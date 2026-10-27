/*
 * Copyright 2026 Google LLC
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

package com.example.bigquery;

// [START bigquery_query_arrow]

import com.google.cloud.bigquery.ArrowQueryResult;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.VectorSchemaRoot;

public class QueryArrow {

  public static void main(String[] args) {
    // TODO(developer): Replace this query before running the sample.
    String query =
        "SELECT corpus, count(*) as corpus_count "
            + "FROM `bigquery-public-data.samples.shakespeare` GROUP BY corpus;";
    queryArrow(query);
  }

  /**
   * Runs a query and streams Apache Arrow {@link VectorSchemaRoot} batches directly for zero-copy
   * vector access.
   *
   * <p><b>JVM Requirements (Java 16+):</b> Applications running on Java 16 or newer must supply the
   * following JVM option to allow Apache Arrow's memory allocator access to internal
   * DirectByteBuffer:
   *
   * <pre>{@code --add-opens=java.base/java.nio=org.apache.arrow.memory.core,ALL-UNNAMED}</pre>
   */
  public static void queryArrow(String query) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // Create the query configuration.
      QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();

      // Execute the query using queryArrow. Always close ArrowQueryResult to free off-heap memory.
      try (ArrowQueryResult result = bigquery.queryArrow(queryConfig)) {
        long totalRows = 0;
        for (VectorSchemaRoot root : result) {
          int rowCount = root.getRowCount();
          totalRows += rowCount;
          FieldVector corpusVector = root.getVector("corpus");
          FieldVector countVector = root.getVector("corpus_count");

          for (int i = 0; i < rowCount; i++) {
            System.out.print("corpus:" + corpusVector.getObject(i));
            System.out.print(", count:" + countVector.getObject(i));
            System.out.println();
          }
        }
        System.out.println("Arrow query ran successfully. Total rows: " + totalRows);
      }
    } catch (BigQueryException e) {
      System.out.println("Arrow query did not run \n" + e.toString());
    } catch (InterruptedException e) {
      System.out.println("Arrow query was interrupted \n" + e.toString());
      Thread.currentThread().interrupt();
    }
  }
}
// [END bigquery_query_arrow]
