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

import com.google.api.core.ApiClock;
import com.google.api.core.ApiFunction;
import com.google.api.core.NanoClock;
import com.google.api.gax.grpc.ChannelPrimer;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.auth.Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.storage.OpenTelemetryBootstrappingUtils.GrpcMetricsChannelConfigurator;
import com.google.common.annotations.VisibleForTesting;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.internal.GrpcUtil;
import io.opentelemetry.api.metrics.MeterProvider;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Package-private telemetry and diagnostics for gRPC channels, supporting CloudPath, DirectPath,
 * and DirectPath over Cloud Interconnect.
 */
final class GrpcChannelTelemetry {

  static final String C2P_PREFIX = "google-c2p:///";
  static final String C2P_EXPERIMENTAL_PREFIX = "google-c2p-experimental:///";
  static final String FORCE_XDS_PARAM = "force-xds";
  static final String DIRECT_PATH_INTERCONNECT_HOST = "storage-direct.googleapis.com";
  static final String DIRECT_PATH_INTERCONNECT_PREPROD_HOST =
      "storage-preprod-direct.sandbox.googleapis.com";
  static final String XDS_LB_POLICY_NAME = "xds_cluster_manager_experimental";
  static final String DNS_LB_POLICY_NAME = "pick_first";
  static final Duration DEFAULT_CHANNEL_READY_TIMEOUT = Duration.ofSeconds(30);

  @VisibleForTesting
  static final Logger LOG = Logger.getLogger(GrpcChannelTelemetry.class.getName());

  private static final String DIRECT_PATH_INTERCONNECT_INFIX = "-direct.";
  private static final String ENV_ENABLE_DIRECT_PATH_XDS_OVER_INTERCONNECT =
      "GOOGLE_CLOUD_ENABLE_DIRECT_PATH_XDS_OVER_INTERCONNECT";
  private static final boolean GRPC_FORCE_XDS_SUPPORTED = detectGrpcForceXdsSupport();

  /** The transport used to reach the GCS service. */
  enum TransportType {
    CLOUD_PATH("CloudPath"),
    DIRECT_PATH("DirectPath"),
    DIRECT_PATH_INTERCONNECT("DirectPathInterconnect");

    private final String label;

    TransportType(String label) {
      this.label = label;
    }

    @Override
    public String toString() {
      return label;
    }
  }

  /**
   * Callback invoked once the first gRPC channel transitions to {@link ConnectivityState#READY}.
   */
  @FunctionalInterface
  interface ChannelReadyCallback {
    void onChannelReady(TransportType selectedTransport, Duration latency);
  }

  static boolean hasQueryParameter(@Nullable String uri, String key) {
    if (uri == null || key == null) {
      return false;
    }
    int fragmentPos = uri.indexOf('#');
    String addressable = fragmentPos >= 0 ? uri.substring(0, fragmentPos) : uri;
    int queryPos = addressable.indexOf('?');
    if (queryPos < 0) {
      return false;
    }
    String query = addressable.substring(queryPos + 1);
    int start = 0;
    while (start <= query.length()) {
      int ampPos = query.indexOf('&', start);
      String param = ampPos >= 0 ? query.substring(start, ampPos) : query.substring(start);
      int eqPos = param.indexOf('=');
      String paramName = eqPos >= 0 ? param.substring(0, eqPos) : param;
      if (paramName.equals(key)) {
        return true;
      }
      if (ampPos < 0) {
        break;
      }
      start = ampPos + 1;
    }
    return false;
  }

  static TransportType detectTransportType(@Nullable String endpoint) {
    if (endpoint == null
        || (!endpoint.startsWith(C2P_PREFIX) && !endpoint.startsWith(C2P_EXPERIMENTAL_PREFIX))) {
      return TransportType.CLOUD_PATH;
    }
    if (hasQueryParameter(endpoint, FORCE_XDS_PARAM)) {
      return TransportType.DIRECT_PATH_INTERCONNECT;
    }
    return TransportType.DIRECT_PATH;
  }

  static String extractHost(@Nullable String endpointOrAuthority) {
    String extracted = OpenTelemetryBootstrappingUtils.extractServerAddress(endpointOrAuthority);
    return extracted != null ? extracted : "";
  }

  static boolean isDirectPathInterconnectHost(@Nullable String host) {
    String h = extractHost(host);
    return DIRECT_PATH_INTERCONNECT_HOST.equals(h)
        || DIRECT_PATH_INTERCONNECT_PREPROD_HOST.equals(h);
  }

