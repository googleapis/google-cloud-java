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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.ReadContext;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionManager;
import com.google.cloud.spanner.Type.Code;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.cloud.spanner.jdbc.TransactionRetryListener.RetryResult;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.hash.PrimitiveSink;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Transaction that is used when a {@link Connection} is normal read/write mode (i.e. not autocommit
 * and not read-only). These transactions can be automatically retried if an {@link
 * AbortedException} is thrown. The transaction will keep track of a running checksum of all {@link
 * ResultSet}s that have been returned, and the update counts returned by any DML statement executed
 * during the transaction. As long as these checksums and update counts are equal for both the
 * original transaction and the retried transaction, the retry can safely be assumed to have the
 * exact same results as the original transaction.
 */
class ReadWriteTransaction extends AbstractMultiUseTransaction {
  private static final Logger logger = Logger.getLogger(ReadWriteTransaction.class.getName());
  private static final AtomicLong ID_GENERATOR = new AtomicLong();
  private static final String MAX_INTERNAL_RETRIES_EXCEEDED =
      "Internal transaction retry maximum exceeded";
  private static final int MAX_INTERNAL_RETRIES = 50;
  private final long transactionId;
  private final DatabaseClient dbClient;
  private TransactionManager txManager;
  private final boolean retryAbortsInternally;
  private int transactionRetryAttempts;
  private int successfulRetries;
  private final List<TransactionRetryListener> transactionRetryListeners;
  private volatile TransactionContext txContext;
  private volatile UnitOfWorkState state = UnitOfWorkState.STARTED;
  private boolean timedOutOrCancelled = false;
  private final List<RetriableStatement> statements = new ArrayList<>();
  private final List<Mutation> mutations = new ArrayList<>();
  private Timestamp transactionStarted;

  static class Builder extends AbstractMultiUseTransaction.Builder<Builder, ReadWriteTransaction> {
    private DatabaseClient dbClient;
    private Boolean retryAbortsInternally;
    private List<TransactionRetryListener> transactionRetryListeners;

    private Builder() {}

    Builder setDatabaseClient(DatabaseClient client) {
      Preconditions.checkNotNull(client);
      this.dbClient = client;
      return this;
    }

    Builder setRetryAbortsInternally(boolean retryAbortsInternally) {
      this.retryAbortsInternally = retryAbortsInternally;
      return this;
    }

    Builder setTransactionRetryListeners(List<TransactionRetryListener> listeners) {
      Preconditions.checkNotNull(listeners);
      this.transactionRetryListeners = listeners;
      return this;
    }

    @Override
    ReadWriteTransaction build() {
      Preconditions.checkState(dbClient != null, "No DatabaseClient client specified");
      Preconditions.checkState(
          retryAbortsInternally != null, "RetryAbortsInternally is not specified");
      Preconditions.checkState(
          transactionRetryListeners != null, "TransactionRetryListeners are not specified");
      return new ReadWriteTransaction(this);
    }
  }

  static Builder newBuilder() {
    return new Builder();
  }

  private ReadWriteTransaction(Builder builder) {
    super(builder);
    this.transactionId = ID_GENERATOR.incrementAndGet();
    this.dbClient = builder.dbClient;
    this.retryAbortsInternally = builder.retryAbortsInternally;
    this.transactionRetryListeners = builder.transactionRetryListeners;
    this.txManager = dbClient.transactionManager();
  }

  @Override
  public String toString() {
    return new StringBuilder()
        .append("ReadWriteTransaction - ID: ")
        .append(transactionId)
        .append("; Status: ")
        .append(internalGetStateName())
        .append("; Started: ")
        .append(internalGetTimeStarted())
        .append("; Retry attempts: ")
        .append(transactionRetryAttempts)
        .append("; Successful retries: ")
        .append(successfulRetries)
        .toString();
  }

  private String internalGetStateName() {
    return transactionStarted == null ? "Not yet started" : getState().toString();
  }

  private String internalGetTimeStarted() {
    return transactionStarted == null ? "Not yet started" : transactionStarted.toString();
  }

  @Override
  public UnitOfWorkState getState() {
    return this.state;
  }

  @Override
  public boolean isReadOnly() {
    return false;
  }

