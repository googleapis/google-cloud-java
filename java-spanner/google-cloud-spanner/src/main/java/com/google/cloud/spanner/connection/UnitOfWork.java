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

package com.google.cloud.spanner.connection;

import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.CommitResponse;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.UpdateOption;
import com.google.cloud.spanner.PartitionOptions;
import com.google.cloud.spanner.ReadContext;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.spanner.v1.ResultSetStats;
import io.opentelemetry.api.trace.Span;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nonnull;

/** Internal interface for transactions and batches on {@link Connection}s. */
@InternalApi
interface UnitOfWork {

  enum CallType {
    SYNC,
    ASYNC
  }

  /** A unit of work can be either a transaction or a DDL/DML batch. */
  enum Type {
    TRANSACTION,
    BATCH
  }

  enum UnitOfWorkState {
    STARTED,
    COMMITTING,
    COMMITTED,
    COMMIT_FAILED,
    ROLLED_BACK,
    RUNNING,
    RAN,
    RUN_FAILED,
    ABORTED;

    public boolean isActive() {
      return this == STARTED;
    }
  }

  /**
   * Callback for end-of-transaction methods. This is used to commit or rollback connection state
   * after an async commit/rollback of a database transaction.
   */
  interface EndTransactionCallback {
    /**
     * This method will be called if the end-of-transaction method (commit or rollback) finished
     * successfully, but before the {@link ApiFuture} that is returned by the method is done.
     */
    void onSuccess();

    /**
     * This method will be called if the end-of-transaction method (commit or rollback) failed, but
     * before the {@link ApiFuture} that is returned by the method is done.
     */
    void onFailure();
  }

  /** Cancel the currently running statement (if any and the statement may be cancelled). */
  void cancel();

  /**
   * @return the type of unit of work.
   */
  Type getType();

  /**
   * @return the current state of this unit of work.
   */
  UnitOfWorkState getState();

  /**
   * @return <code>true</code> if this unit of work is still active.
   */
  boolean isActive();

  /**
   * @return the {@link Span} that is used by this {@link UnitOfWork}.
   */
  Span getSpan();

  /** Returns true if this transaction can only be used for a single statement. */
  boolean isSingleUse();

  /**
   * Commits the changes in this unit of work to the database. For read-only transactions, this only
   * closes the {@link ReadContext}. This method will throw a {@link SpannerException} if called for
   * a {@link Type#BATCH}.
   *
   * @param callType Indicates whether the top-level call is a sync or async call.
   * @param callback Callback that should be called when the commit succeeded or failed.
   * @return An {@link ApiFuture} that is done when the commit has finished.
   */
  ApiFuture<Void> commitAsync(@Nonnull CallType callType, @Nonnull EndTransactionCallback callback);

  /**
   * Rollbacks any changes in this unit of work. For read-only transactions, this only closes the
   * {@link ReadContext}. This method will throw a {@link SpannerException} if called for a {@link
   * Type#BATCH}.
   *
   * @param callType Indicates whether the top-level call is a sync or async call.
   * @param callback Callback that should be called when the rollback succeeded or failed.
   * @return An {@link ApiFuture} that is done when the rollback has finished.
   */
  ApiFuture<Void> rollbackAsync(
      @Nonnull CallType callType, @Nonnull EndTransactionCallback callback);

  default void resetForRetry() {
    throw new UnsupportedOperationException();
  }

  /**
   * @see Connection#savepoint(String)
   */
  void savepoint(@Nonnull String name, @Nonnull Dialect dialect);

  /**
   * @see Connection#releaseSavepoint(String)
   */
  void releaseSavepoint(@Nonnull String name);

  /**
   * @see Connection#rollbackToSavepoint(String)
   */
  void rollbackToSavepoint(@Nonnull String name, @Nonnull SavepointSupport savepointSupport);

  /**
   * Sends the currently buffered statements in this unit of work to the database and ends the
   * batch. This method will throw a {@link SpannerException} if called for a {@link
   * Type#TRANSACTION}.
   *
   * @param callType Indicates whether the top-level call is a sync or async call.
   * @return an {@link ApiFuture} containing the update counts in case of a DML batch. Returns an
   *     array containing 1 for each successful statement and 0 for each failed statement or
   *     statement that was not executed in case of a DDL batch.
   */
  ApiFuture<long[]> runBatchAsync(CallType callType);

  /**
   * Clears the currently buffered statements in this unit of work and ends the batch. This method
   * will throw a {@link SpannerException} if called for a {@link Type#TRANSACTION}. This method is
   * always non-blocking.
   */
  void abortBatch();

  /**
   * @return <code>true</code> if this unit of work is read-only.
   */
  boolean isReadOnly();

  /**
   * @return <code>true</code> if this unit of work supports {@link
   *     com.google.spanner.v1.DirectedReadOptions}
   */
  default boolean supportsDirectedReads(ParsedStatement parsedStatement) {
    return false;
  }

