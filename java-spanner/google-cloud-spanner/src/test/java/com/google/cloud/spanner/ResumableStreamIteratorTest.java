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
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.spanner.ErrorHandler.DefaultErrorHandler;
import com.google.cloud.spanner.XGoogSpannerRequestId.NoopRequestIdCreator;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
import com.google.common.base.Stopwatch;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Value;
import com.google.rpc.RetryInfo;
import com.google.spanner.v1.PartialResultSet;
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
import java.util.concurrent.TimeUnit;
import java.util.function.LongSupplier;
import javax.annotation.Nullable;
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
            return starter.startStream(resumeToken, null);
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
