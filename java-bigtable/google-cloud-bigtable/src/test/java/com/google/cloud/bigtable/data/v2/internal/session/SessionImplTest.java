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

import static com.google.cloud.bigtable.data.v2.internal.test_helpers.StatusSubject.assertThat;
import static com.google.cloud.bigtable.data.v2.internal.test_helpers.VRpcResultSubject.assertThat;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.CloseSessionRequest.CloseSessionReason;
import com.google.bigtable.v2.ClusterInformation;
import com.google.bigtable.v2.ErrorResponse;
import com.google.bigtable.v2.FakeSessionOpResponse;
import com.google.bigtable.v2.GoAwayResponse;
import com.google.bigtable.v2.OpenFakeSessionRequest;
import com.google.bigtable.v2.OpenFakeSessionRequest.Action;
import com.google.bigtable.v2.OpenFakeSessionRequest.ActionList;
import com.google.bigtable.v2.OpenFakeSessionRequest.StreamError;
import com.google.bigtable.v2.OpenSessionRequest;
import com.google.bigtable.v2.OpenSessionResponse;
import com.google.bigtable.v2.SessionFakeScriptedRequest;
import com.google.bigtable.v2.SessionFakeScriptedResponse;
import com.google.bigtable.v2.SessionParametersResponse;
import com.google.bigtable.v2.SessionRequest;
import com.google.bigtable.v2.VirtualRpcResponse;
import com.google.cloud.bigtable.data.v2.internal.api.InstanceName;
import com.google.cloud.bigtable.data.v2.internal.api.UnaryResponseFuture;
import com.google.cloud.bigtable.data.v2.internal.api.VRpcException;
import com.google.cloud.bigtable.data.v2.internal.channels.ChannelPool;
import com.google.cloud.bigtable.data.v2.internal.channels.SingleChannelPool;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.middleware.OpExecutor;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcCallContext;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult.State;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeClock;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeSessionListener;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeSessionService;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeVRpcListener;
import com.google.cloud.bigtable.data.v2.internal.session.fake.PeerInfoInterceptor;
import com.google.cloud.bigtable.data.v2.internal.session.fake.SessionHandler;
import com.google.common.base.Stopwatch;
import com.google.common.base.Strings;
import com.google.common.base.Suppliers;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import com.google.protobuf.util.Durations;
import com.google.rpc.Code;
import io.grpc.CallOptions;
import io.grpc.Deadline;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.Status;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@Timeout(30)
@ExtendWith(MockitoExtension.class)
public class SessionImplTest {
  private ScheduledExecutorService executor;
  private BigtableTimer timer;

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private Metrics metrics;

  private Server server;
  private FakeSessionService fakeService;
  private ChannelPool channelPool;
  private SessionFactory sessionFactory;
  private final VRpcTracer tracer = NoopMetrics.NoopVrpcTracer.INSTANCE;
  private SessionPoolInfo poolInfo;

  @BeforeEach
  void setUp() throws IOException {
    executor = Executors.newScheduledThreadPool(4);
    timer = new HashedWheelTimer("session-impl-test");
    fakeService = new FakeSessionService(executor);
    server = FakeServiceBuilder.create(fakeService).intercept(new PeerInfoInterceptor()).start();

    ClientInfo clientInfo =
        ClientInfo.builder()
            .setAppProfileId("default")
            .setInstanceName(InstanceName.parse("projects/fake-project/instances/fake-instance"))
            .build();

    channelPool =
        new SingleChannelPool(
            Suppliers.ofInstance(
                Grpc.newChannelBuilderForAddress(
                        "localhost", server.getPort(), InsecureChannelCredentials.create())
                    .build()));
    channelPool.start();

    // TODO: extract this out to a SimpleSessionPoolImpl that simply wraps a single Session
    poolInfo = SessionPoolInfo.create(clientInfo, FakeDescriptor.FAKE_SESSION, "fake-pool");
    sessionFactory =
        new SessionFactory(
            channelPool, FakeDescriptor.FAKE_SESSION.getMethodDescriptor(), CallOptions.DEFAULT);
  }

  @AfterEach
  void tearDown() {
    channelPool.close();
    server.shutdownNow();
    timer.stop();
    executor.shutdownNow();
  }

