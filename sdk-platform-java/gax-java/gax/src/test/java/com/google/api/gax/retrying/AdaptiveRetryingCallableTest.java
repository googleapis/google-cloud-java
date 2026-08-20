/*
 * Copyright 2026 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdaptiveRetryingCallableTest {

  private ScheduledExecutorService executor;
  private RetryAlgorithm<String> retryAlgorithm;

  @BeforeEach
  void setUp() {
    executor = Executors.newSingleThreadScheduledExecutor();
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(10))
            .setRetryDelayMultiplier(1.5)
            .setMaxRetryDelayDuration(Duration.ofMillis(50))
            .setTotalTimeoutDuration(Duration.ofSeconds(2))
            .build();
    retryAlgorithm =
        new RetryAlgorithm<>(
            new BasicResultRetryAlgorithm<String>() {
              @Override
              public boolean shouldRetry(Throwable previousThrowable, String previousResponse) {
                return previousThrowable instanceof DeadlineExceededException;
              }
            },
            new ExponentialRetryAlgorithm(retrySettings, com.google.api.core.NanoClock.getDefaultClock()));
  }

  @AfterEach
  void tearDown() {
    executor.shutdownNow();
  }

  @Test
  void testImmediateSuccess() throws Exception {
    AdaptiveRetryingCallable<String> callable =
        new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

    AdaptiveAttemptHandler<String> handler =
        new AdaptiveAttemptHandler<String>() {
          @Override
          public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
            return ApiFutures.immediateFuture("success");
          }

          @Override
          public ApiFuture<Boolean> onAttemptFailure(
              Throwable previousThrowable, ApiCallContext attemptContext) {
            return ApiFutures.immediateFuture(false);
          }
        };

    RetryingFuture<String> future = callable.futureCall(handler, FakeCallContext.createDefault());
    assertThat(future.get()).isEqualTo("success");
    assertThat(future.isDone()).isTrue();
  }

  @Test
  void testRetryWithRecovery() throws Exception {
    AdaptiveRetryingCallable<String> callable =
        new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

    AtomicInteger attemptCount = new AtomicInteger(0);
    AtomicInteger recoveryCount = new AtomicInteger(0);

    AdaptiveAttemptHandler<String> handler =
        new AdaptiveAttemptHandler<String>() {
          @Override
          public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
            int attempt = attemptCount.incrementAndGet();
            if (attempt == 1) {
              return ApiFutures.immediateFailedFuture(
                  new DeadlineExceededException(
                      "timeout", null, FakeStatusCode.of(StatusCode.Code.DEADLINE_EXCEEDED), true));
            }
            return ApiFutures.immediateFuture("recovered-success");
          }

          @Override
          public ApiFuture<Boolean> onAttemptFailure(
              Throwable previousThrowable, ApiCallContext attemptContext) {
            recoveryCount.incrementAndGet();
            return ApiFutures.immediateFuture(true); // Recovery succeeded, proceed to retry
          }
        };

    RetryingFuture<String> future = callable.futureCall(handler, FakeCallContext.createDefault());
    assertThat(future.get()).isEqualTo("recovered-success");
    assertThat(attemptCount.get()).isEqualTo(2);
    assertThat(recoveryCount.get()).isEqualTo(1);
  }

  @Test
  void testNonRetryableFailure() {
    AdaptiveRetryingCallable<String> callable =
        new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

    AdaptiveAttemptHandler<String> handler =
        new AdaptiveAttemptHandler<String>() {
          @Override
          public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
            return ApiFutures.immediateFailedFuture(
                new NotFoundException(
                    "not found", null, FakeStatusCode.of(StatusCode.Code.NOT_FOUND), false));
          }

          @Override
          public ApiFuture<Boolean> onAttemptFailure(
              Throwable previousThrowable, ApiCallContext attemptContext) {
            return ApiFutures.immediateFuture(true);
          }
        };

    RetryingFuture<String> future = callable.futureCall(handler, FakeCallContext.createDefault());
    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(NotFoundException.class);
  }

  @Test
  void testCancellation() {
    AdaptiveRetryingCallable<String> callable =
        new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

    AdaptiveAttemptHandler<String> handler =
        new AdaptiveAttemptHandler<String>() {
          @Override
          public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
            return com.google.api.core.SettableApiFuture.create(); // Never completes
          }

          @Override
          public ApiFuture<Boolean> onAttemptFailure(
              Throwable previousThrowable, ApiCallContext attemptContext) {
            return ApiFutures.immediateFuture(false);
          }
        };

    RetryingFuture<String> future = callable.futureCall(handler, FakeCallContext.createDefault());
    assertThat(future.cancel(true)).isTrue();
    assertThat(future.isCancelled()).isTrue();
  }
}
