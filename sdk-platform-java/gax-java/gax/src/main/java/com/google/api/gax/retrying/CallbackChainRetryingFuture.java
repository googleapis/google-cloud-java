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
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * For internal use only.
 *
 * <p>Callback chaining implementation of {@link RetryingFuture} interface. Suitable for retry
 * implementations, when each attempt is scheduled in a specific thread pool (i.e. each attempt may
 * be executed by a different thread).
 *
 * <p>After each attempt, if it is determined as retriable by the retrying algorithm, this
 * implementation schedules a new attempt using the provided retrying executor and assigns a
 * callback to the new scheduled attempt (to examine it result in the future and either accept,
 * reject or repeat the process again).
 *
 * <p>This class is thread-safe.
 */
class CallbackChainRetryingFuture<ResponseT> extends BasicRetryingFuture<ResponseT> {
  private final ScheduledRetryingExecutor<ResponseT> retryingExecutor;
  private volatile AttemptCompletionListener attemptFutureCompletionListener;

  CallbackChainRetryingFuture(
      Callable<ResponseT> callable,
      RetryAlgorithm<ResponseT> retryAlgorithm,
      ScheduledRetryingExecutor<ResponseT> retryingExecutor,
      RetryingContext context) {
    super(callable, retryAlgorithm, context);
    this.retryingExecutor = checkNotNull(retryingExecutor);
  }

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    synchronized (lock) {
      if (attemptFutureCompletionListener == null) {
        // explicit retry future cancellation, most probably even before the first attempt started
        return super.cancel(mayInterruptIfRunning);
      }
      // will result in attempt triggered cancellation of the whole future via callback chain
      attemptFutureCompletionListener.attemptFuture.cancel(mayInterruptIfRunning);
      return isCancelled();
    }
  }

  @Override
  public void setAttemptFuture(ApiFuture<ResponseT> attemptFuture) {
    if (isDone()) {
      return;
    }
    synchronized (lock) {
      if (isDone()) {
        return;
      }
      attemptFutureCompletionListener = new AttemptCompletionListener(attemptFuture);
      // Using direct addListener instead of ApiFutures.addCallback allows greatly reduce
      // layering. Also listener is more suitable here (as we don't really need two methods -
      // one for failure and one for success).
      attemptFuture.addListener(attemptFutureCompletionListener, MoreExecutors.directExecutor());
    }
  }

  @Override
  void clearAttemptServiceData() {
    synchronized (lock) {
      attemptFutureCompletionListener = null;
    }
  }

  private class AttemptCompletionListener implements Runnable {
    private final Future<ResponseT> attemptFuture;

    AttemptCompletionListener(Future<ResponseT> attemptFuture) {
      this.attemptFuture = attemptFuture;
    }

    @Override
    public void run() {
      try {
        ResponseT response = attemptFuture.get();
        handle(null, response);
      } catch (ExecutionException e) {
        handle(e.getCause(), null);
      } catch (Throwable e) {
        handle(e, null);
      }
    }

    private void handle(Throwable t, ResponseT response) {
      // Essential check, to ensure that we do not execute callback of an abandoned attempt.
      // First before the lock, to increase performance and reduce chance of deadlocking
      // (should never happen, but being extra cautious is appropriate here).
      if (this != attemptFutureCompletionListener || isDone()) {
        return;
      }
      synchronized (lock) {
        // same check as before, now under lock
        if (this != attemptFutureCompletionListener || isDone()) {
          return;
        }
        handleAttempt(t, response);
        if (!isDone()) {
          ApiFuture<ResponseT> attempt = retryingExecutor.submit(CallbackChainRetryingFuture.this);
          setAttemptFuture(attempt);
        }
      }
    }
  }
}
