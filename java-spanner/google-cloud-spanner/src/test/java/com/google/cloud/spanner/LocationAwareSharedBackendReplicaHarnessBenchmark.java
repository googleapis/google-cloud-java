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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.spi.v1.KeyRecipeCache;
import com.google.common.base.MoreObjects;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import com.google.protobuf.ListValue;
import com.google.protobuf.TextFormat;
import com.google.protobuf.Value;
import com.google.rpc.RetryInfo;
import com.google.spanner.v1.CacheUpdate;
import com.google.spanner.v1.Group;
import com.google.spanner.v1.Range;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RecipeList;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.RoutingHint;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.Tablet;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
 * Benchmark for repeated strong reads that all resolve to the same cached location entry.
 *
 * <p>The benchmark uses the shared-backend replica harness so all replicas serve the same fixed
 * payload. That keeps the backend deterministic and makes the reported latency primarily reflect
 * the client-side location-aware strong read path, including cache lookup, endpoint selection, and
 * retry/reroute behavior after an initial error burst.
 */
@BenchmarkMode(Mode.SingleShotTime)
@Fork(value = 1, warmups = 0)
@Measurement(batchSize = 1, iterations = 1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 0)
public class LocationAwareSharedBackendReplicaHarnessBenchmark extends AbstractLatencyBenchmark {

  private static final Duration BENCHMARK_TIMEOUT = Duration.ofMinutes(30);

  private static final String PROJECT = "fake-project";
  private static final String INSTANCE = "fake-instance";
  private static final String DATABASE = "fake-database";
  private static final String TABLE = "T";
  private static final String BENCHMARK_KEY = "same-group-key";
  private static final String BENCHMARK_VALUE = "same-group-value";
  private static final Statement SEED_QUERY = Statement.of("SELECT 1");
  private static final int REPLICA_COUNT = 3;
  private static final int LEADER_REPLICA_INDEX = 0;
  private static final int READS_PER_THREAD =
      Integer.parseInt(
          MoreObjects.firstNonNull(
              System.getenv("SPANNER_LOCATION_AWARE_BENCHMARK_READS_PER_THREAD"), "2000"));
  private static final int WARMUP_READS_PER_THREAD =
      Integer.parseInt(
          MoreObjects.firstNonNull(
              System.getenv("SPANNER_LOCATION_AWARE_BENCHMARK_WARMUP_READS_PER_THREAD"), "50"));
  private static final int LEADER_ERROR_BURST =
      Integer.parseInt(
          MoreObjects.firstNonNull(
              System.getenv("SPANNER_LOCATION_AWARE_BENCHMARK_LEADER_ERROR_BURST"), "6"));
  private static final int STREAMING_READ_MIN_LATENCY_MS =
      Integer.parseInt(
          MoreObjects.firstNonNull(
              System.getenv("SPANNER_LOCATION_AWARE_BENCHMARK_STREAMING_READ_MIN_MS"), "0"));
  private static final int STREAMING_READ_JITTER_MS =
      Integer.parseInt(
          MoreObjects.firstNonNull(
              System.getenv("SPANNER_LOCATION_AWARE_BENCHMARK_STREAMING_READ_JITTER_MS"), "0"));

  @State(Scope.Benchmark)
  public static class BenchmarkState {
    @Param({"steady_state", "resource_exhausted_bootstrap", "unavailable_bootstrap"})
    public String scenario;

    private SharedBackendReplicaHarness harness;
    private Spanner spanner;
    private DatabaseClient client;

    @Setup(Level.Iteration)
    public void setup() throws Exception {
      SpannerOptions.useEnvironment(
          new SpannerOptions.SpannerEnvironment() {
            @Override
            public boolean isEnableLocationApi() {
              return true;
            }
          });
      harness = SharedBackendReplicaHarness.create(REPLICA_COUNT, false);
      configureBackend(harness);
      spanner = createSpanner(harness);
      client = spanner.getDatabaseClient(DatabaseId.of(PROJECT, INSTANCE, DATABASE));

      seedLocationMetadata(client);
      waitForReplicaRoutedStrongRead(client, harness, LEADER_REPLICA_INDEX);

      if (!"steady_state".equals(scenario)) {
        primeReplicaPenalty(client, harness, scenario);
      }

      harness.clearRequests();
    }

