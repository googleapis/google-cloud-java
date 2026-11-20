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

  private static final String STREAM_NAME = "projects/proj/datasets/ds/tables/TAB/streams/_p1";

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

  private static QueryParameter queryParam(String typeName) {
    return new QueryParameter().setParameterType(new QueryParameterType().setType(typeName));
  }

  private static TableFieldSchema protoField(String name, TableFieldSchema.Type type, long picos) {
    TableFieldSchema.Builder b =
        TableFieldSchema.newBuilder()
            .setName(name)
            .setType(type)
            .setMode(TableFieldSchema.Mode.NULLABLE);
    if (picos > 0) {
      b.setTimestampPrecision(Int64Value.of(picos));
    }
    return b.build();
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

  private BigQueryWriteClient stubWriteClient(long finalizedRows, boolean commitHasTimestamp)
      throws SQLException {
    BigQueryWriteClient writeClient = mock(BigQueryWriteClient.class);
    when(writeClient.createWriteStream(any(CreateWriteStreamRequest.class)))
        .thenReturn(
            WriteStream.newBuilder()
                .setName(STREAM_NAME)
                .setTableSchema(TableSchema.getDefaultInstance())
                .build());
    if (finalizedRows >= 0) {
      when(writeClient.finalizeWriteStream(STREAM_NAME))
          .thenReturn(FinalizeWriteStreamResponse.newBuilder().setRowCount(finalizedRows).build());
      BatchCommitWriteStreamsResponse.Builder commitResp =
          BatchCommitWriteStreamsResponse.newBuilder();
      if (commitHasTimestamp) {
        commitResp.getCommitTimeBuilder().setSeconds(1700000000L);
      }
      when(writeClient.batchCommitWriteStreams(any(BatchCommitWriteStreamsRequest.class)))
          .thenReturn(commitResp.build());
    }
    doReturn(writeClient).when(connection).getBigQueryWriteClient();
    return writeClient;
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

  @Test
  public void testConstructorRejectsNullQueryAndBatchLifecycleClearsQueue() throws Exception {
    assertThrows(
        BigQueryJdbcException.class, () -> new BigQueryPreparedStatement(connection, null));

    when(bigQuery.create(any(JobInfo.class))).thenThrow(new BigQueryException(400, "dry run off"));
    BigQueryPreparedStatement ps =
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB (a, b) VALUES (?, ?)");
    ps.setInt(2, 42);
    ps.addBatch();

    BigQueryJdbcException missingEx = assertThrows(BigQueryJdbcException.class, ps::executeBatch);
    assertTrue(missingEx.getMessage().contains("parameter 1 of 2"));
    assertArrayEquals(new int[0], ps.executeBatch());

    ps.setString(1, "x");
    ps.setInt(2, 42);
    ps.addBatch();
    ps.clearBatch();
    assertArrayEquals(new int[0], ps.executeBatch());

    ps.addBatch();
    ps.close();
    assertTrue(ps.isClosed());
  }

  @Test
  public void testExecuteBatchWriteApiMultiChunkSuccessOffsetsCommitAndTelemetry()
      throws Exception {
    Schema schema =
        Schema.of(
            Field.of("id", StandardSQLTypeName.INT64),
            Field.of("name", StandardSQLTypeName.STRING));
    doReturn(
            mockInsertDryRunJob(
                TableId.of("proj", "ds", "TAB"),
                schema,
                Arrays.asList(queryParam("INT64"), queryParam("STRING"))))
        .when(bigQuery)
        .create(any(JobInfo.class));
    doReturn(2).when(connection).getWriteAPIAppendRowCount();

    BigQueryWriteClient mockWriteClient = stubWriteClient(5L, true);
    JsonStreamWriter mockStreamWriter = mock(JsonStreamWriter.class);
    when(mockStreamWriter.append(any(JsonArray.class), anyLong()))
        .thenReturn(ApiFutures.immediateFuture(AppendRowsResponse.getDefaultInstance()));

    BigQueryPreparedStatement ps =
        newWriteApiPreparedStatement("INSERT INTO TAB (id, name) VALUES (?, ?)", mockStreamWriter);
    for (int i = 0; i < 5; i++) {
      ps.setInt(1, i + 10);
      ps.setString(2, "user-" + i);
      ps.addBatch();
    }

    try (MockedStatic<TelemetryManager> telemetry =
        mockStatic(TelemetryManager.class, CALLS_REAL_METHODS)) {
      assertArrayEquals(new int[] {1, 1, 1, 1, 1}, ps.executeBatch());
      ArgumentCaptor<StatementExecution.Builder> execCaptor =
          ArgumentCaptor.forClass(StatementExecution.Builder.class);
      telemetry.verify(
          () -> TelemetryManager.recordStatementExecution(execCaptor.capture(), anyLong()));
      assertEquals(QueryApiType.QUERY_API_TYPE_WRITE_API, execCaptor.getValue().getQueryApiType());
      assertEquals("STATUS_SUCCESS", execCaptor.getValue().getStatus().name());
    }

    ArgumentCaptor<JsonArray> batchCaptor = ArgumentCaptor.forClass(JsonArray.class);
    ArgumentCaptor<Long> offsetCaptor = ArgumentCaptor.forClass(Long.class);
    verify(mockStreamWriter, times(3)).append(batchCaptor.capture(), offsetCaptor.capture());
    assertEquals(Arrays.asList(0L, 2L, 4L), offsetCaptor.getAllValues());
    assertEquals(
        "user-0",
        batchCaptor.getAllValues().get(0).get(0).getAsJsonObject().get("name").getAsString());
    verify(mockStreamWriter, times(1)).close();
    verify(mockWriteClient, never()).close();
    assertArrayEquals(new int[0], ps.executeBatch());
  }

  @Test
  public void testExecuteBatchWriteApiFailurePathsPreserveClientCloseWriterAndRecordError()
      throws Exception {
    doReturn(
            mockInsertDryRunJob(
                TableId.of("proj", "ds", "TAB"),
                Schema.of(Field.of("col1", StandardSQLTypeName.STRING)),
                Collections.singletonList(queryParam("STRING"))))
        .when(bigQuery)
        .create(any(JobInfo.class));

    // 1. Stream creation RuntimeException wraps in BigQueryJdbcException without closing client.
    BigQueryWriteClient initFailClient = mock(BigQueryWriteClient.class);
    StatusRuntimeException streamError =
        Status.INVALID_ARGUMENT.withDescription("simulated SWA failure").asRuntimeException();
    when(initFailClient.createWriteStream(any(CreateWriteStreamRequest.class)))
        .thenThrow(streamError);
    doReturn(initFailClient).when(connection).getBigQueryWriteClient();
    BigQueryPreparedStatement psInitFail =
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?)");
    for (int i = 0; i < 3; i++) {
      psInitFail.setString(1, "r" + i);
      psInitFail.addBatch();
    }
    assertSame(
        streamError,
        assertThrows(BigQueryJdbcException.class, psInitFail::executeBatch).getCause());
    verify(initFailClient, never()).close();
    assertArrayEquals(new int[0], psInitFail.executeBatch());

    // 2. Append IOException closes writer once via closeQuietly without finalizing or closing
    // client.
    BigQueryWriteClient appendFailClient = stubWriteClient(-1L, false);
    JsonStreamWriter ioFailWriter = mock(JsonStreamWriter.class);
    IOException brokenPipe = new IOException("broken pipe");
    when(ioFailWriter.append(any(JsonArray.class), anyLong())).thenThrow(brokenPipe);
    BigQueryPreparedStatement psIoFail =
        newWriteApiPreparedStatement("INSERT INTO TAB VALUES (?)", ioFailWriter);
    for (int i = 0; i < 3; i++) {
      psIoFail.setString(1, "r" + i);
      psIoFail.addBatch();
    }
    assertSame(
        brokenPipe, assertThrows(BigQueryJdbcException.class, psIoFail::executeBatch).getCause());
    verify(ioFailWriter, times(1)).close();
    verify(appendFailClient, never()).finalizeWriteStream(anyString());
    verify(appendFailClient, never()).close();

    // 3. Missing commit timestamp throws BigQueryJdbcException and records STATUS_ERROR.
    BigQueryWriteClient commitFailClient = stubWriteClient(3L, false);
    JsonStreamWriter okAppendWriter = mock(JsonStreamWriter.class);
    when(okAppendWriter.append(any(JsonArray.class), anyLong()))
        .thenReturn(ApiFutures.immediateFuture(AppendRowsResponse.getDefaultInstance()));
    BigQueryPreparedStatement psCommitFail =
        newWriteApiPreparedStatement("INSERT INTO TAB VALUES (?)", okAppendWriter);
    for (int i = 0; i < 3; i++) {
      psCommitFail.setString(1, "r" + i);
      psCommitFail.addBatch();
    }
    assertTrue(
        assertThrows(BigQueryJdbcException.class, psCommitFail::executeBatch)
            .getMessage()
            .contains("Error committing the streams"));
    verify(okAppendWriter, times(1)).close();
    verify(commitFailClient, never()).close();

    // 4. Interrupted cleanup restores thread interrupt flag and closes writer once.
    stubWriteClient(-1L, false);
    JsonStreamWriter stalledWriter = mock(JsonStreamWriter.class);
    when(stalledWriter.append(any(JsonArray.class), anyLong()))
        .thenReturn(SettableApiFuture.create());
    BigQueryPreparedStatement psInterrupt =
        newWriteApiPreparedStatement("INSERT INTO TAB VALUES (?)", stalledWriter);
    for (int i = 0; i < 3; i++) {
      psInterrupt.setString(1, "r" + i);
      psInterrupt.addBatch();
    }
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          Thread.currentThread().interrupt();
          try {
            BigQueryJdbcException ex =
                assertThrows(BigQueryJdbcException.class, psInterrupt::executeBatch);
            assertTrue(ex.getCause() instanceof InterruptedException);
            assertTrue(Thread.currentThread().isInterrupted());
          } finally {
            Thread.interrupted();
          }
        });
    verify(stalledWriter, times(1)).close();
  }

  @Test
  public void testCreateJsonRowAndProtoRoundTripAcrossLocalesZonesAndTypes() throws Exception {
    Schema schema =
        Schema.of(
            Field.of("b_col", StandardSQLTypeName.BYTES),
            Field.of("f_col", StandardSQLTypeName.FLOAT64),
            Field.of("n_zero", StandardSQLTypeName.NUMERIC),
            Field.of("bool_col", StandardSQLTypeName.BOOL),
            Field.of("d_sql", StandardSQLTypeName.DATE),
            Field.of("d_local", StandardSQLTypeName.DATE),
            Field.of("t_sql", StandardSQLTypeName.TIME),
            Field.of("t_local", StandardSQLTypeName.TIME),
            Field.of("dt_col", StandardSQLTypeName.DATETIME),
            Field.of("ts_sql", StandardSQLTypeName.TIMESTAMP),
            Field.of("ts_odt", StandardSQLTypeName.TIMESTAMP),
            Field.newBuilder("ts_picos", StandardSQLTypeName.TIMESTAMP)
                .setTimestampPrecision(12L)
                .build());
    doReturn(
            mockInsertDryRunJob(
                TableId.of("proj", "ds", "TAB"),
                schema,
                Arrays.asList(
                    queryParam("BYTES"),
                    queryParam("FLOAT64"),
                    queryParam("NUMERIC"),
                    queryParam("BOOL"),
                    queryParam("DATE"),
                    queryParam("DATE"),
                    queryParam("TIME"),
                    queryParam("TIME"),
                    queryParam("STRING"),
                    queryParam("TIMESTAMP"),
                    queryParam("TIMESTAMP"),
                    queryParam("TIMESTAMP"))))
        .when(bigQuery)
        .create(any(JobInfo.class));

    TableSchema protoTableSchema =
        TableSchema.newBuilder()
            .addFields(protoField("b_col", TableFieldSchema.Type.BYTES, 0))
            .addFields(protoField("f_col", TableFieldSchema.Type.DOUBLE, 0))
            .addFields(protoField("n_zero", TableFieldSchema.Type.NUMERIC, 0))
            .addFields(protoField("bool_col", TableFieldSchema.Type.BOOL, 0))
            .addFields(protoField("d_sql", TableFieldSchema.Type.DATE, 0))
            .addFields(protoField("d_local", TableFieldSchema.Type.DATE, 0))
            .addFields(protoField("t_sql", TableFieldSchema.Type.TIME, 0))
            .addFields(protoField("t_local", TableFieldSchema.Type.TIME, 0))
            .addFields(protoField("dt_col", TableFieldSchema.Type.DATETIME, 0))
            .addFields(protoField("ts_sql", TableFieldSchema.Type.TIMESTAMP, 0))
            .addFields(protoField("ts_odt", TableFieldSchema.Type.TIMESTAMP, 0))
            .addFields(protoField("ts_picos", TableFieldSchema.Type.TIMESTAMP, 12))
            .build();
    Descriptor descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(protoTableSchema);

    byte[] rawBytes = new byte[] {-128, 0, 127};
    Locale origLocale = Locale.getDefault();
    TimeZone origZone = TimeZone.getDefault();
    try {
      for (Locale locale : Arrays.asList(Locale.US, Locale.FRANCE, Locale.JAPAN)) {
        for (String zoneId : Arrays.asList("UTC", "America/New_York", "Asia/Tokyo")) {
          Locale.setDefault(locale);
          TimeZone.setDefault(TimeZone.getTimeZone(zoneId));
          for (boolean picos : new boolean[] {false, true}) {
            doReturn(picos).when(connection).isEnableTimestampPicos();
            BigQueryPreparedStatement ps =
                new BigQueryPreparedStatement(
                    connection, "INSERT INTO TAB VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            for (int r = 0; r < 3; r++) {
              ps.setBytes(1, rawBytes);
              ps.setFloat(2, 0.6f);
              ps.setBigDecimal(3, BigDecimal.valueOf(0, -100_000_000));
              ps.setBoolean(4, true);
              ps.setDate(5, Date.valueOf("2026-11-18"));
              ps.setObject(6, LocalDate.of(1969, 7, 20));
              ps.setTime(7, Time.valueOf("14:39:36"));
              ps.setObject(8, LocalTime.of(12, 34, 56, 789_123_000));
              ps.setObject(9, LocalDateTime.of(2025, 12, 3, 12, 30, 0, 123_456_000));
              ps.setTimestamp(10, Timestamp.from(Instant.parse("2026-11-18T19:39:36.123456789Z")));
              ps.setObject(
                  11,
                  ZonedDateTime.of(
                      2026, 11, 18, 14, 39, 36, 123_456_000, ZoneId.of("America/New_York")));
              ps.setObject(12, OffsetDateTime.parse("2026-11-18T14:39:36.123456789-05:00"));
              ps.addBatch();
            }
            assertTrue(ps.useWriteAPI());

            JsonObject row =
                BigQueryPreparedStatement.createJsonRow(
                    schema.getFields(), ps.parameterHandler.parametersList, picos);
            assertEquals("0", row.get("n_zero").getAsString());
            assertEquals(
                picos ? "2026-11-18 19:39:36.123456789000Z" : "2026-11-18 19:39:36.123456Z",
                row.get("ts_picos").getAsString());
            assertEquals(
                row.get("ts_picos").getAsString(),
                QueryParameterValue.timestamp(row.get("ts_picos").getAsString()).getValue());

            DynamicMessage protoMsg =
                JsonToProtoMessage.INSTANCE.convertToProtoMessage(
                    descriptor, protoTableSchema, new JSONObject(row.toString()));
            assertArrayEquals(
                rawBytes, (byte[]) protoMsg.getField(descriptor.findFieldByName("b_col")));
            assertEquals(
                (int) LocalDate.of(2026, 11, 18).toEpochDay(),
                protoMsg.getField(descriptor.findFieldByName("d_sql")));
            assertEquals(
                ChronoUnit.MICROS.between(
                    Instant.EPOCH, Instant.parse("2026-11-18T19:39:36.123456Z")),
                protoMsg.getField(descriptor.findFieldByName("ts_sql")));
            assertEquals(
                picos ? "2026-11-18 19:39:36.123456789000Z" : "2026-11-18T19:39:36.123456+00:00",
                protoMsg.getField(descriptor.findFieldByName("ts_picos")));
          }
        }
      }
    } finally {
      doReturn(false).when(connection).isEnableTimestampPicos();
      Locale.setDefault(origLocale);
      TimeZone.setDefault(origZone);
    }
  }

  @Test
  public void testWriteApiCompatibilityAndParameterizedNumericBounds() throws Exception {
    // Unsupported RANGE field leaves insertSchema null.
    Schema rangeSchema =
        Schema.of(
            Field.newBuilder("rng", StandardSQLTypeName.RANGE)
                .setRangeElementType(FieldElementType.newBuilder().setType("DATE").build())
                .build());
    doReturn(
            mockInsertDryRunJob(
                TableId.of("proj", "ds", "TAB"),
                rangeSchema,
                Collections.singletonList(queryParam("STRING"))))
        .when(bigQuery)
        .create(any(JobInfo.class));
    assertNull(
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?)").insertSchema);

    Schema schema =
        Schema.of(
            Field.newBuilder("req_str", StandardSQLTypeName.STRING)
                .setMode(Field.Mode.REQUIRED)
                .build(),
            Field.newBuilder("n5_2", StandardSQLTypeName.NUMERIC)
                .setPrecision(5L)
                .setScale(2L)
                .build(),
            Field.of("flt_col", StandardSQLTypeName.FLOAT64),
            Field.of("d_col", StandardSQLTypeName.DATE),
            Field.of("dt_col", StandardSQLTypeName.DATETIME),
            Field.of("ts_col", StandardSQLTypeName.TIMESTAMP),
            Field.of("json_col", StandardSQLTypeName.JSON));
    doReturn(
            mockInsertDryRunJob(
                TableId.of("proj", "ds", "TAB"),
                schema,
                Arrays.asList(
                    queryParam("STRING"),
                    queryParam("NUMERIC"),
                    queryParam("FLOAT64"),
                    queryParam("DATE"),
                    queryParam("STRING"),
                    queryParam("TIMESTAMP"),
                    queryParam("JSON"))))
        .when(bigQuery)
        .create(any(JobInfo.class));

    BigQueryPreparedStatement ps =
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?, ?, ?, ?, ?, ?, ?)");

    // Valid values (including trailing zeros "12.3400", INT64 999 on NUMERIC(5,2), null JSON).
    BatchRowBinder validRow =
        i -> {
          ps.setString(1, "v" + i);
          ps.setBigDecimal(2, new BigDecimal("12.3400"));
          ps.setDouble(3, 1.5d);
          ps.setObject(4, LocalDate.of(2026, 11, 18));
          ps.setObject(5, LocalDateTime.of(2026, 11, 18, 10, 20, 30));
          ps.setTimestamp(6, Timestamp.from(Instant.parse("2026-11-18T10:20:30Z")));
          ps.setNull(7, Types.OTHER);
        };
    populateBatchAndAssertWriteApi(ps, 3, validRow, true);
    populateBatchAndAssertWriteApi(
        ps,
        3,
        i -> {
          validRow.bindRow(i);
          ps.setInt(2, 999);
        },
        true);

    // Incompatible / out-of-range bindings fall back cleanly to standard SQL DML.
    for (BatchRowBinder invalidOverride :
        Arrays.<BatchRowBinder>asList(
            i -> ps.setNull(1, Types.VARCHAR), // NULL on REQUIRED
            i -> ps.setInt(1, 99), // INT64 into STRING
            i -> ps.setBigDecimal(2, new BigDecimal("1234.50")), // 4 int digits > 5 - 2
            i -> ps.setBigDecimal(2, new BigDecimal("12.345")), // scale 3 > 2
            i -> ps.setInt(2, 1000), // INT64 4 int digits > 5 - 2
            i -> ps.setObject(2, BigInteger.TEN, Types.BIGINT),
            i -> ps.setDouble(3, Double.NaN),
            i -> ps.setObject(4, LocalDate.of(10000, 1, 1)),
            i -> ps.setString(5, "2026-11-18 10:20:30"),
            i -> ps.setObject(6, LocalDateTime.of(2026, 11, 18, 10, 20, 30)),
            i -> ps.setTimestamp(6, Timestamp.from(Instant.parse("+10000-01-01T00:00:00Z"))),
            i -> ps.setString(7, "{\"k\":1}"))) {
      populateBatchAndAssertWriteApi(
          ps,
          3,
          i -> {
            validRow.bindRow(i);
            invalidOverride.bindRow(i);
          },
          false);
    }
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
            "INSERT INTO proj:123_ds.tab (c1) -- mac line ending\rVALUES (?)",
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
        "INSERT INTO TAB (TARG_FIELD) VALUES (UDF(CAST(? AS STRING), 'XXXXXX'))",
        "INSERT INTO TAB (STR_FIELD) VALUES (MASK_UDF(?))",
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
        "INSERT INTO TAB (1col) VALUES (?)",
        "INSERT INTO TAB (`bad\\nescape`) VALUES (?)",
        "INSERT INTO `` VALUES (?)",
        "INSERT INTO TAB (a) VALUES (?); INSERT INTO TAB (a) VALUES (?)",
        "/* unclosed comment INSERT INTO TAB VALUES (?)"
      })
  public void testParseDirectInsertValuesRejectsIneligibleSql(String sql) {
    assertNull(BigQueryPreparedStatement.parseDirectInsertValues(null));
    assertNull(BigQueryPreparedStatement.parseDirectInsertValues(sql));
  }

  static Stream<Arguments> expressionFallbackQueries() {
    return Stream.of(
        Arguments.of(
            "INSERT INTO TAB (STR_FIELD) VALUES (MASK_UDF(?));", StandardSQLTypeName.STRING),
        Arguments.of(
            "INSERT INTO TAB (TARG_FIELD) VALUES (UDF(CAST(? AS STRING), 'XXXXXX'));",
            StandardSQLTypeName.BYTES));
  }

  @ParameterizedTest
  @MethodSource("expressionFallbackQueries")
  public void testExpressionInValuesFallsBackToStandardSqlBatch(
      String sql, StandardSQLTypeName targetColType) throws Exception {
    doReturn(
            mockInsertDryRunJob(
                TableId.of("proj", "ds", "TAB"),
                Schema.of(Field.of("COL", targetColType)),
                Collections.singletonList(queryParam("STRING"))))
        .when(bigQuery)
        .create(any(JobInfo.class));

    TableResult dmlResult = mock(TableResult.class);
    doReturn(StatementType.INSERT).when(dmlResult).getStatementType();
    doReturn(1L).when(dmlResult).getNumDmlAffectedRows();
    doReturn(dmlResult).when(bigQuery).queryWithTimeout(any(), any(), any());

    BigQueryPreparedStatement ps = new BigQueryPreparedStatement(connection, sql);
    assertNull(ps.insertSchema);
    for (int i = 0; i < 3; i++) {
      ps.setString(1, "val-" + i);
      ps.addBatch();
    }
    assertFalse(ps.useWriteAPI());
    assertEquals(3, ps.executeBatch().length);
    verify(connection, never()).getBigQueryWriteClient();
    verify(bigQuery, times(1)).create(any(JobInfo.class));

    ArgumentCaptor<QueryJobConfiguration> jobCaptor =
        ArgumentCaptor.forClass(QueryJobConfiguration.class);
    verify(bigQuery).queryWithTimeout(jobCaptor.capture(), any(), any());
    assertEquals(3, jobCaptor.getValue().getPositionalParameters().size());
    assertEquals("val-0", jobCaptor.getValue().getPositionalParameters().get(0).getValue());
  }

  @Test
  public void testResolveInsertSchemaAndReorderedColumnExecution() throws Exception {
    Schema twoCol =
        Schema.of(
            Field.of("id", StandardSQLTypeName.INT64),
            Field.of("name", StandardSQLTypeName.STRING));
    BigQueryPreparedStatement.DirectInsertShape reordered =
        BigQueryPreparedStatement.parseDirectInsertValues(
            "INSERT INTO TAB (NAME, id) VALUES (?, ?)");
    Schema resolved = BigQueryPreparedStatement.resolveInsertSchema(twoCol, reordered, 2);
    assertEquals("name", resolved.getFields().get(0).getName());
    assertEquals("id", resolved.getFields().get(1).getName());

    // Subset, duplicate, and unknown/pseudo columns return null.
    for (String badSql :
        new String[] {
          "INSERT INTO TAB (id) VALUES (?)",
          "INSERT INTO TAB (id, ID) VALUES (?, ?)",
          "INSERT INTO TAB (id, _PARTITIONTIME) VALUES (?, ?)"
        }) {
      BigQueryPreparedStatement.DirectInsertShape s =
          BigQueryPreparedStatement.parseDirectInsertValues(badSql);
      assertNull(BigQueryPreparedStatement.resolveInsertSchema(twoCol, s, s.placeholderCount));
    }

    // All 14 scalar/temporal/special types accepted; REPEATED, STRUCT, and RANGE rejected.
    BigQueryPreparedStatement.DirectInsertShape singleShape =
        BigQueryPreparedStatement.parseDirectInsertValues("INSERT INTO TAB VALUES (?)");
    for (StandardSQLTypeName t :
        new StandardSQLTypeName[] {
          StandardSQLTypeName.STRING, StandardSQLTypeName.BYTES, StandardSQLTypeName.INT64,
          StandardSQLTypeName.FLOAT64, StandardSQLTypeName.NUMERIC, StandardSQLTypeName.BIGNUMERIC,
          StandardSQLTypeName.BOOL, StandardSQLTypeName.DATE, StandardSQLTypeName.TIME,
          StandardSQLTypeName.DATETIME, StandardSQLTypeName.TIMESTAMP, StandardSQLTypeName.JSON,
          StandardSQLTypeName.GEOGRAPHY, StandardSQLTypeName.INTERVAL
        }) {
      assertNotNull(
          BigQueryPreparedStatement.resolveInsertSchema(
              Schema.of(Field.of("c", t)), singleShape, 1));
    }
    assertNull(
        BigQueryPreparedStatement.resolveInsertSchema(
            Schema.of(
                Field.newBuilder("arr", StandardSQLTypeName.STRING)
                    .setMode(Field.Mode.REPEATED)
                    .build()),
            singleShape,
            1));
    assertNull(
        BigQueryPreparedStatement.resolveInsertSchema(
            Schema.of(
                Field.of(
                    "rec", StandardSQLTypeName.STRUCT, Field.of("s", StandardSQLTypeName.INT64))),
            singleShape,
            1));

    // End-to-end reordered executeBatch maps placeholder 1 -> "name" and placeholder 2 -> "id".
    doReturn(
            mockInsertDryRunJob(
                TableId.of("proj", "ds", "TAB"),
                twoCol,
                Arrays.asList(queryParam("STRING"), queryParam("INT64"))))
        .when(bigQuery)
        .create(any(JobInfo.class));
    stubWriteClient(3L, true);
    JsonStreamWriter mockWriter = mock(JsonStreamWriter.class);
    when(mockWriter.append(any(JsonArray.class), anyLong()))
        .thenReturn(ApiFutures.immediateFuture(AppendRowsResponse.getDefaultInstance()));

    BigQueryPreparedStatement ps =
        newWriteApiPreparedStatement("INSERT INTO TAB (name, id) VALUES (?, ?)", mockWriter);
    for (int i = 0; i < 3; i++) {
      ps.setString(1, "u-" + i);
      ps.setInt(2, 10 + i);
      ps.addBatch();
    }
    assertArrayEquals(new int[] {1, 1, 1}, ps.executeBatch());
    ArgumentCaptor<JsonArray> rowsCaptor = ArgumentCaptor.forClass(JsonArray.class);
    verify(mockWriter).append(rowsCaptor.capture(), anyLong());
    JsonObject firstRow = rowsCaptor.getValue().get(0).getAsJsonObject();
    assertEquals("u-0", firstRow.get("name").getAsString());
    assertEquals("10", firstRow.get("id").getAsString());
  }

  @Test
  public void testTargetProjectTransactionsSessionsLegacySqlAndRetryDryRun() throws Exception {
    // 1. Legacy SQL skips positional dry run in constructor.
    doReturn("BIG_QUERY").when(connection).getQueryDialect();
    assertEquals(
        1, new BigQueryPreparedStatement(connection, "SELECT ? FROM [proj:ds.tab]").parameterCount);
    verify(bigQuery, never()).create(any(JobInfo.class));
    doReturn("SQL").when(connection).getQueryDialect();

    // 2. Active transaction & active session anonymous "_" dataset gating.
    Schema oneStr = Schema.of(Field.of("c1", StandardSQLTypeName.STRING));
    doReturn(
            mockInsertDryRunJob(
                TableId.of("proj", "_anon_session_ds", "TAB"),
                oneStr,
                Collections.singletonList(queryParam("STRING"))))
        .when(bigQuery)
        .create(any(JobInfo.class));
    BigQueryPreparedStatement psGate =
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?)");
    populateBatchAndAssertWriteApi(psGate, 3, i -> psGate.setString(1, "v" + i), true);
    doReturn(true).when(connection).isTransactionStarted();
    assertFalse(psGate.useWriteAPI());
    doReturn(false).when(connection).isTransactionStarted();

    doReturn(
            new BigQueryConnection.SessionState(
                ConnectionProperty.of("session_id", "s1"), Collections.emptyList(), true))
        .when(connection)
        .getSessionStateSnapshot();
    assertFalse(psGate.useWriteAPI());
    doReturn(DatasetId.of("proj", "_anon_session_ds")).when(connection).getDefaultDataset();
    BigQueryPreparedStatement psExplicitHidden =
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?)");
    populateBatchAndAssertWriteApi(
        psExplicitHidden, 3, i -> psExplicitHidden.setString(1, "v" + i), true);
    doReturn(BigQueryConnection.SessionState.empty()).when(connection).getSessionStateSnapshot();

    // 3. Target project resolution: other_ds uses catalog-proj; default_ds uses default-proj.
    doReturn("catalog-proj").when(connection).getCatalog();
    doReturn(DatasetId.of("default-proj", "default_ds")).when(connection).getDefaultDataset();
    BigQueryWriteClient writeClient = stubWriteClient(3L, true);
    JsonStreamWriter okWriter = mock(JsonStreamWriter.class);
    when(okWriter.append(any(JsonArray.class), anyLong()))
        .thenReturn(ApiFutures.immediateFuture(AppendRowsResponse.getDefaultInstance()));
    for (String[] dsAndExpectedProj :
        new String[][] {{"other_ds", "catalog-proj"}, {"default_ds", "default-proj"}}) {
      doReturn(
              mockInsertDryRunJob(
                  TableId.of(dsAndExpectedProj[0], "TAB"),
                  oneStr,
                  Collections.singletonList(queryParam("STRING"))))
          .when(bigQuery)
          .create(any(JobInfo.class));
      BigQueryPreparedStatement psProj =
          newWriteApiPreparedStatement(
              "INSERT INTO " + dsAndExpectedProj[0] + ".TAB VALUES (?)", okWriter);
      for (int i = 0; i < 3; i++) {
        psProj.setString(1, "v" + i);
        psProj.addBatch();
      }
      psProj.executeBatch();
    }
    ArgumentCaptor<CreateWriteStreamRequest> parentCaptor =
        ArgumentCaptor.forClass(CreateWriteStreamRequest.class);
    verify(writeClient, times(2)).createWriteStream(parentCaptor.capture());
    assertEquals(
        "projects/catalog-proj/datasets/other_ds/tables/TAB",
        parentCaptor.getAllValues().get(0).getParent());
    assertEquals(
        "projects/default-proj/datasets/default_ds/tables/TAB",
        parentCaptor.getAllValues().get(1).getParent());

    // 4. Retry dry run uses unbound query, and runs at most once even if it returns null or throws.
    TableResult dmlResult = mock(TableResult.class);
    doReturn(StatementType.INSERT).when(dmlResult).getStatementType();
    doReturn(1L).when(dmlResult).getNumDmlAffectedRows();
    doReturn(dmlResult).when(bigQuery).queryWithTimeout(any(), any(), any());

    clearInvocations(bigQuery);
    Job intJob =
        mockInsertDryRunJob(
            TableId.of("proj", "ds", "TAB"),
            Schema.of(Field.of("n", StandardSQLTypeName.INT64)),
            Collections.singletonList(queryParam("INT64")));
    when(bigQuery.create(any(JobInfo.class)))
        .thenThrow(new BigQueryException(404, "Not found"))
        .thenReturn(intJob);
    BigQueryPreparedStatement psRetry =
        new BigQueryPreparedStatement(connection, "INSERT INTO ds.TAB (n) VALUES (?)");
    for (int i = 0; i < 3; i++) {
      psRetry.setNull(1, Types.OTHER);
      psRetry.addBatch();
    }
    psRetry.executeBatch();
    assertNotNull(psRetry.insertSchema);
    ArgumentCaptor<JobInfo> jobCaptor = ArgumentCaptor.forClass(JobInfo.class);
    verify(bigQuery, times(2)).create(jobCaptor.capture());
    QueryJobConfiguration retryCfg = jobCaptor.getAllValues().get(1).getConfiguration();
    assertTrue(
        retryCfg.getPositionalParameters() == null || retryCfg.getPositionalParameters().isEmpty());

    // Retry dry run returning null statistics OR throwing does NOT retry on 2nd executeBatch.
    for (boolean throwOnRetry : new boolean[] {false, true}) {
      clearInvocations(bigQuery);
      if (throwOnRetry) {
        when(bigQuery.create(any(JobInfo.class))).thenThrow(new BigQueryException(403, "Denied"));
      } else {
        when(bigQuery.create(any(JobInfo.class)))
            .thenThrow(new BigQueryException(404, "Not found"))
            .thenReturn(mock(Job.class));
      }
      BigQueryPreparedStatement psOnce =
          new BigQueryPreparedStatement(connection, "INSERT INTO ds.TAB (n) VALUES (?)");
      for (int b = 0; b < 2; b++) {
        for (int i = 0; i < 3; i++) {
          psOnce.setLong(1, i);
          psOnce.addBatch();
        }
        psOnce.executeBatch();
      }
      verify(bigQuery, times(2)).create(any(JobInfo.class));
    }
  }
}
