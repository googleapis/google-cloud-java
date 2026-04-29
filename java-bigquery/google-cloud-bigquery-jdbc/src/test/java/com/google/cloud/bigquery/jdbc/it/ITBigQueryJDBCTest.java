/*
 * Copyright 2023 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlSyntaxErrorException;
import com.google.cloud.bigquery.jdbc.BigQueryConnection;
import com.google.cloud.bigquery.jdbc.BigQueryDriver;
import com.google.cloud.bigquery.jdbc.DataSource;
import com.google.common.collect.ImmutableMap;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Properties;
import java.util.Random;
import java.util.function.BiFunction;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ITBigQueryJDBCTest extends ITBase {
  static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  static final String connection_uri =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
          + PROJECT_ID
          + ";OAUTHTYPE=3";
  static final String session_enabled_connection_uri = connection_uri + ";EnableSession=1";
  private static final String BASE_QUERY =
      "SELECT * FROM bigquery-public-data.new_york_taxi_trips.tlc_yellow_trips_2017 order by"
          + " trip_distance asc LIMIT %s";
  private static final Random random = new Random();
  private static final int randomNumber = random.nextInt(9999);
  private static final String DATASET = "JDBC_PRESUBMIT_INTEGRATION_DATASET";
  private static final Object EXCEPTION_REPLACEMENT = "EXCEPTION-WAS-RAISED";
  static Connection bigQueryConnection;
  static BigQuery bigQuery;
  static Statement bigQueryStatement;
  static Connection bigQueryConnectionNoReadApi;
  static Statement bigQueryStatementNoReadApi;

  @BeforeAll
  public static void beforeClass() throws SQLException {
    bigQueryConnection = DriverManager.getConnection(connection_uri, new Properties());
    bigQueryStatement = bigQueryConnection.createStatement();

    Properties noReadApi = new Properties();
    noReadApi.setProperty("EnableHighThroughputAPI", "0");
    bigQueryConnectionNoReadApi = DriverManager.getConnection(connection_uri, noReadApi);
    bigQueryStatementNoReadApi = bigQueryConnectionNoReadApi.createStatement();
    bigQuery = BigQueryOptions.newBuilder().build().getService();
  }

  @AfterAll
  public static void afterClass() throws SQLException {
    bigQueryStatement.close();
    bigQueryConnection.close();
    bigQueryStatementNoReadApi.close();
    bigQueryConnectionNoReadApi.close();
  }

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
    Assert.assertNotNull(resultSet);

    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
    resultSet.next();
    Assert.assertEquals(15, resultSetMetaData.getColumnCount());
    Assert.assertTrue(resultSet.getBoolean(1));
    Assert.assertEquals(33, resultSet.getInt(2));
    Assert.assertEquals(50.05f, resultSet.getFloat(3), 0.0);
    Assert.assertEquals(123.456, resultSet.getDouble(4), 0.0);
    Assert.assertEquals(123.456789, resultSet.getDouble(5), 0.0);
    Assert.assertEquals("testString", resultSet.getString(6));
    Assert.assertEquals("Test String", new String(resultSet.getBytes(7), StandardCharsets.UTF_8));
    Assert.assertEquals(Timestamp.valueOf("2020-04-27 18:07:25.356"), resultSet.getObject(10));
    Assert.assertEquals(Timestamp.valueOf("2020-04-27 18:07:25.356"), resultSet.getTimestamp(10));
    Assert.assertEquals(Date.valueOf("2019-1-12"), resultSet.getObject(11));
    Assert.assertEquals(Date.valueOf("2019-1-12"), resultSet.getDate(11));
    Assert.assertEquals(Time.valueOf("14:00:00"), resultSet.getObject(12));
    Assert.assertEquals(Time.valueOf("14:00:00"), resultSet.getTime(12));
    Assert.assertEquals(Timestamp.valueOf("2022-01-22 22:22:12.142265"), resultSet.getObject(13));
    Assert.assertEquals("POINT(1 2)", resultSet.getString(14));
    Assert.assertEquals(
        "{\"class\":{\"students\":[{\"name\":\"Jane\"}]}}", resultSet.getString(15));
    connection.close();
    connection.close();
  }

  @Test
  public void testFastQueryPathSmall() throws SQLException {
    String query =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT"
            + " 850";
    ResultSet jsonResultSet = bigQueryStatement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    assertEquals(850, resultSetRowCount(jsonResultSet));
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
    Assert.assertEquals(0, resultSetRowCount(jsonResultSet));
    connection.close();
  }

  @Test
  public void testSmallSelectAndVerifyResults() throws SQLException {
    String query =
        "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` WHERE"
            + " repository_name LIKE 'X%' LIMIT 10";

    ResultSet resultSet = bigQueryStatement.executeQuery(query);
    int rowCount = 0;
    while (resultSet.next()) {
      assertTrue(resultSet.getString(1).startsWith("X"));
      rowCount++;
    }
    assertEquals(10, rowCount);
  }

  @Test
  // reads without using ReadAPI and makes sure that they are in order, which implies threads worked
  // correctly
  public void testIterateOrderJsonMultiThread_NoReadApi() throws SQLException {
    int expectedCnt = 10000;
    String query = String.format(BASE_QUERY, expectedCnt);
    ResultSet rs = bigQueryStatementNoReadApi.executeQuery(query);
    int cnt = 0;
    double oldTriDis = 0.0d;
    while (rs.next()) {
      double tripDis = rs.getDouble("trip_distance");
      ++cnt;
      assertTrue(oldTriDis <= tripDis);
      oldTriDis = tripDis;
    }
    assertEquals(expectedCnt, cnt); // all the records were retrieved
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
      Assert.assertTrue(oldTriDis <= tripDis);
      oldTriDis = tripDis;
    }
    Assert.assertEquals(expectedCnt, cnt); // all the records were retrieved
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
    Assert.assertEquals(expectedCnt, resultSetRowCount(arrowResultSet));
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
    Assert.assertEquals(expectedCnt, resultSetRowCount(arrowResultSet));
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
    Assert.assertEquals(expectedCnt, resultSetRowCount(arrowResultSet));
    arrowResultSet.close();
    connection.close();
  }

  @Test
  public void testStatelessQueryPathSmall() throws SQLException {
    Properties jobCreationMode = new Properties();
    jobCreationMode.setProperty("JobCreationMode", "2");
    Connection connectionUseStateless =
        DriverManager.getConnection(ITBase.connectionUrl, jobCreationMode);

    Statement statement = connectionUseStateless.createStatement();

    String query =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT"
            + " 850";
    ResultSet jsonResultSet = statement.executeQuery(query);
    Assert.assertEquals(850, resultSetRowCount(jsonResultSet));

    String queryEmpty =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT"
            + " 0";
    ResultSet jsonResultSetEmpty = statement.executeQuery(queryEmpty);
    Assert.assertEquals(0, resultSetRowCount(jsonResultSetEmpty));
    connectionUseStateless.close();
  }

  @Test
  public void testInvalidQuery() throws SQLException {
    String query = "SELECT *";

    try {
      bigQueryStatement.executeQuery(query);
      Assertions.fail();
    } catch (BigQueryJdbcException e) {
      assertTrue(e.getCause().getMessage().contains("SELECT * must have a FROM clause"));
    }
  }

  @Test
  public void testDriver() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=3";

    Driver driver = BigQueryDriver.getRegisteredDriver();
    assertTrue(driver.acceptsURL(connection_uri));

    Connection connection = driver.connect(connection_uri, new Properties());
    assertNotNull(connection);
    Statement st = connection.createStatement();
    boolean rs =
        st.execute("Select * FROM `bigquery-public-data.samples.github_timeline` LIMIT 180");
    assertTrue(rs);
    connection.close();
  }

  @Test
  public void testDefaultDataset() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=3;DEFAULTDATASET=testDataset";

    Driver driver = BigQueryDriver.getRegisteredDriver();
    assertTrue(driver.acceptsURL(connection_uri));

    Connection connection = driver.connect(connection_uri, new Properties());
    assertNotNull(connection);
    assertEquals(
        DatasetId.of("testDataset"), ((BigQueryConnection) connection).getDefaultDataset());

    String connection_uri_null_default_dataset =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=3";

    assertTrue(driver.acceptsURL(connection_uri_null_default_dataset));

    Connection connection2 = driver.connect(connection_uri_null_default_dataset, new Properties());
    assertNotNull(connection2);
    assertNull(((BigQueryConnection) connection2).getDefaultDataset());
    connection.close();
    connection2.close();
  }

  @Test
  public void testDefaultDatasetWithProject() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=3;DEFAULTDATASET="
            + PROJECT_ID
            + ".testDataset";

    Driver driver = BigQueryDriver.getRegisteredDriver();
    assertTrue(driver.acceptsURL(connection_uri));

    Connection connection = driver.connect(connection_uri, new Properties());
    assertNotNull(connection);
    assertEquals(
        DatasetId.of(PROJECT_ID, "testDataset"),
        ((BigQueryConnection) connection).getDefaultDataset());
    connection.close();
  }

  @Test
  public void testLocation() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=3;LOCATION=EU";

    Driver driver = BigQueryDriver.getRegisteredDriver();
    assertTrue(driver.acceptsURL(connection_uri));

    Connection connection = driver.connect(connection_uri, new Properties());
    assertEquals(((BigQueryConnection) connection).getLocation(), "EU");

    Statement statement = connection.createStatement();

    // Query a dataset in the EU
    String query =
        "SELECT name FROM `bigquery-public-data.covid19_italy_eu.data_by_province` LIMIT 100";
    ResultSet resultSet = statement.executeQuery(query);
    assertEquals(100, resultSetRowCount(resultSet));

    String connection_uri_null_location =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=3";

    assertTrue(driver.acceptsURL(connection_uri_null_location));

    Connection connection2 = driver.connect(connection_uri_null_location, new Properties());
    assertNotNull(connection2);
    assertNull(((BigQueryConnection) connection2).getLocation());
    connection.close();
    connection2.close();
  }

  @Test
  public void testIncorrectLocation() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=3;LOCATION=europe-west3";

    Driver driver = BigQueryDriver.getRegisteredDriver();

    Connection connection = driver.connect(connection_uri, new Properties());
    assertEquals(((BigQueryConnection) connection).getLocation(), "europe-west3");

    // Query a dataset in the US
    Statement statement = connection.createStatement();
    String query = "SELECT * FROM `bigquery-public-data.samples.github_timeline` LIMIT 180";
    BigQueryJdbcException ex =
        assertThrows(BigQueryJdbcException.class, () -> statement.executeQuery(query));
    BigQueryError error = ex.getBigQueryException().getError();
    assertNotNull(error);
    assertEquals("accessDenied", error.getReason());
    connection.close();
  }

  @Test
  public void testCreateStatementWithResultSetHoldabilityUnsupportedTypeForwardOnly() {
    assertThrows(
        BigQueryJdbcSqlFeatureNotSupportedException.class,
        () -> bigQueryConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY, 1, 1));
  }

  @Test
  public void testCreateStatementWithResultSetHoldabilityUnsupportedConcurReadOnly() {
    assertThrows(
        BigQueryJdbcSqlFeatureNotSupportedException.class,
        () -> bigQueryConnection.createStatement(1, ResultSet.CONCUR_READ_ONLY, 1));
  }

  @Test
  public void testCreateStatementWithResultSetHoldabilityUnsupportedCloseCursorsAtCommit() {
    assertThrows(
        BigQueryJdbcSqlFeatureNotSupportedException.class,
        () -> bigQueryConnection.createStatement(1, 1, ResultSet.CLOSE_CURSORS_AT_COMMIT));
  }

  @Test
  public void testCreateStatementWithResultSetConcurrencyUnsupportedTypeForwardOnly() {
    assertThrows(
        BigQueryJdbcSqlFeatureNotSupportedException.class,
        () -> bigQueryConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY, 1));
  }

  @Test
  public void testCreateStatementWithResultSetConcurrencyUnsupportedConcurReadOnly() {
    assertThrows(
        BigQueryJdbcSqlFeatureNotSupportedException.class,
        () -> bigQueryConnection.createStatement(1, ResultSet.CONCUR_READ_ONLY));
  }

  @Test
  public void testSetTransactionIsolationToNotSerializableThrowsNotSupported() {
    assertThrows(
        BigQueryJdbcSqlFeatureNotSupportedException.class,
        () -> bigQueryConnection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE + 1));
  }

  @Test
  public void testSetHoldabilityForNonCloseCursorsThrowsNotSupported() throws SQLException {
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());

    assertThrows(
        BigQueryJdbcSqlFeatureNotSupportedException.class,
        () -> connection.setHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT + 1));
    connection.close();
  }

  @Test
  public void testCreateStatementWhenConnectionClosedThrows() throws SQLException {
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());

    connection.close();
    assertThrows(IllegalStateException.class, connection::createStatement);
  }

  @Test
  public void testCreateStatementWithResultSetHoldabilityWhenConnectionClosedThrows()
      throws SQLException {
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());

    connection.close();
    assertThrows(IllegalStateException.class, () -> connection.createStatement(1, 1, 1));
  }

  @Test
  public void testCreateStatementWithResultSetConcurrencyWhenConnectionClosedThrows()
      throws SQLException {
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());

    connection.close();
    assertThrows(IllegalStateException.class, () -> connection.createStatement(1, 1));
  }

  @Test
  public void testSetAutoCommitWithClosedConnectionThrowsIllegalState() throws SQLException {
    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(session_enabled_connection_uri);
    connection.close();
    assertThrows(IllegalStateException.class, () -> connection.setAutoCommit(true));
  }

  @Test
  public void testSetCommitToFalseWithoutSessionEnabledThrowsIllegalState() throws SQLException {
    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(connection_uri);
    assertThrows(IllegalStateException.class, () -> connection.setAutoCommit(false));
    connection.close();
  }

  @Test
  public void testCommitWithConnectionClosedThrowsIllegalState() throws SQLException {
    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(session_enabled_connection_uri);
    connection.close();
    assertThrows(IllegalStateException.class, connection::commit);
  }

  @Test
  public void testCommitToFalseWithoutSessionEnabledThrowsIllegalState() throws SQLException {
    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(connection_uri);
    assertThrows(IllegalStateException.class, connection::commit);
    connection.close();
  }

  @Test
  public void testCommitWithNoTransactionStartedThrowsIllegalState() throws SQLException {
    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(session_enabled_connection_uri);
    assertThrows(IllegalStateException.class, connection::commit);
    connection.close();
  }

  @Test
  public void testRollbackOnConnectionClosed() throws SQLException {
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE1" + random.nextInt(99);
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
    Assert.assertFalse(status);
    int rows = statement.executeUpdate(updateQuery);
    Assert.assertEquals(1, rows);
    status = statement.execute(selectQuery);
    Assert.assertTrue(status);
    connection.close();

    // Separate query to check if transaction rollback worked
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    Assert.assertFalse(resultSet.next());

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TRANSACTION_TABLE));
    connection.close();
  }

  @Test
  public void testRollbackWithConnectionClosedThrowsIllegalState() throws SQLException {
    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(session_enabled_connection_uri);
    connection.close();
    assertThrows(IllegalStateException.class, connection::rollback);
  }

  @Test
  public void testRollbackToFalseWithoutSessionEnabledThrowsIllegalState() throws SQLException {
    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(connection_uri);
    assertThrows(IllegalStateException.class, connection::rollback);
    connection.close();
  }

  @Test
  public void testRollbackWithoutTransactionStartedThrowsIllegalState() throws SQLException {
    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(session_enabled_connection_uri);
    assertThrows(IllegalStateException.class, connection::rollback);
    connection.close();
  }

  @Test
  public void testMultiStatementTransactionRollbackByUser() throws SQLException {
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE3" + random.nextInt(99);
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
    Assert.assertFalse(status);
    int rows = statement.executeUpdate(updateQuery);
    Assert.assertEquals(1, rows);
    status = statement.execute(selectQuery);
    Assert.assertTrue(status);
    connection.rollback();

    // Separate query to check if transaction rollback worked
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    Assert.assertFalse(resultSet.next());

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TRANSACTION_TABLE));
    connection.close();
  }

  @Test
  public void testSingleStatementTransaction() throws SQLException {
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE2" + random.nextInt(99);
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
        Assert.assertTrue(result.next());
        Assert.assertEquals(-1, statement.getUpdateCount());
      } else {
        Assert.assertTrue(statement.getUpdateCount() > -1);
      }
      hasMoreResult = statement.getMoreResults();
      resultsCount++;
    }

    // Check the transaction was actually committed.
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    int rowCount = 0;
    while (resultSet.next()) {
      rowCount++;
      Assert.assertEquals(14, resultSet.getInt(3));
    }
    Assert.assertEquals(2, rowCount);

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TRANSACTION_TABLE));
    connection.close();
  }

  @Test
  public void testGetLocationWhenConnectionClosedThrows() throws SQLException {
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());

    connection.close();
    assertThrows(
        IllegalStateException.class, () -> ((BigQueryConnection) connection).getLocation());
    connection.close();
  }

  @Test
  public void testGetDefaultDatasetWhenConnectionClosedThrows() throws SQLException {
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());

    connection.close();
    assertThrows(
        IllegalStateException.class, () -> ((BigQueryConnection) connection).getDefaultDataset());
  }

  @Test
  public void testGetAutocommitWhenConnectionClosedThrows() throws SQLException {
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());

    connection.close();
    assertThrows(IllegalStateException.class, connection::getAutoCommit);
  }

  @Test
  public void testSetAutocommitWhenConnectionClosedThrows() throws SQLException {
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());

    connection.close();
    assertThrows(IllegalStateException.class, () -> connection.setAutoCommit(true));
  }

  @Test
  public void testMultiStatementTransactionDoesNotCommitWithoutCommit() throws SQLException {
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE4" + random.nextInt(99);
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
    Assert.assertFalse(status);
    int rows = statement.executeUpdate(updateQuery);
    Assert.assertEquals(1, rows);
    status = statement.execute(selectQuery);
    Assert.assertTrue(status);

    // Separate query to check nothing committed
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    Assert.assertFalse(resultSet.next());

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TRANSACTION_TABLE));
    statement.close();
    connection.close();
  }

  @Test
  public void testValidMultiStatementTransactionCommits() throws SQLException {
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE5" + random.nextInt(99);
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
    Assert.assertFalse(status);
    status = statement.execute(updateQuery);
    Assert.assertFalse(status);
    status = statement.execute(selectQuery);
    Assert.assertTrue(status);
    connection.commit();

    // Separate query to check inserted and updated data committed
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    Assert.assertTrue(resultSet.next());
    Assert.assertEquals(14, resultSet.getInt(3));

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TRANSACTION_TABLE));
    statement.close();
    connection.close();
  }

  @Test
  public void testTransactionRollbackOnError() throws SQLException {
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE6" + random.nextInt(99);
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
    Assert.assertFalse(resultSet.next());

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TRANSACTION_TABLE));
    connection.close();
    connection1.close();
  }

  @Test
  public void testExecuteUpdate() throws SQLException {
    String TABLE_NAME = "JDBC_EXECUTE_UPDATE_TABLE_" + randomNumber;
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
  }

  @Test
  public void testExecuteQueryWithInsert() throws SQLException {
    String TABLE_NAME = "JDBC_EXECUTE_UPDATE_TABLE_" + randomNumber;
    String createQuery =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`StringField` STRING, `IntegerField` INTEGER);",
            DATASET, TABLE_NAME);
    String dropQuery = String.format("DROP TABLE %s.%s", DATASET, TABLE_NAME);

    assertEquals(0, bigQueryStatement.executeUpdate(createQuery));
    assertThrows(BigQueryJdbcException.class, () -> bigQueryStatement.executeQuery(dropQuery));
    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TABLE_NAME));
  }

  @Test
  public void testExecuteQueryWithMultipleReturns() throws SQLException {
    String query =
        String.format("SELECT * FROM bigquery-public-data.samples.github_timeline LIMIT 1;");

    assertThrows(BigQueryJdbcException.class, () -> bigQueryStatement.executeQuery(query + query));
  }

  @Test
  public void testExecuteUpdateWithSelect() throws SQLException {
    String selectQuery =
        String.format("SELECT * FROM bigquery-public-data.samples.github_timeline LIMIT 1;");

    assertThrows(BigQueryJdbcException.class, () -> bigQueryStatement.executeUpdate(selectQuery));
  }

  @Test
  public void testExecuteMethod() throws SQLException {

    String TABLE_NAME = "JDBC_EXECUTE_TABLE_" + randomNumber;
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
  }

  @Test
  public void testPreparedExecuteMethod() throws SQLException {

    String TABLE_NAME = "JDBC_PREPARED_EXECUTE_TABLE_" + randomNumber;
    String createQuery =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`StringField` STRING, `IntegerField` INTEGER);",
            DATASET, TABLE_NAME);
    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (StringField, IntegerField) VALUES (?,?), (?,?), (?,?), (?,?);",
            DATASET, TABLE_NAME);
    String updateQuery =
        String.format("UPDATE %s.%s SET StringField=? WHERE IntegerField=?", DATASET, TABLE_NAME);
    String dropQuery = String.format("DROP TABLE %s.%s", DATASET, TABLE_NAME);
    String selectQuery = String.format("SELECT ? FROM %s.%s", DATASET, TABLE_NAME);

    boolean createStatus = bigQueryStatement.execute(createQuery);
    assertFalse(createStatus);

    PreparedStatement insertStmt = bigQueryConnection.prepareStatement(insertQuery);
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

    PreparedStatement selectStmt = bigQueryConnection.prepareStatement(selectQuery);
    selectStmt.setString(1, "StringField");
    boolean selectStatus = selectStmt.execute();
    assertTrue(selectStatus);

    int selectCount = selectStmt.getUpdateCount();
    assertEquals(-1, selectCount);
    ResultSet resultSet = selectStmt.getResultSet();
    assertNotNull(resultSet);

    PreparedStatement updateStmt = bigQueryConnection.prepareStatement(updateQuery);
    updateStmt.setString(1, "Jane Doe");
    updateStmt.setInt(2, 222);
    boolean updateStatus = updateStmt.execute();
    assertFalse(updateStatus);

    boolean dropStatus = bigQueryStatement.execute(dropQuery);
    assertFalse(dropStatus);
  }

  @Test
  public void testPreparedStatementThrowsSyntaxError() throws SQLException {
    String TABLE_NAME = "JDBC_PREPARED_SYNTAX_ERR_TABLE_" + randomNumber;
    String createQuery =
        String.format("CREATE OR REPLACE TABLE %s.%s (? STRING, ? INTEGER);", DATASET, TABLE_NAME);

    PreparedStatement preparedStatement = bigQueryConnection.prepareStatement(createQuery);
    preparedStatement.setString(1, "StringField");
    preparedStatement.setString(2, "IntegerField");
    assertThrows(BigQueryJdbcSqlSyntaxErrorException.class, preparedStatement::execute);

    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TABLE_NAME));
  }

  @Test
  public void testPreparedStatementThrowsJdbcException() throws SQLException {
    String TABLE_NAME = "JDBC_PREPARED_MISSING_PARAM_TABLE_" + randomNumber;
    String createQuery =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (StringField STRING, IntegerField INTEGER);",
            DATASET, TABLE_NAME);
    boolean createStatus = bigQueryStatement.execute(createQuery);
    assertFalse(createStatus);

    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (StringField, IntegerField) " + "VALUES (?,?), (?,?);",
            DATASET, TABLE_NAME);
    PreparedStatement insertStmt = bigQueryConnection.prepareStatement(insertQuery);
    insertStmt.setString(1, "String1");
    insertStmt.setInt(2, 111);
    assertThrows(BigQueryJdbcException.class, insertStmt::execute);

    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TABLE_NAME));
  }

  @Test
  public void testSetFetchDirectionFetchReverseThrowsUnsupported() {
    assertThrows(
        BigQueryJdbcSqlFeatureNotSupportedException.class,
        () -> bigQueryStatement.setFetchDirection(ResultSet.FETCH_REVERSE));
  }

  @Test
  public void testSetFetchDirectionFetchUnknownThrowsUnsupported() {
    assertThrows(
        BigQueryJdbcSqlFeatureNotSupportedException.class,
        () -> bigQueryStatement.setFetchDirection(ResultSet.FETCH_UNKNOWN));
  }

  @Test
  public void testExecuteBatchQueryTypeSelectThrowsUnsupported() throws SQLException {
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    String query =
        "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` WHERE"
            + " repository_name LIKE 'X%' LIMIT 10";
    Statement statement = connection.createStatement();

    assertThrows(IllegalArgumentException.class, () -> statement.addBatch(query));
    connection.close();
  }

  @Test
  public void testValidExecuteBatch() throws SQLException {
    // setup
    String BATCH_TABLE = "JDBC_EXECUTE_BATCH_TABLE_" + random.nextInt(99);
    String createBatchTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, BATCH_TABLE);
    bigQueryStatement.execute(createBatchTable);
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

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
    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, BATCH_TABLE));
    connection.close();
  }

  @Test
  public void testAddBatchWithoutSemicolon() throws SQLException {
    // setup
    String BATCH_TABLE = "JDBC_EXECUTE_BATCH_TABLE_MISSING_SEMICOLON_" + random.nextInt(99);
    String createBatchTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, BATCH_TABLE);
    bigQueryStatement.execute(createBatchTable);
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

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
    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, BATCH_TABLE));
    connection.close();
  }

  @Test
  public void testEmptySqlToAddBatch() throws SQLException {
    // setup
    String BATCH_TABLE = "JDBC_EMPTY_EXECUTE_BATCH_TABLE_" + random.nextInt(99);
    String createBatchTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, BATCH_TABLE);
    bigQueryStatement.execute(createBatchTable);
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    // batch bypasses the 16 concurrent limit
    String emptySql = "";
    statement.addBatch(emptySql);
    int[] results = statement.executeBatch();

    // assertions
    assertEquals(0, results.length);
    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, BATCH_TABLE));
    connection.close();
  }

  @Test
  public void testEmptyExecuteBatch() throws SQLException {
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();
    int[] result = statement.executeBatch();

    assertEquals(0, result.length);
    connection.close();
  }

  @Test
  public void testNonValidStatementTypeForAddBatchThrows() {
    String BATCH_TABLE = "JDBC_EXECUTE_BATCH_TABLE_NON_VALID_TYPE_" + random.nextInt(99);
    String createBatchTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, BATCH_TABLE);
    assertThrows(
        IllegalArgumentException.class, () -> bigQueryStatement.addBatch(createBatchTable));
  }

  @Test
  public void testAllValidStatementTypesForAddBatch() throws SQLException {
    // setup
    String BATCH_TABLE = "JDBC_EXECUTE_BATCH_TABLE_ALL_VALID_TYPES_" + random.nextInt(99);
    String createBatchTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, BATCH_TABLE);
    bigQueryStatement.execute(createBatchTable);
    String insertQuery =
        "INSERT INTO "
            + DATASET
            + "."
            + BATCH_TABLE
            + " (id, name, age) "
            + "VALUES (12, 'Farhan', "
            + randomNumber
            + "); ";
    String updateQuery =
        String.format(
            "UPDATE %s.%s SET age = 13 WHERE age = %s;", DATASET, BATCH_TABLE, randomNumber);
    String deleteQuery =
        String.format("DELETE FROM %s.%s WHERE name='Farhan';", DATASET, BATCH_TABLE);
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    statement.addBatch(insertQuery);
    statement.addBatch(updateQuery);
    statement.addBatch(deleteQuery);
    int[] results = statement.executeBatch();

    // assertion
    for (int updateCount : results) {
      assertEquals(1, updateCount);
    }
    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, BATCH_TABLE));
    connection.close();
  }

  @Test
  public void testUnsupportedHTAPIFallbacksToStandardQueriesWithRange() throws SQLException {
    String selectQuery = "select * from `DATATYPERANGETEST.RangeIntervalTestTable` LIMIT 5000;";
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;ProjectId="
            + PROJECT_ID
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
  }

  @Test
  public void testIntervalDataTypeWithArrowResultSet() throws SQLException {
    String selectQuery =
        "select * from `DATATYPERANGETEST.RangeIntervalTestTable` order by intColumn limit 5000;";
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;ProjectId="
            + PROJECT_ID
            + ";MaxResults=500;HighThroughputActivationRatio=1;"
            + "HighThroughputMinTableSize=100;"
            + "EnableHighThroughputAPI=1;JobCreationMode=1;";

    // Read data via JDBC
    Connection connection = DriverManager.getConnection(connection_uri);
    Statement statement = connection.createStatement();

    ResultSet resultSet = statement.executeQuery(selectQuery);
    assertTrue(resultSet.getClass().getName().contains("BigQueryArrowResultSet"));
    resultSet.next();
    assertEquals("0-0 10 -12:30:0.0", resultSet.getString("intervalField"));

    // cleanup
    connection.close();
  }

  @Test
  public void testIntervalDataTypeWithJsonResultSet() throws SQLException {
    String selectQuery =
        "select * from `DATATYPERANGETEST.RangeIntervalTestTable` order by intColumn limit 10 ;";
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;ProjectId="
            + PROJECT_ID
            + ";MaxResults=500;HighThroughputActivationRatio=1;"
            + "HighThroughputMinTableSize=100;"
            + "EnableHighThroughputAPI=0;JobCreationMode=1;";

    // Read data via JDBC
    Connection connection = DriverManager.getConnection(connection_uri);
    Statement statement = connection.createStatement();

    ResultSet resultSet = statement.executeQuery(selectQuery);
    assertTrue(resultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    resultSet.next();
    assertEquals("0-0 10 -12:30:0", resultSet.getString("intervalField"));

    // cleanup
    connection.close();
  }

  @Test
  public void testValidLEPEndpointQuery() throws SQLException {
    String DATASET = "JDBC_REGIONAL_DATASET";
    String TABLE_NAME = "REGIONAL_TABLE";
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME;
    String connection_uri =
        "jdbc:bigquery://https://googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";"
            + "EndpointOverrides=BIGQUERY=https://us-east4-bigquery.googleapis.com;";

    // Read data via JDBC
    Connection connection = DriverManager.getConnection(connection_uri);
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(selectQuery);
    assertNotNull(resultSet.getMetaData());
    connection.close();
  }

  @Test
  public void testValidEndpointWithInvalidBQPortThrows() throws SQLException {
    String TABLE_NAME = "JDBC_REGIONAL_TABLE_" + randomNumber;
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME;
    String connection_uri =
        "jdbc:bigquery://https://googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";"
            + "EndpointOverrides=BIGQUERY=https://us-east4-bigquery.googleapis.com:12312312;";

    // Read data via JDBC
    Connection connection = DriverManager.getConnection(connection_uri);
    Statement statement = connection.createStatement();
    assertThrows(BigQueryJdbcException.class, () -> statement.executeQuery(selectQuery));
    connection.close();
  }

  @Test
  public void testLEPEndpointDataNotFoundThrows() throws SQLException {
    String DATASET = "JDBC_REGIONAL_DATASET";
    String TABLE_NAME = "REGIONAL_TABLE";
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME;
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";"
            + "EndpointOverrides=BIGQUERY=https://us-east5-bigquery.googleapis.com;";

    // Attempting read data via JDBC
    Connection connection = DriverManager.getConnection(connection_uri);
    Statement statement = connection.createStatement();
    assertThrows(BigQueryJdbcException.class, () -> statement.executeQuery(selectQuery));
    connection.close();
  }

  @Test
  public void testValidREPEndpointQuery() throws SQLException {
    String DATASET = "JDBC_REGIONAL_DATASET";
    String TABLE_NAME = "REGIONAL_TABLE";
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME;
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";"
            + "EndpointOverrides=BIGQUERY=https://bigquery.us-east4.rep.googleapis.com;";

    // Read data via JDBC
    Connection connection = DriverManager.getConnection(connection_uri);
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(selectQuery);
    assertNotNull(resultSet.getMetaData());
    connection.close();
  }

  @Test
  public void testREPEndpointDataNotFoundThrows() throws SQLException {
    String DATASET = "JDBC_REGIONAL_DATASET";
    String TABLE_NAME = "REGIONAL_TABLE";
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME;
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";"
            + "EndpointOverrides=BIGQUERY=https://bigquery.us-east7.rep.googleapis.com;";

    // Attempting read data via JDBC
    Connection connection = DriverManager.getConnection(connection_uri);
    Statement statement = connection.createStatement();
    assertThrows(BigQueryJdbcException.class, () -> statement.executeQuery(selectQuery));
    connection.close();
  }

  @Test
  public void testCloseStatement() throws SQLException {
    String query = "SELECT * FROM `bigquery-public-data.samples.github_timeline` LIMIT 10";
    Statement statement = bigQueryConnection.createStatement();
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertEquals(10, resultSetRowCount(jsonResultSet));
    statement.close();
    assertTrue(statement.isClosed());
  }

  @Test
  public void testCloseableStatementSingleResult() throws SQLException {
    String query = "SELECT * FROM `bigquery-public-data.samples.github_timeline` LIMIT 10";
    Statement statement = bigQueryConnection.createStatement();
    statement.closeOnCompletion();
    assertTrue(statement.isCloseOnCompletion());
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertFalse(statement.isClosed());
    jsonResultSet.close();
    assertTrue(statement.isClosed());
  }

  @Test
  public void testCloseableStatementMultiResult() throws SQLException {
    String query = "SELECT * FROM `bigquery-public-data.samples.github_timeline` LIMIT 10;";
    Statement statement = bigQueryConnection.createStatement();
    statement.closeOnCompletion();
    assertTrue(statement.isCloseOnCompletion());
    statement.execute(query + query);
    assertNotNull(statement.getResultSet());
    assertFalse(statement.isClosed());

    assertTrue(statement.getMoreResults());
    assertNotNull(statement.getResultSet());
    assertFalse(statement.isClosed());

    assertFalse(statement.getMoreResults());
    assertTrue(statement.isClosed());
  }

  @Test
  public void testCloseableStatementMultiResultExplicitClose() throws SQLException {
    String query = "SELECT * FROM `bigquery-public-data.samples.github_timeline` LIMIT 10;";
    Statement statement = bigQueryConnection.createStatement();
    statement.closeOnCompletion();
    assertTrue(statement.isCloseOnCompletion());
    statement.execute(query + query);
    ResultSet result = statement.getResultSet();
    result.close();
    assertFalse(statement.isClosed());

    assertTrue(statement.getMoreResults());
    result = statement.getResultSet();
    result.close();
    assertTrue(statement.isClosed());
  }

  @Test
  public void testConnectionIsValid() throws SQLException {
    assertTrue(bigQueryConnection.isValid(10));
    assertTrue(bigQueryConnectionNoReadApi.isValid(10));
  }

  @Test
  public void testDataSource() throws SQLException {
    DataSource ds = new DataSource();
    ds.setURL("jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;");
    ds.setOAuthType(3);

    try (Connection connection = ds.getConnection()) {
      assertFalse(connection.isClosed());
    }
  }

  @Test
  public void testDataSourceOAuthPvtKeyPath() throws SQLException, IOException {
    File tempFile = File.createTempFile("auth", ".json");
    tempFile.deleteOnExit();
    DataSource ds = new DataSource();
    ds.setURL("jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;");
    ds.setOAuthType(0);
    ds.setOAuthPvtKeyPath(tempFile.toPath().toString());
    assertEquals(0, ds.getOAuthType().intValue());
    assertEquals(tempFile.toPath().toString(), ds.getOAuthPvtKeyPath());
  }

  @Test
  public void testPreparedStatementSmallSelect() throws SQLException {
    String query =
        "SELECT * FROM `bigquery-public-data.samples.github_timeline` where repository_language=?"
            + " LIMIT 1000";
    PreparedStatement preparedStatement = bigQueryConnection.prepareStatement(query);
    preparedStatement.setString(1, "Java");

    ResultSet jsonResultSet = preparedStatement.executeQuery();

    int rowCount = resultSetRowCount(jsonResultSet);
    assertEquals(1000, rowCount);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
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

    bigQueryStatement.execute(createQuery);
    bigQueryStatement.execute(createQuery2);
    bigQueryStatement.execute(insertQuery2);

    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (product, quantity) " + "VALUES (?,? ), (?,? );",
            DATASET, TABLE_NAME1);
    PreparedStatement insertPs = bigQueryConnection.prepareStatement(insertQuery);
    insertPs.setString(1, "dishwasher");
    insertPs.setInt(2, 30);
    insertPs.setString(3, "dryer");
    insertPs.setInt(4, 30);

    int insertStatus = insertPs.executeUpdate();
    assertEquals(2, insertStatus);

    String updateQuery =
        String.format("UPDATE %s.%s SET quantity=? WHERE product=?", DATASET, TABLE_NAME1);
    PreparedStatement updatePs = bigQueryConnection.prepareStatement(updateQuery);
    updatePs.setString(2, "dryer");
    updatePs.setInt(1, 35);

    int updateStatus = updatePs.executeUpdate();
    assertEquals(1, updateStatus);

    String deleteQuery = String.format("DELETE FROM %s.%s WHERE product=?", DATASET, TABLE_NAME1);
    PreparedStatement deletePs = bigQueryConnection.prepareStatement(deleteQuery);
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
    PreparedStatement mergePs = bigQueryConnection.prepareStatement(mergeQuery);
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
  }

  @Test
  public void testPreparedStatementDateTimeValues() throws SQLException {
    Random random = new Random();
    String DATASET = "JDBC_INTEGRATION_DATASET";
    String TABLE_NAME1 = "DateTimeTestTable" + random.nextInt(9999);

    final String createTableQuery =
        "CREATE OR REPLACE TABLE "
            + " `%s.%s` "
            + " (\n"
            + "`StringField` STRING,\n"
            + "`IntegerField` INTEGER,\n"
            + "`TimestampField` TIMESTAMP,\n"
            + "`TimeField` TIME,\n"
            + "`DateField` DATE\n"
            + ");";

    String insertQuery =
        String.format("INSERT INTO %s.%s VALUES (?,?,?,?,? );", DATASET, TABLE_NAME1);

    bigQueryStatement.execute(String.format(createTableQuery, DATASET, TABLE_NAME1));

    PreparedStatement insertPs = bigQueryConnection.prepareStatement(insertQuery);
    insertPs.setString(1, "dishwasher");
    insertPs.setInt(2, 1);
    insertPs.setTimestamp(3, Timestamp.from(Instant.now()));
    insertPs.setTime(4, Time.valueOf(LocalTime.NOON));
    insertPs.setDate(5, Date.valueOf("2025-12-3"));

    int insertStatus = insertPs.executeUpdate();
    assertEquals(1, insertStatus);

    ResultSet rs =
        bigQueryStatement.executeQuery(
            String.format("SELECT COUNT(*) AS row_count\n" + "FROM %s.%s", DATASET, TABLE_NAME1));
    rs.next();
    assertEquals(1, rs.getInt(1));

    String dropQuery = String.format("DROP TABLE %s.%s", DATASET, TABLE_NAME1);
    int dropStatus = bigQueryStatement.executeUpdate(dropQuery);
    assertEquals(0, dropStatus);
  }

  @Test
  public void testValidDestinationTableSavesQueriesWithLegacySQL() throws SQLException {
    // setup
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";QueryDialect=BIG_QUERY;"
            + "AllowLargeResults=1;"
            + "LargeResultTable=destination_table_test_legacy;"
            + "LargeResultDataset=INTEGRATION_TESTS;";
    String selectLegacyQuery =
        "SELECT * FROM [bigquery-public-data.deepmind_alphafold.metadata] LIMIT 200;";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    ResultSet resultSet = statement.executeQuery(selectLegacyQuery);

    // assertion
    assertNotNull(resultSet);
    String selectQuery = "SELECT * FROM `INTEGRATION_TESTS.destination_table_test_legacy`;";
    ResultSet actualResultSet = bigQueryStatement.executeQuery(selectQuery);
    assertTrue(0 < resultSetRowCount(actualResultSet));

    // clean up
    String deleteRows = "DELETE FROM `INTEGRATION_TESTS.destination_table_test_legacy` WHERE 1=1;";
    bigQueryStatement.execute(deleteRows);
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
    Assert.assertThrows(SQLException.class, () -> statement.execute(selectLegacyQuery));
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
    Assert.assertNotNull(resultSet);
    connection.close();
  }

  @Test
  public void testValidDestinationTableSavesQueriesWithStandardSQL() throws SQLException {
    // setup
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";QueryDialect=SQL;"
            + "LargeResultTable=destination_table_test;"
            + "LargeResultDataset=INTEGRATION_TESTS;";
    String selectLegacyQuery =
        "SELECT * FROM `bigquery-public-data.deepmind_alphafold.metadata` LIMIT 200;";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    ResultSet resultSet = statement.executeQuery(selectLegacyQuery);

    // assertion
    assertNotNull(resultSet);
    String selectQuery = "SELECT * FROM INTEGRATION_TESTS.destination_table_test;";
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
            + PROJECT_ID
            + ";QueryDialect=BIG_QUERY;"
            + "AllowLargeResults=1;"
            + "LargeResultTable=FakeTable;"
            + "LargeResultDataset=FakeDataset;";
    String selectLegacyQuery =
        "SELECT * FROM [bigquery-public-data.deepmind_alphafold.metadata] LIMIT 200;";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    ResultSet resultSet = statement.executeQuery(selectLegacyQuery);

    // assertion
    assertNotNull(resultSet);
    String separateQuery = "SELECT * FROM FakeDataset.FakeTable;";
    boolean result = bigQueryStatement.execute(separateQuery);
    assertTrue(result);

    // clean up
    bigQueryStatement.execute("DROP SCHEMA FakeDataset CASCADE;");
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
    Assert.assertNotNull(resultSet);
    connection.close();
  }

  @Test
  public void testDestinationTableWithMissingDestinationDatasetDefaults() throws SQLException {
    // setup
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";QueryDialect=BIG_QUERY;"
            + "AllowLargeResults=1;"
            + "LargeResultTable=FakeTable;";
    String selectLegacyQuery =
        "SELECT * FROM [bigquery-public-data.deepmind_alphafold.metadata] LIMIT 200;";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    ResultSet resultSet = statement.executeQuery(selectLegacyQuery);

    // assertion
    assertNotNull(resultSet);
    String separateQuery = "SELECT * FROM _google_jdbc.FakeTable;";
    boolean result = bigQueryStatement.execute(separateQuery);
    assertTrue(result);
    connection.close();
  }

  @Test
  public void testNonSelectForLegacyDestinationTableThrows() throws SQLException {
    // setup
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE" + random.nextInt(99);
    String createTransactionTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, TRANSACTION_TABLE);
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";QueryDialect=BIG_QUERY;"
            + "AllowLargeResults=1;"
            + "LargeResultTable=destination_table_test;"
            + "LargeResultDataset=INTEGRATION_TESTS;";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act & assertion
    assertThrows(BigQueryJdbcException.class, () -> statement.execute(createTransactionTable));
    connection.close();
  }

  @Test
  public void testNonSelectForStandardDestinationTableDoesNotThrow() throws SQLException {
    // setup
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE" + random.nextInt(99);
    String createTransactionTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, TRANSACTION_TABLE);
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";QueryDialect=SQL;"
            + "AllowLargeResults=1;"
            + "LargeResultTable=destination_table_test;"
            + "LargeResultDataset=INTEGRATION_TESTS;";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act & assertion
    statement.execute(createTransactionTable);
    connection.close();
  }

  @Test
  public void testRangeDataTypeWithJsonResultSet() throws SQLException {
    String RANGE_DATA_TABLE = "JDBC_RANGE_DATA_TEST_TABLE_" + random.nextInt(99);
    String range_date_literal = "RANGE<DATE> '[2020-01-01, 2020-01-31)'";
    String range_datetime_literal = "RANGE<DATETIME> '[2020-01-01 12:00:00, 2020-01-31 12:00:00)'";
    String range_timestamp_literal =
        "RANGE<TIMESTAMP> '[2020-01-01 12:00:00+08, 2020-01-31 12:00:00+08)'";

    String createRangeTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `range_date` RANGE<DATE>,"
                + " `range_date_time` RANGE<DATETIME>, `range_timestamp` RANGE<TIMESTAMP>);",
            DATASET, RANGE_DATA_TABLE);
    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (id, range_date, range_date_time, range_timestamp) VALUES (1, %s,"
                + " %s, %s);",
            DATASET,
            RANGE_DATA_TABLE,
            range_date_literal,
            range_datetime_literal,
            range_timestamp_literal);
    String selectQuery =
        String.format(
            "SELECT id, range_date, range_date_time, range_timestamp FROM %s.%s WHERE id = 1;",
            DATASET, RANGE_DATA_TABLE);

    boolean status = bigQueryStatement.execute(createRangeTable);
    assertFalse(status);

    status = bigQueryStatement.execute(insertQuery);
    assertFalse(status);

    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);

    Integer numRows = 0;
    String actual_range_date = "";
    String actual_range_datetime = "";
    String actual_range_timestamp = "";

    while (resultSet.next()) {
      numRows++;
      actual_range_date = resultSet.getString("range_date");
      actual_range_datetime = resultSet.getString("range_date_time");
      actual_range_timestamp = resultSet.getString("range_timestamp");
    }

    String expected_range_date = "[2020-01-01, 2020-01-31)";
    String expected_range_datetime = "[2020-01-01T12:00:00, 2020-01-31T12:00:00)";
    String expected_range_timestamp = "[1577851200.000000, 1580443200.000000)";

    assertThat(numRows).isEqualTo(1);
    assertThat(actual_range_date).isEqualTo(expected_range_date);
    assertThat(actual_range_datetime).isEqualTo(expected_range_datetime);
    assertThat(actual_range_timestamp).isEqualTo(expected_range_timestamp);

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, RANGE_DATA_TABLE));
  }

  @Test
  public void testRangeDataTypeWithArrowResultSet() throws SQLException {
    String selectQuery =
        "select * from `DATATYPERANGETEST.RangeIntervalTestTable` order by intColumn limit 5000;";

    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;ProjectId="
            + PROJECT_ID
            + ";MaxResults=500;HighThroughputActivationRatio=1;"
            + "HighThroughputMinTableSize=100;"
            + "EnableHighThroughputAPI=1;JobCreationMode=1;";

    // Read data via JDBC
    Connection connection = DriverManager.getConnection(connection_uri);
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(selectQuery);
    assertTrue(resultSet.getClass().getName().contains("BigQueryArrowResultSet"));
    resultSet.next();
    assertEquals("[2024-07-14, 2024-09-23)", resultSet.getString("rangeField"));
    connection.close();
  }

  @Test
  public void testAlterTable() throws SQLException {
    String TABLE_NAME = "JDBC_ALTER_TABLE_" + randomNumber;
    String createQuery =
        String.format("CREATE OR REPLACE TABLE %s.%s (`StringField` STRING);", DATASET, TABLE_NAME);
    String addColumnQuery =
        String.format("ALTER TABLE %s.%s ADD COLUMN `IntegerField` INTEGER;", DATASET, TABLE_NAME);
    String dropColumnQuery =
        String.format(
            "UPDATE %s.%s SET StringField='Jane Doe' WHERE IntegerField=111", DATASET, TABLE_NAME);
    String dropQuery = String.format("DROP TABLE %s.%s", DATASET, TABLE_NAME);
    String selectQuery = String.format("SELECT * FROM %s.%s", DATASET, TABLE_NAME);

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
  }

  public void testQueryPropertyDataSetProjectIdQueriesToCorrectDataset() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";QueryProperties=dataset_project_id="
            + PROJECT_ID
            + ";";
    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (id, name, age) VALUES (15, 'Farhan', 25);",
            "INTEGRATION_TESTS", "Test_Table");
    String selectQuery =
        "SELECT * FROM `bigquery-devtools-drivers.INTEGRATION_TESTS.Test_Table` WHERE age=25;";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    statement.execute(insertQuery);

    // assertions
    boolean result = statement.execute(selectQuery);
    assertTrue(result);

    // clean up
    String deleteQuery =
        String.format("DELETE FROM %s.%s WHERE age=25", "INTEGRATION_TESTS", "Test_Table");
    statement.execute(deleteQuery);
    connection.close();
  }

  @Test
  public void testQueryPropertyDataSetProjectIdQueriesToIncorrectDatasetThrows()
      throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";QueryProperties=dataset_project_id=bigquerytestdefault"
            + ";";
    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (id, name, age) VALUES (15, 'Farhan', 25);",
            "INTEGRATION_TESTS", "Test_Table");
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act & assertion
    assertThrows(BigQueryJdbcException.class, () -> statement.execute(insertQuery));
    connection.close();
  }

  @Test
  public void testQueryPropertyTimeZoneQueries() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";QueryProperties=time_zone=America/New_York;";
    String query = "SELECT * FROM `bigquery-public-data.samples.github_timeline` LIMIT 180";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    ResultSet resultSet = statement.executeQuery(query);

    // assertions
    assertNotNull(resultSet);
    assertTrue(resultSet.next());
    connection.close();
  }

  @Test
  public void testQueryPropertySessionIdSetsStatementSession()
      throws SQLException, InterruptedException {
    String sessionId = getSessionId();
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";QueryProperties=session_id="
            + sessionId
            + ";";
    String selectQuery =
        "INSERT INTO `bigquery-devtools-drivers.JDBC_INTEGRATION_DATASET.No_KMS_Test_table` (id,"
            + " name, age) VALUES (132, 'Batman', 531);";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    boolean resultSet = statement.execute(selectQuery);

    // assertions
    assertFalse(resultSet);

    // clean up
    String deleteQuery =
        String.format("DELETE FROM %s.%s WHERE age=25", "INTEGRATION_TESTS", "Test_Table");
    statement.execute(deleteQuery);
    connection.close();
  }

  @Test
  public void testEncryptedTableWithKmsQueries() throws SQLException {
    // setup
    String KMSKeyName = requireEnvVar("KMS_RESOURCE_PATH");
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";KMSKeyName="
            + KMSKeyName
            + ";";
    String selectQuery = "SELECT * FROM `JDBC_INTEGRATION_DATASET.KMS_Test_table`;";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    ResultSet resultSet = statement.executeQuery(selectQuery);

    // assertions for data not encrypted
    assertNotNull(resultSet);
    assertTrue(resultSet.next());
    assertEquals("Farhan", resultSet.getString("name"));
    connection.close();
  }

  @Test
  public void testIncorrectKmsThrows() throws SQLException {
    String KMSKeyName = requireEnvVar("KMS_RESOURCE_PATH");
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";KMSKeyName="
            + KMSKeyName
            + ";";
    String selectQuery =
        "INSERT INTO `bigquery-devtools-drivers.JDBC_INTEGRATION_DATASET.No_KMS_Test_table` (id,"
            + " name, age) VALUES (132, 'Batman', 531);";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act & assertion
    assertThrows(BigQueryJdbcException.class, () -> statement.execute(selectQuery));
    connection.close();
  }

  @Test
  public void testQueryPropertyServiceAccountFollowsIamPermission() throws SQLException {
    final String SERVICE_ACCOUNT_EMAIL = requireEnvVar("SA_EMAIL");
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";QueryProperties=service_account="
            + SERVICE_ACCOUNT_EMAIL
            + ";";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    ResultSet resultSet = statement.executeQuery(String.format(BASE_QUERY, 100));

    // assertions
    assertNotNull(resultSet);
    assertTrue(resultSet.next());
    connection.close();
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
            + PROJECT_ID
            + ";QueryDialect=BIG_QUERY;";
    Connection connection = DriverManager.getConnection(connection_uri);
    Statement statement = connection.createStatement();

    boolean result = statement.execute(legacyJoinQuery);
    assertTrue(result);
    connection.close();
  }

  @Test
  public void testMultipleTransactionsThrowsUnsupported() throws SQLException {
    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(session_enabled_connection_uri);
    connection.setAutoCommit(false);
    Statement statement = connection.createStatement();
    assertThrows(BigQueryJdbcException.class, () -> statement.execute("BEGIN TRANSACTION;"));
    connection.close();
  }

  @Test
  public void testConnectionWithMultipleTransactionCommits() throws SQLException {
    String TRANSACTION_TABLE = "JDBC_MULTI_COMMIT_TABLE" + randomNumber;
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

    bigQueryStatement.execute(createTransactionTable);

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

    // Verify state with the static bigQueryStatement
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    int count = 0;
    while (resultSet.next()) {
      count++;
      assertEquals(14, resultSet.getInt("age"));
    }
    assertEquals(1, count); // Only first transaction should be committed.

    // Verify the second insert was rolled back
    ResultSet rs2 =
        bigQueryStatement.executeQuery(
            String.format("SELECT * FROM %s.%s WHERE id=15", DATASET, TRANSACTION_TABLE));
    assertFalse(rs2.next());

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %s.%s", DATASET, TRANSACTION_TABLE));

    statement.close();
    connection.close();
  }

  // Private Helper functions
  private String getSessionId() throws InterruptedException {
    QueryJobConfiguration stubJobConfig =
        QueryJobConfiguration.newBuilder("Select 1;").setCreateSession(true).build();
    Job job = bigQuery.create(JobInfo.of(stubJobConfig));
    job = job.waitFor();
    Job stubJob = bigQuery.getJob(job.getJobId());
    return stubJob.getStatistics().getSessionInfo().getSessionId();
  }

  @Test
  public void testExecuteScriptWithExpession() throws SQLException {
    int randomNum = random.nextInt(99);
    String query = String.format("DECLARE x INT64; SET x = (SELECT %s); SELECT x;", randomNum);

    assertTrue(bigQueryStatement.execute(query));
    ResultSet rs = bigQueryStatement.getResultSet();
    assertTrue(rs.next());
    assertEquals(randomNum, rs.getInt(1));
    assertFalse(rs.next());
    assertFalse(bigQueryStatement.getMoreResults());
    assertEquals(-1, bigQueryStatement.getUpdateCount());
  }

  @Test
  public void testExecuteSingleSelectMoreResultsBehavior() throws SQLException {
    String sql = "SELECT 1;";
    assertTrue(bigQueryStatement.execute(sql));
    ResultSet rs = bigQueryStatement.getResultSet();
    assertNotNull(rs);
    assertTrue(rs.next());
    assertEquals(1, rs.getInt(1));
    assertFalse(rs.next());

    // Validate no more results reset update count to -1
    assertFalse(bigQueryStatement.getMoreResults());
    assertEquals(-1, bigQueryStatement.getUpdateCount());
  }

  @Test
  public void testExecuteSingleInsertMoreResultsBehavior() throws SQLException {
    String tableName = "test_insert_more_results_" + System.currentTimeMillis();
    String createSql =
        String.format("CREATE OR REPLACE TABLE %s.%s (id INT64);", DATASET, tableName);
    String insertSql = String.format("INSERT INTO %s.%s (id) VALUES (1);", DATASET, tableName);
    String dropSql = String.format("DROP TABLE IF EXISTS %s.%s;", DATASET, tableName);

    try {
      bigQueryStatement.execute(createSql);

      assertFalse(bigQueryStatement.execute(insertSql));
      assertNull(bigQueryStatement.getResultSet());
      assertTrue(bigQueryStatement.getUpdateCount() > 0);

      // Validate no more results reset update count to -1
      assertFalse(bigQueryStatement.getMoreResults());
      assertEquals(-1, bigQueryStatement.getUpdateCount());
    } finally {
      bigQueryStatement.execute(dropSql);
    }
  }

  @Test
  public void testExecuteSingleTclMoreResultsBehavior() throws SQLException {
    Connection sessionConnection = DriverManager.getConnection(session_enabled_connection_uri);
    Statement sessionStatement = sessionConnection.createStatement();

    try {
      assertFalse(sessionStatement.execute("START TRANSACTION;"));
      assertNull(sessionStatement.getResultSet());
      assertEquals(0, sessionStatement.getUpdateCount());

      // Validate no more results reset update count to -1
      assertFalse(sessionStatement.getMoreResults());
      assertEquals(-1, sessionStatement.getUpdateCount());
    } finally {
      sessionStatement.close();
      sessionConnection.close();
    }
  }

  @Test
  public void testInformationSchemaTables() throws SQLException {
    String query = String.format("SELECT * FROM %s.INFORMATION_SCHEMA.TABLES", DATASET);
    try (Statement statement = bigQueryConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {
      ResultSetMetaData metaData = resultSet.getMetaData();
      int columnCount = metaData.getColumnCount();
      assertTrue(columnCount > 0);
      int rowCount = 0;
      while (resultSet.next()) {
        rowCount++;
        for (int i = 1; i <= columnCount; i++) {
          Object obj = resultSet.getObject(i);
          if (obj != null) {
            assertNotNull(obj.toString());
          }
        }
      }
      assertTrue(rowCount > 0);
    }
  }

  private void validate(
      String method,
      BiFunction<ResultSet, Integer, Object> getter,
      ImmutableMap<String, Object> expectedResult)
      throws Exception {

    try (Connection connection = DriverManager.getConnection(connection_uri);
        Connection connectionHTAPI =
            DriverManager.getConnection(
                connection_uri
                    + ";HighThroughputMinTableSize=0;HighThroughputActivationRatio=0;EnableHighThroughputAPI=1;");
        Statement statement = connection.createStatement();
        Statement statementHTAPI = connectionHTAPI.createStatement()) {

      String query =
          "SELECT * FROM INTEGRATION_TEST_FORMAT.all_bq_types WHERE stringField is not null";
      ResultSet resultSetRegular = statement.executeQuery(query);
      ResultSet resultSetArrow = statementHTAPI.executeQuery(query);
      resultSetRegular.next();
      resultSetArrow.next();

      for (int i = 1; i <= resultSetRegular.getMetaData().getColumnCount(); i++) {
        String columnName = resultSetRegular.getMetaData().getColumnName(i);

        String regularApiLabel =
            String.format("[Method: %s] [Column: %s] [API: Regular]", method, columnName);
        String htapiApiLabel =
            String.format("[Method: %s] [Column: %s] [API: HTAPI]", method, columnName);

        if (expectedResult.containsKey(columnName)) {
          Object expectedValue = expectedResult.get(columnName);

          assertEquals(expectedValue, getter.apply(resultSetRegular, i), regularApiLabel);
          assertEquals(expectedValue, getter.apply(resultSetArrow, i), htapiApiLabel);

        } else {
          String regularMsg = "Expected exception but got a value. " + regularApiLabel;
          assertEquals(EXCEPTION_REPLACEMENT, getter.apply(resultSetRegular, i), regularMsg);

          String htapiMsg = "Expected exception but got a value. " + htapiApiLabel;
          assertEquals(EXCEPTION_REPLACEMENT, getter.apply(resultSetArrow, i), htapiMsg);
        }
      }
    }
  }

  @Test
  public void validateGetString() throws Exception {
    final ImmutableMap<String, Object> stringResults =
        new ImmutableMap.Builder<String, Object>()
            .put("stringField", "StringValue")
            .put("bytesField", "Qnl0ZXNWYWx1ZQ==")
            .put("intField", "123")
            .put("floatField", "10.5")
            .put("numericField", "12345.67")
            .put("bigNumericField", "98765432109876543210.123456789")
            .put("booleanField", "true")
            .put("timestampFiled", "2023-07-28 12:30:00.000000")
            .put("dateField", "2023-07-28")
            .put("timeField", "12:30:00.000")
            .put("dateTimeField", "2023-07-28 12:30:00.000000")
            .put("geographyField", "POINT(-74.006 40.7128)")
            .put(
                "recordField",
                "{\"name\":\"NameValue\",\"recordNested\":{\"lastName\":\"LastNameValue\"}}")
            .put("rangeField", "[2023-01-01, 2023-12-01)")
            .put("jsonField", "{\"key\":\"value\"}")
            .put("arrayString", "[abc, def, ghi]")
            .put("arrayRecord", "[{\"value\":\"rec_val1\"}, {\"value\":\"rec_val2\"}]")
            .put("arrayBytes", "[Ynl0ZTE=, Ynl0ZTI=]")
            .put("arrayInteger", "[10, 20]")
            .put("arrayNumeric", "[10.5, 20.5]")
            .put("arrayBignumeric", "[100.1, 200.2]")
            .put("arrayBoolean", "[true, false]")
            .put("arrayTimestamp", "[2023-01-01 01:00:00.0, 2023-01-01 02:00:00.0]")
            .put("arrayDate", "[2023-01-01, 2023-01-02]")
            .put("arrayTime", "[01:00:00, 02:00:00]")
            .put("arrayDatetime", "[2023-01-01 01:00:00.0, 2023-01-01 02:00:00.0]")
            .put("arrayGeography", "[POINT(1 1), POINT(2 2)]")
            .put("arrayRange", "[[2023-01-01, 2023-01-03), [2023-01-04, 2023-01-06)]")
            .put("arrayJson", "[{\"a\":1}, {\"b\":2}]")
            .put("arrayFloat", "[1.1, 2.2]")
            .build();
    BiFunction<ResultSet, Integer, Object> getter =
        (s, i) -> {
          try {
            return s.getString(i);
          } catch (Exception e) {
            return EXCEPTION_REPLACEMENT;
          }
        };
    validate("getString", getter, stringResults);
  }

  @Test
  public void validateGetInt() throws Exception {
    final ImmutableMap<String, Object> result =
        new ImmutableMap.Builder<String, Object>()
            .put("intField", 123)
            .put("floatField", 10)
            .put("numericField", 12345)
            .put("booleanField", 1)
            .build();
    BiFunction<ResultSet, Integer, Object> getter =
        (s, i) -> {
          try {
            return s.getInt(i);
          } catch (Exception e) {
            return EXCEPTION_REPLACEMENT;
          }
        };
    validate("getInt", getter, result);
  }

  @Test
  public void validateGetLong() throws Exception {
    final ImmutableMap<String, Object> result =
        new ImmutableMap.Builder<String, Object>()
            .put("intField", 123L)
            .put("floatField", 10L)
            .put("numericField", 12345L)
            .put("booleanField", 1L)
            .build();
    BiFunction<ResultSet, Integer, Object> getter =
        (s, i) -> {
          try {
            return s.getLong(i);
          } catch (Exception e) {
            return EXCEPTION_REPLACEMENT;
          }
        };
    validate("getLong", getter, result);
  }

  @Test
  public void validateGetBool() throws Exception {
    final ImmutableMap<String, Object> result =
        new ImmutableMap.Builder<String, Object>()
            .put("intField", true)
            .put("floatField", true)
            .put("numericField", true)
            .put("booleanField", true)
            .put("bigNumericField", true)
            .put("stringField", false)
            .build();
    BiFunction<ResultSet, Integer, Object> getter =
        (s, i) -> {
          try {
            return s.getBoolean(i);
          } catch (Exception e) {
            return EXCEPTION_REPLACEMENT;
          }
        };
    validate("getBool", getter, result);
  }

  @Test
  public void validateGetFloat() throws Exception {
    final ImmutableMap<String, Object> result =
        new ImmutableMap.Builder<String, Object>()
            .put("intField", (float) 123.0)
            .put("floatField", (float) 10.5)
            .put("numericField", (float) 12345.67)
            .put("bigNumericField", (float) 98765432109876543210.123456789)
            .put("booleanField", (float) 1.0)
            .build();
    BiFunction<ResultSet, Integer, Object> getter =
        (s, i) -> {
          try {
            return s.getFloat(i);
          } catch (Exception e) {
            return EXCEPTION_REPLACEMENT;
          }
        };
    validate("getFloat", getter, result);
  }

  @Test
  public void validateGetDouble() throws Exception {
    final ImmutableMap<String, Object> result =
        new ImmutableMap.Builder<String, Object>()
            .put("intField", (double) 123.0)
            .put("floatField", (double) 10.5)
            .put("numericField", (double) 12345.67)
            .put("bigNumericField", (double) 98765432109876543210.123456789)
            .put("booleanField", (double) 1.0)
            .build();
    BiFunction<ResultSet, Integer, Object> getter =
        (s, i) -> {
          try {
            return s.getDouble(i);
          } catch (Exception e) {
            return EXCEPTION_REPLACEMENT;
          }
        };
    validate("getDouble", getter, result);
  }

  @Test
  public void validateGetShort() throws Exception {
    final ImmutableMap<String, Object> result =
        new ImmutableMap.Builder<String, Object>()
            .put("intField", (short) 123)
            .put("floatField", (short) 10)
            .put("numericField", (short) 12345)
            .put("booleanField", (short) 1)
            .build();
    BiFunction<ResultSet, Integer, Object> getter =
        (s, i) -> {
          try {
            return s.getShort(i);
          } catch (Exception e) {
            return EXCEPTION_REPLACEMENT;
          }
        };
    validate("getShort", getter, result);
  }

  @Test
  public void validateGetTime() throws Exception {
    final ImmutableMap<String, Object> result =
        new ImmutableMap.Builder<String, Object>()
            .put("timeField", Time.valueOf("12:30:00"))
            .put("dateTimeField", Time.valueOf("12:30:00"))
            .put("timestampFiled", Time.valueOf("12:30:00"))
            .build();
    BiFunction<ResultSet, Integer, Object> getter =
        (s, i) -> {
          try {
            return s.getTime(i);
          } catch (Exception e) {
            return EXCEPTION_REPLACEMENT;
          }
        };
    validate("getTime", getter, result);
  }

  @Test
  public void validateGetDate() throws Exception {
    final ImmutableMap<String, Object> result =
        new ImmutableMap.Builder<String, Object>()
            .put("dateField", Date.valueOf("2023-07-28"))
            .put("dateTimeField", Date.valueOf("2023-07-28"))
            .put("timestampFiled", Date.valueOf("2023-07-28"))
            .build();
    BiFunction<ResultSet, Integer, Object> getter =
        (s, i) -> {
          try {
            return s.getDate(i);
          } catch (Exception e) {
            return EXCEPTION_REPLACEMENT;
          }
        };
    validate("getDate", getter, result);
  }

  @Test
  public void validateGetTimestamp() throws Exception {
    final ImmutableMap<String, Object> result =
        new ImmutableMap.Builder<String, Object>()
            .put("timeField", Timestamp.valueOf("1970-01-01 12:30:00"))
            .put("dateField", Timestamp.valueOf("2023-07-28 00:00:00"))
            .put("dateTimeField", Timestamp.valueOf("2023-07-28 12:30:00"))
            .put("timestampFiled", Timestamp.valueOf("2023-07-28 12:30:00"))
            .build();
    BiFunction<ResultSet, Integer, Object> getter =
        (s, i) -> {
          try {
            return s.getTimestamp(i);
          } catch (Exception e) {
            return EXCEPTION_REPLACEMENT;
          }
        };
    validate("getTimestamp", getter, result);
  }

  @Test
  public void validateGetByte() throws Exception {
    final ImmutableMap<String, Object> result =
        new ImmutableMap.Builder<String, Object>()
            .put("intField", (byte) 123)
            .put("booleanField", (byte) 1)
            .put("floatField", (byte) 10)
            .build();
    BiFunction<ResultSet, Integer, Object> getter =
        (s, i) -> {
          try {
            return s.getByte(i);
          } catch (Exception e) {
            return EXCEPTION_REPLACEMENT;
          }
        };
    validate("getByte", getter, result);
  }

  @Test
  public void validateGetObjectNullValues() throws Exception {
    try (Connection connection = DriverManager.getConnection(connection_uri);
        Connection connectionHTAPI =
            DriverManager.getConnection(
                connection_uri
                    + ";HighThroughputMinTableSize=0;HighThroughputActivationRatio=0;EnableHighThroughputAPI=1;");
        Statement statement = connection.createStatement();
        Statement statementHTAPI = connectionHTAPI.createStatement()) {

      String query =
          "SELECT * FROM INTEGRATION_TEST_FORMAT.all_bq_types WHERE stringField is null;";
      ResultSet resultSetRegular = statement.executeQuery(query);
      ResultSet resultSetArrow = statementHTAPI.executeQuery(query);
      resultSetRegular.next();
      resultSetArrow.next();

      for (int i = 1; i <= resultSetRegular.getMetaData().getColumnCount(); i++) {
        String columnName = resultSetRegular.getMetaData().getColumnName(i);
        if (!columnName.contains("array")) {
          assertNull(resultSetRegular.getObject(i));
          assertNull(resultSetArrow.getObject(i));
        } else {
          assertEquals(resultSetRegular.getObject(i).toString(), "[]");
          assertEquals(resultSetArrow.getObject(i).toString(), "[]");
        }
      }
    }
  }
}
