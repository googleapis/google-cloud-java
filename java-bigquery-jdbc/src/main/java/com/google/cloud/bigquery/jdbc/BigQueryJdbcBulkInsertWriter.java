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
import com.google.cloud.bigquery.storage.v1.BQTableSchemaToProtoDescriptor;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1.Exceptions;
import com.google.cloud.bigquery.storage.v1.Exceptions.StorageException;
import com.google.cloud.bigquery.storage.v1.FinalizeWriteStreamResponse;
import com.google.cloud.bigquery.storage.v1.ProtoRows;
import com.google.cloud.bigquery.storage.v1.ProtoSchema;
import com.google.cloud.bigquery.storage.v1.ProtoSchemaConverter;
import com.google.cloud.bigquery.storage.v1.StreamWriter;
import com.google.cloud.bigquery.storage.v1.TableFieldSchema;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.cloud.bigquery.storage.v1.TableSchema;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import javax.annotation.concurrent.GuardedBy;

class BigQueryJdbcBulkInsertWriter {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryJdbcBulkInsertWriter.class.getName());
  private StreamWriter streamWriter;
  private volatile String streamName;
  private volatile Descriptor descriptor;
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
    this.descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(
            normalizeTableSchemaFieldNames(writeStream.getTableSchema()));
    ProtoSchema protoSchema = ProtoSchemaConverter.convert(this.descriptor);

    StreamWriter.Builder streamWriterBuilder =
        StreamWriter.newBuilder(this.streamName, client).setWriterSchema(protoSchema);
    if (retrySettings != null) {
      streamWriterBuilder.setRetrySettings(retrySettings);
    }
    this.streamWriter = buildStreamWriter(streamWriterBuilder);
  }

  StreamWriter buildStreamWriter(StreamWriter.Builder builder) throws IOException {
    return builder.build();
  }

  Descriptor getDescriptor() {
    return this.descriptor;
  }

  // Lowercase field names with Locale.ROOT upfront because BQTableSchemaToProtoDescriptor calls
  // String.toLowerCase() with the JVM default locale (turning 'I' into 'ı' under tr/az locales).
  private static TableSchema normalizeTableSchemaFieldNames(TableSchema schema) {
    TableSchema.Builder builder = schema.toBuilder().clearFields();
    for (TableFieldSchema field : schema.getFieldsList()) {
      builder.addFields(normalizeFieldName(field));
    }
    return builder.build();
  }

  private static TableFieldSchema normalizeFieldName(TableFieldSchema field) {
    TableFieldSchema.Builder builder =
        field.toBuilder().setName(field.getName().toLowerCase(Locale.ROOT));
    if (field.getFieldsCount() > 0) {
      builder.clearFields();
      for (TableFieldSchema subField : field.getFieldsList()) {
        builder.addFields(normalizeFieldName(subField));
      }
    }
    return builder.build();
  }

  void append(ProtoRows rows, long offset) throws IOException {
    if (LOG.isLoggable(Level.FINER)) {
      LOG.finer("Appending %d rows at offset %d", rows.getSerializedRowsCount(), offset);
    }
    synchronized (this.streamLock) {
      if (this.error != null) {
        throw this.error;
      }
    }

    // Register before submitting so a synchronously completed future cannot drop the party count
    // to zero (which permanently terminates the Phaser) before registration occurs.
    openRequestCount.register();
    AppendCompleteCallback callback = new AppendCompleteCallback(this);
    try {
      ApiFuture<AppendRowsResponse> future = streamWriter.append(rows, offset);
      ApiFutures.addCallback(future, callback, MoreExecutors.directExecutor());
    } catch (Throwable t) {
      callback.done();
      throw t;
    }
  }

  long cleanup(BigQueryWriteClient client) throws InterruptedException {
    LOG.finer("++enter++");
    String currentStreamName = getStreamName();
    LOG.fine("Cleaning up bulk insert writer for stream: %s", currentStreamName);
    try {
      openRequestCount.awaitAdvanceInterruptibly(openRequestCount.arrive());
    } catch (Throwable t) {
      closeQuietly();
      throw t;
    }
    closeWriter();

    synchronized (this.streamLock) {
      if (this.error != null) {
        throw this.error;
      }
    }

    FinalizeWriteStreamResponse finalizeResponse = client.finalizeWriteStream(currentStreamName);
    LOG.finer("Rows written: %d", finalizeResponse.getRowCount());
    return finalizeResponse.getRowCount();
  }

  void closeQuietly() {
    if (this.streamWriter != null && this.writerClosed.compareAndSet(false, true)) {
      try {
        this.streamWriter.close();
      } catch (RuntimeException ex) {
        LOG.warning(ex, "Failed to close stream writer during error cleanup.");
      }
    }
  }

  private void closeWriter() {
    if (this.streamWriter != null && this.writerClosed.compareAndSet(false, true)) {
      this.streamWriter.close();
    }
  }

  String getStreamName() {
    if (this.streamName != null) {
      return this.streamName;
    }
    return this.streamWriter != null ? this.streamWriter.getStreamName() : null;
  }

  static class AppendCompleteCallback implements ApiFutureCallback<AppendRowsResponse> {

    private final BigQueryJdbcBulkInsertWriter parent;
    private final AtomicBoolean deregistered = new AtomicBoolean(false);

    AppendCompleteCallback(BigQueryJdbcBulkInsertWriter parent) {
      this.parent = parent;
    }

    @Override
    public void onSuccess(AppendRowsResponse response) {
      done();
    }

    @Override
    public void onFailure(Throwable throwable) {
      try {
        synchronized (this.parent.streamLock) {
          if (this.parent.error == null) {
            StorageException storageException = Exceptions.toStorageException(throwable);
            this.parent.error =
                (storageException != null) ? storageException : new RuntimeException(throwable);
          }
        }
        LOG.warning(
            "Append failed for stream %s: %s", parent.getStreamName(), throwable.getMessage());
      } finally {
        done();
      }
    }

    void done() {
      if (this.deregistered.compareAndSet(false, true)) {
        this.parent.openRequestCount.arriveAndDeregister();
      }
    }
  }
}
