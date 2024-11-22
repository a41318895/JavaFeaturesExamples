package java8Features.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class OperationTest {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Amy", "Cherry", "Evan", "Fiona") ;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9) ;

        // 1. Filter: filter out the data stream which passes the validation
        List<String> collectedNames = names.stream()
                .filter(name -> name.length() > 4)
                .toList() ;

        System.out.println("Names length over 4: " + collectedNames) ;


        // 2. Map: map all elements in data stream, execute specific method to each of them
        List<String> upperCasedNames = names.stream()
                .map(String::toUpperCase)
                .toList() ;

        System.out.println("Upper Cased names: " + upperCasedNames) ;


        // 3. Sorted: execute sorting operation (default ASC)
        List<String> ascendingSortedNames = names.stream()
                .sorted()
                .toList() ;

        System.out.println("Ascending Sorted names: " + ascendingSortedNames) ;

        List<String> descendingSortedNames = names.stream()
                .sorted(Comparator.reverseOrder())
                .toList() ;

        System.out.println("Descending Sorted names: " + descendingSortedNames) ;


        // 4. Reduce: Reduce multiple data to one data

        // 4.1 - one param ( Find maximum for example ) :
        numbers.stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparingInt(x -> x)))
                .ifPresentOrElse(System.out::println, () -> System.out.println("No value")) ;

        // 4.2 - two params ( Multiplication for example ) :
        Integer reducedMultipliedNumber = numbers.stream()
                .reduce(100, (num1, num2) -> num1 * num2) ;

        System.out.println("Reduced Multiplied Number: " + reducedMultipliedNumber) ;

        // 4.3 - three params ( Adding for example ) :
        Integer reducedAddingNumber = numbers.parallelStream()
                .reduce(0, Integer::sum, Integer::sum) ;     // The third param is combiner which
                                                                    // combine results between threads

        System.out.println("Reduced Adding Number: " + reducedAddingNumber) ;


        // 5. AnyMatch: Does any element matches the rule
        boolean isAnyNumberBiggerThan10 = numbers.stream()
                .anyMatch(num -> num > 10) ;

        System.out.println("Is there a number bigger than 10 ? : " + isAnyNumberBiggerThan10) ;


        // 6. Count: count the element number which match the rule set before
        long lessThan6Count = numbers.stream()
                .filter(num -> num < 6)
                .count() ;

        System.out.println("Numbers less than 6 : " + lessThan6Count) ;


        // 7. Infinite Stream: stream which has no end ( use limit() to restrict )
        List<Integer> fibonacci =
                Stream.iterate(
                    new int[]{0, 1},
                    nums -> new int[]{nums[1], nums[0] + nums[1]}
                )
                .limit(10)      // [0, 1], [1, 1], [1, 2], [2, 3], [3, 5], [5, 8] ..... n = 10
                .map(nums -> nums[0])   // pre index 1 -> now index 0
                .toList() ;

        System.out.println("Fibonacci with 10 numbers: " + fibonacci) ;
    }
}
