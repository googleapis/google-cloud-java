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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.bigquery.jdbc.BigQueryConnection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.Test;

public class ITTPCBigQueryTest {
  private static final String ENDPOINT_URL = System.getenv("ENDPOINT_URL");
  private static final String UNIVERSE_DOMAIN = System.getenv("UNIVERSE_DOMAIN");
  private static final String TPC_SERVICE_ACCOUNT = System.getenv("SERVICE_ACCOUNT");
  private static final String TPC_PVT_KEY = System.getenv("PRIVATE_KEY");
  private static final String TPC_ACCESS_TOKEN = System.getenv("ACCESS_TOKEN");
  private static final String TPC_PROJECT_ID = System.getenv("PROJECT_ID");

  private static final String TPC_ENDPOINT =
      (ENDPOINT_URL == null || ENDPOINT_URL.isEmpty())
          ? "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443"
          : "jdbc:bigquery://" + ENDPOINT_URL;
  private static final String TPC_UNIVERSE_DOMAIN =
      (UNIVERSE_DOMAIN == null || UNIVERSE_DOMAIN.isEmpty()) ? "googleapis.com" : UNIVERSE_DOMAIN;

  // See here go/bq-cli-tpc for testing setup.
  // Use the default test project.
  // For the SA you will have to give it bigquery admin permissions cl/627813300 and will have to
  // revert after testing.
  // Plug in the values for the connection properties from the guide into the connection string.
  @Test
  public void testServiceAccountAuthenticationViaEmail() throws SQLException {
    validateTPCEnvironment();
    String connection_uri =
        TPC_ENDPOINT
            + ";"
            + "ProjectId="
            + TPC_PROJECT_ID
            + ";"
            + "OAuthType=0;"
            + "universeDomain="
            + TPC_UNIVERSE_DOMAIN
            + ";"
            + "OAuthServiceAcctEmail="
            + TPC_SERVICE_ACCOUNT
            + ";"
            + "OAuthPvtKey="
            + TPC_PVT_KEY
            + ";";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertEquals(
        "GOOGLE_SERVICE_ACCOUNT",
        connection.unwrap(BigQueryConnection.class).getAuthProperties().get("OAuthType"));
    String query = "SELECT 1";
    Statement statement = connection.createStatement();
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    connection.close();
  }

  // You will need to change the environment variable for GOOGLE_APPLICATION_CREDENTIALS to point to
  // the SA key file.
  @Test
  public void testValidApplicationDefaultCredentialsAuthentication() throws SQLException {
    validateTPCEnvironment();
    String connection_uri =
        TPC_ENDPOINT
            + ";"
            + "OAuthType=3;"
            + "ProjectId="
            + TPC_PROJECT_ID
            + ";"
            + "universeDomain="
            + TPC_UNIVERSE_DOMAIN
            + ";";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertEquals(
        "APPLICATION_DEFAULT_CREDENTIALS",
        connection.unwrap(BigQueryConnection.class).getAuthProperties().get("OAuthType"));
    String query = "SELECT * FROM test.test;";
    Statement statement = connection.createStatement();
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    connection.close();
  }

  @Test
  public void testValidPreGeneratedAccessTokenAuthentication() throws SQLException {
    validateTPCEnvironment();
    String connection_uri =
        TPC_ENDPOINT
            + ";"
            + "OAuthType=2;"
            + "ProjectId="
            + TPC_PROJECT_ID
            + ";"
            + "OAuthAccessToken="
            + TPC_ACCESS_TOKEN
            + ";"
            + "universeDomain="
            + TPC_UNIVERSE_DOMAIN
            + ";";

    Connection connection = DriverManager.getConnection(connection_uri);
    String query = "SELECT * FROM test.test;";
    Statement statement = connection.createStatement();
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    connection.close();
  }

  @Test
  public void testSimpleQueryReturns() throws SQLException {
    validateTPCEnvironment();
    String connection_uri =
        TPC_ENDPOINT
            + ";"
            + "ProjectId="
            + TPC_PROJECT_ID
            + ";"
            + "OAuthType=0;"
            + "universeDomain="
            + TPC_UNIVERSE_DOMAIN
            + ";"
            + "OAuthServiceAcctEmail="
            + TPC_SERVICE_ACCOUNT
            + ";"
            + "OAuthPvtKey="
            + TPC_PVT_KEY
            + ";"; // Plug in this value when testing from the key file

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertEquals(
        "GOOGLE_SERVICE_ACCOUNT",
        connection.unwrap(BigQueryConnection.class).getAuthProperties().get("OAuthType"));
    String query = "SELECT * FROM test.test;";
    Statement statement = connection.createStatement();
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    connection.close();
  }

  @Test
  public void testServiceAccountKeyFileReturns() throws SQLException {
    validateTPCEnvironment();
    String connection_uri =
        TPC_ENDPOINT
            + ";"
            + "ProjectId="
            + TPC_PROJECT_ID
            + ";"
            + "OAuthType=0;"
            + "universeDomain="
            + TPC_UNIVERSE_DOMAIN
            + ";"
            // Point the key path to where you have downloaded it to.
            + "OAuthPvtKeyPath=/Users/YourPathToSecretFile/SAKeyFile.json;";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertEquals(
        "GOOGLE_SERVICE_ACCOUNT",
        connection.unwrap(BigQueryConnection.class).getAuthProperties().get("OAuthType"));
    String query = "SELECT * FROM test.test;";
    Statement statement = connection.createStatement();
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    connection.close();
  }

