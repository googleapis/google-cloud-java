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

package com.google.cloud.datastore.telemetry;

import com.google.api.gax.tracing.OpenTelemetryMetricsRecorder;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;

/**
 * OpenTelemetry implementation for recording Datastore metrics.
 *
 * <p>This class follows a two-tier hierarchy:
 *
 * <ol>
 *   <li><b>Inheritance (GAX Alignment):</b> It extends {@link OpenTelemetryMetricsRecorder} from
 *       the GAX library. This allows it to inherit the standardized implementation for common RPC
 *       metrics like {@code operation_latency} and {@code attempt_count} without duplicating logic.
 *   <li><b>Implementation (Datastore Specifics):</b> It implements {@link DatastoreMetricsRecorder}
 *       to provide specialized recording for Datastore-only concepts, such as {@code
 *       transaction_latency} and {@code transaction_attempt_count}.
 * </ol>
 */
class OpenTelemetryDatastoreMetricsRecorder extends OpenTelemetryMetricsRecorder
    implements DatastoreMetricsRecorder {

  private static final Logger logger =
      Logger.getLogger(OpenTelemetryDatastoreMetricsRecorder.class.getName());

  private final OpenTelemetry openTelemetry;

  // Datastore-specific transaction metrics (registered under the Datastore meter).
  private final DoubleHistogram transactionLatency;
  private final LongCounter transactionAttemptCount;

  /**
   * Creates a recorder based on the Otel configuration.
   *
   * <p>Note: Standard GAX RPC metrics (operation_latency, attempt_latency, etc.) are handled by the
   * base OpenTelemetryMetricsRecorder class. Those metrics are inherited from the parent classes.
   * However, the internal metrics expect plural suffixes (e.g. `latencies` instead of `latency`).
   * The discrepancy between the singular GAX names and the plural internal Cloud Monitoring names
   * is handled by configuring OpenTelemetry Views.
   */
  OpenTelemetryDatastoreMetricsRecorder(@Nonnull OpenTelemetry openTelemetry, String metricPrefix) {
    super(openTelemetry, metricPrefix);
    this.openTelemetry = openTelemetry;

    Meter meter = openTelemetry.getMeter(TelemetryConstants.DATASTORE_METER_NAME);

    this.transactionLatency =
        meter
            .histogramBuilder(TelemetryConstants.METRIC_NAME_TRANSACTION_LATENCY)
            .setDescription("Total latency of transaction operations")
            .setUnit("ms")
            .build();

    this.transactionAttemptCount =
        meter
            .counterBuilder(TelemetryConstants.METRIC_NAME_TRANSACTION_ATTEMPT_COUNT)
            .setDescription("Number of attempts to commit a transaction")
            .build();
  }

  OpenTelemetry getOpenTelemetry() {
    return openTelemetry;
  }

  /**
   * Closes this recorder. If this recorder owns the underlying {@link OpenTelemetry} instance
   * (i.e., it was created by the built-in metrics provider), it will be shut down, flushing any
   * pending metrics. If the instance was provided by the user, this is a no-op.
   */
  @Override
  public void close() {
    if (openTelemetry instanceof OpenTelemetrySdk) {
      try {
        ((OpenTelemetrySdk) openTelemetry).close();
      } catch (Exception e) {
        logger.log(Level.WARNING, "Failed to close built-in OpenTelemetry SDK instance.", e);
      }
    }
  }

  @Override
  public void recordTransactionLatency(double latencyMs, Map<String, String> attributes) {
    transactionLatency.record(latencyMs, toOtelAttributes(attributes));
  }

  @Override
  public void recordTransactionAttemptCount(long count, Map<String, String> attributes) {
    transactionAttemptCount.add(count, toOtelAttributes(attributes));
  }

  private static Attributes toOtelAttributes(Map<String, String> attributes) {
    AttributesBuilder builder = Attributes.builder();
    if (attributes != null) {
      attributes.forEach(builder::put);
    }
    return builder.build();
  }
}
