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
import java.util.logging.Level;
import javax.annotation.concurrent.GuardedBy;

class BigQueryJdbcBulkInsertWriter {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryJdbcBulkInsertWriter.class.getName());
  private StreamWriter streamWriter;
  private volatile Descriptor descriptor;
  private final Phaser openRequestCount = new Phaser(1);
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
    this.descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(
            normalizeTableSchemaFieldNames(writeStream.getTableSchema()));
    ProtoSchema protoSchema = ProtoSchemaConverter.convert(this.descriptor);

    StreamWriter.Builder streamWriterBuilder =
        StreamWriter.newBuilder(writeStream.getName(), client).setWriterSchema(protoSchema);
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

    ApiFuture<AppendRowsResponse> future = streamWriter.append(rows, offset);
    ApiFutures.addCallback(
        future, new AppendCompleteCallback(this), MoreExecutors.directExecutor());
    openRequestCount.register();
  }

  long cleanup(BigQueryWriteClient client) {
    LOG.finer("++enter++");
    LOG.fine("Cleaning up bulk insert writer for stream: %s", streamWriter.getStreamName());
    openRequestCount.arriveAndAwaitAdvance();
    streamWriter.close();

    synchronized (this.streamLock) {
      if (this.error != null) {
        throw this.error;
      }
    }

    FinalizeWriteStreamResponse finalizeResponse =
        client.finalizeWriteStream(streamWriter.getStreamName());
    LOG.finer("Rows written: %d", finalizeResponse.getRowCount());
    return finalizeResponse.getRowCount();
  }

  String getStreamName() {
    return streamWriter.getStreamName();
  }

  static class AppendCompleteCallback implements ApiFutureCallback<AppendRowsResponse> {

    private final BigQueryJdbcBulkInsertWriter parent;

    AppendCompleteCallback(BigQueryJdbcBulkInsertWriter parent) {
      this.parent = parent;
    }

    @Override
    public void onSuccess(AppendRowsResponse response) {
      done();
    }

    @Override
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
