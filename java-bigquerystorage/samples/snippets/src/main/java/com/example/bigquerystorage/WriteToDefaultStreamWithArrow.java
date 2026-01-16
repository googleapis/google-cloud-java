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

// [START bigquerystorage_streamwriter_default_arrow]
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
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
import com.google.cloud.bigquery.storage.v1.Exceptions.AppendSerializationError;
import com.google.cloud.bigquery.storage.v1.Exceptions.MaximumRequestCallbackWaitTimeExceededException;
import com.google.cloud.bigquery.storage.v1.Exceptions.StorageException;
import com.google.cloud.bigquery.storage.v1.Exceptions.StreamWriterClosedException;
import com.google.cloud.bigquery.storage.v1.StreamWriter;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BigIntVector;
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.VectorUnloader;
import org.apache.arrow.vector.compression.CompressionCodec;
import org.apache.arrow.vector.compression.CompressionUtil;
import org.apache.arrow.vector.compression.NoCompressionCodec;
import org.apache.arrow.vector.ipc.message.ArrowRecordBatch;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
import org.threeten.bp.Duration;

/**
 * This class demonstrates how to ingest data using Arrow format into BigQuery via the default
 * stream. It initiates a DataWriter to establish a connection to BigQuery and reuses this
 * connection to continuously ingest data.
 */
public class WriteToDefaultStreamWithArrow {
  public static void main(String[] args)
      throws DescriptorValidationException, InterruptedException, IOException {
    if (args.length < 3) {
      System.out.println(
          "Usage: WriteToDefaultStreamWithArrow <projectId> <datasetName> <tableName>");
      return;
    }
    String projectId = args[0];
    String datasetName = args[1];
    String tableName = args[2];
    // Table schema should contain 3 fields:
    // ['test_string': STRING, 'test_int': INTEGER, 'test_geo':GEOGRAPHY]
    writeToDefaultStreamWithArrow(projectId, datasetName, tableName);
  }

  private static Schema createArrowSchema() {
    List<Field> fields =
        ImmutableList.of(
            new Field("test_string", FieldType.nullable(new ArrowType.Utf8()), null),
            new Field("test_int", FieldType.nullable(new ArrowType.Int(64, true)), null),
            new Field("test_geo", FieldType.nullable(new ArrowType.Utf8()), null));
    return new Schema(fields, null);
  }

  // Create an ArrowRecordBatch object that is compatible with the table schema.
  private static ArrowRecordBatch buildRecordBatch(VectorSchemaRoot root, int rowCount) {
    VarCharVector testString = (VarCharVector) root.getVector("test_string");
    BigIntVector testInt = (BigIntVector) root.getVector("test_int");
    VarCharVector testGeo = (VarCharVector) root.getVector("test_geo");

    testString.allocateNew(rowCount);
    testInt.allocateNew(rowCount);
    testGeo.allocateNew(rowCount);

    for (int i = 0; i < rowCount; i++) {
      testString.set(i, ("A" + i).getBytes());
      testInt.set(i, i + 100);
      testGeo.set(
          i,
          "POLYGON((-124.49 47.35,-124.49 40.73,-116.49 40.73,-113.49 47.35,-124.49 47.35))"
              .getBytes());
    }
    root.setRowCount(rowCount);

    CompressionCodec codec =
        NoCompressionCodec.Factory.INSTANCE.createCodec(CompressionUtil.CodecType.NO_COMPRESSION);
    VectorUnloader vectorUnloader =
        new VectorUnloader(root, /* includeNullCount= */ true, codec, /* alignBuffers= */ true);
    return vectorUnloader.getRecordBatch();
  }

  public static void writeToDefaultStreamWithArrow(
      String projectId, String datasetName, String tableName)
      throws DescriptorValidationException, InterruptedException, IOException {
    TableName parentTable = TableName.of(projectId, datasetName, tableName);
    Schema arrowSchema = createArrowSchema();
    DataWriter writer = new DataWriter();
    // One time initialization for the worker.
    writer.initialize(parentTable, arrowSchema);
    long initialRowCount = getRowCount(parentTable);
    try (BufferAllocator allocator = new RootAllocator()) {
      // A writer should be used to ingest as much data as possible before teardown.
      // Append 100 batches.
      for (int i = 0; i < 100; i++) {
        try (VectorSchemaRoot root = VectorSchemaRoot.create(arrowSchema, allocator)) {
          // Each batch has 10 rows.
          ArrowRecordBatch batch = buildRecordBatch(root, 10);

          // Asynchronous append.
          writer.append(new ArrowData(arrowSchema, batch));
        }
      }
    }
    // Final cleanup for the stream during worker teardown.
    // It's blocked until all append requests' response are received.
    writer.cleanup();

    verifyExpectedRowCount(parentTable, initialRowCount + 1000);
    System.out.println("Appended records successfully.");
  }

  private static long getRowCount(TableName parentTable) throws InterruptedException {
    String queryRowCount =
        "SELECT COUNT(*) FROM `"
            + parentTable.getProject()
            + "."
            + parentTable.getDataset()
            + "."
            + parentTable.getTable()
            + "`";
    QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(queryRowCount).build();
    BigQuery bigquery =
        BigQueryOptions.newBuilder().setProjectId(parentTable.getProject()).build().getService();
    TableResult results = bigquery.query(queryConfig);
    return Long.parseLong(results.getValues().iterator().next().get("f0_").getStringValue());
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
    BigQuery bigquery =
        BigQueryOptions.newBuilder().setProjectId(parentTable.getProject()).build().getService();
    TableResult results = bigquery.query(queryConfig);
    long countRowsActual =
        Long.parseLong(results.getValues().iterator().next().get("f0_").getStringValue());
    if (countRowsActual != expectedRowCount) {
      throw new RuntimeException(
          "Unexpected row count. Expected: " + expectedRowCount + ". Actual: " + countRowsActual);
    }
  }

