/*
 * Copyright 2023 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

// [START spanner_directed_read]
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.DirectedReadOptions.ExcludeReplicas;
import com.google.spanner.v1.DirectedReadOptions.IncludeReplicas;
import com.google.spanner.v1.DirectedReadOptions.ReplicaSelection;

public class DirectedReadSample {
  static void directedRead() {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "my-project";
    final String instanceId = "my-instance";
    final String databaseId = "my-database";
    directedRead(projectId, instanceId, databaseId);
  }

  static void directedRead(String projectId, String instanceId, String databaseId) {
    // Only one of excludeReplicas or includeReplicas can be set
    // Each accepts a list of replicaSelections which contains location and type
    //   * `location` - The location must be one of the regions within the
    //      multi-region configuration of your database.
    //   * `type` - The type of the replica
    // Some examples of using replicaSelectors are:
    //   * `location:us-east1` --> The "us-east1" replica(s) of any available type
    //                             will be used to process the request.
    //   * `type:READ_ONLY`    --> The "READ_ONLY" type replica(s) in nearest
    // .                            available location will be used to process the
    //                             request.
    //   * `location:us-east1 type:READ_ONLY` --> The "READ_ONLY" type replica(s)
    //                          in location "us-east1" will be used to process
    //                          the request.
    //  includeReplicas also contains an option called autoFailoverDisabled, which when set to true
    //  will instruct Spanner to not route requests to a replica outside the
    //  includeReplicas list when all the specified replicas are unavailable
    //  or unhealthy. Default value is `false`.
    final DirectedReadOptions directedReadOptionsForClient =
        DirectedReadOptions.newBuilder()
            .setExcludeReplicas(
                ExcludeReplicas.newBuilder()
                    .addReplicaSelections(
                        ReplicaSelection.newBuilder().setLocation("us-east4").build())
                    .build())
            .build();

    // You can set default `DirectedReadOptions` for a Spanner client. These options will be applied
    // to all read-only transactions that are executed by this client, unless specific
    // DirectedReadOptions are set for a query.
    // Directed read can only be used for read-only transactions. The default options will be
    // ignored for any read/write transaction that the client executes.
    try (Spanner spanner =
        SpannerOptions.newBuilder()
            .setProjectId(projectId)
            .setDirectedReadOptions(directedReadOptionsForClient)
            .build()
            .getService()) {
      final DatabaseClient dbClient =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));

      // DirectedReadOptions at request level will override the options set at
      // client level (through SpannerOptions).
      final DirectedReadOptions directedReadOptionsForRequest =
          DirectedReadOptions.newBuilder()
              .setIncludeReplicas(
                  IncludeReplicas.newBuilder()
                      .addReplicaSelections(
                          ReplicaSelection.newBuilder()
                              .setType(ReplicaSelection.Type.READ_WRITE)
                              .build())
                      .setAutoFailoverDisabled(true)
                      .build())
              .build();

      // Read rows while passing DirectedReadOptions directly to the query.
      try (ResultSet rs =
          dbClient
              .singleUse()
              .executeQuery(
                  Statement.of("SELECT SingerId, AlbumId, AlbumTitle FROM Albums"),
                  Options.directedRead(directedReadOptionsForRequest))) {
        while (rs.next()) {
          System.out.printf(
              "SingerId: %d, AlbumId: %d, AlbumTitle: %s\n",
              rs.getLong(0), rs.getLong(1), rs.getString(2));
        }
        System.out.println("Successfully executed read-only transaction with directedReadOptions");
      }
    }
  }
}
// [END spanner_directed_read]
