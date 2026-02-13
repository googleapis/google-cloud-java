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

package com.example.datastore.aggregation;

// [START datastore_count_aggregation_query_on_kind]
import static com.google.cloud.datastore.aggregation.Aggregation.count;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.common.collect.Iterables;

public class CountAggregationOnKind {
  // Instantiates a client.
  private static final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

  // The kind for the new entity.
  private static final String kind = "Task";

  // Setting up Tasks in database
  private static void setUpTasks() {
    Key task1Key = datastore.newKeyFactory().setKind(kind).newKey("task1");
    Key task2Key = datastore.newKeyFactory().setKind(kind).newKey("task2");
    Key task3Key = datastore.newKeyFactory().setKind(kind).newKey("task3");

    // Save all the tasks.
    datastore.put(
        Entity.newBuilder(task1Key).set("done", true).build(),
        Entity.newBuilder(task2Key).set("done", false).build(),
        Entity.newBuilder(task3Key).set("done", true).build());
  }

  // Accessing aggregation result by the generated alias.
  private static void usageWithGeneratedAlias() {
    EntityQuery selectAllTasks = Query.newEntityQueryBuilder().setKind(kind).build();
    // Creating an aggregation query to get the count of all tasks.
    AggregationQuery allTasksCountQuery =
        Query.newAggregationQueryBuilder().over(selectAllTasks).addAggregation(count()).build();
    // Executing aggregation query.
    AggregationResult aggregationResult =
        Iterables.getOnlyElement(datastore.runAggregation(allTasksCountQuery));

    System.out.printf(
        "Total tasks (accessible from default alias) is %d",
        aggregationResult.get("property_1")); // 3
  }

  // Accessing aggregation result by the provided custom alias.
  private static void usageWithCustomAlias() {
    EntityQuery selectAllTasks = Query.newEntityQueryBuilder().setKind(kind).build();
    // Creating an aggregation query to get the count of all tasks.
    AggregationQuery allTasksCountQuery =
        Query.newAggregationQueryBuilder()
            .over(selectAllTasks)
            // passing 'total_count' as alias in the aggregation query.
            .addAggregation(count().as("total_count"))
            .build();
    // Executing aggregation query.
    AggregationResult aggregationResult =
        Iterables.getOnlyElement(datastore.runAggregation(allTasksCountQuery));

    System.out.printf("Total tasks count is %d", aggregationResult.get("total_count")); // 3
  }

  public static void invoke() {
    setUpTasks();
    usageWithGeneratedAlias();
    usageWithCustomAlias();
  }
}
// [END datastore_count_aggregation_query_on_kind]
