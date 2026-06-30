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

//[START spanner_async_read_row]
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Struct;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class AsyncReadRowExample {

  static void asyncReadRow() throws InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      asyncReadRow(client);
    }
  }

  // Read a single row asynchronously and print out the result when available.
  static void asyncReadRow(DatabaseClient client)
      throws InterruptedException, ExecutionException, TimeoutException {
    ApiFuture<Struct> row =
        client
            .singleUse()
            .readRowAsync(
                "Albums", Key.of(1L, 1L), Arrays.asList("SingerId", "AlbumId", "AlbumTitle"));
    // Add a callback that will print out the contents of the row when the result has been returned.
    SettableApiFuture<Void> printed = SettableApiFuture.create();
    ApiFutures.addCallback(
        row,
        new ApiFutureCallback<Struct>() {
          @Override
          public void onFailure(Throwable t) {
            System.out.printf("Error reading row: %s%n", t.getMessage());
            printed.set(null);
          }

          @Override
          public void onSuccess(Struct result) {
            System.out.printf(
                "%d %d %s%n", result.getLong(0), result.getLong(1), result.getString(2));
            printed.set(null);
          }
        },
        MoreExecutors.directExecutor());

    // Wait until the row has been printed.
    printed.get(30L, TimeUnit.SECONDS);
  }
}
//[END spanner_async_read_row]
