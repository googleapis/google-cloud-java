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

import static com.google.cloud.spanner.XGoogSpannerRequestId.REQUEST_ID_HEADER_NAME;

import com.google.api.core.InternalApi;
import com.google.api.gax.tracing.OpenTelemetryMetricsRecorder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.View;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@InternalApi
public class BuiltInMetricsConstant {

  public static final String METER_NAME = "spanner.googleapis.com/internal/client";
  public static final String GAX_METER_NAME = OpenTelemetryMetricsRecorder.GAX_METER_NAME;
  static final String SPANNER_METER_NAME = "spanner-java";
  static final String GRPC_METER_NAME = "grpc-java";
  static final String GFE_LATENCIES_NAME = "gfe_latencies";
  static final String AFE_LATENCIES_NAME = "afe_latencies";
  static final String GFE_CONNECTIVITY_ERROR_NAME = "gfe_connectivity_error_count";
  static final String AFE_CONNECTIVITY_ERROR_NAME = "afe_connectivity_error_count";
  static final String OPERATION_LATENCIES_NAME = "operation_latencies";
  static final String ATTEMPT_LATENCIES_NAME = "attempt_latencies";
  static final String OPERATION_LATENCY_NAME = "operation_latency";
  static final String ATTEMPT_LATENCY_NAME = "attempt_latency";
  static final String OPERATION_COUNT_NAME = "operation_count";
  static final String ATTEMPT_COUNT_NAME = "attempt_count";

  public static final Set<String> SPANNER_METRICS =
      ImmutableSet.of(
              OPERATION_LATENCIES_NAME,
              ATTEMPT_LATENCIES_NAME,
              OPERATION_COUNT_NAME,
              ATTEMPT_COUNT_NAME,
              GFE_LATENCIES_NAME,
              AFE_LATENCIES_NAME,
              GFE_CONNECTIVITY_ERROR_NAME,
              AFE_CONNECTIVITY_ERROR_NAME)
          .stream()
          .map(m -> METER_NAME + '/' + m)
          .collect(Collectors.toSet());

  // The following attributes are optional and need to be enabled explicitly.
  public static final String GRPC_LB_BACKEND_SERVICE_ATTRIBUTE = "grpc.lb.backend_service";
  public static final String GRPC_LB_LOCALITY_ATTRIBUTE = "grpc.lb.locality";
  public static final String GRPC_DISCONNECT_ERROR_ATTRIBUTE = "grpc.disconnect_error";

  static final Set<String> GRPC_LB_RLS_ATTRIBUTES =
      ImmutableSet.of("grpc.lb.rls.data_plane_target", "grpc.lb.pick_result");
  static final Set<String> GRPC_CLIENT_ATTEMPT_STARTED_ATTRIBUTES =
      ImmutableSet.of("grpc.method", "grpc.target");
  static final Set<String> GRPC_SUBCHANNEL_DEFAULT_ATTRIBUTES =
      ImmutableSet.of("grpc.target", GRPC_LB_BACKEND_SERVICE_ATTRIBUTE, GRPC_LB_LOCALITY_ATTRIBUTE);
  static final Set<String> GRPC_SUBCHANNEL_DISCONNECTION_ATTRIBUTES =
      ImmutableSet.of(
          "grpc.target",
          GRPC_LB_BACKEND_SERVICE_ATTRIBUTE,
          GRPC_LB_LOCALITY_ATTRIBUTE,
          GRPC_DISCONNECT_ERROR_ATTRIBUTE);
  static final Set<String> GRPC_XDS_CLIENT_RESOURCE_UPDATE_ATTRIBUTES =
      ImmutableSet.of("grpc.xds.resource_type");

  // Additional gRPC attributes to enable.
  static final Map<String, Set<String>> GRPC_METRIC_ADDITIONAL_ATTRIBUTES =
      ImmutableMap.<String, Set<String>>builder()
          .put("grpc.client.attempt.started", GRPC_CLIENT_ATTEMPT_STARTED_ATTRIBUTES)
          .put("grpc.subchannel.open_connections", GRPC_SUBCHANNEL_DEFAULT_ATTRIBUTES)
          .put("grpc.subchannel.disconnections", GRPC_SUBCHANNEL_DISCONNECTION_ATTRIBUTES)
          .put("grpc.subchannel.connection_attempts_succeeded", GRPC_SUBCHANNEL_DEFAULT_ATTRIBUTES)
          .put("grpc.subchannel.connection_attempts_failed", GRPC_SUBCHANNEL_DEFAULT_ATTRIBUTES)
          .put("grpc.lb.rls.default_target_picks", GRPC_LB_RLS_ATTRIBUTES)
          .put("grpc.lb.rls.target_picks", GRPC_LB_RLS_ATTRIBUTES)
          .put(
              "grpc.xds_client.resource_updates_invalid",
              GRPC_XDS_CLIENT_RESOURCE_UPDATE_ATTRIBUTES)
          .put("grpc.xds_client.resource_updates_valid", GRPC_XDS_CLIENT_RESOURCE_UPDATE_ATTRIBUTES)
          .build();

