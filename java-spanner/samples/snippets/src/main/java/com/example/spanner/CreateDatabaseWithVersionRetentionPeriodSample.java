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

package com.example.spanner;

// [START spanner_create_database_with_version_retention_period]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.common.collect.Lists;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.InstanceName;
import java.util.concurrent.ExecutionException;

public class CreateDatabaseWithVersionRetentionPeriodSample {

  static void createDatabaseWithVersionRetentionPeriod() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    String versionRetentionPeriod = "7d";

    createDatabaseWithVersionRetentionPeriod(projectId, instanceId, databaseId,
        versionRetentionPeriod);
  }

  static void createDatabaseWithVersionRetentionPeriod(String projectId,
      String instanceId, String databaseId, String versionRetentionPeriod) {
    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
        DatabaseAdminClient databaseAdminClient = spanner.createDatabaseAdminClient()) {
      CreateDatabaseRequest request =
          CreateDatabaseRequest.newBuilder()
              .setParent(InstanceName.of(projectId, instanceId).toString())
              .setCreateStatement("CREATE DATABASE `" + databaseId + "`")
              .addAllExtraStatements(Lists.newArrayList("ALTER DATABASE " + "`" + databaseId + "`"
                  + " SET OPTIONS ( version_retention_period = '" + versionRetentionPeriod + "' )"))
              .build();
      Database database =
          databaseAdminClient.createDatabaseAsync(request).get();
      System.out.println("Created database [" + database.getName() + "]");
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
