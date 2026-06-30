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

package com.google.cloud.spanner.connection;

import static com.google.cloud.spanner.connection.ConnectionProperties.DEFAULT_ISOLATION_LEVEL;
import static com.google.cloud.spanner.connection.ConnectionProperties.READ_LOCK_MODE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest.ITConnection;
import com.google.cloud.spanner.connection.StatementResult.ResultType;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;
import io.grpc.Deadline.Ticker;
import io.grpc.Status;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TransactionMockServerTest extends AbstractMockServerTest {

  @Parameter(0)
  public IsolationLevel isolationLevel;

  @Parameter(1)
  public ReadLockMode readLockMode;

  @Parameters(name = "isolationLevel = {0}, readLockMode = {1}")
  public static Collection<Object[]> data() {
    List<Object[]> result = new ArrayList<>();
    for (IsolationLevel isolationLevel : DEFAULT_ISOLATION_LEVEL.getValidValues()) {
      for (ReadLockMode readLockMode : READ_LOCK_MODE.getValidValues()) {
        result.add(new Object[] {isolationLevel, readLockMode});
      }
    }
    return result;
  }

  @Override
  protected ITConnection createConnection() {
    return createConnection(
        Collections.emptyList(),
        Collections.emptyList(),
        String.format(
            ";default_isolation_level=%s;read_lock_mode=%s", isolationLevel, readLockMode));
  }

  @Test
  public void testQuery() {
    try (Connection connection = createConnection()) {
      //noinspection EmptyTryBlock
      try (ResultSet ignore = connection.executeQuery(SELECT1_STATEMENT)) {}
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertEquals(isolationLevel, request.getTransaction().getBegin().getIsolationLevel());
    assertEquals(
        readLockMode, request.getTransaction().getBegin().getReadWrite().getReadLockMode());
    assertFalse(request.getLastStatement());
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testDml() {
    try (Connection connection = createConnection()) {
      connection.executeUpdate(INSERT_STATEMENT);
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertEquals(isolationLevel, request.getTransaction().getBegin().getIsolationLevel());
    assertEquals(
        readLockMode, request.getTransaction().getBegin().getReadWrite().getReadLockMode());
    assertFalse(request.getLastStatement());
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testFailedFirstDml() {
    Statement invalidInsert = Statement.of("insert into my_table (id, name) values (1, 'test')");
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.exception(
            invalidInsert,
            Status.ALREADY_EXISTS.withDescription("Row 1 already exists").asRuntimeException()));

    try (Connection connection = createConnection()) {
      SpannerException exception =
          assertThrows(SpannerException.class, () -> connection.executeUpdate(invalidInsert));
      assertEquals(ErrorCode.ALREADY_EXISTS, exception.getErrorCode());
      connection.commit();
    }
    // The transaction should be internally retried with an explicit BeginTransaction request, as
    // the first statement in the transaction failed.
    assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testFailedFirstAndLastDml() {
    Statement invalidInsert =
        Statement.of("insert into my_table (id, name) values (1, 'test') then return id");
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.exception(
            invalidInsert,
            Status.ALREADY_EXISTS.withDescription("Row 1 already exists").asRuntimeException()));

    try (Connection connection = createConnection()) {
      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () -> connection.executeQuery(invalidInsert, Options.lastStatement()));
      assertEquals(ErrorCode.ALREADY_EXISTS, exception.getErrorCode());

      // The same error should be repeated for the commit.
      exception = assertThrows(SpannerException.class, connection::commit);
      assertEquals(ErrorCode.ALREADY_EXISTS, exception.getErrorCode());
    }
    // The transaction should be not be retried, as the last_statement flag was set.
    assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    // There is no CommitRequest, because the statement never returned a transaction ID.
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testDmlReturning() {
    try (Connection connection = createConnection()) {
      //noinspection EmptyTryBlock
      try (ResultSet ignore = connection.executeQuery(INSERT_RETURNING_STATEMENT)) {}
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertEquals(isolationLevel, request.getTransaction().getBegin().getIsolationLevel());
    assertEquals(
        readLockMode, request.getTransaction().getBegin().getReadWrite().getReadLockMode());
    assertFalse(request.getLastStatement());
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testBatchDml() {
    try (Connection connection = createConnection()) {
      connection.startBatchDml();
      connection.executeUpdate(INSERT_STATEMENT);
      connection.executeUpdate(INSERT_STATEMENT);
      connection.runBatch();
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertEquals(isolationLevel, request.getTransaction().getBegin().getIsolationLevel());
    assertEquals(
        readLockMode, request.getTransaction().getBegin().getReadWrite().getReadLockMode());
    assertFalse(request.getLastStatements());
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testBeginTransactionIsolationLevel() {
    SpannerPool.closeSpannerPool();
    for (Dialect dialect : new Dialect[] {Dialect.POSTGRESQL, Dialect.GOOGLE_STANDARD_SQL}) {
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.detectDialectResult(dialect));

      try (Connection connection = super.createConnection()) {
        for (IsolationLevel isolationLevel :
            new IsolationLevel[] {IsolationLevel.REPEATABLE_READ, IsolationLevel.SERIALIZABLE}) {
          for (ReadLockMode readLockMode :
              new ReadLockMode[] {ReadLockMode.PESSIMISTIC, ReadLockMode.OPTIMISTIC}) {
            for (boolean useSql : new boolean[] {true, false}) {
              if (useSql) {
                connection.execute(
                    Statement.of(
                        "begin transaction isolation level "
                            + isolationLevel.name().replace("_", " ")));
              } else {
                connection.beginTransaction(isolationLevel);
              }
              if (dialect == Dialect.POSTGRESQL) {
                connection.execute(
                    Statement.of("set spanner.read_lock_mode = '" + readLockMode.name() + "'"));
              } else {
                connection.execute(
                    Statement.of("set read_lock_mode = '" + readLockMode.name() + "'"));
              }
              connection.executeUpdate(INSERT_STATEMENT);
              connection.commit();

              assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
              ExecuteSqlRequest request =
                  mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
              assertTrue(request.getTransaction().hasBegin());
              assertTrue(request.getTransaction().getBegin().hasReadWrite());
              assertEquals(isolationLevel, request.getTransaction().getBegin().getIsolationLevel());
              assertEquals(
                  readLockMode,
                  request.getTransaction().getBegin().getReadWrite().getReadLockMode());
              assertFalse(request.getLastStatement());
              assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));

              mockSpanner.clearRequests();
            }
          }
        }
      }
      SpannerPool.closeSpannerPool();
    }
  }

  @Test
  public void testSetTransactionIsolationLevel() {
    SpannerPool.closeSpannerPool();
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.detectDialectResult(Dialect.POSTGRESQL));

    try (Connection connection = super.createConnection()) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);

        for (IsolationLevel isolationLevel :
            new IsolationLevel[] {IsolationLevel.REPEATABLE_READ, IsolationLevel.SERIALIZABLE}) {
          for (ReadLockMode readLockMode :
              new ReadLockMode[] {ReadLockMode.OPTIMISTIC, ReadLockMode.PESSIMISTIC}) {
            // Manually start a transaction if autocommit is enabled.
            if (autocommit) {
              connection.execute(Statement.of("begin"));
            }
            connection.execute(
                Statement.of(
                    "set transaction isolation level " + isolationLevel.name().replace("_", " ")));
            connection.execute(
                Statement.of("set spanner.read_lock_mode = '" + readLockMode.name() + "'"));
            connection.executeUpdate(INSERT_STATEMENT);
            connection.commit();

            assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
            ExecuteSqlRequest request =
                mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
            assertTrue(request.getTransaction().hasBegin());
            assertTrue(request.getTransaction().getBegin().hasReadWrite());
            assertEquals(isolationLevel, request.getTransaction().getBegin().getIsolationLevel());
            assertEquals(
                readLockMode, request.getTransaction().getBegin().getReadWrite().getReadLockMode());
            assertFalse(request.getLastStatement());
            assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));

            mockSpanner.clearRequests();
          }
        }
      }
    }
    SpannerPool.closeSpannerPool();
  }

  @Test
  public void testTransactionTimeout() {
    // Use a fake ticker to be able to advance the clock without having to sleep for X ms.
    AtomicLong nanos = new AtomicLong();
    Ticker ticker =
        new Ticker() {
          @Override
          public long nanoTime() {
            return nanos.get();
          }
        };
    ConnectionOptions options =
        ConnectionOptions.newBuilder().setUri(getBaseUrl()).setTicker(ticker).build();

    try (Connection connection = options.getConnection()) {
      // Set the transaction timeout to 500 milliseconds.
      connection.setTransactionTimeout(Duration.ofMillis(500));

      //noinspection EmptyTryBlock
      try (ResultSet ignore = connection.executeQuery(SELECT1_STATEMENT)) {}
      // Advance the time by 100ms.
      nanos.addAndGet(TimeUnit.MILLISECONDS.toNanos(100));
      // Execute another statement. This should still succeed.
      connection.execute(INSERT_STATEMENT);

      // Advance the time by 401ms. The deadline has now been exceeded and the commit should fail.
      nanos.addAndGet(TimeUnit.MILLISECONDS.toNanos(401));
      SpannerException exception = assertThrows(SpannerException.class, connection::commit);
      assertEquals(ErrorCode.DEADLINE_EXCEEDED, exception.getErrorCode());
    }
    // Verify that a transaction timeout does not apply to statements in auto-commit.
    // Create a connection without a fake ticker.
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      // Set the transaction timeout so low that it will always be exceeded.
      connection.setTransactionTimeout(Duration.ofNanos(1));

      // This statement should succeed, as it does not use a transaction.
      //noinspection EmptyTryBlock
      try (ResultSet ignore = connection.executeQuery(SELECT1_STATEMENT)) {}

      // This statement also succeeds, because it uses a read-only transaction.
      connection.setAutocommit(false);
      connection.setReadOnly(true);
      //noinspection EmptyTryBlock
      try (ResultSet ignore = connection.executeQuery(SELECT1_STATEMENT)) {}
      connection.commit();

      // This statement fails, because it uses a read/write transaction.
      connection.setReadOnly(false);
      SpannerException exception =
          assertThrows(SpannerException.class, () -> connection.executeQuery(SELECT1_STATEMENT));
      assertEquals(ErrorCode.DEADLINE_EXCEEDED, exception.getErrorCode());
    }
  }

  @Test
  public void testCanUseAllMethodsWithInternalRetriesDisabled() {
    // Verify that all query/update methods work as expected when internal retries have been
    // disabled.
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.setRetryAbortsInternally(false);

      try (ResultSet result = connection.executeQuery(SELECT1_STATEMENT)) {
        assertTrue(result.next());
        assertEquals(1L, result.getLong(0));
        assertFalse(result.next());
      }
      assertEquals(1, connection.executeUpdate(INSERT_STATEMENT));
      try (ResultSet result = connection.executeQuery(INSERT_RETURNING_STATEMENT)) {
        assertTrue(result.next());
        assertEquals(1L, result.getLong(0));
        assertFalse(result.next());
      }

      StatementResult statementResult = connection.execute(SELECT1_STATEMENT);
      assertEquals(ResultType.RESULT_SET, statementResult.getResultType());
      try (ResultSet result = statementResult.getResultSet()) {
        assertTrue(result.next());
        assertEquals(1L, result.getLong(0));
        assertFalse(result.next());
      }

      statementResult = connection.execute(INSERT_STATEMENT);
      assertEquals(ResultType.UPDATE_COUNT, statementResult.getResultType());
      assertEquals(1L, statementResult.getUpdateCount().longValue());

      statementResult = connection.execute(INSERT_RETURNING_STATEMENT);
      assertEquals(ResultType.RESULT_SET, statementResult.getResultType());
      try (ResultSet result = statementResult.getResultSet()) {
        assertTrue(result.next());
        assertEquals(1L, result.getLong(0));
        assertFalse(result.next());
      }
      connection.commit();
    }
  }
}
