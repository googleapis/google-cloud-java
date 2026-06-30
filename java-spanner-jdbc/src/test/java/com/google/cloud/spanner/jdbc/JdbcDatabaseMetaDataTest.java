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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.connection.ConnectionOptionsTest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JdbcDatabaseMetaDataTest {
  @Parameter public Dialect dialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  private static final String DEFAULT_CATALOG = "";
  private static final String DEFAULT_SCHEMA = "";
  private static final String TEST_TABLE = "FOO";
  private static final int DATABASE_MAJOR_VERSION = 1;
  private static final int DATABASE_MINOR_VERSION = 0;
  private static final String DATABASE_PRODUCT_NAME = "Google Cloud Spanner";
  private static final String POSTGRESQL_DATABASE_PRODUCT_NAME =
      DATABASE_PRODUCT_NAME + " PostgreSQL";

  @Test
  public void testTrivialMethods() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    when(connection.getDialect()).thenReturn(dialect);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    assertTrue(meta.allProceduresAreCallable());
    assertTrue(meta.allTablesAreSelectable());
    assertFalse(meta.autoCommitFailureClosesAllResultSets());
    assertFalse(meta.dataDefinitionCausesTransactionCommit());
    assertFalse(meta.dataDefinitionIgnoredInTransactions());
    for (int type :
        new int[] {
          ResultSet.TYPE_FORWARD_ONLY,
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.TYPE_SCROLL_SENSITIVE
        }) {
      assertFalse(meta.deletesAreDetected(type));
      assertFalse(meta.insertsAreDetected(type));
      assertFalse(meta.updatesAreDetected(type));
      assertFalse(meta.ownDeletesAreVisible(type));
      assertFalse(meta.ownInsertsAreVisible(type));
      assertFalse(meta.ownUpdatesAreVisible(type));
      assertFalse(meta.othersDeletesAreVisible(type));
      assertFalse(meta.othersInsertsAreVisible(type));
      assertFalse(meta.othersUpdatesAreVisible(type));
    }
    assertTrue(meta.doesMaxRowSizeIncludeBlobs());
    assertFalse(meta.generatedKeyAlwaysReturned());
    assertEquals(".", meta.getCatalogSeparator());
    assertEquals("CATALOG", meta.getCatalogTerm());
    assertEquals(DATABASE_MAJOR_VERSION, meta.getDatabaseMajorVersion());
    assertEquals(DATABASE_MINOR_VERSION, meta.getDatabaseMinorVersion());
    assertEquals(
        DATABASE_MAJOR_VERSION + "." + DATABASE_MINOR_VERSION, meta.getDatabaseProductVersion());
    assertEquals(Connection.TRANSACTION_SERIALIZABLE, meta.getDefaultTransactionIsolation());
    assertEquals("com.google.cloud.spanner.jdbc.JdbcDriver", meta.getDriverName());
    assertEquals("", meta.getExtraNameCharacters());
    assertEquals("`", meta.getIdentifierQuoteString());
    assertEquals(4, meta.getJDBCMajorVersion());
    assertEquals(1, meta.getJDBCMinorVersion()); // Java 7 is JDBC 4.1
    assertEquals(0, meta.getMaxBinaryLiteralLength());
    assertEquals(0, meta.getMaxCatalogNameLength());
    assertEquals(0, meta.getMaxCharLiteralLength());
    assertEquals(128, meta.getMaxColumnNameLength());
    assertEquals(1000, meta.getMaxColumnsInGroupBy());
    assertEquals(16, meta.getMaxColumnsInIndex());
    assertEquals(0, meta.getMaxColumnsInOrderBy());
    assertEquals(0, meta.getMaxColumnsInSelect());
    assertEquals(1024, meta.getMaxColumnsInTable());
    assertEquals(0, meta.getMaxConnections());
    assertEquals(0, meta.getMaxCursorNameLength());
    assertEquals(8000, meta.getMaxIndexLength());
    assertEquals(0, meta.getMaxProcedureNameLength());
    assertEquals(0, meta.getMaxRowSize());
    assertEquals(128, meta.getMaxSchemaNameLength());
    assertEquals(1000000, meta.getMaxStatementLength());
    assertEquals(0, meta.getMaxStatements());
    assertEquals(128, meta.getMaxTableNameLength());
    assertEquals(0, meta.getMaxTablesInSelect());
    assertEquals(0, meta.getMaxUserNameLength());
    assertEquals("PROCEDURE", meta.getProcedureTerm());
    assertEquals(ResultSet.CLOSE_CURSORS_AT_COMMIT, meta.getResultSetHoldability());
    assertEquals(RowIdLifetime.ROWID_UNSUPPORTED, meta.getRowIdLifetime());
    assertEquals("SCHEMA", meta.getSchemaTerm());
    assertEquals("\\", meta.getSearchStringEscape());
    assertEquals(DatabaseMetaData.sqlStateSQL, meta.getSQLStateType());
    assertTrue(meta.locatorsUpdateCopy());
    assertFalse(meta.nullsAreSortedHigh());
    assertTrue(meta.nullsAreSortedLow());
    assertFalse(meta.nullsAreSortedAtStart());
    assertFalse(meta.nullsAreSortedAtEnd());
    assertTrue(meta.nullPlusNonNullIsNull());
    assertFalse(meta.isCatalogAtStart());
    assertEquals(connection.isReadOnly(), meta.isReadOnly());
    if (dialect == Dialect.POSTGRESQL) {
      assertEquals(POSTGRESQL_DATABASE_PRODUCT_NAME, meta.getDatabaseProductName());
      assertTrue(meta.storesLowerCaseIdentifiers());
    } else {
      assertEquals(DATABASE_PRODUCT_NAME, meta.getDatabaseProductName());
      assertFalse(meta.storesLowerCaseIdentifiers());
    }
    assertFalse(meta.storesLowerCaseQuotedIdentifiers());
    assertTrue(meta.storesMixedCaseIdentifiers());
    assertTrue(meta.storesMixedCaseQuotedIdentifiers());
    assertFalse(meta.storesUpperCaseIdentifiers());
    assertFalse(meta.storesUpperCaseQuotedIdentifiers());
    assertTrue(meta.supportsAlterTableWithAddColumn());
    assertTrue(meta.supportsAlterTableWithDropColumn());
    assertFalse(meta.supportsANSI92EntryLevelSQL());
    assertFalse(meta.supportsANSI92FullSQL());
    assertFalse(meta.supportsANSI92IntermediateSQL());
    assertTrue(meta.supportsBatchUpdates());
    assertFalse(meta.supportsCatalogsInDataManipulation());
    assertFalse(meta.supportsCatalogsInIndexDefinitions());
    assertFalse(meta.supportsCatalogsInPrivilegeDefinitions());
    assertFalse(meta.supportsCatalogsInProcedureCalls());
    assertFalse(meta.supportsCatalogsInTableDefinitions());
    assertTrue(meta.supportsColumnAliasing());
    // Note that the supportsConvert() method indicates whether the server side function CONVERT is
    // supported, not what the JDBC driver might be able to convert on the client side.
    assertFalse(meta.supportsConvert());
    int[] types =
        new int[] {
          Types.ARRAY,
          Types.BIGINT,
          Types.BINARY,
          Types.BIT,
          Types.BLOB,
          Types.BOOLEAN,
          Types.CHAR,
          Types.CLOB,
          Types.DATALINK,
          Types.DATE,
          Types.DECIMAL,
          Types.DISTINCT,
          Types.DOUBLE,
          Types.FLOAT,
          Types.INTEGER,
          Types.JAVA_OBJECT,
          Types.LONGNVARCHAR,
          Types.LONGVARCHAR,
          Types.LONGVARBINARY,
          Types.LONGVARCHAR,
          Types.NCHAR,
          Types.NCLOB,
          Types.NULL,
          Types.NUMERIC,
          Types.NVARCHAR,
          Types.OTHER,
          Types.REAL,
          Types.REF,
          Types.ROWID,
          Types.SMALLINT,
          Types.SQLXML,
          Types.STRUCT,
          Types.TIME,
          Types.TIMESTAMP,
          Types.TINYINT,
          Types.VARBINARY,
          Types.VARCHAR
        };
    for (int from : types) {
      for (int to : types) {
        assertFalse(meta.supportsConvert(from, to));
      }
    }
    assertFalse(meta.supportsCoreSQLGrammar());
    assertTrue(meta.supportsCorrelatedSubqueries());
    assertFalse(meta.supportsDataDefinitionAndDataManipulationTransactions());
    assertTrue(meta.supportsDataManipulationTransactionsOnly());
    assertFalse(meta.supportsDifferentTableCorrelationNames());
    assertTrue(meta.supportsExpressionsInOrderBy());
    assertFalse(meta.supportsExtendedSQLGrammar());
    assertTrue(meta.supportsFullOuterJoins());
    assertFalse(meta.supportsGetGeneratedKeys());
    assertTrue(meta.supportsGroupBy());
    assertTrue(meta.supportsGroupByBeyondSelect());
    assertTrue(meta.supportsGroupByUnrelated());
    assertFalse(meta.supportsIntegrityEnhancementFacility());
    assertTrue(meta.supportsLikeEscapeClause());
    assertTrue(meta.supportsLimitedOuterJoins());
    assertFalse(meta.supportsMinimumSQLGrammar());
    assertFalse(meta.supportsMixedCaseIdentifiers());
    assertFalse(meta.supportsMixedCaseQuotedIdentifiers());
    assertTrue(meta.supportsMultipleOpenResults());
    assertTrue(meta.supportsMultipleResultSets());
    assertTrue(meta.supportsMultipleTransactions());
    assertFalse(meta.supportsNamedParameters());
    assertTrue(meta.supportsNonNullableColumns());
    assertFalse(meta.supportsOpenCursorsAcrossCommit());
    assertFalse(meta.supportsOpenCursorsAcrossRollback());
    assertTrue(meta.supportsOpenStatementsAcrossCommit());
    assertTrue(meta.supportsOpenStatementsAcrossRollback());
    assertTrue(meta.supportsOrderByUnrelated());
    assertTrue(meta.supportsOuterJoins());
    assertFalse(meta.supportsPositionedDelete());
    assertFalse(meta.supportsPositionedUpdate());
    for (int type :
        new int[] {
          ResultSet.TYPE_FORWARD_ONLY,
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.TYPE_SCROLL_SENSITIVE
        }) {
      assertEquals(type == ResultSet.TYPE_FORWARD_ONLY, meta.supportsResultSetType(type));
      for (int concur : new int[] {ResultSet.CONCUR_READ_ONLY, ResultSet.CONCUR_UPDATABLE}) {
        assertEquals(
            type == ResultSet.TYPE_FORWARD_ONLY && concur == ResultSet.CONCUR_READ_ONLY,
            meta.supportsResultSetConcurrency(type, concur));
      }
    }
    assertTrue(meta.supportsResultSetHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT));
    assertFalse(meta.supportsResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT));
    assertFalse(meta.supportsSavepoints());
    assertTrue(meta.supportsSchemasInDataManipulation());
    assertTrue(meta.supportsSchemasInIndexDefinitions());
    assertTrue(meta.supportsSchemasInPrivilegeDefinitions());
    assertTrue(meta.supportsSchemasInProcedureCalls());
    assertTrue(meta.supportsSchemasInTableDefinitions());
    assertTrue(meta.supportsSelectForUpdate());
    assertFalse(meta.supportsStatementPooling());
    assertFalse(meta.supportsStoredFunctionsUsingCallSyntax());
    assertFalse(meta.supportsStoredProcedures());
    assertTrue(meta.supportsSubqueriesInComparisons());
    assertTrue(meta.supportsSubqueriesInExists());
    assertTrue(meta.supportsSubqueriesInIns());
    assertTrue(meta.supportsSubqueriesInQuantifieds());
    assertTrue(meta.supportsTableCorrelationNames());
    assertTrue(meta.supportsTransactions());
    assertTrue(meta.supportsUnion());
    assertTrue(meta.supportsUnionAll());
    assertFalse(meta.usesLocalFiles());
    assertFalse(meta.usesLocalFilePerTable());
    assertTrue(meta.supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE));
    assertTrue(meta.supportsTransactionIsolationLevel(Connection.TRANSACTION_REPEATABLE_READ));
    for (int level :
        new int[] {
          Connection.TRANSACTION_NONE,
          Connection.TRANSACTION_READ_COMMITTED,
          Connection.TRANSACTION_READ_UNCOMMITTED,
        }) {
      assertFalse(meta.supportsTransactionIsolationLevel(level));
    }
    assertEquals(10485760L, meta.getMaxLogicalLobSize());
    assertFalse(meta.supportsRefCursors());

    // trivial tests that guarantee that the function works, but the return value doesn't matter
    assertNotNull(meta.getNumericFunctions());
    assertNotNull(meta.getSQLKeywords());
    assertNotNull(meta.getStringFunctions());
    assertNotNull(meta.getSystemFunctions());
    assertNotNull(meta.getTimeDateFunctions());
  }

  @Test
  public void testGetAttributes() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getAttributes(DEFAULT_CATALOG, DEFAULT_SCHEMA, TEST_TABLE, null)) {
      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(21, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetBestRowIdentifier() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs =
        meta.getBestRowIdentifier(
            DEFAULT_CATALOG,
            DEFAULT_SCHEMA,
            TEST_TABLE,
            DatabaseMetaData.bestRowTransaction,
            false)) {
      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(8, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetCatalogs() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    when(connection.getDialect()).thenReturn(dialect);
    when(connection.getCatalog()).thenCallRealMethod();
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getCatalogs()) {
      assertTrue(rs.next());
      assertEquals(connection.getDefaultCatalog(), rs.getString("TABLE_CAT"));
      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(1, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetClientInfoProperties() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getClientInfoProperties()) {
      assertTrue(rs.next());
      assertEquals("APPLICATIONNAME", rs.getString("NAME"));
      assertEquals("", rs.getString("DEFAULT_VALUE"));

      assertTrue(rs.next());
      assertEquals("CLIENTHOSTNAME", rs.getString("NAME"));
      assertEquals("", rs.getString("DEFAULT_VALUE"));

      assertTrue(rs.next());
      assertEquals("CLIENTUSER", rs.getString("NAME"));
      assertEquals("", rs.getString("DEFAULT_VALUE"));

      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(4, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetColumnPrivileges() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs =
        meta.getColumnPrivileges(DEFAULT_CATALOG, DEFAULT_SCHEMA, TEST_TABLE, null)) {
      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(8, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetFunctionColumns() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getFunctionColumns(DEFAULT_CATALOG, DEFAULT_SCHEMA, null, null)) {
      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(17, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetFunctions() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getFunctions(DEFAULT_CATALOG, DEFAULT_SCHEMA, null)) {
      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(6, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetProcedureColumns() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getProcedureColumns(DEFAULT_CATALOG, DEFAULT_SCHEMA, null, null)) {
      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(20, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetProcedures() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getProcedures(DEFAULT_CATALOG, DEFAULT_SCHEMA, null)) {
      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(9, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetPseudoColumns() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getPseudoColumns(DEFAULT_CATALOG, DEFAULT_SCHEMA, TEST_TABLE, null)) {
      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(12, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetSuperTables() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getSuperTables(DEFAULT_CATALOG, DEFAULT_SCHEMA, TEST_TABLE)) {
      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(4, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetSuperTypes() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getSuperTypes(DEFAULT_CATALOG, DEFAULT_SCHEMA, null)) {
      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(6, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetTablePrivileges() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getTablePrivileges(DEFAULT_CATALOG, DEFAULT_SCHEMA, TEST_TABLE)) {
      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(7, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetTableTypes() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getTableTypes()) {
      assertTrue(rs.next());
      assertEquals("TABLE", rs.getString("TABLE_TYPE"));
      assertTrue(rs.next());
      assertEquals("VIEW", rs.getString("TABLE_TYPE"));
      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(1, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetTypeInfo() throws SQLException {
    for (Dialect dialect : Dialect.values()) {
      JdbcConnection connection = mock(JdbcConnection.class);
      when(connection.getDialect()).thenReturn(dialect);
      DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
      try (ResultSet rs = meta.getTypeInfo()) {
        assertTrue(rs.next());
        assertEquals("STRING", rs.getString("TYPE_NAME"));
        assertEquals(Types.NVARCHAR, rs.getInt("DATA_TYPE"));
        assertEquals(Types.NVARCHAR, rs.getShort("DATA_TYPE"));
        assertTrue(rs.next());
        assertEquals("INT64", rs.getString("TYPE_NAME"));
        assertEquals(Types.BIGINT, rs.getInt("DATA_TYPE"));
        assertEquals(Types.BIGINT, rs.getShort("DATA_TYPE"));
        assertTrue(rs.next());
        assertEquals("BYTES", rs.getString("TYPE_NAME"));
        assertEquals(Types.BINARY, rs.getInt("DATA_TYPE"));
        assertEquals(Types.BINARY, rs.getShort("DATA_TYPE"));
        assertTrue(rs.next());
        assertEquals("FLOAT32", rs.getString("TYPE_NAME"));
        assertEquals(Types.REAL, rs.getInt("DATA_TYPE"));
        assertEquals(Types.REAL, rs.getShort("DATA_TYPE"));
        assertTrue(rs.next());
        assertEquals("FLOAT64", rs.getString("TYPE_NAME"));
        assertEquals(Types.DOUBLE, rs.getInt("DATA_TYPE"));
        assertEquals(Types.DOUBLE, rs.getShort("DATA_TYPE"));
        assertTrue(rs.next());
        assertEquals("BOOL", rs.getString("TYPE_NAME"));
        assertEquals(Types.BOOLEAN, rs.getInt("DATA_TYPE"));
        assertEquals(Types.BOOLEAN, rs.getShort("DATA_TYPE"));
        assertTrue(rs.next());
        assertEquals("DATE", rs.getString("TYPE_NAME"));
        assertEquals(Types.DATE, rs.getInt("DATA_TYPE"));
        assertEquals(Types.DATE, rs.getShort("DATA_TYPE"));
        assertTrue(rs.next());
        assertEquals("TIMESTAMP", rs.getString("TYPE_NAME"));
        assertEquals(Types.TIMESTAMP, rs.getInt("DATA_TYPE"));
        assertEquals(Types.TIMESTAMP, rs.getShort("DATA_TYPE"));
        assertTrue(rs.next());
        assertEquals("NUMERIC", rs.getString("TYPE_NAME"));
        assertEquals(Types.NUMERIC, rs.getInt("DATA_TYPE"));
        assertEquals(Types.NUMERIC, rs.getShort("DATA_TYPE"));
        assertTrue(rs.next());
        assertEquals("UUID", rs.getString("TYPE_NAME"));
        assertEquals(Types.OTHER, rs.getInt("DATA_TYPE"));
        assertEquals(Types.OTHER, rs.getShort("DATA_TYPE"));
        assertTrue(rs.next());
        if (dialect == Dialect.POSTGRESQL) {
          assertEquals("JSONB", rs.getString("TYPE_NAME"));
          assertEquals(PgJsonbType.VENDOR_TYPE_NUMBER, rs.getInt("DATA_TYPE"));
          assertEquals(PgJsonbType.SHORT_VENDOR_TYPE_NUMBER, rs.getShort("DATA_TYPE"));
        } else {
          assertEquals("JSON", rs.getString("TYPE_NAME"));
          assertEquals(JsonType.VENDOR_TYPE_NUMBER, rs.getInt("DATA_TYPE"));
          assertEquals(JsonType.SHORT_VENDOR_TYPE_NUMBER, rs.getShort("DATA_TYPE"));
        }

        assertFalse(rs.next());
        ResultSetMetaData rsmd = rs.getMetaData();
        assertEquals(18, rsmd.getColumnCount());
      }
    }
  }

  @Test
  public void testGetUDTs() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getUDTs(DEFAULT_CATALOG, DEFAULT_SCHEMA, null, null)) {
      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(7, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetVersionColumns() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getVersionColumns(DEFAULT_CATALOG, DEFAULT_SCHEMA, TEST_TABLE)) {
      assertFalse(rs.next());
      ResultSetMetaData rsmd = rs.getMetaData();
      assertEquals(8, rsmd.getColumnCount());
    }
  }

  @Test
  public void testGetUserName() throws SQLException, IOException {
    ServiceAccountCredentials credentials =
        ServiceAccountCredentials.fromStream(
            Objects.requireNonNull(ConnectionOptionsTest.class.getResource("test-key.json"))
                .openStream());
    JdbcConnection connection = mock(JdbcConnection.class);
    ConnectionOptions options = mock(ConnectionOptions.class);
    when(options.getCredentials()).thenReturn(credentials);
    when(connection.getConnectionOptions()).thenReturn(options);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    assertEquals("test@test-project.iam.gserviceaccount.com", meta.getUserName());
  }
}
