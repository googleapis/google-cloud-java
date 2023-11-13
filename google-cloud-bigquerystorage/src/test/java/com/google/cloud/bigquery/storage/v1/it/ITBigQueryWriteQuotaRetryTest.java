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

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import java.io.IOException;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/** Integration tests for BigQuery Write API. */
public class ITBigQueryWriteQuotaRetryTest {
  private static final Logger LOG = Logger.getLogger(ITBigQueryWriteQuotaRetryTest.class.getName());
  private static final String DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String TABLE = "testtable";
  private static final String DESCRIPTION = "BigQuery Write Java manual client test dataset";
  // This project is configured on the server to inject RESOURCE_EXHAUSTED in-stream errors every
  // 10 messages.  This is done to verify in-stream message retries.
  private static final String QUOTA_RETRY_PROJECT_ID = "bq-writeapi-java-quota-retry";
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

  @Test
  public void testJsonStreamWriterCommittedStreamWithQuotaRetry()
      throws IOException, InterruptedException, DescriptorValidationException {
    WriteRetryTestUtil.runExclusiveRetryTest(
        bigquery,
        client,
        DATASET,
        QUOTA_RETRY_PROJECT_ID,
        WriteStream.Type.COMMITTED,
        /* requestCount=*/ 901,
        /* rowBatchSize=*/ 1);
  }

  @Test
  public void testJsonStreamWriterDefaultStreamWithQuotaRetry()
      throws IOException, InterruptedException, DescriptorValidationException {
    WriteRetryTestUtil.runDefaultRetryTest(
        bigquery,
        client,
        DATASET,
        QUOTA_RETRY_PROJECT_ID,
        /* requestCount=*/ 901,
        /* rowBatchSize=*/ 1);
  }
}
