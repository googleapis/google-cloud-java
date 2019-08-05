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

import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.jdbc.StatementResult.ClientSideStatementType;
import com.google.rpc.Code;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

/** Base class for Cloud Spanner JDBC {@link Statement}s */
abstract class AbstractJdbcStatement extends AbstractJdbcWrapper implements Statement {
  private static final String CURSORS_NOT_SUPPORTED = "Cursors are not supported";
  private static final String ONLY_FETCH_FORWARD_SUPPORTED = "Only fetch_forward is supported";
  private boolean closed;
  private boolean closeOnCompletion;
  private boolean poolable;
  private final JdbcConnection connection;
  private int queryTimeout;

  AbstractJdbcStatement(JdbcConnection connection) {
    this.connection = connection;
  }

  @Override
  public JdbcConnection getConnection() {
    return connection;
  }

  private Options.QueryOption[] getQueryOptions() throws SQLException {
    if (getFetchSize() > 0) {
      return new Options.ReadAndQueryOption[] {Options.prefetchChunks(getFetchSize())};
    }
    return new QueryOption[0];
  }

  /** The {@link TimeUnit}s that are supported for timeout and staleness durations */
  private static final TimeUnit[] SUPPORTED_UNITS =
      new TimeUnit[] {
        TimeUnit.SECONDS, TimeUnit.MILLISECONDS, TimeUnit.MICROSECONDS, TimeUnit.NANOSECONDS
      };

  /**
   * Get the {@link TimeUnit} with the least precision that is able to represent the timeout of this
   * statement.
   */
  private TimeUnit getAppropriateTimeUnit() {
    int index = 0;
    if (connection.getSpannerConnection().hasStatementTimeout()) {
      for (TimeUnit unit : SUPPORTED_UNITS) {
        long duration = connection.getSpannerConnection().getStatementTimeout(unit);
        if (index + 1 < SUPPORTED_UNITS.length) {
          if (duration > 0L
              && duration * 1000
                  == connection
                      .getSpannerConnection()
                      .getStatementTimeout(SUPPORTED_UNITS[index + 1])) {
            return unit;
          }
        } else {
          // last unit, we have to use this one
          return unit;
        }
        index++;
      }
      throw new IllegalStateException("Unsupported duration");
    }
    return null;
  }

  /**
   * Local class to temporarily hold the statement timeout of the Spanner {@link Connection}. The
   * Spanner connection API sets the timeout on the connection and applies it to all statements that
   * are executed on the {@link Connection}. JDBC specifies a timeout per statement, so we need to
   * temporarily hold on to the timeout specified for the connection while using the timeout
   * specified for a JDBC statement, and then after executing the JDBC statement setting the timeout
   * on the Spanner {@link Connection} again.
   */
  private static class StatementTimeout {
    private final long timeout;
    private final TimeUnit unit;

    private static StatementTimeout of(long timeout, TimeUnit unit) {
      return new StatementTimeout(timeout, unit);
    }

    private StatementTimeout(long timeout, TimeUnit unit) {
      this.timeout = timeout;
      this.unit = unit;
    }
  }

  /**
   * Sets the statement timeout of the Spanner {@link Connection} to the query timeout of this JDBC
   * {@link Statement} and returns the original timeout of the Spanner {@link Connection} so it can
   * be reset after the execution of a statement
   */
  private StatementTimeout setTemporaryStatementTimeout() throws SQLException {
    StatementTimeout originalTimeout = null;
    if (getQueryTimeout() > 0) {
      if (connection.getSpannerConnection().hasStatementTimeout()) {
        TimeUnit unit = getAppropriateTimeUnit();
        originalTimeout =
            StatementTimeout.of(connection.getSpannerConnection().getStatementTimeout(unit), unit);
      }
      connection.getSpannerConnection().setStatementTimeout(getQueryTimeout(), TimeUnit.SECONDS);
    }
    return originalTimeout;
  }

  /**
   * Resets the statement timeout of the Spanner {@link Connection} after a JDBC {@link Statement}
   * has been executed.
   */
  private void resetStatementTimeout(StatementTimeout originalTimeout) throws SQLException {
    if (getQueryTimeout() > 0) {
      if (originalTimeout == null) {
        connection.getSpannerConnection().clearStatementTimeout();
      } else {
        connection
            .getSpannerConnection()
            .setStatementTimeout(originalTimeout.timeout, originalTimeout.unit);
      }
    }
  }

  /**
   * Executes a SQL statement on the connection of this {@link Statement} as a query.
   *
   * @param statement The SQL statement to executed.
   * @return the result of the SQL statement as a {@link ResultSet}.
   * @throws SQLException if a database error occurs.
   */
  ResultSet executeQuery(com.google.cloud.spanner.Statement statement) throws SQLException {
    StatementTimeout originalTimeout = setTemporaryStatementTimeout();
    try {
      return JdbcResultSet.of(
          this, connection.getSpannerConnection().executeQuery(statement, getQueryOptions()));
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    } finally {
      resetStatementTimeout(originalTimeout);
    }
  }

  /**
   * Executes a SQL statement on the connection of this {@link Statement} as an update (DML)
   * statement.
   *
   * @param statement The SQL statement to execute.
   * @return the number of rows that was inserted/updated/deleted.
   * @throws SQLException if a database error occurs, or if the number of rows affected is larger
   *     than {@link Integer#MAX_VALUE}.
   */
  int executeUpdate(com.google.cloud.spanner.Statement statement) throws SQLException {
    StatementTimeout originalTimeout = setTemporaryStatementTimeout();
    try {
      long count = connection.getSpannerConnection().executeUpdate(statement);
      if (count > Integer.MAX_VALUE) {
        throw JdbcSqlExceptionFactory.of(
            "update count too large for executeUpdate: " + count, Code.OUT_OF_RANGE);
      }
      return (int) count;
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    } finally {
      resetStatementTimeout(originalTimeout);
    }
  }

