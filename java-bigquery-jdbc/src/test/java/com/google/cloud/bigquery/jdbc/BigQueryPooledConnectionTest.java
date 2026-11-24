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

import static com.google.cloud.bigquery.jdbc.utils.TestUtilities.TestConnectionListener;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics.StatementType;
import com.google.cloud.bigquery.JobStatistics.SessionInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import com.google.cloud.bigquery.jdbc.telemetry.v1.DriverFeature;
import com.google.cloud.bigquery.jdbc.telemetry.v1.TelemetryManager;
import com.google.cloud.bigquery.jdbc.utils.URIBuilder;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.sql.CallableStatement;
import java.sql.ClientInfoStatus;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.MockedStatic;

public class BigQueryPooledConnectionTest {
  private BigQueryConnection bigQueryConnection;
  private static final Long LISTENER_POOL_SIZE = 10L;
  private static final Long CONNECTION_POOL_SIZE = 10L;

  private static URIBuilder sessionUri() {
    return BigQueryJdbcBaseTest.getUriOAuthToken()
        .append("ProjectId", "test-project")
        .append("EnableSession", 1);
  }

  @BeforeEach
  public void setUp() throws IOException, SQLException {
    bigQueryConnection = mock(BigQueryConnection.class);
    doReturn(LISTENER_POOL_SIZE).when(bigQueryConnection).getListenerPoolSize();
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
    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listener);

