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
  private final boolean tracingEnabled;
  private final @Nullable OpenTelemetry openTelemetry;

  FirestoreOpenTelemetryOptions(Builder builder) {
    this.tracingEnabled = builder.tracingEnabled;
    this.openTelemetry = builder.openTelemetry;
  }

  /**
   * @deprecated This method will be removed in the next minor version update. Please use a no-op
   *     TracerProvider or set the environment variable `FIRESTORE_ENABLE_TRACING=OFF` to disable
   *     tracing. If the GlobalOpenTelemetry or the OpenTelemetry instance passed to Firestore
   *     contain a valid TracerProvider, the Firestore client will generate spans by utilizing it.
   */
  @Deprecated
  public boolean isTracingEnabled() {
    return tracingEnabled;
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

    private boolean tracingEnabled;

    @Nullable private OpenTelemetry openTelemetry;

    private Builder() {
      tracingEnabled = false;
      openTelemetry = null;
    }

    private Builder(FirestoreOpenTelemetryOptions options) {
      this.tracingEnabled = options.tracingEnabled;
      this.openTelemetry = options.openTelemetry;
    }

    @Nonnull
    public FirestoreOpenTelemetryOptions build() {
      return new FirestoreOpenTelemetryOptions(this);
    }

    /**
     * Sets whether tracing should be enabled.
     *
     * @param tracingEnabled Whether tracing should be enabled.
     * @deprecated This method will be removed in the next minor version update. Please use a no-op
     *     TracerProvider or set the environment variable `FIRESTORE_ENABLE_TRACING=OFF` to disable
     *     tracing. If the GlobalOpenTelemetry or the OpenTelemetry instance passed to Firestore
     *     contains a valid TracerProvider, the Firestore client will generate spans by utilizing
     *     it.
     */
    @Deprecated
    @Nonnull
    public FirestoreOpenTelemetryOptions.Builder setTracingEnabled(boolean tracingEnabled) {
      this.tracingEnabled = tracingEnabled;
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
