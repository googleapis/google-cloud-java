/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.executor.spanner;

import static com.google.cloud.spanner.TransactionRunner.TransactionCallable;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.Page;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnavailableException;
import com.google.auth.Credentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.NoCredentials;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Backup;
import com.google.cloud.spanner.BatchClient;
import com.google.cloud.spanner.BatchReadOnlyTransaction;
import com.google.cloud.spanner.BatchTransactionId;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Instance;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceConfig;
import com.google.cloud.spanner.InstanceConfigId;
import com.google.cloud.spanner.InstanceConfigInfo;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.InstanceInfo;
import com.google.cloud.spanner.Interval;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeyRange;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Mutation.WriteBuilder;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Options.RpcPriority;
import com.google.cloud.spanner.Partition;
import com.google.cloud.spanner.PartitionOptions;
import com.google.cloud.spanner.ReadContext;
import com.google.cloud.spanner.ReadOnlyTransaction;
import com.google.cloud.spanner.ReplicaInfo;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SessionPoolOptionsHelper;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.StructReader;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionRunner;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.encryption.CustomerManagedEncryption;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
import com.google.cloud.trace.v1.TraceServiceClient;
import com.google.cloud.trace.v1.TraceServiceSettings;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.devtools.cloudtrace.v1.GetTraceRequest;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.devtools.cloudtrace.v1.TraceSpan;
import com.google.longrunning.Operation;
import com.google.protobuf.ByteString;
import com.google.protobuf.util.Timestamps;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.instance.v1.Instance.State;
import com.google.spanner.executor.v1.AdminAction;
import com.google.spanner.executor.v1.AdminResult;
import com.google.spanner.executor.v1.BatchDmlAction;
import com.google.spanner.executor.v1.BatchPartition;
import com.google.spanner.executor.v1.CancelOperationAction;
import com.google.spanner.executor.v1.ChangeStreamRecord;
import com.google.spanner.executor.v1.ChildPartitionsRecord;
import com.google.spanner.executor.v1.CloseBatchTransactionAction;
import com.google.spanner.executor.v1.CloudBackupResponse;
import com.google.spanner.executor.v1.CloudDatabaseResponse;
import com.google.spanner.executor.v1.CloudInstanceConfigResponse;
import com.google.spanner.executor.v1.CloudInstanceResponse;
import com.google.spanner.executor.v1.Concurrency;
import com.google.spanner.executor.v1.CopyCloudBackupAction;
import com.google.spanner.executor.v1.CreateCloudBackupAction;
import com.google.spanner.executor.v1.CreateCloudDatabaseAction;
import com.google.spanner.executor.v1.CreateCloudInstanceAction;
import com.google.spanner.executor.v1.CreateUserInstanceConfigAction;
import com.google.spanner.executor.v1.DataChangeRecord;
import com.google.spanner.executor.v1.DeleteCloudBackupAction;
import com.google.spanner.executor.v1.DeleteCloudInstanceAction;
import com.google.spanner.executor.v1.DeleteUserInstanceConfigAction;
import com.google.spanner.executor.v1.DmlAction;
import com.google.spanner.executor.v1.DropCloudDatabaseAction;
import com.google.spanner.executor.v1.ExecuteChangeStreamQuery;
import com.google.spanner.executor.v1.ExecutePartitionAction;
import com.google.spanner.executor.v1.FinishTransactionAction;
import com.google.spanner.executor.v1.FinishTransactionAction.Mode;
import com.google.spanner.executor.v1.GenerateDbPartitionsForQueryAction;
import com.google.spanner.executor.v1.GenerateDbPartitionsForReadAction;
import com.google.spanner.executor.v1.GetCloudBackupAction;
import com.google.spanner.executor.v1.GetCloudDatabaseAction;
import com.google.spanner.executor.v1.GetCloudInstanceAction;
import com.google.spanner.executor.v1.GetCloudInstanceConfigAction;
import com.google.spanner.executor.v1.GetOperationAction;
import com.google.spanner.executor.v1.HeartbeatRecord;
import com.google.spanner.executor.v1.ListCloudBackupOperationsAction;
import com.google.spanner.executor.v1.ListCloudBackupsAction;
import com.google.spanner.executor.v1.ListCloudDatabaseOperationsAction;
import com.google.spanner.executor.v1.ListCloudDatabasesAction;
import com.google.spanner.executor.v1.ListCloudInstanceConfigsAction;
import com.google.spanner.executor.v1.ListCloudInstancesAction;
import com.google.spanner.executor.v1.MutationAction;
import com.google.spanner.executor.v1.MutationAction.InsertArgs;
import com.google.spanner.executor.v1.MutationAction.Mod;
import com.google.spanner.executor.v1.MutationAction.UpdateArgs;
import com.google.spanner.executor.v1.OperationResponse;
import com.google.spanner.executor.v1.PartitionedUpdateAction;
import com.google.spanner.executor.v1.PartitionedUpdateAction.ExecutePartitionedUpdateOptions;
import com.google.spanner.executor.v1.QueryAction;
import com.google.spanner.executor.v1.ReadAction;
import com.google.spanner.executor.v1.RestoreCloudDatabaseAction;
import com.google.spanner.executor.v1.SessionPoolOptions;
import com.google.spanner.executor.v1.SpannerAction;
import com.google.spanner.executor.v1.SpannerActionOutcome;
import com.google.spanner.executor.v1.SpannerAsyncActionRequest;
import com.google.spanner.executor.v1.SpannerAsyncActionResponse;
import com.google.spanner.executor.v1.StartBatchTransactionAction;
import com.google.spanner.executor.v1.StartTransactionAction;
import com.google.spanner.executor.v1.TransactionExecutionOptions;
import com.google.spanner.executor.v1.UpdateCloudBackupAction;
import com.google.spanner.executor.v1.UpdateCloudDatabaseDdlAction;
import com.google.spanner.executor.v1.UpdateCloudInstanceAction;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.TypeAnnotationCode;
import com.google.spanner.v1.TypeCode;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.io.FileUtils;

/**
 * Implementation of the SpannerExecutorProxy gRPC service that proxies action request through the
 * Java Cloud Client.
 */
public class CloudClientExecutor extends CloudExecutor {

  private static final Logger LOGGER = Logger.getLogger(CloudClientExecutor.class.getName());

  // Prefix for host address.
  private static final String HOST_PREFIX = "https://localhost:";

  public CloudClientExecutor(boolean enableGrpcFaultInjector) {
    this.enableGrpcFaultInjector = enableGrpcFaultInjector;
  }

  // Helper for unexpected results.
  public static String unexpectedExceptionResponse(Exception e) {
    return "Unexpected error in Github Cloud Java Client Executor: "
        + e
        + " Msg: "
        + e.getMessage()
        + " Stack: "
        + Joiner.on("\n").join(e.getStackTrace());
  }

  /**
   * Implementation of a ReadWriteTransaction, which is a wrapper of the cloud TransactionRunner. It
   * stores all the status and related variables from the start to finish, and control the running
   * flow of this transaction.
   *
   * <p>The following functions should be called on this struct externally:
   *
   * <p>startRWTransaction() initializes a transaction. It creates a callable and runs it with a
   * ReadWriteTransaction() runner in a separate thread. That callable will accept a
   * transactionContext when created, and we will pass it out to execute actions on it. Then the
   * callable will be blocked until we need to exit (e.g. commit) the transaction.
   *
   * <p>getContext() returns the current ReadWriteTransaction context. Reads and writes can be
   * performed on that object.
   *
   * <p>finish() is used to either commit or abandon the transaction. It gets a finishMode from
   * finishAction and essentially unblocks the separate callable thread that's waiting inside
   * ReadWriteTransaction(). As a result of this call, Spanner will commit the current transaction,
   * abandon it without committing, or restart it, in which case the client should get a new
   * transaction instance using getContext() and replay all the reads and writes through it.
   *
   * <p>Here's a typical workflow for how a read-write transaction works.
   *
   * <p>When we call startRWTransaction, a transaction runner will be started in another thread with
   * a callable that stores the passed TransactionContext into the ReadWriteTransaction and blocks.
   * This TransactionContext is used to run the read/write actions. To execute the finish action, we
   * store the FinishMode in the ReadWriteTransaction object, which unblocks the thread in the
   * callable and causes the callable to either return (to commit) or throw an exception (to abort).
   * If the underlying Spanner transaction aborted, the transaction runner will invoke the callable
   * again.
   */
  private static class ReadWriteTransaction {
    private final DatabaseClient dbClient;
    private TransactionRunner runner;
    private TransactionContext txnContext;
    private com.google.protobuf.Timestamp timestamp;
    private Mode finishMode;
    private SpannerException error;
    private final String transactionSeed;
    private final boolean optimistic;
    // Set to true when the transaction runner completed, one of these three could happen: runner
    // committed, abandoned or threw an error.
    private boolean runnerCompleted;

    public ReadWriteTransaction(
        DatabaseClient dbClient, String transactionSeed, boolean optimistic) {
      this.dbClient = dbClient;
      this.transactionSeed = transactionSeed;
      this.optimistic = optimistic;
      this.runnerCompleted = false;
    }

    /** Set context to be used for executing actions. */
    private synchronized void setContext(TransactionContext transaction) {
      finishMode = null;
      txnContext = transaction;
      Preconditions.checkNotNull(txnContext);
      LOGGER.log(Level.INFO, "Transaction callable created, setting context %s\n", transactionSeed);
      notifyAll();
    }

    /** Wait for finishAction to be executed and return the requested finish mode. */
    private synchronized Mode waitForFinishAction() throws Exception {
      while (finishMode == null) {
        wait();
      }
      return finishMode;
    }

    /** Wait for transactionContext to be set. */
    private synchronized void waitForTransactionContext() throws Exception {
      while (txnContext == null && error == null) {
        wait();
      }
      if (error != null) {
        throw error;
      }
    }

    /** Transaction successfully committed with a timestamp. */
    private synchronized void transactionSucceeded(com.google.protobuf.Timestamp timestamp) {
      this.timestamp = timestamp;
      this.runnerCompleted = true;
      notifyAll();
    }

    /** Transaction failed to commit, maybe abandoned or other errors occurred. */
    private synchronized void transactionFailed(SpannerException e) {
      // Handle abandon case
      if (e.getErrorCode() == ErrorCode.UNKNOWN && e.getMessage().contains(TRANSACTION_ABANDONED)) {
        LOGGER.log(Level.INFO, "Transaction abandoned");
      } else {
        // Store the error for sending back
        error = e;
      }
      this.runnerCompleted = true;
      notifyAll();
    }

    /** Return the commit timestamp. */
    public synchronized com.google.protobuf.Timestamp getTimestamp() {
      return timestamp;
    }

    /** Return the transactionContext to run actions. Must be called after start action. */
    public synchronized TransactionContext getContext() {
      Preconditions.checkState(txnContext != null);
      return txnContext;
    }

    /**
     * Create a new transaction runner and corresponding transaction callable to start a read-write
     * transaction.
     */
    public void startRWTransaction() throws Exception {
      final TransactionCallable<Void> callable =
          transaction -> {
            setContext(transaction);
            LOGGER.log(
                Level.INFO,
                String.format(
                    "Transaction context set, executing and waiting for finish %s\n",
                    transactionSeed));
            Mode mode = waitForFinishAction();
            if (mode == Mode.ABANDON) {
              throw new Exception(TRANSACTION_ABANDONED);
            }
            // Try to commit
            return null;
          };
      io.opentelemetry.context.Context context = io.opentelemetry.context.Context.current();
      Runnable runnable =
          context.wrap(
              () -> {
                try {
                  runner =
                      optimistic
                          ? dbClient.readWriteTransaction(Options.optimisticLock())
                          : dbClient.readWriteTransaction();
                  LOGGER.log(
                      Level.INFO, String.format("Ready to run callable %s\n", transactionSeed));
                  runner.run(callable);
                  transactionSucceeded(runner.getCommitTimestamp().toProto());
                } catch (SpannerException e) {
                  LOGGER.log(
                      Level.WARNING,
                      String.format(
                          "Transaction runnable failed with exception %s\n", e.getMessage()),
                      e);
                  transactionFailed(e);
                }
              });
      LOGGER.log(
          Level.INFO,
          String.format("Callable and Runnable created, ready to execute %s\n", transactionSeed));
      txnThreadPool.execute(runnable);
      waitForTransactionContext();
      LOGGER.log(
          Level.INFO,
          String.format("Transaction successfully created and running %s\n", transactionSeed));
    }

