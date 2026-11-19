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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.services.bigquery.model.QueryParameter;
import com.google.api.services.bigquery.model.QueryParameterType;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.ConnectionProperty;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldElementType;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics.StatementType;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.jdbc.telemetry.v1.QueryApiType;
import com.google.cloud.bigquery.jdbc.telemetry.v1.StatementExecution;
import com.google.cloud.bigquery.jdbc.telemetry.v1.TelemetryManager;
import com.google.cloud.bigquery.storage.v1.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1.BQTableSchemaToProtoDescriptor;
import com.google.cloud.bigquery.storage.v1.BatchCommitWriteStreamsRequest;
import com.google.cloud.bigquery.storage.v1.BatchCommitWriteStreamsResponse;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1.FinalizeWriteStreamResponse;
import com.google.cloud.bigquery.storage.v1.JsonStreamWriter;
import com.google.cloud.bigquery.storage.v1.JsonToProtoMessage;
import com.google.cloud.bigquery.storage.v1.TableFieldSchema;
import com.google.cloud.bigquery.storage.v1.TableSchema;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Int64Value;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.stream.Stream;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.MockedStatic;

public class BigQueryPreparedStatementWriteApiTest {

  private BigQueryConnection connection;
  private BigQuery bigQuery;

  @BeforeEach
  public void setUp() {
    connection = mock(BigQueryConnection.class);
    bigQuery = mock(BigQuery.class);
    doReturn(bigQuery).when(connection).getBigQuery();
    doReturn("SQL").when(connection).getQueryDialect();
    doReturn("test-conn-id").when(connection).getConnectionId();
    doReturn(BigQueryConnection.SessionState.empty()).when(connection).getSessionStateSnapshot();
    doReturn(true).when(connection).isEnableWriteAPI();
    doReturn(3).when(connection).getWriteAPIActivationRowCount();
    doReturn(1000).when(connection).getWriteAPIAppendRowCount();
  }

  private static QueryParameter queryParam(String typeName) {
    return new QueryParameter().setParameterType(new QueryParameterType().setType(typeName));
  }

  private Job mockInsertDryRunJob(TableId tableId, Schema schema, List<QueryParameter> parameters) {
    Job dryRunJob = mock(Job.class);
    QueryStatistics stats = mock(QueryStatistics.class);
    doReturn(StatementType.INSERT).when(stats).getStatementType();
    doReturn(schema).when(stats).getSchema();
    doReturn(Collections.singletonList(tableId)).when(stats).getReferencedTables();
    doReturn(parameters).when(stats).getQueryParameters();
    doReturn(stats).when(dryRunJob).getStatistics();
    return dryRunJob;
  }

  @FunctionalInterface
  private interface BatchRowBinder {
    void bindRow(int rowIndex) throws SQLException;
  }

  private static void populateBatchAndAssertWriteApi(
      BigQueryPreparedStatement ps, int rows, BatchRowBinder binder, boolean expectedUseWriteApi)
      throws SQLException {
    ps.clearBatch();
    for (int i = 0; i < rows; i++) {
      binder.bindRow(i);
      ps.addBatch();
    }
    assertEquals(expectedUseWriteApi, ps.useWriteAPI());
  }

  private BigQueryPreparedStatement newWriteApiPreparedStatement(
      String sql, JsonStreamWriter mockJsonStreamWriter) throws SQLException {
    return new BigQueryPreparedStatement(connection, sql) {
      @Override
      BigQueryJdbcBulkInsertWriter createBulkInsertWriter() {
        return new BigQueryJdbcBulkInsertWriter() {
          @Override
          JsonStreamWriter buildJsonStreamWriter(JsonStreamWriter.Builder builder) {
            return mockJsonStreamWriter;
          }
        };
      }
    };
  }

  static Stream<Arguments> validDirectInsertQueries() {
    return Stream.of(
        Arguments.of("INSERT INTO TAB VALUES (?)", 1, null),
        Arguments.of(
            "insert tab (TARG_FIELD) values (?);", 1, Collections.singletonList("TARG_FIELD")),
        Arguments.of(
            "/* header */ INSERT INTO `my-proj.my_ds.TAB` (`col_b`, col_a) -- comment\n"
                + "VALUES ( ? , ? ) ; # trailing",
            2,
            Arrays.asList("col_b", "col_a")),
        Arguments.of(
            "INSERT INTO proj:ds.tab (c1) -- mac line ending\rVALUES (?)",
            1,
            Collections.singletonList("c1")),
        Arguments.of(
            "INSERT INTO `my\\`tab` (`col\\\\1`, `col\\`2`) VALUES (?, ?)",
            2,
            Arrays.asList("col\\1", "col`2")));
  }

  @ParameterizedTest
  @MethodSource("validDirectInsertQueries")
  public void testParseDirectInsertValuesAcceptsValidForms(
      String sql, int expectedPlaceholders, List<String> expectedColumns) {
    BigQueryPreparedStatement.DirectInsertShape shape =
        BigQueryPreparedStatement.parseDirectInsertValues(sql);
    assertNotNull(shape);
    assertEquals(expectedPlaceholders, shape.placeholderCount);
    assertEquals(expectedColumns, shape.columnNames);
  }

  @ParameterizedTest
  @ValueSource(
      strings = {
        "",
        "   ",
        "SELECT ?",
        "UPDATE TAB SET a = ? WHERE b = ?",
        "MERGE INTO TAB USING (SELECT ? AS v) ON FALSE WHEN NOT MATCHED THEN INSERT (a) VALUES (v)",
        "INSERT INTO TAB (TARG_FIELD) VALUES (UDF(CAST(? AS STRING), 'XXXXXX'));",
        "INSERT INTO TAB (a) VALUES (CAST(? AS BYTES))",
        "INSERT INTO TAB (a) VALUES (UPPER(?))",
        "INSERT INTO TAB (a) VALUES (? + 1)",
        "INSERT INTO TAB (a) VALUES (-?)",
        "INSERT INTO TAB (a) VALUES ((?))",
        "INSERT INTO TAB (a, b) VALUES (?, 'constant')",
        "INSERT INTO TAB (a, b) VALUES (?, DEFAULT)",
        "INSERT INTO TAB (a, b) VALUES (?, NULL)",
        "INSERT INTO TAB (a) VALUES (?), (?)",
        "INSERT INTO TAB (a) SELECT a FROM TAB WHERE a = ?",
        "INSERT INTO _SESSION.temp_tab (a) VALUES (?)",
        "INSERT INTO `_SESSION.temp_tab` (a) VALUES (?)",
        "INSERT INTO `\\u005fSESSION.temp_tab` (a) VALUES (?)",
        "INSERT INTO TAB () VALUES (?)",
        "INSERT INTO TAB (s.a) VALUES (?)",
        "INSERT INTO TAB (`bad\\nescape`) VALUES (?)",
        "INSERT INTO TAB (a) VALUES (?); INSERT INTO TAB (a) VALUES (?)",
        "/* unclosed comment INSERT INTO TAB VALUES (?)"
      })
  public void testParseDirectInsertValuesRejectsIneligibleSql(String sql) {
    assertNull(BigQueryPreparedStatement.parseDirectInsertValues(sql));
  }

  @Test
  public void testParseDirectInsertValuesAndConstructorRejectNullQuery() {
    assertNull(BigQueryPreparedStatement.parseDirectInsertValues(null));
    assertThrows(
        BigQueryJdbcException.class, () -> new BigQueryPreparedStatement(connection, null));
  }

