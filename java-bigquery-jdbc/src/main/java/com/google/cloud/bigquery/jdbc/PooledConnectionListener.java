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

import java.util.ArrayDeque;
import java.util.Deque;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import javax.sql.PooledConnection;

public class PooledConnectionListener implements ConnectionEventListener {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(PooledConnectionListener.class.getName());
  private final Deque<BigQueryPooledConnection> connectionPool;
  private final Long connectionPoolSize;
  private final int maxCapacity;
  private final Object poolLock = new Object();

  public PooledConnectionListener(Long connPoolSize) {
    this.connectionPoolSize =
        connPoolSize != null
            ? connPoolSize
            : BigQueryJdbcUrlUtility.DEFAULT_CONNECTION_POOL_SIZE_VALUE;
    this.maxCapacity = BigQueryPooledConnection.clampCapacity(this.connectionPoolSize);
    this.connectionPool = new ArrayDeque<>();
  }

  public Long getConnectionPoolSize() {
    return this.connectionPoolSize;
  }

  public int getConnectionPoolCurrentCapacity() {
    synchronized (poolLock) {
      return this.connectionPool.size();
    }
  }

  public boolean isConnectionPoolEmpty() {
    synchronized (poolLock) {
      return this.connectionPool.isEmpty();
    }
  }

  BigQueryPooledConnection getPooledConnection() {
    synchronized (poolLock) {
      BigQueryPooledConnection candidate;
      while ((candidate = connectionPool.pollFirst()) != null) {
        if (!candidate.isAvailableForPool()) {
          continue;
        }
        return candidate;
      }
      LOG.finer("Connection pool is empty");
      return null;
    }
  }

  boolean addConnection(PooledConnection connection) {
    LOG.finer("++enter++");
    try {
      if (!(connection instanceof BigQueryPooledConnection)) {
        LOG.warning("Connection passed in is null or unsupported");
        return false;
      }
      BigQueryPooledConnection bqConnection = (BigQueryPooledConnection) connection;
      synchronized (poolLock) {
        if (!bqConnection.isAvailableForPool()) {
          return false;
        }
        if (connectionPool.contains(bqConnection)) {
          LOG.finer("Connection already in the pool");
          return true;
        }
        if (connectionPool.size() >= maxCapacity) {
          connectionPool.removeIf(entry -> !entry.isAvailableForPool());
          if (connectionPool.size() >= maxCapacity) {
            return false;
          }
        }
        // LIFO insertion keeps the most recently active idle connections warm.
        connectionPool.addFirst(bqConnection);
        return true;
      }
    } finally {
      LOG.finer("++exit++");
    }
  }

  void removeConnection(PooledConnection connection) {
    LOG.finer("++enter++");
    try {
      if (connection == null) {
        LOG.warning("Connection passed in is null");
        return;
      }
      synchronized (poolLock) {
        if (!connectionPool.remove(connection)) {
          LOG.finer("Connection not present in the pool");
        }
      }
    } finally {
      LOG.finer("++exit++");
    }
  }

  @Override
  public void connectionClosed(ConnectionEvent event) {
    LOG.finer("++enter++");
    try {
      BigQueryPooledConnection bqPooledConnection = extractPooledConnection(event);
      if (addConnection(bqPooledConnection)) {
        LOG.finer("Added pooled connection to connection pool");
        return;
      }
      bqPooledConnection.closeIfIdleAndSoleListener(this);
    } finally {
      LOG.finer("++exit++");
    }
  }

  @Override
  public void connectionErrorOccurred(ConnectionEvent event) {
    LOG.finer("++enter++");
    try {
      BigQueryPooledConnection bqPooledConnection = extractPooledConnection(event);
      removeConnection(bqPooledConnection);
      String errorMessage =
          (event.getSQLException() != null)
              ? event.getSQLException().getMessage()
              : "Connection error occurred";
      LOG.finer("Removed pooled connection from connection pool. Error: %s", errorMessage);
    } finally {
      LOG.finer("++exit++");
    }
  }

  private static BigQueryPooledConnection extractPooledConnection(ConnectionEvent event) {
    Object eventSource = event != null ? event.getSource() : null;
    if (eventSource == null || eventSource.getClass() != BigQueryPooledConnection.class) {
      IllegalArgumentException ex =
          new IllegalArgumentException(
              "Invalid ConnectionEvent source. Expecting BigQueryPooledConnection.");
      LOG.severe(ex.getMessage(), ex);
      throw ex;
    }
    return (BigQueryPooledConnection) eventSource;
  }
}
