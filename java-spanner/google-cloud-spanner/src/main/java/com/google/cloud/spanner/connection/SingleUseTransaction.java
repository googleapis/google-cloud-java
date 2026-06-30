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

import static com.google.cloud.spanner.connection.AbstractStatementParser.COMMIT_STATEMENT;
import static com.google.cloud.spanner.connection.AbstractStatementParser.RUN_BATCH_STATEMENT;
import static com.google.cloud.spanner.connection.ConnectionProperties.AUTOCOMMIT_DML_MODE;
import static com.google.cloud.spanner.connection.ConnectionProperties.DEFAULT_ISOLATION_LEVEL;
import static com.google.cloud.spanner.connection.ConnectionProperties.DEFAULT_SEQUENCE_KIND;
import static com.google.cloud.spanner.connection.ConnectionProperties.MAX_COMMIT_DELAY;
import static com.google.cloud.spanner.connection.ConnectionProperties.READONLY;
import static com.google.cloud.spanner.connection.ConnectionProperties.READ_LOCK_MODE;
import static com.google.cloud.spanner.connection.ConnectionProperties.READ_ONLY_STALENESS;
import static com.google.cloud.spanner.connection.ConnectionProperties.RETURN_COMMIT_STATS;
import static com.google.cloud.spanner.connection.DdlClient.isCreateDatabaseStatement;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.Tuple;
import com.google.cloud.spanner.BatchClient;
import com.google.cloud.spanner.BatchReadOnlyTransaction;
import com.google.cloud.spanner.CommitResponse;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.QueryUpdateOption;
import com.google.cloud.spanner.Options.UpdateOption;
import com.google.cloud.spanner.PartitionOptions;
import com.google.cloud.spanner.ReadOnlyTransaction;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerApiFutures;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.TransactionMutationLimitExceededException;
import com.google.cloud.spanner.TransactionRunner;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.AbstractStatementParser.StatementType;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.spanner.admin.database.v1.DatabaseAdminGrpc;
import com.google.spanner.v1.SpannerGrpc;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;
import io.opentelemetry.context.Scope;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nonnull;

/**
 * Transaction that is used when a {@link Connection} is in autocommit mode. Each method on this
 * transaction actually starts a new transaction on Spanner. The type of transaction that is started
 * depends on the type of statement that is being executed. A {@link SingleUseTransaction} will
 * always try to choose the most efficient type of one-time transaction that is available for the
 * statement.
 *
 * <p>A {@link SingleUseTransaction} can be used to execute any type of statement on Cloud Spanner:
 *
 * <ul>
 *   <li>Client side statements, e.g. SHOW VARIABLE AUTOCOMMIT
 *   <li>Queries, e.g. SELECT * FROM FOO
 *   <li>DML statements, e.g. UPDATE FOO SET BAR=1
 *   <li>DDL statements, e.g. CREATE TABLE FOO (...)
 * </ul>
 */
class SingleUseTransaction extends AbstractBaseUnitOfWork {
  private final DdlClient ddlClient;
  private final DatabaseClient dbClient;
  private final BatchClient batchClient;
  private final ConnectionState connectionState;
  private final boolean internalMetadataQuery;
  private final byte[] protoDescriptors;
  private volatile SettableApiFuture<Timestamp> readTimestamp = null;
  private volatile TransactionRunner writeTransaction;
  private boolean used = false;
  private volatile UnitOfWorkState state = UnitOfWorkState.STARTED;

  static class Builder extends AbstractBaseUnitOfWork.Builder<Builder, SingleUseTransaction> {
    private DdlClient ddlClient;
    private DatabaseClient dbClient;
    private BatchClient batchClient;
    private ConnectionState connectionState;
    private boolean internalMetadataQuery;
    private byte[] protoDescriptors;

    private Builder() {}

    Builder setDdlClient(DdlClient ddlClient) {
      Preconditions.checkNotNull(ddlClient);
      this.ddlClient = ddlClient;
      return this;
    }

    Builder setDatabaseClient(DatabaseClient client) {
      Preconditions.checkNotNull(client);
      this.dbClient = client;
      return this;
    }

    Builder setBatchClient(BatchClient batchClient) {
      this.batchClient = Preconditions.checkNotNull(batchClient);
      return this;
    }

