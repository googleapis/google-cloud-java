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
import com.google.common.base.Stopwatch;
import com.google.common.base.Suppliers;
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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SessionImplTest {
  private ScheduledExecutorService executor;
  private BigtableTimer timer;

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private Metrics metrics;

  private Server server;
  private ChannelPool channelPool;
  private SessionFactory sessionFactory;
  private final VRpcTracer tracer = NoopMetrics.NoopVrpcTracer.INSTANCE;
  private SessionPoolInfo poolInfo;

  @BeforeEach
  void setUp() throws IOException {
    executor = Executors.newScheduledThreadPool(4);
    timer =
        new NettyWheelTimer(
            "session-impl-test", com.google.common.util.concurrent.MoreExecutors.directExecutor());
    server =
        FakeServiceBuilder.create(new FakeSessionService(executor))
            .intercept(new PeerInfoInterceptor())
            .start();

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

    java.util.concurrent.CountDownLatch onCloseLatch = new java.util.concurrent.CountDownLatch(1);
    java.util.concurrent.atomic.AtomicReference<Status> capturedStatus =
        new java.util.concurrent.atomic.AtomicReference<>();

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

    java.util.concurrent.CountDownLatch onReadyLatch = new java.util.concurrent.CountDownLatch(1);
    java.util.concurrent.CountDownLatch onCloseLatch = new java.util.concurrent.CountDownLatch(1);

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

    java.util.concurrent.CountDownLatch onCloseInvoked = new java.util.concurrent.CountDownLatch(1);

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

  // endregion

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
    public Timeout newTimeout(Runnable task, long delay, TimeUnit unit) {
      scheduleCount.incrementAndGet();
      Timeout inner = delegate.newTimeout(task, delay, unit);
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
    public void stop() {
      delegate.stop();
    }
  }
}
