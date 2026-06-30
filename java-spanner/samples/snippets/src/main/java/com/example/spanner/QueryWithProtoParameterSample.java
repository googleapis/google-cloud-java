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

// [START spanner_query_with_proto_types_parameter]
import com.example.spanner.SingerProto.Genre;
import com.example.spanner.SingerProto.SingerInfo;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;

class QueryWithProtoParameterSample {

  static void queryWithProtoParameter() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      queryWithProtoParameter(client);
    }
  }

  static void queryWithProtoParameter(DatabaseClient client) {
    Statement statement =
        Statement.newBuilder(
                "SELECT SingerId, SingerInfo, SingerInfo.nationality, SingerInfoArray, "
                    + "SingerGenre, SingerGenreArray FROM Singers "
                    + "WHERE SingerInfo.nationality=@country and SingerGenre=@singerGenre")
            .bind("country")
            .to("Country2")
            .bind("singerGenre")
            .to(Genre.FOLK)
            .build();
    try (ResultSet resultSet = client.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s %s %s %s %s%n",
            resultSet.getLong("SingerId"),
            resultSet.getProtoMessage("SingerInfo", SingerInfo.getDefaultInstance()),
            resultSet.getString("nationality"),
            resultSet.getProtoMessageList("SingerInfoArray", SingerInfo.getDefaultInstance()),
            resultSet.getProtoEnum("SingerGenre", Genre::forNumber),
            resultSet.getProtoEnumList("SingerGenreArray", Genre::forNumber));
      }
    }
  }
}
// [END spanner_query_with_proto_types_parameter]
