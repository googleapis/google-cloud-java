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

import static com.google.cloud.spanner.connection.DialectNamespaceMapper.getNamespace;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.ABORT_BATCH;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.BEGIN;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.COMMIT;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.RESET_ALL;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.ROLLBACK;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.RUN_BATCH;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_AUTOCOMMIT;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_AUTOCOMMIT_DML_MODE;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_AUTO_BATCH_DML;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_AUTO_BATCH_DML_UPDATE_COUNT;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_AUTO_PARTITION_MODE;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_BATCH_DML_UPDATE_COUNT;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_DATA_BOOST_ENABLED;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_DEFAULT_TRANSACTION_ISOLATION;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_DIRECTED_READ;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_EXCLUDE_TXN_FROM_CHANGE_STREAMS;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_KEEP_TRANSACTION_ALIVE;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_MAX_COMMIT_DELAY;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_MAX_PARTITIONED_PARALLELISM;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_MAX_PARTITIONS;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_OPTIMIZER_STATISTICS_PACKAGE;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_OPTIMIZER_VERSION;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_PROTO_DESCRIPTORS;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_PROTO_DESCRIPTORS_FILE_PATH;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_READONLY;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_READ_LOCK_MODE;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_READ_ONLY_STALENESS;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_RETRY_ABORTS_INTERNALLY;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_RETURN_COMMIT_STATS;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_RPC_PRIORITY;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_SAVEPOINT_SUPPORT;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_STATEMENT_TAG;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_STATEMENT_TIMEOUT;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_TRANSACTION_MODE;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_TRANSACTION_TAG;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SET_TRANSACTION_TIMEOUT;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_AUTOCOMMIT;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_AUTOCOMMIT_DML_MODE;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_AUTO_BATCH_DML;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_AUTO_BATCH_DML_UPDATE_COUNT;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_AUTO_PARTITION_MODE;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_COMMIT_RESPONSE;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_COMMIT_TIMESTAMP;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_DATA_BOOST_ENABLED;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_DEFAULT_TRANSACTION_ISOLATION;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_DIRECTED_READ;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_EXCLUDE_TXN_FROM_CHANGE_STREAMS;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_KEEP_TRANSACTION_ALIVE;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_MAX_COMMIT_DELAY;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_MAX_PARTITIONED_PARALLELISM;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_MAX_PARTITIONS;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_OPTIMIZER_STATISTICS_PACKAGE;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_OPTIMIZER_VERSION;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_PROTO_DESCRIPTORS;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_PROTO_DESCRIPTORS_FILE_PATH;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_READONLY;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_READ_LOCK_MODE;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_READ_ONLY_STALENESS;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_READ_TIMESTAMP;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_RETRY_ABORTS_INTERNALLY;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_RETURN_COMMIT_STATS;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_RPC_PRIORITY;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_SAVEPOINT_SUPPORT;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_STATEMENT_TAG;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_STATEMENT_TIMEOUT;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_TRANSACTION_ISOLATION_LEVEL;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_TRANSACTION_TAG;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.SHOW_TRANSACTION_TIMEOUT;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.START_BATCH_DDL;
import static com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType.START_BATCH_DML;
import static com.google.cloud.spanner.connection.StatementResultImpl.noResult;
import static com.google.cloud.spanner.connection.StatementResultImpl.resultSet;

import com.google.cloud.spanner.CommitResponse;
import com.google.cloud.spanner.CommitStats;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Options.RpcPriority;
import com.google.cloud.spanner.PartitionOptions;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.connection.PgTransactionMode.IsolationLevel;
import com.google.cloud.spanner.connection.ReadOnlyStalenessUtil.DurationValueGetter;
import com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.PlanNode;
import com.google.spanner.v1.QueryPlan;
import com.google.spanner.v1.RequestOptions;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/**
 * The methods in this class are called by the different {@link ClientSideStatement}s. These method
 * calls are then forwarded into a {@link Connection}.
 */
class ConnectionStatementExecutorImpl implements ConnectionStatementExecutor {

  static final class StatementTimeoutGetter implements DurationValueGetter {
    private final Connection connection;

    public StatementTimeoutGetter(Connection connection) {
      this.connection = connection;
    }

    @Override
    public long getDuration(TimeUnit unit) {
      return connection.getStatementTimeout(unit);
    }

    @Override
    public boolean hasDuration() {
      return connection.hasStatementTimeout();
    }
  }

  /** The connection to execute the statements on. */
  private final ConnectionImpl connection;

  ConnectionStatementExecutorImpl(ConnectionImpl connection) {
    this.connection = connection;
  }

