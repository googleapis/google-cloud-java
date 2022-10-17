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

import static com.google.cloud.datastore.ProtoTestData.intValue;
import static com.google.cloud.datastore.ReadOption.eventualConsistency;
import static com.google.cloud.datastore.StructuredQuery.PropertyFilter.eq;
import static com.google.cloud.datastore.TestUtils.matches;
import static com.google.cloud.datastore.aggregation.Aggregation.count;
import static com.google.common.truth.Truth.assertThat;
import static com.google.datastore.v1.ReadOptions.ReadConsistency.EVENTUAL;
import static java.util.Arrays.asList;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.AggregationResults;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.LongValue;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.common.collect.ImmutableMap;
import com.google.datastore.v1.AggregationResultBatch;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.Value;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class AggregationQueryExecutorTest {

  private static final String KIND = "Task";
  private static final String NAMESPACE = "ns";

  private DatastoreRpc mockRpc;
  private AggregationQueryExecutor queryExecutor;
  private DatastoreOptions datastoreOptions;

  @Before
  public void setUp() throws Exception {
    mockRpc = EasyMock.createStrictMock(DatastoreRpc.class);
    datastoreOptions =
        DatastoreOptions.newBuilder().setProjectId("project-id").setNamespace(NAMESPACE).build();
    queryExecutor = new AggregationQueryExecutor(mockRpc, datastoreOptions);
  }

  @Test
  public void shouldExecuteAggregationQuery() {
    EntityQuery nestedQuery =
        Query.newEntityQueryBuilder()
            .setNamespace(NAMESPACE)
            .setKind(KIND)
            .setFilter(eq("done", true))
            .build();

    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .setNamespace(NAMESPACE)
            .addAggregation(count().as("total"))
            .over(nestedQuery)
            .build();

    RunAggregationQueryResponse runAggregationQueryResponse = placeholderAggregationQueryResponse();
    expect(mockRpc.runAggregationQuery(anyObject(RunAggregationQueryRequest.class)))
        .andReturn(runAggregationQueryResponse);

    replay(mockRpc);

    AggregationResults aggregationResults = queryExecutor.execute(aggregationQuery);

    verify(mockRpc);
    assertThat(aggregationResults)
        .isEqualTo(
            new AggregationResults(
                asList(
                    new AggregationResult(
                        ImmutableMap.of(
                            "count", LongValue.of(209), "property_2", LongValue.of(100))),
                    new AggregationResult(
                        ImmutableMap.of(
                            "count", LongValue.of(509), "property_2", LongValue.of(100)))),
                Timestamp.fromProto(runAggregationQueryResponse.getBatch().getReadTime())));
  }

  @Test
  public void shouldExecuteAggregationQueryWithReadOptions() {
    EntityQuery nestedQuery =
        Query.newEntityQueryBuilder()
            .setNamespace(NAMESPACE)
            .setKind(KIND)
            .setFilter(eq("done", true))
            .build();

    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .setNamespace(NAMESPACE)
            .addAggregation(count().as("total"))
            .over(nestedQuery)
            .build();

    RunAggregationQueryResponse runAggregationQueryResponse = placeholderAggregationQueryResponse();
    expect(mockRpc.runAggregationQuery(matches(runAggregationRequestWithEventualConsistency())))
        .andReturn(runAggregationQueryResponse);

    replay(mockRpc);

    AggregationResults aggregationResults =
        queryExecutor.execute(aggregationQuery, eventualConsistency());

    verify(mockRpc);
    assertThat(aggregationResults)
        .isEqualTo(
            new AggregationResults(
                asList(
                    new AggregationResult(
                        ImmutableMap.of(
                            "count", LongValue.of(209), "property_2", LongValue.of(100))),
                    new AggregationResult(
                        ImmutableMap.of(
                            "count", LongValue.of(509), "property_2", LongValue.of(100)))),
                Timestamp.fromProto(runAggregationQueryResponse.getBatch().getReadTime())));
  }

  private RunAggregationQueryResponse placeholderAggregationQueryResponse() {
    Map<String, Value> result1 =
        new HashMap<>(
            ImmutableMap.of(
                "count", intValue(209),
                "property_2", intValue(100)));

    Map<String, Value> result2 =
        new HashMap<>(
            ImmutableMap.of(
                "count", intValue(509),
                "property_2", intValue(100)));

    AggregationResultBatch resultBatch =
        AggregationResultBatch.newBuilder()
            .addAggregationResults(
                com.google.datastore.v1.AggregationResult.newBuilder()
                    .putAllAggregateProperties(result1)
                    .build())
            .addAggregationResults(
                com.google.datastore.v1.AggregationResult.newBuilder()
                    .putAllAggregateProperties(result2)
                    .build())
            .build();
    return RunAggregationQueryResponse.newBuilder().setBatch(resultBatch).build();
  }

  private Predicate<RunAggregationQueryRequest> runAggregationRequestWithEventualConsistency() {
    return runAggregationQueryRequest ->
        runAggregationQueryRequest.getReadOptions().getReadConsistency() == EVENTUAL;
  }
}
