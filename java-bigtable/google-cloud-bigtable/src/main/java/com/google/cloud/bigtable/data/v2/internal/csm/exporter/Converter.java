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
package com.google.cloud.bigtable.data.v2.internal.csm.exporter;

import static com.google.api.MetricDescriptor.MetricKind.CUMULATIVE;
import static com.google.api.MetricDescriptor.MetricKind.GAUGE;
import static com.google.api.MetricDescriptor.MetricKind.UNRECOGNIZED;
import static com.google.api.MetricDescriptor.ValueType.DISTRIBUTION;
import static com.google.api.MetricDescriptor.ValueType.DOUBLE;
import static com.google.api.MetricDescriptor.ValueType.INT64;

import com.google.api.Distribution;
import com.google.api.Distribution.BucketOptions;
import com.google.api.Distribution.BucketOptions.Explicit;
import com.google.api.Metric;
import com.google.api.MetricDescriptor.MetricKind;
import com.google.api.MetricDescriptor.ValueType;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.EnvInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.MetricWrapper;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.monitoring.v3.Point;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.TimeInterval;
import com.google.monitoring.v3.TimeSeries;
import com.google.monitoring.v3.TypedValue;
import com.google.protobuf.util.Timestamps;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoublePointData;
import io.opentelemetry.sdk.metrics.data.HistogramData;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.data.MetricDataType;
import io.opentelemetry.sdk.metrics.data.PointData;
import io.opentelemetry.sdk.metrics.data.SumData;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Helper for exporting metrics from Opentelemetry to Cloud Monitoring.
 *
 * <p>Takes collection {@link MetricData} and uses the {@link MetricWrapper}s defined in {@link
 * MetricRegistry} to compose both the {@link com.google.api.MonitoredResource} and {@link Point}.
 */
class Converter {
  private static final Logger LOGGER = Logger.getLogger(Converter.class.getName());

  private final MetricRegistry metricRegistry;
  private final EnvInfo envInfo;
  private final ClientInfo clientInfo;

  Converter(MetricRegistry metricRegistry, EnvInfo envInfo, ClientInfo clientInfo) {
    this.metricRegistry = metricRegistry;
    this.envInfo = envInfo;
    this.clientInfo = clientInfo;
  }

  Map<ProjectName, Collection<TimeSeries>> convertAll(Collection<MetricData> otelMetrics) {
    ImmutableMultimap.Builder<ProjectName, TimeSeries> builder = ImmutableMultimap.builder();

    for (MetricData metricData : otelMetrics) {
      Multimap<ProjectName, TimeSeries> perProject = convertMetricData(metricData);
      builder.putAll(perProject);
    }
    return builder.build().asMap();
  }

  private Multimap<ProjectName, TimeSeries> convertMetricData(MetricData metricData) {
    MetricWrapper<?> metricDef = metricRegistry.getMetric(metricData.getName());
    if (metricDef == null) {
      LOGGER.log(Level.FINE, "Skipping unexpected metric: {}", metricData.getName());
      return ImmutableListMultimap.of();
    }

    ImmutableMultimap.Builder<ProjectName, TimeSeries> builder = ImmutableMultimap.builder();

    for (PointData pd : metricData.getData().getPoints()) {
      ProjectName projectName =
          metricDef.getSchema().extractProjectName(pd.getAttributes(), envInfo, clientInfo);

      TimeSeries timeSeries =
          TimeSeries.newBuilder()
              .setMetricKind(convertMetricKind(metricData))
              .setValueType(convertValueType(metricData.getType()))
              .setResource(
                  metricDef
                      .getSchema()
                      .extractMonitoredResource(pd.getAttributes(), envInfo, clientInfo))
              .setMetric(
                  Metric.newBuilder()
                      .setType(metricDef.getExternalName())
                      .putAllLabels(
                          metricDef.extractMetricLabels(pd.getAttributes(), envInfo, clientInfo)))
              .addPoints(convertPointData(metricData.getType(), pd))
              .build();

      builder.put(projectName, timeSeries);
    }
    return builder.build();
  }

  private Point convertPointData(MetricDataType type, PointData pointData) {
    TimeInterval timeInterval =
        TimeInterval.newBuilder()
            .setStartTime(Timestamps.fromNanos(pointData.getStartEpochNanos()))
            .setEndTime(Timestamps.fromNanos(pointData.getEpochNanos()))
            .build();

    Point.Builder builder = Point.newBuilder().setInterval(timeInterval);
    switch (type) {
      case HISTOGRAM:
      case EXPONENTIAL_HISTOGRAM:
        return builder
            .setValue(
                TypedValue.newBuilder()
                    .setDistributionValue(convertHistogramData((HistogramPointData) pointData))
                    .build())
            .build();
      case DOUBLE_GAUGE:
      case DOUBLE_SUM:
        return builder
            .setValue(
                TypedValue.newBuilder()
                    .setDoubleValue(((DoublePointData) pointData).getValue())
                    .build())
            .build();
      case LONG_GAUGE:
      case LONG_SUM:
        return builder
            .setValue(TypedValue.newBuilder().setInt64Value(((LongPointData) pointData).getValue()))
            .build();
      default:
        LOGGER.log(Level.WARNING, "unsupported metric type %s", type);
        return builder.build();
    }
  }

  private static Distribution convertHistogramData(HistogramPointData pointData) {
    return Distribution.newBuilder()
        .setCount(pointData.getCount())
        .setMean(pointData.getCount() == 0L ? 0.0D : pointData.getSum() / pointData.getCount())
        .setBucketOptions(
            BucketOptions.newBuilder()
                .setExplicitBuckets(Explicit.newBuilder().addAllBounds(pointData.getBoundaries())))
        .addAllBucketCounts(pointData.getCounts())
        .build();
  }

  private static MetricKind convertMetricKind(MetricData metricData) {
    switch (metricData.getType()) {
      case HISTOGRAM:
      case EXPONENTIAL_HISTOGRAM:
        return convertHistogramType(metricData.getHistogramData());
      case LONG_GAUGE:
      case DOUBLE_GAUGE:
        return GAUGE;
      case LONG_SUM:
        return convertSumDataType(metricData.getLongSumData());
      case DOUBLE_SUM:
        return convertSumDataType(metricData.getDoubleSumData());
      default:
        return UNRECOGNIZED;
    }
  }

  private static MetricKind convertHistogramType(HistogramData histogramData) {
    if (histogramData.getAggregationTemporality() == AggregationTemporality.CUMULATIVE) {
      return CUMULATIVE;
    }
    return UNRECOGNIZED;
  }

  private static MetricKind convertSumDataType(SumData<?> sum) {
    if (!sum.isMonotonic()) {
      return GAUGE;
    }
    if (sum.getAggregationTemporality() == AggregationTemporality.CUMULATIVE) {
      return CUMULATIVE;
    }
    return UNRECOGNIZED;
  }

  private static ValueType convertValueType(MetricDataType metricDataType) {
    switch (metricDataType) {
      case LONG_GAUGE:
      case LONG_SUM:
        return INT64;
      case DOUBLE_GAUGE:
      case DOUBLE_SUM:
        return DOUBLE;
      case HISTOGRAM:
      case EXPONENTIAL_HISTOGRAM:
        return DISTRIBUTION;
      default:
        return ValueType.UNRECOGNIZED;
    }
  }
}
