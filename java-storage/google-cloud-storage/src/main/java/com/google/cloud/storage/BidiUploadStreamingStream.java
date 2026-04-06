/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.base.Preconditions.checkState;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.BaseServiceException;
import com.google.cloud.storage.BidiUploadState.State;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.cloud.storage.RetryContext.OnFailure;
import com.google.cloud.storage.RetryContext.OnSuccess;
import com.google.common.annotations.VisibleForTesting;
import com.google.storage.v2.BidiWriteObjectRedirectedError;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.BidiWriteObjectResponse;
import com.google.storage.v2.ObjectChecksums;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/**
 * A class that helps tie together a {@link BidiUploadState}, {@link RetryContext} and underlying
 * gRPC bidi stream.
 *
 * <p>This class helps transparently handle retries in the event an error is observed, and will
 * handle redirect(s) if they occur, all without the need for the caller of this class to know about
 * those things and the state need to worry about how retries will happen.
 */
final class BidiUploadStreamingStream {

  private final BidiUploadState state;
  private final BidiStreamingCallable<BidiWriteObjectRequest, BidiWriteObjectResponse> write;
  // private final UnaryCallable<GetObjectRequest, Object> get;
  private final ScheduledExecutorService executor;
  private final RetryContext retryContext;
  private final OnSuccess onSuccess;
  private final OnFailure<Throwable> onFailure;
  private final ReentrantLock lock;
  private final int maxRedirectsAllowed;
  private final AtomicInteger redirectCounter;

  private volatile @Nullable StreamTuple stream;
  private volatile @Nullable ApiFuture<Void> pendingReconciliation;

  BidiUploadStreamingStream(
      BidiUploadState state,
      ScheduledExecutorService executor,
      BidiStreamingCallable<BidiWriteObjectRequest, BidiWriteObjectResponse> write,
      int maxRedirectsAllowed,
      RetryContext retryContext) {
    this.state = state;
    this.executor = executor;
    this.write = write;
    this.lock = new ReentrantLock();
    this.retryContext = new StreamRetryContextDecorator(retryContext, lock, this::reset);
    this.onSuccess = this::restart;
    this.onFailure =
        t -> {
          SettableApiFuture<BidiWriteObjectResponse> resultFuture = state.getResultFuture();
          if (!resultFuture.isDone()) {
            this.state.terminalError();
            BaseServiceException coalesced = StorageException.coalesce(t);
            resultFuture.setException(coalesced);
          }
        };
    this.maxRedirectsAllowed = maxRedirectsAllowed;
    this.redirectCounter = new AtomicInteger();
  }

  public ApiFuture<BidiWriteObjectResponse> getResultFuture() {
    return state.getResultFuture();
  }

  public boolean append(ChunkSegmenter.@NonNull ChunkSegment data) {
    lock.lock();
    try {
      boolean offered = state.offer(data);
      if (offered) {
        internalSend();
      }
      return offered;
    } finally {
      lock.unlock();
    }
  }

  public boolean appendAndFlush(ChunkSegmenter.@NonNull ChunkSegment data) {
    lock.lock();
    try {
      boolean offered = state.offer(data);
      if (offered) {
        flush();
      }
      return offered;
    } finally {
      lock.unlock();
    }
  }

  public boolean appendAndFinalize(ChunkSegmenter.@NonNull ChunkSegment data) {
    lock.lock();
    try {
      boolean offered = state.offer(data);
      if (offered) {
        finishWrite(state.getTotalSentBytes());
      }
      return offered;
    } finally {
      lock.unlock();
    }
  }

  public void flush() {
    lock.lock();
    try {
      BidiWriteObjectRequest flush =
          BidiWriteObjectRequest.newBuilder()
              .setWriteOffset(state.getTotalSentBytes())
              .setFlush(true)
              .setStateLookup(true)
              .build();
      // if our flush is already enqueued, simply tick to make sure things are sent
      if (flush.equals(state.peekLast())) {
        internalSend();
        return;
      }
      boolean offered = state.offer(flush);
      if (offered) {
        internalSend();
      }
    } finally {
      lock.unlock();
    }
  }

