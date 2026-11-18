/*
 * Copyright 2025 Google LLC
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
import static org.junit.Assert.assertThrows;
import static org.junit.Assume.assumeFalse;
import static org.mockito.Mockito.mock;

import com.google.cloud.storage.OpenTelemetryBootstrappingUtils.ChannelConfigurator;
import com.google.cloud.storage.OpenTelemetryBootstrappingUtils.GrpcMetricsChannelConfigurator;
import com.google.common.collect.ImmutableList;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.junit.Test;

public final class OpenTelemetryBootstrappingUtilsTest {

  @Test
  public void noErrorIfNotRunningOnGcp() {
    assumeFalse("Skipping because running on GCP", TestUtils.isOnComputeEngine());

    ChannelConfigurator cc = ChannelConfigurator.identity();

    String endpoint = "storage.googleapis.com:443";
    String projectId = null;
    String universeDomain = null;
    ChannelConfigurator actual =
        OpenTelemetryBootstrappingUtils.enableGrpcMetrics(
            cc, endpoint, projectId, universeDomain, true);

    assertThat(actual).isSameInstanceAs(cc);
  }

  @SuppressWarnings("rawtypes") // ManagedChannelBuilder
  @Test
  public void channelConfigurator_andThen() {
    ManagedChannelBuilder b1 = mock(ManagedChannelBuilder.class, "b1");
    ManagedChannelBuilder b2 = mock(ManagedChannelBuilder.class, "b2");
    ManagedChannelBuilder b3 = mock(ManagedChannelBuilder.class, "b2");

    ChannelConfigurator cc1 =
        b -> {
          assertThat(b).isSameInstanceAs(b1);
          return b2;
        };
    ChannelConfigurator cc2 =
        b -> {
          assertThat(b).isSameInstanceAs(b2);
          return b3;
        };

    ChannelConfigurator cc3 = cc1.andThen(cc2);

    ManagedChannelBuilder apply = cc3.apply(b1);
    assertThat(apply).isSameInstanceAs(b3);
  }

  @Test
  public void channelConfigurator_lift_nullToIdentity() {
    ChannelConfigurator actual = ChannelConfigurator.lift(null);
    assertThat(actual).isSameInstanceAs(ChannelConfigurator.identity());
  }

  @SuppressWarnings("rawtypes") // ManagedChannelBuilder
  @Test
  public void channelConfigurator_lift_plumbingWorks() {
    ManagedChannelBuilder b1 = mock(ManagedChannelBuilder.class, "b1");
    AtomicBoolean called = new AtomicBoolean(false);
    ChannelConfigurator lifted =
        ChannelConfigurator.lift(
            b -> {
              called.compareAndSet(false, true);
              return b;
            });
    ManagedChannelBuilder actual = lifted.apply(b1);
    assertThat(actual).isSameInstanceAs(b1);
    assertThat(called.get()).isTrue();
  }

  @Test
  public void channelConfigurator_andThen_nullsafe() {
    ChannelConfigurator actual = ChannelConfigurator.identity().andThen(null);
    assertThat(actual).isSameInstanceAs(ChannelConfigurator.identity());
  }

  @Test
  public void histogramBoundaries_areValidAndIncreasing() {
    List<Double> latencyBoundaries = OpenTelemetryBootstrappingUtils.latencyHistogramBoundaries();
    assertThat(latencyBoundaries).isNotEmpty();
    assertThat(latencyBoundaries).isInStrictOrder();

    List<Double> sizeBoundaries = OpenTelemetryBootstrappingUtils.sizeHistogramBoundaries();
    assertThat(sizeBoundaries).isNotEmpty();
    assertThat(sizeBoundaries).isInStrictOrder();

    List<Long> sizeLongBoundaries = OpenTelemetryBootstrappingUtils.sizeHistogramLongBoundaries();
    assertThat(sizeLongBoundaries).hasSize(sizeBoundaries.size());
    assertThat(sizeLongBoundaries).isInStrictOrder();
  }

  @Test
  public void registerClientViews_doesNotThrow() {
    SdkMeterProviderBuilder builder = SdkMeterProvider.builder();
    SdkMeterProviderBuilder returned = OpenTelemetryBootstrappingUtils.registerClientViews(builder);
    assertThat(returned).isSameInstanceAs(builder);
  }

  @Test
  public void createClientMeterProvider_attachesApiAttribute() {
    Attributes detectedAttributes = Attributes.empty();

    try (SdkMeterProvider grpcProvider =
        OpenTelemetryBootstrappingUtils.createClientMeterProvider(
            "monitoring.googleapis.com:443",
            "test-project",
            detectedAttributes,
            Duration.ofSeconds(60),
            true,
            "grpc")) {
      assertThat(grpcProvider.toString()).contains("api=\"grpc\"");
      assertThat(grpcProvider.toString())
          .doesNotContain("gcp.resource_type=\"storage.googleapis.com/Client\"");
    }

    try (SdkMeterProvider jsonProvider =
        OpenTelemetryBootstrappingUtils.createClientMeterProvider(
            "monitoring.googleapis.com:443",
            "test-project",
            detectedAttributes,
            Duration.ofSeconds(60),
            true,
            "json")) {
      assertThat(jsonProvider.toString()).contains("api=\"json\"");
      assertThat(jsonProvider.toString())
          .doesNotContain("gcp.resource_type=\"storage.googleapis.com/Client\"");
    }

    assertThrows(
        NullPointerException.class,
        () ->
            OpenTelemetryBootstrappingUtils.createClientMeterProvider(
                "monitoring.googleapis.com:443",
                "test-project",
                detectedAttributes,
                Duration.ofSeconds(60),
                true,
                null));

    try (SdkMeterProvider legacyProvider =
        OpenTelemetryBootstrappingUtils.createMeterProvider(
            "monitoring.googleapis.com:443", "test-project", detectedAttributes, true)) {
      assertThat(legacyProvider.toString()).contains("api=\"grpc\"");
      assertThat(legacyProvider.toString())
          .contains("gcp.resource_type=\"storage.googleapis.com/Client\"");
    }
  }

  @Test
  public void createClientMeterProvider_customInstanceId_attachesInstanceIdAttribute() {
    Attributes detectedAttributes = Attributes.empty();
    String customInstanceId = "custom-instance-12345";

    try (SdkMeterProvider provider =
        OpenTelemetryBootstrappingUtils.createClientMeterProvider(
            "monitoring.googleapis.com:443",
            "test-project",
            customInstanceId,
            detectedAttributes,
            Duration.ofSeconds(60),
            true,
            "grpc")) {
      assertThat(provider.toString()).contains("instance_id=\"" + customInstanceId + "\"");
    }
  }

  @Test
  public void createClientMeterProvider_preservesDetectedAttributes() {
    Attributes detectedAttributes =
        Attributes.builder()
            .put("cloud.platform", "gcp_kubernetes_engine")
            .put("cloud.availability_zone", "us-central1-a")
            .put("host.id", "test-host-123")
            .build();

    try (SdkMeterProvider provider =
        OpenTelemetryBootstrappingUtils.createClientMeterProvider(
            "monitoring.googleapis.com:443",
            "test-project",
            "test-instance",
            detectedAttributes,
            Duration.ofSeconds(60),
            true,
            "grpc")) {
      assertThat(provider.toString()).contains("cloud.platform=\"gcp_kubernetes_engine\"");
      assertThat(provider.toString()).contains("cloud.availability_zone=\"us-central1-a\"");
      assertThat(provider.toString()).contains("host.id=\"test-host-123\"");
    }
  }

  @Test
  public void extractServerAddress_parsesVariousHostFormats() {
    assertThat(
            OpenTelemetryBootstrappingUtils.extractServerAddress("https://storage.googleapis.com"))
        .isEqualTo("storage.googleapis.com");
    assertThat(OpenTelemetryBootstrappingUtils.extractServerAddress("http://localhost:8080"))
        .isEqualTo("localhost");
    assertThat(
            OpenTelemetryBootstrappingUtils.extractServerAddress(
                "google-c2p:///storage.googleapis.com"))
        .isEqualTo("storage.googleapis.com");
    assertThat(
            OpenTelemetryBootstrappingUtils.extractServerAddress(
                "https://storage.googleapis.com/path"))
        .isEqualTo("storage.googleapis.com");
    assertThat(OpenTelemetryBootstrappingUtils.extractServerAddress("http://[::1]:8080"))
        .isEqualTo("::1");
    assertThat(OpenTelemetryBootstrappingUtils.extractServerAddress("[::1]")).isEqualTo("::1");
    assertThat(OpenTelemetryBootstrappingUtils.extractServerAddress("http://host:invalid"))
        .isNull();
    assertThat(OpenTelemetryBootstrappingUtils.extractServerAddress(null)).isNull();
    assertThat(OpenTelemetryBootstrappingUtils.extractServerAddress("   ")).isNull();
  }

  @Test
  public void formatStorageEndpoint_formatsVariousHostFormats() {
    assertThat(OpenTelemetryBootstrappingUtils.formatStorageEndpoint(null))
        .isEqualTo("storage.googleapis.com:443");
    assertThat(OpenTelemetryBootstrappingUtils.formatStorageEndpoint("   "))
        .isEqualTo("storage.googleapis.com:443");
    assertThat(
            OpenTelemetryBootstrappingUtils.formatStorageEndpoint("https://storage.googleapis.com"))
        .isEqualTo("storage.googleapis.com:443");
    assertThat(OpenTelemetryBootstrappingUtils.formatStorageEndpoint("http://localhost:8080/"))
        .isEqualTo("localhost:8080");
    assertThat(
            OpenTelemetryBootstrappingUtils.formatStorageEndpoint(
                "google-c2p:///storage.googleapis.com"))
        .isEqualTo("storage.googleapis.com:443");
    assertThat(OpenTelemetryBootstrappingUtils.formatStorageEndpoint("http://[::1]:8080"))
        .isEqualTo("[::1]:8080");
    assertThat(OpenTelemetryBootstrappingUtils.formatStorageEndpoint("[::1]"))
        .isEqualTo("[::1]:443");
    assertThat(OpenTelemetryBootstrappingUtils.formatStorageEndpoint("http://host:invalid"))
        .isEqualTo("storage.googleapis.com:443");
  }

  @Test
  public void getCloudMonitoringEndpoint_extractsPortFromIpv4AndIpv6Endpoints() {
    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "storage.googleapis.com:443", "googleapis.com"))
        .isEqualTo("monitoring.googleapis.com:443");
    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "[::1]:8080", "googleapis.com"))
        .isEqualTo("monitoring.googleapis.com:8080");
    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "[::1]:8443", "googleapis.com"))
        .isEqualTo("monitoring.googleapis.com:8443");
    assertThat(OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint("::1", "googleapis.com"))
        .isEqualTo("monitoring.googleapis.com:443");
    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "[::1]:invalid", "googleapis.com"))
        .isEqualTo("monitoring.googleapis.com:443");
    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "storage.my-universe.com:8443", "my-universe.com"))
        .isEqualTo("monitoring.my-universe.com:8443");
    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "storage.googleapis.com:443", null))
        .isEqualTo("monitoring.googleapis.com:443");
  }

  @Test
  public void getCloudMonitoringEndpoint_directPathInterconnectAndC2pEndpoints() {
    ImmutableList<String[]> cases =
        ImmutableList.of(
            new String[] {
              "storage-direct.googleapis.com:443", null, "monitoring.googleapis.com:443"
            },
            new String[] {
              "storage-preprod-direct.sandbox.googleapis.com:443",
              null,
              "monitoring.googleapis.com:443"
            },
            new String[] {
              "storage-direct.apis-tpclp.goog:443",
              "apis-tpclp.goog",
              "monitoring.apis-tpclp.goog:443"
            },
            new String[] {
              "google-c2p:///storage-direct.googleapis.com?force-xds",
              null,
              "monitoring.googleapis.com:443"
            },
            new String[] {
              "google-c2p-experimental:///storage-preprod-direct.sandbox.googleapis.com:443?force-xds",
              null,
              "monitoring.googleapis.com:443"
            },
            new String[] {null, null, "monitoring.googleapis.com:443"},
            new String[] {"", null, "monitoring.googleapis.com:443"});
    for (String[] c : cases) {
      assertWithMessage("endpoint=%s, universe=%s", c[0], c[1])
          .that(OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(c[0], c[1]))
          .isEqualTo(c[2]);
    }
  }

  @Test
  public void registerGrpcChannelViews_exportsChannelCreationLatencyWithSecondsBuckets() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProviderBuilder providerBuilder =
        SdkMeterProvider.builder().registerMetricReader(metricReader);
    SdkMeterProviderBuilder returned =
        OpenTelemetryBootstrappingUtils.registerGrpcChannelViews(providerBuilder);
    assertThat(returned).isSameInstanceAs(providerBuilder);

    try (SdkMeterProvider meterProvider = providerBuilder.build()) {
      BiConsumer<String, Duration> recorder =
          OpenTelemetryBootstrappingUtils.createChannelCreationLatencyRecorder(meterProvider);
      recorder.accept("DirectPath", Duration.ofMillis(3));
      recorder.accept("DirectPathInterconnect", Duration.ofMillis(1200));
      recorder.accept("CloudPath", Duration.ofSeconds(45));

      Collection<MetricData> metrics = metricReader.collectAllMetrics();
      assertThat(metrics).hasSize(1);
      MetricData metricData = metrics.iterator().next();
      assertThat(metricData.getName())
          .isEqualTo(OpenTelemetryBootstrappingUtils.CHANNEL_CREATION_LATENCY_VIEW_NAME);
      assertThat(metricData.getUnit())
          .isEqualTo(OpenTelemetryBootstrappingUtils.CHANNEL_CREATION_LATENCY_UNIT);
      assertThat(metricData.getDescription())
          .isEqualTo(OpenTelemetryBootstrappingUtils.CHANNEL_CREATION_LATENCY_DESCRIPTION);

      Map<String, HistogramPointData> pointsByTransport =
          metricData.getHistogramData().getPoints().stream()
              .collect(
                  Collectors.toMap(
                      p ->
                          p.getAttributes().get(OpenTelemetryBootstrappingUtils.TRANSPORT_TYPE_KEY),
                      Function.identity()));
      assertThat(pointsByTransport.keySet())
          .containsExactly("DirectPath", "DirectPathInterconnect", "CloudPath");

      HistogramPointData dpPoint = pointsByTransport.get("DirectPath");
      HistogramPointData dpInterconnectPoint = pointsByTransport.get("DirectPathInterconnect");
      HistogramPointData cloudPathPoint = pointsByTransport.get("CloudPath");

      assertThat(dpPoint.getSum()).isWithin(1e-6).of(0.003);
      assertThat(dpInterconnectPoint.getSum()).isWithin(1e-6).of(1.2);
      assertThat(cloudPathPoint.getSum()).isWithin(1e-6).of(45.0);

      List<Double> boundaries = dpPoint.getBoundaries();
      int idx003 = findBucketIndex(boundaries, 0.003);
      int idx12 = findBucketIndex(boundaries, 1.2);
      int idx45 = findBucketIndex(boundaries, 45.0);
      assertThat(idx003).isEqualTo(2);
      assertThat(idx12).isGreaterThan(idx003);
      assertThat(idx45).isGreaterThan(idx12);
      assertThat(dpPoint.getCounts().get(idx003)).isEqualTo(1L);
      assertThat(dpInterconnectPoint.getCounts().get(idx12)).isEqualTo(1L);
      assertThat(cloudPathPoint.getCounts().get(idx45)).isEqualTo(1L);
    }
  }

  @SuppressWarnings("rawtypes") // ManagedChannelBuilder
  @Test
  public void grpcMetricsChannelConfigurator_delegatesAndSuppliesMeterProvider() {
    ManagedChannelBuilder b1 = mock(ManagedChannelBuilder.class, "b1");
    ManagedChannelBuilder b2 = mock(ManagedChannelBuilder.class, "b2");
    ChannelConfigurator delegate =
        b -> {
          assertThat(b).isSameInstanceAs(b1);
          return b2;
        };
    try (SdkMeterProvider meterProvider = SdkMeterProvider.builder().build()) {
      GrpcMetricsChannelConfigurator configurator =
          new GrpcMetricsChannelConfigurator(delegate, meterProvider);
      assertThat(configurator.apply(b1)).isSameInstanceAs(b2);
      assertThat(((Supplier<MeterProvider>) configurator).get()).isSameInstanceAs(meterProvider);
    }
  }

  @Test
  public void createDefaultClientMeterProvider_detectedProjectIdTakesPrecedence() {
    Attributes detectedWithProject =
        Attributes.builder().put("cloud.account.id", "detected-project").build();

    try (SdkMeterProvider provider =
        OpenTelemetryBootstrappingUtils.createDefaultClientMeterProvider(
            "https://storage.googleapis.com",
            "configured-project",
            "googleapis.com",
            Duration.ofSeconds(60),
            "json",
            detectedWithProject)) {
      assertThat(provider).isNotNull();
      assertThat(provider.toString()).contains("project_id=\"detected-project\"");
      assertThat(provider.toString()).contains("cloud.account.id=\"detected-project\"");
      assertThat(provider.toString()).contains("api=\"json\"");
    }
  }

  @Test
  public void createDefaultClientMeterProvider_fallsBackToConfiguredProjectId() {
    try (SdkMeterProvider fallbackProvider =
        OpenTelemetryBootstrappingUtils.createDefaultClientMeterProvider(
            "https://storage.googleapis.com",
            "configured-project",
            "googleapis.com",
            Duration.ofSeconds(60),
            "grpc",
            Attributes.empty())) {
      assertThat(fallbackProvider).isNotNull();
      assertThat(fallbackProvider.toString()).contains("project_id=\"configured-project\"");
      assertThat(fallbackProvider.toString()).contains("api=\"grpc\"");
    }
  }

  @Test
  public void createDefaultClientMeterProvider_returnsNullWhenProjectIdCannotBeDetermined() {
    SdkMeterProvider nullProvider =
        OpenTelemetryBootstrappingUtils.createDefaultClientMeterProvider(
            "https://storage.googleapis.com",
            null,
            "googleapis.com",
            Duration.ofSeconds(60),
            "json",
            Attributes.empty());
    assertThat(nullProvider).isNull();
  }

  @Test
  public void
      createChannelCreationLatencyRecorder_appliesExplicitBucketBoundariesAdviceWithoutCustomViews() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    try (SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build()) {
      BiConsumer<String, Duration> recorder =
          OpenTelemetryBootstrappingUtils.createChannelCreationLatencyRecorder(meterProvider);
      recorder.accept("DirectPathInterconnect", Duration.ofMillis(125));

      Collection<MetricData> metrics = metricReader.collectAllMetrics();
      assertThat(metrics).hasSize(1);
      MetricData metricData = metrics.iterator().next();
      assertThat(metricData.getName())
          .isEqualTo(OpenTelemetryBootstrappingUtils.CHANNEL_CREATION_LATENCY_INSTRUMENT);
      HistogramPointData point = metricData.getHistogramData().getPoints().iterator().next();
      assertThat(point.getBoundaries())
          .isEqualTo(OpenTelemetryBootstrappingUtils.latencyHistogramBoundaries());
      assertThat(point.getSum()).isWithin(1e-6).of(0.125);
    }
  }

  @Test
  public void createChannelCreationLatencyRecorder_nullMeterProvider_isNoop() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    try (SdkMeterProvider unusedProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build()) {
      BiConsumer<String, Duration> noopRecorder =
          OpenTelemetryBootstrappingUtils.createChannelCreationLatencyRecorder(null);
      noopRecorder.accept("CloudPath", Duration.ofMillis(10));
      assertThat(metricReader.collectAllMetrics()).isEmpty();
    }
  }

  private static int findBucketIndex(List<Double> boundaries, double value) {
    for (int i = 0; i < boundaries.size(); i++) {
      if (value <= boundaries.get(i)) {
        return i;
      }
    }
    return boundaries.size();
  }
}
