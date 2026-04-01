/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bigquery.jdbc;

import static java.sql.Types.TIME;
import static java.sql.Types.TIMESTAMP;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseDatabaseMetadata {

  public static int getSizeOfResultSet(ResultSet rs) throws SQLException {
    int count = 0;
    while (rs.next()) {
      count++;
    }
    return count;
  }

  public static List<String> getInfoBySQL(Connection connection, String sqlCmd)
      throws SQLException {
    List<String> result = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery(sqlCmd);
      while (rs.next()) {
        result.add(rs.getString(1));
      }
    } catch (SQLException e) {
      throw e;
    }
    return result;
  }

  protected void verifyAllBooleanMethods(DatabaseMetaData metaData) throws SQLException {
    assertFalse(metaData.allProceduresAreCallable()); // false
    assertTrue(metaData.allTablesAreSelectable()); // true

    assertFalse(metaData.nullsAreSortedHigh()); // false
    assertTrue(metaData.nullsAreSortedLow()); // true
    assertFalse(metaData.nullsAreSortedAtEnd()); // false
    assertFalse(metaData.nullsAreSortedAtStart()); // false
    assertTrue(metaData.nullPlusNonNullIsNull()); // true

    assertFalse(metaData.usesLocalFiles()); // false
    assertFalse(metaData.usesLocalFilePerTable()); // false
    assertFalse(metaData.storesUpperCaseIdentifiers()); // false
    assertFalse(metaData.storesLowerCaseIdentifiers()); // false
    assertTrue(metaData.supportsMixedCaseQuotedIdentifiers());
    assertFalse(metaData.storesUpperCaseQuotedIdentifiers()); // false
    assertFalse(metaData.storesLowerCaseQuotedIdentifiers()); // false
    assertFalse(metaData.storesMixedCaseQuotedIdentifiers()); // false

    assertFalse(metaData.supportsAlterTableWithAddColumn()); // false
    assertFalse(metaData.supportsAlterTableWithDropColumn()); // false
    assertTrue(metaData.supportsColumnAliasing());
    assertTrue(metaData.nullPlusNonNullIsNull());
    assertFalse(metaData.supportsConvert()); // false
    assertFalse(metaData.supportsConvert(TIME, TIMESTAMP)); // false
    assertTrue(metaData.supportsTableCorrelationNames());
    assertTrue(metaData.supportsExpressionsInOrderBy());
    assertFalse(metaData.supportsOrderByUnrelated()); // false
    assertTrue(metaData.supportsGroupBy());
    assertFalse(metaData.supportsGroupByUnrelated()); // false
    assertTrue(metaData.supportsGroupByBeyondSelect());

    assertTrue(metaData.supportsMultipleTransactions());
    assertFalse(metaData.supportsNonNullableColumns());
    assertTrue(metaData.supportsMinimumSQLGrammar());
    assertTrue(metaData.supportsCoreSQLGrammar());
    assertFalse(metaData.supportsExtendedSQLGrammar());
    assertTrue(metaData.supportsANSI92EntryLevelSQL());
    assertFalse(metaData.supportsANSI92IntermediateSQL());
    assertFalse(metaData.supportsANSI92FullSQL());
    assertFalse(metaData.supportsFullOuterJoins());
    assertFalse(metaData.supportsLimitedOuterJoins());
    assertTrue(metaData.isCatalogAtStart());
    assertTrue(metaData.supportsSchemasInDataManipulation());

    assertTrue(metaData.supportsSchemasInTableDefinitions());
    assertTrue(metaData.supportsSchemasInIndexDefinitions());
    assertTrue(metaData.supportsSchemasInPrivilegeDefinitions());
    assertTrue(metaData.supportsCatalogsInDataManipulation());
    assertFalse(metaData.supportsPositionedDelete());
    assertFalse(metaData.supportsPositionedUpdate());

    assertFalse(metaData.supportsSelectForUpdate());
    assertTrue(metaData.supportsStoredProcedures());
    assertTrue(metaData.supportsSubqueriesInComparisons());
    assertTrue(metaData.supportsSubqueriesInExists());
    assertTrue(metaData.supportsSubqueriesInIns());
    assertTrue(metaData.supportsSubqueriesInQuantifieds());
    assertTrue(metaData.supportsCorrelatedSubqueries());
    assertFalse(metaData.supportsOpenCursorsAcrossCommit());

    assertFalse(metaData.supportsOpenCursorsAcrossRollback());
    assertTrue(metaData.supportsOpenStatementsAcrossCommit());
    assertTrue(metaData.supportsOpenStatementsAcrossRollback());

    assertFalse(
        metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_READ_COMMITTED)); // f

    assertFalse(
        metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_REPEATABLE_READ)); // f
    assertFalse(metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_NONE)); // f
    assertFalse(metaData.supportsDifferentTableCorrelationNames()); // f

    assertFalse(metaData.dataDefinitionIgnoredInTransactions());
    assertFalse(metaData.doesMaxRowSizeIncludeBlobs());

    assertTrue(metaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)); // t
    assertFalse(metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)); // f
    assertFalse(metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)); // f

    assertTrue(
        metaData.supportsResultSetConcurrency(
            ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)); // t
    assertFalse(
        metaData.supportsResultSetConcurrency(
            ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)); // f
    assertFalse(
        metaData.supportsResultSetConcurrency(
            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
    assertFalse(
        metaData.supportsResultSetConcurrency(
            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE));
    assertFalse(
        metaData.supportsResultSetConcurrency(
            ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY));
    assertFalse(
        metaData.supportsResultSetConcurrency(
            ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE));

    assertFalse(metaData.ownUpdatesAreVisible(ResultSet.TYPE_FORWARD_ONLY));
    assertFalse(metaData.ownUpdatesAreVisible(ResultSet.TYPE_SCROLL_INSENSITIVE));
    assertFalse(metaData.ownUpdatesAreVisible(ResultSet.TYPE_SCROLL_SENSITIVE));

    assertFalse(metaData.ownDeletesAreVisible(ResultSet.TYPE_FORWARD_ONLY));
    assertFalse(metaData.ownDeletesAreVisible(ResultSet.TYPE_SCROLL_INSENSITIVE));
    assertFalse(metaData.ownDeletesAreVisible(ResultSet.TYPE_SCROLL_SENSITIVE));

    assertFalse(metaData.ownInsertsAreVisible(ResultSet.TYPE_FORWARD_ONLY));
    assertFalse(metaData.ownInsertsAreVisible(ResultSet.TYPE_SCROLL_INSENSITIVE));
    assertFalse(metaData.ownInsertsAreVisible(ResultSet.TYPE_SCROLL_SENSITIVE));

    assertFalse(metaData.othersUpdatesAreVisible(ResultSet.TYPE_FORWARD_ONLY));
    assertFalse(metaData.othersUpdatesAreVisible(ResultSet.TYPE_SCROLL_INSENSITIVE));
    assertFalse(metaData.othersUpdatesAreVisible(ResultSet.TYPE_SCROLL_SENSITIVE));

    assertFalse(metaData.othersDeletesAreVisible(ResultSet.TYPE_FORWARD_ONLY));
    assertFalse(metaData.othersDeletesAreVisible(ResultSet.TYPE_SCROLL_INSENSITIVE));
    assertFalse(metaData.othersDeletesAreVisible(ResultSet.TYPE_SCROLL_SENSITIVE));

    assertFalse(metaData.othersInsertsAreVisible(ResultSet.TYPE_FORWARD_ONLY));
    assertFalse(metaData.othersInsertsAreVisible(ResultSet.TYPE_SCROLL_INSENSITIVE));
    assertFalse(metaData.othersInsertsAreVisible(ResultSet.TYPE_SCROLL_SENSITIVE));

    assertFalse(metaData.updatesAreDetected(ResultSet.TYPE_FORWARD_ONLY));
    assertFalse(metaData.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
    assertFalse(metaData.updatesAreDetected(ResultSet.TYPE_SCROLL_SENSITIVE));

    assertFalse(metaData.deletesAreDetected(ResultSet.TYPE_FORWARD_ONLY));
    assertFalse(metaData.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
    assertFalse(metaData.deletesAreDetected(ResultSet.TYPE_SCROLL_SENSITIVE));

    assertFalse(metaData.insertsAreDetected(ResultSet.TYPE_FORWARD_ONLY));
    assertFalse(metaData.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
    assertFalse(metaData.insertsAreDetected(ResultSet.TYPE_SCROLL_SENSITIVE));

    assertTrue(metaData.supportsBatchUpdates());
    assertFalse(metaData.supportsSavepoints());
    assertFalse(metaData.supportsNamedParameters());
    assertFalse(metaData.supportsMultipleOpenResults());
    assertFalse(metaData.supportsGetGeneratedKeys());

    assertFalse(metaData.generatedKeyAlwaysReturned());
    assertFalse(metaData.supportsIntegrityEnhancementFacility());
    assertFalse(metaData.supportsDataDefinitionAndDataManipulationTransactions());
    assertFalse(metaData.isReadOnly());
  }

  protected void verifyIntMethods(DatabaseMetaData metaData) throws SQLException {
    assertEquals(0, metaData.getMaxBinaryLiteralLength()); // 0
    assertEquals(0, metaData.getMaxCharLiteralLength()); // 0
    assertEquals(0, metaData.getMaxColumnsInGroupBy()); // 0
    assertEquals(0, metaData.getMaxColumnsInIndex()); // 0
    assertEquals(0, metaData.getMaxColumnsInOrderBy()); // 0
    assertEquals(0, metaData.getMaxColumnsInSelect()); // 0
    assertEquals(0, metaData.getMaxConnections()); // 0
    assertEquals(0, metaData.getMaxCursorNameLength()); // 0
    assertEquals(0, metaData.getMaxIndexLength()); // 0
    assertEquals(0, metaData.getMaxProcedureNameLength()); // 0
    assertEquals(0, metaData.getMaxRowSize()); // 0
    assertEquals(0, metaData.getMaxStatementLength()); // 0
    assertEquals(0, metaData.getMaxStatements()); // 0
    assertEquals(1000, metaData.getMaxTablesInSelect()); // 1000
    assertEquals(0, metaData.getMaxUserNameLength()); // 0
  }

  protected void verifyAllStringMethods(DatabaseMetaData metaData, String procedure)
      throws SQLException {
    assertEquals("`", metaData.getIdentifierQuoteString());
    assertTrue(procedure.equalsIgnoreCase(metaData.getProcedureTerm()));
  }

  protected void verifyGetPrimaryKeys(
      Connection connection, DatabaseMetaData metaData, String dataset) throws SQLException {
    final String jdbctesttable = "JDBCTESTPRIMARYKEY";
    connection
        .createStatement()
        .execute(
            "create or replace table "
                + dataset
                + "."
                + jdbctesttable
                + "(KEYCOLUMN int NOT NULL, SECONDCOLUMN string, THIRDCOLUMN timestamp);");
    ResultSet resultSet =
        metaData.getPrimaryKeys(JdbcConnectionHelper.DEFAULT_CATALOG, dataset, jdbctesttable);
    assertFalse(resultSet.next());
    connection.createStatement().execute("drop table if exists " + dataset + "." + jdbctesttable);
  }

  protected void verifyTestProcedure(DatabaseMetaData metaData, String expectedProcedure)
      throws SQLException {
    assertEquals(expectedProcedure, metaData.getProcedureTerm());
    assertTrue(metaData.supportsStoredProcedures());
    ResultSet resultSet;
    resultSet = metaData.getProcedureColumns("%", "%", "%", "%");
    assertEquals(0, getSizeOfResultSet(resultSet));
    resultSet = metaData.getProcedures("%", "%", "%");
    assertEquals(0, getSizeOfResultSet(resultSet));
  }

  protected void verifyDriverMetadata(
      DatabaseMetaData metaData,
      int expectedMajorVer,
      int expectedMinorVersion,
      String expectedDatabaseProductName,
      String expectedDriverName,
      Pattern versionPattern)
      throws SQLException {

    assertEquals(expectedMajorVer, metaData.getJDBCMajorVersion());
    assertEquals(expectedMinorVersion, metaData.getJDBCMinorVersion());
    assertEquals(expectedDatabaseProductName, metaData.getDatabaseProductName());
    assertEquals(expectedDriverName, metaData.getDriverName());
    String driverVersion = metaData.getDriverVersion();
    Matcher m = versionPattern.matcher(driverVersion);
    assertTrue(m.matches());
    int majorVersion = metaData.getDriverMajorVersion();
    int minorVersion = metaData.getDriverMinorVersion();
    assertEquals(Integer.parseInt(m.group(1)), majorVersion);
    assertEquals(Integer.parseInt(m.group(2)), minorVersion);
  }

  protected void verifyCatalogHelper(
      DatabaseMetaData metaData,
      String expectedCatalogSeparator,
      String expectedCatalogTerm,
      int expectedCatalogNameLength,
      String defaultCatalog,
      boolean isBeforeFirstSupported,
      boolean isFirstSupported)
      throws SQLException {
    assertEquals(expectedCatalogSeparator, metaData.getCatalogSeparator());
    // Simba BQ JDBC driver maps Catalogs to projects
    assertEquals(expectedCatalogTerm, metaData.getCatalogTerm());
    assertEquals(expectedCatalogNameLength, metaData.getMaxCatalogNameLength());

    // This should return the project name of the connection
    ResultSet resultSet = metaData.getCatalogs();

    // Compares ResultSetMetadata.
    // verifyResultSetMetaDataColumns(resultSet, DBMetadataResultSetMetadata.GET_CATALOGS);
    if (isBeforeFirstSupported) {
      assertTrue(resultSet.isBeforeFirst());
    }

    int count = 0;
    boolean defaultCatalogFound = false;
    while (resultSet.next()) {
      if (count == 0 && isFirstSupported) {
        assertTrue(resultSet.isFirst());
      }
      ++count;
      if (defaultCatalog.equals(resultSet.getString(1))) {
        defaultCatalogFound = true;
        break;
      }
    }
    assertTrue(defaultCatalogFound);
    resultSet.close();
  }

  protected void verifySchemaHelper(
      Connection connection,
      DatabaseMetaData metaData,
      String schemaTerm,
      int maxSchemaNameLength,
      boolean isBeforeFirstSupported,
      boolean isFirstSupported)
      throws SQLException {
    // Simba BQ JDBC driver maps Table Datasets to Schemas
    assertEquals(schemaTerm, metaData.getSchemaTerm());
    assertEquals(maxSchemaNameLength, metaData.getMaxSchemaNameLength());
    // This should return all the datasets in the project of the connection
    ResultSet resultSet = metaData.getSchemas();
    // Compares ResultSetMetadata.
    // verifyResultSetMetaDataColumns(resultSet, DBMetadataResultSetMetadata.GET_CATALOGS);
    if (isBeforeFirstSupported) {
      assertTrue(resultSet.isBeforeFirst());
    }

    int count = 0;
    Set<String> allVisibleDatasets = new HashSet<>();
    while (resultSet.next()) {
      allVisibleDatasets.add(resultSet.getString(1));
      if (count == 0 && isFirstSupported) {
        assertTrue(resultSet.isFirst());
      }
      ++count;
    }
    assertTrue(count >= 1);
    List<String> allAccessibleDatasets =
        getInfoBySQL(connection, "SELECT schema_name FROM INFORMATION_SCHEMA.SCHEMATA;");
    assertTrue(allVisibleDatasets.containsAll(allAccessibleDatasets));
    assertTrue(count >= allAccessibleDatasets.size());
    resultSet.close();
  }

  protected void verifyTableTypes(DatabaseMetaData metaData, Collection<String> expectedTypes)
      throws SQLException {
    ResultSet resultSet = metaData.getTableTypes();
    Set<String> types = new HashSet<>();
    while (resultSet.next()) {
      String col = resultSet.getString(1);
      types.add(col);
    }
    assertTrue(types.size() > 0);
    assertTrue(types.containsAll(expectedTypes));
  }

  protected void verifyGetTables(Connection connection, DatabaseMetaData metaData, String dataset)
      throws SQLException {
    final String jdbctesttable = "JDBCTESTTABLE";
    final String jdbctestview = "JDBCTESTVIEW";

    Statement statement = connection.createStatement();
    statement.execute(
        String.format(
            "create or replace table `%s.%s.%s` "
                + "(INTCOLUMN int, STRINGCOLUMN string, TIMECOLUMN timestamp);",
            JdbcConnectionHelper.DEFAULT_CATALOG, dataset, jdbctesttable));
    statement.execute(
        String.format(
            "create or replace view  `%s.%s.%s` " + " as select 1 as VIEWCOLUMN;",
            JdbcConnectionHelper.DEFAULT_CATALOG, dataset, jdbctestview));

    ResultSet resultSet;

    // Pattern match for table
    resultSet =
        metaData.getTables(
            JdbcConnectionHelper.DEFAULT_CATALOG, dataset, "%", new String[] {"TABLE"});
    // verifyResultSetMetaDataColumns(resultSet, DBMetadataResultSetMetadata.GET_TABLES);
    Set<String> tables = new HashSet<>();
    while (resultSet.next()) {
      tables.add(resultSet.getString(3));
    }
    assertTrue(tables.contains("JDBCTESTTABLE"));

    // exact match for tablename
    resultSet =
        metaData.getTables(
            JdbcConnectionHelper.DEFAULT_CATALOG, dataset, jdbctesttable, new String[] {"TABLE"});
    tables = new HashSet<>();
    while (resultSet.next()) {
      tables.add(resultSet.getString(3));
    }
    assertEquals(jdbctesttable, tables.iterator().next());

    // Pattern match for view
    resultSet =
        metaData.getTables(
            JdbcConnectionHelper.DEFAULT_CATALOG, dataset, "%", new String[] {"VIEW"});
    Set<String> views = new HashSet<>();
    while (resultSet.next()) {
      views.add(resultSet.getString(3));
    }
    assertTrue(views.contains(jdbctestview));

    connection.createStatement().execute("drop table if exists " + dataset + "." + jdbctesttable);
    connection.createStatement().execute("drop view if exists " + dataset + "." + jdbctestview);
  }

  // GetTablePrivileges not supported for JDBC and ODBC datasource.
  // Returns empty resultset
  protected void verifyGetTablePrivileges(
      Connection connection, DatabaseMetaData metaData, String dataset) throws SQLException {
    final String jdbctesttable = "JDBCTESTPRIVILEGETABLE";

    Statement statement = connection.createStatement();
    statement.execute(
        String.format(
            "create or replace table `%s.%s.%s` (INTCOLUMN int, STRINGCOLUMN string, TIMECOLUMN timestamp);",
            JdbcConnectionHelper.DEFAULT_CATALOG, dataset, jdbctesttable));

    ResultSet resultSet =
        metaData.getTablePrivileges(JdbcConnectionHelper.DEFAULT_CATALOG, dataset, jdbctesttable);
    int cols = resultSet.getMetaData().getColumnCount();
    assertTrue(cols > 0);
    int count = 0;
    while (resultSet.next()) {
      for (int i = 1; i <= cols; i++) {
        assertNotNull(resultSet.getMetaData().getColumnName(i));
        assertNotNull(resultSet.getString(i));
      }
      ++count;
    }
    assertEquals(0, count);
    connection.createStatement().execute("drop table if exists " + dataset + "." + jdbctesttable);
  }

  protected void verifyGetColumnPrivileges(
      Connection connection, DatabaseMetaData metaData, String dataset) throws SQLException {
    final String jdbctesttable = "JDBCTESTPRIVILEGETABLE";

    connection
        .createStatement()
        .execute(
            "create or replace table "
                + dataset
                + "."
                + jdbctesttable
                + "(INTCOLUMN int, STRINGCOLUMN string, TIMECOLUMN timestamp);");

    ResultSet resultSet =
        metaData.getColumnPrivileges(
            JdbcConnectionHelper.DEFAULT_CATALOG, dataset, jdbctesttable, "%");
    int cols = resultSet.getMetaData().getColumnCount();
    assertTrue(cols > 0);
    int count = 0;
    while (resultSet.next()) {
      for (int i = 1; i <= cols; i++) {
        assertNotNull(resultSet.getMetaData().getColumnName(i));
        assertNotNull(resultSet.getString(i));
      }
      ++count;
    }
    assertEquals(0, count);
    connection.createStatement().execute("drop table if exists " + dataset + "." + jdbctesttable);
  }

  protected void verifyForeignKeys(Connection connection, DatabaseMetaData metaData, String dataset)
      throws SQLException {
    final String jdbctesttable = "JDBCTESTTABLEFOREIGNKEYS";

    connection
        .createStatement()
        .execute(
            "create or replace table "
                + dataset
                + "."
                + jdbctesttable
                + "(INTCOLUMN int, STRINGCOLUMN string, TIMECOLUMN timestamp);");

    ResultSet resultSet =
        metaData.getImportedKeys(JdbcConnectionHelper.DEFAULT_CATALOG, dataset, jdbctesttable);
    int cols = resultSet.getMetaData().getColumnCount();
    assertTrue(cols > 0);
    int count = 0;
    while (resultSet.next()) {
      for (int i = 1; i <= cols; i++) {
        assertNotNull(resultSet.getMetaData().getColumnName(i));
        assertNotNull(resultSet.getString(i));
      }
      ++count;
    }
    assertEquals(0, count);
    connection.createStatement().execute("drop table if exists " + dataset + "." + jdbctesttable);
  }

  protected void verifyGetColumns(Connection connection, DatabaseMetaData metaData, String dataset)
      throws SQLException {
    final String jdbctesttable = "JDBCTESTCOLUMNS";
    Statement statement = connection.createStatement();
    statement.execute(
        String.format(
            "create or replace table `%s.%s.%s` (INTCOLUMN int, STRINGCOLUMN string, TIMECOLUMN timestamp);",
            JdbcConnectionHelper.DEFAULT_CATALOG, dataset, jdbctesttable));
    ResultSet resultSet =
        metaData.getColumns(
            JdbcConnectionHelper.DEFAULT_CATALOG, dataset, jdbctesttable, "%COLUMN");
    int cols = resultSet.getMetaData().getColumnCount();
    assertTrue(cols > 0);
    // Resultset is not empty
    int count = 0;
    while (resultSet.next()) {
      for (int i = 1; i <= cols; i++) {
        assertNotNull(resultSet.getMetaData().getColumnName(i));
      }
      ++count;
    }
    resultSet.close();
    assertTrue(count > 0);
    connection.createStatement().execute("drop table if exists " + dataset + "." + jdbctesttable);
  }

  protected void verifyVersionColumns(
      Connection connection,
      DatabaseMetaData metaData,
      String dataset,
      int expectedNumCols,
      Collection<String> expectedColNames)
      throws SQLException {
    final String jdbctesttable = "JDBCTESTCOLUMNS";
    connection
        .createStatement()
        .execute(
            "create or replace table "
                + dataset
                + "."
                + jdbctesttable
                + "(INTCOLUMN int, STRINGCOLUMN string, TIMECOLUMN timestamp);");
    ResultSet resultSet =
        metaData.getVersionColumns(JdbcConnectionHelper.DEFAULT_CATALOG, dataset, jdbctesttable);
    int numCols = resultSet.getMetaData().getColumnCount();
    assertEquals(expectedNumCols, numCols);
    List<String> colNames = new ArrayList<>();
    for (int i = 1; i <= numCols; i++) {
      colNames.add(resultSet.getMetaData().getColumnName(i));
    }
    assertTrue(colNames.containsAll(expectedColNames));
    resultSet.close();
    connection.createStatement().execute("drop table if exists " + dataset + "." + jdbctesttable);
  }

  protected void verifyIndexInfo(Connection connection, DatabaseMetaData metaData, String dataset)
      throws SQLException {
    final String jdbctesttable = "JDBCTESTTABLE";
    connection
        .createStatement()
        .execute(
            "create or replace table "
                + dataset
                + "."
                + jdbctesttable
                + "(INTCOLUMN int, STRINGCOLUMN string, TIMECOLUMN timestamp);");
    ResultSet rs =
        metaData.getIndexInfo(
            JdbcConnectionHelper.DEFAULT_CATALOG, dataset, jdbctesttable, false, false);
    assertFalse(rs.next()); // no index defined.
    rs.close();
    connection.createStatement().execute("drop table if exists " + dataset + "." + jdbctesttable);
  }
}