    Builder setConnectionState(ConnectionState connectionState) {
      this.connectionState = connectionState;
      return this;
    }

    Builder setInternalMetadataQuery(boolean internalMetadataQuery) {
      this.internalMetadataQuery = internalMetadataQuery;
      return this;
    }

    Builder setProtoDescriptors(byte[] protoDescriptors) {
      this.protoDescriptors = protoDescriptors;
      return this;
    }

    @Override
    SingleUseTransaction build() {
      Preconditions.checkState(ddlClient != null, "No DDL client specified");
      Preconditions.checkState(dbClient != null, "No DatabaseClient client specified");
      Preconditions.checkState(batchClient != null, "No BatchClient client specified");
      return new SingleUseTransaction(this);
    }
  }

  static Builder newBuilder() {
    return new Builder();
  }

  private SingleUseTransaction(Builder builder) {
    super(builder);
    this.ddlClient = builder.ddlClient;
    this.dbClient = builder.dbClient;
    this.batchClient = builder.batchClient;
    this.internalMetadataQuery = builder.internalMetadataQuery;
    this.protoDescriptors = builder.protoDescriptors;
    this.connectionState = builder.connectionState;
  }

  @Override
  public boolean isSingleUse() {
    return true;
  }

  @Override
  public Type getType() {
    return Type.TRANSACTION;
  }

  @Override
  public UnitOfWorkState getState() {
    return state;
  }

  @Override
  public boolean isActive() {
    // Single-use transactions are never active as they can be used only once.
    return false;
  }

  @Override
  public boolean isReadOnly() {
    return connectionState.getValue(READONLY).getValue();
  }

  AutocommitDmlMode getAutocommitDmlMode() {
    return connectionState.getValue(AUTOCOMMIT_DML_MODE).getValue();
  }

  @Override
  public boolean supportsDirectedReads(ParsedStatement parsedStatement) {
    return parsedStatement.isQuery();
  }

  private boolean isRetryDmlAsPartitionedDml() {
    return getAutocommitDmlMode()
        == AutocommitDmlMode.TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC;
  }

  private void checkAndMarkUsed() {
    Preconditions.checkState(!used, "This single-use transaction has already been used");
    used = true;
  }

  @Override
  public ApiFuture<ResultSet> executeQueryAsync(
      final CallType callType,
      final ParsedStatement statement,
      final AnalyzeMode analyzeMode,
      final QueryOption... options) {
    Preconditions.checkNotNull(statement);
    Preconditions.checkArgument(
        statement.isQuery()
            || (statement.isUpdate()
                && (analyzeMode != AnalyzeMode.NONE || statement.hasReturningClause())),
        "The statement must be a query, or the statement must be DML and AnalyzeMode must be PLAN"
            + " or PROFILE");
    try (Scope ignore = span.makeCurrent()) {
      checkAndMarkUsed();

      if (statement.isUpdate()) {
        if (analyzeMode != AnalyzeMode.NONE) {
          return analyzeTransactionalUpdateAsync(callType, statement, analyzeMode);
        }
        // DML with returning clause.
        return executeDmlReturningAsync(callType, statement, options);
      }

      // Do not use a read-only staleness for internal metadata queries.
      final ReadOnlyTransaction currentTransaction =
          internalMetadataQuery
              ? dbClient.singleUseReadOnlyTransaction()
              : dbClient.singleUseReadOnlyTransaction(
                  connectionState.getValue(READ_ONLY_STALENESS).getValue());
      Callable<ResultSet> callable =
          () -> {
            try {
              ResultSet rs;
              if (analyzeMode == AnalyzeMode.NONE) {
                rs = currentTransaction.executeQuery(statement.getStatement(), options);
              } else {
                rs =
                    currentTransaction.analyzeQuery(
                        statement.getStatement(), analyzeMode.getQueryAnalyzeMode());
              }
              // Return a DirectExecuteResultSet, which will directly do a next() call in order to
              // ensure that the query is actually sent to Spanner.
              ResultSet directRs = DirectExecuteResultSet.ofResultSet(rs);
              state = UnitOfWorkState.COMMITTED;
              readTimestamp.set(currentTransaction.getReadTimestamp());
              return directRs;
            } catch (Throwable t) {
              state = UnitOfWorkState.COMMIT_FAILED;
              readTimestamp.set(null);
              currentTransaction.close();
              throw t;
            }
          };
      readTimestamp = SettableApiFuture.create();
      return executeStatementAsync(
          callType, statement, callable, SpannerGrpc.getExecuteStreamingSqlMethod());
    }
  }

