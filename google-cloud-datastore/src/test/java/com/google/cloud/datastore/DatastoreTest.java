/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.ServiceOptions;
import com.google.cloud.Timestamp;
import com.google.cloud.datastore.Query.ResultType;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.cloud.datastore.spi.DatastoreRpcFactory;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.cloud.datastore.testing.LocalDatastoreHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.EntityResult;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.PartitionId;
import com.google.datastore.v1.QueryResultBatch;
import com.google.datastore.v1.ReadOptions;
import com.google.datastore.v1.ReadOptions.ReadConsistency;
import com.google.datastore.v1.ReserveIdsRequest;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import com.google.datastore.v1.TransactionOptions;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class DatastoreTest {

  private static LocalDatastoreHelper helper = LocalDatastoreHelper.create(1.0);
  private static final DatastoreOptions options = helper.getOptions();
  private static final Datastore datastore = options.getService();
  private static final String PROJECT_ID = options.getProjectId();
  private static final String KIND1 = "kind1";
  private static final String KIND2 = "kind2";
  private static final String KIND3 = "kind3";
  private static final NullValue NULL_VALUE = NullValue.of();
  private static final StringValue STR_VALUE = StringValue.of("str");
  private static final BooleanValue BOOL_VALUE =
      BooleanValue.newBuilder(false).setExcludeFromIndexes(true).build();
  private static final IncompleteKey INCOMPLETE_KEY1 =
      IncompleteKey.newBuilder(PROJECT_ID, KIND1).build();
  private static final IncompleteKey INCOMPLETE_KEY2 =
      IncompleteKey.newBuilder(PROJECT_ID, KIND2).build();
  private static final Key KEY1 = Key.newBuilder(INCOMPLETE_KEY1, "name").build();
  private static final Key KEY2 = Key.newBuilder(KEY1, KIND2, 1).build();
  private static final Key KEY3 = Key.newBuilder(KEY2).setName("bla").build();
  private static final Key KEY4 = Key.newBuilder(KEY2).setName("newName1").build();
  private static final Key KEY5 = Key.newBuilder(KEY2).setName("newName2").build();
  private static final KeyValue KEY_VALUE = KeyValue.of(KEY1);
  private static final ListValue LIST_VALUE1 =
      ListValue.newBuilder().addValue(NULL_VALUE).addValue(STR_VALUE, BOOL_VALUE).build();
  private static final ListValue LIST_VALUE2 = ListValue.of(Collections.singletonList(KEY_VALUE));
  private static final ListValue EMPTY_LIST_VALUE = ListValue.of(Collections.<Value<?>>emptyList());
  private static final TimestampValue TIMESTAMP_VALUE = new TimestampValue(Timestamp.now());
  private static final LatLngValue LAT_LNG_VALUE =
      new LatLngValue(new LatLng(37.422035, -122.084124));
  private static final FullEntity<IncompleteKey> PARTIAL_ENTITY1 =
      FullEntity.newBuilder(INCOMPLETE_KEY2)
          .set("str", STR_VALUE)
          .set("bool", BOOL_VALUE)
          .set("list", LIST_VALUE1)
          .build();
  private static final FullEntity<IncompleteKey> PARTIAL_ENTITY2 =
      FullEntity.newBuilder(PARTIAL_ENTITY1)
          .remove("str")
          .set("bool", true)
          .set("list", LIST_VALUE1.get())
          .build();
  private static final FullEntity<IncompleteKey> PARTIAL_ENTITY3 =
      FullEntity.newBuilder(PARTIAL_ENTITY1)
          .setKey(IncompleteKey.newBuilder(PROJECT_ID, KIND3).build())
          .build();
  private static final Entity ENTITY1 =
      Entity.newBuilder(KEY1)
          .set("str", STR_VALUE)
          .set("date", TIMESTAMP_VALUE)
          .set("latLng", LAT_LNG_VALUE)
          .set("bool", BOOL_VALUE)
          .set("partial1", EntityValue.of(PARTIAL_ENTITY1))
          .set("list", LIST_VALUE2)
          .set("emptyList", EMPTY_LIST_VALUE)
          .build();
  private static final Entity ENTITY2 =
      Entity.newBuilder(ENTITY1)
          .setKey(KEY2)
          .remove("str")
          .set("name", "Dan")
          .setNull("null")
          .set("age", 20)
          .build();
  private static final Entity ENTITY3 =
      Entity.newBuilder(ENTITY1)
          .setKey(KEY3)
          .remove("str")
          .set("null", NULL_VALUE)
          .set("partial1", PARTIAL_ENTITY2)
          .set("partial2", ENTITY2)
          .build();

  private DatastoreOptions rpcMockOptions;
  private DatastoreRpcFactory rpcFactoryMock;
  private DatastoreRpc rpcMock;

  @BeforeClass
  public static void beforeClass() throws IOException, InterruptedException {
    helper.start();
  }

  @Before
  public void setUp() {
    rpcFactoryMock = EasyMock.createStrictMock(DatastoreRpcFactory.class);
    rpcMock = EasyMock.createStrictMock(DatastoreRpc.class);
    rpcMockOptions =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .setServiceRpcFactory(rpcFactoryMock)
            .build();
    EasyMock.expect(rpcFactoryMock.create(rpcMockOptions)).andReturn(rpcMock);
    StructuredQuery<Key> query = Query.newKeyQueryBuilder().build();
    QueryResults<Key> result = datastore.run(query);
    datastore.delete(Iterators.toArray(result, Key.class));
    datastore.add(ENTITY1, ENTITY2);
  }

  @AfterClass
  public static void afterClass() throws IOException, InterruptedException, TimeoutException {
    helper.stop(Duration.ofMinutes(1));
  }

  @Test
  public void testGetOptions() {
    assertSame(options, datastore.getOptions());
  }

  @Test
  public void testNewTransactionCommit() {
    Transaction transaction = datastore.newTransaction();
    transaction.add(ENTITY3);
    Entity entity2 = Entity.newBuilder(ENTITY2).clear().setNull("bla").build();
    transaction.update(entity2);
    transaction.delete(KEY1);
    transaction.commit();

    List<Entity> list = datastore.fetch(KEY1, KEY2, KEY3);
    assertNull(list.get(0));
    assertEquals(entity2, list.get(1));
    assertEquals(ENTITY3, list.get(2));
    assertEquals(3, list.size());

    try {
      transaction.commit();
      fail("Expecting a failure");
    } catch (DatastoreException ex) {
      // expected to fail
    }

    try {
      transaction.rollback();
      fail("Expecting a failure");
    } catch (DatastoreException ex) {
      // expected to fail
    }

    verifyNotUsable(transaction);
  }

  @Test
  public void testTransactionWithRead() {
    Transaction transaction = datastore.newTransaction();
    assertNull(transaction.get(KEY3));
    transaction.add(ENTITY3);
    transaction.commit();
    assertEquals(ENTITY3, datastore.get(KEY3));

    transaction = datastore.newTransaction();
    assertEquals(ENTITY3, transaction.get(KEY3));
    // update entity3 during the transaction
    datastore.put(Entity.newBuilder(ENTITY3).clear().build());
    transaction.update(ENTITY2);
    try {
      transaction.commit();
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      assertEquals("ABORTED", expected.getReason());
    }
  }

  @Test
  public void testTransactionWithQuery() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(KIND2)
            .setFilter(PropertyFilter.hasAncestor(KEY2))
            .build();
    Transaction transaction = datastore.newTransaction();
    QueryResults<Entity> results = transaction.run(query);
    assertEquals(ENTITY2, results.next());
    assertFalse(results.hasNext());
    transaction.add(ENTITY3);
    transaction.commit();
    assertEquals(ENTITY3, datastore.get(KEY3));

    transaction = datastore.newTransaction();
    results = transaction.run(query);
    assertEquals(ENTITY2, results.next());
    transaction.delete(ENTITY3.getKey());
    // update entity2 during the transaction
    datastore.put(Entity.newBuilder(ENTITY2).clear().build());
    try {
      transaction.commit();
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      assertEquals("ABORTED", expected.getReason());
    }
  }

  @Test
  public void testNewTransactionRollback() {
    Transaction transaction = datastore.newTransaction();
    transaction.add(ENTITY3);
    Entity entity2 =
        Entity.newBuilder(ENTITY2)
            .clear()
            .setNull("bla")
            .set("list3", StringValue.of("bla"), StringValue.newBuilder("bla").build())
            .build();
    transaction.update(entity2);
    transaction.delete(KEY1);
    transaction.rollback();
    transaction.rollback(); // should be safe to repeat rollback calls

    try {
      transaction.commit();
      fail("Expecting a failure");
    } catch (DatastoreException ex) {
      // expected to fail
    }

    verifyNotUsable(transaction);

    List<Entity> list = datastore.fetch(KEY1, KEY2, KEY3);
    assertEquals(ENTITY1, list.get(0));
    assertEquals(ENTITY2, list.get(1));
    assertNull(list.get(2));
    assertEquals(3, list.size());
  }

  @Test
  public void testRunInTransactionWithReadWriteOption() {

    EasyMock.expect(rpcMock.beginTransaction(EasyMock.anyObject(BeginTransactionRequest.class)))
        .andReturn(BeginTransactionResponse.getDefaultInstance());
    EasyMock.expect(rpcMock.rollback(EasyMock.anyObject(RollbackRequest.class)))
        .andReturn(RollbackResponse.getDefaultInstance())
        .once();

    EasyMock.expect(rpcMock.beginTransaction(EasyMock.anyObject(BeginTransactionRequest.class)))
        .andReturn(BeginTransactionResponse.getDefaultInstance());
    EasyMock.expect(rpcMock.commit(EasyMock.anyObject(CommitRequest.class)))
        .andReturn(CommitResponse.newBuilder().build());

    EasyMock.replay(rpcFactoryMock, rpcMock);

    Datastore mockDatastore = rpcMockOptions.getService();

    Datastore.TransactionCallable<Integer> callable =
        new Datastore.TransactionCallable<Integer>() {
          private Integer attempts = 1;

          @Override
          public Integer run(DatastoreReaderWriter transaction) {
            if (attempts < 2) {
              ++attempts;
              throw new DatastoreException(10, "", "ABORTED", false, null);
            }
            return attempts;
          }
        };

    TransactionOptions options =
        TransactionOptions.newBuilder()
            .setReadWrite(TransactionOptions.ReadWrite.getDefaultInstance())
            .build();
    Integer result = mockDatastore.runInTransaction(callable, options);
    EasyMock.verify(rpcFactoryMock, rpcMock);
    assertEquals(2, result.intValue());
  }

  private void verifyNotUsable(DatastoreWriter writer) {
    try {
      writer.add(ENTITY3);
      fail("Expecting a failure");
    } catch (DatastoreException ex) {
      // expected to fail
    }

    try {
      writer.put(ENTITY3);
      fail("Expecting a failure");
    } catch (DatastoreException ex) {
      // expected to fail
    }

    try {
      writer.update(ENTITY3);
      fail("Expecting a failure");
    } catch (DatastoreException ex) {
      // expected to fail
    }

    try {
      writer.delete(ENTITY3.getKey());
      fail("Expecting a failure");
    } catch (DatastoreException ex) {
      // expected to fail
    }
  }

  @Test
  public void testNewBatch() {
    Batch batch = datastore.newBatch();
    Entity entity1 = Entity.newBuilder(ENTITY1).clear().build();
    Entity entity2 = Entity.newBuilder(ENTITY2).clear().setNull("bla").build();
    Entity entity4 = Entity.newBuilder(KEY4).set("value", StringValue.of("value")).build();
    Entity entity5 = Entity.newBuilder(KEY5).set("value", "value").build();

    List<Entity> entities = batch.add(entity4, PARTIAL_ENTITY2, entity5);
    Entity entity6 = entities.get(1);
    assertSame(entity4, entities.get(0));
    assertEquals(PARTIAL_ENTITY2.getProperties(), entity6.getProperties());
    assertEquals(PARTIAL_ENTITY2.getKey().getProjectId(), entity6.getKey().getProjectId());
    assertEquals(PARTIAL_ENTITY2.getKey().getNamespace(), entity6.getKey().getNamespace());
    assertEquals(PARTIAL_ENTITY2.getKey().getAncestors(), entity6.getKey().getAncestors());
    assertEquals(PARTIAL_ENTITY2.getKey().getKind(), entity6.getKey().getKind());
    assertEquals(PARTIAL_ENTITY2.getKey(), IncompleteKey.newBuilder(entity6.getKey()).build());
    assertNotEquals(PARTIAL_ENTITY2.getKey().getPath(), entity6.getKey().getPath());
    assertNotEquals(PARTIAL_ENTITY2.getKey(), entity6.getKey());
    assertSame(entity5, entities.get(2));
    batch.addWithDeferredIdAllocation(PARTIAL_ENTITY3);
    batch.put(ENTITY3, entity1, entity2);

    Batch.Response response = batch.submit();
    entities =
        datastore.fetch(KEY1, KEY2, KEY3, entity4.getKey(), entity5.getKey(), entity6.getKey());
    assertEquals(entity1, entities.get(0));
    assertEquals(entity2, entities.get(1));
    assertEquals(ENTITY3, entities.get(2));
    assertEquals(entity4, entities.get(3));
    assertEquals(entity5, entities.get(4));
    assertEquals(entity6, entities.get(5));
    assertEquals(6, entities.size());
    List<Key> generatedKeys = response.getGeneratedKeys();
    assertEquals(1, generatedKeys.size());
    assertEquals(
        PARTIAL_ENTITY3.getProperties(), datastore.get(generatedKeys.get(0)).getProperties());
    assertEquals(PARTIAL_ENTITY3.getKey(), IncompleteKey.newBuilder(generatedKeys.get(0)).build());

    try {
      batch.submit();
      fail("Expecting a failure");
    } catch (DatastoreException ex) {
      // expected to fail
    }
    verifyNotUsable(batch);

    batch = datastore.newBatch();
    batch.delete(entity4.getKey(), entity5.getKey());
    batch.update(ENTITY1, ENTITY2, ENTITY3);
    batch.submit();
    entities = datastore.fetch(KEY1, KEY2, KEY3, entity4.getKey(), entity5.getKey());
    assertEquals(ENTITY1, entities.get(0));
    assertEquals(ENTITY2, entities.get(1));
    assertEquals(ENTITY3, entities.get(2));
    assertNull(entities.get(3));
    assertNull(entities.get(4));
    assertEquals(5, entities.size());
  }

  @Test
  public void testRunGqlQueryNoCasting() {
    Query<Entity> query1 =
        Query.newGqlQueryBuilder(ResultType.ENTITY, "select * from " + KIND1).build();
    QueryResults<Entity> results1 = datastore.run(query1);
    assertTrue(results1.hasNext());
    assertEquals(ENTITY1, results1.next());
    assertFalse(results1.hasNext());

    datastore.put(ENTITY3);
    Query<? extends Entity> query2 =
        Query.newGqlQueryBuilder(ResultType.ENTITY, "select * from " + KIND2 + " order by __key__")
            .build();
    QueryResults<? extends Entity> results2 = datastore.run(query2);
    assertTrue(results2.hasNext());
    assertEquals(ENTITY2, results2.next());
    assertTrue(results2.hasNext());
    assertEquals(ENTITY3, results2.next());
    assertFalse(results2.hasNext());

    query1 = Query.newGqlQueryBuilder(ResultType.ENTITY, "select * from bla").build();
    results1 = datastore.run(query1);
    assertFalse(results1.hasNext());

    Query<Key> keyOnlyQuery =
        Query.newGqlQueryBuilder(ResultType.KEY, "select __key__ from " + KIND1).build();
    QueryResults<Key> keyOnlyResults = datastore.run(keyOnlyQuery);
    assertTrue(keyOnlyResults.hasNext());
    assertEquals(KEY1, keyOnlyResults.next());
    assertFalse(keyOnlyResults.hasNext());

    GqlQuery<ProjectionEntity> keyProjectionQuery =
        Query.newGqlQueryBuilder(ResultType.PROJECTION_ENTITY, "select __key__ from " + KIND1)
            .build();
    QueryResults<ProjectionEntity> keyProjectionResult = datastore.run(keyProjectionQuery);
    assertTrue(keyProjectionResult.hasNext());
    ProjectionEntity projectionEntity = keyProjectionResult.next();
    assertEquals(KEY1, projectionEntity.getKey());
    assertTrue(projectionEntity.getProperties().isEmpty());
    assertFalse(keyProjectionResult.hasNext());

    GqlQuery<ProjectionEntity> projectionQuery =
        Query.newGqlQueryBuilder(ResultType.PROJECTION_ENTITY, "select str, date from " + KIND1)
            .build();

    QueryResults<ProjectionEntity> projectionResult = datastore.run(projectionQuery);
    assertTrue(projectionResult.hasNext());
    projectionEntity = projectionResult.next();
    assertEquals("str", projectionEntity.getString("str"));
    assertEquals(TIMESTAMP_VALUE.get(), projectionEntity.getTimestamp("date"));
    assertEquals(2, projectionEntity.getNames().size());
    assertFalse(projectionResult.hasNext());
  }

  @Test
  public void testRunGqlQueryWithCasting() {
    @SuppressWarnings("unchecked")
    Query<Entity> query1 =
        (Query<Entity>) Query.newGqlQueryBuilder("select * from " + KIND1).build();
    QueryResults<Entity> results1 = datastore.run(query1);
    assertTrue(results1.hasNext());
    assertEquals(ENTITY1, results1.next());
    assertFalse(results1.hasNext());

    Query<?> query2 = Query.newGqlQueryBuilder("select * from " + KIND1).build();
    QueryResults<?> results2 = datastore.run(query2);
    assertSame(Entity.class, results2.getResultClass());
    @SuppressWarnings("unchecked")
    QueryResults<Entity> results3 = (QueryResults<Entity>) results2;
    assertTrue(results3.hasNext());
    assertEquals(ENTITY1, results3.next());
    assertFalse(results3.hasNext());
  }

  @Test
  public void testGqlQueryPagination() throws DatastoreException {
    List<RunQueryResponse> responses = buildResponsesForQueryPagination();
    for (int i = 0; i < responses.size(); i++) {
      EasyMock.expect(rpcMock.runQuery(EasyMock.anyObject(RunQueryRequest.class)))
          .andReturn(responses.get(i));
    }
    EasyMock.replay(rpcFactoryMock, rpcMock);
    Datastore mockDatastore = rpcMockOptions.getService();
    QueryResults<Key> results =
        mockDatastore.run(
            Query.newGqlQueryBuilder(ResultType.KEY, "select __key__ from *").build());
    int count = 0;
    while (results.hasNext()) {
      count += 1;
      results.next();
    }
    assertEquals(count, 5);
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  @Test
  public void testRunStructuredQuery() {
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind(KIND1).setOrderBy(OrderBy.asc("__key__")).build();
    QueryResults<Entity> results1 = datastore.run(query);
    assertTrue(results1.hasNext());
    assertEquals(ENTITY1, results1.next());
    assertFalse(results1.hasNext());

    Query<Key> keyOnlyQuery = Query.newKeyQueryBuilder().setKind(KIND1).build();
    QueryResults<Key> results2 = datastore.run(keyOnlyQuery);
    assertTrue(results2.hasNext());
    assertEquals(ENTITY1.getKey(), results2.next());
    assertFalse(results2.hasNext());

    StructuredQuery<ProjectionEntity> keyOnlyProjectionQuery =
        Query.newProjectionEntityQueryBuilder().setKind(KIND1).setProjection("__key__").build();
    QueryResults<ProjectionEntity> results3 = datastore.run(keyOnlyProjectionQuery);
    assertTrue(results3.hasNext());
    ProjectionEntity projectionEntity = results3.next();
    assertEquals(ENTITY1.getKey(), projectionEntity.getKey());
    assertTrue(projectionEntity.getNames().isEmpty());
    assertFalse(results2.hasNext());

    StructuredQuery<ProjectionEntity> projectionQuery =
        Query.newProjectionEntityQueryBuilder()
            .setKind(KIND2)
            .setProjection("age")
            .setFilter(PropertyFilter.gt("age", 18))
            .setDistinctOn("age")
            .setOrderBy(OrderBy.asc("age"))
            .setLimit(10)
            .build();

    QueryResults<ProjectionEntity> results4 = datastore.run(projectionQuery);
    assertTrue(results4.hasNext());
    ProjectionEntity entity = results4.next();
    assertEquals(ENTITY2.getKey(), entity.getKey());
    assertEquals(20, entity.getLong("age"));
    assertEquals(1, entity.getProperties().size());
    assertFalse(results4.hasNext());
  }

  @Test
  public void testStructuredQueryPagination() throws DatastoreException {
    List<RunQueryResponse> responses = buildResponsesForQueryPagination();
    for (int i = 0; i < responses.size(); i++) {
      EasyMock.expect(rpcMock.runQuery(EasyMock.anyObject(RunQueryRequest.class)))
          .andReturn(responses.get(i));
    }
    EasyMock.replay(rpcFactoryMock, rpcMock);
    Datastore datastore = rpcMockOptions.getService();
    QueryResults<Key> results = datastore.run(Query.newKeyQueryBuilder().build());
    int count = 0;
    while (results.hasNext()) {
      count += 1;
      results.next();
    }
    assertEquals(count, 5);
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  @Test
  public void testStructuredQueryPaginationWithMoreResults() throws DatastoreException {
    List<RunQueryResponse> responses = buildResponsesForQueryPagination();
    for (int i = 0; i < responses.size(); i++) {
      EasyMock.expect(rpcMock.runQuery(EasyMock.anyObject(RunQueryRequest.class)))
          .andReturn(responses.get(i));
    }
    EasyMock.replay(rpcFactoryMock, rpcMock);
    Datastore datastore = rpcMockOptions.getService();
    QueryResults<Key> results = datastore.run(Query.newKeyQueryBuilder().build());
    int count = 0;
    while (results.hasNext()) {
      count += 1;
      results.next();
    }
    assertEquals(count, 5);
    assertEquals(QueryResultBatch.MoreResultsType.NO_MORE_RESULTS, results.getMoreResults());
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  private List<RunQueryResponse> buildResponsesForQueryPagination() {
    Entity entity4 = Entity.newBuilder(KEY4).set("value", StringValue.of("value")).build();
    Entity entity5 = Entity.newBuilder(KEY5).set("value", "value").build();
    datastore.add(ENTITY3, entity4, entity5);
    List<RunQueryResponse> responses = new ArrayList<>();
    RecordQuery<Key> query = Query.newKeyQueryBuilder().build();
    RunQueryRequest.Builder requestPb = RunQueryRequest.newBuilder();
    query.populatePb(requestPb);
    QueryResultBatch queryResultBatchPb =
        RunQueryResponse.newBuilder()
            .mergeFrom(((DatastoreImpl) datastore).runQuery(requestPb.build()))
            .getBatch();
    QueryResultBatch queryResultBatchPb1 =
        QueryResultBatch.newBuilder()
            .mergeFrom(queryResultBatchPb)
            .setMoreResults(QueryResultBatch.MoreResultsType.NOT_FINISHED)
            .clearEntityResults()
            .addAllEntityResults(queryResultBatchPb.getEntityResultsList().subList(0, 1))
            .setEndCursor(queryResultBatchPb.getEntityResultsList().get(0).getCursor())
            .build();
    responses.add(RunQueryResponse.newBuilder().setBatch(queryResultBatchPb1).build());
    QueryResultBatch queryResultBatchPb2 =
        QueryResultBatch.newBuilder()
            .mergeFrom(queryResultBatchPb)
            .setMoreResults(QueryResultBatch.MoreResultsType.NOT_FINISHED)
            .clearEntityResults()
            .addAllEntityResults(queryResultBatchPb.getEntityResultsList().subList(1, 3))
            .setEndCursor(queryResultBatchPb.getEntityResultsList().get(2).getCursor())
            .build();
    responses.add(RunQueryResponse.newBuilder().setBatch(queryResultBatchPb2).build());
    QueryResultBatch queryResultBatchPb3 =
        QueryResultBatch.newBuilder()
            .mergeFrom(queryResultBatchPb)
            .setMoreResults(QueryResultBatch.MoreResultsType.NO_MORE_RESULTS)
            .clearEntityResults()
            .addAllEntityResults(queryResultBatchPb.getEntityResultsList().subList(3, 5))
            .setEndCursor(queryResultBatchPb.getEntityResultsList().get(4).getCursor())
            .build();
    responses.add(RunQueryResponse.newBuilder().setBatch(queryResultBatchPb3).build());
    return responses;
  }

  @Test
  public void testQueryPaginationWithLimit() throws DatastoreException {
    List<RunQueryResponse> responses = buildResponsesForQueryPaginationWithLimit();
    List<ByteString> endCursors = Lists.newArrayListWithCapacity(responses.size());
    for (RunQueryResponse response : responses) {
      EasyMock.expect(rpcMock.runQuery(EasyMock.anyObject(RunQueryRequest.class)))
          .andReturn(response);
      if (response.getBatch().getMoreResults() != QueryResultBatch.MoreResultsType.NOT_FINISHED) {
        endCursors.add(response.getBatch().getEndCursor());
      }
    }
    EasyMock.replay(rpcFactoryMock, rpcMock);
    Datastore datastore = rpcMockOptions.getService();
    int limit = 2;
    int totalCount = 0;
    Iterator<ByteString> cursorIter = endCursors.iterator();
    StructuredQuery<Entity> query = Query.newEntityQueryBuilder().setLimit(limit).build();
    while (true) {
      QueryResults<Entity> results = datastore.run(query);
      int resultCount = 0;
      while (results.hasNext()) {
        results.next();
        resultCount++;
        totalCount++;
      }
      assertTrue(cursorIter.hasNext());
      Cursor expectedEndCursor = Cursor.copyFrom(cursorIter.next().toByteArray());
      assertEquals(expectedEndCursor, results.getCursorAfter());
      if (resultCount < limit) {
        break;
      }
      query = query.toBuilder().setStartCursor(results.getCursorAfter()).build();
    }
    assertEquals(5, totalCount);
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  @Test
  public void testRunKeyQueryWithOffset() {
    Query<Key> query = Query.newKeyQueryBuilder().setOffset(Integer.MAX_VALUE).build();
    int numberOfEntities = datastore.run(query).getSkippedResults();
    assertEquals(2, numberOfEntities);
  }

  @Test
  public void testRunKeyQueryWithLimit() {
    datastore.put(ENTITY1, ENTITY2);
    Query<Key> keyQuery = Query.newKeyQueryBuilder().setLimit(2).build();
    QueryResults queryResults = datastore.run(keyQuery);
    int resultCount = 0;
    while (queryResults.hasNext()) {
      queryResults.next();
      resultCount++;
    }
    assertEquals(2, resultCount);

    Query<Key> query = Query.newKeyQueryBuilder().setLimit(0).build();
    QueryResults results = datastore.run(query);
    int count = 0;
    while (results.hasNext()) {
      results.next();
      count++;
    }
    assertEquals(0, count);
  }

  private List<RunQueryResponse> buildResponsesForQueryPaginationWithLimit() {
    Entity entity4 = Entity.newBuilder(KEY4).set("value", StringValue.of("value")).build();
    Entity entity5 = Entity.newBuilder(KEY5).set("value", "value").build();
    datastore.add(ENTITY3, entity4, entity5);
    DatastoreRpc datastoreRpc = datastore.getOptions().getDatastoreRpcV1();
    List<RunQueryResponse> responses = new ArrayList<>();
    RecordQuery<Entity> query = Query.newEntityQueryBuilder().build();
    RunQueryRequest.Builder requestPb = RunQueryRequest.newBuilder();
    query.populatePb(requestPb);
    QueryResultBatch queryResultBatchPb =
        RunQueryResponse.newBuilder()
            .mergeFrom(datastoreRpc.runQuery(requestPb.build()))
            .getBatch();
    QueryResultBatch queryResultBatchPb1 =
        QueryResultBatch.newBuilder()
            .mergeFrom(queryResultBatchPb)
            .setMoreResults(QueryResultBatch.MoreResultsType.NOT_FINISHED)
            .clearEntityResults()
            .addAllEntityResults(queryResultBatchPb.getEntityResultsList().subList(0, 1))
            .setEndCursor(ByteString.copyFromUtf8("a"))
            .build();
    responses.add(RunQueryResponse.newBuilder().setBatch(queryResultBatchPb1).build());
    QueryResultBatch queryResultBatchPb2 =
        QueryResultBatch.newBuilder()
            .mergeFrom(queryResultBatchPb)
            .setMoreResults(QueryResultBatch.MoreResultsType.MORE_RESULTS_AFTER_LIMIT)
            .clearEntityResults()
            .addAllEntityResults(queryResultBatchPb.getEntityResultsList().subList(1, 2))
            .setEndCursor(
                ByteString.copyFrom(new byte[] {(byte) 0x80})) // test invalid UTF-8 string
            .build();
    responses.add(RunQueryResponse.newBuilder().setBatch(queryResultBatchPb2).build());
    QueryResultBatch queryResultBatchPb3 =
        QueryResultBatch.newBuilder()
            .mergeFrom(queryResultBatchPb)
            .setMoreResults(QueryResultBatch.MoreResultsType.MORE_RESULTS_AFTER_LIMIT)
            .clearEntityResults()
            .addAllEntityResults(queryResultBatchPb.getEntityResultsList().subList(2, 4))
            .setEndCursor(ByteString.copyFromUtf8("b"))
            .build();
    responses.add(RunQueryResponse.newBuilder().setBatch(queryResultBatchPb3).build());
    QueryResultBatch queryResultBatchPb4 =
        QueryResultBatch.newBuilder()
            .mergeFrom(queryResultBatchPb)
            .setMoreResults(QueryResultBatch.MoreResultsType.NO_MORE_RESULTS)
            .clearEntityResults()
            .addAllEntityResults(queryResultBatchPb.getEntityResultsList().subList(4, 5))
            .setEndCursor(ByteString.copyFromUtf8("c"))
            .build();
    responses.add(RunQueryResponse.newBuilder().setBatch(queryResultBatchPb4).build());
    return responses;
  }

  @Test
  public void testEventualConsistencyQuery() {
    ReadOptions readOption =
        ReadOptions.newBuilder().setReadConsistencyValue(ReadConsistency.EVENTUAL_VALUE).build();
    com.google.datastore.v1.GqlQuery query =
        com.google.datastore.v1.GqlQuery.newBuilder().setQueryString("FROM * SELECT *").build();
    RunQueryRequest.Builder expectedRequest =
        RunQueryRequest.newBuilder()
            .setReadOptions(readOption)
            .setGqlQuery(query)
            .setPartitionId(PartitionId.newBuilder().setProjectId(PROJECT_ID).build());
    EasyMock.expect(rpcMock.runQuery(expectedRequest.build()))
        .andReturn(RunQueryResponse.newBuilder().build());
    EasyMock.replay(rpcFactoryMock, rpcMock);
    Datastore datastore = rpcMockOptions.getService();
    datastore.run(
        Query.newGqlQueryBuilder("FROM * SELECT *").build(), ReadOption.eventualConsistency());
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  @Test
  public void testReadTimeQuery() {
    Timestamp timestamp = Timestamp.now();
    ReadOptions readOption = ReadOptions.newBuilder().setReadTime(timestamp.toProto()).build();
    com.google.datastore.v1.GqlQuery query =
        com.google.datastore.v1.GqlQuery.newBuilder().setQueryString("FROM * SELECT *").build();
    RunQueryRequest.Builder expectedRequest =
        RunQueryRequest.newBuilder()
            .setReadOptions(readOption)
            .setGqlQuery(query)
            .setPartitionId(PartitionId.newBuilder().setProjectId(PROJECT_ID).build());
    EasyMock.expect(rpcMock.runQuery(expectedRequest.build()))
        .andReturn(RunQueryResponse.newBuilder().build());
    EasyMock.replay(rpcFactoryMock, rpcMock);
    Datastore datastore = rpcMockOptions.getService();
    datastore.run(
        Query.newGqlQueryBuilder("FROM * SELECT *").build(), ReadOption.readTime(timestamp));
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  @Test
  public void testToUrlSafe() {
    byte[][] invalidUtf8 =
        new byte[][] {{(byte) 0xfe}, {(byte) 0xc1, (byte) 0xbf}, {(byte) 0xc0}, {(byte) 0x80}};
    for (byte[] bytes : invalidUtf8) {
      assertFalse(ByteString.copyFrom(bytes).isValidUtf8());
      Cursor cursor = new Cursor(ByteString.copyFrom(bytes));
      assertEquals(cursor, Cursor.fromUrlSafe(cursor.toUrlSafe()));
    }
  }

  @Test
  public void testAllocateId() {
    KeyFactory keyFactory = datastore.newKeyFactory().setKind(KIND1);
    IncompleteKey pk1 = keyFactory.newKey();
    Key key1 = datastore.allocateId(pk1);
    assertEquals(key1.getProjectId(), pk1.getProjectId());
    assertEquals(key1.getNamespace(), pk1.getNamespace());
    assertEquals(key1.getAncestors(), pk1.getAncestors());
    assertEquals(key1.getKind(), pk1.getKind());
    assertTrue(key1.hasId());
    assertFalse(key1.hasName());
    assertEquals(Key.newBuilder(pk1, key1.getId()).build(), key1);

    Key key2 = datastore.allocateId(pk1);
    assertNotEquals(key1, key2);
    assertEquals(Key.newBuilder(pk1, key2.getId()).build(), key2);

    try {
      datastore.allocateId(key1);
      fail("Expecting a failure");
    } catch (IllegalArgumentException expected) {
      assertEquals(expected.getMessage(), "keys must be IncompleteKey instances");
    }
  }

  @Test
  public void testAllocateIdArray() {
    KeyFactory keyFactory = datastore.newKeyFactory().setKind(KIND1);
    IncompleteKey incompleteKey1 = keyFactory.newKey();
    IncompleteKey incompleteKey2 =
        keyFactory.setKind(KIND2).addAncestor(PathElement.of(KIND1, 10)).newKey();
    Key key3 = keyFactory.newKey("name");
    List<Key> result1 = datastore.allocateId(incompleteKey1, incompleteKey2, incompleteKey1);
    assertEquals(3, result1.size());
    assertEquals(Key.newBuilder(incompleteKey1, result1.get(0).getId()).build(), result1.get(0));
    assertEquals(Key.newBuilder(incompleteKey1, result1.get(2).getId()).build(), result1.get(2));
    assertEquals(Key.newBuilder(incompleteKey2, result1.get(1).getId()).build(), result1.get(1));

    try {
      datastore.allocateId(incompleteKey1, incompleteKey2, key3);
      fail("expecting a failure");
    } catch (IllegalArgumentException expected) {
      assertEquals(expected.getMessage(), "keys must be IncompleteKey instances");
    }
  }

  @Test
  public void testReserveIds() {
    ReserveIdsRequest reserveIdsRequest =
        ReserveIdsRequest.newBuilder().addKeys(KEY1.toPb()).build();
    EasyMock.expect(rpcMock.reserveIds(reserveIdsRequest))
        .andReturn(ReserveIdsResponse.newBuilder().build())
        .times(1);
    EasyMock.replay(rpcFactoryMock, rpcMock);
    Datastore datastore = rpcMockOptions.getService();
    datastore.reserveIds(KEY1);
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  @Test
  public void testReserveIdsWithKeys() {
    Datastore datastore = createStrictMock(Datastore.class);
    EasyMock.expect(datastore.reserveIds(KEY1, KEY2)).andReturn(Arrays.asList(KEY1, KEY2));
    replay(datastore);
    List<Key> result = datastore.reserveIds(KEY1, KEY2);
    assertEquals(KEY1, result.get(0));
    assertEquals(KEY2, result.get(1));
    verify(datastore);
  }

  @Test
  public void testGet() {
    Entity entity = datastore.get(KEY3);
    assertNull(entity);

    entity = datastore.get(KEY1);
    assertEquals(ENTITY1, entity);
    StringValue value1 = entity.getValue("str");
    assertEquals(STR_VALUE, value1);
    BooleanValue value2 = entity.getValue("bool");
    assertEquals(BOOL_VALUE, value2);
    ListValue value3 = entity.getValue("list");
    assertEquals(LIST_VALUE2, value3);
    TimestampValue value4 = entity.getValue("date");
    assertEquals(TIMESTAMP_VALUE, value4);
    LatLngValue value5 = entity.getValue("latLng");
    assertEquals(LAT_LNG_VALUE, value5);
    FullEntity<IncompleteKey> value6 = entity.getEntity("partial1");
    assertEquals(PARTIAL_ENTITY1, value6);
    ListValue value7 = entity.getValue("emptyList");
    assertEquals(EMPTY_LIST_VALUE, value7);
    assertEquals(7, entity.getNames().size());
    assertFalse(entity.contains("bla"));
  }

  @Test
  public void testLookupEventualConsistency() {
    ReadOptions readOption =
        ReadOptions.newBuilder().setReadConsistencyValue(ReadConsistency.EVENTUAL_VALUE).build();
    com.google.datastore.v1.Key key =
        com.google.datastore.v1.Key.newBuilder()
            .setPartitionId(PartitionId.newBuilder().setProjectId(PROJECT_ID).build())
            .addPath(
                com.google.datastore.v1.Key.PathElement.newBuilder()
                    .setKind("kind1")
                    .setName("name")
                    .build())
            .build();
    LookupRequest lookupRequest =
        LookupRequest.newBuilder().setReadOptions(readOption).addKeys(key).build();
    EasyMock.expect(rpcMock.lookup(lookupRequest))
        .andReturn(LookupResponse.newBuilder().build())
        .times(3);
    EasyMock.replay(rpcFactoryMock, rpcMock);
    Datastore datastore = rpcMockOptions.getService();
    datastore.get(KEY1, ReadOption.eventualConsistency());
    datastore.get(ImmutableList.of(KEY1), ReadOption.eventualConsistency());
    datastore.fetch(ImmutableList.of(KEY1), ReadOption.eventualConsistency());
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  @Test
  public void testLookupReadTime() {
    Timestamp timestamp = Timestamp.now();
    ReadOptions readOption = ReadOptions.newBuilder().setReadTime(timestamp.toProto()).build();
    com.google.datastore.v1.Key key =
        com.google.datastore.v1.Key.newBuilder()
            .setPartitionId(PartitionId.newBuilder().setProjectId(PROJECT_ID).build())
            .addPath(
                com.google.datastore.v1.Key.PathElement.newBuilder()
                    .setKind("kind1")
                    .setName("name")
                    .build())
            .build();
    LookupRequest lookupRequest =
        LookupRequest.newBuilder().setReadOptions(readOption).addKeys(key).build();
    EasyMock.expect(rpcMock.lookup(lookupRequest))
        .andReturn(LookupResponse.newBuilder().build())
        .times(3);
    EasyMock.replay(rpcFactoryMock, rpcMock);
    com.google.cloud.datastore.Datastore datastore = rpcMockOptions.getService();
    datastore.get(KEY1, com.google.cloud.datastore.ReadOption.readTime(timestamp));
    datastore.get(
        ImmutableList.of(KEY1), com.google.cloud.datastore.ReadOption.readTime(timestamp));
    datastore.fetch(
        ImmutableList.of(KEY1), com.google.cloud.datastore.ReadOption.readTime(timestamp));
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  @Test
  public void testGetArrayNoDeferredResults() {
    datastore.put(ENTITY3);
    Iterator<Entity> result =
        datastore.fetch(KEY1, Key.newBuilder(KEY1).setName("bla").build(), KEY2, KEY3).iterator();
    assertEquals(ENTITY1, result.next());
    assertNull(result.next());
    assertEquals(ENTITY2, result.next());
    Entity entity3 = result.next();
    assertEquals(ENTITY3, entity3);
    assertTrue(entity3.isNull("null"));
    assertFalse(entity3.getBoolean("bool"));
    assertEquals(LIST_VALUE2.get(), entity3.getList("list"));
    FullEntity<IncompleteKey> partial1 = entity3.getEntity("partial1");
    FullEntity<IncompleteKey> partial2 = entity3.getEntity("partial2");
    assertEquals(PARTIAL_ENTITY2, partial1);
    assertEquals(ENTITY2, partial2);
    assertEquals(ValueType.BOOLEAN, entity3.getValue("bool").getType());
    assertEquals(LAT_LNG_VALUE, entity3.getValue("latLng"));
    assertEquals(EMPTY_LIST_VALUE, entity3.getValue("emptyList"));
    assertEquals(8, entity3.getNames().size());
    assertFalse(entity3.contains("bla"));
    try {
      entity3.getString("str");
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      // expected - no such property
    }
    assertFalse(result.hasNext());
  }

  @Test
  public void testGetArrayDeferredResults() throws DatastoreException {
    Set<Key> requestedKeys = new HashSet<>();
    requestedKeys.add(KEY1);
    requestedKeys.add(KEY2);
    requestedKeys.add(KEY3);
    requestedKeys.add(KEY4);
    requestedKeys.add(KEY5);
    Iterator<Entity> iter = createDatastoreForDeferredLookup().get(KEY1, KEY2, KEY3, KEY4, KEY5);
    Set<Key> keysOfFoundEntities = new HashSet<>();
    while (iter.hasNext()) {
      keysOfFoundEntities.add(iter.next().getKey());
    }
    assertEquals(requestedKeys, keysOfFoundEntities);
  }

  @Test
  public void testFetchArrayDeferredResults() throws DatastoreException {
    List<Entity> foundEntities =
        createDatastoreForDeferredLookup().fetch(KEY1, KEY2, KEY3, KEY4, KEY5);
    assertEquals(foundEntities.get(0).getKey(), KEY1);
    assertEquals(foundEntities.get(1).getKey(), KEY2);
    assertEquals(foundEntities.get(2).getKey(), KEY3);
    assertEquals(foundEntities.get(3).getKey(), KEY4);
    assertEquals(foundEntities.get(4).getKey(), KEY5);
    assertEquals(foundEntities.size(), 5);
  }

  private Datastore createDatastoreForDeferredLookup() throws DatastoreException {
    List<com.google.datastore.v1.Key> keysPb = new ArrayList<>();
    keysPb.add(KEY1.toPb());
    keysPb.add(KEY2.toPb());
    keysPb.add(KEY3.toPb());
    keysPb.add(KEY4.toPb());
    keysPb.add(KEY5.toPb());
    List<LookupRequest> lookupRequests = new ArrayList<>();
    lookupRequests.add(LookupRequest.newBuilder().addAllKeys(keysPb).build());
    lookupRequests.add(
        LookupRequest.newBuilder()
            .addKeys(keysPb.get(1))
            .addKeys(keysPb.get(2))
            .addKeys(keysPb.get(4))
            .build());
    lookupRequests.add(LookupRequest.newBuilder().addKeys(keysPb.get(4)).build());
    Entity entity4 = Entity.newBuilder(KEY4).set("value", StringValue.of("value")).build();
    Entity entity5 = Entity.newBuilder(KEY5).set("value", "value").build();
    List<LookupResponse> lookupResponses = new ArrayList<>();
    lookupResponses.add(
        LookupResponse.newBuilder()
            .addFound(EntityResult.newBuilder().setEntity(ENTITY1.toPb()))
            .addFound(EntityResult.newBuilder().setEntity(entity4.toPb()))
            .addDeferred(keysPb.get(1))
            .addDeferred(keysPb.get(2))
            .addDeferred(keysPb.get(4))
            .build());
    lookupResponses.add(
        LookupResponse.newBuilder()
            .addFound(EntityResult.newBuilder().setEntity(ENTITY2.toPb()))
            .addFound(EntityResult.newBuilder().setEntity(ENTITY3.toPb()))
            .addDeferred(keysPb.get(4))
            .build());
    lookupResponses.add(
        LookupResponse.newBuilder()
            .addFound(EntityResult.newBuilder().setEntity(entity5.toPb()))
            .build());
    for (int i = 0; i < lookupRequests.size(); i++) {
      EasyMock.expect(rpcMock.lookup(lookupRequests.get(i))).andReturn(lookupResponses.get(i));
    }
    EasyMock.replay(rpcFactoryMock, rpcMock);
    return rpcMockOptions.getService();
  }

  @Test
  public void testAddEntity() {
    List<Entity> keys = datastore.fetch(ENTITY1.getKey(), ENTITY3.getKey());
    assertEquals(ENTITY1, keys.get(0));
    assertNull(keys.get(1));
    assertEquals(2, keys.size());

    try {
      datastore.add(ENTITY1);
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      // expected;
    }

    List<Entity> entities = datastore.add(ENTITY3, PARTIAL_ENTITY1, PARTIAL_ENTITY2);
    assertEquals(ENTITY3, datastore.get(ENTITY3.getKey()));
    assertEquals(ENTITY3, entities.get(0));
    assertEquals(PARTIAL_ENTITY1.getProperties(), entities.get(1).getProperties());
    assertEquals(PARTIAL_ENTITY1.getKey().getAncestors(), entities.get(1).getKey().getAncestors());
    assertNotNull(datastore.get(entities.get(1).getKey()));
    assertEquals(PARTIAL_ENTITY2.getProperties(), entities.get(2).getProperties());
    assertEquals(PARTIAL_ENTITY2.getKey().getAncestors(), entities.get(2).getKey().getAncestors());
    assertNotNull(datastore.get(entities.get(2).getKey()));
  }

  @Test
  public void testUpdate() {
    List<Entity> keys = datastore.fetch(ENTITY1.getKey(), ENTITY3.getKey());
    assertEquals(ENTITY1, keys.get(0));
    assertNull(keys.get(1));
    assertEquals(2, keys.size());

    try {
      datastore.update(ENTITY3);
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      // expected;
    }
    datastore.add(ENTITY3);
    assertEquals(ENTITY3, datastore.get(ENTITY3.getKey()));
    Entity entity3 = Entity.newBuilder(ENTITY3).clear().set("bla", new NullValue()).build();
    assertNotEquals(ENTITY3, entity3);
    datastore.update(entity3);
    assertEquals(entity3, datastore.get(ENTITY3.getKey()));
  }

  @Test
  public void testPut() {
    Entity updatedEntity = Entity.newBuilder(ENTITY1).set("new_property", 42L).build();
    assertEquals(updatedEntity, datastore.put(updatedEntity));
    assertEquals(updatedEntity, datastore.get(updatedEntity.getKey()));

    Entity entity2 = Entity.newBuilder(ENTITY2).clear().set("bla", new NullValue()).build();
    assertNotEquals(ENTITY2, entity2);
    List<Entity> entities = datastore.put(ENTITY1, entity2, ENTITY3, PARTIAL_ENTITY1);
    assertEquals(ENTITY1, entities.get(0));
    assertEquals(entity2, entities.get(1));
    assertEquals(ENTITY3, entities.get(2));
    assertEquals(PARTIAL_ENTITY1.getProperties(), entities.get(3).getProperties());
    assertEquals(PARTIAL_ENTITY1.getKey().getAncestors(), entities.get(3).getKey().getAncestors());
    assertEquals(ENTITY1, datastore.get(ENTITY1.getKey()));
    assertEquals(entity2, datastore.get(entity2.getKey()));
    assertEquals(ENTITY3, datastore.get(ENTITY3.getKey()));
    Entity entity = datastore.get(entities.get(3).getKey());
    assertEquals(entities.get(3), entity);
  }

  @Test
  public void testDelete() {
    Iterator<Entity> keys =
        datastore.fetch(ENTITY1.getKey(), ENTITY2.getKey(), ENTITY3.getKey()).iterator();
    assertEquals(ENTITY1, keys.next());
    assertEquals(ENTITY2, keys.next());
    assertNull(keys.next());
    assertFalse(keys.hasNext());
    datastore.delete(ENTITY1.getKey(), ENTITY2.getKey(), ENTITY3.getKey());
    keys = datastore.fetch(ENTITY1.getKey(), ENTITY2.getKey(), ENTITY3.getKey()).iterator();
    assertNull(keys.next());
    assertNull(keys.next());
    assertNull(keys.next());
    assertFalse(keys.hasNext());
  }

  @Test
  public void testKeyFactory() {
    KeyFactory keyFactory = datastore.newKeyFactory().setKind(KIND1);
    assertEquals(INCOMPLETE_KEY1, keyFactory.newKey());
    assertEquals(
        IncompleteKey.newBuilder(INCOMPLETE_KEY1).setKind(KIND2).build(),
        datastore.newKeyFactory().setKind(KIND2).newKey());
    assertEquals(KEY1, keyFactory.newKey("name"));
    assertEquals(Key.newBuilder(KEY1).setId(2).build(), keyFactory.newKey(2));
  }

  @Test
  public void testRetryableException() {
    LookupRequest requestPb = LookupRequest.newBuilder().addKeys(KEY1.toPb()).build();
    LookupResponse responsePb =
        LookupResponse.newBuilder()
            .addFound(EntityResult.newBuilder().setEntity(ENTITY1.toPb()))
            .build();
    EasyMock.expect(rpcMock.lookup(requestPb))
        .andThrow(new DatastoreException(14, "UNAVAILABLE", "UNAVAILABLE", null))
        .andReturn(responsePb);
    EasyMock.replay(rpcFactoryMock, rpcMock);
    Datastore datastore = rpcMockOptions.getService();
    Entity entity = datastore.get(KEY1);
    assertEquals(ENTITY1, entity);
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  @Test
  public void testRetryableExceptionForOperationWithTxn() {
    ByteString txnBytes = ByteString.copyFromUtf8("txn1");
    LookupRequest requestPb =
        LookupRequest.newBuilder()
            .addKeys(KEY1.toPb())
            .setReadOptions(ReadOptions.newBuilder().setTransaction(txnBytes).build())
            .build();
    LookupResponse responsePb =
        LookupResponse.newBuilder()
            .addFound(EntityResult.newBuilder().setEntity(ENTITY1.toPb()))
            .build();
    EasyMock.expect(rpcMock.beginTransaction(EasyMock.anyObject(BeginTransactionRequest.class)))
        .andReturn(BeginTransactionResponse.newBuilder().setTransaction(txnBytes).build());
    EasyMock.expect(rpcMock.lookup(requestPb))
        .andThrow(new DatastoreException(14, "UNAVAILABLE", "UNAVAILABLE", null))
        .andReturn(responsePb);
    EasyMock.replay(rpcFactoryMock, rpcMock);
    Datastore datastore = rpcMockOptions.getService();
    Transaction transaction = datastore.newTransaction();
    Entity entity = transaction.get(KEY1);
    assertEquals(ENTITY1, entity);
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  @Test
  public void testNonRetryableExceptionForOperationWithTxn() {
    ByteString txnBytes = ByteString.copyFromUtf8("txn1");
    LookupRequest requestPb =
        LookupRequest.newBuilder()
            .addKeys(KEY1.toPb())
            .setReadOptions(ReadOptions.newBuilder().setTransaction(txnBytes).build())
            .build();
    EasyMock.expect(rpcMock.beginTransaction(EasyMock.anyObject(BeginTransactionRequest.class)))
        .andReturn(BeginTransactionResponse.newBuilder().setTransaction(txnBytes).build());
    EasyMock.expect(rpcMock.lookup(requestPb))
        .andThrow(new DatastoreException(10, "ABORTED", "ABORTED", null))
        .times(1);
    EasyMock.replay(rpcFactoryMock, rpcMock);
    try {
      Datastore datastore = rpcMockOptions.getService();
      Transaction transaction = datastore.newTransaction();
      transaction.get(KEY1);
      Assert.fail();
      EasyMock.verify(rpcFactoryMock, rpcMock);
    } catch (DatastoreException ex) {
      assertEquals("ABORTED", ex.getMessage());
    }
  }

  @Test
  public void testNonRetryableException() {
    LookupRequest requestPb = LookupRequest.newBuilder().addKeys(KEY1.toPb()).build();
    EasyMock.expect(rpcMock.lookup(requestPb))
        .andThrow(
            new DatastoreException(DatastoreException.UNKNOWN_CODE, "denied", "PERMISSION_DENIED"))
        .times(1);
    EasyMock.replay(rpcFactoryMock, rpcMock);
    try {
      Datastore datastore = rpcMockOptions.getService();
      datastore.get(KEY1);
      Assert.fail();
      EasyMock.verify(rpcFactoryMock, rpcMock);
    } catch (DatastoreException ex) {
      assertEquals("denied", ex.getMessage());
    }
  }

  @Test
  public void testRuntimeException() {
    LookupRequest requestPb = LookupRequest.newBuilder().addKeys(KEY1.toPb()).build();
    String exceptionMessage = "Artificial runtime exception";
    EasyMock.expect(rpcMock.lookup(requestPb)).andThrow(new RuntimeException(exceptionMessage));
    EasyMock.replay(rpcFactoryMock, rpcMock);
    try {
      Datastore datastore = rpcMockOptions.getService();
      datastore.get(KEY1);
      Assert.fail();
      EasyMock.verify(rpcFactoryMock, rpcMock);
    } catch (DatastoreException ex) {
      assertEquals(exceptionMessage, ex.getCause().getMessage());
    }
  }

  @Test
  public void testGqlQueryWithNullBinding() {
    Query<Entity> query =
        Query.newGqlQueryBuilder(ResultType.ENTITY, "select * from " + KIND1)
            .setNullBinding("name")
            .build();
    Iterator<Entity> results = datastore.run(query);
    assertTrue(results.hasNext());
    assertEquals(ENTITY1, results.next());
    assertFalse(results.hasNext());

    Query<Entity> gqlQuery =
        Query.newGqlQueryBuilder(ResultType.ENTITY, "select * from " + KIND1)
            .setNullBinding("name")
            .build();
    Iterator<Entity> queryResults = datastore.run(gqlQuery);
    int count = 0;
    while (queryResults.hasNext()) {
      queryResults.next();
      count++;
    }
    assertEquals(1, count);
  }

  @Test
  public void testQueryWithStartCursor() {
    Entity entity1 =
        Entity.newBuilder(Key.newBuilder(PROJECT_ID, KIND1, "name-01").build()).build();
    Entity entity2 =
        Entity.newBuilder(Key.newBuilder(PROJECT_ID, KIND1, "name-02").build()).build();
    Entity entity3 =
        Entity.newBuilder(Key.newBuilder(PROJECT_ID, KIND1, "name-03").build()).build();
    datastore.put(entity1, entity2, entity3);
    QueryResults<Entity> run1 = datastore.run(Query.newEntityQueryBuilder().setKind(KIND1).build());
    run1.next();
    Cursor cursor1 = run1.getCursorAfter();
    assertNotNull(cursor1);
    QueryResults<Entity> run2 =
        datastore.run(Query.newEntityQueryBuilder().setKind(KIND1).setStartCursor(cursor1).build());
    Cursor cursor2 = run2.getCursorAfter();
    assertNotNull(cursor2);
    assertEquals(cursor2, cursor1);
    datastore.delete(entity1.getKey(), entity2.getKey(), entity3.getKey());
  }
}
