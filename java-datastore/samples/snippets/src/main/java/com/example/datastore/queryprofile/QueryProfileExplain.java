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

package com.example.datastore.queryprofile;

// [START datastore_query_explain_entity]

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.models.ExplainMetrics;
import com.google.cloud.datastore.models.ExplainOptions;
import com.google.cloud.datastore.models.PlanSummary;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class QueryProfileExplain {
  public static void invoke() throws Exception {
    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // Build the query
    Query<Entity> query = Query.newEntityQueryBuilder().setKind("Task").build();

    // Set the explain options to get back *only* the plan summary
    QueryResults<Entity> results = datastore.run(query, ExplainOptions.newBuilder().build());

    // Get the explain metrics
    Optional<ExplainMetrics> explainMetrics = results.getExplainMetrics();
    if (!explainMetrics.isPresent()) {
      throw new Exception("No explain metrics returned");
    }
    PlanSummary planSummary = explainMetrics.get().getPlanSummary();
    List<Map<String, Object>> indexesUsed = planSummary.getIndexesUsed();
    System.out.println("----- Indexes Used -----");
    indexesUsed.forEach(map -> map.forEach((key, val) -> System.out.println(key + ": " + val)));
  }
}
// [END datastore_query_explain_entity]
