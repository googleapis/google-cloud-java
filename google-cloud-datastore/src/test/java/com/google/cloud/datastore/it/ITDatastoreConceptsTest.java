/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.datastore.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.Cursor;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.KeyQuery;
import com.google.cloud.datastore.ListValue;
import com.google.cloud.datastore.PathElement;
import com.google.cloud.datastore.ProjectionEntity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.ReadOption;
import com.google.cloud.datastore.StringValue;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.StructuredQuery.CompositeFilter;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.cloud.datastore.Transaction;
import com.google.cloud.datastore.testing.RemoteDatastoreHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.datastore.v1.TransactionOptions;
import com.google.datastore.v1.TransactionOptions.ReadOnly;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Test created based on ConceptsTest to run against GraalVM checks
 */
public class ITDatastoreConceptsTest {
  private static final RemoteDatastoreHelper HELPER = RemoteDatastoreHelper.create();
  private static final DatastoreOptions OPTIONS = HELPER.getOptions();
  private static final FullEntity<IncompleteKey> TEST_FULL_ENTITY = FullEntity.newBuilder().build();
  private Datastore datastore;
  private KeyFactory keyFactory;
  private Key taskKey;
  private Entity testEntity;
  private Timestamp startDate;
  private Timestamp endDate;
  private Timestamp includedDate;

  private static final String TASK_CONCEPTS = "TaskConcepts";

  /**
   * Initializes Datastore and cleans out any residual values. Also initializes global variables
   * used for testing.
   */
  @Before
  public void setUp() {
    datastore = OPTIONS.getService();
    StructuredQuery<Key> query = Query.newKeyQueryBuilder().build();
    QueryResults<Key> result = datastore.run(query);
    datastore.delete(Iterators.toArray(result, Key.class));
    keyFactory = datastore.newKeyFactory().setKind(TASK_CONCEPTS);
    taskKey = keyFactory.newKey("some-arbitrary-key");
    testEntity = Entity.newBuilder(taskKey, TEST_FULL_ENTITY).build();
    startDate =
        Timestamp.ofTimeSecondsAndNanos(
            LocalDateTime.of(1990, Month.JANUARY, 1, 1, 1, 1)
                .toInstant(ZoneOffset.UTC)
                .getEpochSecond(),
            0);
    endDate =
        Timestamp.ofTimeSecondsAndNanos(
            LocalDateTime.of(2000, Month.JANUARY, 1, 1, 1, 1)
                .toInstant(ZoneOffset.UTC)
                .getEpochSecond(),
            0);
    includedDate =
        Timestamp.ofTimeSecondsAndNanos(
            LocalDateTime.of(1999, Month.DECEMBER, 31, 1, 1, 1)
                .toInstant(ZoneOffset.UTC)
                .getEpochSecond(),
            0);
    setUpQueryTests();
  }

  @After
  public void tearDown() {
    KeyQuery taskQuery = Query.newKeyQueryBuilder().setKind(TASK_CONCEPTS).build();
    Key[] taskKeysToDelete = Iterators.toArray(datastore.run(taskQuery), Key.class);
    datastore.delete(taskKeysToDelete);
  }

  private void assertValidKey(Key taskKey) {
    datastore.put(Entity.newBuilder(taskKey, TEST_FULL_ENTITY).build());
  }

  private void assertValidEntity(Entity original) {
    datastore.put(original);
    assertEquals(original, datastore.get(original.getKey()));
  }

  private List<Entity> setUpBatchTests(Key taskKey1, Key taskKey2) {
    Entity task1 =
        Entity.newBuilder(taskKey1)
            .set("category", "Personal")
            .set("done", false)
            .set("priority", 4)
            .set("description", "Learn Cloud Datastore")
            .build();
    Entity task2 =
        Entity.newBuilder(taskKey2)
            .set("category", "Personal")
            .set("done", false)
            .set("priority", 5)
            .set("description", "Integrate Cloud Datastore")
            .build();
    datastore.put(task1, task2);
    return ImmutableList.of(task1, task2);
  }

