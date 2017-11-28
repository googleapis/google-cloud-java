/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.firestore;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/** Helper to implement exponential backoff. */
class ExponentialBackoff {
  /*!
   * The initial backoff time in milliseconds after an error.
   * Set to 1s according to https://cloud.google.com/apis/design/errors.
   */
  private static int INITIAL_DELAY_MS = 1000;

  /*!
   * The maximum backoff time in milliseconds.
   */
  private static int MAX_DELAY_MS = 60 * 1000;

  /*!
   * The factor to increase the backup by after each failed attempt.
   */
  private static double BACKOFF_FACTOR = 1.5;

  private final ScheduledExecutorService executor;
  private final long initialDelayMs;
  private final double backoffFactor;
  private final long maxDelayMs;

  private long currentBaseMs;

  /**
   * Creates and returns a helper for running delayed tasks following an exponential backoff curve
   * between attempts.
   *
   * <p>Each delay is made up of a "base" delay which follows the exponential backoff curve, and a
   * +/- 50% "jitter" that is calculated and added to the base delay. This prevents clients from
   * accidentally synchronizing their delays causing spikes of load to the backend. @ param queue
   * The async queue to run tasks on.
   */
  ExponentialBackoff(ScheduledExecutorService executor) {
    this.executor = executor;
    this.initialDelayMs = INITIAL_DELAY_MS;
    this.backoffFactor = BACKOFF_FACTOR;
    this.maxDelayMs = MAX_DELAY_MS;

    reset();
  }

  /**
   * Resets the backoff delay.
   *
   * <p>The very next backoffAndRun() will have no delay. If it is called again (i.e. due to an
   * error), initialDelayMs (plus jitter) will be used, and subsequent ones will increase according
   * to the backoffFactor.
   */
  void reset() {
    currentBaseMs = 0;
  }

  /**
   * Resets the backoff delay to the maximum delay (e.g. for use after a RESOURCE_EXHAUSTED error).
   */
  void resetToMax() {
    currentBaseMs = maxDelayMs;
  }

  /**
   * Waits for currentDelayMs, increases the delay and runs the specified task.
   *
   * @param task The task to run.
   */
  void backoffAndRun(Runnable task) {
    // First schedule using the current base (which may be 0 and should be honored as such).
    long delayWithJitterMs = currentBaseMs + jitterDelayMs();

    executor.schedule(task, delayWithJitterMs, TimeUnit.MILLISECONDS);

    // Apply backoff factor to determine next delay and ensure it is within bounds.
    currentBaseMs *= backoffFactor;
    if (currentBaseMs < initialDelayMs) {
      currentBaseMs = initialDelayMs;
    } else if (currentBaseMs > maxDelayMs) {
      currentBaseMs = maxDelayMs;
    }
  }

  /** Returns a random value in the range [-currentBaseMs/2, currentBaseMs/2] */
  private long jitterDelayMs() {
    return (long) ((Math.random() - 0.5) * currentBaseMs);
  }
}
