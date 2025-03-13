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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import static com.google.api.Distribution.BucketOptions;
import static com.google.api.Distribution.BucketOptions.Explicit;
import static com.google.api.MetricDescriptor.MetricKind;
import static com.google.api.MetricDescriptor.MetricKind.CUMULATIVE;
import static com.google.api.MetricDescriptor.MetricKind.GAUGE;
import static com.google.api.MetricDescriptor.MetricKind.UNRECOGNIZED;
import static com.google.api.MetricDescriptor.ValueType;
import static com.google.api.MetricDescriptor.ValueType.DISTRIBUTION;
import static com.google.api.MetricDescriptor.ValueType.DOUBLE;
import static com.google.api.MetricDescriptor.ValueType.INT64;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.BIGTABLE_PROJECT_ID_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.CLIENT_UID_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.CLUSTER_ID_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.INSTANCE_ID_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.METER_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.TABLE_ID_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.ZONE_ID_KEY;

import com.google.api.Distribution;
import com.google.api.Metric;
import com.google.api.MonitoredResource;
import com.google.cloud.opentelemetry.detection.AttributeKeys;
import com.google.cloud.opentelemetry.detection.DetectedPlatform;
import com.google.cloud.opentelemetry.detection.GCPPlatformDetector;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableSet;
import com.google.monitoring.v3.Point;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.TimeInterval;
import com.google.monitoring.v3.TimeSeries;
import com.google.monitoring.v3.TypedValue;
import com.google.protobuf.util.Timestamps;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoublePointData;
import io.opentelemetry.sdk.metrics.data.HistogramData;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.data.MetricDataType;
import io.opentelemetry.sdk.metrics.data.PointData;
import io.opentelemetry.sdk.metrics.data.SumData;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/** Utils to convert OpenTelemetry types to Google Cloud Monitoring types. */
class BigtableExporterUtils {

  private static final Logger logger = Logger.getLogger(BigtableExporterUtils.class.getName());

  private static final String BIGTABLE_RESOURCE_TYPE = "bigtable_client_raw";

  // These metric labels will be promoted to the bigtable_table monitored resource fields
  private static final Set<AttributeKey<String>> BIGTABLE_PROMOTED_RESOURCE_LABELS =
      ImmutableSet.of(
          BIGTABLE_PROJECT_ID_KEY, INSTANCE_ID_KEY, TABLE_ID_KEY, CLUSTER_ID_KEY, ZONE_ID_KEY);

  private BigtableExporterUtils() {}

  /**
   * In most cases this should look like java-${UUID}@${hostname}. The hostname will be retrieved
   * from the jvm name and fallback to the local hostname.
   */
  private static String defaultTaskValue = null;

  static final Supplier<String> DEFAULT_TABLE_VALUE =
      Suppliers.memoize(BigtableExporterUtils::computeDefaultTaskValue);

  private static String computeDefaultTaskValue() {
    if (defaultTaskValue != null) {
      return defaultTaskValue;
    }
    // Something like '<pid>@<hostname>'
    final String jvmName = ManagementFactory.getRuntimeMXBean().getName();
    // If jvm doesn't have the expected format, fallback to the local hostname
    if (jvmName.indexOf('@') < 1) {
      String hostname = "localhost";
      try {
        hostname = InetAddress.getLocalHost().getHostName();
      } catch (UnknownHostException e) {
        logger.log(Level.INFO, "Unable to get the hostname.", e);
      }
      // Generate a random number and use the same format "random_number@hostname".
      return "java-" + UUID.randomUUID() + "@" + hostname;
    }
    return "java-" + UUID.randomUUID() + jvmName;
  }

  static ProjectName getProjectName(PointData pointData) {
    return ProjectName.of(pointData.getAttributes().get(BIGTABLE_PROJECT_ID_KEY));
  }

  // Returns a list of timeseries by project name
  static Map<ProjectName, List<TimeSeries>> convertToBigtableTimeSeries(
      Collection<MetricData> collection, String taskId) {
    Map<ProjectName, List<TimeSeries>> allTimeSeries = new HashMap<>();

    for (MetricData metricData : collection) {
      if (!metricData.getInstrumentationScopeInfo().getName().equals(METER_NAME)) {
        // Filter out metric data for instruments that are not part of the bigtable builtin metrics
        continue;
      }

      for (PointData pd : metricData.getData().getPoints()) {
        ProjectName projectName = getProjectName(pd);
        List<TimeSeries> current =
            allTimeSeries.computeIfAbsent(projectName, ignored -> new ArrayList<>());
        current.add(convertPointToBigtableTimeSeries(metricData, pd, taskId));
        allTimeSeries.put(projectName, current);
      }
    }

    return allTimeSeries;
  }

  static List<TimeSeries> convertToApplicationResourceTimeSeries(
      Collection<MetricData> collection, String taskId, MonitoredResource applicationResource) {
    Preconditions.checkNotNull(
        applicationResource,
        "convert application metrics is called when the supported resource is not detected");
    List<TimeSeries> allTimeSeries = new ArrayList<>();
    for (MetricData metricData : collection) {
      if (!metricData.getInstrumentationScopeInfo().getName().equals(METER_NAME)) {
        // Filter out metric data for instruments that are not part of the bigtable builtin metrics
        continue;
      }
      metricData.getData().getPoints().stream()
          .map(
              pointData ->
                  convertPointToApplicationResourceTimeSeries(
                      metricData, pointData, taskId, applicationResource))
          .forEach(allTimeSeries::add);
    }
    return allTimeSeries;
  }

