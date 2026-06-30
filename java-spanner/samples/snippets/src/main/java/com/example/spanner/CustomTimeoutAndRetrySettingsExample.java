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

//[START spanner_set_custom_timeout_and_retry]

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import org.threeten.bp.Duration;

class CustomTimeoutAndRetrySettingsExample {

  static void executeSqlWithCustomTimeoutAndRetrySettings() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    executeSqlWithCustomTimeoutAndRetrySettings(projectId, instanceId, databaseId);
  }

  // Create a Spanner client with custom ExecuteSql timeout and retry settings.
  static void executeSqlWithCustomTimeoutAndRetrySettings(
      String projectId, String instanceId, String databaseId) {
    SpannerOptions.Builder builder = SpannerOptions.newBuilder().setProjectId(projectId);
    // Set custom timeout and retry settings for the ExecuteSql RPC.
    // This must be done in a separate chain as the setRetryableCodes and setRetrySettings methods
    // return a UnaryCallSettings.Builder instead of a SpannerOptions.Builder.
    builder
        .getSpannerStubSettingsBuilder()
        .executeSqlSettings()
        // Configure which errors should be retried.
        .setRetryableCodes(Code.UNAVAILABLE)
        .setRetrySettings(
            RetrySettings.newBuilder()
                // Configure retry delay settings.
                // The initial amount of time to wait before retrying the request.
                .setInitialRetryDelay(Duration.ofMillis(500))
                // The maximum amount of time to wait before retrying. I.e. after this value is
                // reached, the wait time will not increase further by the multiplier.
                .setMaxRetryDelay(Duration.ofSeconds(16))
                // The previous wait time is multiplied by this multiplier to come up with the next
                // wait time, until the max is reached.
                .setRetryDelayMultiplier(1.5)

                // Configure RPC and total timeout settings.
                // Timeout for the first RPC call. Subsequent retries will be based off this value.
                .setInitialRpcTimeout(Duration.ofSeconds(60))
                // The max for the per RPC timeout.
                .setMaxRpcTimeout(Duration.ofSeconds(60))
                // Controls the change of timeout for each retry.
                .setRpcTimeoutMultiplier(1.0)
                // The timeout for all calls (first call + all retries).
                .setTotalTimeout(Duration.ofSeconds(60))
                .build());
    // Create a Spanner client using the custom retry and timeout settings.
    try (Spanner spanner = builder.build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      client
          .readWriteTransaction()
          .run(transaction -> {
            String sql =
                "INSERT INTO Singers (SingerId, FirstName, LastName)\n"
                    + "VALUES (20, 'George', 'Washington')";
            long rowCount = transaction.executeUpdate(Statement.of(sql));
            System.out.printf("%d record inserted.%n", rowCount);
            return null;
          });
    }
  }
}
// [END spanner_set_custom_timeout_and_retry]
