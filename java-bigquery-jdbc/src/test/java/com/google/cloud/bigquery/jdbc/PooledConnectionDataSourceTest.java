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
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.jdbc.utils.TestUtilities.TestConnectionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import javax.sql.PooledConnection;
import org.junit.jupiter.api.Test;

public class PooledConnectionDataSourceTest {
  private static final Long LISTENER_POOL_SIZE = 20L;
  private static final Long CONNECTION_POOL_SIZE = 20L;

  private static String buildTestUrl(long connectionPoolSize, long listenerPoolSize) {
    return BigQueryJdbcBaseTest.getUriOAuthToken()
        .append("ProjectId", "test-project")
        .append("ConnectionPoolSize", connectionPoolSize)
        .append("ListenerPoolSize", listenerPoolSize)
        .toString();
  }

  @Test
  public void testGetPooledConnection() throws SQLException {
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(buildTestUrl(CONNECTION_POOL_SIZE, LISTENER_POOL_SIZE));
    pooledDataSource.setListenerPoolSize(LISTENER_POOL_SIZE);
    pooledDataSource.setConnectionPoolSize(CONNECTION_POOL_SIZE);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    try {
      assertNotNull(pooledConnection);
      assertTrue(pooledConnection instanceof BigQueryPooledConnection);
      BigQueryPooledConnection bqPooledConnection = (BigQueryPooledConnection) pooledConnection;
      assertEquals(LISTENER_POOL_SIZE, bqPooledConnection.getListenerPoolSize());
      assertNotNull(pooledDataSource.getConnectionPoolManager());
      assertEquals(
          CONNECTION_POOL_SIZE,
          pooledDataSource.getConnectionPoolManager().getConnectionPoolSize());
    } finally {
      pooledConnection.close();
    }
  }

  @Test
  public void testGetPooledConnectionWithCredentials_throwsUnsupportedOperationException() {
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(buildTestUrl(CONNECTION_POOL_SIZE, LISTENER_POOL_SIZE));

    assertThrows(
        UnsupportedOperationException.class,
        () -> pooledDataSource.getPooledConnection("user", "password"));
  }

  @Test
  public void testGetPooledConnection_honorsUrlConfiguredPoolSize() throws SQLException {
    PooledConnectionDataSource urlOnlyDataSource = new PooledConnectionDataSource();
    urlOnlyDataSource.setURL(buildTestUrl(5L, 7L));

    PooledConnection pooledConnection = urlOnlyDataSource.getPooledConnection();
    try {
      assertEquals(5L, urlOnlyDataSource.getConnectionPoolManager().getConnectionPoolSize());
      assertEquals(7L, ((BigQueryPooledConnection) pooledConnection).getListenerPoolSize());
    } finally {
      pooledConnection.close();
    }
  }

  @Test
  public void testOverlappingCheckouts_useDistinctPhysicalConnections() throws SQLException {
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(buildTestUrl(4L, 10L));

    PooledConnection pc1 = pooledDataSource.getPooledConnection();
    PooledConnection pc2 = pooledDataSource.getPooledConnection();
    try (Connection c1 = pc1.getConnection();
        Connection c2 = pc2.getConnection()) {
      assertNotSame(pc1, pc2);
      BigQueryConnection physical1 = c1.unwrap(BigQueryConnection.class);
      BigQueryConnection physical2 = c2.unwrap(BigQueryConnection.class);
      assertNotSame(physical1, physical2);
      assertFalse(physical1.isClosed());
      assertFalse(physical2.isClosed());
    } finally {
      pc1.close();
      pc2.close();
    }
  }

