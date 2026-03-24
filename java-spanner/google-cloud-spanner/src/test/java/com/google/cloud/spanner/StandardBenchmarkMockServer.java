/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner;

import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.connection.RandomResultSetGenerator;
import com.google.common.collect.Collections2;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ListValue;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.inprocess.InProcessServerBuilder;

/** Standard mock server used for benchmarking. */
class StandardBenchmarkMockServer {
  private static final int NETWORK_LATENCY_TIME = 10;
  private static final int BATCH_CREATE_SESSIONS_MIN_TIME = 10;
  private static final int BATCH_CREATE_SESSIONS_RND_TIME = 10;
  private static final int BEGIN_TRANSACTION_MIN_TIME = 1;
  private static final int BEGIN_TRANSACTION_RND_TIME = 1;
  private static final int COMMIT_TRANSACTION_MIN_TIME = 5;
  private static final int COMMIT_TRANSACTION_RND_TIME = 5;
  private static final int ROLLBACK_TRANSACTION_MIN_TIME = 1;
  private static final int ROLLBACK_TRANSACTION_RND_TIME = 1;
  private static final int EXECUTE_STREAMING_SQL_MIN_TIME = 10;
  private static final int EXECUTE_STREAMING_SQL_RND_TIME = 10;
  private static final int EXECUTE_SQL_MIN_TIME = 10;
  private static final int EXECUTE_SQL_RND_TIME = 10;

  static final Statement UPDATE_STATEMENT = Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2");
  static final Statement INVALID_UPDATE_STATEMENT =
      Statement.of("UPDATE NON_EXISTENT_TABLE SET BAR=1 WHERE BAZ=2");
  static final long UPDATE_COUNT = 1L;
  static final Statement SELECT1 = Statement.of("SELECT 1 AS COL1");
  private static final ResultSetMetadata SELECT1_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("COL1")
                          .setType(
                              com.google.spanner.v1.Type.newBuilder()
                                  .setCode(TypeCode.INT64)
                                  .build())
                          .build())
                  .build())
          .build();
  private static final com.google.spanner.v1.ResultSet SELECT1_RESULTSET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("1").build())
                  .build())
          .setMetadata(SELECT1_METADATA)
          .build();
  static final Statement SELECT_RANDOM = Statement.of("SELECT * FROM RANDOM_TABLE");
  private static final com.google.spanner.v1.ResultSet SELECT_RANDOM_RESULTSET =
      new RandomResultSetGenerator(100).generate();
  private MockSpannerServiceImpl mockSpanner;
  private Server server;
  private LocalChannelProvider channelProvider;

  TransportChannelProvider start() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(StatementResult.update(UPDATE_STATEMENT, UPDATE_COUNT));
    mockSpanner.putStatementResult(StatementResult.query(SELECT1, SELECT1_RESULTSET));
    mockSpanner.putStatementResult(StatementResult.query(SELECT_RANDOM, SELECT_RANDOM_RESULTSET));
    mockSpanner.putStatementResult(
        StatementResult.exception(
            INVALID_UPDATE_STATEMENT,
            Status.INVALID_ARGUMENT.withDescription("invalid statement").asRuntimeException()));

    mockSpanner.setBatchCreateSessionsExecutionTime(
        SimulatedExecutionTime.ofMinimumAndRandomTime(
            NETWORK_LATENCY_TIME + BATCH_CREATE_SESSIONS_MIN_TIME, BATCH_CREATE_SESSIONS_RND_TIME));
    mockSpanner.setBeginTransactionExecutionTime(
        SimulatedExecutionTime.ofMinimumAndRandomTime(
            NETWORK_LATENCY_TIME + BEGIN_TRANSACTION_MIN_TIME, BEGIN_TRANSACTION_RND_TIME));
    mockSpanner.setCommitExecutionTime(
        SimulatedExecutionTime.ofMinimumAndRandomTime(
            NETWORK_LATENCY_TIME + COMMIT_TRANSACTION_MIN_TIME, COMMIT_TRANSACTION_RND_TIME));
    mockSpanner.setRollbackExecutionTime(
        SimulatedExecutionTime.ofMinimumAndRandomTime(
            NETWORK_LATENCY_TIME + ROLLBACK_TRANSACTION_MIN_TIME, ROLLBACK_TRANSACTION_RND_TIME));
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofMinimumAndRandomTime(
            NETWORK_LATENCY_TIME + EXECUTE_STREAMING_SQL_MIN_TIME, EXECUTE_STREAMING_SQL_RND_TIME));
    mockSpanner.setExecuteSqlExecutionTime(
        SimulatedExecutionTime.ofMinimumAndRandomTime(
            NETWORK_LATENCY_TIME + EXECUTE_SQL_MIN_TIME, EXECUTE_SQL_RND_TIME));

    String uniqueName = InProcessServerBuilder.generateName();
    server = InProcessServerBuilder.forName(uniqueName).addService(mockSpanner).build().start();
    channelProvider = LocalChannelProvider.create(uniqueName);

    return channelProvider;
  }

  void shutdown() throws InterruptedException {
    server.shutdown();
    server.awaitTermination();
  }

  MockSpannerServiceImpl getMockSpanner() {
    return mockSpanner;
  }

  int countRequests(final Class<? extends AbstractMessage> type) {
    return Collections2.filter(mockSpanner.getRequests(), input -> input.getClass().equals(type))
        .size();
  }
}
