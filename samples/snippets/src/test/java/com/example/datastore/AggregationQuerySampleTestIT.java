/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.datastore;

import static org.junit.Assert.assertThrows;

import com.example.datastore.aggregation.CountAggregationInTransaction;
import com.example.datastore.aggregation.CountAggregationOnKind;
import com.example.datastore.aggregation.CountAggregationWithGqlQuery;
import com.example.datastore.aggregation.CountAggregationWithLimit;
import com.example.datastore.aggregation.CountAggregationWithOrderBy;
import com.example.datastore.aggregation.CountAggregationWithPropertyFilter;
import com.example.datastore.aggregation.CountAggregationWithStaleRead;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyQuery;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.common.collect.ImmutableList;
import com.rule.SystemsOutRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class AggregationQuerySampleTestIT {

  private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

  @Rule public final SystemsOutRule systemsOutRule = new SystemsOutRule();

  @Before
  public void setUp() throws Exception {
    // Retrieving and deleting all the 'Task' entities.
    KeyQuery allKeysQuery = Query.newKeyQueryBuilder().setKind("Task").build();
    QueryResults<Key> allKeys = datastore.run(allKeysQuery);
    Key[] keysToDelete = ImmutableList.copyOf(allKeys).toArray(new Key[0]);
    datastore.delete(keysToDelete);
  }

  @Test
  public void testAggregationQueryAndCountAggregationSample() {
    CountAggregationOnKind.invoke();
    systemsOutRule.assertContains("Total tasks count is 3");
    systemsOutRule.assertContains("Total tasks (accessible from default alias) is 3");
  }

  @Test
  public void testAggregationQueryAndCountAggregationWithLimitSample() {
    CountAggregationWithLimit.invoke();
    systemsOutRule.assertContains("We have at least 2 tasks");
  }

  @Test
  public void testAggregationQueryAndCountAggregationWithOrderBySample() {
    CountAggregationWithOrderBy.invoke();
    systemsOutRule.assertContains("Total 2 tasks found with priority field");
  }

  @Test
  public void testAggregationQueryAndCountAggregationWithPropertyFilterSample() {
    CountAggregationWithPropertyFilter.invoke();
    systemsOutRule.assertContains("Total completed tasks count is 2");
    systemsOutRule.assertContains("Total remaining tasks count is 1");
  }

  @Test
  public void testAggregationQueryAndCountAggregationSampleWithGqlQuery() {
    CountAggregationWithGqlQuery.invoke();
    systemsOutRule.assertContains("We have at least 2 tasks");
    systemsOutRule.assertContains("Total tasks count is 3");
    systemsOutRule.assertContains("Total completed tasks count is 2");
  }

  @Test
  public void testAggregationQueryAndCountWithStaleRead() throws InterruptedException {
    CountAggregationWithStaleRead.invoke();
    systemsOutRule.assertContains("Latest tasks count is 3");
    systemsOutRule.assertContains("Stale tasks count is 2");
  }

  @Test
  public void testAggregationQueryAndCountWithTransaction() throws InterruptedException {
    assertThrows(Exception.class, CountAggregationInTransaction::invoke);
    systemsOutRule.assertContains("Found existing 2 tasks, rolling back");
  }
}
