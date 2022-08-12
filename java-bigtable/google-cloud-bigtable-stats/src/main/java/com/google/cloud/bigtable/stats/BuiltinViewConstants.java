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

import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.APPLICATION_LATENCIES;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.APP_PROFILE;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.ATTEMPT_LATENCIES;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.CLIENT_NAME;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.CLUSTER;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.CONNECTIVITY_ERROR_COUNT;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.FIRST_RESPONSE_LATENCIES;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.INSTANCE_ID;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.METHOD;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.OPERATION_LATENCIES;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.PROJECT_ID;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.RETRY_COUNT;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.SERVER_LATENCIES;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.STATUS;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.STREAMING;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.TABLE;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.THROTTLING_LATENCIES;
import static com.google.cloud.bigtable.stats.BuiltinMeasureConstants.ZONE;
import static io.opencensus.stats.Aggregation.Distribution;
import static io.opencensus.stats.Aggregation.Sum;

import com.google.common.collect.ImmutableList;
import io.opencensus.stats.Aggregation;
import io.opencensus.stats.BucketBoundaries;
import io.opencensus.stats.View;

/** Create built-in metrics views under bigtable.googleapis.com/internal/client namespace */
class BuiltinViewConstants {
  private static final Aggregation AGGREGATION_WITH_MILLIS_HISTOGRAM =
      Distribution.create(
          BucketBoundaries.create(
              ImmutableList.of(
                  0.0, 0.01, 0.05, 0.1, 0.3, 0.6, 0.8, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 8.0, 10.0,
                  13.0, 16.0, 20.0, 25.0, 30.0, 40.0, 50.0, 65.0, 80.0, 100.0, 130.0, 160.0, 200.0,
                  250.0, 300.0, 400.0, 500.0, 650.0, 800.0, 1000.0, 2000.0, 5000.0, 10000.0,
                  20000.0, 50000.0, 100000.0)));

  private static final Aggregation AGGREGATION_RETRY_COUNT =
      Distribution.create(
          BucketBoundaries.create(
              ImmutableList.of(
                  1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 15.0, 20.0, 30.0, 40.0, 50.0,
                  100.0)));

  private static final Aggregation AGGREGATION_COUNT = Sum.create();

  static final View OPERATION_LATENCIES_VIEW =
      View.create(
          View.Name.create("bigtable.googleapis.com/internal/client/operation_latencies"),
          "Total time until final operation success or failure, including retries and backoff.",
          OPERATION_LATENCIES,
          AGGREGATION_WITH_MILLIS_HISTOGRAM,
          ImmutableList.of(
              PROJECT_ID,
              INSTANCE_ID,
              APP_PROFILE,
              METHOD,
              STREAMING,
              STATUS,
              CLIENT_NAME,
              CLUSTER,
              ZONE,
              TABLE));

  static final View ATTEMPT_LATENCIES_VIEW =
      View.create(
          View.Name.create("bigtable.googleapis.com/internal/client/attempt_latencies"),
          "Client observed latency per RPC attempt.",
          ATTEMPT_LATENCIES,
          AGGREGATION_WITH_MILLIS_HISTOGRAM,
          ImmutableList.of(
              PROJECT_ID,
              INSTANCE_ID,
              APP_PROFILE,
              METHOD,
              STREAMING,
              STATUS,
              CLIENT_NAME,
              CLUSTER,
              ZONE,
              TABLE));

  static final View RETRY_COUNT_VIEW =
      View.create(
          View.Name.create("bigtable.googleapis.com/internal/client/retry_count"),
          "The number of additional RPCs sent after the initial attempt.",
          RETRY_COUNT,
          AGGREGATION_COUNT,
          ImmutableList.of(
              PROJECT_ID,
              INSTANCE_ID,
              APP_PROFILE,
              METHOD,
              STATUS,
              CLIENT_NAME,
              CLUSTER,
              ZONE,
              TABLE));

  static final View FIRST_RESPONSE_LATENCIES_VIEW =
      View.create(
          View.Name.create("bigtable.googleapis.com/internal/client/first_response_latencies"),
          "Latency from operation start until the response headers were received. The publishing of the measurement will be delayed until the attempt response has been received.",
          FIRST_RESPONSE_LATENCIES,
          AGGREGATION_WITH_MILLIS_HISTOGRAM,
          ImmutableList.of(
              PROJECT_ID,
              INSTANCE_ID,
              APP_PROFILE,
              METHOD,
              STATUS,
              CLIENT_NAME,
              CLUSTER,
              ZONE,
              TABLE));

  static final View SERVER_LATENCIES_VIEW =
      View.create(
          View.Name.create("bigtable.googleapis.com/internal/client/server_latencies"),
          "The latency measured from the moment that the RPC entered the Google data center until the RPC was completed.",
          SERVER_LATENCIES,
          AGGREGATION_WITH_MILLIS_HISTOGRAM,
          ImmutableList.of(
              PROJECT_ID,
              INSTANCE_ID,
              APP_PROFILE,
              METHOD,
              STATUS,
              STREAMING,
              CLIENT_NAME,
              CLUSTER,
              ZONE,
              TABLE));

  static final View CONNECTIVITY_ERROR_COUNT_VIEW =
      View.create(
          View.Name.create("bigtable.googleapis.com/internal/client/connectivity_error_count"),
          "Number of requests that failed to reach the Google datacenter. (Requests without google response headers).",
          CONNECTIVITY_ERROR_COUNT,
          AGGREGATION_COUNT,
          ImmutableList.of(
              PROJECT_ID,
              INSTANCE_ID,
              APP_PROFILE,
              METHOD,
              STATUS,
              CLIENT_NAME,
              CLUSTER,
              ZONE,
              TABLE));

  static final View APPLICATION_LATENCIES_VIEW =
      View.create(
          View.Name.create("bigtable.googleapis.com/internal/client/application_latencies"),
          "The latency of the client application consuming available response data.",
          APPLICATION_LATENCIES,
          AGGREGATION_WITH_MILLIS_HISTOGRAM,
          ImmutableList.of(
              PROJECT_ID, INSTANCE_ID, APP_PROFILE, METHOD, CLIENT_NAME, CLUSTER, ZONE, TABLE));

  static final View THROTTLING_LATENCIES_VIEW =
      View.create(
          View.Name.create("bigtable.googleapis.com/internal/client/throttling_latencies"),
          "The artificial latency introduced by the client to limit the number of outstanding requests. The publishing of the measurement will be delayed until the attempt trailers have been received.",
          THROTTLING_LATENCIES,
          AGGREGATION_WITH_MILLIS_HISTOGRAM,
          ImmutableList.of(
              PROJECT_ID, INSTANCE_ID, APP_PROFILE, METHOD, CLIENT_NAME, CLUSTER, ZONE, TABLE));
}
