/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage;

import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.cloud.storage.Backoff.BackoffDuration;
import com.google.cloud.storage.Backoff.BackoffResult;
import com.google.cloud.storage.Backoff.BackoffResults;
import com.google.cloud.storage.Backoff.Jitterer;
import com.google.cloud.storage.Retrying.RetryingDependencies;
import com.google.common.annotations.VisibleForTesting;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.qual.Nullable;

@SuppressWarnings("SizeReplaceableByIsEmpty") // allow elimination of a method call and a negation
final class DefaultRetryContext implements RetryContext {
  private final ScheduledExecutorService scheduledExecutorService;
  private final RetryingDependencies retryingDependencies;
  private final ResultRetryAlgorithm<?> algorithm;
  private final Backoff backoff;
  private final ReentrantLock lock;

  private List<Throwable> failures;
  private long lastReset;
  private long lastRecordedErrorNs;
  @Nullable private BackoffResult lastBackoffResult;
  @Nullable private ScheduledFuture<?> pendingBackoff;

  DefaultRetryContext(
      ScheduledExecutorService scheduledExecutorService,
      RetryingDependencies retryingDependencies,
      ResultRetryAlgorithm<?> algorithm,
      Jitterer jitterer) {
    this.scheduledExecutorService = scheduledExecutorService;
    this.retryingDependencies = retryingDependencies;
    this.algorithm = algorithm;
    this.backoff =
        Backoff.from(retryingDependencies.getRetrySettings()).setJitterer(jitterer).build();
    this.lock = new ReentrantLock();
    this.failures = new LinkedList<>();
    this.lastReset = retryingDependencies.getClock().nanoTime();
    this.lastRecordedErrorNs = this.lastReset;
    this.lastBackoffResult = null;
    this.pendingBackoff = null;
  }

  @Override
  public boolean inBackoff() {
    lock.lock();
    boolean b = pendingBackoff != null;
    try {
      return b;
    } finally {
      lock.unlock();
    }
  }

  @Override
  public void reset() {
    lock.lock();
    try {
      if (failures.size() > 0) {
        failures = new LinkedList<>();
      }
      long now = retryingDependencies.getClock().nanoTime();
      lastReset = now;
      lastRecordedErrorNs = now;
      clearPendingBackoff();
      backoff.reset();
    } finally {
      lock.unlock();
    }
  }

  @VisibleForTesting
  void awaitBackoffComplete() {
    while (inBackoff()) {
      Thread.yield();
    }
  }

  @Override
  public <T extends Throwable> void recordError(T t, OnSuccess onSuccess, OnFailure<T> onFailure) {
    lock.lock();
    try {
      long now = retryingDependencies.getClock().nanoTime();
      Duration elapsed = Duration.ofNanos(now - lastReset);
      Duration elapsedSinceLastRecordError = Duration.ofNanos(now - lastRecordedErrorNs);
      if (pendingBackoff != null && pendingBackoff.isDone()) {
        pendingBackoff = null;
        lastBackoffResult = null;
      } else if (pendingBackoff != null) {
        pendingBackoff.cancel(true);
        String message =
            String.format(
                "Previous backoff interrupted by this error (previousBackoff: %s, elapsed: %s)",
                lastBackoffResult != null ? lastBackoffResult.errorString() : null, elapsed);
        t.addSuppressed(BackoffComment.of(message));
      }
      int failureCount = failures.size() + 1 /* include t in the count*/;
      int maxAttempts = retryingDependencies.getRetrySettings().getMaxAttempts();
      if (maxAttempts <= 0) {
        maxAttempts = Integer.MAX_VALUE;
      }
      boolean shouldRetry = algorithm.shouldRetry(t, null);
      BackoffResult nextBackoff = backoff.nextBackoff(elapsedSinceLastRecordError);
      String msgPrefix = null;
      if (shouldRetry && failureCount >= maxAttempts) {
        msgPrefix = "Operation failed to complete within attempt budget";
      } else if (nextBackoff == BackoffResults.EXHAUSTED) {
        msgPrefix = "Operation failed to complete within backoff budget";
      } else if (!shouldRetry) {
        msgPrefix = "Unretryable error";
      }

      lastRecordedErrorNs = now;
      if (msgPrefix == null) {
        t.addSuppressed(BackoffComment.fromResult(nextBackoff));
        failures.add(t);

        BackoffDuration backoffDuration = (BackoffDuration) nextBackoff;

        lastBackoffResult = nextBackoff;
        try {
          pendingBackoff =
              scheduledExecutorService.schedule(
                  () -> {
                    try {
                      onSuccess.onSuccess();
                    } finally {
                      clearPendingBackoff();
                    }
                  },
                  backoffDuration.getDuration().toNanos(),
                  TimeUnit.NANOSECONDS);
        } catch (RejectedExecutionException e) {
          InterruptedBackoffComment comment =
              new InterruptedBackoffComment(
                  "Interrupted backoff -- unretryable error due to executor service shutdown");
          comment.addSuppressed(e);
          t.addSuppressed(comment);
          onFailure.onFailure(t);
        }
      } else {
        String msg =
            String.format(
                Locale.US,
                "%s (attempts: %d%s, elapsed: %s, nextBackoff: %s%s)%s",
                msgPrefix,
                failureCount,
                maxAttempts == Integer.MAX_VALUE
                    ? ""
                    : String.format(", maxAttempts: %d", maxAttempts),
                elapsed,
                nextBackoff.errorString(),
                Durations.eq(backoff.getTimeout(), Durations.EFFECTIVE_INFINITY)
                    ? ""
                    : ", timeout: " + backoff.getTimeout(),
                failures.isEmpty() ? "" : " previous failures follow in order of occurrence");
        t.addSuppressed(new RetryBudgetExhaustedComment(msg));
        for (Throwable failure : failures) {
          t.addSuppressed(failure);
        }
        onFailure.onFailure(t);
      }
    } finally {
      lock.unlock();
    }
  }

  private void clearPendingBackoff() {
    lock.lock();
    try {
      if (pendingBackoff != null) {
        if (!pendingBackoff.isDone()) {
          pendingBackoff.cancel(true);
        }
        pendingBackoff = null;
      }
      if (lastBackoffResult != null) {
        lastBackoffResult = null;
      }
    } finally {
      lock.unlock();
    }
  }
}
