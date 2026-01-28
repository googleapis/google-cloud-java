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

import static com.google.common.truth.Truth.assertThat;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.jdbc.BigQueryConnection;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Properties;
import org.junit.Test;

public class ITPSCBigQueryTest {
  static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String SERVICE_ACCOUNT_EMAIL = requireEnvVar("SA_EMAIL");

  private static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
    return value;
  }

  @Test
  public void testNoOverrideTimesOut() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId="
            + PROJECT_ID
            + ";OAuthType=3;";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertEquals(
        "APPLICATION_DEFAULT_CREDENTIALS",
        ((BigQueryConnection) connection).getAuthProperties().get("OAuthType"));

    String query =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 850";
    Statement statement = connection.createStatement();
    assertThrows(BigQueryException.class, () -> statement.executeQuery(query));
  }

  @Test
  public void testValidADCAuthenticationInPSC() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId="
            + PROJECT_ID
            + ";OAuthType=3;"
            + "EndpointOverrides=BIGQUERY=https://bigquery-privateendpoint.p.googleapis.com;";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertEquals(
        "APPLICATION_DEFAULT_CREDENTIALS",
        ((BigQueryConnection) connection).getAuthProperties().get("OAuthType"));

    String query =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 850";
    Statement statement = connection.createStatement();
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    connection.close();
  }

  @Test
  public void testValidOAuthType2AuthenticationInPSC() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId="
            + PROJECT_ID
            + ";OAuthType=2;"
            + "OAuthAccessToken=RedactedToken;" // TODO(fahmz): see if there is a way to use SMS
            + "EndpointOverrides=BIGQUERY=https://bigquery-privateendpoint.p.googleapis.com;";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertEquals(
        "PRE_GENERATED_TOKEN",
        ((BigQueryConnection) connection).getAuthProperties().get("OAuthType"));

    String query =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 850";
    Statement statement = connection.createStatement();
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    connection.close();
  }

  @Test
  public void testValidServiceAccountAuthenticationKeyFileInPSC() throws SQLException, IOException {
    final String SERVICE_ACCOUNT_KEY = requireEnvVar("SA_SECRET");
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId="
            + PROJECT_ID
            + ";OAuthType=0;"
            + "OAuthPvtKeyPath="
            + SERVICE_ACCOUNT_KEY
            + "EndpointOverrides=BIGQUERY=https://bigquery-privateendpoint.p.googleapis.com,"
            + "OAuth2=https://oauth2-privateendpoint.p.googleapis.com/token;";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertEquals(
        "GOOGLE_SERVICE_ACCOUNT",
        ((BigQueryConnection) connection).getAuthProperties().get("OAuthType"));
    connection.close();
  }

  @Test
  public void testValidServiceAccountAuthenticationViaEmailInPSC() throws SQLException {
    final String SERVICE_ACCOUNT_KEY = requireEnvVar("SA_SECRET");
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId="
            + PROJECT_ID
            + ";OAuthType=0;"
            + "OAuthServiceAcctEmail="
            + SERVICE_ACCOUNT_EMAIL
            + ";OAuthPvtKey="
            + SERVICE_ACCOUNT_KEY
            + ";EndpointOverrides=BIGQUERY=https://bigquery-privateendpoint.p.googleapis.com,"
            + "OAuth2=https://oauth2-privateendpoint.p.googleapis.com/token;";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertEquals(
        "GOOGLE_SERVICE_ACCOUNT",
        ((BigQueryConnection) connection).getAuthProperties().get("OAuthType"));
    String query =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 850";
    Statement statement = connection.createStatement();
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    connection.close();
  }

  @Test
  public void testValidAllDataTypesSerializationFromSelectQueryInPSC() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId="
            + PROJECT_ID
            + ";OAuthType=0;"
            + "OAuthPvtKeyPath=.\\google-cloud-bigquery-jdbc\\secret.json;"
            + "EndpointOverrides=BIGQUERY=https://bigquery-privateendpoint.p.googleapis.com,"
            + "OAuth2=https://oauth2-privateendpoint.p.googleapis.com/token;";
    Connection bigQueryConnection = DriverManager.getConnection(connection_uri, new Properties());
    Statement bigQueryStatement = bigQueryConnection.createStatement();
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
    assertThat(expectedStruct.getAttributes()).isEqualTo(asList("Eric", 10).toArray());
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
  public void testValidAllDataTypesSerializationFromSelectQueryArrowDatasetInPSC()
      throws SQLException {
    String DATASET = "JDBC_INTEGRATION_DATASET";
    String TABLE_NAME = "JDBC_INTEGRATION_ARROW_TEST_TABLE";
    String selectQuery = "select * from " + DATASET + "." + TABLE_NAME;
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId="
            + PROJECT_ID
            + ";OAuthType=0;"
            + "OAuthPvtKeyPath=.\\google-cloud-bigquery-jdbc\\secret.json;;"
            + "EnableHighThroughputAPI=1;"
            + "EndpointOverrides=BIGQUERY=https://bigquery-privateendpoint.p.googleapis.com,"
            + "READ_API=bigquerystorage-privateendpoint.p.googleapis.com:443,"
            + "OAuth2=https://oauth2-privateendpoint.p.googleapis.com/token;";

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
    assertThat(expectedStruct.getAttributes()).isEqualTo(asList("Eric", 10).toArray());
    assertEquals("{\"v\":{\"f\":[{\"v\":\"Eric\"},{\"v\":\"10\"}]}}", expectedStruct.toString());
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

  @Test
  public void testValidExternalAccountAuthenticationInPSC() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=4;"
            + "BYOID_AudienceUri=//iam.googleapis.com/projects/<project>/locations/<location>/workloadIdentityPools/<pool>/providers/<provider>;"
            + "BYOID_SubjectTokenType=<type>;"
            + "BYOID_CredentialSource={\"file\":\"/path/to/file\"};"
            + "BYOID_SA_Impersonation_Uri=<sa>;"
            + "BYOID_TokenUri=<uri>;"
            + "EndpointOverrides=BIGQUERY=https://bigquery-privateendpoint.p.googleapis.com,"
            + "OAuth2=https://oauth2-privateendpoint.p.googleapis.com/token;";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertEquals(
        "EXTERNAL_ACCOUNT_AUTH",
        ((BigQueryConnection) connection).getAuthProperties().get("OAuthType"));

    Statement statement = connection.createStatement();
    ResultSet resultSet =
        statement.executeQuery(
            "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 50");

    assertNotNull(resultSet);
    connection.close();
  }
}
