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
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.RetryHelper;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.cloud.datastore.telemetry.CompositeDatastoreMetricsRecorder;
import com.google.cloud.datastore.telemetry.DatastoreMetricsRecorder;
import com.google.cloud.datastore.telemetry.TelemetryConstants;
import com.google.cloud.datastore.telemetry.TelemetryUtils;
import com.google.cloud.datastore.telemetry.TraceUtil;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
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
import java.util.ArrayList;
import java.util.concurrent.Callable;
import javax.annotation.Nonnull;

/**
 * An implementation of {@link DatastoreRpc} which acts as a Decorator and decorates the underlying
 * {@link DatastoreRpc} with the logic of retry and Traceability.
 */
@InternalApi
public class RetryAndTraceDatastoreRpcDecorator implements DatastoreRpc {

  private final DatastoreRpc datastoreRpc;
  private final TraceUtil otelTraceUtil;
  private final RetrySettings retrySettings;
  private final DatastoreOptions datastoreOptions;
  private final DatastoreMetricsRecorder metricsRecorder;

  /**
   * This constructor is deprecated.
   *
   * <p>Prefer to create RetryAndTraceDatastoreRpcDecorator via the Builder
   *
   * @deprecated Prefer to create RetryAndTraceDatastoreRpcDecorator via the Builder
   */
  @Deprecated
  public RetryAndTraceDatastoreRpcDecorator(
      DatastoreRpc datastoreRpc,
      TraceUtil otelTraceUtil,
      RetrySettings retrySettings,
      DatastoreOptions datastoreOptions) {
    this.datastoreRpc = datastoreRpc;
    this.retrySettings = retrySettings;
    this.datastoreOptions = datastoreOptions;
    this.otelTraceUtil = otelTraceUtil;
    this.metricsRecorder = new CompositeDatastoreMetricsRecorder(new ArrayList<>());
  }

  private RetryAndTraceDatastoreRpcDecorator(Builder builder) {
    this.datastoreRpc = builder.datastoreRpc;
    this.otelTraceUtil = builder.otelTraceUtil;
    this.retrySettings = builder.retrySettings;
    this.datastoreOptions = builder.datastoreOptions;
    this.metricsRecorder = builder.metricsRecorder;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private DatastoreRpc datastoreRpc;
    private TraceUtil otelTraceUtil;
    private RetrySettings retrySettings;
    private DatastoreOptions datastoreOptions;

    private DatastoreMetricsRecorder metricsRecorder =
        new CompositeDatastoreMetricsRecorder(new ArrayList<>());

    public Builder setDatastoreRpc(DatastoreRpc datastoreRpc) {
      this.datastoreRpc = datastoreRpc;
      return this;
    }

    public Builder setTraceUtil(TraceUtil otelTraceUtil) {
      this.otelTraceUtil = otelTraceUtil;
      return this;
    }

    public Builder setRetrySettings(RetrySettings retrySettings) {
      this.retrySettings = retrySettings;
      return this;
    }

    public Builder setDatastoreOptions(DatastoreOptions datastoreOptions) {
      this.datastoreOptions = datastoreOptions;
      return this;
    }

    @InternalApi
    public Builder setMetricsRecorder(@Nonnull DatastoreMetricsRecorder metricsRecorder) {
      this.metricsRecorder = metricsRecorder;
      return this;
    }

    public RetryAndTraceDatastoreRpcDecorator build() {
      Preconditions.checkNotNull(datastoreRpc, "datastoreRpc is required");
      Preconditions.checkNotNull(otelTraceUtil, "otelTraceUtil is required");
      Preconditions.checkNotNull(retrySettings, "retrySettings is required");
      Preconditions.checkNotNull(datastoreOptions, "datastoreOptions is required");
      Preconditions.checkNotNull(metricsRecorder, "metricsRecorder is required");
      return new RetryAndTraceDatastoreRpcDecorator(this);
    }
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
            ? TraceUtil.SPAN_NAME_TRANSACTION_RUN_AGGREGATION_QUERY
            : TraceUtil.SPAN_NAME_RUN_AGGREGATION_QUERY);
    return invokeRpc(
        () -> datastoreRpc.runAggregationQuery(request),
        spanName,
        TelemetryConstants.METHOD_RUN_AGGREGATION_QUERY);
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
    return invokeRpc(block, startSpan, null);
  }

  <O> O invokeRpc(Callable<O> block, String startSpan, String methodName) {
    TraceUtil.Span span = otelTraceUtil.startSpan(startSpan);
    Stopwatch stopwatch = Stopwatch.createStarted();
    String operationStatus = StatusCode.Code.UNKNOWN.toString();
    try (TraceUtil.Scope ignored = span.makeCurrent()) {
      Callable<O> callable =
          TelemetryUtils.attemptMetricsCallable(
              block, metricsRecorder, methodName, datastoreOptions.getDatabaseId());
      O result =
          RetryHelper.runWithRetries(
              callable, this.retrySettings, EXCEPTION_HANDLER, this.datastoreOptions.getClock());
      operationStatus = StatusCode.Code.OK.toString();
      return result;
    } catch (RetryHelperException e) {
      operationStatus = DatastoreException.extractStatusCode(e);
      span.end(e);
      throw DatastoreException.translateAndThrow(e);
    } finally {
      TelemetryUtils.recordOperationMetrics(
          metricsRecorder,
          stopwatch,
          methodName,
          operationStatus,
          datastoreOptions.getDatabaseId());
      span.end();
    }
  }
}