  /**
   * Executes a query with the given options. If {@link AnalyzeMode} is set to {@link
   * AnalyzeMode#PLAN} or {@link AnalyzeMode#PROFILE}, the returned {@link ResultSet} will include
   * {@link ResultSetStats}.
   *
   * @param callType Indicates whether the top-level call is a sync or async call.
   * @param statement The statement to execute.
   * @param analyzeMode Indicates whether to include {@link ResultSetStats} in the returned {@link
   *     ResultSet} or not. Cannot be used in combination with {@link QueryOption}s.
   * @param options the options to configure the query. May only be set if analyzeMode is set to
   *     {@link AnalyzeMode#NONE}.
   * @return an {@link ApiFuture} containing a {@link ResultSet} with the results of the query.
   * @throws SpannerException if the query is not allowed on this {@link UnitOfWork}. The {@link
   *     ApiFuture} will return a {@link SpannerException} wrapped in an {@link ExecutionException}
   *     if a database error occurs.
   */
  ApiFuture<ResultSet> executeQueryAsync(
      CallType callType,
      ParsedStatement statement,
      AnalyzeMode analyzeMode,
      QueryOption... options);

  ApiFuture<ResultSet> partitionQueryAsync(
      CallType callType,
      ParsedStatement query,
      PartitionOptions partitionOptions,
      QueryOption... options);

  /**
   * @return the read timestamp of this transaction. Will throw a {@link SpannerException} if there
   *     is no read timestamp.
   */
  Timestamp getReadTimestamp();

  /**
   * @return the read timestamp of this transaction or null if there is no read timestamp.
   */
  Timestamp getReadTimestampOrNull();

  /**
   * @return the commit timestamp of this transaction. Will throw a {@link SpannerException} if
   *     there is no commit timestamp.
   */
  Timestamp getCommitTimestamp();

  /**
   * @return the commit timestamp of this transaction or null if there is no commit timestamp.
   */
  Timestamp getCommitTimestampOrNull();

  /**
   * @return the {@link CommitResponse} of this transaction
   * @throws SpannerException if there is no {@link CommitResponse}
   */
  CommitResponse getCommitResponse();

  /**
   * @return the {@link CommitResponse} of this transaction or null if there is no {@link
   *     CommitResponse}
   */
  CommitResponse getCommitResponseOrNull();

  /**
   * Executes the specified DDL statements in this unit of work. For DDL batches, this will mean
   * that the statements are buffered locally and will be sent to Spanner when {@link
   * UnitOfWork#commit()} is called. For {@link SingleUseTransaction}s, this will execute the DDL
   * statement directly on Spanner.
   *
   * @param ddl The DDL statement to execute.
   * @return an {@link ApiFuture} that is done when the DDL operation has finished.
   */
  ApiFuture<Void> executeDdlAsync(CallType callType, ParsedStatement ddl);

  /**
   * Execute a DML statement on Spanner.
   *
   * @param callType Indicates whether the top-level call is a sync or async call.
   * @param update The DML statement to execute.
   * @param options Update options to apply for the statement.
   * @return an {@link ApiFuture} containing the number of records that were
   *     inserted/updated/deleted by this statement.
   */
  ApiFuture<Long> executeUpdateAsync(
      CallType callType, ParsedStatement update, UpdateOption... options);

  /**
   * Execute and/or analyze a DML statement on Spanner.
   *
   * @param callType Indicates whether the top-level call is a sync or async call.
   * @param update The DML statement to analyze/execute.
   * @param analyzeMode Specifies the query/analyze mode to use for the DML statement.
   * @param options Update options to apply for the statement.
   * @return an {@link ApiFuture} containing the {@link ResultSet} that were returned by this
   *     statement. The {@link ResultSet} will not contain any rows.
   */
  ApiFuture<ResultSet> analyzeUpdateAsync(
      CallType callType, ParsedStatement update, AnalyzeMode analyzeMode, UpdateOption... options);

  /**
   * Execute a batch of DML statements on Spanner.
   *
   * @param callType Indicates whether the top-level call is a sync or async call.
   * @param updates The DML statements to execute.
   * @param options Update options to apply for the statement.
   * @return an {@link ApiFuture} containing an array with the number of records that were
   *     inserted/updated/deleted per statement.
   * @see TransactionContext#batchUpdate(Iterable)
   */
  ApiFuture<long[]> executeBatchUpdateAsync(
      CallType callType, Iterable<ParsedStatement> updates, UpdateOption... options);

  /**
   * Writes a batch of {@link Mutation}s to Spanner. For {@link ReadWriteTransaction}s, this means
   * buffering the {@link Mutation}s locally and writing the {@link Mutation}s to Spanner upon
   * {@link UnitOfWork#commit()}. For {@link SingleUseTransaction}s, the {@link Mutation}s will be
   * sent directly to Spanner.
   *
   * @param callType Indicates whether the top-level call is a sync or async call.
   * @param mutations The mutations to write.
   * @return an {@link ApiFuture} that is done when the {@link Mutation}s have been successfully
   *     buffered or written to Cloud Spanner.
   */
  ApiFuture<Void> writeAsync(CallType callType, Iterable<Mutation> mutations);
}
