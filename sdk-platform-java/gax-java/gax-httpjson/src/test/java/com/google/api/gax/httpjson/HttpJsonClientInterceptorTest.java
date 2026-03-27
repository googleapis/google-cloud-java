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
package com.google.api.gax.httpjson;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.httpjson.ForwardingHttpJsonClientCall.SimpleForwardingHttpJsonClientCall;
import com.google.api.gax.httpjson.ForwardingHttpJsonClientCallListener.SimpleForwardingHttpJsonClientCallListener;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.EndpointContext;
import com.google.auth.Credentials;
import com.google.protobuf.Field;
import com.google.protobuf.Field.Cardinality;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HttpJsonClientInterceptorTest {

  private static class CapturingClientInterceptor implements HttpJsonClientInterceptor {
    // Manually capturing arguments instead of using Mockito. This is intentional, as this
    // specific test interceptor class represents a typical interceptor implementation. Doing the
    // same with mocks will simply make this whole test less readable.
    private volatile HttpJsonMetadata capturedResponseHeaders;
    private volatile Object capturedMessage;
    private volatile int capturedStatusCode;

    @Override
    public <RequestT, ResponseT> HttpJsonClientCall<RequestT, ResponseT> interceptCall(
        ApiMethodDescriptor<RequestT, ResponseT> method,
        HttpJsonCallOptions callOptions,
        HttpJsonChannel next) {
      HttpJsonClientCall<RequestT, ResponseT> call = next.newCall(method, callOptions);
      return new SimpleForwardingHttpJsonClientCall<RequestT, ResponseT>(call) {
        @Override
        public void start(Listener<ResponseT> responseListener, HttpJsonMetadata requestHeaders) {
          Listener<ResponseT> forwardingResponseListener =
              new SimpleForwardingHttpJsonClientCallListener<ResponseT>(responseListener) {
                @Override
                public void onHeaders(HttpJsonMetadata responseHeaders) {
                  capturedResponseHeaders = responseHeaders;
                  super.onHeaders(responseHeaders);
                }

                @Override
                public void onMessage(ResponseT message) {
                  capturedMessage = message;
                  super.onMessage(message);
                }

                @Override
                public void onClose(int statusCode, HttpJsonMetadata trailers) {
                  capturedStatusCode = statusCode;
                  super.onClose(statusCode, trailers);
                }
              };

          super.start(forwardingResponseListener, requestHeaders);
        }
      };
    }
  }

  private static final ApiMethodDescriptor<Field, Field> FAKE_METHOD_DESCRIPTOR =
      ApiMethodDescriptor.<Field, Field>newBuilder()
          .setFullMethodName("google.cloud.v1.Fake/FakeMethod")
          .setHttpMethod("POST")
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<Field>newBuilder()
                  .setPath(
                      "/fake/v1/name/{name}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<Field> serializer = ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<Field> serializer = ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "number", request.getNumber());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Field>newBuilder()
                  .setDefaultInstance(Field.getDefaultInstance())
                  .build())
          .build();

  private static final MockHttpService MOCK_SERVICE =
      new MockHttpService(Collections.singletonList(FAKE_METHOD_DESCRIPTOR), "google.com:443");

  private static ExecutorService executorService;

  private CapturingClientInterceptor interceptor;
  private ManagedHttpJsonChannel channel;

  @BeforeAll
  public static void initialize() {
    executorService =
        Executors.newFixedThreadPool(
            2,
            r -> {
              Thread t = Executors.defaultThreadFactory().newThread(r);
              t.setDaemon(true);
              return t;
            });
  }

  @AfterAll
  public static void destroy() {
    executorService.shutdownNow();
  }

  @BeforeEach
  void setUp() throws IOException {
    interceptor = new CapturingClientInterceptor();
    channel =
        InstantiatingHttpJsonChannelProvider.newBuilder()
            .setEndpoint("google.com:443")
            .setExecutor(executorService)
            .setHttpTransport(MOCK_SERVICE)
            .setHeaderProvider(() -> Collections.singletonMap("header-key", "headerValue"))
            .setInterceptorProvider(() -> Collections.singletonList(interceptor))
            .build()
            .getTransportChannel()
            .getManagedChannel();
  }

  @AfterEach
  void tearDown() {
    MOCK_SERVICE.reset();
  }

  @Test
  void testCustomInterceptor() throws ExecutionException, InterruptedException, IOException {
    HttpJsonDirectCallable<Field, Field> callable =
        new HttpJsonDirectCallable<>(FAKE_METHOD_DESCRIPTOR);

    EndpointContext endpointContext = Mockito.mock(EndpointContext.class);
    Mockito.doNothing()
        .when(endpointContext)
        .validateUniverseDomain(
            Mockito.any(Credentials.class), Mockito.any(HttpJsonStatusCode.class));

    HttpJsonCallContext callContext =
        HttpJsonCallContext.createDefault()
            .withChannel(channel)
            .withTimeoutDuration(java.time.Duration.ofSeconds(30))
            .withEndpointContext(endpointContext);

    Field request;
    Field expectedResponse;
    request =
        expectedResponse =
            Field.newBuilder() // "echo" service
                .setName("imTheBestField")
                .setNumber(2)
                .setCardinality(Cardinality.CARDINALITY_OPTIONAL)
                .setDefaultValue("blah")
                .build();

    MOCK_SERVICE.addResponse(expectedResponse);

    Field actualResponse = callable.futureCall(request, callContext).get();

    // Test that the interceptors did not affect normal execution
    assertThat(actualResponse).isEqualTo(expectedResponse);
    assertThat(MOCK_SERVICE.getRequestPaths().size()).isEqualTo(1);
    String headerValue = MOCK_SERVICE.getRequestHeaders().get("header-key").iterator().next();

    // Test that internal interceptor worked (the one which inserts headers)
    assertThat(headerValue).isEqualTo("headerValue");

    assertThat(interceptor.capturedStatusCode).isEqualTo(200);
    assertThat(interceptor.capturedResponseHeaders).isNotNull();
    assertThat(interceptor.capturedMessage).isEqualTo(request);
  }
}
