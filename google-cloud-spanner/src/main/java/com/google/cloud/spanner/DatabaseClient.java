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

/**
 * Interface for all the APIs that are used to read/write data into a Cloud Spanner database. An
 * instance of this is tied to a specific database.
 */
public interface DatabaseClient {

  /**
   * Writes the given mutations atomically to the database.
   *
   * <p>This method uses retries and replay protection internally, which means that the mutations
   * are applied exactly once on success, or not at all if an error is returned, regardless of any
   * failures in the underlying network. Note that if the call is cancelled or reaches deadline, it
   * is not possible to know whether the mutations were applied without performing a subsequent
   * database operation, but the mutations will have been applied at most once.
   *
   * @return the timestamp at which the write was committed
   */
  Timestamp write(Iterable<Mutation> mutations) throws SpannerException;

  /**
   * Writes the given mutations atomically to the database without replay protection.
   *
   * <p>Since this method does not feature replay protection, it may attempt to apply {@code
   * mutations} more than once; if the mutations are not idempotent, this may lead to a failure
   * being reported when the mutation was applied once. For example, an insert may fail with {@link
   * ErrorCode#ALREADY_EXISTS} even though the row did not exist before this method was called. For
   * this reason, most users of the library will prefer to use {@link #write(Iterable)} instead.
   * However, {@code writeAtLeastOnce()} requires only a single RPC, whereas {@code write()}
   * requires two RPCs (one of which may be performed in advance), and so this method may be
   * appropriate for latency sensitive and/or high throughput blind writing.
   *
   * @return the timestamp at which the write was committed
   */
  Timestamp writeAtLeastOnce(Iterable<Mutation> mutations) throws SpannerException;

  /**
   * Returns a context in which a single read can be performed using {@link TimestampBound#strong()}
   * concurrency.
   */
  ReadContext singleUse();

  /**
   * Returns a context in which a single read can be performed.
   *
   * @param bound the timestamp bound at which to perform the read
   */
  ReadContext singleUse(TimestampBound bound);

  /**
   * Returns a read-only transaction context in which a single read or query can be performed using
   * {@link TimestampBound#strong()} concurrency. This method differs from {@link #singleUse()} in
   * that the read timestamp used may be inspected after the read has returned data or finished
   * successfully.
   */
  ReadOnlyTransaction singleUseReadOnlyTransaction();

  /**
   * Returns a read-only transaction context in which a single read or query can be performed. This
   * method differs from {@link #singleUse(TimestampBound)} in that the read timestamp used may be
   * inspected after the read has returned data or finished successfully.
   *
   * @param bound the timestamp bound at which to perform the read
   */
  ReadOnlyTransaction singleUseReadOnlyTransaction(TimestampBound bound);

  /**
   * Returns a read-only transaction context in which a multiple reads and/or queries can be
   * performed using {@link TimestampBound#strong()} concurrency. All reads/queries will use the
   * same timestamp, and the timestamp can be inspected after any read/query has returned data or
   * finished successfully.
   */
  ReadOnlyTransaction readOnlyTransaction();

  /**
   * Returns a read-only transaction context in which a multiple reads and/or queries can be
   * performed. All reads/queries will use the same timestamp, and the timestamp can be inspected
   * after any read/query has returned data or finished successfully.
   *
   * <p>Note that the bounded staleness modes, {@link TimestampBound.Mode#MIN_READ_TIMESTAMP} and
   * {@link TimestampBound.Mode#MAX_STALENESS}, are not supported for multi-use read-only
   * transactions.
   *
   * @param bound the timestamp bound at which to perform the read
   */
  ReadOnlyTransaction readOnlyTransaction(TimestampBound bound);

  /**
   * Returns a transaction runner for executing a single logical transaction with retries. The
   * returned runner can only be used once.
   */
  TransactionRunner readWriteTransaction();
}