  private static class ArrowData {
    Schema arrowSchema;
    ArrowRecordBatch data;

    ArrowData(Schema arrowSchema, ArrowRecordBatch data) {
      this.arrowSchema = arrowSchema;
      this.data = data;
    }
  }

  private static class DataWriter {

    private static final int MAX_RECREATE_COUNT = 3;

    private BigQueryWriteClient client;

    // Track the number of in-flight requests to wait for all responses before shutting down.
    private final Phaser inflightRequestCount = new Phaser(1);
    private final Object lock = new Object();

    private Schema arrowSchema;
    private StreamWriter streamWriter;

    @GuardedBy("lock")
    private RuntimeException error = null;

    private final AtomicInteger recreateCount = new AtomicInteger(0);

    private StreamWriter createStreamWriter(String streamName, Schema arrowSchema)
        throws IOException {
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

      // Use the Stream writer to send records in Arrow format. Specify the table name to write
      // to the default stream.
      // For more information about StreamWriter, see:
      // https://cloud.google.com/java/docs/reference/google-cloud-bigquerystorage/latest/com.google.cloud.bigquery.storage.v1.StreamWriter
      return StreamWriter.newBuilder(streamName, client)
          .setExecutorProvider(FixedExecutorProvider.create(Executors.newScheduledThreadPool(10)))
          .setChannelProvider(
              BigQueryWriteSettings.defaultGrpcTransportProviderBuilder()
                  .setKeepAliveTime(org.threeten.bp.Duration.ofMinutes(1))
                  .setKeepAliveTimeout(org.threeten.bp.Duration.ofMinutes(1))
                  .setKeepAliveWithoutCalls(true)
                  .setChannelsPerCpu(2)
                  .build())
          .setEnableConnectionPool(true)
          // If value is missing in ArrowRecordBatch and there is a default value configured on
          // bigquery column, apply the default value to the missing value field.
          .setDefaultMissingValueInterpretation(
              AppendRowsRequest.MissingValueInterpretation.DEFAULT_VALUE)
          .setMaxRetryDuration(java.time.Duration.ofSeconds(5))
          // Set the StreamWriter with Arrow Schema, this would only allow the StreamWriter to
          // append data in Arrow format.
          .setWriterSchema(arrowSchema)
          .setRetrySettings(retrySettings)
          .build();
    }

    public void initialize(TableName parentTable, Schema arrowSchema)
        throws DescriptorValidationException, IOException, InterruptedException {
      // Initialize client without settings, internally within stream writer a new client will be
      // created with full settings.
      client = BigQueryWriteClient.create();

      streamWriter = createStreamWriter(parentTable.toString() + "/_default", arrowSchema);
    }

    public void append(ArrowData arrowData)
        throws DescriptorValidationException, IOException, InterruptedException {
      synchronized (this.lock) {
        if (!streamWriter.isUserClosed()
            && streamWriter.isClosed()
            && recreateCount.getAndIncrement() < MAX_RECREATE_COUNT) {
          streamWriter = createStreamWriter(streamWriter.getStreamName(), arrowData.arrowSchema);
          this.error = null;
        }
        // If earlier appends have failed, we need to reset before continuing.
        if (this.error != null) {
          throw this.error;
        }
      }
      // Append asynchronously for increased throughput.
      ApiFuture<AppendRowsResponse> future = streamWriter.append(arrowData.data);
      ApiFutures.addCallback(
          future, new AppendCompleteCallback(this, arrowData), MoreExecutors.directExecutor());

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
      private final ArrowData arrowData;

      public AppendCompleteCallback(DataWriter parent, ArrowData arrowData) {
        this.parent = parent;
        this.arrowData = arrowData;
      }

      public void onSuccess(AppendRowsResponse response) {
        System.out.format("Append success\n");
        this.parent.recreateCount.set(0);
        done();
      }

      public void onFailure(Throwable throwable) {
        System.out.format("Append failed: " + throwable.toString());
        if (throwable instanceof AppendSerializationError) {
          AppendSerializationError ase = (AppendSerializationError) throwable;
          Map<Integer, String> rowIndexToErrorMessage = ase.getRowIndexToErrorMessage();
          if (rowIndexToErrorMessage.size() > 0) {
            System.out.format("row level errors: " + rowIndexToErrorMessage.toString());
            // The append returned failure with indices for faulty rows.
            // Fix the faulty rows or remove them from the appended data and retry the append.
            done();
            return;
          }
        }

        boolean resendRequest = false;
        if (throwable instanceof MaximumRequestCallbackWaitTimeExceededException) {
          resendRequest = true;
        } else if (throwable instanceof StreamWriterClosedException) {
          if (!parent.streamWriter.isUserClosed()) {
            resendRequest = true;
          }
        }
        if (resendRequest) {
          // Retry this request.
          try {
            this.parent.append(new ArrowData(arrowData.arrowSchema, arrowData.data));
          } catch (DescriptorValidationException e) {
            throw new RuntimeException(e);
          } catch (IOException e) {
            throw new RuntimeException(e);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          // Mark the existing attempt as done since we got a response for it
          done();
          return;
        }

        synchronized (this.parent.lock) {
          if (this.parent.error == null) {
            StorageException storageException = Exceptions.toStorageException(throwable);
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
// [END bigquerystorage_streamwriter_default_arrow]
