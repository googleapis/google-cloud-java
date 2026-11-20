/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.spanner.SpannerApiFutures.get;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.ExecutorProvider;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.CursorState;
import com.google.cloud.spanner.AsyncResultSet.ReadyCallback;
import com.google.cloud.spanner.AsyncResultSetImplTestUtil.ControllableStreamingDelegate;
import com.google.cloud.spanner.AsyncResultSetImplTestUtil.QueuedExecutorProvider;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.Range;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import com.google.protobuf.Value;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@RunWith(JUnit4.class)
public class AsyncResultSetImplTest {
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

  @SuppressWarnings("unchecked")
  @Test
  public void close() {
    AsyncResultSetImpl rs =
        new AsyncResultSetImpl(
            mockedProvider, mock(ResultSet.class), AsyncResultSetImpl.DEFAULT_BUFFER_SIZE);
    rs.close();
    // Closing a second time should be a no-op.
    rs.close();

    // The following methods are not allowed to call after closing the result set.
    assertThrows(
        IllegalStateException.class,
        () -> rs.setCallback(mock(Executor.class), mock(ReadyCallback.class)));
    assertThrows(IllegalStateException.class, () -> rs.toList(mock(Function.class)));
    assertThrows(
        IllegalStateException.class,
        () -> rs.toListAsync(mock(Function.class), mock(Executor.class)));

    // The following methods are allowed on a closed result set.
    AsyncResultSetImpl rs2 =
        new AsyncResultSetImpl(
            mockedProvider, mock(ResultSet.class), AsyncResultSetImpl.DEFAULT_BUFFER_SIZE);
    rs2.setCallback(mock(Executor.class), mock(ReadyCallback.class));
    rs2.close();
    rs2.cancel();
    rs2.resume();
  }

  @Test
  public void tryNextNotAllowed() {
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(
            mockedProvider, mock(ResultSet.class), AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      rs.setCallback(mock(Executor.class), mock(ReadyCallback.class));
      IllegalStateException e = assertThrows(IllegalStateException.class, rs::tryNext);
      assertThat(e.getMessage()).contains("tryNext may only be called from a DataReady callback.");
    }
  }

