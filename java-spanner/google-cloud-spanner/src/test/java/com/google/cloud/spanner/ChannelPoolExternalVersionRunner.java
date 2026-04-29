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

import com.google.cloud.NoCredentials;
import com.google.cloud.grpc.GcpManagedChannel;
import com.google.cloud.spanner.spi.v1.SpannerInterceptorProvider;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.Value;
import com.google.spanner.v1.BatchCreateSessionsRequest;
import com.google.spanner.v1.BatchCreateSessionsResponse;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.ListSessionsRequest;
import com.google.spanner.v1.ListSessionsResponse;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SpannerGrpc;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.ForwardingServerCall;
import io.grpc.Grpc;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
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
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/** Standalone runner that can be compiled against an older google-cloud-spanner artifact. */
public final class ChannelPoolExternalVersionRunner {
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
      System.getProperty("spanner.channelPoolLoad.operation", "singleUse");
  private static final boolean DISABLE_GRPC_GCP_AFFINITY =
      Boolean.getBoolean("spanner.channelPoolLoad.disableGrpcGcpAffinity");
  private static final boolean GAX_FIRST = Boolean.getBoolean("spanner.channelPoolLoad.gaxFirst");
  private static final String WORKLOAD_SHAPE =
      System.getProperty("spanner.channelPoolLoad.workloadShape", "spikeThenStable");
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

