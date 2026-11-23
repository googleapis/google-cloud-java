/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.Credentials;
import com.google.auth.oauth2.ServiceAccountJwtAccessCredentials;
import com.google.cloud.bigtable.data.v2.internal.JwtCredentialsWithAudience;
import com.google.cloud.bigtable.data.v2.stub.BigtableClientContext.BuiltinOtelFactory;
import io.grpc.ManagedChannel;
import io.opencensus.stats.Stats;
import io.opencensus.tags.Tags;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BigtableClientContextTest {

  private static final URI MONITORING_URI =
      URI.create("https://monitoring.googleapis.com/google.monitoring.v3.MetricService");
  private static final URI BIGTABLE_DATA_URI =
      URI.create("https://bigtable.googleapis.com/google.bigtable.v2.Bigtable");

  private ScheduledExecutorService executor;
  private List<Credentials> capturedMetricsCredentials;
  private BuiltinOtelFactory capturingOtelFactory;

  @BeforeEach
  void setUp() {
    executor = Executors.newSingleThreadScheduledExecutor();
    capturedMetricsCredentials = new ArrayList<>();
    capturingOtelFactory =
        (metricRegistry, clientInfo, defaultCredentials, metricsEndpoint, universeDomain, exec) -> {
          capturedMetricsCredentials.add(defaultCredentials);
          return null;
        };
  }

  @AfterEach
  void tearDown() {
    executor.shutdownNow();
  }

  @Test
  void testServiceAccountJwtCredentialsNotPatchedForMetrics() throws Exception {
    ServiceAccountJwtAccessCredentials jwtCreds = createServiceAccountJwtCredentials();
    CredentialsProvider credentialsProvider =
        mock(CredentialsProvider.class, withSettings().withoutAnnotations());
    when(credentialsProvider.getCredentials()).thenReturn(jwtCreds);

    EnhancedBigtableStubSettings settings =
        baseSettingsBuilder().setCredentialsProvider(credentialsProvider).build();

    BigtableClientContext ctx =
        BigtableClientContext.create(
            settings, Tags.getTagger(), Stats.getStatsRecorder(), capturingOtelFactory);
    try {
      verify(credentialsProvider, times(1)).getCredentials();
      assertThat(capturedMetricsCredentials).hasSize(1);

      Credentials metricsCredentials = capturedMetricsCredentials.get(0);
      assertThat(metricsCredentials).isSameInstanceAs(jwtCreds);
      assertThat(metricsCredentials).isNotInstanceOf(JwtCredentialsWithAudience.class);
      Map<String, List<String>> metricsAuthHeaders =
          metricsCredentials.getRequestMetadata(MONITORING_URI);
      assertThat(extractJwtAudience(metricsAuthHeaders)).isEqualTo(MONITORING_URI.toString());

      Credentials dataCredentials = ctx.getClientContext().getCredentials();
      assertThat(dataCredentials).isInstanceOf(JwtCredentialsWithAudience.class);
      Map<String, List<String>> dataAuthHeaders =
          dataCredentials.getRequestMetadata(BIGTABLE_DATA_URI);
      assertThat(extractJwtAudience(dataAuthHeaders)).isEqualTo("https://bigtable.googleapis.com/");
    } finally {
      ctx.close();
    }
  }

  @Test
  void testCustomJwtAudienceAppliedOnlyToDataCredentials() throws Exception {
    ServiceAccountJwtAccessCredentials jwtCreds = createServiceAccountJwtCredentials();
    CredentialsProvider credentialsProvider =
        mock(CredentialsProvider.class, withSettings().withoutAnnotations());
    when(credentialsProvider.getCredentials()).thenReturn(jwtCreds);

    String customAudience = "https://test-bigtable.sandbox.googleapis.com/";
    EnhancedBigtableStubSettings settings =
        baseSettingsBuilder()
            .setCredentialsProvider(credentialsProvider)
            .setJwtAudience(customAudience)
            .build();

    BigtableClientContext ctx =
        BigtableClientContext.create(
            settings, Tags.getTagger(), Stats.getStatsRecorder(), capturingOtelFactory);
    try {
      verify(credentialsProvider, times(1)).getCredentials();
      assertThat(capturedMetricsCredentials).hasSize(1);

      Credentials metricsCredentials = capturedMetricsCredentials.get(0);
      assertThat(metricsCredentials).isSameInstanceAs(jwtCreds);
      assertThat(metricsCredentials).isNotInstanceOf(JwtCredentialsWithAudience.class);
      Map<String, List<String>> metricsAuthHeaders =
          metricsCredentials.getRequestMetadata(MONITORING_URI);
      assertThat(extractJwtAudience(metricsAuthHeaders)).isEqualTo(MONITORING_URI.toString());

      Credentials dataCredentials = ctx.getClientContext().getCredentials();
      assertThat(dataCredentials).isInstanceOf(JwtCredentialsWithAudience.class);
      Map<String, List<String>> dataAuthHeaders =
          dataCredentials.getRequestMetadata(BIGTABLE_DATA_URI);
      assertThat(extractJwtAudience(dataAuthHeaders)).isEqualTo(customAudience);
    } finally {
      ctx.close();
    }
  }

  @Test
  void testNonJwtCredentialsSharedWithoutWrapping() throws Exception {
    Credentials nonJwtCreds = mock(Credentials.class, withSettings().withoutAnnotations());
    when(nonJwtCreds.getMetricsCredentialType()).thenReturn(CredentialTypeForMetrics.DO_NOT_SEND);
    CredentialsProvider credentialsProvider =
        mock(CredentialsProvider.class, withSettings().withoutAnnotations());
    when(credentialsProvider.getCredentials()).thenReturn(nonJwtCreds);

    EnhancedBigtableStubSettings settings =
        baseSettingsBuilder().setCredentialsProvider(credentialsProvider).build();

    BigtableClientContext ctx =
        BigtableClientContext.create(
            settings, Tags.getTagger(), Stats.getStatsRecorder(), capturingOtelFactory);
    try {
      verify(credentialsProvider, times(1)).getCredentials();
      assertThat(capturedMetricsCredentials).hasSize(1);
      assertThat(capturedMetricsCredentials.get(0)).isSameInstanceAs(nonJwtCreds);
      assertThat(ctx.getClientContext().getCredentials()).isSameInstanceAs(nonJwtCreds);
    } finally {
      ctx.close();
    }
  }

  @Test
  void testNullCredentials() throws Exception {
    EnhancedBigtableStubSettings settings =
        baseSettingsBuilder().setCredentialsProvider(NoCredentialsProvider.create()).build();

    BigtableClientContext ctx =
        BigtableClientContext.create(
            settings, Tags.getTagger(), Stats.getStatsRecorder(), capturingOtelFactory);
    try {
      assertThat(capturedMetricsCredentials).containsExactly((Credentials) null);
      assertThat(ctx.getClientContext().getCredentials()).isNull();
    } finally {
      ctx.close();
    }
  }

  @Test
  void testInvalidJwtAudienceThrows() {
    EnhancedBigtableStubSettings settings =
        baseSettingsBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setJwtAudience("not a valid uri")
            .build();

    IllegalStateException ex =
        assertThrows(
            IllegalStateException.class,
            () ->
                BigtableClientContext.create(
                    settings, Tags.getTagger(), Stats.getStatsRecorder(), capturingOtelFactory));
    assertThat(ex).hasMessageThat().contains("invalid JWT audience");
    assertThat(ex).hasCauseThat().isInstanceOf(URISyntaxException.class);
    assertThat(capturedMetricsCredentials).isEmpty();
  }

  @SuppressWarnings("deprecation")
  private EnhancedBigtableStubSettings.Builder baseSettingsBuilder() {
    ManagedChannel managedChannel = mock(ManagedChannel.class, withSettings().withoutAnnotations());
    return EnhancedBigtableStubSettings.newBuilder()
        .setProjectId("fake-project")
        .setInstanceId("fake-instance")
        .setAppProfileId("fake-app-profile")
        .setTransportChannelProvider(
            FixedTransportChannelProvider.create(GrpcTransportChannel.create(managedChannel)))
        .setBackgroundExecutorProvider(FixedExecutorProvider.create(executor))
        .setRefreshingChannel(false)
        .setSessionsEnabled(false);
  }

  private static ServiceAccountJwtAccessCredentials createServiceAccountJwtCredentials()
      throws NoSuchAlgorithmException {
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
    KeyPair keyPair = keyGen.genKeyPair();
    return ServiceAccountJwtAccessCredentials.newBuilder()
        .setClientId("fake-client-id")
        .setClientEmail("fake@example.com")
        .setPrivateKey(keyPair.getPrivate())
        .setPrivateKeyId("fake-private-key-id")
        .build();
  }

  private static Object extractJwtAudience(Map<String, List<String>> requestMetadata)
      throws IOException {
    List<String> authHeaders = requestMetadata.get("Authorization");
    assertThat(authHeaders).isNotNull();
    assertThat(authHeaders).hasSize(1);
    String authValue = authHeaders.get(0);
    String bearerPrefix = "Bearer ";
    assertThat(authValue).startsWith(bearerPrefix);
    String jwt = authValue.substring(bearerPrefix.length());
    JsonWebSignature parsed = JsonWebSignature.parse(GsonFactory.getDefaultInstance(), jwt);
    return parsed.getPayload().getAudience();
  }
}
