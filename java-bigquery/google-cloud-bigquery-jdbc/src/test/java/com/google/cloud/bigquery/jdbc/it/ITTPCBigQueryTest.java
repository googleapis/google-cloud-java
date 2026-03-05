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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.bigquery.jdbc.BigQueryConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;

public class ITTPCBigQueryTest {
  private static final String ENDPOINT_URL = System.getenv("ENDPOINT_URL");
  private static final String UNIVERSE_DOMAIN = System.getenv("UNIVERSE_DOMAIN");
  private static final String TPC_SERVICE_ACCOUNT = System.getenv("SERVICE_ACCOUNT");
  private static final String TPC_PVT_KEY = System.getenv("PRIVATE_KEY");
  private static final String TPC_ACCESS_TOKEN = System.getenv("ACCESS_TOKEN");
  private static final String TPC_PROJECT_ID = System.getenv("PROJECT_ID");

  private static final String TPC_ENDPOINT =
      (ENDPOINT_URL.isEmpty())
          ? "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443"
          : "jdbc:bigquery://" + ENDPOINT_URL;
  private static final String TPC_UNIVERSE_DOMAIN =
      (UNIVERSE_DOMAIN.isEmpty()) ? "googleapis.com" : UNIVERSE_DOMAIN;

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
        ((BigQueryConnection) connection).getAuthProperties().get("OAuthType"));
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
        ((BigQueryConnection) connection).getAuthProperties().get("OAuthType"));
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
        ((BigQueryConnection) connection).getAuthProperties().get("OAuthType"));
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
        ((BigQueryConnection) connection).getAuthProperties().get("OAuthType"));
    String query = "SELECT * FROM test.test;";
    Statement statement = connection.createStatement();
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    connection.close();
  }

  private void validateTPCEnvironment() {
    if (TPC_PROJECT_ID.isEmpty()) {
      throw new IllegalArgumentException("TPC_PROJECT_ID is empty");
    }
    if (TPC_SERVICE_ACCOUNT.isEmpty()) {
      throw new IllegalArgumentException("TPC_SERVICE_ACCOUNT is empty");
    }
    if (TPC_ENDPOINT.isEmpty()) {
      throw new IllegalArgumentException("TPC_ENDPOINT is empty");
    }
    if (TPC_PVT_KEY.isEmpty()) {
      throw new IllegalArgumentException("TPC_PVT_KEY is empty");
    }
    if (TPC_UNIVERSE_DOMAIN.isEmpty()) {
      throw new IllegalArgumentException("TPC_UNIVERSE_DOMAIN is empty");
    }
  }
}
