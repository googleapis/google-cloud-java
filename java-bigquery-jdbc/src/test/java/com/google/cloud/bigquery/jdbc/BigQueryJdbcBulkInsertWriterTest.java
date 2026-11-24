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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteSettings;
import com.google.cloud.bigquery.storage.v1.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1.FinalizeWriteStreamResponse;
import com.google.cloud.bigquery.storage.v1.TableFieldSchema;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.cloud.bigquery.storage.v1.TableSchema;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class BigQueryJdbcBulkInsertWriterTest {

  private static final String STREAM_NAME =
      "projects/test-project/datasets/test_dataset/tables/test_table/streams/_default";
  private static final TableName TABLE_NAME =
      TableName.of("test-project", "test_dataset", "test_table");

  private static BigQueryWriteClient stubWriteClient(long finalizedRows) throws Exception {
    BigQueryWriteClient mockClient = mock(BigQueryWriteClient.class);
    when(mockClient.getSettings())
        .thenReturn(
            BigQueryWriteSettings.newBuilder()
                .setCredentialsProvider(NoCredentialsProvider.create())
                .build());
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
    }
  }
}
