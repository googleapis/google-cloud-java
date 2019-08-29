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

import io.opencensus.stats.Measure;
import io.opencensus.stats.Measure.MeasureDouble;
import io.opencensus.stats.Measure.MeasureLong;
import io.opencensus.tags.TagKey;

class RpcMeasureConstants {
  /**
   * Tag key that represents a Bigtable operation name.
   *
   * <p>A Bigtable operation consists of 1 or more RPCs. By comparing metrics tagged with {@link
   * io.opencensus.contrib.grpc.metrics.RpcMeasureConstants#GRPC_CLIENT_METHOD} to methods tagged
   * with {@link RpcMeasureConstants#BIGTABLE_OP}, the end user can get a sense how many attempts an
   * operation took.
   */
  public static final TagKey BIGTABLE_OP = TagKey.create("bigtable_op");

  /** Tag key that represents the final status of the Bigtable operation. */
  public static final TagKey BIGTABLE_STATUS = TagKey.create("bigtable_status");

  /** Unit to represent counts. */
  private static final String COUNT = "1";

  /** Unit to represent milliseconds. */
  private static final String MILLISECOND = "ms";

  static final MeasureDouble BIGTABLE_OP_LATENCY =
      Measure.MeasureDouble.create(
          "cloud.google.com/java/bigtable/op_latency",
          "Time between request being sent to last row received, "
              + "or terminal error of the last retry attempt.",
          MILLISECOND);

  static final MeasureDouble BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY =
      MeasureDouble.create(
          "cloud.google.com/java/bigtable/read_rows_first_row_latency",
          "Time between request being sent to the first row received",
          MILLISECOND);

  static final MeasureLong BIGTABLE_ROWS_READ_PER_OP =
      Measure.MeasureLong.create(
          "cloud.google.com/java/bigtable/rows_read_per_op",
          "Number of rows received per ReadRows operation",
          COUNT);

  static final MeasureLong BIGTABLE_MUTATE_ROWS_ENTRIES_PER_BATCH =
      Measure.MeasureLong.create(
          "cloud.google.com/java/bigtable/mutations_per_batch",
          "Number of mutations per MutateRows request",
          COUNT);
}