  static final Collection<String> GRPC_METRICS_TO_ENABLE =
      ImmutableList.of(
          "grpc.client.attempt.started",
          "grpc.subchannel.open_connections",
          "grpc.subchannel.disconnections",
          "grpc.subchannel.connection_attempts_succeeded",
          "grpc.subchannel.connection_attempts_failed",
          "grpc.lb.rls.default_target_picks",
          "grpc.lb.rls.target_picks",
          "grpc.xds_client.server_failure",
          "grpc.xds_client.resource_updates_invalid",
          "grpc.xds_client.resource_updates_valid");

  public static final String SPANNER_RESOURCE_TYPE = "spanner_instance_client";

  public static final AttributeKey<String> PROJECT_ID_KEY = AttributeKey.stringKey("project_id");
  public static final AttributeKey<String> INSTANCE_ID_KEY = AttributeKey.stringKey("instance_id");
  public static final AttributeKey<String> LOCATION_ID_KEY = AttributeKey.stringKey("location");
  public static final AttributeKey<String> INSTANCE_CONFIG_ID_KEY =
      AttributeKey.stringKey("instance_config");
  public static final AttributeKey<String> CLIENT_HASH_KEY = AttributeKey.stringKey("client_hash");

  // These metric labels will be promoted to the spanner monitored resource fields
  public static final Set<AttributeKey<String>> SPANNER_PROMOTED_RESOURCE_LABELS =
      ImmutableSet.of(INSTANCE_ID_KEY);

  public static final AttributeKey<String> DATABASE_KEY = AttributeKey.stringKey("database");
  public static final AttributeKey<String> CLIENT_UID_KEY = AttributeKey.stringKey("client_uid");
  public static final AttributeKey<String> CLIENT_NAME_KEY = AttributeKey.stringKey("client_name");
  public static final AttributeKey<String> METHOD_KEY = AttributeKey.stringKey("method");
  public static final AttributeKey<String> STATUS_KEY = AttributeKey.stringKey("status");
  public static final AttributeKey<String> DIRECT_PATH_ENABLED_KEY =
      AttributeKey.stringKey("directpath_enabled");
  public static final AttributeKey<String> DIRECT_PATH_USED_KEY =
      AttributeKey.stringKey("directpath_used");
  public static final AttributeKey<String> REQUEST_ID_KEY =
      AttributeKey.stringKey(REQUEST_ID_HEADER_NAME);
  public static Set<String> ALLOWED_EXEMPLARS_ATTRIBUTES =
      new HashSet<>(Arrays.asList(REQUEST_ID_HEADER_NAME));

  // IP address prefixes allocated for DirectPath backends.
  public static final String DP_IPV6_PREFIX = "2001:4860:8040";
  public static final String DP_IPV4_PREFIX = "34.126";

  public static final Set<AttributeKey> COMMON_ATTRIBUTES =
      ImmutableSet.of(
          PROJECT_ID_KEY,
          INSTANCE_ID_KEY,
          LOCATION_ID_KEY,
          INSTANCE_CONFIG_ID_KEY,
          CLIENT_UID_KEY,
          CLIENT_HASH_KEY,
          METHOD_KEY,
          STATUS_KEY,
          DATABASE_KEY,
          CLIENT_NAME_KEY,
          DIRECT_PATH_ENABLED_KEY,
          DIRECT_PATH_USED_KEY);

  static List<Double> BUCKET_BOUNDARIES =
      ImmutableList.of(
          0.0, 0.5, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0,
          16.0, 17.0, 18.0, 19.0, 20.0, 25.0, 30.0, 40.0, 50.0, 65.0, 80.0, 100.0, 130.0, 160.0,
          200.0, 250.0, 300.0, 400.0, 500.0, 650.0, 800.0, 1000.0, 2000.0, 5000.0, 10000.0, 20000.0,
          50000.0, 100000.0, 200000.0, 400000.0, 800000.0, 1600000.0, 3200000.0);
  static Aggregation AGGREGATION_WITH_MILLIS_HISTOGRAM =
      Aggregation.explicitBucketHistogram(BUCKET_BOUNDARIES);

