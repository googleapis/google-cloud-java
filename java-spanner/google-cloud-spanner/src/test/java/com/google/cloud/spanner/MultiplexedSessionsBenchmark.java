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

package com.google.cloud.spanner;

import static com.google.cloud.spanner.BenchmarkingUtilityScripts.collectResults;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
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
 * Benchmarks for measuring existing latencies of various APIs using the Java Client with
 * multiplexed sessions. The benchmarks are bound to the Maven profile `benchmark` and can be
 * executed like this: <code>
 *   mvn clean test -DskipTests -Pbenchmark -Dbenchmark.name=MultiplexedSessionsBenchmark
 * </code> Test Table Schema :
 *
 * <p>CREATE TABLE FOO ( id INT64 NOT NULL, BAZ INT64, BAR INT64, ) PRIMARY KEY(id);
 *
 * <p>Below are a few considerations here: 1. We use all default options with multiplexed sessions
 * for this test because that is what most customers would be using. 2. The test schema uses a
 * numeric primary key. To ensure that the reads/updates are distributed across a large query space,
 * we insert 10^5 records. Utility at {@link BenchmarkingUtilityScripts} can be used for loading
 * data. 3. For queries, we make sure that the query is sampled randomly across a large query space.
 * This ensure we don't cause hot-spots. 4. For avoid cold start issues, we execute 1 query/update
 * and ignore its latency from the final reported metrics.
 */
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1, warmups = 0)
@Measurement(batchSize = 1, iterations = 1, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 0)
public class MultiplexedSessionsBenchmark extends AbstractLatencyBenchmark {

  @State(Scope.Benchmark)
  public static class BenchmarkState {

    // TODO(developer): Add your values here for PROJECT_ID, INSTANCE_ID, DATABASE_ID
    private static final String INSTANCE_ID = "";
    private static final String DATABASE_ID = "";
    private static final String SERVER_URL = "https://staging-wrenchworks.sandbox.googleapis.com";
    private Spanner spanner;
    private DatabaseClientImpl client;

    @Param({"100"})
    int minSessions;

    @Param({"400"})
    int maxSessions;

    @Setup(Level.Iteration)
    public void setup() throws Exception {
      SpannerOptions.enableOpenTelemetryMetrics();
      SpannerOptions.enableOpenTelemetryTraces();
      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setSessionPoolOption(
                  SessionPoolOptions.newBuilder()
                      .setMinSessions(minSessions)
                      .setMaxSessions(maxSessions)
                      .setWaitForMinSessionsDuration(Duration.ofSeconds(20))
                      .setUseMultiplexedSession(true)
                      .build())
              .setHost(SERVER_URL)
              .setNumChannels(NUM_GRPC_CHANNELS)
              .build();
      spanner = options.getService();
      client =
          (DatabaseClientImpl)
              spanner.getDatabaseClient(
                  DatabaseId.of(options.getProjectId(), INSTANCE_ID, DATABASE_ID));
    }

    @TearDown(Level.Iteration)
    public void teardown() throws Exception {
      spanner.close();
    }
  }

  /** Measures the time needed to execute a burst of queries. */
  @Benchmark
  public void burstQueries(final BenchmarkState server) throws Exception {
    final DatabaseClientImpl client = server.client;

    ListeningScheduledExecutorService service =
        MoreExecutors.listeningDecorator(Executors.newScheduledThreadPool(PARALLEL_THREADS));
    List<ListenableFuture<List<Duration>>> results = new ArrayList<>(PARALLEL_THREADS);
    for (int i = 0; i < PARALLEL_THREADS; i++) {
      results.add(
          service.submit(() -> runBenchmarksForSingleUseQueries(server, TOTAL_READS_PER_RUN)));
    }
    collectResultsAndPrint(service, results, TOTAL_READS_PER_RUN);
  }

  private List<Duration> runBenchmarksForSingleUseQueries(
      final BenchmarkState server, int numberOfOperations) {
    List<Duration> results = new ArrayList<>(numberOfOperations);
    // Execute one query to make sure everything has been warmed up.
    executeWarmup(server);

    for (int i = 0; i < numberOfOperations; i++) {
      results.add(executeSingleUseQuery(server));
    }
    return results;
  }

  private void executeWarmup(final BenchmarkState server) {
    for (int i = 0; i < WARMUP_REQUEST_COUNT; i++) {
      executeSingleUseQuery(server);
    }
  }

  private Duration executeSingleUseQuery(final BenchmarkState server) {
    Stopwatch watch = Stopwatch.createStarted();

    try (ResultSet rs = server.client.singleUse().executeQuery(getRandomisedReadStatement())) {
      while (rs.next()) {
        assertEquals(1, rs.getColumnCount());
        assertNotNull(rs.getValue(0));
      }
    } catch (Throwable t) {
      // ignore exception
      System.out.println("Got exception = " + t);
    }
    return watch.elapsed();
  }

  static Statement getRandomisedReadStatement() {
    int randomKey = ThreadLocalRandom.current().nextInt(TOTAL_RECORDS);
    return Statement.newBuilder(SELECT_QUERY).bind(ID_COLUMN_NAME).to(randomKey).build();
  }

  void collectResultsAndPrint(
      ListeningScheduledExecutorService service,
      List<ListenableFuture<List<Duration>>> results,
      int numOperationsPerThread)
      throws Exception {
    final List<Duration> collectResults =
        collectResults(
            service, results, numOperationsPerThread * PARALLEL_THREADS, Duration.ofMinutes(60));
    printResults(collectResults);
  }
}
