/*
 * Copyright 2024 Google LLC
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
import static java.util.Arrays.asList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlSyntaxErrorException;
import com.google.cloud.bigquery.jdbc.BigQueryConnection;
import com.google.cloud.bigquery.jdbc.BigQueryDriver;
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
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITNightlyBigQueryTest {
  static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  static Connection bigQueryConnection;
  static Statement bigQueryStatement;
  static BigQuery bigQuery;
  private static final Random random = new Random();
  private static final int randomNumber = random.nextInt(9999);
  private static final String BASE_QUERY =
      "SELECT * FROM bigquery-public-data.new_york_taxi_trips.tlc_yellow_trips_2017 order by"
          + " trip_distance asc LIMIT %s";
  private static final String CONSTRAINTS_DATASET = "JDBC_CONSTRAINTS_TEST_DATASET";
  private static final String CONSTRAINTS_TABLE_NAME = "JDBC_CONSTRAINTS_TEST_TABLE";
  private static final String CONSTRAINTS_TABLE_NAME2 = "JDBC_CONSTRAINTS_TEST_TABLE2";
  private static final String CALLABLE_STMT_PROC_NAME = "IT_CALLABLE_STMT_PROC_TEST";
  private static final String CALLABLE_STMT_TABLE_NAME = "IT_CALLABLE_STMT_PROC_TABLE";
  private static final String CALLABLE_STMT_PARAM_KEY = "CALL_STMT_PARAM_KEY";
  private static final String CALLABLE_STMT_DML_INSERT_PROC_NAME =
      "IT_CALLABLE_STMT_PROC_DML_INSERT_TEST";
  private static final String CALLABLE_STMT_DML_UPDATE_PROC_NAME =
      "IT_CALLABLE_STMT_PROC_DML_UPDATE_TEST";
  private static final String CALLABLE_STMT_DML_DELETE_PROC_NAME =
      "IT_CALLABLE_STMT_PROC_DML_DELETE_TEST";
  private static final String CALLABLE_STMT_DML_TABLE_NAME = "IT_CALLABLE_STMT_PROC_DML_TABLE";
  private static final String DATASET = "JDBC_NIGHTLY_IT_DATASET";
  private static final String DATASET2 = "JDBC_PRESUBMIT_INTEGRATION_DATASET_2";
  static final String session_enabled_connection_uri =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
          + PROJECT_ID
          + ";OAUTHTYPE=3;EnableSession=1";

  static final String connection_uri =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
          + PROJECT_ID
          + ";OAUTHTYPE=3";

  @BeforeClass
  public static void beforeClass() throws SQLException {
    bigQueryConnection = DriverManager.getConnection(connection_uri, new Properties());
    bigQueryStatement = bigQueryConnection.createStatement();
    bigQuery = BigQueryOptions.newBuilder().build().getService();
  }

  @AfterClass
  public static void afterClass() throws SQLException {
    bigQueryStatement.close();
    bigQueryConnection.close();
  }

  @Test
  public void testMergeInExecuteBatch() throws SQLException {
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
            "INSERT INTO %s.%s (product, quantity) "
                + "VALUES (?,? ), (?,? ), (?,? ), (?,? ), (?,? ), (?,? );",
            DATASET, TABLE_NAME1);
    PreparedStatement insertPs = bigQueryConnection.prepareStatement(insertQuery);
    insertPs.setString(1, "dishwasher");
    insertPs.setInt(2, 30);
    insertPs.setString(3, "dryer");
    insertPs.setInt(4, 30);
    insertPs.setString(5, "front load washer");
    insertPs.setInt(6, 20);
    insertPs.setString(7, "microwave");
    insertPs.setInt(8, 20);
    insertPs.setString(9, "oven");
    insertPs.setInt(10, 5);
    insertPs.setString(11, "top load washer");
    insertPs.setInt(12, 10);

    int insertStatus = insertPs.executeUpdate();
    assertEquals(6, insertStatus);

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

    Statement statement = bigQueryConnection.createStatement();
    String mergeQuery =
        String.format(
            "MERGE %s.%s T\n"
                + "USING %s.%s S\n"
                + "ON T.product = S.product\n"
                + "WHEN NOT MATCHED AND quantity < 100 THEN\n"
                + "  INSERT(product, quantity, supply_constrained, comment)\n"
                + "  VALUES(product, quantity, true, '[]')\n",
            DATASET, TABLE_NAME2, DATASET, TABLE_NAME1);
    statement.addBatch(mergeQuery);
    int[] result = statement.executeBatch();

    assertEquals(1, result.length);
    assertEquals(3, result[0]);
    bigQueryStatement.execute(String.format("DROP TABLE %s.%s", DATASET, TABLE_NAME1));
    bigQueryStatement.execute(String.format("DROP TABLE %s.%s", DATASET, TABLE_NAME2));
  }

  @Test
  public void testValidLongRunningQuery() throws SQLException {
    // setup
    String selectQuery =
        "SELECT * FROM `bigquery-public-data.deepmind_alphafold.metadata` LIMIT 50000";

    // Read data via JDBC
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertNotNull(resultSet);

    for (int i = 0; i < 50000; i++) {
      resultSet.next();
      assertFalse(resultSet.wasNull());
      assertNotNull(resultSet.getString(5));
    }

    // clean up
    resultSet.close();
  }

  @Test
  public void testQueryInterruptGracefullyStopsExplicitJob()
      throws SQLException, InterruptedException {
    AtomicBoolean threadException = new AtomicBoolean(true);
    Connection bigQueryConnection =
        DriverManager.getConnection(connection_uri + ";JobCreationMode=1", new Properties());
    Statement bigQueryStatement = bigQueryConnection.createStatement();

    // This query takes 300 seconds to complete
    String query300Seconds =
        "DECLARE DELAY_TIME DATETIME; SET DELAY_TIME = DATETIME_ADD(CURRENT_DATETIME, INTERVAL 300"
            + " SECOND); WHILE CURRENT_DATETIME < DELAY_TIME DO  END WHILE;";

    // Query will be started in the background thread & we will call cancel from current thread.
    Thread t =
        new Thread(
            () -> {
              SQLException e =
                  assertThrows(
                      SQLException.class, () -> bigQueryStatement.execute(query300Seconds));
              assertTrue(e.getMessage().contains("User requested cancellation"));
              threadException.set(false);
            });
    t.start();
    // Allow thread to actually initiate the query
    Thread.sleep(3000);
    bigQueryStatement.cancel();
    // Wait until background thread is finished
    t.join();
    assertFalse(threadException.get());
    // Ensure statement can be used again
    assertFalse(bigQueryStatement.isClosed());
    bigQueryStatement.executeQuery("SELECT 1");
  }

  @Test
  public void testQueryInterruptGracefullyStopsOptionalJob()
      throws SQLException, InterruptedException {
    AtomicBoolean threadException = new AtomicBoolean(true);
    Connection bigQueryConnection =
        DriverManager.getConnection(connection_uri + ";JobCreationMode=2", new Properties());
    Statement bigQueryStatement = bigQueryConnection.createStatement();

    // This query takes 300 seconds to complete
    String query300Seconds =
        "DECLARE DELAY_TIME DATETIME; SET DELAY_TIME = DATETIME_ADD(CURRENT_DATETIME, INTERVAL 300"
            + " SECOND); WHILE CURRENT_DATETIME < DELAY_TIME DO  END WHILE;";

    // Query will be started in the background thread & we will call cancel from current thread.
    Thread t =
        new Thread(
            () -> {
              SQLException e =
                  assertThrows(
                      SQLException.class, () -> bigQueryStatement.execute(query300Seconds));
              assertTrue(e.getMessage().contains("Query was cancelled."));
              threadException.set(false);
            });
    t.start();
    // Allow thread to actually initiate the query
    Thread.sleep(3000);
    bigQueryStatement.cancel();
    // Wait until background thread is finished
    t.join();
    assertFalse(threadException.get());
    // Ensure statement can be used again
    assertFalse(bigQueryStatement.isClosed());
    bigQueryStatement.executeQuery("SELECT 1");
  }

  @Test
  public void testWideColumnQueries() throws SQLException {
    String selectQuery =
        "SELECT * FROM `bigquery-public-data.covid19_open_data_eu.covid19_open_data` LIMIT 50000";

    // Read data via JDBC
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertNotNull(resultSet);

    for (int i = 0; i < 50000; i++) {
      resultSet.next();
      assertFalse(resultSet.wasNull());
    }

    // clean up
    resultSet.close();
  }

  @Test
  public void testExecuteLargeUpdate() throws SQLException {
    String tableName = "JDBC_LARGE_UPDATE_TABLE_" + randomNumber;
    String createQuery =
        String.format(
            "CREATE TABLE %s.%s ("
                + "  gbifid STRING, scientificname STRING, "
                + "  individualcount INTEGER, isReviewed BOOLEAN)",
            DATASET, tableName);

    String insertQuery =
        String.format(
            "INSERT INTO %s.%s (gbifid, scientificname, individualcount) "
                + "SELECT gbifid, scientificname, individualcount  FROM "
                + "bigquery-public-data.gbif.occurrences;",
            DATASET, tableName);
    String updateQuery =
        String.format(
            "UPDATE %s.%s SET isReviewed = false WHERE individualcount >= 0 OR individualcount IS"
                + " NULL",
            DATASET, tableName);

    String selectQuery = String.format("SELECT * FROM %s.%s LIMIT 10", DATASET, tableName);

    bigQueryStatement.execute(createQuery);

    long insertCount = bigQueryStatement.executeLargeUpdate(insertQuery);
    assertTrue(insertCount > Integer.MAX_VALUE);

    long updateCount = bigQueryStatement.executeLargeUpdate(updateQuery);
    assertTrue(updateCount > Integer.MAX_VALUE);

    ResultSet selectResult = bigQueryStatement.executeQuery(selectQuery);
    assertTrue(selectResult.next());
    assertFalse(selectResult.getBoolean("isReviewed"));
    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, tableName));
  }

  @Test
  public void testHTAPIWithValidDestinationTableSavesQueriesWithStandardSQL() throws SQLException {
    // setup
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";QueryDialect=SQL;"
            + "LargeResultTable=destination_table_test;"
            + "LargeResultDataset=INTEGRATION_TESTS;"
            + "EnableHighThroughputAPI=1;";
    String selectLegacyQuery =
        "SELECT * FROM `bigquery-public-data.deepmind_alphafold.metadata` LIMIT 200000;";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    ResultSet resultSet = statement.executeQuery(selectLegacyQuery);

    // assertion
    assertNotNull(resultSet);
    String selectQuery = "SELECT * FROM INTEGRATION_TESTS.destination_table_test;";
    ResultSet actualResultSet = bigQueryStatement.executeQuery(selectQuery);
    assertEquals(200000, resultSetRowCount(actualResultSet));

    // clean up
    String deleteRows = "DELETE FROM `INTEGRATION_TESTS.destination_table_test` WHERE 1=1;";
    bigQueryStatement.execute(deleteRows);
  }

  @Test
  public void testBigQueryConcurrentLimitWithExecuteBatch() throws SQLException {
    // setup
    String BATCH_TABLE = "JDBC_EXECUTE_BATCH_TABLE_CONCURRENT_LIMIT_" + random.nextInt(99);
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
    for (int i = 0; i < 30; i++) {
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

    for (int updateCount : results) {
      assertEquals(1, updateCount);
    }
    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, BATCH_TABLE));
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
    for (int i = 0; i < 30; i++) {
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
    assertEquals(30, results.length);
    for (int updateCount : results) {
      assertEquals(1, updateCount);
    }
    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, BATCH_TABLE));
  }

  @Test
  public void testValidExecuteBatchWithMultipleDatasets() throws SQLException {
    // setup
    String BATCH_TABLE = "JDBC_EXECUTE_BATCH_TABLE_MULTIPLE_DATASET_" + random.nextInt(99);
    String createBatchTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, BATCH_TABLE);
    String createBatchTable2 =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET2, BATCH_TABLE);
    bigQueryStatement.execute(createBatchTable);
    bigQueryStatement.execute(createBatchTable2);
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    int[] results;
    for (int i = 0; i < 15; i++) {
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
    for (int i = 0; i < 15; i++) {
      String insertQuery =
          "INSERT INTO "
              + DATASET2
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
    for (int updateCount : results) {
      assertEquals(1, updateCount);
    }

    // do a select to validate row count on each
    String selectQuery = String.format("SELECT id, name, age FROM %s.%s ;", DATASET, BATCH_TABLE);
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertEquals(15, resultSetRowCount(resultSet));
    selectQuery = String.format("SELECT id, name, age FROM %s.%s ;", DATASET2, BATCH_TABLE);
    resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertEquals(15, resultSetRowCount(resultSet));
    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, BATCH_TABLE));
  }

  @Test
  public void testValidExecuteBatchWithMultipleTables() throws SQLException {
    // setup
    String BATCH_TABLE = "JDBC_EXECUTE_BATCH_TABLE_MULTI_TABLES_" + random.nextInt(99);
    String BATCH_TABLE_2 = "JDBC_EXECUTE_BATCH_TABLE_MULTI_TABLES_" + random.nextInt(99);
    String createBatchTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, BATCH_TABLE);
    String createBatchTable2 =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, BATCH_TABLE_2);
    bigQueryStatement.execute(createBatchTable);
    bigQueryStatement.execute(createBatchTable2);
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    int[] results;
    for (int i = 0; i < 5; i++) {
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
    for (int i = 0; i < 5; i++) {
      String insertQuery =
          "INSERT INTO "
              + DATASET
              + "."
              + BATCH_TABLE_2
              + " (id, name, age) "
              + "VALUES (12, 'Farhan', "
              + randomNumber
              + i
              + "); ";
      statement.addBatch(insertQuery);
    }
    results = statement.executeBatch();

    // assertions
    for (int updateCount : results) {
      assertEquals(1, updateCount);
    }

    // do a select to test row count on each
    String selectQuery = String.format("SELECT id, name, age FROM %s.%s ;", DATASET, BATCH_TABLE);
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertEquals(5, resultSetRowCount(resultSet));
    selectQuery = String.format("SELECT id, name, age FROM %s.%s ;", DATASET, BATCH_TABLE_2);
    resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertEquals(5, resultSetRowCount(resultSet));
    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, BATCH_TABLE));
    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, BATCH_TABLE_2));
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
            "INSERT INTO %s.%s (product, quantity) "
                + "VALUES (?,? ), (?,? ), (?,? ), (?,? ), (?,? ), (?,? );",
            DATASET, TABLE_NAME1);
    PreparedStatement insertPs = bigQueryConnection.prepareStatement(insertQuery);
    insertPs.setString(1, "dishwasher");
    insertPs.setInt(2, 30);
    insertPs.setString(3, "dryer");
    insertPs.setInt(4, 30);
    insertPs.setString(5, "front load washer");
    insertPs.setInt(6, 20);
    insertPs.setString(7, "microwave");
    insertPs.setInt(8, 20);
    insertPs.setString(9, "oven");
    insertPs.setInt(10, 5);
    insertPs.setString(11, "top load washer");
    insertPs.setInt(12, 10);

    int insertStatus = insertPs.executeUpdate();
    assertEquals(6, insertStatus);

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
    assertEquals(3, mergeStatus);

    ResultSet rs =
        bigQueryStatement.executeQuery(
            String.format("SELECT COUNT(*) AS row_count\n" + "FROM %s.%s", DATASET, TABLE_NAME2));
    rs.next();
    assertEquals(7, rs.getInt(1));

    String dropQuery = String.format("DROP TABLE %s.%s", DATASET, TABLE_NAME1);
    int dropStatus = bigQueryStatement.executeUpdate(dropQuery);
    assertEquals(0, dropStatus);
    bigQueryStatement.execute(String.format("DROP TABLE %s.%s", DATASET, TABLE_NAME2));
  }

  @Test
  public void testFailedStatementInTheMiddleOfExecuteBatchStopsExecuting() throws SQLException {
    // setup
    String BATCH_TABLE = "JDBC_EXECUTE_BATCH_TABLE_ERROR_IN_MIDDLE_" + random.nextInt(99);
    String createBatchTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, BATCH_TABLE);
    String createBatchTable2 =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET2, BATCH_TABLE);
    bigQueryStatement.execute(createBatchTable);
    bigQueryStatement.execute(createBatchTable2);
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();
    String dropQuery = String.format("DROP TABLE %s.%s", DATASET2, BATCH_TABLE);

    // act
    for (int i = 0; i < 20; i++) {
      if (i == 10) {
        statement.addBatch(
            "INSERT INTO "
                + DATASET2
                + "."
                + BATCH_TABLE
                + " (id, name, age) "
                + "VALUES (12, 'Farhan', "
                + randomNumber
                + i
                + "); ");
      } else {
        statement.addBatch(
            "INSERT INTO "
                + DATASET
                + "."
                + BATCH_TABLE
                + " (id, name, age) "
                + "VALUES (12, 'Farhan', "
                + randomNumber
                + i
                + "); ");
      }
    }
    bigQueryStatement.execute(dropQuery);

    // assertions
    assertThrows(BigQueryJdbcException.class, statement::executeBatch);
    String selectQuery = String.format("SELECT id, name, age FROM %s.%s ;", DATASET, BATCH_TABLE);
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertEquals(10, resultSetRowCount(resultSet));
    bigQueryStatement.execute(String.format("DROP TABLE %s.%s", DATASET, BATCH_TABLE));
  }

  @Test
  public void testHTAPIWithValidDestinationTableSavesQueriesWithLegacy() throws SQLException {
    // setup
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";QueryDialect=BIG_QUERY;"
            + "LargeResultTable=destination_table_test;"
            + "LargeResultDataset=INTEGRATION_TESTS;"
            + "EnableHighThroughputAPI=1;";
    String selectLegacyQuery =
        "SELECT * FROM [bigquery-public-data.deepmind_alphafold.metadata] LIMIT 200000;";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    ResultSet resultSet = statement.executeQuery(selectLegacyQuery);

    // assertion
    assertNotNull(resultSet);
    String selectQuery = "SELECT * FROM INTEGRATION_TESTS.destination_table_test;";
    ResultSet actualResultSet = bigQueryStatement.executeQuery(selectQuery);
    assertTrue(0 < resultSetRowCount(actualResultSet));

    // clean up
    String deleteRows = "DELETE FROM `INTEGRATION_TESTS.destination_table_test` WHERE 1=1;";
    bigQueryStatement.execute(deleteRows);
  }

  @Test
  public void testMultiStatementTransactionRollbackByUser() throws SQLException {
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE" + random.nextInt(99);
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

    bigQueryStatement.execute(createTransactionTable);

    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(session_enabled_connection_uri);
    connection.setAutoCommit(false);
    Statement statement = connection.createStatement();
    assertTrue(connection.isTransactionStarted());

    boolean status = statement.execute(insertQuery);
    assertFalse(status);
    int rows = statement.executeUpdate(updateQuery);
    assertEquals(1, rows);
    status = statement.execute(selectQuery);
    assertTrue(status);
    connection.rollback();
    assertTrue(
        "After rollback() in manual commit mode, a new transaction should be started.",
        connection.isTransactionStarted());

    // Separate query to check if transaction rollback worked
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertFalse(resultSet.next());

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TRANSACTION_TABLE));
    connection.close();
  }

  @Test
  public void testMultiStatementTransactionDoesNotCommitWithoutCommit() throws SQLException {
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE" + random.nextInt(99);
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

    bigQueryStatement.execute(createTransactionTable);
    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(session_enabled_connection_uri);
    connection.setAutoCommit(false);
    Statement statement = connection.createStatement();
    assertTrue(connection.isTransactionStarted());

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
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE" + random.nextInt(99);
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

    bigQueryStatement.execute(createTransactionTable);
    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(session_enabled_connection_uri);
    connection.setAutoCommit(false);
    Statement statement = connection.createStatement();
    assertTrue(connection.isTransactionStarted());

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
  public void testConnectionWithMultipleTransactionCommits() throws SQLException {
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE" + random.nextInt(99);
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

    bigQueryStatement.execute(createTransactionTable);
    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(session_enabled_connection_uri);
    connection.setAutoCommit(false);

    Statement statement = connection.createStatement();
    assertTrue(connection.isTransactionStarted());
    boolean status = statement.execute(insertQuery);
    assertFalse(status);
    status = statement.execute(updateQuery);
    assertFalse(status);
    status = statement.execute(selectQuery);
    assertTrue(status);
    connection.commit();

    connection.setAutoCommit(false);
    assertTrue(connection.isTransactionStarted());
    statement.execute(insertQuery);
    connection.rollback();

    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    int count = 0;
    while (resultSet.next()) {
      count++;
    }
    assertEquals(1, count);

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TRANSACTION_TABLE));
    connection.close();
  }

  @Test
  public void testTransactionRollbackOnError() throws SQLException {
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE" + random.nextInt(99);
    String createTransactionTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, TRANSACTION_TABLE);
    String selectQuery =
        String.format("SELECT id, name, age FROM %s.%s ;", DATASET, TRANSACTION_TABLE);

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
    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(session_enabled_connection_uri);
    Statement statement = connection.createStatement();
    statement.execute(transactionOnError);

    // do a check to see if no vals inserted
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertFalse(resultSet.next());

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TRANSACTION_TABLE));
    connection.close();
  }

  @Test
  public void testClearBatchClears() throws SQLException {
    // setup
    String BATCH_TABLE = "JDBC_EXECUTE_BATCH_TABLE_CLEAR_BATCH_" + random.nextInt(99);
    String createBatchTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, BATCH_TABLE);
    bigQueryStatement.execute(createBatchTable);
    String updateQuery =
        String.format(
            "UPDATE %s.%s SET age = 13 WHERE age = %s;", DATASET, BATCH_TABLE, randomNumber);
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    statement.addBatch(updateQuery);
    statement.clearBatch();
    int[] results = statement.executeBatch();

    // assertion
    assertEquals(0, results.length);
    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, BATCH_TABLE));
    connection.close();
  }

  @Test
  public void testMultipleExecuteBatches() throws SQLException {
    // setup
    String BATCH_TABLE = "JDBC_EXECUTE_BATCH_TABLE_MULTI_BATCHES_" + random.nextInt(99);
    String createBatchTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING, `age` INTEGER);",
            DATASET, BATCH_TABLE);
    String insertQuery =
        "INSERT INTO "
            + DATASET
            + "."
            + BATCH_TABLE
            + " (id, name, age) "
            + "VALUES (12, 'Farhan', "
            + randomNumber
            + "); ";
    String insertQuery2 =
        "INSERT INTO "
            + DATASET
            + "."
            + BATCH_TABLE
            + " (id, name, age) "
            + "VALUES (12, 'Farhan', 123), "
            + " (12, 'Farhan', 123); ";
    bigQueryStatement.execute(createBatchTable);
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act
    // batch bypasses the 16 concurrent limit
    statement.addBatch(insertQuery);
    int[] firstResults = statement.executeBatch();
    statement.addBatch(insertQuery2);
    int[] secondResults = statement.executeBatch();

    // assertions
    assertEquals(1, firstResults.length);
    assertEquals(1, secondResults.length);
    assertEquals(1, firstResults[0]);
    assertEquals(2, secondResults[0]);
    bigQueryStatement.execute(String.format("DROP TABLE IF EXISTS %S.%s", DATASET, BATCH_TABLE));
    connection.close();
  }

  @Test
  public void testValidAllDataTypesSerializationFromSelectQuery() throws SQLException {
    String DATASET = "JDBC_INTEGRATION_DATASET";
    String TABLE_NAME = "JDBC_DATATYPES_INTEGRATION_TEST_TABLE";
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME;

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
    Struct expectedStruct = (Struct) resultSet.getObject(8);
    assertThat(expectedStruct.getAttributes()).isEqualTo(asList("Eric", 10L).toArray());
    assertArrayEquals(
        new String[] {"one", "two", "three"}, (String[]) resultSet.getArray(9).getArray());

    assertEquals(Timestamp.valueOf("2020-04-27 18:07:25.356456"), resultSet.getObject(10));
    assertEquals(Date.valueOf("2019-1-12"), resultSet.getObject(11));
    assertEquals(Time.valueOf("14:00:00"), resultSet.getObject(12));
    assertEquals(Timestamp.valueOf("2019-02-17 11:24:00"), resultSet.getObject(13));
    assertEquals("POINT(1 2)", resultSet.getString(14));
    assertEquals("{\"class\":{\"students\":[{\"name\":\"Jane\"}]}}", resultSet.getString(15));
    assertEquals("123-7 -19 0:24:12.000006", resultSet.getString(16));
  }

  @Test
  public void testRepeatedStructFromSelectQuery() throws SQLException {
    String DATASET = "JDBC_INTEGRATION_DATASET";
    String TABLE_NAME = "JDBC_REPEATED_STRUCT_INTEGRATION_TEST";
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME;

    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertNotNull(resultSet);
    resultSet.next();

    Struct[] repeatedStruct = (Struct[]) resultSet.getArray(1).getArray();
    assertEquals(3, Arrays.stream(repeatedStruct).count());

    Object[] alice = repeatedStruct[0].getAttributes();
    Object[] bob = repeatedStruct[1].getAttributes();
    Object[] charlie = repeatedStruct[2].getAttributes();
    assertEquals("Alice", alice[0]);
    assertEquals("30", alice[1]);
    assertEquals("Bob", bob[0]);
    assertEquals("25", bob[1]);
    assertEquals("Charlie", charlie[0]);
    assertEquals("35", charlie[1]);
  }

  @Test
  public void testValidAllDataTypesSerializationFromSelectQueryArrowDataset() throws SQLException {
    String DATASET = "JDBC_INTEGRATION_DATASET";
    String TABLE_NAME = "JDBC_INTEGRATION_ARROW_TEST_TABLE";
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME + " LIMIT 5000;";
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;ProjectId="
            + PROJECT_ID
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
    Struct expectedStruct = (Struct) resultSet.getObject(8);
    assertThat(expectedStruct.getAttributes()).isEqualTo(asList("Eric", 10L).toArray());
    assertEquals("{\"name\":\"Eric\",\"age\":10}", expectedStruct.toString());
    assertArrayEquals(
        new String[] {"one", "two", "three"}, (String[]) resultSet.getArray(9).getArray());
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
  }

  /////////////// MARKER
  ///

  @Test
  public void testBulkInsertOperation() throws SQLException {
    String TABLE_NAME = "JDBC_BULK_INSERT_TABLE_" + randomNumber;
    String createQuery =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`StringField` STRING,\n"
                + "    `IntegerField` INTEGER,"
                + "    `FloatField` FLOAT64,"
                + "    `NumericField` NUMERIC,"
                + "    `BigNumericField` BIGNUMERIC,"
                + "    `BooleanField` BOOLEAN"
                + "    );",
            DATASET, TABLE_NAME);
    String insertQuery =
        String.format("INSERT INTO %s.%s  VALUES(?, ?, ?,?, ?, ?);", DATASET, TABLE_NAME);
    String dropQuery = String.format("DROP TABLE %s.%s", DATASET, TABLE_NAME);
    String selectQuery = String.format("SELECT * FROM %s.%s", DATASET, TABLE_NAME);

    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=3;"
            + "EnableWriteAPI=1;SWA_ActivationRowCount=5;SWA_AppendRowCount=500";

    try (Connection connection = DriverManager.getConnection(connection_uri)) {
      bigQueryStatement.execute(createQuery);
      PreparedStatement statement = connection.prepareStatement(insertQuery);
      for (int i = 0; i < 20; ++i) {
        statement.setString(1, i + "StringField");
        statement.setInt(2, i);
        statement.setFloat(3, (float) (i + .6));
        statement.setInt(4, random.nextInt());
        statement.setInt(5, random.nextInt());
        statement.setBoolean(6, true);

        statement.addBatch();
      }
      int[] result = statement.executeBatch();

      ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
      assertEquals(result.length, resultSetRowCount(resultSet));

      bigQueryStatement.execute(dropQuery);

    } catch (SQLException e) {
      throw new BigQueryJdbcException(e);
    }
  }

  @Test
  public void testBulkInsertOperationStandard() throws SQLException {
    String TABLE_NAME = "JDBC_BULK_INSERT_STANDARD_TABLE_" + randomNumber;
    String createQuery =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`StringField` STRING,\n"
                + "    `IntegerField` INTEGER,"
                + "    `FloatField` FLOAT64,"
                + "    `NumericField` NUMERIC,"
                + "    `BigNumericField` BIGNUMERIC,"
                + "    `BooleanField` BOOLEAN"
                + "    );",
            DATASET, TABLE_NAME);
    String insertQuery =
        String.format("INSERT INTO %s.%s  VALUES(?, ?, ?,?, ?, ?);", DATASET, TABLE_NAME);
    String dropQuery = String.format("DROP TABLE %s.%s", DATASET, TABLE_NAME);
    String selectQuery = String.format("SELECT * FROM %s.%s", DATASET, TABLE_NAME);

    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=3;"
            + "EnableWriteAPI=0;SWA_ActivationRowCount=50;SWA_AppendRowCount=500";

    try (Connection connection = DriverManager.getConnection(connection_uri)) {
      bigQueryStatement.execute(createQuery);
      PreparedStatement statement = connection.prepareStatement(insertQuery);
      for (int i = 0; i < 20; ++i) {
        statement.setString(1, i + "StringField");
        statement.setInt(2, i);
        statement.setFloat(3, (float) (i + .6));
        statement.setInt(4, random.nextInt());
        statement.setInt(5, random.nextInt());
        statement.setBoolean(6, true);

        statement.addBatch();
      }
      int[] result = statement.executeBatch();

      ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
      assertEquals(result.length, resultSetRowCount(resultSet));

      bigQueryStatement.execute(dropQuery);

    } catch (SQLException e) {
      throw new BigQueryJdbcException(e);
    }
  }

  @Test
  public void testExecuteQueryWithSetMaxRows() throws SQLException {
    String TEST_MAX_ROWS_TABLE = "JDBC_TEST_MAX_ROWS_TABLE" + random.nextInt(99);
    int id1 = random.nextInt(99);
    int id2 = random.nextInt(99);
    String createMaxRowsTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING);",
            DATASET, TEST_MAX_ROWS_TABLE);
    String insertQuery1 =
        String.format(
            "INSERT INTO %s.%s (id, name) VALUES (%s, 'max-rows-test-1');",
            DATASET, TEST_MAX_ROWS_TABLE, id1);
    String insertQuery2 =
        String.format(
            "INSERT INTO %s.%s (id, name) VALUES (%s, 'max-rows-test-2');",
            DATASET, TEST_MAX_ROWS_TABLE, id2);
    String selectQuery = String.format("SELECT id, name FROM %s.%s;", DATASET, TEST_MAX_ROWS_TABLE);

    boolean executeResult = bigQueryStatement.execute(createMaxRowsTable);
    assertFalse(executeResult);
    int rowsInserted = bigQueryStatement.executeUpdate(insertQuery1);
    assertEquals(1, rowsInserted);
    rowsInserted = bigQueryStatement.executeUpdate(insertQuery2);
    assertEquals(1, rowsInserted);

    bigQueryStatement.setMaxRows(1);
    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertNotNull(resultSet);
    assertEquals(1, resultSetRowCount(resultSet));

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TEST_MAX_ROWS_TABLE));
  }

  @Test
  public void testExecuteQueryWithoutSetMaxRows() throws SQLException {
    String TEST_MAX_ROWS_TABLE = "JDBC_TEST_MAX_ROWS_TABLE" + random.nextInt(99);
    int id1 = random.nextInt(99);
    int id2 = random.nextInt(99);
    String createMaxRowsTable =
        String.format(
            "CREATE OR REPLACE TABLE %s.%s (`id` INTEGER, `name` STRING);",
            DATASET, TEST_MAX_ROWS_TABLE);
    String insertQuery1 =
        String.format(
            "INSERT INTO %s.%s (id, name) VALUES (%s, 'max-rows-test-1');",
            DATASET, TEST_MAX_ROWS_TABLE, id1);
    String insertQuery2 =
        String.format(
            "INSERT INTO %s.%s (id, name) VALUES (%s, 'max-rows-test-2');",
            DATASET, TEST_MAX_ROWS_TABLE, id2);
    String selectQuery = String.format("SELECT id, name FROM %s.%s;", DATASET, TEST_MAX_ROWS_TABLE);

    boolean executeResult = bigQueryStatement.execute(createMaxRowsTable);
    assertFalse(executeResult);
    int rowsInserted = bigQueryStatement.executeUpdate(insertQuery1);
    assertEquals(1, rowsInserted);
    rowsInserted = bigQueryStatement.executeUpdate(insertQuery2);
    assertEquals(1, rowsInserted);

    ResultSet resultSet = bigQueryStatement.executeQuery(selectQuery);
    assertNotNull(resultSet);
    assertEquals(2, resultSetRowCount(resultSet));

    bigQueryStatement.execute(
        String.format("DROP TABLE IF EXISTS %S.%s", DATASET, TEST_MAX_ROWS_TABLE));
  }

  @Test
  public void testQueryPropertySessionIdIsUsedWithTransaction()
      throws SQLException, InterruptedException {
    // setup
    String sessionId = getSessionId();
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE" + random.nextInt(99);
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

    bigQueryStatement.execute(createTransactionTable);

    // Run the transaction
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";QueryProperties=session_id="
            + sessionId
            + ";";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
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
    assertEquals(5, resultsCount);

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
  public void testRollbackOnConnectionClosed() throws SQLException {
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE" + random.nextInt(99);
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

    bigQueryStatement.execute(createTransactionTable);
    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(session_enabled_connection_uri);
    connection.setAutoCommit(false);
    Statement statement = connection.createStatement();
    assertTrue(connection.isTransactionStarted());

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
  }

  @Test
  public void testSingleStatementTransaction() throws SQLException {
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE" + random.nextInt(99);
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
    assertEquals(5, resultsCount);

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
  public void testConnectionClosedRollsBackStartedTransactions() throws SQLException {
    String TRANSACTION_TABLE = "JDBC_TRANSACTION_TABLE" + random.nextInt(99);
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

    bigQueryStatement.execute(createTransactionTable);

    BigQueryConnection connection =
        (BigQueryConnection) DriverManager.getConnection(session_enabled_connection_uri);
    connection.setAutoCommit(false);
    Statement statement = connection.createStatement();
    assertTrue(connection.isTransactionStarted());

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
  }

  @Test
  public void testStatelessQueryPathSmall() throws SQLException {
    Properties jobCreationMode = new Properties();
    jobCreationMode.setProperty("JobCreationMode", "2");
    Connection bigQueryConnectionUseStateless =
        DriverManager.getConnection(connection_uri, jobCreationMode);

    Statement statement = bigQueryConnectionUseStateless.createStatement();

    String query =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT"
            + " 850";
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    assertEquals(850, resultSetRowCount(jsonResultSet));

    String queryEmpty =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT"
            + " 0";
    ResultSet jsonResultSetEmpty = statement.executeQuery(queryEmpty);
    assertTrue(jsonResultSetEmpty.getClass().getName().contains("BigQueryJsonResultSet"));
    assertEquals(0, resultSetRowCount(jsonResultSetEmpty));
    bigQueryConnectionUseStateless.close();
  }

  @Test
  public void testFastQueryPathMedium() throws SQLException {
    String query =
        "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 9000";
    ResultSet jsonResultSet = bigQueryStatement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    assertEquals(9000, resultSetRowCount(jsonResultSet));
  }

  @Test
  public void testFastQueryPathLarge() throws SQLException {
    String query =
        "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 18000";
    ResultSet jsonResultSet = bigQueryStatement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    assertEquals(18000, resultSetRowCount(jsonResultSet));
  }

  @Test
  // reads using ReadAPI and makes sure that they are in order, which implies threads worked
  // correctly
  public void testIterateOrderArrowMultiThread() throws SQLException {
    int expectedCnt = 200000;
    String longQuery = String.format(BASE_QUERY, expectedCnt);
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
  }

  @Test
  public void testNonEnabledUseLegacySQLThrowsSyntaxError() throws SQLException {
    // setup
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;"
            + "ProjectId="
            + PROJECT_ID
            + ";";
    String selectLegacyQuery =
        "SELECT * FROM [bigquery-public-data.deepmind_alphafold.metadata] LIMIT 20000000;";
    Driver driver = BigQueryDriver.getRegisteredDriver();
    Connection connection = driver.connect(connection_uri, new Properties());
    Statement statement = connection.createStatement();

    // act & assertion
    assertThrows(
        BigQueryJdbcSqlSyntaxErrorException.class, () -> statement.execute(selectLegacyQuery));
    connection.close();
  }

  @Test
  public void testFastQueryPathEmpty() throws SQLException {
    String query =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT"
            + " 0";
    ResultSet jsonResultSet = bigQueryStatement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    assertEquals(0, resultSetRowCount(jsonResultSet));
  }

  @Test
  public void testReadAPIPathLarge() throws SQLException {
    Properties withReadApi = new Properties();
    withReadApi.setProperty("EnableHighThroughputAPI", "1");
    withReadApi.setProperty("HighThroughputActivationRatio", "2");
    withReadApi.setProperty("HighThroughputMinTableSize", "1000");
    withReadApi.setProperty("MaxResults", "300");

    Connection connection = DriverManager.getConnection(connection_uri, withReadApi);
    Statement statement = connection.createStatement();
    int expectedCnt = 5000;
    String longQuery = String.format(BASE_QUERY, expectedCnt);
    ResultSet arrowResultSet = statement.executeQuery(longQuery);
    assertTrue(arrowResultSet.getClass().getName().contains("BigQueryArrowResultSet"));
    assertEquals(expectedCnt, resultSetRowCount(arrowResultSet));
    arrowResultSet.close();
    connection.close();
  }

  @Test
  public void testReadAPIPathLargeWithThresholdParameters() throws SQLException {
    String connectionUri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=3;MaxResults=300;HighThroughputActivationRatio=2;"
            + "HighThroughputMinTableSize=100;EnableHighThroughputAPI=1";
    Connection connection = DriverManager.getConnection(connectionUri);
    Statement statement = connection.createStatement();
    int expectedCnt = 1000;
    String longQuery = String.format(BASE_QUERY, expectedCnt);
    ResultSet arrowResultSet = statement.executeQuery(longQuery);
    assertTrue(arrowResultSet.getClass().getName().contains("BigQueryArrowResultSet"));
    assertEquals(expectedCnt, resultSetRowCount(arrowResultSet));
    arrowResultSet.close();
    connection.close();
  }

  @Test
  public void testReadAPIPathLargeWithThresholdNotMet() throws SQLException {
    String connectionUri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=3;HighThroughputActivationRatio=4;"
            + "HighThroughputMinTableSize=100;EnableHighThroughputAPI=1";
    Connection connection = DriverManager.getConnection(connectionUri);
    Statement statement = connection.createStatement();
    int expectedCnt = 5000;
    String longQuery = String.format(BASE_QUERY, expectedCnt);
    ResultSet arrowResultSet = statement.executeQuery(longQuery);
    assertTrue(arrowResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    assertEquals(expectedCnt, resultSetRowCount(arrowResultSet));
    arrowResultSet.close();
    connection.close();
  }

  private String getSessionId() throws InterruptedException {
    QueryJobConfiguration stubJobConfig =
        QueryJobConfiguration.newBuilder("Select 1;").setCreateSession(true).build();
    Job job = bigQuery.create(JobInfo.of(stubJobConfig));
    job = job.waitFor();
    Job stubJob = bigQuery.getJob(job.getJobId());
    return stubJob.getStatistics().getSessionInfo().getSessionId();
  }

  private int resultSetRowCount(ResultSet resultSet) throws SQLException {
    int rowCount = 0;
    while (resultSet.next()) {
      rowCount++;
    }
    return rowCount;
  }
}
