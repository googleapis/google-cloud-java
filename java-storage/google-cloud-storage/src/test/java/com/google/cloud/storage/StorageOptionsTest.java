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
    assertThat(httpOptions.getMeterProvider())
        .isEqualTo(httpOptions.getOpenTelemetry().getMeterProvider());
    assertThat(httpOptions.getMetricInterval()).isEqualTo(Duration.ofSeconds(60));

    GrpcStorageOptions grpcOptions = GrpcStorageOptions.grpc().build();
    assertThat(grpcOptions.isEnableOtelMetrics()).isFalse();
    assertThat(grpcOptions.isEnableOtelDebugMetrics()).isFalse();
    assertThat(grpcOptions.getMeterProvider())
        .isEqualTo(grpcOptions.getOpenTelemetry().getMeterProvider());
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
  public void precedence_envTakesPrecedenceOverBuilder() {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "true");
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "true");
    StorageMetricsConfig.setEnvResolverForTesting(env::get);

    HttpStorageOptions httpDisabled =
        HttpStorageOptions.http()
            .setEnableOtelMetrics(false)
            .setEnableOtelDebugMetrics(false)
            .build();
    assertThat(httpDisabled.isEnableOtelMetrics()).isTrue();
    assertThat(httpDisabled.isEnableOtelDebugMetrics()).isTrue();

    GrpcStorageOptions grpcDisabled =
        GrpcStorageOptions.grpc()
            .setEnableOtelMetrics(false)
            .setEnableOtelDebugMetrics(false)
            .build();
    assertThat(grpcDisabled.isEnableOtelMetrics()).isTrue();
    assertThat(grpcDisabled.isEnableOtelDebugMetrics()).isTrue();

    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "false");
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "false");

    HttpStorageOptions httpEnabled =
        HttpStorageOptions.http()
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .build();
    assertThat(httpEnabled.isEnableOtelMetrics()).isFalse();
    assertThat(httpEnabled.isEnableOtelDebugMetrics()).isFalse();

    GrpcStorageOptions grpcEnabled =
        GrpcStorageOptions.grpc()
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .build();
    assertThat(grpcEnabled.isEnableOtelMetrics()).isFalse();
    assertThat(grpcEnabled.isEnableOtelDebugMetrics()).isFalse();
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
  public void permissiveBooleanParsing() {
    String[] trueValues = {"1", "t", "T", "true", "TRUE", "True", "  true  "};
    for (String val : trueValues) {
      assertThat(StorageMetricsConfig.parseBooleanValue(val, "TEST_VAR")).isTrue();
      Map<String, String> env = new HashMap<>();
      env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, val);
      assertThat(StorageMetricsConfig.isEnableOtelMetrics(env::get, false)).isTrue();
    }

    String[] falseValues = {"0", "f", "F", "false", "FALSE", "False", "  false  "};
    for (String val : falseValues) {
      assertThat(StorageMetricsConfig.parseBooleanValue(val, "TEST_VAR")).isFalse();
      Map<String, String> env = new HashMap<>();
      env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, val);
      assertThat(StorageMetricsConfig.isEnableOtelMetrics(env::get, true)).isFalse();
    }

    String[] invalidValues = {"invalid", "2", "yes", "no", "enabled", ""};
    for (String val : invalidValues) {
      assertThat(StorageMetricsConfig.parseBooleanValue(val, "TEST_VAR")).isNull();
      Map<String, String> env = new HashMap<>();
      env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, val);
      // Unrecognized values fall back to builder setting
      assertThat(StorageMetricsConfig.isEnableOtelMetrics(env::get, true)).isTrue();
      assertThat(StorageMetricsConfig.isEnableOtelMetrics(env::get, false)).isFalse();
      // When builder setting is null, falls back to default false
      assertThat(StorageMetricsConfig.isEnableOtelMetrics(env::get, null)).isFalse();
    }

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
  public void setMetricInterval_validation() {
    MeterProvider customMeterProvider = SdkMeterProvider.builder().build();

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

    // Accept intervals >= 60s when meterProvider == null
    HttpStorageOptions http60 =
        HttpStorageOptions.http().setMetricInterval(Duration.ofSeconds(60)).build();
    assertThat(http60.getMetricInterval()).isEqualTo(Duration.ofSeconds(60));

    GrpcStorageOptions grpc60 =
        GrpcStorageOptions.grpc().setMetricInterval(Duration.ofSeconds(60)).build();
    assertThat(grpc60.getMetricInterval()).isEqualTo(Duration.ofSeconds(60));

    // Accept intervals < 60s when custom meterProvider is configured
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
    // Transient meterProvider does not carry over; falls back to openTelemetry.getMeterProvider()
    // without NPE
    assertThat(deserializedHttp.getMeterProvider()).isNotNull();
    assertThat(deserializedHttp.getMeterProvider()).isNotSameInstanceAs(customMeterProvider);
    assertThat(deserializedHttp.getMeterProvider())
        .isEqualTo(deserializedHttp.getOpenTelemetry().getMeterProvider());

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
    assertThat(deserializedGrpc.getMeterProvider()).isNotNull();
    assertThat(deserializedGrpc.getMeterProvider()).isNotSameInstanceAs(customMeterProvider);
    assertThat(deserializedGrpc.getMeterProvider())
        .isEqualTo(deserializedGrpc.getOpenTelemetry().getMeterProvider());
  }

  @Test
  public void deserializationWithNullMetricInterval_defaultsToSixtySeconds() throws Exception {
    Field httpBuilderField = HttpStorageOptions.Builder.class.getDeclaredField("metricInterval");
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

    Field grpcBuilderField = GrpcStorageOptions.Builder.class.getDeclaredField("metricInterval");
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
