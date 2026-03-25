/*
 * Copyright 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

import com.google.cloud.spanner.BatchClient;
import com.google.cloud.spanner.BatchReadOnlyTransaction;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Partition;
import com.google.cloud.spanner.PartitionOptions;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/** Sample showing how to run a query using the Batch API. */
public class BatchSample {

  /**
   * This example showcases how to create a batch client, partition a query, and concurrently read
   * from multiple partitions.
   */
  public static void main(String[] args) throws InterruptedException {
    if (args.length != 2) {
      System.err.println("Usage: BatchSample <instance_id> <database_id>");
      return;
    }

    /*
     * CREATE TABLE Singers (
     *   SingerId   INT64 NOT NULL,
     *   FirstName  STRING(1024),
     *   LastName   STRING(1024),
     *   SingerInfo BYTES(MAX),
     * ) PRIMARY KEY (SingerId);
     */

    String instanceId = args[0];
    String databaseId = args[1];

    SpannerOptions options = SpannerOptions.newBuilder().build();
    Spanner spanner = options.getService();

    // [START spanner_batch_client]
    int numThreads = Runtime.getRuntime().availableProcessors();
    ExecutorService executor = Executors.newFixedThreadPool(numThreads);

    // Statistics
    int totalPartitions;
    AtomicInteger totalRecords = new AtomicInteger(0);

    try {
      BatchClient batchClient =
          spanner.getBatchClient(DatabaseId.of(options.getProjectId(), instanceId, databaseId));

      final BatchReadOnlyTransaction txn =
          batchClient.batchReadOnlyTransaction(TimestampBound.strong());

      // A Partition object is serializable and can be used from a different process.
      // DataBoost option is an optional parameter which can be used for partition read
      // and query to execute the request via spanner independent compute resources.

      List<Partition> partitions =
          txn.partitionQuery(
              PartitionOptions.getDefaultInstance(),
              Statement.of("SELECT SingerId, FirstName, LastName FROM Singers"),
              // Option to enable data boost for a given request
              Options.dataBoostEnabled(true));

      totalPartitions = partitions.size();

      for (final Partition p : partitions) {
        executor.execute(
            () -> {
              try (ResultSet results = txn.execute(p)) {
                while (results.next()) {
                  long singerId = results.getLong(0);
                  String firstName = results.getString(1);
                  String lastName = results.getString(2);
                  System.out.println("[" + singerId + "] " + firstName + " " + lastName);
                  totalRecords.getAndIncrement();
                }
              }
            });
      }
    } finally {
      executor.shutdown();
      executor.awaitTermination(1, TimeUnit.HOURS);
      spanner.close();
    }

    double avgRecordsPerPartition = 0.0;
    if (totalPartitions != 0) {
      avgRecordsPerPartition = (double) totalRecords.get() / totalPartitions;
    }
    System.out.println("totalPartitions=" + totalPartitions);
    System.out.println("totalRecords=" + totalRecords);
    System.out.println("avgRecordsPerPartition=" + avgRecordsPerPartition);
    // [END spanner_batch_client]
  }
}
