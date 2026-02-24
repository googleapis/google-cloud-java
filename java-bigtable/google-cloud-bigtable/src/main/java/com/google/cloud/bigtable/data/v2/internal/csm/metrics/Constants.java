/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.csm.metrics;

import com.google.common.collect.ImmutableList;
import io.opentelemetry.api.common.AttributeKey;
import java.util.ArrayList;
import java.util.List;

public final class Constants {
  private Constants() {}

  public static final class MetricLabels {
    private MetricLabels() {}

    // TODO: remove overlapping attributes
    // Project & Instance overlap with resource labels because they were migrated from
    // an old gce/gke schema to support per_connection_error_count metric
    @Deprecated
    public static final AttributeKey<String> BIGTABLE_PROJECT_ID_KEY =
        AttributeKey.stringKey("project_id");

    @Deprecated
    public static final AttributeKey<String> INSTANCE_ID_KEY = AttributeKey.stringKey("instance");

    public static final AttributeKey<String> TRANSPORT_TYPE =
        AttributeKey.stringKey("transport_type");
    public static final AttributeKey<String> TRANSPORT_REGION =
        AttributeKey.stringKey("transport_region");
    public static final AttributeKey<String> TRANSPORT_ZONE =
        AttributeKey.stringKey("transport_zone");
    public static final AttributeKey<String> TRANSPORT_SUBZONE =
        AttributeKey.stringKey("transport_subzone");

    public static final AttributeKey<String> CLIENT_UID = AttributeKey.stringKey("client_uid");
    public static final AttributeKey<String> CLIENT_NAME = AttributeKey.stringKey("client_name");
    public static final AttributeKey<String> METHOD_KEY = AttributeKey.stringKey("method");
    public static final AttributeKey<Boolean> STREAMING_KEY = AttributeKey.booleanKey("streaming");
    public static final AttributeKey<String> APP_PROFILE_KEY =
        AttributeKey.stringKey("app_profile");
    public static final AttributeKey<String> DEBUG_TAG_KEY = AttributeKey.stringKey("tag");

    static final AttributeKey<Boolean> APPLIED_KEY = AttributeKey.booleanKey("applied");

    static final AttributeKey<String> CHANNEL_POOL_LB_POLICY = AttributeKey.stringKey("lb_policy");
    static final AttributeKey<String> DP_REASON_KEY = AttributeKey.stringKey("reason");
    static final AttributeKey<String> DP_IP_PREFERENCE_KEY = AttributeKey.stringKey("reason");

    public static final AttributeKey<String> STATUS_KEY = AttributeKey.stringKey("status");

    static final AttributeKey<String> EXECUTOR_KEY = AttributeKey.stringKey("executor");
  }

  static final class Units {
    private Units() {}

    static final String MILLISECOND = "ms";
    static final String MICROSECOND = "us";
    static final String COUNT = "1";
  }

  static final class Buckets {
    static final List<Double> AGGREGATION_WITH_MILLIS_HISTOGRAM =
        ImmutableList.<Double>builder()
            // Match `bigtable.googleapis.com/frontend_server/handler_latencies` buckets
            .addAll(generateLinearSeq(0, 3.0, 0.1))
            .add(4.0, 5.0, 6.0, 8.0, 10.0, 13.0, 16.0, 20.0, 25.0, 30.0, 40.0, 50.0, 65.0, 80.0)
            .add(100.0, 130.0, 160.0, 200.0, 250.0, 300.0, 400.0, 500.0, 650.0, 800.0, 900.0)
            .add(1000.0, 2000.0, 3000.0, 4000.0, 5000.0, 6000.0, 10000.0, 20000.0, 50000.0)
            .add(100000.0, 200000.0, 500000.0, 1000000.0, 2000000.0, 5000000.0)
            .build();

    @SuppressWarnings("SameParameterValue")
    static List<Double> generateLinearSeq(double start, double end, double increment) {
      ImmutableList.Builder<Double> builder = ImmutableList.builder();
      for (int i = 0; true; i++) {
        double next = start + (increment * i);
        if (next > end) {
          break;
        }
        builder.add(next);
      }

      return builder.build();
    }

    @SuppressWarnings("SameParameterValue")
    static List<Double> generateExponentialSeq(double start, int count, double factor) {
      List<Double> buckets = new ArrayList<>();

      for (int i = 0; i < count; i++) {
        buckets.add(start);
        start *= factor;
      }

      return buckets;
    }

    static List<Long> generateGeometricSeq(long startClose, long endClosed) {
      ImmutableList.Builder<Long> builder = ImmutableList.builder();
      for (long i = startClose; i <= endClosed; i *= 2) {
        builder.add(i);
      }
      return builder.build();
    }
  }
}
