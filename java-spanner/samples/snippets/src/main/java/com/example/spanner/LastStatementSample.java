/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;

/**
 * Sample showing how to set the last statement option when a DML statement is the last statement in
 * a transaction.
 */
public class LastStatementSample {

  static void insertAndUpdateUsingLastStatement() {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "my-project";
    final String instanceId = "my-instance";
    final String databaseId = "my-database";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      final DatabaseClient databaseClient =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      insertAndUpdateUsingLastStatement(databaseClient);
    }
  }

  // [START spanner_dml_last_statement]
  static void insertAndUpdateUsingLastStatement(DatabaseClient client) {
    client
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.executeUpdate(
                  Statement.of(
                      "INSERT Singers (SingerId, FirstName, LastName)\n"
                          + "VALUES (54213, 'John', 'Do')"));
              System.out.println("New singer inserted.");

              // Pass in the `lastStatement` option to the last DML statement of the transaction.
              transaction.executeUpdate(
                  Statement.of(
                      "UPDATE Singers SET Singers.LastName = 'Doe' WHERE SingerId = 54213\n"),
                  Options.lastStatement());
              System.out.println("Singer last name updated.");

              return null;
            });
  }
  // [END spanner_dml_last_statement]

}
