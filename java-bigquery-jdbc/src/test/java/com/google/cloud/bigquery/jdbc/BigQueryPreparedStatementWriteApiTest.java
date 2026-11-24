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

import com.google.api.services.bigquery.model.QueryParameter;
import com.google.api.services.bigquery.model.QueryParameterType;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
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
import com.google.cloud.bigquery.storage.v1.BQTableSchemaToProtoDescriptor;
import com.google.cloud.bigquery.storage.v1.BatchCommitWriteStreamsRequest;
import com.google.cloud.bigquery.storage.v1.BatchCommitWriteStreamsResponse;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.StorageError;
import com.google.cloud.bigquery.storage.v1.TableFieldSchema;
import com.google.cloud.bigquery.storage.v1.TableSchema;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
}
