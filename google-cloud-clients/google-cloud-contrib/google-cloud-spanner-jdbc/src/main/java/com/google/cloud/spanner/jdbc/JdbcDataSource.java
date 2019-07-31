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

import com.google.rpc.Code;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;
import javax.sql.DataSource;

/** {@link DataSource} implementation for Google Cloud Spanner. */
public class JdbcDataSource extends AbstractJdbcWrapper implements DataSource {
  private String url;
  private String credentials;
  private Boolean autocommit;
  private Boolean readonly;
  private Boolean retryAbortsInternally;

  /** Make sure the JDBC driver class is loaded. */
  static {
    try {
      Class.forName("com.google.cloud.spanner.jdbc.JdbcDriver");
    } catch (ClassNotFoundException e) {
      throw new IllegalStateException(
          "JdbcDataSource failed to load com.google.cloud.spanner.jdbc.JdbcDriver", e);
    }
  }

  @Override
  public PrintWriter getLogWriter() throws SQLException {
    return null;
  }

  @Override
  public void setLogWriter(PrintWriter out) throws SQLException {
    // no-op
  }

  @Override
  public void setLoginTimeout(int seconds) throws SQLException {
    // no-op
  }

  @Override
  public int getLoginTimeout() throws SQLException {
    return 0;
  }

  @Override
  public Logger getParentLogger() throws SQLFeatureNotSupportedException {
    throw JdbcSqlExceptionFactory.unsupported("java.util.logging is not used");
  }

  @Override
  public Connection getConnection() throws SQLException {
    if (getUrl() == null) {
      throw JdbcSqlExceptionFactory.of(
          "There is no URL specified for this data source", Code.FAILED_PRECONDITION);
    }
    if (!JdbcDriver.getRegisteredDriver().acceptsURL(getUrl())) {
      throw JdbcSqlExceptionFactory.of(
          "The URL " + getUrl() + " is not valid for the data source " + getClass().getName(),
          Code.FAILED_PRECONDITION);
    }
    return DriverManager.getConnection(getUrl(), createProperties());
  }

  @Override
  public Connection getConnection(String username, String password) throws SQLException {
    return getConnection();
  }

  private Properties createProperties() {
    Properties props = new Properties();
    if (this.credentials != null) {
      props.setProperty(ConnectionOptions.CREDENTIALS_PROPERTY_NAME, this.credentials);
    }
    if (this.autocommit != null) {
      props.setProperty(
          ConnectionOptions.AUTOCOMMIT_PROPERTY_NAME, String.valueOf(this.autocommit));
    }
    if (this.readonly != null) {
      props.setProperty(ConnectionOptions.READONLY_PROPERTY_NAME, String.valueOf(this.readonly));
    }
    if (this.retryAbortsInternally != null) {
      props.setProperty(
          ConnectionOptions.RETRY_ABORTS_INTERNALLY_PROPERTY_NAME,
          String.valueOf(this.retryAbortsInternally));
    }
    return props;
  }

  @Override
  public boolean isClosed() throws SQLException {
    return false;
  }

  /** @return the JDBC URL to use for this {@link DataSource}. */
  public String getUrl() {
    return url;
  }

  /** @param url The JDBC URL to use for this {@link DataSource}. */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * @return the credentials URL to use for this {@link DataSource}. If a credentials URL is
   *     specified in both the connection URL and using this property, the value in the connection
   *     URL will be used.
   */
  public String getCredentials() {
    return credentials;
  }

  /**
   * @param credentials The credentials URL to use for this {@link DataSource}. If a credentials URL
   *     is specified in both the connection URL and using this property, the value in the
   *     connection URL will be used.
   */
  public void setCredentials(String credentials) {
    this.credentials = credentials;
  }

  /**
   * @return the initial autocommit setting to use for this {@link DataSource}. If autocommit is
   *     specified in both the connection URL and using this property, the value in the connection
   *     URL will be used.
   */
  public Boolean getAutocommit() {
    return autocommit;
  }

  /**
   * @param autocommit The initial autocommit setting to use for this {@link DataSource}. If
   *     autocommit is specified in both the connection URL and using this property, the value in
   *     the connection URL will be used.
   */
  public void setAutocommit(Boolean autocommit) {
    this.autocommit = autocommit;
  }

  /**
   * @return the initial readonly setting to use for this {@link DataSource}. If readonly is
   *     specified in both the connection URL and using this property, the value in the connection
   *     URL will be used.
   */
  public Boolean getReadonly() {
    return readonly;
  }

  /**
   * @param readonly The initial readonly setting to use for this {@link DataSource}. If readonly is
   *     specified in both the connection URL and using this property, the value in the connection
   *     URL will be used.
   */
  public void setReadonly(Boolean readonly) {
    this.readonly = readonly;
  }

  /**
   * @return the initial retryAbortsInternally setting to use for this {@link DataSource}. If
   *     retryAbortsInternally is specified in both the connection URL and using this property, the
   *     value in the connection URL will be used.
   */
  public Boolean getRetryAbortsInternally() {
    return retryAbortsInternally;
  }

  /**
   * @param retryAbortsInternally The initial retryAbortsInternally setting to use for this {@link
   *     DataSource}. If retryAbortsInternally is specified in both the connection URL and using
   *     this property, the value in the connection URL will be used.
   */
  public void setRetryAbortsInternally(Boolean retryAbortsInternally) {
    this.retryAbortsInternally = retryAbortsInternally;
  }
}
