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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.cloud.spanner.ErrorHandler.DefaultErrorHandler;
import com.google.cloud.spanner.XGoogSpannerRequestId.NoopRequestIdCreator;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
import com.google.common.base.Stopwatch;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import com.google.protobuf.Value;
import com.google.rpc.RetryInfo;
import com.google.spanner.v1.PartialResultSet;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracing;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.LongSupplier;
import javax.annotation.Nullable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;
import org.threeten.bp.Duration;

/** Unit tests for {@link ResumableStreamIterator}. */
@RunWith(Parameterized.class)
public class ResumableStreamIteratorTest {
  interface Starter {
    AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
        @Nullable ByteString resumeToken,
        AsyncResultSet.StreamMessageListener streamMessageListener);
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
                com.google.protobuf.Duration.newBuilder()
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
      implements AbstractResultSet.CloseableIterator<PartialResultSet> {
    final ResultSetStream stream;

    ResultSetIterator(ResultSetStream stream) {
      this.stream = stream;
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

  private void initWithLimitAndRetrySettings(
      int maxBufferSize, RetrySettings retrySettings, TraceWrapper tracer) {
    resumableStreamIterator =
        new ResumableStreamIterator(
            maxBufferSize,
            "",
            new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)),
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
          AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              AsyncResultSet.StreamMessageListener streamMessageListener,
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
    Mockito.when(starter.startStream(null, null)).thenReturn(grpcStream);
    resumableStreamIterator.setStream(grpcStream);

    // Empty stream -> false
    assertFalse(resumableStreamIterator.isDataAvailable());

    // Chunk without resume token arrives -> drained into buffer, but not flushable yet until a
    // resume token or EOF arrives (or maxBufferSize is exceeded).
    grpcStream.consumer().onPartialResultSet(resultSet(null, "a"));
    assertFalse(resumableStreamIterator.isDataAvailable());
    assertEquals(1, resumableStreamIterator.buffer.size());

    grpcStream.consumer().onCompleted();
    assertTrue(resumableStreamIterator.isDataAvailable());
  }

  @Test
  public void isDataAvailableWithoutResumeTokensWithProductionBufferSize() throws Exception {
    initWithLimit(512);
    GrpcStreamIterator grpcStream = new GrpcStreamIterator(false, 4, false);
    SpannerRpc.StreamingCall call = Mockito.mock(SpannerRpc.StreamingCall.class);
    grpcStream.setCall(call, false);
    Mockito.when(starter.startStream(null, null)).thenReturn(grpcStream);
    resumableStreamIterator.setStream(grpcStream);

    assertFalse(resumableStreamIterator.isDataAvailable());

    ExecutorService feeder = Executors.newSingleThreadExecutor();
    try {
      feeder.submit(
          () -> {
            for (int i = 0; i < 10; i++) {
              grpcStream.consumer().onPartialResultSet(resultSet(null, "val" + i));
            }
            grpcStream.consumer().onCompleted();
          });

      List<String> results = new ArrayList<>();
      while (resumableStreamIterator.hasNext()) {
        PartialResultSet prs = resumableStreamIterator.next();
        results.add(prs.getValues(0).getStringValue());
      }
      assertEquals(10, results.size());
      for (int i = 0; i < 10; i++) {
        assertEquals("val" + i, results.get(i));
      }
    } finally {
      feeder.shutdown();
    }
  }

  @Test
  public void isDataAvailableWithResumeTokenInGrpcStream() {
    initWithLimit(10);
    GrpcStreamIterator grpcStream = new GrpcStreamIterator(false, 4, false);
    Mockito.when(starter.startStream(null, null)).thenReturn(grpcStream);
    resumableStreamIterator.setStream(grpcStream);

    assertFalse(resumableStreamIterator.isDataAvailable());

    // Chunk with resume token arrives -> immediately ready to emit!
    grpcStream.consumer().onPartialResultSet(resultSet(ByteString.copyFromUtf8("r1"), "a"));
    assertTrue(resumableStreamIterator.isDataAvailable());
  }

  @Test
  public void isDataAvailableWhenStreamIsNull() {
    initWithLimit(10);
    resumableStreamIterator.setStream(null);
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
  public void closeDuringStartStreamClosesStreamAndPreventsResurrection() {
    initWithLimit(10);
    @SuppressWarnings("unchecked")
    AbstractResultSet.CloseableIterator<PartialResultSet> streamIterator =
        mock(AbstractResultSet.CloseableIterator.class);
    when(starter.startStream(null, null))
        .thenAnswer(
            invocation -> {
              resumableStreamIterator.close("cancelled while starting stream");
              return streamIterator;
            });

    assertFalse(resumableStreamIterator.hasNext());
    assertTrue(resumableStreamIterator.isClosed());
    verify(streamIterator).close("cancelled while starting stream");
  }

  @Test
  public void setStreamWhenAlreadyClosedImmediatelyClosesStream() {
    initWithLimit(10);
    resumableStreamIterator.close("already closed");
    assertTrue(resumableStreamIterator.isClosed());

    @SuppressWarnings("unchecked")
    AbstractResultSet.CloseableIterator<PartialResultSet> streamIterator =
        mock(AbstractResultSet.CloseableIterator.class);
    assertFalse(resumableStreamIterator.setStream(streamIterator));

    verify(streamIterator).close("already closed");
  }

  @Test
  public void multipleCloseCallsAreIdempotent() {
    initWithLimit(10);
    @SuppressWarnings("unchecked")
    AbstractResultSet.CloseableIterator<PartialResultSet> streamIterator =
        mock(AbstractResultSet.CloseableIterator.class);
    resumableStreamIterator.setStream(streamIterator);

    resumableStreamIterator.close("first close");
    resumableStreamIterator.close("second close");

    assertTrue(resumableStreamIterator.isClosed());
    verify(streamIterator, Mockito.times(1)).close("first close");
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

    ResumableStreamIterator iterator =
        new ResumableStreamIterator(
            10,
            "testStream",
            span,
            tracer,
            DefaultErrorHandler.INSTANCE,
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings(),
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
            NoopRequestIdCreator.INSTANCE) {
          @Override
          AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              AsyncResultSet.StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            return starter.startStream(resumeToken, streamMessageListener);
          }
        };

    iterator.close("cancelled before streaming");
    assertTrue(iterator.isClosed());
    verify(openTelemetrySpan).end();
  }

  @Test
  public void closeWithNullMessage() {
    initWithLimit(10);
    @SuppressWarnings("unchecked")
    AbstractResultSet.CloseableIterator<PartialResultSet> streamIterator =
        mock(AbstractResultSet.CloseableIterator.class);
    resumableStreamIterator.setStream(streamIterator);

    resumableStreamIterator.close(null);
    assertTrue(resumableStreamIterator.isClosed());
    verify(streamIterator).close(null);
  }

  @Test
  public void isDataAvailableWhenBufferHasItems() {
    initWithLimit(10);
    ResultSetStream s1 = mock(ResultSetStream.class);
    when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    when(s1.next())
        .thenReturn(resultSet(null, "chunkWithoutToken"))
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "chunkWithToken"))
        .thenReturn(null);

