/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;

import java.io.Serializable;
import java.util.Objects;

/**
 * Parameters for configuring retries with an exponential backoff. Initial request is executed
 * immediately. If the request fails but passes the {@link ExceptionHandler} criteria the calling
 * thread sleeps for {@code initialRetryDelayMillis}. Each subsequent failure the sleep interval is
 * calculated as:
 * <p>
 * {@code retryDelayBackoffFactor ^ attempts * initialRetryDelayMillis} but would be upper-bounded
 * to {@code maxRetryDelayMillis}
 * </p>
 * This proceeds until either the request is successful, {@code retryMaxAttempts} are made, or both
 * {@code retryMinAttempts} are made and {@code totalRetryPeriodMillis} have elapsed. To construct
 * {@code RetryParams}, first create a {@link RetryParams.Builder}. The builder is mutable and each
 * of the parameters can be set (any unset parameters will fallback to the defaults). The
 * {@code Builder} can be then used to create an immutable {@code RetryParams} object. For default
 * {@code RetryParams} use {@link #getDefaultInstance}. Default settings are subject to change
 * release to release. If you require specific settings, explicitly create an instance of
 * {@code RetryParams} with all the required settings.
 *
 * @see RetryHelper
 */
public final class RetryParams implements Serializable {

  private static final long serialVersionUID = -8492751576749007700L;

  public static final int DEFAULT_RETRY_MIN_ATTEMPTS = 3;
  public static final int DEFAULT_RETRY_MAX_ATTEMPTS = 6;
  public static final long DEFAULT_INITIAL_RETRY_DELAY_MILLIS = 250L;
  public static final long DEFAULT_MAX_RETRY_DELAY_MILLIS = 10_000L;
  public static final double DEFAULT_RETRY_DELAY_BACKOFF_FACTOR = 2.0;
  public static final long DEFAULT_TOTAL_RETRY_PERIOD_MILLIS = 50_000L;

  private final int retryMinAttempts;
  private final int retryMaxAttempts;
  private final long initialRetryDelayMillis;
  private final long maxRetryDelayMillis;
  private final double retryDelayBackoffFactor;
  private final long totalRetryPeriodMillis;

  private static final RetryParams DEFAULT_INSTANCE = new RetryParams(new Builder());
  private static final RetryParams NO_RETRIES =
      builder().retryMaxAttempts(1).retryMinAttempts(1).build();

  /**
   * RetryParams builder.
   */
  public static final class Builder {

    private int retryMinAttempts;
    private int retryMaxAttempts;
    private long initialRetryDelayMillis;
    private long maxRetryDelayMillis;
    private double retryDelayBackoffFactor;
    private long totalRetryPeriodMillis;

    private Builder() {
      this(null);
    }

    Builder(/* Nullable */RetryParams retryParams) {
      if (retryParams == null) {
        retryMinAttempts = DEFAULT_RETRY_MIN_ATTEMPTS;
        retryMaxAttempts = DEFAULT_RETRY_MAX_ATTEMPTS;
        initialRetryDelayMillis = DEFAULT_INITIAL_RETRY_DELAY_MILLIS;
        maxRetryDelayMillis = DEFAULT_MAX_RETRY_DELAY_MILLIS;
        retryDelayBackoffFactor = DEFAULT_RETRY_DELAY_BACKOFF_FACTOR;
        totalRetryPeriodMillis = DEFAULT_TOTAL_RETRY_PERIOD_MILLIS;
      } else {
        retryMinAttempts = retryParams.getRetryMinAttempts();
        retryMaxAttempts = retryParams.getRetryMaxAttempts();
        initialRetryDelayMillis = retryParams.getInitialRetryDelayMillis();
        maxRetryDelayMillis = retryParams.getMaxRetryDelayMillis();
        retryDelayBackoffFactor = retryParams.getRetryDelayBackoffFactor();
        totalRetryPeriodMillis = retryParams.getTotalRetryPeriodMillis();
      }
    }

    /**
     * Sets retryMinAttempts.
     *
     * @param retryMinAttempts the retryMinAttempts to set
     * @return the Builder for chaining
     */
    public Builder retryMinAttempts(int retryMinAttempts) {
      this.retryMinAttempts = retryMinAttempts;
      return this;
    }

    /**
     * Sets retryMaxAttempts.
     *
     * @param retryMaxAttempts the retryMaxAttempts to set
     * @return the Builder for chaining
     */
    public Builder retryMaxAttempts(int retryMaxAttempts) {
      this.retryMaxAttempts = retryMaxAttempts;
      return this;
    }

    /**
     * Sets initialRetryDelayMillis.
     *
     * @param initialRetryDelayMillis the initialRetryDelayMillis to set
     * @return the Builder for chaining
     */
    public Builder initialRetryDelayMillis(long initialRetryDelayMillis) {
      this.initialRetryDelayMillis = initialRetryDelayMillis;
      return this;
    }

    /**
     * Sets maxRetryDelayMillis.
     *
     * @param maxRetryDelayMillis the maxRetryDelayMillis to set
     * @return the Builder for chaining
     */
    public Builder maxRetryDelayMillis(long maxRetryDelayMillis) {
      this.maxRetryDelayMillis = maxRetryDelayMillis;
      return this;
    }

