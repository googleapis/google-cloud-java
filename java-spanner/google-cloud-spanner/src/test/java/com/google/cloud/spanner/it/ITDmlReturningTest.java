/*
 * Copyright 2022 Google LLC
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.spanner.AsyncResultSet;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TransactionRunner;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import com.google.cloud.spanner.connection.ConnectionOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/** Integration tests for DML Returning. */
@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public final class ITDmlReturningTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static DatabaseClient googleStandardSQLClient;
  private static DatabaseClient postgreSQLClient;

  /** Id prefix per test case. */
  private static int id;

  private static final long DML_COUNT = 4;

  @BeforeClass
  public static void setUpDatabase() {
    Database googleStandardSQLDatabase =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE T ("
                    + "  K    STRING(MAX) NOT NULL,"
                    + "  V    INT64,"
                    + ") PRIMARY KEY (K)");
    googleStandardSQLClient = env.getTestHelper().getDatabaseClient(googleStandardSQLDatabase);
    Database postgreSQLDatabase =
        env.getTestHelper()
            .createTestDatabase(
                Dialect.POSTGRESQL,
                Collections.singletonList(
                    "CREATE TABLE T ("
                        + "  \"K\"    VARCHAR PRIMARY KEY,"
                        + "  \"V\"    BIGINT"
                        + ")"));
    postgreSQLClient = env.getTestHelper().getDatabaseClient(postgreSQLDatabase);
  }

  @AfterClass
  public static void teardown() {
    ConnectionOptions.closeSpanner();
  }

  @Before
  public void increaseTestIdAndDeleteTestData() {
    if (dialect.dialect == Dialect.GOOGLE_STANDARD_SQL) {
      googleStandardSQLClient.writeAtLeastOnce(
          Collections.singletonList(Mutation.delete("T", KeySet.all())));
    } else {
      postgreSQLClient.writeAtLeastOnce(
          Collections.singletonList(Mutation.delete("T", KeySet.all())));
    }
    id++;
  }

  @Parameterized.Parameters(name = "Dialect = {0}")
  public static List<DialectTestParameter> data() {
    List<DialectTestParameter> params = new ArrayList<>();
    params.add(new DialectTestParameter(Dialect.GOOGLE_STANDARD_SQL));
    params.add(new DialectTestParameter(Dialect.POSTGRESQL));
    return params;
  }

  @Parameterized.Parameter(0)
  public DialectTestParameter dialect;

  private String getInsertDmlReturningTemplate() {
    if (dialect.dialect == Dialect.POSTGRESQL) {
      return "INSERT INTO T (\"K\", \"V\") VALUES ('%d-boo1', 1), ('%d-boo2', 2), ('%d-boo3', 3),"
          + " ('%d-boo4', 4) RETURNING *";
    }
    return "INSERT INTO T (K, V) VALUES ('%d-boo1', 1), ('%d-boo2', 2), ('%d-boo3', 3), ('%d-boo4',"
        + " 4) THEN RETURN *";
  }

  private String getUpdateDmlReturningTemplate() {
    if (dialect.dialect == Dialect.POSTGRESQL) {
      return "UPDATE T SET \"V\" = 100 WHERE \"K\" LIKE '%d-boo%%' RETURNING *";
    }
    return "UPDATE T SET V = 100 WHERE K LIKE '%d-boo%%' THEN RETURN *";
  }

  private String getDeleteDmlReturningTemplate() {
    if (dialect.dialect == Dialect.POSTGRESQL) {
      return "DELETE FROM T WHERE \"K\" like '%d-boo%%' RETURNING *";
    }
    return "DELETE FROM T WHERE K like '%d-boo%%' THEN RETURN *";
  }

  private String getDeleteDmlTemplate() {
    if (dialect.dialect == Dialect.POSTGRESQL) {
      return "DELETE FROM T WHERE \"K\" like '%d-boo%%'";
    }
    return "DELETE FROM T WHERE K like '%d-boo%%'";
  }

  private String insertDmlReturning() {
    return String.format(getInsertDmlReturningTemplate(), id, id, id, id);
  }

  private String updateDmlReturning() {
    return String.format(getUpdateDmlReturningTemplate(), id);
  }

  private String deleteDmlReturning() {
    return String.format(getDeleteDmlReturningTemplate(), id);
  }

  private String deleteDml() {
    return String.format(getDeleteDmlTemplate(), id);
  }

  private DatabaseClient getClient() {
    if (dialect.dialect == Dialect.POSTGRESQL) {
      return postgreSQLClient;
    }
    return googleStandardSQLClient;
  }

  @Test
  public void dmlReturningWithExecuteUpdate() {
    executeUpdate(DML_COUNT, insertDmlReturning());
    // checks for multi-stmts within a txn, therefore also verifying seqNo.
    executeUpdate(DML_COUNT * 2, updateDmlReturning(), deleteDmlReturning());
  }

  private void executeUpdate(long expectedCount, final String... stmts) {
    final TransactionCallable<Long> callable =
        transaction -> {
          long rowCount = 0;
          for (String stmt : stmts) {
            rowCount += transaction.executeUpdate(Statement.of(stmt));
          }
          return rowCount;
        };
    TransactionRunner runner = getClient().readWriteTransaction();
    Long rowCount = runner.run(callable);
    assertEquals((Long) expectedCount, rowCount);
  }

  @Test
  public void dmlReturningWithExecuteUpdateAsync() {
    executeUpdateAsync(DML_COUNT, insertDmlReturning());
    // checks for multi-stmts within a txn, therefore also verifying seqNo.
    executeUpdateAsync(DML_COUNT * 2, updateDmlReturning(), deleteDmlReturning());
  }

  private void executeUpdateAsync(long expectedCount, final String... stmts) {
    final TransactionCallable<Long> callable =
        transaction -> {
          long rowCount = 0;
          for (String stmt : stmts) {
            rowCount += transaction.executeUpdateAsync(Statement.of(stmt)).get(1, TimeUnit.MINUTES);
          }
          return rowCount;
        };
    TransactionRunner runner = getClient().readWriteTransaction();
    Long rowCount = runner.run(callable);
    assertEquals((Long) expectedCount, rowCount);
  }

  @Test
  public void dmlReturningWithExecutePartitionedUpdate() {
    assumeFalse(
        "The emulator does not dis-allow THEN RETURN statements for PDML", isUsingEmulator());

    SpannerException e =
        assertThrows(
            SpannerException.class,
            () -> getClient().executePartitionedUpdate(Statement.of(updateDmlReturning())));
    assertEquals(ErrorCode.UNIMPLEMENTED, e.getErrorCode());
  }

  @Test
  public void dmlReturningWithExecuteQuery() {
    List<Struct> rows = executeQuery(DML_COUNT, insertDmlReturning());
    assertEquals(
        1,
        getClient()
            .singleUse()
            .readRow("T", Key.of(String.format("%d-boo1", id)), Collections.singletonList("V"))
            .getLong(0));

    // Check if keys(K) and V have expected values.
    for (int idx = 0; idx < rows.size(); idx++) {
      assertEquals(idx + 1, rows.get(idx).getLong("V"));
      assertEquals(String.format("%d-boo%d", id, idx + 1), rows.get(idx).getString("K"));
    }
    rows = executeQuery(DML_COUNT, updateDmlReturning());
    assertEquals(
        100,
        getClient()
            .singleUse()
            .readRow("T", Key.of(String.format("%d-boo1", id)), Collections.singletonList("V"))
            .getLong(0));

    // Check if keys(K) and V have expected values.
    for (int idx = 0; idx < rows.size(); idx++) {
      assertEquals(100, rows.get(idx).getLong("V"));
      assertEquals(String.format("%d-boo%d", id, idx + 1), rows.get(idx).getString("K"));
    }
    rows = executeQuery(DML_COUNT, deleteDmlReturning());
    assertNull(
        getClient()
            .singleUse()
            .readRow("T", Key.of(String.format("%d-boo1", id)), Collections.singletonList("V")));

    // Check if keys(K) and V have expected values.
    for (int idx = 0; idx < rows.size(); idx++) {
      assertEquals(100, rows.get(idx).getLong("V"));
      assertEquals(String.format("%d-boo%d", id, idx + 1), rows.get(idx).getString("K"));
    }
  }

  private List<Struct> executeQuery(long expectedCount, String stmt) {
    List<Struct> rows = new ArrayList<>();
    final TransactionCallable<Void> callable =
        transaction -> {
          // Make sure we start with an empty list if the transaction is aborted and retried.
          rows.clear();
          ResultSet resultSet = transaction.executeQuery(Statement.of(stmt));
          // resultSet.next() returns false, when no more row exists.
          // So, number of times resultSet.next() returns true, is the number of rows
          // returned by the DML Returning statement.
          while (resultSet.next()) {
            rows.add(resultSet.getCurrentRowAsStruct());
          }
          assertFalse(resultSet.next());
          assertNotNull(resultSet.getStats());
          assertEquals(expectedCount, resultSet.getStats().getRowCountExact());
          return null;
        };
    TransactionRunner runner = getClient().readWriteTransaction();
    runner.run(callable);
    rows.sort(Comparator.comparing(a -> a.getString("K")));
    return rows;
  }

  @Test
  public void dmlReturningWithExecuteQueryAsync() {
    List<Struct> rows = executeQueryAsync(DML_COUNT, insertDmlReturning());
    assertEquals(
        1,
        getClient()
            .singleUse()
            .readRow("T", Key.of(String.format("%d-boo1", id)), Collections.singletonList("V"))
            .getLong(0));

    // Check if keys(K) and V have expected values.
    for (int idx = 0; idx < rows.size(); idx++) {
      assertEquals(idx + 1, rows.get(idx).getLong("V"));
      assertEquals(String.format("%d-boo%d", id, idx + 1), rows.get(idx).getString("K"));
    }
    rows = executeQueryAsync(DML_COUNT, updateDmlReturning());
    assertEquals(
        100,
        getClient()
            .singleUse()
            .readRow("T", Key.of(String.format("%d-boo1", id)), Collections.singletonList("V"))
            .getLong(0));

    // Check if keys(K) and V have expected values.
    for (int idx = 0; idx < rows.size(); idx++) {
      assertEquals(100, rows.get(idx).getLong("V"));
      assertEquals(String.format("%d-boo%d", id, idx + 1), rows.get(idx).getString("K"));
    }
    rows = executeQueryAsync(DML_COUNT, deleteDmlReturning());
    assertNull(
        getClient()
            .singleUse()
            .readRow("T", Key.of(String.format("%d-boo1", id)), Collections.singletonList("V")));

    // Check if keys(K) and V have expected values.
    for (int idx = 0; idx < rows.size(); idx++) {
      assertEquals(100, rows.get(idx).getLong("V"));
      assertEquals(String.format("%d-boo%d", id, idx + 1), rows.get(idx).getString("K"));
    }
  }

  private List<Struct> executeQueryAsync(long expectedCount, String stmt) {
    List<Struct> rows = new ArrayList<>();
    final TransactionCallable<Void> callable =
        transaction -> {
          rows.clear();
          AsyncResultSet rs = transaction.executeQueryAsync(Statement.of(stmt));
          rs.setCallback(
              Executors.newSingleThreadExecutor(),
              resultSet -> {
                try {
                  while (true) {
                    switch (resultSet.tryNext()) {
                      case OK:
                        rows.add(resultSet.getCurrentRowAsStruct());
                        break;
                      case DONE:
                        assertNotNull(resultSet.getStats());
                        assertEquals(resultSet.getStats().getRowCountExact(), expectedCount);
                        return CallbackResponse.DONE;
                      case NOT_READY:
                        return CallbackResponse.CONTINUE;
                      default:
                        throw new IllegalStateException();
                    }
                  }
                } catch (SpannerException e) {
                  return CallbackResponse.DONE;
                }
              });
          return null;
        };
    TransactionRunner runner = getClient().readWriteTransaction();
    runner.run(callable);
    rows.sort(Comparator.comparing(a -> a.getString("K")));
    return rows;
  }

  @Test
  public void dmlReturningWithBatchUpdate() {
    // Check if batchUpdate works well with a mix of Simple DML and DML Returning statements.
    long[] rowCounts = batchUpdate(insertDmlReturning(), updateDmlReturning(), deleteDml());
    assertEquals(3, rowCounts.length);
    assertEquals(DML_COUNT, rowCounts[0]);
    assertEquals(DML_COUNT, rowCounts[1]);
    assertEquals(DML_COUNT, rowCounts[2]);
  }

  private long[] batchUpdate(final String... stmts) {
    final TransactionCallable<long[]> callable =
        transaction ->
            transaction.batchUpdate(
                Arrays.stream(stmts).map(Statement::of).collect(Collectors.toList()));
    TransactionRunner runner = getClient().readWriteTransaction();
    return runner.run(callable);
  }

  @Test
  public void dmlReturningWithBatchUpdateAsync() {
    // Check if batchUpdateAsync works well with a mix of Simple DML and DML Returning statements.
    long[] rowCounts = batchUpdateAsync(insertDmlReturning(), updateDmlReturning(), deleteDml());
    assertEquals(3, rowCounts.length);
    assertEquals(DML_COUNT, rowCounts[0]);
    assertEquals(DML_COUNT, rowCounts[1]);
    assertEquals(DML_COUNT, rowCounts[2]);
  }

  private long[] batchUpdateAsync(final String... stmts) {
    final TransactionCallable<long[]> callable =
        transaction ->
            transaction
                .batchUpdateAsync(
                    Arrays.stream(stmts).map(Statement::of).collect(Collectors.toList()))
                .get();
    TransactionRunner runner = getClient().readWriteTransaction();
    return runner.run(callable);
  }
}