  @Override
  void checkValidTransaction() {
    ConnectionPreconditions.checkState(
        state == UnitOfWorkState.STARTED, "This transaction has status " + state.name());
    ConnectionPreconditions.checkState(
        !timedOutOrCancelled,
        "The last statement of this transaction timed out or was cancelled. "
            + "The transaction is no longer usable. "
            + "Rollback the transaction and start a new one.");
    if (txManager.getState() == null) {
      transactionStarted = Timestamp.now();
      txContext = txManager.begin();
    }
    if (txManager.getState()
        != com.google.cloud.spanner.TransactionManager.TransactionState.STARTED) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.FAILED_PRECONDITION,
          String.format("Invalid transaction state: %s", txManager.getState()));
    }
  }

  @Override
  ReadContext getReadContext() {
    ConnectionPreconditions.checkState(txContext != null, "Missing transaction context");
    return txContext;
  }

  @Override
  public Timestamp getReadTimestamp() {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION,
        "There is no read timestamp available for read/write transactions.");
  }

  @Override
  public Timestamp getReadTimestampOrNull() {
    return null;
  }

  private boolean hasCommitTimestamp() {
    return txManager.getState()
        == com.google.cloud.spanner.TransactionManager.TransactionState.COMMITTED;
  }

  @Override
  public Timestamp getCommitTimestamp() {
    ConnectionPreconditions.checkState(hasCommitTimestamp(), "This transaction has not committed.");
    return txManager.getCommitTimestamp();
  }

  @Override
  public Timestamp getCommitTimestampOrNull() {
    return hasCommitTimestamp() ? txManager.getCommitTimestamp() : null;
  }

  @Override
  public void executeDdl(ParsedStatement ddl) {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION,
        "DDL-statements are not allowed inside a read/write transaction.");
  }

  private void handlePossibleInvalidatingException(SpannerException e) {
    if (e.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED
        || e.getErrorCode() == ErrorCode.CANCELLED) {
      this.timedOutOrCancelled = true;
    }
  }

  @Override
  public ResultSet executeQuery(
      final ParsedStatement statement,
      final AnalyzeMode analyzeMode,
      final QueryOption... options) {
    Preconditions.checkArgument(statement.isQuery(), "Statement is not a query");
    checkValidTransaction();
    try {
      if (retryAbortsInternally) {
        return asyncExecuteStatement(
            statement,
            new Callable<ResultSet>() {
              @Override
              public ResultSet call() throws Exception {
                return runWithRetry(
                    new Callable<ResultSet>() {
                      @Override
                      public ResultSet call() throws Exception {
                        try {
                          getStatementExecutor()
                              .invokeInterceptors(
                                  statement,
                                  StatementExecutionStep.EXECUTE_STATEMENT,
                                  ReadWriteTransaction.this);
                          ResultSet delegate =
                              DirectExecuteResultSet.ofResultSet(
                                  internalExecuteQuery(statement, analyzeMode, options));
                          return createAndAddRetryResultSet(
                              delegate, statement, analyzeMode, options);
                        } catch (AbortedException e) {
                          throw e;
                        } catch (SpannerException e) {
                          createAndAddFailedQuery(e, statement, analyzeMode, options);
                          throw e;
                        }
                      }
                    });
              }
            },
            InterceptorsUsage
                .IGNORE_INTERCEPTORS); // ignore interceptors here as they are invoked in the
                                       // Callable.
      } else {
        return super.executeQuery(statement, analyzeMode, options);
      }
    } catch (SpannerException e) {
      handlePossibleInvalidatingException(e);
      throw e;
    }
  }

  @Override
  public long executeUpdate(final ParsedStatement update) {
    Preconditions.checkNotNull(update);
    Preconditions.checkArgument(update.isUpdate(), "The statement is not an update statement");
    checkValidTransaction();
    try {
      if (retryAbortsInternally) {
        return asyncExecuteStatement(
            update,
            new Callable<Long>() {
              @Override
              public Long call() throws Exception {
                return runWithRetry(
                    new Callable<Long>() {
                      @Override
                      public Long call() throws Exception {
                        try {
                          getStatementExecutor()
                              .invokeInterceptors(
                                  update,
                                  StatementExecutionStep.EXECUTE_STATEMENT,
                                  ReadWriteTransaction.this);
                          long updateCount = txContext.executeUpdate(update.getStatement());
                          createAndAddRetriableUpdate(update, updateCount);
                          return updateCount;
                        } catch (AbortedException e) {
                          throw e;
                        } catch (SpannerException e) {
                          createAndAddFailedUpdate(e, update);
                          throw e;
                        }
                      }
                    });
              }
            },
            InterceptorsUsage
                .IGNORE_INTERCEPTORS); // ignore interceptors here as they are invoked in the
                                       // Callable.
      } else {
        return asyncExecuteStatement(
            update,
            new Callable<Long>() {
              @Override
              public Long call() throws Exception {
                return txContext.executeUpdate(update.getStatement());
              }
            });
      }
    } catch (SpannerException e) {
      handlePossibleInvalidatingException(e);
      throw e;
    }
  }

  private final ParsedStatement executeBatchUpdateStatement =
      StatementParser.INSTANCE.parse(Statement.of("RUN BATCH"));

  @Override
  public long[] executeBatchUpdate(final Iterable<ParsedStatement> updates) {
    Preconditions.checkNotNull(updates);
    final List<Statement> updateStatements = new LinkedList<>();
    for (ParsedStatement update : updates) {
      Preconditions.checkArgument(
          update.isUpdate(),
          "Statement is not an update statement: " + update.getSqlWithoutComments());
      updateStatements.add(update.getStatement());
    }
    checkValidTransaction();
    try {
      if (retryAbortsInternally) {
        return asyncExecuteStatement(
            executeBatchUpdateStatement,
            new Callable<long[]>() {
              @Override
              public long[] call() throws Exception {
                return runWithRetry(
                    new Callable<long[]>() {
                      @Override
                      public long[] call() throws Exception {
                        try {
                          getStatementExecutor()
                              .invokeInterceptors(
                                  executeBatchUpdateStatement,
                                  StatementExecutionStep.EXECUTE_STATEMENT,
                                  ReadWriteTransaction.this);
                          long[] updateCounts = txContext.batchUpdate(updateStatements);
                          createAndAddRetriableBatchUpdate(updateStatements, updateCounts);
                          return updateCounts;
                        } catch (AbortedException e) {
                          throw e;
                        } catch (SpannerException e) {
                          createAndAddFailedBatchUpdate(e, updateStatements);
                          throw e;
                        }
                      }
                    });
              }
            },
            InterceptorsUsage
                .IGNORE_INTERCEPTORS); // ignore interceptors here as they are invoked in the
                                       // Callable.
      } else {
        return asyncExecuteStatement(
            executeBatchUpdateStatement,
            new Callable<long[]>() {
              @Override
              public long[] call() throws Exception {
                return txContext.batchUpdate(updateStatements);
              }
            });
      }
    } catch (SpannerException e) {
      handlePossibleInvalidatingException(e);
      throw e;
    }
  }

  @Override
  public void write(Mutation mutation) {
    Preconditions.checkNotNull(mutation);
    checkValidTransaction();
    mutations.add(mutation);
  }

  @Override
  public void write(Iterable<Mutation> mutations) {
    Preconditions.checkNotNull(mutations);
    checkValidTransaction();
    for (Mutation mutation : mutations) {
      this.mutations.add(checkNotNull(mutation));
    }
  }

  /** Create a pseudo COMMIT statement to allow it to be cancelled or time out. */
  private final ParsedStatement commitStatement =
      StatementParser.INSTANCE.parse(Statement.of("COMMIT"));

  private final Callable<Void> commitCallable =
      new Callable<Void>() {
        @Override
        public Void call() throws Exception {
          txContext.buffer(mutations);
          txManager.commit();
          return null;
        }
      };

  @Override
  public void commit() {
    checkValidTransaction();
    try {
      if (retryAbortsInternally) {
        asyncExecuteStatement(
            commitStatement,
            new Callable<Void>() {
              @Override
              public Void call() throws Exception {
                return runWithRetry(
                    new Callable<Void>() {
                      @Override
                      public Void call() throws Exception {
                        getStatementExecutor()
                            .invokeInterceptors(
                                commitStatement,
                                StatementExecutionStep.EXECUTE_STATEMENT,
                                ReadWriteTransaction.this);
                        commitCallable.call();
                        return null;
                      }
                    });
              }
            },
            InterceptorsUsage.IGNORE_INTERCEPTORS);
      } else {
        asyncExecuteStatement(commitStatement, commitCallable);
      }
      ReadWriteTransaction.this.state = UnitOfWorkState.COMMITTED;
    } catch (SpannerException e) {
      try {
        txManager.close();
      } catch (Throwable t) {
        // ignore
      }
      this.state = UnitOfWorkState.COMMIT_FAILED;
      throw e;
    }
  }

  /**
   * Executes a database call that could throw an {@link AbortedException}. If an {@link
   * AbortedException} is thrown, the transaction will automatically be retried and the checksums of
   * all {@link ResultSet}s and update counts of DML statements will be checked against the original
   * values of the original transaction. If the checksums and/or update counts do not match, the
   * method will throw an {@link AbortedException} that cannot be retried, as the underlying data
   * have actually changed.
   *
   * <p>If {@link ReadWriteTransaction#retryAbortsInternally} has been set to <code>false</code>,
   * this method will throw an exception instead of retrying the transaction if the transaction was
   * aborted.
   *
   * @param callable The actual database calls.
   * @return the results of the database calls.
   * @throws SpannerException if the database calls threw an exception, an {@link
   *     AbortedDueToConcurrentModificationException} if a retry of the transaction yielded
   *     different results than the original transaction, or an {@link AbortedException} if the
   *     maximum number of retries has been exceeded.
   */
  private <T> T runWithRetry(Callable<T> callable) throws SpannerException {
    while (true) {
      try {
        return callable.call();
      } catch (final AbortedException aborted) {
        if (retryAbortsInternally) {
          handleAborted(aborted);
        } else {
          throw aborted;
        }
      } catch (SpannerException e) {
        throw e;
      } catch (Exception e) {
        throw SpannerExceptionFactory.newSpannerException(ErrorCode.UNKNOWN, e.getMessage(), e);
      }
    }
  }

  /**
   * Registers a {@link ResultSet} on this transaction that must be checked during a retry, and
   * returns a retryable {@link ResultSet}.
   */
  private ResultSet createAndAddRetryResultSet(
      ResultSet resultSet,
      ParsedStatement statement,
      AnalyzeMode analyzeMode,
      QueryOption... options) {
    if (retryAbortsInternally) {
      ChecksumResultSet checksumResultSet =
          createChecksumResultSet(resultSet, statement, analyzeMode, options);
      addRetryStatement(checksumResultSet);
      return checksumResultSet;
    }
    return resultSet;
  }

  /** Registers the statement as a query that should return an error during a retry. */
  private void createAndAddFailedQuery(
      SpannerException e,
      ParsedStatement statement,
      AnalyzeMode analyzeMode,
      QueryOption... options) {
    if (retryAbortsInternally) {
      addRetryStatement(new FailedQuery(e, statement, analyzeMode, options));
    }
  }

  private void createAndAddRetriableUpdate(ParsedStatement update, long updateCount) {
    if (retryAbortsInternally) {
      addRetryStatement(new RetriableUpdate(update, updateCount));
    }
  }

  private void createAndAddRetriableBatchUpdate(Iterable<Statement> updates, long[] updateCounts) {
    if (retryAbortsInternally) {
      addRetryStatement(new RetriableBatchUpdate(updates, updateCounts));
    }
  }

  /** Registers the statement as an update that should return an error during a retry. */
  private void createAndAddFailedUpdate(SpannerException e, ParsedStatement update) {
    if (retryAbortsInternally) {
      addRetryStatement(new FailedUpdate(e, update));
    }
  }

  /** Registers the statements as a batch of updates that should return an error during a retry. */
  private void createAndAddFailedBatchUpdate(SpannerException e, Iterable<Statement> updates) {
    if (retryAbortsInternally) {
      addRetryStatement(new FailedBatchUpdate(e, updates));
    }
  }

  /**
   * Adds a statement to the list of statements that should be retried if this transaction aborts.
   */
  private void addRetryStatement(RetriableStatement statement) {
    Preconditions.checkState(
        retryAbortsInternally, "retryAbortsInternally is not enabled for this transaction");
    statements.add(statement);
  }

  /**
   * Handles an aborted exception by checking whether the transaction may be retried internally, and
   * if so, does the retry. If retry is not allowed, or if the retry fails, the method will throw an
   * {@link AbortedException}.
   */
  private void handleAborted(AbortedException aborted) {
    if (transactionRetryAttempts >= MAX_INTERNAL_RETRIES) {
      // If the same statement in transaction keeps aborting, then we need to abort here.
      throwAbortWithRetryAttemptsExceeded();
    } else if (retryAbortsInternally) {
      logger.fine(toString() + ": Starting internal transaction retry");
      while (true) {
        // First back off and then restart the transaction.
        try {
          Thread.sleep(aborted.getRetryDelayInMillis() / 1000);
        } catch (InterruptedException ie) {
          Thread.currentThread().interrupt();
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.CANCELLED, "The statement was cancelled");
        }
        try {
          try {
            txContext = txManager.resetForRetry();
          } catch (IllegalStateException e) {
            if (txManager.getState()
                == com.google.cloud.spanner.TransactionManager.TransactionState.STARTED) {
              // In case the transaction manager didn't pick up the abort correctly, we'll rollback
              // manually and do another try. This seems to be the case if the transaction was
              // aborted and txContext.executeUpdate(Statement) is called.
              // TODO: Check whether TransactionContextImpl.executeUpdate(Statement) handles
              // AbortedException correctly.
              txManager.rollback();
              txManager = dbClient.transactionManager();
              txContext = txManager.begin();
            }
          }
          // Inform listeners about the transaction retry that is about to start.
          invokeTransactionRetryListenersOnStart();
          // Then retry all transaction statements.
          transactionRetryAttempts++;
          for (RetriableStatement statement : statements) {
            statement.retry(aborted);
          }
          successfulRetries++;
          invokeTransactionRetryListenersOnFinish(RetryResult.RETRY_SUCCESSFUL);
          logger.fine(
              toString()
                  + ": Internal transaction retry succeeded. Starting retry of original statement.");
          // Retry succeeded, return and continue the original transaction.
          break;
        } catch (AbortedDueToConcurrentModificationException e) {
          // Retry failed because of a concurrent modification, we have to abort.
          invokeTransactionRetryListenersOnFinish(
              RetryResult.RETRY_ABORTED_DUE_TO_CONCURRENT_MODIFICATION);
          logger.fine(
              toString() + ": Internal transaction retry aborted due to a concurrent modification");
          // Try to rollback the new transaction and ignore any exceptions.
          try {
            txManager.rollback();
          } catch (Throwable t) {
            // ignore
          }
          this.state = UnitOfWorkState.ABORTED;
          throw e;
        } catch (AbortedException e) {
          // Retry aborted, do another retry of the transaction.
          if (transactionRetryAttempts >= MAX_INTERNAL_RETRIES) {
            throwAbortWithRetryAttemptsExceeded();
          }
          invokeTransactionRetryListenersOnFinish(RetryResult.RETRY_ABORTED_AND_RESTARTING);
          logger.fine(toString() + ": Internal transaction retry aborted, trying again");
        } catch (SpannerException e) {
          // unexpected exception
          logger.log(
              Level.FINE,
              toString() + ": Internal transaction retry failed due to an unexpected exception",
              e);
          // Try to rollback the new transaction and ignore any exceptions.
          try {
            txManager.rollback();
          } catch (Throwable t) {
            // ignore
          }
          // Set transaction state to aborted as the retry failed.
          this.state = UnitOfWorkState.ABORTED;
          // Re-throw underlying exception.
          throw e;
        }
      }
    } else {
      try {
        txManager.close();
      } catch (Throwable t) {
        // ignore
      }
      // Internal retry is not enabled.
      this.state = UnitOfWorkState.ABORTED;
      throw aborted;
    }
  }

  private void throwAbortWithRetryAttemptsExceeded() throws SpannerException {
    invokeTransactionRetryListenersOnFinish(RetryResult.RETRY_ABORTED_AND_MAX_ATTEMPTS_EXCEEDED);
    logger.fine(
        toString()
            + ": Internal transaction retry aborted and max number of retry attempts has been exceeded");
    // Try to rollback the transaction and ignore any exceptions.
    // Normally it should not be necessary to do this, but in order to be sure we never leak
    // any sessions it is better to do so.
    try {
      txManager.rollback();
    } catch (Throwable t) {
      // ignore
    }
    this.state = UnitOfWorkState.ABORTED;
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.ABORTED, MAX_INTERNAL_RETRIES_EXCEEDED);
  }

  private void invokeTransactionRetryListenersOnStart() {
    for (TransactionRetryListener listener : transactionRetryListeners) {
      listener.retryStarting(transactionStarted, transactionId, transactionRetryAttempts);
    }
  }

  private void invokeTransactionRetryListenersOnFinish(RetryResult result) {
    for (TransactionRetryListener listener : transactionRetryListeners) {
      listener.retryFinished(transactionStarted, transactionId, transactionRetryAttempts, result);
    }
  }

  /** The {@link Statement} and {@link Callable} for rollbacks */
  private final ParsedStatement rollbackStatement =
      StatementParser.INSTANCE.parse(Statement.of("ROLLBACK"));

  private final Callable<Void> rollbackCallable =
      new Callable<Void>() {
        @Override
        public Void call() throws Exception {
          txManager.rollback();
          return null;
        }
      };

  @Override
  public void rollback() {
    ConnectionPreconditions.checkState(
        state == UnitOfWorkState.STARTED, "This transaction has status " + state.name());
    try {
      asyncExecuteStatement(rollbackStatement, rollbackCallable);
    } finally {
      // Whatever happens, we should always call close in order to return the underlying session to
      // the session pool to avoid any session leaks.
      try {
        txManager.close();
      } catch (Throwable e) {
        // ignore
      }
      this.state = UnitOfWorkState.ROLLED_BACK;
    }
  }

  /**
   * A retriable statement is a query or DML statement during a read/write transaction that can be
   * retried if the original transaction aborted.
   */
  private interface RetriableStatement {
    /**
     * Retry this statement in a new transaction. Throws an {@link
     * AbortedDueToConcurrentModificationException} if the retry could not successfully be executed
     * because of an actual concurrent modification of the underlying data. This {@link
     * AbortedDueToConcurrentModificationException} cannot be retried.
     */
    void retry(AbortedException aborted) throws AbortedException;
  }

  /** A query that failed with a {@link SpannerException} */
  private final class FailedQuery implements RetriableStatement {
    private final SpannerException exception;
    private final ParsedStatement statement;
    private final AnalyzeMode analyzeMode;
    private final QueryOption[] options;

    private FailedQuery(
        SpannerException exception,
        ParsedStatement statement,
        AnalyzeMode analyzeMode,
        QueryOption... options) {
      Preconditions.checkNotNull(exception);
      Preconditions.checkNotNull(statement);
      this.exception = exception;
      this.statement = statement;
      this.analyzeMode = analyzeMode;
      this.options = options;
    }

    @Override
    public void retry(AbortedException aborted) throws AbortedException {
      getStatementExecutor()
          .invokeInterceptors(
              statement, StatementExecutionStep.RETRY_STATEMENT, ReadWriteTransaction.this);
      try {
        getStatementExecutor()
            .invokeInterceptors(
                statement, StatementExecutionStep.RETRY_STATEMENT, ReadWriteTransaction.this);
        try (ResultSet rs =
            DirectExecuteResultSet.ofResultSet(
                internalExecuteQuery(statement, analyzeMode, options))) {
          // Do nothing with the results, we are only interested in whether the statement throws the
          // same exception as in the original transaction.
        }
      } catch (SpannerException e) {
        // Check that we got the same exception as in the original transaction
        if (e.getErrorCode() == exception.getErrorCode()
            && Objects.equals(e.getMessage(), exception.getMessage())) {
          return;
        }
        throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted, e);
      }
      throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted);
    }
  }

  /** An update that failed with a {@link SpannerException} */
  private final class FailedUpdate implements RetriableStatement {
    private final SpannerException exception;
    private final ParsedStatement statement;

    private FailedUpdate(SpannerException exception, ParsedStatement statement) {
      Preconditions.checkNotNull(exception);
      Preconditions.checkNotNull(statement);
      this.exception = exception;
      this.statement = statement;
    }

    @Override
    public void retry(AbortedException aborted) throws AbortedException {
      getStatementExecutor()
          .invokeInterceptors(
              statement, StatementExecutionStep.RETRY_STATEMENT, ReadWriteTransaction.this);
      try {
        getStatementExecutor()
            .invokeInterceptors(
                statement, StatementExecutionStep.RETRY_STATEMENT, ReadWriteTransaction.this);
        txContext.executeUpdate(statement.getStatement());
      } catch (SpannerException e) {
        // Check that we got the same exception as in the original transaction.
        if (e.getErrorCode() == exception.getErrorCode()
            && Objects.equals(e.getMessage(), exception.getMessage())) {
          return;
        }
        throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted, e);
      }
      throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted);
    }
  }

  /** A batch update that failed with a {@link SpannerException} */
  private final class FailedBatchUpdate implements RetriableStatement {
    private final SpannerException exception;
    private final Iterable<Statement> statements;

    private FailedBatchUpdate(SpannerException exception, Iterable<Statement> statements) {
      Preconditions.checkNotNull(exception);
      Preconditions.checkNotNull(statements);
      this.exception = exception;
      this.statements = statements;
    }

    @Override
    public void retry(AbortedException aborted) throws AbortedException {
      getStatementExecutor()
          .invokeInterceptors(
              executeBatchUpdateStatement,
              StatementExecutionStep.RETRY_STATEMENT,
              ReadWriteTransaction.this);
      try {
        txContext.batchUpdate(statements);
      } catch (SpannerBatchUpdateException e) {
        // Check that we got the same exception as in the original transaction.
        if (exception instanceof SpannerBatchUpdateException
            && e.getErrorCode() == exception.getErrorCode()
            && Objects.equals(e.getMessage(), exception.getMessage())) {
          // Check that the returned update counts are equal.
          if (Arrays.equals(
              e.getUpdateCounts(), ((SpannerBatchUpdateException) exception).getUpdateCounts())) {
            return;
          }
        }
        throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted, e);
      } catch (SpannerException e) {
        // Check that we got the same exception as in the original transaction.
        if (e.getErrorCode() == exception.getErrorCode()
            && Objects.equals(e.getMessage(), exception.getMessage())) {
          return;
        }
        throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted, e);
      }
      throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted);
    }
  }

  /**
   * Retriable DML statement. The check whether the statement had the same effect during retry is
   * done by comparing the number of records affected.
   */
  private final class RetriableUpdate implements RetriableStatement {
    private final ParsedStatement statement;
    private final long updateCount;

    private RetriableUpdate(ParsedStatement statement, long updateCount) {
      Preconditions.checkNotNull(statement);
      this.statement = statement;
      this.updateCount = updateCount;
    }

    @Override
    public void retry(AbortedException aborted) throws AbortedException {
      long newCount = -1;
      try {
        getStatementExecutor()
            .invokeInterceptors(
                statement, StatementExecutionStep.RETRY_STATEMENT, ReadWriteTransaction.this);
        newCount = txContext.executeUpdate(statement.getStatement());
      } catch (AbortedException e) {
        // Just re-throw the AbortedException and let the retry logic determine whether another try
        // should be executed or not.
        throw e;
      } catch (SpannerException e) {
        // Unexpected database error that is different from the original transaction.
        throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted, e);
      }
      if (newCount != updateCount) {
        // The update counts do not match, we cannot retry the transaction.
        throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted);
      }
    }
  }

  /**
   * Retriable batch of DML statements. The check whether the statements had the same effect during
   * retry is done by comparing the number of records affected.
   */
  private final class RetriableBatchUpdate implements RetriableStatement {
    private final Iterable<Statement> statements;
    private final long[] updateCounts;

    private RetriableBatchUpdate(Iterable<Statement> statements, long[] updateCounts) {
      Preconditions.checkNotNull(statements);
      this.statements = statements;
      this.updateCounts = updateCounts;
    }

    @Override
    public void retry(AbortedException aborted) throws AbortedException {
      long[] newCount = null;
      try {
        getStatementExecutor()
            .invokeInterceptors(
                executeBatchUpdateStatement,
                StatementExecutionStep.RETRY_STATEMENT,
                ReadWriteTransaction.this);
        newCount = txContext.batchUpdate(statements);
      } catch (AbortedException e) {
        // Just re-throw the AbortedException and let the retry logic determine whether another try
        // should be executed or not.
        throw e;
      } catch (SpannerException e) {
        // Unexpected database error that is different from the original transaction.
        throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted, e);
      }
      if (newCount == null || !Arrays.equals(updateCounts, newCount)) {
        // The update counts do not match, we cannot retry the transaction.
        throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted);
      }
    }
  }

  /** Creates a {@link ChecksumResultSet} for this {@link ReadWriteTransaction}. */
  @VisibleForTesting
  ChecksumResultSet createChecksumResultSet(
      ResultSet delegate,
      ParsedStatement statement,
      AnalyzeMode analyzeMode,
      QueryOption... options) {
    return new ChecksumResultSet(this, delegate, statement, analyzeMode, options);
  }

  /**
   * {@link ResultSet} implementation that keeps a running checksum that can be used to determine
   * whether a transaction retry is possible or not. The checksum is based on all the rows that have
   * actually been consumed by the user. If the user has not yet consumed any part of the result set
   * (i.e. never called next()), the checksum will be <code>null</code> and retry will always be
   * allowed.
   *
   * <p>If all the rows in the result set have been consumed, the checksum will be based on the
   * values of all those rows, and a retry will only be possible if the query returns the exact same
   * results during the retry as during the original transaction.
   *
   * <p>If some of the rows in the result set have been consumed, the checksum will be based on the
   * values of the rows that have been consumed. A retry will succeed if the query returns the same
   * results for the already consumed rows.
   *
   * <p>The checksum of a {@link ResultSet} is the SHA256 checksum of the current row together with
   * the previous checksum value of the result set. The calculation of the checksum is executed in a
   * separate {@link Thread} to allow the checksum calculation to lag behind the actual consumption
   * of rows, and catch up again if the client slows down the consumption of rows, for example while
   * waiting for more data from Cloud Spanner. If the checksum calculation queue contains more than
   * {@link ChecksumExecutor#MAX_IN_CHECKSUM_QUEUE} items that have not yet been calculated, calls
   * to {@link ResultSet#next()} will slow down in order to allow the calculation to catch up.
   */
  @VisibleForTesting
  static class ChecksumResultSet extends ReplaceableForwardingResultSet
      implements RetriableStatement {
    private final ReadWriteTransaction transaction;
    private long numberOfNextCalls;
    private final ParsedStatement statement;
    private final AnalyzeMode analyzeMode;
    private final QueryOption[] options;
    private final ChecksumCalculator checksumCalculator = new ChecksumCalculator();

    private ChecksumResultSet(
        ReadWriteTransaction transaction,
        ResultSet delegate,
        ParsedStatement statement,
        AnalyzeMode analyzeMode,
        QueryOption... options) {
      super(delegate);
      Preconditions.checkNotNull(transaction);
      Preconditions.checkNotNull(delegate);
      Preconditions.checkNotNull(statement);
      Preconditions.checkNotNull(statement.getStatement());
      Preconditions.checkNotNull(statement.getStatement().getSql());
      this.transaction = transaction;
      this.statement = statement;
      this.analyzeMode = analyzeMode;
      this.options = options;
    }

    /** Simple {@link Callable} for calling {@link ResultSet#next()} */
    private final class NextCallable implements Callable<Boolean> {
      @Override
      public Boolean call() throws Exception {
        transaction
            .getStatementExecutor()
            .invokeInterceptors(
                statement, StatementExecutionStep.CALL_NEXT_ON_RESULT_SET, transaction);
        return ChecksumResultSet.super.next();
      }
    }

    private final NextCallable nextCallable = new NextCallable();

    @Override
    public boolean next() {
      // Call next() with retry.
      boolean res = transaction.runWithRetry(nextCallable);
      // Only update the checksum if there was another row to be consumed.
      if (res) {
        checksumCalculator.calculateNextChecksum(getCurrentRowAsStruct());
      }
      numberOfNextCalls++;
      return res;
    }

    @VisibleForTesting
    HashCode getChecksum() throws InterruptedException, ExecutionException {
      // HashCode is immutable and can be safely returned.
      return checksumCalculator.getChecksum();
    }

    /**
     * Execute the same query as in the original transaction and consume the {@link ResultSet} to
     * the same point as the original {@link ResultSet}. The {@link HashCode} of the new {@link
     * ResultSet} is compared with the {@link HashCode} of the original {@link ResultSet} at the
     * point where the consumption of the {@link ResultSet} stopped.
     */
    @Override
    public void retry(AbortedException aborted) throws AbortedException {
      // Execute the same query and consume the result set to the same point as the original.
      ChecksumCalculator newChecksumCalculator = new ChecksumCalculator();
      ResultSet resultSet = null;
      long counter = 0L;
      try {
        transaction
            .getStatementExecutor()
            .invokeInterceptors(statement, StatementExecutionStep.RETRY_STATEMENT, transaction);
        resultSet =
            DirectExecuteResultSet.ofResultSet(
                transaction.internalExecuteQuery(statement, analyzeMode, options));
        boolean next = true;
        while (counter < numberOfNextCalls && next) {
          transaction
              .getStatementExecutor()
              .invokeInterceptors(
                  statement, StatementExecutionStep.RETRY_NEXT_ON_RESULT_SET, transaction);
          next = resultSet.next();
          if (next) {
            newChecksumCalculator.calculateNextChecksum(resultSet.getCurrentRowAsStruct());
          }
          counter++;
        }
      } catch (Throwable e) {
        if (resultSet != null) {
          resultSet.close();
        }
        // If it was a SpannerException other than an AbortedException, the retry should fail
        // because of different results from the database.
        if (e instanceof SpannerException && !(e instanceof AbortedException)) {
          throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(
              aborted, (SpannerException) e);
        }
        // For other types of exceptions we should just re-throw the exception.
        throw e;
      }
      // Check that we have the same number of rows and the same checksum.
      HashCode newChecksum = newChecksumCalculator.getChecksum();
      HashCode currentChecksum = checksumCalculator.getChecksum();
      if (counter == numberOfNextCalls && Objects.equals(newChecksum, currentChecksum)) {
        // Checksum is ok, we only need to replace the delegate result set if it's still open.
        if (isClosed()) {
          resultSet.close();
        } else {
          replaceDelegate(resultSet);
        }
      } else {
        // The results are not equal, there is an actual concurrent modification, so we cannot
        // continue the transaction.
        throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted);
      }
    }

    /** Calculates and keeps the current checksum of a {@link ChecksumResultSet} */
    private static final class ChecksumCalculator {
      private static final HashFunction SHA256_FUNCTION = Hashing.sha256();
      private HashCode currentChecksum;

      private void calculateNextChecksum(Struct row) {
        Hasher hasher = SHA256_FUNCTION.newHasher();
        if (currentChecksum != null) {
          hasher.putBytes(currentChecksum.asBytes());
        }
        hasher.putObject(row, StructFunnel.INSTANCE);
        currentChecksum = hasher.hash();
      }

      private HashCode getChecksum() {
        return currentChecksum;
      }
    }

    /**
     * A {@link Funnel} implementation for calculating a {@link HashCode} for each row in a {@link
     * ResultSet}.
     */
    private enum StructFunnel implements Funnel<Struct> {
      INSTANCE;
      private static final String NULL = "null";

      @Override
      public void funnel(Struct row, PrimitiveSink into) {
        for (int i = 0; i < row.getColumnCount(); i++) {
          if (row.isNull(i)) {
            funnelValue(Code.STRING, null, into);
          } else {
            Code type = row.getColumnType(i).getCode();
            switch (type) {
              case ARRAY:
                funnelArray(row.getColumnType(i).getArrayElementType().getCode(), row, i, into);
                break;
              case BOOL:
                funnelValue(type, row.getBoolean(i), into);
                break;
              case BYTES:
                funnelValue(type, row.getBytes(i), into);
                break;
              case DATE:
                funnelValue(type, row.getDate(i), into);
                break;
              case FLOAT64:
                funnelValue(type, row.getDouble(i), into);
                break;
              case INT64:
                funnelValue(type, row.getLong(i), into);
                break;
              case STRING:
                funnelValue(type, row.getString(i), into);
                break;
              case TIMESTAMP:
                funnelValue(type, row.getTimestamp(i), into);
                break;

              case STRUCT:
              default:
                throw new IllegalArgumentException("unsupported row type");
            }
          }
        }
      }

      private void funnelArray(
          Code arrayElementType, Struct row, int columnIndex, PrimitiveSink into) {
        funnelValue(Code.STRING, "BeginArray", into);
        switch (arrayElementType) {
          case BOOL:
            into.putInt(row.getBooleanList(columnIndex).size());
            for (Boolean value : row.getBooleanList(columnIndex)) {
              funnelValue(Code.BOOL, value, into);
            }
            break;
          case BYTES:
            into.putInt(row.getBytesList(columnIndex).size());
            for (ByteArray value : row.getBytesList(columnIndex)) {
              funnelValue(Code.BYTES, value, into);
            }
            break;
          case DATE:
            into.putInt(row.getDateList(columnIndex).size());
            for (Date value : row.getDateList(columnIndex)) {
              funnelValue(Code.DATE, value, into);
            }
            break;
          case FLOAT64:
            into.putInt(row.getDoubleList(columnIndex).size());
            for (Double value : row.getDoubleList(columnIndex)) {
              funnelValue(Code.FLOAT64, value, into);
            }
            break;
          case INT64:
            into.putInt(row.getLongList(columnIndex).size());
            for (Long value : row.getLongList(columnIndex)) {
              funnelValue(Code.INT64, value, into);
            }
            break;
          case STRING:
            into.putInt(row.getStringList(columnIndex).size());
            for (String value : row.getStringList(columnIndex)) {
              funnelValue(Code.STRING, value, into);
            }
            break;
          case TIMESTAMP:
            into.putInt(row.getTimestampList(columnIndex).size());
            for (Timestamp value : row.getTimestampList(columnIndex)) {
              funnelValue(Code.TIMESTAMP, value, into);
            }
            break;

          case ARRAY:
          case STRUCT:
          default:
            throw new IllegalArgumentException("unsupported array element type");
        }
        funnelValue(Code.STRING, "EndArray", into);
      }

      private <T> void funnelValue(Code type, T value, PrimitiveSink into) {
        // Include the type name in case the type of a column has changed.
        into.putUnencodedChars(type.name());
        if (value == null) {
          if (type == Code.BYTES || type == Code.STRING) {
            // Put length -1 to distinguish from the string value 'null'.
            into.putInt(-1);
          }
          into.putUnencodedChars(NULL);
        } else {
          switch (type) {
            case BOOL:
              into.putBoolean((Boolean) value);
              break;
            case BYTES:
              ByteArray byteArray = (ByteArray) value;
              into.putInt(byteArray.length());
              into.putBytes(byteArray.toByteArray());
              break;
            case DATE:
              Date date = (Date) value;
              into.putInt(date.getYear()).putInt(date.getMonth()).putInt(date.getDayOfMonth());
              break;
            case FLOAT64:
              into.putDouble((Double) value);
              break;
            case INT64:
              into.putLong((Long) value);
              break;
            case STRING:
              String stringValue = (String) value;
              into.putInt(stringValue.length());
              into.putUnencodedChars(stringValue);
              break;
            case TIMESTAMP:
              Timestamp timestamp = (Timestamp) value;
              into.putLong(timestamp.getSeconds()).putInt(timestamp.getNanos());
              break;
            case ARRAY:
            case STRUCT:
            default:
              throw new IllegalArgumentException("invalid type for single value");
          }
        }
      }
    }
  }
}
