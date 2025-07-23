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

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EnableOpenTelemetryTracingIT {
  private final Logger log = Logger.getLogger(this.getClass().getName());
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static class ConsoleSpanExporter
      implements io.opentelemetry.sdk.trace.export.SpanExporter {
    @Override
    public CompletableResultCode export(Collection<SpanData> collection) {
      if (collection.isEmpty()) {
        return CompletableResultCode.ofFailure();
      }
      for (SpanData data : collection) {
        System.out.println(data);
      }
      return CompletableResultCode.ofSuccess();
    }

    @Override
    public CompletableResultCode flush() {
      return CompletableResultCode.ofSuccess();
    }

    @Override
    public CompletableResultCode shutdown() {
      return CompletableResultCode.ofSuccess();
    }
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
    log.log(Level.INFO, "\n" + bout.toString());
  }

  @Test
  public void testEnableOpenTelemetryTracing() {
    final String tracerName = "testSampleTracer";
    final String datasetId = RemoteBigQueryHelper.generateDatasetName();

    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.builder(new ConsoleSpanExporter()).build())
            .setSampler(Sampler.alwaysOn())
            .build();

    OpenTelemetry otel = OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();

    final Tracer tracer = otel.getTracer(tracerName);

    EnableOpenTelemetryTracing.enableOpenTelemetry(tracer, datasetId);

    assertThat(bout.toString()).contains("com.google.cloud.bigquery.BigQuery.createDataset");
    assertThat(bout.toString()).contains("com.google.cloud.bigquery.BigQuery.deleteDataset");
  }
}
