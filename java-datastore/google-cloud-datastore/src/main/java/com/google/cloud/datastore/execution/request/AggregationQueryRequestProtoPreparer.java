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
package com.google.cloud.datastore.execution.request;

import static com.google.cloud.datastore.AggregationQuery.Mode.GQL;

import com.google.api.core.InternalApi;
import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.GqlQueryProtoPreparer;
import com.google.cloud.datastore.ReadOption;
import com.google.cloud.datastore.ReadOption.QueryConfig;
import com.google.cloud.datastore.ReadOptionProtoPreparer;
import com.google.cloud.datastore.StructuredQueryProtoPreparer;
import com.google.cloud.datastore.aggregation.Aggregation;
import com.google.common.base.MoreObjects;
import com.google.datastore.v1.GqlQuery;
import com.google.datastore.v1.PartitionId;
import com.google.datastore.v1.Query;
import com.google.datastore.v1.ReadOptions;
import com.google.datastore.v1.RunAggregationQueryRequest;
import java.util.List;
import java.util.Optional;

@InternalApi
public class AggregationQueryRequestProtoPreparer
    implements ProtoPreparer<QueryConfig<AggregationQuery>, RunAggregationQueryRequest> {

  private final DatastoreOptions datastoreOptions;
  private final StructuredQueryProtoPreparer structuredQueryProtoPreparer;
  private final GqlQueryProtoPreparer gqlQueryProtoPreparer;
  private final ReadOptionProtoPreparer readOptionProtoPreparer;

  public AggregationQueryRequestProtoPreparer(DatastoreOptions datastoreOptions) {
    this.datastoreOptions = datastoreOptions;
    this.structuredQueryProtoPreparer = new StructuredQueryProtoPreparer();
    this.gqlQueryProtoPreparer = new GqlQueryProtoPreparer();
    this.readOptionProtoPreparer = new ReadOptionProtoPreparer();
  }

  @Override
  public RunAggregationQueryRequest prepare(QueryConfig<AggregationQuery> queryConfig) {
    AggregationQuery aggregationQuery = queryConfig.getQuery();
    List<ReadOption> readOptions = queryConfig.getReadOptions();
    PartitionId partitionId = getPartitionId(aggregationQuery);
    RunAggregationQueryRequest.Builder aggregationQueryRequestBuilder =
        RunAggregationQueryRequest.newBuilder()
            .setPartitionId(partitionId)
            .setProjectId(datastoreOptions.getProjectId())
            .setDatabaseId(datastoreOptions.getDatabaseId());

    if (aggregationQuery.getMode() == GQL) {
      aggregationQueryRequestBuilder.setGqlQuery(buildGqlQuery(aggregationQuery));
    } else {
      aggregationQueryRequestBuilder.setAggregationQuery(getAggregationQuery(aggregationQuery));
    }
    if (queryConfig.getExplainOptions() != null) {
      aggregationQueryRequestBuilder.setExplainOptions(queryConfig.getExplainOptions());
    }
    Optional<ReadOptions> readOptionsPb = readOptionProtoPreparer.prepare(readOptions);
    readOptionsPb.ifPresent(aggregationQueryRequestBuilder::setReadOptions);
    return aggregationQueryRequestBuilder.build();
  }

  private GqlQuery buildGqlQuery(AggregationQuery aggregationQuery) {
    return gqlQueryProtoPreparer.prepare(aggregationQuery.getNestedGqlQuery());
  }

  private com.google.datastore.v1.AggregationQuery getAggregationQuery(
      AggregationQuery aggregationQuery) {
    Query nestedQueryProto =
        structuredQueryProtoPreparer.prepare(aggregationQuery.getNestedStructuredQuery());

    com.google.datastore.v1.AggregationQuery.Builder aggregationQueryProtoBuilder =
        com.google.datastore.v1.AggregationQuery.newBuilder().setNestedQuery(nestedQueryProto);
    for (Aggregation aggregation : aggregationQuery.getAggregations()) {
      aggregationQueryProtoBuilder.addAggregations(aggregation.toPb());
    }
    return aggregationQueryProtoBuilder.build();
  }

  private PartitionId getPartitionId(AggregationQuery aggregationQuery) {
    PartitionId.Builder builder =
        PartitionId.newBuilder()
            .setProjectId(datastoreOptions.getProjectId())
            .setDatabaseId(datastoreOptions.getDatabaseId());
    String namespace =
        MoreObjects.firstNonNull(aggregationQuery.getNamespace(), datastoreOptions.getNamespace());
    builder.setNamespaceId(namespace);
    return builder.build();
  }
}
