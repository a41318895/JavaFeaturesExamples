package java8Features.dateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExamples {

    // Formatter for localTime to erase SSS
    private final static DateTimeFormatter FORMATTER_TIME = DateTimeFormatter.ofPattern("HH:mm:ss") ;
    private final static DateTimeFormatter FORMATTER_DATE_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") ;

    public static void main(String[] args) {

        // 1. Creation
        LocalDateTime now = LocalDateTime.now() ;


        // 2. Transfer to LocalDate / LocalTime
        LocalDate localDateNow = now.toLocalDate() ;
        System.out.println(localDateNow) ;

        LocalTime localTimeNow = now.toLocalTime() ;
        System.out.println(localTimeNow.format(FORMATTER_TIME)) ;


        // 3. Adjustment
        LocalDateTime fiveHoursAgoDateTime = now.minusHours(5) ;
        System.out.println(fiveHoursAgoDateTime.format(FORMATTER_DATE_TIME)) ;
    }
}
