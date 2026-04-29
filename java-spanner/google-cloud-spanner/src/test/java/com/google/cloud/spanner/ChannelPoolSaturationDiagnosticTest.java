/*
 * Copyright 2026 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.NoCredentials;
import com.google.cloud.grpc.GcpManagedChannel;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.spi.v1.SpannerInterceptorProvider;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingServerCall;
import io.grpc.Grpc;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Manual diagnostic for comparing grpc-gcp and GAX channel pool behavior under stream pressure. */
@RunWith(JUnit4.class)
public class ChannelPoolSaturationDiagnosticTest {
  private static final int NUM_CHANNELS =
      Integer.getInteger("spanner.channelPoolLoad.numChannels", 8);
  private static final int CONCURRENT_QUERIES =
      Integer.getInteger("spanner.channelPoolLoad.queries", 400);
  private static final int MAX_CONCURRENT_STREAMS_PER_CONNECTION =
      Integer.getInteger("spanner.channelPoolLoad.maxStreamsPerConnection", 100);
  private static final int QUERY_LATENCY_MS =
      Integer.getInteger("spanner.channelPoolLoad.queryLatencyMillis", 250);
  private static final int WARMUP_QUERIES =
      Integer.getInteger("spanner.channelPoolLoad.warmupQueries", CONCURRENT_QUERIES);
  private static final String OPERATION =
      System.getProperty("spanner.channelPoolLoad.operation", "readOnlyTransaction");
  private static final boolean DISABLE_GRPC_GCP_AFFINITY =
      Boolean.getBoolean("spanner.channelPoolLoad.disableGrpcGcpAffinity");
  private static final boolean GAX_FIRST = Boolean.getBoolean("spanner.channelPoolLoad.gaxFirst");
  private static final String WORKLOAD_SHAPE =
      System.getProperty("spanner.channelPoolLoad.workloadShape", "burst");
  private static final int SPIKE_QUERIES =
      Integer.getInteger("spanner.channelPoolLoad.spikeQueries", CONCURRENT_QUERIES);
  private static final int STABLE_CONCURRENCY =
      Integer.getInteger(
          "spanner.channelPoolLoad.stableConcurrency", Math.max(1, CONCURRENT_QUERIES / 4));
  private static final int STABLE_ROUNDS =
      Integer.getInteger("spanner.channelPoolLoad.stableRounds", 5);
  private static final int MEASUREMENT_PAIRS =
      Integer.getInteger("spanner.channelPoolLoad.measurementPairs", 1);
  private static final boolean DISCARD_FIRST_PAIR =
      Boolean.parseBoolean(
          System.getProperty(
              "spanner.channelPoolLoad.discardFirstMeasurementPair",
              Boolean.toString(MEASUREMENT_PAIRS > 1)));
  private static final String EXTERNAL_SPANNER_VERSIONS =
      System.getProperty("spanner.channelPoolLoad.externalSpannerVersions", "");
  private static final boolean RUN_IN_PROCESS =
      Boolean.parseBoolean(System.getProperty("spanner.channelPoolLoad.runInProcess", "true"));

  private static final Statement SELECT1 = Statement.of("SELECT 1");
  private static final com.google.spanner.v1.ResultSet SELECT1_RESULT_SET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .setMetadata(
              ResultSetMetadata.newBuilder()
                  .setRowType(
                      StructType.newBuilder()
                          .addFields(
                              Field.newBuilder()
                                  .setName("c")
                                  .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                  .build())
                          .build()))
          .addRows(ListValue.newBuilder().addValues(Value.newBuilder().setStringValue("1")))
          .build();

  @Test
  public void compareGrpcGcpAndGaxWithFixedStreamLimit() throws Exception {
    assumeTrue(
        "Set -Dspanner.channelPoolLoad=true to run this manual diagnostic",
        Boolean.getBoolean("spanner.channelPoolLoad"));
    assumeTrue(System.getenv("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS") == null);
    assumeTrue(System.getenv("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS_FOR_RW") == null);

    if (RUN_IN_PROCESS) {
      List<LoadResult> grpcGcpResults = new ArrayList<>();
      List<LoadResult> gaxResults = new ArrayList<>();
      for (int pair = 0; pair < MEASUREMENT_PAIRS; pair++) {
        boolean pairGaxFirst = pair % 2 == 0 ? GAX_FIRST : !GAX_FIRST;
        LoadPair loadPair = runLoadPair(pairGaxFirst);
        System.out.printf(
            "%nPairResult{pair=%d, included=%s, gaxFirst=%s}%n%s%n%s%n",
            pair, !DISCARD_FIRST_PAIR || pair > 0, pairGaxFirst, loadPair.grpcGcp, loadPair.gax);
        if (!DISCARD_FIRST_PAIR || pair > 0) {
          grpcGcpResults.add(loadPair.grpcGcp);
          gaxResults.add(loadPair.gax);
        }
      }
      System.out.printf(
          "%n%s%n%s%n",
          AggregateResult.of("grpc-gcp", grpcGcpResults), AggregateResult.of("gax", gaxResults));
      printGrpcGcpDiagnostics();
      for (LoadResult grpcGcp : grpcGcpResults) {
        assertEquals(expectedMeasuredCalls(), grpcGcp.totalExecuteStreamingSqlCalls());
      }
      for (LoadResult gax : gaxResults) {
        assertEquals(expectedMeasuredCalls(), gax.totalExecuteStreamingSqlCalls());
      }
    }

    for (String externalSpannerVersion : externalSpannerVersions()) {
      runExternalVersion(externalSpannerVersion);
    }
  }

