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

import com.google.bigtable.v2.CloseSessionRequest.CloseSessionReason;
import com.google.bigtable.v2.PeerInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.Util;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.Buckets;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.MetricLabels;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.Units;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.ClientSchema;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolInfo;
import com.google.common.collect.ImmutableSortedSet;
import io.grpc.Status;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.Meter;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class ClientSessionDuration extends MetricWrapper<ClientSchema> {
  private static final String NAME = "bigtable.googleapis.com/internal/client/session/durations";

  public static final List<Long> BUCKETS_MS =
      ImmutableSortedSet.<Long>naturalOrder()
          .add(0L)
          .addAll(Buckets.generateGeometricSeq(1, TimeUnit.MINUTES.toMillis(20)))
          .build()
          .asList();

  public enum SessionCloseVRpcState {
    None("none", false, false),
    SomeOk("some_ok", true, true),
    AllOk("all_ok", true, false),
    AllError("all_error", false, true);

    private final String label;
    private final boolean hasOk;
    private final boolean hasError;

    SessionCloseVRpcState(String label, boolean hasOk, boolean hasError) {
      this.label = label;
      this.hasOk = hasOk;
      this.hasError = hasError;
    }

    public static SessionCloseVRpcState find(boolean hasOk, boolean hasError) {
      for (SessionCloseVRpcState v : SessionCloseVRpcState.values()) {
        if (v.hasOk == hasOk && v.hasError == hasError) {
          return v;
        }
      }
      throw new IllegalStateException(
          String.format(
              "Failed to find SessionCloseVRpcState variant for hasOk: %b, hasError: %b",
              hasOk, hasError));
    }
  }

  public ClientSessionDuration() {
    super(ClientSchema.INSTANCE, NAME);
  }

  public Recorder newRecorder(Meter meter) {
    return new Recorder(meter);
  }

  public class Recorder {
    private final LongHistogram instrument;

    private Recorder(Meter meter) {
      instrument =
          meter
              .histogramBuilder(NAME)
              .setDescription("Client observed latency for establishing a new session")
              .setUnit(Units.MILLISECOND)
              .ofLongs()
              .setExplicitBucketBoundariesAdvice(BUCKETS_MS)
              .build();
    }

    public void record(
        SessionPoolInfo poolInfo,
        @Nullable PeerInfo peerInfo,
        Status.Code code,
        CloseSessionReason closeReason,
        SessionCloseVRpcState vrpcState,
        boolean isReady,
        Duration latency) {
      Attributes attributes =
          getSchema()
              .createResourceAttrs(poolInfo.getClientInfo())
              // Shared session labels
              .put(MetricLabels.SESSION_TYPE_KEY, poolInfo.getTypeLabel())
              .put(MetricLabels.SESSION_NAME, poolInfo.getName())
              .put(MetricLabels.TRANSPORT_TYPE, Util.formatTransportType(peerInfo))
              .put(MetricLabels.AFE_LOCATION_KEY, Util.formatTransportSubzone(peerInfo))
              // metric specific
              .put(MetricLabels.SESSION_READY_KEY, isReady)
              .put(MetricLabels.STATUS_KEY, code.name()) // gRPC stream status
              .put(MetricLabels.REASON_KEY, closeReason.name())
              .put(MetricLabels.VRPCS_KEY, vrpcState.label)
              .build();

      instrument.record((long) toMillis(latency), attributes);
    }
  }
}
