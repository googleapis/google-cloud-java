/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.jdbc;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.jdbc.telemetry.v1.AuthenticationType;
import com.google.cloud.bigquery.jdbc.telemetry.v1.DriverFeature;
import com.google.cloud.bigquery.jdbc.telemetry.v1.Status;
import com.google.cloud.bigquery.jdbc.telemetry.v1.TelemetryManager;
import com.google.cloud.bigquery.jdbc.telemetry.v1.TelemetryTestUtils;
import com.google.cloud.bigquery.jdbc.utils.BigQueryJdbcVersionUtility;
import io.opentelemetry.api.OpenTelemetry;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.MockedStatic;

public class BigQueryDriverTest extends BigQueryJdbcLoggingBaseTest {

  static BigQueryDriver bigQueryDriver;

  /** Token-auth URL that connects without network access; shared by the telemetry tests. */
  private static final String VALID_TOKEN_URL =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
          + "OAuthType=2;ProjectId=MyBigQueryProject;"
          + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
          + "OAuthClientSecret=redactedToken;";

  @BeforeEach
  @AfterEach
  public void resetTelemetry() {
    TelemetryTestUtils.reset();
  }

  @BeforeEach
  public void setUp() {
    bigQueryDriver = BigQueryDriver.getRegisteredDriver();
  }

  @Test
  public void testInvalidURLReturnsNull() throws SQLException {
    assertThat(bigQueryDriver.connect("badURL.com", null)).isNull();
  }

  @Test
  public void testValidURLDoesConnect() throws SQLException {
    Connection connection = bigQueryDriver.connect(VALID_TOKEN_URL, new Properties());
    assertThat(connection.isClosed()).isFalse();
  }

  @Test
  public void testInvalidURLInAcceptsURLReturnsFalse() throws SQLException {
    assertThat(bigQueryDriver.acceptsURL("badURL.com")).isFalse();
  }

  @Test
  public void testValidURLInAcceptsURLReturnsTrue() throws SQLException {
    assertThat(bigQueryDriver.acceptsURL("jdbc:bigquery:https://google.com:8080;projectId=123456"))
        .isTrue();
  }

  @Test
  public void testGetPropertyInfoReturnsValidProperties() {
    DriverPropertyInfo[] res =
        bigQueryDriver.getPropertyInfo(
            "jdbc:bigquery:https://google.com:8080;projectId=123456;OAuthType=3", new Properties());
    int i = 0;
    for (BigQueryConnectionProperty prop : BigQueryJdbcUrlUtility.VALID_PROPERTIES) {
      assertThat(res[i].name).isEqualTo(prop.getName());
      i++;
    }
  }

  @Test
  public void testGetMajorVersionMatchesDriverMajorVersion() {
    assertThat(bigQueryDriver.getMajorVersion())
        .isEqualTo(BigQueryJdbcVersionUtility.getDriverMajorVersion());
  }

  @Test
  public void testGetMinorVersionMatchesDriverMinorVersion() {
    assertThat(bigQueryDriver.getMinorVersion())
        .isEqualTo(BigQueryJdbcVersionUtility.getDriverMinorVersion());
  }

  @Test
  public void testGetParentLoggerReturnsLogger() {
    assertThat(bigQueryDriver.getParentLogger()).isInstanceOf(Logger.class);
  }

  @Test
  public void testJDBCCompliantReturnsFalse() {
    assertThat(bigQueryDriver.jdbcCompliant()).isFalse();
  }

  @Test
  public void testConnectWithInvalidUrlChainsNoException() throws SQLException {
    Connection connection =
        bigQueryDriver.connect(
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                + "OAuthType=2;OAuthAccessToken=redactedToken;ProjectId=t;"
                + "InvalidProperty=Value",
            new Properties());
    assertThat(connection.isClosed()).isFalse();
  }

  @Test
  public void testConnect_withCustomOpenTelemetry_injectsIntoDataSource() throws SQLException {
    OpenTelemetry mockOtel = mock(OpenTelemetry.class);
    Properties props = new Properties();
    props.put("customOpenTelemetry", mockOtel);

    // Connect using standard URL setup but pass the SDK via Properties
    Connection connection =
        bigQueryDriver.connect(
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                + "OAuthType=2;ProjectId=MyBigQueryProject;OAuthAccessToken=redacted;",
            props);

    assertThat(connection).isNotNull();
    assertThat(connection.isClosed()).isFalse();
  }

