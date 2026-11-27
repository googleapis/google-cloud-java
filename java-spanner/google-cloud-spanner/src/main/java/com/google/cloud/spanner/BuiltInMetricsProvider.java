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

import static com.google.cloud.spanner.BuiltInMetricsConstant.CLIENT_HASH_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.CLIENT_NAME_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.CLIENT_UID_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.INSTANCE_CONFIG_ID_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.INSTANCE_ID_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.LOCATION_ID_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.PROJECT_ID_KEY;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.auth.Credentials;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import io.grpc.ManagedChannelBuilder;
import io.grpc.opentelemetry.GrpcOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.contrib.gcp.resource.GCPResourceProvider;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.resources.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * Per-client provider for built-in Cloud Monitoring metrics. Each {@link SpannerOptions} owns a
 * dedicated instance so credentials, monitoring endpoints, universe domains, fallback project IDs,
 * and {@code client_uid} values remain isolated across clients in the same JVM.
 */
class BuiltInMetricsProvider {

  private static final Logger logger = Logger.getLogger(BuiltInMetricsProvider.class.getName());

  static final long DEFAULT_SHUTDOWN_TIMEOUT_SECONDS = 10L;

  private static final Object PID_AND_HOST_LOCK = new Object();
  private static volatile String cachedPidAndHost;

  private static String location;

  private static final String default_location = "global";

  private final Object lock = new Object();
  private OpenTelemetry openTelemetry;
  private boolean ownsOpenTelemetry;
  // Held in an AtomicReference so PeriodicMetricReader export threads read the fallback project
  // lock-free during periodic and final-flush exports, and close() can detach a new reference
  // without clearing the closing exporter's view.
  private volatile AtomicReference<String> fallbackProjectId = new AtomicReference<>();
  private boolean mismatchedProjectIdLogged;
  private Thread shutdownHook;
  private String clientUid;

  // Package-private and non-final so tests can record the arguments passed by SpannerOptions.
  @VisibleForTesting
  BuiltInMetricsProvider() {}

  /**
   * Returns the Cloud Monitoring {@link OpenTelemetry} instance for this client, lazily creating
   * and registering a JVM shutdown hook for it on the first call. Returns {@code null} if exporter
   * creation fails with an {@link IOException}.
   */
  @Nullable
  OpenTelemetry getOrCreateOpenTelemetry(
      String projectId,
      @Nullable Credentials credentials,
      @Nullable String monitoringHost,
      String universeDomain) {
    synchronized (lock) {
      try {
        if (this.openTelemetry == null) {
          AtomicReference<String> projectRef = this.fallbackProjectId;
          String uid = currentClientUid();
          SdkMeterProviderBuilder sdkMeterProviderBuilder = SdkMeterProvider.builder();
          BuiltInMetricsView.registerBuiltinMetrics(
              createExporter(
                  projectRef::get,
                  createClientAttributes(uid),
                  credentials,
                  monitoringHost,
                  universeDomain),
              sdkMeterProviderBuilder);
          sdkMeterProviderBuilder.setResource(
              Resource.create(createResourceAttributes(projectId, uid)));
          SdkMeterProvider sdkMeterProvider = sdkMeterProviderBuilder.build();
          this.openTelemetry =
              OpenTelemetrySdk.builder().setMeterProvider(sdkMeterProvider).build();
          this.ownsOpenTelemetry = true;
          Thread hook = new Thread(sdkMeterProvider::close);
          try {
            Runtime.getRuntime().addShutdownHook(hook);
            this.shutdownHook = hook;
          } catch (IllegalStateException ignored) {
            // The JVM is already shutting down; skip registering a shutdown hook.
            this.shutdownHook = null;
          }
        }
        return this.openTelemetry;
      } catch (IOException ex) {
        logger.log(
            Level.WARNING,
            "Unable to get OpenTelemetry object for client side metrics, will skip exporting client"
                + " side metrics",
            ex);
        return null;
      }
    }
  }

  /**
   * Creates the {@link MetricExporter} backing this provider. Package-private and overridable in
   * tests to inspect exporter settings or inject deterministic test doubles.
   */
  @VisibleForTesting
  MetricExporter createExporter(
      Supplier<String> fallbackProjectIdSupplier,
      Map<String, String> clientAttributes,
      @Nullable Credentials credentials,
      @Nullable String monitoringHost,
      String universeDomain)
      throws IOException {
    return SpannerCloudMonitoringExporter.create(
        fallbackProjectIdSupplier, clientAttributes, credentials, monitoringHost, universeDomain);
  }

