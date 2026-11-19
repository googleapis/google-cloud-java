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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
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
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics.StatementType;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.jdbc.telemetry.v1.QueryApiType;
import com.google.cloud.bigquery.jdbc.telemetry.v1.StatementExecution;
import com.google.cloud.bigquery.jdbc.telemetry.v1.TelemetryManager;
import com.google.cloud.bigquery.storage.v1.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1.BatchCommitWriteStreamsRequest;
import com.google.cloud.bigquery.storage.v1.BatchCommitWriteStreamsResponse;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1.FinalizeWriteStreamResponse;
import com.google.cloud.bigquery.storage.v1.JsonStreamWriter;
import com.google.cloud.bigquery.storage.v1.TableSchema;
import com.google.cloud.bigquery.storage.v1.WriteStream;
import com.google.gson.JsonArray;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
}