  private void setUpQueryTests() {
    Key taskKey =
        datastore
            .newKeyFactory()
            .setKind(TASK_CONCEPTS)
            .addAncestors(PathElement.of("TaskList", "default"))
            .newKey("someTask");
    datastore.put(
        Entity.newBuilder(taskKey)
            .set("category", "Personal")
            .set("done", false)
            .set("completed", false)
            .set("priority", 4)
            .set("created", includedDate)
            .set("percent_complete", 10.0)
            .set(
                "description",
                StringValue.newBuilder("Learn Cloud Datastore").setExcludeFromIndexes(true).build())
            .set("tag", "fun", "l", "programming", "learn")
            .build());
  }

  private void assertValidQuery(Query query) {
    QueryResults results = datastore.run(query);
    assertTrue(results.hasNext());
    results.next();
    assertFalse(results.hasNext());
  }

  private <V> void assertInvalidQuery(Query<V> query) {
    try {
      datastore.run(query);
      fail("should not reach here");
    } catch (DatastoreException ignored) {
    }
  }

  private List<Key> setUpTransferTests() {
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("People");
    Key from = keyFactory.newKey("from");
    Key to = keyFactory.newKey("to");
    datastore.put(Entity.newBuilder(from).set("balance", 100).build());
    datastore.put(Entity.newBuilder(to).set("balance", 0).build());
    return ImmutableList.of(from, to);
  }

  private void assertSuccessfulTransfer(Key from, Key to) {
    assertEquals(90, datastore.get(from).getLong("balance"));
    assertEquals(10, datastore.get(to).getLong("balance"));
  }

  @Test
  public void testIncompleteKey() {
    KeyFactory keyFactory = datastore.newKeyFactory().setKind(TASK_CONCEPTS);
    Key taskKey = datastore.allocateId(keyFactory.newKey());
    assertValidKey(taskKey);
  }

  @Test
  public void testNamedKey() {
    Key taskKey = datastore.newKeyFactory().setKind(TASK_CONCEPTS).newKey("sampleTask");
    assertValidKey(taskKey);
  }

  @Test
  public void testKeyWithParent() {
    Key taskKey =
        datastore
            .newKeyFactory()
            .addAncestors(PathElement.of("TaskList", "default"))
            .setKind(TASK_CONCEPTS)
            .newKey("sampleTask");
    assertValidKey(taskKey);
  }

  @Test
  public void testKeyWithMultilevelParent() {
    KeyFactory keyFactory =
        datastore
            .newKeyFactory()
            .addAncestors(PathElement.of("User", "Alice"), PathElement.of("TaskList", "default"))
            .setKind(TASK_CONCEPTS);
    Key taskKey = keyFactory.newKey("sampleTask");
    assertValidKey(taskKey);
  }

  @Test
  public void testEntityWithParent() {
    Key taskKey =
        datastore
            .newKeyFactory()
            .addAncestors(PathElement.of("TaskList", "default"))
            .setKind(TASK_CONCEPTS)
            .newKey("sampleTask");
    Entity task =
        Entity.newBuilder(taskKey)
            .set("category", "Personal")
            .set("done", false)
            .set("priority", 4)
            .set("description", "Learn Cloud Datastore")
            .build();
    assertValidEntity(task);
  }

  @Test
  public void testProperties() {
    Entity task =
        Entity.newBuilder(taskKey)
            .set("category", "Personal")
            .set("created", Timestamp.now())
            .set("done", false)
            .set("priority", 4)
            .set("percent_complete", 10.0)
            .set(
                "description",
                StringValue.newBuilder("Learn Cloud Datastore").setExcludeFromIndexes(true).build())
            .build();
    assertValidEntity(task);
  }

  @Test
  public void testArrayValue() {
    Entity task =
        Entity.newBuilder(taskKey)
            .set("tags", "fun", "programming")
            .set("collaborators", ListValue.of("alice", "bob"))
            .build();
    assertValidEntity(task);
  }

