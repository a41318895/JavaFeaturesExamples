package java8Features.methodReferences;

import java8Features.methodReferences.instanceMethodReference.Animal;
import java8Features.methodReferences.instanceMethodReference.Cat;
import java8Features.methodReferences.instanceMethodReference.Dog;
import java8Features.methodReferences.objectMethodReference.StringUtil;
import java8Features.methodReferences.staticMethodReference.MathUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test {

    public static void main(String[] args) {

        // 1. Static Method Reference: [ ClassName::StaticMethodName ]
        Function<Integer, Boolean> isEvenSupplier = MathUtil::isEven ;
        Function<Integer, Boolean> isOddSupplier = MathUtil::isOdd ;

        System.out.println(isOddSupplier.apply(2)) ;
        System.out.println(isOddSupplier.apply(3)) ;
        System.out.println(isEvenSupplier.apply(2)) ;
        System.out.println(isEvenSupplier.apply(3)) ;


        // 2. Instance Method Reference: [ InstanceName::MethodName ]
        Animal cat = new Cat() ;
        Animal dog = new Dog() ;

        Supplier<String> catSoundSupplier = cat::makeSound ;
        Supplier<String> dogSoundSupplier = dog::makeSound ;

        System.out.println("Cat: " + catSoundSupplier.get()) ;
        System.out.println("Dog: " + dogSoundSupplier.get()) ;


        // 3. Object Method Reference: [ ClassName::MethodName ]

        // Set instance status parameter 1st
        StringUtil stringUtil = new StringUtil("Hello") ;

        String concatenatedResult = stringUtil.doHandleString(StringUtil::concat, "World") ;
        System.out.println("Concatenate Result: " + concatenatedResult) ;

        String upperCasedResult = stringUtil.doHandleString(StringUtil::toUpperCase, "world") ;
        System.out.println("Uppercase Result: " + upperCasedResult) ;

        String reversedResult = stringUtil.doHandleString(StringUtil::reverse, "World") ;
        System.out.println("Reversed Result: " + reversedResult) ;


        // 4. Constructor Method Reference: [ ClassName::new ]
        Supplier<List<String>> stringListSupplier = ArrayList::new ;

        List<String> stringList = stringListSupplier.get() ;
        stringList.add("first str") ;

        System.out.println(stringList) ;
    }
}