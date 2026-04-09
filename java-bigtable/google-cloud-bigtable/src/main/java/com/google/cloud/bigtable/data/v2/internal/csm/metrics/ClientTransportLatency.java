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

import com.google.bigtable.v2.PeerInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.MethodInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.Util;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.Buckets;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.MetricLabels;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.Units;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.ClientSchema;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolInfo;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.Meter;
import java.time.Duration;
import javax.annotation.Nullable;

public class ClientTransportLatency extends MetricWrapper<ClientSchema> {
  public static final String NAME = "bigtable.googleapis.com/internal/client/transport_latencies";

  public ClientTransportLatency() {
    super(ClientSchema.INSTANCE, NAME);
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
              .setDescription("The latency measured from e2e latencies minus node latencies.")
              .setUnit(Units.MILLISECOND)
              .setExplicitBucketBoundariesAdvice(Buckets.AGGREGATION_WITH_MILLIS_HISTOGRAM)
              .build();
    }

    public void record(
        SessionPoolInfo poolInfo,
        @Nullable PeerInfo peerInfo,
        MethodInfo methodInfo,
        Duration duration) {
      Attributes attributes =
          getSchema()
              .createResourceAttrs(poolInfo.getClientInfo())
              // Shared session labels
              .put(MetricLabels.SESSION_TYPE_KEY, poolInfo.getTypeLabel())
              .put(MetricLabels.SESSION_NAME, poolInfo.getName())
              .put(MetricLabels.TRANSPORT_TYPE, Util.formatTransportType(peerInfo))
              .put(MetricLabels.AFE_LOCATION_KEY, Util.formatTransportSubzone(peerInfo))
              .put(MetricLabels.METHOD_KEY, methodInfo.getName())
              .build();

      instrument.record(toMillis(duration), attributes);
    }
  }
}
