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
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;

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
}
