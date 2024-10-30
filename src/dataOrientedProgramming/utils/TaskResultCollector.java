package dataOrientedProgramming.utils;

import dataOrientedProgramming.consumeStrategy.*;

import java.util.ArrayList;
import java.util.List;

import static dataOrientedProgramming.constant.Constants.TIME_OUT_BORDER_FOR_TASK;

public class TaskResultCollector {

    // Record the results of task executing
    private record TaskExecutionResult<V>(

            String taskName,

            AsyncReturnResult<V> result
    ) {}

    private final List<TaskExecutionResult<?>> taskExecutionResults = new ArrayList<>() ;

    // Store a new asyncReturnResult
    public <V> void addResult(String taskName, AsyncReturnResult<V> asyncReturnResult) {

        taskExecutionResults.add(new TaskExecutionResult<>(taskName, asyncReturnResult)) ;
    }

    public void printResults() {

        System.out.println("\n====== Task Execution Results ======\n") ;

        for (TaskExecutionResult<?> result : taskExecutionResults) {

            printTaskResult(result) ;
        }

        System.out.println("=================================\n") ;
    }

    private void printTaskResult(TaskExecutionResult<?> taskResult) {

        System.out.println("Task: " + taskResult.taskName()) ;
        System.out.println("Status: " + getResultStatus(taskResult.result())) ;
        System.out.println("Details: " + getResultDetails(taskResult.result())) ;

        System.out.println() ;
    }

    private String getResultStatus(AsyncReturnResult<?> result) {

        return switch (result) {

            case SuccessReturnResult<?> ignored -> "SUCCESS" ;

            case FailureReturnResult<?> ignored -> "FAILURE" ;

            case TimeoutReturnResult<?> ignored -> "TIMEOUT" ;

            case InterruptedReturnResult<?> ignored -> "INTERRUPTED" ;

        } ;
    }

    private String getResultDetails(AsyncReturnResult<?> result) {

        return switch (result) {

            case SuccessReturnResult<?>(Object value) -> "Result value: " + value ;

            case FailureReturnResult<?>(Throwable throwable) -> "Error message: " + throwable.getMessage() ;

            case TimeoutReturnResult<?> ignored -> "Task exceeded the time limit of " + TIME_OUT_BORDER_FOR_TASK + " seconds" ;

            case InterruptedReturnResult<?> ignored -> "Task was interrupted during execution" ;
        } ;
    }
}
