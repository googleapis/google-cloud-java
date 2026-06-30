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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * The retry executor which uses {@link ScheduledExecutorService} to schedule an attempt tasks.
 *
 * <p>This implementation does not manage the lifecycle of the underlying {@link
 * ScheduledExecutorService}, so it should be managed outside of this class (like calling the {@link
 * ScheduledExecutorService#shutdown()} when the pool is not needed anymore). In a typical usage
 * pattern there are usually multiple instances of this class sharing same instance of the
 * underlying {@link ScheduledExecutorService}.
 *
 * <p>This class is thread-safe.
 *
 * @param <ResponseT> response type
 */
public class ScheduledRetryingExecutor<ResponseT>
    implements RetryingExecutorWithContext<ResponseT> {

  private final RetryAlgorithm<ResponseT> retryAlgorithm;
  private final ListeningScheduledExecutorService scheduler;

  /**
   * Creates a new scheduled retry executor, which will be using {@code scheduler} for actual
   * attempts scheduling and {@code retryAlgorithm} for retrying strategy.
   *
   * @param retryAlgorithm retry algorithm to use
   * @param scheduler scheduler
   */
  public ScheduledRetryingExecutor(
      RetryAlgorithm<ResponseT> retryAlgorithm, ScheduledExecutorService scheduler) {
    this.retryAlgorithm = retryAlgorithm;
    this.scheduler = MoreExecutors.listeningDecorator(scheduler);
  }

  /**
   * Creates a {@link RetryingFuture}, which is a facade, returned to the client code to wait for
   * any retriable operation to complete. The returned future is bounded to {@code this} executor
   * instance.
   *
   * @param callable the actual callable, which should be executed in a retriable context
   * @return retrying future facade
   */
  @Override
  public RetryingFuture<ResponseT> createFuture(Callable<ResponseT> callable) {
    return createFuture(callable, NoopRetryingContext.create());
  }

  /**
   * Creates a {@link RetryingFuture}, which is a facade, returned to the client code to wait for
   * any retriable operation to complete. The returned future is bounded to {@code this} executor
   * instance.
   *
   * @param callable the actual callable, which should be executed in a retriable context
   * @param context the context for this operation
   * @return retrying future facade
   */
  @BetaApi("The surface for passing per operation state is not yet stable")
  @Override
  public RetryingFuture<ResponseT> createFuture(
      Callable<ResponseT> callable, RetryingContext context) {
    return new CallbackChainRetryingFuture<>(callable, retryAlgorithm, this, context);
  }

  /**
   * Submits an attempt for execution in a different thread.
   *
   * @param retryingFuture the future previously returned by {@link #createFuture(Callable,
   *     RetryingContext)}
   * @return submitted attempt future
   */
  @Override
  public ApiFuture<ResponseT> submit(RetryingFuture<ResponseT> retryingFuture) {
    try {
      ListenableFuture<ResponseT> attemptFuture =
          scheduler.schedule(
              retryingFuture.getCallable(),
              retryingFuture.getAttemptSettings().getRandomizedRetryDelayDuration().toMillis(),
              TimeUnit.MILLISECONDS);
      return new ListenableFutureToApiFuture<>(attemptFuture);
    } catch (RejectedExecutionException e) {
      return ApiFutures.immediateFailedFuture(e);
    }
  }
}
