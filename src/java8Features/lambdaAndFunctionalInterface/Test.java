package java8Features.lambdaAndFunctionalInterface;

import java8Features.lambdaAndFunctionalInterface.functionals.EnrollValidator;
import java8Features.lambdaAndFunctionalInterface.functionals.dataEntity.EnrollValidationResult;
import java8Features.lambdaAndFunctionalInterface.functionals.dataEntity.EnrollmentSheet;

import java.util.List;
import java.util.function.*;

import static java8Features.lambdaAndFunctionalInterface.functionals.constants.EnrollValidationConstant.*;

public class Test {

    public static void main(String[] args) {

        // 1. Anonymous Internal Class with Runnable to lambda expression
        // Origin:
        Runnable printHelloRunnable = new Runnable() {

            @Override
            public void run() {

                System.out.println("Hello") ;
            }
        } ;

        // Lambda (No Param):
        Runnable printHelloRunnableLambda = () -> System.out.println("Hello") ;

        printHelloRunnable.run() ;
        printHelloRunnableLambda.run() ;


        // 2. Functional Interface to lambda expression

        // [ Consumer ]: Accept an input, no return value
        Consumer<String> sayHelloToSomeoneConsumer =
                targetName -> System.out.println("Hello " + targetName) ;

        sayHelloToSomeoneConsumer.accept("Bob") ;

        // [ Supplier ]: No accept input, return a value
        Supplier<String> rollDiceTwiceSupplier =
                () -> {

                    StringBuilder sb = new StringBuilder() ;
                    sb.append("[ ") ;
                    for(int i = 0 ; i < 2 ; i ++) {
                        int randomNumber = (int) (Math.random() * 6) + 1;
                        sb.append(randomNumber).append(" ") ;
                    }
                    sb.append("]") ;

                    return sb.toString() ;
                } ;
        System.out.println("Roll Dice Twice Result: " + rollDiceTwiceSupplier.get()) ;

        // [ Function ]: Accept an input, return a value
        Function<String, String> toUpperCaseWithoutTrailingSpacesFunction =
                targetName -> targetName.trim().toUpperCase() ;

        String targetName = " Name " ;
        System.out.println("No Trialing Space Target Name: [" + toUpperCaseWithoutTrailingSpacesFunction.apply(targetName) + "]") ;

        // [ BiFunction ]: Accept two inputs
        BiFunction<String, String, String> combineNamesBiFunction =
                (firstName, lastName) -> firstName + " " + lastName ;

        System.out.println("Full Name: " + combineNamesBiFunction.apply("Aki", "Chou")) ;

        // [ Predicate ]: Accept an input, return a boolean
        Predicate<String> isPhoneNumberValidPredicate =
                phoneNumber -> phoneNumber.length() == 10 ;

        System.out.println("Is phone number valid ?: " + isPhoneNumberValidPredicate.test("0909012345")) ;
        System.out.println("Is phone number valid ?: " + isPhoneNumberValidPredicate.test("09090123456"));


        // 3. Custom Functional Interface to lambda expression

        // Validator Creation
        EnrollValidator collegeEnrollValidator = enrollmentSheet -> {

            int passedNormNumber = 0 ;

            // Need english name
            if (NAME_RULE.validateField(enrollmentSheet)) passedNormNumber ++ ;

            // Need chinese score over than 70
            if (CHINESE_RULE.validateField(enrollmentSheet)) passedNormNumber ++ ;

            // Need english score over than 85
            if (ENGLISH_RULE.validateField(enrollmentSheet)) passedNormNumber ++ ;

            // Need english listening score over than 90
            if (ENGLISH_LISTENING_RULE.validateField(enrollmentSheet)) passedNormNumber ++ ;

            // Need math score over than 70
            if (MATH_RULE.validateField(enrollmentSheet)) passedNormNumber ++ ;

            return new EnrollValidationResult(
                    passedNormNumber >= MIN_PASSED_NORM_NUMBER,
                    passedNormNumber,
                    TOTAL_VALIDATION_NORM_NUMBER - passedNormNumber,
                    TOTAL_VALIDATION_NORM_NUMBER
            ) ;
        } ;

        // Mocking Data
        List<EnrollmentSheet> enrollmentSheets = List.of(
                new EnrollmentSheet("Aki", 80, 80, 92, 60),
                new EnrollmentSheet("鮑勃", 90, 90, 85, 60),
                new EnrollmentSheet("Cindy", 60, 88, 93, 71),
                new EnrollmentSheet("David", 85, 60, 55, 60),
                new EnrollmentSheet("艾瑞克", 50, 66, 91, 73)
        ) ;

        // Validation Process
        for (EnrollmentSheet enrollmentSheet : enrollmentSheets) {

            EnrollValidationResult enrollValidationResult =
                    collegeEnrollValidator.enrollValidate(enrollmentSheet) ;

            String printedResult = String.format("%s's enrollment %s !  [ PASSED NORM: %d, FAILED NORM: %d, TOTAL NORM: %d ]",
                    enrollmentSheet.enrollName(),
                    enrollValidationResult.isValid() ? "passed" : "failed",
                    enrollValidationResult.passedCount(),
                    enrollValidationResult.failedCount(),
                    enrollValidationResult.totalCount()) ;

            System.out.println(printedResult) ;
        }
    }
}
