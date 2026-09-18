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

import com.google.common.annotations.VisibleForTesting;
import java.util.function.Function;

final class StorageMetricsConfig {
  static final String SYS_PROP_ENABLE_OTEL_METRICS = "com.google.cloud.storage.enable_otel_metrics";
  static final String SYS_PROP_ENABLE_OTEL_DEBUG_METRICS =
      "com.google.cloud.storage.enable_otel_debug_metrics";
  static final String ENV_ENABLE_OTEL_METRICS_JAVA = "GCP_STORAGE_JAVA_ENABLE_OTEL_METRICS";
  static final String ENV_ENABLE_OTEL_METRICS_FALLBACK = "GCP_STORAGE_ENABLE_OTEL_METRICS";
  static final String ENV_ENABLE_OTEL_DEBUG_METRICS = "GCP_STORAGE_JAVA_ENABLE_OTEL_DEBUG_METRICS";

  private static Function<String, String> sysPropResolver = System::getProperty;
  private static Function<String, String> envResolver = System::getenv;

  private StorageMetricsConfig() {}

  static boolean isEnableOtelMetrics() {
    return isEnableOtelMetrics(sysPropResolver, envResolver);
  }

  static boolean isEnableOtelDebugMetrics() {
    return isEnableOtelDebugMetrics(sysPropResolver, envResolver);
  }

  @VisibleForTesting
  static boolean isEnableOtelMetrics(
      Function<String, String> sysProps, Function<String, String> env) {
    String sysProp = sysProps.apply(SYS_PROP_ENABLE_OTEL_METRICS);
    if (sysProp != null) {
      return Boolean.parseBoolean(sysProp);
    }
    String javaEnv = env.apply(ENV_ENABLE_OTEL_METRICS_JAVA);
    if (javaEnv != null) {
      return Boolean.parseBoolean(javaEnv);
    }
    String fallbackEnv = env.apply(ENV_ENABLE_OTEL_METRICS_FALLBACK);
    if (fallbackEnv != null) {
      return Boolean.parseBoolean(fallbackEnv);
    }
    return false;
  }

  @VisibleForTesting
  static boolean isEnableOtelDebugMetrics(
      Function<String, String> sysProps, Function<String, String> env) {
    String sysProp = sysProps.apply(SYS_PROP_ENABLE_OTEL_DEBUG_METRICS);
    if (sysProp != null) {
      return Boolean.parseBoolean(sysProp);
    }
    String javaEnv = env.apply(ENV_ENABLE_OTEL_DEBUG_METRICS);
    if (javaEnv != null) {
      return Boolean.parseBoolean(javaEnv);
    }
    return false;
  }

  @VisibleForTesting
  static void setResolversForTesting(
      Function<String, String> testSysProps, Function<String, String> testEnv) {
    sysPropResolver = testSysProps != null ? testSysProps : System::getProperty;
    envResolver = testEnv != null ? testEnv : System::getenv;
  }

  @VisibleForTesting
  static void resetResolversForTesting() {
    sysPropResolver = System::getProperty;
    envResolver = System::getenv;
  }
}
