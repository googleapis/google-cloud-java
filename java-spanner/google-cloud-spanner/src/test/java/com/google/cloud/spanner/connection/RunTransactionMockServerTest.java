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
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerApiFutures;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.SpannerOptionsTestHelper;
import com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState;
import com.google.protobuf.ByteString;
import com.google.rpc.RetryInfo;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.protobuf.ProtoUtils;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
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

  @Test
  public void testRunTransactionCommitAbortedWithAutocommit() {
    for (IsolationLevel isolationLevel : DEFAULT_ISOLATION_LEVEL.getValidValues()) {
      for (ReadLockMode readLockMode : READ_LOCK_MODE.getValidValues()) {
        final AtomicInteger attempts = new AtomicInteger();
        final AtomicReference<UnitOfWork> firstAttemptUow = new AtomicReference<>();
        try (Connection connection = createConnection()) {
          connection.setAutocommit(true);
          connection.setDefaultIsolationLevel(isolationLevel);
          connection.setReadLockMode(readLockMode);
          connection.runTransaction(
              transaction -> {
                int attempt = attempts.incrementAndGet();
                assertTrue(transaction.isInTransaction());
                assertFalse(transaction.isRetryAbortsInternally());
                UnitOfWork currentUow =
                    ((ConnectionImpl) transaction).getCurrentUnitOfWorkOrStartNewUnitOfWork();
                if (attempt == 1) {
                  firstAttemptUow.set(currentUow);
                } else {
                  assertSame(firstAttemptUow.get(), currentUow);
                }
                assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                if (attempt == 1) {
                  mockSpanner.abortNextStatement();
                }
                return null;
              });
          assertTrue(connection.isAutocommit());
          assertFalse(connection.isInTransaction());
          assertTrue(connection.isRetryAbortsInternally());
        }
        assertEquals(2, attempts.get());
        List<ExecuteSqlRequest> sqlRequests =
            mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
        assertEquals(4, sqlRequests.size());
        assertEquals(2, mockSpanner.countRequestsOfType(CommitRequest.class));
        assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));

        for (ExecuteSqlRequest request : sqlRequests) {
          assertTrue(request.hasTransaction());
          assertFalse(request.getTransaction().hasSingleUse());
        }
        assertTrue(sqlRequests.get(0).getTransaction().hasBegin());
        assertTrue(sqlRequests.get(1).getTransaction().hasId());
        assertTrue(sqlRequests.get(2).getTransaction().hasBegin());
        assertTrue(sqlRequests.get(3).getTransaction().hasId());
        for (int i : new int[] {0, 2}) {
          TransactionOptions options = sqlRequests.get(i).getTransaction().getBegin();
          assertEquals(isolationLevel, options.getIsolationLevel());
          assertEquals(readLockMode, options.getReadWrite().getReadLockMode());
        }

        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testRunTransactionCommitAbortedThenCallableFailsWithAutocommit() {
    final AtomicInteger attempts = new AtomicInteger();
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      IllegalStateException exception =
          assertThrows(
              IllegalStateException.class,
              () ->
                  connection.runTransaction(
                      transaction -> {
                        int attempt = attempts.incrementAndGet();
                        assertTrue(transaction.isInTransaction());
                        assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                        if (attempt == 1) {
                          mockSpanner.abortNextStatement();
                          return null;
                        }
                        throw new IllegalStateException("callable failure on retry");
                      }));
      assertEquals("callable failure on retry", exception.getMessage());
      assertTrue(connection.isAutocommit());
      assertFalse(connection.isInTransaction());
      assertFalse(connection.isTransactionStarted());
      assertTrue(connection.isRetryAbortsInternally());
    }
    assertEquals(2, attempts.get());
    List<ExecuteSqlRequest> sqlRequests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
    assertEquals(2, sqlRequests.size());
    for (ExecuteSqlRequest request : sqlRequests) {
      assertTrue(request.hasTransaction());
      assertTrue(request.getTransaction().hasBegin());
      assertFalse(request.getTransaction().hasSingleUse());
    }
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(RollbackRequest.class));
  }

  @Test
  public void testRunTransactionCommitAbortedResetsSavepointsMutationsAndLocalState() {
    final AtomicInteger retryListenerCalls = new AtomicInteger();
    TransactionRetryListener listener =
        new TransactionRetryListener() {
          @Override
          public void retryStarting(
              Timestamp transactionStarted, long transactionId, int retryAttempt) {
            retryListenerCalls.incrementAndGet();
          }

          @Override
          public void retryFinished(
              Timestamp transactionStarted,
              long transactionId,
              int retryAttempt,
              RetryResult result) {
            retryListenerCalls.incrementAndGet();
          }
        };

    try (Connection connection = createConnection()) {
      connection.addTransactionRetryListener(listener);

      // 1. Statement ABORTED retry (autocommit=false): savepoints, mutations, and local state
      // reset.
      final AtomicInteger statementAbortAttempts = new AtomicInteger();
      final AtomicReference<UnitOfWork> firstUow = new AtomicReference<>();
      connection.runTransaction(
          transaction -> {
            int attempt = statementAbortAttempts.incrementAndGet();
            ConnectionImpl impl = (ConnectionImpl) transaction;
            AbstractMultiUseTransaction uow =
                (AbstractMultiUseTransaction) impl.getCurrentUnitOfWorkOrStartNewUnitOfWork();
            assertFalse(transaction.isRetryAbortsInternally());
            if (attempt == 1) {
              firstUow.set(uow);
              assertFalse(transaction.isReturnCommitStats());
              impl.setReturnCommitStats(true, /* local= */ true);
              assertTrue(transaction.isReturnCommitStats());
              transaction.savepoint("sp_stmt");
              transaction.bufferedWrite(Mutation.newInsertBuilder("TEST").set("ID").to(1L).build());
              assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
              mockSpanner.abortNextStatement();
              transaction.executeUpdate(INSERT_STATEMENT);
              return null;
            }
            assertSame(firstUow.get(), uow);
            assertFalse(transaction.isReturnCommitStats());
            assertTrue(uow.getSavepoints().isEmpty());
            transaction.savepoint("sp_stmt");
            transaction.bufferedWrite(Mutation.newInsertBuilder("TEST").set("ID").to(2L).build());
            assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
            return null;
          });
      assertEquals(2, statementAbortAttempts.get());
      assertEquals(0, retryListenerCalls.get());
      List<CommitRequest> stmtCommitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
      assertEquals(1, stmtCommitRequests.size());
      assertFalse(stmtCommitRequests.get(0).getReturnCommitStats());
      assertEquals(1, stmtCommitRequests.get(0).getMutationsCount());
      assertEquals(
          "2",
          stmtCommitRequests
              .get(0)
              .getMutations(0)
              .getInsert()
              .getValues(0)
              .getValues(0)
              .getStringValue());

      // 2. Commit ABORTED retry (autocommit=true): savepoints, mutations, and local state reset.
      mockSpanner.clearRequests();
      connection.setAutocommit(true);
      final AtomicInteger commitAbortAttempts = new AtomicInteger();
      final AtomicReference<UnitOfWork> firstCommitUow = new AtomicReference<>();
      connection.runTransaction(
          transaction -> {
            int attempt = commitAbortAttempts.incrementAndGet();
            ConnectionImpl impl = (ConnectionImpl) transaction;
            AbstractMultiUseTransaction uow =
                (AbstractMultiUseTransaction) impl.getCurrentUnitOfWorkOrStartNewUnitOfWork();
            assertFalse(transaction.isRetryAbortsInternally());
            if (attempt == 1) {
              firstCommitUow.set(uow);
              assertFalse(transaction.isReturnCommitStats());
              impl.setReturnCommitStats(true, /* local= */ true);
              assertTrue(transaction.isReturnCommitStats());
              transaction.savepoint("sp_commit");
              transaction.write(Mutation.newInsertBuilder("TEST").set("ID").to(10L).build());
              assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
              mockSpanner.abortNextStatement();
              return null;
            }
            assertSame(firstCommitUow.get(), uow);
            assertFalse(transaction.isReturnCommitStats());
            assertTrue(uow.getSavepoints().isEmpty());
            transaction.savepoint("sp_commit");
            transaction.write(Mutation.newInsertBuilder("TEST").set("ID").to(20L).build());
            assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
            return null;
          });
      assertEquals(2, commitAbortAttempts.get());
      assertEquals(0, retryListenerCalls.get());
      List<CommitRequest> commitRequests = mockSpanner.getRequestsOfType(CommitRequest.class);
      assertEquals(2, commitRequests.size());
      assertFalse(commitRequests.get(0).getReturnCommitStats());
      assertFalse(commitRequests.get(1).getReturnCommitStats());
      assertEquals(1, commitRequests.get(1).getMutationsCount());
      assertEquals(
          "20",
          commitRequests
              .get(1)
              .getMutations(0)
              .getInsert()
              .getValues(0)
              .getValues(0)
              .getStringValue());
    }
  }

  @Test
  public void testRunTransactionNonAbortFailuresAndInterruptedBackoff() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);

      // 1. Non-abort Commit RPC failure propagates original exception and resets state.
      mockSpanner.setCommitExecutionTime(
          SimulatedExecutionTime.ofException(
              Status.PERMISSION_DENIED.withDescription("commit denied").asRuntimeException()));
      SpannerException commitFailure =
          assertThrows(
              SpannerException.class,
              () ->
                  connection.runTransaction(
                      transaction -> {
                        assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                        return null;
                      }));
      assertEquals(ErrorCode.PERMISSION_DENIED, commitFailure.getErrorCode());
      assertTrue(commitFailure.getMessage(), commitFailure.getMessage().contains("commit denied"));
      assertFalse(connection.isInTransaction());
      assertFalse(connection.isTransactionStarted());
      assertTrue(connection.isRetryAbortsInternally());
      mockSpanner.removeAllExecutionTimes();
      mockSpanner.clearRequests();

      // 2a. Callable catches statement AbortedException and throws non-abort exception.
      IllegalArgumentException caughtAbortFailure =
          assertThrows(
              IllegalArgumentException.class,
              () ->
                  connection.runTransaction(
                      transaction -> {
                        mockSpanner.abortNextStatement();
                        try {
                          transaction.executeUpdate(INSERT_STATEMENT);
                        } catch (SpannerException ignored) {
                          // Intentionally swallow abort and throw application error.
                        }
                        throw new IllegalArgumentException("failed after caught abort");
                      }));
      assertEquals("failed after caught abort", caughtAbortFailure.getMessage());
      assertEquals(0, mockSpanner.countRequestsOfType(RollbackRequest.class));
      assertFalse(connection.isInTransaction());
      assertTrue(connection.isRetryAbortsInternally());
      mockSpanner.clearRequests();

      // 2b. Callable catches statement AbortedException and returns normally: runner detects
      // aborted transaction before commit and retries cleanly.
      final AtomicInteger swallowedAbortAttempts = new AtomicInteger();
      String recovered =
          connection.runTransaction(
              transaction -> {
                if (swallowedAbortAttempts.incrementAndGet() == 1) {
                  mockSpanner.abortNextStatement();
                  try {
                    transaction.executeUpdate(INSERT_STATEMENT);
                  } catch (SpannerException ignored) {
                    // Intentionally swallow abort and return normally.
                  }
                  return "stale";
                }
                assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                return "recovered";
              });
      assertEquals("recovered", recovered);
      assertEquals(2, swallowedAbortAttempts.get());
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      mockSpanner.clearRequests();

      // 3. Interrupted commit during Commit abort cleanup propagates CANCELLED without
      // FAILED_PRECONDITION and leaves connection usable.
      try {
        SpannerException interrupted =
            assertThrows(
                SpannerException.class,
                () ->
                    connection.runTransaction(
                        transaction -> {
                          assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                          mockSpanner.abortNextStatement();
                          Thread.currentThread().interrupt();
                          return null;
                        }));
        assertEquals(ErrorCode.CANCELLED, interrupted.getErrorCode());
        assertTrue(Thread.interrupted());
      } finally {
        Thread.interrupted();
      }
      assertFalse(connection.isInTransaction());
      assertFalse(connection.isTransactionStarted());
      assertTrue(connection.isRetryAbortsInternally());

      mockSpanner.clearRequests();
      connection.runTransaction(
          transaction -> {
            assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
            return null;
          });
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
    }
  }

  @Test
  public void testRunTransactionSpanAndSessionLifecycleOnAborts() {
    SpannerOptionsTestHelper.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();
    InMemorySpanExporter spanExporter = InMemorySpanExporter.create();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder()
            .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
            .setTracerProvider(tracerProvider)
            .build();

    try {
      try (Connection connection = createTracingConnection(openTelemetry, ";autocommit=true")) {
        // 1. Commit-abort retry: 0 finished transaction spans mid-retry, 1 of each after commit.
        final AtomicInteger commitRetryAttempts = new AtomicInteger();
        connection.runTransaction(
            transaction -> {
              int attempt = commitRetryAttempts.incrementAndGet();
              if (attempt == 2) {
                assertEquals(
                    0L, countFinishedSpans(spanExporter, "CloudSpannerJdbc.ReadWriteTransaction"));
                assertEquals(
                    0L, countFinishedSpans(spanExporter, "CloudSpanner.ReadWriteTransaction"));
              }
              assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
              if (attempt == 1) {
                mockSpanner.abortNextStatement();
              }
              return null;
            });
        assertEquals(2, commitRetryAttempts.get());
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpannerJdbc.ReadWriteTransaction"));
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpanner.ReadWriteTransaction"));

        // 2. Statement-abort retry: 0 finished transaction spans mid-retry, 1 of each after commit.
        spanExporter.reset();
        mockSpanner.clearRequests();
        final AtomicInteger stmtRetryAttempts = new AtomicInteger();
        connection.runTransaction(
            transaction -> {
              int attempt = stmtRetryAttempts.incrementAndGet();
              if (attempt == 2) {
                assertEquals(
                    0L, countFinishedSpans(spanExporter, "CloudSpannerJdbc.ReadWriteTransaction"));
                assertEquals(
                    0L, countFinishedSpans(spanExporter, "CloudSpanner.ReadWriteTransaction"));
              }
              assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
              if (attempt == 1) {
                mockSpanner.abortNextStatement();
              }
              assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
              return null;
            });
        assertEquals(2, stmtRetryAttempts.get());
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpannerJdbc.ReadWriteTransaction"));
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpanner.ReadWriteTransaction"));

        // 3. Caught-abort failure: exactly 1 finished unit-of-work and TransactionManager span.
        spanExporter.reset();
        mockSpanner.clearRequests();
        assertThrows(
            IllegalStateException.class,
            () ->
                connection.runTransaction(
                    transaction -> {
                      assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                      mockSpanner.abortNextStatement();
                      try {
                        transaction.executeUpdate(INSERT_STATEMENT);
                      } catch (SpannerException ignored) {
                        // Swallow abort and fail with non-abort exception.
                      }
                      throw new IllegalStateException("caught abort failure");
                    }));
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpannerJdbc.ReadWriteTransaction"));
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpanner.ReadWriteTransaction"));

        // 4. Interrupted commit: exactly 1 finished unit-of-work and TransactionManager span.
        spanExporter.reset();
        mockSpanner.clearRequests();
        try {
          SpannerException interrupted =
              assertThrows(
                  SpannerException.class,
                  () ->
                      connection.runTransaction(
                          transaction -> {
                            assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                            mockSpanner.abortNextStatement();
                            Thread.currentThread().interrupt();
                            return null;
                          }));
          assertEquals(ErrorCode.CANCELLED, interrupted.getErrorCode());
        } finally {
          Thread.interrupted();
        }
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpannerJdbc.ReadWriteTransaction"));
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpanner.ReadWriteTransaction"));
      }
    } finally {
      SpannerPool.closeSpannerPool();
      openTelemetry.close();
      SpannerOptionsTestHelper.resetActiveTracingFramework();
    }
  }

  @Test
  public void testRunTransactionSyntheticAbortDelayedStartAndActiveDmlBatch() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);

      // 1. Pre-statement synthetic AbortedException (txManager == null).
      final AtomicInteger preStmtAttempts = new AtomicInteger();
      String preStmtResult =
          connection.runTransaction(
              transaction -> {
                if (preStmtAttempts.incrementAndGet() == 1) {
                  throw SpannerExceptionFactory.newSpannerException(
                      ErrorCode.ABORTED, "synthetic pre-statement abort");
                }
                assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                return "pre-stmt-ok";
              });
      assertEquals("pre-stmt-ok", preStmtResult);
      assertEquals(2, preStmtAttempts.get());
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(0, mockSpanner.countRequestsOfType(RollbackRequest.class));
      mockSpanner.clearRequests();

      // 2. Synthetic AbortedException thrown by callable after INSERT (rolls back STARTED
      // txManager).
      final AtomicInteger postInsertAttempts = new AtomicInteger();
      connection.runTransaction(
          transaction -> {
            assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
            if (postInsertAttempts.incrementAndGet() == 1) {
              throw SpannerExceptionFactory.newSpannerException(
                  ErrorCode.ABORTED, "synthetic post-insert abort");
            }
            return null;
          });
      assertEquals(2, postInsertAttempts.get());
      assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(1, mockSpanner.countRequestsOfType(RollbackRequest.class));
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      mockSpanner.clearRequests();

      // 3. delayTransactionStartUntilFirstWrite=true read-then-abort (txManager remains null on
      // Attempt 1).
      connection.setDelayTransactionStartUntilFirstWrite(true);
      try {
        final AtomicInteger delayedAttempts = new AtomicInteger();
        connection.runTransaction(
            transaction -> {
              try (ResultSet rs = transaction.executeQuery(SELECT1_STATEMENT)) {
                assertTrue(rs.next());
              }
              if (delayedAttempts.incrementAndGet() == 1) {
                throw SpannerExceptionFactory.newSpannerException(
                    ErrorCode.ABORTED, "synthetic delayed-start abort");
              }
              assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
              return null;
            });
        assertEquals(2, delayedAttempts.get());
        assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
        assertEquals(0, mockSpanner.countRequestsOfType(RollbackRequest.class));
      } finally {
        connection.setDelayTransactionStartUntilFirstWrite(false);
      }
      mockSpanner.clearRequests();

      // 4a. Abort while DML batch is active resets batch state and succeeds on retry.
      final AtomicInteger batchAbortAttempts = new AtomicInteger();
      connection.runTransaction(
          transaction -> {
            transaction.startBatchDml();
            transaction.executeUpdate(INSERT_STATEMENT);
            if (batchAbortAttempts.incrementAndGet() == 1) {
              throw SpannerExceptionFactory.newSpannerException(
                  ErrorCode.ABORTED, "abort during active batch");
            }
            assertArrayEquals(new long[] {1L}, transaction.runBatch());
            return null;
          });
      assertFalse(connection.isDmlBatchActive());
      assertEquals(2, batchAbortAttempts.get());
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      mockSpanner.clearRequests();

      // 4b. Non-abort failure while DML batch is active aborts batch and rolls back transaction.
      IllegalStateException batchFailure =
          assertThrows(
              IllegalStateException.class,
              () ->
                  connection.runTransaction(
                      transaction -> {
                        assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                        transaction.startBatchDml();
                        transaction.executeUpdate(INSERT_STATEMENT);
                        throw new IllegalStateException("failure during active batch");
                      }));
      assertEquals("failure during active batch", batchFailure.getMessage());
      assertFalse(connection.isDmlBatchActive());
      assertFalse(connection.isInTransaction());
      assertEquals(1, mockSpanner.countRequestsOfType(RollbackRequest.class));
    }
  }

  @Test
  public void testApplicationCommitAbortClosesTransaction() {
    SpannerOptionsTestHelper.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();
    InMemorySpanExporter spanExporter = InMemorySpanExporter.create();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder()
            .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
            .setTracerProvider(tracerProvider)
            .build();

    try {
      try (Connection connection = createTracingConnection(openTelemetry, "")) {
        connection.setRetryAbortsInternally(false);
        assertFalse(connection.isRetryAbortsInternally());
        // 1. Direct application commit() outside runTransaction transitions to COMMIT_FAILED and
        // closes txManager + unit-of-work span.
        assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
        UnitOfWork directUowBefore =
            ((ConnectionImpl) connection).getCurrentUnitOfWorkOrStartNewUnitOfWork();
        mockSpanner.abortNextStatement();
        assertThrows(AbortedException.class, connection::commit);
        assertEquals(UnitOfWorkState.COMMIT_FAILED, directUowBefore.getState());
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpannerJdbc.ReadWriteTransaction"));
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpanner.ReadWriteTransaction"));

        // 2. Run runTransaction with commit abort on the same connection, then verify subsequent
        // direct application commit() still closes transaction with COMMIT_FAILED.
        spanExporter.reset();
        mockSpanner.clearRequests();
        connection.setAutocommit(true);
        final AtomicInteger runnerAttempts = new AtomicInteger();
        connection.runTransaction(
            transaction -> {
              assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
              if (runnerAttempts.incrementAndGet() == 1) {
                mockSpanner.abortNextStatement();
              }
              return null;
            });
        assertEquals(2, runnerAttempts.get());
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpannerJdbc.ReadWriteTransaction"));
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpanner.ReadWriteTransaction"));

        spanExporter.reset();
        mockSpanner.clearRequests();
        connection.beginTransaction();
        assertFalse(connection.isRetryAbortsInternally());
        assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
        UnitOfWork directUowAfter =
            ((ConnectionImpl) connection).getCurrentUnitOfWorkOrStartNewUnitOfWork();
        mockSpanner.abortNextStatement();
        assertThrows(AbortedException.class, connection::commit);
        assertEquals(UnitOfWorkState.COMMIT_FAILED, directUowAfter.getState());
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpannerJdbc.ReadWriteTransaction"));
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpanner.ReadWriteTransaction"));
      }
    } finally {
      SpannerPool.closeSpannerPool();
      openTelemetry.close();
      SpannerOptionsTestHelper.resetActiveTracingFramework();
    }
  }

  @Test
  public void testRunTransactionInterruptedDuringBackoffAfterAbort() {
    // 1. Statement abort with pre-set interrupt closes kept-open aborted txManager without sending
    // a Rollback RPC.
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () ->
                  connection.runTransaction(
                      transaction -> {
                        assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                        mockSpanner.abortNextStatement();
                        AbortedException aborted =
                            assertThrows(
                                AbortedException.class,
                                () -> transaction.executeUpdate(INSERT_STATEMENT));
                        // Pre-setting the interrupt flag ensures Thread.sleep(...) in the runner's
                        // catch (AbortedException) block deterministically throws
                        // InterruptedException immediately without sleeping or background threads.
                        Thread.currentThread().interrupt();
                        throw aborted;
                      }));
      assertEquals(ErrorCode.CANCELLED, exception.getErrorCode());
      assertTrue(Thread.interrupted());
      assertFalse(connection.isInTransaction());
      assertFalse(connection.isTransactionStarted());
      assertTrue(connection.isRetryAbortsInternally());
    } finally {
      Thread.interrupted();
    }
    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(RollbackRequest.class));
    mockSpanner.clearRequests();

    // 2. Active DML batch + pre-set interrupt during post-abort backoff exercises
    // rollbackAfterAbort() (whereas rollbackAsync() would fail with FAILED_PRECONDITION due to the
    // active batch and mask CANCELLED).
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () ->
                  connection.runTransaction(
                      transaction -> {
                        assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
                        transaction.startBatchDml();
                        transaction.executeUpdate(INSERT_STATEMENT);
                        Thread.currentThread().interrupt();
                        throw SpannerExceptionFactory.newSpannerException(
                            ErrorCode.ABORTED, "abort during active batch");
                      }));
      assertEquals(ErrorCode.CANCELLED, exception.getErrorCode());
      assertTrue(Thread.interrupted());
      assertFalse(connection.isDmlBatchActive());
      assertFalse(connection.isInTransaction());
      assertFalse(connection.isTransactionStarted());
      assertTrue(connection.isRetryAbortsInternally());
    } finally {
      Thread.interrupted();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(RollbackRequest.class));
  }

  @Test
  public void testTimedOutAsyncStatementBeforeCommitEndsSpanAndClosesTransaction() {
    SpannerOptionsTestHelper.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();
    InMemorySpanExporter spanExporter = InMemorySpanExporter.create();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder()
            .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
            .setTracerProvider(tracerProvider)
            .build();

    try {
      try (Connection connection = createTracingConnection(openTelemetry, "")) {
        connection.setRetryAbortsInternally(false);
        assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
        UnitOfWork uow = ((ConnectionImpl) connection).getCurrentUnitOfWorkOrStartNewUnitOfWork();

        connection.setStatementTimeout(15L, TimeUnit.MILLISECONDS);
        mockSpanner.freeze();
        ApiFuture<Long> timedOutDml;
        ApiFuture<Void> queuedCommit;
        try {
          timedOutDml = connection.executeUpdateAsync(INSERT_STATEMENT);
          queuedCommit = connection.commitAsync();
          SpannerException dmlTimeout =
              assertThrows(SpannerException.class, () -> SpannerApiFutures.get(timedOutDml));
          assertEquals(ErrorCode.DEADLINE_EXCEEDED, dmlTimeout.getErrorCode());
        } finally {
          mockSpanner.unfreeze();
        }
        SpannerException commitFailure =
            assertThrows(SpannerException.class, () -> SpannerApiFutures.get(queuedCommit));
        assertEquals(ErrorCode.FAILED_PRECONDITION, commitFailure.getErrorCode());
        assertEquals(UnitOfWorkState.COMMIT_FAILED, uow.getState());
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpannerJdbc.ReadWriteTransaction"));
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpanner.ReadWriteTransaction"));
      }
    } finally {
      mockSpanner.unfreeze();
      SpannerPool.closeSpannerPool();
      openTelemetry.close();
      SpannerOptionsTestHelper.resetActiveTracingFramework();
    }
  }

  @Test
  public void testSyntheticAbortWithoutRetryInfoAppliesExponentialBackoff() {
    for (int attempt = 0; attempt <= 25; attempt++) {
      long expectedMax = Math.min(32_000L, 1L << Math.min(attempt + 1, 15));
      long expectedMin = Math.max(1L, expectedMax / 2L);
      for (int sample = 0; sample < 20; sample++) {
        long delayMillis = TransactionRunnerImpl.nextFallbackBackoffMillis(attempt);
        assertTrue(
            "Attempt "
                + attempt
                + " delay "
                + delayMillis
                + "ms outside ["
                + expectedMin
                + ", "
                + expectedMax
                + "]",
            delayMillis >= expectedMin && delayMillis <= expectedMax);
      }
    }
  }

  @Test
  public void testResetForRetryHandlesNonAbortedManagerAndPreservesPreviousTransactionId() {
    // 1. When internal retry fails with concurrent modification, ReadWriteTransaction rolls back
    // txManager (ROLLED_BACK) and marks itself ABORTED; resetForRetry() must fall back cleanly
    // instead of throwing IllegalStateException from txManager.resetForRetry().
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.setRetryAbortsInternally(true);
      ReadWriteTransaction uow =
          (ReadWriteTransaction)
              ((ConnectionImpl) connection).getCurrentUnitOfWorkOrStartNewUnitOfWork();
      try {
        try (ResultSet rs = connection.executeQuery(SELECT_COUNT_STATEMENT)) {
          assertTrue(rs.next());
          assertEquals(COUNT_BEFORE_INSERT, rs.getLong(0));
        }
        mockSpanner.putStatementResult(
            StatementResult.query(SELECT_COUNT_STATEMENT, SELECT_COUNT_RESULTSET_AFTER_INSERT));
        mockSpanner.abortNextStatement();
        assertThrows(AbortedException.class, () -> connection.executeUpdate(INSERT_STATEMENT));
      } finally {
        mockSpanner.putStatementResult(
            StatementResult.query(SELECT_COUNT_STATEMENT, SELECT_COUNT_RESULTSET_BEFORE_INSERT));
      }
      assertEquals(UnitOfWorkState.ABORTED, uow.getState());
      assertNotNull(uow.getAbortedException());
      uow.resetForRetry();
      assertEquals(UnitOfWorkState.STARTED, uow.getState());
      assertNull(uow.getAbortedException());
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      connection.commit();
      mockSpanner.clearRequests();

      // 2. Statement-level backend abort leaves txManager.getState() as STARTED while
      // txn.isAborted() is true; resetForRetry() must still invoke txManager.resetForRetry() so
      // multiplexed sessions forward the aborted attempt's transaction ID on retry.
      connection.setAutocommit(true);
      final AtomicInteger stmtAbortAttempts = new AtomicInteger();
      connection.runTransaction(
          transaction -> {
            assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
            if (stmtAbortAttempts.incrementAndGet() == 1) {
              mockSpanner.abortNextStatement();
            }
            assertEquals(1L, transaction.executeUpdate(INSERT_STATEMENT));
            return null;
          });
      assertEquals(2, stmtAbortAttempts.get());
      List<ExecuteSqlRequest> sqlRequests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
      assertEquals(4, sqlRequests.size());
      assertTrue(sqlRequests.get(1).getTransaction().hasId());
      assertNotEquals(ByteString.EMPTY, sqlRequests.get(1).getTransaction().getId());
      assertEquals(
          sqlRequests.get(1).getTransaction().getId(),
          sqlRequests
              .get(2)
              .getTransaction()
              .getBegin()
              .getReadWrite()
              .getMultiplexedSessionPreviousTransactionId());
    }
  }

  @Test
  public void testRunTransactionMidStreamQueryAbort() {
    SpannerOptionsTestHelper.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();
    InMemorySpanExporter spanExporter = InMemorySpanExporter.create();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
            .build();
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder()
            .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
            .setTracerProvider(tracerProvider)
            .build();

    try {
      try (Connection connection = createTracingConnection(openTelemetry, ";autocommit=true")) {
        Metadata trailers = new Metadata();
        trailers.put(
            ProtoUtils.keyForProto(RetryInfo.getDefaultInstance()),
            RetryInfo.newBuilder()
                .setRetryDelay(com.google.protobuf.Duration.newBuilder().setNanos(1_000_000))
                .build());

        // 1. Uncaught mid-stream abort on ResultSet.next() (after row 0 succeeded) must preserve
        // a single CloudSpanner.ReadWriteTransaction span and forward previousTransactionId.
        mockSpanner.setExecuteStreamingSqlExecutionTime(
            SimulatedExecutionTime.ofStreamException(
                Status.ABORTED.withDescription("mid-stream abort").asRuntimeException(trailers),
                2L));
        final AtomicInteger attempts = new AtomicInteger();
        int rowCount =
            connection.runTransaction(
                transaction -> {
                  attempts.incrementAndGet();
                  int rows = 0;
                  try (ResultSet resultSet = transaction.executeQuery(SELECT_RANDOM_STATEMENT)) {
                    while (resultSet.next()) {
                      rows++;
                    }
                  }
                  return rows;
                });
        assertEquals(RANDOM_RESULT_SET_ROW_COUNT, rowCount);
        assertEquals(2, attempts.get());
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpannerJdbc.ReadWriteTransaction"));
        assertEquals(1L, countFinishedSpans(spanExporter, "CloudSpanner.ReadWriteTransaction"));
        List<ExecuteSqlRequest> streamRequests =
            mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
        assertEquals(2, streamRequests.size());
        assertNotEquals(
            ByteString.EMPTY,
            streamRequests
                .get(1)
                .getTransaction()
                .getBegin()
                .getReadWrite()
                .getMultiplexedSessionPreviousTransactionId());

        // 2. Caught mid-stream abort on ResultSet.next() + thrown non-abort exception must not
        // send an unnecessary Rollback RPC on the already-aborted transaction.
        mockSpanner.clearRequests();
        mockSpanner.setExecuteStreamingSqlExecutionTime(
            SimulatedExecutionTime.ofStreamException(
                Status.ABORTED.withDescription("mid-stream abort").asRuntimeException(trailers),
                2L));
        assertThrows(
            IllegalStateException.class,
            () ->
                connection.runTransaction(
                    transaction -> {
                      try (ResultSet resultSet =
                          transaction.executeQuery(SELECT_RANDOM_STATEMENT)) {
                        while (resultSet.next()) {
                          // Consume until mid-stream abort.
                        }
                      } catch (AbortedException ignored) {
                        // Swallow abort and fail with non-abort exception.
                      }
                      throw new IllegalStateException("failed after caught mid-stream abort");
                    }));
        assertEquals(0, mockSpanner.countRequestsOfType(RollbackRequest.class));

        // 3. Caught mid-stream abort on ResultSet.next() + normal return must re-surface the
        // stored AbortedException before commitAsync and retry cleanly.
        mockSpanner.clearRequests();
        mockSpanner.setExecuteStreamingSqlExecutionTime(
            SimulatedExecutionTime.ofStreamException(
                Status.ABORTED.withDescription("mid-stream abort").asRuntimeException(trailers),
                2L));
        final AtomicInteger swallowedMidStreamAttempts = new AtomicInteger();
        int recoveredRows =
            connection.runTransaction(
                transaction -> {
                  int attempt = swallowedMidStreamAttempts.incrementAndGet();
                  int rows = 0;
                  try (ResultSet resultSet = transaction.executeQuery(SELECT_RANDOM_STATEMENT)) {
                    while (resultSet.next()) {
                      rows++;
                    }
                  } catch (AbortedException ignored) {
                    assertEquals(1, attempt);
                    return -1;
                  }
                  return rows;
                });
        assertEquals(RANDOM_RESULT_SET_ROW_COUNT, recoveredRows);
        assertEquals(2, swallowedMidStreamAttempts.get());
      }
    } finally {
      mockSpanner.removeAllExecutionTimes();
      SpannerPool.closeSpannerPool();
      openTelemetry.close();
      SpannerOptionsTestHelper.resetActiveTracingFramework();
    }
  }

  private Connection createTracingConnection(
      OpenTelemetry openTelemetry, String additionalUrlOptions) {
    return ConnectionOptions.newBuilder()
        .setTracingPrefix("CloudSpannerJdbc")
        .setOpenTelemetry(openTelemetry)
        .setUri(getBaseUrl() + additionalUrlOptions)
        .build()
        .getConnection();
  }

  private static long countFinishedSpans(InMemorySpanExporter exporter, String spanName) {
    assertEquals(CompletableResultCode.ofSuccess(), exporter.flush());
    return exporter.getFinishedSpanItems().stream()
        .filter(span -> span.getName().equals(spanName))
        .count();
  }
}
