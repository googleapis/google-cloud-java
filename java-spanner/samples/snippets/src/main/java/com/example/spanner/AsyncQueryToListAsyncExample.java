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

// [START spanner_async_query_to_list]
import com.google.api.core.ApiFuture;
import com.google.cloud.spanner.AsyncResultSet;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Example code for using Async query on Cloud Spanner and convert it to list.
 */
class AsyncQueryToListAsyncExample {
  static class Album {
    final long singerId;
    final long albumId;
    final String albumTitle;

    Album(long singerId, long albumId, String albumTitle) {
      this.singerId = singerId;
      this.albumId = albumId;
      this.albumTitle = albumTitle;
    }
  }

  static void asyncQueryToList() throws InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      asyncQueryToList(client);
    }
  }

  // Execute a query asynchronously and transform the result to a list.
  static void asyncQueryToList(DatabaseClient client)
      throws InterruptedException, ExecutionException, TimeoutException {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    ApiFuture<? extends List<Album>> albums;
    try (AsyncResultSet resultSet =
        client
            .singleUse()
            .executeQueryAsync(Statement.of("SELECT SingerId, AlbumId, AlbumTitle FROM Albums"))) {
      // Convert the result set to a list of Albums asynchronously.
      albums =
          resultSet.toListAsync(
              reader -> {
                return new Album(
                    reader.getLong("SingerId"),
                    reader.getLong("AlbumId"),
                    reader.getString("AlbumTitle"));
              },
              executor);
    }

    for (Album album : albums.get(30L, TimeUnit.SECONDS)) {
      System.out.printf("%d %d %s%n", album.singerId, album.albumId, album.albumTitle);
    }
    executor.shutdown();
  }
}
//[END spanner_async_query_to_list]
