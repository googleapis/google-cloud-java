/*
 * Copyright 2024 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.gax.tracing;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.GaxProperties;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import java.util.Map;

/**
 * OpenTelemetry implementation of recording metrics. This implementation collections the
 * measurements related to the lifecyle of an RPC.
 *
 * <p>For the Otel implementation, an attempt is a single RPC invocation and an operation is the
 * collection of all the attempts made before a response is returned (either as a success or an
 * error). A single call (i.e. `EchoClient.echo()`) should have an operation_count of 1 and may have
 * an attempt_count of 1+ (depending on the retry configurations).
 */
@BetaApi
@InternalApi
public class OpenTelemetryMetricsRecorder implements MetricsRecorder {

  public static final String GAX_METER_NAME = "gax-java";
  private final DoubleHistogram attemptLatencyRecorder;
  private final DoubleHistogram operationLatencyRecorder;
  private final LongCounter operationCountRecorder;
  private final LongCounter attemptCountRecorder;

  /**
   * Creates the following instruments for the following metrics:
   *
   * <ul>
   *   <li>Attempt Latency: Histogram
   *   <li>Operation Latency: Histogram
   *   <li>Attempt Count: Counter
   *   <li>Operation Count: Counter
   * </ul>
   *
   * @param openTelemetry OpenTelemetry instance
   * @param serviceName Service Name
   */
  public OpenTelemetryMetricsRecorder(OpenTelemetry openTelemetry, String serviceName) {
    Meter meter =
        openTelemetry
            .meterBuilder(GAX_METER_NAME)
            .setInstrumentationVersion(GaxProperties.getGaxVersion())
            .build();
    this.attemptLatencyRecorder =
        meter
            .histogramBuilder(serviceName + "/attempt_latency")
            .setDescription("Time an individual attempt took")
            .setUnit("ms")
            .build();
    this.operationLatencyRecorder =
        meter
            .histogramBuilder(serviceName + "/operation_latency")
            .setDescription(
                "Total time until final operation success or failure, including retries and backoff.")
            .setUnit("ms")
            .build();
    this.attemptCountRecorder =
        meter
            .counterBuilder(serviceName + "/attempt_count")
            .setDescription("Number of Attempts")
            .setUnit("1")
            .build();
    this.operationCountRecorder =
        meter
            .counterBuilder(serviceName + "/operation_count")
            .setDescription("Number of Operations")
            .setUnit("1")
            .build();
  }

  /**
   * Record the latency for an individual attempt. Data is stored in a Histogram.
   *
   * @param attemptLatency Attempt Latency in ms
   * @param attributes Map of the attributes to store
   */
  @Override
  public void recordAttemptLatency(double attemptLatency, Map<String, String> attributes) {
    attemptLatencyRecorder.record(attemptLatency, toOtelAttributes(attributes));
  }

  /**
   * Record an attempt made. The attempt count number is stored in a LongCounter.
   *
   * <p>The count should be set as 1 every time this is invoked (each retry attempt)
   *
   * @param count The number of attempts made
   * @param attributes Map of the attributes to store
   */
  @Override
  public void recordAttemptCount(long count, Map<String, String> attributes) {
    attemptCountRecorder.add(count, toOtelAttributes(attributes));
  }

  /**
   * Record the latency for the entire operation. This is the latency for the entire RPC, including
   * all the retry attempts
   *
   * @param operationLatency Operation Latency in ms
   * @param attributes Map of the attributes to store
   */
  @Override
  public void recordOperationLatency(double operationLatency, Map<String, String> attributes) {
    operationLatencyRecorder.record(operationLatency, toOtelAttributes(attributes));
  }

  /**
   * Record an operation made. The operation count number is stored in a LongCounter.
   *
   * <p>The operation count should always be 1 and this should be invoked once.
   *
   * @param count The number of operations made
   * @param attributes Map of the attributes to store
   */
  @Override
  public void recordOperationCount(long count, Map<String, String> attributes) {
    operationCountRecorder.add(count, toOtelAttributes(attributes));
  }

  @VisibleForTesting
  Attributes toOtelAttributes(Map<String, String> attributes) {
    Preconditions.checkNotNull(attributes, "Attributes map cannot be null");
    AttributesBuilder attributesBuilder = Attributes.builder();
    attributes.forEach(attributesBuilder::put);
    return attributesBuilder.build();
  }
}
