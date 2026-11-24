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

package com.google.cloud.storage;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.rpc.EndpointContext;
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.api.gax.rpc.UnavailableException;
import com.google.auth.ApiKeyCredentials;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GdchCredentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.monitoring.v3.MetricServiceSettings;
import com.google.cloud.opentelemetry.metric.GoogleCloudMetricExporter;
import com.google.cloud.opentelemetry.metric.MetricConfiguration;
import com.google.cloud.opentelemetry.metric.MonitoredResourceDescription;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.net.HostAndPort;
import com.google.common.net.InetAddresses;
import io.grpc.ManagedChannelBuilder;
import io.grpc.opentelemetry.GrpcOpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.contrib.gcp.resource.GCPResourceProvider;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.export.MemoryMode;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.InstrumentSelectorBuilder;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.ViewBuilder;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import io.opentelemetry.sdk.resources.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.NoRouteToHostException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

final class OpenTelemetryBootstrappingUtils {
  private static final Collection<String> METRICS_TO_ENABLE =
      ImmutableList.of(
          "grpc.lb.wrr.rr_fallback",
          "grpc.lb.wrr.endpoint_weight_not_yet_usable",
          "grpc.lb.wrr.endpoint_weight_stale",
          "grpc.lb.wrr.endpoint_weights",
          "grpc.lb.rls.cache_entries",
          "grpc.lb.rls.cache_size",
          "grpc.lb.rls.default_target_picks",
          "grpc.lb.rls.target_picks",
          "grpc.lb.rls.failed_picks",
          "grpc.xds_client.connected",
          "grpc.xds_client.server_failure",
          "grpc.xds_client.resource_updates_valid",
          "grpc.xds_client.resource_updates_invalid",
          "grpc.xds_client.resources");

  private static final Collection<String> METRICS_ENABLED_BY_DEFAULT =
      ImmutableList.of(
          "grpc.client.attempt.sent_total_compressed_message_size",
          "grpc.client.attempt.rcvd_total_compressed_message_size",
          "grpc.client.attempt.started",
          "grpc.client.attempt.duration",
          "grpc.client.call.duration");

  static final Logger log = Logger.getLogger(OpenTelemetryBootstrappingUtils.class.getName());

  @NonNull
  static ChannelConfigurator enableGrpcMetrics(
      @Nullable ChannelConfigurator channelConfigurator,
      String endpoint,
      @Nullable String projectId,
      @Nullable String universeDomain,
      @Nullable Credentials credentials,
      boolean shouldSuppressExceptions) {
    return enableGrpcMetrics(
        channelConfigurator,
        endpoint,
        projectId,
        universeDomain,
        credentials,
        shouldSuppressExceptions,
        System::getenv);
  }

  @VisibleForTesting
  @NonNull
  static ChannelConfigurator enableGrpcMetrics(
      @Nullable ChannelConfigurator channelConfigurator,
      String endpoint,
      @Nullable String projectId,
      @Nullable String universeDomain,
      @Nullable Credentials credentials,
      boolean shouldSuppressExceptions,
      Function<String, String> envProvider) {
    return enableGrpcMetrics(
        channelConfigurator,
        endpoint,
        projectId,
        universeDomain,
        credentials,
        shouldSuppressExceptions,
        () -> new GCPResourceProvider().getAttributes(),
        envProvider);
  }

  @VisibleForTesting
  @NonNull
  static ChannelConfigurator enableGrpcMetrics(
      @Nullable ChannelConfigurator channelConfigurator,
      String endpoint,
      @Nullable String projectId,
      @Nullable String universeDomain,
      @Nullable Credentials credentials,
      boolean shouldSuppressExceptions,
      Attributes detectedAttributes,
      Function<String, String> envProvider) {
    return enableGrpcMetrics(
        channelConfigurator,
        endpoint,
        projectId,
        universeDomain,
        credentials,
        shouldSuppressExceptions,
        () -> detectedAttributes,
        envProvider);
  }

