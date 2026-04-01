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

// [START spanner_update_data_with_proto_types_with_dml]

import com.example.spanner.SingerProto.Genre;
import com.example.spanner.SingerProto.SingerInfo;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class UpdateProtoDataSampleUsingDml {

  static void updateProtoDataUsingDml() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      updateProtoDataUsingDml(client);
    }
  }

  static void updateProtoDataUsingDml(DatabaseClient client) {
    SingerInfo singerInfo =
        SingerInfo.newBuilder()
            .setSingerId(1)
            .setBirthDate("January")
            .setNationality("Country1")
            .setGenre(Genre.ROCK)
            .build();
    Genre singerGenre = Genre.ROCK;
    List<AbstractMessage> singerInfoList = Collections.singletonList(singerInfo);
    List<ProtocolMessageEnum> singerGenreList = Collections.singletonList(singerGenre);

    client
        .readWriteTransaction()
        .run(
            transaction -> {
              Statement statement1 =
                  Statement.newBuilder(
                          "UPDATE Singers SET SingerInfo = @singerInfo,  "
                              + "SingerInfoArray=@singerInfoArray, "
                              + "SingerGenre=@singerGenre, SingerGenreArray=@singerGenreArray "
                              + "WHERE SingerId = 1")
                      .bind("singerInfo")
                      .to(singerInfo)
                      .bind("singerInfoArray")
                      .toProtoMessageArray(singerInfoList, SingerInfo.getDescriptor())
                      .bind("singerGenre")
                      .to(singerGenre)
                      .bind("singerGenreArray")
                      .toProtoEnumArray(singerGenreList, Genre.getDescriptor())
                      .build();

              Statement statement2 =
                  Statement.newBuilder(
                          "UPDATE Singers SET SingerInfo.nationality = @singerNationality "
                              + "WHERE SingerId = 1")
                      .bind("singerNationality")
                      .to("Country2")
                      .build();

              transaction.batchUpdate(Arrays.asList(statement1, statement2));
              return null;
            });

    System.out.println("record(s) updated");
  }
}
// [END spanner_update_data_with_proto_types_with_dml]
