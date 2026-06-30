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
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.Buckets;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.MetricLabels;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.Units;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.ClientSchema;
import com.google.common.collect.ImmutableList;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.Meter;
import java.time.Duration;
import java.util.List;

/**
 * Pacemaker delay records the delta between the pacemaker scheduled time and the actual time. When
 * the delay is high, it could indicate issues with the machine that the client is running on like
 * CPU saturation.
 */
public class PacemakerDelay extends MetricWrapper<ClientSchema> {
  private static final String NAME = "bigtable.googleapis.com/internal/client/pacemaker_delays";

  private static final List<Double> BUCKETS =
      ImmutableList.<Double>builder()
          // Up to 67,108,864, ~1 minute in microseconds
          .addAll(Buckets.generateExponentialSeq(1.0, 13, 4))
          .build();

  public PacemakerDelay() {
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
              .setDescription(
                  "Distribution of the delay between the pacemaker firing and the pacemaker task"
                      + " being scheduled.")
              .setUnit(Units.MICROSECOND)
              .setExplicitBucketBoundariesAdvice(BUCKETS)
              .build();
    }

    public void record(ClientInfo clientInfo, String executorName, Duration delta) {
      Attributes attributes =
          getSchema()
              .createResourceAttrs(clientInfo)
              .put(MetricLabels.EXECUTOR_KEY, executorName)
              .build();
      instrument.record(delta.toNanos() / 1000.0, attributes);
    }
  }
}
