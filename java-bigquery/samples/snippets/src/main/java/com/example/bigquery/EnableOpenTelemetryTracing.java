/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bigquery;

// [START bigquery_enable_otel_tracing]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.exporter.logging.LoggingSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class EnableOpenTelemetryTracing {
  private static final Logger log = Logger.getLogger(EnableOpenTelemetryTracing.class.getName());

  public static void main(String[] args) {
    // Set logging to System.err.
    ConsoleHandler ch = new ConsoleHandler();
    log.addHandler(ch);

    // TODO(developer): Replace values before running the sample.
    final String tracerName = "Sample Tracer";
    final String datasetId = "sampleDatasetId";

    // Create TracerProvider that exports to a logger.
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.builder(LoggingSpanExporter.create()).build())
            .setSampler(Sampler.alwaysOn())
            .build();

    // Create global OpenTelemetry instance using the TracerProvider.
    OpenTelemetry otel = OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();

    // Create Tracer instance from the OpenTelemetry object. Tracers are used to create
    // Spans. There can be multiple Tracers in an OpenTelemetry instance.
    Tracer tracer = otel.getTracer(tracerName);

    enableOpenTelemetry(tracer, datasetId);
  }

  public static void enableOpenTelemetry(Tracer tracer, String datasetId) {
    // Create BigQuery client to trace. EnableOpenTelemetryTracing and OpenTelemetryTracer must
    // be set to enable tracing.
    BigQueryOptions otelOptions =
        BigQueryOptions.newBuilder()
            .setEnableOpenTelemetryTracing(true)
            .setOpenTelemetryTracer(tracer)
            .build();
    BigQuery bigquery = otelOptions.getService();

    try {
      // Create dataset.
      DatasetInfo info = DatasetInfo.newBuilder(datasetId).build();
      Dataset dataset = bigquery.create(info);
    } catch (Exception e) {
      System.out.println(
          String.format("Failed to create dataset: %s: %s", e.toString(), e.getMessage()));
    } finally {
      bigquery.delete(datasetId);
    }
  }
}
// [END bigquery_enable_otel_tracing]
