/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import java.sql.SQLException;
import javax.sql.PooledConnection;
import org.junit.Test;

public class PooledConnectionDataSourceTest {
  private static final Long LISTENER_POOL_SIZE = 20L;
  private static final Long CONNECTION_POOL_SIZE = 20L;
  private static final Long DEFAULT_LISTENER_POOL_SIZE = 10L;
  private static final Long DEFAULT_CONNECTION_POOL_SIZE = 10L;

  @Test
  public void testGetPooledConnection() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    BigQueryConnection bqConnection = mock(BigQueryConnection.class);
    doReturn(connectionUrl).when(bqConnection).getConnectionUrl();

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setConnection(bqConnection);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    assertTrue(pooledConnection instanceof BigQueryPooledConnection);
    BigQueryPooledConnection bqPooledConnection = (BigQueryPooledConnection) pooledConnection;
    assertEquals(LISTENER_POOL_SIZE, bqPooledConnection.getListenerPoolSize());
    assertNotNull(pooledDataSource.getConnectionPoolManager());
    assertEquals(
        CONNECTION_POOL_SIZE, pooledDataSource.getConnectionPoolManager().getConnectionPoolSize());
  }

  @Test
  public void testGetPooledConnectionNoConnectionURl() throws SQLException {
    BigQueryConnection bqConnection = mock(BigQueryConnection.class);
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setConnection(bqConnection);

    assertThrows(BigQueryJdbcRuntimeException.class, () -> pooledDataSource.getPooledConnection());
  }

  @Test
  public void testGetPooledConnectionFailInvalidConnectionURl() {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "ListenerPoolSize=invalid";
    BigQueryConnection bqConnection = mock(BigQueryConnection.class);
    doReturn(connectionUrl).when(bqConnection).getConnectionUrl();

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setConnection(bqConnection);

    assertThrows(NumberFormatException.class, () -> pooledDataSource.getPooledConnection());
  }
}
