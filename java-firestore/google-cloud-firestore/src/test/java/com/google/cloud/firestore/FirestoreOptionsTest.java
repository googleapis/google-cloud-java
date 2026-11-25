/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.firestore;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.cloud.firestore.v1.FirestoreSettings;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import org.junit.Assume;
import org.junit.Test;

public class FirestoreOptionsTest {

  private static final String PROJECT_ID = "test-project";
  private static final String CUSTOM_HOST_A = "custom-firestore.example.com:443";
  private static final String CUSTOM_HOST_B = "other-firestore.example.com:8443";
  private static final String CUSTOM_UNIVERSE = "s3nsapis.fr";

  private static void assumeNoEmulatorHostEnv() {
    Assume.assumeTrue(
        "FIRESTORE_EMULATOR_HOST must be unset", System.getenv("FIRESTORE_EMULATOR_HOST") == null);
  }

  @Test
  public void instantiateWithProjectId() {
    FirestoreOptions firestoreOptions =
        FirestoreOptions.newBuilder().setProjectId(PROJECT_ID).build();
    FirestoreImpl firestore = new FirestoreImpl(firestoreOptions, mock(FirestoreRpc.class));

    DocumentReference document = firestore.document("coll/doc1");
    assertThat(document.getName())
        .isEqualTo("projects/test-project/databases/(default)/documents/coll/doc1");
  }

  @Test
  public void instantiateWithProjectIdAndDatabaseId() {
    FirestoreOptions firestoreOptions =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setDatabaseId("test-database")
            .build();
    FirestoreImpl firestore = new FirestoreImpl(firestoreOptions, mock(FirestoreRpc.class));

    DocumentReference document = firestore.document("coll/doc1");
    assertThat(document.getName())
        .isEqualTo("projects/test-project/databases/test-database/documents/coll/doc1");
  }

  @Test
  public void defaultChannelProviderDefersEndpointToGax() {
    assumeNoEmulatorHostEnv();
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .setOpenTelemetryOptions(
                FirestoreOpenTelemetryOptions.newBuilder()
                    .setOpenTelemetry(OpenTelemetry.noop())
                    .build())
            .build();

    assertThat(options.getTransportChannelProvider())
        .isInstanceOf(InstantiatingGrpcChannelProvider.class);
    InstantiatingGrpcChannelProvider channelProvider =
        (InstantiatingGrpcChannelProvider) options.getTransportChannelProvider();
    assertThat(channelProvider.needsEndpoint()).isTrue();
    assertThat(channelProvider.getEndpoint()).isNull();
    assertThat(channelProvider.toBuilder().getChannelConfigurator()).isNull();
  }

  @Test
  public void defaultChannelProviderDefersEndpointWithTracingEnabled() {
    assumeNoEmulatorHostEnv();
    SdkTracerProvider tracerProvider = SdkTracerProvider.builder().build();
    try {
      OpenTelemetrySdk openTelemetry =
          OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
      FirestoreOptions options =
          FirestoreOptions.newBuilder()
              .setProjectId(PROJECT_ID)
              .setCredentials(NoCredentials.getInstance())
              .setOpenTelemetryOptions(
                  FirestoreOpenTelemetryOptions.newBuilder()
                      .setOpenTelemetry(openTelemetry)
                      .build())
              .build();

      InstantiatingGrpcChannelProvider channelProvider =
          (InstantiatingGrpcChannelProvider) options.getTransportChannelProvider();
      assertThat(channelProvider.needsEndpoint()).isTrue();
      assertThat(channelProvider.getEndpoint()).isNull();
      assertThat(channelProvider.toBuilder().getChannelConfigurator()).isNotNull();
    } finally {
      tracerProvider.close();
    }
  }

  @Test
  public void customHostPinsEndpointOnChannelProvider() {
    assumeNoEmulatorHostEnv();
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .setHost(CUSTOM_HOST_A)
            .build();

    InstantiatingGrpcChannelProvider channelProvider =
        (InstantiatingGrpcChannelProvider) options.getTransportChannelProvider();
    assertThat(channelProvider.needsEndpoint()).isFalse();
    assertThat(channelProvider.getEndpoint()).isEqualTo(CUSTOM_HOST_A);
  }

