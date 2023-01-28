/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.grpc;

class GcpMetricsConstants {
  public static String POOL_INDEX_LABEL = "pool_index";
  public static String POOL_INDEX_DESC = "gRPC GCP channel pool index.";
  public static String RESULT_LABEL = "result";
  public static String RESULT_DESC = "Outcome.";
  public static String RESULT_SUCCESS = "SUCCESS";
  public static String RESULT_ERROR = "ERROR";
  public static String ENDPOINT_LABEL = "endpoint";
  public static String ENDPOINT_LABEL_DESC = "gRPC endpoint (addr:port).";
  public static String STATUS_LABEL = "status";
  public static String STATUS_LABEL_DESC = "Endpoint status.";
  public static String STATUS_AVAILABLE = "AVAILABLE";
  public static String STATUS_UNAVAILABLE = "UNAVAILABLE";
  public static String ME_NAME_LABEL = "me_name";
  public static String ME_NAME_LABEL_DESC = "Multi-endpoint name.";
  public static String SWITCH_TYPE_LABEL = "switch_type";
  public static String SWITCH_TYPE_LABEL_DESC = "Switch type (fallback/recover/replace).";
  public static String TYPE_FALLBACK = "FALLBACK";
  public static String TYPE_RECOVER = "RECOVER";
  public static String TYPE_REPLACE = "REPLACE";

  // Unit to represent count.
  static final String COUNT = "1";
  static final String MICROSECOND = "us";
  static final String MILLISECOND = "ms";

  public static String METRIC_MAX_CHANNELS = "max_channels";
  public static String METRIC_MIN_READY_CHANNELS = "min_ready_channels";
  public static String METRIC_MAX_READY_CHANNELS = "max_ready_channels";
  public static String METRIC_MAX_ALLOWED_CHANNELS = "max_allowed_channels";
  public static String METRIC_NUM_CHANNEL_DISCONNECT = "num_channel_disconnect";
  public static String METRIC_NUM_CHANNEL_CONNECT = "num_channel_connect";
  public static String METRIC_MIN_CHANNEL_READINESS_TIME = "min_channel_readiness_time";
  public static String METRIC_AVG_CHANNEL_READINESS_TIME = "avg_channel_readiness_time";
  public static String METRIC_MAX_CHANNEL_READINESS_TIME = "max_channel_readiness_time";
  public static String METRIC_MIN_ACTIVE_STREAMS = "min_active_streams_per_channel";
  public static String METRIC_MAX_ACTIVE_STREAMS = "max_active_streams_per_channel";
  public static String METRIC_MIN_TOTAL_ACTIVE_STREAMS = "min_total_active_streams";
  public static String METRIC_MAX_TOTAL_ACTIVE_STREAMS = "max_total_active_streams";
  public static String METRIC_MIN_AFFINITY = "min_affinity_per_channel";
  public static String METRIC_MAX_AFFINITY = "max_affinity_per_channel";
  public static String METRIC_NUM_AFFINITY = "num_affinity";
  public static String METRIC_MIN_CALLS = "min_calls_per_channel";
  public static String METRIC_MAX_CALLS = "max_calls_per_channel";
  public static String METRIC_NUM_CALLS_COMPLETED = "num_calls_completed";
  public static String METRIC_NUM_FALLBACKS = "num_fallbacks";
  public static String METRIC_NUM_UNRESPONSIVE_DETECTIONS = "num_unresponsive_detections";
  public static String METRIC_MIN_UNRESPONSIVE_DETECTION_TIME = "min_unresponsive_detection_time";
  public static String METRIC_MAX_UNRESPONSIVE_DETECTION_TIME = "max_unresponsive_detection_time";
  public static String METRIC_MIN_UNRESPONSIVE_DROPPED_CALLS = "min_unresponsive_dropped_calls";
  public static String METRIC_MAX_UNRESPONSIVE_DROPPED_CALLS = "max_unresponsive_dropped_calls";
  public static String METRIC_ENDPOINT_STATE = "endpoint_state";
  public static String METRIC_ENDPOINT_SWITCH = "endpoint_switch";
  public static String METRIC_CURRENT_ENDPOINT = "current_endpoint";
}