  @Test
  public void testUnknownPropertyWarningIsLogged() throws SQLException {
    Connection connection =
        bigQueryDriver.connect(
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                + "OAuthType=2;OAuthAccessToken=redactedToken;ProjectId=t;LogLevel=3;LogPath=target/;"
                + "MyUnknownSetting=Value",
            new Properties());
    assertThat(connection.isClosed()).isFalse();

    boolean foundWarning =
        capturedLogs.stream()
            .anyMatch(
                r ->
                    r.getLevel() == Level.WARNING
                        && r.getMessage()
                            .contains("Wrong value or unknown setting: MYUNKNOWNSETTING"));
    assertThat(foundWarning).isTrue();
  }

  @Test
  public void testMalformedUrlExceptionIsLogged() {
    Assertions.assertThrows(
        SQLException.class,
        () ->
            bigQueryDriver.connect(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "OAuthType=2;OAuthAccessToken=redactedToken;ProjectId=t;LogLevel=3;LogPath=target/;"
                    + "MalformedPropertyWithoutEquals",
                new Properties()));

    boolean foundSevere =
        capturedLogs.stream()
            .anyMatch(
                r ->
                    r.getLevel() == Level.SEVERE
                        && r.getMessage().contains("Failed to parse connection URL"));
    assertThat(foundSevere).isTrue();
  }

  @Test
  public void testInvalidLogLevelExceptionIsLogged() {
    Assertions.assertThrows(
        SQLException.class,
        () ->
            bigQueryDriver.connect(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "OAuthType=2;OAuthAccessToken=redactedToken;ProjectId=t;LogLevel=invalidInt;LogPath=target/;",
                new Properties()));

    boolean foundSevere =
        capturedLogs.stream()
            .anyMatch(
                r ->
                    r.getLevel() == Level.SEVERE
                        && r.getMessage().contains("Failed to parse connection URL properties"));
    assertThat(foundSevere).isTrue();
  }

  @Test
  public void testConnect_recordsSuccessfulConnectionTelemetry() throws SQLException {
    Connection connection = bigQueryDriver.connect(VALID_TOKEN_URL, new Properties());
    assertThat(connection).isNotNull();
    assertThat(connection.isClosed()).isFalse();
    // Verify TelemetryManager is initialized and recorded the connection
    assertThat(TelemetryManager.isInitialized()).isTrue();
  }

  @Test
  public void testConnect_recordsFailedConnectionTelemetry() {
    // Malformed URL causing DataSource parsing failure
    Assertions.assertThrows(
        SQLException.class,
        () ->
            bigQueryDriver.connect(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=invalid;",
                new Properties()));
    assertThat(TelemetryManager.isInitialized()).isTrue();
  }

  @Test
  public void testConnect_optOut_noTelemetryRecorded() throws SQLException {
    Connection connection =
        bigQueryDriver.connect(VALID_TOKEN_URL + "EnableDiagnosticTelemetry=0;", new Properties());
    assertThat(connection).isNotNull();
    // Since opt-out was requested, TelemetryManager should NOT be initialized
    assertThat(TelemetryManager.isInitialized()).isFalse();
  }

  @Test
  public void testConnect_recordsMetadataRetrievalOnce() throws SQLException {
    // connect() logs four DatabaseMetaData values; it must fetch the object once, not four times.
    try (MockedStatic<TelemetryManager> telemetry =
        mockStatic(TelemetryManager.class, CALLS_REAL_METHODS)) {
      bigQueryDriver.connect(VALID_TOKEN_URL, new Properties());
      telemetry.verify(
          () ->
              TelemetryManager.recordFeatureUsage(DriverFeature.DRIVER_FEATURE_METADATA_RETRIEVAL),
          times(1));
    }
  }

