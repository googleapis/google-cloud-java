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

import com.google.common.annotations.VisibleForTesting;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import javax.sql.PooledConnection;
import javax.sql.StatementEventListener;

class BigQueryPooledConnection implements PooledConnection {
  private final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());

  private String id; // Mainly for internal use
  private Connection bqConnection;
  private boolean inUse = false;
  private Long listenerPoolSize = 10L;
  private LinkedBlockingDeque<ConnectionEventListener> listeners;

  BigQueryPooledConnection(Connection bqConnection) {
    this.bqConnection = bqConnection;
    this.id = UUID.randomUUID().toString();
    String connectionUrl = ((BigQueryConnection) bqConnection).getConnectionUrl();
    if (connectionUrl != null && !connectionUrl.isEmpty()) {
      this.listenerPoolSize =
          BigQueryJdbcUrlUtility.parseListenerPoolSize(connectionUrl, this.toString());
    }
    if (getListenerPoolSize() > 0L) {
      listeners = new LinkedBlockingDeque<>(getListenerPoolSize().intValue());
    } else {
      listeners = new LinkedBlockingDeque<>();
    }
  }

  Long getListenerPoolSize() {
    return listenerPoolSize;
  }

  @VisibleForTesting
  boolean inUse() {
    return inUse;
  }

  @VisibleForTesting
  boolean isListenerPooled(ConnectionEventListener l) {
    return listeners.contains(l);
  }

  @Override
  public synchronized Connection getConnection() throws SQLException {
    LOG.finest("++enter++");
    if (inUse) {
      throw new SQLException("PooledConnection is already in use.");
    }
    inUse = true;
    // Return a wrapper around the underlying physical connection.
    return new BigQueryPooledConnectionWrapper(bqConnection, this);
  }

  @Override
  public synchronized void close() throws SQLException {
    LOG.finest("++enter++");
    // Notify listeners that the *PooledConnection* is being closed.
    ConnectionEvent event = new ConnectionEvent(this);
    for (ConnectionEventListener listener : listeners) {
      listener.connectionClosed(event); // This is likely not the intended event for this action
    }
    // Marks the pooled connection to be not in use.
    inUse = false;
  }

  @Override
  public synchronized void addConnectionEventListener(ConnectionEventListener listener) {
    LOG.finest("++enter++");
    if (listener == null) {
      return;
    }
    if (this.listeners.contains(listener)) {
      return;
    }
    this.listeners.add(listener);
  }

  @Override
  public synchronized void removeConnectionEventListener(ConnectionEventListener listener) {
    LOG.finest("++enter++");
    if (listener == null) {
      return;
    }
    if (!this.listeners.contains(listener)) {
      return;
    }
    this.listeners.remove(listener);
  }

  // Method called by the BigQueryPooledConnectionWrapper when the logical
  // Connection is closed.
  public synchronized void connectionHandleClosed(BigQueryPooledConnectionWrapper handle) {
    LOG.finest("++enter++");
    inUse = false;
    ConnectionEvent event = new ConnectionEvent(this);
    for (ConnectionEventListener listener : listeners) {
      listener.connectionClosed(event);
    }
    LOG.finest("Connection handle returned to the pool.");
  }

  // Method to notify listeners about a connection error. This can be called
  // by the application if they are using PooledConnection directly or by the
  // BigQueryPooledConnectionWrapper when a connection is aborted.
  public synchronized void fireConnectionError(SQLException e) {
    LOG.finest("++enter++");
    inUse = false;
    ConnectionEvent event = new ConnectionEvent(this, e);
    for (ConnectionEventListener listener : listeners) {
      listener.connectionErrorOccurred(event);
    }
    LOG.finest(
        String.format("Connection handle removed from the pool due to error: %s", e.getMessage()));
    // Listners no longer need to listen for this connection since it has been removed from the
    // pool.
    for (ConnectionEventListener listener : listeners) {
      removeConnectionEventListener(listener);
    }
  }

  @Override
  public void addStatementEventListener(StatementEventListener arg0) {
    throw new UnsupportedOperationException(
        "Method 'addStatementEventListener' is not supported by the BQ Driver");
  }

  @Override
  public void removeStatementEventListener(StatementEventListener arg0) {
    throw new UnsupportedOperationException(
        "Method 'removeStatementEventListener' is not supported by the BQ Driver");
  }

  // Inner class: Connection Wrapper around the actual physical Connection
  // This class notifies the listeners or calls the listner notification methods
  // provided by the pooled connection.
  static class BigQueryPooledConnectionWrapper implements Connection {
    private final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());
    private Connection bqConnectionDelegate;
    private BigQueryPooledConnection pooledConnection;
    private boolean closed = false;

    public BigQueryPooledConnectionWrapper(
        Connection bqConnectionDelegate, BigQueryPooledConnection pooledConnection) {
      this.bqConnectionDelegate = bqConnectionDelegate;
      this.pooledConnection = pooledConnection;
    }

    @Override
    public void close() throws SQLException {
      LOG.finest("++enter++");
      if (!closed) {
        // Instead of physically closing, we notify the PooledConnection
        // that this handle is no longer in use.
        pooledConnection.connectionHandleClosed(this);
        closed = true;
        LOG.finest("Logical connection closed (returned to pool).");
      }
    }

    @Override
    public boolean isClosed() throws SQLException {
      return closed || bqConnectionDelegate.isClosed();
    }

    @Override
    public java.sql.Statement createStatement() throws SQLException {
      return bqConnectionDelegate.createStatement();
    }

    @Override
    public java.sql.PreparedStatement prepareStatement(String sql) throws SQLException {
      return bqConnectionDelegate.prepareStatement(sql);
    }

    @Override
    public java.sql.CallableStatement prepareCall(String sql) throws SQLException {
      return bqConnectionDelegate.prepareCall(sql);
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
      return bqConnectionDelegate.nativeSQL(sql);
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
      bqConnectionDelegate.setAutoCommit(autoCommit);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
      return bqConnectionDelegate.getAutoCommit();
    }

    @Override
    public void commit() throws SQLException {
      bqConnectionDelegate.commit();
    }

    @Override
    public void rollback() throws SQLException {
      bqConnectionDelegate.rollback();
    }

    @Override
    public java.sql.DatabaseMetaData getMetaData() throws SQLException {
      return bqConnectionDelegate.getMetaData();
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
      bqConnectionDelegate.setReadOnly(readOnly);
    }

    @Override
    public boolean isReadOnly() throws SQLException {
      return bqConnectionDelegate.isReadOnly();
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
      bqConnectionDelegate.setCatalog(catalog);
    }

    @Override
    public String getCatalog() throws SQLException {
      return bqConnectionDelegate.getCatalog();
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
      bqConnectionDelegate.setTransactionIsolation(level);
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
      return bqConnectionDelegate.getTransactionIsolation();
    }

    @Override
    public java.sql.SQLWarning getWarnings() throws SQLException {
      return bqConnectionDelegate.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {
      bqConnectionDelegate.clearWarnings();
    }

    @Override
    public java.sql.Statement createStatement(int resultSetType, int resultSetConcurrency)
        throws SQLException {
      return bqConnectionDelegate.createStatement(resultSetType, resultSetConcurrency);
    }

    @Override
    public java.sql.PreparedStatement prepareStatement(
        String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
      return bqConnectionDelegate.prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public java.sql.CallableStatement prepareCall(
        String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
      return bqConnectionDelegate.prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public java.util.Map<String, Class<?>> getTypeMap() throws SQLException {
      return bqConnectionDelegate.getTypeMap();
    }

    @Override
    public void setTypeMap(java.util.Map<String, Class<?>> map) throws SQLException {
      bqConnectionDelegate.setTypeMap(map);
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
      bqConnectionDelegate.setHoldability(holdability);
    }

    @Override
    public int getHoldability() throws SQLException {
      return bqConnectionDelegate.getHoldability();
    }

    @Override
    public java.sql.Savepoint setSavepoint() throws SQLException {
      return bqConnectionDelegate.setSavepoint();
    }

    @Override
    public java.sql.Savepoint setSavepoint(String name) throws SQLException {
      return bqConnectionDelegate.setSavepoint(name);
    }

    @Override
    public void rollback(java.sql.Savepoint savepoint) throws SQLException {
      bqConnectionDelegate.rollback(savepoint);
    }

    @Override
    public void releaseSavepoint(java.sql.Savepoint savepoint) throws SQLException {
      bqConnectionDelegate.releaseSavepoint(savepoint);
    }

    @Override
    public java.sql.Statement createStatement(
        int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
      return bqConnectionDelegate.createStatement(
          resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public java.sql.PreparedStatement prepareStatement(
        String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
        throws SQLException {
      return bqConnectionDelegate.prepareStatement(
          sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public java.sql.CallableStatement prepareCall(
        String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
        throws SQLException {
      return bqConnectionDelegate.prepareCall(
          sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public java.sql.PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
        throws SQLException {
      return bqConnectionDelegate.prepareStatement(sql, autoGeneratedKeys);
    }

    @Override
    public java.sql.PreparedStatement prepareStatement(String sql, int[] columnIndices)
        throws SQLException {
      return bqConnectionDelegate.prepareStatement(sql, columnIndices);
    }

    @Override
    public java.sql.PreparedStatement prepareStatement(String sql, String[] columnNames)
        throws SQLException {
      return bqConnectionDelegate.prepareStatement(sql, columnNames);
    }

    @Override
    public java.sql.Clob createClob() throws SQLException {
      return bqConnectionDelegate.createClob();
    }

    @Override
    public java.sql.Blob createBlob() throws SQLException {
      return bqConnectionDelegate.createBlob();
    }

    @Override
    public java.sql.NClob createNClob() throws SQLException {
      return bqConnectionDelegate.createNClob();
    }

    @Override
    public java.sql.SQLXML createSQLXML() throws SQLException {
      return bqConnectionDelegate.createSQLXML();
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
      return bqConnectionDelegate.isValid(timeout);
    }

    @Override
    public void setClientInfo(String name, String value) throws java.sql.SQLClientInfoException {
      bqConnectionDelegate.setClientInfo(name, value);
    }

    @Override
    public void setClientInfo(java.util.Properties properties)
        throws java.sql.SQLClientInfoException {
      bqConnectionDelegate.setClientInfo(properties);
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
      return bqConnectionDelegate.getClientInfo(name);
    }

    @Override
    public java.util.Properties getClientInfo() throws SQLException {
      return bqConnectionDelegate.getClientInfo();
    }

    @Override
    public java.sql.Array createArrayOf(String typeName, Object[] elements) throws SQLException {
      return bqConnectionDelegate.createArrayOf(typeName, elements);
    }

    @Override
    public java.sql.Struct createStruct(String typeName, Object[] attributes) throws SQLException {
      return bqConnectionDelegate.createStruct(typeName, attributes);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
      return bqConnectionDelegate.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
      return bqConnectionDelegate.isWrapperFor(iface);
    }

    @Override
    public void setSchema(String schema) throws SQLException {
      bqConnectionDelegate.setSchema(schema);
    }

    @Override
    public String getSchema() throws SQLException {
      return bqConnectionDelegate.getSchema();
    }

    @Override
    public void setNetworkTimeout(java.util.concurrent.Executor executor, int milliseconds)
        throws SQLException {
      bqConnectionDelegate.setNetworkTimeout(executor, milliseconds);
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
      return bqConnectionDelegate.getNetworkTimeout();
    }

    @Override
    public void abort(Executor arg0) throws SQLException {
      LOG.finest("++enter++");
      if (!closed) {
        // We notify the pooled connection that physical connection
        // is being aborted. We assume here that abort() is called for
        // error cases.
        SQLException e = new SQLException("Connection is being terminated and aborted");
        pooledConnection.fireConnectionError(e);
        closed = true;
        LOG.finest("Logical connection aborted (removed from pool).");
      }
      // Call the delate abort to actually close the undelying connection.
      bqConnectionDelegate.abort(arg0);
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    BigQueryPooledConnection other = (BigQueryPooledConnection) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }
}