  static final Collection<String> GRPC_METRICS_ENABLED_BY_DEFAULT =
      ImmutableList.of(
          "grpc.client.attempt.sent_total_compressed_message_size",
          "grpc.client.attempt.rcvd_total_compressed_message_size",
          "grpc.client.attempt.duration",
          "grpc.client.call.duration");

  static Map<InstrumentSelector, View> getAllViews() {
    ImmutableMap.Builder<InstrumentSelector, View> views = ImmutableMap.builder();
    defineView(
        views,
        BuiltInMetricsConstant.GAX_METER_NAME,
        BuiltInMetricsConstant.OPERATION_LATENCY_NAME,
        BuiltInMetricsConstant.OPERATION_LATENCIES_NAME,
        BuiltInMetricsConstant.AGGREGATION_WITH_MILLIS_HISTOGRAM,
        InstrumentType.HISTOGRAM,
        "ms");
    defineView(
        views,
        BuiltInMetricsConstant.GAX_METER_NAME,
        BuiltInMetricsConstant.ATTEMPT_LATENCY_NAME,
        BuiltInMetricsConstant.ATTEMPT_LATENCIES_NAME,
        BuiltInMetricsConstant.AGGREGATION_WITH_MILLIS_HISTOGRAM,
        InstrumentType.HISTOGRAM,
        "ms");
    defineView(
        views,
        BuiltInMetricsConstant.GAX_METER_NAME,
        BuiltInMetricsConstant.OPERATION_COUNT_NAME,
        BuiltInMetricsConstant.OPERATION_COUNT_NAME,
        Aggregation.sum(),
        InstrumentType.COUNTER,
        "1");
    defineView(
        views,
        BuiltInMetricsConstant.GAX_METER_NAME,
        BuiltInMetricsConstant.ATTEMPT_COUNT_NAME,
        BuiltInMetricsConstant.ATTEMPT_COUNT_NAME,
        Aggregation.sum(),
        InstrumentType.COUNTER,
        "1");
    defineSpannerView(views);
    defineGRPCView(views);
    return views.build();
  }

  private static void defineView(
      ImmutableMap.Builder<InstrumentSelector, View> viewMap,
      String meterName,
      String metricName,
      String metricViewName,
      Aggregation aggregation,
      InstrumentType type,
      String unit) {
    InstrumentSelector selector =
        InstrumentSelector.builder()
            .setName(BuiltInMetricsConstant.METER_NAME + '/' + metricName)
            .setMeterName(meterName)
            .setType(type)
            .setUnit(unit)
            .build();
    Set<String> attributesFilter =
        BuiltInMetricsConstant.COMMON_ATTRIBUTES.stream()
            .map(AttributeKey::getKey)
            .collect(Collectors.toSet());
    View view =
        View.builder()
            .setName(BuiltInMetricsConstant.METER_NAME + '/' + metricViewName)
            .setAggregation(aggregation)
            .setAttributeFilter(attributesFilter)
            .build();
    viewMap.put(selector, view);
  }

  private static void defineSpannerView(ImmutableMap.Builder<InstrumentSelector, View> viewMap) {
    InstrumentSelector selector =
        InstrumentSelector.builder()
            .setMeterName(BuiltInMetricsConstant.SPANNER_METER_NAME)
            .build();
    Set<String> attributesFilter =
        BuiltInMetricsConstant.COMMON_ATTRIBUTES.stream()
            .map(AttributeKey::getKey)
            .collect(Collectors.toSet());
    View view = View.builder().setAttributeFilter(attributesFilter).build();
    viewMap.put(selector, view);
  }

  private static void defineGRPCView(ImmutableMap.Builder<InstrumentSelector, View> viewMap) {
    for (String metric : BuiltInMetricsConstant.GRPC_METRICS_TO_ENABLE) {
      InstrumentSelector selector =
          InstrumentSelector.builder()
              .setName(metric)
              .setMeterName(BuiltInMetricsConstant.GRPC_METER_NAME)
              .build();
      Set<String> attributesFilter =
          BuiltInMetricsConstant.COMMON_ATTRIBUTES.stream()
              .map(AttributeKey::getKey)
              .collect(Collectors.toSet());
      attributesFilter.addAll(
          GRPC_METRIC_ADDITIONAL_ATTRIBUTES.getOrDefault(metric, ImmutableSet.of()));

      View view =
          View.builder()
              .setName(BuiltInMetricsConstant.METER_NAME + '/' + metric.replace(".", "/"))
              .setAttributeFilter(attributesFilter)
              .build();
      viewMap.put(selector, view);
    }
  }
}
