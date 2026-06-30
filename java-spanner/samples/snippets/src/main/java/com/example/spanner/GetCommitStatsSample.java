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

// [START spanner_get_commit_stats]

import com.google.cloud.spanner.CommitResponse;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import java.util.Arrays;

public class GetCommitStatsSample {

  static void getCommitStats() {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "my-project";
    final String instanceId = "my-instance";
    final String databaseId = "my-database";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      final DatabaseClient databaseClient = spanner
          .getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      getCommitStats(databaseClient);
    }
  }

  static void getCommitStats(DatabaseClient databaseClient) {
    final CommitResponse commitResponse = databaseClient.writeWithOptions(Arrays.asList(
        Mutation.newInsertOrUpdateBuilder("Albums")
            .set("SingerId")
            .to("1")
            .set("AlbumId")
            .to("1")
            .set("MarketingBudget")
            .to("200000")
            .build(),
        Mutation.newInsertOrUpdateBuilder("Albums")
            .set("SingerId")
            .to("2")
            .set("AlbumId")
            .to("2")
            .set("MarketingBudget")
            .to("400000")
            .build()
    ), Options.commitStats());

    System.out.println(
        "Updated data with " + commitResponse.getCommitStats().getMutationCount() + " mutations.");
  }
}
// [END spanner_get_commit_stats]
