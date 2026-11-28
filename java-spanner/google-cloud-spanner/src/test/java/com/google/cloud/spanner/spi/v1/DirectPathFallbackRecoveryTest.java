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

package com.google.cloud.spanner.spi.v1;

import static com.google.cloud.spanner.MockSpannerTestUtil.SELECT1;
import static com.google.cloud.spanner.MockSpannerTestUtil.SELECT1_RESULTSET;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.grpc.fallback.GcpFallbackChannelOptions;
import com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry;
import com.google.cloud.grpc.fallback.GcpFallbackState;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.XGoogSpannerRequestId;
import com.google.common.collect.Range;
import com.google.spanner.v1.SpannerGrpc;
import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ServerInterceptors;
import io.grpc.Status;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * End-to-end client/slot tests for DirectPath fallback slots and per-channel recovery against two
 * local Netty servers representing DirectPath and CloudPath.
 */
@RunWith(JUnit4.class)
public class DirectPathFallbackRecoveryTest {
  private static final class PathRecorder implements ServerInterceptor {
    final CopyOnWriteArrayList<Integer> channelIds = new CopyOnWriteArrayList<>();
    final CopyOnWriteArrayList<Integer> remotePorts = new CopyOnWriteArrayList<>();
    final AtomicBoolean failCalls = new AtomicBoolean(false);
    final AtomicInteger successfulGetSessions = new AtomicInteger(0);

