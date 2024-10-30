package dataOrientedProgramming.utils;

import java.util.concurrent.Callable;

import static dataOrientedProgramming.constant.Constants.MILLISECOND_TIME_WILL_TIME_OUT;

public class TasksManagementUtil {

    public static Callable<Integer> normalCalculationTask() {

        return (() -> 5 + 5) ;
    }

    public static Callable<Integer> nullPointerExceptionThrowingTask() {

        return (() -> {

            String str = null ;

            return str.length() ;
        }) ;
    }

    public static Callable<Void> timeoutExceptionThrowingTask() {

        return (() -> {

            Thread.sleep(MILLISECOND_TIME_WILL_TIME_OUT) ;

            return null ;
        }) ;
    }

    public static Callable<Void> interruptedExceptionThrowingTask() {

        return (() -> {

            Thread.sleep(5000) ;

            return null ;
        }) ;
    }
}
