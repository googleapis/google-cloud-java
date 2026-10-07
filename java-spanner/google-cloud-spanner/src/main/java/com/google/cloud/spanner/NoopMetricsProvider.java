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
 * A {@link MetricsProvider} that disables caller-owned client-metrics export. This does not affect
 * the built-in Cloud Monitoring export controlled by {@link
 * SpannerOptions.Builder#setBuiltInMetricsEnabled(boolean)}.
 */
public final class NoopMetricsProvider implements MetricsProvider {

  public static final NoopMetricsProvider INSTANCE = new NoopMetricsProvider();

  private NoopMetricsProvider() {}
}
