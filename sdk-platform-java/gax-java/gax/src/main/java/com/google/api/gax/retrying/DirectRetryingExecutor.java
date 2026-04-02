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
import java.io.InterruptedIOException;
import java.nio.channels.ClosedByInterruptException;
import java.util.concurrent.Callable;

/**
 * The retry executor which executes attempts in the current thread, potentially causing the current
 * thread to sleep for the specified amount of time before execution.
 *
 * <p>This class is thread-safe.
 *
 * @param <ResponseT> response type
 */
public class DirectRetryingExecutor<ResponseT> implements RetryingExecutorWithContext<ResponseT> {

  private final RetryAlgorithm<ResponseT> retryAlgorithm;

  /**
   * Creates a new direct retrying executor instance, which will be using {@code retryAlgorithm} to
   * determine retrying strategy.
   *
   * @param retryAlgorithm retry algorithm to use for attempts execution
   * @throws NullPointerException if {@code retryAlgorithm} is null
   */
  public DirectRetryingExecutor(RetryAlgorithm<ResponseT> retryAlgorithm) {
    this.retryAlgorithm = checkNotNull(retryAlgorithm);
  }

  /**
   * Creates a {@link RetryingFuture}, which is a facade, returned to the client code to wait for
   * any retriable operation to complete. The future is bounded to {@code this} executor instance.
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
   * any retriable operation to complete. The future is bounded to {@code this} executor instance.
   *
   * @param callable the actual callable, which should be executed in a retriable context
   * @return retrying future facade
   */
  @Override
  public RetryingFuture<ResponseT> createFuture(
      Callable<ResponseT> callable, RetryingContext context) {
    return new BasicRetryingFuture<>(callable, retryAlgorithm, context);
  }

  /**
   * Submits an attempt for execution in the current thread, causing the current thread to sleep for
   * the specified by the {@link RetryingFuture#getAttemptSettings()} amount of time. As result,
   * this method completes execution only after the specified {@code retryingFuture} completes.
   *
   * @param retryingFuture the future previously returned by {@link #createFuture(Callable,
   *     RetryingContext)}
   * @return returns completed {@code retryingFuture}
   */
  @Override
  public ApiFuture<ResponseT> submit(RetryingFuture<ResponseT> retryingFuture) {
    while (!retryingFuture.isDone()) {
      try {
        sleep(retryingFuture.getAttemptSettings().getRandomizedRetryDelayDuration());
        ResponseT response = retryingFuture.getCallable().call();
        retryingFuture.setAttemptFuture(ApiFutures.immediateFuture(response));
      } catch (InterruptedException | InterruptedIOException | ClosedByInterruptException e) {
        Thread.currentThread().interrupt();
        retryingFuture.setAttemptFuture(ApiFutures.<ResponseT>immediateFailedFuture(e));
      } catch (Exception e) {
        retryingFuture.setAttemptFuture(ApiFutures.<ResponseT>immediateFailedFuture(e));
      }
    }
    return retryingFuture;
  }

  /**
   * This method simply calls {@link Thread#sleep(long)}.
   *
   * @param delay time to sleep
   * @throws InterruptedException if any thread has interrupted the current thread
   */
  protected void sleep(java.time.Duration delay) throws InterruptedException {
    if (java.time.Duration.ZERO.compareTo(delay) < 0) {
      Thread.sleep(delay.toMillis());
    }
  }
}
