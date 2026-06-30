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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.CancelledException;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.gax.tracing.ApiTracerContext.Transport;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.CancellationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TracedClientStreamingCallableTest {
  private static final SpanName SPAN_NAME = SpanName.of("fake-client", "fake-method");
  private static final ApiTracerContext TRACER_CONTEXT =
      ApiTracerContext.newBuilder()
          .setFullMethodName("fake-client/fake-method")
          .setTransport(Transport.GRPC)
          .setLibraryMetadata(LibraryMetadata.empty())
          .setOperationType(OperationType.ClientStreaming)
          .build();

  @Mock private ApiTracerFactory tracerFactory;
  private ApiTracer parentTracer = BaseApiTracer.getInstance();
  @Mock private ApiTracer tracer;

  private FakeClientCallable innerCallable;
  private TracedClientStreamingCallable<String, String> tracedCallable;
  private FakeStreamObserver outerResponseObsever;
  private FakeCallContext callContext;

  void init(boolean useContext) {
    outerResponseObsever = new FakeStreamObserver();
    callContext = FakeCallContext.createDefault();
    innerCallable = new FakeClientCallable();
    if (useContext) {
      when(tracerFactory.newTracer(any(ApiTracer.class), any(ApiTracerContext.class)))
          .thenReturn(tracer);
      tracedCallable =
          new TracedClientStreamingCallable<>(innerCallable, tracerFactory, TRACER_CONTEXT);
    } else {
      when(tracerFactory.newTracer(parentTracer, SPAN_NAME, OperationType.ClientStreaming))
          .thenReturn(tracer);
      tracedCallable = new TracedClientStreamingCallable<>(innerCallable, tracerFactory, SPAN_NAME);
    }
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testTracerCreated(boolean useContext) {
    init(useContext);
    tracedCallable.clientStreamingCall(outerResponseObsever, callContext);

    if (useContext) {
      verify(tracerFactory, times(1)).newTracer(parentTracer, TRACER_CONTEXT);
    } else {
      verify(tracerFactory, times(1))
          .newTracer(parentTracer, SPAN_NAME, OperationType.ClientStreaming);
    }
  }

  @Test
  void testOperationTypeIsSet() {
    init(true);
    ApiTracerContext contextWithWrongType =
        TRACER_CONTEXT.toBuilder().setOperationType(OperationType.Unary).build();

    innerCallable = new FakeClientCallable();
    tracedCallable =
        new TracedClientStreamingCallable<>(innerCallable, tracerFactory, contextWithWrongType);

    tracedCallable.clientStreamingCall(new FakeStreamObserver(), FakeCallContext.createDefault());

    ArgumentCaptor<ApiTracerContext> contextCaptor =
        ArgumentCaptor.forClass(ApiTracerContext.class);
    verify(tracerFactory).newTracer(any(ApiTracer.class), contextCaptor.capture());
    assertThat(contextCaptor.getValue().operationType()).isEqualTo(OperationType.ClientStreaming);
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testCallContextPropagated(boolean useContext) {
    init(useContext);
    ImmutableMap<String, List<String>> extraHeaders =
        ImmutableMap.<String, List<String>>of("header1", ImmutableList.of("value1"));

    ApiCallContext newCallContext = callContext.withExtraHeaders(extraHeaders);
    tracedCallable.clientStreamingCall(outerResponseObsever, newCallContext);

    assertThat(innerCallable.callContext.getExtraHeaders()).isEqualTo(extraHeaders);
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testOperationCancelled(boolean useContext) {
    init(useContext);
    ApiStreamObserver<String> clientStream =
        tracedCallable.clientStreamingCall(outerResponseObsever, callContext);

    clientStream.onError(new CancellationException("explicitly cancelled"));
    innerCallable.responseObserver.onError(
        new CancelledException(
            "fake exception that would be generated by a client cancelling the rpc",
            null,
            FakeStatusCode.of(Code.CANCELLED),
            false));

    verify(tracer, times(1)).operationCancelled();
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testOperationFinished(boolean useContext) {
    init(useContext);
    tracedCallable.clientStreamingCall(outerResponseObsever, callContext);
    innerCallable.responseObserver.onNext("ignored");
    innerCallable.responseObserver.onCompleted();

    verify(tracer, times(1)).operationSucceeded();
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testOperationFailed(boolean useContext) {
    init(useContext);
    RuntimeException expectedError = new RuntimeException("fake error");
    tracedCallable.clientStreamingCall(outerResponseObsever, callContext);
    innerCallable.responseObserver.onError(expectedError);

    verify(tracer, times(1)).operationFailed(expectedError);
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testSyncError(boolean useContext) {
    init(useContext);
    RuntimeException expectedError = new RuntimeException("fake error");
    innerCallable.syncError = expectedError;

    try {
      tracedCallable.clientStreamingCall(outerResponseObsever, callContext);
    } catch (RuntimeException e) {
      // noop
    }

    verify(tracer, times(1)).operationFailed(expectedError);
  }

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void testRequestNotify(boolean useContext) {
    init(useContext);
    ApiStreamObserver<String> requestStream =
        tracedCallable.clientStreamingCall(outerResponseObsever, callContext);

    requestStream.onNext("request1");
    requestStream.onNext("request2");
    innerCallable.responseObserver.onNext("response");
    innerCallable.responseObserver.onCompleted();

    verify(tracer, times(2)).requestSent();
    assertThat(outerResponseObsever.completed).isTrue();
    assertThat(innerCallable.requestObserver.messages).containsExactly("request1", "request2");
  }

  private static class FakeClientCallable extends ClientStreamingCallable<String, String> {
    private RuntimeException syncError;
    private ApiStreamObserver<String> responseObserver;
    // TODO: https://github.com/googleapis/gax-java/issues/687
    private ApiCallContext callContext;
    private FakeStreamObserver requestObserver;

    @Override
    public ApiStreamObserver<String> clientStreamingCall(
        ApiStreamObserver<String> responseObserver, ApiCallContext context) {

      if (syncError != null) {
        throw syncError;
      }

      this.responseObserver = responseObserver;
      this.callContext = context;
      this.requestObserver = new FakeStreamObserver();

      return this.requestObserver;
    }
  }

  private static class FakeStreamObserver implements ApiStreamObserver<String> {
    private List<String> messages = Lists.newArrayList();
    private Throwable error;
    private boolean completed;

    @Override
    public void onNext(String value) {
      messages.add(value);
    }

    @Override
    public void onError(Throwable t) {
      error = t;
      completed = true;
    }

    @Override
    public void onCompleted() {
      completed = true;
    }
  }
}
