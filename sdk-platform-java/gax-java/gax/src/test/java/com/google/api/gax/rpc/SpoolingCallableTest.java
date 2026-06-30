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
package com.google.api.gax.rpc;

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.testing.MockStreamingApi.MockServerStreamingCall;
import com.google.api.gax.rpc.testing.MockStreamingApi.MockServerStreamingCallable;
import com.google.common.truth.Truth;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpoolingCallableTest {
  private MockServerStreamingCallable<String, String> upstream;
  private SpoolingCallable<String, String> callable;

  @BeforeEach
  void setup() {
    upstream = new MockServerStreamingCallable<>();
    callable = new SpoolingCallable<>(upstream);
  }

  @Test
  void testHappyPath() throws InterruptedException, ExecutionException {
    ApiFuture<List<String>> result = callable.futureCall("request");
    MockServerStreamingCall<String, String> call = upstream.popLastCall();

    Truth.assertThat(call.getController().isAutoFlowControlEnabled()).isTrue();

    call.getController().getObserver().onResponse("response1");
    call.getController().getObserver().onResponse("response2");
    call.getController().getObserver().onComplete();

    Truth.assertThat(result.get()).containsExactly("response1", "response2").inOrder();
  }

  @Test
  void testEarlyTermination() throws Exception {
    ApiFuture<List<String>> result = callable.futureCall("request");
    MockServerStreamingCall<String, String> call = upstream.popLastCall();

    // The caller cancels the stream while receiving responses
    call.getController().getObserver().onResponse("response1");
    result.cancel(true);
    call.getController().getObserver().onResponse("response2");

    // The cancellation should propagate upstream
    Truth.assertThat(call.getController().isCancelled()).isTrue();
    // Then we fake a cancellation going the other way (it will be wrapped in StatusRuntimeException
    // for grpc)
    call.getController()
        .getObserver()
        .onError(new RuntimeException("Some other upstream cancellation indicator"));

    // However the inner cancellation exception will be masked by an outer CancellationException
    try {
      result.get();
      Assertions.fail("Callable should have thrown an exception");
    } catch (CancellationException expected) {
      Truth.assertThat(expected).hasMessageThat().contains("Task was cancelled.");
    }
  }

  @Test
  void testNoResults() throws Exception {
    ApiFuture<List<String>> result = callable.futureCall("request");
    MockServerStreamingCall<String, String> call = upstream.popLastCall();

    call.getController().getObserver().onComplete();

    Truth.assertThat(result.get()).isEmpty();
  }
}