  @Test
  public void testSameTypeStringUdfExpressionInValuesFallsBackToStandardSqlBatch()
      throws Exception {
    String sql = "INSERT INTO TAB (STR_FIELD) VALUES (MASK_UDF(?));";
    Schema tableSchema = Schema.of(Field.of("STR_FIELD", StandardSQLTypeName.STRING));
    Job dryRunJob =
        mockInsertDryRunJob(
            TableId.of("proj", "ds", "TAB"),
            tableSchema,
            Collections.singletonList(queryParam("STRING")));
    doReturn(dryRunJob).when(bigQuery).create(any(JobInfo.class));

    TableResult dmlResult = mock(TableResult.class);
    doReturn(StatementType.INSERT).when(dmlResult).getStatementType();
    doReturn(1L).when(dmlResult).getNumDmlAffectedRows();
    doReturn(dmlResult).when(bigQuery).queryWithTimeout(any(), any(), any());

    BigQueryPreparedStatement ps = new BigQueryPreparedStatement(connection, sql);
    assertNull(ps.insertSchema);

    for (int i = 0; i < 3; i++) {
      ps.setString(1, "secret-" + i);
      ps.addBatch();
    }

    assertFalse(ps.useWriteAPI());

    int[] counts = ps.executeBatch();
    assertEquals(3, counts.length);
    verify(connection, never()).getBigQueryWriteClient();
    verify(bigQuery, times(1)).create(any(JobInfo.class));

    ArgumentCaptor<QueryJobConfiguration> jobCaptor =
        ArgumentCaptor.forClass(QueryJobConfiguration.class);
    verify(bigQuery).queryWithTimeout(jobCaptor.capture(), any(), any());
    QueryJobConfiguration executedConfig = jobCaptor.getValue();
    assertTrue(executedConfig.getQuery().contains("MASK_UDF(?)"));
    assertEquals(3, executedConfig.getPositionalParameters().size());
    assertEquals("secret-0", executedConfig.getPositionalParameters().get(0).getValue());
    assertEquals("secret-1", executedConfig.getPositionalParameters().get(1).getValue());
    assertEquals("secret-2", executedConfig.getPositionalParameters().get(2).getValue());
  }

  @Test
  public void testUdfExpressionInValuesFallsBackToStandardSqlBatch() throws Exception {
    String sql = "INSERT INTO TAB (TARG_FIELD) VALUES (UDF(CAST(? AS STRING), 'XXXXXX'));";
    Schema tableSchema = Schema.of(Field.of("TARG_FIELD", StandardSQLTypeName.BYTES));
    Job dryRunJob =
        mockInsertDryRunJob(
            TableId.of("proj", "ds", "TAB"),
            tableSchema,
            Collections.singletonList(queryParam("STRING")));
    doReturn(dryRunJob).when(bigQuery).create(any(JobInfo.class));

    TableResult dmlResult = mock(TableResult.class);
    doReturn(StatementType.INSERT).when(dmlResult).getStatementType();
    doReturn(1L).when(dmlResult).getNumDmlAffectedRows();
    doReturn(dmlResult).when(bigQuery).queryWithTimeout(any(), any(), any());

    BigQueryPreparedStatement ps = new BigQueryPreparedStatement(connection, sql);
    assertNull(ps.insertSchema);

    ps.setString(1, "plaintext-1");
    ps.addBatch();
    ps.setString(1, "plaintext-2");
    ps.addBatch();
    ps.setString(1, "plaintext-3");
    ps.addBatch();

    assertFalse(ps.useWriteAPI());

    int[] counts = ps.executeBatch();
    assertEquals(3, counts.length);
    verify(connection, never()).getBigQueryWriteClient();
    // Constructor ran one dry run; executeBatch must NOT fire a second wasted dry run.
    verify(bigQuery, times(1)).create(any(JobInfo.class));

    ArgumentCaptor<QueryJobConfiguration> jobCaptor =
        ArgumentCaptor.forClass(QueryJobConfiguration.class);
    verify(bigQuery).queryWithTimeout(jobCaptor.capture(), any(), any());
    QueryJobConfiguration executedConfig = jobCaptor.getValue();
    assertTrue(executedConfig.getQuery().contains("UDF(CAST(? AS STRING), 'XXXXXX')"));
    assertEquals(3, executedConfig.getPositionalParameters().size());
    assertEquals("plaintext-1", executedConfig.getPositionalParameters().get(0).getValue());
    assertEquals("plaintext-2", executedConfig.getPositionalParameters().get(1).getValue());
    assertEquals("plaintext-3", executedConfig.getPositionalParameters().get(2).getValue());
  }

  @Test
  public void testResolveInsertSchemaMapsReorderedColumnsAndRejectsSubsetsOrDuplicates() {
    Schema tableSchema =
        Schema.of(
            Field.of("col_a", StandardSQLTypeName.STRING),
            Field.of("col_b", StandardSQLTypeName.INT64));

    BigQueryPreparedStatement.DirectInsertShape reordered =
        BigQueryPreparedStatement.parseDirectInsertValues(
            "INSERT INTO TAB (COL_B, col_a) VALUES (?, ?)");
    Schema resolved = BigQueryPreparedStatement.resolveInsertSchema(tableSchema, reordered, 2);
    assertNotNull(resolved);
    assertEquals("col_b", resolved.getFields().get(0).getName());
    assertEquals("col_a", resolved.getFields().get(1).getName());

    // Partial column list must return null so DDL DEFAULT expressions run on BigQuery's SQL engine.
    BigQueryPreparedStatement.DirectInsertShape subset =
        BigQueryPreparedStatement.parseDirectInsertValues("INSERT INTO TAB (col_b) VALUES (?)");
    assertNull(BigQueryPreparedStatement.resolveInsertSchema(tableSchema, subset, 1));

    // Duplicate column names and unknown/pseudo columns must return null.
    BigQueryPreparedStatement.DirectInsertShape duplicate =
        BigQueryPreparedStatement.parseDirectInsertValues(
            "INSERT INTO TAB (col_a, COL_A) VALUES (?, ?)");
    assertNull(BigQueryPreparedStatement.resolveInsertSchema(tableSchema, duplicate, 2));

    BigQueryPreparedStatement.DirectInsertShape unknown =
        BigQueryPreparedStatement.parseDirectInsertValues(
            "INSERT INTO TAB (col_a, _PARTITIONTIME) VALUES (?, ?)");
    assertNull(BigQueryPreparedStatement.resolveInsertSchema(tableSchema, unknown, 2));
  }

  @ParameterizedTest
  @ValueSource(
      strings = {
        "STRING",
        "BYTES",
        "INT64",
        "FLOAT64",
        "NUMERIC",
        "BIGNUMERIC",
        "BOOL",
        "DATE",
        "TIME",
        "DATETIME",
        "TIMESTAMP",
        "JSON",
        "GEOGRAPHY",
        "INTERVAL"
      })
  public void testResolveInsertSchemaAcceptsSupportedScalarTemporalAndSpecialTypes(
      String typeName) {
    Schema schema = Schema.of(Field.of("c1", StandardSQLTypeName.valueOf(typeName)));
    BigQueryPreparedStatement.DirectInsertShape shape =
        BigQueryPreparedStatement.parseDirectInsertValues("INSERT INTO TAB (c1) VALUES (?)");
    assertNotNull(BigQueryPreparedStatement.resolveInsertSchema(schema, shape, 1));
  }

  @Test
  public void testResolveInsertSchemaRejectsRangeRepeatedAndStructFields() {
    Schema repeatedSchema =
        Schema.of(
            Field.newBuilder("arr", StandardSQLTypeName.STRING)
                .setMode(Field.Mode.REPEATED)
                .build());
    BigQueryPreparedStatement.DirectInsertShape shape =
        BigQueryPreparedStatement.parseDirectInsertValues("INSERT INTO TAB VALUES (?)");
    assertNull(BigQueryPreparedStatement.resolveInsertSchema(repeatedSchema, shape, 1));

    Schema structSchema =
        Schema.of(
            Field.of(
                "rec", StandardSQLTypeName.STRUCT, Field.of("sub", StandardSQLTypeName.INT64)));
    assertNull(BigQueryPreparedStatement.resolveInsertSchema(structSchema, shape, 1));

    Schema rangeSchema =
        Schema.of(
            Field.newBuilder("rng", StandardSQLTypeName.RANGE)
                .setRangeElementType(FieldElementType.newBuilder().setType("DATE").build())
                .build());
    assertNull(BigQueryPreparedStatement.resolveInsertSchema(rangeSchema, shape, 1));
  }

