package java8Features.dateAndTime;

import java.time.LocalDate;

public class LocalDateExamples {

    public static void main(String[] args) {

        // Creation
        LocalDate today = LocalDate.now() ;

        String dateString = "2024-01-01" ;
        LocalDate parsedDate = LocalDate.parse(dateString) ;


        // Adjustment
        LocalDate tomorrow = today.plusDays(1) ;
        LocalDate oneMonthAgo = today.minusMonths(1) ;


        // Comparison
        LocalDate localDate1 = LocalDate.of(2024, 1, 2) ;
        LocalDate localDate2 = LocalDate.of(2024, 2, 2) ;

        boolean isBefore = localDate1.isBefore(localDate2) ;
        System.out.println("Is localDate1 before localDate2: " + isBefore) ;
    }
}
