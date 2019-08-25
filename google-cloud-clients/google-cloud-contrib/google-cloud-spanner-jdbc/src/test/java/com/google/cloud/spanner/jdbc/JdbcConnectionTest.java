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
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcSqlExceptionImpl;
import com.google.rpc.Code;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.util.Arrays;
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
  private static final com.google.cloud.spanner.ResultSet SELECT1_RESULTSET =
      ResultSets.forRows(
          Type.struct(StructField.of("", Type.int64())),
          Arrays.asList(Struct.newBuilder().set("").to(1L).build()));

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

  @Test
  public void testIsValid() throws SQLException {
    // Setup.
    ConnectionOptions options = mock(ConnectionOptions.class);
    com.google.cloud.spanner.jdbc.Connection spannerConnection =
        mock(com.google.cloud.spanner.jdbc.Connection.class);
    when(options.getConnection()).thenReturn(spannerConnection);
    Statement statement = Statement.of(JdbcConnection.IS_VALID_QUERY);

    // Verify that an opened connection that returns a result set is valid.
    try (JdbcConnection connection = new JdbcConnection("url", options)) {
      when(spannerConnection.executeQuery(statement)).thenReturn(SELECT1_RESULTSET);
      assertThat(connection.isValid(1), is(true));
      try {
        // Invalid timeout value.
        connection.isValid(-1);
        fail("missing expected exception");
      } catch (JdbcSqlExceptionImpl e) {
        assertThat(e.getCode(), is(equalTo(Code.INVALID_ARGUMENT)));
      }

      // Now let the query return an error. isValid should now return false.
      when(spannerConnection.executeQuery(statement))
          .thenThrow(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.ABORTED, "the current transaction has been aborted"));
      assertThat(connection.isValid(1), is(false));
    }
  }

  @Test
  public void testIsValidOnClosedConnection() throws SQLException {
    Connection connection = createConnection(mock(ConnectionOptions.class));
    connection.close();
    assertThat(connection.isValid(1), is(false));
  }

  @Test
  public void testCreateStatement() throws SQLException {
    try (JdbcConnection connection = createConnection(mock(ConnectionOptions.class))) {
      for (int resultSetType :
          new int[] {
            ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.TYPE_SCROLL_SENSITIVE
          }) {
        for (int resultSetConcurrency :
            new int[] {ResultSet.CONCUR_READ_ONLY, ResultSet.CONCUR_UPDATABLE}) {
          if (resultSetType == ResultSet.TYPE_FORWARD_ONLY // Only FORWARD_ONLY is supported
              && resultSetConcurrency == ResultSet.CONCUR_READ_ONLY) // Only READ_ONLY is supported
          {
            java.sql.Statement statement =
                connection.createStatement(resultSetType, resultSetConcurrency);
            assertThat(statement.getResultSetType(), is(equalTo(resultSetType)));
            assertThat(statement.getResultSetConcurrency(), is(equalTo(resultSetConcurrency)));
          } else {
            assertCreateStatementFails(connection, resultSetType, resultSetConcurrency);
          }
          for (int resultSetHoldability :
              new int[] {ResultSet.CLOSE_CURSORS_AT_COMMIT, ResultSet.HOLD_CURSORS_OVER_COMMIT}) {
            if (resultSetType == ResultSet.TYPE_FORWARD_ONLY // Only FORWARD_ONLY is supported
                && resultSetConcurrency == ResultSet.CONCUR_READ_ONLY // Only READ_ONLY is supported
                && resultSetHoldability
                    == ResultSet
                        .CLOSE_CURSORS_AT_COMMIT) // Only CLOSE_CURSORS_AT_COMMIT is supported
            {
              java.sql.Statement statement =
                  connection.createStatement(
                      resultSetType, resultSetConcurrency, resultSetHoldability);
              assertThat(statement.getResultSetType(), is(equalTo(resultSetType)));
              assertThat(statement.getResultSetConcurrency(), is(equalTo(resultSetConcurrency)));
              assertThat(statement.getResultSetHoldability(), is(equalTo(resultSetHoldability)));
            } else {
              assertCreateStatementFails(
                  connection, resultSetType, resultSetConcurrency, resultSetHoldability);
            }
          }
        }
      }
    }
  }

  private void assertCreateStatementFails(
      JdbcConnection connection,
      int resultSetType,
      int resultSetConcurrency,
      int resultSetHoldability)
      throws SQLException {
    try {
      connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
      fail(
          String.format(
              "missing expected exception for %d %d %d",
              resultSetType, resultSetConcurrency, resultSetHoldability));
    } catch (SQLFeatureNotSupportedException e) {
      // ignore, this is the expected exception.
    }
  }

  private void assertCreateStatementFails(
      JdbcConnection connection, int resultSetType, int resultSetConcurrency) throws SQLException {
    try {
      connection.createStatement(resultSetType, resultSetConcurrency);
      fail(
          String.format(
              "missing expected exception for %d %d", resultSetType, resultSetConcurrency));
    } catch (SQLFeatureNotSupportedException e) {
      // ignore, this is the expected exception.
    }
  }

  @Test
  public void testPrepareStatement() throws SQLException {
    try (JdbcConnection connection = createConnection(mock(ConnectionOptions.class))) {
      for (int resultSetType :
          new int[] {
            ResultSet.TYPE_FORWARD_ONLY,
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.TYPE_SCROLL_SENSITIVE
          }) {
        for (int resultSetConcurrency :
            new int[] {ResultSet.CONCUR_READ_ONLY, ResultSet.CONCUR_UPDATABLE}) {
          if (resultSetType == ResultSet.TYPE_FORWARD_ONLY // Only FORWARD_ONLY is supported
              && resultSetConcurrency == ResultSet.CONCUR_READ_ONLY) // Only READ_ONLY is supported
          {
            PreparedStatement ps =
                connection.prepareStatement("SELECT 1", resultSetType, resultSetConcurrency);
            assertThat(ps.getResultSetType(), is(equalTo(resultSetType)));
            assertThat(ps.getResultSetConcurrency(), is(equalTo(resultSetConcurrency)));
          } else {
            assertPrepareStatementFails(connection, resultSetType, resultSetConcurrency);
          }
          for (int resultSetHoldability :
              new int[] {ResultSet.CLOSE_CURSORS_AT_COMMIT, ResultSet.HOLD_CURSORS_OVER_COMMIT}) {
            if (resultSetType == ResultSet.TYPE_FORWARD_ONLY // Only FORWARD_ONLY is supported
                && resultSetConcurrency == ResultSet.CONCUR_READ_ONLY // Only READ_ONLY is supported
                && resultSetHoldability
                    == ResultSet
                        .CLOSE_CURSORS_AT_COMMIT) // Only CLOSE_CURSORS_AT_COMMIT is supported
            {
              PreparedStatement ps =
                  connection.prepareStatement(
                      "SELECT 1", resultSetType, resultSetConcurrency, resultSetHoldability);
              assertThat(ps.getResultSetType(), is(equalTo(resultSetType)));
              assertThat(ps.getResultSetConcurrency(), is(equalTo(resultSetConcurrency)));
              assertThat(ps.getResultSetHoldability(), is(equalTo(resultSetHoldability)));
            } else {
              assertPrepareStatementFails(
                  connection, resultSetType, resultSetConcurrency, resultSetHoldability);
            }
          }
        }
      }
    }
  }

  private void assertPrepareStatementFails(
      JdbcConnection connection,
      int resultSetType,
      int resultSetConcurrency,
      int resultSetHoldability)
      throws SQLException {
    try {
      connection.prepareStatement(
          "SELECT 1", resultSetType, resultSetConcurrency, resultSetHoldability);
      fail(
          String.format(
              "missing expected exception for %d %d %d",
              resultSetType, resultSetConcurrency, resultSetHoldability));
    } catch (SQLFeatureNotSupportedException e) {
      // ignore, this is the expected exception.
    }
  }

  private void assertPrepareStatementFails(
      JdbcConnection connection, int resultSetType, int resultSetConcurrency) throws SQLException {
    try {
      connection.prepareStatement("SELECT 1", resultSetType, resultSetConcurrency);
      fail(
          String.format(
              "missing expected exception for %d %d", resultSetType, resultSetConcurrency));
    } catch (SQLFeatureNotSupportedException e) {
      // ignore, this is the expected exception.
    }
  }

  @Test
  public void testPrepareStatementWithAutoGeneratedKeys() throws SQLException {
    String sql = "INSERT INTO FOO (COL1) VALUES (?)";
    try (JdbcConnection connection = createConnection(mock(ConnectionOptions.class))) {
      PreparedStatement statement =
          connection.prepareStatement(sql, java.sql.Statement.NO_GENERATED_KEYS);
      ResultSet rs = statement.getGeneratedKeys();
      assertThat(rs.next(), is(false));
      try {
        statement = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
        fail("missing expected SQLFeatureNotSupportedException");
      } catch (SQLFeatureNotSupportedException e) {
        // ignore, this is the expected exception.
      }
    }
  }

  @Test
  public void testCatalog() throws SQLException {
    ConnectionOptions options = mock(ConnectionOptions.class);
    when(options.getDatabaseName()).thenReturn("test");
    try (JdbcConnection connection = createConnection(options)) {
      assertThat(connection.getCatalog(), is(equalTo("test")));
      // This should be allowed.
      connection.setCatalog("");
      try {
        // This should cause an exception.
        connection.setCatalog("other");
        fail("missing expected exception");
      } catch (JdbcSqlExceptionImpl e) {
        assertThat(e.getCode(), is(equalTo(Code.INVALID_ARGUMENT)));
      }
    }
  }

  @Test
  public void testSchema() throws SQLException {
    try (JdbcConnection connection = createConnection(mock(ConnectionOptions.class))) {
      assertThat(connection.getSchema(), is(equalTo("")));
      // This should be allowed.
      connection.setSchema("");
      try {
        // This should cause an exception.
        connection.setSchema("other");
        fail("missing expected exception");
      } catch (JdbcSqlExceptionImpl e) {
        assertThat(e.getCode(), is(equalTo(Code.INVALID_ARGUMENT)));
      }
    }
  }
}
