/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.internal.session;

import static com.google.cloud.bigtable.data.v2.internal.test_helpers.VRpcResultSubject.assertThat;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.longThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.FeatureFlags;
import com.google.bigtable.v2.OpenFakeSessionRequest;
import com.google.bigtable.v2.OpenFakeSessionRequest.StreamError;
import com.google.bigtable.v2.OpenSessionRequest;
import com.google.bigtable.v2.SessionFakeScriptedRequest;
import com.google.bigtable.v2.SessionFakeScriptedResponse;
import com.google.bigtable.v2.SessionRefreshConfig;
import com.google.bigtable.v2.SessionRequest;
import com.google.cloud.bigtable.data.v2.internal.api.InstanceName;
import com.google.cloud.bigtable.data.v2.internal.api.UnaryResponseFuture;
import com.google.cloud.bigtable.data.v2.internal.api.VRpcException;
import com.google.cloud.bigtable.data.v2.internal.channels.ChannelPool;
import com.google.cloud.bigtable.data.v2.internal.channels.SingleChannelPool;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcCallContext;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeClock;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeSessionService;
import com.google.cloud.bigtable.data.v2.internal.session.fake.PeerInfoInterceptor;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import com.google.common.base.Suppliers;
import com.google.common.truth.Correspondence;
import com.google.protobuf.ByteString;
import com.google.protobuf.util.Durations;
import com.google.rpc.Code;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.LongPredicate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Timeout(30)
@ExtendWith(MockitoExtension.class)
public class SessionPoolImplTest {
  private static final ClientInfo CLIENT_INFO =
      ClientInfo.builder()
          .setAppProfileId("default")
          .setInstanceName(InstanceName.parse("projects/fake-project/instances/fake-instance"))
          .build();

  private static Correspondence<SessionRequest, OpenSessionRequest>
      OPEN_SESSION_REQUEST_CORRESPONDENCE =
          Correspondence.transforming(SessionRequest::getOpenSession, "open session");

  private ScheduledExecutorService executor;
  private NettyWheelTimer testTimer;

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private Metrics metrics;

  @Mock private ClientConfigurationManager configManager;

  private Server server;
  private final VRpcTracer vrpcTracer = NoopMetrics.NoopVrpcTracer.INSTANCE;
  private ChannelPool channelPool;
  private SessionPoolImpl<OpenFakeSessionRequest> sessionPool;
  private FakeSessionService fakeService;
  private HeaderInterceptor headerInterceptor;

  @BeforeEach
  void setUp() throws IOException {
    executor = Executors.newScheduledThreadPool(4);
    testTimer =
        new NettyWheelTimer(
            "test-timer", com.google.common.util.concurrent.MoreExecutors.directExecutor());
    fakeService = new FakeSessionService(executor);
    headerInterceptor = new HeaderInterceptor();
    server =
        FakeServiceBuilder.create(fakeService)
            .intercept(new PeerInfoInterceptor())
            .intercept(headerInterceptor)
            .start();

    channelPool =
        new SingleChannelPool(
            Suppliers.ofInstance(
                Grpc.newChannelBuilderForAddress(
                        "localhost", server.getPort(), InsecureChannelCredentials.create())
                    .build()));
    channelPool.start();

    ClientConfigurationManager.ListenerHandle listenerHandle =
        Mockito.mock(ClientConfigurationManager.ListenerHandle.class);
    when(configManager.getClientConfiguration())
        .thenReturn(ClientConfigurationManager.loadDefault());
    when(configManager.addListener(any(), any())).thenReturn(listenerHandle);
    doNothing().when(listenerHandle).close();

    sessionPool =
        new SessionPoolImpl<>(
            metrics,
            FeatureFlags.getDefaultInstance(),
            CLIENT_INFO,
            configManager,
            channelPool,
            CallOptions.DEFAULT,
            FakeDescriptor.FAKE_SESSION,
            "fake-pool",
            testTimer);
  }

