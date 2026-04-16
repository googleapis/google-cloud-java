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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.ServiceOptions;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITConnectionTest {

  private static final String DATASET = "JDBC_CONNECTION_TEST_DATASET";
  private static final String DEFAULT_CATALOG = ServiceOptions.getDefaultProjectId();
  static Random random = new Random();
  static int randomNumber = random.nextInt(999);
  private static final String TABLE_NAME = "JDBC_CONNECTION_TEST_TABLE" + randomNumber;

  private static String connectionUrl =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=%s;OAuthType=3;Timeout=3600;";

  @BeforeClass
  public static void beforeClass() throws InterruptedException {

    ITBase.setUpDataset(DATASET);
    ITBase.setUpTable(DATASET, TABLE_NAME);
    ITBase.setUpProcedure(DATASET, TABLE_NAME);
  }

  @AfterClass
  public static void afterClass() throws InterruptedException {
    ITBase.cleanUp(DATASET);
  }

  @Test
  public void testGetMetaData() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    assertFalse(connection.isClosed());
    DatabaseMetaData metaData = connection.getMetaData();
    assertNotNull(metaData);
    assertEquals("Google BigQuery", metaData.getDatabaseProductName());
    assertEquals(4, metaData.getJDBCMajorVersion());
    assertEquals(2, metaData.getJDBCMinorVersion());
    assertEquals("Google BigQuery", metaData.getDatabaseProductName());
    assertEquals("SimbaJDBCDriverforGoogleBigQuery", metaData.getDriverName());
  }

  @Test
  public void testCreateStatement() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    assertFalse(connection.isClosed());
    Statement statement = connection.createStatement();
    assertNotNull(statement);
    statement.close();
    connection.close();
  }

  @Test
  public void testPrepareStatement1() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    PreparedStatement preparedStatement = connection.prepareStatement("SELECT 1");
    assertNotNull(preparedStatement);
    preparedStatement.execute();
    preparedStatement.close();
    connection.close();
  }

  @Test
  public void testPrepareStatement2() throws SQLException {

    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    PreparedStatement preparedStatement =
        connection.prepareStatement("SELECT 1", Statement.NO_GENERATED_KEYS);
    assertNotNull(preparedStatement);
    preparedStatement.execute();
    preparedStatement.close();
    connection.close();
  }

  @Test
  public void testPrepareStatement3() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> connection.prepareStatement("SELECT 1", new int[] {1, 2, 3}));
  }

  @Test
  public void testPrepareStatement4() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    PreparedStatement preparedStatement =
        connection.prepareStatement(
            "SELECT 1", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    assertNotNull(preparedStatement);
    preparedStatement.execute();
    preparedStatement.close();
    connection.close();
  }

  @Test
  public void testPrepareStatement5() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () ->
            connection.prepareStatement(
                "SELECT 1",
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT));
  }

  @Test
  public void testPrepareStatement6() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> connection.prepareStatement("SELECT 1", new String[] {"a", "b"}));
  }

  @Test
  public void testPrepareCall1() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    try {
      CallableStatement callableStatement =
          connection.prepareCall(
              String.format("call `%s.%s`.create_customer()", DEFAULT_CATALOG, DATASET));

      assertNotNull(callableStatement);
      callableStatement.execute();
      callableStatement.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testPrepareCall2() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    try {

      CallableStatement callableStatement1 =
          connection.prepareCall(
              String.format("call `%s.%s`.create_customer()", DEFAULT_CATALOG, DATASET),
              ResultSet.TYPE_FORWARD_ONLY,
              ResultSet.CONCUR_READ_ONLY);
      assertNotNull(callableStatement1);
      callableStatement1.execute();
      assertNull(callableStatement1.getResultSet());
      callableStatement1.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testPrepareCall3() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () ->
            connection.prepareCall(
                String.format("call %s.%s.create_customer()", DEFAULT_CATALOG, DATASET),
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT));
  }

  @Test
  public void testSetAutoCommit() throws SQLException {
    Properties properties = new Properties();
    properties.setProperty("EnableSession", "1");

    Connection connection1 = DriverManager.getConnection(ITBase.connectionUrl, properties);
    connection1.setAutoCommit(false);
    assertFalse(connection1.getAutoCommit());
    connection1.setAutoCommit(true);
    assertTrue(connection1.getAutoCommit());
    connection1.close();
  }

  @Test
  public void testCommitAndRollback() throws SQLException {

    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement statement = connection.createStatement();
    Properties properties = new Properties();
    properties.setProperty("EnableSession", "1");

    Connection connection1 = DriverManager.getConnection(ITBase.connectionUrl, properties);
    connection1.setAutoCommit(false);
    Statement statement1 = connection1.createStatement();
    statement.execute(
        String.format(
            "CREATE TABLE IF NOT EXISTS %s.%s.autocommit_test_table (id INT)",
            DEFAULT_CATALOG, DATASET));
    connection1.commit();

    statement1.executeUpdate(
        String.format(
            "INSERT INTO %s.%s.autocommit_test_table (id) VALUES (1)", DEFAULT_CATALOG, DATASET));
    connection1.rollback();

    ResultSet resultSet =
        statement1.executeQuery(
            String.format(
                "SELECT COUNT(*) FROM %s.%s.autocommit_test_table", DEFAULT_CATALOG, DATASET));
    resultSet.next();
    assertEquals(0, resultSet.getInt(1)); // Table should be empty due to rollback

    connection1.setAutoCommit(true);
    statement1.executeUpdate(
        String.format(
            "DROP TABLE IF EXISTS %s.%s.autocommit_test_table", DEFAULT_CATALOG, DATASET));
    statement1.close();
    connection1.close();
    statement.close();
    connection.close();
  }

  @Test
  public void testSetCatalog() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    try {
      String catalog = connection.getCatalog();
      if (catalog != null) {
        connection.setCatalog(catalog);
        assertEquals(catalog, connection.getCatalog());
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testSetSchema() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    try {
      String schema = connection.getSchema();
      if (schema != null) {
        connection.setSchema(schema);
        assertEquals(schema, connection.getSchema());
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testSetClientInfo() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    DatabaseMetaData databaseMetaData = connection.getMetaData();
    ResultSet resultSet = databaseMetaData.getClientInfoProperties();
    while (resultSet.next()) {
      assertNotNull(resultSet.getString("NAME"));
      assertNull(resultSet.getString("DEFAULT_VALUE"));
    }
    connection.setClientInfo("APPLICATIONNAME", "MyTestApp");
    assertEquals("MyTestApp", connection.getClientInfo("APPLICATIONNAME"));
    connection.setClientInfo("CLIENTUSER", "test");
    assertEquals("test", connection.getClientInfo("CLIENTUSER"));

    // Test setClientInfo with Properties
    Properties properties = new Properties();
    properties.setProperty("CLIENTHOSTNAME", "testHost");
    connection.setClientInfo(properties);
    assertEquals("testHost", connection.getClientInfo("CLIENTHOSTNAME"));
    connection.setClientInfo("CLIENTHOSTNAME", "testHost23");
    assertEquals("testHost23", connection.getClientInfo("CLIENTHOSTNAME"));
    connection.close();
  }

  @Test
  public void testSetNetworkTimeout() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> connection.setNetworkTimeout(null, 1000)); // 1 second timeout
  }

  @Test
  public void testCreateClob() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    assertThrows(SQLFeatureNotSupportedException.class, () -> connection.createClob());
  }

  @Test
  public void testCreateBlob() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    assertThrows(SQLFeatureNotSupportedException.class, () -> connection.createBlob());
  }

  @Test
  public void testCreateNClob() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    assertThrows(SQLFeatureNotSupportedException.class, () -> connection.createNClob());
  }

  @Test
  public void testCreateSQLXML() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    assertThrows(SQLFeatureNotSupportedException.class, () -> connection.createSQLXML());
  }

  @Test
  public void testCreateArray() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    try {
      Array array = connection.createArrayOf("INTEGER", new Object[] {1, 2, 3});
      assertNotNull(array);

      array.free(); // Remember to free resources
    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }

  @Test
  public void testCreateStruct() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> connection.createStruct("ADDRESS", new Object[] {"123 Main St", "Anytown"}));
  }

  @Test
  public void testNativeSQL() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    String sql = "SELECT 1";
    String nativeSql = connection.nativeSQL(sql);
    assertEquals(sql, nativeSql);
    assertNotNull(nativeSql);
    connection.close();
  }

  @Test
  public void testSetSavepoint() throws SQLException {
    Properties properties = new Properties();
    properties.setProperty("EnableSession", "1");

    Connection connection1 = DriverManager.getConnection(ITBase.connectionUrl, properties);
    connection1.setAutoCommit(false);
    Statement statement = connection1.createStatement();
    statement.execute("SELECT 1; SELECT 2; SELECT 3;");
    assertThrows(SQLFeatureNotSupportedException.class, () -> connection1.setSavepoint());
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> connection1.setSavepoint("mySavepoint"));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> connection1.releaseSavepoint(connection1.setSavepoint()));
    connection1.setAutoCommit(true);
    connection1.close();
  }

  // TODO:rewrite test
  @Test
  public void testAbort() throws SQLException, InterruptedException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    // This test is tricky to automate fully, as it involves asynchronous behavior
    // We'll just test that we can call it without throwing an exception immediately

    // Create an ExecutorService to simulate asynchronous operation
    java.util.concurrent.ExecutorService executor =
        java.util.concurrent.Executors.newSingleThreadExecutor();
    executor.submit(
        () -> {
          try {
            // This will likely throw an exception as the connection is already open
            // But we mainly want to test that calling abort doesn't cause a direct error
            assertFalse(connection.isClosed());
            assertTrue(connection.isClosed());
            System.out.println(connection.isClosed());
            connection.abort(java.util.concurrent.Executors.newSingleThreadExecutor());
            System.out.println(connection.isClosed());
            assertTrue(connection.isClosed());
          } catch (SQLException e) {
            e.printStackTrace();
            // It's expected that calling abort might cause an exception
            // depending on the state of the connection and driver.
            System.out.println("Abort test threw an exception, which is expected in some cases.");
          }
        });

    // Give the thread a short time to execute
    Thread.sleep(100);

    // Shutdown the executor
    executor.shutdown();
    executor.awaitTermination(100, java.util.concurrent.TimeUnit.MILLISECONDS);
    connection.close();
  }

  @Test
  public void testIsWrapperFor() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    assertTrue(connection.isWrapperFor(Connection.class));
    connection.close();
  }

  @Test
  public void testIsValid() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    assertTrue(connection.isValid(0)); // 0 seconds timeout
    connection.close();
  }
}
