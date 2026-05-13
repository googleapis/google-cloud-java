/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.grpc.fallback;

import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.CALL_STATUS_METRIC;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.CHANNEL_DOWNTIME_METRIC;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.CHANNEL_NAME;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.CURRENT_CHANNEL_METRIC;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.DEFAULT_METRICS_SET;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.ERROR_RATIO_METRIC;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.FALLBACK_COUNT_METRIC;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.FROM_CHANNEL_NAME;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.METRIC_PREFIX;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.PROBE_RESULT;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.PROBE_RESULT_METRIC;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.STATUS_CODE;
import static com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry.TO_CHANNEL_NAME;

import io.grpc.Status.Code;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleGauge;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class OpenTelemetryMetricsModule {
  private final OpenTelemetryMetricsResource resource;
  private final Map<String, Long> firstFailure = new ConcurrentHashMap<>();
  private final Map<String, Boolean> channelActive = new ConcurrentHashMap<>();

  OpenTelemetryMetricsModule(
      Meter meter, Map<String, Boolean> enableMetrics, boolean disableDefault) {
    this.resource = createMetricInstruments(meter, enableMetrics, disableDefault);
  }

  static boolean isMetricEnabled(
      String metricName, Map<String, Boolean> enableMetrics, boolean disableDefault) {
    Boolean explicitlyEnabled = enableMetrics.get(metricName);
    if (explicitlyEnabled != null) {
      return explicitlyEnabled;
    }
    return DEFAULT_METRICS_SET.contains(metricName) && !disableDefault;
  }

  private OpenTelemetryMetricsResource createMetricInstruments(
      Meter meter, Map<String, Boolean> enableMetrics, boolean disableDefault) {
    OpenTelemetryMetricsResource.Builder builder = OpenTelemetryMetricsResource.builder();

    if (isMetricEnabled(CURRENT_CHANNEL_METRIC, enableMetrics, disableDefault)) {
      builder.currentChannelCounter(
          meter
              .upDownCounterBuilder(String.format("%s.%s", METRIC_PREFIX, CURRENT_CHANNEL_METRIC))
              .setUnit("{channel}")
              .setDescription("1 for currently active channel, 0 otherwise.")
              .buildWithCallback(
                  counter -> {
                    channelActive.forEach(
                        (channelName, isActive) -> {
                          counter.record(
                              isActive ? 1 : 0, Attributes.of(CHANNEL_NAME, channelName));
                        });
                  }));
    }

    if (isMetricEnabled(FALLBACK_COUNT_METRIC, enableMetrics, disableDefault)) {
      builder.fallbackCounter(
          meter
              .counterBuilder(String.format("%s.%s", METRIC_PREFIX, FALLBACK_COUNT_METRIC))
              .setUnit("{occurrence}")
              .setDescription("Number of fallbacks occurred from one channel to another.")
              .build());
    }

    if (isMetricEnabled(CALL_STATUS_METRIC, enableMetrics, disableDefault)) {
      builder.callStatusCounter(
          meter
              .counterBuilder(String.format("%s.%s", METRIC_PREFIX, CALL_STATUS_METRIC))
              .setUnit("{call}")
              .setDescription("Number of calls with a status and channel.")
              .build());
    }

    if (isMetricEnabled(ERROR_RATIO_METRIC, enableMetrics, disableDefault)) {
      builder.errorRatioGauge(
          meter
              .gaugeBuilder(String.format("%s.%s", METRIC_PREFIX, ERROR_RATIO_METRIC))
              .setUnit("1")
              .setDescription("Ratio of failed calls to total calls for a channel.")
              .build());
    }

    if (isMetricEnabled(PROBE_RESULT_METRIC, enableMetrics, disableDefault)) {
      builder.probeResultCounter(
          meter
              .counterBuilder(String.format("%s.%s", METRIC_PREFIX, PROBE_RESULT_METRIC))
              .setUnit("{result}")
              .setDescription("Results of probing functions execution.")
              .build());
    }

    if (isMetricEnabled(CHANNEL_DOWNTIME_METRIC, enableMetrics, disableDefault)) {
      builder.channelDowntimeGauge(
          meter
              .gaugeBuilder(String.format("%s.%s", METRIC_PREFIX, CHANNEL_DOWNTIME_METRIC))
              .setUnit("s")
              .setDescription("How many consecutive seconds probing fails for the channel.")
              .build());
    }

    return builder.build();
  }

  void reportErrorRate(String channelName, float errorRate) {
    DoubleGauge errorRatioGauge = resource.errorRatioGauge();

    if (errorRatioGauge == null) {
      return;
    }

    Attributes attributes = Attributes.of(CHANNEL_NAME, channelName);
    errorRatioGauge.set(errorRate, attributes);
  }

  void reportStatus(String channelName, Code statusCode) {
    LongCounter callStatusCounter = resource.callStatusCounter();
    if (callStatusCounter == null) {
      return;
    }

    Attributes attributes =
        Attributes.of(CHANNEL_NAME, channelName, STATUS_CODE, statusCode.toString());

    callStatusCounter.add(1, attributes);
  }

  void reportProbeResult(String channelName, String result) {
    if (result == null) {
      return;
    }

    LongCounter probeResultCounter = resource.probeResultCounter();
    if (probeResultCounter != null) {

      Attributes attributes =
          Attributes.of(
              CHANNEL_NAME, channelName,
              PROBE_RESULT, result);

      probeResultCounter.add(1, attributes);
    }

    DoubleGauge downtimeGauge = resource.channelDowntimeGauge();
    if (downtimeGauge == null) {
      return;
    }

    Attributes attributes = Attributes.of(CHANNEL_NAME, channelName);

    if (result.isEmpty()) {
      firstFailure.remove(channelName);
      downtimeGauge.set(0, attributes);
    } else {
      firstFailure.putIfAbsent(channelName, System.nanoTime());
      downtimeGauge.set(
          (double) (System.nanoTime() - firstFailure.get(channelName)) / 1_000_000_000, attributes);
    }
  }

  void reportCurrentChannel(String channelName, boolean current) {
    channelActive.put(channelName, current);
  }

  void reportFallback(String fromChannelName, String toChannelName) {
    LongCounter fallbackCounter = resource.fallbackCounter();
    if (fallbackCounter == null) {
      return;
    }

    Attributes attributes =
        Attributes.of(
            FROM_CHANNEL_NAME, fromChannelName,
            TO_CHANNEL_NAME, toChannelName);

    fallbackCounter.add(1, attributes);
  }
}
