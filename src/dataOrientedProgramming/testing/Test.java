package dataOrientedProgramming.testing;

import dataOrientedProgramming.consumeStrategy.*;
import dataOrientedProgramming.customWrapper.AsyncFuture;
import dataOrientedProgramming.customWrapper.AsyncFutureWrapper;
import dataOrientedProgramming.utils.TaskResultCollector;
import dataOrientedProgramming.utils.TasksManagementUtil;

import java.util.concurrent.*;

import static dataOrientedProgramming.constant.Constants.TIME_OUT_BORDER_FOR_TASK;

public class Test {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor() ;
        // Handle task results printing
        TaskResultCollector collector = new TaskResultCollector() ;

        executeTaskAsync(
                executorService,
                "Normal Calculation Task",
                TasksManagementUtil.normalCalculationTask(),
                collector) ;

        executeTaskAsync(executorService,
                "NullPointer Exception Throwing Task",
                TasksManagementUtil.nullPointerExceptionThrowingTask(),
                collector) ;

        executeTaskAsync(
                executorService,
                "Timeout Exception Throwing Task",
                TasksManagementUtil.timeoutExceptionThrowingTask(),
                collector) ;

        // Print out the result of executing tasks
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

        // Get the result
        AsyncFuture<V> asyncFuture = new AsyncFutureWrapper<>(future) ;
        AsyncReturnResult<V> result = asyncFuture.get(
                TIME_OUT_BORDER_FOR_TASK,
                TimeUnit.SECONDS
        ) ;

        // Add the result of task completing into collector to wait for printing out
        collector.addResult(taskName, result) ;
    }
}
