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

package com.google.cloud.spanner.connection.it;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.AsyncResultSet;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.AsyncStatementResult;
import com.google.cloud.spanner.connection.Connection;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest;
import com.google.cloud.spanner.connection.StatementResult;
import com.google.cloud.spanner.connection.StatementResult.ResultType;
import com.google.cloud.spanner.connection.TransactionMode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/** Execute DML Returning statements using the generic connection API. */
@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITDmlReturningTest extends ITAbstractSpannerTest {
  private final ImmutableMap<Dialect, Statement> UPDATE_RETURNING_MAP =
      ImmutableMap.of(
          Dialect.GOOGLE_STANDARD_SQL,
          Statement.of("UPDATE Singers SET LastName = 'XYZ' WHERE FirstName = 'ABC' THEN RETURN *"),
          Dialect.POSTGRESQL,
          Statement.of("UPDATE Singers SET LastName = 'XYZ' WHERE FirstName = 'ABC' RETURNING *"));
  private final ImmutableMap<Dialect, String> DDL_MAP =
      ImmutableMap.of(
          Dialect.GOOGLE_STANDARD_SQL,
          "CREATE TABLE Singers ("
              + "  SingerId INT64,"
              + "  FirstName STRING(1024),"
              + "  LastName STRING(1024)"
              + ")  PRIMARY KEY(SingerId)",
          Dialect.POSTGRESQL,
          "CREATE TABLE Singers ("
              + "  SingerId BIGINT PRIMARY KEY,"
              + "  FirstName character varying(1024),"
              + "  LastName character varying(1024))");
  private static final Set<Dialect> IS_INITIALIZED = new HashSet<>();

  @Parameter public Dialect dialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  private boolean checkAndSetInitialized() {
    return !IS_INITIALIZED.add(dialect);
  }

  @Before
  public void setupTable() {
    if (!checkAndSetInitialized()) {
      database =
          env.getTestHelper()
              .createTestDatabase(dialect, Collections.singleton(DDL_MAP.get(dialect)));
    }
    DatabaseClient client = env.getTestHelper().getDatabaseClient(database);
    client.write(ImmutableList.of(Mutation.delete("SINGERS", KeySet.all())));

    List<String> firstNames = Arrays.asList("ABC", "ABC", "DEF", "PQR", "ABC");
    List<String> lastNames = Arrays.asList("XYZ", "DEF", "XYZ", "ABC", "GHI");
    List<Mutation> mutations = new ArrayList<>();
    for (int id = 1; id <= 5; id++) {
      mutations.add(
          Mutation.newInsertBuilder("SINGERS")
              .set("SINGERID")
              .to(id)
              .set("FIRSTNAME")
              .to(firstNames.get(id - 1))
              .set("LASTNAME")
              .to(lastNames.get(id - 1))
              .build());
    }
    env.getTestHelper().getDatabaseClient(database).write(mutations);
  }

  @Test
  public void testDmlReturningExecuteQuery() {
    try (Connection connection = createConnection()) {
      try (ResultSet rs = connection.executeQuery(UPDATE_RETURNING_MAP.get(dialect))) {
        assertEquals(rs.getColumnCount(), 3);
        assertTrue(rs.next());
        assertEquals(rs.getString(1), "ABC");
        assertTrue(rs.next());
        assertEquals(rs.getString(1), "ABC");
        assertTrue(rs.next());
        assertEquals(rs.getString(1), "ABC");
        assertFalse(rs.next());
        assertNotNull(rs.getStats());
        assertEquals(rs.getStats().getRowCountExact(), 3);
      }
    }
  }

  @Test
  public void testDmlReturningExecuteQueryAsync() {
    try (Connection connection = createConnection()) {
      try (AsyncResultSet rs = connection.executeQueryAsync(UPDATE_RETURNING_MAP.get(dialect))) {
        rs.setCallback(
            Executors.newSingleThreadExecutor(),
            resultSet -> {
              try {
                while (true) {
                  switch (resultSet.tryNext()) {
                    case OK:
                      assertEquals(resultSet.getColumnCount(), 3);
                      assertEquals(resultSet.getString(1), "ABC");
                      break;
                    case DONE:
                      assertNotNull(resultSet.getStats());
                      assertEquals(resultSet.getStats().getRowCountExact(), 3);
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
      }
    }
  }

  @Test
  public void testDmlReturningExecuteUpdate() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      SpannerException e =
          assertThrows(
              SpannerException.class,
              () -> connection.executeUpdate(UPDATE_RETURNING_MAP.get(dialect)));
      assertEquals(e.getErrorCode(), ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testDmlReturningExecuteUpdateAsync() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      SpannerException e =
          assertThrows(
              SpannerException.class,
              () -> connection.executeUpdateAsync(UPDATE_RETURNING_MAP.get(dialect)));
      assertEquals(e.getErrorCode(), ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testDmlReturningExecuteBatchUpdate() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      final Statement updateStmt = Preconditions.checkNotNull(UPDATE_RETURNING_MAP.get(dialect));
      long[] counts =
          connection.executeBatchUpdate(ImmutableList.of(updateStmt, updateStmt, updateStmt));
      assertArrayEquals(counts, new long[] {3, 3, 3});
    }
  }

  @Test
  public void testDmlReturningExecuteBatchUpdateAsync() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      final Statement updateStmt = Preconditions.checkNotNull(UPDATE_RETURNING_MAP.get(dialect));
      long[] counts =
          connection
              .executeBatchUpdateAsync(ImmutableList.of(updateStmt, updateStmt, updateStmt))
              .get();
      assertArrayEquals(counts, new long[] {3, 3, 3});
    } catch (ExecutionException | InterruptedException e) {
      // ignore
    }
  }

  @Test
  public void testDmlReturningExecute() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      StatementResult res = connection.execute(UPDATE_RETURNING_MAP.get(dialect));
      assertEquals(res.getResultType(), ResultType.RESULT_SET);
      try (ResultSet rs = res.getResultSet()) {
        assertEquals(rs.getColumnCount(), 3);
        assertTrue(rs.next());
        assertEquals(rs.getString(1), "ABC");
        assertTrue(rs.next());
        assertEquals(rs.getString(1), "ABC");
        assertTrue(rs.next());
        assertEquals(rs.getString(1), "ABC");
        assertFalse(rs.next());
        assertNotNull(rs.getStats());
        assertEquals(rs.getStats().getRowCountExact(), 3);
      }
    }
  }

  @Test
  public void testDmlReturningExecuteAsync() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      AsyncStatementResult res = connection.executeAsync(UPDATE_RETURNING_MAP.get(dialect));
      assertEquals(res.getResultType(), ResultType.RESULT_SET);
      try (AsyncResultSet rs = res.getResultSetAsync()) {
        rs.setCallback(
            Executors.newSingleThreadExecutor(),
            resultSet -> {
              try {
                while (true) {
                  switch (resultSet.tryNext()) {
                    case OK:
                      assertEquals(resultSet.getColumnCount(), 3);
                      assertEquals(resultSet.getString(1), "ABC");
                      break;
                    case DONE:
                      assertNotNull(resultSet.getStats());
                      assertEquals(resultSet.getStats().getRowCountExact(), 3);
                      return CallbackResponse.DONE;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                    default:
                      throw new IllegalStateException();
                  }
                }
              } catch (SpannerException e) {
                System.out.printf("Error in callback: %s%n", e.getMessage());
                return CallbackResponse.DONE;
              }
            });
      }
    }
  }

  @Test
  public void testDmlReturningExecuteQueryReadOnlyMode() {
    try (Connection connection = createConnection()) {
      connection.setReadOnly(true);
      SpannerException e =
          assertThrows(
              SpannerException.class,
              () -> connection.executeQuery(UPDATE_RETURNING_MAP.get(dialect)));
      assertEquals(e.getErrorCode(), ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testDmlReturningExecuteQueryReadOnlyTransaction() {
    try (Connection connection = createConnection()) {
      connection.setReadOnly(false);
      connection.setAutocommit(false);
      connection.setTransactionMode(TransactionMode.READ_ONLY_TRANSACTION);
      SpannerException e =
          assertThrows(
              SpannerException.class,
              () -> connection.executeQuery(UPDATE_RETURNING_MAP.get(dialect)));
      assertEquals(e.getErrorCode(), ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testDmlReturningExecuteQueryAsyncReadOnlyMode() {
    try (Connection connection = createConnection()) {
      connection.setReadOnly(true);
      SpannerException e =
          assertThrows(
              SpannerException.class,
              () -> connection.executeQueryAsync(UPDATE_RETURNING_MAP.get(dialect)));
      assertEquals(e.getErrorCode(), ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testDmlReturningExecuteQueryAsyncReadOnlyTransaction() {
    try (Connection connection = createConnection()) {
      connection.setReadOnly(false);
      connection.setAutocommit(false);
      connection.setTransactionMode(TransactionMode.READ_ONLY_TRANSACTION);
      SpannerException e =
          assertThrows(
              SpannerException.class,
              () -> connection.executeQueryAsync(UPDATE_RETURNING_MAP.get(dialect)));
      assertEquals(e.getErrorCode(), ErrorCode.FAILED_PRECONDITION);
    }
  }
}
