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

// [START bigquerystorage_jsonstreamwriter_committed]
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.bigquery.storage.v1.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1.Exceptions;
import com.google.cloud.bigquery.storage.v1.Exceptions.StorageException;
import com.google.cloud.bigquery.storage.v1.FinalizeWriteStreamResponse;
import com.google.cloud.bigquery.storage.v1.JsonStreamWriter;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Phaser;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONObject;
import org.threeten.bp.Duration;

public class WriteCommittedStream {

  public static void runWriteCommittedStream()
      throws DescriptorValidationException, InterruptedException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";

    writeCommittedStream(projectId, datasetName, tableName);
  }

  public static void writeCommittedStream(String projectId, String datasetName, String tableName)
      throws DescriptorValidationException, InterruptedException, IOException {
    BigQueryWriteClient client = BigQueryWriteClient.create();
    TableName parentTable = TableName.of(projectId, datasetName, tableName);

    DataWriter writer = new DataWriter();
    // One time initialization.
    writer.initialize(parentTable, client);

    try {
      // Write two batches of fake data to the stream, each with 10 JSON records.  Data may be
      // batched up to the maximum request size:
      // https://cloud.google.com/bigquery/quotas#write-api-limits
      long offset = 0;
      for (int i = 0; i < 2; i++) {
        // Create a JSON object that is compatible with the table schema.
        JSONArray jsonArr = new JSONArray();
        for (int j = 0; j < 10; j++) {
          JSONObject record = new JSONObject();
          record.put("col1", String.format("batch-record %03d-%03d", i, j));
          jsonArr.put(record);
        }
        writer.append(jsonArr, offset);
        offset += jsonArr.length();
      }
    } catch (ExecutionException e) {
      // If the wrapped exception is a StatusRuntimeException, check the state of the operation.
      // If the state is INTERNAL, CANCELLED, or ABORTED, you can retry. For more information, see:
      // https://grpc.github.io/grpc-java/javadoc/io/grpc/StatusRuntimeException.html
      System.out.println("Failed to append records. \n" + e);
    }

    // Final cleanup for the stream.
    writer.cleanup(client);
    System.out.println("Appended records successfully.");
  }

  // A simple wrapper object showing how the stateful stream writer should be used.
  private static class DataWriter {

    private JsonStreamWriter streamWriter;
    // Track the number of in-flight requests to wait for all responses before shutting down.
    private final Phaser inflightRequestCount = new Phaser(1);

    private final Object lock = new Object();

    @GuardedBy("lock")
    private RuntimeException error = null;

    void initialize(TableName parentTable, BigQueryWriteClient client)
        throws IOException, DescriptorValidationException, InterruptedException {
      // Initialize a write stream for the specified table.
      // For more information on WriteStream.Type, see:
      // https://googleapis.dev/java/google-cloud-bigquerystorage/latest/com/google/cloud/bigquery/storage/v1/WriteStream.Type.html
      WriteStream stream = WriteStream.newBuilder().setType(WriteStream.Type.COMMITTED).build();

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
      // https://googleapis.dev/java/google-cloud-bigquerystorage/latest/com/google/cloud/bigquery/storage/v1/JsonStreamWriter.html
      streamWriter =
          JsonStreamWriter.newBuilder(writeStream.getName(), writeStream.getTableSchema(), client)
              .setRetrySettings(retrySettings)
              .build();
    }

    public void append(JSONArray data, long offset)
        throws DescriptorValidationException, IOException, ExecutionException {
      synchronized (this.lock) {
        // If earlier appends have failed, we need to reset before continuing.
        if (this.error != null) {
          throw this.error;
        }
      }
      // Append asynchronously for increased throughput.
      ApiFuture<AppendRowsResponse> future = streamWriter.append(data, offset);
      ApiFutures.addCallback(
          future, new DataWriter.AppendCompleteCallback(this), MoreExecutors.directExecutor());
      // Increase the count of in-flight requests.
      inflightRequestCount.register();
    }

    public void cleanup(BigQueryWriteClient client) {
      // Wait for all in-flight requests to complete.
      inflightRequestCount.arriveAndAwaitAdvance();

      // Close the connection to the server.
      streamWriter.close();

      // Verify that no error occurred in the stream.
      synchronized (this.lock) {
        if (this.error != null) {
          throw this.error;
        }
      }

      // Finalize the stream.
      FinalizeWriteStreamResponse finalizeResponse =
          client.finalizeWriteStream(streamWriter.getStreamName());
      System.out.println("Rows written: " + finalizeResponse.getRowCount());
    }

    public String getStreamName() {
      return streamWriter.getStreamName();
    }

    static class AppendCompleteCallback implements ApiFutureCallback<AppendRowsResponse> {

      private final DataWriter parent;

      public AppendCompleteCallback(DataWriter parent) {
        this.parent = parent;
      }

      public void onSuccess(AppendRowsResponse response) {
        System.out.format("Append %d success\n", response.getAppendResult().getOffset().getValue());
        done();
      }

      public void onFailure(Throwable throwable) {
        synchronized (this.parent.lock) {
          if (this.parent.error == null) {
            StorageException storageException = Exceptions.toStorageException(throwable);
            this.parent.error =
                (storageException != null) ? storageException : new RuntimeException(throwable);
          }
        }
        System.out.format("Error: %s\n", throwable.toString());
        done();
      }

      private void done() {
        // Reduce the count of in-flight requests.
        this.parent.inflightRequestCount.arriveAndDeregister();
      }
    }
  }
}
// [END bigquerystorage_jsonstreamwriter_committed]
