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

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.AbstractStatementParser;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParametersInfo;
import com.google.cloud.spanner.connection.SpannerPool;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JdbcDatabaseMetaDataWithMockedServerTest {
  private static final ResultSetMetadata RESULTSET_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("TAB1")
                          .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                          .build())
                  .build())
          .build();
  private static final com.google.spanner.v1.ResultSet RESULTSET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(Value.newBuilder().setStringValue("TAB").build())
                  .build())
          .setMetadata(RESULTSET_METADATA)
          .build();

  @Parameter public Dialect dialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private AbstractStatementParser parser;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    InetSocketAddress address = new InetSocketAddress("localhost", 0);
    server = NettyServerBuilder.forAddress(address).addService(mockSpanner).build().start();
  }

  @AfterClass
  public static void stopServer() throws Exception {
    SpannerPool.closeSpannerPool();
    server.shutdown();
    server.awaitTermination();
  }

  @Before
  public void setup() {
    parser = AbstractStatementParser.getInstance(dialect);
  }

  @After
  public void reset() {
    // Close Spanner pool to prevent reusage of the same Spanner instance (and thereby the same
    // session pool).
    SpannerPool.closeSpannerPool();
    mockSpanner.removeAllExecutionTimes();
    mockSpanner.reset();
  }

  private String createUrl() {
    return String.format(
        "jdbc:cloudspanner://localhost:%d/projects/%s/instances/%s/databases/%s?usePlainText=true",
        server.getPort(), "proj", "inst", "db");
  }

  private Connection createConnection() throws SQLException {
    return DriverManager.getConnection(createUrl());
  }

  @Test
  public void getTablesInDdlBatch() throws SQLException {
    String sql =
        parser.removeCommentsAndTrim(
            JdbcDatabaseMetaData.readSqlFromFile("DatabaseMetaData_GetTables.sql", dialect));
    ParametersInfo params = parser.convertPositionalParametersToNamedParameters('?', sql);
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.newBuilder(params.sqlWithNamedParameters)
                .bind("p1")
                .to("CAT")
                .bind("p2")
                .to("SCH")
                .bind("p3")
                .to("TAB")
                .bind("p4")
                .to("TABLE")
                .bind("p5")
                .to("VIEW")
                .build(),
            RESULTSET));
    try (java.sql.Connection connection = createConnection()) {
      connection.createStatement().execute("START BATCH DDL");
      // Executing an internal metadata query should be allowed during a DDL batch.
      // This query will be executed on a single use read-only transaction.
      try (ResultSet tables = connection.getMetaData().getTables("CAT", "SCH", "TAB", null)) {
        //noinspection StatementWithEmptyBody
        while (tables.next()) {}
      }
      connection.createStatement().execute("CREATE TABLE FOO");
      connection.createStatement().execute("ABORT BATCH");
    }
  }

  @Test
  public void getColumnsInDdlBatch() throws SQLException {
    String sql =
        parser.removeCommentsAndTrim(
            JdbcDatabaseMetaData.readSqlFromFile("DatabaseMetaData_GetColumns.sql", dialect));
    ParametersInfo params = parser.convertPositionalParametersToNamedParameters('?', sql);
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.newBuilder(params.sqlWithNamedParameters)
                .bind("p1")
                .to("CAT")
                .bind("p2")
                .to("SCH")
                .bind("p3")
                .to("TAB")
                .bind("p4")
                .to("%")
                .build(),
            RESULTSET));
    try (java.sql.Connection connection = createConnection()) {
      connection.createStatement().execute("START BATCH DDL");
      try (ResultSet tables = connection.getMetaData().getColumns("CAT", "SCH", "TAB", null)) {
        //noinspection StatementWithEmptyBody
        while (tables.next()) {}
      }
      connection.createStatement().execute("CREATE TABLE FOO");
      connection.createStatement().execute("ABORT BATCH");
    }
  }

  @Test
  public void getKeysInDdlBatch() throws SQLException {
    for (String fileName :
        new String[] {
          "DatabaseMetaData_GetPrimaryKeys.sql",
          "DatabaseMetaData_GetImportedKeys.sql",
          "DatabaseMetaData_GetExportedKeys.sql"
        }) {
      String sql =
          parser.removeCommentsAndTrim(JdbcDatabaseMetaData.readSqlFromFile(fileName, dialect));
      ParametersInfo params = parser.convertPositionalParametersToNamedParameters('?', sql);
      mockSpanner.putStatementResult(
          StatementResult.query(
              Statement.newBuilder(params.sqlWithNamedParameters)
                  .bind("p1")
                  .to("CAT")
                  .bind("p2")
                  .to("SCH")
                  .bind("p3")
                  .to("TAB")
                  .build(),
              RESULTSET));
    }
    try (java.sql.Connection connection = createConnection()) {
      connection.createStatement().execute("START BATCH DDL");
      try (ResultSet tables = connection.getMetaData().getPrimaryKeys("CAT", "SCH", "TAB")) {
        //noinspection StatementWithEmptyBody
        while (tables.next()) {}
      }
      try (ResultSet tables = connection.getMetaData().getImportedKeys("CAT", "SCH", "TAB")) {
        //noinspection StatementWithEmptyBody
        while (tables.next()) {}
      }
      try (ResultSet tables = connection.getMetaData().getExportedKeys("CAT", "SCH", "TAB")) {
        //noinspection StatementWithEmptyBody
        while (tables.next()) {}
      }
      connection.createStatement().execute("CREATE TABLE FOO");
      connection.createStatement().execute("ABORT BATCH");
    }
  }

  @Test
  public void getCrossReferencesInDdlBatch() throws SQLException {
    String sql =
        parser.removeCommentsAndTrim(
            JdbcDatabaseMetaData.readSqlFromFile(
                "DatabaseMetaData_GetCrossReferences.sql", dialect));
    ParametersInfo params = parser.convertPositionalParametersToNamedParameters('?', sql);
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.newBuilder(params.sqlWithNamedParameters)
                .bind("p1")
                .to("CAT")
                .bind("p2")
                .to("SCH")
                .bind("p3")
                .to("TAB")
                .bind("p4")
                .to("CAT2")
                .bind("p5")
                .to("SCH2")
                .bind("p6")
                .to("TAB2")
                .build(),
            RESULTSET));
    try (java.sql.Connection connection = createConnection()) {
      connection.createStatement().execute("START BATCH DDL");
      try (ResultSet tables =
          connection.getMetaData().getCrossReference("CAT", "SCH", "TAB", "CAT2", "SCH2", "TAB2")) {
        //noinspection StatementWithEmptyBody
        while (tables.next()) {}
      }
      connection.createStatement().execute("CREATE TABLE FOO");
      connection.createStatement().execute("ABORT BATCH");
    }
  }

  @Test
  public void getIndexInfoInDdlBatch() throws SQLException {
    String sql =
        parser.removeCommentsAndTrim(
            JdbcDatabaseMetaData.readSqlFromFile("DatabaseMetaData_GetIndexInfo.sql", dialect));
    ParametersInfo params = parser.convertPositionalParametersToNamedParameters('?', sql);
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.newBuilder(params.sqlWithNamedParameters)
                .bind("p1")
                .to("CAT")
                .bind("p2")
                .to("SCH")
                .bind("p3")
                .to("TAB")
                .bind("p4")
                .to("%")
                .bind("p5")
                .to("YES")
                .build(),
            RESULTSET));
    try (java.sql.Connection connection = createConnection()) {
      connection.createStatement().execute("START BATCH DDL");
      try (ResultSet tables =
          connection.getMetaData().getIndexInfo("CAT", "SCH", "TAB", true, false)) {
        //noinspection StatementWithEmptyBody
        while (tables.next()) {}
      }
      connection.createStatement().execute("CREATE TABLE FOO");
      connection.createStatement().execute("ABORT BATCH");
    }
  }

  @Test
  public void getSchemasInDdlBatch() throws SQLException {
    String sql =
        parser.removeCommentsAndTrim(
            JdbcDatabaseMetaData.readSqlFromFile("DatabaseMetaData_GetSchemas.sql", dialect));
    ParametersInfo params = parser.convertPositionalParametersToNamedParameters('?', sql);
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.newBuilder(params.sqlWithNamedParameters)
                .bind("p1")
                .to("%")
                .bind("p2")
                .to("%")
                .build(),
            RESULTSET));
    try (java.sql.Connection connection = createConnection()) {
      connection.createStatement().execute("START BATCH DDL");
      try (ResultSet tables = connection.getMetaData().getSchemas()) {
        //noinspection StatementWithEmptyBody
        while (tables.next()) {}
      }
      try (ResultSet tables = connection.getMetaData().getSchemas(null, null)) {
        //noinspection StatementWithEmptyBody
        while (tables.next()) {}
      }
      connection.createStatement().execute("CREATE TABLE FOO");
      connection.createStatement().execute("ABORT BATCH");
    }
  }
}