    /**
     * Sets retryDelayBackoffFactor.
     *
     * @param retryDelayBackoffFactor the retryDelayBackoffFactor to set
     * @return the Builder for chaining
     */
    public Builder retryDelayBackoffFactor(double retryDelayBackoffFactor) {
      this.retryDelayBackoffFactor = retryDelayBackoffFactor;
      return this;
    }

    /**
     * Sets totalRetryPeriodMillis.
     *
     * @param totalRetryPeriodMillis the totalRetryPeriodMillis to set
     * @return the Builder for chaining
     */
    public Builder totalRetryPeriodMillis(long totalRetryPeriodMillis) {
      this.totalRetryPeriodMillis = totalRetryPeriodMillis;
      return this;
    }

    /**
     * Create an instance of RetryParams with the parameters set in this builder.
     *
     * @return a new instance of RetryParams
     */
    public RetryParams build() {
      return new RetryParams(this);
    }
  }

  /**
   * Create a new RetryParams with the parameters from a {@link RetryParams.Builder}
   *
   * @param builder the parameters to use to construct the RetryParams object
   */
  private RetryParams(Builder builder) {
    retryMinAttempts = builder.retryMinAttempts;
    retryMaxAttempts = builder.retryMaxAttempts;
    initialRetryDelayMillis = builder.initialRetryDelayMillis;
    maxRetryDelayMillis = builder.maxRetryDelayMillis;
    retryDelayBackoffFactor = builder.retryDelayBackoffFactor;
    totalRetryPeriodMillis = builder.totalRetryPeriodMillis;
    checkArgument(retryMinAttempts >= 0, "retryMinAttempts must not be negative");
    checkArgument(retryMaxAttempts >= retryMinAttempts,
        "retryMaxAttempts must not be smaller than retryMinAttempts");
    checkArgument(initialRetryDelayMillis >= 0, "initialRetryDelayMillis must not be negative");
    checkArgument(maxRetryDelayMillis >= initialRetryDelayMillis,
        "maxRetryDelayMillis must not be smaller than initialRetryDelayMillis");
    checkArgument(retryDelayBackoffFactor >= 0, "retryDelayBackoffFactor must not be negative");
    checkArgument(totalRetryPeriodMillis >= 0, "totalRetryPeriodMillis must not be negative");
  }

  /**
   * Returns an instance with the default parameters.
   */
  public static RetryParams getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  /**
   * Returns an instance of {@code RetryParams} where `retryMaxAttempts` and `retryMinAttempts` are
   * set to `1`.
   */
  public static RetryParams noRetries() {
    return NO_RETRIES;
  }

  /**
   * Returns the retryMinAttempts. Default value is {@value #DEFAULT_RETRY_MIN_ATTEMPTS}.
   */
  public int getRetryMinAttempts() {
    return retryMinAttempts;
  }

  /**
   * Returns the retryMaxAttempts. Default value is {@value #DEFAULT_RETRY_MAX_ATTEMPTS}.
   */
  public int getRetryMaxAttempts() {
    return retryMaxAttempts;
  }

  /**
   * Returns the initialRetryDelayMillis. Default value is
   * {@value #DEFAULT_INITIAL_RETRY_DELAY_MILLIS}.
   */
  public long getInitialRetryDelayMillis() {
    return initialRetryDelayMillis;
  }

  /**
   * Returns the maxRetryDelayMillis. Default values is {@value #DEFAULT_MAX_RETRY_DELAY_MILLIS}.
   */
  public long getMaxRetryDelayMillis() {
    return maxRetryDelayMillis;
  }

  /**
   * Returns the maxRetryDelayBackoffFactor. Default values is
   * {@value #DEFAULT_RETRY_DELAY_BACKOFF_FACTOR}.
   */
  public double getRetryDelayBackoffFactor() {
    return retryDelayBackoffFactor;
  }

  /**
   * Returns the totalRetryPeriodMillis. Default value is
   * {@value #DEFAULT_TOTAL_RETRY_PERIOD_MILLIS}.
   */
  public long getTotalRetryPeriodMillis() {
    return totalRetryPeriodMillis;
  }

  @Override
  public int hashCode() {
    return Objects.hash(retryMinAttempts, retryMaxAttempts, initialRetryDelayMillis,
        maxRetryDelayMillis, retryDelayBackoffFactor, totalRetryPeriodMillis);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof RetryParams)) {
      return false;
    }
    RetryParams other = (RetryParams) obj;
    return retryMinAttempts == other.retryMinAttempts && retryMaxAttempts == other.retryMaxAttempts
        && initialRetryDelayMillis == other.initialRetryDelayMillis
        && maxRetryDelayMillis == other.maxRetryDelayMillis
        && retryDelayBackoffFactor == other.retryDelayBackoffFactor
        && totalRetryPeriodMillis == other.totalRetryPeriodMillis;
  }

  @Override
  public String toString() {
    ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
    toStringHelper.add("retryMinAttempts", retryMinAttempts);
    toStringHelper.add("retryMaxAttempts", retryMaxAttempts);
    toStringHelper.add("initialRetryDelayMillis", initialRetryDelayMillis);
    toStringHelper.add("maxRetryDelayMillis", maxRetryDelayMillis);
    toStringHelper.add("retryDelayBackoffFactor", retryDelayBackoffFactor);
    toStringHelper.add("totalRetryPeriodMillis", totalRetryPeriodMillis);
    return toStringHelper.toString();
  }

  public static Builder builder() {
    return new Builder();
  }
}
