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
import javax.annotation.concurrent.GuardedBy;

class BigQueryJdbcBulkInsertWriter {
  private final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());
  private JsonStreamWriter jsonStreamWriter;
  private final Phaser openRequestCount = new Phaser(1);
  private final Object streamLock = new Object();

  @GuardedBy("lock")
  private RuntimeException error = null;

  void initialize(TableName parentTable, BigQueryWriteClient client, RetrySettings retrySettings)
      throws IOException, DescriptorValidationException, InterruptedException {
    WriteStream stream = WriteStream.newBuilder().setType(WriteStream.Type.PENDING).build();

    CreateWriteStreamRequest createWriteStreamRequest =
        CreateWriteStreamRequest.newBuilder()
            .setParent(parentTable.toString())
            .setWriteStream(stream)
            .build();
    WriteStream writeStream = client.createWriteStream(createWriteStreamRequest);

    JsonStreamWriter.Builder jsonStreamWriterBuilder =
        JsonStreamWriter.newBuilder(writeStream.getName(), writeStream.getTableSchema());

    if (retrySettings != null) {
      jsonStreamWriterBuilder.setRetrySettings(retrySettings);
    }

    this.jsonStreamWriter = jsonStreamWriterBuilder.build();
  }

  void append(JsonArray data, long offset) throws DescriptorValidationException, IOException {
    synchronized (this.streamLock) {
      if (this.error != null) {
        throw this.error;
      }
    }

    ApiFuture<AppendRowsResponse> future = jsonStreamWriter.append(data, offset);
    ApiFutures.addCallback(
        future, new AppendCompleteCallback(this), MoreExecutors.directExecutor());
    openRequestCount.register();
  }

  long cleanup(BigQueryWriteClient client) {
    openRequestCount.arriveAndAwaitAdvance();
    jsonStreamWriter.close();

    synchronized (this.streamLock) {
      if (this.error != null) {
        throw this.error;
      }
    }

    // Finalize the stream.
    FinalizeWriteStreamResponse finalizeResponse =
        client.finalizeWriteStream(jsonStreamWriter.getStreamName());
    LOG.finest("Rows written: " + finalizeResponse.getRowCount());
    return finalizeResponse.getRowCount();
  }

  String getStreamName() {
    return jsonStreamWriter.getStreamName();
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
