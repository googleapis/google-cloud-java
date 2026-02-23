/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.utils;

import static com.google.common.truth.Truth.assertThat;
import static com.google.datastore.utils.DatastoreHelper.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

import com.google.datastore.utils.testing.MockCredential;
import com.google.datastore.utils.testing.MockDatastoreFactory;
import com.google.datastore.v1.*;
import com.google.datastore.v1.EntityResult.ResultType;
import com.google.datastore.v1.PropertyFilter.Operator;
import com.google.datastore.v1.PropertyOrder.Direction;
import com.google.datastore.v1.QueryResultBatch.MoreResultsType;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for {@link com.google.datastore.utils.QuerySplitterImpl}. */
@RunWith(JUnit4.class)
public class QuerySplitterTest {
  private static final String PROJECT_ID = "project-id";
  private static final PartitionId PARTITION =
      PartitionId.newBuilder().setProjectId(PROJECT_ID).build();
  private static final String KIND = "test-kind";

  private DatastoreFactory factory = new MockDatastoreFactory();
  private com.google.datastore.utils.DatastoreOptions.Builder options =
      new DatastoreOptions.Builder().projectId(PROJECT_ID).credential(new MockCredential());

  private Filter propertyFilter = makeFilter("foo", Operator.EQUAL, makeValue("value")).build();

  private Query query =
      Query.newBuilder()
          .addKind(KindExpression.newBuilder().setName(KIND).build())
          .setFilter(propertyFilter)
          .build();

  private Query splitQuery =
      Query.newBuilder()
          .addKind(KindExpression.newBuilder().setName(KIND).build())
          .addOrder(makeOrder("__scatter__", Direction.ASCENDING))
          .addProjection(Projection.newBuilder().setProperty(makePropertyReference("__key__")))
          .build();

  private Key splitKey0 = makeKey(KIND, String.format("%05d", 1)).setPartitionId(PARTITION).build();
  private Key splitKey1 =
      makeKey(KIND, String.format("%05d", 101)).setPartitionId(PARTITION).build();
  private Key splitKey2 =
      makeKey(KIND, String.format("%05d", 201)).setPartitionId(PARTITION).build();
  private Key splitKey3 =
      makeKey(KIND, String.format("%05d", 301)).setPartitionId(PARTITION).build();

