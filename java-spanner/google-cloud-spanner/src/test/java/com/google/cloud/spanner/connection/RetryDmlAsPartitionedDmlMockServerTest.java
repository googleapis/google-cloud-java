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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TransactionMutationLimitExceededException;
import com.google.protobuf.Any;
import com.google.rpc.Help;
import com.google.rpc.Help.Link;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RetryDmlAsPartitionedDmlMockServerTest extends AbstractMockServerTest {
  private enum ExceptionType {
    MutationLimitExceeded {
      @Override
      StatusRuntimeException createException() {
        return createTransactionMutationLimitExceededException();
      }
    },
    ResourceLimitExceeded {
      @Override
      StatusRuntimeException createException() {
        return createTransactionResourceLimitExceededException();
      }
    };

    abstract StatusRuntimeException createException();
  }

  @Parameters(name = "exception = {0}")
  public static Object[] data() {
    return ExceptionType.values();
  }

  @SuppressWarnings("ClassEscapesDefinedScope")
  @Parameter
  public ExceptionType exceptionType;

  static StatusRuntimeException createTransactionMutationLimitExceededException() {
    Metadata.Key<byte[]> key =
        Metadata.Key.of("grpc-status-details-bin", Metadata.BINARY_BYTE_MARSHALLER);
    Help help =
        Help.newBuilder()
            .addLinks(
                Link.newBuilder()
                    .setDescription("Cloud Spanner limits documentation.")
                    .setUrl("https://cloud.google.com/spanner/docs/limits")
                    .build())
            .build();
    com.google.rpc.Status status =
        com.google.rpc.Status.newBuilder().addDetails(Any.pack(help)).build();

    Metadata trailers = new Metadata();
    trailers.put(key, status.toByteArray());

    return Status.INVALID_ARGUMENT
        .withDescription("The transaction contains too many mutations.")
        .asRuntimeException(trailers);
  }

  static StatusRuntimeException createTransactionResourceLimitExceededException() {
    return Status.INVALID_ARGUMENT
        .withDescription("Transaction resource limits exceeded")
        .asRuntimeException();
  }

  @Test
  public void testTransactionMutationLimitExceeded_isNotRetriedByDefault() {
    mockSpanner.setExecuteSqlExecutionTime(
        SimulatedExecutionTime.ofException(exceptionType.createException()));

    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      assertEquals(AutocommitDmlMode.TRANSACTIONAL, connection.getAutocommitDmlMode());

      TransactionMutationLimitExceededException exception =
          assertThrows(
              TransactionMutationLimitExceededException.class,
              () -> connection.executeUpdate(Statement.of("update test set value=1 where true")));
      assertEquals(0, exception.getSuppressed().length);
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.getLastStatement());
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testTransactionMutationLimitExceeded_canBeRetriedAsPDML() {
    Statement statement = Statement.of("update test set value=1 where true");
    mockSpanner.setExecuteSqlExecutionTime(
        SimulatedExecutionTime.ofException(exceptionType.createException()));
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.update(statement, 100000L));

    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.setAutocommitDmlMode(
          AutocommitDmlMode.TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC);

      long updateCount = connection.executeUpdate(statement);
      assertEquals(100000L, updateCount);
    }
    // Verify that the request is retried as Partitioned DML.
    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    // The transactional request uses inline-begin.
    ExecuteSqlRequest transactionalRequest =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(transactionalRequest.getTransaction().getBegin().hasReadWrite());
    assertTrue(transactionalRequest.getLastStatement());

    // Partitioned DML uses an explicit BeginTransaction RPC.
    assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    BeginTransactionRequest beginRequest =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class).get(0);
    assertTrue(beginRequest.getOptions().hasPartitionedDml());
    ExecuteSqlRequest partitionedDmlRequest =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(1);
    assertTrue(partitionedDmlRequest.getTransaction().hasId());
    assertFalse(partitionedDmlRequest.getLastStatement());

    // Partitioned DML transactions are not committed.
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testTransactionMutationLimitExceeded_retryAsPDMLFails() {
    Statement statement = Statement.of("insert into test (id, value) select -id, value from test");
    // The transactional update statement uses ExecuteSql(..).
    mockSpanner.setExecuteSqlExecutionTime(
        SimulatedExecutionTime.ofException(exceptionType.createException()));
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.exception(
            statement,
            Status.INVALID_ARGUMENT
                .withDescription("This statement is not supported with Partitioned DML")
                .asRuntimeException()));

    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.setAutocommitDmlMode(
          AutocommitDmlMode.TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC);

      // The connection throws TransactionMutationLimitExceededException if the retry using
      // partitioned DML fails. The exception from the failed retry is returned as a suppressed
      // exception of the TransactionMutationLimitExceededException.
      TransactionMutationLimitExceededException exception =
          assertThrows(
              TransactionMutationLimitExceededException.class,
              () -> connection.executeUpdate(statement));
      assertEquals(1, exception.getSuppressed().length);
      assertEquals(SpannerException.class, exception.getSuppressed()[0].getClass());
      SpannerException spannerException = (SpannerException) exception.getSuppressed()[0];
      assertEquals(ErrorCode.INVALID_ARGUMENT, spannerException.getErrorCode());
      assertTrue(
          spannerException.getMessage(),
          spannerException
              .getMessage()
              .contains("This statement is not supported with Partitioned DML"));
    }
    // Verify that the request was retried as Partitioned DML.
    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    // The transactional request uses inline-begin.
    ExecuteSqlRequest transactionalRequest =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(transactionalRequest.getTransaction().getBegin().hasReadWrite());
    assertTrue(transactionalRequest.getLastStatement());

    // Partitioned DML uses an explicit BeginTransaction RPC.
    assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    BeginTransactionRequest beginRequest =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class).get(0);
    assertTrue(beginRequest.getOptions().hasPartitionedDml());
    ExecuteSqlRequest partitionedDmlRequest =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(1);
    assertTrue(partitionedDmlRequest.getTransaction().hasId());
    assertFalse(partitionedDmlRequest.getLastStatement());

    // Partitioned DML transactions are not committed.
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testSqlStatements() {
    for (Dialect dialect : Dialect.values()) {
      SpannerPool.closeSpannerPool();
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.detectDialectResult(dialect));
      String prefix = dialect == Dialect.POSTGRESQL ? "SPANNER." : "";

      try (Connection connection = createConnection()) {
        connection.setAutocommit(true);
        try (ResultSet resultSet =
            connection.executeQuery(
                Statement.of(String.format("show variable %sautocommit_dml_mode", prefix)))) {
          assertTrue(resultSet.next());
          assertEquals(
              AutocommitDmlMode.TRANSACTIONAL.name(),
              resultSet.getString(String.format("%sAUTOCOMMIT_DML_MODE", prefix)));
          assertFalse(resultSet.next());
        }
        connection.execute(
            Statement.of(
                String.format(
                    "set %sautocommit_dml_mode ="
                        + " 'transactional_with_fallback_to_partitioned_non_atomic'",
                    prefix)));
        try (ResultSet resultSet =
            connection.executeQuery(
                Statement.of(String.format("show variable %sautocommit_dml_mode", prefix)))) {
          assertTrue(resultSet.next());
          assertEquals(
              AutocommitDmlMode.TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC.name(),
              resultSet.getString(String.format("%sAUTOCOMMIT_DML_MODE", prefix)));
          assertFalse(resultSet.next());
        }
      }
    }
  }

  @Test
  public void testTransactionMutationLimitExceeded_isWrappedAsCauseOfBatchUpdateException() {
    String sql = "update test set value=1 where true";
    Statement statement = Statement.of(sql);
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.exception(
            statement, exceptionType.createException()));

    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      assertEquals(AutocommitDmlMode.TRANSACTIONAL, connection.getAutocommitDmlMode());

      connection.startBatchDml();
      connection.execute(statement);
      SpannerBatchUpdateException batchUpdateException =
          assertThrows(SpannerBatchUpdateException.class, connection::runBatch);
      assertNotNull(batchUpdateException.getCause());
      assertEquals(
          TransactionMutationLimitExceededException.class,
          batchUpdateException.getCause().getClass());
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
  }
}
