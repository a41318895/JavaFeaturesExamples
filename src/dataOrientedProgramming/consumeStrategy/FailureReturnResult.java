package dataOrientedProgramming.consumeStrategy;

public record FailureReturnResult<V>(Throwable throwable) implements AsyncReturnResult<V> {

}
