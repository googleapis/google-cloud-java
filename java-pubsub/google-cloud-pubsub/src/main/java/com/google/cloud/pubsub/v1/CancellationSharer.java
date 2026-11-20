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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
  private final long absoluteDeadlineMs;

  // Guarded by lock
  private final Map<Integer, ApiFuture<PublishResponse>> runningAttempts = new HashMap<>();
  private boolean done = false;

  private final Lock lock = new ReentrantLock();

  CancellationSharer(
      final Publisher.OutstandingBatch batch,
      final Publisher publisher,
      final long absoluteDeadlineMs) {
    this.batch = batch;
    this.publisher = publisher;
    this.absoluteDeadlineMs = absoluteDeadlineMs;
  }

  void addAttempt(final int attemptNumber, final ApiFuture<PublishResponse> future) {
    boolean cancelAttempt;
    lock.lock();
    try {
      cancelAttempt = done;
      if (!cancelAttempt) {
        runningAttempts.put(attemptNumber, future);
      }
    } finally {
      lock.unlock();
    }
    if (cancelAttempt) {
      future.cancel(true);
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
    List<ApiFuture<PublishResponse>> attemptsToCancel;
    lock.lock();
    try {
      if (done) {
        return;
      }
      batch.successfulAttempt = attemptNumber;
      publisher.refillTokenBucket();
      runningAttempts.remove(attemptNumber);
      attemptsToCancel = finishLocked();
    } finally {
      lock.unlock();
    }
    cancelAttempts(attemptsToCancel);
    set(response);
  }

  private void handleAttemptFailure(final int attemptNumber, final Throwable t) {
    List<ApiFuture<PublishResponse>> attemptsToCancel;
    lock.lock();
    try {
      if (done) {
        return;
      }
      runningAttempts.remove(attemptNumber);
      if (attemptNumber != 0 && !runningAttempts.isEmpty()) {
        return;
      }
      attemptsToCancel = finishLocked();
    } finally {
      lock.unlock();
    }
    cancelAttempts(attemptsToCancel);
    setException(t);
  }

  @Override
  public boolean cancel(final boolean mayInterruptIfRunning) {
    List<ApiFuture<PublishResponse>> attemptsToCancel;
    lock.lock();
    try {
      if (done) {
        return false;
      }
      attemptsToCancel = finishLocked();
    } finally {
      lock.unlock();
    }
    try {
      return super.cancel(mayInterruptIfRunning);
    } finally {
      cancelAttempts(attemptsToCancel);
    }
  }

  private List<ApiFuture<PublishResponse>> finishLocked() {
    done = true;
    List<ApiFuture<PublishResponse>> attemptsToCancel =
        runningAttempts.isEmpty()
            ? Collections.emptyList()
            : new ArrayList<>(runningAttempts.values());
    runningAttempts.clear();
    batch = null;
    return attemptsToCancel;
  }

  // An attempt callback can enter this coordinator while holding the attempt future's lock.
  // Cancel the attempts only after releasing the coordinator lock.
  private static void cancelAttempts(List<ApiFuture<PublishResponse>> attempts) {
    for (ApiFuture<PublishResponse> attempt : attempts) {
      attempt.cancel(true);
    }
  }

  Publisher.OutstandingBatch getBatchIfActive() {
    lock.lock();
    try {
      return done ? null : batch;
    } finally {
      lock.unlock();
    }
  }

  long getAbsoluteDeadlineMs() {
    return absoluteDeadlineMs;
  }
}
