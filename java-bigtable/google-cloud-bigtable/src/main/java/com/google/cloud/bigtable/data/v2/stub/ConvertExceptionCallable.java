/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub;

import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.InternalException;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;

/**
 * This callable converts the "Received rst stream" exception into a retryable {@link ApiException}.
 */
final class ConvertExceptionCallable<ReadRowsRequest, RowT>
    extends ServerStreamingCallable<ReadRowsRequest, RowT> {

  private final ServerStreamingCallable<ReadRowsRequest, RowT> innerCallable;

  public ConvertExceptionCallable(ServerStreamingCallable<ReadRowsRequest, RowT> innerCallable) {
    this.innerCallable = innerCallable;
  }

  @Override
  public void call(
      ReadRowsRequest request, ResponseObserver<RowT> responseObserver, ApiCallContext context) {
    ReadRowsConvertExceptionResponseObserver<RowT> observer =
        new ReadRowsConvertExceptionResponseObserver<>(responseObserver);
    innerCallable.call(request, observer, context);
  }

  private class ReadRowsConvertExceptionResponseObserver<RowT> extends SafeResponseObserver<RowT> {

    private final ResponseObserver<RowT> outerObserver;

    ReadRowsConvertExceptionResponseObserver(ResponseObserver<RowT> outerObserver) {
      super(outerObserver);
      this.outerObserver = outerObserver;
    }

    @Override
    protected void onStartImpl(StreamController controller) {
      outerObserver.onStart(controller);
    }

    @Override
    protected void onResponseImpl(RowT response) {
      outerObserver.onResponse(response);
    }

    @Override
    protected void onErrorImpl(Throwable t) {
      outerObserver.onError(convertException(t));
    }

    @Override
    protected void onCompleteImpl() {
      outerObserver.onComplete();
    }
  }

  private Throwable convertException(Throwable t) {
    // Long lived connections sometimes are disconnected via an RST frame. This error is
    // transient and should be retried.
    if (t instanceof InternalException && t.getMessage() != null) {
      String error = t.getMessage().toLowerCase();
      if (error.contains("rst_stream") || error.contains("rst stream")) {
        return new InternalException(t, ((InternalException) t).getStatusCode(), true);
      }
    }
    return t;
  }
}
