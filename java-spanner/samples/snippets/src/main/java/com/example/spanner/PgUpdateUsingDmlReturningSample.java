/*
 * Copyright 2022 Google LLC
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

// [START spanner_postgresql_update_dml_returning]

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;

public class PgUpdateUsingDmlReturningSample {

  static void updateUsingDmlReturning() {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "my-project";
    final String instanceId = "my-instance";
    final String databaseId = "my-database";
    updateUsingDmlReturning(projectId, instanceId, databaseId);
  }

  static void updateUsingDmlReturning(String projectId, String instanceId, String databaseId) {
    try (Spanner spanner =
        SpannerOptions.newBuilder()
            .setProjectId(projectId)
            .build()
            .getService()) {
      final DatabaseClient dbClient =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      // Update MarketingBudget column for records satisfying
      // a particular condition and returns the modified
      // MarketingBudget column of the updated records using
      // ‘RETURNING MarketingBudget’.
      // It is also possible to return all columns of all the
      // updated records by using ‘RETURNING *’.
      dbClient
          .readWriteTransaction()
          .run(
              transaction -> {
                String sql =
                    "UPDATE Albums "
                        + "SET MarketingBudget = MarketingBudget * 2 "
                        + "WHERE SingerId = 1 and AlbumId = 1 "
                        + "RETURNING MarketingBudget";

                // readWriteTransaction.executeQuery(..) API should be used for executing
                // DML statements with RETURNING clause.
                try (ResultSet resultSet = transaction.executeQuery(Statement.of(sql))) {
                  while (resultSet.next()) {
                    System.out.printf("%d\n", resultSet.getLong(0));
                  }
                  System.out.printf(
                      "Updated row(s) count: %d\n", resultSet.getStats().getRowCountExact());
                }
                return null;
              });
    }
  }
}
// [END spanner_postgresql_update_dml_returning]
