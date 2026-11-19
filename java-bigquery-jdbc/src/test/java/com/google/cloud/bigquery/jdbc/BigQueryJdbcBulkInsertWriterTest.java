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
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import io.grpc.StatusRuntimeException;
import java.time.Duration;
import org.junit.jupiter.api.Test;

public class BigQueryJdbcBulkInsertWriterTest {

  private static final String STREAM_NAME =
      "projects/test-project/datasets/test_dataset/tables/test_table/streams/_pending1";

  @Test
  public void testInitializePassesClientToJsonStreamWriter() throws Exception {
    BigQueryWriteClient mockClient = mock(BigQueryWriteClient.class);
    BigQueryWriteSettings mockSettings =
        BigQueryWriteSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    when(mockClient.getSettings()).thenReturn(mockSettings);

    WriteStream stream =
        WriteStream.newBuilder()
            .setName(STREAM_NAME)
            .setTableSchema(TableSchema.newBuilder().build())
            .build();
    when(mockClient.createWriteStream(any(CreateWriteStreamRequest.class))).thenReturn(stream);

    TableName tableName = TableName.of("test-project", "test_dataset", "test_table");
    BigQueryJdbcBulkInsertWriter writer = new BigQueryJdbcBulkInsertWriter();
    writer.initialize(tableName, mockClient, null);

    assertNotNull(writer.getStreamName());
    assertEquals(STREAM_NAME, writer.getStreamName());
    verify(mockClient).getSettings();
    writer.closeQuietly();
  }

  @Test
  public void testCloseQuietlyBeforeInitializeIsNoOp() {
    BigQueryJdbcBulkInsertWriter writer = new BigQueryJdbcBulkInsertWriter();
    assertNull(writer.getStreamName());
    assertDoesNotThrow(writer::closeQuietly);
  }

  @Test
  public void testCloseQuietlyClosesOnceAndSwallowsRuntimeException() {
    BigQueryJdbcBulkInsertWriter writer = new BigQueryJdbcBulkInsertWriter();
    JsonStreamWriter mockStreamWriter = mock(JsonStreamWriter.class);
    doThrow(new RuntimeException("close boom")).when(mockStreamWriter).close();
    writer.jsonStreamWriter = mockStreamWriter;

    assertDoesNotThrow(writer::closeQuietly);
    assertDoesNotThrow(writer::closeQuietly);
    verify(mockStreamWriter, times(1)).close();
  }

  @Test
  public void testAppendWithImmediateFuturesDoesNotPrematurelyTerminatePhaser() throws Exception {
    BigQueryJdbcBulkInsertWriter writer = new BigQueryJdbcBulkInsertWriter();
    JsonStreamWriter mockStreamWriter = mock(JsonStreamWriter.class);
    when(mockStreamWriter.getStreamName()).thenReturn(STREAM_NAME);
    writer.jsonStreamWriter = mockStreamWriter;

    SettableApiFuture<AppendRowsResponse> delayedSecondBatch = SettableApiFuture.create();
    when(mockStreamWriter.append(any(JsonArray.class), anyLong()))
        .thenReturn(ApiFutures.immediateFuture(AppendRowsResponse.getDefaultInstance()))
        .thenReturn(delayedSecondBatch);

    JsonArray rows = new JsonArray();
    rows.add(new JsonObject());
    // First batch completes synchronously inside addCallback; second batch stays in flight.
    writer.append(rows, 0L);
    writer.append(rows, 1L);

    // Complete second batch on another thread while cleanup awaits openRequestCount.
    Thread completer =
        new Thread(() -> delayedSecondBatch.set(AppendRowsResponse.getDefaultInstance()));
    completer.start();

    BigQueryWriteClient mockClient = mock(BigQueryWriteClient.class);
    when(mockClient.finalizeWriteStream(STREAM_NAME))
        .thenReturn(FinalizeWriteStreamResponse.newBuilder().setRowCount(2L).build());

    long rowCount = writer.cleanup(mockClient);
    completer.join();

    assertEquals(2L, rowCount);
    verify(mockStreamWriter, times(1)).close();
    // Subsequent closeQuietly after cleanup must not double-close.
    writer.closeQuietly();
    verify(mockStreamWriter, times(1)).close();
  }

  @Test
  public void testSynchronousAppendFailureDeregistersPhaserAndAllowsCleanCleanup()
      throws Exception {
    BigQueryJdbcBulkInsertWriter writer = new BigQueryJdbcBulkInsertWriter();
    JsonStreamWriter mockStreamWriter = mock(JsonStreamWriter.class);
    when(mockStreamWriter.getStreamName()).thenReturn(STREAM_NAME);
    RuntimeException syncFailure = new IllegalArgumentException("bad serialization");
    when(mockStreamWriter.append(any(JsonArray.class), anyLong())).thenThrow(syncFailure);
    writer.jsonStreamWriter = mockStreamWriter;

    JsonArray rows = new JsonArray();
    rows.add(new JsonObject());

    RuntimeException thrown = assertThrows(RuntimeException.class, () -> writer.append(rows, 0L));
    assertSame(syncFailure, thrown);

    BigQueryWriteClient mockClient = mock(BigQueryWriteClient.class);
    when(mockClient.finalizeWriteStream(STREAM_NAME))
        .thenReturn(FinalizeWriteStreamResponse.newBuilder().setRowCount(0L).build());
    long rowCount =
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> writer.cleanup(mockClient));
    assertEquals(0L, rowCount);
    verify(mockStreamWriter, times(1)).close();
  }

  @Test
  public void testCleanupInterruptibleWhenAppendStalls() throws Exception {
    BigQueryJdbcBulkInsertWriter writer = new BigQueryJdbcBulkInsertWriter();
    JsonStreamWriter mockStreamWriter = mock(JsonStreamWriter.class);
    when(mockStreamWriter.getStreamName()).thenReturn(STREAM_NAME);
    SettableApiFuture<AppendRowsResponse> stalledBatch = SettableApiFuture.create();
    when(mockStreamWriter.append(any(JsonArray.class), anyLong())).thenReturn(stalledBatch);
    writer.jsonStreamWriter = mockStreamWriter;

    JsonArray rows = new JsonArray();
    rows.add(new JsonObject());
    writer.append(rows, 0L);

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
    verify(mockStreamWriter, times(1)).close();
    verify(mockClient, never()).finalizeWriteStream(anyString());
  }

  @Test
  public void testAsyncCallbackFailurePropagatesOnCleanupAndClosesStreamOnce() throws Exception {
    BigQueryJdbcBulkInsertWriter writer = new BigQueryJdbcBulkInsertWriter();
    JsonStreamWriter mockStreamWriter = mock(JsonStreamWriter.class);
    when(mockStreamWriter.getStreamName()).thenReturn(STREAM_NAME);
    StatusRuntimeException grpcFailure =
        Status.INVALID_ARGUMENT.withDescription("append rejected").asRuntimeException();
    when(mockStreamWriter.append(any(JsonArray.class), anyLong()))
        .thenReturn(ApiFutures.immediateFailedFuture(grpcFailure));
    writer.jsonStreamWriter = mockStreamWriter;

    JsonArray rows = new JsonArray();
    rows.add(new JsonObject());
    writer.append(rows, 0L);

    BigQueryWriteClient mockClient = mock(BigQueryWriteClient.class);
    assertThrows(RuntimeException.class, () -> writer.cleanup(mockClient));
    verify(mockStreamWriter, times(1)).close();
  }
}
