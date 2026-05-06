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

// [START spanner_async_read_only_transaction]
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.spanner.AsyncResultSet;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.ReadyCallback;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ReadOnlyTransaction;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class AsyncReadOnlyTransactionExample {

  static void asyncReadOnlyTransaction()
      throws InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      asyncReadOnlyTransaction(client);
    }
  }

  static void asyncReadOnlyTransaction(DatabaseClient client)
      throws InterruptedException, ExecutionException, TimeoutException {
    ApiFuture<Void> finished1;
    ApiFuture<Void> finished2;
    ExecutorService executor = Executors.newFixedThreadPool(2);

    try (ReadOnlyTransaction transaction = client.readOnlyTransaction()) {
      try (AsyncResultSet resultSet =
          transaction.executeQueryAsync(
              Statement.of("SELECT SingerId, AlbumId, AlbumTitle FROM Albums"))) {
        finished1 =
            resultSet.setCallback(
                executor,
                new ReadyCallback() {
                  @Override
                  public CallbackResponse cursorReady(AsyncResultSet resultSet) {
                    try {
                      while (true) {
                        switch (resultSet.tryNext()) {
                          case OK:
                            System.out.printf(
                                "%d %d %s%n",
                                resultSet.getLong(0), resultSet.getLong(1), resultSet.getString(2));
                            break;
                          case DONE:
                            return CallbackResponse.DONE;
                          case NOT_READY:
                            return CallbackResponse.CONTINUE;
                          default:
                            throw new IllegalStateException();
                        }
                      }
                    } catch (SpannerException e) {
                      System.out.printf("Error in callback: %s%n", e.getMessage());
                      return CallbackResponse.DONE;
                    }
                  }
                });
      }
      try (AsyncResultSet resultSet =
          transaction.executeQueryAsync(
              Statement.of("SELECT SingerId, FirstName, LastName FROM Singers"))) {
        finished2 =
            resultSet.setCallback(
                executor,
                new ReadyCallback() {
                  @Override
                  public CallbackResponse cursorReady(AsyncResultSet resultSet) {
                    try {
                      while (true) {
                        switch (resultSet.tryNext()) {
                          case OK:
                            System.out.printf(
                                "%d %s %s%n",
                                resultSet.getLong(0),
                                resultSet.getString(1),
                                resultSet.getString(2));
                            break;
                          case DONE:
                            return CallbackResponse.DONE;
                          case NOT_READY:
                            return CallbackResponse.CONTINUE;
                          default:
                            throw new IllegalStateException();
                        }
                      }
                    } catch (SpannerException e) {
                      System.out.printf("Error in callback: %s%n", e.getMessage());
                      return CallbackResponse.DONE;
                    }
                  }
                });
      }
    }

    ApiFutures.allAsList(ImmutableList.of(finished1, finished2)).get(60L, TimeUnit.SECONDS);
    executor.shutdown();
  }
}
//[END spanner_async_read_only_transaction]
