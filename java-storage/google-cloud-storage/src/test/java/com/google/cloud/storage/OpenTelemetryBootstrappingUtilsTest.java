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

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.auth.ApiKeyCredentials;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GdchCredentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.monitoring.v3.MetricServiceSettings;
import com.google.cloud.storage.OpenTelemetryBootstrappingUtils.ChannelConfigurator;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import java.io.IOException;
import java.net.URI;
import java.security.PrivateKey;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Test;

public final class OpenTelemetryBootstrappingUtilsTest {

  private static final Credentials CREDENTIALS = credentials("googleapis.com");
  private static final Credentials MY_UNIVERSE_CREDENTIALS = credentials("my-universe.com");
  private static final MetricServiceSettings METRIC_SERVICE_SETTINGS =
      OpenTelemetryBootstrappingUtils.createMetricServiceSettings(
          "storage.googleapis.com:443", "googleapis.com", null, CREDENTIALS);

  @Test
  public void noErrorIfNotRunningOnGcp() {
    assumeFalse("Skipping because running on GCP", TestUtils.isOnComputeEngine());

    ChannelConfigurator cc = ChannelConfigurator.identity();

    String endpoint = "storage.googleapis.com:443";
    String projectId = null;
    String universeDomain = "googleapis.com";
    ChannelConfigurator actual =
        OpenTelemetryBootstrappingUtils.enableGrpcMetrics(
            cc, endpoint, projectId, universeDomain, CREDENTIALS, true);

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
            METRIC_SERVICE_SETTINGS,
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
            METRIC_SERVICE_SETTINGS,
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
                METRIC_SERVICE_SETTINGS,
                "test-project",
                detectedAttributes,
                Duration.ofSeconds(60),
                true,
                null));

    try (SdkMeterProvider legacyProvider =
        OpenTelemetryBootstrappingUtils.createMeterProvider(
            METRIC_SERVICE_SETTINGS, "test-project", detectedAttributes, true)) {
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
            METRIC_SERVICE_SETTINGS,
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
            METRIC_SERVICE_SETTINGS,
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
    assertThat(
            OpenTelemetryBootstrappingUtils.extractServerAddress(
                "https://storage.googleapis.com?query"))
        .isEqualTo("storage.googleapis.com");
    assertThat(
            OpenTelemetryBootstrappingUtils.extractServerAddress(
                "https://storage.googleapis.com#fragment"))
        .isEqualTo("storage.googleapis.com");
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
  public void metricServiceEndpoint_keepsPortOfStorageEndpoint() {
    assertThat(metricServiceEndpoint("storage.googleapis.com:443", "googleapis.com", null))
        .isEqualTo("monitoring.googleapis.com:443");
    assertThat(metricServiceEndpoint("[::1]:8080", "googleapis.com", null))
        .isEqualTo("monitoring.googleapis.com:8080");
    assertThat(metricServiceEndpoint("storage.my-universe.com:8443", "my-universe.com", null))
        .isEqualTo("monitoring.my-universe.com:8443");
  }

  @Test
  public void metricServiceEndpoint_configuredUniverseDomain_anyStorageHost() {
    for (String storageEndpoint :
        new String[] {
          "https://storage.my-universe.com",
          "storage.us-east1.rep.my-universe.com:443",
          "storage.internal.example.com:443",
          "storage.googleapis.com:443",
          "private.googleapis.com:443"
        }) {
      assertThat(metricServiceEndpoint(storageEndpoint, "my-universe.com", null))
          .isEqualTo("monitoring.my-universe.com:443");
      assertThat(metricServiceEndpoint(storageEndpoint, null, "my-universe.com"))
          .isEqualTo("monitoring.my-universe.com:443");
    }
  }

  @Test
  public void metricServiceEndpoint_privateGoogleAccess() {
    assertThat(metricServiceEndpoint("private.googleapis.com:443", null, null))
        .isEqualTo("private.googleapis.com:443");
    assertThat(metricServiceEndpoint("restricted.googleapis.com:443", null, null))
        .isEqualTo("restricted.googleapis.com:443");
    assertThat(metricServiceEndpoint("private.my-universe.com:443", "my-universe.com", null))
        .isEqualTo("private.my-universe.com:443");
    assertThat(metricServiceEndpoint("restricted.my-universe.com:443", null, "my-universe.com"))
        .isEqualTo("restricted.my-universe.com:443");
  }

  @Test
  public void metricServiceEndpoint_noUniverseDomain_googleapisStorageHost() {
    for (String storageEndpoint :
        new String[] {
          "storage.googleapis.com:443",
          "google-c2p:///storage.googleapis.com",
          "Storage.US-East1.rep.GoogleAPIs.com:443"
        }) {
      assertThat(metricServiceEndpoint(storageEndpoint, null, null))
          .isEqualTo("monitoring.googleapis.com:443");
      assertThat(metricServiceEndpoint(storageEndpoint, "", ""))
          .isEqualTo("monitoring.googleapis.com:443");
    }
  }

  @Test
  public void noMetrics_noUniverseDomain_otherStorageHost() {
    for (String storageEndpoint :
        new String[] {
          "storage.my-universe.com:443",
          "storage.googleapis.com.example.com:443",
          "storagegoogleapis.com:443",
          "localhost:9000",
          "[::1]:8080",
          "http://host:invalid",
          "   ",
          null
        }) {
      assertThat(metricServiceEndpoint(storageEndpoint, null, null)).isNull();
    }
  }

  @Test
  public void createMetricServiceSettings_universeDomainOnClientWinsOverEnvironment() {
    MetricServiceSettings settings =
        OpenTelemetryBootstrappingUtils.createMetricServiceSettings(
            "storage.googleapis.com:443",
            "client-universe.com",
            "env-universe.com",
            credentials("client-universe.com"));

    assertThat(settings.getUniverseDomain()).isEqualTo("client-universe.com");
    assertThat(settings.getEndpoint()).isEqualTo("monitoring.client-universe.com:443");
  }

  @Test
  public void createMetricServiceSettings_usesClientCredentialsAndUniverseDomain()
      throws IOException {
    MetricServiceSettings settings =
        OpenTelemetryBootstrappingUtils.createMetricServiceSettings(
            "storage.us-east1.rep.my-universe.com:443",
            null,
            "my-universe.com",
            MY_UNIVERSE_CREDENTIALS);

    assertThat(settings.getEndpoint()).isEqualTo("monitoring.my-universe.com:443");
    assertThat(settings.getUniverseDomain()).isEqualTo("my-universe.com");
    assertThat(settings.getCredentialsProvider().getCredentials())
        .isSameInstanceAs(MY_UNIVERSE_CREDENTIALS);
  }

  @Test
  public void noMetrics_credentialsOfAnotherUniverseDomain() {
    assertThat(
            OpenTelemetryBootstrappingUtils.createMetricServiceSettings(
                "storage.googleapis.com:443", null, null, MY_UNIVERSE_CREDENTIALS))
        .isNull();
    assertThat(
            OpenTelemetryBootstrappingUtils.createMetricServiceSettings(
                "storage.my-universe.com:443", "my-universe.com", null, CREDENTIALS))
        .isNull();
  }

  @Test
  public void noMetrics_universeDomainOfCredentialsUnavailable() {
    Credentials credentials =
        new GoogleCredentials() {
          @Override
          public String getUniverseDomain() throws IOException {
            throw new IOException("metadata server unavailable");
          }
        };

    assertThat(
            OpenTelemetryBootstrappingUtils.createMetricServiceSettings(
                "storage.googleapis.com:443", null, null, credentials))
        .isNull();
  }

  @Test
  public void noMetrics_credentialsNotUsableWithCloudMonitoring() {
    for (Credentials credentials :
        new Credentials[] {
          null,
          NoCredentials.getInstance(),
          ApiKeyCredentials.create("key"),
          gdchCredentials(),
          OAuth2Credentials.create(null),
          GoogleCredentials.create(null)
        }) {
      assertThat(
              OpenTelemetryBootstrappingUtils.createMetricServiceSettings(
                  "storage.googleapis.com:443", "googleapis.com", null, credentials))
          .isNull();

      ChannelConfigurator cc = b -> b;
      assertThat(
              OpenTelemetryBootstrappingUtils.enableGrpcMetrics(
                  cc, "storage.googleapis.com:443", "project", "googleapis.com", credentials, true))
          .isSameInstanceAs(cc);

      assertThat(
              OpenTelemetryBootstrappingUtils.createDefaultClientMeterProvider(
                  "https://storage.googleapis.com",
                  "project",
                  "googleapis.com",
                  credentials,
                  Duration.ofSeconds(60),
                  "json",
                  Attributes.empty()))
          .isNull();
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
            CREDENTIALS,
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
            CREDENTIALS,
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
            CREDENTIALS,
            Duration.ofSeconds(60),
            "json",
            Attributes.empty());
    assertThat(nullProvider).isNull();
  }

  private static String metricServiceEndpoint(
      String storageEndpoint, String universeDomain, String envUniverseDomain) {
    boolean myUniverse =
        "my-universe.com".equals(universeDomain) || "my-universe.com".equals(envUniverseDomain);
    MetricServiceSettings settings =
        OpenTelemetryBootstrappingUtils.createMetricServiceSettings(
            storageEndpoint,
            universeDomain,
            envUniverseDomain,
            myUniverse ? MY_UNIVERSE_CREDENTIALS : CREDENTIALS);
    return settings != null ? settings.getEndpoint() : null;
  }

  private static Credentials credentials(String universeDomain) {
    return GoogleCredentials.newBuilder()
        .setAccessToken(new AccessToken("token", null))
        .setUniverseDomain(universeDomain)
        .build();
  }

  private static GdchCredentials gdchCredentials() {
    return GdchCredentials.newBuilder()
        .setProjectId("project")
        .setPrivateKeyId("key-id")
        .setPrivateKey(mock(PrivateKey.class))
        .setServiceIdentityName("service-identity")
        .setTokenServerUri(URI.create("https://localhost/token"))
        .setHttpTransportFactory(NetHttpTransport::new)
        .build();
  }
}
