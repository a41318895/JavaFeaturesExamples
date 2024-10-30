package dataOrientedProgramming.customWrapper;

import dataOrientedProgramming.consumeStrategy.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsyncFutureWrapper<V> implements AsyncFuture<V> {

    // Wrap the Future<V> in-built
    private final Future<V> future ;

    public AsyncFutureWrapper(Future<V> future) {

        this.future = future ;
    }

    @Override
    public AsyncReturnResult<V> get() {

        try {

            V result = future.get() ;
            return new SuccessReturnResult<>(result) ;

        } catch (InterruptedException ie) {

            return new InterruptedReturnResult<>() ;

        } catch (ExecutionException ee) {

            return new FailureReturnResult<>(ee) ;
        }
    }

    @Override
    public AsyncReturnResult<V> get(long timeout, TimeUnit unit) {

        try {

            V result = future.get(timeout, unit) ;
            return new SuccessReturnResult<>(result) ;

        } catch (InterruptedException ie) {

            return new InterruptedReturnResult<>() ;

        } catch (ExecutionException ee) {

            return new FailureReturnResult<>(ee) ;

        } catch (TimeoutException te) {

            return new TimeoutReturnResult<>() ;
        }
    }
}
