/*
 * Copyright 2023 Google LLC
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

// [START datastore_multiple_aggregation_in_structured_query]

import static com.google.cloud.datastore.aggregation.Aggregation.avg;
import static com.google.cloud.datastore.aggregation.Aggregation.count;
import static com.google.cloud.datastore.aggregation.Aggregation.sum;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.common.collect.Iterables;

public class MultipleAggregationsInStructuredQuery {

  public static void invoke() {
    // Instantiates a client.
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity.
    String kind = "Sales";

    Key sales1Key = datastore.newKeyFactory().setKind(kind).newKey("sales1");
    Key sales2Key = datastore.newKeyFactory().setKind(kind).newKey("sales2");
    Key sales3Key = datastore.newKeyFactory().setKind(kind).newKey("sales3");

    // Save all the sales.
    datastore.put(
        Entity.newBuilder(sales1Key).set("amount", 89).set("customerId", 1).build(),
        Entity.newBuilder(sales2Key).set("amount", 95).set("customerId", 1).build(),
        Entity.newBuilder(sales3Key).set("amount", 55).set("customerId", 2).build());

    EntityQuery baseQuery = Query.newEntityQueryBuilder().setKind(kind).build();

    // Creating an aggregation query with COUNT, SUM and AVG aggregations.
    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .over(baseQuery)
            .addAggregation(count().as("total_count"))
            .addAggregation(sum("amount").as("sales_sum"))
            .addAggregation(avg("amount").as("sales_avg"))
            .build();

    // Executing aggregation query.
    AggregationResult aggregationResult =
        Iterables.getOnlyElement(datastore.runAggregation(aggregationQuery));

    System.out.printf("Total sales count: %d", aggregationResult.getLong("total_count")); // 3
    System.out.printf("Sum of sales: %d", aggregationResult.getLong("sales_sum")); // 239
    System.out.printf(
        "Avg of sales: %.8f", aggregationResult.getDouble("sales_avg")); // 79.66666667
  }
}
// [END datastore_multiple_aggregation_in_structured_query]
