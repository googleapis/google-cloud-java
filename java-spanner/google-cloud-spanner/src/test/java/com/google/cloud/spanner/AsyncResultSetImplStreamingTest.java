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

import static com.google.cloud.spanner.AsyncResultSetImplTestUtil.NO_OP_RESULT_SET_LISTENER;
import static com.google.cloud.spanner.AsyncResultSetImplTestUtil.drainLongIdsCallback;
import static com.google.cloud.spanner.AsyncResultSetImplTestUtil.singleInt64MetadataChunk;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.spanner.AbstractResultSet.CloseableIterator;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.CursorState;
import com.google.cloud.spanner.AsyncResultSetImplTestUtil.AbstractCloseableIterator;
import com.google.cloud.spanner.AsyncResultSetImplTestUtil.ControllableStreamingDelegate;
import com.google.cloud.spanner.AsyncResultSetImplTestUtil.GrpcStreamingTestHarness;
import com.google.cloud.spanner.AsyncResultSetImplTestUtil.NoOpResultSetListener;
import com.google.cloud.spanner.AsyncResultSetImplTestUtil.QueuedExecutorProvider;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import com.google.protobuf.Value;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for event-driven streaming, non-blocking executor yielding, buffer hysteresis, and {@link
 * GrpcResultSet} startup error translation in {@link AsyncResultSetImpl}.
 */
@RunWith(JUnit4.class)
public class AsyncResultSetImplStreamingTest {
  private SpannerOptions.CloseableExecutorProvider simpleProvider;

  @Before
  public void setup() {
    simpleProvider = SpannerOptions.createAsyncExecutorProvider(1, 1L, TimeUnit.SECONDS);
  }

  @After
  public void teardown() {
    if (simpleProvider != null) {
      simpleProvider.close();
    }
  }

  @Test(timeout = 10_000)
  public void testProducerYieldsSingleThreadExecutorWhenWaitingForStreamData() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    ControllableStreamingDelegate stream = new ControllableStreamingDelegate(1);
    CountDownLatch waitingForStreamDataLatch = new CountDownLatch(1);
    CountDownLatch row1ConsumedLatch = new CountDownLatch(1);
    doAnswer(
            invocation -> {
              if (stream.consumedRows.get() == 0) {
                return stream.availableRows.get() > 0;
              }
              boolean available = stream.streamFinished.get();
              if (!available) {
                waitingForStreamDataLatch.countDown();
              }
              return available;
            })
        .when(stream.delegate)
        .isDataAvailable();

