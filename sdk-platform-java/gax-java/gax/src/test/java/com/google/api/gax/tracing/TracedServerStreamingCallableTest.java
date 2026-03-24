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

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.CancelledException;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.gax.rpc.testing.MockStreamingApi.MockResponseObserver;
import com.google.api.gax.rpc.testing.MockStreamingApi.MockServerStreamingCall;
import com.google.api.gax.rpc.testing.MockStreamingApi.MockServerStreamingCallable;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TracedServerStreamingCallableTest {
  private static final SpanName SPAN_NAME = SpanName.of("FakeClient", "FakeRpc");

  @Mock private ApiTracerFactory tracerFactory;
  @Mock private ApiTracer tracer;
  @Mock private ApiTracerContext tracerContext;
  @Mock private ApiTracerContext.Builder tracerContextBuilder;

  private MockServerStreamingCallable<String, String> innerCallable;
  private TracedServerStreamingCallable<String, String> tracedCallable;
  private MockResponseObserver<String> responseObserver;
  private ApiCallContext callContext;
  @Mock private ApiTracer parentTracer;

  void init(boolean useContext) {
    innerCallable = new MockServerStreamingCallable<>();
    // Wire the mock tracer factory
    if (useContext) {
      when(tracerContext.toBuilder()).thenReturn(tracerContextBuilder);
      when(tracerContextBuilder.setOperationType(any())).thenReturn(tracerContextBuilder);
      when(tracerContextBuilder.build()).thenReturn(tracerContext);
      when(tracerFactory.newTracer(any(ApiTracer.class), any(ApiTracerContext.class)))
          .thenReturn(tracer);
      when(tracerContext.fullMethodName()).thenReturn("FakeClient/FakeRpc");
      tracedCallable =
          new TracedServerStreamingCallable<>(innerCallable, tracerFactory, tracerContext);
    } else {
      when(tracerFactory.newTracer(
              any(ApiTracer.class), any(SpanName.class), eq(OperationType.ServerStreaming)))
          .thenReturn(tracer);
      tracedCallable = new TracedServerStreamingCallable<>(innerCallable, tracerFactory, SPAN_NAME);
    }

    responseObserver = new MockResponseObserver<>(true);
    callContext = FakeCallContext.createDefault().withTracer(parentTracer);
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testTracerCreated(boolean useContext) {
    init(useContext);
    tracedCallable.call("test", responseObserver, callContext);
    if (useContext) {
      verify(tracerFactory, times(1)).newTracer(parentTracer, tracerContext);
    } else {
      verify(tracerFactory, times(1))
          .newTracer(parentTracer, SPAN_NAME, OperationType.ServerStreaming);
    }
  }

  @Test
  void testOperationTypeIsSet() {
    init(true);
    tracedCallable.call("test", responseObserver, callContext);

    verify(tracerContextBuilder).setOperationType(OperationType.ServerStreaming);
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testResponseNotify(boolean useContext) {
    init(useContext);
    tracedCallable.call("test", responseObserver, callContext);

    MockServerStreamingCall<String, String> innerCall = innerCallable.popLastCall();
    innerCall.getController().getObserver().onResponse("response1");
    innerCall.getController().getObserver().onResponse("response2");

    assertThat(responseObserver.popNextResponse()).isEqualTo("response1");
    assertThat(responseObserver.popNextResponse()).isEqualTo("response2");
    verify(tracer, times(2)).responseReceived();
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testOperationCancelled(boolean useContext) {
    init(useContext);
    tracedCallable.call("test", responseObserver, callContext);
    responseObserver.getController().cancel();

    MockServerStreamingCall<String, String> innerCall = innerCallable.popLastCall();
    innerCall
        .getController()
        .getObserver()
        .onError(
            new CancelledException("fake cancel", null, new FakeStatusCode(Code.CANCELLED), false));

    assertThat(responseObserver.isDone()).isTrue();
    verify(tracer, times(1)).operationCancelled();
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testOperationFinish(boolean useContext) {
    init(useContext);
    tracedCallable.call("test", responseObserver, callContext);

    MockServerStreamingCall<String, String> innerCall = innerCallable.popLastCall();
    innerCall.getController().getObserver().onComplete();

    assertThat(responseObserver.isDone()).isTrue();
    verify(tracer, times(1)).operationSucceeded();
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testOperationFail(boolean useContext) {
    init(useContext);
    RuntimeException expectedError = new RuntimeException("expected error");

    tracedCallable.call("test", responseObserver, callContext);

    MockServerStreamingCall<String, String> innerCall = innerCallable.popLastCall();
    innerCall.getController().getObserver().onError(expectedError);

    assertThat(responseObserver.getFinalError()).isEqualTo(expectedError);
    verify(tracer, times(1)).operationFailed(expectedError);
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  @SuppressWarnings("unchecked")
  void testSyncError(boolean useContext) {
    init(useContext);
    RuntimeException expectedError = new RuntimeException("expected error");

    // Create a broken inner callable
    ServerStreamingCallable<String, String> innerCallable = mock(ServerStreamingCallable.class);
    doThrow(expectedError)
        .when(innerCallable)
        .call(
            eq("test"),
            (ResponseObserver<String>) any(ResponseObserver.class),
            any(ApiCallContext.class));

    // Recreate the tracedCallable using the new inner callable
    if (useContext) {
      tracedCallable =
          new TracedServerStreamingCallable<>(innerCallable, tracerFactory, tracerContext);
    } else {
      tracedCallable = new TracedServerStreamingCallable<>(innerCallable, tracerFactory, SPAN_NAME);
    }

    try {
      tracedCallable.call("test", responseObserver, callContext);
    } catch (RuntimeException e) {
      // noop
    }

    verify(tracer, times(1)).operationFailed(expectedError);
  }
}
