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

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.connection.AbstractStatementParser;
import com.google.cloud.spanner.connection.Connection;
import com.google.cloud.spanner.connection.StatementResult;
import com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Stopwatch;
import com.google.rpc.Code;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nonnull;

/** Base class for Cloud Spanner JDBC {@link Statement}s */
abstract class AbstractJdbcStatement extends AbstractJdbcWrapper implements Statement {
  private static final String CURSORS_NOT_SUPPORTED = "Cursors are not supported";
  private static final String ONLY_FETCH_FORWARD_SUPPORTED = "Only fetch_forward is supported";
  final AbstractStatementParser parser;
  private final Lock executingLock;
  private volatile Thread executingThread;
  private final AtomicBoolean cancelled = new AtomicBoolean();
  private boolean closed;
  private boolean closeOnCompletion;
  private boolean poolable;
  private final JdbcConnection connection;
  private Duration queryTimeout = Duration.ZERO;

  AbstractJdbcStatement(JdbcConnection connection) throws SQLException {
    this.connection = connection;
    this.parser = connection.getParser();
    if (connection.usesDirectExecutor()) {
      this.executingLock = new ReentrantLock();
    } else {
      this.executingLock = null;
    }
  }

  @Override
  public JdbcConnection getConnection() {
    return connection;
  }

