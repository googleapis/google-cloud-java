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

// [START spanner_list_database_roles]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabaseRolesPage;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabaseRolesPagedResponse;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.database.v1.DatabaseRole;

public class ListDatabaseRoles {

  static void listDatabaseRoles() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    listDatabaseRoles(projectId, instanceId, databaseId);
  }

  static void listDatabaseRoles(String projectId, String instanceId, String databaseId) {
    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
        DatabaseAdminClient databaseAdminClient = spanner.createDatabaseAdminClient()) {
      DatabaseName databaseName = DatabaseName.of(projectId, instanceId, databaseId);
      ListDatabaseRolesPagedResponse response
          = databaseAdminClient.listDatabaseRoles(databaseName);
      System.out.println("List of Database roles");
      for (ListDatabaseRolesPage page : response.iteratePages()) {
        for (DatabaseRole role : page.iterateAll()) {
          System.out.printf("Obtained role %s%n", role.getName());
        }
      }
    }
  }
}
// [END spanner_list_database_roles]
