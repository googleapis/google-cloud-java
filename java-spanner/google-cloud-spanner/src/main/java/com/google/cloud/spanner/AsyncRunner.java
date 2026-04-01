/*
 * Copyright 2020 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import io.grpc.Status.Code;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public interface AsyncRunner {

  /**
   * Functional interface for executing a read/write transaction asynchronously that returns a
   * result of type R.
   */
  @FunctionalInterface
  interface AsyncWork<R> {
    /**
     * Performs a single transaction attempt. All reads/writes should be performed using {@code
     * txn}.
     *
     * <p>Implementations of this method should not attempt to commit the transaction directly:
     * returning normally will result in the runner attempting to commit the transaction once the
     * returned future completes, retrying on abort.
     *
     * <p>In most cases, the implementation will not need to catch {@code SpannerException}s from
     * Spanner operations, instead letting these propagate to the framework. The transaction runner
     * will take appropriate action based on the type of exception. In particular, implementations
     * should never catch an exception of type {@link Code#ABORTED}: these indicate that some reads
     * may have returned inconsistent data and the transaction attempt must be aborted.
     *
     * @param txn the transaction
     * @return future over the result of the work
     */
    ApiFuture<R> doWorkAsync(TransactionContext txn);
  }

  /** Executes a read/write transaction asynchronously using the given executor. */
  <R> ApiFuture<R> runAsync(AsyncWork<R> work, Executor executor);

  /**
   * Returns the timestamp at which the transaction committed. {@link ApiFuture#get()} will throw an
   * {@link ExecutionException} if the transaction did not commit.
   */
  ApiFuture<Timestamp> getCommitTimestamp();

  /**
   * Returns the {@link CommitResponse} of this transaction. {@link ApiFuture#get()} throws an
   * {@link ExecutionException} if the transaction did not commit.
   */
  ApiFuture<CommitResponse> getCommitResponse();
}
