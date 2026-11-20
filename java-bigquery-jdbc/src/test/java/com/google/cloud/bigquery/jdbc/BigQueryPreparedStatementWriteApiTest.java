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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.services.bigquery.model.QueryParameter;
import com.google.api.services.bigquery.model.QueryParameterType;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.ConnectionProperty;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.Field;
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
import com.google.cloud.bigquery.jdbc.telemetry.v1.Status;
import com.google.cloud.bigquery.jdbc.telemetry.v1.TelemetryManager;
import com.google.cloud.bigquery.storage.v1.AppendRowsRequest;
import com.google.cloud.bigquery.storage.v1.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1.BQTableSchemaToProtoDescriptor;
import com.google.cloud.bigquery.storage.v1.BatchCommitWriteStreamsRequest;
import com.google.cloud.bigquery.storage.v1.BatchCommitWriteStreamsResponse;
import com.google.cloud.bigquery.storage.v1.BigDecimalByteStringEncoder;
import com.google.cloud.bigquery.storage.v1.BigQuerySchemaUtil;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteGrpc;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteSettings;
import com.google.cloud.bigquery.storage.v1.CivilTimeEncoder;
import com.google.cloud.bigquery.storage.v1.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1.FinalizeWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1.FinalizeWriteStreamResponse;
import com.google.cloud.bigquery.storage.v1.StorageError;
import com.google.cloud.bigquery.storage.v1.TableFieldSchema;
import com.google.cloud.bigquery.storage.v1.TableSchema;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import com.google.gson.JsonObject;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Int64Value;
import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;
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
    doReturn(2).when(connection).getWriteAPIAppendRowCount();
  }

  private static QueryParameter queryParam(String typeName) {
    return new QueryParameter().setParameterType(new QueryParameterType().setType(typeName));
  }

  private static Job mockInsertDryRunJob(
      TableId targetTable, Schema schema, List<QueryParameter> params) {
    Job job = mock(Job.class);
    QueryStatistics stats = mock(QueryStatistics.class);
    when(job.getStatistics()).thenReturn(stats);
    when(stats.getStatementType()).thenReturn(StatementType.INSERT);
    when(stats.getSchema()).thenReturn(schema);
    when(stats.getReferencedTables()).thenReturn(Collections.singletonList(targetTable));
    when(stats.getQueryParameters()).thenReturn(params);
    return job;
  }

  private BigQueryWriteClient stubCommitClient(boolean hasCommitTime) {
    BigQueryWriteClient client = mock(BigQueryWriteClient.class);
    BatchCommitWriteStreamsResponse.Builder commit = BatchCommitWriteStreamsResponse.newBuilder();
    if (hasCommitTime) {
      commit.getCommitTimeBuilder().setSeconds(1700000000L);
    } else {
      commit.addStreamErrors(StorageError.newBuilder().setErrorMessage("stream already committed"));
    }
    when(client.batchCommitWriteStreams(any(BatchCommitWriteStreamsRequest.class)))
        .thenReturn(commit.build());
    doReturn(client).when(connection).getBigQueryWriteClient();
    return client;
  }

  private BigQueryPreparedStatement newStatementWithWriter(
      String sql, BigQueryJdbcBulkInsertWriter bulkWriter) throws SQLException {
    return new BigQueryPreparedStatement(connection, sql) {
      @Override
      BigQueryJdbcBulkInsertWriter createBulkInsertWriter() {
        return bulkWriter;
      }
    };
  }

  @Test
  public void testNullQueryEmptyBatchUnboundParametersClearBatchAndClose() throws Exception {
    assertThrows(
        BigQueryJdbcException.class, () -> new BigQueryPreparedStatement(connection, null));

    when(bigQuery.create(any(JobInfo.class))).thenThrow(new BigQueryException(500, "no dry run"));
    BigQueryPreparedStatement ps =
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?, ?)");
    assertArrayEquals(new int[0], ps.executeBatch());

    // Sparse binding (param 2 set, param 1 unset) fails validation and clears batch queue in
    // finally.
    ps.setString(2, "only-second");
    ps.addBatch();
    BigQueryJdbcException missing = assertThrows(BigQueryJdbcException.class, ps::executeBatch);
    assertTrue(missing.getMessage().contains("parameter 1 of 2"));
    assertArrayEquals(new int[0], ps.executeBatch());

    ps.setString(1, "a");
    ps.setString(2, "b");
    ps.addBatch();
    ps.clearBatch();
    assertArrayEquals(new int[0], ps.executeBatch());

    ps.addBatch();
    ps.close();
    assertTrue(ps.isClosed());
  }

  @Test
  public void testExecuteBatchKeepsWriteClientOpenAcrossBatchesAndWrapsErrors() throws Exception {
    doReturn(
            mockInsertDryRunJob(
                TableId.of("proj", "ds", "TAB"),
                Schema.of(Field.of("c1", StandardSQLTypeName.STRING)),
                Collections.singletonList(queryParam("STRING"))))
        .when(bigQuery)
        .create(any(JobInfo.class));

    BigQueryWriteClient writeClient = stubCommitClient(true);
    Descriptor singleStrDescriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(
            TableSchema.newBuilder()
                .addFields(
                    TableFieldSchema.newBuilder()
                        .setName("c1")
                        .setType(TableFieldSchema.Type.STRING)
                        .setMode(TableFieldSchema.Mode.NULLABLE))
                .build());
    BigQueryJdbcBulkInsertWriter okWriter = mock(BigQueryJdbcBulkInsertWriter.class);
    when(okWriter.getStreamName()).thenReturn(STREAM_NAME);
    when(okWriter.getDescriptor()).thenReturn(singleStrDescriptor);
    when(okWriter.cleanup(writeClient)).thenReturn(3L);

    BigQueryPreparedStatement ps = newStatementWithWriter("INSERT INTO TAB VALUES (?)", okWriter);
    for (int batch = 0; batch < 2; batch++) {
      for (int i = 0; i < 3; i++) {
        ps.setString(1, "v" + i);
        ps.addBatch();
      }
      assertArrayEquals(new int[] {1, 1, 1}, ps.executeBatch());
    }
    verify(writeClient, never()).close();
    verify(writeClient, times(2))
        .batchCommitWriteStreams(any(BatchCommitWriteStreamsRequest.class));
    assertArrayEquals(new int[0], ps.executeBatch());

    // Missing commit timestamp throws BigQueryJdbcException and records STATUS_ERROR telemetry.
    stubCommitClient(false);
    when(okWriter.cleanup(any())).thenReturn(3L);
    try (MockedStatic<TelemetryManager> telemetry =
        mockStatic(TelemetryManager.class, CALLS_REAL_METHODS)) {
      for (int i = 0; i < 3; i++) {
        ps.setString(1, "r" + i);
        ps.addBatch();
      }
      String commitErrMsg =
          assertThrows(BigQueryJdbcException.class, ps::executeBatch).getMessage();
      assertTrue(commitErrMsg.contains("Error committing the streams"));
      assertTrue(commitErrMsg.contains("stream already committed"));
      ArgumentCaptor<StatementExecution.Builder> cap =
          ArgumentCaptor.forClass(StatementExecution.Builder.class);
      telemetry.verify(() -> TelemetryManager.recordStatementExecution(cap.capture(), anyLong()));
      assertEquals(QueryApiType.QUERY_API_TYPE_WRITE_API, cap.getValue().getQueryApiType());
      assertEquals(Status.STATUS_ERROR, cap.getValue().getStatus());
    }

    // IOException and InterruptedException wrap in BigQueryJdbcException (restoring interrupt
    // flag).
    IOException ioEx = new IOException("io failure");
    BigQueryJdbcBulkInsertWriter ioFailWriter = mock(BigQueryJdbcBulkInsertWriter.class);
    doThrow(ioEx).when(ioFailWriter).initialize(any(), any(), any());
    BigQueryPreparedStatement psIo =
        newStatementWithWriter("INSERT INTO TAB VALUES (?)", ioFailWriter);
    for (int i = 0; i < 3; i++) {
      psIo.setString(1, "r" + i);
      psIo.addBatch();
    }
    assertSame(ioEx, assertThrows(BigQueryJdbcException.class, psIo::executeBatch).getCause());
    verify(ioFailWriter, times(1)).closeQuietly();

    BigQueryJdbcBulkInsertWriter interruptWriter = mock(BigQueryJdbcBulkInsertWriter.class);
    doThrow(new InterruptedException("stop")).when(interruptWriter).initialize(any(), any(), any());
    BigQueryPreparedStatement psInt =
        newStatementWithWriter("INSERT INTO TAB VALUES (?)", interruptWriter);
    for (int i = 0; i < 3; i++) {
      psInt.setString(1, "r" + i);
      psInt.addBatch();
    }
    try {
      BigQueryJdbcException ex = assertThrows(BigQueryJdbcException.class, psInt::executeBatch);
      assertTrue(ex.getCause() instanceof InterruptedException);
      assertTrue(Thread.currentThread().isInterrupted());
    } finally {
      Thread.interrupted();
    }
  }

  private static final class InProcessWriteServer implements AutoCloseable {
    final List<String> createParents = new CopyOnWriteArrayList<>();
    final List<AppendRowsRequest> appendRequests = new CopyOnWriteArrayList<>();
    final Descriptor descriptor;
    final Server server;
    final ManagedChannel channel;
    final BigQueryWriteClient client;

    InProcessWriteServer(TableSchema tableSchema) throws Exception {
      TableSchema.Builder lowerSchema = tableSchema.toBuilder().clearFields();
      for (TableFieldSchema f : tableSchema.getFieldsList()) {
        lowerSchema.addFields(f.toBuilder().setName(f.getName().toLowerCase(Locale.ROOT)).build());
      }
      this.descriptor =
          BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(lowerSchema.build());
      String name = InProcessServerBuilder.generateName();
      BigQueryWriteGrpc.BigQueryWriteImplBase svc =
          new BigQueryWriteGrpc.BigQueryWriteImplBase() {
            @Override
            public void createWriteStream(
                CreateWriteStreamRequest req, StreamObserver<WriteStream> obs) {
              createParents.add(req.getParent());
              obs.onNext(
                  WriteStream.newBuilder()
                      .setName(req.getParent() + "/streams/_p1")
                      .setType(WriteStream.Type.PENDING)
                      .setTableSchema(tableSchema)
                      .build());
              obs.onCompleted();
            }

            @Override
            public StreamObserver<AppendRowsRequest> appendRows(
                StreamObserver<AppendRowsResponse> responseObserver) {
              return new StreamObserver<AppendRowsRequest>() {
                @Override
                public void onNext(AppendRowsRequest req) {
                  appendRequests.add(req);
                  responseObserver.onNext(
                      AppendRowsResponse.newBuilder()
                          .setAppendResult(
                              AppendRowsResponse.AppendResult.newBuilder()
                                  .setOffset(req.getOffset()))
                          .build());
                }

                @Override
                public void onError(Throwable t) {
                  responseObserver.onError(t);
                }

                @Override
                public void onCompleted() {
                  responseObserver.onCompleted();
                }
              };
            }

            @Override
            public void finalizeWriteStream(
                FinalizeWriteStreamRequest req, StreamObserver<FinalizeWriteStreamResponse> obs) {
              long rows =
                  appendRequests.stream()
                      .mapToLong(r -> r.getProtoRows().getRows().getSerializedRowsCount())
                      .sum();
              obs.onNext(FinalizeWriteStreamResponse.newBuilder().setRowCount(rows).build());
              obs.onCompleted();
            }

            @Override
            public void batchCommitWriteStreams(
                BatchCommitWriteStreamsRequest req,
                StreamObserver<BatchCommitWriteStreamsResponse> obs) {
              BatchCommitWriteStreamsResponse.Builder res =
                  BatchCommitWriteStreamsResponse.newBuilder();
              res.getCommitTimeBuilder().setSeconds(1700000000L);
              obs.onNext(res.build());
              obs.onCompleted();
            }
          };
      this.server = InProcessServerBuilder.forName(name).directExecutor().addService(svc).build();
      this.server.start();
      this.channel = InProcessChannelBuilder.forName(name).directExecutor().build();
      this.client =
          BigQueryWriteClient.create(
              BigQueryWriteSettings.newBuilder()
                  .setTransportChannelProvider(
                      FixedTransportChannelProvider.create(GrpcTransportChannel.create(channel)))
                  .setCredentialsProvider(NoCredentialsProvider.create())
                  .build());
    }

    List<DynamicMessage> decodedRows() throws Exception {
      List<DynamicMessage> out = new ArrayList<>();
      for (AppendRowsRequest req : appendRequests) {
        for (ByteString rowBytes : req.getProtoRows().getRows().getSerializedRowsList()) {
          out.add(DynamicMessage.parseFrom(descriptor, rowBytes));
        }
      }
      return out;
    }

    @Override
    public void close() {
      client.close();
      channel.shutdownNow();
      server.shutdownNow();
    }
  }

  private static TableFieldSchema tfs(String name, TableFieldSchema.Type type) {
    return TableFieldSchema.newBuilder()
        .setName(name)
        .setType(type)
        .setMode(TableFieldSchema.Mode.NULLABLE)
        .build();
  }

  @Test
  public void testAllSupportedTypesEndToEndProtoSchemaParityAcrossLocalesZonesAndPicos()
      throws Exception {
    Object[][] cols = {
      {"col-é", StandardSQLTypeName.STRING, TableFieldSchema.Type.STRING, 0L},
      {"c_bytes", StandardSQLTypeName.BYTES, TableFieldSchema.Type.BYTES, 0L},
      {"C_INT", StandardSQLTypeName.INT64, TableFieldSchema.Type.INT64, 0L},
      {"c_flt", StandardSQLTypeName.FLOAT64, TableFieldSchema.Type.DOUBLE, 0L},
      {"c_num", StandardSQLTypeName.NUMERIC, TableFieldSchema.Type.NUMERIC, 0L},
      {"c_bnum", StandardSQLTypeName.BIGNUMERIC, TableFieldSchema.Type.BIGNUMERIC, 0L},
      {"c_bool", StandardSQLTypeName.BOOL, TableFieldSchema.Type.BOOL, 0L},
      {"c_date", StandardSQLTypeName.DATE, TableFieldSchema.Type.DATE, 0L},
      {"c_time", StandardSQLTypeName.TIME, TableFieldSchema.Type.TIME, 0L},
      {"c_dt", StandardSQLTypeName.DATETIME, TableFieldSchema.Type.DATETIME, 0L},
      {"c_ts6", StandardSQLTypeName.TIMESTAMP, TableFieldSchema.Type.TIMESTAMP, 0L},
      {"c_ts12", StandardSQLTypeName.TIMESTAMP, TableFieldSchema.Type.TIMESTAMP, 12L},
      {"c_json", StandardSQLTypeName.JSON, TableFieldSchema.Type.JSON, 0L},
      {"c_geo", StandardSQLTypeName.GEOGRAPHY, TableFieldSchema.Type.GEOGRAPHY, 0L},
      {"c_iv", StandardSQLTypeName.INTERVAL, TableFieldSchema.Type.INTERVAL, 0L}
    };
    List<Field> bqFields = new ArrayList<>();
    List<QueryParameter> inferred = new ArrayList<>();
    TableSchema.Builder storageBuilder = TableSchema.newBuilder();
    for (Object[] col : cols) {
      String name = (String) col[0];
      StandardSQLTypeName sqlType = (StandardSQLTypeName) col[1];
      bqFields.add(Field.of(name, sqlType));
      inferred.add(queryParam(sqlType.name()));
      TableFieldSchema.Builder fb = tfs(name, (TableFieldSchema.Type) col[2]).toBuilder();
      if ((Long) col[3] > 0) {
        fb.setTimestampPrecision(Int64Value.of((Long) col[3]));
      }
      storageBuilder.addFields(fb.build());
    }
    Schema bqSchema = Schema.of(bqFields);
    TableSchema storageSchema = storageBuilder.build();

    Locale savedLocale = Locale.getDefault();
    TimeZone savedZone = TimeZone.getDefault();
    Locale[] locales = {Locale.US, Locale.FRANCE, Locale.JAPAN, Locale.forLanguageTag("tr-TR")};
    String[] zones = {"UTC", "America/New_York", "Asia/Tokyo", "Europe/Istanbul"};
    try (InProcessWriteServer srv = new InProcessWriteServer(storageSchema)) {
      doReturn(srv.client).when(connection).getBigQueryWriteClient();
      doReturn(mockInsertDryRunJob(TableId.of("proj", "ds", "TAB"), bqSchema, inferred))
          .when(bigQuery)
          .create(any(JobInfo.class));

      for (int idx = 0; idx < locales.length; idx++) {
        Locale.setDefault(locales[idx]);
        TimeZone.setDefault(TimeZone.getTimeZone(zones[idx]));
        for (boolean picos : new boolean[] {false, true}) {
          srv.appendRequests.clear();
          doReturn(picos).when(connection).isEnableTimestampPicos();
          BigQueryPreparedStatement ps =
              new BigQueryPreparedStatement(
                  connection, "INSERT INTO TAB VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

          byte[] rawBytes = new byte[] {-128, 0, 127};
          JsonObject jsonVal = new JsonObject();
          jsonVal.addProperty("k", 7);

          // Row 0: JSR-310, pre-1582 date, pre-1970 sub-micros instant, float 0.6f, trailing zeros.
          BigDecimal bigNumericMax =
              new BigDecimal(
                  "578960446186580977117854925043439539266.34992332820282019728792003956564819967");
          ps.setString(1, "héllo");
          ps.setBytes(2, rawBytes);
          ps.setShort(3, (short) -42);
          ps.setFloat(4, 0.6f);
          ps.setBigDecimal(5, new BigDecimal("12.3400000000"));
          ps.setBigDecimal(6, bigNumericMax);
          ps.parameterHandler
              .parametersList
              .get(5)
              .bindType(BigDecimal.class, StandardSQLTypeName.BIGNUMERIC);
          ps.setBoolean(7, true);
          ps.setObject(8, LocalDate.of(1500, 1, 1));
          ps.setObject(9, LocalTime.of(14, 30, 45, 123_456_789));
          ps.setObject(10, LocalDateTime.of(2026, 8, 24, 15, 30, 45, 987_654_321));
          ps.setObject(11, Instant.parse("1969-12-31T23:59:59.999999900Z"));
          ps.setTimestamp(12, Timestamp.from(Instant.parse("2024-01-01T12:34:56.123456789Z")));
          ps.setObject(13, jsonVal);
          ps.parameterHandler.setParameter(14, "POINT(-122.33 47.61)", String.class);
          ps.parameterHandler
              .parametersList
              .get(13)
              .bindType(String.class, StandardSQLTypeName.GEOGRAPHY);
          ps.parameterHandler.setParameter(15, "1-2 3 4:5:6.000078", String.class);
          ps.parameterHandler
              .parametersList
              .get(14)
              .bindType(String.class, StandardSQLTypeName.INTERVAL);
          List<QueryParameterValue> restRow0 = new ArrayList<>();
          for (BigQueryJdbcParameter param : ps.parameterHandler.parametersList) {
            restRow0.add(BigQueryParameterHandler.toQueryParameterValue(param, picos));
          }
          ps.addBatch();

          // Row 1: Legacy java.sql types + OffsetDateTime + NUMERIC->BIGNUMERIC 0E+50 widening.
          ps.setString(1, "legacy");
          ps.setBytes(2, new byte[0]);
          ps.setByte(3, (byte) 9);
          ps.setDouble(4, -123.5d);
          ps.setBigDecimal(5, new BigDecimal("-99999999999999999999999999999.999999999"));
          ps.setBigDecimal(6, new BigDecimal("0E+50"));
          ps.setBoolean(7, false);
          ps.setDate(8, Date.valueOf("2026-08-24"));
          ps.setTime(9, Time.valueOf("08:09:10"));
          ps.setString(10, "2026-08-24 08:09:10.000000");
          ps.setObject(
              11, OffsetDateTime.of(2024, 1, 1, 18, 4, 56, 123_456_000, ZoneOffset.ofHours(5)));
          ps.setObject(12, Instant.parse("0001-01-01T00:00:00Z"));
          ps.setNull(13, Types.OTHER);
          ps.setNull(14, Types.OTHER);
          ps.setNull(15, Types.OTHER);
          ps.addBatch();

          // Row 2: All NULLs.
          for (int c = 1; c <= 15; c++) {
            ps.setObject(c, null);
          }
          ps.addBatch();

          assertArrayEquals(new int[] {1, 1, 1}, ps.executeBatch());
          List<DynamicMessage> rows = srv.decodedRows();
          assertEquals(3, rows.size());

          Descriptor d = srv.descriptor;
          DynamicMessage r0 = rows.get(0);
          String col0Proto = BigQuerySchemaUtil.generatePlaceholderFieldName("col-é");
          assertEquals(restRow0.get(0).getValue(), r0.getField(d.findFieldByName(col0Proto)));
          assertArrayEquals(
              Base64.getDecoder().decode(restRow0.get(1).getValue()),
              ((ByteString) r0.getField(d.findFieldByName("c_bytes"))).toByteArray());
          assertEquals(
              Long.parseLong(restRow0.get(2).getValue()), r0.getField(d.findFieldByName("c_int")));
          assertEquals(
              Double.parseDouble(restRow0.get(3).getValue()),
              (Double) r0.getField(d.findFieldByName("c_flt")));
          assertEquals(
              0,
              new BigDecimal(restRow0.get(4).getValue())
                  .compareTo(
                      BigDecimalByteStringEncoder.decodeNumericByteString(
                          (ByteString) r0.getField(d.findFieldByName("c_num")))));
          assertEquals(
              0,
              new BigDecimal(restRow0.get(5).getValue())
                  .compareTo(
                      BigDecimalByteStringEncoder.decodeBigNumericByteString(
                          (ByteString) r0.getField(d.findFieldByName("c_bnum")))));
          assertEquals(
              0,
              BigDecimal.ZERO.compareTo(
                  BigDecimalByteStringEncoder.decodeBigNumericByteString(
                      (ByteString) rows.get(1).getField(d.findFieldByName("c_bnum")))));
          assertEquals(
              Boolean.parseBoolean(restRow0.get(6).getValue()),
              r0.getField(d.findFieldByName("c_bool")));
          assertEquals(
              LocalDate.parse(restRow0.get(7).getValue()),
              LocalDate.ofEpochDay((Integer) r0.getField(d.findFieldByName("c_date"))));
          assertEquals(
              LocalTime.parse(restRow0.get(8).getValue()),
              CivilTimeEncoder.decodePacked64TimeMicrosLocalTime(
                  (Long) r0.getField(d.findFieldByName("c_time"))));
          assertEquals(
              LocalDateTime.parse(restRow0.get(9).getValue().replace(' ', 'T')),
              CivilTimeEncoder.decodePacked64DatetimeMicrosLocalDateTime(
                  (Long) r0.getField(d.findFieldByName("c_dt"))));
          assertEquals(-1L, r0.getField(d.findFieldByName("c_ts6")));
          assertEquals(
              BigQueryParameterHandler.formatInstantUtc(
                  Instant.parse("2024-01-01T12:34:56.123456789Z"), false),
              r0.getField(d.findFieldByName("c_ts12")));
          assertEquals(restRow0.get(12).getValue(), r0.getField(d.findFieldByName("c_json")));
          assertEquals(restRow0.get(13).getValue(), r0.getField(d.findFieldByName("c_geo")));
          assertEquals(restRow0.get(14).getValue(), r0.getField(d.findFieldByName("c_iv")));

          DynamicMessage r2 = rows.get(2);
          for (int f = 1; f <= 15; f++) {
            assertFalse(r2.hasField(d.findFieldByNumber(f)));
          }
        }
      }
    } finally {
      Locale.setDefault(savedLocale);
      TimeZone.setDefault(savedZone);
    }
  }

  @Test
  public void testUnsupportedColumnsAndIncompatibleValuesFallBackToSqlBatch() throws Exception {
    // 1. Complex column types (ARRAY, STRUCT, RANGE) leave insertSchema null.
    for (Field unsupported :
        Arrays.asList(
            Field.newBuilder("a", StandardSQLTypeName.STRING).setMode(Field.Mode.REPEATED).build(),
            Field.newBuilder(
                    "s", StandardSQLTypeName.STRUCT, Field.of("x", StandardSQLTypeName.INT64))
                .build(),
            Field.of("r", StandardSQLTypeName.RANGE))) {
      doReturn(
              mockInsertDryRunJob(
                  TableId.of("proj", "ds", "TAB"),
                  Schema.of(unsupported),
                  Collections.singletonList(queryParam(unsupported.getType().name()))))
          .when(bigQuery)
          .create(any(JobInfo.class));
      BigQueryPreparedStatement ps =
          new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?)");
      assertNull(ps.insertSchema);
    }

    // 2. Incompatible parameter values (REQUIRED null, NUMERIC(5,2) overflow, NaN, String picos)
    // fall back cleanly to runQuery without invoking BigQueryWriteClient.
    Schema constrained =
        Schema.of(
            Field.newBuilder("req", StandardSQLTypeName.STRING)
                .setMode(Field.Mode.REQUIRED)
                .build(),
            Field.newBuilder("num", StandardSQLTypeName.NUMERIC)
                .setPrecision(5L)
                .setScale(2L)
                .build(),
            Field.of("flt", StandardSQLTypeName.FLOAT64),
            Field.of("ts", StandardSQLTypeName.TIMESTAMP));
    doReturn(
            mockInsertDryRunJob(
                TableId.of("proj", "ds", "TAB"),
                constrained,
                Arrays.asList(
                    queryParam("STRING"),
                    queryParam("NUMERIC"),
                    queryParam("FLOAT64"),
                    queryParam("TIMESTAMP"))))
        .when(bigQuery)
        .create(any(JobInfo.class));

    // 2. Each incompatible parameter case (REQUIRED null, NUMERIC(5,2) overflow, NaN on row 1,
    // String picosecond literal) independently triggers fallback to runQuery without WriteClient.
    for (int badCase = 0; badCase < 4; badCase++) {
      BigQueryPreparedStatement ps =
          spy(new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?, ?, ?, ?)"));
      doNothing().when(ps).runQuery(anyString(), any(QueryJobConfiguration.class));
      doReturn(1, 1, 1, 1, 1, 1, -1).when(ps).getUpdateCount();
      doReturn(true, true, false).when(ps).getMoreResults();

      for (int i = 0; i < 3; i++) {
        if (badCase == 0 && i == 1) {
          ps.setNull(1, Types.VARCHAR);
        } else {
          ps.setString(1, "ok");
        }
        ps.setBigDecimal(
            2, badCase == 1 && i == 1 ? new BigDecimal("1000.00") : new BigDecimal("12.34"));
        ps.setDouble(3, badCase == 2 && i == 1 ? Double.NaN : 1.0);
        if (badCase == 3 && i == 1) {
          ps.setString(4, "2024-01-01 12:34:56.123456789012Z");
        } else {
          ps.setTimestamp(4, Timestamp.from(Instant.parse("2024-01-01T12:34:56.123456Z")));
        }
        ps.addBatch();
      }
      assertFalse(ps.useWriteAPI(), "badCase=" + badCase);
      assertArrayEquals(new int[] {1, 1, 1}, ps.executeBatch());
      verify(ps, times(1)).runQuery(anyString(), any(QueryJobConfiguration.class));
    }
    verify(connection, never()).getBigQueryWriteClient();
  }

  private static Stream<Arguments> validDirectInsertQueries() {
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

  private static Stream<Arguments> expressionFallbackQueries() {
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
  public void testResolveInsertSchemaAndReorderedColumnProtoRowsExecution() throws Exception {
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

    // End-to-end reordered executeBatch maps placeholder 1 -> "name" and placeholder 2 -> "id".
    TableSchema storageTwoCol =
        TableSchema.newBuilder()
            .addFields(tfs("id", TableFieldSchema.Type.INT64))
            .addFields(tfs("name", TableFieldSchema.Type.STRING))
            .build();
    try (InProcessWriteServer srv = new InProcessWriteServer(storageTwoCol)) {
      doReturn(srv.client).when(connection).getBigQueryWriteClient();
      doReturn(
              mockInsertDryRunJob(
                  TableId.of("proj", "ds", "TAB"),
                  twoCol,
                  Arrays.asList(queryParam("STRING"), queryParam("INT64"))))
          .when(bigQuery)
          .create(any(JobInfo.class));
      BigQueryPreparedStatement ps =
          new BigQueryPreparedStatement(connection, "INSERT INTO TAB (name, id) VALUES (?, ?)");
      for (int i = 0; i < 3; i++) {
        ps.setString(1, "u-" + i);
        ps.setInt(2, 10 + i);
        ps.addBatch();
      }
      assertArrayEquals(new int[] {1, 1, 1}, ps.executeBatch());
      DynamicMessage first = srv.decodedRows().get(0);
      assertEquals("u-0", first.getField(srv.descriptor.findFieldByName("name")));
      assertEquals(10L, first.getField(srv.descriptor.findFieldByName("id")));
    }
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
    for (int i = 0; i < 3; i++) {
      psGate.setString(1, "v" + i);
      psGate.addBatch();
    }
    assertTrue(psGate.useWriteAPI());
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
    for (int i = 0; i < 3; i++) {
      psExplicitHidden.setString(1, "v" + i);
      psExplicitHidden.addBatch();
    }
    assertTrue(psExplicitHidden.useWriteAPI());
    doReturn(BigQueryConnection.SessionState.empty()).when(connection).getSessionStateSnapshot();

    // 3. Target project resolution & retry dry run after 404 (and non-repetition on null/403).
    doReturn("catalog-proj").when(connection).getCatalog();
    doReturn(DatasetId.of("default-proj", "default_ds")).when(connection).getDefaultDataset();
    TableSchema oneStrStorage =
        TableSchema.newBuilder().addFields(tfs("c1", TableFieldSchema.Type.STRING)).build();
    try (InProcessWriteServer srv = new InProcessWriteServer(oneStrStorage)) {
      doReturn(srv.client).when(connection).getBigQueryWriteClient();
      for (String ds : new String[] {"other_ds", "default_ds"}) {
        srv.appendRequests.clear();
        doReturn(
                mockInsertDryRunJob(
                    TableId.of(ds, "TAB"), oneStr, Collections.singletonList(queryParam("STRING"))))
            .when(bigQuery)
            .create(any(JobInfo.class));
        BigQueryPreparedStatement psProj =
            new BigQueryPreparedStatement(connection, "INSERT INTO " + ds + ".TAB VALUES (?)");
        for (int i = 0; i < 3; i++) {
          psProj.setString(1, "v" + i);
          psProj.addBatch();
        }
        assertArrayEquals(new int[] {1, 1, 1}, psProj.executeBatch());
      }
      assertEquals(
          Arrays.asList(
              "projects/catalog-proj/datasets/other_ds/tables/TAB",
              "projects/default-proj/datasets/default_ds/tables/TAB"),
          srv.createParents);

      // Retry dry run after 404 uses unbound query and unlocks Write API execution.
      srv.appendRequests.clear();
      clearInvocations(bigQuery);
      when(bigQuery.create(any(JobInfo.class)))
          .thenThrow(new BigQueryException(404, "Not found"))
          .thenReturn(
              mockInsertDryRunJob(
                  TableId.of("proj", "ds", "TAB"),
                  oneStr,
                  Collections.singletonList(queryParam("STRING"))));
      BigQueryPreparedStatement psRetry =
          new BigQueryPreparedStatement(connection, "INSERT INTO ds.TAB (c1) VALUES (?)");
      for (int i = 0; i < 3; i++) {
        psRetry.setString(1, "r" + i);
        psRetry.addBatch();
      }
      assertArrayEquals(new int[] {1, 1, 1}, psRetry.executeBatch());
      assertNotNull(psRetry.insertSchema);
      ArgumentCaptor<JobInfo> jobCaptor = ArgumentCaptor.forClass(JobInfo.class);
      verify(bigQuery, times(2)).create(jobCaptor.capture());
      QueryJobConfiguration retryCfg = jobCaptor.getAllValues().get(1).getConfiguration();
      assertTrue(
          retryCfg.getPositionalParameters() == null
              || retryCfg.getPositionalParameters().isEmpty());
    }

    TableResult dmlResult = mock(TableResult.class);
    doReturn(StatementType.INSERT).when(dmlResult).getStatementType();
    doReturn(1L).when(dmlResult).getNumDmlAffectedRows();
    doReturn(dmlResult).when(bigQuery).queryWithTimeout(any(), any(), any());
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
          new BigQueryPreparedStatement(connection, "INSERT INTO ds.TAB (c1) VALUES (?)");
      for (int b = 0; b < 2; b++) {
        for (int i = 0; i < 3; i++) {
          psOnce.setString(1, "v" + i);
          psOnce.addBatch();
        }
        psOnce.executeBatch();
      }
      verify(bigQuery, times(2)).create(any(JobInfo.class));
    }
  }
}
