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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.PartitionOptions;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.PartitionQueryRequest;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PartitionedQueryMockServerTest extends AbstractMockServerTest {

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Parameter public Dialect dialect;

  private Dialect currentDialect;

  @Before
  public void setupDialect() {
    if (currentDialect != dialect) {
      mockSpanner.putStatementResult(StatementResult.detectDialectResult(dialect));
      SpannerPool.closeSpannerPool();
      currentDialect = dialect;
    }
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  @Test
  public void testPartitionQuery() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      for (int i = 0; i < 2; i++) {
        try (ResultSet resultSet =
            connection.partitionQuery(
                Statement.newBuilder("select * from my_table where id=@id")
                    .bind("p1")
                    .to(1L)
                    .build(),
                PartitionOptions.newBuilder().build())) {
          assertTrue(resultSet.next());
          assertEquals(1, resultSet.getColumnCount());
          PartitionId partitionId = PartitionId.decodeFromString(resultSet.getString("PARTITION"));
          assertNotNull(partitionId);
          assertFalse(resultSet.next());
        }
      }
      if (isMultiplexedSessionsEnabledForPartitionedOps(connection.getSpanner())) {
        assertEquals(2, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      } else if (isMultiplexedSessionsEnabled(connection.getSpanner())) {
        assertEquals(3, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      } else {
        assertEquals(2, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      }
    }
    assertEquals(2, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    assertEquals(2, mockSpanner.countRequestsOfType(PartitionQueryRequest.class));
  }

  @Test
  public void testPartitionQueryInReadOnlyTransaction() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.setReadOnly(true);
      for (int i = 0; i < 2; i++) {
        try (ResultSet resultSet =
            connection.partitionQuery(
                Statement.newBuilder("select * from my_table where id=@id")
                    .bind("p1")
                    .to(1L)
                    .build(),
                PartitionOptions.newBuilder().build())) {
          assertTrue(resultSet.next());
          assertFalse(resultSet.next());
        }
      }
      if (isMultiplexedSessionsEnabled(connection.getSpanner())) {
        assertEquals(2, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      } else {
        assertEquals(1, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      }
    }
    assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    assertEquals(2, mockSpanner.countRequestsOfType(PartitionQueryRequest.class));
  }

  @Test
  public void testMixNormalAndPartitionQueryInReadOnlyTransaction() {
    List<Timestamp> readTimestamps = new ArrayList<>();
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.setReadOnly(true);
      for (int i = 0; i < 2; i++) {
        try (ResultSet resultSet = connection.executeQuery(SELECT_COUNT_STATEMENT)) {
          assertTrue(resultSet.next());
          assertEquals(0L, resultSet.getLong(0));
          assertFalse(resultSet.next());
        }
        try (ResultSet resultSet =
            connection.partitionQuery(
                Statement.newBuilder("select * from my_table where id=@id")
                    .bind("p1")
                    .to(1L)
                    .build(),
                PartitionOptions.newBuilder().build())) {
          assertTrue(resultSet.next());
          assertFalse(resultSet.next());
        }
        readTimestamps.add(connection.getReadTimestamp());
        connection.commit();
      }
      if (isMultiplexedSessionsEnabledForPartitionedOps(connection.getSpanner())) {
        assertEquals(2, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      } else if (isMultiplexedSessionsEnabled(connection.getSpanner())) {
        assertEquals(3, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      } else {
        assertEquals(2, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      }
    }
    // The above will start two transactions:
    // 1. The initial 'normal' read-only transaction.
    // 2. The batch read-only transaction. The latter will use the same read timestamp as the normal
    //    read-only transaction.
    assertEquals(4, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    assertEquals(2, mockSpanner.countRequestsOfType(PartitionQueryRequest.class));

    List<BeginTransactionRequest> beginRequests =
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class);
    assertTrue(beginRequests.get(0).getOptions().getReadOnly().hasStrong());
    assertTrue(beginRequests.get(1).getOptions().getReadOnly().hasReadTimestamp());
    assertTrue(beginRequests.get(2).getOptions().getReadOnly().hasStrong());
    assertTrue(beginRequests.get(3).getOptions().getReadOnly().hasReadTimestamp());

    assertEquals(
        readTimestamps.get(0),
        Timestamp.fromProto(beginRequests.get(1).getOptions().getReadOnly().getReadTimestamp()));
    assertEquals(
        readTimestamps.get(1),
        Timestamp.fromProto(beginRequests.get(3).getOptions().getReadOnly().getReadTimestamp()));
  }

  @Test
  public void testRunPartition() {
    int generatedRowCount = 20;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(generatedRowCount);
    Statement statement = Statement.of("select * from random_table");
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));

    int maxPartitions = 5;
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      boolean isMultiplexedSessionCreated = false;
      for (boolean dataBoostEnabled : new boolean[] {false, true}) {
        connection.setDataBoostEnabled(dataBoostEnabled);
        assertEquals(dataBoostEnabled, connection.isDataBoostEnabled());
        int rowCount = 0;
        try (ResultSet partitions =
            connection.partitionQuery(
                statement, PartitionOptions.newBuilder().setMaxPartitions(maxPartitions).build())) {

          int partitionCount = 0;
          while (partitions.next()) {
            try (ResultSet resultSet = connection.runPartition(partitions.getString("PARTITION"))) {
              while (resultSet.next()) {
                rowCount++;
              }
            }
            partitionCount++;
          }
          assertEquals(maxPartitions, partitionCount);
          // The mock server is not smart enough to actually only return a partition of a query, so
          // each partition just returns all rows of the query.
          assertEquals(generatedRowCount * maxPartitions, rowCount);
        }
        int createSessionRequestCounts =
            mockSpanner.countRequestsOfType(CreateSessionRequest.class);
        int expectedCreateSessionsRPC = 1;
        if (isMultiplexedSessionsEnabled(connection.getSpanner()) && !isMultiplexedSessionCreated) {
          // in one of the iterations there will be one additional RPC to create a multiplexed
          // session
          assertTrue(
              createSessionRequestCounts >= expectedCreateSessionsRPC
                  && createSessionRequestCounts <= expectedCreateSessionsRPC + 1);
          if (createSessionRequestCounts == expectedCreateSessionsRPC + 1) {
            isMultiplexedSessionCreated = true;
          }
        } else if (isMultiplexedSessionsEnabledForPartitionedOps(connection.getSpanner())
            && isMultiplexedSessionCreated) {
          // When multiplexed session will be reused for each iteration.
          assertEquals(0, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
        } else {
          assertEquals(
              expectedCreateSessionsRPC,
              mockSpanner.countRequestsOfType(CreateSessionRequest.class));
        }
        assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
        assertEquals(1, mockSpanner.countRequestsOfType(PartitionQueryRequest.class));
        assertEquals(maxPartitions, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
        assertFalse(
            mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
                .anyMatch(request -> request.getPartitionToken().isEmpty()));
        assertFalse(
            mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
                .anyMatch(request -> request.getDataBoostEnabled() != dataBoostEnabled));
        mockSpanner.clearRequests();
      }
    }
  }

  @Test
  public void testRunPartitionUsingSql() {
    int generatedRowCount = 20;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(generatedRowCount);
    String paramName = dialect == Dialect.POSTGRESQL ? "$1" : "@p1";
    Statement statement =
        Statement.newBuilder(String.format("select * from random_table where active=%s", paramName))
            .bind("p1")
            .to(true)
            .build();
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
    String prefix = dialect == Dialect.POSTGRESQL ? "spanner." : "";

    int maxPartitions = 5;
    boolean isMultiplexedSessionCreated = false;
    try (Connection connection = createConnection()) {
      connection.execute(Statement.of("set autocommit=true"));
      assertTrue(connection.isAutocommit());
      for (boolean dataBoostEnabled : new boolean[] {false, true}) {
        connection.execute(
            Statement.of(String.format("set %sdata_boost_enabled=%s", prefix, dataBoostEnabled)));
        try (ResultSet resultSet =
            connection.executeQuery(
                Statement.of(String.format("show variable %sdata_boost_enabled", prefix)))) {
          assertTrue(resultSet.next());
          assertEquals(dataBoostEnabled, resultSet.getBoolean(0));
          assertFalse(resultSet.next());
        }
        connection.execute(
            Statement.of(String.format("set %smax_partitions=%d", prefix, maxPartitions)));
        try (ResultSet resultSet =
            connection.executeQuery(
                Statement.of(String.format("show variable %smax_partitions", prefix)))) {
          assertTrue(resultSet.next());
          assertEquals(maxPartitions, resultSet.getLong(0));
          assertFalse(resultSet.next());
        }

        for (boolean useLiteral : new boolean[] {true, false}) {
          try (ResultSet partitions =
              connection.executeQuery(
                  Statement.newBuilder("partition " + statement.getSql())
                      .bind("p1")
                      .to(true)
                      .build())) {
            int rowCount = 0;
            int partitionCount = 0;
            while (partitions.next()) {
              try (ResultSet resultSet =
                  connection.executeQuery(
                      useLiteral
                          ? Statement.of(
                              "RUN\tPARTITION\n '" + partitions.getString("PARTITION") + "'")
                          : Statement.newBuilder("RUN PARTITION")
                              .bind("PARTITION")
                              .to(partitions.getString("PARTITION"))
                              .build())) {
                while (resultSet.next()) {
                  rowCount++;
                }
              }
              partitionCount++;
            }
            assertEquals(maxPartitions, partitionCount);
            // The mock server is not smart enough to actually only return a partition of a query,
            // so each partition just returns all rows of the query.
            assertEquals(generatedRowCount * maxPartitions, rowCount);
          }
          int createSessionRequestCounts =
              mockSpanner.countRequestsOfType(CreateSessionRequest.class);
          int expectedCreateSessionsRPC = 1;
          if (isMultiplexedSessionsEnabled(connection.getSpanner())
              && !isMultiplexedSessionCreated) {
            // in one of the iterations there will be one additional RPC to create a multiplexed
            // session
            assertTrue(
                createSessionRequestCounts >= expectedCreateSessionsRPC
                    && createSessionRequestCounts <= expectedCreateSessionsRPC + 1);
            if (createSessionRequestCounts == expectedCreateSessionsRPC + 1) {
              isMultiplexedSessionCreated = true;
            }
          } else if (isMultiplexedSessionsEnabledForPartitionedOps(connection.getSpanner())
              && isMultiplexedSessionCreated) {
            // When multiplexed session will be reused for each iteration.
            assertEquals(0, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
          } else {
            assertEquals(
                expectedCreateSessionsRPC,
                mockSpanner.countRequestsOfType(CreateSessionRequest.class));
          }
          assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
          assertEquals(1, mockSpanner.countRequestsOfType(PartitionQueryRequest.class));
          assertEquals(maxPartitions, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
          assertFalse(
              mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
                  .anyMatch(request -> request.getPartitionToken().isEmpty()));
          assertFalse(
              mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
                  .anyMatch(request -> request.getDataBoostEnabled() != dataBoostEnabled));
          mockSpanner.clearRequests();
        }
      }
    }
  }

  @Test
  public void testRunPartitionedQuery() {
    int generatedRowCount = 20;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(generatedRowCount);
    Statement statement =
        Statement.newBuilder("select * from random_table where active=@active")
            .bind("active")
            .to(true)
            .build();
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));

    int maxPartitions = 5;
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      try (PartitionedQueryResultSet resultSet =
          connection.runPartitionedQuery(
              statement, PartitionOptions.newBuilder().setMaxPartitions(maxPartitions).build())) {
        int rowCount = 0;
        while (resultSet.next()) {
          rowCount++;
        }
        // The mock server is not smart enough to actually return only a partition of the query.
        // Instead, the server returns the same query result for each partition, so the actual row
        // count will be maxPartitions * generatedRowCount.
        assertEquals(maxPartitions * generatedRowCount, rowCount);
      }
      if (isMultiplexedSessionsEnabled(connection.getSpanner())) {
        assertEquals(2, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      } else {
        assertEquals(1, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      }
    }
    assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(PartitionQueryRequest.class));
  }

  @Test
  public void testRunEmptyPartitionedQuery() {
    int generatedRowCount = 0;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(generatedRowCount);
    Statement statement =
        Statement.newBuilder("select * from random_table where active=@active")
            .bind("active")
            .to(true)
            .build();
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));

    int maxPartitions = 5;
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      try (PartitionedQueryResultSet resultSet =
          connection.runPartitionedQuery(
              statement, PartitionOptions.newBuilder().setMaxPartitions(maxPartitions).build())) {
        assertFalse(resultSet.next());
        assertNotNull(resultSet.getMetadata());
        assertEquals(26, resultSet.getMetadata().getRowType().getFieldsCount());
        assertNotNull(resultSet.getType());
        assertEquals(26, resultSet.getType().getStructFields().size());
      }
      if (isMultiplexedSessionsEnabled(connection.getSpanner())) {
        assertEquals(2, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      } else {
        assertEquals(1, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      }
    }
    assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(PartitionQueryRequest.class));
  }

  @Test
  public void testGetMetadataWithoutNextCall() {
    int generatedRowCount = 1;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(generatedRowCount);
    Statement statement =
        Statement.newBuilder("select * from random_table where active=@active")
            .bind("active")
            .to(true)
            .build();
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));

    int maxPartitions = 1;
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      try (PartitionedQueryResultSet resultSet =
          connection.runPartitionedQuery(
              statement, PartitionOptions.newBuilder().setMaxPartitions(maxPartitions).build())) {
        assertNotNull(resultSet.getMetadata());
        assertEquals(26, resultSet.getMetadata().getRowType().getFieldsCount());
        assertNotNull(resultSet.getType());
        assertEquals(26, resultSet.getType().getStructFields().size());

        assertTrue(resultSet.next());
        assertNotNull(resultSet.getMetadata());
        assertEquals(26, resultSet.getMetadata().getRowType().getFieldsCount());
        assertNotNull(resultSet.getType());
        assertEquals(26, resultSet.getType().getStructFields().size());

        assertFalse(resultSet.next());
      }
    }
    assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(PartitionQueryRequest.class));
  }

  @Test
  public void testGetMetadataWithoutNextCallOnEmptyResultSet() {
    int generatedRowCount = 0;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(generatedRowCount);
    Statement statement =
        Statement.newBuilder("select * from random_table where active=@active")
            .bind("active")
            .to(true)
            .build();
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));

    int maxPartitions = 1;
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      try (PartitionedQueryResultSet resultSet =
          connection.runPartitionedQuery(
              statement, PartitionOptions.newBuilder().setMaxPartitions(maxPartitions).build())) {
        assertNotNull(resultSet.getMetadata());
        assertEquals(26, resultSet.getMetadata().getRowType().getFieldsCount());
        assertNotNull(resultSet.getType());
        assertEquals(26, resultSet.getType().getStructFields().size());

        assertFalse(resultSet.next());
      }
    }
    assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(PartitionQueryRequest.class));
  }

  @Test
  public void testGetMetadataWithoutNextCallOnResultSetWithError() {
    Statement statement =
        Statement.newBuilder("select * from random_table where active=@active")
            .bind("active")
            .to(true)
            .build();
    mockSpanner.putStatementResult(
        StatementResult.exception(statement, Status.NOT_FOUND.asRuntimeException()));

    int maxPartitions = 1;
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      try (PartitionedQueryResultSet resultSet =
          connection.runPartitionedQuery(
              statement, PartitionOptions.newBuilder().setMaxPartitions(maxPartitions).build())) {
        assertThrows(SpannerException.class, resultSet::getMetadata);
        assertThrows(SpannerException.class, resultSet::getType);
      }
    }
    assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(PartitionQueryRequest.class));
  }

  @Test
  public void testRunPartitionedQueryUsingSql() {
    int generatedRowCount = 20;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(generatedRowCount);
    Statement statement =
        Statement.newBuilder("select * from random_table where active=@active")
            .bind("active")
            .to(true)
            .build();
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
    String prefix = dialect == Dialect.POSTGRESQL ? "spanner." : "";

    int maxPartitions = 5;
    int maxParallelism = 4;
    try (Connection connection = createConnection()) {
      connection.execute(Statement.of("set autocommit=true"));
      assertTrue(connection.isAutocommit());
      for (boolean dataBoostEnabled : new boolean[] {false, true}) {
        connection.execute(
            Statement.of(String.format("set %sdata_boost_enabled=%s", prefix, dataBoostEnabled)));
        try (ResultSet resultSet =
            connection.executeQuery(
                Statement.of(String.format("show variable %sdata_boost_enabled", prefix)))) {
          assertTrue(resultSet.next());
          assertEquals(dataBoostEnabled, resultSet.getBoolean(0));
          assertFalse(resultSet.next());
        }
        connection.execute(
            Statement.of(String.format("set %smax_partitions=%d", prefix, maxPartitions)));
        try (ResultSet resultSet =
            connection.executeQuery(
                Statement.of(String.format("show variable %smax_partitions", prefix)))) {
          assertTrue(resultSet.next());
          assertEquals(maxPartitions, resultSet.getLong(0));
          assertFalse(resultSet.next());
        }
        connection.execute(
            Statement.of(
                String.format("set %smax_partitioned_parallelism=%d", prefix, maxParallelism)));
        try (ResultSet resultSet =
            connection.executeQuery(
                Statement.of(
                    String.format("show variable %smax_partitioned_parallelism", prefix)))) {
          assertTrue(resultSet.next());
          assertEquals(maxParallelism, resultSet.getLong(0));
          assertFalse(resultSet.next());
        }

        try (ResultSet resultSet =
            connection.executeQuery(
                Statement.newBuilder(
                        "run\tpartitioned   query\n"
                            + " select * from random_table where active=@active")
                    .bind("active")
                    .to(true)
                    .build())) {
          int rowCount = 0;
          while (resultSet.next()) {
            rowCount++;
          }
          // The mock server is not smart enough to actually return only a partition of the query.
          // Instead, the server returns the same query result for each partition, so the actual row
          // count will be maxPartitions * generatedRowCount.
          assertEquals(maxPartitions * generatedRowCount, rowCount);
        }
      }
      if (isMultiplexedSessionsEnabledForPartitionedOps(connection.getSpanner())) {
        assertEquals(2, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      } else if (isMultiplexedSessionsEnabled(connection.getSpanner())) {
        assertEquals(3, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      } else {
        assertEquals(2, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      }
    }
    // We have 2 requests of each, as we run the query with data boost both enabled and disabled.
    assertEquals(2, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    assertEquals(2, mockSpanner.countRequestsOfType(PartitionQueryRequest.class));
  }

  @Test
  public void testRunPartitionedQueryWithError() {
    int generatedRowCount = 20;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(generatedRowCount);
    Statement statement =
        Statement.newBuilder("select * from random_table where active=@active")
            .bind("active")
            .to(true)
            .build();
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));

    int maxPartitions = 5;
    try (Connection connection = createConnection()) {
      // Make sure the query that determines the dialect has been executed before setting any query
      // errors. This ensures that the error is returned for the partitioned query, and not for the
      // query that determines the dialect.
      assertEquals(dialect, connection.getDialect());
      int errorIndex = new Random().nextInt(generatedRowCount);
      mockSpanner.setExecuteStreamingSqlExecutionTime(
          SimulatedExecutionTime.ofStreamException(
              Status.RESOURCE_EXHAUSTED.withDescription("test error").asRuntimeException(),
              errorIndex));
      connection.setAutocommit(true);

      int rowCount = 0;
      try (ResultSet resultSet =
          connection.runPartitionedQuery(
              statement, PartitionOptions.newBuilder().setMaxPartitions(maxPartitions).build())) {
        while (resultSet.next()) {
          rowCount++;
        }
        fail(
            "missing expected exception for error index "
                + errorIndex
                + ". Got row count "
                + rowCount);
      } catch (SpannerException exception) {
        assertEquals(ErrorCode.RESOURCE_EXHAUSTED, exception.getErrorCode());
        assertTrue(exception.getMessage().contains("test error"));
        // The mock server is not smart enough to actually return only a partition of the query.
        // Instead, the server returns the same query result for each partition, so the actual row
        // count will be (at most):
        // maxPartitions * generatedRowCount - (generatedRowCount - errorIndex).
        // The error that is added to the stream is removed the first time it is encountered, so
        // only one of the partition executors will see it.
        assertTrue(
            String.format(
                "rowCount (%d) should be <= maxPartitions (%d) * generatedRowCount (%d) -"
                    + " (generatedRowCount (%d) - errorIndex (%d))",
                rowCount, maxPartitions, generatedRowCount, generatedRowCount, errorIndex),
            rowCount <= (maxPartitions * generatedRowCount - (generatedRowCount - errorIndex)));
      }
      if (isMultiplexedSessionsEnabled(connection.getSpanner())) {
        assertEquals(2, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      } else {
        assertEquals(1, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      }
    }
    assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(PartitionQueryRequest.class));
  }

  @Test
  public void testRunPartitionedQueryWithMaxParallelism() {
    int generatedRowCount = 20;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(generatedRowCount);
    Statement statement =
        Statement.newBuilder("select * from random_table where active=@active")
            .bind("active")
            .to(true)
            .build();
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));

    int maxPartitions = 15;
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      for (int maxParallelism : new int[] {0, 1, 2, 5, 20}) {
        connection.setMaxPartitionedParallelism(maxParallelism);
        try (PartitionedQueryResultSet resultSet =
            connection.runPartitionedQuery(
                statement, PartitionOptions.newBuilder().setMaxPartitions(maxPartitions).build())) {
          int expectedParallelism;
          if (maxParallelism == 0) {
            expectedParallelism =
                Math.min(maxPartitions, Runtime.getRuntime().availableProcessors());
          } else {
            expectedParallelism = Math.min(maxParallelism, maxPartitions);
          }
          assertEquals(expectedParallelism, resultSet.getParallelism());
          int rowCount = 0;
          while (resultSet.next()) {
            rowCount++;
          }
          // The mock server is not smart enough to actually return only a partition of the query.
          // Instead, the server returns the same query result for each partition, so the actual row
          // count will be maxPartitions * generatedRowCount.
          assertEquals(maxPartitions * generatedRowCount, rowCount);
        }
      }
      if (isMultiplexedSessionsEnabledForPartitionedOps(connection.getSpanner())) {
        assertEquals(2, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      } else if (isMultiplexedSessionsEnabled(connection.getSpanner())) {
        assertEquals(6, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      } else {
        assertEquals(5, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      }
    }
    assertEquals(5, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    assertEquals(5, mockSpanner.countRequestsOfType(PartitionQueryRequest.class));
  }

  @Test
  public void testAutoPartitionMode() {
    int generatedRowCount = 5;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(generatedRowCount);
    Statement statement =
        Statement.newBuilder("select * from random_table where active=@active")
            .bind("active")
            .to(true)
            .build();
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
    String prefix = dialect == Dialect.POSTGRESQL ? "spanner." : "";

    int maxPartitions = 4;
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.setMaxPartitions(maxPartitions);

      connection.execute(Statement.of(String.format("set %sauto_partition_mode=true", prefix)));
      try (ResultSet resultSet =
          connection.executeQuery(
              Statement.of(String.format("show variable %sauto_partition_mode", prefix)))) {
        assertTrue(resultSet.next());
        assertTrue(resultSet.getBoolean(0));
        assertFalse(resultSet.next());
      }

      try (ResultSet resultSet = connection.executeQuery(statement)) {
        int rowCount = 0;
        while (resultSet.next()) {
          rowCount++;
        }
        assertEquals(maxPartitions * generatedRowCount, rowCount);
      }
      try (ResultSet resultSet = connection.execute(statement).getResultSet()) {
        int rowCount = 0;
        while (resultSet.next()) {
          rowCount++;
        }
        assertEquals(maxPartitions * generatedRowCount, rowCount);
      }
      SpannerException exception =
          assertThrows(SpannerException.class, () -> connection.executeQueryAsync(statement));
      assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
      assertTrue(
          exception.getMessage(),
          exception.getMessage().contains("Partitioned queries cannot be executed asynchronously"));
      exception = assertThrows(SpannerException.class, () -> connection.executeAsync(statement));
      assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
      assertTrue(
          exception.getMessage(),
          exception.getMessage().contains("Partitioned queries cannot be executed asynchronously"));

      // Turn off autocommit mode. This will cause the next query to start a read/write transaction.
      // These also do not support partitioned queries.
      connection.setAutocommit(false);
      exception = assertThrows(SpannerException.class, () -> connection.executeQuery(statement));
      assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
      assertTrue(
          exception.getMessage(),
          exception
              .getMessage()
              .contains("Partition query is not supported for read/write transaction"));
      exception = assertThrows(SpannerException.class, () -> connection.execute(statement));
      assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
      assertTrue(
          exception.getMessage(),
          exception
              .getMessage()
              .contains("Partition query is not supported for read/write transaction"));

      if (isMultiplexedSessionsEnabledForPartitionedOps(connection.getSpanner())) {
        assertEquals(2, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      } else if (isMultiplexedSessionsEnabled(connection.getSpanner())) {
        assertEquals(3, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      } else {
        assertEquals(2, mockSpanner.countRequestsOfType(CreateSessionRequest.class));
      }
    }
    assertEquals(2, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
    assertEquals(2, mockSpanner.countRequestsOfType(PartitionQueryRequest.class));
  }
}
