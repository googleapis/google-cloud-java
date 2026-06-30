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
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.CommitResponse;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.UpdateOption;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.AbstractStatementParser.StatementType;
import com.google.common.base.Preconditions;
import com.google.common.base.Suppliers;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.MoreExecutors;
import io.opentelemetry.context.Scope;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import javax.annotation.Nonnull;

/**
 * {@link UnitOfWork} that is used when a DML batch is started. These batches only accept DML
 * statements. All DML statements are buffered locally and sent to Spanner when runBatch() is
 * called.
 */
class DmlBatch extends AbstractBaseUnitOfWork {
  private final boolean autoBatch;
  private final Supplier<Long> autoBatchUpdateCountSupplier;
  private final Supplier<Boolean> verifyUpdateCountsSupplier;
  private final Supplier<Long> dmlbatchUpdateCountSupplier;
  private final UnitOfWork transaction;
  private final String statementTag;
  private final List<ParsedStatement> statements = new ArrayList<>();
  private long[] updateCounts = new long[0];
  private UnitOfWorkState state = UnitOfWorkState.STARTED;

  static class Builder extends AbstractBaseUnitOfWork.Builder<Builder, DmlBatch> {
    private boolean autoBatch;
    private Supplier<Long> autoBatchUpdateCountSupplier = Suppliers.ofInstance(1L);
    private Supplier<Boolean> verifyUpdateCountsSupplier = Suppliers.ofInstance(Boolean.FALSE);
    private Supplier<Long> dmlbatchUpdateCountSupplier = Suppliers.ofInstance(-1L);
    private UnitOfWork transaction;
    private String statementTag;

    private Builder() {}

    Builder setAutoBatch(boolean autoBatch) {
      this.autoBatch = autoBatch;
      return this;
    }

    Builder setAutoBatchUpdateCountSupplier(Supplier<Long> updateCountSupplier) {
      this.autoBatchUpdateCountSupplier = Preconditions.checkNotNull(updateCountSupplier);
      return this;
    }

    Builder setAutoBatchUpdateCountVerificationSupplier(Supplier<Boolean> verificationSupplier) {
      this.verifyUpdateCountsSupplier = verificationSupplier;
      return this;
    }

    Builder setDmlBatchUpdateCountSupplier(Supplier<Long> dmlbatchUpdateCountSupplier) {
      Preconditions.checkNotNull(dmlbatchUpdateCountSupplier);
      this.dmlbatchUpdateCountSupplier = dmlbatchUpdateCountSupplier;
      return this;
    }

    Builder setTransaction(UnitOfWork transaction) {
      Preconditions.checkNotNull(transaction);
      this.transaction = transaction;
      return this;
    }

    Builder setStatementTag(String tag) {
      this.statementTag = tag;
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
    this.autoBatch = builder.autoBatch;
    this.autoBatchUpdateCountSupplier = builder.autoBatchUpdateCountSupplier;
    this.verifyUpdateCountsSupplier = builder.verifyUpdateCountsSupplier;
    this.dmlbatchUpdateCountSupplier = builder.dmlbatchUpdateCountSupplier;
    this.transaction = Preconditions.checkNotNull(builder.transaction);
    this.statementTag = builder.statementTag;
  }

  boolean isAutoBatch() {
    return this.autoBatch;
  }

  @Override
  public boolean isSingleUse() {
    return false;
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
  public ApiFuture<ResultSet> executeQueryAsync(
      CallType callType,
      ParsedStatement statement,
      AnalyzeMode analyzeMode,
      QueryOption... options) {
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
  public CommitResponse getCommitResponse() {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "There is no commit response available for DML batches.");
  }

  @Override
  public CommitResponse getCommitResponseOrNull() {
    return null;
  }

  @Override
  public ApiFuture<Void> executeDdlAsync(CallType callType, ParsedStatement ddl) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Executing DDL statements is not allowed for DML batches.");
  }

  long getUpdateCount() {
    // Auto-batching returns update count 1 by default, as this is what ORMs normally expect.
    // Standard batches return -1 by default, to indicate that the update count is unknown.
    return isAutoBatch() ? autoBatchUpdateCountSupplier.get() : dmlbatchUpdateCountSupplier.get();
  }

  @Override
  public ApiFuture<Long> executeUpdateAsync(
      CallType callType, ParsedStatement update, UpdateOption... options) {
    ConnectionPreconditions.checkState(
        state == UnitOfWorkState.STARTED,
        "The batch is no longer active and cannot be used for further statements");
    Preconditions.checkArgument(
        update.getType() == StatementType.UPDATE,
        "Only DML statements are allowed. \"" + update.getSql() + "\" is not a DML-statement.");
    long updateCount = getUpdateCount();
    this.statements.add(update);
    this.updateCounts = Arrays.copyOf(this.updateCounts, this.updateCounts.length + 1);
    this.updateCounts[this.updateCounts.length - 1] = updateCount;
    return ApiFutures.immediateFuture(updateCount);
  }

