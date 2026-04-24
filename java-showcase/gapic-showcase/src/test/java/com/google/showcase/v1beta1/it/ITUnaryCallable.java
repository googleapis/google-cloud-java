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

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.CancelledException;
import com.google.api.gax.rpc.StatusCode;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoResponse;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ITUnaryCallable {

  private static EchoClient grpcClient;

  private static EchoClient httpjsonClient;

  @BeforeAll
  static void createClients() throws Exception {
    // Create gRPC Echo Client
    grpcClient = TestClientInitializer.createGrpcEchoClient();
    // Create Http JSON Echo Client
    httpjsonClient = TestClientInitializer.createHttpJsonEchoClient();
  }

  @AfterAll
  static void destroyClients() throws InterruptedException {
    grpcClient.close();
    httpjsonClient.close();

    grpcClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    httpjsonClient.awaitTermination(
        TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  @Test
  void testGrpc_receiveContent() {
    assertThat(echoGrpc("grpc-echo?")).isEqualTo("grpc-echo?");
    assertThat(echoGrpc("grpc-echo!")).isEqualTo("grpc-echo!");
  }

  @Test
  void testGrpc_serverResponseError_throwsException() {
    Status cancelledStatus =
        Status.newBuilder().setCode(StatusCode.Code.CANCELLED.ordinal()).build();
    EchoRequest requestWithServerError = EchoRequest.newBuilder().setError(cancelledStatus).build();
    CancelledException exception =
        assertThrows(CancelledException.class, () -> grpcClient.echo(requestWithServerError));
    assertThat(exception.getStatusCode().getCode()).isEqualTo(GrpcStatusCode.Code.CANCELLED);
  }

  @Test
  void testHttpJson_receiveContent() {
    assertThat(echoHttpJson("http-echo?")).isEqualTo("http-echo?");
    assertThat(echoHttpJson("http-echo!")).isEqualTo("http-echo!");
  }

  @Test
  void testHttpJson_serverResponseError_throwsException() {
    EchoRequest requestWithServerError =
        EchoRequest.newBuilder()
            .setError(Status.newBuilder().setCode(StatusCode.Code.CANCELLED.ordinal()).build())
            .build();
    CancelledException exception =
        assertThrows(CancelledException.class, () -> httpjsonClient.echo(requestWithServerError));
    assertThat(exception.getStatusCode().getCode()).isEqualTo(StatusCode.Code.CANCELLED);
  }

  private String echoGrpc(String value) {
    EchoResponse response = grpcClient.echo(EchoRequest.newBuilder().setContent(value).build());
    return response.getContent();
  }

  private String echoHttpJson(String value) {
    EchoResponse response = httpjsonClient.echo(EchoRequest.newBuilder().setContent(value).build());
    return response.getContent();
  }
}
