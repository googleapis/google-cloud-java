/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.grpc.fallback;

import static com.google.cloud.grpc.GrpcGcpUtil.IMPLEMENTATION_VERSION;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * The entrypoint for OpenTelemetry metrics functionality in gRPC-GCP Fallback channel.
 *
 * <p>GcpFallbackOpenTelemetry uses {@link io.opentelemetry.api.OpenTelemetry} APIs for
 * instrumentation. When no SDK is explicitly added no telemetry data will be collected. See {@code
 * io.opentelemetry.sdk.OpenTelemetrySdk} for information on how to construct the SDK.
 */
public final class GcpFallbackOpenTelemetry {
  static final String INSTRUMENTATION_SCOPE = "grpc-gcp";
  static final String METRIC_PREFIX = "eef";

  static final String CURRENT_CHANNEL_METRIC = "current_channel";
  static final String FALLBACK_COUNT_METRIC = "fallback_count";
  static final String CALL_STATUS_METRIC = "call_status";
  static final String ERROR_RATIO_METRIC = "error_ratio";
  static final String PROBE_RESULT_METRIC = "probe_result";
  static final String CHANNEL_DOWNTIME_METRIC = "channel_downtime";

  static final AttributeKey<String> CHANNEL_NAME = AttributeKey.stringKey("channel_name");
  static final AttributeKey<String> FROM_CHANNEL_NAME = AttributeKey.stringKey("from_channel_name");
  static final AttributeKey<String> TO_CHANNEL_NAME = AttributeKey.stringKey("to_channel_name");
  static final AttributeKey<String> STATUS_CODE = AttributeKey.stringKey("status_code");
  static final AttributeKey<String> PROBE_RESULT = AttributeKey.stringKey("result");

  static final ImmutableSet<String> DEFAULT_METRICS_SET =
      ImmutableSet.of(
          CURRENT_CHANNEL_METRIC,
          FALLBACK_COUNT_METRIC,
          CALL_STATUS_METRIC,
          ERROR_RATIO_METRIC,
          PROBE_RESULT_METRIC,
          CHANNEL_DOWNTIME_METRIC);

  private final OpenTelemetry openTelemetrySdk;
  private final MeterProvider meterProvider;
  private final Meter meter;
  private final Map<String, Boolean> enableMetrics;
  private final boolean disableDefault;
  private final OpenTelemetryMetricsModule openTelemetryMetricsModule;

  public static Builder newBuilder() {
    return new Builder();
  }

  private GcpFallbackOpenTelemetry(Builder builder) {
    this.openTelemetrySdk = checkNotNull(builder.openTelemetrySdk, "openTelemetrySdk");
    this.meterProvider = checkNotNull(openTelemetrySdk.getMeterProvider(), "meterProvider");
    this.meter =
        this.meterProvider
            .meterBuilder(INSTRUMENTATION_SCOPE)
            .setInstrumentationVersion(IMPLEMENTATION_VERSION)
            .build();
    this.enableMetrics = ImmutableMap.copyOf(builder.enableMetrics);
    this.disableDefault = builder.disableAll;
    this.openTelemetryMetricsModule =
        new OpenTelemetryMetricsModule(meter, enableMetrics, disableDefault);
  }

  /** Builder for configuring {@link GcpFallbackOpenTelemetry}. */
  public static class Builder {
    private OpenTelemetry openTelemetrySdk = OpenTelemetry.noop();
    private final Map<String, Boolean> enableMetrics = new HashMap<>();
    private boolean disableAll;

    private Builder() {}

    /**
     * Sets the {@link io.opentelemetry.api.OpenTelemetry} entrypoint to use. This can be used to
     * configure OpenTelemetry by returning the instance created by a {@code
     * io.opentelemetry.sdk.OpenTelemetrySdkBuilder}.
     */
    public Builder withSdk(OpenTelemetry sdk) {
      this.openTelemetrySdk = sdk;
      return this;
    }

    /**
     * Enables the specified metrics for collection and export. By default, all metrics are enabled.
     */
    public Builder enableMetrics(Collection<String> enableMetrics) {
      for (String metric : enableMetrics) {
        this.enableMetrics.put(metric, true);
      }
      return this;
    }

    /** Disables the specified metrics from being collected and exported. */
    public Builder disableMetrics(Collection<String> disableMetrics) {
      for (String metric : disableMetrics) {
        this.enableMetrics.put(metric, false);
      }
      return this;
    }

    /** Disable all metrics. Any desired metric must be explicitly enabled after this. */
    public Builder disableAllMetrics() {
      this.enableMetrics.clear();
      this.disableAll = true;
      return this;
    }

    /**
     * Returns a new {@link GcpFallbackOpenTelemetry} built with the configuration of this {@link
     * Builder}.
     */
    public GcpFallbackOpenTelemetry build() {
      return new GcpFallbackOpenTelemetry(this);
    }
  }

  OpenTelemetryMetricsModule getModule() {
    return openTelemetryMetricsModule;
  }
}
