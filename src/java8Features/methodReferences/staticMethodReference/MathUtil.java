package java8Features.methodReferences.staticMethodReference;

public final class MathUtil {

    public static boolean isEven(int number) {

        return (number & 1) == 0 ;
    }

    public static boolean isOdd(int number) {

        return (number & 1) == 1 ;
    }
}
