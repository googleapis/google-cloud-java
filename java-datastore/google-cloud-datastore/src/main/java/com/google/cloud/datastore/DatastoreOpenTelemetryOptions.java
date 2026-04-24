/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.datastore;

import com.google.api.core.BetaApi;
import io.opentelemetry.api.OpenTelemetry;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents the options that are used to configure the use of OpenTelemetry for telemetry
 * collection in the Datastore SDK.
 */
public class DatastoreOpenTelemetryOptions {
  private final boolean tracingEnabled;
  private final boolean metricsEnabled;
  private final boolean exportBuiltinMetricsToGoogleCloudMonitoring;
  private final @Nullable OpenTelemetry openTelemetry;

  DatastoreOpenTelemetryOptions(Builder builder) {
    this.tracingEnabled = builder.tracingEnabled;
    this.metricsEnabled = builder.metricsEnabled;
    this.exportBuiltinMetricsToGoogleCloudMonitoring =
        builder.exportBuiltinMetricsToGoogleCloudMonitoring;
    this.openTelemetry = builder.openTelemetry;
  }

  /**
   * Returns whether either tracing or custom metrics (via a user-provided {@link OpenTelemetry}
   * instance) are enabled.
   *
   * <p><b>Note:</b> This method does <em>not</em> reflect the state of built-in metrics export to
   * Google Cloud Monitoring, which is controlled separately by {@link
   * #isExportBuiltinMetricsToGoogleCloudMonitoring()} and is {@code false} by default. To check
   * whether any telemetry is active, also consult that flag.
   *
   * @return {@code true} if tracing or custom OTel metrics are enabled, {@code false} otherwise.
   */
  public boolean isEnabled() {
    return tracingEnabled || metricsEnabled;
  }

  /**
   * Returns whether tracing is enabled.
   *
   * @return {@code true} if tracing is enabled, {@code false} otherwise.
   */
  public boolean isTracingEnabled() {
    return tracingEnabled;
  }

  /**
   * Returns whether metrics are enabled for the custom (user-provided) OpenTelemetry backend.
   *
   * @return {@code true} if metrics are enabled, {@code false} otherwise.
   */
  public boolean isMetricsEnabled() {
    return metricsEnabled;
  }

  /**
   * Returns whether built-in metrics should be exported to Google Cloud Monitoring.
   *
   * <p>When enabled, client-side metrics are automatically exported to Google Cloud Monitoring
   * using the Cloud Monitoring API. This is independent of the custom OpenTelemetry backend
   * configured via {@link #getOpenTelemetry()}.
   *
   * @return {@code true} if built-in metrics export to Cloud Monitoring is enabled, {@code false}
   *     otherwise.
   */
  @BetaApi
  public boolean isExportBuiltinMetricsToGoogleCloudMonitoring() {
    return exportBuiltinMetricsToGoogleCloudMonitoring;
  }

  /**
   * Returns the custom {@link OpenTelemetry} instance, if one was provided.
   *
   * @return the custom {@link OpenTelemetry} instance, or {@code null} if none was provided.
   */
  @Nullable
  public OpenTelemetry getOpenTelemetry() {
    return openTelemetry;
  }

  /**
   * Returns a new {@link Builder} initialized with the values from this options instance.
   *
   * @return a new {@link Builder}.
   */
  @Nonnull
  public DatastoreOpenTelemetryOptions.Builder toBuilder() {
    return new DatastoreOpenTelemetryOptions.Builder(this);
  }

  /**
   * Returns a new default {@link Builder}.
   *
   * @return a new {@link Builder}.
   */
  @Nonnull
  public static DatastoreOpenTelemetryOptions.Builder newBuilder() {
    return new DatastoreOpenTelemetryOptions.Builder();
  }

  public static class Builder {

    private boolean tracingEnabled;
    private boolean metricsEnabled;
    private boolean exportBuiltinMetricsToGoogleCloudMonitoring;

    @Nullable private OpenTelemetry openTelemetry;

    private Builder() {
      tracingEnabled = false;
      metricsEnabled = false;
      // TODO(b/405457573): This is disabled by default until the Firestore namespace is deployed
      exportBuiltinMetricsToGoogleCloudMonitoring = false;
      openTelemetry = null;
    }

    private Builder(DatastoreOpenTelemetryOptions options) {
      this.tracingEnabled = options.tracingEnabled;
      this.metricsEnabled = options.metricsEnabled;
      this.exportBuiltinMetricsToGoogleCloudMonitoring =
          options.exportBuiltinMetricsToGoogleCloudMonitoring;
      this.openTelemetry = options.openTelemetry;
    }

    /**
     * Sets whether tracing should be enabled.
     *
     * @param enabled Whether tracing should be enabled.
     * @return this builder instance.
     */
    @Nonnull
    public DatastoreOpenTelemetryOptions.Builder setTracingEnabled(boolean enabled) {
      this.tracingEnabled = enabled;
      return this;
    }

    /**
     * Sets whether metrics should be enabled for the custom (user-provided) OpenTelemetry backend.
     *
     * @param enabled Whether metrics should be enabled.
     * @return this builder instance.
     */
    @Nonnull
    DatastoreOpenTelemetryOptions.Builder setMetricsEnabled(boolean enabled) {
      this.metricsEnabled = enabled;
      return this;
    }

    /**
     * Sets whether built-in metrics should be exported to Google Cloud Monitoring.
     *
     * <p>When enabled, client-side metrics are automatically exported to Google Cloud Monitoring
     * using the Cloud Monitoring API. This can be disabled to prevent metrics from being sent to
     * Cloud Monitoring while still allowing metrics to flow to a custom OpenTelemetry backend.
     *
     * @param exportBuiltinMetrics Whether built-in metrics should be exported to Cloud Monitoring.
     * @return this builder instance.
     */
    @BetaApi
    public DatastoreOpenTelemetryOptions.Builder setExportBuiltinMetricsToGoogleCloudMonitoring(
        boolean exportBuiltinMetrics) {
      this.exportBuiltinMetricsToGoogleCloudMonitoring = exportBuiltinMetrics;
      return this;
    }

    /**
     * Sets the {@link OpenTelemetry} to use with this Datastore instance. If telemetry collection
     * is enabled, but an {@code OpenTelemetry} is not provided, the Datastore SDK will attempt to
     * use the {@code GlobalOpenTelemetry}.
     *
     * @param openTelemetry The OpenTelemetry that should be used by this Datastore instance.
     * @return this builder instance.
     */
    @Nonnull
    public DatastoreOpenTelemetryOptions.Builder setOpenTelemetry(
        @Nonnull OpenTelemetry openTelemetry) {
      this.openTelemetry = openTelemetry;
      return this;
    }

    /**
     * Builds a new {@link DatastoreOpenTelemetryOptions} instance from this builder.
     *
     * @return a new {@link DatastoreOpenTelemetryOptions}.
     */
    @Nonnull
    public DatastoreOpenTelemetryOptions build() {
      return new DatastoreOpenTelemetryOptions(this);
    }
  }
}
