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
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.common.util.concurrent.MoreExecutors;
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

    AtomicBoolean cancelled = new AtomicBoolean();
    AtomicReference<ApiFuture<RowT>> futureRef = new AtomicReference<>();

    responseObserver.onStart(
        new StreamController() {
          @Override
          public void cancel() {
            cancelled.set(true);
            ApiFuture<RowT> f = futureRef.get();
            if (f != null) {
              f.cancel(false);
            }
          }

          @Override
          public void disableAutoInboundFlowControl() {}

          @Override
          public void request(int count) {}
        });

    ApiFuture<RowT> future;
    try {
      future = pointReader.futureCall(request, context);
    } catch (Throwable t) {
      if (!cancelled.get()) {
        responseObserver.onError(t);
      }
      return;
    }
    futureRef.set(future);
    if (cancelled.get()) {
      future.cancel(false);
    }

    ApiFutures.addCallback(
        future,
        new ApiFutureCallback<RowT>() {
          @Override
          public void onSuccess(RowT row) {
            if (cancelled.get()) {
              return;
            }
            if (row != null) {
              try {
                responseObserver.onResponse(row);
              } catch (Throwable t) {
                responseObserver.onError(t);
                return;
              }
            }
            responseObserver.onComplete();
          }

          @Override
          public void onFailure(Throwable t) {
            if (cancelled.get()) {
              return;
            }
            responseObserver.onError(t);
          }
        },
        MoreExecutors.directExecutor());
  }
}
