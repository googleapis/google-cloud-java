/*
 * Copyright 2025 Google LLC
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

// [START spanner_database_add_split_points]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.database.v1.SplitPoints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAddSplitPointsSample {

  /***
   * Assume DDL for the underlying database:
   * <pre>{@code
   * CREATE TABLE Singers (
   * SingerId INT64 NOT NULL,
   * FirstName STRING(1024),
   * LastName STRING(1024),
   *  SingerInfo BYTES(MAX),
   * ) PRIMARY KEY(SingerId);
   *
   *
   * CREATE INDEX SingersByFirstLastName ON Singers(FirstName, LastName);
   * }</pre>
   */

  static void addSplitPoints() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";
    addSplitPoints(projectId, instanceId, databaseId);
  }

  static void addSplitPoints(String projectId, String instanceId, String databaseId)
      throws IOException {
    try (Spanner spanner =
            SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
        DatabaseAdminClient databaseAdminClient = spanner.createDatabaseAdminClient()) {
      List<com.google.spanner.admin.database.v1.SplitPoints> splitPoints = new ArrayList<>();

      // table key
      com.google.spanner.admin.database.v1.SplitPoints splitPointForTable =
          SplitPoints.newBuilder()
              .setTable("Singers")
              .addKeys(
                  com.google.spanner.admin.database.v1.SplitPoints.Key.newBuilder()
                      .setKeyParts(
                          ListValue.newBuilder()
                              .addValues(Value.newBuilder().setStringValue("42").build())
                              .build()))
              .build();

      // index key without table key part
      com.google.spanner.admin.database.v1.SplitPoints splitPointForIndex =
          SplitPoints.newBuilder()
              .setIndex("SingersByFirstLastName")
              .addKeys(
                  com.google.spanner.admin.database.v1.SplitPoints.Key.newBuilder()
                      .setKeyParts(
                          ListValue.newBuilder()
                              .addValues(Value.newBuilder().setStringValue("John").build())
                              .addValues(Value.newBuilder().setStringValue("Doe").build())
                              .build()))
              .build();

      // index key with table key part, first key is the index key and second is the table key
      com.google.spanner.admin.database.v1.SplitPoints splitPointForIndexWitTableKey =
          SplitPoints.newBuilder()
              .setIndex("SingersByFirstLastName")
              .addKeys(
                  com.google.spanner.admin.database.v1.SplitPoints.Key.newBuilder()
                      .setKeyParts(
                          ListValue.newBuilder()
                              .addValues(Value.newBuilder().setStringValue("Jane").build())
                              .addValues(Value.newBuilder().setStringValue("Doe").build())
                              .build()))
              .addKeys(
                  com.google.spanner.admin.database.v1.SplitPoints.Key.newBuilder()
                      .setKeyParts(
                          ListValue.newBuilder()
                              .addValues(Value.newBuilder().setStringValue("38").build())
                              .build()))
              .build();

      splitPoints.add(splitPointForTable);
      splitPoints.add(splitPointForIndex);
      splitPoints.add(splitPointForIndexWitTableKey);
      databaseAdminClient.addSplitPoints(
          DatabaseName.of(projectId, instanceId, databaseId), splitPoints);

    } catch (Exception e) {
      // If the operation failed during execution, expose the cause.
      throw (SpannerException) e.getCause();
    }
  }
}
// [END spanner_database_add_split_points]
