/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import com.google.auth.Credentials;
import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.View;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/**
 * A util class to register built-in metrics on a custom OpenTelemetry instance. This is for
 * advanced usage, and is only necessary when wanting to write built-in metrics to cloud monitoring
 * and custom sinks.
 *
 * @deprecated Use methods in {@link CustomOpenTelemetryMetricsProvider} instead.
 */
@Deprecated
public class BuiltinMetricsView {
  private BuiltinMetricsView() {}

  @Deprecated
  public static void registerBuiltinMetrics(String projectId, SdkMeterProviderBuilder builder)
      throws IOException {
    registerBuiltinMetrics(builder);
  }

  @Deprecated
  public static void registerBuiltinMetrics(SdkMeterProviderBuilder builder) throws IOException {
    for (Map.Entry<InstrumentSelector, View> entry :
        BuiltinMetricsConstants.getAllViews().entrySet()) {
      builder.registerView(entry.getKey(), entry.getValue());
    }
  }

  @Deprecated
  public static void registerBuiltinMetrics(
      String projectId, @Nullable Credentials credentials, SdkMeterProviderBuilder builder)
      throws IOException {
    registerBuiltinMetrics(builder);
  }

  @Deprecated
  public static void registerBuiltinMetrics(
      String projectId,
      @Nullable Credentials credentials,
      SdkMeterProviderBuilder builder,
      @Nullable String endpoint)
      throws IOException {
    registerBuiltinMetrics(credentials, builder, endpoint);
  }

  @Deprecated
  public static void registerBuiltinMetrics(
      @Nullable Credentials credentials, SdkMeterProviderBuilder builder, @Nullable String endpoint)
      throws IOException {
    registerBuiltinMetrics(builder);
  }

  @Deprecated
  public static void registerBuiltinMetrics(
      @Nullable Credentials credentials,
      SdkMeterProviderBuilder builder,
      @Nullable String endpoint,
      @Nullable ScheduledExecutorService executorService)
      throws IOException {
    registerBuiltinMetrics(builder);
  }

  @Deprecated
  static void registerBuiltinMetricsWithUniverseDomain(
      @Nullable Credentials credentials,
      SdkMeterProviderBuilder builder,
      @Nullable String endpoint,
      String universeDomain,
      @Nullable ScheduledExecutorService executorService)
      throws IOException {
    registerBuiltinMetrics(builder);
  }
}