  @NonNull
  private static ChannelConfigurator enableGrpcMetrics(
      @Nullable ChannelConfigurator channelConfigurator,
      String endpoint,
      @Nullable String projectId,
      @Nullable String universeDomain,
      @Nullable Credentials credentials,
      boolean shouldSuppressExceptions,
      Supplier<Attributes> detectedAttributesSupplier,
      Function<String, String> envProvider) {
    ChannelConfigurator fallback =
        channelConfigurator != null ? channelConfigurator : ChannelConfigurator.identity();
    if (!isSupportedCredentialsForMetrics(credentials) || isPlaintextOrLoopbackEndpoint(endpoint)) {
      return fallback;
    }
    String resolvedUniverseDomain;
    try {
      resolvedUniverseDomain = resolveUniverseDomain(universeDomain, envProvider);
    } catch (IllegalArgumentException e) {
      log.log(
          Level.WARNING,
          "Invalid universe domain for gRPC client metrics. Skipping metrics export: "
              + e.getMessage(),
          e);
      return fallback;
    }
    if (!credentialsMatchUniverseDomain(credentials, resolvedUniverseDomain)) {
      return fallback;
    }

    Attributes detectedAttributes = detectedAttributesSupplier.get();
    String projectIdToUse =
        resolveProjectIdForMetrics(detectedAttributes, projectId, "gRPC client metrics");
    if (projectIdToUse == null) {
      return fallback;
    }

    String metricServiceEndpoint =
        getCloudMonitoringEndpoint(endpoint, resolvedUniverseDomain, envProvider);
    MetricServiceSettings metricServiceSettings;
    try {
      metricServiceSettings =
          buildMetricServiceSettings(metricServiceEndpoint, resolvedUniverseDomain, credentials);
    } catch (Exception e) {
      log.log(
          Level.WARNING,
          "Failed to configure Cloud Monitoring settings for gRPC client metrics: "
              + e.getMessage(),
          e);
      return fallback;
    }
    SdkMeterProvider provider =
        createMeterProvider(
            metricServiceSettings, projectIdToUse, detectedAttributes, shouldSuppressExceptions);

    OpenTelemetrySdk openTelemetrySdk =
        OpenTelemetrySdk.builder().setMeterProvider(provider).build();
    GrpcOpenTelemetry grpcOpenTelemetry =
        GrpcOpenTelemetry.newBuilder()
            .sdk(openTelemetrySdk)
            .addOptionalLabel("grpc.lb.locality")
            .enableMetrics(METRICS_TO_ENABLE)
            .build();
    ChannelConfigurator otelConfigurator =
        b -> {
          grpcOpenTelemetry.configureChannelBuilder(b);
          return b;
        };
    return otelConfigurator.andThen(channelConfigurator);
  }

  @SuppressWarnings("rawtypes") // ManagedChannelBuilder
  @FunctionalInterface
  interface ChannelConfigurator extends ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> {
    @NonNull
    default ChannelConfigurator andThen(@Nullable ChannelConfigurator then) {
      if (then == null) {
        return this;
      }
      return b -> then.apply(this.apply(b));
    }

    static ChannelConfigurator identity() {
      return IdentityChannelConfigurator.INSTANCE;
    }

    static ChannelConfigurator lift(
        @Nullable ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> f) {
      if (f == null) {
        return identity();
      }
      return f::apply;
    }
  }

  @SuppressWarnings("rawtypes") // ManagedChannelBuilder
  private static final class IdentityChannelConfigurator implements ChannelConfigurator {
    private static final IdentityChannelConfigurator INSTANCE = new IdentityChannelConfigurator();

    private IdentityChannelConfigurator() {}

    @Override
    public ManagedChannelBuilder apply(ManagedChannelBuilder input) {
      return input;
    }
  }

  private static final ImmutableList<String> STRIPPED_ENDPOINT_SCHEMES =
      ImmutableList.of(
          "google-c2p-experimental:///", "google-c2p:///", "dns:///", "https://", "http://");

  private static final ImmutableList<String> AUTHORITY_ENDPOINT_SCHEMES =
      ImmutableList.of("google-c2p-experimental://", "google-c2p://", "dns://");

  private static boolean isSupportedCredentialsForMetrics(@Nullable Credentials credentials) {
    if (credentials == null
        || credentials instanceof NoCredentials
        || credentials instanceof GdchCredentials
        || credentials instanceof ApiKeyCredentials) {
      return false;
    }
    if ((credentials.getClass() == OAuth2Credentials.class
            || credentials.getClass() == GoogleCredentials.class)
        && ((OAuth2Credentials) credentials).getAccessToken() == null) {
      return false;
    }
    return true;
  }

  private static String normalizeUniverseDomain(String universeDomain) {
    String normalized = universeDomain.trim();
    if (normalized.endsWith(".")) {
      normalized = normalized.substring(0, normalized.length() - 1);
    }
    return normalized.toLowerCase(Locale.ROOT);
  }

  @Nullable
  private static String normalizeHost(@Nullable String host) {
    if (host == null) {
      return null;
    }
    String normalized = host.toLowerCase(Locale.ROOT);
    if (normalized.endsWith(".")) {
      normalized = normalized.substring(0, normalized.length() - 1);
    }
    return normalized;
  }