  private Options.QueryOption[] getQueryOptions(QueryOption... options) throws SQLException {
    QueryOption[] res = options == null ? new QueryOption[0] : options;
    if (getFetchSize() > 0) {
      res = Arrays.copyOf(res, res.length + 1);
      res[res.length - 1] = Options.prefetchChunks(getFetchSize());
    }
    return res;
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
  static class StatementTimeout {
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

  /** Functional interface that throws {@link SQLException}. */
  interface JdbcFunction<T, R> {
    R apply(T t) throws SQLException;
  }

  /** Runs the given function with the timeout that has been set on this statement. */
  protected <T> T runWithStatementTimeout(JdbcFunction<Connection, T> function)
      throws SQLException {
    checkClosed();
    StatementTimeout originalTimeout = setTemporaryStatementTimeout();
    try {
      return function.apply(getConnection().getSpannerConnection());
    } catch (SpannerException spannerException) {
      throw JdbcSqlExceptionFactory.of(spannerException);
    } finally {
      resetStatementTimeout(originalTimeout);
    }
  }

  /**
   * Sets the statement timeout of the Spanner {@link Connection} to the query timeout of this JDBC
   * {@link Statement} and returns the original timeout of the Spanner {@link Connection} so it can
   * be reset after the execution of a statement
   */
  StatementTimeout setTemporaryStatementTimeout() throws SQLException {
    StatementTimeout originalTimeout = null;
    if (!getQueryTimeoutDuration().isZero()) {
      if (connection.getSpannerConnection().hasStatementTimeout()) {
        TimeUnit unit = getAppropriateTimeUnit();
        originalTimeout =
            StatementTimeout.of(connection.getSpannerConnection().getStatementTimeout(unit), unit);
      }
      Duration queryTimeout = getQueryTimeoutDuration();
      if (queryTimeout.getNano() > 0) {
        connection
            .getSpannerConnection()
            .setStatementTimeout(queryTimeout.toMillis(), TimeUnit.MILLISECONDS);
      } else {
        connection
            .getSpannerConnection()
            .setStatementTimeout(queryTimeout.getSeconds(), TimeUnit.SECONDS);
      }
    }
    return originalTimeout;
  }

  /**
   * Resets the statement timeout of the Spanner {@link Connection} after a JDBC {@link Statement}
   * has been executed.
   */
  void resetStatementTimeout(StatementTimeout originalTimeout) throws SQLException {
    if (!getQueryTimeoutDuration().isZero()) {
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
   * Executes a SQL statement on the connection of this {@link Statement} as a query using the given
   * {@link QueryAnalyzeMode}.
   *
   * @param statement the SQL statement to executed
   * @param analyzeMode the {@link QueryAnalyzeMode} to use
   * @return the result of the SQL statement as a {@link ResultSet}
   * @throws SQLException if a database error occurs.
   */
  ResultSet analyzeQuery(com.google.cloud.spanner.Statement statement, QueryAnalyzeMode analyzeMode)
      throws SQLException {
    return executeQuery(statement, analyzeMode);
  }

  /**
   * Executes a SQL statement on the connection of this {@link Statement} as a query.
   *
   * @param statement The SQL statement to executed.
   * @param options {@link QueryOption}s that should be applied to the query.
   * @return the result of the SQL statement as a {@link ResultSet}.
   * @throws SQLException if a database error occurs.
   */
  ResultSet executeQuery(com.google.cloud.spanner.Statement statement, QueryOption... options)
      throws SQLException {
    return executeQuery(statement, null, options);
  }

  private ResultSet executeQuery(
      com.google.cloud.spanner.Statement statement,
      QueryAnalyzeMode analyzeMode,
      QueryOption... options)
      throws SQLException {
    Options.QueryOption[] queryOptions = getQueryOptions(options);
    return doWithStatementTimeout(
        () -> {
          com.google.cloud.spanner.ResultSet resultSet;
          if (analyzeMode == null) {
            resultSet = connection.getSpannerConnection().executeQuery(statement, queryOptions);
          } else {
            resultSet = connection.getSpannerConnection().analyzeQuery(statement, analyzeMode);
          }
          return JdbcResultSet.of(this, resultSet);
        });
  }

  private <T> T doWithStatementTimeout(Supplier<T> runnable) throws SQLException {
    return doWithStatementTimeout(runnable, ignore -> Boolean.TRUE);
  }

  private <T> T doWithStatementTimeout(
      Supplier<T> runnable, Function<T, Boolean> shouldResetTimeout) throws SQLException {
    StatementTimeout originalTimeout = setTemporaryStatementTimeout();
    T result = null;
    if (this.executingLock != null) {
      this.executingLock.lock();
      this.executingThread = Thread.currentThread();
    }
    try {
      Stopwatch stopwatch = Stopwatch.createStarted();
      result = runnable.get();
      Duration executionDuration = stopwatch.elapsed();
      connection.recordClientLibLatencyMetric(executionDuration.toMillis());
      return result;
    } catch (SpannerException spannerException) {
      if (this.cancelled.get()
          && spannerException.getErrorCode() == ErrorCode.CANCELLED
          && this.executingLock != null) {
        // Clear the interrupted flag of the thread.
        //noinspection ResultOfMethodCallIgnored
        Thread.interrupted();
      }
      throw JdbcSqlExceptionFactory.of(spannerException);
    } finally {
      if (this.executingLock != null) {
        this.executingThread = null;
        this.cancelled.set(false);
        this.executingLock.unlock();
      }
      if (shouldResetTimeout.apply(result)) {
        resetStatementTimeout(originalTimeout);
      }
    }
  }

  /**
   * Do a checked cast from long to int. Throws a {@link SQLException} with code {@link
   * Code#OUT_OF_RANGE} if the update count is too big to fit in an int.
   */
  int checkedCast(long updateCount) throws SQLException {
    if (updateCount > Integer.MAX_VALUE) {
      throw JdbcSqlExceptionFactory.of(
          "update count too large for executeUpdate: " + updateCount, Code.OUT_OF_RANGE);
    }
    return (int) updateCount;
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
    StatementResult statementResult =
        doWithStatementTimeout(
            () -> connection.getSpannerConnection().execute(statement),
            result -> !resultIsSetStatementTimeout(result));
    if (resultIsShowStatementTimeout(statementResult)) {
      // We can safely re-run it without first resetting the timeout to the original value, as that
      // has already been done by the 'doWithStatementTimeout' function.
      return rerunShowStatementTimeout(statement);
    }
    return statementResult;
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
    return result != null
        && result.getClientSideStatementType() == ClientSideStatementType.SET_STATEMENT_TIMEOUT;
  }

  private boolean resultIsShowStatementTimeout(StatementResult result) {
    return result != null
        && result.getClientSideStatementType() == ClientSideStatementType.SHOW_STATEMENT_TIMEOUT;
  }

  private StatementResult rerunShowStatementTimeout(com.google.cloud.spanner.Statement statement)
      throws SQLException {
    try {
      return connection.getSpannerConnection().execute(statement);
    } catch (SpannerException spannerException) {
      throw JdbcSqlExceptionFactory.of(spannerException);
    }
  }

  @Override
  public int getQueryTimeout() throws SQLException {
    return (int) getQueryTimeoutDuration().getSeconds();
  }

  @VisibleForTesting
  @Nonnull
  Duration getQueryTimeoutDuration() throws SQLException {
    checkClosed();
    return this.queryTimeout;
  }

  @Override
  public void setQueryTimeout(int seconds) throws SQLException {
    setQueryTimeout(Duration.ofSeconds(seconds));
  }

  @VisibleForTesting
  void setQueryTimeout(@Nonnull Duration duration) throws SQLException {
    JdbcPreconditions.checkArgument(!duration.isNegative(), "Timeout must be >= 0");
    checkClosed();
    this.queryTimeout = duration;
  }

  @Override
  public void cancel() throws SQLException {
    checkClosed();
    if (this.executingThread != null) {
      // This is a best-effort operation. It could be that the executing thread is set to null
      // between the if-check and the actual execution. Just ignore if that happens.
      try {
        this.cancelled.set(true);
        this.executingThread.interrupt();
      } catch (NullPointerException ignore) {
        // ignore, this just means that the execution finished before we got to the point where we
        // could interrupt the thread.
      } catch (SecurityException securityException) {
        throw JdbcSqlExceptionFactory.of(
            securityException.getMessage(), Code.PERMISSION_DENIED, securityException);
      }
    } else {
      connection.getSpannerConnection().cancel();
    }
  }

  @Override
  public void close() throws SQLException {
    this.closed = true;
  }

  @Override
  public boolean isClosed() {
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
  public long getLargeMaxRows() throws SQLException {
    checkClosed();
    return 0L;
  }

  @Override
  public void setMaxRows(int max) throws SQLException {
    checkClosed();
  }

  @Override
  public void setLargeMaxRows(long max) throws SQLException {
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
  public int getFetchDirection() {
    return ResultSet.FETCH_FORWARD;
  }

  @Override
  public int getResultSetConcurrency() {
    return ResultSet.CONCUR_READ_ONLY;
  }

  @Override
  public int getResultSetType() {
    return ResultSet.TYPE_FORWARD_ONLY;
  }

  @Override
  public int getResultSetHoldability() {
    return ResultSet.CLOSE_CURSORS_AT_COMMIT;
  }
}