  @Test
  public void
      testReuseAfterLogicalClose_reusesPhysicalInFreshPooledConnectionAndRetiresStaleHolder()
          throws SQLException {
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(buildTestUrl(4L, 10L));

    PooledConnection pc1 = pooledDataSource.getPooledConnection();
    Connection c1 = pc1.getConnection();
    BigQueryConnection physical1 = c1.unwrap(BigQueryConnection.class);
    c1.close();

    PooledConnectionListener poolManager = pooledDataSource.getConnectionPoolManager();
    assertEquals(1, poolManager.getConnectionPoolCurrentCapacity());

    PooledConnection pcReused = pooledDataSource.getPooledConnection();
    assertNotSame(pc1, pcReused);
    assertTrue(poolManager.isConnectionPoolEmpty());

    // A stale reference to pc1 retained by the prior caller cannot reclaim or close physical1
    // (M02).
    BigQueryJdbcException retiredEx = assertThrows(BigQueryJdbcException.class, pc1::getConnection);
    assertTrue(retiredEx.getMessage().contains("retired"));

    Connection cReused = pcReused.getConnection();
    assertSame(physical1, cReused.unwrap(BigQueryConnection.class));
    pc1.close();
    assertFalse(physical1.isClosed(), "Closing retired holder must not close recycled physical");
    assertFalse(cReused.isClosed());

    PooledConnection pcConcurrent = pooledDataSource.getPooledConnection();
    try (Connection cConcurrent = pcConcurrent.getConnection()) {
      assertNotSame(pcReused, pcConcurrent);
      assertNotSame(physical1, cConcurrent.unwrap(BigQueryConnection.class));
    } finally {
      cReused.close();
      pcReused.close();
      pcConcurrent.close();
    }
  }

  @Test
  public void testCheckoutSkipsDirectlyReacquiredEntry_preservesActivePhysicalConnection()
      throws SQLException {
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(buildTestUrl(4L, 10L));

    PooledConnection pcInUse = pooledDataSource.getPooledConnection();
    BigQueryConnection physical1;
    try (Connection c1 = pcInUse.getConnection()) {
      physical1 = c1.unwrap(BigQueryConnection.class);
    }
    Connection directHandle = pcInUse.getConnection();

    PooledConnection pcNext = pooledDataSource.getPooledConnection();
    BigQueryConnection physical2;
    try (Connection cNext = pcNext.getConnection()) {
      physical2 = cNext.unwrap(BigQueryConnection.class);
      assertNotSame(physical1, physical2);
      assertTrue(pooledDataSource.getConnectionPoolManager().isConnectionPoolEmpty());
    } finally {
      pcNext.close();
    }

    assertTrue(physical2.isClosed());
    assertFalse(physical1.isClosed());
    assertFalse(directHandle.isClosed());
    directHandle.close();
    pcInUse.close();
  }

  @Test
  public void testCheckoutSkipsExternallyManagedEntry_preservesExternalPoolOwnership()
      throws SQLException {
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(buildTestUrl(4L, 10L));

    PooledConnection pcExternal = pooledDataSource.getPooledConnection();
    pcExternal.addConnectionEventListener(new TestConnectionListener());
    BigQueryConnection externalPhysical;
    try (Connection cExternal = pcExternal.getConnection()) {
      externalPhysical = cExternal.unwrap(BigQueryConnection.class);
    }

    PooledConnection pcNext = pooledDataSource.getPooledConnection();
    BigQueryConnection nextPhysical;
    try (Connection cNext = pcNext.getConnection()) {
      nextPhysical = cNext.unwrap(BigQueryConnection.class);
      assertNotSame(externalPhysical, nextPhysical);
    } finally {
      pcNext.close();
    }

    assertTrue(nextPhysical.isClosed());
    assertFalse(externalPhysical.isClosed());
    try (Connection cExternalReused = pcExternal.getConnection()) {
      assertSame(externalPhysical, cExternalReused.unwrap(BigQueryConnection.class));
    } finally {
      pcExternal.close();
    }
  }

