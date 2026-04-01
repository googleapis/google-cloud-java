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

import static com.google.cloud.spanner.connection.AbstractStatementParser.RUN_BATCH_STATEMENT;
import static com.google.cloud.spanner.connection.ConnectionProperties.DEFAULT_SEQUENCE_KIND;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.CommitResponse;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.UpdateOption;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.AbstractStatementParser.StatementType;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.spanner.admin.database.v1.DatabaseAdminGrpc;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nonnull;

/**
 * {@link UnitOfWork} that is used when a DDL batch is started. These batches only accept DDL
 * statements. All DDL statements are buffered locally and sent to Spanner when runBatch() is
 * called. Running a {@link DdlBatch} is not an atomic operation. If the execution fails, then some
 * (possibly empty) prefix of the statements in the batch have been successfully applied to the
 * database, and the others have not. Note that the statements that succeed may not all happen at
 * the same time, but they will always happen in order.
 */
class DdlBatch extends AbstractBaseUnitOfWork {
  private final DdlClient ddlClient;
  private final DatabaseClient dbClient;
  private final List<String> statements = new ArrayList<>();
  private UnitOfWorkState state = UnitOfWorkState.STARTED;
  private final byte[] protoDescriptors;
  private final ConnectionState connectionState;

  static class Builder extends AbstractBaseUnitOfWork.Builder<Builder, DdlBatch> {
    private DdlClient ddlClient;
    private DatabaseClient dbClient;
    private byte[] protoDescriptors;
    private ConnectionState connectionState;

    private Builder() {}

    Builder setDdlClient(DdlClient client) {
      Preconditions.checkNotNull(client);
      this.ddlClient = client;
      return this;
    }

    Builder setDatabaseClient(DatabaseClient client) {
      Preconditions.checkNotNull(client);
      this.dbClient = client;
      return this;
    }

    Builder setProtoDescriptors(byte[] protoDescriptors) {
      this.protoDescriptors = protoDescriptors;
      return this;
    }

    Builder setConnectionState(ConnectionState connectionState) {
      this.connectionState = connectionState;
      return this;
    }

    @Override
    DdlBatch build() {
      Preconditions.checkState(ddlClient != null, "No DdlClient specified");
      Preconditions.checkState(dbClient != null, "No DbClient specified");
      return new DdlBatch(this);
    }
  }

  static Builder newBuilder() {
    return new Builder();
  }

  private DdlBatch(Builder builder) {
    super(builder);
    this.ddlClient = builder.ddlClient;
    this.dbClient = builder.dbClient;
    this.protoDescriptors = builder.protoDescriptors;
    this.connectionState = Preconditions.checkNotNull(builder.connectionState);
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
      final ParsedStatement statement,
      AnalyzeMode analyzeMode,
      QueryOption... options) {
    // Queries are by default not allowed on DDL batches.
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Executing queries is not allowed for DDL batches.");
  }

