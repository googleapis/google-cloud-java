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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import com.google.cloud.bigquery.jdbc.utils.TestUtilities.TestConnectionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.ConnectionEvent;
import javax.sql.PooledConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PooledConnectionListenerTest {
  private BigQueryConnection bigQueryConnection;
  private static final Long LISTENER_POOL_SIZE = 7L;
  private static final Long CONNECTION_POOL_SIZE = 10L;

  @BeforeEach
  public void setUp() throws IOException, SQLException {
    bigQueryConnection = mock(BigQueryConnection.class);
    // Stub the listener pool size
    doReturn(LISTENER_POOL_SIZE).when(bigQueryConnection).getListenerPoolSize();
    doReturn(CONNECTION_POOL_SIZE).when(bigQueryConnection).getConnectionPoolSize();
  }

  @Test
  public void testAddConnectionListener() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    PooledConnectionListener listener = new PooledConnectionListener(CONNECTION_POOL_SIZE);
    assertEquals(CONNECTION_POOL_SIZE, listener.getConnectionPoolSize());
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());
    assertNull(listener.getPooledConnection());
  }

  @Test
  public void testRemoveConnectionListener() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    PooledConnectionListener listener = new PooledConnectionListener(CONNECTION_POOL_SIZE);
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

    PooledConnectionListener listener = new PooledConnectionListener(CONNECTION_POOL_SIZE);
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
  public void testPooledConnectionClose_closesPhysicalConnectionWithoutRequeuing()
      throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertFalse(pooledConnection.inUse());
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertTrue(pooledConnection.inUse());

    PooledConnectionListener listener = new PooledConnectionListener(CONNECTION_POOL_SIZE);
    assertEquals(CONNECTION_POOL_SIZE, listener.getConnectionPoolSize());
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    pooledConnection.close();
    assertFalse(pooledConnection.inUse());
    assertTrue(connection.isClosed());
    assertTrue(listener.isConnectionPoolEmpty());
    assertEquals(0, listener.getConnectionPoolCurrentCapacity());
    assertFalse(pooledConnection.isListenerPooled(listener));
    verify(bigQueryConnection).close();
  }

  @Test
  public void testFireConnectionError() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertFalse(pooledConnection.inUse());
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertTrue(pooledConnection.inUse());

    PooledConnectionListener listener = new PooledConnectionListener(CONNECTION_POOL_SIZE);
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

    PooledConnectionListener listener = new PooledConnectionListener(CONNECTION_POOL_SIZE);
    assertEquals(CONNECTION_POOL_SIZE, listener.getConnectionPoolSize());
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    assertNull(listener.getPooledConnection());
  }

  @Test
  public void testGetConnectionWhenPoolNonEmpty_removesCheckedOutConnection() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertFalse(pooledConnection.inUse());
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertTrue(pooledConnection.inUse());

    PooledConnectionListener listener = new PooledConnectionListener(CONNECTION_POOL_SIZE);
    assertEquals(CONNECTION_POOL_SIZE, listener.getConnectionPoolSize());
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    connection.close();
    assertFalse(pooledConnection.inUse());
    assertFalse(listener.isConnectionPoolEmpty());
    assertTrue(pooledConnection.isListenerPooled(listener));

    PooledConnection checkedOut = listener.getPooledConnection();
    assertSame(pooledConnection, checkedOut);
    assertTrue(listener.isConnectionPoolEmpty());
    assertEquals(0, listener.getConnectionPoolCurrentCapacity());
    assertNull(listener.getPooledConnection());
  }

  @Test
  public void testReturnWhenPoolAtCapacity_closesExcessWhenSoleListener() throws SQLException {
    PooledConnectionListener listener = new PooledConnectionListener(1L);

    BigQueryConnection bqConn1 = mock(BigQueryConnection.class);
    doReturn(LISTENER_POOL_SIZE).when(bqConn1).getListenerPoolSize();
    BigQueryPooledConnection pc1 = new BigQueryPooledConnection(bqConn1);
    pc1.addConnectionEventListener(listener);

    BigQueryConnection bqConn2 = mock(BigQueryConnection.class);
    doReturn(LISTENER_POOL_SIZE).when(bqConn2).getListenerPoolSize();
    BigQueryPooledConnection pc2 = new BigQueryPooledConnection(bqConn2);
    pc2.addConnectionEventListener(listener);

    Connection c1 = pc1.getConnection();
    Connection c2 = pc2.getConnection();

    c1.close();
    assertEquals(1, listener.getConnectionPoolCurrentCapacity());
    verify(bqConn1, never()).close();

    c2.close();
    assertEquals(1, listener.getConnectionPoolCurrentCapacity());
    verify(bqConn2).close();
  }

  @Test
  public void testReturnWhenPoolAtCapacity_prunesStaleInUseEntryBeforeRejecting()
      throws SQLException {
    PooledConnectionListener listener = new PooledConnectionListener(1L);

    BigQueryConnection bqConn1 = mock(BigQueryConnection.class);
    doReturn(LISTENER_POOL_SIZE).when(bqConn1).getListenerPoolSize();
    BigQueryPooledConnection pc1 = new BigQueryPooledConnection(bqConn1);
    pc1.addConnectionEventListener(listener);

    BigQueryConnection bqConn2 = mock(BigQueryConnection.class);
    doReturn(LISTENER_POOL_SIZE).when(bqConn2).getListenerPoolSize();
    BigQueryPooledConnection pc2 = new BigQueryPooledConnection(bqConn2);
    pc2.addConnectionEventListener(listener);

    pc1.getConnection().close();
    assertEquals(1, listener.getConnectionPoolCurrentCapacity());

    // Re-acquiring pc1 directly makes its pooled entry stale (inUse == true).
    Connection directConn1 = pc1.getConnection();
    Connection c2 = pc2.getConnection();
    c2.close();

    assertEquals(1, listener.getConnectionPoolCurrentCapacity());
    verify(bqConn2, never()).close();
    assertSame(pc2, listener.getPooledConnection());
    directConn1.close();
  }

  @Test
  public void testReturnWhenPoolAtCapacity_keepsPhysicalOpenWhenExternalListenerPresent()
      throws SQLException {
    PooledConnectionListener listener = new PooledConnectionListener(1L);
    TestConnectionListener externalListener = new TestConnectionListener();

    BigQueryConnection bqConn1 = mock(BigQueryConnection.class);
    doReturn(LISTENER_POOL_SIZE).when(bqConn1).getListenerPoolSize();
    BigQueryPooledConnection pc1 = new BigQueryPooledConnection(bqConn1);
    pc1.addConnectionEventListener(listener);

    BigQueryConnection bqConn2 = mock(BigQueryConnection.class);
    doReturn(LISTENER_POOL_SIZE).when(bqConn2).getListenerPoolSize();
    BigQueryPooledConnection pc2 = new BigQueryPooledConnection(bqConn2);
    pc2.addConnectionEventListener(listener);
    pc2.addConnectionEventListener(externalListener);

    Connection c1 = pc1.getConnection();
    Connection c2 = pc2.getConnection();

    c1.close();
    c2.close();
    assertEquals(1, listener.getConnectionPoolCurrentCapacity());
    assertEquals(1, externalListener.getConnectionClosedCount());
    verify(bqConn2, never()).close();
  }

  @Test
  public void testNullZeroAndLargePoolSize_handledSafely() throws SQLException {
    PooledConnectionListener defaultListener = new PooledConnectionListener(null);
    assertEquals(
        BigQueryJdbcUrlUtility.DEFAULT_CONNECTION_POOL_SIZE_VALUE,
        defaultListener.getConnectionPoolSize());
    assertTrue(defaultListener.isConnectionPoolEmpty());

    // ConnectionPoolSize=0 preserves unbounded idle deque capacity (M15) and LIFO checkout order.
    PooledConnectionListener unboundedListener = new PooledConnectionListener(0L);
    assertEquals(0L, unboundedListener.getConnectionPoolSize());
    BigQueryPooledConnection firstReturned = null;
    BigQueryPooledConnection lastReturned = null;
    for (int i = 0; i < 12; i++) {
      BigQueryConnection mockPhysical = mock(BigQueryConnection.class);
      doReturn(LISTENER_POOL_SIZE).when(mockPhysical).getListenerPoolSize();
      BigQueryPooledConnection pc = new BigQueryPooledConnection(mockPhysical);
      pc.addConnectionEventListener(unboundedListener);
      Connection conn = pc.getConnection();
      conn.close();
      verify(mockPhysical, never()).close();
      if (i == 0) {
        firstReturned = pc;
      }
      if (i == 11) {
        lastReturned = pc;
      }
    }
    assertEquals(12, unboundedListener.getConnectionPoolCurrentCapacity());
    assertSame(lastReturned, unboundedListener.getPooledConnection());
    for (int i = 0; i < 10; i++) {
      assertNotNull(unboundedListener.getPooledConnection());
    }
    assertSame(firstReturned, unboundedListener.getPooledConnection());
    assertTrue(unboundedListener.isConnectionPoolEmpty());

    PooledConnectionListener largeListener = new PooledConnectionListener(Long.MAX_VALUE);
    assertEquals(Long.MAX_VALUE, largeListener.getConnectionPoolSize());
    assertEquals(Integer.MAX_VALUE, BigQueryPooledConnection.clampCapacity(Long.MAX_VALUE));
  }

  @Test
  public void testAddConnection_guardsNullInUseClosedAndDuplicates() throws SQLException {
    PooledConnectionListener listener = new PooledConnectionListener(CONNECTION_POOL_SIZE);
    assertFalse(listener.addConnection(null));
    assertFalse(listener.addConnection(mock(PooledConnection.class)));

    BigQueryPooledConnection pc = new BigQueryPooledConnection(bigQueryConnection);
    Connection conn = pc.getConnection();
    assertFalse(listener.addConnection(pc), "In-use PooledConnection must not be pooled");

    conn.close();
    assertTrue(listener.addConnection(pc));
    assertTrue(
        listener.addConnection(pc), "Duplicate addConnection returns true without duplicating");
    assertEquals(1, listener.getConnectionPoolCurrentCapacity());

    pc.close();
    listener.removeConnection(pc);
    assertFalse(
        listener.addConnection(pc), "Physically closed PooledConnection must not be pooled");
  }

  @Test
  public void testGetPooledConnection_skipsClosedAndInUseEntries() throws SQLException {
    PooledConnectionListener listener = new PooledConnectionListener(CONNECTION_POOL_SIZE);

    BigQueryConnection bqConn1 = mock(BigQueryConnection.class);
    doReturn(LISTENER_POOL_SIZE).when(bqConn1).getListenerPoolSize();
    BigQueryPooledConnection pcClosed = new BigQueryPooledConnection(bqConn1);
    assertTrue(listener.addConnection(pcClosed));
    pcClosed.close();

    BigQueryConnection bqConn2 = mock(BigQueryConnection.class);
    doReturn(LISTENER_POOL_SIZE).when(bqConn2).getListenerPoolSize();
    BigQueryPooledConnection pcInUse = new BigQueryPooledConnection(bqConn2);
    assertTrue(listener.addConnection(pcInUse));
    Connection activeHandle = pcInUse.getConnection();

    BigQueryConnection bqConn3 = mock(BigQueryConnection.class);
    doReturn(LISTENER_POOL_SIZE).when(bqConn3).getListenerPoolSize();
    BigQueryPooledConnection pcIdle = new BigQueryPooledConnection(bqConn3);
    assertTrue(listener.addConnection(pcIdle));

    assertEquals(3, listener.getConnectionPoolCurrentCapacity());
    assertSame(pcIdle, listener.getPooledConnection());
    assertNull(listener.getPooledConnection());
    activeHandle.close();
  }

  @Test
  public void testInvalidEventSource_throwsIllegalArgumentException() {
    PooledConnectionListener listener = new PooledConnectionListener(CONNECTION_POOL_SIZE);
    PooledConnection foreignPooledConnection = mock(PooledConnection.class);
    ConnectionEvent invalidEvent = new ConnectionEvent(foreignPooledConnection);

    assertThrows(IllegalArgumentException.class, () -> listener.connectionClosed(invalidEvent));
    assertThrows(
        IllegalArgumentException.class, () -> listener.connectionErrorOccurred(invalidEvent));
  }
}