  @Test
  public void testBasicEntity() {
    Key taskKey = datastore.newKeyFactory().setKind(TASK_CONCEPTS).newKey("sampleTask");
    Entity task =
        Entity.newBuilder(taskKey)
            .set("category", "Personal")
            .set("done", false)
            .set("priority", 4)
            .set("description", "Learn Cloud Datastore")
            .build();
    assertValidEntity(task);
  }

  @Test
  public void testUpsert() {
    Entity task = Entity.newBuilder(keyFactory.newKey("sampleTask")).build();
    datastore.put(task);
    assertEquals(task, datastore.get(task.getKey()));
  }

  @Test
  public void testInsert() {
    Key taskKey = datastore.add(FullEntity.newBuilder(keyFactory.newKey()).build()).getKey();
    assertEquals(FullEntity.newBuilder(taskKey).build(), datastore.get(taskKey));
  }

  @Test
  public void testLookup() {
    datastore.put(testEntity);
    Entity task = datastore.get(taskKey);
    assertEquals(testEntity, task);
  }

  @Test
  public void testUpdate() {
    datastore.put(testEntity);
    Entity task = Entity.newBuilder(datastore.get(taskKey)).set("priority", 5).build();
    datastore.update(task);
    assertEquals(task, datastore.get(taskKey));
  }

  @Test
  public void testDelete() {
    datastore.put(testEntity);
    datastore.delete(taskKey);
    assertNull(datastore.get(taskKey));
  }

  @Test
  public void testBatchUpsert() {
    FullEntity<IncompleteKey> task1 =
        FullEntity.newBuilder(keyFactory.newKey())
            .set("category", "Personal")
            .set("done", false)
            .set("priority", 4)
            .set("description", "Learn Cloud Datastore")
            .build();
    FullEntity<IncompleteKey> task2 =
        Entity.newBuilder(keyFactory.newKey())
            .set("category", "Personal")
            .set("done", false)
            .set("priority", 5)
            .set("description", "Integrate Cloud Datastore")
            .build();
    List<Entity> tasks = datastore.add(task1, task2);
    Key taskKey1 = tasks.get(0).getKey();
    Key taskKey2 = tasks.get(1).getKey();
    assertEquals(Entity.newBuilder(taskKey1, task1).build(), datastore.get(taskKey1));
    assertEquals(Entity.newBuilder(taskKey2, task2).build(), datastore.get(taskKey2));
  }

  @Test
  public void testBatchLookup() {
    Key taskKey1 = keyFactory.newKey(1);
    Key taskKey2 = keyFactory.newKey(2);
    List<Entity> expectedTasks = setUpBatchTests(taskKey1, taskKey2);
    Iterator<Entity> tasks = datastore.get(taskKey1, taskKey2);
    assertEquals(expectedTasks.get(0), tasks.next());
    assertEquals(expectedTasks.get(1), tasks.next());
  }

  @Test
  public void testBatchDelete() {
    Key taskKey1 = keyFactory.newKey(1);
    Key taskKey2 = keyFactory.newKey(2);
    setUpBatchTests(taskKey1, taskKey2);
    datastore.delete(taskKey1, taskKey2);
    assertNull(datastore.get(taskKey1));
    assertNull(datastore.get(taskKey2));
  }

  @Test
  public void testBasicQuery() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(
                CompositeFilter.and(
                    PropertyFilter.eq("done", false), PropertyFilter.ge("priority", 4)))
            .setOrderBy(OrderBy.desc("priority"))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testRunQuery() {
    Query<Entity> query = Query.newEntityQueryBuilder().setKind(TASK_CONCEPTS).build();
    QueryResults<Entity> tasks = datastore.run(query);
    assertNotNull(tasks.next());
    assertFalse(tasks.hasNext());
  }

