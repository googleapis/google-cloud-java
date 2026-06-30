/*
 * Copyright 2025 Google LLC
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

package com.google.api.gax.grpc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.grpc.testing.FakeMethodDescriptor;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptors;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GrpcLoggingInterceptorTest {
  @Mock private Channel channel;

  @Mock private ClientCall<String, Integer> call;

  private static final MethodDescriptor<String, Integer> method = FakeMethodDescriptor.create();

  @Test
  void testInterceptor_basic() {
    when(channel.newCall(Mockito.<MethodDescriptor<String, Integer>>any(), any(CallOptions.class)))
        .thenReturn(call);
    GrpcLoggingInterceptor interceptor = new GrpcLoggingInterceptor();
    Channel intercepted = ClientInterceptors.intercept(channel, interceptor);
    @SuppressWarnings("unchecked")
    ClientCall.Listener<Integer> listener = mock(ClientCall.Listener.class);
    ClientCall<String, Integer> interceptedCall = intercepted.newCall(method, CallOptions.DEFAULT);
    // Simulate starting the call
    interceptedCall.start(listener, new Metadata());
    // Verify that the underlying call's start() method is invoked
    verify(call).start(any(ClientCall.Listener.class), any(Metadata.class));

    // Simulate sending a message
    String requestMessage = "test request";
    interceptedCall.sendMessage(requestMessage);
    // Verify that the underlying call's sendMessage() method is invoked
    verify(call).sendMessage(requestMessage);
  }

  @Test
  void testInterceptor_responseListener() {
    when(channel.newCall(Mockito.<MethodDescriptor<String, Integer>>any(), any(CallOptions.class)))
        .thenReturn(call);
    GrpcLoggingInterceptor interceptor = spy(new GrpcLoggingInterceptor());
    Channel intercepted = ClientInterceptors.intercept(channel, interceptor);
    @SuppressWarnings("unchecked")
    ClientCall.Listener<Integer> listener = mock(ClientCall.Listener.class);
    ClientCall<String, Integer> interceptedCall = intercepted.newCall(method, CallOptions.DEFAULT);
    interceptedCall.start(listener, new Metadata());

    // Simulate respond interceptor calls
    Metadata responseHeaders = new Metadata();
    responseHeaders.put(
        Metadata.Key.of("test-header", Metadata.ASCII_STRING_MARSHALLER), "header-value");
    interceptor.currentListener.onHeaders(responseHeaders);

    interceptor.currentListener.onMessage(null);

    Status status = Status.OK;
    interceptor.currentListener.onClose(status, new Metadata());
  }
}
