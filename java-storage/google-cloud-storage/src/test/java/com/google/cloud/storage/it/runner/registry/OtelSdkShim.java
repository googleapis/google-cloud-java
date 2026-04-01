/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.storage.it.runner.registry;

import com.google.cloud.opentelemetry.metric.GoogleCloudMetricExporter;
import com.google.cloud.opentelemetry.metric.MetricConfiguration;
import com.google.cloud.opentelemetry.trace.TraceConfiguration;
import com.google.cloud.opentelemetry.trace.TraceExporter;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.time.Duration;
import java.util.Arrays;

public final class OtelSdkShim implements ManagedLifecycle {
  private static final boolean STORAGE_IT_OTEL_ENABLE =
      Arrays.asList(
              System.getProperty("STORAGE_IT_OTEL_ENABLE"), System.getenv("STORAGE_IT_OTEL_ENABLE"))
          .contains("true");
  private final String projectId;

  private OpenTelemetrySdk otelSdk;

  OtelSdkShim(String projectId) {
    this.projectId = projectId;
  }

  @Override
  public OpenTelemetry get() {
    if (otelSdk == null) {
      return OpenTelemetry.noop();
    }
    return otelSdk;
  }

  @Override
  public void start() {
    if (!STORAGE_IT_OTEL_ENABLE) {
      otelSdk = null;
      return;
    }
    MetricConfiguration metricConfiguration =
        MetricConfiguration.builder()
            .setProjectId(projectId)
            .setDeadline(Duration.ofSeconds(30))
            .build();
    TraceConfiguration traceConfiguration =
        TraceConfiguration.builder()
            .setProjectId(projectId)
            .setDeadline(Duration.ofSeconds(30))
            .build();
    MetricExporter metricExporter =
        GoogleCloudMetricExporter.createWithConfiguration(metricConfiguration);
    SpanExporter spanExporter = TraceExporter.createWithConfiguration(traceConfiguration);

    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder()
            .registerMetricReader(
                PeriodicMetricReader.builder(metricExporter)
                    .setInterval(Duration.ofSeconds(60))
                    .build())
            .build();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .setSampler(Sampler.traceIdRatioBased(1.0))
            .addSpanProcessor(
                BatchSpanProcessor.builder(spanExporter).setMeterProvider(meterProvider).build())
            .build();
    otelSdk =
        OpenTelemetrySdk.builder()
            .setTracerProvider(tracerProvider)
            .setMeterProvider(meterProvider)
            .build();
  }

  @Override
  public void stop() {
    if (otelSdk != null) {
      otelSdk.close();
    }
  }
}
