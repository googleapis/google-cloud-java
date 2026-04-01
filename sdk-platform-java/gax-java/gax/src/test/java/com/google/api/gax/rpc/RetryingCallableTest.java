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
package com.google.api.gax.rpc;

import static org.mockito.Mockito.when;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.RetryingExecutorWithContext;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.testing.FakeCallContext;
import java.util.concurrent.Callable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.threeten.bp.Duration;
import org.threeten.bp.temporal.ChronoUnit;

class RetryingCallableTest {
  @Test
  void futureCall() {
    FakeCallContext fakeCallContext = FakeCallContext.createDefault();
    UnaryCallable innerCallable = Mockito.mock(UnaryCallable.class);
    RetryingExecutorWithContext executor = Mockito.mock(RetryingExecutorWithContext.class);
    RetryingFuture retryingFuture = Mockito.mock(RetryingFuture.class);
    TimedAttemptSettings fakeAttemptSettings =
        TimedAttemptSettings.newBuilder()
            .setRpcTimeout(Duration.of(1, ChronoUnit.SECONDS))
            .setAttemptCount(3)
            .setGlobalSettings(RetrySettings.newBuilder().build())
            .setRetryDelay(Duration.of(1, ChronoUnit.SECONDS))
            .setRandomizedRetryDelay(Duration.of(1, ChronoUnit.SECONDS))
            .setFirstAttemptStartTimeNanos(5)
            .build();

    when(retryingFuture.getAttemptSettings()).thenReturn(fakeAttemptSettings);
    when(executor.createFuture(Mockito.any(Callable.class), Mockito.eq(fakeCallContext)))
        .thenReturn(retryingFuture);
    Integer modifiedRequest = 5;
    RequestMutator requestMutator = request -> modifiedRequest;
    RetryingCallable retryingCallable =
        new RetryingCallable<>(fakeCallContext, innerCallable, executor, requestMutator);

    retryingCallable.futureCall(1, fakeCallContext);
    Mockito.verify(innerCallable)
        .futureCall(Mockito.eq(modifiedRequest), Mockito.any(ApiCallContext.class));
  }
}
