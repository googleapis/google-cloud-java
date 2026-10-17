/*
 * Copyright 2024 Google LLC
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

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.cloud.spanner.AbstractResultSet.CloseableIterator;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.spanner.v1.PartialResultSet;
import java.time.Duration;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/** Adapts a streaming read/query call into an iterator over partial result sets. */
@VisibleForTesting
class GrpcStreamIterator extends AbstractIterator<PartialResultSet>
    implements CloseableIterator<PartialResultSet> {

  @VisibleForTesting
  static final class Timeout {
    final long duration;
    final TimeUnit unit;

    Timeout(long duration, TimeUnit unit) {
      this.duration = duration;
      this.unit = Preconditions.checkNotNull(unit);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Timeout)) {
        return false;
      }
      Timeout that = (Timeout) o;
      return this.duration == that.duration && this.unit == that.unit;
    }

    @Override
    public int hashCode() {
      return Objects.hash(duration, unit);
    }

    @Override
    public String toString() {
      return duration + " " + unit;
    }
  }

  private static final Logger logger = Logger.getLogger(GrpcStreamIterator.class.getName());
  static final PartialResultSet END_OF_STREAM = PartialResultSet.newBuilder().build();
  private final int prefetchChunks;
  private AsyncResultSet.StreamMessageListener streamMessageListener;

  private final ConsumerImpl consumer;
  private final BlockingQueue<PartialResultSet> stream;
  private final Statement statement;

  private volatile SpannerRpc.StreamingCall call;
  private boolean callCleared;
  private boolean closed;
  @Nullable private String closeMessage;
  private volatile boolean withBeginTransaction;
  private final boolean lastStatement;
  @Nullable private volatile Timeout streamWaitTimeout;
  @Nullable private volatile SpannerException error;
  private volatile boolean done;

  @VisibleForTesting
  GrpcStreamIterator(
      boolean lastStatement, int prefetchChunks, boolean cancelQueryWhenClientIsClosed) {
    this(null, lastStatement, prefetchChunks, cancelQueryWhenClientIsClosed);
  }

  @VisibleForTesting
  GrpcStreamIterator(
      Statement statement,
      boolean lastStatement,
      int prefetchChunks,
      boolean cancelQueryWhenClientIsClosed) {
    this.statement = statement;
    this.lastStatement = lastStatement;
    this.prefetchChunks = prefetchChunks;
    this.consumer = new ConsumerImpl(cancelQueryWhenClientIsClosed);
    // One extra to allow for END_OF_STREAM message.
    this.stream = new LinkedBlockingQueue<>(prefetchChunks + 1);
  }

  protected final SpannerRpc.ResultStreamConsumer consumer() {
    return consumer;
  }

  void registerListener(AsyncResultSet.StreamMessageListener streamMessageListener) {
    this.streamMessageListener = Preconditions.checkNotNull(streamMessageListener);
  }

  public void setCall(SpannerRpc.StreamingCall call, boolean withBeginTransaction) {
    Timeout timeout = extractTimeout(call);
    boolean shouldCancel;
    String messageToCancel;
    synchronized (this) {
      this.withBeginTransaction = withBeginTransaction;
      shouldCancel = this.closed && !this.callCleared;
      if (!this.callCleared && !this.closed) {
        this.call = call;
      }
      if (timeout != null) {
        this.streamWaitTimeout = timeout;
      }
      messageToCancel = this.closeMessage;
    }
    if (shouldCancel) {
      call.cancel(messageToCancel);
    }
  }

  @VisibleForTesting
  @Nullable
  static Timeout extractTimeout(SpannerRpc.StreamingCall call) {
    ApiCallContext callContext = call.getCallContext();
    Duration streamWaitTimeout =
        callContext == null ? null : callContext.getStreamWaitTimeoutDuration();
    if (streamWaitTimeout != null) {
      // Determine the timeout unit to use. This reduces the precision to seconds if the timeout
      // value is more than 1 second, which is lower than the precision that would normally be
      // used by the stream watchdog (which uses a precision of 10 seconds by default).
      if (streamWaitTimeout.getSeconds() > 0L) {
        return new Timeout(streamWaitTimeout.getSeconds(), TimeUnit.SECONDS);
      } else if (streamWaitTimeout.getNano() > 0) {
        return new Timeout(streamWaitTimeout.getNano(), TimeUnit.NANOSECONDS);
      }
      // Note that if the stream-wait-timeout is zero, we won't set a timeout at all.
      // That is consistent with ApiCallContext#withStreamWaitTimeout(Duration.ZERO).
    }
    return null;
  }

  @Override
  public void close(@Nullable String message) {
    SpannerRpc.StreamingCall callToCancel = null;
    synchronized (this) {
      if (!closed) {
        closed = true;
        closeMessage = message;
        if (!callCleared) {
          callToCancel = this.call;
          this.call = null;
        }
      }
    }
    if (callToCancel != null) {
      callToCancel.cancel(message);
    }
  }

  @Override
  @InternalApi
  public void requestPrefetchChunks() {
    SpannerRpc.StreamingCall callToRequest = null;
    synchronized (this) {
      if (this.call != null) {
        callToRequest = this.call;
      } else if (!this.closed && !this.callCleared) {
        // This should never happen during normal operation because startStream(...) always
        // initializes the call via setCall(...) before returning the GrpcStreamIterator and
        // calling requestPrefetchChunks(). Reaching this point means requestPrefetchChunks()
        // was invoked before setCall(...).
        throw new IllegalStateException("The StreamingCall object is not initialized");
      }
    }
    if (callToRequest != null) {
      callToRequest.request(prefetchChunks);
    }
  }

  @Override
  public boolean isWithBeginTransaction() {
    return withBeginTransaction;
  }

  @Override
  public boolean isLastStatement() {
    return lastStatement;
  }

  @Override
  protected final PartialResultSet computeNext() {
    PartialResultSet next = takeNextFromStream();
    if (next != END_OF_STREAM) {
      SpannerRpc.StreamingCall currentCall = this.call;
      if (currentCall != null) {
        currentCall.request(1);
      }
      if (next.getLast()) {
        clearCall();
      }
      return next;
    }

    clearCall();
    if (error != null) {
      throw SpannerExceptionFactory.asSpannerException(error);
    }
    endOfData();
    return null;
  }

  private PartialResultSet takeNextFromStream() {
    try {
      Timeout timeout = this.streamWaitTimeout;
      if (timeout != null) {
        PartialResultSet next = stream.poll(timeout.duration, timeout.unit);
        if (next == null) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.DEADLINE_EXCEEDED, "stream wait timeout");
        }
        return next;
      } else {
        return stream.take();
      }
    } catch (InterruptedException e) {
      // Treat interrupt as a request to cancel the read.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }

  private void clearCall() {
    // All done - close() no longer needs to cancel the call.
    synchronized (this) {
      callCleared = true;
      call = null;
    }
  }

  private void addToStream(PartialResultSet results) {
    // We assume that nothing from the user will interrupt gRPC event threads.
    Uninterruptibles.putUninterruptibly(stream, results);
    onStreamMessage(results);
  }

  private class ConsumerImpl implements SpannerRpc.ResultStreamConsumer {
    private final boolean cancelQueryWhenClientIsClosed;

    ConsumerImpl(boolean cancelQueryWhenClientIsClosed) {
      this.cancelQueryWhenClientIsClosed = cancelQueryWhenClientIsClosed;
    }

    @Override
    public void onPartialResultSet(PartialResultSet results) {
      addToStream(results);
      if (results.getLast()) {
        addEndOfStream();
      }
    }

    @Override
    public void onCompleted() {
      addEndOfStream();
    }

    @Override
    public void onError(SpannerException exception) {
      if (statement != null) {
        if (logger.isLoggable(Level.FINEST)) {
          // Include parameter values if logging level is set to FINEST or higher.
          exception.setStatement(statement.toString());
          logger.log(Level.FINEST, "Error executing statement", exception);
        } else {
          exception.setStatement(statement.getSql());
        }
      }
      error = exception;
      addEndOfStream();
    }

    private void addEndOfStream() {
      boolean shouldAddEndOfStream = false;
      synchronized (GrpcStreamIterator.this) {
        if (!done) {
          done = true;
          shouldAddEndOfStream = true;
        }
      }
      if (shouldAddEndOfStream) {
        addToStream(END_OF_STREAM);
      }
    }

    @Override
    public boolean cancelQueryWhenClientIsClosed() {
      return this.cancelQueryWhenClientIsClosed;
    }
  }

  private void onStreamMessage(PartialResultSet partialResultSet) {
    Optional.ofNullable(streamMessageListener)
        .ifPresent(sl -> sl.onStreamMessage(partialResultSet, stream.remainingCapacity() <= 1));
  }
}
