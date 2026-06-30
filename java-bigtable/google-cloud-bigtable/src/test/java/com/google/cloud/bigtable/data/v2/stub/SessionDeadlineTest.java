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
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.ClientConfiguration;
import com.google.bigtable.v2.GetClientConfigurationRequest;
import com.google.bigtable.v2.OpenSessionResponse;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.SessionRequest;
import com.google.bigtable.v2.SessionResponse;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.TableId;
import io.grpc.Context;
import io.grpc.ForwardingServerCall;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SessionDeadlineTest {

  private Server server;
  private EnhancedBigtableStubSettings defaultSettings;
  private FakeDataService fakeDataService;

  @Before
  public void setUp() throws IOException {
    fakeDataService = new FakeDataService();
    server =
        NettyServerBuilder.forPort(0)
            .addService(fakeDataService)
            .intercept(new ResponseHeaderInterceptor())
            .build()
            .start();

    defaultSettings =
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
            .setProjectId("fake-project")
            .setInstanceId("fake-instance")
            .setAppProfileId("fake-app-profile")
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build()
            .getStubSettings();
  }

  @After
  public void tearDown() throws InterruptedException {
    if (fakeDataService != null) {
      fakeDataService.shutdown();
    }
    if (server != null) {
      server.shutdownNow();
      server.awaitTermination();
    }
  }

  @Test(timeout = 1000)
  public void testShortDeadlineCancellation() throws Exception {
    EnhancedBigtableStubSettings settings =
        defaultSettings.toBuilder().setSessionsEnabled(true).build();

    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(settings)) {
      Query request = Query.create(TableId.of("fake-table")).rowKey("row-key");

      try (io.grpc.Context.CancellableContext ctx =
          io.grpc.Context.current()
              .withDeadlineAfter(
                  5,
                  TimeUnit.MILLISECONDS,
                  settings.getBackgroundExecutorProvider().getExecutor())) {

        ctx.run(
            () -> {
              ApiFuture<Row> future = stub.readRowCallable().futureCall(request);
              try {
                future.get();
                fail("Should throw exception");
              } catch (ExecutionException e) {
                assertThat(e).hasMessageThat().contains("DEADLINE_EXCEEDED");
              } catch (InterruptedException e) {
                fail("Should not throw interrupted exception");
              }
            });
      }
    }
  }

  @Test(timeout = 10000)
  public void testMissedHeartbeat() throws Exception {
    EnhancedBigtableStubSettings settings =
        defaultSettings.toBuilder().setSessionsEnabled(true).build();

    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(settings)) {
      Query request = Query.create(TableId.of("fake-table")).rowKey("row-key");

      try (Context.CancellableContext ctx =
          Context.current()
              .withDeadlineAfter(
                  1, TimeUnit.SECONDS, settings.getBackgroundExecutorProvider().getExecutor())) {
        ctx.run(
            () -> {
              ApiFuture<Row> future = stub.readRowCallable().futureCall(request);
              try {
                future.get();
                fail("Should throw exception");
              } catch (ExecutionException e) {
                assertThat(e).hasMessageThat().contains("missed heartbeat");
              } catch (InterruptedException e) {
                fail("Should not throw interrupted exception");
              }
            });
      }
    }
  }

  private static class FakeDataService extends BigtableGrpc.BigtableImplBase {
    private final ScheduledExecutorService serverExecutor = Executors.newScheduledThreadPool(4);

    public void shutdown() {
      serverExecutor.shutdownNow();
    }

    @Override
    public void getClientConfiguration(
        GetClientConfigurationRequest request,
        StreamObserver<ClientConfiguration> responseObserver) {
      responseObserver.onNext(
          ClientConfiguration.newBuilder()
              .setSessionConfiguration(
                  com.google.bigtable.v2.SessionClientConfiguration.newBuilder()
                      .setSessionLoad(1)
                      .build())
              .build());
      responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<SessionRequest> openTable(
        StreamObserver<SessionResponse> responseObserver) {
      return new StreamObserver<SessionRequest>() {
        @Override
        public void onNext(SessionRequest sessionRequest) {
          if (sessionRequest.hasOpenSession()) {
            responseObserver.onNext(
                SessionResponse.newBuilder()
                    .setOpenSession(OpenSessionResponse.getDefaultInstance())
                    .build());
          } else if (sessionRequest.hasVirtualRpc()) {
            // Server hangs
          }
        }

        @Override
        public void onError(Throwable t) {}

        @Override
        public void onCompleted() {
          responseObserver.onCompleted();
        }
      };
    }
  }

  private static class ResponseHeaderInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
        ServerCall<ReqT, RespT> serverCall,
        Metadata metadata,
        ServerCallHandler<ReqT, RespT> serverCallHandler) {
      return serverCallHandler.startCall(
          new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(serverCall) {
            @Override
            public void sendHeaders(Metadata headers) {
              Metadata.Key<String> peerInfoKey =
                  Metadata.Key.of("bigtable-peer-info", Metadata.ASCII_STRING_MARSHALLER);
              String encoded =
                  Base64.getUrlEncoder()
                      .encodeToString(
                          PeerInfo.newBuilder()
                              .setApplicationFrontendRegion("us-east1")
                              .build()
                              .toByteArray());
              headers.put(peerInfoKey, encoded);
              super.sendHeaders(headers);
            }

            @Override
            public void close(io.grpc.Status status, Metadata trailers) {
              super.close(status, trailers);
            }
          },
          metadata);
    }
  }
}
