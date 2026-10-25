/*
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.spanner.AbstractResultSet.CloseableIterator;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.StreamMessageListener;
import com.google.cloud.spanner.ErrorHandler.DefaultErrorHandler;
import com.google.cloud.spanner.XGoogSpannerRequestId.NoopRequestIdCreator;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
import com.google.common.base.Stopwatch;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Value;
import com.google.rpc.RetryInfo;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.Transaction;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracing;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.LongSupplier;
import org.jspecify.annotations.Nullable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

/** Unit tests for {@link ResumableStreamIterator}. */
@RunWith(Parameterized.class)
public class ResumableStreamIteratorTest {
  interface Starter {
    CloseableIterator<PartialResultSet> startStream(
        @Nullable ByteString resumeToken, @Nullable StreamMessageListener streamMessageListener);
  }

  interface ResultSetStream {
    PartialResultSet next();

    void close();
  }

  @Parameter(0)
  public ErrorCode errorCodeParameter;

  @Parameters(name = "errorCodeParameter = {0}")
  public static List<ErrorCode> data() {
    return ImmutableList.of(ErrorCode.UNAVAILABLE, ErrorCode.RESOURCE_EXHAUSTED);
  }

  private static StatusRuntimeException statusWithRetryInfo(ErrorCode code) {
    Metadata.Key<RetryInfo> key = ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
    Metadata trailers = new Metadata();
    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(
                Duration.newBuilder()
                    .setNanos((int) TimeUnit.MILLISECONDS.toNanos(1L))
                    .setSeconds(0L))
            .build();
    trailers.put(key, retryInfo);
    return code.getGrpcStatus().asRuntimeException(trailers);
  }

  static class RetryableException extends SpannerException {
    RetryableException(ErrorCode code, @Nullable String message) {
      // OK to instantiate SpannerException directly for this unit test.
      super(DoNotConstructDirectly.ALLOWED, code, true, message, statusWithRetryInfo(code));
    }

    RetryableException(ErrorCode code, @Nullable String message, StatusRuntimeException cause) {
      // OK to instantiate SpannerException directly for this unit test.
      super(DoNotConstructDirectly.ALLOWED, code, true, message, cause);
    }
  }

  static class NonRetryableException extends SpannerException {
    NonRetryableException(ErrorCode code, @Nullable String message) {
      super(DoNotConstructDirectly.ALLOWED, code, false, message, null);
    }
  }

  static class ResultSetIterator extends AbstractIterator<PartialResultSet>
      implements CloseableIterator<PartialResultSet> {
    final ResultSetStream stream;

    ResultSetIterator(ResultSetStream stream) {
      this.stream = stream;
    }

    @Override
    public boolean isDataAvailable() {
      return false;
    }

    @Override
    protected PartialResultSet computeNext() {
      PartialResultSet next = stream.next();
      if (next == null) {
        endOfData();
      }
      return next;
    }

    @Override
    public void close(@Nullable String message) {
      stream.close();
    }

    @Override
    public boolean isWithBeginTransaction() {
      return false;
    }

    @Override
    public boolean isLastStatement() {
      return false;
    }
  }

  Starter starter = Mockito.mock(Starter.class);
  ResumableStreamIterator resumableStreamIterator;
  private LongSupplier nanoTime = System::nanoTime;

  @Before
  public void setUp() {
    SpannerOptions.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();
    initWithLimit(Integer.MAX_VALUE);
  }

  @After
  public void tearDown() {
    SpannerOptions.resetActiveTracingFramework();
  }

