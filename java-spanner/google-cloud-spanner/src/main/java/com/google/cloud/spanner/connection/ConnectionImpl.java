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

import static com.google.cloud.spanner.SpannerApiFutures.get;
import static com.google.cloud.spanner.connection.ConnectionOptions.isEnableTransactionalConnectionStateForPostgreSQL;
import static com.google.cloud.spanner.connection.ConnectionPreconditions.checkValidIdentifier;
import static com.google.cloud.spanner.connection.ConnectionProperties.AUTOCOMMIT;
import static com.google.cloud.spanner.connection.ConnectionProperties.AUTOCOMMIT_DML_MODE;
import static com.google.cloud.spanner.connection.ConnectionProperties.AUTO_BATCH_DML;
import static com.google.cloud.spanner.connection.ConnectionProperties.AUTO_BATCH_DML_UPDATE_COUNT;
import static com.google.cloud.spanner.connection.ConnectionProperties.AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION;
import static com.google.cloud.spanner.connection.ConnectionProperties.AUTO_PARTITION_MODE;
import static com.google.cloud.spanner.connection.ConnectionProperties.BATCH_DML_UPDATE_COUNT;
import static com.google.cloud.spanner.connection.ConnectionProperties.DATA_BOOST_ENABLED;
import static com.google.cloud.spanner.connection.ConnectionProperties.DDL_IN_TRANSACTION_MODE;
import static com.google.cloud.spanner.connection.ConnectionProperties.DEFAULT_ISOLATION_LEVEL;
import static com.google.cloud.spanner.connection.ConnectionProperties.DEFAULT_SEQUENCE_KIND;
import static com.google.cloud.spanner.connection.ConnectionProperties.DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE;
import static com.google.cloud.spanner.connection.ConnectionProperties.DIRECTED_READ;
import static com.google.cloud.spanner.connection.ConnectionProperties.KEEP_TRANSACTION_ALIVE;
import static com.google.cloud.spanner.connection.ConnectionProperties.MAX_COMMIT_DELAY;
import static com.google.cloud.spanner.connection.ConnectionProperties.MAX_PARTITIONED_PARALLELISM;
import static com.google.cloud.spanner.connection.ConnectionProperties.MAX_PARTITIONS;
import static com.google.cloud.spanner.connection.ConnectionProperties.OPTIMIZER_STATISTICS_PACKAGE;
import static com.google.cloud.spanner.connection.ConnectionProperties.OPTIMIZER_VERSION;
import static com.google.cloud.spanner.connection.ConnectionProperties.READONLY;
import static com.google.cloud.spanner.connection.ConnectionProperties.READ_LOCK_MODE;
import static com.google.cloud.spanner.connection.ConnectionProperties.READ_ONLY_STALENESS;
import static com.google.cloud.spanner.connection.ConnectionProperties.RETRY_ABORTS_INTERNALLY;
import static com.google.cloud.spanner.connection.ConnectionProperties.RETURN_COMMIT_STATS;
import static com.google.cloud.spanner.connection.ConnectionProperties.RPC_PRIORITY;
import static com.google.cloud.spanner.connection.ConnectionProperties.SAVEPOINT_SUPPORT;
import static com.google.cloud.spanner.connection.ConnectionProperties.STATEMENT_TIMEOUT;
import static com.google.cloud.spanner.connection.ConnectionProperties.TRACING_PREFIX;
import static com.google.cloud.spanner.connection.ConnectionProperties.TRANSACTION_TIMEOUT;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.GaxProperties;
import com.google.cloud.ByteArray;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AsyncResultSet;
import com.google.cloud.spanner.BatchClient;
import com.google.cloud.spanner.BatchReadOnlyTransaction;
import com.google.cloud.spanner.CommitResponse;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadQueryUpdateTransactionOption;
import com.google.cloud.spanner.Options.RpcPriority;
import com.google.cloud.spanner.Options.UpdateOption;
import com.google.cloud.spanner.PartitionOptions;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TimestampBound.Mode;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.AbstractStatementParser.StatementType;
import com.google.cloud.spanner.connection.ConnectionProperty.Context;
import com.google.cloud.spanner.connection.ConnectionState.Type;
import com.google.cloud.spanner.connection.StatementExecutor.StatementExecutorType;
import com.google.cloud.spanner.connection.StatementExecutor.StatementTimeout;
import com.google.cloud.spanner.connection.StatementResult.ResultType;
import com.google.cloud.spanner.connection.UnitOfWork.CallType;
import com.google.cloud.spanner.connection.UnitOfWork.EndTransactionCallback;
import com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Suppliers;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.ExecuteSqlRequest.QueryOptions;
import com.google.spanner.v1.RequestOptions;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;
import io.grpc.Deadline;
import io.grpc.Deadline.Ticker;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** Implementation for {@link Connection}, the generic Spanner connection API (not JDBC). */
class ConnectionImpl implements Connection {
  private static final String INSTRUMENTATION_SCOPE = "cloud.google.com/java";
  private static final String SINGLE_USE_TRANSACTION = "SingleUseTransaction";
  private static final String READ_ONLY_TRANSACTION = "ReadOnlyTransaction";
  private static final String READ_WRITE_TRANSACTION = "ReadWriteTransaction";
  private static final String DDL_BATCH = "DdlBatch";
  private static final String DDL_STATEMENT = "DdlStatement";

  private static final String CLOSED_ERROR_MSG = "This connection is closed";
  private static final String ONLY_ALLOWED_IN_AUTOCOMMIT =
      "This method may only be called while in autocommit mode";
  private static final String NOT_ALLOWED_IN_AUTOCOMMIT =
      "This method may not be called while in autocommit mode";
  private static final ParsedStatement COMMIT_STATEMENT =
      AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
          .parse(Statement.of("COMMIT"));
  private static final ParsedStatement ROLLBACK_STATEMENT =
      AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
          .parse(Statement.of("ROLLBACK"));
  private static final ParsedStatement START_BATCH_DDL_STATEMENT =
      AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
          .parse(Statement.of("START BATCH DDL"));
  private static final ParsedStatement START_BATCH_DML_STATEMENT =
      AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
          .parse(Statement.of("START BATCH DML"));

  // These SAVEPOINT statements are used as sentinels to recognize the start/rollback/release of a
  // savepoint.
  private static final ParsedStatement SAVEPOINT_STATEMENT =
      AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
          .parse(Statement.of("SAVEPOINT s1"));
  private static final ParsedStatement ROLLBACK_TO_STATEMENT =
      AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
          .parse(Statement.of("ROLLBACK TO s1"));
  private static final ParsedStatement RELEASE_STATEMENT =
      AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
          .parse(Statement.of("RELEASE s1"));

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

  private volatile LeakedConnectionException leakedException;
  private final SpannerPool spannerPool;
  private AbstractStatementParser statementParser;

  /**
   * The {@link ConnectionStatementExecutor} is responsible for translating parsed {@link
   * ClientSideStatement}s into actual method calls on this {@link ConnectionImpl}. I.e. the {@link
   * ClientSideStatement} 'SET AUTOCOMMIT ON' will be translated into the method call {@link
   * ConnectionImpl#setAutocommit(boolean)} with value <code>true</code>.
   */
  private final ConnectionStatementExecutor connectionStatementExecutor =
      new ConnectionStatementExecutorImpl(this);

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

  enum Caller {
    APPLICATION,
    TRANSACTION_RUNNER,
  }

  /** The supported batch modes. */
  enum BatchMode {
    NONE,
    DDL,
    DML
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

  private final Ticker ticker;
  private StatementExecutor.StatementTimeout statementTimeout =
      new StatementExecutor.StatementTimeout();
  private boolean closed = false;

  private final Spanner spanner;
  private final Tracer tracer;
  private final Attributes openTelemetryAttributes;
  private final DdlClient ddlClient;
  private final DatabaseClient dbClient;
  private final BatchClient batchClient;
  private final ConnectionState connectionState;

  private UnitOfWork currentUnitOfWork = null;

  /**
   * This field is only used in autocommit mode to indicate that the user has explicitly started a
   * transaction.
   */
  private boolean inTransaction = false;

  /**
   * This field is used to indicate that a transaction begin has been indicated. This is done by
   * calling beginTransaction or by setting a transaction property while not in autocommit mode.
   */
  private boolean transactionBeginMarked = false;

  /** This field is set to true when a transaction runner is active for this connection. */
  private boolean transactionRunnerActive = false;

  private BatchMode batchMode;
  private UnitOfWorkType unitOfWorkType;
  private final Stack<UnitOfWork> transactionStack = new Stack<>();
  private final List<TransactionRetryListener> transactionRetryListeners = new ArrayList<>();

  // The following properties are not 'normal' connection properties, but transient properties that
  // are automatically reset after executing a transaction or statement.
  private IsolationLevel transactionIsolationLevel;
  private String transactionTag;
  private String statementTag;
  private RequestOptions.ClientContext clientContext;
  private boolean excludeTxnFromChangeStreams;
  private byte[] protoDescriptors;
  private String protoDescriptorsFilePath;

  /** Create a connection and register it in the SpannerPool. */
  ConnectionImpl(ConnectionOptions options) {
    Preconditions.checkNotNull(options);
    this.leakedException =
        options.isTrackConnectionLeaks() ? new LeakedConnectionException() : null;
    StatementExecutorType statementExecutorType;
    if (options.getStatementExecutorType() != null) {
      statementExecutorType = options.getStatementExecutorType();
    } else {
      statementExecutorType =
          options.isUseVirtualThreads()
              ? StatementExecutorType.VIRTUAL_THREAD
              : StatementExecutorType.PLATFORM_THREAD;
    }
    this.ticker = options.getTicker();
    this.statementExecutor =
        new StatementExecutor(statementExecutorType, options.getStatementExecutionInterceptors());
    this.spannerPool = SpannerPool.INSTANCE;
    this.options = options;
    this.spanner = spannerPool.getSpanner(options, this);
    this.tracer =
        spanner
            .getOptions()
            .getOpenTelemetry()
            .getTracer(
                INSTRUMENTATION_SCOPE,
                GaxProperties.getLibraryVersion(spanner.getOptions().getClass()));
    this.openTelemetryAttributes = createOpenTelemetryAttributes(options.getDatabaseId());
    if (options.isAutoConfigEmulator()) {
      EmulatorUtil.maybeCreateInstanceAndDatabase(
          spanner, options.getDatabaseId(), options.getDialect());
    }
    this.dbClient = spanner.getDatabaseClient(options.getDatabaseId());
    this.batchClient = spanner.getBatchClient(options.getDatabaseId());
    this.ddlClient = createDdlClient();
    this.connectionState =
        new ConnectionState(
            options.getInitialConnectionPropertyValues(),
            Suppliers.memoize(
                () ->
                    isEnableTransactionalConnectionStateForPostgreSQL()
                            && getDialect() == Dialect.POSTGRESQL
                        ? Type.TRANSACTIONAL
                        : Type.NON_TRANSACTIONAL));
    setInitialStatementTimeout(options.getInitialConnectionPropertyValue(STATEMENT_TIMEOUT));
    // (Re)set the state of the connection to the default.
    setDefaultTransactionOptions(getDefaultIsolationLevel());
  }

