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

import com.google.api.core.InternalApi;
import com.google.common.collect.ImmutableMap;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.MethodDescriptor;
import java.util.Map;
import java.util.Map.Entry;

/**
 * An interceptor to handle custom headers.
 *
 * <p>Package-private for internal usage.
 */
@InternalApi
public class GrpcHeaderInterceptor implements ClientInterceptor {
  private final Map<Metadata.Key<String>, String> staticHeaders;
  private final String userAgentHeader;

  public GrpcHeaderInterceptor(Map<String, String> staticHeaders) {
    ImmutableMap.Builder<Metadata.Key<String>, String> grpcHeaders = ImmutableMap.builder();
    String userAgentStaticHeader = null;
    for (Map.Entry<String, String> header : staticHeaders.entrySet()) {
      Metadata.Key<String> headerKey =
          Metadata.Key.of(header.getKey(), Metadata.ASCII_STRING_MARSHALLER);

      // User-Agent is overridden on gRPC level. The custom User-Agent is supposed to be provided
      // differently and only merging with gRPC default value for User-Agent is permitted.
      // Specifically the User-Agent will be provided via ManagedChannelBuilder#userAgent(String)
      // during channel construction (calling #getUserAgentHeader() to get the value, initialized
      // here).
      if ("user-agent".equals(headerKey.name())) {
        userAgentStaticHeader = header.getValue();
      } else {
        grpcHeaders.put(headerKey, header.getValue());
      }
    }
    this.staticHeaders = grpcHeaders.build();
    this.userAgentHeader = userAgentStaticHeader;
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> method, final CallOptions callOptions, Channel next) {
    ClientCall<ReqT, RespT> call = next.newCall(method, callOptions);
    return new SimpleForwardingClientCall<ReqT, RespT>(call) {
      @Override
      public void start(ClientCall.Listener<RespT> responseListener, Metadata headers) {
        for (Entry<Key<String>, String> staticHeader : staticHeaders.entrySet()) {
          headers.put(staticHeader.getKey(), staticHeader.getValue());
        }

        Map<Key<String>, String> dynamicHeaders =
            CallOptionsUtil.getDynamicHeadersOption(callOptions);
        for (Entry<Key<String>, String> dynamicHeader : dynamicHeaders.entrySet()) {
          headers.put(dynamicHeader.getKey(), dynamicHeader.getValue());
        }

        super.start(responseListener, headers);
      }
    };
  }

  public String getUserAgentHeader() {
    return userAgentHeader;
  }
}
