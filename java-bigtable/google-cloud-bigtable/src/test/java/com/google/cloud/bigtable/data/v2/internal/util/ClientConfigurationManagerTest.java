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
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.ClientConfiguration;
import com.google.bigtable.v2.FeatureFlags;
import com.google.bigtable.v2.GetClientConfigurationRequest;
import com.google.bigtable.v2.LoadBalancingOptions;
import com.google.bigtable.v2.LoadBalancingOptions.LeastInFlight;
import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.bigtable.v2.SessionClientConfiguration.ChannelPoolConfiguration.DirectAccessWithFallback;
import com.google.bigtable.v2.SessionClientConfiguration.SessionPoolConfiguration;
import com.google.bigtable.v2.SessionDiversionConfiguration;
import com.google.bigtable.v2.SessionDiversionConfiguration.PerScopeDiversion;
import com.google.bigtable.v2.SessionScopeDiversionConfiguration;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders.ForwardingChannelProvider;
import com.google.cloud.bigtable.data.v2.internal.api.InstanceName;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager.ConfigListener;
import com.google.common.collect.Iterables;
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
import io.grpc.ServerBuilder;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
// Backstop against a wedged blocking call (e.g. manager.start().get()) hanging the CI runner
// indefinitely. If any test exceeds this, fail fast with a diagnosable timeout instead.
//
// SEPARATE_THREAD is required, not cosmetic: the default SAME_THREAD mode enforces the timeout by
// interrupting the test thread, and a thread blocked on monitor entry (`synchronized`) cannot be
// interrupted. A deadlock like the one testDeadlockPrevention guards against would therefore
// silently wedge the whole surefire JVM until the CI job's own multi-hour timeout.
@Timeout(value = 60, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
class ClientConfigurationManagerTest {
  private static final FeatureFlags FEATURE_FLAGS = FeatureFlags.getDefaultInstance();

  // Retries of a failed fetch are scheduled with sub-second delays, while the next poll is
  // scheduled minutes out. Anything below this threshold is treated as a retry and run inline.
  private static final long POLL_VS_RETRY_THRESHOLD_MS = 1_000;

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

    // The manager schedules two kinds of tasks on this executor: short-delay retries of a failed
    // fetch, and the long-delay next poll. Run retries inline so a transient failure of the initial
    // fetch (e.g. a flaky loopback connection) recovers instead of wedging a caller blocked on
    // start().get() forever — a plain mock executor would otherwise silently drop the retry.
    // Long-delay polls are left for tests to trigger manually via the captured Runnable.
    lenient()
        .when(mockExecutor.schedule(any(Runnable.class), anyLong(), any(TimeUnit.class)))
        .thenAnswer(
            invocation -> {
              long delayMs =
                  invocation
                      .getArgument(2, TimeUnit.class)
                      .toMillis(invocation.getArgument(1, Long.class));
              if (delayMs < POLL_VS_RETRY_THRESHOLD_MS) {
                invocation.getArgument(0, Runnable.class).run();
              }
              return Mockito.mock(ScheduledFuture.class);
            });

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
  void initialFetchRetriesAndRecovers() throws Exception {
    // The first request is answered without a config message; for a unary RPC gRPC surfaces this to
    // the client as a non-OK status, which drives the retry path. start().get() must recover via a
    // retry instead of wedging forever. Under a plain mock executor the scheduled retry would be
    // silently dropped and this would hang (caught by the class @Timeout).
    service.emptyResponses.set(1);

    ClientConfiguration initialConfig = manager.start().get();

    assertThat(initialConfig).isEqualTo(service.config.get());
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

  @Test
  void testSysPropOverride() throws Exception {
    manager.close();

    ClientConfiguration rawOverrideProto =
        ClientConfiguration.newBuilder()
            .setSessionConfiguration(
                SessionClientConfiguration.newBuilder()
                    .setSessionDiversionConfiguration(
                        SessionDiversionConfiguration.newBuilder()
                            .setGlobalDiversion(
                                SessionScopeDiversionConfiguration.newBuilder()
                                    .setSessionLoad(0.75f)))
                    .setSessionPoolConfiguration(
                        SessionPoolConfiguration.newBuilder().setHeadroom(0.7f)))
            .build();
    String clientConfigOverrides = TextFormat.printer().printToString(rawOverrideProto);

    // 1. Raw override without OVERRIDE_USE_DEFAULT_SYS_PROP_KEY: completely ignores both server
    // config and defaultConfig, uses only the textproto, and does not poll the server.
    Properties rawSysProps = new Properties();
    rawSysProps.setProperty(
        ClientConfigurationManager.OVERRIDE_SYS_PROP_KEY, clientConfigOverrides);
    manager =
        new ClientConfigurationManager(
            rawSysProps,
            FEATURE_FLAGS,
            CLIENT_INFO,
            channelProvider,
            noopDebugTracer,
            mockExecutor);

    ClientConfiguration rawResolvedConfig = manager.start().get();
    ClientConfiguration expectedRawConfig =
        rawOverrideProto.toBuilder()
            .setTelemetryConfiguration(manager.getDefaultConfig().getTelemetryConfiguration())
            .build();
    assertThat(rawResolvedConfig).isEqualTo(expectedRawConfig);
    assertThat(manager.areSessionsRequired()).isTrue();
    verify(mockExecutor, never()).schedule(any(Runnable.class), anyLong(), any(TimeUnit.class));
    manager.close();

    // 2. Override with OVERRIDE_USE_DEFAULT_SYS_PROP_KEY=true: merges override onto defaultConfig
    // and does not poll the server.
    Properties useDefaultSysProps = new Properties();
    useDefaultSysProps.setProperty(
        ClientConfigurationManager.OVERRIDE_USE_DEFAULT_SYS_PROP_KEY, "true");
    useDefaultSysProps.setProperty(
        ClientConfigurationManager.OVERRIDE_SYS_PROP_KEY, clientConfigOverrides);
    manager =
        new ClientConfigurationManager(
            useDefaultSysProps,
            FEATURE_FLAGS,
            CLIENT_INFO,
            channelProvider,
            noopDebugTracer,
            mockExecutor);

    ClientConfiguration mergedConfig = manager.start().get();

    ClientConfiguration.Builder expectedConfig = manager.getDefaultConfig().toBuilder();
    expectedConfig
        .getSessionConfigurationBuilder()
        .getSessionDiversionConfigurationBuilder()
        .getGlobalDiversionBuilder()
        .setSessionLoad(0.75f);
    expectedConfig
        .getSessionConfigurationBuilder()
        .getSessionPoolConfigurationBuilder()
        .setHeadroom(0.7f);

    assertThat(mergedConfig).isEqualTo(expectedConfig.build());
    assertThat(manager.areSessionsRequired()).isTrue();
    verify(mockExecutor, never()).schedule(any(Runnable.class), anyLong(), any(TimeUnit.class));
    manager.close();

    // 3. OVERRIDE_USE_DEFAULT_SYS_PROP_KEY=true without OVERRIDE_SYS_PROP_KEY: ignored, polls the
    // server normally.
    Properties onlyUseDefaultSysProps = new Properties();
    onlyUseDefaultSysProps.setProperty(
        ClientConfigurationManager.OVERRIDE_USE_DEFAULT_SYS_PROP_KEY, "true");
    manager =
        new ClientConfigurationManager(
            onlyUseDefaultSysProps,
            FEATURE_FLAGS,
            CLIENT_INFO,
            channelProvider,
            noopDebugTracer,
            mockExecutor);

    ClientConfiguration serverConfig = manager.start().get();
    assertThat(serverConfig).isEqualTo(service.config.get());
    assertThat(manager.areSessionsRequired()).isFalse();
    verify(mockExecutor, times(1)).schedule(any(Runnable.class), anyLong(), any(TimeUnit.class));
  }

  @Test
  void testPerScopeDiversionWithNonZeroLoadEnablesSessions() throws Exception {
    ClientConfiguration resolvedConfig =
        startWithSessionOverride(
            SessionClientConfiguration.newBuilder()
                .setSessionLoad(0)
                .setSessionDiversionConfiguration(
                    SessionDiversionConfiguration.newBuilder()
                        .setPerScopeDiversion(
                            PerScopeDiversion.newBuilder()
                                .putScopeDiversions(
                                    "method:Bigtable.ReadRow",
                                    SessionScopeDiversionConfiguration.newBuilder()
                                        .setSessionLoad(0.5f)
                                        .build()))));

    // The flat session_load is 0, but a scope diverts traffic, so the config must survive
    // normalization and the client must advertise session support.
    assertThat(resolvedConfig.hasSessionConfiguration()).isTrue();
    assertThat(
            resolvedConfig
                .getSessionConfiguration()
                .getSessionDiversionConfiguration()
                .getPerScopeDiversion()
                .getScopeDiversionsMap())
        .containsKey("method:Bigtable.ReadRow");
    assertThat(manager.areSessionsRequired()).isTrue();
  }

  @Test
  void testPerScopeDiversionWithAllZeroLoadsDisablesSessions() throws Exception {
    ClientConfiguration resolvedConfig =
        startWithSessionOverride(
            SessionClientConfiguration.newBuilder()
                .setSessionLoad(0)
                .setSessionDiversionConfiguration(
                    SessionDiversionConfiguration.newBuilder()
                        .setPerScopeDiversion(
                            PerScopeDiversion.newBuilder()
                                .putScopeDiversions(
                                    "method:Bigtable.ReadRow",
                                    SessionScopeDiversionConfiguration.newBuilder()
                                        .setSessionLoad(0)
                                        .build()))));

    // A diversion config that routes nothing must not keep sessions alive.
    assertThat(resolvedConfig.hasSessionConfiguration()).isFalse();
    assertThat(manager.areSessionsRequired()).isFalse();
  }

  @Test
  void testGlobalDiversionWithZeroLoadDisablesSessions() throws Exception {
    ClientConfiguration resolvedConfig =
        startWithSessionOverride(
            SessionClientConfiguration.newBuilder()
                .setSessionLoad(0)
                .setSessionDiversionConfiguration(
                    SessionDiversionConfiguration.newBuilder()
                        .setGlobalDiversion(
                            SessionScopeDiversionConfiguration.newBuilder().setSessionLoad(0))));

    assertThat(resolvedConfig.hasSessionConfiguration()).isFalse();
    assertThat(manager.areSessionsRequired()).isFalse();
  }

  @Test
  void testGlobalDiversionWithNonZeroLoadEnablesSessions() throws Exception {
    ClientConfiguration resolvedConfig =
        startWithSessionOverride(
            SessionClientConfiguration.newBuilder()
                .setSessionLoad(0)
                .setSessionDiversionConfiguration(
                    SessionDiversionConfiguration.newBuilder()
                        .setGlobalDiversion(
                            SessionScopeDiversionConfiguration.newBuilder()
                                .setSessionLoad(0.25f))));

    assertThat(resolvedConfig.hasSessionConfiguration()).isTrue();
    assertThat(
            resolvedConfig
                .getSessionConfiguration()
                .getSessionDiversionConfiguration()
                .getGlobalDiversion()
                .getSessionLoad())
        .isEqualTo(0.25f);
    assertThat(manager.areSessionsRequired()).isTrue();
  }

  /**
   * Restarts the manager with {@code OVERRIDE_USE_DEFAULT_SYS_PROP_KEY=true} and the supplied
   * session configuration supplied as a sys-prop override, and returns the resolved config.
   */
  private ClientConfiguration startWithSessionOverride(
      SessionClientConfiguration.Builder sessionOverride) throws Exception {
    manager.close();
    Properties sysProps = new Properties();
    sysProps.setProperty(ClientConfigurationManager.OVERRIDE_USE_DEFAULT_SYS_PROP_KEY, "true");
    sysProps.setProperty(
        ClientConfigurationManager.OVERRIDE_SYS_PROP_KEY,
        TextFormat.printer()
            .printToString(
                ClientConfiguration.newBuilder().setSessionConfiguration(sessionOverride).build()));
    manager =
        new ClientConfigurationManager(
            sysProps, FEATURE_FLAGS, CLIENT_INFO, channelProvider, noopDebugTracer, mockExecutor);

    return manager.start().get();
  }

  /**
   * The manager must never invoke a listener while holding its own monitor, no matter which thread
   * ends up running the config-fetch continuation. See {@link #testDeadlockPrevention()} for the
   * deadlock this prevents.
   *
   * <p>Where testDeadlockPrevention relies on a real RPC and so only catches the bad interleaving
   * by luck, this test pins it: the channel answers GetClientConfiguration synchronously on the
   * calling thread, so the config future is always already complete by the time
   * sendRequestWithRetries() registers its continuation, and the continuation always runs inline on
   * the polling thread.
   */
  @Test
  void listenersAreNotifiedWithoutHoldingTheManagerLock() throws Exception {
    manager.close();

    ChannelProviders.ChannelProvider synchronousProvider =
        new ForwardingChannelProvider(channelProvider) {
          @Override
          public ManagedChannelBuilder<?> newChannelBuilder() {
            return super.newChannelBuilder().intercept(new SynchronousConfigInterceptor(service));
          }
        };
    manager =
        new ClientConfigurationManager(
            FEATURE_FLAGS, CLIENT_INFO, synchronousProvider, noopDebugTracer, mockExecutor);

    manager.start().get();

    ArgumentCaptor<Runnable> runnableCaptor = ArgumentCaptor.forClass(Runnable.class);
    verify(mockExecutor, times(1)).schedule(runnableCaptor.capture(), anyLong(), any());

    ClientConfigurationManager notifyingManager = manager;
    AtomicInteger notifications = new AtomicInteger();
    AtomicBoolean lockHeldDuringCallback = new AtomicBoolean();
    manager.addListener(
        ClientConfiguration::getSessionConfiguration,
        newValue -> {
          notifications.incrementAndGet();
          lockHeldDuringCallback.set(Thread.holdsLock(notifyingManager));
        });

    // Change the watched section so the listener actually fires, then poll.
    ClientConfiguration.Builder builder = service.config.get().toBuilder();
    builder
        .getSessionConfigurationBuilder()
        .getSessionPoolConfigurationBuilder()
        .setLoadBalancingOptions(
            LoadBalancingOptions.newBuilder()
                .setLeastInFlight(LeastInFlight.newBuilder().setRandomSubsetSize(30)));
    service.config.set(builder.build());

    runnableCaptor.getValue().run();

    assertThat(notifications.get()).isEqualTo(1);
    assertThat(lockHeldDuringCallback.get()).isFalse();
  }

  @Test
  void testDeadlockPrevention() throws Exception {
    // Initialize the manager and fetch the initial config to schedule polling.
    manager.start().get();

    ArgumentCaptor<Runnable> runnableCaptor = ArgumentCaptor.forClass(Runnable.class);
    verify(mockExecutor, times(1)).schedule(runnableCaptor.capture(), anyLong(), any());
    Runnable triggerPollRunnable = runnableCaptor.getValue();

    // Define the "alien" lock object.
    final Object alienLock = new Object();

    // Latches to coordinate the deadlock scenario deterministically.
    final CountDownLatch alienLockAcquiredLatch = new CountDownLatch(1);
    final CountDownLatch startGetterLatch = new CountDownLatch(1);

    // Register a listener that acts as the "alien" callback.
    manager.addListener(
        ClientConfiguration::getSessionConfiguration,
        new ConfigListener<SessionClientConfiguration>() {
          @Override
          public void onChange(SessionClientConfiguration newValue) {
            // Signal that we have entered the listener callback (released the manager monitor lock)
            startGetterLatch.countDown();

            // Try to acquire the alien lock. If we still hold the manager monitor lock,
            // this will cause a deadlock with the other thread calling getClientConfiguration().
            synchronized (alienLock) {
              // Do nothing
            }
          }
        });

    // Start Thread B which will hold the alienLock and call getClientConfiguration()
    final AtomicReference<ClientConfiguration> retrievedConfig = new AtomicReference<>();
    final AtomicReference<Throwable> threadBError = new AtomicReference<>();

    Thread threadB =
        new Thread(
            () -> {
              synchronized (alienLock) {
                // Signal that we hold the alien lock
                alienLockAcquiredLatch.countDown();
                try {
                  // Wait until Thread A enters the onChange callback
                  if (startGetterLatch.await(5, TimeUnit.SECONDS)) {
                    // Call getClientConfiguration() which requires the synchronized lock on
                    // ClientConfigurationManager
                    retrievedConfig.set(manager.getClientConfiguration());
                  } else {
                    threadBError.set(
                        new RuntimeException("Timeout waiting for listener onChange to start"));
                  }
                } catch (InterruptedException e) {
                  threadBError.set(e);
                }
              }
            });
    threadB.setDaemon(true);
    threadB.start();

    // Wait for Thread B to acquire the alien lock
    assertThat(alienLockAcquiredLatch.await(5, TimeUnit.SECONDS)).isTrue();

    // Thread A (current thread): Trigger config change to invoke listener
    ClientConfiguration.Builder builder = service.config.get().toBuilder();
    builder
        .getSessionConfigurationBuilder()
        .getSessionPoolConfigurationBuilder()
        .setLoadBalancingOptions(
            LoadBalancingOptions.newBuilder()
                .setLeastInFlight(LeastInFlight.newBuilder().setRandomSubsetSize(20)));
    service.config.set(builder.build());

    // Trigger the poll (which calls setClientConfiguration -> notifyListeners)
    triggerPollRunnable.run();
    outstandingRpcCounter.waitUntilRpcsDone();

    // Wait for Thread B to finish
    threadB.join(5000);
    assertThat(threadB.isAlive()).isFalse();
    assertThat(threadBError.get()).isNull();
    assertThat(retrievedConfig.get()).isNotNull();
  }

  @Test
  void disableDirectPathFallbackTest() throws Exception {
    Properties overrideSysProps = new Properties();
    overrideSysProps.setProperty(
        ClientConfigurationManager.DISABLE_DIRECT_ACCESS_FALLBACK_SYS_PROP_KEY, "true");
    overrideSysProps.setProperty(
        ClientConfigurationManager.OVERRIDE_USE_DEFAULT_SYS_PROP_KEY, "true");
    String clientConfigOverrides =
        TextFormat.printer()
            .printToString(
                ClientConfiguration.newBuilder()
                    .setSessionConfiguration(
                        SessionClientConfiguration.newBuilder()
                            .setSessionDiversionConfiguration(
                                SessionDiversionConfiguration.newBuilder()
                                    .setGlobalDiversion(
                                        SessionScopeDiversionConfiguration.newBuilder()
                                            .setSessionLoad(0.75f)))
                            .setChannelConfiguration(
                                SessionClientConfiguration.ChannelPoolConfiguration.newBuilder()
                                    .setDirectAccessWithFallback(
                                        DirectAccessWithFallback.getDefaultInstance())))
                    .build());
    overrideSysProps.setProperty(
        ClientConfigurationManager.OVERRIDE_SYS_PROP_KEY, clientConfigOverrides);

    try (ClientConfigurationManager overrideFallbackDisabledManager =
        new ClientConfigurationManager(
            overrideSysProps,
            FEATURE_FLAGS,
            CLIENT_INFO,
            channelProvider,
            noopDebugTracer,
            mockExecutor)) {
      // Check initial config with override has fallback disabled and direct_access_only set
      SessionClientConfiguration.ChannelPoolConfiguration initialChannelConfig =
          overrideFallbackDisabledManager
              .getClientConfiguration()
              .getSessionConfiguration()
              .getChannelConfiguration();
      assertThat(initialChannelConfig.hasDirectAccessOnly()).isTrue();
      assertThat(initialChannelConfig.hasDirectAccessWithFallback()).isFalse();
    }

    // Also verify server-fetched config (without local override) converts
    // direct_access_with_fallback
    Properties serverSysProps = new Properties();
    serverSysProps.setProperty(
        ClientConfigurationManager.DISABLE_DIRECT_ACCESS_FALLBACK_SYS_PROP_KEY, "true");
    try (ClientConfigurationManager fallbackDisabledManager =
        new ClientConfigurationManager(
            serverSysProps,
            FEATURE_FLAGS,
            CLIENT_INFO,
            channelProvider,
            noopDebugTracer,
            mockExecutor)) {
      // Start manager and fetch server config (which sends direct_access_with_fallback)
      ClientConfiguration fetchedConfig = fallbackDisabledManager.start().get();
      SessionClientConfiguration.ChannelPoolConfiguration fetchedChannelConfig =
          fetchedConfig.getSessionConfiguration().getChannelConfiguration();

      // Verify that direct_access_with_fallback is converted to direct_access_only
      assertThat(fetchedChannelConfig.hasDirectAccessOnly()).isTrue();
      assertThat(fetchedChannelConfig.hasDirectAccessWithFallback()).isFalse();

      // Verify other channel pool configuration fields from the server are preserved
      SessionClientConfiguration.ChannelPoolConfiguration serverChannelConfig =
          service.config.get().getSessionConfiguration().getChannelConfiguration();
      assertThat(fetchedChannelConfig.getMinServerCount())
          .isEqualTo(serverChannelConfig.getMinServerCount());
      assertThat(fetchedChannelConfig.getMaxServerCount())
          .isEqualTo(serverChannelConfig.getMaxServerCount());
      assertThat(fetchedChannelConfig.getPerServerSessionCount())
          .isEqualTo(serverChannelConfig.getPerServerSessionCount());
    }
  }

  @Test
  void stopPollingTest() throws Exception {
    ClientConfiguration stopPollingConfig =
        service.config.get().toBuilder().setStopPolling(true).build();
    service.config.set(stopPollingConfig);

    ClientConfiguration initialConfig = manager.start().get();
    assertThat(initialConfig.getStopPolling()).isTrue();
    assertThat(initialConfig.hasPollingConfiguration()).isFalse();

    verify(mockExecutor, never()).schedule(any(Runnable.class), anyLong(), any(TimeUnit.class));
  }

  @Test
  void metadataDoesNotAccumulateAcrossPollsWithHeaderAttachingInterceptor() throws Exception {
    manager.close();

    Metadata.Key<String> traceparentKey =
        Metadata.Key.of("traceparent", Metadata.ASCII_STRING_MARSHALLER);
    Metadata.Key<String> requestParamsKey =
        Metadata.Key.of("x-goog-request-params", Metadata.ASCII_STRING_MARSHALLER);
    Metadata.Key<String> featureFlagsKey =
        Metadata.Key.of("bigtable-features", Metadata.ASCII_STRING_MARSHALLER);

    List<Integer> traceparentCountsOnServer = new CopyOnWriteArrayList<>();
    List<Integer> requestParamsCountsOnServer = new CopyOnWriteArrayList<>();
    List<Integer> featureFlagsCountsOnServer = new CopyOnWriteArrayList<>();

    ServerInterceptor headerCapturingServerInterceptor =
        new ServerInterceptor() {
          @Override
          public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
              ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
            traceparentCountsOnServer.add(Iterables.size(headers.getAll(traceparentKey)));
            requestParamsCountsOnServer.add(Iterables.size(headers.getAll(requestParamsKey)));
            featureFlagsCountsOnServer.add(Iterables.size(headers.getAll(featureFlagsKey)));
            return next.startCall(call, headers);
          }
        };

    // Enforce a tight 1 KiB SETTINGS_MAX_HEADER_LIST_SIZE so any per-poll header accumulation in
    // ClientConfigurationManager.metadata trips Netty's HpackEncoder HeaderListSizeException
    // (Status.INTERNAL: "http2 exception") within ~8 polls.
    Server boundedHeaderServer =
        ServerBuilder.forPort(0)
            .addService(service)
            .intercept(headerCapturingServerInterceptor)
            .maxInboundMetadataSize(1024)
            .build()
            .start();

    ClientInterceptor tracingInterceptor =
        new ClientInterceptor() {
          @Override
          public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
              MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
            return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
                next.newCall(method, callOptions)) {
              @Override
              public void start(Listener<RespT> responseListener, Metadata headers) {
                headers.put(
                    traceparentKey, "00-4bf92f3577b34da6a3ce929d0e0e4736-00f067aa0ba902b7-01");
                super.start(responseListener, headers);
              }
            };
          }
        };

    ChannelProviders.ChannelProvider tracingChannelProvider =
        new ForwardingChannelProvider(
            new ChannelProviders.EmulatorChannelProvider(
                "localhost", boundedHeaderServer.getPort())) {
          @Override
          public ManagedChannelBuilder<?> newChannelBuilder() {
            return super.newChannelBuilder()
                .intercept(outstandingRpcCounter)
                .intercept(tracingInterceptor);
          }
        };

    try (ClientConfigurationManager localManager =
        new ClientConfigurationManager(
            FEATURE_FLAGS, CLIENT_INFO, tracingChannelProvider, noopDebugTracer, mockExecutor)) {
      localManager.start().get();

      ArgumentCaptor<Runnable> pollCaptor = ArgumentCaptor.forClass(Runnable.class);
      verify(mockExecutor, Mockito.atLeastOnce())
          .schedule(pollCaptor.capture(), anyLong(), any(TimeUnit.class));
      Runnable scheduledPoll = pollCaptor.getValue();

      for (int i = 0; i < 25; i++) {
        scheduledPoll.run();
        outstandingRpcCounter.waitUntilRpcsDone();
      }

      assertThat(service.requestCount.get()).isEqualTo(26);
      assertThat(traceparentCountsOnServer).hasSize(26);
      for (int i = 0; i < 26; i++) {
        assertThat(traceparentCountsOnServer.get(i)).isEqualTo(1);
        assertThat(requestParamsCountsOnServer.get(i)).isEqualTo(1);
        assertThat(featureFlagsCountsOnServer.get(i)).isEqualTo(1);
      }
    } finally {
      boundedHeaderServer.shutdownNow();
    }
  }

  static class FakeConfigService extends BigtableGrpc.BigtableImplBase {
    private final AtomicReference<ClientConfiguration> config = new AtomicReference<>();

    // Number of leading requests to answer with a clean (OK) close that delivers no message,
    // simulating the server closing the stream without ever returning a configuration.
    private final AtomicInteger emptyResponses = new AtomicInteger(0);
    private final AtomicInteger requestCount = new AtomicInteger(0);

    public FakeConfigService() throws IOException {
      ClientConfiguration.Builder builder = ClientConfigurationManager.loadDefault().toBuilder();
      builder
          .getSessionConfigurationBuilder()
          .setSessionDiversionConfiguration(
              SessionDiversionConfiguration.newBuilder()
                  .setGlobalDiversion(
                      SessionScopeDiversionConfiguration.newBuilder().setSessionLoad(0.25f)));
      builder
          .getSessionConfigurationBuilder()
          .getChannelConfigurationBuilder()
          .setMinServerCount(2)
          .setMaxServerCount(10)
          .setPerServerSessionCount(15);
      config.set(builder.build());
    }

    @Override
    public void getClientConfiguration(
        GetClientConfigurationRequest request,
        StreamObserver<ClientConfiguration> responseObserver) {
      requestCount.incrementAndGet();
      if (emptyResponses.getAndDecrement() > 0) {
        // Close cleanly without sending a message.
        responseObserver.onCompleted();
        return;
      }
      responseObserver.onNext(config.get());
      responseObserver.onCompleted();
    }
  }

  /**
   * Answers GetClientConfiguration from {@link FakeConfigService#config} synchronously, on the
   * thread that issued the call, without touching the network. Used to make the "response already
   * delivered before the caller registers its continuation" interleaving deterministic.
   */
  private static class SynchronousConfigInterceptor implements ClientInterceptor {
    private final FakeConfigService service;

    SynchronousConfigInterceptor(FakeConfigService service) {
      this.service = service;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
      return new ClientCall<ReqT, RespT>() {
        private Listener<RespT> responseListener;

        @Override
        public void start(Listener<RespT> responseListener, Metadata headers) {
          this.responseListener = responseListener;
        }

        @Override
        public void request(int numMessages) {}

        @Override
        public void cancel(@Nullable String message, @Nullable Throwable cause) {}

        @Override
        public void halfClose() {
          @SuppressWarnings("unchecked")
          RespT response = (RespT) service.config.get();
          responseListener.onMessage(response);
          responseListener.onClose(Status.OK, new Metadata());
        }

        @Override
        public void sendMessage(ReqT message) {}
      };
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