  /** Constructor only for test purposes. */
  @VisibleForTesting
  ConnectionImpl(
      ConnectionOptions options,
      SpannerPool spannerPool,
      DdlClient ddlClient,
      DatabaseClient dbClient,
      BatchClient batchClient) {
    this.leakedException =
        options.isTrackConnectionLeaks() ? new LeakedConnectionException() : null;
    this.statementExecutor =
        new StatementExecutor(
            options.isUseVirtualThreads()
                ? StatementExecutorType.VIRTUAL_THREAD
                : StatementExecutorType.PLATFORM_THREAD,
            Collections.emptyList());
    this.ticker = options.getTicker();
    this.spannerPool = Preconditions.checkNotNull(spannerPool);
    this.options = Preconditions.checkNotNull(options);
    this.spanner = spannerPool.getSpanner(options, this);
    this.tracer = OpenTelemetry.noop().getTracer(INSTRUMENTATION_SCOPE);
    this.openTelemetryAttributes = Attributes.empty();
    this.ddlClient = Preconditions.checkNotNull(ddlClient);
    this.dbClient = Preconditions.checkNotNull(dbClient);
    this.batchClient = Preconditions.checkNotNull(batchClient);
    this.connectionState =
        new ConnectionState(
            options.getInitialConnectionPropertyValues(),
            Suppliers.ofInstance(Type.NON_TRANSACTIONAL));
    setInitialStatementTimeout(options.getInitialConnectionPropertyValue(STATEMENT_TIMEOUT));
    setReadOnly(options.isReadOnly());
    setAutocommit(options.isAutocommit());
    setReturnCommitStats(options.isReturnCommitStats());
    setDefaultTransactionOptions(getDefaultIsolationLevel());
  }

  @Override
  public Spanner getSpanner() {
    return this.spanner;
  }

  private void setInitialStatementTimeout(Duration duration) {
    if (duration == null || duration.isZero()) {
      return;
    }
    com.google.protobuf.Duration protoDuration =
        com.google.protobuf.Duration.newBuilder()
            .setSeconds(duration.getSeconds())
            .setNanos(duration.getNano())
            .build();
    TimeUnit unit =
        ReadOnlyStalenessUtil.getAppropriateTimeUnit(
            new ReadOnlyStalenessUtil.DurationGetter(protoDuration));
    setStatementTimeout(ReadOnlyStalenessUtil.durationToUnits(protoDuration, unit), unit);
  }

  private DdlClient createDdlClient() {
    return DdlClient.newBuilder()
        .setDatabaseAdminClient(spanner.getDatabaseAdminClient())
        .setDialectSupplier(this::getDialect)
        .setProjectId(options.getProjectId())
        .setInstanceId(options.getInstanceId())
        .setDatabaseName(options.getDatabaseName())
        .build();
  }

  private AbstractStatementParser getStatementParser() {
    if (this.statementParser == null) {
      this.statementParser = AbstractStatementParser.getInstance(dbClient.getDialect());
    }
    return this.statementParser;
  }

  Attributes getOpenTelemetryAttributes() {
    return this.openTelemetryAttributes;
  }

  @VisibleForTesting
  static Attributes createOpenTelemetryAttributes(DatabaseId databaseId) {
    AttributesBuilder attributesBuilder = Attributes.builder();
    attributesBuilder.put("connection_id", UUID.randomUUID().toString());
    attributesBuilder.put("database", databaseId.getDatabase());
    attributesBuilder.put("instance_id", databaseId.getInstanceId().getInstance());
    attributesBuilder.put("project_id", databaseId.getInstanceId().getProject());
    return attributesBuilder.build();
  }

  @VisibleForTesting
  ConnectionState.Type getConnectionStateType() {
    return this.connectionState.getType();
  }

  @Override
  public void close() {
    try {
      closeAsync().get(10L, TimeUnit.SECONDS);
    } catch (SpannerException | InterruptedException | ExecutionException | TimeoutException e) {
      // ignore and continue to close the connection.
    } finally {
      statementExecutor.shutdownNow();
    }
  }

  public ApiFuture<Void> closeAsync() {
    synchronized (this) {
      if (!isClosed()) {
        List<ApiFuture<Void>> futures = new ArrayList<>();
        if (isBatchActive()) {
          abortBatch();
        }
        if (isTransactionStarted()) {
          try {
            futures.add(rollbackAsync());
          } catch (Exception exception) {
            // ignore and continue to close the connection.
          }
        }
        // Try to wait for the current statement to finish (if any) before we actually close the
        // connection.
        this.closed = true;
        // Add a no-op statement to the executor. Once this has been executed, we know that all
        // preceding statements have also been executed, as the executor is single-threaded and
        // executes all statements in order of submitting. The Executor#submit method can throw a
        // RejectedExecutionException if the executor is no longer in state where it accepts new
        // tasks.
        try {
          futures.add(statementExecutor.submit(() -> null));
        } catch (RejectedExecutionException ignored) {
          // ignore and continue to close the connection.
        }
        statementExecutor.shutdown();
        leakedException = null;
        spannerPool.removeConnection(options, this);
        return ApiFutures.transform(
            ApiFutures.allAsList(futures), ignored -> null, MoreExecutors.directExecutor());
      }
    }
    return ApiFutures.immediateFuture(null);
  }

  private Context getCurrentContext() {
    return Context.USER;
  }

  /**
   * Resets the state of this connection to the default state in the {@link ConnectionOptions} of
   * this connection.
   */
  public void reset() {
    reset(getCurrentContext(), isInTransaction());
  }

  private void reset(Context context, boolean inTransaction) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);

    // TODO: Replace all of these with a resetAll in ConnectionState.
    this.connectionState.resetValue(RETRY_ABORTS_INTERNALLY, context, inTransaction);
    this.connectionState.resetValue(AUTOCOMMIT, context, inTransaction);
    this.connectionState.resetValue(READONLY, context, inTransaction);
    this.connectionState.resetValue(DEFAULT_ISOLATION_LEVEL, context, inTransaction);
    this.connectionState.resetValue(READ_LOCK_MODE, context, inTransaction);
    this.connectionState.resetValue(TRANSACTION_TIMEOUT, context, inTransaction);
    this.connectionState.resetValue(READ_ONLY_STALENESS, context, inTransaction);
    this.connectionState.resetValue(OPTIMIZER_VERSION, context, inTransaction);
    this.connectionState.resetValue(OPTIMIZER_STATISTICS_PACKAGE, context, inTransaction);
    this.connectionState.resetValue(RPC_PRIORITY, context, inTransaction);
    this.connectionState.resetValue(DDL_IN_TRANSACTION_MODE, context, inTransaction);
    this.connectionState.resetValue(RETURN_COMMIT_STATS, context, inTransaction);
    this.connectionState.resetValue(
        DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE, context, inTransaction);
    this.connectionState.resetValue(KEEP_TRANSACTION_ALIVE, context, inTransaction);
    this.connectionState.resetValue(AUTO_PARTITION_MODE, context, inTransaction);
    this.connectionState.resetValue(DATA_BOOST_ENABLED, context, inTransaction);
    this.connectionState.resetValue(MAX_PARTITIONS, context, inTransaction);
    this.connectionState.resetValue(MAX_PARTITIONED_PARALLELISM, context, inTransaction);
    this.connectionState.resetValue(MAX_COMMIT_DELAY, context, inTransaction);

    this.connectionState.resetValue(AUTOCOMMIT_DML_MODE, context, inTransaction);
    this.statementTag = null;
    this.statementTimeout = new StatementExecutor.StatementTimeout();
    this.connectionState.resetValue(DIRECTED_READ, context, inTransaction);
    this.connectionState.resetValue(SAVEPOINT_SUPPORT, context, inTransaction);
    this.protoDescriptors = null;
    this.protoDescriptorsFilePath = null;
    this.clientContext = null;

