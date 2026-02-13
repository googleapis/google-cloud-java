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

// [START datastore_sum_aggregation_query_with_filters]

import static com.google.cloud.datastore.aggregation.Aggregation.sum;

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

public class SumAggregationWithPropertyFilter {

  public static void invoke() {
    // Instantiates a client.
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity.
    String kind = "Sales";

    Key sales1Key = datastore.newKeyFactory().setKind(kind).newKey("sales1");
    Key sales2Key = datastore.newKeyFactory().setKind(kind).newKey("sales2");
    Key sales3Key = datastore.newKeyFactory().setKind(kind).newKey("sales3");

    // Save all the tasks.
    datastore.put(
        Entity.newBuilder(sales1Key).set("amount", 89).set("customerId", 1).build(),
        Entity.newBuilder(sales2Key).set("amount", 95).set("customerId", 1).build(),
        Entity.newBuilder(sales3Key).set("amount", 55).set("customerId", 2).build());

    EntityQuery customer1Sales =
        Query.newEntityQueryBuilder()
            .setKind(kind)
            .setFilter(PropertyFilter.eq("customerId", 1))
            .build();

    // Creating an aggregation query to get the sum of all sales for customerId 1.
    AggregationQuery customer1SalesSum =
        Query.newAggregationQueryBuilder()
            .over(customer1Sales)
            .addAggregation(sum("amount").as("total_sales"))
            .build();

    // Executing aggregation query.
    AggregationResult customer1SalesSumQueryResult =
        Iterables.getOnlyElement(datastore.runAggregation(customer1SalesSum));

    System.out.printf(
        "Customer 1 sales sum is %d", customer1SalesSumQueryResult.getLong("total_sales")); // 184
  }
}
// [END datastore_sum_aggregation_query_with_filters]
