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
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TimestampBound.Mode;
import com.google.cloud.spanner.jdbc.StatementExecutor.StatementTimeout;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.cloud.spanner.jdbc.StatementParser.StatementType;
import com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.threeten.bp.Instant;

/** Implementation for {@link Connection}, the generic Spanner connection API (not JDBC). */
class ConnectionImpl implements Connection {
  private static final String CLOSED_ERROR_MSG = "This connection is closed";
  private static final String ONLY_ALLOWED_IN_AUTOCOMMIT =
      "This method may only be called while in autocommit mode";
  private static final String NOT_ALLOWED_IN_AUTOCOMMIT =
      "This method may not be called while in autocommit mode";

  /**
   * Exception that is used to register the stacktrace of the code that opened a {@link Connection}.
   * This exception is logged if the application closes without first closing the connection.
   */
  static class LeakedConnectionException extends RuntimeException {
    private static final long serialVersionUID = 7119433786832158700L;

    private LeakedConnectionException() {
      super("Connection was opened at " + Instant.now());
    }
  }

  private volatile LeakedConnectionException leakedException = new LeakedConnectionException();
  private final SpannerPool spannerPool;
  private final StatementParser parser = StatementParser.INSTANCE;
  /**
   * The {@link ConnectionStatementExecutor} is responsible for translating parsed {@link
   * ClientSideStatement}s into actual method calls on this {@link ConnectionImpl}. I.e. the {@link
   * ClientSideStatement} 'SET AUTOCOMMIT ON' will be translated into the method call {@link
   * ConnectionImpl#setAutocommit(boolean)} with value <code>true</code>.
   */
  private final ConnectionStatementExecutor connectionStatementExecutor =
      new ConnectionStatementExecutorImpl(this);

