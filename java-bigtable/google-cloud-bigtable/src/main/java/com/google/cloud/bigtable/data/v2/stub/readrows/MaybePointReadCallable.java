/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub.readrows;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Routes ReadRows calls whose query identifies a single row through a unary point-read callable,
 * letting them benefit from the same session-shim diversion as {@code ReadRow}. Queries that cannot
 * be reduced to a point read fall through to the classic {@code ReadRows} callable.
 */
@InternalApi
public class MaybePointReadCallable<RowT> extends ServerStreamingCallable<Query, RowT> {
  private final ServerStreamingCallable<Query, RowT> classic;
  private final UnaryCallable<Query, RowT> pointReader;

  public MaybePointReadCallable(
      ServerStreamingCallable<Query, RowT> classic, UnaryCallable<Query, RowT> pointReader) {
    this.classic = classic;
    this.pointReader = pointReader;
  }

  @Override
  public void call(Query request, ResponseObserver<RowT> responseObserver, ApiCallContext context) {
    if (!request.isSinglePointQuery()) {
      classic.call(request, responseObserver, context);
      return;
    }

    // TODO: move StreamController and callback state to an inner class so hasStarted and
    // autoFlowControl can be plain booleans instead of AtomicBooleans.
    AtomicBoolean hasStarted = new AtomicBoolean();
    AtomicBoolean autoFlowControl = new AtomicBoolean(true);
    AtomicReference<CancellationException> cancellation = new AtomicReference<>();
    SettableApiFuture<Void> demand = SettableApiFuture.create();
    AtomicReference<ApiFuture<RowT>> futureRef = new AtomicReference<>();

    responseObserver.onStart(
        new StreamController() {
          @Override
          public void cancel() {
            if (cancellation.compareAndSet(
                null, new CancellationException("User cancelled stream"))) {
              demand.cancel(false);
              ApiFuture<RowT> f = futureRef.get();
              if (f != null) {
                f.cancel(false);
              }
            }
          }

          @Override
          public void disableAutoInboundFlowControl() {
            Preconditions.checkState(
                !hasStarted.get(),
                "Can't disable automatic flow control after the stream has started.");
            autoFlowControl.set(false);
          }

          @Override
          public void request(int count) {
            Preconditions.checkState(!autoFlowControl.get(), "Automatic flow control is enabled.");
            Preconditions.checkArgument(count > 0, "Count must be > 0");
            demand.set(null);
          }
        });

    hasStarted.set(true);
    if (autoFlowControl.get()) {
      demand.set(null);
    }

    // Start the underlying RPC eagerly on the caller thread (rather than waiting for demand) to:
    // 1. Preserve the caller thread's ambient io.grpc.Context (deadlines, trace spans).
    // 2. Match GAX/gRPC inbound flow-control semantics, where the request is sent immediately,
    //    RPC errors surface even when demand is 0, and request(n) only gates inbound row delivery.
    // Chaining via transformAsync also lets future.cancel(false) propagate cancellation to both the
    // in-flight RPC future and the demand future.
    ApiFuture<RowT> future;
    try {
      future =
          ApiFutures.transformAsync(
              pointReader.futureCall(request, context),
              row ->
                  row == null
                      ? ApiFutures.immediateFuture(null)
                      : ApiFutures.transform(demand, unused -> row, MoreExecutors.directExecutor()),
              MoreExecutors.directExecutor());
    } catch (Throwable t) {
      responseObserver.onError(MoreObjects.firstNonNull(cancellation.get(), t));
      return;
    }
    futureRef.set(future);
    if (cancellation.get() != null) {
      future.cancel(false);
    }

    ApiFutures.addCallback(
        future,
        new ApiFutureCallback<RowT>() {
          @Override
          public void onSuccess(RowT row) {
            CancellationException e = cancellation.get();
            if (e != null) {
              responseObserver.onError(e);
              return;
            }
            if (row != null) {
              try {
                responseObserver.onResponse(row);
              } catch (Throwable t) {
                responseObserver.onError(t);
                return;
              }
              e = cancellation.get();
              if (e != null) {
                responseObserver.onError(e);
                return;
              }
            }
            responseObserver.onComplete();
          }

          @Override
          public void onFailure(Throwable t) {
            responseObserver.onError(MoreObjects.firstNonNull(cancellation.get(), t));
          }
        },
        MoreExecutors.directExecutor());
  }
}
