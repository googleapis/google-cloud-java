/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigquery.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DataFormatOptions;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.protobuf.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ITHighPrecisionTimestamp {

  public static final String TEST_HIGH_PRECISION_TIMESTAMP_TABLE_NAME =
      "test_high_precision_timestamp";
  private static BigQuery bigquery;
  private static final String DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static TableId defaultTableId;
  public static final long TIMESTAMP_PICOSECOND_PRECISION = 12L;
  private static final Field TIMESTAMP_HIGH_PRECISION_FIELD_SCHEMA =
      Field.newBuilder("timestampHighPrecisionField", StandardSQLTypeName.TIMESTAMP)
          .setTimestampPrecision(TIMESTAMP_PICOSECOND_PRECISION)
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(TIMESTAMP_HIGH_PRECISION_FIELD_SCHEMA);

  private static final String TIMESTAMP1 = "2025-01-01T12:34:56.123456789123Z";
  private static final String TIMESTAMP2 = "1970-01-01T12:34:56.123456789123Z";
  private static final String TIMESTAMP3 = "2000-01-01T12:34:56.123456789123Z";

  @BeforeAll
  public static void beforeClass() {
    BigQueryOptions.Builder builder =
        BigQueryOptions.newBuilder()
            .setDataFormatOptions(
                DataFormatOptions.newBuilder()
                    .timestampFormatOptions(DataFormatOptions.TimestampFormatOptions.ISO8601_STRING)
                    .build());
    RemoteBigQueryHelper bigqueryHelper = RemoteBigQueryHelper.create(builder);
    bigquery = bigqueryHelper.getOptions().getService();

    // Create a new dataset
    DatasetInfo info = DatasetInfo.newBuilder(DATASET).build();
    bigquery.create(info);

    StandardTableDefinition tableDefinition =
        StandardTableDefinition.newBuilder().setSchema(TABLE_SCHEMA).build();
    defaultTableId = TableId.of(DATASET, TEST_HIGH_PRECISION_TIMESTAMP_TABLE_NAME);

    // Create a new table that can be re-used by the test cases
    Table createdTable = bigquery.create(TableInfo.of(defaultTableId, tableDefinition));
    assertNotNull(createdTable);

    // Populate with some starter data
    Map<String, Object> timestamp1 =
        Collections.singletonMap("timestampHighPrecisionField", TIMESTAMP1);
    Map<String, Object> timestamp2 =
        Collections.singletonMap("timestampHighPrecisionField", TIMESTAMP2);
    Map<String, Object> timestamp3 =
        Collections.singletonMap("timestampHighPrecisionField", TIMESTAMP3);
    InsertAllRequest request =
        InsertAllRequest.newBuilder(defaultTableId)
            .addRow(timestamp1)
            .addRow(timestamp2)
            .addRow(timestamp3)
            .build();
    InsertAllResponse response = bigquery.insertAll(request);
    assertFalse(response.hasErrors());
    assertEquals(0, response.getInsertErrors().size());
  }

  @AfterAll
  public static void afterClass() {
    if (bigquery != null) {
      bigquery.delete(defaultTableId);
      RemoteBigQueryHelper.forceDelete(bigquery, DATASET);
    }
  }

  private static String generateTempTableName() {
    return String.format(
        "insert_temp_%s%s",
        UUID.randomUUID().toString().substring(0, 6), TEST_HIGH_PRECISION_TIMESTAMP_TABLE_NAME);
  }

  @Test
  public void query_highPrecisionTimestamp() throws InterruptedException {
    String sql =
        String.format("SELECT timestampHighPrecisionField FROM %s;", defaultTableId.getTable());
    QueryJobConfiguration queryJobConfiguration =
        QueryJobConfiguration.newBuilder(sql)
            .setDefaultDataset(DatasetId.of(DATASET))
            .setUseLegacySql(false)
            .build();
    TableResult result = bigquery.query(queryJobConfiguration);
    assertNotNull(result.getJobId());
    String[] expected = new String[] {TIMESTAMP1, TIMESTAMP2, TIMESTAMP3};
    List<String> timestamps =
        StreamSupport.stream(result.getValues().spliterator(), false)
            .map(x -> (String) x.get(0).getValue())
            .collect(Collectors.toList());
    assertEquals(expected.length, timestamps.size());
    for (int i = 0; i < timestamps.size(); i++) {
      assertEquals(expected[i], timestamps.get(i));
    }
  }

  @Test
  public void insert_highPrecisionTimestamp_ISOValidFormat() {
    StandardTableDefinition tableDefinition =
        StandardTableDefinition.newBuilder().setSchema(TABLE_SCHEMA).build();
    String tempTableName = generateTempTableName();
    TableId tableId = TableId.of(DATASET, tempTableName);
    Table createdTable = bigquery.create(TableInfo.of(tableId, tableDefinition));
    assertNotNull(createdTable);

    Map<String, Object> timestampISO =
        Collections.singletonMap("timestampHighPrecisionField", "2025-01-01T12:34:56.123456Z");
    InsertAllRequest request = InsertAllRequest.newBuilder(tableId).addRow(timestampISO).build();
    InsertAllResponse response = bigquery.insertAll(request);
    assertFalse(response.hasErrors());
    assertEquals(0, response.getInsertErrors().size());

    bigquery.delete(tableId);
  }

  @Test
  public void insert_highPrecisionTimestamp_invalidFormats() {
    StandardTableDefinition tableDefinition =
        StandardTableDefinition.newBuilder().setSchema(TABLE_SCHEMA).build();
    String tempTable = generateTempTableName();
    TableId tableId = TableId.of(DATASET, tempTable);
    Table createdTable = bigquery.create(TableInfo.of(tableId, tableDefinition));
    assertNotNull(createdTable);

    Map<String, Object> timestampInMicros =
        Collections.singletonMap("timestampHighPrecisionField", 123456);
    Map<String, Object> timestampInMicrosString =
        Collections.singletonMap("timestampHighPrecisionField", "123456");
    Map<String, Object> timestampNegative =
        Collections.singletonMap("timestampHighPrecisionField", -123456);
    Map<String, Object> timestampFloat =
        Collections.singletonMap("timestampHighPrecisionField", 1000.0);
    Map<String, Object> timestampProtobuf =
        Collections.singletonMap(
            "timestampHighPrecisionField",
            Timestamp.newBuilder().setSeconds(123456789).setNanos(123456789).build());
    Map<String, Object> timestampProtobufNegative =
        Collections.singletonMap(
            "timestampHighPrecisionField",
            Timestamp.newBuilder().setSeconds(-123456789).setNanos(-123456789).build());
    InsertAllRequest request =
        InsertAllRequest.newBuilder(tableId)
            .addRow(timestampInMicros)
            .addRow(timestampInMicrosString)
            .addRow(timestampNegative)
            .addRow(timestampFloat)
            .addRow(timestampProtobuf)
            .addRow(timestampProtobufNegative)
            .build();
    InsertAllResponse response = bigquery.insertAll(request);
    assertTrue(response.hasErrors());
    assertEquals(request.getRows().size(), response.getInsertErrors().size());

    bigquery.delete(tableId);
  }

  @Test
  public void queryNamedParameter_highPrecisionTimestamp() throws InterruptedException {
    String query =
        String.format(
            "SELECT * FROM %s.%s WHERE timestampHighPrecisionField >= CAST(@timestampParam AS TIMESTAMP(12))",
            DATASET, defaultTableId.getTable());

    QueryJobConfiguration queryConfig =
        QueryJobConfiguration.newBuilder(query)
            .setDefaultDataset(DATASET)
            .setUseLegacySql(false)
            .addNamedParameter(
                "timestampParam",
                QueryParameterValue.timestamp("2000-01-01 12:34:56.123456789123Z"))
            .build();

    TableResult result = bigquery.query(queryConfig);
    assertNotNull(result);
    String[] expected = new String[] {TIMESTAMP1, TIMESTAMP3};
    List<String> timestamps =
        StreamSupport.stream(result.getValues().spliterator(), false)
            .map(x -> (String) x.get(0).getValue())
            .collect(Collectors.toList());
    assertEquals(expected.length, timestamps.size());
    for (int i = 0; i < timestamps.size(); i++) {
      assertEquals(expected[i], timestamps.get(i));
    }
  }

  @Test
  public void queryNamedParameter_highPrecisionTimestamp_microsLong() throws InterruptedException {
    String query =
        String.format(
            "SELECT * FROM %s.%s WHERE timestampHighPrecisionField >= CAST(@timestampParam AS TIMESTAMP(12))",
            DATASET, defaultTableId.getTable());

    QueryJobConfiguration queryConfig =
        QueryJobConfiguration.newBuilder(query)
            .setDefaultDataset(DATASET)
            .setUseLegacySql(false)
            .addNamedParameter(
                "timestampParam",
                QueryParameterValue.timestamp(
                    946730096123456L)) // micros for 2000-01-01 12:34:56.123456Z
            .build();

    TableResult result = bigquery.query(queryConfig);
    assertNotNull(result);
    // Exact timestamp for TIMESTAMP3 is `2000-01-01T12:34:56.123456789123Z` and for the micros
    // is `2000-01-01T12:34:56.123456Z`. The micros value gets cast to 12 digits of precision, so
    // it becomes `2000-01-01T12:34:56.123456000000Z`. We do expect it as part of the query.
    String[] expected = new String[] {TIMESTAMP1, TIMESTAMP3};
    List<String> timestamps =
        StreamSupport.stream(result.getValues().spliterator(), false)
            .map(x -> (String) x.get(0).getValue())
            .collect(Collectors.toList());
    assertEquals(expected.length, timestamps.size());
    for (int i = 0; i < timestamps.size(); i++) {
      assertEquals(expected[i], timestamps.get(i));
    }
  }

  @Test
  public void queryNamedParameter_highPrecisionTimestamp_microsISOString()
      throws InterruptedException {
    String query =
        String.format(
            "SELECT * FROM %s.%s WHERE timestampHighPrecisionField >= CAST(@timestampParam AS TIMESTAMP(12))",
            DATASET, defaultTableId.getTable());

    QueryJobConfiguration queryConfig =
        QueryJobConfiguration.newBuilder(query)
            .setDefaultDataset(DATASET)
            .setUseLegacySql(false)
            .addNamedParameter(
                "timestampParam", QueryParameterValue.timestamp("2000-01-01 12:34:56.123456Z"))
            .build();

    TableResult result = bigquery.query(queryConfig);
    assertNotNull(result);
    List<String> timestamps =
        StreamSupport.stream(result.getValues().spliterator(), false)
            .map(x -> (String) x.get(0).getValue())
            .collect(Collectors.toList());
    String[] expected = new String[] {TIMESTAMP1, TIMESTAMP3};
    assertEquals(expected.length, timestamps.size());
    for (int i = 0; i < timestamps.size(); i++) {
      assertEquals(expected[i], timestamps.get(i));
    }
  }

  @Test
  public void queryNamedParameter_highPrecisionTimestamp_noExplicitCastInQuery_fails() {
    String query =
        String.format(
            "SELECT * FROM %s.%s WHERE timestampHighPrecisionField >= @timestampParam",
            DATASET, defaultTableId.getTable());

    QueryJobConfiguration queryConfig =
        QueryJobConfiguration.newBuilder(query)
            .setDefaultDataset(DATASET)
            .setUseLegacySql(false)
            .addNamedParameter(
                "timestampParam", QueryParameterValue.timestamp("2000-01-01 12:34:56.123456789123"))
            .build();

    BigQueryException exception =
        assertThrows(BigQueryException.class, () -> bigquery.query(queryConfig));
    assertEquals("Invalid argument type passed to a function", exception.getMessage());
  }
}
