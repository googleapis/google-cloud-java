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

/**
 * The default {@link MetricsProvider}: no caller-owned client-metrics destination is configured.
 * Built-in Cloud Monitoring export is controlled separately by {@link
 * SpannerOptions.Builder#setBuiltInMetricsEnabled(boolean)} and the {@code
 * SPANNER_DISABLE_BUILTIN_METRICS} environment variable.
 */
public final class DefaultMetricsProvider implements MetricsProvider {

  public static final DefaultMetricsProvider INSTANCE = new DefaultMetricsProvider();

  private DefaultMetricsProvider() {}
}
