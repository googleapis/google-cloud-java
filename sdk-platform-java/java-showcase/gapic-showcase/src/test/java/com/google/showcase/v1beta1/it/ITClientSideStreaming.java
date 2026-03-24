/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.showcase.v1beta1.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.CancelledException;
import com.google.api.gax.rpc.StatusCode;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoResponse;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ITClientSideStreaming {

  private static EchoClient grpcClient;

  @BeforeAll
  static void createClients() throws Exception {
    // Create gRPC Echo Client
    grpcClient = TestClientInitializer.createGrpcEchoClient();
  }

  @AfterAll
  static void destroyClients() throws InterruptedException {
    grpcClient.close();
    grpcClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  @Test
  void testGrpc_sendStreamedContent_receiveConcatenatedResponse()
      throws ExecutionException, InterruptedException {
    CollectStreamObserver<EchoResponse> responseObserver = new CollectStreamObserver<>();
    ApiStreamObserver<EchoRequest> requestObserver =
        grpcClient.collectCallable().clientStreamingCall(responseObserver);
    String content = "The rain in Spain stays mainly on the plain";
    for (String message : content.split("\\s")) {
      requestObserver.onNext(EchoRequest.newBuilder().setContent(message).build());
    }
    requestObserver.onCompleted();

    List<EchoResponse> serverResponse = responseObserver.future().get();
    assertThat(serverResponse).hasSize(1);
    assertThat(serverResponse.get(0).getContent())
        .isEqualTo("The rain in Spain stays mainly on the plain");
  }

  @Test
  void testGrpc_sendStreamedContent_handleServerError() {
    CollectStreamObserver<EchoResponse> responseObserver = new CollectStreamObserver<>();
    ApiStreamObserver<EchoRequest> requestObserver =
        grpcClient.collectCallable().clientStreamingCall(responseObserver);
    String content = "The rain in Spain stays mainly on the plain";
    for (String message : content.split("\\s")) {
      requestObserver.onNext(EchoRequest.newBuilder().setContent(message).build());
    }
    Status cancelledStatus =
        Status.newBuilder().setCode(StatusCode.Code.CANCELLED.ordinal()).build();
    requestObserver.onNext(EchoRequest.newBuilder().setError(cancelledStatus).build());
    requestObserver.onCompleted();

    ExecutionException exception =
        assertThrows(ExecutionException.class, () -> responseObserver.future().get());
    assertThat(exception.getCause()).isInstanceOf(CancelledException.class);
    CancelledException cancelledException = (CancelledException) exception.getCause();
    assertThat(cancelledException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.CANCELLED);
  }

  /**
   * Implementation of {@link ApiStreamObserver} to accumulate streamed content.
   *
   * @param <T>
   */
  private class CollectStreamObserver<T> implements ApiStreamObserver<T> {

    private final SettableApiFuture<List<T>> future = SettableApiFuture.create();
    private final List<T> messages = new ArrayList<>();

    @Override
    public void onNext(T message) {
      this.messages.add(message);
    }

    @Override
    public void onError(Throwable throwable) {
      this.future.setException(throwable);
    }

    @Override
    public void onCompleted() {
      future.set(this.messages);
    }

    public SettableApiFuture<List<T>> future() {
      return this.future;
    }
  }
}