  @Test
  public void customHostWithTracingEnabledPreservesChannelConfigurator() {
    assumeNoEmulatorHostEnv();
    SdkTracerProvider tracerProvider = SdkTracerProvider.builder().build();
    try {
      OpenTelemetrySdk openTelemetry =
          OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
      FirestoreOptions options =
          FirestoreOptions.newBuilder()
              .setProjectId(PROJECT_ID)
              .setCredentials(NoCredentials.getInstance())
              .setHost(CUSTOM_HOST_A)
              .setOpenTelemetryOptions(
                  FirestoreOpenTelemetryOptions.newBuilder()
                      .setOpenTelemetry(openTelemetry)
                      .build())
              .build();

      InstantiatingGrpcChannelProvider channelProvider =
          (InstantiatingGrpcChannelProvider) options.getTransportChannelProvider();
      assertThat(channelProvider.needsEndpoint()).isFalse();
      assertThat(channelProvider.getEndpoint()).isEqualTo(CUSTOM_HOST_A);
      assertThat(channelProvider.toBuilder().getChannelConfigurator()).isNotNull();
    } finally {
      tracerProvider.close();
    }
  }

  @Test
  public void explicitDefaultEndpointDefersEndpointToGax() {
    assumeNoEmulatorHostEnv();
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .setHost(FirestoreSettings.getDefaultEndpoint())
            .build();

    InstantiatingGrpcChannelProvider channelProvider =
        (InstantiatingGrpcChannelProvider) options.getTransportChannelProvider();
    assertThat(channelProvider.needsEndpoint()).isTrue();
    assertThat(channelProvider.getEndpoint()).isNull();
  }

  @Test
  public void explicitChannelProviderIsPreserved() {
    assumeNoEmulatorHostEnv();
    InstantiatingGrpcChannelProvider explicitProvider =
        FirestoreSettings.defaultGrpcTransportProviderBuilder().setEndpoint(CUSTOM_HOST_A).build();
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .setChannelProvider(explicitProvider)
            .build();

    assertThat(options.getTransportChannelProvider()).isSameInstanceAs(explicitProvider);
    assertThat(options.getTransportChannelProvider().getEndpoint()).isEqualTo(CUSTOM_HOST_A);
  }

  @Test
  public void toBuilderRoundTripPreservesEqualityAndHashCode() {
    assumeNoEmulatorHostEnv();
    FirestoreOptions original =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .build();
    FirestoreOptions copy = original.toBuilder().build();

    assertThat(copy).isEqualTo(original);
    assertThat(original).isEqualTo(copy);
    assertThat(copy.hashCode()).isEqualTo(original.hashCode());
    assertThat(copy.getTransportChannelProvider())
        .isSameInstanceAs(original.getTransportChannelProvider());
  }

  @Test
  public void equalsAndHashCodeIncludeUniverseDomain() {
    assumeNoEmulatorHostEnv();
    FirestoreOptions defaultOptions =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .build();
    FirestoreOptions customUniverseOptions =
        defaultOptions.toBuilder().setUniverseDomain(CUSTOM_UNIVERSE).build();
    FirestoreOptions sameUniverseCopy = customUniverseOptions.toBuilder().build();
    FirestoreOptions otherUniverseOptions =
        defaultOptions.toBuilder().setUniverseDomain("other.example.com").build();

    assertThat(defaultOptions).isNotEqualTo(customUniverseOptions);
    assertThat(customUniverseOptions).isNotEqualTo(defaultOptions);
    assertThat(defaultOptions.hashCode()).isNotEqualTo(customUniverseOptions.hashCode());
    assertThat(customUniverseOptions).isNotEqualTo(otherUniverseOptions);
    assertThat(customUniverseOptions).isEqualTo(sameUniverseCopy);
    assertThat(customUniverseOptions.hashCode()).isEqualTo(sameUniverseCopy.hashCode());
  }

  @Test
  public void toBuilderSetHostFromDefaultPinsCustomEndpoint() {
    assumeNoEmulatorHostEnv();
    FirestoreOptions defaultOptions =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .build();
    FirestoreOptions customOptions = defaultOptions.toBuilder().setHost(CUSTOM_HOST_A).build();

    InstantiatingGrpcChannelProvider channelProvider =
        (InstantiatingGrpcChannelProvider) customOptions.getTransportChannelProvider();
    assertThat(channelProvider.needsEndpoint()).isFalse();
    assertThat(channelProvider.getEndpoint()).isEqualTo(CUSTOM_HOST_A);
    assertThat(customOptions.getHost()).isEqualTo(CUSTOM_HOST_A);
  }

