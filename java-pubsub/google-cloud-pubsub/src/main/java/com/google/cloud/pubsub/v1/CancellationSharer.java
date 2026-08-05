/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.pubsub.v1;

import com.google.api.core.AbstractApiFuture;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiException;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.pubsub.v1.PublishResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Coordinates multiple publish attempts for a single batch of messages.
 *
 * <p>Implements {@link ApiFuture} to act as the single future returned to the publisher's client.
 * It manages the lifecycle of the original attempt and any subsequent hedged attempts.
 */
class CancellationSharer extends AbstractApiFuture<PublishResponse> {
  private Publisher.OutstandingBatch batch;
  private final Publisher publisher;
  private final long deadlineMs;

  // Guarded by lock
  private final Map<Integer, ApiFuture<PublishResponse>> runningAttempts = new HashMap<>();
  private boolean done = false;
  private Throwable lastError;

  private final Lock lock = new ReentrantLock();
  private final AtomicBoolean isInQueue = new AtomicBoolean(false);

  private void cleanupLocked() {
    runningAttempts.clear();
    this.batch = null;
  }

  CancellationSharer(
      final Publisher.OutstandingBatch batch, final Publisher publisher, final long deadlineMs) {
    this.batch = batch;
    this.publisher = publisher;
    this.deadlineMs = deadlineMs;
  }

  void addAttempt(final int attemptNumber, final ApiFuture<PublishResponse> future) {
    lock.lock();
    try {
      if (done) {
        future.cancel(true);
        return;
      }
      runningAttempts.put(attemptNumber, future);
    } finally {
      lock.unlock();
    }

    ApiFutures.addCallback(
        future,
        new ApiFutureCallback<PublishResponse>() {
          @Override
          public void onSuccess(final PublishResponse result) {
            handleAttemptSuccess(attemptNumber, result);
          }

          @Override
          public void onFailure(final Throwable t) {
            handleAttemptFailure(attemptNumber, t);
          }
        },
        MoreExecutors.directExecutor());
  }

  private void handleAttemptSuccess(final int attemptNumber, final PublishResponse response) {
    lock.lock();
    try {
      if (done) {
        return;
      }
      done = true;
      batch.successfulAttempt = attemptNumber;
      publisher
          .refillTokenBucket();
      set(response);
      cancelAllExceptLocked(attemptNumber);
      cleanupLocked();
    } finally {
      lock.unlock();
    }
  }

  private void handleAttemptFailure(final int attemptNumber, final Throwable t) {
    lock.lock();
    try {
      if (done) {
        return;
      }
      runningAttempts.remove(attemptNumber);
      lastError = t;

      boolean isRetryable = true;
      if (t instanceof ApiException) {
        isRetryable =
            publisher.getRetryableCodes().contains(((ApiException) t).getStatusCode().getCode());
      }

      if (runningAttempts.isEmpty() || !isRetryable) {
        done = true;
        setException(lastError);
        cancelAllLocked();
        cleanupLocked();
      }
    } finally {
      lock.unlock();
    }
  }

  void checkCompletionOnQueueExit() {
    lock.lock();
    try {
      if (!done && runningAttempts.isEmpty() && !isInQueue.get()) {
        done = true;
        setException(
            lastError != null
                ? lastError
                : new RuntimeException("Hedging failed with no active attempts"));
        cleanupLocked();
      }
    } finally {
      lock.unlock();
    }
  }

  @Override
  public boolean cancel(final boolean mayInterruptIfRunning) {
    boolean cancelled = false;
    lock.lock();
    try {
      if (super.cancel(mayInterruptIfRunning)) {
        cancelled = true;
        done = true;
        cancelAllLocked();
        cleanupLocked();
      }
    } finally {
      lock.unlock();
    }
    return cancelled;
  }

  private void cancelAllLocked() {
    for (ApiFuture<PublishResponse> future : runningAttempts.values()) {
      future.cancel(true);
    }
    runningAttempts.clear();
  }

  private void cancelAllExceptLocked(final int successfulAttempt) {
    runningAttempts.forEach(
        (attempt, future) -> {
          if (attempt != successfulAttempt) {
            future.cancel(true);
          }
        });
    runningAttempts.clear();
  }

  AtomicBoolean isInQueue() {
    return isInQueue;
  }

  Publisher.OutstandingBatch getBatchIfActive() {
    lock.lock();
    try {
      return done ? null : batch;
    } finally {
      lock.unlock();
    }
  }

  long getDeadlineMs() {
    return deadlineMs;
  }
}
