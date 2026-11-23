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
import static org.junit.Assert.assertThrows;
import static org.junit.Assume.assumeFalse;
import static org.mockito.Mockito.mock;

import com.google.api.gax.rpc.EndpointContext;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.monitoring.v3.MetricServiceSettings;
import com.google.cloud.storage.OpenTelemetryBootstrappingUtils.ChannelConfigurator;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.junit.Test;

public final class OpenTelemetryBootstrappingUtilsTest {

  private static final Function<String, String> EMPTY_ENV = key -> null;

  private static Credentials testCredentials() {
    return GoogleCredentials.create(new AccessToken("test-token", null));
  }

  private static MetricServiceSettings defaultTestMetricSettings() throws IOException {
    return OpenTelemetryBootstrappingUtils.buildMetricServiceSettings(
        "monitoring.googleapis.com:443", "googleapis.com", testCredentials());
  }

  @Test
  public void noErrorIfNotRunningOnGcp() {
    assumeFalse("Skipping because running on GCP", TestUtils.isOnComputeEngine());

    ChannelConfigurator cc = ChannelConfigurator.identity();

    String endpoint = "storage.googleapis.com:443";
    String projectId = null;
    String universeDomain = null;
    ChannelConfigurator actual =
        OpenTelemetryBootstrappingUtils.enableGrpcMetrics(
            cc, endpoint, projectId, universeDomain, testCredentials(), true, EMPTY_ENV);

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
  public void createClientMeterProvider_attachesApiAttribute() throws IOException {
    Attributes detectedAttributes = Attributes.empty();
    MetricServiceSettings metricSettings = defaultTestMetricSettings();

    try (SdkMeterProvider grpcProvider =
        OpenTelemetryBootstrappingUtils.createClientMeterProvider(
            metricSettings,
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
            metricSettings,
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
                metricSettings,
                "test-project",
                detectedAttributes,
                Duration.ofSeconds(60),
                true,
                null));

    try (SdkMeterProvider legacyProvider =
        OpenTelemetryBootstrappingUtils.createMeterProvider(
            metricSettings, "test-project", detectedAttributes, true)) {
      assertThat(legacyProvider.toString()).contains("api=\"grpc\"");
      assertThat(legacyProvider.toString())
          .contains("gcp.resource_type=\"storage.googleapis.com/Client\"");
    }
  }

  @Test
  public void createClientMeterProvider_customInstanceId_attachesInstanceIdAttribute()
      throws IOException {
    Attributes detectedAttributes = Attributes.empty();
    String customInstanceId = "custom-instance-12345";

    try (SdkMeterProvider provider =
        OpenTelemetryBootstrappingUtils.createClientMeterProvider(
            defaultTestMetricSettings(),
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
  public void createClientMeterProvider_preservesDetectedAttributes() throws IOException {
    Attributes detectedAttributes =
        Attributes.builder()
            .put("cloud.platform", "gcp_kubernetes_engine")
            .put("cloud.availability_zone", "us-central1-a")
            .put("host.id", "test-host-123")
            .build();

    try (SdkMeterProvider provider =
        OpenTelemetryBootstrappingUtils.createClientMeterProvider(
            defaultTestMetricSettings(),
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
                "storage.my-universe.com:8443", "my-universe.com"))
        .isEqualTo("monitoring.my-universe.com:8443");
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
            testCredentials(),
            Duration.ofSeconds(60),
            "json",
            detectedWithProject,
            EMPTY_ENV)) {
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
            testCredentials(),
            Duration.ofSeconds(60),
            "grpc",
            Attributes.empty(),
            EMPTY_ENV)) {
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
            testCredentials(),
            Duration.ofSeconds(60),
            "json",
            Attributes.empty(),
            EMPTY_ENV);
    assertThat(nullProvider).isNull();
  }

  @Test
  public void resolveUniverseDomain_precedenceAndValidation() {
    Map<String, String> customEnv =
        Collections.singletonMap(EndpointContext.GOOGLE_CLOUD_UNIVERSE_DOMAIN, "env.example.com");

    assertThat(
            OpenTelemetryBootstrappingUtils.resolveUniverseDomain(
                "explicit.example.com", customEnv::get))
        .isEqualTo("explicit.example.com");
    assertThat(OpenTelemetryBootstrappingUtils.resolveUniverseDomain(null, customEnv::get))
        .isEqualTo("env.example.com");
    assertThat(OpenTelemetryBootstrappingUtils.resolveUniverseDomain(null, EMPTY_ENV))
        .isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
    assertThat(
            OpenTelemetryBootstrappingUtils.resolveUniverseDomain(
                null,
                Collections.singletonMap(EndpointContext.GOOGLE_CLOUD_UNIVERSE_DOMAIN, "   ")::get))
        .isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
    assertThrows(
        IllegalArgumentException.class,
        () -> OpenTelemetryBootstrappingUtils.resolveUniverseDomain("", EMPTY_ENV));
    assertThrows(
        IllegalArgumentException.class,
        () -> OpenTelemetryBootstrappingUtils.resolveUniverseDomain("   ", EMPTY_ENV));
  }

  @Test
  public void getCloudMonitoringEndpoint_resolvesUniverseDomainAndEnvVar() {
    Map<String, String> customEnv =
        Collections.singletonMap(EndpointContext.GOOGLE_CLOUD_UNIVERSE_DOMAIN, "example.com");

    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "storage.googleapis.com:443", null, customEnv::get))
        .isEqualTo("monitoring.example.com:443");
    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "storage.googleapis.com:443", "override.example.com", customEnv::get))
        .isEqualTo("monitoring.override.example.com:443");
    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "storage.eu-west1.rep.example.com:443", "example.com", EMPTY_ENV))
        .isEqualTo("monitoring.example.com:443");
    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "storage-psc.p.example.com:443", "example.com", EMPTY_ENV))
        .isEqualTo("monitoring.example.com:443");
    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "google-c2p:///storage.example.com", "example.com", EMPTY_ENV))
        .isEqualTo("monitoring.example.com:443");
    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "private.example.com:443", "example.com", EMPTY_ENV))
        .isEqualTo("private.example.com:443");
    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "restricted.example.com:443", null, customEnv::get))
        .isEqualTo("restricted.example.com:443");
    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "private.googleapis.com:443", null, customEnv::get))
        .isEqualTo("monitoring.example.com:443");
    assertThat(
            OpenTelemetryBootstrappingUtils.getCloudMonitoringEndpoint(
                "not-private.googleapis.com:443", null, EMPTY_ENV))
        .isEqualTo("monitoring.googleapis.com:443");
  }

  @Test
  public void buildMetricServiceSettings_propagatesCredentialsUniverseDomainAndEndpoint()
      throws IOException {
    Credentials credentials = testCredentials();

    MetricServiceSettings defaultSettings =
        OpenTelemetryBootstrappingUtils.buildMetricServiceSettings(
            "monitoring.googleapis.com:443", "googleapis.com", credentials);
    assertThat(defaultSettings.getUniverseDomain()).isEqualTo("googleapis.com");
    assertThat(defaultSettings.getEndpoint()).isEqualTo("monitoring.googleapis.com:443");
    assertThat(defaultSettings.getCredentialsProvider().getCredentials())
        .isSameInstanceAs(credentials);

    MetricServiceSettings customUniverseSettings =
        OpenTelemetryBootstrappingUtils.buildMetricServiceSettings(
            "monitoring.example.com:443", "example.com", credentials);
    assertThat(customUniverseSettings.getUniverseDomain()).isEqualTo("example.com");
    assertThat(customUniverseSettings.getEndpoint()).isEqualTo("monitoring.example.com:443");
    assertThat(customUniverseSettings.getCredentialsProvider().getCredentials())
        .isSameInstanceAs(credentials);

    MetricServiceSettings privateSettings =
        OpenTelemetryBootstrappingUtils.buildMetricServiceSettings(
            "private.example.com:443", "example.com", credentials);
    assertThat(privateSettings.getUniverseDomain()).isEqualTo("example.com");
    assertThat(privateSettings.getEndpoint()).isEqualTo("private.example.com:443");

    MetricServiceSettings customPortSettings =
        OpenTelemetryBootstrappingUtils.buildMetricServiceSettings(
            "monitoring.example.com:8443", "example.com", credentials);
    assertThat(customPortSettings.getUniverseDomain()).isEqualTo("example.com");
    assertThat(customPortSettings.getEndpoint()).isEqualTo("monitoring.example.com:8443");

    assertThrows(
        IllegalArgumentException.class,
        () ->
            OpenTelemetryBootstrappingUtils.buildMetricServiceSettings(
                "monitoring.googleapis.com:443", "googleapis.com", null));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            OpenTelemetryBootstrappingUtils.buildMetricServiceSettings(
                "monitoring.googleapis.com:443", "googleapis.com", NoCredentials.getInstance()));
  }

  @Test
  public void enableGrpcMetrics_skipsWhenUnauthenticated() {
    ChannelConfigurator cc = ChannelConfigurator.identity();

    assertThat(
            OpenTelemetryBootstrappingUtils.enableGrpcMetrics(
                cc,
                "storage.googleapis.com:443",
                "test-project",
                "googleapis.com",
                NoCredentials.getInstance(),
                true,
                EMPTY_ENV))
        .isSameInstanceAs(cc);
    assertThat(
            OpenTelemetryBootstrappingUtils.enableGrpcMetrics(
                cc,
                "storage.googleapis.com:443",
                "test-project",
                "googleapis.com",
                null,
                true,
                EMPTY_ENV))
        .isSameInstanceAs(cc);
  }

  @Test
  public void enableGrpcMetrics_skipsCustomHostWhenUniverseUnconfigured() {
    ChannelConfigurator cc = ChannelConfigurator.identity();

    assertThat(
            OpenTelemetryBootstrappingUtils.enableGrpcMetrics(
                cc,
                "storage.example.com:443",
                "test-project",
                null,
                testCredentials(),
                true,
                EMPTY_ENV))
        .isSameInstanceAs(cc);
    assertThat(
            OpenTelemetryBootstrappingUtils.enableGrpcMetrics(
                cc, "localhost:8080", "test-project", null, testCredentials(), true, EMPTY_ENV))
        .isSameInstanceAs(cc);
  }

  @Test
  public void createDefaultClientMeterProvider_skipsWhenUnauthenticated() {
    assertThat(
            OpenTelemetryBootstrappingUtils.createDefaultClientMeterProvider(
                "https://storage.googleapis.com",
                "test-project",
                "googleapis.com",
                NoCredentials.getInstance(),
                Duration.ofSeconds(60),
                "json",
                Attributes.empty(),
                EMPTY_ENV))
        .isNull();
    assertThat(
            OpenTelemetryBootstrappingUtils.createDefaultClientMeterProvider(
                "https://storage.googleapis.com",
                "test-project",
                "googleapis.com",
                null,
                Duration.ofSeconds(60),
                "json",
                Attributes.empty(),
                EMPTY_ENV))
        .isNull();
  }

  @Test
  public void createDefaultClientMeterProvider_skipsCustomHostWhenUniverseUnconfigured() {
    assertThat(
            OpenTelemetryBootstrappingUtils.createDefaultClientMeterProvider(
                "https://storage.example.com",
                "test-project",
                null,
                testCredentials(),
                Duration.ofSeconds(60),
                "json",
                Attributes.empty(),
                EMPTY_ENV))
        .isNull();
    assertThat(
            OpenTelemetryBootstrappingUtils.createDefaultClientMeterProvider(
                "http://localhost:8080",
                "test-project",
                null,
                testCredentials(),
                Duration.ofSeconds(60),
                "json",
                Attributes.empty(),
                EMPTY_ENV))
        .isNull();

    Map<String, String> customEnv =
        Collections.singletonMap(EndpointContext.GOOGLE_CLOUD_UNIVERSE_DOMAIN, "example.com");
    try (SdkMeterProvider provider =
        OpenTelemetryBootstrappingUtils.createDefaultClientMeterProvider(
            "https://storage.example.com",
            "test-project",
            null,
            testCredentials(),
            Duration.ofSeconds(60),
            "json",
            Attributes.empty(),
            customEnv::get)) {
      assertThat(provider).isNotNull();
    }
  }

  @Test
  public void storageClientMetrics_skipsDefaultExporterForNoCredentials() {
    StorageOptions noCredsOptions =
        StorageOptions.http()
            .setEnableOtelMetrics(true)
            .setCredentials(NoCredentials.getInstance())
            .setProjectId("test-project")
            .build();
    assertThat(noCredsOptions.getStorageClientMetrics()).isNull();

    SdkMeterProvider customMeterProvider = SdkMeterProvider.builder().build();
    StorageOptions customProviderOptions =
        StorageOptions.http()
            .setEnableOtelMetrics(true)
            .setCredentials(NoCredentials.getInstance())
            .setMeterProvider(customMeterProvider)
            .setProjectId("test-project")
            .build();
    assertThat(customProviderOptions.getStorageClientMetrics()).isNotNull();
  }
}
