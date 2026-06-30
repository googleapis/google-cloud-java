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

import com.google.api.core.InternalApi;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TransactionMutationLimitExceededException;
import java.util.UUID;

/**
 * Cloud Spanner can abort any read/write transaction because of potential deadlocks or other
 * internal reasons. When a transaction is aborted, the entire transaction should be retried. A
 * {@link Connection} can automatically retry a transaction internally and check whether the results
 * that are returned during a retry attempt are equal to the results during the original
 * transaction. This is done by keeping track of a SHA-256 checksum of all the results that are
 * returned by Spanner during both transactions.
 *
 * <p>This listener class for internal transaction retries allow client applications to do
 * additional testing or logging of transaction retries. Transaction retry listeners of a {@link
 * Connection} can be added using {@link
 * Connection#addTransactionRetryListener(TransactionRetryListener)}.
 */
@InternalApi
public interface TransactionRetryListener {
  /** The result of a retry. */
  @InternalApi
  enum RetryResult {
    /** The retry executed successfully and the transaction will continue. */
    RETRY_SUCCESSFUL,
    /** The retry was aborted by Spanner and another retry attempt will be started. */
    RETRY_ABORTED_AND_RESTARTING,
    /**
     * The retry was aborted by the {@link Connection} because of a concurrent modification. The
     * transaction cannot continue and will throw an {@link
     * AbortedDueToConcurrentModificationException}.
     */
    RETRY_ABORTED_DUE_TO_CONCURRENT_MODIFICATION,
    /**
     * The retry was aborted by Spanner and the maximum number of retry attempts allowed has been
     * exceeded. The transaction cannot continue and will throw an {@link AbortedException}.
     */
    RETRY_ABORTED_AND_MAX_ATTEMPTS_EXCEEDED,
    /**
     * An unexpected error occurred during transaction retry, the transaction cannot continue and
     * will throw an exception.
     */
    RETRY_ERROR
  }

  /**
   * This method is called when a retry is about to start.
   *
   * @param transactionStarted The start date/time of the transaction that is retrying.
   * @param transactionId An internally assigned ID of the transaction (unique during the lifetime
   *     of the JVM) that can be used to identify the transaction for logging purposes.
   * @param retryAttempt The number of retry attempts the current transaction has executed,
   *     <strong>including</strong> the current retry attempt.
   */
  void retryStarting(Timestamp transactionStarted, long transactionId, int retryAttempt);

  /**
   * This method is called when a retry has finished.
   *
   * @param transactionStarted The start date/time of the transaction that is retrying.
   * @param transactionId An internally assigned ID of the transaction (unique during the lifetime
   *     of the JVM) that can be used to identify the transaction for logging purposes.
   * @param retryAttempt The number of retry attempts the current transaction has executed,
   *     <strong>including</strong> the current retry attempt.
   * @param result The result of the retry indicating whether the retry was successful or not.
   */
  void retryFinished(
      Timestamp transactionStarted,
      long transactionId,
      int retryAttempt,
      TransactionRetryListener.RetryResult result);

  /**
   * This method is called when an atomic DML statement is retried as a Partitioned DML statement.
   *
   * @param executionId a generated, unique ID for this execution. The same ID is passed in to the
   *     methods {@link #retryDmlAsPartitionedDmlFinished(UUID, Statement, long)} and {@link
   *     #retryDmlAsPartitionedDmlFailed(UUID, Statement, Throwable)} when the execution finishes or
   *     fails.
   * @param statement the statement that is being retried as Partitioned DML
   * @param exception the mutation-limit-exceeded exception that was returned by Spanner during the
   *     initial execution.
   */
  default void retryDmlAsPartitionedDmlStarting(
      UUID executionId, Statement statement, TransactionMutationLimitExceededException exception) {}

  /**
   * This method is called when an atomic DML statement has been successfully retried as a
   * Partitioned DML statement.
   *
   * @param executionId the unique ID of this statement execution
   * @param statement the statement that was successfully retried as Partitioned DML
   * @param lowerBoundUpdateCount the lower-bound update count returned by Spanner after executing
   *     the statement as Partitioned DML
   */
  default void retryDmlAsPartitionedDmlFinished(
      UUID executionId, Statement statement, long lowerBoundUpdateCount) {}

  /**
   * This method is called when an atomic DML statement failed to be retried as a Partitioned DML
   * statement.
   *
   * @param executionId the unique ID of this statement execution
   * @param statement the statement that failed to be retried as Partitioned DML
   * @param exception the exception that was returned when the statement was executed as Partitioned
   *     DML
   */
  default void retryDmlAsPartitionedDmlFailed(
      UUID executionId, Statement statement, Throwable exception) {}
}
