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
package com.google.cloud.bigtable.data.v2.internal.api;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.ClientConfiguration;
import com.google.bigtable.v2.GetClientConfigurationRequest;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.OpenAuthorizedViewRequest;
import com.google.bigtable.v2.OpenMaterializedViewRequest;
import com.google.bigtable.v2.OpenSessionResponse;
import com.google.bigtable.v2.OpenTableRequest;
import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.bigtable.v2.SessionMutateRowRequest;
import com.google.bigtable.v2.SessionMutateRowResponse;
import com.google.bigtable.v2.SessionReadRowRequest;
import com.google.bigtable.v2.SessionReadRowResponse;
import com.google.bigtable.v2.SessionRequest;
import com.google.bigtable.v2.SessionResponse;
import com.google.bigtable.v2.VirtualRpcResponse;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.internal.session.fake.PeerInfoInterceptor;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import com.google.protobuf.ByteString;
import com.google.protobuf.util.Durations;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientTest {
  private ClientConfiguration defaultConfig;

  private ScheduledExecutorService executor;
  private FakeBigtableService service;
  private Server server;
  private Client client;
  private InstanceName instanceName =
      InstanceName.parse("projects/fake-project/instances/fake-instance");

  @BeforeEach
  void setUp() throws IOException {
    ClientConfiguration.Builder builder = ClientConfigurationManager.loadDefault().toBuilder();
    builder.setSessionConfiguration(
        SessionClientConfiguration.newBuilder()
            .setSessionLoad(1)
            .setSessionPoolConfiguration(
                SessionClientConfiguration.SessionPoolConfiguration.newBuilder()
                    .setNewSessionCreationBudget(10)
                    .setNewSessionCreationPenalty(Durations.fromMinutes(1))
                    .setHeadroom(0.5f)
                    .setMinSessionCount(5)
                    .setMaxSessionCount(20)
                    .setNewSessionQueueLength(10)
                    .setConsecutiveSessionFailureThreshold(10)));
    defaultConfig = builder.build();

    executor = Executors.newScheduledThreadPool(4);
    service = new FakeBigtableService();
    server = FakeServiceBuilder.create(service).intercept(new PeerInfoInterceptor()).start();

    ClientSettings settings =
        ClientSettings.builder()
            .setChannelProvider(
                new ChannelProviders.EmulatorChannelProvider("localhost", server.getPort()))
            .setInstanceName(instanceName)
            .setAppProfileId("default")
            .build();

    client = Client.create(settings);
  }

  @AfterEach
  void tearDown() {
    client.close();
    server.shutdownNow();
    executor.shutdownNow();
  }

  @Test
  public void testRequestFails() {
    TableAsync table =
        client.openTableAsync("fake-table", OpenTableRequest.Permission.PERMISSION_READ);
    CompletableFuture<SessionReadRowResponse> future =
        table.readRow(
            SessionReadRowRequest.newBuilder().setKey(ByteString.copyFromUtf8("key")).build(),
            Deadline.after(1, TimeUnit.MINUTES));

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception).hasCauseThat().isInstanceOf(VRpcException.class);
    VRpcException vRpcException = (VRpcException) exception.getCause();
    assertThat(vRpcException).hasMessageThat().contains("Session failed with consecutive failures");

    table.close();
  }

  @Test
  public void testDeadlineRespected() {
    TableAsync table =
        client.openTableAsync("fake-table", OpenTableRequest.Permission.PERMISSION_READ);
    CompletableFuture<SessionReadRowResponse> future =
        table.readRow(
            SessionReadRowRequest.newBuilder().setKey(ByteString.copyFromUtf8("key")).build(),
            Deadline.after(10, TimeUnit.MILLISECONDS));

    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception).hasCauseThat().isInstanceOf(VRpcException.class);
    VRpcException vRpcException = (VRpcException) exception.getCause();
    assertThat(vRpcException).hasMessageThat().contains("DEADLINE_EXCEEDED");

    table.close();
  }

  @Test
  public void testGrpcContextDeadlineRespected() {
    TableAsync table =
        client.openTableAsync("fake-table", OpenTableRequest.Permission.PERMISSION_READ);

    Context.current()
        .withDeadline(Deadline.after(10, TimeUnit.MILLISECONDS), executor)
        .run(
            () -> {
              CompletableFuture<SessionReadRowResponse> future =
                  table.readRow(
                      SessionReadRowRequest.newBuilder()
                          .setKey(ByteString.copyFromUtf8("key"))
                          .build(),
                      Deadline.after(1, TimeUnit.MINUTES));
              ExecutionException exception = assertThrows(ExecutionException.class, future::get);
              assertThat(exception).hasCauseThat().isInstanceOf(VRpcException.class);
              VRpcException vRpcException = (VRpcException) exception.getCause();
              assertThat(vRpcException).hasMessageThat().contains("DEADLINE_EXCEEDED");
            });

    table.close();
  }

  @Test
  public void testOpenAuthorizedViewRequestSent() throws Exception {
    AuthorizedViewAsync view =
        client.openAuthorizedViewAsync(
            "fake-table", "fake-view", OpenAuthorizedViewRequest.Permission.PERMISSION_READ);

    // wait for session to start
    Thread.sleep(500);

    OpenAuthorizedViewRequest expectedPayload =
        OpenAuthorizedViewRequest.newBuilder()
            .setAuthorizedViewName(
                AuthorizedViewName.builder()
                    .setProjectId(instanceName.getProjectId())
                    .setInstanceId(instanceName.getInstanceId())
                    .setTableId("fake-table")
                    .setAuthorizedViewId("fake-view")
                    .build()
                    .toString())
            .setAppProfileId("default")
            .setPermission(OpenAuthorizedViewRequest.Permission.PERMISSION_READ)
            .build();

    assertThat(service.openSessionRequests.get(0).getOpenSession().getPayload())
        .isEqualTo(expectedPayload.toByteString());

    SessionReadRowRequest read =
        SessionReadRowRequest.newBuilder().setKey(ByteString.copyFromUtf8("key")).build();

    CompletableFuture<SessionReadRowResponse> future1 =
        view.readRow(read, Deadline.after(1, TimeUnit.MINUTES));

    future1.get();

    ByteString payload = service.vrpcRequests.get(0).getVirtualRpc().getPayload();
    assertThat(payload).isEqualTo(VRpcDescriptor.READ_ROW_AUTH_VIEW.encode(read));

    SessionMutateRowRequest mutate =
        SessionMutateRowRequest.newBuilder()
            .setKey(ByteString.copyFromUtf8("key"))
            .addMutations(
                Mutation.newBuilder().setDeleteFromRow(Mutation.DeleteFromRow.getDefaultInstance()))
            .build();
    CompletableFuture<SessionMutateRowResponse> future2 =
        view.mutateRow(mutate, Deadline.after(1, TimeUnit.MINUTES));

    future2.get();

    payload = service.vrpcRequests.get(1).getVirtualRpc().getPayload();
    assertThat(payload).isEqualTo(VRpcDescriptor.MUTATE_ROW_AUTH_VIEW.encode(mutate));

    view.close();
  }

  @Test
  public void testMaterializedViewRequestSent() throws Exception {
    MaterializedViewAsync view =
        client.openMaterializedViewAsync(
            "fake-view", OpenMaterializedViewRequest.Permission.PERMISSION_READ);

    // Wait for session to start
    Thread.sleep(500);

    OpenMaterializedViewRequest expected =
        OpenMaterializedViewRequest.newBuilder()
            .setMaterializedViewName(
                MaterializedViewName.builder()
                    .setProjectId(instanceName.getProjectId())
                    .setInstanceId(instanceName.getInstanceId())
                    .setMaterializedViewId("fake-view")
                    .build()
                    .toString())
            .setPermission(OpenMaterializedViewRequest.Permission.PERMISSION_READ)
            .setAppProfileId("default")
            .build();

    assertThat(service.openSessionRequests.get(0).getOpenSession().getPayload())
        .isEqualTo(expected.toByteString());

    SessionReadRowRequest read =
        SessionReadRowRequest.newBuilder().setKey(ByteString.copyFromUtf8("key")).build();

    CompletableFuture<SessionReadRowResponse> future =
        view.readRow(read, Deadline.after(1, TimeUnit.MINUTES));

    future.get();

    assertThat(service.vrpcRequests.get(0).getVirtualRpc().getPayload())
        .isEqualTo(VRpcDescriptor.READ_ROW_MAT_VIEW.encode(read));

    view.close();
  }

  class FakeBigtableService extends BigtableGrpc.BigtableImplBase {
    private final List<SessionRequest> openSessionRequests = new ArrayList<>();
    private final List<SessionRequest> vrpcRequests = new ArrayList<>();

    @Override
    public void getClientConfiguration(
        GetClientConfigurationRequest request,
        StreamObserver<ClientConfiguration> responseObserver) {
      responseObserver.onNext(defaultConfig);
      responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<SessionRequest> openTable(
        StreamObserver<SessionResponse> responseObserver) {
      // Make openTable take a long time and return a noop which will cause the session creation to
      // fail.
      try {
        Thread.sleep(10);
      } catch (Exception e) {
        // dont care
      }
      return super.openTable(responseObserver);
    }

    @Override
    public StreamObserver<SessionRequest> openAuthorizedView(
        StreamObserver<SessionResponse> responseObserver) {
      return new StreamObserver<SessionRequest>() {
        @Override
        public void onNext(SessionRequest sessionRequest) {
          if (sessionRequest.hasOpenSession()) {
            openSessionRequests.add(sessionRequest);
            responseObserver.onNext(
                SessionResponse.newBuilder()
                    .setOpenSession(OpenSessionResponse.getDefaultInstance())
                    .build());
          } else if (sessionRequest.hasVirtualRpc()) {
            vrpcRequests.add(sessionRequest);
            responseObserver.onNext(
                SessionResponse.newBuilder()
                    .setVirtualRpc(
                        VirtualRpcResponse.newBuilder()
                            .setRpcId(sessionRequest.getVirtualRpc().getRpcId())
                            .build())
                    .build());
          }
        }

        @Override
        public void onError(Throwable throwable) {}

        @Override
        public void onCompleted() {
          responseObserver.onCompleted();
        }
      };
    }

    @Override
    public StreamObserver<SessionRequest> openMaterializedView(
        StreamObserver<SessionResponse> responseObserver) {
      return new StreamObserver<SessionRequest>() {
        @Override
        public void onNext(SessionRequest sessionRequest) {
          if (sessionRequest.hasOpenSession()) {
            openSessionRequests.add(sessionRequest);
            responseObserver.onNext(
                SessionResponse.newBuilder()
                    .setOpenSession(OpenSessionResponse.getDefaultInstance())
                    .build());
          } else if (sessionRequest.hasVirtualRpc()) {
            vrpcRequests.add(sessionRequest);
            responseObserver.onNext(
                SessionResponse.newBuilder()
                    .setVirtualRpc(
                        VirtualRpcResponse.newBuilder()
                            .setRpcId(sessionRequest.getVirtualRpc().getRpcId())
                            .build())
                    .build());
          }
        }

        @Override
        public void onError(Throwable throwable) {}

        @Override
        public void onCompleted() {
          responseObserver.onCompleted();
        }
      };
    }
  }
}
