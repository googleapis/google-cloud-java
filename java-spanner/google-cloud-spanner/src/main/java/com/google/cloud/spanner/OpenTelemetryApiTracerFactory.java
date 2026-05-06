/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
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
import com.google.api.gax.tracing.SpanName;
import com.google.common.base.Preconditions;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import javax.annotation.Nonnull;

/** {@link ApiTracerFactory} that can be used with OpenTelemetry tracing. */
class OpenTelemetryApiTracerFactory implements ApiTracerFactory {
  @Nonnull private final Tracer internalTracer;
  @Nonnull private final Attributes spanAttributes;

  OpenTelemetryApiTracerFactory(
      @Nonnull Tracer internalTracer, @Nonnull Attributes spanAttributes) {
    this.internalTracer = Preconditions.checkNotNull(internalTracer);
    this.spanAttributes = spanAttributes;
  }

  @Override
  public ApiTracer newTracer(ApiTracer parent, SpanName spanName, OperationType operationType) {
    // Default to the current in context span. This is used for outermost tracers that inherit
    // the caller's parent span.
    Span parentSpan = Span.current();

    // If an outer callable started a span, use it as the parent.
    if (parent instanceof OpenTelemetryApiTracer) {
      parentSpan = ((OpenTelemetryApiTracer) parent).getSpan();
    }

    Span span =
        internalTracer
            .spanBuilder(spanName.toString())
            .setParent(Context.current().with(parentSpan))
            .setAllAttributes(spanAttributes)
            .startSpan();

    return new OpenTelemetryApiTracer(span, operationType);
  }
}
