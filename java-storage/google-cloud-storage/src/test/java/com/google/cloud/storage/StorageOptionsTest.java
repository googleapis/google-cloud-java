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

  @After
  public void tearDown() {
    StorageMetricsConfig.resetResolversForTesting();
  }

  @Test
  public void defaultState_metricsDisabled() {
    HttpStorageOptions httpOptions = HttpStorageOptions.http().build();
    assertThat(httpOptions.isEnableOtelMetrics()).isFalse();
    assertThat(httpOptions.isEnableOtelDebugMetrics()).isFalse();
    assertThat(httpOptions.getMeterProvider()).isNull();
    assertThat(httpOptions.getMetricInterval()).isEqualTo(Duration.ofSeconds(60));

    GrpcStorageOptions grpcOptions = GrpcStorageOptions.grpc().build();
    assertThat(grpcOptions.isEnableOtelMetrics()).isFalse();
    assertThat(grpcOptions.isEnableOtelDebugMetrics()).isFalse();
    assertThat(grpcOptions.getMeterProvider()).isNull();
    assertThat(grpcOptions.getMetricInterval()).isEqualTo(Duration.ofSeconds(60));
  }

  @Test
  public void builder_explicitEnabling() {
    MeterProvider mockMeterProvider = SdkMeterProvider.builder().build();
    Duration interval = Duration.ofSeconds(30);

    HttpStorageOptions httpOptions =
        HttpStorageOptions.http()
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .setMeterProvider(mockMeterProvider)
            .setMetricInterval(interval)
            .build();
    assertThat(httpOptions.isEnableOtelMetrics()).isTrue();
    assertThat(httpOptions.isEnableOtelDebugMetrics()).isTrue();
    assertThat(httpOptions.getMeterProvider()).isSameInstanceAs(mockMeterProvider);
    assertThat(httpOptions.getMetricInterval()).isEqualTo(interval);

    HttpStorageOptions rebuiltHttp = httpOptions.toBuilder().build();
    assertThat(rebuiltHttp.isEnableOtelMetrics()).isTrue();
    assertThat(rebuiltHttp.isEnableOtelDebugMetrics()).isTrue();
    assertThat(rebuiltHttp.getMeterProvider()).isSameInstanceAs(mockMeterProvider);
    assertThat(rebuiltHttp.getMetricInterval()).isEqualTo(interval);

    GrpcStorageOptions grpcOptions =
        GrpcStorageOptions.grpc()
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .setMeterProvider(mockMeterProvider)
            .setMetricInterval(interval)
            .build();
    assertThat(grpcOptions.isEnableOtelMetrics()).isTrue();
    assertThat(grpcOptions.isEnableOtelDebugMetrics()).isTrue();
    assertThat(grpcOptions.getMeterProvider()).isSameInstanceAs(mockMeterProvider);
    assertThat(grpcOptions.getMetricInterval()).isEqualTo(interval);

    GrpcStorageOptions rebuiltGrpc = grpcOptions.toBuilder().build();
    assertThat(rebuiltGrpc.isEnableOtelMetrics()).isTrue();
    assertThat(rebuiltGrpc.isEnableOtelDebugMetrics()).isTrue();
    assertThat(rebuiltGrpc.getMeterProvider()).isSameInstanceAs(mockMeterProvider);
    assertThat(rebuiltGrpc.getMetricInterval()).isEqualTo(interval);
  }

  @Test
  public void precedence_builderTakesPrecedenceOverEnv() {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "true");
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "true");
    StorageMetricsConfig.setEnvResolverForTesting(env::get);

    HttpStorageOptions httpDisabled =
        HttpStorageOptions.http()
            .setEnableOtelMetrics(false)
            .setEnableOtelDebugMetrics(false)
            .build();
    assertThat(httpDisabled.isEnableOtelMetrics()).isFalse();
    assertThat(httpDisabled.isEnableOtelDebugMetrics()).isFalse();

    GrpcStorageOptions grpcDisabled =
        GrpcStorageOptions.grpc()
            .setEnableOtelMetrics(false)
            .setEnableOtelDebugMetrics(false)
            .build();
    assertThat(grpcDisabled.isEnableOtelMetrics()).isFalse();
    assertThat(grpcDisabled.isEnableOtelDebugMetrics()).isFalse();

    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "false");
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "false");

    HttpStorageOptions httpEnabled =
        HttpStorageOptions.http()
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .build();
    assertThat(httpEnabled.isEnableOtelMetrics()).isTrue();
    assertThat(httpEnabled.isEnableOtelDebugMetrics()).isTrue();

    GrpcStorageOptions grpcEnabled =
        GrpcStorageOptions.grpc()
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .build();
    assertThat(grpcEnabled.isEnableOtelMetrics()).isTrue();
    assertThat(grpcEnabled.isEnableOtelDebugMetrics()).isTrue();
  }

  @Test
  public void precedence_builderTakesPrecedenceOverDefaultWhenEnvUnset() {
    Map<String, String> env = new HashMap<>();
    StorageMetricsConfig.setEnvResolverForTesting(env::get);

    HttpStorageOptions httpEnabled =
        HttpStorageOptions.http()
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .build();
    assertThat(httpEnabled.isEnableOtelMetrics()).isTrue();
    assertThat(httpEnabled.isEnableOtelDebugMetrics()).isTrue();

    GrpcStorageOptions grpcEnabled =
        GrpcStorageOptions.grpc()
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .build();
    assertThat(grpcEnabled.isEnableOtelMetrics()).isTrue();
    assertThat(grpcEnabled.isEnableOtelDebugMetrics()).isTrue();

    HttpStorageOptions httpDisabled =
        HttpStorageOptions.http()
            .setEnableOtelMetrics(false)
            .setEnableOtelDebugMetrics(false)
            .build();
    assertThat(httpDisabled.isEnableOtelMetrics()).isFalse();
    assertThat(httpDisabled.isEnableOtelDebugMetrics()).isFalse();

    GrpcStorageOptions grpcDisabled =
        GrpcStorageOptions.grpc()
            .setEnableOtelMetrics(false)
            .setEnableOtelDebugMetrics(false)
            .build();
    assertThat(grpcDisabled.isEnableOtelMetrics()).isFalse();
    assertThat(grpcDisabled.isEnableOtelDebugMetrics()).isFalse();
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
  public void toBuilder_doesNotBakeInEnvironmentVariable() {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "true");
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "true");
    StorageMetricsConfig.setEnvResolverForTesting(env::get);

    HttpStorageOptions httpOptions = HttpStorageOptions.http().build();
    assertThat(httpOptions.isEnableOtelMetrics()).isTrue();
    assertThat(httpOptions.isEnableOtelDebugMetrics()).isTrue();

    // Clear environment variable and rebuild
    env.clear();
    HttpStorageOptions rebuiltHttp = httpOptions.toBuilder().build();
    assertThat(rebuiltHttp.isEnableOtelMetrics()).isFalse();
    assertThat(rebuiltHttp.isEnableOtelDebugMetrics()).isFalse();

    // Repeat for GrpcStorageOptions
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "true");
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "true");
    GrpcStorageOptions grpcOptions = GrpcStorageOptions.grpc().build();
    assertThat(grpcOptions.isEnableOtelMetrics()).isTrue();
    assertThat(grpcOptions.isEnableOtelDebugMetrics()).isTrue();

    env.clear();
    GrpcStorageOptions rebuiltGrpc = grpcOptions.toBuilder().build();
    assertThat(rebuiltGrpc.isEnableOtelMetrics()).isFalse();
    assertThat(rebuiltGrpc.isEnableOtelDebugMetrics()).isFalse();
  }

  @Test
  public void environmentVariableJava() {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "true");
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "true");
    StorageMetricsConfig.setEnvResolverForTesting(env::get);

    HttpStorageOptions httpOptions = HttpStorageOptions.http().build();
    assertThat(httpOptions.isEnableOtelMetrics()).isTrue();
    assertThat(httpOptions.isEnableOtelDebugMetrics()).isTrue();

    GrpcStorageOptions grpcOptions = GrpcStorageOptions.grpc().build();
    assertThat(grpcOptions.isEnableOtelMetrics()).isTrue();
    assertThat(grpcOptions.isEnableOtelDebugMetrics()).isTrue();
  }

  @Test
  public void setMetricInterval_rejectsNullZeroOrNegative() {
    assertThrows(
        IllegalArgumentException.class,
        () -> HttpStorageOptions.http().setMetricInterval(Duration.ofSeconds(-1)));
    assertThrows(
        IllegalArgumentException.class,
        () -> HttpStorageOptions.http().setMetricInterval(Duration.ZERO));
    assertThrows(
        IllegalArgumentException.class, () -> HttpStorageOptions.http().setMetricInterval(null));

    assertThrows(
        IllegalArgumentException.class,
        () -> GrpcStorageOptions.grpc().setMetricInterval(Duration.ofSeconds(-1)));
    assertThrows(
        IllegalArgumentException.class,
        () -> GrpcStorageOptions.grpc().setMetricInterval(Duration.ZERO));
    assertThrows(
        IllegalArgumentException.class, () -> GrpcStorageOptions.grpc().setMetricInterval(null));
  }

  @Test
  public void setMetricInterval_rejectsSubSixtySecondsWithoutCustomProvider() {
    // Reject intervals < 60s when meterProvider == null (SDK-owned Cloud Monitoring exporter)
    assertThrows(
        IllegalArgumentException.class,
        () -> HttpStorageOptions.http().setMetricInterval(Duration.ofSeconds(59)).build());
    assertThrows(
        IllegalArgumentException.class,
        () -> HttpStorageOptions.http().setMetricInterval(Duration.ofSeconds(30)).build());

    assertThrows(
        IllegalArgumentException.class,
        () -> GrpcStorageOptions.grpc().setMetricInterval(Duration.ofSeconds(59)).build());
    assertThrows(
        IllegalArgumentException.class,
        () -> GrpcStorageOptions.grpc().setMetricInterval(Duration.ofSeconds(30)).build());
  }

  @Test
  public void setMetricInterval_acceptsSixtySecondsOrGreaterWithDefaultProvider() {
    HttpStorageOptions http60 =
        HttpStorageOptions.http().setMetricInterval(Duration.ofSeconds(60)).build();
    assertThat(http60.getMetricInterval()).isEqualTo(Duration.ofSeconds(60));

    GrpcStorageOptions grpc60 =
        GrpcStorageOptions.grpc().setMetricInterval(Duration.ofSeconds(60)).build();
    assertThat(grpc60.getMetricInterval()).isEqualTo(Duration.ofSeconds(60));
  }

  @Test
  public void setMetricInterval_acceptsSubSixtySecondsWithCustomMeterProvider() {
    MeterProvider customMeterProvider = SdkMeterProvider.builder().build();

    HttpStorageOptions httpCustom =
        HttpStorageOptions.http()
            .setMeterProvider(customMeterProvider)
            .setMetricInterval(Duration.ofSeconds(30))
            .build();
    assertThat(httpCustom.getMetricInterval()).isEqualTo(Duration.ofSeconds(30));

    GrpcStorageOptions grpcCustom =
        GrpcStorageOptions.grpc()
            .setMeterProvider(customMeterProvider)
            .setMetricInterval(Duration.ofSeconds(30))
            .build();
    assertThat(grpcCustom.getMetricInterval()).isEqualTo(Duration.ofSeconds(30));
  }

  @Test
  public void setMetricInterval_acceptsSubSixtySecondsWithCustomOpenTelemetry() {
    io.opentelemetry.api.OpenTelemetry customOtel = io.opentelemetry.api.OpenTelemetry.noop();

    HttpStorageOptions httpCustomOtel =
        HttpStorageOptions.http()
            .setOpenTelemetry(customOtel)
            .setMetricInterval(Duration.ofSeconds(30))
            .build();
    assertThat(httpCustomOtel.getMetricInterval()).isEqualTo(Duration.ofSeconds(30));

    GrpcStorageOptions grpcCustomOtel =
        GrpcStorageOptions.grpc()
            .setOpenTelemetry(customOtel)
            .setMetricInterval(Duration.ofSeconds(30))
            .build();
    assertThat(grpcCustomOtel.getMetricInterval()).isEqualTo(Duration.ofSeconds(30));
  }

  @Test
  public void serializationRoundTrip_customMeterProviderDoesNotCarryOver() throws Exception {
    MeterProvider customMeterProvider = SdkMeterProvider.builder().build();
    HttpStorageOptions httpOptions =
        HttpStorageOptions.http()
            .setEnableOtelMetrics(true)
            .setMeterProvider(customMeterProvider)
            .build();

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(httpOptions);
    }

    HttpStorageOptions deserializedHttp;
    try (ObjectInputStream ois =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      deserializedHttp = (HttpStorageOptions) ois.readObject();
    }

    assertThat(deserializedHttp).isNotNull();
    assertThat(deserializedHttp.isEnableOtelMetrics()).isTrue();
    // Transient meterProvider does not carry over; returns null
    assertThat(deserializedHttp.getMeterProvider()).isNull();

    GrpcStorageOptions grpcOptions =
        GrpcStorageOptions.grpc()
            .setEnableOtelMetrics(true)
            .setMeterProvider(customMeterProvider)
            .build();

    baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(grpcOptions);
    }

    GrpcStorageOptions deserializedGrpc;
    try (ObjectInputStream ois =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      deserializedGrpc = (GrpcStorageOptions) ois.readObject();
    }

    assertThat(deserializedGrpc).isNotNull();
    assertThat(deserializedGrpc.isEnableOtelMetrics()).isTrue();
    // Transient meterProvider does not carry over; returns null
    assertThat(deserializedGrpc.getMeterProvider()).isNull();
  }

  @Test
  public void serializationRoundTrip_customMeterProviderWithSub60sInterval_clampsToSixtySeconds()
      throws Exception {
    MeterProvider customMeterProvider = SdkMeterProvider.builder().build();
    HttpStorageOptions httpOptions =
        HttpStorageOptions.http()
            .setMeterProvider(customMeterProvider)
            .setMetricInterval(Duration.ofSeconds(30))
            .build();
    assertThat(httpOptions.getMetricInterval()).isEqualTo(Duration.ofSeconds(30));

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(httpOptions);
    }

    HttpStorageOptions deserializedHttp;
    try (ObjectInputStream ois =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      deserializedHttp = (HttpStorageOptions) ois.readObject();
    }

    assertThat(deserializedHttp).isNotNull();
    assertThat(deserializedHttp.getMeterProvider()).isNull();
    assertThat(deserializedHttp.getMetricInterval()).isEqualTo(Duration.ofSeconds(60));

    GrpcStorageOptions grpcOptions =
        GrpcStorageOptions.grpc()
            .setMeterProvider(customMeterProvider)
            .setMetricInterval(Duration.ofSeconds(30))
            .build();
    assertThat(grpcOptions.getMetricInterval()).isEqualTo(Duration.ofSeconds(30));

    baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(grpcOptions);
    }

    GrpcStorageOptions deserializedGrpc;
    try (ObjectInputStream ois =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      deserializedGrpc = (GrpcStorageOptions) ois.readObject();
    }

    assertThat(deserializedGrpc).isNotNull();
    assertThat(deserializedGrpc.getMeterProvider()).isNull();
    assertThat(deserializedGrpc.getMetricInterval()).isEqualTo(Duration.ofSeconds(60));
  }

  @Test
  public void deserializationWithNullMetricInterval_defaultsToSixtySeconds() throws Exception {
    Field httpBuilderField = StorageOptions.Builder.class.getDeclaredField("metricInterval");
    httpBuilderField.setAccessible(true);
    HttpStorageOptions.Builder httpBuilder = HttpStorageOptions.http();
    httpBuilderField.set(httpBuilder, null);
    HttpStorageOptions httpWithNullInterval = httpBuilder.build();

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(httpWithNullInterval);
    }

    HttpStorageOptions deserializedHttp;
    try (ObjectInputStream ois =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      deserializedHttp = (HttpStorageOptions) ois.readObject();
    }

    assertThat(deserializedHttp).isNotNull();
    // Verify NPE guard defaults to 60 seconds
    assertThat(deserializedHttp.getMetricInterval()).isEqualTo(Duration.ofSeconds(60));
    // Verify equals and hashCode match a default instance
    HttpStorageOptions defaultHttp = HttpStorageOptions.http().build();
    assertThat(deserializedHttp).isEqualTo(defaultHttp);
    assertThat(defaultHttp).isEqualTo(deserializedHttp);
    assertThat(deserializedHttp.hashCode()).isEqualTo(defaultHttp.hashCode());

    Field grpcBuilderField = StorageOptions.Builder.class.getDeclaredField("metricInterval");
    grpcBuilderField.setAccessible(true);
    GrpcStorageOptions.Builder grpcBuilder = GrpcStorageOptions.grpc();
    grpcBuilderField.set(grpcBuilder, null);
    GrpcStorageOptions grpcWithNullInterval = grpcBuilder.build();

    baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(grpcWithNullInterval);
    }

    GrpcStorageOptions deserializedGrpc;
    try (ObjectInputStream ois =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      deserializedGrpc = (GrpcStorageOptions) ois.readObject();
    }

    assertThat(deserializedGrpc).isNotNull();
    assertThat(deserializedGrpc.getMetricInterval()).isEqualTo(Duration.ofSeconds(60));
    GrpcStorageOptions defaultGrpc = GrpcStorageOptions.grpc().build();
    assertThat(deserializedGrpc).isEqualTo(defaultGrpc);
    assertThat(defaultGrpc).isEqualTo(deserializedGrpc);
    assertThat(deserializedGrpc.hashCode()).isEqualTo(defaultGrpc.hashCode());
  }
}
