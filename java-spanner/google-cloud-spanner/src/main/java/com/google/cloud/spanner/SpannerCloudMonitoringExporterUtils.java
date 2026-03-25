/*
 * Copyright 2024 Google LLC
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

import static com.google.api.MetricDescriptor.MetricKind.CUMULATIVE;
import static com.google.api.MetricDescriptor.MetricKind.GAUGE;
import static com.google.api.MetricDescriptor.MetricKind.UNRECOGNIZED;
import static com.google.api.MetricDescriptor.ValueType.DISTRIBUTION;
import static com.google.api.MetricDescriptor.ValueType.DOUBLE;
import static com.google.api.MetricDescriptor.ValueType.INT64;
import static com.google.cloud.spanner.BuiltInMetricsConstant.ALLOWED_EXEMPLARS_ATTRIBUTES;
import static com.google.cloud.spanner.BuiltInMetricsConstant.GAX_METER_NAME;
import static com.google.cloud.spanner.BuiltInMetricsConstant.GRPC_METER_NAME;
import static com.google.cloud.spanner.BuiltInMetricsConstant.PROJECT_ID_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.SPANNER_METER_NAME;
import static com.google.cloud.spanner.BuiltInMetricsConstant.SPANNER_PROMOTED_RESOURCE_LABELS;
import static com.google.cloud.spanner.BuiltInMetricsConstant.SPANNER_RESOURCE_TYPE;

import com.google.api.Distribution;
import com.google.api.Distribution.BucketOptions;
import com.google.api.Distribution.BucketOptions.Explicit;
import com.google.api.Metric;
import com.google.api.MetricDescriptor.MetricKind;
import com.google.api.MetricDescriptor.ValueType;
import com.google.api.MonitoredResource;
import com.google.monitoring.v3.DroppedLabels;
import com.google.monitoring.v3.Point;
import com.google.monitoring.v3.SpanContext;
import com.google.monitoring.v3.TimeInterval;
import com.google.monitoring.v3.TimeSeries;
import com.google.monitoring.v3.TypedValue;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.DoublePointData;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.data.HistogramData;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongExemplarData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.data.MetricDataType;
import io.opentelemetry.sdk.metrics.data.PointData;
import io.opentelemetry.sdk.metrics.data.SumData;
import io.opentelemetry.sdk.resources.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

class SpannerCloudMonitoringExporterUtils {

  private static final Logger logger =
      Logger.getLogger(SpannerCloudMonitoringExporterUtils.class.getName());

  private SpannerCloudMonitoringExporterUtils() {}

  static String getProjectId(Resource resource) {
    return resource.getAttributes().get(PROJECT_ID_KEY);
  }

  static List<TimeSeries> convertToSpannerTimeSeries(
      List<MetricData> collection, String projectId) {
    List<TimeSeries> allTimeSeries = new ArrayList<>();

    for (MetricData metricData : collection) {
      // Get metrics data from GAX library, GRPC library and Spanner library
      if (!(metricData.getInstrumentationScopeInfo().getName().equals(GAX_METER_NAME)
          || metricData.getInstrumentationScopeInfo().getName().equals(SPANNER_METER_NAME)
          || metricData.getInstrumentationScopeInfo().getName().equals(GRPC_METER_NAME))) {
        // Filter out metric data for instruments that are not part of the spanner metrics list
        continue;
      }

      // Create MonitoredResource Builder
      MonitoredResource.Builder monitoredResourceBuilder =
          MonitoredResource.newBuilder().setType(SPANNER_RESOURCE_TYPE);

      Attributes resourceAttributes = metricData.getResource().getAttributes();
      for (AttributeKey<?> key : resourceAttributes.asMap().keySet()) {
        monitoredResourceBuilder.putLabels(
            key.getKey(), String.valueOf(resourceAttributes.get(key)));
      }

      metricData.getData().getPoints().stream()
          .map(
              pointData ->
                  convertPointToSpannerTimeSeries(
                      metricData, pointData, monitoredResourceBuilder, projectId))
          .forEach(allTimeSeries::add);
    }
    return allTimeSeries;
  }

  private static TimeSeries convertPointToSpannerTimeSeries(
      MetricData metricData,
      PointData pointData,
      MonitoredResource.Builder monitoredResourceBuilder,
      String projectId) {
    MetricKind metricKind = convertMetricKind(metricData);
    TimeSeries.Builder builder =
        TimeSeries.newBuilder()
            .setMetricKind(metricKind)
            .setValueType(convertValueType(metricData.getType()));
    Metric.Builder metricBuilder = Metric.newBuilder().setType(metricData.getName());

    Attributes attributes = pointData.getAttributes();

    for (AttributeKey<?> key : attributes.asMap().keySet()) {
      if (SPANNER_PROMOTED_RESOURCE_LABELS.contains(key)) {
        monitoredResourceBuilder.putLabels(key.getKey(), String.valueOf(attributes.get(key)));
      } else {
        // Replace metric label names by converting "." to "_" since Cloud Monitoring does not
        // support labels containing "."
        metricBuilder.putLabels(
            key.getKey().replace(".", "_"), String.valueOf(attributes.get(key)));
      }
    }

    // Add common labels like "client_name" and "client_uid" for all the exported metrics.
    metricBuilder.putAllLabels(BuiltInMetricsProvider.INSTANCE.createClientAttributes());

    builder.setResource(monitoredResourceBuilder.build());
    builder.setMetric(metricBuilder.build());

    TimeInterval timeInterval =
        TimeInterval.newBuilder()
            .setStartTime(
                // For gauge metrics, the start and end time should be the same.
                metricKind == MetricKind.GAUGE
                    ? Timestamps.fromNanos(pointData.getEpochNanos())
                    : Timestamps.fromNanos(pointData.getStartEpochNanos()))
            .setEndTime(Timestamps.fromNanos(pointData.getEpochNanos()))
            .build();

    builder.addPoints(createPoint(metricData.getType(), pointData, timeInterval, projectId));

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
      MetricDataType type, PointData pointData, TimeInterval timeInterval, String projectId) {
    Point.Builder builder = Point.newBuilder().setInterval(timeInterval);
    switch (type) {
      case HISTOGRAM:
      case EXPONENTIAL_HISTOGRAM:
        return builder
            .setValue(
                TypedValue.newBuilder()
                    .setDistributionValue(
                        convertHistogramData((HistogramPointData) pointData, projectId))
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

  private static Distribution convertHistogramData(HistogramPointData pointData, String projectId) {
    return Distribution.newBuilder()
        .setCount(pointData.getCount())
        .setMean(pointData.getCount() == 0L ? 0.0D : pointData.getSum() / pointData.getCount())
        .setBucketOptions(
            BucketOptions.newBuilder()
                .setExplicitBuckets(Explicit.newBuilder().addAllBounds(pointData.getBoundaries())))
        .addAllBucketCounts(pointData.getCounts())
        .addAllExemplars(
            pointData.getExemplars().stream()
                .map(e -> mapExemplar(e, projectId))
                .collect(Collectors.toList()))
        .build();
  }

  private static Distribution.Exemplar mapExemplar(ExemplarData exemplar, String projectId) {
    double value = 0;
    if (exemplar instanceof DoubleExemplarData) {
      value = ((DoubleExemplarData) exemplar).getValue();
    } else if (exemplar instanceof LongExemplarData) {
      value = ((LongExemplarData) exemplar).getValue();
    }

    Distribution.Exemplar.Builder exemplarBuilder =
        Distribution.Exemplar.newBuilder()
            .setValue(value)
            .setTimestamp(mapTimestamp(exemplar.getEpochNanos()));
    if (exemplar.getSpanContext().isValid()) {
      exemplarBuilder.addAttachments(
          Any.pack(
              SpanContext.newBuilder()
                  .setSpanName(
                      makeSpanName(
                          projectId,
                          exemplar.getSpanContext().getTraceId(),
                          exemplar.getSpanContext().getSpanId()))
                  .build()));
    }
    if (!exemplar.getFilteredAttributes().isEmpty()) {
      exemplarBuilder.addAttachments(
          Any.pack(mapFilteredAttributes(exemplar.getFilteredAttributes())));
    }
    return exemplarBuilder.build();
  }

  static final long NANO_PER_SECOND = (long) 1e9;

  private static Timestamp mapTimestamp(long epochNanos) {
    return Timestamp.newBuilder()
        .setSeconds(epochNanos / NANO_PER_SECOND)
        .setNanos((int) (epochNanos % NANO_PER_SECOND))
        .build();
  }

  private static String makeSpanName(String projectId, String traceId, String spanId) {
    return String.format("projects/%s/traces/%s/spans/%s", projectId, traceId, spanId);
  }

  private static DroppedLabels mapFilteredAttributes(Attributes attributes) {
    DroppedLabels.Builder labels = DroppedLabels.newBuilder();
    attributes.forEach(
        (k, v) -> {
          String key = cleanAttributeKey(k.getKey());
          if (ALLOWED_EXEMPLARS_ATTRIBUTES.contains(key)) {
            labels.putLabel(key, v.toString());
          }
        });
    return labels.build();
  }

  private static String cleanAttributeKey(String key) {
    // . is commonly used in OTel but disallowed in GCM label names,
    // https://cloud.google.com/monitoring/api/ref_v3/rest/v3/LabelDescriptor#:~:text=Matches%20the%20following%20regular%20expression%3A
    return key.replace('.', '_');
  }
}
