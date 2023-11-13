/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.bigquery.storage.v1.it;

import static org.junit.Assert.assertFalse;

import com.google.api.core.ApiFuture;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.storage.v1.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1.JsonStreamWriter;
import com.google.cloud.bigquery.storage.v1.TableFieldSchema;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.cloud.bigquery.storage.v1.TableSchema;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.threeten.bp.Duration;

public class WriteRetryTestUtil {
  private static final Logger LOG =
      Logger.getLogger(
          com.google.cloud.bigquery.storage.v1.it.ITBigQueryWriteQuotaRetryTest.class.getName());

  public static void runExclusiveRetryTest(
      BigQuery bigquery,
      BigQueryWriteClient client,
      String dataset,
      String projectId,
      WriteStream.Type streamType,
      int requestCount,
      int rowBatchSize)
      throws IOException, InterruptedException, DescriptorValidationException {
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelay(Duration.ofMillis(500))
            .setRetryDelayMultiplier(1.1)
            .setMaxAttempts(5)
            .setMaxRetryDelay(Duration.ofMinutes(1))
            .build();
    String tableName = "RetryTest";
    TableId tableId = TableId.of(dataset, tableName);
    Field col1 = Field.newBuilder("col1", StandardSQLTypeName.STRING).build();
    Schema schema = Schema.of(col1);
    TableInfo tableInfo = TableInfo.newBuilder(tableId, StandardTableDefinition.of(schema)).build();
    bigquery.create(tableInfo);
    TableName parent = TableName.of(projectId, dataset, tableName);

    WriteStream writeStream =
        client.createWriteStream(
            CreateWriteStreamRequest.newBuilder()
                .setParent(parent.toString())
                .setWriteStream(WriteStream.newBuilder().setType(streamType).build())
                .build());
    ArrayList<ApiFuture<AppendRowsResponse>> allResponses = new ArrayList<>(requestCount);
    try (JsonStreamWriter jsonStreamWriter =
        JsonStreamWriter.newBuilder(writeStream.getName(), writeStream.getTableSchema())
            .setRetrySettings(retrySettings)
            .build()) {
      for (int k = 0; k < requestCount; k++) {
        JSONObject row = new JSONObject();
        row.put("col1", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        JSONArray jsonArr = new JSONArray();
        // 3MB batch.
        for (int j = 0; j < rowBatchSize; j++) {
          jsonArr.put(row);
        }
        LOG.info("Appending: " + k + "/" + requestCount);
        allResponses.add(jsonStreamWriter.append(jsonArr, k * rowBatchSize));
      }
      LOG.info("Waiting for all responses to come back");
      for (int i = 0; i < requestCount; i++) {
        LOG.info("Waiting for request " + i);
        try {
          Assert.assertEquals(
              allResponses.get(i).get().getAppendResult().getOffset().getValue(), i * rowBatchSize);
        } catch (ExecutionException ex) {
          Assert.fail("Unexpected error " + ex);
        }
      }
    }
  }

  public static void runDefaultRetryTest(
      BigQuery bigquery,
      BigQueryWriteClient client,
      String dataset,
      String projectId,
      int requestCount,
      int rowBatchSize)
      throws IOException, InterruptedException, DescriptorValidationException {
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelay(Duration.ofMillis(500))
            .setRetryDelayMultiplier(1.1)
            .setMaxAttempts(5)
            .setMaxRetryDelay(Duration.ofMinutes(1))
            .build();
    String tableName = "JsonTableDefaultStream";
    TableFieldSchema TEST_STRING =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.STRING)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_str")
            .build();
    TableSchema tableSchema = TableSchema.newBuilder().addFields(0, TEST_STRING).build();
    TableInfo tableInfo =
        TableInfo.newBuilder(
                TableId.of(dataset, tableName),
                StandardTableDefinition.of(
                    Schema.of(Field.newBuilder("test_str", StandardSQLTypeName.STRING).build())))
            .build();

    bigquery.create(tableInfo);
    TableName parent = TableName.of(projectId, dataset, tableName);

    ArrayList<ApiFuture<AppendRowsResponse>> allResponses = new ArrayList<>(requestCount);
    try (JsonStreamWriter jsonStreamWriter =
        JsonStreamWriter.newBuilder(parent.toString(), tableSchema)
            .setIgnoreUnknownFields(true)
            .setRetrySettings(retrySettings)
            .build()) {
      for (int k = 0; k < requestCount; k++) {
        JSONObject row = new JSONObject();
        row.put("test_str", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        JSONArray jsonArr = new JSONArray();
        // 3MB batch.
        for (int j = 0; j < rowBatchSize; j++) {
          jsonArr.put(row);
        }
        LOG.info("Appending: " + k + "/" + requestCount);
        allResponses.add(jsonStreamWriter.append(jsonArr));
      }
      LOG.info("Waiting for all responses to come back");
      for (int i = 0; i < requestCount; i++) {
        LOG.info("Waiting for request " + i);
        try {
          assertFalse(allResponses.get(i).get().hasError());
        } catch (Exception ex) {
          Assert.fail("Unexpected error " + ex);
        }
      }
    }
  }
}
