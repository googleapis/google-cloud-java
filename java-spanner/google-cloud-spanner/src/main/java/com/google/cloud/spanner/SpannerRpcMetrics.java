/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.spanner;

import com.google.api.core.InternalApi;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.Meter;
import java.util.Arrays;
import java.util.List;

@InternalApi
public class SpannerRpcMetrics {
  private final LongHistogram gfeLatencies;
  private final LongCounter gfeHeaderMissingCount;

  public SpannerRpcMetrics(OpenTelemetry openTelemetry) {
    if (!SpannerOptions.isEnabledOpenTelemetryMetrics()) {
      gfeLatencies = null;
      gfeHeaderMissingCount = null;
      return;
    }

    Meter meter = openTelemetry.getMeter(MetricRegistryConstants.INSTRUMENTATION_SCOPE);
    List<Long> RPC_MILLIS_BUCKET_BOUNDARIES =
        Arrays.asList(
            1L, 2L, 3L, 4L, 5L, 6L, 8L, 10L, 13L, 16L, 20L, 25L, 30L, 40L, 50L, 65L, 80L, 100L,
            130L, 160L, 200L, 250L, 300L, 400L, 500L, 650L, 800L, 1000L, 2000L, 5000L, 10000L,
            20000L, 50000L, 100000L);
    gfeLatencies =
        meter
            .histogramBuilder(MetricRegistryConstants.SPANNER_GFE_LATENCY)
            .ofLongs()
            .setDescription(MetricRegistryConstants.SPANNER_GFE_LATENCY_DESCRIPTION)
            .setUnit("ms")
            .setExplicitBucketBoundariesAdvice(RPC_MILLIS_BUCKET_BOUNDARIES)
            .build();
    gfeHeaderMissingCount =
        meter
            .counterBuilder(MetricRegistryConstants.SPANNER_GFE_HEADER_MISSING_COUNT)
            .setDescription(MetricRegistryConstants.SPANNER_GFE_HEADER_MISSING_COUNT_DESCRIPTION)
            .setUnit(MetricRegistryConstants.COUNT)
            .build();
  }

  @InternalApi
  public void recordGfeLatency(long value, Attributes attributes) {
    if (gfeLatencies != null) {
      gfeLatencies.record(value, attributes);
    }
  }

  @InternalApi
  public void recordGfeHeaderMissingCount(long value, Attributes attributes) {
    if (gfeHeaderMissingCount != null) {
      gfeHeaderMissingCount.add(value, attributes);
    }
  }
}
