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
import java.util.Locale;
import java.util.function.Function;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.Nullable;

final class StorageMetricsConfig {
  private static final Logger LOGGER = Logger.getLogger(StorageMetricsConfig.class.getName());

  static final String ENV_ENABLE_OTEL_METRICS_JAVA = "GCP_STORAGE_JAVA_ENABLE_OTEL_METRICS";
  static final String ENV_ENABLE_OTEL_DEBUG_METRICS = "GCP_STORAGE_JAVA_ENABLE_OTEL_DEBUG_METRICS";

  private static volatile Function<String, String> envResolver = System::getenv;

  private StorageMetricsConfig() {}

  static boolean isEnableOtelMetrics() {
    return isEnableOtelMetrics(null);
  }

  static boolean isEnableOtelDebugMetrics() {
    return isEnableOtelDebugMetrics(null);
  }

  static boolean isEnableOtelMetrics(@Nullable Boolean builderSetting) {
    return isEnableOtelMetrics(envResolver, builderSetting);
  }

  static boolean isEnableOtelDebugMetrics(@Nullable Boolean builderSetting) {
    return isEnableOtelDebugMetrics(envResolver, builderSetting);
  }

  @VisibleForTesting
  static boolean isEnableOtelMetrics(
      Function<String, String> env, @Nullable Boolean builderSetting) {
    String javaEnv = env.apply(ENV_ENABLE_OTEL_METRICS_JAVA);
    Boolean parsed = parseBooleanValue(javaEnv, ENV_ENABLE_OTEL_METRICS_JAVA);
    if (parsed != null) {
      return parsed;
    }
    return builderSetting != null ? builderSetting : false;
  }

  @VisibleForTesting
  static boolean isEnableOtelDebugMetrics(
      Function<String, String> env, @Nullable Boolean builderSetting) {
    String javaEnv = env.apply(ENV_ENABLE_OTEL_DEBUG_METRICS);
    Boolean parsed = parseBooleanValue(javaEnv, ENV_ENABLE_OTEL_DEBUG_METRICS);
    if (parsed != null) {
      return parsed;
    }
    return builderSetting != null ? builderSetting : false;
  }

  @Nullable
  @VisibleForTesting
  static Boolean parseBooleanValue(@Nullable String val, String varName) {
    if (val == null) {
      return null;
    }
    String normalized = val.trim().toLowerCase(Locale.ENGLISH);
    switch (normalized) {
      case "1":
      case "t":
      case "true":
        return Boolean.TRUE;
      case "0":
      case "f":
      case "false":
        return Boolean.FALSE;
      default:
        LOGGER.warning(
            "Unrecognized boolean value '"
                + val
                + "' for "
                + varName
                + "; ignoring and falling back to builder/default");
        return null;
    }
  }

  @VisibleForTesting
  static void setEnvResolverForTesting(Function<String, String> testEnv) {
    envResolver = testEnv != null ? testEnv : System::getenv;
  }

  @VisibleForTesting
  static void resetResolversForTesting() {
    envResolver = System::getenv;
  }
}
