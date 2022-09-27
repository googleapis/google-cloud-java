/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.stats;

import com.google.api.Distribution.BucketOptions;
import com.google.api.Distribution.BucketOptions.Explicit;
import com.google.api.Metric;
import com.google.api.MetricDescriptor.MetricKind;
import com.google.api.MonitoredResource;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.monitoring.v3.TimeInterval;
import com.google.monitoring.v3.TypedValue;
import io.opencensus.common.Function;
import io.opencensus.common.Functions;
import io.opencensus.common.Timestamp;
import io.opencensus.metrics.LabelKey;
import io.opencensus.metrics.LabelValue;
import io.opencensus.metrics.export.Distribution;
import io.opencensus.metrics.export.Distribution.Bucket;
import io.opencensus.metrics.export.Distribution.BucketOptions.ExplicitOptions;
import io.opencensus.metrics.export.MetricDescriptor;
import io.opencensus.metrics.export.MetricDescriptor.Type;
import io.opencensus.metrics.export.Point;
import io.opencensus.metrics.export.Summary;
import io.opencensus.metrics.export.TimeSeries;
import io.opencensus.metrics.export.Value;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

class BigtableStackdriverExportUtils {

  private static final Logger logger =
      Logger.getLogger(BigtableStackdriverExportUtils.class.getName());

  private static final Function<Double, TypedValue> typedValueDoubleFunction =
      arg -> {
        TypedValue.Builder builder = TypedValue.newBuilder();
        builder.setDoubleValue(arg);
        return builder.build();
      };
  private static final Function<Long, TypedValue> typedValueLongFunction =
      arg -> {
        TypedValue.Builder builder = TypedValue.newBuilder();
        builder.setInt64Value(arg);
        return builder.build();
      };
  private static final Function<Distribution, TypedValue> typedValueDistributionFunction =
      arg -> {
        TypedValue.Builder builder = TypedValue.newBuilder();
        return builder
            .setDistributionValue(BigtableStackdriverExportUtils.createDistribution(arg))
            .build();
      };
  private static final Function<Summary, TypedValue> typedValueSummaryFunction =
      arg -> {
        TypedValue.Builder builder = TypedValue.newBuilder();
        return builder.build();
      };
  private static final Function<ExplicitOptions, BucketOptions> bucketOptionsExplicitFunction =
      arg -> {
        BucketOptions.Builder builder = BucketOptions.newBuilder();
        Explicit.Builder explicitBuilder = Explicit.newBuilder();
        explicitBuilder.addBounds(0.0D);
        explicitBuilder.addAllBounds(arg.getBucketBoundaries());
        builder.setExplicitBuckets(explicitBuilder.build());
        return builder.build();
      };

  // promote the following metric labels to monitored resource labels
  private static final Set<String> PROMOTED_RESOURCE_LABELS =
      ImmutableSet.of(
          BuiltinMeasureConstants.PROJECT_ID.getName(),
          BuiltinMeasureConstants.INSTANCE_ID.getName(),
          BuiltinMeasureConstants.CLUSTER.getName(),
          BuiltinMeasureConstants.ZONE.getName(),
          BuiltinMeasureConstants.TABLE.getName());

  private static final LabelKey CLIENT_UID_LABEL_KEY =
      LabelKey.create(BuiltinMeasureConstants.CLIENT_UID.getName(), "client uid");

  static com.google.monitoring.v3.TimeSeries convertTimeSeries(
      MetricDescriptor metricDescriptor,
      TimeSeries timeSeries,
      String clientId,
      MonitoredResource monitoredResource) {
    String metricName = metricDescriptor.getName();
    List<LabelKey> labelKeys = metricDescriptor.getLabelKeys();
    Type metricType = metricDescriptor.getType();

    MonitoredResource.Builder monitoredResourceBuilder = monitoredResource.toBuilder();

    List<LabelKey> metricTagKeys = new ArrayList<>();
    List<LabelValue> metricTagValues = new ArrayList<>();

    List<LabelValue> labelValues = timeSeries.getLabelValues();
    for (int i = 0; i < labelValues.size(); i++) {
      // If the label is defined in the monitored resource, convert it to
      // a monitored resource label. Otherwise, keep it as a metric label.
      if (PROMOTED_RESOURCE_LABELS.contains(labelKeys.get(i).getKey())) {
        monitoredResourceBuilder.putLabels(
            labelKeys.get(i).getKey(), labelValues.get(i).getValue());
      } else {
        metricTagKeys.add(labelKeys.get(i));
        metricTagValues.add(labelValues.get(i));
      }
    }
    metricTagKeys.add(CLIENT_UID_LABEL_KEY);
    metricTagValues.add(LabelValue.create(clientId));

    com.google.monitoring.v3.TimeSeries.Builder builder =
        com.google.monitoring.v3.TimeSeries.newBuilder();
    builder.setResource(monitoredResourceBuilder.build());
    builder.setMetric(createMetric(metricName, metricTagKeys, metricTagValues));
    builder.setMetricKind(createMetricKind(metricType));
    builder.setValueType(createValueType(metricType));
    Timestamp startTimeStamp = timeSeries.getStartTimestamp();
    for (Point point : timeSeries.getPoints()) {
      builder.addPoints(createPoint(point, startTimeStamp));
    }
    return builder.build();
  }

