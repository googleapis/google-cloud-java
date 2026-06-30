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
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.PoolFallbackListener.ChannelFallbackReason;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;

public class ClientChannelPoolFallbackCount extends MetricWrapper<ClientSchema> {

  private static final String NAME =
      "bigtable.googleapis.com/internal/client/channel_fallback_count";
  private static final AttributeKey<String> FROM_KEY = AttributeKey.stringKey("from");
  private static final AttributeKey<String> TO_KEY = AttributeKey.stringKey("to");
  private static final AttributeKey<String> REASON_KEY = AttributeKey.stringKey("reason");

  public ClientChannelPoolFallbackCount() {
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
              .setDescription("Number of fallback occurrences.")
              .setUnit(Units.COUNT)
              .build();
    }

    public void record(
        ClientInfo clientInfo, long count, String from, String to, ChannelFallbackReason reason) {
      Attributes attrs =
          getSchema()
              .createResourceAttrs(clientInfo)
              .put(FROM_KEY, from)
              .put(TO_KEY, to)
              .put(REASON_KEY, reason.name())
              .build();
      instrument.add(count, attrs);
    }
  }
}
