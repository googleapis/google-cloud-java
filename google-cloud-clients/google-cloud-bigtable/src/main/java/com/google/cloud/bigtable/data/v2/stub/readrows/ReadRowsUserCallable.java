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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.Query;

/**
 * Simple wrapper for ReadRows to wrap the request protobufs.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class ReadRowsUserCallable<RowT> extends ServerStreamingCallable<Query, RowT> {
  private final ServerStreamingCallable<ReadRowsRequest, RowT> inner;
  private final RequestContext requestContext;
  private final ReadRowsFirstCallable<RowT> firstCallable;

  public ReadRowsUserCallable(
      ServerStreamingCallable<ReadRowsRequest, RowT> inner, RequestContext requestContext) {
    this.inner = inner;
    this.requestContext = requestContext;

    this.firstCallable = new ReadRowsFirstCallable<>(super.first());
  }

  @Override
  public void call(Query request, ResponseObserver<RowT> responseObserver, ApiCallContext context) {
    ReadRowsRequest innerRequest = request.toProto(requestContext);
    inner.call(innerRequest, responseObserver, context);
  }

  // Optimization: since the server supports row limits, override the first callable.
  // This way unnecessary data doesn't need to be buffered and the number of CANCELLED request
  // statuses is minimized
  @Override
  public UnaryCallable<Query, RowT> first() {
    return firstCallable;
  }
}