  private LoadPair runLoadPair(boolean gaxFirst) throws Exception {
    LoadResult first = gaxFirst ? runLoad("gax", false) : runLoad("grpc-gcp", true);
    LoadResult second = gaxFirst ? runLoad("grpc-gcp", true) : runLoad("gax", false);
    return gaxFirst ? new LoadPair(second, first) : new LoadPair(first, second);
  }

  private static List<String> externalSpannerVersions() {
    List<String> versions = new ArrayList<>();
    for (String version : EXTERNAL_SPANNER_VERSIONS.split(",")) {
      String trimmed = version.trim();
      if (!trimmed.isEmpty()) {
        versions.add(trimmed);
      }
    }
    return versions;
  }

  private static void runExternalVersion(String spannerVersion) throws Exception {
    Path moduleDir = Paths.get(System.getProperty("user.dir"));
    Path source =
        moduleDir.resolve(
            "src/test/java/com/google/cloud/spanner/ChannelPoolExternalVersionRunner.java");
    Path runnerDir =
        moduleDir.resolve("target").resolve("channel-pool-external-runner").resolve(spannerVersion);
    Path runnerSource =
        runnerDir.resolve(
            "src/main/java/com/google/cloud/spanner/ChannelPoolExternalVersionRunner.java");
    Files.createDirectories(runnerSource.getParent());
    Files.copy(source, runnerSource, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
    Files.write(runnerDir.resolve("pom.xml"), externalRunnerPom(spannerVersion).getBytes("UTF-8"));

    List<String> command = new ArrayList<>();
    command.add("mvn");
    command.add("-q");
    command.add("-f");
    command.add(runnerDir.resolve("pom.xml").toString());
    copyProperty(command, "spanner.channelPoolLoad.numChannels");
    copyProperty(command, "spanner.channelPoolLoad.queries");
    copyProperty(command, "spanner.channelPoolLoad.maxStreamsPerConnection");
    copyProperty(command, "spanner.channelPoolLoad.queryLatencyMillis");
    copyProperty(command, "spanner.channelPoolLoad.warmupQueries");
    copyProperty(command, "spanner.channelPoolLoad.operation");
    copyProperty(command, "spanner.channelPoolLoad.disableGrpcGcpAffinity");
    copyProperty(command, "spanner.channelPoolLoad.gaxFirst");
    copyProperty(command, "spanner.channelPoolLoad.workloadShape");
    copyProperty(command, "spanner.channelPoolLoad.spikeQueries");
    copyProperty(command, "spanner.channelPoolLoad.stableConcurrency");
    copyProperty(command, "spanner.channelPoolLoad.stableRounds");
    copyProperty(command, "spanner.channelPoolLoad.measurementPairs");
    copyProperty(command, "spanner.channelPoolLoad.discardFirstMeasurementPair");
    command.add("compile");
    command.add("exec:java");
    command.add("-Dexec.mainClass=com.google.cloud.spanner.ChannelPoolExternalVersionRunner");

    System.out.printf(
        "%nExternalVersionRun{spannerVersion=%s, runnerDir=%s}%n", spannerVersion, runnerDir);
    Process process = new ProcessBuilder(command).redirectErrorStream(true).start();
    try (BufferedReader reader =
        new BufferedReader(
            new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    }
    int exitCode = process.waitFor();
    if (exitCode != 0) {
      throw new AssertionError(
          "External java-spanner " + spannerVersion + " run failed with exit code " + exitCode);
    }
  }

  private static void copyProperty(List<String> command, String name) {
    String value = System.getProperty(name);
    if (value != null) {
      command.add("-D" + name + "=" + value);
    }
  }

  private static String externalRunnerPom(String spannerVersion) {
    return "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" "
        + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
        + "xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 "
        + "https://maven.apache.org/xsd/maven-4.0.0.xsd\">\n"
        + "  <modelVersion>4.0.0</modelVersion>\n"
        + "  <groupId>com.google.cloud.spanner</groupId>\n"
        + "  <artifactId>channel-pool-external-runner</artifactId>\n"
        + "  <version>1.0-SNAPSHOT</version>\n"
        + "  <properties>\n"
        + "    <maven.compiler.source>8</maven.compiler.source>\n"
        + "    <maven.compiler.target>8</maven.compiler.target>\n"
        + "  </properties>\n"
        + "  <dependencies>\n"
        + "    <dependency>\n"
        + "      <groupId>com.google.cloud</groupId>\n"
        + "      <artifactId>google-cloud-spanner</artifactId>\n"
        + "      <version>"
        + spannerVersion
        + "</version>\n"
        + "    </dependency>\n"
        + "  </dependencies>\n"
        + "  <build>\n"
        + "    <plugins>\n"
        + "      <plugin>\n"
        + "        <groupId>org.codehaus.mojo</groupId>\n"
        + "        <artifactId>exec-maven-plugin</artifactId>\n"
        + "        <version>3.5.0</version>\n"
        + "      </plugin>\n"
        + "    </plugins>\n"
        + "  </build>\n"
        + "</project>\n";
  }

  private static int expectedMeasuredCalls() {
    if ("spikeThenStable".equals(WORKLOAD_SHAPE)) {
      return SPIKE_QUERIES + STABLE_CONCURRENCY * STABLE_ROUNDS;
    }
    return CONCURRENT_QUERIES;
  }

  private LoadResult runLoad(String name, boolean grpcGcp) throws Exception {
    MockSpannerServiceImpl mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D);
    mockSpanner.putStatementResult(StatementResult.query(SELECT1, SELECT1_RESULT_SET));
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofMinimumAndRandomTime(QUERY_LATENCY_MS, 0));

    ChannelStats stats = new ChannelStats();
    ClientTimingStats clientTimingStats = new ClientTimingStats();
    OperationTimingStats operationTimingStats = new OperationTimingStats();
    Server server =
        NettyServerBuilder.forAddress(new InetSocketAddress("localhost", 0))
            .maxConcurrentCallsPerConnection(MAX_CONCURRENT_STREAMS_PER_CONNECTION)
            .addService(mockSpanner)
            .intercept(stats)
            .build()
            .start();
    try {
      SpannerOptions.Builder builder =
          SpannerOptions.newBuilder()
              .setProjectId("test-project")
              .setHost("http://localhost:" + server.getPort())
              .setCredentials(NoCredentials.getInstance())
              .setChannelConfigurator(input -> input.usePlaintext())
              .setNumChannels(NUM_CHANNELS);
      SpannerInterceptorProvider interceptorProvider =
          SpannerInterceptorProvider.createDefault()
              .with(new ClientTimingInterceptor(clientTimingStats));
      if (!grpcGcp) {
        builder.disableGrpcGcpExtension();
      } else if (DISABLE_GRPC_GCP_AFFINITY) {
        interceptorProvider = interceptorProvider.with(new DisableGrpcGcpAffinity());
      }
      builder.setInterceptorProvider(interceptorProvider);

      long elapsedMillis;
      try (Spanner spanner = builder.build().getService()) {
        DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
        Snapshot setupSnapshot = stats.snapshot();
        if (WARMUP_QUERIES > 0) {
          stats.reset(WARMUP_QUERIES);
          clientTimingStats.reset(WARMUP_QUERIES);
          operationTimingStats.reset(WARMUP_QUERIES);
          runConcurrentQueries(
              client, stats, clientTimingStats, operationTimingStats, WARMUP_QUERIES);
        }
        if ("spikeThenStable".equals(WORKLOAD_SHAPE)) {
          PhaseResult spike =
              runMeasuredPhase(
                  "spike",
                  client,
                  stats,
                  clientTimingStats,
                  operationTimingStats,
                  SPIKE_QUERIES,
                  1);
          PhaseResult stable =
              runMeasuredPhase(
                  "stable",
                  client,
                  stats,
                  clientTimingStats,
                  operationTimingStats,
                  STABLE_CONCURRENCY,
                  STABLE_ROUNDS);
          elapsedMillis = spike.elapsedMillis + stable.elapsedMillis;
          return LoadResult.forPhases(name, elapsedMillis, setupSnapshot, spike, stable);
        } else {
          PhaseResult burst =
              runMeasuredPhase(
                  "burst",
                  client,
                  stats,
                  clientTimingStats,
                  operationTimingStats,
                  CONCURRENT_QUERIES,
                  1);
          elapsedMillis = burst.elapsedMillis;
          return LoadResult.forBurst(name, elapsedMillis, setupSnapshot, burst);
        }
      }
    } finally {
      server.shutdownNow();
      server.awaitTermination();
    }
  }

