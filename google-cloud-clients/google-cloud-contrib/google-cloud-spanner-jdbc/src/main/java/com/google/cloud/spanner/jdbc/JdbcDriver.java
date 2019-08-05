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
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.jdbc.ConnectionOptions.ConnectionProperty;
import com.google.rpc.Code;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Map.Entry;
import java.util.Properties;
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
 * placeholder will be replaced by the default project id of the environment that is requesting a
 * connection.
 *
 * <p>The supported properties are:
 *
 * <ul>
 *   <li>credentials (String): URL for the credentials file to use for the connection. If you do not
 *       specify any credentials at all, the default credentials of the environment as returned by
 *       {@link GoogleCredentials#getApplicationDefault()} will be used.
 *   <li>autocommit (boolean): Sets the initial autocommit mode for the connection. Default is true.
 *   <li>readonly (boolean): Sets the initial readonly mode for the connection. Default is false.
 *   <li>retryAbortsInternally (boolean): Sets the initial retryAbortsInternally mode for the
 *       connection. Default is true. @see {@link
 *       com.google.cloud.spanner.jdbc.CloudSpannerJdbcConnection#setRetryAbortsInternally(boolean)}
 *       for more information.
 * </ul>
 */
public class JdbcDriver implements Driver {
  private static final String JDBC_API_CLIENT_LIB_TOKEN = "sp-jdbc";
  static final int MAJOR_VERSION = 1;
  static final int MINOR_VERSION = 0;
  private static final String JDBC_URL_FORMAT =
      "jdbc:" + ConnectionOptions.Builder.SPANNER_URI_FORMAT;
  private static final Pattern URL_PATTERN = Pattern.compile(JDBC_URL_FORMAT);

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

  /** @return {@code true} if the driver is registered against {@link DriverManager} */
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
    if (url != null && url.startsWith("jdbc:cloudspanner")) {
      try {
        Matcher matcher = URL_PATTERN.matcher(url);
        if (matcher.matches()) {
          // strip 'jdbc:' from the URL, add any extra properties and pass on to the generic
          // Connection API
          String connectionUri = appendPropertiesToUrl(url.substring(5), info);
          ConnectionOptions options = ConnectionOptions.newBuilder().setUri(connectionUri).build();
          return new JdbcConnection(url, options);
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

  private String appendPropertiesToUrl(String url, Properties info) {
    StringBuilder res = new StringBuilder(url);
    for (Entry<Object, Object> entry : info.entrySet()) {
      if (entry.getValue() != null && !"".equals(entry.getValue())) {
        res.append(";").append(entry.getKey()).append("=").append(entry.getValue());
      }
    }
    return res.toString();
  }

  @Override
  public boolean acceptsURL(String url) throws SQLException {
    return URL_PATTERN.matcher(url).matches();
  }

  @Override
  public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
    String connectionUri = appendPropertiesToUrl(url.substring(5), info);
    DriverPropertyInfo[] res = new DriverPropertyInfo[ConnectionOptions.VALID_PROPERTIES.size()];
    int i = 0;
    for (ConnectionProperty prop : ConnectionOptions.VALID_PROPERTIES) {
      res[i] =
          new DriverPropertyInfo(
              prop.getName(),
              parseUriProperty(connectionUri, prop.getName(), prop.getDefaultValue()));
      res[i].description = prop.getDescription();
      res[i].choices = prop.getValidValues();
      i++;
    }
    return res;
  }

  private String parseUriProperty(String uri, String property, String defaultValue) {
    Pattern pattern = Pattern.compile(String.format("(?is)(?:;|\\?)%s=(.*?)(?:;|$)", property));
    Matcher matcher = pattern.matcher(uri);
    if (matcher.find() && matcher.groupCount() == 1) {
      return matcher.group(1);
    }
    return defaultValue;
  }

  @Override
  public int getMajorVersion() {
    return 1;
  }

  @Override
  public int getMinorVersion() {
    return 0;
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
