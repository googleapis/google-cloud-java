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
import com.google.common.base.Function;
import com.google.spanner.v1.PartialResultSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/** Interface for result sets returned by async query methods. */
public interface AsyncResultSet extends ResultSet {

  /** Response code from {@code tryNext()}. */
  enum CursorState {
    /** Cursor has been moved to a new row. */
    OK,
    /** Read is complete, all rows have been consumed, and there are no more. */
    DONE,
    /** No further information known at this time, thus current row not available. */
    NOT_READY
  }

  /**
   * Non-blocking call that attempts to step the cursor to the next position in the stream. The
   * cursor may be inspected only if the cursor returns {@code CursorState.OK}.
   *
   * <p>A caller will typically call tryNext in a loop inside the ReadyCallback, consuming all
   * results available. For more information see {@link #setCallback(Executor, ReadyCallback)}.
   *
   * <p>Currently this method may only be called if a ReadyCallback has been registered. This is for
   * safety purposes only, and may be relaxed in future.
   *
   * @return current cursor readiness state
   * @throws SpannerException When an unrecoverable problem downstream occurs. Once this occurs you
   *     will get no further callbacks. You should return CallbackResponse.DONE back from callback.
   */
  CursorState tryNext() throws SpannerException;

  enum CallbackResponse {
    /**
     * Tell the cursor to continue issuing callbacks when data is available. This is the standard
     * "I'm ready for more" response. If cursor is not completely drained of all ready results the
     * callback will be called again immediately.
     */
    CONTINUE,

    /**
     * Tell the cursor to suspend all callbacks until application calls {@link
     * ForwardingAsyncResultSet#resume()}.
     */
    PAUSE,

    /**
     * Tell the cursor you are done receiving results, even if there are more results sitting in the
     * buffer. Once you return DONE, you will receive no further callbacks.
     *
     * <p>Approximately equivalent to calling {@link ForwardingAsyncResultSet#cancel()}, and then
     * returning {@code PAUSE}, but more clear, immediate, and idiomatic.
     *
     * <p>It is legal to commit a transaction that owns this read before actually returning {@code
     * DONE}.
     */
    DONE,
  }

  /**
   * Interface for receiving asynchronous callbacks when new data is ready. See {@link
   * AsyncResultSet#setCallback(Executor, ReadyCallback)}.
   */
  interface ReadyCallback {
    CallbackResponse cursorReady(AsyncResultSet resultSet);
  }

  /**
   * Register a callback with the ResultSet to be made aware when more data is available, changing
   * the usage pattern from sync to async. Details:
   *
   * <ul>
   *   <li>The callback will be called at least once.
   *   <li>The callback is run each time more results are available, or when we discover that there
   *       will be no more results. (unless paused, see below). Spurious callbacks are possible, see
   *       below.
   *   <li>Spanner guarantees that one callback is ever outstanding at a time. Also, future
   *       callbacks guarantee the "happens before" property with previous callbacks.
   *   <li>A callback normally consumes all available data in the ResultSet, and then returns {@link
   *       CallbackResponse#CONTINUE}.
   *   <li>If a callback returns {@link CallbackResponse#CONTINUE} with data still in the ResultSet,
   *       the callback is invoked again immediately!
   *   <li>Once a callback has returned {@link CallbackResponse#PAUSE} on the cursor no more
   *       callbacks will be run until a corresponding {@link #resume()}.
   *   <li>Callback will stop being called once any of the following occurs:
   *       <ol>
   *         <li>Callback returns {@link CallbackResponse#DONE}.
   *         <li>{@link ForwardingAsyncResultSet#tryNext()} returns {@link CursorState#DONE}.
   *         <li>{@link ForwardingAsyncResultSet#tryNext()} throws an exception.
   *       </ol>
   *   <li>Callback may possibly be invoked after a call to {@link
   *       ForwardingAsyncResultSet#cancel()} call, but the subsequent call to {@link #tryNext()}
   *       will yield a SpannerException.
   *   <li>Spurious callbacks are possible where cursors are not actually ready. Typically callback
   *       should return {@link CallbackResponse#CONTINUE} any time it sees {@link
   *       CursorState#NOT_READY}.
   * </ul>
   *
   * <h4>Flow Control</h4>
   *
   * If no flow control is needed (say because result sizes are known in advance to be finite in
   * size) then async processing is simple. The following is a code example that transfers work from
   * the cursor to an upstream sink:
   *
   * <pre>{@code
   * @Override
   * public CallbackResponse cursorReady(ResultSet cursor) {
   *   try {
   *     while (true) {
   *       switch (cursor.tryNext()) {
   *         case OK:    upstream.emit(cursor.getRow()); break;
   *         case DONE:  upstream.done(); return CallbackResponse.DONE;
   *         case NOT_READY:  return CallbackResponse.CONTINUE;
   *       }
   *     }
   *   } catch (SpannerException e) {
   *     upstream.doneWithError(e);
   *     return CallbackResponse.DONE;
   *   }
   * }
   * }</pre>
   *
   * Flow control may be needed if for example the upstream system may not always be ready to handle
   * more data. In this case the app developer has two main options:
   *
   * <ul>
   *   <li>Semi-async: make {@code upstream.emit()} a blocking call. This will block the callback
   *       thread until progress is possible. When coding in this way the threads in the Executor
   *       provided to setCallback must be blockable without causing harm to progress in your
   *       system.
   *   <li>Full-async: call {@code cursor.pause()} and return from the callback with data still in
   *       the Cursor. Once in this state cursor waits until resume() is called before calling
   *       callback again.
   * </ul>
   *
   * @param exec executor on which to run all callbacks. Typically use a threadpool. If the executor
   *     is one that runs the work on the submitting thread, you must be very careful not to throw
   *     RuntimeException up the stack, lest you do damage to calling components. For example, it
   *     may cause an event dispatcher thread to crash.
   * @param cb ready callback
   * @return An {@link ApiFuture} that returns <code>null</code> when the consumption of the {@link
   *     AsyncResultSet} has finished successfully. No more calls to the {@link ReadyCallback} will
   *     follow and all resources used by the {@link AsyncResultSet} have been cleaned up. The
   *     {@link ApiFuture} throws an {@link ExecutionException} if the consumption of the {@link
   *     AsyncResultSet} finished with an error.
   */
  ApiFuture<Void> setCallback(Executor exec, ReadyCallback cb);

