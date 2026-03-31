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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.core.ExecutorProvider;
import com.google.cloud.spanner.AbstractReadContext.ListenableAsyncResultSet;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Default implementation for {@link AsyncResultSet}. */
class AsyncResultSetImpl extends ForwardingStructReader
    implements ListenableAsyncResultSet, AsyncResultSet.StreamMessageListener {
  private static final Logger log = Logger.getLogger(AsyncResultSetImpl.class.getName());

  /** State of an {@link AsyncResultSetImpl}. */
  private enum State {
    INITIALIZED,
    STREAMING_INITIALIZED,
    /** SYNC indicates that the {@link ResultSet} is used in sync pattern. */
    SYNC,
    CONSUMING,
    RUNNING,
    PAUSED,
    CANCELLED(true),
    DONE(true);

    /** Does this state mean that the result set should permanently stop producing rows. */
    private final boolean shouldStop;

    State() {
      shouldStop = false;
    }

    State(boolean shouldStop) {
      this.shouldStop = shouldStop;
    }
  }

  static final int DEFAULT_BUFFER_SIZE = 10;
  private static final int MAX_WAIT_FOR_BUFFER_CONSUMPTION = 10;
  private static final SpannerException CANCELLED_EXCEPTION =
      SpannerExceptionFactory.newSpannerException(
          ErrorCode.CANCELLED, "This AsyncResultSet has been cancelled");

  private final Object monitor = new Object();
  private boolean closed;

  /**
   * {@link ExecutorProvider} provides executor services that are used to fetch data from the
   * backend and put these into the buffer for further consumption by the callback.
   */
  private final ExecutorProvider executorProvider;

  private final ListeningScheduledExecutorService service;

  private final BlockingDeque<Struct> buffer;
  private Struct currentRow;

  /** Supplies the underlying synchronous {@link ResultSet} that will be producing the rows. */
  private final Supplier<ResultSet> delegateResultSet;

  /**
   * Any exception that occurs while executing the query and iterating over the result set will be
   * stored in this variable and propagated to the user through {@link #tryNext()}.
   */
  private volatile SpannerException executionException;

  /**
   * Executor for callbacks. Regardless of the type of executor that is provided, the {@link
   * AsyncResultSetImpl} will ensure that at most 1 callback call will be active at any one time.
   */
  private Executor executor;

  private ReadyCallback callback;

  /**
   * Listeners that will be called when the {@link AsyncResultSetImpl} has finished fetching all
   * rows and any underlying transaction or session can be closed.
   */
  private final Collection<Runnable> listeners = new LinkedList<>();

  private volatile State state = State.INITIALIZED;

  /** This variable indicates that produce rows thread is initiated */
  private volatile boolean produceRowsInitiated;

  /**
   * This variable indicates whether all the results from the underlying result set have been read.
   */
  private volatile boolean finished;

  private volatile SettableApiFuture<Void> result;

  /**
   * This variable indicates whether {@link #tryNext()} has returned {@link CursorState#DONE} or a
   * {@link SpannerException}.
   */
  private volatile boolean cursorReturnedDoneOrException;

  /**
   * This variable is used to pause the producer when the {@link AsyncResultSet} is paused. The
   * production of rows that are put into the buffer is only paused once the buffer is full.
   */
  private volatile CountDownLatch pausedLatch = new CountDownLatch(1);

  /**
   * This variable is used to pause the producer when the buffer is full and the consumer needs some
   * time to catch up.
   */
  private volatile CountDownLatch bufferConsumptionLatch = new CountDownLatch(0);

  /**
   * This variable is used to pause the producer when all rows have been put into the buffer, but
   * the consumer (the callback) has not yet received and processed all rows.
   */
  private volatile CountDownLatch consumingLatch = new CountDownLatch(0);

  AsyncResultSetImpl(ExecutorProvider executorProvider, ResultSet delegate, int bufferSize) {
    this(executorProvider, Suppliers.ofInstance(Preconditions.checkNotNull(delegate)), bufferSize);
  }

  AsyncResultSetImpl(
      ExecutorProvider executorProvider, Supplier<ResultSet> delegate, int bufferSize) {
    super(delegate);
    this.executorProvider = Preconditions.checkNotNull(executorProvider);
    this.delegateResultSet = Preconditions.checkNotNull(delegate);
    this.service = MoreExecutors.listeningDecorator(executorProvider.getExecutor());
    this.buffer = new LinkedBlockingDeque<>(bufferSize);
  }

  /**
   * Closes the {@link AsyncResultSet}. {@link #close()} is non-blocking and may be called multiple
   * times without side effects. An {@link AsyncResultSet} may be closed before all rows have been
   * returned to the callback, and calling {@link #tryNext()} on a closed {@link AsyncResultSet} is
   * allowed as long as this is done from within a {@link ReadyCallback}. Calling {@link #resume()}
   * on a closed {@link AsyncResultSet} is also allowed.
   */
  @Override
  public void close() {
    synchronized (monitor) {
      if (this.closed) {
        return;
      }
      if (state == State.INITIALIZED || state == State.SYNC) {
        delegateResultSet.get().close();
      }
      this.closed = true;
    }
  }

  /**
   * Adds a listener that will be called when no more rows will be read from the underlying {@link
   * ResultSet}, either because all rows have been read, or because {@link
   * ReadyCallback#cursorReady(AsyncResultSet)} returned {@link CallbackResponse#DONE}.
   */
  @Override
  public void addListener(Runnable listener) {
    Preconditions.checkState(state == State.INITIALIZED);
    listeners.add(listener);
  }

  @Override
  public void removeListener(Runnable listener) {
    Preconditions.checkState(state == State.INITIALIZED);
    listeners.remove(listener);
  }

  /**
   * Tries to advance this {@link AsyncResultSet} to the next row. This method may only be called
   * from within a {@link ReadyCallback}.
   */
  @Override
  public CursorState tryNext() throws SpannerException {
    synchronized (monitor) {
      if (state == State.CANCELLED) {
        cursorReturnedDoneOrException = true;
        throw CANCELLED_EXCEPTION;
      }
      if (buffer.isEmpty() && executionException != null) {
        cursorReturnedDoneOrException = true;
        throw executionException;
      }
      Preconditions.checkState(
          this.callback != null, "tryNext may only be called after a callback has been set.");
      Preconditions.checkState(
          this.state == State.CONSUMING,
          "tryNext may only be called from a DataReady callback. Current state: "
              + this.state.name());

      if (finished && buffer.isEmpty()) {
        cursorReturnedDoneOrException = true;
        return CursorState.DONE;
      }
    }
    if (!buffer.isEmpty()) {
      // Set the next row from the buffer as the current row of the StructReader.
      replaceDelegate(currentRow = buffer.pop());
      synchronized (monitor) {
        bufferConsumptionLatch.countDown();
      }
      return CursorState.OK;
    }
    return CursorState.NOT_READY;
  }

  private void closeDelegateResultSet() {
    try {
      delegateResultSet.get().close();
    } catch (Throwable t) {
      log.log(Level.FINE, "Ignoring error from closing delegate result set", t);
    }
  }

  /**
   * {@link CallbackRunnable} calls the {@link ReadyCallback} registered for this {@link
   * AsyncResultSet}.
   */
  private class CallbackRunnable implements Runnable {
    @Override
    public void run() {
      try {
        while (true) {
          synchronized (monitor) {
            if (cursorReturnedDoneOrException) {
              break;
            }
            if (state == State.CANCELLED) {
              // The callback should always get at least one chance to catch the CANCELLED
              // exception. It is however possible that the callback does not call tryNext(), and
              // instead directly returns PAUSE or DONE. In those cases, the callback runner should
              // also stop, even though the callback has not seen the CANCELLED state.
              cursorReturnedDoneOrException = true;
            }
          }
          CallbackResponse response;
          try {
            response = callback.cursorReady(AsyncResultSetImpl.this);
          } catch (Throwable e) {
            synchronized (monitor) {
              if (cursorReturnedDoneOrException
                  && state == State.CANCELLED
                  && e instanceof SpannerException
                  && ((SpannerException) e).getErrorCode() == ErrorCode.CANCELLED) {
                // The callback did not catch the cancelled exception (which it should have), but
                // we'll keep the cancelled state.
                return;
              }
              executionException = SpannerExceptionFactory.asSpannerException(e);
              cursorReturnedDoneOrException = true;
            }
            return;
          }
          synchronized (monitor) {
            if (state == State.CANCELLED) {
              if (cursorReturnedDoneOrException) {
                return;
              }
            } else {
              switch (response) {
                case DONE:
                  state = State.DONE;
                  cursorReturnedDoneOrException = true;
                  return;
                case PAUSE:
                  state = State.PAUSED;
                  // Make sure no-one else is waiting on the current pause latch and create a new
                  // one.
                  pausedLatch.countDown();
                  pausedLatch = new CountDownLatch(1);
                  return;
                case CONTINUE:
                  if (buffer.isEmpty()) {
                    // Call the callback once more if the entire result set has been processed but
                    // the callback has not yet received a CursorState.DONE or a CANCELLED error.
                    if (finished && !cursorReturnedDoneOrException) {
                      break;
                    }
                    state = State.RUNNING;
                    return;
                  }
                  break;
                default:
                  throw new IllegalStateException("Unknown response: " + response);
              }
            }
          }
        }
      } finally {
        synchronized (monitor) {
          // Count down all latches that the producer might be waiting on.
          consumingLatch.countDown();
          while (bufferConsumptionLatch.getCount() > 0L) {
            bufferConsumptionLatch.countDown();
          }
        }
      }
    }
  }

  private final CallbackRunnable callbackRunnable = new CallbackRunnable();

  /**
   * {@link ProduceRowsRunnable} reads data from the underlying {@link ResultSet}, places these in
   * the buffer and dispatches the {@link CallbackRunnable} when data is ready to be consumed.
   */
  private class ProduceRowsRunnable implements Runnable {
    @Override
    public void run() {
      boolean stop = false;
      boolean hasNext = false;
      try {
        hasNext = delegateResultSet.get().next();
      } catch (Throwable e) {
        synchronized (monitor) {
          executionException = SpannerExceptionFactory.asSpannerException(e);
        }
      }
      try {
        while (!stop && hasNext) {
          try {
            synchronized (monitor) {
              stop = state.shouldStop;
            }
            if (!stop) {
              while (buffer.remainingCapacity() == 0 && !stop) {
                waitIfPaused();
                // The buffer is full and we should let the callback consume a number of rows before
                // we proceed with producing any more rows to prevent us from potentially waiting on
                // a full buffer repeatedly.
                // Wait until at least half of the buffer is available, or if it's a bigger buffer,
                // wait until at least 10 rows can be placed in it.
                // TODO: Make this more dynamic / configurable?
                startCallbackWithBufferLatchIfNecessary(
                    Math.min(
                        Math.min(buffer.size() / 2 + 1, buffer.size()),
                        MAX_WAIT_FOR_BUFFER_CONSUMPTION));
                bufferConsumptionLatch.await();
                synchronized (monitor) {
                  stop = state.shouldStop;
                }
              }
            }
            if (!stop) {
              buffer.put(delegateResultSet.get().getCurrentRowAsStruct());
              startCallbackIfNecessary();
              hasNext = delegateResultSet.get().next();
            }
          } catch (Throwable e) {
            synchronized (monitor) {
              executionException = SpannerExceptionFactory.asSpannerException(e);
              stop = true;
            }
          }
        }
        // We don't need any more data from the underlying result set, so we close it as soon as
        // possible. Any error that might occur during this will be ignored.
        closeDelegateResultSet();

        // Ensure that the callback has been called at least once, even if the result set was
        // cancelled.
        synchronized (monitor) {
          finished = true;
          stop = cursorReturnedDoneOrException;
        }
        // Call the callback if there are still rows in the buffer that need to be processed.
        while (!stop) {
          try {
            waitIfPaused();
            startCallbackIfNecessary();
            // Make sure we wait until the callback runner has actually finished.
            consumingLatch.await();
            synchronized (monitor) {
              stop = cursorReturnedDoneOrException;
            }
          } catch (Throwable e) {
            result.setException(e);
            return;
          }
        }
      } finally {
        if (executorProvider.shouldAutoClose()) {
          service.shutdown();
        }
        for (Runnable listener : listeners) {
          listener.run();
        }
        synchronized (monitor) {
          if (executionException != null) {
            result.setException(executionException);
          } else if (state == State.CANCELLED) {
            result.setException(CANCELLED_EXCEPTION);
          } else {
            result.set(null);
          }
        }
      }
    }

    private void waitIfPaused() throws InterruptedException {
      CountDownLatch pause;
      synchronized (monitor) {
        pause = pausedLatch;
      }
      pause.await();
    }

    private void startCallbackIfNecessary() {
      startCallbackWithBufferLatchIfNecessary(0);
    }

    private void startCallbackWithBufferLatchIfNecessary(int bufferLatch) {
      synchronized (monitor) {
        if ((state == State.RUNNING || state == State.CANCELLED)
            && !cursorReturnedDoneOrException) {
          consumingLatch = new CountDownLatch(1);
          if (bufferLatch > 0) {
            bufferConsumptionLatch = new CountDownLatch(bufferLatch);
          }
          if (state == State.RUNNING) {
            state = State.CONSUMING;
          }
          executor.execute(callbackRunnable);
        }
      }
    }
  }

  private class InitiateStreamingRunnable implements Runnable {

    @Override
    public void run() {
      try {
        // This method returns true if the underlying result set is a streaming result set (e.g. a
        // GrpcResultSet).
        // Those result sets will trigger initiateProduceRows() when the first results are received.
        // Non-streaming result sets do not trigger this callback, and for those result sets, we
        // need to eagerly start the ProduceRowsRunnable.
        if (!initiateStreaming(AsyncResultSetImpl.this)) {
          initiateProduceRows();
        }
      } catch (Throwable exception) {
        executionException = SpannerExceptionFactory.asSpannerException(exception);
        initiateProduceRows();
      }
    }
  }

  /** Sets the callback for this {@link AsyncResultSet}. */
  @Override
  public ApiFuture<Void> setCallback(Executor exec, ReadyCallback cb) {
    synchronized (monitor) {
      Preconditions.checkState(!closed, "This AsyncResultSet has been closed");
      Preconditions.checkState(
          this.state == State.INITIALIZED, "callback may not be set multiple times");

      // Start to fetch data and buffer these.
      this.result = SettableApiFuture.create();
      this.state = State.STREAMING_INITIALIZED;
      this.service.execute(new InitiateStreamingRunnable());
      this.executor = MoreExecutors.newSequentialExecutor(Preconditions.checkNotNull(exec));
      this.callback = Preconditions.checkNotNull(cb);
      pausedLatch.countDown();
      return result;
    }
  }

  private void initiateProduceRows() {
    synchronized (monitor) {
      if (this.state == State.STREAMING_INITIALIZED) {
        this.state = State.RUNNING;
      }
      produceRowsInitiated = true;
    }
    this.service.execute(new ProduceRowsRunnable());
  }

  Future<Void> getResult() {
    return result;
  }

  @Override
  public void cancel() {
    synchronized (monitor) {
      Preconditions.checkState(
          state != State.INITIALIZED && state != State.SYNC,
          "cannot cancel a result set without a callback");
      state = State.CANCELLED;
      pausedLatch.countDown();
    }
  }

  @Override
  public void resume() {
    synchronized (monitor) {
      Preconditions.checkState(
          state != State.INITIALIZED && state != State.SYNC,
          "cannot resume a result set without a callback");
      if (state == State.PAUSED) {
        state = State.RUNNING;
        pausedLatch.countDown();
      }
    }
  }

  private static class CreateListCallback<T> implements ReadyCallback {
    private final SettableApiFuture<List<T>> future;
    private final Function<StructReader, T> transformer;
    private final ImmutableList.Builder<T> builder = ImmutableList.builder();

    private CreateListCallback(
        SettableApiFuture<List<T>> future, Function<StructReader, T> transformer) {
      this.future = future;
      this.transformer = transformer;
    }

    @Override
    public CallbackResponse cursorReady(AsyncResultSet resultSet) {
      try {
        while (true) {
          switch (resultSet.tryNext()) {
            case DONE:
              future.set(builder.build());
              return CallbackResponse.DONE;
            case NOT_READY:
              return CallbackResponse.CONTINUE;
            case OK:
              builder.add(transformer.apply(resultSet));
              break;
          }
        }
      } catch (Throwable t) {
        future.setException(t);
        return CallbackResponse.DONE;
      }
    }
  }

  @Override
  public <T> ApiFuture<List<T>> toListAsync(
      Function<StructReader, T> transformer, Executor executor) {
    synchronized (monitor) {
      Preconditions.checkState(!closed, "This AsyncResultSet has been closed");
      Preconditions.checkState(
          this.state == State.INITIALIZED, "This AsyncResultSet has already been used.");
      final SettableApiFuture<List<T>> res = SettableApiFuture.create();
      CreateListCallback<T> callback = new CreateListCallback<>(res, transformer);
      ApiFuture<Void> finished = setCallback(executor, callback);
      return ApiFutures.transformAsync(finished, ignored -> res, MoreExecutors.directExecutor());
    }
  }

  @Override
  public <T> List<T> toList(Function<StructReader, T> transformer) throws SpannerException {
    ApiFuture<List<T>> future = toListAsync(transformer, MoreExecutors.directExecutor());
    try {
      return future.get();
    } catch (ExecutionException e) {
      throw SpannerExceptionFactory.asSpannerException(e.getCause());
    } catch (Throwable e) {
      throw SpannerExceptionFactory.asSpannerException(e);
    }
  }

  @Override
  public boolean next() throws SpannerException {
    synchronized (monitor) {
      Preconditions.checkState(
          this.state == State.INITIALIZED || this.state == State.SYNC,
          "Cannot call next() on a result set with a callback.");
      this.state = State.SYNC;
    }
    boolean res = delegateResultSet.get().next();
    currentRow = res ? delegateResultSet.get().getCurrentRowAsStruct() : null;
    return res;
  }

  @Override
  public ResultSetStats getStats() {
    return delegateResultSet.get().getStats();
  }

  @Override
  public ResultSetMetadata getMetadata() {
    return delegateResultSet.get().getMetadata();
  }

  boolean initiateStreaming(StreamMessageListener streamMessageListener) {
    return StreamingUtil.initiateStreaming(delegateResultSet.get(), streamMessageListener);
  }

  @Override
  protected void checkValidState() {
    synchronized (monitor) {
      Preconditions.checkState(
          state == State.SYNC || state == State.CONSUMING || state == State.CANCELLED,
          "only allowed after a next() call or from within a ReadyCallback#cursorReady callback");
      Preconditions.checkState(state != State.SYNC || !closed, "ResultSet is closed");
    }
  }

  @Override
  public Struct getCurrentRowAsStruct() {
    checkValidState();
    return currentRow;
  }

  @Override
  public void onStreamMessage(PartialResultSet partialResultSet, boolean bufferIsFull) {
    synchronized (monitor) {
      if (produceRowsInitiated) {
        return;
      }
      // if PartialResultSet contains a resume token or buffer size is full, or
      // we have reached the end of the stream, we can start the thread.
      boolean startJobThread =
          !partialResultSet.getResumeToken().isEmpty()
              || bufferIsFull
              || partialResultSet == GrpcStreamIterator.END_OF_STREAM;
      if (startJobThread || state != State.STREAMING_INITIALIZED) {
        initiateProduceRows();
      }
    }
  }
}
