/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.bigquery.jdbc;

import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import io.grpc.LoadBalancerRegistry;
import io.grpc.internal.PickFirstLoadBalancerProvider;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JDBC {@link Driver} implementation for BigQuery.
 *
 * <p>Usage:
 *
 * <pre>
 *  String CONNECTION_URL = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443"
 *            + "ProjectId=test;OAuthType=3""
 *  Connection connection = DriverManager.getConnection(CONNECTION_URL);
 * </pre>
 *
 * <p>Valid URLs take the form:
 *
 * <pre>
 *  jdbc:bigquery://{host}:{port};ProjectId={projectId};OAuthType={oAuthType};
 *  {property1}={value1};{property2}={value2};...
 * </pre>
 */
public class BigQueryDriver implements Driver {

  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryDriver.class.getName());
  // TODO: update this when JDBC goes GA
  private static final int JDBC_MAJOR_VERSION = 0;
  private static final int JDBC_MINOR_VERSION = 1;
  static BigQueryDriver registeredBigqueryJdbcDriver;

  static {
    try {
      register();
    } catch (SQLException e) {
      throw new ExceptionInInitializerError("Registering driver failed: " + e.getMessage());
    }
    LoadBalancerRegistry.getDefaultRegistry().register(new PickFirstLoadBalancerProvider());
  }

  public BigQueryDriver() {}

  static void register() throws SQLException {
    LOG.finest("++enter++");
    if (isRegistered()) {
      LOG.warning("Driver is already registered. It can only be registered once.");
    }

    DriverManager.registerDriver(LazyHolder.INSTANCE);
    BigQueryDriver.registeredBigqueryJdbcDriver = LazyHolder.INSTANCE;
  }

  static boolean isRegistered() {
    LOG.finest("++enter++");
    return registeredBigqueryJdbcDriver != null;
  }

  /**
   * @return the registered JDBC driver for BigQuery.
   * @throws IllegalStateException if the driver has not been registered.
   */
  public static BigQueryDriver getRegisteredDriver() throws IllegalStateException {
    LOG.finest("++enter++");
    if (isRegistered()) {
      return registeredBigqueryJdbcDriver;
    }
    throw new IllegalStateException(
        "Driver is not registered (or it has not been registered using Driver.register() method)");
  }

  /**
   * Attempts to establish a BigQuery connection to the given URL, using the provided connection
   * Properties.
   *
   * <p>Valid URLs take the form:
   *
   * <pre>
   *  jdbc:bigquery://{host}:{port};ProjectId={projectId};OAuthType={oAuthType};
   *  {property1}={value1};{property2}={value2};...
   * </pre>
   *
   * @param url the BigQuery URL to connect to
   * @param info a list of arbitrary string tag/value pairs as connection arguments.
   * @return A connection to the URL if it was established successfully, otherwise {@code null}
   * @throws SQLException if driver fails to connect to clients.
   * @see Driver#connect(String, Properties)
   */
  @Override
  public Connection connect(String url, Properties info) throws SQLException {
    LOG.finest("++enter++");
    try {
      if (acceptsURL(url)) {
        // strip 'jdbc:' from the URL, add any extra properties
        String connectionUri =
            BigQueryJdbcUrlUtility.appendPropertiesToURL(url.substring(5), this.toString(), info);

        // LogLevel
        String logLevelStr =
            BigQueryJdbcUrlUtility.parseUriProperty(
                connectionUri, BigQueryJdbcUrlUtility.LOG_LEVEL_PROPERTY_NAME);
        if (logLevelStr == null) {
          logLevelStr = System.getenv(BigQueryJdbcUrlUtility.LOG_LEVEL_ENV_VAR);
        }
        Level logLevel = BigQueryJdbcUrlUtility.parseLogLevel(logLevelStr);

        // LogPath
        String logPath =
            BigQueryJdbcUrlUtility.parseUriProperty(
                connectionUri, BigQueryJdbcUrlUtility.LOG_PATH_PROPERTY_NAME);
        if (logPath == null) {
          logPath = System.getenv(BigQueryJdbcUrlUtility.LOG_PATH_ENV_VAR);
        }
        if (logPath == null) {
          logPath = BigQueryJdbcUrlUtility.DEFAULT_LOG_PATH;
        }

        BigQueryJdbcRootLogger.setLevel(logLevel, logPath);
        // Logging starts from here.
        BigQueryConnection connection = new BigQueryConnection(connectionUri);
        LOG.info(
            String.format(
                "Driver info : { {Database Product Name : %s}, "
                    + "{Database Product Version : %s}, "
                    + "{Driver Name : %s}, "
                    + "{Driver Version : %s}, "
                    + "{LogLevel : %s}, "
                    + "{LogPath : %s}, "
                    + "{Driver Instance : %s} }",
                connection.getMetaData().getDatabaseProductName(),
                connection.getMetaData().getDatabaseProductVersion(),
                connection.getMetaData().getDriverName(),
                connection.getMetaData().getDriverVersion(),
                logLevel,
                logPath,
                this.toString()));
        return connection;
      } else {
        throw new IllegalArgumentException(
            "Invalid URL provided, must start with \"jdbc:bigquery:\"");
      }
    } catch (IOException e) {
      LOG.warning("Getting a warning: " + e.getMessage());
    }
    return null;
  }

  /**
   * @param url a JDBC connection URL
   * @return True if the URL is non-empty and starts with "jdbc:bigquery"
   * @see Driver#acceptsURL(String)
   */
  @Override
  public boolean acceptsURL(String url) throws SQLException {
    LOG.finest("++enter++");
    if (url == null || url.isEmpty()) {
      throw new BigQueryJdbcException("Connection URL is null.");
    }
    return url.startsWith("jdbc:bigquery:");
  }

  /**
   * Gets information about the possible BigQuery JDBC Connection Properties.
   *
   * @param url the BigQuery connection URL
   * @param info a proposed list BigQuery connection properties
   * @return an array of {@code DriverPropertyInfo} objects describing possible properties.
   * @see Driver#getPropertyInfo(String, Properties)
   */
  @Override
  public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) {
    LOG.finest("++enter++");
    String connectionUri =
        BigQueryJdbcUrlUtility.appendPropertiesToURL(url.substring(5), this.toString(), info);
    List<DriverPropertyInfo> propertyInfoList = new ArrayList<>();

    for (BigQueryConnectionProperty prop : BigQueryJdbcUrlUtility.VALID_PROPERTIES) {
      DriverPropertyInfo driverProperty =
          new DriverPropertyInfo(
              prop.getName(),
              BigQueryJdbcUrlUtility.parseUriProperty(connectionUri, prop.getName()));
      driverProperty.description = prop.getDescription();
      propertyInfoList.add(driverProperty);
    }
    Map<String, String> oAuthProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(url, this.toString());
    for (Map.Entry<String, String> authProperty : oAuthProperties.entrySet()) {
      propertyInfoList.add(new DriverPropertyInfo(authProperty.getKey(), authProperty.getValue()));
    }
    return propertyInfoList.toArray(new DriverPropertyInfo[0]);
  }

  @Override
  public int getMajorVersion() {
    LOG.finest("++enter++");
    return JDBC_MAJOR_VERSION;
  }

  @Override
  public int getMinorVersion() {
    LOG.finest("++enter++");
    return JDBC_MINOR_VERSION;
  }

  @Override
  public boolean jdbcCompliant() {
    LOG.finest("++enter++");
    return false;
  }

  @Override
  public Logger getParentLogger() {
    LOG.finest("++enter++");
    return BigQueryJdbcRootLogger.getRootLogger();
  }

  private static class LazyHolder {
    static final BigQueryDriver INSTANCE = new BigQueryDriver();
  }
}
