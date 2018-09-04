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

import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;

import java.util.List;

/**
 * {@code BatchReadOnlyTransaction} can be configured to read at timestamps in the past and allows
 * for exporting arbitrarily large amounts of data from Cloud Spanner databases. This is a read only
 * transaction which additionally allows to partition a read or query request.
 * Read/query request can then be executed independently over each partition while observing the
 * same snapshot of the database. BatchReadOnlyTransaction can also be shared across multiple
 * processes/machines by passing around the BatchTransactionId and then recreating the transaction
 * using {@link BatchClient#batchReadOnlyTransaction(BatchTransactionId)}.
 *
 * <p>Unlike locking read-write transactions, BatchReadOnlyTransaction never abort. They can fail
 * if the chosen read timestamp is garbage collected; however any read or query activity within an
 * hour on the transaction avoids garbage collection and most applications do not need to worry
 * about this in practice.
 *
 * <p>To execute a BatchReadOnlyTransaction, specify a {@link TimestampBound}, which tells Cloud
 * Spanner how to choose a read timestamp.
 *
 */
public interface BatchReadOnlyTransaction extends ReadOnlyTransaction {

  /**
   * Returns a list of {@link Partition} to read zero or more rows from a database.
   *
   * <p> These partitions can be executed across multiple processes, even across different machines.
   * The partition size and count hints can be configured using {@link PartitionOptions}.
   *
   * @param partitionOptions configuration for size and count of partitions returned
   * @param table the name of the table to read
   * @param keys the keys and ranges of rows to read. Regardless of ordering in {@code keys}, rows
   *     are returned in their natural key order.
   * @param columns the columns to read
   * @param options the options to configure the read, supported values are
   * {@link Options#prefetchChunks()}
   *
   * <!--SNIPPET partition_read-->
   * <pre>{@code
   * final BatchReadOnlyTransaction txn =
   *     batchClient.batchReadOnlyTransaction(TimestampBound.strong());
   * List<Partition> partitions =
   *     txn.partitionRead(
   *         PartitionOptions.getDefaultInstance(),
   *         "Singers",
   *         KeySet.all(),
   *         Arrays.asList("SingerId", "FirstName", "LastName"));
   * for (final Partition p : partitions) {
   *   try (ResultSet results = txn.execute(p)) {
   *     while (results.next()) {
   *       long singerId = results.getLong(0);
   *       String firstName = results.getString(1);
   *       String lastName = results.getString(2);
   *       System.out.println("P2 [" + singerId + "] " + firstName + " " + lastName);
   *     }
   *   }
   * }
   * }</pre>
   * <!--SNIPPET partition_read-->
   */
  List<Partition> partitionRead(
      PartitionOptions partitionOptions,
      String table,
      KeySet keys,
      Iterable<String> columns,
      ReadOption... options) throws SpannerException;

  /**
   * Returns a list of {@link Partition} to read zero or more rows from a database using an index.
   *
   * <p> These partitions can be executed across multiple processes, even across different machines.
   * The partition size and count can be configured using {@link PartitionOptions}. Though it may
   * not necessarily be honored depending on the parameters in the request.
   *
   * @param partitionOptions configuration for size and count of partitions returned
   * @param table the name of the table to read
   * @param index the name of the index on {@code table} to use
   * @param keys the keys and ranges of index rows to read. Regardless of ordering in {@code keys},
   *     rows are returned in the natural key order of the index.
   * @param columns the columns to read
   * @param options the options to configure the read
   *
   * <!--SNIPPET partition_read_using_index-->
   * <pre>{@code
   * final BatchReadOnlyTransaction txn =
   *     batchClient.batchReadOnlyTransaction(TimestampBound.strong());
   * List<Partition> partitions =
   *     txn.partitionReadUsingIndex(
   *         PartitionOptions.getDefaultInstance(),
   *         "Singers",
   *         "SingerId",
   *         KeySet.all(),
   *         Arrays.asList("FirstName"));
   * BatchTransactionId txnID = txn.getBatchTransactionId();
   * int numRowsRead = 0;
   * for (Partition p : partitions) {
   *   BatchReadOnlyTransaction batchTxnOnEachWorker = batchClient.batchReadOnlyTransaction(txnID);
   *   try (ResultSet results = batchTxnOnEachWorker.execute(p)) {
   *     while (results.next()) {
   *       System.out.println(results.getString(0));
   *     }
   *   }
   * }
   * }</pre>
   * <!--SNIPPET partition_read_using_index-->
   */
  List<Partition> partitionReadUsingIndex(
      PartitionOptions partitionOptions,
      String table,
      String index,
      KeySet keys,
      Iterable<String> columns,
      ReadOption... options) throws SpannerException;

