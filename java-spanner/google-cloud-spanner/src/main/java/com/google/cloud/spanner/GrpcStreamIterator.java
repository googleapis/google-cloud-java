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
  private static final Logger logger = Logger.getLogger(GrpcStreamIterator.class.getName());
  static final PartialResultSet END_OF_STREAM = PartialResultSet.newBuilder().build();
  private final int prefetchChunks;
  private volatile AsyncResultSet.StreamMessageListener streamMessageListener;

  private final ConsumerImpl consumer;
  private final BlockingQueue<PartialResultSet> stream;
  private final Statement statement;

  private volatile SpannerRpc.StreamingCall call;
  private volatile boolean callInitialized;
  private volatile boolean withBeginTransaction;
  private final boolean lastStatement;
  private boolean closed;
  private boolean callCleared;
  @Nullable private String closeMessage;
  private TimeUnit streamWaitTimeoutUnit;
  private long streamWaitTimeoutValue;
  private volatile SpannerException error;
  private volatile boolean done;
  private volatile boolean endOfStreamReached;

  @VisibleForTesting
  GrpcStreamIterator(
      boolean lastStatement, int prefetchChunks, boolean cancelQueryWhenClientIsClosed) {
    this(null, lastStatement, prefetchChunks, cancelQueryWhenClientIsClosed, false);
  }

  @VisibleForTesting
  GrpcStreamIterator(
      Statement statement,
      boolean lastStatement,
      int prefetchChunks,
      boolean cancelQueryWhenClientIsClosed) {
    this(statement, lastStatement, prefetchChunks, cancelQueryWhenClientIsClosed, false);
  }

  @VisibleForTesting
  GrpcStreamIterator(
      Statement statement,
      boolean lastStatement,
      int prefetchChunks,
      boolean cancelQueryWhenClientIsClosed,
      boolean withBeginTransaction) {
    this.statement = statement;
    this.lastStatement = lastStatement;
    this.prefetchChunks = prefetchChunks;
    this.withBeginTransaction = withBeginTransaction;
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
    boolean shouldCancel;
    String messageToCancel;
    synchronized (this) {
      this.withBeginTransaction = withBeginTransaction;
      if (!this.callCleared) {
        this.call = call;
      }
      this.callInitialized = true;
      ApiCallContext callContext = call.getCallContext();
      Duration streamWaitTimeout =
          callContext == null ? null : callContext.getStreamWaitTimeoutDuration();
      if (streamWaitTimeout != null) {
        // Determine the timeout unit to use. This reduces the precision to seconds if the timeout
        // value is more than 1 second, which is lower than the precision that would normally be
        // used by the stream watchdog (which uses a precision of 10 seconds by default).
        if (streamWaitTimeout.getSeconds() > 0L) {
          streamWaitTimeoutValue = streamWaitTimeout.getSeconds();
          streamWaitTimeoutUnit = TimeUnit.SECONDS;
        } else if (streamWaitTimeout.getNano() > 0) {
          streamWaitTimeoutValue = streamWaitTimeout.getNano();
          streamWaitTimeoutUnit = TimeUnit.NANOSECONDS;
        }
        // Note that if the stream-wait-timeout is zero, we won't set a timeout at all.
        // That is consistent with ApiCallContext#withStreamWaitTimeout(Duration.ZERO).
      }
      shouldCancel = this.closed && !this.callCleared;
      messageToCancel = this.closeMessage;
    }
    if (shouldCancel) {
      call.cancel(messageToCancel);
      return;
    }
    PartialResultSet pending = stream.peek();
    if (pending != null) {
      onStreamMessage(pending);
    }
  }

  @Override
  public void close(@Nullable String message) {
    SpannerRpc.StreamingCall callToCancel = null;
    synchronized (this) {
      if (!closed) {
        closed = true;
        closeMessage = message;
        callToCancel = this.call;
      }
    }
    if (callToCancel != null) {
      callToCancel.cancel(message);
    }
  }

  @Override
  @InternalApi
  public void requestPrefetchChunks() {
    Preconditions.checkState(callInitialized, "The StreamingCall object is not initialized");
    SpannerRpc.StreamingCall currentCall = this.call;
    if (currentCall != null) {
      currentCall.request(prefetchChunks);
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
  public boolean isDataAvailable() {
    return canPollWithoutBlocking()
        || ((callInitialized || streamMessageListener == null) && error != null);
  }

  @Override
  public boolean canPollWithoutBlocking() {
    return (callInitialized || streamMessageListener == null)
        && (endOfStreamReached || (!stream.isEmpty() && error == null));
  }

  @Override
  protected final PartialResultSet computeNext() {
    PartialResultSet next;
    try {
      if (streamWaitTimeoutUnit != null) {
        next = stream.poll(streamWaitTimeoutValue, streamWaitTimeoutUnit);
        if (next == null) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.DEADLINE_EXCEEDED, "stream wait timeout");
        }
      } else {
        next = stream.take();
      }
    } catch (InterruptedException e) {
      // Treat interrupt as a request to cancel the read.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
    if (next != END_OF_STREAM) {
      SpannerRpc.StreamingCall currentCall = this.call;
      if (currentCall != null) {
        currentCall.request(1);
      }
      if (next.getLast()) {
        // All done - close() no longer needs to cancel the call.
        synchronized (this) {
          callCleared = true;
          call = null;
        }
      }
      return next;
    }

    // All done - close() no longer needs to cancel the call.
    synchronized (this) {
      callCleared = true;
      call = null;
    }

    if (error != null) {
      throw SpannerExceptionFactory.asSpannerException(error);
    }

    endOfStreamReached = true;
    endOfData();
    return null;
  }

  private void addToStream(PartialResultSet results) {
    // We assume that nothing from the user will interrupt gRPC event threads.
    Uninterruptibles.putUninterruptibly(stream, results);
    if (callInitialized) {
      onStreamMessage(results);
    }
  }

  private class ConsumerImpl implements SpannerRpc.ResultStreamConsumer {
    private final boolean cancelQueryWhenClientIsClosed;

    ConsumerImpl(boolean cancelQueryWhenClientIsClosed) {
      this.cancelQueryWhenClientIsClosed = cancelQueryWhenClientIsClosed;
    }

    @Override
    public void onPartialResultSet(PartialResultSet results) {
      boolean isLast = results.getLast();
      if (isLast) {
        synchronized (GrpcStreamIterator.this) {
          done = true;
        }
      }
      addToStream(results);
      if (isLast) {
        addToStream(END_OF_STREAM);
      }
    }

    @Override
    public void onCompleted() {
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
