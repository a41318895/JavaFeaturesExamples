package java8Features.lambdaAndFunctionalInterface.functionals.constants;

import java8Features.lambdaAndFunctionalInterface.functionals.RuleValidator;

public class EnrollValidationConstant {

    public static final int MIN_PASSED_NORM_NUMBER = 3 ;
    public static final int TOTAL_VALIDATION_NORM_NUMBER = 5 ;

    public static final RuleValidator NAME_RULE =
            sheet -> sheet.enrollName().matches("^[a-zA-Z]+$") ;

    public static final RuleValidator CHINESE_RULE =
            sheet -> sheet.chineseScore() > 70 ;

    public static final RuleValidator ENGLISH_RULE =
            sheet -> sheet.englishScore() > 85 ;

    public static final RuleValidator ENGLISH_LISTENING_RULE =
            sheet -> sheet.englishListeningScore() > 90 ;

    public static final RuleValidator MATH_RULE =
            sheet -> sheet.mathScore() > 70 ;
}
