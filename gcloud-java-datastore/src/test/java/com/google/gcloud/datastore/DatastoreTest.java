/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.datastore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.common.collect.Iterators;
import com.google.gcloud.RetryParams;
import com.google.gcloud.datastore.Query.ResultType;
import com.google.gcloud.datastore.StructuredQuery.OrderBy;
import com.google.gcloud.datastore.StructuredQuery.PropertyFilter;
import com.google.gcloud.datastore.testing.LocalGcdHelper;
import com.google.gcloud.spi.DatastoreRpc;
import com.google.gcloud.spi.DatastoreRpcFactory;
import com.google.protobuf.ByteString;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RunWith(JUnit4.class)
public class DatastoreTest {

  private static final String PROJECT_ID = LocalGcdHelper.DEFAULT_PROJECT_ID;
  private static final String KIND1 = "kind1";
  private static final String KIND2 = "kind2";
  private static final String KIND3 = "kind3";
  private static final NullValue NULL_VALUE = NullValue.of();
  private static final StringValue STR_VALUE = StringValue.of("str");
  private static final BooleanValue BOOL_VALUE = BooleanValue.builder(false)
      .excludeFromIndexes(true).build();
  private static final IncompleteKey INCOMPLETE_KEY1 =
      IncompleteKey.builder(PROJECT_ID, KIND1).build();
  private static final IncompleteKey INCOMPLETE_KEY2 =
      IncompleteKey.builder(PROJECT_ID, KIND2).build();
  private static final Key KEY1 = Key.builder(INCOMPLETE_KEY1, "name").build();
  private static final Key KEY2 = Key.builder(KEY1, KIND2, 1).build();
  private static final Key KEY3 = Key.builder(KEY2).name("bla").build();
  private static final Key KEY4 = Key.builder(KEY2).name("newName1").build();
  private static final Key KEY5 = Key.builder(KEY2).name("newName2").build();
  private static final KeyValue KEY_VALUE = KeyValue.of(KEY1);
  private static final ListValue LIST_VALUE1 = ListValue.builder()
      .addValue(NULL_VALUE)
      .addValue(STR_VALUE, BOOL_VALUE)
      .build();
  private static final ListValue LIST_VALUE2 = ListValue.of(Collections.singletonList(KEY_VALUE));
  private static final DateTimeValue DATE_TIME_VALUE = new DateTimeValue(DateTime.now());
  private static final LatLngValue LAT_LNG_VALUE =
      new LatLngValue(new LatLng(37.422035, -122.084124));
  private static final FullEntity<IncompleteKey> PARTIAL_ENTITY1 =
      FullEntity.builder(INCOMPLETE_KEY2).set("str", STR_VALUE).set("bool", BOOL_VALUE)
          .set("list", LIST_VALUE1).build();
  private static final FullEntity<IncompleteKey> PARTIAL_ENTITY2 =
      FullEntity.builder(PARTIAL_ENTITY1).remove("str").set("bool", true).
          set("list", LIST_VALUE1.get()).build();
  private static final FullEntity<IncompleteKey> PARTIAL_ENTITY3 =
      FullEntity.builder(PARTIAL_ENTITY1).key(IncompleteKey.builder(PROJECT_ID, KIND3).build())
          .build();
  private static final Entity ENTITY1 =
      Entity.builder(KEY1)
          .set("str", STR_VALUE)
          .set("date", DATE_TIME_VALUE)
          .set("latLng", LAT_LNG_VALUE)
          .set("bool", BOOL_VALUE)
          .set("partial1", EntityValue.of(PARTIAL_ENTITY1))
          .set("list", LIST_VALUE2)
          .build();
  private static final Entity ENTITY2 = Entity.builder(ENTITY1).key(KEY2).remove("str")
      .set("name", "Dan").setNull("null").set("age", 20).build();
  private static final Entity ENTITY3 = Entity.builder(ENTITY1).key(KEY3).remove("str")
      .set("null", NULL_VALUE).set("partial1", PARTIAL_ENTITY2).set("partial2", ENTITY2).build();

  private DatastoreOptions options;
  private Datastore datastore;

  private static LocalGcdHelper gcdHelper;
  private static final int PORT = LocalGcdHelper.findAvailablePort(LocalGcdHelper.DEFAULT_PORT);

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @BeforeClass
  public static void beforeClass() throws IOException, InterruptedException {
    if (!LocalGcdHelper.isActive(PROJECT_ID, PORT)) {
      gcdHelper = LocalGcdHelper.start(PROJECT_ID, PORT);
    }
  }

  @Before
  public void setUp() {
    options = DatastoreOptions.builder()
        .projectId(PROJECT_ID)
        .host("localhost:" + PORT)
        .retryParams(RetryParams.noRetries())
        .build();
    datastore = options.service();
    StructuredQuery<Key> query = Query.keyQueryBuilder().build();
    QueryResults<Key> result = datastore.run(query);
    datastore.delete(Iterators.toArray(result, Key.class));
    datastore.add(ENTITY1, ENTITY2);
  }