  private LatencySummary runConcurrentQueries(
      DatabaseClient client,
      ChannelStats stats,
      ClientTimingStats clientTimingStats,
      OperationTimingStats operationTimingStats,
      int queries)
      throws Exception {
    LatencyRecorder recorder = new LatencyRecorder(queries);
    long elapsedMillis =
        runConcurrentQueriesInto(
            client, stats, clientTimingStats, operationTimingStats, queries, recorder);
    return recorder.summary(elapsedMillis);
  }

  private PhaseResult runMeasuredPhase(
      String name,
      DatabaseClient client,
      ChannelStats stats,
      ClientTimingStats clientTimingStats,
      OperationTimingStats operationTimingStats,
      int concurrency,
      int rounds)
      throws Exception {
    int expectedQueries = concurrency * rounds;
    stats.reset(expectedQueries);
    clientTimingStats.reset(expectedQueries);
    operationTimingStats.reset(expectedQueries);
    LatencyRecorder recorder = new LatencyRecorder(expectedQueries);
    long elapsedMillis = 0L;
    for (int round = 0; round < rounds; round++) {
      elapsedMillis +=
          runConcurrentQueriesInto(
              client, stats, clientTimingStats, operationTimingStats, concurrency, recorder);
    }
    return new PhaseResult(
        name,
        elapsedMillis,
        recorder.summary(elapsedMillis),
        stats.snapshot(),
        clientTimingStats.snapshot(),
        operationTimingStats.snapshot());
  }

