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

package com.google.cloud.bigquery.jdbc.testsuite.authentication;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import com.google.cloud.ServiceOptions;
import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.PreparedStatement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ITJdbcAuthenticationTest {
  Connection connection = null;

  private static String connectionUriBase = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=0;";

  @Before
  public void beforeTest(){
    connection = null;
  }

  @After
  public void afterTest() throws Exception {
    if (connection != null){
      connection.close();
    }
    connection = null;
  }

  private static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
    return value;
  }

  private JsonObject getAuthJson() throws Exception {
    final String secret = requireEnvVar("SA_SECRET");
    JsonObject authJson = JsonParser.parseString(secret).getAsJsonObject();

    assertTrue(authJson.has("client_email"));
    assertTrue(authJson.has("private_key"));
    assertTrue(authJson.has("project_id"));
    return authJson;
  }
  
  private void validateConnectionUri(String connectionUri) throws Exception  {
    connection =
        DriverManager.getConnection(connectionUri);
    assertFalse(connection.isClosed());
    PreparedStatement preparedStatement = connection.prepareStatement("SELECT 1");
    assertNotNull(preparedStatement);
    preparedStatement.execute();
    preparedStatement.close();
    connection.close();
  }

  @Test
  public void testConnectOAuthPvtKeyPath() throws Exception {
    final JsonObject authJson = getAuthJson();
    File tempFile = File.createTempFile("auth", ".json");
    tempFile.deleteOnExit();
    Files.write(tempFile.toPath(), authJson.toString().getBytes());

    final String connectionUri = connectionUriBase + 
      ";ProjectId=" + authJson.get("project_id").getAsString() + 
      ";OAuthServiceAcctEmail=" + 
      ";OAuthPvtKeyPath=" + tempFile.toPath();
    validateConnectionUri(connectionUri);
  }

  @Test
  public void testConnectOAuthPvtKeyAsPath() throws Exception {
    final JsonObject authJson = getAuthJson();
    File tempFile = File.createTempFile("auth", ".json");
    tempFile.deleteOnExit();
    Files.write(tempFile.toPath(), authJson.toString().getBytes());

    final String connectionUri = connectionUriBase + 
      ";ProjectId=" + authJson.get("project_id").getAsString() + 
      ";OAuthServiceAcctEmail=" + 
      ";OAuthPvtKey=" + tempFile.toPath();
    validateConnectionUri(connectionUri);
  }

  @Test
  public void testConnectOAuthPvtKeyAsJson() throws Exception {
    final JsonObject authJson = getAuthJson();
    final String connectionUri = connectionUriBase + 
      ";ProjectId=" + authJson.get("project_id").getAsString() + 
      ";OAuthServiceAcctEmail=" + 
      ";OAuthPvtKey=" + authJson.toString();
    validateConnectionUri(connectionUri);
  }

  @org.junit.Ignore("Disabled until p12 file can be supplied")
  @Test
  public void testConnectOAuthPvtKeyP12() throws Exception {
    final JsonObject authJson = getAuthJson();
    final String p12_file = requireEnvVar("SA_SECRET_P12");

    final String connectionUri = connectionUriBase + 
      ";ProjectId=" + authJson.get("project_id").getAsString() + 
      ";OAuthServiceAcctEmail=" + authJson.get("client_email").getAsString() + 
      ";OAuthPvtKeyPath=" + p12_file;
    validateConnectionUri(connectionUri);
  }
}
