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

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import com.google.common.collect.ImmutableMap;
import io.grpc.Context;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.SpanBuilder;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.unsafe.ContextUtils;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OpencensusTracerFactoryTest {
  @Mock private Tracer internalTracer;
  @Mock private SpanBuilder spanBuilder;
  @Mock private Span span;
  private final Map<String, String> defaultSpanAttributes = ImmutableMap.of();

  @BeforeEach
  void setUp() {
    when(internalTracer.spanBuilderWithExplicitParent(anyString(), nullable(Span.class)))
        .thenReturn(spanBuilder);

    when(spanBuilder.setRecordEvents(true)).thenReturn(spanBuilder);

    when(spanBuilder.startSpan()).thenReturn(span);
  }

  @Test
  void testSpanNamePassthrough() {
    OpencensusTracerFactory factory =
        new OpencensusTracerFactory(internalTracer, ImmutableMap.<String, String>of());

    factory.newTracer(
        BaseApiTracer.getInstance(), SpanName.of("FakeClient", "FakeMethod"), OperationType.Unary);

    verify(internalTracer)
        .spanBuilderWithExplicitParent(eq("FakeClient.FakeMethod"), nullable(Span.class));
  }

  @Test
  void testImplicitParentSpan() {
    OpencensusTracerFactory factory =
        new OpencensusTracerFactory(internalTracer, defaultSpanAttributes);

    Span parentSpan = mock(Span.class);
    Context origContext = ContextUtils.withValue(Context.current(), parentSpan).attach();

    try {
      factory.newTracer(
          BaseApiTracer.getInstance(),
          SpanName.of("FakeClient", "FakeMethod"),
          OperationType.Unary);
    } finally {
      Context.current().detach(origContext);
    }

    verify(internalTracer).spanBuilderWithExplicitParent(anyString(), same(parentSpan));
  }

  @Test
  void testExplicitParent() {
    OpencensusTracerFactory factory =
        new OpencensusTracerFactory(internalTracer, defaultSpanAttributes);

    Span parentSpan = mock(Span.class);
    OpencensusTracer parentTracer =
        new OpencensusTracer(internalTracer, parentSpan, OperationType.Unary);

    factory.newTracer(parentTracer, SpanName.of("FakeClient", "FakeMethod"), OperationType.Unary);

    verify(internalTracer).spanBuilderWithExplicitParent(anyString(), same(parentSpan));
  }

  @Test
  void testExplicitParentOverridesImplicit() {
    OpencensusTracerFactory factory =
        new OpencensusTracerFactory(internalTracer, defaultSpanAttributes);

    Span parentSpan = mock(Span.class);
    OpencensusTracer parentTracer =
        new OpencensusTracer(internalTracer, parentSpan, OperationType.Unary);

    Context origContext = ContextUtils.withValue(Context.current(), parentSpan).attach();

    try {
      factory.newTracer(parentTracer, SpanName.of("FakeClient", "FakeMethod"), OperationType.Unary);
    } finally {
      Context.current().detach(origContext);
    }

    verify(internalTracer).spanBuilderWithExplicitParent(anyString(), same(parentSpan));
  }

  @Test
  void testSpanAttributes() {
    OpencensusTracerFactory factory =
        new OpencensusTracerFactory(internalTracer, ImmutableMap.of("gax.version", "1.2.3"));

    factory.newTracer(
        BaseApiTracer.getInstance(), SpanName.of("FakeClient", "FakeMethod"), OperationType.Unary);

    verify(span, times(1))
        .putAttributes(
            ImmutableMap.of("gax.version", AttributeValue.stringAttributeValue("1.2.3")));
  }
}
