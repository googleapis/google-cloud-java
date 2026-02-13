/*
 * Copyright 2024 Google LLC
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

package com.example.datastore.filters;

// sample-metadata:
//   title: Queries with order fileds
//   description: The following query order properties
//   in the decreasing order of query constraint selectivity.

// [START datastore_query_order_fields]

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;

public class OrderFieldsQuery {
  public static void invoke() throws Exception {

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // Build a query with order properties in the decreasing order of query constraint selectivity.
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind("employees")
            .setFilter(PropertyFilter.gt("salary", 100000))
            .setOrderBy(OrderBy.asc("salary"))
            .build();

    // Get the results back from Datastore
    QueryResults<Entity> results = datastore.run(query);
    // Order results by `experience`

    if (!results.hasNext()) {
      throw new Exception("query yielded no results");
    }

    while (results.hasNext()) {
      Entity entity = results.next();
      System.out.printf("Entity: %s%n", entity);
    }
  }
}
// [END datastore_query_order_fields]