    @TearDown(Level.Iteration)
    public void teardown() throws Exception {
      try {
        if (spanner != null) {
          spanner.close();
        }
      } finally {
        spanner = null;
        client = null;
        if (harness != null) {
          harness.close();
        }
        harness = null;
        SpannerOptions.useDefaultEnvironment();
      }
    }
  }

  private static final class ReadMeasurement {
    private final Duration totalLatency;
    private final Duration contextSetupLatency;
    private final Duration openCallLatency;
    private final Duration firstRowLatency;
    private final Duration drainAndCloseLatency;

    private ReadMeasurement(
        Duration totalLatency,
        Duration contextSetupLatency,
        Duration openCallLatency,
        Duration firstRowLatency,
        Duration drainAndCloseLatency) {
      this.totalLatency = totalLatency;
      this.contextSetupLatency = contextSetupLatency;
      this.openCallLatency = openCallLatency;
      this.firstRowLatency = firstRowLatency;
      this.drainAndCloseLatency = drainAndCloseLatency;
    }
  }

  @Benchmark
  public void strongReadsAgainstSingleCachedGroup(BenchmarkState benchmarkState) throws Exception {
    ListeningScheduledExecutorService executor =
        MoreExecutors.listeningDecorator(Executors.newScheduledThreadPool(PARALLEL_THREADS));
    List<ListenableFuture<List<ReadMeasurement>>> futures = new ArrayList<>(PARALLEL_THREADS);
    CountDownLatch warmupDone = new CountDownLatch(PARALLEL_THREADS);
    CountDownLatch startMeasured = new CountDownLatch(1);
    for (int thread = 0; thread < PARALLEL_THREADS; thread++) {
      futures.add(
          executor.submit(
              () ->
                  runBenchmarksForStrongReads(
                      benchmarkState,
                      WARMUP_READS_PER_THREAD,
                      READS_PER_THREAD,
                      warmupDone,
                      startMeasured)));
    }

    if (!warmupDone.await(BENCHMARK_TIMEOUT.toMinutes(), TimeUnit.MINUTES)) {
      throw new IllegalStateException("Timed out waiting for benchmark warmup to complete");
    }

    benchmarkState.harness.clearRequests();
    Stopwatch elapsed = Stopwatch.createStarted();
    startMeasured.countDown();

    List<ReadMeasurement> measurements = collectReadMeasurements(executor, futures);
    List<Duration> totalLatencies = totalLatencies(measurements);

    printScenario(benchmarkState);
    printResults(totalLatencies);
    printThroughput(totalLatencies.size(), elapsed.elapsed());
    printRoutingCounters(benchmarkState.harness, totalLatencies.size());
    printStageTimings(measurements);
  }

  private List<ReadMeasurement> runBenchmarksForStrongReads(
      BenchmarkState benchmarkState,
      int warmupReads,
      int measuredReads,
      CountDownLatch warmupDone,
      CountDownLatch startMeasured)
      throws InterruptedException {
    for (int i = 0; i < warmupReads; i++) {
      executeStrongRead(benchmarkState.client);
    }
    warmupDone.countDown();
    startMeasured.await();

    List<ReadMeasurement> results = new ArrayList<>(measuredReads);
    for (int i = 0; i < measuredReads; i++) {
      results.add(executeStrongRead(benchmarkState.client));
    }
    return results;
  }

