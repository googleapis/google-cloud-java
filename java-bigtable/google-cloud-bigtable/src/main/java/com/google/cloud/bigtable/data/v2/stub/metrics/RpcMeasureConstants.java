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

import com.google.api.core.InternalApi;
import io.opencensus.stats.Measure.MeasureLong;
import io.opencensus.tags.TagKey;

@InternalApi("For internal use only")
public class RpcMeasureConstants {
  // TagKeys
  public static final TagKey BIGTABLE_PROJECT_ID = TagKey.create("bigtable_project_id");
  public static final TagKey BIGTABLE_INSTANCE_ID = TagKey.create("bigtable_instance_id");
  public static final TagKey BIGTABLE_APP_PROFILE_ID = TagKey.create("bigtable_app_profile_id");

  /** Tag key that represents a Bigtable operation name. */
  static final TagKey BIGTABLE_OP = TagKey.create("bigtable_op");

  /** Tag key that represents the final status of the Bigtable operation. */
  static final TagKey BIGTABLE_STATUS = TagKey.create("bigtable_status");

  // Units
  /** Unit to represent counts. */
  private static final String COUNT = "1";

  /** Unit to represent milliseconds. */
  private static final String MILLISECOND = "ms";

  // Measurements
  /**
   * Latency for a logic operation, which will include latencies for each attempt and exponential
   * backoff delays.
   */
  static final MeasureLong BIGTABLE_OP_LATENCY =
      MeasureLong.create(
          "cloud.google.com/java/bigtable/op_latency",
          "Time between request being sent to last row received, "
              + "or terminal error of the last retry attempt.",
          MILLISECOND);

  /**
   * Number of attempts a logical operation took to complete. Under normal circumstances should be
   * 1.
   */
  static final MeasureLong BIGTABLE_OP_ATTEMPT_COUNT =
      MeasureLong.MeasureLong.create(
          "cloud.google.com/java/bigtable/op_attempt_count",
          "Number of attempts per operation",
          COUNT);

  /** Latency that a single attempt (RPC) took to complete. */
  static final MeasureLong BIGTABLE_ATTEMPT_LATENCY =
      MeasureLong.create(
          "cloud.google.com/java/bigtable/attempt_latency",
          "Duration of an individual operation attempt",
          MILLISECOND);

  /** Latency for the caller to see the first row in a ReadRows stream. */
  static final MeasureLong BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY =
      MeasureLong.create(
          "cloud.google.com/java/bigtable/read_rows_first_row_latency",
          "Time between request being sent to the first row received",
          MILLISECOND);

  /** GFE t4t7 latency extracted from server-timing header. */
  public static final MeasureLong BIGTABLE_GFE_LATENCY =
      MeasureLong.create(
          "cloud.google.com/java/bigtable/gfe_latency",
          "Latency between Google's network receives an RPC and reads back the first byte of the response",
          MILLISECOND);

  /** Number of responses without the server-timing header. */
  public static final MeasureLong BIGTABLE_GFE_HEADER_MISSING_COUNT =
      MeasureLong.create(
          "cloud.google.com/java/bigtable/gfe_header_missing_count",
          "Number of RPC responses received without the server-timing header, most likely means that the RPC never reached Google's network",
          COUNT);

  /** Total throttled time of a batch in msecs. */
  public static final MeasureLong BIGTABLE_BATCH_THROTTLED_TIME =
      MeasureLong.create(
          "cloud.google.com/java/bigtable/batch_throttled_time",
          "Total throttled time of a batch in msecs",
          MILLISECOND);
}
