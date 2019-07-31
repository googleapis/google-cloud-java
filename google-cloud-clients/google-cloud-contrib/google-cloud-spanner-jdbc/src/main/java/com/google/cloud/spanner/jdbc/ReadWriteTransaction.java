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

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionManager;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.cloud.spanner.jdbc.TransactionRetryListener.RetryResult;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
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
        state == UnitOfWorkState.STARTED,
        "This transaction has status "
            + state.name()
            + ", only "
            + UnitOfWorkState.STARTED
            + " is allowed.");
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
  TransactionContext getReadContext() {
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

  /**
   * Create a RUN BATCH statement to use with the {@link #executeBatchUpdate(Iterable)} method to
   * allow it to be cancelled, time out or retried.
   *
   * <p>{@link ReadWriteTransaction} uses the generic methods {@link #executeAsync(ParsedStatement,
   * Callable)} and {@link #runWithRetry(Callable)} to allow statements to be cancelled, to timeout
   * and to be retried. These methods require a {@link ParsedStatement} as input. When the {@link
   * #executeBatchUpdate(Iterable)} method is called, we do not have one {@link ParsedStatement},
   * and the method uses this statement instead in order to use the same logic as the other
   * statements.
   */
  static final ParsedStatement EXECUTE_BATCH_UPDATE_STATEMENT =
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
            EXECUTE_BATCH_UPDATE_STATEMENT,
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
                                  EXECUTE_BATCH_UPDATE_STATEMENT,
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
            EXECUTE_BATCH_UPDATE_STATEMENT,
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

  /**
   * Create a COMMIT statement to use with the {@link #commit()} method to allow it to be cancelled,
   * time out or retried.
   *
   * <p>{@link ReadWriteTransaction} uses the generic methods {@link #executeAsync(ParsedStatement,
   * Callable)} and {@link #runWithRetry(Callable)} to allow statements to be cancelled, to timeout
   * and to be retried. These methods require a {@link ParsedStatement} as input. When the {@link
   * #commit()} method is called directly, we do not have a {@link ParsedStatement}, and the method
   * uses this statement instead in order to use the same logic as the other statements.
   */
  private static final ParsedStatement COMMIT_STATEMENT =
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
            COMMIT_STATEMENT,
            new Callable<Void>() {
              @Override
              public Void call() throws Exception {
                return runWithRetry(
                    new Callable<Void>() {
                      @Override
                      public Void call() throws Exception {
                        getStatementExecutor()
                            .invokeInterceptors(
                                COMMIT_STATEMENT,
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
        asyncExecuteStatement(COMMIT_STATEMENT, commitCallable);
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
  <T> T runWithRetry(Callable<T> callable) throws SpannerException {
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
      addRetryStatement(new FailedQuery(this, e, statement, analyzeMode, options));
    }
  }

  private void createAndAddRetriableUpdate(ParsedStatement update, long updateCount) {
    if (retryAbortsInternally) {
      addRetryStatement(new RetriableUpdate(this, update, updateCount));
    }
  }

  private void createAndAddRetriableBatchUpdate(Iterable<Statement> updates, long[] updateCounts) {
    if (retryAbortsInternally) {
      addRetryStatement(new RetriableBatchUpdate(this, updates, updateCounts));
    }
  }

  /** Registers the statement as an update that should return an error during a retry. */
  private void createAndAddFailedUpdate(SpannerException e, ParsedStatement update) {
    if (retryAbortsInternally) {
      addRetryStatement(new FailedUpdate(this, e, update));
    }
  }

  /** Registers the statements as a batch of updates that should return an error during a retry. */
  private void createAndAddFailedBatchUpdate(SpannerException e, Iterable<Statement> updates) {
    if (retryAbortsInternally) {
      addRetryStatement(new FailedBatchUpdate(this, e, updates));
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
          txContext = txManager.resetForRetry();
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
  interface RetriableStatement {
    /**
     * Retry this statement in a new transaction. Throws an {@link
     * AbortedDueToConcurrentModificationException} if the retry could not successfully be executed
     * because of an actual concurrent modification of the underlying data. This {@link
     * AbortedDueToConcurrentModificationException} cannot be retried.
     */
    void retry(AbortedException aborted) throws AbortedException;
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
}
