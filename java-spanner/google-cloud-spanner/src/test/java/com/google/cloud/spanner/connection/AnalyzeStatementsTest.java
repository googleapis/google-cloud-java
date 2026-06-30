/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ExecuteSqlRequest.QueryMode;
import com.google.spanner.v1.PlanNode;
import com.google.spanner.v1.QueryPlan;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import java.util.List;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AnalyzeStatementsTest extends AbstractMockServerTest {
  private static final Statement PLAN_QUERY =
      Statement.of("SELECT * FROM SomeTable WHERE Key LIKE @param ORDER BY Value");
  private static final Statement PLAN_UPDATE =
      Statement.of("UPDATE SomeTable SET Value=Value+1 WHERE Key LIKE @param");

  @BeforeClass
  public static void setupAnalyzeResults() {
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.query(
            PLAN_QUERY,
            com.google.spanner.v1.ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setRowType(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .setName("Key")
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .setName("Value")
                                        .build())
                                .build())
                        .setUndeclaredParameters(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .setName("param")
                                        .build())
                                .build())
                        .build())
                .setStats(
                    ResultSetStats.newBuilder()
                        .setQueryPlan(
                            QueryPlan.newBuilder()
                                .addPlanNodes(
                                    PlanNode.newBuilder().setDisplayName("some-plan-node").build())
                                .build())
                        .build())
                .build()));
    mockSpanner.putStatementResults(
        MockSpannerServiceImpl.StatementResult.query(
            PLAN_UPDATE,
            com.google.spanner.v1.ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setUndeclaredParameters(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .setName("param")
                                        .build())
                                .build())
                        .build())
                .setStats(
                    ResultSetStats.newBuilder()
                        .setQueryPlan(
                            QueryPlan.newBuilder()
                                .addPlanNodes(
                                    PlanNode.newBuilder().setDisplayName("some-plan-node").build())
                                .build())
                        .build())
                .build()));
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  @Test
  public void testAnalyzeQuery() {
    for (boolean readOnly : new boolean[] {true, false}) {
      for (boolean autocommit : new boolean[] {true, false}) {
        mockSpanner.clearRequests();

        try (Connection connection = createConnection()) {
          connection.setAutocommit(autocommit);
          connection.setReadOnly(readOnly);

          try (ResultSet resultSet = connection.analyzeQuery(PLAN_QUERY, QueryAnalyzeMode.PLAN)) {
            // Stats are only available after ResultSet#next() has returned false.
            assertFalse(resultSet.next());

            assertNotNull(resultSet.getStats());
            assertNotNull(resultSet.getStats().getQueryPlan());

            assertNotNull(resultSet.getMetadata());
            assertEquals(1, resultSet.getMetadata().getUndeclaredParameters().getFieldsCount());
            assertEquals(
                Type.newBuilder().setCode(TypeCode.STRING).build(),
                resultSet.getMetadata().getUndeclaredParameters().getFields(0).getType());
            assertEquals(
                "param", resultSet.getMetadata().getUndeclaredParameters().getFields(0).getName());
          }
        }

        List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
        assertEquals(1, requests.size());
        ExecuteSqlRequest request = requests.get(0);
        assertEquals(PLAN_QUERY.getSql(), request.getSql());
        assertEquals(QueryMode.PLAN, request.getQueryMode());
        if (autocommit) {
          // Autocommit should use a single-use read-only transaction.
          assertTrue(request.getTransaction().hasSingleUse());
          assertTrue(request.getTransaction().getSingleUse().hasReadOnly());
        } else {
          // Non-autocommit should start a transaction.
          if (readOnly) {
            // Read-only transaction begin is not inlined.
            BeginTransactionRequest beginTransactionRequest =
                mockSpanner.getRequestsOfType(BeginTransactionRequest.class).stream()
                    .findFirst()
                    .orElse(null);
            assertNotNull(beginTransactionRequest);
            assertTrue(beginTransactionRequest.getOptions().hasReadOnly());
            assertTrue(request.getTransaction().hasId());
          } else {
            assertTrue(request.getTransaction().hasBegin());
            assertTrue(request.getTransaction().getBegin().hasReadWrite());
          }
        }
      }
    }
  }

  @Test
  public void testAnalyzeUpdate() {
    for (boolean autocommit : new boolean[] {true, false}) {
      mockSpanner.clearRequests();

      try (Connection connection = createConnection()) {
        connection.setAutocommit(autocommit);

        ResultSetStats stats = connection.analyzeUpdate(PLAN_UPDATE, QueryAnalyzeMode.PLAN);
        assertNotNull(stats);
        assertNotNull(stats.getQueryPlan());
      }

      List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
      assertEquals(1, requests.size());
      ExecuteSqlRequest request = requests.get(0);
      assertEquals(PLAN_UPDATE.getSql(), request.getSql());
      assertEquals(QueryMode.PLAN, request.getQueryMode());

      // As it is a DML statement, we should always start a read/write transaction, even though it
      // is not executed. This is required by Cloud Spanner.
      assertTrue(request.getTransaction().hasBegin());
      assertTrue(request.getTransaction().getBegin().hasReadWrite());

      if (autocommit) {
        // The read/write transaction should automatically be committed in case of autocommit.
        assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      } else {
        assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
      }
    }
  }

  @Test
  public void testAnalyzeUpdateStatement() {
    for (boolean autocommit : new boolean[] {true, false}) {
      mockSpanner.clearRequests();

      try (Connection connection = createConnection()) {
        connection.setAutocommit(autocommit);

        try (ResultSet resultSet =
            connection.analyzeUpdateStatement(PLAN_UPDATE, QueryAnalyzeMode.PLAN)) {
          assertFalse(resultSet.next());

          ResultSetStats stats = resultSet.getStats();
          assertNotNull(stats);
          assertNotNull(stats.getQueryPlan());

          assertNotNull(resultSet.getMetadata());
          assertEquals(1, resultSet.getMetadata().getUndeclaredParameters().getFieldsCount());
          assertEquals(
              Type.newBuilder().setCode(TypeCode.STRING).build(),
              resultSet.getMetadata().getUndeclaredParameters().getFields(0).getType());
          assertEquals(
              "param", resultSet.getMetadata().getUndeclaredParameters().getFields(0).getName());
        }
      }

      List<ExecuteSqlRequest> requests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
      assertEquals(1, requests.size());
      ExecuteSqlRequest request = requests.get(0);
      assertEquals(PLAN_UPDATE.getSql(), request.getSql());
      assertEquals(QueryMode.PLAN, request.getQueryMode());

      // As it is a DML statement, we should always start a read/write transaction, even though it
      // is not executed. This is required by Cloud Spanner.
      assertTrue(request.getTransaction().hasBegin());
      assertTrue(request.getTransaction().getBegin().hasReadWrite());

      if (autocommit) {
        // The read/write transaction should automatically be committed in case of autocommit.
        assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      } else {
        assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
      }
    }
  }

  @Test
  public void testAnalyzeUpdateReadOnly() {
    for (boolean autocommit : new boolean[] {true, false}) {
      mockSpanner.clearRequests();

      try (Connection connection = createConnection()) {
        connection.setReadOnly(true);
        connection.setAutocommit(autocommit);

        SpannerException exception =
            assertThrows(
                SpannerException.class,
                () -> connection.analyzeUpdate(PLAN_UPDATE, QueryAnalyzeMode.PLAN));
        assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
      }

      assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testAnalyzeUpdateStatementWithQuery() {
    for (boolean autocommit : new boolean[] {true, false}) {
      mockSpanner.clearRequests();

      try (Connection connection = createConnection()) {
        connection.setReadOnly(true);
        connection.setAutocommit(autocommit);

        SpannerException exception =
            assertThrows(
                SpannerException.class,
                () -> connection.analyzeUpdateStatement(PLAN_QUERY, QueryAnalyzeMode.PLAN));
        assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
      }

      assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testAnalyzeUpdateStatementReadOnly() {
    for (boolean autocommit : new boolean[] {true, false}) {
      mockSpanner.clearRequests();

      try (Connection connection = createConnection()) {
        connection.setReadOnly(true);
        connection.setAutocommit(autocommit);

        SpannerException exception =
            assertThrows(
                SpannerException.class,
                () -> connection.analyzeUpdateStatement(PLAN_UPDATE, QueryAnalyzeMode.PLAN));
        assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
      }

      assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testAnalyzeUpdateDdlBatch() {
    try (Connection connection = createConnection()) {
      connection.startBatchDdl();

      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () -> connection.analyzeUpdate(PLAN_UPDATE, QueryAnalyzeMode.PLAN));
      assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
    }

    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testAnalyzeUpdateStatementDdlBatch() {
    try (Connection connection = createConnection()) {
      connection.startBatchDdl();

      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () -> connection.analyzeUpdateStatement(PLAN_UPDATE, QueryAnalyzeMode.PLAN));
      assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
    }

    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testAnalyzeUpdateDmlBatch_AutoCommit() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.startBatchDml();

      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () -> connection.analyzeUpdate(PLAN_UPDATE, QueryAnalyzeMode.PLAN));
      assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
    }

    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testAnalyzeUpdateDmlBatch_Transactional() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.startBatchDml();

      assertNotNull(connection.analyzeUpdate(PLAN_UPDATE, QueryAnalyzeMode.PLAN));
      assertEquals(-1L, connection.executeUpdate(INSERT_STATEMENT));
      connection.runBatch();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    }
  }

  @Test
  public void testAnalyzeUpdateStatementDmlBatch_AutoCommit() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.startBatchDml();

      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () -> connection.analyzeUpdateStatement(PLAN_UPDATE, QueryAnalyzeMode.PLAN));
      assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
    }

    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testAnalyzeUpdateStatementDmlBatch_Transactional() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.startBatchDml();

      connection.analyzeUpdateStatement(PLAN_UPDATE, QueryAnalyzeMode.PLAN);
      assertEquals(-1L, connection.executeUpdate(INSERT_STATEMENT));
      connection.runBatch();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    }
  }
}