  public boolean finishWrite(long length) {
    lock.lock();
    try {
      // if we're already finalizing, ack rather than enqueueing again
      if (state.isFinalizing() && state.getTotalSentBytes() == length) {
        return true;
      }

      BidiWriteObjectRequest.Builder b =
          BidiWriteObjectRequest.newBuilder().setWriteOffset(length).setFinishWrite(true);
      Crc32cLengthKnown cumulativeCrc32c = state.getCumulativeCrc32c();
      if (cumulativeCrc32c != null) {
        b.setObjectChecksums(
            ObjectChecksums.newBuilder().setCrc32C(cumulativeCrc32c.getValue()).build());
      }
      BidiWriteObjectRequest msg = b.build();
      boolean offer = state.offer(msg);
      if (offer) {
        internalSend();
      }
      return offer;
    } finally {
      lock.unlock();
    }
  }

  public boolean closeStream(long length) {
    lock.lock();
    try {

      boolean offer = state.finalFlush(length);
      if (offer) {
        internalSend();
      }
      return offer;
    } finally {
      lock.unlock();
    }
  }

  public void sendClose() {
    lock.lock();
    try {
      StreamTuple tmp = getStream();
      if (tmp != null) {
        tmp.closeSend();
      }
    } finally {
      lock.unlock();
    }
  }

  public void awaitTakeoverStateReconciliation() {
    state.awaitTakeoverStateReconciliation(this::restart);
  }

  void awaitAckOf(long writeOffset) throws InterruptedException {
    state.awaitAck(writeOffset);
  }

  /**
   * It is possible for this value to change after reading, however it is guaranteed that the amount
   * of available capacity will only ever increase.
   *
   * <p>The only way this value is impacted by a background thread is if buffer space is released.
   * Buffer consumption can only happen from the same thread that would invoke this method.
   */
  long availableCapacity() {
    return state.availableCapacity();
  }

  /** expected to be called from a background thread provided by {@link #executor}. */
  @VisibleForTesting
  void restart() {
    lock.lock();
    try {
      checkState(stream == null, "attempting to restart stream when stream is already active");
      state.retrying();
      ApiFuture<Void> reconciliation = state.beginReconciliation();
      // read the current volatile value
      ApiFuture<Void> tmpPendingReconciliation = pendingReconciliation;
      StreamTuple tmp = initStreamTuple();
      state.sendVia(tmp);
      // Intentionally using reference equality.
      // Only register the callback if we haven't previously registered it.
      // We want to avoid any error/cancellation on a long-running reconciliation being registered
      // in retry context multiple times.
      // Unfortunately, ApiFuture doesn't provide "isCallbackRegistered" so we need to track this
      // ourselves.
      if (reconciliation != tmpPendingReconciliation) {
        ApiFutures.addCallback(
            reconciliation,
            new ApiFutureCallback<Void>() {
              @Override
              public void onFailure(Throwable t) {
                lock.lock();
                try {
                  BidiUploadStreamingStream.this.pendingReconciliation = null;
                } finally {
                  lock.unlock();
                }
                retryContext.recordError(t, onSuccess, onFailure);
              }

              @Override
              public void onSuccess(Void result) {
                lock.lock();
                try {
                  BidiUploadStreamingStream.this.pendingReconciliation = null;
                } finally {
                  lock.unlock();
                }
                // when the reconciliation completes, trigger sending the rest of the messages
                // that might be in the queue.
                // re-get the stream so that if a retry is in progress we don't attempt to send
                // to a stream that was broken after reconciliation.
                StreamTuple tmp = getStream();
                if (tmp != null) {
                  state.sendVia(tmp);
                }
              }
            },
            executor);
        pendingReconciliation = reconciliation;
      }
      stream = tmp;
    } catch (Throwable t) {
      retryContext.recordError(t, onSuccess, onFailure);
    } finally {
      lock.unlock();
    }
  }

  @VisibleForTesting
  void reset() {
    lock.lock();
    try {
      StreamTuple tmp = stream;
      if (tmp != null) {
        tmp.in.flagTombstoned();
        tmp.closeSend();
        stream = null;
        state.pendingRetry();
      }
    } catch (Throwable t) {
      // if any exception is thrown, catch it and funnel it into retryContext so that it is surfaced
      // to the application.
      retryContext.recordError(t, onSuccess, onFailure);
      // Then throw it to prevent the current thread from running any following steps. Not ideal,
      // but this can execute on a background thread that the application will never see.
      // throw t;
    } finally {
      lock.unlock();
    }
  }

