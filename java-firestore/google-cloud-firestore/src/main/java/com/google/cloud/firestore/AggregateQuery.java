/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.firestore;

import static com.google.cloud.firestore.pipeline.expressions.Expression.and;
import static com.google.cloud.firestore.telemetry.TelemetryConstants.METHOD_NAME_RUN_AGGREGATION_QUERY;
import static com.google.cloud.firestore.telemetry.TraceUtil.ATTRIBUTE_KEY_ATTEMPT;

import com.google.api.core.ApiFuture;
import com.google.api.core.InternalExtensionOnly;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.pipeline.expressions.AliasedAggregate;
import com.google.cloud.firestore.pipeline.expressions.BooleanExpression;
import com.google.cloud.firestore.telemetry.MetricsUtil.MetricsContext;
import com.google.cloud.firestore.telemetry.TelemetryConstants;
import com.google.cloud.firestore.telemetry.TelemetryConstants.MetricType;
import com.google.cloud.firestore.telemetry.TraceUtil;
import com.google.cloud.firestore.telemetry.TraceUtil.Scope;
import com.google.cloud.firestore.v1.FirestoreSettings;
import com.google.common.collect.ImmutableMap;
import com.google.firestore.v1.RunAggregationQueryRequest;
import com.google.firestore.v1.RunAggregationQueryResponse;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.StructuredAggregationQuery;
import com.google.firestore.v1.StructuredAggregationQuery.Aggregation;
import com.google.firestore.v1.StructuredQuery;
import com.google.firestore.v1.Value;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** A query that calculates aggregations over an underlying query. */
@InternalExtensionOnly
public class AggregateQuery {
  @Nonnull private final Query query;

  @Nonnull private final List<AggregateField> aggregateFieldList;

  @Nonnull private final Map<String, String> aliasMap;

  AggregateQuery(@Nonnull Query query, @Nonnull List<AggregateField> aggregateFields) {
    this.query = query;
    this.aggregateFieldList = aggregateFields;
    this.aliasMap = new HashMap<>();
  }

  @Nonnull
  private TraceUtil getTraceUtil() {
    return query.getFirestore().getOptions().getTraceUtil();
  }

  @Nonnull
  private MetricsContext createMetricsContext(String method) {
    return query.getFirestore().getOptions().getMetricsUtil().createMetricsContext(method);
  }

  /** Returns the query whose aggregations will be calculated by this object. */
  @Nonnull
  public Query getQuery() {
    return query;
  }

  Pipeline pipeline() {
    Pipeline pipeline = getQuery().pipeline();

    List<BooleanExpression> existsExprs =
        this.aggregateFieldList.stream()
            .map(PipelineUtils::toPipelineExistsExpr)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    if (existsExprs.size() == 1) {
      pipeline = pipeline.where(existsExprs.get(0));
    } else if (existsExprs.size() > 1) {
      pipeline =
          pipeline.where(
              and(
                  existsExprs.get(0),
                  existsExprs.subList(1, existsExprs.size()).toArray(new BooleanExpression[0])));
    }

    return pipeline.aggregate(
        this.aggregateFieldList.stream()
            .map(PipelineUtils::toPipelineAggregatorTarget)
            .toArray(AliasedAggregate[]::new));
  }

  /**
   * Executes this query.
   *
   * @return An {@link ApiFuture} that will be resolved with the results of the query.
   */
  @Nonnull
  public ApiFuture<AggregateQuerySnapshot> get() {
    return get(null, null);
  }

  /**
   * Plans and optionally executes this query. Returns an ApiFuture that will be resolved with the
   * planner information, statistics from the query execution (if any), and the query results (if
   * any).
   *
   * @return An ApiFuture that will be resolved with the planner information, statistics from the
   *     query execution (if any), and the query results (if any).
   */
  @Nonnull
  public ApiFuture<ExplainResults<AggregateQuerySnapshot>> explain(ExplainOptions options) {
    TraceUtil.Span span =
        getTraceUtil().startSpan(TelemetryConstants.METHOD_NAME_AGGREGATION_QUERY_GET);

    MetricsContext metricsContext =
        createMetricsContext(TelemetryConstants.METHOD_NAME_RUN_AGGREGATION_QUERY_EXPLAIN);

    try (Scope ignored = span.makeCurrent()) {
      AggregateQueryExplainResponseDeliverer responseDeliverer =
          new AggregateQueryExplainResponseDeliverer(
              /* transactionId= */ null,
              /* readTime= */ null,
              /* startTimeNanos= */ query.rpcContext.getClock().nanoTime(),
              /* explainOptions= */ options,
              metricsContext);
      runQuery(responseDeliverer, /* attempt */ 0);
      ApiFuture<ExplainResults<AggregateQuerySnapshot>> result = responseDeliverer.getFuture();
      span.endAtFuture(result);
      return result;
    } catch (Exception error) {
      span.end(error);
      throw error;
    }
  }

