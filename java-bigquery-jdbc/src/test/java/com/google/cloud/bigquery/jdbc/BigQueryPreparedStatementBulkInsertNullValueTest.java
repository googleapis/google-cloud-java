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
import static org.mockito.Mockito.mock;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.storage.v1.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1.BatchCommitWriteStreamsResponse;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteSettings;
import com.google.cloud.bigquery.storage.v1.FinalizeWriteStreamResponse;
import com.google.cloud.bigquery.storage.v1.MockBigQueryWrite;
import com.google.cloud.bigquery.storage.v1.TableFieldSchema;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.cloud.bigquery.storage.v1.TableSchema;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import com.google.protobuf.Int64Value;
import com.google.protobuf.Timestamp;
import java.lang.reflect.Method;
import java.sql.Types;
import java.util.Arrays;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Regression test for https://github.com/googleapis/google-cloud-java/issues/14066: a
 * null-valued STRING parameter in a Storage Write API batch insert used to throw NPE while
 * building the row's JSON representation, instead of writing a JSON null. Drives the real
 * bulkInsertWithWriteAPI code path end-to-end against an in-process fake Storage Write service so
 * the fix is verified without any real network dependency.
 */
public class BigQueryPreparedStatementBulkInsertNullValueTest {

  private static final String STREAM_NAME =
      "projects/test-project/datasets/test_dataset/tables/test_table/streams/test-stream";

  private MockBigQueryWrite mockBigQueryWrite;
  private MockServiceHelper serviceHelper;
  private BigQueryWriteClient writeClient;
  private BigQueryPreparedStatement preparedStatement;

  @BeforeEach
  public void setUp() throws Exception {
    mockBigQueryWrite = new MockBigQueryWrite();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockBigQueryWrite));
    serviceHelper.start();

    LocalChannelProvider channelProvider = serviceHelper.createChannelProvider();
    writeClient =
        BigQueryWriteClient.create(
            BigQueryWriteSettings.newBuilder()
                .setTransportChannelProvider(channelProvider)
                .setCredentialsProvider(NoCredentialsProvider.create())
                .build());

    TableFieldSchema nameField =
        TableFieldSchema.newBuilder()
            .setName("name")
            .setType(TableFieldSchema.Type.STRING)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .build();
    WriteStream writeStream =
        WriteStream.newBuilder()
            .setName(STREAM_NAME)
            .setTableSchema(TableSchema.newBuilder().addFields(nameField).build())
            .build();

    // Responses are consumed in call order by bulkInsertWithWriteAPI: createWriteStream, then
    // append, then finalizeWriteStream, then batchCommitWriteStreams.
    mockBigQueryWrite.addResponse(writeStream);
    mockBigQueryWrite.addResponse(
        AppendRowsResponse.newBuilder()
            .setAppendResult(
                AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(0)))
            .build());
    mockBigQueryWrite.addResponse(FinalizeWriteStreamResponse.newBuilder().setRowCount(1).build());
    mockBigQueryWrite.addResponse(
        BatchCommitWriteStreamsResponse.newBuilder()
            .setCommitTime(Timestamp.newBuilder().build())
            .build());

    BigQueryConnection connection = mock(BigQueryConnection.class);
    preparedStatement =
        new BigQueryPreparedStatement(connection, "INSERT INTO test_table (name) VALUES (?)");
    preparedStatement.insertSchema = Schema.of(Field.of("name", StandardSQLTypeName.STRING));

    java.lang.reflect.Field insertTableNameField =
        BigQueryPreparedStatement.class.getDeclaredField("insertTableName");
    insertTableNameField.setAccessible(true);
    insertTableNameField.set(
        preparedStatement, TableName.of("test-project", "test_dataset", "test_table"));
  }

  @AfterEach
  public void tearDown() throws Exception {
    writeClient.close();
    serviceHelper.stop();
  }

  @Test
  public void testBulkInsertWithWriteApiCompletesForNullStringParameter() throws Exception {
    preparedStatement.setNull(1, Types.VARCHAR);
    preparedStatement.addBatch();

    Method bulkInsertMethod =
        BigQueryPreparedStatement.class.getDeclaredMethod(
            "bulkInsertWithWriteAPI", BigQueryWriteClient.class);
    bulkInsertMethod.setAccessible(true);

    assertDoesNotThrow(() -> bulkInsertMethod.invoke(preparedStatement, writeClient));
  }
}