  @AfterEach
  void tearDown() throws InterruptedException {
    sessionPool.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionRequest.CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("close session")
            .build());
    // Wait for sessions to drain so the watchdog can be closed before testTimer.stop() races
    // with its self-reschedule loop.
    sessionPool.awaitTerminated(Duration.ofSeconds(10));
    channelPool.close();
    // channel gets shutdown in channelPool.close()
    server.shutdownNow();
    executor.shutdownNow();
    testTimer.stop();
  }

  @Test
  public void consecutiveFailuresTest() {
    com.google.rpc.Status errorStatus =
        com.google.rpc.Status.newBuilder()
            .setCode(Code.INTERNAL_VALUE)
            .setMessage("fake internal error")
            .build();

    OpenFakeSessionRequest request =
        OpenFakeSessionRequest.newBuilder()
            .setStreamError(
                StreamError.newBuilder()
                    .setStatus(errorStatus)
                    .setDelay(Durations.fromMillis(0))
                    .build())
            .build();
    sessionPool.start(request, new Metadata());

    UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
        sessionPool.newCall(FakeDescriptor.SCRIPTED);
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpc.VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, vrpcTracer),
        f);

    VRpcException exception =
        (VRpcException) assertThrows(ExecutionException.class, f::get).getCause();
    assertThat(exception)
        .hasMessageThat()
        .contains(
            "INTERNAL: Session failed with consecutive failures. Most recent server status:"
                + " Status{code=INTERNAL, description=fake internal error. PeerInfo:"
                + " transport_type: TRANSPORT_TYPE_SESSION_UNKNOWN, cause=null}");
  }

  @Test
  void pendingVRpcDrainTest() throws ExecutionException, InterruptedException, TimeoutException {
    // delay all messages to force the first vrpc to be queued

    SessionPool<OpenFakeSessionRequest> testSessionPool = null;

    // Create a channel that will delay all response messages by 10ms
    try (ChannelPool delayedPool =
        new SingleChannelPool(
            Suppliers.ofInstance(
                Grpc.newChannelBuilderForAddress(
                        "localhost", server.getPort(), InsecureChannelCredentials.create())
                    .intercept(new DelayedClientInterceptor(Duration.ofMillis(10)))
                    .build()))) {

      delayedPool.start();

      // wrap it with a session pool
      testSessionPool =
          new SessionPoolImpl<>(
              metrics,
              FeatureFlags.getDefaultInstance(),
              CLIENT_INFO,
              configManager,
              delayedPool,
              CallOptions.DEFAULT,
              FakeDescriptor.FAKE_SESSION,
              "fake-pool",
              testTimer);

      // session ack should be delayed by at least 10ms
      testSessionPool.start(OpenFakeSessionRequest.getDefaultInstance(), new Metadata());

      // Start a vRpc that will be put in the pending queue due to slow session start
      VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> vrpc =
          testSessionPool.newCall(FakeDescriptor.SCRIPTED);
      CompletableFuture<VRpcResult> resultFuture = new CompletableFuture<>();
      vrpc.start(
          SessionFakeScriptedRequest.getDefaultInstance(),
          VRpcCallContext.create(Deadline.after(1, TimeUnit.SECONDS), true, vrpcTracer),
          new VRpc.VRpcListener<SessionFakeScriptedResponse>() {
            @Override
            public void onMessage(SessionFakeScriptedResponse msg) {}

            @Override
            public void onClose(VRpcResult result) {
              resultFuture.complete(result);
            }
          });

      // Ensure that the rpc eventually succeeded
      VRpcResult result = resultFuture.get(1, TimeUnit.MINUTES);
      assertThat(result).isOk();

    } finally {
      if (testSessionPool != null) {
        testSessionPool.close(CloseSessionRequest.getDefaultInstance());
      }
    }
  }

  @Test
  void awaitTerminatedReturnsTrueWhenPoolIsEmpty() throws InterruptedException {
    // A pool that was never started has no sessions; close() should complete drainedFuture
    // immediately and awaitTerminated should return true without blocking.
    sessionPool.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionRequest.CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("empty pool")
            .build());
    assertThat(sessionPool.awaitTerminated(Duration.ofMillis(100))).isTrue();
  }

  @Test
  void awaitTerminatedReturnsTrueAfterSessionsDrain()
      throws InterruptedException, ExecutionException, TimeoutException {
    // Start a real session, issue + complete a vRPC so the session is fully open, then close
    // the pool and verify awaitTerminated returns true (sessions cleanly drained).
    sessionPool.start(OpenFakeSessionRequest.getDefaultInstance(), new Metadata());

    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> vrpc =
        sessionPool.newCall(FakeDescriptor.SCRIPTED);
    UnaryResponseFuture<SessionFakeScriptedResponse> resultFuture = new UnaryResponseFuture<>();
    vrpc.start(
        SessionFakeScriptedRequest.getDefaultInstance(),
        VRpcCallContext.create(Deadline.after(10, TimeUnit.SECONDS), true, vrpcTracer),
        resultFuture);
    resultFuture.get(10, TimeUnit.SECONDS);

    sessionPool.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionRequest.CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("after drain")
            .build());

    assertThat(sessionPool.awaitTerminated(Duration.ofSeconds(10))).isTrue();
  }

  @Test
  void closeCancelsInFlightVRpcAndDrains() throws InterruptedException {
    // Park the session-open response in the client interceptor so the vRPC cannot drain to a
    // ready session and sits in pendingRpcs. Then close the pool and verify (a) the queued
    // vRPC's listener gets a CANCELLED onClose with the "SessionPool closed:" description from
    // SessionPoolImpl.close()'s cancellation loop, (b) awaitTerminated returns true (the
    // OPENING session is driven to CLOSED by sessions.close(req), not parked until the
    // watchdog tick), and (c) no second onClose arrives once the delayed responses finally
    // flush past the interceptor.
    SessionPool<OpenFakeSessionRequest> testSessionPool = null;
    try (ChannelPool delayedPool =
        new SingleChannelPool(
            Suppliers.ofInstance(
                Grpc.newChannelBuilderForAddress(
                        "localhost", server.getPort(), InsecureChannelCredentials.create())
                    .intercept(new DelayedClientInterceptor(Duration.ofMillis(100)))
                    .build()))) {

      delayedPool.start();

      testSessionPool =
          new SessionPoolImpl<>(
              metrics,
              FeatureFlags.getDefaultInstance(),
              CLIENT_INFO,
              configManager,
              delayedPool,
              CallOptions.DEFAULT,
              FakeDescriptor.FAKE_SESSION,
              "fake-pool-in-flight",
              testTimer);

      testSessionPool.start(OpenFakeSessionRequest.getDefaultInstance(), new Metadata());

      VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> vrpc =
          testSessionPool.newCall(FakeDescriptor.SCRIPTED);
      CopyOnWriteArrayList<VRpcResult> closes = new CopyOnWriteArrayList<>();
      CountDownLatch firstClose = new CountDownLatch(1);
      Duration deadline = Duration.ofSeconds(10);
      vrpc.start(
          SessionFakeScriptedRequest.getDefaultInstance(),
          VRpcCallContext.create(
              Deadline.after(deadline.toMillis(), TimeUnit.MILLISECONDS), true, vrpcTracer),
          new VRpc.VRpcListener<SessionFakeScriptedResponse>() {
            @Override
            public void onMessage(SessionFakeScriptedResponse msg) {}

            @Override
            public void onClose(VRpcResult result) {
              closes.add(result);
              firstClose.countDown();
            }
          });

      // vRPC is now queued in pendingRpcs behind the parked session-open. Close the pool.
      testSessionPool.close(
          CloseSessionRequest.newBuilder()
              .setReason(CloseSessionRequest.CloseSessionReason.CLOSE_SESSION_REASON_USER)
              .setDescription("close while in flight")
              .build());

      // Cancellation hops through the vRPC's per-op SerializingExecutor — not the gRPC
      // listener thread — so it should arrive promptly even while the interceptor is asleep.
      assertThat(firstClose.await(2, TimeUnit.SECONDS)).isTrue();
      assertThat(closes).hasSize(1);
      VRpcResult result = closes.get(0);
      assertThat(result).status().code().isEqualTo(Status.Code.CANCELLED);
      assertThat(result).status().description().contains("SessionPool closed:");

      // OPENING session drains via sessions.close(req) once the delayed onMessages flush.
      assertThat(testSessionPool.awaitTerminated(Duration.ofSeconds(10))).isTrue();

      // Regression guard: the delayed session-open responses arriving post-cancellation must
      // not produce a phantom second onClose on the cancelled vRPC's listener.
      Thread.sleep(200);
      assertThat(closes).hasSize(1);
    } finally {
      if (testSessionPool != null) {
        testSessionPool.close(CloseSessionRequest.getDefaultInstance());
      }
    }
  }

  @Test
  void pendingVRpcOnClosedPoolDoesNotLeakDeadlineMonitor() throws InterruptedException {
    // Regression: PendingVRpc.start used to arm the deadline timer before the pool-state
    // check, so the fast-fail "pool closed" branch leaked an armed timer that fired later
    // and called listener.onClose a second time with DEADLINE_EXCEEDED.
    sessionPool.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionRequest.CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("close before issuing rpc")
            .build());

    CopyOnWriteArrayList<VRpcResult> closes = new CopyOnWriteArrayList<>();
    CountDownLatch firstClose = new CountDownLatch(1);
    Duration deadline = Duration.ofMillis(100);

    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> vrpc =
        sessionPool.newCall(FakeDescriptor.SCRIPTED);
    vrpc.start(
        SessionFakeScriptedRequest.getDefaultInstance(),
        VRpcCallContext.create(
            Deadline.after(deadline.toMillis(), TimeUnit.MILLISECONDS), true, vrpcTracer),
        new VRpc.VRpcListener<SessionFakeScriptedResponse>() {
          @Override
          public void onMessage(SessionFakeScriptedResponse msg) {}

          @Override
          public void onClose(VRpcResult result) {
            closes.add(result);
            firstClose.countDown();
          }
        });

    // The fast-fail UNAVAILABLE onClose should arrive immediately.
    assertThat(firstClose.await(1, TimeUnit.SECONDS)).isTrue();
    assertThat(closes).hasSize(1);

    // Wait past the deadline. With the bug (leaked deadlineMonitor), a phantom
    // onClose(DEADLINE_EXCEEDED) would arrive in this window. With the fix, no second close.
    Thread.sleep(deadline.toMillis() * 5);
    assertThat(closes).hasSize(1);
  }

  @Test
  void testCreateSessionDoesntPropagateDeadline() {
    DeadlineInterceptor deadlineInterceptor = new DeadlineInterceptor();
    try (ChannelPool capturedDeadlinePool =
        new SingleChannelPool(
            Suppliers.ofInstance(
                Grpc.newChannelBuilderForAddress(
                        "localhost", server.getPort(), InsecureChannelCredentials.create())
                    .intercept(deadlineInterceptor)
                    .build()))) {

      capturedDeadlinePool.start();

      SessionPoolImpl<OpenFakeSessionRequest> testSessionPool =
          new SessionPoolImpl<>(
              metrics,
              FeatureFlags.getDefaultInstance(),
              CLIENT_INFO,
              configManager,
              capturedDeadlinePool,
              CallOptions.DEFAULT,
              FakeDescriptor.FAKE_SESSION,
              "fake-pool",
              testTimer);

      Context.current()
          .withDeadlineAfter(1, TimeUnit.MINUTES, executor)
          .run(
              () ->
                  testSessionPool.start(
                      OpenFakeSessionRequest.getDefaultInstance(), new Metadata()));

      assertThat(deadlineInterceptor.getObservedDeadline()).isNull();

      testSessionPool.close(CloseSessionRequest.getDefaultInstance());
    }
  }

  @Nested
  class RetrySessionCreation {

    private FakeClock fakeClock;
    private BigtableTimer mockTimer;
    private FakeSessionService fakeService;
    private ChannelPool channelPool;
    private SessionPoolImpl<OpenFakeSessionRequest> sessionPool;

    private final Duration penalty = Duration.ofMinutes(1);

    @BeforeEach
    void setUp() throws Exception {
      fakeClock = new FakeClock(Instant.now());
      // The retry-create-session site uses timer.newTimeout(); we capture the scheduled body on a
      // mock timer and run it inline below.
      mockTimer = mock(BigtableTimer.class, Mockito.RETURNS_DEEP_STUBS);

      Duration penalty = Duration.ofMinutes(1);
      SessionCreationBudget budget = new SessionCreationBudget(10, penalty, fakeClock);

      fakeService = new FakeSessionService(executor);
      Server rejectRequestServer =
          FakeServiceBuilder.create(fakeService).intercept(new PeerInfoInterceptor()).start();

      channelPool =
          new SingleChannelPool(
              Suppliers.ofInstance(
                  Grpc.newChannelBuilderForAddress(
                          "localhost",
                          rejectRequestServer.getPort(),
                          InsecureChannelCredentials.create())
                      .build()));
      channelPool.start();

      sessionPool =
          new SessionPoolImpl<>(
              metrics,
              FeatureFlags.getDefaultInstance(),
              CLIENT_INFO,
              configManager,
              channelPool,
              CallOptions.DEFAULT,
              FakeDescriptor.FAKE_SESSION,
              "fake-pool",
              mockTimer,
              budget);
    }

    @AfterEach
    void tearDown() {
      sessionPool.close(
          CloseSessionRequest.newBuilder()
              .setReason(CloseSessionRequest.CloseSessionReason.CLOSE_SESSION_REASON_USER)
              .setDescription("close session")
              .build());
      server.shutdown();
      channelPool.close();
    }

    @Test
    public void test() throws Exception {
      ArgumentCaptor<Runnable> runnableCaptor = ArgumentCaptor.forClass(Runnable.class);
      // Filter out watchdog (5 min, exact) and AFE prune (10 min, exact) ticks. The
      // retry-create-session site computes its delay against the real wall clock and the fake
      // budget clock, so it can land anywhere from sub-second to a couple of penalty intervals.
      // Match anything that isn't one of the two fixed cadences.
      long watchdogMs = Duration.ofMinutes(5).toMillis();
      long afePruneMs = SessionList.SESSION_LIST_PRUNE_INTERVAL.toMillis();
      LongPredicate isRetrySchedule = d -> d > 0 && d != watchdogMs && d != afePruneMs;

      // start the pool
      sessionPool.start(
          OpenFakeSessionRequest.newBuilder()
              .setStreamError(StreamError.getDefaultInstance())
              .build(),
          new Metadata());

      // Session creations should fail and a task to retry session creation should be scheduled.
      // The delay should be around budget creation failure penalty. It'll take some time for the
      // job to exhaust all the creation budget so set a delay before verifying.
      int waitForReadyMs = 1000;
      verify(mockTimer, Mockito.timeout(waitForReadyMs))
          .newTimeout(
              runnableCaptor.capture(), longThat(isRetrySchedule::test), eq(TimeUnit.MILLISECONDS));

      // we should have received some open requests
      int requestsBefore = fakeService.getOpenRequestCount().get();
      assertThat(requestsBefore).isGreaterThan(0);

      // vrpc will queue in the PendingVRpcs queue
      VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> vrpc =
          sessionPool.newCall(FakeDescriptor.SCRIPTED);
      UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
      vrpc.start(
          SessionFakeScriptedRequest.getDefaultInstance(),
          VRpcCallContext.create(Deadline.after(1, TimeUnit.SECONDS), true, vrpcTracer),
          f);

      // Advance the clock so there's more budget to create sessions
      fakeClock.increment(penalty.plusMillis(1));

      // Run the scheduled timer body inline. The body executes the retry which schedules another
      // timer tick.
      runnableCaptor.getValue().run();

      // The retry task will try to open new sessions. This will fail and schedule another retry.
      verify(mockTimer, Mockito.timeout(5000).times(2))
          .newTimeout(
              any(Runnable.class), longThat(isRetrySchedule::test), eq(TimeUnit.MILLISECONDS));

      // the retry will exhaust the budget again. we should see double the request compared to
      // before
      int requestsAfter = fakeService.getOpenRequestCount().get();
      assertThat(requestsAfter).isGreaterThan(requestsBefore);
    }
  }

  @Test
  public void refreshConfigTest() throws Exception {
    OpenSessionRequest refreshRequest =
        OpenSessionRequest.newBuilder()
            .setPayload(OpenFakeSessionRequest.getDefaultInstance().toByteString())
            .build();
    String refreshHeaderKey = "x-refresh-header";
    Metadata.Key metadataKey = Metadata.Key.of(refreshHeaderKey, Metadata.ASCII_STRING_MARSHALLER);
    SessionRefreshConfig refreshConfig =
        SessionRefreshConfig.newBuilder()
            .setOptimizedOpenRequest(refreshRequest)
            .addMetadata(
                SessionRefreshConfig.Metadata.newBuilder()
                    .setKey(refreshHeaderKey)
                    .setValue(ByteString.copyFromUtf8("refresh_value")))
            .build();

    OpenFakeSessionRequest request =
        OpenFakeSessionRequest.newBuilder()
            .setRefreshConfig(refreshConfig)
            .setRefreshConfigDelay(Durations.fromMillis(100))
            .setGoAwayDelay(Durations.fromMillis(120))
            .build();

    sessionPool.start(request, new Metadata());

    long deadline = System.currentTimeMillis() + 10_000;
    boolean conditionMet = false;
    List<SessionRequest> requests = null;
    boolean containsHeader = false;

    while (System.currentTimeMillis() < deadline) {
      requests = fakeService.getSessionRequests();
      List<Metadata> headers = headerInterceptor.getHeadersList();

      boolean matchesRefreshRequest = false;
      for (SessionRequest r : requests) {
        if (OPEN_SESSION_REQUEST_CORRESPONDENCE.compare(r, refreshRequest)) {
          matchesRefreshRequest = true;
          break;
        }
      }

      containsHeader = false;
      for (Metadata header : headers) {
        if (header.containsKey(metadataKey) && "refresh_value".equals(header.get(metadataKey))) {
          containsHeader = true;
          break;
        }
      }

      if (requests.size() > 1 && matchesRefreshRequest && containsHeader) {
        conditionMet = true;
        break;
      }

      Thread.sleep(50);
    }

    assertThat(conditionMet).isTrue();
    assertThat(requests.size()).isGreaterThan(1);
    assertThat(requests)
        .comparingElementsUsing(OPEN_SESSION_REQUEST_CORRESPONDENCE)
        .contains(refreshRequest);
    assertThat(containsHeader).isTrue();
  }

  private static class DelayedClientInterceptor implements ClientInterceptor {
    private final Duration delay;

    private DelayedClientInterceptor(Duration delay) {
      this.delay = delay;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
      return new SimpleForwardingClientCall<ReqT, RespT>(
          channel.newCall(methodDescriptor, callOptions)) {
        @Override
        public void start(Listener<RespT> responseListener, Metadata headers) {
          super.start(
              new SimpleForwardingClientCallListener<RespT>(responseListener) {
                @Override
                public void onMessage(RespT message) {
                  try {
                    // delay all messages to force the first vrpc to be queued
                    Thread.sleep(delay.toMillis());
                  } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                  }
                  super.onMessage(message);
                }
              },
              headers);
        }
      };
    }
  }

  private static class DeadlineInterceptor implements ClientInterceptor {
    private volatile Deadline observedDeadline;

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
      if (method.getBareMethodName().equals("OpenSession")) {
        observedDeadline = Context.current().getDeadline();
      }
      return next.newCall(method, callOptions);
    }

    public Deadline getObservedDeadline() {
      return observedDeadline;
    }
  }

  private static class HeaderInterceptor implements ServerInterceptor {
    private final List<Metadata> headersList = new CopyOnWriteArrayList<>();

    @Override
    public <ReqT, RespT> io.grpc.ServerCall.Listener<ReqT> interceptCall(
        ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
      headersList.add(headers);
      return next.startCall(call, headers);
    }

    public List<Metadata> getHeadersList() {
      return headersList;
    }
  }
}
