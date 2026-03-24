/*
 * Copyright 2017 Google LLC
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionManager;
import com.google.cloud.spanner.TransactionManager.TransactionState;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.testing.EmulatorSpannerHelper;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITTransactionManagerTest {

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static DatabaseClient client;
  private static DatabaseClient googleStandardSQLClient;
  private static DatabaseClient postgreSQLClient;

  @Parameterized.Parameters(name = "Dialect = {0}")
  public static List<DialectTestParameter> data() {
    List<DialectTestParameter> params = new ArrayList<>();
    params.add(new DialectTestParameter(Dialect.GOOGLE_STANDARD_SQL));
    if (!EmulatorSpannerHelper.isUsingEmulator()) {
      params.add(new DialectTestParameter(Dialect.POSTGRESQL));
    }
    return params;
  }

  @Parameterized.Parameter() public DialectTestParameter dialect;

  @BeforeClass
  public static void setUpDatabase()
      throws ExecutionException, InterruptedException, TimeoutException {

    Database googleStandardSQLDatabase =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE T ("
                    + "  K                   STRING(MAX) NOT NULL,"
                    + "  BoolValue           BOOL,"
                    + ") PRIMARY KEY (K)");
    googleStandardSQLClient = env.getTestHelper().getDatabaseClient(googleStandardSQLDatabase);
    if (!EmulatorSpannerHelper.isUsingEmulator()) {
      Database postgreSQLDatabase =
          env.getTestHelper()
              .createTestDatabase(
                  Dialect.POSTGRESQL,
                  Collections.singletonList(
                      "CREATE TABLE T ("
                          + "  K        VARCHAR PRIMARY KEY,"
                          + "  BoolValue BOOL"
                          + ")"));
      postgreSQLClient = env.getTestHelper().getDatabaseClient(postgreSQLDatabase);
    }
  }

  @Before
  public void before() {
    client =
        dialect.dialect == Dialect.GOOGLE_STANDARD_SQL ? googleStandardSQLClient : postgreSQLClient;
    // Delete all test data
    client.write(ImmutableList.of(Mutation.delete("T", KeySet.all())));
  }

  @AfterClass
  public static void teardown() {
    ConnectionOptions.closeSpanner();
  }

  @SuppressWarnings("resource")
  @Test
  public void simpleInsert() throws InterruptedException {
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      while (true) {
        assertThat(manager.getState()).isEqualTo(TransactionState.STARTED);
        txn.buffer(
            Mutation.newInsertBuilder("T").set("K").to("Key1").set("BoolValue").to(true).build());
        try {
          manager.commit();
          assertThat(manager.getState()).isEqualTo(TransactionState.COMMITTED);
          Struct row =
              client.singleUse().readRow("T", Key.of("Key1"), Arrays.asList("K", "BoolValue"));
          assertThat(row.getString(0)).isEqualTo("Key1");
          assertThat(row.getBoolean(1)).isTrue();
          break;
        } catch (AbortedException e) {
          long retryDelayInMillis = e.getRetryDelayInMillis();
          if (retryDelayInMillis > 0) {
            Thread.sleep(retryDelayInMillis);
          }
          txn = manager.resetForRetry();
        }
      }
    }
  }

  @SuppressWarnings("resource")
  @Test
  public void invalidInsert() throws InterruptedException {
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      while (true) {
        txn.buffer(
            Mutation.newInsertBuilder("InvalidTable")
                .set("K")
                .to("Key1")
                .set("BoolValue")
                .to(true)
                .build());
        try {
          manager.commit();
          fail("Expected exception");
        } catch (AbortedException e) {
          long retryDelayInMillis = e.getRetryDelayInMillis();
          if (retryDelayInMillis > 0) {
            Thread.sleep(retryDelayInMillis);
          }
          txn = manager.resetForRetry();
        } catch (SpannerException e) {
          // expected
          break;
        }
      }
      assertThat(manager.getState()).isEqualTo(TransactionState.COMMIT_FAILED);
      // We cannot retry for non aborted errors.
      try {
        manager.resetForRetry();
        fail("Expected exception");
      } catch (IllegalStateException ex) {
        assertNotNull(ex.getMessage());
      }
    }
  }

  @SuppressWarnings("resource")
  @Test
  public void rollback() throws InterruptedException {
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      while (true) {
        txn.buffer(
            Mutation.newInsertBuilder("T").set("K").to("Key2").set("BoolValue").to(true).build());
        try {
          manager.rollback();
          break;
        } catch (AbortedException e) {
          long retryDelayInMillis = e.getRetryDelayInMillis();
          if (retryDelayInMillis > 0) {
            Thread.sleep(retryDelayInMillis);
          }
          txn = manager.resetForRetry();
        }
      }
      assertThat(manager.getState()).isEqualTo(TransactionState.ROLLED_BACK);
      // Row should not have been inserted.
      assertThat(client.singleUse().readRow("T", Key.of("Key2"), Arrays.asList("K", "BoolValue")))
          .isNull();
    }
  }

  @SuppressWarnings("resource")
  @Test
  public void abortAndRetry() throws InterruptedException {
    assumeFalse(
        "Emulator does not support more than 1 simultaneous transaction. "
            + "This test would therefore loop indefinitely on the emulator.",
        isUsingEmulator());

    client.write(
        Collections.singletonList(
            Mutation.newInsertBuilder("T").set("K").to("Key3").set("BoolValue").to(true).build()));
    try (TransactionManager manager1 = client.transactionManager()) {
      TransactionContext txn1 = manager1.begin();
      TransactionManager manager2;
      TransactionContext txn2;
      while (true) {
        try {
          txn1.readRow("T", Key.of("Key3"), Arrays.asList("K", "BoolValue"));
          manager2 = client.transactionManager();
          txn2 = manager2.begin();
          txn2.readRow("T", Key.of("Key3"), Arrays.asList("K", "BoolValue"));

          txn1.buffer(
              Mutation.newUpdateBuilder("T")
                  .set("K")
                  .to("Key3")
                  .set("BoolValue")
                  .to(false)
                  .build());
          manager1.commit();
          break;
        } catch (AbortedException e) {
          long retryDelayInMillis = e.getRetryDelayInMillis();
          if (retryDelayInMillis > 0) {
            Thread.sleep(retryDelayInMillis);
          }
          // It is possible that it was txn2 that aborted.
          // In that case we should just retry without resetting anything.
          if (manager1.getState() == TransactionState.ABORTED) {
            txn1 = manager1.resetForRetry();
          }
        }
      }

      // txn2 should have been aborted.
      try {
        manager2.commit();
        fail("Expected to abort");
      } catch (AbortedException e) {
        assertThat(manager2.getState()).isEqualTo(TransactionState.ABORTED);
        txn2 = manager2.resetForRetry();
      }
      txn2.buffer(
          Mutation.newUpdateBuilder("T").set("K").to("Key3").set("BoolValue").to(true).build());
      manager2.commit();
      Struct row = client.singleUse().readRow("T", Key.of("Key3"), Arrays.asList("K", "BoolValue"));
      assertThat(row.getString(0)).isEqualTo("Key3");
      assertThat(row.getBoolean(1)).isTrue();
      manager2.close();
    }
  }

  @SuppressWarnings("resource")
  @Test
  public void testTransactionManagerReturnsCommitStats() throws InterruptedException {
    assumeFalse("Emulator does not return commit statistics", isUsingEmulator());
    try (TransactionManager manager = client.transactionManager(Options.commitStats())) {
      TransactionContext transaction = manager.begin();
      while (true) {
        transaction.buffer(
            Mutation.newInsertBuilder("T")
                .set("K")
                .to("KeyCommitStats")
                .set("BoolValue")
                .to(true)
                .build());
        try {
          manager.commit();
          assertNotNull(manager.getCommitResponse().getCommitStats());
          assertEquals(2L, manager.getCommitResponse().getCommitStats().getMutationCount());
          break;
        } catch (AbortedException e) {
          long retryDelayInMillis = e.getRetryDelayInMillis();
          if (retryDelayInMillis > 0) {
            Thread.sleep(retryDelayInMillis);
          }
          transaction = manager.resetForRetry();
        }
      }
    }
  }
}
