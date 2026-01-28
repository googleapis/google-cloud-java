/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static org.junit.Assert.*;

import com.google.api.gax.rpc.HeaderProvider;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;

public class BigQueryConnectionTest {

  private static final String DEFAULT_VERSION = "0.0.0";
  private static final String DEFAULT_JDBC_TOKEN_VALUE = "Google-BigQuery-JDBC-Driver";
  private String expectedVersion;

  @Before
  public void setUp() throws IOException {
    // Read the expected version from the dependencies.properties file once.
    expectedVersion = getExpectedVersion();
  }

  private String getExpectedVersion() {
    Properties props = new Properties();
    try (InputStream in =
        getClass().getResourceAsStream("/com/google/cloud/bigquery/jdbc/dependencies.properties")) {
      if (in != null) {
        props.load(in);
        String version = props.getProperty("version.jdbc");
        if (version != null) {
          return version;
        }
      }
    } catch (IOException e) {
      System.err.println("Error reading dependencies.properties: " + e.getMessage());
    }
    return DEFAULT_VERSION;
  }

  @Test
  public void testGetLibraryVersion() throws IOException, SQLException {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;";
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      String result = connection.getLibraryVersion(BigQueryConnection.class);
      assertEquals(expectedVersion, result);
    }
  }

  @Test
  public void testHeaderProvider() throws IOException, SQLException {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;";
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      HeaderProvider headerProvider = connection.createHeaderProvider();
      String agent = headerProvider.getHeaders().get("user-agent");
      assertTrue(agent.startsWith(DEFAULT_JDBC_TOKEN_VALUE + "/" + expectedVersion));
      assertFalse(agent.contains("(GPN:"));
    }
  }

  @Test
  public void testHeaderProviderWithPartnerToken() throws IOException, SQLException {
    String partnerTokenString = "(GPN:MyPartner; staging)";
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;PartnerToken="
            + partnerTokenString;
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      HeaderProvider headerProvider = connection.createHeaderProvider();
      String agent = headerProvider.getHeaders().get("user-agent");
      assertTrue(
          agent.startsWith(
              DEFAULT_JDBC_TOKEN_VALUE + "/" + expectedVersion + " " + partnerTokenString));
      assertTrue(agent.contains("(GPN:"));
      assertTrue(agent.contains("MyPartner;"));
      assertTrue(agent.contains("staging)"));
    }
  }

  @Test
  public void testHeaderProviderWithEmptyPartnerToken() throws IOException, SQLException {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;PartnerToken=";
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      HeaderProvider headerProvider = connection.createHeaderProvider();
      String agent = headerProvider.getHeaders().get("user-agent");
      assertTrue(agent.startsWith(DEFAULT_JDBC_TOKEN_VALUE + "/" + expectedVersion));
      assertFalse(agent.contains("(GPN:"));
    }
  }

  @Test
  public void testHeaderProviderWithPartnerTokenNoEnv() throws IOException, SQLException {
    String partnerTokenString = "(GPN:MyPartner)";
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;PartnerToken="
            + partnerTokenString;
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      HeaderProvider headerProvider = connection.createHeaderProvider();
      String agent = headerProvider.getHeaders().get("user-agent");
      assertTrue(
          agent.startsWith(
              DEFAULT_JDBC_TOKEN_VALUE + "/" + expectedVersion + " " + partnerTokenString));
      assertTrue(agent.contains("GPN:"));
      assertTrue(agent.contains("MyPartner"));
    }
  }

  @Test
  public void testHeaderProviderWithInvalidPartner() throws IOException, SQLException {
    String partnerTokenString = "(MyPartner; staging)";
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;PartnerToken="
            + partnerTokenString;
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      HeaderProvider headerProvider = connection.createHeaderProvider();
      String agent = headerProvider.getHeaders().get("user-agent");
      assertTrue(agent.startsWith(DEFAULT_JDBC_TOKEN_VALUE + "/" + expectedVersion));
      assertFalse(agent.contains("(MyPartner;"));
      assertFalse(agent.contains("(GPN:"));
    }
  }

  @Test
  public void testWriteAPIConnectionProperties() throws SQLException {
    // Test without connection properties. Defaults to default values.
    String connectionUriDefault =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;";
    try (BigQueryConnection connectionDefault = new BigQueryConnection(connectionUriDefault)) {

      assertFalse(connectionDefault.enableWriteAPI);
      assertEquals(3, connectionDefault.writeAPIActivationRowCount);
      assertEquals(1000, connectionDefault.writeAPIAppendRowCount);
    } catch (IOException | SQLException e) {
      throw new BigQueryJdbcException(e);
    }

    // Test with connection properties
    String connectionUri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;"
            + "EnableWriteAPI=1;SWA_ActivationRowCount=6;SWA_AppendRowCount=500";
    try (BigQueryConnection connection = new BigQueryConnection(connectionUri)) {
      assertTrue(connection.enableWriteAPI);
      assertEquals(6, connection.writeAPIActivationRowCount);
      assertEquals(500, connection.writeAPIAppendRowCount);
    } catch (IOException | SQLException e) {
      throw new BigQueryJdbcException(e);
    }
  }

  @Test
  public void testGetWriteClient() throws SQLException {
    // Test without connection properties. Defaults to default values.
    String connectionUriDefault =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;";
    try (BigQueryConnection connectionDefault = new BigQueryConnection(connectionUriDefault)) {
      assertNull(connectionDefault.bigQueryWriteClient);
      // Lazy initialization
      BigQueryWriteClient writeClient = connectionDefault.getBigQueryWriteClient();
      assertNotNull(writeClient);
      assertFalse(writeClient.isShutdown());
    } catch (SQLException | IOException e) {
      throw new BigQueryJdbcException(e);
    }
  }

  @Test
  public void testAdditionalProjects() throws IOException, BigQueryJdbcException {
    String url1 =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;"
            + "AdditionalProjects=projA,projB";
    try (BigQueryConnection conn1 = new BigQueryConnection(url1)) {
      List<String> additionalProjects1 = conn1.getAdditionalProjects();
      assertNotNull(additionalProjects1);
      assertEquals(Arrays.asList("projA", "projB"), additionalProjects1);
    } catch (SQLException | IOException e) {
      throw new BigQueryJdbcException(e);
    }
    String url2 =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;"
            + "AdditionalProjects=projX";
    try (BigQueryConnection conn2 = new BigQueryConnection(url2)) {
      List<String> additionalProjects2 = conn2.getAdditionalProjects();
      assertNotNull(additionalProjects2);
      assertEquals(Collections.singletonList("projX"), additionalProjects2);
    } catch (SQLException | IOException e) {
      throw new BigQueryJdbcException(e);
    }
  }

  @Test
  public void testFilterTablesOnDefaultDatasetProperty() throws SQLException, IOException {
    // Test default value
    String urlDefault =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;";
    try (BigQueryConnection connectionDefault = new BigQueryConnection(urlDefault)) {
      assertFalse(
          "Default value for FilterTablesOnDefaultDataset should be false",
          connectionDefault.isFilterTablesOnDefaultDataset());
    } catch (SQLException | IOException e) {
      throw new BigQueryJdbcException(e);
    }

    // Test explicitly setting to true
    String urlTrue =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;"
            + "FilterTablesOnDefaultDataset=1;";
    try (BigQueryConnection connectionTrue = new BigQueryConnection(urlTrue)) {
      assertTrue(
          "FilterTablesOnDefaultDataset should be true when set to 1",
          connectionTrue.isFilterTablesOnDefaultDataset());
    } catch (SQLException | IOException e) {
      throw new BigQueryJdbcException(e);
    }
  }

  @Test
  public void testRequestGoogleDriveScopeProperty() throws IOException, SQLException {
    // Test enabled
    String urlEnabled =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;"
            + "RequestGoogleDriveScope=1;";
    try (BigQueryConnection connectionEnabled = new BigQueryConnection(urlEnabled)) {
      assertEquals(
          "RequestGoogleDriveScope should be enabled when set to 1",
          1,
          connectionEnabled.isRequestGoogleDriveScope());
    } catch (SQLException | IOException e) {
      throw new BigQueryJdbcException(e);
    }

    // Test disabled
    String urlDisabled =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;"
            + "RequestGoogleDriveScope=0;";
    try (BigQueryConnection connectionDisabled = new BigQueryConnection(urlDisabled)) {
      assertEquals(
          "RequestGoogleDriveScope should be disabled when set to 0",
          0,
          connectionDisabled.isRequestGoogleDriveScope());
    } catch (SQLException | IOException e) {
      throw new BigQueryJdbcException(e);
    }
  }

  @Test
  public void testMetaDataFetchThreadCountProperty() throws SQLException, IOException {
    // Test Case 1: Should use the default value when the property is not specified.
    String urlDefault =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;";
    try (BigQueryConnection connectionDefault = new BigQueryConnection(urlDefault)) {
      assertEquals(
          "Should use the default value when the property is not set",
          BigQueryJdbcUrlUtility.DEFAULT_METADATA_FETCH_THREAD_COUNT_VALUE,
          connectionDefault.getMetadataFetchThreadCount());
    }

    // Test Case 2: Should use the custom value when a valid integer is provided.
    String urlCustom =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;"
            + "MetaDataFetchThreadCount=16;";
    try (BigQueryConnection connectionCustom = new BigQueryConnection(urlCustom)) {
      assertEquals(
          "Should use the custom value when a valid integer is provided",
          16,
          connectionCustom.getMetadataFetchThreadCount());
    }
  }
}
