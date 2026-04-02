/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.spanner;

import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.tracing.OpenTelemetryMetricsRecorder;
import com.google.common.base.Preconditions;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import java.util.Map;

/**
 * Implementation for recording built in metrics.
 *
 * <p>This class extends the {@link OpenTelemetryMetricsRecorder} which implements the *
 * measurements related to the lifecyle of an RPC.
 */
class BuiltInMetricsRecorder extends OpenTelemetryMetricsRecorder {

  private final DoubleHistogram gfeLatencyRecorder;
  private final DoubleHistogram afeLatencyRecorder;
  private final LongCounter gfeHeaderMissingCountRecorder;
  private final LongCounter afeHeaderMissingCountRecorder;

  /**
   * Creates the following instruments for the following metrics:
   *
   * <ul>
   *   <li>GFE Latency: Histogram
   * </ul>
   *
   * @param openTelemetry OpenTelemetry instance
   * @param serviceName Service Name
   */
  BuiltInMetricsRecorder(OpenTelemetry openTelemetry, String serviceName) {
    super(openTelemetry, serviceName);
    Meter meter =
        openTelemetry
            .meterBuilder(BuiltInMetricsConstant.SPANNER_METER_NAME)
            .setInstrumentationVersion(GaxProperties.getLibraryVersion(getClass()))
            .build();
    this.gfeLatencyRecorder =
        meter
            .histogramBuilder(serviceName + '/' + BuiltInMetricsConstant.GFE_LATENCIES_NAME)
            .setDescription(
                "Latency between Google's network receiving an RPC and reading back the first byte"
                    + " of the response")
            .setUnit("ms")
            .setExplicitBucketBoundariesAdvice(BuiltInMetricsConstant.BUCKET_BOUNDARIES)
            .build();
    this.afeLatencyRecorder =
        meter
            .histogramBuilder(serviceName + '/' + BuiltInMetricsConstant.AFE_LATENCIES_NAME)
            .setDescription(
                "Latency between Spanner API Frontend receiving an RPC and starting to write back"
                    + " the response.")
            .setExplicitBucketBoundariesAdvice(BuiltInMetricsConstant.BUCKET_BOUNDARIES)
            .setUnit("ms")
            .build();
    this.gfeHeaderMissingCountRecorder =
        meter
            .counterBuilder(serviceName + '/' + BuiltInMetricsConstant.GFE_CONNECTIVITY_ERROR_NAME)
            .setDescription("Number of requests that failed to reach the Google network.")
            .setUnit("1")
            .build();
    this.afeHeaderMissingCountRecorder =
        meter
            .counterBuilder(serviceName + '/' + BuiltInMetricsConstant.AFE_CONNECTIVITY_ERROR_NAME)
            .setDescription("Number of requests that failed to reach the Spanner API Frontend.")
            .setUnit("1")
            .build();
  }

  /**
   * Record the latency between Google's network receiving an RPC and reading back the first byte of
   * the response. Data is stored in a Histogram.
   *
   * @param gfeLatency Attempt Latency in ms
   * @param attributes Map of the attributes to store
   */
  void recordServerTimingHeaderMetrics(
      Float gfeLatency,
      Float afeLatency,
      Map<String, String> attributes,
      boolean isDirectPathUsed,
      boolean isAfeEnabled) {
    io.opentelemetry.api.common.Attributes otelAttributes = toOtelAttributes(attributes);
    if (!isDirectPathUsed) {
      if (gfeLatency != null) {
        gfeLatencyRecorder.record(gfeLatency, otelAttributes);
      } else {
        gfeHeaderMissingCountRecorder.add(1, otelAttributes);
      }
    }
    if (isAfeEnabled) {
      if (afeLatency != null) {
        afeLatencyRecorder.record(afeLatency, otelAttributes);
      } else {
        afeHeaderMissingCountRecorder.add(1, otelAttributes);
      }
    }
  }

  Attributes toOtelAttributes(Map<String, String> attributes) {
    Preconditions.checkNotNull(attributes, "Attributes map cannot be null");
    AttributesBuilder attributesBuilder = Attributes.builder();
    attributes.forEach(attributesBuilder::put);
    return attributesBuilder.build();
  }
}