  private ApiFuture<ResultSet> executeDmlReturningAsync(
      CallType callType, final ParsedStatement update, QueryOption... options) {
    Callable<ResultSet> callable =
        () -> {
          try {
            writeTransaction = createWriteTransaction();
            ResultSet resultSet =
                writeTransaction.run(
                    transaction ->
                        DirectExecuteResultSet.ofResultSet(
                            transaction.executeQuery(
                                update.getStatement(), appendLastStatement(options))));
            state = UnitOfWorkState.COMMITTED;
            return resultSet;
          } catch (Throwable t) {
            state = UnitOfWorkState.COMMIT_FAILED;
            throw t;
          }
        };
    return executeStatementAsync(
        callType,
        update,
        callable,
        ImmutableList.of(SpannerGrpc.getExecuteSqlMethod(), SpannerGrpc.getCommitMethod()));
  }

  @Override
  public ApiFuture<ResultSet> partitionQueryAsync(
      CallType callType,
      ParsedStatement query,
      PartitionOptions partitionOptions,
      QueryOption... options) {
    try (Scope ignore = span.makeCurrent()) {
      Callable<ResultSet> callable =
          () -> {
            try (BatchReadOnlyTransaction transaction =
                batchClient.batchReadOnlyTransaction(
                    connectionState.getValue(READ_ONLY_STALENESS).getValue())) {
              ResultSet resultSet = partitionQuery(transaction, partitionOptions, query, options);
              readTimestamp.set(transaction.getReadTimestamp());
              state = UnitOfWorkState.COMMITTED;
              return resultSet;
            } catch (Throwable throwable) {
              state = UnitOfWorkState.COMMIT_FAILED;
              readTimestamp.set(null);
              throw throwable;
            }
          };
      readTimestamp = SettableApiFuture.create();
      return executeStatementAsync(
          callType,
          query,
          callable,
          ImmutableList.of(SpannerGrpc.getExecuteSqlMethod(), SpannerGrpc.getCommitMethod()));
    }
  }

  @Override
  public Timestamp getReadTimestamp() {
    ConnectionPreconditions.checkState(
        SpannerApiFutures.getOrNull(readTimestamp) != null,
        "There is no read timestamp available for this transaction.");
    return SpannerApiFutures.get(readTimestamp);
  }

  @Override
  public Timestamp getReadTimestampOrNull() {
    return SpannerApiFutures.getOrNull(readTimestamp);
  }

  private boolean hasCommitResponse() {
    return state == UnitOfWorkState.COMMITTED && writeTransaction != null;
  }

  @Override
  public Timestamp getCommitTimestamp() {
    ConnectionPreconditions.checkState(
        hasCommitResponse(), "There is no commit timestamp available for this transaction.");
    return getCommitResponse().getCommitTimestamp();
  }

  @Override
  public Timestamp getCommitTimestampOrNull() {
    CommitResponse response = getCommitResponseOrNull();
    return response == null ? null : response.getCommitTimestamp();
  }

  @Override
  public CommitResponse getCommitResponse() {
    ConnectionPreconditions.checkState(
        hasCommitResponse(), "There is no commit response available for this transaction.");
    return writeTransaction.getCommitResponse();
  }

  @Override
  public CommitResponse getCommitResponseOrNull() {
    if (hasCommitResponse()) {
      try {
        return writeTransaction.getCommitResponse();
      } catch (SpannerException e) {
        // ignore
      }
    }
    return null;
  }

