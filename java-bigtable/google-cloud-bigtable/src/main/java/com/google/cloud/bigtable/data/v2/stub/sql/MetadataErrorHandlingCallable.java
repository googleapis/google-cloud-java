/*
 * Copyright 2025 Google LLC
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
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.bigtable.data.v2.internal.SqlRow;
import com.google.cloud.bigtable.data.v2.stub.SafeResponseObserver;

/**
 * Callable that handles passing execeptions through to the metadata future. This needs to be used
 * after all retries, so that non-retriable errors don't surface as errors to users accessing the
 * metadata.
 *
 * <p>In non-error cases the metadata future is resolved by the {@link PlanRefreshingCallable}
 * because the metadata needs to resolve before the SqlRowMerger starts yielding rows
 *
 * <p>This is considered an internal implementation detail and should not be used by applications.
 */
@InternalApi("For internal use only")
public class MetadataErrorHandlingCallable
    extends ServerStreamingCallable<ExecuteQueryCallContext, SqlRow> {
  private final ServerStreamingCallable<ExecuteQueryCallContext, SqlRow> inner;

  public MetadataErrorHandlingCallable(
      ServerStreamingCallable<ExecuteQueryCallContext, SqlRow> inner) {
    this.inner = inner;
  }

  @Override
  public void call(
      ExecuteQueryCallContext request,
      ResponseObserver<SqlRow> responseObserver,
      ApiCallContext context) {
    MetadataErrorHandlingObserver observer =
        new MetadataErrorHandlingObserver(responseObserver, request);
    inner.call(request, observer, context);
  }

  static final class MetadataErrorHandlingObserver extends SafeResponseObserver<SqlRow> {
    private final ExecuteQueryCallContext callContext;
    private final ResponseObserver<SqlRow> outerObserver;

    MetadataErrorHandlingObserver(
        ResponseObserver<SqlRow> outerObserver, ExecuteQueryCallContext callContext) {
      super(outerObserver);
      this.outerObserver = outerObserver;
      this.callContext = callContext;
    }

    @Override
    protected void onStartImpl(StreamController streamController) {
      outerObserver.onStart(streamController);
    }

    @Override
    protected void onResponseImpl(SqlRow response) {
      outerObserver.onResponse(response);
    }

    @Override
    protected void onErrorImpl(Throwable throwable) {
      callContext.setMetadataException(throwable);
      outerObserver.onError(throwable);
    }

    @Override
    protected void onCompleteImpl() {
      outerObserver.onComplete();
    }
  }
}