  /**
   * Executes a SQL statement on the connection of this {@link Statement}. The SQL statement can be
   * any supported SQL statement, including client side statements such as SET AUTOCOMMIT ON|OFF.
   *
   * @param statement The SQL statement to execute.
   * @return a {@link StatementResult} containing either a {@link ResultSet}, an update count or
   *     nothing depending on the type of SQL statement.
   * @throws SQLException if a database error occurs.
   */
  StatementResult execute(com.google.cloud.spanner.Statement statement) throws SQLException {
    StatementTimeout originalTimeout = setTemporaryStatementTimeout();
    boolean mustResetTimeout = false;
    try {
      StatementResult result = connection.getSpannerConnection().execute(statement);
      mustResetTimeout = !resultIsSetStatementTimeout(result);
      if (mustResetTimeout && resultIsShowStatementTimeout(result)) {
        // it was a 'SHOW STATEMENT_TIMEOUT statement, we need to re-run to get the correct value
        mustResetTimeout = false;
        result = rerunShowStatementTimeout(statement, result, originalTimeout);
      }
      return result;
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    } finally {
      if (mustResetTimeout) {
        resetStatementTimeout(originalTimeout);
      }
    }
  }

  /**
   * The Spanner Connection API sets the statement timeout on a {@link Connection}. JDBC on the
   * other hand sets this on the {@link Statement} object. This means that when a JDBC statement has
   * a query timeout set, we need to temporarily set the statement timeout on the underlying Spanner
   * {@link Connection}, then execute the actual statement, and then reset the timeout on the
   * Spanner connection. But if the executed statement was a SHOW STATEMENT_TIMEOUT or SET
   * STATEMENT_TIMEOUT, then we need to handle it differently:
   *
   * <ul>
   *   <li>SHOW STATEMENT_TIMEOUT: Reset the statement timeout on the {@link Connection} to the
   *       original value and re-run the statement
   *   <li>SET STATEMENT_TIMEOUT: Do not reset the statement timeout on the {@link Connection} after
   *       the execution
   * </ul>
   *
   * @param result The result of a statement that was executed.
   * @return <code>true</code> if the {@link StatementResult} indicates that the statement that was
   *     executed was a SET STATEMENT_TIMEOUT statement.
   */
  private boolean resultIsSetStatementTimeout(StatementResult result) {
    return result.getClientSideStatementType() == ClientSideStatementType.SET_STATEMENT_TIMEOUT;
  }

  private boolean resultIsShowStatementTimeout(StatementResult result) {
    return result.getClientSideStatementType() == ClientSideStatementType.SHOW_STATEMENT_TIMEOUT;
  }

  private StatementResult rerunShowStatementTimeout(
      com.google.cloud.spanner.Statement statement,
      StatementResult result,
      StatementTimeout originalTimeout)
      throws SQLException {
    resetStatementTimeout(originalTimeout);
    return connection.getSpannerConnection().execute(statement);
  }

  @Override
  public int getQueryTimeout() throws SQLException {
    checkClosed();
    return queryTimeout;
  }

  @Override
  public void setQueryTimeout(int seconds) throws SQLException {
    checkClosed();
    this.queryTimeout = seconds;
  }

  @Override
  public void cancel() throws SQLException {
    checkClosed();
    connection.getSpannerConnection().cancel();
  }

  @Override
  public void close() throws SQLException {
    this.closed = true;
  }

  @Override
  public boolean isClosed() throws SQLException {
    return closed;
  }

  @Override
  public void setPoolable(boolean poolable) throws SQLException {
    checkClosed();
    this.poolable = poolable;
  }

  @Override
  public boolean isPoolable() throws SQLException {
    checkClosed();
    return poolable;
  }

  @Override
  public void closeOnCompletion() throws SQLException {
    checkClosed();
    this.closeOnCompletion = true;
  }

  @Override
  public boolean isCloseOnCompletion() throws SQLException {
    checkClosed();
    return closeOnCompletion;
  }

  @Override
  public int getMaxFieldSize() throws SQLException {
    checkClosed();
    return 0;
  }

  @Override
  public void setMaxFieldSize(int max) throws SQLException {
    checkClosed();
  }

  @Override
  public int getMaxRows() throws SQLException {
    checkClosed();
    return 0;
  }

  @Override
  public void setMaxRows(int max) throws SQLException {
    checkClosed();
  }

  @Override
  public void setEscapeProcessing(boolean enable) throws SQLException {
    checkClosed();
  }

  @Override
  public SQLWarning getWarnings() throws SQLException {
    checkClosed();
    return null;
  }

  @Override
  public void clearWarnings() throws SQLException {
    checkClosed();
  }

  @Override
  public void setCursorName(String name) throws SQLException {
    throw JdbcSqlExceptionFactory.unsupported(CURSORS_NOT_SUPPORTED);
  }

  @Override
  public void setFetchDirection(int direction) throws SQLException {
    if (direction != ResultSet.FETCH_FORWARD) {
      throw JdbcSqlExceptionFactory.unsupported(ONLY_FETCH_FORWARD_SUPPORTED);
    }
  }

  @Override
  public int getFetchDirection() throws SQLException {
    return ResultSet.FETCH_FORWARD;
  }

  @Override
  public int getResultSetConcurrency() throws SQLException {
    return ResultSet.CONCUR_READ_ONLY;
  }

  @Override
  public int getResultSetType() throws SQLException {
    return ResultSet.TYPE_FORWARD_ONLY;
  }

  @Override
  public int getResultSetHoldability() throws SQLException {
    return ResultSet.CLOSE_CURSORS_AT_COMMIT;
  }
}
