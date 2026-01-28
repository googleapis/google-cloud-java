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

import static com.google.cloud.bigquery.jdbc.utils.TestUtilities.TestConnectionListener;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.sql.*;
import org.junit.Before;
import org.junit.Test;

public class BigQueryPooledConnectionTest {
  private BigQueryConnection bigQueryConnection;
  private static final Long LISTENER_POOL_SIZE = 10L;

  @Before
  public void setUp() throws IOException, SQLException {
    bigQueryConnection = mock(BigQueryConnection.class);
  }

  @Test
  public void testGetPooledConnection() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertFalse(pooledConnection.inUse());
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertTrue(pooledConnection.inUse());
  }

  @Test
  public void testPooledConnectionClose() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertFalse(pooledConnection.inUse());
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertTrue(pooledConnection.inUse());

    connection.close();
    assertFalse(pooledConnection.inUse());
  }

  @Test
  public void testReuseConnectionAfterClose() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertFalse(pooledConnection.inUse());
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertTrue(pooledConnection.inUse());

    connection.close();
    assertFalse(pooledConnection.inUse());

    connection = pooledConnection.getConnection();
    assertTrue(pooledConnection.inUse());
  }

  @Test
  public void testAddConnectionListener() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    TestConnectionListener listner = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listner);

    assertTrue(pooledConnection.isListenerPooled(listner));
  }

  @Test
  public void testRemoveConnectionListener() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    TestConnectionListener listner = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listner);
    assertEquals(0, listner.getConnectionClosedCount());
    assertEquals(0, listner.getConnectionErrorCount());

    assertTrue(pooledConnection.isListenerPooled(listner));
    pooledConnection.removeConnectionEventListener(listner);
    assertFalse(pooledConnection.isListenerPooled(listner));
  }

  @Test
  public void testConnectionHandleClosedByConnection() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    assertFalse(pooledConnection.inUse());
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertTrue(pooledConnection.inUse());

    TestConnectionListener listner = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listner);
    assertEquals(0, listner.getConnectionClosedCount());
    assertEquals(0, listner.getConnectionErrorCount());

    connection.close();
    assertFalse(pooledConnection.inUse());
    assertEquals(1, listner.getConnectionClosedCount());
    assertEquals(0, listner.getConnectionErrorCount());

    assertTrue(pooledConnection.isListenerPooled(listner));
  }

  @Test
  public void testConnectionHandleClosedByPooledConnection() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    assertFalse(pooledConnection.inUse());
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertTrue(pooledConnection.inUse());

    TestConnectionListener listner = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listner);
    assertEquals(0, listner.getConnectionClosedCount());
    assertEquals(0, listner.getConnectionErrorCount());

    pooledConnection.close();
    assertFalse(pooledConnection.inUse());
    assertEquals(1, listner.getConnectionClosedCount());
    assertEquals(0, listner.getConnectionErrorCount());

    assertTrue(pooledConnection.isListenerPooled(listner));
  }

  @Test
  public void testFireConnectionError() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    assertFalse(pooledConnection.inUse());
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertTrue(pooledConnection.inUse());

    TestConnectionListener listner = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listner);
    assertEquals(0, listner.getConnectionClosedCount());
    assertEquals(0, listner.getConnectionErrorCount());

    pooledConnection.fireConnectionError(new SQLException("test"));
    assertFalse(pooledConnection.inUse());
    assertEquals(0, listner.getConnectionClosedCount());
    assertEquals(1, listner.getConnectionErrorCount());

    assertFalse(pooledConnection.isListenerPooled(listner));
  }
}
