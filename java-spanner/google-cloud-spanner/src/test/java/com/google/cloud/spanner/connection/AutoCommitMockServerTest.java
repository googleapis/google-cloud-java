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

import static com.google.cloud.spanner.connection.ConnectionProperties.DEFAULT_ISOLATION_LEVEL;
import static com.google.cloud.spanner.connection.ConnectionProperties.READ_LOCK_MODE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest.ITConnection;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AutoCommitMockServerTest extends AbstractMockServerTest {

  @Parameter(0)
  public IsolationLevel isolationLevel;

  @Parameter(1)
  public ReadLockMode readLockMode;

  @Parameters(name = "isolationLevel = {0}, readLockMode = {1}")
  public static Collection<Object[]> data() {
    List<Object[]> result = new ArrayList<>();
    for (IsolationLevel isolationLevel : DEFAULT_ISOLATION_LEVEL.getValidValues()) {
      for (ReadLockMode readLockMode : READ_LOCK_MODE.getValidValues()) {
        result.add(new Object[] {isolationLevel, readLockMode});
      }
    }
    return result;
  }

  @Override
  protected ITConnection createConnection() {
    return createConnection(
        Collections.emptyList(),
        Collections.emptyList(),
        String.format(
            ";default_isolation_level=%s;read_lock_mode=%s", isolationLevel, readLockMode));
  }

  @Test
  public void testQuery() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      //noinspection EmptyTryBlock
      try (ResultSet ignore = connection.executeQuery(SELECT1_STATEMENT)) {}
      try (ResultSet ignore =
          connection.executeQuery(Statement.of("SHOW VARIABLE READ_LOCK_MODE"))) {}
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.getTransaction().hasSingleUse());
    assertTrue(request.getTransaction().getSingleUse().hasReadOnly());
    assertEquals(
        IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED,
        request.getTransaction().getSingleUse().getIsolationLevel());
    assertFalse(request.getLastStatement());
  }

  @Test
  public void testDml() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.executeUpdate(INSERT_STATEMENT);
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertEquals(isolationLevel, request.getTransaction().getBegin().getIsolationLevel());
    assertEquals(
        readLockMode, request.getTransaction().getBegin().getReadWrite().getReadLockMode());
    assertTrue(request.getLastStatement());
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testDmlFailed() {
    Statement invalidInsert = Statement.of("insert into my_table (id, name) values (1, 'test')");
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.exception(
            invalidInsert,
            Status.ALREADY_EXISTS.withDescription("Row 1 already exists").asRuntimeException()));

    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      SpannerException exception =
          assertThrows(SpannerException.class, () -> connection.executeUpdate(invalidInsert));
      assertEquals(ErrorCode.ALREADY_EXISTS, exception.getErrorCode());
    }
    assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertEquals(isolationLevel, request.getTransaction().getBegin().getIsolationLevel());
    assertEquals(
        readLockMode, request.getTransaction().getBegin().getReadWrite().getReadLockMode());
    assertTrue(request.getLastStatement());
    // There should be no rollback request on the server, as there was no transaction ID returned
    // to the client.
    assertEquals(0, mockSpanner.countRequestsOfType(RollbackRequest.class));
  }

  @Test
  public void testDmlReturning() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      //noinspection EmptyTryBlock
      try (ResultSet ignore = connection.executeQuery(INSERT_RETURNING_STATEMENT)) {}
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertEquals(isolationLevel, request.getTransaction().getBegin().getIsolationLevel());
    assertEquals(
        readLockMode, request.getTransaction().getBegin().getReadWrite().getReadLockMode());
    assertTrue(request.getLastStatement());
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testBatchDml() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.startBatchDml();
      connection.executeUpdate(INSERT_STATEMENT);
      connection.executeUpdate(INSERT_STATEMENT);
      connection.runBatch();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
    assertEquals(isolationLevel, request.getTransaction().getBegin().getIsolationLevel());
    assertEquals(
        readLockMode, request.getTransaction().getBegin().getReadWrite().getReadLockMode());
    assertTrue(request.getLastStatements());
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testPartitionedDml() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.setAutocommitDmlMode(AutocommitDmlMode.PARTITIONED_NON_ATOMIC);
      connection.executeUpdate(INSERT_STATEMENT);
    }
    assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    BeginTransactionRequest beginRequest =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class).get(0);
    assertTrue(beginRequest.getOptions().hasPartitionedDml());
    assertEquals(
        IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED, beginRequest.getOptions().getIsolationLevel());
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.getTransaction().hasId());
    assertFalse(request.getLastStatement());
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testDmlAborted() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      mockSpanner.abortNextTransaction();
      connection.executeUpdate(INSERT_STATEMENT);
    }
    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    for (ExecuteSqlRequest request : mockSpanner.getRequestsOfType(ExecuteSqlRequest.class)) {
      assertTrue(request.getTransaction().hasBegin());
      assertTrue(request.getTransaction().getBegin().hasReadWrite());
      assertEquals(isolationLevel, request.getTransaction().getBegin().getIsolationLevel());
      assertEquals(
          readLockMode, request.getTransaction().getBegin().getReadWrite().getReadLockMode());
      assertTrue(request.getLastStatement());
    }
    assertEquals(2, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testDmlReturningAborted() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      mockSpanner.abortNextTransaction();
      //noinspection EmptyTryBlock
      try (ResultSet ignore = connection.executeQuery(INSERT_RETURNING_STATEMENT)) {}
    }
    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    for (ExecuteSqlRequest request : mockSpanner.getRequestsOfType(ExecuteSqlRequest.class)) {
      assertTrue(request.getTransaction().hasBegin());
      assertTrue(request.getTransaction().getBegin().hasReadWrite());
      assertEquals(isolationLevel, request.getTransaction().getBegin().getIsolationLevel());
      assertEquals(
          readLockMode, request.getTransaction().getBegin().getReadWrite().getReadLockMode());
      assertTrue(request.getLastStatement());
    }
    assertEquals(2, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testBatchDmlAborted() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      mockSpanner.abortNextTransaction();
      connection.startBatchDml();
      connection.executeUpdate(INSERT_STATEMENT);
      connection.executeUpdate(INSERT_STATEMENT);
      connection.runBatch();
    }
    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    for (ExecuteBatchDmlRequest request :
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class)) {
      assertTrue(request.getTransaction().hasBegin());
      assertTrue(request.getTransaction().getBegin().hasReadWrite());
      assertEquals(isolationLevel, request.getTransaction().getBegin().getIsolationLevel());
      assertEquals(
          readLockMode, request.getTransaction().getBegin().getReadWrite().getReadLockMode());
      assertTrue(request.getLastStatements());
    }
    assertEquals(2, mockSpanner.countRequestsOfType(CommitRequest.class));
  }
}
