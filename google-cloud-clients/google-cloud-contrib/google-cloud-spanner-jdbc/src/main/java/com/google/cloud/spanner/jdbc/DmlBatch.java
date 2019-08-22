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

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.cloud.spanner.jdbc.StatementParser.StatementType;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link UnitOfWork} that is used when a DML batch is started. These batches only accept DML
 * statements. All DML statements are buffered locally and sent to Spanner when runBatch() is
 * called.
 */
class DmlBatch extends AbstractBaseUnitOfWork {
  private final UnitOfWork transaction;
  private final List<ParsedStatement> statements = new ArrayList<>();
  private UnitOfWorkState state = UnitOfWorkState.STARTED;

  static class Builder extends AbstractBaseUnitOfWork.Builder<Builder, DmlBatch> {
    private UnitOfWork transaction;

    private Builder() {}

    Builder setTransaction(UnitOfWork transaction) {
      Preconditions.checkNotNull(transaction);
      this.transaction = transaction;
      return this;
    }

    @Override
    DmlBatch build() {
      Preconditions.checkState(transaction != null, "No transaction specified");
      return new DmlBatch(this);
    }
  }

  static Builder newBuilder() {
    return new Builder();
  }

  private DmlBatch(Builder builder) {
    super(builder);
    this.transaction = builder.transaction;
  }

  @Override
  public Type getType() {
    return Type.BATCH;
  }

  @Override
  public UnitOfWorkState getState() {
    return this.state;
  }

  @Override
  public boolean isActive() {
    return getState().isActive();
  }

  @Override
  public boolean isReadOnly() {
    return false;
  }

  @Override
  public ResultSet executeQuery(
      ParsedStatement statement, AnalyzeMode analyzeMode, QueryOption... options) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Executing queries is not allowed for DML batches.");
  }

  @Override
  public Timestamp getReadTimestamp() {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "There is no read timestamp available for DML batches.");
  }

  @Override
  public Timestamp getReadTimestampOrNull() {
    return null;
  }

  @Override
  public Timestamp getCommitTimestamp() {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "There is no commit timestamp available for DML batches.");
  }

  @Override
  public Timestamp getCommitTimestampOrNull() {
    return null;
  }

  @Override
  public void executeDdl(ParsedStatement ddl) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Executing DDL statements is not allowed for DML batches.");
  }

  @Override
  public long executeUpdate(ParsedStatement update) {
    ConnectionPreconditions.checkState(
        state == UnitOfWorkState.STARTED,
        "The batch is no longer active and cannot be used for further statements");
    Preconditions.checkArgument(
        update.getType() == StatementType.UPDATE,
        "Only DML statements are allowed. \""
            + update.getSqlWithoutComments()
            + "\" is not a DML-statement.");
    statements.add(update);
    return -1L;
  }

  @Override
  public long[] executeBatchUpdate(Iterable<ParsedStatement> updates) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Executing batch updates is not allowed for DML batches.");
  }

  @Override
  public void write(Mutation mutation) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Writing mutations is not allowed for DML batches.");
  }

  @Override
  public void write(Iterable<Mutation> mutations) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Writing mutations is not allowed for DML batches.");
  }

  @Override
  public long[] runBatch() {
    ConnectionPreconditions.checkState(
        state == UnitOfWorkState.STARTED, "The batch is no longer active and cannot be ran");
    try {
      long[] res;
      if (statements.isEmpty()) {
        res = new long[0];
      } else {
        res = transaction.executeBatchUpdate(statements);
      }
      this.state = UnitOfWorkState.RAN;
      return res;
    } catch (SpannerException e) {
      this.state = UnitOfWorkState.RUN_FAILED;
      throw e;
    }
  }

  @Override
  public void abortBatch() {
    ConnectionPreconditions.checkState(
        state == UnitOfWorkState.STARTED, "The batch is no longer active and cannot be aborted.");
    this.state = UnitOfWorkState.ABORTED;
  }

  @Override
  public void commit() {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Commit is not allowed for DML batches.");
  }

  @Override
  public void rollback() {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Rollback is not allowed for DML batches.");
  }
}
