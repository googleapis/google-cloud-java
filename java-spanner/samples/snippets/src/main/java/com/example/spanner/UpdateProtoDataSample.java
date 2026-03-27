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

// [START spanner_update_data_with_proto_types]

import com.example.spanner.SingerProto.Genre;
import com.example.spanner.SingerProto.SingerInfo;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.Collections;
import java.util.List;

class UpdateProtoDataSample {

  static void updateProtoData() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String instanceId = "my-instance";
    String databaseId = "my-database";

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      updateProtoData(client);
    }
  }

  static void updateProtoData(DatabaseClient client) {
    SingerInfo singerInfo =
        SingerInfo.newBuilder()
            .setSingerId(2)
            .setBirthDate("February")
            .setNationality("Country2")
            .setGenre(Genre.FOLK)
            .build();
    Genre singerGenre = Genre.FOLK;
    List<AbstractMessage> singerInfoList = Collections.singletonList(singerInfo);
    List<ProtocolMessageEnum> singerGenreList = Collections.singletonList(singerGenre);

    client.write(
        ImmutableList.of(
            Mutation.newInsertOrUpdateBuilder("Singers")
                .set("SingerId")
                .to(2L)
                .set("SingerInfo")
                .to(singerInfo)
                .set("SingerInfoArray")
                .toProtoMessageArray(singerInfoList, SingerInfo.getDescriptor())
                .set("SingerGenre")
                .to(singerGenre)
                .set("SingerGenreArray")
                .toProtoEnumArray(singerGenreList, Genre.getDescriptor())
                .build(),
            Mutation.newInsertOrUpdateBuilder("Singers")
                .set("SingerId")
                .to(3L)
                .set("SingerInfo")
                .to(null, SingerInfo.getDescriptor())
                .set("SingerInfoArray")
                .toProtoMessageArray(null, SingerInfo.getDescriptor())
                .set("SingerGenre")
                .to(null, Genre.getDescriptor())
                .set("SingerGenreArray")
                .toProtoEnumArray(null, Genre.getDescriptor())
                .build()));
    System.out.println("Data updated");
  }
}
// [END spanner_update_data_with_proto_types]