  @Test
  public void testCreateJsonRowEncodesBytesFloatAndBigDecimalAccurately() throws Exception {
    Schema schema =
        Schema.of(
            Field.of("b_col", StandardSQLTypeName.BYTES),
            Field.of("f_col", StandardSQLTypeName.FLOAT64),
            Field.of("n_zero", StandardSQLTypeName.NUMERIC),
            Field.of("n_val", StandardSQLTypeName.NUMERIC),
            Field.of("bool_col", StandardSQLTypeName.BOOL));
    Job dryRunJob =
        mockInsertDryRunJob(
            TableId.of("proj", "ds", "TAB"),
            schema,
            Arrays.asList(
                queryParam("BYTES"),
                queryParam("FLOAT64"),
                queryParam("NUMERIC"),
                queryParam("NUMERIC"),
                queryParam("BOOL")));
    doReturn(dryRunJob).when(bigQuery).create(any(JobInfo.class));

    BigQueryPreparedStatement ps =
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?, ?, ?, ?, ?)");
    byte[] rawBytes = new byte[] {-128, 0, 127};
    ps.setBytes(1, rawBytes);
    ps.setFloat(2, 0.6f);
    // Extreme negative scale zero must format in O(1) without allocating 100M zeros.
    ps.setBigDecimal(3, BigDecimal.valueOf(0, -100_000_000));
    ps.setBigDecimal(4, new BigDecimal("123.4500"));
    ps.setBoolean(5, true);

    JsonObject row =
        BigQueryPreparedStatement.createJsonRow(
            schema.getFields(), ps.parameterHandler.parametersList, false);

