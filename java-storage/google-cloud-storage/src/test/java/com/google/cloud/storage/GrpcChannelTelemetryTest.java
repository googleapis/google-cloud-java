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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assume.assumeFalse;
import static org.mockito.Mockito.mock;

import com.google.api.core.ApiClock;
import com.google.api.core.NanoClock;
import com.google.api.gax.grpc.ChannelPrimer;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.storage.GrpcChannelTelemetry.ChannelReadyCallback;
import com.google.cloud.storage.GrpcChannelTelemetry.TransportType;
import com.google.cloud.storage.OpenTelemetryBootstrappingUtils.ChannelConfigurator;
import com.google.cloud.storage.OpenTelemetryBootstrappingUtils.GrpcMetricsChannelConfigurator;
import com.google.storage.v2.StorageSettings;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public final class GrpcChannelTelemetryTest {

  private static final String DP_INTERCONNECT_TARGET =
      "google-c2p:///storage-direct.googleapis.com?force-xds";

  private CapturingLogHandler logHandler;
  private Level previousLevel;
  private boolean previousUseParentHandlers;
  private ScheduledExecutorService scheduler;

  @Before
  public void setUp() {
    logHandler = new CapturingLogHandler();
    previousLevel = GrpcChannelTelemetry.LOG.getLevel();
    previousUseParentHandlers = GrpcChannelTelemetry.LOG.getUseParentHandlers();
    GrpcChannelTelemetry.LOG.setLevel(Level.ALL);
    GrpcChannelTelemetry.LOG.setUseParentHandlers(false);
    GrpcChannelTelemetry.LOG.addHandler(logHandler);
    scheduler = Executors.newSingleThreadScheduledExecutor();
  }

  @After
  public void tearDown() {
    GrpcChannelTelemetry.LOG.removeHandler(logHandler);
    GrpcChannelTelemetry.LOG.setLevel(previousLevel);
    GrpcChannelTelemetry.LOG.setUseParentHandlers(previousUseParentHandlers);
    scheduler.shutdownNow();
  }

  @Test
  public void detectTransportType_allCases() {
    Object[][] cases = {
      {null, TransportType.CLOUD_PATH},
      {"", TransportType.CLOUD_PATH},
      {"storage.googleapis.com:443", TransportType.CLOUD_PATH},
      {"https://storage.googleapis.com", TransportType.CLOUD_PATH},
      {"google-c2p:///storage.googleapis.com", TransportType.DIRECT_PATH},
      {"google-c2p-experimental:///storage.googleapis.com", TransportType.DIRECT_PATH},
      {DP_INTERCONNECT_TARGET, TransportType.DIRECT_PATH_INTERCONNECT},
      {
        "google-c2p:///storage-direct.googleapis.com?foo=1&force-xds=true",
        TransportType.DIRECT_PATH_INTERCONNECT
      },
      {
        "google-c2p-experimental:///storage-direct.googleapis.com?force-xds",
        TransportType.DIRECT_PATH_INTERCONNECT
      },
      {"google-c2p:///storage.googleapis.com?other=force-xds", TransportType.DIRECT_PATH},
      {"google-c2p:///storage.googleapis.com#force-xds", TransportType.DIRECT_PATH},
      {
        "google-c2p:///storage-direct.googleapis.com?force-xds#section",
        TransportType.DIRECT_PATH_INTERCONNECT
      },
      {"google-c2p:///storage.googleapis.com#frag?force-xds=1", TransportType.DIRECT_PATH}
    };
    for (Object[] c : cases) {
      String endpoint = (String) c[0];
      TransportType expected = (TransportType) c[1];
      assertWithMessage("endpoint=%s", endpoint)
          .that(GrpcChannelTelemetry.detectTransportType(endpoint))
          .isEqualTo(expected);
    }
  }

  @Test
  public void extractHost_extractsNormalizedServerAddress() {
    String[][] cases = {
      {DP_INTERCONNECT_TARGET, "storage-direct.googleapis.com"},
      {
        "google-c2p-experimental:///storage-preprod-direct.sandbox.googleapis.com:443?force-xds",
        "storage-preprod-direct.sandbox.googleapis.com"
      },
      {"google-c2p:///storage.googleapis.com/path", "storage.googleapis.com"},
      {"google-c2p:///storage.googleapis.com#frag", "storage.googleapis.com"},
      {"storage-direct.googleapis.com:443", "storage-direct.googleapis.com"},
      {"storage-direct.googleapis.com", "storage-direct.googleapis.com"},
      {null, ""},
      {"", ""}
    };
    for (String[] c : cases) {
      assertWithMessage("input=%s", c[0])
          .that(GrpcChannelTelemetry.extractHost(c[0]))
          .isEqualTo(c[1]);
    }
  }

  @Test
  public void isDirectPathInterconnectHost_matchesDirectHostsOnly() {
    Object[][] cases = {
      {"storage-direct.googleapis.com", true},
      {"storage-direct.googleapis.com:443", true},
      {"storage-preprod-direct.sandbox.googleapis.com", true},
      {"storage-preprod-direct.sandbox.googleapis.com:443", true},
      {"storage.googleapis.com", false},
      {"custom.example.com", false},
      {null, false}
    };
    for (Object[] c : cases) {
      String host = (String) c[0];
      boolean expected = (Boolean) c[1];
      assertWithMessage("host=%s", host)
          .that(GrpcChannelTelemetry.isDirectPathInterconnectHost(host))
          .isEqualTo(expected);
    }
  }

  @Test
  public void selectedTransportType_allCases() {
    Object[][] cases = {
      {TransportType.CLOUD_PATH, null, true, TransportType.CLOUD_PATH},
      {
        TransportType.CLOUD_PATH,
        GrpcChannelTelemetry.XDS_LB_POLICY_NAME,
        true,
        TransportType.CLOUD_PATH
      },
      {TransportType.DIRECT_PATH, null, true, TransportType.DIRECT_PATH},
      {
        TransportType.DIRECT_PATH,
        GrpcChannelTelemetry.XDS_LB_POLICY_NAME,
        true,
        TransportType.DIRECT_PATH
      },
      {
        TransportType.DIRECT_PATH,
        GrpcChannelTelemetry.DNS_LB_POLICY_NAME,
        true,
        TransportType.CLOUD_PATH
      },
      {TransportType.DIRECT_PATH_INTERCONNECT, null, true, TransportType.DIRECT_PATH_INTERCONNECT},
      {
        TransportType.DIRECT_PATH_INTERCONNECT,
        GrpcChannelTelemetry.XDS_LB_POLICY_NAME,
        true,
        TransportType.DIRECT_PATH_INTERCONNECT
      },
      {
        TransportType.DIRECT_PATH_INTERCONNECT,
        GrpcChannelTelemetry.DNS_LB_POLICY_NAME,
        true,
        TransportType.CLOUD_PATH
      },
      {
        TransportType.DIRECT_PATH_INTERCONNECT,
        GrpcChannelTelemetry.XDS_LB_POLICY_NAME,
        false,
        TransportType.DIRECT_PATH
      }
    };
    for (Object[] c : cases) {
      TransportType requested = (TransportType) c[0];
      String lbPolicy = (String) c[1];
      boolean forceXdsSupported = (Boolean) c[2];
      TransportType expected = (TransportType) c[3];
      assertWithMessage(
              "requested=%s, lbPolicy=%s, forceXds=%s", requested, lbPolicy, forceXdsSupported)
          .that(GrpcChannelTelemetry.selectedTransportType(requested, lbPolicy, forceXdsSupported))
          .isEqualTo(expected);
    }
  }

  @Test
  public void logChannelConfiguration_validConfigurations_logInfo() {
    Object[][] cases = {
      {"storage.googleapis.com:443", false, "CloudPath", "storage.googleapis.com"},
      {"google-c2p:///storage.googleapis.com", false, "DirectPath", "storage.googleapis.com"},
      {DP_INTERCONNECT_TARGET, true, "DirectPathInterconnect", "storage-direct.googleapis.com"},
      {
        "google-c2p:///storage-preprod-direct.sandbox.googleapis.com?force-xds",
        true,
        "DirectPathInterconnect",
        "storage-preprod-direct.sandbox.googleapis.com"
      }
    };
    for (int i = 0; i < cases.length; i++) {
      String endpoint = (String) cases[i][0];
      boolean interconnectEnabled = (Boolean) cases[i][1];
      String expectedTransport = (String) cases[i][2];
      String expectedAuthority = (String) cases[i][3];
      GrpcChannelTelemetry.logChannelConfiguration(endpoint, interconnectEnabled, true);
      LogRecord record = logHandler.records.get(i);
      assertWithMessage(endpoint).that(record.getLevel()).isEqualTo(Level.INFO);
      assertWithMessage(endpoint)
          .that(record.getMessage())
          .contains("Configured gRPC transport. requested_transport_type=" + expectedTransport);
      assertWithMessage(endpoint)
          .that(record.getMessage())
          .contains("authority=" + expectedAuthority);
    }
  }

  @Test
  public void logChannelConfiguration_unsupportedGrpcForceXds_logsWarning() {
    GrpcChannelTelemetry.logChannelConfiguration(DP_INTERCONNECT_TARGET, true, false);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("DirectPath over Interconnect requires a gRPC version supporting force-xds");
  }

  @Test
  public void logChannelConfiguration_interconnectOverriddenByCloudPath_logsWarning() {
    GrpcChannelTelemetry.logChannelConfiguration("storage.googleapis.com:443", true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains(
            "DirectPath over Interconnect is enabled, but the effective endpoint does not request"
                + " it.");
    assertThat(logHandler.records.get(0).getMessage())
        .contains("requested_transport_type=CloudPath");
  }

  @Test
  public void logChannelConfiguration_interconnectOverriddenByDirectPath_logsWarning() {
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage.googleapis.com", true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("requested_transport_type=DirectPath");
  }

  @Test
  public void logChannelConfiguration_nonDirectAuthorityWithForceXds_logsWarning() {
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage.googleapis.com?force-xds", true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains(
            "DirectPath over Interconnect is active, but the channel authority is not a DirectPath"
                + " over Interconnect host");
  }

  @Test
  public void logChannelReady_directPathInterconnectReady_logsInfo() {
    GrpcChannelTelemetry.logChannelReady(
        TransportType.DIRECT_PATH_INTERCONNECT,
        TransportType.DIRECT_PATH_INTERCONNECT,
        GrpcChannelTelemetry.XDS_LB_POLICY_NAME,
        Duration.ofMillis(42),
        true,
        null);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.INFO);
    assertThat(logHandler.records.get(0).getMessage())
        .isEqualTo(
            "gRPC channel [0] is ready. transport_type=DirectPathInterconnect,"
                + " requested_transport_type=DirectPathInterconnect,"
                + " lb_policy=xds_cluster_manager_experimental, elapsed_ms=42");
  }

  @Test
  public void logChannelReady_dnsFallback_logsCloudPathNote() {
    GrpcChannelTelemetry.logChannelReady(
        TransportType.DIRECT_PATH_INTERCONNECT,
        TransportType.CLOUD_PATH,
        GrpcChannelTelemetry.DNS_LB_POLICY_NAME,
        Duration.ofMillis(15),
        true,
        null);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getMessage())
        .contains(
            "Note: google-c2p resolver fell back to DNS (pick_first); traffic is using CloudPath"
                + " instead of DirectPathInterconnect.");
  }

  @Test
  public void logChannelReady_unexpectedLbPolicy_logsNote() {
    GrpcChannelTelemetry.logChannelReady(
        TransportType.DIRECT_PATH,
        TransportType.DIRECT_PATH,
        "round_robin",
        Duration.ofMillis(20),
        true,
        null);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getMessage())
        .contains(
            "Note: unexpected LB policy 'round_robin' for DirectPath (expected"
                + " 'xds_cluster_manager_experimental').");
  }

  @Test
  public void logChannelReady_deadlineExceeded_logsJavaLoggingGuidance() {
    GrpcChannelTelemetry.logChannelReady(
        TransportType.DIRECT_PATH_INTERCONNECT,
        TransportType.DIRECT_PATH_INTERCONNECT,
        null,
        Duration.ofMillis(30000),
        false,
        "DEADLINE_EXCEEDED");
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("gRPC channel [0] did not become ready before deadline.");
    assertThat(logHandler.records.get(0).getMessage()).contains("status=DEADLINE_EXCEEDED");
    assertThat(logHandler.records.get(0).getMessage())
        .contains("enable FINE java.util.logging for io.grpc.xds and io.grpc.googleapis");
  }

  @Test
  public void startChannelTelemetry_immediateReady_invokesCallbackOnce() throws Exception {
    FakeManagedChannel channel =
        new FakeManagedChannel(ConnectivityState.READY, GrpcChannelTelemetry.XDS_LB_POLICY_NAME);
    TestApiClock clock = TestApiClock.tickBy(1_000_000_000L, Duration.ofMillis(25));
    AtomicInteger callbackCount = new AtomicInteger(0);
    AtomicReference<TransportType> reportedTransport = new AtomicReference<>();
    AtomicReference<Duration> reportedLatency = new AtomicReference<>();

    watchInterconnect(
            channel,
            Duration.ofSeconds(30),
            clock,
            (transport, latency) -> {
              callbackCount.incrementAndGet();
              reportedTransport.set(transport);
              reportedLatency.set(latency);
            })
        .get(5, TimeUnit.SECONDS);

    assertThat(callbackCount.get()).isEqualTo(1);
    assertThat(reportedTransport.get()).isEqualTo(TransportType.DIRECT_PATH_INTERCONNECT);
    assertThat(reportedLatency.get()).isEqualTo(Duration.ofMillis(25));
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getMessage()).contains("gRPC channel [0] is ready.");
  }

  @Test
  public void startChannelTelemetry_asyncTransitionToReady_invokesCallbackOnce() throws Exception {
    FakeManagedChannel channel =
        new FakeManagedChannel(ConnectivityState.IDLE, GrpcChannelTelemetry.XDS_LB_POLICY_NAME);
    TestApiClock clock = TestApiClock.of(0L, prev -> prev);
    AtomicInteger callbackCount = new AtomicInteger(0);
    AtomicReference<TransportType> reportedTransport = new AtomicReference<>();
    AtomicReference<Duration> reportedLatency = new AtomicReference<>();

    CompletableFuture<Void> future =
        watchInterconnect(
            channel,
            Duration.ofSeconds(30),
            clock,
            (transport, latency) -> {
              callbackCount.incrementAndGet();
              reportedTransport.set(transport);
              reportedLatency.set(latency);
            });

    assertThat(callbackCount.get()).isEqualTo(0);
    channel.transitionTo(ConnectivityState.CONNECTING);
    assertThat(callbackCount.get()).isEqualTo(0);

    clock.advance(Duration.ofMillis(55));
    channel.transitionTo(ConnectivityState.READY);
    future.get(5, TimeUnit.SECONDS);

    assertThat(callbackCount.get()).isEqualTo(1);
    assertThat(reportedTransport.get()).isEqualTo(TransportType.DIRECT_PATH_INTERCONNECT);
    assertThat(reportedLatency.get()).isEqualTo(Duration.ofMillis(55));
  }

  @Test
  public void startChannelTelemetry_shutdownBeforeReady_doesNotInvokeCallback() throws Exception {
    AtomicInteger callbackCount = new AtomicInteger(0);
    FakeManagedChannel channel = new FakeManagedChannel(ConnectivityState.CONNECTING, null);
    CompletableFuture<Void> future =
        watchInterconnect(
            channel,
            Duration.ofSeconds(30),
            NanoClock.getDefaultClock(),
            (t, d) -> callbackCount.incrementAndGet());
    channel.transitionTo(ConnectivityState.SHUTDOWN);
    future.get(5, TimeUnit.SECONDS);
    assertThat(callbackCount.get()).isEqualTo(0);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("status=channel shut down before becoming ready");
  }

  @Test
  public void startChannelTelemetry_timeoutBeforeReady_doesNotInvokeCallback() throws Exception {
    AtomicInteger callbackCount = new AtomicInteger(0);
    FakeManagedChannel channel = new FakeManagedChannel(ConnectivityState.CONNECTING, null);
    watchInterconnect(
            channel,
            Duration.ofMillis(20),
            NanoClock.getDefaultClock(),
            (t, d) -> callbackCount.incrementAndGet())
        .get(5, TimeUnit.SECONDS);
    assertThat(callbackCount.get()).isEqualTo(0);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getMessage()).contains("status=DEADLINE_EXCEEDED");
  }

  @Test
  public void startChannelTelemetry_clearedWeakReference_doesNotInvokeCallback() throws Exception {
    AtomicInteger callbackCount = new AtomicInteger(0);
    watchInterconnect(
            null,
            Duration.ofSeconds(30),
            NanoClock.getDefaultClock(),
            (t, d) -> callbackCount.incrementAndGet())
        .get(5, TimeUnit.SECONDS);
    assertThat(callbackCount.get()).isEqualTo(0);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("status=channel destroyed before becoming ready");
  }

  @Test
  public void startChannelTelemetry_rejectedScheduler_completesCleanly() throws Exception {
    ScheduledExecutorService closedScheduler = Executors.newSingleThreadScheduledExecutor();
    closedScheduler.shutdownNow();
    FakeManagedChannel connectingChannel =
        new FakeManagedChannel(ConnectivityState.CONNECTING, null);
    GrpcChannelTelemetry.startChannelTelemetry(
            new WeakReference<>(connectingChannel),
            DP_INTERCONNECT_TARGET,
            true,
            Duration.ofSeconds(30),
            null,
            closedScheduler,
            NanoClock.getDefaultClock(),
            FakeManagedChannel::getLbPolicy)
        .get(5, TimeUnit.SECONDS);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("status=telemetry scheduler shut down");
  }

  @Test
  public void startChannelTelemetry_throwingCallback_completesCleanly() throws Exception {
    FakeManagedChannel readyChannel =
        new FakeManagedChannel(ConnectivityState.READY, GrpcChannelTelemetry.XDS_LB_POLICY_NAME);
    watchInterconnect(
            readyChannel,
            Duration.ofSeconds(30),
            NanoClock.getDefaultClock(),
            (transport, latency) -> {
              throw new IllegalStateException("simulated callback failure");
            })
        .get(5, TimeUnit.SECONDS);
    assertThat(logHandler.records).hasSize(2);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.INFO);
    assertThat(logHandler.records.get(1).getLevel()).isEqualTo(Level.FINE);
  }

  @Test
  public void createChannelPrimer_onlyObservesFirstChannelAndShutsDownOwnedScheduler() {
    AtomicInteger callbackCount = new AtomicInteger(0);
    AtomicInteger ownedSupplierCalls = new AtomicInteger(0);
    AtomicReference<ScheduledExecutorService> createdScheduler = new AtomicReference<>();
    ChannelPrimer ownedPrimer =
        GrpcChannelTelemetry.createChannelPrimer(
            DP_INTERCONNECT_TARGET,
            true,
            (transport, latency) -> callbackCount.incrementAndGet(),
            NanoClock.getDefaultClock(),
            () -> {
              ownedSupplierCalls.incrementAndGet();
              ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
              createdScheduler.set(s);
              return s;
            });

    FakeManagedChannel ch0 =
        new FakeManagedChannel(ConnectivityState.READY, GrpcChannelTelemetry.XDS_LB_POLICY_NAME);
    FakeManagedChannel ch1 =
        new FakeManagedChannel(ConnectivityState.READY, GrpcChannelTelemetry.XDS_LB_POLICY_NAME);

    assertThat(ownedSupplierCalls.get()).isEqualTo(0);
    ownedPrimer.primeChannel(ch0);
    ownedPrimer.primeChannel(ch1);
    assertThat(callbackCount.get()).isEqualTo(1);
    assertThat(logHandler.records).hasSize(1);
    assertThat(ownedSupplierCalls.get()).isEqualTo(1);
    assertThat(createdScheduler.get()).isNotNull();
    assertThat(createdScheduler.get().isShutdown()).isTrue();
  }

  @Test
  public void defaultExtractLbPolicyName_extractsFromPackagePrivateAndHandlesMissingMethod() {
    FakeManagedChannel channel =
        new FakeManagedChannel(ConnectivityState.READY, GrpcChannelTelemetry.XDS_LB_POLICY_NAME);
    assertThat(GrpcChannelTelemetry.defaultExtractLbPolicyName(channel))
        .isEqualTo(GrpcChannelTelemetry.XDS_LB_POLICY_NAME);
    assertThat(GrpcChannelTelemetry.defaultExtractLbPolicyName(mock(ManagedChannel.class)))
        .isNull();
    assertThat(GrpcChannelTelemetry.defaultExtractLbPolicyName(null)).isNull();
  }

  @Test
  public void channelReadyCallback_withLatencyRecorder_recordsExpectedHistogramMetric()
      throws Exception {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProviderBuilder providerBuilder =
        OpenTelemetryBootstrappingUtils.registerGrpcChannelViews(
            SdkMeterProvider.builder().registerMetricReader(metricReader));

    try (SdkMeterProvider meterProvider = providerBuilder.build()) {
      BiConsumer<String, Duration> recorder =
          OpenTelemetryBootstrappingUtils.createChannelCreationLatencyRecorder(meterProvider);
      ChannelReadyCallback callback =
          (selectedTransport, latency) -> recorder.accept(selectedTransport.toString(), latency);

      TestApiClock clock = TestApiClock.tickBy(0L, Duration.ofMillis(125));
      FakeManagedChannel channel =
          new FakeManagedChannel(ConnectivityState.READY, GrpcChannelTelemetry.XDS_LB_POLICY_NAME);
      watchInterconnect(channel, Duration.ofSeconds(30), clock, callback).get(5, TimeUnit.SECONDS);

      Collection<MetricData> metrics = metricReader.collectAllMetrics();
      assertThat(metrics).hasSize(1);
      MetricData metricData = metrics.iterator().next();
      assertThat(metricData.getName())
          .isEqualTo(OpenTelemetryBootstrappingUtils.CHANNEL_CREATION_LATENCY_VIEW_NAME);
      HistogramPointData point = metricData.getHistogramData().getPoints().iterator().next();
      assertThat(point.getAttributes().get(OpenTelemetryBootstrappingUtils.TRANSPORT_TYPE_KEY))
          .isEqualTo("DirectPathInterconnect");
      assertThat(point.getCount()).isEqualTo(1L);
      assertThat(point.getSum()).isWithin(1e-6).of(0.125);
    }
  }

  @Test
  public void configureChannelTelemetry_extractsMeterProviderFromGrpcMetricsConfigurator() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProviderBuilder providerBuilder =
        OpenTelemetryBootstrappingUtils.registerGrpcChannelViews(
            SdkMeterProvider.builder().registerMetricReader(metricReader));

    try (SdkMeterProvider meterProvider = providerBuilder.build()) {
      InstantiatingGrpcChannelProvider.Builder channelProviderBuilder =
          InstantiatingGrpcChannelProvider.newBuilder()
              .setEndpoint("storage.googleapis.com:443")
              .setChannelConfigurator(
                  new GrpcMetricsChannelConfigurator(
                      ChannelConfigurator.identity(), meterProvider));
      TestApiClock clock = TestApiClock.tickBy(0L, Duration.ofMillis(80));

      ChannelPrimer primer =
          GrpcChannelTelemetry.configureChannelTelemetry(
              channelProviderBuilder, NoCredentials.getInstance(), false, clock);
      primer.primeChannel(
          new FakeManagedChannel(ConnectivityState.READY, GrpcChannelTelemetry.DNS_LB_POLICY_NAME));

      assertThat(logHandler.records).hasSize(2);
      Collection<MetricData> metrics = metricReader.collectAllMetrics();
      assertThat(metrics).hasSize(1);
      HistogramPointData point =
          metrics.iterator().next().getHistogramData().getPoints().iterator().next();
      assertThat(point.getAttributes().get(OpenTelemetryBootstrappingUtils.TRANSPORT_TYPE_KEY))
          .isEqualTo("CloudPath");
      assertThat(point.getCount()).isEqualTo(1L);
      assertThat(point.getSum()).isWithin(1e-6).of(0.080);
    }
  }

  @Test
  public void startChannelTelemetry_dnsFallback_reportsCloudPath() throws Exception {
    FakeManagedChannel channel =
        new FakeManagedChannel(ConnectivityState.READY, GrpcChannelTelemetry.DNS_LB_POLICY_NAME);
    AtomicReference<TransportType> reportedTransport = new AtomicReference<>();

    watchInterconnect(
            channel,
            Duration.ofSeconds(30),
            NanoClock.getDefaultClock(),
            (transport, latency) -> reportedTransport.set(transport))
        .get(5, TimeUnit.SECONDS);

    assertThat(reportedTransport.get()).isEqualTo(TransportType.CLOUD_PATH);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("transport_type=CloudPath, requested_transport_type=DirectPathInterconnect");
  }

  @Test
  public void isDirectPathInterconnectEnabled_envPrecedence() {
    Object[][] cases = {
      {false, "true", true},
      {false, " TRUE ", true},
      {true, "false", false},
      {true, " FALSE ", false},
      {true, "invalid", true},
      {false, "invalid", false},
      {true, null, true}
    };
    for (Object[] c : cases) {
      boolean builderOption = (Boolean) c[0];
      String envValue = (String) c[1];
      boolean expected = (Boolean) c[2];
      assertWithMessage("builder=%s, env=%s", builderOption, envValue)
          .that(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(builderOption, envValue))
          .isEqualTo(expected);
    }
  }

  @Test
  public void grpcStorageOptions_attemptDirectPathFalse_overridesDirectPathOverInterconnect()
      throws Exception {
    GrpcStorageOptions options =
        StorageOptions.grpc()
            .setAttemptDirectPath(false)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setCredentials(GoogleCredentials.create(new AccessToken("fake-token", null)))
            .build();

    StorageSettings settings = options.getStorageSettings();
    InstantiatingGrpcChannelProvider provider =
        (InstantiatingGrpcChannelProvider)
            settings.getTransportChannelProvider().withCredentials(options.getCredentials());

    assertThat(provider.canUseDirectPath()).isFalse();
    assertThat(GrpcChannelTelemetry.resolveEffectiveTarget(provider, true))
        .isEqualTo("storage.googleapis.com:443");
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
  }

  @Test
  public void grpcStorageOptions_directPathOverInterconnect_resolvesProdDirectTarget()
      throws Exception {
    assumeDirectPathNotDisabledByEnv();
    GrpcStorageOptions options =
        StorageOptions.grpc()
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setCredentials(GoogleCredentials.create(new AccessToken("fake-token", null)))
            .build();
    InstantiatingGrpcChannelProvider provider =
        (InstantiatingGrpcChannelProvider)
            options
                .getStorageSettings()
                .getTransportChannelProvider()
                .withCredentials(options.getCredentials());
    assertThat(GrpcChannelTelemetry.resolveEffectiveTarget(provider, true))
        .isEqualTo(DP_INTERCONNECT_TARGET);
  }

  @Test
  public void grpcStorageOptions_directPathOverInterconnect_resolvesPreprodDirectTarget()
      throws Exception {
    assumeDirectPathNotDisabledByEnv();
    GrpcStorageOptions options =
        StorageOptions.grpc()
            .setHost("https://storage-preprod.sandbox.googleapis.com")
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setCredentials(GoogleCredentials.create(new AccessToken("fake-token", null)))
            .build();
    InstantiatingGrpcChannelProvider provider =
        (InstantiatingGrpcChannelProvider)
            options
                .getStorageSettings()
                .getTransportChannelProvider()
                .withCredentials(options.getCredentials());
    assertThat(GrpcChannelTelemetry.resolveEffectiveTarget(provider, true))
        .isEqualTo("google-c2p:///storage-preprod-direct.sandbox.googleapis.com?force-xds");
  }

  @Test
  public void grpcStorageOptions_noCredentials_fallsBackToCloudPath() throws Exception {
    assumeDirectPathNotDisabledByEnv();
    GrpcStorageOptions options =
        StorageOptions.grpc()
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setCredentials(NoCredentials.getInstance())
            .build();
    InstantiatingGrpcChannelProvider provider =
        (InstantiatingGrpcChannelProvider)
            options.getStorageSettings().getTransportChannelProvider();
    assertThat(GrpcChannelTelemetry.resolveEffectiveTarget(provider, true))
        .isEqualTo("storage.googleapis.com:443");
  }

  private static void assumeDirectPathNotDisabledByEnv() {
    assumeFalse(Boolean.parseBoolean(System.getenv("GOOGLE_CLOUD_DISABLE_DIRECT_PATH")));
  }

  private CompletableFuture<Void> watchInterconnect(
      ManagedChannel channel, Duration timeout, ApiClock clock, ChannelReadyCallback callback) {
    return GrpcChannelTelemetry.startChannelTelemetry(
        new WeakReference<>(channel),
        DP_INTERCONNECT_TARGET,
        true,
        timeout,
        callback,
        scheduler,
        clock,
        FakeManagedChannel::getLbPolicy);
  }

  private static final class FakeManagedChannel extends ManagedChannel {
    private volatile ConnectivityState state;
    private final String lbPolicy;
    private volatile Runnable stateChangeCallback;

    FakeManagedChannel(ConnectivityState initialState, String lbPolicy) {
      this.state = initialState;
      this.lbPolicy = lbPolicy;
    }

    public String getLoadBalancingPolicyName() {
      return lbPolicy;
    }

    static String getLbPolicy(ManagedChannel channel) {
      return channel instanceof FakeManagedChannel ? ((FakeManagedChannel) channel).lbPolicy : null;
    }

    @Override
    public ConnectivityState getState(boolean requestConnection) {
      return state;
    }

    @Override
    public void notifyWhenStateChanged(ConnectivityState source, Runnable callback) {
      if (state != source) {
        callback.run();
      } else {
        this.stateChangeCallback = callback;
      }
    }

    void transitionTo(ConnectivityState newState) {
      this.state = newState;
      Runnable cb = this.stateChangeCallback;
      this.stateChangeCallback = null;
      if (cb != null) {
        cb.run();
      }
    }

    @Override
    public ManagedChannel shutdown() {
      transitionTo(ConnectivityState.SHUTDOWN);
      return this;
    }

    @Override
    public boolean isShutdown() {
      return state == ConnectivityState.SHUTDOWN;
    }

    @Override
    public boolean isTerminated() {
      return state == ConnectivityState.SHUTDOWN;
    }

    @Override
    public ManagedChannel shutdownNow() {
      transitionTo(ConnectivityState.SHUTDOWN);
      return this;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) {
      return true;
    }

    @Override
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
        MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
      throw new UnsupportedOperationException();
    }

    @Override
    public String authority() {
      return "storage-direct.googleapis.com";
    }
  }

  private static final class CapturingLogHandler extends Handler {
    private final List<LogRecord> records = new ArrayList<>();

    @Override
    public void publish(LogRecord record) {
      records.add(record);
    }

    @Override
    public void flush() {}

    @Override
    public void close() {}
  }
}
