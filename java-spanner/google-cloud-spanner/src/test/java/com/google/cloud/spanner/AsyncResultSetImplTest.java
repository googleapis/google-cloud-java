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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.core.ExecutorProvider;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.CursorState;
import com.google.cloud.spanner.AsyncResultSet.ReadyCallback;
import com.google.common.base.Function;
import com.google.common.collect.Range;
import com.google.protobuf.ByteString;
import com.google.protobuf.Value;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@RunWith(JUnit4.class)
public class AsyncResultSetImplTest {
  private ExecutorProvider mockedProvider;
  private ExecutorProvider simpleProvider;

  @Before
  public void setup() {
    mockedProvider = mock(ExecutorProvider.class, withSettings().withoutAnnotations());
    when(mockedProvider.getExecutor()).thenReturn(mock(ScheduledExecutorService.class));
    simpleProvider = SpannerOptions.createAsyncExecutorProvider(1, 1L, TimeUnit.SECONDS);
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
                      paused.set(true);
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
        paused.set(false);
        rs.resume();
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

  @Test
  public void testCallbackIsNotCalledWhilePausedAndCanceled() {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    StreamingResultSet delegate = mock(StreamingResultSet.class);

    final AtomicInteger callbackCounter = new AtomicInteger();
    ApiFuture<Void> callbackResult;

    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {

      when(delegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
          .thenAnswer(
              answer -> {
                rs.onStreamMessage(PartialResultSet.newBuilder().build(), false);
                return null;
              });
      callbackResult =
          rs.setCallback(
              executor,
              resultSet -> {
                callbackCounter.getAndIncrement();
                return CallbackResponse.PAUSE;
              });

      rs.cancel();

      SpannerException exception = assertThrows(SpannerException.class, () -> get(callbackResult));
      assertEquals(ErrorCode.CANCELLED, exception.getErrorCode());
      assertEquals(1, callbackCounter.get());
    } finally {
      executor.shutdown();
    }
  }

  @Test
  public void cancel() throws InterruptedException {
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
    }
  }

  @Test
  public void callbackReturnsError() throws InterruptedException {
    Executor executor = Executors.newSingleThreadExecutor();
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
    }
  }

