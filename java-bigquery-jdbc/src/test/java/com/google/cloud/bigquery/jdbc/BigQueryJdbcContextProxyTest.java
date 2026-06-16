/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.StandardSQLTypeName;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.Test;

public class BigQueryJdbcContextProxyTest {

  @Test
  public void testExtractConnectionIdFromConnection() throws SQLException {
    BigQueryConnection mockConn = mock(BigQueryConnection.class);
    when(mockConn.getConnectionId()).thenReturn("conn-uuid-123");
    when(mockConn.getAutoCommit())
        .thenAnswer(
            invocation -> {
              assertEquals("conn-uuid-123", BigQueryJdbcMdc.getConnectionId());
              return true;
            });

    Connection proxy = BigQueryJdbcContextProxy.wrap(mockConn, Connection.class);
    assertNotNull(proxy);

    // Verify active thread-local context is set during method invocation
    assertTrue(proxy.getAutoCommit());
    // Verify context is cleanly cleared after method exit
    assertNull(BigQueryJdbcMdc.getConnectionId());
  }

  @Test
  public void testExtractConnectionIdFromStatement() throws SQLException {
    BigQueryConnection mockConn = mock(BigQueryConnection.class);
    when(mockConn.getBigQuery()).thenReturn(mock(com.google.cloud.bigquery.BigQuery.class));

    BigQueryStatement stmt = new BigQueryStatement(mockConn);
    stmt.connectionId = "conn-uuid-456";

    Statement proxy = BigQueryJdbcContextProxy.wrap(stmt, Statement.class, "conn-uuid-456");
    assertNotNull(proxy);

    // We can call any statement method (like getUpdateCount) and verify context routing
    // by asserting the thread-local value during invocation, but since it's a real object,
    // it runs cleanly. Let's assert that no thread-local leaks exist.
    assertEquals(-1, proxy.getUpdateCount());
    assertNull(BigQueryJdbcMdc.getConnectionId());
  }

  @Test
  public void testExtractConnectionIdFromDatabaseMetaData() throws SQLException {
    BigQueryConnection mockConn = mock(BigQueryConnection.class);
    when(mockConn.getConnectionId()).thenReturn("conn-uuid-789");
    when(mockConn.getBigQuery()).thenReturn(mock(com.google.cloud.bigquery.BigQuery.class));

    BigQueryDatabaseMetaData meta = new BigQueryDatabaseMetaData(mockConn);

    DatabaseMetaData proxy =
        BigQueryJdbcContextProxy.wrap(meta, DatabaseMetaData.class, "conn-uuid-789");
    assertNotNull(proxy);

    // Assert read-only capability does not leak thread context
    assertFalse(proxy.isReadOnly());
    assertNull(BigQueryJdbcMdc.getConnectionId());
  }

  @Test
  public void testExtractConnectionIdFromResultSetMetaData() throws SQLException {
    BigQueryConnection mockConn = mock(BigQueryConnection.class);
    BigQueryStatement stmt = new BigQueryStatement(mockConn);
    stmt.connectionId = "conn-uuid-999";

    FieldList fields = FieldList.of(Field.of("col", StandardSQLTypeName.STRING));
    BigQueryResultSetMetadata meta = BigQueryResultSetMetadata.of(fields, stmt);

    ResultSetMetaData proxy =
        BigQueryJdbcContextProxy.wrap(meta, ResultSetMetaData.class, "conn-uuid-999");
    assertNotNull(proxy);

    assertEquals(1, proxy.getColumnCount());
    assertNull(BigQueryJdbcMdc.getConnectionId());
  }

  @Test
  public void testWrapWithNullContextAndExceptionThrown() throws SQLException {
    BigQueryStatement mockStmt = mock(BigQueryStatement.class);
    mockStmt.connectionId = null;
    when(mockStmt.executeQuery("SELECT *")).thenThrow(new SQLException("Database error"));

    Statement proxy = BigQueryJdbcContextProxy.wrap(mockStmt, Statement.class, null);
    assertNotNull(proxy);

    SQLException ex = assertThrows(SQLException.class, () -> proxy.executeQuery("SELECT *"));
    assertEquals("Database error", ex.getMessage());
    assertNull(BigQueryJdbcMdc.getConnectionId());
  }
}
