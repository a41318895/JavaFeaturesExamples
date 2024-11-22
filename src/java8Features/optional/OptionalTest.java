package java8Features.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {

        // Best practice 1 : Avoid using get() method directly instead of orElse... type method
        Map<Long, String> idAndName = new HashMap<>() ;
        idAndName.put(1L, "Amy") ;
        idAndName.put(2L, "Jonny") ;
        idAndName.put(3L, "Elsa") ;

        // Map.get() will return null. Using orElseThrow() method is the best way to handle it,
        // because it will throw exception when there's no non-null value.
        String targetName = Optional.ofNullable(idAndName.get(3L))
                .orElseThrow(() -> new RuntimeException("No such Name")) ;

        System.out.println("Target name: " + targetName) ;


        // Best practice 2 : Using flatmap() to avoid nesting Optional<Optional<>> result
        String capitalizedNameString = Optional.of("john")
                .flatMap(OptionalTest::capitalizeNameString)
                .orElse("") ;

        System.out.println("Capitalized name: " + capitalizedNameString) ;
    }

    public static Optional<String> capitalizeNameString(String name) {

        return name != null ?
                Optional.of(name.substring(0, 1).toUpperCase() + name.substring(1)) :
                Optional.empty() ;
    }
}
