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
import static org.mockito.Mockito.never;

import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import com.google.cloud.bigquery.jdbc.telemetry.v1.AuthenticationType;
import com.google.cloud.bigquery.jdbc.telemetry.v1.DriverFeature;
import com.google.cloud.bigquery.jdbc.telemetry.v1.Status;
import com.google.cloud.bigquery.jdbc.telemetry.v1.TelemetryManager;
import com.google.cloud.bigquery.jdbc.telemetry.v1.TelemetryTestUtils;
import com.google.cloud.bigquery.jdbc.utils.BigQueryJdbcVersionUtility;
import io.opentelemetry.api.OpenTelemetry;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
  public void testConnect_doesNotRecordMetadataRetrieval() throws SQLException {
    // connect() reads DatabaseMetaData for its startup log line. That is driver-internal and
    // must not be attributed to the user as DRIVER_FEATURE_METADATA_RETRIEVAL.
    try (MockedStatic<TelemetryManager> telemetry =
            mockStatic(TelemetryManager.class, CALLS_REAL_METHODS);
        Connection ignored = bigQueryDriver.connect(VALID_TOKEN_URL, new Properties())) {
      telemetry.verify(
          () ->
              TelemetryManager.recordFeatureUsage(DriverFeature.DRIVER_FEATURE_METADATA_RETRIEVAL),
          never());
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
          BigQueryJdbcRuntimeException.class,
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
    // BigQueryJdbcRootLogger.setLevel is the only IOException source on the connect path. JDBC
    // requires connect() to throw for an accepted URL that fails, not return null.
    try (MockedStatic<BigQueryJdbcRootLogger> rootLogger =
            mockStatic(BigQueryJdbcRootLogger.class);
        MockedStatic<TelemetryManager> telemetry =
            mockStatic(TelemetryManager.class, CALLS_REAL_METHODS)) {
      rootLogger
          .when(() -> BigQueryJdbcRootLogger.setLevel(any(), any()))
          .thenThrow(new IOException("simulated log path failure"));
      BigQueryJdbcException thrown =
          Assertions.assertThrows(
              BigQueryJdbcException.class,
              () -> bigQueryDriver.connect(VALID_TOKEN_URL, new Properties()));
      assertThat(thrown.getCause()).isInstanceOf(IOException.class);
      // The failure happens before the URL's auth type is resolved, hence UNSPECIFIED.
      telemetry.verify(
          () ->
              TelemetryManager.recordConnectionAttempt(
                  eq(Status.STATUS_ERROR),
                  anyInt(),
                  eq(AuthenticationType.AUTHENTICATION_TYPE_UNSPECIFIED)));
    }
  }

  @Test
  public void testAllowUrlLogPathFalseBlocksUrlAndPropertiesLogPath(@TempDir Path tempDir)
      throws Exception {
    Path blockedUrlDir = tempDir.resolve("blocked_url_dir");
    Path blockedPropsDir = tempDir.resolve("blocked_props_dir");
    Path blockedDirectConnDir = tempDir.resolve("blocked_direct_conn_dir");
    String propName = BigQueryJdbcUrlUtility.ALLOW_URL_LOG_PATH_SYSTEM_PROPERTY;
    String prev = System.getProperty(propName);
    System.setProperty(propName, " false ");

    try (BigQueryJdbcMdc.MdcCloseable outerMdc =
        BigQueryJdbcMdc.registerInstance("enclosing-caller-conn")) {
      Properties connectProps = new Properties();
      connectProps.setProperty("OAuthAccessToken", "connect-secret-token");
      String url =
          getBaseUri()
              .append("OAuthType", 2)
              .append("ProjectId", "proj-locked")
              .append("LogLevel", 7)
              .append("LogPath", blockedUrlDir.toString())
              .toString();
      capturedLogs.clear();
      try (Connection conn = bigQueryDriver.connect(url, connectProps)) {
        assertThat(conn.isClosed()).isFalse();
        Assertions.assertNotNull(conn.getWarnings());
        assertThat(conn.getWarnings().getMessage()).contains("Ignoring URL/Properties LogPath");
      }
      assertThat(BigQueryJdbcMdc.getConnectionId()).isEqualTo("enclosing-caller-conn");
      assertThat(Files.exists(blockedUrlDir)).isFalse();
      assertThat(assertLogContains("Appending OAuthAccessToken with value ***** to URL")).isTrue();
      assertThat(assertLogContains("Ignoring URL/Properties LogPath")).isTrue();
      assertThat(assertLogContains("connect-secret-token")).isFalse();

      // Fail-closed boolean parsing: "0", "no", "off" block URL LogPath; "", "true", "1" allow it
      System.setProperty(propName, "0");
      assertThat(BigQueryJdbcUrlUtility.isUrlLogPathAllowed()).isFalse();
      System.setProperty(propName, "no");
      assertThat(BigQueryJdbcUrlUtility.isUrlLogPathAllowed()).isFalse();
      System.setProperty(propName, "off");
      assertThat(BigQueryJdbcUrlUtility.isUrlLogPathAllowed()).isFalse();
      System.setProperty(propName, "1");
      assertThat(BigQueryJdbcUrlUtility.isUrlLogPathAllowed()).isTrue();
      System.setProperty(propName, " TRUE ");
      assertThat(BigQueryJdbcUrlUtility.isUrlLogPathAllowed()).isTrue();
      System.setProperty(propName, "   ");
      assertThat(BigQueryJdbcUrlUtility.isUrlLogPathAllowed()).isTrue();
      System.setProperty(propName, "false");

      // LogPath supplied via Properties is also ignored when allowUrlLogPath=false
      Properties propsWithLogPath = new Properties();
      propsWithLogPath.setProperty("LogPath", blockedPropsDir.toString());
      String baseLogUrl =
          getUriOAuthToken().append("ProjectId", "proj-props").append("LogLevel", 7).toString();
      try (Connection conn = bigQueryDriver.connect(baseLogUrl, propsWithLogPath)) {
        assertThat(conn.isClosed()).isFalse();
        Assertions.assertNotNull(conn.getWarnings());
        assertThat(conn.getWarnings().getMessage()).contains("Ignoring URL/Properties LogPath");
      }
      assertThat(Files.exists(blockedPropsDir)).isFalse();

      // Direct BigQueryConnection construction also honors allowUrlLogPath=false
      String directUrl =
          getUriOAuthToken()
              .append("ProjectId", "proj-direct")
              .append("LogLevel", 7)
              .append("LogPath", blockedDirectConnDir.toString())
              .toString();
      try (BigQueryConnection directConn = new BigQueryConnection(directUrl)) {
        assertThat(directConn.isClosed()).isFalse();
        Assertions.assertNotNull(directConn.getWarnings());
        assertThat(directConn.getWarnings().getMessage())
            .contains("Ignoring URL/Properties LogPath");
      }
      assertThat(Files.exists(blockedDirectConnDir)).isFalse();

      // Failed connect() also restores enclosing MDC
      String invalidLogLevelUrl =
          getUriOAuthToken().append("ProjectId", "proj-fail").append("LogLevel", "bad").toString();
      Assertions.assertThrows(
          SQLException.class, () -> bigQueryDriver.connect(invalidLogLevelUrl, new Properties()));
      assertThat(BigQueryJdbcMdc.getConnectionId()).isEqualTo("enclosing-caller-conn");

      // Omitting LogPath when allowUrlLogPath=false does NOT fall back to CWD and adds no warning
      Path cwd = Paths.get("").toAbsolutePath();
      long cwdLogsBefore;
      try (Stream<Path> s = Files.list(cwd)) {
        cwdLogsBefore = s.filter(p -> p.getFileName().toString().startsWith("BQ-JDBC-")).count();
      }
      try (Connection conn = bigQueryDriver.connect(baseLogUrl, new Properties())) {
        assertThat(conn.isClosed()).isFalse();
        Assertions.assertNull(conn.getWarnings());
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
}
