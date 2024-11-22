package java8Features.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {

    public static void main(String[] args) {

        // 1. Apply and Combine
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {

            try {

                Thread.sleep(2000);

            } catch (Exception e) {

                System.out.println(e.getMessage());
            }

            return "Hello";
        }) ;
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Combine") ;

        CompletableFuture<String> futureApplied = future.thenApply(str -> str + " Apply") ;
        CompletableFuture<String> futureCombined = future.thenCombine(future2, (str1, str2) -> str1 + " " + str2) ;

        // get() method blocks util the async task finished
        System.out.println(execute(() -> futureApplied.get())) ;
        System.out.println(execute(() -> futureCombined.get())) ;


        // 2. Exception Handling
        CompletableFuture<String> isEqualsFuture =
                CompletableFuture.supplyAsync(() -> {

                    if (1 != 2) throw new RuntimeException("Not Equals Exception") ;

                    return "Equals" ;

                }).exceptionally(ex -> {

                    System.out.println(ex.getMessage()) ;

                    return "Not Equals" ;
                }) ;

        System.out.println(execute(() -> isEqualsFuture.get())) ;


        // 3. Parallel execute multiple tasks
        CompletableFuture<String> task1Future = CompletableFuture.supplyAsync(() -> "Task 1") ;
        CompletableFuture<String> task2Future = CompletableFuture.supplyAsync(() -> {
            doSleep() ;
            return "Task 2" ;
        }) ;
        CompletableFuture<String> task3Future = CompletableFuture.supplyAsync(() -> {
            doSleep() ;
            return "Task 3" ;
        }) ;
        CompletableFuture<String> task4Future = CompletableFuture.supplyAsync(() -> {
            doSleep() ;
            return "Task 4" ;
        }) ;

        // Wait for all tasks being finished
        CompletableFuture.allOf(task1Future, task2Future, task3Future, task4Future).join() ;

        // Catch the first-finished task
        CompletableFuture<Object> firstFinishedFuture = CompletableFuture.anyOf(task1Future, task2Future, task3Future, task4Future) ;
        System.out.println(execute(() -> firstFinishedFuture.get())) ;      // should be "Task 1"
    }

    // To handle exception throwing declaration at every method
    private static <T> T execute(ExecutionAndInterruptedExceptionSupplier<T> supplier) {

        try {

            return supplier.get() ;

        } catch (ExecutionException | InterruptedException e) {

            System.out.println(e.getMessage()) ;

            throw new RuntimeException(e) ;
        }
    }

    private static void doSleep() {

        try {

            Thread.sleep(1000) ;
        } catch (Exception e) {

            System.out.println(e.getMessage()) ;
        }
    }
}
