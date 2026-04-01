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

package com.google.cloud.spanner.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.TransactionMutationLimitExceededException;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.cloud.spanner.connection.AutocommitDmlMode;
import com.google.cloud.spanner.connection.SpannerPool;
import com.google.protobuf.Any;
import com.google.rpc.Help;
import com.google.rpc.Help.Link;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FallbackToPartitionedDMLMockServerTest extends AbstractMockServerTest {

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

  @Test
  public void testConnectionProperty() throws SQLException {
    for (AutocommitDmlMode mode : AutocommitDmlMode.values()) {
      Properties properties = new Properties();
      properties.put("autocommit_dml_mode", mode.name());
      try (Connection connection =
          DriverManager.getConnection("jdbc:" + getBaseUrl(), properties)) {
        assertEquals(
            mode, connection.unwrap(CloudSpannerJdbcConnection.class).getAutocommitDmlMode());
      }
    }
  }

  @Test
  public void testTransactionMutationLimitExceeded_isNotRetriedByDefault() throws SQLException {
    mockSpanner.setExecuteSqlExecutionTime(
        SimulatedExecutionTime.ofException(createTransactionMutationLimitExceededException()));

    try (Connection connection = createJdbcConnection()) {
      connection.setAutoCommit(true);
      assertEquals(
          AutocommitDmlMode.TRANSACTIONAL,
          connection.unwrap(CloudSpannerJdbcConnection.class).getAutocommitDmlMode());

      SQLException exception =
          assertThrows(
              SQLException.class,
              () ->
                  connection.createStatement().executeUpdate("update test set value=1 where true"));
      assertNotNull(exception.getCause());
      assertEquals(
          TransactionMutationLimitExceededException.class, exception.getCause().getClass());
      TransactionMutationLimitExceededException transactionMutationLimitExceededException =
          (TransactionMutationLimitExceededException) exception.getCause();
      assertEquals(0, transactionMutationLimitExceededException.getSuppressed().length);
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testTransactionMutationLimitExceeded_canBeRetriedAsPDML() throws SQLException {
    String sql = "update test set value=1 where true";
    com.google.cloud.spanner.Statement statement = com.google.cloud.spanner.Statement.of(sql);
    mockSpanner.setExecuteSqlExecutionTime(
        SimulatedExecutionTime.ofException(createTransactionMutationLimitExceededException()));
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.update(statement, 100000L));

    try (Connection connection = createJdbcConnection()) {
      connection.setAutoCommit(true);
      connection
          .unwrap(CloudSpannerJdbcConnection.class)
          .setAutocommitDmlMode(
              AutocommitDmlMode.TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC);

      long updateCount = connection.createStatement().executeUpdate(sql);
      assertEquals(100000L, updateCount);
    }
    // Verify that the request is retried as Partitioned DML.
    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    // The transactional request uses inline-begin.
    ExecuteSqlRequest transactionalRequest =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(transactionalRequest.getTransaction().getBegin().hasReadWrite());

    // Partitioned DML uses an explicit BeginTransaction RPC.
    assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    BeginTransactionRequest beginRequest =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class).get(0);
    assertTrue(beginRequest.getOptions().hasPartitionedDml());
    ExecuteSqlRequest partitionedDmlRequest =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(1);
    assertTrue(partitionedDmlRequest.getTransaction().hasId());

    // Partitioned DML transactions are not committed.
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testTransactionMutationLimitExceeded_retryAsPDMLFails() throws SQLException {
    String sql = "insert into test (id, value) select -id, value from test";
    com.google.cloud.spanner.Statement statement = com.google.cloud.spanner.Statement.of(sql);
    // The transactional update statement uses ExecuteSql(..).
    mockSpanner.setExecuteSqlExecutionTime(
        SimulatedExecutionTime.ofException(createTransactionMutationLimitExceededException()));
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.exception(
            statement,
            Status.INVALID_ARGUMENT
                .withDescription("This statement is not supported with Partitioned DML")
                .asRuntimeException()));

    try (Connection connection = createJdbcConnection()) {
      connection.setAutoCommit(true);
      connection
          .unwrap(CloudSpannerJdbcConnection.class)
          .setAutocommitDmlMode(
              AutocommitDmlMode.TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC);

      // The connection throws TransactionMutationLimitExceededException if the retry using
      // partitioned DML fails. The exception from the failed retry is returned as a suppressed
      // exception of the TransactionMutationLimitExceededException.
      SQLException exception =
          assertThrows(SQLException.class, () -> connection.createStatement().executeUpdate(sql));
      assertNotNull(exception.getCause());
      assertEquals(
          TransactionMutationLimitExceededException.class, exception.getCause().getClass());
      TransactionMutationLimitExceededException transactionMutationLimitExceededException =
          (TransactionMutationLimitExceededException) exception.getCause();
      assertEquals(1, transactionMutationLimitExceededException.getSuppressed().length);
      assertEquals(
          SpannerException.class,
          transactionMutationLimitExceededException.getSuppressed()[0].getClass());
      SpannerException spannerException =
          (SpannerException) transactionMutationLimitExceededException.getSuppressed()[0];
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

    // Partitioned DML uses an explicit BeginTransaction RPC.
    assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    BeginTransactionRequest beginRequest =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class).get(0);
    assertTrue(beginRequest.getOptions().hasPartitionedDml());
    ExecuteSqlRequest partitionedDmlRequest =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(1);
    assertTrue(partitionedDmlRequest.getTransaction().hasId());

    // Partitioned DML transactions are not committed.
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testSqlStatements() throws SQLException {
    for (Dialect dialect : Dialect.values()) {
      SpannerPool.closeSpannerPool();
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.detectDialectResult(dialect));
      String prefix = dialect == Dialect.POSTGRESQL ? "SPANNER." : "";

      try (Connection connection = createJdbcConnection()) {
        connection.setAutoCommit(true);
        try (ResultSet resultSet =
            connection
                .createStatement()
                .executeQuery(String.format("show variable %sautocommit_dml_mode", prefix))) {
          assertTrue(resultSet.next());
          assertEquals(
              AutocommitDmlMode.TRANSACTIONAL.name(),
              resultSet.getString(String.format("%sAUTOCOMMIT_DML_MODE", prefix)));
          assertFalse(resultSet.next());
        }
        connection
            .createStatement()
            .execute(
                String.format(
                    "set %sautocommit_dml_mode = 'transactional_with_fallback_to_partitioned_non_atomic'",
                    prefix));
        try (ResultSet resultSet =
            connection
                .createStatement()
                .executeQuery(String.format("show variable %sautocommit_dml_mode", prefix))) {
          assertTrue(resultSet.next());
          assertEquals(
              AutocommitDmlMode.TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC.name(),
              resultSet.getString(String.format("%sAUTOCOMMIT_DML_MODE", prefix)));
          assertFalse(resultSet.next());
        }
      }
    }
  }
}
