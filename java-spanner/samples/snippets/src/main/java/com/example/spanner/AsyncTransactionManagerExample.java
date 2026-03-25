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

//[START spanner_async_transaction_manager]
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.AsyncTransactionManager;
import com.google.cloud.spanner.AsyncTransactionManager.AsyncTransactionStep;
import com.google.cloud.spanner.AsyncTransactionManager.CommitTimestampFuture;
import com.google.cloud.spanner.AsyncTransactionManager.TransactionContextFuture;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class AsyncTransactionManagerExample {

  static void asyncTransactionManager()
      throws InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      asyncTransactionManager(client);
    }
  }

  static void asyncTransactionManager(DatabaseClient client)
      throws InterruptedException, ExecutionException, TimeoutException {
    ExecutorService executor = Executors.newSingleThreadExecutor();

    AsyncTransactionStep<List<Struct>, long[]> updateCounts;
    try (AsyncTransactionManager mgr = client.transactionManagerAsync()) {
      TransactionContextFuture txn = mgr.beginAsync();
      // Loop to retry aborted errors.
      while (true) {
        try {
          updateCounts =
              txn.then(
                (transaction, v) -> {
                  // Execute two reads in parallel and return the result of these as the input
                  // for the next step of the transaction.
                  ApiFuture<Struct> album1BudgetFut =
                      transaction.readRowAsync(
                          "Albums", Key.of(1, 1), ImmutableList.of("MarketingBudget"));
                  ApiFuture<Struct> album2BudgetFut =
                      transaction.readRowAsync(
                          "Albums", Key.of(2, 2), ImmutableList.of("MarketingBudget"));
                  return ApiFutures.allAsList(Arrays.asList(album1BudgetFut, album2BudgetFut));
                },
                executor)
                  // The input of the next step of the transaction is the return value of the
                  // previous step, i.e. a list containing the marketing budget of two Albums.
                  .then(
                    (transaction, budgets) -> {
                      long album1Budget = budgets.get(0).getLong(0);
                      long album2Budget = budgets.get(1).getLong(0);
                      long transfer = 200_000;
                      if (album2Budget >= transfer) {
                        album1Budget += transfer;
                        album2Budget -= transfer;
                        Statement updateStatement1 =
                            Statement.newBuilder(
                                    "UPDATE Albums "
                                        + "SET MarketingBudget = @AlbumBudget "
                                        + "WHERE SingerId = 1 and AlbumId = 1")
                                .bind("AlbumBudget")
                                .to(album1Budget)
                                .build();
                        Statement updateStatement2 =
                            Statement.newBuilder(
                                    "UPDATE Albums "
                                        + "SET MarketingBudget = @AlbumBudget "
                                        + "WHERE SingerId = 2 and AlbumId = 2")
                                .bind("AlbumBudget")
                                .to(album2Budget)
                                .build();
                        return transaction.batchUpdateAsync(
                            ImmutableList.of(updateStatement1, updateStatement2));
                      } else {
                        return ApiFutures.immediateFuture(new long[] {0L, 0L});
                      }
                    },
                    executor);
          // Commit after the updates.
          CommitTimestampFuture commitTsFut = updateCounts.commitAsync();
          // Wait for the transaction to finish and execute a retry if necessary.
          commitTsFut.get();
          break;
        } catch (AbortedException e) {
          txn = mgr.resetForRetryAsync();
        }
      }
    }

    // Calculate the total update count.
    ApiFuture<Long> totalUpdateCount =
        ApiFutures.transform(
            updateCounts,
            new ApiFunction<long[], Long>() {
              @SuppressFBWarnings("UVA_USE_VAR_ARGS")
              @Override
              public Long apply(long[] input) {
                return Arrays.stream(input).sum();
              }
            },
            MoreExecutors.directExecutor());
    System.out.printf("%d records updated.%n", totalUpdateCount.get(30L, TimeUnit.SECONDS));
    executor.shutdown();
  }
}
//[END spanner_async_transaction_manager]