    /**
     * Finish current transaction in given finishMode, if failed, throw the exception back to
     * caller. Returns true if the transaction completed (i.e., committed), false if it was
     * restarted by the transaction runner.
     */
    public synchronized boolean finish(Mode finishMode) throws Exception {
      switch (finishMode) {
        case COMMIT:
        case ABANDON:
          // Signal that finish action has been called and finishMode has been set.
          this.finishMode = finishMode;
          Preconditions.checkNotNull(finishMode);
          txnContext = null;
          LOGGER.log(
              Level.INFO,
              String.format(
                  "TxnContext cleared, sending finishMode to finish transaction %s\n",
                  transactionSeed));
          notifyAll();
          // Wait for the transaction to finish or restart
          while (txnContext == null && !runnerCompleted) {
            wait();
          }
          LOGGER.log(
              Level.INFO,
              String.format("Transaction finished, getting back to caller %s\n", transactionSeed));
          if (txnContext != null) {
            // Transaction restarted
            return false;
          } else if (error != null) {
            // Transaction runner threw an exception: re-throw it to the client.
            // Filter expected errors
            if (error.getErrorCode() == ErrorCode.UNKNOWN
                && error.getMessage().contains("Transaction outcome unknown")) {
              throw SpannerExceptionFactory.newSpannerException(
                  ErrorCode.DEADLINE_EXCEEDED, "Transaction outcome unknown.");
            } else {
              throw error;
            }
          }
          // Transaction successfully completed
          return true;
        default:
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT, "Unsupported finish mode: " + finishMode);
      }
    }
  }

  /**
   * All the context in which SpannerActions are executed. It stores the current running transaction
   * and table metadata, shared by all the action executor and protected by a lock. There will only
   * be exactly one instance of this class per stubby call, created when the executor is
   * initialized.
   */
  class ExecutionFlowContext {
    // Database path from previous action
    private String prevDbPath;
    // Current read-write transaction
    private ReadWriteTransaction rwTxn;
    // Current read-only transaction
    private ReadOnlyTransaction roTxn;
    // Current batch read-only transaction
    private BatchReadOnlyTransaction batchTxn;
    // Current database client
    private DatabaseClient dbClient;
    // Metadata info about table columns
    private Metadata metadata;
    // Number of pending read/query actions.
    private int numPendingReads;
    // Indicate whether there's a read/query action got aborted and the transaction need to be
    // reset.
    private boolean readAborted;
    // Log the workid and op pair for tracing the thread.
    private String transactionSeed;
    // Outgoing stream.
    StreamObserver<SpannerAsyncActionResponse> responseObserver;

    public ExecutionFlowContext(StreamObserver<SpannerAsyncActionResponse> responseObserver) {
      this.responseObserver = responseObserver;
    }

    /** Call the underlying stream to send response. */
    public synchronized void onNext(SpannerAsyncActionResponse response) {
      responseObserver.onNext(response);
    }

    /** Call the underlying stream to send error. */
    public synchronized void onError(Throwable t) {
      responseObserver.onError(t);
    }

    /** Return current transaction that can used for performing read/query actions. */
    public synchronized ReadContext getTransactionForRead() throws SpannerException {
      if (roTxn != null) {
        return roTxn;
      }
      if (rwTxn != null) {
        return rwTxn.getContext();
      }
      if (batchTxn != null) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "Can't execute regular read in a batch transaction");
      }
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT, "No active transaction");
    }

    /** Return current transaction that can used for performing mutation/update actions. */
    public synchronized TransactionContext getTransactionForWrite() throws SpannerException {
      if (rwTxn == null) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "Not in a read-write transaction");
      }
      return rwTxn.getContext();
    }

    /** Return current batch transaction if it exists. */
    public synchronized BatchReadOnlyTransaction getBatchTxn() throws SpannerException {
      if (batchTxn == null) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "Not in a batch transaction");
      }
      return batchTxn;
    }

    /** Set the transactionSeed string retrieved from startTransactionAction. */
    public synchronized void updateTransactionSeed(String transactionSeed) {
      if (!transactionSeed.isEmpty()) {
        this.transactionSeed = transactionSeed;
      }
    }

    /** Return current workid and op pair for logging. */
    public synchronized String getTransactionSeed() {
      return transactionSeed;
    }

    /** Return current database client. */
    public DatabaseClient getDbClient() {
      return dbClient;
    }

    /** Clear the transaction related variables. */
    public synchronized void clear() {
      rwTxn = null;
      roTxn = null;
      metadata = null;
    }

    /** Cleanup all the active transactions if the stubby call is closing. */
    public synchronized void cleanup() {
      if (roTxn != null) {
        LOGGER.log(Level.INFO, "A read only transaction was active when stubby call closed");
        roTxn.close();
      }
      if (rwTxn != null) {
        LOGGER.log(Level.INFO, "A read write transaction was active when stubby call closed");
        try {
          rwTxn.finish(Mode.ABANDON);
        } catch (Exception e) {
          LOGGER.log(
              Level.WARNING, "Failed to abandon a read-write transaction: " + e.getMessage());
        }
      }
    }

    /** Return previous databasePath if given dbPath is empty, then update. */
    public synchronized String getDatabasePath(String dbPath) {
      if (dbPath == null || dbPath.isEmpty()) {
        return prevDbPath;
      }
      prevDbPath = dbPath;
      return dbPath;
    }

    /** Set the metadata for future use. */
    public synchronized void setMetadata(Metadata metadata) {
      this.metadata = metadata;
    }

    /** Start a read-only transaction. */
    public synchronized void startReadOnlyTxn(
        DatabaseClient dbClient, TimestampBound timestampBound, Metadata metadata) {
      if ((rwTxn != null) || (roTxn != null) || (batchTxn != null)) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "Already in a transaction");
      }
      this.metadata = metadata;
      if (timestampBound.getMode() == TimestampBound.Mode.MIN_READ_TIMESTAMP
          || timestampBound.getMode() == TimestampBound.Mode.MAX_STALENESS) {
        roTxn = dbClient.singleUseReadOnlyTransaction(timestampBound);
      } else {
        roTxn = dbClient.readOnlyTransaction(timestampBound);
      }
    }

    /** Start a read-write transaction. */
    public synchronized void startReadWriteTxn(
        DatabaseClient dbClient, Metadata metadata, TransactionExecutionOptions options)
        throws Exception {
      if ((rwTxn != null) || (roTxn != null) || (batchTxn != null)) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "Already in a transaction");
      }
      LOGGER.log(
          Level.INFO,
          String.format(
              "There's no active transaction, safe to create rwTxn: %s\n", getTransactionSeed()));
      this.metadata = metadata;
      rwTxn = new ReadWriteTransaction(dbClient, transactionSeed, options.getOptimistic());
      LOGGER.log(
          Level.INFO,
          String.format(
              "Read-write transaction object created, try to start: %s\n", getTransactionSeed()));
      rwTxn.startRWTransaction();
    }

    /** Start a batch transaction. */
    public synchronized Status startBatchTxn(
        StartBatchTransactionAction action, BatchClient batchClient, OutcomeSender sender) {
      try {
        if ((rwTxn != null) || (roTxn != null) || (batchTxn != null)) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT, "Already in a transaction");
        }

        if (action.hasBatchTxnTime()) {
          TimestampBound timestampBound =
              TimestampBound.ofReadTimestamp(Timestamp.fromProto(action.getBatchTxnTime()));
          batchTxn = batchClient.batchReadOnlyTransaction(timestampBound);
        } else if (action.hasTid()) {
          BatchTransactionId tId = unmarshall(action.getTid());
          batchTxn = batchClient.batchReadOnlyTransaction(tId);
        } else {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT, "Either timestamp or tid must be set");
        }
        SpannerActionOutcome outcome =
            SpannerActionOutcome.newBuilder()
                .setStatus(toProto(Status.OK))
                .setBatchTxnId(marshall(batchTxn.getBatchTransactionId()))
                .build();
        initReadState();
        return sender.sendOutcome(outcome);
      } catch (SpannerException e) {
        return sender.finishWithError(toStatus(e));
      } catch (Exception e) {
        LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
        return sender.finishWithError(
            toStatus(
                SpannerExceptionFactory.newSpannerException(
                    ErrorCode.INVALID_ARGUMENT,
                    CloudClientExecutor.unexpectedExceptionResponse(e))));
      }
    }

    /** Increase the read count when a read/query is issued. */
    public synchronized void startRead() {
      ++numPendingReads;
    }

    /**
     * Decrease the read count when a read/query is finished, if status is aborted and there's no
     * pending read/query, reset the transaction for retry.
     */
    public synchronized void finishRead(Status status) {
      if (status.getCode() == Status.ABORTED.getCode()) {
        readAborted = true;
      }
      --numPendingReads;
      if (readAborted && numPendingReads <= 0) {
        LOGGER.log(Level.FINE, "Transaction reset due to read/query abort");
        readAborted = false;
      }
    }

    /** Initialize the read count and aborted status when transaction started. */
    public synchronized void initReadState() {
      readAborted = false;
      numPendingReads = 0;
    }

    /** Store the reference to the database client for future action use. */
    public void setDatabaseClient(DatabaseClient client) {
      dbClient = client;
    }

    /** Return a list of key column types of the given table. */
    public List<com.google.spanner.v1.Type> getKeyColumnTypes(String tableName)
        throws SpannerException {
      Preconditions.checkNotNull(metadata);
      return metadata.getKeyColumnTypes(tableName);
    }

    /** Return column type of the given table and column. */
    public com.google.spanner.v1.Type getColumnType(String tableName, String columnName)
        throws SpannerException {
      Preconditions.checkNotNull(metadata);
      return metadata.getColumnType(tableName, columnName);
    }

    /** Buffer a list of mutations in a read-write transaction. */
    public synchronized void bufferMutations(List<Mutation> mutations) throws SpannerException {
      getTransactionForWrite().buffer(mutations);
    }

    /** Execute a batch of updates in a read-write transaction. */
    public synchronized long[] executeBatchDml(@Nonnull List<Statement> stmts)
        throws SpannerException {
      for (int i = 0; i < stmts.size(); i++) {
        LOGGER.log(
            Level.INFO, String.format("executeBatchDml [%d]: %s", i + 1, stmts.get(i).toString()));
      }
      return getTransactionForWrite()
          .batchUpdate(stmts, Options.tag("batch-update-transaction-tag"));
    }

    /** Finish active transaction in given finishMode, then send outcome back to client. */
    public synchronized Status finish(Mode finishMode, OutcomeSender sender) {
      if (numPendingReads > 0) {
        return sender.finishWithError(
            toStatus(
                SpannerExceptionFactory.newSpannerException(
                    ErrorCode.FAILED_PRECONDITION, "Reads pending when trying to finish")));
      }
      SpannerActionOutcome.Builder outcomeBuilder = SpannerActionOutcome.newBuilder();
      outcomeBuilder.setStatus(toProto(Status.OK));
      if (roTxn != null || rwTxn != null) {
        try {
          if (roTxn != null) {
            // read-only transaction
            Timestamp ts = roTxn.getReadTimestamp();
            outcomeBuilder.setCommitTime(ts.toProto());
            roTxn.close();
            clear();
          } else {
            // read-write transaction
            if (!rwTxn.finish(finishMode)) {
              LOGGER.log(Level.FINE, "Transaction restarted");
              outcomeBuilder.setTransactionRestarted(true);
            } else {
              LOGGER.log(Level.FINE, "Transaction finish successfully");
              if (rwTxn.getTimestamp() != null) {
                outcomeBuilder.setCommitTime(rwTxn.getTimestamp());
              }
              clear();
            }
          }
        } catch (SpannerException e) {
          outcomeBuilder.setStatus(toProto(toStatus(e)));
          clear();
        } catch (Exception e) {
          LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
          return sender.finishWithError(
              toStatus(
                  SpannerExceptionFactory.newSpannerException(
                      ErrorCode.INVALID_ARGUMENT,
                      CloudClientExecutor.unexpectedExceptionResponse(e))));
        }
        return sender.sendOutcome(outcomeBuilder.build());
      } else if (batchTxn != null) {
        return toStatus(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT, "Can't commit/abort a batch transaction"));
      } else {
        return toStatus(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT, "No currently active transaction"));
      }
    }

    /** Close active batch transaction. */
    public synchronized void closeBatchTxn() throws SpannerException {
      if (batchTxn == null) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "Not in a batch transaction");
      }
      batchTxn.close();
    }
  }

  private Spanner client;
  private Spanner clientWithTimeout;

  private static final String TRANSACTION_ABANDONED = "Fake error to abandon transaction";

  // Read-write transaction thread pool
  private static final Executor txnThreadPool =
      Executors.newCachedThreadPool(
          new ThreadFactoryBuilder().setNameFormat("txn-pool-%d").build());

  // Action thread pool
  private static final Executor actionThreadPool =
      Executors.newCachedThreadPool(
          new ThreadFactoryBuilder().setNameFormat("action-pool-%d").build());

  // Thread pool to verify end to end traces.
  private static final ExecutorService endToEndTracesThreadPool =
      Executors.newCachedThreadPool(
          new ThreadFactoryBuilder().setNameFormat("end-to-end-traces-pool-%d").build());

  private synchronized Spanner getClientWithTimeout(
      long timeoutSeconds, boolean useMultiplexedSession) throws IOException {
    if (clientWithTimeout != null) {
      return clientWithTimeout;
    }
    clientWithTimeout = getClient(timeoutSeconds, useMultiplexedSession);
    return clientWithTimeout;
  }

  private synchronized Spanner getClient(boolean useMultiplexedSession) throws IOException {
    if (client != null) {
      return client;
    }
    client = getClient(/* timeoutSeconds= */ 0, useMultiplexedSession);
    return client;
  }

  // Return the spanner client, create one if not exists.
  private synchronized Spanner getClient(long timeoutSeconds, boolean useMultiplexedSession)
      throws IOException {
    // Create a cloud spanner client
    Credentials credentials;
    if (WorkerProxy.serviceKeyFile.isEmpty()) {
      credentials = NoCredentials.getInstance();
    } else {
      credentials =
          ServiceAccountCredentials.fromStream(
              new ByteArrayInputStream(
                  FileUtils.readFileToByteArray(new File(WorkerProxy.serviceKeyFile))),
              HTTP_TRANSPORT_FACTORY);
    }

    TransportChannelProvider channelProvider =
        CloudUtil.newChannelProviderHelper(WorkerProxy.spannerPort);

    Duration rpcTimeout = Duration.ofHours(1L);
    if (timeoutSeconds > 0) {
      rpcTimeout = Duration.ofSeconds(timeoutSeconds);
    }
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofSeconds(1))
            .setRetryDelayMultiplier(1.3)
            .setMaxRetryDelayDuration(Duration.ofSeconds(32))
            .setInitialRpcTimeoutDuration(rpcTimeout)
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(rpcTimeout)
            .setTotalTimeoutDuration(rpcTimeout)
            .build();

    com.google.cloud.spanner.SessionPoolOptions.Builder poolOptionsBuilder =
        com.google.cloud.spanner.SessionPoolOptions.newBuilder();
    SessionPoolOptionsHelper.setUseMultiplexedSession(poolOptionsBuilder, useMultiplexedSession);
    SessionPoolOptionsHelper.setUseMultiplexedSessionForRW(
        poolOptionsBuilder, useMultiplexedSession);
    SessionPoolOptionsHelper.setUseMultiplexedSessionForPartitionedOperations(
        poolOptionsBuilder, useMultiplexedSession);
    LOGGER.log(
        Level.INFO,
        String.format(
            "Using multiplexed sessions for read-write transactions: %s", useMultiplexedSession));
    com.google.cloud.spanner.SessionPoolOptions sessionPoolOptions = poolOptionsBuilder.build();
    // Cloud Spanner Client does not support global retry settings,
    // Thus, we need to add retry settings to each individual stub.
    SpannerOptions.Builder optionsBuilder =
        SpannerOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setHost(HOST_PREFIX + WorkerProxy.spannerPort)
            .setCredentials(credentials)
            .setChannelProvider(channelProvider)
            .setEnableEndToEndTracing(true)
            .setOpenTelemetry(WorkerProxy.openTelemetrySdk)
            .setSessionPoolOption(sessionPoolOptions);

    SpannerStubSettings.Builder stubSettingsBuilder =
        optionsBuilder.getSpannerStubSettingsBuilder();

    stubSettingsBuilder.executeSqlSettings().setRetrySettings(retrySettings);
    stubSettingsBuilder.executeStreamingSqlSettings().setRetrySettings(retrySettings);
    stubSettingsBuilder.readSettings().setRetrySettings(retrySettings);
    stubSettingsBuilder.streamingReadSettings().setRetrySettings(retrySettings);
    stubSettingsBuilder.commitSettings().setRetrySettings(retrySettings);
    stubSettingsBuilder.executeBatchDmlSettings().setRetrySettings(retrySettings);
    stubSettingsBuilder.partitionQuerySettings().setRetrySettings(retrySettings);
    stubSettingsBuilder.partitionReadSettings().setRetrySettings(retrySettings);
    stubSettingsBuilder.rollbackSettings().setRetrySettings(retrySettings);
    stubSettingsBuilder.batchCreateSessionsSettings().setRetrySettings(retrySettings);
    stubSettingsBuilder.beginTransactionSettings().setRetrySettings(retrySettings);
    stubSettingsBuilder.createSessionSettings().setRetrySettings(retrySettings);
    stubSettingsBuilder.getSessionSettings().setRetrySettings(retrySettings);
    stubSettingsBuilder.deleteSessionSettings().setRetrySettings(retrySettings);

    return optionsBuilder.build().getService();
  }

  private TraceServiceClient traceServiceClient;

  // Return the trace service client, create one if not exists.
  private synchronized TraceServiceClient getTraceServiceClient() throws IOException {
    if (traceServiceClient != null) {
      return traceServiceClient;
    }
    // Create a trace service client
    Credentials credentials;
    if (WorkerProxy.serviceKeyFile.isEmpty()) {
      credentials = NoCredentials.getInstance();
    } else {
      credentials =
          ServiceAccountCredentials.fromStream(
              new ByteArrayInputStream(
                  FileUtils.readFileToByteArray(new File(WorkerProxy.serviceKeyFile))),
              HTTP_TRANSPORT_FACTORY);
    }

    TraceServiceSettings traceServiceSettings =
        TraceServiceSettings.newBuilder()
            .setEndpoint(WorkerProxy.CLOUD_TRACE_ENDPOINT)
            .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
            .build();

    traceServiceClient = TraceServiceClient.create(traceServiceSettings);
    return traceServiceClient;
  }

  public Future<Boolean> getEndToEndTraceVerificationTask(String traceId) {
    return endToEndTracesThreadPool.submit(
        () -> {
          try {
            // Wait for 10 seconds before verifying to ensure traces are exported.
            long sleepDuration = TimeUnit.SECONDS.toMillis(10);
            LOGGER.log(
                Level.INFO,
                String.format(
                    "Sleeping for %d milliseconds before verifying end to end trace",
                    sleepDuration));
            Thread.sleep(sleepDuration);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle interruption
            LOGGER.log(Level.INFO, String.format("Thread interrupted."));
            return false; // Return false if interrupted
          }
          return isExportedEndToEndTraceValid(traceId);
        });
  }

  private static final String READ_WRITE_TRANSACTION = "CloudSpanner.ReadWriteTransaction";
  private static final String READ_ONLY_TRANSACTION = "CloudSpanner.ReadOnlyTransaction";

  /* Returns whether a exported trace is valid. */
  public boolean isExportedEndToEndTraceValid(String traceId) {
    try {
      GetTraceRequest getTraceRequest =
          GetTraceRequest.newBuilder()
              .setProjectId(WorkerProxy.PROJECT_ID)
              .setTraceId(traceId)
              .build();
      Trace trace = getTraceServiceClient().getTrace(getTraceRequest);
      boolean readWriteOrReadOnlyTxnPresent = false, spannerServerSideSpanPresent = false;
      for (TraceSpan span : trace.getSpansList()) {
        if (span.getName().contains(READ_ONLY_TRANSACTION)
            || span.getName().contains(READ_WRITE_TRANSACTION)) {
          readWriteOrReadOnlyTxnPresent = true;
        }
        if (span.getName().startsWith("Spanner.")) {
          spannerServerSideSpanPresent = true;
        }
      }
      if (readWriteOrReadOnlyTxnPresent && !spannerServerSideSpanPresent) {
        return false;
      }
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Failed to verify end to end trace.", e);
      return false;
    }
    return true;
  }

  /** Handle actions. */
  public Status startHandlingRequest(
      SpannerAsyncActionRequest req, ExecutionFlowContext executionContext) {
    OutcomeSender outcomeSender = new OutcomeSender(req.getActionId(), executionContext);

    if (!req.hasAction()) {
      return outcomeSender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, "Invalid request")));
    }
    SpannerAction action = req.getAction();

    // Update dbPath
    String dbPath = executionContext.getDatabasePath(action.getDatabasePath());
    // Update session pool options
    boolean useMultiplexedSession;
    if (action.hasSpannerOptions() && action.getSpannerOptions().hasSessionPoolOptions()) {
      SessionPoolOptions sessionPoolOptions = action.getSpannerOptions().getSessionPoolOptions();
      useMultiplexedSession = sessionPoolOptions.getUseMultiplexed();
    } else {
      useMultiplexedSession = false;
    }

    io.opentelemetry.context.Context context = io.opentelemetry.context.Context.current();
    actionThreadPool.execute(
        context.wrap(
            () -> {
              Status status =
                  executeAction(
                      outcomeSender, action, dbPath, useMultiplexedSession, executionContext);
              if (!status.isOk()) {
                LOGGER.log(
                    Level.WARNING,
                    String.format("Failed to execute action with error: %s\n%s", status, action));
                executionContext.onError(status.getCause());
              }
            }));
    return Status.OK;
  }

  /** Execute actions by action case, using OutcomeSender to send status and results back. */
  private Status executeAction(
      OutcomeSender outcomeSender,
      SpannerAction action,
      String dbPath,
      boolean useMultiplexedSession,
      ExecutionFlowContext executionContext) {
    Tracer tracer = WorkerProxy.openTelemetrySdk.getTracer(CloudClientExecutor.class.getName());
    String actionType = action.getActionCase().toString();
    Span span = tracer.spanBuilder(String.format("performaction_%s", actionType)).startSpan();
    Scope scope = span.makeCurrent();
    try {
      if (action.hasAdmin()) {
        return executeAdminAction(useMultiplexedSession, action.getAdmin(), outcomeSender);
      } else if (action.hasStart()) {
        if (dbPath == null) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT, "Database path must be set for this action");
        }
        DatabaseClient dbClient =
            getClient(useMultiplexedSession).getDatabaseClient(DatabaseId.of(dbPath));
        return executeStartTxn(action.getStart(), dbClient, outcomeSender, executionContext);
      } else if (action.hasFinish()) {
        return executeFinishTxn(action.getFinish(), outcomeSender, executionContext);
      } else if (action.hasMutation()) {
        return executeMutation(
            action.getMutation(), outcomeSender, executionContext, /* isWrite= */ false);
      } else if (action.hasRead()) {
        return executeRead(
            useMultiplexedSession, action.getRead(), outcomeSender, executionContext);
      } else if (action.hasQuery()) {
        return executeQuery(
            useMultiplexedSession, action.getQuery(), outcomeSender, executionContext);
      } else if (action.hasDml()) {
        return executeCloudDmlUpdate(
            useMultiplexedSession, action.getDml(), outcomeSender, executionContext);
      } else if (action.hasBatchDml()) {
        return executeCloudBatchDmlUpdates(action.getBatchDml(), outcomeSender, executionContext);
      } else if (action.hasWrite()) {
        return executeMutation(
            action.getWrite().getMutation(), outcomeSender, executionContext, /* isWrite= */ true);
      } else if (action.hasStartBatchTxn()) {
        if (dbPath == null) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT, "database path must be set for this action");
        }
        BatchClient batchClient =
            getClient(useMultiplexedSession).getBatchClient(DatabaseId.of(dbPath));
        return executeStartBatchTxn(
            action.getStartBatchTxn(), batchClient, outcomeSender, executionContext);
      } else if (action.hasGenerateDbPartitionsRead()) {
        return executeGenerateDbPartitionsRead(
            action.getGenerateDbPartitionsRead(), outcomeSender, executionContext);
      } else if (action.hasGenerateDbPartitionsQuery()) {
        return executeGenerateDbPartitionsQuery(
            action.getGenerateDbPartitionsQuery(), outcomeSender, executionContext);
      } else if (action.hasExecutePartition()) {
        return executeExecutePartition(
            useMultiplexedSession, action.getExecutePartition(), outcomeSender, executionContext);
      } else if (action.hasPartitionedUpdate()) {
        if (dbPath == null) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT, "Database path must be set for this action");
        }
        DatabaseClient dbClient =
            getClient(useMultiplexedSession).getDatabaseClient(DatabaseId.of(dbPath));
        return executePartitionedUpdate(action.getPartitionedUpdate(), dbClient, outcomeSender);
      } else if (action.hasCloseBatchTxn()) {
        return executeCloseBatchTxn(action.getCloseBatchTxn(), outcomeSender, executionContext);
      } else if (action.hasExecuteChangeStreamQuery()) {
        if (dbPath == null) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT, "Database path must be set for this action");
        }
        return executeExecuteChangeStreamQuery(
            dbPath, useMultiplexedSession, action.getExecuteChangeStreamQuery(), outcomeSender);
      } else {
        return outcomeSender.finishWithError(
            toStatus(
                SpannerExceptionFactory.newSpannerException(
                    ErrorCode.UNIMPLEMENTED, "Not implemented yet: \n" + action)));
      }
    } catch (Exception e) {
      span.recordException(e);
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return outcomeSender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    } finally {
      scope.close();
      span.end();
    }
  }

  /** Execute admin actions by action case, using OutcomeSender to send status and results back. */
  private Status executeAdminAction(
      boolean useMultiplexedSession, AdminAction action, OutcomeSender outcomeSender) {
    try {
      if (action.hasCreateCloudInstance()) {
        return executeCreateCloudInstance(
            useMultiplexedSession, action.getCreateCloudInstance(), outcomeSender);
      } else if (action.hasUpdateCloudInstance()) {
        return executeUpdateCloudInstance(
            useMultiplexedSession, action.getUpdateCloudInstance(), outcomeSender);
      } else if (action.hasDeleteCloudInstance()) {
        return executeDeleteCloudInstance(
            useMultiplexedSession, action.getDeleteCloudInstance(), outcomeSender);
      } else if (action.hasListCloudInstances()) {
        return executeListCloudInstances(
            useMultiplexedSession, action.getListCloudInstances(), outcomeSender);
      } else if (action.hasListInstanceConfigs()) {
        return executeListCloudInstanceConfigs(
            useMultiplexedSession, action.getListInstanceConfigs(), outcomeSender);
      } else if (action.hasGetCloudInstanceConfig()) {
        return executeGetCloudInstanceConfig(
            useMultiplexedSession, action.getGetCloudInstanceConfig(), outcomeSender);
      } else if (action.hasGetCloudInstance()) {
        return executeGetCloudInstance(
            useMultiplexedSession, action.getGetCloudInstance(), outcomeSender);
      } else if (action.hasCreateUserInstanceConfig()) {
        return executeCreateUserInstanceConfig(
            useMultiplexedSession, action.getCreateUserInstanceConfig(), outcomeSender);
      } else if (action.hasDeleteUserInstanceConfig()) {
        return executeDeleteUserInstanceConfig(
            useMultiplexedSession, action.getDeleteUserInstanceConfig(), outcomeSender);
      } else if (action.hasCreateCloudDatabase()) {
        return executeCreateCloudDatabase(
            useMultiplexedSession, action.getCreateCloudDatabase(), outcomeSender);
      } else if (action.hasUpdateCloudDatabaseDdl()) {
        return executeUpdateCloudDatabaseDdl(
            useMultiplexedSession, action.getUpdateCloudDatabaseDdl(), outcomeSender);
      } else if (action.hasDropCloudDatabase()) {
        return executeDropCloudDatabase(
            useMultiplexedSession, action.getDropCloudDatabase(), outcomeSender);
      } else if (action.hasCreateCloudBackup()) {
        return executeCreateCloudBackup(
            useMultiplexedSession, action.getCreateCloudBackup(), outcomeSender);
      } else if (action.hasCopyCloudBackup()) {
        return executeCopyCloudBackup(
            useMultiplexedSession, action.getCopyCloudBackup(), outcomeSender);
      } else if (action.hasGetCloudBackup()) {
        return executeGetCloudBackup(
            useMultiplexedSession, action.getGetCloudBackup(), outcomeSender);
      } else if (action.hasUpdateCloudBackup()) {
        return executeUpdateCloudBackup(
            useMultiplexedSession, action.getUpdateCloudBackup(), outcomeSender);
      } else if (action.hasDeleteCloudBackup()) {
        return executeDeleteCloudBackup(
            useMultiplexedSession, action.getDeleteCloudBackup(), outcomeSender);
      } else if (action.hasListCloudBackups()) {
        return executeListCloudBackups(
            useMultiplexedSession, action.getListCloudBackups(), outcomeSender);
      } else if (action.hasListCloudBackupOperations()) {
        return executeListCloudBackupOperations(
            useMultiplexedSession, action.getListCloudBackupOperations(), outcomeSender);
      } else if (action.hasListCloudDatabases()) {
        return executeListCloudDatabases(
            useMultiplexedSession, action.getListCloudDatabases(), outcomeSender);
      } else if (action.hasListCloudDatabaseOperations()) {
        return executeListCloudDatabaseOperations(
            useMultiplexedSession, action.getListCloudDatabaseOperations(), outcomeSender);
      } else if (action.hasRestoreCloudDatabase()) {
        return executeRestoreCloudDatabase(
            useMultiplexedSession, action.getRestoreCloudDatabase(), outcomeSender);
      } else if (action.hasGetCloudDatabase()) {
        return executeGetCloudDatabase(
            useMultiplexedSession, action.getGetCloudDatabase(), outcomeSender);
      } else if (action.hasGetOperation()) {
        return executeGetOperation(useMultiplexedSession, action.getGetOperation(), outcomeSender);
      } else if (action.hasCancelOperation()) {
        return executeCancelOperation(
            useMultiplexedSession, action.getCancelOperation(), outcomeSender);
      } else {
        return outcomeSender.finishWithError(
            toStatus(
                SpannerExceptionFactory.newSpannerException(
                    ErrorCode.UNIMPLEMENTED, "Not implemented yet: \n" + action)));
      }
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return outcomeSender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that creates a cloud instance. */
  private Status executeCreateCloudInstance(
      boolean useMultiplexedSession, CreateCloudInstanceAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Creating instance: \n%s", action));
      InstanceAdminClient instanceAdminClient =
          getClient(useMultiplexedSession).getInstanceAdminClient();
      final String instanceId = action.getInstanceId();
      InstanceId instance = InstanceId.of(action.getProjectId(), instanceId);
      InstanceInfo.Builder builder =
          InstanceInfo.newBuilder(instance)
              .setInstanceConfigId(
                  InstanceConfigId.of(action.getProjectId(), action.getInstanceConfigId()))
              .setDisplayName(instanceId)
              .putAllLabels(action.getLabelsMap());
      if (action.hasNodeCount()) {
        builder.setNodeCount(action.getNodeCount());
      }
      if (action.hasProcessingUnits()) {
        builder.setProcessingUnits(action.getProcessingUnits());
      }
      final InstanceInfo request = builder.build();
      instanceAdminClient.createInstance(request).get();
    } catch (ExecutionException | InterruptedException ex) {
      SpannerException e = SpannerExceptionFactory.newSpannerException(ex);
      if (e.getErrorCode() == ErrorCode.ALREADY_EXISTS) {
        // Another worker or our previous attempt already created the instance.
        return sender.finishWithOK();
      }
      return sender.finishWithError(toStatus(e));
    } catch (SpannerException se) {
      return sender.finishWithError(toStatus(se));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
    return sender.finishWithOK();
  }

  /** Execute action that updates a cloud instance. */
  private Status executeUpdateCloudInstance(
      boolean useMultiplexedSession, UpdateCloudInstanceAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Updating instance: \n%s", action));
      InstanceAdminClient instanceAdminClient =
          getClient(useMultiplexedSession).getInstanceAdminClient();
      final String instanceId = action.getInstanceId();
      final InstanceId instance = InstanceId.of(action.getProjectId(), instanceId);
      final InstanceInfo.Builder builder = InstanceInfo.newBuilder(instance);

      ArrayList<InstanceInfo.InstanceField> fieldsToUpdate = new ArrayList<>();
      if (action.hasDisplayName()) {
        fieldsToUpdate.add(InstanceInfo.InstanceField.DISPLAY_NAME);
        builder.setDisplayName(instanceId);
      }
      if (action.hasNodeCount()) {
        fieldsToUpdate.add(InstanceInfo.InstanceField.NODE_COUNT);
        builder.setNodeCount(action.getNodeCount());
      }
      if (action.hasProcessingUnits()) {
        fieldsToUpdate.add(InstanceInfo.InstanceField.PROCESSING_UNITS);
        builder.setProcessingUnits(action.getProcessingUnits());
      }
      Map<String, String> labels = action.getLabelsMap();
      if (!labels.isEmpty()) {
        fieldsToUpdate.add(InstanceInfo.InstanceField.LABELS);
        builder.putAllLabels(action.getLabelsMap());
      }
      final InstanceInfo request = builder.build();
      instanceAdminClient
          .updateInstance(request, fieldsToUpdate.toArray(new InstanceInfo.InstanceField[0]))
          .get();
    } catch (ExecutionException | InterruptedException ex) {
      SpannerException e = SpannerExceptionFactory.newSpannerException(ex);
      return sender.finishWithError(toStatus(e));
    } catch (SpannerException se) {
      return sender.finishWithError(toStatus(se));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
    return sender.finishWithOK();
  }

  /** Execute action that deletes a cloud instance. */
  private Status executeDeleteCloudInstance(
      boolean useMultiplexedSession, DeleteCloudInstanceAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Deleting instance: \n%s", action));
      InstanceAdminClient instanceAdminClient =
          getClient(useMultiplexedSession).getInstanceAdminClient();
      final String instanceId = action.getInstanceId();
      final InstanceId instance = InstanceId.of(action.getProjectId(), instanceId);
      instanceAdminClient.deleteInstance(instance.getInstance());
    } catch (SpannerException se) {
      return sender.finishWithError(toStatus(se));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
    return sender.finishWithOK();
  }

  /** Execute action that lists cloud instances. */
  private Status executeListCloudInstances(
      boolean useMultiplexedSession, ListCloudInstancesAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Listing instances:\n%s", action));
      ArrayList<Options.ListOption> options = new ArrayList<>();
      if (action.hasPageSize()) {
        options.add(Options.pageSize(action.getPageSize()));
      }
      if (action.hasFilter()) {
        options.add(Options.filter(action.getFilter()));
      }
      if (action.hasPageToken()) {
        options.add(Options.pageToken(action.getPageToken()));
      }

      Page<com.google.cloud.spanner.Instance> response =
          getClient(useMultiplexedSession)
              .getInstanceAdminClient()
              .listInstances(options.toArray(new Options.ListOption[0]));
      List<com.google.spanner.admin.instance.v1.Instance> instanceList = new ArrayList<>();
      for (Instance instance : response.iterateAll()) {
        instanceList.add(instanceToProto(instance));
      }
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .setAdminResult(
                  AdminResult.newBuilder()
                      .setInstanceResponse(
                          CloudInstanceResponse.newBuilder()
                              .addAllListedInstances(instanceList)
                              .setNextPageToken("")
                              .build()))
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that lists cloud instance configs. */
  private Status executeListCloudInstanceConfigs(
      boolean useMultiplexedSession, ListCloudInstanceConfigsAction action, OutcomeSender sender) {
    LOGGER.log(Level.INFO, String.format("Listing instance configs:\n%s", action));
    ArrayList<Options.ListOption> options = new ArrayList<>();
    if (action.hasPageSize()) {
      options.add(Options.pageSize(action.getPageSize()));
    }
    if (action.hasPageToken()) {
      options.add(Options.pageToken(action.getPageToken()));
    }
    try {
      Page<InstanceConfig> response =
          getClient(useMultiplexedSession)
              .getInstanceAdminClient()
              .listInstanceConfigs(options.toArray(new Options.ListOption[0]));
      List<com.google.spanner.admin.instance.v1.InstanceConfig> instanceConfigList =
          new ArrayList<>();
      for (InstanceConfig instanceConfig : response.iterateAll()) {
        instanceConfigList.add(instanceConfigToProto(instanceConfig));
      }
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .setAdminResult(
                  AdminResult.newBuilder()
                      .setInstanceConfigResponse(
                          CloudInstanceConfigResponse.newBuilder()
                              .addAllListedInstanceConfigs(instanceConfigList)
                              .setNextPageToken("")
                              .build()))
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that gets a cloud instance config. */
  private Status executeGetCloudInstanceConfig(
      boolean useMultiplexedSession, GetCloudInstanceConfigAction action, OutcomeSender sender) {
    LOGGER.log(Level.INFO, String.format("Getting instance config:\n%s", action));
    try {
      InstanceConfig instanceConfig =
          getClient(useMultiplexedSession)
              .getInstanceAdminClient()
              .getInstanceConfig(action.getInstanceConfigId());
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .setAdminResult(
                  AdminResult.newBuilder()
                      .setInstanceConfigResponse(
                          CloudInstanceConfigResponse.newBuilder()
                              .setInstanceConfig(instanceConfigToProto(instanceConfig))
                              .build()))
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that retrieves a cloud instance. */
  private Status executeGetCloudInstance(
      boolean useMultiplexedSession, GetCloudInstanceAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Retrieving instance:\n%s", action));
      Instance instance =
          getClient(useMultiplexedSession)
              .getInstanceAdminClient()
              .getInstance(action.getInstanceId());
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .setAdminResult(
                  AdminResult.newBuilder()
                      .setInstanceResponse(
                          CloudInstanceResponse.newBuilder()
                              .setInstance(instanceToProto(instance))
                              .build()))
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that creates a user instance config. */
  private Status executeCreateUserInstanceConfig(
      boolean useMultiplexedSession, CreateUserInstanceConfigAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Creating user instance config:\n%s", action));
      final InstanceConfig baseConfig =
          getClient(useMultiplexedSession)
              .getInstanceAdminClient()
              .getInstanceConfig(action.getBaseConfigId());
      InstanceConfigInfo instanceConfigInfo =
          InstanceConfig.newBuilder(
                  InstanceConfigId.of(action.getProjectId(), action.getUserConfigId()), baseConfig)
              .setDisplayName(action.getUserConfigId())
              .addReadOnlyReplicas(baseConfig.getOptionalReplicas())
              .build();
      getClient(useMultiplexedSession)
          .getInstanceAdminClient()
          .createInstanceConfig(instanceConfigInfo)
          .get();
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
    return sender.finishWithOK();
  }

  /** Execute action that deletes a user instance config. */
  private Status executeDeleteUserInstanceConfig(
      boolean useMultiplexedSession, DeleteUserInstanceConfigAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Deleting user instance config:\n%s", action));
      getClient(useMultiplexedSession)
          .getInstanceAdminClient()
          .deleteInstanceConfig(action.getUserConfigId());
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
    return sender.finishWithOK();
  }

  /** Execute action that creates a cloud custom encrypted database. */
  private Status executeCreateCloudCustomEncryptedDatabase(
      boolean useMultiplexedSession, CreateCloudDatabaseAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Creating database: \n%s", action));
      Database dbInfo =
          getClient(useMultiplexedSession)
              .getDatabaseAdminClient()
              .newDatabaseBuilder(
                  DatabaseId.of(
                      action.getProjectId(), action.getInstanceId(), action.getDatabaseId()))
              .setEncryptionConfig(
                  CustomerManagedEncryption.fromProtoOrNull(action.getEncryptionConfig()))
              .build();
      getClient(useMultiplexedSession)
          .getDatabaseAdminClient()
          .createDatabase(dbInfo, action.getSdlStatementList());
    } catch (SpannerException se) {
      return sender.finishWithError(toStatus(se));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
    return sender.finishWithOK();
  }

  /** Execute action that creates a cloud database. */
  private Status executeCreateCloudDatabase(
      boolean useMultiplexedSession, CreateCloudDatabaseAction action, OutcomeSender sender) {
    if (action.hasEncryptionConfig()) {
      return executeCreateCloudCustomEncryptedDatabase(useMultiplexedSession, action, sender);
    }
    try {
      LOGGER.log(Level.INFO, String.format("Creating database: \n%s", action));
      final String instanceId = action.getInstanceId();
      final String databaseId = action.getDatabaseId();
      getClient(useMultiplexedSession)
          .getDatabaseAdminClient()
          .createDatabase(instanceId, databaseId, action.getSdlStatementList())
          .get();
    } catch (ExecutionException | InterruptedException ex) {
      SpannerException e = SpannerExceptionFactory.newSpannerException(ex);
      if (e.getErrorCode() == ErrorCode.ALREADY_EXISTS) {
        // Client does not retry database, but we assume that no other process has created
        // the database with a different schema (another instance of a worker may have
        // created it with the same schema).
        return sender.finishWithOK();
      }
      return sender.finishWithError(toStatus(e));
    } catch (SpannerException se) {
      return sender.finishWithError(toStatus(se));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
    return sender.finishWithOK();
  }

  /** Execute action that updates a cloud database. */
  private Status executeUpdateCloudDatabaseDdl(
      boolean useMultiplexedSession, UpdateCloudDatabaseDdlAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Updating database: \n%s", action));
      DatabaseAdminClient dbAdminClient = getClient(useMultiplexedSession).getDatabaseAdminClient();
      final String instanceId = action.getInstanceId();
      final String databaseId = action.getDatabaseId();
      UpdateDatabaseDdlMetadata metadata;
      OperationFuture<Void, UpdateDatabaseDdlMetadata> updateOp =
          dbAdminClient.updateDatabaseDdl(
              instanceId, databaseId, action.getSdlStatementList(), action.getOperationId());
      updateOp.get();
      metadata = updateOp.getMetadata().get();
      int tsCount = metadata.getCommitTimestampsCount();
      // Fetch the last timestamp
      sender.setTimestamp(metadata.getCommitTimestamps(tsCount - 1));
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(
          Level.WARNING,
          "Unexpected error executing DDL: "
              + String.join("; ", action.getSdlStatementList())
              + " "
              + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
    return sender.finishWithOK();
  }

  /** Execute action that updates a cloud database. */
  private Status executeDropCloudDatabase(
      boolean useMultiplexedSession, DropCloudDatabaseAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Dropping database: \n%s", action));
      DatabaseAdminClient dbAdminClient = getClient(useMultiplexedSession).getDatabaseAdminClient();
      final String instanceId = action.getInstanceId();
      final String databaseId = action.getDatabaseId();
      dbAdminClient.dropDatabase(instanceId, databaseId);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
    return sender.finishWithOK();
  }

  /** Execute action that creates a cloud database backup. */
  private Status executeCreateCloudBackup(
      boolean useMultiplexedSession, CreateCloudBackupAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Creating backup: \n%s", action));
      Backup backupResult =
          getClient(useMultiplexedSession)
              .getDatabaseAdminClient()
              .createBackup(
                  action.getInstanceId(),
                  action.getBackupId(),
                  action.getDatabaseId(),
                  Timestamp.fromProto(action.getExpireTime()))
              .get();
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .setAdminResult(
                  AdminResult.newBuilder()
                      .setBackupResponse(
                          CloudBackupResponse.newBuilder()
                              .setBackup(backupResult.getProto())
                              .build()))
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that copies a cloud database backup. */
  private Status executeCopyCloudBackup(
      boolean useMultiplexedSession, CopyCloudBackupAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Copying backup: \n%s", action));
      Backup backupResult =
          getClient(useMultiplexedSession)
              .getDatabaseAdminClient()
              .copyBackup(
                  action.getInstanceId(),
                  action.getBackupId(),
                  action.getSourceBackup(),
                  Timestamp.fromProto(action.getExpireTime()))
              .get();
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .setAdminResult(
                  AdminResult.newBuilder()
                      .setBackupResponse(
                          CloudBackupResponse.newBuilder()
                              .setBackup(backupResult.getProto())
                              .build()))
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that gets a cloud database backup. */
  private Status executeGetCloudBackup(
      boolean useMultiplexedSession, GetCloudBackupAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Getting backup: \n%s", action));
      Backup backupResult =
          getClient(useMultiplexedSession)
              .getDatabaseAdminClient()
              .getBackup(action.getInstanceId(), action.getBackupId());
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .setAdminResult(
                  AdminResult.newBuilder()
                      .setBackupResponse(
                          CloudBackupResponse.newBuilder()
                              .setBackup(backupResult.getProto())
                              .build()))
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that updates a cloud database backup. */
  private Status executeUpdateCloudBackup(
      boolean useMultiplexedSession, UpdateCloudBackupAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Updating backup: \n%s", action));
      Backup backupResult =
          getClient(useMultiplexedSession)
              .getDatabaseAdminClient()
              .updateBackup(
                  action.getInstanceId(),
                  action.getBackupId(),
                  Timestamp.fromProto(action.getExpireTime()));
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .setAdminResult(
                  AdminResult.newBuilder()
                      .setBackupResponse(
                          CloudBackupResponse.newBuilder()
                              .setBackup(backupResult.getProto())
                              .build()))
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that deletes a cloud database backup. */
  private Status executeDeleteCloudBackup(
      boolean useMultiplexedSession, DeleteCloudBackupAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, "Deleting backup: \n%s", action);
      getClient(useMultiplexedSession)
          .getDatabaseAdminClient()
          .deleteBackup(action.getInstanceId(), action.getBackupId());
      return sender.finishWithOK();
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that lists cloud database backups. */
  private Status executeListCloudBackups(
      boolean useMultiplexedSession, ListCloudBackupsAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Listing backup: \n%s", action));
      Page<Backup> response =
          getClient(useMultiplexedSession)
              .getDatabaseAdminClient()
              .listBackups(
                  action.getInstanceId(),
                  Options.pageSize(action.getPageSize()),
                  Options.filter(action.getFilter()),
                  Options.pageToken(action.getPageToken()));
      List<com.google.spanner.admin.database.v1.Backup> backupList = new ArrayList<>();
      for (Backup backup : response.iterateAll()) {
        backupList.add(backup.getProto());
      }
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .setAdminResult(
                  AdminResult.newBuilder()
                      .setBackupResponse(
                          CloudBackupResponse.newBuilder()
                              .addAllListedBackups(backupList)
                              .setNextPageToken("")
                              .build()))
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that lists cloud database backup operations. */
  private Status executeListCloudBackupOperations(
      boolean useMultiplexedSession, ListCloudBackupOperationsAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Listing backup operation: \n%s", action));

      Page<com.google.longrunning.Operation> response =
          getClient(useMultiplexedSession)
              .getDatabaseAdminClient()
              .listBackupOperations(
                  action.getInstanceId(),
                  Options.pageSize(action.getPageSize()),
                  Options.filter(action.getFilter()),
                  Options.pageToken(action.getPageToken()));
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .setAdminResult(
                  AdminResult.newBuilder()
                      .setBackupResponse(
                          CloudBackupResponse.newBuilder()
                              .addAllListedBackupOperations(response.iterateAll())
                              .setNextPageToken("")
                              .build()))
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that list cloud databases. */
  private Status executeListCloudDatabases(
      boolean useMultiplexedSession, ListCloudDatabasesAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Listing database: \n%s", action));
      Page<com.google.cloud.spanner.Database> response =
          getClient(useMultiplexedSession)
              .getDatabaseAdminClient()
              .listDatabases(
                  action.getInstanceId(),
                  Options.pageSize(action.getPageSize()),
                  Options.pageToken(action.getPageToken()));
      List<com.google.spanner.admin.database.v1.Database> databaseList = new ArrayList<>();
      for (Database database : response.iterateAll()) {
        databaseList.add(database.getProto());
      }
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .setAdminResult(
                  AdminResult.newBuilder()
                      .setDatabaseResponse(
                          CloudDatabaseResponse.newBuilder()
                              .addAllListedDatabases(databaseList)
                              .setNextPageToken("")
                              .build()))
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that lists cloud database operations. */
  private Status executeListCloudDatabaseOperations(
      boolean useMultiplexedSession,
      ListCloudDatabaseOperationsAction action,
      OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Listing database operation: \n%s", action));

      Page<com.google.longrunning.Operation> response =
          getClient(useMultiplexedSession)
              .getDatabaseAdminClient()
              .listDatabaseOperations(
                  action.getInstanceId(),
                  Options.pageSize(action.getPageSize()),
                  Options.filter(action.getFilter()),
                  Options.pageToken(action.getPageToken()));
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .setAdminResult(
                  AdminResult.newBuilder()
                      .setDatabaseResponse(
                          CloudDatabaseResponse.newBuilder()
                              .addAllListedDatabaseOperations(response.iterateAll())
                              .setNextPageToken("")
                              .build()))
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that restores a cloud database. */
  private Status executeRestoreCloudDatabase(
      boolean useMultiplexedSession, RestoreCloudDatabaseAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Restoring database: \n%s", action));
      Database db =
          getClient(useMultiplexedSession)
              .getDatabaseAdminClient()
              .restoreDatabase(
                  action.getBackupInstanceId(),
                  action.getBackupId(),
                  action.getDatabaseInstanceId(),
                  action.getDatabaseId())
              .get();
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .setAdminResult(
                  AdminResult.newBuilder()
                      .setDatabaseResponse(
                          CloudDatabaseResponse.newBuilder().setDatabase(db.getProto()).build()))
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that gets a cloud database. */
  private Status executeGetCloudDatabase(
      boolean useMultiplexedSession, GetCloudDatabaseAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Getting database: \n%s", action));
      Database databaseResult =
          getClient(useMultiplexedSession)
              .getDatabaseAdminClient()
              .getDatabase(action.getInstanceId(), action.getDatabaseId());
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .setAdminResult(
                  AdminResult.newBuilder()
                      .setDatabaseResponse(
                          CloudDatabaseResponse.newBuilder()
                              .setDatabase(databaseResult.getProto())
                              .build()))
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that gets an operation. */
  private Status executeGetOperation(
      boolean useMultiplexedSession, GetOperationAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Getting operation: \n%s", action));
      final String operationName = action.getOperation();
      Operation operationResult =
          getClient(useMultiplexedSession).getDatabaseAdminClient().getOperation(operationName);
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .setAdminResult(
                  AdminResult.newBuilder()
                      .setOperationResponse(
                          OperationResponse.newBuilder().setOperation(operationResult).build()))
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that cancels an operation. */
  private Status executeCancelOperation(
      boolean useMultiplexedSession, CancelOperationAction action, OutcomeSender sender) {
    try {
      LOGGER.log(Level.INFO, String.format("Cancelling operation: \n%s", action));
      final String operationName = action.getOperation();
      getClient(useMultiplexedSession).getDatabaseAdminClient().cancelOperation(operationName);
      return sender.finishWithOK();
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that starts a batch transaction. */
  private Status executeStartBatchTxn(
      StartBatchTransactionAction action,
      BatchClient batchClient,
      OutcomeSender sender,
      ExecutionFlowContext executionContext) {
    LOGGER.log(Level.INFO, "Starting batch transaction");
    return executionContext.startBatchTxn(action, batchClient, sender);
  }

  /** Execute action that finishes a batch transaction. */
  private Status executeCloseBatchTxn(
      CloseBatchTransactionAction action,
      OutcomeSender sender,
      ExecutionFlowContext executionContext) {
    try {
      LOGGER.log(Level.INFO, "Closing batch transaction");
      if (action.getCleanup()) {
        executionContext.closeBatchTxn();
      }
      return sender.finishWithOK();
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    }
  }

  /** Execute action that generates database partitions for the given read. */
  private Status executeGenerateDbPartitionsRead(
      GenerateDbPartitionsForReadAction action,
      OutcomeSender sender,
      ExecutionFlowContext executionContext) {
    try {
      BatchReadOnlyTransaction batchTxn = executionContext.getBatchTxn();
      Metadata metadata = new Metadata(action.getTableList());
      executionContext.setMetadata(metadata);
      ReadAction request = action.getRead();

      List<com.google.spanner.v1.Type> typeList = new ArrayList<>();
      for (int i = 0; i < request.getColumnCount(); ++i) {
        typeList.add(executionContext.getColumnType(request.getTable(), request.getColumn(i)));
      }
      KeySet keySet = keySetProtoToCloudKeySet(request.getKeys(), typeList);
      PartitionOptions.Builder partitionOptionsBuilder = PartitionOptions.newBuilder();
      if (action.hasDesiredBytesPerPartition() && action.getDesiredBytesPerPartition() > 0) {
        partitionOptionsBuilder.setPartitionSizeBytes(action.getDesiredBytesPerPartition());
      }
      if (action.hasMaxPartitionCount()) {
        partitionOptionsBuilder.setMaxPartitions(action.getMaxPartitionCount());
      }
      List<Partition> parts;
      if (request.hasIndex()) {
        parts =
            batchTxn.partitionReadUsingIndex(
                partitionOptionsBuilder.build(),
                request.getTable(),
                request.getIndex(),
                keySet,
                new ArrayList<>(request.getColumnList()));
      } else {
        parts =
            batchTxn.partitionRead(
                partitionOptionsBuilder.build(),
                request.getTable(),
                keySet,
                new ArrayList<>(request.getColumnList()));
      }
      List<BatchPartition> batchPartitions = new ArrayList<>();
      for (Partition part : parts) {
        batchPartitions.add(
            BatchPartition.newBuilder()
                .setPartition(marshall(part))
                .setPartitionToken(part.getPartitionToken())
                .setTable(request.getTable())
                .setIndex(request.getIndex())
                .build());
      }
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .addAllDbPartition(batchPartitions)
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      LOGGER.log(Level.WARNING, String.format("GenerateDbPartitionsRead failed for %s", action));
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute action that generates database partitions for the given query. */
  private Status executeGenerateDbPartitionsQuery(
      GenerateDbPartitionsForQueryAction action,
      OutcomeSender sender,
      ExecutionFlowContext executionContext) {
    try {
      BatchReadOnlyTransaction batchTxn = executionContext.getBatchTxn();
      Statement.Builder stmt = Statement.newBuilder(action.getQuery().getSql());
      for (int i = 0; i < action.getQuery().getParamsCount(); ++i) {
        stmt.bind(action.getQuery().getParams(i).getName())
            .to(
                valueProtoToCloudValue(
                    action.getQuery().getParams(i).getType(),
                    action.getQuery().getParams(i).getValue()));
      }
      PartitionOptions partitionOptions =
          PartitionOptions.newBuilder()
              .setPartitionSizeBytes(action.getDesiredBytesPerPartition())
              .build();
      List<Partition> parts = batchTxn.partitionQuery(partitionOptions, stmt.build());
      List<BatchPartition> batchPartitions = new ArrayList<>();
      for (Partition part : parts) {
        batchPartitions.add(
            BatchPartition.newBuilder()
                .setPartition(marshall(part))
                .setPartitionToken(part.getPartitionToken())
                .build());
      }

      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .addAllDbPartition(batchPartitions)
              .build();
      return sender.sendOutcome(outcome);
    } catch (SpannerException e) {
      LOGGER.log(Level.WARNING, String.format("GenerateDbPartitionsQuery failed for %s", action));
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute a read or query for the given partitions. */
  private Status executeExecutePartition(
      boolean useMultiplexedSession,
      ExecutePartitionAction action,
      OutcomeSender sender,
      ExecutionFlowContext executionContext) {
    try {
      BatchReadOnlyTransaction batchTxn = executionContext.getBatchTxn();
      ByteString partitionBinary = action.getPartition().getPartition();
      if (partitionBinary.size() == 0) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "Invalid batchPartition " + action);
      }
      if (action.getPartition().hasTable()) {
        sender.initForBatchRead(action.getPartition().getTable(), action.getPartition().getIndex());
      } else {
        sender.initForQuery();
      }
      Partition partition = unmarshall(partitionBinary);
      executionContext.startRead();
      ResultSet result = batchTxn.execute(partition);
      return processResults(useMultiplexedSession, result, 0, sender, executionContext);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Execute a partitioned update which runs different partitions in parallel. */
  private Status executePartitionedUpdate(
      PartitionedUpdateAction action, DatabaseClient dbClient, OutcomeSender sender) {
    try {
      ExecutePartitionedUpdateOptions options = action.getOptions();
      Long count =
          dbClient.executePartitionedUpdate(
              Statement.of(action.getUpdate().getSql()),
              Options.tag(options.getTag()),
              Options.priority(RpcPriority.fromProto(options.getRpcPriority())));
      SpannerActionOutcome outcome =
          SpannerActionOutcome.newBuilder()
              .setStatus(toProto(Status.OK))
              .addDmlRowsModified(count)
              .build();
      sender.sendOutcome(outcome);
      return sender.finishWithOK();
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /** Build a child partition record proto out of childPartitionRecord returned by client. */
  private ChildPartitionsRecord buildChildPartitionRecord(Struct childPartitionRecord)
      throws Exception {
    ChildPartitionsRecord.Builder childPartitionRecordBuilder = ChildPartitionsRecord.newBuilder();
    childPartitionRecordBuilder.setStartTime(
        Timestamps.parse(childPartitionRecord.getTimestamp(0).toString()));
    childPartitionRecordBuilder.setRecordSequence(childPartitionRecord.getString(1));
    for (Struct childPartition : childPartitionRecord.getStructList(2)) {
      ChildPartitionsRecord.ChildPartition.Builder childPartitionBuilder =
          ChildPartitionsRecord.ChildPartition.newBuilder();
      childPartitionBuilder.setToken(childPartition.getString(0));
      childPartitionBuilder.addAllParentPartitionTokens(childPartition.getStringList(1));
      childPartitionRecordBuilder.addChildPartitions(childPartitionBuilder.build());
    }
    return childPartitionRecordBuilder.build();
  }

  /** Build a data change record proto out of dataChangeRecord returned by client. */
  private DataChangeRecord buildDataChangeRecord(Struct dataChangeRecord) throws Exception {
    DataChangeRecord.Builder dataChangeRecordBuilder = DataChangeRecord.newBuilder();
    dataChangeRecordBuilder.setCommitTime(
        Timestamps.parse(dataChangeRecord.getTimestamp(0).toString()));
    dataChangeRecordBuilder.setRecordSequence(dataChangeRecord.getString(1));
    dataChangeRecordBuilder.setTransactionId(dataChangeRecord.getString(2));
    dataChangeRecordBuilder.setIsLastRecord(dataChangeRecord.getBoolean(3));
    dataChangeRecordBuilder.setTable(dataChangeRecord.getString(4));
    for (Struct columnType : dataChangeRecord.getStructList(5)) {
      DataChangeRecord.ColumnType.Builder columnTypeBuilder =
          DataChangeRecord.ColumnType.newBuilder();
      columnTypeBuilder.setName(columnType.getString(0));
      columnTypeBuilder.setType(getJsonStringForStructColumn(columnType, 1));
      columnTypeBuilder.setIsPrimaryKey(columnType.getBoolean(2));
      columnTypeBuilder.setOrdinalPosition(columnType.getLong(3));
      dataChangeRecordBuilder.addColumnTypes(columnTypeBuilder.build());
    }
    for (Struct mod : dataChangeRecord.getStructList(6)) {
      DataChangeRecord.Mod.Builder modBuilder = DataChangeRecord.Mod.newBuilder();
      modBuilder.setKeys(getJsonStringForStructColumn(mod, 0));
      modBuilder.setNewValues(getJsonStringForStructColumn(mod, 1));
      modBuilder.setOldValues(getJsonStringForStructColumn(mod, 2));
      dataChangeRecordBuilder.addMods(modBuilder.build());
    }
    dataChangeRecordBuilder.setModType(dataChangeRecord.getString(7));
    dataChangeRecordBuilder.setValueCaptureType(dataChangeRecord.getString(8));

    // Get transaction tag.
    dataChangeRecordBuilder.setTransactionTag(
        dataChangeRecord.getString(DataChangeRecord.TRANSACTION_TAG_FIELD_NUMBER - 1));

    // Get is system transaction.
    dataChangeRecordBuilder.setIsSystemTransaction(
        dataChangeRecord.getBoolean(DataChangeRecord.IS_SYSTEM_TRANSACTION_FIELD_NUMBER - 1));
    return dataChangeRecordBuilder.build();
  }

  /** Returns the json or string value of a struct column with index=columnIndex. */
  private String getJsonStringForStructColumn(Struct struct, int columnIndex) {
    Type columnType = struct.getColumnType(columnIndex);
    switch (columnType.getCode()) {
      case JSON:
        return struct.getJson(columnIndex);
      case STRING:
        return struct.getString(columnIndex);
      default:
        throw new IllegalArgumentException(
            String.format(
                "Cannot extract value from column with index = %d and column type = %s for struct:"
                    + " %s",
                columnIndex, columnType, struct));
    }
  }

  /** Build a heartbeat record proto out of heartbeatRecord returned by client. */
  private HeartbeatRecord buildHeartbeatRecord(Struct heartbeatRecord) throws Exception {
    HeartbeatRecord.Builder heartbeatRecordBuilder = HeartbeatRecord.newBuilder();
    heartbeatRecordBuilder.setHeartbeatTime(
        Timestamps.parse(heartbeatRecord.getTimestamp(0).toString()));
    return heartbeatRecordBuilder.build();
  }

  /** Execute action that executes a change stream query. */
  private Status executeExecuteChangeStreamQuery(
      String dbPath,
      boolean useMultiplexedSession,
      ExecuteChangeStreamQuery action,
      OutcomeSender sender) {
    try {
      LOGGER.log(
          Level.INFO, String.format("Start executing change change stream query: \n%s", action));

      // Retrieve TVF parameters from the action.
      String changeStreamName = action.getName();
      // For initial partition query (no partition token) we simulate precision of the timestamp
      // in nanoseconds as that's closer inlined with the production client code.

      String startTime =
          timestampToString(
              !action.hasPartitionToken(), Timestamps.toMicros(action.getStartTime()));
      String endTime = "null";
      if (action.hasEndTime()) {
        endTime =
            timestampToString(
                !action.hasPartitionToken(), Timestamps.toMicros(action.getEndTime()));
      }
      String heartbeat = "null";
      if (action.hasHeartbeatMilliseconds()) {
        heartbeat = Integer.toString(action.getHeartbeatMilliseconds());
      }
      String partitionToken = "null";
      if (action.hasPartitionToken()) {
        partitionToken = String.format("\"%s\"", action.getPartitionToken());
      }

      String tvfQuery =
          String.format(
              "SELECT * FROM READ_%s(%s,%s,%s,%s);",
              changeStreamName, startTime, endTime, partitionToken, heartbeat);

      LOGGER.log(Level.INFO, String.format("Start executing change stream TVF: \n%s", tvfQuery));
      sender.initForChangeStreamQuery(
          action.getHeartbeatMilliseconds(), action.getName(), action.getPartitionToken());
      Spanner spannerClient;
      if (action.hasDeadlineSeconds()) {
        spannerClient = getClientWithTimeout(action.getDeadlineSeconds(), useMultiplexedSession);
      } else {
        spannerClient = getClient(useMultiplexedSession);
      }
      DatabaseClient dbClient = spannerClient.getDatabaseClient(DatabaseId.of(dbPath));
      ResultSet resultSet = dbClient.singleUse().executeQuery(Statement.of(tvfQuery));

      ChangeStreamRecord.Builder changeStreamRecordBuilder = ChangeStreamRecord.newBuilder();
      while (resultSet.next()) {
        Struct record = resultSet.getStructList(0).get(0);
        for (Struct dataChangeRecord : record.getStructList("data_change_record")) {
          // If the data change record is null, that means the ChangeRecord is either a heartbeat
          // or a child partitions record.
          if (dataChangeRecord.isNull(0)) {
            continue;
          }
          DataChangeRecord builtDataChangeRecord = buildDataChangeRecord(dataChangeRecord);
          changeStreamRecordBuilder.setDataChange(builtDataChangeRecord);
        }
        for (Struct heartbeatRecord : record.getStructList("heartbeat_record")) {
          // If the heartbeat record is null, that means the ChangeRecord is either a data change
          // record or a child partitions record.
          if (heartbeatRecord.isNull(0)) {
            continue;
          }
          HeartbeatRecord builtHeartbeatRecord = buildHeartbeatRecord(heartbeatRecord);
          changeStreamRecordBuilder.setHeartbeat(builtHeartbeatRecord);
        }
        for (Struct childPartitionRecord : record.getStructList("child_partitions_record")) {
          // If the child partitions record is null, that means the ChangeRecord is either a
          // data change record or a heartbeat record.
          if (childPartitionRecord.isNull(0)) {
            continue;
          }
          ChildPartitionsRecord builtChildPartitionsRecord =
              buildChildPartitionRecord(childPartitionRecord);
          changeStreamRecordBuilder.setChildPartition(builtChildPartitionsRecord);
        }
        // For partitioned queries, validate that the time between received change records are
        // less than 10x the heartbeat interval.
        // Right now, we are not failing the handler since there are other issues besides change
        // stream related issues that can cause the heartbeat check to fail (i.e. RPC latency).
        if (sender.getIsPartitionedChangeStreamQuery()) {
          long lastReceivedTimestamp = sender.getChangeStreamRecordReceivedTimestamp();
          long currentChangeRecordReceivedTimestamp = System.currentTimeMillis();
          long discrepancyMillis = currentChangeRecordReceivedTimestamp - lastReceivedTimestamp;
          // Only do the heartbeat check after we have already received one record for the query
          // (i.e. lastReceivedTimestamp > 0).
          // We should only check the heartbeat interval if heartbeat is greater than 5 seconds,
          // to prevent flaky failures.
          if (lastReceivedTimestamp > 0
              && discrepancyMillis > sender.getChangeStreamHeartbeatMilliSeconds() * 10
              && sender.getChangeStreamHeartbeatMilliSeconds() > 5000) {
            // Log.info(
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.INTERNAL,
                "Does not pass the heartbeat interval check. The last record was received seconds"
                    + discrepancyMillis / 1000
                    + " ago, which is more than ten times the heartbeat interval, which is "
                    + sender.getChangeStreamHeartbeatMilliSeconds() / 1000
                    + " seconds. The change record received is: "
                    + changeStreamRecordBuilder.build());
          }
          sender.updateChangeStreamRecordReceivedTimestamp(currentChangeRecordReceivedTimestamp);
        }
        Status appendStatus = sender.appendChangeStreamRecord(changeStreamRecordBuilder.build());
        if (!appendStatus.isOk()) {
          return appendStatus;
        }
      }
      return sender.finishWithOK();
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      if (e instanceof DeadlineExceededException) {
        return sender.finishWithError(
            toStatus(
                SpannerExceptionFactory.newSpannerException(
                    ErrorCode.DEADLINE_EXCEEDED, "Deadline exceeded error: " + e)));
      } else if (e instanceof UnavailableException) {
        return toStatus(
            SpannerExceptionFactory.newSpannerException(ErrorCode.UNAVAILABLE, e.getMessage()));
      }
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, "Unexpected error: " + e)));
    }
  }

  /**
   * Execute action that start a read-write or read-only transaction. For read-write transaction,
   * see {@link ReadWriteTransaction}.
   */
  private Status executeStartTxn(
      StartTransactionAction action,
      DatabaseClient dbClient,
      OutcomeSender sender,
      ExecutionFlowContext executionContext) {
    try {
      executionContext.updateTransactionSeed(action.getTransactionSeed());
      Metadata metadata = new Metadata(action.getTableList());
      if (action.hasConcurrency()) {
        LOGGER.log(
            Level.INFO,
            String.format(
                "Starting read-only transaction %s\n", executionContext.getTransactionSeed()));
        executionContext.startReadOnlyTxn(
            dbClient, timestampBoundsFromConcurrency(action.getConcurrency()), metadata);
      } else {
        LOGGER.log(
            Level.INFO,
            "Starting read-write transaction %s\n",
            executionContext.getTransactionSeed());
        executionContext.startReadWriteTxn(dbClient, metadata, action.getExecutionOptions());
      }
      executionContext.setDatabaseClient(dbClient);
      executionContext.initReadState();
      return sender.finishWithOK();
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Unexpected error: " + e.getMessage());
      return sender.finishWithError(
          toStatus(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.INVALID_ARGUMENT, CloudClientExecutor.unexpectedExceptionResponse(e))));
    }
  }

  /**
   * Execute action that finish a transaction. For read-write transaction, either commit or abandon
   * the transaction is allowed. Batch transaction is not supported.
   */
  private Status executeFinishTxn(
      FinishTransactionAction action, OutcomeSender sender, ExecutionFlowContext executionContext) {
    LOGGER.log(
        Level.INFO,
        String.format(
            "Finishing transaction %s\n%s", executionContext.getTransactionSeed(), action));
    return executionContext.finish(action.getMode(), sender);
  }

  /** Execute mutation action request and buffer the mutations. */
  private Status executeMutation(
      MutationAction action,
      OutcomeSender sender,
      ExecutionFlowContext executionContext,
      boolean isWrite) {
    String prevTable = "";
    try {
      for (int i = 0; i < action.getModCount(); ++i) {
        Mod mod = action.getMod(i);
        String table = mod.getTable();
        if (table.isEmpty()) {
          table = prevTable;
        }
        if (table.isEmpty()) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT, "Table name missing: " + action);
        }
        prevTable = table;
        LOGGER.log(Level.FINE, String.format("Executing mutation mod: \n%s", mod));

        final List<Mutation> mutations = Lists.newArrayList();

        if (mod.hasInsert()) {
          InsertArgs insertArgs = mod.getInsert();
          for (int j = 0; j < insertArgs.getValuesCount(); ++j) {
            mutations.add(
                buildWrite(
                    insertArgs.getColumnList(),
                    cloudValuesFromValueList(insertArgs.getValues(j), insertArgs.getTypeList()),
                    Mutation.newInsertBuilder(table)));
          }
        } else if (mod.hasUpdate()) {
          UpdateArgs updateArgs = mod.getUpdate();
          for (int j = 0; j < updateArgs.getValuesCount(); ++j) {
            mutations.add(
                buildWrite(
                    updateArgs.getColumnList(),
                    cloudValuesFromValueList(updateArgs.getValues(j), updateArgs.getTypeList()),
                    Mutation.newUpdateBuilder(table)));
          }
        } else if (mod.hasInsertOrUpdate()) {
          InsertArgs insertArgs = mod.getInsertOrUpdate();
          for (int j = 0; j < insertArgs.getValuesCount(); ++j) {
            mutations.add(
                buildWrite(
                    insertArgs.getColumnList(),
                    cloudValuesFromValueList(insertArgs.getValues(j), insertArgs.getTypeList()),
                    Mutation.newInsertOrUpdateBuilder(table)));
          }
        } else if (mod.hasReplace()) {
          InsertArgs insertArgs = mod.getReplace();
          for (int j = 0; j < insertArgs.getValuesCount(); ++j) {
            mutations.add(
                buildWrite(
                    insertArgs.getColumnList(),
                    cloudValuesFromValueList(insertArgs.getValues(j), insertArgs.getTypeList()),
                    Mutation.newReplaceBuilder(table)));
          }
        } else if (mod.hasDeleteKeys()) {
          KeySet keySet =
              keySetProtoToCloudKeySet(
                  mod.getDeleteKeys(), executionContext.getKeyColumnTypes(table));
          mutations.add(Mutation.delete(table, keySet));
        } else {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT, "Unsupported mod: " + mod);
        }
        if (!isWrite) {
          executionContext.bufferMutations(mutations);
        } else {
          executionContext.getDbClient().write(mutations);
        }
      }
      return sender.finishWithOK();
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    }
  }

  /** Build a Mutation by using the given WriteBuilder to set the columns for the action. */
  private Mutation buildWrite(
      List<String> columnList, List<com.google.cloud.spanner.Value> valueList, WriteBuilder write) {
    Preconditions.checkState(columnList.size() == valueList.size());
    for (int i = 0; i < columnList.size(); i++) {
      write.set(columnList.get(i)).to(valueList.get(i));
    }
    return write.build();
  }

  /** Execute a read action request, store the results in the OutcomeSender. */
  private Status executeRead(
      boolean useMultiplexedSession,
      ReadAction action,
      OutcomeSender sender,
      ExecutionFlowContext executionContext) {
    try {
      LOGGER.log(
          Level.INFO,
          String.format("Executing read %s\n%s\n", executionContext.getTransactionSeed(), action));
      List<com.google.spanner.v1.Type> typeList = new ArrayList<>();
      if (action.hasIndex()) {
        // For index read, we assume the key columns are listed at the front of the read
        // column
        // list.
        for (int i = 0; i < action.getColumnCount(); ++i) {
          String col = action.getColumn(i);
          typeList.add(executionContext.getColumnType(action.getTable(), col));
        }
      } else {
        typeList = executionContext.getKeyColumnTypes(action.getTable());
      }
      KeySet keySet = keySetProtoToCloudKeySet(action.getKeys(), typeList);
      ReadContext txn = executionContext.getTransactionForRead();
      sender.initForRead(action.getTable(), action.getIndex());

      executionContext.startRead();
      LOGGER.log(
          Level.INFO,
          String.format(
              "Finish read building, ready to execute %s\n",
              executionContext.getTransactionSeed()));
      ResultSet result;
      if (action.hasIndex()) {
        result =
            txn.readUsingIndex(
                action.getTable(), action.getIndex(), keySet, action.getColumnList());
      } else {
        result = txn.read(action.getTable(), keySet, action.getColumnList());
      }
      LOGGER.log(
          Level.INFO,
          String.format("Parsing read result %s\n", executionContext.getTransactionSeed()));
      return processResults(
          useMultiplexedSession, result, action.getLimit(), sender, executionContext);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    }
  }

  /** Execute a query action request, store the results in the OutcomeSender. */
  private Status executeQuery(
      boolean useMultiplexedSession,
      QueryAction action,
      OutcomeSender sender,
      ExecutionFlowContext executionContext) {
    try {
      LOGGER.log(
          Level.INFO,
          String.format("Executing query %s\n%s\n", executionContext.getTransactionSeed(), action));
      ReadContext txn = executionContext.getTransactionForRead();
      sender.initForQuery();

      Statement.Builder stmt = Statement.newBuilder(action.getSql());
      for (int i = 0; i < action.getParamsCount(); ++i) {
        stmt.bind(action.getParams(i).getName())
            .to(
                valueProtoToCloudValue(
                    action.getParams(i).getType(), action.getParams(i).getValue()));
      }

      executionContext.startRead();
      LOGGER.log(
          Level.INFO,
          String.format(
              "Finish query building, ready to execute %s\n",
              executionContext.getTransactionSeed()));
      ResultSet result = txn.executeQuery(stmt.build(), Options.tag("query-tag"));
      LOGGER.log(
          Level.INFO,
          String.format("Parsing query result %s\n", executionContext.getTransactionSeed()));
      return processResults(useMultiplexedSession, result, 0, sender, executionContext);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    }
  }

  /** Execute a dml update action request, store the results in the OutcomeSender. */
  private Status executeCloudDmlUpdate(
      boolean useMultiplexedSession,
      DmlAction action,
      OutcomeSender sender,
      ExecutionFlowContext executionContext) {
    try {
      LOGGER.log(
          Level.INFO,
          String.format(
              "Executing Dml update %s\n%s\n", executionContext.getTransactionSeed(), action));
      QueryAction update = action.getUpdate();
      Statement.Builder stmt = Statement.newBuilder(update.getSql());
      for (int i = 0; i < update.getParamsCount(); ++i) {
        stmt.bind(update.getParams(i).getName())
            .to(
                valueProtoToCloudValue(
                    update.getParams(i).getType(), update.getParams(i).getValue()));
      }
      sender.initForQuery();
      ResultSet result =
          executionContext
              .getTransactionForWrite()
              .executeQuery(stmt.build(), Options.tag("dml-transaction-tag"));
      LOGGER.log(
          Level.INFO,
          String.format("Parsing Dml result %s\n", executionContext.getTransactionSeed()));
      return processResults(useMultiplexedSession, result, 0, sender, executionContext, true);
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    }
  }

  /** Execute a BatchDml update action request, store the results in the OutcomeSender. */
  private Status executeCloudBatchDmlUpdates(
      BatchDmlAction action, OutcomeSender sender, ExecutionFlowContext executionContext) {
    try {
      List<Statement> queries = new ArrayList<>();
      for (int i = 0; i < action.getUpdatesCount(); ++i) {
        LOGGER.log(
            Level.INFO,
            String.format(
                "Executing BatchDml update [%d] %s\n%s\n",
                i + 1, executionContext.getTransactionSeed(), action));
        QueryAction update = action.getUpdates(i);
        Statement.Builder stmt = Statement.newBuilder(update.getSql());
        for (int j = 0; j < update.getParamsCount(); ++j) {
          stmt.bind(update.getParams(j).getName())
              .to(
                  valueProtoToCloudValue(
                      update.getParams(j).getType(), update.getParams(j).getValue()));
        }
        queries.add(stmt.build());
      }
      long[] rowCounts = executionContext.executeBatchDml(queries);
      sender.initForQuery();
      for (long rowCount : rowCounts) {
        sender.appendRowsModifiedInDml(rowCount);
      }
      // The batchDml request failed. By design, `rowCounts` contains rows
      // modified for DML queries that succeeded only. Add 0 as the row count
      // for the last executed DML in the batch (that failed).
      if (rowCounts.length != queries.size()) {
        sender.appendRowsModifiedInDml(0L);
      }
      return sender.finishWithOK();
    } catch (SpannerException e) {
      return sender.finishWithError(toStatus(e));
    }
  }

  /** Process a ResultSet from a read/query and store the results in the OutcomeSender. */
  private Status processResults(
      boolean useMultiplexedSession,
      ResultSet results,
      int limit,
      OutcomeSender sender,
      ExecutionFlowContext executionContext) {
    return processResults(useMultiplexedSession, results, limit, sender, executionContext, false);
  }

  /** Process a ResultSet from a read/query/dml and store the results in the OutcomeSender. */
  private Status processResults(
      boolean useMultiplexedSession,
      ResultSet results,
      int limit,
      OutcomeSender sender,
      ExecutionFlowContext executionContext,
      boolean isDml) {
    try {
      int rowCount = 0;
      LOGGER.log(
          Level.INFO,
          String.format("Iterating result set: %s\n", executionContext.getTransactionSeed()));
      while (results.next()) {
        com.google.spanner.executor.v1.ValueList row =
            buildRow(results.getCurrentRowAsStruct(), sender);
        Status appendStatus = sender.appendRow(row);
        if (!appendStatus.isOk()) {
          return appendStatus;
        }
        ++rowCount;
        if (limit > 0 && rowCount >= limit) {
          LOGGER.log(Level.INFO, "Stopping at row limit: " + limit);
          break;
        }
      }
      if (isDml) {
        sender.appendRowsModifiedInDml(
            Objects.requireNonNull(results.getStats()).getRowCountExact());
      }

      LOGGER.log(
          Level.INFO,
          String.format(
              "Successfully processed result: %s\n", executionContext.getTransactionSeed()));
      executionContext.finishRead(Status.OK);
      return sender.finishWithOK();
    } catch (SpannerException e) {
      LOGGER.log(Level.WARNING, "Encountered exception: ", e);
      Status status = toStatus(e);
      LOGGER.log(
          Level.WARNING,
          String.format(
              "Encountered exception: %s %s\n",
              status.getDescription(), executionContext.getTransactionSeed()));
      executionContext.finishRead(status);
      if (status.getCode() == Status.ABORTED.getCode()) {
        return sender.finishWithTransactionRestarted();
      } else {
        if (status.getCode() == Status.UNAUTHENTICATED.getCode()) {
          try {
            LOGGER.log(
                Level.INFO,
                String.format(
                    "Found Unauthenticated error, client credentials:\n%s",
                    getClient(useMultiplexedSession).getOptions().getCredentials().toString()));
          } catch (Exception exception) {
            LOGGER.log(Level.WARNING, String.format("Failed to getClient %s", exception));
          }
        }
        return sender.finishWithError(status);
      }
    } finally {
      LOGGER.log(
          Level.INFO,
          String.format("Closing result set %s\n", executionContext.getTransactionSeed()));
      results.close();
    }
  }

  /** Convert a result row to a row proto(value list) for sending back to the client. */
  private com.google.spanner.executor.v1.ValueList buildRow(
      StructReader result, OutcomeSender sender) throws SpannerException {
    sender.setRowType(buildStructType(result));
    return buildStruct(result);
  }

  /** Construct a StructType for a given struct. This is used to set the row type. */
  private com.google.spanner.v1.StructType buildStructType(StructReader struct) {
    com.google.spanner.v1.StructType.Builder rowTypeBuilder =
        com.google.spanner.v1.StructType.newBuilder();
    for (int i = 0; i < struct.getColumnCount(); ++i) {
      com.google.cloud.spanner.Type columnType = struct.getColumnType(i);
      rowTypeBuilder.addFields(
          com.google.spanner.v1.StructType.Field.newBuilder()
              .setName(struct.getType().getStructFields().get(i).getName())
              .setType(cloudTypeToTypeProto(columnType))
              .build());
    }
    return rowTypeBuilder.build();
  }

  /** Convert a struct to a proto(value list) for constructing result rows and struct values. */
  private com.google.spanner.executor.v1.ValueList buildStruct(StructReader struct) {
    com.google.spanner.executor.v1.ValueList.Builder structBuilder =
        com.google.spanner.executor.v1.ValueList.newBuilder();
    for (int i = 0; i < struct.getColumnCount(); ++i) {
      com.google.cloud.spanner.Type columnType = struct.getColumnType(i);
      com.google.spanner.executor.v1.Value.Builder value =
          com.google.spanner.executor.v1.Value.newBuilder();
      if (struct.isNull(i)) {
        value.setIsNull(true);
      } else {
        switch (columnType.getCode()) {
          case BOOL:
            value.setBoolValue(struct.getBoolean(i));
            break;
          case FLOAT32:
            value.setDoubleValue((double) struct.getFloat(i));
            break;
          case FLOAT64:
            value.setDoubleValue(struct.getDouble(i));
            break;
          case INT64:
            value.setIntValue(struct.getLong(i));
            break;
          case STRING:
            value.setStringValue(struct.getString(i));
            break;
          case BYTES:
            value.setBytesValue(toByteString(struct.getBytes(i)));
            break;
          case TIMESTAMP:
            value.setTimestampValue(timestampToProto(struct.getTimestamp(i)));
            break;
          case DATE:
            value.setDateDaysValue(daysFromDate(struct.getDate(i)));
            break;
          case INTERVAL:
            value.setStringValue(struct.getInterval(i).toISO8601());
            break;
          case UUID:
            value.setStringValue(struct.getUuid(i).toString());
            break;
          case NUMERIC:
            String ascii = struct.getBigDecimal(i).toPlainString();
            value.setStringValue(ascii);
            break;
          case JSON:
            value.setStringValue(struct.getJson(i));
            break;
          case ARRAY:
            switch (struct.getColumnType(i).getArrayElementType().getCode()) {
              case BOOL:
                {
                  com.google.spanner.executor.v1.ValueList.Builder builder =
                      com.google.spanner.executor.v1.ValueList.newBuilder();
                  List<Boolean> values = struct.getBooleanList(i);
                  for (Boolean booleanValue : values) {
                    com.google.spanner.executor.v1.Value.Builder valueProto =
                        com.google.spanner.executor.v1.Value.newBuilder();
                    if (booleanValue == null) {
                      builder.addValue(valueProto.setIsNull(true).build());
                    } else {
                      builder.addValue(valueProto.setBoolValue(booleanValue).build());
                    }
                  }
                  value.setArrayValue(builder.build());
                  value.setArrayType(
                      com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.BOOL).build());
                }
                break;
              case FLOAT32:
                {
                  com.google.spanner.executor.v1.ValueList.Builder builder =
                      com.google.spanner.executor.v1.ValueList.newBuilder();
                  List<Float> values = struct.getFloatList(i);
                  for (Float floatValue : values) {
                    com.google.spanner.executor.v1.Value.Builder valueProto =
                        com.google.spanner.executor.v1.Value.newBuilder();
                    if (floatValue == null) {
                      builder.addValue(valueProto.setIsNull(true).build());
                    } else {
                      builder.addValue(valueProto.setDoubleValue((double) floatValue).build());
                    }
                  }
                  value.setArrayValue(builder.build());
                  value.setArrayType(
                      com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.FLOAT32).build());
                }
                break;
              case FLOAT64:
                {
                  com.google.spanner.executor.v1.ValueList.Builder builder =
                      com.google.spanner.executor.v1.ValueList.newBuilder();
                  List<Double> values = struct.getDoubleList(i);
                  for (Double doubleValue : values) {
                    com.google.spanner.executor.v1.Value.Builder valueProto =
                        com.google.spanner.executor.v1.Value.newBuilder();
                    if (doubleValue == null) {
                      builder.addValue(valueProto.setIsNull(true).build());
                    } else {
                      builder.addValue(valueProto.setDoubleValue(doubleValue).build());
                    }
                  }
                  value.setArrayValue(builder.build());
                  value.setArrayType(
                      com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.FLOAT64).build());
                }
                break;
              case INT64:
                {
                  com.google.spanner.executor.v1.ValueList.Builder builder =
                      com.google.spanner.executor.v1.ValueList.newBuilder();
                  List<Long> values = struct.getLongList(i);
                  for (Long longValue : values) {
                    com.google.spanner.executor.v1.Value.Builder valueProto =
                        com.google.spanner.executor.v1.Value.newBuilder();
                    if (longValue == null) {
                      builder.addValue(valueProto.setIsNull(true).build());
                    } else {
                      builder.addValue(valueProto.setIntValue(longValue).build());
                    }
                  }
                  value.setArrayValue(builder.build());
                  value.setArrayType(
                      com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.INT64).build());
                }
                break;
              case STRING:
                {
                  com.google.spanner.executor.v1.ValueList.Builder builder =
                      com.google.spanner.executor.v1.ValueList.newBuilder();
                  List<String> values = struct.getStringList(i);
                  for (String stringValue : values) {
                    com.google.spanner.executor.v1.Value.Builder valueProto =
                        com.google.spanner.executor.v1.Value.newBuilder();
                    if (stringValue == null) {
                      builder.addValue(valueProto.setIsNull(true).build());
                    } else {
                      builder.addValue(valueProto.setStringValue(stringValue)).build();
                    }
                  }
                  value.setArrayValue(builder.build());
                  value.setArrayType(
                      com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.STRING).build());
                }
                break;
              case BYTES:
                {
                  com.google.spanner.executor.v1.ValueList.Builder builder =
                      com.google.spanner.executor.v1.ValueList.newBuilder();
                  List<ByteArray> values = struct.getBytesList(i);
                  for (ByteArray byteArrayValue : values) {
                    com.google.spanner.executor.v1.Value.Builder valueProto =
                        com.google.spanner.executor.v1.Value.newBuilder();
                    if (byteArrayValue == null) {
                      builder.addValue(valueProto.setIsNull(true).build());
                    } else {
                      builder.addValue(
                          valueProto
                              .setBytesValue(ByteString.copyFrom(byteArrayValue.toByteArray()))
                              .build());
                    }
                  }
                  value.setArrayValue(builder.build());
                  value.setArrayType(
                      com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.BYTES).build());
                }
                break;
              case DATE:
                {
                  com.google.spanner.executor.v1.ValueList.Builder builder =
                      com.google.spanner.executor.v1.ValueList.newBuilder();
                  List<Date> values = struct.getDateList(i);
                  for (Date dateValue : values) {
                    com.google.spanner.executor.v1.Value.Builder valueProto =
                        com.google.spanner.executor.v1.Value.newBuilder();
                    if (dateValue == null) {
                      builder.addValue(valueProto.setIsNull(true).build());
                    } else {
                      builder.addValue(
                          valueProto.setDateDaysValue(daysFromDate(dateValue)).build());
                    }
                  }
                  value.setArrayValue(builder.build());
                  value.setArrayType(
                      com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.DATE).build());
                }
                break;
              case TIMESTAMP:
                {
                  com.google.spanner.executor.v1.ValueList.Builder builder =
                      com.google.spanner.executor.v1.ValueList.newBuilder();
                  List<Timestamp> values = struct.getTimestampList(i);
                  for (Timestamp timestampValue : values) {
                    com.google.spanner.executor.v1.Value.Builder valueProto =
                        com.google.spanner.executor.v1.Value.newBuilder();
                    if (timestampValue == null) {
                      builder.addValue(valueProto.setIsNull(true).build());
                    } else {
                      builder.addValue(
                          valueProto.setTimestampValue(timestampToProto(timestampValue)).build());
                    }
                  }
                  value.setArrayValue(builder.build());
                  value.setArrayType(
                      com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.TIMESTAMP).build());
                }
                break;
              case INTERVAL:
                {
                  com.google.spanner.executor.v1.ValueList.Builder builder =
                      com.google.spanner.executor.v1.ValueList.newBuilder();
                  List<Interval> values = struct.getIntervalList(i);
                  for (Interval interval : values) {
                    com.google.spanner.executor.v1.Value.Builder valueProto =
                        com.google.spanner.executor.v1.Value.newBuilder();
                    if (interval == null) {
                      builder.addValue(valueProto.setIsNull(true).build());
                    } else {
                      builder.addValue(valueProto.setStringValue(interval.toISO8601()).build());
                    }
                  }
                  value.setArrayValue(builder.build());
                  value.setArrayType(
                      com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.INTERVAL).build());
                }
                break;
              case UUID:
                {
                  com.google.spanner.executor.v1.ValueList.Builder builder =
                      com.google.spanner.executor.v1.ValueList.newBuilder();
                  List<UUID> values = struct.getUuidList(i);
                  for (UUID uuidValue : values) {
                    com.google.spanner.executor.v1.Value.Builder valueProto =
                        com.google.spanner.executor.v1.Value.newBuilder();
                    if (uuidValue == null) {
                      builder.addValue(valueProto.setIsNull(true).build());
                    } else {
                      builder.addValue(valueProto.setStringValue(uuidValue.toString()).build());
                    }
                  }
                  value.setArrayValue(builder.build());
                  value.setArrayType(
                      com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.UUID).build());
                }
                break;
              case NUMERIC:
                {
                  com.google.spanner.executor.v1.ValueList.Builder builder =
                      com.google.spanner.executor.v1.ValueList.newBuilder();
                  List<BigDecimal> values = struct.getBigDecimalList(i);
                  for (BigDecimal bigDec : values) {
                    com.google.spanner.executor.v1.Value.Builder valueProto =
                        com.google.spanner.executor.v1.Value.newBuilder();
                    if (bigDec == null) {
                      builder.addValue(valueProto.setIsNull(true).build());
                    } else {
                      builder.addValue(valueProto.setStringValue(bigDec.toPlainString()).build());
                    }
                  }
                  value.setArrayValue(builder.build());
                  value.setArrayType(
                      com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.NUMERIC).build());
                }
                break;
              case JSON:
                {
                  com.google.spanner.executor.v1.ValueList.Builder builder =
                      com.google.spanner.executor.v1.ValueList.newBuilder();
                  List<String> values = struct.getJsonList(i);
                  for (String stringValue : values) {
                    com.google.spanner.executor.v1.Value.Builder valueProto =
                        com.google.spanner.executor.v1.Value.newBuilder();
                    if (stringValue == null) {
                      builder.addValue(valueProto.setIsNull(true).build());
                    } else {
                      builder.addValue(valueProto.setStringValue(stringValue)).build();
                    }
                  }
                  value.setArrayValue(builder.build());
                  value.setArrayType(
                      com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.JSON).build());
                }
                break;
              case STRUCT:
                {
                  com.google.spanner.executor.v1.ValueList.Builder builder =
                      com.google.spanner.executor.v1.ValueList.newBuilder();
                  List<Struct> values = struct.getStructList(i);
                  for (StructReader structValue : values) {
                    com.google.spanner.executor.v1.Value.Builder valueProto =
                        com.google.spanner.executor.v1.Value.newBuilder();
                    if (structValue == null) {
                      builder.addValue(valueProto.setIsNull(true).build());
                    } else {
                      builder.addValue(valueProto.setStructValue(buildStruct(structValue))).build();
                    }
                  }
                  value.setArrayValue(builder.build());
                  value.setArrayType(
                      com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.STRUCT).build());
                }
                break;
              default:
                throw SpannerExceptionFactory.newSpannerException(
                    ErrorCode.INVALID_ARGUMENT,
                    "Unsupported row array type: "
                        + struct.getColumnType(i)
                        + " for result type "
                        + struct.getType().toString());
            }
            break;
          default:
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT,
                "Unsupported row type: "
                    + struct.getColumnType(i)
                    + " for result type "
                    + struct.getType().toString());
        }
      }
      structBuilder.addValue(value.build());
    }
    ;
    return structBuilder.build();
  }

  /** Convert a ListValue proto to a list of cloud Value. */
  private static List<com.google.cloud.spanner.Value> cloudValuesFromValueList(
      com.google.spanner.executor.v1.ValueList valueList, List<com.google.spanner.v1.Type> typeList)
      throws SpannerException {
    LOGGER.log(Level.INFO, String.format("Converting valueList: %s\n", valueList));
    Preconditions.checkState(valueList.getValueCount() == typeList.size());
    List<com.google.cloud.spanner.Value> cloudValues = new ArrayList<>();
    for (int i = 0; i < valueList.getValueCount(); ++i) {
      com.google.cloud.spanner.Value value =
          valueProtoToCloudValue(typeList.get(i), valueList.getValue(i));
      cloudValues.add(value);
    }
    return cloudValues;
  }

  /** Convert a proto KeySet to a cloud KeySet. */
  private static com.google.cloud.spanner.KeySet keySetProtoToCloudKeySet(
      com.google.spanner.executor.v1.KeySet keySetProto, List<com.google.spanner.v1.Type> typeList)
      throws SpannerException {
    if (keySetProto.getAll()) {
      return com.google.cloud.spanner.KeySet.all();
    }
    com.google.cloud.spanner.KeySet.Builder cloudKeySetBuilder =
        com.google.cloud.spanner.KeySet.newBuilder();
    for (int i = 0; i < keySetProto.getPointCount(); ++i) {
      cloudKeySetBuilder.addKey(keyProtoToCloudKey(keySetProto.getPoint(i), typeList));
    }
    for (int i = 0; i < keySetProto.getRangeCount(); ++i) {
      cloudKeySetBuilder.addRange(keyRangeProtoToCloudKeyRange(keySetProto.getRange(i), typeList));
    }
    return cloudKeySetBuilder.build();
  }

  /** Convert a keyRange proto to a cloud KeyRange. */
  private static com.google.cloud.spanner.KeyRange keyRangeProtoToCloudKeyRange(
      com.google.spanner.executor.v1.KeyRange keyRangeProto,
      List<com.google.spanner.v1.Type> typeList)
      throws SpannerException {
    Key start = keyProtoToCloudKey(keyRangeProto.getStart(), typeList);
    Key end = keyProtoToCloudKey(keyRangeProto.getLimit(), typeList);
    if (!keyRangeProto.hasType()) {
      // default
      return KeyRange.closedOpen(start, end);
    }
    switch (keyRangeProto.getType()) {
      case CLOSED_CLOSED:
        return KeyRange.closedClosed(start, end);
      case CLOSED_OPEN:
        return KeyRange.closedOpen(start, end);
      case OPEN_CLOSED:
        return KeyRange.openClosed(start, end);
      case OPEN_OPEN:
        return KeyRange.openOpen(start, end);
      // Unreachable.
      default:
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "Unrecognized key range type");
    }
  }

  /** Convert a key proto(value list) to a cloud Key. */
  private static com.google.cloud.spanner.Key keyProtoToCloudKey(
      com.google.spanner.executor.v1.ValueList keyProto, List<com.google.spanner.v1.Type> typeList)
      throws SpannerException {
    com.google.cloud.spanner.Key.Builder cloudKey = com.google.cloud.spanner.Key.newBuilder();
    if (typeList.size() < keyProto.getValueCount()) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT,
          "There's more key parts in " + keyProto + " than column types in " + typeList);
    }

    for (int i = 0; i < keyProto.getValueCount(); ++i) {
      com.google.spanner.v1.Type type = typeList.get(i);
      com.google.spanner.executor.v1.Value part = keyProto.getValue(i);
      if (part.hasIsNull()) {
        switch (type.getCode()) {
          case BOOL:
          case INT64:
          case STRING:
          case BYTES:
          case FLOAT64:
          case DATE:
          case UUID:
          case TIMESTAMP:
          case NUMERIC:
          case JSON:
            cloudKey.appendObject(null);
            break;
          default:
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT,
                "Unsupported null key part type: " + type.getCode().name());
        }
      } else if (part.hasIntValue()) {
        cloudKey.append(part.getIntValue());
      } else if (part.hasBoolValue()) {
        cloudKey.append(part.getBoolValue());
      } else if (part.hasDoubleValue()) {
        cloudKey.append(part.getDoubleValue());
      } else if (part.hasBytesValue()) {
        switch (type.getCode()) {
          case STRING:
            cloudKey.append(part.getBytesValue().toStringUtf8());
            break;
          case BYTES:
            cloudKey.append(toByteArray(part.getBytesValue()));
            break;
          // Unreachable
          default:
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT, "Unsupported key part type: " + type.getCode().name());
        }
      } else if (part.hasStringValue()) {
        if (type.getCode() == TypeCode.NUMERIC) {
          String ascii = part.getStringValue();
          cloudKey.append(new BigDecimal(ascii));
        } else if (type.getCode() == TypeCode.UUID) {
          cloudKey.append(UUID.fromString(part.getStringValue()));
        } else {
          cloudKey.append(part.getStringValue());
        }
      } else if (part.hasTimestampValue()) {
        cloudKey.append(Timestamp.parseTimestamp(Timestamps.toString(part.getTimestampValue())));
      } else if (part.hasDateDaysValue()) {
        cloudKey.append(dateFromDays(part.getDateDaysValue()));
      } else {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "Unsupported key part: " + part);
      }
    }
    return cloudKey.build();
  }

  /** Convert a Value proto to a cloud Value. */
  @SuppressWarnings("NullTernary")
  private static com.google.cloud.spanner.Value valueProtoToCloudValue(
      com.google.spanner.v1.Type type, com.google.spanner.executor.v1.Value value) {
    if (value.hasIsCommitTimestamp() && value.getIsCommitTimestamp()) {
      return Value.timestamp(com.google.cloud.spanner.Value.COMMIT_TIMESTAMP);
    }
    switch (type.getCode()) {
      case INT64:
        return com.google.cloud.spanner.Value.int64(value.hasIsNull() ? null : value.getIntValue());
      case FLOAT32:
        return com.google.cloud.spanner.Value.float32(
            value.hasIsNull() ? null : (float) value.getDoubleValue());
      case FLOAT64:
        return com.google.cloud.spanner.Value.float64(
            value.hasIsNull() ? null : value.getDoubleValue());
      case STRING:
        return com.google.cloud.spanner.Value.string(
            value.hasIsNull() ? null : value.getStringValue());
      case BYTES:
        return com.google.cloud.spanner.Value.bytes(
            value.hasIsNull() ? null : ByteArray.copyFrom(value.getBytesValue().toByteArray()));
      case BOOL:
        return com.google.cloud.spanner.Value.bool(value.hasIsNull() ? null : value.getBoolValue());
      case TIMESTAMP:
        if (value.hasIsNull()) {
          return com.google.cloud.spanner.Value.timestamp(null);
        } else {
          if (!value.hasBytesValue()) {
            return com.google.cloud.spanner.Value.timestamp(
                Timestamp.parseTimestamp(Timestamps.toString(value.getTimestampValue())));
          } else {
            return com.google.cloud.spanner.Value.timestamp(
                com.google.cloud.spanner.Value.COMMIT_TIMESTAMP);
          }
        }
      case DATE:
        return com.google.cloud.spanner.Value.date(
            value.hasIsNull() ? null : dateFromDays(value.getDateDaysValue()));
      case INTERVAL:
        return com.google.cloud.spanner.Value.interval(
            value.hasIsNull() ? null : Interval.parseFromString(value.getStringValue()));
      case UUID:
        return com.google.cloud.spanner.Value.uuid(
            value.hasIsNull() ? null : UUID.fromString(value.getStringValue()));
      case NUMERIC:
        {
          if (value.hasIsNull()) {
            return com.google.cloud.spanner.Value.numeric(null);
          }
          String ascii = value.getStringValue();
          return com.google.cloud.spanner.Value.numeric(new BigDecimal(ascii));
        }
      case JSON:
        return com.google.cloud.spanner.Value.json(
            value.hasIsNull() ? null : value.getStringValue());
      case STRUCT:
        return com.google.cloud.spanner.Value.struct(
            typeProtoToCloudType(type),
            value.hasIsNull() ? null : structProtoToCloudStruct(type, value.getStructValue()));
      case ARRAY:
        switch (type.getArrayElementType().getCode()) {
          case INT64:
            if (value.hasIsNull()) {
              return com.google.cloud.spanner.Value.int64Array((Iterable<Long>) null);
            } else {
              return com.google.cloud.spanner.Value.int64Array(
                  unmarshallValueList(
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getIsNull)
                          .collect(Collectors.toList()),
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getIntValue)
                          .collect(Collectors.toList())));
            }
          case FLOAT32:
            if (value.hasIsNull()) {
              return com.google.cloud.spanner.Value.float32Array((Iterable<Float>) null);
            } else {
              return com.google.cloud.spanner.Value.float32Array(
                  unmarshallValueList(
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getIsNull)
                          .collect(Collectors.toList()),
                      value.getArrayValue().getValueList().stream()
                          .map(v -> (float) v.getDoubleValue())
                          .collect(Collectors.toList())));
            }
          case FLOAT64:
            if (value.hasIsNull()) {
              return com.google.cloud.spanner.Value.float64Array((Iterable<Double>) null);
            } else {
              return com.google.cloud.spanner.Value.float64Array(
                  unmarshallValueList(
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getIsNull)
                          .collect(Collectors.toList()),
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getDoubleValue)
                          .collect(Collectors.toList())));
            }
          case STRING:
            if (value.hasIsNull()) {
              return com.google.cloud.spanner.Value.stringArray(null);
            } else {
              return com.google.cloud.spanner.Value.stringArray(
                  unmarshallValueList(
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getIsNull)
                          .collect(Collectors.toList()),
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getStringValue)
                          .collect(Collectors.toList())));
            }
          case BYTES:
            if (value.hasIsNull()) {
              return com.google.cloud.spanner.Value.bytesArray(null);
            } else {
              return com.google.cloud.spanner.Value.bytesArray(
                  unmarshallValueList(
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getIsNull)
                          .collect(Collectors.toList()),
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getBytesValue)
                          .collect(Collectors.toList()),
                      element -> ByteArray.copyFrom(element.toByteArray())));
            }
          case BOOL:
            if (value.hasIsNull()) {
              return com.google.cloud.spanner.Value.boolArray((Iterable<Boolean>) null);
            } else {
              return com.google.cloud.spanner.Value.boolArray(
                  unmarshallValueList(
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getIsNull)
                          .collect(Collectors.toList()),
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getBoolValue)
                          .collect(Collectors.toList())));
            }
          case TIMESTAMP:
            if (value.hasIsNull()) {
              return com.google.cloud.spanner.Value.timestampArray(null);
            } else {
              return com.google.cloud.spanner.Value.timestampArray(
                  unmarshallValueList(
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getIsNull)
                          .collect(Collectors.toList()),
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getTimestampValue)
                          .collect(Collectors.toList()),
                      element -> Timestamp.parseTimestamp(Timestamps.toString(element))));
            }
          case DATE:
            if (value.hasIsNull()) {
              return com.google.cloud.spanner.Value.dateArray(null);
            } else {
              return com.google.cloud.spanner.Value.dateArray(
                  unmarshallValueList(
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getIsNull)
                          .collect(Collectors.toList()),
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getDateDaysValue)
                          .collect(Collectors.toList()),
                      CloudClientExecutor::dateFromDays));
            }
          case INTERVAL:
            if (value.hasIsNull()) {
              return com.google.cloud.spanner.Value.intervalArray(null);
            } else {
              return com.google.cloud.spanner.Value.intervalArray(
                  unmarshallValueList(
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getIsNull)
                          .collect(Collectors.toList()),
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getStringValue)
                          .collect(Collectors.toList()),
                      Interval::parseFromString));
            }
          case UUID:
            if (value.hasIsNull()) {
              return com.google.cloud.spanner.Value.uuidArray(null);
            } else {
              return com.google.cloud.spanner.Value.uuidArray(
                  unmarshallValueList(
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getIsNull)
                          .collect(Collectors.toList()),
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getStringValue)
                          .collect(Collectors.toList()),
                      UUID::fromString));
            }
          case NUMERIC:
            {
              if (value.hasIsNull()) {
                return com.google.cloud.spanner.Value.numericArray(null);
              }
              List<Boolean> nullList =
                  value.getArrayValue().getValueList().stream()
                      .map(com.google.spanner.executor.v1.Value::getIsNull)
                      .collect(Collectors.toList());
              List<String> valueList =
                  value.getArrayValue().getValueList().stream()
                      .map(com.google.spanner.executor.v1.Value::getStringValue)
                      .collect(Collectors.toList());
              List<BigDecimal> newValueList = new ArrayList<>(valueList.size());

              for (int i = 0; i < valueList.size(); ++i) {
                if (i < nullList.size() && nullList.get(i)) {
                  newValueList.add(null);
                  continue;
                }
                String ascii = valueList.get(i);
                newValueList.add(new BigDecimal(ascii));
              }
              return com.google.cloud.spanner.Value.numericArray(newValueList);
            }
          case STRUCT:
            com.google.cloud.spanner.Type elementType =
                typeProtoToCloudType(type.getArrayElementType());
            if (value.hasIsNull()) {
              return com.google.cloud.spanner.Value.structArray(elementType, null);
            } else {
              return com.google.cloud.spanner.Value.structArray(
                  elementType,
                  unmarshallValueList(
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getIsNull)
                          .collect(Collectors.toList()),
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getStructValue)
                          .collect(Collectors.toList()),
                      element -> structProtoToCloudStruct(type.getArrayElementType(), element)));
            }
          case JSON:
            if (value.hasIsNull()) {
              return com.google.cloud.spanner.Value.jsonArray(null);
            } else {
              return com.google.cloud.spanner.Value.jsonArray(
                  unmarshallValueList(
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getIsNull)
                          .collect(Collectors.toList()),
                      value.getArrayValue().getValueList().stream()
                          .map(com.google.spanner.executor.v1.Value::getStringValue)
                          .collect(Collectors.toList())));
            }
          default:
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT,
                "Unsupported array element type while converting from value proto: "
                    + type.getArrayElementType().getCode().name());
        }
    }
    // Unreachable
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT, "Unsupported type while converting from value proto: " + type);
  }

  /** Convert a cloud Timestamp to a Timestamp proto. */
  private com.google.protobuf.Timestamp timestampToProto(Timestamp t) throws SpannerException {
    try {
      return Timestamps.parse(t.toString());
    } catch (ParseException e) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT, "Timestamp parse error", e);
    }
  }

  /** Convert a cloud Date to a Date proto. */
  private static int daysFromDate(Date date) {
    return (int) LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth()).toEpochDay();
  }

  /** Convert a Date proto to a cloud Date. */
  private static Date dateFromDays(int daysSinceEpoch) {
    LocalDate localDate = LocalDate.ofEpochDay(daysSinceEpoch);
    return Date.fromYearMonthDay(
        localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
  }

  @Nullable
  private static ByteString toByteString(@Nullable ByteArray byteArray) {
    if (byteArray == null) {
      return null;
    }
    return ByteString.copyFrom(byteArray.toByteArray());
  }

  @Nullable
  private static ByteArray toByteArray(@Nullable ByteString byteString) {
    if (byteString == null) {
      return null;
    }
    return ByteArray.copyFrom(byteString.toByteArray());
  }

  /** Convert a list of nullable value to another type. */
  private static <S, T> List<T> unmarshallValueList(
      List<Boolean> isNullList, List<S> valueList, Function<S, T> converter) {
    List<T> newValueList = new ArrayList<>(valueList.size());
    if (isNullList.isEmpty()) {
      for (S value : valueList) {
        newValueList.add(converter.apply(value));
      }
    } else {
      for (int i = 0; i < valueList.size(); ++i) {
        newValueList.add(isNullList.get(i) ? null : converter.apply(valueList.get(i)));
      }
    }
    return newValueList;
  }

  /** Insert null into valueList according to isNullList. */
  private static <S> List<S> unmarshallValueList(List<Boolean> isNullList, List<S> valueList) {
    return unmarshallValueList(isNullList, valueList, element -> element);
  }

  /** Convert a Struct proto to a cloud Struct. */
  private static com.google.cloud.spanner.Struct structProtoToCloudStruct(
      com.google.spanner.v1.Type type, com.google.spanner.executor.v1.ValueList structValue) {
    List<com.google.spanner.executor.v1.Value> fieldValues = structValue.getValueList();
    List<StructType.Field> fieldTypes = type.getStructType().getFieldsList();

    if (fieldTypes.size() != fieldValues.size()) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT,
          "Mismatch between number of expected fields and specified values for struct type");
    }

    com.google.cloud.spanner.Struct.Builder builder = com.google.cloud.spanner.Struct.newBuilder();
    for (int i = 0; i < fieldTypes.size(); ++i) {
      builder
          .set(fieldTypes.get(i).getName())
          .to(valueProtoToCloudValue(fieldTypes.get(i).getType(), fieldValues.get(i)));
    }
    return builder.build();
  }

  /** Convert a Type proto to a cloud Type. */
  private static com.google.cloud.spanner.Type typeProtoToCloudType(
      com.google.spanner.v1.Type typeProto) {
    switch (typeProto.getCode()) {
      case BOOL:
        return com.google.cloud.spanner.Type.bool();
      case INT64:
        return com.google.cloud.spanner.Type.int64();
      case STRING:
        return com.google.cloud.spanner.Type.string();
      case BYTES:
        return com.google.cloud.spanner.Type.bytes();
      case FLOAT32:
        return com.google.cloud.spanner.Type.float32();
      case FLOAT64:
        return com.google.cloud.spanner.Type.float64();
      case DATE:
        return com.google.cloud.spanner.Type.date();
      case TIMESTAMP:
        return com.google.cloud.spanner.Type.timestamp();
      case INTERVAL:
        return com.google.cloud.spanner.Type.interval();
      case UUID:
        return com.google.cloud.spanner.Type.uuid();
      case NUMERIC:
        if (typeProto.getTypeAnnotation().equals(TypeAnnotationCode.PG_NUMERIC)) {
          return com.google.cloud.spanner.Type.pgNumeric();
        } else {
          return com.google.cloud.spanner.Type.numeric();
        }
      case STRUCT:
        List<StructType.Field> fields = typeProto.getStructType().getFieldsList();
        List<com.google.cloud.spanner.Type.StructField> cloudFields = new ArrayList<>();
        for (StructType.Field field : fields) {
          com.google.cloud.spanner.Type fieldType = typeProtoToCloudType(field.getType());
          cloudFields.add(com.google.cloud.spanner.Type.StructField.of(field.getName(), fieldType));
        }
        return com.google.cloud.spanner.Type.struct(cloudFields);
      case ARRAY:
        com.google.spanner.v1.Type elementType = typeProto.getArrayElementType();
        if (elementType.getCode() == TypeCode.ARRAY) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT, "Unsupported array-of-array proto type");
        } else {
          com.google.cloud.spanner.Type cloudElementType = typeProtoToCloudType(elementType);
          return com.google.cloud.spanner.Type.array(cloudElementType);
        }
      case JSON:
        if (typeProto.getTypeAnnotation().equals(TypeAnnotationCode.PG_JSONB)) {
          return com.google.cloud.spanner.Type.pgJsonb();
        } else {
          return com.google.cloud.spanner.Type.json();
        }
      default:
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "Unsupported proto type: " + typeProto);
    }
  }

  /** Convert a cloud Type to a Type proto. */
  private static com.google.spanner.v1.Type cloudTypeToTypeProto(@Nonnull Type cloudTypeProto) {
    switch (cloudTypeProto.getCode()) {
      case BOOL:
        return com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.BOOL).build();
      case INT64:
        return com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.INT64).build();
      case FLOAT32:
        return com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.FLOAT32).build();
      case FLOAT64:
        return com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.FLOAT64).build();
      case STRING:
        return com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.STRING).build();
      case BYTES:
        return com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.BYTES).build();
      case TIMESTAMP:
        return com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.TIMESTAMP).build();
      case DATE:
        return com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.DATE).build();
      case INTERVAL:
        return com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.INTERVAL).build();
      case UUID:
        return com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.UUID).build();
      case NUMERIC:
        return com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.NUMERIC).build();
      case PG_NUMERIC:
        return com.google.spanner.v1.Type.newBuilder()
            .setCode(TypeCode.NUMERIC)
            .setTypeAnnotation(TypeAnnotationCode.PG_NUMERIC)
            .build();
      case STRUCT:
        com.google.spanner.v1.StructType.Builder StructDescriptorBuilder =
            com.google.spanner.v1.StructType.newBuilder();
        for (com.google.cloud.spanner.Type.StructField cloudField :
            cloudTypeProto.getStructFields()) {
          StructDescriptorBuilder.addFields(
              com.google.spanner.v1.StructType.Field.newBuilder()
                  .setName(cloudField.getName())
                  .setType(cloudTypeToTypeProto(cloudField.getType())));
        }
        return com.google.spanner.v1.Type.newBuilder()
            .setCode(TypeCode.STRUCT)
            .setStructType(StructDescriptorBuilder.build())
            .build();
      case ARRAY:
        if (cloudTypeProto.getArrayElementType().getCode()
            == com.google.cloud.spanner.Type.Code.ARRAY) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT, "Unsupported array-of-array cloud type");
        } else {
          return com.google.spanner.v1.Type.newBuilder()
              .setCode(TypeCode.ARRAY)
              .setArrayElementType(cloudTypeToTypeProto(cloudTypeProto.getArrayElementType()))
              .build();
        }
      case JSON:
        return com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.JSON).build();
      case PG_JSONB:
        return com.google.spanner.v1.Type.newBuilder()
            .setCode(TypeCode.JSON)
            .setTypeAnnotation(TypeAnnotationCode.PG_JSONB)
            .build();
      default:
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "Unsupported cloud type: " + cloudTypeProto);
    }
  }

  /** Unmarshall ByteString to serializable object. */
  private <T extends Serializable> T unmarshall(ByteString input)
      throws IOException, ClassNotFoundException {
    ObjectInputStream objectInputStream = new ObjectInputStream(input.newInput());
    return (T) objectInputStream.readObject();
  }

  /** Marshall a serializable object into ByteString. */
  private <T extends Serializable> ByteString marshall(T object) throws IOException {
    ByteString.Output output = ByteString.newOutput();
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(output);
    objectOutputStream.writeObject(object);
    objectOutputStream.flush();
    objectOutputStream.close();
    return output.toByteString();
  }

  /** Build Timestamp from micros. */
  private Timestamp timestampFromMicros(long micros) {
    long seconds = TimeUnit.MICROSECONDS.toSeconds(micros);
    int nanos = (int) (micros * 1000 - seconds * 1000000000);
    return Timestamp.ofTimeSecondsAndNanos(seconds, nanos);
  }

  /** Build TimestampBound from Concurrency. */
  private TimestampBound timestampBoundsFromConcurrency(Concurrency concurrency) {
    if (concurrency.hasStalenessSeconds()) {
      return TimestampBound.ofExactStaleness(
          (long) (concurrency.getStalenessSeconds() * 1000000), TimeUnit.MICROSECONDS);
    } else if (concurrency.hasMinReadTimestampMicros()) {
      return TimestampBound.ofMinReadTimestamp(
          timestampFromMicros(concurrency.getMinReadTimestampMicros()));
    } else if (concurrency.hasMaxStalenessSeconds()) {
      return TimestampBound.ofMaxStaleness(
          (long) (concurrency.getMaxStalenessSeconds() * 1000000), TimeUnit.MICROSECONDS);
    } else if (concurrency.hasExactTimestampMicros()) {
      return TimestampBound.ofReadTimestamp(
          timestampFromMicros(concurrency.getExactTimestampMicros()));
    } else if (concurrency.hasStrong()) {
      return TimestampBound.strong();
    } else if (concurrency.hasBatch()) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT,
          "batch mode should not be in snapshot transaction: " + concurrency);
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT, "Unsupported concurrency mode: " + concurrency);
  }

  /** Build instance proto from cloud spanner instance. */
  private com.google.spanner.admin.instance.v1.Instance instanceToProto(Instance instance) {
    com.google.spanner.admin.instance.v1.Instance.Builder instanceBuilder =
        com.google.spanner.admin.instance.v1.Instance.newBuilder();
    instanceBuilder
        .setConfig(instance.getInstanceConfigId().getInstanceConfig())
        .setName(instance.getId().getName())
        .setDisplayName(instance.getDisplayName())
        .setCreateTime(instance.getCreateTime().toProto())
        .setNodeCount(instance.getNodeCount())
        .setProcessingUnits(instance.getProcessingUnits())
        .setUpdateTime(instance.getUpdateTime().toProto())
        .putAllLabels(instance.getLabels());
    com.google.spanner.admin.instance.v1.Instance.State state;
    switch (instance.getState()) {
      case UNSPECIFIED:
        state = State.STATE_UNSPECIFIED;
        break;
      case CREATING:
        state = State.CREATING;
        break;
      case READY:
        state = State.READY;
        break;
      default:
        throw new IllegalArgumentException("Unknown state:" + instance.getState());
    }
    instanceBuilder.setState(state);
    return instanceBuilder.build();
  }

  /** Build instance proto from cloud spanner instance. */
  private com.google.spanner.admin.instance.v1.InstanceConfig instanceConfigToProto(
      InstanceConfig instanceConfig) {
    com.google.spanner.admin.instance.v1.InstanceConfig.Builder instanceConfigBuilder =
        com.google.spanner.admin.instance.v1.InstanceConfig.newBuilder();
    instanceConfigBuilder
        .setDisplayName(instanceConfig.getDisplayName())
        .setEtag(instanceConfig.getEtag())
        .setName(instanceConfig.getId().getName())
        .addAllLeaderOptions(instanceConfig.getLeaderOptions())
        .addAllOptionalReplicas(
            instanceConfig.getOptionalReplicas().stream()
                .map(ReplicaInfo::getProto)
                .collect(Collectors.toList()))
        .addAllReplicas(
            instanceConfig.getReplicas().stream()
                .map(ReplicaInfo::getProto)
                .collect(Collectors.toList()))
        .putAllLabels(instanceConfig.getLabels())
        .setReconciling(instanceConfig.getReconciling());
    com.google.spanner.admin.instance.v1.InstanceConfig.State state;
    switch (instanceConfig.getState()) {
      case STATE_UNSPECIFIED:
        state = com.google.spanner.admin.instance.v1.InstanceConfig.State.STATE_UNSPECIFIED;
        break;
      case CREATING:
        state = com.google.spanner.admin.instance.v1.InstanceConfig.State.CREATING;
        break;
      case READY:
        state = com.google.spanner.admin.instance.v1.InstanceConfig.State.READY;
        break;
      default:
        throw new IllegalArgumentException("Unknown state:" + instanceConfig.getState());
    }
    instanceConfigBuilder.setState(state);
    com.google.spanner.admin.instance.v1.InstanceConfig.Type type;
    switch (instanceConfig.getConfigType()) {
      case TYPE_UNSPECIFIED:
        type = com.google.spanner.admin.instance.v1.InstanceConfig.Type.TYPE_UNSPECIFIED;
        break;
      case GOOGLE_MANAGED:
        type = com.google.spanner.admin.instance.v1.InstanceConfig.Type.GOOGLE_MANAGED;
        break;
      case USER_MANAGED:
        type = com.google.spanner.admin.instance.v1.InstanceConfig.Type.USER_MANAGED;
        break;
      default:
        throw new IllegalArgumentException("Unknown type:" + instanceConfig.getConfigType());
    }
    instanceConfigBuilder.setConfigType(type);
    if (instanceConfig.getBaseConfig() != null) {
      instanceConfigBuilder.setBaseConfig(instanceConfig.getBaseConfig().getId().getName());
    }
    return instanceConfigBuilder.build();
  }
}
