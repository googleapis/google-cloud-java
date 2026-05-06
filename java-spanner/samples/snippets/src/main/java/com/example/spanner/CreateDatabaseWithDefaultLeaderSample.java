/*
 * Copyright 2023 Google LLC
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

//[START spanner_create_database_with_default_leader]

import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.common.collect.ImmutableList;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class CreateDatabaseWithDefaultLeaderSample {

  static void createDatabaseWithDefaultLeader() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    final String instanceName = "projects/my-project/instances/my-instance-id";
    final String databaseId = "my-database-name";
    final String defaultLeader = "my-default-leader";
    createDatabaseWithDefaultLeader(instanceName, databaseId, defaultLeader);
  }

  static void createDatabaseWithDefaultLeader(String instanceName, String databaseId,
      String defaultLeader) throws IOException {
    try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
      Database createdDatabase =
          databaseAdminClient.createDatabaseAsync(
              CreateDatabaseRequest.newBuilder()
                  .setParent(instanceName)
                  .setCreateStatement("CREATE DATABASE `" + databaseId + "`")
                  .addAllExtraStatements(
                      ImmutableList.of("CREATE TABLE Singers ("
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
                              + " SET OPTIONS ( default_leader = '" + defaultLeader + "' )"))
                  .build()).get();
      System.out.println("Created database [" + createdDatabase.getName() + "]");
      System.out.println("\tDefault leader: " + createdDatabase.getDefaultLeader());
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