  @Test
  public void testPropertyFilter() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(PropertyFilter.eq("done", false))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testCompositeFilter() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(
                CompositeFilter.and(
                    PropertyFilter.eq("done", false), PropertyFilter.eq("priority", 4)))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testKeyFilter() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(StructuredQuery.PropertyFilter.gt("__key__", keyFactory.newKey("someTask")))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testAscendingSort() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setOrderBy(OrderBy.asc("created"))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testDescendingSort() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setOrderBy(OrderBy.desc("created"))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testMultiSort() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setOrderBy(OrderBy.desc("priority"), OrderBy.asc("created"))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testKindlessQuery() {
    Key lastSeenKey = keyFactory.newKey("a");

    Query<Entity> query =
        Query.newEntityQueryBuilder().setFilter(PropertyFilter.gt("__key__", lastSeenKey)).build();
    assertValidQuery(query);
  }

  @Test
  public void testAncestorQuery() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(
                PropertyFilter.hasAncestor(
                    datastore.newKeyFactory().setKind("TaskList").newKey("default")))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testProjectionQuery() {
    Query<ProjectionEntity> query =
        Query.newProjectionEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setProjection("priority", "percent_complete")
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testRunProjectionQuery() {
    Query<ProjectionEntity> query =
        Query.newProjectionEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setProjection("priority", "percent_complete")
            .build();
    List<Long> priorities = new LinkedList<>();
    List<Double> percentCompletes = new LinkedList<>();
    QueryResults<ProjectionEntity> tasks = datastore.run(query);
    while (tasks.hasNext()) {
      ProjectionEntity task = tasks.next();
      priorities.add(task.getLong("priority"));
      percentCompletes.add(task.getDouble("percent_complete"));
    }
    assertEquals(ImmutableList.of(4L), priorities);
    assertEquals(ImmutableList.of(10.0), percentCompletes);
  }

  @Test
  public void testKeysOnlyQuery() {
    Query<Key> query = Query.newKeyQueryBuilder().setKind(TASK_CONCEPTS).build();
    assertValidQuery(query);
  }

  @Test
  public void testDistinctOnQuery() {
    Query<ProjectionEntity> query =
        Query.newProjectionEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setProjection("category", "priority")
            .setDistinctOn("category")
            .setOrderBy(OrderBy.asc("category"), OrderBy.asc("priority"))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testArrayValueInequalityRange() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(
                CompositeFilter.and(
                    PropertyFilter.gt("tag", "learn"), PropertyFilter.lt("tag", "math")))
            .build();
    QueryResults<Entity> results = datastore.run(query);
    assertFalse(results.hasNext());
  }

  @Test
  public void testArrayValueEquality() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(
                CompositeFilter.and(
                    PropertyFilter.eq("tag", "fun"), PropertyFilter.eq("tag", "programming")))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testInequalityRange() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(
                CompositeFilter.and(
                    PropertyFilter.gt("created", startDate), PropertyFilter.lt("created", endDate)))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testInequalityValid() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(
                CompositeFilter.and(
                    PropertyFilter.gt("created", startDate), PropertyFilter.gt("priority", 3)))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testEqualAndInequalityRange() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(
                CompositeFilter.and(
                    PropertyFilter.eq("priority", 4),
                    PropertyFilter.gt("created", startDate),
                    PropertyFilter.lt("created", endDate)))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testInequalitySort() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(PropertyFilter.gt("priority", 3))
            .setOrderBy(OrderBy.asc("priority"), OrderBy.asc("created"))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testInequalitySortInvalidNotSame() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(PropertyFilter.gt("priority", 3))
            .setOrderBy(OrderBy.asc("created"))
            .build();
    assertInvalidQuery(query);
  }