  private ReadMeasurement executeStrongRead(DatabaseClient client) {
    long startNanos = System.nanoTime();
    ReadContext readContext = client.singleUse();
    long afterContextSetupNanos = System.nanoTime();
    ResultSet resultSet =
        readContext.read(TABLE, KeySet.singleKey(Key.of(BENCHMARK_KEY)), Arrays.asList("k"));
    long afterOpenCallNanos = System.nanoTime();

    long afterFirstRowNanos;
    try {
      boolean sawRow = resultSet.next();
      afterFirstRowNanos = System.nanoTime();
      assertTrue("Expected the strong read benchmark to return one row", sawRow);
      assertNotNull(resultSet.getValue(0));
      while (resultSet.next()) {
        assertNotNull(resultSet.getValue(0));
      }
    } finally {
      resultSet.close();
    }
    long endNanos = System.nanoTime();

    return new ReadMeasurement(
        Duration.ofNanos(endNanos - startNanos),
        Duration.ofNanos(afterContextSetupNanos - startNanos),
        Duration.ofNanos(afterOpenCallNanos - afterContextSetupNanos),
        Duration.ofNanos(afterFirstRowNanos - afterOpenCallNanos),
        Duration.ofNanos(endNanos - afterFirstRowNanos));
  }

  private void printScenario(BenchmarkState benchmarkState) {
    System.out.println();
    System.out.printf("Scenario: %s%n", benchmarkState.scenario);
    System.out.printf("Parallel threads: %d%n", PARALLEL_THREADS);
    System.out.printf("Warmup reads per thread: %d%n", WARMUP_READS_PER_THREAD);
    System.out.printf("Measured reads per thread: %d%n", READS_PER_THREAD);
    System.out.printf(
        "Mock streaming read latency: min=%dms jitter=%dms%n",
        STREAMING_READ_MIN_LATENCY_MS, STREAMING_READ_JITTER_MS);
  }

  private void printThroughput(int operations, Duration elapsed) {
    double seconds = elapsed.toNanos() / 1_000_000_000.0;
    double throughput = seconds == 0.0 ? operations : operations / seconds;
    System.out.printf("Throughput: %.2f ops/s%n", throughput);
  }

  private void printRoutingCounters(SharedBackendReplicaHarness harness, int logicalReads) {
    int defaultEndpointAttempts =
        harness.defaultReplica.getRequestCount(SharedBackendReplicaHarness.METHOD_STREAMING_READ);
    int defaultEndpointLogicalReads =
        harness.defaultReplica.getLogicalRequestCount(
            SharedBackendReplicaHarness.METHOD_STREAMING_READ);
    int retryAttempts = totalRetryAttempts(harness);
    int endpointAttempts = totalEndpointAttempts(harness);
    System.out.printf("Logical reads: %d%n", logicalReads);
    System.out.printf("Endpoint attempts: %d%n", endpointAttempts);
    System.out.printf("Extra attempts above logical reads: %d%n", endpointAttempts - logicalReads);
    System.out.printf("Retry attempts: %d%n", retryAttempts);
    System.out.printf("Default endpoint attempts: %d%n", defaultEndpointAttempts);
    System.out.printf("Default endpoint logical reads: %d%n", defaultEndpointLogicalReads);
    System.out.printf(
        "Replica-cache logical reads: %d%n",
        Math.max(0, logicalReads - defaultEndpointLogicalReads));
    System.out.printf("Default endpoint streaming reads: %d%n", defaultEndpointAttempts);
    for (int i = 0; i < harness.replicas.size(); i++) {
      System.out.printf(
          "Replica %d streaming reads: %d%n",
          i,
          harness
              .replicas
              .get(i)
              .getRequestCount(SharedBackendReplicaHarness.METHOD_STREAMING_READ));
    }
  }

  private void printStageTimings(List<ReadMeasurement> measurements) {
    printStageTiming("context_setup", collectStageLatencies(measurements, Stage.CONTEXT_SETUP));
    printStageTiming("read_open", collectStageLatencies(measurements, Stage.READ_OPEN));
    printStageTiming("first_row", collectStageLatencies(measurements, Stage.FIRST_ROW));
    printStageTiming("drain_and_close", collectStageLatencies(measurements, Stage.DRAIN_AND_CLOSE));
  }

  private void printStageTiming(String stageName, List<Duration> latencies) {
    if (latencies.isEmpty()) {
      return;
    }
    List<Duration> ordered = new ArrayList<>(latencies);
    Collections.sort(ordered);
    System.out.printf(
        "Stage %s: avg=%.6fms p50=%.6fms p95=%.6fms%n",
        stageName,
        averageMillis(latencies),
        percentileMillis(50, ordered),
        percentileMillis(95, ordered));
  }

