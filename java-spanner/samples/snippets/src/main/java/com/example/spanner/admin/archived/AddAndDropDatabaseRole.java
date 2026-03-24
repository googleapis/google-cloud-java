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

package com.example.spanner.admin.archived;

// [START spanner_add_and_drop_database_role]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.collect.ImmutableList;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AddAndDropDatabaseRole {

  static void addAndDropDatabaseRole() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    String parentRole = "my-new-parent-role";
    String childRole = "my-new-child-role";
    addAndDropDatabaseRole(projectId, instanceId, databaseId, parentRole, childRole);
  }

  static void addAndDropDatabaseRole(
      String projectId, String instanceId, String databaseId, String parentRole, String childRole) {
    try (Spanner spanner =
                 SpannerOptions.newBuilder()
                         .setProjectId(projectId)
                         .build()
                         .getService())  {
      final DatabaseAdminClient adminClient = spanner.getDatabaseAdminClient();
      OperationFuture<Void, UpdateDatabaseDdlMetadata> operation =
          adminClient.updateDatabaseDdl(
              instanceId,
              databaseId,
              ImmutableList.of(
                  "CREATE ROLE " + parentRole,
                  "GRANT SELECT ON TABLE Singers TO ROLE " + parentRole,
                  "GRANT SELECT ON TABLE Albums TO ROLE " + parentRole,
                  "CREATE ROLE " + childRole,
                  "GRANT ROLE " + parentRole + " TO ROLE " + childRole),
              null);
      try {
        System.out.println("Waiting for role create operation to complete...");
        operation.get(5, TimeUnit.MINUTES);
        System.out.printf(
            "Created roles %s and %s and granted privileges%n", parentRole, childRole);
        // Delete role and membership.
        operation =
            adminClient.updateDatabaseDdl(
                instanceId,
                databaseId,
                ImmutableList.of(
                    "REVOKE ROLE " + parentRole + " FROM ROLE " + childRole,
                    "DROP ROLE " + childRole),
                null);
        System.out.println("Waiting for role revoke & drop operation to complete...");
        operation.get(5, TimeUnit.MINUTES);
        System.out.printf("Revoked privileges and dropped role %s%n", childRole);
      } catch (ExecutionException | TimeoutException e) {
        System.out.printf(
            "Error: AddAndDropDatabaseRole failed with error message %s\n", e.getMessage());
        e.printStackTrace();
      } catch (InterruptedException e) {
        System.out.println(
            "Error: Waiting for AddAndDropDatabaseRole operation to finish was interrupted");
      }
    }
  }
}
// [END spanner_add_and_drop_database_role]
