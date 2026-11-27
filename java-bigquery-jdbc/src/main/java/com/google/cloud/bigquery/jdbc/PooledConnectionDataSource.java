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

import com.google.cloud.bigquery.jdbc.telemetry.v1.DriverFeature;
import com.google.cloud.bigquery.jdbc.telemetry.v1.TelemetryManager;
import com.google.common.annotations.VisibleForTesting;
import java.sql.SQLException;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;

public class PooledConnectionDataSource extends DataSource implements ConnectionPoolDataSource {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(PooledConnectionDataSource.class.getName());
  private volatile PooledConnectionListener connectionPoolManager = null;

  @Override
  public PooledConnection getPooledConnection() throws SQLException {
    PooledConnectionListener poolManager = this.connectionPoolManager;
    if (poolManager != null) {
      BigQueryPooledConnection candidate;
      while ((candidate = poolManager.getPooledConnection()) != null) {
        BigQueryConnection reusedPhysical = candidate.claimPhysicalForReuse(poolManager);
        if (reusedPhysical != null) {
          BigQueryPooledConnection recycled = new BigQueryPooledConnection(reusedPhysical);
          recycled.registerInternalPoolListener(poolManager);
          TelemetryManager.recordFeatureUsage(DriverFeature.DRIVER_FEATURE_CONNECTION_POOLING);
          return recycled;
        }
      }
    }

    BigQueryConnection physicalConnection = super.getConnection().unwrap(BigQueryConnection.class);
    poolManager = getOrInitConnectionPoolManager(physicalConnection.getConnectionPoolSize());
    BigQueryPooledConnection bqPooledConnection = new BigQueryPooledConnection(physicalConnection);
    bqPooledConnection.registerInternalPoolListener(poolManager);

    TelemetryManager.recordFeatureUsage(DriverFeature.DRIVER_FEATURE_CONNECTION_POOLING);
    return bqPooledConnection;
  }

  private PooledConnectionListener getOrInitConnectionPoolManager(Long resolvedPoolSize) {
    PooledConnectionListener existing = this.connectionPoolManager;
    if (existing != null) {
      return existing;
    }
    synchronized (this) {
      if (this.connectionPoolManager == null) {
        this.connectionPoolManager = new PooledConnectionListener(resolvedPoolSize);
      }
      return this.connectionPoolManager;
    }
  }

  @VisibleForTesting
  public PooledConnectionListener getConnectionPoolManager() {
    return this.connectionPoolManager;
  }

  @Override
  public PooledConnection getPooledConnection(String arg0, String arg1) throws SQLException {
    UnsupportedOperationException ex =
        new UnsupportedOperationException("This operation is not supported by the driver");
    LOG.severe(ex.getMessage(), ex);
    throw ex;
  }
}
