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

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;

public class BigQueryJdbcOpenTelemetry {

  static final String INSTRUMENTATION_SCOPE_NAME = "com.google.cloud.bigquery.jdbc";

  private BigQueryJdbcOpenTelemetry() {}

  /**
   * Initializes or returns the OpenTelemetry instance based on hybrid logic. Prefer
   * customOpenTelemetry if provided; fallback to an auto-configured GCP exporter if requested.
   */
  public static OpenTelemetry getOpenTelemetry(
      boolean enableGcpTraceExporter,
      boolean enableGcpLogExporter,
      OpenTelemetry customOpenTelemetry) {
    if (customOpenTelemetry != null) {
      return customOpenTelemetry;
    }

    if (enableGcpTraceExporter || enableGcpLogExporter) {
      // TODO(b/491238299): Initialize and return GCP-specific auto-configured SDK
      return OpenTelemetry.noop();
    }

    return OpenTelemetry.noop();
  }

  /** Gets a Tracer for the JDBC driver instrumentation scope. */
  public static Tracer getTracer(OpenTelemetry openTelemetry) {
    return openTelemetry.getTracer(INSTRUMENTATION_SCOPE_NAME);
  }
}
