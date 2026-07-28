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

import com.google.bigtable.v2.PeerInfo.TransportType;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.Util;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.Buckets;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.MetricLabels;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.ClientSchema;
import com.google.cloud.bigtable.gaxx.grpc.BigtableChannelPoolSettings.LoadBalancingStrategy;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.Meter;
import java.util.List;
import java.util.stream.Collectors;

public class ClientChannelPoolOutstandingRpcs extends MetricWrapper<ClientSchema> {
  public static final String NAME =
      "bigtable.googleapis.com/internal/client/connection_pool/outstanding_rpcs";

  private static final List<Long> BUCKETS =
      Buckets.generateLinearSeq(0d, 200d, 5).stream()
          .map(Double::longValue)
          .collect(Collectors.toList());

  public ClientChannelPoolOutstandingRpcs() {
    super(ClientSchema.INSTANCE, NAME);
  }

  public Recorder newRecorder(Meter meter) {
    return new Recorder(meter);
  }

  public class Recorder {
    private final LongHistogram instrument;

    private Recorder(Meter meter) {
      this.instrument =
          meter
              .histogramBuilder(NAME)
              .ofLongs()
              .setExplicitBucketBoundariesAdvice(BUCKETS)
              .setDescription(
                  "A distribution of the number of outstanding RPCs per connection in the client"
                      + " pool, sampled periodically.")
              .setUnit("1")
              .build();
    }

    public void record(
        ClientInfo clientInfo,
        TransportType transportType,
        LoadBalancingStrategy lbPolicy,
        boolean isStreaming,
        long rpcCount) {
      instrument.record(
          rpcCount,
          getSchema()
              .createResourceAttrs(clientInfo)
              .put(MetricLabels.TRANSPORT_TYPE, Util.transportTypeToString(transportType))
              .put(MetricLabels.CHANNEL_POOL_LB_POLICY, lbPolicy.name())
              .put(MetricLabels.STREAMING_KEY, isStreaming)
              .build());
    }
  }
}
