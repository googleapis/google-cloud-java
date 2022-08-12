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

import static io.opencensus.stats.Measure.MeasureLong;

import io.opencensus.tags.TagKey;

/** Built-in metrics that will be readable under bigtable.googleapis.com/client namespace */
class BuiltinMeasureConstants {
  // Monitored resource TagKeys
  static final TagKey PROJECT_ID = TagKey.create("project_id");
  static final TagKey INSTANCE_ID = TagKey.create("instance");
  static final TagKey CLUSTER = TagKey.create("cluster");
  static final TagKey TABLE = TagKey.create("table");
  static final TagKey ZONE = TagKey.create("zone");
  static final TagKey CLIENT_UID = TagKey.create("client_uid");

  // Metrics TagKeys
  static final TagKey APP_PROFILE = TagKey.create("app_profile");
  static final TagKey METHOD = TagKey.create("method");
  static final TagKey STREAMING = TagKey.create("streaming");
  static final TagKey STATUS = TagKey.create("status");
  static final TagKey CLIENT_NAME = TagKey.create("client_name");

  // Units
  private static final String COUNT = "1";
  private static final String MILLISECOND = "ms";

  // Measurements
  static final MeasureLong OPERATION_LATENCIES =
      MeasureLong.create(
          "bigtable.googleapis.com/internal/client/operation_latencies",
          "Total time until final operation success or failure, including retries and backoff.",
          MILLISECOND);

  static final MeasureLong ATTEMPT_LATENCIES =
      MeasureLong.create(
          "bigtable.googleapis.com/internal/client/attempt_latencies",
          "Client observed latency per RPC attempt.",
          MILLISECOND);

  static final MeasureLong RETRY_COUNT =
      MeasureLong.create(
          "bigtable.googleapis.com/internal/client/retry_count",
          "The number of additional RPCs sent after the initial attempt.",
          COUNT);

  static final MeasureLong FIRST_RESPONSE_LATENCIES =
      MeasureLong.create(
          "bigtable.googleapis.com/internal/client/first_response_latencies",
          "Latency from operation start until the response headers were received. The publishing of the measurement will be delayed until the attempt response has been received.",
          MILLISECOND);

  static final MeasureLong SERVER_LATENCIES =
      MeasureLong.create(
          "bigtable.googleapis.com/internal/client/server_latencies",
          "The latency measured from the moment that the RPC entered the Google data center until the RPC was completed.",
          MILLISECOND);

  static final MeasureLong CONNECTIVITY_ERROR_COUNT =
      MeasureLong.create(
          "bigtable.googleapis.com/internal/client/connectivity_error_count",
          "Number of requests that failed to reach the Google datacenter. (Requests without google response headers).",
          COUNT);

  static final MeasureLong APPLICATION_LATENCIES =
      MeasureLong.create(
          "bigtable.googleapis.com/internal/client/application_latencies",
          "The latency of the client application consuming available response data.",
          MILLISECOND);

  static final MeasureLong THROTTLING_LATENCIES =
      MeasureLong.create(
          "bigtable.googleapis.com/internal/client/throttling_latencies",
          "The artificial latency introduced by the client to limit the number of outstanding requests. The publishing of the measurement will be delayed until the attempt trailers have been received.",
          MILLISECOND);
}
