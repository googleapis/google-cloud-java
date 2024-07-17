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
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.cloud.bigtable.data.v2.internal.SqlRow;
import com.google.cloud.bigtable.gaxx.reframing.ReframingResponseObserver;

@InternalApi
public class SqlRowMergingCallable
    extends ServerStreamingCallable<ExecuteQueryCallContext, SqlRow> {
  private final ServerStreamingCallable<ExecuteQueryCallContext, ExecuteQueryResponse> inner;

  public SqlRowMergingCallable(
      ServerStreamingCallable<ExecuteQueryCallContext, ExecuteQueryResponse> inner) {
    this.inner = inner;
  }

  @Override
  public void call(
      ExecuteQueryCallContext callContext,
      ResponseObserver<SqlRow> responseObserver,
      ApiCallContext apiCallContext) {
    SqlRowMerger merger = new SqlRowMerger();
    ReframingResponseObserver<ExecuteQueryResponse, SqlRow> observer =
        new ReframingResponseObserver<>(responseObserver, merger);
    inner.call(callContext, observer, apiCallContext);
  }
}