  /**
   * Attempt to cancel this operation and free all resources. Non-blocking. This is a no-op for
   * child row cursors and does not cancel the parent cursor.
   */
  void cancel();

  /**
   * Resume callbacks from the cursor. If there is more data available, a callback will be
   * dispatched immediately. This can be called from any thread.
   */
  void resume();

  /**
   * Transforms the row cursor into an immutable list using the given transformer function. {@code
   * transformer} will be called once per row, thus the returned list will contain one entry per
   * row. The returned future will throw a {@link SpannerException} if the row cursor encountered
   * any error or if the transformer threw an exception on any row.
   *
   * <p>The transformer will be run on the supplied executor. The implementation may batch multiple
   * transformer invocations together into a single {@code Runnable} when possible to increase
   * efficiency. At any point in time, there will be at most one invocation of the transformer in
   * progress.
   *
   * <p>WARNING: This will result in materializing the entire list so this should be used
   * judiciously after considering the memory requirements of the returned list.
   *
   * <p>WARNING: The {@code RowBase} object passed to transformer function is not immutable and is
   * not guaranteed to remain valid after the transformer function returns. The same {@code RowBase}
   * object might be passed multiple times to the transformer with different underlying data each
   * time. So *NEVER* keep a reference to the {@code RowBase} outside of the transformer.
   * Specifically do not use {@link com.google.common.base.Functions#identity()} function.
   *
   * @param transformer function which will be used to transform the row. It should not return null.
   * @param executor executor on which the transformer will be run. This should ideally not be an
   *     inline executor such as {@code MoreExecutors.directExecutor()}; using such an executor may
   *     degrade the performance of the Spanner library.
   */
  <T> ApiFuture<List<T>> toListAsync(Function<StructReader, T> transformer, Executor executor);

  /**
   * Transforms the row cursor into an immutable list using the given transformer function. {@code
   * transformer} will be called once per row, thus the returned list will contain one entry per
   * row. This method will block until all the rows have been yielded by the cursor.
   *
   * <p>WARNING: This will result in consuming the entire list so this should be used judiciously
   * after considering the memory requirements of the returned list.
   *
   * <p>WARNING: The {@code RowBase} object passed to transformer function is not immutable and is
   * not guaranteed to remain valid after the transformer function returns. The same {@code RowBase}
   * object might be passed multiple times to the transformer with different underlying data each
   * time. So *NEVER* keep a reference to the {@code RowBase} outside of the transformer.
   * Specifically do not use {@link com.google.common.base.Functions#identity()} function.
   *
   * @param transformer function which will be used to transform the row. It should not return null.
   */
  <T> List<T> toList(Function<StructReader, T> transformer) throws SpannerException;

  /**
   * An interface to register the listener for streaming gRPC request. It will be called when a
   * chunk is received from gRPC streaming call.
   */
  interface StreamMessageListener {
    void onStreamMessage(PartialResultSet partialResultSet, boolean bufferIsFull);
  }
}
