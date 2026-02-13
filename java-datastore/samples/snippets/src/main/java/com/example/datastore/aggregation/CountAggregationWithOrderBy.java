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

// [START datastore_count_aggregation_query_with_order_by]

import static com.google.cloud.datastore.StructuredQuery.OrderBy.asc;
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

public class CountAggregationWithOrderBy {
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
        Entity.newBuilder(task1Key).set("done", true).set("priority", 1).build(),
        // Priority not specified.
        Entity.newBuilder(task2Key).set("done", false).build(),
        Entity.newBuilder(task3Key).set("done", true).set("priority", 2).build());

    // OrderBy acts as an existence filter.
    EntityQuery selectAllTasks =
        Query.newEntityQueryBuilder().setKind(kind).addOrderBy(asc("priority")).build();
    // Creating an aggregation query to get the count of all tasks.
    AggregationQuery allTasksCountQuery =
        Query.newAggregationQueryBuilder()
            .over(selectAllTasks)
            .addAggregation(count().as("count"))
            .build();
    // Executing aggregation query.
    AggregationResult limitQueryResult =
        Iterables.getOnlyElement(datastore.runAggregation(allTasksCountQuery));

    System.out.printf(
        "Total %d tasks found with priority field", limitQueryResult.get("count")); // 2
  }
}
// [END datastore_count_aggregation_query_with_order_by]