  @Test
  public void testInequalitySortInvalidNotFirst() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(PropertyFilter.gt("priority", 3))
            .setOrderBy(OrderBy.asc("created"), OrderBy.asc("priority"))
            .build();
    assertInvalidQuery(query);
  }

  @Test
  public void testLimit() {
    Query<Entity> query = Query.newEntityQueryBuilder().setKind(TASK_CONCEPTS).setLimit(5).build();
    assertValidQuery(query);
  }

  @Test
  public void testCursorPaging() {
    datastore.put(testEntity);
    Cursor nextPageCursor = cursorPaging(1, null);
    assertNotNull(nextPageCursor);
    nextPageCursor = cursorPaging(1, nextPageCursor);
    assertNotNull(nextPageCursor);
  }

  private Cursor cursorPaging(int pageSize, Cursor pageCursor) {
    EntityQuery.Builder queryBuilder =
        Query.newEntityQueryBuilder().setKind(TASK_CONCEPTS).setLimit(pageSize);
    if (pageCursor != null) {
      queryBuilder.setStartCursor(pageCursor);
    }
    QueryResults<Entity> tasks = datastore.run(queryBuilder.build());
    while (tasks.hasNext()) {
      Entity task = tasks.next();
      // do something with the task
    }
    Cursor nextPageCursor = tasks.getCursorAfter();
    return nextPageCursor;
  }

  @Test
  public void testEventualConsistentQuery() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(
                PropertyFilter.hasAncestor(
                    datastore.newKeyFactory().setKind("TaskList").newKey("default")))
            .build();
    datastore.run(query, ReadOption.eventualConsistency());
    assertValidQuery(query);
  }

  @Test
  public void testUnindexedPropertyQuery() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(PropertyFilter.eq("description", "A task description"))
            .build();
    QueryResults<Entity> results = datastore.run(query);
    assertFalse(results.hasNext());
  }

  @Test
  public void testExplodingProperties() {
    Entity task =
        Entity.newBuilder(taskKey)
            .set("tags", "fun", "programming", "learn")
            .set("collaborators", "alice", "bob", "charlie")
            .set("created", Timestamp.now())
            .build();
    assertValidEntity(task);
  }

  @Test
  public void testTransactionalUpdate() {
    List<Key> keys = setUpTransferTests();
    transferFunds(keys.get(0), keys.get(1), 10);
    assertSuccessfulTransfer(keys.get(0), keys.get(1));
  }

  void transferFunds(Key fromKey, Key toKey, long amount) {
    Transaction txn = datastore.newTransaction();
    try {
      List<Entity> entities = txn.fetch(fromKey, toKey);
      Entity from = entities.get(0);
      Entity updatedFrom =
          Entity.newBuilder(from).set("balance", from.getLong("balance") - amount).build();
      Entity to = entities.get(1);
      Entity updatedTo =
          Entity.newBuilder(to).set("balance", to.getLong("balance") + amount).build();
      txn.put(updatedFrom, updatedTo);
      txn.commit();
    } finally {
      if (txn.isActive()) {
        txn.rollback();
      }
    }
  }

  @Test
  public void testTransactionalRetry() {
    List<Key> keys = setUpTransferTests();
    Key fromKey = keys.get(0);
    Key toKey = keys.get(1);
    int retries = 5;
    while (true) {
      try {
        transferFunds(fromKey, toKey, 10);
        break;
      } catch (DatastoreException e) {
        if (retries == 0) {
          throw e;
        }
        --retries;
      }
    }
    assertSuccessfulTransfer(keys.get(0), keys.get(1));
  }

  @Test
  public void testTransactionalGetOrCreate() {
    Entity task;
    Transaction txn = datastore.newTransaction();
    try {
      task = txn.get(taskKey);
      if (task == null) {
        task = Entity.newBuilder(taskKey).build();
        txn.put(task);
        txn.commit();
      }
    } finally {
      if (txn.isActive()) {
        txn.rollback();
      }
    }
    assertEquals(task, datastore.get(taskKey));
  }

  @Test
  public void testTransactionalSingleEntityGroupReadOnly() {

    Key taskListKey = datastore.newKeyFactory().setKind("TaskList").newKey("default");
    Entity taskListEntity = Entity.newBuilder(taskListKey).build();
    datastore.put(taskListEntity);
    Entity taskList;
    QueryResults<Entity> tasks;
    Transaction txn =
        datastore.newTransaction(
            TransactionOptions.newBuilder().setReadOnly(ReadOnly.newBuilder().build()).build());
    try {
      taskList = txn.get(taskListKey);
      Query<Entity> query =
          Query.newEntityQueryBuilder()
              .setKind(TASK_CONCEPTS)
              .setFilter(PropertyFilter.hasAncestor(taskListKey))
              .build();
      tasks = txn.run(query);
      txn.commit();
    } finally {
      if (txn.isActive()) {
        txn.rollback();
      }
    }
    assertEquals(taskListEntity, taskList);
    assertNotNull(tasks.next());
    assertFalse(tasks.hasNext());
  }

  @Test
  public void testNamespaceRunQuery() {
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("__namespace__");
    Key namespaceKey = keyFactory.newKey(OPTIONS.getNamespace());
    Query<Key> query =
        Query.newKeyQueryBuilder()
            .setKind("__namespace__")
            .setFilter(CompositeFilter.and(PropertyFilter.eq("__key__", namespaceKey)))
            .build();
    List<String> namespaces = new ArrayList<>();
    QueryResults<Key> results = datastore.run(query);
    while (results.hasNext()) {
      namespaces.add(results.next().getName());
    }
    assertEquals(ImmutableList.of(OPTIONS.getNamespace()), namespaces);
  }

  @Test
  public void testKindRunQuery() {
    Query<Key> query = Query.newKeyQueryBuilder().setKind("__kind__").build();
    List<String> kinds = new ArrayList<>();
    QueryResults<Key> results = datastore.run(query);
    while (results.hasNext()) {
      kinds.add(results.next().getName());
    }
    assertEquals(ImmutableList.of(TASK_CONCEPTS), kinds);
  }

  @Test
  public void testPropertyRunQuery() {
    Query<Key> query = Query.newKeyQueryBuilder().setKind("__property__").build();
    QueryResults<Key> keys = datastore.run(query);
    Map<String, Collection<String>> propertiesByKind = new HashMap<>();
    while (keys.hasNext()) {
      Key key = keys.next();
      String kind = key.getParent().getName();
      String propertyName = key.getName();
      Collection<String> properties = propertiesByKind.computeIfAbsent(kind, k -> new HashSet<>());
      properties.add(propertyName);
    }
    Map<String, ImmutableSet<String>> expected =
        ImmutableMap.of(
            TASK_CONCEPTS,
            ImmutableSet.of(
                "done", "category", "completed", "priority", "created", "percent_complete", "tag"));
    assertEquals(expected, propertiesByKind);
  }

  @Test
  public void testPropertyByKindRunQuery() {
    Key key = datastore.newKeyFactory().setKind("__kind__").newKey(TASK_CONCEPTS);
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind("__property__")
            .setFilter(PropertyFilter.hasAncestor(key))
            .build();
    QueryResults<Entity> results = datastore.run(query);
    Map<String, Collection<String>> representationsByProperty = new HashMap<>();
    while (results.hasNext()) {
      Entity result = results.next();
      String propertyName = result.getKey().getName();
      List<StringValue> representations = result.getList("property_representation");
      Collection<String> currentRepresentations =
          representationsByProperty.computeIfAbsent(propertyName, k -> new HashSet<>());
      for (StringValue value : representations) {
        currentRepresentations.add(value.get());
      }
    }
    Map<String, Collection<String>> expected =
        ImmutableMap.<String, Collection<String>>builder()
            .put("category", Collections.singleton("STRING"))
            .put("done", Collections.singleton("BOOLEAN"))
            .put("completed", Collections.singleton("BOOLEAN"))
            .put("priority", Collections.singleton("INT64"))
            .put("created", Collections.singleton("INT64"))
            .put("percent_complete", Collections.singleton("DOUBLE"))
            .put("tag", Collections.singleton("STRING"))
            .build();
    assertEquals(expected, representationsByProperty);
  }

  @Test
  public void testPropertyFilteringRunQuery() {
    Key startKey =
        datastore
            .newKeyFactory()
            .setKind("__property__")
            .addAncestors(PathElement.of("__kind__", TASK_CONCEPTS))
            .newKey("priority");
    Query<Key> query =
        Query.newKeyQueryBuilder()
            .setKind("__property__")
            .setFilter(PropertyFilter.ge("__key__", startKey))
            .build();
    Map<String, Collection<String>> propertiesByKind = new HashMap<>();
    QueryResults<Key> keys = datastore.run(query);
    while (keys.hasNext()) {
      Key key = keys.next();
      String kind = key.getParent().getName();
      String propertyName = key.getName();
      Collection<String> properties = propertiesByKind.computeIfAbsent(kind, k -> new HashSet<>());
      properties.add(propertyName);
    }
    Map<String, ImmutableSet<String>> expected =
        ImmutableMap.of(TASK_CONCEPTS, ImmutableSet.of("priority", "tag"));
    assertEquals(expected, propertiesByKind);
  }

  @Test
  public void testEqQuerySorted() {
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(PropertyFilter.eq("tag", "learn"))
            .setOrderBy(OrderBy.asc("tag"))
            .build();
    assertValidQuery(query);
  }

  private void setUpQueryTestsRealBackend() {
    Key taskKey =
        datastore
            .newKeyFactory()
            .setKind(TASK_CONCEPTS)
            .addAncestors(PathElement.of("TaskList", "default"))
            .newKey("someTask");
    datastore.put(
        Entity.newBuilder(taskKey)
            .set("category", "Personal")
            .set("done", false)
            .set("completed", false)
            .set("priority", 4)
            .set("created", includedDate)
            .set("percent_complete", 10.0)
            .set(
                "description",
                StringValue.newBuilder("Learn Cloud Datastore").setExcludeFromIndexes(true).build())
            .set("tag", "fun", "l", "programming", "learn")
            .build());
  }

  @Test
  public void testInQuery() {
    setUpQueryTestsRealBackend();
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(PropertyFilter.in("tag", ListValue.of("learn", "study")))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testNotEqualsQuery() {
    setUpQueryTestsRealBackend();
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(PropertyFilter.neq("category", "Work"))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testNotInQuery() {
    setUpQueryTestsRealBackend();
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(PropertyFilter.not_in("category", ListValue.of("Work", "Chores", "School")))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testInQuerySorted() {
    setUpQueryTestsRealBackend();
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(TASK_CONCEPTS)
            .setFilter(PropertyFilter.in("tag", ListValue.of("learn", "study")))
            .setOrderBy(OrderBy.asc("tag"))
            .build();
    assertValidQuery(query);
  }

  @Test
  public void testStaleReads() throws InterruptedException {
    setUpQueryTestsRealBackend();
    // waiting for 6 seconds, so that we can query with read time of 5 seconds ago
    TimeUnit.SECONDS.sleep(6);
    Key taskKey =
        datastore
            .newKeyFactory()
            .setKind(TASK_CONCEPTS)
            .addAncestors(PathElement.of("TaskList", "default"))
            .newKey("someTask");

    Timestamp fiveSecondsAgo =
        Timestamp.ofTimeSecondsAndNanos(Timestamp.now().getSeconds() - 5L, 0);
    // Create a readOption with read time fiveSecondsAgo
    ReadOption readOption = ReadOption.readTime(fiveSecondsAgo);
    // Use the readOption to Fetch entity
    Entity entity = datastore.get(taskKey, readOption);

    // Use the readOption to Query kind Task
    Query<Entity> query = Query.newEntityQueryBuilder().setKind(TASK_CONCEPTS).setLimit(10).build();
    assertValidQuery(query);
  }
}