  static TransportType selectedTransportType(
      TransportType requestedTransport,
      @Nullable String lbPolicyName,
      boolean grpcSupportsForceXds) {
    if (requestedTransport == TransportType.CLOUD_PATH || DNS_LB_POLICY_NAME.equals(lbPolicyName)) {
      return TransportType.CLOUD_PATH;
    }
    if (requestedTransport == TransportType.DIRECT_PATH_INTERCONNECT && !grpcSupportsForceXds) {
      return TransportType.DIRECT_PATH;
    }
    return requestedTransport;
  }

  static boolean grpcForceXdsIsSupported() {
    return GRPC_FORCE_XDS_SUPPORTED;
  }

  static boolean isDirectPathInterconnectEnabled(boolean attemptDirectPathXdsOverInterconnect) {
    return isDirectPathInterconnectEnabled(
        attemptDirectPathXdsOverInterconnect,
        System.getenv(ENV_ENABLE_DIRECT_PATH_XDS_OVER_INTERCONNECT));
  }

  @VisibleForTesting
  static boolean isDirectPathInterconnectEnabled(
      boolean attemptDirectPathXdsOverInterconnect, @Nullable String envValue) {
    if (envValue != null) {
      String trimmed = envValue.trim();
      if ("true".equalsIgnoreCase(trimmed)) {
        return true;
      }
      if ("false".equalsIgnoreCase(trimmed)) {
        return false;
      }
    }
    return attemptDirectPathXdsOverInterconnect;
  }

  static String resolveEffectiveTarget(
      InstantiatingGrpcChannelProvider provider, boolean interconnectEnabled) {
    String endpoint = provider.getEndpoint();
    if (endpoint == null) {
      return "";
    }
    if (endpoint.startsWith(C2P_PREFIX) || endpoint.startsWith(C2P_EXPERIMENTAL_PREFIX)) {
      return endpoint;
    }
    if (!provider.needsCredentials()
        && provider.canUseDirectPath()
        && provider.isDirectPathXdsEnabled()) {
      String serviceAddress = extractHost(endpoint);
      if (interconnectEnabled) {
        return C2P_PREFIX
            + rewriteDirectPathInterconnectHost(serviceAddress)
            + "?"
            + FORCE_XDS_PARAM;
      }
      return C2P_PREFIX + serviceAddress;
    }
    return endpoint;
  }

  @SuppressWarnings("rawtypes") // ManagedChannelBuilder
  static ChannelPrimer configureChannelTelemetry(
      InstantiatingGrpcChannelProvider.Builder channelProviderBuilder,
      @Nullable Credentials credentials,
      boolean attemptDirectPathXdsOverInterconnect,
      @Nullable ApiClock clock) {
    InstantiatingGrpcChannelProvider baseProvider = channelProviderBuilder.build();
    String effectiveTarget =
        logChannelConfiguration(baseProvider, credentials, attemptDirectPathXdsOverInterconnect);
    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> configurator =
        channelProviderBuilder.getChannelConfigurator();
    MeterProvider grpcMeterProvider =
        configurator instanceof GrpcMetricsChannelConfigurator
            ? ((GrpcMetricsChannelConfigurator) configurator).get()
            : null;
    BiConsumer<String, Duration> latencyRecorder =
        OpenTelemetryBootstrappingUtils.createChannelCreationLatencyRecorder(grpcMeterProvider);
    ChannelReadyCallback onReady =
        (selectedTransport, latency) ->
            latencyRecorder.accept(selectedTransport.toString(), latency);
    ChannelPrimer primer =
        createChannelPrimer(
            effectiveTarget,
            grpcForceXdsIsSupported(),
            onReady,
            clock != null ? clock : NanoClock.getDefaultClock(),
            GrpcChannelTelemetry::newTelemetryScheduler);
    channelProviderBuilder.setChannelPrimer(primer);
    return primer;
  }

  static String logChannelConfiguration(
      InstantiatingGrpcChannelProvider baseProvider,
      @Nullable Credentials credentials,
      boolean attemptDirectPathXdsOverInterconnect) {
    InstantiatingGrpcChannelProvider telemetryProvider =
        (credentials == null || credentials instanceof NoCredentials)
            ? baseProvider
            : (InstantiatingGrpcChannelProvider) baseProvider.withCredentials(credentials);
    boolean interconnectEnabled =
        isDirectPathInterconnectEnabled(attemptDirectPathXdsOverInterconnect);
    boolean grpcSupportsForceXds = grpcForceXdsIsSupported();
    String effectiveTarget = resolveEffectiveTarget(telemetryProvider, interconnectEnabled);
    logChannelConfiguration(effectiveTarget, interconnectEnabled, grpcSupportsForceXds);
    return effectiveTarget;
  }

