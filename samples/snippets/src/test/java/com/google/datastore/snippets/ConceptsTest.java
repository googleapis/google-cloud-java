/*
 * Copyright 2016 Google Inc.
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

package com.google.datastore.snippets;

import static java.util.Calendar.DECEMBER;
import static java.util.Calendar.JANUARY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.Cursor;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
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
import com.google.cloud.datastore.testing.LocalDatastoreHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.datastore.v1.TransactionOptions;
import com.google.datastore.v1.TransactionOptions.ReadOnly;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeoutException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

/**
 * Contains Cloud Datastore snippets demonstrating concepts for documentation.
 */
@RunWith(JUnit4.class)
public class ConceptsTest {

  private static final LocalDatastoreHelper HELPER = LocalDatastoreHelper.create(1.0);
  private static final FullEntity<IncompleteKey> TEST_FULL_ENTITY = FullEntity.newBuilder().build();

  private Datastore datastore;
  private KeyFactory keyFactory;
  private Key taskKey;
  private Entity testEntity;
  private Timestamp startDate;
  private Timestamp endDate;
  private Timestamp includedDate;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  /**
   * Starts the local Datastore emulator.
   *
   * @throws IOException if there are errors starting the local Datastore
   * @throws InterruptedException if there are errors starting the local Datastore
   */
  @BeforeClass
  public static void beforeClass() throws IOException, InterruptedException {
    HELPER.start();
  }

  /**
   * Initializes Datastore and cleans out any residual values.  Also initializes global variables
   * used for testing.
   */
  @Before
  public void setUp() {
    datastore = HELPER.getOptions().toBuilder().setNamespace("ghijklmnop").build().getService();
    StructuredQuery<Key> query = Query.newKeyQueryBuilder().build();
    QueryResults<Key> result = datastore.run(query);
    datastore.delete(Iterators.toArray(result, Key.class));
    keyFactory = datastore.newKeyFactory().setKind("Task");
    taskKey = keyFactory.newKey("some-arbitrary-key");
    testEntity = Entity.newBuilder(taskKey, TEST_FULL_ENTITY).build();
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    calendar.set(1990, JANUARY, 1);
    startDate = Timestamp.of(calendar.getTime());
    calendar.set(2000, JANUARY, 1);
    endDate = Timestamp.of(calendar.getTime());
    calendar.set(1999, DECEMBER, 31);
    includedDate = Timestamp.of(calendar.getTime());
  }

  /**
   * Stops the local Datastore emulator.
   *
   * @throws IOException if there are errors stopping the local Datastore
   * @throws InterruptedException if there are errors stopping the local Datastore
   */
  @AfterClass
  public static void afterClass() throws IOException, InterruptedException, TimeoutException {
    HELPER.stop(Duration.ofMinutes(1));
  }

  private void assertValidKey(Key taskKey) {
    datastore.put(Entity.newBuilder(taskKey, TEST_FULL_ENTITY).build());
  }

  @Test
  public void testIncompleteKey() {
    // [START datastore_incomplete_key]
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");
    Key taskKey = datastore.allocateId(keyFactory.newKey());
    // [END datastore_incomplete_key]
    assertValidKey(taskKey);
  }

  @Test
  public void testNamedKey() {
    // [START datastore_named_key]
    Key taskKey = datastore.newKeyFactory().setKind("Task").newKey("sampleTask");
    // [END datastore_named_key]
    assertValidKey(taskKey);
  }

  @Test
  public void testKeyWithParent() {
    // [START datastore_key_with_parent]
    Key taskKey = datastore.newKeyFactory()
        .addAncestors(PathElement.of("TaskList", "default"))
        .setKind("Task")
        .newKey("sampleTask");
    // [END datastore_key_with_parent]
    assertValidKey(taskKey);
  }

  @Test
  public void testKeyWithMultilevelParent() {
    // [START datastore_key_with_multilevel_parent]
    KeyFactory keyFactory = datastore.newKeyFactory()
        .addAncestors(PathElement.of("User", "Alice"), PathElement.of("TaskList", "default"))
        .setKind("Task");
    Key taskKey = keyFactory.newKey("sampleTask");
    // [END datastore_key_with_multilevel_parent]
    assertValidKey(taskKey);
  }

