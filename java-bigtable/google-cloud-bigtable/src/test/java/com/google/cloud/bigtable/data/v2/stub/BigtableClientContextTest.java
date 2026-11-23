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
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BigtableClientContextTest {

  private static final URI MONITORING_URI =
      URI.create("https://monitoring.googleapis.com/google.monitoring.v3.MetricService");

  private ScheduledExecutorService executor;

  @BeforeEach
  void setUp() {
    executor = Executors.newSingleThreadScheduledExecutor();
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

    AtomicBoolean builtinOtelCalled = new AtomicBoolean(false);
    AtomicReference<Credentials> metricsCredentialsRef = new AtomicReference<>();
    BuiltinOtelFactory capturingFactory =
        (metricRegistry, clientInfo, defaultCredentials, metricsEndpoint, universeDomain, exec) -> {
          builtinOtelCalled.set(true);
          metricsCredentialsRef.set(defaultCredentials);
          return null;
        };

    BigtableClientContext ctx =
        BigtableClientContext.create(
            settings, Tags.getTagger(), Stats.getStatsRecorder(), capturingFactory);
    try {
      verify(credentialsProvider, times(1)).getCredentials();
      assertThat(builtinOtelCalled.get()).isTrue();

      Credentials metricsCredentials = metricsCredentialsRef.get();
      assertThat(metricsCredentials).isSameInstanceAs(jwtCreds);
      assertThat(metricsCredentials).isNotInstanceOf(JwtCredentialsWithAudience.class);
      assertThat(extractJwtAudience(metricsCredentials, MONITORING_URI))
          .isEqualTo(MONITORING_URI.toString());

      Credentials dataCredentials = ctx.getClientContext().getCredentials();
      assertThat(dataCredentials).isInstanceOf(JwtCredentialsWithAudience.class);
      assertThat(extractJwtAudience(dataCredentials, MONITORING_URI))
          .isEqualTo("https://bigtable.googleapis.com/");
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

    AtomicBoolean builtinOtelCalled = new AtomicBoolean(false);
    AtomicReference<Credentials> metricsCredentialsRef = new AtomicReference<>();
    BuiltinOtelFactory capturingFactory =
        (metricRegistry, clientInfo, defaultCredentials, metricsEndpoint, universeDomain, exec) -> {
          builtinOtelCalled.set(true);
          metricsCredentialsRef.set(defaultCredentials);
          return null;
        };

    BigtableClientContext ctx =
        BigtableClientContext.create(
            settings, Tags.getTagger(), Stats.getStatsRecorder(), capturingFactory);
    try {
      verify(credentialsProvider, times(1)).getCredentials();
      assertThat(builtinOtelCalled.get()).isTrue();

      Credentials metricsCredentials = metricsCredentialsRef.get();
      assertThat(metricsCredentials).isSameInstanceAs(jwtCreds);
      assertThat(metricsCredentials).isNotInstanceOf(JwtCredentialsWithAudience.class);
      assertThat(extractJwtAudience(metricsCredentials, MONITORING_URI))
          .isEqualTo(MONITORING_URI.toString());

      Credentials dataCredentials = ctx.getClientContext().getCredentials();
      assertThat(dataCredentials).isInstanceOf(JwtCredentialsWithAudience.class);
      assertThat(extractJwtAudience(dataCredentials, MONITORING_URI)).isEqualTo(customAudience);
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

    AtomicBoolean builtinOtelCalled = new AtomicBoolean(false);
    AtomicReference<Credentials> metricsCredentialsRef = new AtomicReference<>();
    BuiltinOtelFactory capturingFactory =
        (metricRegistry, clientInfo, defaultCredentials, metricsEndpoint, universeDomain, exec) -> {
          builtinOtelCalled.set(true);
          metricsCredentialsRef.set(defaultCredentials);
          return null;
        };

    BigtableClientContext ctx =
        BigtableClientContext.create(
            settings, Tags.getTagger(), Stats.getStatsRecorder(), capturingFactory);
    try {
      verify(credentialsProvider, times(1)).getCredentials();
      assertThat(builtinOtelCalled.get()).isTrue();
      assertThat(metricsCredentialsRef.get()).isSameInstanceAs(nonJwtCreds);
      assertThat(ctx.getClientContext().getCredentials()).isSameInstanceAs(nonJwtCreds);
    } finally {
      ctx.close();
    }
  }

  @Test
  void testNullCredentials() throws Exception {
    EnhancedBigtableStubSettings settings =
        baseSettingsBuilder().setCredentialsProvider(NoCredentialsProvider.create()).build();

    AtomicBoolean builtinOtelCalled = new AtomicBoolean(false);
    AtomicReference<Credentials> metricsCredentialsRef =
        new AtomicReference<>(mock(Credentials.class, withSettings().withoutAnnotations()));
    BuiltinOtelFactory capturingFactory =
        (metricRegistry, clientInfo, defaultCredentials, metricsEndpoint, universeDomain, exec) -> {
          builtinOtelCalled.set(true);
          metricsCredentialsRef.set(defaultCredentials);
          return null;
        };

    BigtableClientContext ctx =
        BigtableClientContext.create(
            settings, Tags.getTagger(), Stats.getStatsRecorder(), capturingFactory);
    try {
      assertThat(builtinOtelCalled.get()).isTrue();
      assertThat(metricsCredentialsRef.get()).isNull();
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

    AtomicBoolean builtinOtelCalled = new AtomicBoolean(false);
    BuiltinOtelFactory capturingFactory =
        (metricRegistry, clientInfo, defaultCredentials, metricsEndpoint, universeDomain, exec) -> {
          builtinOtelCalled.set(true);
          return null;
        };

    IllegalStateException ex =
        assertThrows(
            IllegalStateException.class,
            () ->
                BigtableClientContext.create(
                    settings, Tags.getTagger(), Stats.getStatsRecorder(), capturingFactory));
    assertThat(ex).hasMessageThat().contains("invalid JWT audience");
    assertThat(ex).hasCauseThat().isInstanceOf(URISyntaxException.class);
    assertThat(builtinOtelCalled.get()).isFalse();
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

  private static Object extractJwtAudience(Credentials credentials, URI targetUri)
      throws IOException {
    Map<String, List<String>> metadata = credentials.getRequestMetadata(targetUri);
    List<String> authHeaders = metadata.get("Authorization");
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
