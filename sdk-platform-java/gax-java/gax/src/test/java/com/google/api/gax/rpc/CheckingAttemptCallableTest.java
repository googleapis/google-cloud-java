/*
 * Copyright 2016 Google LLC
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
import static org.mockito.Mockito.verify;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.testing.FakeCallContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

@ExtendWith(MockitoExtension.class)
class CheckingAttemptCallableTest {
  @Mock UnaryCallable<String, String> mockInnerCallable;
  ArgumentCaptor<ApiCallContext> capturedCallContext;
  @Mock RetryingFuture<String> mockExternalFuture;
  TimedAttemptSettings currentAttemptSettings;

  @BeforeEach
  void setUp() {
    capturedCallContext = ArgumentCaptor.forClass(ApiCallContext.class);

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

    Mockito.when(mockExternalFuture.getAttemptSettings())
        .thenAnswer(
            new Answer<TimedAttemptSettings>() {
              @Override
              public TimedAttemptSettings answer(InvocationOnMock invocation) throws Throwable {
                return currentAttemptSettings;
              }
            });
  }

  @Test
  void testRpcTimeout_gtZero_succeeds() {
    Mockito.when(mockInnerCallable.futureCall(Mockito.<String>any(), capturedCallContext.capture()))
        .thenReturn(SettableApiFuture.<String>create());
    CheckingAttemptCallable<String, String> callable =
        new CheckingAttemptCallable<>(mockInnerCallable, FakeCallContext.createDefault());
    callable.setExternalFuture(mockExternalFuture);

    // Make sure that the rpc timeout is set
    java.time.Duration timeout = java.time.Duration.ofSeconds(10);
    currentAttemptSettings =
        currentAttemptSettings.toBuilder().setRpcTimeoutDuration(timeout).build();

    callable.call();

    assertThat(capturedCallContext.getValue().getTimeoutDuration()).isEqualTo(timeout);

    // Make sure that subsequent attempts can extend the timeout
    java.time.Duration longerTimeout = java.time.Duration.ofSeconds(20);
    currentAttemptSettings =
        currentAttemptSettings.toBuilder().setRpcTimeoutDuration(longerTimeout).build();
    callable.call();
    assertThat(capturedCallContext.getValue().getTimeoutDuration()).isEqualTo(longerTimeout);
  }

  @Test
  void testRpcTimeout_gtZero_callsWithTimeoutDuration() {
    FakeCallContext callContext = Mockito.spy(FakeCallContext.createDefault());
    Mockito.doReturn(callContext).when(callContext).withTimeoutDuration(ArgumentMatchers.any());
    CheckingAttemptCallable<String, String> callable =
        new CheckingAttemptCallable<>(Mockito.mock(UnaryCallable.class), callContext);
    callable.setExternalFuture(mockExternalFuture);

    // Make sure that the rpc timeout is set
    java.time.Duration timeout = java.time.Duration.ofSeconds(10);
    currentAttemptSettings =
        currentAttemptSettings.toBuilder().setRpcTimeoutDuration(timeout).build();

    callable.call();

    verify(callContext).withTimeoutDuration(timeout);
  }
}
