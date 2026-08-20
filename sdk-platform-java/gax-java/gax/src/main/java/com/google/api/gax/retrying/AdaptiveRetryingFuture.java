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
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.tracing.ApiTracer;
import com.google.common.base.MoreObjects;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.time.Duration;
import java.util.concurrent.Callable;
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
 * For internal use only.
 *
 * <p>An implementation of {@link RetryingFuture} for {@link AdaptiveRetryingCallable} that supports
 * stateful request generation and asynchronous failure recovery via {@link AdaptiveAttemptHandler}.
 *
 * @param <ResponseT> response type
 */
@NullMarked
class AdaptiveRetryingFuture<ResponseT> extends AbstractFuture<ResponseT>
    implements RetryingFuture<ResponseT> {

  private final Object lock = new Object();

  private final AdaptiveAttemptHandler<ResponseT> handler;
  private final RetryAlgorithm<ResponseT> retryAlgorithm;
  private final ScheduledExecutorService scheduler;
  private final ApiCallContext callContext;

  private volatile TimedAttemptSettings attemptSettings;
  private volatile @Nullable Future<?> currentInFlightFuture;
  private volatile @Nullable ScheduledFuture<?> scheduledRetryFuture;
  private volatile @Nullable ApiFuture<ResponseT> latestCompletedAttemptResult;
  private volatile @Nullable ApiFuture<ResponseT> attemptResult;

  AdaptiveRetryingFuture(
      AdaptiveAttemptHandler<ResponseT> handler,
      RetryAlgorithm<ResponseT> retryAlgorithm,
      ScheduledExecutorService scheduler,
      ApiCallContext callContext) {
    this.handler = checkNotNull(handler);
    this.retryAlgorithm = checkNotNull(retryAlgorithm);
    this.scheduler = checkNotNull(scheduler);
    this.callContext = checkNotNull(callContext);
    this.attemptSettings = retryAlgorithm.createFirstAttempt(callContext);
  }

  /** Starts the first attempt. */
  void start() {
    dispatchAttempt();
  }

  @Override
  public Callable<ResponseT> getCallable() {
    throw new UnsupportedOperationException(
        "AdaptiveRetryingFuture executes attempts via AdaptiveAttemptHandler, not Callable");
  }

  @Override
  public void setAttemptFuture(ApiFuture<ResponseT> attemptFuture) {
    throw new UnsupportedOperationException(
        "AdaptiveRetryingFuture manages attempt execution internally");
  }

  @Override
  public TimedAttemptSettings getAttemptSettings() {
    synchronized (lock) {
      return attemptSettings;
    }
  }

  @Override
  public @Nullable ApiFuture<ResponseT> peekAttemptResult() {
    synchronized (lock) {
      return latestCompletedAttemptResult;
    }
  }

  @Override
  public ApiFuture<ResponseT> getAttemptResult() {
    synchronized (lock) {
      if (attemptResult == null) {
        attemptResult = new NonCancellableFuture<>();
      }
      return attemptResult;
    }
  }

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    ApiTracer tracer = callContext.getTracer();
    synchronized (lock) {
      if (isDone()) {
        return false;
      }
      boolean cancelled = super.cancel(mayInterruptIfRunning);
      if (currentInFlightFuture != null) {
        currentInFlightFuture.cancel(mayInterruptIfRunning);
      }
      if (scheduledRetryFuture != null) {
        scheduledRetryFuture.cancel(mayInterruptIfRunning);
      }
      tracer.attemptCancelled();
      setAttemptResult(new CancellationException("Operation was cancelled"), null, false);
      return cancelled;
    }
  }

  private void dispatchAttempt() {
    ApiCallContext attemptContext;
    TimedAttemptSettings settings;
    ApiTracer tracer = callContext.getTracer();

    synchronized (lock) {
      if (isDone()) {
        return;
      }
      scheduledRetryFuture = null;
      settings = attemptSettings;
      attemptContext = callContext;
      Duration rpcTimeout = settings.getRpcTimeoutDuration();
      if (!rpcTimeout.isZero() && attemptContext.getTimeoutDuration() == null) {
        attemptContext = attemptContext.withTimeoutDuration(rpcTimeout);
      }
      tracer.attemptStarted(null, settings.getOverallAttemptCount());
    }

    ApiFuture<ResponseT> attemptFuture;
    try {
      attemptFuture = handler.startAttempt(attemptContext);
    } catch (Throwable t) {
      handleAttemptFailure(t, attemptContext);
      return;
    }

    synchronized (lock) {
      if (isDone()) {
        attemptFuture.cancel(true);
        return;
      }
      currentInFlightFuture = attemptFuture;
      attemptFuture.addListener(
          new AttemptCompletionListener(attemptFuture, attemptContext),
          MoreExecutors.directExecutor());
    }
  }

  private void handleAttemptSuccess(@Nullable ResponseT response) {
    ApiTracer tracer = callContext.getTracer();
    synchronized (lock) {
      if (isDone()) {
        return;
      }
      currentInFlightFuture = null;
      setAttemptResult(null, response, false);
      tracer.attemptSucceeded();
      set(response);
    }
  }

  private void handleAttemptFailure(Throwable throwable, ApiCallContext attemptContext) {
    ApiTracer tracer = callContext.getTracer();

    synchronized (lock) {
      if (isDone()) {
        return;
      }
      currentInFlightFuture = null;

      if (throwable instanceof CancellationException) {
        tracer.attemptCancelled();
        setAttemptResult(throwable, null, false);
        super.cancel(false);
        return;
      } else if (throwable instanceof RejectedExecutionException) {
        tracer.attemptPermanentFailure(throwable);
        setAttemptResult(throwable, null, false);
        setException(throwable);
        return;
      }

      TimedAttemptSettings nextSettings =
          retryAlgorithm.createNextAttempt(callContext, throwable, null, attemptSettings);
      boolean shouldRetry = retryAlgorithm.shouldRetry(callContext, throwable, null, nextSettings);

      if (!shouldRetry) {
        setAttemptResult(throwable, null, false);
        if (retryAlgorithm.shouldRetryBasedOnResult(callContext, throwable, null)) {
          tracer.attemptFailedRetriesExhausted(throwable);
        } else {
          tracer.attemptPermanentFailure(throwable);
        }
        setException(throwable);
        return;
      }

      setAttemptResult(throwable, null, true);
    }

    ApiFuture<Boolean> recoveryFuture;
    try {
      recoveryFuture = handler.onAttemptFailure(throwable, attemptContext);
    } catch (Throwable recoveryError) {
      synchronized (lock) {
        if (!isDone()) {
          tracer.attemptPermanentFailure(recoveryError);
          setAttemptResult(recoveryError, null, false);
          setException(recoveryError);
        }
      }
      return;
    }

    synchronized (lock) {
      if (isDone()) {
        recoveryFuture.cancel(true);
        return;
      }
      currentInFlightFuture = recoveryFuture;
      recoveryFuture.addListener(
          () -> onRecoveryCompleted(recoveryFuture, throwable), MoreExecutors.directExecutor());
    }
  }

  private void onRecoveryCompleted(ApiFuture<Boolean> recoveryFuture, Throwable originalThrowable) {
    ApiTracer tracer = callContext.getTracer();
    synchronized (lock) {
      if (isDone()) {
        return;
      }
      currentInFlightFuture = null;

      try {
        Boolean canProceed = recoveryFuture.get();
        if (Boolean.TRUE.equals(canProceed)) {
          TimedAttemptSettings nextSettings =
              retryAlgorithm.createNextAttempt(
                  callContext, originalThrowable, null, attemptSettings);
          boolean shouldRetry =
              retryAlgorithm.shouldRetry(callContext, originalThrowable, null, nextSettings);

          if (shouldRetry) {
            this.attemptSettings = nextSettings;
            Duration delay = nextSettings.getRandomizedRetryDelayDuration();
            tracer.attemptFailedDuration(originalThrowable, delay);
            scheduledRetryFuture =
                scheduler.schedule(this::dispatchAttempt, delay.toMillis(), TimeUnit.MILLISECONDS);
          } else {
            if (retryAlgorithm.shouldRetryBasedOnResult(callContext, originalThrowable, null)) {
              tracer.attemptFailedRetriesExhausted(originalThrowable);
            } else {
              tracer.attemptPermanentFailure(originalThrowable);
            }
            setAttemptResult(originalThrowable, null, false);
            setException(originalThrowable);
          }
        } else {
          tracer.attemptPermanentFailure(originalThrowable);
          setAttemptResult(originalThrowable, null, false);
          setException(originalThrowable);
        }
      } catch (CancellationException e) {
        tracer.attemptCancelled();
        setAttemptResult(e, null, false);
        super.cancel(false);
      } catch (ExecutionException e) {
        Throwable cause = e.getCause() != null ? e.getCause() : e;
        if (cause instanceof CancellationException) {
          tracer.attemptCancelled();
          setAttemptResult(cause, null, false);
          super.cancel(false);
        } else {
          tracer.attemptPermanentFailure(cause);
          setAttemptResult(cause, null, false);
          setException(cause);
        }
      } catch (Throwable t) {
        if (t instanceof CancellationException) {
          tracer.attemptCancelled();
          setAttemptResult(t, null, false);
          super.cancel(false);
        } else {
          tracer.attemptPermanentFailure(t);
          setAttemptResult(t, null, false);
          setException(t);
        }
      }
    }
  }

  private void setAttemptResult(
      @Nullable Throwable throwable, @Nullable ResponseT response, boolean shouldRetry) {
    ApiFuture<ResponseT> prevAttemptResult = attemptResult;
    try {
      if (throwable instanceof CancellationException) {
        NonCancellableFuture<ResponseT> future = new NonCancellableFuture<>();
        future.cancelPrivately();
        latestCompletedAttemptResult = future;
        attemptResult = shouldRetry ? null : latestCompletedAttemptResult;
        if (prevAttemptResult instanceof NonCancellableFuture) {
          ((NonCancellableFuture<ResponseT>) prevAttemptResult).cancelPrivately();
        }
      } else if (throwable != null) {
        latestCompletedAttemptResult = ApiFutures.immediateFailedFuture(throwable);
        attemptResult = shouldRetry ? null : latestCompletedAttemptResult;
        if (prevAttemptResult instanceof NonCancellableFuture) {
          ((NonCancellableFuture<ResponseT>) prevAttemptResult).setExceptionPrivately(throwable);
        }
      } else {
        latestCompletedAttemptResult = ApiFutures.immediateFuture(response);
        attemptResult = shouldRetry ? null : latestCompletedAttemptResult;
        if (prevAttemptResult instanceof NonCancellableFuture) {
          ((NonCancellableFuture<ResponseT>) prevAttemptResult).setPrivately(response);
        }
      }
    } catch (Exception ignored) {
    }
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this.getClass())
        .add("super", pendingToString())
        .add("latestCompletedAttemptResult", this.latestCompletedAttemptResult)
        .add("attemptResult", this.attemptResult)
        .add("attemptSettings", this.attemptSettings)
        .toString();
  }

  private class AttemptCompletionListener implements Runnable {
    private final ApiFuture<ResponseT> attemptFuture;
    private final ApiCallContext attemptContext;

    AttemptCompletionListener(ApiFuture<ResponseT> attemptFuture, ApiCallContext attemptContext) {
      this.attemptFuture = attemptFuture;
      this.attemptContext = attemptContext;
    }

    @Override
    public void run() {
      try {
        ResponseT response = attemptFuture.get();
        handleAttemptSuccess(response);
      } catch (ExecutionException e) {
        handleAttemptFailure(e.getCause() != null ? e.getCause() : e, attemptContext);
      } catch (Throwable t) {
        handleAttemptFailure(t, attemptContext);
      }
    }
  }
}
