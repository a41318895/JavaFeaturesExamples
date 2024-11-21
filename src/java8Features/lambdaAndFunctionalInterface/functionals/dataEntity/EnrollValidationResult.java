package java8Features.lambdaAndFunctionalInterface.functionals.dataEntity;

public record EnrollValidationResult(boolean isValid,
                                     int passedCount,
                                     int failedCount,
                                     int totalCount) {
}
