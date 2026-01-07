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
import com.google.auth.oauth2.GoogleCredentials;
import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReaderBuilder;
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

  /**
   * Register built-in metrics on the {@link SdkMeterProviderBuilder} with application default
   * credentials and default endpoint.
   *
   * @deprecated projectId is no longer used. Call {@link
   *     #registerBuiltinMetrics(SdkMeterProviderBuilder)} instead.
   */
  @Deprecated
  public static void registerBuiltinMetrics(String projectId, SdkMeterProviderBuilder builder)
      throws IOException {
    BuiltinMetricsView.registerBuiltinMetrics(
        GoogleCredentials.getApplicationDefault(), builder, null);
  }

  /**
   * Register built-in metrics on the {@link SdkMeterProviderBuilder} with application default
   * credentials and default endpoint.
   */
  public static void registerBuiltinMetrics(SdkMeterProviderBuilder builder) throws IOException {
    BuiltinMetricsView.registerBuiltinMetrics(
        GoogleCredentials.getApplicationDefault(), builder, null);
  }

  /**
   * Register built-in metrics on the {@link SdkMeterProviderBuilder} with custom credentials and
   * default endpoint.
   *
   * @deprecated projectId is no longer used. Call {@link #registerBuiltinMetrics(Credentials,
   *     SdkMeterProviderBuilder, String)} instead.
   */
  @Deprecated
  public static void registerBuiltinMetrics(
      String projectId, @Nullable Credentials credentials, SdkMeterProviderBuilder builder)
      throws IOException {
    BuiltinMetricsView.registerBuiltinMetrics(credentials, builder, null);
  }

  /**
   * Register built-in metrics on the {@link SdkMeterProviderBuilder} with custom credentials and
   * endpoint.
   *
   * @deprecated projectId is no longer used. Call {@link #registerBuiltinMetrics(Credentials,
   *     SdkMeterProviderBuilder, String)} instead.
   */
  @Deprecated
  public static void registerBuiltinMetrics(
      String projectId,
      @Nullable Credentials credentials,
      SdkMeterProviderBuilder builder,
      @Nullable String endpoint)
      throws IOException {
    registerBuiltinMetrics(credentials, builder, endpoint);
  }

  /**
   * Register built-in metrics on the {@link SdkMeterProviderBuilder} with custom credentials and
   * endpoint.
   */
  public static void registerBuiltinMetrics(
      @Nullable Credentials credentials, SdkMeterProviderBuilder builder, @Nullable String endpoint)
      throws IOException {
    registerBuiltinMetricsWithUniverseDomain(
        credentials, builder, endpoint, Credentials.GOOGLE_DEFAULT_UNIVERSE, null);
  }

  /**
   * Register built-in metrics on the {@link SdkMeterProviderBuilder} with custom credentials,
   * endpoint and executor service.
   */
  public static void registerBuiltinMetrics(
      @Nullable Credentials credentials,
      SdkMeterProviderBuilder builder,
      @Nullable String endpoint,
      @Nullable ScheduledExecutorService executorService)
      throws IOException {
    registerBuiltinMetricsWithUniverseDomain(
        credentials, builder, endpoint, Credentials.GOOGLE_DEFAULT_UNIVERSE, executorService);
  }

  static void registerBuiltinMetricsWithUniverseDomain(
      @Nullable Credentials credentials,
      SdkMeterProviderBuilder builder,
      @Nullable String endpoint,
      String universeDomain,
      @Nullable ScheduledExecutorService executorService)
      throws IOException {
    MetricExporter publicExporter =
        BigtableCloudMonitoringExporter.create(
            "bigtable metrics",
            credentials,
            endpoint,
            universeDomain,
            new BigtableCloudMonitoringExporter.PublicTimeSeriesConverter(),
            executorService);

    for (Map.Entry<InstrumentSelector, View> entry :
        BuiltinMetricsConstants.getAllViews().entrySet()) {
      builder.registerView(entry.getKey(), entry.getValue());
    }
    PeriodicMetricReaderBuilder readerBuilder = PeriodicMetricReader.builder(publicExporter);
    if (executorService != null) {
      readerBuilder.setExecutor(executorService);
    }
    builder.registerMetricReader(readerBuilder.build());
  }
}