  private void assertValidEntity(Entity original) {
    datastore.put(original);
    assertEquals(original, datastore.get(original.getKey()));
  }

  @Test
  public void testEntityWithParent() {
    // [START datastore_entity_with_parent]
    Key taskKey = datastore.newKeyFactory()
        .addAncestors(PathElement.of("TaskList", "default"))
        .setKind("Task")
        .newKey("sampleTask");
    Entity task = Entity.newBuilder(taskKey)
        .set("category", "Personal")
        .set("done", false)
        .set("priority", 4)
        .set("description", "Learn Cloud Datastore")
        .build();
    // [END datastore_entity_with_parent]
    assertValidEntity(task);
  }

  @Test
  public void testProperties() {
    // [START datastore_properties]
    Entity task = Entity.newBuilder(taskKey)
        .set("category", "Personal")
        .set("created", Timestamp.now())
        .set("done", false)
        .set("priority", 4)
        .set("percent_complete", 10.0)
        .set("description",
          StringValue.newBuilder("Learn Cloud Datastore").setExcludeFromIndexes(true).build())
        .build();
    // [END datastore_properties]
    assertValidEntity(task);
  }

  @Test
  public void testArrayValue() {
    // [START datastore_array_value]
    Entity task = Entity.newBuilder(taskKey)
        .set("tags", "fun", "programming")
        .set("collaborators", "alice", "bob")
        .build();
    // [END datastore_array_value]
    assertValidEntity(task);
  }

  @Test
  public void testBasicEntity() {
    // [START datastore_basic_entity]
    Entity task = Entity.newBuilder(taskKey)
        .set("category", "Personal")
        .set("done", false)
        .set("priority", 4)
        .set("description", "Learn Cloud Datastore")
        .build();
    // [END datastore_basic_entity]
    assertValidEntity(task);
  }

  @Test
  public void testUpsert() {
    // [START datastore_upsert]
    Entity task = Entity.newBuilder(keyFactory.newKey("sampleTask")).build();
    datastore.put(task);
    // [END datastore_upsert]
    assertEquals(task, datastore.get(task.getKey()));
  }

  @Test
  public void testInsert() {
    // [START datastore_insert]
    Key taskKey = datastore.add(FullEntity.newBuilder(keyFactory.newKey()).build()).getKey();
    // [END datastore_insert]
    assertEquals(FullEntity.newBuilder(taskKey).build(), datastore.get(taskKey));
  }

  @Test
  public void testLookup() {
    datastore.put(testEntity);
    // [START datastore_lookup]
    Entity task = datastore.get(taskKey);
    // [END datastore_lookup]
    assertEquals(testEntity, task);
  }

  @Test
  public void testUpdate() {
    datastore.put(testEntity);
    // [START datastore_update]
    Entity task = Entity.newBuilder(datastore.get(taskKey)).set("priority", 5).build();
    datastore.update(task);
    // [END datastore_update]
    assertEquals(task, datastore.get(taskKey));
  }

  @Test
  public void testDelete() {
    datastore.put(testEntity);
    // [START datastore_delete]
    datastore.delete(taskKey);
    // [END datastore_delete]
    assertNull(datastore.get(taskKey));
  }

  private List<Entity> setUpBatchTests(Key taskKey1, Key taskKey2) {
    Entity task1 = Entity.newBuilder(taskKey1)
        .set("category", "Personal")
        .set("done", false)
        .set("priority", 4)
        .set("description", "Learn Cloud Datastore")
        .build();
    Entity task2 = Entity.newBuilder(taskKey2)
        .set("category", "Personal")
        .set("done", false)
        .set("priority", 5)
        .set("description", "Integrate Cloud Datastore")
        .build();
    datastore.put(task1, task2);
    return ImmutableList.of(task1, task2);
  }

