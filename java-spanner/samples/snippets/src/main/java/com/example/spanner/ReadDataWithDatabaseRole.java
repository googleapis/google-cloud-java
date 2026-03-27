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

// [START spanner_read_data_with_database_role]
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import java.util.Arrays;

public class ReadDataWithDatabaseRole {

  static void readDataWithDatabaseRole() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    String role = "my-role";
    readDataWithDatabaseRole(projectId, instanceId, databaseId, role);
  }

  static void readDataWithDatabaseRole(
      String projectId, String instanceId, String databaseId, String role) {
    try (Spanner spannerWithRole =
        SpannerOptions.newBuilder()
            .setProjectId(projectId)
            .setDatabaseRole(role)
            .build()
            .getService()) {
      DatabaseClient dbClient =
          spannerWithRole.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      ResultSet resultSet =
          dbClient
              .singleUse()
              .read(
                  "Singers",
                  KeySet.all(),
                  Arrays.asList("SingerId", "FirstName", "LastName"));
      while (resultSet.next()) {
        System.out.printf("SingerId: %d\n", resultSet.getLong(0));
        System.out.printf("FirstName: %s\n", resultSet.getString(1));
        System.out.printf("LastName: %s\n", resultSet.getString(2));
      }
    }
  }
}
// [END spanner_read_data_with_database_role]
