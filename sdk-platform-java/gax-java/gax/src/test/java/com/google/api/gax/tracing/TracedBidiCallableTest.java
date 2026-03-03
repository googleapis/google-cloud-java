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

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.BidiStream;
import com.google.api.gax.rpc.BidiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ClientStreamReadyObserver;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TracedBidiCallableTest {
  private static final SpanName SPAN_NAME = SpanName.of("fake-client", "fake-method");
  private FakeBidiObserver outerObserver;
  private FakeCallContext outerCallContext;

  @Mock private ApiTracerFactory tracerFactory;
  private ApiTracer parentTracer = BaseApiTracer.getInstance();
  @Mock private ApiTracer tracer;

  private TracedBidiCallable<String, String> tracedCallable;

  private FakeBidiCallable innerCallable;
  private FakeStreamController innerController;

  @BeforeEach
  void setUp() {
    outerObserver = new FakeBidiObserver();
    outerCallContext = FakeCallContext.createDefault();

    when(tracerFactory.newTracer(parentTracer, SPAN_NAME, OperationType.BidiStreaming))
        .thenReturn(tracer);

    innerCallable = new FakeBidiCallable();
    innerController = new FakeStreamController();
    tracedCallable = new TracedBidiCallable<>(innerCallable, tracerFactory, SPAN_NAME);
  }

  @Test
  void testTracerCreated() {
    tracedCallable.call(outerObserver, outerCallContext);

    verify(tracerFactory, times(1)).newTracer(parentTracer, SPAN_NAME, OperationType.BidiStreaming);
  }

  @Test
  void testOperationCancelled() {
    tracedCallable.call(outerObserver, outerCallContext);
    outerObserver.clientStream.closeSendWithError(new CancellationException());
    innerCallable.responseObserver.onError(
        new RuntimeException("server generated result from cancelling"));

    verify(tracer, times(1)).operationCancelled();
    assertThat(outerObserver.complete).isTrue();
  }

  @Test
  void testOperationCancelled2() {
    BidiStream<String, String> stream = tracedCallable.call(outerCallContext);

    stream.cancel();
    innerCallable.responseObserver.onError(
        new RuntimeException("server generated result from cancelling"));

    verify(tracer, times(1)).operationCancelled();
  }

  @Test
  void testOperationFinished() {
    tracedCallable.call(outerObserver, outerCallContext);
    innerCallable.responseObserver.onComplete();

    verify(tracer, times(1)).operationSucceeded();
    assertThat(outerObserver.complete).isTrue();
  }

  @Test
  void testOperationFailed() {
    RuntimeException expectedException = new RuntimeException("fake");

    tracedCallable.call(outerObserver, outerCallContext);
    innerCallable.responseObserver.onError(expectedException);

    verify(tracer, times(1)).operationFailed(expectedException);
    assertThat(outerObserver.complete).isTrue();
    assertThat(outerObserver.error).isEqualTo(expectedException);
  }

  @Test
  void testSyncError() {
    RuntimeException expectedException = new RuntimeException("fake");
    innerCallable.syncError = expectedException;

    try {
      tracedCallable.call(outerObserver, outerCallContext);
    } catch (RuntimeException e) {
      // noop
    }

    verify(tracer, times(1)).operationFailed(expectedException);
  }

  @Test
  void testRequestNotify() {
    tracedCallable.call(outerObserver, outerCallContext);
    outerObserver.clientStream.send("request1");
    outerObserver.clientStream.send("request2");

    verify(tracer, times(2)).requestSent();
    assertThat(innerCallable.clientStream.sent).containsExactly("request1", "request2");
  }

  @Test
  void testRequestNotify2() {
    BidiStream<String, String> stream = tracedCallable.call(outerCallContext);
    stream.send("request1");
    stream.send("request2");

    verify(tracer, times(2)).requestSent();
    assertThat(innerCallable.clientStream.sent).containsExactly("request1", "request2");
  }

  @Test
  void testResponseNotify() {
    tracedCallable.call(outerObserver, outerCallContext);

    innerCallable.responseObserver.onResponse("response1");
    innerCallable.responseObserver.onResponse("response2");

    verify(tracer, times(2)).responseReceived();
    assertThat(outerObserver.responses).containsExactly("response1", "response2");
  }

  private static class FakeBidiCallable extends BidiStreamingCallable<String, String> {
    RuntimeException syncError;

    FakeStreamController responseController;
    ResponseObserver<String> responseObserver;
    ClientStreamReadyObserver<String> onReady;
    ApiCallContext callContext;
    FakeClientStream clientStream;

    @Override
    public ClientStream<String> internalCall(
        ResponseObserver<String> responseObserver,
        ClientStreamReadyObserver<String> onReady,
        ApiCallContext context) {

      if (syncError != null) {
        throw syncError;
      }

      this.responseController = new FakeStreamController();

      this.responseObserver = responseObserver;
      this.onReady = onReady;
      this.callContext = context;
      this.clientStream = new FakeClientStream();

      onReady.onReady(clientStream);
      responseObserver.onStart(responseController);

      return clientStream;
    }
  }

  private static class FakeClientStream implements ClientStream<String> {
    private List<String> sent = new ArrayList<>();
    private Throwable closeError;
    private boolean closed;

    @Override
    public void send(String request) {
      sent.add(request);
    }

    @Override
    public void closeSendWithError(Throwable t) {
      closed = true;
      closeError = t;
    }

    @Override
    public void closeSend() {
      closed = true;
    }

    @Override
    public boolean isSendReady() {
      return true;
    }
  }

  private static class FakeBidiObserver implements BidiStreamObserver<String, String> {
    private ClientStream<String> clientStream;
    private StreamController streamController;
    private List<String> responses = new ArrayList<>();
    private Throwable error;
    private boolean complete;

    @Override
    public void onReady(ClientStream<String> stream) {
      this.clientStream = stream;
    }

    @Override
    public void onStart(StreamController controller) {
      this.streamController = controller;
    }

    @Override
    public void onResponse(String response) {
      responses.add(response);
    }

    @Override
    public void onError(Throwable t) {
      this.error = t;
      this.complete = true;
    }

    @Override
    public void onComplete() {
      this.complete = true;
    }
  }

  private static class FakeStreamController implements StreamController {
    private boolean wasCancelled;

    @Override
    public void cancel() {
      this.wasCancelled = true;
    }

    @Override
    public void disableAutoInboundFlowControl() {}

    @Override
    public void request(int count) {}
  }
}
