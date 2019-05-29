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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionManager;
import com.google.cloud.spanner.TransactionManager.TransactionState;
import java.util.Arrays;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITTransactionManagerTest {

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
                    + "  BoolValue           BOOL,"
                    + ") PRIMARY KEY (K)");
    client = env.getTestHelper().getDatabaseClient(db);
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
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
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
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          txn = manager.resetForRetry();
        } catch (SpannerException e) {
          // expected
          break;
        }
      }
      assertThat(manager.getState()).isEqualTo(TransactionState.COMMIT_FAILED);
      // We cannot retry for non aborted errors.
      expectedException.expect(IllegalStateException.class);
      manager.resetForRetry();
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
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
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
    client.write(
        Arrays.asList(
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
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
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
    }
  }
}