  @Test
  public void toBuilderSetHostUpdatesCustomEndpoint() {
    assumeNoEmulatorHostEnv();
    FirestoreOptions optionsA =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .setHost(CUSTOM_HOST_A)
            .build();
    FirestoreOptions optionsB = optionsA.toBuilder().setHost(CUSTOM_HOST_B).build();

    InstantiatingGrpcChannelProvider channelProviderB =
        (InstantiatingGrpcChannelProvider) optionsB.getTransportChannelProvider();
    assertThat(channelProviderB.needsEndpoint()).isFalse();
    assertThat(channelProviderB.getEndpoint()).isEqualTo(CUSTOM_HOST_B);
    assertThat(optionsB.getHost()).isEqualTo(CUSTOM_HOST_B);
  }

  @Test
  public void toBuilderSetHostToDefaultEndpointClearsPinnedEndpoint() {
    assumeNoEmulatorHostEnv();
    FirestoreOptions customOptions =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .setHost(CUSTOM_HOST_A)
            .build();
    FirestoreOptions resetOptions =
        customOptions.toBuilder().setHost(FirestoreSettings.getDefaultEndpoint()).build();

    InstantiatingGrpcChannelProvider channelProvider =
        (InstantiatingGrpcChannelProvider) resetOptions.getTransportChannelProvider();
    assertThat(channelProvider.needsEndpoint()).isTrue();
    assertThat(channelProvider.getEndpoint()).isNull();

    FirestoreOptions nullHostOptions = customOptions.toBuilder().setHost(null).build();
    InstantiatingGrpcChannelProvider nullHostProvider =
        (InstantiatingGrpcChannelProvider) nullHostOptions.getTransportChannelProvider();
    assertThat(nullHostOptions.getHost()).isEqualTo(FirestoreSettings.getDefaultEndpoint());
    assertThat(nullHostProvider.needsEndpoint()).isTrue();
    assertThat(nullHostProvider.getEndpoint()).isNull();
  }

  @Test
  public void toBuilderSetHostPreservesExplicitChannelProvider() {
    assumeNoEmulatorHostEnv();
    InstantiatingGrpcChannelProvider explicitProvider =
        FirestoreSettings.defaultGrpcTransportProviderBuilder().setEndpoint(CUSTOM_HOST_A).build();
    FirestoreOptions baseOptions =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .setChannelProvider(explicitProvider)
            .build();

    FirestoreOptions updated = baseOptions.toBuilder().setHost(CUSTOM_HOST_B).build();
    assertThat(updated.getTransportChannelProvider()).isSameInstanceAs(explicitProvider);
    assertThat(updated.getTransportChannelProvider().getEndpoint()).isEqualTo(CUSTOM_HOST_A);

    FirestoreOptions setHostAfterProvider =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .setChannelProvider(explicitProvider)
            .setHost(CUSTOM_HOST_B)
            .build();
    assertThat(setHostAfterProvider.getTransportChannelProvider())
        .isSameInstanceAs(explicitProvider);
  }

  @Test
  public void toBuilderSetCredentialsProviderPreservesUniverseDomainAndDeferredEndpoint() {
    assumeNoEmulatorHostEnv();
    FirestoreOptions baseOptions =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .setUniverseDomain(CUSTOM_UNIVERSE)
            .build();
    CredentialsProvider credentialsProvider =
        FixedCredentialsProvider.create(NoCredentials.getInstance());

    FirestoreOptions adminOptions =
        baseOptions.toBuilder().setCredentialsProvider(credentialsProvider).build();

    assertThat(adminOptions.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE);
    assertThat(adminOptions.getCredentialsProvider()).isSameInstanceAs(credentialsProvider);
    InstantiatingGrpcChannelProvider channelProvider =
        (InstantiatingGrpcChannelProvider) adminOptions.getTransportChannelProvider();
    assertThat(channelProvider.needsEndpoint()).isTrue();
    assertThat(channelProvider.getEndpoint()).isNull();
  }