  @Test
  public void disallowsSortOrder() {
    com.google.datastore.utils.Datastore datastore = factory.create(options.build());
    Query queryWithOrder =
        query.toBuilder().addOrder(makeOrder("bar", Direction.ASCENDING)).build();
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                com.google.datastore.utils.QuerySplitterImpl.INSTANCE.getSplits(
                    queryWithOrder, PARTITION, 2, datastore));
    assertThat(exception).hasMessageThat().contains("Query cannot have any sort orders.");
  }

  @Test
  public void disallowsMultipleKinds() {
    com.google.datastore.utils.Datastore datastore = factory.create(options.build());
    Query queryWithMultipleKinds =
        query.toBuilder()
            .addKind(KindExpression.newBuilder().setName("another-kind").build())
            .build();
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                com.google.datastore.utils.QuerySplitterImpl.INSTANCE.getSplits(
                    queryWithMultipleKinds, PARTITION, 2, datastore));
    assertThat(exception).hasMessageThat().contains("Query must have exactly one kind.");
  }

  @Test
  public void disallowsKindlessQuery() {
    com.google.datastore.utils.Datastore datastore = factory.create(options.build());
    Query kindlessQuery = query.toBuilder().clearKind().build();
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                com.google.datastore.utils.QuerySplitterImpl.INSTANCE.getSplits(
                    kindlessQuery, PARTITION, 2, datastore));
    assertThat(exception).hasMessageThat().contains("Query must have exactly one kind.");
  }

  @Test
  public void disallowsInequalityFilter() {
    com.google.datastore.utils.Datastore datastore = factory.create(options.build());
    Query queryWithInequality =
        query.toBuilder()
            .setFilter(makeFilter("foo", Operator.GREATER_THAN, makeValue("value")))
            .build();
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                com.google.datastore.utils.QuerySplitterImpl.INSTANCE.getSplits(
                    queryWithInequality, PARTITION, 2, datastore));
    assertThat(exception).hasMessageThat().contains("Query cannot have any inequality filters.");
  }

  @Test
  public void splitsMustBePositive() {
    com.google.datastore.utils.Datastore datastore = factory.create(options.build());
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                com.google.datastore.utils.QuerySplitterImpl.INSTANCE.getSplits(
                    query, PARTITION, 0, datastore));
    assertThat(exception).hasMessageThat().contains("The number of splits must be greater than 0.");
  }

  @Test
  public void getSplits() throws Exception {
    com.google.datastore.utils.Datastore datastore = factory.create(options.build());
    MockDatastoreFactory mockClient = (MockDatastoreFactory) factory;

    RunQueryResponse splitQueryResponse =
        RunQueryResponse.newBuilder()
            .setQuery(splitQuery)
            .setBatch(
                QueryResultBatch.newBuilder()
                    .setEntityResultType(ResultType.KEY_ONLY)
                    .setMoreResults(MoreResultsType.NO_MORE_RESULTS)
                    .addEntityResults(makeKeyOnlyEntity(splitKey0))
                    .addEntityResults(makeKeyOnlyEntity(splitKey1))
                    .addEntityResults(makeKeyOnlyEntity(splitKey2))
                    .addEntityResults(makeKeyOnlyEntity(splitKey3))
                    .build())
            .build();

    mockClient.setNextResponse(splitQueryResponse);

    List<Query> splittedQueries =
        com.google.datastore.utils.QuerySplitterImpl.INSTANCE.getSplits(
            query, PARTITION, 3, datastore);

    assertThat(splittedQueries)
        .containsExactly(
            query.toBuilder()
                .setFilter(makeFilterWithKeyRange(propertyFilter, null, splitKey1))
                .build(),
            query.toBuilder()
                .setFilter(makeFilterWithKeyRange(propertyFilter, splitKey1, splitKey3))
                .build(),
            query.toBuilder()
                .setFilter(makeFilterWithKeyRange(propertyFilter, splitKey3, null))
                .build());

    RunQueryRequest expectedSplitQueryRequest =
        RunQueryRequest.newBuilder()
            .setPartitionId(PARTITION)
            .setProjectId(PROJECT_ID)
            .setQuery(
                splitQuery.toBuilder().setLimit(Int32Value.newBuilder().setValue(2 * 32).build()))
            .build();

    assertArrayEquals(expectedSplitQueryRequest.toByteArray(), mockClient.getLastBody());
  }

  @Test
  public void getSplitsWithDatabaseId() throws Exception {
    com.google.datastore.utils.Datastore datastore = factory.create(options.build());
    MockDatastoreFactory mockClient = (MockDatastoreFactory) factory;

    PartitionId partition =
        PartitionId.newBuilder().setProjectId(PROJECT_ID).setDatabaseId("test-database").build();

    RunQueryResponse splitQueryResponse =
        RunQueryResponse.newBuilder()
            .setQuery(splitQuery)
            .setBatch(
                QueryResultBatch.newBuilder()
                    .setEntityResultType(ResultType.KEY_ONLY)
                    .setMoreResults(MoreResultsType.NO_MORE_RESULTS)
                    .addEntityResults(makeKeyOnlyEntity(splitKey0))
                    .addEntityResults(makeKeyOnlyEntity(splitKey1))
                    .addEntityResults(makeKeyOnlyEntity(splitKey2))
                    .addEntityResults(makeKeyOnlyEntity(splitKey3))
                    .build())
            .build();

    mockClient.setNextResponse(splitQueryResponse);

    List<Query> splitQueries =
        com.google.datastore.utils.QuerySplitterImpl.INSTANCE.getSplits(
            query, partition, 3, datastore);

    assertThat(splitQueries)
        .containsExactly(
            query.toBuilder()
                .setFilter(makeFilterWithKeyRange(propertyFilter, null, splitKey1))
                .build(),
            query.toBuilder()
                .setFilter(makeFilterWithKeyRange(propertyFilter, splitKey1, splitKey3))
                .build(),
            query.toBuilder()
                .setFilter(makeFilterWithKeyRange(propertyFilter, splitKey3, null))
                .build());

    RunQueryRequest expectedSplitQueryRequest =
        RunQueryRequest.newBuilder()
            .setPartitionId(partition)
            .setProjectId(PROJECT_ID)
            .setDatabaseId("test-database")
            .setQuery(
                splitQuery.toBuilder().setLimit(Int32Value.newBuilder().setValue(2 * 32).build()))
            .build();

    assertArrayEquals(expectedSplitQueryRequest.toByteArray(), mockClient.getLastBody());
  }

  @Test
  public void notEnoughSplits() throws Exception {
    com.google.datastore.utils.Datastore datastore = factory.create(options.build());
    MockDatastoreFactory mockClient = (MockDatastoreFactory) factory;

    RunQueryResponse splitQueryResponse =
        RunQueryResponse.newBuilder()
            .setQuery(splitQuery)
            .setBatch(
                QueryResultBatch.newBuilder()
                    .setEntityResultType(ResultType.KEY_ONLY)
                    .setMoreResults(MoreResultsType.NO_MORE_RESULTS)
                    .addEntityResults(makeKeyOnlyEntity(splitKey0))
                    .build())
            .build();

    mockClient.setNextResponse(splitQueryResponse);

    List<Query> splittedQueries =
        com.google.datastore.utils.QuerySplitterImpl.INSTANCE.getSplits(
            query, PARTITION, 100, datastore);

    assertThat(splittedQueries)
        .containsExactly(
            query.toBuilder()
                .setFilter(makeFilterWithKeyRange(propertyFilter, null, splitKey0))
                .build(),
            query.toBuilder()
                .setFilter(makeFilterWithKeyRange(propertyFilter, splitKey0, null))
                .build());

    RunQueryRequest expectedSplitQueryRequest =
        RunQueryRequest.newBuilder()
            .setPartitionId(PARTITION)
            .setProjectId(PROJECT_ID)
            .setQuery(
                splitQuery.toBuilder().setLimit(Int32Value.newBuilder().setValue(99 * 32).build()))
            .build();

    assertArrayEquals(expectedSplitQueryRequest.toByteArray(), mockClient.getLastBody());
  }

  @Test
  public void getSplits_withReadTime() throws Exception {
    Datastore datastore = factory.create(options.build());
    MockDatastoreFactory mockClient = (MockDatastoreFactory) factory;

    RunQueryResponse splitQueryResponse =
        RunQueryResponse.newBuilder()
            .setQuery(splitQuery)
            .setBatch(
                QueryResultBatch.newBuilder()
                    .setEntityResultType(ResultType.KEY_ONLY)
                    .setMoreResults(MoreResultsType.NO_MORE_RESULTS)
                    .addEntityResults(makeKeyOnlyEntity(splitKey0))
                    .addEntityResults(makeKeyOnlyEntity(splitKey1))
                    .addEntityResults(makeKeyOnlyEntity(splitKey2))
                    .addEntityResults(makeKeyOnlyEntity(splitKey3))
                    .build())
            .build();

    mockClient.setNextResponse(splitQueryResponse);

    Timestamp readTime = Timestamp.newBuilder().setSeconds(1654651341L).build();

    List<Query> splittedQueries =
        com.google.datastore.utils.QuerySplitterImpl.INSTANCE.getSplits(
            query, PARTITION, 3, datastore, readTime);

    assertThat(splittedQueries)
        .containsExactly(
            query.toBuilder()
                .setFilter(makeFilterWithKeyRange(propertyFilter, null, splitKey1))
                .build(),
            query.toBuilder()
                .setFilter(makeFilterWithKeyRange(propertyFilter, splitKey1, splitKey3))
                .build(),
            query.toBuilder()
                .setFilter(makeFilterWithKeyRange(propertyFilter, splitKey3, null))
                .build());

    RunQueryRequest expectedSplitQueryRequest =
        RunQueryRequest.newBuilder()
            .setPartitionId(PARTITION)
            .setProjectId(PROJECT_ID)
            .setQuery(
                splitQuery.toBuilder().setLimit(Int32Value.newBuilder().setValue(2 * 32).build()))
            .setReadOptions(ReadOptions.newBuilder().setReadTime(readTime))
            .build();

    assertArrayEquals(expectedSplitQueryRequest.toByteArray(), mockClient.getLastBody());
  }

  private static EntityResult makeKeyOnlyEntity(Key key) {
    return EntityResult.newBuilder().setEntity(Entity.newBuilder().setKey(key).build()).build();
  }

  private static Filter makeFilterWithKeyRange(Filter originalFilter, Key startKey, Key endKey) {
    Filter startKeyFilter =
        startKey == null
            ? null
            : makeFilter("__key__", Operator.GREATER_THAN_OR_EQUAL, makeValue(startKey)).build();

    Filter endKeyFilter =
        endKey == null
            ? null
            : makeFilter("__key__", Operator.LESS_THAN, makeValue(endKey)).build();

    if (startKeyFilter == null && endKeyFilter == null) {
      throw new IllegalArgumentException();
    }

    if (startKeyFilter != null && endKeyFilter == null) {
      return makeAndFilter(originalFilter, startKeyFilter).build();
    }

    if (startKeyFilter == null && endKeyFilter != null) {
      return makeAndFilter(originalFilter, endKeyFilter).build();
    }

    return makeAndFilter(originalFilter, startKeyFilter, endKeyFilter).build();
  }
}
