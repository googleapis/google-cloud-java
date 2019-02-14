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
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeyRange;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionRunner;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import java.util.Arrays;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for DML. */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public final class ITDMLTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static Database db;
  private static DatabaseClient client;
  /** Sequence for assigning unique keys to test cases. */
  private static int seq;

  private static final String INSERT_DML =
      "INSERT INTO T (k, v) VALUES ('boo1', 1), ('boo2', 2), ('boo3', 3), ('boo4', 4);";
  private static final String UPDATE_DML = "UPDATE T SET T.V = 100 WHERE T.K LIKE 'boo%';";
  private static final String DELETE_DML = "DELETE FROM T WHERE T.K like 'boo%';";
  private static final long DML_COUNT = 4;

  private static boolean throwAbortOnce = false;

  @BeforeClass
  public static void setUpDatabase() {
    db =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE T ("
                    + "  K    STRING(MAX) NOT NULL,"
                    + "  V    INT64,"
                    + ") PRIMARY KEY (K)");
    client = env.getTestHelper().getDatabaseClient(db);
  }

  private static String uniqueKey() {
    return "k" + seq++;
  }

  private void executeUpdate(long expectedCount, final String... stmts) {
    final TransactionCallable<Long> callable =
        new TransactionCallable<Long>() {
          @Override
          public Long run(TransactionContext transaction) {
            long rowCount = 0;
            for (String stmt : stmts) {
              if (throwAbortOnce) {
                throwAbortOnce = false;
                throw SpannerExceptionFactory.newSpannerException(
                    ErrorCode.ABORTED, "Abort in test");
              }

              rowCount += transaction.executeUpdate(Statement.of(stmt));
            }
            return rowCount;
          }
        };
    TransactionRunner runner = client.readWriteTransaction();
    Long rowCount = runner.run(callable);
    assertThat(rowCount).isEqualTo(expectedCount);
  }

  @Test
  public void abortOnceShouldSucceedAfterRetry() {
    try {
      throwAbortOnce = true;
      executeUpdate(DML_COUNT, INSERT_DML);
      assertThat(throwAbortOnce).isFalse();
    } catch (AbortedException e) {
      fail("Abort Exception not caught and retried");
    }
  }

  @Test
  public void partitionedDML() {
    executeUpdate(DML_COUNT, INSERT_DML);
    assertThat(
            client
                .singleUse(TimestampBound.strong())
                .readRow("T", Key.of("boo1"), Arrays.asList("V"))
                .getLong(0))
        .isEqualTo(1);

    long rowCount = client.executePartitionedUpdate(Statement.of(UPDATE_DML));
    // Note: With PDML there is a possibility of network replay or partial update to occur, causing
    // this assert to fail. We should remove this assert if it is a recurring failure in IT tests.
    assertThat(rowCount).isEqualTo(DML_COUNT);
    assertThat(
            client
                .singleUse(TimestampBound.strong())
                .readRow("T", Key.of("boo1"), Arrays.asList("V"))
                .getLong(0))
        .isEqualTo(100);

    rowCount = client.executePartitionedUpdate(Statement.of(DELETE_DML));
    assertThat(rowCount).isEqualTo(DML_COUNT);
    assertThat(
            client
                .singleUse(TimestampBound.strong())
                .readRow("T", Key.of("boo1"), Arrays.asList("V")))
        .isNull();
  }

  @Test
  public void standardDML() {
    executeUpdate(DML_COUNT, INSERT_DML);
    assertThat(
            client
                .singleUse(TimestampBound.strong())
                .readRow("T", Key.of("boo1"), Arrays.asList("V"))
                .getLong(0))
        .isEqualTo(1);
    executeUpdate(DML_COUNT, UPDATE_DML);
    assertThat(
            client
                .singleUse(TimestampBound.strong())
                .readRow("T", Key.of("boo1"), Arrays.asList("V"))
                .getLong(0))
        .isEqualTo(100);
    executeUpdate(DML_COUNT, DELETE_DML);
    assertThat(
            client
                .singleUse(TimestampBound.strong())
                .readRow("T", Key.of("boo1"), Arrays.asList("V")))
        .isNull();
  }

  @Test
  public void standardDMLWithError() {
    try {
      executeUpdate(0, "SELECT * FROM T;");
      fail("Expected illegal argument exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.UNKNOWN);
      assertThat(e.getMessage())
          .contains("DML response missing stats possibly due to non-DML statement as input");
      assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class);
    }
  }

  @Test
  public void standardDMLWithDuplicates() {
    executeUpdate(DML_COUNT, INSERT_DML);

    executeUpdate(
        4,
        "UPDATE T SET v = 200 WHERE k = 'boo1';",
        "UPDATE T SET v = 300 WHERE k = 'boo1';",
        "UPDATE T SET v = 400 WHERE k = 'boo1';",
        "UPDATE T SET v = 500 WHERE k = 'boo1';");
    assertThat(
            client
                .singleUse(TimestampBound.strong())
                .readRow("T", Key.of("boo1"), Arrays.asList("V"))
                .getLong(0))
        .isEqualTo(500);

    executeUpdate(DML_COUNT, DELETE_DML, DELETE_DML);
  }

  @Test
  public void standardDMLReadYourWrites() {
    executeUpdate(DML_COUNT, INSERT_DML);

    final TransactionCallable<Void> callable =
        new TransactionCallable<Void>() {
          @Override
          public Void run(TransactionContext transaction) {
            long rowCount =
                transaction.executeUpdate(Statement.of("UPDATE T SET v = v * 2 WHERE k = 'boo2';"));
            assertThat(rowCount).isEqualTo(1);
            assertThat(transaction.readRow("T", Key.of("boo2"), Arrays.asList("v")).getLong(0))
                .isEqualTo(2 * 2);
            return null;
          }
        };
    TransactionRunner runner = client.readWriteTransaction();
    runner.run(callable);

    executeUpdate(DML_COUNT, DELETE_DML);
  }

  @Test
  public void standardDMLRollback() {
    class UserException extends Exception {
      UserException(String message) {
        super(message);
      }
    }
    final TransactionCallable<Void> callable =
        new TransactionCallable<Void>() {
          @Override
          public Void run(TransactionContext transaction) throws UserException {
            long rowCount = transaction.executeUpdate(Statement.of(INSERT_DML));
            assertThat(rowCount).isEqualTo(DML_COUNT);
            throw new UserException("failing to commit");
          }
        };

    try {
      TransactionRunner runner = client.readWriteTransaction();
      runner.run(callable);
      fail("Expected user exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.UNKNOWN);
      assertThat(e.getMessage()).contains("failing to commit");
      assertThat(e.getCause()).isInstanceOf(UserException.class);
    }

    ResultSet resultSet =
        client
            .singleUse(TimestampBound.strong())
            .read("T", KeySet.range(KeyRange.prefix(Key.of("boo"))), Arrays.asList("K"));
    assertThat(resultSet.next()).isFalse();
  }

  @Test
  public void standardDMLAndMutations() {
    final String key1 = uniqueKey();
    final String key2 = uniqueKey();
    final TransactionCallable<Void> callable =
        new TransactionCallable<Void>() {
          @Override
          public Void run(TransactionContext transaction) {
            // DML
            long rowCount =
                transaction.executeUpdate(
                    Statement.of("INSERT INTO T (k, v) VALUES ('" + key1 + "', 1)"));
            assertThat(rowCount).isEqualTo(1);

            // Mutations
            transaction.buffer(
                Mutation.newInsertOrUpdateBuilder("T").set("K").to(key2).set("V").to(2).build());
            return null;
          }
        };
    TransactionRunner runner = client.readWriteTransaction();
    runner.run(callable);

    KeySet.Builder keys = KeySet.newBuilder();
    keys.addKey(Key.of(key1)).addKey(Key.of(key2));
    ResultSet resultSet =
        client.singleUse(TimestampBound.strong()).read("T", keys.build(), Arrays.asList("K"));
    int rowCount = 0;
    while (resultSet.next()) {
      rowCount++;
    }
    assertThat(rowCount).isEqualTo(2);
  }

  private void executeQuery(long expectedCount, final String... stmts) {
    final TransactionCallable<Long> callable =
        new TransactionCallable<Long>() {
          @Override
          public Long run(TransactionContext transaction) {
            long rowCount = 0;
            for (final String stmt : stmts) {
              ResultSet resultSet = transaction.executeQuery(Statement.of(stmt));
              assertThat(resultSet.next()).isFalse();
              assertThat(resultSet.getStats()).isNotNull();
              rowCount += resultSet.getStats().getRowCountExact();
            }
            return rowCount;
          }
        };
    TransactionRunner runner = client.readWriteTransaction();
    Long rowCount = runner.run(callable);
    assertThat(rowCount).isEqualTo(expectedCount);
  }

  @Test
  public void standardDMLWithExecuteSQL() {
    executeQuery(DML_COUNT, INSERT_DML);
    // checks for multi-stmts within a txn, therefore also verifying seqNo.
    executeQuery(DML_COUNT * 2, UPDATE_DML, DELETE_DML);
  }
}
