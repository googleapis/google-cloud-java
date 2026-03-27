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

package com.google.cloud.spanner.connection;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest.AbortInterceptor;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest.ITConnection;
import com.google.cloud.spanner.connection.it.ITTransactionRetryTest.CountTransactionRetryListener;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ExecuteSqlRequest.QueryMode;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbortedTest extends AbstractMockServerTest {

  @Test
  public void testCommitAborted() {
    // Do two iterations to ensure that each iteration gets its own transaction, and that each
    // transaction is the most recent transaction of that session.
    for (int i = 0; i < 2; i++) {
      mockSpanner.putStatementResult(
          StatementResult.query(SELECT_COUNT_STATEMENT, SELECT_COUNT_RESULTSET_BEFORE_INSERT));
      mockSpanner.putStatementResult(StatementResult.update(INSERT_STATEMENT, UPDATE_COUNT));
      AbortInterceptor interceptor = new AbortInterceptor(0);
      try (ITConnection connection =
          createConnection(interceptor, new CountTransactionRetryListener())) {
        interceptor.setUsingMultiplexedSession(
            isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
        // verify that the there is no test record
        try (ResultSet rs =
            connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
          assertThat(rs.next(), is(true));
          assertThat(rs.getLong("C"), is(equalTo(0L)));
          assertThat(rs.next(), is(false));
        }
        // do an insert
        connection.executeUpdate(
            Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted')"));
        // indicate that the next statement should abort
        interceptor.setProbability(1.0);
        interceptor.setOnlyInjectOnce(true);
        // do a commit that will first abort, and then on retry will succeed
        connection.commit();
        mockSpanner.putStatementResult(
            StatementResult.query(SELECT_COUNT_STATEMENT, SELECT_COUNT_RESULTSET_AFTER_INSERT));
        // verify that the insert succeeded
        try (ResultSet rs =
            connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
          assertThat(rs.next(), is(true));
          assertThat(rs.getLong("C"), is(equalTo(1L)));
          assertThat(rs.next(), is(false));
        }
      }
    }
  }

  @Test
  public void testCommitAbortedDuringUpdateWithReturning() {
    // Do two iterations to ensure that each iteration gets its own transaction, and that each
    // transaction is the most recent transaction of that session.
    for (int i = 0; i < 2; i++) {
      mockSpanner.putStatementResult(
          StatementResult.query(SELECT_COUNT_STATEMENT, SELECT_COUNT_RESULTSET_BEFORE_INSERT));
      mockSpanner.putStatementResult(
          StatementResult.updateReturning(INSERT_RETURNING_STATEMENT, UPDATE_RETURNING_RESULTSET));
      AbortInterceptor interceptor = new AbortInterceptor(0);
      try (ITConnection connection =
          createConnection(interceptor, new CountTransactionRetryListener())) {
        interceptor.setUsingMultiplexedSession(
            isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
        // verify that the there is no test record
        try (ResultSet rs =
            connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
          assertThat(rs.next(), is(true));
          assertThat(rs.getLong("C"), is(equalTo(0L)));
          assertThat(rs.next(), is(false));
        }
        // do an insert with returning
        connection.executeQuery(
            Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted') THEN RETURN *"));
        // indicate that the next statement should abort
        interceptor.setProbability(1.0);
        interceptor.setOnlyInjectOnce(true);
        // do a commit that will first abort, and then on retry will succeed
        connection.commit();
        mockSpanner.putStatementResult(
            StatementResult.query(SELECT_COUNT_STATEMENT, SELECT_COUNT_RESULTSET_AFTER_INSERT));
        // verify that the insert succeeded
        try (ResultSet rs =
            connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
          assertThat(rs.next(), is(true));
          assertThat(rs.getLong("C"), is(equalTo(1L)));
          assertThat(rs.next(), is(false));
        }
      }
    }
  }

  @Test
  public void testAbortedDuringRetryOfFailedQuery() {
    final Statement invalidStatement = Statement.of("SELECT * FROM FOO");
    StatusRuntimeException notFound =
        Status.NOT_FOUND.withDescription("Table not found").asRuntimeException();
    mockSpanner.putStatementResult(StatementResult.exception(invalidStatement, notFound));
    try (ITConnection connection =
        createConnection(createAbortFirstRetryListener(invalidStatement, notFound))) {
      connection.execute(INSERT_STATEMENT);
      try (ResultSet rs = connection.executeQuery(invalidStatement)) {
        fail("missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
      }
      // Force an abort and retry.
      mockSpanner.abortNextStatement();
      connection.commit();
    }
    assertThat(mockSpanner.countRequestsOfType(CommitRequest.class)).isEqualTo(2);
    // The transaction will be executed 3 times, which means that there will be 6
    // ExecuteSqlRequests:
    // 1. The initial attempt.
    // 2. The first retry attempt. This will fail on the invalid statement as it is aborted.
    // 3. the second retry attempt. This will succeed.
    assertThat(mockSpanner.countRequestsOfType(ExecuteSqlRequest.class)).isEqualTo(6);
  }

  @Test
  public void testAbortedDuringRetryOfFailedUpdate() {
    final Statement invalidStatement = Statement.of("INSERT INTO FOO");
    StatusRuntimeException notFound =
        Status.NOT_FOUND.withDescription("Table not found").asRuntimeException();
    mockSpanner.putStatementResult(StatementResult.exception(invalidStatement, notFound));
    try (ITConnection connection =
        createConnection(createAbortFirstRetryListener(invalidStatement, notFound))) {
      connection.execute(INSERT_STATEMENT);
      try {
        connection.execute(invalidStatement);
        fail("missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
      }
      // Force an abort and retry.
      mockSpanner.abortNextStatement();
      connection.commit();
    }
    assertThat(mockSpanner.countRequestsOfType(CommitRequest.class)).isEqualTo(2);
    // The transaction will be executed 3 times, which means that there will be 6
    // ExecuteSqlRequests:
    // 1. The initial attempt.
    // 2. The first retry attempt. This will fail on the invalid statement as it is aborted.
    // 3. the second retry attempt. This will succeed.
    assertThat(mockSpanner.countRequestsOfType(ExecuteSqlRequest.class)).isEqualTo(6);
  }

  @Test
  public void testAbortedDuringRetryOfFailedUpdateWithReturning() {
    final Statement invalidStatement = Statement.of("INSERT INTO FOO THEN RETURN *");
    StatusRuntimeException notFound =
        Status.NOT_FOUND.withDescription("Table not found").asRuntimeException();
    mockSpanner.putStatementResult(StatementResult.exception(invalidStatement, notFound));
    try (ITConnection connection =
        createConnection(createAbortFirstRetryListener(invalidStatement, notFound))) {
      connection.execute(INSERT_STATEMENT);
      try {
        connection.execute(invalidStatement);
        fail("missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
      }
      // Force an abort and retry.
      mockSpanner.abortNextStatement();
      connection.commit();
    }
    assertThat(mockSpanner.countRequestsOfType(CommitRequest.class)).isEqualTo(2);
    // The transaction will be executed 3 times, which means that there will be 6
    // ExecuteSqlRequests:
    // 1. The initial attempt.
    // 2. The first retry attempt. This will fail on the invalid statement as it is aborted.
    // 3. the second retry attempt. This will succeed.
    assertThat(mockSpanner.countRequestsOfType(ExecuteSqlRequest.class)).isEqualTo(6);
  }

  @Test
  public void testAbortedDuringRetryOfFailedBatchUpdate() {
    final Statement invalidStatement = Statement.of("INSERT INTO FOO");
    StatusRuntimeException notFound =
        Status.NOT_FOUND.withDescription("Table not found").asRuntimeException();
    mockSpanner.putStatementResult(StatementResult.exception(invalidStatement, notFound));
    try (ITConnection connection =
        createConnection(createAbortFirstRetryListener(invalidStatement, notFound))) {
      connection.execute(INSERT_STATEMENT);
      try {
        connection.executeBatchUpdate(Collections.singletonList(invalidStatement));
        fail("missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
      }
      // Force an abort and retry.
      mockSpanner.abortNextStatement();
      connection.commit();
    }
    assertThat(mockSpanner.countRequestsOfType(CommitRequest.class)).isEqualTo(2);
    assertThat(mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class)).isEqualTo(3);
  }

  @Test
  public void testAbortedDuringRetryOfFailedBatchUpdateWithReturning() {
    final Statement invalidStatement = Statement.of("INSERT INTO FOO THEN RETURN *");
    StatusRuntimeException notFound =
        Status.NOT_FOUND.withDescription("Table not found").asRuntimeException();
    mockSpanner.putStatementResult(StatementResult.exception(invalidStatement, notFound));
    try (ITConnection connection =
        createConnection(createAbortFirstRetryListener(invalidStatement, notFound))) {
      connection.execute(INSERT_STATEMENT);
      try {
        connection.executeBatchUpdate(Collections.singletonList(invalidStatement));
        fail("missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
      }
      // Force an abort and retry.
      mockSpanner.abortNextStatement();
      connection.commit();
    }
    assertThat(mockSpanner.countRequestsOfType(CommitRequest.class)).isEqualTo(2);
    assertThat(mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class)).isEqualTo(3);
  }

  @Test
  public void testAbortedDuringRetryOfFailedQueryAsFirstStatement() {
    final Statement invalidStatement = Statement.of("SELECT * FROM FOO");
    StatusRuntimeException notFound =
        Status.NOT_FOUND.withDescription("Table not found").asRuntimeException();
    mockSpanner.putStatementResult(StatementResult.exception(invalidStatement, notFound));
    // Abort the invalid statement on the third retry (listener counts from 0). The first retry will
    // be triggered by the client library because the first statement of the transaction failed.
    // That means that it also failed to return a transaction, and the first retry is only executed
    // in order to execute an explicit BeginTransaction RPC:

    // 1: First statement fails => Retry because no transaction was returned
    // 2: BeginTransaction + Invalid statement + Insert + Commit (aborted) => Retry
    // 3: First statement fails => Retry because no transaction was returned
    // 4: BeginTransaction + Invalid statement (aborted) => Retry
    // 5: First statement fails => Retry because no transaction was returned
    // 6: BeginTransaction + Invalid statement + Insert + Commit => Success

    try (ITConnection connection =
        createConnection(createAbortRetryListener(2, invalidStatement, notFound))) {
      try (ResultSet rs = connection.executeQuery(invalidStatement)) {
        fail("missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
      }
      connection.executeUpdate(INSERT_STATEMENT);
      // Force an abort and retry.
      mockSpanner.abortNextStatement();
      connection.commit();
    }
    assertThat(mockSpanner.countRequestsOfType(CommitRequest.class)).isEqualTo(2);
    // 6 times invalid query + 2 times INSERT.
    assertThat(mockSpanner.countRequestsOfType(ExecuteSqlRequest.class)).isEqualTo(8);
  }

  @Test
  public void testAbortedDuringRetryOfFailedUpdateAsFirstStatement() {
    final Statement invalidStatement = Statement.of("INSERT INTO FOO");
    StatusRuntimeException notFound =
        Status.NOT_FOUND.withDescription("Table not found").asRuntimeException();
    mockSpanner.putStatementResult(StatementResult.exception(invalidStatement, notFound));
    try (ITConnection connection =
        createConnection(createAbortRetryListener(2, invalidStatement, notFound))) {
      try {
        connection.execute(invalidStatement);
        fail("missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
      }
      connection.execute(INSERT_STATEMENT);
      // Force an abort and retry.
      mockSpanner.abortNextStatement();
      connection.commit();
    }
    assertThat(mockSpanner.countRequestsOfType(CommitRequest.class)).isEqualTo(2);
    assertThat(mockSpanner.countRequestsOfType(ExecuteSqlRequest.class)).isEqualTo(8);
  }

  @Test
  public void testAbortedDuringRetryOfFailedUpdateWithReturningAsFirstStatement() {
    final Statement invalidStatement = Statement.of("INSERT INTO FOO THEN RETURN *");
    StatusRuntimeException notFound =
        Status.NOT_FOUND.withDescription("Table not found").asRuntimeException();
    mockSpanner.putStatementResult(StatementResult.exception(invalidStatement, notFound));
    try (ITConnection connection =
        createConnection(createAbortRetryListener(2, invalidStatement, notFound))) {
      try {
        connection.execute(invalidStatement);
        fail("missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
      }
      connection.execute(INSERT_STATEMENT);
      // Force an abort and retry.
      mockSpanner.abortNextStatement();
      connection.commit();
    }
    assertThat(mockSpanner.countRequestsOfType(CommitRequest.class)).isEqualTo(2);
    assertThat(mockSpanner.countRequestsOfType(ExecuteSqlRequest.class)).isEqualTo(8);
  }

  @Test
  public void testAbortedDuringRetryOfFailedBatchUpdateAsFirstStatement() {
    final Statement invalidStatement = Statement.of("INSERT INTO FOO");
    StatusRuntimeException notFound =
        Status.NOT_FOUND.withDescription("Table not found").asRuntimeException();
    mockSpanner.putStatementResult(StatementResult.exception(invalidStatement, notFound));
    try (ITConnection connection =
        createConnection(createAbortFirstRetryListener(invalidStatement, notFound))) {
      try {
        connection.executeBatchUpdate(Collections.singletonList(invalidStatement));
        fail("missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
      }
      connection.execute(INSERT_STATEMENT);
      // Force an abort and retry.
      mockSpanner.abortNextStatement();
      connection.commit();
    }
    assertThat(mockSpanner.countRequestsOfType(CommitRequest.class)).isEqualTo(2);
    assertThat(mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class)).isEqualTo(6);
  }

  @Test
  public void testAbortedDuringRetryOfFailedBatchUpdateWithReturningAsFirstStatement() {
    final Statement invalidStatement = Statement.of("INSERT INTO FOO THEN RETURN *");
    StatusRuntimeException notFound =
        Status.NOT_FOUND.withDescription("Table not found").asRuntimeException();
    mockSpanner.putStatementResult(StatementResult.exception(invalidStatement, notFound));
    try (ITConnection connection =
        createConnection(createAbortFirstRetryListener(invalidStatement, notFound))) {
      try {
        connection.executeBatchUpdate(Collections.singletonList(invalidStatement));
        fail("missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
      }
      connection.execute(INSERT_STATEMENT);
      // Force an abort and retry.
      mockSpanner.abortNextStatement();
      connection.commit();
    }
    assertThat(mockSpanner.countRequestsOfType(CommitRequest.class)).isEqualTo(2);
    assertThat(mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class)).isEqualTo(6);
  }

  @Test
  public void testRetryUsesTags() {
    mockSpanner.putStatementResult(
        StatementResult.query(SELECT_COUNT_STATEMENT, SELECT_COUNT_RESULTSET_BEFORE_INSERT));
    mockSpanner.putStatementResult(StatementResult.update(INSERT_STATEMENT, UPDATE_COUNT));
    try (ITConnection connection = createConnection()) {
      connection.setTransactionTag("transaction-tag");
      connection.setStatementTag("statement-tag");
      connection.executeUpdate(INSERT_STATEMENT);
      connection.setStatementTag("statement-tag");
      connection.executeBatchUpdate(Collections.singleton(INSERT_STATEMENT));
      connection.setStatementTag("statement-tag");
      connection.executeQuery(SELECT_COUNT_STATEMENT);

      mockSpanner.abortNextStatement();
      connection.commit();
    }
    long executeSqlRequestCount =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
            .filter(
                request ->
                    request.getRequestOptions().getRequestTag().equals("statement-tag")
                        && request
                            .getRequestOptions()
                            .getTransactionTag()
                            .equals("transaction-tag"))
            .count();
    assertEquals(4L, executeSqlRequestCount);

    long executeBatchSqlRequestCount =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).stream()
            .filter(
                request ->
                    request.getRequestOptions().getRequestTag().equals("statement-tag")
                        && request
                            .getRequestOptions()
                            .getTransactionTag()
                            .equals("transaction-tag"))
            .count();
    assertEquals(2L, executeBatchSqlRequestCount);

    long commitRequestCount =
        mockSpanner.getRequestsOfType(CommitRequest.class).stream()
            .filter(
                request ->
                    request.getRequestOptions().getRequestTag().equals("")
                        && request
                            .getRequestOptions()
                            .getTransactionTag()
                            .equals("transaction-tag"))
            .count();
    assertEquals(2L, commitRequestCount);
  }

  @Test
  public void testRetryUsesTagsWithUpdateReturning() {
    mockSpanner.putStatementResult(
        StatementResult.query(SELECT_COUNT_STATEMENT, SELECT_COUNT_RESULTSET_BEFORE_INSERT));
    mockSpanner.putStatementResult(StatementResult.update(INSERT_STATEMENT, UPDATE_COUNT));
    mockSpanner.putStatementResult(
        StatementResult.updateReturning(INSERT_RETURNING_STATEMENT, UPDATE_RETURNING_RESULTSET));
    try (ITConnection connection = createConnection()) {
      connection.setTransactionTag("transaction-tag");
      connection.setStatementTag("statement-tag");
      connection.executeUpdate(INSERT_STATEMENT);
      connection.setStatementTag("statement-tag");
      connection.executeBatchUpdate(ImmutableList.of(INSERT_STATEMENT, INSERT_RETURNING_STATEMENT));
      connection.setStatementTag("statement-tag");
      connection.executeQuery(SELECT_COUNT_STATEMENT);
      connection.setStatementTag("statement-tag");
      connection.executeQuery(INSERT_RETURNING_STATEMENT);

      mockSpanner.abortNextStatement();
      connection.commit();
    }
    long executeSqlRequestCount =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
            .filter(
                request ->
                    request.getRequestOptions().getRequestTag().equals("statement-tag")
                        && request
                            .getRequestOptions()
                            .getTransactionTag()
                            .equals("transaction-tag"))
            .count();
    assertEquals(6L, executeSqlRequestCount);

    long executeBatchSqlRequestCount =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).stream()
            .filter(
                request ->
                    request.getRequestOptions().getRequestTag().equals("statement-tag")
                        && request
                            .getRequestOptions()
                            .getTransactionTag()
                            .equals("transaction-tag"))
            .count();
    assertEquals(2L, executeBatchSqlRequestCount);

    long commitRequestCount =
        mockSpanner.getRequestsOfType(CommitRequest.class).stream()
            .filter(
                request ->
                    request.getRequestOptions().getRequestTag().equals("")
                        && request
                            .getRequestOptions()
                            .getTransactionTag()
                            .equals("transaction-tag"))
            .count();
    assertEquals(2L, commitRequestCount);
  }

  @Test
  public void testRetryUsesAnalyzeModeForUpdate() {
    mockSpanner.putStatementResult(
        StatementResult.query(SELECT_COUNT_STATEMENT, SELECT_COUNT_RESULTSET_BEFORE_INSERT));
    mockSpanner.putStatementResult(StatementResult.update(INSERT_STATEMENT, 0));
    try (ITConnection connection = createConnection()) {
      assertEquals(
          0L, connection.analyzeUpdate(INSERT_STATEMENT, QueryAnalyzeMode.PLAN).getRowCountExact());

      mockSpanner.abortNextStatement();
      connection.executeQuery(SELECT_COUNT_STATEMENT);

      mockSpanner.putStatementResult(StatementResult.update(INSERT_STATEMENT, 1));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));

      connection.commit();
    }
    // 5 requests because:
    // 1. Analyze INSERT
    // 2. Execute SELECT COUNT(*) (Aborted)
    // 3. Analyze INSERT (retry)
    // 4. Execute SELECT COUNT(*) (retry)
    // 5. Execute INSERT
    assertEquals(5, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(QueryMode.PLAN, requests.get(0).getQueryMode());
    assertEquals(QueryMode.NORMAL, requests.get(1).getQueryMode());

    // This used NORMAL because of https://github.com/googleapis/java-spanner/issues/2009.
    assertEquals(QueryMode.PLAN, requests.get(2).getQueryMode());

    assertEquals(QueryMode.NORMAL, requests.get(3).getQueryMode());
    assertEquals(QueryMode.NORMAL, requests.get(4).getQueryMode());
  }

  @Test
  public void testAbortedWithBitReversedSequence() {
    // A bit-reversed sequence can only be used in a read/write transaction. However, calling
    // get_next_sequence_value will update the sequence durably, even if the transaction is aborted.
    // That means that retrying a transaction that called get_next_sequence_value will always fail.
    String getSequenceValuesSql =
        "WITH t AS (\n"
            + "\tselect get_next_sequence_value(sequence enhanced_sequence) AS n\n"
            + "\tUNION ALL\n"
            + "\tselect get_next_sequence_value(sequence enhanced_sequence) AS n\n"
            + "\tUNION ALL\n"
            + "\tselect get_next_sequence_value(sequence enhanced_sequence) AS n\n"
            + "\tUNION ALL\n"
            + "\tselect get_next_sequence_value(sequence enhanced_sequence) AS n\n"
            + "\tUNION ALL\n"
            + "\tselect get_next_sequence_value(sequence enhanced_sequence) AS n\n"
            + ")\n"
            + "SELECT n FROM t";
    mockSpanner.putStatementResult(
        StatementResult.queryAndThen(
            Statement.of(getSequenceValuesSql),
            createBitReversedSequenceResultSet(1L, 5L),
            createBitReversedSequenceResultSet(6L, 10L)));
    long currentValue = 0L;
    try (ITConnection connection = createConnection()) {
      try (ResultSet resultSet = connection.executeQuery(Statement.of(getSequenceValuesSql))) {
        while (resultSet.next()) {
          assertEquals(Long.reverse(++currentValue), resultSet.getLong(0));
        }
      }
      mockSpanner.abortNextStatement();
      // The retry should fail, because the sequence will return new values during the retry.
      assertThrows(AbortedDueToConcurrentModificationException.class, connection::commit);
    }
  }

  @Test
  public void testTimeoutWithRetries() {
    // Verifies that even though a single execution of a statement does not exceed the deadline,
    // repeated retries of the statement does cause the deadline to be exceeded.
    try (ITConnection connection = createConnection()) {
      for (boolean autoCommit : new boolean[] {true, false}) {
        connection.setAutocommit(autoCommit);
        mockSpanner.setAbortProbability(1.0);
        mockSpanner.setExecuteSqlExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(1, 0));

        connection.setStatementTimeout(10, TimeUnit.MILLISECONDS);
        SpannerException exception =
            assertThrows(SpannerException.class, () -> connection.execute(INSERT_STATEMENT));
        assertEquals(ErrorCode.DEADLINE_EXCEEDED, exception.getErrorCode());
        if (!autoCommit) {
          connection.rollback();
        }
      }
    } finally {
      mockSpanner.setAbortProbability(0.0);
    }
  }

  static com.google.spanner.v1.ResultSet createBitReversedSequenceResultSet(
      long startValue, long endValue) {
    return com.google.spanner.v1.ResultSet.newBuilder()
        .setMetadata(
            ResultSetMetadata.newBuilder()
                .setRowType(
                    StructType.newBuilder()
                        .addFields(
                            Field.newBuilder()
                                .setName("n")
                                .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                .build())
                        .build())
                .build())
        .addAllRows(
            LongStream.range(startValue, endValue)
                .map(Long::reverse)
                .mapToObj(
                    id ->
                        ListValue.newBuilder()
                            .addValues(
                                Value.newBuilder().setStringValue(String.valueOf(id)).build())
                            .build())
                .collect(Collectors.toList()))
        .build();
  }

  ITConnection createConnection(TransactionRetryListener listener) {
    ITConnection connection =
        super.createConnection(ImmutableList.of(), ImmutableList.of(listener));
    connection.setAutocommit(false);
    return connection;
  }

  /** Creates a retry listener that will abort the first retry as well. */
  TransactionRetryListener createAbortFirstRetryListener(
      final Statement invalidStatement, final StatusRuntimeException statementException) {
    return createAbortRetryListener(0, invalidStatement, statementException);
  }

  /** Creates a retry listener that will abort the n'th retry. */
  TransactionRetryListener createAbortRetryListener(
      final int onAttempt,
      final Statement invalidStatement,
      final StatusRuntimeException statementException) {
    return new TransactionRetryListener() {
      @Override
      public void retryStarting(
          Timestamp transactionStarted, long transactionId, int retryAttempt) {
        if (retryAttempt == onAttempt) {
          mockSpanner.putStatementResult(
              StatementResult.exception(
                  invalidStatement,
                  mockSpanner.createAbortedException(ByteString.copyFromUtf8("some-transaction"))));
        } else {
          mockSpanner.putStatementResult(
              StatementResult.exception(invalidStatement, statementException));
        }
      }

      @Override
      public void retryFinished(
          Timestamp transactionStarted, long transactionId, int retryAttempt, RetryResult result) {}
    };
  }
}
