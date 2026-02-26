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
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.MetricLabels;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.Units;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.TableSchema;
import com.google.common.collect.ImmutableMap;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import javax.annotation.Nullable;

public class TableDebugTagCount extends MetricWrapper<TableSchema> {
  private static final String NAME = "bigtable.googleapis.com/internal/client/debug_tags";

  public TableDebugTagCount() {
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
    private final LongCounter instrument;

    private Recorder(Meter meter) {
      instrument =
          meter
              .counterBuilder(NAME)
              .setDescription("A counter of internal client events used for debugging.")
              .setUnit(Units.COUNT)
              .build();
    }

    public void record(
        ClientInfo clientInfo,
        String tableId,
        String tag,
        @Nullable ResponseParams clusterInfo,
        long amount) {
      Attributes attributes =
          getSchema()
              .createResourceAttrs(clientInfo, tableId, clusterInfo)
              // To maintain backwards compat CLIENT_UID is set using sideband data in the exporter
              .put(MetricLabels.CLIENT_NAME, clientInfo.getClientName())
              .put(MetricLabels.DEBUG_TAG_KEY, tag)
              .put(MetricLabels.APP_PROFILE_KEY, clientInfo.getAppProfileId())
              .build();
      instrument.add(amount, attributes);
    }
  }
}
