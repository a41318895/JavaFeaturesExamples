package java8Features.completableFuture;

import java.util.concurrent.ExecutionException;

@FunctionalInterface
public interface ExecutionAndInterruptedExceptionSupplier<T> {

    T get() throws ExecutionException, InterruptedException ;
}