  @Override
  public Timestamp getReadTimestamp() {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "There is no read timestamp available for DDL batches.");
  }

  @Override
  public Timestamp getReadTimestampOrNull() {
    return null;
  }

  @Override
  public Timestamp getCommitTimestamp() {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "There is no commit timestamp available for DDL batches.");
  }

  @Override
  public Timestamp getCommitTimestampOrNull() {
    return null;
  }

  @Override
  public CommitResponse getCommitResponse() {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "There is no commit response available for DDL batches.");
  }

  @Override
  public CommitResponse getCommitResponseOrNull() {
    return null;
  }

  @Override
  public ApiFuture<Void> executeDdlAsync(CallType callType, ParsedStatement ddl) {
    ConnectionPreconditions.checkState(
        state == UnitOfWorkState.STARTED,
        "The batch is no longer active and cannot be used for further statements");
    Preconditions.checkArgument(
        ddl.getType() == StatementType.DDL,
        "Only DDL statements are allowed. \"" + ddl.getSql() + "\" is not a DDL-statement.");
    Preconditions.checkArgument(
        !DdlClient.isCreateDatabaseStatement(dbClient.getDialect(), ddl.getSql()),
        "CREATE DATABASE is not supported in DDL batches.");
    statements.add(ddl.getSql());
    return ApiFutures.immediateFuture(null);
  }

  @Override
  public ApiFuture<Long> executeUpdateAsync(
      CallType callType, ParsedStatement update, UpdateOption... options) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Executing updates is not allowed for DDL batches.");
  }

  @Override
  public ApiFuture<ResultSet> analyzeUpdateAsync(
      CallType callType, ParsedStatement update, AnalyzeMode analyzeMode, UpdateOption... options) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Analyzing updates is not allowed for DDL batches.");
  }

  @Override
  public ApiFuture<long[]> executeBatchUpdateAsync(
      CallType callType, Iterable<ParsedStatement> updates, UpdateOption... options) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Executing batch updates is not allowed for DDL batches.");
  }

  @Override
  public ApiFuture<Void> writeAsync(CallType callType, Iterable<Mutation> mutations) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Writing mutations is not allowed for DDL batches.");
  }

  @Override
  public ApiFuture<long[]> runBatchAsync(CallType callType) {
    ConnectionPreconditions.checkState(
        state == UnitOfWorkState.STARTED, "The batch is no longer active and cannot be ran");
    try (Scope ignore = span.makeCurrent()) {
      if (statements.isEmpty()) {
        this.state = UnitOfWorkState.RAN;
        return ApiFutures.transform(
            asyncEndUnitOfWorkSpan(), unused -> new long[0], MoreExecutors.directExecutor());
      }
      // Set the DDL statements on the span.

      span.setAllAttributes(Attributes.of(DB_STATEMENT_ARRAY_KEY, statements));
      // create a statement that can be passed in to the execute method
      Callable<long[]> callable =
          () -> {
            try {
              AtomicReference<OperationFuture<Void, UpdateDatabaseDdlMetadata>> operationReference =
                  new AtomicReference<>();
              try {
                ddlClient.runWithRetryForMissingDefaultSequenceKind(
                    restartIndex -> {
                      OperationFuture<Void, UpdateDatabaseDdlMetadata> operation =
                          ddlClient.executeDdl(
                              statements.subList(restartIndex, statements.size()),
                              protoDescriptors);
                      operationReference.set(operation);
                      // Wait until the operation has finished.
                      getWithStatementTimeout(operation, RUN_BATCH_STATEMENT);
                    },
                    connectionState.getValue(DEFAULT_SEQUENCE_KIND).getValue(),
                    dbClient.getDialect(),
                    operationReference);
                long[] updateCounts = new long[statements.size()];
                Arrays.fill(updateCounts, 1L);
                state = UnitOfWorkState.RAN;
                return updateCounts;
              } catch (SpannerException e) {
                long[] updateCounts = extractUpdateCounts(operationReference.get());
                throw SpannerExceptionFactory.newSpannerBatchUpdateException(
                    e.getErrorCode(), e.getMessage(), updateCounts);
              }
            } catch (Throwable t) {
              span.setStatus(StatusCode.ERROR);
              span.recordException(t);
              state = UnitOfWorkState.RUN_FAILED;
              throw t;
            }
          };
      this.state = UnitOfWorkState.RUNNING;
      ApiFuture<long[]> result =
          executeStatementAsync(
              callType,
              RUN_BATCH_STATEMENT,
              callable,
              DatabaseAdminGrpc.getUpdateDatabaseDdlMethod());
      asyncEndUnitOfWorkSpan();

      return result;
    }
  }

  long[] extractUpdateCounts(OperationFuture<Void, UpdateDatabaseDdlMetadata> operation) {
    try {
      return extractUpdateCounts(operation.getMetadata().get());
    } catch (Throwable t) {
      return new long[0];
    }
  }

  @VisibleForTesting
  long[] extractUpdateCounts(UpdateDatabaseDdlMetadata metadata) {
    long[] updateCounts = new long[metadata.getStatementsCount()];
    for (int i = 0; i < updateCounts.length; i++) {
      if (metadata.getCommitTimestampsCount() > i && metadata.getCommitTimestamps(i) != null) {
        updateCounts[i] = 1L;
      } else {
        updateCounts[i] = 0L;
      }
    }
    return updateCounts;
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
        ErrorCode.FAILED_PRECONDITION, "Commit is not allowed for DDL batches.");
  }

  @Override
  public ApiFuture<Void> rollbackAsync(
      @Nonnull CallType callType, @Nonnull EndTransactionCallback callback) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Rollback is not allowed for DDL batches.");
  }

  @Override
  String getUnitOfWorkName() {
    return "DDL batch";
  }
}
