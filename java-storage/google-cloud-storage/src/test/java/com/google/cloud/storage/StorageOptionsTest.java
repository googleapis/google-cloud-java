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
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Test;

public final class StorageOptionsTest {

  @After
  public void tearDown() {
    System.clearProperty(StorageMetricsConfig.SYS_PROP_ENABLE_OTEL_METRICS);
    System.clearProperty(StorageMetricsConfig.SYS_PROP_ENABLE_OTEL_DEBUG_METRICS);
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
  public void builder_explicitDisablingOverridesGate() {
    System.setProperty(StorageMetricsConfig.SYS_PROP_ENABLE_OTEL_METRICS, "true");

    HttpStorageOptions httpOptions = HttpStorageOptions.http().setEnableOtelMetrics(false).build();
    assertThat(httpOptions.isEnableOtelMetrics()).isFalse();

    GrpcStorageOptions grpcOptions = GrpcStorageOptions.grpc().setEnableOtelMetrics(false).build();
    assertThat(grpcOptions.isEnableOtelMetrics()).isFalse();
  }

  @Test
  public void developmentGate_systemProperty() {
    System.setProperty(StorageMetricsConfig.SYS_PROP_ENABLE_OTEL_METRICS, "true");
    System.setProperty(StorageMetricsConfig.SYS_PROP_ENABLE_OTEL_DEBUG_METRICS, "true");

    HttpStorageOptions httpOptions = HttpStorageOptions.http().build();
    assertThat(httpOptions.isEnableOtelMetrics()).isTrue();
    assertThat(httpOptions.isEnableOtelDebugMetrics()).isTrue();

    GrpcStorageOptions grpcOptions = GrpcStorageOptions.grpc().build();
    assertThat(grpcOptions.isEnableOtelMetrics()).isTrue();
    assertThat(grpcOptions.isEnableOtelDebugMetrics()).isTrue();
  }

  @Test
  public void developmentGate_environmentVariableJava() {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "true");
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "true");
    StorageMetricsConfig.setResolversForTesting(k -> null, env::get);

    HttpStorageOptions httpOptions = HttpStorageOptions.http().build();
    assertThat(httpOptions.isEnableOtelMetrics()).isTrue();
    assertThat(httpOptions.isEnableOtelDebugMetrics()).isTrue();

    GrpcStorageOptions grpcOptions = GrpcStorageOptions.grpc().build();
    assertThat(grpcOptions.isEnableOtelMetrics()).isTrue();
    assertThat(grpcOptions.isEnableOtelDebugMetrics()).isTrue();
  }

  @Test
  public void developmentGate_environmentVariableFallback() {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_FALLBACK, "true");
    StorageMetricsConfig.setResolversForTesting(k -> null, env::get);

    HttpStorageOptions httpOptions = HttpStorageOptions.http().build();
    assertThat(httpOptions.isEnableOtelMetrics()).isTrue();

    GrpcStorageOptions grpcOptions = GrpcStorageOptions.grpc().build();
    assertThat(grpcOptions.isEnableOtelMetrics()).isTrue();
  }

  @Test
  public void developmentGate_systemPropertyTakesPrecedenceOverEnv() {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "true");
    Map<String, String> sysProps = new HashMap<>();
    sysProps.put(StorageMetricsConfig.SYS_PROP_ENABLE_OTEL_METRICS, "false");
    StorageMetricsConfig.setResolversForTesting(sysProps::get, env::get);

    HttpStorageOptions httpOptions = HttpStorageOptions.http().build();
    assertThat(httpOptions.isEnableOtelMetrics()).isFalse();

    GrpcStorageOptions grpcOptions = GrpcStorageOptions.grpc().build();
    assertThat(grpcOptions.isEnableOtelMetrics()).isFalse();
  }

  @Test
  public void setMetricInterval_validation() {
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
  public void serializationRoundTrip_preservesMeterProvider() throws Exception {
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
    // Transient meterProvider falls back to openTelemetry.getMeterProvider() after deserialization
    assertThat(deserializedHttp.getMeterProvider()).isNotNull();
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
    assertThat(deserializedGrpc.getMeterProvider())
        .isEqualTo(deserializedGrpc.getOpenTelemetry().getMeterProvider());
  }
}
