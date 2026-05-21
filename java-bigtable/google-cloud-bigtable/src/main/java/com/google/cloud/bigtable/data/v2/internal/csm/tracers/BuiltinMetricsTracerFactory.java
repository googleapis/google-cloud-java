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
package com.google.cloud.bigtable.data.v2.internal.csm.tracers;

import com.google.api.core.InternalApi;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.BaseApiTracerFactory;
import com.google.api.gax.tracing.SpanName;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.MethodInfo;

/**
 * {@link ApiTracerFactory} that will generate OpenTelemetry metrics by using the {@link ApiTracer}
 * api.
 */
@InternalApi("For internal use only")
public class BuiltinMetricsTracerFactory extends BaseApiTracerFactory {

  private final MetricRegistry.RecorderRegistry recorder;
  private final ClientInfo clientInfo;

  public static BuiltinMetricsTracerFactory create(
      MetricRegistry.RecorderRegistry recorder, ClientInfo clientInfo) {
    return new BuiltinMetricsTracerFactory(recorder, clientInfo);
  }

  BuiltinMetricsTracerFactory(MetricRegistry.RecorderRegistry recorder, ClientInfo clientInfo) {
    this.recorder = recorder;
    this.clientInfo = clientInfo;
  }

  @Override
  public ApiTracer newTracer(ApiTracer parent, SpanName spanName, OperationType operationType) {
    MethodInfo methodInfo =
        MethodInfo.builder()
            .setName(spanName.toString())
            .setStreaming(operationType == OperationType.ServerStreaming)
            .build();
    return new BuiltinMetricsTracer(recorder, clientInfo, methodInfo);
  }
}
