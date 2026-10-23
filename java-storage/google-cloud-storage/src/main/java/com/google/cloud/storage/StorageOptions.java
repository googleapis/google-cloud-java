/*
 * Copyright 2015 Google LLC
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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceOptions;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.GrpcStorageOptions.GrpcStorageDefaults;
import com.google.cloud.storage.HttpStorageOptions.HttpStorageDefaults;
import com.google.cloud.storage.HttpStorageOptions.HttpStorageFactory;
import com.google.cloud.storage.HttpStorageOptions.HttpStorageRpcFactory;
import com.google.cloud.storage.Retrying.DefaultRetrier;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.Retrying.RetryingDependencies;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.spi.StorageRpcFactory;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.contrib.gcp.resource.GCPResourceProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class StorageOptions extends ServiceOptions<Storage, StorageOptions> {

  private static final long serialVersionUID = -7295846567928013233L;
  private static final String VERSION;

  static {
    String tmp = "unresolved";
    final Properties props = new Properties();
    try {
      String resourcePath =
          String.format(
              Locale.US,
              "/META-INF/maven/%s/%s/pom.properties",
              "com.google.cloud",
              "google-cloud-storage");
      InputStream resourceAsStream = StorageOptions.class.getResourceAsStream(resourcePath);
      if (resourceAsStream == null) {
        // some classloaders don't like a leading slash
        resourceAsStream = StorageOptions.class.getResourceAsStream(resourcePath.substring(1));
      }
      if (resourceAsStream != null) {
        props.load(resourceAsStream);
        resourceAsStream.close();

        tmp = props.getProperty("version", "unknown-version");
      }
    } catch (IOException ignore) {
      // ignored
    }
    VERSION = tmp;
  }

  Retrier createRetrier() {
    return new DefaultRetrier(
        OtelStorageDecorator.retryContextDecorator(getOpenTelemetry()),
        RetryingDependencies.simple(getClock(), getRetrySettings(), getStorageClientMetrics()));
  }

  /**
   * @deprecated Use {@link HttpStorageFactory}
   */
  @Deprecated
  public static class DefaultStorageFactory extends HttpStorageFactory {
    private static final long serialVersionUID = -7856840922014956661L;

    /**
     * @deprecated Use {@link HttpStorageDefaults#getDefaultServiceFactory()}
     */
    @Deprecated
    public DefaultStorageFactory() {
      super();
    }
  }

  /**
   * @deprecated Use {@link HttpStorageRpcFactory}
   */
  @Deprecated
  public static class DefaultStorageRpcFactory extends HttpStorageRpcFactory {
    private static final long serialVersionUID = -7856840922014956661L;

    /**
     * @deprecated Use {@link HttpStorageDefaults#getDefaultRpcFactory()}
     */
    @Deprecated
    public DefaultStorageRpcFactory() {
      super();
    }
  }

  public abstract static class Builder
      extends ServiceOptions.Builder<Storage, StorageOptions, Builder> {

    private @Nullable Boolean enableOtelMetrics = null;
    private @Nullable Boolean enableOtelDebugMetrics = null;
    private @Nullable MeterProvider meterProvider = null;
    private Duration metricInterval = Duration.ofSeconds(60);
    private boolean customOpenTelemetryConfigured = false;
    private boolean customMeterProviderConfigured = false;

    Builder() {
      setUseJwtAccessWithScope(false);
    }

    Builder(StorageOptions options) {
      super(options);
      this.enableOtelMetrics = options.getRawEnableOtelMetrics();
      this.enableOtelDebugMetrics = options.getRawEnableOtelDebugMetrics();
      this.meterProvider = options.getMeterProvider();
      this.metricInterval = options.metricInterval;
      this.customMeterProviderConfigured = options.isCustomMeterProviderConfigured();
      this.customOpenTelemetryConfigured = options.isCustomOpenTelemetryConfigured();
    }

    @Nullable Boolean getEnableOtelMetrics() {
      return enableOtelMetrics;
    }

    @Nullable Boolean getEnableOtelDebugMetrics() {
      return enableOtelDebugMetrics;
    }

    @Nullable MeterProvider getMeterProvider() {
      return meterProvider;
    }

    Duration getMetricInterval() {
      return metricInterval;
    }

    boolean isCustomOpenTelemetryConfigured() {
      return customOpenTelemetryConfigured;
    }

    void setCustomOpenTelemetryConfigured(boolean customOpenTelemetryConfigured) {
      this.customOpenTelemetryConfigured = customOpenTelemetryConfigured;
    }

    boolean isCustomMeterProviderConfigured() {
      return customMeterProviderConfigured;
    }

    public abstract Builder setStorageRetryStrategy(StorageRetryStrategy storageRetryStrategy);

    /**
     * @see BlobWriteSessionConfig
     * @see BlobWriteSessionConfigs
     * @see Storage#blobWriteSession(BlobInfo, BlobWriteOption...)
     * @see HttpStorageDefaults#getDefaultStorageWriterConfig()
     * @see GrpcStorageDefaults#getDefaultStorageWriterConfig()
     * @since 2.37.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public abstract StorageOptions.Builder setBlobWriteSessionConfig(
        @NonNull BlobWriteSessionConfig blobWriteSessionConfig);

    /**
     * Enable OpenTelemetry Tracing and provide an instance for the client to use.
     *
     * @param openTelemetry User defined instance of OpenTelemetry to be used by the library
     * @since 2.47.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public abstract StorageOptions.Builder setOpenTelemetry(OpenTelemetry openTelemetry);

    /**
     * Enable or disable OpenTelemetry client metrics.
     *
     * @param enableOtelMetrics whether OpenTelemetry client metrics should be enabled
     * @since 2.76.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public StorageOptions.Builder setEnableOtelMetrics(boolean enableOtelMetrics) {
      this.enableOtelMetrics = enableOtelMetrics;
      return this;
    }

    /**
     * Enable or disable OpenTelemetry debug client metrics.
     *
     * @param enableOtelDebugMetrics whether OpenTelemetry debug client metrics should be enabled
     * @since 2.76.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public StorageOptions.Builder setEnableOtelDebugMetrics(boolean enableOtelDebugMetrics) {
      this.enableOtelDebugMetrics = enableOtelDebugMetrics;
      return this;
    }

    /**
     * Set a custom {@link MeterProvider} for recording client metrics.
     *
     * @param meterProvider custom MeterProvider to use, or null to use the default
     * @since 2.76.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public StorageOptions.Builder setMeterProvider(@Nullable MeterProvider meterProvider) {
      this.meterProvider = meterProvider;
      this.customMeterProviderConfigured = meterProvider != null;
      return this;
    }

    /**
     * Set the metric export interval for periodic metric reading.
     *
     * <p>When using the default Cloud Monitoring exporter, the interval must be at least 60 seconds
     * (1 minute). Intervals less than 60 seconds are permitted only when a custom {@link
     * MeterProvider} is configured via {@link #setMeterProvider(MeterProvider)} or explicit
     * OpenTelemetry is configured via {@link #setOpenTelemetry(OpenTelemetry)}.
     *
     * @param metricInterval interval duration
     * @since 2.76.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public StorageOptions.Builder setMetricInterval(Duration metricInterval) {
      checkArgument(
          metricInterval != null && !metricInterval.isNegative() && !metricInterval.isZero(),
          "metricInterval must be positive");
      this.metricInterval = metricInterval;
      return this;
    }

    @Override
    public abstract StorageOptions build();
  }

  private static final Logger LOGGER = Logger.getLogger(StorageOptions.class.getName());

  private final boolean enableOtelMetrics;
  private final boolean enableOtelDebugMetrics;
  @Nullable private final Boolean rawEnableOtelMetrics;
  @Nullable private final Boolean rawEnableOtelDebugMetrics;
  private transient MeterProvider meterProvider;
  private final Duration metricInterval;
  private final boolean customMeterProviderConfigured;
  private final boolean customOpenTelemetryConfigured;
  @Nullable transient StorageClientMetrics storageClientMetrics;

  StorageOptions(Builder builder, StorageDefaults serviceDefaults) {
    super(StorageFactory.class, StorageRpcFactory.class, builder, serviceDefaults);
    this.rawEnableOtelMetrics = builder.getEnableOtelMetrics();
    this.rawEnableOtelDebugMetrics = builder.getEnableOtelDebugMetrics();
    this.enableOtelMetrics =
        StorageMetricsConfig.isEnableOtelMetrics(builder.getEnableOtelMetrics());
    this.enableOtelDebugMetrics =
        this.enableOtelMetrics
            && StorageMetricsConfig.isEnableOtelDebugMetrics(builder.getEnableOtelDebugMetrics());
    this.meterProvider = builder.getMeterProvider();
    this.customMeterProviderConfigured =
        builder.isCustomMeterProviderConfigured() || builder.getMeterProvider() != null;
    this.customOpenTelemetryConfigured = builder.isCustomOpenTelemetryConfigured();
    this.metricInterval =
        builder.getMetricInterval() != null ? builder.getMetricInterval() : Duration.ofSeconds(60);
    boolean hasCustomOtelOrMeterProvider =
        this.customMeterProviderConfigured || this.customOpenTelemetryConfigured;
    if (!hasCustomOtelOrMeterProvider && this.metricInterval != null) {
      checkArgument(
          this.metricInterval.compareTo(Duration.ofSeconds(60)) >= 0,
          "Metric export interval cannot be less than 60 seconds when using Cloud Monitoring exporter");
    }
  }

  @Nullable Boolean getRawEnableOtelMetrics() {
    return rawEnableOtelMetrics;
  }

  @Nullable Boolean getRawEnableOtelDebugMetrics() {
    return rawEnableOtelDebugMetrics;
  }

  boolean isCustomMeterProviderConfigured() {
    return customMeterProviderConfigured;
  }

  boolean isCustomOpenTelemetryConfigured() {
    return customOpenTelemetryConfigured;
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    if (this.customMeterProviderConfigured || this.meterProvider != null) {
      LOGGER.warning(
          "Custom MeterProvider is transient and cannot be serialized across workers; falling back to default provider.");
    }
  }

  abstract static class StorageDefaults implements ServiceDefaults<Storage, StorageOptions> {}

  /**
   * @deprecated Use {@link HttpStorageDefaults#getDefaultTransportOptions()}
   */
  @Deprecated
  public static HttpTransportOptions getDefaultHttpTransportOptions() {
    return HttpStorageOptions.defaults().getDefaultTransportOptions();
  }

  // Project ID is only required for creating buckets, so we don't require it for creating the
  // service.
  @Override
  protected boolean projectIdRequired() {
    return false;
  }

  @Override
  public String getLibraryVersion() {
    return VERSION;
  }

  /* This can break at any time, the value produce is intended to be informative not authoritative */
  @InternalApi
  public static String version() {
    return VERSION;
  }

  /**
   * @since 2.47.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public abstract OpenTelemetry getOpenTelemetry();

  /**
   * Whether OpenTelemetry client metrics are enabled.
   *
   * @since 2.76.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public boolean isEnableOtelMetrics() {
    return enableOtelMetrics;
  }

  /**
   * Whether OpenTelemetry debug client metrics are enabled.
   *
   * @since 2.76.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public boolean isEnableOtelDebugMetrics() {
    return enableOtelDebugMetrics;
  }

  /**
   * The {@link MeterProvider} configured for recording client metrics.
   *
   * @since 2.76.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public @Nullable MeterProvider getMeterProvider() {
    return meterProvider;
  }

  @Nullable
  synchronized StorageClientMetrics getStorageClientMetrics() {
    if (!isEnableOtelMetrics()) {
      return null;
    }
    if (storageClientMetrics == null) {
      MeterProvider mp = getMeterProvider();
      if (mp == null && isCustomOpenTelemetryConfigured()) {
        OpenTelemetry otel = getOpenTelemetry();
        if (otel != null) {
          mp = otel.getMeterProvider();
        }
      }
      if (mp != null) {
        storageClientMetrics =
            StorageClientMetrics.create(
                mp, (SdkMeterProvider) null, isEnableOtelMetrics(), isEnableOtelDebugMetrics());
      } else {
        SdkMeterProvider defaultMeterProvider = createDefaultClientMeterProvider();
        if (defaultMeterProvider != null) {
          storageClientMetrics =
              StorageClientMetrics.create(
                  defaultMeterProvider,
                  defaultMeterProvider,
                  isEnableOtelMetrics(),
                  isEnableOtelDebugMetrics());
        }
      }
    }
    return storageClientMetrics;
  }

  @Nullable
  private SdkMeterProvider createDefaultClientMeterProvider() {
    try {
      GCPResourceProvider resourceProvider = new GCPResourceProvider();
      Attributes detectedAttributes = resourceProvider.getAttributes();
      String detectedProjectId = detectedAttributes.get(AttributeKey.stringKey("cloud.account.id"));
      String configuredProjectId = getProjectId();
      if (configuredProjectId != null && configuredProjectId.trim().isEmpty()) {
        configuredProjectId = null;
      }
      String projectIdToUse =
          (configuredProjectId != null && !configuredProjectId.isEmpty())
              ? configuredProjectId
              : detectedProjectId;
      if (projectIdToUse == null || projectIdToUse.isEmpty()) {
        LOGGER.warning(
            "Unable to determine the Project ID in order to report metrics. No storage client metrics"
                + " will be reported.");
        return null;
      }
      Attributes attributesToUse =
          Attributes.builder()
              .putAll(detectedAttributes)
              .put(AttributeKey.stringKey("cloud.account.id"), projectIdToUse)
              .build();
      String formattedEndpoint = formatStorageEndpoint(getHost());
      String metricServiceEndpoint =
          OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
              formattedEndpoint, getUniverseDomain());
      return OpenTelemetryBootstrappingUtils.createClientMeterProvider(
          metricServiceEndpoint,
          projectIdToUse,
          attributesToUse,
          getMetricInterval(),
          /* shouldSuppressExceptions= */ true,
          this instanceof GrpcStorageOptions ? "grpc" : "json");
    } catch (Exception e) {
      LOGGER.warning("Failed to create default client MeterProvider: " + e.getMessage());
      return null;
    }
  }

  private static String formatStorageEndpoint(@Nullable String host) {
    if (host == null || host.trim().isEmpty()) {
      return "storage.googleapis.com:443";
    }
    String endpoint = host.trim();
    if (endpoint.startsWith("google-c2p:///")) {
      endpoint = endpoint.substring("google-c2p:///".length());
    } else if (endpoint.startsWith("https://")) {
      endpoint = endpoint.substring("https://".length());
    } else if (endpoint.startsWith("http://")) {
      endpoint = endpoint.substring("http://".length());
    }
    if (endpoint.endsWith("/")) {
      endpoint = endpoint.substring(0, endpoint.length() - 1);
    }
    if (!endpoint.contains(":")) {
      endpoint = endpoint + ":443";
    }
    return endpoint;
  }

  synchronized void closeStorageClientMetrics() {
    if (storageClientMetrics != null) {
      try {
        storageClientMetrics.close();
      } catch (Exception e) {
        LOGGER.warning("Failed to close storageClientMetrics: " + e.getMessage());
      } finally {
        storageClientMetrics = null;
      }
    }
  }

  @Nullable StorageMetricsContext createMetricsContext(String operationName) {
    StorageClientMetrics metrics = getStorageClientMetrics();
    if (metrics == null) {
      return null;
    }
    return StorageMetricsContext.create(operationName, buildBaseMetricsAttributes(metrics));
  }

  @Nullable StorageMetricsContext createMultiStepMetricsContext(String operationName) {
    StorageClientMetrics metrics = getStorageClientMetrics();
    if (metrics == null) {
      return null;
    }
    return StorageMetricsContext.createForMultiStep(
        operationName, buildBaseMetricsAttributes(metrics));
  }

  private Attributes buildBaseMetricsAttributes(StorageClientMetrics metrics) {
    io.opentelemetry.api.common.AttributesBuilder builder =
        metrics
            .clientAttributesBuilder()
            .put(
                StorageClientMetrics.KEY_RPC_SYSTEM_NAME,
                this instanceof GrpcStorageOptions ? "grpc" : "http");
    String serverAddress = extractServerAddress(getHost());
    if (serverAddress != null && !serverAddress.isEmpty()) {
      builder.put(StorageClientMetrics.KEY_SERVER_ADDRESS, serverAddress);
    }
    return builder.build();
  }

  @InternalApi
  @Nullable
  public HttpRequestInitializer decorateWithMetrics(@Nullable HttpRequestInitializer initializer) {
    StorageClientMetrics metrics = getStorageClientMetrics();
    if (metrics == null) {
      return initializer;
    }
    return new StorageHttpMetricsInterceptor(initializer, metrics, getClock(), getHost());
  }

  @Nullable
  static String extractServerAddress(@Nullable String host) {
    if (host == null || host.trim().isEmpty()) {
      return null;
    }
    String s = host.trim();
    if (s.startsWith("google-c2p:///")) {
      s = s.substring("google-c2p:///".length());
    } else if (s.startsWith("https://")) {
      s = s.substring("https://".length());
    } else if (s.startsWith("http://")) {
      s = s.substring("http://".length());
    }
    int slashIdx = s.indexOf('/');
    if (slashIdx >= 0) {
      s = s.substring(0, slashIdx);
    }
    if (s.startsWith("[") && s.contains("]")) {
      int closeBracket = s.indexOf(']');
      int colonIdx = s.indexOf(':', closeBracket);
      if (colonIdx >= 0) {
        s = s.substring(0, colonIdx);
      }
      if (s.startsWith("[") && s.endsWith("]")) {
        s = s.substring(1, s.length() - 1);
      }
    } else {
      int colonIdx = s.indexOf(':');
      if (colonIdx >= 0) {
        s = s.substring(0, colonIdx);
      }
    }
    return s.isEmpty() ? null : s;
  }

  /**
   * The metric export interval configured for periodic metric reading.
   *
   * @since 2.76.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public Duration getMetricInterval() {
    Duration interval = metricInterval != null ? metricInterval : Duration.ofSeconds(60);
    if (meterProvider == null && !customOpenTelemetryConfigured) {
      if (interval.compareTo(Duration.ofSeconds(60)) < 0) {
        return Duration.ofSeconds(60);
      }
    }
    return interval;
  }

  @SuppressWarnings("unchecked")
  @Override
  public abstract StorageOptions.Builder toBuilder();

  @Override
  public abstract int hashCode();

  @Override
  public abstract boolean equals(Object obj);

  /**
   * Returns a default {@code StorageOptions} instance. The default instance will use JSON over HTTP
   * for its transport.
   */
  @TransportCompatibility(Transport.HTTP)
  public static StorageOptions getDefaultInstance() {
    return HttpStorageOptions.newBuilder().build();
  }

  /**
   * Returns a unauthenticated {@code StorageOptions} instance. The returned instance will use JSON
   * over HTTP for its transport.
   */
  @TransportCompatibility(Transport.HTTP)
  public static StorageOptions getUnauthenticatedInstance() {
    return HttpStorageOptions.newBuilder().setCredentials(NoCredentials.getInstance()).build();
  }

  /** The returned instance will use JSON over HTTP for its transport. */
  @TransportCompatibility(Transport.HTTP)
  public static StorageOptions.Builder newBuilder() {
    return http();
  }

  /**
   * Builder factory method which will create a JSON over HTTP specific instance of storage options.
   *
   * @since 2.14.0
   */
  @TransportCompatibility(Transport.HTTP)
  public static HttpStorageOptions.Builder http() {
    return HttpStorageOptions.newBuilder();
  }

  /**
   * Builder factory method which will create a gRPC specific instance of storage options.
   *
   * <p>Google Cloud Storage is in Private Preview for a gRPC centric transport.
   *
   * @since 2.14.0
   */
  @TransportCompatibility(Transport.GRPC)
  public static GrpcStorageOptions.Builder grpc() {
    return GrpcStorageOptions.newBuilder();
  }
}
