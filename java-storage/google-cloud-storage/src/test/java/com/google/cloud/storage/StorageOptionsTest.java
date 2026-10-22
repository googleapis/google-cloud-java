/*
 * Copyright 2026 Google LLC
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

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Test;

public final class StorageOptionsTest {

  @FunctionalInterface
  private interface BuilderConsumer {
    void accept(StorageOptions.Builder builder) throws Exception;
  }

  private static void forEachTransport(BuilderConsumer consumer) throws Exception {
    consumer.accept(HttpStorageOptions.http());
    consumer.accept(GrpcStorageOptions.grpc());
  }

  @After
  public void tearDown() {
    StorageMetricsConfig.resetResolversForTesting();
  }

  @Test
  public void defaultState_metricsDisabled() throws Exception {
    forEachTransport(
        builder -> {
          StorageOptions options = builder.build();
          assertThat(options.isEnableOtelMetrics()).isFalse();
          assertThat(options.isEnableOtelDebugMetrics()).isFalse();
          assertThat(options.getMeterProvider()).isNull();
          assertThat(options.getMetricInterval()).isEqualTo(Duration.ofSeconds(60));
        });
  }

  @Test
  public void builder_explicitEnabling() throws Exception {
    MeterProvider mockMeterProvider = SdkMeterProvider.builder().build();
    Duration interval = Duration.ofSeconds(30);

    forEachTransport(
        builder -> {
          StorageOptions options =
              builder
                  .setEnableOtelMetrics(true)
                  .setEnableOtelDebugMetrics(true)
                  .setMeterProvider(mockMeterProvider)
                  .setMetricInterval(interval)
                  .build();
          assertThat(options.isEnableOtelMetrics()).isTrue();
          assertThat(options.isEnableOtelDebugMetrics()).isTrue();
          assertThat(options.getMeterProvider()).isSameInstanceAs(mockMeterProvider);
          assertThat(options.getMetricInterval()).isEqualTo(interval);

          StorageOptions rebuilt = options.toBuilder().build();
          assertThat(rebuilt.isEnableOtelMetrics()).isTrue();
          assertThat(rebuilt.isEnableOtelDebugMetrics()).isTrue();
          assertThat(rebuilt.getMeterProvider()).isSameInstanceAs(mockMeterProvider);
          assertThat(rebuilt.getMetricInterval()).isEqualTo(interval);
        });
  }

  @Test
  public void precedence_builderTakesPrecedenceOverEnv() throws Exception {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "true");
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "true");
    StorageMetricsConfig.setEnvResolverForTesting(env::get);

    forEachTransport(
        builder -> {
          StorageOptions disabled =
              builder.setEnableOtelMetrics(false).setEnableOtelDebugMetrics(false).build();
          assertThat(disabled.isEnableOtelMetrics()).isFalse();
          assertThat(disabled.isEnableOtelDebugMetrics()).isFalse();
        });

    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "false");
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "false");

    forEachTransport(
        builder -> {
          StorageOptions enabled =
              builder.setEnableOtelMetrics(true).setEnableOtelDebugMetrics(true).build();
          assertThat(enabled.isEnableOtelMetrics()).isTrue();
          assertThat(enabled.isEnableOtelDebugMetrics()).isTrue();
        });
  }

  @Test
  public void precedence_builderTakesPrecedenceOverDefaultWhenEnvUnset() throws Exception {
    Map<String, String> env = new HashMap<>();
    StorageMetricsConfig.setEnvResolverForTesting(env::get);

    forEachTransport(
        builder -> {
          StorageOptions enabled =
              builder.setEnableOtelMetrics(true).setEnableOtelDebugMetrics(true).build();
          assertThat(enabled.isEnableOtelMetrics()).isTrue();
          assertThat(enabled.isEnableOtelDebugMetrics()).isTrue();
        });

    forEachTransport(
        builder -> {
          StorageOptions disabled =
              builder.setEnableOtelMetrics(false).setEnableOtelDebugMetrics(false).build();
          assertThat(disabled.isEnableOtelMetrics()).isFalse();
          assertThat(disabled.isEnableOtelDebugMetrics()).isFalse();
        });
  }

  @Test
  public void debugMetricsGatedOnBaseMetrics_builder() throws Exception {
    forEachTransport(
        builder -> {
          StorageOptions debugOnly =
              builder.setEnableOtelMetrics(false).setEnableOtelDebugMetrics(true).build();
          assertThat(debugOnly.isEnableOtelMetrics()).isFalse();
          assertThat(debugOnly.isEnableOtelDebugMetrics()).isFalse();
        });

    forEachTransport(
        builder -> {
          StorageOptions both =
              builder.setEnableOtelMetrics(true).setEnableOtelDebugMetrics(true).build();
          assertThat(both.isEnableOtelMetrics()).isTrue();
          assertThat(both.isEnableOtelDebugMetrics()).isTrue();
        });
  }

  @Test
  public void debugMetricsGatedOnBaseMetrics_env() throws Exception {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "true");
    StorageMetricsConfig.setEnvResolverForTesting(env::get);

    // Base metrics unset (defaults to false) -> debug metrics should evaluate to false
    forEachTransport(
        builder -> {
          StorageOptions envDebugOnly = builder.build();
          assertThat(envDebugOnly.isEnableOtelMetrics()).isFalse();
          assertThat(envDebugOnly.isEnableOtelDebugMetrics()).isFalse();
        });

    // Base metrics explicitly false in env -> debug metrics should evaluate to false
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "false");
    forEachTransport(
        builder -> {
          StorageOptions envExplicitFalse = builder.build();
          assertThat(envExplicitFalse.isEnableOtelMetrics()).isFalse();
          assertThat(envExplicitFalse.isEnableOtelDebugMetrics()).isFalse();
        });

    // Base metrics enabled in env -> debug metrics should evaluate to true
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "true");
    forEachTransport(
        builder -> {
          StorageOptions envBoth = builder.build();
          assertThat(envBoth.isEnableOtelMetrics()).isTrue();
          assertThat(envBoth.isEnableOtelDebugMetrics()).isTrue();
        });
  }

  @Test
  public void permissiveBooleanParsing_trueValues() {
    String[] trueValues = {"1", "t", "T", "true", "TRUE", "True", "  true  "};
    for (String val : trueValues) {
      assertWithMessage("Failed for input value: '%s'", val)
          .that(StorageMetricsConfig.parseBooleanValue(val, "TEST_VAR"))
          .isTrue();
      Map<String, String> env = new HashMap<>();
      env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, val);
      // When builderSetting is null, env var is parsed and respected
      assertWithMessage("Failed for input value: '%s'", val)
          .that(StorageMetricsConfig.isEnableOtelMetrics(env::get, null))
          .isTrue();
      // When builderSetting is provided, builder takes precedence over env var
      assertWithMessage("Failed for input value: '%s'", val)
          .that(StorageMetricsConfig.isEnableOtelMetrics(env::get, false))
          .isFalse();
      assertWithMessage("Failed for input value: '%s'", val)
          .that(StorageMetricsConfig.isEnableOtelMetrics(env::get, true))
          .isTrue();
    }
  }

  @Test
  public void permissiveBooleanParsing_falseValues() {
    String[] falseValues = {"0", "f", "F", "false", "FALSE", "False", "  false  "};
    for (String val : falseValues) {
      assertWithMessage("Failed for input value: '%s'", val)
          .that(StorageMetricsConfig.parseBooleanValue(val, "TEST_VAR"))
          .isFalse();
      Map<String, String> env = new HashMap<>();
      env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, val);
      // When builderSetting is null, env var is parsed and respected
      assertWithMessage("Failed for input value: '%s'", val)
          .that(StorageMetricsConfig.isEnableOtelMetrics(env::get, null))
          .isFalse();
      // When builderSetting is provided, builder takes precedence over env var
      assertWithMessage("Failed for input value: '%s'", val)
          .that(StorageMetricsConfig.isEnableOtelMetrics(env::get, true))
          .isTrue();
      assertWithMessage("Failed for input value: '%s'", val)
          .that(StorageMetricsConfig.isEnableOtelMetrics(env::get, false))
          .isFalse();
    }
  }

  @Test
  public void permissiveBooleanParsing_invalidValuesFallback() {
    String[] invalidValues = {"invalid", "2", "yes", "no", "enabled", ""};
    for (String val : invalidValues) {
      assertWithMessage("Failed for input value: '%s'", val)
          .that(StorageMetricsConfig.parseBooleanValue(val, "TEST_VAR"))
          .isNull();
      Map<String, String> env = new HashMap<>();
      env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, val);
      // Unrecognized values fall back to builder setting if provided
      assertWithMessage("Failed for input value: '%s'", val)
          .that(StorageMetricsConfig.isEnableOtelMetrics(env::get, true))
          .isTrue();
      assertWithMessage("Failed for input value: '%s'", val)
          .that(StorageMetricsConfig.isEnableOtelMetrics(env::get, false))
          .isFalse();
      // When builder setting is null, falls back to default false
      assertWithMessage("Failed for input value: '%s'", val)
          .that(StorageMetricsConfig.isEnableOtelMetrics(env::get, null))
          .isFalse();
    }
  }

  @Test
  public void permissiveBooleanParsing_nullHandled() {
    Map<String, String> emptyEnv = new HashMap<>();
    assertThat(StorageMetricsConfig.isEnableOtelMetrics(emptyEnv::get, null)).isFalse();
    assertThat(StorageMetricsConfig.parseBooleanValue(null, "TEST_VAR")).isNull();
  }

  @Test
  public void toBuilder_doesNotBakeInEnvironmentVariable() throws Exception {
    Map<String, String> env = new HashMap<>();

    forEachTransport(
        builder -> {
          env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "true");
          env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "true");
          StorageMetricsConfig.setEnvResolverForTesting(env::get);

          StorageOptions options = builder.build();
          assertThat(options.isEnableOtelMetrics()).isTrue();
          assertThat(options.isEnableOtelDebugMetrics()).isTrue();

          // Clear environment variable and rebuild
          env.clear();
          StorageOptions rebuilt = options.toBuilder().build();
          assertThat(rebuilt.isEnableOtelMetrics()).isFalse();
          assertThat(rebuilt.isEnableOtelDebugMetrics()).isFalse();
        });
  }

  @Test
  public void environmentVariableJava() throws Exception {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "true");
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "true");
    StorageMetricsConfig.setEnvResolverForTesting(env::get);

    forEachTransport(
        builder -> {
          StorageOptions options = builder.build();
          assertThat(options.isEnableOtelMetrics()).isTrue();
          assertThat(options.isEnableOtelDebugMetrics()).isTrue();
        });
  }

  @Test
  public void setMetricInterval_rejectsNullZeroOrNegative() throws Exception {
    forEachTransport(
        builder -> {
          assertThrows(
              IllegalArgumentException.class,
              () -> builder.setMetricInterval(Duration.ofSeconds(-1)));
          assertThrows(
              IllegalArgumentException.class, () -> builder.setMetricInterval(Duration.ZERO));
          assertThrows(IllegalArgumentException.class, () -> builder.setMetricInterval(null));
        });
  }

  @Test
  public void setMetricInterval_rejectsSubSixtySecondsWithoutCustomProvider() throws Exception {
    // Reject intervals < 60s when meterProvider == null (SDK-owned Cloud Monitoring exporter)
    forEachTransport(
        builder -> {
          assertThrows(
              IllegalArgumentException.class,
              () -> builder.setMetricInterval(Duration.ofSeconds(59)).build());
          assertThrows(
              IllegalArgumentException.class,
              () -> builder.setMetricInterval(Duration.ofSeconds(30)).build());
        });
  }

  @Test
  public void setMetricInterval_acceptsSixtySecondsOrGreaterWithDefaultProvider() throws Exception {
    forEachTransport(
        builder -> {
          StorageOptions options = builder.setMetricInterval(Duration.ofSeconds(60)).build();
          assertThat(options.getMetricInterval()).isEqualTo(Duration.ofSeconds(60));
        });
  }

  @Test
  public void setMetricInterval_acceptsSubSixtySecondsWithCustomMeterProvider() throws Exception {
    MeterProvider customMeterProvider = SdkMeterProvider.builder().build();

    forEachTransport(
        builder -> {
          StorageOptions customOptions =
              builder
                  .setMeterProvider(customMeterProvider)
                  .setMetricInterval(Duration.ofSeconds(30))
                  .build();
          assertThat(customOptions.getMetricInterval()).isEqualTo(Duration.ofSeconds(30));
        });
  }

  @Test
  public void setMetricInterval_acceptsSubSixtySecondsWithCustomOpenTelemetry() throws Exception {
    io.opentelemetry.api.OpenTelemetry customOtel = io.opentelemetry.api.OpenTelemetry.noop();

    forEachTransport(
        builder -> {
          StorageOptions customOptionsOtel =
              builder
                  .setOpenTelemetry(customOtel)
                  .setMetricInterval(Duration.ofSeconds(30))
                  .build();
          assertThat(customOptionsOtel.getMetricInterval()).isEqualTo(Duration.ofSeconds(30));
        });
  }

  @Test
  public void serializationRoundTrip_customMeterProviderDoesNotCarryOver() throws Exception {
    MeterProvider customMeterProvider = SdkMeterProvider.builder().build();

    forEachTransport(
        builder -> {
          StorageOptions options =
              builder.setEnableOtelMetrics(true).setMeterProvider(customMeterProvider).build();

          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(options);
          }

          StorageOptions deserialized;
          try (ObjectInputStream ois =
              new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
            deserialized = (StorageOptions) ois.readObject();
          }

          assertThat(deserialized).isNotNull();
          assertThat(deserialized.isEnableOtelMetrics()).isTrue();
          // Transient meterProvider does not carry over; returns null
          assertThat(deserialized.getMeterProvider()).isNull();
        });
  }

  @Test
  public void serializationRoundTrip_customMeterProviderWithSub60sInterval_clampsToSixtySeconds()
      throws Exception {
    MeterProvider customMeterProvider = SdkMeterProvider.builder().build();

    forEachTransport(
        builder -> {
          StorageOptions options =
              builder
                  .setMeterProvider(customMeterProvider)
                  .setMetricInterval(Duration.ofSeconds(30))
                  .build();
          assertThat(options.getMetricInterval()).isEqualTo(Duration.ofSeconds(30));

          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(options);
          }

          StorageOptions deserialized;
          try (ObjectInputStream ois =
              new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
            deserialized = (StorageOptions) ois.readObject();
          }

          assertThat(deserialized).isNotNull();
          assertThat(deserialized.getMeterProvider()).isNull();
          assertThat(deserialized.getMetricInterval()).isEqualTo(Duration.ofSeconds(60));
        });
  }

  @Test
  public void deserializationWithNullMetricInterval_defaultsToSixtySeconds() throws Exception {
    Field builderField = StorageOptions.Builder.class.getDeclaredField("metricInterval");
    builderField.setAccessible(true);

    forEachTransport(
        builder -> {
          StorageOptions defaultOptions = builder.build();
          builderField.set(builder, null);
          StorageOptions optionsWithNullInterval = builder.build();

          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(optionsWithNullInterval);
          }

          StorageOptions deserialized;
          try (ObjectInputStream ois =
              new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
            deserialized = (StorageOptions) ois.readObject();
          }

          assertThat(deserialized).isNotNull();
          // Verify NPE guard defaults to 60 seconds
          assertThat(deserialized.getMetricInterval()).isEqualTo(Duration.ofSeconds(60));
          // Verify equals and hashCode match a default instance
          assertThat(deserialized).isEqualTo(defaultOptions);
          assertThat(defaultOptions).isEqualTo(deserialized);
          assertThat(deserialized.hashCode()).isEqualTo(defaultOptions.hashCode());
        });
  }

  @Test
  public void extractServerAddress_parsesVariousHostFormats() {
    assertThat(StorageOptions.extractServerAddress("https://storage.googleapis.com"))
        .isEqualTo("storage.googleapis.com");
    assertThat(StorageOptions.extractServerAddress("http://localhost:8080")).isEqualTo("localhost");
    assertThat(StorageOptions.extractServerAddress("google-c2p:///storage.googleapis.com"))
        .isEqualTo("storage.googleapis.com");
    assertThat(StorageOptions.extractServerAddress("https://storage.googleapis.com/path"))
        .isEqualTo("storage.googleapis.com");
    assertThat(StorageOptions.extractServerAddress("http://[::1]:8080")).isEqualTo("::1");
    assertThat(StorageOptions.extractServerAddress("[::1]")).isEqualTo("::1");
    assertThat(StorageOptions.extractServerAddress(null)).isNull();
    assertThat(StorageOptions.extractServerAddress("   ")).isNull();
  }

  @Test
  public void createMetricsContext_populatesRpcSystemNameAndServerAddress() {
    MeterProvider meterProvider = SdkMeterProvider.builder().build();

    HttpStorageOptions httpOptions =
        StorageOptions.http()
            .setEnableOtelMetrics(true)
            .setMeterProvider(meterProvider)
            .setHost("https://storage.googleapis.com")
            .build();
    StorageMetricsContext httpContext = httpOptions.createMetricsContext("GetObject");
    assertThat(httpContext).isNotNull();
    assertThat(httpContext.getBaseAttributes().get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME))
        .isEqualTo("http");
    assertThat(httpContext.getBaseAttributes().get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");

    GrpcStorageOptions grpcOptions =
        StorageOptions.grpc()
            .setEnableOtelMetrics(true)
            .setMeterProvider(meterProvider)
            .setHost("google-c2p:///storage.googleapis.com")
            .build();
    StorageMetricsContext grpcContext = grpcOptions.createMetricsContext("GetObject");
    assertThat(grpcContext).isNotNull();
    assertThat(grpcContext.getBaseAttributes().get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME))
        .isEqualTo("grpc");
    assertThat(grpcContext.getBaseAttributes().get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void meterProvider_usedWhenExplicitlySet() {
    MeterProvider customMeterProvider = SdkMeterProvider.builder().build();
    HttpStorageOptions options =
        StorageOptions.http()
            .setEnableOtelMetrics(true)
            .setMeterProvider(customMeterProvider)
            .build();
    StorageClientMetrics metrics = options.getStorageClientMetrics();
    assertThat(metrics).isNotNull();
  }

  @Test
  public void customOpenTelemetry_meterProviderUsedWhenConfigured() {
    SdkMeterProvider sdkMeterProvider = SdkMeterProvider.builder().build();
    OpenTelemetry customOtel =
        io.opentelemetry.sdk.OpenTelemetrySdk.builder().setMeterProvider(sdkMeterProvider).build();
    HttpStorageOptions options =
        StorageOptions.http().setEnableOtelMetrics(true).setOpenTelemetry(customOtel).build();
    assertThat(options.isCustomOpenTelemetryConfigured()).isTrue();
    StorageClientMetrics metrics = options.getStorageClientMetrics();
    assertThat(metrics).isNotNull();
  }

  @Test
  public void closeStorageClientMetrics_cleansUpMetricsAndClosesSdkOwnedProvider() {
    StorageClientMetricsTest.TestMetricReader reader =
        new StorageClientMetricsTest.TestMetricReader();
    SdkMeterProvider mockOwnedProvider =
        SdkMeterProvider.builder().registerMetricReader(reader).build();
    HttpStorageOptions options =
        StorageOptions.http()
            .setEnableOtelMetrics(true)
            .setMeterProvider(mockOwnedProvider)
            .build();
    StorageClientMetrics metrics =
        StorageClientMetrics.create(mockOwnedProvider, mockOwnedProvider, true, false);
    options.storageClientMetrics = metrics;

    options.closeStorageClientMetrics();
    assertThat(options.storageClientMetrics).isNull();
    assertThat(reader.shutdownCalled.get()).isTrue();
  }

  @Test
  public void closeStorageClientMetrics_doesNotFailOnUserSuppliedMeterProvider() {
    MeterProvider userProvider = SdkMeterProvider.builder().build();
    HttpStorageOptions options =
        StorageOptions.http().setEnableOtelMetrics(true).setMeterProvider(userProvider).build();
    assertThat(options.getStorageClientMetrics()).isNotNull();
    options.closeStorageClientMetrics();
    assertThat(options.storageClientMetrics).isNull();
  }
}
