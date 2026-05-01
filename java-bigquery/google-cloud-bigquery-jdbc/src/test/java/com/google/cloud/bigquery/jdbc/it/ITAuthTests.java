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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.ServiceOptions;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ITAuthTests extends ITBase {
  static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();

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
    String query =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT"
            + " 850";
    Statement statement = connection.createStatement();
    ResultSet jsonResultSet = statement.executeQuery(query);
    int totalRows = 0;
    while (jsonResultSet.next()) {
      totalRows += 1;
    }
    assertEquals(totalRows, 850);
    connection.close();
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
            + ";OAuthServiceAcctEmail=;"
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
      Assertions.fail();
    } catch (Exception ex) {
      assertTrue(ex.getMessage() != null);
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
  @Disabled
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
  @Disabled
  public void testValidGoogleUserAccountAuthentication() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAuthType=1;OAuthClientId=client_id;OAuthClientSecret=client_secret;";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());

    Statement statement = connection.createStatement();
    ResultSet resultSet =
        statement.executeQuery(
            "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 50");

    assertEquals(50, resultSetRowCount(resultSet));
    connection.close();
  }

  @Test
  @Disabled
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

    Statement statement = connection.createStatement();
    ResultSet resultSet =
        statement.executeQuery(
            "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 50");

    assertEquals(50, resultSetRowCount(resultSet));
    connection.close();
  }

  @Test
  @Disabled
  public void testValidExternalAccountAuthenticationFromFile() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=4;"
            + "OAuthPvtKeyPath=/path/to/file;";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());

    Statement statement = connection.createStatement();
    ResultSet resultSet =
        statement.executeQuery(
            "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 50");

    assertEquals(50, resultSetRowCount(resultSet));
    connection.close();
  }

  @Test
  @Disabled
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

    Statement statement = connection.createStatement();
    ResultSet resultSet =
        statement.executeQuery(
            "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 50");

    assertEquals(50, resultSetRowCount(resultSet));
    connection.close();
  }

  // TODO(farhan): figure out how to programmatically generate an access token and test
  @Test
  @Disabled
  public void testValidPreGeneratedAccessTokenAuthentication() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=2;OAuthAccessToken=access_token;";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());

    Statement statement = connection.createStatement();
    ResultSet resultSet =
        statement.executeQuery(
            "SELECT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT 50");

    assertEquals(50, resultSetRowCount(resultSet));
    connection.close();
  }

  // TODO(obada): figure out how to programmatically generate a refresh token and test
  @Test
  @Disabled
  public void testValidRefreshTokenAuthentication() throws SQLException {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID="
            + PROJECT_ID
            + ";OAUTHTYPE=2;OAuthRefreshToken=refresh_token;"
            + ";OAuthClientId=client;OAuthClientSecret=secret;";

    Connection connection = DriverManager.getConnection(connection_uri);
    assertNotNull(connection);
    assertFalse(connection.isClosed());

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
  public void testADCAuthenticationWithImpersonation() throws IOException, SQLException {
    final JsonObject authJson = getAuthJson();

    String connection_uri =
        getBaseUri(3, authJson.get("project_id").getAsString())
            .append("ServiceAccountImpersonationEmail", authJson.get("client_email").getAsString())
            .toString();
    validateConnection(connection_uri);
  }
}
