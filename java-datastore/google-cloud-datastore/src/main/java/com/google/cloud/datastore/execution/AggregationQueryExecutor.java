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
package com.google.cloud.datastore.execution;

import com.google.api.core.InternalApi;
import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResults;
import com.google.cloud.datastore.DatastoreExecutionOptions;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.ReadOption;
import com.google.cloud.datastore.ReadOption.QueryConfig;
import com.google.cloud.datastore.execution.request.AggregationQueryRequestProtoPreparer;
import com.google.cloud.datastore.execution.response.AggregationQueryResponseTransformer;
import com.google.cloud.datastore.models.ExplainOptions;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.datastore.v1.RequestOptions;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * An implementation of {@link QueryExecutor} which executes {@link AggregationQuery} and returns
 * {@link AggregationResults}.
 */
@InternalApi
public class AggregationQueryExecutor
    implements QueryExecutor<AggregationQuery, AggregationResults> {

  private final DatastoreRpc datastoreRpc;
  private final AggregationQueryRequestProtoPreparer protoPreparer;
  private final AggregationQueryResponseTransformer responseTransformer;

  public AggregationQueryExecutor(DatastoreRpc datastoreRpc, DatastoreOptions datastoreOptions) {
    this.datastoreRpc = datastoreRpc;
    this.protoPreparer = new AggregationQueryRequestProtoPreparer(datastoreOptions);
    this.responseTransformer = new AggregationQueryResponseTransformer();
  }

  @Override
  public AggregationResults execute(
      AggregationQuery query, ExplainOptions explainOptions, ReadOption... readOptions) {
    return execute(
        query,
        DatastoreExecutionOptions.newBuilder()
            .setExplainOptions(explainOptions)
            .setReadOptions(readOptions != null ? Arrays.asList(readOptions) : Collections.emptyList())
            .build());
  }

  public AggregationResults execute(
      AggregationQuery query, DatastoreExecutionOptions executionOptions) {
    RunAggregationQueryRequest runAggregationQueryRequest =
        getRunAggregationQueryRequest(query, executionOptions);
    RunAggregationQueryResponse runAggregationQueryResponse =
        this.datastoreRpc.runAggregationQuery(runAggregationQueryRequest);
    return this.responseTransformer.transform(runAggregationQueryResponse);
  }

  public AggregationResults execute(
      AggregationQuery query,
      ExplainOptions explainOptions,
      RequestOptions requestOptions,
      ReadOption... readOptions) {
    return execute(
        query,
        DatastoreExecutionOptions.newBuilder()
            .setExplainOptions(explainOptions)
            .setRequestOptions(requestOptions)
            .setReadOptions(readOptions != null ? Arrays.asList(readOptions) : Collections.emptyList())
            .build());
  }

  private RunAggregationQueryRequest getRunAggregationQueryRequest(
      AggregationQuery query, DatastoreExecutionOptions executionOptions) {
    QueryConfig<AggregationQuery> queryConfig =
        QueryConfig.createWithDatastoreExecutionOptions(query, executionOptions);
    return this.protoPreparer.prepare(queryConfig);
  }
}
