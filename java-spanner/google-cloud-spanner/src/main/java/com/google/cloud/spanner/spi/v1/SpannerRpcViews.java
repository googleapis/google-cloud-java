/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.spanner.spi.v1;

import com.google.api.core.ObsoleteApi;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import io.opencensus.stats.Aggregation;
import io.opencensus.stats.Aggregation.Distribution;
import io.opencensus.stats.Aggregation.Sum;
import io.opencensus.stats.BucketBoundaries;
import io.opencensus.stats.Measure.MeasureLong;
import io.opencensus.stats.Stats;
import io.opencensus.stats.View;
import io.opencensus.stats.ViewManager;
import io.opencensus.tags.TagKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@VisibleForTesting
public class SpannerRpcViews {

  /** Unit to represent milliseconds. */
  private static final String MILLISECOND = "ms";

  /** Unit to represent counts. */
  private static final String COUNT = "1";

  /** TagKeys */
  public static final TagKey METHOD = TagKey.create("method");

  public static final TagKey PROJECT_ID = TagKey.create("project_id");
  public static final TagKey INSTANCE_ID = TagKey.create("instance_id");
  public static final TagKey DATABASE_ID = TagKey.create("database");

  /** GFE t4t7 latency extracted from server-timing header. */
  public static final MeasureLong SPANNER_GFE_LATENCY =
      MeasureLong.create(
          "cloud.google.com/java/spanner/gfe_latency",
          "Latency between Google's network receiving an RPC and reading back the first byte of the"
              + " response",
          MILLISECOND);

  /** Number of responses without the server-timing header. */
  public static final MeasureLong SPANNER_GFE_HEADER_MISSING_COUNT =
      MeasureLong.create(
          "cloud.google.com/java/spanner/gfe_header_missing_count",
          "Number of RPC responses received without the server-timing header, most likely means"
              + " that the RPC never reached Google's network",
          COUNT);

  static final List<Double> RPC_MILLIS_BUCKET_BOUNDARIES =
      Collections.unmodifiableList(
          Arrays.asList(
              0.0, 0.01, 0.05, 0.1, 0.3, 0.6, 0.8, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 8.0, 10.0, 13.0,
              16.0, 20.0, 25.0, 30.0, 40.0, 50.0, 65.0, 80.0, 100.0, 130.0, 160.0, 200.0, 250.0,
              300.0, 400.0, 500.0, 650.0, 800.0, 1000.0, 2000.0, 5000.0, 10000.0, 20000.0, 50000.0,
              100000.0));
  static final Aggregation AGGREGATION_WITH_MILLIS_HISTOGRAM =
      Distribution.create(BucketBoundaries.create(RPC_MILLIS_BUCKET_BOUNDARIES));
  static final View SPANNER_GFE_LATENCY_VIEW =
      View.create(
          View.Name.create("cloud.google.com/java/spanner/gfe_latency"),
          "Latency between Google's network receiving an RPC and reading back the first byte of the"
              + " response",
          SPANNER_GFE_LATENCY,
          AGGREGATION_WITH_MILLIS_HISTOGRAM,
          ImmutableList.of(METHOD, PROJECT_ID, INSTANCE_ID, DATABASE_ID));

  private static final Aggregation SUM = Sum.create();
  static final View SPANNER_GFE_HEADER_MISSING_COUNT_VIEW =
      View.create(
          View.Name.create("cloud.google.com/java/spanner/gfe_header_missing_count"),
          "Number of RPC responses received without the server-timing header, most likely means"
              + " that the RPC never reached Google's network",
          SPANNER_GFE_HEADER_MISSING_COUNT,
          SUM,
          ImmutableList.of(METHOD, PROJECT_ID, INSTANCE_ID, DATABASE_ID));

  public static ViewManager viewManager = Stats.getViewManager();

  /**
   * Register views for GFE metrics, including gfe_latency and gfe_header_missing_count. gfe_latency
   * measures the latency between Google's network receives an RPC and reads back the first byte of
   * the response. gfe_header_missing_count is a counter of the number of RPC responses without a
   * server-timing header.
   *
   * @deprecated The OpenCensus project is deprecated. Use OpenTelemetry to get gfe_latency and
   *     gfe_header_missing_count metrics.
   */
  @VisibleForTesting
  @ObsoleteApi(
      "The OpenCensus project is deprecated. Use OpenTelemetry to get gfe_latency and"
          + " gfe_header_missing_count metrics.")
  public static void registerGfeLatencyAndHeaderMissingCountViews() {
    if (SpannerOptions.isEnabledOpenCensusMetrics()) {
      viewManager.registerView(SPANNER_GFE_LATENCY_VIEW);
      viewManager.registerView(SPANNER_GFE_HEADER_MISSING_COUNT_VIEW);
    }
  }

  /**
   * Register GFE Latency view. gfe_latency measures the latency between Google's network receives
   * an RPC and reads back the first byte of the response.
   *
   * @deprecated The OpenCensus project is deprecated. Use OpenTelemetry to get gfe_latency and
   *     gfe_header_missing_count metrics.
   */
  @VisibleForTesting
  @ObsoleteApi(
      "The OpenCensus project is deprecated. Use OpenTelemetry to get gfe_latency and"
          + " gfe_header_missing_count metrics.")
  public static void registerGfeLatencyView() {
    if (SpannerOptions.isEnabledOpenCensusMetrics()) {
      viewManager.registerView(SPANNER_GFE_LATENCY_VIEW);
    }
  }

  /**
   * Register GFE Header Missing Count view. gfe_header_missing_count is a counter of the number of
   * RPC responses without a server-timing header.
   *
   * @deprecated The OpenCensus project is deprecated. Use OpenTelemetry to get gfe_latency and
   *     gfe_header_missing_count metrics.
   */
  @VisibleForTesting
  @ObsoleteApi(
      "The OpenCensus project is deprecated. Use OpenTelemetry to get gfe_latency and"
          + " gfe_header_missing_count metrics.")
  public static void registerGfeHeaderMissingCountView() {
    if (SpannerOptions.isEnabledOpenCensusMetrics()) {
      viewManager.registerView(SPANNER_GFE_HEADER_MISSING_COUNT_VIEW);
    }
  }
}
