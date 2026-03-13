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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.AbstractApiFuture;
import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TracedOperationCallableTest {
  private static final SpanName SPAN_NAME = SpanName.of("FakeClient", "FakeOperation");

  @Mock private ApiTracerFactory tracerFactory;
  private ApiTracer parentTracer;
  @Mock private ApiTracer tracer;
  @Mock private OperationCallable<String, String, Long> innerCallable;
  private FakeOperationFuture innerResult;

  private TracedOperationCallable<String, String, Long> tracedOperationCallable;
  private FakeCallContext callContext;

  @BeforeEach
  void setUp() {
    parentTracer = BaseApiTracer.getInstance();

    // Wire the mock tracer factory
    when(tracerFactory.newTracer(
            any(ApiTracer.class), any(SpanName.class), eq(OperationType.LongRunning)))
        .thenReturn(tracer);

    // Wire the mock inner callable
    innerResult = new FakeOperationFuture();
    when(innerCallable.futureCall(anyString(), any(ApiCallContext.class))).thenReturn(innerResult);

    // Build the system under test
    tracedOperationCallable =
        new TracedOperationCallable<>(innerCallable, tracerFactory, SPAN_NAME);
    callContext = FakeCallContext.createDefault();
  }

  @Test
  void testTracerCreated() {
    tracedOperationCallable.futureCall("test", callContext);
    verify(tracerFactory, times(1)).newTracer(parentTracer, SPAN_NAME, OperationType.LongRunning);
  }

  @Test
  void testOperationFinish() {
    innerResult.set("successful result");
    tracedOperationCallable.futureCall("test", callContext);

    verify(tracer, times(1)).operationSucceeded();
  }

  @Test
  void testOperationCancelled() {
    innerResult.cancel(true);
    tracedOperationCallable.futureCall("test", callContext);
    verify(tracer, times(1)).operationCancelled();
  }

  @Test
  void testExternalOperationCancel() {
    Mockito.reset(innerCallable, tracerFactory);

    when(tracerFactory.newTracer(
            any(ApiTracer.class), any(SpanName.class), eq(OperationType.Unary)))
        .thenReturn(tracer);

    SettableApiFuture<Void> innerCancelResult = SettableApiFuture.create();
    when(innerCallable.cancel(anyString(), any(ApiCallContext.class)))
        .thenReturn(innerCancelResult);

    tracedOperationCallable.cancel("some external operation", callContext);

    verify(tracerFactory, times(1))
        .newTracer(
            parentTracer,
            SpanName.of(SPAN_NAME.getClientName(), SPAN_NAME.getMethodName() + ".Cancel"),
            OperationType.Unary);
  }

  @Test
  void testOperationFailed() {
    RuntimeException fakeError = new RuntimeException("fake error");
    innerResult.setException(fakeError);
    tracedOperationCallable.futureCall("test", callContext);

    verify(tracer, times(1)).operationFailed(fakeError);
  }

  @Test
  void testSyncError() {
    RuntimeException fakeError = new RuntimeException("fake error");

    // Reset the irrelevant expectations from setup. (only needed to silence the warnings).
    @SuppressWarnings("unchecked")
    OperationCallable<String, String, Long>[] innerCallableWrapper =
        new OperationCallable[] {innerCallable};
    reset(innerCallableWrapper);

    when(innerCallable.futureCall(eq("failing test"), any(ApiCallContext.class)))
        .thenThrow(fakeError);

    try {
      tracedOperationCallable.futureCall("failing test", callContext);
    } catch (RuntimeException e) {
      // ignored
    }

    verify(tracer, times(1)).operationFailed(fakeError);
  }

  static class FakeOperationFuture extends AbstractApiFuture<String>
      implements OperationFuture<String, Long> {
    @Override
    public boolean set(String value) {
      return super.set(value);
    }

    @Override
    public boolean setException(Throwable throwable) {
      return super.setException(throwable);
    }

    @Override
    public String getName() {
      throw new UnsupportedOperationException("getInitialFuture() not implemented");
    }

    @Override
    public ApiFuture<OperationSnapshot> getInitialFuture() {
      throw new UnsupportedOperationException("getInitialFuture() not implemented");
    }

    @Override
    public RetryingFuture<OperationSnapshot> getPollingFuture() {
      throw new UnsupportedOperationException("getPollingFuture() not implemented");
    }

    @Override
    public ApiFuture<Long> peekMetadata() {
      throw new UnsupportedOperationException("getInitialFuture() not implemented");
    }

    @Override
    public ApiFuture<Long> getMetadata() {
      throw new UnsupportedOperationException("getInitialFuture() not implemented");
    }
  }
}
