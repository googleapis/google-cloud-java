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
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.ReadOption;
import com.google.cloud.datastore.ReadOption.QueryAndReadOptions;
import com.google.cloud.datastore.execution.request.AggregationQueryRequestProtoPreparer;
import com.google.cloud.datastore.execution.response.AggregationQueryResponseTransformer;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import java.util.Arrays;

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
  public AggregationResults execute(AggregationQuery query, ReadOption... readOptions) {
    RunAggregationQueryRequest runAggregationQueryRequest =
        getRunAggregationQueryRequest(query, readOptions);
    RunAggregationQueryResponse runAggregationQueryResponse =
        this.datastoreRpc.runAggregationQuery(runAggregationQueryRequest);
    return this.responseTransformer.transform(runAggregationQueryResponse);
  }

  private RunAggregationQueryRequest getRunAggregationQueryRequest(
      AggregationQuery query, ReadOption... readOptions) {
    QueryAndReadOptions<AggregationQuery> queryAndReadOptions =
        readOptions == null
            ? QueryAndReadOptions.create(query)
            : QueryAndReadOptions.create(query, Arrays.asList(readOptions));
    return this.protoPreparer.prepare(queryAndReadOptions);
  }
}
