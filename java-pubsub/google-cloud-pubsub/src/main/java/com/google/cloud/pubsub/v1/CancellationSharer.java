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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Coordinates multiple publish attempts for a single batch of messages.
 *
 * <p>Implements {@link ApiFuture} to act as the single future returned to the
 * publisher's client. It manages the lifecycle of the original attempt and any
 * subsequent hedged attempts.
 */
class CancellationSharer extends AbstractApiFuture<PublishResponse> {
  /** The message batch being coordinated. */
  private final Publisher.OutstandingBatch batch;

  /** The publisher instance. */
  private final Publisher publisher;

  /** Map of active attempt numbers to their respective gRPC futures. */
  private final Map<Integer, ApiFuture<PublishResponse>> runningAttempts =
      new ConcurrentHashMap<>();

  /** Boolean indicating whether the overall batch has resolved or failed. */
  private final AtomicBoolean done = new AtomicBoolean(false);

  /** Boolean indicating whether the batch is currently waiting in the hedging queue. */
  private final AtomicBoolean isInQueue = new AtomicBoolean(false);

  /** The last error encountered by any failed attempt. */
  private final AtomicReference<Throwable> lastError = new AtomicReference<>();

  CancellationSharer(final Publisher.OutstandingBatch batch, final Publisher publisher) {
    this.batch = batch;
    this.publisher = publisher;
  }

  /**
   * Adds an attempt to be tracked by this coordinator.
   *
   * @param attemptNumber the 1-based index of the attempt (1 is original, 2+ are hedged)
   * @param future the future representing the gRPC call for this attempt
   */
  void addAttempt(final int attemptNumber, final ApiFuture<PublishResponse> future) {
    runningAttempts.put(attemptNumber, future);

    if (done.get()) {
      future.cancel(true);
      runningAttempts.remove(attemptNumber);
      return;
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
    if (done.compareAndSet(false, true)) {
      batch.successfulAttempt = attemptNumber;
      set(response); // Resolve parent future
      cancelAllExcept(attemptNumber);
      publisher.refillTokenBucket();
    }
  }

  private void handleAttemptFailure(final int attemptNumber, final Throwable t) {
    runningAttempts.remove(attemptNumber);

    if (done.get()) {
      return;
    }
    lastError.set(t);

    boolean isRetryable = true;
    if (t instanceof ApiException) {
      isRetryable =
          publisher
              .getRetryableCodes()
              .contains(((ApiException) t).getStatusCode().getCode());
    }

    if (runningAttempts.isEmpty() || !isRetryable) {
      if (done.compareAndSet(false, true)) {
        setException(lastError.get());
        cancelAll();
        if (isInQueue.get()) {
          publisher.removeFromHedgingQueue(this);
        }
      }
    }
  }

  private void cancelAll() {
    for (ApiFuture<PublishResponse> future : runningAttempts.values()) {
      future.cancel(true);
    }
  }

  void checkCompletionOnQueueExit() {
    if (!done.get() && runningAttempts.isEmpty() && !isInQueue.get()) {
      if (done.compareAndSet(false, true)) {
        Throwable error = lastError.get();
        setException(
            error != null
                ? error
                : new RuntimeException("Hedging failed with no active attempts"));
      }
    }
  }

  private void cancelAllExcept(final int successfulAttempt) {
    for (Map.Entry<Integer, ApiFuture<PublishResponse>> entry : runningAttempts.entrySet()) {
      if (entry.getKey() != successfulAttempt) {
        entry.getValue().cancel(true);
      }
    }
  }

  @Override
  public boolean cancel(final boolean mayInterruptIfRunning) {
    if (super.cancel(mayInterruptIfRunning)) {
      done.set(true);
      if (isInQueue.get()) {
        publisher.removeFromHedgingQueue(this);
      }
      for (ApiFuture<PublishResponse> future : runningAttempts.values()) {
        future.cancel(mayInterruptIfRunning);
      }
      return true;
    }
    return false;
  }

  AtomicBoolean isInQueue() {
    return isInQueue;
  }

  Publisher.OutstandingBatch getBatch() {
    return batch;
  }
}
