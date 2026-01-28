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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlSyntaxErrorException;
import com.google.cloud.bigquery.jdbc.BigQueryConnection;
import com.google.cloud.bigquery.jdbc.BigQueryDriver;
import com.google.cloud.bigquery.jdbc.DataSource;
import com.google.cloud.bigquery.jdbc.PooledConnectionDataSource;
import com.google.cloud.bigquery.jdbc.PooledConnectionListener;
import com.google.cloud.bigquery.jdbc.utils.TestUtilities.TestConnectionListener;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
import java.sql.Types;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;
import javax.sql.PooledConnection;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ITBigQueryJDBCTest extends ITBase {
  static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  static Connection bigQueryConnection;
  static BigQuery bigQuery;
  static Statement bigQueryStatement;
  static Connection bigQueryConnectionNoReadApi;
  static Statement bigQueryStatementNoReadApi;
  static final String connection_uri =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
          + PROJECT_ID
          + ";OAUTHTYPE=3";
  static final String session_enabled_connection_uri =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
          + PROJECT_ID
          + ";OAUTHTYPE=3;EnableSession=1";
  private static final String BASE_QUERY =
      "SELECT * FROM bigquery-public-data.new_york_taxi_trips.tlc_yellow_trips_2017 order by"
          + " trip_distance asc LIMIT %s";
  private static final Random random = new Random();
  private static final int randomNumber = random.nextInt(9999);
  private static final String DATASET = "JDBC_PRESUBMIT_INTEGRATION_DATASET";
  private static final String DATASET2 = "JDBC_PRESUBMIT_INTEGRATION_DATASET_2";
  private static final String CONSTRAINTS_DATASET = "JDBC_CONSTRAINTS_TEST_DATASET";
  private static final String CONSTRAINTS_TABLE_NAME = "JDBC_CONSTRAINTS_TEST_TABLE";
  private static final String CONSTRAINTS_TABLE_NAME2 = "JDBC_CONSTRAINTS_TEST_TABLE2";
  private static final String CONSTRAINTS_TABLE_NAME3 = "JDBC_CONSTRAINTS_TEST_TABLE3";
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
  private static final Long DEFAULT_CONN_POOL_SIZE = 10L;
  private static final Long CUSTOM_CONN_POOL_SIZE = 5L;
  private static final Object EXCEPTION_REPLACEMENT = "EXCEPTION-WAS-RAISED";

  private static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
    return value;
  }

  private JsonObject getAuthJson() throws IOException {
    final String secret = requireEnvVar("SA_SECRET");
    JsonObject authJson;
    // Supporting both formats of SA_SECRET:
    // - Local runs can point to a json file
    // - Cloud Build has JSON value
    try {
      InputStream stream = Files.newInputStream(Paths.get(secret));
      InputStreamReader reader = new InputStreamReader(stream);
      authJson = JsonParser.parseReader(reader).getAsJsonObject();
    } catch (IOException e) {
      authJson = JsonParser.parseString(secret).getAsJsonObject();
    }
    assertTrue(authJson.has("client_email"));
    assertTrue(authJson.has("private_key"));
    assertTrue(authJson.has("project_id"));
    return authJson;
  }

  private void validateConnection(String connection_uri) throws SQLException {
    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertEquals(
        "GOOGLE_SERVICE_ACCOUNT",
        ((BigQueryConnection) connection).getAuthProperties().get("OAuthType"));
    String query =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT"
            + " 850";
    Statement statement = connection.createStatement();
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));
    connection.close();
  }

  @BeforeClass
  public static void beforeClass() throws SQLException {
    bigQueryConnection = DriverManager.getConnection(connection_uri, new Properties());
    bigQueryStatement = bigQueryConnection.createStatement();

    Properties noReadApi = new Properties();
    noReadApi.setProperty("EnableHighThroughputAPI", "0");
    bigQueryConnectionNoReadApi = DriverManager.getConnection(connection_uri, noReadApi);
    bigQueryStatementNoReadApi = bigQueryConnectionNoReadApi.createStatement();
    bigQuery = BigQueryOptions.newBuilder().build().getService();
  }

  @AfterClass
  public static void afterClass() throws SQLException {
    bigQueryStatement.close();
    bigQueryConnection.close();
    bigQueryStatementNoReadApi.close();
    bigQueryConnectionNoReadApi.close();
  }

  @Test
  public void testValidServiceAccountAuthentication() throws SQLException, IOException {
    final JsonObject authJson = getAuthJson();
    File tempFile = File.createTempFile("auth", ".json");
    tempFile.deleteOnExit();
    Files.write(tempFile.toPath(), authJson.toString().getBytes());

    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId="
            + authJson.get("project_id").getAsString()
            + ";OAuthType=0;"
            + "OAuthPvtKeyPath="
            + tempFile.toPath()
            + ";";

    validateConnection(connection_uri);
  }

  @Test
  public void testServiceAccountAuthenticationMissingOAuthPvtKeyPath() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId="
            + PROJECT_ID
            + ";OAuthType=0;";

    try {
      DriverManager.getConnection(connection_uri);
      Assert.fail();
    } catch (BigQueryJdbcRuntimeException ex) {
      assertTrue(ex.getMessage().contains("No valid credentials provided."));
    }
  }

  @Test
  public void testValidServiceAccountAuthenticationOAuthPvtKeyAsPath()
      throws SQLException, IOException {
    final JsonObject authJson = getAuthJson();
    File tempFile = File.createTempFile("auth", ".json");
    tempFile.deleteOnExit();
    Files.write(tempFile.toPath(), authJson.toString().getBytes());

    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId="
            + authJson.get("project_id").getAsString()
            + ";OAuthType=0;"
            + "OAuthServiceAcctEmail=;"
            + ";OAuthPvtKey="
            + tempFile.toPath()
            + ";";
    validateConnection(connection_uri);
  }

  @Test
  public void testValidServiceAccountAuthenticationViaEmailAndPkcs8Key()
      throws SQLException, IOException {
    final JsonObject authJson = getAuthJson();

    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId="
            + authJson.get("project_id").getAsString()
            + ";OAuthType=0;"
            + "OAuthServiceAcctEmail="
            + authJson.get("client_email").getAsString()
            + ";OAuthPvtKey="
            + authJson.get("private_key").getAsString()
            + ";";
    validateConnection(connection_uri);
  }

  @Test
  public void testValidServiceAccountAuthenticationOAuthPvtKeyAsJson()
      throws SQLException, IOException {
    final JsonObject authJson = getAuthJson();

    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId="
            + authJson.get("project_id").getAsString()
            + ";OAuthType=0;"
            + "OAuthServiceAcctEmail=;"
            + ";OAuthPvtKey="
            + authJson.toString()
            + ";";
    validateConnection(connection_uri);
  }

  // TODO(kirl): Enable this test when pipeline has p12 secret available.
  @Test
  @Ignore
  public void testValidServiceAccountAuthenticationP12() throws SQLException, IOException {
    final JsonObject authJson = getAuthJson();
    final String p12_file = requireEnvVar("SA_SECRET_P12");

    final String connectionUri =
        getBaseUri(0, authJson.get("project_id").getAsString())
            .append("OAuthServiceAcctEmail", authJson.get("client_email").getAsString())
            .append("OAuthPvtKeyPath", p12_file)
            .toString();
    validateConnection(connectionUri);
  }

  @Test
  @Ignore
  public void testValidGoogleUserAccountAuthentication() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAuthType=1;OAuthClientId=client_id;OAuthClientSecret=client_secret;";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertEquals(
        "GOOGLE_USER_ACCOUNT",
        ((BigQueryConnection) connection).getAuthProperties().get("OAuthType"));

    Statement statement = connection.createStatement();
    ResultSet resultSet =
        statement.executeQuery(
            "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 50");

    assertEquals(50, resultSetRowCount(resultSet));
    connection.close();
  }

  @Test
  @Ignore
  public void testValidExternalAccountAuthentication() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=4;"
            + "BYOID_AudienceUri=//iam.googleapis.com/projects/<project>/locations/<location>/workloadIdentityPools/<pool>/providers/<provider>;"
            + "BYOID_SubjectTokenType=<type>;BYOID_CredentialSource={\"file\":\"/path/to/file\"};"
            + "BYOID_SA_Impersonation_Uri=<sa>;BYOID_TokenUri=<uri>;";

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

    assertEquals(50, resultSetRowCount(resultSet));
    connection.close();
  }

  @Test
  @Ignore
  public void testValidExternalAccountAuthenticationFromFile() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=4;"
            + "OAuthPvtKeyPath=/path/to/file;";

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

    assertEquals(50, resultSetRowCount(resultSet));
    connection.close();
  }

  @Test
  @Ignore
  public void testValidExternalAccountAuthenticationRawJson() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=4;OAuthPvtKey={\n"
            + "  \"universe_domain\": \"googleapis.com\",\n"
            + "  \"type\": \"external_account\",\n"
            + "  \"audience\":"
            + " \"//iam.googleapis.com/projects/<project>/locations/<location>/workloadIdentityPools/<pool>/providers/<provider>\",\n"
            + "  \"subject_token_type\": \"<type>\",\n"
            + "  \"token_url\": \"<url>\",\n"
            + "  \"credential_source\": {\n"
            + "    \"file\": \"/path/to/file\"\n"
            + "  },\n"
            + "  \"service_account_impersonation_url\": \"<sa>\"\n"
            + "};";

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

    assertEquals(50, resultSetRowCount(resultSet));
    connection.close();
  }

  // TODO(farhan): figure out how to programmatically generate an access token and test
  @Test
  @Ignore
  public void testValidPreGeneratedAccessTokenAuthentication() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=2;OAuthAccessToken=access_token;";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertEquals(
        "PRE_GENERATED_TOKEN",
        ((BigQueryConnection) connection).getAuthProperties().get("OAuthType"));

    Statement statement = connection.createStatement();
    ResultSet resultSet =
        statement.executeQuery(
            "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 50");

    assertEquals(50, resultSetRowCount(resultSet));
    connection.close();
  }

  // TODO(obada): figure out how to programmatically generate a refresh token and test
  @Test
  @Ignore
  public void testValidRefreshTokenAuthentication() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=2;OAuthRefreshToken=refresh_token;"
            + ";OAuthClientId=client;OAuthClientSecret=secret;";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertEquals(
        "PRE_GENERATED_TOKEN",
        ((BigQueryConnection) connection).getAuthProperties().get("OAuthType"));

    Statement statement = connection.createStatement();
    ResultSet resultSet =
        statement.executeQuery(
            "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 50");

    assertEquals(50, resultSetRowCount(resultSet));
    connection.close();
  }

  @Test
  public void testValidApplicationDefaultCredentialsAuthentication() throws SQLException {
    String connection_uri = getBaseUri(3, PROJECT_ID).toString();

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertEquals(
        "APPLICATION_DEFAULT_CREDENTIALS",
        ((BigQueryConnection) connection).getAuthProperties().get("OAuthType"));
    connection.close();
  }

  // This test is useing the same client email as a main authorization & impersonation.
  // It requires account to have 'tokenCreator' permission, see
  // https://cloud.google.com/docs/authentication/use-service-account-impersonation#required-roles
  @Test
  public void testServiceAccountAuthenticationWithImpersonation() throws IOException, SQLException {
    final JsonObject authJson = getAuthJson();

    String connection_uri =
        getBaseUri(0, authJson.get("project_id").getAsString())
            .append("OAuthServiceAcctEmail", authJson.get("client_email").getAsString())
            .append("OAuthPvtKey", authJson.get("private_key").getAsString())
            .append("ServiceAccountImpersonationEmail", authJson.get("client_email").getAsString())
            .toString();
    validateConnection(connection_uri);
  }

  // This test uses the same client email for the main authorization and a chain of impersonations.
  // It requires the account to have 'tokenCreator' permission on itself.
  @Test
  public void testServiceAccountAuthenticationWithChainedImpersonation()
      throws IOException, SQLException {
    final JsonObject authJson = getAuthJson();
    String clientEmail = authJson.get("client_email").getAsString();

    String connection_uri =
        getBaseUri(0, authJson.get("project_id").getAsString())
            .append("OAuthServiceAcctEmail", clientEmail)
            .append("OAuthPvtKey", authJson.get("private_key").getAsString())
            .append("ServiceAccountImpersonationEmail", clientEmail)
            .append("ServiceAccountImpersonationChain", clientEmail + "," + clientEmail)
            .toString();
    validateConnection(connection_uri);
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
  public void testInvalidQuery() throws SQLException {
    String query = "SELECT *";

    try {
      bigQueryStatement.executeQuery(query);
      Assert.fail();
    } catch (BigQueryJdbcException e) {
      assertTrue(e.getMessage().contains("SELECT * must have a FROM clause"));
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
    assertEquals(0, ds.getOAuthType());
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
  public void testTableConstraints() throws SQLException {
    ResultSet primaryKey1 =
        bigQueryConnection
            .getMetaData()
            .getPrimaryKeys(PROJECT_ID, CONSTRAINTS_DATASET, CONSTRAINTS_TABLE_NAME);
    primaryKey1.next();
    assertEquals("id", primaryKey1.getString(4));
    assertFalse(primaryKey1.next());

    ResultSet primaryKey2 =
        bigQueryConnection
            .getMetaData()
            .getPrimaryKeys(PROJECT_ID, CONSTRAINTS_DATASET, CONSTRAINTS_TABLE_NAME2);
    primaryKey2.next();
    assertEquals("first_name", primaryKey2.getString(4));
    primaryKey2.next();
    assertEquals("last_name", primaryKey2.getString(4));
    assertFalse(primaryKey2.next());

    ResultSet foreignKeys =
        bigQueryConnection
            .getMetaData()
            .getImportedKeys(PROJECT_ID, CONSTRAINTS_DATASET, CONSTRAINTS_TABLE_NAME);
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
        bigQueryConnection
            .getMetaData()
            .getCrossReference(
                PROJECT_ID,
                CONSTRAINTS_DATASET,
                CONSTRAINTS_TABLE_NAME2,
                PROJECT_ID,
                CONSTRAINTS_DATASET,
                CONSTRAINTS_TABLE_NAME);
    crossReference.next();
    assertEquals(CONSTRAINTS_TABLE_NAME2, crossReference.getString(3));
    assertEquals("first_name", crossReference.getString(4));
    assertEquals("name", crossReference.getString(8));
    crossReference.next();
    assertEquals("last_name", crossReference.getString(4));
    assertEquals("second_name", crossReference.getString(8));
    assertFalse(crossReference.next());
  }

  @Test
  public void testDatabaseMetadataGetCatalogs() throws SQLException {
    DatabaseMetaData databaseMetaData = bigQueryConnection.getMetaData();
    try (ResultSet rs = databaseMetaData.getCatalogs()) {
      assertNotNull("ResultSet from getCatalogs() should not be null", rs);

      ResultSetMetaData rsmd = rs.getMetaData();
      assertNotNull("ResultSetMetaData should not be null", rsmd);
      assertEquals("Should have one column", 1, rsmd.getColumnCount());
      assertEquals("Column name should be TABLE_CAT", "TABLE_CAT", rsmd.getColumnName(1));

      assertTrue("ResultSet should have one row", rs.next());
      assertEquals("Catalog name should match Project ID", PROJECT_ID, rs.getString("TABLE_CAT"));
      assertFalse("ResultSet should have no more rows", rs.next());
    }
  }

  @Test
  public void testDatabaseMetadataGetProcedures() throws SQLException {
    String DATASET = "JDBC_INTEGRATION_DATASET";
    String procedureName = "create_customer";
    DatabaseMetaData databaseMetaData = bigQueryConnection.getMetaData();
    ResultSet resultSet = databaseMetaData.getProcedures(PROJECT_ID, DATASET, procedureName);
    while (resultSet.next()) {
      assertEquals(PROJECT_ID, resultSet.getString("PROCEDURE_CAT"));
      assertEquals(DATASET, resultSet.getString("PROCEDURE_SCHEM"));
      assertEquals(procedureName, resultSet.getString("PROCEDURE_NAME"));
      assertEquals(procedureName, resultSet.getString("SPECIFIC_NAME"));
      assertEquals(DatabaseMetaData.procedureResultUnknown, resultSet.getInt("PROCEDURE_TYPE"));
    }
  }

  @Test
  public void testDatabaseMetadataGetProcedureColumns() throws SQLException {
    DatabaseMetaData databaseMetaData = bigQueryConnection.getMetaData();

    // --- Test Case 1: Specific schema and procedure, null column name pattern ---
    String specificSchema = "JDBC_INTEGRATION_DATASET";
    String specificProcedure = "create_customer";
    ResultSet resultSet =
        databaseMetaData.getProcedureColumns(PROJECT_ID, specificSchema, specificProcedure, null);
    int specificProcRows = 0;
    boolean foundNameParam = false;
    boolean foundIdParam = false;
    while (resultSet.next()) {
      specificProcRows++;
      assertEquals(PROJECT_ID, resultSet.getString("PROCEDURE_CAT"));
      assertEquals(specificSchema, resultSet.getString("PROCEDURE_SCHEM"));
      assertEquals(specificProcedure, resultSet.getString("PROCEDURE_NAME"));
      assertEquals(specificProcedure, resultSet.getString("SPECIFIC_NAME"));
      if ("name".equals(resultSet.getString("COLUMN_NAME"))) {
        foundNameParam = true;
        assertEquals(1, resultSet.getInt("ORDINAL_POSITION"));
      }
      if ("id".equals(resultSet.getString("COLUMN_NAME"))) {
        foundIdParam = true;
        assertEquals(2, resultSet.getInt("ORDINAL_POSITION"));
      }
    }
    assertEquals("Should find 2 parameters for " + specificProcedure, 2, specificProcRows);
    assertTrue("Parameter 'name' should be found", foundNameParam);
    assertTrue("Parameter 'id' should be found", foundIdParam);
    resultSet.close();

    // --- Test Case 2: Specific schema, procedure, and column name pattern ---
    String specificColumn = "name";
    resultSet =
        databaseMetaData.getProcedureColumns(
            PROJECT_ID, specificSchema, specificProcedure, specificColumn);
    assertTrue("Should find the specific column 'name'", resultSet.next());
    assertEquals(PROJECT_ID, resultSet.getString("PROCEDURE_CAT"));
    assertEquals(specificSchema, resultSet.getString("PROCEDURE_SCHEM"));
    assertEquals(specificProcedure, resultSet.getString("PROCEDURE_NAME"));
    assertEquals(specificColumn, resultSet.getString("COLUMN_NAME"));
    assertEquals(1, resultSet.getInt("ORDINAL_POSITION"));
    assertEquals(
        (short) DatabaseMetaData.procedureColumnUnknown, resultSet.getShort("COLUMN_TYPE"));
    assertEquals(java.sql.Types.NVARCHAR, resultSet.getInt("DATA_TYPE"));
    assertEquals("NVARCHAR", resultSet.getString("TYPE_NAME"));
    assertFalse("Should only find one row for exact column match", resultSet.next());
    resultSet.close();

    // --- Test Case 3: Non-existent procedure ---
    resultSet =
        databaseMetaData.getProcedureColumns(
            PROJECT_ID, specificSchema, "non_existent_procedure_xyz", null);
    assertFalse("Should not find columns for a non-existent procedure", resultSet.next());
    resultSet.close();
  }

  @Test
  public void testDatabaseMetadataGetColumns() throws SQLException {
    String DATASET = "JDBC_INTEGRATION_DATASET";
    String TABLE_NAME = "JDBC_DATATYPES_INTEGRATION_TEST_TABLE";
    DatabaseMetaData databaseMetaData = bigQueryConnection.getMetaData();

    // --- Test Case 1: Specific Column (StringField) ---
    ResultSet resultSet =
        databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "StringField");

    assertTrue(resultSet.next());
    assertEquals(PROJECT_ID, resultSet.getString("TABLE_CAT"));
    assertEquals(DATASET, resultSet.getString("TABLE_SCHEM"));
    assertEquals(TABLE_NAME, resultSet.getString("TABLE_NAME"));
    assertEquals("StringField", resultSet.getString("COLUMN_NAME"));
    assertEquals("NVARCHAR", resultSet.getString("TYPE_NAME"));
    resultSet.getObject("COLUMN_SIZE");
    assertTrue(resultSet.wasNull());
    resultSet.getObject("DECIMAL_DIGITS");
    assertTrue(resultSet.wasNull());
    assertEquals(1, resultSet.getInt("NULLABLE"));
    assertEquals(6, resultSet.getInt("ORDINAL_POSITION"));
    assertFalse(resultSet.next());

    // --- Test Case 2: All Columns ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, null);
    assertTrue(resultSet.next());
    int count = 0;
    do {
      count++;
      assertEquals(PROJECT_ID, resultSet.getString("TABLE_CAT"));
      assertEquals(DATASET, resultSet.getString("TABLE_SCHEM"));
      assertEquals(TABLE_NAME, resultSet.getString("TABLE_NAME"));
      assertNotNull(resultSet.getString("COLUMN_NAME"));
    } while (resultSet.next());
    assertEquals(16, count);

    // --- Test Case 3: Column Name Pattern Matching (%Field) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "%Time%");
    assertTrue(resultSet.next());
    count = 0;
    do {
      count++;
      String columnName = resultSet.getString("COLUMN_NAME");
      assertTrue(columnName.contains("Time"));
    } while (resultSet.next());
    assertEquals(3, count);

    // --- Test Case 4: Column Name Pattern Matching (Integer%) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "Integer%");
    assertTrue(resultSet.next());
    assertEquals("IntegerField", resultSet.getString("COLUMN_NAME"));
    assertEquals("BIGINT", resultSet.getString("TYPE_NAME"));
    assertEquals(19, resultSet.getInt("COLUMN_SIZE"));
    assertEquals(0, resultSet.getInt("DECIMAL_DIGITS"));
    assertEquals(10, resultSet.getInt("NUM_PREC_RADIX"));
    assertEquals(1, resultSet.getInt("NULLABLE"));
    assertEquals(2, resultSet.getInt("ORDINAL_POSITION"));
    assertFalse(resultSet.next());

    // --- Test Case 5: Specific Column (BooleanField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "BooleanField");
    assertTrue(resultSet.next());
    assertEquals("BooleanField", resultSet.getString("COLUMN_NAME"));
    assertEquals("BOOLEAN", resultSet.getString("TYPE_NAME"));
    assertEquals(1, resultSet.getInt("COLUMN_SIZE"));
    resultSet.getObject("DECIMAL_DIGITS");
    assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    assertTrue(resultSet.wasNull());
    assertEquals(1, resultSet.getInt("NULLABLE"));
    assertEquals(1, resultSet.getInt("ORDINAL_POSITION"));
    assertFalse(resultSet.next());

    // --- Test Case 6: Specific Column (NumericField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "NumericField");
    assertTrue(resultSet.next());
    assertEquals("NumericField", resultSet.getString("COLUMN_NAME"));
    assertEquals("NUMERIC", resultSet.getString("TYPE_NAME"));
    assertEquals(38, resultSet.getInt("COLUMN_SIZE"));
    assertEquals(9, resultSet.getInt("DECIMAL_DIGITS"));
    assertEquals(10, resultSet.getInt("NUM_PREC_RADIX"));
    assertEquals(1, resultSet.getInt("NULLABLE"));
    assertEquals(4, resultSet.getInt("ORDINAL_POSITION"));
    assertFalse(resultSet.next());

    // --- Test Case 7: Specific Column (BytesField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "BytesField");
    assertTrue(resultSet.next());
    assertEquals("BytesField", resultSet.getString("COLUMN_NAME"));
    assertEquals("VARBINARY", resultSet.getString("TYPE_NAME"));
    resultSet.getObject("COLUMN_SIZE");
    assertTrue(resultSet.wasNull());
    resultSet.getObject("DECIMAL_DIGITS");
    assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    assertTrue(resultSet.wasNull());
    assertEquals(1, resultSet.getInt("NULLABLE"));
    assertEquals(7, resultSet.getInt("ORDINAL_POSITION"));
    assertFalse(resultSet.next());

    // --- Test Case 8: Specific Column (ArrayField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "ArrayField");
    assertTrue(resultSet.next());
    assertEquals("ArrayField", resultSet.getString("COLUMN_NAME"));
    assertEquals("ARRAY", resultSet.getString("TYPE_NAME"));
    resultSet.getObject("COLUMN_SIZE");
    assertTrue(resultSet.wasNull());
    resultSet.getObject("DECIMAL_DIGITS");
    assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    assertTrue(resultSet.wasNull());
    assertEquals(1, resultSet.getInt("NULLABLE"));
    assertEquals(9, resultSet.getInt("ORDINAL_POSITION"));
    assertFalse(resultSet.next());

    // --- Test Case 9: Specific Column (TimestampField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "TimestampField");
    assertTrue(resultSet.next());
    assertEquals("TimestampField", resultSet.getString("COLUMN_NAME"));
    assertEquals("TIMESTAMP", resultSet.getString("TYPE_NAME"));
    assertEquals(29, resultSet.getInt("COLUMN_SIZE"));
    resultSet.getObject("DECIMAL_DIGITS");
    assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    assertTrue(resultSet.wasNull());
    assertEquals(1, resultSet.getInt("NULLABLE"));
    assertEquals(10, resultSet.getInt("ORDINAL_POSITION"));
    assertFalse(resultSet.next());

    // --- Test Case 10: Specific Column (DateField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "DateField");
    assertTrue(resultSet.next());
    assertEquals("DateField", resultSet.getString("COLUMN_NAME"));
    assertEquals("DATE", resultSet.getString("TYPE_NAME"));
    assertEquals(10, resultSet.getInt("COLUMN_SIZE"));
    resultSet.getObject("DECIMAL_DIGITS");
    assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    assertTrue(resultSet.wasNull());
    assertEquals(1, resultSet.getInt("NULLABLE"));
    assertEquals(11, resultSet.getInt("ORDINAL_POSITION"));
    assertFalse(resultSet.next());

    // --- Test Case 11: Specific Column (TimeField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "TimeField");
    assertTrue(resultSet.next());
    assertEquals("TimeField", resultSet.getString("COLUMN_NAME"));
    assertEquals("TIME", resultSet.getString("TYPE_NAME"));
    assertEquals(15, resultSet.getInt("COLUMN_SIZE"));
    resultSet.getObject("DECIMAL_DIGITS");
    assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    assertTrue(resultSet.wasNull());
    assertEquals(1, resultSet.getInt("NULLABLE"));
    assertEquals(12, resultSet.getInt("ORDINAL_POSITION"));
    assertFalse(resultSet.next());

    // --- Test Case 12: Specific Column (DateTimeField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "DateTimeField");
    assertTrue(resultSet.next());
    assertEquals("DateTimeField", resultSet.getString("COLUMN_NAME"));
    assertEquals("TIMESTAMP", resultSet.getString("TYPE_NAME"));
    assertEquals(29, resultSet.getInt("COLUMN_SIZE"));
    resultSet.getObject("DECIMAL_DIGITS");
    assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    assertTrue(resultSet.wasNull());
    assertEquals(1, resultSet.getInt("NULLABLE"));
    assertEquals(13, resultSet.getInt("ORDINAL_POSITION"));
    assertFalse(resultSet.next());

    // --- Test Case 13: Specific Column (GeographyField) ---
    resultSet = databaseMetaData.getColumns(PROJECT_ID, DATASET, TABLE_NAME, "GeographyField");
    assertTrue(resultSet.next());
    assertEquals("GeographyField", resultSet.getString("COLUMN_NAME"));
    assertEquals("VARCHAR", resultSet.getString("TYPE_NAME"));
    resultSet.getObject("COLUMN_SIZE");
    assertTrue(resultSet.wasNull());
    resultSet.getObject("DECIMAL_DIGITS");
    assertTrue(resultSet.wasNull());
    resultSet.getObject("NUM_PREC_RADIX");
    assertTrue(resultSet.wasNull());
    assertEquals(1, resultSet.getInt("NULLABLE"));
    assertEquals(14, resultSet.getInt("ORDINAL_POSITION"));
    assertFalse(resultSet.next());
  }

  @Test
  public void testDatabaseMetadataGetTables() throws SQLException {
    DatabaseMetaData databaseMetaData = bigQueryConnection.getMetaData();
    String DATASET = "JDBC_TABLE_TYPES_TEST";

    // --- Test Case 1: Get all tables (types = null) ---
    ResultSet rsAll = databaseMetaData.getTables(PROJECT_ID, DATASET, null, null);
    Set<String> allTableNames = new HashSet<>();
    while (rsAll.next()) {
      allTableNames.add(rsAll.getString("TABLE_NAME"));
    }
    assertTrue(allTableNames.contains("base_table"));
    assertTrue(allTableNames.contains("my_view"));
    assertTrue(allTableNames.contains("external_table"));
    assertTrue(allTableNames.contains("my_materialized_view"));
    assertTrue(allTableNames.contains("base_table_clone"));
    assertTrue(allTableNames.contains("base_table_snapshot"));
    assertEquals(6, allTableNames.size());

    // --- Test Case 2: Get only "TABLE" type ---
    ResultSet rsTable =
        databaseMetaData.getTables(PROJECT_ID, DATASET, null, new String[] {"TABLE"});
    Set<String> tableNames = new HashSet<>();
    while (rsTable.next()) {
      tableNames.add(rsTable.getString("TABLE_NAME"));
    }
    assertTrue(tableNames.contains("base_table"));
    assertTrue(tableNames.contains("base_table_clone"));
    assertEquals(2, tableNames.size());

    // --- Test Case 3: Get "VIEW" type ---
    ResultSet rsView = databaseMetaData.getTables(PROJECT_ID, DATASET, null, new String[] {"VIEW"});
    assertTrue(rsView.next());
    assertEquals("my_view", rsView.getString("TABLE_NAME"));
    assertEquals("VIEW", rsView.getString("TABLE_TYPE"));
    assertFalse(rsView.next());

    // --- Test Case 4: Get "EXTERNAL TABLE" type ---
    ResultSet rsExternal =
        databaseMetaData.getTables(PROJECT_ID, DATASET, null, new String[] {"EXTERNAL"});
    assertTrue(rsExternal.next());
    assertEquals("external_table", rsExternal.getString("TABLE_NAME"));
    assertEquals("EXTERNAL", rsExternal.getString("TABLE_TYPE"));
    assertFalse(rsExternal.next());

    // --- Test Case 5: Get "MATERIALIZED_VIEW" type ---
    ResultSet rsMaterialized =
        databaseMetaData.getTables(PROJECT_ID, DATASET, null, new String[] {"MATERIALIZED_VIEW"});
    assertTrue(rsMaterialized.next());
    assertEquals("my_materialized_view", rsMaterialized.getString("TABLE_NAME"));
    assertEquals("MATERIALIZED_VIEW", rsMaterialized.getString("TABLE_TYPE"));
    assertFalse(rsMaterialized.next());

    // --- Test Case 6: Get "SNAPSHOT" type ---
    ResultSet rsSnapshot =
        databaseMetaData.getTables(PROJECT_ID, DATASET, null, new String[] {"SNAPSHOT"});
    assertTrue(rsSnapshot.next());
    assertEquals("base_table_snapshot", rsSnapshot.getString("TABLE_NAME"));
    assertEquals("SNAPSHOT", rsSnapshot.getString("TABLE_TYPE"));
    assertFalse(rsSnapshot.next());

    // --- Test Case 8: Get multiple types ("TABLE" and "VIEW") ---
    ResultSet rsMulti =
        databaseMetaData.getTables(PROJECT_ID, DATASET, null, new String[] {"TABLE", "VIEW"});
    Set<String> multiTableNames = new HashSet<>();
    while (rsMulti.next()) {
      multiTableNames.add(rsMulti.getString("TABLE_NAME"));
    }
    assertTrue(multiTableNames.contains("base_table"));
    assertTrue(multiTableNames.contains("base_table_clone"));
    assertTrue(multiTableNames.contains("my_view"));
    assertEquals(3, multiTableNames.size());

    // --- Test Case 9: tableNamePattern  ---
    ResultSet rsNamePattern = databaseMetaData.getTables(PROJECT_ID, DATASET, "base%", null);
    Set<String> baseTableNames = new HashSet<>();
    while (rsNamePattern.next()) {
      baseTableNames.add(rsNamePattern.getString("TABLE_NAME"));
    }
    assertTrue(baseTableNames.contains("base_table"));
    assertTrue(baseTableNames.contains("base_table_clone"));
    assertTrue(baseTableNames.contains("base_table_snapshot"));
    assertEquals(3, baseTableNames.size());

    // --- Test Case 10: No matching table ---
    ResultSet rsNoMatch =
        databaseMetaData.getTables(PROJECT_ID, DATASET, "nonexistent_table", null);
    assertFalse(rsNoMatch.next());

    // --- Test Case 11: Null type in array ---
    ResultSet rsNullType =
        databaseMetaData.getTables(PROJECT_ID, DATASET, null, new String[] {null, "VIEW"});
    assertTrue(rsNullType.next());
    assertEquals("VIEW", rsNullType.getString("TABLE_TYPE"));
    assertEquals("my_view", rsNullType.getString("TABLE_NAME"));
    assertFalse(rsNullType.next());
  }

  @Test
  public void testDatabaseMetadataGetSchemas() throws SQLException {
    DatabaseMetaData databaseMetaData = bigQueryConnection.getMetaData();

    // Test case 1: Get all schemas with catalog and check for the presence of specific schemas
    ResultSet rsAll = databaseMetaData.getSchemas(PROJECT_ID, null);
    Set<String> actualSchemas = new HashSet<>();
    while (rsAll.next()) {
      assertEquals(PROJECT_ID, rsAll.getString("TABLE_CATALOG"));
      actualSchemas.add(rsAll.getString("TABLE_SCHEM"));
    }
    assertTrue(actualSchemas.contains("JDBC_INTEGRATION_DATASET"));
    assertTrue(actualSchemas.contains("JDBC_TABLE_TYPES_TEST"));
    assertTrue(actualSchemas.contains("ODBC_TEST_DATASET"));

    // Test case 2: Get schemas with catalog and schemaPattern matching "JDBC_NIGHTLY_IT_DATASET"
    ResultSet rsPattern = databaseMetaData.getSchemas(PROJECT_ID, "JDBC_NIGHTLY_IT_DATASET");
    Set<String> actualSchemasPattern = new HashSet<>();
    while (rsPattern.next()) {
      assertEquals(PROJECT_ID, rsPattern.getString("TABLE_CATALOG"));
      actualSchemasPattern.add(rsPattern.getString("TABLE_SCHEM"));
    }
    assertTrue(actualSchemasPattern.contains("JDBC_NIGHTLY_IT_DATASET"));
    assertEquals(1, actualSchemasPattern.size());

    // Test case 3: Get schemas with catalog and schemaPattern matching "nonexistent"
    ResultSet rsNoMatch = databaseMetaData.getSchemas(PROJECT_ID, "nonexistent");
    assertFalse(rsNoMatch.next());

    // Test case 4: Get schemas with non-existent catalog
    rsNoMatch = databaseMetaData.getSchemas("invalid-catalog", null);
    assertFalse(rsNoMatch.next());
  }

  @Test
  public void testDatabaseMetadataGetSchemasNoArgs() throws SQLException {
    DatabaseMetaData databaseMetaData = bigQueryConnection.getMetaData();
    String expectedCatalog = bigQueryConnection.getCatalog();
    assertNotNull("Project ID (catalog) from connection should not be null", expectedCatalog);

    // Test case: Get all schemas (datasets) for the current project
    try (ResultSet rsAll = databaseMetaData.getSchemas()) {
      assertNotNull("ResultSet from getSchemas() should not be null", rsAll);
      boolean foundTestDataset = false;
      int rowCount = 0;
      while (rsAll.next()) {
        rowCount++;
        assertEquals(
            "TABLE_CATALOG should match the connection's project ID",
            expectedCatalog,
            rsAll.getString("TABLE_CATALOG"));
        String schemaName = rsAll.getString("TABLE_SCHEM");
        assertNotNull("TABLE_SCHEM should not be null", schemaName);
        if (DATASET.equals(schemaName)
            || DATASET2.equals(schemaName)
            || CONSTRAINTS_DATASET.equals(schemaName)
            || "JDBC_TABLE_TYPES_TEST".equals(schemaName)
            || "JDBC_INTEGRATION_DATASET".equals(schemaName)) {
          foundTestDataset = true;
        }
      }
      assertTrue("At least one of the known test datasets should be found", foundTestDataset);
      assertTrue("Should retrieve at least one schema/dataset", rowCount > 0);
    }
  }

  @Test
  public void testDatabaseMetaDataGetFunctions() throws SQLException {
    DatabaseMetaData databaseMetaData = bigQueryConnection.getMetaData();
    String testSchema = "JDBC_TABLE_TYPES_TEST";
    String testCatalog = PROJECT_ID;

    Set<String> expectedFunctionNames =
        new HashSet<>(
            Arrays.asList(
                "complex_scalar_sql_udf",
                "persistent_sql_udf_named_params",
                "scalar_js_udf",
                "scalar_sql_udf"));

    // Test 1: Get all functions from a specific schema
    ResultSet rsAll = databaseMetaData.getFunctions(testCatalog, testSchema, null);
    Set<String> foundFunctionNames = new HashSet<>();
    int countAll = 0;
    while (rsAll.next()) {
      countAll++;
      assertEquals(testCatalog, rsAll.getString("FUNCTION_CAT"));
      assertEquals(testSchema, rsAll.getString("FUNCTION_SCHEM"));
      String funcName = rsAll.getString("FUNCTION_NAME");
      foundFunctionNames.add(funcName);
      assertNull(rsAll.getString("REMARKS"));
      assertEquals(DatabaseMetaData.functionResultUnknown, rsAll.getShort("FUNCTION_TYPE"));
      assertEquals(funcName, rsAll.getString("SPECIFIC_NAME"));
    }
    assertEquals(
        "Should find all " + expectedFunctionNames.size() + " functions in " + testSchema,
        expectedFunctionNames.size(),
        countAll);
    assertEquals(expectedFunctionNames, foundFunctionNames);
    rsAll.close();

    // Test 2: Get a specific function using functionNamePattern
    String specificFunctionName = "scalar_sql_udf";
    ResultSet rsSpecific =
        databaseMetaData.getFunctions(testCatalog, testSchema, specificFunctionName);
    assertTrue("Should find the specific function " + specificFunctionName, rsSpecific.next());
    assertEquals(testCatalog, rsSpecific.getString("FUNCTION_CAT"));
    assertEquals(testSchema, rsSpecific.getString("FUNCTION_SCHEM"));
    assertEquals(specificFunctionName, rsSpecific.getString("FUNCTION_NAME"));
    assertNull(rsSpecific.getString("REMARKS"));
    assertEquals(DatabaseMetaData.functionResultUnknown, rsSpecific.getShort("FUNCTION_TYPE"));
    assertEquals(specificFunctionName, rsSpecific.getString("SPECIFIC_NAME"));
    assertFalse("Should only find one row for exact function match", rsSpecific.next());
    rsSpecific.close();

    // Test 3: Get functions using a wildcard functionNamePattern "scalar%"
    // Expected order due to sorting: scalar_js_udf, scalar_sql_udf
    ResultSet rsWildcard = databaseMetaData.getFunctions(testCatalog, testSchema, "scalar%");
    assertTrue("Should find functions matching 'scalar%'", rsWildcard.next());
    assertEquals("scalar_js_udf", rsWildcard.getString("FUNCTION_NAME"));
    assertEquals(DatabaseMetaData.functionResultUnknown, rsWildcard.getShort("FUNCTION_TYPE"));

    assertTrue("Should find the second function matching 'scalar%'", rsWildcard.next());
    assertEquals("scalar_sql_udf", rsWildcard.getString("FUNCTION_NAME"));
    assertEquals(DatabaseMetaData.functionResultUnknown, rsWildcard.getShort("FUNCTION_TYPE"));
    assertFalse("Should be no more functions matching 'scalar%'", rsWildcard.next());
    rsWildcard.close();

    // Test 4: Schema pattern with wildcard
    ResultSet rsSchemaWildcard =
        databaseMetaData.getFunctions(testCatalog, "JDBC_TABLE_TYPES_T%", "complex_scalar_sql_udf");
    assertTrue("Should find function with schema wildcard", rsSchemaWildcard.next());
    assertEquals(testSchema, rsSchemaWildcard.getString("FUNCTION_SCHEM"));
    assertEquals("complex_scalar_sql_udf", rsSchemaWildcard.getString("FUNCTION_NAME"));
    assertFalse(
        "Should only find one row for this schema wildcard and specific function",
        rsSchemaWildcard.next());
    rsSchemaWildcard.close();

    // Test 5: Non-existent function
    ResultSet rsNonExistentFunc =
        databaseMetaData.getFunctions(testCatalog, testSchema, "non_existent_function_xyz123");
    assertFalse("Should not find a non-existent function", rsNonExistentFunc.next());
    rsNonExistentFunc.close();

    // Test 6: Non-existent schema
    ResultSet rsNonExistentSchema =
        databaseMetaData.getFunctions(testCatalog, "NON_EXISTENT_SCHEMA_XYZ123", null);
    assertFalse("Should not find functions in a non-existent schema", rsNonExistentSchema.next());
    rsNonExistentSchema.close();

    // Test 7: Empty schema pattern
    ResultSet rsEmptySchema = databaseMetaData.getFunctions(testCatalog, "", null);
    assertFalse("Empty schema pattern should return no results", rsEmptySchema.next());
    rsEmptySchema.close();

    // Test 8: Empty function name pattern
    ResultSet rsEmptyFunction = databaseMetaData.getFunctions(testCatalog, testSchema, "");
    assertFalse("Empty function name pattern should return no results", rsEmptyFunction.next());
    rsEmptyFunction.close();

    // Test 9: Null catalog
    ResultSet rsNullCatalog = databaseMetaData.getFunctions(null, testSchema, null);
    assertFalse("Null catalog should return no results", rsNullCatalog.next());
    rsNullCatalog.close();
  }

  @Test
  public void testDatabaseMetadataGetFunctionColumns() throws SQLException {
    DatabaseMetaData databaseMetaData = bigQueryConnection.getMetaData();
    String testCatalog = PROJECT_ID;
    String testSchema = "JDBC_TABLE_TYPES_TEST";

    // Test Case 1: Specific function 'scalar_sql_udf', specific column 'x'
    String specificFunction1 = "scalar_sql_udf";
    String specificColumn1 = "x";
    ResultSet rs =
        databaseMetaData.getFunctionColumns(
            testCatalog, testSchema, specificFunction1, specificColumn1);

    assertTrue("Should find column 'x' for function 'scalar_sql_udf'", rs.next());
    assertEquals(testCatalog, rs.getString("FUNCTION_CAT"));
    assertEquals(testSchema, rs.getString("FUNCTION_SCHEM"));
    assertEquals(specificFunction1, rs.getString("FUNCTION_NAME"));
    assertEquals(specificColumn1, rs.getString("COLUMN_NAME"));
    assertEquals(DatabaseMetaData.functionColumnUnknown, rs.getShort("COLUMN_TYPE"));
    assertEquals(Types.BIGINT, rs.getInt("DATA_TYPE"));
    assertEquals("BIGINT", rs.getString("TYPE_NAME"));
    assertEquals(19, rs.getInt("PRECISION"));
    assertEquals(null, rs.getObject("LENGTH"));
    assertTrue(rs.wasNull());
    assertEquals(0, rs.getShort("SCALE"));
    assertEquals(10, rs.getShort("RADIX"));
    assertEquals(DatabaseMetaData.functionNullableUnknown, rs.getShort("NULLABLE"));
    assertNull(rs.getString("REMARKS"));
    assertEquals(null, rs.getObject("CHAR_OCTET_LENGTH"));
    assertTrue(rs.wasNull());
    assertEquals(1, rs.getInt("ORDINAL_POSITION"));
    assertEquals("", rs.getString("IS_NULLABLE"));
    assertEquals(specificFunction1, rs.getString("SPECIFIC_NAME"));
    assertFalse("Should only find one row for exact column match", rs.next());
    rs.close();

    // Test Case 2: Specific function 'complex_scalar_sql_udf', specific column 'arr'
    String specificFunction2 = "complex_scalar_sql_udf";
    String specificColumn2 = "arr";
    rs =
        databaseMetaData.getFunctionColumns(
            testCatalog, testSchema, specificFunction2, specificColumn2);
    assertTrue("Should find column 'arr' for function 'complex_scalar_sql_udf'", rs.next());
    assertEquals(testCatalog, rs.getString("FUNCTION_CAT"));
    assertEquals(testSchema, rs.getString("FUNCTION_SCHEM"));
    assertEquals(specificFunction2, rs.getString("FUNCTION_NAME"));
    assertEquals(specificColumn2, rs.getString("COLUMN_NAME"));
    assertEquals(DatabaseMetaData.functionColumnUnknown, rs.getShort("COLUMN_TYPE"));
    assertEquals(Types.ARRAY, rs.getInt("DATA_TYPE"));
    assertEquals("ARRAY", rs.getString("TYPE_NAME"));
    assertEquals(null, rs.getObject("PRECISION"));
    assertTrue(rs.wasNull());
    assertEquals(null, rs.getObject("LENGTH"));
    assertTrue(rs.wasNull());
    assertEquals(null, rs.getObject("SCALE"));
    assertTrue(rs.wasNull());
    assertEquals(null, rs.getObject("RADIX"));
    assertTrue(rs.wasNull());
    assertEquals(DatabaseMetaData.functionNullableUnknown, rs.getShort("NULLABLE"));
    assertNull(rs.getString("REMARKS"));
    assertEquals(null, rs.getObject("CHAR_OCTET_LENGTH"));
    assertTrue(rs.wasNull());
    assertEquals(1, rs.getInt("ORDINAL_POSITION"));
    assertEquals("", rs.getString("IS_NULLABLE"));
    assertEquals(specificFunction2, rs.getString("SPECIFIC_NAME"));
    assertFalse("Should only find one row for exact column match", rs.next());
    rs.close();

    // Test Case 3: All columns for 'persistent_sql_udf_named_params' (sorted by ordinal position)
    String specificFunction3 = "persistent_sql_udf_named_params";
    rs = databaseMetaData.getFunctionColumns(testCatalog, testSchema, specificFunction3, null);
    assertTrue("Should find columns for " + specificFunction3, rs.next());
    assertEquals(specificFunction3, rs.getString("FUNCTION_NAME"));
    assertEquals("value1", rs.getString("COLUMN_NAME")); // Ordinal Position 1
    assertEquals(DatabaseMetaData.functionColumnUnknown, rs.getShort("COLUMN_TYPE"));
    assertEquals(Types.BIGINT, rs.getInt("DATA_TYPE"));
    assertEquals("BIGINT", rs.getString("TYPE_NAME"));
    assertEquals(1, rs.getInt("ORDINAL_POSITION"));

    assertTrue("Should find second column for " + specificFunction3, rs.next());
    assertEquals(specificFunction3, rs.getString("FUNCTION_NAME"));
    assertEquals("value-two", rs.getString("COLUMN_NAME")); // Ordinal Position 2
    assertEquals(DatabaseMetaData.functionColumnUnknown, rs.getShort("COLUMN_TYPE"));
    assertEquals(Types.NVARCHAR, rs.getInt("DATA_TYPE"));
    assertEquals("NVARCHAR", rs.getString("TYPE_NAME"));
    assertEquals(2, rs.getInt("ORDINAL_POSITION"));
    assertFalse("Should be no more columns for " + specificFunction3, rs.next());
    rs.close();

    // Test Case 4: Wildcard for function name "scalar%", specific column name "x"
    rs = databaseMetaData.getFunctionColumns(testCatalog, testSchema, "scalar%", "x");
    assertTrue("Should find column 'x' for functions matching 'scalar%'", rs.next());
    assertEquals("scalar_sql_udf", rs.getString("FUNCTION_NAME"));
    assertEquals("x", rs.getString("COLUMN_NAME"));
    assertEquals(1, rs.getInt("ORDINAL_POSITION"));
    assertFalse("Should be no more columns named 'x' for functions matching 'scalar%'", rs.next());
    rs.close();

    // Test Case 5: Wildcard for column name "%" for 'scalar_js_udf'
    String specificFunction4 = "scalar_js_udf";
    rs = databaseMetaData.getFunctionColumns(testCatalog, testSchema, specificFunction4, "%");
    assertTrue("Should find columns for " + specificFunction4 + " with wildcard", rs.next());
    assertEquals(specificFunction4, rs.getString("FUNCTION_NAME"));
    assertEquals("name", rs.getString("COLUMN_NAME")); // Ordinal Position 1
    assertEquals(1, rs.getInt("ORDINAL_POSITION"));

    assertTrue("Should find second column for " + specificFunction4 + " with wildcard", rs.next());
    assertEquals(specificFunction4, rs.getString("FUNCTION_NAME"));
    assertEquals("age", rs.getString("COLUMN_NAME")); // Ordinal Position 2
    assertEquals(2, rs.getInt("ORDINAL_POSITION"));
    assertFalse("Should be no more columns for " + specificFunction4 + " with wildcard", rs.next());
    rs.close();

    // Test Case 6: Non-existent function
    rs =
        databaseMetaData.getFunctionColumns(
            testCatalog, testSchema, "non_existent_function_xyz", null);
    assertFalse("Should not find columns for a non-existent function", rs.next());
    rs.close();
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
  public void testPrepareCallSql() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc");
    assertNotNull(callableStatement);
    callableStatement.close();
  }

  @Test
  public void testRegisterOutParamIndex() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter(1, Types.VARCHAR);
    callableStatement.close();
  }

  @Test
  public void testRegisterOutParamName() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter("ParamKey", Types.VARCHAR);
    callableStatement.close();
  }

  @Test
  public void testRegisterOutParamIndexScale() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter(1, Types.NUMERIC, 2);
    callableStatement.close();
  }

  @Test
  public void testRegisterOutParamNameScale() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter("ParamKey", Types.NUMERIC, 2);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallSqlResultSetTypeConcurrency() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    assertNotNull(callableStatement);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallConcurrencyRegisterOutParamIndex() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter(1, Types.VARCHAR);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallConcurrencyRegisterOutParamName() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter("ParamKey", Types.VARCHAR);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallConcurrencyRegisterOutParamIndexScale() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter(1, Types.NUMERIC, 2);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallConcurrencyRegisterOutParamNameScale() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter("ParamKey", Types.NUMERIC, 2);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallSqlResultSetTypeConcurrencyHoldability() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc",
            ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.CONCUR_READ_ONLY,
            ResultSet.CLOSE_CURSORS_AT_COMMIT);
    assertNotNull(callableStatement);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallHoldabilityRegisterOutParamIndex() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')",
            ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.CONCUR_READ_ONLY,
            ResultSet.CLOSE_CURSORS_AT_COMMIT);
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter(1, Types.VARCHAR);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallHoldabilityRegisterOutParamName() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')",
            ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.CONCUR_READ_ONLY,
            ResultSet.CLOSE_CURSORS_AT_COMMIT);
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter("ParamKey", Types.VARCHAR);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallHoldabilityRegisterOutParamIndexScale() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')",
            ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.CONCUR_READ_ONLY,
            ResultSet.CLOSE_CURSORS_AT_COMMIT);
    assertNotNull(callableStatement);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallHoldabilityRegisterOutParamNameScale() throws SQLException {
    CallableStatement callableStatement =
        this.bigQueryConnection.prepareCall(
            "call testProc('?')",
            ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.CONCUR_READ_ONLY,
            ResultSet.CLOSE_CURSORS_AT_COMMIT);
    assertNotNull(callableStatement);
    callableStatement.registerOutParameter("ParamKey", Types.NUMERIC, 2);
    callableStatement.close();
  }

  @Test
  public void testPrepareCallFailureResultSetType() throws SQLException {
    assertThrows(
        BigQueryJdbcSqlFeatureNotSupportedException.class,
        () ->
            this.bigQueryConnection.prepareCall(
                "call testProc", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY));
  }

  @Test
  public void testPrepareCallFailureResultSetConcurrency() throws SQLException {
    assertThrows(
        BigQueryJdbcSqlFeatureNotSupportedException.class,
        () ->
            this.bigQueryConnection.prepareCall(
                "call testProc", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE));
  }

  @Test
  public void testPrepareCallFailureResultSetHoldability() throws SQLException {
    assertThrows(
        BigQueryJdbcSqlFeatureNotSupportedException.class,
        () ->
            this.bigQueryConnection.prepareCall(
                "call testProc",
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.HOLD_CURSORS_OVER_COMMIT));
  }

  // Integration tests for CallableStatement Setters and Getters
  @Test
  public void testSetterGetterBigDecimal() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    BigDecimal expected = new BigDecimal(12344);
    callableStatement.setBigDecimal(CALLABLE_STMT_PARAM_KEY, expected);
    BigDecimal actual = callableStatement.getBigDecimal(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterBoolean() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Boolean expected = true;
    callableStatement.setBoolean(CALLABLE_STMT_PARAM_KEY, expected);
    Boolean actual = callableStatement.getBoolean(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterByte() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Byte expected = "hello".getBytes()[0];
    callableStatement.setByte(CALLABLE_STMT_PARAM_KEY, expected);
    Byte actual = callableStatement.getByte(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterBytes() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    byte[] expected = "hello".getBytes();
    callableStatement.setBytes(CALLABLE_STMT_PARAM_KEY, expected);
    byte[] actual = callableStatement.getBytes(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterDate() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Date expected = new Date(1234567);
    callableStatement.setDate(CALLABLE_STMT_PARAM_KEY, expected);
    Date actual = callableStatement.getDate(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterDateCal() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Date expected = new Date(1L);
    Calendar cal = Calendar.getInstance();
    callableStatement.setDate(CALLABLE_STMT_PARAM_KEY, expected, cal);
    Date actual = callableStatement.getDate(CALLABLE_STMT_PARAM_KEY, cal);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterDouble() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Double expected = 123.2345;
    callableStatement.setDouble(CALLABLE_STMT_PARAM_KEY, expected);
    Double actual = callableStatement.getDouble(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterFloat() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Float expected = 123.2345F;
    callableStatement.setFloat(CALLABLE_STMT_PARAM_KEY, expected);
    Float actual = callableStatement.getFloat(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterInt() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Integer expected = 123;
    callableStatement.setInt(CALLABLE_STMT_PARAM_KEY, expected);
    Integer actual = callableStatement.getInt(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterLong() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Long expected = 123L;
    callableStatement.setLong(CALLABLE_STMT_PARAM_KEY, expected);
    Long actual = callableStatement.getLong(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterNString() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    String expected = "heelo";
    callableStatement.setNString(CALLABLE_STMT_PARAM_KEY, expected);
    String actual = callableStatement.getNString(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterObject() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    String expected = "heelo";
    callableStatement.setObject(CALLABLE_STMT_PARAM_KEY, expected);
    Object actual = callableStatement.getObject(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterObjectWithSQLType() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    String expected = "heelo";
    callableStatement.setObject(CALLABLE_STMT_PARAM_KEY, expected, Types.NVARCHAR);
    Object actual = callableStatement.getObject(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterObjectWithSqlTypeAndScale() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    String expected = "heelo";
    callableStatement.setObject(CALLABLE_STMT_PARAM_KEY, expected, Types.NVARCHAR, 0);
    Object actual = callableStatement.getObject(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterString() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    String expected = "123";
    callableStatement.setString(CALLABLE_STMT_PARAM_KEY, expected);
    String actual = callableStatement.getString(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterTime() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Time expected = new Time(1234567);
    callableStatement.setTime(CALLABLE_STMT_PARAM_KEY, expected);
    Time actual = callableStatement.getTime(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterTimeCal() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Time expected = new Time(1L);
    Calendar cal = Calendar.getInstance();
    callableStatement.setTime(CALLABLE_STMT_PARAM_KEY, expected, cal);
    Time actual = callableStatement.getTime(CALLABLE_STMT_PARAM_KEY, cal);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterTimestamp() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Timestamp expected = new Timestamp(1234567);
    callableStatement.setTimestamp(CALLABLE_STMT_PARAM_KEY, expected);
    Timestamp actual = callableStatement.getTimestamp(CALLABLE_STMT_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetterGetterTimestampCal() throws SQLException {
    CallableStatement callableStatement = this.bigQueryConnection.prepareCall("call testProc('?')");
    assertNotNull(callableStatement);
    Timestamp expected = new Timestamp(1L);
    Calendar cal = Calendar.getInstance();
    callableStatement.setTimestamp(CALLABLE_STMT_PARAM_KEY, expected, cal);
    Timestamp actual = callableStatement.getTimestamp(CALLABLE_STMT_PARAM_KEY, cal);
    assertEquals(expected, actual);
  }

  @Test
  public void testPooledConnectionDataSourceSuccess() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
  }

  @Test
  public void testPooledConnectionDataSourceFailNoConnectionURl() throws SQLException {
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();

    assertThrows(BigQueryJdbcException.class, () -> pooledDataSource.getPooledConnection());
  }

  @Test
  public void testPooledConnectionDataSourceFailInvalidConnectionURl() {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "ListenerPoolSize=invalid";
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    assertThrows(NumberFormatException.class, () -> pooledDataSource.getPooledConnection());
  }

  @Test
  public void testPooledConnectionAddConnectionListener() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listener);
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());
  }

  @Test
  public void testPooledConnectionRemoveConnectionListener() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.removeConnectionEventListener(listener);
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());
  }

  @Test
  public void testPooledConnectionConnectionClosed() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listener);
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());

    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());

    connection.close();
    assertEquals(1, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());
  }

  @Test
  public void testPooledConnectionClose() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listener);
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());

    pooledConnection.close();
    assertEquals(1, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());
  }

  @Test
  public void testPooledConnectionConnectionError() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listener);
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());

    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());

    ExecutorService executor = Executors.newFixedThreadPool(3);
    connection.abort(executor);
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(1, listener.getConnectionErrorCount());

    executor.shutdown();
    connection.close();
    pooledConnection.close();
  }

  @Test
  public void testPooledConnectionListenerAddListener() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    PooledConnectionListener listener = new PooledConnectionListener(DEFAULT_CONN_POOL_SIZE);
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());
    pooledConnection.close();
  }

  @Test
  public void testPooledConnectionListenerRemoveListener() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    PooledConnectionListener listener = new PooledConnectionListener(DEFAULT_CONN_POOL_SIZE);
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    pooledConnection.removeConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());
    pooledConnection.close();
  }

  @Test
  public void testPooledConnectionListenerCloseConnection() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    PooledConnectionListener listener = new PooledConnectionListener(DEFAULT_CONN_POOL_SIZE);
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());

    connection.close();
    assertFalse(listener.isConnectionPoolEmpty());
    pooledConnection.close();
  }

  @Test
  public void testPooledConnectionListenerClosePooledConnection() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    PooledConnectionListener listener = new PooledConnectionListener(DEFAULT_CONN_POOL_SIZE);
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    pooledConnection.close();
    assertFalse(listener.isConnectionPoolEmpty());
  }

  @Test
  public void testPooledConnectionListenerConnectionError() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    PooledConnectionListener listener = new PooledConnectionListener(DEFAULT_CONN_POOL_SIZE);
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());

    ExecutorService executor = Executors.newFixedThreadPool(3);
    connection.abort(executor);
    assertTrue(listener.isConnectionPoolEmpty());

    executor.shutdown();
    connection.close();
    pooledConnection.close();
  }

  @Test
  public void testExecuteQueryWithConnectionPoolingEnabledDefaultPoolSize() throws SQLException {
    String connectionURL =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;ProjectId="
            + PROJECT_ID
            + ";";
    assertConnectionPoolingResults(connectionURL, DEFAULT_CONN_POOL_SIZE);
  }

  @Test
  public void testExecuteQueryWithConnectionPoolingEnabledCustomPoolSize() throws SQLException {
    String connectionURL =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;ProjectId="
            + PROJECT_ID
            + ";"
            + "ConnectionPoolSize="
            + CUSTOM_CONN_POOL_SIZE
            + ";";
    assertConnectionPoolingResults(connectionURL, CUSTOM_CONN_POOL_SIZE);
  }

  private void assertConnectionPoolingResults(String connectionURL, Long connectionPoolSize)
      throws SQLException {
    // Create Pooled Connection Datasource
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionURL);

    // Get pooled connection and ensure listner was added with default connection pool size.
    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    PooledConnectionListener listener = pooledDataSource.getConnectionPoolManager();
    assertNotNull(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    // Get Underlying physical connection
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());

    // Execute query with physical connection
    String query =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT"
            + " 850";
    Statement statement = connection.createStatement();
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));

    // Close physical connection
    connection.close();
    assertFalse(listener.isConnectionPoolEmpty());
    assertEquals(1, listener.getConnectionPoolCurrentCapacity());
    assertEquals(connectionPoolSize, listener.getConnectionPoolSize());

    // Reuse same physical connection.
    connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertFalse(listener.isConnectionPoolEmpty());
    assertEquals(1, listener.getConnectionPoolCurrentCapacity());
    assertEquals(connectionPoolSize, listener.getConnectionPoolSize());

    // Execute query with reusable physical connection
    jsonResultSet = statement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));

    // Return connection back to the pool.
    connection.close();
    assertFalse(listener.isConnectionPoolEmpty());
    assertEquals(1, listener.getConnectionPoolCurrentCapacity());
    assertEquals(connectionPoolSize, listener.getConnectionPoolSize());
    pooledConnection.close();
  }

  @Test
  public void testAdditionalProjectsInMetadata() throws SQLException {
    String additionalProjectsValue = "bigquery-public-data";
    String datasetInAdditionalProject = "baseball";

    String urlWithAdditionalProjects =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId="
            + PROJECT_ID
            + ";OAuthType=3"
            + ";AdditionalProjects="
            + additionalProjectsValue;

    try (Connection conn = DriverManager.getConnection(urlWithAdditionalProjects)) {
      DatabaseMetaData dbMetaData = conn.getMetaData();

      // 1. Test getCatalogs()
      Set<String> foundCatalogs = new HashSet<>();
      try (ResultSet catalogsRs = dbMetaData.getCatalogs()) {
        while (catalogsRs.next()) {
          foundCatalogs.add(catalogsRs.getString("TABLE_CAT"));
        }
      }
      assertTrue(
          "getCatalogs() should contain the primary project ID",
          foundCatalogs.contains(PROJECT_ID));
      assertTrue(
          "getCatalogs() should contain the additional project ID",
          foundCatalogs.contains(additionalProjectsValue));

      // 2. Test getSchemas()
      Set<String> catalogsForSchemasFromAll = new HashSet<>();
      boolean foundAdditionalDataset = false;
      try (ResultSet schemasRs = dbMetaData.getSchemas()) {
        while (schemasRs.next()) {
          String schemaName = schemasRs.getString("TABLE_SCHEM");
          String catalogName = schemasRs.getString("TABLE_CATALOG");
          catalogsForSchemasFromAll.add(catalogName);
          if (additionalProjectsValue.equals(catalogName)
              && datasetInAdditionalProject.equals(schemaName)) {
            foundAdditionalDataset = true;
          }
        }
      }
      assertTrue(
          "getSchemas() should list datasets from the primary project",
          catalogsForSchemasFromAll.contains(PROJECT_ID));
      assertTrue(
          "getSchemas() should list datasets from the additional project",
          catalogsForSchemasFromAll.contains(additionalProjectsValue));
      assertTrue(
          "Known dataset from additional project not found in getSchemas()",
          foundAdditionalDataset);

    } catch (SQLException e) {
      System.err.println("SQL Error during AdditionalProjects test: " + e.getMessage());
      throw e;
    }
  }

  @Test
  public void testFilterTablesOnDefaultDataset_getTables() throws SQLException {
    String defaultDatasetValue = CONSTRAINTS_DATASET;
    String table1InDefaultDataset = CONSTRAINTS_TABLE_NAME;
    String table2InDefaultDataset = CONSTRAINTS_TABLE_NAME2;

    String specificDatasetValue = "JDBC_TABLE_TYPES_TEST";
    String table1InSpecificDataset = "base_table";
    String table2InSpecificDataset = "external_table";

    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId="
            + PROJECT_ID
            + ";OAuthType=3"
            + ";DefaultDataset="
            + defaultDatasetValue
            + ";FilterTablesOnDefaultDataset=1";
    try (Connection conn = DriverManager.getConnection(connectionUrl)) {
      DatabaseMetaData dbMetaData = conn.getMetaData();

      // Case 1: Catalog and schemaPattern are null/wildcard, should use DefaultDataset
      try (ResultSet rs = dbMetaData.getTables(null, null, null, null)) {
        Set<String> tableNames = new HashSet<>();
        while (rs.next()) {
          assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          assertEquals(defaultDatasetValue, rs.getString("TABLE_SCHEM"));
          tableNames.add(rs.getString("TABLE_NAME"));
        }
        assertTrue(tableNames.contains(table1InDefaultDataset));
        assertTrue(tableNames.contains(table2InDefaultDataset));
      }

      // Case 2: Explicit schemaPattern overrides DefaultDataset
      try (ResultSet rs = dbMetaData.getTables(null, specificDatasetValue, null, null)) {
        Set<String> tableNames = new HashSet<>();
        while (rs.next()) {
          assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          assertEquals(specificDatasetValue, rs.getString("TABLE_SCHEM"));
          tableNames.add(rs.getString("TABLE_NAME"));
        }
        assertTrue(tableNames.contains(table1InSpecificDataset));
        assertTrue(tableNames.contains(table2InSpecificDataset));
      }

      // Case 3: Explicit catalog, schemaPattern is null/wildcard, should use DefaultDataset within
      // that catalog
      try (ResultSet rs = dbMetaData.getTables(PROJECT_ID, null, null, null)) {
        Set<String> tableNames = new HashSet<>();
        while (rs.next()) {
          assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          assertEquals(defaultDatasetValue, rs.getString("TABLE_SCHEM"));
          tableNames.add(rs.getString("TABLE_NAME"));
        }
        assertTrue(tableNames.contains(table1InDefaultDataset));
        assertTrue(tableNames.contains(table2InDefaultDataset));
      }

      // Case 4: Explicit catalog and schemaPattern override DefaultDataset
      try (ResultSet rs = dbMetaData.getTables(PROJECT_ID, specificDatasetValue, null, null)) {
        Set<String> tableNames = new HashSet<>();
        while (rs.next()) {
          assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          assertEquals(specificDatasetValue, rs.getString("TABLE_SCHEM"));
          tableNames.add(rs.getString("TABLE_NAME"));
        }
        assertTrue(tableNames.contains(table1InSpecificDataset));
        assertTrue(tableNames.contains(table2InSpecificDataset));
      }
    }
  }

  @Test
  public void testFilterTablesOnDefaultDataset_getColumns() throws SQLException {
    String defaultDatasetValue = CONSTRAINTS_DATASET;
    String tableInDefaultDataset = CONSTRAINTS_TABLE_NAME;
    String[] columnsInDefaultTable = {"id", "name", "second_name", "address"};

    String specificDatasetValue = "JDBC_TABLE_TYPES_TEST";
    String tableInSpecificDataset = "base_table";
    String[] columnsInSpecificTable = {"id", "name", "created_at"};

    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId="
            + PROJECT_ID
            + ";OAuthType=3"
            + ";DefaultDataset="
            + defaultDatasetValue
            + ";FilterTablesOnDefaultDataset=1";

    try (Connection conn = DriverManager.getConnection(connectionUrl)) {
      DatabaseMetaData dbMetaData = conn.getMetaData();

      // Case 1: Catalog and schemaPattern are null/wildcard, should use DefaultDataset
      try (ResultSet rs = dbMetaData.getColumns(null, null, tableInDefaultDataset, null)) {
        Set<String> columnNames = new HashSet<>();
        while (rs.next()) {
          assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          assertEquals(defaultDatasetValue, rs.getString("TABLE_SCHEM"));
          assertEquals(tableInDefaultDataset, rs.getString("TABLE_NAME"));
          columnNames.add(rs.getString("COLUMN_NAME"));
        }
        for (String expectedCol : columnsInDefaultTable) {
          assertTrue(columnNames.contains(expectedCol));
        }
        assertEquals(columnsInDefaultTable.length, columnNames.size());
      }

      // Case 2: Explicit schemaPattern overrides DefaultDataset
      try (ResultSet rs =
          dbMetaData.getColumns(null, specificDatasetValue, tableInSpecificDataset, null)) {
        Set<String> columnNames = new HashSet<>();
        while (rs.next()) {
          assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          assertEquals(specificDatasetValue, rs.getString("TABLE_SCHEM"));
          assertEquals(tableInSpecificDataset, rs.getString("TABLE_NAME"));
          columnNames.add(rs.getString("COLUMN_NAME"));
        }
        for (String expectedCol : columnsInSpecificTable) {
          assertTrue(columnNames.contains(expectedCol));
        }
        assertEquals(columnsInSpecificTable.length, columnNames.size());
      }

      // Case 3: Explicit catalog, schemaPattern is null/wildcard, should use DefaultDataset within
      // that catalog
      try (ResultSet rs = dbMetaData.getColumns(PROJECT_ID, null, tableInDefaultDataset, null)) {
        Set<String> columnNames = new HashSet<>();
        while (rs.next()) {
          assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          assertEquals(defaultDatasetValue, rs.getString("TABLE_SCHEM"));
          assertEquals(tableInDefaultDataset, rs.getString("TABLE_NAME"));
          columnNames.add(rs.getString("COLUMN_NAME"));
        }
        for (String expectedCol : columnsInDefaultTable) {
          assertTrue(columnNames.contains(expectedCol));
        }
        assertEquals(columnsInDefaultTable.length, columnNames.size());
      }

      // Case 4: Explicit catalog and schemaPattern override DefaultDataset
      try (ResultSet rs =
          dbMetaData.getColumns(PROJECT_ID, specificDatasetValue, tableInSpecificDataset, null)) {
        Set<String> columnNames = new HashSet<>();
        while (rs.next()) {
          assertEquals(PROJECT_ID, rs.getString("TABLE_CAT"));
          assertEquals(specificDatasetValue, rs.getString("TABLE_SCHEM"));
          assertEquals(tableInSpecificDataset, rs.getString("TABLE_NAME"));
          columnNames.add(rs.getString("COLUMN_NAME"));
        }
        for (String expectedCol : columnsInSpecificTable) {
          assertTrue(columnNames.contains(expectedCol));
        }
        assertEquals(columnsInSpecificTable.length, columnNames.size());
      }
    }
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
  public void testCallableStatementScriptExecuteUpdate() throws SQLException {
    int randomNum = java.util.UUID.randomUUID().hashCode();
    String insertName = "callable-statement-dml-insert-test";
    String insertResult = String.format("%s-%d", insertName, randomNum);
    String updateName = "callable-statement-dml-update-test";
    String updateResult = String.format("%s-%d", updateName, randomNum);
    String selectStmtQuery =
        String.format("SELECT * FROM %s.%s WHERE id = ?", DATASET, CALLABLE_STMT_DML_TABLE_NAME);
    String insertCallStmtQuery =
        String.format("CALL %s.%s(?,?,?);", DATASET, CALLABLE_STMT_DML_INSERT_PROC_NAME);
    String updateCallStmtQuery =
        String.format("CALL %s.%s(?,?,?);", DATASET, CALLABLE_STMT_DML_UPDATE_PROC_NAME);
    String deleteCallStmtQuery =
        String.format("CALL %s.%s(?);", DATASET, CALLABLE_STMT_DML_DELETE_PROC_NAME);

    // DML INSERT
    CallableStatement callableStatement = bigQueryConnection.prepareCall(insertCallStmtQuery);
    assertNotNull(callableStatement);
    callableStatement.setString(1, insertName);
    callableStatement.setInt(2, randomNum);
    callableStatement.setString(3, insertResult);
    int rowsInserted = callableStatement.executeUpdate();
    assertEquals(1, rowsInserted);

    PreparedStatement preparedStatement = bigQueryConnection.prepareStatement(selectStmtQuery);
    assertNotNull(preparedStatement);
    preparedStatement.setInt(1, randomNum);
    ResultSet rs = preparedStatement.executeQuery();
    assertNotNull(rs);
    assertTrue(rs.next());

    assertEquals(insertName, rs.getString(1));
    assertEquals(randomNum, rs.getInt(2));
    assertEquals(insertResult, rs.getString(3));

    // DML UPDATE
    callableStatement = bigQueryConnection.prepareCall(updateCallStmtQuery);
    assertNotNull(callableStatement);
    callableStatement.setString(1, updateName);
    callableStatement.setInt(2, randomNum);
    callableStatement.setString(3, updateResult);
    int rowsUpdated = callableStatement.executeUpdate();
    assertEquals(1, rowsUpdated);

    preparedStatement = bigQueryConnection.prepareStatement(selectStmtQuery);
    assertNotNull(preparedStatement);
    preparedStatement.setInt(1, randomNum);
    rs = preparedStatement.executeQuery();
    assertNotNull(rs);
    assertTrue(rs.next());

    assertEquals(updateName, rs.getString(1));
    assertEquals(randomNum, rs.getInt(2));
    assertEquals(updateResult, rs.getString(3));

    // DML DELETE
    callableStatement = bigQueryConnection.prepareCall(deleteCallStmtQuery);
    assertNotNull(callableStatement);
    callableStatement.setInt(1, randomNum);
    int rowsDeleted = callableStatement.executeUpdate();
    assertEquals(1, rowsDeleted);

    preparedStatement = bigQueryConnection.prepareStatement(selectStmtQuery);
    assertNotNull(preparedStatement);
    preparedStatement.setInt(1, randomNum);
    rs = preparedStatement.executeQuery();
    assertNotNull(rs);
    assertFalse(rs.next());

    callableStatement.close();
  }

  @Test
  public void testCallableStatementScriptExecuteLargeUpdate() throws SQLException {
    int randomNum = java.util.UUID.randomUUID().hashCode();
    String insertName = "callable-statement-dml-insert-test";
    String insertResult = String.format("%s-%d", insertName, randomNum);
    String updateName = "callable-statement-dml-update-test";
    String updateResult = String.format("%s-%d", updateName, randomNum);
    String selectStmtQuery =
        String.format("SELECT * FROM %s.%s WHERE id = ?", DATASET, CALLABLE_STMT_DML_TABLE_NAME);
    String insertCallStmtQuery =
        String.format("CALL %s.%s(?,?,?);", DATASET, CALLABLE_STMT_DML_INSERT_PROC_NAME);
    String updateCallStmtQuery =
        String.format("CALL %s.%s(?,?,?);", DATASET, CALLABLE_STMT_DML_UPDATE_PROC_NAME);
    String deleteCallStmtQuery =
        String.format("CALL %s.%s(?);", DATASET, CALLABLE_STMT_DML_DELETE_PROC_NAME);

    // DML INSERT
    CallableStatement callableStatement = bigQueryConnection.prepareCall(insertCallStmtQuery);
    assertNotNull(callableStatement);
    callableStatement.setString(1, insertName);
    callableStatement.setInt(2, randomNum);
    callableStatement.setString(3, insertResult);
    long rowsInserted = callableStatement.executeLargeUpdate();
    assertEquals(1L, rowsInserted);

    PreparedStatement preparedStatement = bigQueryConnection.prepareStatement(selectStmtQuery);
    assertNotNull(preparedStatement);
    preparedStatement.setInt(1, randomNum);
    ResultSet rs = preparedStatement.executeQuery();
    assertNotNull(rs);
    assertTrue(rs.next());

    assertEquals(insertName, rs.getString(1));
    assertEquals(randomNum, rs.getInt(2));
    assertEquals(insertResult, rs.getString(3));

    // DML UPDATE
    callableStatement = bigQueryConnection.prepareCall(updateCallStmtQuery);
    assertNotNull(callableStatement);
    callableStatement.setString(1, updateName);
    callableStatement.setInt(2, randomNum);
    callableStatement.setString(3, updateResult);
    long rowsUpdated = callableStatement.executeLargeUpdate();
    assertEquals(1L, rowsUpdated);

    preparedStatement = bigQueryConnection.prepareStatement(selectStmtQuery);
    assertNotNull(preparedStatement);
    preparedStatement.setInt(1, randomNum);
    rs = preparedStatement.executeQuery();
    assertNotNull(rs);
    assertTrue(rs.next());

    assertEquals(updateName, rs.getString(1));
    assertEquals(randomNum, rs.getInt(2));
    assertEquals(updateResult, rs.getString(3));

    // DML DELETE
    callableStatement = bigQueryConnection.prepareCall(deleteCallStmtQuery);
    assertNotNull(callableStatement);
    callableStatement.setInt(1, randomNum);
    long rowsDeleted = callableStatement.executeLargeUpdate();
    assertEquals(1L, rowsDeleted);

    preparedStatement = bigQueryConnection.prepareStatement(selectStmtQuery);
    assertNotNull(preparedStatement);
    preparedStatement.setInt(1, randomNum);
    rs = preparedStatement.executeQuery();
    assertNotNull(rs);
    assertFalse(rs.next());

    callableStatement.close();
  }

  @Test
  public void testScript() throws SQLException {
    String BASE_QUERY =
        "SELECT * FROM bigquery-public-data.new_york_taxi_trips.tlc_yellow_trips_2017 order by"
            + " trip_distance asc LIMIT %s;";
    String query1 = String.format(BASE_QUERY, 5000);
    String query2 = String.format(BASE_QUERY, 7000);
    String query3 = String.format(BASE_QUERY, 9000);

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
  }

  @Test
  public void testCallableStatementScriptExecute() throws SQLException {
    int randomNum = random.nextInt(99);
    String callableStmtQuery =
        String.format(
            "DECLARE call_result STRING;"
                + "CALL %s.%s(?,?,call_result);"
                + "SELECT * FROM %s.%s WHERE result = call_result;",
            DATASET, CALLABLE_STMT_PROC_NAME, DATASET, CALLABLE_STMT_TABLE_NAME);
    CallableStatement callableStatement = bigQueryConnection.prepareCall(callableStmtQuery);
    callableStatement.setString(1, "callable-stmt-test");
    callableStatement.setInt(2, randomNum);

    assertFalse(callableStatement.execute());
    assertEquals(1, callableStatement.getUpdateCount());

    // This is an actual SELECT * from the above
    assertTrue(callableStatement.getMoreResults());
    ResultSet resultSet = callableStatement.getResultSet();
    ResultSetMetaData rsMetadata = resultSet.getMetaData();
    assertEquals(3, rsMetadata.getColumnCount());

    assertTrue(resultSet.next());

    String expected = String.format("callable-stmt-test-%d", randomNum);
    String actual = resultSet.getString(3);

    assertEquals(expected, actual);

    // Validate there are no more results
    assertFalse(callableStatement.getMoreResults());
    assertEquals(-1, callableStatement.getUpdateCount());
    callableStatement.close();
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

          assertEquals(regularApiLabel, expectedValue, getter.apply(resultSetRegular, i));
          assertEquals(htapiApiLabel, expectedValue, getter.apply(resultSetArrow, i));

        } else {
          String regularMsg = "Expected exception but got a value. " + regularApiLabel;
          assertEquals(regularMsg, EXCEPTION_REPLACEMENT, getter.apply(resultSetRegular, i));

          String htapiMsg = "Expected exception but got a value. " + htapiApiLabel;
          assertEquals(htapiMsg, EXCEPTION_REPLACEMENT, getter.apply(resultSetArrow, i));
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

  private int resultSetRowCount(ResultSet resultSet) throws SQLException {
    int rowCount = 0;
    while (resultSet.next()) {
      rowCount++;
    }
    return rowCount;
  }
}