  @VisibleForTesting
  static String resolveUniverseDomain(
      @Nullable String universeDomain, Function<String, String> envProvider) {
    if (universeDomain != null) {
      String normalized = normalizeUniverseDomain(universeDomain);
      if (normalized.isEmpty()) {
        throw new IllegalArgumentException("The universe domain value cannot be empty.");
      }
      return normalized;
    }
    String envUniverseDomain = envProvider.apply(EndpointContext.GOOGLE_CLOUD_UNIVERSE_DOMAIN);
    if (envUniverseDomain != null) {
      String normalized = normalizeUniverseDomain(envUniverseDomain);
      if (normalized.isEmpty()) {
        throw new IllegalArgumentException(
            "The " + EndpointContext.GOOGLE_CLOUD_UNIVERSE_DOMAIN + " value cannot be empty.");
      }
      return normalized;
    }
    return Credentials.GOOGLE_DEFAULT_UNIVERSE;
  }

  @VisibleForTesting
  static boolean credentialsMatchUniverseDomain(
      Credentials credentials, String resolvedUniverseDomain) {
    try {
      String credentialsUniverseDomain = credentials.getUniverseDomain();
      if (credentialsUniverseDomain == null) {
        log.warning(
            "Unable to determine credentials universe domain for Cloud Monitoring metrics."
                + " Skipping metrics export.");
        return false;
      }
      String normalizedCredUniverse = normalizeUniverseDomain(credentialsUniverseDomain);
      if (normalizedCredUniverse.isEmpty()
          || !resolvedUniverseDomain.equals(normalizedCredUniverse)) {
        log.warning(
            "Configured universe domain ("
                + resolvedUniverseDomain
                + ") does not match credentials universe domain ("
                + credentialsUniverseDomain
                + "). Skipping Cloud Monitoring metrics export.");
        return false;
      }
      return true;
    } catch (IOException | RuntimeException e) {
      log.log(
          Level.WARNING,
          "Failed to validate credentials universe domain for Cloud Monitoring metrics."
              + " Skipping metrics export: "
              + e.getMessage(),
          e);
      return false;
    }
  }

  @VisibleForTesting
  static boolean isPlaintextOrLoopbackEndpoint(@Nullable String endpoint) {
    if (endpoint == null) {
      return false;
    }
    String trimmed = endpoint.trim();
    if (trimmed.isEmpty()) {
      return false;
    }
    if (trimmed.toLowerCase(Locale.ROOT).startsWith("http://")) {
      return true;
    }
    HostAndPort parsed = parseHostAndPort(trimmed);
    if (parsed == null) {
      return false;
    }
    String host = normalizeHost(parsed.getHost());
    if ("localhost".equals(host) || "0.0.0.0".equals(host)) {
      return true;
    }
    if (host != null && InetAddresses.isInetAddress(host)) {
      return InetAddresses.forString(host).isLoopbackAddress();
    }
    return false;
  }

  @VisibleForTesting
  static String getCloudMonitoringEndpoint(
      @Nullable String endpoint, @Nullable String universeDomain) {
    return getCloudMonitoringEndpoint(endpoint, universeDomain, System::getenv);
  }

  @VisibleForTesting
  static String getCloudMonitoringEndpoint(
      @Nullable String endpoint,
      @Nullable String universeDomain,
      Function<String, String> envProvider) {
    String resolvedUniverseDomain = resolveUniverseDomain(universeDomain, envProvider);
    HostAndPort parsed = parseHostAndPort(endpoint);
    String host = parsed != null ? normalizeHost(parsed.getHost()) : null;
    int port = parsed != null ? parsed.getPortOrDefault(443) : 443;

    String privateHost = "private." + resolvedUniverseDomain;
    String restrictedHost = "restricted." + resolvedUniverseDomain;

    String metricServiceHost;
    if (privateHost.equals(host)) {
      metricServiceHost = privateHost;
    } else if (restrictedHost.equals(host)) {
      metricServiceHost = restrictedHost;
    } else {
      metricServiceHost = "monitoring." + resolvedUniverseDomain;
    }
    return metricServiceHost + ":" + port;
  }

