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
package com.google.cloud.bigtable.data.v2.internal.util;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.extensions.proto.ProtoTruth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.ClientConfiguration;
import com.google.bigtable.v2.FeatureFlags;
import com.google.bigtable.v2.GetClientConfigurationRequest;
import com.google.bigtable.v2.LoadBalancingOptions;
import com.google.bigtable.v2.LoadBalancingOptions.LeastInFlight;
import com.google.bigtable.v2.LoadBalancingOptions.PeakEwma;
import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.bigtable.v2.SessionClientConfiguration.SessionPoolConfiguration;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders.ForwardingChannelProvider;
import com.google.cloud.bigtable.data.v2.internal.api.InstanceName;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager.ConfigListener;
import com.google.protobuf.TextFormat;
import com.google.protobuf.util.Durations;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClientConfigurationManagerTest {
  private static final FeatureFlags FEATURE_FLAGS = FeatureFlags.getDefaultInstance();

  private static final ClientInfo CLIENT_INFO =
      ClientInfo.builder()
          .setClientName("fake-client")
          .setInstanceName(InstanceName.of("fake-project", "fake-instance"))
          .setAppProfileId("default")
          .build();

  private Server server;
  private FakeConfigService service;
  private ChannelProviders.ChannelProvider channelProvider;
  @Mock private ScheduledExecutorService mockExecutor;
  private final OutstandingRpcCounter outstandingRpcCounter = new OutstandingRpcCounter();
  private ClientConfigurationManager manager;
  private final NoopMetrics.NoopDebugTracer noopDebugTracer = NoopMetrics.NoopDebugTracer.INSTANCE;

  @BeforeEach
  void setUp() throws IOException {
    service = new FakeConfigService();

    server = FakeServiceBuilder.create(service).start();

    channelProvider =
        new ForwardingChannelProvider(
            new ChannelProviders.EmulatorChannelProvider("localhost", server.getPort())) {
          @Override
          public ManagedChannelBuilder<?> newChannelBuilder() {
            return super.newChannelBuilder().intercept(outstandingRpcCounter);
          }
        };

    manager =
        new ClientConfigurationManager(
            FEATURE_FLAGS, CLIENT_INFO, channelProvider, noopDebugTracer, mockExecutor);
  }

  @AfterEach
  void tearDown() {
    manager.close();
    server.shutdown();
  }

  @Test
  void initialFetchTest() throws ExecutionException, InterruptedException {
    // Check the initial config is correct
    ClientConfiguration initialConfig = manager.start().get();
    assertThat(initialConfig).isEqualTo(service.config.get());

    // Make sure that the next poll was scheduled
    ArgumentCaptor<Long> pollDelayCaptor = ArgumentCaptor.forClass(Long.class);
    verify(mockExecutor, times(1))
        .schedule(any(Runnable.class), pollDelayCaptor.capture(), eq(TimeUnit.MILLISECONDS));

    assertThat(pollDelayCaptor.getValue())
        .isEqualTo(
            Durations.toMillis(
                service.config.get().getPollingConfiguration().getPollingInterval()));
  }

  @Test
  void notifyListenerTest() throws Exception {
    // Fetch initial config
    manager.start().get();

    ArgumentCaptor<Runnable> runnableCaptor = ArgumentCaptor.forClass(Runnable.class);
    verify(mockExecutor, times(1)).schedule(runnableCaptor.capture(), anyLong(), any());

    // Add a listener
    @SuppressWarnings("unchecked")
    ConfigListener<SessionClientConfiguration> mockListener = Mockito.mock(ConfigListener.class);
    manager.addListener(ClientConfiguration::getSessionConfiguration, mockListener);

    // force a fetch
    runnableCaptor.getValue().run();
    outstandingRpcCounter.waitUntilRpcsDone();
    // Config didnt change so listener shouldnt be invoked
    verify(mockListener, never()).onChange(any());

    // Change an unrelated config
    ClientConfiguration.Builder builder = service.config.get().toBuilder();
    builder.getPollingConfigurationBuilder().setPollingInterval(Durations.fromMinutes(100));
    service.config.set(builder.build());
    runnableCaptor.getValue().run();
    outstandingRpcCounter.waitUntilRpcsDone();
    // And make sure that the listener isn't invoked
    verify(mockListener, never()).onChange(any());

    // Now modify the relevant config section
    builder
        .getSessionConfigurationBuilder()
        .getSessionPoolConfigurationBuilder()
        .setLoadBalancingOptions(
            LoadBalancingOptions.newBuilder()
                .setLeastInFlight(LeastInFlight.newBuilder().setRandomSubsetSize(10)));
    service.config.set(builder.build());
    // force a run
    runnableCaptor.getValue().run();
    outstandingRpcCounter.waitUntilRpcsDone();
    verify(mockListener, times(1)).onChange(eq(builder.build().getSessionConfiguration()));
  }

  @Test
  void testDisabledSessions() throws ExecutionException, InterruptedException {
    ClientConfiguration.Builder builder = manager.getDefaultConfig().toBuilder();
    builder.getSessionConfigurationBuilder().setSessionLoad(0);
    ClientConfiguration disabledCfg = builder.build();

    // Default config should have entries for session & channel pools
    assertThat(disabledCfg.getSessionConfiguration().getSessionPoolConfiguration())
        .isNotEqualToDefaultInstance();
    assertThat(disabledCfg.getSessionConfiguration().getChannelConfiguration())
        .isNotEqualToDefaultInstance();

    service.config.set(disabledCfg);
    // Fetch initial config
    ClientConfiguration resolvedConfig = manager.start().get();
    // But since the load is zero, the session & channel pool configs should be cleared
    assertThat(resolvedConfig.getSessionConfiguration().getSessionPoolConfiguration())
        .isEqualToDefaultInstance();
    assertThat(resolvedConfig.getSessionConfiguration().getChannelConfiguration())
        .isEqualToDefaultInstance();
  }

  @Deprecated
  @Test
  void testMigrateSessionPool() throws ExecutionException, InterruptedException {
    ClientConfiguration defaultConfig = manager.getDefaultConfig();

    // Override LoadBalancingOptions
    LoadBalancingOptions loadBalancingOptions =
        LoadBalancingOptions.newBuilder()
            .setPeakEwma(PeakEwma.newBuilder().setRandomSubsetSize(0))
            .build();

    ClientConfiguration.Builder legacyBuilder = defaultConfig.toBuilder();

    // Enable sessions
    legacyBuilder.getSessionConfigurationBuilder().setSessionLoad(0.1f);

    // Now patch default config to be a legacy config
    // During migration, LoadBalancingOptions are a toplevel config, so clear out the
    // SessionPoolConfiguration and set the toplevel option
    legacyBuilder
        .getSessionConfigurationBuilder()
        .setLoadBalancingOptions(loadBalancingOptions)
        .clearSessionPoolConfiguration()
        .clearChannelConfiguration();
    ClientConfiguration legacyCfg = legacyBuilder.build();

    service.config.set(legacyCfg);
    // Fetch initial config
    ClientConfiguration resolvedConfig = manager.start().get();

    // Make sure that SessionPoolConfiguration got patched with SessionPool & ChannelPool configs
    // And ensure that the toplevel LoadBalancingOptions got migrated
    ClientConfiguration.Builder expectedConfig = legacyCfg.toBuilder();
    expectedConfig
        .getSessionConfigurationBuilder()
        .clearLoadBalancingOptions()
        .setSessionPoolConfiguration(
            defaultConfig.getSessionConfiguration().getSessionPoolConfiguration().toBuilder()
                .setLoadBalancingOptions(loadBalancingOptions))
        .setChannelConfiguration(defaultConfig.getSessionConfiguration().getChannelConfiguration());

    assertThat(resolvedConfig).isEqualTo(expectedConfig.build());
  }

  @Test
  void testSysPropOverride() throws Exception {
    manager.close();

    String clientConfigOverrides =
        TextFormat.printer()
            .printToString(
                ClientConfiguration.newBuilder()
                    .setSessionConfiguration(
                        SessionClientConfiguration.newBuilder()
                            .setSessionLoad(0.75f)
                            .setSessionPoolConfiguration(
                                SessionPoolConfiguration.newBuilder().setHeadroom(0.7f)))
                    .build());
    Properties sysProps = new Properties();
    sysProps.setProperty(ClientConfigurationManager.OVERRIDE_SYS_PROP_KEY, clientConfigOverrides);
    manager =
        new ClientConfigurationManager(
            sysProps, FEATURE_FLAGS, CLIENT_INFO, channelProvider, noopDebugTracer, mockExecutor);

    ClientConfiguration initialConfig = manager.start().get();

    // The effective config should be the server config with the overlayed fields
    ClientConfiguration.Builder expectedConfig = service.config.get().toBuilder();
    expectedConfig.getSessionConfigurationBuilder().setSessionLoad(0.75f);
    expectedConfig
        .getSessionConfigurationBuilder()
        .getSessionPoolConfigurationBuilder()
        .setHeadroom(0.7f);

    assertThat(initialConfig).isEqualTo(expectedConfig.build());
    assertThat(manager.areSessionsRequired()).isTrue();
  }

  /** Verify that proto merging works when the override the same as the default value */
  @Test
  void testSysPropOverrideSessionLoadZero() throws Exception {
    manager.close();

    String clientConfigOverrides =
        TextFormat.printer()
            .printToString(
                ClientConfiguration.newBuilder()
                    .setSessionConfiguration(
                        SessionClientConfiguration.newBuilder().setSessionLoad(0))
                    .build());
    Properties sysProps = new Properties();
    sysProps.setProperty(ClientConfigurationManager.OVERRIDE_SYS_PROP_KEY, clientConfigOverrides);
    manager =
        new ClientConfigurationManager(
            sysProps, FEATURE_FLAGS, CLIENT_INFO, channelProvider, noopDebugTracer, mockExecutor);

    ClientConfiguration initialConfig = manager.start().get();

    // The effective config should be the server config with the overlayed fields
    ClientConfiguration.Builder expectedConfig = service.config.get().toBuilder();
    expectedConfig.getSessionConfigurationBuilder().setSessionLoad(0);

    assertThat(initialConfig).isEqualTo(service.config.get());
  }

  static class FakeConfigService extends BigtableGrpc.BigtableImplBase {
    private final AtomicReference<ClientConfiguration> config = new AtomicReference<>();

    public FakeConfigService() throws IOException {
      ClientConfiguration.Builder builder = ClientConfigurationManager.loadDefault().toBuilder();
      builder.getSessionConfigurationBuilder().setSessionLoad(0.25f);
      config.set(builder.build());
    }

    @Override
    public void getClientConfiguration(
        GetClientConfigurationRequest request,
        StreamObserver<ClientConfiguration> responseObserver) {
      responseObserver.onNext(config.get());
      responseObserver.onCompleted();
    }
  }

  private static class OutstandingRpcCounter implements ClientInterceptor {
    private int numOutstandingRpcs = 0;
    private final Object lock = new Object();

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
      synchronized (lock) {
        numOutstandingRpcs++;
      }
      return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
          channel.newCall(methodDescriptor, callOptions)) {
        @Override
        public void start(Listener<RespT> responseListener, Metadata headers) {
          super.start(
              new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(
                  responseListener) {
                @Override
                public void onClose(Status status, Metadata trailers) {
                  super.onClose(status, trailers);
                  synchronized (lock) {
                    numOutstandingRpcs--;
                    lock.notify();
                  }
                }
              },
              headers);
        }
      };
    }

    void waitUntilRpcsDone() throws InterruptedException {
      synchronized (lock) {
        while (numOutstandingRpcs > 0) {
          lock.wait();
        }
      }
    }
  }
}
