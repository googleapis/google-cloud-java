/*
 * Copyright 2018 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.tracing.ApiTracer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

@ExtendWith(MockitoExtension.class)
class AttemptCallableTest {
  @Mock UnaryCallable<String, String> mockInnerCallable;
  ArgumentCaptor<ApiCallContext> capturedCallContext;
  @Mock RetryingFuture<String> mockExternalFuture;
  TimedAttemptSettings currentAttemptSettings;

  @BeforeEach
  void setUp() {
    capturedCallContext = ArgumentCaptor.forClass(ApiCallContext.class);
    when(mockInnerCallable.futureCall(Mockito.anyString(), capturedCallContext.capture()))
        .thenReturn(SettableApiFuture.<String>create());

    currentAttemptSettings =
        TimedAttemptSettings.newBuilder()
            .setGlobalSettings(RetrySettings.newBuilder().build())
            .setAttemptCount(0)
            .setOverallAttemptCount(0)
            .setFirstAttemptStartTimeNanos(0)
            .setRetryDelayDuration(java.time.Duration.ofSeconds(1))
            .setRandomizedRetryDelayDuration(java.time.Duration.ofSeconds(1))
            .setRpcTimeoutDuration(java.time.Duration.ZERO)
            .build();

    when(mockExternalFuture.getAttemptSettings())
        .thenAnswer(
            new Answer<TimedAttemptSettings>() {
              @Override
              public TimedAttemptSettings answer(InvocationOnMock invocation) throws Throwable {
                return currentAttemptSettings;
              }
            });
  }

  @Test
  void testRpcTimeout() {
    FakeCallContext callContext = mock(FakeCallContext.class);
    when(callContext.getTimeoutDuration()).thenReturn(null);
    when(callContext.withTimeoutDuration(any(java.time.Duration.class))).thenReturn(callContext);
    when(callContext.getTracer()).thenReturn(mock(ApiTracer.class));
    AttemptCallable<String, String> callable =
        new AttemptCallable<>(mockInnerCallable, "fake-request", callContext);
    callable.setExternalFuture(mockExternalFuture);

    // Make sure that the rpc timeout is set
    java.time.Duration timeout = java.time.Duration.ofSeconds(10);
    currentAttemptSettings =
        currentAttemptSettings.toBuilder().setRpcTimeoutDuration(timeout).build();

    callable.call();

    Mockito.verify(callContext).withTimeoutDuration(timeout);

    // Make sure that subsequent attempts can extend the timeout
    java.time.Duration longerTimeout = java.time.Duration.ofSeconds(20);
    currentAttemptSettings =
        currentAttemptSettings.toBuilder().setRpcTimeoutDuration(longerTimeout).build();
    callable.call();
    Mockito.verify(callContext).withTimeoutDuration(longerTimeout);
  }

  @Test
  void testRpcTimeoutIsNotErased() {
    java.time.Duration callerTimeout = java.time.Duration.ofMillis(10);
    ApiCallContext callerCallContext =
        FakeCallContext.createDefault().withTimeoutDuration(callerTimeout);

    java.time.Duration timeout = java.time.Duration.ofMillis(5);
    currentAttemptSettings =
        currentAttemptSettings.toBuilder().setRpcTimeoutDuration(timeout).build();

    AttemptCallable<String, String> callable =
        new AttemptCallable<>(mockInnerCallable, "fake-request", callerCallContext);
    callable.setExternalFuture(mockExternalFuture);

    callable.call();

    assertThat(capturedCallContext.getValue().getTimeoutDuration()).isEqualTo(callerTimeout);
  }
}
