package dataOrientedProgramming.customWrapper;

import dataOrientedProgramming.consumeStrategy.AsyncReturnResult;

import java.util.concurrent.TimeUnit;

public interface AsyncFuture<V> {

    AsyncReturnResult<V> get() ;

    AsyncReturnResult<V> get(long timeout, TimeUnit unit) ;
}
