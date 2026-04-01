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

import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.MethodName;
import com.google.api.gax.tracing.MetricsTracer;
import com.google.api.gax.tracing.MetricsTracerFactory;
import com.google.api.gax.tracing.SpanName;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

/**
 * A {@link ApiTracerFactory} to build instances of {@link MetricsTracer}.
 *
 * <p>This class extends the {@link MetricsTracerFactory} which wraps the {@link
 * BuiltInMetricsRecorder} and pass it to {@link BuiltInMetricsTracer}. It will be * used to record
 * metrics in {@link BuiltInMetricsTracer}.
 *
 * <p>This class is expected to be initialized once during client initialization.
 */
class BuiltInMetricsTracerFactory extends MetricsTracerFactory {

  protected BuiltInMetricsRecorder builtInMetricsRecorder;
  private final Map<String, String> attributes;
  private final TraceWrapper traceWrapper;

  /**
   * Pass in a Map of client level attributes which will be added to every single MetricsTracer
   * created from the ApiTracerFactory.
   */
  public BuiltInMetricsTracerFactory(
      BuiltInMetricsRecorder builtInMetricsRecorder,
      Map<String, String> attributes,
      TraceWrapper traceWrapper) {
    super(builtInMetricsRecorder, attributes);
    this.builtInMetricsRecorder = builtInMetricsRecorder;
    this.attributes = ImmutableMap.copyOf(attributes);
    this.traceWrapper = traceWrapper;
  }

  @Override
  public ApiTracer newTracer(ApiTracer parent, SpanName spanName, OperationType operationType) {
    ISpan currentSpan = this.traceWrapper.getCurrentSpan();
    BuiltInMetricsTracer metricsTracer =
        new BuiltInMetricsTracer(
            MethodName.of(spanName.getClientName(), spanName.getMethodName()),
            builtInMetricsRecorder,
            this.traceWrapper,
            currentSpan);
    metricsTracer.addAttributes(attributes);
    return metricsTracer;
  }
}
