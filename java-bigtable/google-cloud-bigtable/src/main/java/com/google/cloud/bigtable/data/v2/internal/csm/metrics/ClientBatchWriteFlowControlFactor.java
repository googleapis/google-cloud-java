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
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.MethodInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.MetricLabels;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.ClientSchema;
import io.grpc.Status;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleGauge;
import io.opentelemetry.api.metrics.Meter;

public class ClientBatchWriteFlowControlFactor extends MetricWrapper<ClientSchema> {
  public static final String NAME =
      "bigtable.googleapis.com/internal/client/batch_write_flow_control_factor";

  public ClientBatchWriteFlowControlFactor() {
    super(ClientSchema.INSTANCE, NAME);
  }

  public Recorder newRecorder(Meter meter) {
    return new Recorder(meter);
  }

  public class Recorder {
    private final DoubleGauge instrument;

    private Recorder(Meter meter) {
      this.instrument =
          meter
              .gaugeBuilder(NAME)
              .setDescription(
                  "The distribution of batch write flow control factors received from the server.")
              .setUnit("1")
              .build();
    }

    public void record(
        ClientInfo clientInfo,
        Status.Code code,
        boolean applied,
        MethodInfo methodInfo,
        double factor) {
      Attributes attributes =
          getSchema()
              .createResourceAttrs(clientInfo)
              .put(MetricLabels.STATUS_KEY, code.name())
              .put(MetricLabels.APPLIED_KEY, applied)
              .put(MetricLabels.METHOD_KEY, methodInfo.getName())
              .build();

      instrument.set(factor, attributes);
    }
  }
}
