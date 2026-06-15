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
import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.cloud.bigtable.data.v2.internal.SqlRow;
import com.google.cloud.bigtable.data.v2.models.sql.BoundStatement;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;

/**
 * Callable that creates {@link SqlServerStream}s from {@link ExecuteQueryRequest}s.
 *
 * <p>This handles setting up the future that is used to allow users to access metadata.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class ExecuteQueryCallable extends ServerStreamingCallable<ExecuteQueryCallContext, SqlRow> {

  private final ServerStreamingCallable<ExecuteQueryCallContext, SqlRow> inner;

  public ExecuteQueryCallable(ServerStreamingCallable<ExecuteQueryCallContext, SqlRow> inner) {
    this.inner = inner;
  }

  /**
   * This should be used to create execute query calls. This replaces the typical API which allows
   * passing of an {@link ApiCallContext}.
   *
   * <p>This class is considered an internal implementation detail and not meant to be used by
   * applications. Users should only use executeQuery through the {@link
   * com.google.cloud.bigtable.data.v2.BigtableDataClient}
   */
  public SqlServerStream call(BoundStatement boundStatement) {
    SettableApiFuture<ResultSetMetadata> metadataFuture = SettableApiFuture.create();
    ServerStream<SqlRow> rowStream =
        this.call(ExecuteQueryCallContext.create(boundStatement, metadataFuture));
    return SqlServerStreamImpl.create(metadataFuture, rowStream);
  }

  @Override
  public void call(
      ExecuteQueryCallContext callContext,
      ResponseObserver<SqlRow> responseObserver,
      ApiCallContext apiCallContext) {
    inner.call(callContext, responseObserver, apiCallContext);
  }
}
