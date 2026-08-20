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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.tracing.ApiTracer;
import com.google.common.util.concurrent.MoreExecutors;
import java.time.Duration;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * An implementation of {@link RetryingFuture} for {@link AdaptiveRetryingCallable} that supports
 * stateful request generation and asynchronous failure recovery via {@link AdaptiveAttemptHandler}.
 *
 * @param <ResponseT> response type
 */
@BetaApi
@NullMarked
public class AdaptiveRetryingFuture<ResponseT> extends BasicRetryingFuture<ResponseT> {

  private final AdaptiveAttemptHandler<ResponseT> handler;
  private final ScheduledExecutorService scheduler;
  private final ApiCallContext callContext;

  private volatile @Nullable Future<?> currentInFlightFuture;
  private volatile @Nullable ScheduledFuture<?> scheduledRetryFuture;

  private final RetryAlgorithm<ResponseT> retryAlgorithm;
  private final RetryingContext retryingContext;

  AdaptiveRetryingFuture(
      AdaptiveAttemptHandler<ResponseT> handler,
      RetryAlgorithm<ResponseT> retryAlgorithm,
      ScheduledExecutorService scheduler,
      RetryingContext retryingContext,
      ApiCallContext callContext) {
    super(() -> null, retryAlgorithm, retryingContext);
    this.handler = checkNotNull(handler);
    this.retryAlgorithm = checkNotNull(retryAlgorithm);
    this.scheduler = checkNotNull(scheduler);
    this.retryingContext = checkNotNull(retryingContext);
    this.callContext = checkNotNull(callContext);
  }

  /** Starts the first attempt. */
  public void start() {
    dispatchAttempt();
  }

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    synchronized (lock) {
      if (currentInFlightFuture != null) {
        currentInFlightFuture.cancel(mayInterruptIfRunning);
      }
      if (scheduledRetryFuture != null) {
        scheduledRetryFuture.cancel(mayInterruptIfRunning);
      }
      super.cancel(mayInterruptIfRunning);
      return isCancelled();
    }
  }

  private void dispatchAttempt() {
    synchronized (lock) {
      if (isDone()) {
        return;
      }

      TimedAttemptSettings settings = getAttemptSettings();
      ApiCallContext attemptContext = callContext;
      Duration rpcTimeout = settings.getRpcTimeoutDuration();
      if (!rpcTimeout.isZero() && attemptContext.getTimeoutDuration() == null) {
        attemptContext = attemptContext.withTimeoutDuration(rpcTimeout);
      }

      ApiTracer tracer = callContext.getTracer();
      tracer.attemptStarted(null, settings.getOverallAttemptCount());

      try {
        ApiFuture<ResponseT> attemptFuture = handler.startAttempt(attemptContext);
        currentInFlightFuture = attemptFuture;
        attemptFuture.addListener(
            new AttemptCompletionListener(attemptFuture, attemptContext),
            MoreExecutors.directExecutor());
      } catch (Throwable t) {
        handleAttemptFailure(t, attemptContext);
      }
    }
  }

  private void handleAttemptFailure(Throwable throwable, ApiCallContext attemptContext) {
    ApiTracer tracer = callContext.getTracer();

    synchronized (lock) {
      if (isDone()) {
        return;
      }

      if (throwable instanceof CancellationException) {
        tracer.attemptCancelled();
        cancel(false);
        return;
      } else if (throwable instanceof RejectedExecutionException) {
        tracer.attemptPermanentFailure(throwable);
        setException(throwable);
        return;
      }

      TimedAttemptSettings currentSettings = getAttemptSettings();
      TimedAttemptSettings nextAttemptSettings =
          createNextAttemptSettings(throwable, currentSettings);
      boolean shouldRetry = shouldRetryAttempt(throwable, nextAttemptSettings);

      if (!shouldRetry) {
        handleAttempt(throwable, null);
        return;
      }

      // Execute recovery step via handler
      try {
        ApiFuture<Boolean> recoveryFuture = handler.onAttemptFailure(throwable, attemptContext);
        currentInFlightFuture = recoveryFuture;
        recoveryFuture.addListener(
            () -> onRecoveryCompleted(recoveryFuture, throwable, nextAttemptSettings),
            MoreExecutors.directExecutor());
      } catch (Throwable recoveryError) {
        tracer.attemptPermanentFailure(recoveryError);
        setException(recoveryError);
      }
    }
  }

  private void onRecoveryCompleted(
      ApiFuture<Boolean> recoveryFuture,
      Throwable originalThrowable,
      TimedAttemptSettings nextAttemptSettings) {
    synchronized (lock) {
      if (isDone()) {
        return;
      }

      try {
        Boolean canProceed = recoveryFuture.get();
        if (Boolean.TRUE.equals(canProceed)) {
          // Recovery successful; update attempt settings and schedule retry with backoff
          handleAttempt(originalThrowable, null);
          if (!isDone()) {
            Duration delay = nextAttemptSettings.getRandomizedRetryDelayDuration();
            scheduledRetryFuture =
                scheduler.schedule(
                    this::dispatchAttempt, delay.toMillis(), TimeUnit.MILLISECONDS);
          }
        } else {
          // Recovery returned false; operation was completed by recovery or is unrecoverable
          if (!isDone()) {
            handleAttempt(originalThrowable, null);
          }
        }
      } catch (ExecutionException e) {
        handleAttempt(e.getCause() != null ? e.getCause() : e, null);
      } catch (Throwable t) {
        handleAttempt(t, null);
      }
    }
  }

  private TimedAttemptSettings createNextAttemptSettings(
      Throwable throwable, TimedAttemptSettings settings) {
    return retryAlgorithm.createNextAttempt(retryingContext, throwable, null, settings);
  }

  private boolean shouldRetryAttempt(Throwable throwable, TimedAttemptSettings nextSettings) {
    return retryAlgorithm.shouldRetry(retryingContext, throwable, null, nextSettings);
  }

  private class AttemptCompletionListener implements Runnable {
    private final ApiFuture<ResponseT> attemptFuture;
    private final ApiCallContext attemptContext;

    AttemptCompletionListener(
        ApiFuture<ResponseT> attemptFuture, ApiCallContext attemptContext) {
      this.attemptFuture = attemptFuture;
      this.attemptContext = attemptContext;
    }

    @Override
    public void run() {
      try {
        ResponseT response = attemptFuture.get();
        handleAttempt(null, response);
      } catch (ExecutionException e) {
        handleAttemptFailure(e.getCause() != null ? e.getCause() : e, attemptContext);
      } catch (Throwable t) {
        handleAttemptFailure(t, attemptContext);
      }
    }
  }
}
