/*
 * Copyright 2019 Google LLC
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

import static com.google.cloud.bigtable.data.v2.stub.metrics.RpcMeasureConstants.BIGTABLE_APP_PROFILE_ID;
import static com.google.cloud.bigtable.data.v2.stub.metrics.RpcMeasureConstants.BIGTABLE_ATTEMPT_LATENCY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.RpcMeasureConstants.BIGTABLE_INSTANCE_ID;
import static com.google.cloud.bigtable.data.v2.stub.metrics.RpcMeasureConstants.BIGTABLE_OP;
import static com.google.cloud.bigtable.data.v2.stub.metrics.RpcMeasureConstants.BIGTABLE_OP_ATTEMPT_COUNT;
import static com.google.cloud.bigtable.data.v2.stub.metrics.RpcMeasureConstants.BIGTABLE_OP_LATENCY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.RpcMeasureConstants.BIGTABLE_PROJECT_ID;
import static com.google.cloud.bigtable.data.v2.stub.metrics.RpcMeasureConstants.BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.RpcMeasureConstants.BIGTABLE_STATUS;

import com.google.common.collect.ImmutableList;
import io.opencensus.stats.Aggregation;
import io.opencensus.stats.Aggregation.Count;
import io.opencensus.stats.Aggregation.Distribution;
import io.opencensus.stats.BucketBoundaries;
import io.opencensus.stats.View;
import java.util.Arrays;

class RpcViewConstants {
  // Aggregations
  private static final Aggregation COUNT = Count.create();

  private static final Aggregation AGGREGATION_WITH_MILLIS_HISTOGRAM =
      Distribution.create(
          BucketBoundaries.create(
              ImmutableList.of(
                  0.0, 0.01, 0.05, 0.1, 0.3, 0.6, 0.8, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 8.0, 10.0,
                  13.0, 16.0, 20.0, 25.0, 30.0, 40.0, 50.0, 65.0, 80.0, 100.0, 130.0, 160.0, 200.0,
                  250.0, 300.0, 400.0, 500.0, 650.0, 800.0, 1000.0, 2000.0, 5000.0, 10000.0,
                  20000.0, 50000.0, 100000.0)));

  private static final Aggregation AGGREGATION_ATTEMPT_COUNT =
      Distribution.create(
          BucketBoundaries.create(
              ImmutableList.of(
                  1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 15.0, 20.0, 30.0, 40.0, 50.0,
                  100.0)));

  private static final Aggregation AGGREGATION_WITH_POWERS_OF_2 =
      Distribution.create(
          BucketBoundaries.create(
              ImmutableList.of(
                  0.0, 1.0, 2.0, 4.0, 8.0, 16.0, 32.0, 64.0, 128.0, 256.0, 512.0, 1024.0, 2048.0,
                  4096.0, 8192.0, 16384.0, 32768.0, 65536.0, 131072.0, 262144.0, 524288.0,
                  1048576.0, 2097152.0)));

  /**
   * {@link View} for Bigtable client roundtrip latency in milliseconds including all retry
   * attempts.
   */
  static final View BIGTABLE_OP_LATENCY_VIEW =
      View.create(
          View.Name.create("cloud.google.com/java/bigtable/op_latency"),
          "Operation latency in msecs",
          BIGTABLE_OP_LATENCY,
          AGGREGATION_WITH_MILLIS_HISTOGRAM,
          ImmutableList.of(
              BIGTABLE_PROJECT_ID,
              BIGTABLE_INSTANCE_ID,
              BIGTABLE_APP_PROFILE_ID,
              BIGTABLE_OP,
              BIGTABLE_STATUS));

  static final View BIGTABLE_COMPLETED_OP_VIEW =
      View.create(
          View.Name.create("cloud.google.com/java/bigtable/completed_ops"),
          "Number of completed Bigtable client operations",
          BIGTABLE_OP_LATENCY,
          COUNT,
          Arrays.asList(
              BIGTABLE_PROJECT_ID,
              BIGTABLE_INSTANCE_ID,
              BIGTABLE_APP_PROFILE_ID,
              BIGTABLE_OP,
              BIGTABLE_STATUS));

  static final View BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY_VIEW =
      View.create(
          View.Name.create("cloud.google.com/java/bigtable/read_rows_first_row_latency"),
          "Latency to receive the first row in a ReadRows stream",
          BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY,
          AGGREGATION_WITH_MILLIS_HISTOGRAM,
          ImmutableList.of(BIGTABLE_PROJECT_ID, BIGTABLE_INSTANCE_ID, BIGTABLE_APP_PROFILE_ID));

  static final View BIGTABLE_ATTEMPT_LATENCY_VIEW =
      View.create(
          View.Name.create("cloud.google.com/java/bigtable/attempt_latency"),
          "Attempt latency in msecs",
          BIGTABLE_ATTEMPT_LATENCY,
          AGGREGATION_WITH_MILLIS_HISTOGRAM,
          ImmutableList.of(
              BIGTABLE_PROJECT_ID,
              BIGTABLE_INSTANCE_ID,
              BIGTABLE_APP_PROFILE_ID,
              BIGTABLE_OP,
              BIGTABLE_STATUS));

  static final View BIGTABLE_ATTEMPTS_PER_OP_VIEW =
      View.create(
          View.Name.create("cloud.google.com/java/bigtable/attempts_per_op"),
          "Distribution of attempts per logical operation",
          BIGTABLE_OP_ATTEMPT_COUNT,
          AGGREGATION_ATTEMPT_COUNT,
          ImmutableList.of(
              BIGTABLE_PROJECT_ID,
              BIGTABLE_INSTANCE_ID,
              BIGTABLE_APP_PROFILE_ID,
              BIGTABLE_OP,
              BIGTABLE_STATUS));
}
