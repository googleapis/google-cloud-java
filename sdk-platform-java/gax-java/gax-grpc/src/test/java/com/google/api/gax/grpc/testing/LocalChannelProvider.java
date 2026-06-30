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
package com.google.api.gax.grpc.testing;

import com.google.api.core.BetaApi;
import com.google.api.gax.grpc.GrpcHeaderInterceptor;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannel;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.Credentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.inprocess.InProcessChannelBuilder;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Pattern;

/** LocalChannelProvider creates channels for in-memory gRPC services. */
@BetaApi
public class LocalChannelProvider implements TransportChannelProvider {

  private final List<LocalHeaderInterceptor> interceptors;
  private final String address;

  private volatile HeaderProvider headerProvider;

  private LocalChannelProvider(String address, HeaderProvider headerProvider) {
    this.interceptors = new CopyOnWriteArrayList<>();
    this.address = address;
    this.headerProvider = headerProvider;
  }

  @Override
  public boolean shouldAutoClose() {
    return true;
  }

  @Deprecated
  @Override
  public boolean needsExecutor() {
    return false;
  }

  @Deprecated
  @Override
  public TransportChannelProvider withExecutor(ScheduledExecutorService executor) {
    return withExecutor((Executor) executor);
  }

  @Override
  public TransportChannelProvider withExecutor(Executor executor) {
    throw new UnsupportedOperationException("LocalChannelProvider doesn't need an executor");
  }

  @Override
  public boolean needsHeaders() {
    return headerProvider == null;
  }

  @Override
  public boolean needsEndpoint() {
    return false;
  }

  @Override
  public TransportChannelProvider withEndpoint(String endpoint) {
    throw new UnsupportedOperationException("LocalChannelProvider doesn't need an endpoint");
  }

  @Override
  @BetaApi("The surface for customizing pool size is not stable yet and may change in the future.")
  public boolean acceptsPoolSize() {
    return false;
  }

  @Override
  @BetaApi("The surface for customizing pool size is not stable yet and may change in the future.")
  public TransportChannelProvider withPoolSize(int size) {
    throw new UnsupportedOperationException(
        "LocalChannelProvider doesn't allow pool size customization");
  }

  @Override
  public TransportChannelProvider withHeaders(Map<String, String> headers) {
    this.headerProvider = FixedHeaderProvider.create(headers);
    return this;
  }

  @Override
  public TransportChannel getTransportChannel() throws IOException {
    ManagedChannelBuilder channelBuilder = InProcessChannelBuilder.forName(address).usePlaintext();
    if (headerProvider != null) {
      GrpcHeaderInterceptor interceptor = new GrpcHeaderInterceptor(headerProvider.getHeaders());
      LocalHeaderInterceptor localHeaderInterceptor = new LocalHeaderInterceptor(interceptor);
      interceptors.add(localHeaderInterceptor);
      channelBuilder.intercept(localHeaderInterceptor).userAgent(interceptor.getUserAgentHeader());
    }
    return GrpcTransportChannel.newBuilder().setManagedChannel(channelBuilder.build()).build();
  }

  @Override
  public String getTransportName() {
    return GrpcTransportChannel.getGrpcTransportName();
  }

  @Override
  public boolean needsCredentials() {
    return false;
  }

  @Override
  public TransportChannelProvider withCredentials(Credentials credentials) {
    throw new UnsupportedOperationException("LocalChannelProvider doesn't need credentials");
  }

  /** Creates a LocalChannelProvider. */
  public static LocalChannelProvider create(String addressString) {
    return new LocalChannelProvider(addressString, null);
  }

  public boolean isHeaderSent(String headerKey, Pattern headerPattern) {
    Metadata.Key<String> key = Metadata.Key.of(headerKey, Metadata.ASCII_STRING_MARSHALLER);

    if (interceptors.isEmpty()) {
      return false;
    }
    for (LocalHeaderInterceptor interceptor : interceptors) {
      if (interceptor.getSubmittedHeaders().isEmpty()) {
        return false;
      }
      for (Metadata submittedHeaders : interceptor.getSubmittedHeaders()) {
        String headerValue = submittedHeaders.get(key);
        if (headerValue == null || !headerPattern.matcher(headerValue).matches()) {
          return false;
        }
      }
    }
    return true;
  }

  private static class LocalHeaderInterceptor implements ClientInterceptor {
    private final ClientInterceptor innerInterceptor;
    private final List<Metadata> submittedHeaders;

    private LocalHeaderInterceptor(ClientInterceptor innerInterceptor) {
      this.innerInterceptor = innerInterceptor;
      this.submittedHeaders = new CopyOnWriteArrayList<>();
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
      ClientCall<ReqT, RespT> call = innerInterceptor.interceptCall(method, callOptions, next);
      return new SimpleForwardingClientCall<ReqT, RespT>(call) {
        @Override
        public void start(Listener<RespT> responseListener, Metadata headers) {
          super.start(responseListener, headers);
          submittedHeaders.add(headers);
        }
      };
    }

    List<Metadata> getSubmittedHeaders() {
      return submittedHeaders;
    }
  }
}