    List<Long> receivedIds = Collections.synchronizedList(new ArrayList<>());
    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(simpleProvider, stream.delegate, 4)) {
      ApiFuture<Void> resultFuture =
          resultSet.setCallback(
              callbackExecutor,
              cursor -> {
                while (true) {
                  CursorState cursorState = cursor.tryNext();
                  if (cursorState == CursorState.OK) {
                    receivedIds.add(cursor.getLong(0));
                    row1ConsumedLatch.countDown();
                  } else if (cursorState == CursorState.NOT_READY) {
                    return CallbackResponse.CONTINUE;
                  } else {
                    return CallbackResponse.DONE;
                  }
                }
              });

      AsyncResultSet.StreamMessageListener listener =
          stream.awaitStreamingInitialized(simpleProvider);
      verify(stream.delegate, times(1)).isDataAvailable();

      // Non-flushable partial chunk before resumeToken/bufferFull must not start the producer.
      listener.onStreamMessage(
          PartialResultSet.newBuilder().addValues(Value.newBuilder().setStringValue("1")).build(),
          false);
      verify(stream.delegate, times(1)).isDataAvailable();

      // Flushable chunk starts the producer, delivers row 1, then yields when !isDataAvailable().
      stream.availableRows.set(1);
      stream.emitFlushableChunk("tok1", false);
      assertTrue(row1ConsumedLatch.await(5, TimeUnit.SECONDS));
      assertTrue(waitingForStreamDataLatch.await(5, TimeUnit.SECONDS));

      // Single-thread executor must be free while waiting for the next gRPC chunk.
      assertTrue(simpleProvider.getExecutor().submit(() -> true).get(5, TimeUnit.SECONDS));

      stream.emitEndOfStream(false);
      assertNull(resultFuture.get(5, TimeUnit.SECONDS));
      assertEquals(Collections.singletonList(1L), receivedIds);
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testImmediateEndOfStreamInitiatesRowProduction() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    StreamingResultSet emptyDelegate = mock(StreamingResultSet.class);
    when(emptyDelegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
        .thenAnswer(
            invocation -> {
              AsyncResultSet.StreamMessageListener emptyListener = invocation.getArgument(0);
              emptyListener.onStreamMessage(GrpcStreamIterator.END_OF_STREAM, false);
              return true;
            });
    when(emptyDelegate.isDataAvailable()).thenReturn(true);
    when(emptyDelegate.next()).thenReturn(false);

    try (AsyncResultSetImpl immediateEofResultSet =
        new AsyncResultSetImpl(simpleProvider, emptyDelegate, 4)) {
      ApiFuture<Void> emptyFuture =
          immediateEofResultSet.setCallback(
              callbackExecutor,
              cursor -> {
                assertEquals(CursorState.DONE, cursor.tryNext());
                return CallbackResponse.DONE;
              });
      assertNull(emptyFuture.get(5, TimeUnit.SECONDS));
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testProducerYieldsSingleThreadExecutorWhenBufferIsFullAndResumesOnTryNext()
      throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    final int totalRows = 5;
    final int maxBufferSize = 2;
    AtomicInteger producedRows = new AtomicInteger();
    CountDownLatch bufferFilledLatch = new CountDownLatch(maxBufferSize);
    CountDownLatch pausedCallbackLatch = new CountDownLatch(1);

    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenAnswer(invocation -> producedRows.incrementAndGet() <= totalRows);
    when(delegate.getCurrentRowAsStruct())
        .thenAnswer(
            invocation -> {
              long id = producedRows.get();
              bufferFilledLatch.countDown();
              return Struct.newBuilder().set("id").to(id).build();
            });

    AtomicBoolean pauseOnFirstCall = new AtomicBoolean(true);
    List<Long> receivedIds = Collections.synchronizedList(new ArrayList<>());

    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, maxBufferSize)) {
      ApiFuture<Void> resultFuture =
          resultSet.setCallback(
              callbackExecutor,
              cursor -> {
                if (pauseOnFirstCall.compareAndSet(true, false)) {
                  pausedCallbackLatch.countDown();
                  return CallbackResponse.PAUSE;
                }
                return drainLongIdsCallback(receivedIds).cursorReady(cursor);
              });

      assertTrue(pausedCallbackLatch.await(5, TimeUnit.SECONDS));
      callbackExecutor.submit(() -> {}).get(5, TimeUnit.SECONDS);
      assertTrue(bufferFilledLatch.await(5, TimeUnit.SECONDS));

      // With buffer at capacity (2 rows), ProduceRowsRunnable returns without pinning the thread.
      Future<Integer> probeFuture = simpleProvider.getExecutor().submit(producedRows::get);
      assertEquals(Integer.valueOf(maxBufferSize), probeFuture.get(5, TimeUnit.SECONDS));

      resultSet.resume();
      assertNull(resultFuture.get(5, TimeUnit.SECONDS));
      assertEquals(Arrays.asList(1L, 2L, 3L, 4L, 5L), receivedIds);
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testFastStreamMessageDuringInitiateStreamingDefersProducerWithoutLosingWakeup()
      throws Exception {
    SpannerOptions.CloseableExecutorProvider twoThreadProvider =
        SpannerOptions.createAsyncExecutorProvider(2, 1L, TimeUnit.SECONDS);
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    AtomicBoolean streamPublished = new AtomicBoolean(false);
    AtomicInteger availabilityChecksWhileInitiating = new AtomicInteger();
    AtomicInteger rowIndex = new AtomicInteger();

    StreamingResultSet streamingDelegate = mock(StreamingResultSet.class);
    when(streamingDelegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
        .thenAnswer(
            invocation -> {
              AsyncResultSet.StreamMessageListener listener = invocation.getArgument(0);
              listener.onStreamMessage(
                  PartialResultSet.newBuilder()
                      .setResumeToken(ByteString.copyFromUtf8("r1"))
                      .build(),
                  false);
              listener.onStreamMessage(GrpcStreamIterator.END_OF_STREAM, false);
              assertTrue(
                  twoThreadProvider.getExecutor().submit(() -> true).get(5, TimeUnit.SECONDS));
              assertEquals(0, availabilityChecksWhileInitiating.get());
              streamPublished.set(true);
              return true;
            });
    when(streamingDelegate.isDataAvailable())
        .thenAnswer(
            invocation -> {
              boolean published = streamPublished.get();
              if (!published) {
                availabilityChecksWhileInitiating.incrementAndGet();
              }
              return published;
            });
    when(streamingDelegate.next()).thenAnswer(invocation -> rowIndex.incrementAndGet() == 1);
    when(streamingDelegate.getCurrentRowAsStruct())
        .thenReturn(Struct.newBuilder().set("id").to(42L).build());

    List<Long> receivedIds = Collections.synchronizedList(new ArrayList<>());
    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(twoThreadProvider, streamingDelegate, 4)) {
      ApiFuture<Void> resultFuture =
          resultSet.setCallback(callbackExecutor, drainLongIdsCallback(receivedIds));
      assertNull(resultFuture.get(5, TimeUnit.SECONDS));
      assertEquals(0, availabilityChecksWhileInitiating.get());
      assertEquals(Collections.singletonList(42L), receivedIds);
    } finally {
      callbackExecutor.shutdownNow();
      twoThreadProvider.close();
    }
  }

  @Test(timeout = 10_000)
  public void testCustomStreamingResultSetStartupFailureDoesNotCallNext() {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    StreamingResultSet customFailingDelegate = mock(StreamingResultSet.class);
    when(customFailingDelegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT, "custom startup error"));

    try (AsyncResultSetImpl customFailingResultSet =
        new AsyncResultSetImpl(simpleProvider, customFailingDelegate, 4)) {
      ApiFuture<Void> customFailingFuture =
          customFailingResultSet.setCallback(
              callbackExecutor,
              cursor -> {
                cursor.tryNext();
                return CallbackResponse.DONE;
              });
      ExecutionException customExecutionException =
          assertThrows(
              ExecutionException.class, () -> customFailingFuture.get(5, TimeUnit.SECONDS));
      assertEquals(
          ErrorCode.INVALID_ARGUMENT,
          ((SpannerException) customExecutionException.getCause()).getErrorCode());
      verify(customFailingDelegate, never()).next();
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testFastEndOfStreamBeforeGrpcInitiateStreamingThrowsPreservesSingleConsumer() {
    SpannerOptions.CloseableExecutorProvider twoThreadProvider =
        SpannerOptions.createAsyncExecutorProvider(2, 1L, TimeUnit.SECONDS);
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    AtomicInteger activeDelegateCalls = new AtomicInteger();
    AtomicInteger maxConcurrentDelegateCalls = new AtomicInteger();
    Runnable enterDelegate =
        () -> {
          int concurrent = activeDelegateCalls.incrementAndGet();
          maxConcurrentDelegateCalls.accumulateAndGet(concurrent, Math::max);
        };
    AbstractResultSet.Listener translatingListener =
        new NoOpResultSetListener() {
          @Override
          public SpannerException onError(
              SpannerException exception, boolean withBeginTransaction, boolean lastStatement) {
            return SpannerExceptionFactory.newSpannerException(
                ErrorCode.ABORTED, "translated startup error", exception);
          }
        };
    CloseableIterator<PartialResultSet> failingIterator =
        new AbstractCloseableIterator(true) {
          @Override
          public boolean initiateStreaming(
              AsyncResultSet.StreamMessageListener streamMessageListener) {
            enterDelegate.run();
            try {
              streamMessageListener.onStreamMessage(GrpcStreamIterator.END_OF_STREAM, false);
              assertTrue(
                  twoThreadProvider.getExecutor().submit(() -> true).get(5, TimeUnit.SECONDS));
              throw SpannerExceptionFactory.newSpannerException(
                  ErrorCode.CANCELLED, "raw startup error");
            } catch (InterruptedException | ExecutionException | TimeoutException exception) {
              throw new RuntimeException(exception);
            } finally {
              activeDelegateCalls.decrementAndGet();
            }
          }

          @Override
          public boolean isDataAvailable() {
            enterDelegate.run();
            try {
              return true;
            } finally {
              activeDelegateCalls.decrementAndGet();
            }
          }

          @Override
          public boolean hasNext() {
            enterDelegate.run();
            try {
              throw SpannerExceptionFactory.newSpannerException(
                  ErrorCode.CANCELLED, "raw startup error");
            } finally {
              activeDelegateCalls.decrementAndGet();
            }
          }
        };

    try (AsyncResultSetImpl failingResultSet =
        new AsyncResultSetImpl(
            twoThreadProvider, () -> new GrpcResultSet(failingIterator, translatingListener), 4)) {
      ApiFuture<Void> failingFuture =
          failingResultSet.setCallback(
              callbackExecutor,
              cursor -> {
                cursor.tryNext();
                return CallbackResponse.DONE;
              });
      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> failingFuture.get(5, TimeUnit.SECONDS));
      assertEquals(
          ErrorCode.ABORTED, ((SpannerException) executionException.getCause()).getErrorCode());
      assertEquals(1, maxConcurrentDelegateCalls.get());
    } finally {
      callbackExecutor.shutdownNow();
      twoThreadProvider.close();
    }
  }

  @Test(timeout = 10_000)
  public void testProducerWakeupInLoopAndInFinallyPreservesSingleConsumer() throws Exception {
    ExecutorService callbackBackingExecutor = Executors.newSingleThreadExecutor();
    ExecutorService grpcDeliveryExecutor = Executors.newSingleThreadExecutor();
    ControllableStreamingDelegate stream = new ControllableStreamingDelegate(2);
    AtomicInteger activeDelegateCalls = new AtomicInteger();
    AtomicInteger maxConcurrentDelegateCalls = new AtomicInteger();
    AtomicInteger isDataAvailableCalls = new AtomicInteger();
    AtomicBoolean triggerFinallyWakeupOnCallbackSchedule = new AtomicBoolean(false);

    Runnable enterDelegateCall =
        () -> {
          int concurrent = activeDelegateCalls.incrementAndGet();
          maxConcurrentDelegateCalls.accumulateAndGet(concurrent, Math::max);
        };

    doAnswer(
            invocation -> {
              enterDelegateCall.run();
              try {
                stream.listenerRef.set(invocation.getArgument(0));
                stream.listenerRegistered.countDown();
                return true;
              } finally {
                activeDelegateCalls.decrementAndGet();
              }
            })
        .when(stream.delegate)
        .initiateStreaming(any(AsyncResultSet.StreamMessageListener.class));
    doAnswer(
            invocation -> {
              enterDelegateCall.run();
              int call = isDataAvailableCalls.incrementAndGet();
              try {
                if (call == 1) {
                  return false;
                }
                if (call == 2) {
                  grpcDeliveryExecutor
                      .submit(() -> stream.emitFlushableChunk("tok2", false))
                      .get(5, TimeUnit.SECONDS);
                  return false;
                }
                if (call == 3 || call == 4) {
                  return true;
                }
                if (call == 5) {
                  triggerFinallyWakeupOnCallbackSchedule.set(true);
                  return false;
                }
                return stream.streamFinished.get();
              } finally {
                activeDelegateCalls.decrementAndGet();
              }
            })
        .when(stream.delegate)
        .isDataAvailable();
    doAnswer(
            invocation -> {
              enterDelegateCall.run();
              try {
                return stream.consumedRows.incrementAndGet() <= 2;
              } finally {
                activeDelegateCalls.decrementAndGet();
              }
            })
        .when(stream.delegate)
        .next();

    Executor hookingCallbackExecutor =
        command -> {
          if (triggerFinallyWakeupOnCallbackSchedule.compareAndSet(true, false)) {
            stream.emitEndOfStream(false);
          }
          callbackBackingExecutor.execute(command);
        };

    List<Long> receivedIds = Collections.synchronizedList(new ArrayList<>());
    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(simpleProvider, stream.delegate, 4)) {
      ApiFuture<Void> resultFuture =
          resultSet.setCallback(hookingCallbackExecutor, drainLongIdsCallback(receivedIds));

      stream.awaitStreamingInitialized(simpleProvider);
      stream.emitFlushableChunk("tok1", false);

      assertNull(resultFuture.get(5, TimeUnit.SECONDS));
      assertEquals(Arrays.asList(1L, 2L), receivedIds);
      assertEquals(1, maxConcurrentDelegateCalls.get());
    } finally {
      grpcDeliveryExecutor.shutdownNow();
      callbackBackingExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testIsDataAvailableFailurePropagatesThroughNextToCallbackAndResultFuture() {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    StreamingResultSet streamingDelegate = mock(StreamingResultSet.class);
    when(streamingDelegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
        .thenAnswer(
            invocation -> {
              AsyncResultSet.StreamMessageListener listener = invocation.getArgument(0);
              listener.onStreamMessage(GrpcStreamIterator.END_OF_STREAM, false);
              return true;
            });
    when(streamingDelegate.isDataAvailable())
        .thenThrow(new IllegalStateException("unexpected availability failure"));
    when(streamingDelegate.next())
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(ErrorCode.UNAVAILABLE, "stream broken"));

    AtomicReference<SpannerException> callbackObservedException = new AtomicReference<>();
    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(simpleProvider, streamingDelegate, 4)) {
      ApiFuture<Void> resultFuture =
          resultSet.setCallback(
              callbackExecutor,
              cursor -> {
                SpannerException thrown = assertThrows(SpannerException.class, cursor::tryNext);
                callbackObservedException.set(thrown);
                throw thrown;
              });

      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> resultFuture.get(5, TimeUnit.SECONDS));
      assertEquals(
          ErrorCode.UNAVAILABLE, ((SpannerException) executionException.getCause()).getErrorCode());
      assertNotNull(callbackObservedException.get());
      assertEquals(ErrorCode.UNAVAILABLE, callbackObservedException.get().getErrorCode());
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testGrpcInitiateStreamingFailureTranslatesErrorViaListenerWithoutSecondRpc()
      throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    SettableApiFuture<ByteString> transactionIdFuture = SettableApiFuture.create();
    List<String> listenerEvents = Collections.synchronizedList(new ArrayList<>());
    AtomicInteger initiateStreamingCalls = new AtomicInteger();
    AtomicInteger hasNextCalls = new AtomicInteger();

    AbstractResultSet.Listener listener =
        new NoOpResultSetListener() {
          @Override
          public SpannerException onError(
              SpannerException exception, boolean withBeginTransaction, boolean lastStatement) {
            listenerEvents.add("onError:" + withBeginTransaction);
            SpannerException translated =
                withBeginTransaction && exception.getErrorCode() == ErrorCode.CANCELLED
                    ? SpannerExceptionFactory.newSpannerException(
                        ErrorCode.ABORTED, "Transaction was aborted", exception)
                    : exception;
            if (withBeginTransaction && !transactionIdFuture.isDone()) {
              transactionIdFuture.setException(translated);
            }
            return translated;
          }

          @Override
          public void onDone(boolean withBeginTransaction) {
            listenerEvents.add("onDone:" + withBeginTransaction);
          }
        };

    SpannerException startupException =
        SpannerExceptionFactory.asSpannerException(
            Status.CANCELLED.withDescription("Transaction was aborted").asRuntimeException());

    CloseableIterator<PartialResultSet> failingIterator =
        new AbstractCloseableIterator(true) {
          @Override
          public boolean initiateStreaming(
              AsyncResultSet.StreamMessageListener streamMessageListener) {
            initiateStreamingCalls.incrementAndGet();
            throw startupException;
          }

          @Override
          public boolean isDataAvailable() {
            return initiateStreamingCalls.get() > 0;
          }

          @Override
          public boolean hasNext() {
            hasNextCalls.incrementAndGet();
            throw startupException;
          }
        };

    AtomicReference<SpannerException> callbackException = new AtomicReference<>();
    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(
            simpleProvider, () -> new GrpcResultSet(failingIterator, listener), 4)) {
      ApiFuture<Void> resultFuture =
          resultSet.setCallback(
              callbackExecutor,
              cursor -> {
                SpannerException thrown = assertThrows(SpannerException.class, cursor::tryNext);
                callbackException.set(thrown);
                throw thrown;
              });

      ExecutionException futureExecutionException =
          assertThrows(ExecutionException.class, () -> resultFuture.get(5, TimeUnit.SECONDS));
      SpannerException futureException = (SpannerException) futureExecutionException.getCause();
      assertEquals(ErrorCode.ABORTED, futureException.getErrorCode());
      assertNotNull(callbackException.get());
      assertEquals(ErrorCode.ABORTED, callbackException.get().getErrorCode());

      ExecutionException txExecutionException =
          assertThrows(
              ExecutionException.class, () -> transactionIdFuture.get(5, TimeUnit.SECONDS));
      assertSame(futureException, txExecutionException.getCause());
      assertEquals(1, initiateStreamingCalls.get());
      assertEquals(1, hasNextCalls.get());
      assertEquals(Arrays.asList("onError:true", "onDone:true"), listenerEvents);
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testForwardingResultSetWrappingNonStreamingResultSetDeliversRowsIncrementally()
      throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    CountDownLatch allowRow2Latch = new CountDownLatch(1);
    AtomicInteger nextCalls = new AtomicInteger();
    ResultSet blockingNonStreaming = mock(ResultSet.class);
    when(blockingNonStreaming.next())
        .thenAnswer(
            invocation -> {
              int call = nextCalls.incrementAndGet();
              if (call == 1) {
                return true;
              }
              if (call == 2) {
                assertTrue(allowRow2Latch.await(5, TimeUnit.SECONDS));
                return true;
              }
              return false;
            });
    when(blockingNonStreaming.getCurrentRowAsStruct())
        .thenAnswer(invocation -> Struct.newBuilder().set("id").to((long) nextCalls.get()).build());

    List<Long> received = Collections.synchronizedList(new ArrayList<>());
    try (AsyncResultSetImpl wrappedBlocking =
        new AsyncResultSetImpl(simpleProvider, new ForwardingResultSet(blockingNonStreaming), 10)) {
      ApiFuture<Void> future =
          wrappedBlocking.setCallback(
              callbackExecutor,
              cursor -> {
                while (true) {
                  CursorState cursorState = cursor.tryNext();
                  if (cursorState == CursorState.OK) {
                    long id = cursor.getLong(0);
                    received.add(id);
                    if (id == 1L) {
                      allowRow2Latch.countDown();
                    }
                  } else if (cursorState == CursorState.NOT_READY) {
                    return CallbackResponse.CONTINUE;
                  } else {
                    return CallbackResponse.DONE;
                  }
                }
              });
      assertNull(future.get(5, TimeUnit.SECONDS));
      assertEquals(Arrays.asList(1L, 2L), received);
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testNonStreamingInlineCallbackPauseAndDoneStopsProducerImmediately()
      throws Exception {
    QueuedExecutorProvider queuedProvider = new QueuedExecutorProvider(false);

    // 1. Inline directExecutor() callback returning DONE after row 1 must stop ProduceRowsRunnable
    // immediately without pulling row 2.
    AtomicInteger doneNextCalls = new AtomicInteger();
    ResultSet doneDelegate = mock(ResultSet.class);
    when(doneDelegate.next()).thenAnswer(invocation -> doneNextCalls.incrementAndGet() <= 3);
    when(doneDelegate.getCurrentRowAsStruct())
        .thenAnswer(
            invocation -> Struct.newBuilder().set("id").to((long) doneNextCalls.get()).build());

    try (AsyncResultSetImpl doneResultSet =
        new AsyncResultSetImpl(queuedProvider, doneDelegate, 10)) {
      ApiFuture<Void> doneFuture =
          doneResultSet.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                assertEquals(CursorState.OK, cursor.tryNext());
                assertEquals(1L, cursor.getLong(0));
                return CallbackResponse.DONE;
              });
      queuedProvider.runNext(); // InitiateStreamingRunnable
      queuedProvider.runNext(); // ProduceRowsRunnable
      assertNull(doneFuture.get(5, TimeUnit.SECONDS));
      assertEquals(1, doneNextCalls.get());
    }

    // 2. Inline directExecutor() callback returning PAUSE after row 1 must stop ProduceRowsRunnable
    // immediately until resume() is called.
    AtomicInteger pauseNextCalls = new AtomicInteger();
    ResultSet pauseDelegate = mock(ResultSet.class);
    when(pauseDelegate.next()).thenAnswer(invocation -> pauseNextCalls.incrementAndGet() <= 3);
    when(pauseDelegate.getCurrentRowAsStruct())
        .thenAnswer(
            invocation -> Struct.newBuilder().set("id").to((long) pauseNextCalls.get()).build());

    AtomicBoolean pauseOnFirstRow = new AtomicBoolean(true);
    List<Long> receivedIds = new ArrayList<>();
    try (AsyncResultSetImpl pauseResultSet =
        new AsyncResultSetImpl(queuedProvider, pauseDelegate, 10)) {
      ApiFuture<Void> pauseFuture =
          pauseResultSet.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                if (pauseOnFirstRow.compareAndSet(true, false)) {
                  assertEquals(CursorState.OK, cursor.tryNext());
                  receivedIds.add(cursor.getLong(0));
                  return CallbackResponse.PAUSE;
                }
                return drainLongIdsCallback(receivedIds).cursorReady(cursor);
              });
      queuedProvider.runNext(); // InitiateStreamingRunnable
      queuedProvider.runNext(); // ProduceRowsRunnable -> row 1 -> inline PAUSE -> breaks!
      assertEquals(1, pauseNextCalls.get());
      assertEquals(AsyncResultSetImpl.State.PAUSED, pauseResultSet.getState());

      pauseResultSet.resume();
      queuedProvider.runNext(); // ProduceRowsRunnable -> rows 2 and 3 + EOF
      assertNull(pauseFuture.get(5, TimeUnit.SECONDS));
      assertEquals(Arrays.asList(1L, 2L, 3L), receivedIds);
    }
  }

  @Test(timeout = 10_000)
  public void testForwardingResultSetWrappingGrpcResultSetAndFailingLazySupplier() {
    AbstractResultSet.Listener translatingListener =
        new NoOpResultSetListener() {
          @Override
          public SpannerException onError(
              SpannerException exception, boolean withBeginTransaction, boolean lastStatement) {
            return SpannerExceptionFactory.newSpannerException(
                ErrorCode.ABORTED, "wrapped grpc startup translated", exception);
          }
        };
    CloseableIterator<PartialResultSet> failingIterator =
        new AbstractCloseableIterator(true) {
          @Override
          public boolean initiateStreaming(AsyncResultSet.StreamMessageListener listener) {
            throw new UnsupportedOperationException("grpc startup failed");
          }

          @Override
          public boolean hasNext() {
            throw SpannerExceptionFactory.newSpannerException(ErrorCode.CANCELLED, "raw cancelled");
          }
        };
    ResultSet doubleWrappedGrpc =
        new ForwardingResultSet(
            new ForwardingResultSet(new GrpcResultSet(failingIterator, translatingListener)));
    try (AsyncResultSetImpl wrappedGrpcResultSet =
        new AsyncResultSetImpl(simpleProvider, doubleWrappedGrpc, 4)) {
      ExecutionException failure =
          assertThrows(
              ExecutionException.class,
              () ->
                  wrappedGrpcResultSet
                      .toListAsync(reader -> reader.getLong(0), MoreExecutors.directExecutor())
                      .get(5, TimeUnit.SECONDS));
      assertEquals(ErrorCode.ABORTED, ((SpannerException) failure.getCause()).getErrorCode());
    }

    ForwardingResultSet brokenLazyWrapper =
        new ForwardingResultSet(
            (Supplier<ResultSet>)
                () -> {
                  throw SpannerExceptionFactory.newSpannerException(
                      ErrorCode.UNAUTHENTICATED, "lazy delegate supplier failed");
                });
    try (AsyncResultSetImpl brokenWrapperResultSet =
        new AsyncResultSetImpl(simpleProvider, brokenLazyWrapper, 4)) {
      ExecutionException failure =
          assertThrows(
              ExecutionException.class,
              () ->
                  brokenWrapperResultSet
                      .toListAsync(reader -> reader.getLong(0), MoreExecutors.directExecutor())
                      .get(5, TimeUnit.SECONDS));
      assertEquals(
          ErrorCode.UNAUTHENTICATED, ((SpannerException) failure.getCause()).getErrorCode());
    }
  }

  @Test(timeout = 10_000)
  public void testGrpcInitiateStreamingFailureEdgeCases() {
    // mode 0: !isDataAvailable() preserves startup exception.
    // mode 1: isDataAvailable() == true and next() genuinely returns false (valid metadata chunk
    // followed by EOF) without throwing, preserving the original UNKNOWN startup exception.
    // mode 2: cancel() during initiateStreaming() skips next() and completes with CANCELLED.
    for (int mode = 0; mode < 3; mode++) {
      final int currentMode = mode;
      final AtomicBoolean metadataEmitted = new AtomicBoolean(false);
      CloseableIterator<PartialResultSet> iterator =
          new AbstractCloseableIterator(false) {
            @Override
            public boolean isDataAvailable() {
              return currentMode == 1;
            }

            @Override
            public boolean initiateStreaming(AsyncResultSet.StreamMessageListener listener) {
              throw SpannerExceptionFactory.newSpannerException(
                  ErrorCode.UNKNOWN, "startup failure " + currentMode);
            }

            @Override
            public boolean hasNext() {
              return currentMode == 1 && !metadataEmitted.get();
            }

            @Override
            public PartialResultSet next() {
              if (currentMode == 1 && metadataEmitted.compareAndSet(false, true)) {
                return singleInt64MetadataChunk();
              }
              throw new NoSuchElementException();
            }
          };
      GrpcResultSet grpcDelegate = new GrpcResultSet(iterator, NO_OP_RESULT_SET_LISTENER);
      AtomicReference<AsyncResultSetImpl> holder = new AtomicReference<>();
      AsyncResultSetImpl grpcAsyncResultSet =
          new AsyncResultSetImpl(
              simpleProvider,
              () -> {
                if (currentMode == 2) {
                  holder.get().cancel();
                }
                return grpcDelegate;
              },
              4);
      holder.set(grpcAsyncResultSet);
      try (AsyncResultSetImpl ignored = grpcAsyncResultSet) {
        ExecutionException failure =
            assertThrows(
                ExecutionException.class,
                () ->
                    grpcAsyncResultSet
                        .toListAsync(reader -> reader.getLong(0), MoreExecutors.directExecutor())
                        .get(5, TimeUnit.SECONDS));
        SpannerException cause = (SpannerException) failure.getCause();
        if (currentMode == 2) {
          assertEquals(ErrorCode.CANCELLED, cause.getErrorCode());
        } else {
          assertEquals(ErrorCode.UNKNOWN, cause.getErrorCode());
          assertTrue(cause.getMessage().contains("startup failure " + currentMode));
        }
      }
    }
  }

  @Test(timeout = 10_000)
  public void testBufferHysteresisPartialConsumptionDispatchesZeroExtraProducerTasks()
      throws Exception {
    QueuedExecutorProvider queuedProvider = new QueuedExecutorProvider(false);
    ControllableStreamingDelegate partialStream = new ControllableStreamingDelegate(3);
    List<Long> partialReceived = new ArrayList<>();
    try (AsyncResultSetImpl partialResultSet =
        new AsyncResultSetImpl(queuedProvider, partialStream.delegate, 10)) {
      ApiFuture<Void> future =
          partialResultSet.setCallback(
              MoreExecutors.directExecutor(), drainLongIdsCallback(partialReceived));

      assertEquals(1, queuedProvider.tasks.size());
      queuedProvider.runNext(); // InitiateStreamingRunnable
      assertTrue(queuedProvider.tasks.isEmpty());

      partialStream.availableRows.set(3);
      partialStream.emitFlushableChunk("chunk1", false);
      assertEquals(1, queuedProvider.tasks.size());
      queuedProvider.runNext(); // ProduceRowsRunnable
      assertEquals(Arrays.asList(1L, 2L, 3L), partialReceived);
      assertTrue(queuedProvider.tasks.isEmpty());

      partialStream.emitEndOfStream(false);
      assertEquals(1, queuedProvider.tasks.size());
      queuedProvider.runNext();
      assertNull(future.get(5, TimeUnit.SECONDS));
    }
  }

  @Test(timeout = 10_000)
  public void testBufferHysteresisBatchThresholdDispatchesSingleRefillTask() throws Exception {
    QueuedExecutorProvider queuedProvider = new QueuedExecutorProvider(false);
    ControllableStreamingDelegate batchStream = new ControllableStreamingDelegate(15);
    List<Long> batchReceived = new ArrayList<>();
    AtomicBoolean pauseAfterEachRow = new AtomicBoolean(true);
    try (AsyncResultSetImpl batchResultSet =
        new AsyncResultSetImpl(queuedProvider, batchStream.delegate, 10)) {
      ApiFuture<Void> future =
          batchResultSet.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                while (true) {
                  switch (cursor.tryNext()) {
                    case OK:
                      batchReceived.add(cursor.getLong(0));
                      if (pauseAfterEachRow.get()) {
                        return CallbackResponse.PAUSE;
                      }
                      break;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                    case DONE:
                      return CallbackResponse.DONE;
                  }
                }
              });

      queuedProvider.runNext(); // InitiateStreamingRunnable
      assertTrue(queuedProvider.tasks.isEmpty());

      batchStream.availableRows.set(15);
      batchStream.emitEndOfStream(true);
      assertEquals(1, queuedProvider.tasks.size());
      queuedProvider.runNext(); // ProduceRowsRunnable buffers 10 rows -> callback reads row 1
      assertEquals(10, batchStream.consumedRows.get());
      assertEquals(1, batchReceived.size());
      assertTrue(queuedProvider.tasks.isEmpty());

      // Incoming stream message while waitingForBufferSpace is true schedules 0 tasks.
      batchStream.emitEndOfStream(true);
      assertTrue(queuedProvider.tasks.isEmpty());

      for (int expectedConsumed = 2; expectedConsumed <= 5; expectedConsumed++) {
        batchResultSet.resume();
        assertEquals(expectedConsumed, batchReceived.size());
        assertTrue(queuedProvider.tasks.isEmpty());
      }

      pauseAfterEachRow.set(false);
      batchResultSet.resume();
      assertEquals(10, batchReceived.size());
      assertEquals(1, queuedProvider.tasks.size());

      queuedProvider.runNext();
      assertTrue(queuedProvider.tasks.isEmpty());
      assertNull(future.get(5, TimeUnit.SECONDS));
      assertEquals(15, batchReceived.size());
    }
  }

  @Test(timeout = 10_000)
  public void testPreClosedStreamingDelegateCompletesWhenDataImmediatelyAvailable() {
    StreamingResultSet preClosedStreamingDelegate = mock(StreamingResultSet.class);
    when(preClosedStreamingDelegate.initiateStreaming(
            any(AsyncResultSet.StreamMessageListener.class)))
        .thenReturn(true);
    when(preClosedStreamingDelegate.isDataAvailable()).thenReturn(true);
    when(preClosedStreamingDelegate.next()).thenReturn(false);
    try (AsyncResultSetImpl preClosedResultSet =
        new AsyncResultSetImpl(simpleProvider, preClosedStreamingDelegate, 4)) {
      assertTrue(preClosedResultSet.toList(reader -> reader.getLong(0)).isEmpty());
    }
  }

  @Test(timeout = 10_000)
  public void testMidStreamErrorReinvokesCallbackAfterPartialConsumption() {
    QueuedExecutorProvider queuedProvider = new QueuedExecutorProvider(false);
    ResultSet oneRowThenErrorDelegate = mock(ResultSet.class);
    when(oneRowThenErrorDelegate.next())
        .thenReturn(true)
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(ErrorCode.UNAVAILABLE, "mid-stream fail"));
    when(oneRowThenErrorDelegate.getCurrentRowAsStruct())
        .thenReturn(Struct.newBuilder().set("id").to(1L).build());
    BlockingDeque<Runnable> gatedCallbacks = new LinkedBlockingDeque<>();
    try (AsyncResultSetImpl midStreamErrorResultSet =
        new AsyncResultSetImpl(queuedProvider, oneRowThenErrorDelegate, 4)) {
      AtomicInteger callbackInvocations = new AtomicInteger();
      ApiFuture<Void> future =
          midStreamErrorResultSet.setCallback(
              gatedCallbacks::addLast,
              cursor -> {
                if (callbackInvocations.incrementAndGet() == 1) {
                  assertEquals(CursorState.OK, cursor.tryNext());
                  assertEquals(1L, cursor.getLong(0));
                  return CallbackResponse.CONTINUE;
                }
                cursor.tryNext();
                return CallbackResponse.DONE;
              });
      queuedProvider.runNext();
      queuedProvider.runNext();
      assertTrue(queuedProvider.tasks.isEmpty());
      assertEquals(1, gatedCallbacks.size());
      gatedCallbacks.removeFirst().run();
      ExecutionException midStreamFailure =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertEquals(
          ErrorCode.UNAVAILABLE, ((SpannerException) midStreamFailure.getCause()).getErrorCode());
      assertEquals(2, callbackInvocations.get());
    }
  }

  @Test(timeout = 10_000)
  public void testLateStreamMessageAfterInitiateStreamingFailureDoesNotClobberConsumingState() {
    QueuedExecutorProvider queuedProvider = new QueuedExecutorProvider(false);
    AtomicReference<AsyncResultSet.StreamMessageListener> lateErrorListenerRef =
        new AtomicReference<>();
    StreamingResultSet failingAfterRegisterDelegate = mock(StreamingResultSet.class);
    when(failingAfterRegisterDelegate.initiateStreaming(
            any(AsyncResultSet.StreamMessageListener.class)))
        .thenAnswer(
            invocation -> {
              lateErrorListenerRef.set(invocation.getArgument(0));
              throw SpannerExceptionFactory.newSpannerException(
                  ErrorCode.UNAVAILABLE, "init failed after register");
            });
    BlockingDeque<Runnable> lateErrorCallbacks = new LinkedBlockingDeque<>();
    try (AsyncResultSetImpl lateErrorResultSet =
        new AsyncResultSetImpl(queuedProvider, failingAfterRegisterDelegate, 4)) {
      ApiFuture<Void> future =
          lateErrorResultSet.setCallback(
              lateErrorCallbacks::addLast,
              cursor -> {
                cursor.tryNext();
                return CallbackResponse.DONE;
              });
      queuedProvider.runNext(); // InitiateStreamingRunnable -> catches error -> CONSUMING
      assertEquals(AsyncResultSetImpl.State.CONSUMING, lateErrorResultSet.getState());
      lateErrorListenerRef.get().onStreamMessage(GrpcStreamIterator.END_OF_STREAM, true);
      assertEquals(AsyncResultSetImpl.State.CONSUMING, lateErrorResultSet.getState());
      assertTrue(queuedProvider.tasks.isEmpty());
      lateErrorCallbacks.removeFirst().run();
      ExecutionException exec =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertEquals(ErrorCode.UNAVAILABLE, ((SpannerException) exec.getCause()).getErrorCode());
    }
  }

  @Test(timeout = 10_000)
  public void testSingleRowPerCallbackContinueReachesDoneAfterLastBufferedRow() throws Exception {
    QueuedExecutorProvider queuedProvider = new QueuedExecutorProvider(false);
    ResultSet twoRowDelegate = mock(ResultSet.class);
    when(twoRowDelegate.next()).thenReturn(true, true, false);
    when(twoRowDelegate.getCurrentRowAsStruct())
        .thenReturn(
            Struct.newBuilder().set("id").to(1L).build(),
            Struct.newBuilder().set("id").to(2L).build());
    BlockingDeque<Runnable> gatedCallbacks = new LinkedBlockingDeque<>();
    List<Long> receivedIds = new ArrayList<>();
    AtomicInteger callbackInvocations = new AtomicInteger();
    try (AsyncResultSetImpl singleRowConsumerResultSet =
        new AsyncResultSetImpl(queuedProvider, twoRowDelegate, 4)) {
      ApiFuture<Void> future =
          singleRowConsumerResultSet.setCallback(
              gatedCallbacks::addLast,
              cursor -> {
                callbackInvocations.incrementAndGet();
                switch (cursor.tryNext()) {
                  case OK:
                    receivedIds.add(cursor.getLong(0));
                    return CallbackResponse.CONTINUE;
                  case NOT_READY:
                    return CallbackResponse.CONTINUE;
                  case DONE:
                    return CallbackResponse.DONE;
                  default:
                    throw new AssertionError("Unexpected CursorState");
                }
              });
      // Run InitiateStreamingRunnable + ProduceRowsRunnable so both rows and finished=true are
      // buffered before CallbackRunnable executes.
      queuedProvider.runNext();
      queuedProvider.runNext();
      assertTrue(queuedProvider.tasks.isEmpty());
      assertEquals(1, gatedCallbacks.size());
      gatedCallbacks.removeFirst().run();

      assertNull(future.get(5, TimeUnit.SECONDS));
      assertEquals(Arrays.asList(1L, 2L), receivedIds);
      assertEquals(3, callbackInvocations.get());
    }
  }

  @Test(timeout = 10_000)
  public void testStreamingFlushesWhenChunksWithoutResumeTokenExceedMaxBufferedChunks()
      throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    final int maxBufferedChunks = 512;
    final int prefetchChunks = 1000;
    final int unflushedChunkCount = maxBufferedChunks + 1;
    GrpcStreamingTestHarness harness =
        new GrpcStreamingTestHarness(maxBufferedChunks, prefetchChunks);

    List<Long> receivedIds = Collections.synchronizedList(new ArrayList<>());
    CountDownLatch flushedBeforeEofLatch = new CountDownLatch(1);
    try (GrpcResultSet grpcResultSet = harness.newGrpcResultSet();
        AsyncResultSetImpl resultSet = new AsyncResultSetImpl(simpleProvider, grpcResultSet, 64)) {
      ApiFuture<Void> future =
          resultSet.setCallback(
              callbackExecutor,
              cursor -> {
                while (true) {
                  switch (cursor.tryNext()) {
                    case OK:
                      receivedIds.add(cursor.getLong(0));
                      if (receivedIds.size() == unflushedChunkCount) {
                        flushedBeforeEofLatch.countDown();
                      }
                      break;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                    case DONE:
                      return CallbackResponse.DONE;
                  }
                }
              });

      GrpcStreamIterator grpcStream = harness.awaitStreamingInitialized(simpleProvider);
      for (int chunkIndex = 1; chunkIndex <= unflushedChunkCount; chunkIndex++) {
        PartialResultSet.Builder chunkBuilder =
            PartialResultSet.newBuilder()
                .addValues(Value.newBuilder().setStringValue(String.valueOf(chunkIndex)));
        if (chunkIndex == 1) {
          chunkBuilder.setMetadata(singleInt64MetadataChunk().getMetadata());
        }
        grpcStream.consumer().onPartialResultSet(chunkBuilder.build());
      }

      // Even though no resumeToken arrived, bufferIsFull is false (513 < 1000), and the stream has
      // not completed yet, ResumableStreamIterator has exceeded maxBufferedChunks (512) and all
      // 513 rows must be flushed to the callback without stalling.
      assertTrue(flushedBeforeEofLatch.await(2, TimeUnit.SECONDS));
      assertEquals(unflushedChunkCount, receivedIds.size());

      grpcStream.consumer().onCompleted();
      assertNull(future.get(5, TimeUnit.SECONDS));
      assertEquals(unflushedChunkCount, receivedIds.size());
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testLargeBufferSizeSchedulesCallbackAtDefaultBatchThresholdBeforeBlockingNext()
      throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    AtomicInteger producedCount = new AtomicInteger();
    CountDownLatch firstBatchConsumedLatch = new CountDownLatch(1);
    StreamingResultSet streamingDelegate = mock(StreamingResultSet.class);
    when(streamingDelegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
        .thenAnswer(
            invocation -> {
              AsyncResultSet.StreamMessageListener listener = invocation.getArgument(0);
              listener.onStreamMessage(
                  PartialResultSet.newBuilder()
                      .setResumeToken(ByteString.copyFromUtf8("r1"))
                      .build(),
                  false);
              return true;
            });
    when(streamingDelegate.isDataAvailable()).thenReturn(true);
    when(streamingDelegate.next())
        .thenAnswer(
            invocation -> {
              int current = producedCount.incrementAndGet();
              if (current <= AsyncResultSetImpl.DEFAULT_BUFFER_SIZE) {
                return true;
              }
              // Simulate row 11 blocking in mid-stream retry backoff; rows 1..10 must already have
              // been dispatched to callbackExecutor even though maxBufferSize (100) is not full.
              assertTrue(firstBatchConsumedLatch.await(2, TimeUnit.SECONDS));
              return false;
            });
    when(streamingDelegate.getCurrentRowAsStruct())
        .thenAnswer(
            invocation -> Struct.newBuilder().set("id").to((long) producedCount.get()).build());

    List<Long> receivedIds = Collections.synchronizedList(new ArrayList<>());
    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(simpleProvider, streamingDelegate, 100)) {
      ApiFuture<Void> future =
          resultSet.setCallback(
              callbackExecutor,
              cursor -> {
                while (true) {
                  switch (cursor.tryNext()) {
                    case OK:
                      receivedIds.add(cursor.getLong(0));
                      if (receivedIds.size() == AsyncResultSetImpl.DEFAULT_BUFFER_SIZE) {
                        firstBatchConsumedLatch.countDown();
                      }
                      break;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                    case DONE:
                      return CallbackResponse.DONE;
                  }
                }
              });

      assertNull(future.get(5, TimeUnit.SECONDS));
      assertEquals(AsyncResultSetImpl.DEFAULT_BUFFER_SIZE, receivedIds.size());
      assertEquals(Long.valueOf(1L), receivedIds.get(0));
      assertEquals(Long.valueOf(10L), receivedIds.get(9));
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testChunkedStringValueSplitAcrossChunksYieldsAndMergesCleanly() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    GrpcStreamingTestHarness harness = new GrpcStreamingTestHarness(16, 8);
    ResultSetMetadata stringColumnMetadata =
        ResultSetMetadata.newBuilder()
            .setRowType(
                Type.struct(Type.StructField.of("payload", Type.string()))
                    .toProto()
                    .getStructType())
            .build();

    List<String> receivedValues = Collections.synchronizedList(new ArrayList<>());
    try (GrpcResultSet grpcResultSet = harness.newGrpcResultSet();
        AsyncResultSetImpl resultSet = new AsyncResultSetImpl(simpleProvider, grpcResultSet, 4)) {
      ApiFuture<Void> future =
          resultSet.setCallback(
              callbackExecutor,
              cursor -> {
                while (true) {
                  switch (cursor.tryNext()) {
                    case OK:
                      receivedValues.add(cursor.getString(0));
                      break;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                    case DONE:
                      return CallbackResponse.DONE;
                  }
                }
              });

      GrpcStreamIterator grpcStream = harness.awaitStreamingInitialized(simpleProvider);

      // Deliver chunk 1 with chunked_value=true and a resume token: ProduceRowsRunnable wakes up,
      // sees GrpcValueIterator#isDataAvailable() == false because the trailing string is still
      // incomplete, and yields the single-thread executor cleanly without blocking.
      grpcStream
          .consumer()
          .onPartialResultSet(
              PartialResultSet.newBuilder()
                  .setMetadata(stringColumnMetadata)
                  .addValues(Value.newBuilder().setStringValue("hello-"))
                  .setChunkedValue(true)
                  .setResumeToken(ByteString.copyFromUtf8("r1"))
                  .build());
      assertTrue(simpleProvider.getExecutor().submit(() -> true).get(5, TimeUnit.SECONDS));
      assertEquals(0, receivedValues.size());

      // Deliver chunk 2 completing the split string, followed by end-of-stream.
      grpcStream
          .consumer()
          .onPartialResultSet(
              PartialResultSet.newBuilder()
                  .addValues(Value.newBuilder().setStringValue("world"))
                  .setChunkedValue(false)
                  .setResumeToken(ByteString.copyFromUtf8("r2"))
                  .build());
      grpcStream.consumer().onCompleted();

      assertNull(future.get(5, TimeUnit.SECONDS));
      assertEquals(Collections.singletonList("hello-world"), receivedValues);
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testPrefetchChunksReplenishmentDoesNotStallWhenEarlyChunksArriveDuringInitiation()
      throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    final int prefetchChunks = 2;
    // Deliver chunk 1 (without resumeToken) during startStream() before InitiateStreamingRunnable
    // runs its initial isDataAvailable() check, so InitiateStreamingRunnable drains 1 chunk into
    // ResumableStreamIterator.buffer and replenishes gRPC flow control via request(1).
    GrpcStreamingTestHarness harness =
        new GrpcStreamingTestHarness(
            512,
            prefetchChunks,
            grpcStream ->
                grpcStream
                    .consumer()
                    .onPartialResultSet(
                        PartialResultSet.newBuilder()
                            .setMetadata(singleInt64MetadataChunk().getMetadata())
                            .addValues(Value.newBuilder().setStringValue("1"))
                            .build()));

    List<Long> receivedIds = Collections.synchronizedList(new ArrayList<>());
    try (GrpcResultSet grpcResultSet = harness.newGrpcResultSet();
        AsyncResultSetImpl resultSet = new AsyncResultSetImpl(simpleProvider, grpcResultSet, 4)) {
      ApiFuture<Void> future =
          resultSet.setCallback(callbackExecutor, drainLongIdsCallback(receivedIds));

      GrpcStreamIterator grpcStream = harness.awaitStreamingInitialized(simpleProvider);
      verify(harness.streamingCall, times(1)).request(prefetchChunks);
      verify(harness.streamingCall, times(1)).request(1);

      // Deliver prefetchChunks (2) more non-resume-token chunks: chunk 3 fills GrpcStreamIterator
      // (bufferIsFull == true), flipping produceRowsInitiated = true and waking ProduceRowsRunnable
      // to drain both chunks into ResumableStreamIterator.buffer and replenish request(1) twice.
      grpcStream
          .consumer()
          .onPartialResultSet(
              PartialResultSet.newBuilder()
                  .addValues(Value.newBuilder().setStringValue("2"))
                  .build());
      grpcStream
          .consumer()
          .onPartialResultSet(
              PartialResultSet.newBuilder()
                  .addValues(Value.newBuilder().setStringValue("3"))
                  .build());
      assertTrue(simpleProvider.getExecutor().submit(() -> true).get(5, TimeUnit.SECONDS));
      verify(harness.streamingCall, times(3)).request(1);

      // Deliver chunk 4 with a resume token + EOF and verify all 4 rows arrive in order.
      grpcStream
          .consumer()
          .onPartialResultSet(
              PartialResultSet.newBuilder()
                  .addValues(Value.newBuilder().setStringValue("4"))
                  .setResumeToken(ByteString.copyFromUtf8("r4"))
                  .build());
      grpcStream.consumer().onCompleted();

      assertNull(future.get(5, TimeUnit.SECONDS));
      assertEquals(Arrays.asList(1L, 2L, 3L, 4L), receivedIds);
    } finally {
      callbackExecutor.shutdownNow();
    }
  }
}