  /**
   * Returns a list of {@link Partition} to execute a query against the database.
   *
   * <p> These partitions can be executed across multiple processes, even across different machines.
   * The partition size and count can be configured using {@link PartitionOptions}. Though it may
   * not necessarily be honored depending on the query and options in the request.
   *
   * @param partitionOptions configuration for size and count of partitions returned
   * @param statement the query statement to execute
   * @param options the options to configure the query
   *
   * <!--SNIPPET partition_query-->
   * <pre>{@code
   * final BatchReadOnlyTransaction txn =
   *     batchClient.batchReadOnlyTransaction(TimestampBound.strong());
   * List<Partition> partitions = txn.partitionQuery(PartitionOptions.getDefaultInstance(),
   *     Statement.of("SELECT SingerId, FirstName, LastName FROM Singers"));
   *
   * for (final Partition p : partitions) {
   *   try (ResultSet results = txn.execute(p)) {
   *     while (results.next()) {
   *       long singerId = results.getLong(0);
   *       String firstName = results.getString(1);
   *       String lastName = results.getString(2);
   *       System.out.println("[" + singerId + "] " + firstName + " " + lastName);
   *     }
   *   }
   * }
   * }</pre>
   * <!--SNIPPET partition_query-->
   */
  List<Partition> partitionQuery(
      PartitionOptions partitionOptions, Statement statement, QueryOption... options)
      throws SpannerException;

  /**
   * Execute the partition to return {@link ResultSet}. The result returned could be zero or more
   * rows. The row metadata may be absent if no rows are returned.
   *
   * <!--SNIPPET partition_query-->
   * <pre>{@code
   * final BatchReadOnlyTransaction txn =
   *     batchClient.batchReadOnlyTransaction(TimestampBound.strong());
   * List<Partition> partitions = txn.partitionQuery(PartitionOptions.getDefaultInstance(),
   *     Statement.of("SELECT SingerId, FirstName, LastName FROM Singers"));
   *
   * for (final Partition p : partitions) {
   *   try (ResultSet results = txn.execute(p)) {
   *     while (results.next()) {
   *       long singerId = results.getLong(0);
   *       String firstName = results.getString(1);
   *       String lastName = results.getString(2);
   *       System.out.println("[" + singerId + "] " + firstName + " " + lastName);
   *     }
   *   }
   * }
   * }</pre>
   * <!--SNIPPET partition_query-->
   *
   */
  ResultSet execute(Partition partition) throws SpannerException;

  /**
   * Returns a {@link BatchTransactionId} to be re-used across several machines/processes. This
   * BatchTransactionId guarantees the subsequent read/query to be executed at the same timestamp.
   *
   * <!--SNIPPET batch_client_read_with_id-->
   * <pre>{@code
   * BatchTransactionId txnId = my_txn.getBatchTransactionId();
   * BatchReadOnlyTransaction txn = batchClient.batchReadOnlyTransaction(txnId);
   * }</pre>
   * <!--SNIPPET batch_client_read_with_id-->
   *
   */
  BatchTransactionId getBatchTransactionId();
}
