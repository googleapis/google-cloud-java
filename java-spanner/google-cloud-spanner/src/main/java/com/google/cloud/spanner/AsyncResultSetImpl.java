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
import com.google.common.annotations.VisibleForTesting;
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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/** Default implementation for {@link AsyncResultSet}. */
@NullMarked
class AsyncResultSetImpl extends ForwardingStructReader
    implements AbstractReadContext.ListenableAsyncResultSet, AsyncResultSet.StreamMessageListener {
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
  @Nullable private Struct currentRow;

  /** Supplies the underlying synchronous {@link ResultSet} that will be producing the rows. */
  private final Supplier<ResultSet> delegateResultSet;

  /**
   * Any exception that occurs while executing the query and iterating over the result set will be
   * stored in this variable and propagated to the user through {@link #tryNext()}.
   */
  @Nullable private volatile SpannerException executionException;

  /**
   * Executor for callbacks. Regardless of the type of executor that is provided, the {@link
   * AsyncResultSetImpl} will ensure that at most 1 callback call will be active at any one time.
   */
  @Nullable private Executor executor;

  @Nullable private ReadyCallback callback;

  /**
   * Listeners that will be called when the {@link AsyncResultSetImpl} has finished fetching all
   * rows and any underlying transaction or session can be closed.
   */
  private final Collection<Runnable> listeners = new LinkedList<>();

  private volatile State state = State.INITIALIZED;

  /** Indicates whether a task is currently executing ProduceRowsRunnable. */
  private boolean producerRunning;

  /** Indicates whether a ProduceRowsRunnable task has been submitted and is waiting to run. */
  private boolean producerScheduled;

  /** Indicates whether produce rows has been initiated. */
  private boolean produceRowsInitiated;

  /** Indicates whether the result future and cleanup have been completed. */
  private boolean completed;

  /**
   * This variable indicates whether all the results from the underlying result set have been read.
   */
  private volatile boolean finished;

  @Nullable private volatile SettableApiFuture<Void> result;

  /**
   * This variable indicates whether {@link #tryNext()} has returned {@link CursorState#DONE} or a
   * {@link SpannerException}.
   */
  private volatile boolean cursorReturnedDoneOrException;

  private boolean callbackRunning;
  private boolean callbackScheduled;

  AsyncResultSetImpl(ExecutorProvider executorProvider, ResultSet delegate, int bufferSize) {
    this(executorProvider, Suppliers.ofInstance(Preconditions.checkNotNull(delegate)), bufferSize);
  }

  AsyncResultSetImpl(
      ExecutorProvider executorProvider, Supplier<ResultSet> delegate, int bufferSize) {
    this(
        executorProvider,
        Suppliers.memoize(Preconditions.checkNotNull(delegate)),
        bufferSize,
        true);
  }

  private AsyncResultSetImpl(
      ExecutorProvider executorProvider,
      Supplier<ResultSet> memoizedDelegate,
      int bufferSize,
      boolean dummy) {
    super(memoizedDelegate);
    this.executorProvider = Preconditions.checkNotNull(executorProvider);
    this.delegateResultSet = memoizedDelegate;
    this.service = MoreExecutors.listeningDecorator(executorProvider.getExecutor());
    this.buffer = new LinkedBlockingDeque<>(bufferSize);
  }

  boolean isUsed() {
    synchronized (monitor) {
      return state != State.INITIALIZED;
    }
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
    boolean shouldCloseDelegate = false;
    boolean shouldShutdownService = false;
    synchronized (monitor) {
      if (this.closed) {
        return;
      }
      if (state == State.INITIALIZED || state == State.SYNC) {
        shouldCloseDelegate = true;
        if (executorProvider.shouldAutoClose()) {
          shouldShutdownService = true;
        }
      }
      this.closed = true;
    }
    if (shouldCloseDelegate) {
      closeDelegateResultSet();
    }
    if (shouldShutdownService) {
      service.shutdown();
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
          this.state == State.CONSUMING,
          "tryNext may only be called from a DataReady callback. Current state: "
              + this.state.name());

      if (finished && buffer.isEmpty()) {
        cursorReturnedDoneOrException = true;
        return CursorState.DONE;
      }
    }
    Struct nextRow = buffer.poll();
    if (nextRow != null) {
      // Set the next row from the buffer as the current row of the StructReader.
      replaceDelegate(currentRow = nextRow);
      scheduleProducerIfNecessary();
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
      synchronized (monitor) {
        callbackScheduled = false;
        callbackRunning = true;
      }
      try {
        while (true) {
          ReadyCallback callback;
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
            callback = AsyncResultSetImpl.this.callback;
          }
          if (callback == null) {
            return;
          }
          CallbackResponse response;
          try {
            response = callback.cursorReady(AsyncResultSetImpl.this);
          } catch (Throwable throwable) {
            synchronized (monitor) {
              if (cursorReturnedDoneOrException
                  && state == State.CANCELLED
                  && throwable instanceof SpannerException
                  && ((SpannerException) throwable).getErrorCode() == ErrorCode.CANCELLED) {
                // The callback did not catch the cancelled exception (which it should have), but
                // we'll keep the cancelled state.
                return;
              }
              executionException = SpannerExceptionFactory.asSpannerException(throwable);
              cursorReturnedDoneOrException = true;
            }
            closeDelegateResultSet();
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
                  return;
                case CONTINUE:
                  if (buffer.isEmpty()) {
                    // Call the callback once more if the entire result set has been processed or an
                    // exception was encountered, but the callback has not yet received a
                    // CursorState.DONE or error.
                    if ((finished || executionException != null)
                        && !cursorReturnedDoneOrException) {
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
          callbackRunning = false;
        }
        scheduleCallbackIfNecessary();
        checkCompletion();
      }
    }
  }

  private final CallbackRunnable callbackRunnable = new CallbackRunnable();
  private final ProduceRowsRunnable produceRowsRunnable = new ProduceRowsRunnable();

  /**
   * {@link ProduceRowsRunnable} reads data from the underlying {@link ResultSet}, places these in
   * the buffer and dispatches the {@link CallbackRunnable} when data is ready to be consumed.
   */
  private class ProduceRowsRunnable implements Runnable {
    @Override
    public void run() {
      try {
        boolean stopped;
        synchronized (monitor) {
          producerScheduled = false;
          stopped = shouldStopProducer();
          if (!stopped) {
            if (state == State.STREAMING_INITIALIZED) {
              state = State.RUNNING;
            }
            produceRowsInitiated = true;
            producerRunning = true;
          }
        }
        if (stopped) {
          checkCompletion();
          return;
        }
        while (true) {
          synchronized (monitor) {
            if (shouldStopProducer() || buffer.remainingCapacity() == 0) {
              return;
            }
          }
          if (!isDataAvailable()) {
            return;
          }

          boolean hasNext = delegateResultSet.get().next();
          if (hasNext) {
            buffer.put(delegateResultSet.get().getCurrentRowAsStruct());
            scheduleCallbackIfNecessary();
          } else {
            synchronized (monitor) {
              finished = true;
            }
            closeDelegateResultSet();
            break;
          }
        }
        scheduleCallbackIfNecessary();
      } catch (InterruptedException interruptedException) {
        Thread.currentThread().interrupt();
        setExecutionException(interruptedException);
        scheduleCallbackIfNecessary();
      } catch (Throwable throwable) {
        setExecutionException(throwable);
        scheduleCallbackIfNecessary();
      } finally {
        synchronized (monitor) {
          producerRunning = false;
        }
        scheduleProducerIfNecessary();
        checkCompletion();
      }
    }
  }

  private boolean isDataAvailable() {
    try {
      return StreamingUtil.isDataAvailable(delegateResultSet.get());
    } catch (Throwable t) {
      return true;
    }
  }

  private void setExecutionException(Throwable throwable) {
    synchronized (monitor) {
      if (executionException == null && !state.shouldStop) {
        executionException = SpannerExceptionFactory.asSpannerException(throwable);
      }
    }
  }

  private boolean shouldStopProducer() {
    return finished
        || state.shouldStop
        || state == State.PAUSED
        || executionException != null
        || cursorReturnedDoneOrException;
  }

  private boolean canScheduleProducer() {
    return !producerRunning
        && !producerScheduled
        && !shouldStopProducer()
        && buffer.remainingCapacity() > 0;
  }

  private void scheduleProducerIfNecessary() {
    synchronized (monitor) {
      if (!canScheduleProducer()) {
        return;
      }
    }
    if (!isDataAvailable()) {
      return;
    }
    boolean shouldSchedule = false;
    synchronized (monitor) {
      if (canScheduleProducer()) {
        if (state == State.STREAMING_INITIALIZED) {
          state = State.RUNNING;
        }
        produceRowsInitiated = true;
        producerScheduled = true;
        shouldSchedule = true;
      }
    }
    if (shouldSchedule) {
      try {
        service.execute(produceRowsRunnable);
      } catch (Throwable throwable) {
        synchronized (monitor) {
          producerScheduled = false;
          if (executionException == null && !state.shouldStop) {
            executionException = SpannerExceptionFactory.asSpannerException(throwable);
          }
        }
        scheduleCallbackIfNecessary();
        checkCompletion();
      }
    }
  }

  private boolean canScheduleCallback() {
    return (state == State.RUNNING || state == State.CANCELLED)
        && !cursorReturnedDoneOrException
        && !callbackRunning
        && !callbackScheduled
        && (!buffer.isEmpty()
            || finished
            || executionException != null
            || state == State.CANCELLED);
  }

  private void scheduleCallbackIfNecessary() {
    boolean shouldExecute = false;
    Executor executor = null;
    synchronized (monitor) {
      if (canScheduleCallback() && this.executor != null) {
        if (state == State.RUNNING) {
          state = State.CONSUMING;
        }
        callbackScheduled = true;
        shouldExecute = true;
        executor = this.executor;
      }
    }
    if (shouldExecute && executor != null) {
      try {
        executor.execute(callbackRunnable);
      } catch (Throwable throwable) {
        synchronized (monitor) {
          callbackScheduled = false;
          cursorReturnedDoneOrException = true;
          if (executionException == null && !state.shouldStop) {
            executionException = SpannerExceptionFactory.asSpannerException(throwable);
          }
        }
        checkCompletion();
      }
    }
  }

  private void checkCompletion() {
    boolean shouldComplete = false;
    synchronized (monitor) {
      if (!completed
          && !producerRunning
          && !producerScheduled
          && !callbackRunning
          && !callbackScheduled) {
        if (state == State.DONE) {
          completed = true;
          shouldComplete = true;
        } else if (state == State.CANCELLED) {
          if (cursorReturnedDoneOrException) {
            completed = true;
            shouldComplete = true;
          }
        } else if (cursorReturnedDoneOrException
            && ((finished && buffer.isEmpty()) || executionException != null)) {
          state = State.DONE;
          completed = true;
          shouldComplete = true;
        }
      }
    }
    if (shouldComplete) {
      cleanupAndCompleteResult();
    }
  }

  private void cleanupAndCompleteResult() {
    closeDelegateResultSet();
    buffer.clear();
    currentRow = null;
    if (executorProvider.shouldAutoClose()) {
      service.shutdown();
    }
    callback = null;
    executor = null;
    for (Runnable listener : listeners) {
      try {
        listener.run();
      } catch (Throwable t) {
        log.log(Level.WARNING, "Listener threw exception", t);
      }
    }
    listeners.clear();
    SettableApiFuture<Void> resultFuture = this.result;
    if (resultFuture != null) {
      if (executionException != null) {
        resultFuture.setException(executionException);
      } else if (state == State.CANCELLED) {
        resultFuture.setException(CANCELLED_EXCEPTION);
      } else {
        resultFuture.set(null);
      }
    }
  }

  @VisibleForTesting
  int getBufferSize() {
    return buffer.size();
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
        } else {
          scheduleProducerIfNecessary();
        }
      } catch (Throwable exception) {
        synchronized (monitor) {
          executionException = SpannerExceptionFactory.asSpannerException(exception);
          produceRowsInitiated = true;
          if (state == State.STREAMING_INITIALIZED) {
            state = State.RUNNING;
          }
        }
        scheduleCallbackIfNecessary();
        checkCompletion();
      }
    }
  }

  /** Sets the callback for this {@link AsyncResultSet}. */
  @Override
  public ApiFuture<Void> setCallback(Executor executor, ReadyCallback callback) {
    SettableApiFuture<Void> resultFuture;
    synchronized (monitor) {
      Preconditions.checkState(!closed, "This AsyncResultSet has been closed");
      Preconditions.checkState(
          this.state == State.INITIALIZED, "callback may not be set multiple times");

      // Start to fetch data and buffer these.
      this.result = resultFuture = SettableApiFuture.create();
      this.state = State.STREAMING_INITIALIZED;
      this.executor = MoreExecutors.newSequentialExecutor(Preconditions.checkNotNull(executor));
      this.callback = Preconditions.checkNotNull(callback);
    }
    try {
      this.service.execute(new InitiateStreamingRunnable());
    } catch (Throwable throwable) {
      synchronized (monitor) {
        cursorReturnedDoneOrException = true;
        if (executionException == null) {
          executionException = SpannerExceptionFactory.asSpannerException(throwable);
        }
      }
      checkCompletion();
    }
    return resultFuture;
  }

  private void initiateProduceRows() {
    synchronized (monitor) {
      if (this.produceRowsInitiated) {
        return;
      }
      this.produceRowsInitiated = true;
      if (this.state == State.STREAMING_INITIALIZED) {
        this.state = State.RUNNING;
      }
    }
    scheduleProducerIfNecessary();
    checkCompletion();
  }

  @Nullable Future<Void> getResult() {
    return result;
  }

  @Override
  public void cancel() {
    boolean shouldStartCallback = false;
    synchronized (monitor) {
      Preconditions.checkState(
          state != State.INITIALIZED && state != State.SYNC,
          "cannot cancel a result set without a callback");
      state = State.CANCELLED;
      if (!callbackRunning && !callbackScheduled) {
        shouldStartCallback = true;
      }
    }
    closeDelegateResultSet();
    if (shouldStartCallback) {
      scheduleCallbackIfNecessary();
    }
    checkCompletion();
  }

  @Override
  public void resume() {
    boolean shouldStartCallback = false;
    boolean shouldScheduleProducer = false;
    synchronized (monitor) {
      Preconditions.checkState(
          state != State.INITIALIZED && state != State.SYNC,
          "cannot resume a result set without a callback");
      if (completed) {
        return;
      }
      if (state == State.PAUSED) {
        state = State.RUNNING;
        shouldStartCallback = true;
        shouldScheduleProducer = true;
      }
    }
    if (shouldStartCallback) {
      scheduleCallbackIfNecessary();
    }
    if (shouldScheduleProducer) {
      scheduleProducerIfNecessary();
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
      final SettableApiFuture<List<T>> resultFuture = SettableApiFuture.create();
      CreateListCallback<T> callback = new CreateListCallback<>(resultFuture, transformer);
      ApiFuture<Void> finished = setCallback(executor, callback);
      return ApiFutures.transformAsync(
          finished, ignored -> resultFuture, MoreExecutors.directExecutor());
    }
  }

  @Override
  public <T> List<T> toList(Function<StructReader, T> transformer) throws SpannerException {
    ApiFuture<List<T>> future = toListAsync(transformer, MoreExecutors.directExecutor());
    try {
      return future.get();
    } catch (ExecutionException executionException) {
      throw SpannerExceptionFactory.asSpannerException(executionException.getCause());
    } catch (Throwable throwable) {
      throw SpannerExceptionFactory.asSpannerException(throwable);
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
    boolean hasNext = delegateResultSet.get().next();
    currentRow = hasNext ? delegateResultSet.get().getCurrentRowAsStruct() : null;
    return hasNext;
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
    boolean shouldInitiate = false;
    synchronized (monitor) {
      if (!produceRowsInitiated) {
        shouldInitiate = true;
      }
    }
    if (shouldInitiate) {
      initiateProduceRows();
    } else {
      scheduleProducerIfNecessary();
    }
  }
}