  /** Simple thread factory that is used for fire-and-forget rollbacks. */
  static final class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
      Thread t = new Thread(r);
      t.setName("connection-rollback-executor");
      t.setDaemon(true);
      return t;
    }
  }

  /**
   * Statements are executed using a separate thread in order to be able to cancel these. Statements
   * are automatically cancelled if the configured {@link ConnectionImpl#statementTimeout} is
   * exceeded. In autocommit mode, the connection will try to rollback the effects of an update
   * statement, but this is not guaranteed to actually succeed.
   */
  private final StatementExecutor statementExecutor;

  /**
   * The {@link ConnectionOptions} that were used to create this {@link ConnectionImpl}. This is
   * retained as it is used for getting a {@link Spanner} object and removing this connection from
   * the {@link SpannerPool}.
   */
  private final ConnectionOptions options;

  /** The supported batch modes. */
  enum BatchMode {
    NONE,
    DDL,
    DML;
  }

  /**
   * This query option is used internally to indicate that a query is executed by the library itself
   * to fetch metadata. These queries are specifically allowed to be executed even when a DDL batch
   * is active.
   */
  static final class InternalMetadataQuery implements QueryOption {
    static final InternalMetadataQuery INSTANCE = new InternalMetadataQuery();

    private InternalMetadataQuery() {}
  }

  /** The combination of all transaction modes and batch modes. */
  enum UnitOfWorkType {
    READ_ONLY_TRANSACTION {
      @Override
      TransactionMode getTransactionMode() {
        return TransactionMode.READ_ONLY_TRANSACTION;
      }
    },
    READ_WRITE_TRANSACTION {
      @Override
      TransactionMode getTransactionMode() {
        return TransactionMode.READ_WRITE_TRANSACTION;
      }
    },
    DML_BATCH {
      @Override
      TransactionMode getTransactionMode() {
        return TransactionMode.READ_WRITE_TRANSACTION;
      }
    },
    DDL_BATCH {
      @Override
      TransactionMode getTransactionMode() {
        return null;
      }
    };

    abstract TransactionMode getTransactionMode();

    static UnitOfWorkType of(TransactionMode transactionMode) {
      switch (transactionMode) {
        case READ_ONLY_TRANSACTION:
          return UnitOfWorkType.READ_ONLY_TRANSACTION;
        case READ_WRITE_TRANSACTION:
          return UnitOfWorkType.READ_WRITE_TRANSACTION;
        default:
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT, "Unknown transaction mode: " + transactionMode);
      }
    }
  }

  private StatementExecutor.StatementTimeout statementTimeout =
      new StatementExecutor.StatementTimeout();
  private boolean closed = false;

  private final Spanner spanner;
  private DdlClient ddlClient;
  private DatabaseClient dbClient;
  private boolean autocommit;
  private boolean readOnly;

  private UnitOfWork currentUnitOfWork = null;
  /**
   * The {@link ConnectionImpl#inTransaction} field is only used in autocommit mode to indicate that
   * the user has explicitly started a transaction.
   */
  private boolean inTransaction = false;
  /**
   * This field is used to indicate that a transaction begin has been indicated. This is done by
   * calling beginTransaction or by setting a transaction property while not in autocommit mode.
   */
  private boolean transactionBeginMarked = false;

  private BatchMode batchMode;
  private UnitOfWorkType unitOfWorkType;
  private final Stack<UnitOfWork> transactionStack = new Stack<>();
  private boolean retryAbortsInternally;
  private final List<TransactionRetryListener> transactionRetryListeners = new ArrayList<>();
  private AutocommitDmlMode autocommitDmlMode = AutocommitDmlMode.TRANSACTIONAL;
  private TimestampBound readOnlyStaleness = TimestampBound.strong();

  /** Create a connection and register it in the SpannerPool. */
  ConnectionImpl(ConnectionOptions options) {
    Preconditions.checkNotNull(options);
    this.statementExecutor = new StatementExecutor(options.getStatementExecutionInterceptors());
    this.spannerPool = SpannerPool.INSTANCE;
    this.options = options;
    this.spanner = spannerPool.getSpanner(options, this);
    this.dbClient = spanner.getDatabaseClient(options.getDatabaseId());
    this.retryAbortsInternally = options.isRetryAbortsInternally();
    this.readOnly = options.isReadOnly();
    this.autocommit = options.isAutocommit();
    this.ddlClient = createDdlClient();
    setDefaultTransactionOptions();
  }

  /** Constructor only for test purposes. */
  @VisibleForTesting
  ConnectionImpl(
      ConnectionOptions options,
      SpannerPool spannerPool,
      DdlClient ddlClient,
      DatabaseClient dbClient) {
    Preconditions.checkNotNull(options);
    Preconditions.checkNotNull(spannerPool);
    Preconditions.checkNotNull(ddlClient);
    Preconditions.checkNotNull(dbClient);
    this.statementExecutor =
        new StatementExecutor(Collections.<StatementExecutionInterceptor>emptyList());
    this.spannerPool = spannerPool;
    this.options = options;
    this.spanner = spannerPool.getSpanner(options, this);
    this.ddlClient = ddlClient;
    this.dbClient = dbClient;
    setReadOnly(options.isReadOnly());
    setAutocommit(options.isAutocommit());
    setDefaultTransactionOptions();
  }

  private DdlClient createDdlClient() {
    return DdlClient.newBuilder()
        .setDatabaseAdminClient(spanner.getDatabaseAdminClient())
        .setInstanceId(options.getInstanceId())
        .setDatabaseName(options.getDatabaseName())
        .build();
  }

  @Override
  public void close() {
    if (!isClosed()) {
      try {
        if (isTransactionStarted()) {
          try {
            rollback();
          } catch (Exception e) {
            // Ignore as we are closing the connection.
          }
        }
        statementExecutor.shutdownNow();
        spannerPool.removeConnection(options, this);
        leakedException = null;
      } finally {
        this.closed = true;
      }
    }
  }

  /** Get the current unit-of-work type of this connection. */
  UnitOfWorkType getUnitOfWorkType() {
    return unitOfWorkType;
  }

  /** Get the current batch mode of this connection. */
  BatchMode getBatchMode() {
    return batchMode;
  }

  /** @return <code>true</code> if this connection is in a batch. */
  boolean isInBatch() {
    return batchMode != BatchMode.NONE;
  }

  /** Get the call stack from when the {@link Connection} was opened. */
  LeakedConnectionException getLeakedException() {
    return leakedException;
  }

  @Override
  public boolean isClosed() {
    return closed;
  }

  @Override
  public void setAutocommit(boolean autocommit) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(!isBatchActive(), "Cannot set autocommit while in a batch");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(), "Cannot set autocommit while a transaction is active");
    ConnectionPreconditions.checkState(
        !(isAutocommit() && isInTransaction()),
        "Cannot set autocommit while in a temporary transaction");
    ConnectionPreconditions.checkState(
        !transactionBeginMarked, "Cannot set autocommit when a transaction has begun");
    this.autocommit = autocommit;
    clearLastTransactionAndSetDefaultTransactionOptions();
    // Reset the readOnlyStaleness value if it is no longer compatible with the new autocommit
    // value.
    if (!autocommit
        && (readOnlyStaleness.getMode() == Mode.MAX_STALENESS
            || readOnlyStaleness.getMode() == Mode.MIN_READ_TIMESTAMP)) {
      readOnlyStaleness = TimestampBound.strong();
    }
  }

  @Override
  public boolean isAutocommit() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return internalIsAutocommit();
  }

  private boolean internalIsAutocommit() {
    return this.autocommit;
  }

  @Override
  public void setReadOnly(boolean readOnly) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(!isBatchActive(), "Cannot set read-only while in a batch");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(), "Cannot set read-only while a transaction is active");
    ConnectionPreconditions.checkState(
        !(isAutocommit() && isInTransaction()),
        "Cannot set read-only while in a temporary transaction");
    ConnectionPreconditions.checkState(
        !transactionBeginMarked, "Cannot set read-only when a transaction has begun");
    this.readOnly = readOnly;
    clearLastTransactionAndSetDefaultTransactionOptions();
  }

  @Override
  public boolean isReadOnly() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return this.readOnly;
  }

  private void clearLastTransactionAndSetDefaultTransactionOptions() {
    setDefaultTransactionOptions();
    this.currentUnitOfWork = null;
  }

  @Override
  public void setAutocommitDmlMode(AutocommitDmlMode mode) {
    Preconditions.checkNotNull(mode);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Cannot set autocommit DML mode while in a batch");
    ConnectionPreconditions.checkState(
        !isInTransaction() && isAutocommit(),
        "Cannot set autocommit DML mode while not in autocommit mode or while a transaction is active");
    ConnectionPreconditions.checkState(
        !isReadOnly(), "Cannot set autocommit DML mode for a read-only connection");
    this.autocommitDmlMode = mode;
  }

  @Override
  public AutocommitDmlMode getAutocommitDmlMode() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Cannot get autocommit DML mode while in a batch");
    return this.autocommitDmlMode;
  }

  @Override
  public void setReadOnlyStaleness(TimestampBound staleness) {
    Preconditions.checkNotNull(staleness);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(!isBatchActive(), "Cannot set read-only while in a batch");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(),
        "Cannot set read-only staleness when a transaction has been started");
    if (staleness.getMode() == Mode.MAX_STALENESS
        || staleness.getMode() == Mode.MIN_READ_TIMESTAMP) {
      // These values are only allowed in autocommit mode.
      ConnectionPreconditions.checkState(
          isAutocommit() && !inTransaction,
          "MAX_STALENESS and MIN_READ_TIMESTAMP are only allowed in autocommit mode");
    }
    this.readOnlyStaleness = staleness;
  }

  @Override
  public TimestampBound getReadOnlyStaleness() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(!isBatchActive(), "Cannot get read-only while in a batch");
    return this.readOnlyStaleness;
  }

  @Override
  public void setStatementTimeout(long timeout, TimeUnit unit) {
    Preconditions.checkArgument(timeout > 0L, "Zero or negative timeout values are not allowed");
    Preconditions.checkArgument(
        StatementTimeout.isValidTimeoutUnit(unit),
        "Time unit must be one of NANOSECONDS, MICROSECONDS, MILLISECONDS or SECONDS");
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    this.statementTimeout.setTimeoutValue(timeout, unit);
  }

  @Override
  public void clearStatementTimeout() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    this.statementTimeout.clearTimeoutValue();
  }

  @Override
  public long getStatementTimeout(TimeUnit unit) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    Preconditions.checkArgument(
        StatementTimeout.isValidTimeoutUnit(unit),
        "Time unit must be one of NANOSECONDS, MICROSECONDS, MILLISECONDS or SECONDS");
    return this.statementTimeout.getTimeoutValue(unit);
  }

  @Override
  public boolean hasStatementTimeout() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return this.statementTimeout.hasTimeout();
  }

  @Override
  public void cancel() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    if (this.currentUnitOfWork != null) {
      currentUnitOfWork.cancel();
    }
  }

  @Override
  public TransactionMode getTransactionMode() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(!isDdlBatchActive(), "This connection is in a DDL batch");
    ConnectionPreconditions.checkState(isInTransaction(), "This connection has no transaction");
    return unitOfWorkType.getTransactionMode();
  }

  @Override
  public void setTransactionMode(TransactionMode transactionMode) {
    Preconditions.checkNotNull(transactionMode);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Cannot set transaction mode while in a batch");
    ConnectionPreconditions.checkState(isInTransaction(), "This connection has no transaction");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(),
        "The transaction mode cannot be set after the transaction has started");
    ConnectionPreconditions.checkState(
        !isReadOnly() || transactionMode == TransactionMode.READ_ONLY_TRANSACTION,
        "The transaction mode can only be READ_ONLY when the connection is in read_only mode");

    this.transactionBeginMarked = true;
    this.unitOfWorkType = UnitOfWorkType.of(transactionMode);
  }

  /**
   * Throws an {@link SpannerException} with code {@link ErrorCode#FAILED_PRECONDITION} if the
   * current state of this connection does not allow changing the setting for retryAbortsInternally.
   */
  private void checkSetRetryAbortsInternallyAvailable() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(isInTransaction(), "This connection has no transaction");
    ConnectionPreconditions.checkState(
        getTransactionMode() == TransactionMode.READ_WRITE_TRANSACTION,
        "RetryAbortsInternally is only available for read-write transactions");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(),
        "RetryAbortsInternally cannot be set after the transaction has started");
  }

  @Override
  public boolean isRetryAbortsInternally() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return retryAbortsInternally;
  }

  @Override
  public void setRetryAbortsInternally(boolean retryAbortsInternally) {
    checkSetRetryAbortsInternallyAvailable();
    this.retryAbortsInternally = retryAbortsInternally;
  }

  @Override
  public void addTransactionRetryListener(TransactionRetryListener listener) {
    Preconditions.checkNotNull(listener);
    transactionRetryListeners.add(listener);
  }

  @Override
  public boolean removeTransactionRetryListener(TransactionRetryListener listener) {
    Preconditions.checkNotNull(listener);
    return transactionRetryListeners.remove(listener);
  }

  @Override
  public Iterator<TransactionRetryListener> getTransactionRetryListeners() {
    return Collections.unmodifiableList(transactionRetryListeners).iterator();
  }

  @Override
  public boolean isInTransaction() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return internalIsInTransaction();
  }

  /** Returns true if this connection currently is in a transaction (and not a batch). */
  private boolean internalIsInTransaction() {
    return !isDdlBatchActive() && (!internalIsAutocommit() || inTransaction);
  }

  @Override
  public boolean isTransactionStarted() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return internalIsTransactionStarted();
  }

  private boolean internalIsTransactionStarted() {
    if (internalIsAutocommit() && !inTransaction) {
      return false;
    }
    return internalIsInTransaction()
        && this.currentUnitOfWork != null
        && this.currentUnitOfWork.getState() == UnitOfWorkState.STARTED;
  }

  @Override
  public Timestamp getReadTimestamp() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        this.currentUnitOfWork != null, "There is no transaction on this connection");
    return this.currentUnitOfWork.getReadTimestamp();
  }

  Timestamp getReadTimestampOrNull() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return this.currentUnitOfWork == null ? null : this.currentUnitOfWork.getReadTimestampOrNull();
  }

  @Override
  public Timestamp getCommitTimestamp() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        this.currentUnitOfWork != null, "There is no transaction on this connection");
    return this.currentUnitOfWork.getCommitTimestamp();
  }

  Timestamp getCommitTimestampOrNull() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return this.currentUnitOfWork == null
        ? null
        : this.currentUnitOfWork.getCommitTimestampOrNull();
  }

  /** Resets this connection to its default transaction options. */
  private void setDefaultTransactionOptions() {
    if (transactionStack.isEmpty()) {
      unitOfWorkType =
          isReadOnly()
              ? UnitOfWorkType.READ_ONLY_TRANSACTION
              : UnitOfWorkType.READ_WRITE_TRANSACTION;
      batchMode = BatchMode.NONE;
    } else {
      popUnitOfWorkFromTransactionStack();
    }
  }

  @Override
  public void beginTransaction() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "This connection has an active batch and cannot begin a transaction");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(),
        "Beginning a new transaction is not allowed when a transaction is already running");
    ConnectionPreconditions.checkState(!transactionBeginMarked, "A transaction has already begun");

    transactionBeginMarked = true;
    clearLastTransactionAndSetDefaultTransactionOptions();
    if (isAutocommit()) {
      inTransaction = true;
    }
  }

  /** Internal interface for ending a transaction (commit/rollback). */
  private static interface EndTransactionMethod {
    public void end(UnitOfWork t);
  }

  private static final class Commit implements EndTransactionMethod {
    @Override
    public void end(UnitOfWork t) {
      t.commit();
    }
  }

  private final Commit commit = new Commit();

  @Override
  public void commit() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    endCurrentTransaction(commit);
  }

  private static final class Rollback implements EndTransactionMethod {
    @Override
    public void end(UnitOfWork t) {
      t.rollback();
    }
  }

  private final Rollback rollback = new Rollback();

  @Override
  public void rollback() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    endCurrentTransaction(rollback);
  }

  private void endCurrentTransaction(EndTransactionMethod endTransactionMethod) {
    ConnectionPreconditions.checkState(!isBatchActive(), "This connection has an active batch");
    ConnectionPreconditions.checkState(isInTransaction(), "This connection has no transaction");
    try {
      if (isTransactionStarted()) {
        endTransactionMethod.end(getCurrentUnitOfWorkOrStartNewUnitOfWork());
      } else {
        this.currentUnitOfWork = null;
      }
    } finally {
      transactionBeginMarked = false;
      if (isAutocommit()) {
        inTransaction = false;
      }
      setDefaultTransactionOptions();
    }
  }

  @Override
  public StatementResult execute(Statement statement) {
    Preconditions.checkNotNull(statement);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ParsedStatement parsedStatement = parser.parse(statement);
    switch (parsedStatement.getType()) {
      case CLIENT_SIDE:
        return parsedStatement
            .getClientSideStatement()
            .execute(connectionStatementExecutor, parsedStatement.getSqlWithoutComments());
      case QUERY:
        return StatementResultImpl.of(internalExecuteQuery(parsedStatement, AnalyzeMode.NONE));
      case UPDATE:
        return StatementResultImpl.of(internalExecuteUpdate(parsedStatement));
      case DDL:
        executeDdl(parsedStatement);
        return StatementResultImpl.noResult();
      case UNKNOWN:
      default:
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT,
        "Unknown statement: " + parsedStatement.getSqlWithoutComments());
  }

  @Override
  public ResultSet executeQuery(Statement query, QueryOption... options) {
    return parseAndExecuteQuery(query, AnalyzeMode.NONE, options);
  }

  @Override
  public ResultSet analyzeQuery(Statement query, QueryAnalyzeMode queryMode) {
    Preconditions.checkNotNull(queryMode);
    return parseAndExecuteQuery(query, AnalyzeMode.of(queryMode));
  }

  /**
   * Parses the given statement as a query and executes it. Throws a {@link SpannerException} if the
   * statement is not a query.
   */
  private ResultSet parseAndExecuteQuery(
      Statement query, AnalyzeMode analyzeMode, QueryOption... options) {
    Preconditions.checkNotNull(query);
    Preconditions.checkNotNull(analyzeMode);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ParsedStatement parsedStatement = parser.parse(query);
    if (parsedStatement.isQuery()) {
      switch (parsedStatement.getType()) {
        case CLIENT_SIDE:
          return parsedStatement
              .getClientSideStatement()
              .execute(connectionStatementExecutor, parsedStatement.getSqlWithoutComments())
              .getResultSet();
        case QUERY:
          return internalExecuteQuery(parsedStatement, analyzeMode, options);
        case UPDATE:
        case DDL:
        case UNKNOWN:
        default:
      }
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT,
        "Statement is not a query: " + parsedStatement.getSqlWithoutComments());
  }

  @Override
  public long executeUpdate(Statement update) {
    Preconditions.checkNotNull(update);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ParsedStatement parsedStatement = parser.parse(update);
    if (parsedStatement.isUpdate()) {
      switch (parsedStatement.getType()) {
        case UPDATE:
          return internalExecuteUpdate(parsedStatement);
        case CLIENT_SIDE:
        case QUERY:
        case DDL:
        case UNKNOWN:
        default:
      }
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT,
        "Statement is not an update statement: " + parsedStatement.getSqlWithoutComments());
  }

  @Override
  public long[] executeBatchUpdate(Iterable<Statement> updates) {
    Preconditions.checkNotNull(updates);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    // Check that there are only DML statements in the input.
    List<ParsedStatement> parsedStatements = new LinkedList<>();
    for (Statement update : updates) {
      ParsedStatement parsedStatement = parser.parse(update);
      if (parsedStatement.isUpdate()) {
        switch (parsedStatement.getType()) {
          case UPDATE:
            parsedStatements.add(parsedStatement);
            break;
          case CLIENT_SIDE:
          case QUERY:
          case DDL:
          case UNKNOWN:
          default:
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT,
                "The batch update list contains a statement that is not an update statement: "
                    + parsedStatement.getSqlWithoutComments());
        }
      }
    }
    return internalExecuteBatchUpdate(parsedStatements);
  }

  private ResultSet internalExecuteQuery(
      final ParsedStatement statement,
      final AnalyzeMode analyzeMode,
      final QueryOption... options) {
    Preconditions.checkArgument(
        statement.getType() == StatementType.QUERY, "Statement must be a query");
    UnitOfWork transaction = getCurrentUnitOfWorkOrStartNewUnitOfWork();
    try {
      return transaction.executeQuery(statement, analyzeMode, options);
    } catch (SpannerException e) {
      // In case of a timed out or cancelled query we need to replace the executor to ensure that we
      // have an executor that is not busy executing a statement. Although we try to cancel the
      // current statement, it is not guaranteed to actually stop the execution directly.
      if (e.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED
          || e.getErrorCode() == ErrorCode.CANCELLED) {
        this.statementExecutor.recreate();
      }
      throw e;
    }
  }

  private long internalExecuteUpdate(final ParsedStatement update) {
    Preconditions.checkArgument(
        update.getType() == StatementType.UPDATE, "Statement must be an update");
    UnitOfWork transaction = getCurrentUnitOfWorkOrStartNewUnitOfWork();
    try {
      return transaction.executeUpdate(update);
    } catch (SpannerException e) {
      // In case of a timed out or cancelled query we need to replace the executor to ensure that we
      // have an executor that is not busy executing a statement. Although we try to cancel the
      // current statement, it is not guaranteed to actually stop the execution directly.
      if (e.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED
          || e.getErrorCode() == ErrorCode.CANCELLED) {
        this.statementExecutor.recreate();
      }
      throw e;
    }
  }

  private long[] internalExecuteBatchUpdate(final List<ParsedStatement> updates) {
    UnitOfWork transaction = getCurrentUnitOfWorkOrStartNewUnitOfWork();
    try {
      return transaction.executeBatchUpdate(updates);
    } catch (SpannerException e) {
      // In case of a timed out or cancelled query we need to replace the executor to ensure that we
      // have an executor that is not busy executing a statement. Although we try to cancel the
      // current statement, it is not guaranteed to actually stop the execution directly.
      if (e.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED
          || e.getErrorCode() == ErrorCode.CANCELLED) {
        this.statementExecutor.recreate();
      }
      throw e;
    }
  }

  /**
   * Returns the current {@link UnitOfWork} of this connection, or creates a new one based on the
   * current transaction settings of the connection and returns that.
   */
  private UnitOfWork getCurrentUnitOfWorkOrStartNewUnitOfWork() {
    if (this.currentUnitOfWork == null || !this.currentUnitOfWork.isActive()) {
      this.currentUnitOfWork = createNewUnitOfWork();
    }
    return this.currentUnitOfWork;
  }

  private UnitOfWork createNewUnitOfWork() {
    if (isAutocommit() && !isInTransaction() && !isInBatch()) {
      return SingleUseTransaction.newBuilder()
          .setDdlClient(ddlClient)
          .setDatabaseClient(dbClient)
          .setReadOnly(isReadOnly())
          .setReadOnlyStaleness(readOnlyStaleness)
          .setAutocommitDmlMode(autocommitDmlMode)
          .setStatementTimeout(statementTimeout)
          .withStatementExecutor(statementExecutor)
          .build();
    } else {
      switch (getUnitOfWorkType()) {
        case READ_ONLY_TRANSACTION:
          return ReadOnlyTransaction.newBuilder()
              .setDatabaseClient(dbClient)
              .setReadOnlyStaleness(readOnlyStaleness)
              .setStatementTimeout(statementTimeout)
              .withStatementExecutor(statementExecutor)
              .build();
        case READ_WRITE_TRANSACTION:
          return ReadWriteTransaction.newBuilder()
              .setDatabaseClient(dbClient)
              .setRetryAbortsInternally(retryAbortsInternally)
              .setTransactionRetryListeners(transactionRetryListeners)
              .setStatementTimeout(statementTimeout)
              .withStatementExecutor(statementExecutor)
              .build();
        case DML_BATCH:
          // A DML batch can run inside the current transaction. It should therefore only
          // temporarily replace the current transaction.
          pushCurrentUnitOfWorkToTransactionStack();
          return DmlBatch.newBuilder()
              .setTransaction(currentUnitOfWork)
              .setStatementTimeout(statementTimeout)
              .withStatementExecutor(statementExecutor)
              .build();
        case DDL_BATCH:
          return DdlBatch.newBuilder()
              .setDdlClient(ddlClient)
              .setDatabaseClient(dbClient)
              .setStatementTimeout(statementTimeout)
              .withStatementExecutor(statementExecutor)
              .build();
        default:
      }
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION,
        "This connection does not have an active transaction and the state of this connection does not allow any new transactions to be started");
  }

  /** Pushes the current unit of work to the stack of nested transactions. */
  private void pushCurrentUnitOfWorkToTransactionStack() {
    Preconditions.checkState(currentUnitOfWork != null, "There is no current transaction");
    transactionStack.push(currentUnitOfWork);
  }

  /** Set the {@link UnitOfWork} of this connection back to the previous {@link UnitOfWork}. */
  private void popUnitOfWorkFromTransactionStack() {
    Preconditions.checkState(
        !transactionStack.isEmpty(), "There is no unit of work in the transaction stack");
    this.currentUnitOfWork = transactionStack.pop();
  }

  private void executeDdl(ParsedStatement ddl) {
    getCurrentUnitOfWorkOrStartNewUnitOfWork().executeDdl(ddl);
  }

  @Override
  public void write(Mutation mutation) {
    Preconditions.checkNotNull(mutation);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(isAutocommit(), ONLY_ALLOWED_IN_AUTOCOMMIT);
    getCurrentUnitOfWorkOrStartNewUnitOfWork().write(mutation);
  }

  @Override
  public void write(Iterable<Mutation> mutations) {
    Preconditions.checkNotNull(mutations);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(isAutocommit(), ONLY_ALLOWED_IN_AUTOCOMMIT);
    getCurrentUnitOfWorkOrStartNewUnitOfWork().write(mutations);
  }

  @Override
  public void bufferedWrite(Mutation mutation) {
    Preconditions.checkNotNull(mutation);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(!isAutocommit(), NOT_ALLOWED_IN_AUTOCOMMIT);
    getCurrentUnitOfWorkOrStartNewUnitOfWork().write(mutation);
  }

  @Override
  public void bufferedWrite(Iterable<Mutation> mutations) {
    Preconditions.checkNotNull(mutations);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(!isAutocommit(), NOT_ALLOWED_IN_AUTOCOMMIT);
    getCurrentUnitOfWorkOrStartNewUnitOfWork().write(mutations);
  }

  @Override
  public void startBatchDdl() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Cannot start a DDL batch when a batch is already active");
    ConnectionPreconditions.checkState(
        !isReadOnly(), "Cannot start a DDL batch when the connection is in read-only mode");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(), "Cannot start a DDL batch while a transaction is active");
    ConnectionPreconditions.checkState(
        !(isAutocommit() && isInTransaction()),
        "Cannot start a DDL batch while in a temporary transaction");
    ConnectionPreconditions.checkState(
        !transactionBeginMarked, "Cannot start a DDL batch when a transaction has begun");
    this.batchMode = BatchMode.DDL;
    this.unitOfWorkType = UnitOfWorkType.DDL_BATCH;
    this.currentUnitOfWork = createNewUnitOfWork();
  }

  @Override
  public void startBatchDml() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Cannot start a DML batch when a batch is already active");
    ConnectionPreconditions.checkState(
        !isReadOnly(), "Cannot start a DML batch when the connection is in read-only mode");
    ConnectionPreconditions.checkState(
        !(isInTransaction() && getTransactionMode() == TransactionMode.READ_ONLY_TRANSACTION),
        "Cannot start a DML batch when a read-only transaction is in progress");
    // Make sure that there is a current unit of work that the batch can use.
    getCurrentUnitOfWorkOrStartNewUnitOfWork();
    // Then create the DML batch.
    this.batchMode = BatchMode.DML;
    this.unitOfWorkType = UnitOfWorkType.DML_BATCH;
    this.currentUnitOfWork = createNewUnitOfWork();
  }

  @Override
  public long[] runBatch() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(isBatchActive(), "This connection has no active batch");
    try {
      if (this.currentUnitOfWork != null) {
        return this.currentUnitOfWork.runBatch();
      }
      return new long[0];
    } finally {
      this.batchMode = BatchMode.NONE;
      setDefaultTransactionOptions();
    }
  }

  @Override
  public void abortBatch() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(isBatchActive(), "This connection has no active batch");
    try {
      if (this.currentUnitOfWork != null) {
        this.currentUnitOfWork.abortBatch();
      }
    } finally {
      this.batchMode = BatchMode.NONE;
      setDefaultTransactionOptions();
    }
  }

  private boolean isBatchActive() {
    return isDdlBatchActive() || isDmlBatchActive();
  }

  @Override
  public boolean isDdlBatchActive() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return this.batchMode == BatchMode.DDL;
  }

  @Override
  public boolean isDmlBatchActive() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return this.batchMode == BatchMode.DML;
  }
}
