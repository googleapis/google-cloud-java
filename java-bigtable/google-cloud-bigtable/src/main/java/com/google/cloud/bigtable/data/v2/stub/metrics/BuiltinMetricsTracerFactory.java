/*
 * Copyright 2022 Google LLC
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

import com.google.api.core.InternalApi;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.BaseApiTracerFactory;
import com.google.api.gax.tracing.SpanName;
import com.google.cloud.bigtable.stats.StatsWrapper;
import com.google.common.collect.ImmutableMap;

/**
 * {@link ApiTracerFactory} that will generate OpenCensus metrics by using the {@link ApiTracer}
 * api.
 */
@InternalApi("For internal use only")
public class BuiltinMetricsTracerFactory extends BaseApiTracerFactory {

  private final ImmutableMap<String, String> statsAttributes;

  public static BuiltinMetricsTracerFactory create(ImmutableMap<String, String> statsAttributes) {
    return new BuiltinMetricsTracerFactory(statsAttributes);
  }

  private BuiltinMetricsTracerFactory(ImmutableMap<String, String> statsAttributes) {
    this.statsAttributes = statsAttributes;
  }

  @Override
  public ApiTracer newTracer(ApiTracer parent, SpanName spanName, OperationType operationType) {
    return new BuiltinMetricsTracer(
        operationType,
        spanName,
        StatsWrapper.createRecorder(operationType, spanName, statsAttributes));
  }
}