  private static void configureBackend(SharedBackendReplicaHarness harness)
      throws TextFormat.ParseException {
    Statement readStatement =
        StatementResult.createReadStatement(
            TABLE, KeySet.singleKey(Key.of(BENCHMARK_KEY)), Arrays.asList("k"));
    harness.backend.putStatementResult(
        StatementResult.query(readStatement, singleRowReadResultSet(BENCHMARK_VALUE)));
    harness.backend.putStatementResult(
        StatementResult.query(
            SEED_QUERY,
            singleRowReadResultSet("seed").toBuilder()
                .setCacheUpdate(cacheUpdate(harness))
                .build()));
    harness.backend.setStreamingReadExecutionTime(
        MockSpannerServiceImpl.SimulatedExecutionTime.ofMinimumAndRandomTime(
            STREAMING_READ_MIN_LATENCY_MS, STREAMING_READ_JITTER_MS));
  }

  private static Spanner createSpanner(SharedBackendReplicaHarness harness) {
    return SpannerOptions.newBuilder()
        .usePlainText()
        .setExperimentalHost(harness.defaultAddress)
        .setSessionPoolOption(
            SessionPoolOptions.newBuilder()
                .setExperimentalHost()
                .setUseMultiplexedSession(true)
                .setUseMultiplexedSessionForRW(true)
                .build())
        .setProjectId(PROJECT)
        .setNumChannels(NUM_GRPC_CHANNELS)
        .setCredentials(NoCredentials.getInstance())
        .setChannelEndpointCacheFactory(null)
        .build()
        .getService();
  }

  private static void seedLocationMetadata(DatabaseClient client) {
    try (ResultSet resultSet = client.singleUse().executeQuery(SEED_QUERY)) {
      while (resultSet.next()) {
        // Consume the cache update from the first query result.
      }
    }
  }

