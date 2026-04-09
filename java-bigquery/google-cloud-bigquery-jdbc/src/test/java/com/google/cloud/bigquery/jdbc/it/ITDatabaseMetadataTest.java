/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery.jdbc.it;

import static java.sql.Types.TIME;
import static java.sql.Types.TIMESTAMP;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.google.cloud.ServiceOptions;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ITDatabaseMetadataTest extends ITBase {
  static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  static final String connection_uri =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
          + PROJECT_ID
          + ";OAUTHTYPE=3";
  private static final Random random = new Random();
  private static final int randomNumber = random.nextInt(9999);
  private static final String DATASET = "JDBC_PRESUBMIT_INTEGRATION_DATASET";
  private static final String DATASET2 = "JDBC_PRESUBMIT_INTEGRATION_DATASET_2";
  private static final String CONSTRAINTS_DATASET = "JDBC_CONSTRAINTS_TEST_DATASET";
  private static final String CONSTRAINTS_TABLE_NAME = "JDBC_CONSTRAINTS_TEST_TABLE";
  private static final String CONSTRAINTS_TABLE_NAME2 = "JDBC_CONSTRAINTS_TEST_TABLE2";
  private static final String CONSTRAINTS_TABLE_NAME3 = "JDBC_CONSTRAINTS_TEST_TABLE3";
  private static final Pattern VERSION_PATTERN =
      Pattern.compile("^(\\d+)\\.(\\d+)(?:\\.\\d+)+\\s*.*");
  private static final String DEFAULT_CATALOG = ServiceOptions.getDefaultProjectId();
  private static final String TABLE_NAME = "JDBC_DBMETADATA_TEST_TABLE" + randomNumber;
  private static String connectionUrl =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=%s;OAuthType=3;Timeout=3600;";

  @BeforeClass
  public static void beforeClass() throws InterruptedException, SQLException {
    // Set up Dataset
    ITBase.setUpTable(DATASET, TABLE_NAME);
  }

  @AfterClass
  public static void afterClass() throws SQLException {}

  @Test
  public void testGetCatalogs() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData metaData = connection.getMetaData();
    try {

      verifyCatalogHelper(metaData, ".", "Project", 128, DEFAULT_CATALOG, true, true);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  // This test is throwing the following error: [Simba][BigQueryJDBCDriver](100068) Error fetching
  // metadata
  @Test
  public void testGetSchemas() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData metaData = connection.getMetaData();
    try {

      verifySchemaHelper(connection, metaData, "Dataset", 1024, true, true);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testGetTableTypes() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData metaData = connection.getMetaData();
    try {
      // this is either 3 or 4 in different projects

      verifyTableTypes(metaData, Arrays.asList("EXTERNAL", "TABLE", "VIEW"));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testGetTables() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData metaData = connection.getMetaData();
    try {

      verifyGetTables(connection, metaData, DATASET);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  // this currently returns empty.
  // TODO: Make it return non-empty
  @Test
  public void testGetTablePrivileges() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData metaData = connection.getMetaData();
    try {

      verifyGetTablePrivileges(connection, metaData, DATASET);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testGetClientInfoProperties() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData metaData = connection.getMetaData();
    try {

      ResultSet resultSet = metaData.getClientInfoProperties();
      // Resultset is not empty
      assertTrue(resultSet.next());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testGetColumns() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData metaData = connection.getMetaData();
    try {

      verifyGetColumns(connection, metaData, DATASET);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testDriverMetadataInfo() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData metaData = connection.getMetaData();
    try {

      verifyDriverMetadata(
          metaData, 4, 2, "Google BigQuery", "SimbaJDBCDriverforGoogleBigQuery", VERSION_PATTERN);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testProcedure() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData metaData = connection.getMetaData();
    try {

      verifyTestProcedure(metaData, "procedure");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testAllBooleanMethods() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData metaData = connection.getMetaData();
    try {
      // This method toggles between true and false in different environments
      assertFalse(metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_NONE)); // f
      assertFalse(
          metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_READ_UNCOMMITTED));
      assertFalse(
          metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_READ_COMMITTED)); // f

      assertFalse(
          metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_REPEATABLE_READ)); // f
      assertTrue(metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE));
      assertEquals(Connection.TRANSACTION_SERIALIZABLE, metaData.getDefaultTransactionIsolation());
      assertTrue(metaData.supportsTransactions());

      verifyAllBooleanMethods(metaData);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testAllIntMethods() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData metaData = connection.getMetaData();
    try {
      verifyIntMethods(metaData);
      assertEquals(2, metaData.getResultSetHoldability()); // 2
      assertEquals(2, metaData.getDatabaseMajorVersion()); // 2
      assertEquals(0, metaData.getDatabaseMinorVersion()); // 0
      assertEquals(2, metaData.getSQLStateType());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testAllStringMethods() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData metaData = connection.getMetaData();
    try {
      verifyAllStringMethods(metaData, "procedure");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testGetPrimaryKeys() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData metaData = connection.getMetaData();
    try {
      verifyGetPrimaryKeys(connection, metaData, DATASET);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testTableConstraints() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    ResultSet primaryKey1 =
        connection
            .getMetaData()
            .getPrimaryKeys(PROJECT_ID, CONSTRAINTS_DATASET, CONSTRAINTS_TABLE_NAME);
    primaryKey1.next();
    Assertions.assertEquals("id", primaryKey1.getString(4));
    Assertions.assertFalse(primaryKey1.next());

    ResultSet primaryKey2 =
        connection
            .getMetaData()
            .getPrimaryKeys(PROJECT_ID, CONSTRAINTS_DATASET, CONSTRAINTS_TABLE_NAME2);
    primaryKey2.next();
    Assertions.assertEquals("first_name", primaryKey2.getString(4));
    primaryKey2.next();
    Assertions.assertEquals("last_name", primaryKey2.getString(4));
    Assertions.assertFalse(primaryKey2.next());

    ResultSet foreignKeys =
        connection
            .getMetaData()
            .getImportedKeys(PROJECT_ID, CONSTRAINTS_DATASET, CONSTRAINTS_TABLE_NAME);
    foreignKeys.next();
    Assertions.assertEquals(CONSTRAINTS_TABLE_NAME2, foreignKeys.getString(3));
    Assertions.assertEquals("first_name", foreignKeys.getString(4));
    Assertions.assertEquals("name", foreignKeys.getString(8));
    foreignKeys.next();
    Assertions.assertEquals(CONSTRAINTS_TABLE_NAME2, foreignKeys.getString(3));
    Assertions.assertEquals("last_name", foreignKeys.getString(4));
    Assertions.assertEquals("second_name", foreignKeys.getString(8));
    foreignKeys.next();
    Assertions.assertEquals(CONSTRAINTS_TABLE_NAME3, foreignKeys.getString(3));
    Assertions.assertEquals("address", foreignKeys.getString(4));
    Assertions.assertEquals("address", foreignKeys.getString(8));
    Assertions.assertFalse(foreignKeys.next());

    ResultSet crossReference =
        connection
            .getMetaData()
            .getCrossReference(
                PROJECT_ID,
                CONSTRAINTS_DATASET,
                CONSTRAINTS_TABLE_NAME2,
                PROJECT_ID,
                CONSTRAINTS_DATASET,
                CONSTRAINTS_TABLE_NAME);
    crossReference.next();
    Assertions.assertEquals(CONSTRAINTS_TABLE_NAME2, crossReference.getString(3));
    Assertions.assertEquals("first_name", crossReference.getString(4));
    Assertions.assertEquals("name", crossReference.getString(8));
    crossReference.next();
    Assertions.assertEquals("last_name", crossReference.getString(4));
    Assertions.assertEquals("second_name", crossReference.getString(8));
    Assertions.assertFalse(crossReference.next());
    connection.close();
  }

  @Test
  public void testDatabaseMetadataGetCatalogs() throws SQLException {

    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData databaseMetaData = connection.getMetaData();
    try (ResultSet rs = databaseMetaData.getCatalogs()) {
      assertNotNull(rs, "ResultSet from getCatalogs() should not be null");

      ResultSetMetaData rsmd = rs.getMetaData();
      assertNotNull(rsmd, "ResultSetMetaData should not be null");
      Assertions.assertEquals(1, rsmd.getColumnCount(), "Should have one column");
      Assertions.assertEquals(
          "TABLE_CAT", rsmd.getColumnName(1), "Column name should be TABLE_CAT");

      Assertions.assertTrue(rs.next(), "ResultSet should have one row");
      Assertions.assertEquals(
          PROJECT_ID, rs.getString("TABLE_CAT"), "Catalog name should match Project ID");
      Assertions.assertFalse(rs.next(), "ResultSet should have no more rows");
    }
    connection.close();
  }

  @Test
  public void testDatabaseMetadataGetProcedures() throws SQLException {

    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    String DATASET = "JDBC_INTEGRATION_DATASET";
    String procedureName = "create_customer";
    DatabaseMetaData databaseMetaData = connection.getMetaData();
    ResultSet resultSet = databaseMetaData.getProcedures(PROJECT_ID, DATASET, procedureName);
    while (resultSet.next()) {
      Assertions.assertEquals(PROJECT_ID, resultSet.getString("PROCEDURE_CAT"));
      Assertions.assertEquals(DATASET, resultSet.getString("PROCEDURE_SCHEM"));
      Assertions.assertEquals(procedureName, resultSet.getString("PROCEDURE_NAME"));
      Assertions.assertEquals(procedureName, resultSet.getString("SPECIFIC_NAME"));
      Assertions.assertEquals(
          DatabaseMetaData.procedureResultUnknown, resultSet.getInt("PROCEDURE_TYPE"));
    }
    resultSet.close();
    connection.close();
  }

  @Test
  public void testDatabaseMetadataGetProcedureColumns() throws SQLException {

    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData databaseMetaData = connection.getMetaData();

    // --- Test Case 1: Specific schema and procedure, null column name pattern ---
    String specificSchema = "JDBC_INTEGRATION_DATASET";
    String specificProcedure = "create_customer";
    ResultSet resultSet =
        databaseMetaData.getProcedureColumns(PROJECT_ID, specificSchema, specificProcedure, null);
    int specificProcRows = 0;
    boolean foundNameParam = false;
    boolean foundIdParam = false;
    while (resultSet.next()) {
      specificProcRows++;
      Assertions.assertEquals(PROJECT_ID, resultSet.getString("PROCEDURE_CAT"));
      Assertions.assertEquals(specificSchema, resultSet.getString("PROCEDURE_SCHEM"));
      Assertions.assertEquals(specificProcedure, resultSet.getString("PROCEDURE_NAME"));
      Assertions.assertEquals(specificProcedure, resultSet.getString("SPECIFIC_NAME"));
      if ("name".equals(resultSet.getString("COLUMN_NAME"))) {
        foundNameParam = true;
        Assertions.assertEquals(1, resultSet.getInt("ORDINAL_POSITION"));
      }
      if ("id".equals(resultSet.getString("COLUMN_NAME"))) {
        foundIdParam = true;
        Assertions.assertEquals(2, resultSet.getInt("ORDINAL_POSITION"));
      }
    }
    Assertions.assertEquals(
        2, specificProcRows, "Should find 2 parameters for " + specificProcedure);
    Assertions.assertTrue(foundNameParam, "Parameter 'name' should be found");
    Assertions.assertTrue(foundIdParam, "Parameter 'id' should be found");
    resultSet.close();

    // --- Test Case 2: Specific schema, procedure, and column name pattern ---
    String specificColumn = "name";
    resultSet =
        databaseMetaData.getProcedureColumns(
            PROJECT_ID, specificSchema, specificProcedure, specificColumn);
    Assertions.assertTrue(resultSet.next(), "Should find the specific column 'name'");
    Assertions.assertEquals(PROJECT_ID, resultSet.getString("PROCEDURE_CAT"));
    Assertions.assertEquals(specificSchema, resultSet.getString("PROCEDURE_SCHEM"));
    Assertions.assertEquals(specificProcedure, resultSet.getString("PROCEDURE_NAME"));
    Assertions.assertEquals(specificColumn, resultSet.getString("COLUMN_NAME"));
    Assertions.assertEquals(1, resultSet.getInt("ORDINAL_POSITION"));
    Assertions.assertEquals(
        (short) DatabaseMetaData.procedureColumnUnknown, resultSet.getShort("COLUMN_TYPE"));
    Assertions.assertEquals(java.sql.Types.NVARCHAR, resultSet.getInt("DATA_TYPE"));
    Assertions.assertEquals("NVARCHAR", resultSet.getString("TYPE_NAME"));
    Assertions.assertFalse(resultSet.next(), "Should only find one row for exact column match");
    resultSet.close();

    // --- Test Case 3: Non-existent procedure ---
    resultSet =
        databaseMetaData.getProcedureColumns(
            PROJECT_ID, specificSchema, "non_existent_procedure_xyz", null);
    Assertions.assertFalse(
        resultSet.next(), "Should not find columns for a non-existent procedure");
    resultSet.close();
    connection.close();
  }

  @Test
  public void testDatabaseMetadataGetColumns() throws SQLException {

    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    String DATASET = "JDBC_INTEGRATION_DATASET";
    String TABLE_NAME = "JDBC_DATATYPES_INTEGRATION_TEST_TABLE";
    DatabaseMetaData databaseMetaData = connection.getMetaData();

    // --- Test Case 1: Specific Column (StringField) ---
    ResultSet resultSet =
        databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "StringField");

    Assertions.assertTrue(resultSet.next());
    Assertions.assertEquals(PROJECT_ID, resultSet.getString("TABLE_CAT"));
    Assertions.assertEquals(DATASET, resultSet.getString("TABLE_SCHEM"));
    Assertions.assertEquals(TABLE_NAME, resultSet.getString("TABLE_NAME"));
    Assertions.assertEquals("StringField", resultSet.getString("COLUMN_NAME"));
    Assertions.assertEquals("NVARCHAR", resultSet.getString("TYPE_NAME"));
    resultSet.getObject("COLUMN_SIZE");
    Assertions.assertTrue(resultSet.wasNull());
    resultSet.getObject("DECIMAL_DIGITS");
    Assertions.assertTrue(resultSet.wasNull());
    Assertions.assertEquals(1, resultSet.getInt("NULLABLE"));
    Assertions.assertEquals(6, resultSet.getInt("ORDINAL_POSITION"));
    Assertions.assertFalse(resultSet.next());

    // --- Test Case 2: All Columns ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, null);
    Assertions.assertTrue(resultSet.next());
    int count = 0;
    do {
      count++;
      Assertions.assertEquals(PROJECT_ID, resultSet.getString("TABLE_CAT"));
      Assertions.assertEquals(DATASET, resultSet.getString("TABLE_SCHEM"));
      Assertions.assertEquals(TABLE_NAME, resultSet.getString("TABLE_NAME"));
      assertNotNull(resultSet.getString("COLUMN_NAME"));
    } while (resultSet.next());
    Assertions.assertEquals(16, count);

    // --- Test Case 3: Column Name Pattern Matching (%Field) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "%Time%");
    Assertions.assertTrue(resultSet.next());
    count = 0;
    do {
      count++;
      String columnName = resultSet.getString("COLUMN_NAME");
      Assertions.assertTrue(columnName.contains("Time"));
    } while (resultSet.next());
    Assertions.assertEquals(3, count);

    // --- Test Case 4: Column Name Pattern Matching (Integer%) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "Integer%");
    Assertions.assertTrue(resultSet.next());
    Assertions.assertEquals("IntegerField", resultSet.getString("COLUMN_NAME"));
    Assertions.assertEquals("BIGINT", resultSet.getString("TYPE_NAME"));
    Assertions.assertEquals(19, resultSet.getInt("COLUMN_SIZE"));
    Assertions.assertEquals(0, resultSet.getInt("DECIMAL_DIGITS"));
    Assertions.assertEquals(10, resultSet.getInt("NUM_PREC_RADIX"));
    Assertions.assertEquals(1, resultSet.getInt("NULLABLE"));
    Assertions.assertEquals(2, resultSet.getInt("ORDINAL_POSITION"));
    Assertions.assertFalse(resultSet.next());

    // --- Test Case 5: Specific Column (BooleanField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "BooleanField");
    Assertions.assertTrue(resultSet.next());
    Assertions.assertEquals("BooleanField", resultSet.getString("COLUMN_NAME"));
    Assertions.assertEquals("BOOLEAN", resultSet.getString("TYPE_NAME"));
    Assertions.assertEquals(1, resultSet.getInt("COLUMN_SIZE"));
    resultSet.getObject("DECIMAL_DIGITS");
    Assertions.assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    Assertions.assertTrue(resultSet.wasNull());
    Assertions.assertEquals(1, resultSet.getInt("NULLABLE"));
    Assertions.assertEquals(1, resultSet.getInt("ORDINAL_POSITION"));
    Assertions.assertFalse(resultSet.next());

    // --- Test Case 6: Specific Column (NumericField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "NumericField");
    Assertions.assertTrue(resultSet.next());
    Assertions.assertEquals("NumericField", resultSet.getString("COLUMN_NAME"));
    Assertions.assertEquals("NUMERIC", resultSet.getString("TYPE_NAME"));
    Assertions.assertEquals(38, resultSet.getInt("COLUMN_SIZE"));
    Assertions.assertEquals(9, resultSet.getInt("DECIMAL_DIGITS"));
    Assertions.assertEquals(10, resultSet.getInt("NUM_PREC_RADIX"));
    Assertions.assertEquals(1, resultSet.getInt("NULLABLE"));
    Assertions.assertEquals(4, resultSet.getInt("ORDINAL_POSITION"));
    Assertions.assertFalse(resultSet.next());

    // --- Test Case 7: Specific Column (BytesField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "BytesField");
    Assertions.assertTrue(resultSet.next());
    Assertions.assertEquals("BytesField", resultSet.getString("COLUMN_NAME"));
    Assertions.assertEquals("VARBINARY", resultSet.getString("TYPE_NAME"));
    resultSet.getObject("COLUMN_SIZE");
    Assertions.assertTrue(resultSet.wasNull());
    resultSet.getObject("DECIMAL_DIGITS");
    Assertions.assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    Assertions.assertTrue(resultSet.wasNull());
    Assertions.assertEquals(1, resultSet.getInt("NULLABLE"));
    Assertions.assertEquals(7, resultSet.getInt("ORDINAL_POSITION"));
    Assertions.assertFalse(resultSet.next());

    // --- Test Case 8: Specific Column (ArrayField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "ArrayField");
    Assertions.assertTrue(resultSet.next());
    Assertions.assertEquals("ArrayField", resultSet.getString("COLUMN_NAME"));
    Assertions.assertEquals("ARRAY", resultSet.getString("TYPE_NAME"));
    resultSet.getObject("COLUMN_SIZE");
    Assertions.assertTrue(resultSet.wasNull());
    resultSet.getObject("DECIMAL_DIGITS");
    Assertions.assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    Assertions.assertTrue(resultSet.wasNull());
    Assertions.assertEquals(1, resultSet.getInt("NULLABLE"));
    Assertions.assertEquals(9, resultSet.getInt("ORDINAL_POSITION"));
    Assertions.assertFalse(resultSet.next());

    // --- Test Case 9: Specific Column (TimestampField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "TimestampField");
    Assertions.assertTrue(resultSet.next());
    Assertions.assertEquals("TimestampField", resultSet.getString("COLUMN_NAME"));
    Assertions.assertEquals("TIMESTAMP", resultSet.getString("TYPE_NAME"));
    Assertions.assertEquals(29, resultSet.getInt("COLUMN_SIZE"));
    resultSet.getObject("DECIMAL_DIGITS");
    Assertions.assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    Assertions.assertTrue(resultSet.wasNull());
    Assertions.assertEquals(1, resultSet.getInt("NULLABLE"));
    Assertions.assertEquals(10, resultSet.getInt("ORDINAL_POSITION"));
    Assertions.assertFalse(resultSet.next());

    // --- Test Case 10: Specific Column (DateField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "DateField");
    Assertions.assertTrue(resultSet.next());
    Assertions.assertEquals("DateField", resultSet.getString("COLUMN_NAME"));
    Assertions.assertEquals("DATE", resultSet.getString("TYPE_NAME"));
    Assertions.assertEquals(10, resultSet.getInt("COLUMN_SIZE"));
    resultSet.getObject("DECIMAL_DIGITS");
    Assertions.assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    Assertions.assertTrue(resultSet.wasNull());
    Assertions.assertEquals(1, resultSet.getInt("NULLABLE"));
    Assertions.assertEquals(11, resultSet.getInt("ORDINAL_POSITION"));
    Assertions.assertFalse(resultSet.next());

    // --- Test Case 11: Specific Column (TimeField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "TimeField");
    Assertions.assertTrue(resultSet.next());
    Assertions.assertEquals("TimeField", resultSet.getString("COLUMN_NAME"));
    Assertions.assertEquals("TIME", resultSet.getString("TYPE_NAME"));
    Assertions.assertEquals(15, resultSet.getInt("COLUMN_SIZE"));
    resultSet.getObject("DECIMAL_DIGITS");
    Assertions.assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    Assertions.assertTrue(resultSet.wasNull());
    Assertions.assertEquals(1, resultSet.getInt("NULLABLE"));
    Assertions.assertEquals(12, resultSet.getInt("ORDINAL_POSITION"));
    Assertions.assertFalse(resultSet.next());

    // --- Test Case 12: Specific Column (DateTimeField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "DateTimeField");
    Assertions.assertTrue(resultSet.next());
    Assertions.assertEquals("DateTimeField", resultSet.getString("COLUMN_NAME"));
    Assertions.assertEquals("TIMESTAMP", resultSet.getString("TYPE_NAME"));
    Assertions.assertEquals(29, resultSet.getInt("COLUMN_SIZE"));
    resultSet.getObject("DECIMAL_DIGITS");
    Assertions.assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    Assertions.assertTrue(resultSet.wasNull());
    Assertions.assertEquals(1, resultSet.getInt("NULLABLE"));
    Assertions.assertEquals(13, resultSet.getInt("ORDINAL_POSITION"));
    Assertions.assertFalse(resultSet.next());

    // --- Test Case 13: Specific Column (GeographyField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "GeographyField");
    Assertions.assertTrue(resultSet.next());
    Assertions.assertEquals("GeographyField", resultSet.getString("COLUMN_NAME"));
    Assertions.assertEquals("VARCHAR", resultSet.getString("TYPE_NAME"));
    resultSet.getObject("COLUMN_SIZE");
    Assertions.assertTrue(resultSet.wasNull());
    resultSet.getObject("DECIMAL_DIGITS");
    Assertions.assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    Assertions.assertTrue(resultSet.wasNull());
    Assertions.assertEquals(1, resultSet.getInt("NULLABLE"));
    Assertions.assertEquals(14, resultSet.getInt("ORDINAL_POSITION"));
    Assertions.assertFalse(resultSet.next());

    connection.close();
  }

  @Test
  public void testDatabaseMetadataGetTables() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData databaseMetaData = connection.getMetaData();
    String DATASET = "JDBC_TABLE_TYPES_TEST";

    // --- Test Case 1: Get all tables (types = null) ---
    ResultSet rsAll = databaseMetaData.getTables(PROJECT_ID, DATASET, null, null);
    Set<String> allTableNames = new HashSet<>();
    while (rsAll.next()) {
      allTableNames.add(rsAll.getString("TABLE_NAME"));
    }
    Assertions.assertTrue(allTableNames.contains("base_table"));
    Assertions.assertTrue(allTableNames.contains("my_view"));
    Assertions.assertTrue(allTableNames.contains("external_table"));
    Assertions.assertTrue(allTableNames.contains("my_materialized_view"));
    Assertions.assertTrue(allTableNames.contains("base_table_clone"));
    Assertions.assertTrue(allTableNames.contains("base_table_snapshot"));
    Assertions.assertEquals(6, allTableNames.size());

    // --- Test Case 2: Get only "TABLE" type ---
    ResultSet rsTable =
        databaseMetaData.getTables(PROJECT_ID, DATASET, null, new String[] {"TABLE"});
    Set<String> tableNames = new HashSet<>();
    while (rsTable.next()) {
      tableNames.add(rsTable.getString("TABLE_NAME"));
    }
    Assertions.assertTrue(tableNames.contains("base_table"));
    Assertions.assertTrue(tableNames.contains("base_table_clone"));
    Assertions.assertEquals(2, tableNames.size());

    // --- Test Case 3: Get "VIEW" type ---
    ResultSet rsView = databaseMetaData.getTables(PROJECT_ID, DATASET, null, new String[] {"VIEW"});
    Assertions.assertTrue(rsView.next());
    Assertions.assertEquals("my_view", rsView.getString("TABLE_NAME"));
    Assertions.assertEquals("VIEW", rsView.getString("TABLE_TYPE"));
    Assertions.assertFalse(rsView.next());

    // --- Test Case 4: Get "EXTERNAL TABLE" type ---
    ResultSet rsExternal =
        databaseMetaData.getTables(PROJECT_ID, DATASET, null, new String[] {"EXTERNAL"});
    Assertions.assertTrue(rsExternal.next());
    Assertions.assertEquals("external_table", rsExternal.getString("TABLE_NAME"));
    Assertions.assertEquals("EXTERNAL", rsExternal.getString("TABLE_TYPE"));
    Assertions.assertFalse(rsExternal.next());

    // --- Test Case 5: Get "MATERIALIZED_VIEW" type ---
    ResultSet rsMaterialized =
        databaseMetaData.getTables(PROJECT_ID, DATASET, null, new String[] {"MATERIALIZED_VIEW"});
    Assertions.assertTrue(rsMaterialized.next());
    Assertions.assertEquals("my_materialized_view", rsMaterialized.getString("TABLE_NAME"));
    Assertions.assertEquals("MATERIALIZED_VIEW", rsMaterialized.getString("TABLE_TYPE"));
    Assertions.assertFalse(rsMaterialized.next());

    // --- Test Case 6: Get "SNAPSHOT" type ---
    ResultSet rsSnapshot =
        databaseMetaData.getTables(PROJECT_ID, DATASET, null, new String[] {"SNAPSHOT"});
    Assertions.assertTrue(rsSnapshot.next());
    Assertions.assertEquals("base_table_snapshot", rsSnapshot.getString("TABLE_NAME"));
    Assertions.assertEquals("SNAPSHOT", rsSnapshot.getString("TABLE_TYPE"));
    Assertions.assertFalse(rsSnapshot.next());

    // --- Test Case 8: Get multiple types ("TABLE" and "VIEW") ---
    ResultSet rsMulti =
        databaseMetaData.getTables(PROJECT_ID, DATASET, null, new String[] {"TABLE", "VIEW"});
    Set<String> multiTableNames = new HashSet<>();
    while (rsMulti.next()) {
      multiTableNames.add(rsMulti.getString("TABLE_NAME"));
    }
    Assertions.assertTrue(multiTableNames.contains("base_table"));
    Assertions.assertTrue(multiTableNames.contains("base_table_clone"));
    Assertions.assertTrue(multiTableNames.contains("my_view"));
    Assertions.assertEquals(3, multiTableNames.size());

    // --- Test Case 9: tableNamePattern  ---
    ResultSet rsNamePattern = databaseMetaData.getTables(PROJECT_ID, DATASET, "base%", null);
    Set<String> baseTableNames = new HashSet<>();
    while (rsNamePattern.next()) {
      baseTableNames.add(rsNamePattern.getString("TABLE_NAME"));
    }
    Assertions.assertTrue(baseTableNames.contains("base_table"));
    Assertions.assertTrue(baseTableNames.contains("base_table_clone"));
    Assertions.assertTrue(baseTableNames.contains("base_table_snapshot"));
    Assertions.assertEquals(3, baseTableNames.size());

    // --- Test Case 10: No matching table ---
    ResultSet rsNoMatch =
        databaseMetaData.getTables(PROJECT_ID, DATASET, "nonexistent_table", null);
    Assertions.assertFalse(rsNoMatch.next());

    // --- Test Case 11: Null type in array ---
    ResultSet rsNullType =
        databaseMetaData.getTables(PROJECT_ID, DATASET, null, new String[] {null, "VIEW"});
    Assertions.assertTrue(rsNullType.next());
    Assertions.assertEquals("VIEW", rsNullType.getString("TABLE_TYPE"));
    Assertions.assertEquals("my_view", rsNullType.getString("TABLE_NAME"));
    Assertions.assertFalse(rsNullType.next());
    connection.close();
  }

  @Test
  public void testDatabaseMetadataGetSchemas() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData databaseMetaData = connection.getMetaData();

    // Test case 1: Get all schemas with catalog and check for the presence of specific schemas
    ResultSet rsAll = databaseMetaData.getSchemas(PROJECT_ID, null);
    Set<String> actualSchemas = new HashSet<>();
    while (rsAll.next()) {
      Assertions.assertEquals(PROJECT_ID, rsAll.getString("TABLE_CATALOG"));
      actualSchemas.add(rsAll.getString("TABLE_SCHEM"));
    }
    Assertions.assertTrue(actualSchemas.contains("JDBC_INTEGRATION_DATASET"));
    Assertions.assertTrue(actualSchemas.contains("JDBC_TABLE_TYPES_TEST"));
    Assertions.assertTrue(actualSchemas.contains("ODBC_TEST_DATASET"));

    // Test case 2: Get schemas with catalog and schemaPattern matching "JDBC_NIGHTLY_IT_DATASET"
    ResultSet rsPattern = databaseMetaData.getSchemas(PROJECT_ID, "JDBC_NIGHTLY_IT_DATASET");
    Set<String> actualSchemasPattern = new HashSet<>();
    while (rsPattern.next()) {
      Assertions.assertEquals(PROJECT_ID, rsPattern.getString("TABLE_CATALOG"));
      actualSchemasPattern.add(rsPattern.getString("TABLE_SCHEM"));
    }
    Assertions.assertTrue(actualSchemasPattern.contains("JDBC_NIGHTLY_IT_DATASET"));
    Assertions.assertEquals(1, actualSchemasPattern.size());

    // Test case 3: Get schemas with catalog and schemaPattern matching "nonexistent"
    ResultSet rsNoMatch = databaseMetaData.getSchemas(PROJECT_ID, "nonexistent");
    Assertions.assertFalse(rsNoMatch.next());

    // Test case 4: Get schemas with non-existent catalog
    rsNoMatch = databaseMetaData.getSchemas("invalid-catalog", null);
    Assertions.assertFalse(rsNoMatch.next());
    connection.close();
  }

  @Test
  public void testDatabaseMetadataGetSchemasNoArgs() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData databaseMetaData = connection.getMetaData();
    String expectedCatalog = connection.getCatalog();
    assertNotNull(expectedCatalog, "Project ID (catalog) from connection should not be null");

    // Test case: Get all schemas (datasets) for the current project
    try (ResultSet rsAll = databaseMetaData.getSchemas()) {
      assertNotNull(rsAll, "ResultSet from getSchemas() should not be null");
      boolean foundTestDataset = false;
      int rowCount = 0;
      while (rsAll.next()) {
        rowCount++;
        Assertions.assertEquals(
            expectedCatalog,
            rsAll.getString("TABLE_CATALOG"),
            "TABLE_CATALOG should match the connection's project ID");
        String schemaName = rsAll.getString("TABLE_SCHEM");
        assertNotNull(schemaName, "TABLE_SCHEM should not be null");
        if (DATASET.equals(schemaName)
            || DATASET2.equals(schemaName)
            || CONSTRAINTS_DATASET.equals(schemaName)
            || "JDBC_TABLE_TYPES_TEST".equals(schemaName)
            || "JDBC_INTEGRATION_DATASET".equals(schemaName)) {
          foundTestDataset = true;
        }
      }
      Assertions.assertTrue(
          foundTestDataset, "At least one of the known test datasets should be found");
      Assertions.assertTrue(rowCount > 0, "Should retrieve at least one schema/dataset");
    }
    connection.close();
  }

  @Test
  public void testDatabaseMetaDataGetFunctions() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData databaseMetaData = connection.getMetaData();
    String testSchema = "JDBC_TABLE_TYPES_TEST";
    String testCatalog = PROJECT_ID;

    Set<String> expectedFunctionNames =
        new HashSet<>(
            Arrays.asList(
                "complex_scalar_sql_udf",
                "persistent_sql_udf_named_params",
                "scalar_js_udf",
                "scalar_sql_udf"));

    // Test 1: Get all functions from a specific schema
    ResultSet rsAll = databaseMetaData.getFunctions(testCatalog, testSchema, null);
    Set<String> foundFunctionNames = new HashSet<>();
    int countAll = 0;
    while (rsAll.next()) {
      countAll++;
      Assertions.assertEquals(testCatalog, rsAll.getString("FUNCTION_CAT"));
      Assertions.assertEquals(testSchema, rsAll.getString("FUNCTION_SCHEM"));
      String funcName = rsAll.getString("FUNCTION_NAME");
      foundFunctionNames.add(funcName);
      assertNull(rsAll.getString("REMARKS"));
      Assertions.assertEquals(
          DatabaseMetaData.functionResultUnknown, rsAll.getShort("FUNCTION_TYPE"));
      Assertions.assertEquals(funcName, rsAll.getString("SPECIFIC_NAME"));
    }
    Assertions.assertEquals(
        expectedFunctionNames.size(),
        countAll,
        "Should find all " + expectedFunctionNames.size() + " functions in " + testSchema);
    Assertions.assertEquals(expectedFunctionNames, foundFunctionNames);
    rsAll.close();

    // Test 2: Get a specific function using functionNamePattern
    String specificFunctionName = "scalar_sql_udf";
    ResultSet rsSpecific =
        databaseMetaData.getFunctions(testCatalog, testSchema, specificFunctionName);
    Assertions.assertTrue(
        rsSpecific.next(), "Should find the specific function " + specificFunctionName);
    Assertions.assertEquals(testCatalog, rsSpecific.getString("FUNCTION_CAT"));
    Assertions.assertEquals(testSchema, rsSpecific.getString("FUNCTION_SCHEM"));
    Assertions.assertEquals(specificFunctionName, rsSpecific.getString("FUNCTION_NAME"));
    assertNull(rsSpecific.getString("REMARKS"));
    Assertions.assertEquals(
        DatabaseMetaData.functionResultUnknown, rsSpecific.getShort("FUNCTION_TYPE"));
    Assertions.assertEquals(specificFunctionName, rsSpecific.getString("SPECIFIC_NAME"));
    Assertions.assertFalse(rsSpecific.next(), "Should only find one row for exact function match");
    rsSpecific.close();

    // Test 3: Get functions using a wildcard functionNamePattern "scalar%"
    // Expected order due to sorting: scalar_js_udf, scalar_sql_udf
    ResultSet rsWildcard = databaseMetaData.getFunctions(testCatalog, testSchema, "scalar%");
    Assertions.assertTrue(rsWildcard.next(), "Should find functions matching 'scalar%'");
    Assertions.assertEquals("scalar_js_udf", rsWildcard.getString("FUNCTION_NAME"));
    Assertions.assertEquals(
        DatabaseMetaData.functionResultUnknown, rsWildcard.getShort("FUNCTION_TYPE"));

    Assertions.assertTrue(rsWildcard.next(), "Should find the second function matching 'scalar%'");
    Assertions.assertEquals("scalar_sql_udf", rsWildcard.getString("FUNCTION_NAME"));
    Assertions.assertEquals(
        DatabaseMetaData.functionResultUnknown, rsWildcard.getShort("FUNCTION_TYPE"));
    Assertions.assertFalse(rsWildcard.next(), "Should be no more functions matching 'scalar%'");
    rsWildcard.close();

    // Test 4: Schema pattern with wildcard
    ResultSet rsSchemaWildcard =
        databaseMetaData.getFunctions(testCatalog, "JDBC_TABLE_TYPES_T%", "complex_scalar_sql_udf");
    Assertions.assertTrue(rsSchemaWildcard.next(), "Should find function with schema wildcard");
    Assertions.assertEquals(testSchema, rsSchemaWildcard.getString("FUNCTION_SCHEM"));
    Assertions.assertEquals("complex_scalar_sql_udf", rsSchemaWildcard.getString("FUNCTION_NAME"));
    Assertions.assertFalse(
        rsSchemaWildcard.next(),
        "Should only find one row for this schema wildcard and specific function");
    rsSchemaWildcard.close();

    // Test 5: Non-existent function
    ResultSet rsNonExistentFunc =
        databaseMetaData.getFunctions(testCatalog, testSchema, "non_existent_function_xyz123");
    Assertions.assertFalse(rsNonExistentFunc.next(), "Should not find a non-existent function");
    rsNonExistentFunc.close();

    // Test 6: Non-existent schema
    ResultSet rsNonExistentSchema =
        databaseMetaData.getFunctions(testCatalog, "NON_EXISTENT_SCHEMA_XYZ123", null);
    Assertions.assertFalse(
        rsNonExistentSchema.next(), "Should not find functions in a non-existent schema");
    rsNonExistentSchema.close();

    // Test 7: Empty schema pattern
    ResultSet rsEmptySchema = databaseMetaData.getFunctions(testCatalog, "", null);
    Assertions.assertFalse(rsEmptySchema.next(), "Empty schema pattern should return no results");
    rsEmptySchema.close();

    // Test 8: Empty function name pattern
    ResultSet rsEmptyFunction = databaseMetaData.getFunctions(testCatalog, testSchema, "");
    Assertions.assertFalse(
        rsEmptyFunction.next(), "Empty function name pattern should return no results");
    rsEmptyFunction.close();

    // Test 9: Null catalog
    ResultSet rsNullCatalog = databaseMetaData.getFunctions(null, testSchema, null);
    Assertions.assertFalse(rsNullCatalog.next(), "Null catalog should return no results");
    rsNullCatalog.close();
    connection.close();
  }

  @Test
  public void testDatabaseMetadataGetFunctionColumns() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData databaseMetaData = connection.getMetaData();
    String testCatalog = PROJECT_ID;
    String testSchema = "JDBC_TABLE_TYPES_TEST";

    // Test Case 1: Specific function 'scalar_sql_udf', specific column 'x'
    String specificFunction1 = "scalar_sql_udf";
    String specificColumn1 = "x";
    ResultSet rs =
        databaseMetaData.getFunctionColumns(
            testCatalog, testSchema, specificFunction1, specificColumn1);

    Assertions.assertTrue(rs.next(), "Should find column 'x' for function 'scalar_sql_udf'");
    Assertions.assertEquals(testCatalog, rs.getString("FUNCTION_CAT"));
    Assertions.assertEquals(testSchema, rs.getString("FUNCTION_SCHEM"));
    Assertions.assertEquals(specificFunction1, rs.getString("FUNCTION_NAME"));
    Assertions.assertEquals(specificColumn1, rs.getString("COLUMN_NAME"));
    Assertions.assertEquals(DatabaseMetaData.functionColumnUnknown, rs.getShort("COLUMN_TYPE"));
    Assertions.assertEquals(Types.BIGINT, rs.getInt("DATA_TYPE"));
    Assertions.assertEquals("BIGINT", rs.getString("TYPE_NAME"));
    Assertions.assertEquals(19, rs.getInt("PRECISION"));
    Assertions.assertEquals(null, rs.getObject("LENGTH"));
    Assertions.assertTrue(rs.wasNull());
    Assertions.assertEquals(0, rs.getShort("SCALE"));
    Assertions.assertEquals(10, rs.getShort("RADIX"));
    Assertions.assertEquals(DatabaseMetaData.functionNullableUnknown, rs.getShort("NULLABLE"));
    assertNull(rs.getString("REMARKS"));
    Assertions.assertEquals(null, rs.getObject("CHAR_OCTET_LENGTH"));
    Assertions.assertTrue(rs.wasNull());
    Assertions.assertEquals(1, rs.getInt("ORDINAL_POSITION"));
    Assertions.assertEquals("", rs.getString("IS_NULLABLE"));
    Assertions.assertEquals(specificFunction1, rs.getString("SPECIFIC_NAME"));
    Assertions.assertFalse(rs.next(), "Should only find one row for exact column match");
    rs.close();

    // Test Case 2: Specific function 'complex_scalar_sql_udf', specific column 'arr'
    String specificFunction2 = "complex_scalar_sql_udf";
    String specificColumn2 = "arr";
    rs =
        databaseMetaData.getFunctionColumns(
            testCatalog, testSchema, specificFunction2, specificColumn2);
    Assertions.assertTrue(
        rs.next(), "Should find column 'arr' for function 'complex_scalar_sql_udf'");
    Assertions.assertEquals(testCatalog, rs.getString("FUNCTION_CAT"));
    Assertions.assertEquals(testSchema, rs.getString("FUNCTION_SCHEM"));
    Assertions.assertEquals(specificFunction2, rs.getString("FUNCTION_NAME"));
    Assertions.assertEquals(specificColumn2, rs.getString("COLUMN_NAME"));
    Assertions.assertEquals(DatabaseMetaData.functionColumnUnknown, rs.getShort("COLUMN_TYPE"));
    Assertions.assertEquals(Types.ARRAY, rs.getInt("DATA_TYPE"));
    Assertions.assertEquals("ARRAY", rs.getString("TYPE_NAME"));
    Assertions.assertEquals(null, rs.getObject("PRECISION"));
    Assertions.assertTrue(rs.wasNull());
    Assertions.assertEquals(null, rs.getObject("LENGTH"));
    Assertions.assertTrue(rs.wasNull());
    Assertions.assertEquals(null, rs.getObject("SCALE"));
    Assertions.assertTrue(rs.wasNull());
    Assertions.assertEquals(null, rs.getObject("RADIX"));
    Assertions.assertTrue(rs.wasNull());
    Assertions.assertEquals(DatabaseMetaData.functionNullableUnknown, rs.getShort("NULLABLE"));
    assertNull(rs.getString("REMARKS"));
    Assertions.assertEquals(null, rs.getObject("CHAR_OCTET_LENGTH"));
    Assertions.assertTrue(rs.wasNull());
    Assertions.assertEquals(1, rs.getInt("ORDINAL_POSITION"));
    Assertions.assertEquals("", rs.getString("IS_NULLABLE"));
    Assertions.assertEquals(specificFunction2, rs.getString("SPECIFIC_NAME"));
    Assertions.assertFalse(rs.next(), "Should only find one row for exact column match");
    rs.close();

    // Test Case 3: All columns for 'persistent_sql_udf_named_params' (sorted by ordinal position)
    String specificFunction3 = "persistent_sql_udf_named_params";
    rs = databaseMetaData.getFunctionColumns(testCatalog, testSchema, specificFunction3, null);
    Assertions.assertTrue(rs.next(), "Should find columns for " + specificFunction3);
    Assertions.assertEquals(specificFunction3, rs.getString("FUNCTION_NAME"));
    Assertions.assertEquals("value1", rs.getString("COLUMN_NAME")); // Ordinal Position 1
    Assertions.assertEquals(DatabaseMetaData.functionColumnUnknown, rs.getShort("COLUMN_TYPE"));
    Assertions.assertEquals(Types.BIGINT, rs.getInt("DATA_TYPE"));
    Assertions.assertEquals("BIGINT", rs.getString("TYPE_NAME"));
    Assertions.assertEquals(1, rs.getInt("ORDINAL_POSITION"));

    Assertions.assertTrue(rs.next(), "Should find second column for " + specificFunction3);
    Assertions.assertEquals(specificFunction3, rs.getString("FUNCTION_NAME"));
    Assertions.assertEquals("value-two", rs.getString("COLUMN_NAME")); // Ordinal Position 2
    Assertions.assertEquals(DatabaseMetaData.functionColumnUnknown, rs.getShort("COLUMN_TYPE"));
    Assertions.assertEquals(Types.NVARCHAR, rs.getInt("DATA_TYPE"));
    Assertions.assertEquals("NVARCHAR", rs.getString("TYPE_NAME"));
    Assertions.assertEquals(2, rs.getInt("ORDINAL_POSITION"));
    Assertions.assertFalse(rs.next(), "Should be no more columns for " + specificFunction3);
    rs.close();

    // Test Case 4: Wildcard for function name "scalar%", specific column name "x"
    rs = databaseMetaData.getFunctionColumns(testCatalog, testSchema, "scalar%", "x");
    Assertions.assertTrue(rs.next(), "Should find column 'x' for functions matching 'scalar%'");
    Assertions.assertEquals("scalar_sql_udf", rs.getString("FUNCTION_NAME"));
    Assertions.assertEquals("x", rs.getString("COLUMN_NAME"));
    Assertions.assertEquals(1, rs.getInt("ORDINAL_POSITION"));
    Assertions.assertFalse(
        rs.next(), "Should be no more columns named 'x' for functions matching 'scalar%'");
    rs.close();

    // Test Case 5: Wildcard for column name "%" for 'scalar_js_udf'
    String specificFunction4 = "scalar_js_udf";
    rs = databaseMetaData.getFunctionColumns(testCatalog, testSchema, specificFunction4, "%");
    Assertions.assertTrue(
        rs.next(), "Should find columns for " + specificFunction4 + " with wildcard");
    Assertions.assertEquals(specificFunction4, rs.getString("FUNCTION_NAME"));
    Assertions.assertEquals("name", rs.getString("COLUMN_NAME")); // Ordinal Position 1
    Assertions.assertEquals(1, rs.getInt("ORDINAL_POSITION"));

    Assertions.assertTrue(
        rs.next(), "Should find second column for " + specificFunction4 + " with wildcard");
    Assertions.assertEquals(specificFunction4, rs.getString("FUNCTION_NAME"));
    Assertions.assertEquals("age", rs.getString("COLUMN_NAME")); // Ordinal Position 2
    Assertions.assertEquals(2, rs.getInt("ORDINAL_POSITION"));
    Assertions.assertFalse(
        rs.next(), "Should be no more columns for " + specificFunction4 + " with wildcard");
    rs.close();

    // Test Case 6: Non-existent function
    rs =
        databaseMetaData.getFunctionColumns(
            testCatalog, testSchema, "non_existent_function_xyz", null);
    Assertions.assertFalse(rs.next(), "Should not find columns for a non-existent function");
    rs.close();
    connection.close();
  }

  @Test
  public void testAdditionalProjectsInMetadata() throws SQLException {
    String additionalProjectsValue = "bigquery-public-data";
    String datasetInAdditionalProject = "baseball";

    String urlWithAdditionalProjects =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId="
            + PROJECT_ID
            + ";OAuthType=3"
            + ";AdditionalProjects="
            + additionalProjectsValue;

    try (Connection conn = DriverManager.getConnection(urlWithAdditionalProjects)) {
      DatabaseMetaData dbMetaData = conn.getMetaData();

      // 1. Test getCatalogs()
      Set<String> foundCatalogs = new HashSet<>();
      try (ResultSet catalogsRs = dbMetaData.getCatalogs()) {
        while (catalogsRs.next()) {
          foundCatalogs.add(catalogsRs.getString("TABLE_CAT"));
        }
      }
      Assertions.assertTrue(
          foundCatalogs.contains(PROJECT_ID),
          "getCatalogs() should contain the primary project ID");
      Assertions.assertTrue(
          foundCatalogs.contains(additionalProjectsValue),
          "getCatalogs() should contain the additional project ID");

      // 2. Test getSchemas()
      Set<String> catalogsForSchemasFromAll = new HashSet<>();
      boolean foundAdditionalDataset = false;
      try (ResultSet schemasRs = dbMetaData.getSchemas()) {
        while (schemasRs.next()) {
          String schemaName = schemasRs.getString("TABLE_SCHEM");
          String catalogName = schemasRs.getString("TABLE_CATALOG");
          catalogsForSchemasFromAll.add(catalogName);
          if (additionalProjectsValue.equals(catalogName)
              && datasetInAdditionalProject.equals(schemaName)) {
            foundAdditionalDataset = true;
          }
        }
      }
      Assertions.assertTrue(
          catalogsForSchemasFromAll.contains(PROJECT_ID),
          "getSchemas() should list datasets from the primary project");
      Assertions.assertTrue(
          catalogsForSchemasFromAll.contains(additionalProjectsValue),
          "getSchemas() should list datasets from the additional project");
      Assertions.assertTrue(
          foundAdditionalDataset,
          "Known dataset from additional project not found in getSchemas()");

    } catch (SQLException e) {
      System.err.println("SQL Error during AdditionalProjects test: " + e.getMessage());
      throw e;
    }
  }

  @Test
  public void testFilterTablesOnDefaultDataset_getTables() throws SQLException {

    String defaultDatasetValue = CONSTRAINTS_DATASET;
    String table1InDefaultDataset = CONSTRAINTS_TABLE_NAME;
    String table2InDefaultDataset = CONSTRAINTS_TABLE_NAME2;

    String specificDatasetValue = "JDBC_TABLE_TYPES_TEST";
    String table1InSpecificDataset = "base_table";
    String table2InSpecificDataset = "external_table";

    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId="
            + PROJECT_ID
            + ";OAuthType=3"
            + ";DefaultDataset="
            + defaultDatasetValue
            + ";FilterTablesOnDefaultDataset=1";
    try (Connection conn = DriverManager.getConnection(connectionUrl)) {
      DatabaseMetaData dbMetaData = conn.getMetaData();

      // Case 1: Catalog and schemaPattern are null/wildcard, should use DefaultDataset
      try (ResultSet rs = dbMetaData.getTables(null, null, null, null)) {
        Set<String> tableNames = new HashSet<>();
        while (rs.next()) {
          Assertions.assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          Assertions.assertEquals(defaultDatasetValue, rs.getString("TABLE_SCHEM"));
          tableNames.add(rs.getString("TABLE_NAME"));
        }
        Assertions.assertTrue(tableNames.contains(table1InDefaultDataset));
        Assertions.assertTrue(tableNames.contains(table2InDefaultDataset));
      }

      // Case 2: Explicit schemaPattern overrides DefaultDataset
      try (ResultSet rs = dbMetaData.getTables(null, specificDatasetValue, null, null)) {
        Set<String> tableNames = new HashSet<>();
        while (rs.next()) {
          Assertions.assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          Assertions.assertEquals(specificDatasetValue, rs.getString("TABLE_SCHEM"));
          tableNames.add(rs.getString("TABLE_NAME"));
        }
        Assertions.assertTrue(tableNames.contains(table1InSpecificDataset));
        Assertions.assertTrue(tableNames.contains(table2InSpecificDataset));
      }

      // Case 3: Explicit catalog, schemaPattern is null/wildcard, should use DefaultDataset within
      // that catalog
      try (ResultSet rs = dbMetaData.getTables(PROJECT_ID, null, null, null)) {
        Set<String> tableNames = new HashSet<>();
        while (rs.next()) {
          Assertions.assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          Assertions.assertEquals(defaultDatasetValue, rs.getString("TABLE_SCHEM"));
          tableNames.add(rs.getString("TABLE_NAME"));
        }
        Assertions.assertTrue(tableNames.contains(table1InDefaultDataset));
        Assertions.assertTrue(tableNames.contains(table2InDefaultDataset));
      }

      // Case 4: Explicit catalog and schemaPattern override DefaultDataset
      try (ResultSet rs = dbMetaData.getTables(PROJECT_ID, specificDatasetValue, null, null)) {
        Set<String> tableNames = new HashSet<>();
        while (rs.next()) {
          Assertions.assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          Assertions.assertEquals(specificDatasetValue, rs.getString("TABLE_SCHEM"));
          tableNames.add(rs.getString("TABLE_NAME"));
        }
        Assertions.assertTrue(tableNames.contains(table1InSpecificDataset));
        Assertions.assertTrue(tableNames.contains(table2InSpecificDataset));
      }
    }
  }

  @Test
  public void testFilterTablesOnDefaultDataset_getColumns() throws SQLException {
    String defaultDatasetValue = CONSTRAINTS_DATASET;
    String tableInDefaultDataset = CONSTRAINTS_TABLE_NAME;
    String[] columnsInDefaultTable = {"id", "name", "second_name", "address"};

    String specificDatasetValue = "JDBC_TABLE_TYPES_TEST";
    String tableInSpecificDataset = "base_table";
    String[] columnsInSpecificTable = {"id", "name", "created_at"};

    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId="
            + PROJECT_ID
            + ";OAuthType=3"
            + ";DefaultDataset="
            + defaultDatasetValue
            + ";FilterTablesOnDefaultDataset=1";

    try (Connection conn = DriverManager.getConnection(connectionUrl)) {
      DatabaseMetaData dbMetaData = conn.getMetaData();

      // Case 1: Catalog and schemaPattern are null/wildcard, should use DefaultDataset
      try (ResultSet rs = dbMetaData.getColumns(null, null, tableInDefaultDataset, null)) {
        Set<String> columnNames = new HashSet<>();
        while (rs.next()) {
          Assertions.assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          Assertions.assertEquals(defaultDatasetValue, rs.getString("TABLE_SCHEM"));
          Assertions.assertEquals(tableInDefaultDataset, rs.getString("TABLE_NAME"));
          columnNames.add(rs.getString("COLUMN_NAME"));
        }
        for (String expectedCol : columnsInDefaultTable) {
          Assertions.assertTrue(columnNames.contains(expectedCol));
        }
        Assertions.assertEquals(columnsInDefaultTable.length, columnNames.size());
      }

      // Case 2: Explicit schemaPattern overrides DefaultDataset
      try (ResultSet rs =
          dbMetaData.getColumns(null, specificDatasetValue, tableInSpecificDataset, null)) {
        Set<String> columnNames = new HashSet<>();
        while (rs.next()) {
          Assertions.assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          Assertions.assertEquals(specificDatasetValue, rs.getString("TABLE_SCHEM"));
          Assertions.assertEquals(tableInSpecificDataset, rs.getString("TABLE_NAME"));
          columnNames.add(rs.getString("COLUMN_NAME"));
        }
        for (String expectedCol : columnsInSpecificTable) {
          Assertions.assertTrue(columnNames.contains(expectedCol));
        }
        Assertions.assertEquals(columnsInSpecificTable.length, columnNames.size());
      }

      // Case 3: Explicit catalog, schemaPattern is null/wildcard, should use DefaultDataset within
      // that catalog
      try (ResultSet rs = dbMetaData.getColumns(PROJECT_ID, null, tableInDefaultDataset, null)) {
        Set<String> columnNames = new HashSet<>();
        while (rs.next()) {
          Assertions.assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          Assertions.assertEquals(defaultDatasetValue, rs.getString("TABLE_SCHEM"));
          Assertions.assertEquals(tableInDefaultDataset, rs.getString("TABLE_NAME"));
          columnNames.add(rs.getString("COLUMN_NAME"));
        }
        for (String expectedCol : columnsInDefaultTable) {
          Assertions.assertTrue(columnNames.contains(expectedCol));
        }
        Assertions.assertEquals(columnsInDefaultTable.length, columnNames.size());
      }

      // Case 4: Explicit catalog and schemaPattern override DefaultDataset
      try (ResultSet rs =
          dbMetaData.getColumns(PROJECT_ID, specificDatasetValue, tableInSpecificDataset, null)) {
        Set<String> columnNames = new HashSet<>();
        while (rs.next()) {
          Assertions.assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          Assertions.assertEquals(specificDatasetValue, rs.getString("TABLE_SCHEM"));
          Assertions.assertEquals(tableInSpecificDataset, rs.getString("TABLE_NAME"));
          columnNames.add(rs.getString("COLUMN_NAME"));
        }
        for (String expectedCol : columnsInSpecificTable) {
          Assertions.assertTrue(columnNames.contains(expectedCol));
        }
        Assertions.assertEquals(columnsInSpecificTable.length, columnNames.size());
      }
    }
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
    ResultSet resultSet = metaData.getPrimaryKeys(ITBase.DEFAULT_CATALOG, dataset, jdbctesttable);
    assertFalse(resultSet.next());
    connection.createStatement().execute("drop table if exists " + dataset + "." + jdbctesttable);
  }

  protected void verifyTestProcedure(DatabaseMetaData metaData, String expectedProcedure)
      throws SQLException {
    assertEquals(expectedProcedure, metaData.getProcedureTerm());
    assertTrue(metaData.supportsStoredProcedures());
    ResultSet resultSet;
    resultSet = metaData.getProcedureColumns("%", "%", "%", "%");
    assertEquals(0, resultSetRowCount(resultSet));
    resultSet = metaData.getProcedures("%", "%", "%");
    assertEquals(0, resultSetRowCount(resultSet));
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
            ITBase.DEFAULT_CATALOG, dataset, jdbctesttable));
    statement.execute(
        String.format(
            "create or replace view  `%s.%s.%s` " + " as select 1 as VIEWCOLUMN;",
            ITBase.DEFAULT_CATALOG, dataset, jdbctestview));

    ResultSet resultSet;

    // Pattern match for table
    resultSet = metaData.getTables(ITBase.DEFAULT_CATALOG, dataset, "%", new String[] {"TABLE"});
    // verifyResultSetMetaDataColumns(resultSet, DBMetadataResultSetMetadata.GET_TABLES);
    Set<String> tables = new HashSet<>();
    while (resultSet.next()) {
      tables.add(resultSet.getString(3));
    }
    assertTrue(tables.contains("JDBCTESTTABLE"));

    // exact match for tablename
    resultSet =
        metaData.getTables(ITBase.DEFAULT_CATALOG, dataset, jdbctesttable, new String[] {"TABLE"});
    tables = new HashSet<>();
    while (resultSet.next()) {
      tables.add(resultSet.getString(3));
    }
    assertEquals(jdbctesttable, tables.iterator().next());

    // Pattern match for view
    resultSet = metaData.getTables(ITBase.DEFAULT_CATALOG, dataset, "%", new String[] {"VIEW"});
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
            ITBase.DEFAULT_CATALOG, dataset, jdbctesttable));

    ResultSet resultSet =
        metaData.getTablePrivileges(ITBase.DEFAULT_CATALOG, dataset, jdbctesttable);
    int cols = resultSet.getMetaData().getColumnCount();
    assertTrue(cols > 0);
    int count = 0;
    while (resultSet.next()) {
      for (int i = 1; i <= cols; i++) {
        Assert.assertNotNull(resultSet.getMetaData().getColumnName(i));
        Assert.assertNotNull(resultSet.getString(i));
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
        metaData.getColumnPrivileges(ITBase.DEFAULT_CATALOG, dataset, jdbctesttable, "%");
    int cols = resultSet.getMetaData().getColumnCount();
    assertTrue(cols > 0);
    int count = 0;
    while (resultSet.next()) {
      for (int i = 1; i <= cols; i++) {
        Assert.assertNotNull(resultSet.getMetaData().getColumnName(i));
        Assert.assertNotNull(resultSet.getString(i));
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

    ResultSet resultSet = metaData.getImportedKeys(ITBase.DEFAULT_CATALOG, dataset, jdbctesttable);
    int cols = resultSet.getMetaData().getColumnCount();
    assertTrue(cols > 0);
    int count = 0;
    while (resultSet.next()) {
      for (int i = 1; i <= cols; i++) {
        Assert.assertNotNull(resultSet.getMetaData().getColumnName(i));
        Assert.assertNotNull(resultSet.getString(i));
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
            ITBase.DEFAULT_CATALOG, dataset, jdbctesttable));
    ResultSet resultSet =
        metaData.getColumns(ITBase.DEFAULT_CATALOG, dataset, jdbctesttable, "%COLUMN");
    int cols = resultSet.getMetaData().getColumnCount();
    assertTrue(cols > 0);
    // Resultset is not empty
    int count = 0;
    while (resultSet.next()) {
      for (int i = 1; i <= cols; i++) {
        Assert.assertNotNull(resultSet.getMetaData().getColumnName(i));
      }
      ++count;
    }
    resultSet.close();
    assertTrue(count > 0);
    connection.createStatement().execute("drop table if exists " + dataset + "." + jdbctesttable);
  }
}
