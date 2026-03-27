/*
 * Copyright 2024 Google LLC
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

import com.google.api.client.http.HttpTransport;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.httpjson.testing.TestApiTracer;
import com.google.api.gax.rpc.EndpointContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.auth.Credentials;
import com.google.common.truth.Truth;
import com.google.protobuf.Field;
import com.google.protobuf.TypeRegistry;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HttpJsonClientCallImplTest {
  @Mock private ApiMethodDescriptor apiMethodDescriptor;
  @Mock private HttpResponseParser httpResponseParser;
  @Mock private HttpJsonCallOptions httpJsonCallOptions;
  @Mock private TypeRegistry typeRegistry;
  @Mock private HttpTransport httpTransport;
  @Mock private Executor executor;
  @Mock private HttpJsonClientCall.Listener listener;

  @Test
  void responseReceived_noCancellationTask() {
    ScheduledThreadPoolExecutor deadlineSchedulerExecutor = new ScheduledThreadPoolExecutor(1);
    // Null timeout means no timeout task created
    Mockito.when(httpJsonCallOptions.getTimeoutDuration()).thenReturn(null);

    HttpJsonClientCallImpl httpJsonClientCall =
        new HttpJsonClientCallImpl<>(
            apiMethodDescriptor,
            "",
            httpJsonCallOptions,
            httpTransport,
            executor,
            deadlineSchedulerExecutor);
    httpJsonClientCall.start(listener, HttpJsonMetadata.newBuilder().build());
    // No timeout task in the work queue
    Truth.assertThat(deadlineSchedulerExecutor.getQueue().size()).isEqualTo(0);
    // Follows the numMessages requested from HttpJsonClientCalls.futureUnaryCall()
    httpJsonClientCall.request(2);
    httpJsonClientCall.setResult(
        HttpRequestRunnable.RunnableResult.builder()
            .setStatusCode(200)
            .setTrailers(HttpJsonMetadata.newBuilder().build())
            .build());
    Truth.assertThat(deadlineSchedulerExecutor.getQueue().size()).isEqualTo(0);
    deadlineSchedulerExecutor.shutdown();
    // Scheduler is not waiting for any task and should terminate immediately
    Truth.assertThat(deadlineSchedulerExecutor.isTerminated()).isTrue();
  }

  @Test
  void responseReceived_cancellationTaskExists_isCancelledProperly() throws InterruptedException {
    ScheduledThreadPoolExecutor deadlineSchedulerExecutor = new ScheduledThreadPoolExecutor(1);
    // SetRemoveOnCancelPolicy will immediately remove the task from the work queue
    // when the task is cancelled
    deadlineSchedulerExecutor.setRemoveOnCancelPolicy(true);

    // Setting a timeout for this call will enqueue a timeout task
    Mockito.when(httpJsonCallOptions.getTimeoutDuration())
        .thenReturn(java.time.Duration.ofMinutes(10));

    String response = "Content";
    InputStream inputStream = new ByteArrayInputStream(response.getBytes());
    Mockito.when(httpJsonCallOptions.getTypeRegistry()).thenReturn(typeRegistry);
    Mockito.when(apiMethodDescriptor.getResponseParser()).thenReturn(httpResponseParser);
    Mockito.when(
            httpResponseParser.parse(Mockito.any(Reader.class), Mockito.any(TypeRegistry.class)))
        .thenReturn(response);
    HttpJsonClientCallImpl httpJsonClientCall =
        new HttpJsonClientCallImpl<>(
            apiMethodDescriptor,
            "",
            httpJsonCallOptions,
            httpTransport,
            executor,
            deadlineSchedulerExecutor);
    httpJsonClientCall.start(listener, HttpJsonMetadata.newBuilder().build());
    // The timeout task is scheduled for 10 minutes from invocation. The task should be
    // populated in the work queue, scheduled to run, but not active yet.
    Truth.assertThat(deadlineSchedulerExecutor.getQueue().size()).isEqualTo(1);
    // Follows the numMessages requested from HttpJsonClientCalls.futureUnaryCall()
    httpJsonClientCall.request(2);
    httpJsonClientCall.setResult(
        HttpRequestRunnable.RunnableResult.builder()
            .setStatusCode(200)
            .setTrailers(HttpJsonMetadata.newBuilder().build())
            .setResponseContent(inputStream)
            .build());
    // After the result is received, `close()` should have run and removed the timeout task
    // Expect that there are no tasks in the queue and no active tasks
    Truth.assertThat(deadlineSchedulerExecutor.getQueue().size()).isEqualTo(0);
    deadlineSchedulerExecutor.shutdown();

    // Ideally, this test wouldn't need to awaitTermination. Given the machine this test
    // is running on, we can't guarantee that isTerminated is true immediately. The point
    // of this test is that it doesn't wait the full timeout duration (10 min) to terminate
    // and rather is able to terminate after we invoke shutdown on the deadline scheduler.
    deadlineSchedulerExecutor.awaitTermination(5, TimeUnit.SECONDS);
    // Scheduler is not waiting for any task and should terminate quickly
    Truth.assertThat(deadlineSchedulerExecutor.isTerminated()).isTrue();
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
                  .setQueryParamsExtractor(request -> new HashMap<>())
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
  private ManagedHttpJsonChannel channel;
  private TestApiTracer tracer;

  @BeforeAll
  static void initialize() {
    executorService = Executors.newFixedThreadPool(2);
  }

  @AfterAll
  static void destroy() {
    executorService.shutdownNow();
  }

  @BeforeEach
  void setUp() {
    channel =
        ManagedHttpJsonChannel.newBuilder()
            .setEndpoint("google.com:443")
            .setExecutor(executorService)
            .setHttpTransport(MOCK_SERVICE)
            .build();
    tracer = new TestApiTracer();
  }

  @AfterEach
  void tearDown() {
    MOCK_SERVICE.reset();
  }

  @Test
  void testBodySizeRecording() throws Exception {
    HttpJsonDirectCallable<Field, Field> callable =
        new HttpJsonDirectCallable<>(FAKE_METHOD_DESCRIPTOR);

    EndpointContext endpointContext = Mockito.mock(EndpointContext.class);
    Mockito.lenient()
        .doNothing()
        .when(endpointContext)
        .validateUniverseDomain(
            Mockito.any(Credentials.class), Mockito.any(HttpJsonStatusCode.class));

    HttpJsonCallContext callContext =
        HttpJsonCallContext.createDefault()
            .withChannel(channel)
            .withEndpointContext(endpointContext)
            .withTracer(tracer);

    Field request = Field.newBuilder().setName("bob").setNumber(42).build();
    Field response = Field.newBuilder().setName("alice").setNumber(43).build();

    MOCK_SERVICE.addResponse(response);

    callable.futureCall(request, callContext).get();

    // Verify response size
    // MockHttpService uses ProtoRestSerializer which pretty-prints.
    String expectedResponseBody = ProtoRestSerializer.create().toBody("*", response, false);
    long expectedResponseSize = expectedResponseBody.getBytes("UTF-8").length;
    assertThat(tracer.getResponseReceivedSize()).isEqualTo(expectedResponseSize);
  }

  @Test
  void testBodySizeRecordingServerStreaming() throws Exception {
    ApiMethodDescriptor<Field, Field> methodServerStreaming =
        FAKE_METHOD_DESCRIPTOR.toBuilder()
            .setType(ApiMethodDescriptor.MethodType.SERVER_STREAMING)
            .build();

    MockHttpService streamingMockService =
        new MockHttpService(Collections.singletonList(methodServerStreaming), "google.com:443");
    ManagedHttpJsonChannel streamingChannel =
        ManagedHttpJsonChannel.newBuilder()
            .setEndpoint("google.com:443")
            .setExecutor(executorService)
            .setHttpTransport(streamingMockService)
            .build();

    HttpJsonDirectServerStreamingCallable<Field, Field> callable =
        new HttpJsonDirectServerStreamingCallable<>(methodServerStreaming);

    EndpointContext endpointContext = Mockito.mock(EndpointContext.class);
    Mockito.lenient()
        .doNothing()
        .when(endpointContext)
        .validateUniverseDomain(
            Mockito.any(Credentials.class), Mockito.any(HttpJsonStatusCode.class));

    HttpJsonCallContext callContext =
        HttpJsonCallContext.createDefault()
            .withChannel(streamingChannel)
            .withEndpointContext(endpointContext)
            .withTracer(tracer);

    Field request = Field.newBuilder().setName("bob").setNumber(42).build();
    Field response1 = Field.newBuilder().setName("alice1").setNumber(43).build();
    Field response2 = Field.newBuilder().setName("alice2").setNumber(44).build();

    streamingMockService.addResponse(new Field[] {response1, response2});

    final List<Field> receivedResponses = new java.util.ArrayList<>();
    final CountDownLatch latch = new CountDownLatch(1);

    callable.call(
        request,
        new ResponseObserver<Field>() {
          @Override
          public void onStart(StreamController controller) {
            // no behavior needed
          }

          @Override
          public void onResponse(Field response) {
            receivedResponses.add(response);
          }

          @Override
          public void onError(Throwable t) {
            latch.countDown();
          }

          @Override
          public void onComplete() {
            latch.countDown();
          }
        },
        callContext);

    latch.await(10, TimeUnit.SECONDS);

    assertThat(receivedResponses).hasSize(2);

    // Verify response size (0 because streaming chunked responses don't include Content-Length)
    assertThat(tracer.getResponseReceivedSize()).isEqualTo(0);
    streamingChannel.shutdownNow();
  }
}
