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
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.Units;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.ClientSchema;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongGauge;
import io.opentelemetry.api.metrics.Meter;
import java.time.Duration;

public class ClientUptime extends MetricWrapper<ClientSchema> {
  private static final String NAME = "bigtable.googleapis.com/internal/client/uptime";

  public ClientUptime() {
    super(ClientSchema.INSTANCE, NAME);
  }

  public Recorder newRecorder(Meter meter) {
    return new Recorder(meter);
  }

  public class Recorder {
    private final LongGauge instrument;

    private Recorder(Meter meter) {
      instrument =
          meter
              .gaugeBuilder(NAME)
              .setDescription("The uptime of the client")
              .setUnit(Units.MILLISECOND)
              .ofLongs()
              .build();
    }

    public void record(ClientInfo clientInfo, Duration duration) {
      Attributes attributes =
          getSchema()
              .createResourceAttrs(clientInfo)
              .build();

      instrument.set(duration.toMillis(), attributes);
    }
  }
}
