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
package com.google.cloud.bigquery.storage.v1;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Enables export of metrics to OpenTelemetry. Since it keeps track of whether metrics are
 * enabled/disabled, it simplifies calling code by removing the need for tedious if clauses to check
 * whether metrics are enabled/disabled. Also, GlobalOpenTelemetry.get() should only be called after
 * client application has already installed the necessary meter provider.
 */
public class TelemetryMetrics {
  private static final Logger log = Logger.getLogger(TelemetryMetrics.class.getName());

  private final ConnectionWorker connectionWorker;
  private final boolean enableMetrics;

  private Meter writeMeter;

  private static final class OpenTelemetryMetrics {
    private LongCounter instrumentAckedRequestCount;
    private LongCounter instrumentAckedRequestSize;
    private LongCounter instrumentAckedRequestRows;
    private LongHistogram instrumentNetworkResponseLatency;
    private LongCounter instrumentConnectionStartCount;
    private LongCounter instrumentConnectionEndCount;
  }

  private OpenTelemetryMetrics openTelemetryMetrics = new OpenTelemetryMetrics();
  private static final List<Long> METRICS_MILLISECONDS_LATENCY_BUCKETS =
      ImmutableList.of(
          0L, 17L, 38L, 86L, 195L, 438L, 985L, 2217L, 4988L, 11223L, 25251L, 56815L, 127834L,
          287627L, 647160L);
  static AttributeKey<String> telemetryKeyTableId = AttributeKey.stringKey("table_id");
  static AttributeKey<String> telemetryKeyWriterId = AttributeKey.stringKey("writer_id");
  private static String dataflowPrefix = "dataflow:";
  static List<AttributeKey<String>> telemetryKeysTraceId =
      new ArrayList<AttributeKey<String>>() {
        {
          add(AttributeKey.stringKey("trace_field_1"));
          add(AttributeKey.stringKey("trace_field_2"));
          add(AttributeKey.stringKey("trace_field_3"));
        }
      };
  static AttributeKey<String> telemetryKeyErrorCode = AttributeKey.stringKey("error_code");
  static AttributeKey<String> telemetryKeyIsRetry = AttributeKey.stringKey("is_retry");
  private Attributes telemetryAttributes;

  private void setTraceIdAttributesPart(
      AttributesBuilder builder,
      String[] traceIdParts,
      int indexPartsToCheck,
      int indexTelemetryKeysToUse) {
    if ((indexPartsToCheck < traceIdParts.length) && !traceIdParts[indexPartsToCheck].isEmpty()) {
      builder.put(
          telemetryKeysTraceId.get(indexTelemetryKeysToUse), traceIdParts[indexPartsToCheck]);
    }
  }

  private void setTraceIdAttributes(AttributesBuilder builder, String traceId) {
    if ((traceId != null) && !traceId.isEmpty()) {
      int indexDataflow = traceId.toLowerCase().indexOf(dataflowPrefix);
      if (indexDataflow >= 0) {
        String[] traceIdParts =
            traceId.substring(indexDataflow + dataflowPrefix.length()).split(":", 8);
        setTraceIdAttributesPart(builder, traceIdParts, 0, 0);
        setTraceIdAttributesPart(builder, traceIdParts, 1, 1);
        setTraceIdAttributesPart(builder, traceIdParts, 2, 2);
      }
    }
  }

  // Specify common attributes for all metrics.
  // For example, table name and writer id.
  // Metrics dashboards can be filtered on available attributes.
  private Attributes buildOpenTelemetryAttributes(
      String tableName, String writerId, String traceId) {
    AttributesBuilder builder = Attributes.builder();
    if (!tableName.isEmpty()) {
      builder.put(telemetryKeyTableId, tableName);
    }
    builder.put(telemetryKeyWriterId, writerId);
    setTraceIdAttributes(builder, traceId);
    return builder.build();
  }

  // Build new attributes augmented with an error code string.
  private Attributes augmentAttributesWithErrorCode(Attributes attributes, String errorCode) {
    AttributesBuilder builder = attributes.toBuilder();
    if ((errorCode != null) && !errorCode.isEmpty()) {
      builder.put(telemetryKeyErrorCode, errorCode);
    }
    return builder.build();
  }

  // Build new attributes augmented with a flag indicating this was a retry.
  private Attributes augmentAttributesWithRetry(Attributes attributes) {
    AttributesBuilder builder = attributes.toBuilder();
    builder.put(telemetryKeyIsRetry, "1");
    return builder.build();
  }

  @VisibleForTesting
  Attributes getTelemetryAttributes() {
    return telemetryAttributes;
  }

