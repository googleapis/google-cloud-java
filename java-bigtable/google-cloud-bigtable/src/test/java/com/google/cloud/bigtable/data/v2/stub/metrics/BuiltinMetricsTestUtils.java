/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.core.InternalApi;
import com.google.common.truth.Correspondence;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.DoublePointData;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;

@InternalApi
public class BuiltinMetricsTestUtils {
  private static final Correspondence<MetricData, String> METRIC_DATA_BY_NAME =
      Correspondence.transforming(MetricData::getName, "MetricData name");

  private BuiltinMetricsTestUtils() {}

  public static MetricData getMetricData(InMemoryMetricReader reader, String metricName) {
    String fullMetricName = BuiltinMetricsConstants.METER_NAME + metricName;
    Collection<MetricData> allMetricData = Collections.emptyList();

    // Fetch the MetricData with retries
    for (int attemptsLeft = 10; attemptsLeft > 0; attemptsLeft--) {
      allMetricData = reader.collectAllMetrics();
      List<MetricData> matchingMetadata =
          allMetricData.stream()
              .filter(md -> METRIC_DATA_BY_NAME.compare(md, fullMetricName))
              .collect(Collectors.toList());
      assertWithMessage(
              "Found multiple MetricData with the same name: %s, in: %s",
              fullMetricName, matchingMetadata)
          .that(matchingMetadata.size())
          .isAtMost(1);

      if (!matchingMetadata.isEmpty()) {
        return matchingMetadata.get(0);
      }

      try {
        Thread.sleep(100);
      } catch (InterruptedException interruptedException) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(interruptedException);
      }
    }

    // MetricData was not found, assert on original collection to get a descriptive error message
    assertThat(allMetricData).comparingElementsUsing(METRIC_DATA_BY_NAME).contains(fullMetricName);
    throw new IllegalStateException(
        "MetricData was missing then appeared, this should never happen");
  }

  public static long getAggregatedValue(MetricData metricData, Attributes attributes) {
    switch (metricData.getType()) {
      case HISTOGRAM:
        HistogramPointData hd =
            metricData.getHistogramData().getPoints().stream()
                .filter(pd -> pd.getAttributes().equals(attributes))
                .collect(Collectors.toList())
                .get(0);
        return (long) hd.getSum() / hd.getCount();
      case LONG_SUM:
        LongPointData ld =
            metricData.getLongSumData().getPoints().stream()
                .filter(pd -> pd.getAttributes().equals(attributes))
                .collect(Collectors.toList())
                .get(0);
        return ld.getValue();
      default:
        return 0;
    }
  }

  public static double getAggregatedDoubleValue(MetricData metricData, Attributes attributes) {
    switch (metricData.getType()) {
      case HISTOGRAM:
        HistogramPointData hd =
            metricData.getHistogramData().getPoints().stream()
                .filter(pd -> pd.getAttributes().equals(attributes))
                .collect(Collectors.toList())
                .get(0);
        return hd.getSum() / hd.getCount();
      case DOUBLE_GAUGE:
        DoublePointData dd =
            metricData.getDoubleGaugeData().getPoints().stream()
                .filter(pd -> pd.getAttributes().equals(attributes))
                .collect(Collectors.toList())
                .get(0);
        return dd.getValue();
      default:
        return 0.0;
    }
  }

  public static Timestamp getStartTimeSeconds(MetricData metricData, Attributes attributes) {
    switch (metricData.getType()) {
      case HISTOGRAM:
        HistogramPointData hd =
            metricData.getHistogramData().getPoints().stream()
                .filter(pd -> pd.getAttributes().equals(attributes))
                .collect(Collectors.toList())
                .get(0);
        return Timestamps.fromNanos(hd.getStartEpochNanos());
      case LONG_SUM:
        LongPointData ld =
            metricData.getLongSumData().getPoints().stream()
                .filter(pd -> pd.getAttributes().equals(attributes))
                .collect(Collectors.toList())
                .get(0);
        return Timestamps.fromNanos(ld.getStartEpochNanos());
      default:
        return Timestamp.getDefaultInstance();
    }
  }

  public static void verifyAttributes(MetricData metricData, Attributes attributes) {
    switch (metricData.getType()) {
      case HISTOGRAM:
        List<HistogramPointData> hd =
            metricData.getHistogramData().getPoints().stream()
                .filter(pd -> pd.getAttributes().equals(attributes))
                .collect(Collectors.toList());
        assertThat(hd).isNotEmpty();
        break;
      case LONG_SUM:
        List<LongPointData> ld =
            metricData.getLongSumData().getPoints().stream()
                .filter(pd -> pd.getAttributes().equals(attributes))
                .collect(Collectors.toList());
        assertThat(ld).isNotEmpty();
        break;
      default:
        Assert.fail("Unexpected type");
    }
  }
}
