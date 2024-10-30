package dataOrientedProgramming.testing;

import dataOrientedProgramming.consumeStrategy.AsyncReturnResult;
import dataOrientedProgramming.customWrapper.AsyncFuture;
import dataOrientedProgramming.customWrapper.AsyncFutureWrapper;
import dataOrientedProgramming.utils.TaskResultCollector;
import dataOrientedProgramming.utils.TasksManagementUtil;

import java.util.concurrent.*;

public class TestForInterrupt {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor() ;
        TaskResultCollector collector = new TaskResultCollector() ;

        executeTaskAsync(
                executorService,
                "Interrupted Exception Throwing Task",
                TasksManagementUtil.interruptedExceptionThrowingTask(),
                collector) ;

        collector.printResults() ;

        executorService.shutdown() ;
    }

    private static <V> void executeTaskAsync(
            ExecutorService executor,
            String taskName,
            Callable<V> task,
            TaskResultCollector collector) {

        // Submit the task
        Future<V> future = executor.submit(task) ;

        // Interrupt the thread
        Thread.currentThread().interrupt() ;

        // Get the result
        AsyncFuture<V> asyncFuture = new AsyncFutureWrapper<>(future) ;
        AsyncReturnResult<V> result = asyncFuture.get() ;

        // Add the result of task completing into collector to wait for printing out
        collector.addResult(taskName, result) ;
    }
}
