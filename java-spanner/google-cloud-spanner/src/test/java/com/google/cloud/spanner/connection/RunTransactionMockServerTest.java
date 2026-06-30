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
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;
import io.grpc.Status;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RunTransactionMockServerTest extends AbstractMockServerTest {

  @Test
  public void testRunTransaction() {
    for (IsolationLevel isolationLevel : DEFAULT_ISOLATION_LEVEL.getValidValues()) {
      for (ReadLockMode readLockMode : READ_LOCK_MODE.getValidValues()) {
        try (Connection connection = createConnection()) {
          connection.setDefaultIsolationLevel(isolationLevel);
          connection.setReadLockMode(readLockMode);
          connection.runTransaction(
              transaction -> {
                assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                return null;
              });
        }
        assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
        TransactionOptions transactionOptions =
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getTransaction()
                .getBegin();
        assertEquals(isolationLevel, transactionOptions.getIsolationLevel());
        assertEquals(readLockMode, transactionOptions.getReadWrite().getReadLockMode());

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testRunTransactionInAutoCommit() {
    for (IsolationLevel isolationLevel : DEFAULT_ISOLATION_LEVEL.getValidValues()) {
      for (ReadLockMode readLockMode : READ_LOCK_MODE.getValidValues()) {
        try (Connection connection = createConnection()) {
          connection.setAutocommit(true);
          connection.setDefaultIsolationLevel(isolationLevel);
          connection.setReadLockMode(readLockMode);

          connection.runTransaction(
              transaction -> {
                assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                return null;
              });
        }
        assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
        TransactionOptions transactionOptions =
            mockSpanner
                .getRequestsOfType(ExecuteSqlRequest.class)
                .get(0)
                .getTransaction()
                .getBegin();
        assertEquals(isolationLevel, transactionOptions.getIsolationLevel());
        assertEquals(readLockMode, transactionOptions.getReadWrite().getReadLockMode());

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testRunTransactionInReadOnly() {
    try (Connection connection = createConnection()) {
      connection.setReadOnly(true);
      connection.setAutocommit(false);

      assertEquals(
          RANDOM_RESULT_SET_ROW_COUNT,
          connection
              .runTransaction(
                  transaction -> {
                    int rows = 0;
                    try (ResultSet resultSet = transaction.executeQuery(SELECT_RANDOM_STATEMENT)) {
                      while (resultSet.next()) {
                        rows++;
                      }
                    }
                    return rows;
                  })
              .intValue());
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(RollbackRequest.class));
  }

  @Test
  public void testRunTransaction_rollbacksAfterException() {
    try (Connection connection = createConnection()) {
      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () ->
                  connection.runTransaction(
                      transaction -> {
                        assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                        mockSpanner.setExecuteSqlExecutionTime(
                            SimulatedExecutionTime.ofException(
                                Status.INVALID_ARGUMENT
                                    .withDescription("invalid statement")
                                    .asRuntimeException()));
                        // This statement will fail.
                        transaction.executeUpdate(INSERT_STATEMENT);
                        return null;
                      }));
      assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
      assertTrue(exception.getMessage(), exception.getMessage().contains("invalid statement"));
    }
    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(RollbackRequest.class));
  }

  @Test
  public void testRunTransactionCommitAborted() {
    for (IsolationLevel isolationLevel : DEFAULT_ISOLATION_LEVEL.getValidValues()) {
      for (ReadLockMode readLockMode : READ_LOCK_MODE.getValidValues()) {
        final AtomicInteger attempts = new AtomicInteger();
        try (Connection connection = createConnection()) {
          connection.setDefaultIsolationLevel(isolationLevel);
          connection.setReadLockMode(readLockMode);
          connection.runTransaction(
              transaction -> {
                assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                if (attempts.incrementAndGet() == 1) {
                  mockSpanner.abortNextStatement();
                }
                return null;
              });
        }
        assertEquals(2, attempts.get());
        assertEquals(4, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        assertEquals(2, mockSpanner.countRequestsOfType(CommitRequest.class));
        assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));

        for (int i : new int[] {0, 2}) {
          ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(i);
          assertTrue(request.hasTransaction());
          assertTrue(request.getTransaction().hasBegin());
          assertEquals(isolationLevel, request.getTransaction().getBegin().getIsolationLevel());
          assertEquals(
              readLockMode, request.getTransaction().getBegin().getReadWrite().getReadLockMode());
        }

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testRunTransactionDmlAborted() {
    final AtomicInteger attempts = new AtomicInteger();
    try (Connection connection = createConnection()) {
      assertTrue(connection.isRetryAbortsInternally());
      connection.runTransaction(
          transaction -> {
            assertFalse(transaction.isRetryAbortsInternally());
            if (attempts.incrementAndGet() == 1) {
              mockSpanner.abortNextStatement();
            }
            assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
            assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
            return null;
          });
      assertTrue(connection.isRetryAbortsInternally());
    }
    assertEquals(2, attempts.get());
    assertEquals(3, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testRunTransactionQueryAborted() {
    final AtomicInteger attempts = new AtomicInteger();
    try (Connection connection = createConnection()) {
      int rowCount =
          connection.runTransaction(
              transaction -> {
                if (attempts.incrementAndGet() == 1) {
                  mockSpanner.abortNextStatement();
                }
                int rows = 0;
                try (ResultSet resultSet = transaction.executeQuery(SELECT_RANDOM_STATEMENT)) {
                  while (resultSet.next()) {
                    rows++;
                  }
                }
                return rows;
              });
      assertEquals(RANDOM_RESULT_SET_ROW_COUNT, rowCount);
    }
    assertEquals(2, attempts.get());
    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testCommitInRunTransaction() {
    try (Connection connection = createConnection()) {
      connection.runTransaction(
          transaction -> {
            assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
            SpannerException exception = assertThrows(SpannerException.class, transaction::commit);
            assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
            assertEquals(
                "FAILED_PRECONDITION: Cannot call commit when a transaction runner is active",
                exception.getMessage());
            return null;
          });
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testRollbackInRunTransaction() {
    try (Connection connection = createConnection()) {
      connection.runTransaction(
          transaction -> {
            assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
            SpannerException exception =
                assertThrows(SpannerException.class, transaction::rollback);
            assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
            assertEquals(
                "FAILED_PRECONDITION: Cannot call rollback when a transaction runner is active",
                exception.getMessage());
            return null;
          });
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(RollbackRequest.class));
  }
}
