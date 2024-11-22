package java8Features.dateAndTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeExamples {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss O") ;

    public static void main(String[] args) {

        // Creation ( Zone : Japan )
        ZoneId japanZoneId = ZoneId.of("GMT+9") ;
        ZonedDateTime japanTimeNow = ZonedDateTime.now(japanZoneId) ;

        System.out.println(japanTimeNow.format(FORMATTER)) ;    // 2024-xx-xx xx:xx:xx GMT+9


        // Time Zone Transfer
        ZoneId taipeiZoneId = ZoneId.of("Asia/Taipei") ;
        ZonedDateTime taipeiTimeNow =
                japanTimeNow.withZoneSameInstant(taipeiZoneId) ;

        System.out.println(taipeiTimeNow.format(FORMATTER)) ;
    }
}
