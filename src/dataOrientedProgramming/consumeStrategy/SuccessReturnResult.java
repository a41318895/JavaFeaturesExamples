package dataOrientedProgramming.consumeStrategy;

public record SuccessReturnResult<V>(V result) implements AsyncReturnResult<V> {

}
