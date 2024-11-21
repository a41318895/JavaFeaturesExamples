package java8Features.methodReferences.objectMethodReference;

/**
 * A Functional Interface to accept two parameters to handle string-relational tasks.
 *
 * @param <StringUtil>
 */
@FunctionalInterface
public interface StringHandler<StringUtil> {

    String handleString(StringUtil str1, String str2) ;
}
