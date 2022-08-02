/*
 * Copyright 2018 Google LLC
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
import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StateCheckingResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigtable.data.v2.models.Query;

/**
 * Enhancement for `readRowsCallable().first()` to gracefully limit the row count instead of
 * cancelling the RPC
 */
@InternalApi
public class ReadRowsFirstCallable<RowT> extends UnaryCallable<Query, RowT> {

  private final ServerStreamingCallable<Query, RowT> inner;

  public ReadRowsFirstCallable(ServerStreamingCallable<Query, RowT> inner) {
    this.inner = inner;
  }

  @Override
  public ApiFuture<RowT> futureCall(Query query, ApiCallContext context) {
    ReadRowsFirstResponseObserver<RowT> observer = new ReadRowsFirstResponseObserver<>();
    this.inner.call(query.limit(1), observer, context);
    return observer.getFuture();
  }

  private class ReadRowsFirstResponseObserver<RowT> extends StateCheckingResponseObserver<RowT> {
    private StreamController innerController;
    private RowT firstRow;
    private SettableApiFuture<RowT> settableFuture = SettableApiFuture.create();

    @Override
    protected void onStartImpl(StreamController streamController) {
      this.innerController = streamController;
    }

    @Override
    protected void onResponseImpl(RowT response) {
      if (firstRow == null) {
        this.firstRow = response;
      }
    }

    @Override
    protected void onErrorImpl(Throwable throwable) {
      settableFuture.setException(throwable);
    }

    @Override
    protected void onCompleteImpl() {
      settableFuture.set(firstRow);
    }

    protected ApiFuture<RowT> getFuture() {
      return settableFuture;
    }
  }
}
