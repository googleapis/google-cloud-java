/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.internal.session;

import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.common.annotations.VisibleForTesting;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
class SessionCreationBudget {
  private static final Logger DEFAULT_LOGGER =
      Logger.getLogger(SessionCreationBudget.class.getName());

  // TODO: add a metric for session can't be created because there's no budget
  private volatile int maxConcurrentRequest;
  private volatile Duration penalty;
  private final Clock clock;

  private int concurrentRequests = 0;

  // Whenever a session creation failed, add the time to the list
  private final List<Instant> delayedCreationTokens = new ArrayList<>();

  static SessionCreationBudget create(int max, Duration penalty) {
    return new SessionCreationBudget(max, penalty, Clock.systemUTC());
  }

  @VisibleForTesting
  SessionCreationBudget(int max, Duration penalty, Clock clock) {
    this.maxConcurrentRequest = max;
    this.penalty = penalty;
    this.clock = clock;
  }

  Instant getNextAvailableBudget() {
    if (concurrentRequests < maxConcurrentRequest) {
      return Instant.now();
    }

    if (delayedCreationTokens.isEmpty()) {
      return Instant.now();
    }

    return delayedCreationTokens.get(0);
  }

  boolean tryReserveSession() {
    sanityCheck();

    if (concurrentRequests == maxConcurrentRequest) {
      drainCreationFailures();
    }

    if (concurrentRequests == maxConcurrentRequest) {
      return false;
    }

    concurrentRequests++;
    return true;
  }

  void onSessionCreationFailure() {
    delayedCreationTokens.add(Instant.now(clock).plus(penalty));
  }

  void onSessionCreationSuccess() {
    concurrentRequests--;
  }

  private void drainCreationFailures() {
    Instant now = Instant.now(clock);
    Iterator<Instant> iter = delayedCreationTokens.listIterator();
    while (iter.hasNext()) {
      if (iter.next().isBefore(now)) {
        concurrentRequests--;
        iter.remove();
      } else {
        // The list should be roughly sorted. Exit early when we encounter
        // something expires later.
        break;
      }
    }
  }

  private void sanityCheck() {
    // This could happen if the budget is updated
    if (concurrentRequests < 0) {
      DEFAULT_LOGGER.log(
          Level.FINE,
          "concurrent request can't be negative: {0}. Resetting it to 0.",
          concurrentRequests);
      concurrentRequests = 0;
    }
    if (concurrentRequests > maxConcurrentRequest) {
      DEFAULT_LOGGER.log(
          Level.FINE,
          "Concurrent requests out of range: {0}. Resetting it to max.",
          concurrentRequests);
      concurrentRequests = maxConcurrentRequest;
    }
  }

  public int getMaxConcurrentRequest() {
    return maxConcurrentRequest;
  }

  void updateConfig(SessionClientConfiguration.SessionPoolConfiguration config) {
    int oldBudget = this.maxConcurrentRequest;
    this.maxConcurrentRequest = config.getNewSessionCreationBudget();
    this.penalty = SessionUtil.toJavaDuration(config.getNewSessionCreationPenalty());
    DEFAULT_LOGGER.log(
        Level.FINE,
        "updated session creation budget from {0} to {1}.",
        new Object[] {oldBudget, config.getNewSessionCreationBudget()});
  }
}
