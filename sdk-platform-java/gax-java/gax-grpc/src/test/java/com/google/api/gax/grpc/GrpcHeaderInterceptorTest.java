/*
 * Copyright 2016 Google LLC
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.grpc.testing.FakeMethodDescriptor;
import com.google.common.collect.ImmutableMap;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptors;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/** Tests for {@link GrpcHeaderInterceptor}. */
class GrpcHeaderInterceptorTest {

  @Mock private Channel channel;

  @Mock private ClientCall<String, Integer> call;

  private static final MethodDescriptor<String, Integer> method = FakeMethodDescriptor.create();

  /** Sets up mocks. */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    when(channel.newCall(Mockito.<MethodDescriptor<String, Integer>>any(), any(CallOptions.class)))
        .thenReturn(call);
  }

  @Test
  void testInterceptor() {
    Map<String, String> data = ImmutableMap.of("x-goog-api-client", "abcd", "user-agent", "defg");
    GrpcHeaderInterceptor interceptor = new GrpcHeaderInterceptor(data);
    Channel intercepted = ClientInterceptors.intercept(channel, interceptor);
    @SuppressWarnings("unchecked")
    ClientCall.Listener<Integer> listener = mock(ClientCall.Listener.class);
    ClientCall<String, Integer> interceptedCall = intercepted.newCall(method, CallOptions.DEFAULT);
    // start() on the intercepted call will eventually reach the call created by the real channel
    interceptedCall.start(listener, new Metadata());
    // The headers passed to the real channel call will contain the information inserted by the
    // interceptor.
    ArgumentCaptor<Metadata> captor = ArgumentCaptor.forClass(Metadata.class);
    verify(call).start(same(listener), captor.capture());
    final Metadata.Key<String> headerKey =
        Metadata.Key.of("x-goog-api-client", Metadata.ASCII_STRING_MARSHALLER);
    assertEquals("abcd", captor.getValue().get(headerKey));
    assertEquals("defg", interceptor.getUserAgentHeader());
  }
}
