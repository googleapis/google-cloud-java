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
package com.google.cloud.bigtable.data.v2.internal.channels;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.bigtable.v2.ClientConfiguration;
import com.google.bigtable.v2.FakeSessionGrpc;
import com.google.bigtable.v2.FeatureFlags;
import com.google.bigtable.v2.OpenFakeSessionRequest;
import com.google.bigtable.v2.OpenSessionRequest;
import com.google.bigtable.v2.OpenSessionResponse;
import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.bigtable.v2.SessionClientConfiguration.ChannelPoolConfiguration;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders.ChannelProvider;
import com.google.cloud.bigtable.data.v2.internal.api.InstanceName;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.session.BigtableTimer;
import com.google.cloud.bigtable.data.v2.internal.session.FakeDescriptor;
import com.google.cloud.bigtable.data.v2.internal.session.HashedWheelTimer;
import com.google.cloud.bigtable.data.v2.internal.session.SessionFactory;
import com.google.cloud.bigtable.data.v2.internal.session.SessionImpl;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolInfo;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeSessionListener;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeSessionService;
import com.google.cloud.bigtable.data.v2.internal.session.fake.PeerInfoInterceptor;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager.ListenerHandle;
import com.google.common.collect.ImmutableList;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.NameResolver;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * Regression test guarding against interceptor-accumulation in {@link SwitchingChannelPool}.
 *
 * <p>{@code SwitchingChannelPool#channelBuilderToSupplier} must hand out a fresh {@code
 * ManagedChannelBuilder} for each channel it builds. Reusing a single builder across {@code
 * .build()} calls means anything that mutates the builder between builds (e.g. the Datadog /
 * OpenTelemetry Java agent installing a tracing {@code ClientInterceptor} via a byte-code hook
 * before each build) accumulates on the shared builder; the Nth channel then carries N tracing
 * interceptors and every RPC on it emits N copies of the tracing header.
 *
 * <p>This test builds a real {@link SwitchingChannelPool} against an in-process fake session
 * server, wires a {@link ChannelProvider} whose builder simulates the tracing agent's per-build
 * hook, warms up N channels, and asserts that each channel carries exactly one tracing interceptor
 * — i.e. no accumulation across builds.
 */
@Timeout(30)
class SwitchingChannelPoolBuilderReuseReproTest {

  private static final Metadata.Key<String> TEST_HEADER =
      Metadata.Key.of("x-test-parent-id", Metadata.ASCII_STRING_MARSHALLER);

  private static final int MIN_SERVER_COUNT = 5;

  private ScheduledExecutorService executor;
  private BigtableTimer timer;
  private Server server;
  private final List<Metadata> receivedHeaders = new CopyOnWriteArrayList<>();

  @BeforeEach
  void setUp() throws IOException {
    executor = Executors.newScheduledThreadPool(4);
    timer = new HashedWheelTimer("switching-channel-pool-repro");

    ServerInterceptor headerCapture =
        new ServerInterceptor() {
          @Override
          public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
              ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
            receivedHeaders.add(headers);
            return next.startCall(call, headers);
          }
        };

