/*
 * Copyright 2026 Google LLC
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

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.cloud.bigquery.storage.v1.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteSettings;
import com.google.cloud.bigquery.storage.v1.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1.FinalizeWriteStreamResponse;
import com.google.cloud.bigquery.storage.v1.JsonStreamWriter;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.cloud.bigquery.storage.v1.TableSchema;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.grpc.Status;
import java.time.Duration;
import org.junit.jupiter.api.Test;

public class BigQueryJdbcBulkInsertWriterTest {

  private static final String STREAM_NAME =
      "projects/test-project/datasets/test_dataset/tables/test_table/streams/_pending1";

  private static JsonArray singleRowBatch() {
    JsonArray rows = new JsonArray();
    rows.add(new JsonObject());
    return rows;
  }

  private static BigQueryJdbcBulkInsertWriter writerWithMockStream(JsonStreamWriter streamWriter) {
    when(streamWriter.getStreamName()).thenReturn(STREAM_NAME);
    BigQueryJdbcBulkInsertWriter writer = new BigQueryJdbcBulkInsertWriter();
    writer.jsonStreamWriter = streamWriter;
    return writer;
  }

  @Test
  public void testInitializePassesClientToJsonStreamWriter() throws Exception {
    BigQueryWriteClient mockClient = mock(BigQueryWriteClient.class);
    when(mockClient.getSettings())
        .thenReturn(
            BigQueryWriteSettings.newBuilder()
                .setCredentialsProvider(NoCredentialsProvider.create())
                .build());
    when(mockClient.createWriteStream(any(CreateWriteStreamRequest.class)))
        .thenReturn(
            WriteStream.newBuilder()
                .setName(STREAM_NAME)
                .setTableSchema(TableSchema.getDefaultInstance())
                .build());

    BigQueryJdbcBulkInsertWriter writer = new BigQueryJdbcBulkInsertWriter();
    writer.initialize(TableName.of("test-project", "test_dataset", "test_table"), mockClient, null);

    assertEquals(STREAM_NAME, writer.getStreamName());
    verify(mockClient).getSettings();
    writer.closeQuietly();
  }

  @Test
  public void testCloseQuietlyIsIdempotentAndSwallowsErrors() {
    BigQueryJdbcBulkInsertWriter uninitialized = new BigQueryJdbcBulkInsertWriter();
    assertNull(uninitialized.getStreamName());
    assertDoesNotThrow(uninitialized::closeQuietly);

    JsonStreamWriter mockStreamWriter = mock(JsonStreamWriter.class);
    doThrow(new RuntimeException("close boom")).when(mockStreamWriter).close();
    BigQueryJdbcBulkInsertWriter writer = writerWithMockStream(mockStreamWriter);

    assertDoesNotThrow(writer::closeQuietly);
    assertDoesNotThrow(writer::closeQuietly);
    verify(mockStreamWriter, times(1)).close();
  }

  @Test
  public void testAppendImmediateAndAsyncFuturesCoordinatePhaserAndCloseOnce() throws Exception {
    JsonStreamWriter mockStreamWriter = mock(JsonStreamWriter.class);
    SettableApiFuture<AppendRowsResponse> delayedSecondBatch = SettableApiFuture.create();
    when(mockStreamWriter.append(any(JsonArray.class), anyLong()))
        .thenReturn(ApiFutures.immediateFuture(AppendRowsResponse.getDefaultInstance()))
        .thenReturn(delayedSecondBatch);
    BigQueryJdbcBulkInsertWriter writer = writerWithMockStream(mockStreamWriter);

    writer.append(singleRowBatch(), 0L);
    writer.append(singleRowBatch(), 1L);
    Thread completer =
        new Thread(() -> delayedSecondBatch.set(AppendRowsResponse.getDefaultInstance()));
    completer.start();

    BigQueryWriteClient mockClient = mock(BigQueryWriteClient.class);
    when(mockClient.finalizeWriteStream(STREAM_NAME))
        .thenReturn(FinalizeWriteStreamResponse.newBuilder().setRowCount(2L).build());

    assertEquals(2L, writer.cleanup(mockClient));
    completer.join();
    writer.closeQuietly();
    verify(mockStreamWriter, times(1)).close();
  }

  @Test
  public void testSyncAppendThrowOrNullFutureDeregistersPhaserWithoutHangingCleanup()
      throws Exception {
    JsonStreamWriter mockStreamWriter = mock(JsonStreamWriter.class);
    RuntimeException syncFailure = new IllegalArgumentException("bad serialization");
    when(mockStreamWriter.append(any(JsonArray.class), anyLong()))
        .thenThrow(syncFailure)
        .thenReturn(null);
    BigQueryJdbcBulkInsertWriter writer = writerWithMockStream(mockStreamWriter);

    assertSame(
        syncFailure,
        assertThrows(RuntimeException.class, () -> writer.append(singleRowBatch(), 0L)));
    assertThrows(NullPointerException.class, () -> writer.append(singleRowBatch(), 1L));

    BigQueryWriteClient mockClient = mock(BigQueryWriteClient.class);
    when(mockClient.finalizeWriteStream(STREAM_NAME))
        .thenReturn(FinalizeWriteStreamResponse.newBuilder().setRowCount(0L).build());
    assertEquals(
        0L, assertTimeoutPreemptively(Duration.ofSeconds(2), () -> writer.cleanup(mockClient)));
    verify(mockStreamWriter, times(1)).close();
  }

  @Test
  public void testCleanupInterruptibleAndAsyncCallbackFailurePropagates() throws Exception {
    JsonStreamWriter stalledWriter = mock(JsonStreamWriter.class);
    when(stalledWriter.append(any(JsonArray.class), anyLong()))
        .thenReturn(SettableApiFuture.create());
    BigQueryJdbcBulkInsertWriter writer = writerWithMockStream(stalledWriter);
    writer.append(singleRowBatch(), 0L);

    BigQueryWriteClient mockClient = mock(BigQueryWriteClient.class);
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          Thread.currentThread().interrupt();
          try {
            assertThrows(InterruptedException.class, () -> writer.cleanup(mockClient));
          } finally {
            Thread.interrupted();
          }
        });
    verify(stalledWriter, times(1)).close();
    verify(mockClient, never()).finalizeWriteStream(anyString());

    JsonStreamWriter failedWriter = mock(JsonStreamWriter.class);
    when(failedWriter.append(any(JsonArray.class), anyLong()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                Status.INVALID_ARGUMENT.withDescription("append rejected").asRuntimeException()));
    BigQueryJdbcBulkInsertWriter failingBulkWriter = writerWithMockStream(failedWriter);
    failingBulkWriter.append(singleRowBatch(), 0L);
    assertThrows(RuntimeException.class, () -> failingBulkWriter.cleanup(mockClient));
    verify(failedWriter, times(1)).close();
  }
}
