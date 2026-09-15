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
import io.opentelemetry.context.Scope;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import org.junit.Assume;
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

  @Before
  public void setUp() {
    SpannerOptions.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();
    initWithLimit(Integer.MAX_VALUE);
  }

  private void initWithLimit(int maxBufferSize) {

    resumableStreamIterator =
        new ResumableStreamIterator(
            maxBufferSize,
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
    Assume.assumeTrue(
        "This test is only supported on JDK11 and lower",
        JavaVersionUtil.getJavaMajorVersion() < 12);

    io.opentelemetry.api.trace.Span oTspan = mock(io.opentelemetry.api.trace.Span.class);
    ISpan span = new OpenTelemetrySpan(oTspan);
    when(oTspan.makeCurrent()).thenReturn(mock(Scope.class));
    setInternalState(ResumableStreamIterator.class, this.resumableStreamIterator, "span", span);

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
    Assume.assumeTrue(
        "This test is only supported on JDK11 and lower",
        JavaVersionUtil.getJavaMajorVersion() < 12);
    Span mockSpan = mock(Span.class);
    ISpan span = new OpenCensusSpan(mockSpan);
    setInternalState(ResumableStreamIterator.class, this.resumableStreamIterator, "span", span);

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
  public void retryableErrorWithoutRetryInfo() throws IOException {
    Assume.assumeTrue(
        "This test is only supported on JDK11 and lower",
        JavaVersionUtil.getJavaMajorVersion() < 12);

    BackOff backOff = mock(BackOff.class);
    Mockito.when(backOff.nextBackOffMillis()).thenReturn(1L);
    setInternalState(
        ResumableStreamIterator.class, this.resumableStreamIterator, "backOff", backOff);

    ResultSetStream s1 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(null, null)).thenReturn(new ResultSetIterator(s1));
    Mockito.when(s1.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r1"), "a"))
        .thenThrow(
            new RetryableException(
                ErrorCode.UNAVAILABLE, "failed by test", Status.UNAVAILABLE.asRuntimeException()));

    ResultSetStream s2 = Mockito.mock(ResultSetStream.class);
    Mockito.when(starter.startStream(ByteString.copyFromUtf8("r1"), null))
        .thenReturn(new ResultSetIterator(s2));
    Mockito.when(s2.next())
        .thenReturn(resultSet(ByteString.copyFromUtf8("r2"), "b"))
        .thenReturn(null);
    assertThat(consume(resumableStreamIterator)).containsExactly("a", "b").inOrder();
    verify(backOff).nextBackOffMillis();
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

    // Chunk without resume token arrives -> immediately available because GrpcStreamIterator has
    // data
    grpcStream.consumer().onPartialResultSet(resultSet(null, "a"));
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

    java.util.concurrent.ExecutorService feeder =
        java.util.concurrent.Executors.newSingleThreadExecutor();
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
    setInternalState(ResumableStreamIterator.class, resumableStreamIterator, "finished", true);
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
    verify(streamIterator).close(null);
  }

  @Test
  public void setStreamWhenAlreadyClosedImmediatelyClosesStream() {
    initWithLimit(10);
    resumableStreamIterator.close("already closed");
    assertTrue(resumableStreamIterator.isClosed());

    @SuppressWarnings("unchecked")
    AbstractResultSet.CloseableIterator<PartialResultSet> streamIterator =
        mock(AbstractResultSet.CloseableIterator.class);
    resumableStreamIterator.setStream(streamIterator);

    verify(streamIterator).close(null);
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
    assertEquals(5000, backOff.getMaxElapsedTimeMillis());
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

  /**
   * Sets a private static final field to a specific value. This is only supported on Java11 and
   * lower.
   */
  private static void setInternalState(Class<?> c, Object target, String field, Object value) {
    try {
      Field f = c.getDeclaredField(field);
      f.setAccessible(true);
      f.set(target, value);
    } catch (Exception e) {
      throw new RuntimeException("Unable to set internal state on a private field.", e);
    }
  }
}
