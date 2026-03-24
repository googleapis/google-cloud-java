/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.gax.retrying;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.tracing.ApiTracer;
import com.google.common.base.MoreObjects;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * For internal use only.
 *
 * <p>Basic implementation of {@link RetryingFuture} interface. On its own, suitable for usage in
 * 'busy loop' retry implementations. Can be used as the basis for more advanced implementations.
 *
 * <p>This class is thread-safe.
 */
class BasicRetryingFuture<ResponseT> extends AbstractFuture<ResponseT>
    implements RetryingFuture<ResponseT> {

  final Object lock = new Object();

  private final Callable<ResponseT> callable;

  private final RetryAlgorithm<ResponseT> retryAlgorithm;
  private final RetryingContext retryingContext;

  private volatile TimedAttemptSettings attemptSettings;

  private volatile ApiFuture<ResponseT> latestCompletedAttemptResult;
  private volatile ApiFuture<ResponseT> attemptResult;

  private static final Logger LOG = Logger.getLogger(BasicRetryingFuture.class.getName());

  BasicRetryingFuture(
      Callable<ResponseT> callable,
      RetryAlgorithm<ResponseT> retryAlgorithm,
      RetryingContext context) {
    this.callable = checkNotNull(callable);
    this.retryAlgorithm = checkNotNull(retryAlgorithm);
    this.retryingContext = checkNotNull(context);

    this.attemptSettings = retryAlgorithm.createFirstAttempt(context);

    // A micro crime, letting "this" reference to escape from constructor before initialization is
    // completed (via internal non-static class CompletionListener). But it is guaranteed to be ok,
    // since listener is guaranteed to be called only after this future is
    // completed and this future is guaranteed to be completed only after it is initialized. Also
    // since "super" is called explicitly here there are no unexpected overrides of addListener
    // here.
    super.addListener(new CompletionListener(), MoreExecutors.directExecutor());
  }

  @Override
  public void setAttemptFuture(ApiFuture<ResponseT> attemptFuture) {
    try {
      if (isDone()) {
        return;
      }
      ResponseT response = attemptFuture.get();
      handleAttempt(null, response);
    } catch (ExecutionException e) {
      handleAttempt(e.getCause(), null);
    } catch (Throwable e) {
      handleAttempt(e, null);
    }
  }

  @Override
  public Callable<ResponseT> getCallable() {
    return callable;
  }

  @Override
  public TimedAttemptSettings getAttemptSettings() {
    synchronized (lock) {
      return attemptSettings;
    }
  }

  @Override
  public ApiFuture<ResponseT> peekAttemptResult() {
    synchronized (lock) {
      return latestCompletedAttemptResult;
    }
  }

  // Lazily initializes attempt result. This allows to prevent overhead of relatively
  // heavy (and in most cases redundant) settable future instantiation on each attempt, plus reduces
  // possibility of callback chaining going into an infinite loop in case of buggy external
  // callbacks implementation.
  @Override
  public ApiFuture<ResponseT> getAttemptResult() {
    synchronized (lock) {
      if (attemptResult == null) {
        attemptResult = new NonCancellableFuture<>();
      }
      return attemptResult;
    }
  }

  // Called in the beginning of handleAttempt() and completion listeners to cleanup all attempt
  // service data (callbacks and stuff)
  void clearAttemptServiceData() {
    // no-op for the basic implementation
  }

  // "super." is used here to avoid infinite loops of callback chains
  void handleAttempt(Throwable throwable, ResponseT response) {
    ApiTracer tracer = retryingContext.getTracer();

    synchronized (lock) {
      try {
        clearAttemptServiceData();
        if (throwable instanceof CancellationException) {
          // An attempt triggered cancellation.
          // In almost all cases, the operation caller caused the attempt to trigger the
          // cancellation by invoking cancel() on the CallbackChainRetryingFuture, which cancelled
          // the current attempt.
          // In a theoretical scenario, the attempt callable might've thrown the exception on its
          // own volition. However it's currently impossible to disambiguate the 2 scenarios.
          tracer.attemptCancelled();
          super.cancel(false);
        } else if (throwable instanceof RejectedExecutionException) {
          // external executor cannot continue retrying
          tracer.attemptPermanentFailure(throwable);
          super.setException(throwable);
        }
        if (isDone()) {
          return;
        }

        TimedAttemptSettings nextAttemptSettings =
            retryAlgorithm.createNextAttempt(retryingContext, throwable, response, attemptSettings);
        boolean shouldRetry =
            retryAlgorithm.shouldRetry(retryingContext, throwable, response, nextAttemptSettings);
        if (shouldRetry) {
          // Log retry info
          if (LOG.isLoggable(Level.FINEST)) {
            LOG.log(
                Level.FINEST,
                "Retrying with:\n{0}\n{1}\n{2}\n{3}",
                new Object[] {
                  "enclosingMethod: "
                      + (callable.getClass().getEnclosingMethod() != null
                          ? callable.getClass().getEnclosingMethod().getName()
                          : ""),
                  "attemptCount: " + attemptSettings.getAttemptCount(),
                  "delay: " + attemptSettings.getRetryDelayDuration(),
                  "retriableException: " + throwable
                });
          }
          tracer.attemptFailedDuration(
              throwable, nextAttemptSettings.getRandomizedRetryDelayDuration());
          attemptSettings = nextAttemptSettings;
          setAttemptResult(throwable, response, true);
          // a new attempt will be (must be) scheduled by an external executor
        } else if (throwable != null) {
          if (retryAlgorithm.shouldRetryBasedOnResult(retryingContext, throwable, response)) {
            tracer.attemptFailedRetriesExhausted(throwable);
          } else {
            tracer.attemptPermanentFailure(throwable);
          }
          super.setException(throwable);
        } else {
          tracer.attemptSucceeded();
          super.set(response);
        }
      } catch (CancellationException e) {
        // A retry algorithm triggered cancellation.
        tracer.attemptFailedRetriesExhausted(e);
        super.cancel(false);
      } catch (Exception e) {
        // Should never happen, but still possible in case of buggy retry algorithm implementation.
        // Any bugs/exceptions (except CancellationException) in retry algorithms immediately
        // terminate retrying future and set the result to the thrown exception.
        tracer.attemptPermanentFailure(e);
        super.setException(e);
      }
    }
  }

  // Sets attempt result futures. Note the "attempt result future" and "attempt future" are not same
  // things because there are more attempt futures than attempt result futures.
  // See AttemptCallable.call() for an example of such condition.
  //
  // The assignments order in this method is crucial. Wrong ordering may lead to infinite
  // loops in callback chains.
  //
  // If this is not the last attempt this method sets attemptResult to null, so the next
  // getAttemptResult() call will return a new future, tracking the new attempt. Otherwise
  // attemptResult is set to the same result as the one returned by peekAttemptResult(), indicating
  // that the ultimate unmodifiable result of the whole future was reached.
  private void setAttemptResult(Throwable throwable, ResponseT response, boolean shouldRetry) {
    ApiFuture<ResponseT> prevAttemptResult = attemptResult;
    try {
      if (throwable instanceof CancellationException) {
        NonCancellableFuture<ResponseT> future = new NonCancellableFuture<>();
        future.cancelPrivately();
        latestCompletedAttemptResult = future;
        attemptResult = shouldRetry ? null : latestCompletedAttemptResult;
        if (prevAttemptResult instanceof NonCancellableFuture) {
          ((NonCancellableFuture<ResponseT>) prevAttemptResult).cancelPrivately();
        }
      } else if (throwable != null) {
        latestCompletedAttemptResult = ApiFutures.immediateFailedFuture(throwable);
        attemptResult = shouldRetry ? null : latestCompletedAttemptResult;
        if (prevAttemptResult instanceof NonCancellableFuture) {
          ((NonCancellableFuture<ResponseT>) prevAttemptResult).setExceptionPrivately(throwable);
        }
      } else {
        latestCompletedAttemptResult = ApiFutures.immediateFuture(response);
        attemptResult = shouldRetry ? null : latestCompletedAttemptResult;
        if (prevAttemptResult instanceof NonCancellableFuture) {
          ((NonCancellableFuture<ResponseT>) prevAttemptResult).setPrivately(response);
        }
      }
    } catch (Exception e) {
      // Usually should not happen but is still possible, for example if one of the attempt result
      // callbacks throws an exception. An example of such condition is the OperationFuture
      // which uses ApiFutures.transform(), which actually assign callbacks to the attempt result
      // futures, and those can fail, for example if metadata class is a wrong one.
      //
      // The exception is swallowed to avoid buggy callback implementations breaking retrying future
      // execution. In case if a callback is executed in a separate thread executor (the recommended
      // way) the exception will be thrown in a separate thread and will not be swallowed by this
      // catch block anyways.
    }
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this.getClass())
        .add("super", pendingToString())
        .add("latestCompletedAttemptResult", this.latestCompletedAttemptResult)
        .add("attemptResult", this.attemptResult)
        .add("attemptSettings", this.attemptSettings)
        .toString();
  }

  private class CompletionListener implements Runnable {
    @Override
    public void run() {
      synchronized (lock) {
        try {
          clearAttemptServiceData();
          ResponseT response = get();
          setAttemptResult(null, response, false);
        } catch (ExecutionException e) {
          setAttemptResult(e.getCause(), null, false);
        } catch (Throwable e) {
          setAttemptResult(e, null, false);
        }
      }
    }
  }
}
