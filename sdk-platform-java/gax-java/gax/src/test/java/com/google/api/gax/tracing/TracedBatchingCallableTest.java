/*
 * Copyright 2018 Google LLC
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.BatchingDescriptor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TracedBatchingCallableTest {
  private static final SpanName SPAN_NAME = SpanName.of("FakeClient", "FakeRpc");

  @Mock private ApiTracerFactory tracerFactory;
  @Mock private ApiTracer tracer;
  @Mock private BatchingDescriptor<String, String> batchingDescriptor;
  @Mock private UnaryCallable<String, String> innerCallable;
  private SettableApiFuture<String> innerResult;

  private TracedBatchingCallable<String, String> tracedBatchingCallable;
  private FakeCallContext callContext;

  @BeforeEach
  void setUp() {
    // Wire the mock tracer factory
    when(tracerFactory.newTracer(
            any(ApiTracer.class), any(SpanName.class), eq(OperationType.Batching)))
        .thenReturn(tracer);

    // Wire the mock inner callable
    // This is a very hacky mock, the actual batching infrastructure is completely omitted here.
    innerResult = SettableApiFuture.create();
    when(innerCallable.futureCall(anyString(), any(ApiCallContext.class))).thenReturn(innerResult);

    // Build the system under test
    tracedBatchingCallable =
        new TracedBatchingCallable<>(innerCallable, tracerFactory, SPAN_NAME, batchingDescriptor);
    callContext = FakeCallContext.createDefault();
  }

  @Test
  void testRootTracerCreated() {
    tracedBatchingCallable.futureCall("test", callContext);
    verify(tracerFactory, times(1))
        .newTracer(callContext.getTracer(), SPAN_NAME, OperationType.Batching);
  }

  @Test
  void testBatchAttributesStamped() {
    when(batchingDescriptor.countElements(anyString())).thenReturn(10L);
    when(batchingDescriptor.countBytes(anyString())).thenReturn(20L);

    tracedBatchingCallable.futureCall("test", callContext);
    verify(tracer).batchRequestSent(10, 20);
  }

  @Test
  void testOperationFinish() {
    innerResult.set("successful result");
    tracedBatchingCallable.futureCall("test", callContext);

    verify(tracer, times(1)).operationSucceeded();
  }

  @Test
  void testOperationFailed() {
    RuntimeException fakeError = new RuntimeException("fake error");
    innerResult.setException(fakeError);
    tracedBatchingCallable.futureCall("test", callContext);

    verify(tracer, times(1)).operationFailed(fakeError);
  }

  @Test
  void testSyncError() {
    RuntimeException fakeError = new RuntimeException("fake error");

    // Reset the irrelevant expectations from setup. (only needed to silence the warnings).
    @SuppressWarnings("unchecked")
    UnaryCallable<String, String>[] innerCallableWrapper = new UnaryCallable[] {innerCallable};
    reset(innerCallableWrapper);

    when(innerCallable.futureCall(eq("failing test"), any(ApiCallContext.class)))
        .thenThrow(fakeError);

    try {
      tracedBatchingCallable.futureCall("failing test", callContext);
    } catch (RuntimeException e) {
      // ignored
    }

    verify(tracer, times(1)).operationFailed(fakeError);
  }
}
