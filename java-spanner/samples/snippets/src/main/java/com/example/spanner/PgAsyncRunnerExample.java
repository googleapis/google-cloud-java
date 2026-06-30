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

//[START spanner_postgresql_async_read_write_transaction]
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.spanner.AsyncRunner;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class PgAsyncRunnerExample {

  static void asyncRunner() throws InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    try (Spanner spanner =
             SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      asyncRunner(client);
    }
  }

  // Execute a read/write transaction asynchronously.
  static void asyncRunner(DatabaseClient client)
      throws InterruptedException, ExecutionException, TimeoutException {
    ExecutorService executor = Executors.newSingleThreadExecutor();

    // Create an async transaction runner.
    AsyncRunner runner = client.runAsync();
    // The transaction returns the total number of rows that were updated as a future array of
    // longs.
    ApiFuture<long[]> rowCounts =
        runner.runAsync(
            txn -> {
              // Transfer marketing budget from one album to another. We do it in a
              // transaction to ensure that the transfer is atomic.
              ApiFuture<Struct> album1BudgetFut =
                  txn.readRowAsync("Albums", Key.of(1, 1), ImmutableList.of("MarketingBudget"));
              ApiFuture<Struct> album2BudgetFut =
                  txn.readRowAsync("Albums", Key.of(2, 2), ImmutableList.of("MarketingBudget"));

              try {
                // Transaction will only be committed if this condition still holds at the
                // time of commit. Otherwise it will be aborted and the AsyncWork will be
                // rerun by the client library.
                long transfer = 200_000;
                if (album2BudgetFut.get().getLong(0) >= transfer) {
                  long album1Budget = album1BudgetFut.get().getLong(0);
                  long album2Budget = album2BudgetFut.get().getLong(0);

                  album1Budget += transfer;
                  album2Budget -= transfer;
                  Statement updateStatement1 =
                      Statement.newBuilder(
                              "UPDATE Albums "
                                  + "SET MarketingBudget = $1 "
                                  + "WHERE SingerId = 1 and AlbumId = 1")
                          .bind("p1")
                          .to(album1Budget)
                          .build();
                  Statement updateStatement2 =
                      Statement.newBuilder(
                              "UPDATE Albums "
                                  + "SET MarketingBudget = $1 "
                                  + "WHERE SingerId = 2 and AlbumId = 2")
                          .bind("p1")
                          .to(album2Budget)
                          .build();
                  return txn.batchUpdateAsync(
                      ImmutableList.of(updateStatement1, updateStatement2));
                } else {
                  return ApiFutures.immediateFuture(new long[] {0L, 0L});
                }
              } catch (ExecutionException e) {
                throw SpannerExceptionFactory.newSpannerException(e.getCause());
              } catch (InterruptedException e) {
                throw SpannerExceptionFactory.propagateInterrupt(e);
              }
            },
            executor);

    ApiFuture<Long> totalUpdateCount =
        ApiFutures.transform(
            rowCounts,
            input -> Arrays.stream(input).sum(),
            MoreExecutors.directExecutor());
    System.out.printf("%d records updated.%n", totalUpdateCount.get(30L, TimeUnit.SECONDS));
    executor.shutdown();
  }
}
//[END spanner_postgresql_async_read_write_transaction]
