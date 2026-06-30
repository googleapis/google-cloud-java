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

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.gax.core.FakeApiClock;
import com.google.api.gax.core.RecordingScheduler;
import com.google.api.gax.grpc.testing.FakeMethodDescriptor;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.EndpointContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.TransportChannel;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.auth.Credentials;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsSettings;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.longrunning.stub.OperationsStub;
import com.google.longrunning.stub.OperationsStubSettings;
import com.google.protobuf.Any;
import com.google.protobuf.Message;
import com.google.type.Color;
import com.google.type.Money;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.Status.Code;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GrpcLongRunningTest {

  private static final RetrySettings FAST_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelayDuration(java.time.Duration.ofMillis(1L))
          .setRetryDelayMultiplier(1)
          .setMaxRetryDelayDuration(java.time.Duration.ofMillis(1L))
          .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(1L))
          .setMaxAttempts(0)
          .setJittered(false)
          .setRpcTimeoutMultiplier(1)
          .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(1L))
          .setTotalTimeoutDuration(java.time.Duration.ofMillis(5L))
          .build();

  private ManagedChannel channel;
  private OperationsStub operationsStub;
  private RecordingScheduler executor;
  private ClientContext initialContext;
  private OperationCallSettings<Integer, Color, Money> callSettings;

  private FakeApiClock clock;
  private OperationTimedPollAlgorithm pollingAlgorithm;

  @BeforeEach
  void setUp() throws IOException {
    channel = mock(ManagedChannel.class);
    TransportChannelProvider operationsChannelProvider = mock(TransportChannelProvider.class);
    TransportChannel transportChannel =
        GrpcTransportChannel.newBuilder().setManagedChannel(channel).build();
    when(operationsChannelProvider.getTransportChannel()).thenReturn(transportChannel);
    when(operationsChannelProvider.withUseS2A(Mockito.any(boolean.class)))
        .thenReturn(operationsChannelProvider);

    clock = new FakeApiClock(0L);
    executor = RecordingScheduler.create(clock);
    pollingAlgorithm = OperationTimedPollAlgorithm.create(FAST_RETRY_SETTINGS, clock);

    OperationsSettings.Builder settingsBuilder = OperationsSettings.newBuilder();
    settingsBuilder
        .getOperationSettings()
        .setRetrySettings(FAST_RETRY_SETTINGS.toBuilder().setMaxAttempts(1).build());
    OperationsSettings settings =
        OperationsSettings.newBuilder()
            .setTransportChannelProvider(operationsChannelProvider)
            .build();
    operationsStub =
        GrpcOperationsStub.create(((OperationsStubSettings) settings.getStubSettings()));

    UnaryCallSettings<Integer, OperationSnapshot> initialCallSettings =
        UnaryCallSettings.<Integer, OperationSnapshot>newUnaryCallSettingsBuilder()
            .setRetrySettings(FAST_RETRY_SETTINGS.toBuilder().setMaxAttempts(1).build())
            .build();

    callSettings =
        OperationCallSettings.<Integer, Color, Money>newBuilder()
            .setInitialCallSettings(initialCallSettings)
            .setResponseTransformer(
                ProtoOperationTransformers.ResponseTransformer.create(Color.class))
            .setMetadataTransformer(
                ProtoOperationTransformers.MetadataTransformer.create(Money.class))
            .setPollingAlgorithm(pollingAlgorithm)
            .build();

    EndpointContext endpointContext = Mockito.mock(EndpointContext.class);
    Mockito.doNothing()
        .when(endpointContext)
        .validateUniverseDomain(Mockito.any(Credentials.class), Mockito.any(GrpcStatusCode.class));

    initialContext =
        ClientContext.newBuilder()
            .setTransportChannel(
                GrpcTransportChannel.newBuilder().setManagedChannel(channel).build())
            .setExecutor(executor)
            .setDefaultCallContext(
                GrpcCallContext.of(channel, CallOptions.DEFAULT)
                    .withEndpointContext(endpointContext))
            .setClock(clock)
            .build();
  }

  @Test
  void testCall() throws IOException {
    Color resp = getColor(1.0f);
    Money meta = getMoney("UAH");
    Operation resultOperation = getOperation("testCall", resp, meta, true);
    mockResponse(channel, Code.OK, resultOperation);

    OperationCallable<Integer, Color, Money> callable =
        GrpcCallableFactory.createOperationCallable(
            createGrpcSettings(), callSettings, initialContext, operationsStub);

    EndpointContext endpointContext = Mockito.mock(EndpointContext.class);
    Mockito.doNothing()
        .when(endpointContext)
        .validateUniverseDomain(Mockito.any(Credentials.class), Mockito.any(GrpcStatusCode.class));

    Color response =
        callable.call(2, GrpcCallContext.createDefault().withEndpointContext(endpointContext));
    assertThat(response).isEqualTo(resp);
    assertThat(executor.getIterationsCount()).isEqualTo(0);
  }

  @Test
  void testFutureCallPollDoneOnFirst() throws Exception {
    String opName = "testFutureCallPollDoneOnFirst";
    Color resp = getColor(0.5f);
    Money meta = getMoney("UAH");
    Operation initialOperation = getOperation(opName, null, null, false);
    Operation resultOperation = getOperation(opName, resp, meta, true);
    mockResponse(channel, Code.OK, initialOperation, resultOperation);

    OperationCallable<Integer, Color, Money> callable =
        GrpcCallableFactory.createOperationCallable(
            createGrpcSettings(), callSettings, initialContext, operationsStub);

    OperationFuture<Color, Money> future = callable.futureCall(2);

    assertFutureSuccessMetaSuccess(opName, future, resp, meta);
    assertThat(executor.getIterationsCount()).isEqualTo(0);
  }

  private void assertFutureSuccessMetaSuccess(
      String opName, OperationFuture<Color, Money> future, Color resp, Money meta)
      throws Exception {
    assertThat(future.getName()).isEqualTo(opName);
    assertThat(future.get(3, TimeUnit.SECONDS)).isEqualTo(resp);
    assertThat(future.isDone()).isTrue();
    assertThat(future.isCancelled()).isFalse();
    assertThat(future.get()).isEqualTo(resp);

    assertThat(future.peekMetadata().get()).isEqualTo(meta);
    assertThat(future.peekMetadata()).isSameInstanceAs(future.peekMetadata());
    assertThat(future.peekMetadata().isDone()).isTrue();
    assertThat(future.peekMetadata().isCancelled()).isFalse();

    assertThat(future.getMetadata().get()).isEqualTo(meta);
    assertThat(future.getMetadata()).isSameInstanceAs(future.getMetadata());
    assertThat(future.getMetadata().isDone()).isTrue();
    assertThat(future.getMetadata().isCancelled()).isFalse();
  }

  private Color getColor(float blueValue) {
    return Color.newBuilder().setBlue(blueValue).build();
  }

  private Money getMoney(String currencyCode) {
    return Money.newBuilder().setCurrencyCode(currencyCode).build();
  }

  private Operation getOperation(String name, Message response, Message metadata, boolean done) {
    Operation.Builder builder = Operation.newBuilder().setName(name).setDone(done);
    if (response instanceof com.google.rpc.Status) {
      builder.setError((com.google.rpc.Status) response);
    } else if (response != null) {
      builder.setResponse(Any.pack(response));
    }
    if (metadata != null) {
      builder.setMetadata(Any.pack(metadata));
    }
    return builder.build();
  }

  @SuppressWarnings("unchecked")
  private void mockResponse(ManagedChannel channel, Code statusCode, Object... results) {
    Status status = statusCode.toStatus();
    ClientCall<Integer, ?> clientCall = new MockClientCall<>(results[0], status);
    ClientCall<Integer, ?>[] moreCalls = new ClientCall[results.length - 1];
    for (int i = 0; i < results.length - 1; i++) {
      moreCalls[i] = new MockClientCall<>(results[i + 1], status);
    }
    when(channel.newCall(any(MethodDescriptor.class), any(CallOptions.class)))
        .thenReturn(clientCall, moreCalls);
  }

  private GrpcCallSettings<Integer, Operation> createGrpcSettings() {
    return GrpcCallSettings.create(FakeMethodDescriptor.<Integer, Operation>create());
  }
}
