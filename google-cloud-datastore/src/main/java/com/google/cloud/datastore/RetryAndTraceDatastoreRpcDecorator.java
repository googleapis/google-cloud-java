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
import static com.google.cloud.datastore.TraceUtil.SPAN_NAME_RUN_AGGREGATION_QUERY;

import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.RetryHelper;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.ReserveIdsRequest;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import io.opencensus.common.Scope;
import io.opencensus.trace.Span;
import io.opencensus.trace.Status;
import java.util.concurrent.Callable;

/**
 * An implementation of {@link DatastoreRpc} which acts as a Decorator and decorates the underlying
 * {@link DatastoreRpc} with the logic of retry and Traceability.
 */
@InternalApi
public class RetryAndTraceDatastoreRpcDecorator implements DatastoreRpc {

  private final DatastoreRpc datastoreRpc;
  private final TraceUtil traceUtil;
  private final RetrySettings retrySettings;
  private final DatastoreOptions datastoreOptions;

  public RetryAndTraceDatastoreRpcDecorator(
      DatastoreRpc datastoreRpc,
      TraceUtil traceUtil,
      RetrySettings retrySettings,
      DatastoreOptions datastoreOptions) {
    this.datastoreRpc = datastoreRpc;
    this.traceUtil = traceUtil;
    this.retrySettings = retrySettings;
    this.datastoreOptions = datastoreOptions;
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
    return invokeRpc(
        () -> datastoreRpc.runAggregationQuery(request), SPAN_NAME_RUN_AGGREGATION_QUERY);
  }

  public <O> O invokeRpc(Callable<O> block, String startSpan) {
    Span span = traceUtil.startSpan(startSpan);
    try (Scope scope = traceUtil.getTracer().withSpan(span)) {
      return RetryHelper.runWithRetries(
          block, this.retrySettings, EXCEPTION_HANDLER, this.datastoreOptions.getClock());
    } catch (RetryHelperException e) {
      span.setStatus(Status.UNKNOWN.withDescription(e.getMessage()));
      throw DatastoreException.translateAndThrow(e);
    } finally {
      span.end(TraceUtil.END_SPAN_OPTIONS);
    }
  }
}
