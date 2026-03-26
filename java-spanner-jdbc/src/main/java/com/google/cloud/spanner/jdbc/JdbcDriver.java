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

import com.google.api.core.InternalApi;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.spanner.SessionPoolOptions;
import com.google.cloud.spanner.SessionPoolOptionsHelper;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.connection.ConnectionOptionsHelper;
import com.google.cloud.spanner.connection.ConnectionProperty;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Suppliers;
import com.google.rpc.Code;
import io.opentelemetry.api.OpenTelemetry;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLWarning;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JDBC {@link Driver} for Google Cloud Spanner.
 *
 * <p>Usage:
 *
 * <pre>
 * <!--SNIPPET {@link JdbcDriver} usage-->
 * {@code
 * String url = "jdbc:cloudspanner:/projects/my_project_id/"
 *            + "instances/my_instance_id/databases/my_database_name?"
 *            + "credentials=/home/cloudspanner-keys/my-key.json;autocommit=false";
 * try (Connection connection = DriverManager.getConnection(url)) {
 *   try(ResultSet rs = connection.createStatement().executeQuery("SELECT SingerId, AlbumId, MarketingBudget FROM Albums")) {
 *     while(rs.next()) {
 *       // do something
 *     }
 *   }
 * }
 * }
 * <!--SNIPPET {@link JdbcDriver} usage-->
 * </pre>
 *
 * The connection that is returned will implement the interface {@link CloudSpannerJdbcConnection}.
 * The JDBC connection URL must be specified in the following format:
 *
 * <pre>
 * jdbc:cloudspanner:[//host[:port]]/projects/project-id[/instances/instance-id[/databases/database-name]][\?property-name=property-value[;property-name=property-value]*]?
 * </pre>
 *
 * The property-value strings should be url-encoded.
 *
 * <p>The project-id part of the URI may be filled with the placeholder DEFAULT_PROJECT_ID. This
 * placeholder is replaced by the default project id of the environment that is requesting a
 * connection.
 *
 * <p>The supported properties are:
 *
 * <ul>
 *   <li>credentials (String): URL for the credentials file to use for the connection. If you do not
 *       specify any credentials at all, the default credentials of the environment as returned by
 *       {@link GoogleCredentials#getApplicationDefault()} is used.
 *   <li>autocommit (boolean): Sets the initial autocommit mode for the connection. Default is true.
 *   <li>readonly (boolean): Sets the initial readonly mode for the connection. Default is false.
 *   <li>autoConfigEmulator (boolean): Automatically configure the connection to try to connect to
 *       the Cloud Spanner emulator. You do not need to specify any host or port in the connection
 *       string as long as the emulator is running on the default host/port (localhost:9010). The
 *       instance and database in the connection string will automatically be created if these do
 *       not yet exist on the emulator. This means that you do not need to execute any `gcloud`
 *       commands on the emulator to create the instance and database before you can connect to it.
 *       Setting this property to true also enables running concurrent transactions on the emulator.
 *       The emulator aborts any concurrent transaction on the emulator, and the JDBC driver works
 *       around this by automatically setting a savepoint after each statement that is executed.
 *       When the transaction has been aborted by the emulator and the JDBC connection wants to
 *       continue with that transaction, the transaction is replayed up until the savepoint that had
 *       automatically been set after the last statement that was executed before the transaction
 *       was aborted by the emulator.
 *   <li>endpoint (string): Set this property to specify a custom endpoint that the JDBC driver
 *       should connect to. You can use this property in combination with the autoConfigEmulator
 *       property to instruct the JDBC driver to connect to an emulator instance that uses a
 *       randomly assigned port numer. See <a
 *       href="https://github.com/googleapis/java-spanner-jdbc/blob/main/src/test/java/com/google/cloud/spanner/jdbc/ConcurrentTransactionOnEmulatorTest.java">ConcurrentTransactionOnEmulatorTest</a>
 *       for a concrete example of how to use this property.
 *   <li>usePlainText (boolean): Sets whether the JDBC connection should establish an unencrypted
 *       connection to the server. This option can only be used when connecting to a local emulator
 *       that does not require an encrypted connection, and that does not require authentication.
 *   <li>optimizerVersion (string): The query optimizer version to use for the connection. The value
 *       must be either a valid version number or <code>LATEST</code>. If no value is specified, the
 *       query optimizer version specified in the environment variable <code>
 *       SPANNER_OPTIMIZER_VERSION</code> is used. If no query optimizer version is specified in the
 *       connection URL or in the environment variable, the default query optimizer version of Cloud
 *       Spanner is used.
 *   <li>oauthtoken (String): A valid OAuth2 token to use for the JDBC connection. The token must
 *       have been obtained with one or both of the scopes
 *       'https://www.googleapis.com/auth/spanner.admin' and/or
 *       'https://www.googleapis.com/auth/spanner.data'. If you specify both a credentials file and
 *       an OAuth token, the JDBC driver will throw an exception when you try to obtain a
 *       connection.
 *   <li>retryAbortsInternally (boolean): Sets the initial retryAbortsInternally mode for the
 *       connection. Default is true. @see {@link
 *       CloudSpannerJdbcConnection#setRetryAbortsInternally(boolean)} for more information.
 *   <li>minSessions (int): Sets the minimum number of sessions in the backing session pool.
 *       Defaults to 100.
 *   <li>maxSessions (int): Sets the maximum number of sessions in the backing session pool.
 *       Defaults to 400.
 *   <li>numChannels (int): Sets the number of gRPC channels to use. Defaults to 4.
 *   <li>rpcPriority (String): Sets the priority for all RPC invocations from this connection.
 *       Defaults to HIGH.
 * </ul>
 */
public class JdbcDriver implements Driver {
  /**
   * The info {@link Properties} object that is passed to the JDBC driver may contain an entry with
   * this key and an {@link io.opentelemetry.api.OpenTelemetry} instance as its value. This {@link
   * io.opentelemetry.api.OpenTelemetry} instance will be used for tracing and metrics in the JDBC
   * connection.
   */
  public static final String OPEN_TELEMETRY_PROPERTY_KEY = "openTelemetry";

  private static final String JDBC_API_CLIENT_LIB_TOKEN = "sp-jdbc";
  // Updated to version 2 when upgraded to Java 8 (JDBC 4.2)
  static final int MAJOR_VERSION = 2;
  static final int MINOR_VERSION = 0;
  private static final String JDBC_URL_FORMAT =
      "jdbc:" + ConnectionOptions.Builder.SPANNER_URI_FORMAT;
  private static final Pattern URL_PATTERN = Pattern.compile(JDBC_URL_FORMAT);
  private static final String JDBC_EXTERNAL_HOST_FORMAT =
      "jdbc:" + ConnectionOptions.Builder.EXTERNAL_HOST_FORMAT;

  @VisibleForTesting
  static final Pattern EXTERNAL_HOST_URL_PATTERN = Pattern.compile(JDBC_EXTERNAL_HOST_FORMAT);

  @InternalApi
  public static String getClientLibToken() {
    return JDBC_API_CLIENT_LIB_TOKEN;
  }

  static {
    try {
      register();
    } catch (SQLException e) {
      java.sql.DriverManager.println("Registering driver failed: " + e.getMessage());
    }
  }

  private static JdbcDriver registeredDriver;

  static void register() throws SQLException {
    if (isRegistered()) {
      throw new IllegalStateException(
          "Driver is already registered. It can only be registered once.");
    }
    JdbcDriver registeredDriver = new JdbcDriver();
    DriverManager.registerDriver(registeredDriver);
    JdbcDriver.registeredDriver = registeredDriver;
  }

  /**
   * According to JDBC specification, this driver is registered against {@link DriverManager} when
   * the class is loaded. To avoid leaks, this method allow unregistering the driver so that the
   * class can be gc'ed if necessary.
   *
   * @throws IllegalStateException if the driver is not registered
   * @throws SQLException if deregistering the driver fails
   */
  static void deregister() throws SQLException {
    if (!isRegistered()) {
      throw new IllegalStateException(
          "Driver is not registered (or it has not been registered using Driver.register() method)");
    }
    ConnectionOptions.closeSpanner();
    DriverManager.deregisterDriver(registeredDriver);
    registeredDriver = null;
  }

  /**
   * @return {@code true} if the driver is registered against {@link DriverManager}
   */
  static boolean isRegistered() {
    return registeredDriver != null;
  }

  /**
   * @return the registered JDBC driver for Cloud Spanner.
   * @throws SQLException if the driver has not been registered.
   */
  static JdbcDriver getRegisteredDriver() throws SQLException {
    if (isRegistered()) {
      return registeredDriver;
    }
    throw JdbcSqlExceptionFactory.of(
        "The driver has not been registered", Code.FAILED_PRECONDITION);
  }

  public JdbcDriver() {}

  @Override
  public Connection connect(String url, Properties info) throws SQLException {
    if (url != null && (url.startsWith("jdbc:cloudspanner") || url.startsWith("jdbc:spanner"))) {
      try {
        Matcher matcher = URL_PATTERN.matcher(url);
        Matcher matcherExternalHost = EXTERNAL_HOST_URL_PATTERN.matcher(url);
        if (matcher.matches() || matcherExternalHost.matches()) {
          // strip 'jdbc:' from the URL, add any extra properties and pass on to the generic
          // Connection API. Also set the user-agent if we detect that the connection
          // comes from known framework like Hibernate, and there is no other user-agent set.
          maybeAddUserAgent(info);
          String connectionUri = appendPropertiesToUrl(url.substring(5), info);
          ConnectionOptions options = buildConnectionOptions(connectionUri, info);
          JdbcConnection connection = new JdbcConnection(url, options);
          if (options.getWarnings() != null) {
            connection.pushWarning(new SQLWarning(options.getWarnings()));
          }
          return connection;
        }
      } catch (SpannerException e) {
        throw JdbcSqlExceptionFactory.of(e);
      } catch (IllegalArgumentException e) {
        throw JdbcSqlExceptionFactory.of(e.getMessage(), Code.INVALID_ARGUMENT, e);
      } catch (Exception e) {
        throw JdbcSqlExceptionFactory.of(e.getMessage(), Code.UNKNOWN, e);
      }
      throw JdbcSqlExceptionFactory.of("invalid url: " + url, Code.INVALID_ARGUMENT);
    }
    return null;
  }

  static ConnectionOptions buildConnectionOptions(String connectionUrl, Properties info) {
    ConnectionOptions.Builder builder =
        ConnectionOptions.newBuilder().setTracingPrefix("JDBC").setUri(connectionUrl);
    if (info.containsKey(OPEN_TELEMETRY_PROPERTY_KEY)
        && info.get(OPEN_TELEMETRY_PROPERTY_KEY) instanceof OpenTelemetry) {
      builder.setOpenTelemetry((OpenTelemetry) info.get(OPEN_TELEMETRY_PROPERTY_KEY));
    }
    // Enable multiplexed sessions by default for the JDBC driver.
    builder.setSessionPoolOptions(
        SessionPoolOptionsHelper.useMultiplexedSessions(SessionPoolOptions.newBuilder()).build());
    // Enable direct executor for JDBC, as we don't use the async API.
    builder =
        ConnectionOptionsHelper.useDirectExecutorIfNotUseVirtualThreads(connectionUrl, builder);
    return builder.build();
  }

  static void maybeAddUserAgent(Properties properties) {
    if (properties.containsKey("userAgent")) {
      return;
    }
    if (isHibernate()) {
      properties.setProperty("userAgent", "sp-hib");
    }
  }

  private static final Supplier<Boolean> isHibernate =
      Suppliers.memoize(
          () -> {
            try {
              // First check if the Spanner Hibernate dialect is on the classpath. If it is, then
              // we assume that Hibernate will (eventually) be used.
              Class.forName(
                  "com.google.cloud.spanner.hibernate.SpannerDialect",
                  /* initialize= */ false,
                  JdbcDriver.class.getClassLoader());
              return true;
            } catch (Throwable ignore) {
            }

            // If we did not find the Spanner Hibernate dialect on the classpath, then do a
            // check if the connection is still being created by Hibernate using the built-in
            // Spanner dialect in Hibernate.
            try {
              StackTraceElement[] callStack = Thread.currentThread().getStackTrace();
              for (StackTraceElement element : callStack) {
                if (element.getClassName().contains(".hibernate.")) {
                  return true;
                }
              }
            } catch (Throwable ignore) {
            }
            return false;
          });

  static boolean isHibernate() {
    // Cache the result as the check is relatively expensive, and we also don't want to create
    // multiple different Spanner instances just to get the correct user-agent in every case.
    return isHibernate.get();
  }

  static String appendPropertiesToUrl(String url, Properties info) {
    StringBuilder res = new StringBuilder(url);
    for (Entry<Object, Object> entry : info.entrySet()) {
      if (entry.getValue() instanceof String && !"".equals(entry.getValue())) {
        res.append(";").append(entry.getKey()).append("=").append(entry.getValue());
      }
    }
    return res.toString();
  }

  @Override
  public boolean acceptsURL(String url) {
    return URL_PATTERN.matcher(url).matches() || EXTERNAL_HOST_URL_PATTERN.matcher(url).matches();
  }

  @Override
  public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) {
    String connectionUri = appendPropertiesToUrl(url.substring(5), info);
    DriverPropertyInfo[] res =
        new DriverPropertyInfo[ConnectionPropertiesHelper.VALID_CONNECTION_PROPERTIES.size()];
    int i = 0;
    for (ConnectionProperty<?> prop : ConnectionPropertiesHelper.VALID_CONNECTION_PROPERTIES) {
      res[i] = ConnectionPropertiesHelper.toDriverPropertyInfo(connectionUri, prop);
      i++;
    }
    return res;
  }

  @Override
  public int getMajorVersion() {
    return MAJOR_VERSION;
  }

  @Override
  public int getMinorVersion() {
    return MINOR_VERSION;
  }

  @Override
  public boolean jdbcCompliant() {
    return false;
  }

  @Override
  public Logger getParentLogger() throws SQLFeatureNotSupportedException {
    throw new SQLFeatureNotSupportedException();
  }
}
