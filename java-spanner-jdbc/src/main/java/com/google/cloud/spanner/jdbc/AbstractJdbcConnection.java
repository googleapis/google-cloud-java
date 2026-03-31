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

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.connection.AbstractStatementParser;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.connection.ConnectionOptionsHelper;
import com.google.common.annotations.VisibleForTesting;
import com.google.rpc.Code;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Struct;
import java.util.Properties;
import java.util.concurrent.Executor;

/** Base class for Cloud Spanner JDBC connections. */
abstract class AbstractJdbcConnection extends AbstractJdbcWrapper
    implements CloudSpannerJdbcConnection {
  private static final String CALLABLE_STATEMENTS_UNSUPPORTED =
      "Callable statements are not supported";
  private static final String ONLY_SERIALIZABLE_OR_REPEATABLE_READ =
      "Only isolation levels TRANSACTION_SERIALIZABLE and TRANSACTION_REPEATABLE_READ are supported";
  private static final String ONLY_CLOSE_ALLOWED =
      "Only holdability CLOSE_CURSORS_AT_COMMIT is supported";
  private static final String SQLXML_UNSUPPORTED = "SQLXML is not supported";
  private static final String STRUCTS_UNSUPPORTED = "Structs are not supported";
  private static final String ABORT_UNSUPPORTED = "Abort is not supported";
  private static final String NETWORK_TIMEOUT_UNSUPPORTED = "Network timeout is not supported";
  static final String CLIENT_INFO_NOT_SUPPORTED =
      "Cloud Spanner does not support ClientInfo property %s";

  private final String connectionUrl;
  private final ConnectionOptions options;
  private final com.google.cloud.spanner.connection.Connection spanner;
  private final Properties clientInfo;
  private final boolean usesDirectExecutor;
  private AbstractStatementParser parser;

  private SQLWarning firstWarning = null;
  private SQLWarning lastWarning = null;

  AbstractJdbcConnection(String connectionUrl, ConnectionOptions options) throws SQLException {
    this.connectionUrl = connectionUrl;
    this.options = options;
    this.spanner = options.getConnection();
    this.clientInfo = new Properties(JdbcDatabaseMetaData.getDefaultClientInfoProperties());
    this.usesDirectExecutor = ConnectionOptionsHelper.usesDirectExecutor(options);
  }

  @Override
  public DatabaseId getDatabaseId() {
    return this.options.getDatabaseId();
  }

  @Override
  public DatabaseClient getDatabaseClient() {
    return getSpannerConnection().getDatabaseClient();
  }

  /** Return the corresponding {@link com.google.cloud.spanner.connection.Connection} */
  com.google.cloud.spanner.connection.Connection getSpannerConnection() {
    return spanner;
  }

  @Override
  public String getConnectionUrl() {
    return connectionUrl;
  }

  ConnectionOptions getConnectionOptions() {
    return options;
  }

  @Override
  public Spanner getSpanner() {
    return this.spanner.getSpanner();
  }

  boolean usesDirectExecutor() {
    return this.usesDirectExecutor;
  }

  @Override
  public Dialect getDialect() {
    return spanner.getDialect();
  }

  protected AbstractStatementParser getParser() throws SQLException {
    if (parser == null) {
      try {
        parser = AbstractStatementParser.getInstance(spanner.getDialect());
      } catch (SpannerException e) {
        throw JdbcSqlExceptionFactory.of(e);
      }
    }
    return parser;
  }

  @Override
  public CallableStatement prepareCall(String sql) throws SQLException {
    return checkClosedAndThrowUnsupported(CALLABLE_STATEMENTS_UNSUPPORTED);
  }

  @Override
  public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
      throws SQLException {
    return checkClosedAndThrowUnsupported(CALLABLE_STATEMENTS_UNSUPPORTED);
  }

  @Override
  public CallableStatement prepareCall(
      String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
      throws SQLException {
    return checkClosedAndThrowUnsupported(CALLABLE_STATEMENTS_UNSUPPORTED);
  }

  @Override
  public void setTransactionIsolation(int level) throws SQLException {
    checkClosed();
    JdbcPreconditions.checkArgument(
        level == TRANSACTION_SERIALIZABLE
            || level == TRANSACTION_REPEATABLE_READ
            || level == TRANSACTION_READ_UNCOMMITTED
            || level == TRANSACTION_READ_COMMITTED,
        "Not a transaction isolation level");
    JdbcPreconditions.checkSqlFeatureSupported(
        JdbcDatabaseMetaData.supportsIsolationLevel(level), ONLY_SERIALIZABLE_OR_REPEATABLE_READ);
    spanner.setDefaultIsolationLevel(IsolationLevelConverter.convertToSpanner(level));
  }

  @Override
  public int getTransactionIsolation() throws SQLException {
    checkClosed();
    //noinspection MagicConstant
    return IsolationLevelConverter.convertToJdbc(spanner.getDefaultIsolationLevel());
  }

  @Override
  public void setHoldability(int holdability) throws SQLException {
    checkClosed();
    JdbcPreconditions.checkArgument(
        holdability == ResultSet.HOLD_CURSORS_OVER_COMMIT
            || holdability == ResultSet.CLOSE_CURSORS_AT_COMMIT,
        "Not a holdability value");
    JdbcPreconditions.checkSqlFeatureSupported(
        holdability == ResultSet.CLOSE_CURSORS_AT_COMMIT, ONLY_CLOSE_ALLOWED);
  }

  @Override
  public int getHoldability() throws SQLException {
    checkClosed();
    return ResultSet.CLOSE_CURSORS_AT_COMMIT;
  }

  @Override
  public SQLWarning getWarnings() throws SQLException {
    checkClosed();
    return firstWarning;
  }

  @Override
  public void clearWarnings() throws SQLException {
    checkClosed();
    firstWarning = null;
    lastWarning = null;
  }

  @Override
  public SQLXML createSQLXML() throws SQLException {
    return checkClosedAndThrowUnsupported(SQLXML_UNSUPPORTED);
  }

  @Override
  public void setClientInfo(String name, String value) throws SQLClientInfoException {
    Properties supported;
    try {
      checkClosed();
      supported = JdbcDatabaseMetaData.getDefaultClientInfoProperties();
    } catch (SQLException e) {
      if (e instanceof JdbcSqlException) {
        throw JdbcSqlExceptionFactory.clientInfoException(
            e.getMessage(), ((JdbcSqlException) e).getCode());
      } else {
        throw JdbcSqlExceptionFactory.clientInfoException(e.getMessage(), Code.UNKNOWN);
      }
    }
    if (value == null) {
      throw JdbcSqlExceptionFactory.clientInfoException(
          "Null-value is not allowed for client info.", Code.INVALID_ARGUMENT);
    }
    if (value.length() > JdbcDatabaseMetaData.MAX_CLIENT_INFO_VALUE_LENGTH) {
      throw JdbcSqlExceptionFactory.clientInfoException(
          String.format(
              "Max length of value is %d characters.",
              JdbcDatabaseMetaData.MAX_CLIENT_INFO_VALUE_LENGTH),
          Code.INVALID_ARGUMENT);
    }
    name = name.toUpperCase();
    if (supported.containsKey(name)) {
      clientInfo.setProperty(name, value);
    } else {
      pushWarning(new SQLWarning(String.format(CLIENT_INFO_NOT_SUPPORTED, name)));
    }
  }

  @Override
  public void setClientInfo(Properties properties) throws SQLClientInfoException {
    try {
      checkClosed();
    } catch (SQLException e) {
      if (e instanceof JdbcSqlException) {
        throw JdbcSqlExceptionFactory.clientInfoException(
            e.getMessage(), ((JdbcSqlException) e).getCode());
      } else {
        throw JdbcSqlExceptionFactory.clientInfoException(e.getMessage(), Code.UNKNOWN);
      }
    }
    clientInfo.clear();
    for (String property : properties.stringPropertyNames()) {
      setClientInfo(property, properties.getProperty(property));
    }
  }

  @Override
  public String getClientInfo(String name) throws SQLException {
    checkClosed();
    return clientInfo.getProperty(name.toUpperCase());
  }

  @Override
  public Properties getClientInfo() throws SQLException {
    checkClosed();
    return (Properties) clientInfo.clone();
  }

  @Override
  public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
    return checkClosedAndThrowUnsupported(STRUCTS_UNSUPPORTED);
  }

  @Override
  public void abort(Executor executor) throws SQLException {
    checkClosedAndThrowUnsupported(ABORT_UNSUPPORTED);
  }

  @Override
  public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
    checkClosedAndThrowUnsupported(NETWORK_TIMEOUT_UNSUPPORTED);
  }

  @Override
  public int getNetworkTimeout() throws SQLException {
    return checkClosedAndThrowUnsupported(NETWORK_TIMEOUT_UNSUPPORTED);
  }

  @VisibleForTesting
  void pushWarning(SQLWarning warning) {
    if (lastWarning == null) {
      firstWarning = warning;
    } else {
      lastWarning.setNextWarning(warning);
    }
    lastWarning = warning;
  }
}
