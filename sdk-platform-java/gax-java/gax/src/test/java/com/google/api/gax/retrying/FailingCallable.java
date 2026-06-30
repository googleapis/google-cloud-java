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
package com.google.api.gax.retrying;

import com.google.api.gax.tracing.ApiTracer;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class FailingCallable implements Callable<String> {
  static final RetrySettings FAST_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setMaxAttempts(6)
          .setInitialRetryDelayDuration(java.time.Duration.ofMillis(8L))
          .setRetryDelayMultiplier(1)
          .setMaxRetryDelayDuration(java.time.Duration.ofMillis(8L))
          .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(8L))
          .setRpcTimeoutMultiplier(1)
          .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(8L))
          .setTotalTimeoutDuration(java.time.Duration.ofMillis(400L))
          .build();
  static final RetrySettings FAILING_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setMaxAttempts(2)
          .setInitialRetryDelayDuration(java.time.Duration.ofNanos(1L))
          .setRetryDelayMultiplier(1)
          .setMaxRetryDelayDuration(java.time.Duration.ofNanos(1L))
          .setInitialRpcTimeoutDuration(java.time.Duration.ofNanos(1L))
          .setRpcTimeoutMultiplier(1)
          .setMaxRpcTimeoutDuration(java.time.Duration.ofNanos(1L))
          .setTotalTimeoutDuration(java.time.Duration.ofNanos(1L))
          .build();

  private AtomicInteger attemptsCount = new AtomicInteger(0);
  private final ApiTracer tracer;
  private final int expectedFailuresCount;
  private final String request;
  private final String result;
  private final CountDownLatch firstAttemptFinished = new CountDownLatch(1);

  private volatile RetryingFuture<String> externalFuture;

  FailingCallable(int expectedFailuresCount, String request, String result, ApiTracer tracer) {
    this.request = request;
    this.tracer = tracer;
    this.expectedFailuresCount = expectedFailuresCount;
    this.result = result;
  }

  // ExternalFuture should always be passed in when using the FailingCallable
  // to accurately mimic the behavior of AttemptCallable. We use the external
  // future to check that the future is done and that none of the callable's
  // logic is run.
  void setExternalFuture(RetryingFuture<String> externalFuture) {
    this.externalFuture = Preconditions.checkNotNull(externalFuture);
  }

  CountDownLatch getFirstAttemptFinishedLatch() {
    return firstAttemptFinished;
  }

  @Override
  public String call() throws Exception {
    try {
      // Assumption is that externalFuture is always passed in.
      // No null check to confirm so that the test will fail if
      // the externalFuture is not passed in
      if (externalFuture.isDone()) {
        return null;
      }
      int attemptNumber = attemptsCount.getAndIncrement();

      tracer.attemptStarted(request, attemptNumber);

      if (attemptNumber < expectedFailuresCount) {
        throw new CustomException();
      }

      return result;
    } finally {
      firstAttemptFinished.countDown();
    }
  }

  static class CustomException extends RuntimeException {

    private static final long serialVersionUID = -1543459008653697004L;
  }
}
