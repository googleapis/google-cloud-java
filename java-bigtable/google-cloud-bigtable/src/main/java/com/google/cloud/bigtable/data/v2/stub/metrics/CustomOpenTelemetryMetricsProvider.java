/*
 * Copyright 2024 Google LLC
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
import com.google.common.base.MoreObjects;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import java.io.IOException;

/**
 * Set a custom OpenTelemetry instance.
 *
 * <p>To register client side metrics on the custom OpenTelemetry:
 *
 * <pre>{@code
 * SdkMeterProviderBuilder sdkMeterProvider = SdkMeterProvider.builder();
 *
 * // Set up SdkMeterProvider for client side metrics
 * CustomOpenTelemetryMetricsProvider.setupSdkMeterProvider(sdkMeterProvider);
 *
 * // register other metrics reader and views
 * sdkMeterProvider.registerMetricReader(..);
 * sdkMeterProvider.registerView(..);
 *
 * // create the OTEL instance
 * OpenTelemetry openTelemetry = OpenTelemetrySdk
 *     .builder()
 *     .setMeterProvider(sdkMeterProvider.build())
 *     .build();
 *
 * // Override MetricsProvider in BigtableDataSettings
 * BigtableDataSettings settings = BigtableDataSettings.newBuilder()
 *   .setProjectId("my-project")
 *   .setInstanceId("my-instance-id")
 *   .setMetricsProvider(CustomOpenTelemetryMetricsProvider.create(openTelemetry)
 *   .build();
 * }</pre>
 */
public final class CustomOpenTelemetryMetricsProvider implements MetricsProvider {

  private final OpenTelemetry otel;

  public static CustomOpenTelemetryMetricsProvider create(OpenTelemetry otel) {
    return new CustomOpenTelemetryMetricsProvider(otel);
  }

  private CustomOpenTelemetryMetricsProvider(OpenTelemetry otel) {
    this.otel = otel;
  }

  public OpenTelemetry getOpenTelemetry() {
    return otel;
  }

  /**
   * Convenient method to set up SdkMeterProviderBuilder with the default credential and endpoint.
   */
  public static void setupSdkMeterProvider(SdkMeterProviderBuilder builder) throws IOException {
    setupSdkMeterProvider(builder, null, null);
  }

  /** Convenient method to set up SdkMeterProviderBuilder with a custom credential. */
  public static void setupSdkMeterProvider(SdkMeterProviderBuilder builder, Credentials credentials)
      throws IOException {
    setupSdkMeterProvider(builder, credentials, null);
  }

  /** Convenient method to set up SdkMeterProviderBuilder with a custom endpoint. */
  public static void setupSdkMeterProvider(SdkMeterProviderBuilder builder, String endpoint)
      throws IOException {
    setupSdkMeterProvider(builder, null, endpoint);
  }

  /** Convenient method to set up SdkMeterProviderBuilder with a custom credentials and endpoint. */
  public static void setupSdkMeterProvider(
      SdkMeterProviderBuilder builder, Credentials credentials, String endpoint)
      throws IOException {
    BuiltinMetricsView.registerBuiltinMetrics(credentials, builder, endpoint);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("openTelemetry", otel).toString();
  }
}