  private long runConcurrentQueriesInto(
      DatabaseClient client,
      ChannelStats stats,
      ClientTimingStats clientTimingStats,
      OperationTimingStats operationTimingStats,
      int queries,
      LatencyRecorder recorder)
      throws Exception {
    ExecutorService executor = Executors.newFixedThreadPool(queries);
    CountDownLatch ready = new CountDownLatch(queries);
    CountDownLatch start = new CountDownLatch(1);
    List<Future<?>> futures = new ArrayList<>(queries);
    long startNanos = System.nanoTime();
    try {
      for (int i = 0; i < queries; i++) {
        futures.add(
            executor.submit(
                () -> {
                  ready.countDown();
                  start.await();
                  long queryStartNanos = System.nanoTime();
                  runQuery(client, operationTimingStats);
                  recorder.record(System.nanoTime() - queryStartNanos);
                  return null;
                }));
      }
      ready.await(30, TimeUnit.SECONDS);
      startNanos = System.nanoTime();
      stats.startTiming(startNanos);
      clientTimingStats.startTiming(startNanos);
      operationTimingStats.startTiming(startNanos);
      start.countDown();
      for (Future<?> future : futures) {
        future.get(60, TimeUnit.SECONDS);
      }
    } finally {
      executor.shutdownNow();
      executor.awaitTermination(30, TimeUnit.SECONDS);
    }
    return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
  }

  private static void runQuery(DatabaseClient client, OperationTimingStats stats) {
    switch (OPERATION) {
      case "singleUse":
        ReadContext singleUse = client.singleUse();
        stats.recordContextCreated();
        try (ResultSet resultSet = singleUse.executeQuery(SELECT1)) {
          stats.recordExecuteReturned();
          drain(resultSet, stats);
        }
        return;
      case "singleUseReadOnlyTransaction":
        try (ReadOnlyTransaction transaction = client.singleUseReadOnlyTransaction()) {
          stats.recordContextCreated();
          try (ResultSet resultSet = transaction.executeQuery(SELECT1)) {
            stats.recordExecuteReturned();
            drain(resultSet, stats);
          }
        }
        return;
      case "readOnlyTransaction":
        try (ReadOnlyTransaction transaction = client.readOnlyTransaction()) {
          stats.recordContextCreated();
          try (ResultSet resultSet = transaction.executeQuery(SELECT1)) {
            stats.recordExecuteReturned();
            drain(resultSet, stats);
          }
        }
        return;
      default:
        throw new IllegalArgumentException("Unknown operation: " + OPERATION);
    }
  }

  private static void drain(ResultSet resultSet, OperationTimingStats stats) {
    boolean first = true;
    while (resultSet.next()) {
      if (first) {
        stats.recordFirstRow();
        first = false;
      }
    }
  }

