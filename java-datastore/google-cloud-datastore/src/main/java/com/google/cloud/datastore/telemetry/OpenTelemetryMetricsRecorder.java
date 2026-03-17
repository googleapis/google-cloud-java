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

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import java.util.Map;
import javax.annotation.Nonnull;

/**
 * OpenTelemetry metrics recorder implementation, used to record metrics when metrics are enabled.
 */
class OpenTelemetryMetricsRecorder implements MetricsRecorder {
  private final OpenTelemetry openTelemetry;

  private final DoubleHistogram transactionLatency;
  private final LongCounter transactionAttemptCount;
  private final DoubleHistogram attemptLatency;
  private final LongCounter attemptCount;
  private final DoubleHistogram operationLatency;
  private final LongCounter operationCount;

  OpenTelemetryMetricsRecorder(@Nonnull OpenTelemetry openTelemetry) {
    this.openTelemetry = openTelemetry;

    Meter meter = openTelemetry.getMeter(TelemetryConstants.METER_NAME);

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

    this.attemptLatency =
        meter
            .histogramBuilder(TelemetryConstants.METRIC_NAME_ATTEMPT_LATENCY)
            .setDescription("Latency of a single RPC attempt")
            .setUnit("ms")
            .build();

    this.attemptCount =
        meter
            .counterBuilder(TelemetryConstants.METRIC_NAME_ATTEMPT_COUNT)
            .setDescription("Number of RPC attempts")
            .setUnit("1")
            .build();

    this.operationLatency =
        meter
            .histogramBuilder(TelemetryConstants.METRIC_NAME_OPERATION_LATENCY)
            .setDescription("Total latency of an operation including retries")
            .setUnit("ms")
            .build();

    this.operationCount =
        meter
            .counterBuilder(TelemetryConstants.METRIC_NAME_OPERATION_COUNT)
            .setDescription("Number of operations")
            .setUnit("1")
            .build();
  }

  OpenTelemetry getOpenTelemetry() {
    return openTelemetry;
  }

  @Override
  public void recordTransactionLatency(double latencyMs, Map<String, String> attributes) {
    transactionLatency.record(latencyMs, toOtelAttributes(attributes));
  }

  @Override
  public void recordTransactionAttemptCount(long count, Map<String, String> attributes) {
    transactionAttemptCount.add(count, toOtelAttributes(attributes));
  }

  @Override
  public void recordAttemptLatency(double latencyMs, Map<String, String> attributes) {
    attemptLatency.record(latencyMs, toOtelAttributes(attributes));
  }

  @Override
  public void recordAttemptCount(long count, Map<String, String> attributes) {
    attemptCount.add(count, toOtelAttributes(attributes));
  }

  @Override
  public void recordOperationLatency(double latencyMs, Map<String, String> attributes) {
    operationLatency.record(latencyMs, toOtelAttributes(attributes));
  }

  @Override
  public void recordOperationCount(long count, Map<String, String> attributes) {
    operationCount.add(count, toOtelAttributes(attributes));
  }

  private static Attributes toOtelAttributes(Map<String, String> attributes) {
    AttributesBuilder builder = Attributes.builder();
    if (attributes != null) {
      attributes.forEach(builder::put);
    }
    return builder.build();
  }
}