  static void logChannelConfiguration(
      String effectiveEndpoint, boolean interconnectEnabled, boolean grpcSupportsForceXds) {
    TransportType requestedTransport = detectTransportType(effectiveEndpoint);
    String effectiveAuthority = extractHost(effectiveEndpoint);
    String grpcVersion = GrpcUtil.getGrpcBuildVersion().toString();

    if (!grpcSupportsForceXds
        && (interconnectEnabled || requestedTransport == TransportType.DIRECT_PATH_INTERCONNECT)) {
      LOG.log(
          Level.WARNING,
          "DirectPath over Interconnect requires a gRPC version supporting force-xds (found "
              + grpcVersion
              + "). The force-xds query parameter will be ignored by the google-c2p resolver;"
              + " outside GCE this channel will fall back to CloudPath, and on GCE it will use"
              + " standard DirectPath. endpoint="
              + effectiveEndpoint);
      return;
    }
    if (interconnectEnabled && requestedTransport != TransportType.DIRECT_PATH_INTERCONNECT) {
      LOG.log(
          Level.WARNING,
          "DirectPath over Interconnect is enabled, but the effective endpoint does not request"
              + " it. Check whether a custom endpoint, non-default universe domain, disabled"
              + " DirectPath, or unauthenticated credentials overrode the DirectPath over"
              + " Interconnect target. requested_transport_type="
              + requestedTransport
              + ", endpoint="
              + effectiveEndpoint);
      return;
    }
    if (requestedTransport == TransportType.DIRECT_PATH_INTERCONNECT
        && !isDirectPathInterconnectHost(effectiveAuthority)) {
      LOG.log(
          Level.WARNING,
          "DirectPath over Interconnect is active, but the channel authority is not a DirectPath"
              + " over Interconnect host; the service will route RPCs as standard DirectPath. Use '"
              + DIRECT_PATH_INTERCONNECT_HOST
              + "' (or '"
              + DIRECT_PATH_INTERCONNECT_PREPROD_HOST
              + "' in preprod). requested_transport_type="
              + requestedTransport
              + ", endpoint="
              + effectiveEndpoint
              + ", authority="
              + effectiveAuthority
              + ", grpc_version="
              + grpcVersion);
      return;
    }
    LOG.log(
        Level.INFO,
        "Configured gRPC transport. requested_transport_type="
            + requestedTransport
            + ", endpoint="
            + effectiveEndpoint
            + ", authority="
            + effectiveAuthority
            + ", grpc_version="
            + grpcVersion);
  }

  static String channelReadyNote(
      TransportType requestedTransport,
      TransportType selectedTransport,
      @Nullable String lbPolicyName,
      boolean ready) {
    if (!ready) {
      if (requestedTransport == TransportType.DIRECT_PATH_INTERCONNECT) {
        return " Verify that TD bootstrap and xDS reachability are configured, or enable FINE"
            + " java.util.logging for io.grpc.xds and io.grpc.googleapis.";
      }
      if (requestedTransport == TransportType.DIRECT_PATH) {
        return " Enable FINE java.util.logging for io.grpc.xds and io.grpc.googleapis.";
      }
      return "";
    }
    if (requestedTransport != TransportType.CLOUD_PATH
        && selectedTransport == TransportType.CLOUD_PATH) {
      return " Note: google-c2p resolver fell back to DNS ("
          + DNS_LB_POLICY_NAME
          + "); traffic is using CloudPath instead of "
          + requestedTransport
          + ".";
    }
    if (requestedTransport != TransportType.CLOUD_PATH
        && lbPolicyName != null
        && !lbPolicyName.isEmpty()
        && !XDS_LB_POLICY_NAME.equals(lbPolicyName)
        && !DNS_LB_POLICY_NAME.equals(lbPolicyName)) {
      return " Note: unexpected LB policy '"
          + lbPolicyName
          + "' for "
          + requestedTransport
          + " (expected '"
          + XDS_LB_POLICY_NAME
          + "').";
    }
    return "";
  }

