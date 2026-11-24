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
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
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
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.RetryOption;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.DataFormatOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobStatistics.SessionInfo;
import com.google.cloud.bigquery.JobStatus;
import com.google.cloud.bigquery.Project;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryJobConfiguration.JobCreationMode;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.jdbc.utils.URIBuilder;
import com.google.cloud.bigquery.storage.v1.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1.BigQueryReadSettings;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteSettings;
import com.google.cloud.logging.Logging;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.testing.junit5.OpenTelemetryExtension;
import io.opentelemetry.sdk.trace.data.SpanData;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import org.mockito.MockedStatic;

public class BigQueryConnectionTest extends BigQueryJdbcLoggingBaseTest {

  @RegisterExtension
  static final OpenTelemetryExtension otelTesting = OpenTelemetryExtension.create();

  private static final String DEFAULT_VERSION = "0.0.0";
  private static final String DEFAULT_JDBC_TOKEN_VALUE = "Google-BigQuery-JDBC-Driver";
  private static final String CUSTOM_UNIVERSE = "example.com";
  private static final String DEFAULT_UNIVERSE = "googleapis.com";
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
    } catch (SQLException e) {
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
    } catch (SQLException e) {
      throw new BigQueryJdbcException(e);
    }
  }

  @Test
  public void testTimestampPicosControlsDataFormatOptions() throws SQLException {
    try (BigQueryConnection connection =
        new BigQueryConnection(BASE_URL + "EnableTimestampPicos=1;")) {
      assertEquals(
          DataFormatOptions.TimestampFormatOptions.ISO8601_STRING,
          connection.getBigQuery().getOptions().getDataFormatOptions().timestampFormatOptions(),
          "EnableTimestampPicos=1 must request ISO8601 timestamp serialization");
    }

    try (BigQueryConnection connection = new BigQueryConnection(BASE_URL)) {
      assertTrue(
          connection.getBigQuery().getOptions().getDataFormatOptions().useInt64Timestamp(),
          "Default connections must request lossless int64 timestamps");
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
    } catch (SQLException e) {
      throw new BigQueryJdbcException(e);
    }
  }

  @Test
  public void testAdditionalProjects() throws BigQueryJdbcException {
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
    } catch (SQLException e) {
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
    } catch (SQLException e) {
      throw new BigQueryJdbcException(e);
    }
  }

  @Test
  public void testFilterTablesOnDefaultDatasetProperty() throws SQLException {
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
    } catch (SQLException e) {
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
    } catch (SQLException e) {
      throw new BigQueryJdbcException(e);
    }
  }

  @Test
  public void testRequestGoogleDriveScopeProperty() throws SQLException {
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
    } catch (SQLException e) {
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
    } catch (SQLException e) {
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
                      anyBoolean(), any(), any(), any(), any(), any(), any()))
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
                      any(),
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

  @Test
  public void testSessionIdIsWriteOnce() throws Exception {
    try (BigQueryConnection connection = new BigQueryConnection(BASE_URL)) {
      assertNull(connection.getSessionInfoConnectionProperty());

      connection.initSessionInfo("test_session_id_1");
      assertNotNull(connection.getSessionInfoConnectionProperty());
      assertEquals("session_id", connection.getSessionInfoConnectionProperty().getKey());
      assertEquals("test_session_id_1", connection.getSessionInfoConnectionProperty().getValue());

      // Verify queryProperties contains session_id
      boolean found =
          connection.getQueryProperties().stream()
              .anyMatch(
                  cp ->
                      "session_id".equalsIgnoreCase(cp.getKey())
                          && "test_session_id_1".equals(cp.getValue()));
      assertTrue(found, "queryProperties should contain session_id property");

      // A connection's session is write-once: a second, different id is ignored rather than
      // silently swapping the session and stranding the original.
      connection.initSessionInfo("test_session_id_2");
      assertEquals("test_session_id_1", connection.getSessionInfoConnectionProperty().getValue());
      long count =
          connection.getQueryProperties().stream()
              .filter(cp -> "session_id".equalsIgnoreCase(cp.getKey()))
              .count();
      assertEquals(1, count, "Should only have 1 session_id property in queryProperties");
    }
  }

  @Test
  public void testUserSuppliedSessionId() throws Exception {
    String urlWithSessionId =
        BASE_URL + ";EnableSession=1;QueryProperties=session_id=user_supplied_session_999";
    try (BigQueryConnection connection = new BigQueryConnection(urlWithSessionId)) {
      assertTrue(connection.isSessionEnabled());
      assertFalse(connection.isSessionCreatedByDriver());
      assertNotNull(connection.getSessionInfoConnectionProperty());
      assertEquals("session_id", connection.getSessionInfoConnectionProperty().getKey());
      assertEquals(
          "user_supplied_session_999", connection.getSessionInfoConnectionProperty().getValue());
    }
  }

  @Test
  public void testCloseAbortsSessionCreatedByDriver() throws Exception {
    try (BigQueryConnection connection = new BigQueryConnection(BASE_URL + ";EnableSession=1")) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      connection.bigQuery = mockBigQuery;

      // BEGIN TRANSACTION asks BigQuery to create the session, and the result carries the new id.
      SessionInfo sessionInfo = mock(SessionInfo.class);
      when(sessionInfo.getSessionId()).thenReturn("driver_created_session");
      TableResult beginResult = mock(TableResult.class);
      when(beginResult.getSessionInfo()).thenReturn(sessionInfo);
      when(mockBigQuery.query(any(QueryJobConfiguration.class))).thenReturn(beginResult);

      // close() rolls the open transaction back before it aborts the session.
      Job rollbackJob = mock(Job.class);
      when(mockBigQuery.create(any(JobInfo.class))).thenReturn(rollbackJob);
      when(rollbackJob.waitFor()).thenReturn(rollbackJob);

      // Drives beginTransaction(), which claims ownership before the id is known.
      connection.setAutoCommit(false);

      assertTrue(connection.isSessionCreatedByDriver());
      assertEquals(
          "driver_created_session", connection.getSessionInfoConnectionProperty().getValue());

      connection.close();

      // close() also rolls back the open transaction, so match on the abort specifically.
      ArgumentCaptor<QueryJobConfiguration> jobCaptor =
          ArgumentCaptor.forClass(QueryJobConfiguration.class);
      verify(mockBigQuery, atLeastOnce()).query(jobCaptor.capture());
      assertTrue(
          jobCaptor.getAllValues().stream()
              .anyMatch(config -> "CALL BQ.ABORT_SESSION();".equals(config.getQuery())));
      assertNull(connection.getSessionInfoConnectionProperty());
      assertFalse(connection.isSessionCreatedByDriver());
      assertTrue(connection.isClosed());
    }
  }

  @Test
  public void testEnableTimestampPicosDefault() throws Exception {
    try (BigQueryConnection connection = new BigQueryConnection(BASE_URL)) {
      assertFalse(connection.isEnableTimestampPicos());
    }
  }

  @Test
  public void testCloseWithUserSuppliedSessionDoesNotAbortSession() throws Exception {
    String urlWithSessionId =
        BASE_URL + ";EnableSession=1;QueryProperties=session_id=user_supplied_session_999";
    try (BigQueryConnection connection = new BigQueryConnection(urlWithSessionId)) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      connection.bigQuery = mockBigQuery;

      assertFalse(connection.isSessionCreatedByDriver());
      assertEquals(
          "user_supplied_session_999", connection.getSessionInfoConnectionProperty().getValue());

      connection.close();

      verify(mockBigQuery, never()).create(any(JobInfo.class));
      assertTrue(connection.isClosed());
    }
  }

  @Test
  public void testCloseWithoutSessionDoesNotAbortSession() throws Exception {
    try (BigQueryConnection connection = new BigQueryConnection(BASE_URL)) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      connection.bigQuery = mockBigQuery;

      connection.close();

      verify(mockBigQuery, never()).query(any(QueryJobConfiguration.class));
      assertTrue(connection.isClosed());
    }
  }

  @Test
  public void testEnableTimestampPicosConfigured() throws Exception {
    String url = BASE_URL + "EnableTimestampPicos=1;";
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      assertTrue(connection.isEnableTimestampPicos());
    }
  }

  @Test
  public void testSessionIdIsMatchedRegardlessOfCase() throws Exception {
    String url = BASE_URL + ";QueryProperties=Session_Id=abc123";
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      assertNotNull(connection.getSessionInfoConnectionProperty());
      assertEquals("abc123", connection.getSessionInfoConnectionProperty().getValue());
    }
  }

  @Test
  public void testSessionIdKeyIsNormalizedInQueryProperties() throws Exception {
    String url = BASE_URL + ";QueryProperties=SESSION_ID=abc123";
    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      // The key reaches BigQuery lowercased
      assertTrue(
          connection.getQueryProperties().stream()
              .anyMatch(cp -> "session_id".equals(cp.getKey())));
    }
  }

  @Test
  public void testDuplicateSessionIdKeysAreRejected() {
    String url = BASE_URL + ";QueryProperties=session_id=a,Session_Id=b";
    BigQueryJdbcException ex =
        assertThrows(BigQueryJdbcException.class, () -> new BigQueryConnection(url));
    assertTrue(ex.getMessage().contains("multiple 'session_id' entries"));
  }

  @Test
  public void testReadAndWriteClientsScopeServiceAccountCredentialsForCustomUniverse()
      throws Exception {
    String url =
        getUriOAuthServiceAccount()
            .append("ProjectId", "project")
            .append("universeDomain", CUSTOM_UNIVERSE)
            .toString();

    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      BigQueryReadClient readClient = connection.getBigQueryReadClient();
      assertEquals(CUSTOM_UNIVERSE, readClient.getSettings().getUniverseDomain());
      assertStorageCredentialsScoped(
          readClient.getSettings().getCredentialsProvider().getCredentials(),
          CUSTOM_UNIVERSE,
          storageUri(CUSTOM_UNIVERSE, "BigQueryRead"),
          BigQueryReadSettings.getDefaultServiceScopes());

      BigQueryWriteClient writeClient = connection.getBigQueryWriteClient();
      assertEquals(CUSTOM_UNIVERSE, writeClient.getSettings().getUniverseDomain());
      assertStorageCredentialsScoped(
          writeClient.getSettings().getCredentialsProvider().getCredentials(),
          CUSTOM_UNIVERSE,
          storageUri(CUSTOM_UNIVERSE, "BigQueryWrite"),
          BigQueryWriteSettings.getDefaultServiceScopes());
    }
  }

  @Test
  public void testReadAndWriteClientsScopeServiceAccountCredentialsForDefaultUniverse()
      throws Exception {
    String url = getUriOAuthServiceAccount().append("ProjectId", "project").toString();

    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      BigQueryReadClient readClient = connection.getBigQueryReadClient();
      assertEquals(DEFAULT_UNIVERSE, readClient.getSettings().getUniverseDomain());
      assertStorageCredentialsScoped(
          readClient.getSettings().getCredentialsProvider().getCredentials(),
          DEFAULT_UNIVERSE,
          storageUri(DEFAULT_UNIVERSE, "BigQueryRead"),
          BigQueryReadSettings.getDefaultServiceScopes());

      BigQueryWriteClient writeClient = connection.getBigQueryWriteClient();
      assertEquals(DEFAULT_UNIVERSE, writeClient.getSettings().getUniverseDomain());
      assertStorageCredentialsScoped(
          writeClient.getSettings().getCredentialsProvider().getCredentials(),
          DEFAULT_UNIVERSE,
          storageUri(DEFAULT_UNIVERSE, "BigQueryWrite"),
          BigQueryWriteSettings.getDefaultServiceScopes());
    }
  }

  @Test
  public void testReadAndWriteClientsPassThroughNonServiceAccountCredentials() throws Exception {
    String url = getUriOAuthToken().append("ProjectId", "project").toString();

    try (BigQueryConnection connection = new BigQueryConnection(url)) {
      Credentials readCredentials =
          connection
              .getBigQueryReadClient()
              .getSettings()
              .getCredentialsProvider()
              .getCredentials();
      Credentials writeCredentials =
          connection
              .getBigQueryWriteClient()
              .getSettings()
              .getCredentialsProvider()
              .getCredentials();

      assertFalse(readCredentials instanceof ServiceAccountCredentials);
      assertSame(connection.credentials, readCredentials);
      assertSame(connection.credentials, writeCredentials);
      assertEquals(
          "Bearer RedactedToken",
          readCredentials
              .getRequestMetadata(storageUri(DEFAULT_UNIVERSE, "BigQueryRead"))
              .get("Authorization")
              .get(0));
    }
  }

  @Test
  public void testScopeStorageCredentialsPreservesExplicitScopes() throws Exception {
    List<String> explicitScopes =
        Arrays.asList(
            "https://www.googleapis.com/auth/bigquery",
            "https://www.googleapis.com/auth/drive.readonly");
    Credentials alreadyScoped =
        ServiceAccountCredentials.newBuilder()
            .setClientEmail("service@account")
            .setPrivateKeyString(fake_pkcs8_key)
            .setUniverseDomain(CUSTOM_UNIVERSE)
            .build()
            .createScoped(explicitScopes);

    Credentials result =
        BigQueryConnection.scopeStorageCredentials(
            alreadyScoped, BigQueryReadSettings.getDefaultServiceScopes());

    assertStorageCredentialsScoped(
        result, CUSTOM_UNIVERSE, storageUri(CUSTOM_UNIVERSE, "BigQueryRead"), explicitScopes);
  }

  @Test
  public void testCustomUniverseDomainServiceAccountJsonKeyNotOverwrittenWhenUniverseDomainOmitted()
      throws Exception {
    JsonObject saJson = new JsonObject();
    saJson.addProperty("type", "service_account");
    saJson.addProperty("project_id", "custom-universe-project");
    saJson.addProperty("private_key_id", "key-id-1");
    saJson.addProperty("private_key", fake_pkcs8_key);
    saJson.addProperty("client_email", "sa@custom-universe-project.iam.gserviceaccount.com");
    saJson.addProperty("client_id", "123456");
    saJson.addProperty("universe_domain", CUSTOM_UNIVERSE);

    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=custom-universe-project;OAuthType=0;EnableDiagnosticTelemetry=0;"
            + "OAuthServiceAcctEmail=sa@custom-universe-project.iam.gserviceaccount.com;OAuthPvtKey="
            + saJson;

    try (MockedStatic<BigQueryJdbcUrlUtility> urlUtil =
        mockStatic(BigQueryJdbcUrlUtility.class, CALLS_REAL_METHODS)) {
      urlUtil.when(BigQueryJdbcUrlUtility::getEnvUniverseDomain).thenReturn(null);
      try (BigQueryConnection connection = new BigQueryConnection(url)) {
        assertNull(connection.universeDomain);
        assertFalse(
            connection.overrideProperties.containsKey(
                BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME));
        assertEquals(CUSTOM_UNIVERSE, connection.credentials.getUniverseDomain());
        // Client-side universe validation must fail-closed before any network RPC is sent to GDU.
        BigQueryException ex =
            assertThrows(
                BigQueryException.class,
                () ->
                    connection
                        .getBigQuery()
                        .query(QueryJobConfiguration.newBuilder("SELECT 1").build()));
        assertTrue(ex.getMessage().contains("does not match the universe domain"));
      }

      // Explicit universeDomain in URL must also NOT overwrite the JSON key's universe_domain.
      try (BigQueryConnection explicitMismatchConn =
          new BigQueryConnection(url + ";universeDomain=other-universe.example.com")) {
        assertEquals("other-universe.example.com", explicitMismatchConn.universeDomain);
        assertEquals(CUSTOM_UNIVERSE, explicitMismatchConn.credentials.getUniverseDomain());
        BigQueryException ex =
            assertThrows(
                BigQueryException.class,
                () ->
                    explicitMismatchConn
                        .getBigQuery()
                        .query(QueryJobConfiguration.newBuilder("SELECT 1").build()));
        assertTrue(ex.getMessage().contains("does not match the universe domain"));
      }
    }
  }

  @Test
  public void testConnectionHonorsEnvUniverseDomainWithoutOverwritingJsonCredentials()
      throws Exception {
    JsonObject gduSaJson = new JsonObject();
    gduSaJson.addProperty("type", "service_account");
    gduSaJson.addProperty("project_id", "gdu-project");
    gduSaJson.addProperty("private_key_id", "key-id-2");
    gduSaJson.addProperty("private_key", fake_pkcs8_key);
    gduSaJson.addProperty("client_email", "sa@gdu-project.iam.gserviceaccount.com");
    gduSaJson.addProperty("client_id", "654321");

    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=gdu-project;OAuthType=0;EnableDiagnosticTelemetry=0;"
            + "OAuthServiceAcctEmail=sa@gdu-project.iam.gserviceaccount.com;OAuthPvtKey="
            + gduSaJson;

    try (MockedStatic<BigQueryJdbcUrlUtility> urlUtil =
        mockStatic(BigQueryJdbcUrlUtility.class, CALLS_REAL_METHODS)) {
      urlUtil.when(BigQueryJdbcUrlUtility::getEnvUniverseDomain).thenReturn(CUSTOM_UNIVERSE);
      try (BigQueryConnection connection = new BigQueryConnection(url)) {
        // Clients honor GOOGLE_CLOUD_UNIVERSE_DOMAIN, while GDU JSON credential stays
        // googleapis.com
        assertEquals(CUSTOM_UNIVERSE, connection.universeDomain);
        assertEquals(CUSTOM_UNIVERSE, connection.getBigQuery().getOptions().getUniverseDomain());
        assertEquals(
            CUSTOM_UNIVERSE, connection.getBigQueryReadClient().getSettings().getUniverseDomain());
        assertEquals(
            CUSTOM_UNIVERSE, connection.getBigQueryWriteClient().getSettings().getUniverseDomain());
        assertFalse(
            connection.overrideProperties.containsKey(
                BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME));
        assertEquals(DEFAULT_UNIVERSE, connection.credentials.getUniverseDomain());
      }
    }

    // Blank/whitespace GOOGLE_CLOUD_UNIVERSE_DOMAIN resolves to googleapis.com so GAX clients
    // do not re-read the raw empty env var and construct an invalid host.
    try (MockedStatic<BigQueryJdbcUrlUtility> blankEnvUtil =
        mockStatic(BigQueryJdbcUrlUtility.class, CALLS_REAL_METHODS)) {
      blankEnvUtil.when(BigQueryJdbcUrlUtility::readRawEnvUniverseDomain).thenReturn("");
      try (BigQueryConnection blankEnvConn = new BigQueryConnection(url)) {
        assertEquals(DEFAULT_UNIVERSE, blankEnvConn.universeDomain);
        assertEquals(DEFAULT_UNIVERSE, blankEnvConn.getBigQuery().getOptions().getUniverseDomain());
        assertEquals(
            DEFAULT_UNIVERSE,
            blankEnvConn.getBigQueryReadClient().getSettings().getUniverseDomain());
        assertEquals(
            DEFAULT_UNIVERSE,
            blankEnvConn.getBigQueryWriteClient().getSettings().getUniverseDomain());
        assertFalse(
            blankEnvConn.overrideProperties.containsKey(
                BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME));
      }
    }
  }

  @Test
  public void
      testConnectionCustomUniverseDomainJsonKeyMatchesEnvUniverseDomainAcrossAllThreeClients()
          throws Exception {
    JsonObject customSaJson = new JsonObject();
    customSaJson.addProperty("type", "service_account");
    customSaJson.addProperty("project_id", "custom-universe-project");
    customSaJson.addProperty("private_key_id", "key-id-3");
    customSaJson.addProperty("private_key", fake_pkcs8_key);
    customSaJson.addProperty("client_email", "sa@custom-universe-project.iam.gserviceaccount.com");
    customSaJson.addProperty("client_id", "999999");
    customSaJson.addProperty("universe_domain", CUSTOM_UNIVERSE);

    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=custom-universe-project;OAuthType=0;EnableDiagnosticTelemetry=0;"
            + "OAuthServiceAcctEmail=sa@custom-universe-project.iam.gserviceaccount.com;OAuthPvtKey="
            + customSaJson;

    try (MockedStatic<BigQueryJdbcUrlUtility> urlUtil =
        mockStatic(BigQueryJdbcUrlUtility.class, CALLS_REAL_METHODS)) {
      urlUtil.when(BigQueryJdbcUrlUtility::getEnvUniverseDomain).thenReturn(CUSTOM_UNIVERSE);
      try (BigQueryConnection connection = new BigQueryConnection(url)) {
        assertEquals(CUSTOM_UNIVERSE, connection.universeDomain);
        assertEquals(CUSTOM_UNIVERSE, connection.credentials.getUniverseDomain());
        assertTrue(connection.getBigQuery().getOptions().hasValidUniverseDomain());
        assertStorageCredentialsScoped(
            connection
                .getBigQueryReadClient()
                .getSettings()
                .getCredentialsProvider()
                .getCredentials(),
            CUSTOM_UNIVERSE,
            storageUri(CUSTOM_UNIVERSE, "BigQueryRead"),
            BigQueryReadSettings.getDefaultServiceScopes());
        assertStorageCredentialsScoped(
            connection
                .getBigQueryWriteClient()
                .getSettings()
                .getCredentialsProvider()
                .getCredentials(),
            CUSTOM_UNIVERSE,
            storageUri(CUSTOM_UNIVERSE, "BigQueryWrite"),
            BigQueryWriteSettings.getDefaultServiceScopes());
      }
    }
  }

  private static URI storageUri(String universeDomain, String service) {
    return URI.create(
        "https://bigquerystorage."
            + universeDomain
            + "/google.cloud.bigquery.storage.v1."
            + service);
  }

  /**
   * Asserts that {@code credentials} are service account credentials that sign a self-signed JWT
   * carrying {@code expectedScopes} (and no audience) for the given universe.
   */
  private static void assertStorageCredentialsScoped(
      Credentials credentials, String expectedUniverse, URI uri, List<String> expectedScopes)
      throws IOException {
    assertTrue(credentials instanceof ServiceAccountCredentials);
    ServiceAccountCredentials sa = (ServiceAccountCredentials) credentials;
    assertFalse(sa.createScopedRequired());
    assertTrue(sa.getUseJwtAccessWithScope());
    assertEquals(expectedUniverse, sa.getUniverseDomain());

    JsonObject jwtPayload = extractBearerJwtPayload(credentials, uri);
    assertFalse(jwtPayload.has("aud"));
    assertTrue(jwtPayload.has("scope"));
    String scopeClaim = jwtPayload.get("scope").getAsString();
    for (String expectedScope : expectedScopes) {
      assertTrue(scopeClaim.contains(expectedScope), "Missing scope: " + expectedScope);
    }
  }

  private static JsonObject extractBearerJwtPayload(Credentials credentials, URI uri)
      throws IOException {
    Map<String, List<String>> metadata = credentials.getRequestMetadata(uri);
    String authHeader = metadata.get("Authorization").get(0);
    assertTrue(authHeader.startsWith("Bearer "));
    String jwt = authHeader.substring("Bearer ".length());
    String[] parts = jwt.split("\\.");
    assertEquals(3, parts.length);
    String payloadJson =
        new String(Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8);
    return JsonParser.parseString(payloadJson).getAsJsonObject();
  }

  private static URIBuilder sessionEnabledUri() {
    return getUriOAuthToken().append("ProjectId", "test-project").append("EnableSession", 1);
  }

  @Test
  public void testResetForReuse_rollsBackActiveTransactionWithoutStartingNewOne() throws Exception {
    try (BigQueryConnection conn = new BigQueryConnection(sessionEnabledUri().toString())) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      conn.bigQuery = mockBigQuery;

      SessionInfo sessionInfo = mock(SessionInfo.class);
      when(sessionInfo.getSessionId()).thenReturn("driver_tx_session");
      TableResult beginResult = mock(TableResult.class);
      when(beginResult.getSessionInfo()).thenReturn(sessionInfo);
      when(mockBigQuery.query(any(QueryJobConfiguration.class))).thenReturn(beginResult);

      Job rollbackJob = mock(Job.class);
      when(mockBigQuery.create(any(JobInfo.class))).thenReturn(rollbackJob);
      when(rollbackJob.waitFor()).thenReturn(rollbackJob);

      conn.setAutoCommit(false);
      assertTrue(conn.isTransactionStarted());
      assertFalse(conn.getAutoCommit());

      conn.resetForReuse();

      assertFalse(conn.isTransactionStarted());
      assertTrue(conn.getAutoCommit());
      assertNull(conn.getSessionInfoConnectionProperty());

      ArgumentCaptor<JobInfo> jobCaptor = ArgumentCaptor.forClass(JobInfo.class);
      verify(mockBigQuery, times(1)).create(jobCaptor.capture());
      QueryJobConfiguration rollbackConfig = jobCaptor.getValue().getConfiguration();
      assertEquals("ROLLBACK TRANSACTION;", rollbackConfig.getQuery());

      ArgumentCaptor<QueryJobConfiguration> queryCaptor =
          ArgumentCaptor.forClass(QueryJobConfiguration.class);
      verify(mockBigQuery, atLeastOnce()).query(queryCaptor.capture());
      List<QueryJobConfiguration> executedQueries = queryCaptor.getAllValues();
      long beginCount =
          executedQueries.stream()
              .filter(cfg -> "BEGIN TRANSACTION;".equals(cfg.getQuery()))
              .count();
      assertEquals(1L, beginCount, "Reset must not start a follow-up transaction after rollback");
      assertTrue(
          executedQueries.stream()
              .anyMatch(cfg -> "CALL BQ.ABORT_SESSION();".equals(cfg.getQuery())));
      assertFalse(
          executedQueries.stream().anyMatch(cfg -> "COMMIT TRANSACTION;".equals(cfg.getQuery())));
    }
  }

  @Test
  public void testResetForReuse_abortsDriverCreatedSessionAndPreservesQueryProperties()
      throws Exception {
    String url =
        sessionEnabledUri().append("QueryProperties", "time_zone=America/Los_Angeles").toString();
    try (BigQueryConnection conn = new BigQueryConnection(url)) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      conn.bigQuery = mockBigQuery;
      when(mockBigQuery.query(any(QueryJobConfiguration.class)))
          .thenReturn(mock(TableResult.class));

      conn.markSessionCreatedByDriver();
      conn.initSessionInfo("driver_query_session_1");
      assertEquals("driver_query_session_1", conn.getSessionInfoConnectionProperty().getValue());
      assertTrue(conn.isSessionCreatedByDriver());

      conn.resetForReuse();

      assertNull(conn.getSessionInfoConnectionProperty());
      assertFalse(conn.isSessionCreatedByDriver());
      assertTrue(
          conn.getQueryProperties().stream()
              .anyMatch(
                  cp ->
                      "time_zone".equals(cp.getKey())
                          && "America/Los_Angeles".equals(cp.getValue())));
      assertFalse(
          conn.getQueryProperties().stream()
              .anyMatch(cp -> "session_id".equalsIgnoreCase(cp.getKey())));

      ArgumentCaptor<QueryJobConfiguration> queryCaptor =
          ArgumentCaptor.forClass(QueryJobConfiguration.class);
      verify(mockBigQuery).query(queryCaptor.capture());
      assertEquals("CALL BQ.ABORT_SESSION();", queryCaptor.getValue().getQuery());
    }
  }

  @Test
  public void testResetForReuse_preservesUserConfiguredSessionIdWhileRollingBackTransaction()
      throws Exception {
    String url =
        sessionEnabledUri().append("QueryProperties", "session_id=caller_owned_77").toString();
    try (BigQueryConnection conn = new BigQueryConnection(url)) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      conn.bigQuery = mockBigQuery;

      SessionInfo sessionInfo = mock(SessionInfo.class);
      when(sessionInfo.getSessionId()).thenReturn("caller_owned_77");
      TableResult beginResult = mock(TableResult.class);
      when(beginResult.getSessionInfo()).thenReturn(sessionInfo);
      when(mockBigQuery.query(any(QueryJobConfiguration.class))).thenReturn(beginResult);

      Job rollbackJob = mock(Job.class);
      when(mockBigQuery.create(any(JobInfo.class))).thenReturn(rollbackJob);
      when(rollbackJob.waitFor()).thenReturn(rollbackJob);

      conn.setAutoCommit(false);
      conn.resetForReuse();

      assertFalse(conn.isTransactionStarted());
      assertTrue(conn.getAutoCommit());
      assertFalse(conn.isSessionCreatedByDriver());
      assertNotNull(conn.getSessionInfoConnectionProperty());
      assertEquals("caller_owned_77", conn.getSessionInfoConnectionProperty().getValue());

      ArgumentCaptor<QueryJobConfiguration> queryCaptor =
          ArgumentCaptor.forClass(QueryJobConfiguration.class);
      verify(mockBigQuery, atLeastOnce()).query(queryCaptor.capture());
      assertFalse(
          queryCaptor.getAllValues().stream()
              .anyMatch(cfg -> "CALL BQ.ABORT_SESSION();".equals(cfg.getQuery())));
    }
  }

  @Test
  public void testResetForReuse_resetsClientInfoWarningsHoldabilityAndClosesOpenStatements()
      throws Exception {
    String url = getUriOAuthToken().append("ProjectId", "test-project").toString();
    BigQueryConnection closedConn;
    try (BigQueryConnection conn = new BigQueryConnection(url)) {
      closedConn = conn;
      assertEquals(ResultSet.CLOSE_CURSORS_AT_COMMIT, conn.getHoldability());
      Statement stmt = conn.createStatement();
      PreparedStatement pstmt = conn.prepareStatement("SELECT 1");

      conn.setClientInfo("ApplicationName", "BillingReport");
      conn.sqlWarnings.add(new SQLWarning("sample warning"));
      conn.holdability = ResultSet.HOLD_CURSORS_OVER_COMMIT;
      assertEquals(2, conn.openStatements.size());

      conn.resetForReuse();

      assertTrue(stmt.isClosed());
      assertTrue(pstmt.isClosed());
      assertTrue(conn.openStatements.isEmpty());
      assertTrue(conn.getClientInfo().isEmpty());
      assertNull(conn.getWarnings());
      assertEquals(ResultSet.CLOSE_CURSORS_AT_COMMIT, conn.getHoldability());
    }
    assertThrows(BigQueryJdbcException.class, closedConn::resetForReuse);
  }

  @Test
  public void testResetForReuse_abortsDriverSessionEvenWhenCallingThreadIsInterrupted()
      throws Exception {
    try (BigQueryConnection conn = new BigQueryConnection(sessionEnabledUri().toString())) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      conn.bigQuery = mockBigQuery;
      // Simulate real BigQueryImpl / AbstractFuture.get(), which throws immediately if the calling
      // thread enters the RPC with its interrupt flag still set.
      when(mockBigQuery.query(any(QueryJobConfiguration.class)))
          .thenAnswer(
              invocation -> {
                if (Thread.interrupted()) {
                  throw new BigQueryException(0, "interrupted before RPC");
                }
                return mock(TableResult.class);
              });

      conn.markSessionCreatedByDriver();
      conn.initSessionInfo("interrupted_caller_session");

      Thread.currentThread().interrupt();
      try {
        conn.resetForReuse();
        assertTrue(Thread.currentThread().isInterrupted());
        assertNull(conn.getSessionInfoConnectionProperty());
        assertFalse(conn.isSessionCreatedByDriver());

        ArgumentCaptor<QueryJobConfiguration> queryCaptor =
            ArgumentCaptor.forClass(QueryJobConfiguration.class);
        verify(mockBigQuery).query(queryCaptor.capture());
        assertEquals("CALL BQ.ABORT_SESSION();", queryCaptor.getValue().getQuery());
      } finally {
        Thread.interrupted();
      }
    }
  }

  @Test
  public void testResetForReuse_preservesSessionAndTransactionForPhysicalCloseWhenInterrupted()
      throws Exception {
    BigQueryConnection conn = new BigQueryConnection(sessionEnabledUri().toString());
    BigQuery mockBigQuery = mock(BigQuery.class);
    conn.bigQuery = mockBigQuery;

    SessionInfo sessionInfo = mock(SessionInfo.class);
    when(sessionInfo.getSessionId()).thenReturn("driver_tx_session");
    TableResult beginResult = mock(TableResult.class);
    when(beginResult.getSessionInfo()).thenReturn(sessionInfo);
    when(mockBigQuery.query(any(QueryJobConfiguration.class)))
        .thenAnswer(
            invocation -> {
              QueryJobConfiguration cfg = invocation.getArgument(0);
              if ("BEGIN TRANSACTION;".equals(cfg.getQuery())) {
                return beginResult;
              }
              throw new InterruptedException("interrupted session abort");
            });

    Job rollbackJob = mock(Job.class);
    when(mockBigQuery.create(any(JobInfo.class))).thenReturn(rollbackJob);
    when(rollbackJob.waitFor()).thenThrow(new InterruptedException("interrupted rollback"));

    conn.setAutoCommit(false);
    Statement failingStmt = mock(Statement.class);
    SQLException stmtCloseEx = new SQLException("statement close failed");
    doThrow(stmtCloseEx).when(failingStmt).close();
    conn.openStatements.add(failingStmt);

    try {
      SQLException thrown = assertThrows(SQLException.class, conn::resetForReuse);
      assertSame(stmtCloseEx, thrown);
      assertEquals(2, thrown.getSuppressed().length);
      assertTrue(Thread.currentThread().isInterrupted());
      assertTrue(conn.isTransactionStarted());
      assertNotNull(conn.getSessionInfoConnectionProperty());
      assertEquals("driver_tx_session", conn.getSessionInfoConnectionProperty().getValue());
    } finally {
      Thread.interrupted();
    }

    // Subsequent physical close must still see the active transaction and session and clean up.
    doReturn(rollbackJob).when(rollbackJob).waitFor();
    when(mockBigQuery.query(any(QueryJobConfiguration.class))).thenReturn(mock(TableResult.class));
    conn.close();

    assertFalse(conn.isTransactionStarted());
    assertNull(conn.getSessionInfoConnectionProperty());
    verify(mockBigQuery, times(2)).create(any(JobInfo.class));
    ArgumentCaptor<QueryJobConfiguration> queryCaptor =
        ArgumentCaptor.forClass(QueryJobConfiguration.class);
    verify(mockBigQuery, times(3)).query(queryCaptor.capture());
    long abortCount =
        queryCaptor.getAllValues().stream()
            .filter(cfg -> "CALL BQ.ABORT_SESSION();".equals(cfg.getQuery()))
            .count();
    assertEquals(2L, abortCount);
  }

  @Test
  public void testClose_rollsBackActiveTransactionWithoutStartingFollowUpTransaction()
      throws Exception {
    String url =
        sessionEnabledUri().append("QueryProperties", "session_id=caller_owned_close").toString();
    BigQueryConnection conn = new BigQueryConnection(url);
    BigQuery mockBigQuery = mock(BigQuery.class);
    conn.bigQuery = mockBigQuery;

    SessionInfo sessionInfo = mock(SessionInfo.class);
    when(sessionInfo.getSessionId()).thenReturn("caller_owned_close");
    TableResult beginResult = mock(TableResult.class);
    when(beginResult.getSessionInfo()).thenReturn(sessionInfo);
    when(mockBigQuery.query(any(QueryJobConfiguration.class))).thenReturn(beginResult);

    Job rollbackJob = mock(Job.class);
    when(mockBigQuery.create(any(JobInfo.class))).thenReturn(rollbackJob);
    when(rollbackJob.waitFor()).thenReturn(rollbackJob);

    conn.setAutoCommit(false);
    conn.close();

    verify(mockBigQuery, times(1)).create(any(JobInfo.class));
    ArgumentCaptor<QueryJobConfiguration> queryCaptor =
        ArgumentCaptor.forClass(QueryJobConfiguration.class);
    verify(mockBigQuery, times(1)).query(queryCaptor.capture());
    assertEquals("BEGIN TRANSACTION;", queryCaptor.getValue().getQuery());
  }

  @Test
  public void
      testAbort_marksClosedSynchronouslyAndExecutesTeardownViaExecutorWithConfiguredTimeout()
          throws Exception {
    String url = sessionEnabledUri().append("Timeout", 15).toString();
    BigQueryConnection conn = new BigQueryConnection(url);
    BigQuery mockBigQuery = mock(BigQuery.class);
    conn.bigQuery = mockBigQuery;

    SessionInfo sessionInfo = mock(SessionInfo.class);
    when(sessionInfo.getSessionId()).thenReturn("abort_tx_session");
    TableResult beginResult = mock(TableResult.class);
    when(beginResult.getSessionInfo()).thenReturn(sessionInfo);
    when(mockBigQuery.query(any(QueryJobConfiguration.class))).thenReturn(beginResult);

    Job rollbackJob = mock(Job.class);
    when(mockBigQuery.create(any(JobInfo.class))).thenReturn(rollbackJob);
    when(rollbackJob.waitFor(any(RetryOption.class))).thenReturn(rollbackJob);

    conn.setAutoCommit(false);
    Statement openStmt = conn.createStatement();
    Connection logicalProxy = mock(Connection.class);
    Statement stmtProxy = mock(Statement.class);
    assertSame(conn, openStmt.getConnection());
    assertNull(((BigQueryStatement) openStmt).getLogicalStatementProxy());
    ((BigQueryStatement) openStmt).attachPooledProxies(logicalProxy, stmtProxy);
    assertSame(logicalProxy, openStmt.getConnection());
    assertSame(stmtProxy, ((BigQueryStatement) openStmt).getLogicalStatementProxy());

    assertThrows(BigQueryJdbcException.class, () -> conn.abort(null));
    assertFalse(conn.isClosed());

    // A rejecting Executor must roll back closeInitiated/isClosed so fallback close() can clean up.
    assertThrows(
        RejectedExecutionException.class,
        () ->
            conn.abort(
                task -> {
                  throw new RejectedExecutionException("executor shut down");
                }));
    assertFalse(conn.isClosed());

    List<Runnable> scheduledTasks = new ArrayList<>();
    conn.abort(scheduledTasks::add);

    assertTrue(conn.isClosed());
    assertEquals(1, scheduledTasks.size());
    assertFalse(openStmt.isClosed(), "Resource teardown must be deferred to the executor");

    // Second abort or close is a no-op once abort has claimed teardown.
    conn.abort(scheduledTasks::add);
    conn.close();
    assertEquals(1, scheduledTasks.size());

    scheduledTasks.get(0).run();
    assertTrue(openStmt.isClosed());
    assertNull(openStmt.getConnection());
    verify(rollbackJob).waitFor(RetryOption.totalTimeoutDuration(Duration.ofSeconds(15)));
  }

  @Test
  public void testCommitAndRollback_surfaceTimedOutFailedAndExceptionTransactionJobs()
      throws Exception {
    String url =
        sessionEnabledUri()
            .append("Timeout", 10)
            .append("QueryProperties", "session_id=tx_status_session")
            .toString();
    try (BigQueryConnection conn = new BigQueryConnection(url)) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      conn.bigQuery = mockBigQuery;

      SessionInfo sessionInfo = mock(SessionInfo.class);
      when(sessionInfo.getSessionId()).thenReturn("tx_status_session");
      TableResult beginResult = mock(TableResult.class);
      when(beginResult.getSessionInfo()).thenReturn(sessionInfo);
      when(mockBigQuery.query(any(QueryJobConfiguration.class))).thenReturn(beginResult);

      conn.setAutoCommit(false);

      // 1. Timed-out commit wait (JobStatus.State.RUNNING) throws and keeps transactionStarted.
      Job runningCommitJob = mock(Job.class);
      JobStatus runningStatus = mock(JobStatus.class);
      when(runningStatus.getState()).thenReturn(JobStatus.State.RUNNING);
      when(runningCommitJob.getStatus()).thenReturn(runningStatus);
      when(runningCommitJob.waitFor(any(RetryOption.class))).thenReturn(runningCommitJob);
      when(mockBigQuery.create(any(JobInfo.class))).thenReturn(runningCommitJob);

      assertThrows(BigQueryJdbcException.class, conn::commit);
      assertTrue(conn.isTransactionStarted());
      verify(runningCommitJob).waitFor(RetryOption.totalTimeoutDuration(Duration.ofSeconds(10)));

      // 2. BigQueryException during commit is wrapped in BigQueryJdbcException.
      when(mockBigQuery.create(any(JobInfo.class)))
          .thenThrow(new BigQueryException(503, "commit unavailable"));
      assertThrows(BigQueryJdbcException.class, conn::commit);
      assertTrue(conn.isTransactionStarted());

      // 3. Rollback job completing with a JobStatus error throws and keeps transactionStarted.
      Job erroredRollbackJob = mock(Job.class);
      JobStatus erroredStatus = mock(JobStatus.class);
      when(erroredStatus.getState()).thenReturn(JobStatus.State.DONE);
      when(erroredStatus.getError())
          .thenReturn(new BigQueryError("backendError", "server", "rollback failed"));
      when(erroredRollbackJob.getStatus()).thenReturn(erroredStatus);
      when(erroredRollbackJob.waitFor(any(RetryOption.class))).thenReturn(erroredRollbackJob);
      doReturn(erroredRollbackJob).when(mockBigQuery).create(any(JobInfo.class));

      assertThrows(BigQueryJdbcException.class, conn::resetForReuse);
      assertTrue(conn.isTransactionStarted());

      // Allow try-with-resources close() to succeed cleanly.
      Job okRollbackJob = mock(Job.class);
      when(okRollbackJob.waitFor(any(RetryOption.class))).thenReturn(okRollbackJob);
      doReturn(okRollbackJob).when(mockBigQuery).create(any(JobInfo.class));
    }
  }

  @Test
  public void testConcurrentCloseDuringRejectingAbort_waitsForRollbackAndClosesConnection()
      throws Exception {
    String url = getUriOAuthToken().append("ProjectId", "test-project").toString();
    BigQueryConnection conn = new BigQueryConnection(url);
    Statement openStmt = conn.createStatement();

    CountDownLatch enteredExecute = new CountDownLatch(1);
    CountDownLatch releaseRejection = new CountDownLatch(1);
    AtomicBoolean isClosedDuringRejectingExecute = new AtomicBoolean(true);
    AtomicReference<Thread> closeThread = new AtomicReference<>();
    CountDownLatch closeStarted = new CountDownLatch(1);

    ExecutorService workers = Executors.newFixedThreadPool(2);
    try {
      Future<?> abortFuture =
          workers.submit(
              () -> {
                assertThrows(
                    RejectedExecutionException.class,
                    () ->
                        conn.abort(
                            task -> {
                              isClosedDuringRejectingExecute.set(conn.isClosed());
                              enteredExecute.countDown();
                              try {
                                assertTrue(releaseRejection.await(5, TimeUnit.SECONDS));
                              } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                              }
                              throw new RejectedExecutionException("executor rejected");
                            }));
                return null;
              });
      assertTrue(enteredExecute.await(5, TimeUnit.SECONDS));
      assertFalse(
          isClosedDuringRejectingExecute.get(),
          "isClosed() must remain false until executor accepts the abort task");

      Future<?> closeFuture =
          workers.submit(
              () -> {
                closeThread.set(Thread.currentThread());
                closeStarted.countDown();
                conn.close();
                return null;
              });
      assertTrue(closeStarted.await(5, TimeUnit.SECONDS));
      long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5);
      while (closeThread.get().getState() != Thread.State.BLOCKED && System.nanoTime() < deadline) {
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(1));
      }
      assertEquals(Thread.State.BLOCKED, closeThread.get().getState());

      releaseRejection.countDown();
      abortFuture.get(5, TimeUnit.SECONDS);
      closeFuture.get(5, TimeUnit.SECONDS);

      assertTrue(conn.isClosed());
      assertTrue(openStmt.isClosed());
    } finally {
      workers.shutdownNow();
    }

    BigQueryConnection abortMdcConn =
        new BigQueryConnection(getUriOAuthToken().append("ProjectId", "test-project").toString());
    try (BigQueryJdbcMdc.MdcCloseable outerMdc =
        BigQueryJdbcMdc.registerInstance("outer-caller-conn")) {
      abortMdcConn.abort(Runnable::run);
      assertTrue(abortMdcConn.isClosed());
      assertEquals("outer-caller-conn", BigQueryJdbcMdc.getConnectionId());
    }
  }

  @Test
  public void testResetForReuse_surfacesBigQueryExceptionFromAbortSessionAndPreservesStateForClose()
      throws Exception {
    BigQueryConnection conn = new BigQueryConnection(sessionEnabledUri().toString());
    BigQuery mockBigQuery = mock(BigQuery.class);
    conn.bigQuery = mockBigQuery;
    when(mockBigQuery.query(any(QueryJobConfiguration.class)))
        .thenThrow(new BigQueryException(503, "session abort unavailable"));

    conn.markSessionCreatedByDriver();
    conn.initSessionInfo("driver_session_503");

    BigQueryJdbcException resetEx = assertThrows(BigQueryJdbcException.class, conn::resetForReuse);
    assertTrue(resetEx.getCause() instanceof BigQueryException);
    assertNotNull(conn.getSessionInfoConnectionProperty());
    assertEquals("driver_session_503", conn.getSessionInfoConnectionProperty().getValue());
    assertTrue(conn.isSessionCreatedByDriver());

    // Physical close retries session abort with throwOnError=false, logs warning, and clears state.
    try (BigQueryJdbcMdc.MdcCloseable outerMdc =
        BigQueryJdbcMdc.registerInstance("outer-caller-conn")) {
      conn.close();
      assertEquals("outer-caller-conn", BigQueryJdbcMdc.getConnectionId());
    }
    assertTrue(conn.isClosed());
    assertNull(conn.getSessionInfoConnectionProperty());
    verify(mockBigQuery, times(2)).query(any(QueryJobConfiguration.class));
  }

  @Test
  public void testAsyncAbortSerializesCloseImplBehindInFlightResetForReuse() throws Exception {
    BigQueryConnection conn = new BigQueryConnection(sessionEnabledUri().toString());
    BigQuery mockBigQuery = mock(BigQuery.class);
    conn.bigQuery = mockBigQuery;

    SessionInfo sessionInfo = mock(SessionInfo.class);
    when(sessionInfo.getSessionId()).thenReturn("serialized_reset_abort_session");
    TableResult beginResult = mock(TableResult.class);
    when(beginResult.getSessionInfo()).thenReturn(sessionInfo);

    CountDownLatch enteredAbortSessionRpc = new CountDownLatch(1);
    CountDownLatch releaseAbortSessionRpc = new CountDownLatch(1);
    AtomicBoolean resetStillInFlight = new AtomicBoolean(false);
    AtomicBoolean closeOverlappedReset = new AtomicBoolean(false);

    when(mockBigQuery.query(any(QueryJobConfiguration.class)))
        .thenAnswer(
            invocation -> {
              QueryJobConfiguration cfg = invocation.getArgument(0);
              if ("BEGIN TRANSACTION;".equals(cfg.getQuery())) {
                return beginResult;
              }
              resetStillInFlight.set(true);
              enteredAbortSessionRpc.countDown();
              try {
                assertTrue(releaseAbortSessionRpc.await(5, TimeUnit.SECONDS));
              } finally {
                resetStillInFlight.set(false);
              }
              return mock(TableResult.class);
            });

    Job rollbackJob = mock(Job.class);
    when(mockBigQuery.create(any(JobInfo.class))).thenReturn(rollbackJob);
    when(rollbackJob.waitFor()).thenReturn(rollbackJob);

    conn.setAutoCommit(false);
    Statement checkOverlapStmt = mock(Statement.class);
    when(checkOverlapStmt.isClosed()).thenReturn(false);

    ExecutorService resetExecutor = Executors.newSingleThreadExecutor();
    ExecutorService abortExecutor = Executors.newSingleThreadExecutor();
    try {
      Future<?> resetFuture =
          resetExecutor.submit(
              () -> {
                conn.resetForReuse();
                return null;
              });
      assertTrue(enteredAbortSessionRpc.await(5, TimeUnit.SECONDS));

      // Add a sentinel statement while reset is paused inside ABORT_SESSION; closeImpl() closes
      // openStatements, so if closeImpl() ran concurrently before reset exited lifecycleLock,
      // resetStillInFlight would be true when checkOverlapStmt.close() is invoked.
      doAnswer(
              inv -> {
                if (resetStillInFlight.get()) {
                  closeOverlappedReset.set(true);
                }
                return null;
              })
          .when(checkOverlapStmt)
          .close();
      conn.openStatements.add(checkOverlapStmt);

      conn.abort(abortExecutor);
      assertTrue(conn.isClosed(), "abort(Executor) must return non-blockingly with isClosed=true");
      LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(15));
      verify(checkOverlapStmt, never()).close();

      releaseAbortSessionRpc.countDown();
      resetFuture.get(5, TimeUnit.SECONDS);

      abortExecutor.shutdown();
      assertTrue(abortExecutor.awaitTermination(5, TimeUnit.SECONDS));

      assertFalse(closeOverlappedReset.get(), "closeImpl() must serialize behind resetForReuse()");
      verify(checkOverlapStmt, times(1)).close();
      verify(mockBigQuery, times(1)).create(any(JobInfo.class));
      ArgumentCaptor<QueryJobConfiguration> queryCaptor =
          ArgumentCaptor.forClass(QueryJobConfiguration.class);
      verify(mockBigQuery, times(2)).query(queryCaptor.capture());
    } finally {
      resetExecutor.shutdownNow();
      abortExecutor.shutdownNow();
    }
  }

  @Test
  public void testConcurrentGetWarningsAndReset_neverThrowsIndexOutOfBounds() throws Exception {
    String url = getUriOAuthToken().append("ProjectId", "test-project").toString();
    try (BigQueryConnection conn = new BigQueryConnection(url)) {
      SQLWarning warning = new SQLWarning("sample warning");
      CountDownLatch startGate = new CountDownLatch(1);
      ExecutorService workers = Executors.newFixedThreadPool(2);
      try {
        Future<?> mutator =
            workers.submit(
                () -> {
                  assertTrue(startGate.await(5, TimeUnit.SECONDS));
                  for (int i = 0; i < 1000; i++) {
                    conn.sqlWarnings.add(warning);
                    conn.resetForReuse();
                  }
                  return null;
                });
        Future<?> reader =
            workers.submit(
                () -> {
                  assertTrue(startGate.await(5, TimeUnit.SECONDS));
                  for (int i = 0; i < 1000; i++) {
                    SQLWarning observed = conn.getWarnings();
                    if (observed != null) {
                      assertSame(warning, observed);
                    }
                  }
                  return null;
                });
        startGate.countDown();
        mutator.get(5, TimeUnit.SECONDS);
        reader.get(5, TimeUnit.SECONDS);
        conn.resetForReuse();
        assertNull(conn.getWarnings());
      } finally {
        workers.shutdownNow();
      }
    }
  }
}
