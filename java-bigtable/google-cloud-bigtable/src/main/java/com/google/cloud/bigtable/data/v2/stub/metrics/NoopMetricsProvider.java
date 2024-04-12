/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import com.google.common.base.MoreObjects;

/**
 * Set {@link
 * com.google.cloud.bigtable.data.v2.BigtableDataSettings.Builder#setMetricsProvider(MetricsProvider)},
 * to {@link this#INSTANCE} to disable collecting and export client side metrics
 * https://cloud.google.com/bigtable/docs/client-side-metrics.
 */
public final class NoopMetricsProvider implements MetricsProvider {

  public static NoopMetricsProvider INSTANCE = new NoopMetricsProvider();

  private NoopMetricsProvider() {}

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).toString();
  }
}