  @VisibleForTesting
  static MetricServiceSettings buildMetricServiceSettings(
      String metricServiceEndpoint, String resolvedUniverseDomain, Credentials credentials)
      throws IOException {
    Preconditions.checkArgument(
        isSupportedCredentialsForMetrics(credentials),
        "Authenticated credentials are required for Cloud Monitoring export.");
    String normalizedUniverseDomain = normalizeUniverseDomain(resolvedUniverseDomain);
    Preconditions.checkArgument(
        !normalizedUniverseDomain.isEmpty(), "The universe domain value cannot be empty.");
    MetricServiceSettings.Builder settingsBuilder =
        MetricServiceSettings.newBuilder()
            .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
            .setUniverseDomain(normalizedUniverseDomain)
            .setEndpoint(metricServiceEndpoint);
    if (!Credentials.GOOGLE_DEFAULT_UNIVERSE.equals(normalizedUniverseDomain)) {
      settingsBuilder.getStubSettingsBuilder().setMtlsEndpoint(null);
    }
    settingsBuilder
        .createMetricDescriptorSettings()
        .setSimpleTimeoutNoRetriesDuration(MetricConfiguration.DEFAULT_DEADLINE);
    return settingsBuilder.build();
  }

  @Nullable
  private static HostAndPort parseHostAndPort(@Nullable String host) {
    if (host == null || host.trim().isEmpty()) {
      return null;
    }
    String s = host.trim();
    String lower = s.toLowerCase(Locale.ROOT);
    boolean schemeStripped = false;
    for (String prefix : STRIPPED_ENDPOINT_SCHEMES) {
      if (lower.startsWith(prefix)) {
        s = s.substring(prefix.length());
        schemeStripped = true;
        break;
      }
    }
    if (!schemeStripped) {
      for (String authorityPrefix : AUTHORITY_ENDPOINT_SCHEMES) {
        if (lower.startsWith(authorityPrefix)) {
          int slashAfterAuthority = s.indexOf('/', authorityPrefix.length());
          if (slashAfterAuthority >= 0) {
            s = s.substring(slashAfterAuthority + 1);
          } else {
            return null;
          }
          break;
        }
      }
    }
    int delimiterIdx = findFirstDelimiter(s);
    if (delimiterIdx >= 0) {
      s = s.substring(0, delimiterIdx);
    }
    int atIdx = s.lastIndexOf('@');
    if (atIdx >= 0) {
      s = s.substring(atIdx + 1);
    }
    if (s.isEmpty()) {
      return null;
    }
    try {
      return HostAndPort.fromString(s);
    } catch (IllegalArgumentException e) {
      return null;
    }
  }

