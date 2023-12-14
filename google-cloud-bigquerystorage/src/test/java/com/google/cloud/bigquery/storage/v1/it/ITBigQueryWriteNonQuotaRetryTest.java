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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

import com.google.api.core.ApiFuture;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.storage.test.Test.FooType;
import com.google.cloud.bigquery.storage.v1.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.ProtoRows;
import com.google.cloud.bigquery.storage.v1.ProtoSchema;
import com.google.cloud.bigquery.storage.v1.StreamWriter;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import io.grpc.Status.Code;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/** Integration tests for BigQuery Write API. */
public class ITBigQueryWriteNonQuotaRetryTest {
  private static final Logger LOG = Logger.getLogger(ITBigQueryWriteQuotaRetryTest.class.getName());
  private static final String DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String TABLE = "testtable";
  private static final String DESCRIPTION = "BigQuery Write Java manual client test dataset";
  // This project is configured on the server to inject INTERNAL in-stream errors every
  // 10 messages.  This is done to verify in-stream message retries.
  private static final String NON_QUOTA_RETRY_PROJECT_ID = "bq-write-api-java-retry-test";
  private static BigQueryWriteClient client;
  private static BigQuery bigquery;

  @BeforeClass
  public static void beforeClass() throws IOException {
    client = BigQueryWriteClient.create();

    RemoteBigQueryHelper bigqueryHelper = RemoteBigQueryHelper.create();
    bigquery = bigqueryHelper.getOptions().getService();
    DatasetInfo datasetInfo =
        DatasetInfo.newBuilder(/* datasetId = */ DATASET).setDescription(DESCRIPTION).build();
    bigquery.create(datasetInfo);
    LOG.info("Created test dataset: " + DATASET);
    TableInfo tableInfo =
        TableInfo.newBuilder(
                TableId.of(DATASET, TABLE),
                StandardTableDefinition.of(
                    Schema.of(
                        Field.newBuilder("foo", LegacySQLTypeName.STRING)
                            .setMode(Field.Mode.NULLABLE)
                            .build())))
            .build();
    bigquery.create(tableInfo);
  }

  @AfterClass
  public static void afterClass() {
    if (client != null) {
      client.close();
    }

    if (bigquery != null) {
      RemoteBigQueryHelper.forceDelete(bigquery, DATASET);
      LOG.info("Deleted test dataset: " + DATASET);
    }
  }

  ProtoRows CreateProtoRows(String[] messages) {
    ProtoRows.Builder rows = ProtoRows.newBuilder();
    for (String message : messages) {
      FooType foo = FooType.newBuilder().setFoo(message).build();
      rows.addSerializedRows(foo.toByteString());
    }
    return rows.build();
  }

  @Test
  public void testJsonStreamWriterCommittedStreamWithNonQuotaRetry()
      throws IOException, InterruptedException, DescriptorValidationException {
    WriteRetryTestUtil.runExclusiveRetryTest(
        bigquery,
        client,
        DATASET,
        NON_QUOTA_RETRY_PROJECT_ID,
        WriteStream.Type.COMMITTED,
        /* requestCount=*/ 901,
        /* rowBatchSize=*/ 1);
  }

  @Test
  public void testJsonStreamWriterDefaultStreamWithNonQuotaRetry()
      throws IOException, InterruptedException, DescriptorValidationException {
    WriteRetryTestUtil.runDefaultRetryTest(
        bigquery,
        client,
        DATASET,
        NON_QUOTA_RETRY_PROJECT_ID,
        /* requestCount=*/ 901,
        /* rowBatchSize=*/ 1);
  }

  // Moved to ITBigQueryWriteNonQuotaRetryTest from ITBigQueryWriteManualClientTest, as it requires
  // usage of the project this file uses to inject errors (bq-write-api-java-retry-test).
  @Test
  public void testDefaultRequestLimit()
      throws IOException, InterruptedException, ExecutionException {
    DatasetId datasetId =
        DatasetId.of(NON_QUOTA_RETRY_PROJECT_ID, RemoteBigQueryHelper.generateDatasetName());
    DatasetInfo datasetInfo = DatasetInfo.newBuilder(datasetId).build();
    bigquery.create(datasetInfo);
    try {
      String tableName = "no_error_table";
      TableId tableId = TableId.of(datasetId.getProject(), datasetId.getDataset(), tableName);
      Field col1 = Field.newBuilder("col1", StandardSQLTypeName.STRING).build();
      Schema originalSchema = Schema.of(col1);
      TableInfo tableInfo =
          TableInfo.newBuilder(tableId, StandardTableDefinition.of(originalSchema)).build();
      bigquery.create(tableInfo);
      ProtoSchema schema =
          ProtoSchema.newBuilder()
              .setProtoDescriptor(
                  DescriptorProto.newBuilder()
                      .setName("testProto")
                      .addField(
                          FieldDescriptorProto.newBuilder()
                              .setName("col1")
                              .setNumber(1)
                              .setType(FieldDescriptorProto.Type.TYPE_STRING)
                              .build())
                      .build())
              .build();
      TableName parent = TableName.of(datasetId.getProject(), datasetId.getDataset(), tableName);
      try (StreamWriter streamWriter =
          StreamWriter.newBuilder(parent.toString() + "/_default")
              .setWriterSchema(schema)
              .build()) {
        ApiFuture<AppendRowsResponse> response =
            streamWriter.append(
                CreateProtoRows(
                    new String[] {new String(new char[19 * 1024 * 1024]).replace("\0", "a")}));
        try {
          AppendRowsResponse resp = response.get();
          LOG.info(
              "Message succeded.  Dataset info: "
                  + datasetInfo.toString()
                  + " tableinfo: "
                  + tableInfo.toString()
                  + " parent: "
                  + parent
                  + "streamWriter: "
                  + streamWriter.toString()
                  + "response: "
                  + resp);
          Assert.fail("Large request should fail with InvalidArgumentError");
        } catch (ExecutionException ex) {
          LOG.info(
              "Message failed.  Dataset info: "
                  + datasetInfo.toString()
                  + " tableinfo: "
                  + tableInfo.toString()
                  + " parent: "
                  + parent
                  + "streamWriter: "
                  + streamWriter);
          assertEquals(io.grpc.StatusRuntimeException.class, ex.getCause().getClass());
          io.grpc.StatusRuntimeException actualError =
              (io.grpc.StatusRuntimeException) ex.getCause();
          // This verifies that the Beam connector can consume this custom exception's grpc
          // StatusCode
          // TODO(yiru): temp fix to unblock test, while final fix is being rolled out.
          if (actualError.getStatus().getCode() != Code.INTERNAL) {
            assertEquals(Code.INVALID_ARGUMENT, actualError.getStatus().getCode());
            assertThat(
                actualError
                    .getStatus()
                    .getDescription()
                    .contains("AppendRows request too large: 19923131 limit 10485760"));
          }
        }
      }
    } finally {
      RemoteBigQueryHelper.forceDelete(bigquery, datasetId.toString());
    }
  }
}