  private void registerOpenTelemetryMetrics(ConnectionWorker connectionWorker) {
    MeterProvider meterProvider = Singletons.getOpenTelemetry().getMeterProvider();
    writeMeter =
        meterProvider
            .meterBuilder("com.google.cloud.bigquery.storage.v1.write")
            .setInstrumentationVersion(
                ConnectionWorker.class.getPackage().getImplementationVersion())
            .build();
    openTelemetryMetrics.instrumentAckedRequestCount =
        writeMeter
            .counterBuilder("append_requests_acked")
            .setDescription("Counts number of requests acked by the server")
            .build();
    openTelemetryMetrics.instrumentAckedRequestSize =
        writeMeter
            .counterBuilder("append_request_bytes_acked")
            .setDescription("Counts byte size of requests acked by the server")
            .build();
    openTelemetryMetrics.instrumentAckedRequestRows =
        writeMeter
            .counterBuilder("append_rows_acked")
            .setDescription("Counts number of request rows acked by the server")
            .build();
    writeMeter
        .gaugeBuilder("active_connection_count")
        .ofLongs()
        .setDescription("Reports number of active connections")
        .buildWithCallback(
            measurement -> {
              int count = connectionWorker.hasActiveConnection() ? 1 : 0;
              measurement.record(count, getTelemetryAttributes());
            });
    writeMeter
        .gaugeBuilder("inflight_queue_length")
        .ofLongs()
        .setDescription(
            "Reports length of inflight queue. This queue contains sent append requests waiting for response from the server.")
        .buildWithCallback(
            measurement -> {
              int length = connectionWorker.getInflightRequestQueueLength();
              measurement.record(length, getTelemetryAttributes());
            });
    openTelemetryMetrics.instrumentNetworkResponseLatency =
        writeMeter
            .histogramBuilder("network_response_latency")
            .ofLongs()
            .setDescription(
                "Reports time taken in milliseconds for a response to arrive once a message has been sent over the network.")
            .setExplicitBucketBoundariesAdvice(METRICS_MILLISECONDS_LATENCY_BUCKETS)
            .build();
    openTelemetryMetrics.instrumentConnectionStartCount =
        writeMeter
            .counterBuilder("connection_start_count")
            .setDescription(
                "Counts number of connection attempts made, regardless of whether these are initial or retry.")
            .build();
    openTelemetryMetrics.instrumentConnectionEndCount =
        writeMeter
            .counterBuilder("connection_end_count")
            .setDescription("Counts number of connection end events.")
            .build();
  }

  TelemetryMetrics(
      ConnectionWorker connectionWorker,
      boolean enableMetrics,
      String tableName,
      String writerId,
      String traceId) {
    this.connectionWorker = connectionWorker;
    this.enableMetrics = enableMetrics;
    if (enableMetrics) {
      this.telemetryAttributes = buildOpenTelemetryAttributes(tableName, writerId, traceId);
      registerOpenTelemetryMetrics(connectionWorker);
    }
  }

  // Refresh the table name attribute when multiplexing switches between tables.
  public void refreshOpenTelemetryTableNameAttributes(String tableName) {
    if (enableMetrics) {
      if (!tableName.isEmpty()
          && !tableName.equals(getTelemetryAttributes().get(telemetryKeyTableId))) {
        AttributesBuilder builder = getTelemetryAttributes().toBuilder();
        builder.put(telemetryKeyTableId, tableName);
        this.telemetryAttributes = builder.build();
      }
    }
  }

  public void recordConnectionStart() {
    if (enableMetrics) {
      openTelemetryMetrics.instrumentConnectionStartCount.add(1, getTelemetryAttributes());
    }
  }

  public void recordConnectionStartWithRetry() {
    if (enableMetrics) {
      openTelemetryMetrics.instrumentConnectionStartCount.add(
          1, augmentAttributesWithRetry(getTelemetryAttributes()));
    }
  }

  public void recordConnectionEnd(String errorCode) {
    if (enableMetrics) {
      openTelemetryMetrics.instrumentConnectionEndCount.add(
          1, augmentAttributesWithErrorCode(getTelemetryAttributes(), errorCode));
    }
  }

  public void recordNetworkLatency(Duration latency) {
    if (enableMetrics) {
      openTelemetryMetrics.instrumentNetworkResponseLatency.record(
          latency.toMillis(), getTelemetryAttributes());
    }
  }

  public void recordResponse(long messageSize, long rowCount, String errorCode, boolean isRetry) {
    if (enableMetrics) {
      Attributes augmentedTelemetryAttributes =
          augmentAttributesWithErrorCode(getTelemetryAttributes(), errorCode);
      if (isRetry) {
        augmentedTelemetryAttributes = augmentAttributesWithRetry(augmentedTelemetryAttributes);
      }
      openTelemetryMetrics.instrumentAckedRequestCount.add(1, augmentedTelemetryAttributes);
      openTelemetryMetrics.instrumentAckedRequestSize.add(
          messageSize, augmentedTelemetryAttributes);
      openTelemetryMetrics.instrumentAckedRequestRows.add(rowCount, augmentedTelemetryAttributes);
    }
  }
}