  @Test
  public void testBatchUpsert() {
    // [START datastore_batch_upsert]
    FullEntity<IncompleteKey> task1 = FullEntity.newBuilder(keyFactory.newKey())
        .set("category", "Personal")
        .set("done", false)
        .set("priority", 4)
        .set("description", "Learn Cloud Datastore")
        .build();
    FullEntity<IncompleteKey> task2 = Entity.newBuilder(keyFactory.newKey())
        .set("category", "Personal")
        .set("done", false)
        .set("priority", 5)
        .set("description", "Integrate Cloud Datastore")
        .build();
    List<Entity> tasks = datastore.add(task1, task2);
    Key taskKey1 = tasks.get(0).getKey();
    Key taskKey2 = tasks.get(1).getKey();
    // [END datastore_batch_upsert]
    assertEquals(Entity.newBuilder(taskKey1, task1).build(), datastore.get(taskKey1));
    assertEquals(Entity.newBuilder(taskKey2, task2).build(), datastore.get(taskKey2));
  }

  @Test
  public void testBatchLookup() {
    Key taskKey1 = keyFactory.newKey(1);
    Key taskKey2 = keyFactory.newKey(2);
    List<Entity> expectedTasks = setUpBatchTests(taskKey1, taskKey2);
    // [START datastore_batch_lookup]
    Iterator<Entity> tasks = datastore.get(taskKey1, taskKey2);
    // [END datastore_batch_lookup]
    assertEquals(expectedTasks.get(0), tasks.next());
    assertEquals(expectedTasks.get(1), tasks.next());
  }

  @Test
  public void testBatchDelete() {
    Key taskKey1 = keyFactory.newKey(1);
    Key taskKey2 = keyFactory.newKey(2);
    setUpBatchTests(taskKey1, taskKey2);
    // [START datastore_batch_delete]
    datastore.delete(taskKey1, taskKey2);
    // [END datastore_batch_delete]
    assertNull(datastore.get(taskKey1));
    assertNull(datastore.get(taskKey2));
  }

  private void setUpQueryTests() {
    Key taskKey = datastore.newKeyFactory()
        .setKind("Task")
        .addAncestors(PathElement.of("TaskList", "default"))
        .newKey("someTask");
    datastore.put(Entity.newBuilder(taskKey)
        .set("category", "Personal")
        .set("done", false)
        .set("completed", false)
        .set("priority", 4)
        .set("created", includedDate)
        .set("percent_complete", 10.0)
        .set("description",
            StringValue.newBuilder("Learn Cloud Datastore").setExcludeFromIndexes(true).build())
        .set("tag", "fun", "l", "programming")
        .build());
  }

  private <V> V assertValidQuery(Query<V> query) {
    QueryResults<V> results = datastore.run(query);
    V result = results.next();
    assertFalse(results.hasNext());
    return result;
  }

  private <V> void assertInvalidQuery(Query<V> query) {
    thrown.expect(DatastoreException.class);
    datastore.run(query);
  }

  @Test
  public void testBasicQuery() {
    setUpQueryTests();
    // [START datastore_basic_query]
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Task")
        .setFilter(CompositeFilter.and(
            PropertyFilter.eq("done", false), PropertyFilter.ge("priority", 4)))
        .setOrderBy(OrderBy.desc("priority"))
        .build();
    // [END datastore_basic_query]
    assertValidQuery(query);
  }

  @Test
  public void testRunQuery() {
    setUpQueryTests();
    Query<Entity> query = Query.newEntityQueryBuilder().setKind("Task").build();
    // [START datastore_run_query]
    QueryResults<Entity> tasks = datastore.run(query);
    // [END datastore_run_query]
    assertNotNull(tasks.next());
    assertFalse(tasks.hasNext());
  }

  @Test
  public void testPropertyFilter() {
    setUpQueryTests();
    // [START datastore_property_filter]
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("Task").setFilter(PropertyFilter.eq("done", false))
        .build();
    // [END datastore_property_filter]
    assertValidQuery(query);
  }

  @Test
  public void testCompositeFilter() {
    setUpQueryTests();
    // [START datastore_composite_filter]
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Task")
        .setFilter(
            CompositeFilter.and(PropertyFilter.eq("done", false), PropertyFilter.eq("priority", 4)))
        .build();
    // [END datastore_composite_filter]
    assertValidQuery(query);
  }

