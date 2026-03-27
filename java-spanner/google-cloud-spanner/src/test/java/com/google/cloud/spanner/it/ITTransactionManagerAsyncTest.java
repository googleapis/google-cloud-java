/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner.it;

import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

import com.google.api.core.ApiFutures;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.AsyncTransactionManager;
import com.google.cloud.spanner.AsyncTransactionManager.AsyncTransactionStep;
import com.google.cloud.spanner.AsyncTransactionManager.TransactionContextFuture;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TransactionManager.TransactionState;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
@Category(ParallelIntegrationTest.class)
public class ITTransactionManagerAsyncTest {

  @Parameter(0)
  public Executor executor;

  @Parameters(name = "executor = {0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {MoreExecutors.directExecutor()},
          {Executors.newSingleThreadExecutor()},
          {Executors.newFixedThreadPool(4)},
        });
  }

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static Database db;
  private static Spanner spanner;
  private static DatabaseClient client;

  @BeforeClass
  public static void setUpDatabase() {
    // Empty database.
    db =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE T ("
                    + "  K                   STRING(MAX) NOT NULL,"
                    + "  BoolValue           BOOL,"
                    + ") PRIMARY KEY (K)");
    spanner = env.getTestHelper().getClient();
    client = spanner.getDatabaseClient(db.getId());
  }

  @Before
  public void clearTable() {
    client.write(ImmutableList.of(Mutation.delete("T", KeySet.all())));
  }

  @Test
  public void testSimpleInsert() throws ExecutionException, InterruptedException {
    try (AsyncTransactionManager manager = client.transactionManagerAsync()) {
      TransactionContextFuture txn = manager.beginAsync();
      while (true) {
        assertThat(manager.getState()).isEqualTo(TransactionState.STARTED);
        try {
          txn.then(
                  (transaction, ignored) -> {
                    transaction.buffer(
                        Mutation.newInsertBuilder("T")
                            .set("K")
                            .to("Key1")
                            .set("BoolValue")
                            .to(true)
                            .build());
                    return ApiFutures.immediateFuture(null);
                  },
                  executor)
              .commitAsync()
              .get();
          assertThat(manager.getState()).isEqualTo(TransactionState.COMMITTED);
          Struct row =
              client.singleUse().readRow("T", Key.of("Key1"), Arrays.asList("K", "BoolValue"));
          assertThat(row.getString(0)).isEqualTo("Key1");
          assertThat(row.getBoolean(1)).isTrue();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis());
          txn = manager.resetForRetryAsync();
        }
      }
    }
  }

  @Test
  public void testInvalidInsert() throws InterruptedException {
    try (AsyncTransactionManager manager = client.transactionManagerAsync()) {
      TransactionContextFuture txn = manager.beginAsync();
      while (true) {
        try {
          txn.then(
                  (transaction, ignored) -> {
                    transaction.buffer(
                        Mutation.newInsertBuilder("InvalidTable")
                            .set("K")
                            .to("Key1")
                            .set("BoolValue")
                            .to(true)
                            .build());
                    return ApiFutures.immediateFuture(null);
                  },
                  executor)
              .commitAsync()
              .get();
          fail("Expected exception");
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis());
          txn = manager.resetForRetryAsync();
        } catch (ExecutionException e) {
          assertThat(e.getCause()).isInstanceOf(SpannerException.class);
          SpannerException se = (SpannerException) e.getCause();
          if (env.getTestHelper()
              .getOptions()
              .getSessionPoolOptions()
              .getUseMultiplexedSessionForRW()) {
            // Backend currently returns INVALID_ARGUMENT, however this will be changed to NOT_FOUND
            // in future.
            assertThat(se.getErrorCode()).isAnyOf(ErrorCode.NOT_FOUND, ErrorCode.INVALID_ARGUMENT);
          } else {
            assertThat(se.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
          }
          // expected
          break;
        }
      }
      assertThat(manager.getState()).isEqualTo(TransactionState.COMMIT_FAILED);
      // We cannot retry for non aborted errors.
      try {
        manager.resetForRetryAsync();
        fail("Expected exception");
      } catch (IllegalStateException ex) {
        assertNotNull(ex.getMessage());
      }
    }
  }

  @Test
  public void testRollback() throws InterruptedException {
    try (AsyncTransactionManager manager = client.transactionManagerAsync()) {
      TransactionContextFuture txn = manager.beginAsync();
      while (true) {
        txn.then(
            (transaction, ignored) -> {
              transaction.buffer(
                  Mutation.newInsertBuilder("T")
                      .set("K")
                      .to("Key2")
                      .set("BoolValue")
                      .to(true)
                      .build());
              return ApiFutures.immediateFuture(null);
            },
            executor);
        try {
          manager.rollbackAsync();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis());
          txn = manager.resetForRetryAsync();
        }
      }
      assertThat(manager.getState()).isEqualTo(TransactionState.ROLLED_BACK);
      // Row should not have been inserted.
      assertThat(client.singleUse().readRow("T", Key.of("Key2"), Arrays.asList("K", "BoolValue")))
          .isNull();
    }
  }

  @Ignore(
      "Cloud Spanner now seems to return CANCELLED instead of ABORTED when a transaction is"
          + " invalidated by a later transaction in the same session")
  @Test
  public void testAbortAndRetry() throws InterruptedException, ExecutionException {
    assumeFalse(
        "Emulator does not support more than 1 simultaneous transaction. "
            + "This test would therefore loop indefinitely on the emulator.",
        isUsingEmulator());

    client.write(
        Collections.singletonList(
            Mutation.newInsertBuilder("T").set("K").to("Key3").set("BoolValue").to(true).build()));
    try (AsyncTransactionManager manager1 = client.transactionManagerAsync()) {
      TransactionContextFuture txn1 = manager1.beginAsync();
      AsyncTransactionManager manager2;
      TransactionContextFuture txn2;
      AsyncTransactionStep<Void, Struct> txn2Step1;
      while (true) {
        try {
          AsyncTransactionStep<Void, Struct> txn1Step1 =
              txn1.then(
                  (transaction, ignored) ->
                      transaction.readRowAsync(
                          "T", Key.of("Key3"), Arrays.asList("K", "BoolValue")),
                  executor);
          manager2 = client.transactionManagerAsync();
          txn2 = manager2.beginAsync();
          txn2Step1 =
              txn2.then(
                  (transaction, ignored) ->
                      transaction.readRowAsync(
                          "T", Key.of("Key3"), Arrays.asList("K", "BoolValue")),
                  executor);

          AsyncTransactionStep<Struct, Void> txn1Step2 =
              txn1Step1.then(
                  (transaction, ignored) -> {
                    transaction.buffer(
                        Mutation.newUpdateBuilder("T")
                            .set("K")
                            .to("Key3")
                            .set("BoolValue")
                            .to(false)
                            .build());
                    return ApiFutures.immediateFuture(null);
                  },
                  executor);

          txn2Step1.get();
          txn1Step2.commitAsync().get();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis());
          // It is possible that it was txn2 that aborted.
          // In that case we should just retry without resetting anything.
          if (manager1.getState() == TransactionState.ABORTED) {
            txn1 = manager1.resetForRetryAsync();
          }
        }
      }

      // txn2 should have been aborted.
      try {
        txn2Step1.commitAsync().get();
        fail("Expected to abort");
      } catch (AbortedException e) {
        assertThat(manager2.getState()).isEqualTo(TransactionState.ABORTED);
        txn2 = manager2.resetForRetryAsync();
      }
      AsyncTransactionStep<Void, Void> txn2Step2 =
          txn2.then(
              (transaction, ignored) -> {
                transaction.buffer(
                    Mutation.newUpdateBuilder("T")
                        .set("K")
                        .to("Key3")
                        .set("BoolValue")
                        .to(true)
                        .build());
                return ApiFutures.immediateFuture(null);
              },
              executor);
      txn2Step2.commitAsync().get();
      Struct row = client.singleUse().readRow("T", Key.of("Key3"), Arrays.asList("K", "BoolValue"));
      assertThat(row.getString(0)).isEqualTo("Key3");
      assertThat(row.getBoolean(1)).isTrue();
      manager2.close();
    }
  }
}
