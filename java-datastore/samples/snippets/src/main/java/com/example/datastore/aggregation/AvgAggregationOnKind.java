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

// [START datastore_avg_aggregation_query_on_kind]

import static com.google.cloud.datastore.aggregation.Aggregation.avg;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.common.collect.Iterables;

public class AvgAggregationOnKind {

  // Instantiates a client.
  private static final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

  // The kind for the new entity.
  private static final String kind = "Sales";

  // Setting up Sales in database
  private static void setUpSales() {
    Key sales1Key = datastore.newKeyFactory().setKind(kind).newKey("sales1");
    Key sales2Key = datastore.newKeyFactory().setKind(kind).newKey("sales2");
    Key sales3Key = datastore.newKeyFactory().setKind(kind).newKey("sales3");

    // Save all the sales.
    datastore.put(
        Entity.newBuilder(sales1Key).set("amount", 89).build(),
        Entity.newBuilder(sales2Key).set("amount", 95).build(),
        Entity.newBuilder(sales3Key).set("amount", 55).build());
  }

  // Accessing aggregation result by the provided custom alias.
  private static void usageWithCustomAlias() {
    EntityQuery selectAllSales = Query.newEntityQueryBuilder().setKind(kind).build();
    // Creating an aggregation query to get the avg of all sales.
    AggregationQuery avgOfSalesQuery =
        Query.newAggregationQueryBuilder()
            .over(selectAllSales)
            // passing 'avg_sales_amount' as alias in the aggregation query.
            .addAggregation(avg("amount").as("avg_sales_amount"))
            .build();
    // Executing aggregation query.
    AggregationResult aggregationResult =
        Iterables.getOnlyElement(datastore.runAggregation(avgOfSalesQuery));

    System.out.printf(
        "Average sales is %.8f", aggregationResult.getDouble("avg_sales_amount")); // 79.66666667
  }

  public static void invoke() {
    setUpSales();
    usageWithCustomAlias();
  }
}
// [END datastore_avg_aggregation_query_on_kind]