  static void logChannelReady(
      TransportType requestedTransport,
      TransportType selectedTransport,
      @Nullable String lbPolicyName,
      Duration elapsed,
      boolean ready,
      @Nullable String statusDescription) {
    String lb = (lbPolicyName == null || lbPolicyName.isEmpty()) ? "unknown" : lbPolicyName;
    String note = channelReadyNote(requestedTransport, selectedTransport, lbPolicyName, ready);
    long elapsedMs = elapsed.toMillis();
    if (ready) {
      LOG.log(
          Level.INFO,
          "gRPC channel [0] is ready. transport_type="
              + selectedTransport
              + ", requested_transport_type="
              + requestedTransport
              + ", lb_policy="
              + lb
              + ", elapsed_ms="
              + elapsedMs
              + note);
    } else {
      LOG.log(
          Level.INFO,
          "gRPC channel [0] did not become ready before deadline. transport_type="
              + selectedTransport
              + ", requested_transport_type="
              + requestedTransport
              + ", lb_policy="
              + lb
              + ", elapsed_ms="
              + elapsedMs
              + (statusDescription != null && !statusDescription.isEmpty()
                  ? ", status=" + statusDescription
                  : "")
              + note);
    }
  }

  static CompletableFuture<Void> startChannelTelemetry(
      ManagedChannel channel,
      String effectiveEndpoint,
      boolean grpcSupportsForceXds,
      Duration timeout,
      @Nullable ChannelReadyCallback onReady,
      ApiClock clock,
      ScheduledExecutorService scheduler) {
    return startChannelTelemetry(
        new WeakReference<>(channel),
        effectiveEndpoint,
        grpcSupportsForceXds,
        timeout,
        onReady,
        scheduler,
        clock,
        GrpcChannelTelemetry::defaultExtractLbPolicyName);
  }

  @VisibleForTesting
  static CompletableFuture<Void> startChannelTelemetry(
      WeakReference<ManagedChannel> channelRef,
      String effectiveEndpoint,
      boolean grpcSupportsForceXds,
      Duration timeout,
      @Nullable ChannelReadyCallback onReady,
      ScheduledExecutorService scheduler,
      ApiClock clock,
      Function<ManagedChannel, @Nullable String> lbPolicyExtractor) {
    TransportType requestedTransport = detectTransportType(effectiveEndpoint);
    ChannelReadyWatcher watcher =
        new ChannelReadyWatcher(
            channelRef,
            requestedTransport,
            grpcSupportsForceXds,
            timeout,
            onReady,
            scheduler,
            clock,
            lbPolicyExtractor);
    return watcher.start();
  }

  static ChannelPrimer createChannelPrimer(
      String effectiveEndpoint,
      boolean grpcSupportsForceXds,
      @Nullable ChannelReadyCallback onReady,
      ApiClock clock,
      Supplier<ScheduledExecutorService> ownedSchedulerSupplier) {
    AtomicBoolean firstChannelObserved = new AtomicBoolean(false);
    return managedChannel -> {
      if (firstChannelObserved.compareAndSet(false, true)) {
        ScheduledExecutorService scheduler = ownedSchedulerSupplier.get();
        startChannelTelemetry(
                managedChannel,
                effectiveEndpoint,
                grpcSupportsForceXds,
                DEFAULT_CHANNEL_READY_TIMEOUT,
                onReady,
                clock,
                scheduler)
            .whenComplete((unused, error) -> scheduler.shutdown());
      }
    };
  }

  private GrpcChannelTelemetry() {}

  private static ScheduledExecutorService newTelemetryScheduler() {
    ScheduledThreadPoolExecutor executor =
        new ScheduledThreadPoolExecutor(
            1,
            runnable -> {
              Thread t = new Thread(runnable, "gcs-grpc-channel-telemetry");
              t.setDaemon(true);
              return t;
            });
    executor.setKeepAliveTime(5L, TimeUnit.SECONDS);
    executor.allowCoreThreadTimeOut(true);
    executor.setRemoveOnCancelPolicy(true);
    return executor;
  }

  private static boolean detectGrpcForceXdsSupport() {
    try {
      Class<?> clazz = Class.forName("io.grpc.googleapis.GoogleCloudToProdNameResolver");
      clazz.getDeclaredField("forceXds");
      return true;
    } catch (Throwable e) {
      return false;
    }
  }

  private static String rewriteDirectPathInterconnectHost(String serviceAddress) {
    if (!serviceAddress.contains(DIRECT_PATH_INTERCONNECT_INFIX)) {
      int dotIndex = serviceAddress.indexOf('.');
      if (dotIndex > 0) {
        return serviceAddress.substring(0, dotIndex)
            + DIRECT_PATH_INTERCONNECT_INFIX
            + serviceAddress.substring(dotIndex + 1);
      }
    }
    return serviceAddress;
  }

  @Nullable
  static String defaultExtractLbPolicyName(@Nullable ManagedChannel channel) {
    if (channel == null) {
      return null;
    }
    try {
      Method m = channel.getClass().getMethod("getLoadBalancingPolicyName");
      m.setAccessible(true);
      Object result = m.invoke(channel);
      if (result instanceof String) {
        return (String) result;
      }
    } catch (Exception ignored) {
      // Standard io.grpc.ManagedChannel does not expose getLoadBalancingPolicyName publicly.
    }
    return null;
  }

