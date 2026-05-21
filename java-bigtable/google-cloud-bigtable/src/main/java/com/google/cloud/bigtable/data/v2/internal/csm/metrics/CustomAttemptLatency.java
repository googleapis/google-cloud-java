/*
 * Copyright 2026 Google LLC
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

import com.google.bigtable.v2.ClusterInformation;
import com.google.bigtable.v2.PeerInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.MethodInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.Util;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.CustomSchema;
import io.grpc.Status;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.Meter;
import java.time.Duration;
import javax.annotation.Nullable;

/**
 * Custom attempt latencies with afe id metric label. This metric is high cardinality and is
 * exported as a custom metric.
 */
public class CustomAttemptLatency extends MetricWrapper<CustomSchema> {
  private static final String NAME = "bigtable.custom.attempt_latencies";

  public CustomAttemptLatency() {
    super(CustomSchema.INSTANCE, NAME);
  }

  public Recorder newRecorder(Meter meter) {
    return new Recorder(meter);
  }

  public static class Recorder {
    private final DoubleHistogram instrument;

    private Recorder(Meter meter) {
      instrument =
          meter
              .histogramBuilder(NAME)
              .setDescription("Client observed latency per RPC attempt.")
              .setUnit(Constants.Units.MILLISECOND)
              .setExplicitBucketBoundariesAdvice(
                  Constants.Buckets.AGGREGATION_WITH_MILLIS_HISTOGRAM)
              .build();
    }

    public void record(
        ClientInfo clientInfo,
        String tableId,
        @Nullable PeerInfo peerInfo,
        @Nullable ClusterInformation clusterInfo,
        MethodInfo methodInfo,
        Status.Code code,
        Duration latency) {

      Attributes attributes =
          Attributes.builder()
              .put(
                  Constants.MetricLabels.BIGTABLE_PROJECT_ID_KEY,
                  clientInfo.getInstanceName().getProjectId())
              .put(
                  Constants.MetricLabels.INSTANCE_ID_KEY,
                  clientInfo.getInstanceName().getInstanceId())
              .put("table", tableId)
              .put(Constants.MetricLabels.APP_PROFILE_KEY, clientInfo.getAppProfileId())
              .put("cluster", Util.formatClusterIdMetricLabel(clusterInfo))
              .put("zone", Util.formatZoneIdMetricLabel(clusterInfo))
              .put(Constants.MetricLabels.STATUS_KEY, code.name())
              .put(Constants.MetricLabels.METHOD_KEY, methodInfo.getName())
              .put("afe_id", Util.formatAfeId(peerInfo))
              .build();

      instrument.record(toMillis(latency), attributes);
    }
  }
}
