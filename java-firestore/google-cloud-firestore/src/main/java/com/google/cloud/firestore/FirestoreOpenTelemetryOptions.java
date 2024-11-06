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

package com.google.cloud.firestore;

import com.google.api.core.BetaApi;
import io.opentelemetry.api.OpenTelemetry;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents the options that are used to configure the use of OpenTelemetry for telemetry
 * collection in the Firestore SDK.
 */
@BetaApi
public class FirestoreOpenTelemetryOptions {
  private final boolean exportBuiltinMetricsToGoogleCloudMonitoring;
  private final @Nullable OpenTelemetry openTelemetry;

  FirestoreOpenTelemetryOptions(Builder builder) {
    this.exportBuiltinMetricsToGoogleCloudMonitoring =
        builder.exportBuiltinMetricsToGoogleCloudMonitoring;
    this.openTelemetry = builder.openTelemetry;
  }

  public boolean exportBuiltinMetricsToGoogleCloudMonitoring() {
    return exportBuiltinMetricsToGoogleCloudMonitoring;
  }

  public OpenTelemetry getOpenTelemetry() {
    return openTelemetry;
  }

  @Nonnull
  public FirestoreOpenTelemetryOptions.Builder toBuilder() {
    return new FirestoreOpenTelemetryOptions.Builder(this);
  }

  @Nonnull
  public static FirestoreOpenTelemetryOptions.Builder newBuilder() {
    return new FirestoreOpenTelemetryOptions.Builder();
  }

  public static class Builder {
    private boolean exportBuiltinMetricsToGoogleCloudMonitoring;
    @Nullable private OpenTelemetry openTelemetry;

    private Builder() {
      // TODO(metrics): default this to true when feature is ready
      exportBuiltinMetricsToGoogleCloudMonitoring = false;
      openTelemetry = null;
    }

    private Builder(FirestoreOpenTelemetryOptions options) {
      this.exportBuiltinMetricsToGoogleCloudMonitoring =
          options.exportBuiltinMetricsToGoogleCloudMonitoring;
      this.openTelemetry = options.openTelemetry;
    }

    @Nonnull
    public FirestoreOpenTelemetryOptions build() {
      return new FirestoreOpenTelemetryOptions(this);
    }

    // TODO(metrics): make this public when feature is ready.
    /**
     * Sets whether built-in metrics should be exported to Google Cloud Monitoring
     *
     * @param exportBuiltinMetrics Whether built-in metrics should be exported to Google Cloud
     *     Monitoring.
     */
    @Nonnull
    private FirestoreOpenTelemetryOptions.Builder exportBuiltinMetricsToGoogleCloudMonitoring(
        boolean exportBuiltinMetrics) {
      this.exportBuiltinMetricsToGoogleCloudMonitoring = exportBuiltinMetrics;
      return this;
    }

    /**
     * Sets the {@link OpenTelemetry} to use with this Firestore instance. If telemetry collection
     * is enabled, but an `OpenTelemetry` is not provided, the Firestore SDK will attempt to use the
     * `GlobalOpenTelemetry`.
     *
     * @param openTelemetry The OpenTelemetry that should be used by this Firestore instance.
     */
    @Nonnull
    public FirestoreOpenTelemetryOptions.Builder setOpenTelemetry(
        @Nonnull OpenTelemetry openTelemetry) {
      this.openTelemetry = openTelemetry;
      return this;
    }
  }
}
