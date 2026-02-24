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

import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.MetricLabels;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.ClientSchema;
import io.opentelemetry.api.metrics.LongGauge;
import io.opentelemetry.api.metrics.Meter;

public class ClientDpCompatGuage extends MetricWrapper<ClientSchema> {
  private static final String NAME =
      "bigtable.googleapis.com/internal/client/direct_access/compatible";

  public ClientDpCompatGuage() {
    super(ClientSchema.INSTANCE, NAME);
  }

  public Recorder newRecorder(Meter meter) {
    return new Recorder(meter);
  }

  public class Recorder {
    private final LongGauge instrument;

    private Recorder(Meter meter) {
      this.instrument =
          meter
              .gaugeBuilder(NAME)
              .ofLongs()
              .setDescription(
                  "Reports 1 if the environment is eligible for DirectPath, 0 otherwise. Based on"
                      + " an attempt at startup.")
              .setUnit("1")
              .build();
    }

    // TODO: replace ipPreference with an enum
    public void recordSuccess(ClientInfo clientInfo, String ipPreference) {
      instrument.set(
          1,
          getSchema()
              .createResourceAttrs(clientInfo)
              .put(MetricLabels.DP_REASON_KEY, "")
              .put(MetricLabels.DP_IP_PREFERENCE_KEY, ipPreference)
              .build());
    }

    // TODO: replace reason with an enum
    public void recordFailure(ClientInfo clientInfo, String reason) {
      instrument.set(
          1,
          getSchema()
              .createResourceAttrs(clientInfo)
              .put(MetricLabels.DP_REASON_KEY, reason)
              .put(MetricLabels.DP_IP_PREFERENCE_KEY, "")
              .build());
    }
  }
}
