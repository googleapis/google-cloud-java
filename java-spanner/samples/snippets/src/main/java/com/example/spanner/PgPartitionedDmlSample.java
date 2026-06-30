/*
 * Copyright 2022 Google Inc.
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

// [START spanner_postgresql_partitioned_dml]

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;

class PgPartitionedDmlSample {

  static void partitionedDml() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    partitionedDml(projectId, instanceId, databaseId);
  }

  static void partitionedDml(String projectId, String instanceId, String databaseId) {
    try (Spanner spanner =
        SpannerOptions.newBuilder()
            .setProjectId(projectId)
            .build()
            .getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));

      // Spanner PostgreSQL has the same transaction limits as normal Spanner. This includes a
      // maximum of 20,000 mutations in a single read/write transaction. Large update operations can
      // be executed using Partitioned DML. This is also supported on Spanner PostgreSQL.
      // See https://cloud.google.com/spanner/docs/dml-partitioned for more information.
      long deletedCount =
          client.executePartitionedUpdate(Statement.of("DELETE FROM users WHERE active=false"));
      // The returned update count is the lower bound of the number of records that was deleted.
      System.out.printf("Deleted at least %d inactive users\n", deletedCount);
    }
  }
}
// [END spanner_postgresql_partitioned_dml]