  @Test
  public void testConnect_failedAttemptCarriesAuthType() {
    // Service-account auth with no key material parses fine but fails while building the
    // connection. The failed attempt must report the auth type, not
    // AUTHENTICATION_TYPE_UNSPECIFIED.
    try (MockedStatic<TelemetryManager> telemetry =
        mockStatic(TelemetryManager.class, CALLS_REAL_METHODS)) {
      Assertions.assertThrows(
          Exception.class,
          () ->
              bigQueryDriver.connect(
                  "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                      + "OAuthType=0;ProjectId=MyBigQueryProject;",
                  new Properties()));
      telemetry.verify(
          () ->
              TelemetryManager.recordConnectionAttempt(
                  eq(Status.STATUS_ERROR),
                  anyInt(),
                  eq(AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT)));
    }
  }

  @Test
  public void testConnect_ioExceptionThrowsInsteadOfReturningNull() {
    // BigQueryJdbcRootLogger.registerConnection is the IOException source on the connect path.
    // JDBC requires connect() to throw for an accepted URL that fails, not return null.
    try (MockedStatic<BigQueryJdbcRootLogger> rootLogger =
        mockStatic(BigQueryJdbcRootLogger.class)) {
      rootLogger
          .when(() -> BigQueryJdbcRootLogger.registerConnection(any(), any(), any()))
          .thenThrow(new IOException("simulated log path failure"));
      BigQueryJdbcException thrown =
          Assertions.assertThrows(
              BigQueryJdbcException.class,
              () -> bigQueryDriver.connect(VALID_TOKEN_URL, new Properties()));
      assertThat(thrown.getCause()).isInstanceOf(IOException.class);
    }
  }