  ConnectionImpl getConnection() {
    return connection;
  }

  @Override
  public Dialect getDialect() {
    return getConnection().getDialect();
  }

  @Override
  public StatementResult statementSetAutocommit(Boolean autocommit) {
    Preconditions.checkNotNull(autocommit);
    getConnection().setAutocommit(autocommit);
    return noResult(SET_AUTOCOMMIT);
  }

  @Override
  public StatementResult statementShowAutocommit() {
    return resultSet("AUTOCOMMIT", getConnection().isAutocommit(), SHOW_AUTOCOMMIT);
  }

  @Override
  public StatementResult statementSetReadOnly(Boolean readOnly) {
    Preconditions.checkNotNull(readOnly);
    getConnection().setReadOnly(readOnly);
    return noResult(SET_READONLY);
  }

  @Override
  public StatementResult statementShowReadOnly() {
    return StatementResultImpl.resultSet(
        String.format("%sREADONLY", getNamespace(connection.getDialect())),
        getConnection().isReadOnly(),
        SHOW_READONLY);
  }

  @Override
  public StatementResult statementSetRetryAbortsInternally(
      Boolean retryAbortsInternally, Boolean local) {
    Preconditions.checkNotNull(retryAbortsInternally);
    getConnection().setRetryAbortsInternally(retryAbortsInternally, local);
    return noResult(SET_RETRY_ABORTS_INTERNALLY);
  }

  @Override
  public StatementResult statementShowRetryAbortsInternally() {
    return StatementResultImpl.resultSet(
        String.format("%sRETRY_ABORTS_INTERNALLY", getNamespace(connection.getDialect())),
        getConnection().isRetryAbortsInternally(),
        SHOW_RETRY_ABORTS_INTERNALLY);
  }

  @Override
  public StatementResult statementSetAutocommitDmlMode(AutocommitDmlMode mode) {
    getConnection().setAutocommitDmlMode(mode);
    return noResult(SET_AUTOCOMMIT_DML_MODE);
  }

  @Override
  public StatementResult statementShowAutocommitDmlMode() {
    return resultSet(
        String.format("%sAUTOCOMMIT_DML_MODE", getNamespace(connection.getDialect())),
        getConnection().getAutocommitDmlMode(),
        SHOW_AUTOCOMMIT_DML_MODE);
  }

  @Override
  public StatementResult statementSetStatementTimeout(Duration duration) {
    if (duration == null || duration.isZero()) {
      getConnection().clearStatementTimeout();
    } else {
      com.google.protobuf.Duration protoDuration =
          com.google.protobuf.Duration.newBuilder()
              .setSeconds(duration.getSeconds())
              .setNanos(duration.getNano())
              .build();
      TimeUnit unit =
          ReadOnlyStalenessUtil.getAppropriateTimeUnit(
              new ReadOnlyStalenessUtil.DurationGetter(protoDuration));
      getConnection()
          .setStatementTimeout(ReadOnlyStalenessUtil.durationToUnits(protoDuration, unit), unit);
    }
    return noResult(SET_STATEMENT_TIMEOUT);
  }

  @Override
  public StatementResult statementShowStatementTimeout() {
    return resultSet(
        "STATEMENT_TIMEOUT",
        getConnection().hasStatementTimeout()
            ? ReadOnlyStalenessUtil.durationToString(new StatementTimeoutGetter(getConnection()))
            : connection.getDialect() == Dialect.POSTGRESQL ? "0" : null,
        SHOW_STATEMENT_TIMEOUT);
  }

  @Override
  public StatementResult statementSetTransactionTimeout(Duration duration) {
    if (duration == null || duration.isZero()) {
      getConnection().setTransactionTimeout(null);
    } else {
      getConnection().setTransactionTimeout(duration);
    }
    return noResult(SET_TRANSACTION_TIMEOUT);
  }

  @Override
  public StatementResult statementShowTransactionTimeout() {
    return resultSet(
        String.format("%sTRANSACTION_TIMEOUT", getNamespace(connection.getDialect())),
        String.valueOf(getConnection().getTransactionTimeout()),
        SHOW_TRANSACTION_TIMEOUT);
  }

  @Override
  public StatementResult statementShowReadTimestamp() {
    return resultSet(
        String.format("%sREAD_TIMESTAMP", getNamespace(connection.getDialect())),
        getConnection().getReadTimestampOrNull(),
        SHOW_READ_TIMESTAMP);
  }

  @Override
  public StatementResult statementShowCommitTimestamp() {
    return resultSet(
        String.format("%sCOMMIT_TIMESTAMP", getNamespace(connection.getDialect())),
        getConnection().getCommitTimestampOrNull(),
        SHOW_COMMIT_TIMESTAMP);
  }

