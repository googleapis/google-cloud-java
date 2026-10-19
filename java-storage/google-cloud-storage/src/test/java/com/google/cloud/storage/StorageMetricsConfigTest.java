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
}
