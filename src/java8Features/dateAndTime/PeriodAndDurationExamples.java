package java8Features.dateAndTime;

import java.time.*;

public class PeriodAndDurationExamples {

    public static void main(String[] args) {

        // Period: calculate between date

        LocalDate startDate = LocalDate.of(2024, 1, 1) ;
        LocalDate endDate = LocalDate.of(2024, 5, 31) ;

        Period period = Period.between(startDate, endDate) ;
        System.out.println(period.getMonths() + " Months") ;


        // Duration: calculate between time

        LocalTime startTime = LocalTime.of(12, 30, 0) ;
        LocalTime endTime = LocalTime.of(14, 50, 30) ;

        Duration duration = Duration.between(startTime, endTime) ;
        System.out.println(duration.toMinutes() + " Minutes") ;
    }
}
