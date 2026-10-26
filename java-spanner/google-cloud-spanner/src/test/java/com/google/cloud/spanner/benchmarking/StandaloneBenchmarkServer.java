/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.benchmarking;

import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Statement;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Standalone gRPC server hosting {@link MockSpannerServiceImpl} and {@link MonitoringServiceImpl}
 * in a separate JVM process to isolate server threads and GC activity from the JMH benchmark
 * client.
 */
public class StandaloneBenchmarkServer implements AutoCloseable {

  static final List<String> BENCHMARK_COLUMNS = Arrays.asList("id", "name");
  static final String BENCHMARK_SELECT_QUERY = "SELECT * FROM [TABLE] WHERE ID = 1";

  private final MockSpannerServiceImpl mockSpannerService;
  private final Server spannerServer;
  private final Server monitoringServer;
  private final ExecutorService executor;

  private StandaloneBenchmarkServer(
      MockSpannerServiceImpl mockSpannerService,
      Server spannerServer,
      Server monitoringServer,
      ExecutorService executor) {
    this.mockSpannerService = mockSpannerService;
    this.spannerServer = spannerServer;
    this.monitoringServer = monitoringServer;
    this.executor = executor;
  }

  public static StandaloneBenchmarkServer start(int spannerPort, int monitoringPort)
      throws IOException {
    MockSpannerServiceImpl mockSpannerService = new MockSpannerServiceImpl();
    mockSpannerService.setAbortProbability(0.0D);
    mockSpannerService.setRecordRequests(false);
    registerMocks(mockSpannerService);

    MonitoringServiceImpl mockMonitoringService = new MonitoringServiceImpl();

    int numThreads = Math.max(4, Runtime.getRuntime().availableProcessors());
    ExecutorService executor = Executors.newFixedThreadPool(numThreads);

    Server spannerServer = null;
    Server monitoringServer = null;
    try {
      spannerServer =
          ServerBuilder.forPort(spannerPort)
              .addService(mockSpannerService)
              .executor(executor)
              .build()
              .start();

      monitoringServer =
          ServerBuilder.forPort(monitoringPort).addService(mockMonitoringService).build().start();

      return new StandaloneBenchmarkServer(
          mockSpannerService, spannerServer, monitoringServer, executor);
    } catch (Throwable t) {
      if (spannerServer != null) {
        spannerServer.shutdown();
      }
      if (monitoringServer != null) {
        monitoringServer.shutdown();
      }
      executor.shutdown();
      throw t;
    }
  }

  public static void registerMocks(MockSpannerServiceImpl mockSpannerService) {
    ResultSetMetadata selectMetadata =
        ResultSetMetadata.newBuilder()
            .setRowType(
                StructType.newBuilder()
                    .addFields(
                        Field.newBuilder()
                            .setName("id")
                            .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                            .build())
                    .addFields(
                        Field.newBuilder()
                            .setName("name")
                            .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                            .build())
                    .build())
            .build();
    ResultSet selectResultSet =
        ResultSet.newBuilder()
            .addRows(
                ListValue.newBuilder()
                    .addValues(Value.newBuilder().setStringValue("1").build())
                    .addValues(Value.newBuilder().setStringValue("[NAME]").build())
                    .build())
            .setMetadata(selectMetadata)
            .build();
    mockSpannerService.putStatementResult(
        StatementResult.read(
            "[TABLE]", KeySet.singleKey(Key.of()), BENCHMARK_COLUMNS, selectResultSet));
    mockSpannerService.putStatementResult(
        StatementResult.query(Statement.of(BENCHMARK_SELECT_QUERY), selectResultSet));
  }

  public MockSpannerServiceImpl getMockSpannerService() {
    return mockSpannerService;
  }

  public int getSpannerPort() {
    return spannerServer.getPort();
  }

  public int getMonitoringPort() {
    return monitoringServer.getPort();
  }

  public void blockUntilShutdown() throws InterruptedException {
    spannerServer.awaitTermination();
  }

  @Override
  public void close() throws InterruptedException {
    spannerServer.shutdown();
    monitoringServer.shutdown();
    executor.shutdown();
    spannerServer.awaitTermination(10, TimeUnit.SECONDS);
    monitoringServer.awaitTermination(10, TimeUnit.SECONDS);
    executor.awaitTermination(10, TimeUnit.SECONDS);
  }

  private static int getRequiredEnvPort(String envKey) {
    String val = System.getenv(envKey);
    if (val == null || val.trim().isEmpty()) {
      throw new IllegalArgumentException("Missing required environment variable: " + envKey);
    }
    return Integer.parseInt(val.trim());
  }

  public static void main(String[] args) throws Exception {
    int spannerPort = getRequiredEnvPort("SPANNER_PORT");
    int monitoringPort = getRequiredEnvPort("MONITORING_PORT");
    final StandaloneBenchmarkServer server = start(spannerPort, monitoringPort);
    Runtime.getRuntime()
        .addShutdownHook(
            new Thread(
                () -> {
                  try {
                    server.close();
                  } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                  }
                }));
    server.blockUntilShutdown();
  }
}
