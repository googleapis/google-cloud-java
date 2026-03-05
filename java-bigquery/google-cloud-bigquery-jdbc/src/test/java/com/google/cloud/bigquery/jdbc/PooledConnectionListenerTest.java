/*
 * Copyright 2025 Google LLC
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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;

public class PooledConnectionListenerTest {
  private BigQueryConnection bigQueryConnection;
  private static final Long LISTENER_POOL_SIZE = 10L;
  private static final Long CONNECTION_POOL_SIZE = 10L;

  @Before
  public void setUp() throws IOException, SQLException {
    bigQueryConnection = mock(BigQueryConnection.class);
  }

  @Test
  public void testAddConnectionListener() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    PooledConnectionListener listener = new PooledConnectionListener(LISTENER_POOL_SIZE);
    assertEquals(CONNECTION_POOL_SIZE, listener.getConnectionPoolSize());
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());
    assertNull(listener.getPooledConnection());
  }

  @Test
  public void testRemoveConnectionListener() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    PooledConnectionListener listener = new PooledConnectionListener(LISTENER_POOL_SIZE);
    assertEquals(CONNECTION_POOL_SIZE, listener.getConnectionPoolSize());
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    assertTrue(pooledConnection.isListenerPooled(listener));
    pooledConnection.removeConnectionEventListener(listener);
    assertFalse(pooledConnection.isListenerPooled(listener));
  }

  @Test
  public void testConnectionHandleClosedByConnection() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertFalse(pooledConnection.inUse());
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertTrue(pooledConnection.inUse());

    PooledConnectionListener listener = new PooledConnectionListener(LISTENER_POOL_SIZE);
    assertEquals(CONNECTION_POOL_SIZE, listener.getConnectionPoolSize());
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    connection.close();
    assertFalse(pooledConnection.inUse());
    assertFalse(listener.isConnectionPoolEmpty());
    assertEquals(1, listener.getConnectionPoolCurrentCapacity());
    assertTrue(pooledConnection.isListenerPooled(listener));
  }

  @Test
  public void testConnectionHandleClosedByPooledConnection() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertFalse(pooledConnection.inUse());
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertTrue(pooledConnection.inUse());

    PooledConnectionListener listener = new PooledConnectionListener(LISTENER_POOL_SIZE);
    assertEquals(CONNECTION_POOL_SIZE, listener.getConnectionPoolSize());
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    pooledConnection.close();
    assertFalse(pooledConnection.inUse());
    assertFalse(listener.isConnectionPoolEmpty());
    assertEquals(1, listener.getConnectionPoolCurrentCapacity());
    assertTrue(pooledConnection.isListenerPooled(listener));
  }

  @Test
  public void testFireConnectionError() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertFalse(pooledConnection.inUse());
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertTrue(pooledConnection.inUse());

    PooledConnectionListener listener = new PooledConnectionListener(LISTENER_POOL_SIZE);
    assertEquals(CONNECTION_POOL_SIZE, listener.getConnectionPoolSize());
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    pooledConnection.fireConnectionError(new SQLException("test"));
    assertFalse(pooledConnection.inUse());
    assertTrue(listener.isConnectionPoolEmpty());
    assertFalse(pooledConnection.isListenerPooled(listener));
  }

  @Test
  public void testGetConnectionWhenPoolEmpty() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertFalse(pooledConnection.inUse());
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertTrue(pooledConnection.inUse());

    PooledConnectionListener listener = new PooledConnectionListener(LISTENER_POOL_SIZE);
    assertEquals(CONNECTION_POOL_SIZE, listener.getConnectionPoolSize());
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    assertNull(listener.getPooledConnection());
  }

  @Test
  public void testGetConnectionWhenPoolNonEmpty() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertFalse(pooledConnection.inUse());
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertTrue(pooledConnection.inUse());

    PooledConnectionListener listener = new PooledConnectionListener(LISTENER_POOL_SIZE);
    assertEquals(CONNECTION_POOL_SIZE, listener.getConnectionPoolSize());
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    connection.close();
    assertFalse(pooledConnection.inUse());
    assertFalse(listener.isConnectionPoolEmpty());
    assertTrue(pooledConnection.isListenerPooled(listener));

    assertNotNull(listener.getPooledConnection());
  }
}
