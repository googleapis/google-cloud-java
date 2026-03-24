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

import com.google.api.client.util.BackOff;
import com.google.cloud.spanner.ErrorHandler.DefaultErrorHandler;
import com.google.cloud.spanner.XGoogSpannerRequestId.NoopRequestIdCreator;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
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
import io.opentelemetry.context.Scope;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.junit.Assume;
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
