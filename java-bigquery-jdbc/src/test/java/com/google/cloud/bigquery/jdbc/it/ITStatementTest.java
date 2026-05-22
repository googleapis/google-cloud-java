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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.ServiceOptions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITStatementTest {
  private static final String DEFAULT_CATALOG = ServiceOptions.getDefaultProjectId();
  private static final String DATASET = "JDBC_STATEMENT_TEST_DATASET";
  private static String connectionUrl =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=%s;OAuthType=3;Timeout=3600;";
  private static Random random = new Random();
  private static int randomNumber = random.nextInt(999);
  private static final String TABLE_NAME = "JDBC_STATEMENT_TEST_TABLE" + randomNumber;

  @BeforeClass
  public static void beforeClass() throws InterruptedException {
    ITBase.setUpDataset(DATASET);
    ITBase.setUpTable(DATASET, TABLE_NAME);
  }

  @AfterClass
  public static void afterClass() throws InterruptedException {
    ITBase.cleanUp(DATASET);
  }

  @Test
  public void testExecute() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement statement = connection.createStatement();
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME;

    Boolean selectQueryReturn = statement.execute(selectQuery);
    assertEquals(true, selectQueryReturn);

    ResultSet resultSet = statement.getResultSet();
    while (resultSet.next()) {
      if (resultSet.getInt("IntegerField") == 111) {
        assertEquals("string1", resultSet.getString("StringField"));
        assertEquals("737472696E6731", resultSet.getString("BytesField"));
      }
    }

    assertEquals(0, statement.getQueryTimeout());
    assertEquals(ResultSet.FETCH_FORWARD, statement.getFetchDirection());
    assertNotEquals(ResultSet.FETCH_REVERSE, statement.getFetchDirection());
    assertNotEquals(ResultSet.FETCH_UNKNOWN, statement.getFetchDirection());

    assertEquals(ResultSet.CLOSE_CURSORS_AT_COMMIT, statement.getResultSetHoldability());
    assertNotEquals(ResultSet.HOLD_CURSORS_OVER_COMMIT, statement.getResultSetHoldability());

    assertEquals(ResultSet.TYPE_FORWARD_ONLY, statement.getResultSetType());
    assertNotEquals(ResultSet.TYPE_SCROLL_SENSITIVE, statement.getResultSetType());
    assertNotEquals(ResultSet.TYPE_SCROLL_INSENSITIVE, statement.getResultSetType());

    assertEquals(ResultSet.CONCUR_READ_ONLY, statement.getResultSetConcurrency());
    assertNotEquals(ResultSet.CONCUR_UPDATABLE, statement.getResultSetConcurrency());

    assertEquals(-1, statement.getUpdateCount());
    // assertEquals(-1L, statement.getLargeUpdateCount());

    statement.close();
    connection.close();
  }

  @Test
  public void testExecuteQuery() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement statement = connection.createStatement();
    String selectQuery =
        "SELECT * FROM bigquery-public-data.chicago_taxi_trips.taxi_trips LIMIT 1000;";

    ResultSet selectQueryResult = statement.executeQuery(selectQuery);
    ResultSet statementResult = statement.getResultSet();
    assertEquals(statementResult, selectQueryResult);

    assertEquals(0, statement.getFetchSize());

    // setMaxRows Test
    statement.setMaxRows(5);
    ResultSet maxRowsResultSet = statement.executeQuery(selectQuery);
    assertEquals(5, getSizeOfResultSet(maxRowsResultSet));

    try {
      statement.setMaxRows(0);
      maxRowsResultSet = statement.executeQuery(selectQuery);
    } catch (SQLDataException exception) {
      assertTrue(true);
      statement.close();
    }

    // TODO(note): setFetchSize not working
    /*statement.setFetchSize(1);
    ResultSet newResultSet = statement.executeQuery(selectQuery);
    assertEquals(1, getSizeOfResultSet(newResultSet));*/

    assertEquals(0, statement.getQueryTimeout());
    assertEquals(ResultSet.FETCH_FORWARD, statement.getFetchDirection());
    assertNotEquals(ResultSet.FETCH_REVERSE, statement.getFetchDirection());
    assertNotEquals(ResultSet.FETCH_UNKNOWN, statement.getFetchDirection());
    try {
      statement.setFetchDirection(ResultSet.FETCH_REVERSE);
    } catch (SQLFeatureNotSupportedException exception) {
      assertTrue(true);
    }

    assertEquals(ResultSet.CLOSE_CURSORS_AT_COMMIT, statement.getResultSetHoldability());
    assertNotEquals(ResultSet.HOLD_CURSORS_OVER_COMMIT, statement.getResultSetHoldability());

    assertEquals(ResultSet.TYPE_FORWARD_ONLY, statement.getResultSetType());
    assertNotEquals(ResultSet.TYPE_SCROLL_SENSITIVE, statement.getResultSetType());
    assertNotEquals(ResultSet.TYPE_SCROLL_INSENSITIVE, statement.getResultSetType());

    assertEquals(ResultSet.CONCUR_READ_ONLY, statement.getResultSetConcurrency());
    assertNotEquals(ResultSet.CONCUR_UPDATABLE, statement.getResultSetConcurrency());

    assertEquals(-1, statement.getUpdateCount());
    assertEquals(-1L, statement.getLargeUpdateCount());
    statement.close();
    connection.close();
  }

  @Test
  public void testExecuteUpdate() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    String TEMP_TABLE_NAME = "TEMP_DDL_STATEMENT_TABLE";
    String createQuery =
        "CREATE OR REPLACE TABLE "
            + DATASET
            + "."
            + TEMP_TABLE_NAME
            + " (\n"
            + "`StringField` STRING,\n"
            + "`BytesField` BYTES,\n"
            + "`IntegerField` INTEGER);";
    String alterQuery =
        "ALTER TABLE " + DATASET + "." + TEMP_TABLE_NAME + " ADD COLUMN `NewField` INTEGER;";
    String updateQuery =
        "UPDATE "
            + DATASET
            + "."
            + TEMP_TABLE_NAME
            + "  SET StringField = 'string71' "
            + "  WHERE IntegerField = 333 "
            + " ;";
    String deleteQuery = "DROP TABLE " + DATASET + "." + TEMP_TABLE_NAME;
    String multiInsertQuery =
        "INSERT INTO "
            + DATASET
            + "."
            + TEMP_TABLE_NAME
            + " (\n"
            + "  StringField, BytesField,IntegerField)\n"
            + "  VALUES ('string3',CAST ('string3' AS BYTES),333), "
            + " ('string4',CAST ('string4' AS BYTES),444), "
            + " ('string5',CAST ('string5' AS BYTES),555) "
            + " ;";
    String selectQuery = "select * from " + DATASET + "." + TEMP_TABLE_NAME;

    Statement statement = connection.createStatement();
    int createCount = statement.executeUpdate(createQuery);
    assertEquals(0, createCount);

    int insertCount = statement.executeUpdate(multiInsertQuery);
    assertEquals(3, insertCount);

    int alterCount = statement.executeUpdate(alterQuery);
    assertEquals(0, alterCount);
    ResultSet resultSet = statement.executeQuery(selectQuery);
    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
    assertEquals(4, resultSetMetaData.getColumnCount());

    int updateCount = statement.executeUpdate(updateQuery);
    assertEquals(1, updateCount);

    int deleteCount = statement.executeUpdate(deleteQuery);
    assertEquals(0, deleteCount);

    statement.close();
    connection.close();
  }

  @Test
  public void testScript() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + DEFAULT_CATALOG
            + ";OAUTHTYPE=3";
    Properties withReadApi = new Properties();
    withReadApi.setProperty("EnableHighThroughputAPI", "1");
    Connection connection = DriverManager.getConnection(connection_uri, withReadApi);
    Statement statement = connection.createStatement();
    String BASE_QUERY =
        "SELECT * FROM bigquery-public-data.new_york_taxi_trips.tlc_yellow_trips_2017 order by"
            + " trip_distance asc LIMIT %s;";
    int expectedCnt = 500000;
    String longQuery = String.format(BASE_QUERY, expectedCnt);
    String longerQuery = String.format(BASE_QUERY, 700000);
    String longerQuery2 = String.format(BASE_QUERY, 900000);
    statement.execute(longQuery + longerQuery + longerQuery2);
    ResultSet arrowResultSet = statement.getResultSet();
    assertEquals(500000, resultSetRowCount(arrowResultSet));
    arrowResultSet.close();
    connection.close();
  }

  private int resultSetRowCount(ResultSet resultSet) throws SQLException {
    int rowCount = 0;
    while (resultSet.next()) {
      rowCount++;
    }
    return rowCount;
  }

  @Test
  public void testStringColumnLength() throws SQLException {
    String projectId = DEFAULT_CATALOG;
    String TABLE_NAME = "StringColumnLengthTable";
    String oauthType = "3"; // Google Application Credentials
    int length = 10;
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId="
            + projectId
            + ";OAuthType="
            + oauthType
            + ";Timeout=3600;"
            + "StringColumnLength="
            + length
            + ";";
    // + "EnableSession=1";
    Connection connection1 = DriverManager.getConnection(connectionUrl);
    Statement statement = connection1.createStatement();

    String createQuery =
        "CREATE OR REPLACE TABLE "
            + DATASET
            + "."
            + TABLE_NAME
            + " (\n"
            + "`StringField1` STRING,\n"
            + "`StringField2` STRING,\n"
            + "`StringField3` STRING \n"
            + ");";
    String insertQuery =
        "INSERT INTO %s.%s (StringField1, StringField2, StringField3)  VALUES ('%s', '%s', '%s') ;";
    String selectQuery = String.format("SELECT * FROM %s.%s; ", DATASET, TABLE_NAME);
    statement.execute(createQuery);

    String s1 = generateString(1111);
    String s2 = generateString(11111);
    String s3 = generateString(111111);
    statement.execute(String.format(insertQuery, DATASET, TABLE_NAME, s1, s2, s3));
    ResultSet rs = statement.executeQuery(selectQuery);
    ResultSetMetaData metadata = rs.getMetaData();
    int i = 0;
    while (rs.next()) {
      assertNotNull(rs.getString(1));
      assertNotNull(rs.getString(2));
      assertNotNull(rs.getString(3));
    }
  }

  private String generateString(int len) {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < len; i++) {
      s = s.append("s");
    }
    return s.toString();
  }

  @Test
  public void testCloseStatement() throws SQLException {
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME;
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement statement = connection.createStatement();

    assertFalse(statement.isClosed());
    assertFalse(statement.isCloseOnCompletion());
    statement.closeOnCompletion();
    assertTrue(statement.isCloseOnCompletion());
    ResultSet resultSet = statement.executeQuery(selectQuery);
    resultSet.close();

    assertTrue(statement.isClosed());
    statement = connection.createStatement();
    statement.close();
    assertTrue(statement.isClosed());
    connection.close();
  }

  @Test
  public void testSetTimeout() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement statement = connection.createStatement();

    String selectQuery =
        "SELECT views FROM bigquery-public-data.wikipedia.pageviews_2020 WHERE datehour >="
            + " '2020-01-01' LIMIT 9000000";

    // statement.execute(selectQuery);
    assertEquals(0, statement.getQueryTimeout());
    statement.setQueryTimeout(1);
    assertEquals(1, statement.getQueryTimeout());
    try {
      statement.executeQuery(selectQuery);
    } catch (SQLException e) {
      assertTrue(true);
      assertEquals("SQL execution canceled", e.getMessage());
    }
    statement.close();
    connection.close();
  }

  @Test
  public void testSetTimeoutThrows() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement statement = connection.createStatement();
    assertThrows(SQLException.class, () -> statement.setQueryTimeout(-1));
  }

  @Test
  public void testDefaultValues() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement statement = connection.createStatement();
    assertEquals(0, statement.getMaxFieldSize());
    // assertEquals(0, statement.getLargeMaxRows());
    assertNull(statement.getWarnings());
    assertFalse(statement.isPoolable());
    statement.close();
    connection.close();
  }

  @Test
  public void testRangeSelectDataset() throws SQLException {
    Connection connection =
        DriverManager.getConnection(String.format(connectionUrl, DEFAULT_CATALOG));
    Statement statement = connection.createStatement();

    // execute
    try {
      statement.execute(
          "CREATE TABLE "
              + DEFAULT_CATALOG
              + "."
              + DATASET
              + ".RangeTable (x RANGE<DATE> OPTIONS (description = 'An optional RANGE<DATE>"
              + " field'), y STRUCT <a ARRAY <RANGE<DATETIME>> OPTIONS (description = 'An array of"
              + " RANGE<DATETIME> field')>);");
      ResultSet selectQueryResult =
          statement.executeQuery(
              "SELECT * FROM " + String.format("  `%s.%s.RangeTable`;", DEFAULT_CATALOG, DATASET));

      assertEquals(selectQueryResult.getMetaData().getColumnTypeName(1), "RANGE");
    } finally {
      // clean up
      statement.execute(
          String.format("DROP TABLE IF EXISTS %s.%s.RangeTable;", DEFAULT_CATALOG, DATASET));
      statement.close();
    }
    connection.close();
  }

  int getSizeOfResultSet(ResultSet resultSet) throws SQLException {
    int count = 0;
    while (resultSet.next()) {
      count++;
    }
    return count;
  }
}
