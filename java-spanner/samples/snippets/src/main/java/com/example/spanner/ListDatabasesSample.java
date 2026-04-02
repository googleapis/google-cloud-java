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

//[START spanner_list_databases]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabasesPage;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabasesPagedResponse;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.InstanceName;

public class ListDatabasesSample {

  static void listDatabases() {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "my-project";
    final String instanceId = "my-instance";
    listDatabases(projectId, instanceId);
  }

  static void listDatabases(String projectId, String instanceId) {
    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
        DatabaseAdminClient databaseAdminClient = spanner.createDatabaseAdminClient()) {
      ListDatabasesPagedResponse response =
          databaseAdminClient.listDatabases(InstanceName.of(projectId, instanceId));

      System.out.println("Databases for projects/" + projectId + "/instances/" + instanceId);

      for (ListDatabasesPage page : response.iteratePages()) {
        for (Database database : page.iterateAll()) {
          final String defaultLeader = database.getDefaultLeader().equals("")
              ? "" : "(default leader = " + database.getDefaultLeader() + ")";
          System.out.println("\t" + database.getName() + " " + defaultLeader);
        }
      }
    }
  }
}
//[END spanner_list_databases]
