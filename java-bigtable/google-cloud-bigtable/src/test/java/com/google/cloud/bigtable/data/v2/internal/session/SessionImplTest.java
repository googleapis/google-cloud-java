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
    executor.shutdownNow();
  }

  @Test
  void sessionSendAndCloseTest() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew());

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
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew());

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
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew());

    Duration goAwayDelay = Duration.ofMillis(100);
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

    // Send vRPCs until after a goaway time
    Stopwatch stopwatch = Stopwatch.createStarted();
    int numUncommittedErrors = 0;
    int numOk = 0;
    while (stopwatch.elapsed(TimeUnit.MILLISECONDS) < goAwayDelay.toMillis()) {
      VRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> rpc =
          session.newCall(FakeDescriptor.SCRIPTED);
      UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
      rpc.start(
          SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
          VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
          f);
      try {
        f.get();
        numOk++;
      } catch (VRpcException e) {
        if (e.getResult().getState() == State.UNCOMMITED) {
          numUncommittedErrors++;
        }
      }
    }

    assertWithMessage("Ensure that some vRpcs succeeded prior to the goaway")
        .that(numOk)
        .isGreaterThan(0);
    assertWithMessage("Ensure that only the last vRpc could be rejected with an uncommited error")
        .that(numUncommittedErrors)
        .isAtMost(1);

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
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew());

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
                + "Transport error: INTERNAL: fake internal error. PeerInfo: application_frontend_subzone: \"ll\" transport_type: TRANSPORT_TYPE_SESSION_DIRECT_ACCESS application_frontend_region: \"local\"");
    assertThat(error.getResult()).state().isEqualTo(State.TRANSPORT_FAILURE);
    // TODO: fix server Latency definition - need to split node latency from transport latency
    assertThat(error.getResult()).backendLatency().isEqualTo(Duration.ZERO);

    Status status = sessionListener.popUntil(Status.class);
    assertThat(status).code().isEqualTo(actualCode);
    assertThat(status)
        .description()
        .isEqualTo(
            actualSessionStatusProto.getMessage()
                + ". PeerInfo: application_frontend_subzone: \"ll\" transport_type: TRANSPORT_TYPE_SESSION_DIRECT_ACCESS application_frontend_region: \"local\"");
  }

  @Test
  void rpcErrorDuringRpcTest() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew());

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
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew());

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

    SessionImpl session = new SessionImpl(metrics, clock, poolInfo, 0, sessionFactory.createNew());

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
                    .putVrpcActions(0, ActionList.getDefaultInstance())
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

    assertThat(session.getNextHeartbeat())
        .isEqualTo(time.plus(Duration.ofMillis(keepAliveDurationMs)));

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
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew());

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
}