  @Nonnull
  ApiFuture<AggregateQuerySnapshot> get(
      @Nullable final ByteString transactionId, @Nullable com.google.protobuf.Timestamp readTime) {
    TraceUtil.Span span =
        getTraceUtil()
            .startSpan(
                transactionId == null
                    ? TelemetryConstants.METHOD_NAME_AGGREGATION_QUERY_GET
                    : TelemetryConstants.METHOD_NAME_TRANSACTION_GET_AGGREGATION_QUERY);

    MetricsContext metricsContext =
        createMetricsContext(
            transactionId == null
                ? TelemetryConstants.METHOD_NAME_RUN_AGGREGATION_QUERY_GET
                : TelemetryConstants.METHOD_NAME_RUN_AGGREGATION_QUERY_TRANSACTIONAL);

    try (Scope ignored = span.makeCurrent()) {
      AggregateQueryResponseDeliverer responseDeliverer =
          new AggregateQueryResponseDeliverer(
              transactionId,
              readTime,
              /* startTimeNanos= */ query.rpcContext.getClock().nanoTime(),
              metricsContext);
      runQuery(responseDeliverer, /* attempt= */ 0);
      ApiFuture<AggregateQuerySnapshot> result = responseDeliverer.getFuture();
      span.endAtFuture(result);
      return result;
    } catch (Exception error) {
      span.end(error);
      throw error;
    }
  }

  private <T> void runQuery(ResponseDeliverer<T> responseDeliverer, int attempt) {
    RunAggregationQueryRequest request =
        toProto(
            responseDeliverer.getTransactionId(),
            responseDeliverer.getReadTime(),
            responseDeliverer.getExplainOptions());
    AggregateQueryResponseObserver<T> responseObserver =
        new AggregateQueryResponseObserver<T>(responseDeliverer, attempt);
    ServerStreamingCallable<RunAggregationQueryRequest, RunAggregationQueryResponse> callable =
        query.rpcContext.getClient().runAggregationQueryCallable();
    query.rpcContext.streamRequest(request, responseObserver, callable);
  }

  @Nonnull
  private Map<String, Value> convertServerAggregateFieldsMapToClientAggregateFieldsMap(
      @Nonnull Map<String, Value> data) {
    ImmutableMap.Builder<String, Value> builder = ImmutableMap.builder();
    data.forEach((serverAlias, value) -> builder.put(aliasMap.get(serverAlias), value));
    return builder.build();
  }

  private abstract static class ResponseDeliverer<T> {
    private final @Nullable ByteString transactionId;
    private final @Nullable com.google.protobuf.Timestamp readTime;
    private final long startTimeNanos;
    private final SettableApiFuture<T> future = SettableApiFuture.create();
    private MetricsContext metricsContext;

    ResponseDeliverer(
        @Nullable ByteString transactionId,
        @Nullable com.google.protobuf.Timestamp readTime,
        long startTimeNanos,
        MetricsContext metricsContext) {
      this.transactionId = transactionId;
      this.readTime = readTime;
      this.startTimeNanos = startTimeNanos;
      this.metricsContext = metricsContext;
    }

    @Nullable
    ByteString getTransactionId() {
      return transactionId;
    }

    @Nullable
    com.google.protobuf.Timestamp getReadTime() {
      return readTime;
    }

    long getStartTimeNanos() {
      return startTimeNanos;
    }

    @Nullable
    ExplainOptions getExplainOptions() {
      return null;
    }

    ApiFuture<T> getFuture() {
      return future;
    }

