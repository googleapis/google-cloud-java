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

import com.google.api.gax.grpc.ChannelPrimer;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.storage.GrpcChannelTelemetry.ChannelReadyCallback;
import com.google.cloud.storage.GrpcChannelTelemetry.TransportType;
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
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public final class GrpcChannelTelemetryTest {

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
    assertThat(GrpcChannelTelemetry.detectTransportType(null)).isEqualTo(TransportType.CLOUD_PATH);
    assertThat(GrpcChannelTelemetry.detectTransportType("")).isEqualTo(TransportType.CLOUD_PATH);
    assertThat(GrpcChannelTelemetry.detectTransportType("storage.googleapis.com:443"))
        .isEqualTo(TransportType.CLOUD_PATH);
    assertThat(GrpcChannelTelemetry.detectTransportType("https://storage.googleapis.com"))
        .isEqualTo(TransportType.CLOUD_PATH);
    assertThat(GrpcChannelTelemetry.detectTransportType("google-c2p:///storage.googleapis.com"))
        .isEqualTo(TransportType.DIRECT_PATH);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p-experimental:///storage.googleapis.com"))
        .isEqualTo(TransportType.DIRECT_PATH);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p:///storage-direct.googleapis.com?force-xds"))
        .isEqualTo(TransportType.DIRECT_PATH_INTERCONNECT);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p:///storage-direct.googleapis.com?foo=1&force-xds=true"))
        .isEqualTo(TransportType.DIRECT_PATH_INTERCONNECT);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p-experimental:///storage-direct.googleapis.com?force-xds"))
        .isEqualTo(TransportType.DIRECT_PATH_INTERCONNECT);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p:///storage.googleapis.com?other=force-xds"))
        .isEqualTo(TransportType.DIRECT_PATH);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p:///storage.googleapis.com#force-xds"))
        .isEqualTo(TransportType.DIRECT_PATH);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p:///storage-direct.googleapis.com?force-xds#section"))
        .isEqualTo(TransportType.DIRECT_PATH_INTERCONNECT);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p:///storage.googleapis.com#frag?force-xds=1"))
        .isEqualTo(TransportType.DIRECT_PATH);
  }

  @Test
  public void c2pTargetHost_authorityHost_isDirectPathInterconnectHost() {
    assertThat(
            GrpcChannelTelemetry.c2pTargetHost(
                "google-c2p:///storage-direct.googleapis.com?force-xds"))
        .isEqualTo("storage-direct.googleapis.com");
    assertThat(
            GrpcChannelTelemetry.c2pTargetHost(
                "google-c2p-experimental:///storage-preprod-direct.sandbox.googleapis.com:443?force-xds"))
        .isEqualTo("storage-preprod-direct.sandbox.googleapis.com");
    assertThat(GrpcChannelTelemetry.c2pTargetHost("google-c2p:///storage.googleapis.com/path"))
        .isEqualTo("storage.googleapis.com");
    assertThat(GrpcChannelTelemetry.c2pTargetHost("google-c2p:///storage.googleapis.com#frag"))
        .isEqualTo("storage.googleapis.com");
    assertThat(GrpcChannelTelemetry.c2pTargetHost("storage.googleapis.com:443")).isEmpty();
    assertThat(GrpcChannelTelemetry.c2pTargetHost(null)).isEmpty();

    assertThat(GrpcChannelTelemetry.authorityHost("storage-direct.googleapis.com:443"))
        .isEqualTo("storage-direct.googleapis.com");
    assertThat(GrpcChannelTelemetry.authorityHost("storage-direct.googleapis.com"))
        .isEqualTo("storage-direct.googleapis.com");
    assertThat(GrpcChannelTelemetry.authorityHost(null)).isEmpty();
    assertThat(GrpcChannelTelemetry.authorityHost("")).isEmpty();

    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectHost("storage-direct.googleapis.com"))
        .isTrue();
    assertThat(
            GrpcChannelTelemetry.isDirectPathInterconnectHost("storage-direct.googleapis.com:443"))
        .isTrue();
    assertThat(
            GrpcChannelTelemetry.isDirectPathInterconnectHost(
                "storage-preprod-direct.sandbox.googleapis.com"))
        .isTrue();
    assertThat(
            GrpcChannelTelemetry.isDirectPathInterconnectHost(
                "storage-preprod-direct.sandbox.googleapis.com:443"))
        .isTrue();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectHost("storage.googleapis.com"))
        .isFalse();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectHost("custom.example.com")).isFalse();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectHost(null)).isFalse();
  }

  @Test
  public void selectedTransportType_allCases() {
    assertThat(GrpcChannelTelemetry.selectedTransportType(TransportType.CLOUD_PATH, null, true))
        .isEqualTo(TransportType.CLOUD_PATH);
    assertThat(
            GrpcChannelTelemetry.selectedTransportType(
                TransportType.CLOUD_PATH, GrpcChannelTelemetry.XDS_LB_POLICY_NAME, true))
        .isEqualTo(TransportType.CLOUD_PATH);
    assertThat(
            GrpcChannelTelemetry.selectedTransportType(
                TransportType.DIRECT_PATH, GrpcChannelTelemetry.XDS_LB_POLICY_NAME, true))
        .isEqualTo(TransportType.DIRECT_PATH);
    assertThat(
            GrpcChannelTelemetry.selectedTransportType(
                TransportType.DIRECT_PATH, GrpcChannelTelemetry.DNS_LB_POLICY_NAME, true))
        .isEqualTo(TransportType.CLOUD_PATH);
    assertThat(
            GrpcChannelTelemetry.selectedTransportType(
                TransportType.DIRECT_PATH_INTERCONNECT,
                GrpcChannelTelemetry.XDS_LB_POLICY_NAME,
                true))
        .isEqualTo(TransportType.DIRECT_PATH_INTERCONNECT);
    assertThat(
            GrpcChannelTelemetry.selectedTransportType(
                TransportType.DIRECT_PATH_INTERCONNECT,
                GrpcChannelTelemetry.DNS_LB_POLICY_NAME,
                true))
        .isEqualTo(TransportType.CLOUD_PATH);
    assertThat(
            GrpcChannelTelemetry.selectedTransportType(
                TransportType.DIRECT_PATH_INTERCONNECT,
                GrpcChannelTelemetry.XDS_LB_POLICY_NAME,
                false))
        .isEqualTo(TransportType.DIRECT_PATH);
  }

  @Test
  public void logChannelConfiguration_validConfigurations_logInfo() {
    GrpcChannelTelemetry.logChannelConfiguration(
        "storage.googleapis.com:443", "storage.googleapis.com", false, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.INFO);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("Configured gRPC transport. requested_transport_type=CloudPath");

    logHandler.clear();
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage.googleapis.com", "storage.googleapis.com", false, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.INFO);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("Configured gRPC transport. requested_transport_type=DirectPath");

    logHandler.clear();
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage-direct.googleapis.com?force-xds", null, true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.INFO);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("Configured gRPC transport. requested_transport_type=DirectPathInterconnect");
    assertThat(logHandler.records.get(0).getMessage())
        .contains("authority=storage-direct.googleapis.com");

    logHandler.clear();
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage-preprod-direct.sandbox.googleapis.com?force-xds", null, true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.INFO);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("authority=storage-preprod-direct.sandbox.googleapis.com");
  }

  @Test
  public void logChannelConfiguration_warnings() {
    // Priority 1: gRPC version does not support force-xds
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage-direct.googleapis.com?force-xds", null, true, false);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("DirectPath over Interconnect requires a gRPC version supporting force-xds");

    // Priority 2: interconnectEnabled = true, but effectiveEndpoint is CloudPath or DirectPath
    logHandler.clear();
    GrpcChannelTelemetry.logChannelConfiguration(
        "storage.googleapis.com:443", "storage.googleapis.com", true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains(
            "DirectPath over Interconnect is enabled, but the effective endpoint does not request"
                + " it.");
    assertThat(logHandler.records.get(0).getMessage())
        .contains("requested_transport_type=CloudPath");

    logHandler.clear();
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage.googleapis.com", "storage.googleapis.com", true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("requested_transport_type=DirectPath");

    // Priority 3: force-xds active, but authority is not a -direct host
    logHandler.clear();
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage.googleapis.com?force-xds", "storage.googleapis.com", true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains(
            "DirectPath over Interconnect is active, but the channel authority is not a DirectPath"
                + " over Interconnect host");
  }

  @Test
  public void logChannelReady_and_channelReadyNote() {
    // Ready on DirectPathInterconnect
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

    // Ready with DNS fallback (pick_first)
    logHandler.clear();
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

    // Ready with unexpected LB policy
    logHandler.clear();
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

    // Not ready on DirectPathInterconnect
    logHandler.clear();
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
        .contains("GRPC_VERBOSITY=debug GRPC_TRACE=xds_client,xds_resolver,c2p_resolver");
  }

  @Test
  public void startChannelTelemetry_immediateReady_invokesCallbackOnce() throws Exception {
    FakeManagedChannel channel =
        new FakeManagedChannel(ConnectivityState.READY, GrpcChannelTelemetry.XDS_LB_POLICY_NAME);
    AtomicLong clockNanos = new AtomicLong(1_000_000_000L);
    AtomicInteger callbackCount = new AtomicInteger(0);
    AtomicReference<TransportType> reportedTransport = new AtomicReference<>();
    AtomicReference<Duration> reportedLatency = new AtomicReference<>();

    GrpcChannelTelemetry.startChannelTelemetry(
            new WeakReference<>(channel),
            "google-c2p:///storage-direct.googleapis.com?force-xds",
            true,
            Duration.ofSeconds(30),
            (transport, latency) -> {
              callbackCount.incrementAndGet();
              reportedTransport.set(transport);
              reportedLatency.set(latency);
            },
            scheduler,
            () -> clockNanos.addAndGet(25_000_000L),
            FakeManagedChannel::getLbPolicy)
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
    AtomicLong clockNanos = new AtomicLong(0L);
    AtomicInteger callbackCount = new AtomicInteger(0);
    AtomicReference<TransportType> reportedTransport = new AtomicReference<>();
    AtomicReference<Duration> reportedLatency = new AtomicReference<>();

    CompletableFuture<Void> future =
        GrpcChannelTelemetry.startChannelTelemetry(
            new WeakReference<>(channel),
            "google-c2p:///storage-direct.googleapis.com?force-xds",
            true,
            Duration.ofSeconds(30),
            (transport, latency) -> {
              callbackCount.incrementAndGet();
              reportedTransport.set(transport);
              reportedLatency.set(latency);
            },
            scheduler,
            clockNanos::get,
            FakeManagedChannel::getLbPolicy);

    assertThat(callbackCount.get()).isEqualTo(0);

    clockNanos.set(10_000_000L);
    channel.transitionTo(ConnectivityState.CONNECTING);
    assertThat(callbackCount.get()).isEqualTo(0);

    clockNanos.set(55_000_000L);
    channel.transitionTo(ConnectivityState.READY);
    future.get(5, TimeUnit.SECONDS);

    assertThat(callbackCount.get()).isEqualTo(1);
    assertThat(reportedTransport.get()).isEqualTo(TransportType.DIRECT_PATH_INTERCONNECT);
    assertThat(reportedLatency.get()).isEqualTo(Duration.ofMillis(55));
  }

  @Test
  public void startChannelTelemetry_shutdownBeforeReady_doesNotInvokeCallback() throws Exception {
    FakeManagedChannel channel = new FakeManagedChannel(ConnectivityState.CONNECTING, null);
    AtomicInteger callbackCount = new AtomicInteger(0);

    CompletableFuture<Void> future =
        GrpcChannelTelemetry.startChannelTelemetry(
            new WeakReference<>(channel),
            "google-c2p:///storage-direct.googleapis.com?force-xds",
            true,
            Duration.ofSeconds(30),
            (transport, latency) -> callbackCount.incrementAndGet(),
            scheduler,
            System::nanoTime,
            FakeManagedChannel::getLbPolicy);

    channel.transitionTo(ConnectivityState.SHUTDOWN);
    future.get(5, TimeUnit.SECONDS);

    assertThat(callbackCount.get()).isEqualTo(0);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("status=channel shut down before becoming ready");
  }

  @Test
  public void startChannelTelemetry_timeoutBeforeReady_doesNotInvokeCallback() throws Exception {
    FakeManagedChannel channel = new FakeManagedChannel(ConnectivityState.CONNECTING, null);
    AtomicInteger callbackCount = new AtomicInteger(0);

    CompletableFuture<Void> future =
        GrpcChannelTelemetry.startChannelTelemetry(
            new WeakReference<>(channel),
            "google-c2p:///storage-direct.googleapis.com?force-xds",
            true,
            Duration.ofMillis(20),
            (transport, latency) -> callbackCount.incrementAndGet(),
            scheduler,
            System::nanoTime,
            FakeManagedChannel::getLbPolicy);

    future.get(5, TimeUnit.SECONDS);

    assertThat(callbackCount.get()).isEqualTo(0);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getMessage()).contains("status=DEADLINE_EXCEEDED");
  }

  @Test
  public void startChannelTelemetry_clearedWeakReference_doesNotInvokeCallback() throws Exception {
    WeakReference<ManagedChannel> clearedRef = new WeakReference<>(null);
    AtomicInteger callbackCount = new AtomicInteger(0);

    GrpcChannelTelemetry.startChannelTelemetry(
            clearedRef,
            "google-c2p:///storage-direct.googleapis.com?force-xds",
            true,
            Duration.ofSeconds(30),
            (transport, latency) -> callbackCount.incrementAndGet(),
            scheduler,
            System::nanoTime,
            ch -> null)
        .get(5, TimeUnit.SECONDS);

    assertThat(callbackCount.get()).isEqualTo(0);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("status=channel destroyed before becoming ready");
  }

  @Test
  public void createChannelPrimer_onlyObservesFirstChannel() {
    AtomicInteger callbackCount = new AtomicInteger(0);
    ChannelPrimer primer =
        GrpcChannelTelemetry.createChannelPrimer(
            "google-c2p:///storage-direct.googleapis.com?force-xds",
            true,
            (transport, latency) -> callbackCount.incrementAndGet());

    FakeManagedChannel ch0 =
        new FakeManagedChannel(ConnectivityState.READY, GrpcChannelTelemetry.XDS_LB_POLICY_NAME);
    FakeManagedChannel ch1 =
        new FakeManagedChannel(ConnectivityState.READY, GrpcChannelTelemetry.XDS_LB_POLICY_NAME);

    primer.primeChannel(ch0);
    primer.primeChannel(ch1);

    assertThat(callbackCount.get()).isEqualTo(1);
    assertThat(logHandler.records).hasSize(1);
  }

  @Test
  public void makeChannelMetricsCallback_recordsExpectedHistogramMetric() {
    ChannelReadyCallback noopCallback = GrpcChannelTelemetry.makeChannelMetricsCallback(null);
    noopCallback.onChannelReady(TransportType.CLOUD_PATH, Duration.ofMillis(10));

    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProviderBuilder providerBuilder =
        SdkMeterProvider.builder().registerMetricReader(metricReader);
    OpenTelemetryBootstrappingUtils.registerGrpcChannelViews(providerBuilder);

    try (SdkMeterProvider meterProvider = providerBuilder.build()) {
      ChannelReadyCallback callback =
          GrpcChannelTelemetry.makeChannelMetricsCallback(meterProvider);
      callback.onChannelReady(TransportType.DIRECT_PATH_INTERCONNECT, Duration.ofMillis(125));
      callback.onChannelReady(TransportType.DIRECT_PATH, Duration.ofMillis(50));
      callback.onChannelReady(TransportType.CLOUD_PATH, Duration.ofMillis(250));

      Collection<MetricData> metrics = metricReader.collectAllMetrics();
      assertThat(metrics).hasSize(1);
      MetricData metricData = metrics.iterator().next();
      assertThat(metricData.getName())
          .isEqualTo(GrpcChannelTelemetry.CHANNEL_CREATION_LATENCY_VIEW_NAME);
      assertThat(metricData.getUnit())
          .isEqualTo(GrpcChannelTelemetry.CHANNEL_CREATION_LATENCY_UNIT);
      assertThat(metricData.getDescription())
          .isEqualTo(GrpcChannelTelemetry.CHANNEL_CREATION_LATENCY_DESCRIPTION);

      Collection<HistogramPointData> points = metricData.getHistogramData().getPoints();
      assertThat(points).hasSize(3);
      for (HistogramPointData point : points) {
        String transportType = point.getAttributes().get(GrpcChannelTelemetry.TRANSPORT_TYPE_KEY);
        assertThat(point.getCount()).isEqualTo(1);
        if ("DirectPathInterconnect".equals(transportType)) {
          assertThat(point.getSum()).isWithin(1e-6).of(0.125);
        } else if ("DirectPath".equals(transportType)) {
          assertThat(point.getSum()).isWithin(1e-6).of(0.050);
        } else if ("CloudPath".equals(transportType)) {
          assertThat(point.getSum()).isWithin(1e-6).of(0.250);
        } else {
          throw new AssertionError("Unexpected transport_type: " + transportType);
        }
      }
    }
  }

  @Test
  public void startChannelTelemetry_dnsFallback_reportsCloudPath() throws Exception {
    FakeManagedChannel channel =
        new FakeManagedChannel(ConnectivityState.READY, GrpcChannelTelemetry.DNS_LB_POLICY_NAME);
    AtomicReference<TransportType> reportedTransport = new AtomicReference<>();

    GrpcChannelTelemetry.startChannelTelemetry(
            new WeakReference<>(channel),
            "google-c2p:///storage-direct.googleapis.com?force-xds",
            true,
            Duration.ofSeconds(30),
            (transport, latency) -> reportedTransport.set(transport),
            scheduler,
            System::nanoTime,
            FakeManagedChannel::getLbPolicy)
        .get(5, TimeUnit.SECONDS);

    assertThat(reportedTransport.get()).isEqualTo(TransportType.CLOUD_PATH);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("transport_type=CloudPath, requested_transport_type=DirectPathInterconnect");
  }

  @Test
  public void isDirectPathInterconnectEnabled_envPrecedence() {
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(false, "true")).isTrue();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(false, " TRUE ")).isTrue();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(true, "false")).isFalse();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(true, " FALSE ")).isFalse();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(true, "invalid")).isTrue();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(false, "invalid")).isFalse();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(true, null)).isTrue();
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

    if (!Boolean.parseBoolean(System.getenv("GOOGLE_CLOUD_DISABLE_DIRECT_PATH"))) {
      GrpcStorageOptions enabledOptions =
          StorageOptions.grpc()
              .setAttemptDirectPathXdsOverInterconnect(true)
              .setCredentials(GoogleCredentials.create(new AccessToken("fake-token", null)))
              .build();
      InstantiatingGrpcChannelProvider enabledProvider =
          (InstantiatingGrpcChannelProvider)
              enabledOptions
                  .getStorageSettings()
                  .getTransportChannelProvider()
                  .withCredentials(enabledOptions.getCredentials());
      assertThat(GrpcChannelTelemetry.resolveEffectiveTarget(enabledProvider, true))
          .isEqualTo("google-c2p:///storage-direct.googleapis.com?force-xds");

      GrpcStorageOptions preprodOptions =
          StorageOptions.grpc()
              .setHost("https://storage-preprod.sandbox.googleapis.com")
              .setAttemptDirectPathXdsOverInterconnect(true)
              .setCredentials(GoogleCredentials.create(new AccessToken("fake-token", null)))
              .build();
      InstantiatingGrpcChannelProvider preprodProvider =
          (InstantiatingGrpcChannelProvider)
              preprodOptions
                  .getStorageSettings()
                  .getTransportChannelProvider()
                  .withCredentials(preprodOptions.getCredentials());
      assertThat(GrpcChannelTelemetry.resolveEffectiveTarget(preprodProvider, true))
          .isEqualTo("google-c2p:///storage-preprod-direct.sandbox.googleapis.com?force-xds");

      GrpcStorageOptions unauthenticatedOptions =
          StorageOptions.grpc()
              .setAttemptDirectPathXdsOverInterconnect(true)
              .setCredentials(NoCredentials.getInstance())
              .build();
      InstantiatingGrpcChannelProvider unauthenticatedProvider =
          (InstantiatingGrpcChannelProvider)
              unauthenticatedOptions.getStorageSettings().getTransportChannelProvider();
      assertThat(GrpcChannelTelemetry.resolveEffectiveTarget(unauthenticatedProvider, true))
          .isEqualTo("storage.googleapis.com:443");
    }
  }

  private static final class FakeManagedChannel extends ManagedChannel {
    private ConnectivityState state;
    private final String lbPolicy;
    private Runnable stateChangeCallback;

    FakeManagedChannel(ConnectivityState initialState, String lbPolicy) {
      this.state = initialState;
      this.lbPolicy = lbPolicy;
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

    void clear() {
      records.clear();
    }
  }
}