  private static void waitForReplicaRoutedStrongRead(
      DatabaseClient client, SharedBackendReplicaHarness harness, int expectedReplicaIndex)
      throws InterruptedException {
    long deadlineNanos = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
    while (System.nanoTime() < deadlineNanos) {
      harness.clearRequests();
      try (ResultSet resultSet =
          client
              .singleUse()
              .read(TABLE, KeySet.singleKey(Key.of(BENCHMARK_KEY)), Arrays.asList("k"))) {
        if (resultSet.next()
            && harness
                    .replicas
                    .get(expectedReplicaIndex)
                    .getRequestCount(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
                > 0) {
          return;
        }
      }
      Thread.sleep(50L);
    }
    throw new AssertionError(
        "Timed out waiting for strong read to route to replica " + expectedReplicaIndex);
  }

  private static void primeReplicaPenalty(
      DatabaseClient client, SharedBackendReplicaHarness harness, String scenario) {
    RuntimeException leaderFailure =
        "resource_exhausted_bootstrap".equals(scenario)
            ? resourceExhaustedWithRetryInfo("benchmark leader overload")
            : unavailable("benchmark leader unavailable");
    for (int i = 0; i < LEADER_ERROR_BURST; i++) {
      harness
          .replicas
          .get(LEADER_REPLICA_INDEX)
          .putMethodErrors(SharedBackendReplicaHarness.METHOD_STREAMING_READ, leaderFailure);
      try (ResultSet resultSet =
          client
              .singleUse()
              .read(TABLE, KeySet.singleKey(Key.of(BENCHMARK_KEY)), Arrays.asList("k"))) {
        while (resultSet.next()) {
          // Consume rows so retries and routing complete before the next iteration.
        }
      }
    }

    boolean routedAwayFromLeader = false;
    long deadlineNanos = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
    while (System.nanoTime() < deadlineNanos && !routedAwayFromLeader) {
      harness.clearRequests();
      try (ResultSet resultSet =
          client
              .singleUse()
              .read(TABLE, KeySet.singleKey(Key.of(BENCHMARK_KEY)), Arrays.asList("k"))) {
        while (resultSet.next()) {
          // Consume the row to make routing observable through request counters.
        }
      }
      for (int replicaIndex = 1; replicaIndex < harness.replicas.size(); replicaIndex++) {
        if (harness
                .replicas
                .get(replicaIndex)
                .getRequestCount(SharedBackendReplicaHarness.METHOD_STREAMING_READ)
            > 0) {
          routedAwayFromLeader = true;
          break;
        }
      }
    }
    assertTrue(
        "Expected strong reads to route away from the leader after bootstrap",
        routedAwayFromLeader);
  }

  private static CacheUpdate cacheUpdate(SharedBackendReplicaHarness harness)
      throws TextFormat.ParseException {
    RecipeList recipes = readRecipeList();
    RoutingHint routingHint = exactReadRoutingHint(recipes);
    ByteString limitKey = routingHint.getLimitKey();
    if (limitKey.isEmpty()) {
      limitKey = routingHint.getKey().concat(ByteString.copyFrom(new byte[] {0}));
    }

    return CacheUpdate.newBuilder()
        .setDatabaseId(12345L)
        .setKeyRecipes(recipes)
        .addRange(
            Range.newBuilder()
                .setStartKey(routingHint.getKey())
                .setLimitKey(limitKey)
                .setGroupUid(1L)
                .setSplitId(1L)
                .setGeneration(ByteString.copyFromUtf8("gen1")))
        .addGroup(
            Group.newBuilder()
                .setGroupUid(1L)
                .setGeneration(ByteString.copyFromUtf8("gen1"))
                .setLeaderIndex(LEADER_REPLICA_INDEX)
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(11L)
                        .setServerAddress(harness.replicaAddresses.get(0))
                        .setLocation("us-east1")
                        .setRole(Tablet.Role.READ_WRITE)
                        .setDistance(0))
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(12L)
                        .setServerAddress(harness.replicaAddresses.get(1))
                        .setLocation("us-east1")
                        .setRole(Tablet.Role.READ_ONLY)
                        .setDistance(0))
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(13L)
                        .setServerAddress(harness.replicaAddresses.get(2))
                        .setLocation("us-east1")
                        .setRole(Tablet.Role.READ_ONLY)
                        .setDistance(0)))
        .build();
  }

  private static RecipeList readRecipeList() throws TextFormat.ParseException {
    RecipeList.Builder recipes = RecipeList.newBuilder();
    TextFormat.merge(
        "schema_generation: \"1\"\n"
            + "recipe {\n"
            + "  table_name: \""
            + TABLE
            + "\"\n"
            + "  part { tag: 1 }\n"
            + "  part {\n"
            + "    order: ASCENDING\n"
            + "    null_order: NULLS_FIRST\n"
            + "    type { code: STRING }\n"
            + "    identifier: \"k\"\n"
            + "  }\n"
            + "}\n",
        recipes);
    return recipes.build();
  }

  private static RoutingHint exactReadRoutingHint(RecipeList recipes) {
    KeyRecipeCache recipeCache = new KeyRecipeCache();
    recipeCache.addRecipes(recipes);
    ReadRequest.Builder request =
        ReadRequest.newBuilder()
            .setSession(
                String.format(
                    "projects/%s/instances/%s/databases/%s/sessions/test-session",
                    PROJECT, INSTANCE, DATABASE))
            .setTable(TABLE)
            .addAllColumns(Arrays.asList("k"));
    KeySet.singleKey(Key.of(BENCHMARK_KEY)).appendToProto(request.getKeySetBuilder());
    recipeCache.computeKeys(request);
    return request.getRoutingHint();
  }

  private static StatusRuntimeException resourceExhaustedWithRetryInfo(String description) {
    Metadata trailers = new Metadata();
    trailers.put(
        ProtoUtils.keyForProto(RetryInfo.getDefaultInstance()),
        RetryInfo.newBuilder()
            .setRetryDelay(
                com.google.protobuf.Duration.newBuilder()
                    .setNanos((int) TimeUnit.MILLISECONDS.toNanos(1L))
                    .build())
            .build());
    return Status.RESOURCE_EXHAUSTED.withDescription(description).asRuntimeException(trailers);
  }

  private static StatusRuntimeException unavailable(String description) {
    return Status.UNAVAILABLE.withDescription(description).asRuntimeException();
  }

  private static com.google.spanner.v1.ResultSet singleRowReadResultSet(String value) {
    return com.google.spanner.v1.ResultSet.newBuilder()
        .setMetadata(
            ResultSetMetadata.newBuilder()
                .setRowType(
                    StructType.newBuilder()
                        .addFields(
                            StructType.Field.newBuilder()
                                .setName("k")
                                .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                .build())
                        .build()))
        .addRows(
            ListValue.newBuilder()
                .addValues(Value.newBuilder().setStringValue(value).build())
                .build())
        .build();
  }

  private List<ReadMeasurement> collectReadMeasurements(
      ListeningScheduledExecutorService executor,
      List<ListenableFuture<List<ReadMeasurement>>> futures)
      throws Exception {
    executor.shutdown();
    if (!executor.awaitTermination(BENCHMARK_TIMEOUT.toMinutes(), TimeUnit.MINUTES)) {
      throw new IllegalStateException("Timed out waiting for benchmark tasks to finish");
    }
    List<ReadMeasurement> results = new ArrayList<>(READS_PER_THREAD * PARALLEL_THREADS);
    for (Future<List<ReadMeasurement>> future : futures) {
      results.addAll(future.get());
    }
    return results;
  }

  private List<Duration> totalLatencies(List<ReadMeasurement> measurements) {
    return collectStageLatencies(measurements, Stage.TOTAL);
  }

  private List<Duration> collectStageLatencies(List<ReadMeasurement> measurements, Stage stage) {
    List<Duration> latencies = new ArrayList<>(measurements.size());
    for (ReadMeasurement measurement : measurements) {
      latencies.add(stage.durationOf(measurement));
    }
    return latencies;
  }

  private int totalEndpointAttempts(SharedBackendReplicaHarness harness) {
    int count =
        harness.defaultReplica.getRequestCount(SharedBackendReplicaHarness.METHOD_STREAMING_READ);
    for (SharedBackendReplicaHarness.HookedReplicaSpannerService replica : harness.replicas) {
      count += replica.getRequestCount(SharedBackendReplicaHarness.METHOD_STREAMING_READ);
    }
    return count;
  }

  private int totalRetryAttempts(SharedBackendReplicaHarness harness) {
    int count =
        harness.defaultReplica.getRetryAttemptCount(
            SharedBackendReplicaHarness.METHOD_STREAMING_READ);
    for (SharedBackendReplicaHarness.HookedReplicaSpannerService replica : harness.replicas) {
      count += replica.getRetryAttemptCount(SharedBackendReplicaHarness.METHOD_STREAMING_READ);
    }
    return count;
  }

  private double averageMillis(List<Duration> latencies) {
    double total = 0.0;
    for (Duration latency : latencies) {
      total += latency.toNanos() / 1_000_000.0;
    }
    return total / latencies.size();
  }

  private double percentileMillis(int percentile, List<Duration> orderedLatencies) {
    int index = percentile * orderedLatencies.size() / 100;
    if (index >= orderedLatencies.size()) {
      index = orderedLatencies.size() - 1;
    }
    return orderedLatencies.get(index).toNanos() / 1_000_000.0;
  }

  private enum Stage {
    TOTAL {
      @Override
      Duration durationOf(ReadMeasurement measurement) {
        return measurement.totalLatency;
      }
    },
    CONTEXT_SETUP {
      @Override
      Duration durationOf(ReadMeasurement measurement) {
        return measurement.contextSetupLatency;
      }
    },
    READ_OPEN {
      @Override
      Duration durationOf(ReadMeasurement measurement) {
        return measurement.openCallLatency;
      }
    },
    FIRST_ROW {
      @Override
      Duration durationOf(ReadMeasurement measurement) {
        return measurement.firstRowLatency;
      }
    },
    DRAIN_AND_CLOSE {
      @Override
      Duration durationOf(ReadMeasurement measurement) {
        return measurement.drainAndCloseLatency;
      }
    };

    abstract Duration durationOf(ReadMeasurement measurement);
  }
}
