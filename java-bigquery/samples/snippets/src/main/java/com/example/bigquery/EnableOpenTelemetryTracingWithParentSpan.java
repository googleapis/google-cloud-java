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

// [START bigquery_enable_otel_tracing_with_parent_span]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import io.opentelemetry.exporter.logging.LoggingSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.time.LocalDate;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class EnableOpenTelemetryTracingWithParentSpan {
  private static final Logger log =
      Logger.getLogger(EnableOpenTelemetryTracingWithParentSpan.class.getName());

  public static void main(String[] args) {
    // Set logging to System.err.
    ConsoleHandler ch = new ConsoleHandler();
    log.addHandler(ch);

    // TODO(developer): Replace values before running the sample.
    final String tracerName = "Sample Tracer";
    final String parentSpanName = "Sample Parent Span";
    final String datasetId = "sampleDatasetId";

    // Create TracerProvider that exports to a logger.
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.builder(LoggingSpanExporter.create()).build())
            .setSampler(Sampler.alwaysOn())
            .build();

    // Create OpenTelemetry instance using the TracerProvider.
    OpenTelemetry otel = OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();

    // Create Tracer instance from the global OpenTelemetry object. Tracers are used to create
    // Spans. There can be multiple Tracers in a global OpenTelemetry instance.
    final Tracer tracer = otel.getTracer(tracerName);
    enableOpenTelemetryWithParentSpan(tracer, parentSpanName, datasetId);
  }

  public static void enableOpenTelemetryWithParentSpan(
      Tracer tracer, String parentSpanName, String datasetId) {
    // Create BigQuery client to trace. EnableOpenTelemetryTracing and OpenTelemetryTracer must
    // be set to enable tracing.
    BigQueryOptions otelOptions =
        BigQueryOptions.newBuilder()
            .setEnableOpenTelemetryTracing(true)
            .setOpenTelemetryTracer(tracer)
            .build();
    BigQuery bigquery = otelOptions.getService();

    LocalDate currentDate = LocalDate.now();

    // Create the root parent Span. setNoParent() ensures that it is a parent Span with a Span ID
    // of 0.
    Span parentSpan =
        tracer
            .spanBuilder(parentSpanName)
            .setNoParent()
            .setAttribute("current_date", currentDate.toString())
            .startSpan();

    // The Span Context is automatically passed on to any functions called within the scope of the
    // try block. parentSpan.makeCurrent() sets parentSpan to be the parent of any Spans created in
    // this scope, or the scope of any functions called within this scope.
    try (Scope parentScope = parentSpan.makeCurrent()) {
      DatasetInfo info = DatasetInfo.newBuilder(datasetId).build();
      Dataset dataset = bigquery.create(info);
    } catch (Exception e) {
      System.out.println(
          String.format("Failed to create dataset: %s: %s", e.toString(), e.getMessage()));
    } finally {
      // finally block ensures that Spans are cleaned up properly.
      parentSpan.end();
      bigquery.delete(datasetId);
    }
  }
}
// [END bigquery_enable_otel_tracing_with_parent_span]
