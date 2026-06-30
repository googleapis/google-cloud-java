/*
 * Copyright 2024 Google Inc.
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

package com.example.storage;

import com.google.cloud.opentelemetry.propagators.XCloudTraceContextPropagator;
import com.google.cloud.opentelemetry.trace.TraceExporter;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.context.propagation.TextMapPropagator;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import io.opentelemetry.sdk.trace.samplers.Sampler;

// [START storage_enable_otel_tracing]
public class QuickstartOpenTelemetrySample {
  public static void main(String... args) throws Exception {
    SpanExporter spanExporter = TraceExporter.createWithDefaultConfiguration();
    TextMapPropagator propagators =
        TextMapPropagator.composite(
            W3CTraceContextPropagator.getInstance(),
            new XCloudTraceContextPropagator(/* oneway= */ true));

    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder()
            .setPropagators(ContextPropagators.create(propagators))
            .setTracerProvider(
                SdkTracerProvider.builder()
                    // Sample Rate is set to alwaysOn
                    // It is recommended to sample based on a ratio for standard use ie.
                    // .setSampler(Sampler.traceIdRatioBased(0.2)) // sample only 20% of trace ids
                    .setSampler(Sampler.alwaysOn())
                    .addSpanProcessor(BatchSpanProcessor.builder(spanExporter).build())
                    .build())
            .build();
    StorageOptions options = StorageOptions.newBuilder().setOpenTelemetry(openTelemetry).build();
    Storage storage = options.getService();
    System.out.println("Created an instance of storage with OpenTelemetry configured");
  }
}
// [END storage_enable_otel_tracing]