  @AfterClass
  public static void afterClass() throws IOException, InterruptedException {
    if (gcdHelper != null) {
      gcdHelper.stop();
    }
  }

  @Test
  public void testGetOptions() {
    assertSame(options, datastore.options());
  }

  @Test
  public void testNewTransactionCommit() {
    Transaction transaction = datastore.newTransaction();
    transaction.add(ENTITY3);
    Entity entity2 = Entity.builder(ENTITY2)
        .clear()
        .setNull("bla")
        .build();
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
    datastore.put(Entity.builder(ENTITY3).clear().build());
    transaction.update(ENTITY2);
    try {
      transaction.commit();
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      assertEquals("ABORTED", expected.reason());
    }
  }

  @Test
  public void testTransactionWithQuery() {
    Query<Entity> query = Query.entityQueryBuilder()
        .kind(KIND2)
        .filter(PropertyFilter.hasAncestor(KEY2))
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
    transaction.delete(ENTITY3.key());
    // update entity2 during the transaction
    datastore.put(Entity.builder(ENTITY2).clear().build());
    try {
      transaction.commit();
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      assertEquals("ABORTED", expected.reason());
    }
  }

  @Test
  public void testNewTransactionRollback() {
    Transaction transaction = datastore.newTransaction();
    transaction.add(ENTITY3);
    Entity entity2 = Entity.builder(ENTITY2).clear().setNull("bla")
        .set("list3", StringValue.of("bla"), StringValue.builder("bla").build()).build();
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
      writer.delete(ENTITY3.key());
      fail("Expecting a failure");
    } catch (DatastoreException ex) {
      // expected to fail
    }
  }

  @Test
  public void testNewBatch() {
    Batch batch = datastore.newBatch();
    Entity entity1 = Entity.builder(ENTITY1).clear().build();
    Entity entity2 = Entity.builder(ENTITY2).clear().setNull("bla").build();
    Entity entity4 = Entity.builder(KEY4).set("value", StringValue.of("value")).build();
    Entity entity5 = Entity.builder(KEY5).set("value", "value").build();

    List<Entity> entities = batch.add(entity4, PARTIAL_ENTITY2, entity5);
    Entity entity6 = entities.get(1);
    assertSame(entity4, entities.get(0));
    assertEquals(PARTIAL_ENTITY2.properties(), entity6.properties());
    assertEquals(PARTIAL_ENTITY2.key().projectId(), entity6.key().projectId());
    assertEquals(PARTIAL_ENTITY2.key().namespace(), entity6.key().namespace());
    assertEquals(PARTIAL_ENTITY2.key().ancestors(), entity6.key().ancestors());
    assertEquals(PARTIAL_ENTITY2.key().kind(), entity6.key().kind());
    assertEquals(PARTIAL_ENTITY2.key(), IncompleteKey.builder(entity6.key()).build());
    assertNotEquals(PARTIAL_ENTITY2.key().path(), entity6.key().path());
    assertNotEquals(PARTIAL_ENTITY2.key(), entity6.key());
    assertSame(entity5, entities.get(2));
    batch.addWithDeferredIdAllocation(PARTIAL_ENTITY3);
    batch.put(ENTITY3, entity1, entity2);

    Batch.Response response = batch.submit();
    entities = datastore.fetch(KEY1, KEY2, KEY3, entity4.key(), entity5.key(), entity6.key());
    assertEquals(entity1, entities.get(0));
    assertEquals(entity2, entities.get(1));
    assertEquals(ENTITY3, entities.get(2));
    assertEquals(entity4, entities.get(3));
    assertEquals(entity5, entities.get(4));
    assertEquals(entity6, entities.get(5));
    assertEquals(6, entities.size());
    List<Key> generatedKeys = response.generatedKeys();
    assertEquals(1, generatedKeys.size());
    assertEquals(PARTIAL_ENTITY3.properties(), datastore.get(generatedKeys.get(0)).properties());
    assertEquals(PARTIAL_ENTITY3.key(), IncompleteKey.builder(generatedKeys.get(0)).build());

    try {
      batch.submit();
      fail("Expecting a failure");
    } catch (DatastoreException ex) {
      // expected to fail
    }
    verifyNotUsable(batch);

    batch = datastore.newBatch();
    batch.delete(entity4.key(), entity5.key());
    batch.update(ENTITY1, ENTITY2, ENTITY3);
    batch.submit();
    entities = datastore.fetch(KEY1, KEY2, KEY3, entity4.key(), entity5.key());
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
        Query.gqlQueryBuilder(ResultType.ENTITY, "select * from " + KIND1).build();
    QueryResults<Entity> results1 = datastore.run(query1);
    assertTrue(results1.hasNext());
    assertEquals(ENTITY1, results1.next());
    assertFalse(results1.hasNext());

    datastore.put(ENTITY3);
    Query<? extends Entity> query2 =  Query.gqlQueryBuilder(
        ResultType.ENTITY, "select * from " + KIND2 + " order by __key__").build();
    QueryResults<? extends Entity> results2 = datastore.run(query2);
    assertTrue(results2.hasNext());
    assertEquals(ENTITY2, results2.next());
    assertTrue(results2.hasNext());
    assertEquals(ENTITY3, results2.next());
    assertFalse(results2.hasNext());

    query1 = Query.gqlQueryBuilder(ResultType.ENTITY, "select * from bla").build();
    results1 = datastore.run(query1);
    assertFalse(results1.hasNext());

    Query<Key> keyOnlyQuery =
        Query.gqlQueryBuilder(ResultType.KEY, "select __key__ from " + KIND1).build();
    QueryResults<Key> keyOnlyResults = datastore.run(keyOnlyQuery);
    assertTrue(keyOnlyResults.hasNext());
    assertEquals(KEY1, keyOnlyResults.next());
    assertFalse(keyOnlyResults.hasNext());

    GqlQuery<ProjectionEntity> keyProjectionQuery = Query.gqlQueryBuilder(
        ResultType.PROJECTION_ENTITY, "select __key__ from " + KIND1).build();
    QueryResults<ProjectionEntity> keyProjectionResult = datastore.run(keyProjectionQuery);
    assertTrue(keyProjectionResult.hasNext());
    ProjectionEntity projectionEntity = keyProjectionResult.next();
    assertEquals(KEY1, projectionEntity.key());
    assertTrue(projectionEntity.properties().isEmpty());
    assertFalse(keyProjectionResult.hasNext());

    GqlQuery<ProjectionEntity> projectionQuery = Query.gqlQueryBuilder(
        ResultType.PROJECTION_ENTITY, "select str, date from " + KIND1).build();

    QueryResults<ProjectionEntity> projectionResult = datastore.run(projectionQuery);
    assertTrue(projectionResult.hasNext());
    projectionEntity = projectionResult.next();
    assertEquals("str", projectionEntity.getString("str"));
    assertEquals(DATE_TIME_VALUE.get(), projectionEntity.getDateTime("date"));
    assertEquals(DATE_TIME_VALUE.get().timestampMicroseconds(),
        projectionEntity.getLong("date"));
    assertEquals(2, projectionEntity.names().size());
    assertFalse(projectionResult.hasNext());
  }

  @Test
  public void testRunGqlQueryWithCasting() {
    @SuppressWarnings("unchecked")
    Query<Entity> query1 =
        (Query<Entity>) Query.gqlQueryBuilder("select * from " + KIND1).build();
    QueryResults<Entity> results1 = datastore.run(query1);
    assertTrue(results1.hasNext());
    assertEquals(ENTITY1, results1.next());
    assertFalse(results1.hasNext());

    Query<?> query2 = Query.gqlQueryBuilder("select * from " + KIND1).build();
    QueryResults<?> results2 = datastore.run(query2);
    assertSame(Entity.class, results2.resultClass());
    @SuppressWarnings("unchecked")
    QueryResults<Entity> results3 = (QueryResults<Entity>) results2;
    assertTrue(results3.hasNext());
    assertEquals(ENTITY1, results3.next());
    assertFalse(results3.hasNext());
  }

  @Test
  public void testGqlQueryPagination() throws DatastoreException {
    DatastoreRpcFactory rpcFactoryMock = EasyMock.createStrictMock(DatastoreRpcFactory.class);
    DatastoreRpc rpcMock = EasyMock.createStrictMock(DatastoreRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(DatastoreOptions.class)))
        .andReturn(rpcMock);
    List<com.google.datastore.v1beta3.RunQueryResponse> responses =
        buildResponsesForQueryPagination();
    for (int i = 0; i < responses.size(); i++) {
        EasyMock
            .expect(rpcMock.runQuery(
                EasyMock.anyObject(com.google.datastore.v1beta3.RunQueryRequest.class)))
            .andReturn(responses.get(i));
    }
    EasyMock.replay(rpcFactoryMock, rpcMock);
    DatastoreOptions options = this.options.toBuilder()
        .retryParams(RetryParams.defaultInstance())
        .serviceRpcFactory(rpcFactoryMock)
        .build();
    Datastore mockDatastore = options.service();
    QueryResults<Key> results =
        mockDatastore.run(Query.gqlQueryBuilder(ResultType.KEY, "select __key__ from *").build());
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
        Query.entityQueryBuilder().kind(KIND1).orderBy(OrderBy.asc("__key__")).build();
    QueryResults<Entity> results1 = datastore.run(query);
    assertTrue(results1.hasNext());
    assertEquals(ENTITY1, results1.next());
    assertFalse(results1.hasNext());

    Query<Key> keyOnlyQuery =  Query.keyQueryBuilder().kind(KIND1).build();
    QueryResults<Key> results2 = datastore.run(keyOnlyQuery);
    assertTrue(results2.hasNext());
    assertEquals(ENTITY1.key(), results2.next());
    assertFalse(results2.hasNext());

    StructuredQuery<ProjectionEntity> keyOnlyProjectionQuery =
        Query.projectionEntityQueryBuilder()
        .kind(KIND1).projection("__key__").build();
    QueryResults<ProjectionEntity> results3 = datastore.run(keyOnlyProjectionQuery);
    assertTrue(results3.hasNext());
    ProjectionEntity projectionEntity = results3.next();
    assertEquals(ENTITY1.key(), projectionEntity.key());
    assertTrue(projectionEntity.names().isEmpty());
    assertFalse(results2.hasNext());

    StructuredQuery<ProjectionEntity> projectionQuery =
        Query.projectionEntityQueryBuilder()
            .kind(KIND2)
            .projection("age")
            .filter(PropertyFilter.gt("age", 18))
            .distinctOn("age")
            .orderBy(OrderBy.asc("age"))
            .limit(10)
            .build();

    QueryResults<ProjectionEntity> results4 = datastore.run(projectionQuery);
    assertTrue(results4.hasNext());
    ProjectionEntity entity = results4.next();
    assertEquals(ENTITY2.key(), entity.key());
    assertEquals(20, entity.getLong("age"));
    assertEquals(1, entity.properties().size());
    assertFalse(results4.hasNext());
  }

  @Test
  public void testStructuredQueryPagination() throws DatastoreException {
    DatastoreRpcFactory rpcFactoryMock = EasyMock.createStrictMock(DatastoreRpcFactory.class);
    DatastoreRpc rpcMock = EasyMock.createStrictMock(DatastoreRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(DatastoreOptions.class)))
        .andReturn(rpcMock);
    List<com.google.datastore.v1beta3.RunQueryResponse> responses =
        buildResponsesForQueryPagination();
    for (int i = 0; i < responses.size(); i++) {
        EasyMock
            .expect(rpcMock.runQuery(
                EasyMock.anyObject(com.google.datastore.v1beta3.RunQueryRequest.class)))
            .andReturn(responses.get(i));
    }
    EasyMock.replay(rpcFactoryMock, rpcMock);
    DatastoreOptions options = this.options.toBuilder()
        .retryParams(RetryParams.defaultInstance())
        .serviceRpcFactory(rpcFactoryMock)
        .build();
    Datastore mockDatastore = options.service();
    QueryResults<Key> results = mockDatastore.run(Query.keyQueryBuilder().build());
    int count = 0;
    while (results.hasNext()) {
      count += 1;
      results.next();
    }
    assertEquals(count, 5);
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  private List<com.google.datastore.v1beta3.RunQueryResponse> buildResponsesForQueryPagination() {
    Entity entity4 = Entity.builder(KEY4).set("value", StringValue.of("value")).build();
    Entity entity5 = Entity.builder(KEY5).set("value", "value").build();
    datastore.add(ENTITY3, entity4, entity5);
    List<com.google.datastore.v1beta3.RunQueryResponse> responses = new ArrayList<>();
    Query<Key> query = Query.keyQueryBuilder().build();
    com.google.datastore.v1beta3.RunQueryRequest.Builder requestPb =
        com.google.datastore.v1beta3.RunQueryRequest.newBuilder();
    query.populatePb(requestPb);
    com.google.datastore.v1beta3.QueryResultBatch queryResultBatchPb =
        com.google.datastore.v1beta3.RunQueryResponse.newBuilder()
            .mergeFrom(((DatastoreImpl) datastore).runQuery(requestPb.build()))
            .getBatch();
    com.google.datastore.v1beta3.QueryResultBatch queryResultBatchPb1 =
        com.google.datastore.v1beta3.QueryResultBatch.newBuilder()
            .mergeFrom(queryResultBatchPb)
            .setMoreResults(
                com.google.datastore.v1beta3.QueryResultBatch.MoreResultsType.NOT_FINISHED)
            .clearEntityResults()
            .addAllEntityResults(queryResultBatchPb.getEntityResultsList().subList(0, 1))
            .setEndCursor(queryResultBatchPb.getEntityResultsList().get(0).getCursor())
            .build();
    responses.add(
        com.google.datastore.v1beta3.RunQueryResponse.newBuilder()
            .setBatch(queryResultBatchPb1)
            .build());
    com.google.datastore.v1beta3.QueryResultBatch queryResultBatchPb2 =
        com.google.datastore.v1beta3.QueryResultBatch.newBuilder()
            .mergeFrom(queryResultBatchPb)
            .setMoreResults(
                com.google.datastore.v1beta3.QueryResultBatch.MoreResultsType.NOT_FINISHED)
            .clearEntityResults()
            .addAllEntityResults(queryResultBatchPb.getEntityResultsList().subList(1, 3))
            .setEndCursor(queryResultBatchPb.getEntityResultsList().get(2).getCursor())
            .build();
    responses.add(
        com.google.datastore.v1beta3.RunQueryResponse.newBuilder()
            .setBatch(queryResultBatchPb2)
            .build());
    com.google.datastore.v1beta3.QueryResultBatch queryResultBatchPb3 =
        com.google.datastore.v1beta3.QueryResultBatch.newBuilder()
            .mergeFrom(queryResultBatchPb)
            .setMoreResults(
                com.google.datastore.v1beta3.QueryResultBatch.MoreResultsType.NO_MORE_RESULTS)
            .clearEntityResults()
            .addAllEntityResults(queryResultBatchPb.getEntityResultsList().subList(3, 5))
            .setEndCursor(queryResultBatchPb.getEntityResultsList().get(4).getCursor())
            .build();
    responses.add(
        com.google.datastore.v1beta3.RunQueryResponse.newBuilder()
            .setBatch(queryResultBatchPb3)
            .build());
    return responses;
  }

  public void testQueryPaginationWithLimit() throws DatastoreException {
    DatastoreRpcFactory rpcFactoryMock = EasyMock.createStrictMock(DatastoreRpcFactory.class);
    DatastoreRpc rpcMock = EasyMock.createStrictMock(DatastoreRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(DatastoreOptions.class)))
        .andReturn(rpcMock);
    List<com.google.datastore.v1beta3.RunQueryResponse> responses =
        buildResponsesForQueryPaginationWithLimit();
    for (int i = 0; i < responses.size(); i++) {
      EasyMock.expect(
              rpcMock.runQuery(
                  EasyMock.anyObject(com.google.datastore.v1beta3.RunQueryRequest.class)))
          .andReturn(responses.get(i));
    }
    EasyMock.replay(rpcFactoryMock, rpcMock);
    Datastore mockDatastore = options.toBuilder()
        .retryParams(RetryParams.defaultInstance())
        .serviceRpcFactory(rpcFactoryMock)
        .build()
        .service();
    int limit = 2;
    int totalCount = 0;
    StructuredQuery<Entity> query = Query.entityQueryBuilder().limit(limit).build();
    while (true) {
      QueryResults<Entity> results = mockDatastore.run(query);
      int resultCount = 0;
      while (results.hasNext()) {
        results.next();
        resultCount++;
        totalCount++;
      }
      if (resultCount < limit) {
        break;
      }
      query = query.toBuilder().startCursor(results.cursorAfter()).build();
    }
    assertEquals(5, totalCount);
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  private List<com.google.datastore.v1beta3.RunQueryResponse>
      buildResponsesForQueryPaginationWithLimit() {
    Entity entity4 = Entity.builder(KEY4).set("value", StringValue.of("value")).build();
    Entity entity5 = Entity.builder(KEY5).set("value", "value").build();
    datastore.add(ENTITY3, entity4, entity5);
    List<com.google.datastore.v1beta3.RunQueryResponse> responses = new ArrayList<>();
    Query<Entity> query = Query.entityQueryBuilder().build();
    com.google.datastore.v1beta3.RunQueryRequest.Builder requestPb =
        com.google.datastore.v1beta3.RunQueryRequest.newBuilder();
    query.populatePb(requestPb);
    com.google.datastore.v1beta3.QueryResultBatch queryResultBatchPb =
        com.google.datastore.v1beta3.RunQueryResponse.newBuilder()
            .mergeFrom(((DatastoreImpl) datastore).runQuery(requestPb.build()))
            .getBatch();
    com.google.datastore.v1beta3.QueryResultBatch queryResultBatchPb1 =
        com.google.datastore.v1beta3.QueryResultBatch.newBuilder()
            .mergeFrom(queryResultBatchPb)
            .setMoreResults(
                com.google.datastore.v1beta3.QueryResultBatch.MoreResultsType.NOT_FINISHED)
            .clearEntityResults()
            .addAllEntityResults(queryResultBatchPb.getEntityResultsList().subList(0, 1))
            .setEndCursor(queryResultBatchPb.getEntityResultsList().get(0).getCursor())
            .build();
    responses.add(
        com.google.datastore.v1beta3.RunQueryResponse.newBuilder()
            .setBatch(queryResultBatchPb1)
            .build());
    com.google.datastore.v1beta3.QueryResultBatch queryResultBatchPb2 =
        com.google.datastore.v1beta3.QueryResultBatch.newBuilder()
            .mergeFrom(queryResultBatchPb)
            .setMoreResults(
                com.google.datastore.v1beta3.QueryResultBatch.MoreResultsType
                    .MORE_RESULTS_AFTER_LIMIT)
            .clearEntityResults()
            .addAllEntityResults(queryResultBatchPb.getEntityResultsList().subList(1, 2))
            .setEndCursor(
                ByteString.copyFrom(new byte[] {(byte) 0x80})) // test invalid UTF-8 string
            .build();
    responses.add(
        com.google.datastore.v1beta3.RunQueryResponse.newBuilder()
            .setBatch(queryResultBatchPb2)
            .build());
    com.google.datastore.v1beta3.QueryResultBatch queryResultBatchPb3 =
        com.google.datastore.v1beta3.QueryResultBatch.newBuilder()
            .mergeFrom(queryResultBatchPb)
            .setMoreResults(
                com.google.datastore.v1beta3.QueryResultBatch.MoreResultsType
                    .MORE_RESULTS_AFTER_LIMIT)
            .clearEntityResults()
            .addAllEntityResults(queryResultBatchPb.getEntityResultsList().subList(2, 4))
            .setEndCursor(queryResultBatchPb.getEntityResultsList().get(3).getCursor())
            .build();
    responses.add(
        com.google.datastore.v1beta3.RunQueryResponse.newBuilder()
            .setBatch(queryResultBatchPb3)
            .build());
    com.google.datastore.v1beta3.QueryResultBatch queryResultBatchPb4 =
        com.google.datastore.v1beta3.QueryResultBatch.newBuilder()
            .mergeFrom(queryResultBatchPb)
            .setMoreResults(
                com.google.datastore.v1beta3.QueryResultBatch.MoreResultsType.NO_MORE_RESULTS)
            .clearEntityResults()
            .addAllEntityResults(queryResultBatchPb.getEntityResultsList().subList(4, 5))
            .setEndCursor(queryResultBatchPb.getEntityResultsList().get(4).getCursor())
            .build();
    responses.add(
        com.google.datastore.v1beta3.RunQueryResponse.newBuilder()
            .setBatch(queryResultBatchPb4)
            .build());
    return responses;
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
    KeyFactory keyFactory = datastore.newKeyFactory().kind(KIND1);
    IncompleteKey pk1 = keyFactory.newKey();
    Key key1 = datastore.allocateId(pk1);
    assertEquals(key1.projectId(), pk1.projectId());
    assertEquals(key1.namespace(), pk1.namespace());
    assertEquals(key1.ancestors(), pk1.ancestors());
    assertEquals(key1.kind(), pk1.kind());
    assertTrue(key1.hasId());
    assertFalse(key1.hasName());
    assertEquals(Key.builder(pk1, key1.id()).build(), key1);

    Key key2 = datastore.allocateId(pk1);
    assertNotEquals(key1, key2);
    assertEquals(Key.builder(pk1, key2.id()).build(), key2);

    Key key3 = datastore.allocateId(key1);
    assertNotEquals(key1, key3);
    assertEquals(Key.builder(pk1, key3.id()).build(), key3);
  }

  @Test
  public void testAllocateIdArray() {
    KeyFactory keyFactory = datastore.newKeyFactory().kind(KIND1);
    IncompleteKey incompleteKey1 = keyFactory.newKey();
    IncompleteKey incompleteKey2 =
        keyFactory.kind(KIND2).ancestors(PathElement.of(KIND1, 10)).newKey();
    Key key3 = keyFactory.newKey("name");
    Key key4 = keyFactory.newKey(1);
    List<Key> result =
        datastore.allocateId(incompleteKey1, incompleteKey2, key3, key4, incompleteKey1, key3);
    assertEquals(6, result.size());
    assertEquals(Key.builder(incompleteKey1, result.get(0).id()).build(), result.get(0));
    assertEquals(Key.builder(incompleteKey1, result.get(4).id()).build(), result.get(4));
    assertEquals(Key.builder(incompleteKey2, result.get(1).id()).build(), result.get(1));
    assertEquals(Key.builder(key3).id(result.get(2).id()).build(), result.get(2));
    assertEquals(Key.builder(key3).id(result.get(5).id()).build(), result.get(5));
    assertEquals(Key.builder(key4).id(result.get(3).id()).build(), result.get(3));
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
    DateTimeValue value4 = entity.getValue("date");
    assertEquals(DATE_TIME_VALUE, value4);
    LatLngValue value5 = entity.getValue("latLng");
    assertEquals(LAT_LNG_VALUE, value5);
    FullEntity<IncompleteKey> value6 = entity.getEntity("partial1");
    assertEquals(PARTIAL_ENTITY1, value6);
    assertEquals(6, entity.names().size());
    assertFalse(entity.contains("bla"));
  }

  @Test
  public void testGetArrayNoDeferredResults() {
    datastore.put(ENTITY3);
    Iterator<Entity> result =
        datastore.fetch(KEY1, Key.builder(KEY1).name("bla").build(), KEY2, KEY3).iterator();
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
    assertEquals(ValueType.BOOLEAN, entity3.getValue("bool").type());
    assertEquals(LAT_LNG_VALUE, entity3.getValue("latLng"));
    assertEquals(7, entity3.names().size());
    assertFalse(entity3.contains("bla"));
    try {
      entity3.getString("str");
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      // expected - no such property
    }
    assertFalse(result.hasNext());
  }

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
      keysOfFoundEntities.add(iter.next().key());
    }
    assertEquals(requestedKeys, keysOfFoundEntities);
  }

  public void testFetchArrayDeferredResults() throws DatastoreException {
    List<Entity> foundEntities =
        createDatastoreForDeferredLookup().fetch(KEY1, KEY2, KEY3, KEY4, KEY5);
    assertEquals(foundEntities.get(0).key(), KEY1);
    assertEquals(foundEntities.get(1).key(), KEY2);
    assertEquals(foundEntities.get(2).key(), KEY3);
    assertEquals(foundEntities.get(3).key(), KEY4);
    assertEquals(foundEntities.get(4).key(), KEY5);
    assertEquals(foundEntities.size(), 5);
  }

  private Datastore createDatastoreForDeferredLookup() throws DatastoreException {
    List<com.google.datastore.v1beta3.Key> keysPb = new ArrayList<>();
    keysPb.add(KEY1.toPb());
    keysPb.add(KEY2.toPb());
    keysPb.add(KEY3.toPb());
    keysPb.add(KEY4.toPb());
    keysPb.add(KEY5.toPb());
    List<com.google.datastore.v1beta3.LookupRequest> lookupRequests = new ArrayList<>();
    lookupRequests.add(
        com.google.datastore.v1beta3.LookupRequest.newBuilder().addAllKeys(keysPb).build());
    lookupRequests.add(
        com.google.datastore.v1beta3.LookupRequest.newBuilder()
            .addKeys(keysPb.get(2))
            .addKeys(keysPb.get(3))
            .addKeys(keysPb.get(5))
            .build());
    lookupRequests.add(
        com.google.datastore.v1beta3.LookupRequest.newBuilder().addKeys(keysPb.get(5)).build());
    Entity entity4 = Entity.builder(KEY4).set("value", StringValue.of("value")).build();
    Entity entity5 = Entity.builder(KEY5).set("value", "value").build();
    List<com.google.datastore.v1beta3.LookupResponse> lookupResponses = new ArrayList<>();
    lookupResponses.add(
        com.google.datastore.v1beta3.LookupResponse.newBuilder()
            .addFound(
                com.google.datastore.v1beta3.EntityResult.newBuilder().setEntity(ENTITY1.toPb()))
            .addFound(
                com.google.datastore.v1beta3.EntityResult.newBuilder().setEntity(entity4.toPb()))
            .addDeferred(keysPb.get(2))
            .addDeferred(keysPb.get(3))
            .addDeferred(keysPb.get(5))
            .build());
    lookupResponses.add(
        com.google.datastore.v1beta3.LookupResponse.newBuilder()
            .addFound(
                com.google.datastore.v1beta3.EntityResult.newBuilder().setEntity(ENTITY3.toPb()))
            .addFound(
                com.google.datastore.v1beta3.EntityResult.newBuilder().setEntity(entity4.toPb()))
            .addDeferred(keysPb.get(5))
            .build());
    lookupResponses.add(
        com.google.datastore.v1beta3.LookupResponse.newBuilder()
            .addFound(
                com.google.datastore.v1beta3.EntityResult.newBuilder().setEntity(entity5.toPb()))
            .build());
    DatastoreRpcFactory rpcFactoryMock = EasyMock.createStrictMock(DatastoreRpcFactory.class);
    DatastoreRpc rpcMock = EasyMock.createStrictMock(DatastoreRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(DatastoreOptions.class)))
        .andReturn(rpcMock);
    for (int i = 0; i < lookupRequests.size(); i++) {
      EasyMock.expect(rpcMock.lookup(lookupRequests.get(i))).andReturn(lookupResponses.get(i));
    }
    EasyMock.replay(rpcFactoryMock, rpcMock);
    DatastoreOptions options =
        this.options.toBuilder()
            .retryParams(RetryParams.defaultInstance())
            .serviceRpcFactory(rpcFactoryMock)
            .build();
    return options.service();
  }

  @Test
  public void testAddEntity() {
    List<Entity> keys = datastore.fetch(ENTITY1.key(), ENTITY3.key());
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
    assertEquals(ENTITY3, datastore.get(ENTITY3.key()));
    assertEquals(ENTITY3, entities.get(0));
    assertEquals(PARTIAL_ENTITY1.properties(), entities.get(1).properties());
    assertEquals(PARTIAL_ENTITY1.key().ancestors(), entities.get(1).key().ancestors());
    assertNotNull(datastore.get(entities.get(1).key()));
    assertEquals(PARTIAL_ENTITY2.properties(), entities.get(2).properties());
    assertEquals(PARTIAL_ENTITY2.key().ancestors(), entities.get(2).key().ancestors());
    assertNotNull(datastore.get(entities.get(2).key()));
  }

  @Test
  public void testUpdate() {
    List<Entity> keys = datastore.fetch(ENTITY1.key(), ENTITY3.key());
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
    assertEquals(ENTITY3, datastore.get(ENTITY3.key()));
    Entity entity3 = Entity.builder(ENTITY3).clear().set("bla", new NullValue()).build();
    assertNotEquals(ENTITY3, entity3);
    datastore.update(entity3);
    assertEquals(entity3, datastore.get(ENTITY3.key()));
  }

  @Test
  public void testPut() {
    Iterator<Entity> keys =
        datastore.fetch(ENTITY1.key(), ENTITY2.key(), ENTITY3.key()).iterator();
    assertEquals(ENTITY1, keys.next());
    assertEquals(ENTITY2, keys.next());
    assertNull(keys.next());
    assertFalse(keys.hasNext());

    Entity entity2 = Entity.builder(ENTITY2).clear().set("bla", new NullValue()).build();
    assertNotEquals(ENTITY2, entity2);
    datastore.put(ENTITY3, ENTITY1, entity2);
    keys = datastore.fetch(ENTITY1.key(), ENTITY2.key(), ENTITY3.key()).iterator();
    assertEquals(ENTITY1, keys.next());
    assertEquals(entity2, keys.next());
    assertEquals(ENTITY3, keys.next());
    assertFalse(keys.hasNext());
  }

  @Test
  public void testDelete() {
    Iterator<Entity> keys =
        datastore.fetch(ENTITY1.key(), ENTITY2.key(), ENTITY3.key()).iterator();
    assertEquals(ENTITY1, keys.next());
    assertEquals(ENTITY2, keys.next());
    assertNull(keys.next());
    assertFalse(keys.hasNext());
    datastore.delete(ENTITY1.key(), ENTITY2.key(), ENTITY3.key());
    keys = datastore.fetch(ENTITY1.key(), ENTITY2.key(), ENTITY3.key()).iterator();
    assertNull(keys.next());
    assertNull(keys.next());
    assertNull(keys.next());
    assertFalse(keys.hasNext());
  }

  @Test
  public void testKeyFactory() {
    KeyFactory keyFactory = datastore.newKeyFactory().kind(KIND1);
    assertEquals(INCOMPLETE_KEY1, keyFactory.newKey());
    assertEquals(IncompleteKey.builder(INCOMPLETE_KEY1).kind(KIND2).build(),
        datastore.newKeyFactory().kind(KIND2).newKey());
    assertEquals(KEY1, keyFactory.newKey("name"));
    assertEquals(Key.builder(KEY1).id(2).build(), keyFactory.newKey(2));
  }

  @Test
  public void testRetryableException() throws Exception {
    com.google.datastore.v1beta3.LookupRequest requestPb =
        com.google.datastore.v1beta3.LookupRequest.newBuilder().addKeys(KEY1.toPb()).build();
    com.google.datastore.v1beta3.LookupResponse responsePb =
        com.google.datastore.v1beta3.LookupResponse.newBuilder()
            .addFound(
                com.google.datastore.v1beta3.EntityResult.newBuilder().setEntity(ENTITY1.toPb()))
            .build();
    DatastoreRpcFactory rpcFactoryMock = EasyMock.createStrictMock(DatastoreRpcFactory.class);
    DatastoreRpc rpcMock = EasyMock.createStrictMock(DatastoreRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(DatastoreOptions.class)))
        .andReturn(rpcMock);
    EasyMock.expect(rpcMock.lookup(requestPb))
        .andThrow(new DatastoreException(503, "UNAVAILABLE", "UNAVAILABLE", null))
        .andReturn(responsePb);
    EasyMock.replay(rpcFactoryMock, rpcMock);
    DatastoreOptions options = this.options.toBuilder()
        .retryParams(RetryParams.defaultInstance())
        .serviceRpcFactory(rpcFactoryMock)
        .build();
    Datastore datastore = options.service();
    Entity entity = datastore.get(KEY1);
    assertEquals(ENTITY1, entity);
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  @Test
  public void testNonRetryableException() throws Exception {
    com.google.datastore.v1beta3.LookupRequest requestPb =
        com.google.datastore.v1beta3.LookupRequest.newBuilder().addKeys(KEY1.toPb()).build();
    DatastoreRpcFactory rpcFactoryMock = EasyMock.createStrictMock(DatastoreRpcFactory.class);
    DatastoreRpc rpcMock = EasyMock.createStrictMock(DatastoreRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(DatastoreOptions.class)))
        .andReturn(rpcMock);
    EasyMock.expect(rpcMock.lookup(requestPb))
        .andThrow(
            new DatastoreException(DatastoreException.UNKNOWN_CODE, "denied", "PERMISSION_DENIED"))
        .times(1);
    EasyMock.replay(rpcFactoryMock, rpcMock);
    RetryParams retryParams = RetryParams.builder().retryMinAttempts(2).build();
    DatastoreOptions options = this.options.toBuilder()
        .retryParams(retryParams)
        .serviceRpcFactory(rpcFactoryMock)
        .build();
    Datastore datastore = options.service();
    thrown.expect(DatastoreException.class);
    thrown.expectMessage("denied");
    datastore.get(KEY1);
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  @Test
  public void testRuntimeException() throws Exception {
    com.google.datastore.v1beta3.LookupRequest requestPb =
        com.google.datastore.v1beta3.LookupRequest.newBuilder().addKeys(KEY1.toPb()).build();
    DatastoreRpcFactory rpcFactoryMock = EasyMock.createStrictMock(DatastoreRpcFactory.class);
    DatastoreRpc rpcMock = EasyMock.createStrictMock(DatastoreRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(DatastoreOptions.class)))
        .andReturn(rpcMock);
    String exceptionMessage = "Artificial runtime exception";
    EasyMock.expect(rpcMock.lookup(requestPb))
        .andThrow(new RuntimeException(exceptionMessage));
    EasyMock.replay(rpcFactoryMock, rpcMock);
    DatastoreOptions options = this.options.toBuilder()
        .retryParams(RetryParams.defaultInstance())
        .serviceRpcFactory(rpcFactoryMock)
        .build();
    Datastore datastore = options.service();
    thrown.expect(DatastoreException.class);
    thrown.expectMessage(exceptionMessage);
    datastore.get(KEY1);
    EasyMock.verify(rpcFactoryMock, rpcMock);
  }
}
