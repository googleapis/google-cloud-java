/*
 * Copyright 2023 Google LLC
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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.SessionPoolOptions;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.connection.SpannerPool;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.rpc.Code;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * Test class for verifying that the methods execute, executeQuery, and executeUpdate work as
 * intended. It also verifies that they always also include any comments in the statement for the
 * PostgreSQL dialect, as these may contain hints.
 */
@RunWith(Parameterized.class)
public class ExecuteMockServerTest extends AbstractMockServerTest {
  private static final IllegalStateException REQUEST_NOT_FOUND =
      new IllegalStateException("request not found");
  private static Dialect currentDialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] parameters() {
    return Dialect.values();
  }

  @Parameter public Dialect dialect;

  private static final String DDL = "create table my_table";
  private static final long LARGE_UPDATE_COUNT = 2L * Integer.MAX_VALUE;

  private String query;
  private String dml;
  private String largeDml;
  private String dmlReturning;
  private String clientSideQuery;
  private String clientSideUpdate;

  @Before
  public void setupResults() {
    // Only register new results if the dialect has changed.
    if (!Objects.equals(currentDialect, dialect)) {
      query =
          dialect == Dialect.POSTGRESQL
              ? "/*@ lock_scanned_ranges = exclusive */ select * from my_table"
              : "select * from my_table";
      dml =
          dialect == Dialect.POSTGRESQL
              ? "/*@ lock_scanned_ranges = exclusive */ insert into my_table (id, value) values (1, 'One')"
              : "insert into my_table (id, value) values (1, 'One')";
      String DML_THEN_RETURN_ID =
          dml + (dialect == Dialect.POSTGRESQL ? "\nRETURNING \"id\"" : "\nTHEN RETURN `id`");
      largeDml =
          dialect == Dialect.POSTGRESQL
              ? "/*@ lock_scanned_ranges = exclusive */ update my_table set value='new value' where true"
              : "update my_table set value='new value' where true";
      String LARGE_DML_THEN_RETURN_ID =
          largeDml + (dialect == Dialect.POSTGRESQL ? "\nRETURNING \"id\"" : "\nTHEN RETURN `id`");
      dmlReturning =
          dialect == Dialect.POSTGRESQL
              ? "/*@ lock_scanned_ranges = exclusive */ insert into my_table (id, value) values (1, 'One') RETURNING *"
              : "insert into my_table (id, value) values (1, 'One') THEN RETURN *";
      clientSideQuery =
          dialect == Dialect.POSTGRESQL ? "show spanner.readonly" : "show variable readonly";
      clientSideUpdate =
          dialect == Dialect.POSTGRESQL ? "set spanner.readonly=false" : "set readonly=false";

      // This forces a refresh of the Spanner instance that is used for a connection, which again is
      // needed in order to refresh the dialect of the database.
      SpannerPool.closeSpannerPool();
      mockSpanner.putStatementResult(StatementResult.detectDialectResult(dialect));

      super.setupResults();

      com.google.spanner.v1.ResultSet resultSet =
          com.google.spanner.v1.ResultSet.newBuilder()
              .setMetadata(
                  ResultSetMetadata.newBuilder()
                      .setRowType(
                          StructType.newBuilder()
                              .addFields(
                                  Field.newBuilder()
                                      .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                      .setName("id")
                                      .build())
                              .addFields(
                                  Field.newBuilder()
                                      .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                      .setName("value")
                                      .build())
                              .build())
                      .build())
              .addRows(
                  ListValue.newBuilder()
                      .addValues(Value.newBuilder().setStringValue("1").build())
                      .addValues(Value.newBuilder().setStringValue("One").build())
                      .build())
              .build();
      com.google.spanner.v1.ResultSet returnIdResultSet =
          com.google.spanner.v1.ResultSet.newBuilder()
              .setMetadata(
                  ResultSetMetadata.newBuilder()
                      .setRowType(
                          StructType.newBuilder()
                              .addFields(
                                  Field.newBuilder()
                                      .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                      .setName("id")
                                      .build())
                              .build())
                      .build())
              .addRows(
                  ListValue.newBuilder()
                      .addValues(Value.newBuilder().setStringValue("1").build())
                      .build())
              .build();
      mockSpanner.putStatementResult(
          StatementResult.query(com.google.cloud.spanner.Statement.of(query), resultSet));
      mockSpanner.putStatementResult(
          StatementResult.update(com.google.cloud.spanner.Statement.of(dml), 1L));
      mockSpanner.putStatementResult(
          StatementResult.update(
              com.google.cloud.spanner.Statement.of(largeDml), LARGE_UPDATE_COUNT));
      mockSpanner.putStatementResult(
          StatementResult.query(
              com.google.cloud.spanner.Statement.of(dmlReturning),
              resultSet.toBuilder()
                  .setStats(ResultSetStats.newBuilder().setRowCountExact(1L).build())
                  .build()));
      mockSpanner.putStatementResult(
          StatementResult.query(
              com.google.cloud.spanner.Statement.of(DML_THEN_RETURN_ID),
              returnIdResultSet.toBuilder()
                  .setStats(ResultSetStats.newBuilder().setRowCountExact(1L).build())
                  .build()));
      mockSpanner.putStatementResult(
          StatementResult.query(
              com.google.cloud.spanner.Statement.of(LARGE_DML_THEN_RETURN_ID),
              returnIdResultSet.toBuilder()
                  .setStats(
                      ResultSetStats.newBuilder().setRowCountExact(LARGE_UPDATE_COUNT).build())
                  .build()));
      mockDatabaseAdmin.addResponse(
          Operation.newBuilder()
              .setDone(true)
              .setResponse(Any.pack(Empty.getDefaultInstance()))
              .setMetadata(Any.pack(UpdateDatabaseDdlMetadata.getDefaultInstance()))
              .build());
    }
  }

  private String createUrl() {
    return String.format(
        "jdbc:cloudspanner://localhost:%d/projects/%s/instances/%s/databases/%s?usePlainText=true",
        getPort(), "proj", "inst", "db");
  }

  @Override
  protected Connection createJdbcConnection() throws SQLException {
    return DriverManager.getConnection(createUrl());
  }

  @Test
  public void testStatementExecuteQuery() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(query)) {
        verifyResultSet(resultSet);
      }
      ExecuteSqlRequest request =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
              .filter(r -> r.getSql().equals(query))
              .findAny()
              .orElseThrow(() -> REQUEST_NOT_FOUND);
      assertTrue(request.getTransaction().hasSingleUse());
      assertTrue(request.getTransaction().getSingleUse().hasReadOnly());
      assertFalse(request.getLastStatement());

      try (ResultSet resultSet = statement.executeQuery(dmlReturning)) {
        verifyResultSet(resultSet);
      }
      request =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
              .filter(r -> r.getSql().equals(dmlReturning))
              .findAny()
              .orElseThrow(() -> REQUEST_NOT_FOUND);
      assertTrue(request.getTransaction().hasBegin());
      assertTrue(request.getTransaction().getBegin().hasReadWrite());
      assertTrue(request.getLastStatement());

      try (ResultSet resultSet = statement.executeQuery(clientSideQuery)) {
        verifyClientSideResultSet(resultSet);
      }
      verifyException(() -> statement.executeQuery(dml));
      verifyException(() -> statement.executeQuery(largeDml));
      verifyException(() -> statement.executeQuery(DDL));
      verifyException(() -> statement.executeQuery(clientSideUpdate));
    }
  }

  @Test
  public void testStatementExecuteUpdate() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      assertEquals(1, statement.executeUpdate(dml));
      ExecuteSqlRequest request =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
              .filter(r -> r.getSql().equals(dml))
              .findAny()
              .orElseThrow(() -> REQUEST_NOT_FOUND);
      assertTrue(request.getTransaction().hasBegin());
      assertTrue(request.getTransaction().getBegin().hasReadWrite());
      assertTrue(request.getLastStatement());

      assertEquals(0, statement.executeUpdate(DDL));

      connection.setAutoCommit(false);
      assertEquals(0, statement.executeUpdate(clientSideUpdate));
      connection.setAutoCommit(true);

      verifyOverflow(() -> statement.executeUpdate(largeDml));
      verifyException(() -> statement.executeUpdate(query));
      verifyException(() -> statement.executeUpdate(dmlReturning));
      verifyException(() -> statement.executeUpdate(clientSideQuery));
    }
  }

  @Test
  public void testStatementExecuteUpdateReturnGeneratedKeys() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      // TODO: Add tests for RETURN_GENERATED_KEYS when that is supported.
      assertEquals(1, statement.executeUpdate(dml, Statement.NO_GENERATED_KEYS));
      ExecuteSqlRequest request =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
              .findAny()
              .orElseThrow(() -> REQUEST_NOT_FOUND);
      assertTrue(request.getTransaction().hasBegin());
      assertTrue(request.getTransaction().getBegin().hasReadWrite());
      assertTrue(request.getLastStatement());

      assertEquals(0, statement.executeUpdate(DDL, Statement.NO_GENERATED_KEYS));
      assertEquals(0, statement.executeUpdate(clientSideUpdate, Statement.NO_GENERATED_KEYS));

      verifyOverflow(() -> statement.executeUpdate(largeDml, Statement.NO_GENERATED_KEYS));
      verifyException(() -> statement.executeUpdate(query, Statement.NO_GENERATED_KEYS));
      verifyException(() -> statement.executeUpdate(dmlReturning, Statement.NO_GENERATED_KEYS));
      verifyException(() -> statement.executeUpdate(clientSideQuery, Statement.NO_GENERATED_KEYS));
    }
  }

  @Test
  public void testStatementExecuteUpdateReturnColumnNames() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      assertEquals(1, statement.executeUpdate(dml, new String[] {"id"}));
      ExecuteSqlRequest request =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
              .findAny()
              .orElseThrow(() -> REQUEST_NOT_FOUND);
      assertTrue(request.getTransaction().hasBegin());
      assertTrue(request.getTransaction().getBegin().hasReadWrite());
      assertTrue(request.getLastStatement());

      assertEquals(0, statement.executeUpdate(DDL, new String[] {"id"}));
      assertEquals(0, statement.executeUpdate(clientSideUpdate, new String[] {"id"}));

      verifyOverflow(() -> statement.executeUpdate(largeDml, new String[] {"id"}));
      verifyException(
          () -> statement.executeUpdate(query, new String[] {"id"}), Code.FAILED_PRECONDITION);
      assertEquals(1, statement.executeUpdate(dmlReturning, new String[] {"id"}));
      verifyException(
          () -> statement.executeUpdate(clientSideQuery, new String[] {"id"}),
          Code.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testStatementExecuteUpdateReturnColumnIndexes() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      assertEquals(1, statement.executeUpdate(dml, new int[] {1}));
      ExecuteSqlRequest request =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
              .findAny()
              .orElseThrow(() -> REQUEST_NOT_FOUND);
      assertTrue(request.getTransaction().hasBegin());
      assertTrue(request.getTransaction().getBegin().hasReadWrite());
      assertTrue(request.getLastStatement());

      assertEquals(0, statement.executeUpdate(DDL, new int[] {1}));
      assertEquals(0, statement.executeUpdate(clientSideUpdate, new int[] {1}));
      verifyOverflow(() -> statement.executeUpdate(largeDml, new int[] {1}));
      verifyException(() -> statement.executeUpdate(query, new int[] {1}));
      verifyException(() -> statement.executeUpdate(dmlReturning, new int[] {1}));
      verifyException(() -> statement.executeUpdate(clientSideQuery, new int[] {1}));
    }
  }

  @Test
  public void testStatementLargeExecuteUpdate() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      assertEquals(1L, statement.executeLargeUpdate(dml));
      ExecuteSqlRequest request =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
              .findAny()
              .orElseThrow(() -> REQUEST_NOT_FOUND);
      assertTrue(request.getTransaction().hasBegin());
      assertTrue(request.getTransaction().getBegin().hasReadWrite());
      assertTrue(request.getLastStatement());

      assertEquals(0L, statement.executeLargeUpdate(DDL));
      assertEquals(0L, statement.executeLargeUpdate(clientSideUpdate));
      assertEquals(LARGE_UPDATE_COUNT, statement.executeLargeUpdate(largeDml));
      verifyException(() -> statement.executeLargeUpdate(query));
      verifyException(() -> statement.executeLargeUpdate(dmlReturning));
      verifyException(() -> statement.executeLargeUpdate(clientSideQuery));
    }
  }

  @Test
  public void testStatementExecuteLargeUpdateReturnGeneratedKeys() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      // TODO: Add tests for RETURN_GENERATED_KEYS when that is supported.
      assertEquals(1, statement.executeLargeUpdate(dml, Statement.NO_GENERATED_KEYS));
      ExecuteSqlRequest request =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
              .findAny()
              .orElseThrow(() -> REQUEST_NOT_FOUND);
      assertTrue(request.getTransaction().hasBegin());
      assertTrue(request.getTransaction().getBegin().hasReadWrite());
      assertTrue(request.getLastStatement());

      assertEquals(0, statement.executeLargeUpdate(DDL, Statement.NO_GENERATED_KEYS));
      assertEquals(0, statement.executeLargeUpdate(clientSideUpdate, Statement.NO_GENERATED_KEYS));
      assertEquals(
          LARGE_UPDATE_COUNT, statement.executeLargeUpdate(largeDml, Statement.NO_GENERATED_KEYS));
      verifyException(() -> statement.executeLargeUpdate(query, Statement.NO_GENERATED_KEYS));
      verifyException(
          () -> statement.executeLargeUpdate(dmlReturning, Statement.NO_GENERATED_KEYS));
      verifyException(
          () -> statement.executeLargeUpdate(clientSideQuery, Statement.NO_GENERATED_KEYS));
    }
  }

  @Test
  public void testStatementExecuteLargeUpdateReturnColumnNames() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      assertEquals(1, statement.executeLargeUpdate(dml, new String[] {"id"}));
      assertEquals(0, statement.executeLargeUpdate(DDL, new String[] {"id"}));
      assertEquals(0, statement.executeLargeUpdate(clientSideUpdate, new String[] {"id"}));
      assertEquals(LARGE_UPDATE_COUNT, statement.executeLargeUpdate(largeDml, new String[] {"id"}));
      verifyException(
          () -> statement.executeLargeUpdate(query, new String[] {"id"}), Code.FAILED_PRECONDITION);
      assertEquals(1L, statement.executeLargeUpdate(dmlReturning, new String[] {"id"}));
      verifyException(
          () -> statement.executeLargeUpdate(clientSideQuery, new String[] {"id"}),
          Code.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testStatementExecuteLargeUpdateReturnColumnIndexes() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      assertEquals(1, statement.executeLargeUpdate(dml, new int[] {1}));
      assertEquals(0, statement.executeLargeUpdate(DDL, new int[] {1}));
      assertEquals(0, statement.executeLargeUpdate(clientSideUpdate, new int[] {1}));
      assertEquals(LARGE_UPDATE_COUNT, statement.executeLargeUpdate(largeDml, new int[] {1}));
      verifyException(() -> statement.executeLargeUpdate(query, new int[] {1}));
      verifyException(() -> statement.executeLargeUpdate(dmlReturning, new int[] {1}));
      verifyException(() -> statement.executeLargeUpdate(clientSideQuery, new int[] {1}));
    }
  }

  @Test
  public void testStatementExecute() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      verifyUpdateCount(statement, () -> statement.execute(dml), 1L);
      verifyUpdateCount(statement, () -> statement.execute(largeDml), LARGE_UPDATE_COUNT);
      verifyUpdateCount(statement, () -> statement.execute(DDL), Statement.SUCCESS_NO_INFO);
      verifyUpdateCount(
          statement, () -> statement.execute(clientSideUpdate), Statement.SUCCESS_NO_INFO);
      verifyResultSet(statement, () -> statement.execute(query));
      verifyResultSet(statement, () -> statement.execute(dmlReturning));
      verifyResultSet(statement, () -> statement.execute(clientSideQuery));
    }
  }

  @Test
  public void testStatementExecuteReturnGeneratedKeys() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      // TODO: Add tests for RETURN_GENERATED_KEYS when that is supported.
      verifyUpdateCount(statement, () -> statement.execute(dml, Statement.NO_GENERATED_KEYS), 1L);
      verifyUpdateCount(
          statement,
          () -> statement.execute(largeDml, Statement.NO_GENERATED_KEYS),
          LARGE_UPDATE_COUNT);
      verifyUpdateCount(
          statement,
          () -> statement.execute(DDL, Statement.NO_GENERATED_KEYS),
          Statement.SUCCESS_NO_INFO);
      verifyUpdateCount(
          statement,
          () -> statement.execute(clientSideUpdate, Statement.NO_GENERATED_KEYS),
          Statement.SUCCESS_NO_INFO);
      verifyResultSet(statement, () -> statement.execute(query, Statement.NO_GENERATED_KEYS));
      verifyResultSet(
          statement, () -> statement.execute(dmlReturning, Statement.NO_GENERATED_KEYS));
      verifyResultSet(
          statement, () -> statement.execute(clientSideQuery, Statement.NO_GENERATED_KEYS));
    }
  }

  @Test
  public void testStatementExecuteReturnColumnNames() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      verifyUpdateCount(statement, () -> statement.execute(dml, new String[] {"id"}), 1L);
      verifyUpdateCount(
          statement, () -> statement.execute(largeDml, new String[] {"id"}), LARGE_UPDATE_COUNT);
      verifyUpdateCount(
          statement, () -> statement.execute(DDL, new String[] {"id"}), Statement.SUCCESS_NO_INFO);
      verifyUpdateCount(
          statement,
          () -> statement.execute(clientSideUpdate, new String[] {"id"}),
          Statement.SUCCESS_NO_INFO);
      verifyResultSet(statement, () -> statement.execute(query, new String[] {"id"}));
      verifyResultSet(statement, () -> statement.execute(dmlReturning, new String[] {"id"}));
      verifyResultSet(statement, () -> statement.execute(clientSideQuery, new String[] {"id"}));
    }
  }

  @Test
  public void testStatementExecuteReturnColumnIndexes() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      verifyUpdateCount(statement, () -> statement.execute(dml, new int[] {1}), 1L);
      verifyUpdateCount(
          statement, () -> statement.execute(largeDml, new int[] {1}), LARGE_UPDATE_COUNT);
      verifyUpdateCount(
          statement, () -> statement.execute(DDL, new int[] {1}), Statement.SUCCESS_NO_INFO);
      verifyUpdateCount(
          statement,
          () -> statement.execute(clientSideUpdate, new int[] {1}),
          Statement.SUCCESS_NO_INFO);
      verifyResultSet(statement, () -> statement.execute(query, new int[] {1}));
      verifyResultSet(statement, () -> statement.execute(dmlReturning, new int[] {1}));
      verifyResultSet(statement, () -> statement.execute(clientSideQuery, new int[] {1}));
    }
  }

  @Test
  public void testPreparedStatementExecuteQuery() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      try (ResultSet resultSet = connection.prepareStatement(query).executeQuery()) {
        verifyResultSet(resultSet);
      }
      try (ResultSet resultSet = connection.prepareStatement(dmlReturning).executeQuery()) {
        verifyResultSet(resultSet);
      }
      try (ResultSet resultSet = connection.prepareStatement(clientSideQuery).executeQuery()) {
        verifyClientSideResultSet(resultSet);
      }
      verifyException(() -> connection.prepareStatement(dml).executeQuery());
      verifyException(() -> connection.prepareStatement(largeDml).executeQuery());
      verifyException(() -> connection.prepareStatement(DDL).executeQuery());
      verifyException(() -> connection.prepareStatement(clientSideUpdate).executeQuery());
    }
  }

  @Test
  public void testPreparedStatementExecuteUpdate() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      assertEquals(1, connection.prepareStatement(dml).executeUpdate());
      assertEquals(0, connection.prepareStatement(DDL).executeUpdate());
      assertEquals(0, connection.prepareStatement(clientSideUpdate).executeUpdate());
      verifyOverflow(() -> connection.prepareStatement(largeDml).executeUpdate());
      verifyException(() -> connection.prepareStatement(query).executeUpdate());
      verifyException(
          () -> connection.prepareStatement(dmlReturning).executeUpdate(), Code.INVALID_ARGUMENT);
      verifyException(() -> connection.prepareStatement(clientSideQuery).executeUpdate());
    }
  }

  @Test
  public void testPreparedStatementExecuteUpdateReturnGeneratedKeys() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      // TODO: Add tests for RETURN_GENERATED_KEYS when that is supported.
      assertEquals(
          1, connection.prepareStatement(dml, Statement.NO_GENERATED_KEYS).executeUpdate());
      assertEquals(
          0, connection.prepareStatement(DDL, Statement.NO_GENERATED_KEYS).executeUpdate());
      assertEquals(
          0,
          connection
              .prepareStatement(clientSideUpdate, Statement.NO_GENERATED_KEYS)
              .executeUpdate());
      verifyOverflow(
          () -> connection.prepareStatement(largeDml, Statement.NO_GENERATED_KEYS).executeUpdate());
      verifyException(
          () -> connection.prepareStatement(query, Statement.NO_GENERATED_KEYS).executeUpdate());
      verifyException(
          () ->
              connection
                  .prepareStatement(dmlReturning, Statement.NO_GENERATED_KEYS)
                  .executeUpdate(),
          Code.INVALID_ARGUMENT);
      verifyException(
          () ->
              connection
                  .prepareStatement(clientSideQuery, Statement.NO_GENERATED_KEYS)
                  .executeUpdate());
    }
  }

  @Test
  public void testPreparedStatementExecuteUpdateReturnColumnNames() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      assertEquals(1, connection.prepareStatement(dml, new String[] {"id"}).executeUpdate());
      assertEquals(0, connection.prepareStatement(DDL, new String[] {"id"}).executeUpdate());
      assertEquals(
          0, connection.prepareStatement(clientSideUpdate, new String[] {"id"}).executeUpdate());
      verifyOverflow(
          () -> connection.prepareStatement(largeDml, new String[] {"id"}).executeUpdate());
      verifyException(
          () -> connection.prepareStatement(query, new String[] {"id"}).executeUpdate(),
          Code.FAILED_PRECONDITION);
      assertEquals(
          1, connection.prepareStatement(dmlReturning, new String[] {"id"}).executeUpdate());
      verifyException(
          () -> connection.prepareStatement(clientSideQuery, new String[] {"id"}).executeUpdate(),
          Code.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testPreparedStatementExecuteUpdateReturnColumnIndexes() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      assertEquals(1, connection.prepareStatement(dml, new int[] {1}).executeUpdate());
      assertEquals(0, connection.prepareStatement(DDL, new int[] {1}).executeUpdate());
      assertEquals(0, connection.prepareStatement(clientSideUpdate, new int[] {1}).executeUpdate());
      verifyOverflow(() -> connection.prepareStatement(largeDml, new int[] {1}).executeUpdate());
      verifyException(() -> connection.prepareStatement(query, new int[] {1}).executeUpdate());
      verifyException(
          () -> connection.prepareStatement(dmlReturning, new int[] {1}).executeUpdate(),
          Code.INVALID_ARGUMENT);
      verifyException(
          () -> connection.prepareStatement(clientSideQuery, new int[] {1}).executeUpdate());
    }
  }

  @Test
  public void testPreparedStatementLargeExecuteUpdate() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      assertEquals(1L, connection.prepareStatement(dml).executeLargeUpdate());
      assertEquals(0L, connection.prepareStatement(DDL).executeLargeUpdate());
      assertEquals(0L, connection.prepareStatement(clientSideUpdate).executeLargeUpdate());
      assertEquals(LARGE_UPDATE_COUNT, connection.prepareStatement(largeDml).executeLargeUpdate());
      verifyException(() -> connection.prepareStatement(query).executeLargeUpdate());
      verifyException(
          () -> connection.prepareStatement(dmlReturning).executeLargeUpdate(),
          Code.INVALID_ARGUMENT);
      verifyException(() -> connection.prepareStatement(clientSideQuery).executeLargeUpdate());
    }
  }

  @Test
  public void testPreparedStatementExecuteLargeUpdateReturnGeneratedKeys() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      // TODO: Add tests for RETURN_GENERATED_KEYS when that is supported.
      assertEquals(
          1, connection.prepareStatement(dml, Statement.NO_GENERATED_KEYS).executeLargeUpdate());
      assertEquals(
          0, connection.prepareStatement(DDL, Statement.NO_GENERATED_KEYS).executeLargeUpdate());
      assertEquals(
          0,
          connection
              .prepareStatement(clientSideUpdate, Statement.NO_GENERATED_KEYS)
              .executeLargeUpdate());
      assertEquals(
          LARGE_UPDATE_COUNT,
          connection.prepareStatement(largeDml, Statement.NO_GENERATED_KEYS).executeLargeUpdate());
      verifyException(
          () ->
              connection.prepareStatement(query, Statement.NO_GENERATED_KEYS).executeLargeUpdate());
      verifyException(
          () ->
              connection
                  .prepareStatement(dmlReturning, Statement.NO_GENERATED_KEYS)
                  .executeLargeUpdate(),
          Code.INVALID_ARGUMENT);
      verifyException(
          () ->
              connection
                  .prepareStatement(clientSideQuery, Statement.NO_GENERATED_KEYS)
                  .executeLargeUpdate());
    }
  }

  @Test
  public void testPreparedStatementExecuteLargeUpdateReturnColumnNames() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      assertEquals(1, connection.prepareStatement(dml, new String[] {"id"}).executeLargeUpdate());
      assertEquals(0, connection.prepareStatement(DDL, new String[] {"id"}).executeLargeUpdate());
      assertEquals(
          0,
          connection.prepareStatement(clientSideUpdate, new String[] {"id"}).executeLargeUpdate());
      assertEquals(
          LARGE_UPDATE_COUNT,
          connection.prepareStatement(largeDml, new String[] {"id"}).executeLargeUpdate());
      verifyException(
          () -> connection.prepareStatement(query, new String[] {"id"}).executeLargeUpdate(),
          Code.FAILED_PRECONDITION);
      assertEquals(
          1L, connection.prepareStatement(dmlReturning, new String[] {"id"}).executeLargeUpdate());
      verifyException(
          () ->
              connection
                  .prepareStatement(clientSideQuery, new String[] {"id"})
                  .executeLargeUpdate(),
          Code.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testPreparedStatementExecuteLargeUpdateReturnColumnIndexes() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      assertEquals(1, connection.prepareStatement(dml, new int[] {1}).executeLargeUpdate());
      assertEquals(0, connection.prepareStatement(DDL, new int[] {1}).executeLargeUpdate());
      assertEquals(
          0, connection.prepareStatement(clientSideUpdate, new int[] {1}).executeLargeUpdate());
      assertEquals(
          LARGE_UPDATE_COUNT,
          connection.prepareStatement(largeDml, new int[] {1}).executeLargeUpdate());
      verifyException(() -> connection.prepareStatement(query, new int[] {1}).executeLargeUpdate());
      verifyException(
          () -> connection.prepareStatement(dmlReturning, new int[] {1}).executeLargeUpdate(),
          Code.INVALID_ARGUMENT);
      verifyException(
          () -> connection.prepareStatement(clientSideQuery, new int[] {1}).executeLargeUpdate());
    }
  }

  @Test
  public void testPreparedStatementExecute() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      verifyPreparedUpdateCount(connection.prepareStatement(dml), PreparedStatement::execute, 1L);
      verifyPreparedUpdateCount(
          connection.prepareStatement(largeDml), PreparedStatement::execute, LARGE_UPDATE_COUNT);
      verifyPreparedUpdateCount(
          connection.prepareStatement(DDL), PreparedStatement::execute, Statement.SUCCESS_NO_INFO);
      verifyPreparedUpdateCount(
          connection.prepareStatement(clientSideUpdate),
          PreparedStatement::execute,
          Statement.SUCCESS_NO_INFO);
      verifyPreparedResultSet(connection.prepareStatement(query), PreparedStatement::execute);
      verifyPreparedResultSet(
          connection.prepareStatement(dmlReturning), PreparedStatement::execute);
      verifyPreparedResultSet(
          connection.prepareStatement(clientSideQuery), PreparedStatement::execute);
    }
  }

  @Test
  public void testPreparedStatementExecuteReturnGeneratedKeys() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      // TODO: Add tests for RETURN_GENERATED_KEYS when that is supported.
      verifyPreparedUpdateCount(
          connection.prepareStatement(dml, Statement.NO_GENERATED_KEYS),
          PreparedStatement::execute,
          1L);
      verifyPreparedUpdateCount(
          connection.prepareStatement(largeDml, Statement.NO_GENERATED_KEYS),
          PreparedStatement::execute,
          LARGE_UPDATE_COUNT);
      verifyPreparedUpdateCount(
          connection.prepareStatement(DDL, Statement.NO_GENERATED_KEYS),
          PreparedStatement::execute,
          Statement.SUCCESS_NO_INFO);
      verifyPreparedUpdateCount(
          connection.prepareStatement(clientSideUpdate, Statement.NO_GENERATED_KEYS),
          PreparedStatement::execute,
          Statement.SUCCESS_NO_INFO);
      verifyPreparedResultSet(
          connection.prepareStatement(query, Statement.NO_GENERATED_KEYS),
          PreparedStatement::execute);
      verifyPreparedResultSet(
          connection.prepareStatement(dmlReturning, Statement.NO_GENERATED_KEYS),
          PreparedStatement::execute);
      verifyPreparedResultSet(
          connection.prepareStatement(clientSideQuery, Statement.NO_GENERATED_KEYS),
          PreparedStatement::execute);
    }
  }

  @Test
  public void testPreparedStatementExecuteReturnColumnNames() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      verifyPreparedUpdateCount(
          connection.prepareStatement(dml, new String[] {"id"}), PreparedStatement::execute, 1L);
      verifyPreparedUpdateCount(
          connection.prepareStatement(largeDml, new String[] {"id"}),
          PreparedStatement::execute,
          LARGE_UPDATE_COUNT);
      verifyPreparedUpdateCount(
          connection.prepareStatement(DDL, new String[] {"id"}),
          PreparedStatement::execute,
          Statement.SUCCESS_NO_INFO);
      verifyPreparedUpdateCount(
          connection.prepareStatement(clientSideUpdate, new String[] {"id"}),
          PreparedStatement::execute,
          Statement.SUCCESS_NO_INFO);
      verifyPreparedResultSet(
          connection.prepareStatement(query, new String[] {"id"}), PreparedStatement::execute);
      verifyPreparedResultSet(
          connection.prepareStatement(dmlReturning, new String[] {"id"}),
          PreparedStatement::execute);
      verifyPreparedResultSet(
          connection.prepareStatement(clientSideQuery, new String[] {"id"}),
          PreparedStatement::execute);
    }
  }

  @Test
  public void testPreparedStatementExecuteReturnColumnIndexes() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      verifyPreparedUpdateCount(
          connection.prepareStatement(dml, new int[] {1}), PreparedStatement::execute, 1L);
      verifyPreparedUpdateCount(
          connection.prepareStatement(largeDml, new int[] {1}),
          PreparedStatement::execute,
          LARGE_UPDATE_COUNT);
      verifyPreparedUpdateCount(
          connection.prepareStatement(DDL, new int[] {1}),
          PreparedStatement::execute,
          Statement.SUCCESS_NO_INFO);
      verifyPreparedUpdateCount(
          connection.prepareStatement(clientSideUpdate, new int[] {1}),
          PreparedStatement::execute,
          Statement.SUCCESS_NO_INFO);
      verifyPreparedResultSet(
          connection.prepareStatement(query, new int[] {1}), PreparedStatement::execute);
      verifyPreparedResultSet(
          connection.prepareStatement(dmlReturning, new int[] {1}), PreparedStatement::execute);
      verifyPreparedResultSet(
          connection.prepareStatement(clientSideQuery, new int[] {1}), PreparedStatement::execute);
    }
  }

  private void verifyClientSideResultSet(ResultSet resultSet) throws SQLException {
    assertNotNull(resultSet.getMetaData());
    assertEquals(1, resultSet.getMetaData().getColumnCount());
    assertTrue(resultSet.next());
    assertFalse(resultSet.getBoolean(1));
    assertFalse(resultSet.next());
  }

  private void verifyResultSet(ResultSet resultSet) throws SQLException {
    assertNotNull(resultSet.getMetaData());
    assertEquals(2, resultSet.getMetaData().getColumnCount());
    assertTrue(resultSet.next());
    assertFalse(resultSet.next());
  }

  private void verifyException(ThrowingRunnable runnable) {
    verifyException(runnable, Code.INVALID_ARGUMENT);
  }

  private void verifyOverflow(ThrowingRunnable runnable) {
    verifyException(runnable, Code.OUT_OF_RANGE);
  }

  private void verifyException(ThrowingRunnable runnable, Code code) {
    SQLException exception = assertThrows(SQLException.class, runnable);
    assertTrue(exception instanceof JdbcSqlException);
    JdbcSqlException sqlException = (JdbcSqlException) exception;
    assertEquals(code, sqlException.getCode());
  }

  interface ThrowingFunction<T> {
    T apply() throws SQLException;
  }

  interface ThrowingPreparedFunction<T> {
    T apply(PreparedStatement statement) throws SQLException;
  }

  private void verifyPreparedUpdateCount(
      PreparedStatement statement, ThrowingPreparedFunction<Boolean> function, long updateCount)
      throws SQLException {
    verifyUpdateCount(statement, () -> function.apply(statement), updateCount);
  }

  private void verifyUpdateCount(
      Statement statement, ThrowingFunction<Boolean> function, long updateCount)
      throws SQLException {
    assertFalse(function.apply());
    if (updateCount > Integer.MAX_VALUE) {
      verifyOverflow(statement::getUpdateCount);
    } else {
      assertEquals((int) updateCount, statement.getUpdateCount());
    }
    assertEquals(updateCount, statement.getLargeUpdateCount());
    assertNull(statement.getResultSet());
    assertFalse(statement.getMoreResults());
    assertEquals(-1, statement.getUpdateCount());
    assertEquals(-1L, statement.getLargeUpdateCount());
  }

  private void verifyPreparedResultSet(
      PreparedStatement statement, ThrowingPreparedFunction<Boolean> function) throws SQLException {
    verifyResultSet(statement, () -> function.apply(statement));
  }

  private void verifyResultSet(Statement statement, ThrowingFunction<Boolean> function)
      throws SQLException {
    assertTrue(function.apply());
    assertEquals(-1, statement.getUpdateCount());
    assertEquals(-1L, statement.getLargeUpdateCount());
    assertNotNull(statement.getResultSet());
    try (ResultSet resultSet = statement.getResultSet()) {
      assertTrue(resultSet.next());
      assertFalse(resultSet.next());
    }

    assertFalse(statement.getMoreResults());
    assertEquals(-1, statement.getUpdateCount());
    assertEquals(-1L, statement.getLargeUpdateCount());
  }

  @Test
  public void testInvalidExecuteUpdate_shouldNotLeakSession() throws SQLException {
    int maxSessions = 1;
    try (Connection connection =
        new JdbcConnection(
            createUrl(),
            ConnectionOptions.newBuilder()
                .setUri(createUrl().substring("jdbc:".length()))
                .setSessionPoolOptions(
                    SessionPoolOptions.newBuilder()
                        .setMinSessions(1)
                        .setMaxSessions(maxSessions)
                        .setFailIfPoolExhausted()
                        .build())
                .build())) {

      for (int i = 0; i < (maxSessions + 1); i++) {
        SQLException exception =
            assertThrows(
                SQLException.class, () -> connection.createStatement().executeUpdate(query));
        assertTrue(exception instanceof JdbcSqlException);
        JdbcSqlException jdbcSqlException = (JdbcSqlException) exception;
        // This would be RESOURCE_EXHAUSTED if the query leaked a session.
        assertEquals(Code.INVALID_ARGUMENT, jdbcSqlException.getCode());
      }
    }
  }

  private String getExtension() {
    return dialect == Dialect.POSTGRESQL ? "spanner." : "";
  }

  @Test
  public void testExecuteAutoBatchDml() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      connection.setAutoCommit(false);

      assertFalse(statement.execute(String.format("set %sauto_batch_dml = true", getExtension())));
      for (int i = 0; i < 3; i++) {
        assertFalse(statement.execute(dml));
        assertEquals(1, statement.getUpdateCount());
      }
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(3, request.getStatementsCount());
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testLastStatement_AutoCommit_Query() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      //noinspection EmptyTryBlock
      try (ResultSet ignore = statement.executeQuery(query)) {}
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertFalse(mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0).getLastStatement());
  }

  @Test
  public void testLastStatement_AutoCommit_Dml() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      statement.executeUpdate(dml);
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertTrue(mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0).getLastStatement());
  }

  @Test
  public void testLastStatement_AutoCommit_DmlReturning() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      //noinspection EmptyTryBlock
      try (ResultSet ignore = statement.executeQuery(dmlReturning)) {}
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertTrue(mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0).getLastStatement());
  }

  @Test
  public void testLastStatement_AutoCommit_BatchDml() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      statement.addBatch(dml);
      statement.addBatch(dml);
      statement.executeBatch();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertTrue(
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0).getLastStatements());
  }

  @Test
  public void testLastStatement_Transaction_Query() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      connection.setAutoCommit(false);
      //noinspection EmptyTryBlock
      try (ResultSet ignore = statement.executeQuery(query)) {}
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertFalse(mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0).getLastStatement());
  }

  @Test
  public void testLastStatement_Transaction_Dml() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      connection.setAutoCommit(false);
      statement.executeUpdate(dml);
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertFalse(mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0).getLastStatement());
  }

  @Test
  public void testLastStatement_Transaction_DmlReturning() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      connection.setAutoCommit(false);
      //noinspection EmptyTryBlock
      try (ResultSet ignore = statement.executeQuery(dmlReturning)) {}
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertFalse(mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0).getLastStatement());
  }

  @Test
  public void testLastStatement_Transaction_BatchDml() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      connection.setAutoCommit(false);
      statement.addBatch(dml);
      statement.addBatch(dml);
      statement.executeBatch();
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertFalse(
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0).getLastStatements());
  }
}
