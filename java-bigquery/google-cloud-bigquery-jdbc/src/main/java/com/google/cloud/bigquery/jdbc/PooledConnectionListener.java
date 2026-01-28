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

import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import javax.sql.PooledConnection;

public class PooledConnectionListener implements ConnectionEventListener {
  private final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());
  private String id; // Mainly for internal use
  private LinkedBlockingDeque<PooledConnection> connectionPool;
  private Long connectionPoolSize = 0L;

  public PooledConnectionListener(Long connPoolSize) {
    id = UUID.randomUUID().toString();
    this.connectionPoolSize = connPoolSize;
    if (getConnectionPoolSize() > 0L) {
      connectionPool = new LinkedBlockingDeque<>(getConnectionPoolSize().intValue());
    } else {
      connectionPool = new LinkedBlockingDeque<>();
    }
  }

  public Long getConnectionPoolSize() {
    return this.connectionPoolSize;
  }

  public int getConnectionPoolCurrentCapacity() {
    return this.connectionPool.size();
  }

  public boolean isConnectionPoolEmpty() {
    return (connectionPool != null && connectionPool.isEmpty());
  }

  PooledConnection getPooledConnection() {
    if (isConnectionPoolEmpty()) {
      LOG.warning("Connection pool is empty");
      return null;
    }
    // Return the first element.
    return connectionPool.getFirst();
  }

  void addConnection(PooledConnection connection) {
    LOG.finest("++enter++");
    if (connection == null) {
      LOG.warning("Connection passed in is null");
      return;
    }
    if (connectionPool.contains(connection)) {
      LOG.warning("Connection already in the pool");
      return;
    }
    connectionPool.add(connection);
  }

  void removeConnection(PooledConnection connection) {
    LOG.finest("++enter++");
    if (connection == null) {
      LOG.warning("Connection passed in is null");
      return;
    }
    if (!connectionPool.contains(connection)) {
      LOG.warning("Connection already in the pool");
      return;
    }
    connectionPool.remove(connection);
  }

  @Override
  public void connectionClosed(ConnectionEvent event) {
    LOG.finest("++enter++");
    Object eventSource = event.getSource();
    if (eventSource == null
        || !(eventSource instanceof BigQueryPooledConnection)
        || !(eventSource.getClass().isAssignableFrom(BigQueryPooledConnection.class))) {
      throw new IllegalArgumentException(
          "Invalid ConnectionEvent source passed to connectionClosed. Expecting"
              + " BigQueryPooledConnection.");
    }
    BigQueryPooledConnection bqPooledConnection = (BigQueryPooledConnection) eventSource;
    addConnection(bqPooledConnection);
    LOG.finest("Added pooled connection to connection pool");
  }

  @Override
  public void connectionErrorOccurred(ConnectionEvent event) {
    LOG.finest("++enter++");
    Object eventSource = event.getSource();
    if (eventSource == null
        || !(eventSource instanceof BigQueryPooledConnection)
        || !(eventSource.getClass().isAssignableFrom(BigQueryPooledConnection.class))) {
      throw new IllegalArgumentException(
          "Invalid ConnectionEvent source passed to connectionClosed. Expecting"
              + " BigQueryPooledConnection.");
    }
    BigQueryPooledConnection bqPooledConnection = (BigQueryPooledConnection) eventSource;
    removeConnection(bqPooledConnection);
    String errorMessage =
        (event.getSQLException() != null)
            ? event.getSQLException().getMessage()
            : "Connection error occured";
    LOG.finest(
        String.format(
            "Removed pooled connection from connection pool due to error: %s", errorMessage));
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
    PooledConnectionListener other = (PooledConnectionListener) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }
}
