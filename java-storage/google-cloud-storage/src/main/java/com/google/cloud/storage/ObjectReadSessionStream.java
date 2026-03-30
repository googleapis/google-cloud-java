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

package com.google.cloud.storage;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.storage.GrpcUtils.ZeroCopyBidiStreamingCallable;
import com.google.cloud.storage.Hasher.UncheckedChecksumMismatchException;
import com.google.cloud.storage.ObjectReadSessionState.OpenArguments;
import com.google.cloud.storage.ResponseContentLifecycleHandle.ChildRef;
import com.google.cloud.storage.RetryContext.OnSuccess;
import com.google.cloud.storage.StorageDataClient.Borrowable;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import com.google.rpc.Status;
import com.google.storage.v2.BidiReadObjectError;
import com.google.storage.v2.BidiReadObjectRedirectedError;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectResponse;
import com.google.storage.v2.ChecksummedData;
import com.google.storage.v2.ObjectRangeData;
import com.google.storage.v2.ReadRange;
import com.google.storage.v2.ReadRangeError;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import org.checkerframework.checker.nullness.qual.Nullable;

final class ObjectReadSessionStream
    implements ClientStream<BidiReadObjectRequest>, ApiFuture<Void>, IOAutoCloseable, Borrowable {

  private final SettableApiFuture<Void> objectReadSessionResolveFuture;

  private final ObjectReadSessionState state;
  private final ScheduledExecutorService executor;
  private final ZeroCopyBidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse>
      callable;
  private final RetryContext streamRetryContext;
  private final int maxRedirectsAllowed;

  private final AtomicInteger openLeases;
  private volatile MonitoringResponseObserver monitoringResponseObserver;
  private volatile ResponseObserver<BidiReadObjectResponse> responseObserver;
  private volatile ClientStream<BidiReadObjectRequest> requestStream;
  private volatile StreamController controller;
  private final AtomicInteger redirectCounter;

  private ObjectReadSessionStream(
      ObjectReadSessionState state,
      ScheduledExecutorService executor,
      ZeroCopyBidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse> callable,
      int maxRedirectsAllowed,
      RetryContext backoff) {
    this.state = state;
    this.executor = executor;
    this.callable = callable;
    this.streamRetryContext = backoff;
    this.objectReadSessionResolveFuture = SettableApiFuture.create();
    this.maxRedirectsAllowed = maxRedirectsAllowed;
    this.openLeases = new AtomicInteger(1);
    this.redirectCounter = new AtomicInteger();
  }

  // TODO: make this more elegant
  private ClientStream<BidiReadObjectRequest> getRequestStream(@Nullable GrpcCallContext context) {
    if (requestStream != null) {
      return requestStream;
    } else {
      synchronized (this) {
        if (requestStream == null) {
          monitoringResponseObserver =
              new MonitoringResponseObserver(new BidiReadObjectResponseObserver());
          responseObserver =
              GrpcUtils.decorateAsStateChecking(
                  new RedirectHandlingResponseObserver(monitoringResponseObserver));
          requestStream = callable.splitCall(responseObserver, context);
        }
        return requestStream;
      }
    }
  }

  @Override
  public void close() {
    ApiFuture<Void> closeAsync = closeAsync();
    ApiFutureUtils.await(closeAsync);
  }

  public ApiFuture<Void> closeAsync() {
    if (!isOpen()) {
      return ApiFutures.immediateFuture(null);
    }
    int updatedLeaseCount = openLeases.decrementAndGet();
    if (updatedLeaseCount == 0) {
      AsyncSessionClosedException cause = new AsyncSessionClosedException("Session already closed");
      ApiFuture<?> f = failAll(() -> new StorageException(0, "Parent stream shutdown", cause));
      return ApiFutures.transformAsync(f, ignore -> ApiFutures.immediateFuture(null), executor);
    } else {
      return ApiFutures.immediateFuture(null);
    }
  }

  private void cleanUp() {
    cancel(true);
    if (requestStream != null) {
      requestStream.closeSend();
      ApiFutureUtils.await(monitoringResponseObserver.closeSignal);
      requestStream = null;
    }
  }

  @Override
  public void send(BidiReadObjectRequest request) {
    checkOpen();
    if (requestStream == null) {
      OpenArguments openArguments = state.getOpenArguments();
      BidiReadObjectRequest merged =
          openArguments.getReq().toBuilder().clearReadRanges().mergeFrom(request).build();
      getRequestStream(openArguments.getCtx()).send(merged);
    } else {
      getRequestStream(null).send(request);
    }
  }

  @Override
  public void closeSendWithError(Throwable t) {
    checkOpen();
    getRequestStream(null).closeSendWithError(t);
  }

  @Override
  public void closeSend() {
    checkOpen();
    getRequestStream(null).closeSend();
  }

  @Override
  public boolean isSendReady() {
    checkOpen();
    return getRequestStream(null).isSendReady();
  }

  @Override
  public void addListener(Runnable listener, Executor executor) {
    objectReadSessionResolveFuture.addListener(listener, executor);
  }

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    return objectReadSessionResolveFuture.cancel(mayInterruptIfRunning);
  }

  @Override
  public Void get() throws InterruptedException, ExecutionException {
    return objectReadSessionResolveFuture.get();
  }

  @Override
  public Void get(long timeout, TimeUnit unit)
      throws InterruptedException, ExecutionException, TimeoutException {
    return objectReadSessionResolveFuture.get(timeout, unit);
  }

  @Override
  public boolean isCancelled() {
    return objectReadSessionResolveFuture.isCancelled();
  }

  @Override
  public boolean isDone() {
    return objectReadSessionResolveFuture.isDone();
  }

  boolean isOpen() {
    return openLeases.get() > 0;
  }

  public void borrow() {
    checkOpen();
    openLeases.incrementAndGet();
  }

  private void checkOpen() {
    Preconditions.checkState(isOpen(), "Stream closed");
  }

  @VisibleForTesting
  void restart() {
    Preconditions.checkState(
        requestStream == null, "attempting to restart stream when stream is already active");

    OpenArguments openArguments = state.getOpenArguments();
    BidiReadObjectRequest req = openArguments.getReq();
    if (!req.getReadRangesList().isEmpty() || !objectReadSessionResolveFuture.isDone()) {
      ClientStream<BidiReadObjectRequest> requestStream1 = getRequestStream(openArguments.getCtx());
      requestStream1.send(req);
    }
  }

  private void failAll(Throwable terminalFailure) {
    openLeases.set(0);
    try {
      objectReadSessionResolveFuture.setException(terminalFailure);
      state.failAll(executor, () -> terminalFailure);
    } finally {
      cleanUp();
    }
  }

  private ApiFuture<?> failAll(Supplier<Throwable> terminalFailure) {
    openLeases.set(0);
    try {
      objectReadSessionResolveFuture.setException(terminalFailure.get());
      return state.failAll(executor, terminalFailure);
    } finally {
      cleanUp();
    }
  }

  private final class BidiReadObjectResponseObserver
      implements ResponseObserver<BidiReadObjectResponse> {

    private BidiReadObjectResponseObserver() {}

    @Override
    public void onStart(StreamController controller) {
      ObjectReadSessionStream.this.controller = controller;
      controller.disableAutoInboundFlowControl();
      controller.request(1);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void onResponse(BidiReadObjectResponse response) {
      controller.request(1);
      try (ResponseContentLifecycleHandle<BidiReadObjectResponse> handle =
          callable.getResponseContentLifecycleManager().get(response)) {
        if (response.hasMetadata()) {
          state.setMetadata(response.getMetadata());
        }
        if (response.hasReadHandle()) {
          state.setBidiReadHandle(response.getReadHandle());
        }
        List<ObjectRangeData> rangeData = response.getObjectDataRangesList();
        if (rangeData.isEmpty()) {
          return;
        }
        for (int i = 0; i < rangeData.size(); i++) {
          ObjectRangeData d = rangeData.get(i);
          ReadRange readRange = d.getReadRange();
          long id = readRange.getReadId();
          ObjectReadSessionStreamRead<?> read = state.getOutstandingRead(id);
          if (read == null || !read.acceptingBytes()) {
            continue;
          }
          ChecksummedData checksummedData = d.getChecksummedData();
          ByteString content = checksummedData.getContent();
          int crc32C = checksummedData.getCrc32C();

          try {
            // On a Threadripper PRO 3945WX
            // java11+ calculating the crc32c of a 2MiB segment is ~70us
            // java8 the same calculation is ~1600us
            // not something to worry about offloading to another thread at this time.
            read.hasher().validateUnchecked(Crc32cValue.of(crc32C), content);
          } catch (UncheckedChecksumMismatchException e) {
            read.recordError(
                e,
                restartReadFromCurrentOffset(id),
                state.removeOutstandingReadOnFailure(id, read::fail));
            continue;
          }

          final int idx = i;
          long begin = readRange.getReadOffset();
          long position = read.readOffset();
          if (begin == position) {
            ChildRef childRef;
            childRef =
                handle.borrow(r -> r.getObjectDataRanges(idx).getChecksummedData().getContent());
            read.accept(childRef);
          } else if (begin < position) {
            int skip = Math.toIntExact(position - begin);
            ChildRef childRef =
                handle.borrow(
                    r ->
                        r.getObjectDataRanges(idx)
                            .getChecksummedData()
                            .getContent()
                            .substring(skip));
            read.accept(childRef);
            ApiException apiException =
                ApiExceptionFactory.createException(
                    String.format("position = %d, readRange.read_offset = %d", position, begin),
                    null,
                    GrpcStatusCode.of(Code.OUT_OF_RANGE),
                    true);
            read.recordError(
                apiException,
                restartReadFromCurrentOffset(id),
                state.removeOutstandingReadOnFailure(id, read::fail));
            continue;
          } else {
            ApiException apiException =
                ApiExceptionFactory.createException(
                    String.format("position = %d, readRange.read_offset = %d", position, begin),
                    null,
                    GrpcStatusCode.of(Code.OUT_OF_RANGE),
                    true);
            read.recordError(
                apiException,
                restartReadFromCurrentOffset(id),
                state.removeOutstandingReadOnFailure(id, read::fail));
            continue;
          }

          if (d.getRangeEnd()) {
            // invoke eof on exec, the resolving future could have a downstream callback
            // that we don't want to block this grpc thread
            executor.execute(
                StorageException.liftToRunnable(
                    () -> {
                      read.eof();
                      // don't remove the outstanding read until the future has been resolved
                      state.removeOutstandingRead(id);
                    }));
          }
        }
      } catch (IOException e) {
        //
        // When using zero-copy, the returned InputStream is of type InputStream rather than its
        // concrete subclass. The subclass is `io.grpc.internal.ReadableBuffers.BufferInputStream`
        // which exclusively operates on a `io.grpc.internal.ReadableBuffer`. `ReadableBuffer`s
        // close method does not throw.
        //
        // This is defined as an exhaustiveness compliance. {@code javac} dictates we handle an
        // `IOException`, even though the underlying classes won't throw it. If the behavior in grpc
        // at some point does throw, we catch it here and funnel it into the stream retry handling.
        //
        requestStream = null;
        streamRetryContext.recordError(
            e, ObjectReadSessionStream.this::restart, ObjectReadSessionStream.this::failAll);
      }
    }

    @Override
    public void onError(Throwable t) {
      requestStream = null;
      BidiReadObjectError error = GrpcUtils.getBidiReadObjectError(t);
      if (error == null) {
        // if there isn't a BidiReadObjectError that may contain more narrow failures, propagate
        // the failure as is to the stream.
        streamRetryContext.recordError(
            t, ObjectReadSessionStream.this::restart, ObjectReadSessionStream.this::failAll);
        return;
      }

      List<ReadRangeError> rangeErrors = error.getReadRangeErrorsList();
      if (rangeErrors.isEmpty()) {
        // if there aren't any specific read id's that contain errors, propagate the error as is to
        // the stream.
        streamRetryContext.recordError(
            t, ObjectReadSessionStream.this::restart, ObjectReadSessionStream.this::failAll);
        return;
      }
      for (ReadRangeError rangeError : rangeErrors) {
        Status status = rangeError.getStatus();
        long id = rangeError.getReadId();
        ObjectReadSessionStreamRead<?> read = state.getOutstandingRead(id);
        if (read == null) {
          continue;
        }
        // mark read as failed, but don't resolve its future now. Schedule the delivery of the
        // failure in executor to ensure any downstream future doesn't block this IO thread.
        read.preFail();
        executor.execute(
            StorageException.liftToRunnable(
                () ->
                    state
                        .removeOutstandingReadOnFailure(id, read::fail)
                        .onFailure(GrpcUtils.statusToApiException(status))));
      }
      // now that we've failed specific reads, raise a retryable ABORTED error to the stream to
      // cause it to retry and pending remaining reads.
      ApiException apiException =
          ApiExceptionFactory.createException(
              "Stream error, reclassifying as ABORTED for reads not specified in"
                  + " BidiReadObjectError",
              t,
              GrpcStatusCode.of(Code.ABORTED),
              true);
      streamRetryContext.recordError(
          apiException,
          ObjectReadSessionStream.this::restart,
          ObjectReadSessionStream.this::failAll);
    }

    private OnSuccess restartReadFromCurrentOffset(long id) {
      return () -> {
        //noinspection resource
        ObjectReadSessionStreamRead<?> readWithNewId = state.assignNewReadId(id);
        BidiReadObjectRequest requestWithNewReadId =
            BidiReadObjectRequest.newBuilder().addReadRanges(readWithNewId.makeReadRange()).build();
        ObjectReadSessionStream.this.send(requestWithNewReadId);
      };
    }

    @Override
    public void onComplete() {}
  }

  private class MonitoringResponseObserver implements ResponseObserver<BidiReadObjectResponse> {
    private final ResponseObserver<BidiReadObjectResponse> delegate;
    private final SettableApiFuture<Void> openSignal;
    private final SettableApiFuture<Void> closeSignal;

    private MonitoringResponseObserver(ResponseObserver<BidiReadObjectResponse> delegate) {
      this.delegate = delegate;
      this.openSignal = SettableApiFuture.create();
      this.closeSignal = SettableApiFuture.create();
    }

    @Override
    public void onStart(StreamController controller) {
      delegate.onStart(controller);
    }

    @Override
    public void onResponse(BidiReadObjectResponse response) {
      delegate.onResponse(response);
      openSignal.set(null);
      objectReadSessionResolveFuture.set(null);
    }

    @Override
    public void onError(Throwable t) {
      delegate.onError(t);
      openSignal.setException(t);
      closeSignal.setException(t);
    }

    @Override
    public void onComplete() {
      delegate.onComplete();
      if (state.getMetadata() == null) {
        StatusRuntimeException cause =
            Code.UNAVAILABLE
                .toStatus()
                .withDescription("onComplete without prior onNext")
                .asRuntimeException();
        ApiException apiException =
            ApiExceptionFactory.createException(cause, GrpcStatusCode.of(Code.UNAVAILABLE), false);
        StorageException storageException =
            new StorageException(0, cause.getMessage(), apiException);
        streamRetryContext.recordError(
            storageException,
            ObjectReadSessionStream.this::restart,
            objectReadSessionResolveFuture::setException);
      }
      openSignal.set(null);
      closeSignal.set(null);
    }
  }

  private final class RedirectHandlingResponseObserver
      implements ResponseObserver<BidiReadObjectResponse> {
    private final ResponseObserver<BidiReadObjectResponse> delegate;

    private RedirectHandlingResponseObserver(ResponseObserver<BidiReadObjectResponse> delegate) {
      this.delegate = delegate;
    }

    @Override
    public void onStart(StreamController controller) {
      delegate.onStart(controller);
    }

    @Override
    public void onResponse(BidiReadObjectResponse response) {
      redirectCounter.set(0);
      delegate.onResponse(response);
    }

    @Override
    public void onError(Throwable t) {
      BidiReadObjectRedirectedError error = GrpcUtils.getBidiReadObjectRedirectedError(t);
      if (error == null) {
        delegate.onError(t);
        return;
      }
      requestStream = null;
      int redirectCount = redirectCounter.incrementAndGet();
      if (redirectCount > maxRedirectsAllowed) {
        // attach the fact we're ignoring the redirect to the original exception as a suppressed
        // Exception. The lower level handler can then perform its usual handling, but if things
        // bubble all the way up to the invoker we'll be able to see it in a bug report.
        t.addSuppressed(new MaxRedirectsExceededException(maxRedirectsAllowed, redirectCount));
        delegate.onError(t);
        objectReadSessionResolveFuture.setException(t);
        return;
      }
      if (error.hasReadHandle()) {
        state.setBidiReadHandle(error.getReadHandle());
      }
      if (error.hasRoutingToken()) {
        state.setRoutingToken(error.getRoutingToken());
      }
      executor.execute(ObjectReadSessionStream.this::restart);
    }

    @Override
    public void onComplete() {
      delegate.onComplete();
    }
  }

  static ObjectReadSessionStream create(
      ScheduledExecutorService executor,
      ZeroCopyBidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse> callable,
      ObjectReadSessionState state,
      RetryContext retryContext) {

    int maxRedirectsAllowed = 3; // TODO: make this configurable in the ultimate public surface
    return new ObjectReadSessionStream(
        state, executor, callable, maxRedirectsAllowed, retryContext);
  }
}
