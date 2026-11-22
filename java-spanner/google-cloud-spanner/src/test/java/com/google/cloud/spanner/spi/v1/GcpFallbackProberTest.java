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
import com.google.common.collect.ImmutableMap;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SpannerGrpc;
import io.grpc.Attributes;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
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
import io.grpc.alts.internal.AltsInternalContext;
import io.grpc.alts.internal.AltsProtocolNegotiator;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
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
  private static final String OTHER_SESSION_NAME =
      "projects/my-project/instances/my-instance/databases/other-database/sessions/other-session";

  private static final Metadata.Key<String> RESOURCE_PREFIX_KEY =
      Metadata.Key.of("google-cloud-resource-prefix", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> REQUEST_PARAMS_KEY =
      Metadata.Key.of("x-goog-request-params", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> REQUEST_ID_KEY =
      Metadata.Key.of("x-goog-spanner-request-id", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> ROUTE_TO_LEADER_KEY =
      Metadata.Key.of("x-goog-spanner-route-to-leader", Metadata.ASCII_STRING_MARSHALLER);

  private static final class ProbeService extends SpannerGrpc.SpannerImplBase
      implements ServerInterceptor {
    final CopyOnWriteArrayList<GetSessionRequest> requests = new CopyOnWriteArrayList<>();
    final CopyOnWriteArrayList<Metadata> headers = new CopyOnWriteArrayList<>();
    final CountDownLatch callCancelled = new CountDownLatch(1);
    final Map<String, Status> failBySession = new ConcurrentHashMap<>();
    volatile boolean holdResponses;

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        ServerCall<ReqT, RespT> call, Metadata metadata, ServerCallHandler<ReqT, RespT> next) {
      headers.add(metadata);
      return next.startCall(call, metadata);
    }

    @Override
    public void getSession(GetSessionRequest request, StreamObserver<Session> responseObserver) {
      requests.add(request);
      ((ServerCallStreamObserver<Session>) responseObserver)
          .setOnCancelHandler(callCancelled::countDown);
      if (holdResponses) {
        return;
      }
      Status failure = failBySession.get(request.getName());
      if (failure != null) {
        responseObserver.onError(failure.asRuntimeException());
        return;
      }
      responseObserver.onNext(Session.newBuilder().setName(request.getName()).build());
      responseObserver.onCompleted();
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
            .directExecutor()
            .addService(service)
            .intercept(service)
            .build()
            .start();
    channel = InProcessChannelBuilder.forName(serverName).build();
    registry = new SessionSourceRegistry();
  }

  @After
  public void tearDown() throws Exception {
    channel.shutdownNow();
    server.shutdownNow();
    channel.awaitTermination(5, TimeUnit.SECONDS);
    server.awaitTermination(5, TimeUnit.SECONDS);
  }

  private GcpFallbackProber newProber(
      Duration rpcDeadline, @Nullable Predicate<Attributes> isDirectPathPredicate) {
    return newProber(
        rpcDeadline,
        isDirectPathPredicate,
        /* callCredentialsProvider= */ null,
        /* leaderAwareRoutingEnabled= */ true);
  }

  private GcpFallbackProber newProber(
      Duration rpcDeadline,
      @Nullable Predicate<Attributes> isDirectPathPredicate,
      @Nullable CallCredentialsProvider callCredentialsProvider,
      boolean leaderAwareRoutingEnabled) {
    GcpFallbackProber prober =
        new GcpFallbackProber(
            registry,
            SpannerMetadataProvider.create(
                ImmutableMap.of("x-goog-api-client", "test-client", "user-agent", "test-agent"),
                RESOURCE_PREFIX_KEY.name()),
            PROJECT_NAME,
            new RequestIdCreatorImpl(),
            callCredentialsProvider,
            leaderAwareRoutingEnabled,
            rpcDeadline);
    return isDirectPathPredicate == null
        ? prober
        : prober.withDirectPathPredicate(isDirectPathPredicate);
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
    GcpFallbackProber prober = newProber(GcpFallbackProber.DEFAULT_PROBE_DEADLINE, a -> true);

    assertThat(prober.apply(channel)).isEqualTo(GcpFallbackProber.RESULT_WAITING_FOR_SESSION);
    assertThat(service.requests).isEmpty();

    registry.register(() -> SESSION_NAME);
    assertThat(prober.apply(channel)).isEqualTo(GcpFallbackProber.RESULT_SUCCESS);

    assertThat(service.requests).hasSize(1);
    assertThat(service.requests.get(0).getName()).isEqualTo(SESSION_NAME);
    Metadata headers = service.headers.get(0);
    assertThat(headers.get(RESOURCE_PREFIX_KEY)).isEqualTo(DATABASE_NAME);
    assertThat(headers.get(REQUEST_PARAMS_KEY))
        .isEqualTo("name=" + URLEncoder.encode(SESSION_NAME, "UTF-8"));
    assertThat(headers.get(REQUEST_ID_KEY)).isNotEmpty();
    assertThat(headers.get(ROUTE_TO_LEADER_KEY)).isEqualTo("true");
  }

  @Test
  public void probeOmitsRouteToLeaderHeaderWhenLeaderAwareRoutingIsDisabled() {
    GcpFallbackProber prober =
        newProber(
            GcpFallbackProber.DEFAULT_PROBE_DEADLINE,
            a -> true,
            /* callCredentialsProvider= */ null,
            /* leaderAwareRoutingEnabled= */ false);
    registry.register(() -> SESSION_NAME);

    assertThat(prober.apply(channel)).isEqualTo(GcpFallbackProber.RESULT_SUCCESS);
    assertThat(service.headers.get(0).containsKey(ROUTE_TO_LEADER_KEY)).isFalse();
  }

  @Test
  public void probeAttachesCustomCallCredentialsWhenConfigured() {
    Metadata.Key<String> authKey =
        Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);
    CallCredentials customCredentials =
        new CallCredentials() {
          @Override
          public void applyRequestMetadata(
              RequestInfo requestInfo,
              java.util.concurrent.Executor appExecutor,
              MetadataApplier applier) {
            Metadata extra = new Metadata();
            extra.put(authKey, "Bearer custom-token");
            applier.apply(extra);
          }

          @Override
          public void thisUsesUnstableApi() {}
        };
    GcpFallbackProber prober =
        newProber(
            GcpFallbackProber.DEFAULT_PROBE_DEADLINE,
            a -> true,
            () -> customCredentials,
            /* leaderAwareRoutingEnabled= */ true);
    registry.register(() -> SESSION_NAME);

    assertThat(prober.apply(channel)).isEqualTo(GcpFallbackProber.RESULT_SUCCESS);
    assertThat(service.headers.get(0).get(authKey)).isEqualTo("Bearer custom-token");
  }

  @Test
  public void sessionSourceRegistryNextSessionNamesRotatesAndSkipsUnavailable() {
    assertThat(registry.nextSessionNames()).isEmpty();

    registry.register(() -> SESSION_NAME);
    registry.register(() -> null);
    registry.register(() -> OTHER_SESSION_NAME);

    assertThat(registry.nextSessionNames())
        .containsExactly(SESSION_NAME, OTHER_SESSION_NAME)
        .inOrder();
    assertThat(registry.nextSessionNames())
        .containsExactly(OTHER_SESSION_NAME, SESSION_NAME)
        .inOrder();
  }

  @Test
  public void defaultProbeVerifiesAltsFailClosed() {
    GcpFallbackProber prober = newProber(GcpFallbackProber.DEFAULT_PROBE_DEADLINE, null);
    registry.register(() -> SESSION_NAME);

    assertThat(prober.apply(channelWithAttributes(null)))
        .isEqualTo(GcpFallbackProber.RESULT_NOT_DIRECTPATH);
    assertThat(prober.apply(channelWithAttributes(Attributes.EMPTY)))
        .isEqualTo(GcpFallbackProber.RESULT_NOT_DIRECTPATH);
    Attributes sslAttributes =
        Attributes.newBuilder()
            .set(Grpc.TRANSPORT_ATTR_SSL_SESSION, mock(SSLSession.class))
            .build();
    assertThat(prober.apply(channelWithAttributes(sslAttributes)))
        .isEqualTo(GcpFallbackProber.RESULT_NOT_DIRECTPATH);

    Attributes altsAttributes =
        Attributes.newBuilder()
            .set(AltsProtocolNegotiator.AUTH_CONTEXT_KEY, AltsInternalContext.getDefaultInstance())
            .build();
    assertThat(prober.apply(channelWithAttributes(altsAttributes)))
        .isEqualTo(GcpFallbackProber.RESULT_SUCCESS);
    assertThat(service.requests).hasSize(4);
  }

  @Test
  public void probeRetriesOtherDatabasesOnlyOnPermissionDeniedOrNotFound() {
    GcpFallbackProber prober = newProber(GcpFallbackProber.DEFAULT_PROBE_DEADLINE, a -> true);
    registry.register(() -> SESSION_NAME);
    registry.register(() -> OTHER_SESSION_NAME);

    // First source PERMISSION_DENIED -> retries second source and succeeds.
    service.failBySession.put(
        SESSION_NAME, Status.PERMISSION_DENIED.withDescription("missing IAM"));
    assertThat(prober.apply(channel)).isEqualTo(GcpFallbackProber.RESULT_SUCCESS);
    assertThat(service.requests).hasSize(2);
    assertThat(service.requests.get(0).getName()).isEqualTo(SESSION_NAME);
    assertThat(service.requests.get(1).getName()).isEqualTo(OTHER_SESSION_NAME);

    // All sources return NOT_FOUND / PERMISSION_DENIED -> tries each once and fails with last code.
    service.requests.clear();
    service.failBySession.put(OTHER_SESSION_NAME, Status.NOT_FOUND);
    assertThat(prober.apply(channel)).isEqualTo(Status.Code.PERMISSION_DENIED.name());
    assertThat(service.requests).hasSize(2);

    // Transport failure UNAVAILABLE -> fails fast without trying other sources.
    service.requests.clear();
    service.failBySession.clear();
    service.failBySession.put(SESSION_NAME, Status.UNAVAILABLE);
    assertThat(prober.apply(channel)).isEqualTo(Status.Code.UNAVAILABLE.name());
    assertThat(service.requests).hasSize(1);
  }

  @Test
  public void probeCancelsRpcWhenDeadlineExpires() throws Exception {
    registry.register(() -> SESSION_NAME);
    service.holdResponses = true;
    GcpFallbackProber shortDeadlineProber = newProber(Duration.ofMillis(200), a -> true);

    assertThat(shortDeadlineProber.apply(channel)).isEqualTo(Status.Code.DEADLINE_EXCEEDED.name());
    assertThat(service.callCancelled.await(5, TimeUnit.SECONDS)).isTrue();
  }
}
