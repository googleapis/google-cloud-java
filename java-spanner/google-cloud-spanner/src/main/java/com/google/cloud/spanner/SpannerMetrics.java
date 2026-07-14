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

package com.google.cloud.spanner;

import com.google.common.base.Preconditions;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;

/** Utility methods for configuring Spanner client metrics. */
public final class SpannerMetrics {
  private SpannerMetrics() {}

  /**
   * Applies the Spanner client-metrics views to a caller-owned {@link SdkMeterProviderBuilder}.
   * Recommended (but not required) when using {@link CustomOpenTelemetryMetricsProvider}: the views
   * rename the raw instruments to the exported {@code spanner/client/...} metric names, apply the
   * Spanner latency histogram bucket boundaries, and restrict the recorded attributes to the
   * supported client-metric labels. Without the views, metrics are still recorded with the raw
   * instrument names, default buckets and unfiltered attributes.
   *
   * <p>Use a dedicated {@link SdkMeterProviderBuilder} (and resulting meter provider) for the
   * Spanner client metrics, not one that is shared with other instrumentation. Some of the
   * registered views select generic gRPC instruments (for example {@code
   * grpc.client.attempt.duration} on the {@code grpc-java} meter), so on a shared meter provider
   * they would also rename metrics recorded by unrelated gRPC clients into the {@code
   * spanner/client} namespace and filter their attributes down to the Spanner client-metric labels.
   *
   * <p>Register the views at most once per {@link SdkMeterProviderBuilder}.
   */
  public static void configureMeterProviderBuilder(SdkMeterProviderBuilder meterProviderBuilder) {
    Preconditions.checkNotNull(meterProviderBuilder, "meterProviderBuilder cannot be null");
    BuiltInMetricsConstant.getCustomExportViews().forEach(meterProviderBuilder::registerView);
  }
}
