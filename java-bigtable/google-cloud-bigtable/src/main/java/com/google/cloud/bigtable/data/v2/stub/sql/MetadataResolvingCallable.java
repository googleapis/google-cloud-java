/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.sql;

import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;
import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.cloud.bigtable.data.v2.internal.ProtoResultSetMetadata;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.cloud.bigtable.data.v2.stub.SafeResponseObserver;

/**
 * Callable that allows passing of {@link ResultSetMetadata} back to users throught the {@link
 * ExecuteQueryCallContext}.
 *
 * <p>This is considered an internal implementation detail and should not be used by applications.
 */
@InternalApi("For internal use only")
public class MetadataResolvingCallable
    extends ServerStreamingCallable<ExecuteQueryCallContext, ExecuteQueryResponse> {
  private final ServerStreamingCallable<ExecuteQueryRequest, ExecuteQueryResponse> inner;

  public MetadataResolvingCallable(
      ServerStreamingCallable<ExecuteQueryRequest, ExecuteQueryResponse> inner) {
    this.inner = inner;
  }

  @Override
  public void call(
      ExecuteQueryCallContext callContext,
      ResponseObserver<ExecuteQueryResponse> responseObserver,
      ApiCallContext apiCallContext) {
    MetadataObserver observer =
        new MetadataObserver(responseObserver, callContext.resultSetMetadataFuture());
    inner.call(callContext.request(), observer, apiCallContext);
  }

  static final class MetadataObserver extends SafeResponseObserver<ExecuteQueryResponse> {

    private final SettableApiFuture<ResultSetMetadata> metadataFuture;
    private final ResponseObserver<ExecuteQueryResponse> outerObserver;
    // This doesn't need to be synchronized because this is called above the reframer
    // so onResponse will be called sequentially
    private boolean isFirstResponse;

    MetadataObserver(
        ResponseObserver<ExecuteQueryResponse> outerObserver,
        SettableApiFuture<ResultSetMetadata> metadataFuture) {
      super(outerObserver);
      this.outerObserver = outerObserver;
      this.metadataFuture = metadataFuture;
      this.isFirstResponse = true;
    }

    @Override
    protected void onStartImpl(StreamController streamController) {
      outerObserver.onStart(streamController);
    }

    @Override
    protected void onResponseImpl(ExecuteQueryResponse response) {
      if (isFirstResponse && !response.hasMetadata()) {
        IllegalStateException e =
            new IllegalStateException("First response must always contain metadata");
        metadataFuture.setException(e);
        throw e;
      }
      isFirstResponse = false;
      if (response.hasMetadata()) {
        try {
          ResultSetMetadata md = ProtoResultSetMetadata.fromProto(response.getMetadata());
          metadataFuture.set(md);
        } catch (Throwable t) {
          metadataFuture.setException(t);
          throw t;
        }
      }
      outerObserver.onResponse(response);
    }

    @Override
    protected void onErrorImpl(Throwable throwable) {
      // When we support retries this will have to move after the retrying callable in a separate
      // observer.
      metadataFuture.setException(throwable);
      outerObserver.onError(throwable);
    }

    @Override
    protected void onCompleteImpl() {
      if (!metadataFuture.isDone()) {
        IllegalStateException missingMetadataException =
            new IllegalStateException("Unexpected Stream complete without receiving metadata");
        metadataFuture.setException(missingMetadataException);
        throw missingMetadataException;
      }
      outerObserver.onComplete();
    }
  }
}
