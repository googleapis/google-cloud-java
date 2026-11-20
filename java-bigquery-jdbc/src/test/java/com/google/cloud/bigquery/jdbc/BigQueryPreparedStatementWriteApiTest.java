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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
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
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.TableId;
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
import com.google.protobuf.Descriptors.Descriptor;
import java.io.IOException;
import java.sql.SQLException;
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
}
