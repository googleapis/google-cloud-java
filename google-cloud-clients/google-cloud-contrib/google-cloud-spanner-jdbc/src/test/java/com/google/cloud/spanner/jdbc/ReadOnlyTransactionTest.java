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

package com.google.cloud.spanner.jdbc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.cloud.spanner.jdbc.StatementParser.StatementType;
import com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState;
import com.google.spanner.v1.ResultSetStats;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadOnlyTransactionTest {
  @Rule public ExpectedException exception = ExpectedException.none();

  private static final class SimpleReadOnlyTransaction
      implements com.google.cloud.spanner.ReadOnlyTransaction {
    private Timestamp readTimestamp = null;
    private final TimestampBound staleness;

    private SimpleReadOnlyTransaction(TimestampBound staleness) {
      this.staleness = staleness;
    }

    @Override
    public ResultSet read(
        String table, KeySet keys, Iterable<String> columns, ReadOption... options) {
      return null;
    }

    @Override
    public ResultSet readUsingIndex(
        String table, String index, KeySet keys, Iterable<String> columns, ReadOption... options) {
      return null;
    }

    @Override
    public Struct readRow(String table, Key key, Iterable<String> columns) {
      return null;
    }

    @Override
    public Struct readRowUsingIndex(String table, String index, Key key, Iterable<String> columns) {
      return null;
    }

    @Override
    public ResultSet executeQuery(Statement statement, QueryOption... options) {
      if (readTimestamp == null) {
        switch (staleness.getMode()) {
          case STRONG:
            readTimestamp = Timestamp.now();
            break;
          case READ_TIMESTAMP:
            readTimestamp = staleness.getReadTimestamp();
            break;
          case MIN_READ_TIMESTAMP:
            readTimestamp = staleness.getMinReadTimestamp();
            break;
          case EXACT_STALENESS:
            Calendar cal = Calendar.getInstance();
            cal.add(
                Calendar.MILLISECOND, (int) -staleness.getExactStaleness(TimeUnit.MILLISECONDS));
            readTimestamp = Timestamp.of(cal.getTime());
            break;
          case MAX_STALENESS:
            cal = Calendar.getInstance();
            cal.add(Calendar.MILLISECOND, (int) -staleness.getMaxStaleness(TimeUnit.MILLISECONDS));
            readTimestamp = Timestamp.of(cal.getTime());
            break;
          default:
            throw new IllegalStateException();
        }
      }
      return mock(ResultSet.class);
    }

    @Override
    public ResultSet analyzeQuery(Statement statement, QueryAnalyzeMode queryMode) {
      ResultSet res = executeQuery(statement);
      when(res.getStats()).thenReturn(ResultSetStats.getDefaultInstance());
      return res;
    }

    @Override
    public void close() {}

    @Override
    public Timestamp getReadTimestamp() {
      return readTimestamp;
    }
  }

  private ReadOnlyTransaction createSubject() {
    return createSubject(TimestampBound.strong());
  }

  private ReadOnlyTransaction createSubject(TimestampBound staleness) {
    DatabaseClient client = mock(DatabaseClient.class);
    when(client.readOnlyTransaction(staleness))
        .thenReturn(new SimpleReadOnlyTransaction(staleness));
    return ReadOnlyTransaction.newBuilder()
        .setDatabaseClient(client)
        .setReadOnlyStaleness(staleness)
        .withStatementExecutor(new StatementExecutor())
        .build();
  }

  @Test
  public void testExecuteDdl() {
    ParsedStatement ddl = mock(ParsedStatement.class);
    when(ddl.getType()).thenReturn(StatementType.DDL);
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    createSubject().executeDdl(ddl);
  }

  @Test
  public void testExecuteUpdate() {
    ParsedStatement update = mock(ParsedStatement.class);
    when(update.getType()).thenReturn(StatementType.UPDATE);
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    createSubject().executeUpdate(update);
  }

  @Test
  public void testWrite() {
    Mutation mutation = Mutation.newInsertBuilder("foo").build();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    createSubject().write(mutation);
  }

  @Test
  public void testWriteIterable() {
    Mutation mutation = Mutation.newInsertBuilder("foo").build();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    createSubject().write(Arrays.asList(mutation, mutation));
  }

  @Test
  public void testRunBatch() {
    ReadOnlyTransaction subject = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    subject.runBatch();
  }

  @Test
  public void testAbortBatch() {
    ReadOnlyTransaction subject = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    subject.abortBatch();
  }

  @Test
  public void testGetCommitTimestamp() {
    ReadOnlyTransaction transaction = createSubject();
    transaction.commit();
    assertThat(transaction.getState(), is(UnitOfWorkState.COMMITTED));
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    transaction.getCommitTimestamp();
  }

  @Test
  public void testIsReadOnly() {
    assertThat(createSubject().isReadOnly(), is(true));
  }

  @Test
  public void testExecuteQuery() {
    for (TimestampBound staleness : getTestTimestampBounds()) {
      ParsedStatement parsedStatement = mock(ParsedStatement.class);
      when(parsedStatement.getType()).thenReturn(StatementType.QUERY);
      when(parsedStatement.isQuery()).thenReturn(true);
      Statement statement = Statement.of("SELECT * FROM FOO");
      when(parsedStatement.getStatement()).thenReturn(statement);
      when(parsedStatement.getSqlWithoutComments()).thenReturn(statement.getSql());

      ReadOnlyTransaction transaction = createSubject(staleness);
      ResultSet rs = transaction.executeQuery(parsedStatement, AnalyzeMode.NONE);
      assertThat(rs, is(notNullValue()));
      assertThat(rs.getStats(), is(nullValue()));
    }
  }

  @Test
  public void testExecuteQueryWithOptionsTest() {
    String sql = "SELECT * FROM FOO";
    QueryOption option = Options.prefetchChunks(10000);
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    when(parsedStatement.getType()).thenReturn(StatementType.QUERY);
    when(parsedStatement.isQuery()).thenReturn(true);
    Statement statement = Statement.of(sql);
    when(parsedStatement.getStatement()).thenReturn(statement);
    when(parsedStatement.getSqlWithoutComments()).thenReturn(statement.getSql());
    DatabaseClient client = mock(DatabaseClient.class);
    com.google.cloud.spanner.ReadOnlyTransaction tx =
        mock(com.google.cloud.spanner.ReadOnlyTransaction.class);
    ResultSet resWithOptions = mock(ResultSet.class);
    ResultSet resWithoutOptions = mock(ResultSet.class);
    when(tx.executeQuery(Statement.of(sql), option)).thenReturn(resWithOptions);
    when(tx.executeQuery(Statement.of(sql))).thenReturn(resWithoutOptions);
    when(client.readOnlyTransaction(TimestampBound.strong())).thenReturn(tx);

    ReadOnlyTransaction transaction =
        ReadOnlyTransaction.newBuilder()
            .setDatabaseClient(client)
            .setReadOnlyStaleness(TimestampBound.strong())
            .withStatementExecutor(new StatementExecutor())
            .build();
    ResultSet expectedWithOptions = DirectExecuteResultSet.ofResultSet(resWithOptions);
    assertThat(
        transaction.executeQuery(parsedStatement, AnalyzeMode.NONE, option),
        is(equalTo(expectedWithOptions)));
    ResultSet expectedWithoutOptions = DirectExecuteResultSet.ofResultSet(resWithoutOptions);
    assertThat(
        transaction.executeQuery(parsedStatement, AnalyzeMode.NONE),
        is(equalTo(expectedWithoutOptions)));
  }

  @Test
  public void testPlanQuery() {
    for (TimestampBound staleness : getTestTimestampBounds()) {
      ParsedStatement parsedStatement = mock(ParsedStatement.class);
      when(parsedStatement.getType()).thenReturn(StatementType.QUERY);
      when(parsedStatement.isQuery()).thenReturn(true);
      Statement statement = Statement.of("SELECT * FROM FOO");
      when(parsedStatement.getStatement()).thenReturn(statement);
      when(parsedStatement.getSqlWithoutComments()).thenReturn(statement.getSql());

      ReadOnlyTransaction transaction = createSubject(staleness);
      ResultSet rs = transaction.executeQuery(parsedStatement, AnalyzeMode.PLAN);
      assertThat(rs, is(notNullValue()));
      // get all results and then get the stats
      while (rs.next()) {
        // do nothing
      }
      assertThat(rs.getStats(), is(notNullValue()));
    }
  }

  @Test
  public void testProfileQuery() {
    for (TimestampBound staleness : getTestTimestampBounds()) {
      ParsedStatement parsedStatement = mock(ParsedStatement.class);
      when(parsedStatement.getType()).thenReturn(StatementType.QUERY);
      when(parsedStatement.isQuery()).thenReturn(true);
      Statement statement = Statement.of("SELECT * FROM FOO");
      when(parsedStatement.getStatement()).thenReturn(statement);
      when(parsedStatement.getSqlWithoutComments()).thenReturn(statement.getSql());

      ReadOnlyTransaction transaction = createSubject(staleness);
      ResultSet rs = transaction.executeQuery(parsedStatement, AnalyzeMode.PROFILE);
      assertThat(rs, is(notNullValue()));
      // get all results and then get the stats
      while (rs.next()) {
        // do nothing
      }
      assertThat(rs.getStats(), is(notNullValue()));
    }
  }

  @Test
  public void testGetReadTimestamp() {
    for (TimestampBound staleness : getTestTimestampBounds()) {
      ParsedStatement parsedStatement = mock(ParsedStatement.class);
      when(parsedStatement.getType()).thenReturn(StatementType.QUERY);
      when(parsedStatement.isQuery()).thenReturn(true);
      Statement statement = Statement.of("SELECT * FROM FOO");
      when(parsedStatement.getStatement()).thenReturn(statement);
      when(parsedStatement.getSqlWithoutComments()).thenReturn(statement.getSql());

      ReadOnlyTransaction transaction = createSubject(staleness);
      boolean expectedException = false;
      try {
        transaction.getReadTimestamp();
      } catch (SpannerException e) {
        if (e.getErrorCode() == ErrorCode.FAILED_PRECONDITION) {
          expectedException = true;
        }
      }
      assertThat(expectedException, is(true));
      assertThat(transaction.executeQuery(parsedStatement, AnalyzeMode.NONE), is(notNullValue()));
      assertThat(transaction.getReadTimestamp(), is(notNullValue()));
    }
  }

  private List<TimestampBound> getTestTimestampBounds() {
    return Arrays.asList(
        TimestampBound.strong(),
        TimestampBound.ofReadTimestamp(Timestamp.now()),
        TimestampBound.ofMinReadTimestamp(Timestamp.now()),
        TimestampBound.ofExactStaleness(1L, TimeUnit.SECONDS),
        TimestampBound.ofMaxStaleness(100L, TimeUnit.MILLISECONDS));
  }

  @Test
  public void testState() {
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    when(parsedStatement.getType()).thenReturn(StatementType.QUERY);
    when(parsedStatement.isQuery()).thenReturn(true);
    Statement statement = Statement.of("SELECT * FROM FOO");
    when(parsedStatement.getStatement()).thenReturn(statement);
    when(parsedStatement.getSqlWithoutComments()).thenReturn(statement.getSql());

    ReadOnlyTransaction transaction = createSubject();
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.STARTED)));
    assertThat(transaction.isActive(), is(true));
    transaction.commit();
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.COMMITTED)));
    assertThat(transaction.isActive(), is(false));

    transaction = createSubject();
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.STARTED)));
    assertThat(transaction.isActive(), is(true));
    assertThat(transaction.executeQuery(parsedStatement, AnalyzeMode.NONE), is(notNullValue()));
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.STARTED)));
    assertThat(transaction.isActive(), is(true));

    transaction.commit();
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.COMMITTED)));
    assertThat(transaction.isActive(), is(false));

    // start a new transaction
    transaction = createSubject();
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.STARTED)));
    assertThat(transaction.isActive(), is(true));
    transaction.rollback();
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.ROLLED_BACK)));
    assertThat(transaction.isActive(), is(false));

    transaction = createSubject();
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.STARTED)));
    assertThat(transaction.isActive(), is(true));
    assertThat(transaction.executeQuery(parsedStatement, AnalyzeMode.NONE), is(notNullValue()));
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.STARTED)));
    assertThat(transaction.isActive(), is(true));
    transaction.rollback();
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.ROLLED_BACK)));
    assertThat(transaction.isActive(), is(false));
  }
}
