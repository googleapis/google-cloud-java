/*
 * Copyright 2023 Google Inc.
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

// [START spanner_transaction_timeout]

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import io.grpc.Context;
import io.grpc.Context.CancellableContext;
import io.grpc.Deadline;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Sample showing how to set a timeout for an entire transaction for the Cloud Spanner Java client.
 */
class TransactionTimeoutExample {

  static void executeTransactionWithTimeout() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    executeTransactionWithTimeout(projectId, instanceId, databaseId, 60L, TimeUnit.SECONDS);
  }

  // Execute a read/write transaction with a timeout for the entire transaction.
  static void executeTransactionWithTimeout(
      String projectId,
      String instanceId,
      String databaseId,
      long timeoutValue,
      TimeUnit timeoutUnit) {
    try (Spanner spanner = SpannerOptions.newBuilder().setProjectId(projectId).build()
        .getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      // Create a gRPC context with a deadline and with cancellation.
      // gRPC context deadlines require the use of a scheduled executor.
      ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
      try (CancellableContext context =
          Context.current()
              .withDeadline(Deadline.after(timeoutValue, timeoutUnit), executor)
              .withCancellation()) {
        context.run(
            () -> {
              client
                  .readWriteTransaction()
                  .run(
                      transaction -> {
                        try (ResultSet resultSet =
                            transaction.executeQuery(
                                Statement.of(
                                    "SELECT SingerId, FirstName, LastName\n"
                                        + "FROM Singers\n"
                                        + "ORDER BY LastName, FirstName"))) {
                          while (resultSet.next()) {
                            System.out.printf(
                                "%d %s %s\n",
                                resultSet.getLong("SingerId"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"));
                          }
                        }
                        String sql =
                            "INSERT INTO Singers (SingerId, FirstName, LastName)\n"
                                + "VALUES (20, 'George', 'Washington')";
                        long rowCount = transaction.executeUpdate(Statement.of(sql));
                        System.out.printf("%d record inserted.%n", rowCount);
                        return null;
                      });
            });
      }
    }
  }
}
// [END spanner_transaction_timeout]
