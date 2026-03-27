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
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.ReadContext;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.spanner.v1.SpannerGrpc;
import io.opentelemetry.context.Scope;
import java.util.LinkedList;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * Base class for {@link Connection}-based transactions that can be used for multiple read and
 * read/write statements.
 */
abstract class AbstractMultiUseTransaction extends AbstractBaseUnitOfWork {

  /** In-memory savepoint implementation that is used by the Connection API. */
  static class Savepoint {
    private final String name;
    private final boolean autoSavepoint;

    static Savepoint of(String name) {
      return new Savepoint(name, false);
    }

    Savepoint(String name, boolean autoSavepoint) {
      this.name = name;
      this.autoSavepoint = autoSavepoint;
    }

    /** Returns the index of the first statement that was executed after this savepoint. */
    int getStatementPosition() {
      return -1;
    }

    /** Returns the index of the first mutation that was executed after this savepoint. */
    int getMutationPosition() {
      return -1;
    }

    boolean isAutoSavepoint() {
      return this.autoSavepoint;
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof Savepoint)) {
        return false;
      }
      Savepoint other = (Savepoint) o;
      return Objects.equals(other.name, this.name)
          && Objects.equals(other.autoSavepoint, this.autoSavepoint);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.name, this.autoSavepoint);
    }

    @Override
    public String toString() {
      return name;
    }
  }

  private final LinkedList<Savepoint> savepoints = new LinkedList<>();

  AbstractMultiUseTransaction(Builder<?, ? extends AbstractMultiUseTransaction> builder) {
    super(builder);
  }

  @Override
  public boolean isSingleUse() {
    return false;
  }

  @Override
  public Type getType() {
    return Type.TRANSACTION;
  }

  @Override
  public boolean isActive() {
    return getState().isActive();
  }

  abstract void checkAborted();

  /**
   * Check that the current transaction actually has a valid underlying transaction and creates it
   * if necessary. If the transaction does not have a valid underlying transaction and/or is not in
   * a state that allows the creation of a transaction, the method will throw a {@link
   * SpannerException}.
   */
  abstract void checkOrCreateValidTransaction(ParsedStatement statement, CallType callType);

  /** Returns the {@link ReadContext} that can be used for queries on this transaction. */
  abstract ReadContext getReadContext();

  @Override
  public ApiFuture<ResultSet> executeQueryAsync(
      final CallType callType,
      final ParsedStatement statement,
      final AnalyzeMode analyzeMode,
      final QueryOption... options) {
    Preconditions.checkArgument(statement.isQuery(), "Statement is not a query");
    try (Scope ignore = span.makeCurrent()) {
      checkOrCreateValidTransaction(statement, callType);
      return executeStatementAsync(
          callType,
          statement,
          () -> {
            checkAborted();
            return DirectExecuteResultSet.ofResultSet(
                internalExecuteQuery(statement, analyzeMode, options));
          },
          SpannerGrpc.getExecuteStreamingSqlMethod());
    }
  }

  ResultSet internalExecuteQuery(
      final ParsedStatement statement, AnalyzeMode analyzeMode, QueryOption... options) {
    if (analyzeMode == AnalyzeMode.NONE) {
      return getReadContext().executeQuery(statement.getStatement(), options);
    }
    return getReadContext()
        .analyzeQuery(statement.getStatement(), analyzeMode.getQueryAnalyzeMode());
  }

  @Override
  public ApiFuture<long[]> runBatchAsync(CallType callType) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Run batch is not supported for transactions");
  }

  @Override
  public void abortBatch() {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Run batch is not supported for transactions");
  }

  abstract Savepoint savepoint(String name);

  abstract void rollbackToSavepoint(Savepoint savepoint);

  @VisibleForTesting
  ImmutableList<Savepoint> getSavepoints() {
    return ImmutableList.copyOf(savepoints);
  }

  @Override
  public void savepoint(@Nonnull String name, @Nonnull Dialect dialect) {
    if (dialect != Dialect.POSTGRESQL) {
      // Check that there is no savepoint with this name. Note that PostgreSQL allows multiple
      // savepoints in a transaction with the same name, so we don't execute this check for PG.
      if (savepoints.stream().anyMatch(savepoint -> savepoint.name.equals(name))) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "Savepoint with name " + name + " already exists");
      }
    }
    savepoints.add(savepoint(name));
  }

  @Override
  public void releaseSavepoint(@Nonnull String name) {
    // Remove the given savepoint and all later savepoints from the transaction.
    savepoints.subList(getSavepointIndex(name), savepoints.size()).clear();
  }

  @Override
  public void rollbackToSavepoint(
      @Nonnull String name, @Nonnull SavepointSupport savepointSupport) {
    int index = getSavepointIndex(name);
    rollbackToSavepoint(savepoints.get(index));
    if (index < (savepoints.size() - 1)) {
      // Remove all savepoints that come after this savepoint from the transaction.
      // Rolling back to a savepoint does not remove that savepoint, only the ones that come after.
      savepoints.subList(index + 1, savepoints.size()).clear();
    }
  }

  private int getSavepointIndex(String name) {
    int index = savepoints.lastIndexOf(savepoint(name));
    if (index == -1) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT, "Savepoint with name " + name + " does not exist");
    }
    return index;
  }
}
