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

package com.google.cloud.bigtable.data.v2.internal.middleware;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.ClusterInformation;
import com.google.bigtable.v2.ErrorResponse;
import com.google.bigtable.v2.OpenFakeSessionRequest;
import com.google.bigtable.v2.OpenSessionRequest;
import com.google.bigtable.v2.OpenSessionResponse;
import com.google.bigtable.v2.SessionFakeScriptedRequest;
import com.google.bigtable.v2.SessionFakeScriptedResponse;
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
import com.google.cloud.bigtable.data.v2.internal.session.FakeDescriptor;
import com.google.cloud.bigtable.data.v2.internal.session.SessionFactory;
import com.google.cloud.bigtable.data.v2.internal.session.SessionImpl;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolInfo;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeSessionListener;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeSessionService;
import com.google.cloud.bigtable.data.v2.internal.session.fake.PeerInfoInterceptor;
import com.google.common.base.Suppliers;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.util.Durations;
import com.google.rpc.Code;
import com.google.rpc.RetryInfo;
import io.grpc.CallOptions;
import io.grpc.Deadline;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.Status;
import java.io.IOException;
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
public class RetryingVRpcTest {
  private ScheduledExecutorService executor;

  private Server server;
  private ChannelPool channelPool;
  private final VRpcTracer tracer = NoopMetrics.NoopVrpcTracer.INSTANCE;

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private Metrics metrics;

  private SessionPoolInfo poolInfo;
  private SessionFactory sessionFactory;

  @BeforeEach
  void setUp() throws IOException {
    executor = Executors.newScheduledThreadPool(4);
    server =
        FakeServiceBuilder.create(new FakeSessionService(executor))
            .intercept(new PeerInfoInterceptor())
            .start();
    channelPool =
        new SingleChannelPool(
            Suppliers.ofInstance(
                Grpc.newChannelBuilderForAddress(
                        "localhost", server.getPort(), InsecureChannelCredentials.create())
                    .build()));
    channelPool.start();
    ClientInfo clientInfo =
        ClientInfo.builder()
            .setAppProfileId("default")
            .setInstanceName(InstanceName.parse("projects/fake-project/instances/fake-instance"))
            .build();

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
  void noRetryTest() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew());

