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

import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.SpannerException;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/** Jdbc Connection class for Google Cloud Spanner */
class JdbcConnection extends AbstractJdbcConnection {
  private static final String ONLY_RS_FORWARD_ONLY =
      "Only result sets of type TYPE_FORWARD_ONLY are supported";
  private static final String ONLY_CONCUR_READ_ONLY =
      "Only result sets with concurrency CONCUR_READ_ONLY are supported";
  private static final String ONLY_CLOSE_CURSORS_AT_COMMIT =
      "Only result sets with holdability CLOSE_CURSORS_AT_COMMIT are supported";
  static final String ONLY_NO_GENERATED_KEYS = "Only NO_GENERATED_KEYS are supported";
  static final String IS_VALID_QUERY = "SELECT 1";

  private Map<String, Class<?>> typeMap = new HashMap<>();

  JdbcConnection(String connectionUrl, ConnectionOptions options) {
    super(connectionUrl, options);
  }

  @Override
  public Statement createStatement() throws SQLException {
    checkClosed();
    return new JdbcStatement(this);
  }

  @Override
  public JdbcPreparedStatement prepareStatement(String sql) throws SQLException {
    checkClosed();
    return new JdbcPreparedStatement(this, sql);
  }

  @Override
  public String nativeSQL(String sql) throws SQLException {
    checkClosed();
    return JdbcParameterStore.convertPositionalParametersToNamedParameters(
            StatementParser.removeCommentsAndTrim(sql))
        .sqlWithNamedParameters;
  }

