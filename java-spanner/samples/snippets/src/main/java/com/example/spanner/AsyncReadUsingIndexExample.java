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

//[START spanner_async_read_data_with_index]
import com.google.api.core.ApiFuture;
import com.google.cloud.spanner.AsyncResultSet;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.ReadyCallback;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerOptions;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class AsyncReadUsingIndexExample {

  static void asyncReadUsingIndex()
      throws InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      asyncReadUsingIndex(client);
    }
  }

  // Execute a query asynchronously and process the results in a callback.
  static void asyncReadUsingIndex(DatabaseClient client)
      throws InterruptedException, ExecutionException, TimeoutException {
    ApiFuture<Void> finished;
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try (AsyncResultSet resultSet =
        client
            .singleUse()
            .readUsingIndexAsync(
                "Albums",
                "AlbumsByAlbumTitle",
                KeySet.all(), // Read all rows in a table.
                Arrays.asList("AlbumId", "AlbumTitle"))) {
      // Setting a callback will automatically start the iteration over the results of the query
      // using the specified executor. The callback will be called at least once. The returned
      // ApiFuture is done when the callback has returned DONE and all resources used by the
      // AsyncResultSet have been released.
      finished =
          resultSet.setCallback(
              executor,
              new ReadyCallback() {
                @Override
                public CallbackResponse cursorReady(AsyncResultSet resultSet) {
                  try {
                    while (true) {
                      switch (resultSet.tryNext()) {
                        // OK: There is a row ready.
                        case OK:
                          System.out.printf(
                              "%d %s%n", resultSet.getLong(0), resultSet.getString(1));
                          break;

                        // DONE: There are no more rows in the result set.
                        case DONE:
                          return CallbackResponse.DONE;

                        // NOT_READY: There are currently no more rows in the buffer.
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

    // This ApiFuture is done when the callback has returned DONE and all resources of the
    // asynchronous result set have been released.
    finished.get(30L, TimeUnit.SECONDS);
    executor.shutdown();
  }
}
//[END spanner_async_read_data_with_index]