  @Test
  public void testCheckoutAfterIdlePhysicalClose_createsFreshOpenPhysicalConnection()
      throws SQLException {
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(buildTestUrl(4L, 10L));

    PooledConnection pcClosed = pooledDataSource.getPooledConnection();
    BigQueryConnection closedPhysical;
    try (Connection cClosed = pcClosed.getConnection()) {
      closedPhysical = cClosed.unwrap(BigQueryConnection.class);
    }
    pcClosed.close();
    assertTrue(closedPhysical.isClosed());
    assertTrue(pooledDataSource.getConnectionPoolManager().isConnectionPoolEmpty());

    PooledConnection pcNext = pooledDataSource.getPooledConnection();
    try (Connection cNext = pcNext.getConnection()) {
      BigQueryConnection nextPhysical = cNext.unwrap(BigQueryConnection.class);
      assertNotSame(closedPhysical, nextPhysical);
      assertFalse(nextPhysical.isClosed());
    } finally {
      pcNext.close();
    }
  }

  @Test
  public void testConcurrentCheckoutsAndReturns_threadSafeAndBounded() throws Exception {
    final long poolSize = 4L;
    final int threadCount = 12;
    final int iterationsPerThread = 15;

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(buildTestUrl(poolSize, 10L));

    Set<BigQueryConnection> activePhysicalConnections = ConcurrentHashMap.newKeySet();
    Set<BigQueryConnection> allObservedPhysicalConnections = ConcurrentHashMap.newKeySet();
    Set<PooledConnection> observedPooledConnections = ConcurrentHashMap.newKeySet();
    CountDownLatch startLatch = new CountDownLatch(1);
    ExecutorService executor = Executors.newFixedThreadPool(threadCount);
    List<Future<?>> futures = new ArrayList<>();

    try {
      for (int i = 0; i < threadCount; i++) {
        futures.add(
            executor.submit(
                () -> {
                  startLatch.await();
                  for (int iter = 0; iter < iterationsPerThread; iter++) {
                    PooledConnection pc = pooledDataSource.getPooledConnection();
                    assertNotNull(pc);
                    observedPooledConnections.add(pc);
                    try (Connection conn = pc.getConnection()) {
                      BigQueryConnection physical = conn.unwrap(BigQueryConnection.class);
                      allObservedPhysicalConnections.add(physical);
                      assertTrue(
                          activePhysicalConnections.add(physical),
                          "Physical connection must not be shared across concurrent checkouts");
                      try {
                        conn.setClientInfo("worker", Thread.currentThread().getName());
                        LockSupport.parkNanos(TimeUnit.MICROSECONDS.toNanos(250));
                        assertEquals(
                            Thread.currentThread().getName(), conn.getClientInfo("worker"));
                      } finally {
                        activePhysicalConnections.remove(physical);
                      }
                    }
                  }
                  return null;
                }));
      }

      startLatch.countDown();
      for (Future<?> future : futures) {
        future.get(30, TimeUnit.SECONDS);
      }

      PooledConnectionListener poolManager = pooledDataSource.getConnectionPoolManager();
      assertNotNull(poolManager);
      int retainedIdle = poolManager.getConnectionPoolCurrentCapacity();
      assertTrue(retainedIdle <= (int) poolSize);
      long closedOverflowCount =
          allObservedPhysicalConnections.stream().filter(BigQueryConnection::isClosed).count();
      assertEquals(allObservedPhysicalConnections.size() - retainedIdle, closedOverflowCount);
    } finally {
      executor.shutdownNow();
      for (PooledConnection pc : observedPooledConnections) {
        pc.close();
      }
      while (pooledDataSource.getConnectionPoolManager() != null
          && !pooledDataSource.getConnectionPoolManager().isConnectionPoolEmpty()) {
        PooledConnection idle = pooledDataSource.getPooledConnection();
        idle.close();
      }
    }
  }

