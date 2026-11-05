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

import static com.google.cloud.spanner.AsyncResultSetImplTestUtil.sneakyThrow;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.ExecutorProvider;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.CursorState;
import com.google.cloud.spanner.AsyncResultSetImplTestUtil.ControllableStreamingDelegate;
import com.google.cloud.spanner.AsyncResultSetImplTestUtil.QueuedExecutorProvider;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Value;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for pause/resume races, cancellation concurrency, executor rejections, listener isolation,
 * and supplier exception caching in {@link AsyncResultSetImpl}.
 */
@RunWith(JUnit4.class)
public class AsyncResultSetImplLifecycleAndConcurrencyTest {
  private ExecutorProvider mockedProvider;
  private SpannerOptions.CloseableExecutorProvider simpleProvider;

  @Before
  public void setup() {
    mockedProvider = mock(ExecutorProvider.class, withSettings().withoutAnnotations());
    when(mockedProvider.getExecutor()).thenReturn(mock(ScheduledExecutorService.class));
    simpleProvider = SpannerOptions.createAsyncExecutorProvider(1, 1L, TimeUnit.SECONDS);
  }

  @After
  public void teardown() {
    if (simpleProvider != null) {
      simpleProvider.close();
    }
  }

  @Test(timeout = 10_000)
  public void testPollingResumeDuringConsumingDoesNotBypassCallbackPause() throws Exception {
    // Callers that coordinate externally (such as ReadAsyncTest#pauseResume and
    // AsyncResultSetImplTest#testCallbackIsNotCalledWhilePaused) poll resume() concurrently while
    // cursorReady() is still executing in State.CONSUMING. Returning CallbackResponse.PAUSE must
    // still transition the cursor to State.PAUSED rather than consuming a pre-pause resume() call.
    QueuedExecutorProvider queuedProvider = new QueuedExecutorProvider(false);
    ControllableStreamingDelegate stream = new ControllableStreamingDelegate(2);
    List<Long> receivedIds = new ArrayList<>();
    AtomicInteger callbackInvocations = new AtomicInteger();

    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(queuedProvider, stream.delegate, 10)) {
      ApiFuture<Void> future =
          resultSet.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                int call = callbackInvocations.incrementAndGet();
                if (call == 1) {
                  // Simulate an external coordinator polling resume() while cursorReady() is in
                  // State.CONSUMING before returning PAUSE.
                  cursor.resume();
                  assertEquals(CursorState.OK, cursor.tryNext());
                  receivedIds.add(cursor.getLong(0));
                  return CallbackResponse.PAUSE;
                }
                while (true) {
                  CursorState cursorState = cursor.tryNext();
                  if (cursorState == CursorState.OK) {
                    receivedIds.add(cursor.getLong(0));
                  } else if (cursorState == CursorState.NOT_READY) {
                    return CallbackResponse.CONTINUE;
                  } else {
                    return CallbackResponse.DONE;
                  }
                }
              });

      queuedProvider.runNext(); // InitiateStreamingRunnable
      stream.availableRows.set(2);
      stream.emitEndOfStream(false);
      queuedProvider.runNext(); // ProduceRowsRunnable -> buffers rows 1 & 2 + EOF

      assertEquals(Collections.singletonList(1L), receivedIds);
      assertEquals(AsyncResultSetImpl.State.PAUSED, resultSet.getState());
      assertFalse(future.isDone());

      resultSet.resume();
      assertTrue(future.isDone());
      assertNull(future.get(5, TimeUnit.SECONDS));
      assertEquals(Arrays.asList(1L, 2L), receivedIds);
    }
  }

  @Test(timeout = 10_000)
  public void testResumeImmediatelyUponEnteringPausedStateDoesNotLoseWakeup() throws Exception {
    final int totalRows = 80;
    final int maxBufferSize = 3;
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    ExecutorService resumerExecutor = Executors.newFixedThreadPool(2);
    ExecutorService streamFeederExecutor = Executors.newSingleThreadExecutor();
    ControllableStreamingDelegate stream = new ControllableStreamingDelegate(totalRows);
    List<Long> receivedIds = Collections.synchronizedList(new ArrayList<>());

    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(simpleProvider, stream.delegate, maxBufferSize)) {
      ApiFuture<Void> resultFuture =
          resultSet.setCallback(
              callbackExecutor,
              cursor -> {
                while (true) {
                  CursorState cursorState = cursor.tryNext();
                  if (cursorState == CursorState.OK) {
                    receivedIds.add(cursor.getLong(0));
                    resumerExecutor.execute(
                        () -> {
                          while (resultSet.getState() == AsyncResultSetImpl.State.CONSUMING) {
                            Thread.yield();
                          }
                          resultSet.resume();
                        });
                    return CallbackResponse.PAUSE;
                  } else if (cursorState == CursorState.NOT_READY) {
                    return CallbackResponse.CONTINUE;
                  } else {
                    return CallbackResponse.DONE;
                  }
                }
              });

      Future<?> feederFuture =
          streamFeederExecutor.submit(
              () -> {
                stream.awaitListener();
                for (int row = 1; row <= totalRows; row++) {
                  stream.availableRows.incrementAndGet();
                  stream.emitFlushableChunk("r" + row, row % 4 == 0);
                }
                stream.emitEndOfStream(false);
                return null;
              });

      feederFuture.get(5, TimeUnit.SECONDS);
      assertNull(resultFuture.get(5, TimeUnit.SECONDS));
      assertEquals(totalRows, receivedIds.size());
      for (int index = 0; index < totalRows; index++) {
        assertEquals(Long.valueOf(index + 1L), receivedIds.get(index));
      }
    } finally {
      streamFeederExecutor.shutdownNow();
      resumerExecutor.shutdownNow();
      callbackExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testConcurrentStreamingPauseResumeWithSeededRandom() throws Exception {
    final int totalRows = 150;
    final int maxBufferSize = 4;
    final Random random = new Random(42L);
    ExecutorService callbackPool = Executors.newFixedThreadPool(2);
    ExecutorService resumerExecutor = Executors.newSingleThreadExecutor();
    ExecutorService streamFeederExecutor = Executors.newSingleThreadExecutor();
    ControllableStreamingDelegate stream = new ControllableStreamingDelegate(totalRows);

    List<Long> receivedIds = Collections.synchronizedList(new ArrayList<>());
    AtomicBoolean currentlyPaused = new AtomicBoolean(false);

    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(simpleProvider, stream.delegate, maxBufferSize)) {
      Executor notifyingCallbackExecutor =
          command ->
              callbackPool.execute(
                  () -> {
                    try {
                      command.run();
                    } finally {
                      if (resultSet.getState() == AsyncResultSetImpl.State.PAUSED) {
                        resumerExecutor.execute(
                            () -> {
                              currentlyPaused.set(false);
                              resultSet.resume();
                            });
                      }
                    }
                  });

      ApiFuture<Void> resultFuture =
          resultSet.setCallback(
              notifyingCallbackExecutor,
              cursor -> {
                assertFalse(currentlyPaused.get());
                while (true) {
                  CursorState cursorState = cursor.tryNext();
                  if (cursorState == CursorState.OK) {
                    receivedIds.add(cursor.getLong(0));
                    if (random.nextInt(4) == 0) {
                      currentlyPaused.set(true);
                      return CallbackResponse.PAUSE;
                    }
                  } else if (cursorState == CursorState.NOT_READY) {
                    return CallbackResponse.CONTINUE;
                  } else {
                    return CallbackResponse.DONE;
                  }
                }
              });

      Future<?> feederFuture =
          streamFeederExecutor.submit(
              () -> {
                AsyncResultSet.StreamMessageListener listener = stream.awaitListener();
                for (int row = 1; row <= totalRows; row++) {
                  listener.onStreamMessage(
                      PartialResultSet.newBuilder()
                          .addValues(Value.newBuilder().setStringValue(String.valueOf(row)))
                          .build(),
                      false);
                  stream.availableRows.incrementAndGet();
                  stream.emitFlushableChunk("r" + row, row % 3 == 0);
                }
                stream.emitEndOfStream(false);
                return null;
              });

      feederFuture.get(5, TimeUnit.SECONDS);
      assertNull(resultFuture.get(5, TimeUnit.SECONDS));
      assertEquals(totalRows, receivedIds.size());
      for (int index = 0; index < totalRows; index++) {
        assertEquals(Long.valueOf(index + 1L), receivedIds.get(index));
      }
    } finally {
      streamFeederExecutor.shutdownNow();
      resumerExecutor.shutdownNow();
      callbackPool.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testCancelDuringCallbackReturningDoneDoesNotReinvokeCallback() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    CountDownLatch inDoneCallbackLatch = new CountDownLatch(1);
    CountDownLatch allowDoneReturnLatch = new CountDownLatch(1);
    AtomicInteger doneCallbackCount = new AtomicInteger();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, false);
    when(delegate.getCurrentRowAsStruct()).thenReturn(Struct.newBuilder().set("c").to(1L).build());

    try (AsyncResultSetImpl resultSet = new AsyncResultSetImpl(simpleProvider, delegate, 4)) {
      ApiFuture<Void> future =
          resultSet.setCallback(
              callbackExecutor,
              cursor -> {
                doneCallbackCount.incrementAndGet();
                assertEquals(CursorState.OK, cursor.tryNext());
                inDoneCallbackLatch.countDown();
                try {
                  assertTrue(allowDoneReturnLatch.await(5, TimeUnit.SECONDS));
                } catch (InterruptedException interruptedException) {
                  Thread.currentThread().interrupt();
                }
                return CallbackResponse.DONE;
              });
      assertTrue(inDoneCallbackLatch.await(5, TimeUnit.SECONDS));
      resultSet.cancel();
      assertThrows(IllegalStateException.class, resultSet::tryNext);
      allowDoneReturnLatch.countDown();
      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertEquals(
          ErrorCode.CANCELLED, ((SpannerException) executionException.getCause()).getErrorCode());
      assertEquals(1, doneCallbackCount.get());
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testCancelDuringCallbackReturningPauseOrContinueDeliversCancelledOnNextInvocation()
      throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    try {
      for (CallbackResponse firstResponse :
          new CallbackResponse[] {CallbackResponse.PAUSE, CallbackResponse.CONTINUE}) {
        CountDownLatch inFirstCallbackLatch = new CountDownLatch(1);
        CountDownLatch allowFirstReturnLatch = new CountDownLatch(1);
        AtomicInteger callbackCount = new AtomicInteger();
        AtomicBoolean observedCancelledInCallback = new AtomicBoolean(false);
        ResultSet delegate = mock(ResultSet.class);
        when(delegate.next()).thenReturn(true, true, false);
        when(delegate.getCurrentRowAsStruct())
            .thenReturn(Struct.newBuilder().set("c").to(1L).build());

        try (AsyncResultSetImpl resultSet = new AsyncResultSetImpl(simpleProvider, delegate, 4)) {
          ApiFuture<Void> future =
              resultSet.setCallback(
                  callbackExecutor,
                  cursor -> {
                    int call = callbackCount.incrementAndGet();
                    if (call == 1) {
                      assertEquals(CursorState.OK, cursor.tryNext());
                      inFirstCallbackLatch.countDown();
                      try {
                        assertTrue(allowFirstReturnLatch.await(5, TimeUnit.SECONDS));
                      } catch (InterruptedException interruptedException) {
                        Thread.currentThread().interrupt();
                      }
                      return firstResponse;
                    }
                    try {
                      cursor.tryNext();
                    } catch (SpannerException spannerException) {
                      if (spannerException.getErrorCode() == ErrorCode.CANCELLED) {
                        observedCancelledInCallback.set(true);
                      }
                    }
                    return CallbackResponse.CONTINUE;
                  });

          assertTrue(inFirstCallbackLatch.await(5, TimeUnit.SECONDS));
          resultSet.cancel();
          allowFirstReturnLatch.countDown();

          ExecutionException executionException =
              assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
          assertEquals(
              ErrorCode.CANCELLED,
              ((SpannerException) executionException.getCause()).getErrorCode());
          assertTrue(observedCancelledInCallback.get());
          assertEquals(2, callbackCount.get());
        }
      }
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testCancelBeforeCallbackReturningContinueWithoutTryNextStopsAfterOneInvocation() {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    AtomicInteger noTryNextCallbackCount = new AtomicInteger();
    StreamingResultSet streamingDelegate = mock(StreamingResultSet.class);
    when(streamingDelegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
        .thenReturn(true);

    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(simpleProvider, streamingDelegate, 4)) {
      ApiFuture<Void> future =
          resultSet.setCallback(
              callbackExecutor,
              cursor -> {
                noTryNextCallbackCount.incrementAndGet();
                return CallbackResponse.CONTINUE;
              });
      resultSet.cancel();
      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertEquals(
          ErrorCode.CANCELLED, ((SpannerException) executionException.getCause()).getErrorCode());
      assertEquals(1, noTryNextCallbackCount.get());
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testCancelBeforeInitiateStreamingRunsSkipsDelegateInitialization() throws Exception {
    CountDownLatch blockerStartedLatch = new CountDownLatch(1);
    CountDownLatch releaseBlockerLatch = new CountDownLatch(1);
    Future<?> blockerFuture =
        simpleProvider
            .getExecutor()
            .submit(
                () -> {
                  blockerStartedLatch.countDown();
                  try {
                    releaseBlockerLatch.await(5, TimeUnit.SECONDS);
                  } catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                  }
                });

    assertTrue(blockerStartedLatch.await(5, TimeUnit.SECONDS));
    AtomicInteger supplierCalls = new AtomicInteger();
    AtomicInteger onStartOrCloseCalls = new AtomicInteger();

    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(
            simpleProvider,
            () -> {
              supplierCalls.incrementAndGet();
              return mock(ResultSet.class);
            },
            4,
            onStartOrCloseCalls::incrementAndGet)) {
      ApiFuture<Void> future =
          resultSet.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                assertThrows(IllegalStateException.class, cursor::getColumnCount);
                SpannerException cancelled = assertThrows(SpannerException.class, cursor::tryNext);
                assertEquals(ErrorCode.CANCELLED, cancelled.getErrorCode());
                assertThrows(IllegalStateException.class, cursor::getColumnCount);
                return CallbackResponse.DONE;
              });
      resultSet.cancel();
      releaseBlockerLatch.countDown();
      blockerFuture.get(5, TimeUnit.SECONDS);

      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertEquals(
          ErrorCode.CANCELLED, ((SpannerException) executionException.getCause()).getErrorCode());
      assertEquals(0, supplierCalls.get());
      assertEquals(1, onStartOrCloseCalls.get());
    }
  }

  @Test(timeout = 10_000)
  public void testCancelDuringNonStreamingInitiateStreamingPreservesCancelledState() {
    QueuedExecutorProvider queuedProvider = new QueuedExecutorProvider(false);
    AtomicReference<AsyncResultSetImpl> nonStreamingCancelHolder = new AtomicReference<>();
    ResultSet nonStreamingCancelDelegate = mock(ResultSet.class);
    AsyncResultSetImpl nonStreamingCancelResultSet =
        new AsyncResultSetImpl(
            queuedProvider,
            () -> {
              nonStreamingCancelHolder.get().cancel();
              return nonStreamingCancelDelegate;
            },
            4);
    nonStreamingCancelHolder.set(nonStreamingCancelResultSet);
    try (AsyncResultSetImpl ignored = nonStreamingCancelResultSet) {
      ApiFuture<Void> future =
          nonStreamingCancelResultSet.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                cursor.tryNext();
                return CallbackResponse.DONE;
              });
      queuedProvider.runNext(); // InitiateStreamingRunnable
      assertTrue(queuedProvider.tasks.isEmpty());
      ExecutionException cancelledExec =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertEquals(
          ErrorCode.CANCELLED, ((SpannerException) cancelledExec.getCause()).getErrorCode());
      verify(nonStreamingCancelDelegate, never()).next();
    }
  }

  @Test(timeout = 10_000)
  public void testCancelRacingWithProducerWakeupExitsWithoutCallingNext() {
    QueuedExecutorProvider queuedProvider = new QueuedExecutorProvider(false);
    ControllableStreamingDelegate cancelRaceStream = new ControllableStreamingDelegate(1);
    AtomicReference<AsyncResultSetImpl> cancelRaceResultSetRef = new AtomicReference<>();
    AtomicInteger isDataAvailableCalls = new AtomicInteger();
    doAnswer(
            invocation -> {
              if (isDataAvailableCalls.incrementAndGet() == 2) {
                cancelRaceStream.emitEndOfStream(true);
                cancelRaceResultSetRef.get().cancel();
              }
              return false;
            })
        .when(cancelRaceStream.delegate)
        .isDataAvailable();
    try (AsyncResultSetImpl cancelRaceResultSet =
        new AsyncResultSetImpl(queuedProvider, cancelRaceStream.delegate, 4)) {
      cancelRaceResultSetRef.set(cancelRaceResultSet);
      ApiFuture<Void> future =
          cancelRaceResultSet.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                cursor.tryNext();
                return CallbackResponse.DONE;
              });
      queuedProvider.runNext(); // InitiateStreamingRunnable
      cancelRaceStream.emitFlushableChunk("wake", false);
      queuedProvider.runNext(); // ProduceRowsRunnable
      assertTrue(queuedProvider.tasks.isEmpty());
      ExecutionException cancelExec =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertEquals(ErrorCode.CANCELLED, ((SpannerException) cancelExec.getCause()).getErrorCode());
      verify(cancelRaceStream.delegate, never()).next();
    }
  }

  @Test(timeout = 10_000)
  public void testCallbackNullReturnAndUncaughtExceptionsOnCancel() {
    ResultSet oneRowDelegate = mock(ResultSet.class);
    when(oneRowDelegate.next()).thenReturn(true, false);
    when(oneRowDelegate.getCurrentRowAsStruct())
        .thenReturn(Struct.newBuilder().set("c").to(1L).build());
    try (AsyncResultSetImpl resultSet = new AsyncResultSetImpl(simpleProvider, oneRowDelegate, 4)) {
      ApiFuture<Void> future =
          resultSet.setCallback(MoreExecutors.directExecutor(), cursor -> null);
      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertEquals(
          ErrorCode.UNKNOWN, ((SpannerException) executionException.getCause()).getErrorCode());
    }

    StreamingResultSet cancelledStreamingDelegate = mock(StreamingResultSet.class);
    when(cancelledStreamingDelegate.initiateStreaming(
            any(AsyncResultSet.StreamMessageListener.class)))
        .thenReturn(true);
    try (AsyncResultSetImpl uncaughtCancelledResultSet =
            new AsyncResultSetImpl(simpleProvider, cancelledStreamingDelegate, 4);
        AsyncResultSetImpl customUserCancelledResultSet =
            new AsyncResultSetImpl(simpleProvider, cancelledStreamingDelegate, 4);
        AsyncResultSetImpl customExceptionResultSet =
            new AsyncResultSetImpl(simpleProvider, cancelledStreamingDelegate, 4);
        AsyncResultSetImpl nonCancelledSpannerExceptionResultSet =
            new AsyncResultSetImpl(simpleProvider, cancelledStreamingDelegate, 4)) {
      ApiFuture<Void> uncaughtCancelledFuture =
          uncaughtCancelledResultSet.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                cursor.tryNext();
                return CallbackResponse.DONE;
              });
      uncaughtCancelledResultSet.cancel();
      ExecutionException cancelledException =
          assertThrows(
              ExecutionException.class, () -> uncaughtCancelledFuture.get(5, TimeUnit.SECONDS));
      assertEquals(
          ErrorCode.CANCELLED, ((SpannerException) cancelledException.getCause()).getErrorCode());

      SpannerException userCustomCancelled =
          SpannerExceptionFactory.newSpannerException(
              ErrorCode.CANCELLED, "custom user cancel reason");
      ApiFuture<Void> userCancelledFuture =
          customUserCancelledResultSet.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                throw userCustomCancelled;
              });
      customUserCancelledResultSet.cancel();
      ExecutionException userCancelledExecutionException =
          assertThrows(
              ExecutionException.class, () -> userCancelledFuture.get(5, TimeUnit.SECONDS));
      assertSame(userCustomCancelled, userCancelledExecutionException.getCause());

      ApiFuture<Void> customFuture =
          customExceptionResultSet.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                throw new IllegalArgumentException("custom callback failure");
              });
      customExceptionResultSet.cancel();
      ExecutionException customException =
          assertThrows(ExecutionException.class, () -> customFuture.get(5, TimeUnit.SECONDS));
      assertEquals(
          ErrorCode.UNKNOWN, ((SpannerException) customException.getCause()).getErrorCode());
      assertTrue(customException.getCause().getMessage().contains("custom callback failure"));

      ApiFuture<Void> internalSpannerFuture =
          nonCancelledSpannerExceptionResultSet.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                throw SpannerExceptionFactory.newSpannerException(
                    ErrorCode.INTERNAL, "internal callback failure");
              });
      nonCancelledSpannerExceptionResultSet.cancel();
      ExecutionException internalException =
          assertThrows(
              ExecutionException.class, () -> internalSpannerFuture.get(5, TimeUnit.SECONDS));
      assertEquals(
          ErrorCode.INTERNAL, ((SpannerException) internalException.getCause()).getErrorCode());
    }
  }

  @Test(timeout = 10_000)
  public void testExecutorRejectionsAndListenerIsolation() {
    AtomicInteger serviceExecuteCalls = new AtomicInteger();
    ExecutorProvider rejectingProducerProvider =
        mock(ExecutorProvider.class, withSettings().withoutAnnotations());
    ScheduledExecutorService customService =
        mock(
            ScheduledExecutorService.class,
            invocation -> {
              if ("execute".equals(invocation.getMethod().getName())) {
                Runnable runnable = invocation.getArgument(0);
                if (serviceExecuteCalls.incrementAndGet() == 1) {
                  runnable.run();
                  return null;
                }
                throw new RejectedExecutionException("producer rejected on stream message");
              }
              return null;
            });
    when(rejectingProducerProvider.getExecutor()).thenReturn(customService);
    when(rejectingProducerProvider.shouldAutoClose()).thenReturn(true);

    StreamingResultSet streamingDelegate = mock(StreamingResultSet.class);
    when(streamingDelegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
        .thenReturn(true);
    AtomicInteger listenerCalls = new AtomicInteger();
    try (AsyncResultSetImpl producerRejectedResultSet =
        new AsyncResultSetImpl(rejectingProducerProvider, streamingDelegate, 4)) {
      producerRejectedResultSet.addListener(
          () -> {
            listenerCalls.incrementAndGet();
            throw new RuntimeException("listener failure 1");
          });
      producerRejectedResultSet.addListener(listenerCalls::incrementAndGet);
      ApiFuture<Void> future =
          producerRejectedResultSet.setCallback(
              MoreExecutors.directExecutor(), cursor -> CallbackResponse.DONE);
      producerRejectedResultSet.onStreamMessage(GrpcStreamIterator.END_OF_STREAM, false);
      ExecutionException rejectedException =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertTrue(rejectedException.getCause() instanceof SpannerException);
      assertEquals(2, listenerCalls.get());
      assertThrows(
          IllegalStateException.class, () -> producerRejectedResultSet.addListener(() -> {}));
    }

    Executor rejectingCallbackExecutor =
        command -> {
          throw new RejectedExecutionException("callback executor shut down");
        };
    ResultSet emptyDelegate = mock(ResultSet.class);
    when(emptyDelegate.next()).thenReturn(false);
    try (AsyncResultSetImpl callbackRejectedResultSet =
        new AsyncResultSetImpl(simpleProvider, emptyDelegate, 4)) {
      ApiFuture<Void> future =
          callbackRejectedResultSet.setCallback(
              rejectingCallbackExecutor, cursor -> CallbackResponse.DONE);
      ExecutionException callbackRejectedException =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertTrue(callbackRejectedException.getCause() instanceof SpannerException);
      verify(emptyDelegate).close();
    }

    ScheduledExecutorService nonAutoCloseRejectingService = mock(ScheduledExecutorService.class);
    doThrow(new RejectedExecutionException("rejected"))
        .when(nonAutoCloseRejectingService)
        .execute(any(Runnable.class));
    ExecutorProvider nonAutoCloseProvider =
        mock(ExecutorProvider.class, withSettings().withoutAnnotations());
    when(nonAutoCloseProvider.getExecutor()).thenReturn(nonAutoCloseRejectingService);
    when(nonAutoCloseProvider.shouldAutoClose()).thenReturn(false);
    try (AsyncResultSetImpl rejectedNonAutoClose =
        new AsyncResultSetImpl(nonAutoCloseProvider, mock(ResultSet.class), 4)) {
      assertThrows(
          RejectedExecutionException.class,
          () ->
              rejectedNonAutoClose.setCallback(
                  MoreExecutors.directExecutor(), cursor -> CallbackResponse.DONE));
    }
    verify(nonAutoCloseRejectingService, never()).shutdown();
  }

  @Test(timeout = 10_000)
  public void testListenerRemovalAndSwallowedDelegateCloseExceptions() throws Exception {
    AtomicInteger removedListenerCalls = new AtomicInteger();
    AtomicInteger keptListenerCalls = new AtomicInteger();
    Runnable removedListener = removedListenerCalls::incrementAndGet;
    Runnable keptListener = keptListenerCalls::incrementAndGet;
    ResultSet emptySyncDelegate = mock(ResultSet.class);
    when(emptySyncDelegate.next()).thenReturn(false);
    try (AsyncResultSetImpl listenerResultSet =
        new AsyncResultSetImpl(simpleProvider, emptySyncDelegate, 4)) {
      listenerResultSet.addListener(removedListener);
      listenerResultSet.addListener(keptListener);
      listenerResultSet.removeListener(removedListener);
      assertEquals(
          0,
          listenerResultSet
              .toListAsync(reader -> reader.getLong(0), MoreExecutors.directExecutor())
              .get(5, TimeUnit.SECONDS)
              .size());
      assertEquals(0, removedListenerCalls.get());
      assertEquals(1, keptListenerCalls.get());
    }

    ResultSet throwingLazyDelegate = mock(ResultSet.class);
    ResultSetMetadata expectedMetadata = ResultSetMetadata.getDefaultInstance();
    when(throwingLazyDelegate.getMetadata()).thenReturn(expectedMetadata);
    doThrow(new RuntimeException("lazy close failure")).when(throwingLazyDelegate).close();
    AsyncResultSetImpl closedBeforeInitResultSet =
        new AsyncResultSetImpl(mockedProvider, () -> throwingLazyDelegate, 4);
    closedBeforeInitResultSet.close();
    assertSame(expectedMetadata, closedBeforeInitResultSet.getMetadata());

    ResultSet throwingInitializedDelegate = mock(ResultSet.class);
    doThrow(new RuntimeException("eager close failure")).when(throwingInitializedDelegate).close();
    AsyncResultSetImpl initializedThrowingCloseResultSet =
        new AsyncResultSetImpl(mockedProvider, throwingInitializedDelegate, 4);
    initializedThrowingCloseResultSet.close();
    verify(throwingInitializedDelegate).close();
  }

  @Test(timeout = 10_000)
  public void testToListInterruptedAndCachedSupplierExceptions() {
    StreamingResultSet stalledDelegate = mock(StreamingResultSet.class);
    when(stalledDelegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
        .thenReturn(true);
    try (AsyncResultSetImpl stalledResultSet =
        new AsyncResultSetImpl(simpleProvider, stalledDelegate, 4)) {
      Thread.currentThread().interrupt();
      try {
        SpannerException interruptedSpannerException =
            assertThrows(
                SpannerException.class, () -> stalledResultSet.toList(reader -> reader.getLong(0)));
        assertEquals(ErrorCode.CANCELLED, interruptedSpannerException.getErrorCode());
        assertTrue(Thread.currentThread().isInterrupted());
      } finally {
        Thread.interrupted();
      }
    }

    ScheduledExecutorService autoCloseService = mock(ScheduledExecutorService.class);
    ExecutorProvider autoCloseProvider =
        mock(ExecutorProvider.class, withSettings().withoutAnnotations());
    when(autoCloseProvider.getExecutor()).thenReturn(autoCloseService);
    when(autoCloseProvider.shouldAutoClose()).thenReturn(true);
    AtomicInteger runtimeSupplierCalls = new AtomicInteger();
    try (AsyncResultSetImpl runtimeSupplierResultSet =
        new AsyncResultSetImpl(
            autoCloseProvider,
            () -> {
              runtimeSupplierCalls.incrementAndGet();
              throw new IllegalStateException("runtime supplier failure");
            },
            4)) {
      assertThrows(IllegalStateException.class, runtimeSupplierResultSet::getMetadata);
      assertThrows(IllegalStateException.class, runtimeSupplierResultSet::getStats);
      assertEquals(1, runtimeSupplierCalls.get());
    }
    verify(autoCloseService).shutdown();

    AtomicInteger errorSupplierCalls = new AtomicInteger();
    try (AsyncResultSetImpl errorSupplierResultSet =
        new AsyncResultSetImpl(
            simpleProvider,
            () -> {
              errorSupplierCalls.incrementAndGet();
              throw new AssertionError("fatal supplier error");
            },
            4)) {
      assertThrows(AssertionError.class, errorSupplierResultSet::getMetadata);
      assertThrows(AssertionError.class, errorSupplierResultSet::getStats);
      assertEquals(1, errorSupplierCalls.get());
    }

    AtomicInteger checkedSupplierCalls = new AtomicInteger();
    try (AsyncResultSetImpl checkedSupplierResultSet =
        new AsyncResultSetImpl(
            simpleProvider,
            () -> {
              checkedSupplierCalls.incrementAndGet();
              throw sneakyThrow(new IOException("checked supplier io failure"));
            },
            4)) {
      assertThrows(SpannerException.class, checkedSupplierResultSet::getMetadata);
      assertThrows(SpannerException.class, checkedSupplierResultSet::getStats);
      assertEquals(1, checkedSupplierCalls.get());
    }
  }

  @Test(timeout = 10_000)
  public void testSetCallbackWithCallerRunsServiceDoesNotHoldMonitorDuringInitiateStreaming()
      throws Exception {
    ScheduledExecutorService callerRunsService =
        mock(
            ScheduledExecutorService.class,
            invocation -> {
              if ("execute".equals(invocation.getMethod().getName())) {
                Runnable runnable = invocation.getArgument(0);
                runnable.run();
              }
              return null;
            });
    ExecutorProvider callerRunsProvider =
        mock(ExecutorProvider.class, withSettings().withoutAnnotations());
    when(callerRunsProvider.getExecutor()).thenReturn(callerRunsService);
    when(callerRunsProvider.shouldAutoClose()).thenReturn(false);

    ExecutorService externalObserverExecutor = Executors.newSingleThreadExecutor();
    AtomicReference<AsyncResultSetImpl> resultSetRef = new AtomicReference<>();
    StreamingResultSet streamingDelegate = mock(StreamingResultSet.class);
    when(streamingDelegate.isDataAvailable()).thenReturn(true);
    when(streamingDelegate.next()).thenReturn(false);
    when(streamingDelegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
        .thenAnswer(
            invocation -> {
              AsyncResultSet.StreamMessageListener listener = invocation.getArgument(0);
              Future<?> externalCall =
                  externalObserverExecutor.submit(
                      () -> {
                        assertEquals(
                            AsyncResultSetImpl.State.STREAMING_INITIALIZED,
                            resultSetRef.get().getState());
                        listener.onStreamMessage(GrpcStreamIterator.END_OF_STREAM, false);
                        return null;
                      });
              // If setCallback holds monitor across service.execute(...), externalCall deadlocks
              // trying to acquire monitor in getState()/onStreamMessage() and times out here.
              externalCall.get(1, TimeUnit.SECONDS);
              return true;
            });

    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(callerRunsProvider, streamingDelegate, 4)) {
      resultSetRef.set(resultSet);
      ApiFuture<Void> future =
          resultSet.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                assertEquals(CursorState.DONE, cursor.tryNext());
                return CallbackResponse.DONE;
              });
      assertNull(future.get(5, TimeUnit.SECONDS));
    } finally {
      externalObserverExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testSetCallbackConcurrentCancelBeforeRejectedExecutionRollsBackCleanly() {
    for (boolean alsoCloseBeforeReject : new boolean[] {false, true}) {
      AtomicReference<AsyncResultSetImpl> resultSetRef = new AtomicReference<>();
      ScheduledExecutorService cancelThenRejectService =
          mock(
              ScheduledExecutorService.class,
              invocation -> {
                if ("execute".equals(invocation.getMethod().getName())) {
                  // Simulate another thread calling cancel() (and optionally close()) right after
                  // setCallback transitions to STREAMING_INITIALIZED and releases monitor, before
                  // service.execute() throws RejectedExecutionException.
                  resultSetRef.get().cancel();
                  if (alsoCloseBeforeReject) {
                    resultSetRef.get().close();
                  }
                  throw new RejectedExecutionException("rejected after concurrent cancel");
                }
                return null;
              });
      ExecutorProvider provider = mock(ExecutorProvider.class, withSettings().withoutAnnotations());
      when(provider.getExecutor()).thenReturn(cancelThenRejectService);
      when(provider.shouldAutoClose()).thenReturn(true);

      AtomicInteger runningAsyncOperations = new AtomicInteger();
      AtomicInteger callbackCount = new AtomicInteger();
      ResultSet delegate = mock(ResultSet.class);
      try (AsyncResultSetImpl resultSet = new AsyncResultSetImpl(provider, delegate, 4)) {
        resultSetRef.set(resultSet);
        Runnable listener = runningAsyncOperations::decrementAndGet;
        assertThrows(
            RejectedExecutionException.class,
            () -> {
              // Mirror TransactionRunnerImpl.TransactionContextAsyncResultSetImpl.setCallback.
              runningAsyncOperations.incrementAndGet();
              resultSet.addListener(listener);
              try {
                resultSet.setCallback(
                    MoreExecutors.directExecutor(),
                    cursor -> {
                      callbackCount.incrementAndGet();
                      return CallbackResponse.DONE;
                    });
              } catch (Throwable throwable) {
                resultSet.removeListener(listener);
                runningAsyncOperations.decrementAndGet();
                throw throwable;
              }
            });
        assertEquals(0, runningAsyncOperations.get());
        assertEquals(0, callbackCount.get());
        assertEquals(AsyncResultSetImpl.State.INITIALIZED, resultSet.getState());
        verify(delegate).close();
        verify(cancelThenRejectService).shutdown();
      }
    }
  }

  @Test(timeout = 10_000)
  public void testCancelDuringInitiateStreamingDefersCallbackUntilInitiateStreamingCompletes()
      throws Exception {
    ExecutorService serviceExecutor = Executors.newSingleThreadExecutor();
    ScheduledExecutorService scheduledService =
        mock(
            ScheduledExecutorService.class,
            invocation -> {
              if ("execute".equals(invocation.getMethod().getName())) {
                serviceExecutor.execute(invocation.getArgument(0));
              }
              return null;
            });
    ExecutorProvider provider = mock(ExecutorProvider.class, withSettings().withoutAnnotations());
    when(provider.getExecutor()).thenReturn(scheduledService);
    when(provider.shouldAutoClose()).thenReturn(false);

    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    AtomicInteger activeDelegateCalls = new AtomicInteger();
    AtomicInteger maxConcurrentDelegateCalls = new AtomicInteger();
    CountDownLatch insideInitiateStreaming = new CountDownLatch(1);
    CountDownLatch allowInitiateStreamingToFinish = new CountDownLatch(1);
    Runnable enterDelegate =
        () -> {
          int concurrent = activeDelegateCalls.incrementAndGet();
          maxConcurrentDelegateCalls.accumulateAndGet(concurrent, Math::max);
        };

    StreamingResultSet streamingDelegate = mock(StreamingResultSet.class);
    when(streamingDelegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
        .thenAnswer(
            invocation -> {
              enterDelegate.run();
              try {
                insideInitiateStreaming.countDown();
                assertTrue(allowInitiateStreamingToFinish.await(5, TimeUnit.SECONDS));
                return true;
              } finally {
                activeDelegateCalls.decrementAndGet();
              }
            });
    when(streamingDelegate.getMetadata())
        .thenAnswer(
            invocation -> {
              enterDelegate.run();
              try {
                return ResultSetMetadata.getDefaultInstance();
              } finally {
                activeDelegateCalls.decrementAndGet();
              }
            });

    Runnable noopListener = () -> {};
    try (AsyncResultSetImpl resultSet = new AsyncResultSetImpl(provider, streamingDelegate, 4)) {
      resultSet.addListener(noopListener);
      ApiFuture<Void> future =
          resultSet.setCallback(
              callbackExecutor,
              cursor -> {
                cursor.getMetadata();
                assertThrows(SpannerException.class, cursor::tryNext);
                return CallbackResponse.DONE;
              });

      assertTrue(insideInitiateStreaming.await(5, TimeUnit.SECONDS));
      // removeListener must reject removal while active and not closed.
      assertThrows(IllegalStateException.class, () -> resultSet.removeListener(noopListener));

      // Cancel while InitiateStreamingRunnable is still inside initiateStreaming(); flush
      // callbackExecutor to prove ReadyCallback was NOT scheduled while initiatingStreaming=true.
      resultSet.cancel();
      callbackExecutor.submit(() -> null).get(5, TimeUnit.SECONDS);
      assertEquals(1, activeDelegateCalls.get());

      allowInitiateStreamingToFinish.countDown();
      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertEquals(
          ErrorCode.CANCELLED, ((SpannerException) executionException.getCause()).getErrorCode());
      assertEquals(1, maxConcurrentDelegateCalls.get());
    } finally {
      allowInitiateStreamingToFinish.countDown();
      callbackExecutor.shutdownNow();
      serviceExecutor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void testCancelledExceptionDoesNotLeakSuppressedExceptionsAcrossQueries()
      throws Exception {
    QueuedExecutorProvider queuedProvider = new QueuedExecutorProvider(false);
    ResultSet delegate1 = mock(ResultSet.class);
    try (AsyncResultSetImpl resultSet1 = new AsyncResultSetImpl(queuedProvider, delegate1, 4)) {
      ApiFuture<Void> future1 =
          resultSet1.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                try (AutoCloseable failingCloseable =
                    () -> {
                      throw new IOException("suppressed close failure");
                    }) {
                  cursor.tryNext();
                } catch (Exception exception) {
                  // Also invoke cancel() a second time before rethrowing to ensure repeated
                  // cancel() calls keep the same per-instance cancelledException identity.
                  resultSet1.cancel();
                  if (exception instanceof RuntimeException) {
                    throw (RuntimeException) exception;
                  }
                  throw new RuntimeException(exception);
                }
                return CallbackResponse.DONE;
              });
      resultSet1.cancel();
      queuedProvider.runNext();
      ExecutionException exec1 =
          assertThrows(ExecutionException.class, () -> future1.get(5, TimeUnit.SECONDS));
      SpannerException cancelled1 = (SpannerException) exec1.getCause();
      assertEquals(ErrorCode.CANCELLED, cancelled1.getErrorCode());
      assertEquals(1, cancelled1.getSuppressed().length);
    }

    ResultSet delegate2 = mock(ResultSet.class);
    try (AsyncResultSetImpl resultSet2 = new AsyncResultSetImpl(queuedProvider, delegate2, 4)) {
      AtomicReference<SpannerException> caughtInCallback = new AtomicReference<>();
      ApiFuture<Void> future2 =
          resultSet2.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                SpannerException thrown = assertThrows(SpannerException.class, cursor::tryNext);
                caughtInCallback.set(thrown);
                return CallbackResponse.DONE;
              });
      resultSet2.cancel();
      queuedProvider.runNext();
      ExecutionException exec2 =
          assertThrows(ExecutionException.class, () -> future2.get(5, TimeUnit.SECONDS));
      SpannerException cancelled2 = (SpannerException) exec2.getCause();
      assertEquals(ErrorCode.CANCELLED, cancelled2.getErrorCode());
      assertEquals(0, caughtInCallback.get().getSuppressed().length);
      assertEquals(0, cancelled2.getSuppressed().length);
    }
  }

  @Test(timeout = 10_000)
  public void testConcurrentLazySupplierFailureInvokesSupplierOnlyOnce() throws Exception {
    SpannerException transientFailure =
        SpannerExceptionFactory.newSpannerException(
            ErrorCode.UNAVAILABLE, "transient lazy supplier error");
    CountDownLatch firstThreadInSupplier = new CountDownLatch(1);
    CountDownLatch allowSupplierToThrow = new CountDownLatch(1);
    AtomicInteger supplierCalls = new AtomicInteger();
    ResultSet leakedSecondDelegate = mock(ResultSet.class);

    ExecutorService callerPool = Executors.newFixedThreadPool(2);
    AtomicReference<Thread> secondCallerThread = new AtomicReference<>();
    CountDownLatch secondCallerEntering = new CountDownLatch(1);

    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(
            simpleProvider,
            () -> {
              int call = supplierCalls.incrementAndGet();
              if (call == 1) {
                firstThreadInSupplier.countDown();
                try {
                  assertTrue(allowSupplierToThrow.await(5, TimeUnit.SECONDS));
                } catch (InterruptedException interruptedException) {
                  Thread.currentThread().interrupt();
                }
                throw transientFailure;
              }
              return leakedSecondDelegate;
            },
            4)) {
      Future<Throwable> firstCall =
          callerPool.submit(() -> assertThrows(SpannerException.class, resultSet::getMetadata));
      assertTrue(firstThreadInSupplier.await(5, TimeUnit.SECONDS));

      Future<Throwable> secondCall =
          callerPool.submit(
              () -> {
                secondCallerThread.set(Thread.currentThread());
                secondCallerEntering.countDown();
                return assertThrows(SpannerException.class, resultSet::getStats);
              });
      assertTrue(secondCallerEntering.await(5, TimeUnit.SECONDS));
      while (secondCallerThread.get().getState() != Thread.State.BLOCKED && !secondCall.isDone()) {
        Thread.yield();
      }
      allowSupplierToThrow.countDown();

      assertSame(transientFailure, firstCall.get(5, TimeUnit.SECONDS));
      assertSame(transientFailure, secondCall.get(5, TimeUnit.SECONDS));
      assertEquals(1, supplierCalls.get());
    } finally {
      allowSupplierToThrow.countDown();
      callerPool.shutdownNow();
    }
  }
}
