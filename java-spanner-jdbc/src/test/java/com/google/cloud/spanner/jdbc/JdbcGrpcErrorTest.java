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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.admin.database.v1.MockDatabaseAdminImpl;
import com.google.cloud.spanner.admin.instance.v1.MockInstanceAdminImpl;
import com.google.cloud.spanner.connection.SpannerPool;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcSqlExceptionImpl;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.rpc.Code;
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
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Test that the JDBC driver propagates {@link SQLException}s when a gRPC error occurs. */
@RunWith(JUnit4.class)
public class JdbcGrpcErrorTest {
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
  private static final Statement UPDATE_STATEMENT =
      Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2");
  private static final int UPDATE_COUNT = 1;
  private static final Statement INVALID_UPDATE_STATEMENT =
      Statement.of("UPDATE NON_EXISING_TABLE SET FOO=1 WHERE BAR=2");

  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;

  // INVALID_ARGUMENT is chosen as the test error code as it should never be retryable, and it does
  // not overlap with the 'are multiplexed sessions supported?' check.
  private final Exception serverException =
      Status.INVALID_ARGUMENT.withDescription("test exception").asRuntimeException();

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(StatementResult.query(SELECT1, SELECT1_RESULTSET));
    mockSpanner.putStatementResult(StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT));
    mockSpanner.putStatementResult(
        StatementResult.exception(
            INVALID_UPDATE_STATEMENT,
            Status.NOT_FOUND.withDescription("Unknown table name").asRuntimeException()));
    MockInstanceAdminImpl mockInstanceAdmin = new MockInstanceAdminImpl();
    MockDatabaseAdminImpl mockDatabaseAdmin = new MockDatabaseAdminImpl();
    InetSocketAddress address = new InetSocketAddress("localhost", 0);
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
    server.shutdown();
    server.awaitTermination();
  }

  @After
  public void reset() {
    // Close Spanner pool to prevent reusage of the same Spanner instance (and thereby the same
    // session pool).
    try {
      SpannerPool.closeSpannerPool();
    } catch (SpannerException e) {
      // Ignore leaked session errors that can be caused by the internal dialect auto-detection that
      // is executed at startup. This query can still be running when an error is caused by tests in
      // this class, and that will be registered as a session leak as that session has not yet been
      // checked in to the pool.
      if (!(e.getErrorCode() == ErrorCode.FAILED_PRECONDITION
          && e.getMessage()
              .contains(
                  "There is/are 1 connection(s) still open. Close all connections before calling closeSpanner()"))) {
        throw e;
      }
    }
    mockSpanner.removeAllExecutionTimes();
    mockSpanner.reset();
  }

  private String createUrl() {
    return String.format(
        "jdbc:cloudspanner://localhost:%d/projects/%s/instances/%s/databases/%s?usePlainText=true;minSessions=0",
        server.getPort(), "proj", "inst", "db");
  }

  private Connection createConnection() throws SQLException {
    return DriverManager.getConnection(createUrl());
  }

  @Test
  public void autocommitBeginTransaction() throws SQLException {
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      // This triggers a retry with an explicit BeginTransaction RPC.
      mockSpanner.abortNextStatement();
      JdbcSqlExceptionImpl sqlException =
          assertThrows(
              JdbcSqlExceptionImpl.class,
              () -> connection.createStatement().executeUpdate(UPDATE_STATEMENT.getSql()));
      assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
      assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
    }
  }

  @Test
  public void autocommitBeginPDMLTransaction() throws SQLException {
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      connection.createStatement().execute("SET AUTOCOMMIT_DML_MODE='PARTITIONED_NON_ATOMIC'");
      JdbcSqlExceptionImpl sqlException =
          assertThrows(
              JdbcSqlExceptionImpl.class,
              () -> connection.createStatement().executeUpdate(UPDATE_STATEMENT.getSql()));
      assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
      assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
    }
  }

  @Test
  public void transactionalBeginTransaction() throws SQLException {
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      // This triggers a retry with an explicit BeginTransaction RPC.
      mockSpanner.abortNextStatement();
      JdbcSqlExceptionImpl sqlException =
          assertThrows(
              JdbcSqlExceptionImpl.class,
              () -> connection.createStatement().executeUpdate(UPDATE_STATEMENT.getSql()));
      assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
      assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
    }
  }

  @Test
  public void readOnlyBeginTransaction() throws SQLException {
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      connection.setReadOnly(true);
      JdbcSqlExceptionImpl sqlException =
          assertThrows(
              JdbcSqlExceptionImpl.class,
              () -> connection.createStatement().executeQuery(SELECT1.getSql()));
      assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
      assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
    }
  }

  @Test
  public void autocommitExecuteSql() throws SQLException {
    mockSpanner.setExecuteSqlExecutionTime(
        SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      JdbcSqlExceptionImpl sqlException =
          assertThrows(
              JdbcSqlExceptionImpl.class,
              () -> connection.createStatement().executeUpdate(UPDATE_STATEMENT.getSql()));
      assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
      assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
    }
  }

  @Test
  public void autocommitPDMLExecuteSql() throws SQLException {
    // Make sure the dialect auto-detection has finished before we instruct the RPC to always return
    // an error.
    try (java.sql.Connection connection = createConnection()) {
      connection.unwrap(CloudSpannerJdbcConnection.class).getDialect();
    }

    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      connection.createStatement().execute("SET AUTOCOMMIT_DML_MODE='PARTITIONED_NON_ATOMIC'");
      JdbcSqlExceptionImpl sqlException =
          assertThrows(
              JdbcSqlExceptionImpl.class,
              () -> connection.createStatement().executeUpdate(UPDATE_STATEMENT.getSql()));
      assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
      assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
    }
  }

  @Test
  public void transactionalExecuteSql() throws SQLException {
    mockSpanner.setExecuteSqlExecutionTime(
        SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      JdbcSqlExceptionImpl sqlException =
          assertThrows(
              JdbcSqlExceptionImpl.class,
              () -> connection.createStatement().executeUpdate(UPDATE_STATEMENT.getSql()));
      assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
      assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
    }
  }

  @Test
  public void autocommitExecuteBatchDml() throws SQLException {
    mockSpanner.setExecuteBatchDmlExecutionTime(
        SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      try (java.sql.Statement statement = connection.createStatement()) {
        statement.addBatch(UPDATE_STATEMENT.getSql());
        statement.addBatch(UPDATE_STATEMENT.getSql());
        JdbcSqlExceptionImpl sqlException =
            assertThrows(JdbcSqlExceptionImpl.class, statement::executeBatch);
        assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
        assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
      }
    }
  }

  @Test
  public void transactionalExecuteBatchDml() throws SQLException {
    mockSpanner.setExecuteBatchDmlExecutionTime(
        SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      try (java.sql.Statement statement = connection.createStatement()) {
        statement.addBatch(UPDATE_STATEMENT.getSql());
        statement.addBatch(UPDATE_STATEMENT.getSql());
        JdbcSqlExceptionImpl sqlException =
            assertThrows(JdbcSqlExceptionImpl.class, statement::executeBatch);
        assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
        assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
      }
    }
  }

  @Test
  public void autocommitCommit() throws SQLException {
    mockSpanner.setCommitExecutionTime(SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      JdbcSqlExceptionImpl sqlException =
          assertThrows(
              JdbcSqlExceptionImpl.class,
              () -> connection.createStatement().executeUpdate(UPDATE_STATEMENT.getSql()));
      assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
      assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
    }
  }

  @Test
  public void transactionalCommit() throws SQLException {
    mockSpanner.setCommitExecutionTime(SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      connection.createStatement().executeUpdate(UPDATE_STATEMENT.getSql());
      JdbcSqlExceptionImpl sqlException =
          assertThrows(JdbcSqlExceptionImpl.class, connection::commit);
      assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
      assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
    }
  }

  @Test
  public void autocommitRollback() throws SQLException {
    // The JDBC driver should throw the exception of the SQL statement and ignore any errors from
    // the rollback() method.
    mockSpanner.setRollbackExecutionTime(SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      JdbcSqlExceptionImpl sqlException =
          assertThrows(
              JdbcSqlExceptionImpl.class,
              () -> connection.createStatement().executeUpdate(INVALID_UPDATE_STATEMENT.getSql()));
      assertEquals(Code.NOT_FOUND, sqlException.getCode());
      assertTrue(
          sqlException.getMessage(), sqlException.getMessage().contains("Unknown table name"));
    }
  }

  @Test
  public void transactionalRollback() throws SQLException {
    // Rollback exceptions are ignored by the client library and not propagated to the JDBC driver.
    // This method will therefore not throw any errors.
    mockSpanner.setRollbackExecutionTime(SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      connection.createStatement().executeUpdate(UPDATE_STATEMENT.getSql());
      connection.rollback();
    }
  }

  @Test
  public void autocommitExecuteStreamingSql() throws SQLException {
    // Make sure the dialect auto-detection has finished before we instruct the RPC to always return
    // an error.
    try (java.sql.Connection connection = createConnection()) {
      connection.unwrap(CloudSpannerJdbcConnection.class).getDialect();
    }

    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      JdbcSqlExceptionImpl sqlException =
          assertThrows(
              JdbcSqlExceptionImpl.class,
              () -> connection.createStatement().executeQuery(SELECT1.getSql()));
      assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
      assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
    }
  }

  @Test
  public void transactionalExecuteStreamingSql() throws SQLException {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      JdbcSqlExceptionImpl sqlException =
          assertThrows(
              JdbcSqlExceptionImpl.class,
              () -> connection.createStatement().executeQuery(SELECT1.getSql()));
      assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
      assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
    }
  }

  @Test
  public void readOnlyExecuteStreamingSql() throws SQLException {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      connection.setReadOnly(true);
      JdbcSqlExceptionImpl sqlException =
          assertThrows(
              JdbcSqlExceptionImpl.class,
              () -> connection.createStatement().executeQuery(SELECT1.getSql()));
      assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
      assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
    }
  }

  @Test
  public void autocommitCreateSession() throws SQLException {
    mockSpanner.setCreateSessionExecutionTime(
        SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      JdbcSqlExceptionImpl sqlException =
          assertThrows(
              JdbcSqlExceptionImpl.class,
              () -> connection.createStatement().executeUpdate(UPDATE_STATEMENT.getSql()));
      assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
      assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
    }
  }

  @Test
  public void transactionalCreateSession() throws SQLException {
    mockSpanner.setCreateSessionExecutionTime(
        SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      JdbcSqlExceptionImpl sqlException =
          assertThrows(
              JdbcSqlExceptionImpl.class,
              () -> connection.createStatement().executeUpdate(UPDATE_STATEMENT.getSql()));
      assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
      assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
    }
  }

  @Test
  public void readOnlyCreateSession() throws SQLException {
    mockSpanner.setCreateSessionExecutionTime(
        SimulatedExecutionTime.ofStickyException(serverException));
    try (java.sql.Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      connection.setReadOnly(true);
      JdbcSqlExceptionImpl sqlException =
          assertThrows(
              JdbcSqlExceptionImpl.class,
              () -> connection.createStatement().executeQuery(SELECT1.getSql()));
      assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
      assertTrue(sqlException.getMessage(), sqlException.getMessage().contains("test exception"));
    }
  }
}
