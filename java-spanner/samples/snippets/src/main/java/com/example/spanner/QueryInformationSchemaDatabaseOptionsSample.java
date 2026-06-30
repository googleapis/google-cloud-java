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

//[START spanner_query_information_schema_database_options]

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;

public class QueryInformationSchemaDatabaseOptionsSample {

  static void queryInformationSchemaDatabaseOptions() {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "my-project";
    final String instanceId = "my-instance";
    final String databaseId = "my-database";
    queryInformationSchemaDatabaseOptions(projectId, instanceId, databaseId);
  }

  static void queryInformationSchemaDatabaseOptions(
      String projectId, String instanceId, String databaseId) {
    try (Spanner spanner = SpannerOptions
        .newBuilder()
        .setProjectId(projectId)
        .build()
        .getService()) {
      final DatabaseId id = DatabaseId.of(projectId, instanceId, databaseId);
      final DatabaseClient databaseClient = spanner.getDatabaseClient(id);

      try (ResultSet resultSet = databaseClient
          .singleUse()
          .executeQuery(Statement.of(
              "SELECT OPTION_NAME, OPTION_VALUE"
                  + " FROM INFORMATION_SCHEMA.DATABASE_OPTIONS"
                  + " WHERE OPTION_NAME = 'default_leader'")
          )) {
        if (resultSet.next()) {
          final String optionName = resultSet.getString("OPTION_NAME");
          final String optionValue = resultSet.getString("OPTION_VALUE");

          System.out.println("The " + optionName + " for " + id + " is " + optionValue);
        } else {
          System.out.println(
              "Database " + id + " does not have a value for option 'default_leader'"
          );
        }
      }
    }
  }
}
//[END spanner_query_information_schema_database_options]