  static String getProjectId(MetricDescriptor metricDescriptor, TimeSeries timeSeries) {
    List<LabelKey> labelKeys = metricDescriptor.getLabelKeys();
    List<LabelValue> labelValues = timeSeries.getLabelValues();
    for (int i = 0; i < labelKeys.size(); i++) {
      if (labelKeys.get(i).getKey().equals(BuiltinMeasureConstants.PROJECT_ID.getName())) {
        return labelValues.get(i).getValue();
      }
    }
    throw new IllegalStateException("Can't find project id for the current timeseries");
  }

  static String getDefaultTaskValue() {
    // Something like '<pid>@<hostname>'
    final String jvmName = ManagementFactory.getRuntimeMXBean().getName();
    // If not the expected format then generate a random number.
    if (jvmName.indexOf('@') < 1) {
      String hostname = "localhost";
      try {
        hostname = InetAddress.getLocalHost().getHostName();
      } catch (UnknownHostException e) {
        logger.log(Level.INFO, "Unable to get the hostname.", e);
      }
      // Generate a random number and use the same format "random_number@hostname".
      return "java-" + new SecureRandom().nextInt() + "@" + hostname;
    }
    return "java-" + UUID.randomUUID() + jvmName;
  }

  private static MetricKind createMetricKind(Type type) {
    switch (type) {
      case CUMULATIVE_DOUBLE:
      case CUMULATIVE_INT64:
      case CUMULATIVE_DISTRIBUTION:
        return MetricKind.CUMULATIVE;
      default:
        return MetricKind.UNRECOGNIZED;
    }
  }

  private static com.google.api.MetricDescriptor.ValueType createValueType(Type type) {
    switch (type) {
      case CUMULATIVE_DOUBLE:
        return com.google.api.MetricDescriptor.ValueType.DOUBLE;
      case CUMULATIVE_INT64:
        return com.google.api.MetricDescriptor.ValueType.INT64;
      case CUMULATIVE_DISTRIBUTION:
        return com.google.api.MetricDescriptor.ValueType.DISTRIBUTION;
      default:
        return com.google.api.MetricDescriptor.ValueType.UNRECOGNIZED;
    }
  }

  private static Metric createMetric(
      String metricName, List<LabelKey> labelKeys, List<LabelValue> labelValues) {
    Metric.Builder builder = Metric.newBuilder();
    builder.setType(metricName);
    Map<String, String> stringTagMap = Maps.newHashMap();

    for (int i = 0; i < labelValues.size(); ++i) {
      String value = labelValues.get(i).getValue();
      if (value != null) {
        stringTagMap.put(labelKeys.get(i).getKey(), value);
      }
    }

    builder.putAllLabels(stringTagMap);
    return builder.build();
  }

  private static com.google.monitoring.v3.Point createPoint(Point point, Timestamp startTimestamp) {
    com.google.monitoring.v3.TimeInterval.Builder timeIntervalBuilder = TimeInterval.newBuilder();
    timeIntervalBuilder.setStartTime(convertTimestamp(startTimestamp));
    timeIntervalBuilder.setEndTime(convertTimestamp(point.getTimestamp()));

    com.google.monitoring.v3.Point.Builder builder = com.google.monitoring.v3.Point.newBuilder();
    builder.setInterval(timeIntervalBuilder.build());
    builder.setValue(createTypedValue(point.getValue()));
    return builder.build();
  }

  private static TypedValue createTypedValue(Value value) {
    return value.match(
        typedValueDoubleFunction,
        typedValueLongFunction,
        typedValueDistributionFunction,
        typedValueSummaryFunction,
        Functions.throwIllegalArgumentException());
  }

  private static com.google.api.Distribution createDistribution(Distribution distribution) {
    com.google.api.Distribution.Builder builder =
        com.google.api.Distribution.newBuilder()
            .setBucketOptions(createBucketOptions(distribution.getBucketOptions()))
            .setCount(distribution.getCount())
            .setMean(
                distribution.getCount() == 0L
                    ? 0.0D
                    : distribution.getSum() / (double) distribution.getCount())
            .setSumOfSquaredDeviation(distribution.getSumOfSquaredDeviations());
    setBucketCounts(distribution.getBuckets(), builder);
    return builder.build();
  }

  private static BucketOptions createBucketOptions(
      @Nullable Distribution.BucketOptions bucketOptions) {
    com.google.api.Distribution.BucketOptions.Builder builder = BucketOptions.newBuilder();
    return bucketOptions == null
        ? builder.build()
        : bucketOptions.match(
            bucketOptionsExplicitFunction, Functions.throwIllegalArgumentException());
  }

  private static void setBucketCounts(
      List<Bucket> buckets, com.google.api.Distribution.Builder builder) {
    builder.addBucketCounts(0L);

    for (Bucket bucket : buckets) {
      builder.addBucketCounts(bucket.getCount());
    }
  }

  private static com.google.protobuf.Timestamp convertTimestamp(Timestamp censusTimestamp) {
    return censusTimestamp.getSeconds() < 0L
        ? com.google.protobuf.Timestamp.newBuilder().build()
        : com.google.protobuf.Timestamp.newBuilder()
            .setSeconds(censusTimestamp.getSeconds())
            .setNanos(censusTimestamp.getNanos())
            .build();
  }
}
