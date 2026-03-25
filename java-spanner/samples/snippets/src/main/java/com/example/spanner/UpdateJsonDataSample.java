/*
 * Copyright 2021 Google Inc.
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

// [START spanner_update_data_with_json_column]

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Value;
import com.google.common.collect.ImmutableList;

class UpdateJsonDataSample {

  static void updateJsonData() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      updateJsonData(client);
    }
  }

  static void updateJsonData(DatabaseClient client) {
    client.write(
        ImmutableList.of(
            Mutation.newInsertOrUpdateBuilder("Venues")
                .set("VenueId")
                .to(4L)
                .set("VenueDetails")
                .to(
                    Value.json(
                        "[{\"name\":\"room 1\",\"open\":true},"
                            + "{\"name\":\"room 2\",\"open\":false}]"))
                .build(),
            Mutation.newInsertOrUpdateBuilder("Venues")
                .set("VenueId")
                .to(19L)
                .set("VenueDetails")
                .to(Value.json("{\"rating\":9,\"open\":true}"))
                .build(),
            Mutation.newInsertOrUpdateBuilder("Venues")
                .set("VenueId")
                .to(42L)
                .set("VenueDetails")
                .to(
                    Value.json(
                        "{\"name\":null,"
                            + "\"open\":{\"Monday\":true,\"Tuesday\":false},"
                            + "\"tags\":[\"large\",\"airy\"]}"))
                .build()));
    System.out.println("Venues successfully updated");
  }
}
// [END spanner_update_data_with_json_column]
