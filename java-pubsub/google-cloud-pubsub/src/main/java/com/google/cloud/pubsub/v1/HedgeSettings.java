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
  /** Default hedging delay. */
  private static final Duration DEFAULT_DELAY = Duration.ofMillis(1000);

  /** Default maximum number of tokens in the bucket. */
  private static final int DEFAULT_MAX_TOKENS = 50;

  /** Default refill rate (tokens per successful request). */
  private static final float DEFAULT_REFILL_RATIO = 0.1f;

  /** Hedging delay. */
  private final Duration hedgeDelay;

  /** Maximum tokens. */
  private final int maxTokens;

  /** Refill rate. */
  private final float refillRatio;

  private HedgeSettings(final Builder builder) {
    this.hedgeDelay = builder.hedgeDelay;
    this.maxTokens = builder.maxTokens;
    this.refillRatio = builder.refillRatio;
  }

  /**
   * Returns the configured hedging delay.
   *
   * @return the hedging delay.
   */
  Duration getHedgeDelay() {
    return hedgeDelay;
  }

  int getMaxTokens() {
    return maxTokens;
  }

  float getRefillRatio() {
    return refillRatio;
  }

  /**
   * Returns a new builder for {@code HedgeSettings}.
   *
   * @return a new builder.
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Builder for {@code HedgeSettings}. */
  public static final class Builder {
    /** Hedging delay. */
    private Duration hedgeDelay = DEFAULT_DELAY;

    /** Maximum tokens. */
    private int maxTokens = DEFAULT_MAX_TOKENS;

    /** Refill rate. */
    private float refillRatio = DEFAULT_REFILL_RATIO;

    private Builder() {}

    /**
     * Allows hedging delay to be configurable.
     *
     * @param delay the hedging delay, must be 0.1s <= HedgeDelay <= 10s.
     * @return this builder.
     */
    public Builder setHedgeDelay(final Duration delay) {
      Preconditions.checkNotNull(delay);
      if (delay.toMillis() < 100 || delay.toMillis() > 10000) {
        throw new IllegalArgumentException(
            "delay must be greater than or equal to 100ms and less than or equal to 10s");
      }
      this.hedgeDelay = delay;
      return this;
    }

    /**
     * Allows the maximum number of tokens in the bucket to be configurable.
     *
     * @param maxTokens the maximum number of tokens, must be 0 < MaxTokens <= 250.
     * @return this builder.
     */
    public Builder setMaxTokens(final int maxTokens) {
      if (maxTokens <= 0 || maxTokens > 250) {
        throw new IllegalArgumentException(
            "maxTokens must be greater than 0 and less than or equal to 250");
      }
      this.maxTokens = maxTokens;
      return this;
    }

    /**
     * Allows the token bucket refill rate to be configurable.
     *
     * @param refill the refill rate (tokens per successful request), must be 0 < RefillRatio <=
     *     0.2.
     * @return this builder.
     */
    public Builder setRefillRatio(final float refillRatio) {
      if (refillRatio <= 0.0f || refillRatio > 0.2f) {
        throw new IllegalArgumentException(
            "refill must be greater than 0.0 and less than or equal to 0.2");
      }
      this.refillRatio = refillRatio;
      return this;
    }

    /**
     * Builds an instance of {@code HedgeSettings}.
     *
     * @return the built {@code HedgeSettings} instance.
     */
    public HedgeSettings build() {
      return new HedgeSettings(this);
    }
  }
}
