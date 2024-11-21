package java8Features.lambdaAndFunctionalInterface.functionals;

import java8Features.lambdaAndFunctionalInterface.functionals.dataEntity.EnrollValidationResult;
import java8Features.lambdaAndFunctionalInterface.functionals.dataEntity.EnrollmentSheet;

/**
 * Represent a function that accepts an {@link EnrollmentSheet}
 * and return an {@link EnrollValidationResult} which represents validation status
 *
 * <p>This is a functional interface
 * whose functional method is {@link #enrollValidate(EnrollmentSheet)}.
 */
@FunctionalInterface
public interface EnrollValidator {

    EnrollValidationResult enrollValidate(EnrollmentSheet enrollmentSheet) ;
}
