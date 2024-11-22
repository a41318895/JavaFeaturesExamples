package java8Features.dateAndTime;

import java.time.LocalTime;

public class LocalTimeExamples {

    public static void main(String[] args) {

        // Creation
        LocalTime now = LocalTime.now() ;

        String timeString = "10:30:00" ;
        LocalTime parsedTime = LocalTime.parse(timeString) ;


        // Adjustment
        LocalTime twoHoursLater = now.plusHours(2) ;
        LocalTime oneMinutesAgo = now.minusMinutes(1) ;
    }
}
