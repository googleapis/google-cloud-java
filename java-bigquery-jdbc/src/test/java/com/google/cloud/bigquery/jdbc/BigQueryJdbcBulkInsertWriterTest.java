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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
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
import com.google.cloud.bigquery.storage.v1.ProtoRows;
import com.google.cloud.bigquery.storage.v1.StreamWriter;
import com.google.cloud.bigquery.storage.v1.TableFieldSchema;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.cloud.bigquery.storage.v1.TableSchema;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.time.Duration;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class BigQueryJdbcBulkInsertWriterTest {

  private static final String STREAM_NAME =
      "projects/test-project/datasets/test_dataset/tables/test_table/streams/_pending";
  private static final TableName TABLE_NAME =
      TableName.of("test-project", "test_dataset", "test_table");

  private static BigQueryWriteClient stubWriteClient(long finalizedRows) throws Exception {
    BigQueryWriteClient mockClient = mock(BigQueryWriteClient.class);
    BigQueryWriteSettings mockSettings =
        BigQueryWriteSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    when(mockClient.getSettings()).thenReturn(mockSettings);
    WriteStream stream =
        WriteStream.newBuilder()
            .setName(STREAM_NAME)
            .setTableSchema(
                TableSchema.newBuilder()
                    .addFields(
                        TableFieldSchema.newBuilder()
                            .setName("ID")
                            .setType(TableFieldSchema.Type.STRING)
                            .setMode(TableFieldSchema.Mode.NULLABLE)
                            .build())
                    .build())
            .build();
    when(mockClient.createWriteStream(any(CreateWriteStreamRequest.class))).thenReturn(stream);
    if (finalizedRows >= 0) {
      when(mockClient.finalizeWriteStream(STREAM_NAME))
          .thenReturn(FinalizeWriteStreamResponse.newBuilder().setRowCount(finalizedRows).build());
    }
    return mockClient;
  }

  private static BigQueryJdbcBulkInsertWriter writerWithMockStream(StreamWriter mockStream) {
    return new BigQueryJdbcBulkInsertWriter() {
      @Override
      StreamWriter buildStreamWriter(StreamWriter.Builder builder) {
        return mockStream;
      }
    };
  }

  @Test
  public void testInitializeBuildsProtoSchemaStreamWriterFromClient() throws Exception {
    Locale saved = Locale.getDefault();
    BigQueryWriteClient mockClient = stubWriteClient(-1L);
    BigQueryJdbcBulkInsertWriter writer = new BigQueryJdbcBulkInsertWriter();
    try {
      Locale.setDefault(Locale.forLanguageTag("tr-TR"));
      writer.initialize(TABLE_NAME, mockClient, null);
      assertEquals(STREAM_NAME, writer.getStreamName());
      assertNotNull(writer.getDescriptor());
      assertNotNull(writer.getDescriptor().findFieldByName("id"));
      verify(mockClient).getSettings();
    } finally {
      Locale.setDefault(saved);
      writer.closeQuietly();
    }
  }

  @Test
  public void testPhaserHandlesImmediateCompletionNullFutureFailureInterruptAndCloseQuietly()
      throws Exception {
    // 1. Multiple immediate-future appends do not prematurely terminate Phaser; closeQuietly is
    // idempotent after cleanup.
    BigQueryWriteClient okClient = stubWriteClient(4L);
    StreamWriter okStream = mock(StreamWriter.class);
    when(okStream.append(any(ProtoRows.class), anyLong()))
        .thenReturn(ApiFutures.immediateFuture(AppendRowsResponse.getDefaultInstance()));
    BigQueryJdbcBulkInsertWriter okWriter = writerWithMockStream(okStream);
    okWriter.initialize(TABLE_NAME, okClient, null);
    okWriter.append(ProtoRows.getDefaultInstance(), 0L);
    okWriter.append(ProtoRows.getDefaultInstance(), 2L);
    assertEquals(4L, okWriter.cleanup(okClient));
    okWriter.closeQuietly();
    verify(okStream, times(1)).close();

    // 2. Synchronous RuntimeException or null ApiFuture deregisters Phaser so cleanup never hangs.
    for (boolean returnNullFuture : new boolean[] {false, true}) {
      BigQueryWriteClient failClient = stubWriteClient(0L);
      StreamWriter syncFailStream = mock(StreamWriter.class);
      RuntimeException boom = new IllegalStateException("sync append failure");
      if (returnNullFuture) {
        when(syncFailStream.append(any(ProtoRows.class), anyLong())).thenReturn(null);
      } else {
        when(syncFailStream.append(any(ProtoRows.class), anyLong())).thenThrow(boom);
      }
      BigQueryJdbcBulkInsertWriter syncFailWriter = writerWithMockStream(syncFailStream);
      syncFailWriter.initialize(TABLE_NAME, failClient, null);
      if (returnNullFuture) {
        assertThrows(
            NullPointerException.class,
            () -> syncFailWriter.append(ProtoRows.getDefaultInstance(), 0L));
      } else {
        assertSame(
            boom,
            assertThrows(
                IllegalStateException.class,
                () -> syncFailWriter.append(ProtoRows.getDefaultInstance(), 0L)));
      }
      assertTimeoutPreemptively(Duration.ofSeconds(2), () -> syncFailWriter.cleanup(failClient));
      verify(syncFailStream, times(1)).close();
    }

    // 3. Asynchronous failed future surfaces error on subsequent append/cleanup without finalizing.
    BigQueryWriteClient asyncFailClient = stubWriteClient(-1L);
    StreamWriter asyncFailStream = mock(StreamWriter.class);
    when(asyncFailStream.append(any(ProtoRows.class), anyLong()))
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                new StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("bad proto"))));
    BigQueryJdbcBulkInsertWriter asyncFailWriter = writerWithMockStream(asyncFailStream);
    asyncFailWriter.initialize(TABLE_NAME, asyncFailClient, null);
    asyncFailWriter.append(ProtoRows.getDefaultInstance(), 0L);
    assertThrows(
        RuntimeException.class, () -> asyncFailWriter.append(ProtoRows.getDefaultInstance(), 1L));
    assertThrows(RuntimeException.class, () -> asyncFailWriter.cleanup(asyncFailClient));
    verify(asyncFailStream, times(1)).close();
    verify(asyncFailClient, never()).finalizeWriteStream(anyString());

    // 4. Interrupted cleanup aborts wait promptly and closes StreamWriter once.
    BigQueryWriteClient stalledClient = stubWriteClient(-1L);
    StreamWriter stalledStream = mock(StreamWriter.class);
    when(stalledStream.append(any(ProtoRows.class), anyLong()))
        .thenReturn(SettableApiFuture.create());
    BigQueryJdbcBulkInsertWriter stalledWriter = writerWithMockStream(stalledStream);
    stalledWriter.initialize(TABLE_NAME, stalledClient, null);
    stalledWriter.append(ProtoRows.getDefaultInstance(), 0L);
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          Thread.currentThread().interrupt();
          try {
            assertThrows(InterruptedException.class, () -> stalledWriter.cleanup(stalledClient));
          } finally {
            Thread.interrupted();
          }
        });
    stalledWriter.closeQuietly();
    verify(stalledStream, times(1)).close();
  }
}