  @Override
  public StatementResult statementShowCommitResponse() {
    CommitResponse response = getConnection().getCommitResponseOrNull();
    CommitStats stats = null;
    if (response != null && response.hasCommitStats()) {
      stats = response.getCommitStats();
    }
    ResultSet resultSet =
        ResultSets.forRows(
            Type.struct(
                StructField.of(
                    String.format("%sCOMMIT_TIMESTAMP", getNamespace(connection.getDialect())),
                    Type.timestamp()),
                StructField.of(
                    String.format("%sMUTATION_COUNT", getNamespace(connection.getDialect())),
                    Type.int64())),
            Collections.singletonList(
                Struct.newBuilder()
                    .set(String.format("%sCOMMIT_TIMESTAMP", getNamespace(connection.getDialect())))
                    .to(response == null ? null : response.getCommitTimestamp())
                    .set(String.format("%sMUTATION_COUNT", getNamespace(connection.getDialect())))
                    .to(stats == null ? null : stats.getMutationCount())
                    .build()));
    return StatementResultImpl.of(resultSet, SHOW_COMMIT_RESPONSE);
  }

  @Override
  public StatementResult statementSetReadOnlyStaleness(TimestampBound staleness) {
    getConnection().setReadOnlyStaleness(staleness);
    return noResult(SET_READ_ONLY_STALENESS);
  }

  @Override
  public StatementResult statementShowReadOnlyStaleness() {
    TimestampBound staleness = getConnection().getReadOnlyStaleness();
    return resultSet(
        String.format("%sREAD_ONLY_STALENESS", getNamespace(connection.getDialect())),
        ReadOnlyStalenessUtil.timestampBoundToString(staleness),
        SHOW_READ_ONLY_STALENESS);
  }

  @Override
  public StatementResult statementSetDirectedRead(DirectedReadOptions directedReadOptions) {
    getConnection().setDirectedRead(directedReadOptions);
    return noResult(SET_DIRECTED_READ);
  }

  @Override
  public StatementResult statementShowDirectedRead() {
    DirectedReadOptions directedReadOptions = getConnection().getDirectedRead();
    return resultSet(
        String.format("%sDIRECTED_READ", getNamespace(connection.getDialect())),
        DirectedReadOptionsUtil.toString(directedReadOptions),
        SHOW_DIRECTED_READ);
  }

  @Override
  public StatementResult statementSetOptimizerVersion(String optimizerVersion) {
    getConnection().setOptimizerVersion(optimizerVersion);
    return noResult(SET_OPTIMIZER_VERSION);
  }

  @Override
  public StatementResult statementShowOptimizerVersion() {
    return resultSet(
        String.format("%sOPTIMIZER_VERSION", getNamespace(connection.getDialect())),
        getConnection().getOptimizerVersion(),
        SHOW_OPTIMIZER_VERSION);
  }

  @Override
  public StatementResult statementSetOptimizerStatisticsPackage(String optimizerStatisticsPackage) {
    getConnection().setOptimizerStatisticsPackage(optimizerStatisticsPackage);
    return noResult(SET_OPTIMIZER_STATISTICS_PACKAGE);
  }

  @Override
  public StatementResult statementShowOptimizerStatisticsPackage() {
    return resultSet(
        String.format("%sOPTIMIZER_STATISTICS_PACKAGE", getNamespace(connection.getDialect())),
        getConnection().getOptimizerStatisticsPackage(),
        SHOW_OPTIMIZER_STATISTICS_PACKAGE);
  }

  @Override
  public StatementResult statementSetReturnCommitStats(Boolean returnCommitStats) {
    getConnection().setReturnCommitStats(returnCommitStats);
    return noResult(SET_RETURN_COMMIT_STATS);
  }

  @Override
  public StatementResult statementShowReturnCommitStats() {
    return resultSet(
        String.format("%sRETURN_COMMIT_STATS", getNamespace(connection.getDialect())),
        getConnection().isReturnCommitStats(),
        SHOW_RETURN_COMMIT_STATS);
  }

  @Override
  public StatementResult statementSetMaxCommitDelay(Duration duration) {
    getConnection().setMaxCommitDelay(duration);
    return noResult(SET_MAX_COMMIT_DELAY);
  }

  @Override
  public StatementResult statementShowMaxCommitDelay() {
    return resultSet(
        "MAX_COMMIT_DELAY",
        getConnection().getMaxCommitDelay() == null
            ? null
            : getConnection().getMaxCommitDelay().toMillis() + "ms",
        SHOW_MAX_COMMIT_DELAY);
  }

