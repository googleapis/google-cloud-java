/*
 * Copyright 2026 Google LLC
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

// [START bigquerystorage_timestamp_jsonstreamwriter_default]
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.storage.v1.AppendRowsRequest;
import com.google.cloud.bigquery.storage.v1.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteSettings;
import com.google.cloud.bigquery.storage.v1.Exceptions;
import com.google.cloud.bigquery.storage.v1.JsonStreamWriter;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import java.io.IOException;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONObject;
import org.threeten.bp.Duration;

public class WriteToDefaultStreamTimestampJson {

  public static void runWriteToDefaultStream()
      throws Descriptors.DescriptorValidationException, InterruptedException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    writeToDefaultStream(projectId, datasetName, tableName);
  }

  // Create a JSON object that is compatible with the table schema.
  private static JSONObject buildRecord() {
    JSONObject record = new JSONObject();
    record.put("timestampField", Instant.now().toString());
    return record;
  }

  public static void writeToDefaultStream(String projectId, String datasetName, String tableName)
      throws Descriptors.DescriptorValidationException, InterruptedException, IOException {
    TableName parentTable = TableName.of(projectId, datasetName, tableName);

    DataWriter writer = new DataWriter();
    // One time initialization for the worker.
    writer.initialize(parentTable);

    // Write two batches of fake data to the stream, each with 10 JSON records.  Data may be
    // batched up to the maximum request size:
    // https://cloud.google.com/bigquery/quotas#write-api-limits
    for (int i = 0; i < 2; i++) {
      JSONArray jsonArr = new JSONArray();
      for (int j = 0; j < 10; j++) {
        jsonArr.put(buildRecord());
      }

      writer.append(new AppendContext(jsonArr));
    }

    // Final cleanup for the stream during worker teardown.
    writer.cleanup();
    verifyExpectedRowCount(parentTable, 20L);
    System.out.println("Appended records successfully.");
  }

  private static void verifyExpectedRowCount(TableName parentTable, long expectedRowCount)
      throws InterruptedException {
    String queryRowCount =
        "SELECT COUNT(*) FROM `"
            + parentTable.getProject()
            + "."
            + parentTable.getDataset()
            + "."
            + parentTable.getTable()
            + "`";
    QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(queryRowCount).build();
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    TableResult results = bigquery.query(queryConfig);
    long countRowsActual =
        Long.parseLong(results.getValues().iterator().next().get("f0_").getStringValue());
    if (countRowsActual != expectedRowCount) {
      throw new RuntimeException(
          "Unexpected row count. Expected: " + expectedRowCount + ". Actual: " + countRowsActual);
    }
  }

  private static class AppendContext {
    JSONArray data;

    AppendContext(JSONArray data) {
      this.data = data;
    }
  }

  private static class DataWriter {

    private static final int MAX_RECREATE_COUNT = 3;

    private BigQueryWriteClient client;

    // Track the number of in-flight requests to wait for all responses before shutting down.
    private final Phaser inflightRequestCount = new Phaser(1);
    private final Object lock = new Object();
    private JsonStreamWriter streamWriter;

    @GuardedBy("lock")
    private RuntimeException error = null;

    private final AtomicInteger recreateCount = new AtomicInteger(0);

    private JsonStreamWriter createStreamWriter(String tableName)
        throws Descriptors.DescriptorValidationException, IOException, InterruptedException {
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

      // Use the JSON stream writer to send records in JSON format. Specify the table name to write
      // to the default stream.
      // For more information about JsonStreamWriter, see:
      // https://googleapis.dev/java/google-cloud-bigquerystorage/latest/com/google/cloud/bigquery/storage/v1/JsonStreamWriter.html
      return JsonStreamWriter.newBuilder(tableName, client)
          .setExecutorProvider(FixedExecutorProvider.create(Executors.newScheduledThreadPool(10)))
          .setChannelProvider(
              BigQueryWriteSettings.defaultGrpcTransportProviderBuilder()
                  .setKeepAliveTime(org.threeten.bp.Duration.ofMinutes(1))
                  .setKeepAliveTimeout(org.threeten.bp.Duration.ofMinutes(1))
                  .setKeepAliveWithoutCalls(true)
                  .build())
          .setEnableConnectionPool(true)
          // This will allow connection pool to scale up better.
          .setFlowControlSettings(
              FlowControlSettings.newBuilder().setMaxOutstandingElementCount(100L).build())
          // If value is missing in json and there is a default value configured on bigquery
          // column, apply the default value to the missing value field.
          .setDefaultMissingValueInterpretation(
              AppendRowsRequest.MissingValueInterpretation.DEFAULT_VALUE)
          .setRetrySettings(retrySettings)
          .build();
    }

    public void initialize(TableName parentTable)
        throws Descriptors.DescriptorValidationException, IOException, InterruptedException {
      // Initialize client without settings, internally within stream writer a new client will be
      // created with full settings.
      client = BigQueryWriteClient.create();

      streamWriter = createStreamWriter(parentTable.toString());
    }

    public void append(AppendContext appendContext)
        throws Descriptors.DescriptorValidationException, IOException, InterruptedException {
      synchronized (this.lock) {
        if (!streamWriter.isUserClosed()
            && streamWriter.isClosed()
            && recreateCount.getAndIncrement() < MAX_RECREATE_COUNT) {
          streamWriter = createStreamWriter(streamWriter.getStreamName());
          this.error = null;
        }
        // If earlier appends have failed, we need to reset before continuing.
        if (this.error != null) {
          throw this.error;
        }
      }
      // Append asynchronously for increased throughput.
      ApiFuture<AppendRowsResponse> future = streamWriter.append(appendContext.data);
      ApiFutures.addCallback(
          future, new AppendCompleteCallback(this, appendContext), MoreExecutors.directExecutor());

      // Increase the count of in-flight requests.
      inflightRequestCount.register();
    }

    public void cleanup() {
      // Wait for all in-flight requests to complete.
      inflightRequestCount.arriveAndAwaitAdvance();

      client.close();
      // Close the connection to the server.
      streamWriter.close();

      // Verify that no error occurred in the stream.
      synchronized (this.lock) {
        if (this.error != null) {
          throw this.error;
        }
      }
    }

    static class AppendCompleteCallback implements ApiFutureCallback<AppendRowsResponse> {

      private final DataWriter parent;
      private final AppendContext appendContext;

      public AppendCompleteCallback(DataWriter parent, AppendContext appendContext) {
        this.parent = parent;
        this.appendContext = appendContext;
      }

      public void onSuccess(AppendRowsResponse response) {
        System.out.println("Append success");
        this.parent.recreateCount.set(0);
        done();
      }

      public void onFailure(Throwable throwable) {
        if (throwable instanceof Exceptions.AppendSerializationError) {
          Exceptions.AppendSerializationError ase = (Exceptions.AppendSerializationError) throwable;
          Map<Integer, String> rowIndexToErrorMessage = ase.getRowIndexToErrorMessage();
          if (!rowIndexToErrorMessage.isEmpty()) {
            // Omit the faulty rows
            JSONArray dataNew = new JSONArray();
            for (int i = 0; i < appendContext.data.length(); i++) {
              if (!rowIndexToErrorMessage.containsKey(i)) {
                dataNew.put(appendContext.data.get(i));
              } else {
                // process faulty rows by placing them on a dead-letter-queue, for instance
              }
            }

            // Retry the remaining valid rows, but using a separate thread to
            // avoid potentially blocking while we are in a callback.
            if (!dataNew.isEmpty()) {
              try {
                this.parent.append(new AppendContext(dataNew));
              } catch (DescriptorValidationException | IOException | InterruptedException e) {
                throw new RuntimeException(e);
              }
            }
            // Mark the existing attempt as done since we got a response for it
            done();
            return;
          }
        }

        boolean resendRequest = false;
        if (throwable instanceof Exceptions.MaximumRequestCallbackWaitTimeExceededException) {
          resendRequest = true;
        } else if (throwable instanceof Exceptions.StreamWriterClosedException) {
          if (!parent.streamWriter.isUserClosed()) {
            resendRequest = true;
          }
        }
        if (resendRequest) {
          // Retry this request.
          try {
            this.parent.append(new AppendContext(appendContext.data));
          } catch (Descriptors.DescriptorValidationException
              | IOException
              | InterruptedException e) {
            throw new RuntimeException(e);
          }
          // Mark the existing attempt as done since we got a response for it
          done();
          return;
        }

        synchronized (this.parent.lock) {
          if (this.parent.error == null) {
            Exceptions.StorageException storageException = Exceptions.toStorageException(throwable);
            this.parent.error =
                (storageException != null) ? storageException : new RuntimeException(throwable);
          }
        }
        done();
      }

      private void done() {
        // Reduce the count of in-flight requests.
        this.parent.inflightRequestCount.arriveAndDeregister();
      }
    }
  }
}
// [END bigquerystorage_timestamp_jsonstreamwriter_default]
