/*
 * Copyright 2020 Google LLC
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

// [START bigquerystorage_jsonstreamwriter_buffered]
import com.google.api.core.ApiFuture;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.bigquery.storage.v1.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1.FinalizeWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1.FlushRowsRequest;
import com.google.cloud.bigquery.storage.v1.FlushRowsResponse;
import com.google.cloud.bigquery.storage.v1.JsonStreamWriter;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Int64Value;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.threeten.bp.Duration;

public class WriteBufferedStream {

  public static void runWriteBufferedStream()
      throws DescriptorValidationException, InterruptedException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";

    writeBufferedStream(projectId, datasetName, tableName);
  }

  public static void writeBufferedStream(String projectId, String datasetName, String tableName)
      throws DescriptorValidationException, InterruptedException, IOException {
    try (BigQueryWriteClient client = BigQueryWriteClient.create()) {
      // Initialize a write stream for the specified table.
      // For more information on WriteStream.Type, see:
      // https://googleapis.dev/java/google-cloud-bigquerystorage/latest/com/google/cloud/bigquery/storage/v1/WriteStream.Type.html
      WriteStream stream = WriteStream.newBuilder().setType(WriteStream.Type.BUFFERED).build();
      TableName parentTable = TableName.of(projectId, datasetName, tableName);
      CreateWriteStreamRequest createWriteStreamRequest =
          CreateWriteStreamRequest.newBuilder()
              .setParent(parentTable.toString())
              .setWriteStream(stream)
              .build();
      WriteStream writeStream = client.createWriteStream(createWriteStreamRequest);

      // Configure in-stream automatic retry settings.
      // Error codes that are immediately retried:
      // * ABORTED, UNAVAILABLE, CANCELLED, INTERNAL, DEADLINE_EXCEEDED
      // Error codes that are retried with exponential backoff:
      // * RESOURCE_EXHAUSTED
      RetrySettings retrySettings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(500))
              .setRetryDelayMultiplier(1.1)
              .setMaxAttempts(5)
              .setMaxRetryDelay(Duration.ofMinutes(1))
              .build();

      // Use the JSON stream writer to send records in JSON format.
      // For more information about JsonStreamWriter, see:
      // https://googleapis.dev/java/google-cloud-bigquerystorage/latest/com/google/cloud/bigquery/storage/v1beta2/JsonStreamWriter.html
      try (JsonStreamWriter writer =
          JsonStreamWriter.newBuilder(writeStream.getName(), writeStream.getTableSchema())
              .setRetrySettings(retrySettings)
              .build()) {
        // Write two batches to the stream, each with 10 JSON records.
        for (int i = 0; i < 2; i++) {
          JSONArray jsonArr = new JSONArray();
          for (int j = 0; j < 10; j++) {
            // Create a JSON object that is compatible with the table schema.
            JSONObject record = new JSONObject();
            record.put("col1", String.format("buffered-record %03d", i));
            jsonArr.put(record);
          }
          ApiFuture<AppendRowsResponse> future = writer.append(jsonArr);
          AppendRowsResponse response = future.get();
        }
        // Flush the buffer.
        FlushRowsRequest flushRowsRequest =
            FlushRowsRequest.newBuilder()
                .setWriteStream(writeStream.getName())
                .setOffset(Int64Value.of(10 * 2 - 1)) // Advance the cursor to the latest record.
                .build();
        FlushRowsResponse flushRowsResponse = client.flushRows(flushRowsRequest);
        // You can continue to write to the stream after flushing the buffer.
      }
      // Finalize the stream after use.
      FinalizeWriteStreamRequest finalizeWriteStreamRequest =
          FinalizeWriteStreamRequest.newBuilder().setName(writeStream.getName()).build();
      client.finalizeWriteStream(finalizeWriteStreamRequest);
      System.out.println("Appended and committed records successfully.");
    } catch (ExecutionException e) {
      // If the wrapped exception is a StatusRuntimeException, check the state of the operation.
      // If the state is INTERNAL, CANCELLED, or ABORTED, you can retry. For more information, see:
      // https://grpc.github.io/grpc-java/javadoc/io/grpc/StatusRuntimeException.html
      System.out.println(e);
    }
  }
}
// [END bigquerystorage_jsonstreamwriter_buffered]