  private void initWithLimit(int maxBufferSize) {
    initWithLimitAndRetrySettings(
        maxBufferSize,
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(10))
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(1000))
            .build());
  }

  private void initWithLimitAndRetrySettings(int maxBufferSize, RetrySettings retrySettings) {
    initWithLimitAndRetrySettings(
        maxBufferSize,
        retrySettings,
        new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false));
  }

  private static OpenTelemetrySpan mockOpenTelemetrySpan() {
    return new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class));
  }

  private void initWithLimitAndRetrySettings(
      int maxBufferSize, RetrySettings retrySettings, TraceWrapper tracer) {
    resumableStreamIterator =
        new ResumableStreamIterator(
            maxBufferSize,
            "",
            mockOpenTelemetrySpan(),
            tracer,
            DefaultErrorHandler.INSTANCE,
            retrySettings,
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
            NoopRequestIdCreator.INSTANCE) {
          @Override
          long nanoTime() {
            return nanoTime.getAsLong();
          }

          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            return starter.startStream(resumeToken, streamMessageListener);
          }
        };
  }

  @Test
  public void simple() {
    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    Mockito.when(s1.next())
        .thenReturn(resultSet(null, "a"))
        .thenReturn(resultSet(null, "b"))
        .thenReturn(null);
    assertThat(consume(resumableStreamIterator)).containsExactly("a", "b").inOrder();
  }

  @Test
  public void closedOTSpan() {
    SpannerOptions.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();

    io.opentelemetry.api.trace.Span oTspan = mock(io.opentelemetry.api.trace.Span.class);
    ISpan span = new OpenTelemetrySpan(oTspan);
    TraceWrapper tracer = mock(TraceWrapper.class);
    when(tracer.spanBuilderWithExplicitParent(
            Mockito.anyString(), Mockito.any(), Mockito.any(Attributes.class)))
        .thenReturn(span);
    initWithLimitAndRetrySettings(Integer.MAX_VALUE, RetrySettings.newBuilder().build(), tracer);

    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    Mockito.when(s1.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "a"))
        .thenReturn(resultSet(ByteString.copyFromUtf8("r2"), "b"))
        .thenReturn(null);
    assertThat(consume(resumableStreamIterator)).containsExactly("a", "b").inOrder();

    resumableStreamIterator.close("closed");
    verify(oTspan).end();
  }

  @Test
  public void closedOCSpan() {
    SpannerOptions.resetActiveTracingFramework();
    SpannerOptions.enableOpenCensusTraces();
    Span mockSpan = mock(Span.class);
    ISpan span = new OpenCensusSpan(mockSpan);
    TraceWrapper tracer = mock(TraceWrapper.class);
    when(tracer.spanBuilderWithExplicitParent(
            Mockito.anyString(), Mockito.any(), Mockito.any(Attributes.class)))
        .thenReturn(span);
    initWithLimitAndRetrySettings(Integer.MAX_VALUE, RetrySettings.newBuilder().build(), tracer);

    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    Mockito.when(s1.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "a"))
        .thenReturn(resultSet(ByteString.copyFromUtf8("r2"), "b"))
        .thenReturn(null);
    assertThat(consume(resumableStreamIterator)).containsExactly("a", "b").inOrder();

    resumableStreamIterator.close("closed");
    verify(mockSpan).end(OpenCensusSpan.END_SPAN_OPTIONS);
  }

  @Test
  public void restart() {
    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    Mockito.when(s1.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "a"))
        .thenReturn(resultSet(ByteString.copyFromUtf8("r2"), "b"))
        .thenThrow(new RetryableException(errorCodeParameter, "failed by test"));

    ResultSetStream s2 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(ByteString.copyFromUtf8("r2"), null))
        .thenReturn(new ResultSetIterator(s2));
    Mockito.when(s2.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r3"), "c"))
        .thenReturn(resultSet(ByteString.copyFromUtf8("r4"), "d"))
        .thenReturn(null);
    assertThat(consume(resumableStreamIterator)).containsExactly("a", "b", "c", "d").inOrder();
  }

  @Test
  public void restartWithHoldBack() {
    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    Mockito.when(s1.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "a"))
        .thenReturn(resultSet(ByteString.copyFromUtf8("r2"), "b"))
        .thenReturn(resultSet(null, "X"))
        .thenReturn(resultSet(null, "X"))
        .thenThrow(new RetryableException(errorCodeParameter, "failed by test"));

    ResultSetStream s2 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(ByteString.copyFromUtf8("r2"), null))
        .thenReturn(new ResultSetIterator(s2));
    Mockito.when(s2.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r3"), "c"))
        .thenReturn(resultSet(ByteString.copyFromUtf8("r4"), "d"))
        .thenReturn(null);
    assertThat(consume(resumableStreamIterator)).containsExactly("a", "b", "c", "d").inOrder();
  }

  @Test
  public void restartWithHoldBackMidStream() {
    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    Mockito.when(s1.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "a"))
        .thenReturn(resultSet(null, "b"))
        .thenReturn(resultSet(null, "c"))
        .thenReturn(resultSet(ByteString.copyFromUtf8("r2"), "d"))
        .thenThrow(new RetryableException(errorCodeParameter, "failed by test"));

    ResultSetStream s2 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(ByteString.copyFromUtf8("r2"), null))
        .thenReturn(new ResultSetIterator(s2));
    Mockito.when(s2.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r3"), "e"))
        .thenReturn(resultSet(null, "f"))
        .thenReturn(null);
    assertThat(consume(resumableStreamIterator))
        .containsExactly("a", "b", "c", "d", "e", "f")
        .inOrder();
  }

  @Test
  public void retryableErrorWithoutRetryInfo() {
    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(s1.next())
        .thenThrow(
            new RetryableException(
                ErrorCode.UNAVAILABLE, "failed by test", Status.UNAVAILABLE.asRuntimeException()));

    ResultSetStream s2 = Mockito.mock(ResultSetStream.class);
    Mockito.when(s2.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "a"))
        .thenReturn(resultSet(ByteString.copyFromUtf8("r2"), "b"))
        .thenReturn(null);

    Mockito.when(starter.startStream(null, null))
        .thenReturn(new ResultSetIterator(s1))
        .thenReturn(new ResultSetIterator(s2));
    assertThat(consume(resumableStreamIterator)).containsExactly("a", "b").inOrder();
    Mockito.verify(starter, Mockito.times(2)).startStream(null, null);
  }

  @Test(timeout = 60000L)
  public void customMaxAttempts_stopsResumeAfterMaxAttempts() {
    initWithLimitAndRetrySettings(
        Integer.MAX_VALUE,
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(1L))
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(1L))
            .setRetryDelayMultiplier(1.0)
            .setMaxAttempts(2)
            .setTotalTimeoutDuration(java.time.Duration.ofSeconds(30L))
            .build());

    // Every stream fails with a retryable error before returning any data. Without a bound on the
    // number of attempts, this loops forever.
    Mockito.when(starter.startStream(Mockito.any(), Mockito.any()))
        .thenAnswer(
            invocation -> {
              ResultSetStream stream = Mockito.mock(ResultSetStream.class);
              Mockito.when(stream.next())
                  .thenThrow(new RetryableException(errorCodeParameter, "failed by test"));
              return new ResultSetIterator(stream);
            });

    SpannerException e =
        assertThrows(SpannerException.class, () -> consume(resumableStreamIterator));
    assertEquals(errorCodeParameter, e.getErrorCode());
    Mockito.verify(starter, Mockito.times(2)).startStream(Mockito.any(), Mockito.any());
  }

  @Test(timeout = 60000L)
  public void customMaxAttemptsWithoutTotalTimeout_makesExactlyMaxAttempts() {
    // A total timeout of zero means that no total timeout has been set. The number of attempts
    // must then be limited by maxAttempts alone: the unset total timeout must not be interpreted
    // as a (near-)zero time budget that stops the retries before maxAttempts has been reached.
    initWithLimitAndRetrySettings(
        Integer.MAX_VALUE,
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(5L))
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(5L))
            .setRetryDelayMultiplier(1.0)
            .setMaxAttempts(3)
            .build());

    // Every stream fails with a retryable error without retry info, so the exponential backoff
    // determines the retry delays.
    Mockito.when(starter.startStream(Mockito.any(), Mockito.any()))
        .thenAnswer(
            invocation -> {
              ResultSetStream stream = Mockito.mock(ResultSetStream.class);
              Mockito.when(stream.next())
                  .thenThrow(
                      new RetryableException(
                          errorCodeParameter,
                          "failed by test",
                          errorCodeParameter.getGrpcStatus().asRuntimeException()));
              return new ResultSetIterator(stream);
            });

    SpannerException e =
        assertThrows(SpannerException.class, () -> consume(resumableStreamIterator));
    assertEquals(errorCodeParameter, e.getErrorCode());
    Mockito.verify(starter, Mockito.times(3)).startStream(Mockito.any(), Mockito.any());
  }

  @Test(timeout = 60000L)
  public void repeatedIdenticalResumeToken_doesNotResetAttempts() {
    // A stream that repeatedly returns the same resume token has not made any progress: only a
    // new resume token resets the budget for consecutive failed attempts. Without this, a stream
    // that always returns the token that was used to resume it and then fails would retry
    // forever, regardless of maxAttempts.
    initWithLimitAndRetrySettings(
        Integer.MAX_VALUE,
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(1L))
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(1L))
            .setRetryDelayMultiplier(1.0)
            .setMaxAttempts(2)
            .setTotalTimeoutDuration(java.time.Duration.ofSeconds(30L))
            .build());

    ByteString token = ByteString.copyFromUtf8("r1");
    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(s1.next())
        .thenReturn(resultSet(token, "a"))
        .thenThrow(new RetryableException(errorCodeParameter, "failed by test"));
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    // Every resumed stream returns the same resume token again and then fails.
    Mockito.when(starter.startStream(token, null))
        .thenAnswer(
            invocation -> {
              ResultSetStream stream = Mockito.mock(ResultSetStream.class);
              Mockito.when(stream.next())
                  .thenReturn(resultSet(token, "x"))
                  .thenThrow(new RetryableException(errorCodeParameter, "failed by test"));
              return new ResultSetIterator(stream);
            });

    SpannerException e =
        assertThrows(SpannerException.class, () -> consume(resumableStreamIterator));
    assertEquals(errorCodeParameter, e.getErrorCode());
    Mockito.verify(starter, Mockito.times(1)).startStream(null, null);
    Mockito.verify(starter, Mockito.times(1)).startStream(token, null);
  }

  @Test
  public void activeRetrySequence_preservesNegativeOneStartTime() {
    initWithLimitAndRetrySettings(
        Integer.MAX_VALUE,
        RetrySettings.newBuilder()
            .setTotalTimeoutDuration(java.time.Duration.ofSeconds(1))
            .build());
    SpannerException exception = new RetryableException(errorCodeParameter, "failed by test");
    nanoTime = () -> -1L;
    assertEquals(1L, resumableStreamIterator.checkRetryBudgetAndGetDelay(exception));
    nanoTime = () -> TimeUnit.SECONDS.toNanos(1L);
    assertThat(
            assertThrows(
                SpannerException.class,
                () -> resumableStreamIterator.checkRetryBudgetAndGetDelay(exception)))
        .isSameInstanceAs(exception);
  }

  @Test
  public void totalTimeout_largeDelayDoesNotOverflow() {
    assertThat(totalTimeoutExceeded(1000L, 100L, Long.MAX_VALUE)).isTrue();
  }

  @Test
  public void totalTimeout_negativeElapsedIsClamped() {
    assertThat(totalTimeoutExceeded(Long.MAX_VALUE, -60000L, Long.MAX_VALUE)).isTrue();
    assertThat(totalTimeoutExceeded(Long.MAX_VALUE, -60000L, 0L)).isFalse();
  }

  @Test
  public void totalTimeout_elapsedBudgetAndNegativeDelay() {
    assertThat(totalTimeoutExceeded(1000L, 60000L, -2L)).isTrue();
    assertThat(totalTimeoutExceeded(1000L, -60000L, -2L)).isFalse();
    assertThat(totalTimeoutExceeded(1000L, -60000L, 1000L)).isTrue();
  }

  private boolean totalTimeoutExceeded(long timeoutMillis, long elapsedMillis, long delayMillis) {
    initWithLimitAndRetrySettings(
        Integer.MAX_VALUE,
        RetrySettings.newBuilder()
            .setTotalTimeoutDuration(java.time.Duration.ofMillis(timeoutMillis))
            .build());
    SpannerException exception =
        Mockito.spy(new RetryableException(errorCodeParameter, "failed by test"));
    when(exception.getRetryDelayInMillis()).thenReturn(0L);
    nanoTime = () -> 0L;
    assertEquals(0L, resumableStreamIterator.checkRetryBudgetAndGetDelay(exception));
    nanoTime = () -> TimeUnit.MILLISECONDS.toNanos(elapsedMillis);
    when(exception.getRetryDelayInMillis()).thenReturn(delayMillis);
    try {
      assertEquals(delayMillis, resumableStreamIterator.checkRetryBudgetAndGetDelay(exception));
      return false;
    } catch (SpannerException e) {
      assertThat(e).isSameInstanceAs(exception);
      return true;
    }
  }

  @Test
  public void retryBudget_usesConfiguredBackoffWithoutRetryInfo() {
    initWithLimitAndRetrySettings(
        Integer.MAX_VALUE,
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(100))
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(100))
            .build());
    SpannerException exception =
        new RetryableException(
            errorCodeParameter,
            "failed by test",
            errorCodeParameter.getGrpcStatus().asRuntimeException());
    long delayMillis = resumableStreamIterator.checkRetryBudgetAndGetDelay(exception);
    assertThat(delayMillis).isAtLeast(50L);
    assertThat(delayMillis).isAtMost(150L);
  }

  @Test
  public void rawGapicSettings_useConfiguredTimeoutWithoutSpecialCase() {
    RetrySettings settings =
        SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings();
    initWithLimitAndRetrySettings(Integer.MAX_VALUE, settings);
    SpannerException exception =
        Mockito.spy(new RetryableException(errorCodeParameter, "failed by test"));
    when(exception.getRetryDelayInMillis())
        .thenReturn(settings.getTotalTimeoutDuration().toMillis());
    assertThat(
            assertThrows(
                SpannerException.class,
                () -> resumableStreamIterator.checkRetryBudgetAndGetDelay(exception)))
        .isSameInstanceAs(exception);
  }

  @Test(timeout = 60000L)
  public void customTotalTimeoutSmallerThanRetryDelay_doesNotRetry() {
    // Retrying is only allowed if the retry delay still fits in the remaining total timeout
    // budget. A retry delay that is larger than the total timeout means that the first failure
    // already exhausts the budget.
    initWithLimitAndRetrySettings(
        Integer.MAX_VALUE,
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofSeconds(1L))
            .setMaxRetryDelayDuration(java.time.Duration.ofSeconds(1L))
            .setRetryDelayMultiplier(1.0)
            .setTotalTimeoutDuration(java.time.Duration.ofMillis(100L))
            .build());

    Mockito.when(starter.startStream(Mockito.any(), Mockito.any()))
        .thenAnswer(
            invocation -> {
              ResultSetStream stream = Mockito.mock(ResultSetStream.class);
              Mockito.when(stream.next())
                  .thenThrow(
                      new RetryableException(
                          errorCodeParameter,
                          "failed by test",
                          errorCodeParameter.getGrpcStatus().asRuntimeException()));
              return new ResultSetIterator(stream);
            });

    Stopwatch stopwatch = Stopwatch.createStarted();
    SpannerException e =
        assertThrows(SpannerException.class, () -> consume(resumableStreamIterator));
    assertEquals(errorCodeParameter, e.getErrorCode());
    Mockito.verify(starter, Mockito.times(1)).startStream(Mockito.any(), Mockito.any());
    // The one-second retry delay must not have been slept before giving up.
    assertThat(stopwatch.elapsed(TimeUnit.MILLISECONDS)).isLessThan(5000L);
  }

  @Test(timeout = 60000L)
  public void customTotalTimeout_stopsResumeWhenTotalTimeoutIsExhausted() {
    initWithLimitAndRetrySettings(
        Integer.MAX_VALUE,
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(1L))
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(10L))
            .setRetryDelayMultiplier(1.0)
            .setTotalTimeoutDuration(java.time.Duration.ofMillis(50L))
            .build());

    // Every stream fails with a retryable error without retry info, so the exponential backoff
    // determines the retry delays. Without a bound on the total time spent retrying, this loops
    // forever.
    Mockito.when(starter.startStream(Mockito.any(), Mockito.any()))
        .thenAnswer(
            invocation -> {
              ResultSetStream stream = Mockito.mock(ResultSetStream.class);
              Mockito.when(stream.next())
                  .thenThrow(
                      new RetryableException(
                          errorCodeParameter,
                          "failed by test",
                          errorCodeParameter.getGrpcStatus().asRuntimeException()));
              return new ResultSetIterator(stream);
            });

    SpannerException e =
        assertThrows(SpannerException.class, () -> consume(resumableStreamIterator));
    assertEquals(errorCodeParameter, e.getErrorCode());
  }

  @Test
  public void nonRetryableError() {
    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    Mockito.when(s1.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "a"))
        .thenReturn(resultSet(ByteString.copyFromUtf8("r2"), "b"))
        .thenReturn(resultSet(null, "X"))
        .thenReturn(resultSet(null, "X"))
        .thenThrow(new NonRetryableException(ErrorCode.FAILED_PRECONDITION, "failed by test"));
    Iterator<String> strings = stringIterator(resumableStreamIterator);
    assertThat(strings.next()).isEqualTo("a");
    assertThat(strings.next()).isEqualTo("b");
    SpannerException e = assertThrows(SpannerException.class, () -> strings.next());
    assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
  }

  @Test
  public void bufferLimitSimple() {
    initWithLimit(1);

    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    Mockito.when(s1.next())
        .thenReturn(resultSet(null, "a"))
        .thenReturn(resultSet(null, "b"))
        .thenReturn(null);
    assertThat(consume(resumableStreamIterator)).containsExactly("a", "b").inOrder();
  }

  @Test
  public void bufferLimitSimpleWithRestartTokens() {
    initWithLimit(1);

    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    Mockito.when(s1.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "a"))
        .thenReturn(resultSet(ByteString.copyFromUtf8("r2"), "b"))
        .thenReturn(null);
    assertThat(consume(resumableStreamIterator)).containsExactly("a", "b").inOrder();
  }

  @Test
  public void bufferLimitRestart() {
    initWithLimit(1);

    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    Mockito.when(s1.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "a"))
        .thenReturn(resultSet(ByteString.copyFromUtf8("r2"), "b"))
        .thenThrow(new RetryableException(errorCodeParameter, "failed by test"));

    ResultSetStream s2 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(ByteString.copyFromUtf8("r2"), null))
        .thenReturn(new ResultSetIterator(s2));
    Mockito.when(s2.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r3"), "c"))
        .thenReturn(resultSet(ByteString.copyFromUtf8("r4"), "d"))
        .thenReturn(null);
    assertThat(consume(resumableStreamIterator)).containsExactly("a", "b", "c", "d").inOrder();
  }

  @Test
  public void bufferLimitRestartWithinLimitAtStartOfResults() {
    initWithLimit(1);

    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    Mockito.when(s1.next())
        .thenReturn(resultSet(null, "XXXXXX"))
        .thenThrow(new RetryableException(errorCodeParameter, "failed by test"));

    ResultSetStream s2 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s2));
    Mockito.when(s2.next())
        .thenReturn(resultSet(null, "a"))
        .thenReturn(resultSet(null, "b"))
        .thenReturn(null);
    assertThat(consume(resumableStreamIterator)).containsExactly("a", "b").inOrder();
  }

  @Test
  public void bufferLimitRestartWithinLimitMidResults() {
    initWithLimit(1);

    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    Mockito.when(s1.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "a"))
        .thenReturn(resultSet(null, "XXXXXX"))
        .thenThrow(new RetryableException(errorCodeParameter, "failed by test"));

    ResultSetStream s2 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(ByteString.copyFromUtf8("r1"), null))
        .thenReturn(new ResultSetIterator(s2));
    Mockito.when(s2.next())
        .thenReturn(resultSet(null, "b"))
        .thenReturn(resultSet(null, "c"))
        .thenReturn(null);
    assertThat(consume(resumableStreamIterator)).containsExactly("a", "b", "c").inOrder();
  }

  @Test
  public void bufferLimitMissingTokensUnsafeToRetry() {
    initWithLimit(1);

    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    Mockito.when(s1.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "a"))
        .thenReturn(resultSet(null, "b"))
        .thenReturn(resultSet(null, "c"))
        .thenThrow(new RetryableException(errorCodeParameter, "failed by test"));

    assertThat(consumeAtMost(3, resumableStreamIterator)).containsExactly("a", "b", "c").inOrder();
    SpannerException e = assertThrows(SpannerException.class, () -> resumableStreamIterator.next());
    assertThat(e.getErrorCode()).isEqualTo(errorCodeParameter);
  }

  @Test
  public void bufferLimitMissingTokensSafeToRetry() {
    initWithLimit(1);

    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    Mockito.when(s1.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "a"))
        .thenReturn(resultSet(null, "b"))
        .thenReturn(resultSet(ByteString.copyFromUtf8("r3"), "c"))
        .thenThrow(new RetryableException(errorCodeParameter, "failed by test"));

    ResultSetStream s2 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(ByteString.copyFromUtf8("r3"), null))
        .thenReturn(new ResultSetIterator(s2));
    Mockito.when(s2.next()).thenReturn(resultSet(null, "d")).thenReturn(null);

    assertThat(consume(resumableStreamIterator)).containsExactly("a", "b", "c", "d").inOrder();
  }

  @Test
  public void isDataAvailableWithGrpcStreamIterator() {
    initWithLimit(512);
    GrpcStreamIterator grpcStream = new GrpcStreamIterator(false, 4, false);
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    grpcStream.setCall(call, false);
    Mockito.when(starter.startStream(null, null)).thenReturn(grpcStream);
    resumableStreamIterator.initiateStreaming(null);

    // Empty stream -> false
    assertFalse(resumableStreamIterator.isDataAvailable());

    // Chunk without resume token arrives -> drained into buffer (replenishing gRPC flow-control
    // credit), but not flushable yet until a resume token or EOF arrives (or maxBufferSize is
    // exceeded).
    grpcStream.consumer().onPartialResultSet(resultSet(null, "a"));
    assertFalse(resumableStreamIterator.isDataAvailable());
    verify(call, Mockito.times(1)).request(1);
    assertFalse(grpcStream.canPollWithoutErrorOrBlocking());

    grpcStream.consumer().onCompleted();
    assertTrue(resumableStreamIterator.isDataAvailable());
    assertEquals("a", resumableStreamIterator.next().getValues(0).getStringValue());
    assertFalse(resumableStreamIterator.hasNext());
  }

  @Test
  public void isDataAvailableWithGrpcStreamIteratorWhenErrorOccurs() {
    initWithLimit(512);
    GrpcStreamIterator grpcStream = new GrpcStreamIterator(false, 4, false);
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    grpcStream.setCall(call, false);
    when(starter.startStream(null, null)).thenReturn(grpcStream);
    resumableStreamIterator.initiateStreaming(null);

    // Initial chunk without resume token arrives -> drained into buffer, but not flushable yet.
    grpcStream.consumer().onPartialResultSet(resultSet(null, "a"));
    assertFalse(resumableStreamIterator.isDataAvailable());
    verify(call, Mockito.times(1)).request(1);
    assertFalse(grpcStream.canPollWithoutErrorOrBlocking());

    // Stream encounters an error -> isDataAvailable() must return true to unblock the consumer.
    grpcStream.consumer().onError(new RetryableException(errorCodeParameter, "transient error"));
    assertTrue(resumableStreamIterator.isDataAvailable());
  }

  @Test(timeout = 10_000)
  public void isDataAvailableWithoutResumeTokensWithProductionBufferSize() {
    initWithLimit(512);
    GrpcStreamIterator grpcStream = new GrpcStreamIterator(false, 4, false);
    SpannerRpc.StreamingCall call = Mockito.mock(SpannerRpc.StreamingCall.class);
    grpcStream.setCall(call, false);
    Mockito.when(starter.startStream(null, null)).thenReturn(grpcStream);
    resumableStreamIterator.initiateStreaming(null);

    assertFalse(resumableStreamIterator.isDataAvailable());

    for (int i = 0; i < 512; i++) {
      grpcStream.consumer().onPartialResultSet(resultSet(null, "val" + i));
      // Draining each chunk from grpcStream's bounded queue into ResumableStreamIterator.buffer.
      // Since buffer size <= 512, safeToRetry remains true and isDataAvailable() returns false.
      assertFalse(resumableStreamIterator.isDataAvailable());
    }

    // Pushing chunk 513 exceeds maxBufferSize (512). This flips safeToRetry to false,
    // making the buffer flushable and isDataAvailable() true BEFORE the stream completes.
    grpcStream.consumer().onPartialResultSet(resultSet(null, "val512"));
    assertTrue(resumableStreamIterator.isDataAvailable());

    // Once the stream completes, buffered chunks remain flushable.
    grpcStream.consumer().onCompleted();
    assertTrue(resumableStreamIterator.isDataAvailable());

    List<String> results = new ArrayList<>();
    while (resumableStreamIterator.hasNext()) {
      PartialResultSet partialResultSet = resumableStreamIterator.next();
      results.add(partialResultSet.getValues(0).getStringValue());
    }
    assertEquals(513, results.size());
    for (int i = 0; i < 513; i++) {
      assertEquals("val" + i, results.get(i));
    }
  }

  @Test
  public void isDataAvailableWhenStreamIsNull() {
    initWithLimit(10);
    assertFalse(resumableStreamIterator.isDataAvailable());
  }

  @Test
  public void isDataAvailableWhenFinished() {
    initWithLimit(10);
    ResultSetStream stream = mock(ResultSetStream.class);
    when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(stream));
    when(stream.next()).thenReturn(null);
    assertFalse(resumableStreamIterator.hasNext());
    assertTrue(resumableStreamIterator.isDataAvailable());
  }

  @Test
  public void isDataAvailableWhenClosedReturnsTrue() {
    initWithLimit(10);
    resumableStreamIterator.close("closed");
    assertTrue(resumableStreamIterator.isClosed());
    assertTrue(resumableStreamIterator.isDataAvailable());
  }

  @Test
  public void canPollWithoutErrorOrBlockingWhenClosedReturnsFalse() {
    initWithLimit(10);
    assertFalse(resumableStreamIterator.canPollWithoutErrorOrBlocking());

    resumableStreamIterator.close("closed");
    assertTrue(resumableStreamIterator.isClosed());
    assertFalse(resumableStreamIterator.canPollWithoutErrorOrBlocking());
  }

  @Test
  public void canPollWithoutErrorOrBlockingWithGrpcStreamIterator() {
    initWithLimit(512);
    GrpcStreamIterator grpcStream =
        new GrpcStreamIterator(
            /* lastStatement= */ false,
            /* prefetchChunks= */ 4,
            /* cancelQueryWhenClientIsClosed= */ false);
    grpcStream.setCall(mock(SpannerRpc.StreamingCall.class), false);
    when(starter.startStream(null, null)).thenReturn(grpcStream);
    resumableStreamIterator.initiateStreaming(null);

    assertFalse(resumableStreamIterator.canPollWithoutErrorOrBlocking());

    // Non-resume-token chunk arrives -> buffered, but not flushable yet
    grpcStream.consumer().onPartialResultSet(resultSet(null, "a"));
    assertFalse(resumableStreamIterator.canPollWithoutErrorOrBlocking());

    // Resume token chunk arrives -> flushable!
    grpcStream.consumer().onPartialResultSet(resultSet(ByteString.copyFromUtf8("r1"), "b"));
    assertTrue(resumableStreamIterator.canPollWithoutErrorOrBlocking());

    // Consuming both items empties the buffer
    assertEquals("a", resumableStreamIterator.next().getValues(0).getStringValue());
    assertEquals("b", resumableStreamIterator.next().getValues(0).getStringValue());
    assertFalse(resumableStreamIterator.canPollWithoutErrorOrBlocking());

    // EOF arrives -> flushable again (yields EOF)
    grpcStream.consumer().onCompleted();
    assertTrue(resumableStreamIterator.canPollWithoutErrorOrBlocking());
    assertFalse(resumableStreamIterator.hasNext());
  }

  @Test(timeout = 10_000)
  public void closeDuringStartStreamClosesStreamAndPreventsResurrection() {
    initWithLimit(10);
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    GrpcStreamIterator grpcStream = new GrpcStreamIterator(true, 4, false);
    grpcStream.setCall(call, true);
    when(starter.startStream(null, null))
        .thenAnswer(
            invocation -> {
              resumableStreamIterator.close("cancelled while starting stream");
              return grpcStream;
            });

    assertFalse(resumableStreamIterator.hasNext());
    assertTrue(resumableStreamIterator.isClosed());
    assertTrue(resumableStreamIterator.isWithBeginTransaction());
    assertTrue(resumableStreamIterator.isLastStatement());
    verify(call, Mockito.times(1)).cancel("cancelled while starting stream");
    verify(call, Mockito.never()).request(Mockito.anyInt());
  }

  @Test(timeout = 10_000)
  public void multipleCloseCallsAreIdempotent() {
    initWithLimit(10);
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    GrpcStreamIterator grpcStream = new GrpcStreamIterator(false, 4, false);
    grpcStream.setCall(call, false);
    when(starter.startStream(null, null)).thenReturn(grpcStream);
    resumableStreamIterator.initiateStreaming(null);
    grpcStream.consumer().onPartialResultSet(resultSet(ByteString.copyFromUtf8("r1"), "a"));

    resumableStreamIterator.close("first close");
    resumableStreamIterator.close("second close");

    assertTrue(resumableStreamIterator.isClosed());
    assertFalse(resumableStreamIterator.hasNext());
    verify(call, Mockito.times(1)).cancel("first close");
    verify(call, Mockito.never()).cancel("second close");
  }

  @Test
  public void closeWhenStreamIsNullEndsSpan() {
    SpannerOptions.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();

    io.opentelemetry.api.trace.Span openTelemetrySpan = mock(io.opentelemetry.api.trace.Span.class);
    ISpan span = new OpenTelemetrySpan(openTelemetrySpan);
    TraceWrapper tracer = mock(TraceWrapper.class);
    when(tracer.spanBuilderWithExplicitParent(Mockito.anyString(), Mockito.any(), Mockito.any()))
        .thenReturn(span);
    initWithLimitAndRetrySettings(10, RetrySettings.newBuilder().build(), tracer);

    resumableStreamIterator.close("cancelled before streaming");
    assertTrue(resumableStreamIterator.isClosed());
    verify(openTelemetrySpan).end();
  }

  @Test
  public void isDataAvailableWhenBufferHasItems() {
    initWithLimit(10);
    ResultSetStream stream = mock(ResultSetStream.class);
    when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(stream));
    when(stream.next())
        .thenReturn(resultSet(null, "chunkWithoutToken"))
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "chunkWithToken"))
        .thenReturn(null);

    // Consuming the first element causes computeNext to buffer both chunks (up to the resume token)
    // and pop the first one, leaving chunkWithToken in the buffer.
    assertEquals("chunkWithoutToken", resumableStreamIterator.next().getValues(0).getStringValue());

    // With chunkWithToken still buffered, isDataAvailable() returns true via buffer.peekFirst()
    // != null
    assertTrue(resumableStreamIterator.isDataAvailable());
    assertEquals("chunkWithToken", resumableStreamIterator.next().getValues(0).getStringValue());
  }

  @Test
  public void
      isWithBeginTransactionAndLastStatementPropagateFromGrpcStreamIteratorToGrpcResultSet() {
    initWithLimit(10);
    assertFalse(resumableStreamIterator.isWithBeginTransaction());
    assertFalse(resumableStreamIterator.isLastStatement());

    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    GrpcStreamIterator grpcStream = new GrpcStreamIterator(true, 4, false);
    grpcStream.setCall(call, true);
    when(starter.startStream(null, null)).thenReturn(grpcStream);

    Transaction expectedTransaction =
        Transaction.newBuilder().setId(ByteString.copyFromUtf8("tx-1")).build();
    grpcStream
        .consumer()
        .onPartialResultSet(
            PartialResultSet.newBuilder()
                .setMetadata(
                    MockSpannerTestUtil.READ_KEY_VALUE_METADATA.toBuilder()
                        .setTransaction(expectedTransaction)
                        .build())
                .setResumeToken(ByteString.copyFromUtf8("r1"))
                .setLast(true)
                .addValues(Value.newBuilder().setStringValue("k1"))
                .addValues(Value.newBuilder().setStringValue("v1"))
                .build());
    grpcStream.consumer().onCompleted();

    AbstractResultSet.Listener listener = mockErrorAndDoneListener();
    try (GrpcResultSet grpcResultSet = new GrpcResultSet(resumableStreamIterator, listener)) {
      assertTrue(grpcResultSet.next());
      assertEquals("k1", grpcResultSet.getString(0));
      assertEquals("v1", grpcResultSet.getString(1));
      assertTrue(resumableStreamIterator.isWithBeginTransaction());
      assertTrue(resumableStreamIterator.isLastStatement());
      assertFalse(grpcResultSet.next());
    }

    verify(listener).onTransactionMetadata(expectedTransaction, true);
    verify(listener).onDone(true);
  }

  @Test
  public void isWithBeginTransactionAndLastStatementFalseWhenNotSetOnGrpcStreamIterator() {
    initWithLimit(10);
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    GrpcStreamIterator grpcStream = new GrpcStreamIterator(false, 4, false);
    grpcStream.setCall(call, false);
    when(starter.startStream(null, null)).thenReturn(grpcStream);

    resumableStreamIterator.initiateStreaming(null);
    assertFalse(resumableStreamIterator.isWithBeginTransaction());
    assertFalse(resumableStreamIterator.isLastStatement());
  }

  @Test(timeout = 10_000)
  public void initiateStreamingStartsStreamAndDeliversRowsToAsyncResultSet() throws Exception {
    initWithLimit(10);
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(starter.startStream(Mockito.isNull(), Mockito.any()))
        .thenAnswer(
            invocation -> {
              StreamMessageListener listener = invocation.getArgument(1);
              GrpcStreamIterator grpcStream = new GrpcStreamIterator(false, 4, false);
              if (listener != null) {
                grpcStream.registerListener(listener);
              }
              grpcStream.setCall(call, false);
              grpcStream
                  .consumer()
                  .onPartialResultSet(
                      PartialResultSet.newBuilder()
                          .setMetadata(MockSpannerTestUtil.READ_KEY_VALUE_METADATA)
                          .setResumeToken(ByteString.copyFromUtf8("r1"))
                          .setLast(true)
                          .addValues(Value.newBuilder().setStringValue("k1"))
                          .addValues(Value.newBuilder().setStringValue("v1"))
                          .build());
              grpcStream.consumer().onCompleted();
              return grpcStream;
            });

    ExecutorProvider executorProvider =
        SpannerOptions.createAsyncExecutorProvider(1, 1L, TimeUnit.SECONDS);
    List<String> receivedRows = new ArrayList<>();
    try (GrpcResultSet grpcResultSet =
            new GrpcResultSet(resumableStreamIterator, mockErrorAndDoneListener());
        AsyncResultSetImpl asyncResultSet =
            new AsyncResultSetImpl(
                executorProvider, grpcResultSet, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> callbackFuture =
          asyncResultSet.setCallback(
              MoreExecutors.directExecutor(),
              resultSet -> {
                while (true) {
                  switch (resultSet.tryNext()) {
                    case OK:
                      receivedRows.add(resultSet.getString(0) + ":" + resultSet.getString(1));
                      break;
                    case DONE:
                      return CallbackResponse.DONE;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                  }
                }
              });
      callbackFuture.get(5, TimeUnit.SECONDS);
    } finally {
      executorProvider.getExecutor().shutdown();
    }

    verify(call).request(4);
    assertEquals(ImmutableList.of("k1:v1"), receivedRows);
  }

  @Test
  public void initiateStreamingWhenClosedReturnsFalse() {
    initWithLimit(10);
    resumableStreamIterator.close("already closed");
    StreamMessageListener streamMessageListener = mock(StreamMessageListener.class);
    assertFalse(resumableStreamIterator.initiateStreaming(streamMessageListener));
    verify(starter, Mockito.never()).startStream(Mockito.any(), Mockito.any());
  }

  @Test
  public void isDataAvailableHoldingBackNonResumeTokenChunksPreventsDataDuplicationOnRetry() {
    initWithLimit(10);
    GrpcStreamIterator grpcStream1 = new GrpcStreamIterator(false, 4, false);
    SpannerRpc.StreamingCall call1 = mock(SpannerRpc.StreamingCall.class);
    grpcStream1.setCall(call1, false);

    GrpcStreamIterator grpcStream2 = new GrpcStreamIterator(false, 4, false);
    SpannerRpc.StreamingCall call2 = mock(SpannerRpc.StreamingCall.class);
    grpcStream2.setCall(call2, false);

    when(starter.startStream(null, null)).thenReturn(grpcStream1);
    when(starter.startStream(ByteString.copyFromUtf8("r1"), null)).thenReturn(grpcStream2);

    // Initial stream delivers chunk 1 with resume token "r1".
    grpcStream1.consumer().onPartialResultSet(resultSet(ByteString.copyFromUtf8("r1"), "val1"));
    assertTrue(resumableStreamIterator.hasNext());
    assertEquals("val1", resumableStreamIterator.next().getValues(0).getStringValue());

    // Chunk 2 arrives WITHOUT a resume token. isDataAvailable() MUST return false to hold it back.
    grpcStream1.consumer().onPartialResultSet(resultSet(null, "val2"));
    assertFalse(resumableStreamIterator.isDataAvailable());

    // Stream 1 encounters a transient retryable error before a resume token arrives.
    grpcStream1
        .consumer()
        .onError(new RetryableException(errorCodeParameter, "transient network disconnect"));

    // Resumed stream restarts at token "r1" and replays "val2", followed by "val3" with token "r2".
    grpcStream2.consumer().onPartialResultSet(resultSet(null, "val2"));
    grpcStream2.consumer().onPartialResultSet(resultSet(ByteString.copyFromUtf8("r2"), "val3"));
    grpcStream2.consumer().onCompleted();

    // Error on stream 1 cannot be polled without blocking, but isDataAvailable() returns true to
    // prompt the consumer to call hasNext() and trigger the retry onto stream 2.
    assertFalse(resumableStreamIterator.canPollWithoutErrorOrBlocking());
    assertTrue(resumableStreamIterator.isDataAvailable());
    assertTrue(resumableStreamIterator.hasNext());
    assertEquals("val2", resumableStreamIterator.next().getValues(0).getStringValue());
    assertTrue(resumableStreamIterator.hasNext());
    assertEquals("val3", resumableStreamIterator.next().getValues(0).getStringValue());
    assertFalse(resumableStreamIterator.hasNext());
  }

  @Test
  public void asynchronousChunkProductionWithInterleavedIsDataAvailableAndNext() throws Exception {
    initWithLimit(512);
    GrpcStreamIterator grpcStream = new GrpcStreamIterator(false, 4, false);
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    grpcStream.setCall(call, false);
    when(starter.startStream(null, null)).thenReturn(grpcStream);
    resumableStreamIterator.initiateStreaming(null);

    int totalChunks = 50;
    ExecutorService producerExecutor = Executors.newSingleThreadExecutor();
    try {
      Future<?> producerFuture =
          producerExecutor.submit(
              () -> {
                for (int i = 0; i < totalChunks; i++) {
                  ByteString token = i % 3 == 0 ? ByteString.copyFromUtf8("token" + i) : null;
                  grpcStream.consumer().onPartialResultSet(resultSet(token, "chunk_" + i));
                  Thread.yield();
                }
                grpcStream.consumer().onCompleted();
              });

      long deadlineNanos = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
      List<String> receivedValues = new ArrayList<>();
      while (receivedValues.size() < totalChunks) {
        if (System.nanoTime() > deadlineNanos) {
          fail("Timed out waiting for chunks to be produced and consumed");
        }
        if (resumableStreamIterator.isDataAvailable() && resumableStreamIterator.hasNext()) {
          PartialResultSet chunk = resumableStreamIterator.next();
          receivedValues.add(chunk.getValues(0).getStringValue());
        } else {
          Thread.yield();
        }
      }
      producerFuture.get(10, TimeUnit.SECONDS);

      assertEquals(totalChunks, receivedValues.size());
      for (int i = 0; i < totalChunks; i++) {
        assertEquals("chunk_" + i, receivedValues.get(i));
      }
      assertFalse(resumableStreamIterator.hasNext());
    } finally {
      producerExecutor.shutdownNow();
    }
  }

  @Test
  public void computeNextWhenAlreadyClosedReturnsEndOfData() {
    initWithLimit(10);
    resumableStreamIterator.close("pre-closed");
    assertFalse(resumableStreamIterator.hasNext());
    assertThrows(NoSuchElementException.class, () -> resumableStreamIterator.next());
  }

  @Test
  public void retryOnDifferentGrpcChannelWhenSupported() {
    ErrorHandler errorHandler = mock(ErrorHandler.class);
    when(errorHandler.getMaxAttempts()).thenReturn(2);
    when(errorHandler.translateException(Mockito.any()))
        .thenReturn(new RetryOnDifferentGrpcChannelException("channel failed", 1, null));

    final AtomicInteger channelRetries = new AtomicInteger(0);
    ResumableStreamIterator channelRetryIterator =
        new TestResumableStreamIterator(errorHandler) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            return starter.startStream(resumeToken, streamMessageListener);
          }

          @Override
          boolean prepareIteratorForRetryOnDifferentGrpcChannel() {
            channelRetries.incrementAndGet();
            return true;
          }
        };

    ResultSetStream firstStream = mock(ResultSetStream.class);
    ResultSetStream secondStream = mock(ResultSetStream.class);
    when(starter.startStream(null, null))
        .thenReturn(new ResultSetIterator(firstStream))
        .thenReturn(new ResultSetIterator(secondStream));

    when(firstStream.next())
        .thenThrow(new NonRetryableException(ErrorCode.UNAVAILABLE, "transient channel error"));
    when(secondStream.next()).thenReturn(resultSet(null, "success")).thenReturn(null);

    assertEquals("success", channelRetryIterator.next().getValues(0).getStringValue());
    assertEquals(1, channelRetries.get());
  }

  @Test
  public void retryOnDifferentGrpcChannelNotAttemptedWhenPrepareReturnsFalse() {
    ErrorHandler errorHandler = mock(ErrorHandler.class);
    when(errorHandler.getMaxAttempts()).thenReturn(2);
    when(errorHandler.translateException(Mockito.any()))
        .thenReturn(new RetryOnDifferentGrpcChannelException("channel failed", 1, null));

    ResumableStreamIterator channelRetryIterator =
        new TestResumableStreamIterator(errorHandler) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            return starter.startStream(resumeToken, streamMessageListener);
          }
        };

    ResultSetStream firstStream = mock(ResultSetStream.class);
    when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(firstStream));
    when(firstStream.next())
        .thenThrow(new NonRetryableException(ErrorCode.UNAVAILABLE, "transient channel error"));

    SpannerException spannerException =
        assertThrows(SpannerException.class, channelRetryIterator::next);
    assertEquals(ErrorCode.UNAVAILABLE, spannerException.getErrorCode());
  }

  @Test
  public void retryOnDifferentGrpcChannelNotAttemptedWhenMaxAttemptsExceeded() {
    ErrorHandler errorHandler = mock(ErrorHandler.class);
    when(errorHandler.getMaxAttempts()).thenReturn(1);
    when(errorHandler.translateException(Mockito.any()))
        .thenReturn(new RetryOnDifferentGrpcChannelException("channel failed", 1, null));

    ResumableStreamIterator channelRetryIterator =
        new TestResumableStreamIterator(errorHandler) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            return starter.startStream(resumeToken, streamMessageListener);
          }

          @Override
          boolean prepareIteratorForRetryOnDifferentGrpcChannel() {
            return true;
          }
        };

    ResultSetStream firstStream = mock(ResultSetStream.class);
    when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(firstStream));
    when(firstStream.next())
        .thenThrow(new NonRetryableException(ErrorCode.UNAVAILABLE, "transient error"));

    SpannerException spannerException =
        assertThrows(SpannerException.class, channelRetryIterator::next);
    assertEquals(ErrorCode.UNAVAILABLE, spannerException.getErrorCode());
  }

  @Test
  public void retryOnDifferentGrpcChannelNotAttemptedWhenResumeTokenPresent() {
    ErrorHandler errorHandler = mock(ErrorHandler.class);
    when(errorHandler.getMaxAttempts()).thenReturn(5);
    when(errorHandler.translateException(Mockito.any()))
        .thenReturn(new RetryOnDifferentGrpcChannelException("channel failed", 1, null));

    final AtomicBoolean prepareCalled = new AtomicBoolean(false);
    ResumableStreamIterator channelRetryIterator =
        new TestResumableStreamIterator(errorHandler) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            return starter.startStream(resumeToken, streamMessageListener);
          }

          @Override
          boolean prepareIteratorForRetryOnDifferentGrpcChannel() {
            prepareCalled.set(true);
            return true;
          }
        };

    ResultSetStream firstStream = mock(ResultSetStream.class);
    when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(firstStream));
    when(firstStream.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "firstChunk"))
        .thenThrow(new NonRetryableException(ErrorCode.UNAVAILABLE, "error after token"));

    assertEquals("firstChunk", channelRetryIterator.next().getValues(0).getStringValue());
    SpannerException spannerException =
        assertThrows(SpannerException.class, channelRetryIterator::next);
    assertEquals(ErrorCode.UNAVAILABLE, spannerException.getErrorCode());
    assertFalse(prepareCalled.get());
  }

  @Test
  public void unhandledRuntimeExceptionSetsSpanStatusAndThrows() {
    ISpan mockSpan = mock(ISpan.class);
    initWithLimitAndRetrySettings(
        10, RetrySettings.newBuilder().build(), mockTracerWithSpan(mockSpan));

    ResultSetStream firstStream = mock(ResultSetStream.class);
    when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(firstStream));
    when(firstStream.next()).thenThrow(new IllegalStateException("unexpected runtime exception"));

    IllegalStateException thrown =
        assertThrows(IllegalStateException.class, resumableStreamIterator::next);
    assertEquals("unexpected runtime exception", thrown.getMessage());
    verify(mockSpan)
        .addAnnotation(
            Mockito.eq("Stream broken. Not safe to retry"), Mockito.any(Throwable.class));
    verify(mockSpan).setStatus(Mockito.any(Throwable.class));
    verify(mockSpan).end();
  }

  @Test(timeout = 10_000)
  public void startStreamFailureAfterSetStreamDoesNotDeadlockOrStartSecondStream()
      throws Exception {
    AtomicInteger startCount = new AtomicInteger();
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    ISpan span = mock(ISpan.class);

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator(mockTracerWithSpan(span)) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            startCount.incrementAndGet();
            GrpcStreamIterator grpcStream =
                new GrpcStreamIterator(
                    /* lastStatement= */ true, 10, /* cancelQueryWhenClientIsClosed= */ false);
            if (streamMessageListener != null) {
              grpcStream.registerListener(streamMessageListener);
            }
            setStream(grpcStream);
            grpcStream.setCall(call, /* withBeginTransaction= */ true);
            throw new RuntimeException("start failure");
          }
        };

    AbstractResultSet.Listener listener = mockErrorAndDoneListener();
    ExecutorProvider executorProvider =
        SpannerOptions.createAsyncExecutorProvider(1, 1L, TimeUnit.SECONDS);
    AtomicReference<SpannerException> callbackException = new AtomicReference<>();
    try (GrpcResultSet grpcResultSet = new GrpcResultSet(iterator, listener);
        AsyncResultSetImpl asyncResultSet =
            new AsyncResultSetImpl(
                executorProvider, grpcResultSet, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> callbackFuture =
          asyncResultSet.setCallback(
              MoreExecutors.directExecutor(),
              resultSet -> {
                try {
                  resultSet.tryNext();
                } catch (SpannerException spannerException) {
                  callbackException.set(spannerException);
                }
                return CallbackResponse.DONE;
              });

      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> callbackFuture.get(5, TimeUnit.SECONDS));
      assertTrue(executionException.getCause() instanceof SpannerException);
      assertTrue(executionException.getCause().getMessage().contains("start failure"));
    } finally {
      executorProvider.getExecutor().shutdown();
    }

    assertTrue(callbackException.get().getMessage().contains("start failure"));
    assertEquals(1, startCount.get());
    verify(call, Mockito.times(1)).cancel("start failure");
    verify(span, Mockito.times(1)).setStatus(Mockito.any(Throwable.class));
    verify(span, Mockito.times(1)).end();
    verify(listener)
        .onError(Mockito.any(SpannerException.class), Mockito.eq(true), Mockito.eq(true));
    verify(listener).onDone(true);
  }

  @Test
  public void drainPathBufferLimitMissingTokensBecomesUnsafeToRetry() {
    initWithLimit(1);
    GrpcStreamIterator grpcStream = new GrpcStreamIterator(false, 4, false);
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    grpcStream.setCall(call, false);
    when(starter.startStream(null, null)).thenReturn(grpcStream);
    resumableStreamIterator.initiateStreaming(null);

    // Initial chunk with resume token.
    grpcStream.consumer().onPartialResultSet(resultSet(ByteString.copyFromUtf8("r1"), "a"));
    assertTrue(resumableStreamIterator.hasNext());
    assertEquals("a", resumableStreamIterator.next().getValues(0).getStringValue());

    // Deliver 2 chunks without tokens. Buffer limit is 1, so the drain path exceeds maxBufferSize
    // and transitions safeToRetry to false.
    grpcStream.consumer().onPartialResultSet(resultSet(null, "b"));
    grpcStream.consumer().onPartialResultSet(resultSet(null, "c"));
    assertTrue(resumableStreamIterator.canPollWithoutErrorOrBlocking());
    assertEquals("b", resumableStreamIterator.next().getValues(0).getStringValue());
    assertEquals("c", resumableStreamIterator.next().getValues(0).getStringValue());

    // While safeToRetry is false and buffer is empty, even a single tokenless chunk is immediately
    // flushable via canPollWithoutErrorOrBlocking() / isDataAvailable().
    grpcStream.consumer().onPartialResultSet(resultSet(null, "d1"));
    assertTrue(resumableStreamIterator.canPollWithoutErrorOrBlocking());
    assertEquals("d1", resumableStreamIterator.next().getValues(0).getStringValue());

    // Receiving a chunk with a resume token restores safeToRetry to true.
    grpcStream.consumer().onPartialResultSet(resultSet(ByteString.copyFromUtf8("r2"), "e"));
    assertTrue(resumableStreamIterator.isDataAvailable());
    assertEquals("e", resumableStreamIterator.next().getValues(0).getStringValue());

    // Now that safeToRetry is true again, a single tokenless chunk is held back again.
    grpcStream.consumer().onPartialResultSet(resultSet(null, "f"));
    assertFalse(resumableStreamIterator.isDataAvailable());

    // Exceeding maxBufferSize again transitions safeToRetry back to false; a subsequent tokenless
    // chunk "h" is yielded directly via consumeNextFromStream() and the error fails without retry.
    grpcStream.consumer().onPartialResultSet(resultSet(null, "g"));
    assertTrue(resumableStreamIterator.canPollWithoutErrorOrBlocking());
    grpcStream.consumer().onPartialResultSet(resultSet(null, "h"));
    grpcStream.consumer().onError(new RetryableException(errorCodeParameter, "transient error"));

    assertEquals("f", resumableStreamIterator.next().getValues(0).getStringValue());
    assertEquals("g", resumableStreamIterator.next().getValues(0).getStringValue());
    assertEquals("h", resumableStreamIterator.next().getValues(0).getStringValue());
    SpannerException spannerException =
        assertThrows(SpannerException.class, resumableStreamIterator::next);
    assertEquals(errorCodeParameter, spannerException.getErrorCode());
  }

  @Test
  public void closeBeforeSetCallCancelsUnderlyingCallWithMessage() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    ResumableStreamIterator iterator =
        new TestResumableStreamIterator() {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            GrpcStreamIterator stream =
                new GrpcStreamIterator(
                    /* lastStatement= */ false, 10, /* cancelQueryWhenClientIsClosed= */ false);
            setStream(stream);
            close("closing before setCall");
            stream.setCall(call, false);
            return stream;
          }
        };

    iterator.initiateStreaming(null);
    verify(call).cancel("closing before setCall");
  }

  @Test
  public void isWithBeginTransactionAndIsLastStatementPreservedAfterClose() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    ResumableStreamIterator iterator =
        new TestResumableStreamIterator() {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            GrpcStreamIterator stream =
                new GrpcStreamIterator(
                    /* lastStatement= */ true, 10, /* cancelQueryWhenClientIsClosed= */ false);
            setStream(stream);
            stream.setCall(call, /* withBeginTransaction= */ true);
            return stream;
          }
        };

    iterator.initiateStreaming(null);
    assertTrue(iterator.isWithBeginTransaction());
    assertTrue(iterator.isLastStatement());

    iterator.close("closed");
    verify(call).cancel("closed");
    assertTrue(iterator.isWithBeginTransaction());
    assertTrue(iterator.isLastStatement());
  }

  @Test
  public void closeAfterLastTrueWithResumeTokenDoesNotCancelUnderlyingCall() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    ResumableStreamIterator iterator =
        new TestResumableStreamIterator() {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            GrpcStreamIterator stream =
                new GrpcStreamIterator(
                    /* lastStatement= */ false, 10, /* cancelQueryWhenClientIsClosed= */ false);
            setStream(stream);
            stream.setCall(call, false);
            PartialResultSet.Builder builder =
                PartialResultSet.newBuilder()
                    .setResumeToken(ByteString.copyFromUtf8("r1"))
                    .setLast(true);
            for (int i = 0; i < 20; i++) {
              builder.addValuesBuilder().setStringValue("v" + i);
            }
            stream.consumer().onPartialResultSet(builder.build());
            return stream;
          }
        };

    assertTrue(iterator.hasNext());
    PartialResultSet partialResultSet = iterator.next();
    assertEquals(20, partialResultSet.getValuesCount());
    // Closing before calling hasNext() a second time should not cancel the stream because the
    // PartialResultSet had last=true.
    iterator.close("closed early");
    Mockito.verify(call, Mockito.never()).cancel(Mockito.any());
  }

  @Test
  public void closeWithMultipleChunksCancelsUnlessLastTrueChunkWasConsumed() {
    for (boolean consumeSecondChunk : new boolean[] {false, true}) {
      SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
      ResumableStreamIterator iterator =
          new TestResumableStreamIterator() {
            @Override
            CloseableIterator<PartialResultSet> startStream(
                @Nullable ByteString resumeToken,
                @Nullable StreamMessageListener streamMessageListener,
                XGoogSpannerRequestId requestId) {
              GrpcStreamIterator stream =
                  new GrpcStreamIterator(
                      /* lastStatement= */ false, 10, /* cancelQueryWhenClientIsClosed= */ false);
              setStream(stream);
              stream.setCall(call, false);
              PartialResultSet firstChunk =
                  PartialResultSet.newBuilder()
                      .setResumeToken(ByteString.copyFromUtf8("r1"))
                      .setLast(false)
                      .addValues(Value.newBuilder().setStringValue("v1"))
                      .build();
              PartialResultSet secondChunk =
                  PartialResultSet.newBuilder()
                      .setResumeToken(ByteString.copyFromUtf8("r2"))
                      .setLast(true)
                      .addValues(Value.newBuilder().setStringValue("v2"))
                      .build();
              stream.consumer().onPartialResultSet(firstChunk);
              stream.consumer().onPartialResultSet(secondChunk);
              return stream;
            }
          };

      assertTrue(iterator.hasNext());
      assertEquals("v1", iterator.next().getValues(0).getStringValue());
      if (consumeSecondChunk) {
        assertTrue(iterator.hasNext());
        assertEquals("v2", iterator.next().getValues(0).getStringValue());
      }
      iterator.close("closed");
      if (consumeSecondChunk) {
        Mockito.verify(call, Mockito.never()).cancel(Mockito.any());
      } else {
        verify(call).cancel("closed");
      }
    }
  }

  @Test(timeout = 10_000)
  public void closeAfterDrainingChunkPreventsSubsequentReads() {
    initWithLimit(10);
    GrpcStreamIterator grpcStream = new GrpcStreamIterator(false, 4, false);
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    grpcStream.setCall(call, false);
    when(starter.startStream(null, null)).thenReturn(grpcStream);
    resumableStreamIterator.initiateStreaming(null);
    grpcStream.consumer().onPartialResultSet(resultSet(null, "bufferedBeforeClose"));
    assertFalse(resumableStreamIterator.canPollWithoutErrorOrBlocking());
    verify(call, Mockito.times(1)).request(1);
    assertFalse(grpcStream.canPollWithoutErrorOrBlocking());

    resumableStreamIterator.close("closed with buffered chunk");
    assertFalse(resumableStreamIterator.canPollWithoutErrorOrBlocking());
    assertFalse(resumableStreamIterator.hasNext());
  }

  @Test(timeout = 10_000)
  public void closeDuringStreamNextTerminatesCleanlyAndCancelsOnce() {
    AtomicReference<ResumableStreamIterator> iteratorReference = new AtomicReference<>();
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    // GrpcStreamIterator.computeNext() invokes call.request(1) after dequeuing a chunk and before
    // returning it to ResumableStreamIterator.readNextFromStreamIntoBuffer(). Closing the
    // ResumableStreamIterator inside call.request(1) deterministically exercises the race where
    // close() completes while currentStream.next() is in flight.
    Mockito.doAnswer(
            invocation -> {
              iteratorReference.get().close("closed while fetching");
              return null;
            })
        .when(call)
        .request(1);

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator() {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            GrpcStreamIterator stream = new GrpcStreamIterator(false, 10, false);
            setStream(stream);
            stream.setCall(call, false);
            stream.consumer().onPartialResultSet(resultSet(null, "chunkAfterClose"));
            return stream;
          }
        };
    iteratorReference.set(iterator);

    assertFalse(iterator.hasNext());
    assertFalse(iterator.canPollWithoutErrorOrBlocking());
    verify(call).cancel("closed while fetching");
  }

  static PartialResultSet resultSet(@Nullable ByteString resumeToken, String... data) {
    PartialResultSet.Builder builder = PartialResultSet.newBuilder();
    if (resumeToken != null) {
      builder.setResumeToken(resumeToken);
    }
    for (String s : data) {
      builder.addValuesBuilder().setStringValue(s);
    }
    return builder.build();
  }

  static Iterator<String> stringIterator(final Iterator<PartialResultSet> iterator) {
    return new AbstractIterator<String>() {
      private final LinkedList<String> buffer = new LinkedList<>();

      @Override
      protected String computeNext() {
        while (true) {
          if (!buffer.isEmpty()) {
            return buffer.pop();
          }
          if (!iterator.hasNext()) {
            endOfData();
            return null;
          }
          for (Value value : iterator.next().getValuesList()) {
            buffer.add(value.getStringValue());
          }
        }
      }
    };
  }

  @Test
  public void retryOnDifferentGrpcChannelNotAttemptedWhenBufferNotEmptyAndResumeTokenNull() {
    ErrorHandler errorHandler = mock(ErrorHandler.class);
    when(errorHandler.getMaxAttempts()).thenReturn(2);
    when(errorHandler.translateException(Mockito.any()))
        .thenReturn(new RetryOnDifferentGrpcChannelException("channel failed", 1, null));

    ResumableStreamIterator channelRetryIterator =
        new TestResumableStreamIterator(errorHandler) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            return starter.startStream(resumeToken, streamMessageListener);
          }

          @Override
          boolean prepareIteratorForRetryOnDifferentGrpcChannel() {
            return true;
          }
        };

    ResultSetStream firstStream = mock(ResultSetStream.class);
    when(starter.startStream(null, null)).thenAnswer(inv -> new ResultSetIterator(firstStream));
    when(firstStream.next())
        .thenReturn(resultSet(null, "chunkWithoutToken"))
        .thenThrow(new NonRetryableException(ErrorCode.INTERNAL, "transient error"));

    SpannerException spannerException =
        assertThrows(SpannerException.class, channelRetryIterator::next);
    assertEquals(ErrorCode.INTERNAL, spannerException.getErrorCode());
  }

  @Test
  public void retryOnDifferentGrpcChannelNotAttemptedWhenTranslatedExceptionIsNotChannelRetry() {
    ResultSetStream firstStream = mock(ResultSetStream.class);
    when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(firstStream));
    when(firstStream.next())
        .thenThrow(new NonRetryableException(ErrorCode.INTERNAL, "non-channel error"));

    SpannerException spannerException =
        assertThrows(SpannerException.class, resumableStreamIterator::next);
    assertEquals(ErrorCode.INTERNAL, spannerException.getErrorCode());
  }

  @Test(timeout = 10_000)
  public void spanSetStatusCalledExactlyOnceWhenRetryBudgetExhausted() {
    ISpan childSpan = mock(ISpan.class);
    RetrySettings retrySettings = RetrySettings.newBuilder().setMaxAttempts(1).build();

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator(mockTracerWithSpan(childSpan), retrySettings) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            ResultSetStream stream = mock(ResultSetStream.class);
            when(stream.next())
                .thenThrow(new RetryableException(errorCodeParameter, "retryable error"));
            return new ResultSetIterator(stream);
          }
        };

    SpannerException spannerException = assertThrows(SpannerException.class, iterator::next);
    assertEquals(errorCodeParameter, spannerException.getErrorCode());
    Mockito.verify(childSpan, Mockito.times(1)).setStatus(Mockito.any(Throwable.class));
    Mockito.verify(childSpan).end();
  }

  @Test(timeout = 10_000)
  public void closeDuringStreamNextWithCancelledExceptionTerminatesCleanly() throws Exception {
    CountDownLatch consumerStarted = new CountDownLatch(1);
    AtomicReference<Thread> consumerThreadRef = new AtomicReference<>();
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator() {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            GrpcStreamIterator stream = new GrpcStreamIterator(false, 10, false);
            setStream(stream);
            Mockito.doAnswer(
                    invocation -> {
                      String message = invocation.getArgument(0);
                      stream
                          .consumer()
                          .onError(
                              SpannerExceptionFactory.newSpannerException(
                                  ErrorCode.CANCELLED, message));
                      return null;
                    })
                .when(call)
                .cancel(Mockito.any());
            stream.setCall(call, false);
            return stream;
          }
        };

    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
      Future<Boolean> hasNextFuture =
          executor.submit(
              () -> {
                consumerThreadRef.set(Thread.currentThread());
                consumerStarted.countDown();
                return iterator.hasNext();
              });

      assertTrue(consumerStarted.await(5, TimeUnit.SECONDS));
      awaitThreadWaiting(consumerThreadRef.get());

      // Closing the iterator cancels the active gRPC call, which delivers ErrorCode.CANCELLED to
      // the GrpcStreamIterator blocked in stream.take(). ResumableStreamIterator must treat this
      // post-close cancellation as clean EOF rather than throwing CANCELLED to the caller.
      iterator.close("cancelled by user");

      assertFalse(hasNextFuture.get(5, TimeUnit.SECONDS));
      assertTrue(iterator.isClosed());
      verify(call).cancel("cancelled by user");
    } finally {
      executor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void startStreamWhenClosedCancelsStreamCallAndMarksIteratorClosed() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    GrpcStreamIterator stream = new GrpcStreamIterator(false, 10, false);

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator() {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            close("closing");
            setStream(stream);
            stream.setCall(call, false);
            return stream;
          }
        };

    iterator.initiateStreaming(null);
    Mockito.verify(call, Mockito.times(1)).cancel("closing");
    assertTrue(iterator.isClosed());
    assertFalse(iterator.hasNext());
  }

  @Test(timeout = 10_000)
  public void initiateStreamingConcurrentWithImmediateRetryableErrorDoesNotResurrectFailedStream()
      throws Exception {
    AtomicInteger streamAttempts = new AtomicInteger();
    CountDownLatch consumerStarted = new CountDownLatch(1);
    CountDownLatch allowFirstStartStreamToReturn = new CountDownLatch(1);
    AtomicReference<Thread> consumerThreadRef = new AtomicReference<>();

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator() {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            int attempt = streamAttempts.incrementAndGet();
            SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
            GrpcStreamIterator stream = new GrpcStreamIterator(false, 10, false);
            if (streamMessageListener != null) {
              stream.registerListener(streamMessageListener);
            }
            setStream(stream);
            if (attempt == 1) {
              // Simulate an immediate retryable gRPC error arriving before setCall() completes.
              stream
                  .consumer()
                  .onError(new RetryableException(errorCodeParameter, "transient failure"));
              // setCall() flushes pending messages and invokes streamMessageListener synchronously.
              stream.setCall(call, false);
              Uninterruptibles.awaitUninterruptibly(
                  allowFirstStartStreamToReturn, 5, TimeUnit.SECONDS);
            } else {
              stream.setCall(call, false);
              stream
                  .consumer()
                  .onPartialResultSet(
                      PartialResultSet.newBuilder()
                          .setResumeToken(ByteString.copyFromUtf8("r1"))
                          .setLast(true)
                          .addValues(Value.newBuilder().setStringValue("recovered-row"))
                          .build());
              stream.consumer().onCompleted();
            }
            return stream;
          }
        };

    ExecutorService executor = Executors.newFixedThreadPool(2);
    try {
      AtomicReference<Future<PartialResultSet>> consumerFutureRef = new AtomicReference<>();
      Future<Boolean> initiateFuture =
          executor.submit(
              () ->
                  iterator.initiateStreaming(
                      (chunk, full) -> {
                        if (consumerFutureRef.get() == null) {
                          consumerFutureRef.set(
                              executor.submit(
                                  () -> {
                                    consumerThreadRef.set(Thread.currentThread());
                                    consumerStarted.countDown();
                                    return iterator.next();
                                  }));
                        }
                      }));

      assertTrue(consumerStarted.await(5, TimeUnit.SECONDS));
      awaitThreadWaiting(consumerThreadRef.get());
      allowFirstStartStreamToReturn.countDown();

      assertTrue(initiateFuture.get(5, TimeUnit.SECONDS));
      PartialResultSet result = consumerFutureRef.get().get(5, TimeUnit.SECONDS);
      assertEquals("recovered-row", result.getValues(0).getStringValue());
      assertFalse(iterator.hasNext());
      assertEquals(2, streamAttempts.get());
    } finally {
      executor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void isDataAvailableAndReadinessPollingDoNotTouchUninitializedStreamDuringStartStream()
      throws Exception {
    CountDownLatch setStreamCalled = new CountDownLatch(1);
    CountDownLatch allowStartStreamToFail = new CountDownLatch(1);
    AtomicInteger startStreamCalls = new AtomicInteger();

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator() {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            startStreamCalls.incrementAndGet();
            GrpcStreamIterator uninitializedStream = new GrpcStreamIterator(false, 10, false);
            setStream(uninitializedStream);
            setStreamCalled.countDown();
            Uninterruptibles.awaitUninterruptibly(allowStartStreamToFail, 5, TimeUnit.SECONDS);
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.PERMISSION_DENIED, "synchronous start failure");
          }
        };

    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
      Future<?> initiateFuture =
          executor.submit(() -> iterator.initiateStreaming((chunk, full) -> {}));
      assertTrue(setStreamCalled.await(5, TimeUnit.SECONDS));

      // While startStream() is still in flight and setCall() has not been called on the
      // GrpcStreamIterator, polling readiness must not touch or block on the uninitialized stream.
      assertFalse(iterator.canPollWithoutErrorOrBlocking());
      assertFalse(iterator.isDataAvailable());

      allowStartStreamToFail.countDown();
      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> initiateFuture.get(5, TimeUnit.SECONDS));
      assertTrue(executionException.getCause() instanceof SpannerException);
      assertEquals(
          ErrorCode.PERMISSION_DENIED,
          ((SpannerException) executionException.getCause()).getErrorCode());
      assertEquals(1, startStreamCalls.get());
    } finally {
      executor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void waitingConsumerInterruptedDuringStartStreamThrowsCancelledAndPreservesInterruptFlag()
      throws Exception {
    CountDownLatch startStreamEntered = new CountDownLatch(1);
    CountDownLatch allowStartStreamToFinish = new CountDownLatch(1);
    CountDownLatch consumerStarted = new CountDownLatch(1);
    AtomicReference<Thread> consumerThreadRef = new AtomicReference<>();
    AtomicBoolean interruptFlagPreserved = new AtomicBoolean();

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator() {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            startStreamEntered.countDown();
            Uninterruptibles.awaitUninterruptibly(allowStartStreamToFinish, 5, TimeUnit.SECONDS);
            GrpcStreamIterator stream = new GrpcStreamIterator(false, 10, false);
            stream.setCall(mock(SpannerRpc.StreamingCall.class), false);
            stream.consumer().onCompleted();
            return stream;
          }
        };

    ExecutorService executor = Executors.newFixedThreadPool(2);
    try {
      Future<Boolean> initiateFuture = executor.submit(() -> iterator.initiateStreaming(null));
      assertTrue(startStreamEntered.await(5, TimeUnit.SECONDS));

      Future<?> consumerFuture =
          executor.submit(
              () -> {
                consumerThreadRef.set(Thread.currentThread());
                consumerStarted.countDown();
                try {
                  iterator.hasNext();
                } finally {
                  interruptFlagPreserved.set(Thread.interrupted());
                }
              });

      assertTrue(consumerStarted.await(5, TimeUnit.SECONDS));
      awaitThreadWaiting(consumerThreadRef.get());
      consumerThreadRef.get().interrupt();

      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> consumerFuture.get(5, TimeUnit.SECONDS));
      assertTrue(executionException.getCause() instanceof SpannerException);
      assertEquals(
          ErrorCode.CANCELLED, ((SpannerException) executionException.getCause()).getErrorCode());
      assertTrue(interruptFlagPreserved.get());

      allowStartStreamToFinish.countDown();
      assertTrue(initiateFuture.get(5, TimeUnit.SECONDS));
    } finally {
      executor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void waitingConsumerWokenByConcurrentCloseDuringStartStreamTerminatesCleanly()
      throws Exception {
    CountDownLatch startStreamEntered = new CountDownLatch(1);
    CountDownLatch allowStartStreamToFinish = new CountDownLatch(1);
    CountDownLatch consumerStarted = new CountDownLatch(1);
    AtomicReference<Thread> consumerThreadRef = new AtomicReference<>();
    AtomicInteger startStreamCalls = new AtomicInteger();

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator() {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            startStreamCalls.incrementAndGet();
            GrpcStreamIterator stream = new GrpcStreamIterator(false, 10, false);
            setStream(stream);
            startStreamEntered.countDown();
            Uninterruptibles.awaitUninterruptibly(allowStartStreamToFinish, 5, TimeUnit.SECONDS);
            return stream;
          }
        };

    ExecutorService executor = Executors.newFixedThreadPool(2);
    try {
      Future<Boolean> initiateFuture = executor.submit(() -> iterator.initiateStreaming(null));
      assertTrue(startStreamEntered.await(5, TimeUnit.SECONDS));

      Future<Boolean> consumerFuture =
          executor.submit(
              () -> {
                consumerThreadRef.set(Thread.currentThread());
                consumerStarted.countDown();
                return iterator.hasNext();
              });

      assertTrue(consumerStarted.await(5, TimeUnit.SECONDS));
      awaitThreadWaiting(consumerThreadRef.get());

      iterator.close("closed while consumer waiting");
      assertFalse(consumerFuture.get(5, TimeUnit.SECONDS));

      allowStartStreamToFinish.countDown();
      assertTrue(initiateFuture.get(5, TimeUnit.SECONDS));
      assertEquals(1, startStreamCalls.get());
    } finally {
      executor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void requestPrefetchChunksFailureClosesInFlightStream() {
    AtomicInteger startCount = new AtomicInteger();
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    Mockito.doThrow(new RuntimeException("prefetch failed")).when(call).request(10);
    ISpan span = mock(ISpan.class);

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator(mockTracerWithSpan(span)) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            startCount.incrementAndGet();
            GrpcStreamIterator stream =
                new GrpcStreamIterator(
                    /* lastStatement= */ true, 10, /* cancelQueryWhenClientIsClosed= */ false);
            stream.setCall(call, /* withBeginTransaction= */ true);
            return stream;
          }
        };

    RuntimeException initialFailure =
        assertThrows(RuntimeException.class, () -> iterator.initiateStreaming(null));
    assertEquals("prefetch failed", initialFailure.getMessage());
    verify(call, Mockito.times(1)).cancel("prefetch failed");
    verify(span, Mockito.times(1)).setStatus(Mockito.any(Throwable.class));
    verify(span, Mockito.times(1)).end();

    RuntimeException subsequentFailure = assertThrows(RuntimeException.class, iterator::hasNext);
    assertEquals("prefetch failed", subsequentFailure.getMessage());
    assertEquals(1, startCount.get());
  }

  @Test(timeout = 10_000)
  public void closeDuringStartStreamFailureDoesNotDoubleCloseStream() {
    AtomicInteger startCount = new AtomicInteger();
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    ISpan span = mock(ISpan.class);

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator(mockTracerWithSpan(span)) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            startCount.incrementAndGet();
            GrpcStreamIterator stream =
                new GrpcStreamIterator(
                    /* lastStatement= */ false, 10, /* cancelQueryWhenClientIsClosed= */ false);
            setStream(stream);
            stream.setCall(call, /* withBeginTransaction= */ false);
            close("closed before startStream threw");
            throw new RuntimeException("startStream threw after close");
          }
        };

    assertThrows(RuntimeException.class, () -> iterator.initiateStreaming(null));
    verify(call, Mockito.times(1)).cancel("closed before startStream threw");
    verify(call, Mockito.never()).cancel("startStream threw after close");
    verify(span, Mockito.times(1)).setStatus(Mockito.any(Throwable.class));
    verify(span, Mockito.times(1)).end();
    assertFalse(iterator.hasNext());
    assertEquals(1, startCount.get());
  }

  @Test(timeout = 10_000)
  public void contextCancellationDuringRetryBackoffInComputeNextSetsSpanStatusAndEndsSpan() {
    ISpan childSpan = mock(ISpan.class);
    ISpan currentSpan = mock(ISpan.class);
    TraceWrapper tracer = mockTracerWithSpan(childSpan);
    when(tracer.getCurrentSpan()).thenReturn(currentSpan);

    Context.CancellableContext cancellableContext = Context.current().withCancellation();
    Mockito.doAnswer(
            invocation -> {
              cancellableContext.cancel(new InterruptedException("cancelled during retry backoff"));
              return null;
            })
        .when(currentSpan)
        .addAnnotation(Mockito.eq("Backing off"), Mockito.eq("Delay"), Mockito.anyLong());

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator(tracer) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            ResultSetStream stream = mock(ResultSetStream.class);
            when(stream.next())
                .thenThrow(new RetryableException(errorCodeParameter, "transient error"));
            return new ResultSetIterator(stream);
          }
        };

    try {
      cancellableContext.run(
          () -> {
            SpannerException cancelledException =
                assertThrows(SpannerException.class, iterator::next);
            assertEquals(ErrorCode.CANCELLED, cancelledException.getErrorCode());
          });
    } finally {
      cancellableContext.close();
    }
    Mockito.verify(childSpan, Mockito.times(1)).setStatus(Mockito.any(Throwable.class));
    Mockito.verify(childSpan, Mockito.times(1)).end();
  }

  @Test
  public void isDataAvailableLoopsWhenTokenlessChunkArrivesConcurrentlyOnStream() {
    initWithLimit(10);
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    AtomicBoolean deliveredDuringIsDataAvailable = new AtomicBoolean(false);

    GrpcStreamIterator racingStream =
        new GrpcStreamIterator(false, 4, false) {
          @Override
          public boolean isDataAvailable() {
            // Simulate a tokenless chunk arriving on the GrpcStreamIterator right after the
            // initial canPollWithoutErrorOrBlocking() drain check returned false, before
            // currentStream.isDataAvailable() is evaluated.
            if (deliveredDuringIsDataAvailable.compareAndSet(false, true)) {
              consumer().onPartialResultSet(resultSet(null, "tokenlessChunk"));
            }
            return super.isDataAvailable();
          }
        };
    racingStream.setCall(call, false);

    when(starter.startStream(null, null)).thenReturn(racingStream);
    resumableStreamIterator.initiateStreaming(null);

    // Without the loop in isDataAvailable(), this would erroneously return true even though only a
    // single tokenless chunk arrived (which cannot be flushed without blocking on network I/O).
    assertFalse(resumableStreamIterator.isDataAvailable());
    verify(call, Mockito.times(1)).request(1);
    assertFalse(racingStream.canPollWithoutErrorOrBlocking());

    racingStream.consumer().onCompleted();
    assertTrue(resumableStreamIterator.isDataAvailable());
    assertEquals("tokenlessChunk", resumableStreamIterator.next().getValues(0).getStringValue());
    assertFalse(resumableStreamIterator.hasNext());
  }

  @Test(timeout = 10_000)
  public void concurrentCloseDuringIsDataAvailableReturnsTrue() {
    initWithLimit(10);
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    AtomicBoolean closedDuringDrainCheck = new AtomicBoolean(false);

    GrpcStreamIterator racingStream =
        new GrpcStreamIterator(false, 4, false) {
          @Override
          public boolean canPollWithoutErrorOrBlocking() {
            // Simulate a concurrent close() completing right after the initial
            // canPollWithoutErrorOrBlocking() check in isDataAvailable() returns false.
            if (closedDuringDrainCheck.compareAndSet(false, true)) {
              resumableStreamIterator.close("closed concurrently during isDataAvailable");
            }
            return super.canPollWithoutErrorOrBlocking();
          }
        };
    racingStream.setCall(call, false);

    when(starter.startStream(null, null)).thenReturn(racingStream);
    resumableStreamIterator.initiateStreaming(null);

    assertTrue(resumableStreamIterator.isDataAvailable());
    verify(call).cancel("closed concurrently during isDataAvailable");
  }

  @Test(timeout = 10_000)
  public void startGrpcStreamingExceptionInTracerDoesNotDeadlockWaitingConsumer() throws Exception {
    CountDownLatch withSpanEntered = new CountDownLatch(1);
    CountDownLatch allowWithSpanToThrow = new CountDownLatch(1);
    CountDownLatch consumerStarted = new CountDownLatch(1);
    AtomicReference<Thread> consumerThreadRef = new AtomicReference<>();

    ISpan mockSpan = mock(ISpan.class);
    TraceWrapper tracer = mock(TraceWrapper.class);
    when(tracer.spanBuilderWithExplicitParent(Mockito.anyString(), Mockito.any(), Mockito.any()))
        .thenReturn(mockSpan);
    when(tracer.withSpan(mockSpan))
        .thenAnswer(
            invocation -> {
              withSpanEntered.countDown();
              Uninterruptibles.awaitUninterruptibly(allowWithSpanToThrow, 5, TimeUnit.SECONDS);
              throw new RuntimeException("tracer withSpan failed");
            });

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator(tracer) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            throw new AssertionError("startStream should not be reached");
          }
        };

    ExecutorService executor = Executors.newFixedThreadPool(2);
    try {
      Future<Boolean> initiateFuture = executor.submit(() -> iterator.initiateStreaming(null));
      assertTrue(withSpanEntered.await(5, TimeUnit.SECONDS));

      Future<Boolean> consumerFuture =
          executor.submit(
              () -> {
                consumerThreadRef.set(Thread.currentThread());
                consumerStarted.countDown();
                return iterator.hasNext();
              });

      assertTrue(consumerStarted.await(5, TimeUnit.SECONDS));
      awaitThreadWaiting(consumerThreadRef.get());
      allowWithSpanToThrow.countDown();

      ExecutionException leaderException =
          assertThrows(ExecutionException.class, () -> initiateFuture.get(2, TimeUnit.SECONDS));
      assertEquals("tracer withSpan failed", leaderException.getCause().getMessage());

      // Without covering tracer.withSpan(span) in the try/catch block of startGrpcStreaming(),
      // consumerFuture permanently deadlocks in streamLock.wait() and times out here.
      ExecutionException waiterException =
          assertThrows(ExecutionException.class, () -> consumerFuture.get(2, TimeUnit.SECONDS));
      assertEquals("tracer withSpan failed", waiterException.getCause().getMessage());
    } finally {
      executor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void concurrentWaiterInStartGrpcStreamingDoesNotStartSecondStreamWhenLeaderFails()
      throws Exception {
    CountDownLatch startStreamEntered = new CountDownLatch(1);
    CountDownLatch allowStartStreamToFail = new CountDownLatch(1);
    CountDownLatch consumerStarted = new CountDownLatch(1);
    AtomicReference<Thread> consumerThreadRef = new AtomicReference<>();
    AtomicInteger startStreamCalls = new AtomicInteger();

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator() {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            startStreamCalls.incrementAndGet();
            startStreamEntered.countDown();
            Uninterruptibles.awaitUninterruptibly(allowStartStreamToFail, 5, TimeUnit.SECONDS);
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.PERMISSION_DENIED, "leader startStream failed");
          }
        };

    ExecutorService executor = Executors.newFixedThreadPool(2);
    try {
      Future<Boolean> initiateFuture = executor.submit(() -> iterator.initiateStreaming(null));
      assertTrue(startStreamEntered.await(5, TimeUnit.SECONDS));

      Future<Boolean> consumerFuture =
          executor.submit(
              () -> {
                consumerThreadRef.set(Thread.currentThread());
                consumerStarted.countDown();
                return iterator.hasNext();
              });

      assertTrue(consumerStarted.await(5, TimeUnit.SECONDS));
      awaitThreadWaiting(consumerThreadRef.get());
      allowStartStreamToFail.countDown();

      ExecutionException leaderException =
          assertThrows(ExecutionException.class, () -> initiateFuture.get(5, TimeUnit.SECONDS));
      assertTrue(leaderException.getCause() instanceof SpannerException);
      assertEquals(
          ErrorCode.PERMISSION_DENIED,
          ((SpannerException) leaderException.getCause()).getErrorCode());

      ExecutionException waiterException =
          assertThrows(ExecutionException.class, () -> consumerFuture.get(5, TimeUnit.SECONDS));
      assertTrue(waiterException.getCause() instanceof SpannerException);
      assertEquals(
          ErrorCode.PERMISSION_DENIED,
          ((SpannerException) waiterException.getCause()).getErrorCode());

      // The waiting consumer thread must fail with the leader's startup failure rather than
      // initiating a second startStream() call.
      assertEquals(1, startStreamCalls.get());
    } finally {
      executor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void errorInStartStreamDoesNotDeadlockWaitingFollowerAndClosesInFlightStreamAndSpan()
      throws Exception {
    AtomicInteger startCount = new AtomicInteger();
    CountDownLatch consumerWaitingLatch = new CountDownLatch(1);
    CountDownLatch allowStartStreamToThrowError = new CountDownLatch(1);
    AtomicReference<Thread> consumerThreadRef = new AtomicReference<>();
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    ISpan span = mock(ISpan.class);

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator(mockTracerWithSpan(span)) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            startCount.incrementAndGet();
            GrpcStreamIterator stream =
                new GrpcStreamIterator(
                    /* lastStatement= */ true, 10, /* cancelQueryWhenClientIsClosed= */ false);
            if (streamMessageListener != null) {
              stream.registerListener(streamMessageListener);
            }
            setStream(stream);
            stream.setCall(call, /* withBeginTransaction= */ true);
            consumerWaitingLatch.countDown();
            Uninterruptibles.awaitUninterruptibly(
                allowStartStreamToThrowError, 5, TimeUnit.SECONDS);
            throw new AssertionError("fatal error during startStream");
          }
        };

    AbstractResultSet.Listener listener = mockErrorAndDoneListener();
    ExecutorService executor = Executors.newFixedThreadPool(2);
    try (GrpcResultSet grpcResultSet = new GrpcResultSet(iterator, listener)) {
      Future<Boolean> initiateFuture = executor.submit(() -> iterator.initiateStreaming(null));
      assertTrue(consumerWaitingLatch.await(5, TimeUnit.SECONDS));

      CountDownLatch followerEntered = new CountDownLatch(1);
      Future<Boolean> followerFuture =
          executor.submit(
              () -> {
                consumerThreadRef.set(Thread.currentThread());
                followerEntered.countDown();
                return grpcResultSet.next();
              });

      assertTrue(followerEntered.await(5, TimeUnit.SECONDS));
      awaitThreadWaiting(consumerThreadRef.get());
      allowStartStreamToThrowError.countDown();

      ExecutionException leaderException =
          assertThrows(ExecutionException.class, () -> initiateFuture.get(2, TimeUnit.SECONDS));
      assertTrue(leaderException.getCause() instanceof AssertionError);
      assertEquals("fatal error during startStream", leaderException.getCause().getMessage());

      ExecutionException followerException =
          assertThrows(ExecutionException.class, () -> followerFuture.get(2, TimeUnit.SECONDS));
      assertTrue(followerException.getCause() instanceof SpannerException);
      assertTrue(followerException.getCause().getCause() instanceof AssertionError);
      assertEquals(
          "fatal error during startStream", followerException.getCause().getCause().getMessage());

      verify(listener, Mockito.times(1))
          .onError(Mockito.any(SpannerException.class), Mockito.eq(true), Mockito.eq(true));
      verify(listener, Mockito.times(1)).onDone(true);

      assertEquals(1, startCount.get());
      verify(call, Mockito.times(1)).cancel("fatal error during startStream");
      verify(span, Mockito.times(1)).setStatus(Mockito.any(Throwable.class));
      verify(span, Mockito.times(1)).end();
      assertTrue(iterator.isWithBeginTransaction());
      assertTrue(iterator.isLastStatement());
    } finally {
      executor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void
      concurrentCloseDuringStartStreamAfterSetCallCapturesWithBeginTransactionAndClosesStreamOnce()
          throws Exception {
    CountDownLatch setCallCompleted = new CountDownLatch(1);
    CountDownLatch allowStartStreamToReturn = new CountDownLatch(1);
    AtomicInteger streamCloseCount = new AtomicInteger();
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    ISpan span = mock(ISpan.class);

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator(mockTracerWithSpan(span)) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            GrpcStreamIterator stream =
                new GrpcStreamIterator(
                    /* lastStatement= */ true, 10, /* cancelQueryWhenClientIsClosed= */ false) {
                  @Override
                  public void close(@Nullable String message) {
                    streamCloseCount.incrementAndGet();
                    super.close(message);
                  }
                };
            // Register the stream early before stream.setCall(...) sets withBeginTransaction.
            setStream(stream);
            stream.setCall(call, /* withBeginTransaction= */ true);
            setCallCompleted.countDown();
            Uninterruptibles.awaitUninterruptibly(allowStartStreamToReturn, 5, TimeUnit.SECONDS);
            return stream;
          }
        };

    AbstractResultSet.Listener listener = mockErrorAndDoneListener();
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try (GrpcResultSet grpcResultSet = new GrpcResultSet(iterator, listener)) {
      Future<Boolean> initiateFuture = executor.submit(() -> iterator.initiateStreaming(null));
      assertTrue(setCallCompleted.await(5, TimeUnit.SECONDS));

      // Close while startStream() is still in flight after setCall(call, true) has completed.
      grpcResultSet.close();

      // Immediately after close() returns (before startStream() returns), withBeginTransaction and
      // lastStatement must already reflect the in-flight stream's state, and GrpcResultSet.close()
      // must have notified listener.onDone(true).
      verify(listener, Mockito.times(1)).onDone(true);
      assertTrue(iterator.isWithBeginTransaction());
      assertTrue(iterator.isLastStatement());
      assertEquals(1, streamCloseCount.get());
      verify(call, Mockito.times(1)).cancel("ResultSet closed");

      allowStartStreamToReturn.countDown();
      assertTrue(initiateFuture.get(5, TimeUnit.SECONDS));

      // Returning the same in-flight stream from startStream() to startGrpcStreaming() must not
      // close the stream a second time.
      assertEquals(1, streamCloseCount.get());
      verify(call, Mockito.times(1)).cancel("ResultSet closed");
      verify(span, Mockito.times(1)).end();
      assertTrue(iterator.isWithBeginTransaction());
      assertTrue(iterator.isLastStatement());
    } finally {
      executor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void canPollWithoutErrorOrBlockingStopsDrainingAndReturnsFalseWhenClosedConcurrently() {
    initWithLimit(10);
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    GrpcStreamIterator grpcStream = new GrpcStreamIterator(false, 10, false);
    grpcStream.setCall(call, false);
    when(starter.startStream(null, null)).thenReturn(grpcStream);
    resumableStreamIterator.initiateStreaming(null);

    // Enqueue two tokenless chunks so drainAvailableFromStream() would normally pull both.
    grpcStream.consumer().onPartialResultSet(resultSet(null, "chunk1"));
    grpcStream.consumer().onPartialResultSet(resultSet(null, "chunk2"));

    // Close the ResumableStreamIterator while the first chunk is being dequeued in
    // GrpcStreamIterator.computeNext() -> call.request(1).
    Mockito.doAnswer(
            invocation -> {
              resumableStreamIterator.close("closed while draining");
              return null;
            })
        .when(call)
        .request(1);

    assertFalse(resumableStreamIterator.canPollWithoutErrorOrBlocking());
    assertFalse(resumableStreamIterator.hasNext());
    // Must stop draining immediately after the first chunk rather than pulling the second chunk:
    // chunk2 must still be sitting unconsumed in grpcStream.
    assertTrue(grpcStream.canPollWithoutErrorOrBlocking());
    assertEquals("chunk2", grpcStream.next().getValues(0).getStringValue());
    verify(call, Mockito.times(1)).request(1);
    verify(call, Mockito.times(1)).cancel("closed while draining");
  }

  @Test(timeout = 10_000)
  public void
      startStreamFailureAfterSetCallReportsDataAvailableAndPreservesWithBeginTransactionForGrpcResultSet() {
    AtomicInteger startCount = new AtomicInteger();
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    Mockito.doThrow(new RuntimeException("prefetch failed after setCall")).when(call).request(10);
    ISpan span = mock(ISpan.class);

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator(mockTracerWithSpan(span)) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            startCount.incrementAndGet();
            GrpcStreamIterator stream =
                new GrpcStreamIterator(
                    /* lastStatement= */ true, 10, /* cancelQueryWhenClientIsClosed= */ false);
            if (streamMessageListener != null) {
              stream.registerListener(streamMessageListener);
            }
            // Register the stream early before stream.setCall(call, withBeginTransaction) sets
            // withBeginTransaction = true.
            setStream(stream);
            assertFalse(stream.isWithBeginTransaction());
            stream.setCall(call, /* withBeginTransaction= */ true);
            assertTrue(stream.isWithBeginTransaction());
            stream.requestPrefetchChunks();
            return stream;
          }
        };

    AbstractResultSet.Listener listener = mockErrorAndDoneListener();
    try (GrpcResultSet grpcResultSet = new GrpcResultSet(iterator, listener)) {
      RuntimeException initialFailure =
          assertThrows(
              RuntimeException.class,
              () -> grpcResultSet.initiateStreaming(mock(StreamMessageListener.class)));
      assertEquals("prefetch failed after setCall", initialFailure.getMessage());

      // Even before GrpcResultSet or the caller closes the iterator, the recorded startup failure
      // is immediately available to surface without blocking on network I/O, and
      // resetStreamOnFailure() must have captured withBeginTransaction = true from inFlightStream.
      assertFalse(iterator.canPollWithoutErrorOrBlocking());
      assertTrue(iterator.isDataAvailable());
      assertTrue(iterator.isWithBeginTransaction());
      assertTrue(iterator.isLastStatement());

      SpannerException surfacedException =
          assertThrows(SpannerException.class, grpcResultSet::next);
      assertTrue(surfacedException.getMessage().contains("prefetch failed after setCall"));
    }
    assertEquals(1, startCount.get());
    verify(listener)
        .onError(Mockito.any(SpannerException.class), Mockito.eq(true), Mockito.eq(true));
    verify(listener).onDone(true);
    verify(call, Mockito.times(1)).cancel("prefetch failed after setCall");
    verify(span, Mockito.times(1)).setStatus(Mockito.any(Throwable.class));
    verify(span, Mockito.times(1)).end();
  }

  @Test(timeout = 10_000)
  public void withBeginTransactionAndLastStatementPreservedWhenCancelledDuringRetryBackoff()
      throws Exception {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    ISpan span = mock(ISpan.class);
    ISpan currentSpan = mock(ISpan.class);
    TraceWrapper tracer = mockTracerWithSpan(span);
    when(tracer.getCurrentSpan()).thenReturn(currentSpan);

    Context.CancellableContext cancellableContext = Context.current().withCancellation();
    Mockito.doAnswer(
            invocation -> {
              cancellableContext.cancel(new InterruptedException("cancelled during retry backoff"));
              return null;
            })
        .when(currentSpan)
        .addAnnotation(Mockito.eq("Backing off"), Mockito.eq("Delay"), Mockito.anyLong());

    ResumableStreamIterator iterator =
        new TestResumableStreamIterator(tracer) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            GrpcStreamIterator stream =
                new GrpcStreamIterator(
                    /* lastStatement= */ true, 10, /* cancelQueryWhenClientIsClosed= */ false);
            stream.setCall(call, /* withBeginTransaction= */ true);
            stream
                .consumer()
                .onError(new RetryableException(errorCodeParameter, "transient error"));
            return stream;
          }
        };

    AbstractResultSet.Listener listener = mockErrorAndDoneListener();
    try (GrpcResultSet grpcResultSet = new GrpcResultSet(iterator, listener)) {
      SpannerException thrown =
          cancellableContext.call(() -> assertThrows(SpannerException.class, grpcResultSet::next));
      assertEquals(ErrorCode.CANCELLED, thrown.getErrorCode());
    } finally {
      cancellableContext.close();
    }

    verify(listener)
        .onError(Mockito.any(SpannerException.class), Mockito.eq(true), Mockito.eq(true));
    verify(listener).onDone(true);
    verify(span, Mockito.times(1)).setStatus(Mockito.any(Throwable.class));
    verify(span, Mockito.times(1)).end();
  }

  @Test
  public void unhandledErrorInStreamNextSetsSpanStatusAndThrows() {
    ISpan mockSpan = mock(ISpan.class);
    initWithLimitAndRetrySettings(
        10, RetrySettings.newBuilder().build(), mockTracerWithSpan(mockSpan));

    ResultSetStream firstStream = mock(ResultSetStream.class);
    when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(firstStream));
    when(firstStream.next()).thenThrow(new AssertionError("unexpected error in stream.next"));

    AssertionError thrown = assertThrows(AssertionError.class, resumableStreamIterator::next);
    assertEquals("unexpected error in stream.next", thrown.getMessage());
    verify(mockSpan)
        .addAnnotation(
            Mockito.eq("Stream broken. Not safe to retry"), Mockito.any(Throwable.class));
    verify(mockSpan).setStatus(Mockito.any(Throwable.class));
    verify(mockSpan).end();
  }

  @Test(timeout = 10_000)
  public void closeDuringRequestPrefetchChunksCancelsOnceAndTerminatesCleanly() {
    AtomicInteger startCount = new AtomicInteger();
    AtomicReference<ResumableStreamIterator> iteratorRef = new AtomicReference<>();
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    Mockito.doAnswer(
            invocation -> {
              iteratorRef.get().close("closed during prefetch");
              return null;
            })
        .when(call)
        .request(10);

    ISpan span = mock(ISpan.class);
    ResumableStreamIterator iterator =
        new TestResumableStreamIterator(mockTracerWithSpan(span)) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            startCount.incrementAndGet();
            GrpcStreamIterator stream = new GrpcStreamIterator(true, 10, false);
            stream.setCall(call, true);
            return stream;
          }
        };
    iteratorRef.set(iterator);

    assertTrue(iterator.initiateStreaming(null));
    assertFalse(iterator.hasNext());
    assertEquals(1, startCount.get());
    verify(call, Mockito.times(1)).cancel("closed during prefetch");
    verify(span, Mockito.times(1)).end();
  }

  @Test(timeout = 10_000)
  public void
      retryableStreamErrorDuringInitialStartStreamIsRetriedWhileSynchronousStartStreamExceptionFailsFast() {
    // 1. A retryable stream error delivered via the gRPC stream consumer during initial
    // startStream() is retried transparently and yields rows from the restarted stream.
    AtomicInteger streamStartCount = new AtomicInteger();
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    ISpan successSpan = mock(ISpan.class);
    Transaction expectedTransaction =
        Transaction.newBuilder().setId(ByteString.copyFromUtf8("tx-1")).build();
    ResumableStreamIterator retryingIterator =
        new TestResumableStreamIterator(mockTracerWithSpan(successSpan)) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            int attempt = streamStartCount.incrementAndGet();
            GrpcStreamIterator stream = new GrpcStreamIterator(true, 10, false);
            if (streamMessageListener != null) {
              stream.registerListener(streamMessageListener);
            }
            setStream(stream);
            stream.setCall(call, true);
            if (attempt == 1) {
              stream
                  .consumer()
                  .onError(new RetryableException(errorCodeParameter, "initial stream failed"));
            } else {
              stream
                  .consumer()
                  .onPartialResultSet(
                      PartialResultSet.newBuilder()
                          .setMetadata(
                              MockSpannerTestUtil.READ_KEY_VALUE_METADATA.toBuilder()
                                  .setTransaction(expectedTransaction)
                                  .build())
                          .setResumeToken(ByteString.copyFromUtf8("r1"))
                          .setLast(true)
                          .addValues(Value.newBuilder().setStringValue("k1"))
                          .addValues(Value.newBuilder().setStringValue("v1"))
                          .build());
              stream.consumer().onCompleted();
            }
            return stream;
          }
        };

    AbstractResultSet.Listener successListener = mockErrorAndDoneListener();
    try (GrpcResultSet grpcResultSet = new GrpcResultSet(retryingIterator, successListener)) {
      grpcResultSet.initiateStreaming(mock(StreamMessageListener.class));
      assertTrue(grpcResultSet.next());
      assertEquals("k1", grpcResultSet.getString(0));
      assertEquals("v1", grpcResultSet.getString(1));
      assertFalse(grpcResultSet.next());
    }
    assertEquals(2, streamStartCount.get());
    verify(successListener).onTransactionMetadata(expectedTransaction, true);
    verify(successListener).onDone(true);
    verify(successSpan, Mockito.times(1)).end();

    // 2. A synchronous exception thrown directly by startStream() itself (even with a retryable
    // error code) is a fatal pre-stream failure: it records the failure on the span, ends the span
    // once, and fails fast on subsequent calls without re-invoking startStream().
    AtomicInteger syncFailStartCount = new AtomicInteger();
    ISpan failSpan = mock(ISpan.class);
    ResumableStreamIterator failingIterator =
        new TestResumableStreamIterator(mockTracerWithSpan(failSpan)) {
          @Override
          CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              @Nullable StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            syncFailStartCount.incrementAndGet();
            throw new RetryableException(errorCodeParameter, "synchronous startStream failure");
          }
        };

    AbstractResultSet.Listener failListener = mockErrorAndDoneListener();
    try (GrpcResultSet failingResultSet = new GrpcResultSet(failingIterator, failListener)) {
      SpannerException initialException =
          assertThrows(
              SpannerException.class,
              () -> failingResultSet.initiateStreaming(mock(StreamMessageListener.class)));
      assertEquals(errorCodeParameter, initialException.getErrorCode());
      assertTrue(failingIterator.isDataAvailable());

      SpannerException subsequentException =
          assertThrows(SpannerException.class, failingResultSet::next);
      assertEquals(errorCodeParameter, subsequentException.getErrorCode());
    }
    assertEquals(1, syncFailStartCount.get());
    verify(failSpan, Mockito.times(1)).setStatus(Mockito.any(Throwable.class));
    verify(failSpan, Mockito.times(1)).end();
  }

  @Test(timeout = 10_000)
  public void concurrentCloseDuringReadinessPollingDoesNotThrowCancelledException() {
    for (boolean pollViaIsDataAvailable : new boolean[] {false, true}) {
      AtomicReference<ResumableStreamIterator> iteratorRef = new AtomicReference<>();
      SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
      Mockito.doAnswer(
              invocation -> {
                iteratorRef.get().close("closed while polling");
                throw SpannerExceptionFactory.newSpannerException(
                    ErrorCode.CANCELLED, "closed while polling");
              })
          .when(call)
          .request(1);

      ISpan span = mock(ISpan.class);
      ResumableStreamIterator iterator =
          new TestResumableStreamIterator(mockTracerWithSpan(span)) {
            @Override
            CloseableIterator<PartialResultSet> startStream(
                @Nullable ByteString resumeToken,
                @Nullable StreamMessageListener streamMessageListener,
                XGoogSpannerRequestId requestId) {
              GrpcStreamIterator stream = new GrpcStreamIterator(false, 10, false);
              setStream(stream);
              stream.setCall(call, false);
              stream.consumer().onPartialResultSet(resultSet(null, "chunk1"));
              return stream;
            }
          };
      iteratorRef.set(iterator);
      assertTrue(iterator.initiateStreaming(null));

      if (pollViaIsDataAvailable) {
        assertTrue(iterator.isDataAvailable());
      } else {
        assertFalse(iterator.canPollWithoutErrorOrBlocking());
      }
      assertFalse(iterator.canPollWithoutErrorOrBlocking());
      assertTrue(iterator.isDataAvailable());
      assertFalse(iterator.hasNext());
      verify(call, Mockito.times(1)).cancel("closed while polling");
      verify(span, Mockito.times(1)).end();
    }
  }

  private abstract static class TestResumableStreamIterator extends ResumableStreamIterator {
    TestResumableStreamIterator() {
      this(new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false));
    }

    TestResumableStreamIterator(TraceWrapper tracer) {
      this(
          tracer,
          DefaultErrorHandler.INSTANCE,
          SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings());
    }

    TestResumableStreamIterator(ErrorHandler errorHandler) {
      this(
          new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false),
          errorHandler,
          SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings());
    }

    TestResumableStreamIterator(TraceWrapper tracer, RetrySettings retrySettings) {
      this(tracer, DefaultErrorHandler.INSTANCE, retrySettings);
    }

    TestResumableStreamIterator(
        TraceWrapper tracer, ErrorHandler errorHandler, RetrySettings retrySettings) {
      super(
          10,
          "",
          mockOpenTelemetrySpan(),
          tracer,
          errorHandler,
          retrySettings,
          SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
          NoopRequestIdCreator.INSTANCE);
    }
  }

  private static TraceWrapper mockTracerWithSpan(ISpan span) {
    TraceWrapper tracer = mock(TraceWrapper.class);
    when(tracer.spanBuilderWithExplicitParent(Mockito.any(), Mockito.any(), Mockito.any()))
        .thenReturn(span);
    when(tracer.withSpan(span)).thenReturn(() -> {});
    when(tracer.getCurrentSpan()).thenReturn(span);
    return tracer;
  }

  private static AbstractResultSet.Listener mockErrorAndDoneListener() {
    AbstractResultSet.Listener listener = mock(AbstractResultSet.Listener.class);
    when(listener.onError(Mockito.any(), Mockito.anyBoolean(), Mockito.anyBoolean()))
        .thenAnswer(invocation -> invocation.getArgument(0));
    return listener;
  }

  private static void awaitThreadWaiting(Thread thread) {
    long deadlineNanos = System.nanoTime() + TimeUnit.SECONDS.toNanos(5);
    while (thread.getState() != Thread.State.WAITING
        && thread.getState() != Thread.State.TIMED_WAITING) {
      if (System.nanoTime() > deadlineNanos) {
        fail("Timed out waiting for thread to enter WAITING state; current=" + thread.getState());
      }
      Thread.yield();
    }
  }

  static List<String> consume(Iterator<PartialResultSet> iterator) {
    return Lists.newArrayList(stringIterator(iterator));
  }

  static List<String> consumeAtMost(int n, Iterator<PartialResultSet> iterator) {
    Iterator<String> stringIterator = stringIterator(iterator);
    List<String> r = new ArrayList<>(n);
    for (int i = 0; i < n; ++i) {
      if (stringIterator.hasNext()) {
        r.add(stringIterator.next());
      }
    }
    return r;
  }
}
