/*
 * Copyright 2020 Google LLC
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

import com.google.api.core.ApiFunction;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.bigtable.v2.BigtableGrpc.BigtableImplBase;
import com.google.bigtable.v2.PingAndWarmRequest;
import com.google.bigtable.v2.PingAndWarmResponse;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.ThrowsException;

@RunWith(JUnit4.class)
public class BigtableChannelPrimerTest {
  private static final String TOKEN_VALUE = "fake-token";

  FakeService fakeService;
  MetadataInterceptor metadataInterceptor;
  BigtableChannelPrimer primer;
  ManagedChannel channel;
  private LogHandler logHandler;
  private Server server;

  @Before
  public void setup() throws IOException {
    fakeService = new FakeService();
    metadataInterceptor = new MetadataInterceptor();

    server = FakeServiceBuilder.create(fakeService).intercept(metadataInterceptor).start();

    primer =
        BigtableChannelPrimer.create(
            OAuth2Credentials.create(new AccessToken(TOKEN_VALUE, null)),
            "fake-project",
            "fake-instance",
            "fake-app-profile");

    channel =
        ManagedChannelBuilder.forAddress("localhost", server.getPort()).usePlaintext().build();
    logHandler = new LogHandler();
    Logger.getLogger(BigtableChannelPrimer.class.toString()).addHandler(logHandler);
  }

  @After
  public void teardown() {
    Logger.getLogger(BigtableChannelPrimer.class.toString()).removeHandler(logHandler);
    channel.shutdown();
    server.shutdown();
  }

  @Test
  public void testCredentials() {
    primer.primeChannel(channel);

    for (Metadata metadata : metadataInterceptor.metadataList) {
      assertThat(metadata.get(Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER)))
          .isEqualTo("Bearer " + TOKEN_VALUE);
    }
    channel.shutdown();
  }

  @Test
  public void testRequests() {
    final Queue<PingAndWarmRequest> requests = new ConcurrentLinkedQueue<>();

    fakeService.pingAndWarmCallback =
        new ApiFunction<PingAndWarmRequest, PingAndWarmResponse>() {
          @Override
          public PingAndWarmResponse apply(PingAndWarmRequest req) {
            requests.add(req);
            return PingAndWarmResponse.getDefaultInstance();
          }
        };
    primer.primeChannel(channel);

    assertThat(requests)
        .containsExactly(
            PingAndWarmRequest.newBuilder()
                .setName("projects/fake-project/instances/fake-instance")
                .setAppProfileId("fake-app-profile")
                .build());
  }

  @Test
  public void testErrorsAreLogged() {
    fakeService.pingAndWarmCallback =
        new ApiFunction<PingAndWarmRequest, PingAndWarmResponse>() {
          @Override
          public PingAndWarmResponse apply(PingAndWarmRequest pingAndWarmRequest) {
            throw new StatusRuntimeException(Status.FAILED_PRECONDITION);
          }
        };
    primer.primeChannel(channel);

    assertThat(logHandler.logs).hasSize(1);
    for (LogRecord log : logHandler.logs) {
      assertThat(log.getMessage()).contains("FAILED_PRECONDITION");
    }
  }

  @Test
  public void testChannelErrorsAreLogged() {
    ManagedChannel channel =
        Mockito.mock(
            ManagedChannel.class, new ThrowsException(new UnsupportedOperationException()));
    primer.primeChannel(channel);

    assertThat(logHandler.logs).hasSize(1);
    for (LogRecord log : logHandler.logs) {
      assertThat(log.getMessage()).contains("UnsupportedOperationException");
    }
  }

  private static class MetadataInterceptor implements ServerInterceptor {
    ConcurrentLinkedQueue<Metadata> metadataList = new ConcurrentLinkedQueue<>();

    @Override
    public <ReqT, RespT> Listener<ReqT> interceptCall(
        ServerCall<ReqT, RespT> serverCall,
        Metadata metadata,
        ServerCallHandler<ReqT, RespT> serverCallHandler) {
      metadataList.add(metadata);

      return serverCallHandler.startCall(serverCall, metadata);
    }
  }

  static class FakeService extends BigtableImplBase {
    private ApiFunction<PingAndWarmRequest, PingAndWarmResponse> pingAndWarmCallback =
        new ApiFunction<PingAndWarmRequest, PingAndWarmResponse>() {
          @Override
          public PingAndWarmResponse apply(PingAndWarmRequest pingAndWarmRequest) {
            return PingAndWarmResponse.getDefaultInstance();
          }
        };

    @Override
    public void pingAndWarm(
        PingAndWarmRequest request, StreamObserver<PingAndWarmResponse> responseObserver) {
      try {
        responseObserver.onNext(pingAndWarmCallback.apply(request));
        responseObserver.onCompleted();
      } catch (RuntimeException e) {
        responseObserver.onError(e);
      }
    }
  }

  private static class LogHandler extends Handler {
    private ConcurrentLinkedQueue<LogRecord> logs = new ConcurrentLinkedQueue<>();

    @Override
    public void publish(LogRecord record) {
      logs.add(record);
    }

    @Override
    public void flush() {}

    @Override
    public void close() throws SecurityException {}
  }
}
