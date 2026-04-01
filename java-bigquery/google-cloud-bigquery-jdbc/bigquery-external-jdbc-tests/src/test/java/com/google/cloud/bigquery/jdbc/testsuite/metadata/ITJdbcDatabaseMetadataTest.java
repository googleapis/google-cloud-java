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

package com.google.cloud.bigquery.jdbc.testsuite.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.cloud.bigquery.jdbc.testsuite.BaseDatabaseMetadata;
import com.google.cloud.bigquery.jdbc.testsuite.JdbcConnectionHelper;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITJdbcDatabaseMetadataTest extends BaseDatabaseMetadata {

  private static final Pattern VERSION_PATTERN =
      Pattern.compile("^(\\d+)\\.(\\d+)(?:\\.\\d+)+\\s*.*");
  private static final String DEFAULT_CATALOG = ServiceOptions.getDefaultProjectId();
  private static final String DATASET = "EXT_JDBC_DBMETADATA_TEST_DATASET";
  static Random random = new Random();
  static int randomNumber = random.nextInt(999);
  private static final String TABLE_NAME = "EXT_JDBC_DBMETADATA_TEST_TABLE" + randomNumber;
  private static String connectionUrl =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=%s;OAuthType=3;Timeout=3600;";
  private static BigQuery bigQuery;

  @BeforeClass
  public static void beforeClass() throws InterruptedException {
    // Set up Dataset
    JdbcConnectionHelper.setUpDataset(DATASET);
    JdbcConnectionHelper.setUpTable(DATASET, TABLE_NAME);
  }

  @AfterClass
  public static void afterClass() throws InterruptedException {
    JdbcConnectionHelper.cleanUp(DATASET);
  }

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
}
