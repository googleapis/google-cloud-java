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

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.admin.database.v1.MockDatabaseAdminImpl;
import com.google.cloud.spanner.admin.instance.v1.MockInstanceAdminImpl;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcAbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcAbortedException;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JdbcAbortedTransactionTest {
  private static final class TransactionRetryCounter implements TransactionRetryListener {
    private int retriesFinished;

    @Override
    public void retryStarting(Timestamp transactionStarted, long transactionId, int retryAttempt) {}

    @Override
    public void retryFinished(
        Timestamp transactionStarted, long transactionId, int retryAttempt, RetryResult result) {
      retriesFinished++;
    }
  }

  private static final Statement SELECT1 = Statement.of("SELECT 1 AS COL1");
  private static final ResultSetMetadata SELECT1_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("COL1")
                          .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                          .build())
                  .build())
          .build();
  private static final com.google.spanner.v1.ResultSet SELECT1_RESULTSET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(Value.newBuilder().setStringValue("1").build())
                  .build())
          .setMetadata(SELECT1_METADATA)
          .build();
  private static final Statement SELECT_RANDOM = Statement.of("SELECT * FROM RANDOM");
  private static final Statement UPDATE_STATEMENT =
      Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2");
  private static final int UPDATE_COUNT = 1;

  private static MockSpannerServiceImpl mockSpanner;
  private static MockInstanceAdminImpl mockInstanceAdmin;
  private static MockDatabaseAdminImpl mockDatabaseAdmin;
  private static Server server;
  private static InetSocketAddress address;

  @Parameter(0)
  public boolean retryAbortsInternally;

  @Rule public ExpectedException expected = ExpectedException.none();

  @Parameters(name = "retryAbortsInternally = {0}")
  public static Collection<Object[]> data() {
    List<Object[]> params = new ArrayList<>();
    params.add(new Object[] {Boolean.TRUE});
    params.add(new Object[] {Boolean.FALSE});
    return params;
  }

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(StatementResult.query(SELECT1, SELECT1_RESULTSET));
    mockSpanner.putStatementResult(StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT));
    mockInstanceAdmin = new MockInstanceAdminImpl();
    mockDatabaseAdmin = new MockDatabaseAdminImpl();
    address = new InetSocketAddress("localhost", 0);
    server =
        NettyServerBuilder.forAddress(address)
            .addService(mockSpanner)
            .addService(mockInstanceAdmin)
            .addService(mockDatabaseAdmin)
            .build()
            .start();
  }

  @AfterClass
  public static void stopServer() throws Exception {
    SpannerPool.closeSpannerPool();
    server.shutdown();
    server.awaitTermination();
  }

  private String createUrl() {
    return String.format(
        "jdbc:cloudspanner://localhost:%d/projects/%s/instances/%s/databases/%s?usePlainText=true;retryAbortsInternally=%s",
        server.getPort(), "proj", "inst", "db", Boolean.toString(retryAbortsInternally));
  }

  private Connection createConnection() throws SQLException {
    Connection connection = DriverManager.getConnection(createUrl());
    CloudSpannerJdbcConnection cs = connection.unwrap(CloudSpannerJdbcConnection.class);
    cs.addTransactionRetryListener(new TransactionRetryCounter());
    return connection;
  }

  private int getRetryCount(Connection connection) throws SQLException {
    return ((TransactionRetryCounter)
            connection
                .unwrap(CloudSpannerJdbcConnection.class)
                .getTransactionRetryListeners()
                .next())
        .retriesFinished;
  }

  @Test
  public void testAutocommitUpdateAborted() throws SQLException {
    // Updates in autocommit are always automatically retried.
    // These retries are not picked up by the transaction retry listener, as that is only done for
    // actual JDBC transactions that are retried.
    try (java.sql.Connection connection = createConnection()) {
      mockSpanner.abortNextStatement();
      int updateCount = connection.createStatement().executeUpdate(UPDATE_STATEMENT.getSql());
      assertThat(updateCount, is(equalTo(UPDATE_COUNT)));
    }
  }

  @Test
  public void testTransactionalUpdateAborted() throws SQLException {
    // Updates in transactional mode are automatically retried by default, but this can be switched
    // off.
    if (!retryAbortsInternally) {
      expected.expect(JdbcAbortedException.class);
    }
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      mockSpanner.abortNextStatement();
      int updateCount = connection.createStatement().executeUpdate(UPDATE_STATEMENT.getSql());
      assertThat(updateCount, is(equalTo(UPDATE_COUNT)));
      assertThat(getRetryCount(connection), is(equalTo(1)));
    }
  }

  @Test
  public void testAutocommitBatchUpdateAborted() throws SQLException {
    try (java.sql.Connection connection = createConnection()) {
      mockSpanner.abortNextStatement();
      try (java.sql.Statement statement = connection.createStatement()) {
        statement.addBatch(UPDATE_STATEMENT.getSql());
        statement.addBatch(UPDATE_STATEMENT.getSql());
        int[] updateCounts = statement.executeBatch();
        assertThat(updateCounts, is(equalTo(new int[] {UPDATE_COUNT, UPDATE_COUNT})));
      }
    }
  }

  @Test
  public void testTransactionalBatchUpdateAborted() throws SQLException {
    if (!retryAbortsInternally) {
      expected.expect(JdbcAbortedException.class);
    }
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      mockSpanner.abortNextStatement();
      try (java.sql.Statement statement = connection.createStatement()) {
        statement.addBatch(UPDATE_STATEMENT.getSql());
        statement.addBatch(UPDATE_STATEMENT.getSql());
        int[] updateCounts = statement.executeBatch();
        assertThat(updateCounts, is(equalTo(new int[] {UPDATE_COUNT, UPDATE_COUNT})));
        assertThat(getRetryCount(connection), is(equalTo(1)));
      }
    }
  }

  @Test
  public void testAutocommitSelectAborted() throws SQLException {
    // Selects in autocommit are executed using a singleUse read-only transaction and cannot abort.
    try (java.sql.Connection connection = createConnection()) {
      mockSpanner.abortNextStatement();
      try (ResultSet rs = connection.createStatement().executeQuery(SELECT1.getSql())) {
        while (rs.next()) {
          assertThat(rs.getLong(1), is(equalTo(1L)));
        }
      }
    }
  }

  @Test
  public void testTransactionalSelectAborted() throws SQLException {
    if (!retryAbortsInternally) {
      expected.expect(JdbcAbortedException.class);
    }
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      mockSpanner.abortNextStatement();
      try (ResultSet rs = connection.createStatement().executeQuery(SELECT1.getSql())) {
        while (rs.next()) {
          assertThat(rs.getLong(1), is(equalTo(1L)));
        }
      }
      assertThat(getRetryCount(connection), is(equalTo(1)));
    }
  }

  @Test
  public void testTransactionalUpdateWithConcurrentModificationsAborted() throws SQLException {
    if (retryAbortsInternally) {
      // As the transaction does a random select, the retry will always see different data than the
      // original attempt.
      expected.expect(JdbcAbortedDueToConcurrentModificationException.class);
    } else {
      expected.expect(JdbcAbortedException.class);
    }
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      // Set a random answer.
      mockSpanner.putStatementResult(
          StatementResult.query(SELECT_RANDOM, new RandomResultSetGenerator(25).generate()));
      try (ResultSet rs = connection.createStatement().executeQuery(SELECT_RANDOM.getSql())) {
        while (rs.next()) {}
      }
      // Set a new random answer that will be returned during the retry.
      mockSpanner.putStatementResult(
          StatementResult.query(SELECT_RANDOM, new RandomResultSetGenerator(25).generate()));
      // Abort all transactions (including the current one).
      mockSpanner.abortNextStatement();
      // This will abort and start an internal retry.
      connection.createStatement().executeUpdate(UPDATE_STATEMENT.getSql());
      fail("missing expected aborted exception");
    }
  }

  @Test
  public void testTransactionalUpdateWithErrorOnOriginalAndRetry() throws SQLException {
    if (!retryAbortsInternally) {
      expected.expect(JdbcAbortedException.class);
    }
    final String sql = "UPDATE SOMETHING SET OTHER=1";
    mockSpanner.putStatementResult(
        StatementResult.exception(
            Statement.of(sql),
            Status.INVALID_ARGUMENT.withDescription("test").asRuntimeException()));
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      try (ResultSet rs = connection.createStatement().executeQuery(SELECT1.getSql())) {
        while (rs.next()) {
          assertThat(rs.getLong(1), is(equalTo(1L)));
        }
      }
      try {
        connection.createStatement().executeUpdate(sql);
        fail("missing 'test' exception");
      } catch (SQLException e) {
        // ignore
      }
      mockSpanner.abortNextStatement();
      connection.commit();
    }
  }

  @Test
  public void testTransactionalUpdateWithErrorOnRetryAndNotOnOriginal() throws SQLException {
    if (retryAbortsInternally) {
      expected.expect(JdbcAbortedDueToConcurrentModificationException.class);
    } else {
      expected.expect(JdbcAbortedException.class);
    }
    final String sql = "UPDATE SOMETHING SET OTHER=1";
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      // Set a normal response to the update statement.
      mockSpanner.putStatementResult(StatementResult.update(Statement.of(sql), 1L));
      connection.createStatement().executeUpdate(sql);
      // Set an error as response for the same update statement that will be used during the retry.
      // This will cause the retry to fail.
      mockSpanner.putStatementResult(
          StatementResult.exception(
              Statement.of(sql),
              Status.INVALID_ARGUMENT.withDescription("test").asRuntimeException()));
      mockSpanner.abortNextStatement();
      connection.commit();
      fail("missing expected aborted exception");
    } catch (JdbcAbortedDueToConcurrentModificationException e) {
      assertThat(
          e.getDatabaseErrorDuringRetry().getErrorCode(), is(equalTo(ErrorCode.INVALID_ARGUMENT)));
      assertThat(e.getDatabaseErrorDuringRetry().getMessage(), endsWith("test"));
      throw e;
    }
  }

  @Test
  public void testTransactionalUpdateWithErrorOnOriginalAndNotOnRetry() throws SQLException {
    if (retryAbortsInternally) {
      expected.expect(JdbcAbortedDueToConcurrentModificationException.class);
    } else {
      expected.expect(JdbcAbortedException.class);
    }
    final String sql = "UPDATE SOMETHING SET OTHER=1";
    mockSpanner.putStatementResult(
        StatementResult.exception(
            Statement.of(sql),
            Status.INVALID_ARGUMENT.withDescription("test").asRuntimeException()));
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      try (ResultSet rs = connection.createStatement().executeQuery(SELECT1.getSql())) {
        while (rs.next()) {
          assertThat(rs.getLong(1), is(equalTo(1L)));
        }
      }
      try {
        connection.createStatement().executeUpdate(sql);
        fail("missing 'test' exception");
      } catch (SQLException e) {
        // ignore
      }
      // Set the update statement to return a result next time (i.e. during retry).
      mockSpanner.putStatementResult(StatementResult.update(Statement.of(sql), 1L));
      mockSpanner.abortNextStatement();
      connection.commit();
      fail("missing expected aborted exception");
    } catch (JdbcAbortedDueToConcurrentModificationException e) {
      assertThat(e.getDatabaseErrorDuringRetry(), is(nullValue()));
      throw e;
    }
  }
}
