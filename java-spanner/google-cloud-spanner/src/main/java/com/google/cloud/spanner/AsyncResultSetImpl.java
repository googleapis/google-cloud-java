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
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/** Default implementation for {@link AsyncResultSet}. */
@NullMarked
class AsyncResultSetImpl extends ForwardingStructReader
    implements ListenableAsyncResultSet, AsyncResultSet.StreamMessageListener {
  private static final Logger log = Logger.getLogger(AsyncResultSetImpl.class.getName());

  /** State of an {@link AsyncResultSetImpl}. */
  @VisibleForTesting
  enum State {
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
  static final int MAX_BUFFERED_CHUNKS = 512;
  private static final int MAX_WAIT_FOR_BUFFER_CONSUMPTION = 10;

  private final Object monitor = new Object();

  @GuardedBy("monitor")
  private boolean closed;

  /**
   * {@link ExecutorProvider} provides executor services that are used to fetch data from the
   * backend and put these into the buffer for further consumption by the callback.
   */
  private final ExecutorProvider executorProvider;

  private final ScheduledExecutorService service;

  private final int maxBufferSize;

  @GuardedBy("monitor")
  private final ArrayDeque<Struct> buffer;

  @GuardedBy("monitor")
  private boolean waitingForBufferSpace;

  @Nullable private volatile Struct currentRow;

  private volatile boolean syncHasCurrentRow;

  /** Supplies the underlying synchronous {@link ResultSet} that will be producing the rows. */
  private final Supplier<ResultSet> delegateResultSet;

  @VisibleForTesting @Nullable volatile ResultSet initializedDelegate;

  /**
   * Callback invoked once when query execution begins or when the result set is closed without
   * starting, allowing callers (like {@link MultiUseReadOnlyTransaction}) to track query lifecycle.
   */
  private final Runnable onStartOrClose;

  @GuardedBy("monitor")
  private boolean startOrCloseNotified;

  @GuardedBy("monitor")
  private boolean delegateInitialized;

  @GuardedBy("monitor")
  private boolean delegateClosed;

  /**
   * Any exception that occurs while executing the query and iterating over the result set will be
   * stored in this variable and propagated to the user through {@link #tryNext()}.
   */
  @GuardedBy("monitor")
  @Nullable
  private SpannerException executionException;

  @GuardedBy("monitor")
  @Nullable
  private SpannerException cancelledException;

  /**
   * Executor for callbacks. Regardless of the type of executor that is provided, the {@link
   * AsyncResultSetImpl} will ensure that at most 1 callback call will be active at any one time.
   */
  @GuardedBy("monitor")
  @Nullable
  private Executor executor;

  @GuardedBy("monitor")
  @Nullable
  private ReadyCallback callback;

  /**
   * Listeners that will be called when the {@link AsyncResultSetImpl} has finished fetching all
   * rows and any underlying transaction or session can be closed.
   */
  @GuardedBy("monitor")
  private final Collection<Runnable> listeners = new ArrayList<>(2);

  @GuardedBy("monitor")
  private State state = State.INITIALIZED;

  /** Indicates whether InitiateStreamingRunnable is currently scheduled or executing. */
  @GuardedBy("monitor")
  private boolean initiatingStreaming;

  /** Indicates whether the delegate dynamically supports non-blocking streaming notifications. */
  @GuardedBy("monitor")
  private boolean streamingSupported;

  /** Indicates whether a task is currently scheduled or executing ProduceRowsRunnable. */
  @GuardedBy("monitor")
  private boolean producerRunning;

  /** Indicates whether a producer wakeup has been requested while a producer task is running. */
  @GuardedBy("monitor")
  private boolean producerWakeupRequested;

  /** Indicates whether produce rows has been initiated. */
  @GuardedBy("monitor")
  private boolean produceRowsInitiated;

  /**
   * Counts initial stream chunks without a resume token before {@link #produceRowsInitiated} flips
   * to {@code true}, ensuring row production starts once {@link ResumableStreamIterator} exceeds
   * {@link #MAX_BUFFERED_CHUNKS} even when {@code prefetchChunks} is larger.
   */
  @GuardedBy("monitor")
  private int initialChunksWithoutResumeToken;

  /**
   * Indicates whether the entire async result set lifecycle and cleanup have been completed (all
   * rows processed/handled, callback done, future resolved, resources freed).
   */
  @GuardedBy("monitor")
  private boolean completed;

  /** Indicates whether a task is currently scheduled or executing CallbackRunnable. */
  @GuardedBy("monitor")
  private boolean callbackRunning;

  /**
   * The thread currently executing {@link ReadyCallback#cursorReady(AsyncResultSet)}, or {@code
   * null} when no callback invocation is in progress. Written only under {@link #monitor} by the
   * callback thread itself; volatile allows lock-free self-thread checks in {@link
   * #checkValidState()}.
   */
  @Nullable private volatile Thread callbackInvocationThread;

  /**
   * This variable indicates whether all the results from the underlying result set have been read.
   */
  @GuardedBy("monitor")
  private boolean finished;

  @GuardedBy("monitor")
  @Nullable
  private SettableApiFuture<Void> result;

  /**
   * This variable indicates whether {@link #tryNext()} has returned {@link CursorState#DONE} or a
   * {@link SpannerException}.
   */
  @GuardedBy("monitor")
  private boolean cursorReturnedDoneOrException;

  @VisibleForTesting
  State getState() {
    synchronized (monitor) {
      return state;
    }
  }

  AsyncResultSetImpl(ExecutorProvider executorProvider, ResultSet delegate, int bufferSize) {
    this(
        executorProvider,
        Suppliers.ofInstance(Preconditions.checkNotNull(delegate)),
        bufferSize,
        /* onStartOrClose= */ () -> {},
        /* delegateInitialized= */ true);
  }

  AsyncResultSetImpl(
      ExecutorProvider executorProvider, Supplier<ResultSet> delegate, int bufferSize) {
    this(executorProvider, delegate, bufferSize, /* onStartOrClose= */ () -> {});
  }

  AsyncResultSetImpl(
      ExecutorProvider executorProvider,
      Supplier<ResultSet> delegate,
      int bufferSize,
      Runnable onStartOrClose) {
    this(
        executorProvider,
        new MemoizingSupplier(Preconditions.checkNotNull(delegate)),
        bufferSize,
        Preconditions.checkNotNull(onStartOrClose),
        /* delegateInitialized= */ false);
  }

  private AsyncResultSetImpl(
      ExecutorProvider executorProvider,
      Supplier<ResultSet> memoizedDelegate,
      int bufferSize,
      Runnable onStartOrClose,
      boolean delegateInitialized) {
    super(memoizedDelegate);
    Preconditions.checkArgument(bufferSize > 0, "bufferSize must be > 0");
    this.executorProvider = Preconditions.checkNotNull(executorProvider);
    this.delegateResultSet = memoizedDelegate;
    this.onStartOrClose = onStartOrClose;
    this.delegateInitialized = delegateInitialized;
    this.service = executorProvider.getExecutor();
    this.maxBufferSize = bufferSize;
    this.buffer = new ArrayDeque<>(Math.min(bufferSize, 1024));
    replaceDelegateSupplier(this::currentRowOrDelegate);
  }

  private StructReader currentRowOrDelegate() {
    Struct row = getCurrentCallbackRow();
    return row != null ? row : getOrInitializeDelegate();
  }

  /**
   * Returns the underlying {@link ResultSet}, lazily initializing it on first access and handling
   * any necessary early-close reconciliation and start/close notifications.
   */
  private ResultSet getOrInitializeDelegate() {
    ResultSet delegate = initializedDelegate;
    if (delegate != null) {
      return delegate;
    }
    try {
      delegate = delegateResultSet.get();
      closeIfClosedBeforeInitialization(delegate);
    } finally {
      maybeNotifyStartOrClose();
    }
    initializedDelegate = delegate;
    return delegate;
  }

  private void closeIfClosedBeforeInitialization(ResultSet delegate) {
    boolean shouldCloseImmediately = false;
    synchronized (monitor) {
      if (!delegateInitialized) {
        delegateInitialized = true;
        if (delegateClosed) {
          shouldCloseImmediately = true;
        }
      }
    }
    if (shouldCloseImmediately) {
      try {
        delegate.close();
      } catch (Throwable throwable) {
        log.log(Level.FINE, "Ignoring error from closing delegate result set", throwable);
      }
    }
  }

  private void maybeNotifyStartOrClose() {
    boolean shouldNotify = false;
    synchronized (monitor) {
      if (!startOrCloseNotified) {
        startOrCloseNotified = true;
        shouldNotify = true;
      }
    }
    if (shouldNotify) {
      try {
        onStartOrClose.run();
      } catch (Throwable throwable) {
        log.log(Level.WARNING, "Failed to execute onStartOrClose callback", throwable);
      }
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
    boolean shouldNotifyClose = false;
    synchronized (monitor) {
      if (this.closed) {
        return;
      }
      if (state == State.INITIALIZED || state == State.SYNC) {
        shouldCloseDelegate = true;
        currentRow = null;
        syncHasCurrentRow = false;
      }
      if (state == State.INITIALIZED) {
        shouldNotifyClose = true;
      }
      this.closed = true;
    }
    if (shouldCloseDelegate) {
      closeDelegateResultSet();
      if (executorProvider.shouldAutoClose()) {
        service.shutdown();
      }
    }
    if (shouldNotifyClose) {
      maybeNotifyStartOrClose();
    }
  }

  /**
   * Adds a listener that will be called when no more rows will be read from the underlying {@link
   * ResultSet}, either because all rows have been read, or because {@link
   * ReadyCallback#cursorReady(AsyncResultSet)} returned {@link CallbackResponse#DONE}.
   */
  @Override
  public void addListener(Runnable listener) {
    synchronized (monitor) {
      Preconditions.checkState(state == State.INITIALIZED);
      listeners.add(listener);
    }
  }

  @Override
  public void removeListener(Runnable listener) {
    synchronized (monitor) {
      Preconditions.checkState(state == State.INITIALIZED || closed);
      listeners.remove(listener);
    }
  }

  /**
   * Tries to advance this {@link AsyncResultSet} to the next row. This method may only be called
   * from within a {@link ReadyCallback}.
   */
  @Override
  public CursorState tryNext() throws SpannerException {
    boolean shouldExecuteProducer = false;
    synchronized (monitor) {
      Preconditions.checkState(
          isInCallbackInvocation(), "tryNext may only be called from a DataReady callback.");
      if (state == State.CANCELLED) {
        currentRow = null;
        cursorReturnedDoneOrException = true;
        throw Preconditions.checkNotNull(cancelledException);
      }
      if (!buffer.isEmpty()) {
        currentRow = buffer.removeFirst();
        if (waitingForBufferSpace && hasBufferBatchSpace()) {
          waitingForBufferSpace = false;
          shouldExecuteProducer = prepareScheduleProducerLocked();
        }
      } else {
        currentRow = null;
        if (executionException != null) {
          cursorReturnedDoneOrException = true;
          throw executionException;
        } else if (finished) {
          cursorReturnedDoneOrException = true;
          return CursorState.DONE;
        } else {
          return CursorState.NOT_READY;
        }
      }
    }
    if (shouldExecuteProducer) {
      executeProducer();
    }
    return CursorState.OK;
  }

  @GuardedBy("monitor")
  private boolean hasBufferBatchSpace() {
    int minAvailableSlots = Math.min(maxBufferSize / 2 + 1, MAX_WAIT_FOR_BUFFER_CONSUMPTION);
    return maxBufferSize - buffer.size() >= minAvailableSlots;
  }

  private void closeDelegateResultSet() {
    boolean shouldClose = false;
    synchronized (monitor) {
      if (!delegateClosed) {
        delegateClosed = true;
        shouldClose = delegateInitialized;
      }
    }
    if (shouldClose) {
      try {
        delegateResultSet.get().close();
      } catch (Throwable throwable) {
        log.log(Level.FINE, "Ignoring error from closing delegate result set", throwable);
      }
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
          ReadyCallback callback;
          synchronized (monitor) {
            if (state == State.CANCELLED) {
              // The callback should always get at least one chance to catch the CANCELLED
              // exception. It is however possible that the callback does not call tryNext(), and
              // instead directly returns PAUSE or DONE. In those cases, the callback runner should
              // also stop, even though the callback has not seen the CANCELLED state.
              cursorReturnedDoneOrException = true;
            }
            callback = Preconditions.checkNotNull(AsyncResultSetImpl.this.callback);
            callbackInvocationThread = Thread.currentThread();
          }
          CallbackResponse response;
          try {
            response =
                Preconditions.checkNotNull(
                    callback.cursorReady(AsyncResultSetImpl.this),
                    "CallbackResponse may not be null");
          } catch (Throwable throwable) {
            boolean shouldCloseDelegate = true;
            synchronized (monitor) {
              currentRow = null;
              callbackInvocationThread = null;
              cursorReturnedDoneOrException = true;
              if (state == State.CANCELLED && throwable == cancelledException) {
                // The callback did not catch the cancelled exception (which it should have), but
                // we'll keep the cancelled state.
                shouldCloseDelegate = false;
              } else {
                executionException = SpannerExceptionFactory.asSpannerException(throwable);
              }
            }
            if (shouldCloseDelegate) {
              closeDelegateResultSet();
            }
            return;
          }
          boolean shouldCloseDelegate = false;
          boolean shouldReturn = false;
          synchronized (monitor) {
            currentRow = null;
            callbackInvocationThread = null;
            if (response == CallbackResponse.DONE || cursorReturnedDoneOrException) {
              if (state != State.CANCELLED) {
                state = State.DONE;
              }
              cursorReturnedDoneOrException = true;
              shouldCloseDelegate = true;
              shouldReturn = true;
            } else if (state == State.CANCELLED) {
              // cancel() occurred concurrently during cursorReady() before tryNext() observed
              // CANCELLED, and callback returned PAUSE or CONTINUE. Loop once more so the
              // callback gets its one guaranteed chance to catch CANCELLED.
            } else if (response == CallbackResponse.PAUSE) {
              state = State.PAUSED;
              shouldReturn = true;
            } else if (buffer.isEmpty() && !finished && executionException == null) {
              state = State.RUNNING;
              shouldReturn = true;
            }
          }
          if (shouldCloseDelegate) {
            closeDelegateResultSet();
          }
          if (shouldReturn) {
            return;
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

  /**
   * {@link ProduceRowsRunnable} reads data from the underlying {@link ResultSet}, places these in
   * the buffer and dispatches the {@link CallbackRunnable} when data is ready to be consumed.
   *
   * <p>For {@link StreamingResultSet} delegates, this task yields back to the executor whenever
   * {@link StreamingResultSet#isDataAvailable()} returns {@code false} or the row buffer reaches
   * {@link #maxBufferSize}, and is re-scheduled by {@link #onStreamMessage} or consumer drain. A
   * task thread may still block synchronously on non-streaming {@link ResultSet} implementations or
   * mid-stream retry backoff inside {@link ResumableStreamIterator}.
   */
  private class ProduceRowsRunnable implements Runnable {
    @Override
    public void run() {
      try {
        boolean isStreaming;
        synchronized (monitor) {
          if (shouldStopProducer()) {
            return;
          }
          producerWakeupRequested = false;
          isStreaming = streamingSupported;
        }
        ResultSet delegate = getOrInitializeDelegate();
        while (true) {
          if (!isDataAvailable(delegate)) {
            synchronized (monitor) {
              if (producerWakeupRequested && !shouldStopProducer()) {
                producerWakeupRequested = false;
                continue;
              }
            }
            break;
          }
          boolean hasNext = delegate.next();
          if (hasNext) {
            Struct row = delegate.getCurrentRowAsStruct();
            boolean shouldScheduleCallback;
            synchronized (monitor) {
              buffer.addLast(row);
              if (buffer.size() >= maxBufferSize) {
                waitingForBufferSpace = true;
                break;
              }
              if (shouldStopProducer()) {
                break;
              }
              producerWakeupRequested = false;
              shouldScheduleCallback =
                  !callbackRunning && (!isStreaming || buffer.size() >= DEFAULT_BUFFER_SIZE);
            }
            if (shouldScheduleCallback) {
              scheduleCallbackIfNecessary();
              synchronized (monitor) {
                if (shouldStopProducer()) {
                  break;
                }
              }
            }
          } else {
            closeDelegateResultSet();
            synchronized (monitor) {
              finished = true;
            }
            break;
          }
        }
        scheduleCallbackIfNecessary();
      } catch (Throwable throwable) {
        synchronized (monitor) {
          setExecutionExceptionLocked(throwable);
        }
        closeDelegateResultSet();
        scheduleCallbackIfNecessary();
      } finally {
        boolean shouldExecuteProducer = false;
        synchronized (monitor) {
          producerRunning = false;
          if (producerWakeupRequested) {
            producerWakeupRequested = false;
            shouldExecuteProducer = prepareScheduleProducerLocked();
          }
        }
        if (shouldExecuteProducer) {
          executeProducer();
        }
        checkCompletion();
      }
    }
  }

  private final ProduceRowsRunnable produceRowsRunnable = new ProduceRowsRunnable();

  private static boolean isDataAvailable(ResultSet delegate) {
    try {
      return StreamingUtil.isDataAvailable(delegate);
    } catch (Throwable throwable) {
      // Returning true ensures that any exception encountered while checking for available data is
      // not swallowed. The producer will proceed to invoke next(), where the exception is caught,
      // recorded in executionException, and propagated to the caller.
      return true;
    }
  }

  @GuardedBy("monitor")
  private void setExecutionExceptionLocked(Throwable throwable) {
    if (executionException == null && !state.shouldStop) {
      executionException = SpannerExceptionFactory.asSpannerException(throwable);
    }
  }

  @GuardedBy("monitor")
  private boolean shouldStopProducer() {
    return finished
        || cursorReturnedDoneOrException
        || state.shouldStop
        || state == State.PAUSED
        || executionException != null;
  }

  @GuardedBy("monitor")
  private boolean canScheduleProducer() {
    return !initiatingStreaming
        && produceRowsInitiated
        && !shouldStopProducer()
        && !waitingForBufferSpace;
  }

  @GuardedBy("monitor")
  private boolean prepareScheduleProducerLocked() {
    if (producerRunning) {
      if (!shouldStopProducer() && !waitingForBufferSpace) {
        producerWakeupRequested = true;
      }
      return false;
    }
    if (!canScheduleProducer()) {
      return false;
    }
    producerRunning = true;
    producerWakeupRequested = false;
    return true;
  }

  private void executeProducer() {
    try {
      service.execute(produceRowsRunnable);
    } catch (Throwable throwable) {
      synchronized (monitor) {
        setExecutionExceptionLocked(throwable);
        producerRunning = false;
      }
      closeDelegateResultSet();
      scheduleCallbackIfNecessary();
      checkCompletion();
    }
  }

  private void scheduleProducerIfNecessary() {
    boolean shouldExecute;
    synchronized (monitor) {
      shouldExecute = prepareScheduleProducerLocked();
    }
    if (shouldExecute) {
      executeProducer();
    }
  }

  @GuardedBy("monitor")
  private boolean canScheduleCallback() {
    return !initiatingStreaming
        && !cursorReturnedDoneOrException
        && !callbackRunning
        && (state == State.CANCELLED
            || (state == State.RUNNING
                && (!buffer.isEmpty() || finished || executionException != null)));
  }

  private void scheduleCallbackIfNecessary() {
    Executor callbackExecutor = null;
    synchronized (monitor) {
      if (canScheduleCallback()) {
        if (state == State.RUNNING) {
          state = State.CONSUMING;
        }
        callbackRunning = true;
        callbackExecutor = Preconditions.checkNotNull(this.executor);
      }
    }
    if (callbackExecutor != null) {
      try {
        callbackExecutor.execute(callbackRunnable);
      } catch (Throwable throwable) {
        synchronized (monitor) {
          setExecutionExceptionLocked(throwable);
          callbackRunning = false;
          cursorReturnedDoneOrException = true;
        }
        closeDelegateResultSet();
        checkCompletion();
      }
    }
  }

  private void checkCompletion() {
    boolean shouldComplete = false;
    synchronized (monitor) {
      if (!completed
          && cursorReturnedDoneOrException
          && !initiatingStreaming
          && !producerRunning
          && !callbackRunning) {
        if (state != State.CANCELLED) {
          state = State.DONE;
        }
        completed = true;
        shouldComplete = true;
      }
    }
    if (shouldComplete) {
      cleanupAndCompleteResult();
    }
  }

  private void cleanupAndCompleteResult() {
    closeDelegateResultSet();
    maybeNotifyStartOrClose();
    currentRow = null;
    SpannerException finalException;
    SpannerException finalCancelledException;
    State finalState;
    SettableApiFuture<Void> resultFuture;
    List<Runnable> listenersToNotify = Collections.emptyList();
    synchronized (monitor) {
      buffer.clear();
      finalException = executionException;
      finalCancelledException = cancelledException;
      finalState = state;
      resultFuture = Preconditions.checkNotNull(result);
      callback = null;
      executor = null;
      if (!listeners.isEmpty()) {
        listenersToNotify = new ArrayList<>(listeners);
        listeners.clear();
      }
    }
    try {
      for (Runnable listener : listenersToNotify) {
        try {
          listener.run();
        } catch (Throwable throwable) {
          log.log(Level.WARNING, "Listener threw exception", throwable);
        }
      }
      if (executorProvider.shouldAutoClose()) {
        service.shutdown();
      }
    } finally {
      if (finalException != null) {
        resultFuture.setException(finalException);
      } else if (finalState == State.CANCELLED) {
        resultFuture.setException(Preconditions.checkNotNull(finalCancelledException));
      } else {
        resultFuture.set(null);
      }
    }
  }

  /**
   * Initializes the delegate {@link ResultSet} and starts streaming if supported. Note that
   * obtaining the delegate or starting the stream may still block synchronously on future-backed
   * {@link ResultSet} suppliers (such as {@link ResultSets#toAsyncResultSet(ApiFuture,
   * ExecutorProvider, Options.ReadQueryUpdateTransactionOption...)}) or when waiting for an
   * inlined-begin transaction ID on concurrent queries sharing a transaction.
   */
  private class InitiateStreamingRunnable implements Runnable {

    @Override
    public void run() {
      try {
        boolean shouldStop;
        synchronized (monitor) {
          shouldStop = state.shouldStop;
        }
        if (shouldStop) {
          closeDelegateResultSet();
          return;
        }
        // Initiate streaming on the underlying result set if it supports streaming (such as
        // GrpcResultSet). Streaming result sets notify onStreamMessage() as chunks arrive. While
        // initiatingStreaming is true, neither ProduceRowsRunnable nor CallbackRunnable may be
        // dispatched so that delegate access remains strictly single-threaded until
        // initiateStreaming() finishes. If the delegate is non-streaming or already has data or
        // closure ready immediately after initiateStreaming() (for example, if the delegate was
        // closed concurrently before starting an RPC), start producing rows immediately.
        boolean isStreaming = initiateStreaming(AsyncResultSetImpl.this);
        boolean startImmediately = !isStreaming;
        if (!startImmediately) {
          boolean alreadyInitiated;
          synchronized (monitor) {
            alreadyInitiated = produceRowsInitiated || state.shouldStop;
          }
          startImmediately = !alreadyInitiated && isDataAvailable(delegateResultSet.get());
        }
        synchronized (monitor) {
          streamingSupported = isStreaming;
          if (startImmediately) {
            produceRowsInitiated = true;
            if (state == State.STREAMING_INITIALIZED) {
              state = State.RUNNING;
            }
          }
        }
      } catch (Throwable exception) {
        GrpcResultSet grpcDelegate = unwrapGrpcResultSet();
        if (grpcDelegate != null) {
          exception = translateGrpcInitiateStreamingException(grpcDelegate, exception);
        }
        closeDelegateResultSet();
        synchronized (monitor) {
          if (state == State.STREAMING_INITIALIZED) {
            state = State.RUNNING;
          }
          setExecutionExceptionLocked(exception);
        }
      } finally {
        boolean shouldExecuteProducer;
        synchronized (monitor) {
          initiatingStreaming = false;
          shouldExecuteProducer = prepareScheduleProducerLocked();
        }
        if (shouldExecuteProducer) {
          executeProducer();
        }
        scheduleCallbackIfNecessary();
        checkCompletion();
      }
    }
  }

  @Nullable
  private GrpcResultSet unwrapGrpcResultSet() {
    synchronized (monitor) {
      if (!delegateInitialized || delegateClosed || state.shouldStop) {
        return null;
      }
    }
    try {
      ResultSet current = delegateResultSet.get();
      while (current instanceof ForwardingResultSet) {
        current = ((ForwardingResultSet) current).getDelegate();
      }
      return current instanceof GrpcResultSet ? (GrpcResultSet) current : null;
    } catch (Throwable ignored) {
      return null;
    }
  }

  private static Throwable translateGrpcInitiateStreamingException(
      GrpcResultSet grpcDelegate, Throwable exception) {
    try {
      if (grpcDelegate.isDataAvailable()) {
        grpcDelegate.next();
      }
    } catch (Throwable nextException) {
      return nextException;
    }
    return exception;
  }

  /** Sets the callback for this {@link AsyncResultSet}. */
  @Override
  public ApiFuture<Void> setCallback(Executor executor, ReadyCallback callback) {
    Preconditions.checkNotNull(executor, "exec cannot be null");
    Preconditions.checkNotNull(callback, "cb cannot be null");
    SettableApiFuture<Void> resultFuture = SettableApiFuture.create();
    synchronized (monitor) {
      Preconditions.checkState(!closed, "This AsyncResultSet has been closed");
      Preconditions.checkState(
          this.state == State.INITIALIZED, "callback may not be set multiple times");

      // Start to fetch data and buffer these.
      this.result = resultFuture;
      this.executor = MoreExecutors.newSequentialExecutor(executor);
      this.callback = callback;
      this.state = State.STREAMING_INITIALIZED;
      this.initiatingStreaming = true;
    }
    try {
      this.service.execute(new InitiateStreamingRunnable());
    } catch (Throwable throwable) {
      boolean shouldRollback = false;
      synchronized (monitor) {
        if (this.initiatingStreaming) {
          this.initiatingStreaming = false;
          this.cancelledException = null;
          this.state = State.INITIALIZED;
          this.closed = true;
          this.executor = null;
          this.callback = null;
          this.result = null;
          shouldRollback = true;
        }
      }
      if (shouldRollback) {
        closeDelegateResultSet();
        maybeNotifyStartOrClose();
        if (executorProvider.shouldAutoClose()) {
          service.shutdown();
        }
      }
      throw throwable;
    }
    return resultFuture;
  }

  @Nullable Future<Void> getResult() {
    synchronized (monitor) {
      return result;
    }
  }

  @Override
  public void cancel() {
    synchronized (monitor) {
      Preconditions.checkState(
          state != State.INITIALIZED && state != State.SYNC,
          "cannot cancel a result set without a callback");
      if (completed) {
        return;
      }
      if (cancelledException == null) {
        cancelledException =
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.CANCELLED, "This AsyncResultSet has been cancelled");
      }
      if (!cursorReturnedDoneOrException) {
        executionException = null;
      }
      state = State.CANCELLED;
    }
    closeDelegateResultSet();
    scheduleCallbackIfNecessary();
    checkCompletion();
  }

  @Override
  public void resume() {
    boolean shouldResume = false;
    synchronized (monitor) {
      Preconditions.checkState(
          state != State.INITIALIZED && state != State.SYNC,
          "cannot resume a result set without a callback");
      if (state == State.PAUSED) {
        state = State.RUNNING;
        shouldResume = true;
      }
    }
    if (shouldResume) {
      scheduleCallbackIfNecessary();
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
    Preconditions.checkNotNull(transformer, "transformer cannot be null");
    Preconditions.checkNotNull(executor, "executor cannot be null");
    final SettableApiFuture<List<T>> res = SettableApiFuture.create();
    CreateListCallback<T> callback = new CreateListCallback<>(res, transformer);
    ApiFuture<Void> finished = setCallback(executor, callback);
    return ApiFutures.transformAsync(finished, ignored -> res, MoreExecutors.directExecutor());
  }

  @Override
  public <T> List<T> toList(Function<StructReader, T> transformer) throws SpannerException {
    ApiFuture<List<T>> future = toListAsync(transformer, MoreExecutors.directExecutor());
    try {
      return future.get();
    } catch (ExecutionException e) {
      throw SpannerExceptionFactory.asSpannerException(e.getCause());
    } catch (InterruptedException e) {
      cancel();
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }

  @Override
  public boolean next() throws SpannerException {
    synchronized (monitor) {
      Preconditions.checkState(!closed, "This AsyncResultSet has been closed");
      Preconditions.checkState(
          this.state == State.INITIALIZED || this.state == State.SYNC,
          "Cannot call next() on a result set with a callback.");
      this.state = State.SYNC;
    }
    syncHasCurrentRow = false;
    ResultSet delegate = getOrInitializeDelegate();
    boolean hasNext = delegate.next();
    syncHasCurrentRow = hasNext;
    return hasNext;
  }

  /**
   * Returns query execution statistics. Calling this method after the result set has closed is
   * allowed because callers frequently inspect statistics or query plans after consuming all rows
   * and finishing the query.
   */
  @Override
  @Nullable
  public ResultSetStats getStats() {
    return getOrInitializeDelegate().getStats();
  }

  /**
   * Returns query metadata. Calling this method after the result set has closed is allowed so
   * callers can inspect column and type information after consuming all rows. If the result set was
   * closed before execution started, {@link #getOrInitializeDelegate()} ensures the underlying
   * delegate is closed immediately to prevent resource leaks.
   */
  @Override
  public ResultSetMetadata getMetadata() {
    return getOrInitializeDelegate().getMetadata();
  }

  @VisibleForTesting
  boolean initiateStreaming(StreamMessageListener streamMessageListener) {
    return StreamingUtil.initiateStreaming(getOrInitializeDelegate(), streamMessageListener);
  }

  private StructReader getSchemaReader() {
    Struct row = getCurrentCallbackRow();
    if (row != null) {
      return row;
    }
    checkValidStateSlow(/* allowAfterDone= */ true);
    return getOrInitializeDelegate();
  }

  @Override
  public Type getType() {
    return getSchemaReader().getType();
  }

  @Override
  public int getColumnCount() {
    return getSchemaReader().getColumnCount();
  }

  @Override
  public int getColumnIndex(String columnName) {
    return getSchemaReader().getColumnIndex(columnName);
  }

  @Override
  public Type getColumnType(int columnIndex) {
    return getSchemaReader().getColumnType(columnIndex);
  }

  @Override
  @Nullable
  public Type getColumnType(String columnName) {
    return getSchemaReader().getColumnType(columnName);
  }

  private boolean isInCallbackInvocation() {
    return callbackInvocationThread == Thread.currentThread();
  }

  @Nullable
  private Struct getCurrentCallbackRow() {
    return isInCallbackInvocation() ? currentRow : null;
  }

  @Override
  protected void checkValidState() {
    if (getCurrentCallbackRow() != null) {
      return;
    }
    checkValidStateSlow(/* allowAfterDone= */ false);
  }

  private void checkValidStateSlow(boolean allowAfterDone) {
    synchronized (monitor) {
      if (state == State.SYNC) {
        Preconditions.checkState(!closed, "ResultSet is closed");
        return;
      }
      Preconditions.checkState(
          isInCallbackInvocation(),
          "only allowed after a next() call or from within a ReadyCallback#cursorReady callback");
      Preconditions.checkState(
          allowAfterDone && finished && cursorReturnedDoneOrException && state != State.CANCELLED,
          "AsyncResultSet is not positioned on a row");
    }
  }

  @Override
  public Struct getCurrentRowAsStruct() {
    Struct row = getCurrentCallbackRow();
    if (row != null) {
      return row;
    }
    checkValidStateSlow(/* allowAfterDone= */ false);
    Preconditions.checkState(syncHasCurrentRow, "next() call required");
    return getOrInitializeDelegate().getCurrentRowAsStruct();
  }

  @Override
  public void onStreamMessage(PartialResultSet partialResultSet, boolean bufferIsFull) {
    boolean shouldExecuteProducer;
    synchronized (monitor) {
      if (state.shouldStop) {
        return;
      }
      if (!produceRowsInitiated
          && (!partialResultSet.getResumeToken().isEmpty()
              || bufferIsFull
              || partialResultSet == GrpcStreamIterator.END_OF_STREAM
              || ++initialChunksWithoutResumeToken > MAX_BUFFERED_CHUNKS)) {
        produceRowsInitiated = true;
        if (state == State.STREAMING_INITIALIZED) {
          state = State.RUNNING;
        }
      }
      shouldExecuteProducer = prepareScheduleProducerLocked();
    }
    if (shouldExecuteProducer) {
      executeProducer();
    }
  }

  private static final class MemoizingSupplier implements Supplier<ResultSet> {
    private final Object lock = new Object();

    @GuardedBy("lock")
    @Nullable
    private Supplier<ResultSet> delegate;

    private volatile boolean initialized;

    @Nullable private ResultSet value;
    @Nullable private Throwable exception;

    private MemoizingSupplier(Supplier<ResultSet> delegate) {
      this.delegate = delegate;
    }

    @Override
    public ResultSet get() {
      if (!initialized) {
        synchronized (lock) {
          if (!initialized) {
            Supplier<ResultSet> supplier = Preconditions.checkNotNull(delegate);
            delegate = null;
            try {
              value = Preconditions.checkNotNull(supplier.get());
            } catch (Throwable throwable) {
              exception = throwable;
            } finally {
              initialized = true;
            }
          }
        }
      }
      Throwable thrown = exception;
      if (thrown != null) {
        Throwables.throwIfUnchecked(thrown);
        throw SpannerExceptionFactory.asSpannerException(thrown);
      }
      return Preconditions.checkNotNull(value);
    }
  }
}
