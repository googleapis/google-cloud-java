/*
 * Copyright 2023 Google LLC
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

import com.google.cloud.spanner.AbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.common.collect.ImmutableList;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.RollbackRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DelayTransactionStartUntilFirstWriteMockServerTest extends AbstractMockServerTest {

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Parameter public Dialect dialect;

  @Before
  public void setupDialect() {
    mockSpanner.putStatementResult(StatementResult.detectDialectResult(dialect));
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
    SpannerPool.closeSpannerPool();
  }

  @Test
  public void testEnable() {
    String prefix = dialect == Dialect.POSTGRESQL ? "spanner." : "";
    try (Connection connection = createConnection(";delayTransactionStartUntilFirstWrite=true")) {
      assertTrue(connection.isDelayTransactionStartUntilFirstWrite());
      try (ResultSet resultSet =
          connection.executeQuery(
              Statement.of(
                  String.format(
                      "show variable %sdelay_transaction_start_until_first_write", prefix)))) {
        assertTrue(resultSet.next());
        assertTrue(resultSet.getBoolean(0));
        assertTrue(
            resultSet.getBoolean(
                prefix.toUpperCase() + "DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE"));
        assertFalse(resultSet.next());
      }
    }
    try (Connection connection = createConnection()) {
      assertFalse(connection.isDelayTransactionStartUntilFirstWrite());
      connection.execute(
          Statement.of(
              String.format("set %sdelay_transaction_start_until_first_write=true", prefix)));
      assertTrue(connection.isDelayTransactionStartUntilFirstWrite());
    }
  }

  @Test
  public void testDisable() {
    String prefix = dialect == Dialect.POSTGRESQL ? "spanner." : "";
    try (Connection connection = createConnection()) {
      assertFalse(connection.isDelayTransactionStartUntilFirstWrite());
      try (ResultSet resultSet =
          connection.executeQuery(
              Statement.of(
                  String.format(
                      "show variable %sdelay_transaction_start_until_first_write", prefix)))) {
        assertTrue(resultSet.next());
        assertFalse(resultSet.getBoolean(0));
        assertFalse(
            resultSet.getBoolean(
                prefix.toUpperCase() + "DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE"));
        assertFalse(resultSet.next());
      }
    }
    try (Connection connection = createConnection(";delayTransactionStartUntilFirstWrite=true")) {
      assertTrue(connection.isDelayTransactionStartUntilFirstWrite());
      connection.execute(
          Statement.of(
              String.format("set %sdelay_transaction_start_until_first_write=false", prefix)));
      assertFalse(connection.isDelayTransactionStartUntilFirstWrite());
    }
  }

  @Test
  public void testDefaultUsesRealTransactions() {
    try (Connection connection = createConnection()) {
      executeRandomQuery(connection);
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertTrue(request.hasTransaction());
      assertTrue(request.getTransaction().hasBegin());
      assertTrue(request.getTransaction().getBegin().hasReadWrite());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testTransactionWithOneQuery() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      for (boolean commit : new boolean[] {true, false}) {
        executeRandomQuery(connection);
        if (commit) {
          connection.commit();
        } else {
          connection.rollback();
        }

        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
        assertFalse(request.hasTransaction());
        assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
        assertEquals(0, mockSpanner.countRequestsOfType(RollbackRequest.class));

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testTransactionWithTwoQueries() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      for (boolean commit : new boolean[] {true, false}) {
        executeRandomQuery(connection);
        executeRandomQuery(connection);
        if (commit) {
          connection.commit();
        } else {
          connection.rollback();
        }

        assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        assertFalse(mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0).hasTransaction());
        assertFalse(mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(1).hasTransaction());
        assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testTransactionWithSingleDml() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      connection.executeUpdate(INSERT_STATEMENT);
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertTrue(request.hasTransaction());
      assertTrue(request.getTransaction().hasBegin());
      assertTrue(request.getTransaction().getBegin().hasReadWrite());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testTransactionWithQueryFollowedByDml() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      executeRandomQuery(connection);
      connection.executeUpdate(INSERT_STATEMENT);
      connection.commit();

      assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest queryRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertFalse(queryRequest.hasTransaction());
      ExecuteSqlRequest dmlRequest = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(1);
      assertTrue(dmlRequest.hasTransaction());
      assertTrue(dmlRequest.getTransaction().hasBegin());
      assertTrue(dmlRequest.getTransaction().getBegin().hasReadWrite());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testTransactionWithDmlFollowedByQuery() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      connection.executeUpdate(INSERT_STATEMENT);
      executeRandomQuery(connection);
      connection.commit();

      assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest dmlRequest = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertTrue(dmlRequest.hasTransaction());
      assertTrue(dmlRequest.getTransaction().hasBegin());
      assertTrue(dmlRequest.getTransaction().getBegin().hasReadWrite());
      ExecuteSqlRequest queryRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(1);
      assertTrue(queryRequest.hasTransaction());
      assertTrue(queryRequest.getTransaction().hasId());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testTransactionWithQueryFollowedByBatchDml() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      executeRandomQuery(connection);
      connection.executeBatchUpdate(ImmutableList.of(INSERT_STATEMENT, INSERT_STATEMENT));
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest queryRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertFalse(queryRequest.hasTransaction());
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
      ExecuteBatchDmlRequest dmlRequest =
          mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
      assertTrue(dmlRequest.hasTransaction());
      assertTrue(dmlRequest.getTransaction().hasBegin());
      assertTrue(dmlRequest.getTransaction().getBegin().hasReadWrite());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testTransactionWithBatchDmlFollowedByQuery() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      connection.executeBatchUpdate(ImmutableList.of(INSERT_STATEMENT, INSERT_STATEMENT));
      executeRandomQuery(connection);
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
      ExecuteBatchDmlRequest dmlRequest =
          mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
      assertTrue(dmlRequest.hasTransaction());
      assertTrue(dmlRequest.getTransaction().hasBegin());
      assertTrue(dmlRequest.getTransaction().getBegin().hasReadWrite());
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest queryRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertTrue(queryRequest.hasTransaction());
      assertTrue(queryRequest.getTransaction().hasId());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testTransactionWithQueryFollowedByDmlReturning() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      executeRandomQuery(connection);
      try (ResultSet resultSet =
          connection.executeQuery(
              dialect == Dialect.POSTGRESQL
                  ? PG_INSERT_RETURNING_STATEMENT
                  : INSERT_RETURNING_STATEMENT)) {
        //noinspection StatementWithEmptyBody
        while (resultSet.next()) {
          // ignore
        }
      }
      connection.commit();

      assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest queryRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertFalse(queryRequest.hasTransaction());
      ExecuteSqlRequest dmlRequest = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(1);
      assertTrue(dmlRequest.hasTransaction());
      assertTrue(dmlRequest.getTransaction().hasBegin());
      assertTrue(dmlRequest.getTransaction().getBegin().hasReadWrite());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testTransactionWithDmlReturningFollowedByQuery() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      try (ResultSet resultSet =
          connection.executeQuery(
              dialect == Dialect.POSTGRESQL
                  ? PG_INSERT_RETURNING_STATEMENT
                  : INSERT_RETURNING_STATEMENT)) {
        //noinspection StatementWithEmptyBody
        while (resultSet.next()) {
          // ignore
        }
      }
      executeRandomQuery(connection);
      connection.commit();

      assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest dmlRequest = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertTrue(dmlRequest.hasTransaction());
      assertTrue(dmlRequest.getTransaction().hasBegin());
      assertTrue(dmlRequest.getTransaction().getBegin().hasReadWrite());
      ExecuteSqlRequest queryRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(1);
      assertTrue(queryRequest.hasTransaction());
      assertTrue(queryRequest.getTransaction().hasId());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testTransactionWithQueryFollowedByMutations() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      executeRandomQuery(connection);
      // Mutations don't start a transaction, as they are only included in the commit call anyways.
      connection.bufferedWrite(
          Mutation.newInsertOrUpdateBuilder("foo").set("id").to(1L).set("value").to("one").build());
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest queryRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertFalse(queryRequest.hasTransaction());
      assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testTransactionWithMutationsFollowedByQuery() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      // Mutations don't start a transaction, as they are only included in the commit call anyways.
      connection.bufferedWrite(
          Mutation.newInsertOrUpdateBuilder("foo").set("id").to(1L).set("value").to("one").build());
      executeRandomQuery(connection);
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest queryRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertFalse(queryRequest.hasTransaction());
      assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testTransactionWithQueryFollowedByDmlAborted() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      executeRandomQuery(connection);
      connection.executeUpdate(INSERT_STATEMENT);
      mockSpanner.abortNextStatement();
      connection.commit();

      // There should be 3 ExecuteSqlRequests:
      // 1. The initial query.
      // 2. The initial DML statement.
      // 3. The retried DML statement. The initial query is not part of the transaction, and
      // therefore also not retried.
      assertEquals(3, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest queryRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertFalse(queryRequest.hasTransaction());
      ExecuteSqlRequest firstDmlRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(1);
      assertTrue(firstDmlRequest.hasTransaction());
      assertTrue(firstDmlRequest.getTransaction().hasBegin());
      assertTrue(firstDmlRequest.getTransaction().getBegin().hasReadWrite());
      ExecuteSqlRequest secondDmlRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(2);
      assertTrue(secondDmlRequest.hasTransaction());
      assertTrue(secondDmlRequest.getTransaction().hasBegin());
      assertTrue(secondDmlRequest.getTransaction().getBegin().hasReadWrite());
      assertEquals(2, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testTransactionWithDmlFollowedByQueryAborted() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      connection.executeUpdate(INSERT_STATEMENT);
      executeRandomQuery(connection);
      mockSpanner.abortNextStatement();
      connection.commit();

      // There should be 4 ExecuteSqlRequests:
      // 1. The initial query.
      // 2. The initial DML statement.
      // 3. The retried query.
      // 4. The retried DML statement.
      assertEquals(4, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest firstQueryRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertTrue(firstQueryRequest.hasTransaction());
      assertTrue(firstQueryRequest.getTransaction().hasBegin());
      assertTrue(firstQueryRequest.getTransaction().getBegin().hasReadWrite());
      ExecuteSqlRequest firstDmlRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(1);
      assertTrue(firstDmlRequest.hasTransaction());
      assertTrue(firstDmlRequest.getTransaction().hasId());

      ExecuteSqlRequest secondQueryRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(2);
      assertTrue(secondQueryRequest.hasTransaction());
      assertTrue(firstQueryRequest.getTransaction().hasBegin());
      assertTrue(firstQueryRequest.getTransaction().getBegin().hasReadWrite());
      ExecuteSqlRequest secondDmlRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(3);
      assertTrue(secondDmlRequest.hasTransaction());
      assertTrue(secondDmlRequest.getTransaction().hasId());
      assertEquals(2, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testTransactionWithDmlFollowedByQueryWithFailedRetry() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      connection.executeUpdate(INSERT_STATEMENT);
      executeRandomQuery(connection);
      mockSpanner.abortNextStatement();
      // Change the results that is returned by the query. This will make the retry fail.
      mockSpanner.putStatementResult(
          StatementResult.query(
              SELECT_RANDOM_STATEMENT, new RandomResultSetGenerator(10).generate()));
      assertThrows(AbortedDueToConcurrentModificationException.class, connection::commit);

      // There should be 4 ExecuteSqlRequests:
      // 1. The initial query.
      // 2. The initial DML statement.
      // 3. The retried query.
      // 4. The retried DML statement.
      assertEquals(4, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest firstQueryRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertTrue(firstQueryRequest.hasTransaction());
      assertTrue(firstQueryRequest.getTransaction().hasBegin());
      assertTrue(firstQueryRequest.getTransaction().getBegin().hasReadWrite());
      ExecuteSqlRequest firstDmlRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(1);
      assertTrue(firstDmlRequest.hasTransaction());
      assertTrue(firstDmlRequest.getTransaction().hasId());

      ExecuteSqlRequest secondQueryRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(2);
      assertTrue(secondQueryRequest.hasTransaction());
      assertTrue(firstQueryRequest.getTransaction().hasBegin());
      assertTrue(firstQueryRequest.getTransaction().getBegin().hasReadWrite());
      ExecuteSqlRequest secondDmlRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(3);
      assertTrue(secondDmlRequest.hasTransaction());
      assertTrue(secondDmlRequest.getTransaction().hasId());

      // There is only one Commit request, as the retry fails on the query that returns different
      // results during the retry attempt.
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testTransactionWithQueryFollowedByDmlAborted_RetrySucceedsWithModifiedQueryResults() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      executeRandomQuery(connection);
      connection.executeUpdate(INSERT_STATEMENT);
      mockSpanner.abortNextStatement();
      // Change the results that is returned by the query. This will not affect the retry, as the
      // query is not part of the transaction.
      mockSpanner.putStatementResult(
          StatementResult.query(
              SELECT_RANDOM_STATEMENT, new RandomResultSetGenerator(10).generate()));
      connection.commit();

      // There should be 3 ExecuteSqlRequests:
      // 1. The initial query.
      // 2. The initial DML statement.
      // 3. The retried DML statement.
      assertEquals(3, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest queryRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertFalse(queryRequest.hasTransaction());
      ExecuteSqlRequest firstDmlRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(1);
      assertTrue(firstDmlRequest.hasTransaction());
      assertTrue(firstDmlRequest.getTransaction().hasBegin());
      assertTrue(firstDmlRequest.getTransaction().getBegin().hasReadWrite());
      ExecuteSqlRequest secondDmlRequest =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(2);
      assertTrue(secondDmlRequest.hasTransaction());
      assertTrue(secondDmlRequest.getTransaction().hasBegin());
      assertTrue(secondDmlRequest.getTransaction().getBegin().hasReadWrite());
      assertEquals(2, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testTransactionWithRollbackToSavepointWithoutRealTransaction() {
    try (Connection connection = createConnection()) {
      connection.setDelayTransactionStartUntilFirstWrite(true);

      executeRandomQuery(connection);
      connection.savepoint("s1");
      executeRandomQuery(connection);
      connection.rollbackToSavepoint("s1");
      executeRandomQuery(connection);

      connection.commit();

      assertEquals(3, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertFalse(mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0).hasTransaction());
      assertFalse(mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(1).hasTransaction());
      assertFalse(mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(2).hasTransaction());
      assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(0, mockSpanner.countRequestsOfType(RollbackRequest.class));
    }
  }

  private void executeRandomQuery(Connection connection) {
    try (ResultSet resultSet = connection.executeQuery(SELECT_RANDOM_STATEMENT)) {
      //noinspection StatementWithEmptyBody
      while (resultSet.next()) {
        // ignore
      }
    }
  }
}
