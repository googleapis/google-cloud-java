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

import com.google.api.core.InternalApi;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;

@InternalApi
public class BuiltinMetricsTestUtils {

  private BuiltinMetricsTestUtils() {}

  public static MetricData getMetricData(Collection<MetricData> allMetricData, String metricName) {
    List<MetricData> metricDataList =
        allMetricData.stream()
            .filter(md -> md.getName().equals(BuiltinMetricsConstants.METER_NAME + metricName))
            .collect(Collectors.toList());
    if (metricDataList.size() == 0) {
      allMetricData.stream().forEach(md -> System.out.println(md.getName()));
    }
    assertThat(metricDataList.size()).isEqualTo(1);

    return metricDataList.get(0);
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
