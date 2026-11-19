/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

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
import com.google.gson.JsonArray;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import java.io.IOException;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import javax.annotation.concurrent.GuardedBy;

class BigQueryJdbcBulkInsertWriter {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryJdbcBulkInsertWriter.class.getName());
  JsonStreamWriter jsonStreamWriter;
  // Written once during initialize() and read by background gRPC completion callbacks.
  private volatile String streamName;
  private final Phaser openRequestCount = new Phaser(1);
  private final AtomicBoolean writerClosed = new AtomicBoolean(false);
  private final Object streamLock = new Object();

  @GuardedBy("streamLock")
  private RuntimeException error = null;

  void initialize(TableName parentTable, BigQueryWriteClient client, RetrySettings retrySettings)
      throws IOException, DescriptorValidationException, InterruptedException {
    LOG.finer("++enter++");
    LOG.fine("Initializing bulk insert writer for table: %s", parentTable);
    WriteStream stream = WriteStream.newBuilder().setType(WriteStream.Type.PENDING).build();

    CreateWriteStreamRequest createWriteStreamRequest =
        CreateWriteStreamRequest.newBuilder()
            .setParent(parentTable.toString())
            .setWriteStream(stream)
            .build();
    WriteStream writeStream = client.createWriteStream(createWriteStreamRequest);
    this.streamName = writeStream.getName();

    JsonStreamWriter.Builder jsonStreamWriterBuilder =
        JsonStreamWriter.newBuilder(this.streamName, writeStream.getTableSchema(), client);

    if (retrySettings != null) {
      jsonStreamWriterBuilder.setRetrySettings(retrySettings);
    }

    this.jsonStreamWriter = buildJsonStreamWriter(jsonStreamWriterBuilder);
  }

  JsonStreamWriter buildJsonStreamWriter(JsonStreamWriter.Builder builder)
      throws DescriptorValidationException, IOException, InterruptedException {
    return builder.build();
  }

  void append(JsonArray data, long offset) throws DescriptorValidationException, IOException {
    if (LOG.isLoggable(Level.FINER)) {
      LOG.finer("Appending %d rows at offset %d", data.size(), offset);
    }
    synchronized (this.streamLock) {
      if (this.error != null) {
        throw this.error;
      }
    }

    // Register before submitting so a synchronously completed future cannot drop the party count
    // to zero (which permanently terminates the Phaser) before registration occurs.
    openRequestCount.register();
    ApiFuture<AppendRowsResponse> future;
    try {
      future = jsonStreamWriter.append(data, offset);
    } catch (Throwable t) {
      openRequestCount.arriveAndDeregister();
      throw t;
    }
    ApiFutures.addCallback(
        future, new AppendCompleteCallback(this), MoreExecutors.directExecutor());
  }

  long cleanup(BigQueryWriteClient client) throws InterruptedException {
    LOG.finer("++enter++");
    String currentStreamName = getStreamName();
    LOG.fine("Cleaning up bulk insert writer for stream: %s", currentStreamName);
    try {
      openRequestCount.awaitAdvanceInterruptibly(openRequestCount.arrive());
    } finally {
      closeStreamWriter();
    }

    synchronized (this.streamLock) {
      if (this.error != null) {
        throw this.error;
      }
    }

    // Finalize the stream.
    FinalizeWriteStreamResponse finalizeResponse = client.finalizeWriteStream(currentStreamName);
    LOG.finer("Rows written: %d", finalizeResponse.getRowCount());
    return finalizeResponse.getRowCount();
  }

  void closeQuietly() {
    if (this.jsonStreamWriter != null && this.writerClosed.compareAndSet(false, true)) {
      try {
        this.jsonStreamWriter.close();
      } catch (RuntimeException ex) {
        LOG.warning(ex, "Failed to close JsonStreamWriter during error cleanup.");
      }
    }
  }

  private void closeStreamWriter() {
    if (this.jsonStreamWriter != null && this.writerClosed.compareAndSet(false, true)) {
      this.jsonStreamWriter.close();
    }
  }

  String getStreamName() {
    if (this.streamName != null) {
      return this.streamName;
    }
    return this.jsonStreamWriter != null ? this.jsonStreamWriter.getStreamName() : null;
  }

  static class AppendCompleteCallback implements ApiFutureCallback<AppendRowsResponse> {

    private final BigQueryJdbcBulkInsertWriter parent;

    AppendCompleteCallback(BigQueryJdbcBulkInsertWriter parent) {
      this.parent = parent;
    }

    public void onSuccess(AppendRowsResponse response) {
      done();
    }

    public void onFailure(Throwable throwable) {
      LOG.warning(
          "Append failed for stream %s: %s", parent.getStreamName(), throwable.getMessage());
      synchronized (this.parent.streamLock) {
        if (this.parent.error == null) {
          StorageException storageException = Exceptions.toStorageException(throwable);
          this.parent.error =
              (storageException != null) ? storageException : new RuntimeException(throwable);
        }
      }
      done();
    }

    private void done() {
      this.parent.openRequestCount.arriveAndDeregister();
    }
  }
}
