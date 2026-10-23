/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.spi.v1;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;

import com.google.cloud.spanner.SpannerOptions.CallCredentialsProvider;
import com.google.cloud.spanner.spi.v1.SpannerRpc.ChannelPrimeSessionSource;
import com.google.common.collect.ImmutableMap;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SpannerGrpc;
import io.grpc.Attributes;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.Grpc;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GcpFallbackProberTest {
  private static final String PROJECT_NAME = "projects/my-project";
  private static final String DATABASE_NAME =
      "projects/my-project/instances/my-instance/databases/my-database";
  private static final String SESSION_NAME = DATABASE_NAME + "/sessions/multiplexed-session";
  private static final String RESOURCE_HEADER_KEY = "google-cloud-resource-prefix";

  private static final Metadata.Key<String> RESOURCE_PREFIX_KEY =
      Metadata.Key.of(RESOURCE_HEADER_KEY, Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> REQUEST_PARAMS_KEY =
      Metadata.Key.of("x-goog-request-params", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> REQUEST_ID_KEY =
      Metadata.Key.of("x-goog-spanner-request-id", Metadata.ASCII_STRING_MARSHALLER);

  private static final class ProbeService extends SpannerGrpc.SpannerImplBase {
    final CopyOnWriteArrayList<GetSessionRequest> requests = new CopyOnWriteArrayList<>();
    final CopyOnWriteArrayList<Metadata> headers = new CopyOnWriteArrayList<>();
    final CountDownLatch callCancelled = new CountDownLatch(1);
    volatile boolean holdResponses;
    @Nullable volatile Status failWith;

    @Override
    public void getSession(GetSessionRequest request, StreamObserver<Session> responseObserver) {
      requests.add(request);
      ((ServerCallStreamObserver<Session>) responseObserver)
          .setOnCancelHandler(callCancelled::countDown);
      if (holdResponses) {
        return;
      }
      Status failure = failWith;
      if (failure != null) {
        responseObserver.onError(failure.asRuntimeException());
        return;
      }
      responseObserver.onNext(Session.newBuilder().setName(request.getName()).build());
      responseObserver.onCompleted();
    }
  }

  private static final class FixedSessionSource implements ChannelPrimeSessionSource {
    private final String sessionName;

    private FixedSessionSource(String sessionName) {
      this.sessionName = sessionName;
    }

    @Override
    public String getChannelPrimeSessionName() {
      return sessionName;
    }
  }

  private ProbeService service;
  private Server server;
  private ManagedChannel channel;
  private SessionSourceRegistry registry;

  @Before
  public void setUp() throws Exception {
    service = new ProbeService();
    String serverName = InProcessServerBuilder.generateName();
    server =
        InProcessServerBuilder.forName(serverName)
            .addService(service)
            .intercept(
                new ServerInterceptor() {
                  @Override
                  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                      ServerCall<ReqT, RespT> call,
                      Metadata headers,
                      ServerCallHandler<ReqT, RespT> next) {
                    service.headers.add(headers);
                    return Contexts.interceptCall(Context.current(), call, headers, next);
                  }
                })
            .build()
            .start();
    channel = InProcessChannelBuilder.forName(serverName).build();
    registry = new SessionSourceRegistry();
  }

  @After
  public void tearDown() throws Exception {
    channel.shutdownNow();
    server.shutdownNow();
    server.awaitTermination(5, TimeUnit.SECONDS);
  }

  private GcpFallbackProber newProber(
      @Nullable CallCredentialsProvider callCredentialsProvider, Duration rpcDeadline) {
    return new GcpFallbackProber(
        registry,
        SpannerMetadataProvider.create(
            ImmutableMap.of("x-goog-api-client", "test-client", "user-agent", "test-agent"),
            RESOURCE_HEADER_KEY),
        PROJECT_NAME,
        new RequestIdCreatorImpl(),
        callCredentialsProvider,
        rpcDeadline);
  }

  private GcpFallbackProber newProber(Duration rpcDeadline) {
    return newProber(/* callCredentialsProvider= */ null, rpcDeadline);
  }

  private GcpFallbackProber newProber() {
    return newProber(GcpFallbackProber.DEFAULT_PROBE_DEADLINE);
  }

  private Channel channelWithAttributes(@Nullable Attributes attributes) {
    return new Channel() {
      @Override
      public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(
          MethodDescriptor<ReqT, RespT> method, CallOptions callOptions) {
        return new SimpleForwardingClientCall<ReqT, RespT>(channel.newCall(method, callOptions)) {
          @Override
          public Attributes getAttributes() {
            return attributes;
          }
        };
      }

      @Override
      public String authority() {
        return channel.authority();
      }
    };
  }

  @Test
  public void probeWaitsForASessionAndThenCallsGetSessionWithPerCallHeaders() throws Exception {
    GcpFallbackProber prober = newProber();

    assertThat(prober.apply(channel)).isEqualTo(GcpFallbackProber.RESULT_WAITING_FOR_SESSION);
    assertThat(service.requests).isEmpty();

    registry.register(new FixedSessionSource(SESSION_NAME));
    assertThat(prober.apply(channel)).isEqualTo(GcpFallbackProber.RESULT_SUCCESS);

    assertThat(service.requests).hasSize(1);
    assertThat(service.requests.get(0).getName()).isEqualTo(SESSION_NAME);
    Metadata headers = service.headers.get(0);
    assertThat(headers.get(RESOURCE_PREFIX_KEY)).isEqualTo(DATABASE_NAME);
    assertThat(headers.get(REQUEST_PARAMS_KEY))
        .isEqualTo("name=" + URLEncoder.encode(SESSION_NAME, "UTF-8"));
    assertThat(headers.get(REQUEST_ID_KEY)).isNotEmpty();
  }

  @Test
  public void probeAttachesCallCredentialsWhenConfigured() {
    Metadata.Key<String> authHeaderKey =
        Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);
    CallCredentials callCredentials =
        new CallCredentials() {
          @Override
          public void applyRequestMetadata(
              RequestInfo requestInfo, Executor appExecutor, MetadataApplier applier) {
            Metadata headers = new Metadata();
            headers.put(authHeaderKey, "Bearer test-token");
            applier.apply(headers);
          }
        };
    GcpFallbackProber prober =
        newProber(() -> callCredentials, GcpFallbackProber.DEFAULT_PROBE_DEADLINE);
    registry.register(new FixedSessionSource(SESSION_NAME));

    assertThat(prober.apply(channel)).isEqualTo(GcpFallbackProber.RESULT_SUCCESS);
    assertThat(service.headers).hasSize(1);
    assertThat(service.headers.get(0).get(authHeaderKey)).isEqualTo("Bearer test-token");
  }

  @Test
  public void probeSucceedsWhenCallAttributesAreNull() {
    GcpFallbackProber prober = newProber();
    registry.register(new FixedSessionSource(SESSION_NAME));

    assertThat(prober.apply(channelWithAttributes(null)))
        .isEqualTo(GcpFallbackProber.RESULT_SUCCESS);
  }

  @Test
  public void probeReportsNotDirectPathWhenTheCallCompletedOverSsl() {
    GcpFallbackProber prober = newProber();
    registry.register(new FixedSessionSource(SESSION_NAME));

    Attributes sslAttributes =
        Attributes.newBuilder()
            .set(Grpc.TRANSPORT_ATTR_SSL_SESSION, mock(SSLSession.class))
            .build();

    assertThat(prober.apply(channelWithAttributes(sslAttributes)))
        .isEqualTo(GcpFallbackProber.RESULT_NOT_DIRECTPATH);
    assertThat(service.requests).hasSize(1);
  }

  @Test
  public void probeReportsTheStatusCodeWhenTheCallFails() {
    GcpFallbackProber prober = newProber();
    registry.register(new FixedSessionSource(SESSION_NAME));
    service.failWith = Status.UNAVAILABLE.withDescription("DirectPath down");

    assertThat(prober.apply(channel)).isEqualTo(Status.Code.UNAVAILABLE.name());
  }

  @Test
  public void probeCancelsTheCallWhenTheDeadlineExpires() throws Exception {
    GcpFallbackProber prober = newProber(Duration.ofMillis(200));
    registry.register(new FixedSessionSource(SESSION_NAME));
    service.holdResponses = true;

    assertThat(prober.apply(channel)).isEqualTo(Status.Code.DEADLINE_EXCEEDED.name());
    assertThat(service.callCancelled.await(5, TimeUnit.SECONDS)).isTrue();
  }
}
