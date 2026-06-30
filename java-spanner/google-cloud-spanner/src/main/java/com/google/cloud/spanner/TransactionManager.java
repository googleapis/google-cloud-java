/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Options.TransactionOption;

/**
 * An interface for managing the life cycle of a read write transaction including all its retries.
 * See {@link TransactionContext} for a description of transaction semantics.
 *
 * <p>At any point in time there can be at most one active transaction in this manager. When that
 * transaction is committed, if it fails with an {@code ABORTED} error, calling {@link
 * #resetForRetry()} would create a new {@link TransactionContext}. The newly created transaction
 * would use the same session thus increasing its lock priority. If the transaction is committed
 * successfully, or is rolled back or commit fails with any error other than {@code ABORTED}, the
 * manager is considered complete and no further transactions are allowed to be created in it.
 *
 * <p>Every {@code TransactionManager} should either be committed or rolled back. Failure to do so
 * can cause resources to be leaked and deadlocks. Easiest way to guarantee this is by calling
 * {@link #close()} in a finally block.
 *
 * @see DatabaseClient#transactionManager(TransactionOption...)
 */
public interface TransactionManager extends AutoCloseable {

  /** State of the transaction manager. */
  enum TransactionState {
    // Transaction has been started either by calling {@link #begin()} or via
    // {@link resetForRetry()} but has not been committed or rolled back yet.
    STARTED,
    // Transaction was successfully committed. This is a terminal state.
    COMMITTED,
    // Transaction failed during commit with an error other than ABORTED. Transaction cannot be
    // retried in this state. This is a terminal state.
    COMMIT_FAILED,
    // Transaction failed during commit with ABORTED and can be retried.
    ABORTED,
    // Transaction was rolled back. This is a terminal state.
    ROLLED_BACK
  }

  /**
   * Creates a new read write transaction. This must be called before doing any other operation and
   * can only be called once. To create a new transaction for subsequent retries, see {@link
   * #resetForRetry()}.
   */
  TransactionContext begin();

  /**
   * Initializes a new read-write transaction that is a retry of a previously aborted transaction.
   * This method must be called before performing any operations, and it can only be invoked once
   * per transaction lifecycle.
   *
   * <p>This method should only be used when multiplexed sessions are enabled to create a retry for
   * a previously aborted transaction. This method can be used instead of {@link #resetForRetry()}
   * to create a retry. Using this method or {@link #resetForRetry()} will have the same effect. You
   * must pass in the {@link AbortedException} from the previous attempt to preserve the
   * transaction's priority.
   *
   * <p>For regular sessions, this behaves the same as {@link #begin()}.
   */
  TransactionContext begin(AbortedException exception);

  /**
   * Commits the currently active transaction. If the transaction was already aborted, then this
   * would throw an {@link AbortedException}.
   */
  void commit();

  /**
   * Rolls back the currently active transaction. In most cases there should be no need to call this
   * explicitly since {@link #close()} would automatically roll back any active transaction.
   */
  void rollback();

  /**
   * Creates a new transaction for retry. This should only be called if the previous transaction
   * failed with {@code ABORTED}. In all other cases, this will throw an {@link
   * IllegalStateException}. Users should backoff before calling this method. Backoff delay is
   * specified by {@link SpannerException#getRetryDelayInMillis()} on the {@code SpannerException}
   * throw by the previous commit call.
   */
  TransactionContext resetForRetry();

  /**
   * Returns the commit timestamp if the transaction committed successfully otherwise it will throw
   * {@code IllegalStateException}.
   */
  Timestamp getCommitTimestamp();

  /** Returns the {@link CommitResponse} of this transaction. */
  CommitResponse getCommitResponse();

  /** Returns the state of the transaction. */
  TransactionState getState();

  /**
   * Closes the manager. If there is an active transaction, it will be rolled back. Underlying
   * session will be released back to the session pool.
   */
  @Override
  void close();
}
