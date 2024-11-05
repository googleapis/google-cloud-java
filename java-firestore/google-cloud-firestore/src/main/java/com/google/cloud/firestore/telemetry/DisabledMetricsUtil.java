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

package com.google.cloud.firestore.telemetry;

import com.google.api.core.ApiFuture;
import com.google.api.gax.tracing.ApiTracerFactory;
import java.util.List;

/**
 * A fully disabled (No-op) MetricsUtil class that does not perform any metrics collection actions
 * and has near-zero overhead.
 */
class DisabledMetricsUtil implements MetricsUtil {

  class MetricsContext implements MetricsUtil.MetricsContext {

    @Override
    public <T> void recordEndToEndLatencyAtFuture(ApiFuture<T> futureValue) {}

    @Override
    public void recordEndToEndLatency() {}

    @Override
    public void recordEndToEndLatency(Throwable t) {}

    @Override
    public void recordFirstResponseLatency() {}
  }

  @Override
  public MetricsContext createMetricsContext(String methodName) {
    return new MetricsContext();
  }

  @Override
  public void addMetricsTracerFactory(List<ApiTracerFactory> apiTracerFactories) {}
}
