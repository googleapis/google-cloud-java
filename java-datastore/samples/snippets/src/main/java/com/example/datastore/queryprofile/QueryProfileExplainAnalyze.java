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

// [START datastore_query_explain_analyze_entity]
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.models.ExecutionStats;
import com.google.cloud.datastore.models.ExplainMetrics;
import com.google.cloud.datastore.models.ExplainOptions;
import com.google.cloud.datastore.models.PlanSummary;
import java.util.List;
import java.util.Map;

public class QueryProfileExplainAnalyze {
  public static void invoke() throws Exception {
    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // Build the query
    Query<Entity> query = Query.newEntityQueryBuilder().setKind("Task").build();

    // Set explain options with analzye = true to get back the query stats, plan info, and query
    // results
    QueryResults<Entity> results =
        datastore.run(query, ExplainOptions.newBuilder().setAnalyze(true).build());

    // Get the result set stats
    if (!results.getExplainMetrics().isPresent()) {
      throw new Exception("No explain metrics returned");
    }
    ExplainMetrics explainMetrics = results.getExplainMetrics().get();

    // Get the execution stats
    if (!explainMetrics.getExecutionStats().isPresent()) {
      throw new Exception("No execution stats returned");
    }

    ExecutionStats executionStats = explainMetrics.getExecutionStats().get();
    Map<String, Object> debugStats = executionStats.getDebugStats();
    System.out.println("----- Debug Stats -----");
    debugStats.forEach((key, val) -> System.out.println(key + ": " + val));
    System.out.println("----------");

    long resultsReturned = executionStats.getResultsReturned();
    System.out.println("Results returned: " + resultsReturned);

    // Get the plan summary
    PlanSummary planSummary = explainMetrics.getPlanSummary();
    List<Map<String, Object>> indexesUsed = planSummary.getIndexesUsed();
    System.out.println("----- Indexes Used -----");
    indexesUsed.forEach(map -> map.forEach((key, val) -> System.out.println(key + ": " + val)));

    if (!results.hasNext()) {
      throw new Exception("query yielded no results");
    }

    // Get the query results
    System.out.println("----- Query Results -----");
    while (results.hasNext()) {
      Entity entity = results.next();
      System.out.printf("Entity: %s%n", entity);
    }
  }
}
// [END datastore_query_explain_analyze_entity]
