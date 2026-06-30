/*
 * Copyright 2023 Google LLC
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

// [START spanner_batch_write_at_least_once]

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.MutationGroup;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.collect.ImmutableList;
import com.google.rpc.Code;
import com.google.spanner.v1.BatchWriteResponse;

public class BatchWriteAtLeastOnceSample {

  /***
   * Assume DDL for the underlying database:
   * <pre>{@code
   *   CREATE TABLE Singers (
   *     SingerId   INT64 NOT NULL,
   *     FirstName  STRING(1024),
   *     LastName   STRING(1024),
   *   ) PRIMARY KEY (SingerId)
   *
   *   CREATE TABLE Albums (
   *     SingerId     INT64 NOT NULL,
   *     AlbumId      INT64 NOT NULL,
   *     AlbumTitle   STRING(1024),
   *   ) PRIMARY KEY (SingerId, AlbumId),
   *   INTERLEAVE IN PARENT Singers ON DELETE CASCADE
   * }</pre>
   */

  private static final MutationGroup MUTATION_GROUP1 =
      MutationGroup.of(
          Mutation.newInsertOrUpdateBuilder("Singers")
              .set("SingerId")
              .to(16)
              .set("FirstName")
              .to("Scarlet")
              .set("LastName")
              .to("Terry")
              .build());
  private static final MutationGroup MUTATION_GROUP2 =
      MutationGroup.of(
          Mutation.newInsertOrUpdateBuilder("Singers")
              .set("SingerId")
              .to(17)
              .set("FirstName")
              .to("Marc")
              .build(),
          Mutation.newInsertOrUpdateBuilder("Singers")
              .set("SingerId")
              .to(18)
              .set("FirstName")
              .to("Catalina")
              .set("LastName")
              .to("Smith")
              .build(),
          Mutation.newInsertOrUpdateBuilder("Albums")
              .set("SingerId")
              .to(17)
              .set("AlbumId")
              .to(1)
              .set("AlbumTitle")
              .to("Total Junk")
              .build(),
          Mutation.newInsertOrUpdateBuilder("Albums")
              .set("SingerId")
              .to(18)
              .set("AlbumId")
              .to(2)
              .set("AlbumTitle")
              .to("Go, Go, Go")
              .build());

  static void batchWriteAtLeastOnce() {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "my-project";
    final String instanceId = "my-instance";
    final String databaseId = "my-database";
    batchWriteAtLeastOnce(projectId, instanceId, databaseId);
  }

  static void batchWriteAtLeastOnce(String projectId, String instanceId, String databaseId) {
    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseId dbId = DatabaseId.of(projectId, instanceId, databaseId);
      final DatabaseClient dbClient = spanner.getDatabaseClient(dbId);

      // Creates and issues a BatchWrite RPC request that will apply the mutation groups
      // non-atomically and respond back with a stream of BatchWriteResponse.
      ServerStream<BatchWriteResponse> responses =
          dbClient.batchWriteAtLeastOnce(
              ImmutableList.of(MUTATION_GROUP1, MUTATION_GROUP2),
              Options.tag("batch-write-tag"));

      // Iterates through the results in the stream response and prints the MutationGroup indexes,
      // commit timestamp and status.
      for (BatchWriteResponse response : responses) {
        if (response.getStatus().getCode() == Code.OK_VALUE) {
          System.out.printf(
              "Mutation group indexes %s have been applied with commit timestamp %s",
              response.getIndexesList(), response.getCommitTimestamp());
        } else {
          System.out.printf(
              "Mutation group indexes %s could not be applied with error code %s and "
                  + "error message %s", response.getIndexesList(),
              Code.forNumber(response.getStatus().getCode()), response.getStatus().getMessage());
        }
      }
    }
  }
}

// [END spanner_batch_write_at_least_once]
