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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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

  Logger logger = Logger.getLogger(DatastoreMetricsRecorder.class.getName());

  /**
   * Releases any resources held by this recorder.
   *
   * <p>For built-in recorders that own a private {@link io.opentelemetry.sdk.OpenTelemetrySdk}
   * instance, this will flush and shut down the underlying {@link
   * io.opentelemetry.sdk.metrics.SdkMeterProvider}. For recorders backed by a user-provided {@link
   * io.opentelemetry.api.OpenTelemetry} instance, this is a no-op since the caller owns that
   * instance's lifecycle.
   *
   * <p>This method should be called from {@link com.google.cloud.datastore.DatastoreImpl#close()}.
   */
  default void close() {}

  /** Records the total latency of a transaction in milliseconds. */
  void recordTransactionLatency(double latencyMs, Map<String, String> attributes);

  /** Records the number of attempts a transaction took. */
  void recordTransactionAttemptCount(long count, Map<String, String> attributes);

  /**
   * Returns a {@link DatastoreMetricsRecorder} instance based on the provided {@link
   * DatastoreOptions}.
   *
   * <p>This factory method creates a {@link CompositeDatastoreMetricsRecorder} that delegates to
   * multiple backends:
   *
   * <ul>
   *   <li><b>Default provider</b>: Always exports metrics to Google Cloud Monitoring via a
   *       privately-constructed {@link io.opentelemetry.sdk.OpenTelemetrySdk} with a {@link
   *       DatastoreCloudMonitoringExporter}, unless explicitly disabled via {@link
   *       DatastoreOpenTelemetryOptions#isExportBuiltinMetricsToGoogleCloudMonitoring()}.
   *   <li><b>Custom provider</b>: If the user has enabled metrics and provided an {@link
   *       OpenTelemetry} instance (or {@link GlobalOpenTelemetry} is used as fallback), metrics are
   *       also recorded to that backend.
   * </ul>
   *
   * @param options the {@link DatastoreOptions} configuring the Datastore client
   * @param builtInOtel the {@link OpenTelemetry} built in Otel object
   * @return a {@link DatastoreMetricsRecorder} that fans out to all configured backends
   */
  static DatastoreMetricsRecorder getInstance(
      @Nonnull DatastoreOptions options, OpenTelemetry builtInOtel) {
    List<DatastoreMetricsRecorder> recorders = new ArrayList<>();

    // No need to send metrics when using an emulator
    String emulatorHost = System.getenv(DatastoreOptions.LOCAL_HOST_ENV_VAR);
    boolean emulatorEnabled = emulatorHost != null && !emulatorHost.isEmpty();

    if (emulatorEnabled) {
      logger.log(Level.FINE, "Emulator detected in Datastore. Metrics are not being recorded.");
      return new CompositeDatastoreMetricsRecorder(recorders);
    }

    DatastoreOpenTelemetryOptions otelOptions = options.getOpenTelemetryOptions();

    // When using a local emulator, there is no need to configure a built-in Otel instance
    if (otelOptions.isExportBuiltinMetricsToGoogleCloudMonitoring()) {
      try {
        if (builtInOtel != null) {
          recorders.add(
              new OpenTelemetryDatastoreMetricsRecorder(
                  builtInOtel, TelemetryConstants.METRIC_PREFIX));
        }
      } catch (Exception e) {
        logger.log(
            Level.WARNING,
            "Failed to create built-in metrics provider for Cloud Monitoring exporting.",
            e);
      }
    }

    // If the user has enabled metrics, we will attempt to export metrics to their
    // configured backend. We will first check their supplied Otel object, then check
    // the global Otel config.
    // Note: Metrics will not be sent if an emulator is enabled.
    if (otelOptions.isMetricsEnabled()) {
      OpenTelemetry customOtel = otelOptions.getOpenTelemetry();
      if (customOtel.getMeterProvider() == OpenTelemetry.noop().getMeterProvider()) {
        customOtel = GlobalOpenTelemetry.get();
      }
      recorders.add(
          new OpenTelemetryDatastoreMetricsRecorder(customOtel, TelemetryConstants.METRIC_PREFIX));
    }

    return new CompositeDatastoreMetricsRecorder(recorders);
  }
}
