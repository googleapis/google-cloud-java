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

// [START datastore_count_aggregation_query_with_filters]

import static com.google.cloud.datastore.aggregation.Aggregation.count;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.common.collect.Iterables;

public class CountAggregationWithPropertyFilter {

  public static void invoke() {
    // Instantiates a client.
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity.
    String kind = "Task";

    Key task1Key = datastore.newKeyFactory().setKind(kind).newKey("task1");
    Key task2Key = datastore.newKeyFactory().setKind(kind).newKey("task2");
    Key task3Key = datastore.newKeyFactory().setKind(kind).newKey("task3");

    // Save all the tasks.
    datastore.put(
        Entity.newBuilder(task1Key).set("done", true).build(),
        Entity.newBuilder(task2Key).set("done", false).build(),
        Entity.newBuilder(task3Key).set("done", true).build());

    EntityQuery completedTasks =
        Query.newEntityQueryBuilder()
            .setKind(kind)
            .setFilter(PropertyFilter.eq("done", true))
            .build();
    EntityQuery remainingTasks =
        Query.newEntityQueryBuilder()
            .setKind(kind)
            .setFilter(PropertyFilter.eq("done", false))
            .build();
    // Creating an aggregation query to get the count of all completed tasks.
    AggregationQuery completedTasksCountQuery =
        Query.newAggregationQueryBuilder()
            .over(completedTasks)
            .addAggregation(count().as("total_completed_count"))
            .build();
    // Creating an aggregation query to get the count of all remaining tasks.
    AggregationQuery remainingTasksCountQuery =
        Query.newAggregationQueryBuilder()
            .over(remainingTasks)
            .addAggregation(count().as("total_remaining_count"))
            .build();

    // Executing aggregation query.
    AggregationResult completedTasksCountQueryResult =
        Iterables.getOnlyElement(datastore.runAggregation(completedTasksCountQuery));
    AggregationResult remainingTasksCountQueryResult =
        Iterables.getOnlyElement(datastore.runAggregation(remainingTasksCountQuery));

    System.out.printf(
        "Total completed tasks count is %d",
        completedTasksCountQueryResult.get("total_completed_count")); // 2
    System.out.printf(
        "Total remaining tasks count is %d",
        remainingTasksCountQueryResult.get("total_remaining_count")); // 1
  }
}
// [END datastore_count_aggregation_query_with_filters]