  @Override
  public StatementResult statementSetDelayTransactionStartUntilFirstWrite(
      Boolean delayTransactionStartUntilFirstWrite) {
    getConnection().setDelayTransactionStartUntilFirstWrite(delayTransactionStartUntilFirstWrite);
    return noResult(SET_DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE);
  }

  @Override
  public StatementResult statementShowDelayTransactionStartUntilFirstWrite() {
    return resultSet(
        String.format(
            "%sDELAY_TRANSACTION_START_UNTIL_FIRST_WRITE", getNamespace(connection.getDialect())),
        getConnection().isDelayTransactionStartUntilFirstWrite(),
        SHOW_DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE);
  }

  @Override
  public StatementResult statementSetKeepTransactionAlive(Boolean keepTransactionAlive) {
    getConnection().setKeepTransactionAlive(keepTransactionAlive);
    return noResult(SET_KEEP_TRANSACTION_ALIVE);
  }

  @Override
  public StatementResult statementShowKeepTransactionAlive() {
    return resultSet(
        String.format("%sKEEP_TRANSACTION_ALIVE", getNamespace(connection.getDialect())),
        getConnection().isKeepTransactionAlive(),
        SHOW_KEEP_TRANSACTION_ALIVE);
  }

  @Override
  public StatementResult statementSetStatementTag(String tag) {
    getConnection().setStatementTag("".equals(tag) ? null : tag);
    return noResult(SET_STATEMENT_TAG);
  }

  @Override
  public StatementResult statementShowStatementTag() {
    return resultSet(
        String.format("%sSTATEMENT_TAG", getNamespace(connection.getDialect())),
        MoreObjects.firstNonNull(getConnection().getStatementTag(), ""),
        SHOW_STATEMENT_TAG);
  }

  @Override
  public StatementResult statementSetTransactionTag(String tag) {
    getConnection().setTransactionTag("".equals(tag) ? null : tag);
    return noResult(SET_TRANSACTION_TAG);
  }

  @Override
  public StatementResult statementShowTransactionTag() {
    return resultSet(
        String.format("%sTRANSACTION_TAG", getNamespace(connection.getDialect())),
        MoreObjects.firstNonNull(getConnection().getTransactionTag(), ""),
        SHOW_TRANSACTION_TAG);
  }

  @Override
  public StatementResult statementSetExcludeTxnFromChangeStreams(
      Boolean excludeTxnFromChangeStreams) {
    getConnection().setExcludeTxnFromChangeStreams(excludeTxnFromChangeStreams);
    return noResult(SET_EXCLUDE_TXN_FROM_CHANGE_STREAMS);
  }

  @Override
  public StatementResult statementShowExcludeTxnFromChangeStreams() {
    return resultSet(
        String.format("%sEXCLUDE_TXN_FROM_CHANGE_STREAMS", getNamespace(connection.getDialect())),
        getConnection().isExcludeTxnFromChangeStreams(),
        SHOW_EXCLUDE_TXN_FROM_CHANGE_STREAMS);
  }

  @Override
  public StatementResult statementBeginTransaction(
      TransactionOptions.IsolationLevel isolationLevel) {
    if (isolationLevel != null) {
      getConnection().beginTransaction(isolationLevel);
    } else {
      getConnection().beginTransaction();
    }
    return noResult(BEGIN);
  }

  @Override
  public StatementResult statementBeginPgTransaction(@Nullable PgTransactionMode transactionMode) {
    if (transactionMode == null
        || transactionMode.getIsolationLevel() == null
        || transactionMode.getIsolationLevel() == IsolationLevel.ISOLATION_LEVEL_DEFAULT) {
      getConnection().beginTransaction();
    } else {
      getConnection()
          .beginTransaction(transactionMode.getIsolationLevel().getSpannerIsolationLevel());
    }
    if (transactionMode != null) {
      statementSetPgTransactionMode(transactionMode);
    }
    return noResult(BEGIN);
  }

  @Override
  public StatementResult statementCommit() {
    getConnection().commit();
    return noResult(COMMIT);
  }

  @Override
  public StatementResult statementRollback() {
    getConnection().rollback();
    return noResult(ROLLBACK);
  }

  @Override
  public StatementResult statementSetTransactionMode(TransactionMode mode) {
    getConnection().setTransactionMode(mode);
    return noResult(SET_TRANSACTION_MODE);
  }