  @Test
  public void testKeyFilter() {
    setUpQueryTests();
    // [START datastore_key_filter]
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Task")
        .setFilter(PropertyFilter.gt("__key__", keyFactory.newKey("someTask")))
        .build();
    // [END datastore_key_filter]
    assertValidQuery(query);
  }

  @Test
  public void testAscendingSort() {
    setUpQueryTests();
    // [START datastore_ascending_sort]
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("Task").setOrderBy(OrderBy.asc("created")).build();
    // [END datastore_ascending_sort]
    assertValidQuery(query);
  }

  @Test
  public void testDescendingSort() {
    setUpQueryTests();
    // [START datastore_descending_sort]
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("Task").setOrderBy(OrderBy.desc("created")).build();
    // [END datastore_descending_sort]
    assertValidQuery(query);
  }

  @Test
  public void testMultiSort() {
    setUpQueryTests();
    // [START datastore_multi_sort]
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Task")
        .setOrderBy(OrderBy.desc("priority"), OrderBy.asc("created"))
        .build();
    // [END datastore_multi_sort]
    assertValidQuery(query);
  }

  @Test
  public void testKindlessQuery() {
    Key lastSeenKey = keyFactory.newKey("a");
    setUpQueryTests();
    // [START datastore_kindless_query]
    Query<Entity> query =
        Query.newEntityQueryBuilder().setFilter(PropertyFilter.gt("__key__", lastSeenKey)).build();
    // [END datastore_kindless_query]
    assertValidQuery(query);
  }

  @Test
  public void testAncestorQuery() {
    setUpQueryTests();
    // [START datastore_ancestor_query]
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Task")
        .setFilter(PropertyFilter.hasAncestor(
            datastore.newKeyFactory().setKind("TaskList").newKey("default")))
        .build();
    // [END datastore_ancestor_query]
    assertValidQuery(query);
  }

  @Test
  public void testProjectionQuery() {
    setUpQueryTests();
    // [START datastore_projection_query]
    Query<ProjectionEntity> query = Query.newProjectionEntityQueryBuilder()
        .setKind("Task")
        .setProjection("priority", "percent_complete")
        .build();
    // [END datastore_projection_query]
    assertValidQuery(query);
  }

  @Test
  public void testRunProjectionQuery() {
    setUpQueryTests();
    Query<ProjectionEntity> query = Query.newProjectionEntityQueryBuilder()
        .setKind("Task")
        .setProjection("priority", "percent_complete")
        .build();
    // [START datastore_run_query_projection]
    List<Long> priorities = new LinkedList<>();
    List<Double> percentCompletes = new LinkedList<>();
    QueryResults<ProjectionEntity> tasks = datastore.run(query);
    while (tasks.hasNext()) {
      ProjectionEntity task = tasks.next();
      priorities.add(task.getLong("priority"));
      percentCompletes.add(task.getDouble("percent_complete"));
    }
    // [END datastore_run_query_projection]
    assertEquals(ImmutableList.of(4L), priorities);
    assertEquals(ImmutableList.of(10.0), percentCompletes);
  }

  @Test
  public void testKeysOnlyQuery() {
    setUpQueryTests();
    // [START datastore_keys_only_query]
    Query<Key> query = Query.newKeyQueryBuilder().setKind("Task").build();
    // [END datastore_keys_only_query]
    assertValidQuery(query);
  }

  @Test
  public void testDistinctOnQuery() {
    setUpQueryTests();
    // [START datastore_distinct_on_query]
    Query<ProjectionEntity> query = Query.newProjectionEntityQueryBuilder()
        .setKind("Task")
        .setProjection("category", "priority")
        .setDistinctOn("category")
        .setOrderBy(OrderBy.asc("category"), OrderBy.asc("priority"))
        .build();
    // [END datastore_distinct_on_query]
    assertValidQuery(query);
  }

  @Test
  public void testArrayValueInequalityRange() {
    setUpQueryTests();
    // [START datastore_array_value_inequality_range]
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Task")
        .setFilter(CompositeFilter.and(
            PropertyFilter.gt("tag", "learn"), PropertyFilter.lt("tag", "math")))
        .build();
    // [END datastore_array_value_inequality_range]
    QueryResults<Entity> results = datastore.run(query);
    assertFalse(results.hasNext());
  }

