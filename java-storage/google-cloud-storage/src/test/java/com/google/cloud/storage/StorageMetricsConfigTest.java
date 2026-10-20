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

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Test;

public final class StorageMetricsConfigTest {

  @After
  public void tearDown() {
    StorageMetricsConfig.resetResolversForTesting();
  }

  @Test
  public void isEnableOtelMetrics_explicitBuilderSettingTakesPrecedenceOverEnvVar() {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "true");
    assertThat(StorageMetricsConfig.isEnableOtelMetrics(env::get, false)).isFalse();

    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "false");
    assertThat(StorageMetricsConfig.isEnableOtelMetrics(env::get, true)).isTrue();
  }

  @Test
  public void isEnableOtelMetrics_envVarRespectedWhenBuilderSettingNull() {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "true");
    assertThat(StorageMetricsConfig.isEnableOtelMetrics(env::get, null)).isTrue();

    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "false");
    assertThat(StorageMetricsConfig.isEnableOtelMetrics(env::get, null)).isFalse();
  }

  @Test
  public void isEnableOtelMetrics_defaultsToFalseWhenUnset() {
    Map<String, String> env = new HashMap<>();
    assertThat(StorageMetricsConfig.isEnableOtelMetrics(env::get, null)).isFalse();
  }

  @Test
  public void isEnableOtelDebugMetrics_explicitBuilderSettingTakesPrecedenceOverEnvVar() {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "true");
    assertThat(StorageMetricsConfig.isEnableOtelDebugMetrics(env::get, false)).isFalse();

    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "false");
    assertThat(StorageMetricsConfig.isEnableOtelDebugMetrics(env::get, true)).isTrue();
  }

  @Test
  public void isEnableOtelDebugMetrics_envVarRespectedWhenBuilderSettingNull() {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "true");
    assertThat(StorageMetricsConfig.isEnableOtelDebugMetrics(env::get, null)).isTrue();

    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "false");
    assertThat(StorageMetricsConfig.isEnableOtelDebugMetrics(env::get, null)).isFalse();
  }

  @Test
  public void isEnableOtelDebugMetrics_defaultsToFalseWhenUnset() {
    Map<String, String> env = new HashMap<>();
    assertThat(StorageMetricsConfig.isEnableOtelDebugMetrics(env::get, null)).isFalse();
  }

  @Test
  public void parseBooleanValue_handlesPermissiveValues() {
    String[] trueValues = {"1", "t", "T", "true", "TRUE", "True", "  true  "};
    for (String val : trueValues) {
      assertWithMessage("Failed for input value: '%s'", val)
          .that(StorageMetricsConfig.parseBooleanValue(val, "TEST_VAR"))
          .isTrue();
    }

    String[] falseValues = {"0", "f", "F", "false", "FALSE", "False", "  false  "};
    for (String val : falseValues) {
      assertWithMessage("Failed for input value: '%s'", val)
          .that(StorageMetricsConfig.parseBooleanValue(val, "TEST_VAR"))
          .isFalse();
    }

    String[] invalidValues = {"invalid", "2", "yes", "no", "enabled", ""};
    for (String val : invalidValues) {
      assertWithMessage("Failed for input value: '%s'", val)
          .that(StorageMetricsConfig.parseBooleanValue(val, "TEST_VAR"))
          .isNull();
    }

    assertThat(StorageMetricsConfig.parseBooleanValue(null, "TEST_VAR")).isNull();
  }

  @Test
  public void setEnvResolverForTesting_resolution() {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "true");
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "true");
    StorageMetricsConfig.setEnvResolverForTesting(env::get);

    assertThat(StorageMetricsConfig.isEnableOtelMetrics()).isTrue();
    assertThat(StorageMetricsConfig.isEnableOtelDebugMetrics()).isTrue();

    StorageMetricsConfig.resetResolversForTesting();
  }

  @Test
  public void debugMetricsGatedOnBaseMetrics_inStorageOptions() {
    Map<String, String> env = new HashMap<>();
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_DEBUG_METRICS, "true");
    StorageMetricsConfig.setEnvResolverForTesting(env::get);

    // Base metrics unset in env (defaults to false) -> options evaluate debug metrics to false
    HttpStorageOptions httpEnvDebugOnly = HttpStorageOptions.http().build();
    assertThat(httpEnvDebugOnly.isEnableOtelMetrics()).isFalse();
    assertThat(httpEnvDebugOnly.isEnableOtelDebugMetrics()).isFalse();

    GrpcStorageOptions grpcEnvDebugOnly = GrpcStorageOptions.grpc().build();
    assertThat(grpcEnvDebugOnly.isEnableOtelMetrics()).isFalse();
    assertThat(grpcEnvDebugOnly.isEnableOtelDebugMetrics()).isFalse();

    // Base metrics set to true in env -> options evaluate debug metrics to true
    env.put(StorageMetricsConfig.ENV_ENABLE_OTEL_METRICS_JAVA, "true");
    HttpStorageOptions httpEnvBoth = HttpStorageOptions.http().build();
    assertThat(httpEnvBoth.isEnableOtelMetrics()).isTrue();
    assertThat(httpEnvBoth.isEnableOtelDebugMetrics()).isTrue();

    GrpcStorageOptions grpcEnvBoth = GrpcStorageOptions.grpc().build();
    assertThat(grpcEnvBoth.isEnableOtelMetrics()).isTrue();
    assertThat(grpcEnvBoth.isEnableOtelDebugMetrics()).isTrue();

    // Explicit builder disabling base metrics overrides env and keeps debug metrics false
    HttpStorageOptions httpBuilderGated =
        HttpStorageOptions.http()
            .setEnableOtelMetrics(false)
            .setEnableOtelDebugMetrics(true)
            .build();
    assertThat(httpBuilderGated.isEnableOtelMetrics()).isFalse();
    assertThat(httpBuilderGated.isEnableOtelDebugMetrics()).isFalse();

    GrpcStorageOptions grpcBuilderGated =
        GrpcStorageOptions.grpc()
            .setEnableOtelMetrics(false)
            .setEnableOtelDebugMetrics(true)
            .build();
    assertThat(grpcBuilderGated.isEnableOtelMetrics()).isFalse();
    assertThat(grpcBuilderGated.isEnableOtelDebugMetrics()).isFalse();

    // Explicit builder enabling both evaluates debug metrics to true
    HttpStorageOptions httpBuilderBoth =
        HttpStorageOptions.http()
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .build();
    assertThat(httpBuilderBoth.isEnableOtelMetrics()).isTrue();
    assertThat(httpBuilderBoth.isEnableOtelDebugMetrics()).isTrue();

    GrpcStorageOptions grpcBuilderBoth =
        GrpcStorageOptions.grpc()
            .setEnableOtelMetrics(true)
            .setEnableOtelDebugMetrics(true)
            .build();
    assertThat(grpcBuilderBoth.isEnableOtelMetrics()).isTrue();
    assertThat(grpcBuilderBoth.isEnableOtelDebugMetrics()).isTrue();
  }
}
