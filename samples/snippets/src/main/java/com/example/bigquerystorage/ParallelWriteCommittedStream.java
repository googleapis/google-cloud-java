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

// [START bigquerystorage_jsonstreamwriter_parallelcommitted]
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.cloud.bigquery.storage.v1beta2.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1beta2.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1beta2.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1beta2.JsonStreamWriter;
import com.google.cloud.bigquery.storage.v1beta2.TableName;
import com.google.cloud.bigquery.storage.v1beta2.WriteStream;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONObject;

public class ParallelWriteCommittedStream {

  private static final Logger LOG = Logger.getLogger(ParallelWriteCommittedStream.class.getName());

  // Total amount of test time.
  private static final Duration TEST_TIME = Duration.ofSeconds(10);

  // How often to publish append stats.
  private static final Duration METRICS_GAP = Duration.ofSeconds(5);

  // Size of each row to append.
  private static final int ROW_SIZE = 1024;

  // The number of rows in each append request.
  private static final long BATCH_SIZE = 10;

  // If true, switch to a new stream when append fails.
  // If false, do not switch to a new stream.
  private static final boolean SUPPORT_STREAM_SWITCH = false;

  @GuardedBy("this")
  private long inflightCount = 0;

  @GuardedBy("this")
  private long successCount = 0;

  @GuardedBy("this")
  private long failureCount = 0;

  @GuardedBy("this")
  private Throwable error = null;

  @GuardedBy("this")
  private long lastMetricsTimeMillis = 0;

  @GuardedBy("this")
  private long lastMetricsSuccessCount = 0;

  @GuardedBy("this")
  private long lastMetricsFailureCount = 0;

  public void writeLoop(
      String projectId, String datasetName, String tableName, BigQueryWriteClient client) {
    LOG.info("Start writeLoop");
    long streamSwitchCount = 0;
    long successRowCount = 0;
    long failureRowCount = 0;
    Throwable loggedError = null;
    long deadlineMillis = System.currentTimeMillis() + TEST_TIME.toMillis();
    while (System.currentTimeMillis() < deadlineMillis) {
      try {
        WriteStream writeStream = createStream(projectId, datasetName, tableName, client);
        writeToStream(client, writeStream, deadlineMillis);
      } catch (Throwable e) {
        LOG.warning("Unexpected error writing to stream: " + e.toString());
      }
      waitForInflightToReachZero(Duration.ofMinutes(1));
      synchronized (this) {
        successRowCount += successCount * BATCH_SIZE;
        failureRowCount += failureCount * BATCH_SIZE;
        if (loggedError == null) {
          loggedError = error;
        }
      }
      if (!SUPPORT_STREAM_SWITCH) {
        // If stream switch is disabled, break.
        break;
      }
      LOG.info("Sleeping before switching stream.");
      sleepIgnoringInterruption(Duration.ofMinutes(1));
      streamSwitchCount++;
    }
    LOG.info(
        "Finish writeLoop. Success row count: "
            + successRowCount
            + " Failure row count: "
            + failureRowCount
            + " Logged error: "
            + loggedError
            + " Stream switch count: "
            + streamSwitchCount);
    if (successRowCount > 0 && failureRowCount == 0 && loggedError == null) {
      System.out.println("All records are appended successfully.");
    }
  }

  private WriteStream createStream(
      String projectId, String datasetName, String tableName, BigQueryWriteClient client) {
    LOG.info("Creating a new stream");
    // Initialize a write stream for the specified table.
    // For more information on WriteStream.Type, see:
    // https://googleapis.dev/java/google-cloud-bigquerystorage/latest/com/google/cloud/bigquery/storage/v1beta2/WriteStream.Type.html
    WriteStream stream = WriteStream.newBuilder().setType(WriteStream.Type.COMMITTED).build();
    TableName parentTable = TableName.of(projectId, datasetName, tableName);
    CreateWriteStreamRequest createWriteStreamRequest =
        CreateWriteStreamRequest.newBuilder()
            .setParent(parentTable.toString())
            .setWriteStream(stream)
            .build();
    return client.createWriteStream(createWriteStreamRequest);
  }

