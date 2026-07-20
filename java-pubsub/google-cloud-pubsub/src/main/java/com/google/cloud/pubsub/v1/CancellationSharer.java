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
import com.google.common.util.concurrent.MoreExecutors;
import com.google.pubsub.v1.PublishResponse;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;



/**
 * Coordinates multiple publish attempts for a single batch of messages.
 *
 * <p>Implements {@link ApiFuture} to act as the single future returned to the publisher's client.
 * It manages the lifecycle of the original attempt and any subsequent hedged attempts (CancellationSharer in the diagram).
 */
class CancellationSharer extends AbstractApiFuture<PublishResponse> {
  private final Publisher.OutstandingBatch batch;
  private final Publisher publisher;
  private final Map<Integer, ApiFuture<PublishResponse>> runningAttempts = new ConcurrentHashMap<>();
  private final AtomicInteger totalAttemptsCount = new AtomicInteger(0);
  private final AtomicBoolean done = new AtomicBoolean(false);
  final AtomicBoolean isInQueue = new AtomicBoolean(false);
  private final AtomicReference<Throwable> lastError = new AtomicReference<>();


  CancellationSharer(Publisher.OutstandingBatch batch, Publisher publisher) {
    this.batch = batch;
    this.publisher = publisher;
  }

  /**
   * Adds an attempt to be tracked by this coordinator.
   *
   * @param attemptNumber the 1-based index of the attempt (1 is original, 2+ are hedged)
   * @param future the future representing the gRPC call for this attempt
   */
  void addAttempt(final int attemptNumber, ApiFuture<PublishResponse> future) {
    runningAttempts.put(attemptNumber, future);
    totalAttemptsCount.incrementAndGet();

    if (done.get()) {
      future.cancel(true);
      runningAttempts.remove(attemptNumber);
      return;
    }

    ApiFutures.addCallback(
        future,
        new ApiFutureCallback<PublishResponse>() {
          @Override
          public void onSuccess(PublishResponse result) {
            handleAttemptSuccess(attemptNumber, result);
          }

          @Override
          public void onFailure(Throwable t) {
            handleAttemptFailure(attemptNumber, t);
          }
        },
        MoreExecutors.directExecutor());
  }

  private void handleAttemptSuccess(int attemptNumber, PublishResponse response) {
    if (done.compareAndSet(false, true)) {
      set(response); // Resolve parent future
      cancelAllExcept(attemptNumber);
      publisher.refillTokenBucket();
    }
  }

  private void handleAttemptFailure(int attemptNumber, Throwable t) {
    runningAttempts.remove(attemptNumber);

    if (!done.get()) {
      lastError.set(t);
      if (runningAttempts.isEmpty() && !isInQueue.get()) {
        if (done.compareAndSet(false, true)) {
          setException(lastError.get());
        }
      }
    }
  }

  void checkCompletionOnQueueExit() {
    if (!done.get() && runningAttempts.isEmpty() && !isInQueue.get()) {
      if (done.compareAndSet(false, true)) {
        Throwable error = lastError.get();
        setException(error != null ? error : new RuntimeException("Hedging failed with no active attempts"));
      }
    }
  }

  private void cancelAllExcept(int successfulAttempt) {
    for (Map.Entry<Integer, ApiFuture<PublishResponse>> entry : runningAttempts.entrySet()) {
      if (entry.getKey() != successfulAttempt) {
        entry.getValue().cancel(true);
      }
    }
  }

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    if (super.cancel(mayInterruptIfRunning)) {
      if (done.compareAndSet(false, true)) {
        for (ApiFuture<PublishResponse> future : runningAttempts.values()) {
          future.cancel(mayInterruptIfRunning);
        }
        return true;
      }
    }
    return false;
  }

  int getAttemptCount() {
    return totalAttemptsCount.get();
  }

  Publisher.OutstandingBatch getBatch() {
    return batch;
  }
}