  @Test
  public void testArrayValueEquality() {
    setUpQueryTests();
    // [START datastore_array_value_equality]
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Task")
        .setFilter(CompositeFilter.and(
            PropertyFilter.eq("tag", "fun"), PropertyFilter.eq("tag", "programming")))
        .build();
    // [END datastore_array_value_equality]
    assertValidQuery(query);
  }

  @Test
  public void testInequalityRange() {
    setUpQueryTests();
    // [START datastore_inequality_range]
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Task")
        .setFilter(CompositeFilter.and(
            PropertyFilter.gt("created", startDate), PropertyFilter.lt("created", endDate)))
        .build();
    // [END datastore_inequality_range]
    assertValidQuery(query);
  }

  @Test
  public void testInequalityInvalid() {
    // [START datastore_inequality_invalid]
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Task")
        .setFilter(CompositeFilter.and(
            PropertyFilter.gt("created", startDate), PropertyFilter.gt("priority", 3)))
        .build();
    // [END datastore_inequality_invalid]
    assertInvalidQuery(query);
  }

  @Test
  public void testEqualAndInequalityRange() {
    setUpQueryTests();
    // [START datastore_equal_and_inequality_range]
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Task")
        .setFilter(CompositeFilter.and(PropertyFilter.eq("priority", 4),
            PropertyFilter.gt("created", startDate), PropertyFilter.lt("created", endDate)))
        .build();
    // [END datastore_equal_and_inequality_range]
    assertValidQuery(query);
  }

  @Test
  public void testInequalitySort() {
    setUpQueryTests();
    // [START datastore_inequality_sort]
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Task")
        .setFilter(PropertyFilter.gt("priority", 3))
        .setOrderBy(OrderBy.asc("priority"), OrderBy.asc("created"))
        .build();
    // [END datastore_inequality_sort]
    assertValidQuery(query);
  }

  @Test
  public void testInequalitySortInvalidNotSame() {
    // [START datastore_inequality_sort_invalid_not_same]
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Task")
        .setFilter(PropertyFilter.gt("priority", 3))
        .setOrderBy(OrderBy.asc("created"))
        .build();
    // [END datastore_inequality_sort_invalid_not_same]
    assertInvalidQuery(query);
  }

  @Test
  public void testInequalitySortInvalidNotFirst() {
    // [START datastore_inequality_sort_invalid_not_first]
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Task")
        .setFilter(PropertyFilter.gt("priority", 3))
        .setOrderBy(OrderBy.asc("created"), OrderBy.asc("priority"))
        .build();
    // [END datastore_inequality_sort_invalid_not_first]
    assertInvalidQuery(query);
  }

  @Test
  public void testLimit() {
    setUpQueryTests();
    // [START datastore_limit]
    Query<Entity> query = Query.newEntityQueryBuilder().setKind("Task").setLimit(5).build();
    // [END datastore_limit]
    assertValidQuery(query);
  }

  @Test
  public void testCursorPaging() {
    setUpQueryTests();
    datastore.put(testEntity);
    Cursor nextPageCursor = cursorPaging(1, null);
    assertNotNull(nextPageCursor);
    nextPageCursor = cursorPaging(1, nextPageCursor);
    assertNotNull(nextPageCursor);
  }

  private Cursor cursorPaging(int pageSize, Cursor pageCursor) {
    // [START datastore_cursor_paging]
    EntityQuery.Builder queryBuilder = Query.newEntityQueryBuilder().setKind("Task")
        .setLimit(pageSize);
    if (pageCursor != null) {
      queryBuilder.setStartCursor(pageCursor);
    }
    QueryResults<Entity> tasks = datastore.run(queryBuilder.build());
    while (tasks.hasNext()) {
      Entity task = tasks.next();
      // do something with the task
    }
    Cursor nextPageCursor = tasks.getCursorAfter();
    // [END datastore_cursor_paging]
    return nextPageCursor;
  }

