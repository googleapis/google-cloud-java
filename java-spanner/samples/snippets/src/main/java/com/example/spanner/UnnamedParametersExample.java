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

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Statement.StatementFactory;
import java.time.LocalDate;

public class UnnamedParametersExample {

  static void executeQueryWithUnnamedParameters() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    executeQueryWithUnnamedParameters(projectId, instanceId, databaseId);
  }

  static void executeQueryWithUnnamedParameters(
      String projectId, String instanceId, String databaseId) {
    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {

      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      StatementFactory statementFactory = client.getStatementFactory();

      // Insert a row with unnamed parameters
      client
          .readWriteTransaction()
          .run(
              transaction -> {
                Statement statement = statementFactory
                    .withUnnamedParameters("INSERT INTO Students(StudentId, Name, IsNRI, AvgMarks, "
                            + "JoinedAt, PinCode, CreatedAt) VALUES(?, ?, ?, ?, ?, ?, ?)",
                        1000001,
                        "Google",
                        false,
                        (float) 34.5,
                        LocalDate.of(2024, 3, 31),
                        "123456",
                        Timestamp.now());
                transaction.executeUpdate(statement);

                return null;
              });
      System.out.println("Row is inserted.");

      // Query the table with unnamed parameters
      try (ResultSet resultSet =
          client
              .singleUse()
              .executeQuery(
                  statementFactory.withUnnamedParameters(
                      "SELECT * FROM Students WHERE StudentId = ?", 1000001))) {
        while (resultSet.next()) {
          System.out.println(resultSet.getString("Name"));
        }
      }
      System.out.println("Row is fetched.");
    }
  }
}
