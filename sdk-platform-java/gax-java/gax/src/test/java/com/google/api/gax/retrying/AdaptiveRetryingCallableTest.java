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
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.NanoClock;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
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
            new ExponentialRetryAlgorithm(retrySettings, NanoClock.getDefaultClock()));
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
            return SettableApiFuture.create(); // Never completes
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

  @Test
  void testRecoveryReturnsFalseFailsWithOriginalException() {
    AdaptiveRetryingCallable<String> callable =
        new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

    AdaptiveAttemptHandler<String> handler =
        new AdaptiveAttemptHandler<String>() {
          @Override
          public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
            return ApiFutures.immediateFailedFuture(
                new DeadlineExceededException(
                    "attempt-failed",
                    null,
                    FakeStatusCode.of(StatusCode.Code.DEADLINE_EXCEEDED),
                    true));
          }

          @Override
          public ApiFuture<Boolean> onAttemptFailure(
              Throwable previousThrowable, ApiCallContext attemptContext) {
            return ApiFutures.immediateFuture(false); // Recovery determined unrecoverable
          }
        };

    RetryingFuture<String> future = callable.futureCall(handler, FakeCallContext.createDefault());
    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(DeadlineExceededException.class);
    assertThat(exception.getCause()).hasMessageThat().contains("attempt-failed");
  }

  @Test
  void testRecoveryFailsWithExceptionPropagatesRecoveryError() {
    AdaptiveRetryingCallable<String> callable =
        new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

    AdaptiveAttemptHandler<String> handler =
        new AdaptiveAttemptHandler<String>() {
          @Override
          public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
            return ApiFutures.immediateFailedFuture(
                new DeadlineExceededException(
                    "timeout", null, FakeStatusCode.of(StatusCode.Code.DEADLINE_EXCEEDED), true));
          }

          @Override
          public ApiFuture<Boolean> onAttemptFailure(
              Throwable previousThrowable, ApiCallContext attemptContext) {
            return ApiFutures.immediateFailedFuture(new IllegalStateException("recovery-failed"));
          }
        };

    RetryingFuture<String> future = callable.futureCall(handler, FakeCallContext.createDefault());
    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(IllegalStateException.class);
    assertThat(exception.getCause()).hasMessageThat().contains("recovery-failed");
  }

  @Test
  void testRecoveryThrowsSynchronouslyFailsFuture() {
    AdaptiveRetryingCallable<String> callable =
        new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

    AdaptiveAttemptHandler<String> handler =
        new AdaptiveAttemptHandler<String>() {
          @Override
          public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
            return ApiFutures.immediateFailedFuture(
                new DeadlineExceededException(
                    "timeout", null, FakeStatusCode.of(StatusCode.Code.DEADLINE_EXCEEDED), true));
          }

          @Override
          public ApiFuture<Boolean> onAttemptFailure(
              Throwable previousThrowable, ApiCallContext attemptContext) {
            throw new RuntimeException("synchronous-recovery-crash");
          }
        };

    RetryingFuture<String> future = callable.futureCall(handler, FakeCallContext.createDefault());
    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(RuntimeException.class);
    assertThat(exception.getCause()).hasMessageThat().contains("synchronous-recovery-crash");
  }

  @Test
  void testStartAttemptThrowsSynchronouslyTriggersRetry() throws Exception {
    AdaptiveRetryingCallable<String> callable =
        new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

    AtomicInteger attemptCount = new AtomicInteger(0);

    AdaptiveAttemptHandler<String> handler =
        new AdaptiveAttemptHandler<String>() {
          @Override
          public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
            int attempt = attemptCount.incrementAndGet();
            if (attempt == 1) {
              throw new DeadlineExceededException(
                  "sync-timeout", null, FakeStatusCode.of(StatusCode.Code.DEADLINE_EXCEEDED), true);
            }
            return ApiFutures.immediateFuture("success-after-sync-throw");
          }

          @Override
          public ApiFuture<Boolean> onAttemptFailure(
              Throwable previousThrowable, ApiCallContext attemptContext) {
            return ApiFutures.immediateFuture(true);
          }
        };

    RetryingFuture<String> future = callable.futureCall(handler, FakeCallContext.createDefault());
    assertThat(future.get()).isEqualTo("success-after-sync-throw");
    assertThat(attemptCount.get()).isEqualTo(2);
  }

  @Test
  void testRetriesExhausted() {
    RetrySettings maxAttemptsSettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(10))
            .setRetryDelayMultiplier(1.5)
            .setMaxRetryDelayDuration(Duration.ofMillis(50))
            .setTotalTimeoutDuration(Duration.ofSeconds(2))
            .setMaxAttempts(3)
            .build();
    RetryAlgorithm<String> boundedAlgorithm =
        new RetryAlgorithm<>(
            new BasicResultRetryAlgorithm<String>() {
              @Override
              public boolean shouldRetry(Throwable previousThrowable, String previousResponse) {
                return previousThrowable instanceof DeadlineExceededException;
              }
            },
            new ExponentialRetryAlgorithm(maxAttemptsSettings, NanoClock.getDefaultClock()));

    AdaptiveRetryingCallable<String> callable =
        new AdaptiveRetryingCallable<>(boundedAlgorithm, executor);

    AtomicInteger attemptCount = new AtomicInteger(0);
    AtomicInteger recoveryCount = new AtomicInteger(0);

    AdaptiveAttemptHandler<String> handler =
        new AdaptiveAttemptHandler<String>() {
          @Override
          public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
            attemptCount.incrementAndGet();
            return ApiFutures.immediateFailedFuture(
                new DeadlineExceededException(
                    "persistent-timeout",
                    null,
                    FakeStatusCode.of(StatusCode.Code.DEADLINE_EXCEEDED),
                    true));
          }

          @Override
          public ApiFuture<Boolean> onAttemptFailure(
              Throwable previousThrowable, ApiCallContext attemptContext) {
            recoveryCount.incrementAndGet();
            return ApiFutures.immediateFuture(true);
          }
        };

    RetryingFuture<String> future = callable.futureCall(handler, FakeCallContext.createDefault());
    ExecutionException exception = assertThrows(ExecutionException.class, future::get);
    assertThat(exception.getCause()).isInstanceOf(DeadlineExceededException.class);
    assertThat(attemptCount.get()).isEqualTo(3);
    assertThat(recoveryCount.get()).isEqualTo(2);
  }

  @Test
  void testCancellationDuringRecovery() {
    AdaptiveRetryingCallable<String> callable =
        new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

    SettableApiFuture<Boolean> recoveryFuture = SettableApiFuture.create();

    AdaptiveAttemptHandler<String> handler =
        new AdaptiveAttemptHandler<String>() {
          @Override
          public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
            return ApiFutures.immediateFailedFuture(
                new DeadlineExceededException(
                    "timeout", null, FakeStatusCode.of(StatusCode.Code.DEADLINE_EXCEEDED), true));
          }

          @Override
          public ApiFuture<Boolean> onAttemptFailure(
              Throwable previousThrowable, ApiCallContext attemptContext) {
            return recoveryFuture; // In-flight recovery that does not complete immediately
          }
        };

    RetryingFuture<String> future = callable.futureCall(handler, FakeCallContext.createDefault());
    assertThat(future.cancel(true)).isTrue();
    assertThat(future.isCancelled()).isTrue();
    assertThat(recoveryFuture.isCancelled()).isTrue();
  }

  @Test
  void testCancellationDuringBackoffDelay() throws Exception {
    RetrySettings longDelaySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofSeconds(10))
            .setMaxRetryDelayDuration(Duration.ofSeconds(10))
            .setTotalTimeoutDuration(Duration.ofMinutes(1))
            .build();
    RetryAlgorithm<String> longDelayAlgorithm =
        new RetryAlgorithm<>(
            new BasicResultRetryAlgorithm<String>() {
              @Override
              public boolean shouldRetry(Throwable previousThrowable, String previousResponse) {
                return previousThrowable instanceof DeadlineExceededException;
              }
            },
            new ExponentialRetryAlgorithm(longDelaySettings, NanoClock.getDefaultClock()));

    AdaptiveRetryingCallable<String> callable =
        new AdaptiveRetryingCallable<>(longDelayAlgorithm, executor);

    AtomicInteger attemptCount = new AtomicInteger(0);
    CountDownLatch recoveryCompletedLatch = new CountDownLatch(1);

    AdaptiveAttemptHandler<String> handler =
        new AdaptiveAttemptHandler<String>() {
          @Override
          public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
            attemptCount.incrementAndGet();
            return ApiFutures.immediateFailedFuture(
                new DeadlineExceededException(
                    "timeout", null, FakeStatusCode.of(StatusCode.Code.DEADLINE_EXCEEDED), true));
          }

          @Override
          public ApiFuture<Boolean> onAttemptFailure(
              Throwable previousThrowable, ApiCallContext attemptContext) {
            recoveryCompletedLatch.countDown();
            return ApiFutures.immediateFuture(true);
          }
        };

    RetryingFuture<String> future = callable.futureCall(handler, FakeCallContext.createDefault());
    assertThat(recoveryCompletedLatch.await(5, TimeUnit.SECONDS)).isTrue();

    // Now in backoff delay sleep; cancel it
    assertThat(future.cancel(true)).isTrue();
    assertThat(future.isCancelled()).isTrue();

    // Ensure attempt 2 is never dispatched
    await()
        .during(Duration.ofMillis(200))
        .atMost(Duration.ofMillis(500))
        .until(() -> attemptCount.get() == 1);
  }

  @Test
  void testRpcTimeoutInjectedIntoCallContext() throws Exception {
    RetrySettings timeoutSettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(10))
            .setMaxRetryDelayDuration(Duration.ofMillis(50))
            .setInitialRpcTimeoutDuration(Duration.ofSeconds(7))
            .setMaxRpcTimeoutDuration(Duration.ofSeconds(7))
            .setTotalTimeoutDuration(Duration.ofMinutes(1))
            .build();
    RetryAlgorithm<String> timeoutAlgorithm =
        new RetryAlgorithm<>(
            new BasicResultRetryAlgorithm<String>(),
            new ExponentialRetryAlgorithm(timeoutSettings, NanoClock.getDefaultClock()));

    AdaptiveRetryingCallable<String> callable =
        new AdaptiveRetryingCallable<>(timeoutAlgorithm, executor);

    AtomicReference<Duration> capturedTimeout = new AtomicReference<>();

    AdaptiveAttemptHandler<String> handler =
        new AdaptiveAttemptHandler<String>() {
          @Override
          public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
            capturedTimeout.set(attemptContext.getTimeoutDuration());
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
    assertThat(capturedTimeout.get()).isEqualTo(Duration.ofSeconds(7));
  }

  @Test
  void testAsyncAttemptAndRecoveryCompletionAcrossThreads() throws Exception {
    ExecutorService backgroundWorker = Executors.newFixedThreadPool(4);
    try {
      AdaptiveRetryingCallable<String> callable =
          new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

      AtomicInteger attemptCount = new AtomicInteger(0);
      AtomicInteger recoveryCount = new AtomicInteger(0);

      AdaptiveAttemptHandler<String> handler =
          new AdaptiveAttemptHandler<String>() {
            @Override
            public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
              int attempt = attemptCount.incrementAndGet();
              SettableApiFuture<String> attemptFuture = SettableApiFuture.create();
              backgroundWorker.submit(
                  () -> {
                    if (attempt == 1) {
                      attemptFuture.setException(
                          new DeadlineExceededException(
                              "async-timeout",
                              null,
                              FakeStatusCode.of(StatusCode.Code.DEADLINE_EXCEEDED),
                              true));
                    } else {
                      attemptFuture.set("recovered-async-success");
                    }
                  });
              return attemptFuture;
            }

            @Override
            public ApiFuture<Boolean> onAttemptFailure(
                Throwable previousThrowable, ApiCallContext attemptContext) {
              recoveryCount.incrementAndGet();
              SettableApiFuture<Boolean> recoveryFuture = SettableApiFuture.create();
              backgroundWorker.submit(() -> recoveryFuture.set(true));
              return recoveryFuture;
            }
          };

      RetryingFuture<String> future = callable.futureCall(handler, FakeCallContext.createDefault());
      assertThat(future.get(5, TimeUnit.SECONDS)).isEqualTo("recovered-async-success");
      assertThat(attemptCount.get()).isEqualTo(2);
      assertThat(recoveryCount.get()).isEqualTo(1);
    } finally {
      backgroundWorker.shutdownNow();
    }
  }

  @Test
  void testMultiThreadedScheduledExecutor() throws Exception {
    ScheduledExecutorService multiThreadedScheduler = Executors.newScheduledThreadPool(4);
    try {
      AdaptiveRetryingCallable<String> callable =
          new AdaptiveRetryingCallable<>(retryAlgorithm, multiThreadedScheduler);

      AtomicInteger attemptCount = new AtomicInteger(0);
      Set<String> threadNames = ConcurrentHashMap.newKeySet();

      AdaptiveAttemptHandler<String> handler =
          new AdaptiveAttemptHandler<String>() {
            @Override
            public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
              threadNames.add(Thread.currentThread().getName());
              int attempt = attemptCount.incrementAndGet();
              if (attempt < 3) {
                return ApiFutures.immediateFailedFuture(
                    new DeadlineExceededException(
                        "timeout-" + attempt,
                        null,
                        FakeStatusCode.of(StatusCode.Code.DEADLINE_EXCEEDED),
                        true));
              }
              return ApiFutures.immediateFuture("multi-threaded-success");
            }

            @Override
            public ApiFuture<Boolean> onAttemptFailure(
                Throwable previousThrowable, ApiCallContext attemptContext) {
              return ApiFutures.immediateFuture(true);
            }
          };

      RetryingFuture<String> future = callable.futureCall(handler, FakeCallContext.createDefault());
      assertThat(future.get(5, TimeUnit.SECONDS)).isEqualTo("multi-threaded-success");
      assertThat(attemptCount.get()).isEqualTo(3);
    } finally {
      multiThreadedScheduler.shutdownNow();
    }
  }

  @Test
  void testConcurrentCancellationRacingWithAttemptCompletion() throws Exception {
    ExecutorService raceExecutor = Executors.newFixedThreadPool(8);
    try {
      for (int i = 0; i < 50; i++) {
        AdaptiveRetryingCallable<String> callable =
            new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

        SettableApiFuture<String> attemptFuture = SettableApiFuture.create();
        AdaptiveAttemptHandler<String> handler =
            new AdaptiveAttemptHandler<String>() {
              @Override
              public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
                return attemptFuture;
              }

              @Override
              public ApiFuture<Boolean> onAttemptFailure(
                  Throwable previousThrowable, ApiCallContext attemptContext) {
                return ApiFutures.immediateFuture(false);
              }
            };

        RetryingFuture<String> future =
            callable.futureCall(handler, FakeCallContext.createDefault());

        CyclicBarrier barrier = new CyclicBarrier(2);
        raceExecutor.submit(
            () -> {
              try {
                barrier.await();
                future.cancel(true);
              } catch (Exception ignored) {
              }
            });
        raceExecutor.submit(
            () -> {
              try {
                barrier.await();
                attemptFuture.set("completed-result");
              } catch (Exception ignored) {
              }
            });

        try {
          String result = future.get(5, TimeUnit.SECONDS);
          assertThat(result).isEqualTo("completed-result");
          assertThat(future.isDone()).isTrue();
        } catch (CancellationException e) {
          assertThat(future.isCancelled()).isTrue();
          assertThat(future.isDone()).isTrue();
        }
      }
    } finally {
      raceExecutor.shutdownNow();
    }
  }

  @Test
  void testConcurrentCancellationRacingWithRecoveryCompletion() throws Exception {
    ExecutorService raceExecutor = Executors.newFixedThreadPool(8);
    try {
      for (int i = 0; i < 50; i++) {
        AdaptiveRetryingCallable<String> callable =
            new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

        SettableApiFuture<Boolean> recoveryFuture = SettableApiFuture.create();
        AdaptiveAttemptHandler<String> handler =
            new AdaptiveAttemptHandler<String>() {
              @Override
              public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
                return ApiFutures.immediateFailedFuture(
                    new DeadlineExceededException(
                        "timeout",
                        null,
                        FakeStatusCode.of(StatusCode.Code.DEADLINE_EXCEEDED),
                        true));
              }

              @Override
              public ApiFuture<Boolean> onAttemptFailure(
                  Throwable previousThrowable, ApiCallContext attemptContext) {
                return recoveryFuture;
              }
            };

        RetryingFuture<String> future =
            callable.futureCall(handler, FakeCallContext.createDefault());

        CyclicBarrier barrier = new CyclicBarrier(2);
        raceExecutor.submit(
            () -> {
              try {
                barrier.await();
                future.cancel(true);
              } catch (Exception ignored) {
              }
            });
        raceExecutor.submit(
            () -> {
              try {
                barrier.await();
                recoveryFuture.set(false);
              } catch (Exception ignored) {
              }
            });

        try {
          future.get(5, TimeUnit.SECONDS);
        } catch (CancellationException e) {
          assertThat(future.isCancelled()).isTrue();
        } catch (ExecutionException e) {
          assertThat(e.getCause()).isInstanceOf(DeadlineExceededException.class);
        }
        assertThat(future.isDone()).isTrue();
      }
    } finally {
      raceExecutor.shutdownNow();
    }
  }

  @Test
  void testConcurrentAccessorsWhileRetrying() throws Exception {
    ExecutorService readerPool = Executors.newFixedThreadPool(4);
    try {
      AdaptiveRetryingCallable<String> callable =
          new AdaptiveRetryingCallable<>(retryAlgorithm, executor);

      AtomicInteger attemptCount = new AtomicInteger(0);
      AdaptiveAttemptHandler<String> handler =
          new AdaptiveAttemptHandler<String>() {
            @Override
            public ApiFuture<String> startAttempt(ApiCallContext attemptContext) {
              int attempt = attemptCount.incrementAndGet();
              if (attempt < 4) {
                return ApiFutures.immediateFailedFuture(
                    new DeadlineExceededException(
                        "timeout-" + attempt,
                        null,
                        FakeStatusCode.of(StatusCode.Code.DEADLINE_EXCEEDED),
                        true));
              }
              return ApiFutures.immediateFuture("eventual-success");
            }

            @Override
            public ApiFuture<Boolean> onAttemptFailure(
                Throwable previousThrowable, ApiCallContext attemptContext) {
              return ApiFutures.immediateFuture(true);
            }
          };

      RetryingFuture<String> future = callable.futureCall(handler, FakeCallContext.createDefault());

      AtomicBoolean running = new AtomicBoolean(true);
      for (int i = 0; i < 4; i++) {
        readerPool.submit(
            () -> {
              while (running.get()) {
                future.getAttemptSettings();
                future.peekAttemptResult();
                future.isDone();
                future.isCancelled();
              }
            });
      }

      assertThat(future.get(5, TimeUnit.SECONDS)).isEqualTo("eventual-success");
      running.set(false);
      assertThat(attemptCount.get()).isEqualTo(4);
    } finally {
      readerPool.shutdownNow();
    }
  }
}