    FakeSessionListener sessionListener = new FakeSessionListener();
    OpenSessionRequest openSessionRequest =
        OpenSessionRequest.newBuilder()
            .setPayload(OpenFakeSessionRequest.getDefaultInstance().toByteString())
            .build();
    session.start(openSessionRequest, new Metadata(), sessionListener);
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);

    RetryingVRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> retrying =
        new RetryingVRpc<>(() -> session.newCall(FakeDescriptor.SCRIPTED), executor);
    UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
    retrying.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpc.VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        f);

    assertThat(f.get()).isEqualTo(SessionFakeScriptedResponse.getDefaultInstance());
    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionRequest.CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("test closed session")
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isEqualTo(Status.OK);
  }

  @Test
  public void retryServerError() throws Exception {
    int requestTag = 1;
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew());

    FakeSessionListener sessionListener = new FakeSessionListener();

    // expected responses: 1 deadline exceeded error followed by a response.
    com.google.rpc.Status status =
        com.google.rpc.Status.newBuilder()
            .setCode(Code.DEADLINE_EXCEEDED_VALUE)
            .setMessage("fake deadline exceeded error")
            .build();
    ErrorResponse error =
        ErrorResponse.newBuilder()
            .setRpcId(1)
            .setStatus(status)
            .setRetryInfo(RetryInfo.newBuilder().setRetryDelay(Durations.fromMillis(10)).build())
            .setClusterInfo(ClusterInformation.getDefaultInstance())
            .build();
    OpenSessionRequest openSessionRequest =
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .putVrpcActions(
                        requestTag,
                        OpenFakeSessionRequest.ActionList.newBuilder()
                            .setRepeat(false)
                            .addActions(
                                OpenFakeSessionRequest.Action.newBuilder()
                                    .setErrorResponse(error)
                                    .build())
                            .addActions(
                                OpenFakeSessionRequest.Action.newBuilder()
                                    .setResponse(
                                        VirtualRpcResponse.newBuilder()
                                            .setRpcId(2)
                                            .setClusterInfo(ClusterInformation.getDefaultInstance())
                                            .setPayload(ByteString.EMPTY)
                                            .build()))
                            .build())
                    .build()
                    .toByteString())
            .build();
    session.start(openSessionRequest, new Metadata(), sessionListener);
    // Verify that session has started
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);

    RetryingVRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> retrying =
        new RetryingVRpc<>(() -> session.newCall(FakeDescriptor.SCRIPTED), executor);
    UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
    retrying.start(
        SessionFakeScriptedRequest.newBuilder().setTag(requestTag).build(),
        VRpc.VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        f);
    assertThat(f.get()).isEqualTo(SessionFakeScriptedResponse.getDefaultInstance());

    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionRequest.CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("test closed session")
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isEqualTo(Status.OK);
  }

  @Test
  public void retryDeadlineRespectedTest() throws Exception {
    int requestTag = 1;
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew());

    FakeSessionListener sessionListener = new FakeSessionListener();

    // Deadline is < retryDelay + responseDealy, we should not schedule retry and fail with the
    // server
    // returned error
    Duration retryDelay = Durations.fromSeconds(1);
    Duration responseDelay = Durations.fromMillis(500);
    Duration deadline = Durations.fromSeconds(1);

    String errorMessage = "fake unavailable error";
    // server responses: 1 unavailable error followed by an OK response
    com.google.rpc.Status status =
        com.google.rpc.Status.newBuilder()
            .setCode(Code.UNAVAILABLE.getNumber())
            .setMessage(errorMessage)
            .build();
    ErrorResponse error =
        ErrorResponse.newBuilder()
            .setRpcId(1)
            .setStatus(status)
            .setRetryInfo(RetryInfo.newBuilder().setRetryDelay(retryDelay).build())
            .setClusterInfo(ClusterInformation.getDefaultInstance())
            .build();
    OpenSessionRequest openSessionRequest =
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .putVrpcActions(
                        requestTag,
                        OpenFakeSessionRequest.ActionList.newBuilder()
                            .setRepeat(false)
                            .addActions(
                                OpenFakeSessionRequest.Action.newBuilder()
                                    .setErrorResponse(error)
                                    .setDelay(responseDelay)
                                    .build())
                            .addActions(
                                OpenFakeSessionRequest.Action.newBuilder()
                                    .setResponse(
                                        VirtualRpcResponse.newBuilder()
                                            .setRpcId(2)
                                            .setClusterInfo(ClusterInformation.getDefaultInstance())
                                            .setPayload(ByteString.EMPTY)
                                            .build()))
                            .build())
                    .build()
                    .toByteString())
            .build();
    session.start(openSessionRequest, new Metadata(), sessionListener);
    // Verify that session has started
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);

    RetryingVRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> retrying =
        new RetryingVRpc<>(() -> session.newCall(FakeDescriptor.SCRIPTED), executor);
    UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
    retrying.start(
        SessionFakeScriptedRequest.newBuilder().setTag(requestTag).build(),
        VRpc.VRpcCallContext.create(
            Deadline.after(Durations.toMillis(deadline), TimeUnit.MILLISECONDS), true, tracer),
        f);
    ExecutionException exception = assertThrows(ExecutionException.class, f::get);
    assertThat(exception).hasMessageThat().contains(errorMessage);

    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionRequest.CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("test closed session")
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isEqualTo(Status.OK);
  }

  @Test
  public void vRpcFailureTest() throws Exception {
    // vrpc error on the session should not close the stream
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew());

    FakeSessionListener sessionListener = new FakeSessionListener();

    // expected responses: 1 deadline exceeded error followed by a response.
    com.google.rpc.Status status =
        com.google.rpc.Status.newBuilder()
            .setCode(Code.DEADLINE_EXCEEDED_VALUE)
            .setMessage("fake deadline exceeded error")
            .build();
    ErrorResponse error =
        ErrorResponse.newBuilder()
            .setRpcId(1)
            .setStatus(status)
            .setClusterInfo(ClusterInformation.getDefaultInstance())
            .build();
    OpenSessionRequest openSessionRequest =
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .putVrpcActions(
                        0,
                        OpenFakeSessionRequest.ActionList.newBuilder()
                            .setRepeat(false)
                            .addActions(
                                OpenFakeSessionRequest.Action.newBuilder()
                                    .setErrorResponse(error)
                                    .build())
                            .build())
                    .build()
                    .toByteString())
            .build();
    session.start(openSessionRequest, new Metadata(), sessionListener);
    // Verify that session has started
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);

    RetryingVRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> retrying =
        new RetryingVRpc<>(() -> session.newCall(FakeDescriptor.SCRIPTED), executor);
    UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
    retrying.start(
        SessionFakeScriptedRequest.newBuilder().setTag(0).build(),
        VRpc.VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        f);
    VRpcException cause =
        (VRpcException) assertThrows(ExecutionException.class, () -> f.get()).getCause();
    assertThat(cause).hasMessageThat().isEqualTo("DEADLINE_EXCEEDED: fake deadline exceeded error");

    session.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionRequest.CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("test closed session")
            .build());
    assertThat(sessionListener.popUntil(Status.class)).isEqualTo(Status.OK);
  }

  @Test
  void cancelInScheduledState() throws Exception {
    SessionImpl session = new SessionImpl(metrics, poolInfo, 0, sessionFactory.createNew());

    FakeSessionListener sessionListener = new FakeSessionListener();

    // expected responses: 1 deadline exceeded error followed by a response.
    com.google.rpc.Status status =
        com.google.rpc.Status.newBuilder()
            .setCode(Code.DEADLINE_EXCEEDED_VALUE)
            .setMessage("fake deadline exceeded error")
            .build();
    ErrorResponse error =
        ErrorResponse.newBuilder()
            .setRpcId(1)
            .setStatus(status)
            .setRetryInfo(RetryInfo.newBuilder().setRetryDelay(Durations.fromSeconds(1)).build())
            .setClusterInfo(ClusterInformation.getDefaultInstance())
            .build();
    OpenSessionRequest openSessionRequest =
        OpenSessionRequest.newBuilder()
            .setPayload(
                OpenFakeSessionRequest.newBuilder()
                    .putVrpcActions(
                        1,
                        OpenFakeSessionRequest.ActionList.newBuilder()
                            .setRepeat(false)
                            .addActions(
                                OpenFakeSessionRequest.Action.newBuilder()
                                    .setErrorResponse(error)
                                    .build())
                            .build())
                    .build()
                    .toByteString())
            .build();
    session.start(openSessionRequest, new Metadata(), sessionListener);
    // Verify that session has started
    assertThat(sessionListener.popUntil(OpenSessionResponse.class))
        .isInstanceOf(OpenSessionResponse.class);

    RetryingVRpc<SessionFakeScriptedRequest, SessionFakeScriptedResponse> retrying =
        new RetryingVRpc<>(() -> session.newCall(FakeDescriptor.SCRIPTED), executor);
    UnaryResponseFuture<SessionFakeScriptedResponse> f = new UnaryResponseFuture<>();
    retrying.start(
        SessionFakeScriptedRequest.newBuilder().setTag(1).build(),
        VRpc.VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer),
        f);

    // Wait for the first attempt to fail and get scheduled for retry
    Thread.sleep(50);

    retrying.cancel("test cancel", null);

    ExecutionException executionException = assertThrows(ExecutionException.class, f::get);
    assertThat(executionException.getCause()).isInstanceOf(VRpcException.class);
    VRpcException vRpcException = (VRpcException) executionException.getCause();
    assertThat(vRpcException.getStatus().getCode()).isEqualTo(Status.Code.CANCELLED);
  }
}
