/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.rpc.Code;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JdbcConnectionTest {
  @Rule public final ExpectedException exception = ExpectedException.none();

  private JdbcConnection createConnection(ConnectionOptions options) {
    com.google.cloud.spanner.jdbc.Connection spannerConnection =
        ConnectionImplTest.createConnection(options);
    when(options.getConnection()).thenReturn(spannerConnection);
    return new JdbcConnection(
        "jdbc:cloudspanner://localhost/projects/project/instances/instance/databases/database;credentialsUrl=url",
        options);
  }

  @Test
  public void testAutoCommit() throws SQLException {
    ConnectionOptions options = mock(ConnectionOptions.class);
    when(options.isAutocommit()).thenReturn(true);
    try (Connection connection = createConnection(options)) {
      assertThat(connection.getAutoCommit(), is(true));
      connection.setAutoCommit(false);
      assertThat(connection.getAutoCommit(), is(false));
      // execute a query that will start a transaction
      connection.createStatement().executeQuery(AbstractConnectionImplTest.SELECT);
      // setting autocommit will automatically commit the transaction
      connection.setAutoCommit(true);
      assertThat(connection.getAutoCommit(), is(true));
    }
  }

  @Test
  public void testReadOnly() throws SQLException {
    ConnectionOptions options = mock(ConnectionOptions.class);
    when(options.isAutocommit()).thenReturn(true);
    when(options.isReadOnly()).thenReturn(true);
    try (Connection connection = createConnection(options)) {
      assertThat(connection.isReadOnly(), is(true));
      connection.setReadOnly(false);
      assertThat(connection.isReadOnly(), is(false));
      // start a transaction
      connection.createStatement().execute("begin transaction");
      // setting readonly should no longer be allowed
      exception.expect(JdbcExceptionMatcher.matchCode(Code.FAILED_PRECONDITION));
      connection.setReadOnly(true);
    }
  }

  @Test
  public void testCommit() throws SQLException {
    ConnectionOptions options = mock(ConnectionOptions.class);
    try (JdbcConnection connection = createConnection(options)) {
      // verify that there is no transaction started
      assertThat(connection.getSpannerConnection().isTransactionStarted(), is(false));
      // start a transaction
      connection.createStatement().execute(AbstractConnectionImplTest.SELECT);
      // verify that we did start a transaction
      assertThat(connection.getSpannerConnection().isTransactionStarted(), is(true));
      // do a commit
      connection.commit();
      // verify that there is no transaction started anymore
      assertThat(connection.getSpannerConnection().isTransactionStarted(), is(false));
      // verify that there is a commit timestamp
      assertThat(connection.getSpannerConnection().getCommitTimestamp(), is(notNullValue()));
    }
  }

  @Test
  public void testRollback() throws SQLException {
    ConnectionOptions options = mock(ConnectionOptions.class);
    try (JdbcConnection connection = createConnection(options)) {
      // verify that there is no transaction started
      assertThat(connection.getSpannerConnection().isTransactionStarted(), is(false));
      // start a transaction
      connection.createStatement().execute(AbstractConnectionImplTest.SELECT);
      // verify that we did start a transaction
      assertThat(connection.getSpannerConnection().isTransactionStarted(), is(true));
      // do a rollback
      connection.rollback();
      // verify that there is no transaction started anymore
      assertThat(connection.getSpannerConnection().isTransactionStarted(), is(false));
      // verify that there is no commit timestamp
      try (ResultSet rs =
          connection.createStatement().executeQuery("show variable commit_timestamp")) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getTimestamp("COMMIT_TIMESTAMP"), is(nullValue()));
      }
    }
  }

  @Test
  public void testClosedAbstractJdbcConnection()
      throws SQLException, NoSuchMethodException, SecurityException, IllegalAccessException,
          IllegalArgumentException {}

  @Test
  public void testClosedJdbcConnection()
      throws SQLException, NoSuchMethodException, SecurityException, IllegalAccessException,
          IllegalArgumentException {
    testClosed(Connection.class, "getCatalog");
    testClosed(Connection.class, "getWarnings");
    testClosed(Connection.class, "clearWarnings");
    testClosed(Connection.class, "getHoldability");
    testClosed(Connection.class, "createClob");
    testClosed(Connection.class, "createBlob");
    testClosed(Connection.class, "createNClob");
    testClosed(Connection.class, "createSQLXML");
    testClosed(Connection.class, "getCatalog");
    testClosed(Connection.class, "getClientInfo");
    testClosed(Connection.class, "getSchema");
    testClosed(Connection.class, "getNetworkTimeout");

    testClosed(
        Connection.class, "setCatalog", new Class<?>[] {String.class}, new Object[] {"TEST"});
    testClosed(
        Connection.class,
        "prepareCall",
        new Class<?>[] {String.class, int.class, int.class},
        new Object[] {"TEST", 0, 0});
    testClosed(
        Connection.class,
        "prepareCall",
        new Class<?>[] {String.class, int.class, int.class, int.class},
        new Object[] {"TEST", 0, 0, 0});
    testClosed(
        Connection.class,
        "setClientInfo",
        new Class<?>[] {String.class, String.class},
        new Object[] {"TEST", "TEST"});
    testClosed(
        Connection.class, "setClientInfo", new Class<?>[] {Properties.class}, new Object[] {null});
    testClosed(
        Connection.class, "getClientInfo", new Class<?>[] {String.class}, new Object[] {"TEST"});
    testClosed(
        Connection.class,
        "createStruct",
        new Class<?>[] {String.class, Object[].class},
        new Object[] {"TEST", new Object[] {}});
    testClosed(Connection.class, "setSchema", new Class<?>[] {String.class}, new Object[] {"TEST"});
    testClosed(
        Connection.class,
        "setNetworkTimeout",
        new Class<?>[] {Executor.class, int.class},
        new Object[] {null, 0});

    testClosed(Connection.class, "getTypeMap");
    testClosed(Connection.class, "createStatement");
    testClosed(Connection.class, "getAutoCommit");
    testClosed(Connection.class, "commit");
    testClosed(Connection.class, "rollback");
    testClosed(Connection.class, "getMetaData");
    testClosed(Connection.class, "isReadOnly");
    testClosed(Connection.class, "getTransactionIsolation");
    testClosed(Connection.class, "setSavepoint");

    testClosed(
        Connection.class,
        "setTypeMap",
        new Class<?>[] {Map.class},
        new Object[] {Collections.EMPTY_MAP});
    testClosed(
        Connection.class, "prepareStatement", new Class<?>[] {String.class}, new Object[] {"TEST"});
    testClosed(
        Connection.class, "prepareCall", new Class<?>[] {String.class}, new Object[] {"TEST"});
    testClosed(Connection.class, "nativeSQL", new Class<?>[] {String.class}, new Object[] {"TEST"});
    testClosed(
        Connection.class, "prepareStatement", new Class<?>[] {String.class}, new Object[] {"TEST"});
    testClosed(
        Connection.class, "setAutoCommit", new Class<?>[] {boolean.class}, new Object[] {true});
    testClosed(
        Connection.class, "setReadOnly", new Class<?>[] {boolean.class}, new Object[] {true});
    testClosed(
        Connection.class, "setTransactionIsolation", new Class<?>[] {int.class}, new Object[] {0});
    testClosed(
        Connection.class,
        "createStatement",
        new Class<?>[] {int.class, int.class},
        new Object[] {0, 0});
    testClosed(
        Connection.class,
        "prepareStatement",
        new Class<?>[] {String.class, int.class, int.class},
        new Object[] {"TEST", 0, 0});
    testClosed(
        Connection.class,
        "createStatement",
        new Class<?>[] {int.class, int.class, int.class},
        new Object[] {0, 0, 0});
    testClosed(
        Connection.class,
        "prepareStatement",
        new Class<?>[] {String.class, int.class, int.class, int.class},
        new Object[] {"TEST", 0, 0, 0});
    testClosed(
        Connection.class,
        "prepareStatement",
        new Class<?>[] {String.class, int.class},
        new Object[] {"TEST", 0});
    testClosed(
        Connection.class,
        "prepareStatement",
        new Class<?>[] {String.class, int[].class},
        new Object[] {"TEST", new int[] {0}});
    testClosed(
        Connection.class,
        "prepareStatement",
        new Class<?>[] {String.class, String[].class},
        new Object[] {"TEST", new String[] {"COL1"}});
    testClosed(
        Connection.class,
        "createArrayOf",
        new Class<?>[] {String.class, Object[].class},
        new Object[] {"TEST", new Object[] {"COL1"}});

    testClosed(
        Connection.class, "setSavepoint", new Class<?>[] {String.class}, new Object[] {"TEST"});
    testClosed(Connection.class, "rollback", new Class<?>[] {Savepoint.class}, new Object[] {null});
    testClosed(
        Connection.class,
        "releaseSavepoint",
        new Class<?>[] {Savepoint.class},
        new Object[] {null});
  }

  private void testClosed(Class<? extends Connection> clazz, String name)
      throws NoSuchMethodException, SecurityException, SQLException, IllegalAccessException,
          IllegalArgumentException {
    testClosed(clazz, name, null, null);
  }

  private void testClosed(
      Class<? extends Connection> clazz, String name, Class<?>[] paramTypes, Object[] args)
      throws NoSuchMethodException, SecurityException, SQLException, IllegalAccessException,
          IllegalArgumentException {
    Method method = clazz.getDeclaredMethod(name, paramTypes);
    testInvokeMethodOnClosedConnection(method, args);
  }

  private void testInvokeMethodOnClosedConnection(Method method, Object... args)
      throws SQLException, IllegalAccessException, IllegalArgumentException {
    ConnectionOptions options = mock(ConnectionOptions.class);
    JdbcConnection connection = createConnection(options);
    connection.close();
    boolean valid = false;
    try {
      method.invoke(connection, args);
    } catch (InvocationTargetException e) {
      if (e.getTargetException() instanceof JdbcSqlException
          && ((JdbcSqlException) e.getTargetException()).getCode() == Code.FAILED_PRECONDITION
          && ((JdbcSqlException) e.getTargetException()).getMessage().endsWith("has been closed")) {
        // this is the expected exception
        valid = true;
      }
    }
    assertThat(
        "Method did not throw exception on closed connection: " + method.getName(),
        valid,
        is(true));
  }

  @Test
  public void testTransactionIsolation() throws SQLException {
    ConnectionOptions options = mock(ConnectionOptions.class);
    try (JdbcConnection connection = createConnection(options)) {
      assertThat(
          connection.getTransactionIsolation(), is(equalTo(Connection.TRANSACTION_SERIALIZABLE)));
      // assert that setting it to this value is ok.
      connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
      // assert that setting it to something else is not ok.
      int[] settings =
          new int[] {
            Connection.TRANSACTION_READ_COMMITTED,
            Connection.TRANSACTION_READ_UNCOMMITTED,
            Connection.TRANSACTION_REPEATABLE_READ,
            -100
          };
      for (int setting : settings) {
        boolean exception = false;
        try {
          connection.setTransactionIsolation(setting);
        } catch (SQLException e) {
          if (setting == -100) {
            exception =
                (e instanceof JdbcSqlException
                    && ((JdbcSqlException) e).getCode() == Code.INVALID_ARGUMENT);
          } else {
            exception =
                (e instanceof JdbcSqlException
                    && ((JdbcSqlException) e).getCode() == Code.UNIMPLEMENTED);
          }
        }
        assertThat(exception, is(true));
      }
    }
  }

  @Test
  public void testHoldability() throws SQLException {
    ConnectionOptions options = mock(ConnectionOptions.class);
    try (JdbcConnection connection = createConnection(options)) {
      assertThat(connection.getHoldability(), is(equalTo(ResultSet.CLOSE_CURSORS_AT_COMMIT)));
      // assert that setting it to this value is ok.
      connection.setHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT);
      // assert that setting it to something else is not ok.
      int[] settings = new int[] {ResultSet.HOLD_CURSORS_OVER_COMMIT, -100};
      for (int setting : settings) {
        boolean exception = false;
        try {
          connection.setHoldability(setting);
        } catch (SQLException e) {
          if (setting == -100) {
            exception =
                (e instanceof JdbcSqlException
                    && ((JdbcSqlException) e).getCode() == Code.INVALID_ARGUMENT);
          } else {
            exception =
                (e instanceof JdbcSqlException
                    && ((JdbcSqlException) e).getCode() == Code.UNIMPLEMENTED);
          }
        }
        assertThat(exception, is(true));
      }
    }
  }

  @Test
  public void testWarnings() throws SQLException {
    ConnectionOptions options = mock(ConnectionOptions.class);
    try (JdbcConnection connection = createConnection(options)) {
      assertThat(connection.getWarnings(), is(nullValue()));

      // Push one warning and get it twice.
      connection.pushWarning(new SQLWarning("test"));
      assertThat(connection.getWarnings().getMessage(), is(equalTo("test")));
      assertThat(connection.getWarnings().getMessage(), is(equalTo("test")));

      // Clear warnings and push two warnings and get them both.
      connection.clearWarnings();
      connection.pushWarning(new SQLWarning("test 1"));
      connection.pushWarning(new SQLWarning("test 2"));
      assertThat(connection.getWarnings().getMessage(), is(equalTo("test 1")));
      assertThat(connection.getWarnings().getMessage(), is(equalTo("test 1")));
      assertThat(connection.getWarnings().getNextWarning().getMessage(), is(equalTo("test 2")));

      // Clear warnings.
      connection.clearWarnings();
      assertThat(connection.getWarnings(), is(nullValue()));
    }
  }

  @Test
  public void testSetClientInfo() throws SQLException {
    ConnectionOptions options = mock(ConnectionOptions.class);
    try (JdbcConnection connection = createConnection(options)) {
      assertThat(connection.getWarnings(), is(nullValue()));
      connection.setClientInfo("test", "foo");
      assertThat(connection.getWarnings(), is(notNullValue()));
      assertThat(
          connection.getWarnings().getMessage(),
          is(equalTo(AbstractJdbcConnection.CLIENT_INFO_NOT_SUPPORTED)));

      connection.clearWarnings();
      assertThat(connection.getWarnings(), is(nullValue()));

      Properties props = new Properties();
      props.setProperty("test", "foo");
      connection.setClientInfo(props);
      assertThat(connection.getWarnings(), is(notNullValue()));
      assertThat(
          connection.getWarnings().getMessage(),
          is(equalTo(AbstractJdbcConnection.CLIENT_INFO_NOT_SUPPORTED)));
    }
  }
}
