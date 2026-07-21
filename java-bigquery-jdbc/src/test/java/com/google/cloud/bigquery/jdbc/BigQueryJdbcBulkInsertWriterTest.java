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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteSettings;
import com.google.cloud.bigquery.storage.v1.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.cloud.bigquery.storage.v1.TableSchema;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import org.junit.jupiter.api.Test;

public class BigQueryJdbcBulkInsertWriterTest {

  @Test
  public void testInitializePassesClientToJsonStreamWriter() throws Exception {
    BigQueryWriteClient mockClient = mock(BigQueryWriteClient.class);
    BigQueryWriteSettings mockSettings = BigQueryWriteSettings.newBuilder().build();
    when(mockClient.getSettings()).thenReturn(mockSettings);

    WriteStream stream =
        WriteStream.newBuilder()
            .setName("projects/test-project/datasets/test_dataset/tables/test_table/streams/_default")
            .setTableSchema(TableSchema.newBuilder().build())
            .build();
    when(mockClient.createWriteStream(any(CreateWriteStreamRequest.class))).thenReturn(stream);

    TableName tableName = TableName.of("test-project", "test_dataset", "test_table");
    BigQueryJdbcBulkInsertWriter writer = new BigQueryJdbcBulkInsertWriter();
    writer.initialize(tableName, mockClient, null);

    assertNotNull(writer.getStreamName());
    verify(mockClient).getSettings();
  }
}
