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

package com.google.cloud.bigquery.jdbc.testsuite.statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.bigquery.jdbc.testsuite.JdbcConnectionHelper;
import com.google.cloud.ServiceOptions;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.Random;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ITBigQueryJDBCTest {

  static final String DEFAULT_CATALOG = ServiceOptions.getDefaultProjectId();
  private static String connectionUrl =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=%s;OAuthType=3;Timeout=3600;";
  private static String noReadAPIConnectionUrl =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=%s;OAuthType=3;Timeout=3600;"
          + "EnableHighThroughputAPI=0;HighThroughputActivationRatio=30;HighThroughputMinTableSize=200000000;";
  static final String session_enabled_connection_uri =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
          + DEFAULT_CATALOG
          + ";OAUTHTYPE=3;EnableSession=1";
  private static final String BASE_QUERY =
      "SELECT * FROM bigquery-public-data.new_york_taxi_trips.tlc_yellow_trips_2017 order by"
          + " trip_distance asc LIMIT %s";
  private static final String CONSTRAINTS_DATASET = "JDBC_CONSTRAINTS_TEST_DATASET";
  private static final String CONSTRAINTS_TABLE_NAME = "JDBC_CONSTRAINTS_TEST_TABLE";
  private static final String CONSTRAINTS_TABLE_NAME2 = "JDBC_CONSTRAINTS_TEST_TABLE2";
  private static final String CONSTRAINTS_TABLE_NAME3 = "JDBC_CONSTRAINTS_TEST_TABLE3";
  private static final String DATASET = "JDBC_BIGQUERY_TEST_DATASET";
  static Random random = new Random();
  static int randomNumber = random.nextInt(999);
  private static final String TABLE_NAME = "EXT_JDBC_BIGQUERY_TEST_TABLE" + randomNumber;

  @BeforeClass
  public static void beforeClass() throws InterruptedException {
    JdbcConnectionHelper.setUpDataset(DATASET);
    JdbcConnectionHelper.setUpTable(DATASET, TABLE_NAME);
    JdbcConnectionHelper.setUpProcedure(DATASET, TABLE_NAME);
  }

  @AfterClass
  public static void afterClass() throws InterruptedException {
    JdbcConnectionHelper.cleanUp(DATASET);
  }

  @Test
  public void testValidApplicationDefaultCredentialsAuthentication() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;ProjectId="
            + DEFAULT_CATALOG
            + ";";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    connection.close();
  }

  @Test
  public void testFastQueryPathSmall() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection.createStatement();
    String query =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT"
            + " 850";
    ResultSet jsonResultSet = bigQueryStatement.executeQuery(query);
    assertEquals(850, resultSetRowCount(jsonResultSet));
    connection.close();
  }

  @Test
  public void testFastQueryPathEmpty() throws SQLException {
    String query =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT"
            + " 0";
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection.createStatement();
    ResultSet jsonResultSet = bigQueryStatement.executeQuery(query);
    assertEquals(0, resultSetRowCount(jsonResultSet));
    connection.close();
  }

  @Test
  public void testStatelessQueryPathSmall() throws SQLException {
    Properties jobCreationMode = new Properties();
    jobCreationMode.setProperty("JobCreationMode", "2");
    Connection connectionUseStateless =
        DriverManager.getConnection(JdbcConnectionHelper.connectionUrl, jobCreationMode);

    Statement statement = connectionUseStateless.createStatement();

    String query =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT"
            + " 850";
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertEquals(850, resultSetRowCount(jsonResultSet));

    String queryEmpty =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT"
            + " 0";
    ResultSet jsonResultSetEmpty = statement.executeQuery(queryEmpty);
    assertEquals(0, resultSetRowCount(jsonResultSetEmpty));
    connectionUseStateless.close();
  }

  @Test
  public void testFastQueryPathMedium() throws SQLException {
    String query =
        "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 9000";
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection.createStatement();
    ResultSet jsonResultSet = bigQueryStatement.executeQuery(query);
    assertEquals(9000, resultSetRowCount(jsonResultSet));
    connection.close();
  }

  @Test
  public void testFastQueryPathLarge() throws SQLException {
    String query =
        "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 18000";
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection.createStatement();
    ResultSet jsonResultSet = bigQueryStatement.executeQuery(query);
    assertEquals(18000, resultSetRowCount(jsonResultSet));
    connection.close();
  }

  @Test
  // reads using ReadAPI and makes sure that they are in order, which implies threads worked
  // correctly
  public void testIterateOrderArrowMultiThread() throws SQLException {
    int expectedCnt = 200000;
    String longQuery = String.format(BASE_QUERY, expectedCnt);
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection.createStatement();
    ResultSet rs = bigQueryStatement.executeQuery(longQuery);
    int cnt = 0;
    double oldTriDis = 0.0d;
    while (rs.next()) {
      double tripDis = rs.getDouble("trip_distance");
      ++cnt;
      assertTrue(oldTriDis <= tripDis);
      oldTriDis = tripDis;
    }
    assertEquals(expectedCnt, cnt); // all the records were retrieved
    connection.close();
  }

  @Test
  public void testReadAPIPathLarge() throws SQLException {
    Properties withReadApi = new Properties();
    withReadApi.setProperty("EnableHighThroughputAPI", "1");
    withReadApi.setProperty("HighThroughputActivationRatio", "2");
    withReadApi.setProperty("HighThroughputMinTableSize", "1000");
    withReadApi.setProperty("MaxResults", "300");

    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG), withReadApi);
    Statement statement = connection.createStatement();
    int expectedCnt = 5000;
    String longQuery = String.format(BASE_QUERY, expectedCnt);
    ResultSet arrowResultSet = statement.executeQuery(longQuery);
    assertEquals(expectedCnt, resultSetRowCount(arrowResultSet));
    arrowResultSet.close();
    connection.close();
  }

  @Test
  public void testReadAPIPathLargeWithThresholdParameters() throws SQLException {
    String connectionUri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + DEFAULT_CATALOG
            + ";OAUTHTYPE=3;MaxResults=300;HighThroughputActivationRatio=2;"
            + "HighThroughputMinTableSize=100;EnableHighThroughputAPI=1";
    Connection connection = DriverManager.getConnection(connectionUri);
    Statement statement = connection.createStatement();
    int expectedCnt = 1000;
    String longQuery = String.format(BASE_QUERY, expectedCnt);
    ResultSet arrowResultSet = statement.executeQuery(longQuery);
    assertEquals(expectedCnt, resultSetRowCount(arrowResultSet));
    arrowResultSet.close();
    connection.close();
  }

  @Test
  public void testReadAPIPathLargeWithThresholdNotMet() throws SQLException {
    String connectionUri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + DEFAULT_CATALOG
            + ";OAUTHTYPE=3;HighThroughputActivationRatio=4;"
            + "HighThroughputMinTableSize=100;EnableHighThroughputAPI=1";
    Connection connection = DriverManager.getConnection(connectionUri);
    Statement statement = connection.createStatement();
    int expectedCnt = 5000;
    String longQuery = String.format(BASE_QUERY, expectedCnt);
    ResultSet arrowResultSet = statement.executeQuery(longQuery);
    assertEquals(expectedCnt, resultSetRowCount(arrowResultSet));
    arrowResultSet.close();
    connection.close();
  }

  @Test
  public void testSmallSelectAndVerifyResults() throws SQLException {
    String query =
        "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` WHERE"
            + " repository_name LIKE 'X%' LIMIT 10";

    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection.createStatement();
    ResultSet resultSet = bigQueryStatement.executeQuery(query);
    int rowCount = 0;
    while (resultSet.next()) {
      assertTrue(resultSet.getString(1).startsWith("X"));
      rowCount++;
    }
    assertEquals(10, rowCount);
    connection.close();
  }

  @Test
  public void testInvalidQuery() throws SQLException {
    String query = "SELECT *";
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection.createStatement();

    try {
      bigQueryStatement.executeQuery(query);
      Assert.fail();
    } catch (Exception e) {
      assertTrue(e.getMessage().contains("SELECT * must have a FROM clause"));
    }
    connection.close();
  }

  @Test
  public void testLocation() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + DEFAULT_CATALOG
            + ";OAUTHTYPE=3;LOCATION=EU";

    Connection connection = DriverManager.getConnection(connection_uri, new Properties());
    assertTrue(connection.isValid(1));

    Statement statement = connection.createStatement();

    // Query a dataset in the EU
    String query =
        "SELECT name FROM `bigquery-public-data.covid19_italy_eu.data_by_province` LIMIT 100";
    ResultSet resultSet = statement.executeQuery(query);
    assertEquals(100, resultSetRowCount(resultSet));

    String connection_uri_null_location =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + DEFAULT_CATALOG
            + ";OAUTHTYPE=3";

    Connection connection2 =
        DriverManager.getConnection(connection_uri_null_location, new Properties());
    assertNotNull(connection2);
    assertTrue(connection2.isValid(1));
    connection.close();

    connection2.close();
  }

  @Test
  public void testIncorrectLocation() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + DEFAULT_CATALOG
            + ";OAUTHTYPE=3;LOCATION=europe-west3";

    Connection connection = DriverManager.getConnection(connection_uri, new Properties());
    assertTrue(connection.isValid(1));

    // Query a dataset in the US
    Statement statement = connection.createStatement();
    String query = "SELECT * FROM `bigquery-public-data.samples.github_timeline` LIMIT 180";
    Exception ex = assertThrows(Exception.class, () -> statement.executeQuery(query));
    assertNotNull(ex);
    assertTrue(ex.getMessage().contains("Access Denied"));
    connection.close();
  }

  @Test
  public void testRollbackOnConnectionClosed() throws SQLException {
    String TRANSACTION_TABLE = "EXT_JDBC_TRANSACTION_TABLE1" + random.nextInt(99);
    String createTransactionTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, TRANSACTION_TABLE);
    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (id, name, age) VALUES (15, 'Farhan', %s);",
            DATASET, TRANSACTION_TABLE, randomNumber);
    String updateQuery =
        String.format(
            "UPDATE %s.%s SET age = 12 WHERE age = %s;", DATASET, TRANSACTION_TABLE, randomNumber);
    String selectQuery =
        String.format("SELECT id, name, age FROM %s.%s WHERE id = 12;", DATASET, TRANSACTION_TABLE);

    Connection connection1 =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection1.createStatement();
    bigQueryStatement.execute(createTransactionTable);
    Connection connection = DriverManager.getConnection(session_enabled_connection_uri);
    connection.setAutoCommit(false);
    Statement statement = connection.createStatement();

    boolean status = statement.execute(insertQuery);
    assertFalse(status);
    int rows = statement.executeUpdate(updateQuery);
    assertEquals(1, rows);
    status = statement.execute(selectQuery);
    assertTrue(status);
    connection.close();

    // Separate query to check if transaction rollback worked
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertFalse(resultSet.next());

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TRANSACTION_TABLE));
    connection.close();
  }

  @Test
  public void testSingleStatementTransaction() throws SQLException {
    String TRANSACTION_TABLE = "EXT_JDBC_TRANSACTION_TABLE2" + random.nextInt(99);
    String createTransactionTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, TRANSACTION_TABLE);
    String beginTransaction = "BEGIN TRANSACTION; ";
    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (id, name, age) VALUES (12, 'Farhan', %s);",
            DATASET, TRANSACTION_TABLE, randomNumber);
    String updateQuery =
        String.format(
            "UPDATE %s.%s SET age = 14 WHERE age = %s;", DATASET, TRANSACTION_TABLE, randomNumber);
    String selectQuery =
        String.format("SELECT id, name, age FROM %s.%s WHERE id = 12;", DATASET, TRANSACTION_TABLE);
    String commitTransaction = "COMMIT TRANSACTION;";

    String transactionQuery =
        beginTransaction
            + insertQuery
            + insertQuery
            + updateQuery
            + selectQuery
            + commitTransaction;

    Connection connection1 =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection1.createStatement();
    bigQueryStatement.execute(createTransactionTable);

    // Run the transaction
    Connection connection = DriverManager.getConnection(session_enabled_connection_uri);
    Statement statement = connection.createStatement();
    statement.execute(transactionQuery);

    // Test each query's result with getMoreResults
    int resultsCount = 0;
    boolean hasMoreResult = statement.getMoreResults();
    while (hasMoreResult || statement.getUpdateCount() != -1) {
      if (statement.getUpdateCount() == -1) {
        ResultSet result = statement.getResultSet();
        assertTrue(result.next());
        assertEquals(-1, statement.getUpdateCount());
      } else {
        assertTrue(statement.getUpdateCount() > -1);
      }
      hasMoreResult = statement.getMoreResults();
      resultsCount++;
    }

    // Check the transaction was actually committed.
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    int rowCount = 0;
    while (resultSet.next()) {
      rowCount++;
      assertEquals(14, resultSet.getInt(3));
    }
    assertEquals(2, rowCount);

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TRANSACTION_TABLE));
    connection.close();
  }

  @Test
  public void testConnectionWithMultipleTransactionCommits() throws SQLException {
    String TRANSACTION_TABLE = "EXT_JDBC_MULTI_COMMIT_TABLE" + randomNumber;
    String createTransactionTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, TRANSACTION_TABLE);
    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (id, name, age) VALUES (12, 'DwightShrute', %s);",
            DATASET, TRANSACTION_TABLE, randomNumber);
    String updateQuery =
        String.format(
            "UPDATE %s.%s SET age = 14 WHERE age = %s;", DATASET, TRANSACTION_TABLE, randomNumber);
    String selectQuery =
        String.format("SELECT id, name, age FROM %s.%s WHERE id = 12;", DATASET, TRANSACTION_TABLE);

    Connection setupConnection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement setupStatement = setupConnection.createStatement();
    setupStatement.execute(createTransactionTable);
    setupStatement.close();
    setupConnection.close();

    Connection connection = DriverManager.getConnection(session_enabled_connection_uri);
    connection.setAutoCommit(false);

    Statement statement = connection.createStatement();
    statement.execute(insertQuery);
    statement.execute(updateQuery);
    connection.commit(); // First transaction

    // After commit, a new transaction should have started.
    // Executing another query and then rolling it back.
    String insertQuery2 =
        String.format(
            "INSERT INTO %s.%s (id, name, age) VALUES (15, 'MichaelScott', 25);",
            DATASET, TRANSACTION_TABLE);
    statement.execute(insertQuery2);
    connection.rollback(); // Second transaction

    // Verify state with a separate connection
    Connection verifyConnection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement verifyStatement = verifyConnection.createStatement();
    ResultSet resultSet = verifyStatement.executeQuery(selectQuery);
    int count = 0;
    while (resultSet.next()) {
      count++;
      assertEquals(14, resultSet.getInt("age"));
    }
    assertEquals(1, count); // Only first transaction should be committed.

    // Verify the second insert was rolled back
    ResultSet rs2 =
        verifyStatement.executeQuery(
            String.format("SELECT * FROM %s.%s WHERE id=15", DATASET, TRANSACTION_TABLE));
    assertFalse(rs2.next());

    verifyStatement.execute(
        String.format("DROP TABLE IF EXISTS %s.%s", DATASET, TRANSACTION_TABLE));

    verifyStatement.close();
    verifyConnection.close();
    statement.close();
    connection.close();
  }

  @Test
  public void testScript() throws SQLException {
    String BASE_QUERY =
        "SELECT * FROM bigquery-public-data.new_york_taxi_trips.tlc_yellow_trips_2017 order by"
            + " trip_distance asc LIMIT %s;";
    String query1 = String.format(BASE_QUERY, 5000);
    String query2 = String.format(BASE_QUERY, 7000);
    String query3 = String.format(BASE_QUERY, 9000);

    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection.createStatement();
    bigQueryStatement.execute(query1 + query2 + query3);
    ResultSet resultSet = bigQueryStatement.getResultSet();
    assertEquals(5000, resultSetRowCount(resultSet));

    boolean hasMoreResult = bigQueryStatement.getMoreResults();
    assertTrue(hasMoreResult);
    resultSet = bigQueryStatement.getResultSet();
    assertEquals(7000, resultSetRowCount(resultSet));

    hasMoreResult = bigQueryStatement.getMoreResults();
    assertTrue(hasMoreResult);
    resultSet = bigQueryStatement.getResultSet();
    assertEquals(9000, resultSetRowCount(resultSet));
    connection.close();
  }

  @Test
  public void testMultiStatementTransactionRollbackByUser() throws SQLException {
    String TRANSACTION_TABLE = "EXT_JDBC_TRANSACTION_TABLE3" + random.nextInt(99);
    String createTransactionTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, TRANSACTION_TABLE);
    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (id, name, age) VALUES (12, 'Farhan', %s);",
            DATASET, TRANSACTION_TABLE, randomNumber);
    String updateQuery =
        String.format(
            "UPDATE %s.%s SET age = 14 WHERE age = %s;", DATASET, TRANSACTION_TABLE, randomNumber);
    String selectQuery =
        String.format("SELECT id, name, age FROM %s.%s WHERE id = 12;", DATASET, TRANSACTION_TABLE);

    Connection connection1 =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection1.createStatement();
    bigQueryStatement.execute(createTransactionTable);

    Connection connection = DriverManager.getConnection(session_enabled_connection_uri);
    connection.setAutoCommit(false);
    Statement statement = connection.createStatement();

    boolean status = statement.execute(insertQuery);
    assertFalse(status);
    int rows = statement.executeUpdate(updateQuery);
    assertEquals(1, rows);
    status = statement.execute(selectQuery);
    assertTrue(status);
    connection.rollback();

    // Separate query to check if transaction rollback worked
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertFalse(resultSet.next());

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TRANSACTION_TABLE));
    connection.close();
  }

  @Test
  public void testMultiStatementTransactionDoesNotCommitWithoutCommit() throws SQLException {
    String TRANSACTION_TABLE = "EXT_JDBC_TRANSACTION_TABLE4" + random.nextInt(99);
    String createTransactionTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, TRANSACTION_TABLE);
    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (id, name, age) VALUES (12, 'Farhan', %s);",
            DATASET, TRANSACTION_TABLE, randomNumber);
    String updateQuery =
        String.format(
            "UPDATE %s.%s SET age = 14 WHERE age = %s;", DATASET, TRANSACTION_TABLE, randomNumber);
    String selectQuery =
        String.format("SELECT id, name, age FROM %s.%s WHERE id = 12;", DATASET, TRANSACTION_TABLE);

    Connection connection1 =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection1.createStatement();
    bigQueryStatement.execute(createTransactionTable);
    Connection connection = DriverManager.getConnection(session_enabled_connection_uri);
    connection.setAutoCommit(false);
    Statement statement = connection.createStatement();

    boolean status = statement.execute(insertQuery);
    assertFalse(status);
    int rows = statement.executeUpdate(updateQuery);
    assertEquals(1, rows);
    status = statement.execute(selectQuery);
    assertTrue(status);

    // Separate query to check nothing committed
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertFalse(resultSet.next());

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TRANSACTION_TABLE));
    statement.close();
    connection.close();
  }

  @Test
  public void testValidMultiStatementTransactionCommits() throws SQLException {
    String TRANSACTION_TABLE = "EXT_JDBC_TRANSACTION_TABLE5" + random.nextInt(99);
    String createTransactionTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, TRANSACTION_TABLE);
    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (id, name, age) VALUES (12, 'Farhan', %s);",
            DATASET, TRANSACTION_TABLE, randomNumber);
    String updateQuery =
        String.format(
            "UPDATE %s.%s SET age = 14 WHERE age = %s;", DATASET, TRANSACTION_TABLE, randomNumber);
    String selectQuery =
        String.format("SELECT id, name, age FROM %s.%s WHERE id = 12;", DATASET, TRANSACTION_TABLE);

    Connection connection1 =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection1.createStatement();
    bigQueryStatement.execute(createTransactionTable);
    Connection connection = DriverManager.getConnection(session_enabled_connection_uri);
    connection.setAutoCommit(false);
    Statement statement = connection.createStatement();

    boolean status = statement.execute(insertQuery);
    assertFalse(status);
    status = statement.execute(updateQuery);
    assertFalse(status);
    status = statement.execute(selectQuery);
    assertTrue(status);
    connection.commit();

    // Separate query to check inserted and updated data committed
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertTrue(resultSet.next());
    assertEquals(14, resultSet.getInt(3));

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TRANSACTION_TABLE));
    statement.close();
    connection.close();
  }

  @Test
  public void testTransactionRollbackOnError() throws SQLException {
    String TRANSACTION_TABLE = "EXT_JDBC_TRANSACTION_TABLE6" + random.nextInt(99);
    String createTransactionTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, TRANSACTION_TABLE);
    String selectQuery =
        String.format("SELECT id, name, age FROM %s.%s ;", DATASET, TRANSACTION_TABLE);

    Connection connection1 =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection1.createStatement();
    bigQueryStatement.execute(createTransactionTable);
    String transactionOnError =
        "BEGIN\n"
            + "\n"
            + "  BEGIN TRANSACTION;\n"
            + "  INSERT INTO "
            + DATASET
            + "."
            + TRANSACTION_TABLE
            + "\n"
            + "    VALUES (39, 'Drake', 123);\n"
            + "  SELECT 1/0;\n"
            + "  COMMIT TRANSACTION;\n"
            + "\n"
            + "EXCEPTION WHEN ERROR THEN\n"
            + "  SELECT @@error.message;\n"
            + "  ROLLBACK TRANSACTION;\n"
            + "END;";
    Connection connection = DriverManager.getConnection(session_enabled_connection_uri);
    Statement statement = connection.createStatement();
    statement.execute(transactionOnError);

    // do a check to see if no vals inserted
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertFalse(resultSet.next());

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TRANSACTION_TABLE));
    connection.close();
    connection1.close();
  }

  @Test
  public void testValidLegacySQLStatement() throws SQLException {
    String legacyJoinQuery =
        "SELECT\n"
            + "  repo_name\n"
            + "FROM\n"
            + "  [bigquery-public-data.github_repos.commits],\n"
            + "  [bigquery-public-data.github_repos.sample_commits] LIMIT 10";
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;ProjectId="
            + DEFAULT_CATALOG
            + ";QueryDialect=BIG_QUERY;";
    Connection connection = DriverManager.getConnection(connection_uri);
    Statement statement = connection.createStatement();

    boolean result = statement.execute(legacyJoinQuery);
    assertTrue(result);
    connection.close();
  }

  @Test
  public void testExecuteUpdate() throws SQLException {
    String TABLE_NAME = "EXT_JDBC_EXECUTE_UPDATE_TABLE_" + randomNumber;
    String createQuery =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`StringField` STRING, `IntegerField` INTEGER);",
            DATASET, TABLE_NAME);
    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (StringField, IntegerField) "
                + "VALUES ('string1',111 ), ('string2',111 ), ('string3',222 ), ('string4',333 );",
            DATASET, TABLE_NAME);
    String updateQuery =
        String.format(
            "UPDATE %s.%s SET StringField='Jane Doe' WHERE IntegerField=111", DATASET, TABLE_NAME);
    String dropQuery = String.format("DROP TABLE %s.%s", DATASET, TABLE_NAME);
    String selectQuery = String.format("SELECT * FROM %s.%s", DATASET, TABLE_NAME);

    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection.createStatement();
    int createStatus = bigQueryStatement.executeUpdate(createQuery);
    assertEquals(0, createStatus);

    int insertStatus = bigQueryStatement.executeUpdate(insertQuery);
    assertEquals(4, insertStatus);

    bigQueryStatement.executeQuery(selectQuery);
    int selectStatus = bigQueryStatement.getUpdateCount();
    assertEquals(-1, selectStatus);

    int updateStatus = bigQueryStatement.executeUpdate(updateQuery);
    assertEquals(2, updateStatus);

    int dropStatus = bigQueryStatement.executeUpdate(dropQuery);
    assertEquals(0, dropStatus);

    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TABLE_NAME));
    connection.close();
  }

  @Test
  public void testExecuteMethod() throws SQLException {

    String TABLE_NAME = "EXT_JDBC_EXECUTE_TABLE_" + randomNumber;
    String createQuery =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`StringField` STRING, `IntegerField` INTEGER);",
            DATASET, TABLE_NAME);
    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (StringField, IntegerField) "
                + "VALUES ('string1',111 ), ('string2',111 ), ('string3',222 ), ('string4',333 );",
            DATASET, TABLE_NAME);
    String updateQuery =
        String.format(
            "UPDATE %s.%s SET StringField='Jane Doe' WHERE IntegerField=111", DATASET, TABLE_NAME);
    String dropQuery = String.format("DROP TABLE %s.%s", DATASET, TABLE_NAME);
    String selectQuery = String.format("SELECT * FROM %s.%s", DATASET, TABLE_NAME);

    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection.createStatement();
    boolean createStatus = bigQueryStatement.execute(createQuery);
    assertFalse(createStatus);

    boolean insertStatus = bigQueryStatement.execute(insertQuery);
    assertFalse(insertStatus);

    boolean selectStatus = bigQueryStatement.execute(selectQuery);
    assertTrue(selectStatus);
    int selectCount = bigQueryStatement.getUpdateCount();
    assertEquals(-1, selectCount);
    ResultSet resultSet = bigQueryStatement.getResultSet();
    assertNotNull(resultSet);

    boolean updateStatus = bigQueryStatement.execute(updateQuery);
    assertFalse(updateStatus);

    boolean dropStatus = bigQueryStatement.execute(dropQuery);
    assertFalse(dropStatus);
    connection.close();
  }

  @Test
  public void testPreparedExecuteMethod() throws SQLException {

    String TABLE_NAME = "EXT_JDBC_PREPARED_EXECUTE_TABLE_" + randomNumber;
    String createQuery =
        String.format(
            "CREATE OR REPLACE TABLE `%s.%s` (`StringField` STRING, `IntegerField` INTEGER);",
            DATASET, TABLE_NAME);
    String insertQuery =
        String.format(
            "INSERT INTO `%s.%s` (StringField, IntegerField) VALUES (?,?), (?,?), (?,?), (?,?);",
            DATASET, TABLE_NAME);
    String updateQuery =
        String.format("UPDATE `%s.%s` SET StringField=? WHERE IntegerField=?", DATASET, TABLE_NAME);
    String dropQuery = String.format("DROP TABLE `%s.%s`", DATASET, TABLE_NAME);
    String selectQuery = String.format("SELECT StringField FROM `%s.%s`", DATASET, TABLE_NAME);
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection.createStatement();
    boolean createStatus = bigQueryStatement.execute(createQuery);
    assertFalse(createStatus);

    PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
    insertStmt.setString(1, "String1");
    insertStmt.setInt(2, 111);
    insertStmt.setString(3, "String2");
    insertStmt.setInt(4, 222);
    insertStmt.setString(5, "String3");
    insertStmt.setInt(6, 333);
    insertStmt.setString(7, "String4");
    insertStmt.setInt(8, 444);

    boolean insertStatus = insertStmt.execute();
    assertFalse(insertStatus);

    Statement selectStmt = connection.createStatement();
    boolean selectStatus = selectStmt.execute(selectQuery);
    assertTrue(selectStatus);

    int selectCount = selectStmt.getUpdateCount();
    assertEquals(-1, selectCount);
    ResultSet resultSet = selectStmt.getResultSet();
    assertNotNull(resultSet);

    PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
    updateStmt.setString(1, "Jane Doe");
    updateStmt.setInt(2, 222);
    boolean updateStatus = updateStmt.execute();
    assertFalse(updateStatus);

    boolean dropStatus = bigQueryStatement.execute(dropQuery);
    assertFalse(dropStatus);
    connection.close();
  }

  @Test
  public void testPreparedStatementThrowsJdbcException() throws SQLException {
    String TABLE_NAME = "EXT_JDBC_PREPARED_MISSING_PARAM_TABLE_" + randomNumber;
    String createQuery =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (StringField STRING, IntegerField INTEGER);",
            DATASET, TABLE_NAME);
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement bigQueryStatement = connection.createStatement();
    boolean createStatus = bigQueryStatement.execute(createQuery);
    assertFalse(createStatus);

    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (StringField, IntegerField) " + "VALUES (?,?), (?,?);",
            DATASET, TABLE_NAME);
    PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
    insertStmt.setString(1, "String1");
    insertStmt.setInt(2, 111);
    assertThrows(SQLException.class, insertStmt::execute);

    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TABLE_NAME));
    connection.close();
  }

  @Test
  public void testValidExecuteBatch() throws SQLException {
    // setup
    String BATCH_TABLE = "EXT_JDBC_EXECUTE_BATCH_TABLE_" + random.nextInt(99);
    String createBatchTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, BATCH_TABLE);

    Connection connection =
        DriverManager.getConnection(
            String.format(connectionUrl, DEFAULT_CATALOG), new Properties());
    Statement statement = connection.createStatement();
    statement.execute(createBatchTable);
    // act
    // batch bypasses the 16 concurrent limit
    int[] results;
    for (int i = 0; i < 3; i++) {
      String insertQuery =
          "INSERT INTO "
              + DATASET
              + "."
              + BATCH_TABLE
              + " (id, name, age) "
              + "VALUES (12, 'Farhan', "
              + randomNumber
              + i
              + "); ";
      statement.addBatch(insertQuery);
    }
    results = statement.executeBatch();

    // assertions
    assertEquals(3, results.length);
    for (int updateCount : results) {
      assertEquals(1, updateCount);
    }
    statement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, BATCH_TABLE));
    connection.close();
  }

  @Test
  public void testAddBatchWithoutSemicolon() throws SQLException {
    // setup
    String BATCH_TABLE = "EXT_JDBC_EXECUTE_BATCH_TABLE_MISSING_SEMICOLON_" + random.nextInt(99);
    String createBatchTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, BATCH_TABLE);

    Connection connection =
        DriverManager.getConnection(
            String.format(connectionUrl, DEFAULT_CATALOG), new Properties());
    Statement statement = connection.createStatement();
    statement.execute(createBatchTable);

    // act
    // batch bypasses the 16 concurrent limit
    String insertQuery =
        "INSERT INTO "
            + DATASET
            + "."
            + BATCH_TABLE
            + " (id, name, age) "
            + "VALUES (12, 'Farhan', 4)";
    statement.addBatch(insertQuery);
    statement.addBatch(insertQuery);
    int[] results = statement.executeBatch();

    // assertions
    assertEquals(2, results.length);
    for (int updateCount : results) {
      assertEquals(1, updateCount);
    }
    statement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, BATCH_TABLE));
    connection.close();
    connection.close();
  }

  // Array and Struct not tested.
  @Test
  public void testValidAllDataTypesSerializationFromSelectQuery() throws SQLException {
    String DATASET = "JDBC_INTEGRATION_DATASET";
    String TABLE_NAME = "JDBC_DATATYPES_INTEGRATION_TEST_TABLE";
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME;

    Connection connection =
        DriverManager.getConnection(
            String.format(connectionUrl, DEFAULT_CATALOG), new Properties());
    Statement bigQueryStatement = connection.createStatement();
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertNotNull(resultSet);
    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
    resultSet.next();
    assertEquals(16, resultSetMetaData.getColumnCount());
    assertTrue(resultSet.getBoolean(1));
    assertEquals(33, resultSet.getInt(2));
    assertEquals(50.05f, resultSet.getFloat(3), 0.0);
    assertEquals(123.456, resultSet.getDouble(4), 0.0);
    assertEquals(123.456789, resultSet.getDouble(5), 0.0);
    assertEquals("testString", resultSet.getString(6));
    assertEquals("Test String", new String(resultSet.getBytes(7), StandardCharsets.UTF_8));
    assertEquals(Timestamp.valueOf("2020-04-27 18:07:25.356456"), resultSet.getObject(10));
    assertEquals(Date.valueOf("2019-1-12"), resultSet.getObject(11));
    assertEquals(Time.valueOf("14:00:00"), resultSet.getObject(12));
    assertEquals(Timestamp.valueOf("2019-02-17 11:24:00.0"), resultSet.getObject(13));
    assertEquals("POINT(1 2)", resultSet.getString(14));
    assertEquals("{\"class\":{\"students\":[{\"name\":\"Jane\"}]}}", resultSet.getString(15));
    assertEquals("123-7 -19 0:24:12.000006", resultSet.getString(16));
    connection.close();
  }

  // Array and Struct not tested.
  @Test
  public void testValidAllDataTypesSerializationFromSelectQueryArrowDataset() throws SQLException {
    String DATASET = "JDBC_INTEGRATION_DATASET";
    String TABLE_NAME = "JDBC_INTEGRATION_ARROW_TEST_TABLE";
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME + " LIMIT 5000;";
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;ProjectId="
            + DEFAULT_CATALOG
            + ";EnableHighThroughputAPI=1;"
            + "HighThroughputActivationRatio=2;"
            + "HighThroughputMinTableSize=1000;";

    // Read data via JDBC
    Connection connection = DriverManager.getConnection(connection_uri);
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(selectQuery);
    assertNotNull(resultSet);

    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
    resultSet.next();
    assertEquals(15, resultSetMetaData.getColumnCount());
    assertTrue(resultSet.getBoolean(1));
    assertEquals(33, resultSet.getInt(2));
    assertEquals(50.05f, resultSet.getFloat(3), 0.0);
    assertEquals(123.456, resultSet.getDouble(4), 0.0);
    assertEquals(123.456789, resultSet.getDouble(5), 0.0);
    assertEquals("testString", resultSet.getString(6));
    assertEquals("Test String", new String(resultSet.getBytes(7), StandardCharsets.UTF_8));
    assertEquals(Timestamp.valueOf("2020-04-27 18:07:25.356"), resultSet.getObject(10));
    assertEquals(Timestamp.valueOf("2020-04-27 18:07:25.356"), resultSet.getTimestamp(10));
    assertEquals(Date.valueOf("2019-1-12"), resultSet.getObject(11));
    assertEquals(Date.valueOf("2019-1-12"), resultSet.getDate(11));
    assertEquals(Time.valueOf("14:00:00"), resultSet.getObject(12));
    assertEquals(Time.valueOf("14:00:00"), resultSet.getTime(12));
    assertEquals(Timestamp.valueOf("2022-01-22 22:22:12.142265"), resultSet.getObject(13));
    assertEquals("POINT(1 2)", resultSet.getString(14));
    assertEquals("{\"class\":{\"students\":[{\"name\":\"Jane\"}]}}", resultSet.getString(15));
    connection.close();
    connection.close();
  }

  @Test
  public void testUnsupportedHTAPIFallbacksToStandardQueriesWithRange() throws SQLException {
    String selectQuery = "select * from `DATATYPERANGETEST.RangeIntervalTestTable` LIMIT 5000;";
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;ProjectId="
            + DEFAULT_CATALOG
            + ";MaxResults=500;HighThroughputActivationRatio=1;"
            + "HighThroughputMinTableSize=100;"
            + "EnableHighThroughputAPI=1;UnsupportedHTAPIFallback=1;JobCreationMode=1;";

    // Read data via JDBC
    Connection connection = DriverManager.getConnection(connection_uri);
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(selectQuery);
    assertNotNull(resultSet);

    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
    resultSet.next();
    assertEquals(3, resultSetMetaData.getColumnCount());
    connection.close();
    connection.close();
  }

  @Test
  public void testValidLEPEndpointQuery() throws SQLException, InterruptedException {
    String DATASET = "JDBC_REGIONAL_DATASET";
    String TABLE_NAME = "REGIONAL_TABLE";
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME;
    String connection_uri =
        "jdbc:bigquery://https://googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + DEFAULT_CATALOG
            + ";"
            + "EndpointOverrides=BIGQUERY=https://us-east4-bigquery.googleapis.com;";

    // Read data via JDBC
    Connection connection = DriverManager.getConnection(connection_uri);
    JdbcConnectionHelper.setUpDataset(DATASET);
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(selectQuery);
    assertNotNull(resultSet.getMetaData());
    connection.close();
  }

  @Test
  public void testValidEndpointWithInvalidBQPortThrows() throws SQLException {
    String TABLE_NAME = "EXT_JDBC_REGIONAL_TABLE_" + randomNumber;
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME;
    String connection_uri =
        "jdbc:bigquery://https://googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + DEFAULT_CATALOG
            + ";"
            + "EndpointOverrides=BIGQUERY=https://us-east4-bigquery.googleapis.com:12312312;";

    // Read data via JDBC
    Connection connection = DriverManager.getConnection(connection_uri);
    Statement statement = connection.createStatement();
    assertThrows(SQLException.class, () -> statement.executeQuery(selectQuery));
    connection.close();
  }

  @Test
  public void testValidREPEndpointQuery() throws SQLException, InterruptedException {
    String DATASET = "JDBC_REGIONAL_DATASET";
    String TABLE_NAME = "REGIONAL_TABLE";
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME;
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + DEFAULT_CATALOG
            + ";"
            + "EndpointOverrides=BIGQUERY=https://bigquery.us-east4.rep.googleapis.com;";

    // Read data via JDBC
    Connection connection = DriverManager.getConnection(connection_uri);
    JdbcConnectionHelper.setUpDataset(DATASET);
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(selectQuery);
    assertNotNull(resultSet.getMetaData());
    connection.close();
  }

  @Test
  public void testCloseStatement() throws SQLException {
    String query = "SELECT * FROM `bigquery-public-data.samples.github_timeline` LIMIT 10";
    Connection connection =
        DriverManager.getConnection(
            String.format(connectionUrl, DEFAULT_CATALOG), new Properties());
    Statement statement = connection.createStatement();
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertEquals(10, resultSetRowCount(jsonResultSet));
    statement.close();
    assertTrue(statement.isClosed());
    connection.close();
  }

  @Test
  public void testPreparedStatementSmallSelect() throws SQLException {
    String query =
        "SELECT * FROM `bigquery-public-data.samples.github_timeline` where repository_language=?"
            + " LIMIT 1000";
    Connection connection =
        DriverManager.getConnection(
            String.format(connectionUrl, DEFAULT_CATALOG), new Properties());
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setString(1, "Java");

    ResultSet jsonResultSet = preparedStatement.executeQuery();

    int rowCount = resultSetRowCount(jsonResultSet);
    assertEquals(1000, rowCount);
    connection.close();
  }

  @Test
  public void testPreparedStatementExecuteUpdate() throws SQLException {
    Random random = new Random();
    String DATASET = "JDBC_INTEGRATION_DATASET";
    String TABLE_NAME1 = "Inventory" + random.nextInt(9999);
    String TABLE_NAME2 = "DetailedInventory" + random.nextInt(9999);

    String createQuery =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`product` STRING, `quantity` INTEGER);",
            DATASET, TABLE_NAME1);

    String createQuery2 =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`product` STRING, `quantity` INTEGER,"
                + " `supply_constrained` BOOLEAN, `comment` STRING);",
            DATASET, TABLE_NAME2);

    String insertQuery2 =
        String.format(
            "INSERT INTO %s.%s (product, quantity, supply_constrained, comment) "
                + "VALUES ('countertop microwave', 20, NULL,'[]' ),"
                + " ('front load washer', 20, false,'[]' ), "
                + " ('microwave', 20, false,'[]' ), "
                + " ('refrigerator', 10, false,'[]' );",
            DATASET, TABLE_NAME2);

    Connection connection =
        DriverManager.getConnection(
            String.format(connectionUrl, DEFAULT_CATALOG), new Properties());
    Statement bigQueryStatement = connection.createStatement();
    bigQueryStatement.execute(createQuery);
    bigQueryStatement.execute(createQuery2);
    bigQueryStatement.execute(insertQuery2);

    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (product, quantity) " + "VALUES (?,? ), (?,? );",
            DATASET, TABLE_NAME1);
    PreparedStatement insertPs = connection.prepareStatement(insertQuery);
    insertPs.setString(1, "dishwasher");
    insertPs.setInt(2, 30);
    insertPs.setString(3, "dryer");
    insertPs.setInt(4, 30);

    int insertStatus = insertPs.executeUpdate();
    assertEquals(2, insertStatus);

    String updateQuery =
        String.format("UPDATE %s.%s SET quantity=? WHERE product=?", DATASET, TABLE_NAME1);
    PreparedStatement updatePs = connection.prepareStatement(updateQuery);
    updatePs.setString(2, "dryer");
    updatePs.setInt(1, 35);

    int updateStatus = updatePs.executeUpdate();
    assertEquals(1, updateStatus);

    String deleteQuery = String.format("DELETE FROM %s.%s WHERE product=?", DATASET, TABLE_NAME1);
    PreparedStatement deletePs = connection.prepareStatement(deleteQuery);
    deletePs.setString(1, "dishwasher");

    int deleteStatus = deletePs.executeUpdate();
    assertEquals(1, deleteStatus);

    String mergeQuery =
        String.format(
            "MERGE %s.%s T\n"
                + "USING %s.%s S\n"
                + "ON T.product = S.product\n"
                + "WHEN NOT MATCHED AND quantity < ? THEN\n"
                + "  INSERT(product, quantity, supply_constrained, comment)\n"
                + "  VALUES(product, quantity, true, ?)\n"
                + "WHEN NOT MATCHED THEN\n"
                + "  INSERT(product, quantity, supply_constrained)\n"
                + "  VALUES(product, quantity, false)",
            DATASET, TABLE_NAME2, DATASET, TABLE_NAME1);
    PreparedStatement mergePs = connection.prepareStatement(mergeQuery);
    mergePs.setInt(1, 20);
    mergePs.setString(2, "comment" + random.nextInt(999));

    int mergeStatus = mergePs.executeUpdate();
    assertEquals(1, mergeStatus);

    ResultSet rs =
        bigQueryStatement.executeQuery(
            String.format("SELECT COUNT(*) AS row_count\n" + "FROM %s.%s", DATASET, TABLE_NAME2));
    rs.next();
    assertEquals(5, rs.getInt(1));

    String dropQuery = String.format("DROP TABLE %s.%s", DATASET, TABLE_NAME1);
    int dropStatus = bigQueryStatement.executeUpdate(dropQuery);
    assertEquals(0, dropStatus);
    bigQueryStatement.execute(String.format("DROP TABLE %s.%s", DATASET, TABLE_NAME2));
    connection.close();
  }

  @Test
  public void testUseLegacySQLWithLargeResultsNotAllowedQueries() throws SQLException {
    // setup
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + DEFAULT_CATALOG
            + ";QueryDialect=BIG_QUERY;AllowLargeResults=0;";
    String selectLegacyQuery =
        "SELECT * FROM [bigquery-public-data.deepmind_alphafold.metadata] LIMIT 250000;";
    Connection connection = DriverManager.getConnection(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    ResultSet resultSet = statement.executeQuery(selectLegacyQuery);

    // assertion
    assertNotNull(resultSet);
    connection.close();
  }

  @Test
  public void testUseLegacySQLWithLargeResultsAllowedWithNoDestinationTableDefaults()
      throws SQLException {
    // setup
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + DEFAULT_CATALOG
            + ";QueryDialect=BIG_QUERY;AllowLargeResults=1;";
    String selectLegacyQuery =
        "SELECT * FROM [bigquery-public-data.deepmind_alphafold.metadata] LIMIT 250000;";
    Connection connection = DriverManager.getConnection(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    ResultSet resultSet = statement.executeQuery(selectLegacyQuery);

    // assertion
    assertNotNull(resultSet);
    connection.close();
  }

  @Test
  public void testValidDestinationTableSavesQueriesWithLegacySQL() throws SQLException {
    // setup
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + DEFAULT_CATALOG
            + ";QueryDialect=BIG_QUERY;"
            + "AllowLargeResults=1;"
            + "LargeResultTable=destination_table_test_legacy;"
            + "LargeResultDataset=INTEGRATION_TESTS;";
    String selectLegacyQuery =
        "SELECT * FROM [bigquery-public-data.deepmind_alphafold.metadata] LIMIT 200;";
    Connection connection = DriverManager.getConnection(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    ResultSet resultSet = statement.executeQuery(selectLegacyQuery);

    // assertion
    assertNotNull(resultSet);
    String selectQuery = "SELECT * FROM `INTEGRATION_TESTS.destination_table_test_legacy`;";
    Connection connection1 =
        DriverManager.getConnection(
            String.format(connectionUrl, DEFAULT_CATALOG), new Properties());
    Statement bigQueryStatement = connection1.createStatement();
    ResultSet actualResultSet = bigQueryStatement.executeQuery(selectQuery);
    assertTrue(0 < resultSetRowCount(actualResultSet));

    // clean up
    String deleteRows = "DELETE FROM `INTEGRATION_TESTS.destination_table_test_legacy` WHERE 1=1;";
    bigQueryStatement.execute(deleteRows);
    connection.close();
  }

  @Test
  public void testValidDestinationTableSavesQueriesWithStandardSQL() throws SQLException {
    // setup
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + DEFAULT_CATALOG
            + ";QueryDialect=SQL;"
            + "LargeResultTable=destination_table_test;"
            + "LargeResultDataset=INTEGRATION_TESTS;";
    String selectLegacyQuery =
        "SELECT * FROM `bigquery-public-data.deepmind_alphafold.metadata` LIMIT 200;";
    Connection connection = DriverManager.getConnection(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    ResultSet resultSet = statement.executeQuery(selectLegacyQuery);

    // assertion
    assertNotNull(resultSet);
    String selectQuery = "SELECT * FROM INTEGRATION_TESTS.destination_table_test;";
    Connection connection1 =
        DriverManager.getConnection(
            String.format(connectionUrl, DEFAULT_CATALOG), new Properties());
    Statement bigQueryStatement = connection1.createStatement();
    ResultSet actualResultSet = bigQueryStatement.executeQuery(selectQuery);
    assertEquals(200, resultSetRowCount(actualResultSet));

    // clean up
    String deleteRows = "DELETE FROM `INTEGRATION_TESTS.destination_table_test` WHERE 1=1;";
    bigQueryStatement.execute(deleteRows);
    connection.close();
  }

  @Test
  public void testDestinationTableAndDestinationDatasetThatDoesNotExistsCreates()
      throws SQLException {
    // setup
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + DEFAULT_CATALOG
            + ";QueryDialect=BIG_QUERY;"
            + "AllowLargeResults=1;"
            + "LargeResultTable=FakeTable;"
            + "LargeResultDataset=FakeDataset;";
    String selectLegacyQuery =
        "SELECT * FROM [bigquery-public-data.deepmind_alphafold.metadata] LIMIT 200;";
    Connection connection = DriverManager.getConnection(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    ResultSet resultSet = statement.executeQuery(selectLegacyQuery);

    // assertion
    assertNotNull(resultSet);
    String separateQuery = "SELECT * FROM FakeDataset.FakeTable;";
    Connection connection1 =
        DriverManager.getConnection(
            String.format(connectionUrl, DEFAULT_CATALOG), new Properties());
    Statement bigQueryStatement = connection1.createStatement();
    boolean result = bigQueryStatement.execute(separateQuery);
    assertTrue(result);

    // clean up
    bigQueryStatement.execute("DROP SCHEMA FakeDataset CASCADE;");
    connection.close();
  }

  @Test
  public void testNonSelectForStandardDestinationTableDoesNotThrow() throws SQLException {
    // setup
    String TRANSACTION_TABLE = "EXT_JDBC_TRANSACTION_TABLE8" + random.nextInt(99);
    String createTransactionTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, TRANSACTION_TABLE);
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + DEFAULT_CATALOG
            + ";QueryDialect=SQL;"
            + "AllowLargeResults=1;"
            + "LargeResultTable=destination_table_test;"
            + "LargeResultDataset=INTEGRATION_TESTS;";
    Connection connection = DriverManager.getConnection(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act & assertion
    statement.execute(createTransactionTable);
    connection.close();
  }

  @Test
  public void testNonEnabledUseLegacySQLThrowsSyntaxError() throws SQLException {
    // setup
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + DEFAULT_CATALOG
            + ";";
    String selectLegacyQuery =
        "SELECT * FROM [bigquery-public-data.deepmind_alphafold.metadata] LIMIT 20000000;";
    Connection connection = DriverManager.getConnection(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act & assertion
    assertThrows(SQLException.class, () -> statement.execute(selectLegacyQuery));
    connection.close();
  }

  // result order is wrong here, simba will fix this in a future release
  // b/356365421
  @Test
  @Ignore
  public void testTableConstraints() throws SQLException {
    Connection connection =
        DriverManager.getConnection(
            String.format(connectionUrl, DEFAULT_CATALOG), new Properties());
    ResultSet primaryKey1 =
        connection
            .getMetaData()
            .getPrimaryKeys(DEFAULT_CATALOG, CONSTRAINTS_DATASET, CONSTRAINTS_TABLE_NAME);
    primaryKey1.next();
    assertEquals("id", primaryKey1.getString(4));
    assertFalse(primaryKey1.next());

    ResultSet primaryKey2 =
        connection
            .getMetaData()
            .getPrimaryKeys(DEFAULT_CATALOG, CONSTRAINTS_DATASET, CONSTRAINTS_TABLE_NAME2);
    primaryKey2.next();
    assertEquals("first_name", primaryKey2.getString(4));
    primaryKey2.next();
    assertEquals("last_name", primaryKey2.getString(4));
    assertFalse(primaryKey2.next());

    ResultSet foreignKeys =
        connection
            .getMetaData()
            .getImportedKeys(DEFAULT_CATALOG, CONSTRAINTS_DATASET, CONSTRAINTS_TABLE_NAME);
    foreignKeys.next();
    assertEquals(CONSTRAINTS_TABLE_NAME2, foreignKeys.getString(3));
    assertEquals("first_name", foreignKeys.getString(4));
    assertEquals("name", foreignKeys.getString(8));
    foreignKeys.next();
    assertEquals(CONSTRAINTS_TABLE_NAME2, foreignKeys.getString(3));
    assertEquals("last_name", foreignKeys.getString(4));
    assertEquals("second_name", foreignKeys.getString(8));
    foreignKeys.next();
    assertEquals(CONSTRAINTS_TABLE_NAME3, foreignKeys.getString(3));
    assertEquals("address", foreignKeys.getString(4));
    assertEquals("address", foreignKeys.getString(8));
    assertFalse(foreignKeys.next());

    ResultSet crossReference =
        connection
            .getMetaData()
            .getCrossReference(
                DEFAULT_CATALOG,
                CONSTRAINTS_DATASET,
                CONSTRAINTS_TABLE_NAME2,
                DEFAULT_CATALOG,
                CONSTRAINTS_DATASET,
                CONSTRAINTS_TABLE_NAME);
    crossReference.next();
    assertEquals(CONSTRAINTS_TABLE_NAME2, crossReference.getString(3));
    assertEquals("first_name", crossReference.getString(4));
    assertEquals("name", crossReference.getString(8));
    crossReference.next();
    assertEquals("last_name", crossReference.getString(4));
    assertEquals("second_name", crossReference.getString(8));
    connection.close();
  }

  @Test
  public void testDatabaseMetadataGetProcedures() throws SQLException {
    String DATASET = "JDBC_INTEGRATION_DATASET";
    String procedureName = "create_customer";
    Connection connection =
        DriverManager.getConnection(
            String.format(connectionUrl, DEFAULT_CATALOG), new Properties());
    DatabaseMetaData databaseMetaData = connection.getMetaData();
    ResultSet resultSet = databaseMetaData.getProcedures(DEFAULT_CATALOG, DATASET, procedureName);
    while (resultSet.next()) {
      assertEquals(DEFAULT_CATALOG, resultSet.getString("PROCEDURE_CAT"));
      assertEquals(DATASET, resultSet.getString("PROCEDURE_SCHEM"));
      assertEquals(procedureName, resultSet.getString("PROCEDURE_NAME"));
      assertEquals(procedureName, resultSet.getString("SPECIFIC_NAME"));
    }
    connection.close();
  }

  @Test
  public void testDatabaseMetadataGetProcedureColumns() throws SQLException {
    String DATASET = "JDBC_INTEGRATION_DATASET";
    String procedureName = "create_customer";
    String parameterName = "id";

    Connection connection =
        DriverManager.getConnection(
            String.format(connectionUrl, DEFAULT_CATALOG), new Properties());
    DatabaseMetaData databaseMetaData = connection.getMetaData();
    ResultSet resultSet =
        databaseMetaData.getProcedureColumns(
            DEFAULT_CATALOG, DATASET, procedureName, parameterName);
    while (resultSet.next()) {
      assertEquals(DEFAULT_CATALOG, resultSet.getString("PROCEDURE_CAT"));
      assertEquals(DATASET, resultSet.getString("PROCEDURE_SCHEM"));
      assertEquals(procedureName, resultSet.getString("PROCEDURE_NAME"));
      assertEquals(procedureName, resultSet.getString("SPECIFIC_NAME"));
      assertEquals(parameterName, resultSet.getString("COLUMN_NAME"));
      assertEquals(65535, resultSet.getInt("PRECISION"));
      assertEquals(2, resultSet.getShort("NULLABLE"));
    }
    connection.close();
  }

  @Test
  public void testAlterTable() throws SQLException {
    String TABLE_NAME = "EXT_JDBC_ALTER_TABLE_" + randomNumber;
    String createQuery =
        String.format("CREATE OR REPLACE TABLE %s.%s (`StringField` STRING);", DATASET, TABLE_NAME);
    String addColumnQuery =
        String.format("ALTER TABLE %s.%s ADD COLUMN `IntegerField` INTEGER;", DATASET, TABLE_NAME);
    String dropColumnQuery =
        String.format(
            "UPDATE %s.%s SET StringField='Jane Doe' WHERE IntegerField=111", DATASET, TABLE_NAME);
    String dropQuery = String.format("DROP TABLE %s.%s", DATASET, TABLE_NAME);
    String selectQuery = String.format("SELECT * FROM %s.%s", DATASET, TABLE_NAME);

    Connection connection =
        DriverManager.getConnection(
            String.format(connectionUrl, DEFAULT_CATALOG), new Properties());
    Statement bigQueryStatement = connection.createStatement();
    int createStatus = bigQueryStatement.executeUpdate(createQuery);
    assertEquals(0, createStatus);

    int addColumnStatus = bigQueryStatement.executeUpdate(addColumnQuery);
    assertEquals(0, addColumnStatus);

    bigQueryStatement.executeQuery(selectQuery);
    int selectStatus = bigQueryStatement.getUpdateCount();
    assertEquals(-1, selectStatus);

    int dropColumnStatus = bigQueryStatement.executeUpdate(dropColumnQuery);
    assertEquals(0, dropColumnStatus);

    int dropStatus = bigQueryStatement.executeUpdate(dropQuery);
    assertEquals(0, dropStatus);

    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TABLE_NAME));
    connection.close();
  }

  @Test
  public void testQueryPropertyDataSetProjectIdQueriesToIncorrectDatasetThrows()
      throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + DEFAULT_CATALOG
            + ";QueryProperties=dataset_project_id=bigquerytestdefault"
            + ";";
    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (id, name, age) VALUES (15, 'Farhan', 25);",
            "INTEGRATION_TESTS", "Test_Table");
    Connection connection = DriverManager.getConnection(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act & assertion
    assertThrows(SQLException.class, () -> statement.execute(insertQuery));
    connection.close();
  }

  @Test
  public void testQueryPropertyTimeZoneQueries() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + DEFAULT_CATALOG
            + ";QueryProperties=time_zone=America/New_York;";
    String query = "SELECT * FROM `bigquery-public-data.samples.github_timeline` LIMIT 180";
    Connection connection = DriverManager.getConnection(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    ResultSet resultSet = statement.executeQuery(query);

    // assertions
    assertNotNull(resultSet);
    assertTrue(resultSet.next());
    connection.close();
  }

  private int resultSetRowCount(ResultSet resultSet) throws SQLException {
    int rowCount = 0;
    while (resultSet.next()) {
      rowCount++;
    }
    return rowCount;
  }
}
