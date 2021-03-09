/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.storage.v1beta2.st;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.core.ApiFuture;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.storage.v1beta2.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1beta2.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1beta2.JsonStreamWriter;
import com.google.cloud.bigquery.storage.v1beta2.TableName;
import com.google.cloud.bigquery.storage.v1beta2.it.ITBigQueryStorageLongRunningTest;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.protobuf.Descriptors;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.threeten.bp.LocalDateTime;

public class ITBigQueryStorageLongRunningWriteTest {
  public enum RowComplexity {
    SIMPLE,
    COMPLEX
  }

  private static final Logger LOG =
      Logger.getLogger(ITBigQueryStorageLongRunningTest.class.getName());
  private static final String LONG_TESTS_ENABLED_PROPERTY =
      "bigquery.storage.enable_long_running_tests";
  private static final String DESCRIPTION = "BigQuery Write Java long test dataset";

  private static String dataset;
  private static BigQueryWriteClient client;
  private static String parentProjectId;
  private static BigQuery bigquery;

  private static JSONObject MakeJsonObject(RowComplexity complexity) throws IOException {
    JSONObject object = new JSONObject();
    // size: (1, simple)(2,complex)()
    // TODO(jstocklass): Add option for testing protobuf format using StreamWriter2
    switch (complexity) {
      case SIMPLE:
        object.put("test_str", "aaa");
        object.put("test_numerics", new JSONArray(new String[] {"1234", "-900000"}));
        object.put("test_datetime", String.valueOf(LocalDateTime.now()));
        break;
      case COMPLEX:
        // TODO(jstocklass): make a complex object
      default:
        break;
    }
    return object;
  }

  @BeforeClass
  public static void beforeClass() throws IOException {
    parentProjectId = String.format("projects/%s", ServiceOptions.getDefaultProjectId());

    client = BigQueryWriteClient.create();
    RemoteBigQueryHelper bigqueryHelper = RemoteBigQueryHelper.create();
    bigquery = bigqueryHelper.getOptions().getService();
    dataset = RemoteBigQueryHelper.generateDatasetName();
    DatasetInfo datasetInfo =
        DatasetInfo.newBuilder(/* datasetId = */ dataset).setDescription(DESCRIPTION).build();
    LOG.info("Creating dataset: " + dataset);
    bigquery.create(datasetInfo);
  }

  @AfterClass
  public static void afterClass() {
    if (client != null) {
      client.close();
    }
    if (bigquery != null && dataset != null) {
      RemoteBigQueryHelper.forceDelete(bigquery, dataset);
      LOG.info("Deleted test dataset: " + dataset);
    }
  }

  @Test
  public void testDefaultStreamSimpleSchema()
      throws IOException, InterruptedException, ExecutionException,
          Descriptors.DescriptorValidationException {
    // TODO(jstocklass): Set up a default stream. Write to it for a long time,
    // (a few minutes for now) and make sure that everything goes well, report stats.
    LOG.info(
        String.format(
            "%s tests running with parent project: %s",
            ITBigQueryStorageLongRunningWriteTest.class.getSimpleName(), parentProjectId));

    String tableName = "JsonSimpleTableDefaultStream";
    TableInfo tableInfo =
        TableInfo.newBuilder(
                TableId.of(dataset, tableName),
                StandardTableDefinition.of(
                    Schema.of(
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_str", StandardSQLTypeName.STRING)
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_numerics", StandardSQLTypeName.NUMERIC)
                            .setMode(Field.Mode.REPEATED)
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_datetime", StandardSQLTypeName.DATETIME)
                            .build())))
            .build();
    bigquery.create(tableInfo);

    int requestLimit = 10;
    long averageLatency = 0;
    long totalLatency = 0;
    TableName parent = TableName.of(ServiceOptions.getDefaultProjectId(), dataset, tableName);
    try (JsonStreamWriter jsonStreamWriter =
        JsonStreamWriter.newBuilder(parent.toString(), tableInfo.getDefinition().getSchema())
            .createDefaultStream()
            .build()) {
      for (int i = 0; i < requestLimit; i++) {
        JSONObject row = MakeJsonObject(RowComplexity.SIMPLE);
        JSONArray jsonArr = new JSONArray(new JSONObject[] {row});
        long startTime = System.nanoTime();
        // TODO(jstocklass): Make asynchronized calls instead of synchronized calls
        ApiFuture<AppendRowsResponse> response = jsonStreamWriter.append(jsonArr, -1);
        long finishTime = System.nanoTime();
        Assert.assertFalse(response.get().getAppendResult().hasOffset());
        // Ignore first entry, it is way slower than the others and ruins expected behavior
        if (i != 0) {
          totalLatency += (finishTime - startTime);
        }
      }
      averageLatency = totalLatency / requestLimit;
      // TODO(jstocklass): Is there a better way to get this than to log it?
      LOG.info("Simple average Latency: " + String.valueOf(averageLatency) + " ns");
      averageLatency = totalLatency = 0;

      TableResult result =
          bigquery.listTableData(
              tableInfo.getTableId(), BigQuery.TableDataListOption.startIndex(0L));
      Iterator<FieldValueList> iter = result.getValues().iterator();
      FieldValueList currentRow;
      for (int i = 0; i < requestLimit; i++) {
        assertTrue(iter.hasNext());
        currentRow = iter.next();
        assertEquals("aaa", currentRow.get(0).getStringValue());
      }
      assertEquals(false, iter.hasNext());
    }
  }
}
