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

package com.example.datastore.filters;

// sample-metadata:
//   title: Create a union between two filters
//   description: Create a union between two filters (logical OR operator)

// [START datastore_query_filter_or]
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.CompositeFilter;
import com.google.cloud.datastore.StructuredQuery.Filter;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;

public class OrFilterQuery {
  public static void invoke() throws Exception {

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    String propertyName = "description";

    // Create the two filters
    Filter orFilter =
        CompositeFilter.or(
            PropertyFilter.eq(propertyName, "Feed cats"),
            PropertyFilter.eq(propertyName, "Buy milk"));

    // Build the query
    Query<Entity> query = Query.newEntityQueryBuilder().setKind("Task").setFilter(orFilter).build();

    // Get the results back from Datastore
    QueryResults<Entity> results = datastore.run(query);

    if (!results.hasNext()) {
      throw new Exception("query yielded no results");
    }

    while (results.hasNext()) {
      Entity entity = results.next();
      System.out.printf("Entity: %s%n", entity);
    }
  }
}
// [END datastore_query_filter_or]