  private static final Statement SELECT1 = Statement.of("SELECT 1");
  private static final ResultSetMetadata METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("c")
                          .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                          .build())
                  .build())
          .build();
  private static final PartialResultSet SELECT1_RESULT =
      PartialResultSet.newBuilder()
          .setMetadata(METADATA)
          .addValues(Value.newBuilder().setStringValue("1").build())
          .build();

  private ChannelPoolExternalVersionRunner() {}

  public static void main(String[] args) throws Exception {
    List<LoadResult> grpcGcpResults = new ArrayList<>();
    List<LoadResult> gaxResults = new ArrayList<>();
    for (int pair = 0; pair < MEASUREMENT_PAIRS; pair++) {
      boolean pairGaxFirst = pair % 2 == 0 ? GAX_FIRST : !GAX_FIRST;
      LoadPair loadPair = runLoadPair(pairGaxFirst);
      System.out.printf(
          "%nExternalPairResult{pair=%d, included=%s, gaxFirst=%s}%n%s%n%s%n",
          pair, !DISCARD_FIRST_PAIR || pair > 0, pairGaxFirst, loadPair.grpcGcp, loadPair.gax);
      if (!DISCARD_FIRST_PAIR || pair > 0) {
        grpcGcpResults.add(loadPair.grpcGcp);
        gaxResults.add(loadPair.gax);
      }
    }
    System.out.printf(
        "%n%s%n%s%n",
        AggregateResult.of("grpc-gcp", grpcGcpResults), AggregateResult.of("gax", gaxResults));
  }

  private static LoadPair runLoadPair(boolean gaxFirst) throws Exception {
    LoadResult first = gaxFirst ? runLoad("gax", false) : runLoad("grpc-gcp", true);
    LoadResult second = gaxFirst ? runLoad("grpc-gcp", true) : runLoad("gax", false);
    return gaxFirst ? new LoadPair(second, first) : new LoadPair(first, second);
  }

  private static LoadResult runLoad(String name, boolean grpcGcp) throws Exception {
    ChannelStats stats = new ChannelStats();
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(NUM_CHANNELS * 2);
    Server server =
        NettyServerBuilder.forAddress(new InetSocketAddress("localhost", 0))
            .maxConcurrentCallsPerConnection(MAX_CONCURRENT_STREAMS_PER_CONNECTION)
            .addService(new SimpleSpannerService(scheduler))
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
      if (!grpcGcp) {
        builder.disableGrpcGcpExtension();
      } else if (DISABLE_GRPC_GCP_AFFINITY) {
        builder.setInterceptorProvider(
            SpannerInterceptorProvider.createDefault().with(new DisableGrpcGcpAffinity()));
      }
      try (Spanner spanner = builder.build().getService()) {
        DatabaseClient client = spanner.getDatabaseClient(DatabaseId.of("p", "i", "d"));
        Snapshot setupSnapshot = stats.snapshot();
        if (WARMUP_QUERIES > 0) {
          stats.reset(WARMUP_QUERIES);
          runConcurrentQueries(client, stats, WARMUP_QUERIES, new LatencyRecorder(WARMUP_QUERIES));
        }
        if ("spikeThenStable".equals(WORKLOAD_SHAPE)) {
          PhaseResult spike = runMeasuredPhase("spike", client, stats, SPIKE_QUERIES, 1);
          PhaseResult stable =
              runMeasuredPhase("stable", client, stats, STABLE_CONCURRENCY, STABLE_ROUNDS);
          return LoadResult.forPhases(
              name, spike.elapsedMillis + stable.elapsedMillis, setupSnapshot, spike, stable);
        }
        PhaseResult burst = runMeasuredPhase("burst", client, stats, CONCURRENT_QUERIES, 1);
        return LoadResult.forBurst(name, burst.elapsedMillis, setupSnapshot, burst);
      }
    } finally {
      server.shutdownNow();
      server.awaitTermination();
      scheduler.shutdownNow();
    }
  }

  private static PhaseResult runMeasuredPhase(
      String name, DatabaseClient client, ChannelStats stats, int concurrency, int rounds)
      throws Exception {
    int expectedQueries = concurrency * rounds;
    stats.reset(expectedQueries);
    LatencyRecorder recorder = new LatencyRecorder(expectedQueries);
    long elapsedMillis = 0L;
    for (int round = 0; round < rounds; round++) {
      elapsedMillis += runConcurrentQueries(client, stats, concurrency, recorder);
    }
    return new PhaseResult(name, elapsedMillis, recorder.summary(elapsedMillis), stats.snapshot());
  }

  private static long runConcurrentQueries(
      DatabaseClient client, ChannelStats stats, int queries, LatencyRecorder recorder)
      throws Exception {
    ExecutorService executor = Executors.newFixedThreadPool(queries);
    CountDownLatch ready = new CountDownLatch(queries);
    CountDownLatch start = new CountDownLatch(1);
    List<Future<?>> futures = new ArrayList<>(queries);
    long startNanos;
    try {
      for (int i = 0; i < queries; i++) {
        futures.add(
            executor.submit(
                () -> {
                  ready.countDown();
                  start.await();
                  long queryStartNanos = System.nanoTime();
                  runQuery(client);
                  recorder.record(System.nanoTime() - queryStartNanos);
                  return null;
                }));
      }
      ready.await(30, TimeUnit.SECONDS);
      startNanos = System.nanoTime();
      stats.startTiming(startNanos);
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

  private static void runQuery(DatabaseClient client) {
    switch (OPERATION) {
      case "singleUse":
        try (ResultSet resultSet = client.singleUse().executeQuery(SELECT1)) {
          drain(resultSet);
        }
        return;
      case "singleUseReadOnlyTransaction":
        try (ReadOnlyTransaction transaction = client.singleUseReadOnlyTransaction();
            ResultSet resultSet = transaction.executeQuery(SELECT1)) {
          drain(resultSet);
        }
        return;
      case "readOnlyTransaction":
        try (ReadOnlyTransaction transaction = client.readOnlyTransaction();
            ResultSet resultSet = transaction.executeQuery(SELECT1)) {
          drain(resultSet);
        }
        return;
      default:
        throw new IllegalArgumentException("Unknown operation: " + OPERATION);
    }
  }

  private static void drain(ResultSet resultSet) {
    while (resultSet.next()) {}
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

  private static final class DisableGrpcGcpAffinity implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
      return next.newCall(
          method, callOptions.withOption(GcpManagedChannel.DISABLE_AFFINITY_KEY, true));
    }
  }

  private static final class SimpleSpannerService extends SpannerGrpc.SpannerImplBase {
    private final ScheduledExecutorService scheduler;
    private final AtomicInteger sessionId = new AtomicInteger();
    private final AtomicInteger transactionId = new AtomicInteger();

    private SimpleSpannerService(ScheduledExecutorService scheduler) {
      this.scheduler = scheduler;
    }

    @Override
    public void createSession(
        CreateSessionRequest request, StreamObserver<Session> responseObserver) {
      responseObserver.onNext(newSession(request.getDatabase()));
      responseObserver.onCompleted();
    }

    @Override
    public void batchCreateSessions(
        BatchCreateSessionsRequest request,
        StreamObserver<BatchCreateSessionsResponse> responseObserver) {
      BatchCreateSessionsResponse.Builder response = BatchCreateSessionsResponse.newBuilder();
      for (int i = 0; i < request.getSessionCount(); i++) {
        response.addSession(newSession(request.getDatabase()));
      }
      responseObserver.onNext(response.build());
      responseObserver.onCompleted();
    }

    @Override
    public void getSession(GetSessionRequest request, StreamObserver<Session> responseObserver) {
      responseObserver.onNext(
          Session.newBuilder().setName(request.getName()).setMultiplexed(true).build());
      responseObserver.onCompleted();
    }

    @Override
    public void listSessions(
        ListSessionsRequest request, StreamObserver<ListSessionsResponse> responseObserver) {
      responseObserver.onNext(ListSessionsResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void deleteSession(
        DeleteSessionRequest request, StreamObserver<Empty> responseObserver) {
      responseObserver.onNext(Empty.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void beginTransaction(
        BeginTransactionRequest request, StreamObserver<Transaction> responseObserver) {
      responseObserver.onNext(
          Transaction.newBuilder()
              .setId(ByteString.copyFromUtf8("t" + transactionId.incrementAndGet()))
              .build());
      responseObserver.onCompleted();
    }

    @Override
    public void executeStreamingSql(
        ExecuteSqlRequest request, StreamObserver<PartialResultSet> responseObserver) {
      scheduler.schedule(
          () -> {
            responseObserver.onNext(SELECT1_RESULT);
            responseObserver.onCompleted();
          },
          QUERY_LATENCY_MS,
          TimeUnit.MILLISECONDS);
    }

    private Session newSession(String database) {
      return Session.newBuilder()
          .setName(database + "/sessions/s" + sessionId.incrementAndGet())
          .setMultiplexed(true)
          .build();
    }
  }

  private static final class ChannelStats implements ServerInterceptor {
    static final String EXECUTE_STREAMING_SQL = "google.spanner.v1.Spanner/ExecuteStreamingSql";
    private static final Metadata.Key<String> REQUEST_ID_HEADER_KEY =
        Metadata.Key.of("x-goog-spanner-request-id", Metadata.ASCII_STRING_MARSHALLER);

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
      increment(callsByTransport, transport);
      increment(callsByRequestIdChannel, requestIdChannel(headers));
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
      String requestId = headers.get(REQUEST_ID_HEADER_KEY);
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
      Map<String, Integer> copy = new LinkedHashMap<>();
      source.forEach((key, value) -> copy.put(key, value.get()));
      return copy;
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

  private static final class PhaseResult {
    private final String phaseName;
    private final long elapsedMillis;
    private final LatencySummary latencySummary;
    private final Snapshot snapshot;

    private PhaseResult(
        String phaseName, long elapsedMillis, LatencySummary latencySummary, Snapshot snapshot) {
      this.phaseName = phaseName;
      this.elapsedMillis = elapsedMillis;
      this.latencySummary = latencySummary;
      this.snapshot = snapshot;
    }

    int totalExecuteStreamingSqlCalls() {
      return snapshot.callsByTransport.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public String toString() {
      return "ExternalPhaseResult{"
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

    @Override
    public String toString() {
      return "ExternalLoadResult{"
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
      return "ExternalAggregateResult{"
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
    }

    @Override
    public String toString() {
      return "ExternalPhaseAggregate{"
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
