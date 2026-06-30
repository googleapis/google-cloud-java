/*
 * Copyright 2026 Google LLC
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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompositeTracerFactoryTest {

  private ApiTracerFactory childFactory1;
  private ApiTracerFactory childFactory2;
  private CompositeTracerFactory compositeFactory;

  @BeforeEach
  void setUp() {
    childFactory1 = mock(ApiTracerFactory.class);
    childFactory2 = mock(ApiTracerFactory.class);
    compositeFactory = new CompositeTracerFactory(Arrays.asList(childFactory1, childFactory2));
  }

  @Test
  void testNewTracerWithParentAndSpanName() {
    ApiTracer parent = mock(ApiTracer.class);
    SpanName spanName = SpanName.of("TestClient", "TestMethod");
    ApiTracerFactory.OperationType operationType = ApiTracerFactory.OperationType.Unary;

    ApiTracer tracer1 = mock(ApiTracer.class);
    ApiTracer tracer2 = mock(ApiTracer.class);

    when(childFactory1.newTracer(parent, spanName, operationType)).thenReturn(tracer1);
    when(childFactory2.newTracer(parent, spanName, operationType)).thenReturn(tracer2);

    ApiTracer compositeTracer = compositeFactory.newTracer(parent, spanName, operationType);

    // Verify that the composite delegates operation succeeded to its internal children
    compositeTracer.operationSucceeded();

    verify(childFactory1).newTracer(parent, spanName, operationType);
    verify(childFactory2).newTracer(parent, spanName, operationType);
    verify(tracer1).operationSucceeded();
    verify(tracer2).operationSucceeded();
  }

  @Test
  void testNewTracerWithApiTracerContext() {
    ApiTracer parent = mock(ApiTracer.class);
    ApiTracerContext context = ApiTracerContext.empty();

    ApiTracer tracer1 = mock(ApiTracer.class);
    ApiTracer tracer2 = mock(ApiTracer.class);

    when(childFactory1.newTracer(parent, context)).thenReturn(tracer1);
    when(childFactory2.newTracer(parent, context)).thenReturn(tracer2);

    ApiTracer compositeTracer = compositeFactory.newTracer(parent, context);

    // Verify that the composite delegates correctly
    compositeTracer.operationSucceeded();

    verify(childFactory1).newTracer(parent, context);
    verify(childFactory2).newTracer(parent, context);
    verify(tracer1).operationSucceeded();
    verify(tracer2).operationSucceeded();
  }

  @Test
  void testWithContext() {
    ApiTracerContext context = ApiTracerContext.empty();

    ApiTracerFactory contextualizedFactory1 = mock(ApiTracerFactory.class);
    ApiTracerFactory contextualizedFactory2 = mock(ApiTracerFactory.class);

    when(childFactory1.withContext(context)).thenReturn(contextualizedFactory1);
    when(childFactory2.withContext(context)).thenReturn(contextualizedFactory2);

    ApiTracerFactory newCompositeFactory = compositeFactory.withContext(context);

    // Create tracer from the new compositeFactory and verify it delegates to the contextualized
    // children
    ApiTracer parent = mock(ApiTracer.class);
    ApiTracerContext tracerContext = ApiTracerContext.empty();

    ApiTracer tracer1 = mock(ApiTracer.class);
    ApiTracer tracer2 = mock(ApiTracer.class);

    when(contextualizedFactory1.newTracer(parent, tracerContext)).thenReturn(tracer1);
    when(contextualizedFactory2.newTracer(parent, tracerContext)).thenReturn(tracer2);

    ApiTracer compositeTracer = newCompositeFactory.newTracer(parent, tracerContext);
    compositeTracer.operationSucceeded();

    verify(childFactory1).withContext(context);
    verify(childFactory2).withContext(context);
    verify(contextualizedFactory1).newTracer(parent, tracerContext);
    verify(contextualizedFactory2).newTracer(parent, tracerContext);
    verify(tracer1).operationSucceeded();
    verify(tracer2).operationSucceeded();
  }

  @Test
  void testNeedsContext_returnsFalseWhenNoChildrenNeedContext() {
    when(childFactory1.needsContext()).thenReturn(false);
    when(childFactory2.needsContext()).thenReturn(false);

    org.junit.jupiter.api.Assertions.assertFalse(compositeFactory.needsContext());
  }

  @Test
  void testNeedsContext_returnsTrueWhenAtLeastOneChildNeedsContext() {
    when(childFactory1.needsContext()).thenReturn(true);
    when(childFactory2.needsContext()).thenReturn(false);

    org.junit.jupiter.api.Assertions.assertTrue(compositeFactory.needsContext());
  }
}
