/*
 * Copyright 2022 Google LLC
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
package com.google.api.gax.httpjson;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.httpjson.ApiMethodDescriptor.MethodType;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.EndpointContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StateCheckingResponseObserver;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.auth.Credentials;
import com.google.common.collect.Lists;
import com.google.common.truth.Truth;
import com.google.protobuf.Field;
import com.google.type.Color;
import com.google.type.Money;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HttpJsonDirectServerStreamingCallableTest {
  private static final Color DEFAULT_REQUEST = Color.newBuilder().setRed(0.5f).build();
  private static final Color ASYNC_REQUEST = DEFAULT_REQUEST.toBuilder().setGreen(1000).build();
  private static final Color ERROR_REQUEST = Color.newBuilder().setRed(-1).build();
  private static final Money DEFAULT_RESPONSE =
      Money.newBuilder().setCurrencyCode("USD").setUnits(127).build();
  private static final Money DEFAULTER_RESPONSE =
      Money.newBuilder().setCurrencyCode("UAH").setUnits(255).build();

  private ServerStreamingCallSettings<Color, Money> streamingCallSettings;
  private ServerStreamingCallable<Color, Money> streamingCallable;

  private ManagedHttpJsonChannel channel;
  private ClientContext clientContext;
  private ExecutorService executorService;
  private MockHttpService mockService;
  ApiMethodDescriptor<Color, Money> methodServerStreamingRecognize;

  @BeforeEach
  void initialize() throws IOException {
    initialize(java.time.Duration.ofSeconds(30));
  }

  void initialize(java.time.Duration timeout) throws IOException {
    this.methodServerStreamingRecognize =
        ApiMethodDescriptor.<Color, Money>newBuilder()
            .setFullMethodName("google.cloud.v1.Fake/ServerStreamingRecognize")
            .setHttpMethod("POST")
            .setRequestFormatter(
                ProtoMessageRequestFormatter.<Color>newBuilder()
                    .setPath(
                        "/fake/v1/recognize/{blue}",
                        request -> {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<Field> serializer = ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "blue", request.getBlue());
                          return fields;
                        })
                    .setQueryParamsExtractor(
                        request -> {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<Field> serializer = ProtoRestSerializer.create();
                          serializer.putQueryParam(fields, "red", request.getRed());
                          return fields;
                        })
                    .setRequestBodyExtractor(
                        request ->
                            ProtoRestSerializer.create()
                                .toBody(
                                    "*", request.toBuilder().clearBlue().clearRed().build(), false))
                    .build())
            .setResponseParser(
                ProtoMessageResponseParser.<Money>newBuilder()
                    .setDefaultInstance(Money.getDefaultInstance())
                    .build())
            .setType(MethodType.SERVER_STREAMING)
            .build();
    this.mockService =
        new MockHttpService(
            Collections.singletonList(methodServerStreamingRecognize), "google.com:443");
    executorService = Executors.newFixedThreadPool(2);
    channel =
        new ManagedHttpJsonInterceptorChannel(
            ManagedHttpJsonChannel.newBuilder()
                .setEndpoint("google.com:443")
                .setExecutor(executorService)
                .setHttpTransport(mockService)
                .build(),
            new HttpJsonHeaderInterceptor(Collections.singletonMap("header-key", "headerValue")));
    EndpointContext endpointContext = Mockito.mock(EndpointContext.class);
    Mockito.doNothing()
        .when(endpointContext)
        .validateUniverseDomain(
            Mockito.any(Credentials.class), Mockito.any(HttpJsonStatusCode.class));
    clientContext =
        ClientContext.newBuilder()
            .setTransportChannel(HttpJsonTransportChannel.create(channel))
            .setDefaultCallContext(
                HttpJsonCallContext.of(channel, HttpJsonCallOptions.DEFAULT)
                    .withTimeoutDuration(timeout)
                    .withEndpointContext(endpointContext))
            .build();

    streamingCallSettings = ServerStreamingCallSettings.<Color, Money>newBuilder().build();
    streamingCallable =
        HttpJsonCallableFactory.createServerStreamingCallable(
            HttpJsonCallSettings.create(methodServerStreamingRecognize),
            streamingCallSettings,
            clientContext);
  }

  @AfterEach
  void destroy() throws InterruptedException {
    executorService.shutdown();
    channel.shutdown();
  }

  @Test
  void testBadContext() {
    mockService.addResponse(new Money[] {DEFAULT_RESPONSE});
    // Create a local callable with a bad context
    ServerStreamingCallable<Color, Money> streamingCallable =
        HttpJsonCallableFactory.createServerStreamingCallable(
            HttpJsonCallSettings.create(this.methodServerStreamingRecognize),
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
          .contains("context must be an instance of HttpJsonCallContext");
    }
  }

  @Test
  void testServerStreamingStart() throws InterruptedException {
    mockService.addResponse(new Money[] {DEFAULT_RESPONSE});
    CountDownLatch latch = new CountDownLatch(1);
    MoneyObserver moneyObserver = new MoneyObserver(true, latch);

    streamingCallable.call(DEFAULT_REQUEST, moneyObserver);

    Truth.assertThat(moneyObserver.controller).isNotNull();
  }

  @Test
  void testServerStreaming() throws InterruptedException {
    mockService.addResponse(new Money[] {DEFAULT_RESPONSE, DEFAULTER_RESPONSE});
    CountDownLatch latch = new CountDownLatch(3);
    MoneyObserver moneyObserver = new MoneyObserver(true, latch);

    streamingCallable.call(DEFAULT_REQUEST, moneyObserver);

    Truth.assertThat(latch.await(10, TimeUnit.SECONDS)).isTrue();
    Truth.assertThat(latch.getCount()).isEqualTo(0);
    Truth.assertThat(moneyObserver.error).isNull();
    Truth.assertThat(moneyObserver.response).isEqualTo(DEFAULTER_RESPONSE);
  }

  @Test
  void testManualFlowControl() throws Exception {
    mockService.addResponse(new Money[] {DEFAULT_RESPONSE});
    CountDownLatch latch = new CountDownLatch(2);
    MoneyObserver moneyObserver = new MoneyObserver(false, latch);

    streamingCallable.call(DEFAULT_REQUEST, moneyObserver);

    Truth.assertThat(latch.await(1000, TimeUnit.MILLISECONDS)).isFalse();
    Truth.assertWithMessage("Received response before requesting it")
        .that(moneyObserver.response)
        .isNull();

    moneyObserver.controller.request(1);
    Truth.assertThat(latch.await(1000, TimeUnit.MILLISECONDS)).isTrue();

    Truth.assertThat(moneyObserver.response).isEqualTo(DEFAULT_RESPONSE);
    Truth.assertThat(moneyObserver.completed).isTrue();
  }

  @Test
  void testCancelClientCall() throws Exception {
    mockService.addResponse(new Money[] {DEFAULT_RESPONSE});
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
    mockService.addException(404, new RuntimeException("some error"));

    CountDownLatch latch = new CountDownLatch(1);
    MoneyObserver moneyObserver = new MoneyObserver(true, latch);

    streamingCallable.call(ERROR_REQUEST, moneyObserver);
    Truth.assertThat(latch.await(60, TimeUnit.SECONDS)).isTrue();

    Truth.assertThat(moneyObserver.error).isInstanceOf(ApiException.class);
    Truth.assertThat(((ApiException) moneyObserver.error).getStatusCode().getCode())
        .isEqualTo(Code.NOT_FOUND);

    Truth.assertThat(moneyObserver.error)
        .hasMessageThat()
        .contains("com.google.api.client.http.HttpResponseException: 404");
    Truth.assertThat(moneyObserver.error)
        .hasMessageThat()
        .contains("POST https://google.com:443/fake/v1/recognize/0.0?red=-1.0");
    Truth.assertThat(moneyObserver.error)
        .hasMessageThat()
        .contains("java.lang.RuntimeException: some error");
  }

  @Test
  void testObserverErrorCancelsCall() throws Throwable {
    mockService.addResponse(new Money[] {DEFAULT_RESPONSE});
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
    Throwable actualError = actualErrorF.get(11500, TimeUnit.MILLISECONDS);

    Truth.assertThat(actualError).isInstanceOf(ApiException.class);
    Truth.assertThat(((ApiException) actualError).getStatusCode().getCode())
        .isEqualTo(StatusCode.Code.CANCELLED);

    // gax httpjson transport layer is responsible for the immediate cancellation
    Truth.assertThat(actualError.getCause()).isInstanceOf(HttpJsonStatusRuntimeException.class);
    // and the client error is cause for httpjson transport layer to cancel it
    Truth.assertThat(actualError.getCause().getCause()).isSameInstanceAs(expectedCause);
  }

  @Test
  void testBlockingServerStreaming() {
    mockService.addResponse(new Money[] {DEFAULT_RESPONSE});
    Color request = Color.newBuilder().setRed(0.5f).build();
    ServerStream<Money> response = streamingCallable.call(request);
    List<Money> responseData = Lists.newArrayList(response);

    Money expected = Money.newBuilder().setCurrencyCode("USD").setUnits(127).build();
    Truth.assertThat(responseData).containsExactly(expected);
  }

  // This test ensures that the server-side streaming does not exceed the timeout value
  @Test
  void testDeadlineExceededServerStreaming() throws InterruptedException, IOException {
    // set a low timeout to trigger deadline-exceeded sooner
    initialize(java.time.Duration.ofSeconds(1));

    mockService.addResponse(
        new Money[] {DEFAULT_RESPONSE, DEFAULTER_RESPONSE}, java.time.Duration.ofSeconds(30));
    Color request = Color.newBuilder().setRed(0.5f).build();
    CountDownLatch latch = new CountDownLatch(1);
    MoneyObserver moneyObserver = new MoneyObserver(false, latch);

    streamingCallable.call(request, moneyObserver);

    moneyObserver.controller.request(2);
    // Set the latch's await time to above the context's timeout value to ensure that
    // the latch has been released.
    Truth.assertThat(latch.await(30, TimeUnit.SECONDS)).isTrue();

    Truth.assertThat(moneyObserver.error).isInstanceOf(DeadlineExceededException.class);
    Truth.assertThat(moneyObserver.error).hasMessageThat().isEqualTo("Deadline exceeded");
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
