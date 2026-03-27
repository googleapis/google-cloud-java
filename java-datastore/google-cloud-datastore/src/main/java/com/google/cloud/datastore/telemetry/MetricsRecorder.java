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
import com.google.cloud.datastore.DatastoreOpenTelemetryOptions;
import com.google.cloud.datastore.DatastoreOptions;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;

/**
 * Interface to record specific metric operations.
 *
 * <p><b>Warning:</b> This is intended to be an internal API and is not intended for external use.
 * This is public solely for implementation purposes and does not promise any backwards
 * compatibility.
 */
@InternalExtensionOnly
public interface MetricsRecorder {

  Logger logger = Logger.getLogger(MetricsRecorder.class.getName());

  /** Records the total latency of a transaction in milliseconds. */
  void recordTransactionLatency(double latencyMs, Map<String, String> attributes);

  /** Records the number of attempts a transaction took. */
  void recordTransactionAttemptCount(long count, Map<String, String> attributes);

  /** Records the latency of a single RPC attempt in milliseconds. */
  void recordAttemptLatency(double latencyMs, Map<String, String> attributes);

  /** Records the count of a single RPC attempt. */
  void recordAttemptCount(long count, Map<String, String> attributes);

  /** Records the total latency of an operation (including retries) in milliseconds. */
  void recordOperationLatency(double latencyMs, Map<String, String> attributes);

  /** Records the count of an operation. */
  void recordOperationCount(long count, Map<String, String> attributes);

  /**
   * Returns a {@link MetricsRecorder} instance based on the provided {@link DatastoreOptions}.
   *
   * <p>This factory method creates a {@link CompositeMetricsRecorder} that delegates to multiple
   * backends:
   *
   * <ul>
   *   <li><b>Default provider</b>: Always exports metrics to Google Cloud Monitoring via a
   *       privately-constructed {@link OpenTelemetrySdk} with a {@link
   *       DatastoreCloudMonitoringExporter}, unless explicitly disabled via {@link
   *       DatastoreOpenTelemetryOptions#isExportBuiltinMetricsToGoogleCloudMonitoring()}.
   *   <li><b>Custom provider</b>: If the user has enabled metrics and provided an {@link
   *       OpenTelemetry} instance (or {@link GlobalOpenTelemetry} is used as fallback), metrics are
   *       also recorded to that backend.
   * </ul>
   *
   * @param datastoreOptions the {@link DatastoreOptions} configuring the Datastore client
   * @return a {@link MetricsRecorder} that fans out to all configured backends
   */
  static MetricsRecorder getInstance(@Nonnull DatastoreOptions datastoreOptions) {
    DatastoreOpenTelemetryOptions otelOptions = datastoreOptions.getOpenTelemetryOptions();
    List<MetricsRecorder> recorders = new ArrayList<>();

    // Default provider: export built-in metrics to Cloud Monitoring
    String emulatorHost = System.getenv(DatastoreOptions.LOCAL_HOST_ENV_VAR);
    boolean emulatorEnabled = emulatorHost != null && !emulatorHost.isEmpty();
    String metricsEnvVar = System.getenv(TelemetryConstants.ENABLE_METRICS_ENV_VAR);
    boolean metricsDisabledViaEnv = "false".equalsIgnoreCase(metricsEnvVar);

    if (otelOptions.isExportBuiltinMetricsToGoogleCloudMonitoring()
        && !emulatorEnabled
        && !metricsDisabledViaEnv) {
      try {
        OpenTelemetry builtInOtel =
            BuiltInMetricsProvider.INSTANCE.getOrCreateOpenTelemetry(
                datastoreOptions.getProjectId(), datastoreOptions.getCredentials());
        if (builtInOtel != null) {
          recorders.add(
              new OpenTelemetryMetricsRecorder(builtInOtel, TelemetryConstants.METRIC_PREFIX));
        }
      } catch (Exception e) {
        logger.log(
            Level.WARNING,
            "Failed to create built-in metrics provider for Cloud Monitoring export.",
            e);
      }
    }

    // Custom provider: export metrics to user-provided OpenTelemetry backend
    if (otelOptions.isMetricsEnabled()) {
      OpenTelemetry customOtel = otelOptions.getOpenTelemetry();
      if (customOtel == null) {
        customOtel = GlobalOpenTelemetry.get();
      }
      recorders.add(new OpenTelemetryMetricsRecorder(customOtel));
    }

    if (recorders.isEmpty()) {
      return new NoOpMetricsRecorder();
    }
    if (recorders.size() == 1) {
      return recorders.get(0);
    }
    return new CompositeMetricsRecorder(recorders);
  }

}
