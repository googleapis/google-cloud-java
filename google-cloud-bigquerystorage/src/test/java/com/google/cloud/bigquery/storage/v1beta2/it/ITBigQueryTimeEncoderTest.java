/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.storage.v1beta2.it;

import static org.junit.Assert.assertEquals;

import com.google.api.core.ApiFuture;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field.Mode;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.storage.v1beta2.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1beta2.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1beta2.CivilTimeEncoder;
import com.google.cloud.bigquery.storage.v1beta2.JsonStreamWriter;
import com.google.cloud.bigquery.storage.v1beta2.TableName;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.protobuf.Descriptors;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;

public class ITBigQueryTimeEncoderTest {
  private static final String DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String TABLE = "testtable";
  private static final String DESCRIPTION = "BigQuery Write Java manual client test dataset";

  private static BigQueryWriteClient client;
  private static TableInfo tableInfo;
  private static BigQuery bigquery;

  @BeforeClass
  public static void beforeClass() throws IOException {
    client = BigQueryWriteClient.create();

    RemoteBigQueryHelper bigqueryHelper = RemoteBigQueryHelper.create();
    bigquery = bigqueryHelper.getOptions().getService();
    DatasetInfo datasetInfo =
        DatasetInfo.newBuilder(/* datasetId = */ DATASET).setDescription(DESCRIPTION).build();
    bigquery.create(datasetInfo);
    tableInfo =
        TableInfo.newBuilder(
                TableId.of(DATASET, TABLE),
                StandardTableDefinition.of(
                    Schema.of(
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_str", StandardSQLTypeName.STRING)
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_time_micros", StandardSQLTypeName.TIME)
                            .setMode(Mode.REPEATED)
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_datetime_micros", StandardSQLTypeName.DATETIME)
                            .setMode(Mode.REPEATED)
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
    }
  }

  @Test
  public void TestTimeEncoding()
      throws IOException, InterruptedException, ExecutionException,
          Descriptors.DescriptorValidationException {
    TableName parent = TableName.of(ServiceOptions.getDefaultProjectId(), DATASET, TABLE);
    try (JsonStreamWriter jsonStreamWriter =
        JsonStreamWriter.newBuilder(parent.toString(), tableInfo.getDefinition().getSchema())
            .build()) {
      JSONObject row = new JSONObject();
      row.put("test_str", "Start of the day");
      row.put(
          "test_time_micros",
          new JSONArray(
              new long[] {
                CivilTimeEncoder.encodePacked64TimeMicros(LocalTime.of(13, 14, 15, 16_000_000)),
                CivilTimeEncoder.encodePacked64TimeMicros(LocalTime.of(23, 59, 59, 999_999_000)),
                CivilTimeEncoder.encodePacked64TimeMicros(LocalTime.of(0, 0, 0, 0)),
                CivilTimeEncoder.encodePacked64TimeMicros(LocalTime.of(1, 2, 3, 4_000)),
                CivilTimeEncoder.encodePacked64TimeMicros(LocalTime.of(5, 6, 7, 8_000))
              }));
      row.put(
          "test_datetime_micros",
          new JSONArray(
              new long[] {
                CivilTimeEncoder.encodePacked64DatetimeMicros(
                    LocalDateTime.of(1, 1, 1, 12, 0, 0, 0)),
                CivilTimeEncoder.encodePacked64DatetimeMicros(
                    LocalDateTime.of(1995, 5, 19, 10, 30, 45, 0)),
                CivilTimeEncoder.encodePacked64DatetimeMicros(
                    LocalDateTime.of(2000, 1, 1, 0, 0, 0, 0)),
                CivilTimeEncoder.encodePacked64DatetimeMicros(
                    LocalDateTime.of(2026, 3, 11, 5, 45, 12, 9_000_000)),
                CivilTimeEncoder.encodePacked64DatetimeMicros(
                    LocalDateTime.of(2050, 1, 2, 3, 4, 5, 6_000)),
              }));
      JSONArray jsonArr = new JSONArray(new JSONObject[] {row});
      ApiFuture<AppendRowsResponse> response = jsonStreamWriter.append(jsonArr, -1);
      Assert.assertFalse(response.get().getAppendResult().hasOffset());
      TableResult result =
          bigquery.listTableData(
              tableInfo.getTableId(), BigQuery.TableDataListOption.startIndex(0L));
      Iterator<FieldValueList> iter = result.getValues().iterator();
      FieldValueList currentRow;
      currentRow = iter.next();
      assertEquals("Start of the day", currentRow.get(0).getValue());
      assertEquals("13:14:15.016000", currentRow.get(1).getRepeatedValue().get(0).getStringValue());
      assertEquals("23:59:59.999999", currentRow.get(1).getRepeatedValue().get(1).getStringValue());
      assertEquals("00:00:00", currentRow.get(1).getRepeatedValue().get(2).getStringValue());
      assertEquals("01:02:03.000004", currentRow.get(1).getRepeatedValue().get(3).getStringValue());
      assertEquals("05:06:07.000008", currentRow.get(1).getRepeatedValue().get(4).getStringValue());

      assertEquals(
          "0001-01-01T12:00:00", currentRow.get(2).getRepeatedValue().get(0).getStringValue());
      assertEquals(
          "1995-05-19T10:30:45", currentRow.get(2).getRepeatedValue().get(1).getStringValue());
      assertEquals(
          "2000-01-01T00:00:00", currentRow.get(2).getRepeatedValue().get(2).getStringValue());
      assertEquals(
          "2026-03-11T05:45:12.009000",
          currentRow.get(2).getRepeatedValue().get(3).getStringValue());
      assertEquals(
          "2050-01-02T03:04:05.000006",
          currentRow.get(2).getRepeatedValue().get(4).getStringValue());
    }
  }
}