    if (!isTransactionStarted()) {
      setDefaultTransactionOptions(getDefaultIsolationLevel());
    }
  }

  /** Get the current unit-of-work type of this connection. */
  UnitOfWorkType getUnitOfWorkType() {
    return unitOfWorkType;
  }

  /**
   * @return <code>true</code> if this connection is in a batch.
   */
  boolean isInBatch() {
    return batchMode != BatchMode.NONE;
  }

  /** Get the call stack from when the {@link Connection} was opened. */
  LeakedConnectionException getLeakedException() {
    return leakedException;
  }

  @Override
  public Dialect getDialect() {
    return dbClient.getDialect();
  }

  @Override
  public DatabaseClient getDatabaseClient() {
    return dbClient;
  }

  @Override
  public boolean isClosed() {
    return closed;
  }

  @Override
  public <T> T getConnectionPropertyValue(
      com.google.cloud.spanner.connection.ConnectionProperty<T> property) {
    return this.connectionState.getValue(property).getValue();
  }

  private <T> void setConnectionPropertyValue(ConnectionProperty<T> property, T value) {
    setConnectionPropertyValue(property, value, /* local= */ false);
  }

  private <T> void setConnectionPropertyValue(
      ConnectionProperty<T> property, T value, boolean local) {
    if (local) {
      setLocalConnectionPropertyValue(property, value);
    } else {
      this.connectionState.setValue(property, value, getCurrentContext(), isInTransaction());
    }
  }

  /**
   * Sets a connection property value only for the duration of the current transaction. The effects
   * of this will be undone once the transaction ends, regardless whether the transaction is
   * committed or rolled back. 'Local' properties are supported for both {@link
   * com.google.cloud.spanner.connection.ConnectionState.Type#TRANSACTIONAL} and {@link
   * com.google.cloud.spanner.connection.ConnectionState.Type#NON_TRANSACTIONAL} connection states.
   *
   * <p>NOTE: This feature is not yet exposed in the public API.
   */
  private <T> void setLocalConnectionPropertyValue(ConnectionProperty<T> property, T value) {
    ConnectionPreconditions.checkState(
        isInTransaction(), "SET LOCAL statements are only supported in transactions");
    this.connectionState.setLocalValue(property, value);
  }

  @Override
  public void setAutocommit(boolean autocommit) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    if (isAutocommit() == autocommit) {
      return;
    }
    ConnectionPreconditions.checkState(!isBatchActive(), "Cannot set autocommit while in a batch");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(), "Cannot set autocommit while a transaction is active");
    ConnectionPreconditions.checkState(
        !(isAutocommit() && isInTransaction()),
        "Cannot set autocommit while in a temporary transaction");
    ConnectionPreconditions.checkState(
        !transactionBeginMarked, "Cannot set autocommit when a transaction has begun");
    setConnectionPropertyValue(AUTOCOMMIT, autocommit);
    if (autocommit) {
      // Commit the current transaction state if we went from autocommit=false to autocommit=true.
      // Otherwise, we get the strange situation that autocommit=true cannot be committed, as we no
      // longer have a transaction. Note that all the above state checks essentially mean that
      // autocommit can only be set before a transaction has actually started, and not in the
      // middle of a transaction.
      this.connectionState.commit();
    }
    clearLastTransactionAndSetDefaultTransactionOptions(getDefaultIsolationLevel());
    // Reset the readOnlyStaleness value if it is no longer compatible with the new autocommit
    // value.
    if (!autocommit) {
      TimestampBound readOnlyStaleness = getReadOnlyStaleness();
      if (readOnlyStaleness.getMode() == Mode.MAX_STALENESS
          || readOnlyStaleness.getMode() == Mode.MIN_READ_TIMESTAMP) {
        setConnectionPropertyValue(READ_ONLY_STALENESS, TimestampBound.strong());
      }
    }
  }

  @Override
  public boolean isAutocommit() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return internalIsAutocommit();
  }

  private boolean internalIsAutocommit() {
    return getConnectionPropertyValue(AUTOCOMMIT);
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
    setConnectionPropertyValue(READONLY, readOnly);
    clearLastTransactionAndSetDefaultTransactionOptions(getDefaultIsolationLevel());
  }

  @Override
  public boolean isReadOnly() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return getConnectionPropertyValue(READONLY);
  }

  @Override
  public void setDefaultIsolationLevel(IsolationLevel isolationLevel) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Cannot default isolation level while in a batch");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(),
        "Cannot set default isolation level while a transaction is active");
    setConnectionPropertyValue(DEFAULT_ISOLATION_LEVEL, isolationLevel);
    clearLastTransactionAndSetDefaultTransactionOptions(isolationLevel);
  }

  @Override
  public IsolationLevel getDefaultIsolationLevel() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return getConnectionPropertyValue(DEFAULT_ISOLATION_LEVEL);
  }

  private void clearLastTransactionAndSetDefaultTransactionOptions(IsolationLevel isolationLevel) {
    setDefaultTransactionOptions(isolationLevel);
    this.currentUnitOfWork = null;
  }

  @Override
  public void setReadLockMode(ReadLockMode readLockMode) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    setConnectionPropertyValue(READ_LOCK_MODE, readLockMode);
  }

  @Override
  public ReadLockMode getReadLockMode() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return getConnectionPropertyValue(READ_LOCK_MODE);
  }

  @Override
  public void setTransactionTimeout(Duration timeout) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    setConnectionPropertyValue(TRANSACTION_TIMEOUT, timeout);
  }

  @Override
  public Duration getTransactionTimeout() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return getConnectionPropertyValue(TRANSACTION_TIMEOUT);
  }

  @Nullable
  Deadline getTransactionDeadline() {
    Duration timeout = getTransactionTimeout();
    return timeout == null
        ? null
        : Deadline.after(timeout.toNanos(), TimeUnit.NANOSECONDS, this.ticker);
  }

  @Override
  public void setAutocommitDmlMode(AutocommitDmlMode mode) {
    Preconditions.checkNotNull(mode);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Cannot set autocommit DML mode while in a batch");
    ConnectionPreconditions.checkState(
        !isInTransaction() && isAutocommit(),
        "Cannot set autocommit DML mode while not in autocommit mode or while a transaction is"
            + " active");
    ConnectionPreconditions.checkState(
        !isReadOnly(), "Cannot set autocommit DML mode for a read-only connection");
    setConnectionPropertyValue(AUTOCOMMIT_DML_MODE, mode);
  }

  @Override
  public AutocommitDmlMode getAutocommitDmlMode() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Cannot get autocommit DML mode while in a batch");
    return getConnectionPropertyValue(AUTOCOMMIT_DML_MODE);
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
    setConnectionPropertyValue(READ_ONLY_STALENESS, staleness);
  }

  @Override
  public TimestampBound getReadOnlyStaleness() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(!isBatchActive(), "Cannot get read-only while in a batch");
    return getConnectionPropertyValue(READ_ONLY_STALENESS);
  }

  @Override
  public void setDirectedRead(DirectedReadOptions directedReadOptions) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isTransactionStarted(),
        "Cannot set directed read options when a transaction has been started");
    setConnectionPropertyValue(DIRECTED_READ, directedReadOptions);
  }

  @Override
  public DirectedReadOptions getDirectedRead() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return getConnectionPropertyValue(DIRECTED_READ);
  }

  @Override
  public void setOptimizerVersion(String optimizerVersion) {
    Preconditions.checkNotNull(optimizerVersion);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    setConnectionPropertyValue(OPTIMIZER_VERSION, optimizerVersion);
  }

  @Override
  public String getOptimizerVersion() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return getConnectionPropertyValue(OPTIMIZER_VERSION);
  }

  @Override
  public void setOptimizerStatisticsPackage(String optimizerStatisticsPackage) {
    Preconditions.checkNotNull(optimizerStatisticsPackage);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    setConnectionPropertyValue(OPTIMIZER_STATISTICS_PACKAGE, optimizerStatisticsPackage);
  }

  @Override
  public String getOptimizerStatisticsPackage() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return getConnectionPropertyValue(OPTIMIZER_STATISTICS_PACKAGE);
  }

  private QueryOptions buildQueryOptions() {
    return QueryOptions.newBuilder()
        .setOptimizerVersion(getConnectionPropertyValue(OPTIMIZER_VERSION))
        .setOptimizerStatisticsPackage(getConnectionPropertyValue(OPTIMIZER_STATISTICS_PACKAGE))
        .build();
  }

  @Override
  public void setRPCPriority(RpcPriority rpcPriority) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    setConnectionPropertyValue(RPC_PRIORITY, rpcPriority);
  }

  @Override
  public RpcPriority getRPCPriority() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return getConnectionPropertyValue(RPC_PRIORITY);
  }

  @Override
  public DdlInTransactionMode getDdlInTransactionMode() {
    return getConnectionPropertyValue(DDL_IN_TRANSACTION_MODE);
  }

  @Override
  public void setDdlInTransactionMode(DdlInTransactionMode ddlInTransactionMode) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Cannot set DdlInTransactionMode while in a batch");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(), "Cannot set DdlInTransactionMode while a transaction is active");
    setConnectionPropertyValue(DDL_IN_TRANSACTION_MODE, ddlInTransactionMode);
  }

  @Override
  public String getDefaultSequenceKind() {
    return getConnectionPropertyValue(DEFAULT_SEQUENCE_KIND);
  }

  @Override
  public void setDefaultSequenceKind(String defaultSequenceKind) {
    setConnectionPropertyValue(DEFAULT_SEQUENCE_KIND, defaultSequenceKind);
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

  IsolationLevel getTransactionIsolationLevel() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(!isDdlBatchActive(), "This connection is in a DDL batch");
    ConnectionPreconditions.checkState(isInTransaction(), "This connection has no transaction");
    return this.transactionIsolationLevel;
  }

  void setTransactionIsolationLevel(IsolationLevel isolationLevel) {
    Preconditions.checkNotNull(isolationLevel);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Cannot set transaction isolation level while in a batch");
    ConnectionPreconditions.checkState(isInTransaction(), "This connection has no transaction");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(),
        "The transaction isolation level cannot be set after the transaction has started");

    this.transactionBeginMarked = true;
    this.transactionIsolationLevel = isolationLevel;
  }

  @Override
  public String getTransactionTag() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(!isDdlBatchActive(), "This connection is in a DDL batch");
    return transactionTag;
  }

  @Override
  public void setClientContext(RequestOptions.ClientContext clientContext) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    this.clientContext = clientContext;
  }

  @Override
  public RequestOptions.ClientContext getClientContext() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return clientContext;
  }

  @Override
  public void setTransactionTag(String tag) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Cannot set transaction tag while in a batch");
    ConnectionPreconditions.checkState(isInTransaction(), "This connection has no transaction");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(),
        "The transaction tag cannot be set after the transaction has started");
    ConnectionPreconditions.checkState(
        getTransactionMode() == TransactionMode.READ_WRITE_TRANSACTION,
        "Transaction tag can only be set for a read/write transaction");

    this.transactionBeginMarked = true;
    this.transactionTag = tag;
  }

  @Override
  public String getStatementTag() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Statement tags are not allowed inside a batch");
    return statementTag;
  }

  @Override
  public void setStatementTag(String tag) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Statement tags are not allowed inside a batch");

    this.statementTag = tag;
  }

  @Override
  public boolean isExcludeTxnFromChangeStreams() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(!isDdlBatchActive(), "This connection is in a DDL batch");
    return excludeTxnFromChangeStreams;
  }

  @Override
  public void setExcludeTxnFromChangeStreams(boolean excludeTxnFromChangeStreams) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Cannot set exclude_txn_from_change_streams while in a batch");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(),
        "exclude_txn_from_change_streams cannot be set after the transaction has started");
    this.excludeTxnFromChangeStreams = excludeTxnFromChangeStreams;
  }

  @Override
  public byte[] getProtoDescriptors() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    if (this.protoDescriptors == null && this.protoDescriptorsFilePath != null) {
      // Read from file if filepath is valid
      try {
        File protoDescriptorsFile = new File(this.protoDescriptorsFilePath);
        if (!protoDescriptorsFile.isFile()) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT,
              String.format(
                  "File %s is not a valid proto descriptors file", this.protoDescriptorsFilePath));
        }
        InputStream pdStream = Files.newInputStream(protoDescriptorsFile.toPath());
        this.protoDescriptors = ByteArray.copyFrom(pdStream).toByteArray();
      } catch (Exception exception) {
        throw SpannerExceptionFactory.newSpannerException(exception);
      }
    }
    return this.protoDescriptors;
  }

  @Override
  public void setProtoDescriptors(@Nonnull byte[] protoDescriptors) {
    Preconditions.checkNotNull(protoDescriptors);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Proto descriptors cannot be set when a batch is active");
    this.protoDescriptors = protoDescriptors;
    this.protoDescriptorsFilePath = null;
  }

  void setProtoDescriptorsFilePath(@Nonnull String protoDescriptorsFilePath) {
    Preconditions.checkNotNull(protoDescriptorsFilePath);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Proto descriptors file path cannot be set when a batch is active");
    this.protoDescriptorsFilePath = protoDescriptorsFilePath;
    this.protoDescriptors = null;
  }

  String getProtoDescriptorsFilePath() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return this.protoDescriptorsFilePath;
  }

  /**
   * Throws an {@link SpannerException} with code {@link ErrorCode#FAILED_PRECONDITION} if the
   * current state of this connection does not allow changing the setting for retryAbortsInternally.
   */
  private void checkSetRetryAbortsInternallyAvailable() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isTransactionStarted(),
        "RetryAbortsInternally cannot be set after the transaction has started");
  }

  @Override
  public boolean isRetryAbortsInternally() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return getConnectionPropertyValue(RETRY_ABORTS_INTERNALLY);
  }

  @Override
  public void setRetryAbortsInternally(boolean retryAbortsInternally) {
    setRetryAbortsInternally(retryAbortsInternally, /* local= */ false);
  }

  void setRetryAbortsInternally(boolean retryAbortsInternally, boolean local) {
    checkSetRetryAbortsInternallyAvailable();
    setConnectionPropertyValue(RETRY_ABORTS_INTERNALLY, retryAbortsInternally, local);
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

  private boolean hasTransactionalChanges() {
    return internalIsTransactionStarted() || this.connectionState.hasTransactionalChanges();
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

  @Override
  public CommitResponse getCommitResponse() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        this.currentUnitOfWork != null, "There is no transaction on this connection");
    return this.currentUnitOfWork.getCommitResponse();
  }

  CommitResponse getCommitResponseOrNull() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return this.currentUnitOfWork == null ? null : this.currentUnitOfWork.getCommitResponseOrNull();
  }

  @Override
  public void setReturnCommitStats(boolean returnCommitStats) {
    setReturnCommitStats(returnCommitStats, /* local= */ false);
  }

  @VisibleForTesting
  void setReturnCommitStats(boolean returnCommitStats, boolean local) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    setConnectionPropertyValue(RETURN_COMMIT_STATS, returnCommitStats, local);
  }

  @Override
  public boolean isReturnCommitStats() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return getConnectionPropertyValue(RETURN_COMMIT_STATS);
  }

  @Override
  public void setMaxCommitDelay(Duration maxCommitDelay) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    setConnectionPropertyValue(MAX_COMMIT_DELAY, maxCommitDelay);
  }

  @Override
  public Duration getMaxCommitDelay() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return getConnectionPropertyValue(MAX_COMMIT_DELAY);
  }

  @Override
  public void setDelayTransactionStartUntilFirstWrite(
      boolean delayTransactionStartUntilFirstWrite) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isTransactionStarted(),
        "Cannot set DelayTransactionStartUntilFirstWrite while a transaction is active");
    setConnectionPropertyValue(
        DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE, delayTransactionStartUntilFirstWrite);
  }

  @Override
  public boolean isDelayTransactionStartUntilFirstWrite() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return getConnectionPropertyValue(DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE);
  }

  @Override
  public void setKeepTransactionAlive(boolean keepTransactionAlive) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isTransactionStarted(), "Cannot set KeepTransactionAlive while a transaction is active");
    setConnectionPropertyValue(KEEP_TRANSACTION_ALIVE, keepTransactionAlive);
  }

  @Override
  public boolean isKeepTransactionAlive() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    return getConnectionPropertyValue(KEEP_TRANSACTION_ALIVE);
  }

  /** Resets this connection to its default transaction options. */
  private void setDefaultTransactionOptions(IsolationLevel isolationLevel) {
    if (transactionStack.isEmpty()) {
      unitOfWorkType =
          isReadOnly()
              ? UnitOfWorkType.READ_ONLY_TRANSACTION
              : UnitOfWorkType.READ_WRITE_TRANSACTION;
      batchMode = BatchMode.NONE;
      transactionIsolationLevel = isolationLevel;
      transactionTag = null;
      excludeTxnFromChangeStreams = false;
    } else {
      popUnitOfWorkFromTransactionStack();
    }
  }

  @Override
  public void beginTransaction() {
    get(beginTransactionAsync(getConnectionPropertyValue(DEFAULT_ISOLATION_LEVEL)));
  }

  @Override
  public void beginTransaction(IsolationLevel isolationLevel) {
    get(beginTransactionAsync(isolationLevel));
  }

  @Override
  public ApiFuture<Void> beginTransactionAsync() {
    return beginTransactionAsync(getConnectionPropertyValue(DEFAULT_ISOLATION_LEVEL));
  }

  @Override
  public ApiFuture<Void> beginTransactionAsync(IsolationLevel isolationLevel) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "This connection has an active batch and cannot begin a transaction");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(),
        "Beginning a new transaction is not allowed when a transaction is already running");
    ConnectionPreconditions.checkState(!transactionBeginMarked, "A transaction has already begun");

    transactionBeginMarked = true;
    clearLastTransactionAndSetDefaultTransactionOptions(isolationLevel);
    if (isAutocommit()) {
      inTransaction = true;
    }
    return ApiFutures.immediateFuture(null);
  }

  /** Internal interface for ending a transaction (commit/rollback). */
  private interface EndTransactionMethod {
    ApiFuture<Void> endAsync(CallType callType, UnitOfWork t);
  }

  private final class Commit implements EndTransactionMethod {
    @Override
    public ApiFuture<Void> endAsync(CallType callType, UnitOfWork t) {
      return t.commitAsync(
          callType,
          new EndTransactionCallback() {
            @Override
            public void onSuccess() {
              ConnectionImpl.this.connectionState.commit();
            }

            @Override
            public void onFailure() {
              ConnectionImpl.this.connectionState.rollback();
            }
          });
    }
  }

  private final Commit commit = new Commit();

  @Override
  public void commit() {
    get(commitAsync(CallType.SYNC, Caller.APPLICATION));
  }

  @Override
  public ApiFuture<Void> commitAsync() {
    return commitAsync(CallType.ASYNC, Caller.APPLICATION);
  }

  ApiFuture<Void> commitAsync(CallType callType, Caller caller) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !transactionRunnerActive || caller == Caller.TRANSACTION_RUNNER,
        "Cannot call commit when a transaction runner is active");
    maybeAutoCommitOrFlushCurrentUnitOfWork(COMMIT_STATEMENT.getType(), COMMIT_STATEMENT);
    return endCurrentTransactionAsync(callType, commit, COMMIT_STATEMENT);
  }

  private final class Rollback implements EndTransactionMethod {
    @Override
    public ApiFuture<Void> endAsync(CallType callType, UnitOfWork t) {
      return t.rollbackAsync(
          callType,
          new EndTransactionCallback() {
            @Override
            public void onSuccess() {
              ConnectionImpl.this.connectionState.rollback();
            }

            @Override
            public void onFailure() {
              ConnectionImpl.this.connectionState.rollback();
            }
          });
    }
  }

  private final Rollback rollback = new Rollback();

  @Override
  public void rollback() {
    get(rollbackAsync(CallType.SYNC, Caller.APPLICATION));
  }

  @Override
  public ApiFuture<Void> rollbackAsync() {
    return rollbackAsync(CallType.ASYNC, Caller.APPLICATION);
  }

  ApiFuture<Void> rollbackAsync(CallType callType, Caller caller) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !transactionRunnerActive || caller == Caller.TRANSACTION_RUNNER,
        "Cannot call rollback when a transaction runner is active");
    maybeAutoCommitOrFlushCurrentUnitOfWork(ROLLBACK_STATEMENT.getType(), ROLLBACK_STATEMENT);
    return endCurrentTransactionAsync(callType, rollback, ROLLBACK_STATEMENT);
  }

  private ApiFuture<Void> endCurrentTransactionAsync(
      CallType callType,
      EndTransactionMethod endTransactionMethod,
      ParsedStatement parsedStatement) {
    ConnectionPreconditions.checkState(!isBatchActive(), "This connection has an active batch");
    ConnectionPreconditions.checkState(isInTransaction(), "This connection has no transaction");
    ConnectionPreconditions.checkState(
        statementTag == null, "Statement tags are not supported for COMMIT or ROLLBACK");
    ApiFuture<Void> res;
    try {
      if (hasTransactionalChanges()) {
        res =
            endTransactionMethod.endAsync(
                callType, getCurrentUnitOfWorkOrStartNewUnitOfWork(parsedStatement));
      } else {
        this.currentUnitOfWork = null;
        res = ApiFutures.immediateFuture(null);
      }
    } finally {
      transactionBeginMarked = false;
      if (isAutocommit()) {
        inTransaction = false;
      }
      setDefaultTransactionOptions(getDefaultIsolationLevel());
    }
    return res;
  }

  @Override
  public <T> T runTransaction(TransactionCallable<T> callable) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(!isBatchActive(), "Cannot run transaction while in a batch");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(), "Cannot run transaction when a transaction is already active");
    ConnectionPreconditions.checkState(
        !transactionRunnerActive, "A transaction runner is already active for this connection");
    this.transactionRunnerActive = true;
    try {
      return new TransactionRunnerImpl(this).run(callable);
    } finally {
      this.transactionRunnerActive = false;
    }
  }

  void resetForRetry(UnitOfWork retryUnitOfWork) {
    retryUnitOfWork.resetForRetry();
    this.currentUnitOfWork = retryUnitOfWork;
  }

  @Override
  public SavepointSupport getSavepointSupport() {
    return getConnectionPropertyValue(SAVEPOINT_SUPPORT);
  }

  @Override
  public void setSavepointSupport(SavepointSupport savepointSupport) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Cannot set SavepointSupport while in a batch");
    ConnectionPreconditions.checkState(
        !isTransactionStarted(), "Cannot set SavepointSupport while a transaction is active");
    setConnectionPropertyValue(SAVEPOINT_SUPPORT, savepointSupport);
  }

  @Override
  public void savepoint(String name) {
    ConnectionPreconditions.checkState(isInTransaction(), "This connection has no transaction");
    SavepointSupport savepointSupport = getSavepointSupport();
    ConnectionPreconditions.checkState(
        savepointSupport.isSavepointCreationAllowed(),
        "This connection does not allow the creation of savepoints. Current value of"
            + " SavepointSupport: "
            + savepointSupport);
    getCurrentUnitOfWorkOrStartNewUnitOfWork(SAVEPOINT_STATEMENT)
        .savepoint(checkValidIdentifier(name), getDialect());
  }

  @Override
  public void releaseSavepoint(String name) {
    ConnectionPreconditions.checkState(
        isTransactionStarted(), "This connection has no active transaction");
    getCurrentUnitOfWorkOrStartNewUnitOfWork(RELEASE_STATEMENT)
        .releaseSavepoint(checkValidIdentifier(name));
  }

  @Override
  public void rollbackToSavepoint(String name) {
    ConnectionPreconditions.checkState(
        isTransactionStarted(), "This connection has no active transaction");
    getCurrentUnitOfWorkOrStartNewUnitOfWork(ROLLBACK_TO_STATEMENT)
        .rollbackToSavepoint(checkValidIdentifier(name), getSavepointSupport());
  }

  @Override
  public StatementResult execute(Statement statement) {
    return internalExecute(Preconditions.checkNotNull(statement), null);
  }

  @Override
  public StatementResult execute(Statement statement, Set<ResultType> allowedResultTypes) {
    return internalExecute(
        Preconditions.checkNotNull(statement), Preconditions.checkNotNull(allowedResultTypes));
  }

  private StatementResult internalExecute(
      Statement statement, @Nullable Set<ResultType> allowedResultTypes) {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ParsedStatement parsedStatement = getStatementParser().parse(statement, buildQueryOptions());
    checkResultTypeAllowed(parsedStatement, allowedResultTypes);
    switch (parsedStatement.getType()) {
      case CLIENT_SIDE:
        return parsedStatement
            .getClientSideStatement()
            .execute(connectionStatementExecutor, parsedStatement);
      case QUERY:
        return StatementResultImpl.of(
            internalExecuteQuery(CallType.SYNC, parsedStatement, AnalyzeMode.NONE));
      case UPDATE:
        if (parsedStatement.hasReturningClause()) {
          return StatementResultImpl.of(
              internalExecuteQuery(CallType.SYNC, parsedStatement, AnalyzeMode.NONE));
        }
        return StatementResultImpl.of(
            get(internalExecuteUpdateAsync(CallType.SYNC, parsedStatement)));
      case DDL:
        get(executeDdlAsync(CallType.SYNC, parsedStatement));
        return StatementResultImpl.noResult();
      case UNKNOWN:
      default:
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT, "Unknown statement: " + parsedStatement.getSql());
  }

  @VisibleForTesting
  static void checkResultTypeAllowed(
      ParsedStatement parsedStatement, @Nullable Set<ResultType> allowedResultTypes) {
    if (allowedResultTypes == null) {
      return;
    }
    ResultType resultType = getResultType(parsedStatement);
    if (!allowedResultTypes.contains(resultType)) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT,
          "This statement returns a result of type "
              + resultType
              + ". Only statements that return a result of one of the following types are allowed: "
              + allowedResultTypes.stream()
                  .map(ResultType::toString)
                  .collect(Collectors.joining(", ")));
    }
  }

  private static ResultType getResultType(ParsedStatement parsedStatement) {
    switch (parsedStatement.getType()) {
      case CLIENT_SIDE:
        if (parsedStatement.getClientSideStatement().isQuery()) {
          return ResultType.RESULT_SET;
        } else if (parsedStatement.getClientSideStatement().isUpdate()) {
          return ResultType.UPDATE_COUNT;
        } else {
          return ResultType.NO_RESULT;
        }
      case QUERY:
        return ResultType.RESULT_SET;
      case UPDATE:
        if (parsedStatement.hasReturningClause()) {
          return ResultType.RESULT_SET;
        } else {
          return ResultType.UPDATE_COUNT;
        }
      case DDL:
        return ResultType.NO_RESULT;
      case UNKNOWN:
      default:
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "Unknown statement: " + parsedStatement.getSql());
    }
  }

  @Override
  public AsyncStatementResult executeAsync(Statement statement) {
    Preconditions.checkNotNull(statement);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ParsedStatement parsedStatement = getStatementParser().parse(statement, buildQueryOptions());
    switch (parsedStatement.getType()) {
      case CLIENT_SIDE:
        return AsyncStatementResultImpl.of(
            parsedStatement
                .getClientSideStatement()
                .execute(connectionStatementExecutor, parsedStatement),
            spanner.getAsyncExecutorProvider());
      case QUERY:
        return AsyncStatementResultImpl.of(
            internalExecuteQueryAsync(CallType.ASYNC, parsedStatement, AnalyzeMode.NONE));
      case UPDATE:
        if (parsedStatement.hasReturningClause()) {
          return AsyncStatementResultImpl.of(
              internalExecuteQueryAsync(CallType.ASYNC, parsedStatement, AnalyzeMode.NONE));
        }
        return AsyncStatementResultImpl.of(
            internalExecuteUpdateAsync(CallType.ASYNC, parsedStatement));
      case DDL:
        return AsyncStatementResultImpl.noResult(executeDdlAsync(CallType.ASYNC, parsedStatement));
      case UNKNOWN:
      default:
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT, "Unknown statement: " + parsedStatement.getSql());
  }

  @Override
  public ResultSet executeQuery(Statement query, QueryOption... options) {
    return parseAndExecuteQuery(CallType.SYNC, query, AnalyzeMode.NONE, options);
  }

  @Override
  public AsyncResultSet executeQueryAsync(Statement query, QueryOption... options) {
    return parseAndExecuteQueryAsync(query, options);
  }

  @Override
  public ResultSet analyzeQuery(Statement query, QueryAnalyzeMode queryMode) {
    Preconditions.checkNotNull(queryMode);
    return parseAndExecuteQuery(CallType.SYNC, query, AnalyzeMode.of(queryMode));
  }

  @Override
  public void setAutoBatchDml(boolean autoBatchDml) {
    setConnectionPropertyValue(AUTO_BATCH_DML, autoBatchDml);
  }

  @Override
  public boolean isAutoBatchDml() {
    return getConnectionPropertyValue(AUTO_BATCH_DML);
  }

  @Override
  public void setAutoBatchDmlUpdateCount(long updateCount) {
    setConnectionPropertyValue(AUTO_BATCH_DML_UPDATE_COUNT, updateCount);
  }

  @Override
  public long getAutoBatchDmlUpdateCount() {
    return getConnectionPropertyValue(AUTO_BATCH_DML_UPDATE_COUNT);
  }

  long getDmlBatchUpdateCount() {
    return getConnectionPropertyValue(BATCH_DML_UPDATE_COUNT);
  }

  @Override
  public void setAutoBatchDmlUpdateCountVerification(boolean verification) {
    setConnectionPropertyValue(AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION, verification);
  }

  @Override
  public boolean isAutoBatchDmlUpdateCountVerification() {
    return getConnectionPropertyValue(AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION);
  }

  void setBatchDmlUpdateCount(long updateCount, boolean local) {
    setConnectionPropertyValue(BATCH_DML_UPDATE_COUNT, updateCount, local);
  }

  @Override
  public void setDataBoostEnabled(boolean dataBoostEnabled) {
    setConnectionPropertyValue(DATA_BOOST_ENABLED, dataBoostEnabled);
  }

  @Override
  public boolean isDataBoostEnabled() {
    return getConnectionPropertyValue(DATA_BOOST_ENABLED);
  }

  @Override
  public void setAutoPartitionMode(boolean autoPartitionMode) {
    setConnectionPropertyValue(AUTO_PARTITION_MODE, autoPartitionMode);
  }

  /**
   * autoPartitionMode will force this connection to execute all queries as partitioned queries. If
   * a query cannot be executed as a partitioned query, for example if it is not partitionable, then
   * the query will fail. This mode is intended for integrations with frameworks that should always
   * use partitioned queries, and that do not support executing custom SQL statements. This setting
   * can be used in combination with the dataBoostEnabled flag to force all queries to use data
   * boost.
   */
  @Override
  public boolean isAutoPartitionMode() {
    return getConnectionPropertyValue(AUTO_PARTITION_MODE);
  }

  @Override
  public void setMaxPartitions(int maxPartitions) {
    setConnectionPropertyValue(MAX_PARTITIONS, maxPartitions);
  }

  @Override
  public int getMaxPartitions() {
    return getConnectionPropertyValue(MAX_PARTITIONS);
  }

  @Override
  public ResultSet partitionQuery(
      Statement query, PartitionOptions partitionOptions, QueryOption... options) {
    ParsedStatement parsedStatement = getStatementParser().parse(query, buildQueryOptions());
    if (parsedStatement.getType() != StatementType.QUERY) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT,
          "Only queries can be partitioned. Invalid statement: " + query.getSql());
    }

    QueryOption[] combinedOptions = concat(parsedStatement.getOptionsFromHints(), options);
    UnitOfWork transaction = getCurrentUnitOfWorkOrStartNewUnitOfWork(parsedStatement);
    return get(
        transaction.partitionQueryAsync(
            CallType.SYNC,
            parsedStatement,
            getEffectivePartitionOptions(partitionOptions),
            mergeDataBoost(
                mergeQueryRequestOptions(
                    parsedStatement, mergeQueryStatementTag(combinedOptions)))));
  }

  private PartitionOptions getEffectivePartitionOptions(
      PartitionOptions callSpecificPartitionOptions) {
    if (getMaxPartitions() == 0) {
      if (callSpecificPartitionOptions == null) {
        return PartitionOptions.newBuilder().build();
      } else {
        return callSpecificPartitionOptions;
      }
    }
    if (callSpecificPartitionOptions != null
        && callSpecificPartitionOptions.getMaxPartitions() > 0L) {
      return callSpecificPartitionOptions;
    }
    if (callSpecificPartitionOptions != null
        && callSpecificPartitionOptions.getPartitionSizeBytes() > 0L) {
      return PartitionOptions.newBuilder()
          .setMaxPartitions(getMaxPartitions())
          .setPartitionSizeBytes(callSpecificPartitionOptions.getPartitionSizeBytes())
          .build();
    }
    return PartitionOptions.newBuilder().setMaxPartitions(getMaxPartitions()).build();
  }

  @Override
  public ResultSet runPartition(String encodedPartitionId) {
    PartitionId id = PartitionId.decodeFromString(encodedPartitionId);
    try (BatchReadOnlyTransaction transaction =
        batchClient.batchReadOnlyTransaction(id.getTransactionId())) {
      return transaction.execute(id.getPartition());
    }
  }

  @Override
  public void setMaxPartitionedParallelism(int maxThreads) {
    Preconditions.checkArgument(maxThreads >= 0, "maxThreads must be >=0");
    setConnectionPropertyValue(MAX_PARTITIONED_PARALLELISM, maxThreads);
  }

  @Override
  public int getMaxPartitionedParallelism() {
    return getConnectionPropertyValue(MAX_PARTITIONED_PARALLELISM);
  }

  @Override
  public PartitionedQueryResultSet runPartitionedQuery(
      Statement query, PartitionOptions partitionOptions, QueryOption... options) {
    List<String> partitionIds = new ArrayList<>();
    try (ResultSet partitions = partitionQuery(query, partitionOptions, options)) {
      while (partitions.next()) {
        partitionIds.add(partitions.getString(0));
      }
    }
    // parallelism=0 means 'dynamically choose based on the number of available processors and the
    // number of partitions'.
    return new MergedResultSet(this, partitionIds, getMaxPartitionedParallelism());
  }

  /**
   * Parses the given statement as a query and executes it. Throws a {@link SpannerException} if the
   * statement is not a query.
   */
  private ResultSet parseAndExecuteQuery(
      CallType callType, Statement query, AnalyzeMode analyzeMode, QueryOption... options) {
    Preconditions.checkNotNull(query);
    Preconditions.checkNotNull(analyzeMode);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ParsedStatement parsedStatement = getStatementParser().parse(query, buildQueryOptions());
    if (parsedStatement.isQuery() || parsedStatement.isUpdate()) {
      switch (parsedStatement.getType()) {
        case CLIENT_SIDE:
          return parsedStatement
              .getClientSideStatement()
              .execute(connectionStatementExecutor, parsedStatement)
              .getResultSet();
        case QUERY:
          return internalExecuteQuery(callType, parsedStatement, analyzeMode, options);
        case UPDATE:
          if (parsedStatement.hasReturningClause()) {
            // Cannot execute DML statement with returning clause in read-only mode or in
            // READ_ONLY_TRANSACTION transaction mode.
            if (this.isReadOnly()
                || (this.isInTransaction()
                    && this.getTransactionMode() == TransactionMode.READ_ONLY_TRANSACTION)) {
              throw SpannerExceptionFactory.newSpannerException(
                  ErrorCode.FAILED_PRECONDITION,
                  "DML statement with returning clause cannot be executed in read-only mode: "
                      + parsedStatement.getSql());
            }
            return internalExecuteQuery(callType, parsedStatement, analyzeMode, options);
          }
        case DDL:
        case UNKNOWN:
        default:
      }
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT,
        "Statement is not a query or DML with returning clause: " + parsedStatement.getSql());
  }

  private AsyncResultSet parseAndExecuteQueryAsync(Statement query, QueryOption... options) {
    Preconditions.checkNotNull(query);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ParsedStatement parsedStatement = getStatementParser().parse(query, buildQueryOptions());
    if (parsedStatement.isQuery() || parsedStatement.isUpdate()) {
      switch (parsedStatement.getType()) {
        case CLIENT_SIDE:
          return ResultSets.toAsyncResultSet(
              parsedStatement
                  .getClientSideStatement()
                  .execute(connectionStatementExecutor, parsedStatement)
                  .getResultSet(),
              spanner.getAsyncExecutorProvider(),
              options);
        case QUERY:
          return internalExecuteQueryAsync(
              CallType.ASYNC, parsedStatement, AnalyzeMode.NONE, options);
        case UPDATE:
          if (parsedStatement.hasReturningClause()) {
            // Cannot execute DML statement with returning clause in read-only mode or in
            // READ_ONLY_TRANSACTION transaction mode.
            if (this.isReadOnly()
                || (this.isInTransaction()
                    && this.getTransactionMode() == TransactionMode.READ_ONLY_TRANSACTION)) {
              throw SpannerExceptionFactory.newSpannerException(
                  ErrorCode.FAILED_PRECONDITION,
                  "DML statement with returning clause cannot be executed in read-only mode: "
                      + parsedStatement.getSql());
            }
            return internalExecuteQueryAsync(
                CallType.ASYNC, parsedStatement, AnalyzeMode.NONE, options);
          }
        case DDL:
        case UNKNOWN:
        default:
      }
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT,
        "Statement is not a query or DML with returning clause: " + parsedStatement.getSql());
  }

  private boolean isInternalMetadataQuery(QueryOption... options) {
    if (options == null) {
      return false;
    }
    for (QueryOption option : options) {
      if (option instanceof InternalMetadataQuery) {
        return true;
      }
    }
    return false;
  }

  @Override
  public long executeUpdate(Statement update) {
    Preconditions.checkNotNull(update);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ParsedStatement parsedStatement = getStatementParser().parse(update);
    if (parsedStatement.isUpdate()) {
      switch (parsedStatement.getType()) {
        case UPDATE:
          if (parsedStatement.hasReturningClause()) {
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.FAILED_PRECONDITION,
                "DML statement with returning clause cannot be executed using executeUpdate: "
                    + parsedStatement.getSql()
                    + ". Please use executeQuery instead.");
          }
          return get(internalExecuteUpdateAsync(CallType.SYNC, parsedStatement));
        case CLIENT_SIDE:
        case QUERY:
        case DDL:
        case UNKNOWN:
        default:
      }
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT,
        "Statement is not an update statement: " + parsedStatement.getSql());
  }

  @Override
  public ApiFuture<Long> executeUpdateAsync(Statement update) {
    Preconditions.checkNotNull(update);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ParsedStatement parsedStatement = getStatementParser().parse(update);
    if (parsedStatement.isUpdate()) {
      switch (parsedStatement.getType()) {
        case UPDATE:
          if (parsedStatement.hasReturningClause()) {
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.FAILED_PRECONDITION,
                "DML statement with returning clause cannot be executed using executeUpdateAsync: "
                    + parsedStatement.getSql()
                    + ". Please use executeQueryAsync instead.");
          }
          return internalExecuteUpdateAsync(CallType.ASYNC, parsedStatement);
        case CLIENT_SIDE:
        case QUERY:
        case DDL:
        case UNKNOWN:
        default:
      }
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT,
        "Statement is not an update statement: " + parsedStatement.getSql());
  }

  @Override
  public ResultSetStats analyzeUpdate(Statement update, QueryAnalyzeMode analyzeMode) {
    Preconditions.checkNotNull(update);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ParsedStatement parsedStatement = getStatementParser().parse(update);
    if (parsedStatement.isUpdate()) {
      switch (parsedStatement.getType()) {
        case UPDATE:
          return get(internalAnalyzeUpdateAsync(
                  CallType.SYNC, parsedStatement, AnalyzeMode.of(analyzeMode)))
              .getStats();
        case CLIENT_SIDE:
        case QUERY:
        case DDL:
        case UNKNOWN:
        default:
      }
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT,
        "Statement is not an update statement: " + parsedStatement.getSql());
  }

  @Override
  public ResultSet analyzeUpdateStatement(
      Statement statement, QueryAnalyzeMode analyzeMode, UpdateOption... options) {
    Preconditions.checkNotNull(statement);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ParsedStatement parsedStatement = getStatementParser().parse(statement);
    switch (parsedStatement.getType()) {
      case UPDATE:
        return get(
            internalAnalyzeUpdateAsync(
                CallType.SYNC, parsedStatement, AnalyzeMode.of(analyzeMode), options));
      case QUERY:
      case CLIENT_SIDE:
      case DDL:
      case UNKNOWN:
      default:
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT,
        "Statement is not an update statement: " + parsedStatement.getSql());
  }

  @Override
  public long[] executeBatchUpdate(Iterable<Statement> updates) {
    return get(internalExecuteBatchUpdateAsync(CallType.SYNC, parseUpdateStatements(updates)));
  }

  @Override
  public ApiFuture<long[]> executeBatchUpdateAsync(Iterable<Statement> updates) {
    return internalExecuteBatchUpdateAsync(CallType.ASYNC, parseUpdateStatements(updates));
  }

  private List<ParsedStatement> parseUpdateStatements(Iterable<Statement> updates) {
    Preconditions.checkNotNull(updates);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    // Check that there are only DML statements in the input.
    List<ParsedStatement> parsedStatements = new LinkedList<>();
    for (Statement update : updates) {
      ParsedStatement parsedStatement = getStatementParser().parse(update);
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
                  + parsedStatement.getSql());
      }
    }
    return parsedStatements;
  }

  private UpdateOption[] concat(
      ReadQueryUpdateTransactionOption[] statementOptions, UpdateOption[] argumentOptions) {
    if (statementOptions == null || statementOptions.length == 0) {
      return argumentOptions;
    }
    if (argumentOptions == null || argumentOptions.length == 0) {
      return statementOptions;
    }
    UpdateOption[] result =
        Arrays.copyOf(statementOptions, statementOptions.length + argumentOptions.length);
    System.arraycopy(argumentOptions, 0, result, statementOptions.length, argumentOptions.length);
    return result;
  }

  private QueryOption[] concat(
      ReadQueryUpdateTransactionOption[] statementOptions, QueryOption[] argumentOptions) {
    if (statementOptions == null || statementOptions.length == 0) {
      return argumentOptions;
    }
    if (argumentOptions == null || argumentOptions.length == 0) {
      return statementOptions;
    }
    QueryOption[] result =
        Arrays.copyOf(statementOptions, statementOptions.length + argumentOptions.length);
    System.arraycopy(argumentOptions, 0, result, statementOptions.length, argumentOptions.length);
    return result;
  }

  private QueryOption[] mergeDataBoost(QueryOption... options) {
    if (isDataBoostEnabled()) {
      options = appendQueryOption(options, Options.dataBoostEnabled(true));
    }
    return options;
  }

  private QueryOption[] mergeQueryStatementTag(QueryOption... options) {
    if (this.statementTag != null) {
      options = appendQueryOption(options, Options.tag(statementTag));
      this.statementTag = null;
    }
    return options;
  }

  private QueryOption[] mergeQueryRequestOptions(
      ParsedStatement parsedStatement, QueryOption... options) {
    if (getConnectionPropertyValue(RPC_PRIORITY) != null) {
      options =
          appendQueryOption(options, Options.priority(getConnectionPropertyValue(RPC_PRIORITY)));
    }
    if (clientContext != null) {
      options = appendQueryOption(options, Options.clientContext(clientContext));
    }
    if (currentUnitOfWork != null
        && currentUnitOfWork.supportsDirectedReads(parsedStatement)
        && getConnectionPropertyValue(DIRECTED_READ) != null) {
      options =
          appendQueryOption(
              options, Options.directedRead(getConnectionPropertyValue(DIRECTED_READ)));
    }
    return options;
  }

  private QueryOption[] appendQueryOption(QueryOption[] options, QueryOption append) {
    if (options == null || options.length == 0) {
      options = new QueryOption[] {append};
    } else {
      options = Arrays.copyOf(options, options.length + 1);
      options[options.length - 1] = append;
    }
    return options;
  }

  private UpdateOption[] mergeUpdateStatementTag(UpdateOption... options) {
    if (this.statementTag != null) {
      // Shortcut for the most common scenario.
      if (options == null || options.length == 0) {
        options = new UpdateOption[] {Options.tag(statementTag)};
      } else {
        options = Arrays.copyOf(options, options.length + 1);
        options[options.length - 1] = Options.tag(statementTag);
      }
      this.statementTag = null;
    }
    return options;
  }

  private UpdateOption[] mergeUpdateRequestOptions(UpdateOption... options) {
    if (getConnectionPropertyValue(RPC_PRIORITY) != null) {
      // Shortcut for the most common scenario.
      if (options == null || options.length == 0) {
        options = new UpdateOption[] {Options.priority(getConnectionPropertyValue(RPC_PRIORITY))};
      } else {
        options = Arrays.copyOf(options, options.length + 1);
        options[options.length - 1] = Options.priority(getConnectionPropertyValue(RPC_PRIORITY));
      }
    }
    if (clientContext != null) {
      if (options == null || options.length == 0) {
        options = new UpdateOption[] {Options.clientContext(clientContext)};
      } else {
        options = Arrays.copyOf(options, options.length + 1);
        options[options.length - 1] = Options.clientContext(clientContext);
      }
    }
    return options;
  }

  private ResultSet internalExecuteQuery(
      final CallType callType,
      final ParsedStatement statement,
      final AnalyzeMode analyzeMode,
      final QueryOption... options) {
    Preconditions.checkArgument(
        statement.getType() == StatementType.QUERY
            || (statement.getType() == StatementType.UPDATE
                && (analyzeMode != AnalyzeMode.NONE || statement.hasReturningClause())),
        "Statement must either be a query or a DML mode with analyzeMode!=NONE or returning"
            + " clause");
    boolean isInternalMetadataQuery = isInternalMetadataQuery(options);
    QueryOption[] combinedOptions = concat(statement.getOptionsFromHints(), options);
    UnitOfWork transaction =
        getCurrentUnitOfWorkOrStartNewUnitOfWork(statement, isInternalMetadataQuery);
    if (isAutoPartitionMode()
        && statement.getType() == StatementType.QUERY
        && !isInternalMetadataQuery) {
      return runPartitionedQuery(
          statement.getStatement(), PartitionOptions.getDefaultInstance(), combinedOptions);
    }
    return get(
        transaction.executeQueryAsync(
            callType,
            statement,
            analyzeMode,
            mergeQueryRequestOptions(statement, mergeQueryStatementTag(combinedOptions))));
  }

  private AsyncResultSet internalExecuteQueryAsync(
      final CallType callType,
      final ParsedStatement statement,
      final AnalyzeMode analyzeMode,
      final QueryOption... options) {
    Preconditions.checkArgument(
        (statement.getType() == StatementType.QUERY)
            || (statement.getType() == StatementType.UPDATE && statement.hasReturningClause()),
        "Statement must be a query or DML with returning clause.");
    ConnectionPreconditions.checkState(
        !(isAutoPartitionMode() && statement.getType() == StatementType.QUERY),
        "Partitioned queries cannot be executed asynchronously");
    boolean isInternalMetadataQuery = isInternalMetadataQuery(options);
    QueryOption[] combinedOptions = concat(statement.getOptionsFromHints(), options);
    UnitOfWork transaction =
        getCurrentUnitOfWorkOrStartNewUnitOfWork(statement, isInternalMetadataQuery);
    return ResultSets.toAsyncResultSet(
        transaction.executeQueryAsync(
            callType,
            statement,
            analyzeMode,
            mergeQueryRequestOptions(statement, mergeQueryStatementTag(combinedOptions))),
        spanner.getAsyncExecutorProvider(),
        combinedOptions);
  }

  private ApiFuture<Long> internalExecuteUpdateAsync(
      final CallType callType, final ParsedStatement update, UpdateOption... options) {
    Preconditions.checkArgument(
        update.getType() == StatementType.UPDATE, "Statement must be an update");
    UpdateOption[] combinedOptions = concat(update.getOptionsFromHints(), options);
    UnitOfWork transaction =
        maybeStartAutoDmlBatch(getCurrentUnitOfWorkOrStartNewUnitOfWork(update));
    return transaction.executeUpdateAsync(
        callType, update, mergeUpdateRequestOptions(mergeUpdateStatementTag(combinedOptions)));
  }

  private ApiFuture<ResultSet> internalAnalyzeUpdateAsync(
      final CallType callType,
      final ParsedStatement update,
      AnalyzeMode analyzeMode,
      UpdateOption... options) {
    Preconditions.checkArgument(
        update.getType() == StatementType.UPDATE, "Statement must be an update");
    UpdateOption[] combinedOptions = concat(update.getOptionsFromHints(), options);
    UnitOfWork transaction = getCurrentUnitOfWorkOrStartNewUnitOfWork(update);
    return transaction.analyzeUpdateAsync(
        callType,
        update,
        analyzeMode,
        mergeUpdateRequestOptions(mergeUpdateStatementTag(combinedOptions)));
  }

  private ApiFuture<long[]> internalExecuteBatchUpdateAsync(
      CallType callType, List<ParsedStatement> updates, UpdateOption... options) {
    UpdateOption[] combinedOptions =
        updates.isEmpty() ? options : concat(updates.get(0).getOptionsFromHints(), options);
    UnitOfWork transaction =
        maybeStartAutoDmlBatch(getCurrentUnitOfWorkOrStartNewUnitOfWork(updates.get(0)));
    return transaction.executeBatchUpdateAsync(
        callType, updates, mergeUpdateRequestOptions(mergeUpdateStatementTag(combinedOptions)));
  }

  private UnitOfWork maybeStartAutoDmlBatch(UnitOfWork transaction) {
    if (isInTransaction() && isAutoBatchDml() && !(transaction instanceof DmlBatch)) {
      // Automatically start a DML batch.
      return startBatchDml(/* autoBatch= */ true);
    }
    return transaction;
  }

  UnitOfWork getCurrentUnitOfWorkOrStartNewUnitOfWork() {
    return getCurrentUnitOfWorkOrStartNewUnitOfWork(
        StatementType.UNKNOWN, /* parsedStatement= */ null, /* internalMetadataQuery= */ false);
  }

  private UnitOfWork getCurrentUnitOfWorkOrStartNewUnitOfWork(
      @Nonnull ParsedStatement parsedStatement) {
    return getCurrentUnitOfWorkOrStartNewUnitOfWork(
        parsedStatement.getType(), parsedStatement, /* internalMetadataQuery= */ false);
  }

  @VisibleForTesting
  UnitOfWork getCurrentUnitOfWorkOrStartNewUnitOfWork(
      @Nonnull ParsedStatement parsedStatement, boolean isInternalMetadataQuery) {
    return getCurrentUnitOfWorkOrStartNewUnitOfWork(
        parsedStatement.getType(), parsedStatement, isInternalMetadataQuery);
  }

  private UnitOfWork getOrStartDdlUnitOfWork(ParsedStatement parsedStatement) {
    return getCurrentUnitOfWorkOrStartNewUnitOfWork(StatementType.DDL, parsedStatement, false);
  }

  /**
   * Returns the current {@link UnitOfWork} of this connection, or creates a new one based on the
   * current transaction settings of the connection and returns that.
   */
  @VisibleForTesting
  UnitOfWork getCurrentUnitOfWorkOrStartNewUnitOfWork(
      StatementType statementType,
      @Nullable ParsedStatement parsedStatement,
      boolean isInternalMetadataQuery) {
    if (isInternalMetadataQuery) {
      // Just return a temporary single-use transaction.
      return createNewUnitOfWork(
          /* isInternalMetadataQuery= */ true,
          /* forceSingleUse= */ true,
          /* autoBatchDml= */ false);
    }
    maybeAutoCommitOrFlushCurrentUnitOfWork(statementType, parsedStatement);
    if (this.currentUnitOfWork == null || !this.currentUnitOfWork.isActive()) {
      this.currentUnitOfWork =
          createNewUnitOfWork(
              /* isInternalMetadataQuery= */ false,
              /* forceSingleUse= */ statementType == StatementType.DDL
                  && getDdlInTransactionMode() != DdlInTransactionMode.FAIL
                  && !this.transactionBeginMarked,
              /* autoBatchDml= */ false,
              statementType);
    }
    return this.currentUnitOfWork;
  }

  private Span createSpanForUnitOfWork(String name) {
    return tracer
        .spanBuilder(
            // We can memoize this, as it is a STARTUP property.
            Suppliers.memoize(() -> this.connectionState.getValue(TRACING_PREFIX).getValue()).get()
                + "."
                + name)
        .setAllAttributes(getOpenTelemetryAttributes())
        .startSpan();
  }

  void maybeAutoCommitOrFlushCurrentUnitOfWork(
      StatementType statementType, @Nullable ParsedStatement parsedStatement) {
    if (this.currentUnitOfWork instanceof ReadWriteTransaction
        && this.currentUnitOfWork.isActive()
        && statementType == StatementType.DDL
        && getDdlInTransactionMode() == DdlInTransactionMode.AUTO_COMMIT_TRANSACTION) {
      commit();
    } else {
      maybeFlushAutoDmlBatch(parsedStatement);
    }
  }

  private void maybeFlushAutoDmlBatch(@Nullable ParsedStatement parsedStatement) {
    if (parsedStatement == null) {
      return;
    }
    if (this.currentUnitOfWork instanceof DmlBatch && this.currentUnitOfWork.isActive()) {
      DmlBatch batch = (DmlBatch) this.currentUnitOfWork;
      if (batch.isAutoBatch()) {
        if (parsedStatement == ROLLBACK_STATEMENT
            || (parsedStatement == ROLLBACK_TO_STATEMENT
                && getSavepointSupport() == SavepointSupport.ENABLED)) {
          // Just abort the batch if the transaction is about to be rolled back.
          abortBatch();
        } else if (!parsedStatement.isUpdate() || parsedStatement.hasReturningClause()) {
          // The statement that is about to be executed cannot be executed in a DML batch.
          // Flush the current batch and then executed the statement.
          runBatch();
        }
      }
    }
  }

  @VisibleForTesting
  UnitOfWork createNewUnitOfWork(
      boolean isInternalMetadataQuery, boolean forceSingleUse, boolean autoBatchDml) {
    return createNewUnitOfWork(isInternalMetadataQuery, forceSingleUse, autoBatchDml, null);
  }

  @VisibleForTesting
  UnitOfWork createNewUnitOfWork(
      boolean isInternalMetadataQuery,
      boolean forceSingleUse,
      boolean autoBatchDml,
      StatementType statementType) {
    if (isInternalMetadataQuery
        || (isAutocommit() && !isInTransaction() && !isInBatch())
        || forceSingleUse) {
      SingleUseTransaction singleUseTransaction =
          SingleUseTransaction.newBuilder()
              .setInternalMetadataQuery(isInternalMetadataQuery)
              .setDdlClient(ddlClient)
              .setDatabaseClient(dbClient)
              .setBatchClient(batchClient)
              .setConnectionState(connectionState)
              .setTransactionRetryListeners(transactionRetryListeners)
              .setExcludeTxnFromChangeStreams(excludeTxnFromChangeStreams)
              .setStatementTimeout(statementTimeout)
              .withStatementExecutor(statementExecutor)
              .setSpan(
                  createSpanForUnitOfWork(
                      statementType == StatementType.DDL ? DDL_STATEMENT : SINGLE_USE_TRANSACTION))
              .setProtoDescriptors(getProtoDescriptors())
              .setClientContext(clientContext)
              .build();
      if (!isInternalMetadataQuery && !forceSingleUse) {
        // Reset the transaction options after starting a single-use transaction.
        setDefaultTransactionOptions(getDefaultIsolationLevel());
      }
      return singleUseTransaction;
    } else {
      switch (getUnitOfWorkType()) {
        case READ_ONLY_TRANSACTION:
          return ReadOnlyTransaction.newBuilder()
              .setDatabaseClient(dbClient)
              .setBatchClient(batchClient)
              .setReadOnlyStaleness(getConnectionPropertyValue(READ_ONLY_STALENESS))
              .setStatementTimeout(statementTimeout)
              .withStatementExecutor(statementExecutor)
              .setTransactionTag(transactionTag)
              .setRpcPriority(getConnectionPropertyValue(RPC_PRIORITY))
              .setSpan(createSpanForUnitOfWork(READ_ONLY_TRANSACTION))
              .setClientContext(clientContext)
              .build();
        case READ_WRITE_TRANSACTION:
          return ReadWriteTransaction.newBuilder()
              .setUsesEmulator(options.usesEmulator())
              .setUseAutoSavepointsForEmulator(options.useAutoSavepointsForEmulator())
              .setDatabaseClient(dbClient)
              .setIsolationLevel(transactionIsolationLevel)
              .setReadLockMode(getConnectionPropertyValue(READ_LOCK_MODE))
              .setDeadline(getTransactionDeadline())
              .setDelayTransactionStartUntilFirstWrite(
                  getConnectionPropertyValue(DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE))
              .setKeepTransactionAlive(getConnectionPropertyValue(KEEP_TRANSACTION_ALIVE))
              .setRetryAbortsInternally(getConnectionPropertyValue(RETRY_ABORTS_INTERNALLY))
              .setSavepointSupport(getConnectionPropertyValue(SAVEPOINT_SUPPORT))
              .setReturnCommitStats(getConnectionPropertyValue(RETURN_COMMIT_STATS))
              .setMaxCommitDelay(getConnectionPropertyValue(MAX_COMMIT_DELAY))
              .setTransactionRetryListeners(transactionRetryListeners)
              .setStatementTimeout(statementTimeout)
              .withStatementExecutor(statementExecutor)
              .setTransactionTag(transactionTag)
              .setExcludeTxnFromChangeStreams(excludeTxnFromChangeStreams)
              .setRpcPriority(getConnectionPropertyValue(RPC_PRIORITY))
              .setSpan(createSpanForUnitOfWork(READ_WRITE_TRANSACTION))
              .setClientContext(clientContext)
              .build();
        case DML_BATCH:
          // A DML batch can run inside the current transaction. It should therefore only
          // temporarily replace the current transaction.
          pushCurrentUnitOfWorkToTransactionStack();
          return DmlBatch.newBuilder()
              .setAutoBatch(autoBatchDml)
              .setAutoBatchUpdateCountSupplier(this::getAutoBatchDmlUpdateCount)
              .setAutoBatchUpdateCountVerificationSupplier(
                  this::isAutoBatchDmlUpdateCountVerification)
              .setDmlBatchUpdateCountSupplier(this::getDmlBatchUpdateCount)
              .setTransaction(currentUnitOfWork)
              .setStatementTimeout(statementTimeout)
              .withStatementExecutor(statementExecutor)
              .setStatementTag(statementTag)
              .setExcludeTxnFromChangeStreams(excludeTxnFromChangeStreams)
              .setRpcPriority(getConnectionPropertyValue(RPC_PRIORITY))
              // Use the transaction Span for the DML batch.
              .setSpan(transactionStack.peek().getSpan())
              .setClientContext(clientContext)
              .build();
        case DDL_BATCH:
          return DdlBatch.newBuilder()
              .setDdlClient(ddlClient)
              .setDatabaseClient(dbClient)
              .setStatementTimeout(statementTimeout)
              .withStatementExecutor(statementExecutor)
              .setSpan(createSpanForUnitOfWork(DDL_BATCH))
              .setProtoDescriptors(getProtoDescriptors())
              .setConnectionState(connectionState)
              .setClientContext(clientContext)
              .build();
        default:
      }
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION,
        "This connection does not have an active transaction and the state of this connection does"
            + " not allow any new transactions to be started");
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

  private ApiFuture<Void> executeDdlAsync(CallType callType, ParsedStatement ddl) {
    ApiFuture<Void> result = getOrStartDdlUnitOfWork(ddl).executeDdlAsync(callType, ddl);
    // reset proto descriptors after executing a DDL statement
    this.protoDescriptors = null;
    this.protoDescriptorsFilePath = null;
    return result;
  }

  @Override
  public void write(Mutation mutation) {
    get(writeAsync(Collections.singleton(Preconditions.checkNotNull(mutation))));
  }

  @Override
  public ApiFuture<Void> writeAsync(Mutation mutation) {
    return writeAsync(Collections.singleton(Preconditions.checkNotNull(mutation)));
  }

  @Override
  public void write(Iterable<Mutation> mutations) {
    get(writeAsync(Preconditions.checkNotNull(mutations)));
  }

  @Override
  public ApiFuture<Void> writeAsync(Iterable<Mutation> mutations) {
    Preconditions.checkNotNull(mutations);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(isAutocommit(), ONLY_ALLOWED_IN_AUTOCOMMIT);
    return getCurrentUnitOfWorkOrStartNewUnitOfWork().writeAsync(CallType.ASYNC, mutations);
  }

  @Override
  public void bufferedWrite(Mutation mutation) {
    bufferedWrite(Preconditions.checkNotNull(Collections.singleton(mutation)));
  }

  @Override
  public void bufferedWrite(Iterable<Mutation> mutations) {
    Preconditions.checkNotNull(mutations);
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(!isAutocommit(), NOT_ALLOWED_IN_AUTOCOMMIT);
    get(getCurrentUnitOfWorkOrStartNewUnitOfWork().writeAsync(CallType.SYNC, mutations));
  }

  @Override
  public void startBatchDdl() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(
        !isBatchActive(), "Cannot start a DDL batch when a batch is already active");
    ConnectionPreconditions.checkState(
        !isReadOnly(), "Cannot start a DDL batch when the connection is in read-only mode");
    ConnectionPreconditions.checkState(
        !isTransactionStarted()
            || getDdlInTransactionMode() == DdlInTransactionMode.AUTO_COMMIT_TRANSACTION,
        "Cannot start a DDL batch while a transaction is active");
    ConnectionPreconditions.checkState(
        !(isAutocommit() && isInTransaction()),
        "Cannot start a DDL batch while in a temporary transaction");
    ConnectionPreconditions.checkState(
        !transactionBeginMarked, "Cannot start a DDL batch when a transaction has begun");
    ConnectionPreconditions.checkState(
        isAutocommit() || getDdlInTransactionMode() != DdlInTransactionMode.FAIL,
        "Cannot start a DDL batch when autocommit=false and ddlInTransactionMode=FAIL");

    maybeAutoCommitOrFlushCurrentUnitOfWork(StatementType.DDL, START_BATCH_DDL_STATEMENT);
    this.batchMode = BatchMode.DDL;
    this.unitOfWorkType = UnitOfWorkType.DDL_BATCH;
    this.currentUnitOfWork =
        createNewUnitOfWork(
            /* isInternalMetadataQuery= */ false,
            /* forceSingleUse= */ false,
            /* autoBatchDml= */ false);
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
    startBatchDml(/* autoBatch= */ false);
  }

  private UnitOfWork startBatchDml(boolean autoBatch) {
    // Make sure that there is a current unit of work that the batch can use.
    getCurrentUnitOfWorkOrStartNewUnitOfWork(START_BATCH_DML_STATEMENT);
    // Then create the DML batch.
    this.batchMode = BatchMode.DML;
    this.unitOfWorkType = UnitOfWorkType.DML_BATCH;
    return this.currentUnitOfWork =
        createNewUnitOfWork(
            /* isInternalMetadataQuery= */ false, /* forceSingleUse= */ false, autoBatch);
  }

  @Override
  public long[] runBatch() {
    return get(runBatchAsync());
  }

  @Override
  public ApiFuture<long[]> runBatchAsync() {
    ConnectionPreconditions.checkState(!isClosed(), CLOSED_ERROR_MSG);
    ConnectionPreconditions.checkState(isBatchActive(), "This connection has no active batch");
    try {
      if (this.currentUnitOfWork != null) {
        return this.currentUnitOfWork.runBatchAsync(CallType.ASYNC);
      }
      return ApiFutures.immediateFuture(new long[0]);
    } finally {
      if (isDdlBatchActive()) {
        // reset proto descriptors after executing a DDL batch
        this.protoDescriptors = null;
        this.protoDescriptorsFilePath = null;
      }
      this.batchMode = BatchMode.NONE;
      setDefaultTransactionOptions(getDefaultIsolationLevel());
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
      setDefaultTransactionOptions(getDefaultIsolationLevel());
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
