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
import static org.junit.Assert.assertTrue;

import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import org.junit.Test;

public class ITDriverTest {

  private static final String DEFAULT_CATALOG = ServiceOptions.getDefaultProjectId();
  static Random random = new Random();
  static int randomNumber = random.nextInt(999);
  String createDataset = "CREATE SCHEMA `%s.%s` OPTIONS(default_table_expiration_days = 5);";
  String createQuery =
      "CREATE OR REPLACE TABLE `%s.%s.%s` "
          + " (\n"
          + "`StringField` STRING,\n"
          + "`BytesField` BYTES,\n"
          + "`IntegerField` INTEGER"
          + ");";
  String insertQuery1 =
      "INSERT INTO `%s.%s.%s` "
          + " (StringField, BytesField,IntegerField) "
          + "VALUES('string1', CAST('string1' AS BYTES),111);";

  String selectQuery = "SELECT * FROM `%s.%s.%s` ;";

  @Test
  public void testGetDriverMethod() throws SQLException, InterruptedException {
    String OAUTH_TYPE = "3";
    String CONNECTION_URL =
        "jdbc:bigquery://https://bigquery.googleapis.com/bigquery/v2/:443;ProjectId="
            + DEFAULT_CATALOG
            + ";OAuthType="
            + OAUTH_TYPE
            + ";LOCATION=US;";

    String dataset = "JDBC_DRIVER_TEST_DATASET" + random.nextInt(999);
    String tableName = "JDBC_DRIVER_TEST_TABLE" + randomNumber;

    Driver driver = DriverManager.getDriver(CONNECTION_URL);

    Connection con = driver.connect(CONNECTION_URL, new Properties());
    assertTrue(driver.acceptsURL(CONNECTION_URL));
    assertFalse(driver.jdbcCompliant());
    assertEquals(1, driver.getMajorVersion());
    assertEquals(6, driver.getMinorVersion());

    Statement statement = con.createStatement();
    statement.execute(String.format(createDataset, DEFAULT_CATALOG, dataset));
    statement.execute(String.format(createQuery, DEFAULT_CATALOG, dataset, tableName));
    boolean insertResult =
        statement.execute(String.format(insertQuery1, DEFAULT_CATALOG, dataset, tableName));
    assertFalse(insertResult);
    statement.execute(String.format(selectQuery, DEFAULT_CATALOG, dataset, tableName));
    ResultSet res = statement.getResultSet();
    assertTrue(res.next());
    ITBase.cleanUp(dataset);
    con.close();
  }

  @Test
  public void testDriverLocation() throws SQLException, InterruptedException {

    String datasetUS = "JDBC_DRIVER_US_TEST_DATASET" + random.nextInt(999);
    String tableNameUS = "JDBC_DRIVER_US_TEST_TABLE" + randomNumber;
    String OAUTH_TYPE = "3";
    String CONNECTION_URL =
        "jdbc:bigquery://https://bigquery.googleapis.com/bigquery/v2/:443;ProjectId=%s;OAuthType=%s;LOCATION=%s;";

    // US Connection
    Connection connectionUS =
        DriverManager.getConnection(
            String.format(CONNECTION_URL, DEFAULT_CATALOG, OAUTH_TYPE, "us-east5"));
    Statement statementUS = connectionUS.createStatement();
    statementUS.execute(String.format(createDataset, DEFAULT_CATALOG, datasetUS));
    statementUS.execute(String.format(createQuery, DEFAULT_CATALOG, datasetUS, tableNameUS));
    boolean insertResult =
        statementUS.execute(String.format(insertQuery1, DEFAULT_CATALOG, datasetUS, tableNameUS));
    assertFalse(insertResult);
    statementUS.execute(String.format(selectQuery, DEFAULT_CATALOG, datasetUS, tableNameUS));
    ResultSet res = statementUS.getResultSet();
    assertTrue(res.next());

    BigQuery bigQuery = BigQueryOptions.getDefaultInstance().getService();
    Dataset retrievedDataset = bigQuery.getDataset(DatasetId.of(DEFAULT_CATALOG, datasetUS));
    assertEquals("us-east5", retrievedDataset.getLocation());
    ITBase.cleanUp(datasetUS);
    connectionUS.close();
  }
}