  @Override
  public StatementResult statementSetPgTransactionMode(PgTransactionMode transactionMode) {
    if (transactionMode.getIsolationLevel() != null) {
      getConnection()
          .setTransactionIsolationLevel(
              transactionMode.getIsolationLevel().getSpannerIsolationLevel());
    }
    if (transactionMode.getAccessMode() != null) {
      switch (transactionMode.getAccessMode()) {
        case READ_ONLY_TRANSACTION:
          getConnection().setTransactionMode(TransactionMode.READ_ONLY_TRANSACTION);
          break;
        case READ_WRITE_TRANSACTION:
          getConnection().setTransactionMode(TransactionMode.READ_WRITE_TRANSACTION);
          break;
        default:
          // no-op
      }
    }
    return noResult(SET_TRANSACTION_MODE);
  }

  @Override
  public StatementResult statementSetPgSessionCharacteristicsTransactionMode(
      PgTransactionMode transactionMode) {
    if (transactionMode.getIsolationLevel() != null) {
      getConnection()
          .setDefaultIsolationLevel(transactionMode.getIsolationLevel().getSpannerIsolationLevel());
    }
    if (transactionMode.getAccessMode() != null) {
      switch (transactionMode.getAccessMode()) {
        case READ_ONLY_TRANSACTION:
          getConnection().setReadOnly(true);
          break;
        case READ_WRITE_TRANSACTION:
          getConnection().setReadOnly(false);
          break;
        default:
          // no-op
      }
    }
    return noResult(SET_TRANSACTION_MODE);
  }

  @Override
  public StatementResult statementSetPgDefaultTransactionIsolation(IsolationLevel isolationLevel) {
    getConnection()
        .setDefaultIsolationLevel(
            isolationLevel == null
                ? TransactionOptions.IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED
                : isolationLevel.getSpannerIsolationLevel());
    return noResult(SET_DEFAULT_TRANSACTION_ISOLATION);
  }

  @Override
  public StatementResult statementStartBatchDdl() {
    getConnection().startBatchDdl();
    return noResult(START_BATCH_DDL);
  }

  @Override
  public StatementResult statementStartBatchDml() {
    getConnection().startBatchDml();
    return noResult(START_BATCH_DML);
  }

  @Override
  public StatementResult statementRunBatch() {
    long[] updateCounts = getConnection().runBatch();
    return resultSet("UPDATE_COUNTS", updateCounts, RUN_BATCH);
  }

  @Override
  public StatementResult statementAbortBatch() {
    getConnection().abortBatch();
    return noResult(ABORT_BATCH);
  }

  @Override
  public StatementResult statementResetAll() {
    getConnection().reset();
    return noResult(RESET_ALL);
  }

  @Override
  public StatementResult statementSetRPCPriority(RpcPriority priority) {
    getConnection().setRPCPriority(priority);
    return noResult(SET_RPC_PRIORITY);
  }

  @Override
  public StatementResult statementShowRPCPriority() {
    return resultSet(
        String.format("%sRPC_PRIORITY", getNamespace(connection.getDialect())),
        getConnection().getRPCPriority() == null
            ? RequestOptions.Priority.PRIORITY_UNSPECIFIED
            : getConnection().getRPCPriority(),
        SHOW_RPC_PRIORITY);
  }

  @Override
  public StatementResult statementSetSavepointSupport(SavepointSupport savepointSupport) {
    getConnection().setSavepointSupport(savepointSupport);
    return noResult(SET_SAVEPOINT_SUPPORT);
  }

  @Override
  public StatementResult statementShowSavepointSupport() {
    return resultSet(
        String.format("%SAVEPOINT_SUPPORT", getNamespace(connection.getDialect())),
        getConnection().getSavepointSupport(),
        SHOW_SAVEPOINT_SUPPORT);
  }

  @Override
  public StatementResult statementSetReadLockMode(ReadLockMode readLockMode) {
    getConnection().setReadLockMode(readLockMode);
    return noResult(SET_READ_LOCK_MODE);
  }

  @Override
  public StatementResult statementShowReadLockMode() {
    return resultSet(
        String.format("%sREAD_LOCK_MODE", getNamespace(connection.getDialect())),
        getConnection().getReadLockMode(),
        SHOW_READ_LOCK_MODE);
  }

  @Override
  public StatementResult statementShowTransactionIsolationLevel() {
    TransactionOptions.IsolationLevel isolationLevel =
        getConnection().isInTransaction()
            ? getConnection().getTransactionIsolationLevel()
            : getConnection().getDefaultIsolationLevel();
    return resultSet("transaction_isolation", isolationLevel, SHOW_TRANSACTION_ISOLATION_LEVEL);
  }

  @Override
  public StatementResult statementShowDefaultTransactionIsolation() {
    return resultSet(
        "default_transaction_isolation",
        getConnection().getDefaultIsolationLevel(),
        SHOW_DEFAULT_TRANSACTION_ISOLATION);
  }

