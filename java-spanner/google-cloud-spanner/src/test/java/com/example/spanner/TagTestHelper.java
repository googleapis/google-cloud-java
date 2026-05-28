/*
 * Copyright 2026 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.AsyncTransactionManager;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Options.TransactionOption;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionManager;
import com.google.cloud.spanner.TransactionRunner;
import com.google.common.util.concurrent.MoreExecutors;

/** Helper class in a non-ignored package to stable-test auto-tagging stack walks. */
public final class TagTestHelper {

  private TagTestHelper() {}

  public static <T> T run(
      DatabaseClient client, TransactionRunner.TransactionCallable<T> callable) {
    return client.readWriteTransaction().run(callable);
  }

  public static <T> T runWithOptions(
      DatabaseClient client,
      TransactionRunner.TransactionCallable<T> callable,
      TransactionOption option) {
    return client.readWriteTransaction(option).run(callable);
  }

  public static <R> ApiFuture<R> runAsync(
      DatabaseClient client, com.google.cloud.spanner.AsyncRunner.AsyncWork<R> work) {
    return client.runAsync().runAsync(work, MoreExecutors.directExecutor());
  }

  public static void singleUseConsume(
      DatabaseClient client, com.google.cloud.spanner.Statement stmt) {
    try (com.google.cloud.spanner.ResultSet resultSet = client.singleUse().executeQuery(stmt)) {
      while (resultSet.next()) {}
    }
  }

  public static void readOnlyTxnConsume(
      com.google.cloud.spanner.ReadOnlyTransaction txn, com.google.cloud.spanner.Statement stmt) {
    try (com.google.cloud.spanner.ResultSet resultSet = txn.executeQuery(stmt)) {
      while (resultSet.next()) {}
    }
  }

  public static void runWithManager(
      DatabaseClient client, com.google.cloud.spanner.Statement stmt) {
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext transaction = manager.begin();
      while (true) {
        try {
          transaction.executeUpdate(stmt);
          manager.commit();
          break;
        } catch (AbortedException abortedException) {
          transaction = manager.resetForRetry();
        }
      }
    }
  }

  public static ApiFuture<Void> runWithAsyncManager(
      DatabaseClient client, com.google.cloud.spanner.Statement stmt) {
    final AsyncTransactionManager manager = client.transactionManagerAsync();
    AsyncTransactionManager.TransactionContextFuture txnFuture = manager.beginAsync();
    return com.google.api.core.ApiFutures.transformAsync(
        txnFuture
            .then(
                (transaction, ignored) -> transaction.executeUpdateAsync(stmt),
                MoreExecutors.directExecutor())
            .commitAsync(),
        commitTimestamp -> {
          manager.close();
          return com.google.api.core.ApiFutures.immediateFuture(null);
        },
        MoreExecutors.directExecutor());
  }

  /** Subclass with an extremely long name to test tag truncation rules. */
  public static final class ExtremelyLongClassNameForTestingTagTruncationSupportUnderCheckstyle {
    public static <T> T run(
        DatabaseClient client, TransactionRunner.TransactionCallable<T> callable) {
      return client.readWriteTransaction().run(callable);
    }
  }
}
