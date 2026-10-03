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

import com.google.api.core.InternalExtensionOnly;

/**
 * Provider for Spanner client metrics exported to a caller-owned OpenTelemetry destination. This is
 * independent of the built-in Cloud Monitoring export controlled by {@link
 * SpannerOptions.Builder#setBuiltInMetricsEnabled(boolean)}.
 *
 * <p>The available providers are:
 *
 * <ul>
 *   <li>{@link DefaultMetricsProvider}: No caller-owned client-metrics destination is configured.
 *       This is the default. On {@link SpannerOptions.InstanceType#OMNI}, where the Cloud
 *       Monitoring export is not available, this means no client metrics are exported.
 *   <li>{@link NoopMetricsProvider}: Caller-owned client metrics are explicitly disabled. The Cloud
 *       Monitoring export is controlled separately.
 *   <li>{@link CustomOpenTelemetryMetricsProvider}: The same Spanner client instruments are
 *       recorded on a caller-provided {@link io.opentelemetry.api.OpenTelemetry} instance.
 * </ul>
 */
@InternalExtensionOnly
public interface MetricsProvider {}
