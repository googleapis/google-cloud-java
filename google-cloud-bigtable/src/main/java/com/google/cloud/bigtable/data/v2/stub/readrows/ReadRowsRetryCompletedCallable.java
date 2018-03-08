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

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;
import com.google.bigtable.v2.ReadRowsRequest;

/**
 * This callable addresses edge case of a ReadRows stream receiving all of the rows, but receiving a
 * retryable error status instead of an OK. If a retry attempt is scheduled, then it should return
 * an OK response.
 *
 * <p>This callable works in tandem with {@link ReadRowsResumptionStrategy}, which will send a
 * {@link #FULFILLED_REQUEST_MARKER} to be processed by this callable. Upon receiving the {@link
 * #FULFILLED_REQUEST_MARKER}, this callable will promptly notify the {@link ResponseObserver} that
 * the stream has been successfully compeleted.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public final class ReadRowsRetryCompletedCallable<RowT>
    extends ServerStreamingCallable<ReadRowsRequest, RowT> {
  static final ReadRowsRequest FULFILLED_REQUEST_MARKER =
      ReadRowsRequest.newBuilder().setRowsLimit(-1).build();

  private final ServerStreamingCallable<ReadRowsRequest, RowT> inner;

  public ReadRowsRetryCompletedCallable(ServerStreamingCallable<ReadRowsRequest, RowT> inner) {
    this.inner = inner;
  }

  @Override
  public void call(
      ReadRowsRequest request, ResponseObserver<RowT> responseObserver, ApiCallContext context) {

    if (request == FULFILLED_REQUEST_MARKER) {
      responseObserver.onStart(new DummyController());
      responseObserver.onComplete();
    } else {
      inner.call(request, responseObserver, context);
    }
  }

  private static class DummyController implements StreamController {
    @Override
    public void cancel() {}

    @Override
    public void disableAutoInboundFlowControl() {}

    @Override
    public void request(int count) {}
  }
}
