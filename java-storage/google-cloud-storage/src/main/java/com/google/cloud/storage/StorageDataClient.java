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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.cloud.storage.GrpcUtils.ZeroCopyBidiStreamingCallable;
import com.google.cloud.storage.ObjectReadSessionState.OpenArguments;
import com.google.cloud.storage.ReadProjectionConfig.ProjectionType;
import com.google.cloud.storage.RetryContext.RetryContextProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@InternalApi
final class StorageDataClient implements AutoCloseable {

  final ScheduledExecutorService executor;
  private final Duration terminationAwaitDuration;
  private final ZeroCopyBidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse>
      bidiReadObject;
  final RetryContextProvider retryContextProvider;
  private final IOAutoCloseable onClose;

  private StorageDataClient(
      ScheduledExecutorService executor,
      Duration terminationAwaitDuration,
      ZeroCopyBidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse> bidiReadObject,
      RetryContextProvider retryContextProvider,
      IOAutoCloseable onClose) {
    this.executor = executor;
    this.terminationAwaitDuration = terminationAwaitDuration;
    this.bidiReadObject = bidiReadObject;
    this.retryContextProvider = retryContextProvider;
    this.onClose = onClose;
  }

  ApiFuture<ObjectReadSession> readSession(BidiReadObjectRequest req, GrpcCallContext ctx) {
    return readSession(req, ctx, ImmutableList.of());
  }

  /**
   * Open a new {@link ObjectReadSession} using fast open: the ranges in {@code fastOpenConfigs} are
   * sent in the same request that opens the session, saving a round trip before the first bytes.
   *
   * <p>The first {@code readAs} with a config equal to one of these is given that fast open read
   * instead of sending a new one.
   *
   * @param fastOpenConfigs the reads to send with the open, for example {@code
   *     ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(0, 1024))}; empty to only
   *     open the session
   */
  ApiFuture<ObjectReadSession> readSession(
      BidiReadObjectRequest req,
      GrpcCallContext ctx,
      List<ReadProjectionConfig<?>> fastOpenConfigs) {
    checkArgument(
        req.getReadRangesList().isEmpty(),
        "ranges included in the initial request are not supported");
    checkArgument(fastOpenConfigs.size() <= 1, "at most one fast open read is supported");
    ObjectReadSessionState state = new ObjectReadSessionState(ctx, req);

    ZeroCopyBidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse> callable =
        getCallable();
    ObjectReadSessionStream stream =
        ObjectReadSessionStream.create(executor, callable, state, retryContextProvider.create());

    // Add each fast open read to the session state. The open request below is built from the
    // state, so these reads are sent as part of the open.
    Map<ReadProjectionConfig<?>, ObjectReadSessionStreamRead<?>> fastOpenReads = new HashMap<>();
    for (ReadProjectionConfig<?> config : fastOpenConfigs) {
      long readId = state.newReadId();
      ObjectReadSessionStreamRead<?> read =
          config.cast().newRead(readId, retryContextProvider.create());
      state.putOutstandingRead(readId, read);
      fastOpenReads.put(config, read);
    }

    ApiFuture<ObjectReadSession> objectReadSessionFuture =
        ApiFutures.transform(
            stream,
            nowOpen ->
                new ObjectReadSessionImpl(
                    executor, callable, stream, state, retryContextProvider, fastOpenReads),
            executor);
    stream.send(state.getOpenArguments().getReq());
    return objectReadSessionFuture;
  }

  <Projection> ApiFuture<FastOpenObjectReadSession<Projection>> fastOpenReadSession(
      BidiReadObjectRequest openRequest,
      GrpcCallContext ctx,
      ReadProjectionConfig<Projection> config) {
    checkArgument(
        openRequest.getReadRangesList().isEmpty(),
        "ranges included in the initial request are not supported");
    checkArgument(
        config.getType() == ProjectionType.STREAM_READ,
        "unsupported ReadProjectionConfig: %s",
        config.getClass().getName());
    ObjectReadSessionState state = new ObjectReadSessionState(ctx, openRequest);

    ZeroCopyBidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse> callable =
        getCallable();
    ObjectReadSessionStream stream =
        ObjectReadSessionStream.create(executor, callable, state, retryContextProvider.create());

    long readId = state.newReadId();
    ObjectReadSessionStreamRead<Projection> read =
        config.cast().newRead(readId, retryContextProvider.create());
    state.putOutstandingRead(readId, read);

    ApiFuture<FastOpenObjectReadSession<Projection>> objectReadSessionFuture =
        ApiFutures.transform(
            stream,
            nowOpen ->
                new FastOpenObjectReadSession<>(
                    new ObjectReadSessionImpl(
                        executor, callable, stream, state, retryContextProvider, ImmutableMap.of()),
                    read,
                    stream),
            executor);
    OpenArguments openArguments = state.getOpenArguments();
    BidiReadObjectRequest req = openArguments.getReq();
    stream.send(req);
    read.setOnCloseCallback(stream);
    return objectReadSessionFuture;
  }

  @SuppressWarnings("ResultOfMethodCallIgnored")
  @Override
  public void close() throws Exception {
    try (IOAutoCloseable ignore = onClose) {
      // today, we own the executor service. If StorageDataClient is ever standalone, this code will
      // need to be re-evaluated. Especially if a customer is able to provide the executor.
      executor.shutdownNow();
      executor.awaitTermination(terminationAwaitDuration.toNanos(), TimeUnit.NANOSECONDS);
    }
  }

  private ZeroCopyBidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse>
      getCallable() {
    return bidiReadObject.withDefaultCallContext(Retrying.newCallContext());
  }

  static StorageDataClient create(
      ScheduledExecutorService executor,
      Duration terminationAwaitDuration,
      ZeroCopyBidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse> read,
      RetryContextProvider retryContextProvider,
      IOAutoCloseable onClose) {
    return new StorageDataClient(
        executor, terminationAwaitDuration, read, retryContextProvider, onClose);
  }

  @FunctionalInterface
  interface Borrowable {
    void borrow();
  }

  static final class FastOpenObjectReadSession<Projection> implements IOAutoCloseable {
    private final ObjectReadSession session;
    private final ObjectReadSessionStreamRead<Projection> read;
    private final Borrowable borrowable;
    private boolean sessionLeased;

    private FastOpenObjectReadSession(
        ObjectReadSession session,
        ObjectReadSessionStreamRead<Projection> read,
        Borrowable borrowable) {
      this.session = session;
      this.read = read;
      this.borrowable = borrowable;
      this.sessionLeased = false;
    }

    ObjectReadSession getSession() {
      if (!sessionLeased) {
        sessionLeased = true;
        borrowable.borrow();
      }
      return session;
    }

    ObjectReadSessionStreamRead<Projection> getRead() {
      return read;
    }

    Projection getProjection() {
      return read.project();
    }

    @Override
    public void close() throws IOException {
      //noinspection EmptyTryBlock
      try (IOAutoCloseable ignore1 = session;
          IOAutoCloseable ignore2 = read) {
        // use try-with to ensure full cleanup
      }
    }

    public static <Projection> FastOpenObjectReadSession<Projection> of(
        ObjectReadSession session,
        ObjectReadSessionStreamRead<Projection> read,
        Borrowable borrowable) {
      return new FastOpenObjectReadSession<>(session, read, borrowable);
    }
  }
}
