/*
 * Copyright 2026 Google LLC
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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.spanner.AbstractResultSet.CloseableIterator;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.CursorState;
import com.google.cloud.spanner.AsyncResultSet.ReadyCallback;
import com.google.cloud.spanner.ErrorHandler.DefaultErrorHandler;
import com.google.cloud.spanner.XGoogSpannerRequestId.NoopRequestIdCreator;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.MultiplexedSessionPrecommitToken;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.Transaction;
import io.opencensus.trace.Tracing;
import io.opentelemetry.api.OpenTelemetry;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import org.jspecify.annotations.Nullable;

/** Shared test fixtures for {@link AsyncResultSetImpl} unit tests. */
final class AsyncResultSetImplTestUtil {

  static class NoOpResultSetListener implements AbstractResultSet.Listener {
    @Override
    public void onTransactionMetadata(Transaction transaction, boolean shouldIncludeId) {}

    @Override
    public SpannerException onError(
        SpannerException exception, boolean withBeginTransaction, boolean lastStatement) {
      return exception;
    }

    @Override
    public void onDone(boolean withBeginTransaction) {}

    @Override
    public void onPrecommitToken(MultiplexedSessionPrecommitToken token) {}
  }

  static final AbstractResultSet.Listener NO_OP_RESULT_SET_LISTENER = new NoOpResultSetListener();

  abstract static class AbstractCloseableIterator implements CloseableIterator<PartialResultSet> {
    private final boolean withBeginTransaction;

    AbstractCloseableIterator(boolean withBeginTransaction) {
      this.withBeginTransaction = withBeginTransaction;
    }

    @Override
    public void close(@Nullable String message) {}

    @Override
    public boolean isWithBeginTransaction() {
      return withBeginTransaction;
    }

    @Override
    public boolean isLastStatement() {
      return false;
    }

    @Override
    public PartialResultSet next() {
      throw new NoSuchElementException();
    }
  }

  static final class QueuedExecutorProvider implements ExecutorProvider {
    final BlockingDeque<Runnable> tasks = new LinkedBlockingDeque<>();
    final ScheduledExecutorService service = mock(ScheduledExecutorService.class);
    private final boolean autoClose;

    QueuedExecutorProvider(boolean autoClose) {
      this.autoClose = autoClose;
      doAnswer(
              invocation -> {
                tasks.addLast(invocation.getArgument(0));
                return null;
              })
          .when(service)
          .execute(any(Runnable.class));
    }

    @Override
    public boolean shouldAutoClose() {
      return autoClose;
    }

    @Override
    public ScheduledExecutorService getExecutor() {
      return service;
    }

    void runNext() {
      tasks.removeFirst().run();
    }
  }

  static final class ControllableStreamingDelegate {
    final StreamingResultSet delegate = mock(StreamingResultSet.class);
    final AtomicReference<AsyncResultSet.StreamMessageListener> listenerRef =
        new AtomicReference<>();
    final CountDownLatch listenerRegistered = new CountDownLatch(1);
    final AtomicInteger availableRows = new AtomicInteger();
    final AtomicInteger consumedRows = new AtomicInteger();
    final AtomicBoolean streamFinished = new AtomicBoolean();

    ControllableStreamingDelegate(int totalRows) {
      when(delegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
          .thenAnswer(
              invocation -> {
                listenerRef.set(invocation.getArgument(0));
                listenerRegistered.countDown();
                return true;
              });
      when(delegate.isDataAvailable())
          .thenAnswer(
              invocation -> streamFinished.get() || consumedRows.get() < availableRows.get());
      when(delegate.next()).thenAnswer(invocation -> consumedRows.incrementAndGet() <= totalRows);
      when(delegate.getCurrentRowAsStruct())
          .thenAnswer(
              invocation -> Struct.newBuilder().set("id").to((long) consumedRows.get()).build());
    }

    AsyncResultSet.StreamMessageListener awaitListener() throws InterruptedException {
      assertTrue(listenerRegistered.await(5, TimeUnit.SECONDS));
      return listenerRef.get();
    }

    /**
     * Waits until {@code initiateStreaming} has registered the listener AND {@code
     * InitiateStreamingRunnable} has finished its initial availability check and yielded on {@code
     * provider}'s single-thread executor.
     */
    AsyncResultSet.StreamMessageListener awaitStreamingInitialized(ExecutorProvider provider)
        throws Exception {
      AsyncResultSet.StreamMessageListener listener = awaitListener();
      assertTrue(provider.getExecutor().submit(() -> true).get(5, TimeUnit.SECONDS));
      return listener;
    }

    void emitFlushableChunk(String token, boolean bufferIsFull) {
      listenerRef
          .get()
          .onStreamMessage(
              PartialResultSet.newBuilder().setResumeToken(ByteString.copyFromUtf8(token)).build(),
              bufferIsFull);
    }

    void emitEndOfStream(boolean bufferIsFull) {
      streamFinished.set(true);
      listenerRef.get().onStreamMessage(GrpcStreamIterator.END_OF_STREAM, bufferIsFull);
    }
  }