    void deliverFirstResponse() {
      metricsContext.recordLatency(MetricType.FIRST_RESPONSE_LATENCY);
    }

    void deliverError(Throwable throwable) {
      future.setException(throwable);
      metricsContext.recordLatency(MetricType.END_TO_END_LATENCY, throwable);
    }

    void deliverResult(
        @Nullable Map<String, Value> serverData,
        Timestamp readTime,
        @Nullable ExplainMetrics metrics) {
      try {
        T result = processResult(serverData, readTime, metrics);
        future.set(result);
        metricsContext.recordLatency(MetricType.END_TO_END_LATENCY);
      } catch (Exception error) {
        deliverError(error);
      }
    }

    abstract T processResult(
        @Nullable Map<String, Value> serverData,
        Timestamp readTime,
        @Nullable ExplainMetrics metrics);
  }

  private class AggregateQueryResponseDeliverer extends ResponseDeliverer<AggregateQuerySnapshot> {
    AggregateQueryResponseDeliverer(
        @Nullable ByteString transactionId,
        @Nullable com.google.protobuf.Timestamp readTime,
        long startTimeNanos,
        MetricsContext metricsContext) {
      super(transactionId, readTime, startTimeNanos, metricsContext);
    }

    @Override
    AggregateQuerySnapshot processResult(
        @Nullable Map<String, Value> serverData,
        Timestamp readTime,
        @Nullable ExplainMetrics metrics) {
      if (serverData == null) {
        throw new RuntimeException("Did not receive any aggregate query results.");
      }
      return new AggregateQuerySnapshot(
          AggregateQuery.this,
          readTime,
          convertServerAggregateFieldsMapToClientAggregateFieldsMap(serverData));
    }
  }

  private final class AggregateQueryExplainResponseDeliverer
      extends ResponseDeliverer<ExplainResults<AggregateQuerySnapshot>> {
    private final @Nullable ExplainOptions explainOptions;

    AggregateQueryExplainResponseDeliverer(
        @Nullable ByteString transactionId,
        @Nullable com.google.protobuf.Timestamp readTime,
        long startTimeNanos,
        @Nullable ExplainOptions explainOptions,
        MetricsContext metricsContext) {
      super(transactionId, readTime, startTimeNanos, metricsContext);
      this.explainOptions = explainOptions;
    }

    @Override
    @Nullable
    ExplainOptions getExplainOptions() {
      return explainOptions;
    }

    @Override
    ExplainResults<AggregateQuerySnapshot> processResult(
        @Nullable Map<String, Value> serverData,
        Timestamp readTime,
        @Nullable ExplainMetrics metrics) {
      // The server is required to provide ExplainMetrics for explain queries.
      if (metrics == null) {
        throw new RuntimeException("Did not receive any metrics for explain query.");
      }
      AggregateQuerySnapshot snapshot =
          serverData == null
              ? null
              : new AggregateQuerySnapshot(
                  AggregateQuery.this,
                  readTime,
                  convertServerAggregateFieldsMapToClientAggregateFieldsMap(serverData));
      return new ExplainResults<>(metrics, snapshot);
    }
  }

