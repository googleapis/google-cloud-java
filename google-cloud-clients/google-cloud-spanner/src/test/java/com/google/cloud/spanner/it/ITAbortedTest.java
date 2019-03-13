/*
 * Copyright 2019 Google LLC
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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.AbortedTransactionInjector;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionManager;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Uses an {@link AbortedTransactionInjector} to simulate aborted transaction and the handling of
 * this.
 */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITAbortedTest {

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static Database db;
  @Rule public ExpectedException expectedException = ExpectedException.none();
  private static DatabaseClient client;

  @BeforeClass
  public static void setUpDatabase() {
    // Empty database.
    db =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE T ("
                    + "  K                   STRING(MAX) NOT NULL,"
                    + "  BoolValue           BOOL"
                    + ") PRIMARY KEY (K)");
    client = env.getTestHelper().getDatabaseClient(db);
    client
        .readWriteTransaction()
        .run(
            new TransactionCallable<Void>() {
              @Override
              public Void run(TransactionContext transaction) throws Exception {
                transaction.buffer(
                    Mutation.newInsertBuilder("T")
                        .set("K")
                        .to("TEST")
                        .set("BoolValue")
                        .to(false)
                        .build());
                return null;
              }
            });
  }

  private AbortedTransactionInjector getInjector() {
    return env.getTestHelper().getOptions().getAbortedInjector();
  }

  @Test
  public void testAbortOnQuery() throws FileNotFoundException, IOException {
    client
        .readWriteTransaction()
        .run(
            new TransactionCallable<Void>() {
              private boolean first = true;

              @Override
              public Void run(TransactionContext transaction) throws Exception {
                boolean wasFirst = first;
                if (first) {
                  // This will cause the query to abort.
                  getInjector().injectAbortOnce();
                  first = false;
                }
                try (ResultSet rs = transaction.executeQuery(Statement.of("SELECT * FROM T"))) {
                  if (wasFirst) {
                    fail("Missing aborted exception");
                  }
                  while (rs.next()) {
                    // Do nothing with the results.
                  }
                }
                // Verify that the transaction was retried.
                assertThat(wasFirst, is(false));
                return null;
              }
            });
  }

  @Test
  public void testAbortOnNext() throws FileNotFoundException, IOException {
    client
        .readWriteTransaction()
        .run(
            new TransactionCallable<Void>() {
              private boolean first = true;

              @Override
              public Void run(TransactionContext transaction) throws Exception {
                boolean wasFirst = first;
                try (ResultSet rs = transaction.executeQuery(Statement.of("SELECT * FROM T"))) {
                  if (first) {
                    // This will cause the ResultSet#next() call to abort.
                    getInjector().injectAbortOnce();
                    first = false;
                  }
                  while (rs.next()) {
                    // Do nothing with the results.
                  }
                  if (wasFirst) {
                    fail("Missing aborted exception");
                  }
                }
                // Verify that the transaction was retried.
                assertThat(wasFirst, is(false));
                return null;
              }
            });
  }

  @Test
  public void testAbortOnUpdate() throws FileNotFoundException, IOException {
    client
        .readWriteTransaction()
        .run(
            new TransactionCallable<Void>() {
              private boolean first = true;

              @Override
              public Void run(TransactionContext transaction) throws Exception {
                boolean wasFirst = first;
                if (first) {
                  // This will cause the update to abort.
                  getInjector().injectAbortOnce();
                  first = false;
                }
                transaction.executeUpdate(
                    Statement.of("UPDATE T SET BoolValue=TRUE WHERE K='TEST'"));
                if (wasFirst) {
                  fail("Missing aborted exception");
                }
                // Verify that the transaction was retried.
                assertThat(wasFirst, is(false));
                return null;
              }
            });
  }

  @Test
  public void testAbortOnBatchUpdate() throws FileNotFoundException, IOException {
    client
        .readWriteTransaction()
        .run(
            new TransactionCallable<Void>() {
              private boolean first = true;

              @Override
              public Void run(TransactionContext transaction) throws Exception {
                boolean wasFirst = first;
                if (first) {
                  // This will cause the update to abort.
                  getInjector().injectAbortOnce();
                  first = false;
                }
                transaction.batchUpdate(
                    Arrays.asList(
                        Statement.of("UPDATE T SET BoolValue=TRUE WHERE K='TEST'"),
                        Statement.of("UPDATE T SET BoolValue=FALSE WHERE K='FOO'")));
                if (wasFirst) {
                  fail("Missing aborted exception");
                }
                // Verify that the transaction was retried.
                assertThat(wasFirst, is(false));
                return null;
              }
            });
  }

  /** Use an instance variable to keep track of the retry count when the commit is aborted. */
  private int runCount;

  @Test
  public void testAbortOnCommit() throws FileNotFoundException, IOException {
    runCount = 0;
    client
        .readWriteTransaction()
        .run(
            new TransactionCallable<Void>() {
              private boolean first = true;

              @Override
              public Void run(TransactionContext transaction) throws Exception {
                runCount++;
                transaction.executeUpdate(
                    Statement.of("UPDATE T SET BoolValue=TRUE WHERE K='TEST'"));
                if (first) {
                  // This will cause the commit to abort.
                  getInjector().injectAbortOnce();
                  first = false;
                }
                return null;
              }
            });
    assertThat(runCount > 1, is(true));
  }

  @SuppressWarnings("resource")
  @Test
  public void testAbortOnQueryWithTransactionManager()
      throws FileNotFoundException, IOException, InterruptedException {
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      boolean first = true;
      while (true) {
        boolean wasFirst = first;
        try {
          if (first) {
            getInjector().injectAbortOnce();
            first = false;
          }
          try (ResultSet rs = txn.executeQuery(Statement.of("SELECT * FROM T"))) {
            if (wasFirst) {
              fail("Missing aborted exception");
            }
            while (rs.next()) {
              // Do nothing with the results.
            }
          }
          manager.commit();
          // Verify that the transaction was retried.
          assertThat(wasFirst, is(false));
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          txn = manager.resetForRetry();
        }
      }
    }
  }

  @SuppressWarnings("resource")
  @Test
  public void testAbortOnNextWithTransactionManager()
      throws FileNotFoundException, IOException, InterruptedException {
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      boolean first = true;
      while (true) {
        boolean wasFirst = first;
        try {
          try (ResultSet rs = txn.executeQuery(Statement.of("SELECT * FROM T"))) {
            if (first) {
              getInjector().injectAbortOnce();
              first = false;
            }
            while (rs.next()) {
              if (wasFirst) {
                fail("Missing aborted exception");
              }
              // Do nothing with the results.
            }
          }
          manager.commit();
          // Verify that the transaction was retried.
          assertThat(wasFirst, is(false));
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          txn = manager.resetForRetry();
        }
      }
    }
  }

  @SuppressWarnings("resource")
  @Test
  public void testAbortOnUpdateWithTransactionManager()
      throws FileNotFoundException, IOException, InterruptedException {
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      boolean first = true;
      while (true) {
        boolean wasFirst = first;
        try {
          if (first) {
            getInjector().injectAbortOnce();
            first = false;
          }
          txn.executeUpdate(Statement.of("UPDATE T SET BoolValue=TRUE WHERE K='TEST'"));
          if (wasFirst) {
            fail("Missing aborted exception");
          }
          manager.commit();
          // Verify that the transaction was retried.
          assertThat(wasFirst, is(false));
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          txn = manager.resetForRetry();
        }
      }
    }
  }

  @SuppressWarnings("resource")
  @Test
  public void testAbortOnBatchUpdateWithTransactionManager()
      throws FileNotFoundException, IOException, InterruptedException {
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      boolean first = true;
      while (true) {
        boolean wasFirst = first;
        try {
          if (first) {
            getInjector().injectAbortOnce();
            first = false;
          }
          txn.batchUpdate(
              Arrays.asList(
                  Statement.of("UPDATE T SET BoolValue=TRUE WHERE K='TEST'"),
                  Statement.of("UPDATE T SET BoolValue=FALSE WHERE K='FOO'")));
          if (wasFirst) {
            fail("Missing aborted exception");
          }
          manager.commit();
          // Verify that the transaction was retried.
          assertThat(wasFirst, is(false));
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          txn = manager.resetForRetry();
        }
      }
    }
  }

  @SuppressWarnings("resource")
  @Test
  public void testAbortOnCommitWithTransactionManager()
      throws FileNotFoundException, IOException, InterruptedException {
    try (TransactionManager manager = client.transactionManager()) {
      TransactionContext txn = manager.begin();
      boolean first = true;
      while (true) {
        boolean wasFirst = first;
        try {
          txn.batchUpdate(
              Arrays.asList(
                  Statement.of("UPDATE T SET BoolValue=TRUE WHERE K='TEST'"),
                  Statement.of("UPDATE T SET BoolValue=FALSE WHERE K='FOO'")));
          if (first) {
            getInjector().injectAbortOnce();
            first = false;
          }
          manager.commit();
          if (wasFirst) {
            fail("Missing aborted exception");
          }
          // Verify that the transaction was retried.
          assertThat(wasFirst, is(false));
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          txn = manager.resetForRetry();
        }
      }
    }
  }
}
