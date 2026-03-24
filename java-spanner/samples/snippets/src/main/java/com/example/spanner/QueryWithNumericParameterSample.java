/*
 * Copyright 2020 Google Inc.
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

// [START spanner_query_with_numeric_parameter]
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import java.math.BigDecimal;

class QueryWithNumericParameterSample {

  static void queryWithNumericParameter() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      queryWithNumericParameter(client);
    }
  }

  static void queryWithNumericParameter(DatabaseClient client) {
    Statement statement =
        Statement.newBuilder(
                "SELECT VenueId, Revenue FROM Venues WHERE Revenue < @numeric")
            .bind("numeric")
            .to(new BigDecimal("100000"))
            .build();
    try (ResultSet resultSet = client.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s%n", resultSet.getLong("VenueId"), resultSet.getBigDecimal("Revenue"));
      }
    }
  }
}
// [END spanner_query_with_numeric_parameter]