  private static final class ChannelReadyWatcher {
    private final WeakReference<ManagedChannel> channelRef;
    private final TransportType requestedTransport;
    private final boolean grpcSupportsForceXds;
    private final Duration timeout;
    @Nullable private final ChannelReadyCallback onReady;
    private final ScheduledExecutorService scheduler;
    private final ApiClock clock;
    private final Function<ManagedChannel, @Nullable String> lbPolicyExtractor;
    private final AtomicBoolean completed = new AtomicBoolean(false);
    private final CompletableFuture<Void> completionFuture = new CompletableFuture<>();
    private volatile long startNanos;
    @Nullable private volatile ScheduledFuture<?> timeoutFuture;

    ChannelReadyWatcher(
        WeakReference<ManagedChannel> channelRef,
        TransportType requestedTransport,
        boolean grpcSupportsForceXds,
        Duration timeout,
        @Nullable ChannelReadyCallback onReady,
        ScheduledExecutorService scheduler,
        ApiClock clock,
        Function<ManagedChannel, @Nullable String> lbPolicyExtractor) {
      this.channelRef = channelRef;
      this.requestedTransport = requestedTransport;
      this.grpcSupportsForceXds = grpcSupportsForceXds;
      this.timeout = timeout;
      this.onReady = onReady;
      this.scheduler = scheduler;
      this.clock = clock;
      this.lbPolicyExtractor = lbPolicyExtractor;
    }

    CompletableFuture<Void> start() {
      this.startNanos = clock.nanoTime();
      try {
        this.timeoutFuture =
            scheduler.schedule(
                this::onTimeout, Math.max(0L, timeout.toMillis()), TimeUnit.MILLISECONDS);
      } catch (RejectedExecutionException e) {
        completeFailure(channelRef.get(), "telemetry scheduler shut down");
        return completionFuture;
      }
      step();
      return completionFuture;
    }

    private void step() {
      if (completed.get()) {
        return;
      }
      ManagedChannel ch = channelRef.get();
      if (ch == null) {
        completeFailure(null, "channel destroyed before becoming ready");
        return;
      }
      ConnectivityState state;
      try {
        state = ch.getState(true);
      } catch (UnsupportedOperationException e) {
        completeFailure(ch, "channel does not support connectivity state inspection");
        return;
      }
      if (state == ConnectivityState.READY) {
        if (completed.compareAndSet(false, true)) {
          try {
            cancelTimeout();
            Duration elapsed = elapsedDuration();
            String lbPolicyName = lbPolicyExtractor.apply(ch);
            TransportType selected =
                selectedTransportType(requestedTransport, lbPolicyName, grpcSupportsForceXds);
            logChannelReady(requestedTransport, selected, lbPolicyName, elapsed, true, null);
            if (onReady != null) {
              onReady.onChannelReady(selected, elapsed);
            }
          } catch (RuntimeException e) {
            LOG.log(Level.FINE, "Channel telemetry callback failed", e);
          } finally {
            completionFuture.complete(null);
          }
        }
        return;
      }
      if (state == ConnectivityState.SHUTDOWN) {
        completeFailure(ch, "channel shut down before becoming ready");
        return;
      }
      try {
        ch.notifyWhenStateChanged(state, this::step);
      } catch (UnsupportedOperationException e) {
        completeFailure(ch, "channel does not support state change notifications");
      }
    }

    private void onTimeout() {
      completeFailure(channelRef.get(), "DEADLINE_EXCEEDED");
    }

    private void completeFailure(@Nullable ManagedChannel ch, String statusDescription) {
      if (completed.compareAndSet(false, true)) {
        try {
          cancelTimeout();
          Duration elapsed = elapsedDuration();
          String lbPolicyName = ch != null ? lbPolicyExtractor.apply(ch) : null;
          TransportType selected =
              selectedTransportType(requestedTransport, lbPolicyName, grpcSupportsForceXds);
          logChannelReady(
              requestedTransport, selected, lbPolicyName, elapsed, false, statusDescription);
        } catch (RuntimeException e) {
          LOG.log(Level.FINE, "Channel telemetry failure callback failed", e);
        } finally {
          completionFuture.complete(null);
        }
      }
    }

    private Duration elapsedDuration() {
      return Duration.ofNanos(clock.nanoTime() - startNanos);
    }

    private void cancelTimeout() {
      ScheduledFuture<?> f = this.timeoutFuture;
      if (f != null) {
        f.cancel(false);
      }
    }
  }
}