  @Override
  public void setAutoCommit(boolean autoCommit) throws SQLException {
    checkClosed();
    try {
      // According to the JDBC spec's we need to commit the current transaction when changing
      // autocommit mode.
      if (getSpannerConnection().isAutocommit() != autoCommit
          && getSpannerConnection().isTransactionStarted()) {
        commit();
      }
      getSpannerConnection().setAutocommit(autoCommit);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public boolean getAutoCommit() throws SQLException {
    checkClosed();
    return getSpannerConnection().isAutocommit();
  }

  @Override
  public void commit() throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().commit();
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void rollback() throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().rollback();
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void close() throws SQLException {
    try {
      getSpannerConnection().close();
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public boolean isClosed() throws SQLException {
    return getSpannerConnection().isClosed();
  }

  @Override
  public DatabaseMetaData getMetaData() throws SQLException {
    checkClosed();
    return new JdbcDatabaseMetaData(this);
  }

  @Override
  public void setReadOnly(boolean readOnly) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().setReadOnly(readOnly);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public boolean isReadOnly() throws SQLException {
    checkClosed();
    return getSpannerConnection().isReadOnly();
  }

  @Override
  public Statement createStatement(int resultSetType, int resultSetConcurrency)
      throws SQLException {
    checkClosed();
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetType == ResultSet.TYPE_FORWARD_ONLY, ONLY_RS_FORWARD_ONLY);
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetConcurrency == ResultSet.CONCUR_READ_ONLY, ONLY_CONCUR_READ_ONLY);
    return createStatement();
  }

  @Override
  public Statement createStatement(
      int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
    checkClosed();
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetType == ResultSet.TYPE_FORWARD_ONLY, ONLY_RS_FORWARD_ONLY);
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetConcurrency == ResultSet.CONCUR_READ_ONLY, ONLY_CONCUR_READ_ONLY);
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetHoldability == ResultSet.CLOSE_CURSORS_AT_COMMIT, ONLY_CLOSE_CURSORS_AT_COMMIT);
    return createStatement();
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
      throws SQLException {
    checkClosed();
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetType == ResultSet.TYPE_FORWARD_ONLY, ONLY_RS_FORWARD_ONLY);
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetConcurrency == ResultSet.CONCUR_READ_ONLY, ONLY_CONCUR_READ_ONLY);
    return prepareStatement(sql);
  }

  @Override
  public PreparedStatement prepareStatement(
      String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
      throws SQLException {
    checkClosed();
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetType == ResultSet.TYPE_FORWARD_ONLY, ONLY_RS_FORWARD_ONLY);
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetConcurrency == ResultSet.CONCUR_READ_ONLY, ONLY_CONCUR_READ_ONLY);
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetHoldability == ResultSet.CLOSE_CURSORS_AT_COMMIT, ONLY_CLOSE_CURSORS_AT_COMMIT);
    return prepareStatement(sql);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
    checkClosed();
    JdbcPreconditions.checkSqlFeatureSupported(
        autoGeneratedKeys == Statement.NO_GENERATED_KEYS, ONLY_NO_GENERATED_KEYS);
    return prepareStatement(sql);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
    checkClosed();
    return prepareStatement(sql);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
    checkClosed();
    return prepareStatement(sql);
  }

  @Override
  public Map<String, Class<?>> getTypeMap() throws SQLException {
    checkClosed();
    return new HashMap<>(typeMap);
  }

  @Override
  public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
    checkClosed();
    this.typeMap = new HashMap<>(map);
  }

  @Override
  public boolean isValid(int timeout) throws SQLException {
    JdbcPreconditions.checkArgument(timeout >= 0, "timeout must be >= 0");
    if (!isClosed()) {
      try {
        Statement statement = createStatement();
        statement.setQueryTimeout(timeout);
        try (ResultSet rs = statement.executeQuery(IS_VALID_QUERY)) {
          if (rs.next()) {
            if (rs.getLong(1) == 1L) {
              return true;
            }
          }
        }
      } catch (SQLException e) {
        // ignore
      }
    }
    return false;
  }

  @Override
  public Blob createBlob() throws SQLException {
    checkClosed();
    return new JdbcBlob();
  }

  @Override
  public Clob createClob() throws SQLException {
    checkClosed();
    return new JdbcClob();
  }

  @Override
  public NClob createNClob() throws SQLException {
    checkClosed();
    return new JdbcClob();
  }

  @Override
  public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
    checkClosed();
    return JdbcArray.createArray(typeName, elements);
  }

  @Override
  public void setCatalog(String catalog) throws SQLException {
    // This method could be changed to allow the user to change to another database.
    // For now we only support setting an empty string in order to support frameworks
    // and applications that set this when no catalog has been specified in the connection
    // URL.
    checkClosed();
    JdbcPreconditions.checkArgument("".equals(catalog), "Only catalog \"\" is supported");
  }

  @Override
  public String getCatalog() throws SQLException {
    checkClosed();
    return getConnectionOptions().getDatabaseName();
  }

  @Override
  public void setSchema(String schema) throws SQLException {
    checkClosed();
    // Cloud Spanner does not support schemas, but does contain a pseudo 'empty string' schema that
    // might be set by frameworks and applications that read the database metadata.
    JdbcPreconditions.checkArgument("".equals(schema), "Only schema \"\" is supported");
  }

  @Override
  public String getSchema() throws SQLException {
    checkClosed();
    return "";
  }

  @Override
  public Timestamp getCommitTimestamp() throws SQLException {
    checkClosed();
    try {
      return getSpannerConnection().getCommitTimestamp().toSqlTimestamp();
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public Timestamp getReadTimestamp() throws SQLException {
    checkClosed();
    try {
      return getSpannerConnection().getReadTimestamp().toSqlTimestamp();
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public boolean isRetryAbortsInternally() throws SQLException {
    checkClosed();
    try {
      return getSpannerConnection().isRetryAbortsInternally();
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void setRetryAbortsInternally(boolean retryAbortsInternally) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().setRetryAbortsInternally(retryAbortsInternally);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void write(Mutation mutation) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().write(mutation);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void write(Iterable<Mutation> mutations) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().write(mutations);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void bufferedWrite(Mutation mutation) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().bufferedWrite(mutation);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void bufferedWrite(Iterable<Mutation> mutations) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().bufferedWrite(mutations);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void addTransactionRetryListener(TransactionRetryListener listener) throws SQLException {
    checkClosed();
    getSpannerConnection().addTransactionRetryListener(listener);
  }

  @Override
  public boolean removeTransactionRetryListener(TransactionRetryListener listener)
      throws SQLException {
    checkClosed();
    return getSpannerConnection().removeTransactionRetryListener(listener);
  }

  @Override
  public Iterator<TransactionRetryListener> getTransactionRetryListeners() throws SQLException {
    checkClosed();
    return getSpannerConnection().getTransactionRetryListeners();
  }
}