    JsonArray encodedBytes = row.getAsJsonArray("b_col");
    assertEquals(3, encodedBytes.size());
    assertEquals(-128, encodedBytes.get(0).getAsByte());
    assertEquals(0, encodedBytes.get(1).getAsByte());
    assertEquals(127, encodedBytes.get(2).getAsByte());
    assertEquals(Double.toString(((Float) 0.6f).doubleValue()), row.get("f_col").getAsString());
    assertEquals("0", row.get("n_zero").getAsString());
    assertEquals("123.45", row.get("n_val").getAsString());
    assertTrue(row.get("bool_col").getAsBoolean());
  }

  @Test
  public void testTemporalCreateJsonRowAndProtoConversionAcrossLocalesAndZones() throws Exception {
    Schema schema =
        Schema.of(
            Field.of("d_sql", StandardSQLTypeName.DATE),
            Field.of("d_local", StandardSQLTypeName.DATE),
            Field.of("t_sql", StandardSQLTypeName.TIME),
            Field.of("t_local", StandardSQLTypeName.TIME),
            Field.of("dt_col", StandardSQLTypeName.DATETIME),
            Field.of("ts_sql", StandardSQLTypeName.TIMESTAMP),
            Field.of("ts_inst", StandardSQLTypeName.TIMESTAMP),
            Field.of("ts_odt", StandardSQLTypeName.TIMESTAMP),
            Field.of("ts_zdt", StandardSQLTypeName.TIMESTAMP),
            Field.newBuilder("ts_picos", StandardSQLTypeName.TIMESTAMP)
                .setTimestampPrecision(12L)
                .build());
    Job dryRunJob =
        mockInsertDryRunJob(
            TableId.of("proj", "ds", "TAB"),
            schema,
            Arrays.asList(
                queryParam("DATE"),
                queryParam("DATE"),
                queryParam("TIME"),
                queryParam("TIME"),
                queryParam("STRING"),
                queryParam("TIMESTAMP"),
                queryParam("TIMESTAMP"),
                queryParam("TIMESTAMP"),
                queryParam("TIMESTAMP"),
                queryParam("TIMESTAMP")));
    doReturn(dryRunJob).when(bigQuery).create(any(JobInfo.class));

    TableSchema protoTableSchema =
        TableSchema.newBuilder()
            .addFields(
                TableFieldSchema.newBuilder()
                    .setName("d_sql")
                    .setType(TableFieldSchema.Type.DATE)
                    .setMode(TableFieldSchema.Mode.NULLABLE)
                    .build())
            .addFields(
                TableFieldSchema.newBuilder()
                    .setName("d_local")
                    .setType(TableFieldSchema.Type.DATE)
                    .setMode(TableFieldSchema.Mode.NULLABLE)
                    .build())
            .addFields(
                TableFieldSchema.newBuilder()
                    .setName("t_sql")
                    .setType(TableFieldSchema.Type.TIME)
                    .setMode(TableFieldSchema.Mode.NULLABLE)
                    .build())
            .addFields(
                TableFieldSchema.newBuilder()
                    .setName("t_local")
                    .setType(TableFieldSchema.Type.TIME)
                    .setMode(TableFieldSchema.Mode.NULLABLE)
                    .build())
            .addFields(
                TableFieldSchema.newBuilder()
                    .setName("dt_col")
                    .setType(TableFieldSchema.Type.DATETIME)
                    .setMode(TableFieldSchema.Mode.NULLABLE)
                    .build())
            .addFields(
                TableFieldSchema.newBuilder()
                    .setName("ts_sql")
                    .setType(TableFieldSchema.Type.TIMESTAMP)
                    .setMode(TableFieldSchema.Mode.NULLABLE)
                    .build())
            .addFields(
                TableFieldSchema.newBuilder()
                    .setName("ts_inst")
                    .setType(TableFieldSchema.Type.TIMESTAMP)
                    .setMode(TableFieldSchema.Mode.NULLABLE)
                    .build())
            .addFields(
                TableFieldSchema.newBuilder()
                    .setName("ts_odt")
                    .setType(TableFieldSchema.Type.TIMESTAMP)
                    .setMode(TableFieldSchema.Mode.NULLABLE)
                    .build())
            .addFields(
                TableFieldSchema.newBuilder()
                    .setName("ts_zdt")
                    .setType(TableFieldSchema.Type.TIMESTAMP)
                    .setMode(TableFieldSchema.Mode.NULLABLE)
                    .build())
            .addFields(
                TableFieldSchema.newBuilder()
                    .setName("ts_picos")
                    .setType(TableFieldSchema.Type.TIMESTAMP)
                    .setMode(TableFieldSchema.Mode.NULLABLE)
                    .setTimestampPrecision(Int64Value.of(12))
                    .build())
            .build();
    Descriptor descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(protoTableSchema);

    Locale originalLocale = Locale.getDefault();
    TimeZone originalZone = TimeZone.getDefault();
    try {
      for (Locale locale : Arrays.asList(Locale.US, Locale.FRANCE, Locale.GERMANY, Locale.JAPAN)) {
        for (String zoneId : Arrays.asList("UTC", "America/New_York", "Asia/Tokyo")) {
          Locale.setDefault(locale);
          TimeZone.setDefault(TimeZone.getTimeZone(zoneId));

          for (boolean picos : new boolean[] {false, true}) {
            doReturn(picos).when(connection).isEnableTimestampPicos();
            BigQueryPreparedStatement ps =
                new BigQueryPreparedStatement(
                    connection, "INSERT INTO TAB VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            Date sqlDate = Date.valueOf("2026-11-18");
            LocalDate localDate = LocalDate.of(1969, 7, 20);
            Time sqlTime = Time.valueOf("14:39:36");
            LocalTime localTime = LocalTime.of(12, 34, 56, 789_123_000);
            LocalDateTime localDateTime = LocalDateTime.of(2025, 12, 3, 12, 30, 0, 123_456_000);
            Timestamp sqlTimestamp =
                Timestamp.from(Instant.parse("2026-11-18T19:39:36.123456789Z"));
            Instant preEpochInstant = Instant.parse("1969-07-20T20:17:40.123456Z");
            OffsetDateTime odt = OffsetDateTime.parse("2026-11-18T14:39:36.123456-05:00");
            ZonedDateTime zdt =
                ZonedDateTime.of(
                    2026, 11, 18, 14, 39, 36, 123_456_000, ZoneId.of("America/New_York"));
            Timestamp picosTs = Timestamp.from(Instant.parse("2026-11-18T19:39:36.123456789Z"));

            for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
              ps.setDate(1, sqlDate);
              ps.setObject(2, localDate);
              ps.setTime(3, sqlTime);
              ps.setObject(4, localTime);
              ps.setObject(5, localDateTime);
              ps.setTimestamp(6, sqlTimestamp);
              ps.setObject(7, preEpochInstant);
              ps.setObject(8, odt);
              ps.setObject(9, zdt);
              ps.setTimestamp(10, picosTs);
              ps.addBatch();
            }

            assertTrue(ps.useWriteAPI());

            JsonObject row =
                BigQueryPreparedStatement.createJsonRow(
                    schema.getFields(), ps.parameterHandler.parametersList, picos);

            assertEquals("2026-11-18", row.get("d_sql").getAsString());
            assertEquals("1969-07-20", row.get("d_local").getAsString());
            assertEquals("14:39:36.000000", row.get("t_sql").getAsString());
            assertEquals("12:34:56.789123", row.get("t_local").getAsString());
            assertEquals("2025-12-03 12:30:00.123456", row.get("dt_col").getAsString());
            assertEquals("2026-11-18 19:39:36.123456Z", row.get("ts_sql").getAsString());
            assertEquals("1969-07-20 20:17:40.123456Z", row.get("ts_inst").getAsString());
            assertEquals("2026-11-18 19:39:36.123456Z", row.get("ts_odt").getAsString());
            assertEquals("2026-11-18 19:39:36.123456Z", row.get("ts_zdt").getAsString());
            assertEquals(
                picos ? "2026-11-18 19:39:36.123456789000Z" : "2026-11-18 19:39:36.123456Z",
                row.get("ts_picos").getAsString());
            // Door 1 (QueryParameterValue.timestamp) and Door 2 accept the exact same wire format.
            assertEquals(
                row.get("ts_picos").getAsString(),
                QueryParameterValue.timestamp(row.get("ts_picos").getAsString()).getValue());
            for (int colIdx = 0; colIdx < 9; colIdx++) {
              String fieldName = schema.getFields().get(colIdx).getName();
              QueryParameterValue door1Value =
                  BigQueryParameterHandler.toQueryParameterValue(
                      ps.parameterHandler.parametersList.get(colIdx), false);
              assertEquals(door1Value.getValue(), row.get(fieldName).getAsString());
            }

            DynamicMessage protoMsg =
                JsonToProtoMessage.INSTANCE.convertToProtoMessage(
                    descriptor, protoTableSchema, new JSONObject(row.toString()));
            assertNotNull(protoMsg);
            long expectedTsMicros =
                ChronoUnit.MICROS.between(
                    Instant.EPOCH, Instant.parse("2026-11-18T19:39:36.123456Z"));
            long expectedPreEpochMicros =
                ChronoUnit.MICROS.between(
                    Instant.EPOCH, Instant.parse("1969-07-20T20:17:40.123456Z"));
            assertEquals(
                (int) LocalDate.of(2026, 11, 18).toEpochDay(),
                protoMsg.getField(descriptor.findFieldByName("d_sql")));
            assertEquals(
                (int) localDate.toEpochDay(),
                protoMsg.getField(descriptor.findFieldByName("d_local")));
            assertEquals(expectedTsMicros, protoMsg.getField(descriptor.findFieldByName("ts_sql")));
            assertEquals(
                expectedPreEpochMicros, protoMsg.getField(descriptor.findFieldByName("ts_inst")));
            assertEquals(expectedTsMicros, protoMsg.getField(descriptor.findFieldByName("ts_odt")));
            assertEquals(expectedTsMicros, protoMsg.getField(descriptor.findFieldByName("ts_zdt")));
            assertEquals(
                picos ? "2026-11-18 19:39:36.123456789000Z" : "2026-11-18T19:39:36.123456+00:00",
                protoMsg.getField(descriptor.findFieldByName("ts_picos")));
          }
        }
      }
    } finally {
      doReturn(false).when(connection).isEnableTimestampPicos();
      Locale.setDefault(originalLocale);
      TimeZone.setDefault(originalZone);
    }
  }

  @Test
  public void testUseWriteApiGatesTransactionsSessionsAndIncompatibleParameterValues()
      throws Exception {
    Schema schema =
        Schema.of(
            Field.newBuilder("req_str", StandardSQLTypeName.STRING)
                .setMode(Field.Mode.REQUIRED)
                .build(),
            Field.of("num_col", StandardSQLTypeName.NUMERIC),
            Field.of("flt_col", StandardSQLTypeName.FLOAT64));
    Job dryRunJob =
        mockInsertDryRunJob(
            TableId.of("proj", "_internal_session_ds", "TAB"),
            schema,
            Arrays.asList(queryParam("STRING"), queryParam("NUMERIC"), queryParam("FLOAT64")));
    doReturn(dryRunJob).when(bigQuery).create(any(JobInfo.class));

    BigQueryPreparedStatement ps =
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?, ?, ?)");
    for (int i = 0; i < 3; i++) {
      ps.setString(1, "v" + i);
      ps.setBigDecimal(2, new BigDecimal("12.34"));
      ps.setDouble(3, 1.5d);
      ps.addBatch();
    }
    assertTrue(ps.useWriteAPI());

    // Active SQL transaction must block Storage Write API so rollback() stays atomic.
    doReturn(true).when(connection).isTransactionStarted();
    assertFalse(ps.useWriteAPI());
    doReturn(false).when(connection).isTransactionStarted();

    // Active session with anonymous "_" dataset must block SWA (session TEMP table),
    // unless that "_" dataset is explicitly configured as DefaultDataset.
    BigQueryConnection.SessionState activeSession =
        new BigQueryConnection.SessionState(
            ConnectionProperty.of("session_id", "s1"), Collections.emptyList(), true);
    doReturn(activeSession).when(connection).getSessionStateSnapshot();
    assertFalse(ps.useWriteAPI());

    doReturn(DatasetId.of("proj", "_internal_session_ds")).when(connection).getDefaultDataset();
    BigQueryPreparedStatement psWithExplicitHiddenDs =
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?, ?, ?)");
    populateBatchAndAssertWriteApi(
        psWithExplicitHiddenDs,
        3,
        i -> {
          psWithExplicitHiddenDs.setString(1, "v" + i);
          psWithExplicitHiddenDs.setInt(2, i); // INT64 widening to NUMERIC is valid
          psWithExplicitHiddenDs.setDouble(3, 1.5d);
        },
        true);

    // Non-finite Double (NaN), out-of-range NUMERIC BigDecimal, BigInteger, NULL on REQUIRED, or
    // cross-family INT64->STRING must return false so BigQuery SQL handles them.
    populateBatchAndAssertWriteApi(
        psWithExplicitHiddenDs,
        3,
        i -> {
          psWithExplicitHiddenDs.setString(1, "v" + i);
          psWithExplicitHiddenDs.setBigDecimal(2, new BigDecimal("1E+40"));
          psWithExplicitHiddenDs.setDouble(3, 1.5d);
        },
        false);

    populateBatchAndAssertWriteApi(
        psWithExplicitHiddenDs,
        3,
        i -> {
          psWithExplicitHiddenDs.setString(1, "v" + i);
          psWithExplicitHiddenDs.setInt(2, 1);
          psWithExplicitHiddenDs.setDouble(3, Double.NaN);
        },
        false);

    populateBatchAndAssertWriteApi(
        psWithExplicitHiddenDs,
        3,
        i -> {
          psWithExplicitHiddenDs.setNull(1, Types.VARCHAR); // REQUIRED column
          psWithExplicitHiddenDs.setInt(2, 1);
          psWithExplicitHiddenDs.setDouble(3, 1.0d);
        },
        false);

    populateBatchAndAssertWriteApi(
        psWithExplicitHiddenDs,
        3,
        i -> {
          psWithExplicitHiddenDs.setInt(1, 99); // INT64 into STRING column
          psWithExplicitHiddenDs.setInt(2, 1);
          psWithExplicitHiddenDs.setDouble(3, 1.0d);
        },
        false);

    populateBatchAndAssertWriteApi(
        psWithExplicitHiddenDs,
        3,
        i -> {
          psWithExplicitHiddenDs.setString(1, "ok");
          psWithExplicitHiddenDs.setObject(2, BigInteger.TEN, Types.BIGINT);
          psWithExplicitHiddenDs.setDouble(3, 1.0d);
        },
        false);
  }

  @Test
  public void testExecuteBatchWriteApiDoesNotCloseConnectionClientAndWrapsRuntimeException()
      throws Exception {
    Schema schema = Schema.of(Field.of("col1", StandardSQLTypeName.STRING));
    Job dryRunJob =
        mockInsertDryRunJob(
            TableId.of("ds", "TAB"), schema, Collections.singletonList(queryParam("STRING")));
    doReturn("fallback-proj").when(connection).getCatalog();
    doReturn(dryRunJob).when(bigQuery).create(any(JobInfo.class));

    BigQueryWriteClient mockWriteClient = mock(BigQueryWriteClient.class);
    StatusRuntimeException streamError =
        Status.INVALID_ARGUMENT.withDescription("simulated SWA failure").asRuntimeException();
    when(mockWriteClient.createWriteStream(any(CreateWriteStreamRequest.class)))
        .thenThrow(streamError);
    doReturn(mockWriteClient).when(connection).getBigQueryWriteClient();

    BigQueryPreparedStatement ps =
        new BigQueryPreparedStatement(connection, "INSERT INTO ds.TAB (col1) VALUES (?)");
    for (int i = 0; i < 3; i++) {
      ps.setString(1, "row-" + i);
      ps.addBatch();
    }

    BigQueryJdbcException ex = assertThrows(BigQueryJdbcException.class, ps::executeBatch);
    assertSame(streamError, ex.getCause());
    // Cached BigQueryWriteClient belongs to BigQueryConnection; executeBatch must not close it.
    verify(mockWriteClient, never()).close();
    // Failed executeBatch must clear queued batchParameters so a subsequent batch starts clean.
    assertArrayEquals(new int[0], ps.executeBatch());
  }

  @Test
  public void testRetryDryRunRunsOnceWhenTableCreatedAfterPrepareStatement() throws Exception {
    String sql = "INSERT INTO ds.TAB (col1) VALUES (?)";
    Schema schema = Schema.of(Field.of("col1", StandardSQLTypeName.STRING));
    Job dryRunJob =
        mockInsertDryRunJob(
            TableId.of("proj", "ds", "TAB"),
            schema,
            Collections.singletonList(queryParam("STRING")));
    when(bigQuery.create(any(JobInfo.class)))
        .thenThrow(new BigQueryException(404, "Not found: Table proj:ds.TAB"))
        .thenReturn(dryRunJob);

    BigQueryWriteClient mockWriteClient = mock(BigQueryWriteClient.class);
    when(mockWriteClient.createWriteStream(any(CreateWriteStreamRequest.class)))
        .thenThrow(new RuntimeException("simulated stream init stop"));
    doReturn(mockWriteClient).when(connection).getBigQueryWriteClient();

    BigQueryPreparedStatement ps = new BigQueryPreparedStatement(connection, sql);
    assertNull(ps.insertSchema);

    for (int i = 0; i < 3; i++) {
      ps.setString(1, "v" + i);
      ps.addBatch();
    }
    // Retry dry run executes during executeBatch, populates insertSchema, and enters SWA path.
    assertThrows(BigQueryJdbcException.class, ps::executeBatch);
    assertNotNull(ps.insertSchema);
    verify(bigQuery, times(2)).create(any(JobInfo.class));
    verify(mockWriteClient, times(1)).createWriteStream(any(CreateWriteStreamRequest.class));
    verify(mockWriteClient, never()).close();
  }

  @Test
  public void testUnboundBatchParameterSparseAddBatchClearBatchAndClose() throws Exception {
    // Constructor dry run fails -> parameterCount falls back to 2 '?' placeholders.
    when(bigQuery.create(any(JobInfo.class))).thenThrow(new BigQueryException(400, "dry run off"));

    BigQueryPreparedStatement ps =
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB (a, b) VALUES (?, ?)");
    // Setting parameter 2 before parameter 1 leaves index 0 null in parametersList; addBatch must
    // not NPE, and executeBatch must report missing parameter 1.
    ps.setInt(2, 42);
    ps.addBatch();

    BigQueryJdbcException missingEx = assertThrows(BigQueryJdbcException.class, ps::executeBatch);
    assertTrue(missingEx.getMessage().contains("parameter 1 of 2"));

    // clearBatch empties queued rows.
    ps.setString(1, "x");
    ps.setInt(2, 42);
    ps.addBatch();
    ps.clearBatch();
    assertArrayEquals(new int[0], ps.executeBatch());

    // close() also clears queued batch rows without throwing.
    ps.addBatch();
    ps.close();
    assertTrue(ps.isClosed());
  }

  @Test
  public void testLegacySqlSkipsPositionalDryRun() throws Exception {
    doReturn("BIG_QUERY").when(connection).getQueryDialect();
    BigQueryPreparedStatement ps =
        new BigQueryPreparedStatement(connection, "SELECT ? FROM [proj:ds.tab]");
    assertEquals(1, ps.parameterCount);
    verify(bigQuery, never()).create(any(JobInfo.class));
  }

  @Test
  public void testTemporalAndSpecialColumnCompatibilityInUseWriteApi() throws Exception {
    Schema schema =
        Schema.of(
            Field.of("d_col", StandardSQLTypeName.DATE),
            Field.of("dt_col", StandardSQLTypeName.DATETIME),
            Field.of("ts_col", StandardSQLTypeName.TIMESTAMP),
            Field.of("json_col", StandardSQLTypeName.JSON));
    Job dryRunJob =
        mockInsertDryRunJob(
            TableId.of("proj", "ds", "TAB"),
            schema,
            Arrays.asList(
                queryParam("DATE"),
                queryParam("STRING"),
                queryParam("TIMESTAMP"),
                queryParam("JSON")));
    doReturn(dryRunJob).when(bigQuery).create(any(JobInfo.class));

    BigQueryPreparedStatement ps =
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?, ?, ?, ?)");

    // Nullable NULL values on temporal and JSON columns stay SWA-eligible when null type matches.
    populateBatchAndAssertWriteApi(
        ps,
        3,
        i -> {
          ps.setObject(1, LocalDate.of(2026, 11, 18));
          ps.setObject(2, LocalDateTime.of(2026, 11, 18, 10, 20, 30));
          ps.setTimestamp(3, Timestamp.from(Instant.parse("2026-11-18T10:20:30Z")));
          ps.setNull(4, Types.OTHER);
        },
        true);

    // Non-null JSON/GEOGRAPHY/INTERVAL bound as String falls back to SQL so BigQuery casts/parses.
    populateBatchAndAssertWriteApi(
        ps,
        3,
        i -> {
          ps.setObject(1, LocalDate.of(2026, 11, 18));
          ps.setObject(2, LocalDateTime.of(2026, 11, 18, 10, 20, 30));
          ps.setTimestamp(3, Timestamp.from(Instant.parse("2026-11-18T10:20:30Z")));
          ps.setString(4, "{\"k\":1}");
        },
        false);

    // Year 0 / 10000 LocalDate or out-of-range Date falls back to SQL.
    populateBatchAndAssertWriteApi(
        ps,
        3,
        i -> {
          ps.setObject(1, LocalDate.of(10000, 1, 1));
          ps.setObject(2, LocalDateTime.of(2026, 11, 18, 10, 20, 30));
          ps.setTimestamp(3, Timestamp.from(Instant.parse("2026-11-18T10:20:30Z")));
          ps.setNull(4, Types.OTHER);
        },
        false);

    // String bound to DATE or invalid DATETIME digits falls back to SQL.
    populateBatchAndAssertWriteApi(
        ps,
        3,
        i -> {
          ps.setObject(1, LocalDate.of(2026, 11, 18));
          ps.setString(2, "2026-11-18 10:20:30"); // missing fractional microseconds
          ps.setTimestamp(3, Timestamp.from(Instant.parse("2026-11-18T10:20:30Z")));
          ps.setNull(4, Types.OTHER);
        },
        false);

    // LocalDateTime bound as STRING into TIMESTAMP falls back to SQL.
    populateBatchAndAssertWriteApi(
        ps,
        3,
        i -> {
          ps.setObject(1, LocalDate.of(2026, 11, 18));
          ps.setObject(2, LocalDateTime.of(2026, 11, 18, 10, 20, 30));
          ps.setObject(3, LocalDateTime.of(2026, 11, 18, 10, 20, 30));
          ps.setNull(4, Types.OTHER);
        },
        false);

    // Out-of-range Instant (> 9999-12-31) into TIMESTAMP falls back to SQL.
    populateBatchAndAssertWriteApi(
        ps,
        3,
        i -> {
          ps.setObject(1, LocalDate.of(2026, 11, 18));
          ps.setObject(2, LocalDateTime.of(2026, 11, 18, 10, 20, 30));
          ps.setTimestamp(3, Timestamp.from(Instant.parse("+10000-01-01T00:00:00Z")));
          ps.setNull(4, Types.OTHER);
        },
        false);
  }

  @Test
  public void testExecuteBatchWriteApiMultiChunkSuccessOffsetsCommitAndTelemetry()
      throws Exception {
    String streamName = "projects/proj/datasets/ds/tables/TAB/streams/_pending_ok";
    Schema schema =
        Schema.of(
            Field.of("id", StandardSQLTypeName.INT64),
            Field.of("name", StandardSQLTypeName.STRING));
    Job dryRunJob =
        mockInsertDryRunJob(
            TableId.of("proj", "ds", "TAB"),
            schema,
            Arrays.asList(queryParam("INT64"), queryParam("STRING")));
    doReturn(dryRunJob).when(bigQuery).create(any(JobInfo.class));
    doReturn(2).when(connection).getWriteAPIAppendRowCount();

    BigQueryWriteClient mockWriteClient = mock(BigQueryWriteClient.class);
    when(mockWriteClient.createWriteStream(any(CreateWriteStreamRequest.class)))
        .thenReturn(
            WriteStream.newBuilder()
                .setName(streamName)
                .setTableSchema(TableSchema.getDefaultInstance())
                .build());
    when(mockWriteClient.finalizeWriteStream(streamName))
        .thenReturn(FinalizeWriteStreamResponse.newBuilder().setRowCount(5L).build());
    BatchCommitWriteStreamsResponse.Builder commitRespBuilder =
        BatchCommitWriteStreamsResponse.newBuilder();
    commitRespBuilder.getCommitTimeBuilder().setSeconds(1700000000L);
    when(mockWriteClient.batchCommitWriteStreams(any(BatchCommitWriteStreamsRequest.class)))
        .thenReturn(commitRespBuilder.build());
    doReturn(mockWriteClient).when(connection).getBigQueryWriteClient();

    JsonStreamWriter mockStreamWriter = mock(JsonStreamWriter.class);
    when(mockStreamWriter.append(any(JsonArray.class), anyLong()))
        .thenReturn(ApiFutures.immediateFuture(AppendRowsResponse.getDefaultInstance()));

    BigQueryPreparedStatement ps =
        newWriteApiPreparedStatement("INSERT INTO TAB (name, id) VALUES (?, ?)", mockStreamWriter);
    for (int i = 0; i < 5; i++) {
      ps.setString(1, "user-" + i);
      ps.setInt(2, i + 10);
      ps.addBatch();
    }

    int[] counts;
    try (MockedStatic<TelemetryManager> telemetry =
        mockStatic(TelemetryManager.class, CALLS_REAL_METHODS)) {
      counts = ps.executeBatch();

      ArgumentCaptor<StatementExecution.Builder> executionCaptor =
          ArgumentCaptor.forClass(StatementExecution.Builder.class);
      telemetry.verify(
          () -> TelemetryManager.recordStatementExecution(executionCaptor.capture(), anyLong()),
          times(1));
      assertEquals(
          QueryApiType.QUERY_API_TYPE_WRITE_API, executionCaptor.getValue().getQueryApiType());
      assertEquals("STATUS_SUCCESS", executionCaptor.getValue().getStatus().name());
    }

    assertArrayEquals(new int[] {1, 1, 1, 1, 1}, counts);

    ArgumentCaptor<JsonArray> batchCaptor = ArgumentCaptor.forClass(JsonArray.class);
    ArgumentCaptor<Long> offsetCaptor = ArgumentCaptor.forClass(Long.class);
    verify(mockStreamWriter, times(3)).append(batchCaptor.capture(), offsetCaptor.capture());
    assertEquals(Arrays.asList(0L, 2L, 4L), offsetCaptor.getAllValues());
    List<JsonArray> appendedChunks = batchCaptor.getAllValues();
    assertEquals(2, appendedChunks.get(0).size());
    assertEquals(2, appendedChunks.get(1).size());
    assertEquals(1, appendedChunks.get(2).size());
    assertEquals(
        "user-0", appendedChunks.get(0).get(0).getAsJsonObject().get("name").getAsString());
    assertEquals("14", appendedChunks.get(2).get(0).getAsJsonObject().get("id").getAsString());

    ArgumentCaptor<BatchCommitWriteStreamsRequest> commitCaptor =
        ArgumentCaptor.forClass(BatchCommitWriteStreamsRequest.class);
    verify(mockWriteClient, times(1)).finalizeWriteStream(streamName);
    verify(mockWriteClient, times(1)).batchCommitWriteStreams(commitCaptor.capture());
    assertEquals("projects/proj/datasets/ds/tables/TAB", commitCaptor.getValue().getParent());
    assertEquals(
        Collections.singletonList(streamName), commitCaptor.getValue().getWriteStreamsList());

    verify(mockStreamWriter, times(1)).close();
    verify(mockWriteClient, never()).close();
    assertArrayEquals(new int[0], ps.executeBatch());
  }

  @Test
  public void testExecuteBatchWriteApiCommitMissingCommitTimeThrowsAndCleansUp() throws Exception {
    String streamName = "projects/proj/datasets/ds/tables/TAB/streams/_pending_commit_fail";
    Schema schema = Schema.of(Field.of("col1", StandardSQLTypeName.STRING));
    Job dryRunJob =
        mockInsertDryRunJob(
            TableId.of("proj", "ds", "TAB"),
            schema,
            Collections.singletonList(queryParam("STRING")));
    doReturn(dryRunJob).when(bigQuery).create(any(JobInfo.class));

    BigQueryWriteClient mockWriteClient = mock(BigQueryWriteClient.class);
    when(mockWriteClient.createWriteStream(any(CreateWriteStreamRequest.class)))
        .thenReturn(
            WriteStream.newBuilder()
                .setName(streamName)
                .setTableSchema(TableSchema.getDefaultInstance())
                .build());
    when(mockWriteClient.finalizeWriteStream(streamName))
        .thenReturn(FinalizeWriteStreamResponse.newBuilder().setRowCount(3L).build());
    when(mockWriteClient.batchCommitWriteStreams(any(BatchCommitWriteStreamsRequest.class)))
        .thenReturn(BatchCommitWriteStreamsResponse.getDefaultInstance());
    doReturn(mockWriteClient).when(connection).getBigQueryWriteClient();

    JsonStreamWriter mockStreamWriter = mock(JsonStreamWriter.class);
    when(mockStreamWriter.append(any(JsonArray.class), anyLong()))
        .thenReturn(ApiFutures.immediateFuture(AppendRowsResponse.getDefaultInstance()));

    BigQueryPreparedStatement ps =
        newWriteApiPreparedStatement("INSERT INTO TAB VALUES (?)", mockStreamWriter);
    for (int i = 0; i < 3; i++) {
      ps.setString(1, "row-" + i);
      ps.addBatch();
    }

    try (MockedStatic<TelemetryManager> telemetry =
        mockStatic(TelemetryManager.class, CALLS_REAL_METHODS)) {
      BigQueryJdbcException ex = assertThrows(BigQueryJdbcException.class, ps::executeBatch);
      assertTrue(ex.getMessage().contains("Error committing the streams"));

      ArgumentCaptor<StatementExecution.Builder> executionCaptor =
          ArgumentCaptor.forClass(StatementExecution.Builder.class);
      telemetry.verify(
          () -> TelemetryManager.recordStatementExecution(executionCaptor.capture(), anyLong()),
          times(1));
      assertEquals("STATUS_ERROR", executionCaptor.getValue().getStatus().name());
    }

    verify(mockStreamWriter, times(1)).close();
    verify(mockWriteClient, never()).close();
    assertArrayEquals(new int[0], ps.executeBatch());
  }

  @Test
  public void testExecuteBatchWriteApiAppendFailureClosesWriterOnceWithoutClosingClient()
      throws Exception {
    String streamName = "projects/proj/datasets/ds/tables/TAB/streams/_pending_append_fail";
    Schema schema = Schema.of(Field.of("col1", StandardSQLTypeName.STRING));
    Job dryRunJob =
        mockInsertDryRunJob(
            TableId.of("proj", "ds", "TAB"),
            schema,
            Collections.singletonList(queryParam("STRING")));
    doReturn(dryRunJob).when(bigQuery).create(any(JobInfo.class));

    BigQueryWriteClient mockWriteClient = mock(BigQueryWriteClient.class);
    when(mockWriteClient.createWriteStream(any(CreateWriteStreamRequest.class)))
        .thenReturn(
            WriteStream.newBuilder()
                .setName(streamName)
                .setTableSchema(TableSchema.getDefaultInstance())
                .build());
    doReturn(mockWriteClient).when(connection).getBigQueryWriteClient();

    JsonStreamWriter mockStreamWriter = mock(JsonStreamWriter.class);
    IOException appendIoEx = new IOException("broken pipe");
    when(mockStreamWriter.append(any(JsonArray.class), anyLong())).thenThrow(appendIoEx);

    BigQueryPreparedStatement ps =
        newWriteApiPreparedStatement("INSERT INTO TAB VALUES (?)", mockStreamWriter);
    for (int i = 0; i < 3; i++) {
      ps.setString(1, "row-" + i);
      ps.addBatch();
    }

    try (MockedStatic<TelemetryManager> telemetry =
        mockStatic(TelemetryManager.class, CALLS_REAL_METHODS)) {
      BigQueryJdbcException ex = assertThrows(BigQueryJdbcException.class, ps::executeBatch);
      assertSame(appendIoEx, ex.getCause());

      ArgumentCaptor<StatementExecution.Builder> executionCaptor =
          ArgumentCaptor.forClass(StatementExecution.Builder.class);
      telemetry.verify(
          () -> TelemetryManager.recordStatementExecution(executionCaptor.capture(), anyLong()),
          times(1));
      assertEquals("STATUS_ERROR", executionCaptor.getValue().getStatus().name());
    }

    verify(mockStreamWriter, times(1)).close();
    verify(mockWriteClient, never()).finalizeWriteStream(anyString());
    verify(mockWriteClient, never()).close();
    assertArrayEquals(new int[0], ps.executeBatch());
  }

  @Test
  public void testExecuteBatchWriteApiInterruptedCleanupRestoresInterruptFlagAndRecordsTelemetry()
      throws Exception {
    String streamName = "projects/proj/datasets/ds/tables/TAB/streams/_pending_interrupt";
    Schema schema = Schema.of(Field.of("col1", StandardSQLTypeName.STRING));
    Job dryRunJob =
        mockInsertDryRunJob(
            TableId.of("proj", "ds", "TAB"),
            schema,
            Collections.singletonList(queryParam("STRING")));
    doReturn(dryRunJob).when(bigQuery).create(any(JobInfo.class));

    BigQueryWriteClient mockWriteClient = mock(BigQueryWriteClient.class);
    when(mockWriteClient.createWriteStream(any(CreateWriteStreamRequest.class)))
        .thenReturn(
            WriteStream.newBuilder()
                .setName(streamName)
                .setTableSchema(TableSchema.getDefaultInstance())
                .build());
    doReturn(mockWriteClient).when(connection).getBigQueryWriteClient();

    JsonStreamWriter mockStreamWriter = mock(JsonStreamWriter.class);
    SettableApiFuture<AppendRowsResponse> stalledFuture = SettableApiFuture.create();
    when(mockStreamWriter.append(any(JsonArray.class), anyLong())).thenReturn(stalledFuture);

    BigQueryPreparedStatement ps =
        newWriteApiPreparedStatement("INSERT INTO TAB VALUES (?)", mockStreamWriter);
    for (int i = 0; i < 3; i++) {
      ps.setString(1, "row-" + i);
      ps.addBatch();
    }

    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          try (MockedStatic<TelemetryManager> telemetry =
              mockStatic(TelemetryManager.class, CALLS_REAL_METHODS)) {
            Thread.currentThread().interrupt();
            BigQueryJdbcException ex = assertThrows(BigQueryJdbcException.class, ps::executeBatch);
            assertTrue(ex.getCause() instanceof InterruptedException);
            assertTrue(Thread.currentThread().isInterrupted());

            ArgumentCaptor<StatementExecution.Builder> executionCaptor =
                ArgumentCaptor.forClass(StatementExecution.Builder.class);
            telemetry.verify(
                () ->
                    TelemetryManager.recordStatementExecution(executionCaptor.capture(), anyLong()),
                times(1));
            assertEquals("STATUS_ERROR", executionCaptor.getValue().getStatus().name());
          } finally {
            Thread.interrupted();
          }
        });

    verify(mockStreamWriter, times(1)).close();
    verify(mockWriteClient, never()).close();
  }

  @Test
  public void testRetryDryRunUsesUnboundDescribeForNullsAndRunsOnceWhenDryRunReturnsNull()
      throws Exception {
    String sql = "INSERT INTO ds.TAB (num_col) VALUES (?)";
    Schema schema = Schema.of(Field.of("num_col", StandardSQLTypeName.INT64));
    Job dryRunJob =
        mockInsertDryRunJob(
            TableId.of("proj", "ds", "TAB"),
            schema,
            Collections.singletonList(queryParam("INT64")));
    TableResult dmlResult = mock(TableResult.class);
    doReturn(StatementType.INSERT).when(dmlResult).getStatementType();
    doReturn(1L).when(dmlResult).getNumDmlAffectedRows();
    doReturn(dmlResult).when(bigQuery).queryWithTimeout(any(), any(), any());

    when(bigQuery.create(any(JobInfo.class)))
        .thenThrow(new BigQueryException(404, "Not found"))
        .thenReturn(dryRunJob);

    BigQueryPreparedStatement ps = new BigQueryPreparedStatement(connection, sql);
    // First batch binds Types.OTHER (defaults to STRING before dry run); retry dry run must still
    // send an unbound POSITIONAL dry-run query without failing on STRING vs INT64 mismatch, and
    // this mismatched batch must fall back to SQL DML cleanly.
    for (int i = 0; i < 3; i++) {
      ps.setNull(1, Types.OTHER);
      ps.addBatch();
    }
    int[] counts = ps.executeBatch();
    assertEquals(3, counts.length);
    assertNotNull(ps.insertSchema);

    ArgumentCaptor<JobInfo> jobInfoCaptor = ArgumentCaptor.forClass(JobInfo.class);
    verify(bigQuery, times(2)).create(jobInfoCaptor.capture());
    QueryJobConfiguration retryConfig = jobInfoCaptor.getAllValues().get(1).getConfiguration();
    assertTrue(
        retryConfig.getPositionalParameters() == null
            || retryConfig.getPositionalParameters().isEmpty());

    // When retry dry run completes with null statistics, insertMetadataEvaluated becomes true so
    // subsequent executeBatch calls do not repeat the dry run.
    clearInvocations(bigQuery);
    Job nullStatsJob = mock(Job.class);
    when(bigQuery.create(any(JobInfo.class)))
        .thenThrow(new BigQueryException(404, "Not found"))
        .thenReturn(nullStatsJob);
    BigQueryPreparedStatement psNullStats = new BigQueryPreparedStatement(connection, sql);
    for (int b = 0; b < 2; b++) {
      for (int i = 0; i < 3; i++) {
        psNullStats.setLong(1, i);
        psNullStats.addBatch();
      }
      psNullStats.executeBatch();
    }
    verify(bigQuery, times(2)).create(any(JobInfo.class));
  }

  @Test
  public void testResolveTargetProjectDatasetMatchingAndParameterizedNumericBounds()
      throws Exception {
    doReturn("catalog-proj").when(connection).getCatalog();
    doReturn(DatasetId.of("default-proj", "default_ds")).when(connection).getDefaultDataset();

    // Unqualified table project on a different dataset ("other_ds" != "default_ds") uses catalog.
    Schema numericSchema =
        Schema.of(
            Field.newBuilder("n_prec_only", StandardSQLTypeName.NUMERIC).setPrecision(5L).build(),
            Field.newBuilder("n_prec_scale", StandardSQLTypeName.NUMERIC)
                .setPrecision(5L)
                .setScale(2L)
                .build(),
            Field.newBuilder("bn_prec_scale", StandardSQLTypeName.BIGNUMERIC)
                .setPrecision(8L)
                .setScale(3L)
                .build());
    Job otherDsJob =
        mockInsertDryRunJob(
            TableId.of("other_ds", "TAB"),
            numericSchema,
            Arrays.asList(queryParam("NUMERIC"), queryParam("NUMERIC"), queryParam("BIGNUMERIC")));
    doReturn(otherDsJob).when(bigQuery).create(any(JobInfo.class));

    String streamName = "projects/catalog-proj/datasets/other_ds/tables/TAB/streams/_pending1";
    BigQueryWriteClient mockWriteClient = mock(BigQueryWriteClient.class);
    when(mockWriteClient.createWriteStream(any(CreateWriteStreamRequest.class)))
        .thenReturn(
            WriteStream.newBuilder()
                .setName(streamName)
                .setTableSchema(TableSchema.getDefaultInstance())
                .build());
    when(mockWriteClient.finalizeWriteStream(streamName))
        .thenReturn(FinalizeWriteStreamResponse.newBuilder().setRowCount(3L).build());
    BatchCommitWriteStreamsResponse.Builder okCommit = BatchCommitWriteStreamsResponse.newBuilder();
    okCommit.getCommitTimeBuilder().setSeconds(1700000000L);
    when(mockWriteClient.batchCommitWriteStreams(any(BatchCommitWriteStreamsRequest.class)))
        .thenReturn(okCommit.build());
    doReturn(mockWriteClient).when(connection).getBigQueryWriteClient();

    JsonStreamWriter mockStreamWriter = mock(JsonStreamWriter.class);
    when(mockStreamWriter.append(any(JsonArray.class), anyLong()))
        .thenReturn(ApiFutures.immediateFuture(AppendRowsResponse.getDefaultInstance()));

    BigQueryPreparedStatement ps =
        newWriteApiPreparedStatement("INSERT INTO other_ds.TAB VALUES (?, ?, ?)", mockStreamWriter);

    // Trailing zeros ("12.3400") on NUMERIC(5, 2) and trailing-zero scale on NUMERIC(5) succeed.
    populateBatchAndAssertWriteApi(
        ps,
        3,
        i -> {
          ps.setBigDecimal(1, new BigDecimal("12300"));
          ps.setBigDecimal(2, new BigDecimal("12.3400"));
          ps.setBigDecimal(3, new BigDecimal("12345.6780"));
        },
        true);

    // Parameterized precision/scale violations fall back to SQL instead of failing on SWA.
    populateBatchAndAssertWriteApi(
        ps,
        3,
        i -> {
          ps.setBigDecimal(1, new BigDecimal("12.5")); // NUMERIC(5) has effective scale 0
          ps.setBigDecimal(2, new BigDecimal("12.34"));
          ps.setBigDecimal(3, new BigDecimal("1.23"));
        },
        false);
    populateBatchAndAssertWriteApi(
        ps,
        3,
        i -> {
          ps.setBigDecimal(1, new BigDecimal("100"));
          ps.setBigDecimal(2, new BigDecimal("1234.50")); // 4 integer digits > (5 - 2 = 3)
          ps.setBigDecimal(3, new BigDecimal("1.23"));
        },
        false);
    populateBatchAndAssertWriteApi(
        ps,
        3,
        i -> {
          ps.setBigDecimal(1, new BigDecimal("100"));
          ps.setBigDecimal(2, new BigDecimal("12.345")); // scale 3 > 2
          ps.setBigDecimal(3, new BigDecimal("1.23"));
        },
        false);
    populateBatchAndAssertWriteApi(
        ps,
        3,
        i -> {
          ps.setInt(1, 100);
          ps.setInt(2, 1000); // 4 integer digits > (5 - 2 = 3) for INT64->NUMERIC(5, 2)
          ps.setInt(3, 100);
        },
        false);
    populateBatchAndAssertWriteApi(
        ps,
        3,
        i -> {
          ps.setInt(1, 100);
          ps.setInt(2, 999); // fits 3 integer digits for INT64->NUMERIC(5, 2)
          ps.setInt(3, 100);
        },
        true);

    // Executing eligible batch creates stream under catalog-proj (not default-proj).
    populateBatchAndAssertWriteApi(
        ps,
        3,
        i -> {
          ps.setBigDecimal(1, new BigDecimal("12300"));
          ps.setBigDecimal(2, new BigDecimal("12.3400"));
          ps.setBigDecimal(3, new BigDecimal("12345.6780"));
        },
        true);
    ps.executeBatch();
    ArgumentCaptor<CreateWriteStreamRequest> createCaptor =
        ArgumentCaptor.forClass(CreateWriteStreamRequest.class);
    verify(mockWriteClient, times(1)).createWriteStream(createCaptor.capture());
    assertEquals(
        "projects/catalog-proj/datasets/other_ds/tables/TAB", createCaptor.getValue().getParent());

    // When tableId.getDataset() matches defaultDataset.getDataset(), defaultDataset project wins.
    Job defaultDsJob =
        mockInsertDryRunJob(
            TableId.of("default_ds", "TAB"),
            Schema.of(Field.of("id", StandardSQLTypeName.INT64)),
            Collections.singletonList(queryParam("INT64")));
    doReturn(defaultDsJob).when(bigQuery).create(any(JobInfo.class));
    String defaultStreamName = "projects/default-proj/datasets/default_ds/tables/TAB/streams/_p2";
    when(mockWriteClient.createWriteStream(any(CreateWriteStreamRequest.class)))
        .thenReturn(
            WriteStream.newBuilder()
                .setName(defaultStreamName)
                .setTableSchema(TableSchema.getDefaultInstance())
                .build());
    when(mockWriteClient.finalizeWriteStream(defaultStreamName))
        .thenReturn(FinalizeWriteStreamResponse.newBuilder().setRowCount(3L).build());

    BigQueryPreparedStatement psDefaultDs =
        newWriteApiPreparedStatement("INSERT INTO TAB VALUES (?)", mockStreamWriter);
    populateBatchAndAssertWriteApi(psDefaultDs, 3, i -> psDefaultDs.setInt(1, i), true);
    psDefaultDs.executeBatch();
    verify(mockWriteClient, times(2)).createWriteStream(createCaptor.capture());
    assertEquals(
        "projects/default-proj/datasets/default_ds/tables/TAB",
        createCaptor.getValue().getParent());
  }
}