  @Override
  public ApiFuture<ResultSet> analyzeUpdateAsync(
      CallType callType, ParsedStatement update, AnalyzeMode analyzeMode, UpdateOption... options) {
    if (transaction.isSingleUse()) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.FAILED_PRECONDITION, "Analyzing updates is not allowed for DML batches.");
    }
    return transaction.analyzeUpdateAsync(callType, update, analyzeMode, options);
  }

  @Override
  public ApiFuture<long[]> executeBatchUpdateAsync(
      CallType callType, Iterable<ParsedStatement> updates, UpdateOption... options) {
    ConnectionPreconditions.checkState(
        state == UnitOfWorkState.STARTED,
        "The batch is no longer active and cannot be used for further statements");
    for (ParsedStatement update : updates) {
      Preconditions.checkArgument(
          update.getType() == StatementType.UPDATE,
          "Only DML statements are allowed. \"" + update.getSql() + "\" is not a DML-statement.");
    }
    long[] updateCountArray = new long[Iterables.size(updates)];
    Arrays.fill(updateCountArray, getUpdateCount());
    Iterables.addAll(this.statements, updates);
    this.updateCounts =
        Arrays.copyOf(this.updateCounts, this.updateCounts.length + updateCountArray.length);
    System.arraycopy(
        updateCountArray,
        0,
        this.updateCounts,
        this.updateCounts.length - updateCountArray.length,
        updateCountArray.length);

    return ApiFutures.immediateFuture(updateCountArray);
  }

  @Override
  public ApiFuture<Void> writeAsync(CallType callType, Iterable<Mutation> mutations) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Writing mutations is not allowed for DML batches.");
  }

  @Override
  public ApiFuture<long[]> runBatchAsync(CallType callType) {
    ConnectionPreconditions.checkState(
        state == UnitOfWorkState.STARTED, "The batch is no longer active and cannot be ran");
    try (Scope ignore = span.makeCurrent()) {
      if (statements.isEmpty()) {
        this.state = UnitOfWorkState.RAN;
        return ApiFutures.immediateFuture(new long[0]);
      }
      this.state = UnitOfWorkState.RUNNING;
      // Use a SettableApiFuture to return the result, instead of directly returning the future that
      // is returned by the executeBatchUpdateAsync method. This is needed because the state of the
      // batch is set after the update has finished, and this happens in a listener. A listener is
      // executed AFTER a Future is done, which means that a user could read the state of the Batch
      // before it has been changed.
      final SettableApiFuture<long[]> res = SettableApiFuture.create();
      int numOptions = 0;
      if (statementTag != null) {
        numOptions++;
      }
      if (this.rpcPriority != null) {
        numOptions++;
      }
      UpdateOption[] options = new UpdateOption[numOptions];
      int index = 0;
      if (statementTag != null) {
        options[index++] = Options.tag(statementTag);
      }
      if (this.rpcPriority != null) {
        options[index++] = Options.priority(this.rpcPriority);
      }
      ApiFuture<long[]> updateCounts =
          transaction.executeBatchUpdateAsync(callType, statements, options);
      ApiFutures.addCallback(
          updateCounts,
          new ApiFutureCallback<long[]>() {
            @Override
            public void onFailure(Throwable t) {
              state = UnitOfWorkState.RUN_FAILED;
              res.setException(t);
            }

            @Override
            public void onSuccess(long[] result) {
              state = UnitOfWorkState.RAN;
              if (!verifyUpdateCounts(result)) {
                res.setException(
                    SpannerExceptionFactory.newDmlBatchUpdateCountVerificationFailedException(
                        DmlBatch.this.updateCounts, result));
              } else {
                res.set(result);
              }
            }
          },
          MoreExecutors.directExecutor());
      asyncEndUnitOfWorkSpan();
      return res;
    }
  }

  private boolean verifyUpdateCounts(long[] actualUpdateCounts) {
    if (!this.autoBatch || !this.verifyUpdateCountsSupplier.get()) {
      // We only need to do an actual verification if the batch was an auto-batch and verification
      // is enabled.
      return true;
    }
    return Arrays.equals(this.updateCounts, actualUpdateCounts);
  }

  @Override
  public void abortBatch() {
    ConnectionPreconditions.checkState(
        state == UnitOfWorkState.STARTED, "The batch is no longer active and cannot be aborted.");
    asyncEndUnitOfWorkSpan();
    this.state = UnitOfWorkState.ABORTED;
  }

  @Override
  public ApiFuture<Void> commitAsync(
      @Nonnull CallType callType, @Nonnull EndTransactionCallback callback) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Commit is not allowed for DML batches.");
  }

  @Override
  public ApiFuture<Void> rollbackAsync(
      @Nonnull CallType callType, @Nonnull EndTransactionCallback callback) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Rollback is not allowed for DML batches.");
  }

  @Override
  String getUnitOfWorkName() {
    return "DML batch";
  }
}