  @Test
  public void toBuilderSetOpenTelemetryOptionsRebuildsAutoChannelProvider() {
    assumeNoEmulatorHostEnv();
    SdkTracerProvider tracerProvider = SdkTracerProvider.builder().build();
    try {
      FirestoreOptions noopOptions =
          FirestoreOptions.newBuilder()
              .setProjectId(PROJECT_ID)
              .setCredentials(NoCredentials.getInstance())
              .setOpenTelemetryOptions(
                  FirestoreOpenTelemetryOptions.newBuilder()
                      .setOpenTelemetry(OpenTelemetry.noop())
                      .build())
              .build();
      InstantiatingGrpcChannelProvider noopProvider =
          (InstantiatingGrpcChannelProvider) noopOptions.getTransportChannelProvider();
      assertThat(noopProvider.toBuilder().getChannelConfigurator()).isNull();

      OpenTelemetrySdk enabledOtel =
          OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
      FirestoreOptions enabledOptions =
          noopOptions.toBuilder()
              .setOpenTelemetryOptions(
                  FirestoreOpenTelemetryOptions.newBuilder().setOpenTelemetry(enabledOtel).build())
              .build();
      InstantiatingGrpcChannelProvider enabledProvider =
          (InstantiatingGrpcChannelProvider) enabledOptions.getTransportChannelProvider();
      assertThat(enabledProvider.needsEndpoint()).isTrue();
      assertThat(enabledProvider.getEndpoint()).isNull();
      assertThat(enabledProvider.toBuilder().getChannelConfigurator()).isNotNull();

      // Explicit custom channel provider must NOT be replaced by setOpenTelemetryOptions().
      InstantiatingGrpcChannelProvider explicitProvider =
          FirestoreSettings.defaultGrpcTransportProviderBuilder()
              .setEndpoint(CUSTOM_HOST_A)
              .build();
      FirestoreOptions explicitOptions =
          FirestoreOptions.newBuilder()
              .setProjectId(PROJECT_ID)
              .setCredentials(NoCredentials.getInstance())
              .setChannelProvider(explicitProvider)
              .build();
      FirestoreOptions explicitUpdated =
          explicitOptions.toBuilder()
              .setOpenTelemetryOptions(
                  FirestoreOpenTelemetryOptions.newBuilder().setOpenTelemetry(enabledOtel).build())
              .build();
      assertThat(explicitUpdated.getTransportChannelProvider()).isSameInstanceAs(explicitProvider);
    } finally {
      tracerProvider.close();
    }
  }

  @Test
  public void toBuilderSetHostPreservesTracingChannelConfigurator() {
    assumeNoEmulatorHostEnv();
    SdkTracerProvider tracerProvider = SdkTracerProvider.builder().build();
    try {
      OpenTelemetrySdk enabledOtel =
          OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
      FirestoreOptions baseOptions =
          FirestoreOptions.newBuilder()
              .setProjectId(PROJECT_ID)
              .setCredentials(NoCredentials.getInstance())
              .setOpenTelemetryOptions(
                  FirestoreOpenTelemetryOptions.newBuilder().setOpenTelemetry(enabledOtel).build())
              .build();

      FirestoreOptions customHostOptions = baseOptions.toBuilder().setHost(CUSTOM_HOST_A).build();
      InstantiatingGrpcChannelProvider channelProvider =
          (InstantiatingGrpcChannelProvider) customHostOptions.getTransportChannelProvider();
      assertThat(channelProvider.needsEndpoint()).isFalse();
      assertThat(channelProvider.getEndpoint()).isEqualTo(CUSTOM_HOST_A);
      assertThat(channelProvider.toBuilder().getChannelConfigurator()).isNotNull();
    } finally {
      tracerProvider.close();
    }
  }

  @Test
  public void emulatorOptionsToBuilderSetHostPreservesEmulatorChannelProvider() {
    String emulatorHost = "localhost:8080";
    FirestoreOptions emulatorOptions =
        FirestoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .setEmulatorHost(emulatorHost)
            .build();
    FirestoreOptions updated = emulatorOptions.toBuilder().setHost(CUSTOM_HOST_A).build();

    assertThat(updated.getEmulatorHost()).isEqualTo(emulatorHost);
    assertThat(updated.getTransportChannelProvider().needsEndpoint()).isFalse();
    assertThat(updated.getTransportChannelProvider().getEndpoint()).isEqualTo(emulatorHost);
  }
}
