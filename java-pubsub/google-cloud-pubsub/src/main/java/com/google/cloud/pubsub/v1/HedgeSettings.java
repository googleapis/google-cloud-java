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

import com.google.common.base.Preconditions;
import java.time.Duration;

/** Settings for configuring publish hedging. */
public final class HedgeSettings {
  private static final Duration DEFAULT_DELAY = Duration.ofMillis(100);
  private static final int DEFAULT_MAX_TOKENS = 100;
  private static final float DEFAULT_REFILL = 0.1f;

  private final Duration hedgeDelay;
  private final int maxTokens;
  private final float refill;

  private HedgeSettings(Builder builder) {
    this.hedgeDelay = builder.hedgeDelay;
    this.maxTokens = builder.maxTokens;
    this.refill = builder.refill;
  }

  /** Returns the configured hedging delay. */
  public Duration getHedgeDelay() {
    return hedgeDelay;
  }

  int getMaxTokens() {
    return maxTokens;
  }

  float getRefill() {
    return refill;
  }

  /** Returns a new builder for {@code HedgeSettings}. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Builder for {@code HedgeSettings}. */
  public static final class Builder {
    private Duration hedgeDelay = DEFAULT_DELAY;
    private int maxTokens = DEFAULT_MAX_TOKENS;
    private float refill = DEFAULT_REFILL;

    private Builder() {}

    /** Allows hedging delay to be configurable. */
    public Builder setHedgeDelay(Duration hedgeDelay) {
      Preconditions.checkNotNull(hedgeDelay);
      Preconditions.checkArgument(!hedgeDelay.isNegative() && !hedgeDelay.isZero(), "hedgeDelay must be positive");
      this.hedgeDelay = hedgeDelay;
      return this;
    }

    /** Builds an instance of {@code HedgeSettings}. */
    public HedgeSettings build() {
      return new HedgeSettings(this);
    }
  }
}