  @Override
  public StatementResult statementShowDataBoostEnabled() {
    return resultSet(
        String.format("%sDATA_BOOST_ENABLED", getNamespace(connection.getDialect())),
        getConnection().isDataBoostEnabled(),
        SHOW_DATA_BOOST_ENABLED);
  }

  @Override
  public StatementResult statementSetDataBoostEnabled(Boolean dataBoostEnabled) {
    getConnection().setDataBoostEnabled(Preconditions.checkNotNull(dataBoostEnabled));
    return noResult(SET_DATA_BOOST_ENABLED);
  }

  @Override
  public StatementResult statementShowAutoPartitionMode() {
    return resultSet(
        String.format("%sAUTO_PARTITION_MODE", getNamespace(connection.getDialect())),
        getConnection().isAutoPartitionMode(),
        SHOW_AUTO_PARTITION_MODE);
  }

  @Override
  public StatementResult statementSetAutoPartitionMode(Boolean autoPartitionMode) {
    getConnection().setAutoPartitionMode(Preconditions.checkNotNull(autoPartitionMode));
    return noResult(SET_AUTO_PARTITION_MODE);
  }

  @Override
  public StatementResult statementShowMaxPartitions() {
    return resultSet(
        String.format("%sMAX_PARTITIONS", getNamespace(connection.getDialect())),
        Long.valueOf(getConnection().getMaxPartitions()),
        SHOW_MAX_PARTITIONS);
  }

  @Override
  public StatementResult statementSetMaxPartitions(Integer maxPartitions) {
    getConnection().setMaxPartitions(Preconditions.checkNotNull(maxPartitions));
    return noResult(SET_MAX_PARTITIONS);
  }

  @Override
  public StatementResult statementShowMaxPartitionedParallelism() {
    return resultSet(
        String.format("%sMAX_PARTITIONED_PARALLELISM", getNamespace(connection.getDialect())),
        Long.valueOf(getConnection().getMaxPartitionedParallelism()),
        SHOW_MAX_PARTITIONED_PARALLELISM);
  }

  @Override
  public StatementResult statementSetMaxPartitionedParallelism(Integer maxPartitionedParallelism) {
    getConnection()
        .setMaxPartitionedParallelism(Preconditions.checkNotNull(maxPartitionedParallelism));
    return noResult(SET_MAX_PARTITIONED_PARALLELISM);
  }

  @Override
  public StatementResult statementPartition(Statement statement) {
    return StatementResultImpl.of(
        getConnection().partitionQuery(statement, PartitionOptions.getDefaultInstance()),
        ClientSideStatementType.PARTITION);
  }

  @Override
  public StatementResult statementRunPartition(String partitionId) {
    return StatementResultImpl.of(
        getConnection().runPartition(partitionId), ClientSideStatementType.RUN_PARTITION);
  }

  @Override
  public StatementResult statementRunPartitionedQuery(Statement statement) {
    return StatementResultImpl.of(
        getConnection().runPartitionedQuery(statement, PartitionOptions.getDefaultInstance()),
        ClientSideStatementType.RUN_PARTITIONED_QUERY);
  }

  @Override
  public StatementResult statementSetBatchDmlUpdateCount(Long updateCount, Boolean local) {
    getConnection().setBatchDmlUpdateCount(updateCount, local);
    return noResult(SET_BATCH_DML_UPDATE_COUNT);
  }

  @Override
  public StatementResult statementSetProtoDescriptors(byte[] protoDescriptors) {
    Preconditions.checkNotNull(protoDescriptors);
    getConnection().setProtoDescriptors(protoDescriptors);
    return noResult(SET_PROTO_DESCRIPTORS);
  }

  @Override
  public StatementResult statementSetProtoDescriptorsFilePath(String filePath) {
    Preconditions.checkNotNull(filePath);
    getConnection().setProtoDescriptorsFilePath(filePath);
    return noResult(SET_PROTO_DESCRIPTORS_FILE_PATH);
  }

  @Override
  public StatementResult statementShowProtoDescriptors() {
    return resultSet(
        String.format("%sPROTO_DESCRIPTORS", getNamespace(connection.getDialect())),
        getConnection().getProtoDescriptors(),
        SHOW_PROTO_DESCRIPTORS);
  }

  @Override
  public StatementResult statementShowProtoDescriptorsFilePath() {
    return resultSet(
        String.format("%sPROTO_DESCRIPTORS_FILE_PATH", getNamespace(connection.getDialect())),
        getConnection().getProtoDescriptorsFilePath(),
        SHOW_PROTO_DESCRIPTORS_FILE_PATH);
  }

