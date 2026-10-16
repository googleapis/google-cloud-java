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

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.protobuf.ByteString;
import com.google.protobuf.Value;
import com.google.spanner.v1.PartialResultSet;
import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GrpcStreamIteratorTest {

  @Test
  public void closeBeforeSetCallCancelsUnderlyingCallWithMessage() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());

    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 10,
            /* cancelQueryWhenClientIsClosed= */ false);

    streamIterator.close("Cancelled before setCall");
    streamIterator.setCall(call, /* withBeginTransaction= */ false);

    verify(call).cancel("Cancelled before setCall");
  }

  @Test
  public void closeAfterSetCallCancelsUnderlyingCallWithMessage() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());

    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 10,
            /* cancelQueryWhenClientIsClosed= */ false);

    streamIterator.setCall(call, /* withBeginTransaction= */ false);
    streamIterator.close("Cancelled after setCall");

    verify(call).cancel("Cancelled after setCall");
  }

  @Test
  public void closeAfterLastTrueChunkConsumedDoesNotCancelCall() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());

    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 10,
            /* cancelQueryWhenClientIsClosed= */ false);

    streamIterator.setCall(call, /* withBeginTransaction= */ false);

    PartialResultSet lastChunk =
        PartialResultSet.newBuilder()
            .setResumeToken(ByteString.copyFromUtf8("token-1"))
            .setLast(true)
            .addValues(Value.newBuilder().setStringValue("value-1"))
            .build();

    streamIterator.consumer().onPartialResultSet(lastChunk);
    assertTrue(streamIterator.hasNext());
    assertEquals(lastChunk, streamIterator.next());

    streamIterator.close("Closing after finished");

    verify(call, never()).cancel(any());
  }

  @Test
  public void closeBeforeLastTrueChunkConsumedCancelsCall() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());

    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 10,
            /* cancelQueryWhenClientIsClosed= */ false);

    streamIterator.setCall(call, /* withBeginTransaction= */ false);

    PartialResultSet lastChunk =
        PartialResultSet.newBuilder()
            .setResumeToken(ByteString.copyFromUtf8("token-1"))
            .setLast(true)
            .addValues(Value.newBuilder().setStringValue("value-1"))
            .build();

    streamIterator.consumer().onPartialResultSet(lastChunk);
    streamIterator.close("Closing before consumption");

    verify(call).cancel("Closing before consumption");
  }

  @Test
  public void lastTrueConsumedBeforeSetCallDoesNotCancelWhenClosed() {
    for (boolean closeBeforeSetCall : new boolean[] {true, false}) {
      SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
      when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());

      GrpcStreamIterator streamIterator =
          new GrpcStreamIterator(
              /* statement= */ null,
              /* lastStatement= */ false,
              /* prefetchChunks= */ 10,
              /* cancelQueryWhenClientIsClosed= */ false);

      PartialResultSet chunk =
          PartialResultSet.newBuilder()
              .setResumeToken(ByteString.copyFromUtf8("token-1"))
              .setLast(true)
              .addValues(Value.newBuilder().setStringValue("value-1"))
              .build();

      streamIterator.consumer().onPartialResultSet(chunk);
      assertTrue(streamIterator.hasNext());
      assertEquals(chunk, streamIterator.next());

      if (closeBeforeSetCall) {
        streamIterator.close("Closed before setCall");
      }
      streamIterator.setCall(call, /* withBeginTransaction= */ false);
      if (!closeBeforeSetCall) {
        streamIterator.close("Closed after setCall");
      }

      verify(call, never()).cancel(any());
    }
  }

  @Test(timeout = 5000)
  public void consumerPrefetchChunksOneDoesNotDeadlockOnCompletion() {
    // When prefetchChunks is 1, stream queue capacity is 2 (prefetchChunks + 1).
    // Delivering last=true followed by onCompleted() must not deadlock.
    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 1,
            /* cancelQueryWhenClientIsClosed= */ false);

    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());
    streamIterator.setCall(call, /* withBeginTransaction= */ false);

    PartialResultSet lastChunk =
        PartialResultSet.newBuilder()
            .setResumeToken(ByteString.copyFromUtf8("token-1"))
            .setLast(true)
            .addValues(Value.newBuilder().setStringValue("value-1"))
            .build();

    streamIterator.consumer().onPartialResultSet(lastChunk);
    streamIterator.consumer().onCompleted();

    assertTrue(streamIterator.hasNext());
    assertEquals(lastChunk, streamIterator.next());
    assertFalse(streamIterator.hasNext());
  }

  @Test(timeout = 5000)
  public void consumerPrefetchChunksOneDoesNotDeadlockOnError() {
    // When prefetchChunks is 1, stream queue capacity is 2.
    // Delivering last=true followed by onError() must not deadlock.
    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 1,
            /* cancelQueryWhenClientIsClosed= */ false);

    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());
    streamIterator.setCall(call, /* withBeginTransaction= */ false);

    PartialResultSet lastChunk =
        PartialResultSet.newBuilder()
            .setResumeToken(ByteString.copyFromUtf8("token-1"))
            .setLast(true)
            .addValues(Value.newBuilder().setStringValue("value-1"))
            .build();

    streamIterator.consumer().onPartialResultSet(lastChunk);
    SpannerException spannerException =
        SpannerExceptionFactory.newSpannerException(ErrorCode.INTERNAL, "stream error");
    streamIterator.consumer().onError(spannerException);

    assertTrue(streamIterator.hasNext());
    assertEquals(lastChunk, streamIterator.next());
    SpannerException thrown = assertThrows(SpannerException.class, streamIterator::hasNext);
    assertEquals(ErrorCode.INTERNAL, thrown.getErrorCode());
  }

  @Test
  public void requestPrefetchChunksValidatesInitialization() {
    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 5,
            /* cancelQueryWhenClientIsClosed= */ false);

    assertThrows(IllegalStateException.class, streamIterator::requestPrefetchChunks);

    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());
    streamIterator.setCall(call, /* withBeginTransaction= */ false);

    streamIterator.requestPrefetchChunks();
    verify(call).request(5);
  }

  @Test
  public void statePreservedAcrossClose() {
    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ true,
            /* prefetchChunks= */ 2,
            /* cancelQueryWhenClientIsClosed= */ false);
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());
    streamIterator.setCall(call, /* withBeginTransaction= */ true);

    assertTrue(streamIterator.isLastStatement());
    assertTrue(streamIterator.isWithBeginTransaction());

    streamIterator.close("Closed");

    assertTrue(streamIterator.isLastStatement());
    assertTrue(streamIterator.isWithBeginTransaction());
  }

  @Test
  public void onErrorSetsStatementOnException() {
    Statement statement = Statement.of("SELECT 1");
    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            statement,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 2,
            /* cancelQueryWhenClientIsClosed= */ false);

    SpannerException originalException =
        SpannerExceptionFactory.newSpannerException(ErrorCode.UNAVAILABLE, "Unavailable");
    streamIterator.consumer().onError(originalException);

    SpannerException thrown = assertThrows(SpannerException.class, streamIterator::hasNext);
    assertTrue(thrown.getMessage().contains(statement.getSql()));
  }

  @Test
  public void streamWaitTimeoutThrowsDeadlineExceeded() {
    ApiCallContext callContext =
        GrpcCallContext.createDefault().withStreamWaitTimeoutDuration(Duration.ofMillis(50));
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(callContext);

    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 2,
            /* cancelQueryWhenClientIsClosed= */ false);

    streamIterator.setCall(call, /* withBeginTransaction= */ false);

    SpannerException thrown = assertThrows(SpannerException.class, streamIterator::hasNext);
    assertEquals(ErrorCode.DEADLINE_EXCEEDED, thrown.getErrorCode());
  }

  @Test
  public void closeBeforeSetCallDoesNotRetainCall() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());

    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 5,
            /* cancelQueryWhenClientIsClosed= */ false);

    streamIterator.close("Closed before setCall");
    streamIterator.setCall(call, /* withBeginTransaction= */ false);

    verify(call).cancel("Closed before setCall");
    // Since streamIterator was already closed, requestPrefetchChunks should safely no-op
    // without requesting chunks from the cancelled call.
    streamIterator.requestPrefetchChunks();
    verify(call, never()).request(anyInt());
  }

  @Test
  public void closeAfterSetCallClearsCallReference() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());

    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 5,
            /* cancelQueryWhenClientIsClosed= */ false);

    streamIterator.setCall(call, /* withBeginTransaction= */ false);
    streamIterator.close("Closed after setCall");

    verify(call).cancel("Closed after setCall");
    // Since streamIterator is closed, requestPrefetchChunks should safely no-op.
    streamIterator.requestPrefetchChunks();
    verify(call, never()).request(anyInt());
  }

  @Test(timeout = 10000)
  public void concurrentCloseAndSetCallCancelsCallDeterministically() throws Exception {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    try {
      for (int i = 0; i < 50; i++) {
        SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
        when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());

        GrpcStreamIterator streamIterator =
            new GrpcStreamIterator(
                /* statement= */ null,
                /* lastStatement= */ false,
                /* prefetchChunks= */ 5,
                /* cancelQueryWhenClientIsClosed= */ false);

        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(2);

        executor.submit(
            () -> {
              try {
                startLatch.await();
                streamIterator.setCall(call, /* withBeginTransaction= */ false);
              } catch (InterruptedException ignored) {
              } finally {
                doneLatch.countDown();
              }
            });

        executor.submit(
            () -> {
              try {
                startLatch.await();
                streamIterator.close("Concurrent cancellation");
              } catch (InterruptedException ignored) {
              } finally {
                doneLatch.countDown();
              }
            });

        startLatch.countDown();
        assertTrue(doneLatch.await(5, TimeUnit.SECONDS));

        verify(call).cancel("Concurrent cancellation");
        streamIterator.requestPrefetchChunks();
        verify(call, never()).request(anyInt());
      }
    } finally {
      executor.shutdownNow();
    }
  }

  @Test(timeout = 5000)
  public void concurrentCloseUnblocksConsumerWaitingOnStream() throws Exception {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());

    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 5,
            /* cancelQueryWhenClientIsClosed= */ false);
    streamIterator.setCall(call, /* withBeginTransaction= */ false);

    AtomicReference<Throwable> consumerError = new AtomicReference<>();
    Thread consumerThread =
        new Thread(
            () -> {
              try {
                SpannerException spannerException =
                    assertThrows(SpannerException.class, streamIterator::hasNext);
                assertEquals(ErrorCode.CANCELLED, spannerException.getErrorCode());
              } catch (Throwable t) {
                consumerError.set(t);
              }
            });
    consumerThread.start();

    // Deterministically wait for the consumer thread to block on stream.take() without sleeping.
    await()
        .atMost(Duration.ofSeconds(5))
        .until(() -> consumerThread.getState() == Thread.State.WAITING);

    streamIterator.close("User cancelled");
    verify(call).cancel("User cancelled");

    // gRPC layer delivers error on cancellation
    streamIterator
        .consumer()
        .onError(SpannerExceptionFactory.newSpannerException(ErrorCode.CANCELLED, "Cancelled"));

    consumerThread.join(5000);
    assertFalse(consumerThread.isAlive());
    if (consumerError.get() != null) {
      throw new AssertionError(consumerError.get());
    }
  }

  @Test
  public void setCallWithNullCallContextDoesNotThrow() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(null);

    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 5,
            /* cancelQueryWhenClientIsClosed= */ false);
    streamIterator.setCall(call, /* withBeginTransaction= */ false);

    streamIterator.requestPrefetchChunks();
    verify(call).request(5);
  }

  @Test
  public void streamWaitTimeoutWithSecondsUnitThrowsDeadlineExceeded() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext())
        .thenReturn(
            GrpcCallContext.createDefault().withStreamWaitTimeoutDuration(Duration.ofSeconds(1)));

    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 5,
            /* cancelQueryWhenClientIsClosed= */ false);
    streamIterator.setCall(call, /* withBeginTransaction= */ false);

    SpannerException spannerException =
        assertThrows(SpannerException.class, streamIterator::hasNext);
    assertEquals(ErrorCode.DEADLINE_EXCEEDED, spannerException.getErrorCode());
  }

  @Test
  public void duplicateCloseIsIdempotent() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());

    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 5,
            /* cancelQueryWhenClientIsClosed= */ false);
    streamIterator.setCall(call, /* withBeginTransaction= */ false);

    streamIterator.close("First close");
    streamIterator.close("Second close");

    verify(call, times(1)).cancel("First close");
    verify(call, never()).cancel("Second close");
  }

  @Test
  public void requestPrefetchChunksSafelyNoOpsWhenCallCleared() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());

    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 5,
            /* cancelQueryWhenClientIsClosed= */ false);
    streamIterator.setCall(call, /* withBeginTransaction= */ false);

    streamIterator
        .consumer()
        .onPartialResultSet(PartialResultSet.newBuilder().setLast(true).build());
    assertTrue(streamIterator.hasNext());
    assertNotNull(streamIterator.next());
    assertFalse(streamIterator.hasNext());

    // Call is now cleared; requesting prefetch chunks should safely no-op
    streamIterator.requestPrefetchChunks();
    // Only the request during computeNext should have occurred
    verify(call, times(1)).request(1);
  }

  @Test(timeout = 10000)
  public void concurrentSetCallAndRequestPrefetchChunks() throws Exception {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    try {
      for (int i = 0; i < 50; i++) {
        SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
        when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());

        GrpcStreamIterator streamIterator =
            new GrpcStreamIterator(
                /* statement= */ null,
                /* lastStatement= */ false,
                /* prefetchChunks= */ 5,
                /* cancelQueryWhenClientIsClosed= */ false);

        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(2);
        AtomicReference<Throwable> error = new AtomicReference<>();
        AtomicBoolean requestPrefetchSucceeded = new AtomicBoolean(false);

        executor.submit(
            () -> {
              try {
                startLatch.await();
                streamIterator.setCall(call, /* withBeginTransaction= */ false);
              } catch (Throwable t) {
                error.set(t);
              } finally {
                doneLatch.countDown();
              }
            });

        executor.submit(
            () -> {
              try {
                startLatch.await();
                streamIterator.requestPrefetchChunks();
                requestPrefetchSucceeded.set(true);
              } catch (IllegalStateException ignored) {
                // If requestPrefetchChunks runs strictly before setCall begins, throwing
                // IllegalStateException is expected.
              } catch (Throwable t) {
                error.set(t);
              } finally {
                doneLatch.countDown();
              }
            });

        startLatch.countDown();
        assertTrue(doneLatch.await(5, TimeUnit.SECONDS));
        if (error.get() != null) {
          throw new AssertionError(error.get());
        }
        if (requestPrefetchSucceeded.get()) {
          verify(call).request(5);
        } else {
          verify(call, never()).request(anyInt());
        }
      }
    } finally {
      executor.shutdownNow();
    }
  }

  @Test(timeout = 10000)
  public void concurrentAddEndOfStreamFromMultipleCallbacks() throws Exception {
    ExecutorService executor = Executors.newFixedThreadPool(3);
    try {
      for (int i = 0; i < 50; i++) {
        GrpcStreamIterator streamIterator =
            new GrpcStreamIterator(
                /* statement= */ null,
                /* lastStatement= */ false,
                /* prefetchChunks= */ 1,
                /* cancelQueryWhenClientIsClosed= */ false);

        SpannerRpc.ResultStreamConsumer consumer = streamIterator.consumer();
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(3);
        AtomicReference<Throwable> error = new AtomicReference<>();

        executor.submit(
            () -> {
              try {
                startLatch.await();
                consumer.onPartialResultSet(PartialResultSet.newBuilder().setLast(true).build());
              } catch (Throwable t) {
                error.set(t);
              } finally {
                doneLatch.countDown();
              }
            });

        executor.submit(
            () -> {
              try {
                startLatch.await();
                consumer.onCompleted();
              } catch (Throwable t) {
                error.set(t);
              } finally {
                doneLatch.countDown();
              }
            });

        executor.submit(
            () -> {
              try {
                startLatch.await();
                consumer.onError(
                    SpannerExceptionFactory.newSpannerException(ErrorCode.INTERNAL, "test-error"));
              } catch (Throwable t) {
                error.set(t);
              } finally {
                doneLatch.countDown();
              }
            });

        startLatch.countDown();
        assertTrue(doneLatch.await(5, TimeUnit.SECONDS));
        if (error.get() != null) {
          throw new AssertionError(error.get());
        }

        // Verify that the iterator can be safely drained without blocking or deadlocks.
        try {
          while (streamIterator.hasNext()) {
            streamIterator.next();
          }
        } catch (SpannerException e) {
          // If onError won the race, an exception is expected.
          assertEquals(ErrorCode.INTERNAL, e.getErrorCode());
        }
      }
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  public void closeOnAlreadyCompletedStreamDoesNotDeliverSpuriousError() {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());

    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 1,
            /* cancelQueryWhenClientIsClosed= */ false);
    streamIterator.setCall(call, /* withBeginTransaction= */ false);

    streamIterator
        .consumer()
        .onPartialResultSet(PartialResultSet.newBuilder().setLast(true).build());
    assertTrue(streamIterator.hasNext());
    assertNotNull(streamIterator.next());
    assertFalse(streamIterator.hasNext());

    // Closing already completed stream should safely no-op without cancelling or setting errors
    streamIterator.close("Post-completion close");
    verify(call, never()).cancel(any());
    assertFalse(streamIterator.hasNext());
  }

  @Test
  public void testExtractTimeout() {
    SpannerRpc.StreamingCall callWithNullContext = mock(SpannerRpc.StreamingCall.class);
    when(callWithNullContext.getCallContext()).thenReturn(null);
    assertNull(GrpcStreamIterator.extractTimeout(callWithNullContext));

    SpannerRpc.StreamingCall callWithNoTimeout = mock(SpannerRpc.StreamingCall.class);
    when(callWithNoTimeout.getCallContext()).thenReturn(GrpcCallContext.createDefault());
    assertNull(GrpcStreamIterator.extractTimeout(callWithNoTimeout));

    SpannerRpc.StreamingCall callWithZeroTimeout = mock(SpannerRpc.StreamingCall.class);
    when(callWithZeroTimeout.getCallContext())
        .thenReturn(GrpcCallContext.createDefault().withStreamWaitTimeoutDuration(Duration.ZERO));
    assertNull(GrpcStreamIterator.extractTimeout(callWithZeroTimeout));

    SpannerRpc.StreamingCall callWithSecondsTimeout = mock(SpannerRpc.StreamingCall.class);
    when(callWithSecondsTimeout.getCallContext())
        .thenReturn(
            GrpcCallContext.createDefault().withStreamWaitTimeoutDuration(Duration.ofSeconds(10)));
    assertEquals(
        new GrpcStreamIterator.Timeout(10, TimeUnit.SECONDS),
        GrpcStreamIterator.extractTimeout(callWithSecondsTimeout));

    SpannerRpc.StreamingCall callWithNanosTimeout = mock(SpannerRpc.StreamingCall.class);
    when(callWithNanosTimeout.getCallContext())
        .thenReturn(
            GrpcCallContext.createDefault()
                .withStreamWaitTimeoutDuration(Duration.ofNanos(500_000)));
    assertEquals(
        new GrpcStreamIterator.Timeout(500_000, TimeUnit.NANOSECONDS),
        GrpcStreamIterator.extractTimeout(callWithNanosTimeout));
  }

  @Test
  public void testTimeoutEqualsHashCodeAndToString() {
    GrpcStreamIterator.Timeout timeout1 = new GrpcStreamIterator.Timeout(10, TimeUnit.SECONDS);
    GrpcStreamIterator.Timeout timeout2 = new GrpcStreamIterator.Timeout(10, TimeUnit.SECONDS);
    GrpcStreamIterator.Timeout timeout3 = new GrpcStreamIterator.Timeout(20, TimeUnit.SECONDS);
    GrpcStreamIterator.Timeout timeout4 = new GrpcStreamIterator.Timeout(10, TimeUnit.MILLISECONDS);

    assertEquals(timeout1, timeout2);
    assertEquals(timeout1.hashCode(), timeout2.hashCode());
    assertFalse(timeout1.equals(null));
    assertFalse(timeout1.equals("other"));
    assertFalse(timeout1.equals(timeout3));
    assertFalse(timeout1.equals(timeout4));
    assertEquals("10 SECONDS", timeout1.toString());
  }

  @Test(timeout = 5000)
  public void interruptedTakeNextFromStreamThrowsPropagateInterrupt() throws Exception {
    SpannerRpc.StreamingCall call = mock(SpannerRpc.StreamingCall.class);
    when(call.getCallContext()).thenReturn(GrpcCallContext.createDefault());

    GrpcStreamIterator streamIterator =
        new GrpcStreamIterator(
            /* statement= */ null,
            /* lastStatement= */ false,
            /* prefetchChunks= */ 5,
            /* cancelQueryWhenClientIsClosed= */ false);
    streamIterator.setCall(call, /* withBeginTransaction= */ false);

    AtomicReference<Throwable> thrown = new AtomicReference<>();
    Thread consumerThread =
        new Thread(
            () -> {
              try {
                streamIterator.hasNext();
              } catch (Throwable t) {
                thrown.set(t);
              }
            });
    consumerThread.start();

    await()
        .atMost(Duration.ofSeconds(5))
        .until(() -> consumerThread.getState() == Thread.State.WAITING);

    consumerThread.interrupt();
    consumerThread.join();

    assertNotNull(thrown.get());
    assertTrue(thrown.get() instanceof SpannerException);
    SpannerException spannerException = (SpannerException) thrown.get();
    assertEquals(ErrorCode.CANCELLED, spannerException.getErrorCode());
    assertTrue(spannerException.getCause() instanceof InterruptedException);
  }
}
