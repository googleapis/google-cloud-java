/*
 * Copyright 2016 Google LLC
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

import static com.google.cloud.datastore.aggregation.Aggregation.avg;
import static com.google.cloud.datastore.aggregation.Aggregation.count;
import static com.google.cloud.datastore.aggregation.Aggregation.sum;
import static com.google.common.collect.Iterables.getOnlyElement;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.Timestamp;
import com.google.cloud.Tuple;
import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.AggregationResults;
import com.google.cloud.datastore.Batch;
import com.google.cloud.datastore.BooleanValue;
import com.google.cloud.datastore.Cursor;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Datastore.TransactionCallable;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.DatastoreReaderWriter;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
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
import com.google.cloud.datastore.ReadOption;
import com.google.cloud.datastore.StringValue;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.StructuredQuery.CompositeFilter;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.cloud.datastore.TimestampValue;
import com.google.cloud.datastore.Transaction;
import com.google.cloud.datastore.ValueType;
import com.google.cloud.datastore.models.ExecutionStats;
import com.google.cloud.datastore.models.ExplainMetrics;
import com.google.cloud.datastore.models.ExplainOptions;
import com.google.cloud.datastore.models.PlanSummary;
import com.google.cloud.datastore.testing.RemoteDatastoreHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import com.google.common.truth.Truth;
import com.google.datastore.v1.TransactionOptions;
import com.google.datastore.v1.TransactionOptions.ReadOnly;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.threeten.bp.Duration;

@RunWith(Parameterized.class)
public class ITDatastoreTest {

  private static final RemoteDatastoreHelper HELPER = RemoteDatastoreHelper.create();
  private static final DatastoreOptions OPTIONS_1 = HELPER.getOptions();
  private static final Datastore DATASTORE_1 = OPTIONS_1.getService();

  private static final String CUSTOM_DB_ID = "test-db";
  private static final RemoteDatastoreHelper HELPER2 = RemoteDatastoreHelper.create(CUSTOM_DB_ID);
  private static final DatastoreOptions OPTIONS_2 = HELPER2.getOptions();
  private static final Datastore DATASTORE_2 = OPTIONS_2.getService();

  private final DatastoreOptions options;
  private final Datastore datastore;

  private static String PROJECT_ID;
  private static String NAMESPACE;
  private static final String KIND1 = "kind1";
  private static final String KIND2 = "kind2";
  private static final String KIND3 = "kind3";
  private static final NullValue NULL_VALUE = NullValue.of();
  private static final StringValue STR_VALUE = StringValue.of("str");
  private static final BooleanValue BOOL_VALUE =
      BooleanValue.newBuilder(false).setExcludeFromIndexes(true).build();
  private static final ListValue EMPTY_LIST_VALUE = ListValue.of(Collections.emptyList());
  private static final ListValue LIST_VALUE1 =
      ListValue.newBuilder().addValue(NULL_VALUE).addValue(STR_VALUE, BOOL_VALUE).build();
  private static final TimestampValue TIMESTAMP_VALUE = new TimestampValue(Timestamp.now());
  private static final LatLngValue LAT_LNG_VALUE =
      new LatLngValue(LatLng.of(37.422035, -122.084124));

  private static Key ROOT_KEY;
  private static IncompleteKey INCOMPLETE_KEY1;
  private static ListValue LIST_VALUE2;
  private static Key KEY1;
  private static Key KEY2;
  private static Key KEY3;
  private static Key KEY4;
  private static Key KEY5;
  private static final String MARKS_KIND = "Marks";
  private static FullEntity<IncompleteKey> PARTIAL_ENTITY1;
  private static FullEntity<IncompleteKey> PARTIAL_ENTITY2;
  private static FullEntity<IncompleteKey> PARTIAL_ENTITY3;
  private static Entity ENTITY1;
  private static Entity ENTITY2;
  private static Entity ENTITY3;

  private static Entity AGGREGATION_ENTITY_1;
  private static Entity AGGREGATION_ENTITY_2;
  private static Entity AGGREGATION_ENTITY_3;

  @Rule public Timeout globalTimeout = Timeout.seconds(100);

  @Rule public MultipleAttemptsRule multipleAttemptsRule = new MultipleAttemptsRule(3);

  @AfterClass
  public static void afterClass() {
    HELPER.deleteNamespace();
  }

  public ITDatastoreTest(
      DatastoreOptions options,
      Datastore datastore,
      // databaseType is unused as a variable, but used as a parameterized label when running tests
      String databaseType) {
    this.options = options;
    this.datastore = datastore;

    PROJECT_ID = this.options.getProjectId();
    NAMESPACE = this.options.getNamespace();

    ROOT_KEY =
        Key.newBuilder(PROJECT_ID, "rootkey", "default", options.getDatabaseId())
            .setNamespace(NAMESPACE)
            .build();
    INCOMPLETE_KEY1 = IncompleteKey.newBuilder(ROOT_KEY, KIND1).setNamespace(NAMESPACE).build();

    IncompleteKey INCOMPLETE_KEY2 =
        IncompleteKey.newBuilder(PROJECT_ID, KIND2)
            .setDatabaseId(options.getDatabaseId())
            .setNamespace(NAMESPACE)
            .build();

    KEY1 = Key.newBuilder(INCOMPLETE_KEY1, "name").build();
    KEY2 = Key.newBuilder(KEY1, KIND2, 1).build();
    KEY3 = Key.newBuilder(KEY2).setName("bla").setNamespace(NAMESPACE).build();
    KEY4 = Key.newBuilder(KEY2).setName("newName1").setNamespace(NAMESPACE).build();
    KEY5 = Key.newBuilder(KEY2).setName("newName2").setNamespace(NAMESPACE).build();

    LIST_VALUE2 = ListValue.of(Collections.singletonList(KeyValue.of(KEY1)));

    PARTIAL_ENTITY1 =
        FullEntity.newBuilder(INCOMPLETE_KEY2)
            .set("str", STR_VALUE)
            .set("bool", BOOL_VALUE)
            .set("list", LIST_VALUE1)
            .build();
    PARTIAL_ENTITY2 =
        FullEntity.newBuilder(PARTIAL_ENTITY1)
            .remove("str")
            .set("bool", true)
            .set("list", LIST_VALUE1.get())
            .build();
    PARTIAL_ENTITY3 =
        FullEntity.newBuilder(PARTIAL_ENTITY1)
            .setKey(
                IncompleteKey.newBuilder(PROJECT_ID, KIND3)
                    .setNamespace(NAMESPACE)
                    .setDatabaseId(options.getDatabaseId())
                    .build())
            .build();
    ENTITY1 =
        Entity.newBuilder(KEY1)
            .set("str", STR_VALUE)
            .set("date", TIMESTAMP_VALUE)
            .set("latLng", LAT_LNG_VALUE)
            .set("bool", BOOL_VALUE)
            .set("partial1", EntityValue.of(PARTIAL_ENTITY1))
            .set("list", LIST_VALUE2)
            .set("emptyList", EMPTY_LIST_VALUE)
            .build();
    ENTITY2 =
        Entity.newBuilder(ENTITY1)
            .setKey(KEY2)
            .remove("str")
            .set("name", "Dan")
            .setNull("null")
            .set("age", 20)
            .build();
    ENTITY3 =
        Entity.newBuilder(ENTITY1)
            .setKey(KEY3)
            .remove("str")
            .set("null", NULL_VALUE)
            .set("partial1", PARTIAL_ENTITY2)
            .set("partial2", ENTITY2)
            .build();

    Key aggregationKey1 = datastore.newKeyFactory().setKind(MARKS_KIND).newKey(1);
    Key aggregationKey2 = datastore.newKeyFactory().setKind(MARKS_KIND).newKey(2);
    Key aggregationKey3 = datastore.newKeyFactory().setKind(MARKS_KIND).newKey(3);

    AGGREGATION_ENTITY_1 =
        Entity.newBuilder(aggregationKey1)
            .set("name", "Person1")
            .set("marks", 89)
            .set("cgpa", 7.34)
            .build();
    AGGREGATION_ENTITY_2 =
        Entity.newBuilder(aggregationKey2)
            .set("name", "Person2")
            .set("marks", 95)
            .set("cgpa", 9.27)
            .build();
    AGGREGATION_ENTITY_3 =
        Entity.newBuilder(aggregationKey3)
            .set("name", "Person3")
            .set("marks", 55)
            .set("cgpa", 5.16)
            .build();
  }

  @Before
  public void setUp() {
    datastore.put(ENTITY1, ENTITY2);
  }

  @After
  public void tearDown() {
    EntityQuery allEntitiesQuery = Query.newEntityQueryBuilder().build();
    QueryResults<Entity> allEntities = datastore.run(allEntitiesQuery);
    Key[] keysToDelete =
        ImmutableList.copyOf(allEntities).stream().map(Entity::getKey).toArray(Key[]::new);
    datastore.delete(keysToDelete);
  }

  @Parameterized.Parameters(name = "database: {2}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(
        new Object[][] {{OPTIONS_1, DATASTORE_1, "default"}, {OPTIONS_2, DATASTORE_2, "test-db"}});
  }

  private <T> Iterator<T> getStronglyConsistentResults(Query scQuery, Query query)
      throws InterruptedException {
    // scQuery is equivalent to query, but with an ancestor filter in it
    // this makes scQuery strongly consistent
    QueryResults<T> scResults = datastore.run(scQuery);
    List<T> scResultsCopy = makeResultsCopy(scResults);
    Set<T> scResultsSet = new HashSet<>(scResultsCopy);
    int maxAttempts = 20;

    while (maxAttempts > 0) {
      --maxAttempts;
      QueryResults<T> results = datastore.run(query);
      List<T> resultsCopy = makeResultsCopy(results);
      Set<T> resultsSet = new HashSet<>(resultsCopy);
      if (scResultsSet.size() == resultsSet.size() && scResultsSet.containsAll(resultsSet)) {
        return resultsCopy.iterator();
      }
      Thread.sleep(500);
    }

    throw new RuntimeException(
        "reached max number of attempts to get strongly consistent results.");
  }

  private <T> List<T> makeResultsCopy(QueryResults<T> scResults) {
    Preconditions.checkNotNull(scResults);
    List<T> results = new ArrayList<>();
    while (scResults.hasNext()) {
      results.add(scResults.next());
    }
    return results;
  }

  @Test
  public void orQuery() {
    Key key = Key.newBuilder(KEY1, KIND2, 2).build();
    Entity entity3 =
        Entity.newBuilder(ENTITY1)
            .setKey(key)
            .remove("str")
            .set("name", "Dan")
            .setNull("null")
            .set("age", 19)
            .build();
    datastore.put(entity3);

    // age == 19 || age == 20
    CompositeFilter orFilter =
        CompositeFilter.or(PropertyFilter.eq("age", 19), PropertyFilter.eq("age", 20));
    Query<Entity> simpleOrQuery =
        Query.newEntityQueryBuilder()
            .setNamespace(NAMESPACE)
            .setKind(KIND2)
            .setFilter(orFilter)
            .build();
    QueryResults<Entity> results = datastore.run(simpleOrQuery);
    assertTrue(results.hasNext());
    assertEquals(ENTITY2, results.next());
    assertTrue(results.hasNext());
    assertEquals(entity3, results.next());
    assertFalse(results.hasNext());

    // age == 19 || age == 20 with limit of 1
    Query<Entity> simpleOrQueryLimit =
        Query.newEntityQueryBuilder()
            .setNamespace(NAMESPACE)
            .setKind(KIND2)
            .setFilter(orFilter)
            .setLimit(1)
            .build();
    QueryResults<Entity> results2 = datastore.run(simpleOrQueryLimit);
    assertTrue(results2.hasNext());
    assertEquals(ENTITY2, results2.next());
    assertFalse(results2.hasNext());

    // (age == 18 && name == Dan) || (age == 20 && name == Dan)
    CompositeFilter nestedOr =
        CompositeFilter.or(
            CompositeFilter.and(PropertyFilter.eq("age", 18), PropertyFilter.eq("name", "Dan")),
            CompositeFilter.and(PropertyFilter.eq("age", 20), PropertyFilter.eq("name", "Dan")));
    CompositeFilter compositeFilter =
        CompositeFilter.and(PropertyFilter.hasAncestor(ROOT_KEY), nestedOr);
    Query<Entity> orQueryNested =
        Query.newEntityQueryBuilder()
            .setNamespace(NAMESPACE)
            .setKind(KIND2)
            .setFilter(compositeFilter)
            .build();
    QueryResults<Entity> results3 = datastore.run(orQueryNested);
    assertTrue(results3.hasNext());
    assertEquals(ENTITY2, results3.next());
    assertFalse(results3.hasNext());

    // age == 20 && (name == Bob || name == Dan)
    CompositeFilter nestedOr2 =
        CompositeFilter.or(PropertyFilter.eq("name", "Dan"), PropertyFilter.eq("name", "Bob"));
    CompositeFilter andFilter = CompositeFilter.and(PropertyFilter.eq("age", 20), nestedOr2);
    CompositeFilter ancestorAndFilter =
        CompositeFilter.and(PropertyFilter.hasAncestor(ROOT_KEY), andFilter);
    Query<Entity> orQueryNested2 =
        Query.newEntityQueryBuilder()
            .setNamespace(NAMESPACE)
            .setKind(KIND2)
            .setFilter(ancestorAndFilter)
            .setLimit(1)
            .build();
    QueryResults<Entity> results4 = datastore.run(orQueryNested2);
    assertTrue(results4.hasNext());
    assertEquals(ENTITY2, results4.next());
    assertFalse(results4.hasNext());
  }

  @Test
  public void testQueryProfile() {
    Key key = Key.newBuilder(KEY1, KIND2, 2).build();
    Entity entity3 =
        Entity.newBuilder(ENTITY1)
            .setKey(key)
            .remove("str")
            .set("name", "Dan")
            .setNull("null")
            .set("age", 19)
            .build();
    datastore.put(entity3);

    // age == 19 || age == 20
    CompositeFilter orFilter =
        CompositeFilter.or(PropertyFilter.eq("age", 19), PropertyFilter.eq("age", 20));
    StructuredQuery<Entity> simpleOrQuery =
        Query.newEntityQueryBuilder()
            .setNamespace(NAMESPACE)
            .setKind(KIND2)
            .setFilter(orFilter)
            .build();
    QueryResults<Entity> results =
        datastore.run(simpleOrQuery, ExplainOptions.newBuilder().setAnalyze(true).build());
    Truth.assertThat(results.hasNext()).isTrue();
    Truth.assertThat(results.getExplainMetrics().isPresent()).isTrue();
    assertPlanSummary(results.getExplainMetrics().get().getPlanSummary());
    assertExecutionStats(results.getExplainMetrics().get().getExecutionStats().get(), 2, 2, "2");

    QueryResults<Entity> results2 =
        datastore.run(simpleOrQuery, ExplainOptions.newBuilder().build());
    Truth.assertThat(results2.hasNext()).isFalse();
    assertPlanSummary(results2.getExplainMetrics().get().getPlanSummary());
    Truth.assertThat(results2.getExplainMetrics().get().getExecutionStats().isPresent()).isFalse();

    QueryResults<Entity> results3 = datastore.run(simpleOrQuery);
    Truth.assertThat(results3.hasNext()).isTrue();
    Truth.assertThat(results3.getExplainMetrics().isPresent()).isFalse();

    QueryResults<Entity> results4 =
        datastore.run(simpleOrQuery, ExplainOptions.newBuilder().setAnalyze(false).build());
    Truth.assertThat(results4.hasNext()).isFalse();
    assertPlanSummary(results4.getExplainMetrics().get().getPlanSummary());
    Truth.assertThat(results4.getExplainMetrics().get().getExecutionStats().isPresent()).isFalse();

    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder().over(simpleOrQuery).addAggregation(count()).build();
    AggregationResults resultsAggregation =
        datastore.runAggregation(
            aggregationQuery, ExplainOptions.newBuilder().setAnalyze(true).build());

    Truth.assertThat(resultsAggregation.size() > 0).isTrue();

    assertPlanSummary(resultsAggregation.getExplainMetrics().get().getPlanSummary());
    assertExecutionStats(
        resultsAggregation.getExplainMetrics().get().getExecutionStats().get(), 1, 1, "2");

    AggregationQuery aggregationQuery2 =
        Query.newAggregationQueryBuilder().over(simpleOrQuery).addAggregation(count()).build();
    AggregationResults resultsAggregation2 =
        datastore.runAggregation(aggregationQuery2, ExplainOptions.newBuilder().build());

    Truth.assertThat(resultsAggregation2.size() > 0).isFalse();

    assertPlanSummary(resultsAggregation2.getExplainMetrics().get().getPlanSummary());
    Truth.assertThat(resultsAggregation2.getExplainMetrics().get().getExecutionStats().isPresent())
        .isFalse();

    AggregationQuery aggregationQuery3 =
        Query.newAggregationQueryBuilder().over(simpleOrQuery).addAggregation(count()).build();
    AggregationResults resultsAggregation3 = datastore.runAggregation(aggregationQuery3);

    Truth.assertThat(resultsAggregation3.size() > 0).isTrue();
    Truth.assertThat(resultsAggregation3.getExplainMetrics().isPresent()).isFalse();
  }

  @Test
  public void testNewTransactionCommit() {
    Transaction transaction = datastore.newTransaction();
    transaction.add(ENTITY3);
    Entity entity2 = Entity.newBuilder(ENTITY2).clear().setNull("bla").build();
    transaction.update(entity2);
    transaction.delete(KEY1);
    transaction.commit();
    assertFalse(transaction.isActive());

    List<Entity> list = datastore.fetch(KEY1, KEY2, KEY3);
    assertNull(list.get(0));
    assertEquals(entity2, list.get(1));
    assertEquals(ENTITY3, list.get(2));
    assertEquals(3, list.size());

    try {
      transaction.commit();
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      assertDatastoreException(expected, "FAILED_PRECONDITION", 0);
    }

    try {
      transaction.rollback();
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      assertDatastoreException(expected, "FAILED_PRECONDITION", 0);
    }
  }

  @Test
  public void testTransactionWithRead() throws Exception {
    StatementExecutor statementExecutor = new StatementExecutor();
    Transaction baseTransaction = datastore.newTransaction();
    assertNull(baseTransaction.get(KEY3));
    baseTransaction.add(ENTITY3);
    baseTransaction.commit();
    assertEquals(ENTITY3, datastore.get(KEY3));

    Transaction transaction = datastore.newTransaction();
    statementExecutor.execute(
        Tuple.of("T1", () -> assertEquals(ENTITY3, transaction.get(KEY3))),
        // update entity3 during the transaction, will be blocked in case of pessimistic concurrency
        Tuple.of(
            "T2",
            () ->
                datastore.put(Entity.newBuilder(ENTITY3).clear().set("from", "datastore").build())),
        Tuple.of(
            "T1",
            () ->
                transaction.update(
                    Entity.newBuilder(ENTITY3).clear().set("from", "transaction").build())),
        Tuple.of("T1", transaction::commit) // T1 will throw error in case of optimistic concurrency
        );

    boolean t1AllPassed = statementExecutor.didAllPass("T1");
    boolean t2AllPassed = statementExecutor.didAllPass("T2");
    // If two transactions conflict with each other, the database guarantees that only
    // one can commit successfully at a time. Please refer to StatementExecutor class for more info.
    // Using XOR to ensure that only one of transaction group is successful,
    boolean onlyOneTransactionIsSuccessful = t1AllPassed ^ t2AllPassed;

    assertThat(onlyOneTransactionIsSuccessful).isTrue();
  }

  @Test
  public void testTransactionWithQuery() throws Exception {
    StatementExecutor statementExecutor = new StatementExecutor();
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(KIND2)
            .setFilter(PropertyFilter.hasAncestor(KEY2))
            .setNamespace(NAMESPACE)
            .build();
    Transaction baseTransaction = datastore.newTransaction();
    QueryResults<Entity> baseResults = baseTransaction.run(query);
    assertTrue(baseResults.hasNext());
    assertEquals(ENTITY2, baseResults.next());
    assertFalse(baseResults.hasNext());
    baseTransaction.add(ENTITY3);
    baseTransaction.commit();
    assertEquals(ENTITY3, datastore.get(KEY3));

    Transaction transaction = datastore.newTransaction();
    statementExecutor.execute(
        Tuple.of(
            "T1",
            () -> {
              QueryResults<Entity> results = transaction.run(query);
              assertTrue(results.hasNext());
              assertEquals(ENTITY2, results.next());
              assertFalse(results.hasNext());
            }),
        Tuple.of("T1", () -> transaction.delete(ENTITY3.getKey())),
        // update entity2 during the transaction, will be blocked in case of pessimistic concurrency
        Tuple.of("T2", () -> datastore.put(Entity.newBuilder(ENTITY2).clear().build())),
        Tuple.of("T1", transaction::commit) // T1 will throw error in case of optimistic concurrency
        );

    boolean t1AllPassed = statementExecutor.didAllPass("T1");
    boolean t2AllPassed = statementExecutor.didAllPass("T2");
    // If two transactions conflict with each other, the database guarantees that only
    // one can commit successfully at a time. Please refer to StatementExecutor class for more info.
    // Using XOR to ensure that only one of transaction group is successful,
    boolean onlyOneTransactionIsSuccessful = t1AllPassed ^ t2AllPassed;

    assertThat(onlyOneTransactionIsSuccessful).isTrue();
  }

  @Test
  public void testTransactionExplainOptionsAnalyze() {
    StructuredQuery<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(KIND2)
            .setFilter(PropertyFilter.hasAncestor(KEY2))
            .setNamespace(NAMESPACE)
            .build();
    Transaction baseTransaction = datastore.newTransaction();
    QueryResults<Entity> baseResults =
        baseTransaction.run(query, ExplainOptions.newBuilder().setAnalyze(true).build());
    assertTrue(baseResults.hasNext());
    assertEquals(ENTITY2, baseResults.next());
    assertFalse(baseResults.hasNext());

    ExplainMetrics explainMetrics = baseResults.getExplainMetrics().get();
    assertPlanSummary(explainMetrics.getPlanSummary());
    assertExecutionStats(explainMetrics.getExecutionStats().get(), 1, 1, "1");

    baseTransaction.add(ENTITY3);
    baseTransaction.commit();
    assertEquals(ENTITY3, datastore.get(KEY3));

    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder().addAggregation(count()).over(query).build();

    Transaction aggregationTransaction = datastore.newTransaction();
    AggregationResults results =
        aggregationTransaction.runAggregation(
            aggregationQuery, ExplainOptions.newBuilder().setAnalyze(true).build());
    assertTrue(results.size() > 0);

    assertPlanSummary(results.getExplainMetrics().get().getPlanSummary());
    assertExecutionStats(results.getExplainMetrics().get().getExecutionStats().get(), 1, 1, "1");
    aggregationTransaction.commit();
  }

  @Test
  public void testTransactionExplainOptions() {
    StructuredQuery<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind(KIND2)
            .setFilter(PropertyFilter.hasAncestor(KEY2))
            .setNamespace(NAMESPACE)
            .build();
    Transaction baseTransaction = datastore.newTransaction();
    QueryResults<Entity> baseResults =
        baseTransaction.run(query, ExplainOptions.newBuilder().build());
    assertFalse(baseResults.hasNext());

    ExplainMetrics explainMetrics = baseResults.getExplainMetrics().get();
    assertPlanSummary(explainMetrics.getPlanSummary());
    Truth.assertThat(explainMetrics.getExecutionStats().isPresent()).isFalse();

    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder().addAggregation(count()).over(query).build();

    Transaction aggregationTransaction = datastore.newTransaction();
    AggregationResults results =
        aggregationTransaction.runAggregation(
            aggregationQuery, ExplainOptions.newBuilder().build());
    assertFalse(results.size() > 0);

    assertPlanSummary(results.getExplainMetrics().get().getPlanSummary());
    assertThat(results.getExplainMetrics().get().getExecutionStats().isPresent()).isFalse();
  }

  private void assertPlanSummary(PlanSummary planSummary) {
    List<Map<String, Object>> indexesUsed = planSummary.getIndexesUsed();
    indexesUsed.forEach(
        each -> Truth.assertThat(each.keySet()).containsAtLeast("properties", "query_scope"));
  }

  private void assertExecutionStats(
      ExecutionStats executionStats,
      long expectedReadOps,
      long expectedResultsReturned,
      String expectedIndexEntriesScanned) {
    Map<String, Object> debugStats = executionStats.getDebugStats();
    Truth.assertThat(debugStats.keySet())
        .containsAtLeast("billing_details", "documents_scanned", "index_entries_scanned");
    Truth.assertThat(debugStats.get("index_entries_scanned"))
        .isEqualTo(expectedIndexEntriesScanned);

    Duration executionDuration = executionStats.getExecutionDuration();
    Truth.assertThat(executionDuration).isIn(Range.greaterThan(Duration.ofMillis(0)));

    long readOperations = executionStats.getReadOperations();
    Truth.assertThat(readOperations).isEqualTo(expectedReadOps);

    long resultsReturned = executionStats.getResultsReturned();
    Truth.assertThat(resultsReturned).isEqualTo(expectedResultsReturned);
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
    } catch (DatastoreException expected) {
      assertDatastoreException(expected, "FAILED_PRECONDITION", 0);
    }

    List<Entity> list = datastore.fetch(KEY1, KEY2, KEY3);
    assertEquals(ENTITY1, list.get(0));
    assertEquals(ENTITY2, list.get(1));
    assertNull(list.get(2));
    assertEquals(3, list.size());
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
    assertEquals(PARTIAL_ENTITY3.getNames(), datastore.get(generatedKeys.get(0)).getNames());
    assertEquals(PARTIAL_ENTITY3.getKey(), IncompleteKey.newBuilder(generatedKeys.get(0)).build());

    try {
      batch.submit();
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      assertDatastoreException(expected, "FAILED_PRECONDITION", 0);
    }

    batch = datastore.newBatch();
    batch.delete(entity4.getKey(), entity5.getKey(), entity6.getKey());
    batch.update(ENTITY1, ENTITY2, ENTITY3);
    batch.submit();
    entities =
        datastore.fetch(KEY1, KEY2, KEY3, entity4.getKey(), entity5.getKey(), entity6.getKey());
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
    Query<Entity> query1 =
        Query.newGqlQueryBuilder(ResultType.ENTITY, "select * from " + KIND1)
            .setNamespace(NAMESPACE)
            .build();
    Query<Entity> scQuery1 =
        Query.newEntityQueryBuilder()
            .setNamespace(NAMESPACE)
            .setKind(KIND1)
            .setFilter(PropertyFilter.hasAncestor(ROOT_KEY))
            .build();

    Iterator<Entity> results1 = getStronglyConsistentResults(scQuery1, query1);

    assertTrue(results1.hasNext());
    assertEquals(ENTITY1, results1.next());
    assertFalse(results1.hasNext());

    datastore.put(ENTITY3);
    Query<? extends Entity> query2 =
        Query.newGqlQueryBuilder(ResultType.ENTITY, "select * from " + KIND2 + " order by __key__")
            .setNamespace(NAMESPACE)
            .build();
    Query<? extends Entity> scQuery2 =
        Query.newEntityQueryBuilder()
            .setNamespace(NAMESPACE)
            .setKind(KIND2)
            .setFilter(PropertyFilter.hasAncestor(ROOT_KEY))
            .setOrderBy(OrderBy.asc("__key__"))
            .build();

    Iterator<Entity> results2 = getStronglyConsistentResults(scQuery2, query2);
    assertTrue(results2.hasNext());
    assertEquals(ENTITY2, results2.next());
    assertTrue(results2.hasNext());
    assertEquals(ENTITY3, results2.next());
    assertFalse(results2.hasNext());

    query1 =
        Query.newGqlQueryBuilder(ResultType.ENTITY, "select * from bla")
            .setNamespace(NAMESPACE)
            .build();
    scQuery1 =
        Query.newEntityQueryBuilder()
            .setNamespace(NAMESPACE)
            .setFilter(PropertyFilter.hasAncestor(ROOT_KEY))
            .setKind("bla")
            .build();
    results1 = getStronglyConsistentResults(scQuery1, query1);
    assertFalse(results1.hasNext());

    Query<Key> keyOnlyQuery =
        Query.newGqlQueryBuilder(ResultType.KEY, "select __key__ from " + KIND1)
            .setNamespace(NAMESPACE)
            .build();
    Query<Key> scKeyOnlyQuery =
        Query.newKeyQueryBuilder()
            .setNamespace(NAMESPACE)
            .setFilter(PropertyFilter.hasAncestor(ROOT_KEY))
            .setKind(KIND1)
            .build();
    Iterator<Key> keyOnlyResults = getStronglyConsistentResults(scKeyOnlyQuery, keyOnlyQuery);
    assertTrue(keyOnlyResults.hasNext());
    assertEquals(KEY1, keyOnlyResults.next());
    assertFalse(keyOnlyResults.hasNext());

    GqlQuery<ProjectionEntity> keyProjectionQuery =
        Query.newGqlQueryBuilder(ResultType.PROJECTION_ENTITY, "select __key__ from " + KIND1)
            .setNamespace(NAMESPACE)
            .build();
    Query<ProjectionEntity> scKeyProjectionQuery =
        Query.newProjectionEntityQueryBuilder()
            .addProjection("__key__")
            .setNamespace(NAMESPACE)
            .setKind(KIND1)
            .setFilter(PropertyFilter.hasAncestor(ROOT_KEY))
            .build();

    Iterator<ProjectionEntity> keyProjectionResult =
        getStronglyConsistentResults(scKeyProjectionQuery, keyProjectionQuery);
    assertTrue(keyProjectionResult.hasNext());
    ProjectionEntity projectionEntity = keyProjectionResult.next();
    assertEquals(KEY1, projectionEntity.getKey());
    assertTrue(projectionEntity.getNames().isEmpty());
    assertFalse(keyProjectionResult.hasNext());
    datastore.delete(ENTITY3.getKey());
  }

  @Test
  public void testRunGqlQueryWithCasting() throws InterruptedException {
    @SuppressWarnings("unchecked")
    Query<Entity> query1 =
        (Query<Entity>)
            Query.newGqlQueryBuilder("select * from " + KIND1).setNamespace(NAMESPACE).build();
    Query<Entity> scQuery1 =
        Query.newEntityQueryBuilder()
            .setNamespace(NAMESPACE)
            .setKind(KIND1)
            .setFilter(PropertyFilter.hasAncestor(ROOT_KEY))
            .build();
    Iterator<Entity> results1 = getStronglyConsistentResults(scQuery1, query1);
    assertTrue(results1.hasNext());
    assertEquals(ENTITY1, results1.next());
    assertFalse(results1.hasNext());

    Query<?> query2 =
        Query.newGqlQueryBuilder("select * from " + KIND1).setNamespace(NAMESPACE).build();

    QueryResults<?> results2 = datastore.run(query2);

    assertSame(Entity.class, results2.getResultClass());

    Query<?> scQuery2 =
        Query.newEntityQueryBuilder()
            .setNamespace(NAMESPACE)
            .setKind(KIND1)
            .setFilter(PropertyFilter.hasAncestor(ROOT_KEY))
            .build();

    Iterator<Entity> results3 = getStronglyConsistentResults(scQuery2, query2);
    assertTrue(results3.hasNext());
    assertEquals(ENTITY1, results3.next());
    assertFalse(results3.hasNext());
  }

  @Test
  public void testRunAggregationQuery() {
    // verifying aggregation with an entity query
    testCountAggregationWith(
        builder ->
            builder
                .addAggregation(count().as("total_count"))
                .over(
                    Query.newEntityQueryBuilder().setNamespace(NAMESPACE).setKind(KIND1).build()));

    // verifying aggregation with a projection query
    testCountAggregationWith(
        builder ->
            builder
                .addAggregation(count().as("total_count"))
                .over(
                    Query.newProjectionEntityQueryBuilder()
                        .setProjection("str")
                        .setNamespace(NAMESPACE)
                        .setKind(KIND1)
                        .build()));

    // verifying aggregation with a key query
    testCountAggregationWith(
        builder ->
            builder
                .addAggregation(count().as("total_count"))
                .over(Query.newKeyQueryBuilder().setNamespace(NAMESPACE).setKind(KIND1).build()));

    // verifying aggregation with a GQL query
    testCountAggregationWith(
        builder ->
            builder.over(
                Query.newGqlQueryBuilder(
                        "AGGREGATE COUNT(*) AS total_count OVER (SELECT * FROM kind1)")
                    .setNamespace(NAMESPACE)
                    .build()));
  }

  @Test
  public void testRunAggregationQueryWithLimit() {
    // verifying aggregation with an entity query
    testCountAggregationWithLimit(
        builder ->
            builder
                .addAggregation(count().as("total_count"))
                .over(Query.newEntityQueryBuilder().setNamespace(NAMESPACE).setKind(KIND1).build()),
        ((builder, limit) ->
            builder
                .addAggregation(count().as("total_count"))
                .over(
                    Query.newEntityQueryBuilder()
                        .setNamespace(NAMESPACE)
                        .setKind(KIND1)
                        .setLimit(limit.intValue())
                        .build())));

    // verifying aggregation with a projection query
    testCountAggregationWithLimit(
        builder ->
            builder
                .addAggregation(count().as("total_count"))
                .over(
                    Query.newProjectionEntityQueryBuilder()
                        .setProjection("str")
                        .setNamespace(NAMESPACE)
                        .setKind(KIND1)
                        .build()),
        ((builder, limit) ->
            builder
                .addAggregation(count().as("total_count"))
                .over(
                    Query.newProjectionEntityQueryBuilder()
                        .setProjection("str")
                        .setNamespace(NAMESPACE)
                        .setKind(KIND1)
                        .setLimit(limit.intValue())
                        .build())));

    // verifying aggregation with a key query
    testCountAggregationWithLimit(
        builder ->
            builder
                .addAggregation(count().as("total_count"))
                .over(Query.newKeyQueryBuilder().setNamespace(NAMESPACE).setKind(KIND1).build()),
        (builder, limit) ->
            builder
                .addAggregation(count().as("total_count"))
                .over(
                    Query.newKeyQueryBuilder()
                        .setNamespace(NAMESPACE)
                        .setKind(KIND1)
                        .setLimit(limit.intValue())
                        .build()));

    // verifying aggregation with a GQL query
    testCountAggregationWithLimit(
        builder ->
            builder.over(
                Query.newGqlQueryBuilder(
                        "AGGREGATE COUNT(*) AS total_count OVER (SELECT * FROM kind1)")
                    .setNamespace(NAMESPACE)
                    .build()),
        (builder, limit) ->
            builder.over(
                Query.newGqlQueryBuilder(
                        "AGGREGATE COUNT(*) AS total_count OVER (SELECT * FROM kind1 LIMIT @limit)")
                    .setNamespace(NAMESPACE)
                    .setBinding("limit", limit)
                    .build()));
  }

  @Test
  public void testSumAggregation() {
    datastore.put(AGGREGATION_ENTITY_1, AGGREGATION_ENTITY_2);

    EntityQuery baseQuery = Query.newEntityQueryBuilder().setKind(MARKS_KIND).build();
    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .over(baseQuery)
            .addAggregations(sum("marks").as("total_marks"))
            .setNamespace(NAMESPACE)
            .build();

    // sum of 2 entities
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("total_marks"))
        .isEqualTo(184L);

    // sum of 3 entities
    datastore.put(AGGREGATION_ENTITY_3);
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("total_marks"))
        .isEqualTo(239L);
  }

  @Test
  public void testSumAggregationWithAutoGeneratedAlias() {
    datastore.put(AGGREGATION_ENTITY_1, AGGREGATION_ENTITY_2);

    EntityQuery baseQuery = Query.newEntityQueryBuilder().setKind(MARKS_KIND).build();
    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .over(baseQuery)
            .addAggregations(sum("marks"))
            .setNamespace(NAMESPACE)
            .build();

    // sum of 2 entities
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("property_1"))
        .isEqualTo(184L);

    // sum of 3 entities
    datastore.put(AGGREGATION_ENTITY_3);
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("property_1"))
        .isEqualTo(239L);
  }

  @Test
  public void testSumAggregationInGqlQuery() {
    datastore.put(AGGREGATION_ENTITY_1, AGGREGATION_ENTITY_2);

    GqlQuery<?> gqlQuery =
        GqlQuery.newGqlQueryBuilder(
                "AGGREGATE SUM(marks) AS total_marks OVER (SELECT * FROM Marks)")
            .build();

    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder().over(gqlQuery).setNamespace(NAMESPACE).build();

    // sum of 2 entities
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("total_marks"))
        .isEqualTo(184L);

    // sum of 3 entities
    datastore.put(AGGREGATION_ENTITY_3);
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("total_marks"))
        .isEqualTo(239L);
  }

  @Test
  public void testSumAggregationWithResultOfDoubleType() {
    datastore.put(AGGREGATION_ENTITY_1, AGGREGATION_ENTITY_2);

    EntityQuery baseQuery = Query.newEntityQueryBuilder().setKind(MARKS_KIND).build();
    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .over(baseQuery)
            .addAggregations(sum("cgpa").as("total_cgpa"))
            .setNamespace(NAMESPACE)
            .build();

    // sum of 2 entities
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getDouble("total_cgpa"))
        .isEqualTo(16.61);

    // sum of 3 entities
    datastore.put(AGGREGATION_ENTITY_3);
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getDouble("total_cgpa"))
        .isEqualTo(21.77);
  }

  @Test
  public void testAvgAggregation() {
    datastore.put(AGGREGATION_ENTITY_1, AGGREGATION_ENTITY_2);

    EntityQuery baseQuery = Query.newEntityQueryBuilder().setKind(MARKS_KIND).build();
    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .over(baseQuery)
            .addAggregations(avg("marks").as("avg_marks"))
            .setNamespace(NAMESPACE)
            .build();

    // avg of 2 entities
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getDouble("avg_marks"))
        .isEqualTo(92D);

    // avg of 3 entities
    datastore.put(AGGREGATION_ENTITY_3);
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getDouble("avg_marks"))
        .isEqualTo(79.66666666666667);
  }

  @Test
  public void testAvgAggregationWithAutoGeneratedAlias() {
    datastore.put(AGGREGATION_ENTITY_1, AGGREGATION_ENTITY_2);

    EntityQuery baseQuery = Query.newEntityQueryBuilder().setKind(MARKS_KIND).build();
    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .over(baseQuery)
            .addAggregations(avg("marks"))
            .setNamespace(NAMESPACE)
            .build();

    // avg of 2 entities
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getDouble("property_1"))
        .isEqualTo(92D);

    // avg of 3 entities
    datastore.put(AGGREGATION_ENTITY_3);
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getDouble("property_1"))
        .isEqualTo(79.66666666666667);
  }

  @Test
  public void testAvgAggregationInGqlQuery() {
    datastore.put(AGGREGATION_ENTITY_1, AGGREGATION_ENTITY_2);

    GqlQuery<?> gqlQuery =
        Query.newGqlQueryBuilder("AGGREGATE AVG(marks) AS avg_marks OVER (SELECT * FROM Marks)")
            .build();

    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder().over(gqlQuery).setNamespace(NAMESPACE).build();

    // avg of 2 entities
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getDouble("avg_marks"))
        .isEqualTo(92D);

    // avg of 3 entities
    datastore.put(AGGREGATION_ENTITY_3);
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getDouble("avg_marks"))
        .isEqualTo(79.66666666666667);
  }

  @Test
  public void testSumAndAvgAggregationTogether() {
    datastore.put(AGGREGATION_ENTITY_1, AGGREGATION_ENTITY_2);

    EntityQuery baseQuery = Query.newEntityQueryBuilder().setKind(MARKS_KIND).build();
    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .over(baseQuery)
            .addAggregations(sum("marks").as("total_marks"))
            .addAggregations(avg("marks").as("avg_marks"))
            .setNamespace(NAMESPACE)
            .build();

    // sum of 2 entities
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("total_marks"))
        .isEqualTo(184L);
    // avg of 2 entities
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getDouble("avg_marks"))
        .isEqualTo(92D);
  }

  @Test
  public void testTransactionShouldReturnAConsistentSnapshot() {
    datastore.put(AGGREGATION_ENTITY_1, AGGREGATION_ENTITY_2);

    EntityQuery baseQuery = Query.newEntityQueryBuilder().setKind(MARKS_KIND).build();
    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .over(baseQuery)
            .addAggregation(count().as("count"))
            .addAggregations(sum("marks").as("total_marks"))
            .addAggregations(avg("marks").as("avg_marks"))
            .setNamespace(NAMESPACE)
            .build();

    // original entity count is 2
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("count"))
        .isEqualTo(2L);

    // FIRST TRANSACTION
    datastore.runInTransaction(
        (TransactionCallable<Void>)
            inFirstTransaction -> {
              // creating a new entity
              inFirstTransaction.put(AGGREGATION_ENTITY_3);

              // aggregation result consistently being produced for original 2 entities
              AggregationResult aggregationResult =
                  getOnlyElement(inFirstTransaction.runAggregation(aggregationQuery));
              assertThat(aggregationResult.getLong("count")).isEqualTo(2L);
              assertThat(aggregationResult.getLong("total_marks")).isEqualTo(184L);
              assertThat(aggregationResult.getDouble("avg_marks")).isEqualTo(92D);
              return null;
            });

    // after first transaction is committed, we have 3 entities now.
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("count"))
        .isEqualTo(3L);

    // SECOND TRANSACTION
    datastore.runInTransaction(
        (TransactionCallable<Void>)
            inSecondTransaction -> {
              // deleting ENTITY3
              inSecondTransaction.delete(AGGREGATION_ENTITY_3.getKey());

              // aggregation result still coming for 3 entities
              AggregationResult aggregationResult =
                  getOnlyElement(inSecondTransaction.runAggregation(aggregationQuery));
              assertThat(aggregationResult.getLong("count")).isEqualTo(3L);
              assertThat(aggregationResult.getLong("total_marks")).isEqualTo(239L);
              assertThat(aggregationResult.getDouble("avg_marks")).isEqualTo(79.66666666666667);
              return null;
            });

    // after second transaction is committed, we are back to 2 entities now.
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("count"))
        .isEqualTo(2L);
  }

  @Test
  public void testReadOnlyTransactionShouldNotLockTheDocuments()
      throws ExecutionException, InterruptedException {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    datastore.put(AGGREGATION_ENTITY_1, AGGREGATION_ENTITY_2);

    EntityQuery baseQuery = Query.newEntityQueryBuilder().setKind(MARKS_KIND).build();
    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .over(baseQuery)
            .addAggregation(count().as("count"))
            .addAggregations(sum("marks").as("total_marks"))
            .addAggregations(avg("marks").as("avg_marks"))
            .setNamespace(NAMESPACE)
            .build();

    TransactionOptions transactionOptions =
        TransactionOptions.newBuilder().setReadOnly(ReadOnly.newBuilder().build()).build();
    Transaction readOnlyTransaction = datastore.newTransaction(transactionOptions);

    // Executing query in transaction, results for original 2 entities
    AggregationResult aggregationResult =
        getOnlyElement(readOnlyTransaction.runAggregation(aggregationQuery));
    assertThat(aggregationResult.getLong("count")).isEqualTo(2L);
    assertThat(aggregationResult.getLong("total_marks")).isEqualTo(184L);
    assertThat(aggregationResult.getDouble("avg_marks")).isEqualTo(92D);

    // Concurrent write task.
    Future<Void> addNewEntityTaskOutsideTransaction =
        executor.submit(
            () -> {
              datastore.put(AGGREGATION_ENTITY_3);
              return null;
            });

    // should not throw exception and complete successfully as the ongoing transaction is read-only.
    addNewEntityTaskOutsideTransaction.get();

    // cleanup
    readOnlyTransaction.commit();
    executor.shutdownNow();

    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("count"))
        .isEqualTo(3L);
  }

  private void testCountAggregationWith(Consumer<AggregationQuery.Builder> configurer) {
    AggregationQuery.Builder builder = Query.newAggregationQueryBuilder().setNamespace(NAMESPACE);
    configurer.accept(builder);
    AggregationQuery aggregationQuery = builder.build();
    String alias = "total_count";

    Long countBeforeAdd = getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong(alias);
    long expectedCount = countBeforeAdd + 1;

    Entity newEntity =
        Entity.newBuilder(ENTITY1)
            .setKey(Key.newBuilder(KEY3, KIND1, 1).build())
            .set("null", NULL_VALUE)
            .set("partial1", PARTIAL_ENTITY2)
            .set("partial2", ENTITY2)
            .build();
    datastore.put(newEntity);

    Long countAfterAdd = getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong(alias);
    assertThat(countAfterAdd).isEqualTo(expectedCount);

    datastore.delete(newEntity.getKey());
  }

  private void testCountAggregationWithLimit(
      Consumer<AggregationQuery.Builder> withoutLimitConfigurer,
      BiConsumer<AggregationQuery.Builder, Long> withLimitConfigurer) {
    String alias = "total_count";

    AggregationQuery.Builder withoutLimitBuilder =
        Query.newAggregationQueryBuilder().setNamespace(NAMESPACE);
    withoutLimitConfigurer.accept(withoutLimitBuilder);

    Long currentCount =
        getOnlyElement(datastore.runAggregation(withoutLimitBuilder.build())).getLong(alias);
    long limit = currentCount - 1;

    AggregationQuery.Builder withLimitBuilder =
        Query.newAggregationQueryBuilder().setNamespace(NAMESPACE);
    withLimitConfigurer.accept(withLimitBuilder, limit);

    Long countWithLimit =
        getOnlyElement(datastore.runAggregation(withLimitBuilder.build())).getLong(alias);
    assertThat(countWithLimit).isEqualTo(limit);
  }

  private void testCountAggregationReadTimeWith(Consumer<AggregationQuery.Builder> configurer)
      throws InterruptedException {
    Entity entity1 =
        Entity.newBuilder(
                Key.newBuilder(PROJECT_ID, "new_kind", "name-01")
                    .setDatabaseId(options.getDatabaseId())
                    .setNamespace(NAMESPACE)
                    .build())
            .set("name", "name01")
            .build();
    Entity entity2 =
        Entity.newBuilder(
                Key.newBuilder(PROJECT_ID, "new_kind", "name-02")
                    .setDatabaseId(options.getDatabaseId())
                    .setNamespace(NAMESPACE)
                    .build())
            .set("name", "name02")
            .build();
    Entity entity3 =
        Entity.newBuilder(
                Key.newBuilder(PROJECT_ID, "new_kind", "name-03")
                    .setDatabaseId(options.getDatabaseId())
                    .setNamespace(NAMESPACE)
                    .build())
            .set("name", "name03")
            .build();

    datastore.put(entity1, entity2);
    Thread.sleep(1000);
    Timestamp now = Timestamp.now();
    Thread.sleep(1000);
    datastore.put(entity3);

    try {
      AggregationQuery.Builder builder = Query.newAggregationQueryBuilder().setNamespace(NAMESPACE);
      configurer.accept(builder);
      AggregationQuery countAggregationQuery = builder.build();

      Long latestCount =
          getOnlyElement(datastore.runAggregation(countAggregationQuery)).getLong("total_count");
      assertThat(latestCount).isEqualTo(3L);

      ExplainOptions explainOptions = ExplainOptions.newBuilder().setAnalyze(true).build();
      AggregationResults results =
          datastore.runAggregation(countAggregationQuery, explainOptions, ReadOption.readTime(now));
      Long oldCount = getOnlyElement(results).getLong("total_count");
      assertThat(oldCount).isEqualTo(2L);
      assertPlanSummary(results.getExplainMetrics().get().getPlanSummary());
      assertExecutionStats(results.getExplainMetrics().get().getExecutionStats().get(), 1, 1, "2");
    } finally {
      datastore.delete(entity1.getKey(), entity2.getKey(), entity3.getKey());
    }
  }

  /**
   * if an entity is modified or deleted within a transaction, a query or lookup returns the
   * original version of the entity as of the beginning of the transaction, or nothing if the entity
   * did not exist then.
   *
   * @see <a
   *     href="https://cloud.google.com/datastore/docs/concepts/transactions#isolation_and_consistency">
   *     Source</a>
   */
  @Test
  public void testRunAggregationQueryInTransactionShouldReturnAConsistentSnapshot() {
    Key newEntityKey = Key.newBuilder(KEY1, "newKind", "name-01").build();
    EntityQuery entityQuery =
        Query.newEntityQueryBuilder()
            .setNamespace(NAMESPACE)
            .setFilter(PropertyFilter.hasAncestor(KEY1))
            .build();

    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .setNamespace(NAMESPACE)
            .over(entityQuery)
            .addAggregation(count().as("count"))
            .build();

    // original entity count is 2
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("count"))
        .isEqualTo(2L);

    // FIRST TRANSACTION
    datastore.runInTransaction(
        (TransactionCallable<Void>)
            inFirstTransaction -> {
              // creating a new entity
              Entity aNewEntity =
                  Entity.newBuilder(ENTITY2).setKey(newEntityKey).set("v_int", 10).build();
              inFirstTransaction.put(aNewEntity);

              // count remains 2
              assertThat(
                      getOnlyElement(inFirstTransaction.runAggregation(aggregationQuery))
                          .getLong("count"))
                  .isEqualTo(2L);
              assertThat(
                      getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("count"))
                  .isEqualTo(2L);
              return null;
            });
    // after first transaction is committed, count is updated to 3 now.
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("count"))
        .isEqualTo(3L);

    // SECOND TRANSACTION
    datastore.runInTransaction(
        (TransactionCallable<Void>)
            inSecondTransaction -> {
              // deleting ENTITY2
              inSecondTransaction.delete(ENTITY2.getKey());

              // count remains 3
              assertThat(
                      getOnlyElement(inSecondTransaction.runAggregation(aggregationQuery))
                          .getLong("count"))
                  .isEqualTo(3L);
              assertThat(
                      getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("count"))
                  .isEqualTo(3L);
              return null;
            });
    // after second transaction is committed, count is updated to 2 now.
    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("count"))
        .isEqualTo(2L);
    datastore.delete(newEntityKey);
  }

  @Test
  public void testRunAggregationQueryInAReadOnlyTransactionShouldNotLockTheCountedDocuments()
      throws Exception {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    EntityQuery entityQuery =
        Query.newEntityQueryBuilder()
            .setNamespace(NAMESPACE)
            .setFilter(PropertyFilter.hasAncestor(KEY1))
            .build();
    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .setNamespace(NAMESPACE)
            .over(entityQuery)
            .addAggregation(count().as("count"))
            .build();

    TransactionOptions transactionOptions =
        TransactionOptions.newBuilder().setReadOnly(ReadOnly.newBuilder().build()).build();
    Transaction readOnlyTransaction = datastore.newTransaction(transactionOptions);

    // Executing query in transaction
    assertThat(
            getOnlyElement(readOnlyTransaction.runAggregation(aggregationQuery)).getLong("count"))
        .isEqualTo(2L);

    // Concurrent write task.
    Future<Void> addNewEntityTaskOutsideTransaction =
        executor.submit(
            () -> {
              Entity aNewEntity =
                  Entity.newBuilder(ENTITY2)
                      .setKey(Key.newBuilder(KEY1, "newKind", "name-01").build())
                      .set("v_int", 10)
                      .build();
              datastore.put(aNewEntity);
              return null;
            });

    // should not throw exception and complete successfully as the ongoing transaction is read-only.
    addNewEntityTaskOutsideTransaction.get();

    // cleanup
    readOnlyTransaction.commit();
    executor.shutdownNow();

    assertThat(getOnlyElement(datastore.runAggregation(aggregationQuery)).getLong("count"))
        .isEqualTo(3L);
  }

  @Test
  public void testRunAggregationQueryWithReadTime() throws InterruptedException {
    String alias = "total_count";

    // verifying aggregation readTime with an entity query
    testCountAggregationReadTimeWith(
        builder ->
            builder
                .over(Query.newEntityQueryBuilder().setKind("new_kind").build())
                .addAggregation(count().as(alias)));

    // verifying aggregation readTime with a projection query
    testCountAggregationReadTimeWith(
        builder ->
            builder
                .over(
                    Query.newProjectionEntityQueryBuilder()
                        .setProjection("name")
                        .setKind("new_kind")
                        .build())
                .addAggregation(count().as(alias)));

    // verifying aggregation readTime with a key query
    testCountAggregationReadTimeWith(
        builder ->
            builder
                .over(Query.newKeyQueryBuilder().setKind("new_kind").build())
                .addAggregation(count().as(alias)));

    // verifying aggregation readTime with a GQL query
    testCountAggregationReadTimeWith(
        builder ->
            builder
                .over(
                    Query.newGqlQueryBuilder(
                            "AGGREGATE COUNT(*) AS total_count OVER (SELECT * FROM new_kind)")
                        .build())
                .addAggregation(count().as(alias)));
  }

  @Test
  public void testRunStructuredQuery() throws InterruptedException {
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind(KIND1).setOrderBy(OrderBy.asc("__key__")).build();

    Query<Entity> scQuery =
        Query.newEntityQueryBuilder()
            .setKind(KIND1)
            .setFilter(PropertyFilter.hasAncestor(ROOT_KEY))
            .setOrderBy(OrderBy.asc("__key__"))
            .build();

    Iterator<Entity> results1 = getStronglyConsistentResults(scQuery, query);

    assertTrue(results1.hasNext());
    assertEquals(ENTITY1, results1.next());
    assertFalse(results1.hasNext());

    Query<Key> keyOnlyQuery = Query.newKeyQueryBuilder().setKind(KIND1).build();
    Query<Key> scKeyOnlyQuery =
        Query.newKeyQueryBuilder()
            .setKind(KIND1)
            .setFilter(PropertyFilter.hasAncestor(ROOT_KEY))
            .build();

    Iterator<Key> results2 = getStronglyConsistentResults(scKeyOnlyQuery, keyOnlyQuery);
    assertTrue(results2.hasNext());
    assertEquals(ENTITY1.getKey(), results2.next());
    assertFalse(results2.hasNext());

    StructuredQuery<ProjectionEntity> keyOnlyProjectionQuery =
        Query.newProjectionEntityQueryBuilder().setKind(KIND1).setProjection("__key__").build();
    StructuredQuery<ProjectionEntity> scKeyOnlyProjectionQuery =
        Query.newProjectionEntityQueryBuilder()
            .setKind(KIND1)
            .setFilter(PropertyFilter.hasAncestor(ROOT_KEY))
            .setProjection("__key__")
            .build();
    Iterator<ProjectionEntity> results3 =
        getStronglyConsistentResults(scKeyOnlyProjectionQuery, keyOnlyProjectionQuery);
    assertTrue(results3.hasNext());
    ProjectionEntity projectionEntity = results3.next();
    assertEquals(ENTITY1.getKey(), projectionEntity.getKey());
    assertTrue(projectionEntity.getNames().isEmpty());
    assertFalse(results3.hasNext());

    StructuredQuery<ProjectionEntity> projectionQuery =
        Query.newProjectionEntityQueryBuilder()
            .setKind(KIND2)
            .setProjection("age")
            .setFilter(PropertyFilter.gt("age", 18))
            .setDistinctOn("age")
            .setOrderBy(OrderBy.asc("age"))
            .setLimit(10)
            .build();

    StructuredQuery<ProjectionEntity> scProjectionQuery =
        Query.newProjectionEntityQueryBuilder()
            .setKind(KIND2)
            .setFilter(PropertyFilter.hasAncestor(ROOT_KEY))
            .setProjection("age")
            .setFilter(PropertyFilter.gt("age", 18))
            .setDistinctOn("age")
            .setOrderBy(OrderBy.asc("age"))
            .setLimit(10)
            .build();

    Iterator<ProjectionEntity> results4 =
        getStronglyConsistentResults(scProjectionQuery, projectionQuery);
    assertTrue(results4.hasNext());
    ProjectionEntity entity = results4.next();
    assertEquals(ENTITY2.getKey(), entity.getKey());
    assertEquals(20, entity.getLong("age"));
    assertEquals(1, entity.getNames().size());
    assertFalse(results4.hasNext());
  }

  @Test
  public void testInNotInNeqFilters() throws InterruptedException {
    Entity e1 =
        Entity.newBuilder(ENTITY1)
            .setKey(Key.newBuilder(INCOMPLETE_KEY1, "e1").build())
            .set("v_int", 10)
            .build();
    Entity e2 =
        Entity.newBuilder(ENTITY1)
            .setKey(Key.newBuilder(INCOMPLETE_KEY1, "e2").build())
            .set("v_int", 20)
            .build();
    datastore.put(e1, e2);

    Query<Entity> queryIn =
        Query.newEntityQueryBuilder()
            .setKind(KIND1)
            .setFilter(PropertyFilter.in("v_int", ListValue.of(10, 20)))
            .build();

    Query<Entity> scQueryIn =
        Query.newEntityQueryBuilder()
            .setKind(KIND1)
            .setFilter(PropertyFilter.hasAncestor(ROOT_KEY))
            .setFilter(PropertyFilter.in("v_int", ListValue.of(10, 20)))
            .build();

    Iterator<Entity> resultIn = getStronglyConsistentResults(scQueryIn, queryIn);

    assertTrue(resultIn.hasNext());
    assertEquals(e1, resultIn.next());
    assertTrue(resultIn.hasNext());
    assertEquals(e2, resultIn.next());
    assertFalse(resultIn.hasNext());

    Query<Entity> queryNotIn =
        Query.newEntityQueryBuilder()
            .setKind(KIND1)
            .setFilter(PropertyFilter.not_in("v_int", ListValue.of(20, 30)))
            .build();

    Query<Entity> scQueryNotIn =
        Query.newEntityQueryBuilder()
            .setKind(KIND1)
            .setFilter(PropertyFilter.hasAncestor(ROOT_KEY))
            .setFilter(PropertyFilter.not_in("v_int", ListValue.of(20, 30)))
            .build();

    Iterator<Entity> resultNotIn = getStronglyConsistentResults(scQueryNotIn, queryNotIn);

    assertTrue(resultNotIn.hasNext());
    assertEquals(e1, resultNotIn.next());
    assertFalse(resultNotIn.hasNext());

    Query<Entity> queryNeq =
        Query.newEntityQueryBuilder()
            .setKind(KIND1)
            .setFilter(PropertyFilter.neq("v_int", 10))
            .build();

    Query<Entity> scQueryNeq =
        Query.newEntityQueryBuilder()
            .setKind(KIND1)
            .setFilter(PropertyFilter.hasAncestor(ROOT_KEY))
            .setFilter(PropertyFilter.neq("v_int", 10))
            .build();

    Iterator<Entity> resultNeq = getStronglyConsistentResults(scQueryNeq, queryNeq);

    assertTrue(resultNeq.hasNext());
    assertEquals(e2, resultNeq.next());
    assertFalse(resultNeq.hasNext());

    Query<Entity> scQueryInEqOr =
        Query.newEntityQueryBuilder()
            .setKind(KIND1)
            .setFilter(
                CompositeFilter.or(
                    PropertyFilter.in("v_int", ListValue.of(10, 50000)),
                    PropertyFilter.eq("v_int", 10000)))
            .build();

    QueryResults<Entity> run = datastore.run(scQueryInEqOr);

    assertTrue(run.hasNext());
    assertEquals(e1, run.next());
    assertFalse(run.hasNext());

    datastore.delete(e1.getKey());
    datastore.delete(e2.getKey());
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
  }

  @Test
  public void testReserveIds() {
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
    Key key1 = keyFactory.newKey(10);
    Key key2 = keyFactory.newKey("name");
    List<Key> keyList = datastore.reserveIds(key1, key2);
    assertEquals(2, keyList.size());
  }

  @Test
  public void testAllocateIdArray() {
    KeyFactory keyFactory = datastore.newKeyFactory().setKind(KIND1);
    IncompleteKey incompleteKey1 = keyFactory.newKey();
    IncompleteKey incompleteKey2 =
        keyFactory
            .setKind(KIND2)
            .setDatabaseId(options.getDatabaseId())
            .addAncestors(PathElement.of(KIND1, 10))
            .newKey();
    List<Key> result = datastore.allocateId(incompleteKey1, incompleteKey2, incompleteKey1);
    assertEquals(3, result.size());
    assertEquals(Key.newBuilder(incompleteKey1, result.get(0).getId()).build(), result.get(0));
    assertEquals(Key.newBuilder(incompleteKey1, result.get(2).getId()).build(), result.get(2));
    assertEquals(Key.newBuilder(incompleteKey2, result.get(1).getId()).build(), result.get(1));
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
  public void testGetWithReadTime() throws InterruptedException {
    Key key =
        Key.newBuilder(PROJECT_ID, "new_kind", "name", options.getDatabaseId())
            .setNamespace(NAMESPACE)
            .build();

    try {
      datastore.put(Entity.newBuilder(key).set("str", "old_str_value").build());

      Thread.sleep(1000);
      Timestamp now = Timestamp.now();
      Thread.sleep(1000);

      datastore.put(Entity.newBuilder(key).set("str", "new_str_value").build());

      Entity entity = datastore.get(key);
      StringValue value1 = entity.getValue("str");
      assertEquals(StringValue.of("new_str_value"), value1);

      entity = datastore.get(key, ReadOption.readTime(now));
      value1 = entity.getValue("str");
      assertEquals(StringValue.of("old_str_value"), value1);
    } finally {
      datastore.delete(key);
    }
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
      assertDatastoreException(expected, "FAILED_PRECONDITION", 0);
    }
    assertFalse(result.hasNext());
    datastore.delete(ENTITY3.getKey());
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
      assertDatastoreException(expected, "ALREADY_EXISTS", 6);
    }

    List<Entity> entities = datastore.add(ENTITY3, PARTIAL_ENTITY1, PARTIAL_ENTITY2);
    assertEquals(ENTITY3, datastore.get(ENTITY3.getKey()));
    assertEquals(ENTITY3, entities.get(0));
    assertEquals(PARTIAL_ENTITY1.getNames(), entities.get(1).getNames());
    assertEquals(PARTIAL_ENTITY1.getKey().getAncestors(), entities.get(1).getKey().getAncestors());
    assertNotNull(datastore.get(entities.get(1).getKey()));
    assertEquals(PARTIAL_ENTITY2.getNames(), entities.get(2).getNames());
    assertEquals(PARTIAL_ENTITY2.getKey().getAncestors(), entities.get(2).getKey().getAncestors());
    assertNotNull(datastore.get(entities.get(2).getKey()));
    for (Entity entity : entities) {
      datastore.delete(entity.getKey());
    }
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
      assertDatastoreException(expected, "NOT_FOUND", 5);
    }
    datastore.add(ENTITY3);
    assertEquals(ENTITY3, datastore.get(ENTITY3.getKey()));
    Entity entity3 = Entity.newBuilder(ENTITY3).clear().set("bla", new NullValue()).build();
    assertNotEquals(ENTITY3, entity3);
    datastore.update(entity3);
    assertEquals(entity3, datastore.get(ENTITY3.getKey()));
    datastore.delete(ENTITY3.getKey());
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
    assertEquals(PARTIAL_ENTITY1.getNames(), entities.get(3).getNames());
    assertEquals(PARTIAL_ENTITY1.getKey().getAncestors(), entities.get(3).getKey().getAncestors());
    assertEquals(ENTITY1, datastore.get(ENTITY1.getKey()));
    assertEquals(entity2, datastore.get(entity2.getKey()));
    assertEquals(ENTITY3, datastore.get(ENTITY3.getKey()));
    Entity entity = datastore.get(entities.get(3).getKey());
    assertEquals(entities.get(3), entity);
    for (Entity entityToDelete : entities) {
      datastore.delete(entityToDelete.getKey());
    }
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
  public void testRunInTransaction() {
    Datastore.TransactionCallable<Integer> callable1 =
        new Datastore.TransactionCallable<Integer>() {
          private Integer attempts = 1;

          @Override
          public Integer run(DatastoreReaderWriter transaction) {
            transaction.get(KEY1);
            if (attempts < 2) {
              ++attempts;
              throw new DatastoreException(10, "", "ABORTED", false, null);
            }

            return attempts;
          }
        };

    int result = datastore.runInTransaction(callable1);
    assertEquals(result, 2);

    Datastore.TransactionCallable<Integer> callable2 =
        new Datastore.TransactionCallable<Integer>() {
          private Integer attempts = 1;

          @Override
          public Integer run(DatastoreReaderWriter transaction) {
            transaction.get(KEY1);
            if (attempts < 2) {
              ++attempts;
              throw new DatastoreException(4, "", "DEADLINE_EXCEEDED", false, null);
            }
            return attempts;
          }
        };

    try {
      datastore.runInTransaction(callable2);
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      assertDatastoreException((DatastoreException) expected.getCause(), "DEADLINE_EXCEEDED", 4);
    }
  }

  @Test
  public void testRunInTransactionReadWrite() {

    final Entity entity1 = Entity.newBuilder(ENTITY1).clear().setNull("bla").build();

    Datastore.TransactionCallable<Integer> callable1 =
        new Datastore.TransactionCallable<Integer>() {
          private Integer attempts = 1;

          @Override
          public Integer run(DatastoreReaderWriter transaction) {
            transaction.update(entity1);
            if (attempts < 2) {
              ++attempts;
              throw new DatastoreException(10, "", "ABORTED", false, null);
            }

            return attempts;
          }
        };

    int result = datastore.runInTransaction(callable1);
    assertEquals(result, 2);

    final Entity entity2 = Entity.newBuilder(ENTITY2).clear().setNull("bla").build();
    Datastore.TransactionCallable<Integer> callable2 =
        new Datastore.TransactionCallable<Integer>() {
          private Integer attempts = 1;

          @Override
          public Integer run(DatastoreReaderWriter transaction) {
            transaction.update(entity2);
            if (attempts < 2) {
              ++attempts;
              throw new DatastoreException(10, "", "ABORTED", false, null);
            }

            return attempts;
          }
        };

    TransactionOptions readOnlyOptions =
        TransactionOptions.newBuilder()
            .setReadOnly(TransactionOptions.ReadOnly.getDefaultInstance())
            .build();

    try {
      datastore.runInTransaction(callable2, readOnlyOptions);
      fail("Expecting a failure");
    } catch (DatastoreException expected) {
      assertDatastoreException((DatastoreException) expected.getCause(), "INVALID_ARGUMENT", 3);
    }
  }

  @Test
  public void testSkippedResults() {
    Query<Key> query = Query.newKeyQueryBuilder().setOffset(Integer.MAX_VALUE).build();
    int numberOfEntities = datastore.run(query).getSkippedResults();
    assertEquals(2, numberOfEntities);
  }

  @Test
  public void testSetLimit() {
    datastore.put(ENTITY1);
    Query<Key> keyQuery = Query.newKeyQueryBuilder().setLimit(1).build();
    QueryResults<?> queryResults = datastore.run(keyQuery);
    assertTrue(queryResults.hasNext());
    assertEquals(KEY1, queryResults.next());

    Query<?> query = Query.newEntityQueryBuilder().setLimit(0).build();
    QueryResults<?> results = datastore.run(query);
    assertFalse(results.hasNext());
  }

  @Test
  public void testGqlQueryWithNullBinding() {
    Query<Entity> query =
        Query.newGqlQueryBuilder(ResultType.ENTITY, "select * from " + KIND1)
            .setNamespace(NAMESPACE)
            .setNullBinding("name")
            .build();
    Iterator<Entity> results = datastore.run(query);
    assertTrue(results.hasNext());
    assertEquals(ENTITY1, results.next());
    assertFalse(results.hasNext());
  }

  @Test
  public void testQueryWithStartCursor() {
    Entity entity1 =
        Entity.newBuilder(
                Key.newBuilder(PROJECT_ID, KIND1, "name-01", options.getDatabaseId()).build())
            .build();
    Entity entity2 =
        Entity.newBuilder(
                Key.newBuilder(PROJECT_ID, KIND1, "name-02", options.getDatabaseId()).build())
            .build();
    Entity entity3 =
        Entity.newBuilder(
                Key.newBuilder(PROJECT_ID, KIND1, "name-03", options.getDatabaseId()).build())
            .build();
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

  @Test
  public void testQueryWithReadTime() throws InterruptedException {
    Entity entity1 =
        Entity.newBuilder(
                Key.newBuilder(PROJECT_ID, "new_kind", "name-01")
                    .setDatabaseId(options.getDatabaseId())
                    .setNamespace(NAMESPACE)
                    .build())
            .build();
    Entity entity2 =
        Entity.newBuilder(
                Key.newBuilder(PROJECT_ID, "new_kind", "name-02")
                    .setDatabaseId(options.getDatabaseId())
                    .setNamespace(NAMESPACE)
                    .build())
            .build();
    Entity entity3 =
        Entity.newBuilder(
                Key.newBuilder(PROJECT_ID, "new_kind", "name-03")
                    .setDatabaseId(options.getDatabaseId())
                    .setNamespace(NAMESPACE)
                    .build())
            .build();

    datastore.put(entity1, entity2);
    Thread.sleep(1000);
    Timestamp now = Timestamp.now();
    Thread.sleep(1000);
    datastore.put(entity3);

    try {
      Query<Entity> query = Query.newEntityQueryBuilder().setKind("new_kind").build();

      QueryResults<Entity> withoutReadTime = datastore.run(query);
      assertTrue(withoutReadTime.hasNext());
      assertEquals(entity1, withoutReadTime.next());
      assertTrue(withoutReadTime.hasNext());
      assertEquals(entity2, withoutReadTime.next());
      assertTrue(withoutReadTime.hasNext());
      assertEquals(entity3, withoutReadTime.next());
      assertFalse(withoutReadTime.hasNext());

      QueryResults<Entity> withReadTime = datastore.run(query, ReadOption.readTime(now));
      assertTrue(withReadTime.hasNext());
      assertEquals(entity1, withReadTime.next());
      assertTrue(withReadTime.hasNext());
      assertEquals(entity2, withReadTime.next());
      assertFalse(withReadTime.hasNext());
    } finally {
      datastore.delete(entity1.getKey(), entity2.getKey(), entity3.getKey());
    }
  }

  private void assertDatastoreException(
      DatastoreException expected, String reason, int statusCode) {
    assertEquals(reason, expected.getReason());
    assertEquals(statusCode, expected.getCode());
  }
}
