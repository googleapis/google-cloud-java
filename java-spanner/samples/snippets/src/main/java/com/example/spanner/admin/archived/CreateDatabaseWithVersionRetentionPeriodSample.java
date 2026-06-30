/*
 * Copyright 2021 Google LLC
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

package com.example.spanner.admin.archived;

// [START spanner_create_database_with_version_retention_period]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class CreateDatabaseWithVersionRetentionPeriodSample {

  static void createDatabaseWithVersionRetentionPeriod() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    String versionRetentionPeriod = "7d";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseAdminClient adminClient = spanner.getDatabaseAdminClient();
      createDatabaseWithVersionRetentionPeriod(adminClient, instanceId, databaseId,
          versionRetentionPeriod);
    }
  }

  static void createDatabaseWithVersionRetentionPeriod(DatabaseAdminClient adminClient,
      String instanceId, String databaseId, String versionRetentionPeriod) {
    OperationFuture<Database, CreateDatabaseMetadata> op =
        adminClient.createDatabase(
            instanceId,
            databaseId,
            Arrays.asList(
                "CREATE TABLE Singers ("
                    + "  SingerId   INT64 NOT NULL,"
                    + "  FirstName  STRING(1024),"
                    + "  LastName   STRING(1024),"
                    + "  SingerInfo BYTES(MAX)"
                    + ") PRIMARY KEY (SingerId)",
                "CREATE TABLE Albums ("
                    + "  SingerId     INT64 NOT NULL,"
                    + "  AlbumId      INT64 NOT NULL,"
                    + "  AlbumTitle   STRING(MAX)"
                    + ") PRIMARY KEY (SingerId, AlbumId),"
                    + "  INTERLEAVE IN PARENT Singers ON DELETE CASCADE",
                "ALTER DATABASE " + "`" + databaseId + "`"
                    + " SET OPTIONS ( version_retention_period = '" + versionRetentionPeriod + "' )"
            ));
    try {
      Database database = op.get();
      System.out.println("Created database [" + database.getId() + "]");
      System.out.println("\tVersion retention period: " + database.getVersionRetentionPeriod());
      System.out.println("\tEarliest version time: " + database.getEarliestVersionTime());
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
}
// [END spanner_create_database_with_version_retention_period]
