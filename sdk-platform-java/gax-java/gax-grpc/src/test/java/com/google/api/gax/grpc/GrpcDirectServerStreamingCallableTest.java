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

import static com.google.api.gax.grpc.testing.FakeServiceGrpc.METHOD_SERVER_STREAMING_RECOGNIZE;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.testing.FakeServiceImpl;
import com.google.api.gax.grpc.testing.InProcessServer;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.EndpointContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StateCheckingResponseObserver;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.auth.Credentials;
import com.google.common.collect.Lists;
import com.google.common.truth.Truth;
import com.google.type.Color;
import com.google.type.Money;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GrpcDirectServerStreamingCallableTest {
  private static final Color DEFAULT_REQUEST = Color.newBuilder().setRed(0.5f).build();
  private static final Color ASYNC_REQUEST = DEFAULT_REQUEST.toBuilder().setGreen(1000).build();
  private static final Color ERROR_REQUEST = Color.newBuilder().setRed(-1).build();
  private static final Money DEFAULT_RESPONSE =
      Money.newBuilder().setCurrencyCode("USD").setUnits(127).build();

  private InProcessServer<FakeServiceImpl> inprocessServer;
  private ManagedChannel channel;
  private ClientContext clientContext;
  private ServerStreamingCallSettings<Color, Money> streamingCallSettings;
  private ServerStreamingCallable<Color, Money> streamingCallable;

  @BeforeEach
  void setUp() throws InstantiationException, IllegalAccessException, IOException {
    String serverName = "fakeservice";
    FakeServiceImpl serviceImpl = new FakeServiceImpl();
    inprocessServer = new InProcessServer<>(serviceImpl, serverName);
    inprocessServer.start();

    EndpointContext endpointContext = Mockito.mock(EndpointContext.class);
    Mockito.doNothing()
        .when(endpointContext)
        .validateUniverseDomain(Mockito.any(Credentials.class), Mockito.any(GrpcStatusCode.class));

    channel = InProcessChannelBuilder.forName(serverName).directExecutor().usePlaintext().build();
    clientContext =
        ClientContext.newBuilder()
            .setTransportChannel(GrpcTransportChannel.create(channel))
            .setDefaultCallContext(
                GrpcCallContext.of(channel, CallOptions.DEFAULT)
                    .withEndpointContext(endpointContext))
            .build();
    streamingCallSettings = ServerStreamingCallSettings.<Color, Money>newBuilder().build();
    streamingCallable =
        GrpcCallableFactory.createServerStreamingCallable(
            GrpcCallSettings.create(METHOD_SERVER_STREAMING_RECOGNIZE),
            streamingCallSettings,
            clientContext);
  }

  @AfterEach
  void tearDown() {
    channel.shutdown();
    inprocessServer.stop();
  }

  @Test
  void testBadContext() {
    streamingCallable =
        GrpcCallableFactory.createServerStreamingCallable(
            GrpcCallSettings.create(METHOD_SERVER_STREAMING_RECOGNIZE),
            streamingCallSettings,
            clientContext.toBuilder()
                .setDefaultCallContext(FakeCallContext.createDefault())
                .build());

    CountDownLatch latch = new CountDownLatch(1);
    MoneyObserver observer = new MoneyObserver(true, latch);
    try {
      streamingCallable.call(DEFAULT_REQUEST, observer);
      Assertions.fail("Callable should have thrown an exception");
    } catch (IllegalArgumentException expected) {
      Truth.assertThat(expected)
          .hasMessageThat()
          .contains("context must be an instance of GrpcCallContext");
    }
  }

  @Test
  void testServerStreamingStart() {
    CountDownLatch latch = new CountDownLatch(1);
    MoneyObserver moneyObserver = new MoneyObserver(true, latch);

    streamingCallable.call(DEFAULT_REQUEST, moneyObserver);

    Truth.assertThat(moneyObserver.controller).isNotNull();
  }

  @Test
  void testServerStreaming() throws Exception {
    CountDownLatch latch = new CountDownLatch(2);
    MoneyObserver moneyObserver = new MoneyObserver(true, latch);

    streamingCallable.call(DEFAULT_REQUEST, moneyObserver);

    Truth.assertThat(latch.await(20, TimeUnit.SECONDS)).isTrue();
    Truth.assertThat(moneyObserver.error).isNull();
    Truth.assertThat(moneyObserver.response).isEqualTo(DEFAULT_RESPONSE);
  }

  @Test
  void testManualFlowControl() throws Exception {
    CountDownLatch latch = new CountDownLatch(2);
    MoneyObserver moneyObserver = new MoneyObserver(false, latch);

    streamingCallable.call(DEFAULT_REQUEST, moneyObserver);

    Truth.assertThat(latch.await(500, TimeUnit.MILLISECONDS)).isFalse();
    Truth.assertWithMessage("Received response before requesting it")
        .that(moneyObserver.response)
        .isNull();

    moneyObserver.controller.request(1);
    Truth.assertThat(latch.await(500, TimeUnit.MILLISECONDS)).isTrue();

    Truth.assertThat(moneyObserver.response).isEqualTo(DEFAULT_RESPONSE);
    Truth.assertThat(moneyObserver.completed).isTrue();
  }

  @Test
  void testCancelClientCall() throws Exception {
    CountDownLatch latch = new CountDownLatch(1);
    MoneyObserver moneyObserver = new MoneyObserver(false, latch);

    streamingCallable.call(ASYNC_REQUEST, moneyObserver);

    moneyObserver.controller.cancel();
    moneyObserver.controller.request(1);
    Truth.assertThat(latch.await(500, TimeUnit.MILLISECONDS)).isTrue();

    Truth.assertThat(moneyObserver.error).isInstanceOf(CancellationException.class);
    Truth.assertThat(moneyObserver.error).hasMessageThat().isEqualTo("User cancelled stream");
  }

  @Test
  void testOnResponseError() throws Throwable {
    CountDownLatch latch = new CountDownLatch(1);
    MoneyObserver moneyObserver = new MoneyObserver(true, latch);

    streamingCallable.call(ERROR_REQUEST, moneyObserver);
    Truth.assertThat(latch.await(500, TimeUnit.MILLISECONDS)).isTrue();

    Truth.assertThat(moneyObserver.error).isInstanceOf(ApiException.class);
    Truth.assertThat(((ApiException) moneyObserver.error).getStatusCode().getCode())
        .isEqualTo(StatusCode.Code.INVALID_ARGUMENT);
    Truth.assertThat(moneyObserver.error)
        .hasMessageThat()
        .isEqualTo("io.grpc.StatusRuntimeException: INVALID_ARGUMENT: red must be positive");
  }

  @Test
  void testObserverErrorCancelsCall() throws Throwable {
    final RuntimeException expectedCause = new RuntimeException("some error");
    final SettableApiFuture<Throwable> actualErrorF = SettableApiFuture.create();

    ResponseObserver<Money> moneyObserver =
        new StateCheckingResponseObserver<Money>() {
          @Override
          protected void onStartImpl(StreamController controller) {}

          @Override
          protected void onResponseImpl(Money response) {
            throw expectedCause;
          }

          @Override
          protected void onErrorImpl(Throwable t) {
            actualErrorF.set(t);
          }

          @Override
          protected void onCompleteImpl() {
            actualErrorF.set(null);
          }
        };

    streamingCallable.call(DEFAULT_REQUEST, moneyObserver);
    Throwable actualError = actualErrorF.get(500, TimeUnit.MILLISECONDS);

    Truth.assertThat(actualError).isInstanceOf(ApiException.class);
    Truth.assertThat(((ApiException) actualError).getStatusCode().getCode())
        .isEqualTo(StatusCode.Code.CANCELLED);

    // grpc is responsible for the immediate cancellation
    Truth.assertThat(actualError.getCause()).isInstanceOf(StatusRuntimeException.class);
    // and the client error is cause for grpc to cancel it
    Truth.assertThat(actualError.getCause().getCause()).isSameInstanceAs(expectedCause);
  }

  @Test
  void testBlockingServerStreaming() {
    Color request = Color.newBuilder().setRed(0.5f).build();
    ServerStream<Money> response = streamingCallable.call(request);
    List<Money> responseData = Lists.newArrayList(response);

    Money expected = Money.newBuilder().setCurrencyCode("USD").setUnits(127).build();
    Truth.assertThat(responseData).containsExactly(expected);
  }

  static class MoneyObserver extends StateCheckingResponseObserver<Money> {
    private final boolean autoFlowControl;
    private final CountDownLatch latch;

    volatile StreamController controller;
    volatile Money response;
    volatile Throwable error;
    volatile boolean completed;

    MoneyObserver(boolean autoFlowControl, CountDownLatch latch) {
      this.autoFlowControl = autoFlowControl;
      this.latch = latch;
    }

    @Override
    protected void onStartImpl(StreamController controller) {
      this.controller = controller;
      if (!autoFlowControl) {
        controller.disableAutoInboundFlowControl();
      }
    }

    @Override
    protected void onResponseImpl(Money value) {
      response = value;
      latch.countDown();
    }

    @Override
    protected void onErrorImpl(Throwable t) {
      error = t;
      latch.countDown();
    }

    @Override
    protected void onCompleteImpl() {
      completed = true;
      latch.countDown();
    }
  }
}
