/*
 * Copyright 2023 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.grpc;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.FakeServiceGrpc;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.StreamResumptionStrategy;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.type.Color;
import com.google.type.Money;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class GrpcDirectStreamControllerTest {
  private static final int DEFAULT_AWAIT_TERMINATION_SEC = 10;

  @Test
  @Timeout(180)
  void testRetryNoRaceCondition() throws Exception {
    Server server = ServerBuilder.forPort(1234).addService(new FakeService()).build().start();
    ManagedChannel channel =
        ManagedChannelBuilder.forAddress("localhost", 1234).usePlaintext().build();
    StreamResumptionStrategy<Color, Money> resumptionStrategy =
        new StreamResumptionStrategy<Color, Money>() {
          @Nonnull
          @Override
          public StreamResumptionStrategy<Color, Money> createNew() {
            return this;
          }

          @Nonnull
          @Override
          public Money processResponse(Money response) {
            return response;
          }

          @Nullable
          @Override
          public Color getResumeRequest(Color originalRequest) {
            return originalRequest;
          }

          @Override
          public boolean canResume() {
            return true;
          }
        };
    // Set up retry settings. Set total timeout to 1 minute to limit the total runtime of this
    // test. Set retry delay to 1 ms so the retries will be scheduled in a loop with no delays.
    ServerStreamingCallSettings<Color, Money> callSettings =
        ServerStreamingCallSettings.<Color, Money>newBuilder()
            .setResumptionStrategy(resumptionStrategy)
            .setRetryableCodes(StatusCode.Code.DEADLINE_EXCEEDED)
            .setRetrySettings(
                RetrySettings.newBuilder()
                    .setTotalTimeoutDuration(java.time.Duration.ofMinutes(1))
                    .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(1))
                    .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(1))
                    .setInitialRetryDelayDuration(java.time.Duration.ofMillis(1))
                    .setMaxRetryDelayDuration(java.time.Duration.ofMillis(1))
                    .build())
            .build();
    // Store a list of resources to manually close at the end of the test
    List<BackgroundResource> backgroundResourceList = new ArrayList<>();
    try {
      GrpcTransportChannel transportChannel = GrpcTransportChannel.create(channel);
      backgroundResourceList.add(transportChannel);

      StubSettings.Builder builder =
          new StubSettings.Builder() {
            @Override
            public StubSettings build() {
              return new StubSettings(this) {
                @Override
                public Builder toBuilder() {
                  throw new IllegalStateException();
                }
              };
            }
          };

      builder
          .setEndpoint("localhost:1234")
          .setCredentialsProvider(NoCredentialsProvider.create())
          .setTransportChannelProvider(FixedTransportChannelProvider.create(transportChannel));

      ClientContext clientContext = ClientContext.create(builder.build());
      backgroundResourceList.addAll(clientContext.getBackgroundResources());
      // GrpcCallableFactory's createServerStreamingCallable creates a retrying callable
      ServerStreamingCallable<Color, Money> callable =
          GrpcCallableFactory.createServerStreamingCallable(
              GrpcCallSettings.create(FakeServiceGrpc.METHOD_SERVER_STREAMING_RECOGNIZE),
              callSettings,
              clientContext);

      Color request = Color.newBuilder().getDefaultInstanceForType();
      for (Money money : callable.call(request, clientContext.getDefaultCallContext())) {}
    } catch (DeadlineExceededException e) {
      // Ignore this error
    } finally {
      // Shutdown all the resources
      server.shutdown();
      server.awaitTermination(DEFAULT_AWAIT_TERMINATION_SEC, TimeUnit.SECONDS);
      channel.shutdown();
      channel.awaitTermination(DEFAULT_AWAIT_TERMINATION_SEC, TimeUnit.SECONDS);
      for (BackgroundResource backgroundResource : backgroundResourceList) {
        backgroundResource.shutdown();
        backgroundResource.awaitTermination(DEFAULT_AWAIT_TERMINATION_SEC, TimeUnit.SECONDS);
      }
    }
  }

  class FakeService extends FakeServiceGrpc.FakeServiceImplBase {
    @Override
    public void serverStreamingRecognize(Color request, StreamObserver<Money> responseObserver) {
      responseObserver.onNext(Money.getDefaultInstance());
      responseObserver.onError(Status.DEADLINE_EXCEEDED.asException());
    }
  }
}
