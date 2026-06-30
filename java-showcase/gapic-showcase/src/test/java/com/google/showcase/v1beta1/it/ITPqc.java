/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.showcase.v1beta1.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.ForwardingHttpJsonClientCall;
import com.google.api.gax.httpjson.ForwardingHttpJsonClientCallListener;
import com.google.api.gax.httpjson.HttpJsonCallOptions;
import com.google.api.gax.httpjson.HttpJsonChannel;
import com.google.api.gax.httpjson.HttpJsonClientCall;
import com.google.api.gax.httpjson.HttpJsonClientInterceptor;
import com.google.api.gax.httpjson.HttpJsonMetadata;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.TransportChannel;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoResponse;
import com.google.showcase.v1beta1.EchoSettings;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContextBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import java.security.Provider;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.conscrypt.Conscrypt;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ITPqc {

  private static final String GRPC_ENDPOINT = "localhost:7470";
  private static final String HTTPJSON_ENDPOINT = "https://localhost:7470";

  @BeforeAll
  static void setUp() {
    // Force Conscrypt and OpenJDK to prefer X25519MLKEM768 for TLS 1.3
    System.setProperty("jdk.tls.namedGroups", "X25519MLKEM768,X25519,secp256r1");
  }

  @Test
  void testGrpcPqc() throws Exception {
    // Build insecure Netty SslContext to bypass certificate validation for testing
    SslContext sslContext = GrpcSslContexts.configure(
        SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE)).build();

    ManagedChannel channel =
        NettyChannelBuilder.forTarget(GRPC_ENDPOINT).sslContext(sslContext).build();
    TransportChannel transportChannel = GrpcTransportChannel.create(channel);

    GrpcHeaderCapturingInterceptor interceptor = new GrpcHeaderCapturingInterceptor();

    EchoSettings settings =
        EchoSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(FixedTransportChannelProvider.create(transportChannel))
            .build();

    // Add interceptor to capture headers
    ManagedChannel interceptedChannel = new InterceptedManagedChannel(channel, interceptor);
    TransportChannel interceptedTransportChannel = GrpcTransportChannel.create(interceptedChannel);

    settings =
        settings.toBuilder()
            .setTransportChannelProvider(
                FixedTransportChannelProvider.create(interceptedTransportChannel))
            .build();

    try (EchoClient client = EchoClient.create(settings)) {
      EchoResponse response =
          client.echo(EchoRequest.newBuilder().setContent("pqc-grpc-test").build());
      assertThat(response.getContent()).isEqualTo("pqc-grpc-test");

      Metadata capturedHeaders = interceptor.getCapturedHeaders();
      assertThat(capturedHeaders).isNotNull();

      Metadata.Key<String> groupKey =
          Metadata.Key.of("x-showcase-tls-group", Metadata.ASCII_STRING_MARSHALLER);
      Metadata.Key<String> versionKey =
          Metadata.Key.of("x-showcase-tls-version", Metadata.ASCII_STRING_MARSHALLER);
      Metadata.Key<String> cipherKey =
          Metadata.Key.of("x-showcase-tls-cipher", Metadata.ASCII_STRING_MARSHALLER);
      Metadata.Key<String> supportedGroupsKey =
          Metadata.Key.of(
              "x-showcase-tls-client-supported-groups", Metadata.ASCII_STRING_MARSHALLER);

      assertThat(capturedHeaders.get(groupKey)).isEqualTo("X25519MLKEM768");
      assertThat(capturedHeaders.get(versionKey)).isEqualTo("TLS 1.3");
      assertThat(capturedHeaders.get(cipherKey)).isEqualTo("TLS_AES_128_GCM_SHA256");
      assertThat(capturedHeaders.get(supportedGroupsKey)).isNotNull();
    } finally {
      channel.shutdown();
      channel.awaitTermination(10, TimeUnit.SECONDS);
    }
  }

  @Test
  void testHttpJsonPqc() throws Exception {
    // Build NetHttpTransport with certificate validation disabled
    NetHttpTransport transport = new NetHttpTransport.Builder().doNotValidateCertificate().build();

    HttpJsonHeaderCapturingInterceptor interceptor = new HttpJsonHeaderCapturingInterceptor();

    InstantiatingHttpJsonChannelProvider transportChannelProvider =
        EchoSettings.defaultHttpJsonTransportProviderBuilder()
            .setHttpTransport(transport)
            .setEndpoint(HTTPJSON_ENDPOINT)
            .setInterceptorProvider(() -> Collections.singletonList(interceptor))
            .build();

    EchoSettings settings =
        EchoSettings.newHttpJsonBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(transportChannelProvider)
            .build();

    try (EchoClient client = EchoClient.create(settings)) {
      EchoResponse response =
          client.echo(EchoRequest.newBuilder().setContent("pqc-httpjson-test").build());
      assertThat(response.getContent()).isEqualTo("pqc-httpjson-test");

      HttpJsonMetadata capturedHeaders = interceptor.getCapturedHeaders();
      assertThat(capturedHeaders).isNotNull();

      String negotiatedGroup = getSingleHeaderString(capturedHeaders, "x-showcase-tls-group");
      assertThat(negotiatedGroup).isEqualTo("X25519MLKEM768");

      String tlsVersion = getSingleHeaderString(capturedHeaders, "x-showcase-tls-version");
      assertThat(tlsVersion).isEqualTo("TLS 1.3");

      String tlsCipher = getSingleHeaderString(capturedHeaders, "x-showcase-tls-cipher");
      assertThat(tlsCipher).isEqualTo("TLS_AES_128_GCM_SHA256");

      String supportedGroups =
          getSingleHeaderString(capturedHeaders, "x-showcase-tls-client-supported-groups");
      assertThat(supportedGroups).isNotNull();
    }
  }

  @Test
  void testHttpJsonPqc_withExplicitSecurityProvider() throws Exception {
    Provider explicitConscryptProvider = Conscrypt.newProvider();

    // Build NetHttpTransport specifying the Conscrypt provider explicitly
    NetHttpTransport transport =
        new NetHttpTransport.Builder()
            .setSecurityProvider(explicitConscryptProvider)
            .doNotValidateCertificate()
            .build();

    HttpJsonHeaderCapturingInterceptor interceptor = new HttpJsonHeaderCapturingInterceptor();

    InstantiatingHttpJsonChannelProvider transportChannelProvider =
        EchoSettings.defaultHttpJsonTransportProviderBuilder()
            .setHttpTransport(transport)
            .setEndpoint(HTTPJSON_ENDPOINT)
            .setInterceptorProvider(() -> Collections.singletonList(interceptor))
            .build();

    EchoSettings settings =
        EchoSettings.newHttpJsonBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(transportChannelProvider)
            .build();

    try (EchoClient client = EchoClient.create(settings)) {
      EchoResponse response =
          client.echo(
              EchoRequest.newBuilder().setContent("pqc-httpjson-explicit-provider-test").build());
      assertThat(response.getContent()).isEqualTo("pqc-httpjson-explicit-provider-test");

      HttpJsonMetadata capturedHeaders = interceptor.getCapturedHeaders();
      assertThat(capturedHeaders).isNotNull();

      String negotiatedGroup = getSingleHeaderString(capturedHeaders, "x-showcase-tls-group");
      assertThat(negotiatedGroup).isEqualTo("X25519MLKEM768");

      String tlsVersion = getSingleHeaderString(capturedHeaders, "x-showcase-tls-version");
      assertThat(tlsVersion).isEqualTo("TLS 1.3");

      String tlsCipher = getSingleHeaderString(capturedHeaders, "x-showcase-tls-cipher");
      assertThat(tlsCipher).isEqualTo("TLS_AES_128_GCM_SHA256");
    }
  }

  private static class GrpcHeaderCapturingInterceptor implements ClientInterceptor {
    private Metadata capturedHeaders;

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method, io.grpc.CallOptions callOptions, Channel next) {
      return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
          next.newCall(method, callOptions)) {
        @Override
        public void start(Listener<RespT> responseListener, Metadata headers) {
          super.start(
              new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(
                  responseListener) {
                @Override
                public void onHeaders(Metadata headers) {
                  capturedHeaders = headers;
                  super.onHeaders(headers);
                }
              },
              headers);
        }
      };
    }

    public Metadata getCapturedHeaders() {
      return capturedHeaders;
    }
  }

  private static class HttpJsonHeaderCapturingInterceptor implements HttpJsonClientInterceptor {
    private HttpJsonMetadata capturedHeaders;

    @Override
    public <ReqT, RespT> HttpJsonClientCall<ReqT, RespT> interceptCall(
        ApiMethodDescriptor<ReqT, RespT> method,
        HttpJsonCallOptions callOptions,
        HttpJsonChannel next) {
      return new ForwardingHttpJsonClientCall.SimpleForwardingHttpJsonClientCall<ReqT, RespT>(
          next.newCall(method, callOptions)) {
        @Override
        public void start(
            HttpJsonClientCall.Listener<RespT> responseListener, HttpJsonMetadata requestHeaders) {
          super.start(
              new ForwardingHttpJsonClientCallListener.SimpleForwardingHttpJsonClientCallListener<
                  RespT>(responseListener) {
                @Override
                public void onHeaders(HttpJsonMetadata responseHeaders) {
                  capturedHeaders = responseHeaders;
                  super.onHeaders(responseHeaders);
                }
              },
              requestHeaders);
        }
      };
    }

    public HttpJsonMetadata getCapturedHeaders() {
      return capturedHeaders;
    }
  }

  private static class InterceptedManagedChannel extends ManagedChannel {
    private final ManagedChannel delegate;
    private final Channel intercepted;

    InterceptedManagedChannel(ManagedChannel delegate, ClientInterceptor... interceptors) {
      this.delegate = delegate;
      this.intercepted = io.grpc.ClientInterceptors.intercept(delegate, interceptors);
    }

    @Override
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
        MethodDescriptor<RequestT, ResponseT> methodDescriptor, io.grpc.CallOptions callOptions) {
      return intercepted.newCall(methodDescriptor, callOptions);
    }

    @Override
    public String authority() {
      return delegate.authority();
    }

    @Override
    public ManagedChannel shutdown() {
      delegate.shutdown();
      return this;
    }

    @Override
    public boolean isShutdown() {
      return delegate.isShutdown();
    }

    @Override
    public boolean isTerminated() {
      return delegate.isTerminated();
    }

    @Override
    public ManagedChannel shutdownNow() {
      delegate.shutdownNow();
      return this;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
      return delegate.awaitTermination(timeout, unit);
    }
  }

  private static String getSingleHeaderString(HttpJsonMetadata metadata, String name) {
    Object valueObj = metadata.getHeaders().get(name);
    if (valueObj instanceof java.util.List) {
      java.util.List<?> list = (java.util.List<?>) valueObj;
      if (!list.isEmpty()) {
        return String.valueOf(list.get(0));
      }
    } else if (valueObj != null) {
      return String.valueOf(valueObj);
    }
    return null;
  }
}