    server =
        FakeServiceBuilder.create(new FakeSessionService(executor))
            .intercept(new PeerInfoInterceptor())
            .intercept(headerCapture)
            .start();
  }

  @AfterEach
  void tearDown() {
    if (server != null) {
      server.shutdownNow();
    }
    if (timer != null) {
      timer.stop();
    }
    if (executor != null) {
      executor.shutdownNow();
    }
  }

  @Test
  void switchingChannelPoolAccumulatesInterceptorsAcrossWarmUpBuilds() throws Exception {
    AtomicInteger buildCount = new AtomicInteger();

    ChannelProvider provider =
        new ChannelProvider() {
          @Override
          public ManagedChannelBuilder<?> newChannelBuilder() {
            ManagedChannelBuilder<?> real =
                Grpc.newChannelBuilderForAddress(
                    "localhost", server.getPort(), InsecureChannelCredentials.create());
            return new AgentSimulatingChannelBuilder(real, buildCount);
          }

          @Override
          public Optional<ChannelProvider> getFallback() {
            return Optional.empty();
          }

          @Override
          public FeatureFlags updateFeatureFlags(FeatureFlags featureFlags) {
            return featureFlags;
          }

          @Override
          public boolean isSingleEndpoint() {
            // false → SwitchingChannelPool picks ChannelPoolDpImpl, which warms up
            // MinServerCount channels off the shared builder on start().
            return false;
          }
        };

    ClientConfiguration clientConfig =
        ClientConfiguration.newBuilder()
            .setSessionConfiguration(
                SessionClientConfiguration.newBuilder()
                    .setChannelConfiguration(
                        ChannelPoolConfiguration.newBuilder()
                            .setMinServerCount(MIN_SERVER_COUNT)
                            .setMaxServerCount(25)
                            .setPerServerSessionCount(10)))
            .build();
    ClientConfigurationManager configManager = mock(ClientConfigurationManager.class);
    when(configManager.getClientConfiguration()).thenReturn(clientConfig);
    when(configManager.addListener(any(), any())).thenReturn(mock(ListenerHandle.class));

    Metrics metrics = new NoopMetrics();

    SwitchingChannelPool pool =
        new SwitchingChannelPool(provider, configManager, metrics, executor);
    try {
      pool.start();

      // Wait for warm-up to complete — MinServerCount .build() calls on the shared builder.
      long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5);
      while (buildCount.get() < MIN_SERVER_COUNT && System.nanoTime() < deadline) {
        Thread.sleep(10);
      }
      assertEquals(
          MIN_SERVER_COUNT,
          buildCount.get(),
          "warm-up should have built exactly MinServerCount channels off the shared builder");

      // Open one session per warm-up channel so each channel is exercised at least once. The
      // pool's picker distributes each session to a different least-loaded starting channel.
      SessionPoolInfo poolInfo =
          SessionPoolInfo.create(
              ClientInfo.builder()
                  .setAppProfileId("default")
                  .setInstanceName(
                      InstanceName.parse("projects/fake-project/instances/fake-instance"))
                  .build(),
              FakeDescriptor.FAKE_SESSION,
              "repro-pool");
      SessionFactory sessionFactory =
          new SessionFactory(pool, FakeSessionGrpc.getOpenSessionMethod(), CallOptions.DEFAULT);

      List<FakeSessionListener> listeners = new ArrayList<>();
      for (int i = 0; i < MIN_SERVER_COUNT; i++) {
        SessionImpl session =
            new SessionImpl(new NoopMetrics(), poolInfo, i, sessionFactory.createNew(), timer);
        FakeSessionListener listener = new FakeSessionListener();
        listeners.add(listener);
        OpenSessionRequest openReq =
            OpenSessionRequest.newBuilder()
                .setPayload(OpenFakeSessionRequest.getDefaultInstance().toByteString())
                .build();
        session.start(openReq, new Metadata(), listener);
      }

      // Wait for the server to have seen all MIN_SERVER_COUNT stream openings.
      deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5);
      while (receivedHeaders.size() < MIN_SERVER_COUNT && System.nanoTime() < deadline) {
        Thread.sleep(10);
      }
      assertEquals(
          MIN_SERVER_COUNT,
          receivedHeaders.size(),
          "server should have seen one OpenSession per warm-up channel");

      // Sanity: sessions could talk to the server end-to-end.
      for (FakeSessionListener listener : listeners) {
        listener.popUntil(OpenSessionResponse.class);
      }

      List<Integer> perRpcHeaderCounts =
          receivedHeaders.stream()
              .map(h -> ImmutableList.copyOf(h.getAll(TEST_HEADER)).size())
              .sorted()
              .collect(Collectors.toList());

      // Every RPC should carry exactly one x-test-parent-id — one per DD-agent-simulated build
      // hook per channel. Any higher count means channelBuilderToSupplier reused a single
      // ManagedChannelBuilder across .build() calls and let the agent's build-time interceptor
      // accumulate.
      for (int count : perRpcHeaderCounts) {
        assertEquals(
            1,
            count,
            "each channel must carry exactly one tracing interceptor; got per-RPC counts: "
                + perRpcHeaderCounts);
      }
    } finally {
      pool.close();
    }
  }

  /**
   * Wraps a real {@link ManagedChannelBuilder} and, on every {@link #build()} call, appends a fresh
   * header-emitting {@link ClientInterceptor} to the same delegate. Mimics the way tracing agents
   * (Datadog, OpenTelemetry Java agent, etc.) instrument gRPC by installing a tracing interceptor
   * at build time — when the builder is reused, the interceptor list grows.
   */
  private static final class AgentSimulatingChannelBuilder
      extends ManagedChannelBuilder<AgentSimulatingChannelBuilder> {

    private final ManagedChannelBuilder<?> delegate;
    private final AtomicInteger buildCount;

    AgentSimulatingChannelBuilder(ManagedChannelBuilder<?> delegate, AtomicInteger buildCount) {
      this.delegate = delegate;
      this.buildCount = buildCount;
    }

    @Override
    public AgentSimulatingChannelBuilder intercept(ClientInterceptor... interceptors) {
      delegate.intercept(interceptors);
      return this;
    }

    @Override
    public AgentSimulatingChannelBuilder intercept(List<ClientInterceptor> interceptors) {
      delegate.intercept(interceptors);
      return this;
    }

    @Override
    public ManagedChannel build() {
      delegate.intercept(new HeaderAddingInterceptor());
      buildCount.incrementAndGet();
      return delegate.build();
    }

    @Override
    public AgentSimulatingChannelBuilder usePlaintext() {
      delegate.usePlaintext();
      return this;
    }

    @Override
    public AgentSimulatingChannelBuilder useTransportSecurity() {
      delegate.useTransportSecurity();
      return this;
    }

    @Override
    public AgentSimulatingChannelBuilder directExecutor() {
      throw new UnsupportedOperationException();
    }

    @Override
    public AgentSimulatingChannelBuilder executor(Executor executor) {
      throw new UnsupportedOperationException();
    }

    @Override
    public AgentSimulatingChannelBuilder offloadExecutor(Executor executor) {
      throw new UnsupportedOperationException();
    }

    @Override
    public AgentSimulatingChannelBuilder userAgent(String userAgent) {
      throw new UnsupportedOperationException();
    }

    @Override
    public AgentSimulatingChannelBuilder overrideAuthority(String authority) {
      throw new UnsupportedOperationException();
    }

    @Override
    public AgentSimulatingChannelBuilder decompressorRegistry(DecompressorRegistry registry) {
      throw new UnsupportedOperationException();
    }

    @Override
    public AgentSimulatingChannelBuilder compressorRegistry(CompressorRegistry registry) {
      throw new UnsupportedOperationException();
    }

    @Override
    public AgentSimulatingChannelBuilder idleTimeout(long value, TimeUnit unit) {
      throw new UnsupportedOperationException();
    }

    @Override
    public AgentSimulatingChannelBuilder nameResolverFactory(NameResolver.Factory resolverFactory) {
      throw new UnsupportedOperationException();
    }
  }

  private static final class HeaderAddingInterceptor implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
      return new SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
        @Override
        public void start(Listener<RespT> responseListener, Metadata headers) {
          headers.put(TEST_HEADER, "v");
          super.start(responseListener, headers);
        }
      };
    }
  }
}