  @Nullable
  static MonitoredResource detectResourceSafe() {
    try {
      return detectResource();
    } catch (Exception e) {
      logger.log(
          Level.WARNING,
          "Failed to detect resource, will skip exporting application level metrics ",
          e);
      return null;
    }
  }

  @Nullable
  private static MonitoredResource detectResource() {
    GCPPlatformDetector detector = GCPPlatformDetector.DEFAULT_INSTANCE;
    DetectedPlatform detectedPlatform = detector.detectPlatform();
    MonitoredResource monitoredResource = null;
    try {
      switch (detectedPlatform.getSupportedPlatform()) {
        case GOOGLE_COMPUTE_ENGINE:
          monitoredResource =
              createGceMonitoredResource(
                  detectedPlatform.getProjectId(), detectedPlatform.getAttributes());
          break;
        case GOOGLE_KUBERNETES_ENGINE:
          monitoredResource =
              createGkeMonitoredResource(
                  detectedPlatform.getProjectId(), detectedPlatform.getAttributes());
          break;
      }
    } catch (IllegalStateException e) {
      logger.log(
          Level.WARNING,
          "Failed to create monitored resource for " + detectedPlatform.getSupportedPlatform(),
          e);
    }
    return monitoredResource;
  }

  private static MonitoredResource createGceMonitoredResource(
      String projectId, Map<String, String> attributes) {
    return MonitoredResource.newBuilder()
        .setType("gce_instance")
        .putLabels("project_id", projectId)
        .putLabels("instance_id", getAttribute(attributes, AttributeKeys.GCE_INSTANCE_ID))
        .putLabels("zone", getAttribute(attributes, AttributeKeys.GCE_AVAILABILITY_ZONE))
        .build();
  }

  private static MonitoredResource createGkeMonitoredResource(
      String projectId, Map<String, String> attributes) {
    return MonitoredResource.newBuilder()
        .setType("k8s_container")
        .putLabels("project_id", projectId)
        .putLabels("location", getAttribute(attributes, AttributeKeys.GKE_CLUSTER_LOCATION))
        .putLabels("cluster_name", getAttribute(attributes, AttributeKeys.GKE_CLUSTER_NAME))
        .putLabels("namespace_name", MoreObjects.firstNonNull(System.getenv("NAMESPACE"), ""))
        .putLabels("pod_name", MoreObjects.firstNonNull(System.getenv("HOSTNAME"), ""))
        .putLabels("container_name", MoreObjects.firstNonNull(System.getenv("CONTAINER_NAME"), ""))
        .build();
  }

  private static String getAttribute(Map<String, String> attributes, String key) {
    String value = attributes.get(key);
    if (value == null) {
      throw new IllegalStateException(
          "Required attribute " + key + " does not exist in the attributes map " + attributes);
    }
    return value;
  }

  private static TimeSeries convertPointToBigtableTimeSeries(
      MetricData metricData, PointData pointData, String taskId) {
    TimeSeries.Builder builder =
        TimeSeries.newBuilder()
            .setMetricKind(convertMetricKind(metricData))
            .setValueType(convertValueType(metricData.getType()));
    Metric.Builder metricBuilder = Metric.newBuilder().setType(metricData.getName());

    Attributes attributes = pointData.getAttributes();
    MonitoredResource.Builder monitoredResourceBuilder =
        MonitoredResource.newBuilder().setType(BIGTABLE_RESOURCE_TYPE);

    for (AttributeKey<?> key : attributes.asMap().keySet()) {
      if (BIGTABLE_PROMOTED_RESOURCE_LABELS.contains(key)) {
        monitoredResourceBuilder.putLabels(key.getKey(), String.valueOf(attributes.get(key)));
      } else {
        metricBuilder.putLabels(key.getKey(), String.valueOf(attributes.get(key)));
      }
    }

    builder.setResource(monitoredResourceBuilder.build());

    metricBuilder.putLabels(CLIENT_UID_KEY.getKey(), taskId);
    builder.setMetric(metricBuilder.build());

    TimeInterval timeInterval =
        TimeInterval.newBuilder()
            .setStartTime(Timestamps.fromNanos(pointData.getStartEpochNanos()))
            .setEndTime(Timestamps.fromNanos(pointData.getEpochNanos()))
            .build();

    builder.addPoints(createPoint(metricData.getType(), pointData, timeInterval));

    return builder.build();
  }

  private static TimeSeries convertPointToApplicationResourceTimeSeries(
      MetricData metricData,
      PointData pointData,
      String taskId,
      MonitoredResource applicationResource) {
    TimeSeries.Builder builder =
        TimeSeries.newBuilder()
            .setMetricKind(convertMetricKind(metricData))
            .setValueType(convertValueType(metricData.getType()))
            .setResource(applicationResource);

    Metric.Builder metricBuilder = Metric.newBuilder().setType(metricData.getName());

    Attributes attributes = pointData.getAttributes();
    for (AttributeKey<?> key : attributes.asMap().keySet()) {
      metricBuilder.putLabels(key.getKey(), String.valueOf(attributes.get(key)));
    }

    metricBuilder.putLabels(CLIENT_UID_KEY.getKey(), taskId);
    builder.setMetric(metricBuilder.build());

    TimeInterval timeInterval =
        TimeInterval.newBuilder()
            .setStartTime(Timestamps.fromNanos(pointData.getStartEpochNanos()))
            .setEndTime(Timestamps.fromNanos(pointData.getEpochNanos()))
            .build();

    builder.addPoints(createPoint(metricData.getType(), pointData, timeInterval));
    return builder.build();
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

  private static Point createPoint(
      MetricDataType type, PointData pointData, TimeInterval timeInterval) {
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
        logger.log(Level.WARNING, "unsupported metric type");
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
}
