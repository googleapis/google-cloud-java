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

import com.google.auth.Credentials;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.oauth2.UserCredentials;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.jdbc.ConnectionImpl.InternalMetadataQuery;
import com.google.common.annotations.VisibleForTesting;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/** {@link DatabaseMetaData} implementation for Cloud Spanner */
class JdbcDatabaseMetaData extends AbstractJdbcWrapper implements DatabaseMetaData {
  private static final int JDBC_MAJOR_VERSION = 4;
  private static final int JDBC_MINOR_VERSION = 1;
  private static final int DATABASE_MAJOR_VERSION = 1;
  private static final int DATABASE_MINOR_VERSION = 0;
  private static final String PRODUCT_NAME = "Google Cloud Spanner";

  @VisibleForTesting
  static String readSqlFromFile(String filename) {
    InputStream in = JdbcDatabaseMetaData.class.getResourceAsStream(filename);
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    StringBuilder builder = new StringBuilder();
    try (Scanner scanner = new Scanner(reader)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        builder.append(line).append("\n");
      }
      scanner.close();
    }
    return builder.toString();
  }

  private JdbcConnection connection;

  JdbcDatabaseMetaData(JdbcConnection connection) {
    this.connection = connection;
  }

  @Override
  public boolean isClosed() {
    return false;
  }

  @Override
  public boolean allProceduresAreCallable() throws SQLException {
    return true;
  }

  @Override
  public boolean allTablesAreSelectable() throws SQLException {
    return true;
  }

  @Override
  public String getURL() throws SQLException {
    return connection.getConnectionUrl();
  }

  @Override
  public String getUserName() throws SQLException {
    Credentials credentials = connection.getConnectionOptions().getCredentials();
    if (credentials != null) {
      if (credentials instanceof ServiceAccountSigner) {
        return ((ServiceAccountSigner) credentials).getAccount();
      } else if (credentials instanceof UserCredentials) {
        return ((UserCredentials) credentials).getClientId();
      }
    }
    return "";
  }

  @Override
  public boolean isReadOnly() throws SQLException {
    return false;
  }

  @Override
  public boolean nullsAreSortedHigh() throws SQLException {
    return false;
  }

  @Override
  public boolean nullsAreSortedLow() throws SQLException {
    return true;
  }

  @Override
  public boolean nullsAreSortedAtStart() throws SQLException {
    return false;
  }

  @Override
  public boolean nullsAreSortedAtEnd() throws SQLException {
    return false;
  }

  @Override
  public String getDatabaseProductName() throws SQLException {
    return PRODUCT_NAME;
  }

  @Override
  public String getDatabaseProductVersion() throws SQLException {
    return getDatabaseMajorVersion() + "." + getDatabaseMinorVersion();
  }

  @Override
  public String getDriverName() throws SQLException {
    return JdbcDriver.class.getName();
  }

  @Override
  public String getDriverVersion() throws SQLException {
    return getDriverMajorVersion() + "." + getDriverMinorVersion();
  }

  @Override
  public int getDriverMajorVersion() {
    return JdbcDriver.MAJOR_VERSION;
  }

  @Override
  public int getDriverMinorVersion() {
    return JdbcDriver.MINOR_VERSION;
  }

  @Override
  public boolean usesLocalFiles() throws SQLException {
    return false;
  }

  @Override
  public boolean usesLocalFilePerTable() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsMixedCaseIdentifiers() throws SQLException {
    return false;
  }

  @Override
  public boolean storesUpperCaseIdentifiers() throws SQLException {
    return false;
  }

  @Override
  public boolean storesLowerCaseIdentifiers() throws SQLException {
    return false;
  }

  @Override
  public boolean storesMixedCaseIdentifiers() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
    return false;
  }

  @Override
  public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
    return false;
  }

  @Override
  public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
    return false;
  }

  @Override
  public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
    return true;
  }

  @Override
  public String getIdentifierQuoteString() throws SQLException {
    return "`";
  }

  @Override
  public String getSQLKeywords() throws SQLException {
    return "ASSERT_ROWS_MODIFIED,ENUM,GROUPS,HASH,IGNORE,LOOKUP,PROTO,RESPECT,STRUCT,WINDOW";
  }

  @Override
  public String getNumericFunctions() throws SQLException {
    return "ABS,SIGN,IS_INF,IS_NAN,IEEE_DIVIDE,SQRT,POW,POWER,EXP,LN,LOG,LOG10,GREATEST,LEAST,DIV,MOD,ROUND,TRUNC,CEIL,CEILING,FLOOR,COS,COSH,ACOS,ACOSH,SIN,SINH,ASIN,ASINH,TAN,TANH,ATAN,ATANH,ATAN2,FARM_FINGERPRINT,SHA1,SHA256,SHA512";
  }

  @Override
  public String getStringFunctions() throws SQLException {
    return "BYTE_LENGTH,CHAR_LENGTH,CHARACTER_LENGTH,CODE_POINTS_TO_BYTES,CODE_POINTS_TO_STRING,CONCAT,ENDS_WITH,FORMAT,FROM_BASE64,FROM_HEX,LENGTH,LPAD,LOWER,LTRIM,REGEXP_CONTAINS,REGEXP_EXTRACT,REGEXP_EXTRACT_ALL,REGEXP_REPLACE,REPLACE,REPEAT,REVERSE,RPAD,RTRIM,SAFE_CONVERT_BYTES_TO_STRING,SPLIT,STARTS_WITH,STRPOS,SUBSTR,TO_BASE64,TO_CODE_POINTS,TO_HEX,TRIM,UPPER,JSON_QUERY,JSON_VALUE";
  }

  @Override
  public String getSystemFunctions() throws SQLException {
    return "";
  }

  @Override
  public String getTimeDateFunctions() throws SQLException {
    return "CURRENT_DATE,EXTRACT,DATE,DATE_ADD,DATE_SUB,DATE_DIFF,DATE_TRUNC,DATE_FROM_UNIX_DATE,FORMAT_DATE,PARSE_DATE,UNIX_DATE,CURRENT_TIMESTAMP,STRING,TIMESTAMP,TIMESTAMP_ADD,TIMESTAMP_SUB,TIMESTAMP_DIFF,TIMESTAMP_TRUNC,FORMAT_TIMESTAMP,PARSE_TIMESTAMP,TIMESTAMP_SECONDS,TIMESTAMP_MILLIS,TIMESTAMP_MICROS,UNIX_SECONDS,UNIX_MILLIS,UNIX_MICROS";
  }

  @Override
  public String getSearchStringEscape() throws SQLException {
    return "\\";
  }

  @Override
  public String getExtraNameCharacters() throws SQLException {
    return "";
  }

  @Override
  public boolean supportsAlterTableWithAddColumn() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsAlterTableWithDropColumn() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsColumnAliasing() throws SQLException {
    return true;
  }

  @Override
  public boolean nullPlusNonNullIsNull() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsConvert() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsConvert(int fromType, int toType) throws SQLException {
    return false;
  }

  @Override
  public boolean supportsTableCorrelationNames() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsDifferentTableCorrelationNames() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsExpressionsInOrderBy() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsOrderByUnrelated() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsGroupBy() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsGroupByUnrelated() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsGroupByBeyondSelect() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsLikeEscapeClause() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsMultipleResultSets() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsMultipleTransactions() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsNonNullableColumns() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsMinimumSQLGrammar() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsCoreSQLGrammar() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsExtendedSQLGrammar() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsANSI92EntryLevelSQL() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsANSI92IntermediateSQL() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsANSI92FullSQL() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsIntegrityEnhancementFacility() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsOuterJoins() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsFullOuterJoins() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsLimitedOuterJoins() throws SQLException {
    return true;
  }

  @Override
  public String getSchemaTerm() throws SQLException {
    return "SCHEMA";
  }

  @Override
  public String getProcedureTerm() throws SQLException {
    return "PROCEDURE";
  }

  @Override
  public String getCatalogTerm() throws SQLException {
    // Spanner does not support catalogs, but the term is included for compatibility with the SQL
    // standard
    return "CATALOG";
  }

  @Override
  public boolean isCatalogAtStart() throws SQLException {
    return false;
  }

  @Override
  public String getCatalogSeparator() throws SQLException {
    return ".";
  }

  @Override
  public boolean supportsSchemasInDataManipulation() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsSchemasInProcedureCalls() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsSchemasInTableDefinitions() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsSchemasInIndexDefinitions() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsCatalogsInDataManipulation() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsCatalogsInProcedureCalls() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsCatalogsInTableDefinitions() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsPositionedDelete() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsPositionedUpdate() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsSelectForUpdate() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsStoredProcedures() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsSubqueriesInComparisons() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsSubqueriesInExists() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsSubqueriesInIns() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsSubqueriesInQuantifieds() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsCorrelatedSubqueries() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsUnion() throws SQLException {
    // Note that Cloud Spanner requires the user to specify 'UNION DISTINCT' or 'UNION ALL' in a
    // query. 'UNION DISTINCT' is equal to the SQL operation 'UNION'.
    return true;
  }

  @Override
  public boolean supportsUnionAll() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
    return true;
  }

  @Override
  public int getMaxBinaryLiteralLength() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxCharLiteralLength() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxColumnNameLength() throws SQLException {
    return 128;
  }

  @Override
  public int getMaxColumnsInGroupBy() throws SQLException {
    return 1000;
  }

  @Override
  public int getMaxColumnsInIndex() throws SQLException {
    return 16;
  }

  @Override
  public int getMaxColumnsInOrderBy() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxColumnsInSelect() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxColumnsInTable() throws SQLException {
    return 1024;
  }

  @Override
  public int getMaxConnections() throws SQLException {
    // there is a max number of sessions, but that is not the same as the max number of connections
    return 0;
  }

  @Override
  public int getMaxCursorNameLength() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxIndexLength() throws SQLException {
    return 8000;
  }

  @Override
  public int getMaxSchemaNameLength() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxProcedureNameLength() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxCatalogNameLength() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxRowSize() throws SQLException {
    return 1024 * 10000000;
  }

  @Override
  public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
    return true;
  }

  @Override
  public int getMaxStatementLength() throws SQLException {
    return 1000000;
  }

  @Override
  public int getMaxStatements() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxTableNameLength() throws SQLException {
    return 128;
  }

  @Override
  public int getMaxTablesInSelect() throws SQLException {
    return 0;
  }

  @Override
  public int getMaxUserNameLength() throws SQLException {
    return 0;
  }

  @Override
  public int getDefaultTransactionIsolation() throws SQLException {
    return Connection.TRANSACTION_SERIALIZABLE;
  }

  @Override
  public boolean supportsTransactions() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsTransactionIsolationLevel(int level) throws SQLException {
    return Connection.TRANSACTION_SERIALIZABLE == level;
  }

  @Override
  public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
    return true;
  }

  @Override
  public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
    return false;
  }

  @Override
  public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
    return false;
  }

  @Override
  public ResultSet getProcedures(String catalog, String schemaPattern, String procedureNamePattern)
      throws SQLException {
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("PROCEDURE_CAT", Type.string()),
                StructField.of("PROCEDURE_SCHEM", Type.string()),
                StructField.of("PROCEDURE_NAME", Type.string()),
                StructField.of("reserved1", Type.string()),
                StructField.of("reserved2", Type.string()),
                StructField.of("reserved3", Type.string()),
                StructField.of("REMARKS", Type.string()),
                StructField.of("PROCEDURE_TYPE", Type.int64()),
                StructField.of("SPECIFIC_NAME", Type.string())),
            Collections.<Struct>emptyList()));
  }

  @Override
  public ResultSet getProcedureColumns(
      String catalog, String schemaPattern, String procedureNamePattern, String columnNamePattern)
      throws SQLException {
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("PROCEDURE_CAT", Type.string()),
                StructField.of("PROCEDURE_SCHEM", Type.string()),
                StructField.of("PROCEDURE_NAME", Type.string()),
                StructField.of("COLUMN_NAME", Type.string()),
                StructField.of("COLUMN_TYPE", Type.int64()),
                StructField.of("DATA_TYPE", Type.int64()),
                StructField.of("TYPE_NAME", Type.string()),
                StructField.of("PRECISION", Type.string()),
                StructField.of("LENGTH", Type.int64()),
                StructField.of("SCALE", Type.int64()),
                StructField.of("RADIX", Type.int64()),
                StructField.of("NULLABLE", Type.int64()),
                StructField.of("REMARKS", Type.string()),
                StructField.of("COLUMN_DEF", Type.string()),
                StructField.of("SQL_DATA_TYPE", Type.int64()),
                StructField.of("SQL_DATETIME_SUB", Type.int64()),
                StructField.of("CHAR_OCTET_LENGTH", Type.int64()),
                StructField.of("ORDINAL_POSITION", Type.int64()),
                StructField.of("IS_NULLABLE", Type.string()),
                StructField.of("SPECIFIC_NAME", Type.string())),
            Collections.<Struct>emptyList()));
  }

  private JdbcPreparedStatement prepareStatementReplaceNullWithAnyString(
      String sql, String... params) throws SQLException {
    JdbcPreparedStatement statement = connection.prepareStatement(sql);
    int paramIndex = 1;
    for (String param : params) {
      if (param == null) {
        statement.setString(paramIndex, "%");
      } else {
        statement.setString(paramIndex, param.toUpperCase());
      }
      paramIndex++;
    }
    return statement;
  }

  @Override
  public ResultSet getTables(
      String catalog, String schemaPattern, String tableNamePattern, String[] types)
      throws SQLException {
    String sql = readSqlFromFile("DatabaseMetaData_GetTables.sql");
    String type1;
    String type2;
    if (types == null || types.length == 0) {
      type1 = "TABLE";
      type2 = "VIEW";
    } else if (types.length == 1) {
      type1 = types[0];
      type2 = "NON_EXISTENT_TYPE";
    } else {
      type1 = types[0];
      type2 = types[1];
    }
    JdbcPreparedStatement statement =
        prepareStatementReplaceNullWithAnyString(
            sql, catalog, schemaPattern, tableNamePattern, type1, type2);
    return statement.executeQueryWithOptions(InternalMetadataQuery.INSTANCE);
  }

  @Override
  public ResultSet getSchemas() throws SQLException {
    return getSchemas(null, null);
  }

  @Override
  public ResultSet getCatalogs() throws SQLException {
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(StructField.of("TABLE_CAT", Type.string())),
            Arrays.asList(Struct.newBuilder().set("TABLE_CAT").to("").build())));
  }

  @Override
  public ResultSet getTableTypes() throws SQLException {
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(StructField.of("TABLE_TYPE", Type.string())),
            Arrays.asList(
                Struct.newBuilder().set("TABLE_TYPE").to("TABLE").build(),
                Struct.newBuilder().set("TABLE_TYPE").to("VIEW").build())));
  }

  @Override
  public ResultSet getColumns(
      String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern)
      throws SQLException {
    String sql = readSqlFromFile("DatabaseMetaData_GetColumns.sql");
    JdbcPreparedStatement statement =
        prepareStatementReplaceNullWithAnyString(
            sql, catalog, schemaPattern, tableNamePattern, columnNamePattern);
    return statement.executeQueryWithOptions(InternalMetadataQuery.INSTANCE);
  }

  @Override
  public ResultSet getColumnPrivileges(
      String catalog, String schema, String table, String columnNamePattern) throws SQLException {
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("TABLE_CAT", Type.string()),
                StructField.of("TABLE_SCHEM", Type.string()),
                StructField.of("TABLE_NAME", Type.string()),
                StructField.of("COLUMN_NAME", Type.string()),
                StructField.of("GRANTOR", Type.string()),
                StructField.of("GRANTEE", Type.string()),
                StructField.of("PRIVILEGE", Type.string()),
                StructField.of("IS_GRANTABLE", Type.string())),
            Collections.<Struct>emptyList()));
  }

  @Override
  public ResultSet getTablePrivileges(String catalog, String schemaPattern, String tableNamePattern)
      throws SQLException {
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("TABLE_CAT", Type.string()),
                StructField.of("TABLE_SCHEM", Type.string()),
                StructField.of("TABLE_NAME", Type.string()),
                StructField.of("GRANTOR", Type.string()),
                StructField.of("GRANTEE", Type.string()),
                StructField.of("PRIVILEGE", Type.string()),
                StructField.of("IS_GRANTABLE", Type.string())),
            Collections.<Struct>emptyList()));
  }

  @Override
  public ResultSet getBestRowIdentifier(
      String catalog, String schema, String table, int scope, boolean nullable)
      throws SQLException {
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("SCOPE", Type.int64()),
                StructField.of("COLUMN_NAME", Type.string()),
                StructField.of("DATA_TYPE", Type.int64()),
                StructField.of("TYPE_NAME", Type.string()),
                StructField.of("COLUMN_SIZE", Type.int64()),
                StructField.of("BUFFER_LENGTH", Type.int64()),
                StructField.of("DECIMAL_DIGITS", Type.int64()),
                StructField.of("PSEUDO_COLUMN", Type.int64())),
            Collections.<Struct>emptyList()));
  }

  @Override
  public ResultSet getVersionColumns(String catalog, String schema, String table)
      throws SQLException {
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("SCOPE", Type.int64()),
                StructField.of("COLUMN_NAME", Type.string()),
                StructField.of("DATA_TYPE", Type.int64()),
                StructField.of("TYPE_NAME", Type.string()),
                StructField.of("COLUMN_SIZE", Type.int64()),
                StructField.of("BUFFER_LENGTH", Type.int64()),
                StructField.of("DECIMAL_DIGITS", Type.int64()),
                StructField.of("PSEUDO_COLUMN", Type.int64())),
            Collections.<Struct>emptyList()));
  }

  @Override
  public ResultSet getPrimaryKeys(String catalog, String schema, String table) throws SQLException {
    JdbcPreconditions.checkArgument(table != null, "table may not be null");
    String sql = readSqlFromFile("DatabaseMetaData_GetPrimaryKeys.sql");
    JdbcPreparedStatement statement =
        prepareStatementReplaceNullWithAnyString(sql, catalog, schema, table);
    return statement.executeQueryWithOptions(InternalMetadataQuery.INSTANCE);
  }

  @Override
  public ResultSet getImportedKeys(String catalog, String schema, String table)
      throws SQLException {
    JdbcPreconditions.checkArgument(table != null, "table may not be null");
    String sql = readSqlFromFile("DatabaseMetaData_GetImportedKeys.sql");
    JdbcPreparedStatement statement =
        prepareStatementReplaceNullWithAnyString(sql, catalog, schema, table);
    return statement.executeQueryWithOptions(InternalMetadataQuery.INSTANCE);
  }

  @Override
  public ResultSet getExportedKeys(String catalog, String schema, String table)
      throws SQLException {
    JdbcPreconditions.checkArgument(table != null, "table may not be null");
    String sql = readSqlFromFile("DatabaseMetaData_GetExportedKeys.sql");
    JdbcPreparedStatement statement =
        prepareStatementReplaceNullWithAnyString(sql, catalog, schema, table);
    return statement.executeQueryWithOptions(InternalMetadataQuery.INSTANCE);
  }

  @Override
  public ResultSet getCrossReference(
      String parentCatalog,
      String parentSchema,
      String parentTable,
      String foreignCatalog,
      String foreignSchema,
      String foreignTable)
      throws SQLException {
    String sql = readSqlFromFile("DatabaseMetaData_GetCrossReferences.sql");
    JdbcPreparedStatement statement =
        prepareStatementReplaceNullWithAnyString(
            sql,
            parentCatalog,
            parentSchema,
            parentTable,
            foreignCatalog,
            foreignSchema,
            foreignTable);
    return statement.executeQueryWithOptions(InternalMetadataQuery.INSTANCE);
  }

  @Override
  public ResultSet getTypeInfo() throws SQLException {
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("TYPE_NAME", Type.string()),
                StructField.of("DATA_TYPE", Type.int64()),
                StructField.of("PRECISION", Type.int64()),
                StructField.of("LITERAL_PREFIX", Type.string()),
                StructField.of("LITERAL_SUFFIX", Type.string()),
                StructField.of("CREATE_PARAMS", Type.string()),
                StructField.of("NULLABLE", Type.int64()),
                StructField.of("CASE_SENSITIVE", Type.bool()),
                StructField.of("SEARCHABLE", Type.int64()),
                StructField.of("UNSIGNED_ATTRIBUTE", Type.bool()),
                StructField.of("FIXED_PREC_SCALE", Type.bool()),
                StructField.of("AUTO_INCREMENT", Type.bool()),
                StructField.of("LOCAL_TYPE_NAME", Type.string()),
                StructField.of("MINIMUM_SCALE", Type.int64()),
                StructField.of("MAXIMUM_SCALE", Type.int64()),
                StructField.of("SQL_DATA_TYPE", Type.int64()),
                StructField.of("SQL_DATETIME_SUB", Type.int64()),
                StructField.of("NUM_PREC_RADIX", Type.int64())),
            Arrays.asList(
                Struct.newBuilder()
                    .set("TYPE_NAME")
                    .to("STRING")
                    .set("DATA_TYPE")
                    .to(Types.NVARCHAR) // -9
                    .set("PRECISION")
                    .to(2621440L)
                    .set("LITERAL_PREFIX")
                    .to((String) null)
                    .set("LITERAL_SUFFIX")
                    .to((String) null)
                    .set("CREATE_PARAMS")
                    .to("(length)")
                    .set("NULLABLE")
                    .to(DatabaseMetaData.typeNullable)
                    .set("CASE_SENSITIVE")
                    .to(true)
                    .set("SEARCHABLE")
                    .to(DatabaseMetaData.typeSearchable)
                    .set("UNSIGNED_ATTRIBUTE")
                    .to(true)
                    .set("FIXED_PREC_SCALE")
                    .to(false)
                    .set("AUTO_INCREMENT")
                    .to(false)
                    .set("LOCAL_TYPE_NAME")
                    .to("STRING")
                    .set("MINIMUM_SCALE")
                    .to(0)
                    .set("MAXIMUM_SCALE")
                    .to(0)
                    .set("SQL_DATA_TYPE")
                    .to((Long) null)
                    .set("SQL_DATETIME_SUB")
                    .to((Long) null)
                    .set("NUM_PREC_RADIX")
                    .to((Long) null)
                    .build(),
                Struct.newBuilder()
                    .set("TYPE_NAME")
                    .to("INT64")
                    .set("DATA_TYPE")
                    .to(Types.BIGINT) // -5
                    .set("PRECISION")
                    .to(19L)
                    .set("LITERAL_PREFIX")
                    .to((String) null)
                    .set("LITERAL_SUFFIX")
                    .to((String) null)
                    .set("CREATE_PARAMS")
                    .to((String) null)
                    .set("NULLABLE")
                    .to(DatabaseMetaData.typeNullable)
                    .set("CASE_SENSITIVE")
                    .to(false)
                    .set("SEARCHABLE")
                    .to(DatabaseMetaData.typePredBasic)
                    .set("UNSIGNED_ATTRIBUTE")
                    .to(false)
                    .set("FIXED_PREC_SCALE")
                    .to(false)
                    .set("AUTO_INCREMENT")
                    .to(false)
                    .set("LOCAL_TYPE_NAME")
                    .to("INT64")
                    .set("MINIMUM_SCALE")
                    .to(0)
                    .set("MAXIMUM_SCALE")
                    .to(0)
                    .set("SQL_DATA_TYPE")
                    .to((Long) null)
                    .set("SQL_DATETIME_SUB")
                    .to((Long) null)
                    .set("NUM_PREC_RADIX")
                    .to(10)
                    .build(),
                Struct.newBuilder()
                    .set("TYPE_NAME")
                    .to("BYTES")
                    .set("DATA_TYPE")
                    .to(Types.BINARY) // -2
                    .set("PRECISION")
                    .to(10485760L)
                    .set("LITERAL_PREFIX")
                    .to((String) null)
                    .set("LITERAL_SUFFIX")
                    .to((String) null)
                    .set("CREATE_PARAMS")
                    .to("(length)")
                    .set("NULLABLE")
                    .to(DatabaseMetaData.typeNullable)
                    .set("CASE_SENSITIVE")
                    .to(false)
                    .set("SEARCHABLE")
                    .to(DatabaseMetaData.typePredBasic)
                    .set("UNSIGNED_ATTRIBUTE")
                    .to(true)
                    .set("FIXED_PREC_SCALE")
                    .to(false)
                    .set("AUTO_INCREMENT")
                    .to(false)
                    .set("LOCAL_TYPE_NAME")
                    .to("BYTES")
                    .set("MINIMUM_SCALE")
                    .to(0)
                    .set("MAXIMUM_SCALE")
                    .to(0)
                    .set("SQL_DATA_TYPE")
                    .to((Long) null)
                    .set("SQL_DATETIME_SUB")
                    .to((Long) null)
                    .set("NUM_PREC_RADIX")
                    .to((Long) null)
                    .build(),
                Struct.newBuilder()
                    .set("TYPE_NAME")
                    .to("FLOAT64")
                    .set("DATA_TYPE")
                    .to(Types.DOUBLE) // 8
                    .set("PRECISION")
                    .to(15L)
                    .set("LITERAL_PREFIX")
                    .to((String) null)
                    .set("LITERAL_SUFFIX")
                    .to((String) null)
                    .set("CREATE_PARAMS")
                    .to((String) null)
                    .set("NULLABLE")
                    .to(DatabaseMetaData.typeNullable)
                    .set("CASE_SENSITIVE")
                    .to(false)
                    .set("SEARCHABLE")
                    .to(DatabaseMetaData.typePredBasic)
                    .set("UNSIGNED_ATTRIBUTE")
                    .to(false)
                    .set("FIXED_PREC_SCALE")
                    .to(false)
                    .set("AUTO_INCREMENT")
                    .to(false)
                    .set("LOCAL_TYPE_NAME")
                    .to("FLOAT64")
                    .set("MINIMUM_SCALE")
                    .to(0)
                    .set("MAXIMUM_SCALE")
                    .to(0)
                    .set("SQL_DATA_TYPE")
                    .to((Long) null)
                    .set("SQL_DATETIME_SUB")
                    .to((Long) null)
                    .set("NUM_PREC_RADIX")
                    .to(2)
                    .build(),
                Struct.newBuilder()
                    .set("TYPE_NAME")
                    .to("BOOL")
                    .set("DATA_TYPE")
                    .to(Types.BOOLEAN) // 16
                    .set("PRECISION")
                    .to((Long) null)
                    .set("LITERAL_PREFIX")
                    .to((String) null)
                    .set("LITERAL_SUFFIX")
                    .to((String) null)
                    .set("CREATE_PARAMS")
                    .to((String) null)
                    .set("NULLABLE")
                    .to(DatabaseMetaData.typeNullable)
                    .set("CASE_SENSITIVE")
                    .to(false)
                    .set("SEARCHABLE")
                    .to(DatabaseMetaData.typePredBasic)
                    .set("UNSIGNED_ATTRIBUTE")
                    .to(true)
                    .set("FIXED_PREC_SCALE")
                    .to(false)
                    .set("AUTO_INCREMENT")
                    .to(false)
                    .set("LOCAL_TYPE_NAME")
                    .to("BOOL")
                    .set("MINIMUM_SCALE")
                    .to(0)
                    .set("MAXIMUM_SCALE")
                    .to(0)
                    .set("SQL_DATA_TYPE")
                    .to((Long) null)
                    .set("SQL_DATETIME_SUB")
                    .to((Long) null)
                    .set("NUM_PREC_RADIX")
                    .to((Long) null)
                    .build(),
                Struct.newBuilder()
                    .set("TYPE_NAME")
                    .to("DATE")
                    .set("DATA_TYPE")
                    .to(Types.DATE) // 91
                    .set("PRECISION")
                    .to(10L)
                    .set("LITERAL_PREFIX")
                    .to("DATE ")
                    .set("LITERAL_SUFFIX")
                    .to((String) null)
                    .set("CREATE_PARAMS")
                    .to((String) null)
                    .set("NULLABLE")
                    .to(DatabaseMetaData.typeNullable)
                    .set("CASE_SENSITIVE")
                    .to(false)
                    .set("SEARCHABLE")
                    .to(DatabaseMetaData.typePredBasic)
                    .set("UNSIGNED_ATTRIBUTE")
                    .to(true)
                    .set("FIXED_PREC_SCALE")
                    .to(false)
                    .set("AUTO_INCREMENT")
                    .to(false)
                    .set("LOCAL_TYPE_NAME")
                    .to("DATE")
                    .set("MINIMUM_SCALE")
                    .to(0)
                    .set("MAXIMUM_SCALE")
                    .to(0)
                    .set("SQL_DATA_TYPE")
                    .to((Long) null)
                    .set("SQL_DATETIME_SUB")
                    .to((Long) null)
                    .set("NUM_PREC_RADIX")
                    .to((Long) null)
                    .build(),
                Struct.newBuilder()
                    .set("TYPE_NAME")
                    .to("TIMESTAMP")
                    .set("DATA_TYPE")
                    .to(Types.TIMESTAMP) // 93
                    .set("PRECISION")
                    .to(35L)
                    .set("LITERAL_PREFIX")
                    .to("TIMESTAMP ")
                    .set("LITERAL_SUFFIX")
                    .to((String) null)
                    .set("CREATE_PARAMS")
                    .to((String) null)
                    .set("NULLABLE")
                    .to(DatabaseMetaData.typeNullable)
                    .set("CASE_SENSITIVE")
                    .to(false)
                    .set("SEARCHABLE")
                    .to(DatabaseMetaData.typePredBasic)
                    .set("UNSIGNED_ATTRIBUTE")
                    .to(true)
                    .set("FIXED_PREC_SCALE")
                    .to(false)
                    .set("AUTO_INCREMENT")
                    .to(false)
                    .set("LOCAL_TYPE_NAME")
                    .to("TIMESTAMP")
                    .set("MINIMUM_SCALE")
                    .to(0)
                    .set("MAXIMUM_SCALE")
                    .to(0)
                    .set("SQL_DATA_TYPE")
                    .to((Long) null)
                    .set("SQL_DATETIME_SUB")
                    .to((Long) null)
                    .set("NUM_PREC_RADIX")
                    .to((Long) null)
                    .build())));
  }

  @Override
  public ResultSet getIndexInfo(
      String catalog, String schema, String table, boolean unique, boolean approximate)
      throws SQLException {
    return getIndexInfo(catalog, schema, table, null, unique);
  }

  public ResultSet getIndexInfo(String catalog, String schema, String indexName)
      throws SQLException {
    return getIndexInfo(catalog, schema, null, indexName, false);
  }

  private ResultSet getIndexInfo(
      String catalog, String schema, String table, String indexName, boolean unique)
      throws SQLException {
    String sql = readSqlFromFile("DatabaseMetaData_GetIndexInfo.sql");
    JdbcPreparedStatement statement =
        prepareStatementReplaceNullWithAnyString(
            sql, catalog, schema, table, indexName, unique ? "YES" : "%");
    return statement.executeQueryWithOptions(InternalMetadataQuery.INSTANCE);
  }

  @Override
  public boolean supportsResultSetType(int type) throws SQLException {
    return type == ResultSet.TYPE_FORWARD_ONLY;
  }

  @Override
  public boolean supportsResultSetConcurrency(int type, int concurrency) throws SQLException {
    return type == ResultSet.TYPE_FORWARD_ONLY && concurrency == ResultSet.CONCUR_READ_ONLY;
  }

  @Override
  public boolean ownUpdatesAreVisible(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean ownDeletesAreVisible(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean ownInsertsAreVisible(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean othersUpdatesAreVisible(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean othersDeletesAreVisible(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean othersInsertsAreVisible(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean updatesAreDetected(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean deletesAreDetected(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean insertsAreDetected(int type) throws SQLException {
    return false;
  }

  @Override
  public boolean supportsBatchUpdates() throws SQLException {
    return true;
  }

  @Override
  public ResultSet getUDTs(
      String catalog, String schemaPattern, String typeNamePattern, int[] types)
      throws SQLException {
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("TYPE_CAT", Type.string()),
                StructField.of("TYPE_SCHEM", Type.string()),
                StructField.of("TYPE_NAME", Type.string()),
                StructField.of("CLASS_NAME", Type.string()),
                StructField.of("DATA_TYPE", Type.int64()),
                StructField.of("REMARKS", Type.string()),
                StructField.of("BASE_TYPE", Type.int64())),
            Collections.<Struct>emptyList()));
  }

  @Override
  public Connection getConnection() throws SQLException {
    return connection;
  }

  @Override
  public boolean supportsSavepoints() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsNamedParameters() throws SQLException {
    return false;
  }

  @Override
  public boolean supportsMultipleOpenResults() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsGetGeneratedKeys() throws SQLException {
    return false;
  }

  @Override
  public ResultSet getSuperTypes(String catalog, String schemaPattern, String typeNamePattern)
      throws SQLException {
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("TYPE_CAT", Type.string()),
                StructField.of("TYPE_SCHEM", Type.string()),
                StructField.of("TYPE_NAME", Type.string()),
                StructField.of("SUPERTYPE_CAT", Type.string()),
                StructField.of("SUPERTYPE_SCHEM", Type.string()),
                StructField.of("SUPERTYPE_NAME", Type.string())),
            Collections.<Struct>emptyList()));
  }

  @Override
  public ResultSet getSuperTables(String catalog, String schemaPattern, String tableNamePattern)
      throws SQLException {
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("TABLE_CAT", Type.string()),
                StructField.of("TABLE_SCHEM", Type.string()),
                StructField.of("TABLE_NAME", Type.string()),
                StructField.of("SUPERTABLE_NAME", Type.string())),
            Collections.<Struct>emptyList()));
  }

  @Override
  public ResultSet getAttributes(
      String catalog, String schemaPattern, String typeNamePattern, String attributeNamePattern)
      throws SQLException {
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("TYPE_CAT", Type.string()),
                StructField.of("TYPE_SCHEM", Type.string()),
                StructField.of("TYPE_NAME", Type.string()),
                StructField.of("ATTR_NAME", Type.string()),
                StructField.of("DATA_TYPE", Type.int64()),
                StructField.of("ATTR_TYPE_NAME", Type.string()),
                StructField.of("ATTR_SIZE", Type.int64()),
                StructField.of("DECIMAL_DIGITS", Type.int64()),
                StructField.of("NUM_PREC_RADIX", Type.int64()),
                StructField.of("NULLABLE", Type.int64()),
                StructField.of("REMARKS", Type.string()),
                StructField.of("ATTR_DEF", Type.string()),
                StructField.of("SQL_DATA_TYPE", Type.int64()),
                StructField.of("SQL_DATETIME_SUB", Type.int64()),
                StructField.of("CHAR_OCTET_LENGTH", Type.int64()),
                StructField.of("ORDINAL_POSITION", Type.int64()),
                StructField.of("IS_NULLABLE", Type.string()),
                StructField.of("SCOPE_CATALOG", Type.string()),
                StructField.of("SCOPE_SCHEMA", Type.string()),
                StructField.of("SCOPE_TABLE", Type.string()),
                StructField.of("SOURCE_DATA_TYPE", Type.int64())),
            Collections.<Struct>emptyList()));
  }

  @Override
  public boolean supportsResultSetHoldability(int holdability) throws SQLException {
    return holdability == ResultSet.CLOSE_CURSORS_AT_COMMIT;
  }

  @Override
  public int getResultSetHoldability() throws SQLException {
    return ResultSet.CLOSE_CURSORS_AT_COMMIT;
  }

  @Override
  public int getDatabaseMajorVersion() throws SQLException {
    return DATABASE_MAJOR_VERSION;
  }

  @Override
  public int getDatabaseMinorVersion() throws SQLException {
    return DATABASE_MINOR_VERSION;
  }

  @Override
  public int getJDBCMajorVersion() throws SQLException {
    return JDBC_MAJOR_VERSION;
  }

  @Override
  public int getJDBCMinorVersion() throws SQLException {
    return JDBC_MINOR_VERSION;
  }

  @Override
  public int getSQLStateType() throws SQLException {
    return sqlStateSQL;
  }

  @Override
  public boolean locatorsUpdateCopy() throws SQLException {
    return true;
  }

  @Override
  public boolean supportsStatementPooling() throws SQLException {
    return false;
  }

  @Override
  public RowIdLifetime getRowIdLifetime() throws SQLException {
    return RowIdLifetime.ROWID_UNSUPPORTED;
  }

  @Override
  public ResultSet getSchemas(String catalog, String schemaPattern) throws SQLException {
    String sql = readSqlFromFile("DatabaseMetaData_GetSchemas.sql");
    JdbcPreparedStatement statement =
        prepareStatementReplaceNullWithAnyString(sql, catalog, schemaPattern);
    return statement.executeQueryWithOptions(InternalMetadataQuery.INSTANCE);
  }

  @Override
  public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
    return false;
  }

  @Override
  public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
    return false;
  }

  @Override
  public ResultSet getClientInfoProperties() throws SQLException {
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("NAME", Type.string()),
                StructField.of("MAX_LEN", Type.string()),
                StructField.of("DEFAULT_VALUE", Type.string()),
                StructField.of("DESCRIPTION", Type.string())),
            Collections.<Struct>emptyList()));
  }

  @Override
  public ResultSet getFunctions(String catalog, String schemaPattern, String functionNamePattern)
      throws SQLException {
    // TODO: return system functions
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("FUNCTION_CAT", Type.string()),
                StructField.of("FUNCTION_SCHEM", Type.string()),
                StructField.of("FUNCTION_NAME", Type.string()),
                StructField.of("REMARKS", Type.string()),
                StructField.of("FUNCTION_TYPE", Type.int64()),
                StructField.of("SPECIFIC_NAME", Type.string())),
            Collections.<Struct>emptyList()));
  }

  @Override
  public ResultSet getFunctionColumns(
      String catalog, String schemaPattern, String functionNamePattern, String columnNamePattern)
      throws SQLException {
    // TODO: return system functions
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("FUNCTION_CAT", Type.string()),
                StructField.of("FUNCTION_SCHEM", Type.string()),
                StructField.of("FUNCTION_NAME", Type.string()),
                StructField.of("COLUMN_NAME", Type.string()),
                StructField.of("COLUMN_TYPE", Type.int64()),
                StructField.of("DATA_TYPE", Type.int64()),
                StructField.of("TYPE_NAME", Type.string()),
                StructField.of("PRECISION", Type.int64()),
                StructField.of("LENGTH", Type.int64()),
                StructField.of("SCALE", Type.int64()),
                StructField.of("RADIX", Type.int64()),
                StructField.of("NULLABLE", Type.int64()),
                StructField.of("REMARKS", Type.string()),
                StructField.of("CHAR_OCTET_LENGTH", Type.int64()),
                StructField.of("ORDINAL_POSITION", Type.int64()),
                StructField.of("IS_NULLABLE", Type.string()),
                StructField.of("SPECIFIC_NAME", Type.string())),
            Collections.<Struct>emptyList()));
  }

  @Override
  public ResultSet getPseudoColumns(
      String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern)
      throws SQLException {
    return JdbcResultSet.of(
        ResultSets.forRows(
            Type.struct(
                StructField.of("TABLE_CAT", Type.string()),
                StructField.of("TABLE_SCHEM", Type.string()),
                StructField.of("TABLE_NAME", Type.string()),
                StructField.of("COLUMN_NAME", Type.string()),
                StructField.of("DATA_TYPE", Type.int64()),
                StructField.of("COLUMN_SIZE", Type.int64()),
                StructField.of("DECIMAL_DIGITS", Type.int64()),
                StructField.of("NUM_PREC_RADIX", Type.int64()),
                StructField.of("COLUMN_USAGE", Type.string()),
                StructField.of("REMARKS", Type.string()),
                StructField.of("CHAR_OCTET_LENGTH", Type.int64()),
                StructField.of("IS_NULLABLE", Type.string())),
            Collections.<Struct>emptyList()));
  }

  @Override
  public boolean generatedKeyAlwaysReturned() throws SQLException {
    return false;
  }
}
