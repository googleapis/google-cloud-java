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

import com.google.cloud.spanner.AbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.CommitResponse;
import com.google.cloud.spanner.CommitStats;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.PartitionOptions;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.connection.AutocommitDmlMode;
import com.google.cloud.spanner.connection.SavepointSupport;
import com.google.cloud.spanner.connection.TransactionMode;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import javax.annotation.Nonnull;

/**
 * JDBC connection with a number of additional Cloud Spanner specific methods. JDBC connections that
 * are returned by the Cloud Spanner {@link JdbcDriver} will implement this interface.
 *
 * <p>Calling {@link Connection#unwrap(Class)} with {@code CloudSpannerJdbcConnection} class as
 * input on a {@link Connection} returned by the Cloud Spanner JDBC Driver will return a {@link
 * CloudSpannerJdbcConnection} instance.
 */
public interface CloudSpannerJdbcConnection extends Connection {

  /**
   * Returns the {@link DatabaseId} of the database that this {@link Connection} is connected to.
   */
  default DatabaseId getDatabaseId() {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the underlying {@link DatabaseClient} that is used by this connection. Operations that
   * are executed on the {@link DatabaseClient} that is returned has no impact on this {@link
   * Connection}, e.g. starting a read/write transaction on the {@link DatabaseClient} will not
   * start a transaction on this connection.
   */
  default DatabaseClient getDatabaseClient() {
    throw new UnsupportedOperationException();
  }

  /** Returns the underlying {@link Spanner} instance that is used by this connection. */
  default Spanner getSpanner() {
    throw new UnsupportedOperationException();
  }

  /**
   * Sets the transaction tag to use for the current transaction. This method may only be called
   * when in a transaction, and before the transaction is actually started, i.e. before any
   * statements have been executed in the transaction.
   *
   * <p>The tag will be set as the transaction tag of all statements during the transaction, and as
   * the transaction tag of the commit.
   *
   * <p>The transaction tag will automatically be cleared after the transaction has ended.
   *
   * @param tag The tag to use.
   */
  default void setTransactionTag(String tag) throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * @return The transaction tag of the current transaction.
   */
  default String getTransactionTag() throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * Sets the statement tag to use for the next statement that will be executed. The tag is
   * automatically cleared after the statement is executed. Statement tags can be used both with
   * autocommit=true and autocommit=false, and can be used for partitioned DML.
   *
   * @param tag The statement tag to use with the next statement that will be executed on this
   *     connection.
   */
  default void setStatementTag(String tag) throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * @return The statement tag that will be used with the next statement that is executed on this
   *     connection.
   */
  default String getStatementTag() throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * Sets the transaction mode to use for current transaction. This method may only be called when
   * in a transaction, and before the transaction is actually started, i.e. before any statements
   * have been executed in the transaction.
   *
   * @param transactionMode The transaction mode to use for the current transaction.
   *     <ul>
   *       <li>{@link TransactionMode#READ_ONLY_TRANSACTION} will create a read-only transaction and
   *           prevent any changes to written to the database through this transaction. The read
   *           timestamp to be used will be determined based on the current readOnlyStaleness
   *           setting of this connection. It is recommended to use {@link
   *           TransactionMode#READ_ONLY_TRANSACTION} instead of {@link
   *           TransactionMode#READ_WRITE_TRANSACTION} when possible, as read-only transactions do
   *           not acquire locks on Cloud Spanner, and read-only transactions never abort.
   *       <li>{@link TransactionMode#READ_WRITE_TRANSACTION} this value is only allowed when the
   *           connection is not in read-only mode and will create a read-write transaction. If
   *           {@link CloudSpannerJdbcConnection#isRetryAbortsInternally()} is <code>true</code>,
   *           each read/write transaction will keep track of a running SHA256 checksum for each
   *           {@link ResultSet} that is returned in order to be able to retry the transaction in
   *           case the transaction is aborted by Spanner.
   *     </ul>
   */
  void setTransactionMode(TransactionMode transactionMode) throws SQLException;

  /**
   * @return the transaction mode of the current transaction. This method may only be called when
   *     the connection is in a transaction.
   */
  TransactionMode getTransactionMode() throws SQLException;

  /**
   * Sets the mode for executing DML statements in autocommit mode for this connection. This setting
   * is only used when the connection is in autocommit mode, and may only be set while the
   * transaction is in autocommit mode and not in a temporary transaction. The autocommit
   * transaction mode is reset to its default value of {@link AutocommitDmlMode#TRANSACTIONAL} when
   * autocommit mode is changed on the connection.
   *
   * @param mode The DML autocommit mode to use
   *     <ul>
   *       <li>{@link AutocommitDmlMode#TRANSACTIONAL} DML statements are executed as single
   *           read-write transaction. After successful execution, the DML statement is guaranteed
   *           to have been applied exactly once to the database
   *       <li>{@link AutocommitDmlMode#PARTITIONED_NON_ATOMIC} DML statements are executed as
   *           partitioned DML transactions. If an error occurs during the execution of the DML
   *           statement, it is possible that the statement has been applied to some but not all of
   *           the rows specified in the statement.
   *     </ul>
   */
  void setAutocommitDmlMode(AutocommitDmlMode mode) throws SQLException;

  /**
   * @return the current {@link AutocommitDmlMode} setting for this connection. This method may only
   *     be called on a connection that is in autocommit mode and not while in a temporary
   *     transaction.
   */
  AutocommitDmlMode getAutocommitDmlMode() throws SQLException;

  /**
   * Sets the staleness to use for the current read-only transaction. This method may only be called
   * when the transaction mode of the current transaction is {@link
   * TransactionMode#READ_ONLY_TRANSACTION} and there is no transaction that has started, or when
   * the connection is in read-only and autocommit mode.
   *
   * @param staleness The staleness to use for the current but not yet started read-only transaction
   */
  void setReadOnlyStaleness(TimestampBound staleness) throws SQLException;

  /**
   * @return the read-only staleness setting for the current read-only transaction. This method may
   *     only be called when the current transaction is a read-only transaction, or when the
   *     connection is in read-only and autocommit mode.
   */
  TimestampBound getReadOnlyStaleness() throws SQLException;

  /**
   * Sets the query optimizer version to use for this connection.
   *
   * @param optimizerVersion The query optimizer version to use. Must be a valid optimizer version
   *     number, the string <code>LATEST</code> or an empty string. The empty string will instruct
   *     the connection to use the optimizer version that is defined in the environment variable
   *     <code>SPANNER_OPTIMIZER_VERSION</code>. If no value is specified in the environment
   *     variable, the default query optimizer of Cloud Spanner is used.
   */
  void setOptimizerVersion(String optimizerVersion) throws SQLException;

  /**
   * Gets the current query optimizer version of this connection.
   *
   * @return The query optimizer version that is currently used by this connection.
   */
  String getOptimizerVersion() throws SQLException;

  /**
   * @return <code>true</code> if this connection has a transaction (that has not necessarily
   *     started). This method will only return false when the {@link Connection} is in autocommit
   *     mode and no explicit transaction has been started by executing `BEGIN TRANSACTION`. If the
   *     {@link Connection} is not in autocommit mode, there will always be a transaction.
   */
  boolean isInTransaction() throws SQLException;

  /**
   * @return <code>true</code> if this connection has a transaction that has started. A transaction
   *     is automatically started by the first statement that is executed in the transaction.
   */
  boolean isTransactionStarted() throws SQLException;

  /**
   * @return the commit {@link Timestamp} of the last read/write transaction. If the last
   *     transaction was not a read/write transaction, or a read/write transaction that did not
   *     return a commit timestamp because the transaction was not committed, the method will throw
   *     a {@link SQLException}.
   */
  Timestamp getCommitTimestamp() throws SQLException;

  /**
   * @return the {@link CommitResponse} of the last read/write transaction. If the last transaction
   *     was not a read/write transaction, or a read/write transaction that did not return a {@link
   *     CommitResponse} because the transaction was not committed, the method will throw a {@link
   *     SQLException}. The {@link CommitResponse} will include {@link CommitStats} if {@link
   *     #isReturnCommitStats()} returns true.
   */
  CommitResponse getCommitResponse() throws SQLException;

  /**
   * Sets whether this connection should request commit statistics from Cloud Spanner for read/write
   * transactions and for DML statements in autocommit mode.
   */
  void setReturnCommitStats(boolean returnCommitStats) throws SQLException;

  /**
   * @return true if this connection requests commit statistics from Cloud Spanner.
   */
  boolean isReturnCommitStats() throws SQLException;

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

  /** Returns the current savepoint support for this connection. */
  SavepointSupport getSavepointSupport() throws SQLException;

  /** Sets how savepoints should be supported on this connection. */
  void setSavepointSupport(SavepointSupport savepointSupport) throws SQLException;

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
   * @return The {@link Dialect} that is used by this connection.
   */
  default Dialect getDialect() {
    return Dialect.GOOGLE_STANDARD_SQL;
  }

  /**
   * Enable data boost for partitioned queries. See also {@link
   * CloudSpannerJdbcStatement#partitionQuery(String, PartitionOptions, QueryOption...)} and {@link
   * CloudSpannerJdbcPreparedStatement#partitionQuery(PartitionOptions, QueryOption...)}.
   */
  default void setDataBoostEnabled(boolean dataBoostEnabled) throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns whether data boost is enabled for partitioned queries. See also {@link
   * CloudSpannerJdbcStatement#partitionQuery(String, PartitionOptions, QueryOption...)} and {@link
   * CloudSpannerJdbcPreparedStatement#partitionQuery(PartitionOptions, QueryOption...)}.
   */
  default boolean isDataBoostEnabled() throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * Sets whether this connection should always use partitioned queries when a query is executed on
   * this connection. Setting this flag to <code>true</code> and then executing a query that cannot
   * be partitioned, or executing a query in a read/write transaction, will cause an error. Use this
   * flag in combination with {@link #setDataBoostEnabled(boolean)} to force all queries on this
   * connection to use data boost.
   */
  default void setAutoPartitionMode(boolean alwaysUsePartitionedQueries) throws SQLException {
    throw new UnsupportedOperationException();
  }

  /** Returns whether this connection will execute all queries as partitioned queries. */
  default boolean isAutoPartitionMode() throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * Sets the maximum number of partitions that should be included as a hint to Cloud Spanner when
   * partitioning a query on this connection. Note that this is only a hint and Cloud Spanner might
   * choose to ignore the hint.
   */
  default void setMaxPartitions(int maxPartitions) throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * Gets the maximum number of partitions that should be included as a hint to Cloud Spanner when
   * partitioning a query on this connection. Note that this is only a hint and Cloud Spanner might
   * choose to ignore the hint.
   */
  default int getMaxPartitions() throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * Sets the maximum degree of parallelism that is used when executing a partitioned query. A
   * partitioned query will use up to <code>maxThreads</code> to execute and retrieve the results
   * from Cloud Spanner. Set this value to <code>0</code>> to use the number of available processors
   * as returned by {@link Runtime#availableProcessors()}.
   */
  default void setMaxPartitionedParallelism(int maxThreads) throws SQLException {
    throw new UnsupportedOperationException();
  }

  /** Returns the maximum degree of parallelism that is used for partitioned queries. */
  default int getMaxPartitionedParallelism() throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * Enables or disables automatic batching of DML statements. When enabled, DML statements that are
   * executed on this connection will be buffered in memory instead of actually being executed. The
   * buffered DML statements are flushed to Spanner when a statement that cannot be part of a DML
   * batch is executed on the connection. This can be a query, a DDL statement with a THEN RETURN
   * clause, or a Commit call. The update count that is returned for DML statements that are
   * buffered is determined by the value that has been set with {@link
   * #setAutoBatchDmlUpdateCount(long)}. The default is 1. The connection verifies that the update
   * counts that were returned while buffering DML statements match the actual update counts that
   * are returned by Spanner when the batch is executed. This verification can be disabled by
   * calling {@link #setAutoBatchDmlUpdateCountVerification(boolean)}.
   */
  default void setAutoBatchDml(boolean autoBatchDml) throws SQLException {
    throw new UnsupportedOperationException();
  }

  /** Returns whether automatic DML batching is enabled on this connection. */
  default boolean isAutoBatchDml() throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * Sets the update count that is returned for DML statements that are buffered during an automatic
   * DML batch. This value is only used if {@link #isAutoBatchDml()} is enabled.
   */
  default void setAutoBatchDmlUpdateCount(long updateCount) throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the update count that is returned for DML statements that are buffered during an
   * automatic DML batch.
   */
  default long getAutoBatchDmlUpdateCount() throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * Sets whether the update count that is returned by Spanner after executing an automatic DML
   * batch should be verified against the update counts that were returned during the buffering of
   * those statements.
   */
  default void setAutoBatchDmlUpdateCountVerification(boolean verification) throws SQLException {
    throw new UnsupportedOperationException();
  }

  /** Indicates whether the update counts of automatic DML batches should be verified. */
  default boolean isAutoBatchDmlUpdateCountVerification() throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * @see
   *     com.google.cloud.spanner.connection.Connection#addTransactionRetryListener(com.google.cloud.spanner.connection.TransactionRetryListener)
   * @throws SQLException if the {@link Connection} is closed.
   */
  void addTransactionRetryListener(
      com.google.cloud.spanner.connection.TransactionRetryListener listener) throws SQLException;

  /**
   * Use {@link
   * #addTransactionRetryListener(com.google.cloud.spanner.connection.TransactionRetryListener)}
   * instead.
   */
  @Deprecated
  void addTransactionRetryListener(com.google.cloud.spanner.jdbc.TransactionRetryListener listener)
      throws SQLException;

  /**
   * @see
   *     com.google.cloud.spanner.connection.Connection#removeTransactionRetryListener(com.google.cloud.spanner.connection.TransactionRetryListener)
   * @throws SQLException if the {@link Connection} is closed.
   */
  boolean removeTransactionRetryListener(
      com.google.cloud.spanner.connection.TransactionRetryListener listener) throws SQLException;

  /**
   * Use {@link
   * #removeTransactionRetryListener(com.google.cloud.spanner.connection.TransactionRetryListener)}
   * instead.
   */
  @Deprecated
  boolean removeTransactionRetryListener(
      com.google.cloud.spanner.jdbc.TransactionRetryListener listener) throws SQLException;

  /** Use {@link #getTransactionRetryListenersFromConnection()} instead. */
  @Deprecated
  Iterator<com.google.cloud.spanner.jdbc.TransactionRetryListener> getTransactionRetryListeners()
      throws SQLException;

  /**
   * @see com.google.cloud.spanner.connection.Connection#getTransactionRetryListeners()
   * @throws SQLException if the {@link Connection} is closed.
   */
  Iterator<com.google.cloud.spanner.connection.TransactionRetryListener>
      getTransactionRetryListenersFromConnection() throws SQLException;

  /**
   * Sets the proto descriptors to use for the next DDL statement (single or batch) that will be
   * executed. The proto descriptor is automatically cleared after the statement is executed.
   *
   * @param protoDescriptors The proto descriptors to use with the next DDL statement (single or
   *     batch) that will be executed on this connection.
   */
  default void setProtoDescriptors(@Nonnull byte[] protoDescriptors) throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * Sets the proto descriptors to use for the next DDL statement (single or batch) that will be
   * executed. The proto descriptor is automatically cleared after the statement is executed.
   *
   * @param protoDescriptors The proto descriptors to use with the next DDL statement (single or
   *     batch) that will be executed on this connection.
   */
  default void setProtoDescriptors(@Nonnull InputStream protoDescriptors)
      throws SQLException, IOException {
    throw new UnsupportedOperationException();
  }

  /**
   * @return The proto descriptor that will be used with the next DDL statement (single or batch)
   *     that is executed on this connection.
   */
  default byte[] getProtoDescriptors() throws SQLException {
    throw new UnsupportedOperationException();
  }
}
