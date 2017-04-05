/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.datastore.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.datastore.Batch;
import com.google.cloud.datastore.BooleanValue;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.DateTime;
import com.google.cloud.datastore.DateTimeValue;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityValue;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.GqlQuery;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.KeyValue;
import com.google.cloud.datastore.LatLng;
import com.google.cloud.datastore.LatLngValue;
import com.google.cloud.datastore.ListValue;
import com.google.cloud.datastore.NullValue;
import com.google.cloud.datastore.PathElement;
import com.google.cloud.datastore.ProjectionEntity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.Query.ResultType;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StringValue;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.cloud.datastore.Transaction;
import com.google.cloud.datastore.Value;
import com.google.cloud.datastore.ValueType;
import com.google.cloud.datastore.testing.RemoteDatastoreHelper;
import com.google.common.collect.Iterators;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ITDatastoreTest {

  private static final RemoteDatastoreHelper HELPER = RemoteDatastoreHelper.create();
  private static final DatastoreOptions OPTIONS = HELPER.getOptions();
  private static final Datastore DATASTORE = OPTIONS.getService();
  private static final String PROJECT_ID = OPTIONS.getProjectId();
  private static final String NAMESPACE = OPTIONS.getNamespace();
  private static final String KIND1 = "kind1";
  private static final String KIND2 = "kind2";
  private static final String KIND3 = "kind3";
  private static final NullValue NULL_VALUE = NullValue.of();
  private static final StringValue STR_VALUE = StringValue.of("str");
  private static final BooleanValue BOOL_VALUE = BooleanValue.newBuilder(false)
      .setExcludeFromIndexes(true).build();
  private static final IncompleteKey INCOMPLETE_KEY1 =
      IncompleteKey.newBuilder(PROJECT_ID, KIND1).setNamespace(NAMESPACE).build();
  private static final IncompleteKey INCOMPLETE_KEY2 =
      IncompleteKey.newBuilder(PROJECT_ID, KIND2).setNamespace(NAMESPACE).build();
  private static final Key KEY1 = Key.newBuilder(INCOMPLETE_KEY1, "name").build();
  private static final Key KEY2 = Key.newBuilder(KEY1, KIND2, 1).build();
  private static final Key KEY3 = Key.newBuilder(KEY2)
      .setName("bla")
      .setNamespace(NAMESPACE)
      .build();
  private static final Key KEY4 = Key.newBuilder(KEY2)
      .setName("newName1")
      .setNamespace(NAMESPACE)
      .build();
  private static final Key KEY5 = Key.newBuilder(KEY2)
      .setName("newName2")
      .setNamespace(NAMESPACE)
      .build();
  private static final KeyValue KEY_VALUE = KeyValue.of(KEY1);
  private static final ListValue LIST_VALUE1 = ListValue.newBuilder()
      .addValue(NULL_VALUE)
      .addValue(STR_VALUE, BOOL_VALUE)
      .build();
  private static final ListValue LIST_VALUE2 = ListValue.of(Collections.singletonList(KEY_VALUE));
  private static final ListValue EMPTY_LIST_VALUE = ListValue.of(Collections.<Value<?>>emptyList());
  private static final DateTimeValue DATE_TIME_VALUE = new DateTimeValue(DateTime.now());
  private static final LatLngValue LAT_LNG_VALUE =
      new LatLngValue(LatLng.of(37.422035, -122.084124));
  private static final FullEntity<IncompleteKey> PARTIAL_ENTITY1 =
      FullEntity.newBuilder(INCOMPLETE_KEY2).set("str", STR_VALUE).set("bool", BOOL_VALUE)
          .set("list", LIST_VALUE1).build();
  private static final FullEntity<IncompleteKey> PARTIAL_ENTITY2 =
      FullEntity.newBuilder(PARTIAL_ENTITY1).remove("str").set("bool", true)
          .set("list", LIST_VALUE1.get()).build();
  private static final FullEntity<IncompleteKey> PARTIAL_ENTITY3 =
      FullEntity.newBuilder(PARTIAL_ENTITY1)

          .setKey(IncompleteKey.newBuilder(PROJECT_ID, KIND3).build())
          .build();
  private static final Entity ENTITY1 = Entity.newBuilder(KEY1)
      .set("str", STR_VALUE)
      .set("date", DATE_TIME_VALUE)
      .set("latLng", LAT_LNG_VALUE)
      .set("bool", BOOL_VALUE)
      .set("partial1", EntityValue.of(PARTIAL_ENTITY1))
      .set("list", LIST_VALUE2)
      .set("emptyList", EMPTY_LIST_VALUE)
      .build();
  private static final Entity ENTITY2 = Entity.newBuilder(ENTITY1).setKey(KEY2).remove("str")
      .set("name", "Dan").setNull("null").set("age", 20).build();
  private static final Entity ENTITY3 = Entity.newBuilder(ENTITY1).setKey(KEY3).remove("str")
      .set("null", NULL_VALUE).set("partial1", PARTIAL_ENTITY2).set("partial2", ENTITY2).build();

  @Rule
  public Timeout globalTimeout = Timeout.seconds(100);

  @AfterClass
  public static void afterClass() {
    HELPER.deleteNamespace();
  }

  @Before
  public void setUp() {
    DATASTORE.put(ENTITY1, ENTITY2);
  }

  @After
  public void tearDown() {
    DATASTORE.delete(KEY1, KEY2, KEY3);
  }

  @Test
  public void testNewTransactionCommit() {
    Transaction transaction = DATASTORE.newTransaction();
    transaction.add(ENTITY3);
    Entity entity2 = Entity.newBuilder(ENTITY2)
        .clear()
        .setNull("bla")
        .build();
    transaction.update(entity2);
    transaction.delete(KEY1);
    transaction.commit();
    assertFalse(transaction.isActive());

    List<Entity> list = DATASTORE.fetch(KEY1, KEY2, KEY3);
    assertNull(list.get(0));
    assertEquals(entity2, list.get(1));
    assertEquals(ENTITY3, list.get(2));
    assertEquals(3, list.size());

    try {
      transaction.commit();
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      assertEquals("FAILED_PRECONDITION", expected.getReason());
    }

    try {
      transaction.rollback();
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      assertEquals("FAILED_PRECONDITION", expected.getReason());
    }
  }

  @Test
  public void testTransactionWithRead() {
    Transaction transaction = DATASTORE.newTransaction();
    assertNull(transaction.get(KEY3));
    transaction.add(ENTITY3);
    transaction.commit();
    assertEquals(ENTITY3, DATASTORE.get(KEY3));

    transaction = DATASTORE.newTransaction();
    assertEquals(ENTITY3, transaction.get(KEY3));
    // update entity3 during the transaction
    DATASTORE.put(Entity.newBuilder(ENTITY2).clear().set("from", "datastore").build());
    transaction.update(Entity.newBuilder(ENTITY2).clear().set("from", "transaction").build());
    try {
      transaction.commit();
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      assertEquals("ABORTED", expected.getReason());
    }
  }

  @Test
  public void testTransactionWithQuery() throws InterruptedException {
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind(KIND2)
        .setFilter(PropertyFilter.hasAncestor(KEY2))
        .setNamespace(NAMESPACE)
        .build();
    Transaction transaction = DATASTORE.newTransaction();
    QueryResults<Entity> results = transaction.run(query);
    while (Iterators.size(results) < 1) {
      Thread.sleep(500);
      results = DATASTORE.run(query);
    }
    results = DATASTORE.run(query);
    assertTrue(results.hasNext());
    assertEquals(ENTITY2, results.next());
    assertFalse(results.hasNext());
    transaction.add(ENTITY3);
    transaction.commit();
    assertEquals(ENTITY3, DATASTORE.get(KEY3));

    transaction = DATASTORE.newTransaction();
    results = transaction.run(query);
    while (Iterators.size(results) < 1) {
      Thread.sleep(500);
      results = DATASTORE.run(query);
    }
    results = DATASTORE.run(query);
    assertTrue(results.hasNext());
    assertEquals(ENTITY2, results.next());
    assertFalse(results.hasNext());
    transaction.delete(ENTITY3.getKey());
    // update entity2 during the transaction
    DATASTORE.put(Entity.newBuilder(ENTITY2).clear().build());
    try {
      transaction.commit();
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      assertEquals("ABORTED", expected.getReason());
    }
  }

  @Test
  public void testNewTransactionRollback() {
    Transaction transaction = DATASTORE.newTransaction();
    transaction.add(ENTITY3);
    Entity entity2 = Entity.newBuilder(ENTITY2).clear().setNull("bla")
        .set("list3", StringValue.of("bla"), StringValue.newBuilder("bla").build()).build();
    transaction.update(entity2);
    transaction.delete(KEY1);
    transaction.rollback();
    transaction.rollback(); // should be safe to repeat rollback calls

    try {
      transaction.commit();
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      assertEquals("FAILED_PRECONDITION", expected.getReason());
    }

    List<Entity> list = DATASTORE.fetch(KEY1, KEY2, KEY3);
    assertEquals(ENTITY1, list.get(0));
    assertEquals(ENTITY2, list.get(1));
    assertNull(list.get(2));
    assertEquals(3, list.size());
  }

  @Test
  public void testNewBatch() {
    Batch batch = DATASTORE.newBatch();
    Entity entity1 = Entity.newBuilder(ENTITY1).clear().build();
    Entity entity2 = Entity.newBuilder(ENTITY2).clear().setNull("bla").build();
    Entity entity4 = Entity.newBuilder(KEY4).set("value", StringValue.of("value")).build();
    Entity entity5 = Entity.newBuilder(KEY5).set("value", "value").build();

    List<Entity> entities = batch.add(entity4, PARTIAL_ENTITY2, entity5);
    Entity entity6 = entities.get(1);
    assertSame(entity4, entities.get(0));
    assertEquals(PARTIAL_ENTITY2.getNames(), entity6.getNames());
    assertEquals(PARTIAL_ENTITY2.getKey().getProjectId(), entity6.getKey().getProjectId());
    assertEquals(PARTIAL_ENTITY2.getKey().getNamespace(), entity6.getKey().getNamespace());
    assertEquals(PARTIAL_ENTITY2.getKey().getAncestors(), entity6.getKey().getAncestors());
    assertEquals(PARTIAL_ENTITY2.getKey().getKind(), entity6.getKey().getKind());
    assertEquals(PARTIAL_ENTITY2.getKey(), IncompleteKey.newBuilder(entity6.getKey()).build());
    assertEquals(PARTIAL_ENTITY2.getKey().getAncestors(), entity6.getKey().getAncestors());
    assertNotEquals(PARTIAL_ENTITY2.getKey(), entity6.getKey());
    assertSame(entity5, entities.get(2));
    batch.addWithDeferredIdAllocation(PARTIAL_ENTITY3);
    batch.put(ENTITY3, entity1, entity2);

    Batch.Response response = batch.submit();
    entities = DATASTORE.fetch(KEY1, KEY2, KEY3, entity4.getKey(), entity5.getKey(), entity6.getKey());
    assertEquals(entity1, entities.get(0));
    assertEquals(entity2, entities.get(1));
    assertEquals(ENTITY3, entities.get(2));
    assertEquals(entity4, entities.get(3));
    assertEquals(entity5, entities.get(4));
    assertEquals(entity6, entities.get(5));
    assertEquals(6, entities.size());
    List<Key> generatedKeys = response.getGeneratedKeys();
    assertEquals(1, generatedKeys.size());
    assertEquals(PARTIAL_ENTITY3.getNames(), DATASTORE.get(generatedKeys.get(0)).getNames());
    assertEquals(PARTIAL_ENTITY3.getKey(), IncompleteKey.newBuilder(generatedKeys.get(0)).build());

    try {
      batch.submit();
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      assertEquals("FAILED_PRECONDITION", expected.getReason());
    }

    batch = DATASTORE.newBatch();
    batch.delete(entity4.getKey(), entity5.getKey(), entity6.getKey());
    batch.update(ENTITY1, ENTITY2, ENTITY3);
    batch.submit();
    entities =
        DATASTORE.fetch(KEY1, KEY2, KEY3, entity4.getKey(), entity5.getKey(), entity6.getKey());
    assertEquals(ENTITY1, entities.get(0));
    assertEquals(ENTITY2, entities.get(1));
    assertEquals(ENTITY3, entities.get(2));
    assertNull(entities.get(3));
    assertNull(entities.get(4));
    assertNull(entities.get(5));
    assertEquals(6, entities.size());
  }

  @Test
  public void testRunGqlQueryNoCasting() throws InterruptedException {
    Query<Entity> query1 = Query.newGqlQueryBuilder(ResultType.ENTITY, "select * from " + KIND1)
        .setNamespace(NAMESPACE)
        .build();
    QueryResults<Entity> results1 = DATASTORE.run(query1);
    while (Iterators.size(results1) < 1) {
      Thread.sleep(500);
      results1 = DATASTORE.run(query1);
    }
    results1 = DATASTORE.run(query1);
    assertTrue(results1.hasNext());
    assertEquals(ENTITY1, results1.next());
    assertFalse(results1.hasNext());

    DATASTORE.put(ENTITY3);
    Query<? extends Entity> query2 =
        Query.newGqlQueryBuilder(ResultType.ENTITY, "select * from " + KIND2 + " order by __key__")
            .setNamespace(NAMESPACE)
            .build();
    QueryResults<? extends Entity> results2 = DATASTORE.run(query2);
    while (Iterators.size(results2) < 2) {
      Thread.sleep(500);
      results2 = DATASTORE.run(query2);
    }
    results2 = DATASTORE.run(query2);
    assertTrue(results2.hasNext());
    assertEquals(ENTITY2, results2.next());
    assertTrue(results2.hasNext());
    assertEquals(ENTITY3, results2.next());
    assertFalse(results2.hasNext());

    query1 = Query.newGqlQueryBuilder(ResultType.ENTITY, "select * from bla")
        .setNamespace(NAMESPACE)
        .build();
    results1 = DATASTORE.run(query1);
    assertFalse(results1.hasNext());

    Query<Key> keyOnlyQuery =
        Query.newGqlQueryBuilder(ResultType.KEY, "select __key__ from " + KIND1)
            .setNamespace(NAMESPACE)
            .build();
    QueryResults<Key> keyOnlyResults = DATASTORE.run(keyOnlyQuery);
    while (Iterators.size(keyOnlyResults) < 1) {
      Thread.sleep(500);
      keyOnlyResults = DATASTORE.run(keyOnlyQuery);
    }
    keyOnlyResults = DATASTORE.run(keyOnlyQuery);
    assertTrue(keyOnlyResults.hasNext());
    assertEquals(KEY1, keyOnlyResults.next());
    assertFalse(keyOnlyResults.hasNext());

    GqlQuery<ProjectionEntity> keyProjectionQuery =
        Query.newGqlQueryBuilder(ResultType.PROJECTION_ENTITY, "select __key__ from " + KIND1)
            .setNamespace(NAMESPACE)
            .build();
    QueryResults<ProjectionEntity> keyProjectionResult = DATASTORE.run(keyProjectionQuery);
    while (Iterators.size(keyProjectionResult) < 1) {
      Thread.sleep(500);
      keyProjectionResult = DATASTORE.run(keyProjectionQuery);
    }
    keyProjectionResult = DATASTORE.run(keyProjectionQuery);
    assertTrue(keyProjectionResult.hasNext());
    ProjectionEntity projectionEntity = keyProjectionResult.next();
    assertEquals(KEY1, projectionEntity.getKey());
    assertTrue(projectionEntity.getNames().isEmpty());
    assertFalse(keyProjectionResult.hasNext());
  }

  @Test
  public void testRunGqlQueryWithCasting() throws InterruptedException {
    @SuppressWarnings("unchecked")
    Query<Entity> query1 = (Query<Entity>) Query.newGqlQueryBuilder("select * from " + KIND1)
        .setNamespace(NAMESPACE)
        .build();
    QueryResults<Entity> results1 = DATASTORE.run(query1);
    while (Iterators.size(results1) < 1) {
      Thread.sleep(500);
      results1 = DATASTORE.run(query1);
    }
    results1 = DATASTORE.run(query1);
    assertTrue(results1.hasNext());
    assertEquals(ENTITY1, results1.next());
    assertFalse(results1.hasNext());

    Query<?> query2 = Query.newGqlQueryBuilder("select * from " + KIND1)
        .setNamespace(NAMESPACE)
        .build();
    QueryResults<?> results2 = DATASTORE.run(query2);
    while (Iterators.size(results2) < 1) {
      Thread.sleep(500);
      results2 = DATASTORE.run(query2);
    }
    results2 = DATASTORE.run(query1);
    assertSame(Entity.class, results2.getResultClass());
    @SuppressWarnings("unchecked")
    QueryResults<Entity> results3 = (QueryResults<Entity>) results2;
    assertTrue(results3.hasNext());
    assertEquals(ENTITY1, results3.next());
    assertFalse(results3.hasNext());
  }

  @Test
  public void testRunStructuredQuery() throws InterruptedException {
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind(KIND1).setOrderBy(OrderBy.asc("__key__")).build();
    QueryResults<Entity> results1 = DATASTORE.run(query);
    while (Iterators.size(results1) < 1) {
      Thread.sleep(500);
      results1 = DATASTORE.run(query);
    }
    results1 = DATASTORE.run(query);
    assertTrue(results1.hasNext());
    assertEquals(ENTITY1, results1.next());
    assertFalse(results1.hasNext());

    Query<Key> keyOnlyQuery =  Query.newKeyQueryBuilder().setKind(KIND1).build();
    QueryResults<Key> results2 = DATASTORE.run(keyOnlyQuery);
    while (Iterators.size(results2) < 1) {
      Thread.sleep(500);
      results2 = DATASTORE.run(keyOnlyQuery);
    }
    results2 = DATASTORE.run(keyOnlyQuery);
    assertTrue(results2.hasNext());
    assertEquals(ENTITY1.getKey(), results2.next());
    assertFalse(results2.hasNext());

    StructuredQuery<ProjectionEntity> keyOnlyProjectionQuery =
        Query.newProjectionEntityQueryBuilder()
            .setKind(KIND1).setProjection("__key__").build();
    QueryResults<ProjectionEntity> results3 = DATASTORE.run(keyOnlyProjectionQuery);
    while (Iterators.size(results3) < 1) {
      Thread.sleep(500);
      results3 = DATASTORE.run(keyOnlyProjectionQuery);
    }
    results3 = DATASTORE.run(keyOnlyProjectionQuery);
    assertTrue(results3.hasNext());
    ProjectionEntity projectionEntity = results3.next();
    assertEquals(ENTITY1.getKey(), projectionEntity.getKey());
    assertTrue(projectionEntity.getNames().isEmpty());
    assertFalse(results2.hasNext());

    StructuredQuery<ProjectionEntity> projectionQuery = Query.newProjectionEntityQueryBuilder()
        .setKind(KIND2)
        .setProjection("age")
        .setFilter(PropertyFilter.gt("age", 18))
        .setDistinctOn("age")
        .setOrderBy(OrderBy.asc("age"))
        .setLimit(10)
        .build();

    QueryResults<ProjectionEntity> results4 = DATASTORE.run(projectionQuery);
    while (Iterators.size(results4) < 1) {
      Thread.sleep(500);
      results4 = DATASTORE.run(projectionQuery);
    }
    results4 = DATASTORE.run(projectionQuery);
    assertTrue(results4.hasNext());
    ProjectionEntity entity = results4.next();
    assertEquals(ENTITY2.getKey(), entity.getKey());
    assertEquals(20, entity.getLong("age"));
    assertEquals(1, entity.getNames().size());
    assertFalse(results4.hasNext());
  }

  @Test
  public void testAllocateId() {
    KeyFactory keyFactory = DATASTORE.newKeyFactory().setKind(KIND1);
    IncompleteKey pk1 = keyFactory.newKey();
    Key key1 = DATASTORE.allocateId(pk1);
    assertEquals(key1.getProjectId(), pk1.getProjectId());
    assertEquals(key1.getNamespace(), pk1.getNamespace());
    assertEquals(key1.getAncestors(), pk1.getAncestors());
    assertEquals(key1.getKind(), pk1.getKind());
    assertTrue(key1.hasId());
    assertFalse(key1.hasName());
    assertEquals(Key.newBuilder(pk1, key1.getId()).build(), key1);

    Key key2 = DATASTORE.allocateId(pk1);
    assertNotEquals(key1, key2);
    assertEquals(Key.newBuilder(pk1, key2.getId()).build(), key2);
  }

  @Test
  public void testAllocateIdArray() {
    KeyFactory keyFactory = DATASTORE.newKeyFactory().setKind(KIND1);
    IncompleteKey incompleteKey1 = keyFactory.newKey();
    IncompleteKey incompleteKey2 =
        keyFactory.setKind(KIND2).addAncestors(PathElement.of(KIND1, 10)).newKey();
    List<Key> result =
        DATASTORE.allocateId(incompleteKey1, incompleteKey2, incompleteKey1);
    assertEquals(3, result.size());
    assertEquals(Key.newBuilder(incompleteKey1, result.get(0).getId()).build(), result.get(0));
    assertEquals(Key.newBuilder(incompleteKey1, result.get(2).getId()).build(), result.get(2));
    assertEquals(Key.newBuilder(incompleteKey2, result.get(1).getId()).build(), result.get(1));
  }

  @Test
  public void testGet() {
    Entity entity = DATASTORE.get(KEY3);
    assertNull(entity);

    entity = DATASTORE.get(KEY1);
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
    ListValue value7 = entity.getValue("emptyList");
    assertEquals(EMPTY_LIST_VALUE, value7);
    assertEquals(7, entity.getNames().size());
    assertFalse(entity.contains("bla"));
  }

  @Test
  public void testGetArrayNoDeferredResults() {
    DATASTORE.put(ENTITY3);
    Iterator<Entity> result =
        DATASTORE.fetch(KEY1, Key.newBuilder(KEY1).setName("bla").build(), KEY2, KEY3).iterator();
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
  public void testAddEntity() {
    List<Entity> keys = DATASTORE.fetch(ENTITY1.getKey(), ENTITY3.getKey());
    assertEquals(ENTITY1, keys.get(0));
    assertNull(keys.get(1));
    assertEquals(2, keys.size());

    try {
      DATASTORE.add(ENTITY1);
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      // expected;
    }

    List<Entity> entities = DATASTORE.add(ENTITY3, PARTIAL_ENTITY1, PARTIAL_ENTITY2);
    assertEquals(ENTITY3, DATASTORE.get(ENTITY3.getKey()));
    assertEquals(ENTITY3, entities.get(0));
    assertEquals(PARTIAL_ENTITY1.getNames(), entities.get(1).getNames());
    assertEquals(PARTIAL_ENTITY1.getKey().getAncestors(), entities.get(1).getKey().getAncestors());
    assertNotNull(DATASTORE.get(entities.get(1).getKey()));
    assertEquals(PARTIAL_ENTITY2.getNames(), entities.get(2).getNames());
    assertEquals(PARTIAL_ENTITY2.getKey().getAncestors(), entities.get(2).getKey().getAncestors());
    assertNotNull(DATASTORE.get(entities.get(2).getKey()));
    for (Entity entity : entities) {
      DATASTORE.delete(entity.getKey());
    }
  }

  @Test
  public void testUpdate() {
    List<Entity> keys = DATASTORE.fetch(ENTITY1.getKey(), ENTITY3.getKey());
    assertEquals(ENTITY1, keys.get(0));
    assertNull(keys.get(1));
    assertEquals(2, keys.size());

    try {
      DATASTORE.update(ENTITY3);
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      // expected;
    }
    DATASTORE.add(ENTITY3);
    assertEquals(ENTITY3, DATASTORE.get(ENTITY3.getKey()));
    Entity entity3 = Entity.newBuilder(ENTITY3).clear().set("bla", new NullValue()).build();
    assertNotEquals(ENTITY3, entity3);
    DATASTORE.update(entity3);
    assertEquals(entity3, DATASTORE.get(ENTITY3.getKey()));
  }

  @Test
  public void testPut() {
    Entity updatedEntity = Entity.newBuilder(ENTITY1).set("new_property", 42L).build();
    assertEquals(updatedEntity, DATASTORE.put(updatedEntity));
    assertEquals(updatedEntity, DATASTORE.get(updatedEntity.getKey()));

    Entity entity2 = Entity.newBuilder(ENTITY2).clear().set("bla", new NullValue()).build();
    assertNotEquals(ENTITY2, entity2);
    List<Entity> entities = DATASTORE.put(ENTITY1, entity2, ENTITY3, PARTIAL_ENTITY1);
    assertEquals(ENTITY1, entities.get(0));
    assertEquals(entity2, entities.get(1));
    assertEquals(ENTITY3, entities.get(2));
    assertEquals(PARTIAL_ENTITY1.getNames(), entities.get(3).getNames());
    assertEquals(PARTIAL_ENTITY1.getKey().getAncestors(), entities.get(3).getKey().getAncestors());
    assertEquals(ENTITY1, DATASTORE.get(ENTITY1.getKey()));
    assertEquals(entity2, DATASTORE.get(entity2.getKey()));
    assertEquals(ENTITY3, DATASTORE.get(ENTITY3.getKey()));
    Entity entity = DATASTORE.get(entities.get(3).getKey());
    assertEquals(entities.get(3), entity);
    for (Entity entityToDelete : entities) {
      DATASTORE.delete(entityToDelete.getKey());
    }
  }

  @Test
  public void testDelete() {
    Iterator<Entity> keys =
        DATASTORE.fetch(ENTITY1.getKey(), ENTITY2.getKey(), ENTITY3.getKey()).iterator();
    assertEquals(ENTITY1, keys.next());
    assertEquals(ENTITY2, keys.next());
    assertNull(keys.next());
    assertFalse(keys.hasNext());
    DATASTORE.delete(ENTITY1.getKey(), ENTITY2.getKey(), ENTITY3.getKey());
    keys = DATASTORE.fetch(ENTITY1.getKey(), ENTITY2.getKey(), ENTITY3.getKey()).iterator();
    assertNull(keys.next());
    assertNull(keys.next());
    assertNull(keys.next());
    assertFalse(keys.hasNext());
  }
}
