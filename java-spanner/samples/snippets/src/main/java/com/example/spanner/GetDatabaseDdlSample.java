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

//[START spanner_get_database_ddl]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.database.v1.GetDatabaseDdlResponse;

public class GetDatabaseDdlSample {

  static void getDatabaseDdl() {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "my-project";
    final String instanceId = "my-instance";
    final String databaseId = "my-database";
    getDatabaseDdl(projectId, instanceId, databaseId);
  }

  static void getDatabaseDdl(
      String projectId, String instanceId, String databaseId) {
    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
        DatabaseAdminClient databaseAdminClient = spanner.createDatabaseAdminClient()) {
      final GetDatabaseDdlResponse response =
          databaseAdminClient.getDatabaseDdl(DatabaseName.of(projectId, instanceId, databaseId));
      System.out.println("Retrieved database DDL for " + databaseId);
      for (String ddl : response.getStatementsList()) {
        System.out.println(ddl);
      }
    }
  }
}
//[END spanner_get_database_ddl]
