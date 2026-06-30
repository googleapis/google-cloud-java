/*
 * Copyright 2022 Google Inc.
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

package com.example.spanner;

// [START spanner_postgresql_batch_dml]

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import java.util.Arrays;

class PgBatchDmlSample {

  static void batchDml() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    batchDml(projectId, instanceId, databaseId);
  }

  static void batchDml(String projectId, String instanceId, String databaseId) {
    try (Spanner spanner =
        SpannerOptions.newBuilder()
            .setProjectId(projectId)
            .build()
            .getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));

      // Spanner PostgreSQL supports BatchDML statements. This will batch multiple DML statements
      // into one request, which reduces the number of round trips that is needed for multiple DML
      // statements.
      long[] updateCounts =
          client
              .readWriteTransaction()
              .run(
                  transaction ->
                      transaction.batchUpdate(
                          Arrays.asList(
                              Statement.newBuilder(
                                      "INSERT INTO Singers (SingerId, FirstName, LastName) "
                                          + "VALUES ($1, $2, $3)")
                                  // Use 'p1' to bind to the parameter with index 1 etc.
                                  .bind("p1")
                                  .to(1L)
                                  .bind("p2")
                                  .to("Alice")
                                  .bind("p3")
                                  .to("Henderson")
                                  .build(),
                              Statement.newBuilder(
                                      "INSERT INTO Singers (SingerId, FirstName, LastName) "
                                          + "VALUES ($1, $2, $3)")
                                  // Use 'p1' to bind to the parameter with index 1 etc.
                                  .bind("p1")
                                  .to(2L)
                                  .bind("p2")
                                  .to("Bruce")
                                  .bind("p3")
                                  .to("Allison")
                                  .build())));
      long totalUpdateCount = Arrays.stream(updateCounts).sum();
      System.out.printf("Inserted %d singers\n", totalUpdateCount);
    }
  }
}
// [END spanner_postgresql_batch_dml]