    assertTrue(pooledConnection.isListenerPooled(listener));
  }

  @Test
  public void testRemoveConnectionListener() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listener);
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());

    assertTrue(pooledConnection.isListenerPooled(listener));
    pooledConnection.removeConnectionEventListener(listener);
    assertFalse(pooledConnection.isListenerPooled(listener));
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

    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listener);
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());

    connection.close();
    assertFalse(pooledConnection.inUse());
    assertEquals(1, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());
    assertTrue(pooledConnection.isListenerPooled(listener));

    // Repeated close on the logical handle is a no-op and must not fire duplicate events.
    connection.close();
    assertEquals(1, listener.getConnectionClosedCount());
  }

  @Test
  public void testPhysicalClose_closesUnderlyingConnectionWithoutFiringClosedEvent()
      throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    assertEquals(LISTENER_POOL_SIZE, pooledConnection.getListenerPoolSize());
    assertFalse(pooledConnection.inUse());
    Connection connection = pooledConnection.getConnection();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    assertTrue(pooledConnection.inUse());

    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listener);

    pooledConnection.close();
    assertFalse(pooledConnection.inUse());
    assertTrue(connection.isClosed());
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());
    assertFalse(pooledConnection.isListenerPooled(listener));
    verify(bigQueryConnection, times(1)).close();

    // Idempotent physical close and post-close checkout rejection.
    pooledConnection.close();
    verify(bigQueryConnection, times(1)).close();
    assertThrows(BigQueryJdbcException.class, pooledConnection::getConnection);
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

    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listener);
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(0, listener.getConnectionErrorCount());

    pooledConnection.fireConnectionError(new SQLException("test"));
    assertFalse(pooledConnection.inUse());
    assertTrue(connection.isClosed());
    assertEquals(0, listener.getConnectionClosedCount());
    assertEquals(1, listener.getConnectionErrorCount());
    assertFalse(pooledConnection.isListenerPooled(listener));
    verify(bigQueryConnection).close();
    assertThrows(BigQueryJdbcException.class, pooledConnection::getConnection);
  }

  @Test
  public void testPooledGetMetaData_delegatesWithoutRecordingTelemetry() throws SQLException {
    // The physical BigQueryConnection records DRIVER_FEATURE_METADATA_RETRIEVAL; the pooled
    // wrapper must only delegate, otherwise every pooled call is counted twice.
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    try (MockedStatic<TelemetryManager> telemetry = mockStatic(TelemetryManager.class)) {
      pooledConnection.getConnection().getMetaData();
      verify(bigQueryConnection).getMetaData();
      telemetry.verify(
          () ->
              TelemetryManager.recordFeatureUsage(DriverFeature.DRIVER_FEATURE_METADATA_RETRIEVAL),
          never());
    }
  }

  @Test
  public void testLogicalClose_rollsBackActiveTransactionWithoutStartingNewOne() throws Exception {
    try (BigQueryConnection realConn = new BigQueryConnection(sessionUri().toString())) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      realConn.bigQuery = mockBigQuery;

      SessionInfo sessionInfo = mock(SessionInfo.class);
      when(sessionInfo.getSessionId()).thenReturn("driver_tx_session");
      TableResult beginResult = mock(TableResult.class);
      when(beginResult.getSessionInfo()).thenReturn(sessionInfo);
      when(mockBigQuery.query(any(QueryJobConfiguration.class))).thenReturn(beginResult);

      Job rollbackJob = mock(Job.class);
      when(mockBigQuery.create(any(JobInfo.class))).thenReturn(rollbackJob);
      when(rollbackJob.waitFor()).thenReturn(rollbackJob);

      BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(realConn);
      Connection handle = pooledConnection.getConnection();
      handle.setAutoCommit(false);
      assertTrue(realConn.isTransactionStarted());
      assertFalse(realConn.getAutoCommit());

      handle.close();

      assertFalse(realConn.isTransactionStarted());
      assertTrue(realConn.getAutoCommit());
      assertNull(realConn.getSessionInfoConnectionProperty());

      ArgumentCaptor<JobInfo> jobCaptor = ArgumentCaptor.forClass(JobInfo.class);
      verify(mockBigQuery, times(1)).create(jobCaptor.capture());
      QueryJobConfiguration rollbackConfig = jobCaptor.getValue().getConfiguration();
      assertEquals("ROLLBACK TRANSACTION;", rollbackConfig.getQuery());

      ArgumentCaptor<QueryJobConfiguration> queryCaptor =
          ArgumentCaptor.forClass(QueryJobConfiguration.class);
      verify(mockBigQuery, atLeastOnce()).query(queryCaptor.capture());
      List<QueryJobConfiguration> executedQueries = queryCaptor.getAllValues();
      long beginCount =
          executedQueries.stream()
              .filter(cfg -> "BEGIN TRANSACTION;".equals(cfg.getQuery()))
              .count();
      assertEquals(1L, beginCount, "Rollback on logical close must not start a second transaction");
      assertTrue(
          executedQueries.stream()
              .anyMatch(cfg -> "CALL BQ.ABORT_SESSION();".equals(cfg.getQuery())));
      assertFalse(
          executedQueries.stream().anyMatch(cfg -> "COMMIT TRANSACTION;".equals(cfg.getQuery())));
    }
  }

  @Test
  public void testLogicalClose_abortsDriverCreatedSessionAndPreservesQueryProperties()
      throws Exception {
    String url = sessionUri().append("QueryProperties", "time_zone=America/Los_Angeles").toString();
    try (BigQueryConnection realConn = new BigQueryConnection(url)) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      realConn.bigQuery = mockBigQuery;
      when(mockBigQuery.query(any(QueryJobConfiguration.class)))
          .thenReturn(mock(TableResult.class));

      BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(realConn);
      Connection handle = pooledConnection.getConnection();

      // Simulate a non-transactional query establishing a driver-managed session.
      realConn.markSessionCreatedByDriver();
      realConn.initSessionInfo("driver_query_session_1");
      assertEquals(
          "driver_query_session_1", realConn.getSessionInfoConnectionProperty().getValue());
      assertTrue(realConn.isSessionCreatedByDriver());

      handle.close();

      assertNull(realConn.getSessionInfoConnectionProperty());
      assertFalse(realConn.isSessionCreatedByDriver());
      assertTrue(
          realConn.getQueryProperties().stream()
              .anyMatch(
                  cp ->
                      "time_zone".equals(cp.getKey())
                          && "America/Los_Angeles".equals(cp.getValue())));
      assertFalse(
          realConn.getQueryProperties().stream()
              .anyMatch(cp -> "session_id".equalsIgnoreCase(cp.getKey())));

      ArgumentCaptor<QueryJobConfiguration> queryCaptor =
          ArgumentCaptor.forClass(QueryJobConfiguration.class);
      verify(mockBigQuery).query(queryCaptor.capture());
      assertEquals("CALL BQ.ABORT_SESSION();", queryCaptor.getValue().getQuery());
    }
  }

  @Test
  public void testLogicalClose_preservesUserConfiguredSessionIdWhileRollingBackTransaction()
      throws Exception {
    String url =
        sessionUri().append("QueryProperties", "session_id=caller_owned_session_77").toString();
    try (BigQueryConnection realConn = new BigQueryConnection(url)) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      realConn.bigQuery = mockBigQuery;

      SessionInfo sessionInfo = mock(SessionInfo.class);
      when(sessionInfo.getSessionId()).thenReturn("caller_owned_session_77");
      TableResult beginResult = mock(TableResult.class);
      when(beginResult.getSessionInfo()).thenReturn(sessionInfo);
      when(mockBigQuery.query(any(QueryJobConfiguration.class))).thenReturn(beginResult);

      Job rollbackJob = mock(Job.class);
      when(mockBigQuery.create(any(JobInfo.class))).thenReturn(rollbackJob);
      when(rollbackJob.waitFor()).thenReturn(rollbackJob);

      BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(realConn);
      Connection handle = pooledConnection.getConnection();
      handle.setAutoCommit(false);

      handle.close();

      assertFalse(realConn.isTransactionStarted());
      assertTrue(realConn.getAutoCommit());
      assertFalse(realConn.isSessionCreatedByDriver());
      assertNotNull(realConn.getSessionInfoConnectionProperty());
      assertEquals(
          "caller_owned_session_77", realConn.getSessionInfoConnectionProperty().getValue());

      ArgumentCaptor<QueryJobConfiguration> queryCaptor =
          ArgumentCaptor.forClass(QueryJobConfiguration.class);
      verify(mockBigQuery, atLeastOnce()).query(queryCaptor.capture());
      assertFalse(
          queryCaptor.getAllValues().stream()
              .anyMatch(cfg -> "CALL BQ.ABORT_SESSION();".equals(cfg.getQuery())));
    }
  }

  @Test
  public void testLogicalClose_resetsClientInfoWarningsHoldabilityAndClosesOpenStatements()
      throws Exception {
    String url =
        BigQueryJdbcBaseTest.getUriOAuthToken().append("ProjectId", "test-project").toString();
    try (BigQueryConnection realConn = new BigQueryConnection(url)) {
      int defaultHoldability = realConn.getHoldability();
      BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(realConn);
      Connection handle = pooledConnection.getConnection();

      Statement stmt = handle.createStatement();
      PreparedStatement pstmt = handle.prepareStatement("SELECT 1");
      CallableStatement cstmt = handle.prepareCall("{call test_proc()}");
      assertTrue(Proxy.isProxyClass(stmt.getClass()));
      assertTrue(Proxy.isProxyClass(handle.getMetaData().getClass()));

      handle.setClientInfo("ApplicationName", "BillingReport");
      realConn.sqlWarnings.add(new SQLWarning("sample warning"));
      realConn.holdability = ResultSet.HOLD_CURSORS_OVER_COMMIT;

      assertFalse(stmt.isClosed());
      assertFalse(pstmt.isClosed());
      assertFalse(cstmt.isClosed());
      assertEquals(3, realConn.openStatements.size());

      handle.close();

      assertTrue(stmt.isClosed());
      assertTrue(pstmt.isClosed());
      assertTrue(cstmt.isClosed());
      assertTrue(realConn.openStatements.isEmpty());
      assertThrows(SQLException.class, () -> stmt.executeQuery("SELECT 1"));
      assertTrue(realConn.getClientInfo().isEmpty());
      assertNull(realConn.getWarnings());
      assertEquals(defaultHoldability, realConn.getHoldability());
    }
  }

  @Test
  public void testClosedWrapper_rejectsSubsequentOperations() throws SQLException {
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    Connection handle = pooledConnection.getConnection();
    assertTrue(handle.isWrapperFor(Connection.class));
    assertFalse(handle.isWrapperFor(null));
    assertSame(handle, handle.unwrap(Connection.class));
    assertThrows(BigQueryJdbcException.class, () -> handle.unwrap(null));

    handle.close();

    assertTrue(handle.isClosed());
    assertFalse(handle.isValid(5));
    assertThrows(BigQueryJdbcException.class, () -> handle.isValid(-1));
    assertFalse(handle.isWrapperFor(BigQueryConnection.class));

    Properties props = new Properties();
    props.setProperty("ApplicationName", "TestSuite");
    Savepoint savepoint = mock(Savepoint.class);
    Executor executor = Runnable::run;

    assertThrows(BigQueryJdbcException.class, handle::createStatement);
    assertThrows(
        BigQueryJdbcException.class,
        () -> handle.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY));
    assertThrows(
        BigQueryJdbcException.class,
        () ->
            handle.createStatement(
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT));
    assertThrows(BigQueryJdbcException.class, () -> handle.prepareStatement("SELECT 1"));
    assertThrows(
        BigQueryJdbcException.class,
        () ->
            handle.prepareStatement(
                "SELECT 1", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY));
    assertThrows(
        BigQueryJdbcException.class,
        () ->
            handle.prepareStatement(
                "SELECT 1",
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT));
    assertThrows(
        BigQueryJdbcException.class,
        () -> handle.prepareStatement("SELECT 1", Statement.NO_GENERATED_KEYS));
    assertThrows(
        BigQueryJdbcException.class, () -> handle.prepareStatement("SELECT 1", new int[] {1}));
    assertThrows(
        BigQueryJdbcException.class,
        () -> handle.prepareStatement("SELECT 1", new String[] {"col"}));
    assertThrows(BigQueryJdbcException.class, () -> handle.prepareCall("{call p()}"));
    assertThrows(
        BigQueryJdbcException.class,
        () ->
            handle.prepareCall(
                "{call p()}", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY));
    assertThrows(
        BigQueryJdbcException.class,
        () ->
            handle.prepareCall(
                "{call p()}",
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT));
    assertThrows(BigQueryJdbcException.class, () -> handle.nativeSQL("SELECT 1"));
    assertThrows(BigQueryJdbcException.class, () -> handle.setAutoCommit(false));
    assertThrows(BigQueryJdbcException.class, handle::getAutoCommit);
    assertThrows(BigQueryJdbcException.class, handle::commit);
    assertThrows(BigQueryJdbcException.class, handle::rollback);
    assertThrows(BigQueryJdbcException.class, () -> handle.rollback(savepoint));
    assertThrows(BigQueryJdbcException.class, handle::getMetaData);
    assertThrows(BigQueryJdbcException.class, () -> handle.setReadOnly(true));
    assertThrows(BigQueryJdbcException.class, handle::isReadOnly);
    assertThrows(BigQueryJdbcException.class, () -> handle.setCatalog("cat"));
    assertThrows(BigQueryJdbcException.class, handle::getCatalog);
    assertThrows(
        BigQueryJdbcException.class,
        () -> handle.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE));
    assertThrows(BigQueryJdbcException.class, handle::getTransactionIsolation);
    assertThrows(BigQueryJdbcException.class, handle::getWarnings);
    assertThrows(BigQueryJdbcException.class, handle::clearWarnings);
    assertThrows(BigQueryJdbcException.class, handle::getTypeMap);
    assertThrows(BigQueryJdbcException.class, () -> handle.setTypeMap(Collections.emptyMap()));
    assertThrows(
        BigQueryJdbcException.class,
        () -> handle.setHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT));
    assertThrows(BigQueryJdbcException.class, handle::getHoldability);
    assertThrows(BigQueryJdbcException.class, handle::setSavepoint);
    assertThrows(BigQueryJdbcException.class, () -> handle.setSavepoint("sp"));
    assertThrows(BigQueryJdbcException.class, () -> handle.releaseSavepoint(savepoint));
    assertThrows(BigQueryJdbcException.class, handle::createClob);
    assertThrows(BigQueryJdbcException.class, handle::createBlob);
    assertThrows(BigQueryJdbcException.class, handle::createNClob);
    assertThrows(BigQueryJdbcException.class, handle::createSQLXML);
    SQLClientInfoException singleClientInfoEx =
        assertThrows(SQLClientInfoException.class, () -> handle.setClientInfo("k", "v"));
    assertEquals(
        ClientInfoStatus.REASON_UNKNOWN, singleClientInfoEx.getFailedProperties().get("k"));
    SQLClientInfoException bulkClientInfoEx =
        assertThrows(SQLClientInfoException.class, () -> handle.setClientInfo(props));
    assertEquals(
        ClientInfoStatus.REASON_UNKNOWN,
        bulkClientInfoEx.getFailedProperties().get("ApplicationName"));
    assertThrows(BigQueryJdbcException.class, () -> handle.getClientInfo("k"));
    assertThrows(BigQueryJdbcException.class, handle::getClientInfo);
    assertThrows(BigQueryJdbcException.class, () -> handle.createArrayOf("STRING", new Object[0]));
    assertThrows(BigQueryJdbcException.class, () -> handle.createStruct("STRUCT", new Object[0]));
    assertThrows(BigQueryJdbcException.class, () -> handle.unwrap(BigQueryConnection.class));
    assertThrows(BigQueryJdbcException.class, () -> handle.setSchema("ds"));
    assertThrows(BigQueryJdbcException.class, handle::getSchema);
    assertThrows(BigQueryJdbcException.class, () -> handle.setNetworkTimeout(executor, 100));
    assertThrows(BigQueryJdbcException.class, handle::getNetworkTimeout);

    verify(bigQueryConnection, never()).createStatement();
    verify(bigQueryConnection, never()).commit();
    verify(bigQueryConnection, never()).isValid(5);
  }

  @Test
  public void testGetConnectionWhileInUse_invalidatesPreviousWrapperAndResetsState()
      throws Exception {
    String url =
        BigQueryJdbcBaseTest.getUriOAuthToken().append("ProjectId", "test-project").toString();
    try (BigQueryConnection realConn = new BigQueryConnection(url)) {
      BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(realConn);
      TestConnectionListener listener = new TestConnectionListener();
      pooledConnection.addConnectionEventListener(listener);

      Connection firstHandle = pooledConnection.getConnection();
      Statement firstStmt = firstHandle.createStatement();
      firstHandle.setClientInfo("ApplicationName", "FirstCaller");

      Connection secondHandle = pooledConnection.getConnection();
      assertTrue(firstHandle.isClosed());
      assertTrue(firstStmt.isClosed());
      assertThrows(BigQueryJdbcException.class, firstHandle::createStatement);
      assertEquals(
          0,
          listener.getConnectionClosedCount(),
          "Implicit handle reclaim per JDBC 4.3 must not fire connectionClosed");

      assertFalse(secondHandle.isClosed());
      assertNull(secondHandle.getClientInfo("ApplicationName"));

      // Closing the already-invalidated first handle must not close or return secondHandle.
      firstHandle.close();
      assertFalse(secondHandle.isClosed());
      assertTrue(pooledConnection.inUse());
      assertEquals(0, listener.getConnectionClosedCount());

      secondHandle.close();
      assertEquals(1, listener.getConnectionClosedCount());
    }
  }

  @Test
  public void testLogicalCloseResetFailure_firesConnectionErrorAndClosesPhysicalConnection()
      throws Exception {
    try (BigQueryConnection realConn = new BigQueryConnection(sessionUri().toString())) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      realConn.bigQuery = mockBigQuery;

      SessionInfo sessionInfo = mock(SessionInfo.class);
      when(sessionInfo.getSessionId()).thenReturn("driver_tx_session");
      TableResult beginResult = mock(TableResult.class);
      when(beginResult.getSessionInfo()).thenReturn(sessionInfo);
      when(mockBigQuery.query(any(QueryJobConfiguration.class))).thenReturn(beginResult);
      when(mockBigQuery.create(any(JobInfo.class)))
          .thenThrow(new BigQueryException(500, "rollback backend error"));

      BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(realConn);
      TestConnectionListener eventListener = new TestConnectionListener();
      PooledConnectionListener poolListener = new PooledConnectionListener(CONNECTION_POOL_SIZE);
      pooledConnection.addConnectionEventListener(eventListener);
      pooledConnection.addConnectionEventListener(poolListener);

      Connection handle = pooledConnection.getConnection();
      handle.setAutoCommit(false);

      assertThrows(SQLException.class, handle::close);

      assertTrue(handle.isClosed());
      assertFalse(pooledConnection.inUse());
      assertEquals(0, eventListener.getConnectionClosedCount());
      assertEquals(1, eventListener.getConnectionErrorCount());
      assertTrue(poolListener.isConnectionPoolEmpty());
      assertTrue(realConn.isClosed());
      verify(mockBigQuery, times(1)).create(any(JobInfo.class));
      assertThrows(BigQueryJdbcException.class, pooledConnection::getConnection);
    }
  }

  @Test
  public void testGetConnectionWhileInUseResetFailure_firesErrorAndClosesPhysical()
      throws SQLException {
    doThrow(new IllegalStateException("unexpected runtime reset failure"))
        .when(bigQueryConnection)
        .resetForReuse();

    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    TestConnectionListener listener = new TestConnectionListener();
    pooledConnection.addConnectionEventListener(listener);

    Connection firstHandle = pooledConnection.getConnection();
    BigQueryJdbcException thrown =
        assertThrows(BigQueryJdbcException.class, pooledConnection::getConnection);
    assertTrue(thrown.getCause() instanceof IllegalStateException);
    assertTrue(firstHandle.isClosed());
    assertEquals(1, listener.getConnectionErrorCount());
    verify(bigQueryConnection).close();
  }

  @Test
  public void testAbort_handlesNullExecutorOpenHandleAndAlreadyClosedHandle() throws Exception {
    String url =
        BigQueryJdbcBaseTest.getUriOAuthToken().append("ProjectId", "test-project").toString();
    Executor directExecutor = Runnable::run;

    // 1. abort() on an already-closed handle is a no-op and must not close a reused checkout.
    try (BigQueryConnection realConn = new BigQueryConnection(url)) {
      BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(realConn);
      Connection handle1 = pooledConnection.getConnection();
      assertThrows(BigQueryJdbcException.class, () -> handle1.abort(null));
      handle1.close();

      Connection handle2 = pooledConnection.getConnection();
      handle1.abort(directExecutor);
      assertFalse(realConn.isClosed());
      assertFalse(handle2.isClosed());
      handle2.close();
    }

    // 2. abort() on a live handle closes the physical connection before notifying error listeners.
    try (BigQueryConnection realConn = new BigQueryConnection(url)) {
      BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(realConn);
      AtomicReference<Boolean> physicalClosedDuringCallback = new AtomicReference<>(false);
      pooledConnection.addConnectionEventListener(
          new ConnectionEventListener() {
            @Override
            public void connectionClosed(ConnectionEvent event) {}

            @Override
            public void connectionErrorOccurred(ConnectionEvent event) {
              physicalClosedDuringCallback.set(realConn.isClosed());
            }
          });

      Connection liveHandle = pooledConnection.getConnection();
      liveHandle.abort(directExecutor);
      assertTrue(liveHandle.isClosed());
      assertTrue(realConn.isClosed());
      assertTrue(physicalClosedDuringCallback.get());
      assertThrows(BigQueryJdbcException.class, pooledConnection::getConnection);
    }
  }

  @FunctionalInterface
  private interface SqlCallable<T> {
    T call() throws SQLException;
  }

  @Test
  public void testConcurrentCloseDuringStatementCreation_closesNewStatementAndThrows()
      throws Exception {
    for (int variant = 0; variant < 3; variant++) {
      BigQueryConnection mockConn = mock(BigQueryConnection.class);
      doReturn(LISTENER_POOL_SIZE).when(mockConn).getListenerPoolSize();
      BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(mockConn);
      Connection handle = pooledConnection.getConnection();
      CountDownLatch enteredCreate = new CountDownLatch(1);
      CountDownLatch releaseCreate = new CountDownLatch(1);

      if (variant == 0) {
        Statement createdStmt = mock(Statement.class);
        when(mockConn.createStatement())
            .thenAnswer(
                invocation -> {
                  enteredCreate.countDown();
                  assertTrue(releaseCreate.await(5, TimeUnit.SECONDS));
                  return createdStmt;
                });
        assertTwoThreadCloseDuringCreate(
            handle, enteredCreate, releaseCreate, createdStmt, handle::createStatement);
      } else if (variant == 1) {
        PreparedStatement createdPstmt = mock(PreparedStatement.class);
        when(mockConn.prepareStatement("SELECT 1"))
            .thenAnswer(
                invocation -> {
                  enteredCreate.countDown();
                  assertTrue(releaseCreate.await(5, TimeUnit.SECONDS));
                  return createdPstmt;
                });
        assertTwoThreadCloseDuringCreate(
            handle,
            enteredCreate,
            releaseCreate,
            createdPstmt,
            () -> handle.prepareStatement("SELECT 1"));
      } else {
        CallableStatement createdCstmt = mock(CallableStatement.class);
        when(mockConn.prepareCall("{call p()}"))
            .thenAnswer(
                invocation -> {
                  enteredCreate.countDown();
                  assertTrue(releaseCreate.await(5, TimeUnit.SECONDS));
                  return createdCstmt;
                });
        assertTwoThreadCloseDuringCreate(
            handle,
            enteredCreate,
            releaseCreate,
            createdCstmt,
            () -> handle.prepareCall("{call p()}"));
      }
    }
  }

  private static void assertTwoThreadCloseDuringCreate(
      Connection handle,
      CountDownLatch enteredCreate,
      CountDownLatch releaseCreate,
      Statement createdStmt,
      SqlCallable<? extends Statement> operation)
      throws Exception {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    try {
      Future<?> opFuture =
          executor.submit(
              () -> {
                assertThrows(BigQueryJdbcException.class, operation::call);
                return null;
              });
      assertTrue(enteredCreate.await(5, TimeUnit.SECONDS));
      AtomicReference<Thread> closeThread = new AtomicReference<>();
      CountDownLatch closeStarted = new CountDownLatch(1);
      Future<?> closeFuture =
          executor.submit(
              () -> {
                closeThread.set(Thread.currentThread());
                closeStarted.countDown();
                handle.close();
                return null;
              });
      awaitThreadWaiting(closeThread, closeStarted);
      releaseCreate.countDown();
      opFuture.get(5, TimeUnit.SECONDS);
      closeFuture.get(5, TimeUnit.SECONDS);
      verify(createdStmt).close();
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  public void testListenerCapacityExceededAndPostCloseRegistration() throws SQLException {
    doReturn(1L).when(bigQueryConnection).getListenerPoolSize();
    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    TestConnectionListener first = new TestConnectionListener();
    TestConnectionListener second = new TestConnectionListener();

    pooledConnection.addConnectionEventListener(first);
    assertThrows(
        BigQueryJdbcRuntimeException.class,
        () -> pooledConnection.addConnectionEventListener(second));

    pooledConnection.close();
    pooledConnection.addConnectionEventListener(second);
    assertFalse(pooledConnection.isListenerPooled(second));
  }

  private static void awaitThreadWaiting(
      AtomicReference<Thread> threadRef, CountDownLatch startedLatch) throws InterruptedException {
    assertTrue(startedLatch.await(5, TimeUnit.SECONDS));
    Thread worker = threadRef.get();
    long deadlineNanos = System.nanoTime() + TimeUnit.SECONDS.toNanos(5);
    while (!isThreadWaitingOnLock(worker.getState()) && System.nanoTime() < deadlineNanos) {
      LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(1));
    }
    assertTrue(
        isThreadWaitingOnLock(worker.getState()),
        "Expected worker thread to be waiting on lock, observed: " + worker.getState());
  }

  private static boolean isThreadWaitingOnLock(Thread.State state) {
    return state == Thread.State.BLOCKED
        || state == Thread.State.WAITING
        || state == Thread.State.TIMED_WAITING;
  }

  @Test
  public void testConcurrentCloseAndGetConnectionReclaim_serializesResetAndProtectsNewHandle()
      throws Exception {
    CountDownLatch enteredFirstReset = new CountDownLatch(1);
    CountDownLatch allowFirstResetToFinish = new CountDownLatch(1);
    AtomicInteger activeResets = new AtomicInteger(0);
    AtomicInteger totalResets = new AtomicInteger(0);
    AtomicBoolean overlappingResetDetected = new AtomicBoolean(false);
    AtomicReference<Connection> publishedHandle2 = new AtomicReference<>();
    AtomicBoolean resetRanAfterHandle2Published = new AtomicBoolean(false);

    doAnswer(
            invocation -> {
              if (activeResets.incrementAndGet() > 1) {
                overlappingResetDetected.set(true);
              }
              try {
                int callNum = totalResets.incrementAndGet();
                if (callNum == 1) {
                  enteredFirstReset.countDown();
                  assertTrue(allowFirstResetToFinish.await(5, TimeUnit.SECONDS));
                }
                if (publishedHandle2.get() != null) {
                  resetRanAfterHandle2Published.set(true);
                }
                return null;
              } finally {
                activeResets.decrementAndGet();
              }
            })
        .when(bigQueryConnection)
        .resetForReuse();

    BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(bigQueryConnection);
    Connection handle1 = pooledConnection.getConnection();
    BigQueryPooledConnection.PooledConnectionInvocationHandler handle1Handler =
        pooledConnection.getActiveHandleForTesting();

    ExecutorService executor = Executors.newFixedThreadPool(2);
    try {
      // Thread A reclaims the open handle via getConnection() and blocks inside resetForReuse().
      Future<Connection> reclaimFuture = executor.submit(pooledConnection::getConnection);
      assertTrue(enteredFirstReset.await(5, TimeUnit.SECONDS));

      // Thread B simulates a caller that passed closed.compareAndSet(false, true) just before
      // reclaim and now contends on physicalLock inside connectionHandleClosed(handle1).
      CountDownLatch staleCloseStarted = new CountDownLatch(1);
      AtomicReference<Thread> staleCloseThread = new AtomicReference<>();
      Future<?> closeStaleHandleFuture =
          executor.submit(
              () -> {
                staleCloseThread.set(Thread.currentThread());
                staleCloseStarted.countDown();
                pooledConnection.connectionHandleClosed(handle1Handler);
                return null;
              });
      awaitThreadWaiting(staleCloseThread, staleCloseStarted);

      allowFirstResetToFinish.countDown();
      Connection handle2 = reclaimFuture.get(5, TimeUnit.SECONDS);
      publishedHandle2.set(handle2);
      closeStaleHandleFuture.get(5, TimeUnit.SECONDS);

      // Direct stale abortHandle after reclaim must also be a no-op and leave handle2 intact (M07).
      pooledConnection.abortHandle(handle1Handler, Runnable::run);
      verify(bigQueryConnection, never()).abort(any(Executor.class));

      assertFalse(overlappingResetDetected.get(), "resetForReuse() calls must be serialized");
      assertFalse(
          resetRanAfterHandle2Published.get(),
          "Stale handle close must not run resetForReuse() underneath active handle2");
      assertEquals(1, totalResets.get());
      assertFalse(handle2.isClosed());
      assertTrue(pooledConnection.inUse());

      // Scenario 2: handle2.close() blocks inside resetForReuse() while a concurrent
      // getConnection() waits on physicalLock, verifying serialized handoff without double-reset.
      CountDownLatch enteredSecondReset = new CountDownLatch(1);
      CountDownLatch allowSecondResetToFinish = new CountDownLatch(1);
      doAnswer(
              invocation -> {
                if (activeResets.incrementAndGet() > 1) {
                  overlappingResetDetected.set(true);
                }
                try {
                  totalResets.incrementAndGet();
                  enteredSecondReset.countDown();
                  assertTrue(allowSecondResetToFinish.await(5, TimeUnit.SECONDS));
                  return null;
                } finally {
                  activeResets.decrementAndGet();
                }
              })
          .when(bigQueryConnection)
          .resetForReuse();

      Future<?> closeHandle2Future =
          executor.submit(
              () -> {
                handle2.close();
                return null;
              });
      assertTrue(enteredSecondReset.await(5, TimeUnit.SECONDS));

      CountDownLatch checkoutStarted = new CountDownLatch(1);
      AtomicReference<Thread> checkoutThread = new AtomicReference<>();
      Future<Connection> nextCheckoutFuture =
          executor.submit(
              () -> {
                checkoutThread.set(Thread.currentThread());
                checkoutStarted.countDown();
                return pooledConnection.getConnection();
              });
      awaitThreadWaiting(checkoutThread, checkoutStarted);
      assertFalse(nextCheckoutFuture.isDone(), "getConnection() must wait for in-flight reset");

      allowSecondResetToFinish.countDown();
      closeHandle2Future.get(5, TimeUnit.SECONDS);
      Connection handle3 = nextCheckoutFuture.get(5, TimeUnit.SECONDS);

      assertFalse(overlappingResetDetected.get());
      assertEquals(2, totalResets.get());
      assertFalse(handle3.isClosed());
      assertTrue(pooledConnection.inUse());
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  public void testConcurrentPhysicalCloseDuringReset_suppressesReturnEventAndRejectsCheckout()
      throws SQLException {
    BigQueryPooledConnection pc1 = new BigQueryPooledConnection(bigQueryConnection);
    TestConnectionListener listener = new TestConnectionListener();
    pc1.addConnectionEventListener(listener);
    Connection handle = pc1.getConnection();
    doAnswer(
            invocation -> {
              pc1.close();
              return null;
            })
        .when(bigQueryConnection)
        .resetForReuse();

    handle.close();
    assertEquals(0, listener.getConnectionClosedCount());
    assertFalse(pc1.inUse());

    BigQueryConnection bqConn2 = mock(BigQueryConnection.class);
    doReturn(LISTENER_POOL_SIZE).when(bqConn2).getListenerPoolSize();
    BigQueryPooledConnection pc2 = new BigQueryPooledConnection(bqConn2);
    pc2.getConnection();
    doAnswer(
            invocation -> {
              pc2.close();
              return null;
            })
        .when(bqConn2)
        .resetForReuse();

    assertThrows(BigQueryJdbcException.class, pc2::getConnection);
  }

  @Test
  public void testAbort_propagatesDelegateFailureAndSuppressesCloseException() throws SQLException {
    BigQueryConnection failingConn = mock(BigQueryConnection.class);
    doReturn(LISTENER_POOL_SIZE).when(failingConn).getListenerPoolSize();
    SQLException abortFailure = new SQLException("abort failed");
    SQLException closeFailure = new SQLException("close failed");
    doThrow(abortFailure).when(failingConn).abort(any(Executor.class));
    doThrow(closeFailure).when(failingConn).close();

    BigQueryPooledConnection pc = new BigQueryPooledConnection(failingConn);
    AtomicReference<SQLException> capturedError = new AtomicReference<>();
    pc.addConnectionEventListener(
        new ConnectionEventListener() {
          @Override
          public void connectionClosed(ConnectionEvent event) {}

          @Override
          public void connectionErrorOccurred(ConnectionEvent event) {
            capturedError.set(event.getSQLException());
          }
        });

    Connection handle = pc.getConnection();
    SQLException thrown = assertThrows(SQLException.class, () -> handle.abort(Runnable::run));
    assertSame(abortFailure, thrown);
    assertNotNull(capturedError.get());
    assertEquals(2, capturedError.get().getSuppressed().length);
  }

  @Test
  public void testChildObjectsReturnLogicalHandleAndGuardRetainedMetaData() throws Exception {
    String url =
        BigQueryJdbcBaseTest.getUriOAuthToken()
            .append("ProjectId", "test-project")
            .append("UseStatelessQueryMode", 1)
            .toString();
    try (BigQueryConnection realConn = new BigQueryConnection(url)) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      realConn.bigQuery = mockBigQuery;
      TableResult queryResult = mock(TableResult.class);
      when(queryResult.getSchema()).thenReturn(Schema.of());
      when(queryResult.getStatementType()).thenReturn(StatementType.SELECT);
      when(queryResult.iterateAll()).thenReturn(Collections.emptyList());
      when(queryResult.getValues()).thenReturn(Collections.emptyList());
      when(mockBigQuery.queryWithTimeout(any(QueryJobConfiguration.class), any(), any()))
          .thenReturn(queryResult);

      BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(realConn);
      TestConnectionListener listener = new TestConnectionListener();
      pooledConnection.addConnectionEventListener(listener);

      Connection handle1 = pooledConnection.getConnection();
      Statement stmt = handle1.createStatement();
      PreparedStatement pstmt = handle1.prepareStatement("SELECT 1");
      CallableStatement cstmt = handle1.prepareCall("{call p()}");
      DatabaseMetaData metaData = handle1.getMetaData();
      ResultSet rs = stmt.executeQuery("SELECT 1");

      assertSame(handle1, stmt.getConnection());
      assertSame(handle1, pstmt.getConnection());
      assertSame(handle1, cstmt.getConnection());
      assertSame(stmt, rs.getStatement());
      assertSame(handle1, rs.getStatement().getConnection());
      assertSame(handle1, metaData.getConnection());

      // Closing through rs.getStatement().getConnection().close() must close the logical handle
      // and fire connectionClosed, leaving the underlying physical connection open for reuse.
      rs.getStatement().getConnection().close();
      assertTrue(handle1.isClosed());
      assertFalse(realConn.isClosed());
      assertFalse(pooledConnection.inUse());
      assertEquals(1, listener.getConnectionClosedCount());
      assertEquals(0, listener.getConnectionErrorCount());
      assertThrows(BigQueryJdbcException.class, stmt::getConnection);

      // A DatabaseMetaData retained past handle1.close() must not operate on handle2's checkout.
      Connection handle2 = pooledConnection.getConnection();
      assertThrows(BigQueryJdbcException.class, metaData::getConnection);
      assertThrows(BigQueryJdbcException.class, metaData::getDatabaseProductName);
      assertFalse(handle2.isClosed());
      handle2.close();
    }
  }

  @Test
  public void testOutOfBandPhysicalClose_firesConnectionErrorOnHandleCloseAndCheckout()
      throws Exception {
    String url =
        BigQueryJdbcBaseTest.getUriOAuthToken().append("ProjectId", "test-project").toString();
    // Case 1: Physical connection closed out-of-band while logical handle is checked out.
    BigQueryConnection realConn1 = new BigQueryConnection(url);
    BigQueryPooledConnection pc1 = new BigQueryPooledConnection(realConn1);
    TestConnectionListener listener1 = new TestConnectionListener();
    PooledConnectionListener poolListener1 = new PooledConnectionListener(CONNECTION_POOL_SIZE);
    pc1.addConnectionEventListener(listener1);
    pc1.addConnectionEventListener(poolListener1);

    Connection handle1 = pc1.getConnection();
    handle1.unwrap(BigQueryConnection.class).close();
    assertTrue(realConn1.isClosed());

    handle1.close();
    assertFalse(pc1.inUse());
    assertEquals(0, listener1.getConnectionClosedCount());
    assertEquals(1, listener1.getConnectionErrorCount());
    assertTrue(poolListener1.isConnectionPoolEmpty());
    assertThrows(BigQueryJdbcException.class, pc1::getConnection);

    // Case 2: Physical connection closed out-of-band while holder is idle, then getConnection().
    BigQueryConnection realConn2 = new BigQueryConnection(url);
    BigQueryPooledConnection pc2 = new BigQueryPooledConnection(realConn2);
    TestConnectionListener listener2 = new TestConnectionListener();
    pc2.addConnectionEventListener(listener2);
    realConn2.close();

    assertThrows(BigQueryJdbcException.class, pc2::getConnection);
    assertEquals(0, listener2.getConnectionClosedCount());
    assertEquals(1, listener2.getConnectionErrorCount());
  }

  @Test
  public void testConcurrentSetAutoCommitAndClose_waitsForInFlightRpcAndRollsBackTransaction()
      throws Exception {
    try (BigQueryConnection realConn = new BigQueryConnection(sessionUri().toString())) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      realConn.bigQuery = mockBigQuery;

      CountDownLatch enteredBeginRpc = new CountDownLatch(1);
      CountDownLatch releaseBeginRpc = new CountDownLatch(1);
      SessionInfo sessionInfo = mock(SessionInfo.class);
      when(sessionInfo.getSessionId()).thenReturn("raced_tx_session");
      TableResult beginResult = mock(TableResult.class);
      when(beginResult.getSessionInfo()).thenReturn(sessionInfo);

      when(mockBigQuery.query(any(QueryJobConfiguration.class)))
          .thenAnswer(
              invocation -> {
                QueryJobConfiguration cfg = invocation.getArgument(0);
                if ("BEGIN TRANSACTION;".equals(cfg.getQuery())) {
                  enteredBeginRpc.countDown();
                  assertTrue(releaseBeginRpc.await(5, TimeUnit.SECONDS));
                  return beginResult;
                }
                return mock(TableResult.class);
              });

      Job rollbackJob = mock(Job.class);
      when(mockBigQuery.create(any(JobInfo.class))).thenReturn(rollbackJob);
      when(rollbackJob.waitFor()).thenReturn(rollbackJob);

      BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(realConn);
      TestConnectionListener listener = new TestConnectionListener();
      pooledConnection.addConnectionEventListener(listener);
      Connection handle1 = pooledConnection.getConnection();

      ExecutorService executor = Executors.newFixedThreadPool(2);
      try {
        Future<?> autoCommitFuture =
            executor.submit(
                () -> {
                  assertThrows(BigQueryJdbcException.class, () -> handle1.setAutoCommit(false));
                  return null;
                });
        assertTrue(enteredBeginRpc.await(5, TimeUnit.SECONDS));

        AtomicReference<Thread> closeThread = new AtomicReference<>();
        CountDownLatch closeStarted = new CountDownLatch(1);
        Future<?> closeFuture =
            executor.submit(
                () -> {
                  closeThread.set(Thread.currentThread());
                  closeStarted.countDown();
                  handle1.close();
                  return null;
                });
        awaitThreadWaiting(closeThread, closeStarted);
        assertFalse(closeFuture.isDone(), "close() must wait for in-flight setAutoCommit RPC");

        releaseBeginRpc.countDown();
        autoCommitFuture.get(5, TimeUnit.SECONDS);
        closeFuture.get(5, TimeUnit.SECONDS);

        assertEquals(1, listener.getConnectionClosedCount());
        assertEquals(0, listener.getConnectionErrorCount());

        Connection handle2 = pooledConnection.getConnection();
        assertTrue(handle2.getAutoCommit());
        assertFalse(realConn.isTransactionStarted());
        assertNull(realConn.getSessionInfoConnectionProperty());
        handle2.close();
      } finally {
        executor.shutdownNow();
      }
    }
  }

  @Test
  public void testPhysicalCloseAndErrorWaitForInFlightResetOnPhysicalLock() throws Exception {
    for (boolean triggerError : new boolean[] {false, true}) {
      BigQueryConnection mockConn = mock(BigQueryConnection.class);
      doReturn(LISTENER_POOL_SIZE).when(mockConn).getListenerPoolSize();
      CountDownLatch enteredReset = new CountDownLatch(1);
      CountDownLatch releaseReset = new CountDownLatch(1);
      AtomicBoolean resetInFlight = new AtomicBoolean(false);
      AtomicBoolean closeOverlappedReset = new AtomicBoolean(false);

      doAnswer(
              invocation -> {
                resetInFlight.set(true);
                enteredReset.countDown();
                try {
                  assertTrue(releaseReset.await(5, TimeUnit.SECONDS));
                  return null;
                } finally {
                  resetInFlight.set(false);
                }
              })
          .when(mockConn)
          .resetForReuse();
      doAnswer(
              invocation -> {
                if (resetInFlight.get()) {
                  closeOverlappedReset.set(true);
                }
                return null;
              })
          .when(mockConn)
          .close();

      BigQueryPooledConnection pc = new BigQueryPooledConnection(mockConn);
      Connection handle = pc.getConnection();
      ExecutorService executor = Executors.newFixedThreadPool(2);
      try {
        Future<?> resetFuture =
            executor.submit(
                () -> {
                  handle.close();
                  return null;
                });
        assertTrue(enteredReset.await(5, TimeUnit.SECONDS));

        AtomicReference<Thread> teardownThread = new AtomicReference<>();
        CountDownLatch teardownStarted = new CountDownLatch(1);
        Future<?> teardownFuture =
            executor.submit(
                () -> {
                  teardownThread.set(Thread.currentThread());
                  teardownStarted.countDown();
                  if (triggerError) {
                    pc.fireConnectionError(new SQLException("forced error"));
                  } else {
                    pc.close();
                  }
                  return null;
                });
        awaitThreadWaiting(teardownThread, teardownStarted);
        verify(mockConn, never()).close();

        releaseReset.countDown();
        resetFuture.get(5, TimeUnit.SECONDS);
        teardownFuture.get(5, TimeUnit.SECONDS);

        assertFalse(closeOverlappedReset.get());
        verify(mockConn, times(1)).close();
      } finally {
        executor.shutdownNow();
      }
    }
  }

  @Test
  public void testListenerExceptionsAreIsolatedOnCloseAndError() throws SQLException {
    ConnectionEventListener throwingListener =
        new ConnectionEventListener() {
          @Override
          public void connectionClosed(ConnectionEvent event) {
            throw new IllegalStateException("listener close failure");
          }

          @Override
          public void connectionErrorOccurred(ConnectionEvent event) {
            throw new IllegalStateException("listener error failure");
          }
        };

    BigQueryPooledConnection pc1 = new BigQueryPooledConnection(bigQueryConnection);
    TestConnectionListener healthy1 = new TestConnectionListener();
    pc1.addConnectionEventListener(throwingListener);
    pc1.addConnectionEventListener(healthy1);

    Connection handle1 = pc1.getConnection();
    handle1.close();
    assertEquals(1, healthy1.getConnectionClosedCount());

    BigQueryConnection failingResetConn = mock(BigQueryConnection.class);
    doReturn(LISTENER_POOL_SIZE).when(failingResetConn).getListenerPoolSize();
    SQLException resetEx = new SQLException("reset failed");
    doThrow(resetEx).when(failingResetConn).resetForReuse();

    BigQueryPooledConnection pc2 = new BigQueryPooledConnection(failingResetConn);
    TestConnectionListener healthy2 = new TestConnectionListener();
    pc2.addConnectionEventListener(throwingListener);
    pc2.addConnectionEventListener(healthy2);

    Connection handle2 = pc2.getConnection();
    SQLException surfaced = assertThrows(SQLException.class, handle2::close);
    assertSame(resetEx, surfaced);
    assertEquals(1, healthy2.getConnectionErrorCount());
  }

  @Test
  public void testAbortUsesExecutorAsynchronouslyAndPreemptsBlockedReset() throws Exception {
    String url =
        BigQueryJdbcBaseTest.getUriOAuthToken().append("ProjectId", "test-project").toString();
    // 1. Deferred executor receives the physical close task while abort() returns immediately.
    BigQueryConnection realConn = new BigQueryConnection(url);
    BigQueryPooledConnection pc = new BigQueryPooledConnection(realConn);
    TestConnectionListener listener = new TestConnectionListener();
    pc.addConnectionEventListener(listener);

    Connection handle = pc.getConnection();
    Statement stmt = handle.createStatement();
    DatabaseMetaData metaData = handle.getMetaData();
    List<Runnable> deferredTasks = new ArrayList<>();
    handle.abort(deferredTasks::add);

    assertTrue(handle.isClosed());
    assertTrue(realConn.isClosed());
    assertEquals(1, listener.getConnectionErrorCount());
    assertEquals(1, deferredTasks.size());
    assertFalse(stmt.isClosed());
    assertThrows(BigQueryJdbcException.class, stmt::getConnection);
    assertThrows(BigQueryJdbcException.class, metaData::getConnection);

    deferredTasks.get(0).run();
    assertTrue(stmt.isClosed());

    // 2. abort() while handle.close() is blocked inside resetForReuse() preempts the hung reset.
    BigQueryConnection hungResetConn = mock(BigQueryConnection.class);
    doReturn(LISTENER_POOL_SIZE).when(hungResetConn).getListenerPoolSize();
    CountDownLatch enteredReset = new CountDownLatch(1);
    CountDownLatch releaseReset = new CountDownLatch(1);
    doAnswer(
            invocation -> {
              enteredReset.countDown();
              assertTrue(releaseReset.await(5, TimeUnit.SECONDS));
              return null;
            })
        .when(hungResetConn)
        .resetForReuse();

    BigQueryPooledConnection pcHung = new BigQueryPooledConnection(hungResetConn);
    TestConnectionListener hungListener = new TestConnectionListener();
    pcHung.addConnectionEventListener(hungListener);
    Connection hungHandle = pcHung.getConnection();

    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
      Future<?> closeFuture =
          executor.submit(
              () -> {
                hungHandle.close();
                return null;
              });
      assertTrue(enteredReset.await(5, TimeUnit.SECONDS));

      List<Runnable> abortTasks = new ArrayList<>();
      hungHandle.abort(abortTasks::add);
      assertEquals(1, hungListener.getConnectionErrorCount());
      assertEquals(0, hungListener.getConnectionClosedCount());
      verify(hungResetConn).abort(any(Executor.class));

      releaseReset.countDown();
      closeFuture.get(5, TimeUnit.SECONDS);
      assertEquals(0, hungListener.getConnectionClosedCount());
    } finally {
      executor.shutdownNow();
    }

    // 3. Rejecting Executor passed to abort() rolls back and runs synchronous fallback close.
    BigQueryConnection rejectConn = new BigQueryConnection(url);
    BigQueryPooledConnection pcReject = new BigQueryPooledConnection(rejectConn);
    TestConnectionListener rejectListener = new TestConnectionListener();
    pcReject.addConnectionEventListener(rejectListener);
    Connection rejectHandle = pcReject.getConnection();
    Statement rejectStmt = rejectHandle.createStatement();

    assertThrows(
        RejectedExecutionException.class,
        () ->
            rejectHandle.abort(
                task -> {
                  throw new RejectedExecutionException("abort pool shut down");
                }));
    assertTrue(rejectHandle.isClosed());
    assertTrue(rejectConn.isClosed());
    assertTrue(rejectStmt.isClosed());
    assertEquals(1, rejectListener.getConnectionErrorCount());
  }

  @Test
  public void testConcurrentStatementExecuteAndHandleClose_waitsForInFlightQueryAndAbortsSession()
      throws Exception {
    String url = sessionUri().append("UseStatelessQueryMode", 1).toString();
    try (BigQueryConnection realConn = new BigQueryConnection(url)) {
      BigQuery mockBigQuery = mock(BigQuery.class);
      realConn.bigQuery = mockBigQuery;

      CountDownLatch enteredQueryRpc = new CountDownLatch(1);
      CountDownLatch releaseQueryRpc = new CountDownLatch(1);
      SessionInfo sessionInfo = mock(SessionInfo.class);
      when(sessionInfo.getSessionId()).thenReturn("raced_stmt_session");
      TableResult queryResult = mock(TableResult.class);
      when(queryResult.getSchema()).thenReturn(Schema.of());
      when(queryResult.getStatementType()).thenReturn(StatementType.SELECT);
      when(queryResult.iterateAll()).thenReturn(Collections.emptyList());
      when(queryResult.getValues()).thenReturn(Collections.emptyList());
      when(queryResult.getSessionInfo()).thenReturn(sessionInfo);

      when(mockBigQuery.queryWithTimeout(any(QueryJobConfiguration.class), any(), any()))
          .thenAnswer(
              invocation -> {
                enteredQueryRpc.countDown();
                assertTrue(releaseQueryRpc.await(5, TimeUnit.SECONDS));
                return queryResult;
              });
      when(mockBigQuery.query(any(QueryJobConfiguration.class)))
          .thenReturn(mock(TableResult.class));

      BigQueryPooledConnection pooledConnection = new BigQueryPooledConnection(realConn);
      TestConnectionListener listener = new TestConnectionListener();
      pooledConnection.addConnectionEventListener(listener);
      Connection handle1 = pooledConnection.getConnection();
      Statement stmt1 = handle1.createStatement();

      ExecutorService executor = Executors.newFixedThreadPool(2);
      try {
        Future<?> queryFuture =
            executor.submit(
                () -> {
                  assertThrows(BigQueryJdbcException.class, () -> stmt1.executeQuery("SELECT 1"));
                  return null;
                });
        assertTrue(enteredQueryRpc.await(5, TimeUnit.SECONDS));

        AtomicReference<Thread> closeThread = new AtomicReference<>();
        CountDownLatch closeStarted = new CountDownLatch(1);
        Future<?> closeFuture =
            executor.submit(
                () -> {
                  closeThread.set(Thread.currentThread());
                  closeStarted.countDown();
                  handle1.close();
                  return null;
                });
        awaitThreadWaiting(closeThread, closeStarted);
        assertFalse(closeFuture.isDone(), "close() must wait for in-flight Statement RPC");

        releaseQueryRpc.countDown();
        queryFuture.get(5, TimeUnit.SECONDS);
        closeFuture.get(5, TimeUnit.SECONDS);

        assertEquals(1, listener.getConnectionClosedCount());
        assertEquals(0, listener.getConnectionErrorCount());
        assertTrue(stmt1.isClosed());

        Connection handle2 = pooledConnection.getConnection();
        assertNull(realConn.getSessionInfoConnectionProperty());
        assertFalse(realConn.isSessionCreatedByDriver());
        handle2.close();

        ArgumentCaptor<QueryJobConfiguration> abortCaptor =
            ArgumentCaptor.forClass(QueryJobConfiguration.class);
        verify(mockBigQuery).query(abortCaptor.capture());
        assertEquals("CALL BQ.ABORT_SESSION();", abortCaptor.getValue().getQuery());
      } finally {
        executor.shutdownNow();
      }
    }
  }

  @Test
  public void testPooledOperationsPreserveOuterThreadMdcContext() throws Exception {
    String url =
        BigQueryJdbcBaseTest.getUriOAuthToken().append("ProjectId", "test-project").toString();
    AtomicReference<String> mdcDuringClosedCallback = new AtomicReference<>();
    AtomicReference<String> mdcDuringErrorCallback = new AtomicReference<>();
    ConnectionEventListener mdcCapturingListener =
        new ConnectionEventListener() {
          @Override
          public void connectionClosed(ConnectionEvent event) {
            mdcDuringClosedCallback.set(BigQueryJdbcMdc.getConnectionId());
          }

          @Override
          public void connectionErrorOccurred(ConnectionEvent event) {
            mdcDuringErrorCallback.set(BigQueryJdbcMdc.getConnectionId());
          }
        };

    try (BigQueryJdbcMdc.MdcCloseable outerMdc =
        BigQueryJdbcMdc.registerInstance("outer-caller-conn")) {
      BigQueryConnection realConn1 = new BigQueryConnection(url);
      BigQueryPooledConnection pc1 = new BigQueryPooledConnection(realConn1);

      pc1.addConnectionEventListener(mdcCapturingListener);
      assertEquals("outer-caller-conn", BigQueryJdbcMdc.getConnectionId());

      Connection handle1 = pc1.getConnection();
      assertEquals("outer-caller-conn", BigQueryJdbcMdc.getConnectionId());

      handle1.close();
      assertEquals("outer-caller-conn", mdcDuringClosedCallback.get());
      assertEquals("outer-caller-conn", BigQueryJdbcMdc.getConnectionId());

      pc1.close();
      assertEquals("outer-caller-conn", BigQueryJdbcMdc.getConnectionId());

      BigQueryConnection realConn2 = new BigQueryConnection(url);
      BigQueryPooledConnection pc2 = new BigQueryPooledConnection(realConn2);
      pc2.addConnectionEventListener(mdcCapturingListener);
      Connection handle2 = pc2.getConnection();
      pc2.fireConnectionError(new SQLException("forced error"));
      assertTrue(handle2.isClosed());
      assertEquals("outer-caller-conn", mdcDuringErrorCallback.get());
      assertEquals("outer-caller-conn", BigQueryJdbcMdc.getConnectionId());
    }
    assertNull(BigQueryJdbcMdc.getConnectionId());
  }
}
