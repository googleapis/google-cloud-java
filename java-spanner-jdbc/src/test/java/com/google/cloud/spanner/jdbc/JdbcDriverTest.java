/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.jdbc;

import static com.google.cloud.spanner.jdbc.JdbcDriver.SPANNER_OMNI_URL_PATTERN;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.ServiceOptions;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.connection.ConnectionOptionsHelper;
import com.google.cloud.spanner.connection.SpannerPool;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.rpc.Code;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.opentelemetry.api.OpenTelemetry;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.regex.Matcher;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JdbcDriverTest {
  // Make sure the JDBC driver class is loaded. This is needed when running the test using Maven.
  static {
    try {
      Class.forName("com.google.cloud.spanner.jdbc.JdbcDriver");
    } catch (ClassNotFoundException e) {
      throw new IllegalStateException(
          "JdbcDataSource failed to load com.google.cloud.spanner.jdbc.JdbcDriver", e);
    }
  }

  private static Server server;
  private static final String TEST_KEY_PATH =
      Objects.requireNonNull(JdbcDriverTest.class.getResource("test-key.json")).getFile();

  @BeforeClass
  public static void startStaticServer() throws IOException {
    MockSpannerServiceImpl mockSpanner = new MockSpannerServiceImpl();
    InetSocketAddress address = new InetSocketAddress("localhost", 0);
    server =
        NettyServerBuilder.forAddress(address)
            .addService(mockSpanner)
            .intercept(
                new ServerInterceptor() {
                  @Override
                  public <ReqT, RespT> Listener<ReqT> interceptCall(
                      ServerCall<ReqT, RespT> call,
                      Metadata headers,
                      ServerCallHandler<ReqT, RespT> next) {
                    String clientLibToken =
                        headers.get(
                            Metadata.Key.of("x-goog-api-client", Metadata.ASCII_STRING_MARSHALLER));
                    assertNotNull(clientLibToken);
                    assertTrue(
                        clientLibToken.contains(ServiceOptions.getGoogApiClientLibName() + "/"));
                    return Contexts.interceptCall(Context.current(), call, headers, next);
                  }
                })
            .build()
            .start();
  }

  @AfterClass
  public static void stopServer() throws Exception {
    SpannerPool.closeSpannerPool();
    server.shutdown();
    server.awaitTermination();
  }

  @Test
  public void testClientLibToken() {
    assertThat(JdbcDriver.getClientLibToken()).isEqualTo("sp-jdbc");
  }

  @Test
  public void testVersion() throws SQLException {
    assertEquals(JdbcDriver.MAJOR_VERSION, JdbcDriver.getRegisteredDriver().getMajorVersion());
    assertEquals(JdbcDriver.MINOR_VERSION, JdbcDriver.getRegisteredDriver().getMinorVersion());
  }

  @Test
  public void testRegister() throws SQLException {
    assertThat(JdbcDriver.isRegistered()).isTrue();
    JdbcDriver.deregister();
    assertThat(JdbcDriver.isRegistered()).isFalse();
    try {
      JdbcDriver.getRegisteredDriver();
      fail("missing expected exception");
    } catch (SQLException e) {
      assertThat(e.getErrorCode()).isEqualTo(Code.FAILED_PRECONDITION_VALUE);
    }
    JdbcDriver.register();
    assertThat(JdbcDriver.isRegistered()).isTrue();
    assertThat(JdbcDriver.getRegisteredDriver()).isNotNull();
  }

  @Test
  public void testConnect() throws SQLException {
    for (String prefix : new String[] {"cloudspanner", "spanner"})
      try (Connection connection =
          DriverManager.getConnection(
              String.format(
                  "jdbc:%s://localhost:%d/projects/some-company.com:test-project/instances/static-test-instance/databases/test-database;usePlainText=true;credentials=%s",
                  prefix, server.getPort(), TEST_KEY_PATH))) {
        assertThat(connection.isClosed()).isFalse();
      }
  }

  @Test(expected = SQLException.class)
  public void testInvalidConnect() throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner://localhost:%d/projects/some-company.com:test-project/instances/static-test-instance/databases/test-database;usePlainText=true;credentialsUrl=%s",
                server.getPort(), TEST_KEY_PATH))) {
      assertThat(connection.isClosed()).isFalse();
    }
  }

  @Test
  public void testConnectWithCredentialsAndOAuthToken() {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner://localhost:%d/projects/test-project/instances/static-test-instance/databases/test-database;usePlainText=true;credentials=%s;OAuthToken=%s",
                server.getPort(), TEST_KEY_PATH, "some-token"))) {
      fail("missing expected exception");
    } catch (SQLException e) {
      assertThat(e.getMessage())
          .contains(
              "Specify only one of credentialsUrl, encodedCredentials, credentialsProvider and OAuth token");
    }
  }

  @Test
  public void testGetPropertyInfo() throws SQLException {
    DriverPropertyInfo[] props =
        JdbcDriver.getRegisteredDriver()
            .getPropertyInfo(
                "jdbc:cloudspanner:/projects/p/instances/i/databases/d", new Properties());
    assertThat(props).hasLength(ConnectionPropertiesHelper.VALID_CONNECTION_PROPERTIES.size());

    Collection<String> validConnectionPropertyNames =
        Collections2.transform(
            ConnectionPropertiesHelper.VALID_CONNECTION_PROPERTIES,
            ConnectionPropertiesHelper::getConnectionPropertyName);
    Collection<String> driverPropertyNames =
        Collections2.transform(ImmutableList.copyOf(props), input -> input.name);
    assertThat(driverPropertyNames).containsExactlyElementsIn(validConnectionPropertyNames);
  }

  @Test
  public void testLenient() throws SQLException {
    // With lenient=true the driver should accept unknown properties and only generate a warning.
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d?usePlainText=true;credentials=%s;lenient=true;foo=bar",
                server.getPort(), TEST_KEY_PATH))) {
      assertThat(connection.isClosed()).isFalse();
      assertThat((Throwable) connection.getWarnings()).isNotNull();
      assertThat(connection.getWarnings().getMessage()).contains("foo");
    }

    // Without lenient the driver should throw an exception for unknown properties.
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d?usePlainText=true;credentials=%s;foo=bar",
                server.getPort(), TEST_KEY_PATH))) {
      fail("missing expected exception");
    } catch (SQLException e) {
      assertThat((Throwable) e).isInstanceOf(JdbcSqlException.class);
      JdbcSqlException jdbc = (JdbcSqlException) e;
      assertThat(jdbc.getMessage()).contains("foo");
      assertThat(jdbc.getCode()).isEqualTo(Code.INVALID_ARGUMENT);
    }
  }

  @Test
  public void testAcceptsURL() throws SQLException {
    JdbcDriver driver = JdbcDriver.getRegisteredDriver();
    assertTrue(
        driver.acceptsURL(
            "jdbc:cloudspanner:/projects/my-project/instances/my-instance/databases/my-database"));
    assertTrue(
        driver.acceptsURL(
            "jdbc:spanner:/projects/my-project/instances/my-instance/databases/my-database"));
  }

  @Test
  public void testJdbcSpannerOmniFormat() {
    Matcher matcherWithoutInstance =
        SPANNER_OMNI_URL_PATTERN.matcher("jdbc:cloudspanner://localhost:15000/databases/test-db");
    assertTrue(matcherWithoutInstance.matches());
    assertEquals("test-db", matcherWithoutInstance.group("DATABASEGROUP"));
    Matcher matcherWithProperty =
        SPANNER_OMNI_URL_PATTERN.matcher(
            "jdbc:cloudspanner://localhost:15000/instances/default/databases/singers-db?usePlainText=true");
    assertTrue(matcherWithProperty.matches());
    assertEquals("default", matcherWithProperty.group("INSTANCEGROUP"));
    assertEquals("singers-db", matcherWithProperty.group("DATABASEGROUP"));
    Matcher matcherWithoutPort =
        SPANNER_OMNI_URL_PATTERN.matcher(
            "jdbc:cloudspanner://localhost/instances/default/databases/test-db");
    assertTrue(matcherWithoutPort.matches());
    assertEquals("default", matcherWithoutPort.group("INSTANCEGROUP"));
    assertEquals("test-db", matcherWithoutPort.group("DATABASEGROUP"));
    Matcher matcherWithProject =
        SPANNER_OMNI_URL_PATTERN.matcher(
            "jdbc:cloudspanner://localhost:15000/projects/default/instances/default/databases/singers-db");
    assertFalse(matcherWithProject.matches());
    Matcher matcherWithoutHost =
        SPANNER_OMNI_URL_PATTERN.matcher(
            "jdbc:cloudspanner:/instances/default/databases/singers-db");
    assertFalse(matcherWithoutHost.matches());
  }

  @Test
  public void testDelimiterInjectionInProperties() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty(
        "databaseRole", "reader;usePlainText=true;endpoint=attacker.example.com:443");
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      JdbcConnection jdbcConnection = connection.unwrap(JdbcConnection.class);
      assertEquals(
          "reader;usePlainText=true;endpoint=attacker.example.com:443",
          jdbcConnection.getConnectionOptions().getDatabaseRole());
      assertEquals(
          String.format("http://localhost:%d", server.getPort()),
          jdbcConnection.getConnectionOptions().getHost());
    }
  }

  @Test
  public void testPasswordWithSemicolons() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty("password", "secret;password=123;foo=bar");
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      JdbcConnection jdbcConnection = connection.unwrap(JdbcConnection.class);
      assertEquals(
          "secret;password=123;foo=bar",
          ConnectionOptionsHelper.getInitialPropertyValue(
              jdbcConnection.getConnectionOptions(), "password"));
    }
  }

  @Test
  public void testPropertiesPrecedence() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s;autocommit=false;readonly=true",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty("autocommit", "true");
    properties.setProperty("readonly", "false");
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      assertFalse(connection.getAutoCommit());
      assertTrue(connection.isReadOnly());
    }
  }

  @Test
  public void testLenientAndNonLenientExtraProperties() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);

    // Without lenient=true in URL or Properties: unknown property should throw SQLException.
    Properties nonLenientProperties = new Properties();
    nonLenientProperties.setProperty("unknownProperty", "value");
    SQLException sqlException =
        assertThrows(
            SQLException.class, () -> DriverManager.getConnection(url, nonLenientProperties));
    assertTrue(sqlException.getMessage().contains("unknownProperty"));
    assertEquals(Code.INVALID_ARGUMENT_VALUE, sqlException.getErrorCode());

    // With lenient=true in Properties: unknown property should produce a warning.
    Properties lenientProperties = new Properties();
    lenientProperties.setProperty("unknownProperty", "value");
    lenientProperties.setProperty("lenient", "true");
    try (Connection connection = DriverManager.getConnection(url, lenientProperties)) {
      assertFalse(connection.isClosed());
      assertNotNull(connection.getWarnings());
      assertTrue(connection.getWarnings().getMessage().contains("unknownProperty"));
    }

    // With lenient=true in URL: unknown property in Properties should produce a warning.
    String lenientUrl = url + ";lenient=true";
    try (Connection connection = DriverManager.getConnection(lenientUrl, nonLenientProperties)) {
      assertFalse(connection.isClosed());
      assertNotNull(connection.getWarnings());
      assertTrue(connection.getWarnings().getMessage().contains("unknownProperty"));
    }
  }

  @Test
  public void testUserAliasForUsername() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty("user", "test-user-from-properties");
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      JdbcConnection jdbcConnection = connection.unwrap(JdbcConnection.class);
      assertEquals(
          "test-user-from-properties",
          ConnectionOptionsHelper.getInitialPropertyValue(
              jdbcConnection.getConnectionOptions(), "username"));
    }
  }

  @Test
  public void testGetPropertyInfoNoDelimiterInjection() throws SQLException {
    Properties properties = new Properties();
    properties.setProperty(
        "databaseRole", "reader;usePlainText=true;endpoint=attacker.example.com:443");
    DriverPropertyInfo[] propertyInfos =
        JdbcDriver.getRegisteredDriver()
            .getPropertyInfo("jdbc:cloudspanner:/projects/p/instances/i/databases/d", properties);

    DriverPropertyInfo databaseRoleInfo = null;
    DriverPropertyInfo endpointInfo = null;
    DriverPropertyInfo usePlainTextInfo = null;
    for (DriverPropertyInfo propertyInfo : propertyInfos) {
      if ("databaseRole".equalsIgnoreCase(propertyInfo.name)) {
        databaseRoleInfo = propertyInfo;
      } else if ("endpoint".equalsIgnoreCase(propertyInfo.name)) {
        endpointInfo = propertyInfo;
      } else if ("usePlainText".equalsIgnoreCase(propertyInfo.name)) {
        usePlainTextInfo = propertyInfo;
      }
    }
    assertNotNull(databaseRoleInfo);
    assertEquals(
        "reader;usePlainText=true;endpoint=attacker.example.com:443", databaseRoleInfo.value);

    assertNotNull(endpointInfo);
    assertNull(endpointInfo.value);

    assertNotNull(usePlainTextInfo);
    assertEquals("false", usePlainTextInfo.value);
  }

  @Test
  public void testUserAndUsernameCollision() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty("user", "user-alias-value");
    properties.setProperty("username", "primary-username-value");
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      JdbcConnection jdbcConnection = connection.unwrap(JdbcConnection.class);
      assertEquals(
          "primary-username-value",
          ConnectionOptionsHelper.getInitialPropertyValue(
              jdbcConnection.getConnectionOptions(), "username"));
    }
  }

  @Test
  public void testCaseInsensitiveProperties() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty("AutoCommit", "false");
    properties.setProperty("READONLY", "true");
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      assertFalse(connection.getAutoCommit());
      assertTrue(connection.isReadOnly());
    }
  }

  @Test
  public void testNonStringPropertyValues() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.put("autocommit", Boolean.FALSE);
    properties.put("internalPoolConfig", new Object());
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      assertFalse(connection.getAutoCommit());
    }
  }

  @Test
  public void testEmptyStringPropertyValues() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty("autocommit", "");
    properties.setProperty("unknownProp", "");
    properties.setProperty("password", "");
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      assertTrue(connection.getAutoCommit());
      JdbcConnection jdbcConnection = connection.unwrap(JdbcConnection.class);
      assertEquals(
          "",
          ConnectionOptionsHelper.getInitialPropertyValue(
              jdbcConnection.getConnectionOptions(), "password"));
    }
  }

  @Test
  public void testConflictingLenientFlags() {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s;lenient=false",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty("lenient", "true");
    properties.setProperty("unknownProp", "someValue");
    SQLException sqlException =
        assertThrows(SQLException.class, () -> DriverManager.getConnection(url, properties));
    assertTrue(sqlException.getMessage().contains("unknownProp"));
  }

  @Test
  public void testMultipleUnknownProperties() {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty("unknownProp1", "val1");
    properties.setProperty("unknownProp2", "val2");
    SQLException sqlException =
        assertThrows(SQLException.class, () -> DriverManager.getConnection(url, properties));
    assertTrue(sqlException.getMessage().contains("unknownProp1"));
    assertTrue(sqlException.getMessage().contains("unknownProp2"));
  }

  @Test
  public void testMultipleUnknownPropertiesWithLenient() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s;lenient=true",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty("unknownProp1", "val1");
    properties.setProperty("unknownProp2", "val2");
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      assertNotNull(connection.getWarnings());
      assertTrue(connection.getWarnings().getMessage().contains("unknownProp1"));
      assertTrue(connection.getWarnings().getMessage().contains("unknownProp2"));
    }
  }

  @Test
  public void testChainedWarningsWithLenient() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s;unknownUrlProp=urlVal;lenient=true",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty("unknownInfoProp", "infoVal");
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      SQLWarning firstWarning = connection.getWarnings();
      assertNotNull(firstWarning);
      assertTrue(firstWarning.getMessage().contains("unknownUrlProp"));
      SQLWarning secondWarning = firstWarning.getNextWarning();
      assertNotNull(secondWarning);
      assertTrue(secondWarning.getMessage().contains("unknownInfoProp"));
    }
  }

  @Test
  public void testOpenTelemetryInProperties() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    OpenTelemetry openTelemetry = OpenTelemetry.noop();
    properties.put("openTelemetry", openTelemetry);
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      JdbcConnection jdbcConnection = connection.unwrap(JdbcConnection.class);
      assertEquals(
          openTelemetry,
          ConnectionOptionsHelper.getOpenTelemetry(jdbcConnection.getConnectionOptions()));
    }

    // Verify case-insensitivity: "OpenTelemetry"
    Properties mixedCaseProperties = new Properties();
    mixedCaseProperties.put("OpenTelemetry", openTelemetry);
    try (Connection connection = DriverManager.getConnection(url, mixedCaseProperties)) {
      assertFalse(connection.isClosed());
      JdbcConnection jdbcConnection = connection.unwrap(JdbcConnection.class);
      assertEquals(
          openTelemetry,
          ConnectionOptionsHelper.getOpenTelemetry(jdbcConnection.getConnectionOptions()));
    }
  }

  @Test
  public void testUseVirtualThreadsInProperties() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty("useVirtualThreads", "true");
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      JdbcConnection jdbcConnection = connection.unwrap(JdbcConnection.class);
      assertFalse(
          ConnectionOptionsHelper.usesDirectExecutor(jdbcConnection.getConnectionOptions()));
    }
  }

  @Test
  public void testNullInfoArgument() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Driver registeredDriver = JdbcDriver.getRegisteredDriver();
    try (Connection connection = registeredDriver.connect(url, null)) {
      assertNotNull(connection);
      assertFalse(connection.isClosed());
    }
    DriverPropertyInfo[] propertyInfos = registeredDriver.getPropertyInfo(url, null);
    assertNotNull(propertyInfos);
    assertTrue(propertyInfos.length > 0);

    ConnectionOptions connectionOptions = JdbcDriver.buildConnectionOptions(url.substring(5), null);
    assertNotNull(connectionOptions);
  }

  @Test
  public void testGetPropertyInfoEdgeCases() throws SQLException {
    Properties properties = new Properties();
    properties.setProperty("user", "test-user-from-props");
    properties.setProperty("AUTOCOMMIT", "false");
    DriverPropertyInfo[] propertyInfos =
        JdbcDriver.getRegisteredDriver()
            .getPropertyInfo(
                "jdbc:cloudspanner:/projects/p/instances/i/databases/d;autocommit=true",
                properties);

    DriverPropertyInfo usernameInfo = null;
    DriverPropertyInfo autocommitInfo = null;
    for (DriverPropertyInfo propertyInfo : propertyInfos) {
      if ("username".equalsIgnoreCase(propertyInfo.name)) {
        usernameInfo = propertyInfo;
      } else if ("autocommit".equalsIgnoreCase(propertyInfo.name)) {
        autocommitInfo = propertyInfo;
      }
    }
    assertNotNull(usernameInfo);
    assertEquals("test-user-from-props", usernameInfo.value);

    assertNotNull(autocommitInfo);
    assertEquals("true", autocommitInfo.value);
  }

  @Test
  public void testInvalidPropertyValueThrowsSQLException() {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty("autocommit", "not-a-boolean");
    SQLException sqlException =
        assertThrows(SQLException.class, () -> DriverManager.getConnection(url, properties));
    assertTrue(sqlException.getMessage().contains("autocommit"));
    assertEquals(Code.INVALID_ARGUMENT_VALUE, sqlException.getErrorCode());
  }

  @Test
  public void testUnknownPropertyThrowsSQLException() {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty("unknownProperty", "value");
    SQLException sqlException =
        assertThrows(SQLException.class, () -> DriverManager.getConnection(url, properties));
    assertTrue(sqlException.getMessage().contains("unknownProperty"));
    assertEquals(Code.INVALID_ARGUMENT_VALUE, sqlException.getErrorCode());
  }

  @Test
  public void testPropertiesWithDefaults() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Properties defaultProperties = new Properties();
    defaultProperties.setProperty("autocommit", "false");
    defaultProperties.setProperty("readonly", "true");
    Properties properties = new Properties(defaultProperties);
    assertTrue(properties.isEmpty());
    assertFalse(properties.stringPropertyNames().isEmpty());

    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      assertFalse(connection.getAutoCommit());
      assertTrue(connection.isReadOnly());
    }

    // Verify Driver.getPropertyInfo with Properties that only contain defaults
    DriverPropertyInfo[] propertyInfos =
        JdbcDriver.getRegisteredDriver().getPropertyInfo(url, properties);
    boolean foundAutocommit = false;
    for (DriverPropertyInfo info : propertyInfos) {
      if ("autocommit".equalsIgnoreCase(info.name)) {
        foundAutocommit = true;
        assertEquals("false", info.value);
      }
    }
    assertTrue(foundAutocommit);

    // Verify JdbcDriver.buildConnectionOptions with Properties that only contain defaults
    ConnectionOptions options = JdbcDriver.buildConnectionOptions(url.substring(5), properties);
    assertFalse(options.isAutocommit());
    assertTrue(options.isReadOnly());

    // Verify ConnectionOptionsHelper.applyProperties directly
    ConnectionOptions.Builder builder =
        ConnectionOptions.newBuilder().setTracingPrefix("JDBC").setUri(url.substring(5));
    ConnectionOptionsHelper.applyProperties(builder, url.substring(5), properties);
    ConnectionOptions builtOptions = builder.build();
    assertFalse(builtOptions.isAutocommit());
    assertTrue(builtOptions.isReadOnly());
  }

  @Test
  public void testUserAgentCaseInsensitive() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty("UserAgent", "sp-hib");
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      JdbcConnection jdbcConnection = connection.unwrap(JdbcConnection.class);
      assertEquals(
          "sp-hib",
          ConnectionOptionsHelper.getInitialPropertyValue(
              jdbcConnection.getConnectionOptions(), "userAgent"));
    }

    // Also verify that maybeAddUserAgent respects case-insensitivity and does not add userAgent.
    Properties customProperties = new Properties();
    customProperties.setProperty("USERAGENT", "custom");
    JdbcDriver.maybeAddUserAgent(customProperties);
    assertFalse(customProperties.containsKey("userAgent"));

    // Also verify that copyProperties preserves userAgent present in defaults.
    Properties defaultProperties = new Properties();
    defaultProperties.setProperty("UserAgent", "custom-from-defaults");
    Properties propertiesWithDefaults =
        JdbcDriver.copyProperties(new Properties(defaultProperties));
    assertTrue(propertiesWithDefaults.containsKey("UserAgent"));
    JdbcDriver.maybeAddUserAgent(propertiesWithDefaults);
    assertFalse(propertiesWithDefaults.containsKey("userAgent"));
  }

  @Test
  public void testNonStringOverrideOfDefaultProperty() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);
    Properties defaultProperties = new Properties();
    defaultProperties.setProperty("openTelemetry", "dummy");
    defaultProperties.setProperty("autocommit", "true");
    Properties properties = new Properties(defaultProperties);
    OpenTelemetry openTelemetry = OpenTelemetry.noop();
    properties.put("OpenTelemetry", openTelemetry);
    properties.put("AutoCommit", "false");

    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      assertFalse(connection.getAutoCommit());
      JdbcConnection jdbcConnection = connection.unwrap(JdbcConnection.class);
      assertEquals(
          openTelemetry,
          ConnectionOptionsHelper.getOpenTelemetry(jdbcConnection.getConnectionOptions()));
    }

    Map<String, Object> collectedProperties = ConnectionOptionsHelper.collectProperties(properties);
    assertEquals(openTelemetry, collectedProperties.get("openTelemetry"));
    assertEquals("false", collectedProperties.get("autocommit"));

    Properties copiedProperties = JdbcDriver.copyProperties(properties);
    assertEquals(openTelemetry, copiedProperties.get("OpenTelemetry"));
    assertFalse(copiedProperties.containsKey("autocommit"));
  }

  @Test
  public void testUserInUriTakesPrecedenceOverUsernameInProperties() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s;user=uri-user;lenient=true",
            server.getPort(), TEST_KEY_PATH);
    Properties properties = new Properties();
    properties.setProperty("username", "properties-user");

    try (Connection connection = DriverManager.getConnection(url, properties)) {
      assertFalse(connection.isClosed());
      JdbcConnection jdbcConnection = connection.unwrap(JdbcConnection.class);
      assertEquals(
          "uri-user",
          ConnectionOptionsHelper.getInitialPropertyValue(
              jdbcConnection.getConnectionOptions(), "username"));
    }
  }

  @Test
  public void testUserAliasWithDefaultProperties() throws SQLException {
    String url =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s",
            server.getPort(), TEST_KEY_PATH);

    // Case 1: defaults specify username, main properties specify user
    Properties defaultProperties1 = new Properties();
    defaultProperties1.setProperty("username", "default-user");
    Properties properties1 = new Properties(defaultProperties1);
    properties1.setProperty("user", "main-user");

    try (Connection connection = DriverManager.getConnection(url, properties1)) {
      assertFalse(connection.isClosed());
      JdbcConnection jdbcConnection = connection.unwrap(JdbcConnection.class);
      assertEquals(
          "main-user",
          ConnectionOptionsHelper.getInitialPropertyValue(
              jdbcConnection.getConnectionOptions(), "username"));
    }
    Map<String, Object> collected1 = ConnectionOptionsHelper.collectProperties(properties1);
    assertEquals("main-user", collected1.get("username"));
    assertFalse(collected1.containsKey("user"));

    Properties copied1 = JdbcDriver.copyProperties(properties1);
    assertEquals("main-user", copied1.getProperty("user"));
    assertFalse(copied1.containsKey("username"));

    // Case 2: defaults specify user, main properties specify username
    Properties defaultProperties2 = new Properties();
    defaultProperties2.setProperty("user", "default-user");
    Properties properties2 = new Properties(defaultProperties2);
    properties2.setProperty("username", "main-user");

    try (Connection connection = DriverManager.getConnection(url, properties2)) {
      assertFalse(connection.isClosed());
      JdbcConnection jdbcConnection = connection.unwrap(JdbcConnection.class);
      assertEquals(
          "main-user",
          ConnectionOptionsHelper.getInitialPropertyValue(
              jdbcConnection.getConnectionOptions(), "username"));
    }
    Map<String, Object> collected2 = ConnectionOptionsHelper.collectProperties(properties2);
    assertEquals("main-user", collected2.get("username"));
    assertFalse(collected2.containsKey("user"));

    Properties copied2 = JdbcDriver.copyProperties(properties2);
    assertEquals("main-user", copied2.getProperty("username"));
    assertFalse(copied2.containsKey("user"));
  }

  private enum UserSettingSource {
    NONE,
    USER,
    USERNAME,
    BOTH
  }

  @Test
  public void testUserAndUsernamePrecedenceMatrix() throws SQLException {
    for (UserSettingSource uriSource : UserSettingSource.values()) {
      for (UserSettingSource mainPropertiesSource : UserSettingSource.values()) {
        for (UserSettingSource defaultPropertiesSource : UserSettingSource.values()) {
          testPrecedenceCombination(uriSource, mainPropertiesSource, defaultPropertiesSource);
        }
      }
    }
  }

  private void testPrecedenceCombination(
      UserSettingSource uriSource,
      UserSettingSource mainPropertiesSource,
      UserSettingSource defaultPropertiesSource)
      throws SQLException {
    String expectedWinner;
    if (uriSource == UserSettingSource.USERNAME || uriSource == UserSettingSource.BOTH) {
      expectedWinner = "uri-username";
    } else if (uriSource == UserSettingSource.USER) {
      expectedWinner = "uri-user";
    } else if (mainPropertiesSource == UserSettingSource.USERNAME
        || mainPropertiesSource == UserSettingSource.BOTH) {
      expectedWinner = "main-username";
    } else if (mainPropertiesSource == UserSettingSource.USER) {
      expectedWinner = "main-user";
    } else if (defaultPropertiesSource == UserSettingSource.USERNAME
        || defaultPropertiesSource == UserSettingSource.BOTH) {
      expectedWinner = "default-username";
    } else if (defaultPropertiesSource == UserSettingSource.USER) {
      expectedWinner = "default-user";
    } else {
      expectedWinner = "";
    }

    StringBuilder urlBuilder =
        new StringBuilder(
            String.format(
                "jdbc:cloudspanner:/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s;lenient=true",
                TEST_KEY_PATH));
    if (uriSource == UserSettingSource.USER) {
      urlBuilder.append(";user=uri-user");
    } else if (uriSource == UserSettingSource.USERNAME) {
      urlBuilder.append(";username=uri-username");
    } else if (uriSource == UserSettingSource.BOTH) {
      urlBuilder.append(";username=uri-username;user=uri-user");
    }
    String url = urlBuilder.toString();

    Properties defaultProperties = null;
    if (defaultPropertiesSource != UserSettingSource.NONE) {
      defaultProperties = new Properties();
      if (defaultPropertiesSource == UserSettingSource.USER) {
        defaultProperties.setProperty("user", "default-user");
      } else if (defaultPropertiesSource == UserSettingSource.USERNAME) {
        defaultProperties.setProperty("username", "default-username");
      } else if (defaultPropertiesSource == UserSettingSource.BOTH) {
        defaultProperties.setProperty("username", "default-username");
        defaultProperties.setProperty("user", "default-user");
      }
    }

    Properties properties =
        defaultProperties == null ? new Properties() : new Properties(defaultProperties);
    if (mainPropertiesSource == UserSettingSource.USER) {
      properties.setProperty("user", "main-user");
    } else if (mainPropertiesSource == UserSettingSource.USERNAME) {
      properties.setProperty("username", "main-username");
    } else if (mainPropertiesSource == UserSettingSource.BOTH) {
      properties.setProperty("username", "main-username");
      properties.setProperty("user", "main-user");
    }

    String testContext =
        String.format(
            "Combination failed for URI=%s, Main=%s, Defaults=%s",
            uriSource, mainPropertiesSource, defaultPropertiesSource);

    // 1. Verify buildConnectionOptions
    ConnectionOptions connectionOptions =
        JdbcDriver.buildConnectionOptions(url.substring(5), properties);
    assertEquals(
        testContext,
        expectedWinner,
        ConnectionOptionsHelper.getInitialPropertyValue(connectionOptions, "username"));

    // 2. Verify getPropertyInfo
    DriverPropertyInfo[] propertyInfos =
        JdbcDriver.getRegisteredDriver().getPropertyInfo(url, properties);
    DriverPropertyInfo usernamePropertyInfo = findPropertyInfo(propertyInfos, "username");
    assertNotNull(testContext, usernamePropertyInfo);
    assertEquals(testContext, expectedWinner, usernamePropertyInfo.value);

    // 3. Verify collectProperties
    String expectedPropertiesWinner;
    if (mainPropertiesSource == UserSettingSource.USERNAME
        || mainPropertiesSource == UserSettingSource.BOTH) {
      expectedPropertiesWinner = "main-username";
    } else if (mainPropertiesSource == UserSettingSource.USER) {
      expectedPropertiesWinner = "main-user";
    } else if (defaultPropertiesSource == UserSettingSource.USERNAME
        || defaultPropertiesSource == UserSettingSource.BOTH) {
      expectedPropertiesWinner = "default-username";
    } else if (defaultPropertiesSource == UserSettingSource.USER) {
      expectedPropertiesWinner = "default-user";
    } else {
      expectedPropertiesWinner = null;
    }
    Map<String, Object> collected = ConnectionOptionsHelper.collectProperties(properties);
    assertEquals(testContext, expectedPropertiesWinner, collected.get("username"));
    assertFalse(testContext, collected.containsKey("user"));

    // 4. Verify copyProperties
    Properties copied = JdbcDriver.copyProperties(properties);
    if (mainPropertiesSource == UserSettingSource.USER) {
      assertEquals(testContext, "main-user", copied.getProperty("user"));
      assertFalse(testContext, copied.containsKey("username"));
    } else if (mainPropertiesSource == UserSettingSource.USERNAME) {
      assertEquals(testContext, "main-username", copied.getProperty("username"));
      assertFalse(testContext, copied.containsKey("user"));
    } else if (mainPropertiesSource == UserSettingSource.BOTH) {
      assertEquals(testContext, "main-username", copied.getProperty("username"));
      assertEquals(testContext, "main-user", copied.getProperty("user"));
    } else if (mainPropertiesSource == UserSettingSource.NONE) {
      if (defaultPropertiesSource == UserSettingSource.USERNAME
          || defaultPropertiesSource == UserSettingSource.BOTH) {
        assertEquals(testContext, "default-username", copied.getProperty("username"));
        assertFalse(testContext, copied.containsKey("user"));
      } else if (defaultPropertiesSource == UserSettingSource.USER) {
        assertEquals(testContext, "default-user", copied.getProperty("user"));
        assertFalse(testContext, copied.containsKey("username"));
      } else {
        assertFalse(testContext, copied.containsKey("username"));
        assertFalse(testContext, copied.containsKey("user"));
      }
    }
  }

  private static DriverPropertyInfo findPropertyInfo(
      DriverPropertyInfo[] propertyInfos, String name) {
    for (DriverPropertyInfo propertyInfo : propertyInfos) {
      if (name.equalsIgnoreCase(propertyInfo.name)) {
        return propertyInfo;
      }
    }
    return null;
  }

  @Test
  public void testUserAndUsernameCaseInsensitivity() throws SQLException {
    String[] userPropertyKeys = {"USER", "User", "uSeR"};
    String[] usernamePropertyKeys = {"USERNAME", "UserName", "uSeRnAmE"};

    for (String userKey : userPropertyKeys) {
      // In URI
      String url =
          String.format(
              "jdbc:cloudspanner:/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s;lenient=true;%s=case-user",
              TEST_KEY_PATH, userKey);
      ConnectionOptions connectionOptions =
          JdbcDriver.buildConnectionOptions(url.substring(5), null);
      assertEquals(
          "case-user",
          ConnectionOptionsHelper.getInitialPropertyValue(connectionOptions, "username"));

      // In Main Properties
      Properties mainProperties = new Properties();
      mainProperties.setProperty(userKey, "case-user-property");
      Map<String, Object> collectedProperties =
          ConnectionOptionsHelper.collectProperties(mainProperties);
      assertEquals("case-user-property", collectedProperties.get("username"));
      assertFalse(collectedProperties.containsKey("user"));
      Properties copiedProperties = JdbcDriver.copyProperties(mainProperties);
      assertEquals("case-user-property", copiedProperties.getProperty(userKey));

      // In Default Properties
      Properties defaultProperties = new Properties();
      defaultProperties.setProperty(userKey, "case-user-default");
      Properties propertiesWithDefaults = new Properties(defaultProperties);
      Map<String, Object> collectedDefaults =
          ConnectionOptionsHelper.collectProperties(propertiesWithDefaults);
      assertEquals("case-user-default", collectedDefaults.get("username"));
      assertFalse(collectedDefaults.containsKey("user"));
      Properties copiedDefaults = JdbcDriver.copyProperties(propertiesWithDefaults);
      assertEquals("case-user-default", copiedDefaults.getProperty(userKey));
    }

    for (String usernameKey : usernamePropertyKeys) {
      // In URI
      String url =
          String.format(
              "jdbc:cloudspanner:/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s;lenient=true;%s=case-username",
              TEST_KEY_PATH, usernameKey);
      ConnectionOptions connectionOptions =
          JdbcDriver.buildConnectionOptions(url.substring(5), null);
      assertEquals(
          "case-username",
          ConnectionOptionsHelper.getInitialPropertyValue(connectionOptions, "username"));

      // In Main Properties
      Properties mainProperties = new Properties();
      mainProperties.setProperty(usernameKey, "case-username-property");
      Map<String, Object> collectedProperties =
          ConnectionOptionsHelper.collectProperties(mainProperties);
      assertEquals("case-username-property", collectedProperties.get("username"));
      assertFalse(collectedProperties.containsKey("user"));
      Properties copiedProperties = JdbcDriver.copyProperties(mainProperties);
      assertEquals("case-username-property", copiedProperties.getProperty(usernameKey));

      // In Default Properties
      Properties defaultProperties = new Properties();
      defaultProperties.setProperty(usernameKey, "case-username-default");
      Properties propertiesWithDefaults = new Properties(defaultProperties);
      Map<String, Object> collectedDefaults =
          ConnectionOptionsHelper.collectProperties(propertiesWithDefaults);
      assertEquals("case-username-default", collectedDefaults.get("username"));
      assertFalse(collectedDefaults.containsKey("user"));
      Properties copiedDefaults = JdbcDriver.copyProperties(propertiesWithDefaults);
      assertEquals("case-username-default", copiedDefaults.getProperty(usernameKey));
    }
  }

  @Test
  public void testUserAndUsernameLiveConnectionPermutations() throws SQLException {
    String baseUrl =
        String.format(
            "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d;usePlainText=true;credentials=%s;lenient=true",
            server.getPort(), TEST_KEY_PATH);

    // 1. user in URI alone
    try (Connection connection =
        DriverManager.getConnection(baseUrl + ";user=uri-only-user", new Properties())) {
      assertEquals(
          "uri-only-user",
          ConnectionOptionsHelper.getInitialPropertyValue(
              connection.unwrap(JdbcConnection.class).getConnectionOptions(), "username"));
    }

    // 2. username in URI beats user in properties
    Properties propertiesWithUser = new Properties();
    propertiesWithUser.setProperty("user", "properties-user");
    try (Connection connection =
        DriverManager.getConnection(baseUrl + ";username=uri-username", propertiesWithUser)) {
      assertEquals(
          "uri-username",
          ConnectionOptionsHelper.getInitialPropertyValue(
              connection.unwrap(JdbcConnection.class).getConnectionOptions(), "username"));
    }

    // 3. user in defaults alone (no main properties)
    Properties defaultProperties = new Properties();
    defaultProperties.setProperty("user", "default-user");
    Properties propertiesWithDefaults = new Properties(defaultProperties);
    try (Connection connection = DriverManager.getConnection(baseUrl, propertiesWithDefaults)) {
      assertEquals(
          "default-user",
          ConnectionOptionsHelper.getInitialPropertyValue(
              connection.unwrap(JdbcConnection.class).getConnectionOptions(), "username"));
    }
  }
}
