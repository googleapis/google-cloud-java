/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore.telemetry;

import com.google.cloud.datastore.DatastoreOpenTelemetryOptions;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import java.util.Map;
import javax.annotation.Nonnull;

/** Interface to record specific metric operations. */
public interface MetricsRecorder {
  /** Records the total latency of a transaction in milliseconds. */
  void recordTransactionLatency(double latencyMs, Map<String, String> attributes);

  /** Records the number of attempts a transaction took. */
  void recordTransactionAttemptCount(long count, Map<String, String> attributes);

  /**
   * Returns a {@link MetricsRecorder} instance based on the provided OpenTelemetry options.
   *
   * @param options The {@link com.google.cloud.datastore.DatastoreOpenTelemetryOptions} configuring
   *     telemetry.
   * @return An {@link OpenTelemetryMetricsRecorder} if metrics are enabled, otherwise a {@link
   *     NoOpMetricsRecorder}.
   */
  static MetricsRecorder getInstance(@Nonnull DatastoreOpenTelemetryOptions options) {
    boolean isMetricsEnabled = options.isMetricsEnabled();

    if (isMetricsEnabled) {
      OpenTelemetry openTelemetry = options.getOpenTelemetry();
      if (openTelemetry == null) {
        return new OpenTelemetryMetricsRecorder(GlobalOpenTelemetry.get());
      }
      return new OpenTelemetryMetricsRecorder(openTelemetry);
    } else {
      return new NoOpMetricsRecorder();
    }
  }
}
