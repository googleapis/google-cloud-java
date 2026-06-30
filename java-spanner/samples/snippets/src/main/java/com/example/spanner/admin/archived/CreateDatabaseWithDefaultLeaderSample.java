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

//[START spanner_create_database_with_default_leader]

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

public class CreateDatabaseWithDefaultLeaderSample {

  static void createDatabaseWithDefaultLeader() {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "my-project";
    final String instanceId = "my-instance";
    final String databaseId = "my-database";
    final String defaultLeader = "my-default-leader";
    createDatabaseWithDefaultLeader(projectId, instanceId, databaseId, defaultLeader);
  }

  static void createDatabaseWithDefaultLeader(
      String projectId, String instanceId, String databaseId, String defaultLeader) {
    try (Spanner spanner = SpannerOptions
        .newBuilder()
        .setProjectId(projectId)
        .build()
        .getService()) {
      final DatabaseAdminClient databaseAdminClient = spanner.getDatabaseAdminClient();
      final OperationFuture<Database, CreateDatabaseMetadata> operation = databaseAdminClient
          .createDatabase(
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
                      + " SET OPTIONS ( default_leader = '" + defaultLeader + "' )"
              )
          );
      final Database database = operation.get();
      System.out.println("Created database [" + database.getId() + "]");
      System.out.println("\tDefault leader: " + database.getDefaultLeader());
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
//[END spanner_create_database_with_default_leader]
