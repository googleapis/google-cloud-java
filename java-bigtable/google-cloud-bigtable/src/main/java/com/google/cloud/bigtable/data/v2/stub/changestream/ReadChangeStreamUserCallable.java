/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.changestream;

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.bigtable.v2.ReadChangeStreamRequest;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.ReadChangeStreamQuery;

/**
 * A ServerStreamingCallable that converts a {@link ReadChangeStreamQuery} to a {@link
 * ReadChangeStreamRequest}.
 */
@InternalApi("Used in Changestream beam pipeline.")
public class ReadChangeStreamUserCallable<ChangeStreamRecordT>
    extends ServerStreamingCallable<ReadChangeStreamQuery, ChangeStreamRecordT> {
  private final ServerStreamingCallable<ReadChangeStreamRequest, ChangeStreamRecordT> inner;
  private final RequestContext requestContext;

  public ReadChangeStreamUserCallable(
      ServerStreamingCallable<ReadChangeStreamRequest, ChangeStreamRecordT> inner,
      RequestContext requestContext) {
    this.inner = inner;
    this.requestContext = requestContext;
  }

  @Override
  public void call(
      ReadChangeStreamQuery request,
      ResponseObserver<ChangeStreamRecordT> responseObserver,
      ApiCallContext context) {
    ReadChangeStreamRequest innerRequest = request.toProto(requestContext);
    inner.call(innerRequest, responseObserver, context);
  }
}