  @Override
  public ApiFuture<Void> executeDdlAsync(CallType callType, final ParsedStatement ddl) {
    Preconditions.checkNotNull(ddl);
    Preconditions.checkArgument(
        ddl.getType() == StatementType.DDL, "Statement is not a ddl statement");
    ConnectionPreconditions.checkState(
        !isReadOnly(), "DDL statements are not allowed in read-only mode");
    try (Scope ignore = span.makeCurrent()) {
      checkAndMarkUsed();
      span.setAttribute(DB_STATEMENT_KEY, ddl.getStatement().getSql());

      Callable<Void> callable =
          () -> {
            try {
              if (isCreateDatabaseStatement(dbClient.getDialect(), ddl.getSql())) {
                executeCreateDatabase(ddl);
              } else {
                ddlClient.runWithRetryForMissingDefaultSequenceKind(
                    restartIndex -> {
                      OperationFuture<?, ?> operation =
                          ddlClient.executeDdl(ddl.getSql(), protoDescriptors);
                      getWithStatementTimeout(operation, ddl);
                    },
                    connectionState.getValue(DEFAULT_SEQUENCE_KIND).getValue(),
                    dbClient.getDialect(),
                    new AtomicReference<>());
              }
              state = UnitOfWorkState.COMMITTED;
              return null;
            } catch (Throwable t) {
              state = UnitOfWorkState.COMMIT_FAILED;
              throw t;
            }
          };
      return executeStatementAsync(
          callType, ddl, callable, DatabaseAdminGrpc.getUpdateDatabaseDdlMethod());
    }
  }

  private void executeCreateDatabase(ParsedStatement ddl) {
    OperationFuture<?, ?> operation =
        ddlClient.executeCreateDatabase(ddl.getSql(), dbClient.getDialect());
    getWithStatementTimeout(operation, ddl);
  }