  static final class GrpcStreamingTestHarness {
    final SpannerRpc.StreamingCall streamingCall = mock(SpannerRpc.StreamingCall.class);
    final ResumableStreamIterator resumableIterator;
    private final AtomicReference<GrpcStreamIterator> grpcStreamRef = new AtomicReference<>();
    private final CountDownLatch streamStartedLatch = new CountDownLatch(1);

    GrpcStreamingTestHarness(int maxBufferSize, int prefetchChunks) {
      this(maxBufferSize, prefetchChunks, ignored -> {});
    }

    GrpcStreamingTestHarness(
        int maxBufferSize, int prefetchChunks, Consumer<GrpcStreamIterator> onStartStream) {
      TraceWrapper tracer =
          new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false);
      ISpan parentSpan = tracer.spanBuilder("test");
      RetrySettings retrySettings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(10))
              .setMaxRetryDelayDuration(Duration.ofMillis(100))
              .build();
      this.resumableIterator =
          new ResumableStreamIterator(
              maxBufferSize,
              "query",
              parentSpan,
              tracer,
              DefaultErrorHandler.INSTANCE,
              retrySettings,
              SpannerStubSettings.newBuilder().executeStreamingSqlSettings().getRetryableCodes(),
              NoopRequestIdCreator.INSTANCE) {
            @Override
            CloseableIterator<PartialResultSet> startStream(
                ByteString resumeToken,
                AsyncResultSet.StreamMessageListener streamMessageListener,
                XGoogSpannerRequestId requestId) {
              GrpcStreamIterator grpcStream = new GrpcStreamIterator(false, prefetchChunks, false);
              if (streamMessageListener != null) {
                grpcStream.registerListener(streamMessageListener);
              }
              grpcStream.setCall(streamingCall);
              onStartStream.accept(grpcStream);
              grpcStreamRef.set(grpcStream);
              streamStartedLatch.countDown();
              return grpcStream;
            }
          };
    }

    GrpcResultSet newGrpcResultSet() {
      return new GrpcResultSet(resumableIterator, NO_OP_RESULT_SET_LISTENER);
    }

    GrpcStreamIterator awaitStreamingInitialized(ExecutorProvider provider) throws Exception {
      assertTrue(streamStartedLatch.await(5, TimeUnit.SECONDS));
      assertTrue(provider.getExecutor().submit(() -> true).get(5, TimeUnit.SECONDS));
      GrpcStreamIterator grpcStream = grpcStreamRef.get();
      assertNotNull(grpcStream);
      return grpcStream;
    }
  }

  static ExecutorProvider executorProviderOf(ScheduledExecutorService service, boolean autoClose) {
    return new ExecutorProvider() {
      @Override
      public boolean shouldAutoClose() {
        return autoClose;
      }

      @Override
      public ScheduledExecutorService getExecutor() {
        return service;
      }
    };
  }

  static PartialResultSet singleInt64MetadataChunk() {
    return PartialResultSet.newBuilder()
        .setMetadata(
            ResultSetMetadata.newBuilder()
                .setRowType(
                    Type.struct(Type.StructField.of("id", Type.int64())).toProto().getStructType()))
        .build();
  }

  static ReadyCallback drainLongIdsCallback(List<Long> sink) {
    return cursor -> {
      while (true) {
        CursorState cursorState = cursor.tryNext();
        if (cursorState == CursorState.OK) {
          sink.add(cursor.getLong(0));
        } else if (cursorState == CursorState.NOT_READY) {
          return CallbackResponse.CONTINUE;
        } else {
          return CallbackResponse.DONE;
        }
      }
    };
  }

  @SuppressWarnings("unchecked")
  static <E extends Throwable> RuntimeException sneakyThrow(Throwable throwable) throws E {
    throw (E) throwable;
  }

  private AsyncResultSetImplTestUtil() {}
}
