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

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.paging.Page;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.Project;
import com.google.cloud.bigquery.QueryJobConfiguration.JobCreationMode;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.storage.v1.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.logging.Logging;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.testing.junit5.OpenTelemetryExtension;
import io.opentelemetry.sdk.trace.data.SpanData;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

public class BigQueryConnectionTest extends BigQueryJdbcLoggingBaseTest {

  @RegisterExtension
  static final OpenTelemetryExtension otelTesting = OpenTelemetryExtension.create();

  private static final String DEFAULT_VERSION = "0.0.0";
  private static final String DEFAULT_JDBC_TOKEN_VALUE = "Google-BigQuery-JDBC-Driver";
  private static final String BASE_URL =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
          + "OAuthType=2;OAuthAccessToken=redacted;ProjectId=project;";
  private String expectedVersion;

  @BeforeEach
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
  public void testHeaderProviderWithRequestReason() throws IOException, SQLException {
    String requestReason = "Ticket123";
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;RequestReason="
            + requestReason;
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      HeaderProvider headerProvider = connection.createHeaderProvider();
      java.util.Map<String, String> headers = headerProvider.getHeaders();
      assertTrue(headers.containsKey("x-goog-request-reason"));
      assertEquals(requestReason, headers.get("x-goog-request-reason"));
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
      String additionalProjects1 = conn1.getAdditionalProjects();
      assertNotNull(additionalProjects1);
      assertEquals("projA,projB", additionalProjects1);
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
      String additionalProjects2 = conn2.getAdditionalProjects();
      assertNotNull(additionalProjects2);
      assertEquals("projX", additionalProjects2);
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
          connectionDefault.isFilterTablesOnDefaultDataset(),
          "Default value for FilterTablesOnDefaultDataset should be false");
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
          connectionTrue.isFilterTablesOnDefaultDataset(),
          "FilterTablesOnDefaultDataset should be true when set to 1");
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
          1,
          connectionEnabled.isRequestGoogleDriveScope(),
          "RequestGoogleDriveScope should be enabled when set to 1");
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
          0,
          connectionDisabled.isRequestGoogleDriveScope(),
          "RequestGoogleDriveScope should be disabled when set to 0");
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
          BigQueryJdbcUrlUtility.DEFAULT_METADATA_FETCH_THREAD_COUNT_VALUE,
          connectionDefault.getMetadataFetchThreadCount(),
          "Should use the default value when the property is not set");
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
          16,
          connectionCustom.getMetadataFetchThreadCount(),
          "Should use the custom value when a valid integer is provided");
    }
  }

  @Test
  public void testBigQueryReadClientKeepAliveSettings() throws SQLException, IOException {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
            + "OAuthClientSecret=redactedToken;";
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      BigQueryReadClient readClient = connection.getBigQueryReadClient();
      assertNotNull(readClient);

      TransportChannelProvider provider = readClient.getSettings().getTransportChannelProvider();
      assertTrue(provider instanceof InstantiatingGrpcChannelProvider);

      InstantiatingGrpcChannelProvider grpcProvider = (InstantiatingGrpcChannelProvider) provider;
      assertEquals(java.time.Duration.ofSeconds(10), grpcProvider.getKeepAliveTimeDuration());
      assertEquals(java.time.Duration.ofSeconds(5), grpcProvider.getKeepAliveTimeoutDuration());
      assertTrue(grpcProvider.getKeepAliveWithoutCalls());
    }
  }

  @Test
  public void testBigQueryJobCreationMode_required() throws Exception {
    String url = BASE_URL + "JobCreationMode=1;";
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      BigQuery bq = connection.getBigQuery();
      assertEquals(
          bq.getOptions().getDefaultJobCreationMode(), JobCreationMode.JOB_CREATION_REQUIRED);
    }
  }

  @Test
  public void testBigQueryJobCreationMode_optional() throws Exception {
    String url = BASE_URL + "JobCreationMode=2;";
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      BigQuery bq = connection.getBigQuery();
      assertEquals(
          bq.getOptions().getDefaultJobCreationMode(), JobCreationMode.JOB_CREATION_OPTIONAL);
    }
  }

  @Test
  public void testBigQueryJobCreationMode_default() throws Exception {
    String url = BASE_URL;
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      BigQuery bq = connection.getBigQuery();
      assertEquals(
          bq.getOptions().getDefaultJobCreationMode(), JobCreationMode.JOB_CREATION_OPTIONAL);
    }
  }

  @Test
  public void testWithDriveScopeTrue() throws Exception {
    String url = BASE_URL + "RequestGoogleDriveScope=1;";
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      assertTrue(connection.reqGoogleDriveScope);
    }
  }

  @Test
  public void testWithDriveScopeFalse() throws Exception {
    String url = BASE_URL + "RequestGoogleDriveScope=0;";
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      assertFalse(connection.reqGoogleDriveScope);
    }
  }

  @Test
  public void testWithDriveScopeDefault() throws Exception {
    String url = BASE_URL;
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      assertFalse(connection.reqGoogleDriveScope);
    }
  }

  @ParameterizedTest
  @CsvSource({"1, true", "0, false", "true, true", "false, false"})
  public void testIsReadOnlyTokenProvided(String readonlyProp, boolean expectedIsReadOnly)
      throws Exception {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=redacted;"
            + "OAuthAccessTokenReadonly="
            + readonlyProp
            + ";";

    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      assertEquals(expectedIsReadOnly, connection.isReadOnlyTokenUsed());
    }
  }

  @Test
  public void testConnect_withCustomOpenTelemetry_usesCustomInstance() throws Exception {
    DataSource ds = DataSource.fromUrl(BASE_URL);
    ds.setCustomOpenTelemetry(otelTesting.getOpenTelemetry());

    try (BigQueryConnection connection = new BigQueryConnection(BASE_URL, ds)) {
      assertNotNull(connection);
      assertFalse(connection.isClosed());

      Tracer tracer = connection.getTracer();
      assertNotNull(tracer);

      Span span = tracer.spanBuilder("custom-otel-span").startSpan();
      span.end();

      List<SpanData> spans = otelTesting.getSpans();
      assertEquals(1, spans.size());
      assertEquals("custom-otel-span", spans.get(0).getName());
    }
  }

  @Test
  public void testConnectionPropertiesLoggingAndMasking() throws IOException, SQLException {
    Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    Level originalLevel = rootLogger.getLevel();
    rootLogger.setLevel(Level.CONFIG);

    try {
      String url =
          "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
              + "OAuthType=2;ProjectId=MyTestProjectId;"
              + "OAuthAccessToken=secretAccessToken;Location=US;";
      try (BigQueryConnection connection = new BigQueryConnection(url)) {
        // Just trigger the constructor
      }

      Optional<LogRecord> connectionPropertiesLog =
          capturedLogs.stream()
              .filter(r -> r.getMessage().contains("Connection properties:"))
              .findFirst();
      assertTrue(
          connectionPropertiesLog.isPresent(),
          "Log message about Connection properties was not found");
      String logMessage = connectionPropertiesLog.get().getMessage();
      assertTrue(logMessage.contains("ProjectId=MyTestProjectId"));
      assertTrue(logMessage.contains("Location=US"));
      assertTrue(logMessage.contains("OAuthAccessToken=*****"));
      assertFalse(logMessage.contains("secretAccessToken"));
    } finally {
      rootLogger.setLevel(originalLevel);
    }
  }

  @ParameterizedTest(
      name =
          "Case {index}: custom={0}, global={1}, trace={2}, log={3} -> expectTrace={4}, expectLog={5}")
  @CsvSource({
    // hasCustom, useGlobal, enableTrace, enableLog, expectTrace,     expectLog
    "true,        true,      true,       true,      CUSTOM,         CUSTOM",
    "true,        false,     true,       true,      CUSTOM,         CUSTOM",
    "false,       true,      true,       true,      GLOBAL,         GLOBAL",
    "false,       true,      false,      false,     GLOBAL,         GLOBAL",
    "false,       false,     true,       false,     DRIVER_MANAGED, NONE",
    "false,       false,     false,      true,      NONE,           DRIVER_MANAGED",
    "false,       false,     true,       true,      DRIVER_MANAGED, DRIVER_MANAGED",
    "false,       false,     false,      false,     NONE,           NONE"
  })
  public void testOpenTelemetryPrecedenceHierarchy(
      boolean hasCustom,
      boolean useGlobal,
      boolean enableTrace,
      boolean enableLog,
      String expectTrace,
      String expectLog)
      throws Exception {

    DataSource ds = DataSource.fromUrl(BASE_URL);
    ds.setUseGlobalOpenTelemetry(useGlobal);
    ds.setEnableGcpTraceExporter(enableTrace);
    ds.setEnableGcpLogExporter(enableLog);

    OpenTelemetry mockCustomOtel = mock(OpenTelemetry.class);
    OpenTelemetry mockGlobalOtel = mock(OpenTelemetry.class);
    OpenTelemetry mockDriverManagedOtel = mock(OpenTelemetry.class);
    Logging mockLogging = mock(Logging.class);
    when(mockCustomOtel.getTracer(anyString())).thenReturn(mock(Tracer.class));
    when(mockGlobalOtel.getTracer(anyString())).thenReturn(mock(Tracer.class));
    when(mockDriverManagedOtel.getTracer(anyString())).thenReturn(mock(Tracer.class));

    if (hasCustom) {
      ds.setCustomOpenTelemetry(mockCustomOtel);
    }

    try (MockedStatic<BigQueryJdbcOpenTelemetry> mockedOtel =
            mockStatic(BigQueryJdbcOpenTelemetry.class);
        MockedStatic<BigQueryJdbcOAuthUtility> mockedAuth =
            mockStatic(BigQueryJdbcOAuthUtility.class);
        MockedStatic<GoogleCredentials> mockedCreds = mockStatic(GoogleCredentials.class)) {

      mockedCreds
          .when(GoogleCredentials::getApplicationDefault)
          .thenReturn(mock(GoogleCredentials.class));

      // Mock parseOAuthProperties to always return ADC type to bypass validation
      mockedAuth
          .when(() -> BigQueryJdbcOAuthUtility.parseOAuthProperties(any(), anyString()))
          .thenAnswer(
              invocation -> {
                java.util.Map<String, String> props = new java.util.HashMap<>();
                props.put(
                    BigQueryJdbcUrlUtility.OAUTH_TYPE_PROPERTY_NAME,
                    "APPLICATION_DEFAULT_CREDENTIALS");
                return props;
              });

      mockedAuth
          .when(() -> BigQueryJdbcOAuthUtility.getCredentials(any(), any(), any(), any(), any()))
          .thenReturn(mock(GoogleCredentials.class));

      mockedOtel
          .when(
              () ->
                  BigQueryJdbcOpenTelemetry.createLoggingClient(
                      anyBoolean(), any(), any(), any(), any()))
          .thenReturn(mockLogging);

      // Stub getOpenTelemetry to return the expected mock based on inputs
      mockedOtel
          .when(
              () ->
                  BigQueryJdbcOpenTelemetry.getOpenTelemetry(
                      eq(useGlobal),
                      eq(enableTrace),
                      eq(enableLog),
                      hasCustom ? eq(mockCustomOtel) : isNull(),
                      any(),
                      any()))
          .thenAnswer(
              invocation -> {
                if (hasCustom) return mockCustomOtel;
                if (useGlobal) return mockGlobalOtel;
                if (enableTrace || enableLog) return mockDriverManagedOtel;
                return OpenTelemetry.noop();
              });

      try (BigQueryConnection connection = new BigQueryConnection(BASE_URL, ds)) {

        boolean shouldBeRegistered = enableLog || hasCustom || useGlobal;

        if (!shouldBeRegistered) {
          mockedOtel.verify(
              () ->
                  BigQueryJdbcOpenTelemetry.registerConnection(
                      anyString(), any(), any(), anyBoolean()),
              never());
        } else {
          final OpenTelemetry expectedOtelInstance;
          if ("CUSTOM".equals(expectTrace) || "CUSTOM".equals(expectLog)) {
            expectedOtelInstance = mockCustomOtel;
          } else if ("GLOBAL".equals(expectTrace) || "GLOBAL".equals(expectLog)) {
            expectedOtelInstance = mockGlobalOtel;
          } else if ("DRIVER_MANAGED".equals(expectTrace) || "DRIVER_MANAGED".equals(expectLog)) {
            expectedOtelInstance = mockDriverManagedOtel;
          } else {
            expectedOtelInstance = OpenTelemetry.noop();
          }

          boolean expectUseDirectGcp = "DRIVER_MANAGED".equals(expectLog);
          Logging expectedLogClient = expectUseDirectGcp ? mockLogging : null;

          mockedOtel.verify(
              () ->
                  BigQueryJdbcOpenTelemetry.registerConnection(
                      anyString(),
                      eq(expectedOtelInstance),
                      eq(expectedLogClient),
                      eq(expectUseDirectGcp)));
        }
      }
    }
  }

  @Test
  public void testWrapperMethods() throws Exception {
    try (BigQueryConnection connection = new BigQueryConnection(BASE_URL)) {
      assertTrue(connection.isWrapperFor(java.sql.Connection.class));
      assertTrue(connection.isWrapperFor(BigQueryConnection.class));
      assertFalse(connection.isWrapperFor(java.sql.Statement.class));
      assertFalse(connection.isWrapperFor(null));

      Object unwrappedConn = connection.unwrap(java.sql.Connection.class);
      assertSame(unwrappedConn, connection);

      Object unwrappedImpl = connection.unwrap(BigQueryConnection.class);
      assertSame(unwrappedImpl, connection);

      BigQueryJdbcException e =
          assertThrows(
              BigQueryJdbcException.class, () -> connection.unwrap(java.sql.Statement.class));
      assertTrue(e.getMessage().contains("Cannot unwrap to java.sql.Statement"));
    }
  }

  @Test
  public void testGetDiscoveredProjects_Success() throws Exception {
    try (BigQueryConnection connection = new BigQueryConnection(BASE_URL)) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      connection.bigQuery = mockBigQuery;

      Page<Project> mockPage = mock(Page.class, withSettings().withoutAnnotations());
      Project project1 = mock(Project.class);
      when(project1.getProjectId()).thenReturn("discovered-p1");
      Project project2 = mock(Project.class);
      when(project2.getProjectId()).thenReturn("discovered-p2");

      when(mockPage.iterateAll()).thenReturn(Arrays.asList(project1, project2));
      when(mockBigQuery.listProjects()).thenReturn(mockPage);

      List<String> discovered = connection.getDiscoveredProjects();
      assertEquals(Arrays.asList("discovered-p1", "discovered-p2"), discovered);

      // Verify caching: second call should not invoke listProjects again
      List<String> discoveredCached = connection.getDiscoveredProjects();
      assertSame(discovered, discoveredCached);
      verify(mockBigQuery, times(1)).listProjects();
    }
  }

  @Test
  public void testGetDiscoveredProjects_BigQueryExceptionThrown() throws Exception {
    try (BigQueryConnection connection = new BigQueryConnection(BASE_URL)) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      connection.bigQuery = mockBigQuery;

      BigQueryException exception = new BigQueryException(403, "Access Denied");
      when(mockBigQuery.listProjects()).thenThrow(exception);

      // Verify that it throws BigQueryJdbcException
      BigQueryJdbcException ex =
          assertThrows(
              BigQueryJdbcException.class,
              () -> {
                connection.getDiscoveredProjects();
              });
      assertTrue(ex.getMessage().contains("Failed to list all accessible projects."));
      assertEquals(exception, ex.getCause());

      // Subsequent call should retry since no cache is set
      assertThrows(
          BigQueryJdbcException.class,
          () -> {
            connection.getDiscoveredProjects();
          });
      verify(mockBigQuery, times(2)).listProjects();
    }
  }

  @Test
  public void testGetDiscoveredProjects_OtherExceptionThrown() throws Exception {
    try (BigQueryConnection connection = new BigQueryConnection(BASE_URL)) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      connection.bigQuery = mockBigQuery;

      RuntimeException exception = new RuntimeException("Generic Network Failure");
      when(mockBigQuery.listProjects()).thenThrow(exception);

      // Verify that it throws BigQueryJdbcException
      BigQueryJdbcException ex =
          assertThrows(
              BigQueryJdbcException.class,
              () -> {
                connection.getDiscoveredProjects();
              });
      assertTrue(ex.getMessage().contains("Failed to list all accessible projects."));
      assertEquals(exception, ex.getCause());
    }
  }
}
