/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import javax.annotation.Nullable;

/**
 * An interface for executing a body of work in the context of a read-write transaction, with
 * retries for transaction aborts. See {@link TransactionContext} for a description of transaction
 * semantics. {@code TransactionRunner} instances are obtained by calling {@link
 * Session#readWriteTransaction()}.
 *
 * <p>A {@code TransactionRunner} instance can only be used for a single invocation of {@link
 * #run(TransactionCallable)}.
 */
public interface TransactionRunner {
  /** A unit of work to be performed in the context of a transaction. */
  interface TransactionCallable<T> {
    /**
     * Invoked by the library framework to perform a single attempt of a transaction. This method
     * may be called more than once if previous transaction attempts aborted. Each invocation can
     * perform zero or more reads or queries and can buffer mutations to be applied to the database
     * when the transaction commits.
     *
     * <p>The framework will attempt to commit the transaction when this method returns normally. If
     * commit is successful, the return value from this method will be returned from {@link
     * TransactionRunner#run(TransactionCallable)}; on failure, the transaction may be retried by
     * the framework by calling the method again.
     *
     * <p>If this method raises an exception, one of two things can happen. If some operation in the
     * transaction has previously detected that the transaction has been aborted, the framework may
     * retry the transaction. Otherwise, the framework will roll back the transaction, releasing any
     * locks held, and yield the exception to the caller as a {@link SpannerException} of type
     * {@link ErrorCode#UNKNOWN} with the exception as the cause.
     */
    @Nullable
    T run(TransactionContext transaction) throws Exception;
  }

  /**
   * Executes a read-write transaction, with retries as necessary. The work to perform in each
   * transaction attempt is defined by {@code callable}, which may return an object as the result of
   * the work. {@code callable} will be retried if a transaction attempt aborts; implementations
   * must be prepared to be called more than once. Any writes buffered by {@code callable} will only
   * be applied if the transaction commits successfully. Similarly, the value produced by {@code
   * callable} will only be returned by this method if the transaction commits successfully.
   *
   * <p>{@code callable} is allowed to raise an unchecked exception. Typically this prevents further
   * attempts to execute {@code callable}, and the exception will propagate from this method call.
   * However, if a read or query in {@code callable} detected that the transaction aborted, {@code
   * callable} will be retried even if it raised an exception.
   */
  @Nullable
  <T> T run(TransactionCallable<T> callable);

  /**
   * Returns the timestamp at which the transaction committed. This method may only be called once
   * {@link #run(TransactionCallable)} has returned normally.
   */
  Timestamp getCommitTimestamp();
}