  @Test
  public void testDatabaseMetadataOperationsInTPC() throws SQLException {
    validateTPCEnvironment();
    String connection_uri =
        TPC_ENDPOINT
            + ";"
            + "ProjectId="
            + TPC_PROJECT_ID
            + ";"
            + "OAuthType=0;"
            + "universeDomain="
            + TPC_UNIVERSE_DOMAIN
            + ";"
            + "OAuthServiceAcctEmail="
            + TPC_SERVICE_ACCOUNT
            + ";"
            + "OAuthPvtKey="
            + TPC_PVT_KEY
            + ";";

    String dataset = "INTEGRATION_TESTS";
    String pkTable = "IT_METADATA_PK_" + System.currentTimeMillis();
    String fkTable = "IT_METADATA_FK_" + System.currentTimeMillis();

    Connection connection = DriverManager.getConnection(connection_uri);
    Statement stmt = connection.createStatement();
    try {
      assertNotNull(connection);
      assertFalse(connection.isClosed());

      // Create test PK and FK tables
      stmt.execute(
          String.format(
              "CREATE OR REPLACE TABLE `%s.%s.%s` (id INT64, name STRING, PRIMARY KEY (id) NOT ENFORCED);",
              TPC_PROJECT_ID, dataset, pkTable));
      stmt.execute(
          String.format(
              "CREATE OR REPLACE TABLE `%s.%s.%s` (order_id INT64, pk_id INT64, PRIMARY KEY (order_id) NOT ENFORCED, CONSTRAINT fk_order FOREIGN KEY (pk_id) REFERENCES `%s.%s.%s`(id) NOT ENFORCED);",
              TPC_PROJECT_ID, dataset, fkTable, TPC_PROJECT_ID, dataset, pkTable));

      DatabaseMetaData metaData = connection.getMetaData();
      assertNotNull(metaData);

      // 1. Test getTables
      try (ResultSet rs = metaData.getTables(TPC_PROJECT_ID, dataset, pkTable, null)) {
        assertTrue(rs.next(), "Expected PK table to be returned by getTables");
        assertEquals(pkTable, rs.getString("TABLE_NAME"));
        assertFalse(rs.next());
      }

      // 2. Test getColumns
      try (ResultSet rs = metaData.getColumns(TPC_PROJECT_ID, dataset, pkTable, "id")) {
        assertTrue(rs.next(), "Expected id column to be returned by getColumns");
        assertEquals("id", rs.getString("COLUMN_NAME"));
        assertFalse(rs.next());
      }

      // 3. Test getPrimaryKeys
      try (ResultSet rs = metaData.getPrimaryKeys(TPC_PROJECT_ID, dataset, pkTable)) {
        assertTrue(rs.next(), "Expected primary key to be returned by getPrimaryKeys");
        assertEquals("id", rs.getString("COLUMN_NAME"));
        assertFalse(rs.next());
      }

      // 4. Test getImportedKeys
      try (ResultSet rs = metaData.getImportedKeys(TPC_PROJECT_ID, dataset, fkTable)) {
        assertTrue(rs.next(), "Expected foreign key to be returned by getImportedKeys");
        assertEquals(pkTable, rs.getString("PKTABLE_NAME"));
        assertEquals("id", rs.getString("PKCOLUMN_NAME"));
        assertEquals(fkTable, rs.getString("FKTABLE_NAME"));
        assertEquals("pk_id", rs.getString("FKCOLUMN_NAME"));
        assertEquals("fk_order", rs.getString("FK_NAME"));
        assertFalse(rs.next());
      }

      // 5. Test getExportedKeys
      try (ResultSet rs = metaData.getExportedKeys(TPC_PROJECT_ID, dataset, pkTable)) {
        assertTrue(rs.next(), "Expected exported foreign key to be returned by getExportedKeys");
        assertEquals(pkTable, rs.getString("PKTABLE_NAME"));
        assertEquals("id", rs.getString("PKCOLUMN_NAME"));
        assertEquals(fkTable, rs.getString("FKTABLE_NAME"));
        assertEquals("pk_id", rs.getString("FKCOLUMN_NAME"));
        assertEquals("fk_order", rs.getString("FK_NAME"));
        assertFalse(rs.next());
      }
    } finally {
      try {
        stmt.execute(
            String.format("DROP TABLE IF EXISTS `%s.%s.%s`;", TPC_PROJECT_ID, dataset, fkTable));
        stmt.execute(
            String.format("DROP TABLE IF EXISTS `%s.%s.%s`;", TPC_PROJECT_ID, dataset, pkTable));
      } finally {
        stmt.close();
        connection.close();
      }
    }
  }

  private void validateTPCEnvironment() {
    if (TPC_PROJECT_ID == null || TPC_PROJECT_ID.isEmpty()) {
      throw new IllegalArgumentException("TPC_PROJECT_ID is empty");
    }
    if (TPC_SERVICE_ACCOUNT == null || TPC_SERVICE_ACCOUNT.isEmpty()) {
      throw new IllegalArgumentException("TPC_SERVICE_ACCOUNT is empty");
    }
    if (TPC_ENDPOINT == null || TPC_ENDPOINT.isEmpty()) {
      throw new IllegalArgumentException("TPC_ENDPOINT is empty");
    }
    if (TPC_PVT_KEY == null || TPC_PVT_KEY.isEmpty()) {
      throw new IllegalArgumentException("TPC_PVT_KEY is empty");
    }
    if (TPC_UNIVERSE_DOMAIN == null || TPC_UNIVERSE_DOMAIN.isEmpty()) {
      throw new IllegalArgumentException("TPC_UNIVERSE_DOMAIN is empty");
    }
  }
}