  private final class AggregateQueryResponseObserver<T>
      implements ResponseObserver<RunAggregationQueryResponse> {
    private final ResponseDeliverer<T> responseDeliverer;
    private Timestamp readTime = Timestamp.MAX_VALUE;
    @Nullable private Map<String, Value> aggregateFieldsMap = null;
    @Nullable private ExplainMetrics metrics = null;
    private int attempt;
    private boolean firstResponse = false;

    AggregateQueryResponseObserver(ResponseDeliverer<T> responseDeliverer, int attempt) {
      this.responseDeliverer = responseDeliverer;
      this.attempt = attempt;
    }

    Map<String, Object> getAttemptAttributes() {
      return Collections.singletonMap(ATTRIBUTE_KEY_ATTEMPT, attempt);
    }

    private boolean isExplainQuery() {
      return this.responseDeliverer.getExplainOptions() != null;
    }

    @Override
    public void onStart(StreamController streamController) {
      getTraceUtil()
          .currentSpan()
          .addEvent(METHOD_NAME_RUN_AGGREGATION_QUERY + " Stream started.", getAttemptAttributes());
    }

    @Override
    public void onResponse(RunAggregationQueryResponse response) {
      if (!firstResponse) {
        firstResponse = true;
        responseDeliverer.deliverFirstResponse();
      }

      getTraceUtil()
          .currentSpan()
          .addEvent(
              METHOD_NAME_RUN_AGGREGATION_QUERY + " Response Received.", getAttemptAttributes());
      if (response.hasReadTime()) {
        readTime = Timestamp.fromProto(response.getReadTime());
      }

      if (response.hasResult()) {
        aggregateFieldsMap = response.getResult().getAggregateFieldsMap();
      }

      if (response.hasExplainMetrics()) {
        metrics = new ExplainMetrics(response.getExplainMetrics());
      }

      if (!isExplainQuery()) {
        // Deliver the result; even though the `RunAggregationQuery` RPC is a "streaming" RPC,
        // meaning that `onResponse()` can be called multiple times, it _should_ only be called
        // once for non-explain queries. But even if it is called more than once,
        // `responseDeliverer` will drop superfluous results. For explain queries, there will
        // be more than one response, and the last response will contain the metrics.
        onComplete();
      }
    }

    @Override
    public void onError(Throwable throwable) {
      if (shouldRetry(throwable)) {
        getTraceUtil()
            .currentSpan()
            .addEvent(
                METHOD_NAME_RUN_AGGREGATION_QUERY + ": Retryable Error",
                Collections.singletonMap("error.message", throwable.toString()));

        runQuery(responseDeliverer, attempt + 1);
      } else {
        getTraceUtil()
            .currentSpan()
            .addEvent(
                METHOD_NAME_RUN_AGGREGATION_QUERY + ": Error",
                Collections.singletonMap("error.message", throwable.toString()));
        responseDeliverer.deliverError(throwable);
      }
    }

    private boolean shouldRetry(Throwable throwable) {
      // Do not retry EXPLAIN requests because it'd be executing
      // multiple queries. This means stats would have to be aggregated,
      // and that may not even make sense for many statistics.
      if (isExplainQuery()) {
        return false;
      }

      Set<StatusCode.Code> retryableCodes =
          FirestoreSettings.newBuilder().runAggregationQuerySettings().getRetryableCodes();
      return query.shouldRetryQuery(
          throwable,
          responseDeliverer.getTransactionId(),
          responseDeliverer.getStartTimeNanos(),
          retryableCodes);
    }

    @Override
    public void onComplete() {
      responseDeliverer.deliverResult(aggregateFieldsMap, readTime, metrics);
    }
  }

  /**
   * Returns the {@link RunAggregationQueryRequest} that this AggregateQuery instance represents.
   * The request contain the serialized form of all aggregations and Query constraints.
   *
   * @return the serialized RunAggregationQueryRequest
   */
  @Nonnull
  public RunAggregationQueryRequest toProto() {
    return toProto(/* transactionId= */ null, /* readTime= */ null, /* explainOptions= */ null);
  }