  private static int findFirstDelimiter(String s) {
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '/' || c == '?' || c == '#') {
        return i;
      }
    }
    return -1;
  }

  static String formatStorageEndpoint(@Nullable String host) {
    HostAndPort parsed = parseHostAndPort(host);
    if (parsed == null) {
      return "storage.googleapis.com:443";
    }
    return parsed.withDefaultPort(443).toString();
  }

  @Nullable
  static String extractServerAddress(@Nullable String host) {
    HostAndPort parsed = parseHostAndPort(host);
    return parsed != null ? parsed.getHost() : null;
  }

  @Nullable
  private static String resolveProjectIdForMetrics(
      Attributes detectedAttributes,
      @Nullable String configuredProjectId,
      String metricsTypeLabel) {
    @Nullable String detectedProjectId =
        detectedAttributes.get(AttributeKey.stringKey("cloud.account.id"));
    if (detectedProjectId != null && detectedProjectId.trim().isEmpty()) {
      detectedProjectId = null;
    }
    @Nullable String cleanConfiguredProjectId =
        (configuredProjectId != null && !configuredProjectId.trim().isEmpty())
            ? configuredProjectId.trim()
            : null;
    if (cleanConfiguredProjectId == null && detectedProjectId == null) {
      log.warning(
          "Unable to determine the Project ID in order to report metrics. No "
              + metricsTypeLabel
              + " will be reported.");
      return null;
    }
    String projectIdToUse =
        detectedProjectId != null ? detectedProjectId : cleanConfiguredProjectId;
    if (cleanConfiguredProjectId != null && !projectIdToUse.equals(cleanConfiguredProjectId)) {
      log.warning(
          "The Project ID configured for "
              + metricsTypeLabel
              + " is "
              + projectIdToUse
              + ", but the Project ID of the storage client is "
              + cleanConfiguredProjectId
              + ". Make sure that the service account in use has the required metric writing"
              + " role (roles/monitoring.metricWriter) in the project "
              + projectIdToUse
              + ", or metrics will not be written.");
    }
    return projectIdToUse;
  }

  @Nullable
  static SdkMeterProvider createDefaultClientMeterProvider(
      @Nullable String host,
      @Nullable String configuredProjectId,
      @Nullable String universeDomain,
      @Nullable Credentials credentials,
      @Nullable Duration metricInterval,
      String api) {
    return createDefaultClientMeterProvider(
        host,
        configuredProjectId,
        universeDomain,
        credentials,
        metricInterval,
        api,
        () -> new GCPResourceProvider().getAttributes(),
        System::getenv);
  }

  @VisibleForTesting
  @Nullable
  static SdkMeterProvider createDefaultClientMeterProvider(
      @Nullable String host,
      @Nullable String configuredProjectId,
      @Nullable String universeDomain,
      @Nullable Credentials credentials,
      @Nullable Duration metricInterval,
      String api,
      Attributes detectedAttributes) {
    return createDefaultClientMeterProvider(
        host,
        configuredProjectId,
        universeDomain,
        credentials,
        metricInterval,
        api,
        () -> detectedAttributes,
        System::getenv);
  }

  @VisibleForTesting
  @Nullable
  static SdkMeterProvider createDefaultClientMeterProvider(
      @Nullable String host,
      @Nullable String configuredProjectId,
      @Nullable String universeDomain,
      @Nullable Credentials credentials,
      @Nullable Duration metricInterval,
      String api,
      Attributes detectedAttributes,
      Function<String, String> envProvider) {
    return createDefaultClientMeterProvider(
        host,
        configuredProjectId,
        universeDomain,
        credentials,
        metricInterval,
        api,
        () -> detectedAttributes,
        envProvider);
  }

  @Nullable
  private static SdkMeterProvider createDefaultClientMeterProvider(
      @Nullable String host,
      @Nullable String configuredProjectId,
      @Nullable String universeDomain,
      @Nullable Credentials credentials,
      @Nullable Duration metricInterval,
      String api,
      Supplier<Attributes> detectedAttributesSupplier,
      Function<String, String> envProvider) {
    try {
      if (!isSupportedCredentialsForMetrics(credentials) || isPlaintextOrLoopbackEndpoint(host)) {
        return null;
      }
      String resolvedUniverseDomain = resolveUniverseDomain(universeDomain, envProvider);
      if (!credentialsMatchUniverseDomain(credentials, resolvedUniverseDomain)) {
        return null;
      }
      Attributes detectedAttributes = detectedAttributesSupplier.get();
      String projectIdToUse =
          resolveProjectIdForMetrics(
              detectedAttributes, configuredProjectId, "storage client metrics");
      if (projectIdToUse == null) {
        return null;
      }
      Attributes attributesToUse =
          Attributes.builder()
              .putAll(detectedAttributes)
              .put(AttributeKey.stringKey("cloud.account.id"), projectIdToUse)
              .build();
      String formattedEndpoint = formatStorageEndpoint(host);
      String metricServiceEndpoint =
          getCloudMonitoringEndpoint(formattedEndpoint, resolvedUniverseDomain, envProvider);
      MetricServiceSettings metricServiceSettings =
          buildMetricServiceSettings(metricServiceEndpoint, resolvedUniverseDomain, credentials);
      return createClientMeterProvider(
          metricServiceSettings,
          projectIdToUse,
          attributesToUse,
          metricInterval,
          /* shouldSuppressExceptions= */ true,
          api);
    } catch (Exception e) {
      log.warning("Failed to create default client MeterProvider: " + e.getMessage());
      return null;
    }
  }

  static final ImmutableList<String> CLIENT_LATENCY_HISTOGRAMS =
      ImmutableList.of(
          StorageClientMetrics.METRIC_RPC_CLIENT_CALL_DURATION,
          StorageClientMetrics.METRIC_HTTP_CLIENT_REQUEST_DURATION,
          StorageClientMetrics.METRIC_GCP_CLIENT_REQUEST_DURATION,
          StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_TTFB,
          StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_SERVER_DURATION,
          StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_STALL_DURATION,
          StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_AUTH_CREDENTIAL_REFRESH_DURATION);

  static final ImmutableList<String> CLIENT_SIZE_HISTOGRAMS =
      ImmutableList.of(
          StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_BODY_SIZE,
          StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_RESPONSE_BODY_SIZE);

  static final ImmutableList<String> CLIENT_COUNTERS =
      ImmutableList.of(
          StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_OPERATIONS,
          StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ATTEMPTS,
          StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_ERRORS,
          StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_REQUEST_ACTIVE,
          StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_SERVER_UNREACHED,
          StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_NETWORK_IO);

  @VisibleForTesting
  static MetricConfiguration createGrpcMetricConfiguration(
      MetricServiceSettings metricServiceSettings, String projectIdToUse) {
    MonitoredResourceDescription monitoredResourceDescription =
        new MonitoredResourceDescription(
            "storage.googleapis.com/Client",
            ImmutableSet.of(
                "project_id", "location", "cloud_platform", "host_id", "instance_id", "api"));

    return MetricConfiguration.builder()
        .setMonitoredResourceDescription(monitoredResourceDescription)
        .setInstrumentationLibraryLabelsEnabled(false)
        .setMetricServiceSettings(metricServiceSettings)
        .setPrefix("storage.googleapis.com/client")
        .setUseServiceTimeSeries(true)
        .setProjectId(projectIdToUse)
        .build();
  }

  @VisibleForTesting
  static MetricConfiguration createClientMetricConfiguration(
      MetricServiceSettings metricServiceSettings, String projectIdToUse) {
    return MetricConfiguration.builder()
        .setInstrumentationLibraryLabelsEnabled(false)
        .setMetricServiceSettings(metricServiceSettings)
        .setPrefix("custom.googleapis.com")
        .setUseServiceTimeSeries(false)
        .setProjectId(projectIdToUse)
        .build();
  }

  @VisibleForTesting
  static SdkMeterProvider createMeterProvider(
      MetricServiceSettings metricServiceSettings,
      String projectIdToUse,
      Attributes detectedAttributes,
      boolean shouldSuppressExceptions) {

    MetricExporter cloudMonitoringExporter =
        GoogleCloudMetricExporter.createWithConfiguration(
            createGrpcMetricConfiguration(metricServiceSettings, projectIdToUse));

    SdkMeterProviderBuilder providerBuilder = SdkMeterProvider.builder();

    // This replaces the dots with slashes in each metric, which is the format needed for this
    // monitored resource
    for (String metric :
        ImmutableList.copyOf(Iterables.concat(METRICS_TO_ENABLE, METRICS_ENABLED_BY_DEFAULT))) {
      providerBuilder.registerView(
          InstrumentSelector.builder().setName(metric).build(),
          View.builder().setName(metric.replace(".", "/")).build());
    }
    addHistogramView(
        providerBuilder,
        latencyHistogramBoundaries(),
        "grpc/client/attempt/duration",
        "grpc/client/attempt/duration",
        "grpc-java",
        "s",
        "A view of grpc/client/attempt/duration with histogram boundaries more appropriate for"
            + " Google Cloud Storage RPCs");
    addHistogramView(
        providerBuilder,
        sizeHistogramBoundaries(),
        "grpc/client/attempt/rcvd_total_compressed_message_size",
        "grpc/client/attempt/rcvd_total_compressed_message_size",
        "grpc-java",
        "By",
        "A view of grpc/client/attempt/rcvd_total_compressed_message_size with histogram boundaries"
            + " more appropriate for Google Cloud Storage RPCs");
    addHistogramView(
        providerBuilder,
        sizeHistogramBoundaries(),
        "grpc/client/attempt/sent_total_compressed_message_size",
        "grpc/client/attempt/sent_total_compressed_message_size",
        "grpc-java",
        "By",
        "A view of grpc/client/attempt/sent_total_compressed_message_size with histogram boundaries"
            + " more appropriate for Google Cloud Storage RPCs");

    return buildMeterProvider(
        cloudMonitoringExporter,
        providerBuilder,
        projectIdToUse,
        null,
        "grpc",
        "storage.googleapis.com/Client",
        detectedAttributes,
        Duration.ofSeconds(60),
        shouldSuppressExceptions);
  }

  @VisibleForTesting
  static SdkMeterProvider createClientMeterProvider(
      MetricServiceSettings metricServiceSettings,
      String projectIdToUse,
      Attributes detectedAttributes,
      boolean shouldSuppressExceptions,
      String api) {
    return createClientMeterProvider(
        metricServiceSettings,
        projectIdToUse,
        null,
        detectedAttributes,
        Duration.ofSeconds(60),
        shouldSuppressExceptions,
        api);
  }

  @VisibleForTesting
  static SdkMeterProvider createClientMeterProvider(
      MetricServiceSettings metricServiceSettings,
      String projectIdToUse,
      Attributes detectedAttributes,
      Duration metricInterval,
      boolean shouldSuppressExceptions,
      String api) {
    return createClientMeterProvider(
        metricServiceSettings,
        projectIdToUse,
        null,
        detectedAttributes,
        metricInterval,
        shouldSuppressExceptions,
        api);
  }

  /**
   * Creates an {@link SdkMeterProvider} configured for custom client metrics with the {@code
   * custom.googleapis.com} prefix and default monitored resource with client metric views and Cloud
   * Monitoring exporter.
   *
   * @param metricServiceSettings the Cloud Monitoring service settings to export metrics with
   * @param projectIdToUse the GCP project ID to associate with the monitored resource
   * @param instanceId the client instance ID to associate with the monitored resource, or null to
   *     generate a random UUID
   * @param detectedAttributes environment-detected resource attributes
   * @param metricInterval export interval for the periodic metric reader
   * @param shouldSuppressExceptions whether exporter exceptions should be suppressed
   * @param api the transport/API protocol distinguishing the client in Cloud Monitoring (e.g.,
   *     {@code "grpc"} for gRPC transport or {@code "json"} for HTTP/JSON transport).
   * @return the configured {@link SdkMeterProvider}
   */
  @VisibleForTesting
  static SdkMeterProvider createClientMeterProvider(
      MetricServiceSettings metricServiceSettings,
      String projectIdToUse,
      @Nullable String instanceId,
      Attributes detectedAttributes,
      @Nullable Duration metricInterval,
      boolean shouldSuppressExceptions,
      String api) {
    Objects.requireNonNull(api, "api must not be null");

    MetricExporter cloudMonitoringExporter =
        GoogleCloudMetricExporter.createWithConfiguration(
            createClientMetricConfiguration(metricServiceSettings, projectIdToUse));

    SdkMeterProviderBuilder providerBuilder = SdkMeterProvider.builder();

    // Register views for client histograms and counters
    registerClientViews(providerBuilder);

    return buildMeterProvider(
        cloudMonitoringExporter,
        providerBuilder,
        projectIdToUse,
        instanceId,
        api,
        null,
        detectedAttributes,
        metricInterval,
        shouldSuppressExceptions);
  }

  private static SdkMeterProvider buildMeterProvider(
      MetricExporter cloudMonitoringExporter,
      SdkMeterProviderBuilder providerBuilder,
      String projectIdToUse,
      @Nullable String instanceId,
      String api,
      @Nullable String customResourceType,
      Attributes detectedAttributes,
      @Nullable Duration metricInterval,
      boolean shouldSuppressExceptions) {
    MetricExporter exporter =
        shouldSuppressExceptions
            ? new PermissionDeniedSingleReportMetricsExporter(cloudMonitoringExporter)
            : cloudMonitoringExporter;
    AttributesBuilder attributesBuilder = Attributes.builder();
    if (detectedAttributes != null) {
      attributesBuilder.putAll(detectedAttributes);
    }
    attributesBuilder
        .put("project_id", projectIdToUse)
        .put("instance_id", instanceId != null ? instanceId : UUID.randomUUID().toString())
        .put("api", api);
    if (customResourceType != null) {
      attributesBuilder.put("gcp.resource_type", customResourceType);
    }
    String detectedLocation =
        detectedAttributes != null
            ? detectedAttributes.get(AttributeKey.stringKey("cloud.region"))
            : null;
    attributesBuilder.put("location", detectedLocation != null ? detectedLocation : "global");
    String detectedCloudPlatform =
        detectedAttributes != null
            ? detectedAttributes.get(AttributeKey.stringKey("cloud.platform"))
            : null;
    attributesBuilder.put(
        "cloud_platform", detectedCloudPlatform != null ? detectedCloudPlatform : "unknown");
    String detectedHostId =
        detectedAttributes != null
            ? detectedAttributes.get(AttributeKey.stringKey("host.id"))
            : null;
    attributesBuilder.put("host_id", detectedHostId != null ? detectedHostId : "unknown");

    providerBuilder
        .registerMetricReader(
            PeriodicMetricReader.builder(exporter)
                .setInterval(metricInterval != null ? metricInterval : Duration.ofSeconds(60))
                .build())
        .setResource(Resource.create(attributesBuilder.build()));

    return providerBuilder.build();
  }

  @VisibleForTesting
  static SdkMeterProviderBuilder registerClientViews(SdkMeterProviderBuilder providerBuilder) {
    for (String metric : CLIENT_COUNTERS) {
      providerBuilder.registerView(
          InstrumentSelector.builder()
              .setMeterName(StorageClientMetrics.METER_NAME)
              .setName(metric)
              .build(),
          View.builder().setName(metric.replace(".", "/")).build());
    }
    for (String metric : CLIENT_LATENCY_HISTOGRAMS) {
      addHistogramView(
          providerBuilder,
          latencyHistogramBoundaries(),
          metric,
          metric.replace(".", "/"),
          StorageClientMetrics.METER_NAME,
          null,
          null);
    }
    for (String metric : CLIENT_SIZE_HISTOGRAMS) {
      addHistogramView(
          providerBuilder,
          sizeHistogramBoundaries(),
          metric,
          metric.replace(".", "/"),
          StorageClientMetrics.METER_NAME,
          null,
          null);
    }
    return providerBuilder;
  }

  private static void addHistogramView(
      SdkMeterProviderBuilder provider,
      List<Double> boundaries,
      String instrumentName,
      String viewName,
      String meterName,
      @Nullable String unit,
      @Nullable String description) {
    InstrumentSelectorBuilder selector =
        InstrumentSelector.builder()
            .setType(InstrumentType.HISTOGRAM)
            .setMeterName(meterName)
            .setName(instrumentName);
    if (unit != null) {
      selector.setUnit(unit);
    }
    ViewBuilder view =
        View.builder()
            .setName(viewName)
            .setAggregation(Aggregation.explicitBucketHistogram(boundaries));
    if (description != null) {
      view.setDescription(description);
    }
    provider.registerView(selector.build(), view.build());
  }

  static List<Double> latencyHistogramBoundaries() {
    List<Double> boundaries = new ArrayList<>();
    BigDecimal boundary = new BigDecimal(0, MathContext.UNLIMITED);
    BigDecimal increment = new BigDecimal("0.002", MathContext.UNLIMITED); // 2ms

    // 2ms buckets for the first 100ms, so we can have higher resolution for uploads and downloads
    // in the 100 KiB range
    for (int i = 0; i != 50; i++) {
      boundaries.add(boundary.doubleValue());
      boundary = boundary.add(increment);
    }

    // For the remaining buckets do 10 10ms, 10 20ms, and so on, up until 5 minutes
    increment = new BigDecimal("0.01", MathContext.UNLIMITED); // 10 ms
    for (int i = 0; i != 150 && boundary.compareTo(new BigDecimal(300)) < 1; i++) {
      boundaries.add(boundary.doubleValue());
      if (i != 0 && i % 10 == 0) {
        increment = increment.multiply(new BigDecimal(2));
      }
      boundary = boundary.add(increment);
    }

    return boundaries;
  }

  static List<Double> sizeHistogramBoundaries() {
    long kb = 1024;
    long mb = 1024 * kb;
    long gb = 1024 * mb;

    List<Double> boundaries = new ArrayList<>();
    long boundary = 0;
    long increment = 128 * kb;

    // 128 KiB increments up to 4MiB, then exponential growth
    while (boundaries.size() < 200 && boundary <= 16 * gb) {
      boundaries.add((double) boundary);
      boundary += increment;
      if (boundary >= 4 * mb) {
        increment *= 2;
      }
    }
    return boundaries;
  }

  static List<Long> sizeHistogramLongBoundaries() {
    return sizeHistogramBoundaries().stream().map(Double::longValue).collect(Collectors.toList());
  }

  private static final class PermissionDeniedSingleReportMetricsExporter implements MetricExporter {
    private final MetricExporter delegate;
    private final AtomicBoolean seenPermissionDenied = new AtomicBoolean(false);
    private final AtomicBoolean seenNoRouteToHost = new AtomicBoolean(false);

    private PermissionDeniedSingleReportMetricsExporter(MetricExporter delegate) {
      this.delegate = delegate;
    }

    @Override
    public CompletableResultCode export(Collection<MetricData> metrics) {
      if (seenPermissionDenied.get() && seenNoRouteToHost.get()) {
        return CompletableResultCode.ofFailure();
      }

      try {
        return delegate.export(metrics);
      } catch (PermissionDeniedException e) {
        if (!seenPermissionDenied.get()) {
          seenPermissionDenied.set(true);
          throw e;
        }
        return CompletableResultCode.ofFailure();
      } catch (UnavailableException e) {
        if (seenPermissionDenied.get()
            && !seenNoRouteToHost.get()
            && ultimateCause(e, NoRouteToHostException.class)) {
          seenNoRouteToHost.set(true);
          throw e;
        }
        return CompletableResultCode.ofFailure();
      }
    }

    @Override
    public Aggregation getDefaultAggregation(InstrumentType instrumentType) {
      return delegate.getDefaultAggregation(instrumentType);
    }

    @Override
    public MemoryMode getMemoryMode() {
      return delegate.getMemoryMode();
    }

    @Override
    public CompletableResultCode flush() {
      return delegate.flush();
    }

    @Override
    public CompletableResultCode shutdown() {
      return delegate.shutdown();
    }

    @Override
    public void close() {
      delegate.close();
    }

    @Override
    public AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
      return delegate.getAggregationTemporality(instrumentType);
    }

    @Override
    public DefaultAggregationSelector with(InstrumentType instrumentType, Aggregation aggregation) {
      return delegate.with(instrumentType, aggregation);
    }

    private static boolean ultimateCause(Throwable t, Class<? extends Throwable> c) {
      if (t == null) {
        return false;
      }

      Throwable cause = t.getCause();
      if (cause != null && c.isAssignableFrom(cause.getClass())) {
        return true;
      } else {
        return ultimateCause(cause, c);
      }
    }
  }
}