  @Test
  public void testEventualConsistentQuery() {
    setUpQueryTests();
    // [START datastore_eventual_consistent_query]
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Task")
        .setFilter(PropertyFilter.hasAncestor(
            datastore.newKeyFactory().setKind("TaskList").newKey("default")))
        .build();
    datastore.run(query, ReadOption.eventualConsistency());
    // [END datastore_eventual_consistent_query]
    assertValidQuery(query);
  }

  @Test
  public void testUnindexedPropertyQuery() {
    setUpQueryTests();
    // [START datastore_unindexed_property_query]
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Task")
        .setFilter(PropertyFilter.eq("description", "A task description"))
        .build();
    // [END datastore_unindexed_property_query]
    QueryResults<Entity> results = datastore.run(query);
    assertFalse(results.hasNext());
  }

  @Test
  public void testExplodingProperties() {
    // [START datastore_exploding_properties]
    Entity task = Entity.newBuilder(taskKey)
        .set("tags", "fun", "programming", "learn")
        .set("collaborators", "alice", "bob", "charlie")
        .set("created", Timestamp.now())
        .build();
    // [END datastore_exploding_properties]
    assertValidEntity(task);
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
  public void testTransactionalUpdate() {
    List<Key> keys = setUpTransferTests();
    transferFunds(keys.get(0), keys.get(1), 10);
    assertSuccessfulTransfer(keys.get(0), keys.get(1));
  }

  // [START datastore_transactional_update]
  void transferFunds(Key fromKey, Key toKey, long amount) {
    Transaction txn = datastore.newTransaction();
    try {
      List<Entity> entities = txn.fetch(fromKey, toKey);
      Entity from = entities.get(0);
      Entity updatedFrom =
          Entity.newBuilder(from).set("balance", from.getLong("balance") - amount).build();
      Entity to = entities.get(1);
      Entity updatedTo = Entity.newBuilder(to).set("balance", to.getLong("balance") + amount)
          .build();
      txn.put(updatedFrom, updatedTo);
      txn.commit();
    } finally {
      if (txn.isActive()) {
        txn.rollback();
      }
    }
  }
  // [END datastore_transactional_update]

  @Test
  public void testTransactionalRetry() {
    List<Key> keys = setUpTransferTests();
    Key fromKey = keys.get(0);
    Key toKey = keys.get(1);
    // [START datastore_transactional_retry]
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
    // Retry handling can also be configured and automatically applied using google-cloud-java.
    // [END datastore_transactional_retry]
    assertSuccessfulTransfer(keys.get(0), keys.get(1));
  }

  @Test
  public void testTransactionalGetOrCreate() {
    // [START datastore_transactional_get_or_create]
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
    // [END datastore_transactional_get_or_create]
    assertEquals(task, datastore.get(taskKey));
  }

  @Test
  public void testTransactionalSingleEntityGroupReadOnly() {
    setUpQueryTests();
    Key taskListKey = datastore.newKeyFactory().setKind("TaskList").newKey("default");
    Entity taskListEntity = Entity.newBuilder(taskListKey).build();
    datastore.put(taskListEntity);
    // [START datastore_transactional_single_entity_group_read_only]
    Entity taskList;
    QueryResults<Entity> tasks;
    Transaction txn = datastore.newTransaction(
        TransactionOptions.newBuilder()
            .setReadOnly(ReadOnly.newBuilder().build())
            .build()
    );
    try {
      taskList = txn.get(taskListKey);
      Query<Entity> query = Query.newEntityQueryBuilder()
          .setKind("Task")
          .setFilter(PropertyFilter.hasAncestor(taskListKey))
          .build();
      tasks = txn.run(query);
      txn.commit();
    } finally {
      if (txn.isActive()) {
        txn.rollback();
      }
    }
    // [END datastore_transactional_single_entity_group_read_only]
    assertEquals(taskListEntity, taskList);
    assertNotNull(tasks.next());
    assertFalse(tasks.hasNext());
  }

  @Test
  public void testNamespaceRunQuery() {
    setUpQueryTests();
    // [START datastore_namespace_run_query]
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("__namespace__");
    Key startNamespace = keyFactory.newKey("g");
    Key endNamespace = keyFactory.newKey("h");
    Query<Key> query = Query.newKeyQueryBuilder()
        .setKind("__namespace__")
        .setFilter(CompositeFilter.and(
            PropertyFilter.gt("__key__", startNamespace),
            PropertyFilter.lt("__key__", endNamespace)))
        .build();
    List<String> namespaces = new ArrayList<>();
    QueryResults<Key> results = datastore.run(query);
    while (results.hasNext()) {
      namespaces.add(results.next().getName());
    }
    // [END datastore_namespace_run_query]
    assertEquals(ImmutableList.of("ghijklmnop"), namespaces);
  }

  @Test
  public void testKindRunQuery() {
    setUpQueryTests();
    // [START datastore_kind_run_query]
    Query<Key> query = Query.newKeyQueryBuilder().setKind("__kind__").build();
    List<String> kinds = new ArrayList<>();
    QueryResults<Key> results = datastore.run(query);
    while (results.hasNext()) {
      kinds.add(results.next().getName());
    }
    // [END datastore_kind_run_query]
    assertEquals(ImmutableList.of("Task"), kinds);
  }

  @Test
  public void testPropertyRunQuery() {
    setUpQueryTests();
    // [START datastore_property_run_query]
    Query<Key> query = Query.newKeyQueryBuilder().setKind("__property__").build();
    QueryResults<Key> keys = datastore.run(query);
    Map<String, Collection<String>> propertiesByKind = new HashMap<>();
    while (keys.hasNext()) {
      Key key = keys.next();
      String kind = key.getParent().getName();
      String propertyName = key.getName();
      Collection<String> properties = propertiesByKind.get(kind);
      if (properties == null) {
        properties = new HashSet<>();
        propertiesByKind.put(kind, properties);
      }
      properties.add(propertyName);
    }
    // [END datastore_property_run_query]
    Map<String, ImmutableSet<String>> expected = ImmutableMap.of("Task", ImmutableSet.of(
        "done", "category", "done", "completed", "priority", "created", "percent_complete", "tag"));
    assertEquals(expected, propertiesByKind);
  }

  @Test
  public void testPropertyByKindRunQuery() {
    setUpQueryTests();
    // [START datastore_property_by_kind_run_query]
    Key key = datastore.newKeyFactory().setKind("__kind__").newKey("Task");
    Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("__property__")
        .setFilter(PropertyFilter.hasAncestor(key))
        .build();
    QueryResults<Entity> results = datastore.run(query);
    Map<String, Collection<String>> representationsByProperty = new HashMap<>();
    while (results.hasNext()) {
      Entity result = results.next();
      String propertyName = result.getKey().getName();
      List<StringValue> representations = result.getList("property_representation");
      Collection<String> currentRepresentations = representationsByProperty.get(propertyName);
      if (currentRepresentations == null) {
        currentRepresentations = new HashSet<>();
        representationsByProperty.put(propertyName, currentRepresentations);
      }
      for (StringValue value : representations) {
        currentRepresentations.add(value.get());
      }
    }
    // [END datastore_property_by_kind_run_query]
    Map<String, Collection<String>> expected = ImmutableMap.<String, Collection<String>>builder()
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
    setUpQueryTests();
    // [START datastore_property_filtering_run_query]
    Key startKey = datastore.newKeyFactory()
        .setKind("__property__")
        .addAncestors(PathElement.of("__kind__", "Task"))
        .newKey("priority");
    Query<Key> query = Query.newKeyQueryBuilder()
        .setKind("__property__")
        .setFilter(PropertyFilter.ge("__key__", startKey))
        .build();
    Map<String, Collection<String>> propertiesByKind = new HashMap<>();
    QueryResults<Key> keys = datastore.run(query);
    while (keys.hasNext()) {
      Key key = keys.next();
      String kind = key.getParent().getName();
      String propertyName = key.getName();
      Collection<String> properties = propertiesByKind.get(kind);
      if (properties == null) {
        properties = new HashSet<String>();
        propertiesByKind.put(kind, properties);
      }
      properties.add(propertyName);
    }
    // [END datastore_property_filtering_run_query]
    Map<String, ImmutableSet<String>> expected =
        ImmutableMap.of("Task", ImmutableSet.of("priority", "tag"));
    assertEquals(expected, propertiesByKind);
  }
}
