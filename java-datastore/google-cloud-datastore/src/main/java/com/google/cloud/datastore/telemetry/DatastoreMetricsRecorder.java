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

import com.google.api.core.InternalExtensionOnly;
import com.google.api.gax.tracing.MetricsRecorder;
import com.google.cloud.datastore.DatastoreOpenTelemetryOptions;
import com.google.cloud.datastore.DatastoreOptions;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import java.util.Map;
import javax.annotation.Nonnull;

/**
 * Interface to record Datastore-specific and standard RPC metrics.
 *
 * <p>This interface extends {@link MetricsRecorder} from the GAX library to provide a unified
 * recording contract that covers both generic RPC metrics (like latency and attempt counts) and
 * Datastore-specific operations (like transactions).
 *
 * <p><b>Warning:</b> This is intended to be an internal API and is not intended for external use.
 * This is public solely for implementation purposes and does not promise any backwards
 * compatibility.
 */
@InternalExtensionOnly
public interface DatastoreMetricsRecorder extends MetricsRecorder {

  /** Records the total latency of a transaction in milliseconds. */
  void recordTransactionLatency(double latencyMs, Map<String, String> attributes);

  /** Records the number of attempts a transaction took. */
  void recordTransactionAttemptCount(long count, Map<String, String> attributes);

  /**
   * Returns a {@link DatastoreMetricsRecorder} instance based on the provided {@link
   * DatastoreOptions}.
   *
   * <p>If the user has enabled metrics and provided an {@link OpenTelemetry} instance (or {@link
   * GlobalOpenTelemetry} is used as fallback), an {@link OpenTelemetryDatastoreMetricsRecorder} is
   * returned. Otherwise a {@link NoOpDatastoreMetricsRecorder} is returned.
   *
   * @param datastoreOptions the {@link DatastoreOptions} configuring the Datastore client
   * @return a {@link DatastoreMetricsRecorder} for the configured backend
   */
  static DatastoreMetricsRecorder getInstance(@Nonnull DatastoreOptions datastoreOptions) {
    DatastoreOpenTelemetryOptions otelOptions = datastoreOptions.getOpenTelemetryOptions();

    if (otelOptions.isMetricsEnabled()) {
      OpenTelemetry customOtel = otelOptions.getOpenTelemetry();
      if (customOtel == null) {
        customOtel = GlobalOpenTelemetry.get();
      }
      return new OpenTelemetryDatastoreMetricsRecorder(
          customOtel, TelemetryConstants.METRIC_PREFIX);
    }

    return new NoOpDatastoreMetricsRecorder();
  }
}