  @Override
  public StatementResult statementSetAutoBatchDml(Boolean autoBatchDml) {
    getConnection().setAutoBatchDml(autoBatchDml);
    return noResult(SET_AUTO_BATCH_DML);
  }

  @Override
  public StatementResult statementShowAutoBatchDml() {
    return resultSet(
        String.format("%sAUTO_BATCH_DML", getNamespace(connection.getDialect())),
        getConnection().isAutoBatchDml(),
        SHOW_AUTO_BATCH_DML);
  }

  @Override
  public StatementResult statementSetAutoBatchDmlUpdateCount(Long updateCount) {
    getConnection().setAutoBatchDmlUpdateCount(updateCount);
    return noResult(SET_AUTO_BATCH_DML_UPDATE_COUNT);
  }

  @Override
  public StatementResult statementShowAutoBatchDmlUpdateCount() {
    return resultSet(
        String.format("%sAUTO_BATCH_DML_UPDATE_COUNT", getNamespace(connection.getDialect())),
        getConnection().getAutoBatchDmlUpdateCount(),
        SHOW_AUTO_BATCH_DML_UPDATE_COUNT);
  }

  @Override
  public StatementResult statementSetAutoBatchDmlUpdateCountVerification(Boolean verification) {
    getConnection().setAutoBatchDmlUpdateCountVerification(verification);
    return noResult(SET_AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION);
  }

  @Override
  public StatementResult statementShowAutoBatchDmlUpdateCountVerification() {
    return resultSet(
        String.format(
            "%sAUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION", getNamespace(connection.getDialect())),
        getConnection().isAutoBatchDmlUpdateCountVerification(),
        SHOW_AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION);
  }

  private String processQueryPlan(PlanNode planNode) {
    StringBuilder planNodeDescription = new StringBuilder(" : { ");
    com.google.protobuf.Struct metadata = planNode.getMetadata();

    for (String key : metadata.getFieldsMap().keySet()) {
      planNodeDescription
          .append(key)
          .append(" : ")
          .append(metadata.getFieldsMap().get(key).getStringValue())
          .append(" , ");
    }
    String substring = planNodeDescription.substring(0, planNodeDescription.length() - 3);
    planNodeDescription.setLength(0);
    planNodeDescription.append(substring).append(" }");

    return planNodeDescription.toString();
  }

  private String processExecutionStats(PlanNode planNode) {
    StringBuilder executionStats = new StringBuilder("");
    for (String key : planNode.getExecutionStats().getFieldsMap().keySet()) {
      executionStats.append(key).append(" : { ");
      com.google.protobuf.Struct value =
          planNode.getExecutionStats().getFieldsMap().get(key).getStructValue();
      for (String newKey : value.getFieldsMap().keySet()) {
        String newValue = value.getFieldsMap().get(newKey).getStringValue();
        executionStats.append(newKey).append(" : ").append(newValue).append(" , ");
      }
      String substring = executionStats.substring(0, executionStats.length() - 3);
      executionStats.setLength(0);
      executionStats.append(substring).append(" } , ");
    }
    String substring = executionStats.substring(0, executionStats.length() - 3);
    executionStats.setLength(0);
    executionStats.append(substring);
    return executionStats.toString();
  }

  private StatementResult getStatementResultFromQueryPlan(QueryPlan queryPlan, boolean isAnalyze) {
    ArrayList<Struct> list = new ArrayList<>();
    for (PlanNode planNode : queryPlan.getPlanNodesList()) {
      String planNodeDescription = planNode.getDisplayName();
      String executionStats = "";

      if (!planNode.getMetadata().toString().equalsIgnoreCase("")) {
        planNodeDescription += processQueryPlan(planNode);
      }

      if (!planNode.getShortRepresentation().toString().equalsIgnoreCase("")) {
        planNodeDescription += " : " + planNode.getShortRepresentation().getDescription();
      }

      if (isAnalyze && !planNode.getExecutionStats().toString().equals("")) {
        executionStats = processExecutionStats(planNode);
      }
      Struct.Builder builder = Struct.newBuilder().set("QUERY PLAN").to(planNodeDescription);

      if (isAnalyze) {
        builder.set("EXECUTION STATS").to(executionStats);
      }
      list.add(builder.build());
    }

    ResultSet resultSet;
    if (isAnalyze) {
      resultSet =
          ResultSets.forRows(
              Type.struct(
                  StructField.of("QUERY PLAN", Type.string()),
                  StructField.of("EXECUTION STATS", Type.string())),
              list);
    } else {
      resultSet =
          ResultSets.forRows(Type.struct(StructField.of("QUERY PLAN", Type.string())), list);
    }
    return StatementResultImpl.of(resultSet);
  }