  private static int saturatedMillis(long nanos) {
    long millis = TimeUnit.NANOSECONDS.toMillis(nanos);
    return millis > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) millis;
  }

  private static List<Map.Entry<String, Integer>> ordered(Map<String, Integer> values) {
    List<Map.Entry<String, Integer>> entries = new ArrayList<>(values.entrySet());
    entries.sort(Comparator.comparing(Map.Entry::getKey));
    return entries;
  }

  private static void printGrpcGcpDiagnostics() {
    try {
      Class<?> diagnostics = Class.forName("com.google.cloud.grpc.GcpDiagnostics");
      java.lang.reflect.Method printNow = diagnostics.getDeclaredMethod("printNow");
      printNow.setAccessible(true);
      printNow.invoke(null);
    } catch (ReflectiveOperationException ignored) {
      // This is a manual diagnostic hook. Keep the load test usable with stock grpc-gcp artifacts.
    }
  }

  private static final class DisableGrpcGcpAffinity implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
      return next.newCall(
          method, callOptions.withOption(GcpManagedChannel.DISABLE_AFFINITY_KEY, true));
    }
  }

  private static final class ClientTimingInterceptor implements ClientInterceptor {
    private final ClientTimingStats stats;

    private ClientTimingInterceptor(ClientTimingStats stats) {
      this.stats = stats;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
      ClientCall<ReqT, RespT> delegate = next.newCall(method, callOptions);
      if (!method.getFullMethodName().equals(ChannelStats.EXECUTE_STREAMING_SQL)) {
        return delegate;
      }
      return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(delegate) {
        @Override
        public void start(Listener<RespT> responseListener, Metadata headers) {
          stats.recordStart();
          super.start(responseListener, headers);
        }

        @Override
        public void sendMessage(ReqT message) {
          stats.recordSendMessage();
          super.sendMessage(message);
        }

        @Override
        public void halfClose() {
          stats.recordHalfClose();
          super.halfClose();
        }
      };
    }
  }

  private static final class ClientTimingStats {
    private final AtomicInteger startLatencyIndex = new AtomicInteger();
    private final AtomicInteger sendMessageLatencyIndex = new AtomicInteger();
    private final AtomicInteger halfCloseLatencyIndex = new AtomicInteger();
    private volatile AtomicIntegerArray startLatenciesMillis =
        new AtomicIntegerArray(CONCURRENT_QUERIES);
    private volatile AtomicIntegerArray sendMessageLatenciesMillis =
        new AtomicIntegerArray(CONCURRENT_QUERIES);
    private volatile AtomicIntegerArray halfCloseLatenciesMillis =
        new AtomicIntegerArray(CONCURRENT_QUERIES);
    private volatile long clientStartNanos;

    void reset(int expectedCalls) {
      startLatencyIndex.set(0);
      sendMessageLatencyIndex.set(0);
      halfCloseLatencyIndex.set(0);
      startLatenciesMillis = new AtomicIntegerArray(expectedCalls);
      sendMessageLatenciesMillis = new AtomicIntegerArray(expectedCalls);
      halfCloseLatenciesMillis = new AtomicIntegerArray(expectedCalls);
      clientStartNanos = 0L;
    }

    void startTiming(long clientStartNanos) {
      this.clientStartNanos = clientStartNanos;
    }

    void recordStart() {
      record(startLatenciesMillis, startLatencyIndex);
    }

    void recordSendMessage() {
      record(sendMessageLatenciesMillis, sendMessageLatencyIndex);
    }

    void recordHalfClose() {
      record(halfCloseLatenciesMillis, halfCloseLatencyIndex);
    }

    ClientTimingSnapshot snapshot() {
      return new ClientTimingSnapshot(
          LatencySummary.of(0L, startLatenciesMillis, startLatencyIndex.get()),
          LatencySummary.of(0L, sendMessageLatenciesMillis, sendMessageLatencyIndex.get()),
          LatencySummary.of(0L, halfCloseLatenciesMillis, halfCloseLatencyIndex.get()));
    }

    private void record(AtomicIntegerArray latenciesMillis, AtomicInteger indexCounter) {
      int index = indexCounter.getAndIncrement();
      if (index < latenciesMillis.length() && clientStartNanos != 0L) {
        latenciesMillis.set(index, saturatedMillis(System.nanoTime() - clientStartNanos));
      }
    }
  }

  private static final class OperationTimingStats {
    private final AtomicInteger contextCreatedLatencyIndex = new AtomicInteger();
    private final AtomicInteger executeReturnedLatencyIndex = new AtomicInteger();
    private final AtomicInteger firstRowLatencyIndex = new AtomicInteger();
    private volatile AtomicIntegerArray contextCreatedLatenciesMillis =
        new AtomicIntegerArray(CONCURRENT_QUERIES);
    private volatile AtomicIntegerArray executeReturnedLatenciesMillis =
        new AtomicIntegerArray(CONCURRENT_QUERIES);
    private volatile AtomicIntegerArray firstRowLatenciesMillis =
        new AtomicIntegerArray(CONCURRENT_QUERIES);
    private volatile long clientStartNanos;

    void reset(int expectedCalls) {
      contextCreatedLatencyIndex.set(0);
      executeReturnedLatencyIndex.set(0);
      firstRowLatencyIndex.set(0);
      contextCreatedLatenciesMillis = new AtomicIntegerArray(expectedCalls);
      executeReturnedLatenciesMillis = new AtomicIntegerArray(expectedCalls);
      firstRowLatenciesMillis = new AtomicIntegerArray(expectedCalls);
      clientStartNanos = 0L;
    }

    void startTiming(long clientStartNanos) {
      this.clientStartNanos = clientStartNanos;
    }

    void recordContextCreated() {
      record(contextCreatedLatenciesMillis, contextCreatedLatencyIndex);
    }

    void recordExecuteReturned() {
      record(executeReturnedLatenciesMillis, executeReturnedLatencyIndex);
    }

    void recordFirstRow() {
      record(firstRowLatenciesMillis, firstRowLatencyIndex);
    }

    OperationTimingSnapshot snapshot() {
      return new OperationTimingSnapshot(
          LatencySummary.of(0L, contextCreatedLatenciesMillis, contextCreatedLatencyIndex.get()),
          LatencySummary.of(0L, executeReturnedLatenciesMillis, executeReturnedLatencyIndex.get()),
          LatencySummary.of(0L, firstRowLatenciesMillis, firstRowLatencyIndex.get()));
    }

    private void record(AtomicIntegerArray latenciesMillis, AtomicInteger indexCounter) {
      int index = indexCounter.getAndIncrement();
      if (index < latenciesMillis.length() && clientStartNanos != 0L) {
        latenciesMillis.set(index, saturatedMillis(System.nanoTime() - clientStartNanos));
      }
    }
  }

  private static final class ChannelStats implements ServerInterceptor {
    static final String EXECUTE_STREAMING_SQL = "google.spanner.v1.Spanner/ExecuteStreamingSql";

    private final Map<String, AtomicInteger> activeByTransport = new ConcurrentHashMap<>();
    private final Map<String, AtomicInteger> maxActiveByTransport = new ConcurrentHashMap<>();
    private final Map<String, AtomicInteger> callsByTransport = new ConcurrentHashMap<>();
    private final Map<String, AtomicInteger> callsByMethod = new ConcurrentHashMap<>();
    private final Map<String, AtomicInteger> callsByRequestIdChannel = new ConcurrentHashMap<>();
    private final AtomicInteger serverReceiveLatencyIndex = new AtomicInteger();
    private volatile AtomicIntegerArray serverReceiveLatenciesMillis =
        new AtomicIntegerArray(CONCURRENT_QUERIES);
    private volatile long clientStartNanos;

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
      String method = call.getMethodDescriptor().getFullMethodName();
      increment(callsByMethod, method);
      if (!method.equals(EXECUTE_STREAMING_SQL)) {
        return Contexts.interceptCall(Context.current(), call, headers, next);
      }

      String transport = transportKey(call);
      String requestIdChannel = requestIdChannel(headers);
      increment(callsByTransport, transport);
      increment(callsByRequestIdChannel, requestIdChannel);
      recordServerReceiveLatency();
      int active = increment(activeByTransport, transport);
      maxActiveByTransport
          .computeIfAbsent(transport, unused -> new AtomicInteger())
          .accumulateAndGet(active, Math::max);

      ServerCall<ReqT, RespT> forwardingCall =
          new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(call) {
            @Override
            public void close(io.grpc.Status status, Metadata trailers) {
              activeByTransport.get(transport).decrementAndGet();
              super.close(status, trailers);
            }
          };
      return Contexts.interceptCall(Context.current(), forwardingCall, headers, next);
    }

    void reset(int expectedCalls) {
      activeByTransport.clear();
      maxActiveByTransport.clear();
      callsByTransport.clear();
      callsByMethod.clear();
      callsByRequestIdChannel.clear();
      serverReceiveLatencyIndex.set(0);
      serverReceiveLatenciesMillis = new AtomicIntegerArray(expectedCalls);
      clientStartNanos = 0L;
    }

    void startTiming(long clientStartNanos) {
      this.clientStartNanos = clientStartNanos;
    }

    Snapshot snapshot() {
      return new Snapshot(
          copy(callsByTransport),
          copy(maxActiveByTransport),
          copy(callsByMethod),
          copy(callsByRequestIdChannel),
          LatencySummary.of(0L, serverReceiveLatenciesMillis, serverReceiveLatencyIndex.get()));
    }

    private static String transportKey(ServerCall<?, ?> call) {
      SocketAddress address = call.getAttributes().get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR);
      return address == null ? "unknown" : address.toString();
    }

    private static String requestIdChannel(Metadata headers) {
      String requestId = headers.get(XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY);
      if (requestId == null) {
        return "none";
      }
      String[] parts = requestId.split("\\.");
      return parts.length >= 4 ? parts[3] : "malformed";
    }

    private static int increment(Map<String, AtomicInteger> map, String key) {
      return map.computeIfAbsent(key, unused -> new AtomicInteger()).incrementAndGet();
    }

    private void recordServerReceiveLatency() {
      int index = serverReceiveLatencyIndex.getAndIncrement();
      if (index < serverReceiveLatenciesMillis.length() && clientStartNanos != 0L) {
        serverReceiveLatenciesMillis.set(
            index, saturatedMillis(System.nanoTime() - clientStartNanos));
      }
    }

    private static Map<String, Integer> copy(Map<String, AtomicInteger> source) {
      ImmutableMap.Builder<String, Integer> builder = ImmutableMap.builder();
      source.forEach((key, value) -> builder.put(key, value.get()));
      return builder.build();
    }
  }

  private static final class Snapshot {
    private final Map<String, Integer> callsByTransport;
    private final Map<String, Integer> maxActiveByTransport;
    private final Map<String, Integer> callsByMethod;
    private final Map<String, Integer> callsByRequestIdChannel;
    private final LatencySummary serverReceiveLatencySummary;

    private Snapshot(
        Map<String, Integer> callsByTransport,
        Map<String, Integer> maxActiveByTransport,
        Map<String, Integer> callsByMethod,
        Map<String, Integer> callsByRequestIdChannel,
        LatencySummary serverReceiveLatencySummary) {
      this.callsByTransport = callsByTransport;
      this.maxActiveByTransport = maxActiveByTransport;
      this.callsByMethod = callsByMethod;
      this.callsByRequestIdChannel = callsByRequestIdChannel;
      this.serverReceiveLatencySummary = serverReceiveLatencySummary;
    }
  }

  private static final class ClientTimingSnapshot {
    private final LatencySummary startLatencySummary;
    private final LatencySummary sendMessageLatencySummary;
    private final LatencySummary halfCloseLatencySummary;

    private ClientTimingSnapshot(
        LatencySummary startLatencySummary,
        LatencySummary sendMessageLatencySummary,
        LatencySummary halfCloseLatencySummary) {
      this.startLatencySummary = startLatencySummary;
      this.sendMessageLatencySummary = sendMessageLatencySummary;
      this.halfCloseLatencySummary = halfCloseLatencySummary;
    }
  }

  private static final class OperationTimingSnapshot {
    private final LatencySummary contextCreatedLatencySummary;
    private final LatencySummary executeReturnedLatencySummary;
    private final LatencySummary firstRowLatencySummary;

    private OperationTimingSnapshot(
        LatencySummary contextCreatedLatencySummary,
        LatencySummary executeReturnedLatencySummary,
        LatencySummary firstRowLatencySummary) {
      this.contextCreatedLatencySummary = contextCreatedLatencySummary;
      this.executeReturnedLatencySummary = executeReturnedLatencySummary;
      this.firstRowLatencySummary = firstRowLatencySummary;
    }
  }

  private static final class PhaseResult {
    private final String phaseName;
    private final long elapsedMillis;
    private final LatencySummary latencySummary;
    private final Snapshot snapshot;
    private final ClientTimingSnapshot clientTimingSnapshot;
    private final OperationTimingSnapshot operationTimingSnapshot;

    private PhaseResult(
        String phaseName,
        long elapsedMillis,
        LatencySummary latencySummary,
        Snapshot snapshot,
        ClientTimingSnapshot clientTimingSnapshot,
        OperationTimingSnapshot operationTimingSnapshot) {
      this.phaseName = phaseName;
      this.elapsedMillis = elapsedMillis;
      this.latencySummary = latencySummary;
      this.snapshot = snapshot;
      this.clientTimingSnapshot = clientTimingSnapshot;
      this.operationTimingSnapshot = operationTimingSnapshot;
    }

    int totalExecuteStreamingSqlCalls() {
      return snapshot.callsByTransport.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public String toString() {
      return "PhaseResult{"
          + "phase="
          + phaseName
          + ", elapsedMillis="
          + elapsedMillis
          + ", p50Millis="
          + latencySummary.p50Millis
          + ", p90Millis="
          + latencySummary.p90Millis
          + ", p99Millis="
          + latencySummary.p99Millis
          + ", serverReceiveP50Millis="
          + snapshot.serverReceiveLatencySummary.p50Millis
          + ", serverReceiveP90Millis="
          + snapshot.serverReceiveLatencySummary.p90Millis
          + ", serverReceiveP99Millis="
          + snapshot.serverReceiveLatencySummary.p99Millis
          + ", clientStartP50Millis="
          + clientTimingSnapshot.startLatencySummary.p50Millis
          + ", clientStartP90Millis="
          + clientTimingSnapshot.startLatencySummary.p90Millis
          + ", clientStartP99Millis="
          + clientTimingSnapshot.startLatencySummary.p99Millis
          + ", clientSendP50Millis="
          + clientTimingSnapshot.sendMessageLatencySummary.p50Millis
          + ", clientSendP90Millis="
          + clientTimingSnapshot.sendMessageLatencySummary.p90Millis
          + ", clientSendP99Millis="
          + clientTimingSnapshot.sendMessageLatencySummary.p99Millis
          + ", clientHalfCloseP50Millis="
          + clientTimingSnapshot.halfCloseLatencySummary.p50Millis
          + ", clientHalfCloseP90Millis="
          + clientTimingSnapshot.halfCloseLatencySummary.p90Millis
          + ", clientHalfCloseP99Millis="
          + clientTimingSnapshot.halfCloseLatencySummary.p99Millis
          + ", contextCreatedP50Millis="
          + operationTimingSnapshot.contextCreatedLatencySummary.p50Millis
          + ", contextCreatedP90Millis="
          + operationTimingSnapshot.contextCreatedLatencySummary.p90Millis
          + ", contextCreatedP99Millis="
          + operationTimingSnapshot.contextCreatedLatencySummary.p99Millis
          + ", executeReturnedP50Millis="
          + operationTimingSnapshot.executeReturnedLatencySummary.p50Millis
          + ", executeReturnedP90Millis="
          + operationTimingSnapshot.executeReturnedLatencySummary.p90Millis
          + ", executeReturnedP99Millis="
          + operationTimingSnapshot.executeReturnedLatencySummary.p99Millis
          + ", firstRowP50Millis="
          + operationTimingSnapshot.firstRowLatencySummary.p50Millis
          + ", firstRowP90Millis="
          + operationTimingSnapshot.firstRowLatencySummary.p90Millis
          + ", firstRowP99Millis="
          + operationTimingSnapshot.firstRowLatencySummary.p99Millis
          + ", measuredCallsByMethod="
          + ordered(snapshot.callsByMethod)
          + ", callsByTransport="
          + ordered(snapshot.callsByTransport)
          + ", maxActiveByTransport="
          + ordered(snapshot.maxActiveByTransport)
          + ", callsByRequestIdChannel="
          + ordered(snapshot.callsByRequestIdChannel)
          + '}';
    }
  }

  private static final class LoadResult {
    private final String name;
    private final long elapsedMillis;
    private final Snapshot setupSnapshot;
    private final List<PhaseResult> phases;

    private LoadResult(
        String name, long elapsedMillis, Snapshot setupSnapshot, List<PhaseResult> phases) {
      this.name = name;
      this.elapsedMillis = elapsedMillis;
      this.setupSnapshot = setupSnapshot;
      this.phases = phases;
    }

    static LoadResult forBurst(
        String name, long elapsedMillis, Snapshot setupSnapshot, PhaseResult burst) {
      List<PhaseResult> phases = new ArrayList<>();
      phases.add(burst);
      return new LoadResult(name, elapsedMillis, setupSnapshot, phases);
    }

    static LoadResult forPhases(
        String name,
        long elapsedMillis,
        Snapshot setupSnapshot,
        PhaseResult spike,
        PhaseResult stable) {
      List<PhaseResult> phases = new ArrayList<>();
      phases.add(spike);
      phases.add(stable);
      return new LoadResult(name, elapsedMillis, setupSnapshot, phases);
    }

    int totalExecuteStreamingSqlCalls() {
      return phases.stream().mapToInt(PhaseResult::totalExecuteStreamingSqlCalls).sum();
    }

    @Override
    public String toString() {
      return "LoadResult{"
          + "name="
          + name
          + ", elapsedMillis="
          + elapsedMillis
          + ", workloadShape="
          + WORKLOAD_SHAPE
          + ", operation="
          + OPERATION
          + ", warmupQueries="
          + WARMUP_QUERIES
          + ", spikeQueries="
          + SPIKE_QUERIES
          + ", stableConcurrency="
          + STABLE_CONCURRENCY
          + ", stableRounds="
          + STABLE_ROUNDS
          + ", gaxFirst="
          + GAX_FIRST
          + ", disableGrpcGcpAffinity="
          + DISABLE_GRPC_GCP_AFFINITY
          + ", setupCallsByMethod="
          + ordered(setupSnapshot.callsByMethod)
          + ", phases="
          + phases
          + '}';
    }
  }

  private static final class LoadPair {
    private final LoadResult grpcGcp;
    private final LoadResult gax;

    private LoadPair(LoadResult grpcGcp, LoadResult gax) {
      this.grpcGcp = grpcGcp;
      this.gax = gax;
    }
  }

  private static final class AggregateResult {
    private final String name;
    private final int runs;
    private final Map<String, PhaseAggregate> phases;

    private AggregateResult(String name, int runs, Map<String, PhaseAggregate> phases) {
      this.name = name;
      this.runs = runs;
      this.phases = phases;
    }

    static AggregateResult of(String name, List<LoadResult> results) {
      Map<String, PhaseAggregate> phases = new LinkedHashMap<>();
      for (LoadResult result : results) {
        for (PhaseResult phase : result.phases) {
          phases.computeIfAbsent(phase.phaseName, PhaseAggregate::new).add(phase);
        }
      }
      return new AggregateResult(name, results.size(), phases);
    }

    @Override
    public String toString() {
      return "AggregateResult{"
          + "name="
          + name
          + ", runs="
          + runs
          + ", measurementPairs="
          + MEASUREMENT_PAIRS
          + ", discardFirstMeasurementPair="
          + DISCARD_FIRST_PAIR
          + ", phases="
          + phases.values()
          + '}';
    }
  }

  private static final class PhaseAggregate {
    private final String phaseName;
    private int runs;
    private int calls;
    private long elapsedMillis;
    private long p50Millis;
    private long p90Millis;
    private long p99Millis;
    private long serverReceiveP50Millis;
    private long serverReceiveP90Millis;
    private long serverReceiveP99Millis;
    private long firstRowP50Millis;
    private long firstRowP90Millis;
    private long firstRowP99Millis;

    private PhaseAggregate(String phaseName) {
      this.phaseName = phaseName;
    }

    void add(PhaseResult phase) {
      runs++;
      calls += phase.totalExecuteStreamingSqlCalls();
      elapsedMillis += phase.elapsedMillis;
      p50Millis += phase.latencySummary.p50Millis;
      p90Millis += phase.latencySummary.p90Millis;
      p99Millis += phase.latencySummary.p99Millis;
      serverReceiveP50Millis += phase.snapshot.serverReceiveLatencySummary.p50Millis;
      serverReceiveP90Millis += phase.snapshot.serverReceiveLatencySummary.p90Millis;
      serverReceiveP99Millis += phase.snapshot.serverReceiveLatencySummary.p99Millis;
      firstRowP50Millis += phase.operationTimingSnapshot.firstRowLatencySummary.p50Millis;
      firstRowP90Millis += phase.operationTimingSnapshot.firstRowLatencySummary.p90Millis;
      firstRowP99Millis += phase.operationTimingSnapshot.firstRowLatencySummary.p99Millis;
    }

    @Override
    public String toString() {
      return "PhaseAggregate{"
          + "phase="
          + phaseName
          + ", runs="
          + runs
          + ", calls="
          + calls
          + ", avgElapsedMillis="
          + average(elapsedMillis, runs)
          + ", avgP50Millis="
          + average(p50Millis, runs)
          + ", avgP90Millis="
          + average(p90Millis, runs)
          + ", avgP99Millis="
          + average(p99Millis, runs)
          + ", avgServerReceiveP50Millis="
          + average(serverReceiveP50Millis, runs)
          + ", avgServerReceiveP90Millis="
          + average(serverReceiveP90Millis, runs)
          + ", avgServerReceiveP99Millis="
          + average(serverReceiveP99Millis, runs)
          + ", avgFirstRowP50Millis="
          + average(firstRowP50Millis, runs)
          + ", avgFirstRowP90Millis="
          + average(firstRowP90Millis, runs)
          + ", avgFirstRowP99Millis="
          + average(firstRowP99Millis, runs)
          + '}';
    }

    private static long average(long value, int count) {
      return count == 0 ? 0L : value / count;
    }
  }

  private static final class LatencyRecorder {
    private final AtomicInteger index = new AtomicInteger();
    private final AtomicIntegerArray latenciesMillis;

    private LatencyRecorder(int expectedCalls) {
      this.latenciesMillis = new AtomicIntegerArray(expectedCalls);
    }

    void record(long nanos) {
      int position = index.getAndIncrement();
      if (position < latenciesMillis.length()) {
        latenciesMillis.set(position, saturatedMillis(nanos));
      }
    }

    LatencySummary summary(long elapsedMillis) {
      return LatencySummary.of(elapsedMillis, latenciesMillis, index.get());
    }
  }

  private static final class LatencySummary {
    private final long elapsedMillis;
    private final int p50Millis;
    private final int p90Millis;
    private final int p99Millis;

    private LatencySummary(long elapsedMillis, int p50Millis, int p90Millis, int p99Millis) {
      this.elapsedMillis = elapsedMillis;
      this.p50Millis = p50Millis;
      this.p90Millis = p90Millis;
      this.p99Millis = p99Millis;
    }

    private static LatencySummary of(
        long elapsedMillis, AtomicIntegerArray latenciesMillis, int recordedCount) {
      int count = Math.max(0, Math.min(recordedCount, latenciesMillis.length()));
      if (count == 0) {
        return new LatencySummary(elapsedMillis, 0, 0, 0);
      }
      List<Integer> values = new ArrayList<>(count);
      for (int i = 0; i < count; i++) {
        values.add(latenciesMillis.get(i));
      }
      values.sort(Integer::compareTo);
      return new LatencySummary(
          elapsedMillis, percentile(values, 50), percentile(values, 90), percentile(values, 99));
    }

    private static int percentile(List<Integer> sortedValues, int percentile) {
      int index = (int) Math.ceil((percentile / 100.0D) * sortedValues.size()) - 1;
      return sortedValues.get(Math.max(0, Math.min(index, sortedValues.size() - 1)));
    }
  }
}
