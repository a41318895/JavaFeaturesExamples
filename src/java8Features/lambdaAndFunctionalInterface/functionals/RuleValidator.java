package java8Features.lambdaAndFunctionalInterface.functionals;

import java8Features.lambdaAndFunctionalInterface.functionals.dataEntity.EnrollmentSheet;

/**
 * Represent a function that accepts an {@link EnrollmentSheet}
 * to validate a specific field with a specific rule.
 *
 * <p>This is a functional interface
 * whose functional method is {@link #validateField(EnrollmentSheet)}.
 */
@FunctionalInterface
public interface RuleValidator {

    boolean validateField(EnrollmentSheet sheet) ;
}
