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
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.Units;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.ClientSchema;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;

public class ClientDebugTagCount extends MetricWrapper<ClientSchema> {
  private static final String NAME = "bigtable.googleapis.com/internal/client/debug_tags";

  public ClientDebugTagCount() {
    super(ClientSchema.INSTANCE, NAME);
  }

  public Recorder newRecorder(Meter meter) {
    return new Recorder(meter);
  }

  public class Recorder {
    private final LongCounter instrument;

    private Recorder(Meter meter) {
      instrument =
          meter
              .counterBuilder(NAME)
              .setDescription("A counter of internal client events used for debugging.")
              .setUnit(Units.COUNT)
              .build();
    }

    public void record(ClientInfo clientInfo, String tag, long amount) {
      Attributes attributes =
          getSchema()
              .createResourceAttrs(clientInfo)
              // To maintain backwards compat CLIENT_UID is set using sideband data in the exporter
              .put(MetricLabels.CLIENT_NAME, clientInfo.getClientName())
              .put(MetricLabels.DEBUG_TAG_KEY, tag)
              .put(MetricLabels.APP_PROFILE_KEY, clientInfo.getAppProfileId())
              .build();
      instrument.add(amount, attributes);
    }
  }
}
