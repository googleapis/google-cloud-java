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

package com.google.cloud.spanner;

import static com.google.cloud.spanner.MockSpannerTestUtil.INVALID_SELECT_STATEMENT;
import static com.google.cloud.spanner.MockSpannerTestUtil.SELECT1;
import static com.google.cloud.spanner.MockSpannerTestUtil.UPDATE_STATEMENT;
import static com.google.cloud.spanner.SpannerApiFutures.get;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFutures;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AsyncTransactionManager.TransactionContextFuture;
import com.google.cloud.spanner.Options.TransactionOption;
import java.util.Collections;
import java.util.concurrent.Executor;

public class MockSpannerTestActions {

  static final Mutation TEST_MUTATION =
      Mutation.newInsertBuilder("foo").set("id").to(1L).set("name").to("bar").build();

  static Timestamp writeInsertMutation(DatabaseClient client) {
    return client.write(Collections.singletonList(TEST_MUTATION));
  }

  static void writeInsertMutationWithOptions(DatabaseClient client, TransactionOption... options) {
    client.writeWithOptions(Collections.singletonList(TEST_MUTATION), options);
  }

  static Timestamp writeAtLeastOnceInsertMutation(DatabaseClient client) {
    return client.writeAtLeastOnce(Collections.singletonList(TEST_MUTATION));
  }

  static void writeAtLeastOnceWithOptionsInsertMutation(
      DatabaseClient client, TransactionOption... options) {
    client.writeAtLeastOnceWithOptions(Collections.singletonList(TEST_MUTATION), options);
  }

  static void executeBatchUpdateTransaction(DatabaseClient client, TransactionOption... options) {
    client
        .readWriteTransaction(options)
        .run(transaction -> transaction.batchUpdate(Collections.singletonList(UPDATE_STATEMENT)));
  }

  static void executePartitionedUpdate(DatabaseClient client) {
    client.executePartitionedUpdate(UPDATE_STATEMENT);
  }

  static void commitDeleteTransaction(DatabaseClient client, TransactionOption... options) {
    client
        .readWriteTransaction(options)
        .run(
            transaction -> {
              transaction.buffer(Mutation.delete("TEST", KeySet.all()));
              return null;
            });
  }

  static void transactionManagerCommit(DatabaseClient client, TransactionOption... options) {
    try (TransactionManager manager = client.transactionManager(options)) {
      TransactionContext transaction = manager.begin();
      transaction.buffer(Mutation.delete("TEST", KeySet.all()));
      manager.commit();
    }
  }

  static void asyncRunnerCommit(
      DatabaseClient client, Executor executor, TransactionOption... options) {
    AsyncRunner runner = client.runAsync(options);
    SpannerApiFutures.get(
        runner.runAsync(
            txn -> {
              txn.buffer(Mutation.delete("TEST", KeySet.all()));
              return ApiFutures.immediateFuture(null);
            },
            executor));
  }

  static void transactionManagerAsyncCommit(
      DatabaseClient client, Executor executor, TransactionOption... options) {
    try (AsyncTransactionManager manager = client.transactionManagerAsync(options)) {
      TransactionContextFuture transaction = manager.beginAsync();
      get(
          transaction
              .then(
                  (txn, input) -> {
                    txn.buffer(Mutation.delete("TEST", KeySet.all()));
                    return ApiFutures.immediateFuture(null);
                  },
                  executor)
              .commitAsync());
    }
  }

  static Long executeSelect1(DatabaseClient client, TransactionOption... options) {
    return client
        .readWriteTransaction(options)
        .run(
            transaction -> {
              try (ResultSet rs = transaction.executeQuery(SELECT1)) {
                while (rs.next()) {
                  return rs.getLong(0);
                }
              } catch (AbortedException e) {

              }
              return 0L;
            });
  }

  static Long executeReadFoo(DatabaseClient client, TransactionOption... options) {
    return client
        .readWriteTransaction(options)
        .run(
            transaction -> {
              try (ResultSet rs =
                  transaction.read("FOO", KeySet.all(), Collections.singletonList("ID"))) {
                while (rs.next()) {
                  return rs.getLong(0);
                }
              } catch (AbortedException e) {
                // Ignore the AbortedException and let the commit handle it.
              }
              return 0L;
            });
  }

  static Long executeInvalidAndValidSql(DatabaseClient client, TransactionOption... options) {
    return client
        .readWriteTransaction(options)
        .run(
            transaction -> {
              // This query carries the BeginTransaction, but fails. The BeginTransaction will
              // then be carried by the subsequent statement.
              try (ResultSet rs = transaction.executeQuery(INVALID_SELECT_STATEMENT)) {
                SpannerException e = assertThrows(SpannerException.class, () -> rs.next());
                assertEquals(ErrorCode.INVALID_ARGUMENT, e.getErrorCode());
              }
              return transaction.executeUpdate(UPDATE_STATEMENT);
            });
  }
}
