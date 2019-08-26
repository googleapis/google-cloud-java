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
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.auth.oauth2.GoogleCredentials;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.sql.Types;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JdbcDatabaseMetaDataTest {
  private static final String DEFAULT_CATALOG = "";
  private static final String DEFAULT_SCHEMA = "";
  private static final String TEST_TABLE = "FOO";
  private static final int DATABASE_MAJOR_VERSION = 1;
  private static final int DATABASE_MINOR_VERSION = 0;
  private static final String DATABASE_PRODUCT_NAME = "Google Cloud Spanner";

  @Test
  public void testTrivialMethods() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    assertThat(meta.allProceduresAreCallable(), is(true));
    assertThat(meta.allTablesAreSelectable(), is(true));
    assertThat(meta.autoCommitFailureClosesAllResultSets(), is(false));
    assertThat(meta.dataDefinitionCausesTransactionCommit(), is(false));
    assertThat(meta.dataDefinitionIgnoredInTransactions(), is(false));
    for (int type :
        new int[] {
          ResultSet.TYPE_FORWARD_ONLY,
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.TYPE_SCROLL_SENSITIVE
        }) {
      assertThat(meta.deletesAreDetected(type), is(false));
      assertThat(meta.insertsAreDetected(type), is(false));
      assertThat(meta.updatesAreDetected(type), is(false));
      assertThat(meta.ownDeletesAreVisible(type), is(false));
      assertThat(meta.ownInsertsAreVisible(type), is(false));
      assertThat(meta.ownUpdatesAreVisible(type), is(false));
      assertThat(meta.othersDeletesAreVisible(type), is(false));
      assertThat(meta.othersInsertsAreVisible(type), is(false));
      assertThat(meta.othersUpdatesAreVisible(type), is(false));
    }
    assertThat(meta.doesMaxRowSizeIncludeBlobs(), is(true));
    assertThat(meta.generatedKeyAlwaysReturned(), is(false));
    assertThat(meta.getCatalogSeparator(), is(equalTo(".")));
    assertThat(meta.getCatalogTerm(), is(equalTo("CATALOG")));
    assertThat(meta.getDatabaseMajorVersion(), is(equalTo(DATABASE_MAJOR_VERSION)));
    assertThat(meta.getDatabaseMinorVersion(), is(equalTo(DATABASE_MINOR_VERSION)));
    assertThat(meta.getDatabaseProductName(), is(equalTo(DATABASE_PRODUCT_NAME)));
    assertThat(
        meta.getDatabaseProductVersion(),
        is(equalTo(DATABASE_MAJOR_VERSION + "." + DATABASE_MINOR_VERSION)));
    assertThat(
        meta.getDefaultTransactionIsolation(), is(equalTo(Connection.TRANSACTION_SERIALIZABLE)));
    assertThat(meta.getDriverName(), is(equalTo("com.google.cloud.spanner.jdbc.JdbcDriver")));
    assertThat(meta.getExtraNameCharacters(), is(equalTo("")));
    assertThat(meta.getIdentifierQuoteString(), is(equalTo("`")));
    assertThat(meta.getJDBCMajorVersion(), is(equalTo(4)));
    assertThat(meta.getJDBCMinorVersion(), is(equalTo(1))); // Java 7 is JDBC 4.1
    assertThat(meta.getMaxBinaryLiteralLength(), is(equalTo(0)));
    assertThat(meta.getMaxCatalogNameLength(), is(equalTo(0)));
    assertThat(meta.getMaxCharLiteralLength(), is(equalTo(0)));
    assertThat(meta.getMaxColumnNameLength(), is(equalTo(128)));
    assertThat(meta.getMaxColumnsInGroupBy(), is(equalTo(1000)));
    assertThat(meta.getMaxColumnsInIndex(), is(equalTo(16)));
    assertThat(meta.getMaxColumnsInOrderBy(), is(equalTo(0)));
    assertThat(meta.getMaxColumnsInSelect(), is(equalTo(0)));
    assertThat(meta.getMaxColumnsInTable(), is(equalTo(1024)));
    assertThat(meta.getMaxConnections(), is(equalTo(0))); // there is a max number of sessions, but
    // that is not the same as connections
    assertThat(meta.getMaxCursorNameLength(), is(equalTo(0)));
    assertThat(meta.getMaxIndexLength(), is(equalTo(8000)));
    assertThat(meta.getMaxProcedureNameLength(), is(equalTo(0)));
    assertThat(meta.getMaxRowSize(), is(equalTo(1024 * 10000000)));
    assertThat(meta.getMaxSchemaNameLength(), is(equalTo(0)));
    assertThat(meta.getMaxStatementLength(), is(equalTo(1000000)));
    assertThat(meta.getMaxStatements(), is(equalTo(0)));
    assertThat(meta.getMaxTableNameLength(), is(equalTo(128)));
    assertThat(meta.getMaxTablesInSelect(), is(equalTo(0)));
    assertThat(meta.getMaxUserNameLength(), is(equalTo(0)));
    assertThat(meta.getProcedureTerm(), is(equalTo("PROCEDURE")));
    assertThat(meta.getResultSetHoldability(), is(equalTo(ResultSet.CLOSE_CURSORS_AT_COMMIT)));
    assertThat(meta.getRowIdLifetime(), is(equalTo(RowIdLifetime.ROWID_UNSUPPORTED)));
    assertThat(meta.getSchemaTerm(), is(equalTo("SCHEMA")));
    assertThat(meta.getSearchStringEscape(), is(equalTo("\\")));
    assertThat(meta.getSQLStateType(), is(equalTo(DatabaseMetaData.sqlStateSQL)));
    assertThat(meta.locatorsUpdateCopy(), is(true));
    assertThat(meta.nullsAreSortedHigh(), is(false));
    assertThat(meta.nullsAreSortedLow(), is(true));
    assertThat(meta.nullsAreSortedAtStart(), is(false));
    assertThat(meta.nullsAreSortedAtEnd(), is(false));
    assertThat(meta.nullPlusNonNullIsNull(), is(true));
    assertThat(meta.isCatalogAtStart(), is(false));
    assertThat(meta.isReadOnly(), is(equalTo(connection.isReadOnly())));
    assertThat(meta.storesLowerCaseIdentifiers(), is(false));
    assertThat(meta.storesLowerCaseQuotedIdentifiers(), is(false));
    assertThat(meta.storesMixedCaseIdentifiers(), is(true));
    assertThat(meta.storesMixedCaseQuotedIdentifiers(), is(true));
    assertThat(meta.storesUpperCaseIdentifiers(), is(false));
    assertThat(meta.storesUpperCaseQuotedIdentifiers(), is(false));
    assertThat(meta.supportsAlterTableWithAddColumn(), is(true));
    assertThat(meta.supportsAlterTableWithDropColumn(), is(true));
    assertThat(meta.supportsANSI92EntryLevelSQL(), is(false));
    assertThat(meta.supportsANSI92FullSQL(), is(false));
    assertThat(meta.supportsANSI92IntermediateSQL(), is(false));
    assertThat(meta.supportsBatchUpdates(), is(true));
    assertThat(meta.supportsCatalogsInDataManipulation(), is(false));
    assertThat(meta.supportsCatalogsInIndexDefinitions(), is(false));
    assertThat(meta.supportsCatalogsInPrivilegeDefinitions(), is(false));
    assertThat(meta.supportsCatalogsInProcedureCalls(), is(false));
    assertThat(meta.supportsCatalogsInTableDefinitions(), is(false));
    assertThat(meta.supportsColumnAliasing(), is(true));
    // Note that the supportsConvert() method indicates whether the server side function CONVERT is
    // supported, not what the JDBC driver might be able to convert on the client side.
    assertThat(meta.supportsConvert(), is(false));
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
        assertThat(meta.supportsConvert(from, to), is(false));
      }
    }
    assertThat(meta.supportsCoreSQLGrammar(), is(false));
    assertThat(meta.supportsCorrelatedSubqueries(), is(true));
    assertThat(meta.supportsDataDefinitionAndDataManipulationTransactions(), is(false));
    assertThat(meta.supportsDataManipulationTransactionsOnly(), is(true));
    assertThat(meta.supportsDifferentTableCorrelationNames(), is(false));
    assertThat(meta.supportsExpressionsInOrderBy(), is(true));
    assertThat(meta.supportsExtendedSQLGrammar(), is(false));
    assertThat(meta.supportsFullOuterJoins(), is(true));
    assertThat(meta.supportsGetGeneratedKeys(), is(false));
    assertThat(meta.supportsGroupBy(), is(true));
    assertThat(meta.supportsGroupByBeyondSelect(), is(true));
    assertThat(meta.supportsGroupByUnrelated(), is(true));
    assertThat(meta.supportsIntegrityEnhancementFacility(), is(false));
    assertThat(meta.supportsLikeEscapeClause(), is(true));
    assertThat(meta.supportsLimitedOuterJoins(), is(true));
    assertThat(meta.supportsMinimumSQLGrammar(), is(false));
    assertThat(meta.supportsMixedCaseIdentifiers(), is(false));
    assertThat(meta.supportsMixedCaseQuotedIdentifiers(), is(false));
    assertThat(meta.supportsMultipleOpenResults(), is(true));
    assertThat(meta.supportsMultipleResultSets(), is(true));
    assertThat(meta.supportsMultipleTransactions(), is(true));
    assertThat(meta.supportsNamedParameters(), is(false));
    assertThat(meta.supportsNonNullableColumns(), is(true));
    assertThat(meta.supportsOpenCursorsAcrossCommit(), is(false));
    assertThat(meta.supportsOpenCursorsAcrossRollback(), is(false));
    assertThat(meta.supportsOpenStatementsAcrossCommit(), is(true));
    assertThat(meta.supportsOpenStatementsAcrossRollback(), is(true));
    assertThat(meta.supportsOrderByUnrelated(), is(true));
    assertThat(meta.supportsOuterJoins(), is(true));
    assertThat(meta.supportsPositionedDelete(), is(false));
    assertThat(meta.supportsPositionedUpdate(), is(false));
    for (int type :
        new int[] {
          ResultSet.TYPE_FORWARD_ONLY,
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.TYPE_SCROLL_SENSITIVE
        }) {
      assertThat(meta.supportsResultSetType(type), is(type == ResultSet.TYPE_FORWARD_ONLY));
      for (int concur : new int[] {ResultSet.CONCUR_READ_ONLY, ResultSet.CONCUR_UPDATABLE}) {
        assertThat(
            meta.supportsResultSetConcurrency(type, concur),
            is(type == ResultSet.TYPE_FORWARD_ONLY && concur == ResultSet.CONCUR_READ_ONLY));
      }
    }
    assertThat(meta.supportsResultSetHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT), is(true));
    assertThat(meta.supportsResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT), is(false));
    assertThat(meta.supportsSavepoints(), is(false));
    assertThat(meta.supportsSchemasInDataManipulation(), is(false));
    assertThat(meta.supportsSchemasInIndexDefinitions(), is(false));
    assertThat(meta.supportsSchemasInPrivilegeDefinitions(), is(false));
    assertThat(meta.supportsSchemasInProcedureCalls(), is(false));
    assertThat(meta.supportsSchemasInTableDefinitions(), is(false));
    assertThat(meta.supportsSelectForUpdate(), is(false));
    assertThat(meta.supportsStatementPooling(), is(false));
    assertThat(meta.supportsStoredFunctionsUsingCallSyntax(), is(false));
    assertThat(meta.supportsStoredProcedures(), is(false));
    assertThat(meta.supportsSubqueriesInComparisons(), is(true));
    assertThat(meta.supportsSubqueriesInExists(), is(true));
    assertThat(meta.supportsSubqueriesInIns(), is(true));
    assertThat(meta.supportsSubqueriesInQuantifieds(), is(true));
    assertThat(meta.supportsTableCorrelationNames(), is(true));
    assertThat(meta.supportsTransactions(), is(true));
    assertThat(meta.supportsUnion(), is(true));
    assertThat(meta.supportsUnionAll(), is(true));
    assertThat(meta.usesLocalFiles(), is(false));
    assertThat(meta.usesLocalFilePerTable(), is(false));
    assertThat(
        meta.supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE), is(true));
    for (int level :
        new int[] {
          Connection.TRANSACTION_NONE,
          Connection.TRANSACTION_READ_COMMITTED,
          Connection.TRANSACTION_READ_UNCOMMITTED,
          Connection.TRANSACTION_REPEATABLE_READ
        }) {
      assertThat(meta.supportsTransactionIsolationLevel(level), is(false));
    }

    // trivial tests that guarantee that the function works, but the return value doesn't matter
    assertThat(meta.getNumericFunctions(), is(notNullValue()));
    assertThat(meta.getSQLKeywords(), is(notNullValue()));
    assertThat(meta.getStringFunctions(), is(notNullValue()));
    assertThat(meta.getSystemFunctions(), is(notNullValue()));
    assertThat(meta.getTimeDateFunctions(), is(notNullValue()));
  }

  @Test
  public void testGetAttributes() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getAttributes(DEFAULT_CATALOG, DEFAULT_SCHEMA, TEST_TABLE, null)) {
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(21)));
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
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(8)));
    }
  }

  @Test
  public void testGetCatalogs() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getCatalogs()) {
      assertThat(rs.next(), is(true));
      assertThat(rs.getString("TABLE_CAT"), is(equalTo("")));
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(1)));
    }
  }

  @Test
  public void testGetClientInfoProperties() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getClientInfoProperties()) {
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(4)));
    }
  }

  public void testGetColumnPrivileges() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs =
        meta.getColumnPrivileges(DEFAULT_CATALOG, DEFAULT_SCHEMA, TEST_TABLE, null)) {
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(8)));
    }
  }

  @Test
  public void testGetFunctionColumns() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getFunctionColumns(DEFAULT_CATALOG, DEFAULT_SCHEMA, null, null)) {
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(17)));
    }
  }

  @Test
  public void testGetFunctions() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getFunctions(DEFAULT_CATALOG, DEFAULT_SCHEMA, null)) {
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(6)));
    }
  }

  @Test
  public void testGetProcedureColumns() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getProcedureColumns(DEFAULT_CATALOG, DEFAULT_SCHEMA, null, null)) {
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(20)));
    }
  }

  @Test
  public void testGetProcedures() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getProcedures(DEFAULT_CATALOG, DEFAULT_SCHEMA, null)) {
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(9)));
    }
  }

  @Test
  public void testGetPseudoColumns() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getPseudoColumns(DEFAULT_CATALOG, DEFAULT_SCHEMA, TEST_TABLE, null)) {
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(12)));
    }
  }

  @Test
  public void testGetSuperTables() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getSuperTables(DEFAULT_CATALOG, DEFAULT_SCHEMA, TEST_TABLE)) {
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(4)));
    }
  }

  @Test
  public void testGetSuperTypes() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getSuperTypes(DEFAULT_CATALOG, DEFAULT_SCHEMA, null)) {
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(6)));
    }
  }

  @Test
  public void testGetTablePrivileges() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getTablePrivileges(DEFAULT_CATALOG, DEFAULT_SCHEMA, TEST_TABLE)) {
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(7)));
    }
  }

  @Test
  public void testGetTableTypes() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getTableTypes()) {
      assertThat(rs.next(), is(true));
      assertThat(rs.getString("TABLE_TYPE"), is(equalTo("TABLE")));
      assertThat(rs.next(), is(true));
      assertThat(rs.getString("TABLE_TYPE"), is(equalTo("VIEW")));
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(1)));
    }
  }

  @Test
  public void testGetTypeInfo() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getTypeInfo()) {
      assertThat(rs.next(), is(true));
      assertThat(rs.getString("TYPE_NAME"), is(equalTo("STRING")));
      assertThat(rs.next(), is(true));
      assertThat(rs.getString("TYPE_NAME"), is(equalTo("INT64")));
      assertThat(rs.next(), is(true));
      assertThat(rs.getString("TYPE_NAME"), is(equalTo("BYTES")));
      assertThat(rs.next(), is(true));
      assertThat(rs.getString("TYPE_NAME"), is(equalTo("FLOAT64")));
      assertThat(rs.next(), is(true));
      assertThat(rs.getString("TYPE_NAME"), is(equalTo("BOOL")));
      assertThat(rs.next(), is(true));
      assertThat(rs.getString("TYPE_NAME"), is(equalTo("DATE")));
      assertThat(rs.next(), is(true));
      assertThat(rs.getString("TYPE_NAME"), is(equalTo("TIMESTAMP")));
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(18)));
    }
  }

  @Test
  public void testGetUDTs() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getUDTs(DEFAULT_CATALOG, DEFAULT_SCHEMA, null, null)) {
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(7)));
    }
  }

  @Test
  public void testGetVersionColumns() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    try (ResultSet rs = meta.getVersionColumns(DEFAULT_CATALOG, DEFAULT_SCHEMA, TEST_TABLE)) {
      assertThat(rs.next(), is(false));
      ResultSetMetaData rsmd = rs.getMetaData();
      assertThat(rsmd.getColumnCount(), is(equalTo(8)));
    }
  }

  @Test
  public void testGetUserName() throws SQLException, IOException {
    GoogleCredentials credentials =
        GoogleCredentials.fromStream(
            ConnectionOptionsTest.class.getResource("test-key.json").openStream());
    JdbcConnection connection = mock(JdbcConnection.class);
    ConnectionOptions options = mock(ConnectionOptions.class);
    when(options.getCredentials()).thenReturn(credentials);
    when(connection.getConnectionOptions()).thenReturn(options);
    DatabaseMetaData meta = new JdbcDatabaseMetaData(connection);
    assertThat(meta.getUserName(), is(equalTo("test@test-project.iam.gserviceaccount.com")));
  }
}
