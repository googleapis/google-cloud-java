/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.connection;

import static com.google.cloud.spanner.connection.ConnectionProperties.CONNECTION_STATE_TYPE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.ConnectionState.Type;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest.ITConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ConnectionStateMockServerTest extends AbstractMockServerTest {

  @Parameters(name = "dialect = {0})")
  public static Object[] data() {
    return Dialect.values();
  }

  @Parameter public Dialect dialect;

  private Dialect currentDialect;

  @BeforeClass
  public static void enableTransactionalConnectionStateForPostgreSQL() {
    System.setProperty(
        ConnectionOptions.ENABLE_TRANSACTIONAL_CONNECTION_STATE_FOR_POSTGRESQL_PROPERTY, "true");
  }

  @AfterClass
  public static void disableTransactionalConnectionStateForPostgreSQL() {
    System.clearProperty(
        ConnectionOptions.ENABLE_TRANSACTIONAL_CONNECTION_STATE_FOR_POSTGRESQL_PROPERTY);
  }

  @Before
  public void setupDialect() {
    if (currentDialect != dialect) {
      // Reset the dialect result.
      SpannerPool.closeSpannerPool();
      mockSpanner.putStatementResult(StatementResult.detectDialectResult(dialect));
      currentDialect = dialect;
    }
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  protected String getBaseUrl() {
    return String.format(
        "cloudspanner://localhost:%d/projects/proj/instances/inst/databases/db?usePlainText=true",
        getPort());
  }

  ITConnection createConnection(ConnectionState.Type type) {
    return createConnection(";" + CONNECTION_STATE_TYPE.getKey() + "=" + type.name());
  }

  String getPrefix() {
    return dialect == Dialect.POSTGRESQL ? "SPANNER." : "";
  }

  @Test
  public void testConnectionStateType() {
    try (Connection connection = createConnection()) {
      // The default ConnectionState.Type should depend on the dialect.
      assertEquals(
          dialect == Dialect.POSTGRESQL ? Type.TRANSACTIONAL : Type.NON_TRANSACTIONAL,
          ((ConnectionImpl) connection).getConnectionStateType());
    }
    // It should be possible to override the default ConnectionState.Type, irrespective of the
    // database dialect.
    try (Connection connection = createConnection(Type.TRANSACTIONAL)) {
      assertEquals(Type.TRANSACTIONAL, ((ConnectionImpl) connection).getConnectionStateType());
    }
    try (Connection connection = createConnection(Type.NON_TRANSACTIONAL)) {
      assertEquals(Type.NON_TRANSACTIONAL, ((ConnectionImpl) connection).getConnectionStateType());
    }
  }

  @Test
  public void testAutocommitPersistsConnectionState() {
    try (Connection connection = createConnection(";autocommit=true")) {
      assertTrue(connection.isAutocommit());

      assertEquals(AutocommitDmlMode.TRANSACTIONAL, connection.getAutocommitDmlMode());
      connection.setAutocommitDmlMode(AutocommitDmlMode.PARTITIONED_NON_ATOMIC);
      assertEquals(AutocommitDmlMode.PARTITIONED_NON_ATOMIC, connection.getAutocommitDmlMode());
    }
  }

  @Test
  public void testNonTransactionalState_commitsAutomatically() {
    try (Connection connection =
        createConnection(";connection_state_type=non_transactional;autocommit=false")) {
      assertEquals(((ConnectionImpl) connection).getConnectionStateType(), Type.NON_TRANSACTIONAL);
      assertFalse(connection.isAutocommit());

      // Verify the initial default value.
      assertFalse(connection.isReturnCommitStats());

      // Change the value and read it back in the same transaction.
      connection.setReturnCommitStats(true);
      assertTrue(connection.isReturnCommitStats());

      // Rolling back should not have any impact on the connection state, as the connection state is
      // non-transactional.
      connection.rollback();
      assertTrue(connection.isReturnCommitStats());

      // Verify that the behavior is the same with autocommit=true and a temporary transaction.
      assertTrue(connection.isReturnCommitStats());
      connection.setAutocommit(true);
      connection.beginTransaction();
      connection.setReturnCommitStats(false);
      assertFalse(connection.isReturnCommitStats());
      connection.rollback();
      assertFalse(connection.isReturnCommitStats());
    }
  }

  @Test
  public void testTransactionalState_rollBacksConnectionState() {
    try (Connection connection =
        createConnection(";connection_state_type=transactional;autocommit=false")) {
      assertEquals(((ConnectionImpl) connection).getConnectionStateType(), Type.TRANSACTIONAL);
      assertFalse(connection.isAutocommit());

      // Verify the initial default value.
      assertFalse(connection.isReturnCommitStats());

      // Change the value and read it back in the same transaction.
      connection.setReturnCommitStats(true);
      assertTrue(connection.isReturnCommitStats());

      // Rolling back will undo the connection state change.
      connection.rollback();
      assertFalse(connection.isReturnCommitStats());

      // Verify that the behavior is the same with autocommit=true and a temporary transaction.
      assertFalse(connection.isReturnCommitStats());
      connection.setAutocommit(true);
      connection.beginTransaction();
      connection.setReturnCommitStats(true);
      assertTrue(connection.isReturnCommitStats());
      connection.rollback();
      assertFalse(connection.isReturnCommitStats());
    }
  }

  @Test
  public void testTransactionalState_commitsConnectionState() {
    try (Connection connection =
        createConnection(";connection_state_type=transactional;autocommit=false")) {
      assertEquals(((ConnectionImpl) connection).getConnectionStateType(), Type.TRANSACTIONAL);
      assertFalse(connection.isAutocommit());

      // Verify the initial default value.
      assertFalse(connection.isReturnCommitStats());

      // Change the value and read it back in the same transaction.
      connection.setReturnCommitStats(true);
      assertTrue(connection.isReturnCommitStats());

      // Committing will persist the connection state change.
      connection.commit();
      assertTrue(connection.isReturnCommitStats());

      // Verify that the behavior is the same with autocommit=true and a temporary transaction.
      assertTrue(connection.isReturnCommitStats());
      connection.setAutocommit(true);
      connection.beginTransaction();
      connection.setReturnCommitStats(false);
      assertFalse(connection.isReturnCommitStats());
      connection.commit();
      assertFalse(connection.isReturnCommitStats());
    }
  }

  @Test
  public void testLocalChangeIsLostAfterTransaction() {
    // SET LOCAL ... has the same effect regardless of connection state type.
    for (ConnectionState.Type type : Type.values()) {
      try (ConnectionImpl connection = (ConnectionImpl) createConnection()) {
        assertTrue(connection.isAutocommit());

        for (boolean commit : new boolean[] {true, false}) {
          // Verify the initial default value.
          assertFalse(connection.isReturnCommitStats());

          connection.beginTransaction();
          // Change the value and read it back in the same transaction.
          connection.setReturnCommitStats(true, /* local= */ true);
          assertTrue(connection.isReturnCommitStats());
          // Both rolling back and committing will undo the connection state change.
          if (commit) {
            connection.commit();
          } else {
            connection.rollback();
          }
          // The local change should now be undone.
          assertFalse(connection.isReturnCommitStats());
        }
      }
    }
  }

  @Test
  public void testSetLocalWithSqlStatement() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);

      assertTrue(connection.isRetryAbortsInternally());
      connection.execute(
          Statement.of(String.format("set local %sretry_aborts_internally=false", getPrefix())));
      assertFalse(connection.isRetryAbortsInternally());
      connection.commit();
      assertTrue(connection.isRetryAbortsInternally());
    }
  }

  @Test
  public void testSetSessionWithSqlStatement() {
    assumeTrue("Only PostgreSQL supports the 'session' keyword", dialect == Dialect.POSTGRESQL);

    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);

      assertTrue(connection.isRetryAbortsInternally());
      connection.execute(
          Statement.of(String.format("set session %sretry_aborts_internally=false", getPrefix())));
      assertFalse(connection.isRetryAbortsInternally());
      connection.commit();
      assertFalse(connection.isRetryAbortsInternally());
    }
  }

  @Test
  public void testSetLocalInvalidValue() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);

      assertTrue(connection.isRetryAbortsInternally());
      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () ->
                  connection.execute(
                      Statement.of(
                          String.format("set local %sretry_aborts_internally=foo", getPrefix()))));
      assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
      assertTrue(
          exception.getMessage(),
          exception
              .getMessage()
              .endsWith(
                  String.format("Unknown value for %sRETRY_ABORTS_INTERNALLY: foo", getPrefix())));
      assertTrue(connection.isRetryAbortsInternally());
    }
  }

  @Test
  public void testGetConnectionProperty() {
    try (Connection connection = createConnection()) {
      ConnectionProperty<Integer> unknownLength = ConnectionProperties.UNKNOWN_LENGTH;
      assertEquals(
          unknownLength.getDefaultValue(), connection.getConnectionPropertyValue(unknownLength));
    }
  }
}
