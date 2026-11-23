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
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.ConnectionProperty;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics.StatementType;
import com.google.cloud.bigquery.QueryJobConfiguration;
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
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteGrpc;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteSettings;
import com.google.cloud.bigquery.storage.v1.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1.FinalizeWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1.FinalizeWriteStreamResponse;
import com.google.cloud.bigquery.storage.v1.StorageError;
import com.google.cloud.bigquery.storage.v1.TableFieldSchema;
import com.google.cloud.bigquery.storage.v1.TableSchema;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.DynamicMessage;
import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
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

  private BigQueryPreparedStatement newStatementWithWriter(BigQueryJdbcBulkInsertWriter writer)
      throws SQLException {
    return new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?)") {
      @Override
      BigQueryJdbcBulkInsertWriter createBulkInsertWriter() {
        return writer;
      }
    };
  }

  private static void addThreeStringRows(BigQueryPreparedStatement ps) throws SQLException {
    for (int i = 0; i < 3; i++) {
      ps.setString(1, "v" + i);
      ps.addBatch();
    }
  }

  @Test
  public void testNullQueryEmptyBatchUnboundParametersClearBatchAndClose() throws Exception {
    assertThrows(
        BigQueryJdbcException.class, () -> new BigQueryPreparedStatement(connection, null));
    when(bigQuery.create(any(JobInfo.class))).thenThrow(new BigQueryException(500, "no dry run"));
    BigQueryPreparedStatement ps =
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?, ?)");
    assertArrayEquals(new int[0], ps.executeBatch());

    ps.setString(2, "only-second");
    ps.addBatch();
    assertTrue(
        assertThrows(BigQueryJdbcException.class, ps::executeBatch)
            .getMessage()
            .contains("parameter 1 of 2"));
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
    BigQueryJdbcBulkInsertWriter okWriter = mock(BigQueryJdbcBulkInsertWriter.class);
    when(okWriter.getStreamName()).thenReturn("projects/proj/datasets/ds/tables/TAB/streams/_p1");
    when(okWriter.getDescriptor())
        .thenReturn(
            BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(
                TableSchema.newBuilder()
                    .addFields(
                        TableFieldSchema.newBuilder()
                            .setName("c1")
                            .setType(TableFieldSchema.Type.STRING)
                            .setMode(TableFieldSchema.Mode.NULLABLE))
                    .build()));
    when(okWriter.cleanup(writeClient)).thenReturn(3L);

    BigQueryPreparedStatement ps = newStatementWithWriter(okWriter);
    for (int batch = 0; batch < 2; batch++) {
      addThreeStringRows(ps);
      assertArrayEquals(new int[] {1, 1, 1}, ps.executeBatch());
    }
    verify(writeClient, never()).close();
    verify(writeClient, times(2))
        .batchCommitWriteStreams(any(BatchCommitWriteStreamsRequest.class));
    assertArrayEquals(new int[0], ps.executeBatch());

    stubCommitClient(false);
    when(okWriter.cleanup(any())).thenReturn(3L);
    try (MockedStatic<TelemetryManager> telemetry =
        mockStatic(TelemetryManager.class, CALLS_REAL_METHODS)) {
      addThreeStringRows(ps);
      assertTrue(
          assertThrows(BigQueryJdbcException.class, ps::executeBatch)
              .getMessage()
              .contains("stream already committed"));
      ArgumentCaptor<StatementExecution.Builder> cap =
          ArgumentCaptor.forClass(StatementExecution.Builder.class);
      telemetry.verify(() -> TelemetryManager.recordStatementExecution(cap.capture(), anyLong()));
      assertEquals(QueryApiType.QUERY_API_TYPE_WRITE_API, cap.getValue().getQueryApiType());
      assertEquals(Status.STATUS_ERROR, cap.getValue().getStatus());
    }

    IOException ioEx = new IOException("io failure");
    BigQueryJdbcBulkInsertWriter ioFailWriter = mock(BigQueryJdbcBulkInsertWriter.class);
    doThrow(ioEx).when(ioFailWriter).initialize(any(), any(), any());
    BigQueryPreparedStatement psIo = newStatementWithWriter(ioFailWriter);
    addThreeStringRows(psIo);
    assertSame(ioEx, assertThrows(BigQueryJdbcException.class, psIo::executeBatch).getCause());
    verify(ioFailWriter, times(1)).closeQuietly();

    BigQueryJdbcBulkInsertWriter interruptWriter = mock(BigQueryJdbcBulkInsertWriter.class);
    doThrow(new InterruptedException("stop")).when(interruptWriter).initialize(any(), any(), any());
    BigQueryPreparedStatement psInt = newStatementWithWriter(interruptWriter);
    addThreeStringRows(psInt);
    try {
      BigQueryJdbcException ex = assertThrows(BigQueryJdbcException.class, psInt::executeBatch);
      assertTrue(ex.getCause() instanceof InterruptedException);
      assertTrue(Thread.currentThread().isInterrupted());
    } finally {
      Thread.interrupted();
    }
  }

  @Test
  public void testUnsupportedColumnsAndIncompatibleValuesFallBackToSqlBatch() throws Exception {
    for (Field unsupported :
        Arrays.asList(
            Field.newBuilder("a", StandardSQLTypeName.STRING).setMode(Field.Mode.REPEATED).build(),
            Field.of("s", StandardSQLTypeName.STRUCT, Field.of("x", StandardSQLTypeName.INT64)),
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
        Arguments.of("INSERT INTO TAB VALUES (?)", true, 1, null),
        Arguments.of(
            "insert tab (TARG_FIELD) values (?);",
            true,
            1,
            Collections.singletonList("TARG_FIELD")),
        Arguments.of(
            "/* header */ INSERT INTO `my-proj.my_ds.TAB` (`col_b`, col_a) -- comment\n"
                + "VALUES ( ? , ? ) ; # trailing",
            false,
            2,
            Arrays.asList("col_b", "col_a")),
        Arguments.of(
            "INSERT INTO proj:123_ds.tab (c1) -- mac line ending\rVALUES (?)",
            false,
            1,
            Collections.singletonList("c1")),
        Arguments.of(
            "INSERT INTO `my\\`tab` (`col\\\\1`, `col\\`2`) VALUES (?, ?)",
            true,
            2,
            Arrays.asList("col\\1", "col`2")));
  }

  @ParameterizedTest
  @MethodSource("validDirectInsertQueries")
  public void testParseDirectInsertValuesAcceptsValidForms(
      String sql, boolean unqualified, int expectedPlaceholders, List<String> expectedCols) {
    BigQueryPreparedStatement.DirectInsertShape shape =
        BigQueryPreparedStatement.parseDirectInsertValues(sql);
    assertNotNull(shape);
    assertEquals(unqualified, shape.unqualifiedTable);
    assertEquals(expectedPlaceholders, shape.placeholderCount);
    assertEquals(expectedCols, shape.columnNames);
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

    // Partial column subset on a multi-column table leaves insertSchema null so DDL DEFAULTs run.
    Schema twoCols =
        Schema.of(
            Field.of("id", StandardSQLTypeName.INT64),
            Field.of("name", StandardSQLTypeName.STRING));
    doReturn(
            mockInsertDryRunJob(
                TableId.of("proj", "ds", "TAB"),
                twoCols,
                Collections.singletonList(queryParam("INT64"))))
        .when(bigQuery)
        .create(any(JobInfo.class));
    assertNull(
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB (id) VALUES (?)").insertSchema);
    doReturn(
            mockInsertDryRunJob(
                TableId.of("proj", "ds", "TAB"),
                twoCols,
                Arrays.asList(queryParam("INT64"), queryParam("STRING"))))
        .when(bigQuery)
        .create(any(JobInfo.class));
    assertNotNull(
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB (ID, name) VALUES (?, ?)")
            .insertSchema);
  }

  private static TableFieldSchema tfs(String name, TableFieldSchema.Type type) {
    return TableFieldSchema.newBuilder()
        .setName(name)
        .setType(type)
        .setMode(TableFieldSchema.Mode.NULLABLE)
        .build();
  }

  private void stubDryRun(TableId targetTable, Schema schema, String... paramTypes) {
    List<QueryParameter> params = new ArrayList<>(paramTypes.length);
    for (String t : paramTypes) {
      params.add(queryParam(t));
    }
    doReturn(mockInsertDryRunJob(targetTable, schema, params))
        .when(bigQuery)
        .create(any(JobInfo.class));
  }

  private void stubDml() throws InterruptedException {
    TableResult dml = mock(TableResult.class);
    doReturn(StatementType.INSERT).when(dml).getStatementType();
    doReturn(1L).when(dml).getNumDmlAffectedRows();
    doReturn(dml).when(bigQuery).queryWithTimeout(any(), any(), any());
  }

  private static final class InProcessWriteServer implements AutoCloseable {
    final List<String> createParents = new CopyOnWriteArrayList<>();
    final List<AppendRowsRequest> appendRequests = new CopyOnWriteArrayList<>();
    final Descriptor descriptor;
    final Server server;
    final ManagedChannel channel;
    final BigQueryWriteClient client;

    InProcessWriteServer(TableSchema tableSchema) throws Exception {
      TableSchema.Builder lower = TableSchema.newBuilder();
      boolean convertible = true;
      for (TableFieldSchema f : tableSchema.getFieldsList()) {
        convertible &= (f.getType() != TableFieldSchema.Type.RANGE);
        lower.addFields(f.toBuilder().setName(f.getName().toLowerCase(Locale.ROOT)).build());
      }
      this.descriptor =
          convertible
              ? BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(lower.build())
              : null;
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
                StreamObserver<AppendRowsResponse> obs) {
              return new StreamObserver<AppendRowsRequest>() {
                @Override
                public void onNext(AppendRowsRequest req) {
                  appendRequests.add(req);
                  AppendRowsResponse.Builder res = AppendRowsResponse.newBuilder();
                  res.getAppendResultBuilder().setOffset(req.getOffset());
                  obs.onNext(res.build());
                }

                @Override
                public void onError(Throwable t) {
                  obs.onError(t);
                }

                @Override
                public void onCompleted() {
                  obs.onCompleted();
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
      GrpcTransportChannel ch = GrpcTransportChannel.create(channel);
      this.client =
          BigQueryWriteClient.create(
              BigQueryWriteSettings.newBuilder()
                  .setTransportChannelProvider(FixedTransportChannelProvider.create(ch))
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

  @Test
  public void testResolveInsertSchemaAndStreamSchemaMismatchFallback() throws Exception {
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
    for (String bad :
        new String[] {
          "INSERT INTO TAB (id) VALUES (?)",
          "INSERT INTO TAB (id, ID) VALUES (?, ?)",
          "INSERT INTO TAB (id, _PARTITIONTIME) VALUES (?, ?)"
        }) {
      BigQueryPreparedStatement.DirectInsertShape s =
          BigQueryPreparedStatement.parseDirectInsertValues(bad);
      assertNull(BigQueryPreparedStatement.resolveInsertSchema(twoCol, s, s.placeholderCount));
    }

    TableSchema storageTwo =
        TableSchema.newBuilder()
            .addFields(tfs("id", TableFieldSchema.Type.INT64))
            .addFields(tfs("name", TableFieldSchema.Type.STRING))
            .build();
    try (InProcessWriteServer srv = new InProcessWriteServer(storageTwo)) {
      doReturn(srv.client).when(connection).getBigQueryWriteClient();
      stubDryRun(TableId.of("proj", "ds", "TAB"), twoCol, "STRING", "INT64");
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

    stubDml();
    TableSchema extraRange =
        TableSchema.newBuilder()
            .addFields(tfs("c1", TableFieldSchema.Type.STRING))
            .addFields(tfs("rng", TableFieldSchema.Type.RANGE))
            .build();
    try (InProcessWriteServer srv = new InProcessWriteServer(extraRange)) {
      doReturn(srv.client).when(connection).getBigQueryWriteClient();
      stubDryRun(
          TableId.of("proj", "ds", "TAB"),
          Schema.of(Field.of("c1", StandardSQLTypeName.STRING)),
          "STRING");
      BigQueryPreparedStatement psPartial =
          new BigQueryPreparedStatement(connection, "INSERT INTO TAB (c1) VALUES (?)");
      addThreeStringRows(psPartial);
      assertEquals(3, psPartial.executeBatch().length);
      assertTrue(srv.appendRequests.isEmpty());
      assertNull(psPartial.insertSchema);
      verify(bigQuery, times(1)).queryWithTimeout(any(), any(), any());
    }
  }

  @Test
  public void testTargetProjectTransactionsSessionsLegacySqlAndRetryDryRun() throws Exception {
    doReturn("BIG_QUERY").when(connection).getQueryDialect();
    assertEquals(
        1, new BigQueryPreparedStatement(connection, "SELECT ? FROM [proj:ds.tab]").parameterCount);
    verify(bigQuery, never()).create(any(JobInfo.class));
    doReturn("SQL").when(connection).getQueryDialect();

    Schema oneStr = Schema.of(Field.of("c1", StandardSQLTypeName.STRING));
    stubDryRun(TableId.of("proj", "_anon_ds", "TAB"), oneStr, "STRING");
    BigQueryPreparedStatement psGate =
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?)");
    addThreeStringRows(psGate);
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
    doReturn(DatasetId.of("proj", "_anon_ds")).when(connection).getDefaultDataset();
    BigQueryPreparedStatement psExplicit =
        new BigQueryPreparedStatement(connection, "INSERT INTO TAB VALUES (?)");
    addThreeStringRows(psExplicit);
    assertTrue(psExplicit.useWriteAPI());
    doReturn(BigQueryConnection.SessionState.empty()).when(connection).getSessionStateSnapshot();

    BigQueryOptions opts = mock(BigQueryOptions.class);
    when(opts.getProjectId()).thenReturn("options-proj");
    when(bigQuery.getOptions()).thenReturn(opts);
    doReturn("catalog-proj").when(connection).getCatalog();
    doReturn(DatasetId.of("default-proj", "default_ds")).when(connection).getDefaultDataset();
    TableSchema oneStorage =
        TableSchema.newBuilder().addFields(tfs("c1", TableFieldSchema.Type.STRING)).build();
    try (InProcessWriteServer srv = new InProcessWriteServer(oneStorage)) {
      doReturn(srv.client).when(connection).getBigQueryWriteClient();
      stubDryRun(TableId.of("default_ds", "TAB"), oneStr, "STRING");
      for (String sql :
          new String[] {"INSERT INTO TAB VALUES (?)", "INSERT INTO default_ds.TAB VALUES (?)"}) {
        srv.appendRequests.clear();
        BigQueryPreparedStatement psProj = new BigQueryPreparedStatement(connection, sql);
        addThreeStringRows(psProj);
        assertArrayEquals(new int[] {1, 1, 1}, psProj.executeBatch());
      }
      srv.appendRequests.clear();
      doReturn(null).when(connection).getCatalog();
      stubDryRun(TableId.of("other_ds", "TAB"), oneStr, "STRING");
      BigQueryPreparedStatement psAdc =
          new BigQueryPreparedStatement(connection, "INSERT INTO other_ds.TAB VALUES (?)");
      addThreeStringRows(psAdc);
      assertArrayEquals(new int[] {1, 1, 1}, psAdc.executeBatch());
      assertEquals(
          Arrays.asList(
              "projects/default-proj/datasets/default_ds/tables/TAB",
              "projects/catalog-proj/datasets/default_ds/tables/TAB",
              "projects/options-proj/datasets/other_ds/tables/TAB"),
          srv.createParents);

      srv.appendRequests.clear();
      clearInvocations(bigQuery);
      Job okJob =
          mockInsertDryRunJob(
              TableId.of("proj", "ds", "TAB"),
              oneStr,
              Collections.singletonList(queryParam("STRING")));
      when(bigQuery.create(any(JobInfo.class)))
          .thenThrow(new BigQueryException(404, "Not found"))
          .thenReturn(okJob);
      BigQueryPreparedStatement psRetry =
          new BigQueryPreparedStatement(connection, "INSERT INTO ds.TAB (c1) VALUES (?)");
      addThreeStringRows(psRetry);
      assertArrayEquals(new int[] {1, 1, 1}, psRetry.executeBatch());
      assertNotNull(psRetry.insertSchema);
      ArgumentCaptor<JobInfo> cap = ArgumentCaptor.forClass(JobInfo.class);
      verify(bigQuery, times(2)).create(cap.capture());
      QueryJobConfiguration retryCfg = cap.getAllValues().get(1).getConfiguration();
      List<?> retryParams = retryCfg.getPositionalParameters();
      assertTrue(retryParams == null || retryParams.isEmpty());
    }

    stubDml();
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
        addThreeStringRows(psOnce);
        psOnce.executeBatch();
      }
      verify(bigQuery, times(2)).create(any(JobInfo.class));
    }
  }
}
