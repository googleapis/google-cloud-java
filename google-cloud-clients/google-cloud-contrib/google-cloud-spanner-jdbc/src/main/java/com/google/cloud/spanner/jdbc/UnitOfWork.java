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

import com.google.api.core.InternalApi;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.ReadContext;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.spanner.v1.ResultSetStats;

/** Internal interface for transactions and batches on {@link Connection}s. */
@InternalApi
interface UnitOfWork {

  /** A unit of work can be either a transaction or a DDL/DML batch. */
  enum Type {
    TRANSACTION,
    BATCH;
  }

  enum UnitOfWorkState {
    STARTED,
    COMMITTED,
    COMMIT_FAILED,
    ROLLED_BACK,
    RAN,
    RUN_FAILED,
    ABORTED;

    public boolean isActive() {
      return this == STARTED;
    }
  }

  /** Cancel the currently running statement (if any and the statement may be cancelled). */
  void cancel();

  /** @return the type of unit of work. */
  Type getType();

  /** @return the current state of this unit of work. */
  UnitOfWorkState getState();

  /** @return <code>true</code> if this unit of work is still active. */
  boolean isActive();

  /**
   * Commits the changes in this unit of work to the database. For read-only transactions, this only
   * closes the {@link ReadContext}. This method will throw a {@link SpannerException} if called for
   * a {@link Type#BATCH}.
   */
  void commit();

  /**
   * Rollbacks any changes in this unit of work. For read-only transactions, this only closes the
   * {@link ReadContext}. This method will throw a {@link SpannerException} if called for a {@link
   * Type#BATCH}.
   */
  void rollback();

  /**
   * Sends the currently buffered statements in this unit of work to the database and ends the
   * batch. This method will throw a {@link SpannerException} if called for a {@link
   * Type#TRANSACTION}.
   *
   * @return the update counts in case of a DML batch. Returns an array containing 1 for each
   *     successful statement and 0 for each failed statement or statement that was not executed DDL
   *     in case of a DDL batch.
   */
  long[] runBatch();

  /**
   * Clears the currently buffered statements in this unit of work and ends the batch. This method
   * will throw a {@link SpannerException} if called for a {@link Type#TRANSACTION}.
   */
  void abortBatch();

  /** @return <code>true</code> if this unit of work is read-only. */
  boolean isReadOnly();

  /**
   * Executes a query with the given options. If {@link AnalyzeMode} is set to {@link
   * AnalyzeMode#PLAN} or {@link AnalyzeMode#PROFILE}, the returned {@link ResultSet} will include
   * {@link ResultSetStats}.
   *
   * @param statement The statement to execute.
   * @param analyzeMode Indicates whether to include {@link ResultSetStats} in the returned {@link
   *     ResultSet} or not. Cannot be used in combination with {@link QueryOption}s.
   * @param options the options to configure the query. May only be set if analyzeMode is set to
   *     {@link AnalyzeMode#NONE}.
   * @return a {@link ResultSet} with the results of the query.
   * @throws SpannerException if the query is not allowed on this {@link UnitOfWork}, or if a
   *     database error occurs.
   */
  ResultSet executeQuery(
      ParsedStatement statement, AnalyzeMode analyzeMode, QueryOption... options);

  /**
   * @return the read timestamp of this transaction. Will throw a {@link SpannerException} if there
   *     is no read timestamp.
   */
  Timestamp getReadTimestamp();

  /** @return the read timestamp of this transaction or null if there is no read timestamp. */
  Timestamp getReadTimestampOrNull();

  /**
   * @return the commit timestamp of this transaction. Will throw a {@link SpannerException} if
   *     there is no commit timestamp.
   */
  Timestamp getCommitTimestamp();

  /** @return the commit timestamp of this transaction or null if there is no commit timestamp. */
  Timestamp getCommitTimestampOrNull();

  /**
   * Executes the specified DDL statements in this unit of work. For DDL batches, this will mean
   * that the statements are buffered locally and will be sent to Spanner when {@link
   * UnitOfWork#commit()} is called. For {@link SingleUseTransaction}s, this will execute the DDL
   * statement directly on Spanner.
   *
   * @param ddl The DDL statement to execute.
   */
  void executeDdl(ParsedStatement ddl);

  /**
   * Execute a DML statement on Spanner.
   *
   * @param update The DML statement to execute.
   * @return the number of records that were inserted/updated/deleted by this statement.
   */
  long executeUpdate(ParsedStatement update);

  /**
   * Execute a batch of DML statements on Spanner.
   *
   * @param updates The DML statements to execute.
   * @return an array containing the number of records that were inserted/updated/deleted per
   *     statement.
   * @see TransactionContext#batchUpdate(Iterable)
   */
  long[] executeBatchUpdate(Iterable<ParsedStatement> updates);

  /**
   * Writes a {@link Mutation} to Spanner. For {@link ReadWriteTransaction}s, this means buffering
   * the {@link Mutation} locally and writing the {@link Mutation} to Spanner upon {@link
   * UnitOfWork#commit()}. For {@link SingleUseTransaction}s, the {@link Mutation} will be sent
   * directly to Spanner.
   *
   * @param mutation The mutation to write.
   */
  void write(Mutation mutation);

  /**
   * Writes a batch of {@link Mutation}s to Spanner. For {@link ReadWriteTransaction}s, this means
   * buffering the {@link Mutation}s locally and writing the {@link Mutation}s to Spanner upon
   * {@link UnitOfWork#commit()}. For {@link SingleUseTransaction}s, the {@link Mutation}s will be
   * sent directly to Spanner.
   *
   * @param mutations The mutations to write.
   */
  void write(Iterable<Mutation> mutations);
}
