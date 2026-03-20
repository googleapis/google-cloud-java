/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery.jdbc;

import com.google.cloud.opentelemetry.trace.TraceConfiguration;
import com.google.cloud.opentelemetry.trace.TraceExporter;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import java.io.IOException;

public class BigQueryJdbcOpenTelemetry {

  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryJdbcOpenTelemetry.class.getName());
  private static final Object lock = new Object();
  private static volatile OpenTelemetrySdk autoConfiguredOpenTelemetry;
  private static volatile boolean initialized = false;
  private static final String INSTRUMENTATION_SCOPE_NAME = "com.google.cloud.bigquery.jdbc";

  /**
   * Initializes or returns the OpenTelemetry instance based on hybrid logic. Prefer
   * GlobalOpenTelemetry; fallback to an auto-configured GCP exporter if requested.
   */
  public static OpenTelemetry getOpenTelemetry(boolean enableOpenTelemetry, String exporterType) {
    if (!enableOpenTelemetry) {
      return OpenTelemetry.noop();
    }

    OpenTelemetry globalOtel = GlobalOpenTelemetry.get();
    if ("gcp".equalsIgnoreCase(exporterType)) {
      return getAutoConfiguredOpenTelemetry();
    }

    return globalOtel;
  }

  /** Gets a Tracer for the JDBC driver instrumentation scope. */
  public static Tracer getTracer(OpenTelemetry openTelemetry) {
    return openTelemetry.getTracer(INSTRUMENTATION_SCOPE_NAME);
  }

  /**
   * TODO(b/491245568): Attaches the OpenTelemetry logging bridge to the root
   * java.util.logging.Logger. This is currently a no-op due to shading issues with
   * `opentelemetry-appender-jul`.
   */
  public static void attachLoggingBridge() {
    // No-op for now.
  }

  private static OpenTelemetry getAutoConfiguredOpenTelemetry() {
    if (!initialized) {
      synchronized (lock) {
        if (!initialized) {
          try {
            autoConfiguredOpenTelemetry = initGcpOpenTelemetry();
          } catch (Exception e) {
            LOG.warning("Failed to initialize OpenTelemetry with GCP exporter: " + e.getMessage());
            autoConfiguredOpenTelemetry = null;
          } finally {
            initialized = true;
          }
        }
      }
    }
    return autoConfiguredOpenTelemetry != null ? autoConfiguredOpenTelemetry : OpenTelemetry.noop();
  }

  private static OpenTelemetrySdk initGcpOpenTelemetry() throws IOException {
    LOG.info("Initializing BigQuery JDBC standalone OpenTelemetry SDK with GCP exporter.");

    SpanExporter traceExporter;
    try {
      TraceConfiguration configuration = TraceConfiguration.builder().build();
      traceExporter = TraceExporter.createWithConfiguration(configuration);
    } catch (Exception e) {
      throw new RuntimeException(
          "Could not create TraceExporter. Ensure exporter-trace is on classpath.", e);
    }

    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(BatchSpanProcessor.builder(traceExporter).build())
            .build();

    OpenTelemetrySdk sdk = OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();

    Runtime.getRuntime()
        .addShutdownHook(
            new Thread(
                () -> {
                  try {
                    tracerProvider.close();
                  } catch (Exception e) {
                    LOG.warning("Error closing tracer provider: " + e.getMessage());
                  }
                }));

    return sdk;
  }
}
