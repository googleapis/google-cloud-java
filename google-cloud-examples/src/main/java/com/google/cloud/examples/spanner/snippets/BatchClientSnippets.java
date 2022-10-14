/*
 * Copyright 2018 Google LLC
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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in spanner/BatchClient's javadoc. Any change
 * to this file should be reflected in spanner/BatchClient's javadoc.
 */

package com.google.cloud.examples.spanner.snippets;

import com.google.cloud.spanner.BatchClient;
import com.google.cloud.spanner.BatchReadOnlyTransaction;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Partition;
import com.google.cloud.spanner.PartitionOptions;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import java.util.Arrays;
import java.util.List;

/** This class contains snippets for {@link com.google.cloud.spanner.BatchClient} interface. */
public class BatchClientSnippets {

  private final BatchClient batchClient;

  public BatchClientSnippets(BatchClient batchClient) {
    this.batchClient = batchClient;
  }

  /** Example to do a batch strong read. */
  BatchReadOnlyTransaction readStrong() {
    // [START batch_client_strong_read]
    BatchReadOnlyTransaction txn = batchClient.batchReadOnlyTransaction(TimestampBound.strong());
    // [END batch_client_strong_read]
    return txn;
  }

  void partitionQuery() {
    // [START partition_query]
    final BatchReadOnlyTransaction txn =
        batchClient.batchReadOnlyTransaction(TimestampBound.strong());
    List<Partition> partitions =
        txn.partitionQuery(
            PartitionOptions.getDefaultInstance(),
            Statement.of("SELECT SingerId, FirstName, LastName FROM Singers"));

    for (final Partition p : partitions) {
      try (ResultSet results = txn.execute(p)) {
        while (results.next()) {
          long singerId = results.getLong(0);
          String firstName = results.getString(1);
          String lastName = results.getString(2);
          System.out.println("[" + singerId + "] " + firstName + " " + lastName);
        }
      }
    }
    // [END partition_query]

  }

  void partitionRead() {
    // [START partition_read]
    final BatchReadOnlyTransaction txn =
        batchClient.batchReadOnlyTransaction(TimestampBound.strong());
    List<Partition> partitions =
        txn.partitionRead(
            PartitionOptions.getDefaultInstance(),
            "Singers",
            KeySet.all(),
            Arrays.asList("SingerId", "FirstName", "LastName"));
    for (final Partition p : partitions) {
      try (ResultSet results = txn.execute(p)) {
        while (results.next()) {
          long singerId = results.getLong(0);
          String firstName = results.getString(1);
          String lastName = results.getString(2);
          System.out.println("[" + singerId + "] " + firstName + " " + lastName);
        }
      }
    }
    // [END partition_read]
  }

  void partitionReadUsingIndex() {
    // [START partition_read_using_index]
    final BatchReadOnlyTransaction txn =
        batchClient.batchReadOnlyTransaction(TimestampBound.strong());
    List<Partition> partitions =
        txn.partitionReadUsingIndex(
            PartitionOptions.getDefaultInstance(),
            "Singers",
            "SingerId",
            KeySet.all(),
            Arrays.asList("SingerId", "FirstName", "LastName"));

    for (Partition p : partitions) {
      try (ResultSet results = txn.execute(p)) {
        while (results.next()) {
          long singerId = results.getLong(0);
          String firstName = results.getString(1);
          String lastName = results.getString(2);
          System.out.println("[" + singerId + "] " + firstName + " " + lastName);
        }
      }
    }
    // [END partition_read_using_index]
  }
}
