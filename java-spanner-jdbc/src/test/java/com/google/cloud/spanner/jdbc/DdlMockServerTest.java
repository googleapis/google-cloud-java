/*
 * Copyright 2024 Google LLC
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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.common.collect.ImmutableList;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.rpc.Code;
import com.google.spanner.admin.database.v1.GetDatabaseDdlResponse;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DdlMockServerTest extends AbstractMockServerTest {

  private String createUrl(boolean autoCommit) {
    return String.format(
        "jdbc:cloudspanner://localhost:%d/projects/%s/instances/%s/databases/%s?usePlainText=true;autoCommit=%s",
        getPort(), "proj", "inst", "db", autoCommit);
  }

  private Connection createConnection(boolean autoCommit) throws SQLException {
    return DriverManager.getConnection(createUrl(autoCommit));
  }

  @Test
  public void testGetDatabaseDdl() throws SQLException {
    List<String> expectedDdl =
        ImmutableList.of(
            "create table foo (id int64) primary key (id)",
            "create table bar (id int64) primary key (id)");
    mockDatabaseAdmin.addResponse(
        GetDatabaseDdlResponse.newBuilder().addAllStatements(expectedDdl).build());

    try (Connection connection = createConnection(/* autoCommit= */ true)) {
      CloudSpannerJdbcConnection spannerJdbcConnection =
          connection.unwrap(CloudSpannerJdbcConnection.class);
      List<String> ddl =
          spannerJdbcConnection
              .getSpanner()
              .getDatabaseAdminClient()
              .getDatabaseDdl(
                  spannerJdbcConnection.getDatabaseId().getInstanceId().getInstance(),
                  spannerJdbcConnection.getDatabaseId().getDatabase());
      assertEquals(expectedDdl, ddl);
    }
  }

  @Test
  public void testDdlInAutoCommitIsTrue_succeeds() throws SQLException {
    mockDatabaseAdmin.addResponse(
        Operation.newBuilder()
            .setDone(true)
            .setResponse(Any.pack(Empty.getDefaultInstance()))
            .setMetadata(Any.pack(UpdateDatabaseDdlMetadata.getDefaultInstance()))
            .build());

    try (Connection connection = createConnection(/* autoCommit= */ true)) {
      assertFalse(
          connection.createStatement().execute("create table foo (id int64) primary key (id)"));
    }
  }

  @Test
  public void testDdlInAutoCommitIsFalse_succeedsWithNoActiveTransaction() throws SQLException {
    mockDatabaseAdmin.addResponse(
        Operation.newBuilder()
            .setDone(true)
            .setResponse(Any.pack(Empty.getDefaultInstance()))
            .setMetadata(Any.pack(UpdateDatabaseDdlMetadata.getDefaultInstance()))
            .build());

    try (Connection connection = createConnection(/* autoCommit= */ false)) {
      assertFalse(
          connection.createStatement().execute("create table foo (id int64) primary key (id)"));
    }
  }

  @Test
  public void testDdlInAutoCommitIsFalse_failsWithActiveTransaction() throws SQLException {
    mockSpanner.putStatementResult(
        StatementResult.update(Statement.of("update foo set bar=1 where true"), 1L));

    try (Connection connection = createConnection(/* autoCommit= */ false)) {
      assertFalse(connection.createStatement().execute("update foo set bar=1 where true"));
      SQLException exception =
          assertThrows(
              SQLException.class,
              () ->
                  connection
                      .createStatement()
                      .execute("create table foo (id int64) primary key (id)"));
      assertTrue(exception instanceof JdbcSqlException);
      JdbcSqlException jdbcSqlException = (JdbcSqlException) exception;
      assertEquals(Code.FAILED_PRECONDITION, jdbcSqlException.getCode());
    }
  }

  @Test
  public void testDdlUsingStatementAndExecuteUpdate() throws SQLException {
    for (boolean autoCommit : new boolean[] {true, false}) {
      mockDatabaseAdmin.addResponse(
          Operation.newBuilder()
              .setDone(true)
              .setResponse(Any.pack(Empty.getDefaultInstance()))
              .setMetadata(Any.pack(UpdateDatabaseDdlMetadata.getDefaultInstance()))
              .build());

      try (Connection connection = createConnection(autoCommit)) {
        try (java.sql.Statement statement = connection.createStatement()) {
          assertEquals(0, statement.executeUpdate("create table foo (id int64) primary key (id)"));
        }
      }
      assertEquals(1, mockDatabaseAdmin.getRequests().size());
      mockDatabaseAdmin.getRequests().clear();
    }
  }

  @Test
  public void testDdlUsingPreparedStatementAndExecuteUpdate() throws SQLException {
    for (boolean autoCommit : new boolean[] {true, false}) {
      mockDatabaseAdmin.addResponse(
          Operation.newBuilder()
              .setDone(true)
              .setResponse(Any.pack(Empty.getDefaultInstance()))
              .setMetadata(Any.pack(UpdateDatabaseDdlMetadata.getDefaultInstance()))
              .build());

      try (Connection connection = createConnection(autoCommit)) {
        try (PreparedStatement preparedStatement =
            connection.prepareStatement("create table foo (id int64) primary key (id)")) {
          assertEquals(0, preparedStatement.executeUpdate());
        }
      }
      assertEquals(1, mockDatabaseAdmin.getRequests().size());
      mockDatabaseAdmin.getRequests().clear();
    }
  }
}
