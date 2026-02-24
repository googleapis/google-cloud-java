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

import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.EnvInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.Buckets;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.MetricLabels;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.ClientSchema;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.Meter;
import java.util.List;
import java.util.Set;

public class ClientPerConnectionErrorCount extends MetricWrapper<ClientSchema> {
  private static final String NAME =
      "bigtable.googleapis.com/internal/client/per_connection_error_count";

  static final List<Long> BUCKETS =
      ImmutableList.<Long>builder()
          .add(0L)
          .addAll(Buckets.generateGeometricSeq(1, 64))
          .addAll(Buckets.generateGeometricSeq(125, 1_000_000L))
          .build();
  // This metric migrated from gce/gke schemas to bigtable_client
  // So a lot of the metric labels overlap with the resource labels.
  // we need special handling since the logic in MetricWrapper assumes that there is no
  // overlap.
  private static final Set<AttributeKey<?>> METRIC_LABELS =
      ImmutableSet.of(
          MetricLabels.BIGTABLE_PROJECT_ID_KEY,
          MetricLabels.CLIENT_UID,
          MetricLabels.INSTANCE_ID_KEY,
          MetricLabels.CLIENT_NAME,
          MetricLabels.APP_PROFILE_KEY);

  public ClientPerConnectionErrorCount() {
    super(ClientSchema.INSTANCE, NAME);
  }

  // Override the default metric labels to account for backwards compatibility.
  // This metric used to live under bigtable_table, and has moved to bigtable_client
  // The new schema duplicates some of the metric labels. However the default implementation
  // in MetricWrapper will remove all resource labels from the metric labels.
  // To maintain backwards compatibility, this metric override the extractMetricLabels
  // to always emit the duplicate metric labels.
  @Override
  public ImmutableMap<String, String> extractMetricLabels(
      Attributes metricAttrs, EnvInfo envInfo, ClientInfo clientInfo) {
    ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
    metricAttrs.forEach(
        (k, v) -> {
          if (METRIC_LABELS.contains(k) && v != null) {
            builder.put(k.getKey(), v.toString());
          }
        });
    builder.put(MetricLabels.CLIENT_UID.getKey(), envInfo.getUid());
    return builder.build();
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
              .ofLongs()
              .setDescription("Distribution of counts of channels per 'error count per minute'.")
              .setUnit("1")
              .setExplicitBucketBoundariesAdvice(BUCKETS)
              .build();
    }

    public void record(ClientInfo clientInfo, long value) {
      Attributes attributes =
          getSchema()
              .createResourceAttrs(clientInfo)
              .put(MetricLabels.BIGTABLE_PROJECT_ID_KEY, clientInfo.getInstanceName().getProject())
              .put(MetricLabels.INSTANCE_ID_KEY, clientInfo.getInstanceName().getInstance())
              .put(MetricLabels.CLIENT_NAME, clientInfo.getClientName())
              .put(MetricLabels.APP_PROFILE_KEY, clientInfo.getAppProfileId())
              .build();
      instrument.record(value, attributes);
    }
  }
}
