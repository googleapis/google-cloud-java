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

//[START spanner_update_database_with_default_leader]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

public class UpdateDatabaseWithDefaultLeaderSample {

  static void updateDatabaseWithDefaultLeader() {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "my-project";
    final String instanceId = "my-instance";
    final String databaseId = "my-database";
    final String defaultLeader = "my-default-leader";
    updateDatabaseWithDefaultLeader(projectId, instanceId, databaseId, defaultLeader);
  }

  static void updateDatabaseWithDefaultLeader(
      String projectId, String instanceId, String databaseId, String defaultLeader) {
    try (Spanner spanner = SpannerOptions
        .newBuilder()
        .setProjectId(projectId)
        .build()
        .getService()) {
      final DatabaseAdminClient databaseAdminClient = spanner.getDatabaseAdminClient();
      final OperationFuture<Void, UpdateDatabaseDdlMetadata> operation = databaseAdminClient
          .updateDatabaseDdl(
              instanceId,
              databaseId,
              Collections.singletonList(
                  String.format(
                      "ALTER DATABASE `%s` SET OPTIONS (default_leader = '%s')",
                      databaseId,
                      defaultLeader
                  )
              ),
              null
          );
      operation.get();
      System.out.println("Updated default leader to " + defaultLeader);
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
//[END spanner_update_database_with_default_leader]