  private @Nullable StreamTuple getStream() {
    if (stream == null && state.getState() == State.INITIALIZING) {
      stream = initStreamTuple();
    }
    return stream;
  }

  private StreamTuple initStreamTuple() {
    GrpcCallContext grpcCallContext = state.enqueueFirstMessageAndGetGrpcCallContext();
    StreamingResponseObserver streamResponseObserver =
        new StreamingResponseObserver(state, retryContext, onSuccess, onFailure);
    RedirectHandlingResponseObserver responseObserver =
        new RedirectHandlingResponseObserver(
            state,
            streamResponseObserver,
            redirectCounter,
            maxRedirectsAllowed,
            this::reset,
            () -> executor.execute(this::restart));
    ClientStream<BidiWriteObjectRequest> clientStream =
        write.splitCall(responseObserver, grpcCallContext);
    GracefulOutboundStream out = new GracefulOutboundStream(clientStream);

    return new StreamTuple(out, responseObserver);
  }

  private void internalSend() {
    StreamTuple tmp = getStream();
    if (tmp != null) {
      state.sendVia(tmp);
    }
  }

  private static final class StreamTuple implements Consumer<BidiWriteObjectRequest> {
    private final ClientStream<BidiWriteObjectRequest> out;
    private final RedirectHandlingResponseObserver in;

    StreamTuple(ClientStream<BidiWriteObjectRequest> out, RedirectHandlingResponseObserver in) {
      this.out = out;
      this.in = in;
    }

    @Override
    public void accept(BidiWriteObjectRequest bidiWriteObjectRequest) {
      out.send(bidiWriteObjectRequest);
    }

    public void closeSend() {
      in.flagTombstoned();
      out.closeSend();
    }
  }

  static final class StreamingResponseObserver
      implements ResponseObserver<BidiWriteObjectResponse> {

    private final BidiUploadState state;
    private final RetryContext retryContext;
    private final OnSuccess onSuccess;
    private final OnFailure<Throwable> onFailure;

    @MonotonicNonNull private StreamController controller;

    StreamingResponseObserver(
        BidiUploadState state,
        RetryContext retryContext,
        OnSuccess onSuccess,
        OnFailure<Throwable> onFailure) {
      this.state = state;
      this.retryContext = retryContext;
      this.onSuccess = onSuccess;
      this.onFailure = onFailure;
    }

    @EnsuresNonNull("controller")
    @Override
    public void onStart(StreamController controller) {
      this.controller = controller;
      controller.disableAutoInboundFlowControl();
      controller.request(1);
    }

    @RequiresNonNull("controller")
    @Override
    public void onResponse(BidiWriteObjectResponse response) {
      try {
        controller.request(1);
        @Nullable StorageException se = state.onResponse(response);
        if (se != null) {
          retryContext.recordError(se, onSuccess, onFailure);
        } else {
          retryContext.reset();
        }
      } catch (Throwable t) {
        // catch an error that might happen while processing and forward it to our retry context
        retryContext.recordError(t, onSuccess, onFailure);
      }
    }

    @Override
    public void onError(Throwable t) {
      retryContext.recordError(t, onSuccess, onFailure);
    }

    @Override
    public void onComplete() {
      // ignore
    }
  }

