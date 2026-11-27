/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.jdbc.BigQueryConnection;
import com.google.cloud.bigquery.jdbc.PooledConnectionDataSource;
import com.google.cloud.bigquery.jdbc.PooledConnectionListener;
import com.google.cloud.bigquery.jdbc.utils.TestUtilities.TestConnectionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.sql.PooledConnection;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ITConnectionPoolingTest extends ITBase {
  static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final Long DEFAULT_CONN_POOL_SIZE = 10L;
  private static final Long CUSTOM_CONN_POOL_SIZE = 5L;

  @Test
  public void testPooledConnectionDataSourceSuccess() throws SQLException {
    String connectionUrl = ITBase.connectionUrl + "ConnectionPoolSize=20;" + "ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    pooledConnection.close();
  }

  @Test
  public void testPooledConnectionDataSourceFailNoConnectionURl() {
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();

    assertThrows(BigQueryJdbcException.class, () -> pooledDataSource.getPooledConnection());
  }

  @Test
  public void testPooledConnectionDataSourceFailInvalidConnectionURl() {
    String connectionUrl = ITBase.connectionUrl + "ListenerPoolSize=invalid;";
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    assertThrows(BigQueryJdbcException.class, () -> pooledDataSource.getPooledConnection());
  }

  @Test
  public void testPooledConnectionAddConnectionListener() throws SQLException {
    String connectionUrl = ITBase.connectionUrl + "ConnectionPoolSize=20;" + "ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    try {
      assertNotNull(pooledConnection);
      TestConnectionListener listener = new TestConnectionListener();
      pooledConnection.addConnectionEventListener(listener);
      assertEquals(0, listener.getConnectionClosedCount());
      assertEquals(0, listener.getConnectionErrorCount());
    } finally {
      pooledConnection.close();
    }
  }

  @Test
  public void testPooledConnectionRemoveConnectionListener() throws SQLException {
    String connectionUrl = ITBase.connectionUrl + "ConnectionPoolSize=20;" + "ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    try {
      assertNotNull(pooledConnection);
      TestConnectionListener listener = new TestConnectionListener();
      pooledConnection.removeConnectionEventListener(listener);
      assertEquals(0, listener.getConnectionClosedCount());
      assertEquals(0, listener.getConnectionErrorCount());
    } finally {
      pooledConnection.close();
    }
  }

  @Test
  public void testPooledConnectionConnectionClosed() throws SQLException {
    String connectionUrl = ITBase.connectionUrl + "ConnectionPoolSize=20;" + "ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    try {
      assertNotNull(pooledConnection);
      TestConnectionListener listener = new TestConnectionListener();
      pooledConnection.addConnectionEventListener(listener);
      assertEquals(0, listener.getConnectionClosedCount());
      assertEquals(0, listener.getConnectionErrorCount());

      Connection connection = pooledConnection.getConnection();
      assertNotNull(connection);
      assertFalse(connection.isClosed());

      connection.close();
      assertEquals(1, listener.getConnectionClosedCount());
      assertEquals(0, listener.getConnectionErrorCount());
    } finally {
      pooledConnection.close();
    }
  }

  @Test
  public void testPooledConnectionClose() throws SQLException {
    String connectionUrl = ITBase.connectionUrl + "ConnectionPoolSize=20;" + "ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listener);
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());

    pooledConnection.close();
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());
  }

  @Test
  public void testPooledConnectionConnectionError() throws Exception {
    String connectionUrl = ITBase.connectionUrl + "ConnectionPoolSize=20;" + "ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    ExecutorService executor = Executors.newFixedThreadPool(3);
    try {
      assertNotNull(pooledConnection);
      TestConnectionListener listener = new TestConnectionListener();
      pooledConnection.addConnectionEventListener(listener);
      assertEquals(0, listener.getConnectionClosedCount());
      assertEquals(0, listener.getConnectionErrorCount());

      Connection connection = pooledConnection.getConnection();
      assertNotNull(connection);
      assertFalse(connection.isClosed());

      connection.abort(executor);
      assertEquals(0, listener.getConnectionClosedCount());
      assertEquals(1, listener.getConnectionErrorCount());
      connection.close();
    } finally {
      executor.shutdown();
      assertTrue(executor.awaitTermination(30, TimeUnit.SECONDS));
      pooledConnection.close();
    }
  }

  @Test
  public void testPooledConnectionListenerAddListener() throws SQLException {
    String connectionUrl = ITBase.connectionUrl + "ConnectionPoolSize=20;" + "ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    PooledConnectionListener listener = new PooledConnectionListener(DEFAULT_CONN_POOL_SIZE);
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());
    pooledConnection.close();
  }

  @Test
  public void testPooledConnectionListenerRemoveListener() throws SQLException {
    String connectionUrl = ITBase.connectionUrl + "ConnectionPoolSize=20;" + "ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    PooledConnectionListener listener = new PooledConnectionListener(DEFAULT_CONN_POOL_SIZE);
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    pooledConnection.removeConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());
    pooledConnection.close();
  }

  @Test
  public void testPooledConnectionListenerCloseConnection() throws SQLException {
    String connectionUrl = ITBase.connectionUrl + "ConnectionPoolSize=20;" + "ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    PooledConnectionListener listener = new PooledConnectionListener(DEFAULT_CONN_POOL_SIZE);
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());

    connection.close();
    assertFalse(listener.isConnectionPoolEmpty());
    pooledConnection.close();
  }

  @Test
  public void testPooledConnectionListenerClosePooledConnection() throws SQLException {
    String connectionUrl = ITBase.connectionUrl + "ConnectionPoolSize=20;" + "ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    PooledConnectionListener listener = new PooledConnectionListener(DEFAULT_CONN_POOL_SIZE);
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    pooledConnection.close();
    assertTrue(listener.isConnectionPoolEmpty());
  }

  @Test
  public void testPooledConnectionListenerConnectionError() throws Exception {
    String connectionUrl = ITBase.connectionUrl + "ConnectionPoolSize=20;" + "ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    ExecutorService executor = Executors.newFixedThreadPool(3);
    try {
      assertNotNull(pooledConnection);
      PooledConnectionListener listener = new PooledConnectionListener(DEFAULT_CONN_POOL_SIZE);
      pooledConnection.addConnectionEventListener(listener);
      assertTrue(listener.isConnectionPoolEmpty());

      Connection connection = pooledConnection.getConnection();
      assertNotNull(connection);
      assertFalse(connection.isClosed());

      connection.abort(executor);
      assertTrue(listener.isConnectionPoolEmpty());
      connection.close();
    } finally {
      executor.shutdown();
      assertTrue(executor.awaitTermination(30, TimeUnit.SECONDS));
      pooledConnection.close();
    }
  }

  @Test
  @Tag("disable_universe_domain")
  public void testExecuteQueryWithConnectionPoolingEnabledDefaultPoolSize() throws SQLException {
    String connectionURL = ITBase.connectionUrl;

    assertConnectionPoolingResults(connectionURL, DEFAULT_CONN_POOL_SIZE);
  }

  @Test
  @Tag("disable_universe_domain")
  public void testExecuteQueryWithConnectionPoolingEnabledCustomPoolSize() throws SQLException {
    String connectionURL =
        ITBase.connectionUrl + "ConnectionPoolSize=" + CUSTOM_CONN_POOL_SIZE + ";";
    assertConnectionPoolingResults(connectionURL, CUSTOM_CONN_POOL_SIZE);
  }

  @Test
  @Tag("disable_universe_domain")
  public void testConcurrentCheckoutsExecuteQueriesIndependently() throws SQLException {
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(ITBase.connectionUrl + "ConnectionPoolSize=4;");

    PooledConnection pc1 = null;
    PooledConnection pc2 = null;
    try {
      pc1 = pooledDataSource.getPooledConnection();
      pc2 = pooledDataSource.getPooledConnection();
      Connection conn1 = pc1.getConnection();
      Connection conn2 = pc2.getConnection();
      assertNotSame(conn1.unwrap(BigQueryConnection.class), conn2.unwrap(BigQueryConnection.class));

      // Keep stmt2 open across conn1.close() so any shared-physical statement reset would fail.
      try (Statement stmt2 = conn2.createStatement()) {
        try (Statement stmt1 = conn1.createStatement()) {
          ITBase.validateStatement(stmt1, 10);
          ITBase.validateStatement(stmt2, 20);
        }

        conn1.close();
        assertTrue(conn1.isClosed());
        assertThrows(SQLException.class, conn1::createStatement);

        assertFalse(conn2.isClosed());
        assertFalse(stmt2.isClosed());
        ITBase.validateStatement(stmt2, 15);
      }
      conn2.close();
    } finally {
      try {
        if (pc1 != null) {
          pc1.close();
        }
      } finally {
        if (pc2 != null) {
          pc2.close();
        }
      }
    }
  }

  @Test
  @Tag("disable_universe_domain")
  public void testSessionAndUncommittedTransactionResetOnReturn() throws Exception {
    String dataset = ITBase.getSharedDataset();
    String tableName = "pooled_tx_reset_" + UUID.randomUUID().toString().replace("-", "_");
    String qualifiedTable = String.format("`%s.%s.%s`", PROJECT_ID, dataset, tableName);

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(ITBase.connectionUrl + "EnableSession=1;ConnectionPoolSize=2;");

    PooledConnection pc1 = null;
    PooledConnection pc2 = null;
    try {
      ITBase.bigQuery.query(
          QueryJobConfiguration.of("CREATE TABLE " + qualifiedTable + " (id INT64)"));

      pc1 = pooledDataSource.getPooledConnection();
      Connection conn1 = pc1.getConnection();
      BigQueryConnection firstPhysical = conn1.unwrap(BigQueryConnection.class);
      Statement leakedStmt = conn1.createStatement();
      leakedStmt.execute("CREATE TEMP TABLE pooled_session_temp (id INT64) AS SELECT 42 AS id");

      conn1.setAutoCommit(false);
      leakedStmt.executeUpdate("INSERT INTO " + qualifiedTable + " (id) VALUES (1)");
      conn1.setClientInfo("CLIENTUSER", "first_borrower");

      // Logical close without commit/rollback must close open statements, roll back the active
      // transaction, abort the driver-created session, and reset mutable connection properties.
      conn1.close();
      assertTrue(leakedStmt.isClosed());
      assertThrows(SQLException.class, () -> leakedStmt.executeQuery("SELECT 1"));
      assertThrows(SQLException.class, conn1::createStatement);

      pc2 = pooledDataSource.getPooledConnection();
      try (Connection conn2 = pc2.getConnection();
          Statement stmt2 = conn2.createStatement()) {
        assertSame(firstPhysical, conn2.unwrap(BigQueryConnection.class));
        assertTrue(conn2.getAutoCommit());
        assertNull(conn2.getClientInfo("CLIENTUSER"));

        try (ResultSet rs = stmt2.executeQuery("SELECT COUNT(*) FROM " + qualifiedTable)) {
          assertTrue(rs.next());
          assertEquals(0, rs.getInt(1));
        }
        assertThrows(
            SQLException.class, () -> stmt2.executeQuery("SELECT * FROM pooled_session_temp"));
      }
    } finally {
      try {
        if (pc2 != null) {
          pc2.close();
        }
      } finally {
        try {
          if (pc1 != null) {
            pc1.close();
          }
        } finally {
          ITBase.bigQuery.query(QueryJobConfiguration.of("DROP TABLE IF EXISTS " + qualifiedTable));
        }
      }
    }
  }

  private void assertConnectionPoolingResults(String connectionURL, Long connectionPoolSize)
      throws SQLException {
    // Create Pooled Connection Datasource
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionURL);

    // Get pooled connection and ensure listener was added with expected connection pool size.
    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    try {
      PooledConnectionListener listener = pooledDataSource.getConnectionPoolManager();
      assertNotNull(listener);
      assertTrue(listener.isConnectionPoolEmpty());

      // Get logical connection handle
      Connection connection = pooledConnection.getConnection();
      assertNotNull(connection);
      assertFalse(connection.isClosed());

      // Execute query with logical connection
      try (Statement statement = connection.createStatement()) {
        ITBase.validateStatement(statement, 850);
      }

      // Close logical connection to return PooledConnection to the pool
      connection.close();
      assertFalse(listener.isConnectionPoolEmpty());
      assertEquals(1, listener.getConnectionPoolCurrentCapacity());
      assertEquals(connectionPoolSize, listener.getConnectionPoolSize());

      // Check out the pooled connection from the DataSource and execute a query on a new Statement.
      pooledConnection = pooledDataSource.getPooledConnection();
      assertTrue(listener.isConnectionPoolEmpty());
      assertEquals(0, listener.getConnectionPoolCurrentCapacity());
      connection = pooledConnection.getConnection();
      assertNotNull(connection);
      assertFalse(connection.isClosed());

      try (Statement statement = connection.createStatement()) {
        ITBase.validateStatement(statement, 850);
      }

      // Return connection back to the pool, then physically close.
      connection.close();
      assertFalse(listener.isConnectionPoolEmpty());
      assertEquals(1, listener.getConnectionPoolCurrentCapacity());
      assertEquals(connectionPoolSize, listener.getConnectionPoolSize());
      pooledConnection.close();
      assertTrue(listener.isConnectionPoolEmpty());
    } finally {
      pooledConnection.close();
    }
  }
}
