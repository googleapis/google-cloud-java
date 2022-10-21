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

// [START datastore_count_aggregation_query_in_transaction]

import static com.google.cloud.datastore.aggregation.Aggregation.count;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Datastore.TransactionCallable;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.common.collect.Iterables;

public class CountAggregationInTransaction {

  public static void invoke() {
    // Instantiates a client.
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity.
    String kind = "Task";

    Key task1Key = datastore.newKeyFactory().setKind(kind).newKey("task1");
    Key task2Key = datastore.newKeyFactory().setKind(kind).newKey("task2");

    // Save all the tasks.
    datastore.put(
        Entity.newBuilder(task1Key).set("owner", "john").build(),
        Entity.newBuilder(task2Key).set("owner", "john").build());

    // Using transactions to maintain consistent application state.
    datastore.runInTransaction(
        (TransactionCallable<Void>)
            transaction -> {
              // Create a query to get the count of all tasks of owner 'John'.
              EntityQuery tasksOfJohn =
                  Query.newEntityQueryBuilder()
                      .setKind(kind)
                      .setFilter(PropertyFilter.eq("owner", "john"))
                      .build();
              AggregationQuery totalTasksQuery =
                  Query.newAggregationQueryBuilder()
                      .over(tasksOfJohn)
                      .addAggregation(count().as("tasks_count"))
                      .build();

              // Executing aggregation query in the ongoing transaction.
              Long tasksCount =
                  Iterables.getOnlyElement(transaction.runAggregation(totalTasksQuery))
                      .get("tasks_count");

              if (tasksCount < 2) {
                Key newTaskKey = datastore.newKeyFactory().setKind(kind).newKey("task3");
                Entity newTask = Entity.newBuilder(newTaskKey).set("owner", "john").build();
                // Inserting a new entity in the transaction.
                transaction.put(newTask);
              } else {
                System.out.printf("Found existing %d tasks, rolling back", tasksCount);
                throw new Exception("User 'John' cannot have more than 2 tasks");
              }
              return null;
            });
  }
}
// [END datastore_count_aggregation_query_in_transaction]
