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

package com.google.cloud.spanner;

import com.google.common.base.Preconditions;
import io.opentelemetry.api.OpenTelemetry;

/**
 * A {@link MetricsProvider} that records Spanner client metrics on a caller-provided {@link
 * OpenTelemetry} instance. The caller owns the metrics pipeline (readers, exporters and resource);
 * Spanner only records the client metric instruments on it. The caller-owned sink is never exported
 * to Google Cloud Monitoring by the Spanner client and is independent of the built-in Cloud
 * Monitoring export.
 *
 * <p>Metrics recorded through this provider use the {@code spanner/client/} instrument namespace
 * instead of the reserved {@code spanner.googleapis.com/internal/client/} namespace that is used
 * for the Cloud Monitoring export, so that re-exporting the caller-owned pipeline to Cloud
 * Monitoring does not conflict with the curated Spanner metric descriptors.
 *
 * <p>It is recommended to register the Spanner client-metrics views on the {@link
 * io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder} with {@link
 * SpannerMetrics#configureMeterProviderBuilder(io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder)}
 * before creating the {@link OpenTelemetry} instance. Without the views, metrics are still
 * recorded, but with the raw instrument names, default histogram buckets and without attribute
 * filtering. When registering the views, use a meter provider that is dedicated to Spanner client
 * metrics; see {@link
 * SpannerMetrics#configureMeterProviderBuilder(io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder)}
 * for details.
 *
 * <p>gRPC-layer metrics are only recorded if the given {@link OpenTelemetry} instance is an
 * instance of {@link io.opentelemetry.sdk.OpenTelemetrySdk}; for any other implementation they are
 * skipped. All other client metrics work with any {@link OpenTelemetry} implementation.
 *
 * <p>Client metrics are not recorded when the client runs against the Spanner emulator, regardless
 * of the configured {@link MetricsProvider}; the caller-owned sink is inactive in that mode.
 *
 * <p>This provider is independent of the default Cloud Monitoring export: the caller-owned
 * destination recorded here keeps recording even when the Cloud Monitoring (GCM) sink is disabled
 * via {@link SpannerOptions.Builder#setBuiltInMetricsEnabled(boolean)} or the {@code
 * SPANNER_DISABLE_BUILTIN_METRICS} environment variable. On {@link
 * SpannerOptions.InstanceType#OMNI} clients, where the GCM sink is never active, this provider is
 * the way to export client metrics.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * SdkMeterProviderBuilder meterProviderBuilder =
 *     SdkMeterProvider.builder().registerMetricReader(PeriodicMetricReader.create(myExporter));
 * SpannerMetrics.configureMeterProviderBuilder(meterProviderBuilder);
 * OpenTelemetry openTelemetry =
 *     OpenTelemetrySdk.builder().setMeterProvider(meterProviderBuilder.build()).build();
 * SpannerOptions options =
 *     SpannerOptions.newBuilder()
 *         .setClientMetricsProvider(CustomOpenTelemetryMetricsProvider.create(openTelemetry))
 *         .build();
 * }</pre>
 */
public final class CustomOpenTelemetryMetricsProvider implements MetricsProvider {

  private final OpenTelemetry openTelemetry;

  private CustomOpenTelemetryMetricsProvider(OpenTelemetry openTelemetry) {
    this.openTelemetry = openTelemetry;
  }

  /**
   * Creates a provider that records Spanner client metrics on the given caller-owned {@link
   * OpenTelemetry} instance.
   */
  public static CustomOpenTelemetryMetricsProvider create(OpenTelemetry openTelemetry) {
    Preconditions.checkNotNull(openTelemetry, "openTelemetry cannot be null");
    return new CustomOpenTelemetryMetricsProvider(openTelemetry);
  }

  /** Returns the caller-owned {@link OpenTelemetry} instance used for client metrics. */
  public OpenTelemetry getOpenTelemetry() {
    return openTelemetry;
  }
}
