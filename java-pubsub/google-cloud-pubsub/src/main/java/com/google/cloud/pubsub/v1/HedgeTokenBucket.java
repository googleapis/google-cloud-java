/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.pubsub.v1;

import com.google.common.annotations.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

/** Token bucket for limiting hedged requests. Thread-safe. */
final class HedgeTokenBucket {
  private final int maxTokens;
  private final float refillAmount;

  @GuardedBy("this")
  private float tokens;

  HedgeTokenBucket(HedgeSettings settings) {
    this.maxTokens = settings.getMaxTokens();
    this.refillAmount = settings.getRefill();
    this.tokens = maxTokens;
  }

  @VisibleForTesting
  HedgeTokenBucket(int maxTokens, float refillAmount) {
    this.maxTokens = maxTokens;
    this.refillAmount = refillAmount;
    this.tokens = maxTokens;
  }

  /**
   * Attempts to acquire a token for a hedged request.
   *
   * @return {@code true} if a token was acquired, {@code false} otherwise.
   */
  synchronized boolean tryAcquire() {
    if (tokens >= 1.0f) {
      tokens -= 1.0f;
      return true;
    }
    return false;
  }

  /** Refills the bucket by the configured refill amount, capped at max tokens. */
  synchronized void refill() {
    tokens = Math.min(maxTokens, tokens + refillAmount);
  }

  @VisibleForTesting
  synchronized float getTokens() {
    return tokens;
  }
}
