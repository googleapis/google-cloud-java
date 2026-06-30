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

package com.example.spanner.admin.archived;

// [START spanner_update_database]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.DatabaseInfo.DatabaseField;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.spanner.admin.database.v1.UpdateDatabaseMetadata;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UpdateDatabaseSample {

  static void updateDatabase() {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "my-project";
    final String instanceId = "my-instance";
    final String databaseId = "my-database";
    updateDatabase(projectId, instanceId, databaseId);
  }

  static void updateDatabase(String projectId, String instanceId, String databaseId) {
    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      final DatabaseAdminClient databaseAdminClient = spanner.getDatabaseAdminClient();

      DatabaseId dbId = DatabaseId.of(projectId, instanceId, databaseId);
      Database databaseToUpdate =
          databaseAdminClient.newDatabaseBuilder(dbId).enableDropProtection().build();
      OperationFuture<Database, UpdateDatabaseMetadata> operation =
          databaseAdminClient.updateDatabase(databaseToUpdate, DatabaseField.DROP_PROTECTION);
      System.out.printf("Waiting for update operation for %s to complete...\n", dbId);
      Database updatedDb = operation.get(5, TimeUnit.MINUTES);
      System.out.printf("Updated database %s.\n", updatedDb.getId().getName());
    } catch (ExecutionException | TimeoutException e) {
      // If the operation failed during execution, expose the cause.
      throw SpannerExceptionFactory.asSpannerException(e.getCause());
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
}
// [END spanner_update_database]
