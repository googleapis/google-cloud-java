/*
 * Copyright 2024 Google Inc.
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

// [START spanner_add_proto_type_columns]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

class AddProtoColumnSample {

  static void addProtoColumn() throws InterruptedException, ExecutionException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    addProtoColumn(projectId, instanceId, databaseId);
  }

  static void addProtoColumn(String projectId, String instanceId, String databaseId)
      throws InterruptedException, ExecutionException, IOException {
    InputStream in =
        AddProtoColumnSample.class
            .getClassLoader()
            .getResourceAsStream("com/example/spanner/descriptors.pb");
    try (Spanner spanner =
            SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
        DatabaseAdminClient databaseAdminClient = spanner.createDatabaseAdminClient()) {
      UpdateDatabaseDdlRequest request =
          UpdateDatabaseDdlRequest.newBuilder()
              .setDatabase(DatabaseName.of(projectId, instanceId, databaseId).toString())
              .addAllStatements(
                  ImmutableList.of(
                      "CREATE PROTO BUNDLE ("
                          + "examples.spanner.music.SingerInfo,"
                          + "examples.spanner.music.Genre,"
                          + ")",
                      "ALTER TABLE Singers ADD COLUMN SingerInfo examples.spanner.music.SingerInfo",
                      "ALTER TABLE Singers ADD COLUMN "
                          + "SingerInfoArray ARRAY<examples.spanner.music.SingerInfo>",
                      "ALTER TABLE Singers ADD COLUMN SingerGenre examples.spanner.music.Genre",
                      "ALTER TABLE Singers ADD COLUMN "
                          + "SingerGenreArray ARRAY<examples.spanner.music.Genre>"))
              .setProtoDescriptors(ByteString.readFrom(in))
              .build();
      // Wait for the operation to finish.
      // This will throw an ExecutionException if the operation fails.
      databaseAdminClient.updateDatabaseDdlAsync(request).get();
      System.out.printf("Added Proto columns %n");
    }
  }
}
// [END spanner_add_proto_type_columns]
