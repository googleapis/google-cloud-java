/*
 * Copyright 2025 Google LLC
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

package com.example.spanner;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;

/**
 * Sample showing how to set exclude transaction from change streams in different write requests.
 */
public class ChangeStreamsTxnExclusionSample {

  static void setExcludeTxnFromChangeStreams() {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "my-instance";
    final String instanceId = "my-project";
    final String databaseId = "my-database";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      final DatabaseClient databaseClient =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      readWriteTxnExcludedFromChangeStreams(databaseClient);
    }
  }

  // [START spanner_set_exclude_txn_from_change_streams]
  static void readWriteTxnExcludedFromChangeStreams(DatabaseClient client) {
    // Exclude the transaction from allowed tracking change streams with alloww_txn_exclusion=true.
    // This exclusion will be applied to all the individual operations inside this transaction.
    client
        .readWriteTransaction(Options.excludeTxnFromChangeStreams())
        .run(
            transaction -> {
              transaction.executeUpdate(
                  Statement.of(
                      "INSERT Singers (SingerId, FirstName, LastName)\n"
                          + "VALUES (1341, 'Virginia', 'Watson')"));
              System.out.println("New singer inserted.");

              transaction.executeUpdate(
                  Statement.of("UPDATE Singers SET FirstName = 'Hi' WHERE SingerId = 111"));
              System.out.println("Singer first name updated.");

              return null;
            });
  }
  // [END spanner_set_exclude_txn_from_change_streams]

}
