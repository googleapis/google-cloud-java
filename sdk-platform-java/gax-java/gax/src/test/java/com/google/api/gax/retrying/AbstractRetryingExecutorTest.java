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

import static com.google.api.gax.retrying.FailingCallable.FAILING_RETRY_SETTINGS;
import static com.google.api.gax.retrying.FailingCallable.FAST_RETRY_SETTINGS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.google.api.core.ApiFuture;
import com.google.api.core.NanoClock;
import com.google.api.gax.retrying.FailingCallable.CustomException;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.tracing.ApiTracer;
import com.google.common.base.Stopwatch;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public abstract class AbstractRetryingExecutorTest {

  private static final int DEFAULT_AWAIT_TERMINATION_SEC = 10;

  // This is the default executor service for RetryingExecutor tests unless
  // a local executor is specifically used
  ScheduledExecutorService scheduledExecutorService;

  @BeforeEach
  void setup() {
    scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
  }

  @AfterEach
  void cleanup() throws InterruptedException {
    scheduledExecutorService.shutdownNow();
    scheduledExecutorService.awaitTermination(DEFAULT_AWAIT_TERMINATION_SEC, TimeUnit.SECONDS);
  }

  public static Stream<Arguments> data() {
    return Stream.of(Arguments.of(false), Arguments.of(true));
  }

  @Mock protected ApiTracer tracer;
  protected RetryingContext retryingContext;

  protected abstract RetryingExecutorWithContext<String> getExecutor(
      RetryAlgorithm<String> retryAlgorithm);

  protected abstract RetryAlgorithm<String> getAlgorithm(
      RetrySettings retrySettings, int apocalypseCountDown, RuntimeException apocalypseException);

  protected <T> void busyWaitForInitialResult(RetryingFuture<T> future, java.time.Duration timeout)
      throws TimeoutException {
    Stopwatch watch = Stopwatch.createStarted();
    while (future.peekAttemptResult() == null) {
      if (watch.elapsed(TimeUnit.NANOSECONDS) > timeout.toNanos()) {
        throw new TimeoutException();
      }
    }
  }

  void setUp(boolean withCustomRetrySettings) {
    if (withCustomRetrySettings) {
      retryingContext =
          FakeCallContext.createDefault().withTracer(tracer).withRetrySettings(FAST_RETRY_SETTINGS);
    } else {
      retryingContext = FakeCallContext.createDefault().withTracer(tracer);
    }
  }

  @ParameterizedTest
  @MethodSource("data")
  void testSuccess(boolean withCustomRetrySettings) throws Exception {
    setUp(withCustomRetrySettings);
    FailingCallable callable = new FailingCallable(0, "request", "SUCCESS", tracer);
    RetryingExecutorWithContext<String> executor =
        getExecutor(
            getAlgorithm(
                withCustomRetrySettings ? FAILING_RETRY_SETTINGS : FAST_RETRY_SETTINGS, 0, null));
    RetryingFuture<String> future = executor.createFuture(callable, retryingContext);
    callable.setExternalFuture(future);
    future.setAttemptFuture(executor.submit(future));

    assertFutureSuccess(future);
    assertEquals(0, future.getAttemptSettings().getAttemptCount());

    verify(tracer, times(1)).attemptStarted(eq("request"), eq(0));
    verify(tracer, times(1)).attemptSucceeded();
    verifyNoMoreInteractions(tracer);
  }

  @ParameterizedTest
  @MethodSource("data")
  void testSuccessWithFailures(boolean withCustomRetrySettings) throws Exception {
    setUp(withCustomRetrySettings);
    FailingCallable callable = new FailingCallable(5, "request", "SUCCESS", tracer);
    RetryingExecutorWithContext<String> executor =
        getExecutor(
            getAlgorithm(
                withCustomRetrySettings ? FAILING_RETRY_SETTINGS : FAST_RETRY_SETTINGS, 0, null));
    RetryingFuture<String> future = executor.createFuture(callable, retryingContext);
    callable.setExternalFuture(future);
    future.setAttemptFuture(executor.submit(future));

    assertFutureSuccess(future);
    assertEquals(5, future.getAttemptSettings().getAttemptCount());

    verify(tracer, times(6)).attemptStarted(eq("request"), anyInt());
    verify(tracer, times(5))
        .attemptFailedDuration(any(Throwable.class), any(java.time.Duration.class));
    verify(tracer, times(1)).attemptSucceeded();
    verifyNoMoreInteractions(tracer);
  }

  @ParameterizedTest
  @MethodSource("data")
  void testSuccessWithFailuresPeekGetAttempt(boolean withCustomRetrySettings) throws Exception {
    setUp(withCustomRetrySettings);
    FailingCallable callable = new FailingCallable(5, "request", "SUCCESS", tracer);
    RetryingExecutorWithContext<String> executor =
        getExecutor(
            getAlgorithm(
                withCustomRetrySettings ? FAILING_RETRY_SETTINGS : FAST_RETRY_SETTINGS, 0, null));
    RetryingFuture<String> future = executor.createFuture(callable, retryingContext);
    callable.setExternalFuture(future);

    assertNull(future.peekAttemptResult());
    assertSame(future.peekAttemptResult(), future.peekAttemptResult());
    assertFalse(future.getAttemptResult().isDone());
    assertFalse(future.getAttemptResult().isCancelled());

    Exception exception = null;
    try {
      future.get(1L, TimeUnit.MILLISECONDS);
    } catch (TimeoutException e) {
      exception = e;
    }
    assertNotNull(exception);

    future.setAttemptFuture(executor.submit(future));

    assertFutureSuccess(future);
    assertEquals(5, future.getAttemptSettings().getAttemptCount());
  }

  @ParameterizedTest
  @MethodSource("data")
  void testMaxRetriesExceeded(boolean withCustomRetrySettings) throws Exception {
    setUp(withCustomRetrySettings);
    FailingCallable callable = new FailingCallable(6, "request", "FAILURE", tracer);
    RetryingExecutorWithContext<String> executor =
        getExecutor(
            getAlgorithm(
                withCustomRetrySettings ? FAILING_RETRY_SETTINGS : FAST_RETRY_SETTINGS, 0, null));
    RetryingFuture<String> future = executor.createFuture(callable, retryingContext);
    callable.setExternalFuture(future);
    future.setAttemptFuture(executor.submit(future));

    assertFutureFail(future, CustomException.class);
    assertEquals(5, future.getAttemptSettings().getAttemptCount());

    verify(tracer, times(6)).attemptStarted(eq("request"), anyInt());
    verify(tracer, times(5))
        .attemptFailedDuration(any(Throwable.class), any(java.time.Duration.class));
    verify(tracer, times(1)).attemptFailedRetriesExhausted(any(Throwable.class));
    verifyNoMoreInteractions(tracer);
  }

  @ParameterizedTest
  @MethodSource("data")
  void testTotalTimeoutExceeded(boolean withCustomRetrySettings) throws Exception {
    setUp(withCustomRetrySettings);
    RetrySettings retrySettings =
        FAST_RETRY_SETTINGS.toBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(Integer.MAX_VALUE))
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(Integer.MAX_VALUE))
            .build();
    boolean useContextRetrySettings = retryingContext.getRetrySettings() != null;
    RetryingExecutorWithContext<String> executor =
        getExecutor(
            getAlgorithm(
                useContextRetrySettings
                    ? withCustomRetrySettings ? FAILING_RETRY_SETTINGS : FAST_RETRY_SETTINGS
                    : retrySettings,
                0,
                null));
    FailingCallable callable = new FailingCallable(6, "request", "FAILURE", tracer);
    RetryingContext context;
    if (useContextRetrySettings) {
      context = FakeCallContext.createDefault().withTracer(tracer).withRetrySettings(retrySettings);
    } else {
      context = FakeCallContext.createDefault().withTracer(tracer);
    }
    RetryingFuture<String> future = executor.createFuture(callable, context);
    callable.setExternalFuture(future);
    future.setAttemptFuture(executor.submit(future));

    assertFutureFail(future, CustomException.class);
    assertTrue(future.getAttemptSettings().getAttemptCount() < 4);

    verify(tracer, times(1)).attemptStarted(eq("request"), anyInt());
    verify(tracer, times(1)).attemptFailedRetriesExhausted(any(Throwable.class));
    verifyNoMoreInteractions(tracer);
  }

  @ParameterizedTest
  @MethodSource("data")
  void testCancelOuterFutureBeforeStart(boolean withCustomRetrySettings) {
    setUp(withCustomRetrySettings);
    FailingCallable callable = new FailingCallable(0, "request", "FAILURE", tracer);

    RetrySettings retrySettings =
        FAST_RETRY_SETTINGS.toBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(1_000L))
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(1_000L))
            .setTotalTimeoutDuration(java.time.Duration.ofMillis(10_000L))
            .build();
    RetryingExecutorWithContext<String> executor =
        getExecutor(getAlgorithm(retrySettings, 0, null));
    RetryingFuture<String> future = executor.createFuture(callable, retryingContext);
    callable.setExternalFuture(future);
    boolean res = future.cancel(false);
    assertTrue(res);
    assertTrue(future.isCancelled());

    future.setAttemptFuture(executor.submit(future));
    assertEquals(0, future.getAttemptSettings().getAttemptCount());

    // Tracer should have 0 interactions as the externalFuture has already been cancelled
    // FailingCallable should exit immediately and no tracer logic should be invoked
    verifyNoMoreInteractions(tracer);
  }

  @ParameterizedTest
  @MethodSource("data")
  void testCancelByRetryingAlgorithm(boolean withCustomRetrySettings) throws Exception {
    setUp(withCustomRetrySettings);
    FailingCallable callable = new FailingCallable(6, "request", "FAILURE", tracer);
    RetryingExecutorWithContext<String> executor =
        getExecutor(
            getAlgorithm(
                withCustomRetrySettings ? FAILING_RETRY_SETTINGS : FAST_RETRY_SETTINGS,
                5,
                new CancellationException()));
    RetryingFuture<String> future = executor.createFuture(callable, retryingContext);
    callable.setExternalFuture(future);
    future.setAttemptFuture(executor.submit(future));

    assertFutureCancel(future);
    assertEquals(4, future.getAttemptSettings().getAttemptCount());

    verify(tracer, times(5)).attemptStarted(eq("request"), anyInt());
    // Pre-apocalypse failures
    verify(tracer, times(4))
        .attemptFailedDuration(any(Throwable.class), any(java.time.Duration.class));
    // Apocalypse failure
    verify(tracer, times(1)).attemptFailedRetriesExhausted(any(CancellationException.class));
    verifyNoMoreInteractions(tracer);
  }

  @ParameterizedTest
  @MethodSource("data")
  void testUnexpectedExceptionFromRetryAlgorithm(boolean withCustomRetrySettings) throws Exception {
    setUp(withCustomRetrySettings);
    FailingCallable callable = new FailingCallable(6, "request", "FAILURE", tracer);
    RetryingExecutorWithContext<String> executor =
        getExecutor(
            getAlgorithm(
                withCustomRetrySettings ? FAILING_RETRY_SETTINGS : FAST_RETRY_SETTINGS,
                5,
                new RuntimeException()));
    RetryingFuture<String> future = executor.createFuture(callable, retryingContext);
    callable.setExternalFuture(future);
    future.setAttemptFuture(executor.submit(future));

    assertFutureFail(future, RuntimeException.class);
    assertEquals(4, future.getAttemptSettings().getAttemptCount());

    verify(tracer, times(5)).attemptStarted(eq("request"), anyInt());
    // Pre-apocalypse failures
    verify(tracer, times(4))
        .attemptFailedDuration(any(Throwable.class), any(java.time.Duration.class));
    // Apocalypse failure
    verify(tracer, times(1)).attemptPermanentFailure(any(RuntimeException.class));
    verifyNoMoreInteractions(tracer);
  }

  @ParameterizedTest
  @MethodSource("data")
  void testPollExceptionByPollAlgorithm(boolean withCustomRetrySettings) throws Exception {
    setUp(withCustomRetrySettings);
    RetrySettings retrySettings =
        FAST_RETRY_SETTINGS.toBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(Integer.MAX_VALUE))
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(Integer.MAX_VALUE))
            .build();
    boolean useContextRetrySettings = retryingContext.getRetrySettings() != null;

    RetryAlgorithm<String> retryAlgorithm =
        new RetryAlgorithm<>(
            new TestResultRetryAlgorithm<String>(0, null),
            new ExponentialPollAlgorithm(
                useContextRetrySettings
                    ? withCustomRetrySettings ? FAILING_RETRY_SETTINGS : FAST_RETRY_SETTINGS
                    : retrySettings,
                NanoClock.getDefaultClock()));

    RetryingExecutorWithContext<String> executor = getExecutor(retryAlgorithm);
    FailingCallable callable = new FailingCallable(6, "request", "FAILURE", tracer);
    RetryingContext context;
    if (useContextRetrySettings) {
      context = FakeCallContext.createDefault().withTracer(tracer).withRetrySettings(retrySettings);
    } else {
      context = FakeCallContext.createDefault().withTracer(tracer);
    }
    RetryingFuture<String> future = executor.createFuture(callable, context);
    callable.setExternalFuture(future);
    future.setAttemptFuture(executor.submit(future));

    assertFutureFail(future, PollException.class);
    assertTrue(future.getAttemptSettings().getAttemptCount() < 4);

    verify(tracer, times(1)).attemptStarted(eq("request"), anyInt());
    verify(tracer, times(1)).attemptPermanentFailure(any(PollException.class));
    verifyNoMoreInteractions(tracer);
  }

  protected static class TestResultRetryAlgorithm<ResponseT>
      extends BasicResultRetryAlgorithm<ResponseT> {

    private AtomicInteger apocalypseCountDown;
    private RuntimeException apocalypseException;

    TestResultRetryAlgorithm(int apocalypseCountDown, RuntimeException apocalypseException) {
      this.apocalypseCountDown =
          apocalypseCountDown > 0
              ? new AtomicInteger(apocalypseCountDown * 2)
              : new AtomicInteger(Integer.MAX_VALUE);
      this.apocalypseException = apocalypseException;
    }

    @Override
    public boolean shouldRetry(Throwable prevThrowable, ResponseT prevResponse) {
      if (apocalypseCountDown.decrementAndGet() == 0) {
        throw apocalypseException;
      }
      return super.shouldRetry(prevThrowable, prevResponse);
    }
  }

  void assertFutureSuccess(RetryingFuture<String> future)
      throws ExecutionException, InterruptedException, TimeoutException {
    assertEquals("SUCCESS", future.get(3, TimeUnit.SECONDS));
    assertTrue(future.isDone());
    assertFalse(future.isCancelled());

    assertEquals("SUCCESS", future.peekAttemptResult().get(3, TimeUnit.SECONDS));
    assertSame(future.peekAttemptResult(), future.peekAttemptResult());
    assertTrue(future.peekAttemptResult().isDone());
    assertFalse(future.peekAttemptResult().isCancelled());

    assertEquals("SUCCESS", future.getAttemptResult().get(3, TimeUnit.SECONDS));
    assertSame(future.getAttemptResult(), future.getAttemptResult());
    assertTrue(future.getAttemptResult().isDone());
    assertFalse(future.getAttemptResult().isCancelled());

    String res = future.get();
    ApiFuture<?> gottentAttempt = future.getAttemptResult();
    ApiFuture<?> peekedAttempt = future.peekAttemptResult();

    // testing completed immutability
    assertFalse(future.cancel(true));
    assertFalse(future.cancel(false));
    assertSame(gottentAttempt, future.getAttemptResult());
    assertSame(peekedAttempt, future.peekAttemptResult());
    assertSame(res, future.get());
    assertTrue(future.isDone());
    assertFalse(future.isCancelled());
  }

  void assertFutureFail(RetryingFuture<?> future, Class<? extends Throwable> exceptionClass)
      throws TimeoutException, InterruptedException {
    Throwable exception = null;
    try {
      future.get(3, TimeUnit.SECONDS);
    } catch (ExecutionException e) {
      exception = e.getCause();
    }
    assertNotNull(exception);
    assertEquals(exception.getClass(), exceptionClass);
    assertTrue(future.isDone());
    assertFalse(future.isCancelled());

    try {
      future.peekAttemptResult().get(3, TimeUnit.SECONDS);
    } catch (ExecutionException e) {
      exception = e.getCause();
    }
    assertNotNull(exception);
    assertEquals(exception.getClass(), exceptionClass);
    assertSame(future.peekAttemptResult(), future.peekAttemptResult());
    assertTrue(future.peekAttemptResult().isDone());
    assertFalse(future.peekAttemptResult().isCancelled());

    try {
      future.getAttemptResult().get(3, TimeUnit.SECONDS);
    } catch (ExecutionException e) {
      exception = e.getCause();
    }
    assertNotNull(exception);
    assertEquals(exception.getClass(), exceptionClass);
    assertSame(future.getAttemptResult(), future.getAttemptResult());
    assertTrue(future.getAttemptResult().isDone());
    assertFalse(future.getAttemptResult().isCancelled());

    ApiFuture<?> gottentAttempt = future.getAttemptResult();
    ApiFuture<?> peekedAttempt = future.peekAttemptResult();

    // testing completed immutability
    assertFalse(future.cancel(true));
    assertFalse(future.cancel(false));
    assertSame(gottentAttempt, future.getAttemptResult());
    assertSame(peekedAttempt, future.peekAttemptResult());
    try {
      future.get(3, TimeUnit.SECONDS);
    } catch (ExecutionException e) {
      exception = e.getCause();
    }
    assertNotNull(exception);
    assertEquals(exception.getClass(), exceptionClass);
    assertTrue(future.isDone());
    assertFalse(future.isCancelled());
  }

  void assertFutureCancel(RetryingFuture<?> future)
      throws ExecutionException, InterruptedException, TimeoutException {
    Exception exception = null;
    try {
      future.get(3, TimeUnit.SECONDS);
    } catch (CancellationException e) {
      exception = e;
    }
    assertNotNull(exception);
    assertTrue(future.isDone());
    assertTrue(future.isCancelled());

    try {
      future.getAttemptResult().get(3, TimeUnit.SECONDS);
    } catch (CancellationException e) {
      exception = e;
    }
    assertNotNull(exception);
    assertSame(future.getAttemptResult(), future.getAttemptResult());
    assertTrue(future.getAttemptResult().isDone());
    assertTrue(future.getAttemptResult().isCancelled());
    try {
      future.peekAttemptResult().get(3, TimeUnit.SECONDS);
    } catch (CancellationException e) {
      exception = e;
    }
    assertNotNull(exception);
    assertSame(future.peekAttemptResult(), future.peekAttemptResult());
    assertTrue(future.peekAttemptResult().isDone());
    assertTrue(future.peekAttemptResult().isCancelled());

    ApiFuture<?> gottentAttempt = future.getAttemptResult();
    ApiFuture<?> peekedAttempt = future.peekAttemptResult();

    // testing completed immutability
    assertFalse(future.cancel(true));
    assertFalse(future.cancel(false));
    assertSame(gottentAttempt, future.getAttemptResult());
    assertSame(peekedAttempt, future.peekAttemptResult());
    try {
      future.get(3, TimeUnit.SECONDS);
    } catch (CancellationException e) {
      exception = e;
    }
    assertNotNull(exception);
    assertTrue(future.isDone());
    assertTrue(future.isCancelled());
  }
}
