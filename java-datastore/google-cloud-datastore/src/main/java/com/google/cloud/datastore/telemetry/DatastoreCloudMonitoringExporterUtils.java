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

import static com.google.api.MetricDescriptor.MetricKind.CUMULATIVE;
import static com.google.api.MetricDescriptor.MetricKind.GAUGE;
import static com.google.api.MetricDescriptor.MetricKind.UNRECOGNIZED;
import static com.google.api.MetricDescriptor.ValueType.DISTRIBUTION;
import static com.google.api.MetricDescriptor.ValueType.DOUBLE;
import static com.google.api.MetricDescriptor.ValueType.INT64;
import static com.google.cloud.datastore.telemetry.TelemetryConstants.DATASTORE_RESOURCE_TYPE;

import com.google.api.Distribution;
import com.google.api.Distribution.BucketOptions;
import com.google.api.Distribution.BucketOptions.Explicit;
import com.google.api.Metric;
import com.google.api.MetricDescriptor.MetricKind;
import com.google.api.MetricDescriptor.ValueType;
import com.google.api.MonitoredResource;
import com.google.monitoring.v3.Point;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class for converting OpenTelemetry metrics to Google Cloud Monitoring format.
 *
 * <p>This class contains the logic to map OpenTelemetry {@link MetricData} and {@link PointData} to
 * Cloud Monitoring {@link TimeSeries}, including resource label mapping and attribute conversion.
 *
 * <p>The implementation in this file is inspired from the original work done in the Spanner client
 * library (SpannerCloudMonitoringExporterUtils) to export metrics. The logic has been adapted for
 * Datastore's use case.
 */
class DatastoreCloudMonitoringExporterUtils {

  private static final Logger logger =
      Logger.getLogger(DatastoreCloudMonitoringExporterUtils.class.getName());

  private DatastoreCloudMonitoringExporterUtils() {}

  /**
   * Converts a list of {@link MetricData} to Cloud Monitoring {@link TimeSeries}.
   *
   * @param collection the collection of metrics to convert.
   * @param clientAttributes common client labels (e.g. {@code client_name}, {@code client_uid}) to
   *     attach to every metric data point.
   * @return a list of converted {@link TimeSeries}.
   */
  static List<TimeSeries> convertToDatastoreTimeSeries(
      List<MetricData> collection, Map<String, String> clientAttributes) {
    List<TimeSeries> allTimeSeries = new ArrayList<>();

    // Metrics should already been filtered for Gax and Datastore related ones
    for (MetricData metricData : collection) {
      // TODO(b/405457573): The monitored resource is currently written to `global` because the
      // Firestore namespace in Cloud Monitoring has not been deployed yet. Once the namespace
      // is available, database_id and location labels should be added here using
      // RESOURCE_LABEL_DATABASE_ID and RESOURCE_LABEL_LOCATION respectively.

      // Map OTel resource attributes to the specific monitored resource labels.
      MonitoredResource.Builder monitoredResourceBuilder =
          MonitoredResource.newBuilder().setType(DATASTORE_RESOURCE_TYPE);

      Attributes resourceAttributes = metricData.getResource().getAttributes();
      String resourceProjectId = resourceAttributes.get(TelemetryConstants.PROJECT_ID_KEY);
      //      String resourceDatabaseId =
      // resourceAttributes.get(TelemetryConstants.DATABASE_ID_KEY);
      //      String resourceLocation = resourceAttributes.get(TelemetryConstants.LOCATION_ID_KEY);

      if (resourceProjectId != null) {
        monitoredResourceBuilder.putLabels(
            TelemetryConstants.RESOURCE_LABEL_PROJECT_ID, resourceProjectId);
      }

      // Convert each point in the metric data to a TimeSeries.
      metricData.getData().getPoints().stream()
          .map(
              pointData ->
                  convertPointToDatastoreTimeSeries(
                      metricData, pointData, monitoredResourceBuilder, clientAttributes))
          .forEach(allTimeSeries::add);
    }
    return allTimeSeries;
  }

