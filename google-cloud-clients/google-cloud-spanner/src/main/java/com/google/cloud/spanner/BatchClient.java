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

/**
 * Interface for the Batch Client that is used to read data from a Cloud Spanner database. An
 * instance of this is tied to a specific database.
 *
 * <p>{@code BatchClient} is useful when one wants to read or query a large amount of data from
 * Cloud Spanner across multiple processes, even across different machines. It allows to create
 * partitions of Cloud Spanner database and then read or query over each partition independently yet
 *  at the same snapshot.
 */
public interface BatchClient {

  /**
   * Returns a {@link BatchReadOnlyTransaction} context in which multiple reads and/or queries can
   * be performed. All reads/queries will use the same timestamp, and the timestamp can be inspected
   * after this transaction is created successfully. This is a blocking method
   * since it waits to finish the rpcs.
   *
   * <p>Note that the bounded staleness modes, {@link TimestampBound.Mode#MIN_READ_TIMESTAMP} and
   * {@link TimestampBound.Mode#MAX_STALENESS}, are not supported for
   * {@link BatchReadOnlyTransaction}.
   *
   * @param bound the timestamp bound at which to perform the read
   */
  BatchReadOnlyTransaction batchReadOnlyTransaction(TimestampBound bound);

  /**
   * Returns a {@link BatchReadOnlyTransaction} context in which multiple reads and/or queries can
   * be performed. This is a non-blocking method. All reads/queries will use the same timestamp, and
   * the timestamp can be inspected after this transaction is created successfully.
   *
   * <p>This method is useful to recreate a BatchReadOnlyTransaction object from an existing
   * batchTransactionId. For example one might send the transaction id to a different process or
   * machine and recreate the transaction object there.
   *
   * @param batchTransactionId to re-initialize the transaction, re-using the timestamp for
   *     successive read/query.
   */
  BatchReadOnlyTransaction batchReadOnlyTransaction(BatchTransactionId batchTransactionId);
}