  @Override
  public ApiFuture<Long> executeUpdateAsync(
      CallType callType, ParsedStatement update, UpdateOption... options) {
    Preconditions.checkNotNull(update);
    Preconditions.checkArgument(update.isUpdate(), "Statement is not an update statement");
    ConnectionPreconditions.checkState(
        !isReadOnly(), "Update statements are not allowed in read-only mode");
    try (Scope ignore = span.makeCurrent()) {
      checkAndMarkUsed();

      ApiFuture<Long> res;
      switch (getAutocommitDmlMode()) {
        case TRANSACTIONAL:
        case TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC:
          res =
              ApiFutures.transform(
                  executeTransactionalUpdateAsync(callType, update, AnalyzeMode.NONE, options),
                  Tuple::x,
                  MoreExecutors.directExecutor());
          break;
        case PARTITIONED_NON_ATOMIC:
          res = executePartitionedUpdateAsync(callType, update, options);
          break;
        default:
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.FAILED_PRECONDITION, "Unknown dml mode: " + getAutocommitDmlMode());
      }
      return res;
    }
  }

  @Override
  public ApiFuture<ResultSet> analyzeUpdateAsync(
      CallType callType, ParsedStatement update, AnalyzeMode analyzeMode, UpdateOption... options) {
    Preconditions.checkNotNull(update);
    Preconditions.checkArgument(update.isUpdate(), "Statement is not an update statement");
    ConnectionPreconditions.checkState(
        !isReadOnly(), "Update statements are not allowed in read-only mode");
    ConnectionPreconditions.checkState(
        getAutocommitDmlMode() != AutocommitDmlMode.PARTITIONED_NON_ATOMIC,
        "Analyzing update statements is not supported for Partitioned DML");
    try (Scope ignore = span.makeCurrent()) {
      checkAndMarkUsed();

      return ApiFutures.transform(
          executeTransactionalUpdateAsync(callType, update, analyzeMode, options),
          Tuple::y,
          MoreExecutors.directExecutor());
    }
  }

  @Override
  public ApiFuture<long[]> executeBatchUpdateAsync(
      CallType callType, Iterable<ParsedStatement> updates, UpdateOption... options) {
    Preconditions.checkNotNull(updates);
    for (ParsedStatement update : updates) {
      Preconditions.checkArgument(
          update.isUpdate(), "Statement is not an update statement: " + update.getSql());
    }
    ConnectionPreconditions.checkState(
        !isReadOnly(), "Batch update statements are not allowed in read-only mode");
    try (Scope ignore = span.makeCurrent()) {
      checkAndMarkUsed();

      switch (getAutocommitDmlMode()) {
        case TRANSACTIONAL:
          return executeTransactionalBatchUpdateAsync(callType, updates, options);
        case PARTITIONED_NON_ATOMIC:
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.FAILED_PRECONDITION,
              "Batch updates are not allowed in " + getAutocommitDmlMode());
        default:
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.FAILED_PRECONDITION, "Unknown dml mode: " + getAutocommitDmlMode());
      }
    }
  }

  private TransactionRunner createWriteTransaction() {
    int numOptions = 0;
    if (this.rpcPriority != null) {
      numOptions++;
    }
    if (connectionState.getValue(RETURN_COMMIT_STATS).getValue()) {
      numOptions++;
    }
    if (excludeTxnFromChangeStreams) {
      numOptions++;
    }
    if (connectionState.getValue(MAX_COMMIT_DELAY).getValue() != null) {
      numOptions++;
    }
    if (connectionState.getValue(DEFAULT_ISOLATION_LEVEL).getValue()
        != IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED) {
      numOptions++;
    }
    if (connectionState.getValue(READ_LOCK_MODE).getValue()
        != ReadLockMode.READ_LOCK_MODE_UNSPECIFIED) {
      numOptions++;
    }
    if (this.clientContext != null) {
      numOptions++;
    }
    if (numOptions == 0) {
      return dbClient.readWriteTransaction();
    }
    Options.TransactionOption[] options = new Options.TransactionOption[numOptions];
    int index = 0;
    if (this.rpcPriority != null) {
      options[index++] = Options.priority(this.rpcPriority);
    }
    if (connectionState.getValue(RETURN_COMMIT_STATS).getValue()) {
      options[index++] = Options.commitStats();
    }
    if (excludeTxnFromChangeStreams) {
      options[index++] = Options.excludeTxnFromChangeStreams();
    }
    if (connectionState.getValue(MAX_COMMIT_DELAY).getValue() != null) {
      options[index++] =
          Options.maxCommitDelay(connectionState.getValue(MAX_COMMIT_DELAY).getValue());
    }
    if (connectionState.getValue(DEFAULT_ISOLATION_LEVEL).getValue()
        != IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED) {
      options[index++] =
          Options.isolationLevel(connectionState.getValue(DEFAULT_ISOLATION_LEVEL).getValue());
    }
    if (connectionState.getValue(READ_LOCK_MODE).getValue()
        != ReadLockMode.READ_LOCK_MODE_UNSPECIFIED) {
      options[index++] = Options.readLockMode(connectionState.getValue(READ_LOCK_MODE).getValue());
    }
    if (this.clientContext != null) {
      options[index++] = Options.clientContext(this.clientContext);
    }
    return dbClient.readWriteTransaction(options);
  }

  private ApiFuture<Tuple<Long, ResultSet>> executeTransactionalUpdateAsync(
      CallType callType,
      final ParsedStatement update,
      AnalyzeMode analyzeMode,
      final UpdateOption... options) {
    Callable<Tuple<Long, ResultSet>> callable =
        () -> {
          try {
            writeTransaction = createWriteTransaction();
            Tuple<Long, ResultSet> res =
                writeTransaction.run(
                    transaction -> {
                      if (analyzeMode == AnalyzeMode.NONE) {
                        return Tuple.of(
                            transaction.executeUpdate(
                                update.getStatement(), appendLastStatement(options)),
                            null);
                      }
                      ResultSet resultSet =
                          transaction.analyzeUpdateStatement(
                              update.getStatement(),
                              analyzeMode.getQueryAnalyzeMode(),
                              appendLastStatement(options));
                      return Tuple.of(null, resultSet);
                    });
            state = UnitOfWorkState.COMMITTED;
            return res;
          } catch (Throwable t) {
            state = UnitOfWorkState.COMMIT_FAILED;
            throw t;
          }
        };
    ApiFuture<Tuple<Long, ResultSet>> transactionalResult =
        executeStatementAsync(
            callType,
            update,
            callable,
            ImmutableList.of(SpannerGrpc.getExecuteSqlMethod(), SpannerGrpc.getCommitMethod()));
    // Retry as Partitioned DML if the statement fails due to exceeding the mutation limit if that
    // option has been enabled.
    if (isRetryDmlAsPartitionedDml()) {
      return addRetryUpdateAsPartitionedDmlCallback(transactionalResult, callType, update, options);
    }
    return transactionalResult;
  }

  private static final QueryUpdateOption[] LAST_STATEMENT_OPTIONS =
      new QueryUpdateOption[] {Options.lastStatement()};

  private static UpdateOption[] appendLastStatement(UpdateOption[] options) {
    if (options.length == 0) {
      return LAST_STATEMENT_OPTIONS;
    }
    UpdateOption[] result = new UpdateOption[options.length + 1];
    System.arraycopy(options, 0, result, 0, options.length);
    result[result.length - 1] = LAST_STATEMENT_OPTIONS[0];
    return result;
  }

  private static QueryOption[] appendLastStatement(QueryOption[] options) {
    if (options.length == 0) {
      return LAST_STATEMENT_OPTIONS;
    }
    QueryOption[] result = new QueryOption[options.length + 1];
    System.arraycopy(options, 0, result, 0, options.length);
    result[result.length - 1] = LAST_STATEMENT_OPTIONS[0];
    return result;
  }

  /**
   * Adds a callback to the given future that retries the update statement using Partitioned DML if
   * the original statement fails with a {@link TransactionMutationLimitExceededException}.
   */
  private ApiFuture<Tuple<Long, ResultSet>> addRetryUpdateAsPartitionedDmlCallback(
      ApiFuture<Tuple<Long, ResultSet>> transactionalResult,
      CallType callType,
      final ParsedStatement update,
      final UpdateOption... options) {
    // Catch TransactionMutationLimitExceededException and retry as Partitioned DML. All other
    // exceptions are just propagated.
    return ApiFutures.catchingAsync(
        transactionalResult,
        TransactionMutationLimitExceededException.class,
        mutationLimitExceededException -> {
          UUID executionId = UUID.randomUUID();
          // Invoke the retryDmlAsPartitionedDmlStarting method for the TransactionRetryListeners
          // that have been registered for the connection.
          for (TransactionRetryListener listener : this.transactionRetryListeners) {
            listener.retryDmlAsPartitionedDmlStarting(
                executionId, update.getStatement(), mutationLimitExceededException);
          }
          // Try to execute the DML statement as Partitioned DML.
          ApiFuture<Tuple<Long, ResultSet>> partitionedResult =
              ApiFutures.transform(
                  executePartitionedUpdateAsync(callType, update, options),
                  lowerBoundUpdateCount -> Tuple.of(lowerBoundUpdateCount, null),
                  MoreExecutors.directExecutor());

          // Add a callback to the future that invokes the TransactionRetryListeners after the
          // Partitioned DML statement finished. This will invoke either the Finished or Failed
          // method on the listeners.
          ApiFutures.addCallback(
              partitionedResult,
              new ApiFutureCallback<Tuple<Long, ResultSet>>() {
                @Override
                public void onFailure(Throwable throwable) {
                  for (TransactionRetryListener listener :
                      SingleUseTransaction.this.transactionRetryListeners) {
                    listener.retryDmlAsPartitionedDmlFailed(
                        executionId, update.getStatement(), throwable);
                  }
                }

                @Override
                public void onSuccess(Tuple<Long, ResultSet> result) {
                  for (TransactionRetryListener listener :
                      SingleUseTransaction.this.transactionRetryListeners) {
                    listener.retryDmlAsPartitionedDmlFinished(
                        executionId, update.getStatement(), result.x());
                  }
                }
              },
              MoreExecutors.directExecutor());

          // Catch any exception from the Partitioned DML execution and throw the original
          // TransactionMutationLimitExceededException instead.
          // The exception that is returned for the Partitioned DML statement is added to the
          // exception as a suppressed exception.
          return ApiFutures.catching(
              partitionedResult,
              Throwable.class,
              input -> {
                mutationLimitExceededException.addSuppressed(input);
                throw mutationLimitExceededException;
              },
              MoreExecutors.directExecutor());
        },
        MoreExecutors.directExecutor());
  }

  private ApiFuture<ResultSet> analyzeTransactionalUpdateAsync(
      CallType callType, final ParsedStatement update, AnalyzeMode analyzeMode) {
    Callable<ResultSet> callable =
        () -> {
          try {
            writeTransaction = createWriteTransaction();
            ResultSet resultSet =
                writeTransaction.run(
                    transaction ->
                        DirectExecuteResultSet.ofResultSet(
                            transaction.analyzeQuery(
                                update.getStatement(), analyzeMode.getQueryAnalyzeMode())));
            state = UnitOfWorkState.COMMITTED;
            return resultSet;
          } catch (Throwable t) {
            state = UnitOfWorkState.COMMIT_FAILED;
            throw t;
          }
        };
    return executeStatementAsync(
        callType,
        update,
        callable,
        ImmutableList.of(SpannerGrpc.getExecuteSqlMethod(), SpannerGrpc.getCommitMethod()));
  }

  private ApiFuture<Long> executePartitionedUpdateAsync(
      CallType callType, final ParsedStatement update, final UpdateOption... options) {
    final UpdateOption[] effectiveOptions;
    if (excludeTxnFromChangeStreams) {
      if (options.length == 0) {
        effectiveOptions = new UpdateOption[] {Options.excludeTxnFromChangeStreams()};
      } else {
        effectiveOptions = Arrays.copyOf(options, options.length + 1);
        effectiveOptions[effectiveOptions.length - 1] = Options.excludeTxnFromChangeStreams();
      }
    } else {
      effectiveOptions = options;
    }
    Callable<Long> callable =
        () -> {
          try {
            Long res = dbClient.executePartitionedUpdate(update.getStatement(), effectiveOptions);
            state = UnitOfWorkState.COMMITTED;
            return res;
          } catch (Throwable t) {
            state = UnitOfWorkState.COMMIT_FAILED;
            throw t;
          }
        };
    return executeStatementAsync(
        callType, update, callable, SpannerGrpc.getExecuteStreamingSqlMethod());
  }

  private ApiFuture<long[]> executeTransactionalBatchUpdateAsync(
      final CallType callType,
      final Iterable<ParsedStatement> updates,
      final UpdateOption... options) {
    Callable<long[]> callable =
        () -> {
          writeTransaction = createWriteTransaction();
          return writeTransaction.run(
              transaction -> {
                try {
                  long[] res =
                      transaction.batchUpdate(
                          Iterables.transform(updates, ParsedStatement::getStatement),
                          appendLastStatement(options));
                  state = UnitOfWorkState.COMMITTED;
                  return res;
                } catch (Throwable t) {
                  if (t instanceof SpannerBatchUpdateException) {
                    // Batch update exceptions does not cause a rollback.
                    state = UnitOfWorkState.COMMITTED;
                  } else {
                    state = UnitOfWorkState.COMMIT_FAILED;
                  }
                  throw t;
                }
              });
        };
    return executeStatementAsync(
        callType, RUN_BATCH_STATEMENT, callable, SpannerGrpc.getExecuteBatchDmlMethod());
  }

  @Override
  public ApiFuture<Void> writeAsync(CallType callType, final Iterable<Mutation> mutations) {
    Preconditions.checkNotNull(mutations);
    ConnectionPreconditions.checkState(
        !isReadOnly(), "Update statements are not allowed in read-only mode");
    try (Scope ignore = span.makeCurrent()) {
      checkAndMarkUsed();

      Callable<Void> callable =
          () -> {
            try {
              writeTransaction = createWriteTransaction();
              Void res =
                  writeTransaction.run(
                      transaction -> {
                        transaction.buffer(mutations);
                        return null;
                      });
              state = UnitOfWorkState.COMMITTED;
              return res;
            } catch (Throwable t) {
              state = UnitOfWorkState.COMMIT_FAILED;
              throw t;
            }
          };
      return executeStatementAsync(
          callType, COMMIT_STATEMENT, callable, SpannerGrpc.getCommitMethod());
    }
  }

  @Override
  public ApiFuture<Void> commitAsync(
      @Nonnull CallType callType, @Nonnull EndTransactionCallback callback) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Commit is not supported for single-use transactions");
  }

  @Override
  public ApiFuture<Void> rollbackAsync(
      @Nonnull CallType callType, @Nonnull EndTransactionCallback callback) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Rollback is not supported for single-use transactions");
  }

  @Override
  String getUnitOfWorkName() {
    return "single-use transaction";
  }

  @Override
  public ApiFuture<long[]> runBatchAsync(CallType callType) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Run batch is not supported for single-use transactions");
  }

  @Override
  public void abortBatch() {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Run batch is not supported for single-use transactions");
  }
}
