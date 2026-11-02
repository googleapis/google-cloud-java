/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.grpc;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.awaitility.Awaitility.await;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.grpc.GcpManagedChannel.ChannelAffinityRef;
import com.google.cloud.grpc.GcpManagedChannel.ChannelRef;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpChannelPoolOptions;
import com.google.cloud.grpc.proto.AffinityConfig;
import com.google.cloud.grpc.proto.ApiConfig;
import com.google.cloud.grpc.proto.MethodConfig;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.Session;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.CompressorRegistry;
import io.grpc.ConnectivityState;
import io.grpc.DecompressorRegistry;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.NameResolver.Factory;
import io.grpc.Status;
import io.grpc.protobuf.ProtoUtils;
import io.grpc.stub.ClientCalls;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Dynamic-pool per-channel request-skew tests.
 *
 * <p>Deterministic regressions always run. The load-shaped reproducer is opt-in with {@code
 * -Dhotchannel.load=true}; configure its seeds with {@code -Dhotchannel.seeds=1103,7,42,99,123}.
 */
@RunWith(JUnit4.class)
public final class GcpManagedChannelHotChannelReproducerTest {
  private static final int MIN_SIZE = 2;
  private static final int INITIAL_SIZE = 4;
  private static final int MAX_SIZE = 48;
  private static final int MIN_RPC_PER_CHANNEL = 15;
  private static final int MAX_RPC_PER_CHANNEL = 25;
  private static final int DEFAULT_CALLERS = 300;
  private static final int SESSION_COUNT = 100;
  private static final Duration TEST_SCALE_DOWN_INTERVAL = Duration.ofMillis(120);
  private static final CallOptions.Key<Long> TEST_LATENCY_MILLIS =
      CallOptions.Key.create("hotchannel-test-latency-millis");
  private static final MethodDescriptor<CreateSessionRequest, Session> CREATE_SESSION_METHOD =
      MethodDescriptor.<CreateSessionRequest, Session>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.v1.Spanner/CreateSession")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSessionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Session.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ExecuteSqlRequest, ResultSet> EXECUTE_SQL_METHOD =
      MethodDescriptor.<ExecuteSqlRequest, ResultSet>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.v1.Spanner/ExecuteSql")
          .setRequestMarshaller(ProtoUtils.marshaller(ExecuteSqlRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(ResultSet.getDefaultInstance()))
          .build();
  private static final CallOptions.Key<ChannelAffinityRef> CHANNEL_AFFINITY_REF_KEY =
      GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY;

  @Test
  public void dynamicPoolDoesNotDevelopOneHotChannel() throws Exception {
    assumeTrue("load-shaped reproducer disabled", Boolean.getBoolean("hotchannel.load"));
    Variant variant =
        Variant.valueOf(
            System.getProperty("hotchannel.variant", "REF_6120").toUpperCase(Locale.ROOT));
    LoadShape loadShape =
        LoadShape.valueOf(
            System.getProperty("hotchannel.loadShape", "BURSTY").toUpperCase(Locale.ROOT));
    String[] seeds = System.getProperty("hotchannel.seeds", "1103").split(",");
    boolean observeOnly = Boolean.getBoolean("hotchannel.observeOnly");

    for (String seedValue : seeds) {
      long seed = Long.parseLong(seedValue.trim());
      RunResult result = runScenario(seed, variant, loadShape);
      System.out.println(result.format());
      if (!observeOnly) {
        assertWithMessage("one-hot-channel skew: %s", result.format())
            .that(result.hotToMedian)
            .isLessThan(3.0);
      }
    }
  }

  @Test
  public void warmChannelDoesNotBiasPowerOfTwoTies() throws Exception {
    ScheduledExecutorService responses = Executors.newSingleThreadScheduledExecutor();
    GcpManagedChannel pool = null;
    try {
      pool = fixedPool(new RecordingChannelBuilder(responses, 1), 2, 2, false);
      ChannelRef warm = pool.channelRefs.get(1);
      warm.messageReceived();

      int warmPicks = 0;
      for (int i = 0; i < 200; i++) {
        if (pool.getChannelRef(null) == warm) {
          warmPicks++;
        }
      }

      assertThat(warmPicks).isGreaterThan(60);
      assertThat(warmPicks).isLessThan(140);
    } finally {
      if (pool != null) {
        pool.shutdownNow();
      }
      responses.shutdownNow();
    }
  }

  @Test
  public void selectedCallsReserveLoadBeforeStart() throws Exception {
    ScheduledExecutorService responses = Executors.newSingleThreadScheduledExecutor();
    GcpManagedChannel pool = null;
    try {
      RecordingChannelBuilder delegateBuilder = new RecordingChannelBuilder(responses, 2);
      pool = fixedPool(delegateBuilder, 2, 2, false);
      pool.channelRefs.get(1).messageReceived();

      for (int i = 0; i < 200; i++) {
        ChannelAffinityRef affinityRef = new ChannelAffinityRef();
        pool.newCall(
            EXECUTE_SQL_METHOD,
            CallOptions.DEFAULT.withOption(CHANNEL_AFFINITY_REF_KEY, affinityRef));
      }

      long first = delegateBuilder.stats.get(0).selected.get();
      long second = delegateBuilder.stats.get(1).selected.get();
      assertThat(first).isGreaterThan(60);
      assertThat(second).isGreaterThan(60);
      assertThat(pool.channelRefs.get(0).getActiveStreamsCount()).isEqualTo((int) first);
      assertThat(pool.channelRefs.get(1).getActiveStreamsCount()).isEqualTo((int) second);
    } finally {
      if (pool != null) {
        pool.shutdownNow();
      }
      responses.shutdownNow();
    }
  }

  @Test
  public void affinityReferencesRedistributeAfterDrainingChannelsShutdown() throws Exception {
    ScheduledExecutorService responses = Executors.newSingleThreadScheduledExecutor();
    ExecutorService executor = Executors.newFixedThreadPool(100);
    GcpManagedChannel pool = null;
    try {
      pool = fixedPool(new RecordingChannelBuilder(responses, 3), 2, 4, true);
      List<ChannelAffinityRef> affinityRefs = new ArrayList<>();
      List<Integer> originalIds = new ArrayList<>();
      for (int i = 0; i < 200; i++) {
        int channelId = pool.channelRefs.get(i % 4).getId();
        ChannelAffinityRef affinityRef = new ChannelAffinityRef();
        affinityRef.setChannelIdForTest(channelId);
        affinityRefs.add(affinityRef);
        originalIds.add(channelId);
      }

      invokeScaleDownCheck(pool, 3);
      assertThat(pool.channelRefs).hasSize(2);
      Set<Integer> removedIds = new HashSet<>();
      for (ChannelRef removed : pool.removedChannelRefs) {
        removedIds.add(removed.getId());
      }
      List<ChannelAffinityRef> orphaned = new ArrayList<>();
      for (int i = 0; i < affinityRefs.size(); i++) {
        if (removedIds.contains(originalIds.get(i))) {
          orphaned.add(affinityRefs.get(i));
        }
      }
      assertThat(orphaned).hasSize(100);
      for (int i = 0; i < affinityRefs.size(); i++) {
        if (removedIds.contains(originalIds.get(i))) {
          assertThat(pool.getChannelRefByAffinityRef(affinityRefs.get(i)).getId())
              .isEqualTo(originalIds.get(i));
        }
      }
      for (ChannelRef removed : pool.removedChannelRefs) {
        removed.getChannel().shutdownNow();
      }

      ChannelRef first = pool.channelRefs.get(0);
      ChannelRef second = pool.channelRefs.get(1);
      second.messageReceived();
      CountDownLatch start = new CountDownLatch(1);
      List<Future<ChannelRef>> resolutions = new ArrayList<>();
      GcpManagedChannel resolvingPool = pool;
      for (ChannelAffinityRef affinityRef : orphaned) {
        resolutions.add(
            executor.submit(
                () -> {
                  start.await();
                  return resolvingPool.getChannelRefByAffinityRef(affinityRef);
                }));
      }
      start.countDown();
      int firstPicks = 0;
      int secondPicks = 0;
      for (Future<ChannelRef> resolution : resolutions) {
        ChannelRef resolved = resolution.get(5, TimeUnit.SECONDS);
        if (resolved == first) {
          firstPicks++;
        } else if (resolved == second) {
          secondPicks++;
        }
      }
      assertThat(firstPicks).isGreaterThan(25);
      assertThat(secondPicks).isGreaterThan(25);
    } finally {
      if (pool != null) {
        pool.shutdownNow();
      }
      executor.shutdownNow();
      responses.shutdownNow();
    }
  }

  @Test
  public void scaleDownMarksAtMostTwoOfFortyEightLiveReferencesPerCheck() throws Exception {
    ScheduledExecutorService responses = Executors.newSingleThreadScheduledExecutor();
    GcpManagedChannel pool = null;
    try {
      pool = fixedPool(new RecordingChannelBuilder(responses, 4), 2, 48, true);
      List<ChannelAffinityRef> handles = new ArrayList<>();
      for (ChannelRef channelRef : pool.channelRefs) {
        channelRef.activeStreamsCountIncr();
        ChannelAffinityRef handle = new ChannelAffinityRef();
        handle.setChannelIdForTest(channelRef.getId());
        handles.add(handle);
      }
      for (ChannelRef channelRef : pool.channelRefs) {
        channelRef.activeStreamsCountDecr(System.nanoTime(), Status.OK, false);
      }

      invokeScaleDownCheck(pool, 2);
      assertThat(pool.channelRefs).hasSize(48);
      invokeScaleDownCheck(pool, 1);
      assertThat(pool.channelRefs).hasSize(46);
      assertThat(pool.removedChannelRefs).hasSize(2);
      for (ChannelRef removed : pool.removedChannelRefs) {
        ChannelRef resolved = pool.getChannelRefByAffinityRef(handles.get(removed.getId()));
        assertThat(resolved).isSameInstanceAs(removed);
        assertThat(resolved.isActive()).isFalse();
        assertThat(resolved.getChannel().isShutdown()).isFalse();
      }

      invokeScaleDownCheck(pool, 3);
      assertThat(pool.channelRefs).hasSize(44);
      assertThat(pool.removedChannelRefs).hasSize(4);
    } finally {
      if (pool != null) {
        pool.shutdownNow();
      }
      responses.shutdownNow();
    }
  }

  private static GcpManagedChannel fixedPool(
      RecordingChannelBuilder delegateBuilder, int minimum, int initial, boolean dynamic) {
    GcpChannelPoolOptions.Builder options =
        GcpChannelPoolOptions.newBuilder()
            .setMinSize(minimum)
            .setInitSize(initial)
            .setMaxSize(initial);
    if (dynamic) {
      options
          .setDynamicScaling(10, 20, Duration.ofMinutes(1))
          .setScaleDownConsecutiveLowLoadChecks(3)
          .setMaxScaleDownChannels(2);
    }
    return (GcpManagedChannel)
        GcpManagedChannelBuilder.forDelegateBuilder(delegateBuilder)
            .withOptions(
                GcpManagedChannelOptions.newBuilder()
                    .withChannelPoolOptions(options.build())
                    .build())
            .build();
  }

  private static void invokeScaleDownCheck(GcpManagedChannel pool, int times) {
    for (int i = 0; i < times; i++) {
      pool.checkScaleDown();
    }
  }

  private RunResult runScenario(long seed, Variant variant, LoadShape loadShape) throws Exception {
    int callers = Integer.getInteger("hotchannel.callers", DEFAULT_CALLERS);
    if (callers < 20) {
      throw new IllegalArgumentException("hotchannel.callers must be at least 20");
    }
    boolean staticPool = Boolean.getBoolean("hotchannel.staticPool");
    boolean noScaleDown = Boolean.getBoolean("hotchannel.noScaleDown");
    Duration phaseInterval =
        Duration.ofMillis(
            Long.getLong("hotchannel.scaleDownMillis", TEST_SCALE_DOWN_INTERVAL.toMillis()));
    Duration scaleDownInterval = noScaleDown ? Duration.ofHours(1) : phaseInterval;

    ScheduledExecutorService responses = Executors.newScheduledThreadPool(32);
    ExecutorService callersExecutor = Executors.newFixedThreadPool(callers);
    GcpManagedChannel pool = null;
    try {
      RecordingChannelBuilder delegateBuilder = new RecordingChannelBuilder(responses, seed);
      GcpChannelPoolOptions.Builder poolOptions =
          GcpChannelPoolOptions.newBuilder()
              .setMaxSize(MAX_SIZE)
              .setMinSize(staticPool ? MAX_SIZE : MIN_SIZE)
              .setInitSize(staticPool ? MAX_SIZE : INITIAL_SIZE)
              .setAffinityKeyLifetime(Duration.ofMinutes(10))
              .setCleanupInterval(Duration.ofMinutes(1));
      if (staticPool) {
        poolOptions.disableDynamicScaling();
      } else {
        poolOptions.setDynamicScaling(MIN_RPC_PER_CHANNEL, MAX_RPC_PER_CHANNEL, scaleDownInterval);
        compressBranchSpecificScaleUpTimer(poolOptions);
      }

      pool =
          (GcpManagedChannel)
              GcpManagedChannelBuilder.forDelegateBuilder(delegateBuilder)
                  .withApiConfig(spannerAffinityConfig())
                  .withOptions(
                      GcpManagedChannelOptions.newBuilder()
                          .withChannelPoolOptions(poolOptions.build())
                          .build())
                  .build();

      // Reach the customer-sized pool before creating the session pool. Each caller owns one
      // transaction and fans out five RPCs on its transaction affinity handle.
      runWave(pool, callersExecutor, variant, Collections.emptyList(), seed, callers, 5, 0);

      List<String> sessionNames = createSessionsInBatches(pool);

      if (!staticPool && loadShape == LoadShape.BURSTY) {
        runScaleCycles(pool, callersExecutor, variant, sessionNames, seed, callers, phaseInterval);
      } else if (loadShape == LoadShape.CONSTANT) {
        runConstantLoad(pool, callersExecutor, variant, sessionNames, seed, callers);
      }

      // Final ramp restores a full active pool. Reset delegate counters so prior channel history
      // does not manufacture skew in the measured hold period.
      runWave(pool, callersExecutor, variant, sessionNames, seed + 10_000, callers, 5, 10_000);
      delegateBuilder.resetMeasurements();

      if (variant == Variant.REF_6120 && loadShape == LoadShape.BURSTY) {
        runTransactionsAcrossScaleDown(
            pool,
            callersExecutor,
            delegateBuilder,
            sessionNames,
            seed + 15_000,
            callers,
            phaseInterval);
      }

      int measureWaves = Integer.getInteger("hotchannel.measureWaves", 8);
      for (int wave = 0; wave < measureWaves; wave++) {
        runWave(
            pool,
            callersExecutor,
            variant,
            sessionNames,
            seed + 20_000,
            callers,
            5,
            20_000 + wave * callers);
      }

      Set<Integer> activeIds = new HashSet<>();
      for (ChannelRef channelRef : pool.channelRefs) {
        activeIds.add(channelRef.getId());
      }
      return delegateBuilder.snapshot(
          seed, variant, loadShape, pool.getNumberOfChannels(), activeIds);
    } finally {
      if (pool != null) {
        pool.shutdownNow();
      }
      callersExecutor.shutdownNow();
      responses.shutdownNow();
      callersExecutor.awaitTermination(10, TimeUnit.SECONDS);
      responses.awaitTermination(10, TimeUnit.SECONDS);
    }
  }

  private static void compressBranchSpecificScaleUpTimer(GcpChannelPoolOptions.Builder builder) {
    builder.setScaleUpCooldown(Duration.ofNanos(1));
  }

  private static void runTransactionsAcrossScaleDown(
      GcpManagedChannel pool,
      ExecutorService executor,
      RecordingChannelBuilder delegateBuilder,
      List<String> sessions,
      long seed,
      int callers,
      Duration scaleDownInterval)
      throws Exception {
    List<TransactionContext> transactions = new ArrayList<>(callers);
    for (int transaction = 0; transaction < callers; transaction++) {
      String session = sessions.get(Math.floorMod(mix(seed ^ transaction), sessions.size()));
      transactions.add(new TransactionContext(transaction, session, new ChannelAffinityRef()));
    }

    CountDownLatch firstStart = new CountDownLatch(1);
    List<Future<ListenableFuture<ResultSet>>> firstRpcStarts = new ArrayList<>(callers);
    for (TransactionContext transaction : transactions) {
      firstRpcStarts.add(
          executor.submit(
              () -> {
                firstStart.await();
                CallOptions options =
                    CallOptions.DEFAULT.withOption(
                        CHANNEL_AFFINITY_REF_KEY, transaction.affinityRef);
                if (transaction.id < 20) {
                  options = options.withOption(TEST_LATENCY_MILLIS, 900L);
                }
                return executeSql(pool, options, transaction.session);
              }));
    }
    firstStart.countDown();
    List<ListenableFuture<ResultSet>> firstRpcs = new ArrayList<>(callers);
    for (Future<ListenableFuture<ResultSet>> start : firstRpcStarts) {
      firstRpcs.add(start.get(10, TimeUnit.SECONDS));
    }
    for (int transaction = 20; transaction < callers; transaction++) {
      firstRpcs.get(transaction).get(10, TimeUnit.SECONDS);
    }

    // Twenty slow streams remain while a scaled 120 ms interval stands in for Spanner's three
    // minutes. Mainline removes almost the entire pool in one check. Caller-owned refs still point
    // at those now-inactive channels.
    await()
        .atMost(scaleDownInterval.multipliedBy(5).plusSeconds(1))
        .until(() -> pool.getNumberOfChannels() < MAX_SIZE);

    // Select every remaining call before starting any of them. This exposes the real newCall/start
    // accounting gap: channel selection happens before SimpleGcpClientCall publishes its stream.
    Set<Integer> candidateIds = new HashSet<>();
    for (ChannelRef channelRef : pool.channelRefs) {
      candidateIds.add(channelRef.getId());
    }
    delegateBuilder.resetSelections();
    List<Future<List<ClientCall<ExecuteSqlRequest, ResultSet>>>> prepared =
        new ArrayList<>(callers);
    for (TransactionContext transaction : transactions) {
      prepared.add(
          executor.submit(
              () -> {
                int remainingRpcCount = 1 + Math.floorMod(mix(seed + transaction.id * 17L), 4);
                List<ClientCall<ExecuteSqlRequest, ResultSet>> calls =
                    new ArrayList<>(remainingRpcCount);
                CallOptions options =
                    CallOptions.DEFAULT.withOption(
                        CHANNEL_AFFINITY_REF_KEY, transaction.affinityRef);
                for (int rpc = 0; rpc < remainingRpcCount; rpc++) {
                  calls.add(pool.newCall(EXECUTE_SQL_METHOD, options));
                }
                return calls;
              }));
    }

    List<List<ClientCall<ExecuteSqlRequest, ResultSet>>> preparedCalls = new ArrayList<>(callers);
    for (Future<List<ClientCall<ExecuteSqlRequest, ResultSet>>> calls : prepared) {
      preparedCalls.add(calls.get(10, TimeUnit.SECONDS));
    }
    System.out.println(delegateBuilder.formatSelections(seed, candidateIds));
    CountDownLatch remainingStart = new CountDownLatch(1);
    List<Future<?>> remainingTransactions = new ArrayList<>(callers);
    for (int transaction = 0; transaction < callers; transaction++) {
      TransactionContext context = transactions.get(transaction);
      List<ClientCall<ExecuteSqlRequest, ResultSet>> calls = preparedCalls.get(transaction);
      remainingTransactions.add(
          executor.submit(
              () -> {
                remainingStart.await();
                List<ListenableFuture<ResultSet>> results = new ArrayList<>(calls.size());
                for (ClientCall<ExecuteSqlRequest, ResultSet> call : calls) {
                  results.add(
                      ClientCalls.futureUnaryCall(
                          call,
                          ExecuteSqlRequest.newBuilder()
                              .setSession(context.session)
                              .setSql("SELECT 1")
                              .build()));
                }
                for (ListenableFuture<ResultSet> result : results) {
                  result.get(10, TimeUnit.SECONDS);
                }
                return null;
              }));
    }
    remainingStart.countDown();
    for (Future<?> transaction : remainingTransactions) {
      transaction.get(30, TimeUnit.SECONDS);
    }
    for (int transaction = 0; transaction < 20; transaction++) {
      firstRpcs.get(transaction).get(10, TimeUnit.SECONDS);
    }
  }

  private static ListenableFuture<ResultSet> executeSql(
      GcpManagedChannel pool, CallOptions callOptions, String session) {
    return ClientCalls.futureUnaryCall(
        pool.newCall(EXECUTE_SQL_METHOD, callOptions),
        ExecuteSqlRequest.newBuilder().setSession(session).setSql("SELECT 1").build());
  }

  private static void runScaleCycles(
      GcpManagedChannel pool,
      ExecutorService executor,
      Variant variant,
      List<String> sessions,
      long seed,
      int callers,
      Duration interval)
      throws Exception {
    int[] ramp = {callers / 8, callers / 3, (callers * 2) / 3, callers};
    for (int cycle = 0; cycle < 3; cycle++) {
      for (int waveSize : ramp) {
        runWave(
            pool,
            executor,
            variant,
            sessions,
            seed + cycle * 1_000,
            waveSize,
            0,
            cycle * 10_000 + waveSize);
      }
      for (int hold = 0; hold < 3; hold++) {
        runWave(
            pool,
            executor,
            variant,
            sessions,
            seed + cycle * 1_000,
            callers,
            0,
            cycle * 10_000 + 1_000 + hold * callers);
      }
      int sizeBeforeScaleDown = pool.getNumberOfChannels();
      await()
          .atMost(interval.multipliedBy(5).plusSeconds(1))
          .until(
              () ->
                  pool.getNumberOfChannels() < sizeBeforeScaleDown
                      || pool.getNumberOfChannels() == MIN_SIZE);
    }
  }

  private static void runConstantLoad(
      GcpManagedChannel pool,
      ExecutorService executor,
      Variant variant,
      List<String> sessions,
      long seed,
      int callers)
      throws Exception {
    for (int wave = 0; wave < 20; wave++) {
      runWave(pool, executor, variant, sessions, seed + 5_000, callers, 0, 5_000 + wave * callers);
    }
  }

  private static List<String> createSessionsInBatches(GcpManagedChannel pool) throws Exception {
    List<String> sessions = new ArrayList<>();
    for (int batch = 0; batch < SESSION_COUNT / 10; batch++) {
      List<ListenableFuture<Session>> futures = new ArrayList<>();
      for (int item = 0; item < 10; item++) {
        futures.add(
            ClientCalls.futureUnaryCall(
                pool.newCall(CREATE_SESSION_METHOD, CallOptions.DEFAULT),
                CreateSessionRequest.newBuilder()
                    .setDatabase("projects/p/instances/i/databases/d")
                    .build()));
      }
      for (ListenableFuture<Session> future : futures) {
        sessions.add(future.get(10, TimeUnit.SECONDS).getName());
      }
    }
    return sessions;
  }

  private static void runWave(
      GcpManagedChannel pool,
      ExecutorService executor,
      Variant variant,
      List<String> sessions,
      long seed,
      int transactionCount,
      int fixedRpcCount,
      int transactionOffset)
      throws Exception {
    CountDownLatch start = new CountDownLatch(1);
    List<Future<?>> transactions = new ArrayList<>(transactionCount);
    for (int transaction = 0; transaction < transactionCount; transaction++) {
      final int transactionId = transactionOffset + transaction;
      transactions.add(
          executor.submit(
              () -> {
                start.await();
                int rpcCount =
                    fixedRpcCount > 0
                        ? fixedRpcCount
                        : 1 + Math.floorMod(mix(seed + transactionId), 5);
                ChannelAffinityRef affinityRef = new ChannelAffinityRef();
                String session =
                    sessions.isEmpty()
                        ? "projects/p/instances/i/databases/d/sessions/bootstrap"
                        : sessions.get(Math.floorMod(mix(seed ^ transactionId), sessions.size()));
                List<ListenableFuture<ResultSet>> calls = new ArrayList<>(rpcCount);
                for (int rpc = 0; rpc < rpcCount; rpc++) {
                  CallOptions callOptions = CallOptions.DEFAULT;
                  if (variant == Variant.REF_6120) {
                    callOptions = callOptions.withOption(CHANNEL_AFFINITY_REF_KEY, affinityRef);
                  } else {
                    int route = Math.floorMod(mix(seed + transactionId * 31L), 100);
                    if (route < 9) {
                      callOptions =
                          callOptions.withOption(
                              GcpManagedChannel.AFFINITY_KEY,
                              "projects/p/instances/i/databases/d/sessions/multiplexed");
                    } else if (route >= 29) {
                      callOptions =
                          callOptions.withOption(GcpManagedChannel.DISABLE_AFFINITY_KEY, true);
                    }
                  }
                  calls.add(
                      ClientCalls.futureUnaryCall(
                          pool.newCall(EXECUTE_SQL_METHOD, callOptions),
                          ExecuteSqlRequest.newBuilder()
                              .setSession(session)
                              .setSql("SELECT 1")
                              .build()));
                }
                for (ListenableFuture<ResultSet> call : calls) {
                  call.get(10, TimeUnit.SECONDS);
                }
                return null;
              }));
    }
    start.countDown();
    for (Future<?> transaction : transactions) {
      transaction.get(30, TimeUnit.SECONDS);
    }
  }

  private static ApiConfig spannerAffinityConfig() {
    AffinityConfig bind =
        AffinityConfig.newBuilder()
            .setCommand(AffinityConfig.Command.BIND)
            .setAffinityKey("name")
            .build();
    AffinityConfig bound =
        AffinityConfig.newBuilder()
            .setCommand(AffinityConfig.Command.BOUND)
            .setAffinityKey("session")
            .build();
    return ApiConfig.newBuilder()
        .addMethod(
            MethodConfig.newBuilder()
                .addName(CREATE_SESSION_METHOD.getFullMethodName())
                .setAffinity(bind))
        .addMethod(
            MethodConfig.newBuilder()
                .addName(EXECUTE_SQL_METHOD.getFullMethodName())
                .setAffinity(bound))
        .build();
  }

  private static int mix(long value) {
    value = (value ^ (value >>> 33)) * 0xff51afd7ed558ccdL;
    value = (value ^ (value >>> 33)) * 0xc4ceb9fe1a85ec53L;
    return (int) (value ^ (value >>> 33));
  }

  private enum Variant {
    REF_6120,
    KEY_6117
  }

  private enum LoadShape {
    BURSTY,
    CONSTANT
  }

  private static final class RecordingChannelBuilder
      extends ManagedChannelBuilder<RecordingChannelBuilder> {
    private final ScheduledExecutorService responses;
    private final long seed;
    private final AtomicInteger nextId = new AtomicInteger();
    private final AtomicInteger nextSession = new AtomicInteger();
    private final AtomicLong nextCall = new AtomicLong();
    private final Map<Integer, ChannelStats> stats = new ConcurrentHashMap<>();

    private RecordingChannelBuilder(ScheduledExecutorService responses, long seed) {
      this.responses = responses;
      this.seed = seed;
    }

    @Override
    public ManagedChannel build() {
      int id = nextId.getAndIncrement();
      ChannelStats channelStats = new ChannelStats(id);
      stats.put(id, channelStats);
      return new RecordingManagedChannel(id, channelStats, responses, nextSession, nextCall, seed);
    }

    private void resetMeasurements() {
      for (ChannelStats channelStats : stats.values()) {
        channelStats.completed.set(0);
        channelStats.maxActive.set(channelStats.active.get());
      }
    }

    private void resetSelections() {
      for (ChannelStats channelStats : stats.values()) {
        channelStats.selected.set(0);
      }
    }

    private String formatSelections(long runSeed, Set<Integer> candidateIds) {
      List<ChannelStats> candidates = new ArrayList<>();
      for (int id : candidateIds) {
        candidates.add(stats.get(id));
      }
      candidates.sort(Comparator.comparingInt(candidate -> candidate.id));
      ChannelStats hot =
          Collections.max(
              candidates, Comparator.comparingLong(candidate -> candidate.selected.get()));
      long[] selected =
          candidates.stream().mapToLong(candidate -> candidate.selected.get()).sorted().toArray();
      double median =
          selected.length % 2 == 0
              ? (selected[selected.length / 2 - 1] + selected[selected.length / 2]) / 2.0
              : selected[selected.length / 2];
      StringBuilder distribution = new StringBuilder();
      for (ChannelStats candidate : candidates) {
        if (distribution.length() > 0) {
          distribution.append(',');
        }
        distribution.append(candidate.id).append('=').append(candidate.selected.get());
      }
      return String.format(
          Locale.ROOT,
          "HOTCHANNEL_EARLIEST seed=%d poolAfterDip=%d hotId=%d hotSelected=%d median=%.1f "
              + "hotToMedian=%.3f preparedDistribution=[%s]",
          runSeed,
          candidateIds.size(),
          hot.id,
          hot.selected.get(),
          median,
          hot.selected.get() / median,
          distribution);
    }

    private RunResult snapshot(
        long runSeed,
        Variant variant,
        LoadShape loadShape,
        int activePoolSize,
        Set<Integer> activeIds) {
      List<ChannelStatsSnapshot> snapshots = new ArrayList<>();
      for (int id : activeIds) {
        ChannelStats channelStats = stats.get(id);
        snapshots.add(
            new ChannelStatsSnapshot(
                id, channelStats.completed.get(), channelStats.maxActive.get()));
      }
      snapshots.sort(Comparator.comparingInt(snapshot -> snapshot.id));
      return new RunResult(runSeed, variant, loadShape, activePoolSize, nextId.get(), snapshots);
    }

    @Override
    public RecordingChannelBuilder directExecutor() {
      return this;
    }

    @Override
    public RecordingChannelBuilder executor(Executor executor) {
      return this;
    }

    @Override
    public RecordingChannelBuilder intercept(List<ClientInterceptor> interceptors) {
      return this;
    }

    @Override
    public RecordingChannelBuilder intercept(ClientInterceptor... interceptors) {
      return this;
    }

    @Override
    public RecordingChannelBuilder userAgent(String userAgent) {
      return this;
    }

    @Override
    public RecordingChannelBuilder overrideAuthority(String authority) {
      return this;
    }

    @Override
    public RecordingChannelBuilder nameResolverFactory(Factory resolverFactory) {
      return this;
    }

    @Override
    public RecordingChannelBuilder decompressorRegistry(DecompressorRegistry registry) {
      return this;
    }

    @Override
    public RecordingChannelBuilder compressorRegistry(CompressorRegistry registry) {
      return this;
    }

    @Override
    public RecordingChannelBuilder idleTimeout(long value, TimeUnit unit) {
      return this;
    }
  }

  private static final class RecordingManagedChannel extends ManagedChannel {
    private final int id;
    private final ChannelStats stats;
    private final ScheduledExecutorService responses;
    private final AtomicInteger nextSession;
    private final AtomicLong nextCall;
    private final long seed;
    private final AtomicBoolean shutdown = new AtomicBoolean();

    private RecordingManagedChannel(
        int id,
        ChannelStats stats,
        ScheduledExecutorService responses,
        AtomicInteger nextSession,
        AtomicLong nextCall,
        long seed) {
      this.id = id;
      this.stats = stats;
      this.responses = responses;
      this.nextSession = nextSession;
      this.nextCall = nextCall;
      this.seed = seed;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(
        MethodDescriptor<ReqT, RespT> method, CallOptions callOptions) {
      stats.selected.incrementAndGet();
      return new RecordingClientCall<>(
          id, stats, responses, nextSession, nextCall, seed, method, callOptions);
    }

    @Override
    public ConnectivityState getState(boolean requestConnection) {
      return shutdown.get() ? ConnectivityState.SHUTDOWN : ConnectivityState.READY;
    }

    @Override
    public void notifyWhenStateChanged(ConnectivityState source, Runnable callback) {}

    @Override
    public ManagedChannel shutdown() {
      shutdown.set(true);
      return this;
    }

    @Override
    public boolean isShutdown() {
      return shutdown.get();
    }

    @Override
    public boolean isTerminated() {
      return shutdown.get();
    }

    @Override
    public ManagedChannel shutdownNow() {
      return shutdown();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) {
      return shutdown.get();
    }

    @Override
    public String authority() {
      return "in-process-channel-" + id;
    }

    @Override
    public void enterIdle() {}
  }

  private static final class RecordingClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    private final int channelId;
    private final ChannelStats stats;
    private final ScheduledExecutorService responses;
    private final AtomicInteger nextSession;
    private final AtomicLong nextCall;
    private final long seed;
    private final MethodDescriptor<ReqT, RespT> method;
    private final Long latencyMillisOverride;
    private final AtomicBoolean completed = new AtomicBoolean();
    private Listener<RespT> listener;

    private RecordingClientCall(
        int channelId,
        ChannelStats stats,
        ScheduledExecutorService responses,
        AtomicInteger nextSession,
        AtomicLong nextCall,
        long seed,
        MethodDescriptor<ReqT, RespT> method,
        CallOptions callOptions) {
      this.channelId = channelId;
      this.stats = stats;
      this.responses = responses;
      this.nextSession = nextSession;
      this.nextCall = nextCall;
      this.seed = seed;
      this.method = method;
      this.latencyMillisOverride = callOptions.getOption(TEST_LATENCY_MILLIS);
    }

    @Override
    public void start(Listener<RespT> listener, Metadata headers) {
      this.listener = listener;
      int active = stats.active.incrementAndGet();
      stats.maxActive.accumulateAndGet(active, Math::max);
    }

    @Override
    public void request(int numMessages) {}

    @Override
    public void cancel(String message, Throwable cause) {
      finish(Status.CANCELLED, null);
    }

    @Override
    public void halfClose() {
      long callId = nextCall.getAndIncrement();
      long latencyMillis =
          latencyMillisOverride == null
              ? 20 + Math.floorMod(mix(seed ^ callId), 11)
              : latencyMillisOverride;
      responses.schedule(
          () -> finish(Status.OK, responseForMethod()), latencyMillis, TimeUnit.MILLISECONDS);
    }

    @Override
    public void sendMessage(ReqT message) {}

    @Override
    public boolean isReady() {
      return true;
    }

    @SuppressWarnings("unchecked")
    private RespT responseForMethod() {
      if (method.getFullMethodName().equals(CREATE_SESSION_METHOD.getFullMethodName())) {
        return (RespT)
            Session.newBuilder()
                .setName(
                    "projects/p/instances/i/databases/d/sessions/session-"
                        + nextSession.incrementAndGet())
                .build();
      }
      return (RespT) ResultSet.getDefaultInstance();
    }

    private void finish(Status status, RespT response) {
      if (!completed.compareAndSet(false, true)) {
        return;
      }
      if (response != null) {
        listener.onMessage(response);
      }
      listener.onClose(status, new Metadata());
      if (status.isOk()) {
        stats.completed.incrementAndGet();
      }
      stats.active.decrementAndGet();
    }
  }

  private static final class ChannelStats {
    private final int id;
    private final AtomicLong completed = new AtomicLong();
    private final AtomicLong selected = new AtomicLong();
    private final AtomicInteger active = new AtomicInteger();
    private final AtomicInteger maxActive = new AtomicInteger();

    private ChannelStats(int id) {
      this.id = id;
    }
  }

  private static final class TransactionContext {
    private final int id;
    private final String session;
    private final ChannelAffinityRef affinityRef;

    private TransactionContext(int id, String session, ChannelAffinityRef affinityRef) {
      this.id = id;
      this.session = session;
      this.affinityRef = affinityRef;
    }
  }

  private static final class ChannelStatsSnapshot {
    private final int id;
    private final long completed;
    private final int maxActive;

    private ChannelStatsSnapshot(int id, long completed, int maxActive) {
      this.id = id;
      this.completed = completed;
      this.maxActive = maxActive;
    }
  }

  private static final class RunResult {
    private final long seed;
    private final Variant variant;
    private final LoadShape loadShape;
    private final int activePoolSize;
    private final int createdChannels;
    private final List<ChannelStatsSnapshot> channels;
    private final ChannelStatsSnapshot hot;
    private final double median;
    private final double hotToMedian;

    private RunResult(
        long seed,
        Variant variant,
        LoadShape loadShape,
        int activePoolSize,
        int createdChannels,
        List<ChannelStatsSnapshot> channels) {
      this.seed = seed;
      this.variant = variant;
      this.loadShape = loadShape;
      this.activePoolSize = activePoolSize;
      this.createdChannels = createdChannels;
      this.channels = channels;
      this.hot =
          Collections.max(channels, Comparator.comparingLong(snapshot -> snapshot.completed));
      long[] counts =
          channels.stream().mapToLong(snapshot -> snapshot.completed).sorted().toArray();
      this.median =
          counts.length % 2 == 0
              ? (counts[counts.length / 2 - 1] + counts[counts.length / 2]) / 2.0
              : counts[counts.length / 2];
      this.hotToMedian = hot.completed / median;
    }

    private String format() {
      StringBuilder distribution = new StringBuilder();
      for (ChannelStatsSnapshot channel : channels) {
        if (distribution.length() > 0) {
          distribution.append(',');
        }
        distribution
            .append(channel.id)
            .append('=')
            .append(channel.completed)
            .append('/')
            .append(channel.maxActive);
      }
      return String.format(
          Locale.ROOT,
          "HOTCHANNEL_RESULT seed=%d variant=%s load=%s pool=%d created=%d hotId=%d "
              + "hotOrder=%d hotCalls=%d hotMaxActive=%d median=%.1f hotToMedian=%.3f "
              + "distribution[id=calls/maxActive]=[%s]",
          seed,
          variant,
          loadShape,
          activePoolSize,
          createdChannels,
          hot.id,
          hot.id + 1,
          hot.completed,
          hot.maxActive,
          median,
          hotToMedian,
          distribution);
    }
  }
}