  static final class RedirectHandlingResponseObserver
      implements ResponseObserver<BidiWriteObjectResponse> {
    private final BidiUploadState state;
    private final ResponseObserver<BidiWriteObjectResponse> delegate;
    private final AtomicInteger redirectCounter;
    private final int maxRedirectsAllowed;
    private final Runnable beforeRedirect;
    private final Runnable onRedirect;

    private volatile boolean tombstoned;

    RedirectHandlingResponseObserver(
        BidiUploadState state,
        ResponseObserver<BidiWriteObjectResponse> delegate,
        AtomicInteger redirectCounter,
        int maxRedirectsAllowed,
        Runnable beforeRedirect,
        Runnable onRedirect) {
      this.state = state;
      this.delegate = delegate;
      this.redirectCounter = redirectCounter;
      this.maxRedirectsAllowed = maxRedirectsAllowed;
      this.beforeRedirect = beforeRedirect;
      this.onRedirect = onRedirect;
      this.tombstoned = false;
    }

    /**
     * mark this observer instance as tombstoned, this will cause it to ignore any invocations of
     * its methods.
     *
     * <p>When we are going to retry a client detected error instead of a server detected one, we
     * want to effectively ignore any following message that might already be inflight from the
     * server.
     */
    void flagTombstoned() {
      tombstoned = true;
    }

    @Override
    public void onStart(StreamController controller) {
      if (tombstoned) {
        return;
      }
      delegate.onStart(controller);
    }

    @Override
    public void onResponse(BidiWriteObjectResponse response) {
      if (tombstoned) {
        return;
      }
      redirectCounter.set(0);
      delegate.onResponse(response);
    }

    @Override
    public void onError(Throwable t) {
      if (tombstoned) {
        return;
      }
      BidiWriteObjectRedirectedError error = GrpcUtils.getBidiWriteObjectRedirectedError(t);
      if (error == null) {
        delegate.onError(t);
        return;
      }
      int redirectCount = redirectCounter.incrementAndGet();
      if (redirectCount > maxRedirectsAllowed) {
        // attach the fact we're ignoring the redirect to the original exception as a suppressed
        // Exception. The lower level handler can then perform its usual handling, but if things
        // bubble all the way up to the invoker we'll be able to see it in a bug report.
        t.addSuppressed(new MaxRedirectsExceededException(maxRedirectsAllowed, redirectCount));
        delegate.onError(t);
        return;
      }
      beforeRedirect.run();
      state.updateFromRedirect(error);
      onRedirect.run();
    }

    @Override
    public void onComplete() {
      if (tombstoned) {
        return;
      }
      delegate.onComplete();
    }
  }

  /**
   * Prevent "already half-closed" if we previously called onComplete but then detect an error and
   * call onError
   */
  private static final class GracefulOutboundStream
      implements ClientStream<BidiWriteObjectRequest> {

    private final ClientStream<BidiWriteObjectRequest> delegate;
    private volatile boolean closing;

    private GracefulOutboundStream(ClientStream<BidiWriteObjectRequest> delegate) {
      this.delegate = delegate;
      this.closing = false;
    }

    @Override
    public boolean isSendReady() {
      return delegate.isSendReady();
    }

    @Override
    public void send(BidiWriteObjectRequest request) {
      delegate.send(request);
    }

    @Override
    public void closeSendWithError(Throwable t) {
      if (closing) {
        return;
      }
      closing = true;
      delegate.closeSendWithError(t);
    }

    @Override
    public void closeSend() {
      if (closing) {
        return;
      }
      closing = true;
      delegate.closeSend();
    }
  }

  /**
   * Decorate a RetryContext to allow observing the invocation of {@link #recordError(Throwable,
   * OnSuccess, OnFailure)}. This allows us to clear out the pending stream before a retry.
   */
  @VisibleForTesting
  static final class StreamRetryContextDecorator implements RetryContext {
    private final RetryContext retryContext;
    private final ReentrantLock lock;
    private final Runnable onRecordError;

    @VisibleForTesting
    StreamRetryContextDecorator(
        RetryContext retryContext, ReentrantLock lock, Runnable onRecordError) {
      this.retryContext = retryContext;
      this.lock = lock;
      this.onRecordError = onRecordError;
    }

    @Override
    public boolean inBackoff() {
      return retryContext.inBackoff();
    }

    @Override
    public void reset() {
      retryContext.reset();
    }

    @Override
    public <T extends Throwable> void recordError(
        T t, OnSuccess onSuccess, OnFailure<T> onFailure) {
      lock.lock();
      try {
        try {
          onRecordError.run();
        } catch (Throwable tt) {
          t.addSuppressed(tt);
          onFailure.onFailure(t);
          return;
        }
        retryContext.recordError(t, onSuccess, onFailure);
      } finally {
        lock.unlock();
      }
    }
  }
}
