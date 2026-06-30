/*
 * Copyright 2024 Google LLC
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

import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.common.collect.ImmutableList;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExcludeTxnFromChangeStreamsMockServerTest extends AbstractMockServerTest {

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  @Test
  public void testAutoCommit_includedByDefault() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.executeUpdate(INSERT_STATEMENT);
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.hasTransaction());
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertFalse(request.getTransaction().getBegin().getExcludeTxnFromChangeStreams());
  }

  @Test
  public void testAutoCommitUpdate() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.setExcludeTxnFromChangeStreams(true);
      connection.executeUpdate(INSERT_STATEMENT);

      // Verify that the setting is reset after executing a transaction.
      assertFalse(connection.isExcludeTxnFromChangeStreams());
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.hasTransaction());
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertTrue(request.getTransaction().getBegin().getExcludeTxnFromChangeStreams());
  }

  @Test
  public void testAutoCommitBatchDml() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.setExcludeTxnFromChangeStreams(true);
      connection.executeBatchUpdate(ImmutableList.of(INSERT_STATEMENT, INSERT_STATEMENT));

      assertFalse(connection.isExcludeTxnFromChangeStreams());
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertTrue(request.hasTransaction());
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertTrue(request.getTransaction().getBegin().getExcludeTxnFromChangeStreams());
  }

  @Test
  public void testAutoCommitUpdateReturning() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.setExcludeTxnFromChangeStreams(true);
      connection.executeQuery(INSERT_RETURNING_STATEMENT);

      assertFalse(connection.isExcludeTxnFromChangeStreams());
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.hasTransaction());
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertTrue(request.getTransaction().getBegin().getExcludeTxnFromChangeStreams());
  }

  @Test
  public void testPartitionedDml() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.setAutocommitDmlMode(AutocommitDmlMode.PARTITIONED_NON_ATOMIC);
      connection.setExcludeTxnFromChangeStreams(true);
      connection.executeUpdate(INSERT_STATEMENT);

      // Verify that the setting is reset after executing a transaction.
      assertFalse(connection.isExcludeTxnFromChangeStreams());
    }

    assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    BeginTransactionRequest request =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class).get(0);
    assertTrue(request.hasOptions());
    assertTrue(request.getOptions().hasPartitionedDml());
    assertTrue(request.getOptions().getExcludeTxnFromChangeStreams());
  }

  @Test
  public void testTransaction_includedByDefault() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.executeUpdate(INSERT_STATEMENT);
      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.hasTransaction());
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertFalse(request.getTransaction().getBegin().getExcludeTxnFromChangeStreams());
  }

  @Test
  public void testTransactionUpdate() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.setExcludeTxnFromChangeStreams(true);
      connection.executeUpdate(INSERT_STATEMENT);
      connection.commit();

      // Verify that the setting is reset after executing a transaction.
      assertFalse(connection.isExcludeTxnFromChangeStreams());
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.hasTransaction());
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertTrue(request.getTransaction().getBegin().getExcludeTxnFromChangeStreams());
  }

  @Test
  public void testTransactionBatchDml() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.setExcludeTxnFromChangeStreams(true);
      connection.executeBatchUpdate(ImmutableList.of(INSERT_STATEMENT, INSERT_STATEMENT));
      connection.commit();

      assertFalse(connection.isExcludeTxnFromChangeStreams());
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertTrue(request.hasTransaction());
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertTrue(request.getTransaction().getBegin().getExcludeTxnFromChangeStreams());
  }

  @Test
  public void testTransactionUpdateReturning() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.setExcludeTxnFromChangeStreams(true);
      connection.executeQuery(INSERT_RETURNING_STATEMENT);
      connection.commit();

      assertFalse(connection.isExcludeTxnFromChangeStreams());
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.hasTransaction());
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertTrue(request.getTransaction().getBegin().getExcludeTxnFromChangeStreams());
  }

  @Test
  public void testSqlStatements() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);

      connection.execute(Statement.of("set exclude_txn_from_change_streams = true"));
      assertTrue(connection.isExcludeTxnFromChangeStreams());

      try (ResultSet resultSet =
          connection
              .execute(Statement.of("show variable exclude_txn_from_change_streams"))
              .getResultSet()) {
        assertTrue(resultSet.next());
        assertTrue(resultSet.getBoolean("EXCLUDE_TXN_FROM_CHANGE_STREAMS"));
        assertFalse(resultSet.next());
      }

      connection.setAutocommit(false);
      connection.execute(Statement.of("set exclude_txn_from_change_streams = true"));
      assertTrue(connection.isExcludeTxnFromChangeStreams());
      connection.execute(INSERT_STATEMENT);
      assertThrows(
          SpannerException.class,
          () -> connection.execute(Statement.of("set exclude_txn_from_change_streams=false")));
    }
  }
}
