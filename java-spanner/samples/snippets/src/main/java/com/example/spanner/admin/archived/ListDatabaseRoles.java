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

// [START spanner_list_database_roles]
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.DatabaseRole;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import java.util.concurrent.ExecutionException;

public class ListDatabaseRoles {

  static void listDatabaseRoles() throws InterruptedException, ExecutionException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    listDatabaseRoles(projectId, instanceId, databaseId);
  }

  static void listDatabaseRoles(String projectId, String instanceId, String databaseId) {
    try (Spanner spanner =
                 SpannerOptions.newBuilder()
                         .setProjectId(projectId)
                         .build()
                         .getService()) {
      final DatabaseAdminClient adminClient = spanner.getDatabaseAdminClient();
      String databasePath = DatabaseId.of(projectId, instanceId, databaseId).getName();
      System.out.println("List of Database roles");
      for (DatabaseRole role : adminClient.listDatabaseRoles(instanceId, databaseId).iterateAll()) {
        System.out.printf("%s%n", role.getName());
      }
    }
  }
}
// [END spanner_list_database_roles]