  @Test
  public void toList() {
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, true, true, false);
    when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      List<Object> list = rs.toList(ignored -> new Object());
      assertThat(list).hasSize(3);
    }
  }

  @Test
  public void toListPropagatesError() {
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next())
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT, "invalid query"));
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      SpannerException e =
          assertThrows(SpannerException.class, () -> rs.toList(ignored -> new Object()));
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
      assertThat(e.getMessage()).contains("invalid query");
    }
  }

  @Test
  public void toListAsync() throws InterruptedException, ExecutionException {
    ExecutorService executor = Executors.newFixedThreadPool(1);
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, true, true, false);
    when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<List<Object>> future = rs.toListAsync(ignored -> new Object(), executor);
      assertThat(future.get()).hasSize(3);
    }
    executor.shutdown();
  }

  @Test
  public void toListAsyncPropagatesError() {
    ExecutorService executor = Executors.newFixedThreadPool(1);
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next())
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT, "invalid query"));
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ExecutionException e =
          assertThrows(
              ExecutionException.class,
              () -> rs.toListAsync(ignored -> new Object(), executor).get());
      assertThat(e.getCause()).isInstanceOf(SpannerException.class);
      SpannerException se = (SpannerException) e.getCause();
      assertThat(se.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
      assertThat(se.getMessage()).contains("invalid query");
    }
    executor.shutdown();
  }

  @Test
  public void withCallback() throws InterruptedException {
    Executor executor = Executors.newSingleThreadExecutor();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, true, true, false);
    when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));
    final AtomicInteger callbackCounter = new AtomicInteger();
    final AtomicInteger rowCounter = new AtomicInteger();
    final CountDownLatch finishedLatch = new CountDownLatch(1);
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      rs.setCallback(
          executor,
          resultSet -> {
            callbackCounter.incrementAndGet();
            CursorState state;
            while ((state = resultSet.tryNext()) == CursorState.OK) {
              rowCounter.incrementAndGet();
            }
            if (state == CursorState.DONE) {
              finishedLatch.countDown();
            }
            return CallbackResponse.CONTINUE;
          });
    }
    finishedLatch.await();
    // There should be between 1 and 5 callbacks, depending on the timing of the threads.
    // Normally, there should be just 1 callback.
    assertThat(callbackCounter.get()).isIn(Range.closed(1, 5));
    assertThat(rowCounter.get()).isEqualTo(3);
  }

  @Test
  public void callbackReceivesError() throws InterruptedException {
    Executor executor = Executors.newSingleThreadExecutor();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next())
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT, "invalid query"));
    final BlockingDeque<Exception> receivedErr = new LinkedBlockingDeque<>(1);
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      rs.setCallback(
          executor,
          resultSet -> {
            try {
              resultSet.tryNext();
              receivedErr.push(new Exception("missing expected exception"));
            } catch (SpannerException e) {
              receivedErr.push(e);
            }
            return CallbackResponse.DONE;
          });
    }
    Exception e = receivedErr.take();
    assertThat(e).isInstanceOf(SpannerException.class);
    SpannerException se = (SpannerException) e;
    assertThat(se.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
    assertThat(se.getMessage()).contains("invalid query");
  }

  @Test
  public void callbackReceivesErrorHalfwayThrough() throws InterruptedException {
    Executor executor = Executors.newSingleThreadExecutor();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next())
        .thenReturn(true)
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT, "invalid query"));
    when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));
    final AtomicInteger rowCount = new AtomicInteger();
    final BlockingDeque<Exception> receivedErr = new LinkedBlockingDeque<>(1);
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      rs.setCallback(
          executor,
          resultSet -> {
            try {
              if (resultSet.tryNext() != CursorState.DONE) {
                rowCount.incrementAndGet();
                return CallbackResponse.CONTINUE;
              }
            } catch (SpannerException e) {
              receivedErr.push(e);
            }
            return CallbackResponse.DONE;
          });
    }
    Exception e = receivedErr.take();
    assertThat(e).isInstanceOf(SpannerException.class);
    SpannerException se = (SpannerException) e;
    assertThat(se.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
    assertThat(se.getMessage()).contains("invalid query");
    assertThat(rowCount.get()).isEqualTo(1);
  }

  @Test
  public void pauseResume() throws InterruptedException {
    Executor executor = Executors.newSingleThreadExecutor();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, true, true, false);
    when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));
    final AtomicInteger callbackCounter = new AtomicInteger();
    final BlockingDeque<Object> queue = new LinkedBlockingDeque<>(1);
    final AtomicBoolean finished = new AtomicBoolean(false);
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      rs.setCallback(
          executor,
          resultSet -> {
            callbackCounter.incrementAndGet();
            CursorState state = resultSet.tryNext();
            if (state == CursorState.OK) {
              try {
                queue.put(new Object());
              } catch (InterruptedException e) {
                // Finish early if an error occurs.
                return CallbackResponse.DONE;
              }
              return CallbackResponse.PAUSE;
            }
            finished.set(true);
            return CallbackResponse.DONE;
          });
      int rowCounter = 0;
      while (!finished.get()) {
        Object o = queue.poll(1L, TimeUnit.MILLISECONDS);
        if (o != null) {
          rowCounter++;
        }
        rs.resume();
      }
      // There should be exactly 4 callbacks as we only consume one row per callback.
      assertThat(callbackCounter.get()).isEqualTo(4);
      assertThat(rowCounter).isEqualTo(3);
    }
  }

  @Test
  public void testCallbackIsNotCalledWhilePaused() throws InterruptedException, ExecutionException {
    Executor executor = Executors.newSingleThreadExecutor();
    final int simulatedRows = 100;
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next())
        .thenAnswer(
            new Answer<Boolean>() {
              int row = 0;

              @Override
              public Boolean answer(InvocationOnMock invocation) throws Throwable {
                row++;
                return row <= simulatedRows;
              }
            });
    when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));
    final AtomicInteger callbackCounter = new AtomicInteger();
    final BlockingDeque<Object> queue = new LinkedBlockingDeque<>(1);
    final AtomicBoolean paused = new AtomicBoolean();
    // Clearing the paused flag and calling resume() must be atomic with respect to the callback
    // setting the paused flag. Otherwise, the test thread could clear the flag before the callback
    // sets it, and then call resume() after the callback returned PAUSE. The next callback would
    // then see a stale paused flag, even though resume() was correctly called.
    final Object pauseLock = new Object();
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> callbackResult =
          rs.setCallback(
              executor,
              resultSet -> {
                assertFalse(paused.get());
                callbackCounter.incrementAndGet();
                try {
                  switch (resultSet.tryNext()) {
                    case OK:
                      synchronized (pauseLock) {
                        paused.set(true);
                      }
                      queue.put(new Object());
                      return CallbackResponse.PAUSE;
                    case DONE:
                      return CallbackResponse.DONE;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                    default:
                      throw new IllegalStateException();
                  }
                } catch (InterruptedException e) {
                  throw SpannerExceptionFactory.propagateInterrupt(e);
                }
              });
      int rowCounter = 0;
      while (!callbackResult.isDone()) {
        Object o = queue.poll(1L, TimeUnit.MILLISECONDS);
        if (o != null) {
          rowCounter++;
        }
        Thread.yield();
        synchronized (pauseLock) {
          paused.set(false);
          rs.resume();
        }
      }
      // Empty the queue to ensure we count all elements.
      while (queue.poll() != null) {
        rowCounter++;
      }
      // Assert that we can get the result from the callback future without any exceptions. That
      // indicates that the callback function never failed with an unexpected exception.
      assertNull(callbackResult.get());
      assertThat(callbackCounter.get()).isEqualTo(simulatedRows + 1);
      assertThat(rowCounter).isEqualTo(simulatedRows);
    }
  }

  @Test(timeout = 10_000)
  public void testCallbackIsNotCalledWhilePausedAndCanceled() throws Exception {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    StreamingResultSet delegate = mock(StreamingResultSet.class);

    final AtomicInteger callbackCounter = new AtomicInteger();
    final CountDownLatch pausedLatch = new CountDownLatch(1);
    ApiFuture<Void> callbackResult;

    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {

      when(delegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
          .thenAnswer(
              answer -> {
                resultSet.onStreamMessage(
                    PartialResultSet.newBuilder()
                        .setResumeToken(ByteString.copyFromUtf8("r1"))
                        .build(),
                    false);
                return Boolean.TRUE;
              });
      when(delegate.isDataAvailable()).thenReturn(true);
      callbackResult =
          resultSet.setCallback(
              executor,
              cursor -> {
                callbackCounter.getAndIncrement();
                pausedLatch.countDown();
                return CallbackResponse.PAUSE;
              });

      assertTrue(pausedLatch.await(5, TimeUnit.SECONDS));
      resultSet.cancel();

      SpannerException exception = assertThrows(SpannerException.class, () -> get(callbackResult));
      assertEquals(ErrorCode.CANCELLED, exception.getErrorCode());
      // 1 callback before cancel() returning PAUSE + 1 post-cancel callback given a chance to
      // catch CANCELLED and stopping cleanly when it returns PAUSE without calling tryNext().
      assertEquals(2, callbackCounter.get());
    } finally {
      executor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void cancel() throws InterruptedException {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, true, true, false);
    when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));
    final AtomicInteger callbackCounter = new AtomicInteger();
    final BlockingDeque<Object> queue = new LinkedBlockingDeque<>(1);
    final AtomicBoolean finished = new AtomicBoolean(false);
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      rs.setCallback(
          executor,
          resultSet -> {
            callbackCounter.incrementAndGet();
            try {
              CursorState state = resultSet.tryNext();
              if (state == CursorState.OK) {
                try {
                  queue.put(new Object());
                } catch (InterruptedException e) {
                  // Finish early if an error occurs.
                  return CallbackResponse.DONE;
                }
              }
              // Pause after 2 rows to make sure that no more data is consumed until the cancel
              // call has been received.
              return callbackCounter.get() == 2
                  ? CallbackResponse.PAUSE
                  : CallbackResponse.CONTINUE;
            } catch (SpannerException e) {
              if (e.getErrorCode() == ErrorCode.CANCELLED) {
                finished.set(true);
              }
            }
            return CallbackResponse.DONE;
          });
      int rowCounter = 0;
      while (!finished.get()) {
        Object o = queue.poll(1L, TimeUnit.MILLISECONDS);
        if (o != null) {
          rowCounter++;
        }
        if (rowCounter == 2) {
          // Cancel the result set and then resume it to get the cancelled error.
          rs.cancel();
          rs.resume();
        }
      }
      assertThat(callbackCounter.get()).isIn(Range.closed(2, 4));
      assertThat(rowCounter).isIn(Range.closed(2, 3));
    } finally {
      executor.shutdownNow();
    }
  }

  @Test(timeout = 10_000)
  public void callbackReturnsError() throws InterruptedException {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, true, true, false);
    when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));
    final AtomicInteger callbackCounter = new AtomicInteger();
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      rs.setCallback(
          executor,
          resultSet -> {
            callbackCounter.incrementAndGet();
            throw new RuntimeException("async test");
          });
      ExecutionException e = assertThrows(ExecutionException.class, () -> rs.getResult().get());
      assertThat(e.getCause()).isInstanceOf(SpannerException.class);
      SpannerException se = (SpannerException) e.getCause();
      assertThat(se.getErrorCode()).isEqualTo(ErrorCode.UNKNOWN);
      assertThat(se.getMessage()).contains("async test");
      assertThat(callbackCounter.get()).isEqualTo(1);
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  public void callbackReturnsErrorWhileBufferIsFull_shouldStopProducer() throws Exception {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    // Return more rows than fit in the buffer, so the producer will wait for the buffer to be
    // consumed by the callback. The callback fails instead of consuming any rows.
    final int simulatedRows = AsyncResultSetImpl.DEFAULT_BUFFER_SIZE * 10;
    final AtomicInteger producedRows = new AtomicInteger();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenAnswer(ignored -> producedRows.incrementAndGet() <= simulatedRows);
    when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> result =
          rs.setCallback(
              executor,
              ignored -> {
                throw new RuntimeException("async test");
              });
      // The result must complete with the error from the callback. Before the fix, the producer
      // would keep waiting for the (full) buffer to be consumed, and the result never completed.
      ExecutionException e =
          assertThrows(ExecutionException.class, () -> result.get(30L, TimeUnit.SECONDS));
      assertThat(e.getCause()).isInstanceOf(SpannerException.class);
      SpannerException se = (SpannerException) e.getCause();
      assertThat(se.getErrorCode()).isEqualTo(ErrorCode.UNKNOWN);
      assertThat(se.getMessage()).contains("async test");
      // The producer should stop and release the underlying result set.
      verify(delegate).close();
      assertThat(producedRows.get()).isLessThan(simulatedRows);
    } finally {
      executor.shutdown();
    }
  }

  @Test
  public void callbackReturnsDoneBeforeEnd_shouldStopIteration() throws Exception {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
      ResultSet delegate = mock(ResultSet.class);
      when(delegate.next()).thenReturn(true, true, true, false);
      when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));
      try (AsyncResultSetImpl resultSet =
          new AsyncResultSetImpl(
              simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
        resultSet.setCallback(
            executor,
            // Not calling resultSet.tryNext() means that it will also never return DONE.
            // Instead the callback indicates that it does not want any more rows.
            ignored -> CallbackResponse.DONE);
        resultSet.getResult().get(10L, TimeUnit.SECONDS);
      }
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  public void testOnStreamMessageWhenResumeTokenIsPresent() {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    StreamingResultSet delegate = mock(StreamingResultSet.class);
    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(mockedProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      // Marking Streaming as supported
      when(delegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
          .thenReturn(true);

      resultSet.setCallback(callbackExecutor, ignored -> CallbackResponse.DONE);
      ArgumentCaptor<Runnable> runnableCaptor = ArgumentCaptor.forClass(Runnable.class);
      verify(mockedProvider.getExecutor(), times(1)).execute(runnableCaptor.capture());
      runnableCaptor.getValue().run();
      verify(mockedProvider.getExecutor(), times(1)).execute(any());

      resultSet.onStreamMessage(
          PartialResultSet.newBuilder().addValues(Value.newBuilder().build()).build(), false);
      verify(mockedProvider.getExecutor(), times(1)).execute(any());

      resultSet.onStreamMessage(
          PartialResultSet.newBuilder().setResumeToken(ByteString.copyFromUtf8("test")).build(),
          false);
      verify(mockedProvider.getExecutor(), times(2)).execute(any());
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test
  public void testOnStreamMessageWhenCurrentBufferSizeReachedPrefetchChunkSize() {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    StreamingResultSet delegate = mock(StreamingResultSet.class);
    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(mockedProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      // Marking Streaming as supported
      when(delegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
          .thenReturn(true);

      resultSet.setCallback(callbackExecutor, ignored -> CallbackResponse.DONE);
      ArgumentCaptor<Runnable> runnableCaptor = ArgumentCaptor.forClass(Runnable.class);
      verify(mockedProvider.getExecutor(), times(1)).execute(runnableCaptor.capture());
      runnableCaptor.getValue().run();

      resultSet.onStreamMessage(
          PartialResultSet.newBuilder().addValues(Value.newBuilder().build()).build(), true);
      verify(mockedProvider.getExecutor(), times(2)).execute(any());
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test
  public void testOnStreamMessageWhenAsyncResultIsCancelled() {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    StreamingResultSet delegate = mock(StreamingResultSet.class);
    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(mockedProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      // Marking Streaming as supported
      when(delegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
          .thenReturn(true);

      resultSet.setCallback(callbackExecutor, ignored -> CallbackResponse.DONE);
      resultSet.cancel();
      resultSet.onStreamMessage(
          PartialResultSet.newBuilder().addValues(Value.newBuilder().build()).build(), false);
      // Once cancelled, cancel() schedules the callback directly and incoming stream messages must
      // not dispatch a wasted ProduceRowsRunnable onto the producer executor.
      verify(mockedProvider.getExecutor(), times(1)).execute(any());
    } finally {
      callbackExecutor.shutdownNow();
    }
  }

  @Test
  public void testGetStatsAndGetMetadata() {
    ResultSet delegate = mock(ResultSet.class);
    ResultSetStats expectedStats = ResultSetStats.getDefaultInstance();
    ResultSetMetadata expectedMetadata = ResultSetMetadata.getDefaultInstance();
    when(delegate.getStats()).thenReturn(expectedStats);
    when(delegate.getMetadata()).thenReturn(expectedMetadata);

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      assertEquals(expectedStats, asyncResultSet.getStats());
      assertEquals(expectedMetadata, asyncResultSet.getMetadata());
    }
  }

  @Test
  public void testGetStatsAndGetMetadataAfterClose() {
    ResultSet delegate = mock(ResultSet.class);
    ResultSetStats expectedStats = ResultSetStats.getDefaultInstance();
    ResultSetMetadata expectedMetadata = ResultSetMetadata.getDefaultInstance();
    when(delegate.getStats()).thenReturn(expectedStats);
    when(delegate.getMetadata()).thenReturn(expectedMetadata);

    AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE);
    asyncResultSet.close();
    assertEquals(expectedStats, asyncResultSet.getStats());
    assertEquals(expectedMetadata, asyncResultSet.getMetadata());
  }

  @Test
  public void testGetStatsAndGetMetadataAfterCloseWithoutPriorExecutionClosesDelegate() {
    ResultSet delegate = mock(ResultSet.class);
    ResultSetStats expectedStats = ResultSetStats.getDefaultInstance();
    ResultSetMetadata expectedMetadata = ResultSetMetadata.getDefaultInstance();
    when(delegate.getStats()).thenReturn(expectedStats);
    when(delegate.getMetadata()).thenReturn(expectedMetadata);

    AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(
            simpleProvider, () -> delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE);
    asyncResultSet.close();
    verify(delegate, never()).close();

    assertEquals(expectedStats, asyncResultSet.getStats());
    verify(delegate, times(1)).close();

    assertEquals(expectedMetadata, asyncResultSet.getMetadata());
    // Closing once is sufficient
    verify(delegate, times(1)).close();
  }

  @Test
  public void testOnStartOrCloseCalledOnNext() {
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, false);
    AtomicInteger count = new AtomicInteger();
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, () -> delegate, 10, count::incrementAndGet)) {
      assertEquals(0, count.get());
      assertTrue(asyncResultSet.next());
      assertEquals(1, count.get());
      assertFalse(asyncResultSet.next());
      assertEquals(1, count.get());
    }
    assertEquals(1, count.get());
  }

  @Test
  public void testOnStartOrCloseCalledOnCloseBeforeStartWithoutInitializingDelegate() {
    @SuppressWarnings("unchecked")
    Supplier<ResultSet> delegateSupplier = mock(Supplier.class);
    AtomicInteger count = new AtomicInteger();
    AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegateSupplier, 10, count::incrementAndGet);
    assertEquals(0, count.get());
    asyncResultSet.close();
    assertEquals(1, count.get());
    verify(delegateSupplier, never()).get();

    // Calling close a second time is idempotent.
    asyncResultSet.close();
    assertEquals(1, count.get());
  }

  @Test
  public void testGetStatsOrMetadataOnUnstartedResultSetNotifiesStartOrClose() {
    ResultSet delegate = mock(ResultSet.class);
    ResultSetMetadata expectedMetadata = ResultSetMetadata.getDefaultInstance();
    when(delegate.getMetadata()).thenReturn(expectedMetadata);
    AtomicInteger count = new AtomicInteger();

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, () -> delegate, 10, count::incrementAndGet)) {
      assertEquals(0, count.get());
      assertEquals(expectedMetadata, asyncResultSet.getMetadata());
      assertEquals(1, count.get());
    }
    assertEquals(1, count.get());
  }

  @Test
  public void testConstructorWithoutOnStartOrCloseCallback() {
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, false);
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, () -> delegate, 10)) {
      assertTrue(asyncResultSet.next());
      assertFalse(asyncResultSet.next());
    }
  }

  @Test
  public void testOnStartOrCloseCalledWhenDelegateSupplierFailsOnGetMetadata() {
    AtomicInteger count = new AtomicInteger();
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(
            simpleProvider,
            () -> {
              throw new RuntimeException("delegate creation failed");
            },
            10,
            count::incrementAndGet)) {
      assertEquals(0, count.get());
      assertThrows(RuntimeException.class, asyncResultSet::getMetadata);
      assertEquals(1, count.get());
    }
  }

  @Test
  public void testOnStartOrCloseCalledOnSetCallback() throws Exception {
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(false);
    AtomicInteger count = new AtomicInteger();
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, () -> delegate, 10, count::incrementAndGet)) {
      assertEquals(0, count.get());
      ApiFuture<Void> future =
          asyncResultSet.setCallback(
              MoreExecutors.directExecutor(), ignored -> CallbackResponse.DONE);
      future.get(10, TimeUnit.SECONDS);
      assertEquals(1, count.get());
    }
  }

  @Test
  public void testOnStartOrCloseCalledOnInitiateStreamingFailure() {
    AtomicInteger count = new AtomicInteger();
    AtomicInteger supplierInvocations = new AtomicInteger();
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(
            simpleProvider,
            () -> {
              supplierInvocations.incrementAndGet();
              throw new RuntimeException("stream start failure");
            },
            10,
            count::incrementAndGet)) {
      assertEquals(0, count.get());
      ApiFuture<Void> future =
          asyncResultSet.setCallback(
              MoreExecutors.directExecutor(), ignored -> CallbackResponse.DONE);
      assertThrows(ExecutionException.class, () -> future.get(10, TimeUnit.SECONDS));
      assertEquals(1, count.get());
      assertEquals(1, supplierInvocations.get());
    }
  }

  @Test
  public void testNextAfterCloseThrowsIllegalStateException() {
    ResultSet delegate = mock(ResultSet.class);
    AsyncResultSetImpl asyncResultSet = new AsyncResultSetImpl(simpleProvider, () -> delegate, 10);
    asyncResultSet.close();
    IllegalStateException exception =
        assertThrows(IllegalStateException.class, asyncResultSet::next);
    assertEquals("This AsyncResultSet has been closed", exception.getMessage());
  }

  @Test
  public void testCloseAfterSetCallbackDoesNotNotifyBeforeDelegateStarts() throws Exception {
    CountDownLatch startSupplierLatch = new CountDownLatch(1);
    CountDownLatch inSupplierLatch = new CountDownLatch(1);
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(false);
    AtomicInteger count = new AtomicInteger();
    Supplier<ResultSet> supplier =
        () -> {
          inSupplierLatch.countDown();
          try {
            startSupplierLatch.await();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          return delegate;
        };

    AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, supplier, 10, count::incrementAndGet);
    ApiFuture<Void> future =
        asyncResultSet.setCallback(
            MoreExecutors.directExecutor(), ignored -> CallbackResponse.DONE);

    assertTrue(inSupplierLatch.await(5, TimeUnit.SECONDS));
    // At this point, the delegate supplier is executing, but has not completed.
    // Closing the AsyncResultSet while streaming is starting should not immediately trigger
    // onStartOrClose because streaming has already been initiated.
    asyncResultSet.close();
    assertEquals(0, count.get());

    // Allow the supplier to complete.
    startSupplierLatch.countDown();
    future.get(10, TimeUnit.SECONDS);

    // Now count should be 1.
    assertEquals(1, count.get());
  }

  @Test
  public void testCloseImmediatelyAfterSetCallback() throws Exception {
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(false);
    AtomicInteger count = new AtomicInteger();
    AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, () -> delegate, 10, count::incrementAndGet);
    ApiFuture<Void> future =
        asyncResultSet.setCallback(
            MoreExecutors.directExecutor(), ignored -> CallbackResponse.DONE);
    asyncResultSet.close();
    future.get(10, TimeUnit.SECONDS);
    assertEquals(1, count.get());
    verify(delegate).close();
  }

  @Test
  public void testOnStartOrCloseExceptionDoesNotMaskPrimaryException() {
    Supplier<ResultSet> delegateSupplier =
        () -> {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.NOT_FOUND, "database not found");
        };
    Runnable throwingCallback =
        () -> {
          throw new RuntimeException("boom in onStartOrClose");
        };

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegateSupplier, 10, throwingCallback)) {
      SpannerException exception = assertThrows(SpannerException.class, asyncResultSet::next);
      assertEquals(ErrorCode.NOT_FOUND, exception.getErrorCode());
      assertTrue(exception.getMessage().contains("database not found"));
    }
  }

  @Test
  public void testSetCallbackRejectsNullArguments() {
    ResultSet delegate = mock(ResultSet.class);
    AtomicInteger count = new AtomicInteger();
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, () -> delegate, 10, count::incrementAndGet)) {
      assertThrows(
          NullPointerException.class,
          () -> asyncResultSet.setCallback(null, ignored -> CallbackResponse.DONE));
      assertThrows(
          NullPointerException.class,
          () -> asyncResultSet.setCallback(MoreExecutors.directExecutor(), null));

      // Because arguments were null, setCallback failed before mutating state.
      // The result set should still be closeable cleanly, notifying start or close once.
      assertEquals(0, count.get());
    }
    assertEquals(1, count.get());
  }

  @Test
  public void testSetCallbackRejectedExecutionNotifiesStartOrClose() {
    ScheduledExecutorService mockService = mock(ScheduledExecutorService.class);
    doThrow(new RejectedExecutionException()).when(mockService).execute(any(Runnable.class));
    ExecutorProvider provider = mock(ExecutorProvider.class, withSettings().withoutAnnotations());
    when(provider.getExecutor()).thenReturn(mockService);
    when(provider.shouldAutoClose()).thenReturn(true);

    AtomicInteger count = new AtomicInteger();
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(provider, () -> mock(ResultSet.class), 10, count::incrementAndGet)) {
      assertThrows(
          RejectedExecutionException.class,
          () ->
              asyncResultSet.setCallback(
                  MoreExecutors.directExecutor(), ignored -> CallbackResponse.DONE));

      // State is rolled back to INITIALIZED so cancel() and resume() reject calls cleanly.
      assertThrows(IllegalStateException.class, asyncResultSet::cancel);
      assertThrows(IllegalStateException.class, asyncResultSet::resume);

      // Rejection should immediately trigger start or close notification so that callers
      // waiting on query initialization are unblocked.
      assertEquals(1, count.get());
      verify(mockService).shutdown();
    }

    // Closing afterwards is a no-op and does not notify a second time.
    assertEquals(1, count.get());
  }

  @Test
  public void testSetCallbackRejectedExecutionClosesInitializedDelegate() {
    ScheduledExecutorService mockService = mock(ScheduledExecutorService.class);
    doThrow(new RejectedExecutionException()).when(mockService).execute(any(Runnable.class));
    ExecutorProvider provider = mock(ExecutorProvider.class, withSettings().withoutAnnotations());
    when(provider.getExecutor()).thenReturn(mockService);
    when(provider.shouldAutoClose()).thenReturn(true);

    ResultSet delegate = mock(ResultSet.class);
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(provider, () -> delegate, 10, () -> {})) {
      // Access metadata to initialize the delegate eagerly
      assertNull(asyncResultSet.getMetadata());

      assertThrows(
          RejectedExecutionException.class,
          () ->
              asyncResultSet.setCallback(
                  MoreExecutors.directExecutor(), ignored -> CallbackResponse.DONE));
    }

    verify(delegate).close();
    verify(mockService).shutdown();
  }

  @Test
  public void testRemoveListenerAfterCloseDoesNotThrow() {
    ResultSet delegate = mock(ResultSet.class);
    Runnable listener = () -> {};
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, () -> delegate, 10)) {
      asyncResultSet.addListener(listener);
      asyncResultSet.close();

      // Calling removeListener after close should not throw IllegalStateException
      asyncResultSet.removeListener(listener);
    }
  }

  @Test
  public void testToListAsyncRejectsNullArguments() {
    ResultSet delegate = mock(ResultSet.class);
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, () -> delegate, 10)) {
      assertThrows(
          NullPointerException.class,
          () -> asyncResultSet.toListAsync(null, MoreExecutors.directExecutor()));
      assertThrows(
          NullPointerException.class, () -> asyncResultSet.toListAsync(reader -> null, null));
    }
  }

  private static void assertAllSchemaMethodsThrowIllegalState(StructReader reader) {
    assertThrows(IllegalStateException.class, reader::getType);
    assertThrows(IllegalStateException.class, reader::getColumnCount);
    assertThrows(IllegalStateException.class, () -> reader.getColumnIndex("id"));
    assertThrows(IllegalStateException.class, () -> reader.getColumnType(0));
    assertThrows(IllegalStateException.class, () -> reader.getColumnType("id"));
  }

  @Test(timeout = 10_000)
  public void testStaleCurrentRowClearedAcrossNotReadyPauseAndDone() throws Exception {
    QueuedExecutorProvider queuedProvider = new QueuedExecutorProvider(false);
    Type rowSchema = Type.struct(Type.StructField.of("id", Type.int64()));
    ControllableStreamingDelegate stream = new ControllableStreamingDelegate(2);
    when(stream.delegate.getType()).thenReturn(rowSchema);
    when(stream.delegate.getColumnCount()).thenReturn(1);
    when(stream.delegate.getColumnIndex("id")).thenReturn(0);
    when(stream.delegate.getColumnType(0)).thenReturn(Type.int64());
    when(stream.delegate.getColumnType("id")).thenReturn(Type.int64());

    AtomicInteger callbackStep = new AtomicInteger();
    try (AsyncResultSetImpl resultSet =
        new AsyncResultSetImpl(queuedProvider, stream.delegate, 10)) {
      ApiFuture<Void> future =
          resultSet.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                int step = callbackStep.incrementAndGet();
                if (step == 1) {
                  assertThrows(IllegalStateException.class, () -> cursor.getLong(0));
                  assertThrows(IllegalStateException.class, cursor::getCurrentRowAsStruct);
                  assertAllSchemaMethodsThrowIllegalState(cursor);

                  assertEquals(CursorState.OK, cursor.tryNext());
                  assertEquals(1L, cursor.getLong(0));
                  assertEquals(1L, cursor.getCurrentRowAsStruct().getLong(0));
                  assertEquals(rowSchema, cursor.getType());

                  // Next tryNext() returns NOT_READY: stale Row 1 must be cleared!
                  assertEquals(CursorState.NOT_READY, cursor.tryNext());
                  assertThrows(IllegalStateException.class, () -> cursor.getLong(0));
                  assertThrows(IllegalStateException.class, cursor::getCurrentRowAsStruct);
                  assertAllSchemaMethodsThrowIllegalState(cursor);
                  return CallbackResponse.CONTINUE;
                }
                if (step == 2) {
                  assertEquals(CursorState.OK, cursor.tryNext());
                  assertEquals(2L, cursor.getLong(0));
                  // Return PAUSE while still positioned on Row 2 (without calling tryNext() again).
                  return CallbackResponse.PAUSE;
                }
                // Step 3: resumed after PAUSE. Before calling tryNext(), stale Row 2 must be
                // cleared even if stream already reached finished = true!
                assertThrows(IllegalStateException.class, () -> cursor.getLong(0));
                assertThrows(IllegalStateException.class, cursor::getCurrentRowAsStruct);
                assertAllSchemaMethodsThrowIllegalState(cursor);

                assertEquals(CursorState.DONE, cursor.tryNext());
                assertThrows(IllegalStateException.class, () -> cursor.getLong(0));
                assertThrows(IllegalStateException.class, cursor::getCurrentRowAsStruct);
                assertEquals(rowSchema, cursor.getType());
                return CallbackResponse.DONE;
              });

      queuedProvider.runNext(); // InitiateStreamingRunnable
      stream.availableRows.set(1);
      stream.emitFlushableChunk("c1", false);
      queuedProvider.runNext(); // ProduceRowsRunnable -> Row 1 + NOT_READY

      stream.availableRows.set(2);
      stream.emitEndOfStream(false);
      queuedProvider.runNext(); // ProduceRowsRunnable -> Row 2 + finished=true -> PAUSE
      resultSet.resume();
      assertNull(future.get(5, TimeUnit.SECONDS));
      assertEquals(3, callbackStep.get());
    }
  }

  @Test(timeout = 10_000)
  public void testSchemaMethodsOnDoneForMultiRowAndEmptyResultSets() throws Exception {
    Type rowSchema =
        Type.struct(
            Type.StructField.of("id", Type.int64()), Type.StructField.of("name", Type.string()));

    // 1. Empty PrePopulatedResultSet (0 rows): on DONE, all schema methods (including returning
    // null for getColumnType("nonexistent")) succeed while row value getters throw.
    ResultSet zeroRowDelegate = ResultSets.forRows(rowSchema, Collections.emptyList());
    try (AsyncResultSetImpl zeroRowResultSet =
        new AsyncResultSetImpl(simpleProvider, zeroRowDelegate, 4)) {
      ApiFuture<Void> future =
          zeroRowResultSet.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                assertAllSchemaMethodsThrowIllegalState(cursor);
                assertEquals(CursorState.DONE, cursor.tryNext());
                assertEquals(rowSchema, cursor.getType());
                assertEquals(2, cursor.getColumnCount());
                assertEquals(0, cursor.getColumnIndex("id"));
                assertEquals(1, cursor.getColumnIndex("name"));
                assertEquals(Type.int64(), cursor.getColumnType(0));
                assertEquals(Type.string(), cursor.getColumnType("name"));
                assertNull(cursor.getColumnType("nonexistent"));
                assertThrows(
                    IllegalArgumentException.class, () -> cursor.getColumnIndex("nonexistent"));
                assertThrows(IllegalStateException.class, cursor::getCurrentRowAsStruct);
                assertThrows(IllegalStateException.class, () -> cursor.getLong(0));
                return CallbackResponse.DONE;
              });
      assertNull(future.get(5, TimeUnit.SECONDS));
      assertAllSchemaMethodsThrowIllegalState(zeroRowResultSet);
    }

    // 2. Multi-rowResultSet: on OK, schema methods read from currentRow without touching delegate
    // schema methods; on DONE, schema methods delegate to underlying ResultSet.
    ResultSet twoRowDelegate =
        ResultSets.forRows(
            rowSchema,
            Arrays.asList(
                Struct.newBuilder().set("id").to(10L).set("name").to("a").build(),
                Struct.newBuilder().set("id").to(20L).set("name").to("b").build()));
    try (AsyncResultSetImpl multiRowResultSet =
        new AsyncResultSetImpl(simpleProvider, twoRowDelegate, 4)) {
      ApiFuture<Void> future =
          multiRowResultSet.setCallback(
              MoreExecutors.directExecutor(),
              cursor -> {
                while (true) {
                  CursorState cursorState = cursor.tryNext();
                  if (cursorState == CursorState.OK) {
                    assertEquals(rowSchema, cursor.getType());
                    assertEquals(2, cursor.getColumnCount());
                    assertEquals(0, cursor.getColumnIndex("id"));
                    assertEquals(Type.int64(), cursor.getColumnType(0));
                    assertEquals(Type.string(), cursor.getColumnType("name"));
                  } else if (cursorState == CursorState.NOT_READY) {
                    return CallbackResponse.CONTINUE;
                  } else {
                    assertEquals(rowSchema, cursor.getType());
                    assertEquals(2, cursor.getColumnCount());
                    assertEquals(1, cursor.getColumnIndex("name"));
                    assertEquals(Type.int64(), cursor.getColumnType(0));
                    assertEquals(Type.string(), cursor.getColumnType("name"));
                    assertNull(cursor.getColumnType("nonexistent"));
                    return CallbackResponse.DONE;
                  }
                }
              });
      assertNull(future.get(5, TimeUnit.SECONDS));
    }
  }

  @Test(timeout = 10_000)
  public void testStaleCurrentRowClearedOnCancelAndMidStreamError() {
    QueuedExecutorProvider queuedProvider = new QueuedExecutorProvider(false);
    Type rowSchema = Type.struct(Type.StructField.of("id", Type.int64()));
    ResultSet twoRowSync =
        ResultSets.forRows(
            rowSchema,
            Arrays.asList(
                Struct.newBuilder().set("id").to(1L).build(),
                Struct.newBuilder().set("id").to(2L).build()));
    BlockingDeque<Runnable> gatedCallbacks = new LinkedBlockingDeque<>();
    try (AsyncResultSetImpl cancelAfterRow1 =
        new AsyncResultSetImpl(queuedProvider, twoRowSync, 10)) {
      ApiFuture<Void> future =
          cancelAfterRow1.setCallback(
              gatedCallbacks::addLast,
              cursor -> {
                assertEquals(CursorState.OK, cursor.tryNext());
                assertEquals(1L, cursor.getLong(0));
                cancelAfterRow1.cancel();
                SpannerException cancelled = assertThrows(SpannerException.class, cursor::tryNext);
                assertEquals(ErrorCode.CANCELLED, cancelled.getErrorCode());
                assertThrows(IllegalStateException.class, () -> cursor.getLong(0));
                assertThrows(IllegalStateException.class, cursor::getCurrentRowAsStruct);
                assertAllSchemaMethodsThrowIllegalState(cursor);
                return CallbackResponse.DONE;
              });
      queuedProvider.runNext(); // InitiateStreamingRunnable
      queuedProvider.runNext(); // ProduceRowsRunnable (reads both rows + finished = true)
      gatedCallbacks.removeFirst().run();
      ExecutionException exec =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertEquals(ErrorCode.CANCELLED, ((SpannerException) exec.getCause()).getErrorCode());
    }

    ResultSet row1ThenError = mock(ResultSet.class);
    when(row1ThenError.next())
        .thenReturn(true)
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(ErrorCode.UNAVAILABLE, "mid-stream boom"));
    when(row1ThenError.getCurrentRowAsStruct())
        .thenReturn(Struct.newBuilder().set("id").to(9L).build());
    try (AsyncResultSetImpl errorAfterRow1 =
        new AsyncResultSetImpl(queuedProvider, row1ThenError, 10)) {
      ApiFuture<Void> future =
          errorAfterRow1.setCallback(
              gatedCallbacks::addLast,
              cursor -> {
                assertEquals(CursorState.OK, cursor.tryNext());
                assertEquals(9L, cursor.getLong(0));
                SpannerException err = assertThrows(SpannerException.class, cursor::tryNext);
                assertEquals(ErrorCode.UNAVAILABLE, err.getErrorCode());
                assertThrows(IllegalStateException.class, () -> cursor.getLong(0));
                assertThrows(IllegalStateException.class, cursor::getCurrentRowAsStruct);
                assertAllSchemaMethodsThrowIllegalState(cursor);
                return CallbackResponse.DONE;
              });
      queuedProvider.runNext(); // InitiateStreamingRunnable
      queuedProvider.runNext(); // ProduceRowsRunnable (buffers row 1 + records UNAVAILABLE)
      gatedCallbacks.removeFirst().run();
      ExecutionException exec =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertEquals(ErrorCode.UNAVAILABLE, ((SpannerException) exec.getCause()).getErrorCode());
    }
  }

  @Test
  public void testBigDecimalStateValidationAndDelegation() {
    AtomicInteger unstartedSupplierCalls = new AtomicInteger();
    AsyncResultSetImpl closedBeforeStart =
        new AsyncResultSetImpl(
            simpleProvider,
            () -> {
              unstartedSupplierCalls.incrementAndGet();
              return mock(ResultSet.class);
            },
            4);
    closedBeforeStart.close();
    assertThrows(IllegalStateException.class, () -> closedBeforeStart.getBigDecimal(0));
    assertThrows(IllegalStateException.class, () -> closedBeforeStart.getBigDecimal("n"));
    assertThrows(IllegalStateException.class, () -> closedBeforeStart.getBigDecimalList(0));
    assertThrows(IllegalStateException.class, () -> closedBeforeStart.getBigDecimalList("na"));
    assertEquals(0, unstartedSupplierCalls.get());

    BigDecimal expectedDecimal = new BigDecimal("12.34");
    List<BigDecimal> expectedDecimalList = Arrays.asList(expectedDecimal, new BigDecimal("56.78"));
    Struct numericRow =
        Struct.newBuilder()
            .set("n")
            .to(expectedDecimal)
            .set("na")
            .toNumericArray(expectedDecimalList)
            .build();
    ResultSet numericDelegate =
        ResultSets.forRows(numericRow.getType(), Collections.singletonList(numericRow));
    try (AsyncResultSetImpl numericResultSet =
        new AsyncResultSetImpl(simpleProvider, numericDelegate, 4)) {
      List<BigDecimal> results =
          numericResultSet.toList(
              reader -> {
                assertEquals(expectedDecimal, reader.getBigDecimal(0));
                assertEquals(expectedDecimal, reader.getBigDecimal("n"));
                assertEquals(expectedDecimalList, reader.getBigDecimalList(1));
                assertEquals(expectedDecimalList, reader.getBigDecimalList("na"));
                return reader.getBigDecimal(0);
              });
      assertEquals(Collections.singletonList(expectedDecimal), results);
    }
  }

  @Test
  public void testSyncModeStateValidation() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new AsyncResultSetImpl(simpleProvider, mock(ResultSet.class), 0));

    Type syncSchema = Type.struct(Type.StructField.of("id", Type.int64()));
    Struct singleRow = Struct.newBuilder().set("id").to(7L).build();
    ResultSet syncDelegate = ResultSets.forRows(syncSchema, Collections.singletonList(singleRow));
    try (AsyncResultSetImpl syncResultSet =
        new AsyncResultSetImpl(simpleProvider, syncDelegate, 4)) {
      assertThrows(IllegalStateException.class, syncResultSet::tryNext);
      assertThrows(IllegalStateException.class, syncResultSet::cancel);
      assertThrows(IllegalStateException.class, syncResultSet::resume);
      assertThrows(IllegalStateException.class, syncResultSet::getCurrentRowAsStruct);
      assertAllSchemaMethodsThrowIllegalState(syncResultSet);

      assertTrue(syncResultSet.next());
      assertThrows(IllegalStateException.class, syncResultSet::cancel);
      assertThrows(IllegalStateException.class, syncResultSet::resume);
      assertThrows(
          IllegalStateException.class,
          () ->
              syncResultSet.setCallback(
                  MoreExecutors.directExecutor(), ignored -> CallbackResponse.DONE));
      assertEquals(7L, syncResultSet.getLong(0));
      assertEquals(singleRow, syncResultSet.getCurrentRowAsStruct());
      assertEquals(syncSchema, syncResultSet.getType());
      assertEquals(1, syncResultSet.getColumnCount());
      assertEquals(0, syncResultSet.getColumnIndex("id"));
      assertEquals(Type.int64(), syncResultSet.getColumnType(0));
      assertEquals(Type.int64(), syncResultSet.getColumnType("id"));

      assertFalse(syncResultSet.next());
      assertEquals(syncSchema, syncResultSet.getType());
      assertEquals(1, syncResultSet.getColumnCount());
      assertEquals(0, syncResultSet.getColumnIndex("id"));
      assertEquals(Type.int64(), syncResultSet.getColumnType(0));
      assertEquals(Type.int64(), syncResultSet.getColumnType("id"));
      assertThrows(IllegalStateException.class, syncResultSet::getCurrentRowAsStruct);

      syncResultSet.close();
      assertThrows(IllegalStateException.class, () -> syncResultSet.getLong(0));
      assertAllSchemaMethodsThrowIllegalState(syncResultSet);
    }
  }

  @Test
  public void testSyncModeTransientSupplierFailureCachesExceptionWithoutLeakingDelegate() {
    SpannerException transientFailure =
        SpannerExceptionFactory.newSpannerException(
            ErrorCode.UNAVAILABLE, "transient supplier failure");
    AtomicInteger supplierCalls = new AtomicInteger();
    ResultSet leakedDelegate = mock(ResultSet.class);

    try (AsyncResultSetImpl syncResultSet =
        new AsyncResultSetImpl(
            simpleProvider,
            () -> {
              if (supplierCalls.incrementAndGet() == 1) {
                throw transientFailure;
              }
              return leakedDelegate;
            },
            4)) {
      assertSame(transientFailure, assertThrows(SpannerException.class, syncResultSet::next));
      assertEquals(1, supplierCalls.get());

      // Every StructReader and schema/metadata method in SYNC mode must route through
      // getOrInitializeDelegate(), rethrowing the cached supplierException without invoking the
      // underlying Supplier a second time or leaking a newly created ResultSet.
      assertSame(
          transientFailure, assertThrows(SpannerException.class, () -> syncResultSet.getLong(0)));
      assertSame(
          transientFailure,
          assertThrows(SpannerException.class, () -> syncResultSet.getString("id")));
      assertSame(
          transientFailure, assertThrows(SpannerException.class, () -> syncResultSet.isNull(0)));
      assertSame(
          transientFailure,
          assertThrows(SpannerException.class, () -> syncResultSet.getBigDecimal(0)));
      assertSame(transientFailure, assertThrows(SpannerException.class, syncResultSet::getType));
      assertSame(
          transientFailure, assertThrows(SpannerException.class, syncResultSet::getColumnCount));
      assertSame(
          transientFailure,
          assertThrows(SpannerException.class, () -> syncResultSet.getColumnIndex("id")));
      assertSame(
          transientFailure,
          assertThrows(SpannerException.class, () -> syncResultSet.getColumnType(0)));
      assertSame(
          transientFailure,
          assertThrows(SpannerException.class, () -> syncResultSet.getColumnType("id")));
      assertSame(transientFailure, assertThrows(SpannerException.class, syncResultSet::getStats));
      assertSame(
          transientFailure, assertThrows(SpannerException.class, syncResultSet::getMetadata));
      assertEquals(1, supplierCalls.get());
    }
    assertEquals(1, supplierCalls.get());
  }

  @Test
  public void testSyncModeNextExceptionClearsStaleCurrentRow() {
    Struct row1 = Struct.newBuilder().set("id").to(1L).build();
    SpannerException row2Failure =
        SpannerExceptionFactory.newSpannerException(ErrorCode.UNAVAILABLE, "row 2 stream failure");
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true).thenThrow(row2Failure);
    when(delegate.getCurrentRowAsStruct()).thenReturn(row1);
    when(delegate.getLong(0)).thenReturn(1L).thenThrow(new IllegalStateException("invalid row"));

    try (AsyncResultSetImpl syncResultSet = new AsyncResultSetImpl(simpleProvider, delegate, 4)) {
      assertTrue(syncResultSet.next());
      assertEquals(1L, syncResultSet.getLong(0));
      assertEquals(row1, syncResultSet.getCurrentRowAsStruct());

      assertSame(row2Failure, assertThrows(SpannerException.class, syncResultSet::next));
      assertThrows(IllegalStateException.class, syncResultSet::getCurrentRowAsStruct);
      assertThrows(IllegalStateException.class, () -> syncResultSet.getLong(0));
    }
  }

  @Test(timeout = 10_000)
  public void testExternalTryNextAndStructReaderRejectedAcrossAsyncStates() throws Exception {
    Struct singleRow = Struct.newBuilder().set("id").to(7L).build();
    CountDownLatch callbackQueuedLatch = new CountDownLatch(1);
    CountDownLatch releaseQueuedCallbackLatch = new CountDownLatch(1);
    CountDownLatch pausedLatch = new CountDownLatch(1);
    ExecutorService callbackBackingExecutor = Executors.newSingleThreadExecutor();
    Executor gatedCallbackExecutor =
        command -> {
          if (callbackQueuedLatch.getCount() > 0) {
            callbackBackingExecutor.execute(
                () -> {
                  callbackQueuedLatch.countDown();
                  try {
                    releaseQueuedCallbackLatch.await(5, TimeUnit.SECONDS);
                  } catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    return;
                  }
                  command.run();
                });
          } else {
            callbackBackingExecutor.execute(command);
          }
        };

    ResultSet asyncDelegate = mock(ResultSet.class);
    when(asyncDelegate.next()).thenReturn(true, false);
    when(asyncDelegate.getCurrentRowAsStruct()).thenReturn(singleRow);
    AtomicInteger callbackInvocations = new AtomicInteger();

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, asyncDelegate, 4)) {
      ApiFuture<Void> resultFuture =
          asyncResultSet.setCallback(
              gatedCallbackExecutor,
              cursor -> {
                int call = callbackInvocations.incrementAndGet();
                if (call == 1) {
                  assertThrows(IllegalStateException.class, () -> cursor.getLong(0));
                  assertThrows(IllegalStateException.class, cursor::getCurrentRowAsStruct);
                  assertEquals(CursorState.OK, cursor.tryNext());
                  assertEquals(7L, cursor.getLong(0));
                  assertEquals(singleRow, cursor.getCurrentRowAsStruct());
                  pausedLatch.countDown();
                  return CallbackResponse.PAUSE;
                }
                assertEquals(CursorState.DONE, cursor.tryNext());
                return CallbackResponse.PAUSE;
              });

      assertThrows(
          IllegalStateException.class,
          () ->
              asyncResultSet.setCallback(
                  MoreExecutors.directExecutor(), ignored -> CallbackResponse.DONE));
      assertThrows(IllegalStateException.class, asyncResultSet::next);
      assertThrows(IllegalStateException.class, () -> asyncResultSet.removeListener(() -> {}));

      assertTrue(callbackQueuedLatch.await(5, TimeUnit.SECONDS));
      assertEquals(AsyncResultSetImpl.State.CONSUMING, asyncResultSet.getState());
      assertThrows(IllegalStateException.class, asyncResultSet::tryNext);
      assertThrows(IllegalStateException.class, asyncResultSet::getCurrentRowAsStruct);
      assertThrows(IllegalStateException.class, () -> asyncResultSet.getLong(0));

      releaseQueuedCallbackLatch.countDown();
      assertTrue(pausedLatch.await(5, TimeUnit.SECONDS));
      callbackBackingExecutor.submit(() -> {}).get(5, TimeUnit.SECONDS);

      assertEquals(AsyncResultSetImpl.State.PAUSED, asyncResultSet.getState());
      assertThrows(IllegalStateException.class, asyncResultSet::tryNext);
      assertThrows(IllegalStateException.class, asyncResultSet::getCurrentRowAsStruct);

      asyncResultSet.resume();
      assertNull(resultFuture.get(5, TimeUnit.SECONDS));

      assertEquals(AsyncResultSetImpl.State.DONE, asyncResultSet.getState());
      asyncResultSet.cancel();
      asyncResultSet.resume();
      assertEquals(AsyncResultSetImpl.State.DONE, asyncResultSet.getState());
      assertThrows(IllegalStateException.class, asyncResultSet::tryNext);
      assertThrows(IllegalStateException.class, asyncResultSet::getCurrentRowAsStruct);
    } finally {
      callbackBackingExecutor.shutdownNow();
    }
  }

  @Test
  public void testSyncModeNextDoesNotCopyCurrentRowAsStructUnlessRequested() {
    Struct row2Struct = Struct.newBuilder().set("id").to(20L).build();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, true, false);
    when(delegate.getLong(0)).thenReturn(10L, 20L);
    when(delegate.getCurrentRowAsStruct()).thenReturn(row2Struct);

    try (AsyncResultSetImpl syncResultSet = new AsyncResultSetImpl(simpleProvider, delegate, 4)) {
      assertTrue(syncResultSet.next());
      assertEquals(10L, syncResultSet.getLong(0));
      verify(delegate, never()).getCurrentRowAsStruct();

      assertTrue(syncResultSet.next());
      assertEquals(20L, syncResultSet.getLong(0));
      verify(delegate, never()).getCurrentRowAsStruct();
      assertSame(row2Struct, syncResultSet.getCurrentRowAsStruct());
      verify(delegate, times(1)).getCurrentRowAsStruct();

      assertFalse(syncResultSet.next());
      assertThrows(IllegalStateException.class, syncResultSet::getCurrentRowAsStruct);
      verify(delegate, times(1)).getCurrentRowAsStruct();
    }
  }
}
