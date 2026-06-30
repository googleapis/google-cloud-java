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

import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;

/**
 * Benchmarks for inlining the BeginTransaction RPC with the first statement of a transaction. The
 * simulated execution times are based on reasonable estimates and are primarily intended to keep
 * the benchmarks comparable with each other before and after changes have been made to the pool.
 * The benchmarks are bound to the Maven profile `benchmark` and can be executed like this: <code>
 * mvn clean test -DskipTests -Pbenchmark -Dbenchmark.name=InlineBeginBenchmark
 * </code>
 */
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1, warmups = 0)
@Measurement(batchSize = 1, iterations = 1, timeUnit = TimeUnit.MILLISECONDS)
@Warmup(batchSize = 0, iterations = 0)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class InlineBeginBenchmark {
  private static final String TEST_PROJECT = "my-project";
  private static final String TEST_INSTANCE = "my-instance";
  private static final String TEST_DATABASE = "my-database";
  private static final int HOLD_SESSION_TIME = 100;
  private static final int RND_WAIT_TIME_BETWEEN_REQUESTS = 10;
  private static final Random RND = new Random();

  @State(Scope.Thread)
  public static class BenchmarkState {
    private final boolean useRealServer = Boolean.parseBoolean(System.getProperty("useRealServer"));
    private final String instance = System.getProperty("instance", TEST_INSTANCE);
    private final String database = System.getProperty("database", TEST_DATABASE);
    private StandardBenchmarkMockServer mockServer;
    private Spanner spanner;
    private DatabaseClientImpl client;

    @Param({"true"})
    boolean inlineBegin;

    @Param({"0.2"})
    float writeFraction;

    @Setup(Level.Invocation)
    public void setup() throws Exception {
      System.out.println("useRealServer: " + System.getProperty("useRealServer"));
      System.out.println("instance: " + System.getProperty("instance"));
      SpannerOptions options;
      if (useRealServer) {
        System.out.println("running benchmark with **REAL** server");
        System.out.println("instance: " + instance);
        System.out.println("database: " + database);
        options = createRealServerOptions();
      } else {
        System.out.println("running benchmark with **MOCK** server");
        mockServer = new StandardBenchmarkMockServer();
        TransportChannelProvider channelProvider = mockServer.start();
        options = createBenchmarkServerOptions(channelProvider);
      }

      spanner = options.getService();
      client =
          (DatabaseClientImpl)
              spanner.getDatabaseClient(DatabaseId.of(options.getProjectId(), instance, database));
      Stopwatch watch = Stopwatch.createStarted();
      // Wait until the session pool has initialized.
      while (client.multiplexedSessionDatabaseClient.getCurrentSessionReference() == null) {
        Thread.sleep(1L);
        if (watch.elapsed(TimeUnit.SECONDS) > 10L) {
          break;
        }
      }
    }

    SpannerOptions createBenchmarkServerOptions(TransportChannelProvider channelProvider) {
      return SpannerOptions.newBuilder()
          .setProjectId(TEST_PROJECT)
          .setChannelProvider(channelProvider)
          .setCredentials(NoCredentials.getInstance())
          .setSessionPoolOption(
              SessionPoolOptions.newBuilder().setWriteSessionsFraction(writeFraction).build())
          .build();
    }

    SpannerOptions createRealServerOptions() {
      return SpannerOptions.newBuilder()
          .setSessionPoolOption(
              SessionPoolOptions.newBuilder().setWriteSessionsFraction(writeFraction).build())
          .build();
    }

    @TearDown(Level.Invocation)
    public void teardown() throws Exception {
      spanner.close();
      if (mockServer != null) {
        mockServer.shutdown();
      }
    }
  }

  /** Measures the time needed to execute a burst of read requests. */
  @Benchmark
  public void burstRead(final BenchmarkState server) throws Exception {
    int totalQueries = server.spanner.getOptions().getSessionPoolOptions().getMaxSessions() * 8;
    int parallelThreads = server.spanner.getOptions().getSessionPoolOptions().getMaxSessions() * 2;

    ListeningScheduledExecutorService service =
        MoreExecutors.listeningDecorator(Executors.newScheduledThreadPool(parallelThreads));
    List<ListenableFuture<?>> futures = new ArrayList<>(totalQueries);
    for (int i = 0; i < totalQueries; i++) {
      futures.add(
          service.submit(
              () -> {
                Thread.sleep(RND.nextInt(RND_WAIT_TIME_BETWEEN_REQUESTS));
                try (ResultSet rs =
                    server.client.singleUse().executeQuery(StandardBenchmarkMockServer.SELECT1)) {
                  while (rs.next()) {
                    Thread.sleep(RND.nextInt(HOLD_SESSION_TIME));
                  }
                  return null;
                }
              }));
    }
    Futures.allAsList(futures).get();
    service.shutdown();
  }

  /** Measures the time needed to execute a burst of write requests. */
  @Benchmark
  public void burstWrite(final BenchmarkState server) throws Exception {
    int totalWrites = server.spanner.getOptions().getSessionPoolOptions().getMaxSessions() * 8;
    int parallelThreads = server.spanner.getOptions().getSessionPoolOptions().getMaxSessions() * 2;

    ListeningScheduledExecutorService service =
        MoreExecutors.listeningDecorator(Executors.newScheduledThreadPool(parallelThreads));
    List<ListenableFuture<?>> futures = new ArrayList<>(totalWrites);
    for (int i = 0; i < totalWrites; i++) {
      futures.add(
          service.submit(
              () -> {
                Thread.sleep(RND.nextInt(RND_WAIT_TIME_BETWEEN_REQUESTS));
                TransactionRunner runner = server.client.readWriteTransaction();
                return runner.run(
                    transaction ->
                        transaction.executeUpdate(StandardBenchmarkMockServer.UPDATE_STATEMENT));
              }));
    }
    Futures.allAsList(futures).get();
    service.shutdown();
  }

  /** Measures the time needed to execute a burst of read and write requests. */
  @Benchmark
  public void burstReadAndWrite(final BenchmarkState server) throws Exception {
    int totalWrites = server.spanner.getOptions().getSessionPoolOptions().getMaxSessions() * 4;
    int totalReads = server.spanner.getOptions().getSessionPoolOptions().getMaxSessions() * 4;
    int parallelThreads = server.spanner.getOptions().getSessionPoolOptions().getMaxSessions() * 2;

    ListeningScheduledExecutorService service =
        MoreExecutors.listeningDecorator(Executors.newScheduledThreadPool(parallelThreads));
    List<ListenableFuture<?>> futures = new ArrayList<>(totalReads + totalWrites);
    for (int i = 0; i < totalWrites; i++) {
      futures.add(
          service.submit(
              () -> {
                Thread.sleep(RND.nextInt(RND_WAIT_TIME_BETWEEN_REQUESTS));
                TransactionRunner runner = server.client.readWriteTransaction();
                return runner.run(
                    transaction ->
                        transaction.executeUpdate(StandardBenchmarkMockServer.UPDATE_STATEMENT));
              }));
    }
    for (int i = 0; i < totalReads; i++) {
      futures.add(
          service.submit(
              () -> {
                Thread.sleep(RND.nextInt(RND_WAIT_TIME_BETWEEN_REQUESTS));
                try (ResultSet rs =
                    server.client.singleUse().executeQuery(StandardBenchmarkMockServer.SELECT1)) {
                  while (rs.next()) {
                    Thread.sleep(RND.nextInt(HOLD_SESSION_TIME));
                  }
                  return null;
                }
              }));
    }
    Futures.allAsList(futures).get();
    service.shutdown();
  }
}