  @Nonnull
  RunAggregationQueryRequest toProto(
      @Nullable final ByteString transactionId,
      @Nullable final com.google.protobuf.Timestamp readTime,
      @Nullable ExplainOptions explainOptions) {
    RunQueryRequest runQueryRequest = query.toProto();

    RunAggregationQueryRequest.Builder request = RunAggregationQueryRequest.newBuilder();
    request.setParent(runQueryRequest.getParent());
    if (transactionId != null) {
      request.setTransaction(transactionId);
    }
    if (readTime != null) {
      request.setReadTime(readTime);
    }

    if (explainOptions != null) {
      request.setExplainOptions(explainOptions.toProto());
    }

    StructuredAggregationQuery.Builder structuredAggregationQuery =
        request.getStructuredAggregationQueryBuilder();
    structuredAggregationQuery.setStructuredQuery(runQueryRequest.getStructuredQuery());

    // We use this set to remove duplicate aggregates.
    // For example, `aggregate(sum("foo"), sum("foo"))`
    HashSet<String> uniqueAggregates = new HashSet<>();
    List<StructuredAggregationQuery.Aggregation> aggregations = new ArrayList<>();
    int aggregationNum = 0;
    for (AggregateField aggregateField : aggregateFieldList) {
      // `getAlias()` provides a unique representation of an AggregateField.
      boolean isNewAggregateField = uniqueAggregates.add(aggregateField.getAlias());
      if (!isNewAggregateField) {
        // This is a duplicate AggregateField. We don't need to include it in the request.
        continue;
      }

      // If there's a field for this aggregation, build its proto.
      StructuredQuery.FieldReference field = null;
      if (!aggregateField.getFieldPath().isEmpty()) {
        field =
            StructuredQuery.FieldReference.newBuilder()
                .setFieldPath(aggregateField.getFieldPath())
                .build();
      }
      // Build the aggregation proto.
      Aggregation.Builder aggregation = Aggregation.newBuilder();
      if (aggregateField instanceof AggregateField.CountAggregateField) {
        aggregation.setCount(Aggregation.Count.getDefaultInstance());
      } else if (aggregateField instanceof AggregateField.SumAggregateField) {
        aggregation.setSum(Aggregation.Sum.newBuilder().setField(field).build());
      } else if (aggregateField instanceof AggregateField.AverageAggregateField) {
        aggregation.setAvg(Aggregation.Avg.newBuilder().setField(field).build());
      } else {
        throw new RuntimeException("Unsupported aggregation");
      }
      // Map all client-side aliases to a unique short-form alias.
      // This avoids issues with client-side aliases that exceed the 1500-byte string size limit.
      String serverAlias = "aggregate_" + aggregationNum++;
      aliasMap.put(serverAlias, aggregateField.getAlias());
      aggregation.setAlias(serverAlias);
      aggregations.add(aggregation.build());
    }
    structuredAggregationQuery.addAllAggregations(aggregations);
    return request.build();
  }

  /**
   * Returns an AggregateQuery instance that can be used to execute the provided {@link
   * RunAggregationQueryRequest}.
   *
   * <p>Only RunAggregationQueryRequests that pertain to the same project as the Firestore instance
   * can be deserialized.
   *
   * @param firestore a Firestore instance to apply the query to.
   * @param proto the serialized RunAggregationQueryRequest.
   * @return a AggregateQuery instance that can be used to execute the RunAggregationQueryRequest.
   */
  @Nonnull
  public static AggregateQuery fromProto(Firestore firestore, RunAggregationQueryRequest proto) {
    RunQueryRequest runQueryRequest =
        RunQueryRequest.newBuilder()
            .setParent(proto.getParent())
            .setStructuredQuery(proto.getStructuredAggregationQuery().getStructuredQuery())
            .build();
    Query query = Query.fromProto(firestore, runQueryRequest);

    List<AggregateField> aggregateFields = new ArrayList<>();
    List<Aggregation> aggregations = proto.getStructuredAggregationQuery().getAggregationsList();
    aggregations.forEach(
        aggregation -> {
          if (aggregation.hasCount()) {
            aggregateFields.add(AggregateField.count());
          } else if (aggregation.hasAvg()) {
            aggregateFields.add(
                AggregateField.average(aggregation.getAvg().getField().getFieldPath()));
          } else if (aggregation.hasSum()) {
            aggregateFields.add(AggregateField.sum(aggregation.getSum().getField().getFieldPath()));
          } else {
            throw new RuntimeException("Unsupported aggregation.");
          }
        });
    return new AggregateQuery(query, aggregateFields);
  }

  /**
   * Calculates and returns the hash code for this object.
   *
   * @return the hash code for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(query, aggregateFieldList);
  }

  /**
   * Compares this object with the given object for equality.
   *
   * <p>This object is considered "equal" to the other object if and only if all of the following
   * conditions are satisfied:
   *
   * <ol>
   *   <li>{@code object} is a non-null instance of {@link AggregateQuery}.
   *   <li>{@code object} performs the same aggregations as this {@link AggregateQuery}.
   *   <li>The underlying {@link Query} of {@code object} compares equal to that of this object.
   * </ol>
   *
   * @param object The object to compare to this object for equality.
   * @return {@code true} if this object is "equal" to the given object, as defined above, or {@code
   *     false} otherwise.
   */
  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    } else if (!(object instanceof AggregateQuery)) {
      return false;
    }
    AggregateQuery other = (AggregateQuery) object;
    return query.equals(other.query) && aggregateFieldList.equals(other.aggregateFieldList);
  }
}