  private void writeToStream(
      BigQueryWriteClient client, WriteStream writeStream, long deadlineMillis) throws Throwable {
    LOG.info("Start writing to new stream:" + writeStream.getName());
    synchronized (this) {
      inflightCount = 0;
      successCount = 0;
      failureCount = 0;
      error = null;
      lastMetricsTimeMillis = System.currentTimeMillis();
      lastMetricsSuccessCount = 0;
      lastMetricsFailureCount = 0;
    }
    // Use the JSON stream writer to send records in JSON format.
    // For more information about JsonStreamWriter, see:
    // https://googleapis.dev/java/google-cloud-bigquerystorage/latest/com/google/cloud/bigquery/storage/v1beta2/JsonStreamWriter.html
    try (JsonStreamWriter writer =
        JsonStreamWriter.newBuilder(writeStream.getName(), writeStream.getTableSchema(), client)
            .build()) {
      while (System.currentTimeMillis() < deadlineMillis) {
        synchronized (this) {
          if (error != null) {
            // Stop writing once we get an error.
            throw error;
          }
        }
        ApiFuture<AppendRowsResponse> future = writer.append(createPayload(), -1);
        synchronized (this) {
          inflightCount++;
        }
        ApiFutures.addCallback(
            future, new AppendCompleteCallback(this), MoreExecutors.directExecutor());
      }
    }
  }

  private void waitForInflightToReachZero(Duration timeout) {
    LOG.info("Waiting for inflight count to reach zero.");
    long deadlineMillis = System.currentTimeMillis() + timeout.toMillis();
    while (System.currentTimeMillis() < deadlineMillis) {
      synchronized (this) {
        if (inflightCount == 0) {
          LOG.info("Inflight count has reached zero.");
          return;
        }
      }
      sleepIgnoringInterruption(Duration.ofSeconds(1));
    }
    throw new RuntimeException("Timeout waiting for inflight count to reach 0");
  }

  private JSONArray createPayload() {
    // Create a JSON object that is compatible with the table schema.
    JSONArray jsonArr = new JSONArray();
    for (int i = 0; i < BATCH_SIZE; i++) {
      byte[] payload = new byte[ROW_SIZE];
      ThreadLocalRandom.current().nextBytes(payload);
      JSONObject record = new JSONObject();
      record.put("col1", new String(payload));
      jsonArr.put(record);
    }
    return jsonArr;
  }

  private void sleepIgnoringInterruption(Duration duration) {
    try {
      Thread.sleep(duration.toMillis());
    } catch (InterruptedException e) {
      LOG.warning("Sleep is interrupted.");
    }
  }

  /*
   * Callback when Append request is completed.
   *
   * It keeps track of count.
   */
  private class AppendCompleteCallback implements ApiFutureCallback<AppendRowsResponse> {

    private final ParallelWriteCommittedStream parent;

    AppendCompleteCallback(ParallelWriteCommittedStream parent) {
      this.parent = parent;
    }

    @Override
    public void onSuccess(@Nullable AppendRowsResponse response) {
      synchronized (parent) {
        parent.inflightCount--;
        if (!response.hasError()) {
          parent.successCount++;
        } else {
          parent.failureCount++;
        }
        long nowMillis = System.currentTimeMillis();
        if (nowMillis >= parent.lastMetricsTimeMillis + METRICS_GAP.toMillis()) {
          long successCountInIteration = parent.successCount - parent.lastMetricsSuccessCount;
          long failureCountInIteration = parent.failureCount - parent.lastMetricsFailureCount;
          long metricsTimeMillis = nowMillis - parent.lastMetricsTimeMillis;
          LOG.info(
              "Success append: "
                  + successCountInIteration
                  + " failure append: "
                  + failureCountInIteration
                  + " in "
                  + metricsTimeMillis
                  + "ms. Successful MB Per Second: "
                  + (double) (successCountInIteration * BATCH_SIZE * ROW_SIZE)
                      / metricsTimeMillis
                      / 1000
                  + " Current inflight: "
                  + parent.inflightCount);
          parent.lastMetricsTimeMillis = System.currentTimeMillis();
          parent.lastMetricsSuccessCount = parent.successCount;
          parent.lastMetricsFailureCount = parent.failureCount;
        }
      }
    }

    @Override
    public void onFailure(Throwable throwable) {
      synchronized (parent) {
        parent.inflightCount--;
        parent.error = throwable;
        LOG.warning("Found failure: " + throwable.toString());
      }
    }
  }

  public static void writeCommittedStream(String projectId, String datasetName, String tableName)
      throws DescriptorValidationException, InterruptedException, IOException {
    try (BigQueryWriteClient client = BigQueryWriteClient.create()) {
      new ParallelWriteCommittedStream().writeLoop(projectId, datasetName, tableName, client);
    } catch (Exception e) {
      System.out.println("Failed to append records. \n" + e.toString());
    }
  }
}
// [END bigquerystorage_jsonstreamwriter_parallelcommitted]