  /**
   * Converts an individual {@link PointData} to a {@link TimeSeries}.
   *
   * <p>{@code clientAttributes} (e.g. {@code client_name}, {@code client_uid}) are injected here
   * rather than being looked up from a singleton so that this method is testable in isolation. The
   * caller ({@link DatastoreCloudMonitoringExporter}) is responsible for supplying them from {@link
   * BuiltInDatastoreMetricsProvider#buildClientAttributes()}.
   */
  private static TimeSeries convertPointToDatastoreTimeSeries(
      MetricData metricData,
      PointData pointData,
      MonitoredResource.Builder monitoredResourceBuilder,
      Map<String, String> clientAttributes) {
    MetricKind metricKind = convertMetricKind(metricData);
    TimeSeries.Builder builder =
        TimeSeries.newBuilder()
            .setMetricKind(metricKind)
            .setValueType(convertValueType(metricData.getType()));
    Metric.Builder metricBuilder = Metric.newBuilder().setType(metricData.getName());

    Attributes attributes = pointData.getAttributes();

    // Convert attribute keys by replacing "." with "_" for Cloud Monitoring compatibility.
    for (AttributeKey<?> key : attributes.asMap().keySet()) {
      metricBuilder.putLabels(key.getKey().replace(".", "_"), String.valueOf(attributes.get(key)));
    }

    // Attach common client attributes (service, client_uid) to each metric.
    clientAttributes.forEach(metricBuilder::putLabels);

    builder.setResource(monitoredResourceBuilder.build());
    builder.setMetric(metricBuilder.build());

    // Define the time interval for the metric point.
    TimeInterval timeInterval =
        TimeInterval.newBuilder()
            .setStartTime(
                // For GAUGE metrics, start and end time are identical.
                metricKind == MetricKind.GAUGE
                    ? Timestamps.fromNanos(pointData.getEpochNanos())
                    : Timestamps.fromNanos(pointData.getStartEpochNanos()))
            .setEndTime(Timestamps.fromNanos(pointData.getEpochNanos()))
            .build();

    builder.addPoints(createPoint(metricData.getType(), pointData, timeInterval));

    return builder.build();
  }

  /** Maps OpenTelemetry metric type to Cloud Monitoring {@link MetricKind}. */
  private static MetricKind convertMetricKind(MetricData metricData) {
    switch (metricData.getType()) {
      case HISTOGRAM:
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

  /**
   * Returns {@link com.google.api.MetricDescriptor.MetricKind#CUMULATIVE} for cumulative
   * histograms, or {@link com.google.api.MetricDescriptor.MetricKind#UNRECOGNIZED} for delta
   * histograms. Cloud Monitoring only accepts cumulative histograms; delta histograms from
   * short-lived OTel SDK instances would produce incomplete data and are intentionally dropped.
   */
  private static MetricKind convertHistogramType(HistogramData histogramData) {
    if (histogramData.getAggregationTemporality() == AggregationTemporality.CUMULATIVE) {
      return CUMULATIVE;
    }
    return UNRECOGNIZED;
  }

  /**
   * Maps an OTel {@link SumData} to a Cloud Monitoring {@link MetricKind}.
   *
   * <p>Non-monotonic sums (values that can decrease) are mapped to {@code GAUGE} because Cloud
   * Monitoring {@code CUMULATIVE} metrics must be strictly monotonically increasing. Monotonic
   * cumulative sums map to {@code CUMULATIVE}; delta sums are not supported and return {@code
   * UNRECOGNIZED}.
   */
  private static MetricKind convertSumDataType(SumData<?> sum) {
    // Non-monotonic sums are treated as GAUGE.
    if (!sum.isMonotonic()) {
      return GAUGE;
    }
    if (sum.getAggregationTemporality() == AggregationTemporality.CUMULATIVE) {
      return CUMULATIVE;
    }
    return UNRECOGNIZED;
  }

  /** Maps OpenTelemetry metric data type to Cloud Monitoring {@link ValueType}. */
  private static ValueType convertValueType(MetricDataType metricDataType) {
    switch (metricDataType) {
      case LONG_GAUGE:
      case LONG_SUM:
        return INT64;
      case DOUBLE_GAUGE:
      case DOUBLE_SUM:
        return DOUBLE;
      case HISTOGRAM:
        return DISTRIBUTION;
      default:
        return ValueType.UNRECOGNIZED;
    }
  }

  /** Creates a Cloud Monitoring {@link Point} from OpenTelemetry {@link PointData}. */
  private static Point createPoint(
      MetricDataType type, PointData pointData, TimeInterval timeInterval) {
    Point.Builder builder = Point.newBuilder().setInterval(timeInterval);
    switch (type) {
      case HISTOGRAM:
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

  /** Converts OpenTelemetry histogram data to Cloud Monitoring {@link Distribution}. */
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
