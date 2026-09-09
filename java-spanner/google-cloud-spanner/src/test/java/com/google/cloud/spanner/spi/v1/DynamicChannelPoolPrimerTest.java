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
import static org.junit.Assert.assertThrows;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerOptions.CallCredentialsProvider;
import com.google.cloud.spanner.XGoogSpannerRequestId;
import com.google.cloud.spanner.spi.v1.SpannerRpc.ChannelPrimeSessionSource;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.SpannerGrpc;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.auth.MoreCallCredentials;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DynamicChannelPoolPrimerTest {
  private static final String PROJECT_NAME = "projects/my-project";
  private static final String DATABASE_NAME =
      "projects/my-project/instances/my-instance/databases/my-database";
  private static final String OTHER_DATABASE_NAME =
      "projects/my-project/instances/my-instance/databases/other-database";
  private static final String SESSION_NAME = DATABASE_NAME + "/sessions/multiplexed-session";
  private static final String REFRESHED_SESSION_NAME =
      DATABASE_NAME + "/sessions/refreshed-session";
  private static final String OTHER_SESSION_NAME = OTHER_DATABASE_NAME + "/sessions/other-session";
  private static final String RESOURCE_HEADER_KEY = "google-cloud-resource-prefix";
  private static final String DEFAULT_TOKEN = "default-token";
  private static final String PROVIDER_TOKEN = "provider-token";

  private static final Metadata.Key<String> AUTHORIZATION_KEY =
      Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> API_CLIENT_KEY =
      Metadata.Key.of("x-goog-api-client", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> RESOURCE_PREFIX_KEY =
      Metadata.Key.of(RESOURCE_HEADER_KEY, Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> REQUEST_PARAMS_KEY =
      Metadata.Key.of("x-goog-request-params", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> ROUTE_TO_LEADER_KEY =
      Metadata.Key.of("x-goog-spanner-route-to-leader", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> REQUEST_ID_KEY =
      Metadata.Key.of("x-goog-spanner-request-id", Metadata.ASCII_STRING_MARSHALLER);

  /** Minimal Spanner service that only serves ExecuteSql and can hold or fail calls. */
  private static final class PrimeService extends SpannerGrpc.SpannerImplBase {
    final List<ExecuteSqlRequest> requests = new CopyOnWriteArrayList<>();
    final List<Metadata> headers = new CopyOnWriteArrayList<>();
    volatile boolean holdResponses;
    volatile CountDownLatch callStarted = new CountDownLatch(1);
    volatile CountDownLatch callCancelled = new CountDownLatch(1);
    @Nullable volatile Status failWith;

    @Override
    public void executeSql(ExecuteSqlRequest request, StreamObserver<ResultSet> responseObserver) {
      requests.add(request);
      ServerCallStreamObserver<ResultSet> serverObserver =
          (ServerCallStreamObserver<ResultSet>) responseObserver;
      serverObserver.setOnCancelHandler(() -> callCancelled.countDown());
      callStarted.countDown();
      if (holdResponses) {
        return;
      }
      Status failure = failWith;
      if (failure != null) {
        responseObserver.onError(failure.asRuntimeException());
        return;
      }
      responseObserver.onNext(ResultSet.getDefaultInstance());
      responseObserver.onCompleted();
    }
  }

  private PrimeService service;
  private Server server;
  private String serverNameForChannels;
  private final List<ManagedChannel> channels = new ArrayList<>();
  private final RequestIdCreatorImpl requestIdCreator = new RequestIdCreatorImpl();

  @Before
  public void setUp() throws Exception {
    service = new PrimeService();
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
    serverNameForChannels = serverName;
  }

  @After
  public void tearDown() throws Exception {
    for (ManagedChannel channel : channels) {
      channel.shutdownNow();
    }
    server.shutdownNow();
    server.awaitTermination(5, TimeUnit.SECONDS);
  }

  private ManagedChannel newChannel() {
    return newChannel(InProcessChannelBuilder.forName(serverNameForChannels));
  }

  private ManagedChannel newChannel(InProcessChannelBuilder builder) {
    ManagedChannel channel = builder.build();
    channels.add(channel);
    return channel;
  }

  /**
   * Returns a channel that carries what the delegate channel of the dynamic channel pool carries:
   * the fixed headers of the client through the GAX header interceptor, and the request id
   * interceptor of the client.
   */
  private ManagedChannel newDelegateLikeChannel() {
    Metadata fixedHeaders = new Metadata();
    fixedHeaders.put(API_CLIENT_KEY, "test-client");
    return newChannel(
        InProcessChannelBuilder.forName(serverNameForChannels)
            .intercept(
                new RequestIdInterceptor(),
                new ClientInterceptor() {
                  @Override
                  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
                      MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
                    return new SimpleForwardingClientCall<ReqT, RespT>(
                        next.newCall(method, callOptions)) {
                      @Override
                      public void start(Listener<RespT> responseListener, Metadata headers) {
                        headers.merge(fixedHeaders);
                        super.start(responseListener, headers);
                      }
                    };
                  }
                }));
  }

  private static CallCredentials credentialsWithToken(String token) {
    return MoreCallCredentials.from(oauthCredentialsWithToken(token));
  }

  private static OAuth2Credentials oauthCredentialsWithToken(String token) {
    return OAuth2Credentials.create(
        new AccessToken(token, new Date(System.currentTimeMillis() + 3_600_000L)));
  }

  private DynamicChannelPoolPrimer newPrimer(
      @Nullable CallCredentialsProvider callCredentialsProvider, Duration rpcDeadline) {
    // The fixed headers of the client are configured on the channel and must not be sent by the
    // primer: it only sends the headers that a normal call adds per call.
    SpannerMetadataProvider metadataProvider =
        SpannerMetadataProvider.create(
            ImmutableMap.of("x-goog-api-client", "test-client", "user-agent", "test-agent"),
            RESOURCE_HEADER_KEY);
    return new DynamicChannelPoolPrimer(
        metadataProvider, PROJECT_NAME, requestIdCreator, callCredentialsProvider, rpcDeadline);
  }

  private DynamicChannelPoolPrimer newPrimer() {
    return newPrimer(() -> credentialsWithToken(DEFAULT_TOKEN), Duration.ofSeconds(5));
  }

  private static class MutableSessionSource implements ChannelPrimeSessionSource {
    @Nullable volatile String sessionName;

    private MutableSessionSource(@Nullable String sessionName) {
      this.sessionName = sessionName;
    }

    @Override
    @Nullable
    public String getChannelPrimeSessionName() {
      return sessionName;
    }
  }

  private static final class EqualSessionSource extends MutableSessionSource {
    private EqualSessionSource(String sessionName) {
      super(sessionName);
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof EqualSessionSource;
    }

    @Override
    public int hashCode() {
      return 1;
    }
  }

  private static MutableSessionSource registerPrimeSession(
      DynamicChannelPoolPrimer primer, String databaseName, String sessionName) {
    MutableSessionSource source = new MutableSessionSource(sessionName);
    primer.registerPrimeSessionSource(source);
    return source;
  }

  private static <T> T getWithin(ListenableFuture<T> future, Duration timeout) throws Exception {
    return future.get(timeout.toMillis(), TimeUnit.MILLISECONDS);
  }

  private static Throwable failureOf(ListenableFuture<?> future) throws Exception {
    ExecutionException exception =
        assertThrows(ExecutionException.class, () -> getWithin(future, Duration.ofSeconds(10)));
    return exception.getCause();
  }

  /** Returns the request id header of the given call, asserting that there is exactly one. */
  private static XGoogSpannerRequestId requestIdOf(Metadata headers) {
    List<String> values = ImmutableList.copyOf(headers.getAll(REQUEST_ID_KEY));
    assertThat(values).hasSize(1);
    return XGoogSpannerRequestId.of(values.get(0));
  }

  /** Asserts the per-call headers that every priming RPC carries. */
  private void assertPrimeHeaders(Metadata headers, String expectedToken) throws Exception {
    assertThat(headers.getAll(AUTHORIZATION_KEY)).containsExactly("Bearer " + expectedToken);
    assertThat(headers.getAll(RESOURCE_PREFIX_KEY)).containsExactly(DATABASE_NAME);
    assertThat(headers.getAll(REQUEST_PARAMS_KEY))
        .containsExactly("session=" + urlEncode(SESSION_NAME));
    assertThat(headers.containsKey(ROUTE_TO_LEADER_KEY)).isFalse();
    XGoogSpannerRequestId requestId = requestIdOf(headers);
    assertThat(requestId.getHeaderValue())
        .isEqualTo(
            XGoogSpannerRequestId.of(
                    requestIdCreator.getClientId(),
                    DynamicChannelPoolPrimer.REQUEST_ID_CHANNEL,
                    requestNumberOf(requestId),
                    /* attempt= */ 1)
                .getHeaderValue());
  }

  /** Returns the request number of the given request id. */
  private static long requestNumberOf(XGoogSpannerRequestId requestId) {
    // <version>.<process id>.<client id>.<channel id>.<request number>.<attempt>
    String[] parts = requestId.getHeaderValue().split("\\.");
    assertThat(parts).hasLength(6);
    return Long.parseLong(parts[4]);
  }

  private static String urlEncode(String value) throws Exception {
    return java.net.URLEncoder.encode(value, "UTF-8");
  }

  @Test
  public void primeExecutesSelectOneWithSessionAndHeaders() throws Exception {
    DynamicChannelPoolPrimer primer = newPrimer();
    registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);

    ListenableFuture<Void> future = primer.prime(newChannel());

    assertThat(getWithin(future, Duration.ofSeconds(10))).isNull();
    assertThat(service.requests).hasSize(1);
    ExecuteSqlRequest request = service.requests.get(0);
    assertThat(request.getSession()).isEqualTo(SESSION_NAME);
    assertThat(request.getSql()).isEqualTo("SELECT 1");
    // A single-use read-only query: no transaction selector.
    assertThat(request.hasTransaction()).isFalse();

    assertThat(service.headers).hasSize(1);
    Metadata headers = service.headers.get(0);
    assertPrimeHeaders(headers, DEFAULT_TOKEN);
    // The fixed headers of the client are carried by the delegate channel itself and must not be
    // sent by the primer, or the delegate would send them twice.
    assertThat(headers.containsKey(API_CLIENT_KEY)).isFalse();
  }

  @Test
  public void primeSendsEveryHeaderOnceOnDelegateThatCarriesFixedHeaders() throws Exception {
    DynamicChannelPoolPrimer primer = newPrimer();
    registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);

    getWithin(primer.prime(newDelegateLikeChannel()), Duration.ofSeconds(10));

    Metadata headers = service.headers.get(0);
    assertPrimeHeaders(headers, DEFAULT_TOKEN);
    assertThat(headers.getAll(API_CLIENT_KEY)).containsExactly("test-client");
  }

  @Test
  public void everyPrimeCarriesFreshRequestIdWithFirstAttempt() throws Exception {
    DynamicChannelPoolPrimer primer = newPrimer();
    registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);
    ManagedChannel channel = newChannel();

    // The pool invokes prime() once per attempt, so each attempt is a new request id.
    getWithin(primer.prime(channel), Duration.ofSeconds(10));
    getWithin(primer.prime(channel), Duration.ofSeconds(10));

    assertThat(service.headers).hasSize(2);
    XGoogSpannerRequestId first = requestIdOf(service.headers.get(0));
    XGoogSpannerRequestId second = requestIdOf(service.headers.get(1));
    assertThat(second).isNotEqualTo(first);
    assertThat(requestNumberOf(second)).isGreaterThan(requestNumberOf(first));
    assertThat(second.getLogicalRequestKey()).isNotEqualTo(first.getLogicalRequestKey());
  }

  @Test
  public void primeOmitsRouteToLeaderHeader() throws Exception {
    DynamicChannelPoolPrimer primer = newPrimer();
    registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);

    getWithin(primer.prime(newChannel()), Duration.ofSeconds(10));

    assertThat(service.headers.get(0).containsKey(ROUTE_TO_LEADER_KEY)).isFalse();
  }

  @Test
  public void primeUsesCallCredentialsProviderOverDefaultCredentials() throws Exception {
    CallCredentialsProvider credentialsProvider =
        GapicSpannerRpc.createChannelPrimeCallCredentialsProvider(
            () -> oauthCredentialsWithToken(DEFAULT_TOKEN),
            () -> credentialsWithToken(PROVIDER_TOKEN));
    DynamicChannelPoolPrimer primer = newPrimer(credentialsProvider, Duration.ofSeconds(5));
    registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);

    getWithin(primer.prime(newChannel()), Duration.ofSeconds(10));

    assertThat(service.headers.get(0).getAll(AUTHORIZATION_KEY))
        .containsExactly("Bearer " + PROVIDER_TOKEN);
  }

  @Test
  public void primeFallsBackToDefaultCredentialsWhenProviderReturnsNull() throws Exception {
    CallCredentialsProvider credentialsProvider =
        GapicSpannerRpc.createChannelPrimeCallCredentialsProvider(
            () -> oauthCredentialsWithToken(DEFAULT_TOKEN), () -> null);
    DynamicChannelPoolPrimer primer = newPrimer(credentialsProvider, Duration.ofSeconds(5));
    registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);

    getWithin(primer.prime(newChannel()), Duration.ofSeconds(10));

    assertThat(service.headers.get(0).getAll(AUTHORIZATION_KEY))
        .containsExactly("Bearer " + DEFAULT_TOKEN);
  }

  @Test
  public void primeOmitsCredentialsWithoutProviderOrDefaultCredentials() throws Exception {
    CallCredentialsProvider credentialsProvider =
        GapicSpannerRpc.createChannelPrimeCallCredentialsProvider(() -> null, null);
    DynamicChannelPoolPrimer primer = newPrimer(credentialsProvider, Duration.ofSeconds(5));
    registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);

    getWithin(primer.prime(newChannel()), Duration.ofSeconds(10));

    assertThat(service.headers.get(0).containsKey(AUTHORIZATION_KEY)).isFalse();
  }

  @Test
  public void primeReturnsFailedFutureWhenCallCredentialsProviderThrows() throws Exception {
    RuntimeException expected = new RuntimeException("credentials unavailable");
    DynamicChannelPoolPrimer primer =
        newPrimer(
            () -> {
              throw expected;
            },
            Duration.ofSeconds(5));
    registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);

    ListenableFuture<Void> future = primer.prime(newChannel());

    assertThat(failureOf(future)).isSameInstanceAs(expected);
  }

  @Test
  public void primeFailsWhenRpcFails() throws Exception {
    service.failWith = Status.UNAVAILABLE.withDescription("backend unavailable");
    DynamicChannelPoolPrimer primer = newPrimer();
    registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);

    Throwable failure = failureOf(primer.prime(newChannel()));

    assertThat(failure).isInstanceOf(StatusRuntimeException.class);
    assertThat(((StatusRuntimeException) failure).getStatus().getCode())
        .isEqualTo(Status.Code.UNAVAILABLE);
    // A transient failure says nothing about the session, so it stays registered.
    assertThat(primer.getPrimeSessionName()).isEqualTo(SESSION_NAME);
  }

  @Test
  public void primeFailsWithDeadlineExceededWhenServerDoesNotRespond() throws Exception {
    service.holdResponses = true;
    DynamicChannelPoolPrimer primer =
        newPrimer(() -> credentialsWithToken(DEFAULT_TOKEN), Duration.ofMillis(200));
    registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);

    Throwable failure = failureOf(primer.prime(newChannel()));

    assertThat(failure).isInstanceOf(StatusRuntimeException.class);
    assertThat(((StatusRuntimeException) failure).getStatus().getCode())
        .isEqualTo(Status.Code.DEADLINE_EXCEEDED);
    // The deadline cancels the server-side call as well.
    assertThat(service.callCancelled.await(5, TimeUnit.SECONDS)).isTrue();
    // A deadline says nothing about the session, so it stays registered.
    assertThat(primer.getPrimeSessionName()).isEqualTo(SESSION_NAME);
  }

  @Test
  public void cancellingPrimeCancelsRpc() throws Exception {
    service.holdResponses = true;
    DynamicChannelPoolPrimer primer = newPrimer();
    registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);

    ListenableFuture<Void> future = primer.prime(newChannel());
    assertThat(service.callStarted.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(future.isDone()).isFalse();

    assertThat(future.cancel(true)).isTrue();

    assertThat(future.isCancelled()).isTrue();
    assertThat(service.callCancelled.await(5, TimeUnit.SECONDS)).isTrue();
  }

  @Test
  public void primeFailsWhenChannelIsShutDownDuringRpc() throws Exception {
    service.holdResponses = true;
    DynamicChannelPoolPrimer primer = newPrimer();
    registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);
    ManagedChannel channel = newChannel();

    ListenableFuture<Void> future = primer.prime(channel);
    assertThat(service.callStarted.await(5, TimeUnit.SECONDS)).isTrue();
    channel.shutdownNow();

    Throwable failure = failureOf(future);
    assertThat(failure).isInstanceOf(StatusRuntimeException.class);
    assertThat(future.isCancelled()).isFalse();
  }

  @Test
  public void primeOnShutDownChannelFailsPromptly() throws Exception {
    DynamicChannelPoolPrimer primer = newPrimer();
    registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);
    ManagedChannel channel = newChannel();
    channel.shutdownNow();

    Throwable failure = failureOf(primer.prime(channel));

    assertThat(failure).isInstanceOf(StatusRuntimeException.class);
  }

  @Test
  public void primeFailsWithFailedPreconditionWithoutSession() throws Exception {
    DynamicChannelPoolPrimer primer = newPrimer();

    ListenableFuture<Void> future = primer.prime(newChannel());

    assertThat(future.isDone()).isTrue();
    Throwable failure = failureOf(future);
    assertThat(failure).isInstanceOf(SpannerException.class);
    assertThat(((SpannerException) failure).getErrorCode())
        .isEqualTo(ErrorCode.FAILED_PRECONDITION);
    assertThat(service.requests).isEmpty();
  }

  @Test
  public void concurrentPrimesOnOneChannelAllSucceed() throws Exception {
    DynamicChannelPoolPrimer primer = newPrimer();
    registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);
    ManagedChannel channel = newChannel();

    List<ListenableFuture<Void>> futures = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      futures.add(primer.prime(channel));
    }
    for (ListenableFuture<Void> future : futures) {
      assertThat(getWithin(future, Duration.ofSeconds(10))).isNull();
    }
    assertThat(service.requests).hasSize(5);
  }

  @Test
  public void latestRegisteredSessionIsUsedForPriming() throws Exception {
    DynamicChannelPoolPrimer primer = newPrimer();
    assertThat(primer.getPrimeSessionName()).isNull();

    MutableSessionSource source = registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);
    assertThat(primer.getPrimeSessionName()).isEqualTo(SESSION_NAME);
    getWithin(primer.prime(newChannel()), Duration.ofSeconds(10));

    // Refreshing changes what the source returns without changing its registration.
    source.sessionName = REFRESHED_SESSION_NAME;
    assertThat(primer.getPrimeSessionName()).isEqualTo(REFRESHED_SESSION_NAME);
    assertThat(primer.getPrimeSessionSources()).containsExactly(source);
    getWithin(primer.prime(newChannel()), Duration.ofSeconds(10));

    assertThat(service.requests).hasSize(2);
    assertThat(service.requests.get(0).getSession()).isEqualTo(SESSION_NAME);
    assertThat(service.requests.get(1).getSession()).isEqualTo(REFRESHED_SESSION_NAME);
  }

  @Test
  public void primeAttemptsRotateAcrossAvailableSources() {
    DynamicChannelPoolPrimer primer = newPrimer();
    MutableSessionSource first = registerPrimeSession(primer, DATABASE_NAME, SESSION_NAME);
    MutableSessionSource second =
        registerPrimeSession(primer, OTHER_DATABASE_NAME, OTHER_SESSION_NAME);

    assertThat(primer.getPrimeSessionName()).isEqualTo(SESSION_NAME);
    assertThat(primer.getPrimeSessionName()).isEqualTo(OTHER_SESSION_NAME);
    assertThat(primer.getPrimeSessionName()).isEqualTo(SESSION_NAME);

    // An unavailable source is skipped without blocking, while the cursor still advances.
    first.sessionName = null;
    assertThat(primer.getPrimeSessionName()).isEqualTo(OTHER_SESSION_NAME);
    assertThat(primer.getPrimeSessionName()).isEqualTo(OTHER_SESSION_NAME);
    assertThat(primer.getPrimeSessionSources()).containsExactly(first, second).inOrder();
  }

  @Test
  public void unregisterIsTargetedAndIdempotent() {
    DynamicChannelPoolPrimer primer = newPrimer();
    EqualSessionSource first = new EqualSessionSource(SESSION_NAME);
    EqualSessionSource second = new EqualSessionSource(OTHER_SESSION_NAME);
    assertThat(first).isEqualTo(second);
    primer.registerPrimeSessionSource(first);
    primer.registerPrimeSessionSource(first);
    primer.registerPrimeSessionSource(second);

    primer.unregisterPrimeSessionSource(first);
    primer.unregisterPrimeSessionSource(first);

    assertThat(primer.getPrimeSessionSources()).containsExactly(second);
    assertThat(primer.getPrimeSessionName()).isEqualTo(OTHER_SESSION_NAME);
    primer.unregisterPrimeSessionSource(second);
    assertThat(primer.getPrimeSessionSources()).isEmpty();
    assertThat(primer.getPrimeSessionName()).isNull();
  }

  @Test
  public void rpcDeadlineNormallyStaysBelowPoolPrimeTimeout() {
    // The default prime timeout of 10 seconds is capped at the maximum RPC deadline.
    assertThat(DynamicChannelPoolPrimer.rpcDeadlineFor(Duration.ofSeconds(10)))
        .isEqualTo(Duration.ofSeconds(5));
    assertThat(DynamicChannelPoolPrimer.rpcDeadlineFor(Duration.ofSeconds(6)))
        .isEqualTo(Duration.ofSeconds(5));
    // Below that, the deadline keeps the safety margin below the prime timeout.
    assertThat(DynamicChannelPoolPrimer.rpcDeadlineFor(Duration.ofSeconds(4)))
        .isEqualTo(Duration.ofSeconds(3));
    assertThat(DynamicChannelPoolPrimer.rpcDeadlineFor(Duration.ofSeconds(2)))
        .isEqualTo(Duration.ofSeconds(1));
    // Very short prime timeouts never drop the deadline below half of the prime timeout.
    assertThat(DynamicChannelPoolPrimer.rpcDeadlineFor(Duration.ofMillis(1500)))
        .isEqualTo(Duration.ofMillis(750));
    assertThat(DynamicChannelPoolPrimer.rpcDeadlineFor(Duration.ofMillis(200)))
        .isEqualTo(Duration.ofMillis(100));
    // Prime timeouts of at most twice the minimum deadline are clamped to the minimum deadline,
    // which then reaches (2 ms) or exceeds (1 ms, 1 ns) the prime timeout itself; the pool's own
    // prime timeout bounds the attempt in that case.
    assertThat(DynamicChannelPoolPrimer.rpcDeadlineFor(Duration.ofMillis(3)))
        .isEqualTo(Duration.ofNanos(1_500_000L));
    assertThat(DynamicChannelPoolPrimer.rpcDeadlineFor(Duration.ofMillis(2)))
        .isEqualTo(DynamicChannelPoolPrimer.MIN_RPC_DEADLINE);
    assertThat(DynamicChannelPoolPrimer.rpcDeadlineFor(Duration.ofMillis(1)))
        .isEqualTo(DynamicChannelPoolPrimer.MIN_RPC_DEADLINE);
    assertThat(DynamicChannelPoolPrimer.rpcDeadlineFor(Duration.ofNanos(1)))
        .isEqualTo(DynamicChannelPoolPrimer.MIN_RPC_DEADLINE);
    // The clamped deadline is accepted by the primer.
    assertThat(
            newPrimer(
                    /* callCredentialsProvider= */ null,
                    DynamicChannelPoolPrimer.rpcDeadlineFor(Duration.ofNanos(1)))
                .getRpcDeadline())
        .isEqualTo(DynamicChannelPoolPrimer.MIN_RPC_DEADLINE);
    assertThrows(
        IllegalArgumentException.class,
        () -> DynamicChannelPoolPrimer.rpcDeadlineFor(Duration.ZERO));
    assertThrows(
        IllegalArgumentException.class,
        () -> DynamicChannelPoolPrimer.rpcDeadlineFor(Duration.ofSeconds(-1)));
    assertThrows(
        IllegalArgumentException.class, () -> DynamicChannelPoolPrimer.rpcDeadlineFor(null));
  }

  @Test
  public void nullSourcesAreRejected() {
    DynamicChannelPoolPrimer primer = newPrimer();

    assertThrows(NullPointerException.class, () -> primer.registerPrimeSessionSource(null));
    assertThrows(NullPointerException.class, () -> primer.unregisterPrimeSessionSource(null));
    assertThat(primer.getPrimeSessionSources()).isEmpty();
  }
}
