package dataOrientedProgramming.consumeStrategy;

sealed public interface AsyncReturnResult<V> permits SuccessReturnResult, FailureReturnResult, TimeoutReturnResult, InterruptedReturnResult {

}