  @Test
  public void callbackReturnsDoneBeforeEnd_shouldStopIteration() throws Exception {
    Executor executor = Executors.newSingleThreadExecutor();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, true, true, false);
    when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      rs.setCallback(
          executor,
          // Not calling resultSet.tryNext() means that it will also never return DONE.
          // Instead the callback indicates that it does not want any more rows.
          ignored -> CallbackResponse.DONE);
      rs.getResult().get(10L, TimeUnit.SECONDS);
    }
  }

  @Test
  public void testOnStreamMessageWhenResumeTokenIsPresent() {
    StreamingResultSet delegate = mock(StreamingResultSet.class);
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(mockedProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      // Marking Streaming as supported
      Mockito.when(
              delegate.initiateStreaming(Mockito.any(AsyncResultSet.StreamMessageListener.class)))
          .thenReturn(true);
      Mockito.when(delegate.isDataAvailable()).thenReturn(true);

      rs.setCallback(Executors.newSingleThreadExecutor(), ignored -> CallbackResponse.DONE);
      rs.onStreamMessage(
          PartialResultSet.newBuilder().addValues(Value.newBuilder().build()).build(), false);

      rs.onStreamMessage(
          PartialResultSet.newBuilder().setResumeToken(ByteString.copyFromUtf8("test")).build(),
          false);
      Mockito.verify(mockedProvider.getExecutor(), times(2)).execute(Mockito.any());
    }
  }

  @Test
  public void testOnStreamMessageWhenCurrentBufferSizeReachedPrefetchChunkSize() {
    StreamingResultSet delegate = mock(StreamingResultSet.class);
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(mockedProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      // Marking Streaming as supported
      Mockito.when(
              delegate.initiateStreaming(Mockito.any(AsyncResultSet.StreamMessageListener.class)))
          .thenReturn(true);
      Mockito.when(delegate.isDataAvailable()).thenReturn(true);

      rs.setCallback(Executors.newSingleThreadExecutor(), ignored -> CallbackResponse.DONE);
      rs.onStreamMessage(
          PartialResultSet.newBuilder().addValues(Value.newBuilder().build()).build(), true);
      Mockito.verify(mockedProvider.getExecutor(), times(2)).execute(Mockito.any());
    }
  }

  @Test
  public void testOnStreamMessageWhenAsyncResultIsCancelled() {
    StreamingResultSet delegate = mock(StreamingResultSet.class);
    try (AsyncResultSetImpl rs =
        new AsyncResultSetImpl(mockedProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      // Marking Streaming as supported
      Mockito.when(
              delegate.initiateStreaming(Mockito.any(AsyncResultSet.StreamMessageListener.class)))
          .thenReturn(true);

      rs.setCallback(Executors.newSingleThreadExecutor(), ignored -> CallbackResponse.DONE);
      rs.cancel();
      rs.onStreamMessage(
          PartialResultSet.newBuilder().addValues(Value.newBuilder().build()).build(), false);
      Mockito.verify(mockedProvider.getExecutor(), times(1)).execute(Mockito.any());
    }
  }

  @Test
  public void testSequentialRowDeliveryUnderConcurrentEvents() throws Exception {
    ExecutorService callbackExecutor = Executors.newFixedThreadPool(2);
    ExecutorService resumeExecutor = Executors.newFixedThreadPool(2);
    final int rowCount = 100;
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next())
        .thenAnswer(
            new Answer<Boolean>() {
              int currentRowIndex = 0;

              @Override
              public Boolean answer(InvocationOnMock invocation) {
                currentRowIndex++;
                return currentRowIndex <= rowCount;
              }
            });
    when(delegate.getCurrentRowAsStruct())
        .thenAnswer(
            new Answer<Struct>() {
              int currentRowIndex = 0;

              @Override
              public Struct answer(InvocationOnMock invocation) {
                currentRowIndex++;
                return Struct.newBuilder().set("ID").to((long) currentRowIndex).build();
              }
            });

    final List<Long> receivedRowIds = Collections.synchronizedList(new ArrayList<>());
    final CountDownLatch finishedLatch = new CountDownLatch(1);

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> callbackFuture =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                CursorState cursorState;
                while ((cursorState = resultSet.tryNext()) == CursorState.OK) {
                  receivedRowIds.add(resultSet.getLong("ID"));
                }
                if (cursorState == CursorState.DONE) {
                  finishedLatch.countDown();
                  return CallbackResponse.DONE;
                }
                return CallbackResponse.CONTINUE;
              });

      final AtomicBoolean testRunning = new AtomicBoolean(true);
      resumeExecutor.execute(
          () -> {
            while (testRunning.get()) {
              asyncResultSet.resume();
              Thread.yield();
            }
          });

      assertTrue(finishedLatch.await(10, TimeUnit.SECONDS));
      testRunning.set(false);
      assertNull(callbackFuture.get(5, TimeUnit.SECONDS));

      assertEquals(rowCount, receivedRowIds.size());
      for (int i = 0; i < rowCount; i++) {
        assertEquals((long) (i + 1), (long) receivedRowIds.get(i));
      }
    } finally {
      callbackExecutor.shutdown();
      resumeExecutor.shutdown();
    }
  }

  @Test
  public void testNonStreamingResultSetWithSmallBufferCapacity() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    final int rowCount = 50;
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next())
        .thenAnswer(
            new Answer<Boolean>() {
              int currentRowIndex = 0;

              @Override
              public Boolean answer(InvocationOnMock invocation) {
                currentRowIndex++;
                return currentRowIndex <= rowCount;
              }
            });
    when(delegate.getCurrentRowAsStruct())
        .thenAnswer(
            new Answer<Struct>() {
              int currentRowIndex = 0;

              @Override
              public Struct answer(InvocationOnMock invocation) {
                currentRowIndex++;
                return Struct.newBuilder().set("ID").to((long) currentRowIndex).build();
              }
            });

    final List<Long> receivedRowIds = new ArrayList<>();
    // Use buffer size = 1 to force maximum contention and buffer exhaustion
    try (AsyncResultSetImpl asyncResultSet = new AsyncResultSetImpl(simpleProvider, delegate, 1)) {
      ApiFuture<Void> callbackFuture =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                CursorState cursorState;
                while ((cursorState = resultSet.tryNext()) == CursorState.OK) {
                  receivedRowIds.add(resultSet.getLong("ID"));
                }
                if (cursorState == CursorState.DONE) {
                  return CallbackResponse.DONE;
                }
                return CallbackResponse.CONTINUE;
              });

      assertNull(callbackFuture.get(10, TimeUnit.SECONDS));
      assertEquals(rowCount, receivedRowIds.size());
      for (int i = 0; i < rowCount; i++) {
        assertEquals((long) (i + 1), (long) receivedRowIds.get(i));
      }
    } finally {
      callbackExecutor.shutdown();
    }
  }

  @Test
  public void testPostStreamDrainingWithSlowConsumer() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    final int rowCount = 5;
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next())
        .thenAnswer(
            new Answer<Boolean>() {
              int currentRowIndex = 0;

              @Override
              public Boolean answer(InvocationOnMock invocation) {
                currentRowIndex++;
                return currentRowIndex <= rowCount;
              }
            });
    when(delegate.getCurrentRowAsStruct())
        .thenAnswer(
            new Answer<Struct>() {
              int currentRowIndex = 0;

              @Override
              public Struct answer(InvocationOnMock invocation) {
                currentRowIndex++;
                return Struct.newBuilder().set("ID").to((long) currentRowIndex).build();
              }
            });

    final List<Long> receivedRowIds = new ArrayList<>();
    final AtomicBoolean listenerInvoked = new AtomicBoolean(false);

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      asyncResultSet.addListener(() -> listenerInvoked.set(true));

      ApiFuture<Void> callbackFuture =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                CursorState cursorState = resultSet.tryNext();
                if (cursorState == CursorState.OK) {
                  receivedRowIds.add(resultSet.getLong("ID"));
                  return CallbackResponse.PAUSE;
                } else if (cursorState == CursorState.DONE) {
                  return CallbackResponse.DONE;
                }
                return CallbackResponse.CONTINUE;
              });

      while (!callbackFuture.isDone()) {
        Thread.sleep(10);
        asyncResultSet.resume();
      }

      assertNull(callbackFuture.get(5, TimeUnit.SECONDS));
      assertTrue(listenerInvoked.get());
      assertEquals(rowCount, receivedRowIds.size());
    } finally {
      callbackExecutor.shutdown();
    }
  }

  @Test
  public void testStreamingResultSetWithMultipleRowsPerChunk() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    StreamingResultSet delegate = mock(StreamingResultSet.class);
    when(delegate.isDataAvailable()).thenReturn(true);
    final int rowCount = 10;
    when(delegate.next())
        .thenAnswer(
            new Answer<Boolean>() {
              int currentRowIndex = 0;

              @Override
              public Boolean answer(InvocationOnMock invocation) {
                currentRowIndex++;
                return currentRowIndex <= rowCount;
              }
            });
    when(delegate.getCurrentRowAsStruct())
        .thenAnswer(
            new Answer<Struct>() {
              int currentRowIndex = 0;

              @Override
              public Struct answer(InvocationOnMock invocation) {
                currentRowIndex++;
                return Struct.newBuilder().set("ID").to((long) currentRowIndex).build();
              }
            });

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      when(delegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
          .thenAnswer(
              answer -> {
                AsyncResultSet.StreamMessageListener listener = answer.getArgument(0);
                // Deliver one chunk containing a resume token representing all rows
                listener.onStreamMessage(
                    PartialResultSet.newBuilder()
                        .setResumeToken(ByteString.copyFromUtf8("resume-token"))
                        .build(),
                    false);
                return true;
              });

      final List<Long> receivedRowIds = new ArrayList<>();
      ApiFuture<Void> callbackFuture =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                CursorState cursorState;
                while ((cursorState = resultSet.tryNext()) == CursorState.OK) {
                  receivedRowIds.add(resultSet.getLong("ID"));
                }
                if (cursorState == CursorState.DONE) {
                  return CallbackResponse.DONE;
                }
                return CallbackResponse.CONTINUE;
              });

      assertNull(callbackFuture.get(5, TimeUnit.SECONDS));
      assertEquals(rowCount, receivedRowIds.size());
    } finally {
      callbackExecutor.shutdown();
    }
  }

  @Test
  public void testRapidConcurrentPauseResume() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    ExecutorService resumeExecutor = Executors.newFixedThreadPool(4);
    final int rowCount = 100;
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next())
        .thenAnswer(
            new Answer<Boolean>() {
              int currentRowIndex = 0;

              @Override
              public Boolean answer(InvocationOnMock invocation) {
                currentRowIndex++;
                return currentRowIndex <= rowCount;
              }
            });
    when(delegate.getCurrentRowAsStruct())
        .thenAnswer(
            new Answer<Struct>() {
              int currentRowIndex = 0;

              @Override
              public Struct answer(InvocationOnMock invocation) {
                currentRowIndex++;
                return Struct.newBuilder().set("ID").to((long) currentRowIndex).build();
              }
            });

    final List<Long> receivedRowIds = Collections.synchronizedList(new ArrayList<>());
    final Random random = new Random();

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> callbackFuture =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                CursorState cursorState = resultSet.tryNext();
                if (cursorState == CursorState.OK) {
                  receivedRowIds.add(resultSet.getLong("ID"));
                  return random.nextBoolean() ? CallbackResponse.PAUSE : CallbackResponse.CONTINUE;
                } else if (cursorState == CursorState.DONE) {
                  return CallbackResponse.DONE;
                }
                return CallbackResponse.CONTINUE;
              });

      final AtomicBoolean testRunning = new AtomicBoolean(true);
      for (int i = 0; i < 4; i++) {
        resumeExecutor.execute(
            () -> {
              while (testRunning.get()) {
                asyncResultSet.resume();
                Thread.yield();
              }
            });
      }

      assertNull(callbackFuture.get(10, TimeUnit.SECONDS));
      testRunning.set(false);

      assertEquals(rowCount, receivedRowIds.size());
      for (int i = 0; i < rowCount; i++) {
        assertEquals((long) (i + 1), (long) receivedRowIds.get(i));
      }
    } finally {
      callbackExecutor.shutdown();
      resumeExecutor.shutdown();
    }
  }

  @Test
  public void testErrorAfterBufferedRowsDelivered() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next())
        .thenReturn(true)
        .thenReturn(true)
        .thenReturn(true)
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.UNAVAILABLE, "temporary network glitch"));
    when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));

    final List<CursorState> receivedStates = new ArrayList<>();
    final AtomicInteger rowCount = new AtomicInteger();
    final SettableApiFuture<SpannerException> exceptionFuture = SettableApiFuture.create();

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> callbackFuture =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                try {
                  CursorState cursorState = resultSet.tryNext();
                  receivedStates.add(cursorState);
                  if (cursorState == CursorState.OK) {
                    rowCount.incrementAndGet();
                    return CallbackResponse.CONTINUE;
                  }
                  return CallbackResponse.DONE;
                } catch (SpannerException e) {
                  exceptionFuture.set(e);
                  return CallbackResponse.DONE;
                }
              });

      SpannerException callbackException = exceptionFuture.get(5, TimeUnit.SECONDS);
      assertEquals(ErrorCode.UNAVAILABLE, callbackException.getErrorCode());
      assertTrue(callbackException.getMessage().contains("temporary network glitch"));
      assertEquals(3, rowCount.get());

      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> callbackFuture.get(5, TimeUnit.SECONDS));
      assertTrue(executionException.getCause() instanceof SpannerException);
      assertEquals(
          ErrorCode.UNAVAILABLE, ((SpannerException) executionException.getCause()).getErrorCode());
    } finally {
      callbackExecutor.shutdown();
    }
  }

  @Test
  public void testProducerYieldsThreadWhenWaitingForStreamData() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    GrpcResultSet delegate = mock(GrpcResultSet.class);
    AtomicReference<AsyncResultSet.StreamMessageListener> listenerRef = new AtomicReference<>();
    CountDownLatch listenerRegistered = new CountDownLatch(1);
    when(delegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
        .thenAnswer(
            answer -> {
              listenerRef.set(answer.getArgument(0));
              listenerRegistered.countDown();
              return true;
            });
    final AtomicInteger nextCallCount = new AtomicInteger();
    when(delegate.next())
        .thenAnswer(
            invocation -> {
              int count = nextCallCount.incrementAndGet();
              return count <= 2;
            });
    when(delegate.getCurrentRowAsStruct())
        .thenAnswer(
            invocation -> Struct.newBuilder().set("ID").to((long) nextCallCount.get()).build());

    // Initially isDataAvailable is true for the first row, then false until chunk 2 arrives
    AtomicBoolean secondChunkAvailable = new AtomicBoolean(false);
    when(delegate.isDataAvailable())
        .thenAnswer(invocation -> nextCallCount.get() == 0 || secondChunkAvailable.get());

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      List<Long> receivedRows = new ArrayList<>();
      CountDownLatch firstRowReceived = new CountDownLatch(1);

      ApiFuture<Void> callbackFuture =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                CursorState state;
                while ((state = resultSet.tryNext()) == CursorState.OK) {
                  receivedRows.add(resultSet.getLong("ID"));
                  firstRowReceived.countDown();
                }
                if (state == CursorState.DONE) {
                  return CallbackResponse.DONE;
                }
                return CallbackResponse.CONTINUE;
              });

      // Wait for the streaming listener to be registered asynchronously
      assertTrue(listenerRegistered.await(5, TimeUnit.SECONDS));

      // Deliver first message to trigger the producer
      listenerRef
          .get()
          .onStreamMessage(
              PartialResultSet.newBuilder()
                  .setResumeToken(ByteString.copyFromUtf8("chunk-1"))
                  .build(),
              false);
      assertTrue(firstRowReceived.await(5, TimeUnit.SECONDS));
      assertEquals(1, receivedRows.size());

      // While stream is waiting for chunk 2, delegate.isDataAvailable() is false.
      // Submit another task to simpleProvider (which is a 1-thread pool!).
      // If the producer did not yield, the 1-thread pool would be blocked and this task could NOT
      // execute!
      ScheduledExecutorService producerExecutor = simpleProvider.getExecutor();
      Future<String> pingTask = producerExecutor.submit(() -> "pong");
      assertEquals("pong", pingTask.get(2, TimeUnit.SECONDS));

      // Now make chunk 2 available and notify listener
      secondChunkAvailable.set(true);
      listenerRef
          .get()
          .onStreamMessage(
              PartialResultSet.newBuilder()
                  .setResumeToken(ByteString.copyFromUtf8("chunk-2"))
                  .build(),
              false);

      assertNull(callbackFuture.get(5, TimeUnit.SECONDS));
      assertEquals(2, receivedRows.size());
      assertEquals(1L, (long) receivedRows.get(0));
      assertEquals(2L, (long) receivedRows.get(1));
    } finally {
      callbackExecutor.shutdown();
    }
  }

  @Test
  public void testStreamInitializationFailurePropagatesToCallbackAndFuture() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    StreamingResultSet delegate = mock(StreamingResultSet.class);
    when(delegate.initiateStreaming(any(AsyncResultSet.StreamMessageListener.class)))
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT, "Invalid query syntax error"));

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      final SettableApiFuture<SpannerException> exceptionFromCallback = SettableApiFuture.create();

      ApiFuture<Void> callbackFuture =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                try {
                  resultSet.tryNext();
                } catch (SpannerException exception) {
                  exceptionFromCallback.set(exception);
                }
                return CallbackResponse.DONE;
              });

      SpannerException callbackException = exceptionFromCallback.get(5, TimeUnit.SECONDS);
      assertEquals(ErrorCode.INVALID_ARGUMENT, callbackException.getErrorCode());
      assertTrue(callbackException.getMessage().contains("Invalid query syntax error"));

      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> callbackFuture.get(5, TimeUnit.SECONDS));
      assertTrue(executionException.getCause() instanceof SpannerException);
      assertEquals(
          ErrorCode.INVALID_ARGUMENT,
          ((SpannerException) executionException.getCause()).getErrorCode());
    } finally {
      callbackExecutor.shutdown();
    }
  }

  @Test
  public void testCancelDoesNotRunListenersUntilCallbackFinishes() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, false);
    when(delegate.getCurrentRowAsStruct()).thenReturn(Struct.newBuilder().set("ID").to(1L).build());

    final CountDownLatch callbackStartedLatch = new CountDownLatch(1);
    final CountDownLatch allowCallbackToFinishLatch = new CountDownLatch(1);
    final AtomicBoolean listenerRanWhileCallbackExecuting = new AtomicBoolean(false);
    final AtomicBoolean listenerRan = new AtomicBoolean(false);
    final AtomicBoolean callbackFinished = new AtomicBoolean(false);

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      asyncResultSet.addListener(
          () -> {
            listenerRan.set(true);
            if (!callbackFinished.get()) {
              listenerRanWhileCallbackExecuting.set(true);
            }
          });

      ApiFuture<Void> callbackFuture =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                CursorState state = resultSet.tryNext();
                if (state == CursorState.OK) {
                  callbackStartedLatch.countDown();
                  try {
                    assertTrue(allowCallbackToFinishLatch.await(5, TimeUnit.SECONDS));
                  } catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                  }
                  callbackFinished.set(true);
                  return CallbackResponse.CONTINUE;
                }
                return CallbackResponse.DONE;
              });

      // Wait until the callback is actively executing inside cursorReady
      assertTrue(callbackStartedLatch.await(5, TimeUnit.SECONDS));

      // Cancel while the callback is still blocked inside cursorReady
      asyncResultSet.cancel();

      // Ensure that listeners did NOT run while the callback was still executing
      assertFalse(listenerRan.get());
      assertFalse(listenerRanWhileCallbackExecuting.get());

      // Release callback so it can complete
      allowCallbackToFinishLatch.countDown();

      // Now verify that the callback future completes with CANCELLED
      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> callbackFuture.get(5, TimeUnit.SECONDS));
      assertTrue(executionException.getCause() instanceof SpannerException);
      assertEquals(
          ErrorCode.CANCELLED, ((SpannerException) executionException.getCause()).getErrorCode());

      // And the listener has run AFTER callback completed
      assertTrue(listenerRan.get());
      assertFalse(listenerRanWhileCallbackExecuting.get());
    } finally {
      callbackExecutor.shutdown();
    }
  }

  @Test
  public void testGrpcStreamIteratorDoneSetOnCompleted() {
    GrpcStreamIterator streamIterator = new GrpcStreamIterator(false, 4, false);
    assertFalse(streamIterator.isDataAvailable());

    streamIterator.consumer().onCompleted();
    assertTrue(streamIterator.isDataAvailable());
    assertFalse(streamIterator.hasNext());
    assertTrue(streamIterator.isDataAvailable());
  }

  @Test
  public void testBufferClearedOnCancellation() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, true, true, false);
    when(delegate.getCurrentRowAsStruct())
        .thenReturn(
            Struct.newBuilder().set("ID").to(1L).build(),
            Struct.newBuilder().set("ID").to(2L).build(),
            Struct.newBuilder().set("ID").to(3L).build());

    final CountDownLatch callbackStartedLatch = new CountDownLatch(1);
    final CountDownLatch allowCancellationLatch = new CountDownLatch(1);

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> callbackFuture =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                CursorState state = resultSet.tryNext();
                if (state == CursorState.OK) {
                  callbackStartedLatch.countDown();
                  try {
                    assertTrue(allowCancellationLatch.await(5, TimeUnit.SECONDS));
                  } catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                  }
                  return CallbackResponse.CONTINUE;
                }
                return CallbackResponse.DONE;
              });

      assertTrue(callbackStartedLatch.await(5, TimeUnit.SECONDS));
      asyncResultSet.cancel();
      allowCancellationLatch.countDown();

      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> callbackFuture.get(5, TimeUnit.SECONDS));
      assertTrue(executionException.getCause() instanceof SpannerException);
      assertEquals(
          ErrorCode.CANCELLED, ((SpannerException) executionException.getCause()).getErrorCode());
      assertEquals(0, asyncResultSet.getBufferSize());
    } finally {
      callbackExecutor.shutdown();
    }
  }

  @Test
  public void testForwardingResultSetIsDataAvailable() {
    GrpcResultSet grpcDelegate = mock(GrpcResultSet.class);
    when(grpcDelegate.isDataAvailable()).thenReturn(false, true);

    ForwardingResultSet innerForwarding = new ForwardingResultSet(grpcDelegate);
    ForwardingResultSet outerForwarding = new ForwardingResultSet(innerForwarding);

    assertFalse(outerForwarding.isDataAvailable());
    assertTrue(outerForwarding.isDataAvailable());
  }

  @Test
  public void testProducerStopsImmediatelyWhenCallbackThrowsUncheckedException() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true);
    when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> future =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                CursorState state = resultSet.tryNext();
                if (state == CursorState.OK) {
                  throw new RuntimeException("User callback error");
                }
                return CallbackResponse.CONTINUE;
              });

      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertTrue(executionException.getCause() instanceof SpannerException);
      assertTrue(executionException.getCause().getMessage().contains("User callback error"));
      assertEquals(0, asyncResultSet.getBufferSize());
    } finally {
      callbackExecutor.shutdown();
    }
  }

  @Test
  public void testRejectedExecutionExceptionOnProducerService() throws Exception {
    ScheduledExecutorService failingExecutor = mock(ScheduledExecutorService.class);
    Mockito.doThrow(new RejectedExecutionException("Producer rejected"))
        .when(failingExecutor)
        .execute(any(Runnable.class));
    ExecutorProvider failingProvider =
        new ExecutorProvider() {
          @Override
          public boolean shouldAutoClose() {
            return false;
          }

          @Override
          public ScheduledExecutorService getExecutor() {
            return failingExecutor;
          }
        };

    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(
            failingProvider, mock(ResultSet.class), AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> future =
          asyncResultSet.setCallback(callbackExecutor, resultSet -> CallbackResponse.DONE);

      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertTrue(executionException.getCause() instanceof SpannerException);
      assertTrue(executionException.getCause().getMessage().contains("Producer rejected"));
    } finally {
      callbackExecutor.shutdown();
    }
  }

  @Test
  public void testRejectedExecutionExceptionOnCallbackExecutor() {
    Executor failingCallbackExecutor =
        command -> {
          throw new RejectedExecutionException("Callback rejected");
        };
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, false);
    when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> future =
          asyncResultSet.setCallback(failingCallbackExecutor, resultSet -> CallbackResponse.DONE);

      ExecutionException executionException =
          assertThrows(ExecutionException.class, () -> future.get(5, TimeUnit.SECONDS));
      assertTrue(executionException.getCause() instanceof SpannerException);
      assertTrue(executionException.getCause().getMessage().contains("Callback rejected"));
    }
  }

  @Test
  public void testIsUsed() throws Exception {
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, false);
    when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      assertFalse(asyncResultSet.isUsed());
      ExecutorService executor = Executors.newSingleThreadExecutor();
      try {
        ApiFuture<Void> future =
            asyncResultSet.setCallback(
                executor,
                resultSet -> {
                  resultSet.tryNext();
                  return CallbackResponse.DONE;
                });
        assertTrue(asyncResultSet.isUsed());
        future.get(5, TimeUnit.SECONDS);
        assertTrue(asyncResultSet.isUsed());
      } finally {
        executor.shutdown();
      }
    }

    ResultSet delegateSync = mock(ResultSet.class);
    when(delegateSync.next()).thenReturn(true, false);
    when(delegateSync.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));
    try (AsyncResultSetImpl asyncResultSetSync =
        new AsyncResultSetImpl(
            simpleProvider, delegateSync, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      assertFalse(asyncResultSetSync.isUsed());
      assertTrue(asyncResultSetSync.next());
      assertTrue(asyncResultSetSync.isUsed());
    }
  }

  @Test
  public void testListenerPreconditionsAndRemoval() throws Exception {
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(false);

    AtomicBoolean removedListenerCalled = new AtomicBoolean(false);
    AtomicBoolean activeListenerCalled = new AtomicBoolean(false);
    Runnable removedListener = () -> removedListenerCalled.set(true);
    Runnable activeListener = () -> activeListenerCalled.set(true);

    ExecutorService executor = Executors.newSingleThreadExecutor();
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      asyncResultSet.addListener(removedListener);
      asyncResultSet.addListener(activeListener);
      asyncResultSet.removeListener(removedListener);

      ApiFuture<Void> future =
          asyncResultSet.setCallback(
              executor,
              resultSet -> {
                resultSet.tryNext();
                return CallbackResponse.DONE;
              });

      assertThrows(IllegalStateException.class, () -> asyncResultSet.addListener(() -> {}));
      assertThrows(
          IllegalStateException.class, () -> asyncResultSet.removeListener(activeListener));

      future.get(5, TimeUnit.SECONDS);
      assertFalse(removedListenerCalled.get());
      assertTrue(activeListenerCalled.get());
    } finally {
      executor.shutdown();
    }
  }

  @Test
  public void testListenerExceptionDoesNotPreventSubsequentListenersOrCompletion()
      throws Exception {
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(false);

    AtomicBoolean secondListenerCalled = new AtomicBoolean(false);
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      asyncResultSet.addListener(
          () -> {
            throw new RuntimeException("Listener failure");
          });
      asyncResultSet.addListener(() -> secondListenerCalled.set(true));

      ApiFuture<Void> future =
          asyncResultSet.setCallback(
              executor,
              resultSet -> {
                resultSet.tryNext();
                return CallbackResponse.DONE;
              });

      assertNull(future.get(5, TimeUnit.SECONDS));
      assertTrue(secondListenerCalled.get());
    } finally {
      executor.shutdown();
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
  public void testSyncModeOperations() {
    ResultSet delegate = mock(ResultSet.class);
    Struct mockRow = mock(Struct.class);
    when(delegate.next()).thenReturn(true, false);
    when(delegate.getCurrentRowAsStruct()).thenReturn(mockRow);

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      assertTrue(asyncResultSet.next());
      assertEquals(mockRow, asyncResultSet.getCurrentRowAsStruct());

      assertThrows(
          IllegalStateException.class,
          () ->
              asyncResultSet.setCallback(
                  Executors.newSingleThreadExecutor(), resultSet -> CallbackResponse.DONE));

      assertFalse(asyncResultSet.next());
      assertNull(asyncResultSet.getCurrentRowAsStruct());

      ResultSet anotherDelegate = mock(ResultSet.class);
      try (AsyncResultSetImpl asyncResultSet2 =
          new AsyncResultSetImpl(
              simpleProvider, anotherDelegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
        asyncResultSet2.setCallback(
            Executors.newSingleThreadExecutor(), resultSet -> CallbackResponse.DONE);
        assertThrows(IllegalStateException.class, asyncResultSet2::next);
      }

      asyncResultSet.close();
      Mockito.verify(delegate, times(1)).close();
      assertThrows(IllegalStateException.class, asyncResultSet::getCurrentRowAsStruct);
    }
  }

  @Test
  public void testExecutorProviderShouldAutoClose() throws Exception {
    ScheduledExecutorService realService = Executors.newSingleThreadScheduledExecutor();
    ExecutorProvider autoCloseProvider =
        new ExecutorProvider() {
          @Override
          public boolean shouldAutoClose() {
            return true;
          }

          @Override
          public ScheduledExecutorService getExecutor() {
            return realService;
          }
        };

    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(false);

    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(
            autoCloseProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> future =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                resultSet.tryNext();
                return CallbackResponse.DONE;
              });

      future.get(5, TimeUnit.SECONDS);
      assertTrue(realService.isShutdown());
    } finally {
      callbackExecutor.shutdown();
      realService.shutdown();
    }
  }

  @Test
  public void testDefaultIsDataAvailable() {
    StreamingResultSet defaultStreamingResultSet =
        mock(StreamingResultSet.class, Mockito.CALLS_REAL_METHODS);
    assertTrue(defaultStreamingResultSet.isDataAvailable());

    AbstractResultSet.CloseableIterator<?> defaultIterator =
        mock(AbstractResultSet.CloseableIterator.class, Mockito.CALLS_REAL_METHODS);
    assertTrue(defaultIterator.isDataAvailable());
  }

  @Test
  public void testDuplicateCloseIsIdempotent() {
    ResultSet delegate = mock(ResultSet.class);
    AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE);
    asyncResultSet.close();
    verify(delegate, times(1)).close();
    // Second close is a no-op
    asyncResultSet.close();
    verify(delegate, times(1)).close();
  }

  @Test
  public void testCallbackThrowsCancelledException() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true);
    when(delegate.getCurrentRowAsStruct()).thenReturn(mock(Struct.class));
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> future =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                asyncResultSet.cancel();
                // Calling tryNext() will throw CANCELLED_EXCEPTION out of cursorReady
                resultSet.tryNext();
                return CallbackResponse.CONTINUE;
              });
      SpannerException exception = assertThrows(SpannerException.class, () -> get(future));
      assertEquals(ErrorCode.CANCELLED, exception.getErrorCode());
    } finally {
      callbackExecutor.shutdown();
    }
  }

  @Test
  public void testSetCallbackInitiateStreamingRejection() {
    ScheduledExecutorService rejectingExecutor = mock(ScheduledExecutorService.class);
    Mockito.doThrow(new RejectedExecutionException("rejected"))
        .when(rejectingExecutor)
        .execute(any(Runnable.class));
    ExecutorProvider rejectingProvider =
        new ExecutorProvider() {
          @Override
          public boolean shouldAutoClose() {
            return false;
          }

          @Override
          public ScheduledExecutorService getExecutor() {
            return rejectingExecutor;
          }
        };

    ResultSet delegate = mock(ResultSet.class);
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(
            rejectingProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> future =
          asyncResultSet.setCallback(
              Executors.newSingleThreadExecutor(), resultSet -> CallbackResponse.DONE);
      SpannerException exception = assertThrows(SpannerException.class, () -> get(future));
      assertTrue(exception.getMessage().contains("rejected"));
    }
  }

  @Test
  public void testIsDataAvailableExceptionHandling() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    StreamingResultSet delegate = mock(StreamingResultSet.class);
    when(delegate.isDataAvailable()).thenThrow(new RuntimeException("isDataAvailable error"));
    when(delegate.next()).thenReturn(false);

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> future =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                assertEquals(CursorState.DONE, resultSet.tryNext());
                return CallbackResponse.DONE;
              });
      assertNull(future.get(5, TimeUnit.SECONDS));
    } finally {
      callbackExecutor.shutdown();
    }
  }

  @Test
  public void testCallbackProcessingOneRowAtATimeReceivesDone() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, true, false);
    when(delegate.getCurrentRowAsStruct())
        .thenReturn(
            Struct.newBuilder().set("v").to("a").build(),
            Struct.newBuilder().set("v").to("b").build());

    AtomicInteger rowsSeen = new AtomicInteger();
    AtomicBoolean doneReceived = new AtomicBoolean();
    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, AsyncResultSetImpl.DEFAULT_BUFFER_SIZE)) {
      ApiFuture<Void> future =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                CursorState state = resultSet.tryNext();
                if (state == CursorState.OK) {
                  rowsSeen.incrementAndGet();
                  return CallbackResponse.CONTINUE;
                }
                if (state == CursorState.DONE) {
                  doneReceived.set(true);
                  return CallbackResponse.DONE;
                }
                return CallbackResponse.CONTINUE;
              });
      assertNull(future.get(5, TimeUnit.SECONDS));
      assertTrue(doneReceived.get());
      assertEquals(2, rowsSeen.get());
    } finally {
      callbackExecutor.shutdown();
    }
  }

  @Test
  public void testHighVolumeStreamingWithoutBufferStarvation() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    int totalRowCount = 50_000;
    int bufferCapacity = 50;

    StreamingResultSet delegate =
        new ForwardingResultSet(mock(ResultSet.class)) {
          private int currentRow = 0;
          private Struct currentStruct;

          @Override
          public boolean next() {
            if (currentRow < totalRowCount) {
              currentRow++;
              currentStruct = Struct.newBuilder().set("ID").to((long) currentRow).build();
              return true;
            }
            return false;
          }

          @Override
          public Struct getCurrentRowAsStruct() {
            return currentStruct;
          }

          @Override
          public boolean isDataAvailable() {
            return true;
          }

          @Override
          public boolean initiateStreaming(AsyncResultSet.StreamMessageListener listener) {
            return true;
          }
        };

    AtomicInteger rowsReceived = new AtomicInteger();
    AtomicBoolean doneReceived = new AtomicBoolean();

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, bufferCapacity)) {
      ApiFuture<Void> future =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                while (true) {
                  switch (resultSet.tryNext()) {
                    case OK:
                      int expectedId = rowsReceived.incrementAndGet();
                      assertEquals(expectedId, resultSet.getLong("ID"));
                      break;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                    case DONE:
                      doneReceived.set(true);
                      return CallbackResponse.DONE;
                  }
                }
              });

      assertNull(future.get(30, TimeUnit.SECONDS));
      assertTrue(doneReceived.get());
      assertEquals(totalRowCount, rowsReceived.get());
    } finally {
      callbackExecutor.shutdown();
      assertTrue(callbackExecutor.awaitTermination(5, TimeUnit.SECONDS));
    }
  }

  @Test
  public void testHighVolumeStreamingWithAsyncChunkArrivals() throws Exception {
    ExecutorService callbackExecutor = Executors.newSingleThreadExecutor();
    ExecutorService feederExecutor = Executors.newSingleThreadExecutor();
    int totalRowCount = 10_000;
    int chunkSize = 100;
    int bufferCapacity = 50;

    AtomicInteger availableRows = new AtomicInteger();
    AtomicReference<AsyncResultSet.StreamMessageListener> registeredListener =
        new AtomicReference<>();
    CountDownLatch streamingInitiated = new CountDownLatch(1);

    StreamingResultSet delegate =
        new ForwardingResultSet(mock(ResultSet.class)) {
          private int currentRow = 0;
          private Struct currentStruct;

          @Override
          public boolean next() {
            if (currentRow < totalRowCount) {
              currentRow++;
              currentStruct = Struct.newBuilder().set("ID").to((long) currentRow).build();
              return true;
            }
            return false;
          }

          @Override
          public Struct getCurrentRowAsStruct() {
            return currentStruct;
          }

          @Override
          public boolean isDataAvailable() {
            return currentRow < availableRows.get() || currentRow >= totalRowCount;
          }

          @Override
          public boolean initiateStreaming(AsyncResultSet.StreamMessageListener listener) {
            registeredListener.set(listener);
            streamingInitiated.countDown();
            return true;
          }
        };

    Semaphore chunkRequested = new Semaphore(1);
    AtomicInteger rowsReceived = new AtomicInteger();
    AtomicBoolean doneReceived = new AtomicBoolean();

    try (AsyncResultSetImpl asyncResultSet =
        new AsyncResultSetImpl(simpleProvider, delegate, bufferCapacity)) {
      ApiFuture<Void> future =
          asyncResultSet.setCallback(
              callbackExecutor,
              resultSet -> {
                while (true) {
                  switch (resultSet.tryNext()) {
                    case OK:
                      int expectedId = rowsReceived.incrementAndGet();
                      assertEquals(expectedId, resultSet.getLong("ID"));
                      break;
                    case NOT_READY:
                      if (availableRows.get() < totalRowCount
                          && chunkRequested.availablePermits() == 0) {
                        chunkRequested.release();
                      }
                      return CallbackResponse.CONTINUE;
                    case DONE:
                      doneReceived.set(true);
                      return CallbackResponse.DONE;
                  }
                }
              });

      assertTrue(streamingInitiated.await(5, TimeUnit.SECONDS));
      feederExecutor.execute(
          () -> {
            try {
              while (availableRows.get() < totalRowCount) {
                chunkRequested.acquire();
                availableRows.addAndGet(chunkSize);
                AsyncResultSet.StreamMessageListener listener = registeredListener.get();
                if (listener != null) {
                  listener.onStreamMessage(PartialResultSet.getDefaultInstance(), false);
                }
              }
            } catch (InterruptedException ignored) {
            }
          });

      assertNull(future.get(30, TimeUnit.SECONDS));
      assertTrue(doneReceived.get());
      assertEquals(totalRowCount, rowsReceived.get());
    } finally {
      feederExecutor.shutdownNow();
      callbackExecutor.shutdown();
      assertTrue(feederExecutor.awaitTermination(5, TimeUnit.SECONDS));
      assertTrue(callbackExecutor.awaitTermination(5, TimeUnit.SECONDS));
    }
  }
}
