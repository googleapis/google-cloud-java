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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.services.bigquery.model.QueryParameter;
import com.google.api.services.bigquery.model.QueryParameterType;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics.StatementType;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.TableId;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
