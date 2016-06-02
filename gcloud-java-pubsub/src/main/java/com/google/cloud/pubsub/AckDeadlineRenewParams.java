/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.pubsub;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Parameters for configuring automatic ack deadline renewals with an exponential backoff. The first
 * time the ack deadline is renewed for a pulled message, its value is set to
 * {@link #initialDeadlineSeconds()}. For each subsequent ack deadline renewal, the ack deadline is
 * calculated as:
 *
 * <p>{@code deadlineBackoffFactor ^ renewals * initialDeadlineSeconds} but would be upper-bounded
 * to {@code maxDeadlineSeconds}
 */
public final class AckDeadlineRenewParams implements Serializable {

  private static final long serialVersionUID = -8142363212304296426L;

  public static final int DEFAULT_INITIAL_DEADLINE_SECONDS = 10;
  public static final int DEFAULT_MAX_DEADLINED_SECONDS = 80;
  public static final double DEFAULT_DEADLINE_BACKOFF_FACTOR = 2.0;

  private final int initialDeadlineSeconds;
  private final int maxDeadlineSeconds;
  private final double deadlineBackoffFactor;

  private static final AckDeadlineRenewParams DEFAULT_INSTANCE =
      new AckDeadlineRenewParams(new Builder());
  private static final AckDeadlineRenewParams NO_BACKOFF = builder()
      .maxDeadlineSeconds(DEFAULT_INITIAL_DEADLINE_SECONDS)
      .deadlineBackoffFactor(1)
      .initialDeadlineSeconds(DEFAULT_INITIAL_DEADLINE_SECONDS)
      .build();

  /**
   * {@code AckDeadlineRenewParams} builder.
   */
  public static final class Builder {

    private int initialDeadlineSeconds;
    private int maxDeadlineSeconds;
    private double deadlineBackoffFactor;

    private Builder() {
      this.initialDeadlineSeconds = DEFAULT_INITIAL_DEADLINE_SECONDS;
      this.maxDeadlineSeconds = DEFAULT_MAX_DEADLINED_SECONDS;
      this.deadlineBackoffFactor = DEFAULT_DEADLINE_BACKOFF_FACTOR;
    }

    Builder(AckDeadlineRenewParams renewParams) {
      this.initialDeadlineSeconds = renewParams.initialDeadlineSeconds;
      this.maxDeadlineSeconds = renewParams.maxDeadlineSeconds;
      this.deadlineBackoffFactor = renewParams.deadlineBackoffFactor;
    }

    /**
     * Sets the initial deadline value, used the first time the ack deadline is renewed for a pulled
     * message. This value must be &gt= 10 seconds.
     *
     * @param initialDeadlineSeconds the initial deadline value, in seconds
     * @return the Builder for chaining
     */
    public Builder initialDeadlineSeconds(int initialDeadlineSeconds) {
      this.initialDeadlineSeconds = initialDeadlineSeconds;
      return this;
    }

    /**
     * Sets the maximum deadline value. This value must be greater or equal to the value set for
     * {@link #initialDeadlineSeconds(int)}.
     *
     * @param maxDeadlineSeconds the maximum deadline value, in seconds
     * @return the Builder for chaining
     */
    public Builder maxDeadlineSeconds(int maxDeadlineSeconds) {
      this.maxDeadlineSeconds = maxDeadlineSeconds;
      return this;
    }

    /**
     * Sets the deadline backoff factor, used to compute deadline renewal values after the initial
     * one. This value must be &gt= 1.
     *
     * @param deadlineBackoffFactor the backoff factor
     * @return the Builder for chaining
     */
    public Builder deadlineBackoffFactor(double deadlineBackoffFactor) {
      this.deadlineBackoffFactor = deadlineBackoffFactor;
      return this;
    }

    /**
     * Create an instance of {@code AckDeadlineRenewParams} with the parameters set in this builder.
     *
     * @return a new instance of {@code AckDeadlineRenewParams}
     */
    public AckDeadlineRenewParams build() {
      return new AckDeadlineRenewParams(this);
    }
  }

  private AckDeadlineRenewParams(Builder builder) {
    initialDeadlineSeconds = builder.initialDeadlineSeconds;
    maxDeadlineSeconds = builder.maxDeadlineSeconds;
    deadlineBackoffFactor = builder.deadlineBackoffFactor;
    checkArgument(initialDeadlineSeconds >= 10, "Initial deadline must be >= 10 seconds");
    checkArgument(maxDeadlineSeconds >= initialDeadlineSeconds,
        "Max deadline must be greater or equal to the initial deadline");
    checkArgument(deadlineBackoffFactor >= 1.0, "Deadline backoff factor must be >= 1");
  }

  /**
   * Returns an {@code AckDeadlineRenewParams} object with default values: initial deadline is
   * {@value DEFAULT_INITIAL_DEADLINE_SECONDS} seconds, max deadline is
   * {@value DEFAULT_MAX_DEADLINED_SECONDS} seconds and the backoff factor is
   * {@value DEFAULT_DEADLINE_BACKOFF_FACTOR}.
   */
  public static AckDeadlineRenewParams defaultInstance() {
    return DEFAULT_INSTANCE;
  }

  /**
   * Returns an {@code AckDeadlineRenewParams} object that does no backoff, deadline is always set
   * to 10 seconds.
   */
  public static AckDeadlineRenewParams noBackoff() {
    return NO_BACKOFF;
  }

  /**
   * Returns the initial deadline value, used the first time the ack deadline is renewed for a
   * pulled message.
   */
  public int initialDeadlineSeconds() {
    return initialDeadlineSeconds;
  }

  /**
   * Returns the maximum deadline value.
   */
  public int maxDeadlineSeconds() {
    return maxDeadlineSeconds;
  }

  /**
   * Sets the deadline backoff factor, used to compute deadline renewal values after the initial
   * one.
   */
  public double deadlineBackoffFactor() {
    return deadlineBackoffFactor;
  }

  @Override
  public int hashCode() {
    return Objects.hash(initialDeadlineSeconds, maxDeadlineSeconds, deadlineBackoffFactor);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof AckDeadlineRenewParams)) {
      return false;
    }
    AckDeadlineRenewParams other = (AckDeadlineRenewParams) obj;
    return initialDeadlineSeconds == other.initialDeadlineSeconds
        && maxDeadlineSeconds == other.maxDeadlineSeconds
        && deadlineBackoffFactor == other.deadlineBackoffFactor;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("initialDeadlineSeconds", initialDeadlineSeconds)
        .add("maxDeadlineSeconds", maxDeadlineSeconds)
        .add("deadlineBackoffFactor", deadlineBackoffFactor).toString();
  }

  /**
   * Returns a builder for {@code AckDeadlineRenewParams} objects.
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Returns a builder for the current {@code AckDeadlineRenewParams} object.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }
}
