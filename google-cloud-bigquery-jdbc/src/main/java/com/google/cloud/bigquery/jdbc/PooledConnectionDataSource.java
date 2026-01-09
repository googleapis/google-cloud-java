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

import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import com.google.common.annotations.VisibleForTesting;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;

public class PooledConnectionDataSource extends DataSource implements ConnectionPoolDataSource {
  private PooledConnectionListener connectionPoolManager = null;
  Connection bqConnection = null;

  @Override
  public PooledConnection getPooledConnection() throws SQLException {
    if (connectionPoolManager != null && !connectionPoolManager.isConnectionPoolEmpty()) {
      return connectionPoolManager.getPooledConnection();
    }
    // Create the Underlying physical connection
    if (bqConnection == null) {
      bqConnection = super.getConnection();
    }
    if (bqConnection == null) {
      throw new BigQueryJdbcRuntimeException(
          "Cannot get pooled connection: unable to get underlying physical connection");
    }
    String connectionURl = ((BigQueryConnection) bqConnection).getConnectionUrl();
    Long connectionPoolSize =
        BigQueryJdbcUrlUtility.parseConnectionPoolSize(connectionURl, this.toString());
    if (connectionPoolManager == null) {
      connectionPoolManager = new PooledConnectionListener(connectionPoolSize);
    }
    BigQueryPooledConnection bqPooledConnection = new BigQueryPooledConnection(bqConnection);
    bqPooledConnection.addConnectionEventListener(connectionPoolManager);
    return bqPooledConnection;
  }

  @VisibleForTesting
  void setConnection(Connection connection) {
    this.bqConnection = connection;
  }

  @VisibleForTesting
  public PooledConnectionListener getConnectionPoolManager() {
    return this.connectionPoolManager;
  }

  @Override
  public PooledConnection getPooledConnection(String arg0, String arg1) throws SQLException {
    throw new UnsupportedOperationException("This operation is not supported by the driver");
  }
}