    void clearCalls() {
      channelIds.clear();
      remotePorts.clear();
    }

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
      String method = call.getMethodDescriptor().getFullMethodName();
      boolean fail = failCalls.get();
      if (SpannerGrpc.getGetSessionMethod().getFullMethodName().equals(method)) {
        if (!fail) {
          successfulGetSessions.incrementAndGet();
        }
      } else if (SpannerGrpc.getExecuteStreamingSqlMethod().getFullMethodName().equals(method)
          || SpannerGrpc.getBeginTransactionMethod().getFullMethodName().equals(method)
          || SpannerGrpc.getCommitMethod().getFullMethodName().equals(method)) {
        String requestId = headers.get(XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY);
        assertThat(requestId).isNotNull();
        String[] parts = requestId.split("\\.");
        assertThat(parts.length).isAtLeast(6);
        SocketAddress addr = call.getAttributes().get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR);
        channelIds.add(Integer.parseInt(parts[3]));
        remotePorts.add(
            addr instanceof InetSocketAddress ? ((InetSocketAddress) addr).getPort() : -1);
      }
      if (fail) {
        call.close(Status.UNAVAILABLE.withDescription("Simulated path outage"), new Metadata());
        return new ServerCall.Listener<ReqT>() {};
      }
      return next.startCall(call, headers);
    }
  }

  private PathRecorder directPathRecorder;
  private PathRecorder cloudPathRecorder;
  private Server directPathServer;
  private Server cloudPathServer;
  private Spanner spanner;
  private final InMemoryMetricReader metricReader = InMemoryMetricReader.create();
  private final OpenTelemetry fallbackOpenTelemetry =
      OpenTelemetrySdk.builder()
          .setMeterProvider(SdkMeterProvider.builder().registerMetricReader(metricReader).build())
          .build();

  @Before
  public void setUp() throws Exception {
    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public boolean isEnableGcpFallbackRecovery() {
            return true;
          }
        });
    MockSpannerServiceImpl mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D);
    mockSpanner.putStatementResult(StatementResult.query(SELECT1, SELECT1_RESULTSET));
    directPathRecorder = new PathRecorder();
    cloudPathRecorder = new PathRecorder();
    directPathServer =
        NettyServerBuilder.forAddress(new InetSocketAddress("localhost", 0))
            .addService(ServerInterceptors.intercept(mockSpanner, directPathRecorder))
            .build()
            .start();
    cloudPathServer =
        NettyServerBuilder.forAddress(new InetSocketAddress("localhost", 0))
            .addService(ServerInterceptors.intercept(mockSpanner, cloudPathRecorder))
            .build()
            .start();
  }

  @After
  public void tearDown() throws Exception {
    try {
      if (spanner != null) {
        spanner.close();
        spanner = null;
      }
    } finally {
      try {
        for (Server server : new Server[] {directPathServer, cloudPathServer}) {
          if (server != null) {
            server.shutdownNow();
            server.awaitTermination(5, TimeUnit.SECONDS);
          }
        }
      } finally {
        SpannerOptions.useDefaultEnvironment();
      }
    }
  }

  private DatabaseClient createClient(
      int numChannels,
      Duration probeInterval,
      int minProbeSuccesses,
      Duration minProbeSuccessDuration,
      @Nullable Function<GcpFallbackProber, Function<Channel, String>> probeWrapper) {
    return createClient(
        numChannels,
        /* enableDynamicChannelPool= */ false,
        probeInterval,
        minProbeSuccesses,
        minProbeSuccessDuration,
        probeWrapper);
  }

  private DatabaseClient createClient(
      int numChannels,
      boolean enableDynamicChannelPool,
      Duration probeInterval,
      int minProbeSuccesses,
      Duration minProbeSuccessDuration,
      @Nullable Function<GcpFallbackProber, Function<Channel, String>> probeWrapper) {
    final String dpEndpoint = "localhost:" + directPathServer.getPort();
    final String cpEndpoint = "localhost:" + cloudPathServer.getPort();
    SpannerOptions.Builder optionsBuilder =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setHost("http://" + dpEndpoint)
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setEnableDirectAccess(true)
            .setNumChannels(numChannels)
            .enableGrpcGcpExtension()
            .setCredentials(NoCredentials.getInstance());
    if (enableDynamicChannelPool) {
      optionsBuilder.enableDynamicChannelPool();
    } else {
      optionsBuilder.disableDynamicChannelPool();
    }
    spanner =
        optionsBuilder
            .setServiceRpcFactory(
                spannerOptions ->
                    new GapicSpannerRpc(spannerOptions) {
                      @Override
                      InstantiatingGrpcChannelProvider.Builder createBaseChannelProviderBuilder(
                          SpannerOptions opts,
                          HeaderProvider headerProvider,
                          boolean isEnableDirectAccess) {
                        return super.createBaseChannelProviderBuilder(
                                opts, headerProvider, isEnableDirectAccess)
                            .setEndpoint(isEnableDirectAccess ? dpEndpoint : cpEndpoint);
                      }

                      @Override
                      OpenTelemetry getFallbackOpenTelemetry(SpannerOptions opts) {
                        return fallbackOpenTelemetry;
                      }

                      @Override
                      GcpFallbackChannelOptions createFallbackChannelOptions(
                          GcpFallbackOpenTelemetry fallbackTelemetry,
                          int minFailedCalls,
                          @Nullable GcpFallbackState fallbackState) {
                        // Local Netty test servers run plaintext rather than ALTS.
                        GcpFallbackProber prober =
                            getFallbackProber().withDirectPathPredicate(attributes -> true);
                        return GcpFallbackChannelOptions.newBuilder()
                            .setSharedState(fallbackState)
                            .setMinFailedCalls(minFailedCalls)
                            .setPeriod(Duration.ofMillis(80))
                            .setGcpFallbackOpenTelemetry(fallbackTelemetry)
                            .setPrimaryProbingFunction(
                                probeWrapper != null ? probeWrapper.apply(prober) : prober)
                            .setPrimaryProbingInterval(probeInterval)
                            .setMinPrimaryProbeSuccessCount(minProbeSuccesses)
                            .setMinPrimaryProbeSuccessDuration(minProbeSuccessDuration)
                            .setEnableRecovery(true)
                            .build();
                      }
                    })
            .build()
            .getService();
    return spanner.getDatabaseClient(DatabaseId.of("test-project", "test-instance", "test-db"));
  }

  private static void executeSingleUseSelect1(DatabaseClient client) {
    try (ResultSet rs = client.singleUse().executeQuery(SELECT1)) {
      assertTrue(rs.next());
      assertEquals(1L, rs.getLong(0));
    }
  }

  private void waitUntilQueriesMatch(
      String description,
      DatabaseClient client,
      int queryCount,
      boolean ignoreErrors,
      BooleanSupplier condition)
      throws InterruptedException {
    long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
    while (System.nanoTime() < deadline) {
      directPathRecorder.clearCalls();
      cloudPathRecorder.clearCalls();
      for (int i = 0; i < queryCount; i++) {
        try {
          executeSingleUseSelect1(client);
        } catch (SpannerException e) {
          if (!ignoreErrors) {
            throw e;
          }
        }
      }
      if (condition.getAsBoolean()) {
        return;
      }
      Thread.sleep(20L);
    }
    assertTrue("Timed out waiting for: " + description, condition.getAsBoolean());
  }

  private void waitUntilAllTrafficOnPath(
      String description,
      DatabaseClient client,
      PathRecorder active,
      PathRecorder inactive,
      int numChannels,
      boolean ignoreErrors)
      throws InterruptedException {
    waitUntilQueriesMatch(
        description,
        client,
        12,
        ignoreErrors,
        () ->
            active.channelIds.size() == 12
                && new HashSet<>(active.channelIds).size() == numChannels
                && inactive.channelIds.isEmpty());
  }

  private void triggerFallbackAndWait(DatabaseClient client) throws InterruptedException {
    directPathRecorder.failCalls.set(true);
    waitUntilQueriesMatch(
        "pool-wide fallback to CloudPath",
        client,
        1,
        true,
        () -> !cloudPathRecorder.channelIds.isEmpty());
  }

  private void assertChannelInvariantsOnPath(
      DatabaseClient client, PathRecorder active, PathRecorder inactive, int numChannels) {
    active.clearCalls();
    inactive.clearCalls();
    for (int i = 0; i < 16; i++) {
      executeSingleUseSelect1(client);
    }
    assertTrue(inactive.channelIds.isEmpty());
    Set<Integer> channelIds = new HashSet<>(active.channelIds);
    assertThat(channelIds.size()).isGreaterThan(1);
    channelIds.forEach(id -> assertThat(id).isIn(Range.closed(1, numChannels)));

    active.clearCalls();
    client
        .readWriteTransaction()
        .run(
            tx -> {
              for (int i = 0; i < 2; i++) {
                try (ResultSet rs = tx.executeQuery(SELECT1)) {
                  assertTrue(rs.next());
                  assertEquals(1L, rs.getLong(0));
                }
              }
              return null;
            });
    assertThat(active.channelIds.size()).isAtLeast(3);
    Set<Integer> txnChannelIds = new HashSet<>(active.channelIds);
    assertThat(txnChannelIds).hasSize(1);
    assertThat(txnChannelIds.iterator().next()).isIn(Range.closed(1, numChannels));
    assertThat(new HashSet<>(active.remotePorts)).hasSize(1);
  }

  @Test
  public void transactionAffinityAndRequestIdChannelIdsPreservedBeforeAndAfterFallback()
      throws Exception {
    int numChannels = 4;
    DatabaseClient client =
        createClient(numChannels, Duration.ofMinutes(5), 10, Duration.ZERO, null);
    executeSingleUseSelect1(client);

    assertChannelInvariantsOnPath(client, directPathRecorder, cloudPathRecorder, numChannels);

    // An in-flight RW transaction spanning a live failover keeps the same slot channel ID.
    directPathRecorder.clearCalls();
    cloudPathRecorder.clearCalls();
    AtomicReference<Set<Integer>> directPathTxnChannelIds = new AtomicReference<>();
    client
        .readWriteTransaction()
        .run(
            tx -> {
              try (ResultSet rs = tx.executeQuery(SELECT1)) {
                assertTrue(rs.next());
                assertEquals(1L, rs.getLong(0));
              }
              directPathTxnChannelIds.set(new HashSet<>(directPathRecorder.channelIds));
              // Run single-use failover traffic on a separate thread to avoid the thread-local
              // nested-transaction guard while this RW transaction stays open.
              CompletableFuture.runAsync(
                      () -> {
                        try {
                          triggerFallbackAndWait(client);
                        } catch (InterruptedException e) {
                          Thread.currentThread().interrupt();
                          throw new RuntimeException(e);
                        }
                      })
                  .join();
              cloudPathRecorder.clearCalls();
              try (ResultSet rs = tx.executeQuery(SELECT1)) {
                assertTrue(rs.next());
                assertEquals(1L, rs.getLong(0));
              }
              return null;
            });
    assertThat(directPathTxnChannelIds.get()).hasSize(1);
    assertThat(cloudPathRecorder.channelIds.size()).isAtLeast(2);
    assertThat(new HashSet<>(cloudPathRecorder.channelIds))
        .containsExactlyElementsIn(directPathTxnChannelIds.get());

    assertChannelInvariantsOnPath(client, cloudPathRecorder, directPathRecorder, numChannels);
  }

  @Test
  public void dcpEnabledFallbackAndRecoveryWithGetSessionProbe() throws Exception {
    int numChannels = 2;
    DatabaseClient client =
        createClient(
            numChannels,
            /* enableDynamicChannelPool= */ true,
            Duration.ofMillis(50),
            2,
            Duration.ofMillis(50),
            null);

    executeSingleUseSelect1(client);
    assertThat(directPathRecorder.channelIds).isNotEmpty();
    assertThat(cloudPathRecorder.channelIds).isEmpty();

    triggerFallbackAndWait(client);
    directPathRecorder.failCalls.set(false);
    waitUntilQueriesMatch(
        "DCP-enabled slots recover to DirectPath via GetSession probes",
        client,
        12,
        false,
        () -> directPathRecorder.channelIds.size() == 12 && cloudPathRecorder.channelIds.isEmpty());
    assertThat(directPathRecorder.successfulGetSessions.get()).isAtLeast(numChannels * 2);
  }

  @Test
  public void simpleFallbackAndRecoveryWithGetSessionProbe() throws Exception {
    int numChannels = 2;
    DatabaseClient client =
        createClient(numChannels, Duration.ofMillis(50), 2, Duration.ofMillis(50), null);

    executeSingleUseSelect1(client);
    assertThat(directPathRecorder.channelIds).isNotEmpty();
    assertThat(cloudPathRecorder.channelIds).isEmpty();

    triggerFallbackAndWait(client);
    directPathRecorder.failCalls.set(false);
    waitUntilAllTrafficOnPath(
        "all slots recover to DirectPath via GetSession probes",
        client,
        directPathRecorder,
        cloudPathRecorder,
        numChannels,
        false);
    // Every slot needs two consecutive passing probes to recover.
    assertThat(directPathRecorder.successfulGetSessions.get()).isAtLeast(numChannels * 2);

    // eef.probe_result must stay unexported until its Monarch definition is in production.
    List<String> metricNames =
        metricReader.collectAllMetrics().stream()
            .map(MetricData::getName)
            .collect(Collectors.toList());
    assertThat(metricNames).contains("eef.fallback_count");
    assertThat(metricNames.stream().noneMatch(name -> name.contains("probe_result"))).isTrue();
  }

  @Test
  public void staggeredPartialRecoveryAndReFallback() throws Exception {
    AtomicReference<Channel> firstSlot = new AtomicReference<>();
    AtomicBoolean releaseSecondSlot = new AtomicBoolean(false);
    DatabaseClient client =
        createClient(
            2,
            Duration.ofMillis(40),
            2,
            Duration.ZERO,
            prober ->
                channel -> {
                  firstSlot.compareAndSet(null, channel);
                  if (!channel.equals(firstSlot.get()) && !releaseSecondSlot.get()) {
                    return "HELD_FOR_TEST";
                  }
                  return prober.apply(channel);
                });

    executeSingleUseSelect1(client);
    triggerFallbackAndWait(client);
    directPathRecorder.failCalls.set(false);

    // Slot 0 recovers to DirectPath while slot 1 stays held on CloudPath.
    waitUntilQueriesMatch(
        "partial recovery (slot 0 on DirectPath, slot 1 on CloudPath)",
        client,
        10,
        false,
        () -> !directPathRecorder.channelIds.isEmpty() && !cloudPathRecorder.channelIds.isEmpty());

    // DirectPath fails again during partial recovery -> recovered slot 0 re-enters fallback.
    directPathRecorder.failCalls.set(true);
    waitUntilAllTrafficOnPath(
        "recovered slot re-enters fallback on DirectPath failure during partial recovery",
        client,
        cloudPathRecorder,
        directPathRecorder,
        2,
        true);

    // Restore DirectPath and release slot 1 -> both slots recover to DirectPath.
    directPathRecorder.failCalls.set(false);
    releaseSecondSlot.set(true);
    waitUntilAllTrafficOnPath(
        "both slots complete staggered recovery to DirectPath",
        client,
        directPathRecorder,
        cloudPathRecorder,
        2,
        false);
  }
}
