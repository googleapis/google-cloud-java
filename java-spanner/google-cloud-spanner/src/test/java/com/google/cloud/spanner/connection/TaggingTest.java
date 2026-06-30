/*
 * Copyright 2021 Google LLC
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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import java.util.Collections;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TaggingTest extends AbstractMockServerTest {

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Parameter public Dialect dialect;

  private Dialect currentDialect;

  @Before
  public void setupDialect() {
    if (currentDialect != dialect) {
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.detectDialectResult(dialect));
      SpannerPool.closeSpannerPool();
      currentDialect = dialect;
    }
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  @Test
  public void testStatementTagNotAllowedForCommit() {
    try (Connection connection = createConnection()) {
      connection.setStatementTag("tag-1");
      SpannerException exception = assertThrows(SpannerException.class, connection::commit);
      assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
    }
  }

  @Test
  public void testStatementTagNotAllowedForRollback() {
    try (Connection connection = createConnection()) {
      connection.setStatementTag("tag-1");
      SpannerException exception = assertThrows(SpannerException.class, connection::rollback);
      assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
    }
  }

  @Test
  public void testStatementTagNotAllowedInsideBatch() {
    try (Connection connection = createConnection()) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);
        connection.startBatchDml();

        SpannerException exception =
            assertThrows(SpannerException.class, () -> connection.setStatementTag("tag-1"));
        assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());

        connection.abortBatch();
      }
    }
  }

  @Test
  public void testQuery_NoTags() {
    try (Connection connection = createConnection()) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);
        //noinspection EmptyTryBlock
        try (ResultSet ignore = connection.executeQuery(SELECT_COUNT_STATEMENT)) {}
        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getRequestOptions()
                .getRequestTag());
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getRequestOptions()
                .getTransactionTag());

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testUpdate_NoTags() {
    try (Connection connection = createConnection()) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);
        connection.executeUpdate(INSERT_STATEMENT);

        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getRequestOptions()
                .getRequestTag());
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getRequestOptions()
                .getTransactionTag());

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testPartitionedUpdate_NoTags() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.setAutocommitDmlMode(AutocommitDmlMode.PARTITIONED_NON_ATOMIC);
      connection.executeUpdate(INSERT_STATEMENT);

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());

      mockSpanner.clearRequests();
    }
  }

  @Test
  public void testBatchUpdate_NoTags() {
    try (Connection connection = createConnection()) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);
        connection.executeBatchUpdate(Collections.singletonList(INSERT_STATEMENT));

        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteBatchDmlRequest.class)
                .get(0)
                .getRequestOptions()
                .getRequestTag());
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteBatchDmlRequest.class)
                .get(0)
                .getRequestOptions()
                .getTransactionTag());

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testQuery_StatementTag() {
    try (Connection connection = createConnection()) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);
        connection.setStatementTag("tag-1");
        //noinspection EmptyTryBlock
        try (ResultSet ignore = connection.executeQuery(SELECT_COUNT_STATEMENT)) {}
        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        assertEquals(
            "tag-1",
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getRequestOptions()
                .getRequestTag());
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getRequestOptions()
                .getTransactionTag());

        mockSpanner.clearRequests();

        // The tag should automatically be cleared after a statement.
        //noinspection EmptyTryBlock
        try (ResultSet ignore = connection.executeQuery(SELECT_COUNT_STATEMENT)) {}
        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getRequestOptions()
                .getRequestTag());
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getRequestOptions()
                .getTransactionTag());

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testUpdate_StatementTag() {
    try (Connection connection = createConnection()) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);
        connection.setStatementTag("tag-2");
        connection.executeUpdate(INSERT_STATEMENT);

        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        assertEquals(
            "tag-2",
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getRequestOptions()
                .getRequestTag());
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getRequestOptions()
                .getTransactionTag());

        mockSpanner.clearRequests();

        connection.executeUpdate(INSERT_STATEMENT);

        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getRequestOptions()
                .getRequestTag());
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getRequestOptions()
                .getTransactionTag());

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testPartitionedUpdate_StatementTag() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.setAutocommitDmlMode(AutocommitDmlMode.PARTITIONED_NON_ATOMIC);
      connection.setStatementTag("tag-4");
      connection.executeUpdate(INSERT_STATEMENT);

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(
          "tag-4",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());

      mockSpanner.clearRequests();

      connection.executeUpdate(INSERT_STATEMENT);

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());

      mockSpanner.clearRequests();
    }
  }

  @Test
  public void testBatchUpdate_StatementTag() {
    try (Connection connection = createConnection()) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);
        connection.setStatementTag("tag-3");
        connection.executeBatchUpdate(Collections.singletonList(INSERT_STATEMENT));

        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
        assertEquals(
            "tag-3",
            mockSpanner
                .getRequestsOfType(ExecuteBatchDmlRequest.class)
                .get(0)
                .getRequestOptions()
                .getRequestTag());
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteBatchDmlRequest.class)
                .get(0)
                .getRequestOptions()
                .getTransactionTag());

        mockSpanner.clearRequests();

        connection.executeBatchUpdate(Collections.singletonList(INSERT_STATEMENT));

        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteBatchDmlRequest.class)
                .get(0)
                .getRequestOptions()
                .getRequestTag());
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteBatchDmlRequest.class)
                .get(0)
                .getRequestOptions()
                .getTransactionTag());

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testQuery_TransactionTag() {
    try (Connection connection = createConnection()) {
      connection.setTransactionTag("tag-1");
      //noinspection EmptyTryBlock
      try (ResultSet ignore = connection.executeQuery(SELECT_COUNT_STATEMENT)) {}
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "tag-1",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "tag-1",
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());

      mockSpanner.clearRequests();

      // The tag should automatically be cleared after a statement.
      //noinspection EmptyTryBlock
      try (ResultSet ignore = connection.executeQuery(SELECT_COUNT_STATEMENT)) {}
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());

      mockSpanner.clearRequests();
    }
  }

  @Test
  public void testUpdate_TransactionTag() {
    try (Connection connection = createConnection()) {
      connection.setTransactionTag("tag-2");
      connection.executeUpdate(INSERT_STATEMENT);
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "tag-2",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "tag-2",
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());

      mockSpanner.clearRequests();

      connection.executeUpdate(INSERT_STATEMENT);
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());

      mockSpanner.clearRequests();
    }
  }

  @Test
  public void testBatchUpdate_TransactionTag() {
    try (Connection connection = createConnection()) {
      connection.setTransactionTag("tag-3");
      connection.executeBatchUpdate(Collections.singletonList(INSERT_STATEMENT));
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteBatchDmlRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "tag-3",
          mockSpanner
              .getRequestsOfType(ExecuteBatchDmlRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "tag-3",
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());

      mockSpanner.clearRequests();

      connection.executeBatchUpdate(Collections.singletonList(INSERT_STATEMENT));
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteBatchDmlRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteBatchDmlRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());

      mockSpanner.clearRequests();
    }
  }

  @Test
  public void testDmlBatch_StatementTag() {
    try (Connection connection = createConnection()) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);

        connection.setStatementTag("batch-tag");
        connection.startBatchDml();
        connection.execute(INSERT_STATEMENT);
        connection.execute(INSERT_STATEMENT);
        connection.runBatch();

        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
        assertEquals(
            "batch-tag",
            mockSpanner
                .getRequestsOfType(ExecuteBatchDmlRequest.class)
                .get(0)
                .getRequestOptions()
                .getRequestTag());
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteBatchDmlRequest.class)
                .get(0)
                .getRequestOptions()
                .getTransactionTag());

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testRunBatch_TransactionTag() {
    try (Connection connection = createConnection()) {
      connection.setTransactionTag("batch-tag");
      connection.startBatchDml();
      connection.execute(INSERT_STATEMENT);
      connection.execute(INSERT_STATEMENT);
      connection.runBatch();
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteBatchDmlRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "batch-tag",
          mockSpanner
              .getRequestsOfType(ExecuteBatchDmlRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "batch-tag",
          mockSpanner
              .getRequestsOfType(CommitRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());

      mockSpanner.clearRequests();
    }
  }

  @Test
  public void testShowSetTags() {
    try (Connection connection = createConnection()) {
      connection.execute(Statement.of(String.format("SET %sSTATEMENT_TAG='tag1'", prefix())));
      try (ResultSet rs =
          connection
              .execute(Statement.of(String.format("SHOW VARIABLE %sSTATEMENT_TAG", prefix())))
              .getResultSet()) {
        assertTrue(rs.next());
        assertEquals("tag1", rs.getString(String.format("%sSTATEMENT_TAG", prefix())));
        assertFalse(rs.next());
      }
      connection.execute(Statement.of(String.format("SET %sSTATEMENT_TAG=''", prefix())));
      try (ResultSet rs =
          connection
              .execute(Statement.of(String.format("SHOW VARIABLE %sSTATEMENT_TAG", prefix())))
              .getResultSet()) {
        assertTrue(rs.next());
        assertEquals("", rs.getString(String.format("%sSTATEMENT_TAG", prefix())));
        assertFalse(rs.next());
      }
      connection.execute(Statement.of(String.format("SET %sTRANSACTION_TAG='tag2'", prefix())));
      try (ResultSet rs =
          connection
              .execute(Statement.of(String.format("SHOW VARIABLE %sTRANSACTION_TAG", prefix())))
              .getResultSet()) {
        assertTrue(rs.next());
        assertEquals("tag2", rs.getString(String.format("%sTRANSACTION_TAG", prefix())));
        assertFalse(rs.next());
      }
      connection.execute(Statement.of(String.format("SET %sTRANSACTION_TAG=''", prefix())));
      try (ResultSet rs =
          connection
              .execute(Statement.of(String.format("SHOW VARIABLE %sTRANSACTION_TAG", prefix())))
              .getResultSet()) {
        assertTrue(rs.next());
        assertEquals("", rs.getString(String.format("%sTRANSACTION_TAG", prefix())));
        assertFalse(rs.next());
      }
    }
  }

  @Test
  public void testQuery_StatementTagHint() {
    String sql = SELECT_COUNT_STATEMENT.getSql();

    try (Connection connection = createConnection()) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);
        //noinspection EmptyTryBlock
        try (ResultSet ignore =
            connection.executeQuery(Statement.of(statementTagHint("tag-1") + sql))) {}
        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        assertEquals(
            "tag-1",
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getRequestOptions()
                .getRequestTag());

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testUpdate_StatementTagHint() {
    String sql = INSERT_STATEMENT.getSql();

    try (Connection connection = createConnection()) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);
        connection.executeUpdate(Statement.of(statementTagHint("tag-2") + sql));

        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        assertEquals(
            "tag-2",
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getRequestOptions()
                .getRequestTag());
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getRequestOptions()
                .getTransactionTag());

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testPartitionedUpdate_StatementTagHint() {
    String sql = INSERT_STATEMENT.getSql();

    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.setAutocommitDmlMode(AutocommitDmlMode.PARTITIONED_NON_ATOMIC);
      connection.executeUpdate(Statement.of(statementTagHint("tag-4") + sql));

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(
          "tag-4",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getRequestTag());
      assertEquals(
          "",
          mockSpanner
              .getRequestsOfType(ExecuteSqlRequest.class)
              .get(0)
              .getRequestOptions()
              .getTransactionTag());

      mockSpanner.clearRequests();
    }
  }

  @Test
  public void testBatchUpdate_StatementTagHint() {
    String sql = INSERT_STATEMENT.getSql();

    try (Connection connection = createConnection()) {
      for (boolean autocommit : new boolean[] {true, false}) {
        connection.setAutocommit(autocommit);
        connection.executeBatchUpdate(
            Collections.singletonList(Statement.of(statementTagHint("tag-3") + sql)));

        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
        assertEquals(
            "tag-3",
            mockSpanner
                .getRequestsOfType(ExecuteBatchDmlRequest.class)
                .get(0)
                .getRequestOptions()
                .getRequestTag());
        assertEquals(
            "",
            mockSpanner
                .getRequestsOfType(ExecuteBatchDmlRequest.class)
                .get(0)
                .getRequestOptions()
                .getTransactionTag());

        mockSpanner.clearRequests();
      }
    }
  }

  private String statementTagHint(String tag) {
    switch (dialect) {
      case POSTGRESQL:
        return "/*@statement_tag='" + tag + "'*/";
      case GOOGLE_STANDARD_SQL:
      default:
        return "@{statement_tag='" + tag + "'}";
    }
  }

  private String prefix() {
    return dialect == Dialect.POSTGRESQL ? "SPANNER." : "";
  }
}
