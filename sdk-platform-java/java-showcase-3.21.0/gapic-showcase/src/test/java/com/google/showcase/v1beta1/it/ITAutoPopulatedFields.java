/*
 * Copyright 2024 Google LLC
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

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.ForwardingHttpJsonClientCall;
import com.google.api.gax.httpjson.HttpJsonCallOptions;
import com.google.api.gax.httpjson.HttpJsonChannel;
import com.google.api.gax.httpjson.HttpJsonClientCall;
import com.google.api.gax.httpjson.HttpJsonClientInterceptor;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.truth.Truth;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoResponse;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.MethodDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.threeten.bp.Duration;

class ITAutoPopulatedFields {

  private static class HttpJsonInterceptor implements HttpJsonClientInterceptor {
    private Consumer<Object> onRequestIntercepted;

    private HttpJsonInterceptor() {}

    private void setOnRequestIntercepted(Consumer<Object> onRequestIntercepted) {
      this.onRequestIntercepted = onRequestIntercepted;
    }

    @Override
    public <ReqT, RespT> HttpJsonClientCall<ReqT, RespT> interceptCall(
        ApiMethodDescriptor<ReqT, RespT> method,
        HttpJsonCallOptions callOptions,
        HttpJsonChannel next) {
      HttpJsonClientCall<ReqT, RespT> call = next.newCall(method, callOptions);

      return new ForwardingHttpJsonClientCall.SimpleForwardingHttpJsonClientCall<ReqT, RespT>(
          call) {
        @Override
        public void sendMessage(ReqT message) {
          // Capture the request message
          if (onRequestIntercepted != null) {
            onRequestIntercepted.accept(message);
          }
          super.sendMessage(message);
        }
      };
    }
  }

  // Implement a request interceptor to retrieve the request ID being sent on the request.
  private static class GRPCInterceptor implements ClientInterceptor {
    private Consumer<Object> onRequestIntercepted;

    private GRPCInterceptor() {}

    private void setOnRequestIntercepted(Consumer<Object> onRequestIntercepted) {
      this.onRequestIntercepted = onRequestIntercepted;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {

      return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
          next.newCall(method, callOptions)) {
        @Override
        public void sendMessage(ReqT message) {
          // Capture the request message
          if (onRequestIntercepted != null) {
            onRequestIntercepted.accept(message);
          }
          super.sendMessage(message);
        }
      };
    }
  }

  private GRPCInterceptor grpcRequestInterceptor;
  private HttpJsonInterceptor httpJsonInterceptor;
  private EchoClient grpcClientWithoutRetries;
  private EchoClient grpcClientWithRetries;

  private EchoClient httpJsonClient;
  private EchoClient httpJsonClientWithRetries;

  @BeforeEach
  void createClients() throws Exception {
    RetrySettings defaultRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(5000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeout(Duration.ofMillis(5000L))
            .setTotalTimeout(Duration.ofMillis(5000L))
            // Cap retries at 5
            .setMaxAttempts(5)
            .build();

    // Adding `Code.INTERNAL` is necessary because for httpJson requests, the httpJson status code
    // is mapped here:
    // https://github.com/googleapis/sdk-platform-java/blob/acdde47445916dd306ce8b91489fab45c9c2ef50/gax-java/gax-httpjson/src/main/java/com/google/api/gax/httpjson/HttpJsonStatusCode.java#L96-L133
    // Therefore, just setting the error code to `Code.UNKNOWN` for httpJson will get translated
    // instead to `Code.INTERNAL`.
    Set<Code> retryableCodes = ImmutableSet.of(Code.UNKNOWN, Code.INTERNAL);

    // Create gRPC Interceptor and Client
    grpcRequestInterceptor = new ITAutoPopulatedFields.GRPCInterceptor();
    grpcClientWithoutRetries =
        TestClientInitializer.createGrpcEchoClient(ImmutableList.of(grpcRequestInterceptor));
    grpcClientWithRetries =
        TestClientInitializer.createGrpcEchoClientWithRetrySettings(
            defaultRetrySettings, retryableCodes, ImmutableList.of(grpcRequestInterceptor));

    // Create HttpJson Interceptor and Client
    httpJsonInterceptor = new ITAutoPopulatedFields.HttpJsonInterceptor();
    httpJsonClient =
        TestClientInitializer.createHttpJsonEchoClient(ImmutableList.of(httpJsonInterceptor));
    httpJsonClientWithRetries =
        TestClientInitializer.createHttpJsonEchoClientWithRetrySettings(
            defaultRetrySettings, retryableCodes, ImmutableList.of(httpJsonInterceptor));
  }

  @AfterEach
  void destroyClient() throws InterruptedException {
    grpcClientWithoutRetries.close();
    grpcClientWithRetries.close();
    httpJsonClient.close();

    grpcClientWithoutRetries.awaitTermination(
        TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    grpcClientWithRetries.awaitTermination(
        TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    httpJsonClient.awaitTermination(
        TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  @Test
  void testGrpc_autoPopulateRequestIdWhenAttemptedOnceSuccessfully() {
    List<String> capturedRequestIds = new ArrayList<>();
    grpcRequestInterceptor.setOnRequestIntercepted(
        request -> {
          if (request instanceof EchoRequest) {
            EchoRequest echoRequest = (EchoRequest) request;
            capturedRequestIds.add(echoRequest.getRequestId());
          }
        });
    grpcClientWithoutRetries.echo(EchoRequest.newBuilder().build());
    Truth.assertThat(capturedRequestIds).isNotEmpty();
    // Autopopulation of UUID is currently only configured for format UUID4.
    Integer UUIDVersion = 4;
    Truth.assertThat(UUID.fromString(capturedRequestIds.get(0)).version()).isEqualTo(UUIDVersion);
  }

  @Test
  void testGrpc_shouldNotAutoPopulateRequestIdIfSetInRequest() {
    List<String> capturedRequestIds = new ArrayList<>();
    grpcRequestInterceptor.setOnRequestIntercepted(
        request -> {
          if (request instanceof EchoRequest) {
            EchoRequest echoRequest = (EchoRequest) request;
            capturedRequestIds.add(echoRequest.getRequestId());
          }
        });
    String UUIDsent = UUID.randomUUID().toString();
    grpcClientWithoutRetries.echo(EchoRequest.newBuilder().setRequestId(UUIDsent).build());
    Truth.assertThat(capturedRequestIds).isNotEmpty();
    Truth.assertThat(capturedRequestIds).contains(UUIDsent);
  }

  @Test
  void testHttpJson_autoPopulateRequestIdWhenAttemptedOnceSuccessfully() {
    List<String> capturedRequestIds = new ArrayList<>();
    httpJsonInterceptor.setOnRequestIntercepted(
        request -> {
          if (request instanceof EchoRequest) {
            EchoRequest echoRequest = (EchoRequest) request;
            capturedRequestIds.add(echoRequest.getRequestId());
          }
        });
    httpJsonClient.echo(EchoRequest.newBuilder().build());
    Truth.assertThat(capturedRequestIds).isNotEmpty();
    // Autopopulation of UUID is currently only configured for format UUID4.
    Integer UUIDVersion = 4;
    Truth.assertThat(UUID.fromString(capturedRequestIds.get(0)).version()).isEqualTo(UUIDVersion);
  }

  @Test
  void testHttpJson_shouldNotAutoPopulateRequestIdIfSetInRequest() {
    String UUIDsent = UUID.randomUUID().toString();
    List<String> capturedRequestIds = new ArrayList<>();
    httpJsonInterceptor.setOnRequestIntercepted(
        request -> {
          if (request instanceof EchoRequest) {
            EchoRequest echoRequest = (EchoRequest) request;
            capturedRequestIds.add(echoRequest.getRequestId());
          }
        });
    httpJsonClient.echo(EchoRequest.newBuilder().setRequestId(UUIDsent).build());
    Truth.assertThat(capturedRequestIds).isNotEmpty();
    Truth.assertThat(capturedRequestIds).contains(UUIDsent);
  }

  @Test
  void testGRPC_setsSameRequestIdIfSetInRequestWhenRequestsAreRetried() throws Exception {
    List<String> capturedRequestIds = new ArrayList<>();
    grpcRequestInterceptor.setOnRequestIntercepted(
        request -> {
          if (request instanceof EchoRequest) {
            EchoRequest echoRequest = (EchoRequest) request;
            capturedRequestIds.add(echoRequest.getRequestId());
          }
        });
    String UUIDsent = UUID.randomUUID().toString();
    EchoRequest requestSent =
        EchoRequest.newBuilder()
            .setRequestId(UUIDsent)
            .setError(Status.newBuilder().setCode(Code.UNKNOWN.ordinal()).build())
            .build();

    try {
      RetryingFuture<EchoResponse> retryingFuture =
          (RetryingFuture<EchoResponse>)
              grpcClientWithRetries.echoCallable().futureCall(requestSent);
      assertThrows(ExecutionException.class, () -> retryingFuture.get(10, TimeUnit.SECONDS));
      // assert that the number of request IDs is equal to the max attempt
      Truth.assertThat(capturedRequestIds).hasSize(5);
      // assert that each request ID sent is the same as the UUIDSent
      Truth.assertThat(capturedRequestIds)
          .containsExactly(UUIDsent, UUIDsent, UUIDsent, UUIDsent, UUIDsent);
    } finally {
      grpcClientWithRetries.close();
      grpcClientWithRetries.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  @Test
  void testGRPC_setsSameAutoPopulatedRequestIdWhenRequestsAreRetried() throws Exception {
    List<String> capturedRequestIds = new ArrayList<>();
    grpcRequestInterceptor.setOnRequestIntercepted(
        request -> {
          if (request instanceof EchoRequest) {
            EchoRequest echoRequest = (EchoRequest) request;
            capturedRequestIds.add(echoRequest.getRequestId());
          }
        });

    EchoRequest requestSent =
        EchoRequest.newBuilder()
            .setError(Status.newBuilder().setCode(Code.UNKNOWN.ordinal()).build())
            .build();

    try {
      RetryingFuture<EchoResponse> retryingFuture =
          (RetryingFuture<EchoResponse>)
              grpcClientWithRetries.echoCallable().futureCall(requestSent);
      assertThrows(ExecutionException.class, () -> retryingFuture.get(10, TimeUnit.SECONDS));
      // assert that the number of request IDs is equal to the max attempt
      Truth.assertThat(capturedRequestIds).hasSize(5);
      // assert that each request ID sent is the same
      Truth.assertThat(capturedRequestIds)
          .containsExactly(
              capturedRequestIds.get(0),
              capturedRequestIds.get(0),
              capturedRequestIds.get(0),
              capturedRequestIds.get(0),
              capturedRequestIds.get(0));
    } finally {
      grpcClientWithRetries.close();
      grpcClientWithRetries.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  @Test
  void testHttpJson_setsSameRequestIdIfSetInRequestWhenRequestsAreRetried() throws Exception {
    List<String> capturedRequestIds = new ArrayList<>();
    httpJsonInterceptor.setOnRequestIntercepted(
        request -> {
          if (request instanceof EchoRequest) {
            EchoRequest echoRequest = (EchoRequest) request;
            capturedRequestIds.add(echoRequest.getRequestId());
          }
        });
    String UUIDsent = UUID.randomUUID().toString();
    EchoRequest requestSent =
        EchoRequest.newBuilder()
            .setRequestId(UUIDsent)
            .setError(Status.newBuilder().setCode(Code.UNKNOWN.getHttpStatusCode()).build())
            .build();
    try {
      RetryingFuture<EchoResponse> retryingFuture =
          (RetryingFuture<EchoResponse>)
              httpJsonClientWithRetries.echoCallable().futureCall(requestSent);
      assertThrows(ExecutionException.class, () -> retryingFuture.get(10, TimeUnit.SECONDS));
      // assert that the number of request IDs is equal to the max attempt
      Truth.assertThat(capturedRequestIds).hasSize(5);
      // assert that each request ID sent is the same as the UUIDSent
      Truth.assertThat(capturedRequestIds)
          .containsExactly(UUIDsent, UUIDsent, UUIDsent, UUIDsent, UUIDsent);
    } finally {
      httpJsonClientWithRetries.close();
      httpJsonClientWithRetries.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  @Test
  void testHttpJson_setsSameAutoPopulatedRequestIdWhenRequestsAreRetried() throws Exception {
    List<String> capturedRequestIds = new ArrayList<>();
    httpJsonInterceptor.setOnRequestIntercepted(
        request -> {
          if (request instanceof EchoRequest) {
            EchoRequest echoRequest = (EchoRequest) request;
            capturedRequestIds.add(echoRequest.getRequestId());
          }
        });
    EchoRequest requestSent =
        EchoRequest.newBuilder()
            .setError(Status.newBuilder().setCode(Code.UNKNOWN.getHttpStatusCode()).build())
            .build();
    try {
      RetryingFuture<EchoResponse> retryingFuture =
          (RetryingFuture<EchoResponse>)
              httpJsonClientWithRetries.echoCallable().futureCall(requestSent);
      assertThrows(ExecutionException.class, () -> retryingFuture.get(10, TimeUnit.SECONDS));
      // assert that the number of request IDs is equal to the max attempt
      Truth.assertThat(capturedRequestIds).hasSize(5);
      // assert that each request ID sent is the same
      Truth.assertThat(capturedRequestIds)
          .containsExactly(
              capturedRequestIds.get(0),
              capturedRequestIds.get(0),
              capturedRequestIds.get(0),
              capturedRequestIds.get(0),
              capturedRequestIds.get(0));
    } finally {
      httpJsonClientWithRetries.close();
      httpJsonClientWithRetries.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }
}
