/*
 * Copyright 2025 Google LLC
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

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.ReadContext;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.protobuf.ListValue;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeCode;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Threads(10)
@Fork(1)
public class ReadBenchmark {

  @State(Scope.Benchmark)
  public static class BenchmarkState {

    // Spanner state
    Spanner spanner;
    DatabaseClient databaseClient;

    // gRPC server
    Server gRPCServer;
    Server gRPCMonitoringServer;

    // Executors for handling parallel requests by gRPC server
    ExecutorService gRPCServerExecutor;

    // Table
    List<String> columns = Arrays.asList("id", "name");
    String selectQuery = "SELECT * FROM [TABLE] WHERE ID = 1";

    @Setup(Level.Trial)
    public void setup() throws IOException {
      // Enable JMH system property
      System.setProperty("jmh.enabled", "true");

      // Initializing mock spanner service
      MockSpannerServiceImpl mockSpannerService = new MockSpannerServiceImpl();
      mockSpannerService.setAbortProbability(0.0D);

      // Initializing mock monitoring service
      MonitoringServiceImpl mockMonitoringService = new MonitoringServiceImpl();

      // Create a thread pool to handle concurrent requests
      gRPCServerExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

      // Creating Spanner Inprocess gRPC server
      gRPCServer =
          ServerBuilder.forPort(0)
              .addService(mockSpannerService)
              .executor(gRPCServerExecutor)
              .build()
              .start();

      registerMocks(mockSpannerService);

      // Creating Monitoring Inprocess gRPC server
      gRPCMonitoringServer =
          ServerBuilder.forPort(0).addService(mockMonitoringService).build().start();

      // Set the monitoring host port for exporter to forward requests to local netty gRPC server
      System.setProperty(
          "jmh.monitoring-server-port", String.valueOf(gRPCMonitoringServer.getPort()));

      spanner =
          SpannerOptions.newBuilder()
              .setProjectId("[PROJECT]")
              .setCredentials(NoCredentials.getInstance())
              .setChannelConfigurator(
                  managedChannelBuilder ->
                      ManagedChannelBuilder.forAddress("0.0.0.0", gRPCServer.getPort())
                          .usePlaintext())
              .build()
              .getService();
      databaseClient =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE_ID]", "[DATABASE_ID]"));
    }

    private void registerMocks(MockSpannerServiceImpl mockSpannerService) {
      ResultSetMetadata selectMetadata =
          ResultSetMetadata.newBuilder()
              .setRowType(
                  StructType.newBuilder()
                      .addFields(
                          Field.newBuilder()
                              .setName("id")
                              .setType(
                                  com.google.spanner.v1.Type.newBuilder()
                                      .setCode(TypeCode.INT64)
                                      .build())
                              .build())
                      .addFields(
                          Field.newBuilder()
                              .setName("name")
                              .setType(
                                  com.google.spanner.v1.Type.newBuilder()
                                      .setCode(TypeCode.STRING)
                                      .build())
                              .build())
                      .build())
              .build();
      com.google.spanner.v1.ResultSet selectResultSet =
          com.google.spanner.v1.ResultSet.newBuilder()
              .addRows(
                  ListValue.newBuilder()
                      .addValues(com.google.protobuf.Value.newBuilder().setStringValue("1").build())
                      .addValues(
                          com.google.protobuf.Value.newBuilder().setStringValue("[NAME]").build())
                      .build())
              .setMetadata(selectMetadata)
              .build();
      mockSpannerService.putStatementResult(
          StatementResult.read(
              "[TABLE]", KeySet.singleKey(Key.of()), this.columns, selectResultSet));
      mockSpannerService.putStatementResult(
          StatementResult.query(Statement.of(this.selectQuery), selectResultSet));
    }

    @TearDown(Level.Trial)
    public void tearDown() throws InterruptedException {
      spanner.close();
      gRPCServer.shutdown();
      gRPCServerExecutor.shutdown();

      // awaiting termination for servers and executors
      gRPCServer.awaitTermination(10, TimeUnit.SECONDS);
      gRPCServerExecutor.awaitTermination(10, TimeUnit.SECONDS);
    }
  }

  @Benchmark
  @Warmup(time = 5, timeUnit = TimeUnit.MINUTES, iterations = 1)
  @Measurement(time = 15, timeUnit = TimeUnit.MINUTES, iterations = 1)
  @Timeout(time = 30, timeUnit = TimeUnit.MINUTES)
  public void readBenchmark(BenchmarkState benchmarkState, Blackhole blackhole) {
    try (ReadContext readContext = benchmarkState.databaseClient.singleUse()) {
      try (ResultSet resultSet =
          readContext.read("[TABLE]", KeySet.singleKey(Key.of("2")), benchmarkState.columns)) {
        while (resultSet.next()) {
          blackhole.consume(resultSet.getLong("id"));
        }
      }
    }
  }

  @Benchmark
  @Warmup(time = 5, timeUnit = TimeUnit.MINUTES, iterations = 1)
  @Measurement(time = 15, timeUnit = TimeUnit.MINUTES, iterations = 1)
  @Timeout(time = 30, timeUnit = TimeUnit.MINUTES)
  public void queryBenchmark(BenchmarkState benchmarkState, Blackhole blackhole) {
    try (ReadContext readContext = benchmarkState.databaseClient.singleUse()) {
      try (ResultSet resultSet =
          readContext.executeQuery(Statement.of(benchmarkState.selectQuery))) {
        while (resultSet.next()) {
          blackhole.consume(resultSet.getLong("id"));
        }
      }
    }
  }

  public static void main(String[] args) throws RunnerException {
    Options opt =
        new OptionsBuilder()
            .include(ReadBenchmark.class.getSimpleName())
            .result("jmh-result.json")
            .resultFormat(ResultFormatType.JSON)
            .build();
    new Runner(opt).run();
  }
}
