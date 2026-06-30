/*
 * Copyright 2020 Google LLC
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

import com.google.common.base.Preconditions;
import java.util.Date;

/**
 * A helper that uses the Token Bucket algorithm to rate limit the number of operations that can be
 * made in a second.
 *
 * <p>Before a given request containing a number of operations can proceed, RateLimiter determines
 * doing so stays under the provided rate limits. It can also determine how much time is required
 * before a request can be made.
 *
 * <p>RateLimiter can also implement a gradually increasing rate limit. This is used to enforce the
 * 500/50/5 rule.
 *
 * @see <a href=https://cloud.google.com/firestore/docs/best-practices#ramping_up_traffic>Ramping up
 *     traffic</a>
 */
class RateLimiter {
  private final int initialCapacity;
  private final double multiplier;
  private final int multiplierMillis;
  private final long startTimeMillis;
  private final int maximumRate;

  private int availableTokens;
  private long lastRefillTimeMillis;

  RateLimiter(int initialCapacity, double multiplier, int multiplierMillis, int maximumRate) {
    this(initialCapacity, multiplier, multiplierMillis, maximumRate, new Date().getTime());
  }

  /**
   * @param initialCapacity Initial maximum number of operations per second.
   * @param multiplier Rate by which to increase the capacity.
   * @param multiplierMillis How often the capacity should increase in milliseconds.
   * @param maximumRate Maximum number of allowed operations per second. The number of tokens added
   *     per second will never exceed this number.
   * @param startTimeMillis The starting time in epoch milliseconds that the rate limit is based on.
   *     Used for testing the limiter.
   */
  RateLimiter(
      int initialCapacity,
      double multiplier,
      int multiplierMillis,
      int maximumRate,
      long startTimeMillis) {
    this.initialCapacity = initialCapacity;
    this.multiplier = multiplier;
    this.multiplierMillis = multiplierMillis;
    this.maximumRate = maximumRate;
    this.startTimeMillis = startTimeMillis;

    this.availableTokens = initialCapacity;
    this.lastRefillTimeMillis = startTimeMillis;
  }

  public int getInitialCapacity() {
    return initialCapacity;
  }

  public int getMaximumRate() {
    return maximumRate;
  }

  public boolean tryMakeRequest(int numOperations) {
    return tryMakeRequest(numOperations, new Date().getTime());
  }

  /**
   * Tries to make the number of operations. Returns true if the request succeeded and false
   * otherwise.
   *
   * @param requestTimeMillis The time used to calculate the number of available tokens. Used for
   *     testing the limiter.
   */
  public boolean tryMakeRequest(int numOperations, long requestTimeMillis) {
    refillTokens(requestTimeMillis);
    if (numOperations <= availableTokens) {
      availableTokens -= numOperations;
      return true;
    }
    return false;
  }

  public long getNextRequestDelayMs(int numOperations) {
    return getNextRequestDelayMs(numOperations, new Date().getTime());
  }

  /**
   * Returns the number of ms needed to make a request with the provided number of operations.
   * Returns 0 if the request can be made with the existing capacity. Returns -1 if the request is
   * not possible with the current capacity.
   *
   * @param requestTimeMillis The time used to calculate the number of available tokens. Used for
   *     testing the limiter.
   */
  public long getNextRequestDelayMs(int numOperations, long requestTimeMillis) {
    if (numOperations < availableTokens) {
      return 0;
    }

    int capacity = calculateCapacity(requestTimeMillis);
    if (capacity < numOperations) {
      return -1;
    }

    int requiredTokens = numOperations - availableTokens;
    return (long) Math.ceil((double) (requiredTokens * 1000) / capacity);
  }

  /**
   * Refills the number of available tokens based on how much time has elapsed since the last time
   * the tokens were refilled.
   *
   * @param requestTimeMillis The time used to calculate the number of available tokens. Used for
   *     testing the limiter.
   */
  private void refillTokens(long requestTimeMillis) {
    Preconditions.checkArgument(
        requestTimeMillis >= lastRefillTimeMillis,
        "Request time should not be before the last token refill time");
    long elapsedTime = requestTimeMillis - lastRefillTimeMillis;
    int capacity = calculateCapacity(requestTimeMillis);
    int tokensToAdd = (int) ((elapsedTime * capacity) / 1000);
    if (tokensToAdd > 0) {
      availableTokens = Math.min(capacity, availableTokens + tokensToAdd);
      lastRefillTimeMillis = requestTimeMillis;
    }
  }

  public int calculateCapacity(long requestTimeMillis) {
    long millisElapsed = requestTimeMillis - startTimeMillis;
    int operationsPerSecond =
        Math.min(
            (int)
                (Math.pow(multiplier, (int) (millisElapsed / multiplierMillis)) * initialCapacity),
            maximumRate);
    return operationsPerSecond;
  }
}
