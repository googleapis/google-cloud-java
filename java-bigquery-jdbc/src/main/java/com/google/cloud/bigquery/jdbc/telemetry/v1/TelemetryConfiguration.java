/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.telemetry.v1;

import java.util.Objects;

/** Configuration settings for the BigQuery JDBC driver telemetry client. */
final class TelemetryConfiguration {
  static final boolean DEFAULT_ENABLED = true;
  // TODO: change DEFAULT_LOG_SOURCE value once the value is assigned.
  static final int DEFAULT_LOG_SOURCE = -1;
  static final String DEFAULT_ENDPOINT_URL = "https://play.googleapis.com/log";
  static final long DEFAULT_UPLOAD_INTERVAL_MS = 300_000L;
  static final int DEFAULT_BATCH_SIZE_THRESHOLD = 5000;

  private final boolean enabled;
  private final int logSource;
  private final String endpointUrl;
  private final long uploadIntervalMs;
  private final int batchSizeThreshold;
  private final DriverEnvironment driverEnvironment;

  private TelemetryConfiguration(Builder builder) {
    this.enabled = builder.enabled;
    this.logSource = builder.logSource;
    this.endpointUrl = builder.endpointUrl;
    this.uploadIntervalMs = builder.uploadIntervalMs;
    this.batchSizeThreshold = builder.batchSizeThreshold;
    this.driverEnvironment = builder.driverEnvironment;
  }

  boolean isEnabled() {
    return enabled;
  }

  int getLogSource() {
    return logSource;
  }

  String getEndpointUrl() {
    return endpointUrl;
  }

  long getUploadIntervalMs() {
    return uploadIntervalMs;
  }

  int getBatchSizeThreshold() {
    return batchSizeThreshold;
  }

  DriverEnvironment getDriverEnvironment() {
    return driverEnvironment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelemetryConfiguration that = (TelemetryConfiguration) o;
    return enabled == that.enabled
        && logSource == that.logSource
        && uploadIntervalMs == that.uploadIntervalMs
        && batchSizeThreshold == that.batchSizeThreshold
        && Objects.equals(endpointUrl, that.endpointUrl)
        && Objects.equals(driverEnvironment, that.driverEnvironment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        enabled, logSource, endpointUrl, uploadIntervalMs, batchSizeThreshold, driverEnvironment);
  }

  @Override
  public String toString() {
    return "TelemetryConfiguration{"
        + "enabled="
        + enabled
        + ", logSource="
        + logSource
        + ", endpointUrl='"
        + endpointUrl
        + '\''
        + ", uploadIntervalMs="
        + uploadIntervalMs
        + ", batchSizeThreshold="
        + batchSizeThreshold
        + ", driverEnvironment="
        + driverEnvironment
        + '}';
  }

  static Builder newBuilder() {
    return new Builder();
  }

  /** Builder for {@link TelemetryConfiguration}. */
  static class Builder {
    private boolean enabled = DEFAULT_ENABLED;
    private int logSource = DEFAULT_LOG_SOURCE;
    private String endpointUrl = DEFAULT_ENDPOINT_URL;
    private long uploadIntervalMs = DEFAULT_UPLOAD_INTERVAL_MS;
    private int batchSizeThreshold = DEFAULT_BATCH_SIZE_THRESHOLD;
    private DriverEnvironment driverEnvironment;

    Builder setEnabled(boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    Builder setLogSource(int logSource) {
      this.logSource = logSource;
      return this;
    }

    Builder setEndpointUrl(String endpointUrl) {
      this.endpointUrl = endpointUrl;
      return this;
    }

    Builder setUploadIntervalMs(long uploadIntervalMs) {
      this.uploadIntervalMs = uploadIntervalMs;
      return this;
    }

    Builder setBatchSizeThreshold(int batchSizeThreshold) {
      this.batchSizeThreshold = batchSizeThreshold;
      return this;
    }

    Builder setDriverEnvironment(DriverEnvironment driverEnvironment) {
      this.driverEnvironment = driverEnvironment;
      return this;
    }

    TelemetryConfiguration build() {
      return new TelemetryConfiguration(this);
    }
  }
}
