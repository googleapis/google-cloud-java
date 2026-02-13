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
package com.google.cloud.datastore;

import static com.google.cloud.BaseService.EXCEPTION_HANDLER;

import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.RetryHelper;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.cloud.datastore.telemetry.TraceUtil;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.ReadOptions;
import com.google.datastore.v1.ReserveIdsRequest;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import java.util.concurrent.Callable;

/**
 * An implementation of {@link DatastoreRpc} which acts as a Decorator and decorates the underlying
 * {@link DatastoreRpc} with the logic of retry and Traceability.
 */
@InternalApi
public class RetryAndTraceDatastoreRpcDecorator implements DatastoreRpc {

  private final DatastoreRpc datastoreRpc;
  private final com.google.cloud.datastore.telemetry.TraceUtil otelTraceUtil;
  private final RetrySettings retrySettings;
  private final DatastoreOptions datastoreOptions;

  public RetryAndTraceDatastoreRpcDecorator(
      DatastoreRpc datastoreRpc,
      TraceUtil otelTraceUtil,
      RetrySettings retrySettings,
      DatastoreOptions datastoreOptions) {
    this.datastoreRpc = datastoreRpc;
    this.retrySettings = retrySettings;
    this.datastoreOptions = datastoreOptions;
    this.otelTraceUtil = otelTraceUtil;
  }

  @Override
  public AllocateIdsResponse allocateIds(AllocateIdsRequest request) {
    throw new UnsupportedOperationException("Not implemented.");
  }

  @Override
  public BeginTransactionResponse beginTransaction(BeginTransactionRequest request)
      throws DatastoreException {
    throw new UnsupportedOperationException("Not implemented.");
  }

  @Override
  public CommitResponse commit(CommitRequest request) {
    throw new UnsupportedOperationException("Not implemented.");
  }

  @Override
  public LookupResponse lookup(LookupRequest request) {
    throw new UnsupportedOperationException("Not implemented.");
  }

  @Override
  public ReserveIdsResponse reserveIds(ReserveIdsRequest request) {
    throw new UnsupportedOperationException("Not implemented.");
  }

  @Override
  public RollbackResponse rollback(RollbackRequest request) {
    throw new UnsupportedOperationException("Not implemented.");
  }

  @Override
  public RunQueryResponse runQuery(RunQueryRequest request) {
    throw new UnsupportedOperationException("Not implemented.");
  }

  @Override
  public RunAggregationQueryResponse runAggregationQuery(RunAggregationQueryRequest request) {
    ReadOptions readOptions = request.getReadOptions();
    boolean isTransactional = readOptions.hasTransaction() || readOptions.hasNewTransaction();
    String spanName =
        (isTransactional
            ? com.google.cloud.datastore.telemetry.TraceUtil
                .SPAN_NAME_TRANSACTION_RUN_AGGREGATION_QUERY
            : com.google.cloud.datastore.telemetry.TraceUtil.SPAN_NAME_RUN_AGGREGATION_QUERY);
    return invokeRpc(() -> datastoreRpc.runAggregationQuery(request), spanName);
  }

  @Override
  public void close() throws Exception {
    datastoreRpc.close();
  }

  @Override
  public boolean isClosed() {
    return datastoreRpc.isClosed();
  }

  public <O> O invokeRpc(Callable<O> block, String startSpan) {
    com.google.cloud.datastore.telemetry.TraceUtil.Span span = otelTraceUtil.startSpan(startSpan);
    try (com.google.cloud.datastore.telemetry.TraceUtil.Scope ignored = span.makeCurrent()) {
      return RetryHelper.runWithRetries(
          block, this.retrySettings, EXCEPTION_HANDLER, this.datastoreOptions.getClock());
    } catch (RetryHelperException e) {
      span.end(e);
      throw DatastoreException.translateAndThrow(e);
    } finally {
      span.end();
    }
  }
}