  /** Sets the fallback project ID for non-Spanner gRPC metrics if not yet initialized. */
  void setProjectIdIfAbsent(String projectId) {
    synchronized (lock) {
      String current = this.fallbackProjectId.get();
      if (current == null) {
        this.fallbackProjectId.set(projectId);
      } else if (!current.equals(projectId) && !mismatchedProjectIdLogged) {
        mismatchedProjectIdLogged = true;
        logger.log(
            Level.WARNING,
            "Built-in metrics fallback project is already initialized to project {0}. Non-Spanner"
                + " metrics without project information will be exported using that project instead"
                + " of project {1}.",
            new Object[] {current, projectId});
      }
    }
  }

  @Nullable
  OpenTelemetry getOpenTelemetry() {
    synchronized (lock) {
      return this.openTelemetry;
    }
  }

  /**
   * Injects the Cloud Monitoring OpenTelemetry so that {@link #getOrCreateOpenTelemetry} returns it
   * instead of building one backed by the live Cloud Monitoring exporter. Used to observe the
   * reserved-namespace sink in-memory in tests. Injected instances are owned by the caller and are
   * not shut down by {@link #close()}.
   */
  @VisibleForTesting
  void setOpenTelemetry(OpenTelemetry openTelemetry) {
    synchronized (lock) {
      this.openTelemetry = openTelemetry;
      this.ownsOpenTelemetry = false;
    }
  }

  /** Returns the current fallback project ID lock-free for export threads. */
  String getProjectId() {
    return this.fallbackProjectId.get();
  }

  /**
   * Closes the provider-owned {@link OpenTelemetrySdk} with the default bounded shutdown timeout
   * and rotates state so subsequent reuse of the owning {@link SpannerOptions} starts cleanly.
   */
  void close() {
    close(DEFAULT_SHUTDOWN_TIMEOUT_SECONDS, TimeUnit.SECONDS);
  }

  /**
   * Closes the provider-owned {@link OpenTelemetrySdk}, waiting at most {@code timeout} for the
   * final flush. When {@code timeout <= 0}, shutdown is initiated asynchronously without blocking.
   */
  void close(long timeout, TimeUnit unit) {
    closeInternal(/* closeInjected= */ false, timeout, unit);
  }

  @VisibleForTesting
  boolean hasShutdownHook() {
    synchronized (lock) {
      return this.shutdownHook != null;
    }
  }

  @VisibleForTesting
  void reset() {
    closeInternal(/* closeInjected= */ true, DEFAULT_SHUTDOWN_TIMEOUT_SECONDS, TimeUnit.SECONDS);
  }

  private void closeInternal(boolean closeInjected, long timeout, TimeUnit unit) {
    final OpenTelemetry toClose;
    final Thread hookToRemove;
    synchronized (lock) {
      toClose = (closeInjected || this.ownsOpenTelemetry) ? this.openTelemetry : null;
      hookToRemove = this.shutdownHook;
      this.openTelemetry = null;
      this.ownsOpenTelemetry = false;
      this.shutdownHook = null;
      // Clear fallbackProjectId and clientUid so a subsequent reopen starts cleanly with a new
      // lazy client_uid while any in-flight final flush keeps reading the previous AtomicReference.
      this.fallbackProjectId = new AtomicReference<>();
      this.mismatchedProjectIdLogged = false;
      this.clientUid = null;
    }
    if (hookToRemove != null) {
      try {
        Runtime.getRuntime().removeShutdownHook(hookToRemove);
      } catch (IllegalStateException ignored) {
        // The JVM is already shutting down.
      }
    }
    if (toClose instanceof OpenTelemetrySdk) {
      shutdownMeterProvider(((OpenTelemetrySdk) toClose).getSdkMeterProvider(), timeout, unit);
    }
  }

