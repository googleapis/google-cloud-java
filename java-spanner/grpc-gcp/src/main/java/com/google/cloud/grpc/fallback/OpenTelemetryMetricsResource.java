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

package com.google.cloud.grpc.fallback;

import com.google.auto.value.AutoValue;
import com.google.cloud.grpc.fallback.AutoValue_OpenTelemetryMetricsResource.Builder;
import io.opentelemetry.api.metrics.DoubleGauge;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.ObservableLongUpDownCounter;
import javax.annotation.Nullable;

@AutoValue
abstract class OpenTelemetryMetricsResource {

  @Nullable
  abstract ObservableLongUpDownCounter currentChannelCounter();

  @Nullable
  abstract LongCounter fallbackCounter();

  @Nullable
  abstract LongCounter callStatusCounter();

  @Nullable
  abstract DoubleGauge errorRatioGauge();

  @Nullable
  abstract LongCounter probeResultCounter();

  @Nullable
  abstract DoubleGauge channelDowntimeGauge();

  static Builder builder() {
    return new AutoValue_OpenTelemetryMetricsResource.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {
    abstract Builder currentChannelCounter(ObservableLongUpDownCounter counter);

    abstract Builder fallbackCounter(LongCounter counter);

    abstract Builder callStatusCounter(LongCounter counter);

    abstract Builder errorRatioGauge(DoubleGauge gauge);

    abstract Builder probeResultCounter(LongCounter counter);

    abstract Builder channelDowntimeGauge(DoubleGauge gauge);

    abstract OpenTelemetryMetricsResource build();
  }
}
