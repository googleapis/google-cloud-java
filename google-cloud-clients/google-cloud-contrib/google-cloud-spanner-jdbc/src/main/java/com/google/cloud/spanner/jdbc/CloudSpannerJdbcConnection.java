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

import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.jdbc.StatementResult.ResultType;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * JDBC connection with a number of additional Cloud Spanner specific methods. JDBC connections that
 * are returned by the Cloud Spanner {@link JdbcDriver} will implement this interface.
 *
 * <p>Calling {@link Connection#unwrap(Class)} with {@link CloudSpannerJdbcConnection#getClass()} as
 * input on a {@link Connection} returned by the Cloud Spanner JDBC Driver will return a {@link
 * CloudSpannerJdbcConnection} instance.
 */
public interface CloudSpannerJdbcConnection extends Connection {

  /**
   * @return the commit {@link Timestamp} of the last read/write transaction. If the last
   *     transaction was not a read/write transaction, or a read/write transaction that did not
   *     return a commit timestamp because the transaction was not committed, the method will throw
   *     a {@link SQLException}.
   */
  Timestamp getCommitTimestamp() throws SQLException;

  /**
   * @return the read {@link Timestamp} of the last read-only transaction. If the last transaction
   *     was not a read-only transaction, or a read-only transaction that did not return a read
   *     timestamp because no data was read, the method will throw a {@link SQLException}.
   */
  Timestamp getReadTimestamp() throws SQLException;

  /**
   * @return <code>true</code> if this connection will automatically retry read/write transactions
   *     that abort. This method may only be called when the connection is in read/write
   *     transactional mode and no transaction has been started yet.
   */
  boolean isRetryAbortsInternally() throws SQLException;

  /**
   * Sets whether this connection will internally retry read/write transactions that abort. The
   * default is <code>true</code>. When internal retry is enabled, the {@link Connection} will keep
   * track of a running SHA256 checksum of all {@link ResultSet}s that have been returned from Cloud
   * Spanner. If the checksum that is calculated during an internal retry differs from the original
   * checksum, the transaction will abort with an {@link
   * AbortedDueToConcurrentModificationException}.
   *
   * <p>Note that retries of a read/write transaction that calls a non-deterministic function on
   * Cloud Spanner, such as CURRENT_TIMESTAMP(), will never be successful, as the data returned
   * during the retry will always be different from the original transaction.
   *
   * <p>It is also highly recommended that all queries in a read/write transaction have an ORDER BY
   * clause that guarantees that the data is returned in the same order as in the original
   * transaction if the transaction is internally retried. The most efficient way to achieve this is
   * to always include the primary key columns at the end of the ORDER BY clause.
   *
   * <p>This method may only be called when the connection is in read/write transactional mode and
   * no transaction has been started yet.
   *
   * @param retryAbortsInternally Set to <code>true</code> to internally retry transactions that are
   *     aborted by Spanner. When set to <code>false</code>, any database call on a transaction that
   *     has been aborted by Cloud Spanner will throw an {@link AbortedException} instead of being
   *     retried. Set this to false if your application already uses retry loops to handle {@link
   *     AbortedException}s.
   */
  void setRetryAbortsInternally(boolean retryAbortsInternally) throws SQLException;

  /**
   * Writes the specified mutation directly to the database and commits the change. The value is
   * readable after the successful completion of this method. Writing multiple mutations to a
   * database by calling this method multiple times mode is inefficient, as each call will need a
   * round trip to the database. Instead, you should consider writing the mutations together by
   * calling {@link CloudSpannerJdbcConnection#write(Iterable)}.
   *
   * <p>Calling this method is only allowed in autocommit mode. See {@link
   * CloudSpannerJdbcConnection#bufferedWrite(Iterable)} for writing mutations in transactions.
   *
   * @param mutation The {@link Mutation} to write to the database.
   * @throws SQLException if the {@link Connection} is not in autocommit mode or if the {@link
   *     Connection} is closed.
   */
  void write(Mutation mutation) throws SQLException;

  /**
   * Writes the specified mutations directly to the database and commits the changes. The values are
   * readable after the successful completion of this method.
   *
   * <p>Calling this method is only allowed in autocommit mode. See {@link
   * CloudSpannerJdbcConnection#bufferedWrite(Iterable)} for writing mutations in transactions.
   *
   * @param mutations The {@link Mutation}s to write to the database.
   * @throws SQLException if the {@link Connection} is not in autocommit mode or if the {@link
   *     Connection} is closed.
   */
  void write(Iterable<Mutation> mutations) throws SQLException;

  /**
   * Buffers the given mutation locally on the current transaction of this {@link Connection}. The
   * mutation will be written to the database at the next call to {@link Connection#commit()}. The
   * value will not be readable on this {@link Connection} before the transaction is committed.
   *
   * <p>Calling this method is only allowed when not in autocommit mode. See {@link
   * CloudSpannerJdbcConnection#write(Mutation)} for writing mutations in autocommit mode.
   *
   * @param mutation the {@link Mutation} to buffer for writing to the database on the next commit.
   * @throws SQLException if the {@link Connection} is in autocommit mode or the {@link Connection}
   *     is closed.
   */
  void bufferedWrite(Mutation mutation) throws SQLException;

  /**
   * Buffers the given mutations locally on the current transaction of this {@link Connection}. The
   * mutations will be written to the database at the next call to {@link Connection#commit()}. The
   * values will not be readable on this {@link Connection} before the transaction is committed.
   *
   * <p>Calling this method is only allowed when not in autocommit mode. See {@link
   * CloudSpannerJdbcConnection#write(Iterable)} for writing mutations in autocommit mode.
   *
   * @param mutations the {@link Mutation}s to buffer for writing to the database on the next
   *     commit.
   * @throws SQLException if the {@link Connection} is in autocommit mode or the {@link Connection}
   *     is closed.
   */
  void bufferedWrite(Iterable<Mutation> mutations) throws SQLException;

  /**
   * @return a connection URL that can be used to create a new {@link Connection} that is equal to
   *     the initial state of this connection. If this connection was initially opened in read-only
   *     mode, and later changed to read-write, this will not be reflected in the connection URL
   *     that is returned.
   */
  String getConnectionUrl();

  /**
   * @see
   *     com.google.cloud.spanner.jdbc.Connection#addTransactionRetryListener(TransactionRetryListener)
   * @throws SQLException if the {@link Connection} is closed.
   */
  void addTransactionRetryListener(TransactionRetryListener listener) throws SQLException;

  /**
   * @see
   *     com.google.cloud.spanner.jdbc.Connection#removeTransactionRetryListener(TransactionRetryListener)
   * @throws SQLException if the {@link Connection} is closed.
   */
  boolean removeTransactionRetryListener(TransactionRetryListener listener) throws SQLException;

  /**
   * @see com.google.cloud.spanner.jdbc.Connection#getTransactionRetryListeners()
   * @throws SQLException if the {@link Connection} is closed.
   */
  Iterator<TransactionRetryListener> getTransactionRetryListeners() throws SQLException;

  /**
   * Sets the duration the connection should wait before automatically aborting the execution of a
   * statement. The default is no timeout. Statement timeouts are applied all types of statements,
   * both in autocommit and transactional mode. They also apply to {@link Connection#commit()} and
   * {@link Connection#rollback()} statements.
   *
   * <p>A DML statement in autocommit mode may or may not have actually been applied to the
   * database, depending on when the timeout occurred.
   *
   * <p>A DML statement in a transaction that times out may still have been applied to the
   * transaction. If you still decide to commit the transaction after such a timeout, the DML
   * statement may or may not have been part of the transaction, depending on whether the timeout
   * occurred before or after the statement was (successfully) sent to Spanner. You should therefore
   * either always rollback a transaction that had a DML statement that timed out, or you should
   * accept that the timed out statement still might have been applied to the database.
   *
   * <p>DDL statements and DML statements in {@link AutocommitDmlMode#PARTITIONED_NON_ATOMIC} mode
   * cannot be rolled back. If such a statement times out, it may or may not have been applied to
   * the database. The same applies to commit and rollback statements.
   *
   * <p>Statements that time out will throw a {@link SpannerException} with error code {@link
   * ErrorCode#DEADLINE_EXCEEDED}.
   *
   * @param timeout The number of {@link TimeUnit}s before a statement is automatically aborted by
   *     the connection. Zero or negative values are not allowed. The maximum allowed value is
   *     315,576,000,000 seconds. Use {@link Connection#clearStatementTimeout()} to remove a timeout
   *     value that has been set.
   * @param unit The {@link TimeUnit} to specify the timeout value in. Must be one of {@link
   *     TimeUnit#NANOSECONDS}, {@link TimeUnit#MICROSECONDS}, {@link TimeUnit#MILLISECONDS}, {@link
   *     TimeUnit#SECONDS}.
   */
  void setStatementTimeout(long timeout, TimeUnit unit);

  /**
   * Clears the statement timeout value for this connection. This is a no-op if there is currently
   * no statement timeout set on this connection.
   */
  void clearStatementTimeout();

  /**
   * @param unit The {@link TimeUnit} to get the timeout value in. Must be one of {@link
   *     TimeUnit#NANOSECONDS}, {@link TimeUnit#MICROSECONDS}, {@link TimeUnit#MILLISECONDS}, {@link
   *     TimeUnit#SECONDS}
   * @return the current statement timeout value or 0 if no timeout value has been set.
   */
  long getStatementTimeout(TimeUnit unit);

  /** @return <code>true</code> if this {@link Connection} has a statement timeout value. */
  boolean hasStatementTimeout();

  /**
   * Cancels the currently running statement on this {@link Connection} (if any). If canceling the
   * statement execution succeeds, the statement will be terminated and a {@link SpannerException}
   * with code {@link ErrorCode#CANCELLED} will be thrown. The result of the statement will be the
   * same as when a statement times out (see {@link Connection#setStatementTimeout(long, TimeUnit)}
   * for more information).
   *
   * <p>Canceling a DDL statement in autocommit mode or a RUN BATCH statement of a DDL batch will
   * cause the connection to try to cancel the execution of the DDL statement(s). This is not
   * guaranteed to cancel the execution of the statement(s) on Cloud Spanner. See
   * https://cloud.google.com/spanner/docs/reference/rpc/google.longrunning#google.longrunning.Operations.CancelOperation
   * for more information.
   *
   * <p>Canceling a DML statement that is running in {@link
   * AutocommitDmlMode#PARTITIONED_NON_ATOMIC} mode will not cancel a statement on Cloud Spanner
   * that is already being executed, and its effects will still be applied to the database.
   */
  void cancel();

  /**
   * Starts a new DDL batch on this connection. A DDL batch allows several DDL statements to be
   * grouped into a batch that can be executed as a group. DDL statements that are issued during the
   * batch are buffered locally and will return immediately with an OK. It is not guaranteed that a
   * DDL statement that has been issued during a batch will eventually succeed when running the
   * batch. Aborting a DDL batch will clear the DDL buffer and will have made no changes to the
   * database. Running a DDL batch will send all buffered DDL statements to Spanner, and Spanner
   * will try to execute these. The result will be OK if all the statements executed successfully.
   * If a statement cannot be executed, Spanner will stop execution at that point and return an
   * error message for the statement that could not be executed. Preceding statements of the batch
   * may have been executed.
   *
   * <p>This method may only be called when the connection is in read/write mode, autocommit mode is
   * enabled or no read/write transaction has been started, and there is not already another batch
   * active. The connection will only accept DDL statements while a DDL batch is active.
   */
  void startBatchDdl();

  /**
   * Starts a new DML batch on this connection. A DML batch allows several DML statements to be
   * grouped into a batch that can be executed as a group. DML statements that are issued during the
   * batch are buffered locally and will return immediately with an OK. It is not guaranteed that a
   * DML statement that has been issued during a batch will eventually succeed when running the
   * batch. Aborting a DML batch will clear the DML buffer and will have made no changes to the
   * database. Running a DML batch will send all buffered DML statements to Spanner, and Spanner
   * will try to execute these. The result will be OK if all the statements executed successfully.
   * If a statement cannot be executed, Spanner will stop execution at that point and return {@link
   * SpannerBatchUpdateException} for the statement that could not be executed. Preceding statements
   * of the batch will have been executed, and the update counts of those statements can be
   * retrieved through {@link SpannerBatchUpdateException#getUpdateCounts()}.
   *
   * <p>This method may only be called when the connection is in read/write mode, autocommit mode is
   * enabled or no read/write transaction has been started, and there is not already another batch
   * active. The connection will only accept DML statements while a DML batch is active.
   */
  void startBatchDml();

  /**
   * Sends all buffered DML or DDL statements of the current batch to the database, waits for these
   * to be executed and ends the current batch. The method will throw an exception for the first
   * statement that cannot be executed, or return successfully if all statements could be executed.
   * If an exception is thrown for a statement in the batch, the preceding statements in the same
   * batch may still have been applied to the database.
   *
   * <p>This method may only be called when a (possibly empty) batch is active.
   *
   * @return the update counts in case of a DML batch. Returns an array containing 1 for each
   *     successful statement and 0 for each failed statement or statement that was not executed DDL
   *     in case of a DDL batch.
   */
  long[] runBatch();

  /**
   * Clears all buffered statements in the current batch and ends the batch.
   *
   * <p>This method may only be called when a (possibly empty) batch is active.
   */
  void abortBatch();

  /** @return <code>true</code> if a DDL batch is active on this connection. */
  boolean isDdlBatchActive();

  /** @return <code>true</code> if a DML batch is active on this connection. */
  boolean isDmlBatchActive();

  /**
   * Executes the given statement if allowed in the current {@link TransactionMode} and connection
   * state. The returned value depends on the type of statement:
   *
   * <ul>
   *   <li>Queries will return a {@link ResultSet}
   *   <li>DML statements will return an update count
   *   <li>DDL statements will return a {@link ResultType#NO_RESULT}
   *   <li>Connection and transaction statements (SET AUTOCOMMIT=TRUE|FALSE, SHOW AUTOCOMMIT, SET
   *       TRANSACTION READ ONLY, etc) will return either a {@link ResultSet} or {@link
   *       ResultType#NO_RESULT}, depending on the type of statement (SHOW or SET)
   * </ul>
   *
   * @param statement The statement to execute
   * @return the result of the statement
   */
  StatementResult execute(Statement statement);

  /**
   * Executes the given statement as a query and returns the result as a {@link ResultSet}. This
   * method blocks and waits for a response from Spanner. If the statement does not contain a valid
   * query, the method will throw a {@link SpannerException}.
   *
   * @param query The query statement to execute
   * @param options the options to configure the query
   * @return a {@link ResultSet} with the results of the query
   */
  ResultSet executeQuery(Statement query, QueryOption... options);

  /**
   * Executes the given statement as a DML statement. If the statement does not contain a valid DML
   * statement, the method will throw a {@link SpannerException}.
   *
   * @param update The update statement to execute
   * @return the number of records that were inserted/updated/deleted by this statement
   */
  long executeUpdate(Statement update);

  /**
   * Executes a list of DML statements in a single request. The statements will be executed in order
   * and the semantics is the same as if each statement is executed by {@link
   * Connection#executeUpdate(Statement)} in a loop. This method returns an array of long integers,
   * each representing the number of rows modified by each statement.
   *
   * <p>If an individual statement fails, execution stops and a {@code SpannerBatchUpdateException}
   * is returned, which includes the error and the number of rows affected by the statements that
   * are run prior to the error.
   *
   * <p>For example, if statements contains 3 statements, and the 2nd one is not a valid DML. This
   * method throws a {@code SpannerBatchUpdateException} that contains the error message from the
   * 2nd statement, and an array of length 1 that contains the number of rows modified by the 1st
   * statement. The 3rd statement will not run. Executes the given statements as DML statements in
   * one batch. If one of the statements does not contain a valid DML statement, the method will
   * throw a {@link SpannerException}.
   *
   * @param updates The update statements that will be executed as one batch.
   * @return an array containing the update counts per statement.
   */
  long[] executeBatchUpdate(Iterable<Statement> updates);
}