  @Test
  public void testMultiTenantLogPathAndLevelIsolationAndHandlerPreservation(@TempDir Path tempDir)
      throws Exception {
    BigQueryJdbcOpenTelemetry.ensureGlobalHandlerAttached();
    Path tenantADir = tempDir.resolve("tenant_a");
    Path tenantBDir = tempDir.resolve("tenant_b");
    Path tenantCDir = tempDir.resolve("tenant_c_off");

    String tenantAUrl =
        getBaseUri(2, "proj-a")
            .append("OAuthAccessToken", "token-a-secret")
            .append("LogLevel", 7)
            .append("LogPath", tenantADir.toString())
            .toString();

    String tenantBBaseUrl =
        getBaseUri()
            .append("ProjectId", "proj-b")
            .append("LogLevel", 3)
            .append("LogPath", tenantBDir.toString())
            .toString();
    Properties tenantBProps = new Properties();
    tenantBProps.setProperty("OAuthType", "2");
    tenantBProps.setProperty("OAuthAccessToken", "victim-tenant-b-secret-token");

    String tenantCOffUrl =
        getBaseUri(2, "proj-c")
            .append("OAuthAccessToken", "token-c-secret")
            .append("LogLevel", 0)
            .append("LogPath", tenantCDir.toString())
            .toString();

    Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    // Temporarily detach the base test's ALL capture handler to verify production root-level
    // stepping across staggered connection closes, plus an external WARNING handler floor.
    rootLogger.removeHandler(this.handler);
    Handler externalWarningHandler =
        new Handler() {
          @Override
          public void publish(LogRecord record) {}

          @Override
          public void flush() {}

          @Override
          public void close() {}
        };
    try {
      rootLogger.setLevel(Level.OFF);
      Connection connA = bigQueryDriver.connect(tenantAUrl, new Properties());
      Connection connB = bigQueryDriver.connect(tenantBBaseUrl, tenantBProps);
      Connection connC = bigQueryDriver.connect(tenantCOffUrl, new Properties());
      try {
        assertThat(rootLogger.getLevel()).isEqualTo(Level.FINEST);
        assertThat(Files.exists(tenantCDir)).isFalse();
        List<Handler> rootHandlers = Arrays.asList(rootLogger.getHandlers());
        assertThat(rootHandlers.stream().anyMatch(h -> h instanceof OpenTelemetryJulHandler))
            .isTrue();

        // Closing LogLevel=0 Tenant C must leave Tenant A at FINEST and Tenant B at INFO
        connC.close();
        assertThat(rootLogger.getLevel()).isEqualTo(Level.FINEST);

        Assertions.assertThrows(
            SQLException.class,
            () ->
                connA.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE));

        // Closing LogLevel=7 Tenant A steps root level up to Tenant B's INFO (not stuck at FINEST)
        connA.close();
        assertThat(rootLogger.getLevel()).isEqualTo(Level.INFO);

        Assertions.assertThrows(
            SQLException.class,
            () ->
                connB.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE));

        // Closing Tenant B steps root level all the way back to OFF
        connB.close();
        assertThat(rootLogger.getLevel()).isEqualTo(Level.OFF);

        // Verify external handler floor is preserved (not ratcheted to FINEST) after FINEST closes
        rootLogger.addHandler(externalWarningHandler);
        rootLogger.setLevel(Level.WARNING);
        try (Connection tempFinest = bigQueryDriver.connect(tenantAUrl, new Properties())) {
          assertThat(rootLogger.getLevel()).isEqualTo(Level.FINEST);
        }
        assertThat(rootLogger.getLevel()).isEqualTo(Level.WARNING);
      } finally {
        rootLogger.removeHandler(externalWarningHandler);
        connC.close();
        connB.close();
        connA.close();
      }
    } finally {
      rootLogger.addHandler(this.handler);
      rootLogger.setLevel(Level.ALL);
    }

    String tenantALogs = readAllLogFiles(tenantADir);
    String tenantBLogs = readAllLogFiles(tenantBDir);

    // Tenant A gets FINEST/FINER + INFO logs for proj-a only; never sees Tenant B's secrets or logs
    assertThat(tenantALogs).contains("++entry++");
    assertThat(tenantALogs).doesNotContain("victim-tenant-b-secret-token");
    assertThat(tenantALogs).doesNotContain("proj-b");

    // Tenant B (LogLevel=3 INFO) gets INFO/SEVERE logs only (no FINER ++entry++) and masks secrets
    assertThat(tenantBLogs).contains("Driver info");
    assertThat(tenantBLogs).doesNotContain("++entry++");
    assertThat(tenantBLogs).doesNotContain("victim-tenant-b-secret-token");
    assertThat(tenantBLogs).doesNotContain("proj-a");
  }

  @Test
  public void testAllowUrlLogPathFalseBlocksUrlAndDefaultLogCreation(@TempDir Path tempDir)
      throws Exception {
    Path blockedDir = tempDir.resolve("blocked_url_dir");
    String propName = BigQueryJdbcUrlUtility.ALLOW_URL_LOG_PATH_SYSTEM_PROPERTY;
    String prev = System.getProperty(propName);
    System.setProperty(propName, "false");
    try {
      String url =
          getUriOAuthToken()
              .append("ProjectId", "proj-locked")
              .append("LogLevel", 7)
              .append("LogPath", blockedDir.toString())
              .toString();
      try (Connection conn = bigQueryDriver.connect(url, new Properties())) {
        assertThat(conn.isClosed()).isFalse();
      }
      assertThat(Files.exists(blockedDir)).isFalse();
      assertThat(assertLogContains("Ignoring URL/Properties LogPath")).isTrue();

      // Also verify that omitting LogPath when allowUrlLogPath=false does NOT fall back to CWD
      Path cwd = Paths.get("").toAbsolutePath();
      long cwdLogsBefore;
      try (Stream<Path> s = Files.list(cwd)) {
        cwdLogsBefore = s.filter(p -> p.getFileName().toString().startsWith("BQ-JDBC-")).count();
      }
      String noPathUrl =
          getUriOAuthToken().append("ProjectId", "proj-no-cwd").append("LogLevel", 7).toString();
      try (Connection conn = bigQueryDriver.connect(noPathUrl, new Properties())) {
        assertThat(conn.isClosed()).isFalse();
      }
      try (Stream<Path> s = Files.list(cwd)) {
        long cwdLogsAfter =
            s.filter(p -> p.getFileName().toString().startsWith("BQ-JDBC-")).count();
        assertThat(cwdLogsAfter).isEqualTo(cwdLogsBefore);
      }
    } finally {
      if (prev == null) {
        System.clearProperty(propName);
      } else {
        System.setProperty(propName, prev);
      }
    }
  }

  private static String readAllLogFiles(Path dir) throws IOException {
    StringBuilder sb = new StringBuilder();
    try (Stream<Path> files = Files.list(dir)) {
      for (Path p : files.collect(Collectors.toList())) {
        sb.append(new String(Files.readAllBytes(p), StandardCharsets.UTF_8));
      }
    }
    return sb.toString();
  }
}
