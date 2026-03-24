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

import com.google.api.client.http.HttpTransport;
import com.google.common.truth.Truth;
import com.google.protobuf.TypeRegistry;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
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
}
