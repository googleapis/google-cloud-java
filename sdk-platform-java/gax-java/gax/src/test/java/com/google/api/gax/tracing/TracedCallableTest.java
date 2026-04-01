/*
 * Copyright 2021 Google LLC
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

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.Callables;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TracedCallableTest {
  private static final SpanName SPAN_NAME = SpanName.of("FakeClient", "FakeRpc");

  @Mock private ApiTracerFactory tracerFactory;
  private ApiTracer parentTracer;
  @Mock private ApiTracer tracer;
  @Mock private UnaryCallable<String, String> innerCallable;
  private SettableApiFuture<String> innerResult;

  private ApiCallContext callContext;
  private ClientContext clientContext;

  @BeforeEach
  void setUp() {
    parentTracer = BaseApiTracer.getInstance();

    // Wire the mock tracer factory
    when(tracerFactory.newTracer(
            any(ApiTracer.class), any(SpanName.class), eq(OperationType.Unary)))
        .thenReturn(tracer);

    // Wire the mock inner callable
    innerResult = SettableApiFuture.create();
    when(innerCallable.futureCall(anyString(), any(ApiCallContext.class))).thenReturn(innerResult);

    callContext = FakeCallContext.createDefault();
    clientContext = ClientContext.newBuilder().setDefaultCallContext(callContext).build();
  }

  public UnaryCallable<String, String> setupTracedUnaryCallable(
      UnaryCallSettings<Object, Object> callSettings) {
    UnaryCallable<String, String> callable =
        Callables.retrying(innerCallable, callSettings, clientContext);
    return new TracedUnaryCallable<>(callable, tracerFactory, SPAN_NAME);
  }

  @Test
  void testNonRetriedCallable() throws Exception {
    // Verify that callables configured to not retry have the appropriate tracer interactions.
    UnaryCallSettings<Object, Object> callSettings =
        UnaryCallSettings.newUnaryCallSettingsBuilder()
            .setSimpleTimeoutNoRetriesDuration(java.time.Duration.ofMillis(5L))
            .build();
    UnaryCallable<String, String> callable = setupTracedUnaryCallable(callSettings);
    innerResult.set("No, my refrigerator is not running!");

    ApiFuture<String> future = callable.futureCall("Is your refrigerator running?", callContext);

    verify(tracerFactory, times(1)).newTracer(parentTracer, SPAN_NAME, OperationType.Unary);
    verify(tracer, times(1)).attemptStarted(anyString(), anyInt());
    verify(tracer, times(1)).attemptSucceeded();
    verify(tracer, times(1)).operationSucceeded();
    verifyNoMoreInteractions(tracer);
  }
}