  @Test
  void sessionSendAndCloseTest() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    FakeSessionListener sessionListener = new FakeSessionListener();
    OpenSessionRequest openSessionRequest =
        OpenSessionRequest.newBuilder()
            .setPayload(OpenFakeSessionRequest.getDefaultInstance().toByteString())
            .build();
    session.start(openSessionRequest, new Metadata(), sessionListener);
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);

    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
        session.newCall(FakeDescriptor.SCRIPTED);
    UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        f);

    assertThat(f.get()).isEqualTo(SessionFakeScriptedResponse.getDefaultInstance());
    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("test closed session")
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isOk();
  }

  @Test
  void sessionCloseBeforeInit() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    FakeSessionListener sessionListener = new FakeSessionListener();
    OpenSessionRequest openSessionRequest =
        OpenSessionRequest.newBuilder()
            .setPayload(OpenFakeSessionRequest.getDefaultInstance().toByteString())
            .build();
    session.start(openSessionRequest, new Metadata(), sessionListener);
    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isOk();
  }

  @Test
  void sessionGoAwayTest() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    Duration goAwayDelay = Duration.ofMillis(500);
    FakeSessionListener sessionListener = new FakeSessionListener();
    session.start(
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .setGoAwayDelay(Durations.fromMillis(goAwayDelay.toMillis()))
                    .putVrpcActions(0, ActionList.getDefaultInstance())
                    .putVrpcActions(1, ActionList.getDefaultInstance())
                    .putVrpcActions(2, ActionList.getDefaultInstance())
                    .build()
                    .toByteString())
            .build(),
        new Metadata(),
        sessionListener);
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);

    Stopwatch stopwatch = Stopwatch.createStarted();
    int numOkBeforeError = 0;
    int numOkAfterError = 0;
    int numUncommittedErrors = 0;
    int otherErrors = 0;
    boolean encounteredError = false;

    while (stopwatch.elapsed(TimeUnit.MILLISECONDS) < goAwayDelay.toMillis() + 200) {
      VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
          session.newCall(FakeDescriptor.SCRIPTED);
      UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
      rpc.start(
          SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
          VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
          f);
      try {
        f.get();
        if (!encounteredError) {
          numOkBeforeError++;
        } else {
          numOkAfterError++;
        }
      } catch (ExecutionException e) {
        encounteredError = true;
        if (e.getCause() instanceof VRpcException) {
          VRpcException vrpcException = (VRpcException) e.getCause();
          if (vrpcException.getResult().getState() == State.UNCOMMITED) {
            numUncommittedErrors++;
          } else {
            otherErrors++;
          }
        } else {
          otherErrors++;
        }
      }
    }

    assertWithMessage("Ensure that some vRpcs succeeded prior to the goaway")
        .that(numOkBeforeError)
        .isGreaterThan(0);
    assertWithMessage("Ensure that no vRpcs succeeded after the first error")
        .that(numOkAfterError)
        .isEqualTo(0);
    assertWithMessage("Ensure that we received uncommitted errors after goaway")
        .that(numUncommittedErrors)
        .isGreaterThan(0);
    assertWithMessage("Ensure that we received no other types of errors")
        .that(otherErrors)
        .isEqualTo(0);

    assertThat(sessionListener.popUntil(GoAwayResponse.class)).isInstanceOf(GoAwayResponse.class);

    // Make sure we can't send vrpc after receiving goaway
    UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
        session.newCall(FakeDescriptor.SCRIPTED);
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(1).build(),
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        f);

    assertThrows(ExecutionException.class, f::get);

    assertThat(sessionListener.popUntil(Status.class)).isOk();
  }

  @Test
  void streamErrorDuringRpcTest() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    FakeSessionListener sessionListener = new FakeSessionListener();
    Status.Code actualCode = Status.Code.INTERNAL;
    com.google.rpc.Status actualSessionStatusProto =
        com.google.rpc.Status.newBuilder()
            .setCode(actualCode.value())
            .setMessage("fake internal error")
            .build();

    session.start(
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .setStreamError(
                        StreamError.newBuilder()
                            .setDelay(Durations.fromMillis(200))
                            .setStatus(actualSessionStatusProto))
                    .putVrpcActions(
                        0,
                        ActionList.newBuilder()
                            .addActions(
                                Action.newBuilder()
                                    .setResponse(VirtualRpcResponse.getDefaultInstance())
                                    .setDelay(
                                        com.google.protobuf.Duration.newBuilder()
                                            .setNanos(300000000))
                                    .build())
                            .build())
                    .build()
                    .toByteString())
            .build(),
        new Metadata(),
        sessionListener);

    sessionListener.popUntil(OpenSessionResponse.class);

    UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
        session.newCall(FakeDescriptor.SCRIPTED);
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        f);

    VRpcException error = (VRpcException) assertThrows(ExecutionException.class, f::get).getCause();
    assertThat(error)
        .hasMessageThat()
        .isEqualTo(
            "UNAVAILABLE: vRPC failed due to transport error\n"
                + "Transport error: INTERNAL: fake internal error. PeerInfo:"
                + " application_frontend_subzone: \"ll\" transport_type:"
                + " TRANSPORT_TYPE_SESSION_DIRECT_ACCESS application_frontend_region: \"local\"");
    assertThat(error.getResult()).state().isEqualTo(State.TRANSPORT_FAILURE);
    // TODO: fix server Latency definition - need to split node latency from transport latency
    assertThat(error.getResult()).backendLatency().isEqualTo(Duration.ZERO);

    Status status = sessionListener.popUntil(Status.class);
    assertThat(status).code().isEqualTo(actualCode);
    assertThat(status)
        .description()
        .isEqualTo(
            actualSessionStatusProto.getMessage()
                + ". PeerInfo: application_frontend_subzone: \"ll\" transport_type:"
                + " TRANSPORT_TYPE_SESSION_DIRECT_ACCESS application_frontend_region: \"local\"");
  }

  @Test
  void rpcErrorDuringRpcTest() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    com.google.rpc.Status expectedRpcStatus =
        com.google.rpc.Status.newBuilder()
            .setCode(Code.DEADLINE_EXCEEDED_VALUE)
            .setMessage("fake deadline exceeded")
            .build();

    ErrorResponse errorResponse =
        ErrorResponse.newBuilder()
            .setRpcId(1)
            .setStatus(expectedRpcStatus)
            .setClusterInfo(ClusterInformation.getDefaultInstance())
            .build();

    ActionList errorActionList =
        ActionList.newBuilder()
            .addActions(Action.newBuilder().setErrorResponse(errorResponse).build())
            .build();
    FakeSessionListener sessionListener = new FakeSessionListener();
    session.start(
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .putVrpcActions(0, errorActionList)
                    .putVrpcActions(1, ActionList.getDefaultInstance())
                    .build()
                    .toByteString())
            .build(),
        new Metadata(),
        sessionListener);

    sessionListener.popUntil(OpenSessionResponse.class);

    UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
        session.newCall(FakeDescriptor.SCRIPTED);
    // error response
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        f);

    VRpcException error = (VRpcException) assertThrows(ExecutionException.class, f::get).getCause();
    assertThat(error).hasMessageThat().isEqualTo("DEADLINE_EXCEEDED: fake deadline exceeded");
    assertThat(error.getResult()).state().isEqualTo(State.SERVER_RESULT);
    // TODO: fix server Latency definition - need to split node latency from transport latency
    assertThat(error.getResult()).backendLatency().isEqualTo(Duration.ZERO);

    // Sending another vRPC after a failed vRPC is ok
    f = new UnaryResponseFuture<>();
    rpc = session.newCall(FakeDescriptor.SCRIPTED);
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(1).build(),
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        f);

    // shouldn't throw an error
    assertThat(f.get()).isEqualTo(SessionFakeScriptedResponse.getDefaultInstance());

    session.close(CloseSessionRequest.getDefaultInstance());

    assertThat(sessionListener.popUntil(Status.class)).isOk();
  }

  @Test
  void localErrorTest() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    FakeSessionListener sessionListener = new FakeSessionListener();
    session.start(
        OpenSessionRequest.newBuilder()
            .setPayload(OpenFakeSessionRequest.getDefaultInstance().toByteString())
            .build(),
        new Metadata(),
        sessionListener);

    sessionListener.popUntil(OpenSessionResponse.class);

    RuntimeException expectedError = new RuntimeException("my fake onMessageError");
    FakeVRpcListener<SessionFakeScriptedResponse> rpcListener =
        new FakeVRpcListener<SessionFakeScriptedResponse>() {
          @Override
          public void onMessage(SessionFakeScriptedResponse msg) {
            throw expectedError;
          }
        };

    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
        session.newCall(FakeDescriptor.SCRIPTED);
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        rpcListener);

    VRpcResult result = (VRpcResult) rpcListener.popNext();

    // TODO: Need a different State to represent local processing failure
    assertThat(result).state().isEqualTo(State.USER_FAILURE);
    // The status is INTERNAL with a desc explaining the failure was due to local handling
    assertThat(result).status().code().isEqualTo(Status.CANCELLED.getCode());
    assertThat(result)
        .status()
        .description()
        .isEqualTo("Cancelling RPC due to exception thrown by user callback");
    assertThat(result).status().cause().isSameInstanceAs(expectedError);
  }

  @Test
  void testHeartbeat() throws Exception {
    FakeClock clock = new FakeClock(Instant.now());

    Instant time = clock.instant();

    SessionImpl session =
        new SessionImpl(metrics, clock, poolInfo, 0, sessionFactory.createNew(), timer);

    int keepAliveDurationMs = 150;

    FakeSessionListener sessionListener = new FakeSessionListener();
    OpenSessionRequest openSessionRequest =
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .setSessionParams(
                        SessionParametersResponse.newBuilder()
                            .setKeepAlive(Durations.fromMillis(keepAliveDurationMs))
                            .build())
                    .putVrpcActions(
                        0,
                        ActionList.newBuilder()
                            .addActions(
                                Action.newBuilder()
                                    .setDelay(Durations.fromMillis(500))
                                    .setResponse(VirtualRpcResponse.getDefaultInstance())
                                    .build())
                            .build())
                    .build()
                    .toByteString())
            .build();
    session.start(openSessionRequest, new Metadata(), sessionListener);
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);

    assertThat(session.getNextHeartbeat()).isEqualTo(time.plus(SessionImpl.FUTURE_TIME));

    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
        session.newCall(FakeDescriptor.SCRIPTED);
    UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        f);

    // startRpc() is now async; poll until sessionSyncContext processes it.
    Instant expectedHeartbeat = time.plus(Duration.ofMillis(keepAliveDurationMs));
    Stopwatch sw = Stopwatch.createStarted();
    while (!session.getNextHeartbeat().equals(expectedHeartbeat)
        && sw.elapsed(TimeUnit.SECONDS) < 5) {
      Thread.sleep(10);
    }
    assertThat(session.getNextHeartbeat()).isEqualTo(expectedHeartbeat);

    assertThat(f.get()).isEqualTo(SessionFakeScriptedResponse.getDefaultInstance());

    assertThat(session.getNextHeartbeat()).isEqualTo(time.plus(SessionImpl.FUTURE_TIME));

    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("test closed session")
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isOk();
  }

  @Test
  void testSoftmaxStreamingPrefetchBufferSize() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    // Before the server advertises anything, the session reports the client-side default.
    assertThat(session.getSoftmaxStreamingPrefetchBufferSize()).isEqualTo(1024 * 1024);

    int serverSoftmax = 4096;
    FakeSessionListener sessionListener = new FakeSessionListener();
    OpenSessionRequest openSessionRequest =
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .setSessionParams(
                        SessionParametersResponse.newBuilder()
                            .setKeepAlive(Durations.fromMillis(150))
                            .setSoftmaxStreamingPrefetchBufferSize(serverSoftmax)
                            .build())
                    .build()
                    .toByteString())
            .build();
    session.start(openSessionRequest, new Metadata(), sessionListener);
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);

    // Session params are applied asynchronously on the session's sync context; poll until visible.
    Stopwatch sw = Stopwatch.createStarted();
    while (session.getSoftmaxStreamingPrefetchBufferSize() != serverSoftmax
        && sw.elapsed(TimeUnit.SECONDS) < 5) {
      Thread.sleep(10);
    }
    assertThat(session.getSoftmaxStreamingPrefetchBufferSize()).isEqualTo(serverSoftmax);

    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("test closed session")
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isOk();
  }

  // region streaming vRPC / byte-budget prefetch

  @Test
  void streamingReadDeliversAllMessagesInOrder() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    int softmax = 1 << 20;
    FakeSessionListener sessionListener = new FakeSessionListener();
    session.start(
        streamingOpen(
            softmax,
            ActionList.newBuilder()
                .addActions(streamAction("m0", true))
                .addActions(streamAction("m1", true))
                .addActions(streamAction("m2", false))
                .build()),
        new Metadata(),
        sessionListener);
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);
    awaitSoftmax(session, softmax);

    OpExecutor opExecutor = newOpExecutor();
    FakeVRpcListener<SessionFakeScriptedResponse> listener = new FakeVRpcListener<>();
    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
        session.newCall(FakeDescriptor.SCRIPTED_STREAMING);
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer, opExecutor, true),
        listener);

    // The first response is delivered implicitly (no requestNext needed).
    assertThat(listener.popUntil(SessionFakeScriptedResponse.class).getMessage()).isEqualTo("m0");

    // Demand gating: nothing further is delivered until requestNext, even though the client has
    // prefetched the remaining messages into its buffer.
    Thread.sleep(50);
    assertThat(listener.getOnMessageCount()).isEqualTo(1);

    opExecutor.execute(rpc::requestNext);
    assertThat(listener.popUntil(SessionFakeScriptedResponse.class).getMessage()).isEqualTo("m1");

    opExecutor.execute(rpc::requestNext);
    assertThat(listener.popUntil(SessionFakeScriptedResponse.class).getMessage()).isEqualTo("m2");

    // The terminal response completes the stream without another requestNext.
    VRpcResult result = listener.popUntil(VRpcResult.class);
    assertThat(result).state().isEqualTo(State.SERVER_RESULT);
    assertThat(result).status().code().isEqualTo(Status.Code.OK);

    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isOk();
  }

  @Test
  void streamingPrefetchIsBoundedByByteBudget() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    // Each payload is ~200 bytes, so a 300-byte budget admits only a couple of buffered messages
    // before prefetch must stop — well short of the 20 scripted responses.
    String body = Strings.repeat("x", 200);
    int softmax = 300;
    int total = 20;
    ActionList.Builder actions = ActionList.newBuilder();
    for (int i = 0; i < total; i++) {
      actions.addActions(streamAction(body + i, i < total - 1));
    }

    FakeSessionListener sessionListener = new FakeSessionListener();
    session.start(streamingOpen(softmax, actions.build()), new Metadata(), sessionListener);
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);
    awaitSoftmax(session, softmax);

    OpExecutor opExecutor = newOpExecutor();
    FakeVRpcListener<SessionFakeScriptedResponse> listener = new FakeVRpcListener<>();
    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
        session.newCall(FakeDescriptor.SCRIPTED_STREAMING);
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer, opExecutor, true),
        listener);

    // First message auto-delivered; the client then prefetches until the byte budget is hit and
    // stops issuing continues, even though 19 more messages are available.
    listener.popUntil(SessionFakeScriptedResponse.class);
    Thread.sleep(100);
    int plateau = continueCount();
    Thread.sleep(100);
    assertWithMessage("prefetch must stop at the byte budget, not drain the whole stream")
        .that(continueCount())
        .isEqualTo(plateau);
    assertWithMessage("some prefetch should have happened").that(plateau).isGreaterThan(0);
    assertWithMessage("prefetch must be bounded well below the full stream")
        .that(plateau)
        .isLessThan(total - 1);

    // Draining frees budget so prefetch resumes; the whole stream is delivered and closes OK.
    int delivered = 1;
    Object next;
    do {
      opExecutor.execute(rpc::requestNext);
      next = listener.popNext(Duration.ofSeconds(2));
      assertThat(next).isNotNull();
      if (next instanceof SessionFakeScriptedResponse) {
        delivered++;
      }
    } while (!(next instanceof VRpcResult));

    assertThat(delivered).isEqualTo(total);
    assertThat((VRpcResult) next).status().code().isEqualTo(Status.Code.OK);

    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isOk();
  }

  @Test
  void streamingDecodeErrorClosesStreamWithTransportError() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    // {0x08} is a truncated varint field, so FakeSessionOpResponse.parseFrom throws.
    Action badPayload =
        Action.newBuilder()
            .setResponse(
                VirtualRpcResponse.newBuilder()
                    .setRpcId(SessionHandler.AUTOMATIC_RPC_ID)
                    .setHasMore(false)
                    .setPayload(ByteString.copyFrom(new byte[] {0x08})))
            .build();

    int softmax = 1 << 20;
    FakeSessionListener sessionListener = new FakeSessionListener();
    session.start(
        streamingOpen(
            softmax,
            ActionList.newBuilder()
                .addActions(streamAction("m0", true))
                .addActions(badPayload)
                .build()),
        new Metadata(),
        sessionListener);
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);
    awaitSoftmax(session, softmax);

    OpExecutor opExecutor = newOpExecutor();
    FakeVRpcListener<SessionFakeScriptedResponse> listener = new FakeVRpcListener<>();
    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
        session.newCall(FakeDescriptor.SCRIPTED_STREAMING);
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer, opExecutor, true),
        listener);

    // m0 decodes fine and is delivered; the prefetched bad payload fails to decode and closes the
    // stream with a local transport error.
    VRpcResult result = listener.popUntil(VRpcResult.class);
    assertThat(result).state().isEqualTo(State.TRANSPORT_FAILURE);
    assertThat(result).status().code().isEqualTo(Status.Code.INTERNAL);
    assertThat(result).status().description().isEqualTo("Failed to decode VRpc payload");

    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isOk();
  }

  @Test
  void streamingUserCallbackThrowClosesStreamWithUserError() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    RuntimeException boom = new RuntimeException("boom in onMessage");
    FakeVRpcListener<SessionFakeScriptedResponse> listener =
        new FakeVRpcListener<SessionFakeScriptedResponse>() {
          @Override
          public void onMessage(SessionFakeScriptedResponse msg) {
            super.onMessage(msg);
            if (msg.getMessage().equals("m1")) {
              throw boom;
            }
          }
        };

    int softmax = 1 << 20;
    FakeSessionListener sessionListener = new FakeSessionListener();
    session.start(
        streamingOpen(
            softmax,
            ActionList.newBuilder()
                .addActions(streamAction("m0", true))
                .addActions(streamAction("m1", false))
                .build()),
        new Metadata(),
        sessionListener);
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);
    awaitSoftmax(session, softmax);

    OpExecutor opExecutor = newOpExecutor();
    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
        session.newCall(FakeDescriptor.SCRIPTED_STREAMING);
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer, opExecutor, true),
        listener);

    // m0 delivers cleanly; requesting m1 makes the user callback throw, which cancels the stream.
    assertThat(listener.popUntil(SessionFakeScriptedResponse.class).getMessage()).isEqualTo("m0");
    opExecutor.execute(rpc::requestNext);

    VRpcResult result = listener.popUntil(VRpcResult.class);
    assertThat(result).state().isEqualTo(State.USER_FAILURE);
    assertThat(result).status().code().isEqualTo(Status.Code.CANCELLED);
    assertThat(result).status().cause().isSameInstanceAs(boom);
    assertThat(listener.getOnMessageCount()).isEqualTo(2);

    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isOk();
  }

  // Cancelling a streaming vRPC that has gone idle (prefetch buffer full, no continue in flight,
  // but
  // the server still has more responses) must complete promptly. Without wiring the
  // CancelVirtualRpcRequest, the server would never send another frame, so the cancel could never
  // take effect and the vRPC would hang.
  @Test
  void streamingCancelUnwedgesIdleStream() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    // ~200-byte payloads with a 300-byte budget: the client delivers the first message, prefetches
    // a message or two, then plateaus with the stream idle and the server still holding 17+ more.
    String body = Strings.repeat("x", 200);
    int softmax = 300;
    int total = 20;
    ActionList.Builder actions = ActionList.newBuilder();
    for (int i = 0; i < total; i++) {
      actions.addActions(streamAction(body + i, i < total - 1));
    }

    FakeSessionListener sessionListener = new FakeSessionListener();
    session.start(streamingOpen(softmax, actions.build()), new Metadata(), sessionListener);
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);
    awaitSoftmax(session, softmax);

    OpExecutor opExecutor = newOpExecutor();
    FakeVRpcListener<SessionFakeScriptedResponse> listener = new FakeVRpcListener<>();
    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
        session.newCall(FakeDescriptor.SCRIPTED_STREAMING);
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer, opExecutor, true),
        listener);

    // Wait for prefetch to plateau: the stream is now idle (no continue in flight) with the server
    // still holding more responses.
    listener.popUntil(SessionFakeScriptedResponse.class);
    Thread.sleep(100);
    int plateau = continueCount();
    Thread.sleep(100);
    assertThat(continueCount()).isEqualTo(plateau);
    assertThat(plateau).isLessThan(total - 1);

    // Cancel the idle stream, then re-arm demand -- both on the op executor (FIFO), matching how
    // VOperationImpl drives cancel/requestNext in production. cancel() discards the prefetch buffer
    // and turns the machine off, so the re-arm delivers nothing from the buffer and issues no
    // further continue; the stream completes promptly with CANCELLED at the one message already
    // delivered. Without the discard the re-arm would refill the buffer and pull again.
    int continuesAtCancel = continueCount();
    opExecutor.execute(() -> rpc.cancel("cancel idle stream", null));
    opExecutor.execute(rpc::requestNext);

    VRpcResult result = listener.popUntil(VRpcResult.class);
    assertThat(result).state().isEqualTo(State.UNCOMMITED);
    assertThat(result).status().code().isEqualTo(Status.Code.CANCELLED);
    assertThat(result).status().description().isEqualTo("cancel idle stream");
    assertThat(listener.getOnMessageCount()).isEqualTo(1);
    assertThat(continueCount()).isEqualTo(continuesAtCancel);

    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isOk();
  }

  // The prefetch budget is read live from the session on every prefetch decision, so a softmax the
  // server raises mid-session takes effect on the next drain — it is not snapshotted when the vRPC
  // is created. A snapshot of the tiny opening budget would keep prefetch bounded forever.
  @Test
  void streamingPrefetchPicksUpDynamicSoftmaxUpdate() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    String body = Strings.repeat("x", 200);
    int smallSoftmax = 300;
    int largeSoftmax = 1 << 20;
    int total = 20;
    ActionList.Builder actions = ActionList.newBuilder();
    for (int i = 0; i < total; i++) {
      actions.addActions(streamAction(body + i, i < total - 1));
    }

    // Open with a tiny budget, but have the server push a large budget 100ms into the session.
    OpenSessionRequest open =
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .setSessionParams(
                        SessionParametersResponse.newBuilder()
                            .setKeepAlive(Durations.fromSeconds(30))
                            .setSoftmaxStreamingPrefetchBufferSize(smallSoftmax)
                            .build())
                    .setUpdatedSessionParams(
                        SessionParametersResponse.newBuilder()
                            .setKeepAlive(Durations.fromSeconds(30))
                            .setSoftmaxStreamingPrefetchBufferSize(largeSoftmax)
                            .build())
                    .setUpdatedSessionParamsDelay(Durations.fromMillis(100))
                    .putVrpcActions(0, actions.build())
                    .build()
                    .toByteString())
            .build();

    FakeSessionListener sessionListener = new FakeSessionListener();
    session.start(open, new Metadata(), sessionListener);
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);
    awaitSoftmax(session, smallSoftmax);

    OpExecutor opExecutor = newOpExecutor();
    FakeVRpcListener<SessionFakeScriptedResponse> listener = new FakeVRpcListener<>();
    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
        session.newCall(FakeDescriptor.SCRIPTED_STREAMING);
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer, opExecutor, true),
        listener);

    // Under the tiny budget the client delivers m0 and prefetches only a couple ahead, then
    // plateaus well short of the full stream.
    listener.popUntil(SessionFakeScriptedResponse.class);
    Thread.sleep(100);
    int plateau = continueCount();
    assertThat(plateau).isLessThan(total - 1);

    // Wait for the server's mid-session budget bump to be applied to the session.
    awaitSoftmax(session, largeSoftmax);

    // Draining one message re-checks the budget on the op executor. Because the vRPC reads the
    // softmax live, the now-large budget lets prefetch resume and pull the rest of the stream in;
    // a snapshot of the tiny budget would stay bounded and never reach total-1 continues.
    opExecutor.execute(rpc::requestNext);
    Stopwatch sw = Stopwatch.createStarted();
    while (continueCount() < total - 1 && sw.elapsed(TimeUnit.SECONDS) < 5) {
      Thread.sleep(5);
    }
    assertThat(continueCount()).isEqualTo(total - 1);

    // Drain the rest; the whole stream is delivered and the vRPC completes OK.
    Object next;
    do {
      opExecutor.execute(rpc::requestNext);
      next = listener.popNext(Duration.ofSeconds(2));
      assertThat(next).isNotNull();
    } while (!(next instanceof VRpcResult));
    assertThat(listener.getOnMessageCount()).isEqualTo(total);
    assertThat((VRpcResult) next).status().code().isEqualTo(Status.Code.OK);

    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isOk();
  }

  @Test
  void invalidSessionParamsUpdateIsDiscarded() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    int validSoftmax = 4096;
    // Open with valid params, then have the server push an invalid update (softmax == 0) shortly
    // after. The invalid update must be discarded so the session keeps the last-known-good budget
    // instead of wedging streaming prefetch (maybeContinue would never pull under a 0 budget).
    OpenSessionRequest open =
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .setSessionParams(
                        SessionParametersResponse.newBuilder()
                            .setKeepAlive(Durations.fromSeconds(30))
                            .setSoftmaxStreamingPrefetchBufferSize(validSoftmax)
                            .build())
                    .setUpdatedSessionParams(
                        SessionParametersResponse.newBuilder()
                            .setKeepAlive(Durations.fromSeconds(30))
                            .setSoftmaxStreamingPrefetchBufferSize(0)
                            .build())
                    .setUpdatedSessionParamsDelay(Durations.fromMillis(50))
                    .build()
                    .toByteString())
            .build();

    FakeSessionListener sessionListener = new FakeSessionListener();
    session.start(open, new Metadata(), sessionListener);
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);
    awaitSoftmax(session, validSoftmax);

    // Give the invalid update time to arrive and be processed, then confirm it was rejected: the
    // session still reports the last-known-good budget rather than the malformed 0.
    Thread.sleep(200);
    assertThat(session.getSoftmaxStreamingPrefetchBufferSize()).isEqualTo(validSoftmax);

    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isOk();
  }

  private OpenSessionRequest streamingOpen(int softmax, ActionList actions) {
    return OpenSessionRequest.newBuilder()
        .setPayload(
            OpenFakeSessionRequest.newBuilder()
                .setSessionParams(
                    SessionParametersResponse.newBuilder()
                        .setKeepAlive(Durations.fromSeconds(30))
                        .setSoftmaxStreamingPrefetchBufferSize(softmax)
                        .build())
                .putVrpcActions(0, actions)
                .build()
                .toByteString())
        .build();
  }

  private static Action streamAction(String message, boolean hasMore) {
    return Action.newBuilder()
        .setResponse(
            VirtualRpcResponse.newBuilder()
                .setRpcId(SessionHandler.AUTOMATIC_RPC_ID)
                .setHasMore(hasMore)
                .setPayload(
                    FakeSessionOpResponse.newBuilder()
                        .setScripted(SessionFakeScriptedResponse.newBuilder().setMessage(message))
                        .build()
                        .toByteString()))
        .build();
  }

  private static OpExecutor newOpExecutor() {
    return new OpExecutor(
        MoreExecutors.directExecutor(),
        t -> {
          throw new AssertionError(t);
        });
  }

  // Blocks until the session has applied the server-advertised softmax, so a vRPC created after
  // this snapshots the intended prefetch budget.
  private void awaitSoftmax(SessionImpl session, int softmax) throws InterruptedException {
    Stopwatch sw = Stopwatch.createStarted();
    while (session.getSoftmaxStreamingPrefetchBufferSize() != softmax
        && sw.elapsed(TimeUnit.SECONDS) < 5) {
      Thread.sleep(5);
    }
    assertThat(session.getSoftmaxStreamingPrefetchBufferSize()).isEqualTo(softmax);
  }

  private int continueCount() {
    int n = 0;
    for (SessionRequest r : fakeService.getSessionRequests()) {
      if (r.getPayloadCase() == SessionRequest.PayloadCase.CONTINUE_VIRTUAL_RPC) {
        n++;
      }
    }
    return n;
  }

  // endregion

  @Test
  void testCancel() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    int responseDelayMs = 200;
    // Configure the fake service to delay the response, giving us time to cancel it
    ActionList actions =
        ActionList.newBuilder()
            .addActions(
                Action.newBuilder()
                    .setDelay(Durations.fromMillis(responseDelayMs))
                    .setResponse(VirtualRpcResponse.getDefaultInstance()))
            .build();

    FakeSessionListener sessionListener = new FakeSessionListener();
    session.start(
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .putVrpcActions(0, actions)
                    .build()
                    .toByteString())
            .build(),
        new Metadata(),
        sessionListener);

    // Wait for the session to be ready
    sessionListener.popUntil(OpenSessionResponse.class);

    // Start the RPC
    FakeVRpcListener<SessionFakeScriptedResponse> rpcListener = new FakeVRpcListener<>();
    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
        session.newCall(FakeDescriptor.SCRIPTED);
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        rpcListener);

    // Cancel it immediately
    rpc.cancel("test cancel", null);

    // Verify that the rpc was closed with a CANCELLED status
    VRpcResult result = rpcListener.popUntil(VRpcResult.class);
    assertThat(result).state().isEqualTo(State.UNCOMMITED);
    assertThat(result).status().code().isEqualTo(Status.Code.CANCELLED);
    assertThat(result).status().description().isEqualTo("test cancel");

    // Verify that the response is ignored
    Thread.sleep(responseDelayMs + 10);
    assertThat(rpcListener.getOnMessageCount()).isEqualTo(0);

    session.close(CloseSessionRequest.getDefaultInstance());
    sessionListener.popUntil(Status.class);
  }

  // Regression test: a READY session with no in-flight vRPC must not have the heartbeat tick
  // armed on the wheel. Without this, every idle session burns periodic wheel wake-ups, and a
  // server heartbeat resetting nextHeartbeat to a near-future deadline can force-close a healthy
  // idle session if subsequent heartbeats are briefly delayed.
  @Test
  void testHeartbeatNotScheduledWithoutVRpc() throws Exception {
    CountingBigtableTimer counting = new CountingBigtableTimer(timer);
    SessionImpl session =
        new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), counting);

    FakeSessionListener sessionListener = new FakeSessionListener();
    session.start(
        OpenSessionRequest.newBuilder()
            .setPayload(OpenFakeSessionRequest.getDefaultInstance().toByteString())
            .build(),
        new Metadata(),
        sessionListener);
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);

    // The open-handshake deadline is armed while STARTING and cancelled once READY (before onReady,
    // so it's already settled here). Reset the counters to scope the assertion below to the
    // heartbeat lifecycle only.
    counting.scheduleCount.set(0);
    counting.cancelCount.set(0);

    // After session is READY with no vRPC, no Timeout should ever have been scheduled. Wait a
    // bit so that any background tick (none expected) would have shown up.
    Thread.sleep(50);
    assertWithMessage("no heartbeat timer should be armed before any vRPC starts")
        .that(counting.scheduleCount.get())
        .isEqualTo(0);

    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("test closed session")
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isOk();
  }

  // Verifies the lifecycle: timer is armed exactly when a vRPC starts and cancelled when it
  // completes. Paired with testHeartbeatNotScheduledWithoutVRpc, this locks in "scheduled iff
  // active vRPC".
  @Test
  void testHeartbeatScheduledOnlyDuringVRpc() throws Exception {
    CountingBigtableTimer counting = new CountingBigtableTimer(timer);
    SessionImpl session =
        new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), counting);

    FakeSessionListener sessionListener = new FakeSessionListener();
    OpenSessionRequest openSessionRequest =
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .putVrpcActions(
                        0,
                        ActionList.newBuilder()
                            .addActions(
                                Action.newBuilder()
                                    .setResponse(VirtualRpcResponse.getDefaultInstance())
                                    .build())
                            .build())
                    .build()
                    .toByteString())
            .build();
    session.start(openSessionRequest, new Metadata(), sessionListener);
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);

    // The open-handshake deadline is armed while STARTING and cancelled once READY. Reset the
    // counters so the assertions below track only the heartbeat lifecycle.
    counting.scheduleCount.set(0);
    counting.cancelCount.set(0);

    assertThat(counting.scheduleCount.get()).isEqualTo(0);

    VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
        session.newCall(FakeDescriptor.SCRIPTED);
    UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
    rpc.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        f);
    assertThat(f.get()).isEqualTo(SessionFakeScriptedResponse.getDefaultInstance());

    int schedulesAfterRpc = counting.scheduleCount.get();
    int cancelsAfterRpc = counting.cancelCount.get();
    assertWithMessage("startRpc must arm at least one heartbeat tick")
        .that(schedulesAfterRpc)
        .isAtLeast(1);
    assertWithMessage("vRPC completion must cancel the heartbeat tick")
        .that(cancelsAfterRpc)
        .isAtLeast(1);

    // After completion no further schedules should happen — wait past one HEARTBEAT_CHECK_INTERVAL
    // to give a stray tick a chance to re-arm itself if the cancel were ineffective.
    Thread.sleep(SessionImpl.HEARTBEAT_CHECK_INTERVAL.toMillis() + 50);
    assertWithMessage("no further heartbeat schedules after vRPC completes")
        .that(counting.scheduleCount.get())
        .isEqualTo(schedulesAfterRpc);

    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("test closed session")
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isOk();
  }

  // region uncaught-exception abort behaviors

  @Test
  void abortFiresWhenListenerOnReadyThrows() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    CountDownLatch onCloseLatch = new CountDownLatch(1);
    AtomicReference<Status> capturedStatus = new AtomicReference<>();

    Session.Listener throwingListener =
        new Session.Listener() {
          @Override
          public void onReady(OpenSessionResponse msg) {
            throw new RuntimeException("simulated onReady failure");
          }

          @Override
          public void onGoAway(GoAwayResponse msg) {}

          @Override
          public void onClose(Session.SessionState prevState, Status status, Metadata trailers) {
            capturedStatus.set(status);
            onCloseLatch.countDown();
          }
        };

    session.start(
        OpenSessionRequest.newBuilder()
            .setPayload(OpenFakeSessionRequest.getDefaultInstance().toByteString())
            .build(),
        new Metadata(),
        throwingListener);

    // The abort path must drive the session to CLOSED and notify the listener via onClose, even
    // though the original onReady threw.
    assertWithMessage("listener.onClose must be invoked after onReady throws")
        .that(onCloseLatch.await(5, TimeUnit.SECONDS))
        .isTrue();
    assertThat(session.getState()).isEqualTo(Session.SessionState.CLOSED);
    assertThat(capturedStatus.get().getCode()).isEqualTo(Status.Code.INTERNAL);
  }

  @Test
  void abortDoesNotHangWhenListenerOnCloseThrows() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    CountDownLatch onReadyLatch = new CountDownLatch(1);
    CountDownLatch onCloseLatch = new CountDownLatch(1);

    Session.Listener throwingListener =
        new Session.Listener() {
          @Override
          public void onReady(OpenSessionResponse msg) {
            onReadyLatch.countDown();
          }

          @Override
          public void onGoAway(GoAwayResponse msg) {}

          @Override
          public void onClose(Session.SessionState prevState, Status status, Metadata trailers) {
            onCloseLatch.countDown();
            throw new RuntimeException("simulated onClose failure");
          }
        };

    session.start(
        OpenSessionRequest.newBuilder()
            .setPayload(OpenFakeSessionRequest.getDefaultInstance().toByteString())
            .build(),
        new Metadata(),
        throwingListener);

    assertThat(onReadyLatch.await(5, TimeUnit.SECONDS)).isTrue();

    // Close normally. The listener's onClose throws — the local guard inside notifyTerminalClose
    // must swallow it so the SyncContext drain doesn't recurse infinitely or hang.
    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("test")
            .build());

    assertWithMessage("listener.onClose should be invoked exactly once during normal close")
        .that(onCloseLatch.await(5, TimeUnit.SECONDS))
        .isTrue();

    // The session should reach CLOSED state cleanly within the test timeout.
    Stopwatch sw = Stopwatch.createStarted();
    while (session.getState() != Session.SessionState.CLOSED && sw.elapsed().getSeconds() < 5) {
      Thread.sleep(10);
    }
    assertThat(session.getState()).isEqualTo(Session.SessionState.CLOSED);
  }

  @Test
  void abortDoesNotInfiniteLoopWhenRecoveryListenerAlsoThrows() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), timer);

    CountDownLatch onCloseInvoked = new CountDownLatch(1);

    Session.Listener doublyThrowingListener =
        new Session.Listener() {
          @Override
          public void onReady(OpenSessionResponse msg) {
            throw new RuntimeException("simulated onReady failure");
          }

          @Override
          public void onGoAway(GoAwayResponse msg) {}

          @Override
          public void onClose(Session.SessionState prevState, Status status, Metadata trailers) {
            onCloseInvoked.countDown();
            throw new RuntimeException("simulated onClose failure during abort");
          }
        };

    session.start(
        OpenSessionRequest.newBuilder()
            .setPayload(OpenFakeSessionRequest.getDefaultInstance().toByteString())
            .build(),
        new Metadata(),
        doublyThrowingListener);

    // onReady throws → abort fires → abort calls onClose, which also throws → Guard 4 swallows
    // and isAborting prevents the handler from re-driving abort. The session must reach CLOSED
    // without hanging (the @Timeout(30) on the class is the safety net for infinite loops).
    assertThat(onCloseInvoked.await(5, TimeUnit.SECONDS)).isTrue();
    Stopwatch sw = Stopwatch.createStarted();
    while (session.getState() != Session.SessionState.CLOSED && sw.elapsed().getSeconds() < 5) {
      Thread.sleep(10);
    }
    assertThat(session.getState()).isEqualTo(Session.SessionState.CLOSED);
  }

  // Regression test: a session that connects but never completes the open handshake must not stay
  // wedged in STARTING forever. Without the open-handshake deadline the session would never fire a
  // terminal callback, so the pool's reserved session-creation-budget slot would leak. Arming
  // OPEN_SESSION_TIMEOUT force-closes such a session, routing STARTING -> WAIT_SERVER_CLOSE and
  // driving the listener to a terminal Status (which releases the budget in the pool).
  @Test
  void sessionOpenTimeoutForcesClose() throws Exception {
    // Capture the scheduled open-timeout tick so we can fire it deterministically instead of
    // waiting the real OPEN_SESSION_TIMEOUT.
    CapturingBigtableTimer capturing = new CapturingBigtableTimer(timer);
    SessionImpl session =
        new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew(), capturing);

    FakeSessionListener sessionListener = new FakeSessionListener();
    session.start(
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder().setHangBeforeOpen(true).build().toByteString())
            .build(),
        new Metadata(),
        sessionListener);

    // start() runs on the sessionSyncContext; wait until it has armed the open-timeout tick and the
    // session is STARTING. The server never responds, so it stays STARTING.
    Stopwatch sw = Stopwatch.createStarted();
    while ((capturing.tasks.isEmpty() || session.getState() != Session.SessionState.STARTING)
        && sw.elapsed(TimeUnit.SECONDS) < 5) {
      Thread.sleep(10);
    }
    assertThat(session.getState()).isEqualTo(Session.SessionState.STARTING);
    assertWithMessage("open-timeout tick should have been armed while STARTING")
        .that(capturing.tasks)
        .isNotEmpty();

    // Fire the open-timeout tick on its executor (the sessionSyncContext), simulating the deadline
    // elapsing while still STARTING.
    capturing.executors.get(0).execute(capturing.tasks.get(0));

    // The session must force-close and drive the listener to a terminal Status.
    assertWithMessage("terminal status should be delivered after open timeout")
        .that(sessionListener.popUntil(Status.class))
        .isNotNull();
    sw.reset().start();
    while (session.getState() != Session.SessionState.WAIT_SERVER_CLOSE
        && session.getState() != Session.SessionState.CLOSED
        && sw.elapsed(TimeUnit.SECONDS) < 5) {
      Thread.sleep(10);
    }
    assertThat(session.getState())
        .isAnyOf(Session.SessionState.WAIT_SERVER_CLOSE, Session.SessionState.CLOSED);
  }

  // endregion

  // Captures newTimeout tasks/executors so a scheduled tick can be fired deterministically instead
  // of waiting out the real delay.
  private static final class CapturingBigtableTimer implements BigtableTimer {
    private final BigtableTimer delegate;
    final List<Runnable> tasks = Collections.synchronizedList(new ArrayList<>());
    final List<Executor> executors = Collections.synchronizedList(new ArrayList<>());

    CapturingBigtableTimer(BigtableTimer delegate) {
      this.delegate = delegate;
    }

    @Override
    public Timeout newTimeout(Runnable task, Executor executor, long delay, TimeUnit unit) {
      tasks.add(task);
      executors.add(executor);
      return new Timeout() {
        @Override
        public boolean cancel() {
          return true;
        }

        @Override
        public boolean isCancelled() {
          return false;
        }
      };
    }

    @Override
    public Registration onStop(Runnable hook) {
      return delegate.onStop(hook);
    }

    @Override
    public void stop() {
      delegate.stop();
    }
  }

  // Wraps a real BigtableTimer and counts newTimeout / cancel calls. Used to assert that the
  // heartbeat tick is only armed while a vRPC is in flight.
  private static final class CountingBigtableTimer implements BigtableTimer {
    private final BigtableTimer delegate;
    final AtomicInteger scheduleCount = new AtomicInteger();
    final AtomicInteger cancelCount = new AtomicInteger();

    CountingBigtableTimer(BigtableTimer delegate) {
      this.delegate = delegate;
    }

    @Override
    public Timeout newTimeout(Runnable task, Executor executor, long delay, TimeUnit unit) {
      scheduleCount.incrementAndGet();
      Timeout inner = delegate.newTimeout(task, executor, delay, unit);
      return new Timeout() {
        @Override
        public boolean cancel() {
          cancelCount.incrementAndGet();
          return inner.cancel();
        }

        @Override
        public boolean isCancelled() {
          return inner.isCancelled();
        }
      };
    }

    @Override
    public Registration onStop(Runnable hook) {
      return delegate.onStop(hook);
    }

    @Override
    public void stop() {
      delegate.stop();
    }
  }
}
