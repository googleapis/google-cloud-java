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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.core.ApiFuture;
import com.google.api.core.NanoClock;
import com.google.api.gax.retrying.FailingCallable.CustomException;
import com.google.api.gax.rpc.testing.FakeCallContext;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ScheduledRetryingExecutorTest extends AbstractRetryingExecutorTest {

  // Number of test runs, essential for multithreaded tests.
  private static final int EXECUTIONS_COUNT = 5;

  @Override
  protected RetryingExecutorWithContext<String> getExecutor(RetryAlgorithm<String> retryAlgorithm) {
    return getRetryingExecutor(retryAlgorithm, scheduledExecutorService);
  }

  @Override
  protected RetryAlgorithm<String> getAlgorithm(
      RetrySettings retrySettings, int apocalypseCountDown, RuntimeException apocalypseException) {
    return new RetryAlgorithm<>(
        new TestResultRetryAlgorithm<String>(apocalypseCountDown, apocalypseException),
        new ExponentialRetryAlgorithm(retrySettings, NanoClock.getDefaultClock()));
  }

  private RetryingExecutorWithContext<String> getRetryingExecutor(
      RetryAlgorithm<String> retryAlgorithm, ScheduledExecutorService scheduler) {
    return new ScheduledRetryingExecutor<>(retryAlgorithm, scheduler);
  }

  @Test
  void testSuccessWithFailuresPeekAttempt() throws Exception {
    RetrySettings retrySettings =
        FAST_RETRY_SETTINGS.toBuilder()
            .setTotalTimeoutDuration(java.time.Duration.ofMillis(1000L))
            .setMaxAttempts(100)
            .build();
    for (int executionsCount = 0; executionsCount < EXECUTIONS_COUNT; executionsCount++) {

      FailingCallable callable = new FailingCallable(15, "request", "SUCCESS", tracer);

      RetryingExecutorWithContext<String> executor =
          getRetryingExecutor(getAlgorithm(retrySettings, 0, null), scheduledExecutorService);
      RetryingFuture<String> future =
          executor.createFuture(
              callable,
              FakeCallContext.createDefault().withTracer(tracer).withRetrySettings(retrySettings));
      callable.setExternalFuture(future);

      assertNull(future.peekAttemptResult());
      assertSame(future.peekAttemptResult(), future.peekAttemptResult());
      assertFalse(future.getAttemptResult().isDone());
      assertFalse(future.getAttemptResult().isCancelled());

      future.setAttemptFuture(executor.submit(future));

      int failedAttempts = 0;
      while (!future.isDone()) {
        ApiFuture<String> attemptResult = future.peekAttemptResult();
        if (attemptResult != null) {
          assertTrue(attemptResult.isDone());
          assertFalse(attemptResult.isCancelled());
          try {
            attemptResult.get();
          } catch (ExecutionException e) {
            if (e.getCause() instanceof CustomException) {
              failedAttempts++;
            }
          }
        }
        Thread.sleep(0L, 100);
      }

      assertFutureSuccess(future);
      assertEquals(15, future.getAttemptSettings().getAttemptCount());
      assertTrue(failedAttempts > 0);
    }
  }

  @Test
  void testSuccessWithFailuresGetAttempt() throws Exception {
    int maxRetries = 100;
    RetrySettings retrySettings =
        FAST_RETRY_SETTINGS.toBuilder()
            .setTotalTimeoutDuration(java.time.Duration.ofMillis(1000L))
            .setMaxAttempts(maxRetries)
            .build();
    for (int executionsCount = 0; executionsCount < EXECUTIONS_COUNT; executionsCount++) {

      FailingCallable callable = new FailingCallable(15, "request", "SUCCESS", tracer);

      RetryingExecutorWithContext<String> executor =
          getRetryingExecutor(getAlgorithm(retrySettings, 0, null), scheduledExecutorService);
      RetryingFuture<String> future =
          executor.createFuture(
              callable,
              FakeCallContext.createDefault().withTracer(tracer).withRetrySettings(retrySettings));
      callable.setExternalFuture(future);

      assertNull(future.peekAttemptResult());
      assertSame(future.getAttemptResult(), future.getAttemptResult());
      assertFalse(future.getAttemptResult().isDone());
      assertFalse(future.getAttemptResult().isCancelled());

      future.setAttemptFuture(executor.submit(future));

      CustomException exception;
      int checks = 0;
      do {
        exception = null;
        checks++;
        Future<String> attemptResult = future.getAttemptResult();
        try {
          // testing that the gotten attempt result is non-cancelable
          assertFalse(attemptResult.cancel(false));
          assertFalse(attemptResult.cancel(true));
          attemptResult.get();
          assertNotNull(future.peekAttemptResult());
        } catch (ExecutionException e) {
          exception = (CustomException) e.getCause();
        }
        assertTrue(attemptResult.isDone());
        assertFalse(attemptResult.isCancelled());
      } while (exception != null && checks < maxRetries + 1);

      assertTrue(future.isDone());
      assertFutureSuccess(future);
      assertEquals(15, future.getAttemptSettings().getAttemptCount());
      assertTrue(checks > 1 && checks <= maxRetries, "checks is equal to " + checks);
    }
  }

  @Test
  void testCancelGetAttempt() throws Exception {
    int maxRetries = 100;
    RetrySettings retrySettings =
        FAST_RETRY_SETTINGS.toBuilder()
            .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(50L))
            .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(50L))
            .setTotalTimeoutDuration(java.time.Duration.ofMillis(5000L))
            .setMaxAttempts(maxRetries)
            .build();
    FailingCallable callable = new FailingCallable(maxRetries - 1, "request", "SUCCESS", tracer);

    RetryingExecutorWithContext<String> executor =
        getRetryingExecutor(getAlgorithm(retrySettings, 0, null), scheduledExecutorService);
    RetryingFuture<String> future =
        executor.createFuture(
            callable,
            FakeCallContext.createDefault().withTracer(tracer).withRetrySettings(retrySettings));
    callable.setExternalFuture(future);

    assertNull(future.peekAttemptResult());
    assertSame(future.getAttemptResult(), future.getAttemptResult());
    assertFalse(future.getAttemptResult().isDone());
    assertFalse(future.getAttemptResult().isCancelled());

    future.setAttemptFuture(executor.submit(future));

    CustomException exception;
    CancellationException cancellationException = null;
    int checks = 0;
    do {
      exception = null;
      checks++;
      Future<String> attemptResult = future.getAttemptResult();
      try {
        attemptResult.get();
        assertNotNull(future.peekAttemptResult());
      } catch (CancellationException e) {
        cancellationException = e;
      } catch (ExecutionException e) {
        exception = (CustomException) e.getCause();
      }
      future.cancel(true);
      assertTrue(attemptResult.isDone());
    } while (exception != null && checks < maxRetries);

    assertTrue(future.isDone());
    assertNotNull(cancellationException);
    assertTrue(future.getAttemptSettings().getAttemptCount() > 0);
    assertFutureCancel(future);
  }

  @Test
  void testCancelOuterFutureAfterStart() throws Exception {
    RetrySettings retrySettings =
        FAST_RETRY_SETTINGS.toBuilder()
            // These params were selected to ensure that future tries to run and fail (at least
            // once) but does not complete before it is cancelled. Assuming no computation time,
            // it would take 2500 + 10000 + 10000 + 10000 = 32500ms for the future to complete,
            // which should
            // be more than enough time to cancel the future.
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(2500L))
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(10000L))
            .setRetryDelayMultiplier(4.0)
            .setTotalTimeoutDuration(java.time.Duration.ofMillis(60000L))
            // Set this test to not use jitter as the randomized retry delay (RRD) may introduce
            // flaky results. For example, if every RRD value is calculated to be a small value
            // (i.e. 2ms), four retries would result a "SUCCESS" result after 8ms, far below
            // both the sleep value (150ms) and timeout (60000ms). This could potentially result
            // in the future.cancel() returning false as you can't cancel a future that has
            // already succeeded. The possibility of having each of the four retries produce a
            // tiny RRD value is small, but not impossible.
            .setJittered(false)
            .build();
    for (int executionsCount = 0; executionsCount < EXECUTIONS_COUNT; executionsCount++) {
      FailingCallable callable = new FailingCallable(4, "request", "SUCCESS", tracer);
      RetryingExecutorWithContext<String> executor =
          getRetryingExecutor(getAlgorithm(retrySettings, 0, null), scheduledExecutorService);
      RetryingFuture<String> future =
          executor.createFuture(
              callable,
              FakeCallContext.createDefault().withTracer(tracer).withRetrySettings(retrySettings));
      callable.setExternalFuture(future);
      future.setAttemptFuture(executor.submit(future));

      // The test sleeps a duration long enough to ensure that the future has been submitted for
      // execution
      Thread.sleep(150L);

      boolean res = future.cancel(false);
      assertTrue(res);
      assertFutureCancel(future);

      // Verify that the cancelled future is traced. Every attempt increases the number
      // of cancellation attempts from the tracer.
      Mockito.verify(tracer, Mockito.times(executionsCount + 1)).attemptCancelled();

      // Assert that future has at least been attempted once
      // i.e. The future from executor.submit() has been run by the ScheduledExecutor
      assertTrue(future.getAttemptSettings().getAttemptCount() > 0);
      assertTrue(future.getAttemptSettings().getAttemptCount() < 4);
    }
  }

  @Test
  void testCancelProxiedFutureAfterStart() throws Exception {
    RetrySettings retrySettings =
        FAST_RETRY_SETTINGS.toBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(1_000L))
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(1_000L))
            .setTotalTimeoutDuration(java.time.Duration.ofMillis(10_0000L))
            .build();
    // this is a heavy test, which takes a lot of time, so only few executions.
    for (int executionsCount = 0; executionsCount < 2; executionsCount++) {
      // Use a test local executor for this test case due to the reasons listed below
      ScheduledExecutorService localExecutor = Executors.newSingleThreadScheduledExecutor();
      FailingCallable callable = new FailingCallable(5, "request", "SUCCESS", tracer);

      RetryingExecutorWithContext<String> executor =
          getRetryingExecutor(getAlgorithm(retrySettings, 0, null), localExecutor);
      RetryingFuture<String> future =
          executor.createFuture(
              callable,
              FakeCallContext.createDefault().withTracer(tracer).withRetrySettings(retrySettings));
      callable.setExternalFuture(future);
      future.setAttemptFuture(executor.submit(future));

      Thread.sleep(50L);

      // Note that shutdownNow() will not cancel internal FutureTasks automatically, which
      // may potentially cause another thread handing on RetryingFuture#get() call forever.
      // Canceling the tasks returned by shutdownNow() also does not help, because of missing
      // feature in guava's ListenableScheduledFuture, which does not cancel itself, when its
      // delegate is
      // canceled.
      // So only the graceful shutdown() is supported properly.
      localExecutor.shutdown();

      assertFutureFail(future, RejectedExecutionException.class);
      localExecutor.shutdownNow();
    }
  }
}