  /**
   * Shuts down {@code meterProvider} on a daemon thread so caller timeouts are strictly honored
   * even though {@code PeriodicMetricReader#shutdown()} synchronously blocks up to 5 seconds per
   * internal phase while waiting on a final export.
   */
  private static void shutdownMeterProvider(
      SdkMeterProvider meterProvider, long timeout, TimeUnit unit) {
    CountDownLatch completed = new CountDownLatch(1);
    Thread shutdownThread =
        new Thread(
            () -> {
              try {
                CompletableResultCode shutdownResult = meterProvider.shutdown();
                if (timeout > 0) {
                  shutdownResult.join(timeout, unit);
                }
              } catch (RuntimeException e) {
                logger.log(Level.WARNING, "Failed to shut down built-in metrics provider", e);
              } finally {
                completed.countDown();
              }
            },
            "spanner-builtin-metrics-shutdown");
    shutdownThread.setDaemon(true);
    shutdownThread.start();
    if (timeout > 0) {
      try {
        completed.await(timeout, unit);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  // TODO: Remove when
  // https://github.com/GoogleCloudPlatform/opentelemetry-operations-java/issues/421
  //       has been fixed.
  static boolean quickCheckIsRunningOnGcp() {
    int timeout = 5000;
    try {
      timeout =
          Integer.parseInt(System.getProperty("spanner.check_is_running_on_gcp_timeout", "5000"));
    } catch (NumberFormatException ignore) {
      // ignore
    }
    try {
      URL url = new URL("http://metadata.google.internal/computeMetadata/v1/project/project-id");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setConnectTimeout(timeout);
      connection.setRequestProperty("Metadata-Flavor", "Google");
      if (connection.getResponseCode() == 200
          && ("Google").equals(connection.getHeaderField("Metadata-Flavor"))) {
        InputStream input = connection.getInputStream();
        try (BufferedReader reader =
            new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {
          return !Strings.isNullOrEmpty(reader.readLine());
        }
      }
    } catch (IOException ignore) {
      // ignore
    }
    return false;
  }

  void enableGrpcMetrics(
      InstantiatingGrpcChannelProvider.Builder channelProviderBuilder,
      String projectId,
      @Nullable Credentials credentials,
      @Nullable String monitoringHost,
      String universeDomain) {
    OpenTelemetry otel =
        this.getOrCreateOpenTelemetry(projectId, credentials, monitoringHost, universeDomain);
    if (otel == null) {
      return;
    }
    enableGrpcMetrics(channelProviderBuilder, otel);
  }

  /**
   * Wires gRPC-layer metrics into the channel builder using the given OpenTelemetry instance. Does
   * nothing if {@code openTelemetry} is {@code null}.
   */
  void enableGrpcMetrics(
      InstantiatingGrpcChannelProvider.Builder channelProviderBuilder,
      @Nullable OpenTelemetry openTelemetry) {
    if (openTelemetry == null) {
      return;
    }
    GrpcOpenTelemetry grpcOpenTelemetry =
        GrpcOpenTelemetry.newBuilder()
            .sdk(openTelemetry)
            .enableMetrics(BuiltInMetricsConstant.GRPC_METRICS_TO_ENABLE)
            // Disable gRPCs default metrics as they are not needed for Spanner.
            .disableMetrics(BuiltInMetricsConstant.GRPC_METRICS_ENABLED_BY_DEFAULT)
            .addOptionalLabel(BuiltInMetricsConstant.GRPC_LB_BACKEND_SERVICE_ATTRIBUTE)
            .addOptionalLabel(BuiltInMetricsConstant.GRPC_LB_LOCALITY_ATTRIBUTE)
            .addOptionalLabel(BuiltInMetricsConstant.GRPC_DISCONNECT_ERROR_ATTRIBUTE)
            .build();
    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator =
        channelProviderBuilder.getChannelConfigurator();
    channelProviderBuilder.setChannelConfigurator(
        b -> {
          grpcOpenTelemetry.configureChannelBuilder(b);
          if (channelConfigurator != null) {
            return channelConfigurator.apply(b);
          }
          return b;
        });
  }

  Attributes createResourceAttributes(String projectId) {
    return createResourceAttributes(projectId, currentClientUid());
  }

  private Attributes createResourceAttributes(String projectId, String uid) {
    AttributesBuilder attributesBuilder =
        Attributes.builder()
            .put(PROJECT_ID_KEY.getKey(), projectId)
            .put(INSTANCE_CONFIG_ID_KEY.getKey(), "unknown")
            .put(CLIENT_HASH_KEY.getKey(), generateClientHash(uid))
            .put(INSTANCE_ID_KEY.getKey(), "unknown")
            .put(LOCATION_ID_KEY.getKey(), detectClientLocation());

    return attributesBuilder.build();
  }

  Map<String, String> createClientAttributes() {
    return createClientAttributes(currentClientUid());
  }

  /** Lazily initializes and returns the per-provider {@code client_uid} on first metrics use. */
  private String currentClientUid() {
    synchronized (lock) {
      if (this.clientUid == null) {
        this.clientUid = createTaskValue();
      }
      return this.clientUid;
    }
  }

  private Map<String, String> createClientAttributes(String uid) {
    Map<String, String> clientAttributes = new HashMap<>();
    clientAttributes.put(
        CLIENT_NAME_KEY.getKey(), "spanner-java/" + GaxProperties.getLibraryVersion(getClass()));
    clientAttributes.put(CLIENT_UID_KEY.getKey(), uid);
    return clientAttributes;
  }

  /**
   * Generates a 6-digit zero-padded all lower case hexadecimal representation of hash of the
   * accounting group. The hash utilizes the 10 most significant bits of the value returned by
   * `Hashing.goodFastHash(64).hashBytes()`, so effectively the returned values are uniformly
   * distributed in the range [000000, 0003ff].
   *
   * <p>The primary purpose of this function is to generate a hash value for the `client_hash`
   * resource label using `client_uid` metric field. The range of values is chosen to be small
   * enough to keep the cardinality of the Resource targets under control. Note: If at later time
   * the range needs to be increased, it can be done by increasing the value of `kPrefixLength` to
   * up to 24 bits without changing the format of the returned value.
   *
   * @return Returns a 6-digit zero-padded all lower case hexadecimal representation of hash of the
   *     accounting group.
   */
  static String generateClientHash(String clientUid) {
    if (clientUid == null) {
      return "000000";
    }

    HashFunction hashFunction = Hashing.goodFastHash(64);
    Long hash = hashFunction.hashBytes(clientUid.getBytes()).asLong();
    // Don't change this value without reading above comment
    int kPrefixLength = 10;
    long shiftedValue = hash >>> (64 - kPrefixLength);
    return String.format("%06x", shiftedValue);
  }

  static String detectClientLocation() {
    if (location == null) {
      location = default_location;
      if (quickCheckIsRunningOnGcp()) {
        Attributes detectedResourceAttributes = new GCPResourceProvider().getAttributes();
        // All platform except GKE uses "cloud.region" for region attribute.
        // GKE could either use "cloud.region" or "cloud.availability_zone" for region attribute.
        String region = detectedResourceAttributes.get(AttributeKey.stringKey("cloud.region"));
        String gkeZonalClusterLocation =
            detectedResourceAttributes.get(AttributeKey.stringKey("cloud.availability_zone"));
        if (region == null && gkeZonalClusterLocation != null) {
          region = gkeZonalClusterLocation;
        }
        location = region == null ? location : region;
      }
    }
    return location;
  }

  /**
   * Generates a unique identifier for the {@code client_uid} metric field in the format {@code
   * UUID@PID@hostname}, caching the PID and hostname once per JVM.
   */
  private static String createTaskValue() {
    return UUID.randomUUID() + "@" + getPidAndHost();
  }

  private static String getPidAndHost() {
    String pidAndHost = cachedPidAndHost;
    if (pidAndHost != null) {
      return pidAndHost;
    }
    synchronized (PID_AND_HOST_LOCK) {
      if (cachedPidAndHost == null) {
        String pid = getProcessId();
        String hostname;
        try {
          hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
          logger.log(Level.INFO, "Unable to get the hostname.", e);
          hostname = "localhost";
        }
        cachedPidAndHost = pid + "@" + hostname;
      }
      return cachedPidAndHost;
    }
  }

  private static String getProcessId() {
    try {
      // Check if Java 9+ and ProcessHandle class is available
      Class<?> processHandleClass = Class.forName("java.lang.ProcessHandle");
      Method currentMethod = processHandleClass.getMethod("current");
      Object processHandleInstance = currentMethod.invoke(null);
      Method pidMethod = processHandleClass.getMethod("pid");
      long pid = (long) pidMethod.invoke(processHandleInstance);
      return Long.toString(pid);
    } catch (Exception e) {
      // Fallback to Java 8 method
      final String jvmName = ManagementFactory.getRuntimeMXBean().getName();
      if (jvmName != null && jvmName.contains("@")) {
        return jvmName.split("@")[0];
      } else {
        return "unknown";
      }
    }
  }
}
