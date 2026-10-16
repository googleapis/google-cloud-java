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

import static com.google.api.gax.retrying.FailingCallable.FAST_RETRY_SETTINGS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.core.CurrentMillisClock;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class DirectRetryingExecutorTest extends AbstractRetryingExecutorTest {

  @Override
  protected RetryingExecutorWithContext<String> getExecutor(RetryAlgorithm<String> retryAlgorithm) {
    return new DirectRetryingExecutor<>(retryAlgorithm);
  }

  @Override
  protected RetryAlgorithm<String> getAlgorithm(
      RetrySettings retrySettings, int apocalypseCountDown, RuntimeException apocalypseException) {
    return new RetryAlgorithm<>(
        new TestResultRetryAlgorithm<String>(apocalypseCountDown, apocalypseException),
        new ExponentialRetryAlgorithm(retrySettings, CurrentMillisClock.getDefaultClock()));
  }

  /**
   * Runs {@code callable} under an algorithm that retries a {@link SocketTimeoutException} and
   * nothing else, so the test sees which exception the algorithm was given.
   */
  private RetryingFuture<String> runRetryingTimeouts(Callable<String> callable) {
    setUp(false);
    RetryAlgorithm<String> algorithm =
        new RetryAlgorithm<>(
            new BasicResultRetryAlgorithm<String>() {
              @Override
              public boolean shouldRetry(Throwable prevThrowable, String prevResponse) {
                return prevThrowable instanceof SocketTimeoutException;
              }
            },
            new ExponentialRetryAlgorithm(
                FAST_RETRY_SETTINGS, CurrentMillisClock.getDefaultClock()));
    RetryingExecutorWithContext<String> executor = getExecutor(algorithm);
    RetryingFuture<String> future = executor.createFuture(callable, retryingContext);
    future.setAttemptFuture(executor.submit(future));
    return future;
  }

  @Test
  void testSocketTimeoutReachesTheRetryAlgorithm() throws Exception {
    AtomicInteger calls = new AtomicInteger();
    try {
      RetryingFuture<String> future =
          runRetryingTimeouts(
              () -> {
                if (calls.getAndIncrement() == 0) {
                  throw new SocketTimeoutException("Read timed out");
                }
                return "SUCCESS";
              });
      assertFalse(Thread.currentThread().isInterrupted());
      assertEquals("SUCCESS", future.get());
      assertEquals(2, calls.get());
    } finally {
      Thread.interrupted();
    }
  }

  @Test
  void testInterruptedIOExceptionStillFailsAsInterrupted() {
    try {
      RetryingFuture<String> future =
          runRetryingTimeouts(
              () -> {
                throw new InterruptedIOException("interrupted");
              });
      ExecutionException e = assertThrows(ExecutionException.class, future::get);
      assertInstanceOf(InterruptedException.class, e.getCause());
    } finally {
      Thread.interrupted();
    }
  }
}
