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

import com.google.bigtable.v2.ResponseParams;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.EnvInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.MethodInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.Buckets;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.MetricLabels;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.Units;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.TableSchema;
import com.google.common.collect.ImmutableMap;
import io.grpc.Status;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.Meter;
import java.time.Duration;

public class TableServerLatency extends MetricWrapper<TableSchema> {
  private static final String NAME = "bigtable.googleapis.com/internal/client/server_latencies";

  public TableServerLatency() {
    super(TableSchema.INSTANCE, NAME);
  }

  @Override
  public ImmutableMap<String, String> extractMetricLabels(
      Attributes metricAttrs, EnvInfo envInfo, ClientInfo clientInfo) {
    return ImmutableMap.<String, String>builder()
        .putAll(super.extractMetricLabels(metricAttrs, envInfo, clientInfo))
        .put(MetricLabels.CLIENT_UID.getKey(), envInfo.getUid())
        .build();
  }

  public Recorder newRecorder(Meter meter) {
    return new Recorder(meter);
  }

  public class Recorder {
    private final DoubleHistogram instrument;

    private Recorder(Meter meter) {
      instrument =
          meter
              .histogramBuilder(NAME)
              .setDescription(
                  "The latency measured from the moment that the RPC entered the Google data center"
                      + " until the RPC was completed.")
              .setUnit(Units.MILLISECOND)
              .setExplicitBucketBoundariesAdvice(Buckets.AGGREGATION_WITH_MILLIS_HISTOGRAM)
              .build();
    }

    public void record(
        ClientInfo clientInfo,
        String tableId,
        MethodInfo methodInfo,
        ResponseParams clusterInfo,
        Status.Code code,
        Duration duration) {
      Attributes attributes =
          getSchema()
              .createResourceAttrs(clientInfo, tableId, clusterInfo)
              .put(MetricLabels.METHOD_KEY, methodInfo.getName())
              .put(MetricLabels.APP_PROFILE_KEY, clientInfo.getAppProfileId())
              .put(MetricLabels.STREAMING_KEY, methodInfo.getStreaming())
              .put(MetricLabels.STATUS_KEY, code.name())
              .put(MetricLabels.CLIENT_NAME, clientInfo.getClientName())
              // To maintain backwards compat CLIENT_UID is set using sideband data in the exporter
              .build();

      instrument.record(toMillis(duration), attributes);
    }
  }
}
