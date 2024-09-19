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

import io.opentelemetry.api.OpenTelemetry;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class DatastoreOpenTelemetryOptions {
  private final boolean enabled;
  private final @Nullable OpenTelemetry openTelemetry;

  DatastoreOpenTelemetryOptions(Builder builder) {
    this.enabled = builder.enabled;
    this.openTelemetry = builder.openTelemetry;
  }

  public boolean isEnabled() {
    return enabled;
  }

  @Nullable
  public OpenTelemetry getOpenTelemetry() {
    return openTelemetry;
  }

  @Nonnull
  public DatastoreOpenTelemetryOptions.Builder toBuilder() {
    return new DatastoreOpenTelemetryOptions.Builder(this);
  }

  @Nonnull
  public static DatastoreOpenTelemetryOptions.Builder newBuilder() {
    return new DatastoreOpenTelemetryOptions.Builder();
  }

  public static class Builder {

    private boolean enabled;

    @Nullable private OpenTelemetry openTelemetry;

    private Builder() {
      enabled = false;
      openTelemetry = null;
    }

    private Builder(DatastoreOpenTelemetryOptions options) {
      this.enabled = options.enabled;
      this.openTelemetry = options.openTelemetry;
    }

    @Nonnull
    public DatastoreOpenTelemetryOptions build() {
      return new DatastoreOpenTelemetryOptions(this);
    }

    /**
     * Sets whether tracing should be enabled.
     *
     * @param enabled Whether tracing should be enabled.
     */
    @Nonnull
    public DatastoreOpenTelemetryOptions.Builder setTracingEnabled(boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Sets the {@link OpenTelemetry} to use with this Datastore instance. If telemetry collection
     * is enabled, but an `OpenTelemetry` is not provided, the Datastore SDK will attempt to use the
     * `GlobalOpenTelemetry`.
     *
     * @param openTelemetry The OpenTelemetry that should be used by this Datastore instance.
     */
    @Nonnull
    public DatastoreOpenTelemetryOptions.Builder setOpenTelemetry(
        @Nonnull OpenTelemetry openTelemetry) {
      this.openTelemetry = openTelemetry;
      return this;
    }
  }
}
