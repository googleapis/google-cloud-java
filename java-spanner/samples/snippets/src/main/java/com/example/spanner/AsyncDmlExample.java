/*
 * Copyright 2020 Google Inc.
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

// [START spanner_async_dml_standard_insert]
import com.google.api.core.ApiFuture;
import com.google.cloud.spanner.AsyncRunner;
import com.google.cloud.spanner.AsyncRunner.AsyncWork;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TransactionContext;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

class AsyncDmlExample {

  static void asyncDml() throws InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      asyncDml(client);
    }
  }

  // Execute a DML statement asynchronously.
  static void asyncDml(DatabaseClient client)
      throws InterruptedException, ExecutionException, TimeoutException {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    AsyncRunner runner = client.runAsync();
    ApiFuture<Long> rowCount =
        runner.runAsync(
            txn -> {
              String sql =
                  "INSERT INTO Singers (SingerId, FirstName, LastName) VALUES "
                      + "(12, 'Melissa', 'Garcia'), "
                      + "(13, 'Russell', 'Morales'), "
                      + "(14, 'Jacqueline', 'Long'), "
                      + "(15, 'Dylan', 'Shaw')";
              return txn.executeUpdateAsync(Statement.of(sql));
            },
            executor);
    System.out.printf("%d records inserted.%n", rowCount.get());
    executor.shutdown();
  }
}
//[END spanner_async_dml_standard_insert]
