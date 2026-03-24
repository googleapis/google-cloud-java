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

package com.google.cloud.spanner;

import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;

class BuiltInMetricsView {

  private BuiltInMetricsView() {}

  /** Register built-in metrics on the {@link SdkMeterProviderBuilder} with credentials. */
  static void registerBuiltinMetrics(
      MetricExporter metricExporter, SdkMeterProviderBuilder builder) {
    BuiltInMetricsConstant.getAllViews().forEach(builder::registerView);
    builder.registerMetricReader(PeriodicMetricReader.create(metricExporter));
  }
}