  @Test
  public void testExternalManagerEvictionSequenceAndSingleSlotListenerCapacity()
      throws SQLException {
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    // ListenerPoolSize=1 must remain available to an external pool manager (R16).
    pooledDataSource.setURL(buildTestUrl(4L, 1L));

    PooledConnection pcExternal = pooledDataSource.getPooledConnection();
    TestConnectionListener externalListener = new TestConnectionListener();
    pcExternal.addConnectionEventListener(externalListener);

    BigQueryConnection externalPhysical;
    try (Connection cExternal = pcExternal.getConnection()) {
      externalPhysical = cExternal.unwrap(BigQueryConnection.class);
    }
    assertEquals(1, externalListener.getConnectionClosedCount());
    assertTrue(
        pooledDataSource.getConnectionPoolManager().isConnectionPoolEmpty(),
        "Externally managed holder must not double-populate the internal idle pool");

    // External manager retirement sequence: removeConnectionEventListener(this) followed by close()
    // must never allow a concurrent getPooledConnection() to hijack externalPhysical (m-4).
    pcExternal.removeConnectionEventListener(externalListener);
    PooledConnection pcConcurrent = pooledDataSource.getPooledConnection();
    pcExternal.close();

    assertTrue(externalPhysical.isClosed());
    try (Connection cConcurrent = pcConcurrent.getConnection()) {
      BigQueryConnection concurrentPhysical = cConcurrent.unwrap(BigQueryConnection.class);
      assertNotSame(externalPhysical, concurrentPhysical);
      assertFalse(concurrentPhysical.isClosed());
    } finally {
      pcConcurrent.close();
    }
  }

  @Test
  public void testClaimPhysicalForReuse_rejectsInUseClosedAndRetiredHolders() throws SQLException {
    PooledConnectionListener poolManager = new PooledConnectionListener(4L);

    BigQueryConnection mockPhysical1 = mock(BigQueryConnection.class);
    doReturn(10L).when(mockPhysical1).getListenerPoolSize();
    BigQueryPooledConnection pcInUse = new BigQueryPooledConnection(mockPhysical1);
    pcInUse.registerInternalPoolListener(poolManager);
    Connection activeHandle = pcInUse.getConnection();

    assertNull(pcInUse.claimPhysicalForReuse(poolManager));
    assertTrue(pcInUse.inUse());
    activeHandle.close();

    assertSame(mockPhysical1, pcInUse.claimPhysicalForReuse(poolManager));
    assertNull(pcInUse.claimPhysicalForReuse(poolManager));

    BigQueryConnection mockPhysical2 = mock(BigQueryConnection.class);
    doReturn(10L).when(mockPhysical2).getListenerPoolSize();
    BigQueryPooledConnection pcClosed = new BigQueryPooledConnection(mockPhysical2);
    pcClosed.registerInternalPoolListener(poolManager);
    pcClosed.close();
    assertNull(pcClosed.claimPhysicalForReuse(poolManager));
  }

  @Test
  public void testStandalonePooledConnectionListenerOnDataSourceConnection_closesOverflowIdle()
      throws SQLException {
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(buildTestUrl(4L, 10L));
    PooledConnectionListener standaloneListener = new PooledConnectionListener(1L);

    PooledConnection pc1 = pooledDataSource.getPooledConnection();
    PooledConnection pc2 = pooledDataSource.getPooledConnection();
    pc1.addConnectionEventListener(standaloneListener);
    pc2.addConnectionEventListener(standaloneListener);

    try {
      BigQueryConnection physical1;
      BigQueryConnection physical2;
      Connection c1 = pc1.getConnection();
      Connection c2 = pc2.getConnection();
      physical1 = c1.unwrap(BigQueryConnection.class);
      physical2 = c2.unwrap(BigQueryConnection.class);

      c1.close();
      assertEquals(1, standaloneListener.getConnectionPoolCurrentCapacity());
      assertTrue(pooledDataSource.getConnectionPoolManager().isConnectionPoolEmpty());
      assertFalse(physical1.isClosed());

      // Returning pc2 when standaloneListener is at capacity (1) must close physical2 (R1-5).
      c2.close();
      assertEquals(1, standaloneListener.getConnectionPoolCurrentCapacity());
      assertTrue(physical2.isClosed());
      assertFalse(physical1.isClosed());
    } finally {
      pc1.close();
      pc2.close();
    }
  }
}
