/*
 * Copyright 2017 Google LLC
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

import static com.google.api.gax.grpc.testing.FakeServiceGrpc.METHOD_CLIENT_STREAMING_RECOGNIZE;
import static com.google.api.gax.grpc.testing.FakeServiceGrpc.METHOD_STREAMING_RECOGNIZE;
import static com.google.api.gax.grpc.testing.FakeServiceGrpc.METHOD_STREAMING_RECOGNIZE_ERROR;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.grpc.testing.FakeServiceImpl;
import com.google.api.gax.grpc.testing.InProcessServer;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.EndpointContext;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.auth.Credentials;
import com.google.type.Color;
import com.google.type.Money;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GrpcDirectStreamingCallableTest {
  private InProcessServer<FakeServiceImpl> inprocessServer;
  private ManagedChannel channel;
  private FakeServiceImpl serviceImpl;
  private ClientContext clientContext;

  @BeforeEach
  void setUp() throws InstantiationException, IllegalAccessException, IOException {
    String serverName = "fakeservice";
    serviceImpl = new FakeServiceImpl();
    inprocessServer = new InProcessServer<>(serviceImpl, serverName);
    inprocessServer.start();
    channel = InProcessChannelBuilder.forName(serverName).directExecutor().usePlaintext().build();
    EndpointContext endpointContext = Mockito.mock(EndpointContext.class);
    Mockito.doNothing()
        .when(endpointContext)
        .validateUniverseDomain(Mockito.any(Credentials.class), Mockito.any(GrpcStatusCode.class));
    clientContext =
        ClientContext.newBuilder()
            .setTransportChannel(GrpcTransportChannel.create(channel))
            .setDefaultCallContext(
                GrpcCallContext.of(channel, CallOptions.DEFAULT)
                    .withEndpointContext(endpointContext))
            .build();
  }

  @AfterEach
  void tearDown() {
    channel.shutdown();
    inprocessServer.stop();
  }

  @Test
  void testBidiStreaming() throws Exception {
    BidiStreamingCallable<Color, Money> streamingCallable =
        GrpcCallableFactory.createBidiStreamingCallable(
            GrpcCallSettings.create(METHOD_STREAMING_RECOGNIZE), null, clientContext);

    CountDownLatch latch = new CountDownLatch(1);
    GrpcDirectServerStreamingCallableTest.MoneyObserver moneyObserver =
        new GrpcDirectServerStreamingCallableTest.MoneyObserver(true, latch);

    Color request = Color.newBuilder().setRed(0.5f).build();
    ClientStream<Color> stream = streamingCallable.splitCall(moneyObserver);
    stream.send(request);
    stream.closeSend();

    latch.await(20, TimeUnit.SECONDS);
    assertThat(moneyObserver.error).isNull();
    Money expected = Money.newBuilder().setCurrencyCode("USD").setUnits(127).build();
    assertThat(moneyObserver.response).isEqualTo(expected);
    assertThat(moneyObserver.completed).isTrue();
  }

  @Test
  void testBidiStreamingServerError() throws Exception {
    BidiStreamingCallable<Color, Money> streamingCallable =
        GrpcCallableFactory.createBidiStreamingCallable(
            GrpcCallSettings.create(METHOD_STREAMING_RECOGNIZE_ERROR), null, clientContext);

    CountDownLatch latch = new CountDownLatch(1);
    GrpcDirectServerStreamingCallableTest.MoneyObserver moneyObserver =
        new GrpcDirectServerStreamingCallableTest.MoneyObserver(true, latch);

    Color request = Color.newBuilder().setRed(0.5f).build();
    ClientStream<Color> stream = streamingCallable.splitCall(moneyObserver);
    stream.send(request);

    latch.await(20, TimeUnit.SECONDS);
    assertThat(moneyObserver.error).isNotNull();
    assertThat(moneyObserver.error).isInstanceOf(ApiException.class);
    assertThat(moneyObserver.error.getCause()).isInstanceOf(StatusRuntimeException.class);
    assertThat(((StatusRuntimeException) moneyObserver.error.getCause()).getStatus())
        .isEqualTo(Status.INVALID_ARGUMENT);
    assertThat(moneyObserver.response).isNull();
  }

  @Test
  void testBidiStreamingClientError() throws Exception {
    BidiStreamingCallable<Color, Money> streamingCallable =
        GrpcCallableFactory.createBidiStreamingCallable(
            GrpcCallSettings.create(METHOD_STREAMING_RECOGNIZE_ERROR), null, clientContext);

    CountDownLatch latch = new CountDownLatch(1);
    GrpcDirectServerStreamingCallableTest.MoneyObserver moneyObserver =
        new GrpcDirectServerStreamingCallableTest.MoneyObserver(true, latch);

    ClientStream<Color> stream = streamingCallable.splitCall(moneyObserver);
    Throwable clientError = new StatusRuntimeException(Status.CANCELLED);
    stream.closeSendWithError(clientError);

    latch.await(20, TimeUnit.SECONDS);
    assertThat(moneyObserver.error).isNotNull();
    assertThat(moneyObserver.error).isInstanceOf(ApiException.class);
    assertThat(((ApiException) moneyObserver.error).getStatusCode().getCode())
        .isEqualTo(Code.CANCELLED);
    assertThat(moneyObserver.response).isNull();

    // As of gRPC 1.8, when the client closes, the server gRPC issues
    //   io.grpc.StatusRuntimeException: CANCELLED: cancelled before receiving half close
    // to the server application, and our error is not propagated.
    // We don't check the error received by the server; we can't round-trip it.
  }

  @Test
  void testClientStreaming() throws Exception {
    ClientStreamingCallable<Color, Money> streamingCallable =
        GrpcCallableFactory.createClientStreamingCallable(
            GrpcCallSettings.create(METHOD_CLIENT_STREAMING_RECOGNIZE), null, clientContext);

    CountDownLatch latch = new CountDownLatch(1);
    MoneyObserver moneyObserver = new MoneyObserver(latch);

    Color request = Color.newBuilder().setRed(0.5f).build();
    ApiStreamObserver<Color> requestObserver = streamingCallable.clientStreamingCall(moneyObserver);
    requestObserver.onNext(request);
    requestObserver.onCompleted();

    latch.await(20, TimeUnit.SECONDS);
    assertThat(moneyObserver.error).isNull();
    Money expected = Money.newBuilder().setCurrencyCode("USD").setUnits(127).build();
    assertThat(moneyObserver.response).isEqualTo(expected);
    assertThat(moneyObserver.completed).isTrue();
  }

  private static class MoneyObserver implements ApiStreamObserver<Money> {
    volatile Money response;
    volatile Throwable error;
    volatile boolean completed;
    CountDownLatch latch;

    MoneyObserver(CountDownLatch latch) {
      this.latch = latch;
    }

    @Override
    public void onNext(Money value) {
      response = value;
      latch.countDown();
    }

    @Override
    public void onError(Throwable t) {
      error = t;
      latch.countDown();
    }

    @Override
    public void onCompleted() {
      completed = true;
    }
  }
  ;
}
