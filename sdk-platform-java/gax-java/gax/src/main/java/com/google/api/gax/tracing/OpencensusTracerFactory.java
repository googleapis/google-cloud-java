/*
 * Copyright 2019 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.tracing;

import com.google.api.core.InternalApi;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import java.util.Map;
import javax.annotation.Nonnull;

/**
 * A {@link ApiTracerFactory} to build instances of {@link OpencensusTracer}.
 *
 * <p>This class wraps the {@link Tracer} provided by Opencensus in {@code Tracing.getTracer()}. It
 * will be used to create new spans and wrap them in {@link OpencensusTracer} defined in gax.
 *
 * <p>This class is thread safe.
 */
@InternalApi("For google-cloud-java client use only")
public final class OpencensusTracerFactory extends BaseApiTracerFactory {
  @Nonnull private final Tracer internalTracer;
  @Nonnull private final Map<String, AttributeValue> spanAttributes;

  /**
   * Instantiates a new instance capturing the {@link io.opencensus.trace.Tracer} in {@code
   * Tracing.getTracer}.
   */
  public OpencensusTracerFactory() {
    this(ImmutableMap.<String, String>of());
  }

  /**
   * Instantiates a new instance capturing the {@link io.opencensus.trace.Tracer} in {@code
   * Tracing.getTracer}. It will also override the service name of the grpc stub with a custom
   * client name. This is useful disambiguate spans created outer manual written wrappers and around
   * generated gapic spans.
   *
   * @param spanAttributes the attributes to stamp on every span. Should include things like library
   *     version.
   */
  public OpencensusTracerFactory(Map<String, String> spanAttributes) {
    this(Tracing.getTracer(), spanAttributes);
  }

  /**
   * Instantiates a new instance with an explicit {@link io.opencensus.trace.Tracer}. It will also
   * override the service name of the grpc stub with a custom client name. This is useful
   * disambiguate spans created outer manual written wrappers and around generated gapic spans.
   *
   * @param internalTracer the Opencensus tracer to wrap.
   */
  @InternalApi("Visible for testing")
  OpencensusTracerFactory(Tracer internalTracer, @Nonnull Map<String, String> spanAttributes) {
    this.internalTracer =
        Preconditions.checkNotNull(internalTracer, "internalTracer can't be null");
    ImmutableMap.Builder<String, AttributeValue> formattedSpanAttributes = ImmutableMap.builder();
    for (Map.Entry<String, String> entry : spanAttributes.entrySet()) {
      formattedSpanAttributes.put(
          entry.getKey(), AttributeValue.stringAttributeValue(entry.getValue()));
    }
    this.spanAttributes = formattedSpanAttributes.build();
  }

  /** {@inheritDoc } */
  @Override
  public ApiTracer newTracer(ApiTracer parent, SpanName spanName, OperationType operationType) {
    // Default to the current in context span. This is used for outermost tracers that inherit
    // the caller's parent span.
    Span parentSpan = internalTracer.getCurrentSpan();

    // If an outer callable started a span, use it as the parent.
    if (parent instanceof OpencensusTracer) {
      parentSpan = ((OpencensusTracer) parent).getSpan();
    }

    Span span =
        internalTracer
            .spanBuilderWithExplicitParent(spanName.toString(), parentSpan)
            .setRecordEvents(true)
            .startSpan();
    span.putAttributes(spanAttributes);

    return new OpencensusTracer(internalTracer, span, operationType);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OpencensusTracerFactory that = (OpencensusTracerFactory) o;
    return Objects.equal(internalTracer, that.internalTracer)
        && Objects.equal(spanAttributes, that.spanAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(internalTracer, spanAttributes);
  }
}
