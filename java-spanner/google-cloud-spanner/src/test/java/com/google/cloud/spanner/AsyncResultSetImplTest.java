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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.ExecutorProvider;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.CursorState;
import com.google.cloud.spanner.AsyncResultSet.ReadyCallback;
import com.google.common.base.Function;
import com.google.common.collect.Range;
import com.google.protobuf.ByteString;
import com.google.protobuf.Value;
import com.google.spanner.v1.PartialResultSet;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
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
    mockedProvider = mock(ExecutorProvider.class);
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
      Mockito.verify(mockedProvider.getExecutor(), times(2)).execute(Mockito.any());
    }
  }
}