  private StatementResult executeStatement(String sql, QueryAnalyzeMode queryAnalyzeMode) {
    Statement statement = Statement.newBuilder(sql).build();
    try (ResultSet resultSet = getConnection().analyzeQuery(statement, queryAnalyzeMode)) {
      while (resultSet.next()) {
        // ResultSet.next() should return false in order to access the ResultSet.Stats
      }

      if (resultSet.getStats() != null && resultSet.getStats().getQueryPlan() != null) {
        return getStatementResultFromQueryPlan(
            resultSet.getStats().getQueryPlan(), queryAnalyzeMode.equals(QueryAnalyzeMode.PROFILE));
      }
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, String.format("Couldn't fetch stats for %s", sql));
  }

  // This method removes parenthesis from the sql string assuming it is ending with the closing
  // parenthesis
  private String removeParenthesisAndTrim(String sql) {
    sql = sql.trim();
    if (sql.charAt(0) == '(') {
      sql = sql.substring(1, sql.length() - 1);
    }
    return sql.trim();
  }

  /*
   * This method executes the given SQL string in either PLAN or PROFILE mode and returns
   * the query plan and execution stats (if necessary).
   *
   * The only additional option that is supported is ANALYZE. The method will throw a SpannerException
   * if it is invoked with a statement that includes any other options.
   *
   * If the SQL string has ANALYZE option, it will be executed in PROFILE mode and will return a resultset
   * with two String columns namely QUERY PLAN and EXECUTION STATS.
   *
   * If the sql string doesn't have any option, it will be executed in PLAN mode and will return a resultset
   * with one string column namely QUERY PLAN.
   */
  @Override
  public StatementResult statementExplain(String sql) {
    if (sql == null) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT, String.format("Invalid String with Explain"));
    }

    if (sql.charAt(0) == '(') {
      int index = sql.indexOf(')');
      if (index == -1) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT,
            String.format("Missing closing parenthesis in the query: %s", sql));
      }
      String options[] = sql.substring(1, index).split("\\s*,\\s*");
      boolean isAnalyze = false, startAfterIndex = false;
      for (String option : options) {
        String optionExpression[] = option.trim().split("\\s+");
        if (optionExpression.length >= 3) {
          isAnalyze = false;
          break;
        } else if (ClientSideStatementExplainExecutor.EXPLAIN_OPTIONS.contains(
            optionExpression[0].toLowerCase())) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.UNIMPLEMENTED,
              String.format("%s is not implemented yet", optionExpression[0]));
        } else if (optionExpression[0].equalsIgnoreCase("analyse")
            || optionExpression[0].equalsIgnoreCase("analyze")) {
          isAnalyze = true;
        } else {
          isAnalyze = false;
          break;
        }

        if (optionExpression.length == 2) {
          if (optionExpression[1].equalsIgnoreCase("false")
              || optionExpression[1].equalsIgnoreCase("0")
              || optionExpression[1].equalsIgnoreCase("off")) {
            isAnalyze = false;
            startAfterIndex = true;
          } else if (!(optionExpression[1].equalsIgnoreCase("true")
              || optionExpression[1].equalsIgnoreCase("1")
              || optionExpression[1].equalsIgnoreCase("on"))) {
            isAnalyze = false;
            break;
          }
        }
      }
      if (isAnalyze) {
        String newSql = removeParenthesisAndTrim(sql.substring(index + 1));
        return executeStatement(newSql, QueryAnalyzeMode.PROFILE);
      } else if (startAfterIndex) {
        String newSql = removeParenthesisAndTrim(sql.substring(index + 1));
        return executeStatement(newSql, QueryAnalyzeMode.PLAN);
      } else {
        return executeStatement(removeParenthesisAndTrim(sql), QueryAnalyzeMode.PLAN);
      }
    } else {
      String[] arr = sql.split("\\s+", 2);
      if (arr.length >= 2) {
        String option = arr[0].toLowerCase();
        String statementToBeExplained = arr[1];

        if (ClientSideStatementExplainExecutor.EXPLAIN_OPTIONS.contains(option)) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.UNIMPLEMENTED, String.format("%s is not implemented yet", option));
        } else if (option.equals("analyze") || option.equals("analyse")) {
          return executeStatement(
              removeParenthesisAndTrim(statementToBeExplained), QueryAnalyzeMode.PROFILE);
        }
      }
      return executeStatement(sql, QueryAnalyzeMode.PLAN);
    }
  }
}
