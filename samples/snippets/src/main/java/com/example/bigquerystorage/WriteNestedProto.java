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

package com.example.bigquerystorage;

// [START bigquerystorage_writenestedproto]
import com.google.api.core.ApiFuture;
import com.google.cloud.bigquery.storage.v1.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1.ProtoRows;
import com.google.cloud.bigquery.storage.v1.ProtoSchemaConverter;
import com.google.cloud.bigquery.storage.v1.StreamWriter;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class WriteNestedProto {

  public static void runWriteNestedProto(String projectId, String datasetName, String tableName)
      throws DescriptorValidationException, InterruptedException, IOException {
    StreamWriter streamWriter =
        StreamWriter.newBuilder(
                "projects/"
                    + projectId
                    + "/datasets/"
                    + datasetName
                    + "/tables/"
                    + tableName
                    + "/_default")
            .setWriterSchema(ProtoSchemaConverter.convert(HasNestedMessage.getDescriptor()))
            .build();
    ProtoRows protoRows =
        ProtoRows.newBuilder()
            .addSerializedRows(
                HasNestedMessage.newBuilder()
                    .setFoo("foo")
                    .setBar(
                        HasNestedMessage.InnerMessage.newBuilder()
                            .setMyInt(12345)
                            .setMyString("bar")
                            .build())
                    .build()
                    .toByteString())
            .addSerializedRows(
                HasSeparateNestedMessage.newBuilder()
                    .setFoo("foo2")
                    .setBar(
                        SeparateMessage.newBuilder().setMyInt(123456).setMyString("bar2").build())
                    .build()
                    .toByteString())
            .build();
    ApiFuture<AppendRowsResponse> future = streamWriter.append(protoRows);
    try {
      AppendRowsResponse response = future.get();
      System.out.println("Appended records successfully.");
    } catch (ExecutionException e) {
      System.out.println(e);
    }
  }
}
// [END bigquerystorage_writenestedproto]