    // Consuming the first element causes computeNext to buffer both chunks (up to the resume token)
    // and pop the first one, leaving chunkWithToken in the buffer.
    assertEquals("chunkWithoutToken", resumableStreamIterator.next().getValues(0).getStringValue());

    // With chunkWithToken still buffered, isDataAvailable() returns true via buffer.isEmpty() ==
    // false
    assertTrue(resumableStreamIterator.isDataAvailable());
    assertEquals("chunkWithToken", resumableStreamIterator.next().getValues(0).getStringValue());
  }

  @Test
  public void isWithBeginTransactionDelegatesToStream() {
    initWithLimit(10);
    assertFalse(resumableStreamIterator.isWithBeginTransaction());

    @SuppressWarnings("unchecked")
    AbstractResultSet.CloseableIterator<PartialResultSet> streamIterator =
        mock(AbstractResultSet.CloseableIterator.class);
    when(streamIterator.isWithBeginTransaction()).thenReturn(true);
    resumableStreamIterator.setStream(streamIterator);
    assertTrue(resumableStreamIterator.isWithBeginTransaction());

    when(streamIterator.isWithBeginTransaction()).thenReturn(false);
    assertFalse(resumableStreamIterator.isWithBeginTransaction());
  }

  @Test
  public void isLastStatementDelegatesToStream() {
    initWithLimit(10);
    assertFalse(resumableStreamIterator.isLastStatement());

    @SuppressWarnings("unchecked")
    AbstractResultSet.CloseableIterator<PartialResultSet> streamIterator =
        mock(AbstractResultSet.CloseableIterator.class);
    when(streamIterator.isLastStatement()).thenReturn(true);
    resumableStreamIterator.setStream(streamIterator);
    assertTrue(resumableStreamIterator.isLastStatement());

    when(streamIterator.isLastStatement()).thenReturn(false);
    assertFalse(resumableStreamIterator.isLastStatement());
  }

  @Test
  public void initiateStreamingStartsStreamAndRegistersListener() {
    initWithLimit(10);
    AsyncResultSet.StreamMessageListener streamMessageListener =
        mock(AsyncResultSet.StreamMessageListener.class);
    @SuppressWarnings("unchecked")
    AbstractResultSet.CloseableIterator<PartialResultSet> streamIterator =
        mock(AbstractResultSet.CloseableIterator.class);
    when(starter.startStream(null, streamMessageListener)).thenReturn(streamIterator);

    assertTrue(resumableStreamIterator.initiateStreaming(streamMessageListener));
    verify(starter).startStream(null, streamMessageListener);
    verify(streamIterator).requestPrefetchChunks();
  }

  @Test
  public void setStreamDoesNotRequestPrefetchChunks() {
    initWithLimit(10);
    @SuppressWarnings("unchecked")
    AbstractResultSet.CloseableIterator<PartialResultSet> streamIterator =
        mock(AbstractResultSet.CloseableIterator.class);
    resumableStreamIterator.setStream(streamIterator);
    verify(streamIterator, Mockito.never()).requestPrefetchChunks();
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
        new ResumableStreamIterator(
            10,
            "",
            new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)),
            new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false),
            errorHandler,
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings(),
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
            NoopRequestIdCreator.INSTANCE) {
          @Override
          AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              AsyncResultSet.StreamMessageListener streamMessageListener,
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
    when(secondStream.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "recoveredValue"))
        .thenReturn(null);

    List<String> results = consume(channelRetryIterator);
    assertEquals(1, results.size());
    assertEquals("recoveredValue", results.get(0));
    assertEquals(1, channelRetries.get());
  }

  @Test
  public void retryOnDifferentGrpcChannelNotAttemptedWhenPrepareReturnsFalse() {
    ErrorHandler errorHandler = mock(ErrorHandler.class);
    when(errorHandler.getMaxAttempts()).thenReturn(2);
    when(errorHandler.translateException(Mockito.any()))
        .thenReturn(new RetryOnDifferentGrpcChannelException("channel failed", 1, null));

    ResumableStreamIterator channelRetryIterator =
        new ResumableStreamIterator(
            10,
            "",
            new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)),
            new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false),
            errorHandler,
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings(),
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
            NoopRequestIdCreator.INSTANCE) {
          @Override
          AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              AsyncResultSet.StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            return starter.startStream(resumeToken, streamMessageListener);
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
  public void retryOnDifferentGrpcChannelNotAttemptedWhenMaxAttemptsExceeded() {
    ErrorHandler errorHandler = mock(ErrorHandler.class);
    when(errorHandler.getMaxAttempts()).thenReturn(1);
    when(errorHandler.translateException(Mockito.any()))
        .thenReturn(new RetryOnDifferentGrpcChannelException("channel failed", 1, null));

    ResumableStreamIterator channelRetryIterator =
        new ResumableStreamIterator(
            10,
            "",
            new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)),
            new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false),
            errorHandler,
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings(),
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
            NoopRequestIdCreator.INSTANCE) {
          @Override
          AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              AsyncResultSet.StreamMessageListener streamMessageListener,
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
        new ResumableStreamIterator(
            10,
            "",
            new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)),
            new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false),
            errorHandler,
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings(),
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
            NoopRequestIdCreator.INSTANCE) {
          @Override
          AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              AsyncResultSet.StreamMessageListener streamMessageListener,
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
  public void newBackOffWithDefaultSettings() {
    initWithLimit(10);
    ExponentialBackOff backOff = resumableStreamIterator.newBackOff();
    assertEquals(1.0, backOff.getMultiplier(), 0.001);
    assertEquals(10, backOff.getInitialIntervalMillis());
    assertEquals(1000, backOff.getMaxIntervalMillis());
    assertEquals(Integer.MAX_VALUE, backOff.getMaxElapsedTimeMillis());
  }

  @Test
  public void newBackOffWithCustomSettings() {
    RetrySettings customRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelay(Duration.ofMillis(50))
            .setMaxRetryDelay(Duration.ofMillis(500))
            .setRetryDelayMultiplier(2.0)
            .setTotalTimeout(Duration.ofMillis(5000))
            .build();
    ResumableStreamIterator customIterator =
        new ResumableStreamIterator(
            10,
            "",
            new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)),
            new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false),
            DefaultErrorHandler.INSTANCE,
            customRetrySettings,
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
            NoopRequestIdCreator.INSTANCE) {
          @Override
          AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              AsyncResultSet.StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            return starter.startStream(resumeToken, streamMessageListener);
          }
        };

    ExponentialBackOff backOff = customIterator.newBackOff();
    assertEquals(2.0, backOff.getMultiplier(), 0.001);
    assertEquals(50, backOff.getInitialIntervalMillis());
    assertEquals(500, backOff.getMaxIntervalMillis());
    assertEquals(Integer.MAX_VALUE, backOff.getMaxElapsedTimeMillis());
  }

  @Test
  public void nextBackOffMillisWhenIOExceptionThrowsSpannerException() throws Exception {
    BackOff mockBackOff = mock(BackOff.class);
    when(mockBackOff.nextBackOffMillis()).thenThrow(new IOException("Simulated I/O error"));

    SpannerException spannerException =
        assertThrows(
            SpannerException.class, () -> ResumableStreamIterator.nextBackOffMillis(mockBackOff));
    assertEquals(ErrorCode.INTERNAL, spannerException.getErrorCode());
  }

  @Test
  public void backoffSleepWhenContextCancelledThrowsCancellationException() {
    initWithLimit(10);
    ResultSetStream firstStream = mock(ResultSetStream.class);
    when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(firstStream));
    when(firstStream.next())
        .thenThrow(new RetryableException(errorCodeParameter, "transient error"));

    Context.CancellableContext cancellableContext = Context.current().withCancellation();
    cancellableContext.cancel(new RuntimeException("context cancelled by test"));

    cancellableContext.run(
        () -> {
          SpannerException spannerException =
              assertThrows(SpannerException.class, resumableStreamIterator::next);
          assertEquals(ErrorCode.CANCELLED, spannerException.getErrorCode());
        });
  }

  @Test
  public void unhandledRuntimeExceptionSetsSpanStatusAndThrows() {
    initWithLimit(10);
    ResultSetStream firstStream = mock(ResultSetStream.class);
    when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(firstStream));
    when(firstStream.next()).thenThrow(new IllegalStateException("unexpected runtime exception"));

    IllegalStateException thrown =
        assertThrows(IllegalStateException.class, resumableStreamIterator::next);
    assertEquals("unexpected runtime exception", thrown.getMessage());
  }

  @Test
  public void isRetryableMatchesRetryableCodesEvenIfExceptionIsNotRetryable() {
    ResumableStreamIterator iteratorWithRetryableCodes =
        new ResumableStreamIterator(
            10,
            "",
            new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)),
            new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false),
            DefaultErrorHandler.INSTANCE,
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings(),
            Collections.singleton(Code.UNAVAILABLE),
            NoopRequestIdCreator.INSTANCE) {
          @Override
          AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              AsyncResultSet.StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            return null;
          }
        };

    NonRetryableException exceptionWithUnavailableCode =
        new NonRetryableException(ErrorCode.UNAVAILABLE, "non retryable flag but UNAVAILABLE code");
    assertTrue(iteratorWithRetryableCodes.isRetryable(exceptionWithUnavailableCode));

    NonRetryableException exceptionWithInvalidArgument =
        new NonRetryableException(ErrorCode.INVALID_ARGUMENT, "non retryable code");
    assertFalse(iteratorWithRetryableCodes.isRetryable(exceptionWithInvalidArgument));
  }

  @Test
  public void constructorNegativeMaxBufferSizeThrowsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> initWithLimit(-1));
  }

  @Test
  public void constructorNullRetrySettingsThrowsNullPointerException() {
    assertThrows(
        NullPointerException.class,
        () ->
            new ResumableStreamIterator(
                10,
                "",
                new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)),
                new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false),
                DefaultErrorHandler.INSTANCE,
                null,
                SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
                NoopRequestIdCreator.INSTANCE) {
              @Override
              AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
                  @Nullable ByteString resumeToken,
                  AsyncResultSet.StreamMessageListener streamMessageListener,
                  XGoogSpannerRequestId requestId) {
                return null;
              }
            });
  }

  @Test
  public void constructorNullRetryableCodesThrowsNullPointerException() {
    assertThrows(
        NullPointerException.class,
        () ->
            new ResumableStreamIterator(
                10,
                "",
                new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)),
                new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false),
                DefaultErrorHandler.INSTANCE,
                SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings(),
                null,
                NoopRequestIdCreator.INSTANCE) {
              @Override
              AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
                  @Nullable ByteString resumeToken,
                  AsyncResultSet.StreamMessageListener streamMessageListener,
                  XGoogSpannerRequestId requestId) {
                return null;
              }
            });
  }

  @Test
  public void isDataAvailableWhenBufferHasItemsWithoutResumeTokenDelegatesToUnderlyingStream() {
    initWithLimit(10);
    @SuppressWarnings("unchecked")
    AbstractResultSet.CloseableIterator<PartialResultSet> streamIterator =
        mock(AbstractResultSet.CloseableIterator.class);
    resumableStreamIterator.setStream(streamIterator);

    PartialResultSet chunkWithoutToken = resultSet(null, "chunk1");
    synchronized (resumableStreamIterator.buffer) {
      resumableStreamIterator.buffer.add(chunkWithoutToken);
    }

    when(streamIterator.isDataAvailable()).thenReturn(false);
    assertFalse(resumableStreamIterator.isDataAvailable());

    when(streamIterator.isDataAvailable()).thenReturn(true);
    assertTrue(resumableStreamIterator.isDataAvailable());

    PartialResultSet chunkWithToken = resultSet(ByteString.copyFromUtf8("token1"), "chunk2");
    synchronized (resumableStreamIterator.buffer) {
      resumableStreamIterator.buffer.add(chunkWithToken);
    }
    when(streamIterator.isDataAvailable()).thenReturn(false);
    assertTrue(resumableStreamIterator.isDataAvailable());
  }

  @Test
  public void startStreamFailureAfterSetStreamDoesNotLeaveStaleStream() {
    AtomicInteger startCount = new AtomicInteger();
    ResumableStreamIterator iterator =
        new ResumableStreamIterator(
            10,
            "",
            new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)),
            new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false),
            DefaultErrorHandler.INSTANCE,
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings(),
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
            NoopRequestIdCreator.INSTANCE) {
          @Override
          AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              AsyncResultSet.StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            GrpcStreamIterator stream =
                new GrpcStreamIterator(
                    /* lastStatement= */ false, 10, /* cancelQueryWhenClientIsClosed= */ false);
            setStream(stream);
            if (startCount.incrementAndGet() == 1) {
              throw SpannerExceptionFactory.newSpannerException(
                  ErrorCode.DEADLINE_EXCEEDED,
                  "Simulated failure in getTransactionSelector() or rpc.executeQuery()");
            }
            SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
            stream.setCall(call, false);
            stream.consumer().onPartialResultSet(resultSet(ByteString.copyFromUtf8("r1"), "val1"));
            stream.consumer().onCompleted();
            return stream;
          }
        };

    assertThrows(SpannerException.class, () -> iterator.initiateStreaming(null));
    // A subsequent attempt to consume or check availability must not be stuck on the unstarted
    // GrpcStreamIterator from the failed first attempt.
    assertFalse(iterator.isDataAvailable());
    ExecutorService testExecutor = Executors.newSingleThreadExecutor();
    try {
      assertTrue(testExecutor.submit(iterator::hasNext).get(1, TimeUnit.SECONDS));
      assertEquals("val1", iterator.next().getValues(0).getStringValue());
    } catch (Exception e) {
      throw new AssertionError("iterator.hasNext() got stuck after failed startStream()", e);
    } finally {
      testExecutor.shutdownNow();
    }
  }

  @Test
  public void closeBeforeSetCallCancelsUnderlyingCallWithMessage() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    ResumableStreamIterator iterator =
        new ResumableStreamIterator(
            10,
            "",
            new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)),
            new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false),
            DefaultErrorHandler.INSTANCE,
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings(),
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
            NoopRequestIdCreator.INSTANCE) {
          @Override
          AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              AsyncResultSet.StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            GrpcStreamIterator stream =
                new GrpcStreamIterator(
                    /* lastStatement= */ false, 10, /* cancelQueryWhenClientIsClosed= */ false);
            setStream(stream);
            // Simulate concurrent close(message) while rpc.executeQuery() is in flight before
            // stream.setCall(call, ...) is invoked.
            close("Cancelled by test");
            stream.setCall(call, false);
            return stream;
          }
        };

    iterator.initiateStreaming(null);
    verify(call).cancel("Cancelled by test");
  }

  @Test
  public void isWithBeginTransactionAndIsLastStatementPreservedAfterClose() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    ResumableStreamIterator iterator =
        new ResumableStreamIterator(
            10,
            "",
            new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)),
            new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false),
            DefaultErrorHandler.INSTANCE,
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings(),
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
            NoopRequestIdCreator.INSTANCE) {
          @Override
          AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              AsyncResultSet.StreamMessageListener streamMessageListener,
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
    assertTrue(iterator.isWithBeginTransaction());
    assertTrue(iterator.isLastStatement());
  }

  @Test
  public void closeAfterLastTrueWithResumeTokenDoesNotCancelUnderlyingCall() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    ResumableStreamIterator iterator =
        new ResumableStreamIterator(
            10,
            "",
            new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)),
            new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false),
            DefaultErrorHandler.INSTANCE,
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings(),
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
            NoopRequestIdCreator.INSTANCE) {
          @Override
          AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              AsyncResultSet.StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            GrpcStreamIterator stream =
                new GrpcStreamIterator(
                    /* lastStatement= */ false, 10, /* cancelQueryWhenClientIsClosed= */ false);
            setStream(stream);
            stream.setCall(call, /* withBeginTransaction= */ false);
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
    PartialResultSet prs = iterator.next();
    assertEquals(20, prs.getValuesCount());
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
          new ResumableStreamIterator(
              10,
              "",
              new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)),
              new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false),
              DefaultErrorHandler.INSTANCE,
              SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings(),
              SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
              NoopRequestIdCreator.INSTANCE) {
            @Override
            AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
                @Nullable ByteString resumeToken,
                AsyncResultSet.StreamMessageListener streamMessageListener,
                XGoogSpannerRequestId requestId) {
              GrpcStreamIterator stream =
                  new GrpcStreamIterator(
                      /* lastStatement= */ false, 10, /* cancelQueryWhenClientIsClosed= */ false);
              setStream(stream);
              stream.setCall(call, /* withBeginTransaction= */ false);
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

  @Test
  public void lastTrueConsumedBeforeSetCallDoesNotCancelWhenClosedBeforeOrAfterSetCall() {
    for (boolean closeBeforeSetCall : new boolean[] {true, false}) {
      SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
      GrpcStreamIterator stream =
          new GrpcStreamIterator(
              /* lastStatement= */ false, 10, /* cancelQueryWhenClientIsClosed= */ false);
      stream
          .consumer()
          .onPartialResultSet(
              PartialResultSet.newBuilder()
                  .setResumeToken(ByteString.copyFromUtf8("r1"))
                  .setLast(true)
                  .addValues(Value.newBuilder().setStringValue("v1"))
                  .build());
      assertTrue(stream.hasNext());
      assertEquals("v1", stream.next().getValues(0).getStringValue());
      if (closeBeforeSetCall) {
        stream.close("closed before setCall");
      }
      stream.setCall(call, /* withBeginTransaction= */ false);
      if (!closeBeforeSetCall) {
        stream.close("closed after setCall");
      }
      Mockito.verify(call, Mockito.never()).cancel(Mockito.any());
    }
  }

  @Test
  public void concurrentResetDuringStartStreamDoesNotOverwriteStreamOrRequestPrefetch() {
    @SuppressWarnings("unchecked")
    AbstractResultSet.CloseableIterator<PartialResultSet> initialStream =
        mock(AbstractResultSet.CloseableIterator.class);
    @SuppressWarnings("unchecked")
    AbstractResultSet.CloseableIterator<PartialResultSet> retryStream =
        mock(AbstractResultSet.CloseableIterator.class);
    AtomicInteger startCount = new AtomicInteger();

    ResumableStreamIterator iterator =
        new ResumableStreamIterator(
            10,
            "",
            new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)),
            new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false),
            DefaultErrorHandler.INSTANCE,
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetrySettings(),
            SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
            NoopRequestIdCreator.INSTANCE) {
          @Override
          AbstractResultSet.CloseableIterator<PartialResultSet> startStream(
              @Nullable ByteString resumeToken,
              AsyncResultSet.StreamMessageListener streamMessageListener,
              XGoogSpannerRequestId requestId) {
            if (startCount.incrementAndGet() == 1) {
              assertTrue(setStream(initialStream));
              // Simulate a concurrent consumer thread resetting and replacing the stream before
              // the first startStream() returns to startGrpcStreaming().
              setStream(retryStream);
              return initialStream;
            }
            return retryStream;
          }
        };

    iterator.initiateStreaming(null);
    Mockito.verify(initialStream, Mockito.never()).requestPrefetchChunks();
    iterator.close("closing");
    verify(retryStream).close("closing");
    Mockito.verify(initialStream, Mockito.never()).close(Mockito.any());
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
