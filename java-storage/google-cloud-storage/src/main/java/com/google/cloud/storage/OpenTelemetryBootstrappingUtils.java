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
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.api.gax.rpc.UnavailableException;
import com.google.cloud.opentelemetry.metric.GoogleCloudMetricExporter;
import com.google.cloud.opentelemetry.metric.MetricConfiguration;
import com.google.cloud.opentelemetry.metric.MonitoredResourceDescription;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import io.grpc.ManagedChannelBuilder;
import io.grpc.opentelemetry.GrpcOpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.internal.StringUtils;
import io.opentelemetry.contrib.gcp.resource.GCPResourceProvider;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.export.MemoryMode;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import io.opentelemetry.sdk.resources.Resource;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.NoRouteToHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
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
      String universeDomain,
      boolean shouldSuppressExceptions) {
    GCPResourceProvider resourceProvider = new GCPResourceProvider();
    Attributes detectedAttributes = resourceProvider.getAttributes();

    @Nullable String detectedProjectId =
        detectedAttributes.get(AttributeKey.stringKey("cloud.account.id"));
    if (projectId == null && detectedProjectId == null) {
      log.warning(
          "Unable to determine the Project ID in order to report metrics. No gRPC client metrics"
              + " will be reported.");
      return channelConfigurator != null ? channelConfigurator : ChannelConfigurator.identity();
    }

    String projectIdToUse = detectedProjectId == null ? projectId : detectedProjectId;
    if (!projectIdToUse.equals(projectId)) {
      log.warning(
          "The Project ID configured for gRPC client metrics is "
              + projectIdToUse
              + ", but the Project ID of the storage client is "
              + projectId
              + ". Make sure that the service account in use has the required metric writing role "
              + "(roles/monitoring.metricWriter) in the project "
              + projectIdToUse
              + ", or metrics will not be written.");
    }

    String metricServiceEndpoint = getCloudMonitoringEndpoint(endpoint, universeDomain);
    SdkMeterProvider provider =
        createMeterProvider(
            metricServiceEndpoint, projectIdToUse, detectedAttributes, shouldSuppressExceptions);

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

  @VisibleForTesting
  static String getCloudMonitoringEndpoint(String endpoint, String universeDomain) {
    String metricServiceEndpoint = "monitoring.googleapis.com";

    // use contains instead of equals because endpoint has a port in it
    if (universeDomain != null && endpoint.contains("storage." + universeDomain)) {
      metricServiceEndpoint = "monitoring." + universeDomain;
    } else if (!endpoint.contains("storage.googleapis.com")) {
      String canonicalEndpoint = "storage.googleapis.com";
      String privateEndpoint = "private.googleapis.com";
      String restrictedEndpoint = "restricted.googleapis.com";
      if (universeDomain != null) {
        canonicalEndpoint = "storage." + universeDomain;
        privateEndpoint = "private." + universeDomain;
        restrictedEndpoint = "restricted." + universeDomain;
      }
      String match =
          ImmutableList.of(canonicalEndpoint, privateEndpoint, restrictedEndpoint).stream()
              .filter(s -> endpoint.contains(s) || endpoint.contains("google-c2p:///" + s))
              .collect(Collectors.joining());
      if (!StringUtils.isNullOrEmpty(match)) {
        metricServiceEndpoint = match;
      }
    }
    return metricServiceEndpoint + ":" + endpoint.split(":")[1];
  }

  @VisibleForTesting
  static SdkMeterProvider createMeterProvider(
      String metricServiceEndpoint,
      String projectIdToUse,
      Attributes detectedAttributes,
      boolean shouldSuppressExceptions) {

    MonitoredResourceDescription monitoredResourceDescription =
        new MonitoredResourceDescription(
            "storage.googleapis.com/Client",
            ImmutableSet.of(
                "project_id", "location", "cloud_platform", "host_id", "instance_id", "api"));

    MetricExporter cloudMonitoringExporter =
        GoogleCloudMetricExporter.createWithConfiguration(
            MetricConfiguration.builder()
                .setMonitoredResourceDescription(monitoredResourceDescription)
                .setInstrumentationLibraryLabelsEnabled(false)
                .setMetricServiceEndpoint(metricServiceEndpoint)
                .setPrefix("storage.googleapis.com/client")
                .setUseServiceTimeSeries(true)
                .setProjectId(projectIdToUse)
                .build());

    SdkMeterProviderBuilder providerBuilder = SdkMeterProvider.builder();

    // This replaces the dots with slashes in each metric, which is the format needed for this
    // monitored resource
    for (String metric :
        ImmutableList.copyOf(Iterables.concat(METRICS_TO_ENABLE, METRICS_ENABLED_BY_DEFAULT))) {
      providerBuilder.registerView(
          InstrumentSelector.builder().setName(metric).build(),
          View.builder().setName(metric.replace(".", "/")).build());
    }
    MetricExporter exporter =
        shouldSuppressExceptions
            ? new PermissionDeniedSingleReportMetricsExporter(cloudMonitoringExporter)
            : cloudMonitoringExporter;
    AttributesBuilder attributesBuilder =
        Attributes.builder()
            .put("gcp.resource_type", "storage.googleapis.com/Client")
            .put("project_id", projectIdToUse)
            .put("instance_id", UUID.randomUUID().toString())
            .put("api", "grpc");
    String detectedLocation = detectedAttributes.get(AttributeKey.stringKey("cloud.region"));
    if (detectedLocation != null) {
      attributesBuilder.put("location", detectedLocation);
    } else {
      attributesBuilder.put("location", "global");
    }
    String detectedCloudPlatform = detectedAttributes.get(AttributeKey.stringKey("cloud.platform"));
    if (detectedCloudPlatform != null) {
      attributesBuilder.put("cloud_platform", detectedCloudPlatform);
    } else {
      attributesBuilder.put("cloud_platform", "unknown");
    }
    String detectedHostId = detectedAttributes.get(AttributeKey.stringKey("host.id"));
    if (detectedHostId != null) {
      attributesBuilder.put("host_id", detectedHostId);
    } else {
      attributesBuilder.put("host_id", "unknown");
    }
    providerBuilder
        .registerMetricReader(
            PeriodicMetricReader.builder(exporter)
                .setInterval(java.time.Duration.ofSeconds(60))
                .build())
        .setResource(Resource.create(attributesBuilder.build()));

    addHistogramView(
        providerBuilder, latencyHistogramBoundaries(), "grpc/client/attempt/duration", "s");
    addHistogramView(
        providerBuilder,
        sizeHistogramBoundaries(),
        "grpc/client/attempt/rcvd_total_compressed_message_size",
        "By");
    addHistogramView(
        providerBuilder,
        sizeHistogramBoundaries(),
        "grpc/client/attempt/sent_total_compressed_message_size",
        "By");

    return providerBuilder.build();
  }

  private static void addHistogramView(
      SdkMeterProviderBuilder provider, List<Double> boundaries, String name, String unit) {
    InstrumentSelector instrumentSelector =
        InstrumentSelector.builder()
            .setType(InstrumentType.HISTOGRAM)
            .setUnit(unit)
            .setName(name)
            .setMeterName("grpc-java")
            .setMeterSchemaUrl("")
            .build();
    View view =
        View.builder()
            .setName(name)
            .setDescription(
                "A view of "
                    + name
                    + " with histogram boundaries more appropriate for Google Cloud Storage RPCs")
            .setAggregation(Aggregation.explicitBucketHistogram(boundaries))
            .build();
    provider.registerView(instrumentSelector, view);
  }

  private static List<Double> latencyHistogramBoundaries() {
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

  private static List<Double> sizeHistogramBoundaries() {
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
