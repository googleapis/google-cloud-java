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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.jdbc.PooledConnectionDataSource;
import com.google.cloud.bigquery.jdbc.PooledConnectionListener;
import com.google.cloud.bigquery.jdbc.utils.TestUtilities.TestConnectionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.sql.PooledConnection;
import org.junit.jupiter.api.Test;

public class ITConnectionPoolingTest extends ITBase {
  static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final Long DEFAULT_CONN_POOL_SIZE = 10L;
  private static final Long CUSTOM_CONN_POOL_SIZE = 5L;

  @Test
  public void testPooledConnectionDataSourceSuccess() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
  }

  @Test
  public void testPooledConnectionDataSourceFailNoConnectionURl() {
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();

    assertThrows(BigQueryJdbcException.class, () -> pooledDataSource.getPooledConnection());
  }

  @Test
  public void testPooledConnectionDataSourceFailInvalidConnectionURl() {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "ListenerPoolSize=invalid";
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    assertThrows(NumberFormatException.class, () -> pooledDataSource.getPooledConnection());
  }

  @Test
  public void testPooledConnectionAddConnectionListener() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listener);
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());
  }

  @Test
  public void testPooledConnectionRemoveConnectionListener() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.removeConnectionEventListener(listener);
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());
  }

  @Test
  public void testPooledConnectionConnectionClosed() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
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
  }

  @Test
  public void testPooledConnectionClose() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listener);
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());

    pooledConnection.close();
    assertEquals(1, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());
  }

  @Test
  public void testPooledConnectionConnectionError() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listener);
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());

    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());

    ExecutorService executor = Executors.newFixedThreadPool(3);
    connection.abort(executor);
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(1, listener.getConnectionErrorCount());

    executor.shutdown();
    connection.close();
    pooledConnection.close();
  }

  @Test
  public void testPooledConnectionListenerAddListener() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

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
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

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
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

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
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionUrl);

    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    PooledConnectionListener listener = new PooledConnectionListener(DEFAULT_CONN_POOL_SIZE);
    pooledConnection.addConnectionEventListener(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    pooledConnection.close();
    assertFalse(listener.isConnectionPoolEmpty());
  }

  @Test
  public void testPooledConnectionListenerConnectionError() throws SQLException {
    String connectionUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;ConnectionPoolSize=20;ListenerPoolSize=20;";

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

    ExecutorService executor = Executors.newFixedThreadPool(3);
    connection.abort(executor);
    assertTrue(listener.isConnectionPoolEmpty());

    executor.shutdown();
    connection.close();
    pooledConnection.close();
  }

  @Test
  public void testExecuteQueryWithConnectionPoolingEnabledDefaultPoolSize() throws SQLException {
    String connectionURL =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;ProjectId="
            + PROJECT_ID
            + ";";
    assertConnectionPoolingResults(connectionURL, DEFAULT_CONN_POOL_SIZE);
  }

  @Test
  public void testExecuteQueryWithConnectionPoolingEnabledCustomPoolSize() throws SQLException {
    String connectionURL =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=3;ProjectId="
            + PROJECT_ID
            + ";"
            + "ConnectionPoolSize="
            + CUSTOM_CONN_POOL_SIZE
            + ";";
    assertConnectionPoolingResults(connectionURL, CUSTOM_CONN_POOL_SIZE);
  }

  private void assertConnectionPoolingResults(String connectionURL, Long connectionPoolSize)
      throws SQLException {
    // Create Pooled Connection Datasource
    PooledConnectionDataSource pooledDataSource = new PooledConnectionDataSource();
    pooledDataSource.setURL(connectionURL);

    // Get pooled connection and ensure listner was added with default connection pool size.
    PooledConnection pooledConnection = pooledDataSource.getPooledConnection();
    assertNotNull(pooledConnection);
    PooledConnectionListener listener = pooledDataSource.getConnectionPoolManager();
    assertNotNull(listener);
    assertTrue(listener.isConnectionPoolEmpty());

    // Get Underlying physical connection
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());

    // Execute query with physical connection
    String query =
        "SELECT DISTINCT repository_name FROM `bigquery-public-data.samples.github_timeline` LIMIT"
            + " 850";
    Statement statement = connection.createStatement();
    ResultSet jsonResultSet = statement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));

    // Close physical connection
    connection.close();
    assertFalse(listener.isConnectionPoolEmpty());
    assertEquals(1, listener.getConnectionPoolCurrentCapacity());
    assertEquals(connectionPoolSize, listener.getConnectionPoolSize());

    // Reuse same physical connection.
    connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertFalse(listener.isConnectionPoolEmpty());
    assertEquals(1, listener.getConnectionPoolCurrentCapacity());
    assertEquals(connectionPoolSize, listener.getConnectionPoolSize());

    // Execute query with reusable physical connection
    jsonResultSet = statement.executeQuery(query);
    assertTrue(jsonResultSet.getClass().getName().contains("BigQueryJsonResultSet"));

    // Return connection back to the pool.
    connection.close();
    assertFalse(listener.isConnectionPoolEmpty());
    assertEquals(1, listener.getConnectionPoolCurrentCapacity());
    assertEquals(connectionPoolSize, listener.getConnectionPoolSize());
    pooledConnection.close();
    jsonResultSet.close();
    statement.close();
    connection.close();
  }
}
