/*
 * Copyright 2016 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.retrying;

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;
import static com.google.api.gax.util.TimeConversionUtils.toThreetenDuration;

import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.auto.value.AutoValue;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;

/**
 * Holds the parameters for <b>retry</b> or <b>poll</b> logic with jitter, timeout and exponential
 * backoff. Actual implementation of the logic is elsewhere.
 *
 * <p>The intent of these settings is to be used with a call to a remote server, which could either
 * fail (and return an error code) or not respond (and cause a timeout). When there is a failure or
 * timeout, the logic should keep trying until the total timeout has passed.
 *
 * <p>The "total timeout" and "max attempts" settings have ultimate control over how long the logic
 * should keep trying the remote call until it gives up completely. The remote call will be retried
 * until one of those thresholds is crossed. To avoid unbounded rpc calls, it is required to
 * configure one of those settings. If both are 0, then retries will be disabled. The other settings
 * are considered more advanced.
 *
 * <p>Retry delay and timeout start at specific values, and are tracked separately from each other.
 * The very first call (before any retries) will use the initial timeout.
 *
 * <p>If the last remote call is a failure, then the retrier will wait for the current retry delay
 * before attempting another call, and then the retry delay will be multiplied by the retry delay
 * multiplier for the next failure. The timeout will not be affected, except in the case where the
 * timeout would result in a deadline past the total timeout; in that circumstance, a new timeout
 * value is computed which will terminate the call when the total time is up.
 *
 * <p>If the last remote call is a timeout, then the retrier will compute a new timeout and make
 * another call. The new timeout is computed by multiplying the current timeout by the timeout
 * multiplier, but if that results in a deadline after the total timeout, then a new timeout value
 * is computed which will terminate the call when the total time is up.
 *
 * <p>Server streaming RPCs interpret RPC timeouts a bit differently. For server streaming RPCs, the
 * RPC timeout gets converted into a wait timeout {@link
 * com.google.api.gax.rpc.ApiCallContext#withStreamWaitTimeoutDuration(java.time.Duration)}.
 *
 * <p>In Cloud Client Libraries, Retry and LRO Retry Settings may be configured for each RPC in a
 * service. These values are chosen by the service teams and may be found by looking at the
 * {Service}StubSettings.java file in each library. The default values listed below for each
 * configuration are the default values for the RetrySettings class if there are no RPC specific
 * configurations from the Service Team.
 */
@AutoValue
public abstract class RetrySettings implements Serializable {

  private static final long serialVersionUID = 8258475264439710899L;

  /** This method is obsolete. Use {@link #getTotalTimeoutDuration()} instead */
  @ObsoleteApi("Use getTotalTimeoutDuration() instead")
  public org.threeten.bp.Duration getTotalTimeout() {
    return toThreetenDuration(getTotalTimeoutDuration());
  }
  ;

  /**
   * TotalTimeout has ultimate control over how long the logic should keep trying the remote call
   * until it gives up completely. The higher the total timeout, the more retries and polls can be
   * attempted. If this value is {@code Duration.ZERO}, then the logic will instead use the number
   * of attempts to determine retries. In the event that both maxAttempts and totalTimeout values
   * are both 0, the logic will not retry. If this value is non-{@code Duration.ZERO}, and the retry
   * duration has reaches the timeout value, the logic will give up retrying even the number of
   * attempts is lower than the maxAttempts value.
   *
   * <p>If there are no configurations, Retries have the default timeout value of {@code
   * Duration.ZERO} and LROs have a default total timeout value of {@code Duration.ofMillis(300000)}
   * (5 minutes).
   */
  public abstract java.time.Duration getTotalTimeoutDuration();

  /** This method is obsolete. Use {@link #getInitialRetryDelayDuration()} instead */
  @ObsoleteApi("Use getInitialRetryDelayDuration() instead")
  public org.threeten.bp.Duration getInitialRetryDelay() {
    return toThreetenDuration(getInitialRetryDelayDuration());
  }

  /**
   * InitialRetryDelay controls the delay before the first retry/ poll. Subsequent retries and polls
   * will use this value adjusted according to the RetryDelayMultiplier.
   *
   * <p>If there are no configurations, Retries have the default initial retry delay value of {@code
   * Duration.ZERO} and LROs have a default initial poll delay value of {@code
   * Duration.ofMillis(5000)} (5 seconds).
   */
  public abstract java.time.Duration getInitialRetryDelayDuration();

  /**
   * RetryDelayMultiplier controls the change in delay before the next retry or poll. The retry
   * delay of the previous call is multiplied by the RetryDelayMultiplier to calculate the retry
   * delay for the next call.
   *
   * <p>If there are no configurations, Retries have the default retry delay multiplier value of
   * {@code 1.0} and LROs have a default retry delay multiplier of {@code 1.5}.
   */
  public abstract double getRetryDelayMultiplier();

  /** This method is obsolete. Use {@link #getMaxRetryDelayDuration()} instead */
  @ObsoleteApi("Use getMaxRetryDelayDuration()")
  public org.threeten.bp.Duration getMaxRetryDelay() {
    return toThreetenDuration(getMaxRetryDelayDuration());
  }

  /**
   * MaxRetryDelay puts a limit on the value of the retry delay, so that the RetryDelayMultiplier
   * can't increase the retry delay higher than this amount.
   *
   * <p>If there are no configurations, Retries have the default max retry delay value of {@code
   * Duration.ZERO} and LROs have a default max poll retry delay value of {@code
   * Duration.ofMillis(45000)} (45 seconds).
   */
  public abstract java.time.Duration getMaxRetryDelayDuration();

  /**
   * MaxAttempts defines the maximum number of retry attempts to perform. If this value is set to 0,
   * the logic will instead use the totalTimeout value to determine retries. In the event that both
   * the maxAttempts and totalTimeout values are both 0, the logic will not retry. If this value is
   * greater than 0, and the number of attempts exceeds this limit, the logic will give up retrying
   * even if the total retry time is still lower than totalTimeout.
   *
   * <p>If there are no configurations, Retries and LROs have the default max attempt value of
   * {@code 0}. LRO polling does not use this value by default.
   *
   * <p>The first RPC invocation will be considered attempt #0. Subsequent calls (retries) will
   * increment the number of attempts and the number of attempts will not exceed this value.
   */
  public abstract int getMaxAttempts();

  /**
   * Jitter determines if the delay time should be randomized. In most cases, if jitter is set to
   * {@code true} the actual delay time is calculated in the following way:
   *
   * <pre>{@code actualDelay = rand_between(0, min(maxRetryDelay, delay))}</pre>
   *
   * The default value is {@code true}.
   *
   * @deprecated Retries always jitter.
   */
  @Deprecated
  @VisibleForTesting
  public abstract boolean isJittered();

  /** This method is obsolete. Use {@link #getInitialRpcTimeoutDuration()} instead */
  @ObsoleteApi("Use getInitialRpcTimeoutDuration() instead")
  public final org.threeten.bp.Duration getInitialRpcTimeout() {
    return toThreetenDuration(getInitialRpcTimeoutDuration());
  }

  /**
   * InitialRpcTimeout controls the timeout for the initial RPC. Subsequent calls will use this
   * value adjusted according to the RpcTimeoutMultiplier. RPC Timeout value of {@code
   * Duration.ZERO} allows the RPC to continue indefinitely (until it hits a Connect Timeout or the
   * connection has been terminated).
   *
   * <p>{@link #getTotalTimeout()} caps how long the logic should keep trying the RPC until it gives
   * up completely. If {@link #getTotalTimeout()} is set, initialRpcTimeout should be <=
   * totalTimeout.
   *
   * <p>If there are no configurations, Retries have the default initial RPC timeout value of {@code
   * Duration.ZERO}. LRO polling does not use the Initial RPC Timeout value.
   */
  public abstract java.time.Duration getInitialRpcTimeoutDuration();

  /**
   * RpcTimeoutMultiplier controls the change in RPC timeout. The timeout of the previous call is
   * multiplied by the RpcTimeoutMultiplier to calculate the timeout for the next call.
   *
   * <p>If there are no configurations, Retries have the default RPC Timeout Multiplier value of
   * {@code 1.0}. LRO polling does not use the RPC Timeout Multiplier value.
   */
  public abstract double getRpcTimeoutMultiplier();

  /** This method is obsolete. Use {@link #getMaxRpcTimeoutDuration()} instead */
  @ObsoleteApi("Use getMaxRpcTimeoutDuration() instead")
  public final org.threeten.bp.Duration getMaxRpcTimeout() {
    return toThreetenDuration(getMaxRpcTimeoutDuration());
  }

  /**
   * MaxRpcTimeout puts a limit on the value of the RPC timeout, so that the RpcTimeoutMultiplier
   * can't increase the RPC timeout higher than this amount.
   *
   * <p>If there are no configurations, Retries have the default Max RPC Timeout value of {@code
   * Duration.ZERO}. LRO polling does not use the Max RPC Timeout value.
   */
  public abstract java.time.Duration getMaxRpcTimeoutDuration();

  public static Builder newBuilder() {
    return new AutoValue_RetrySettings.Builder()
        .setTotalTimeoutDuration(java.time.Duration.ZERO)
        .setInitialRetryDelayDuration(java.time.Duration.ZERO)
        .setRetryDelayMultiplier(1.0)
        .setMaxRetryDelayDuration(java.time.Duration.ZERO)
        .setMaxAttempts(0)
        .setJittered(true)
        .setInitialRpcTimeoutDuration(java.time.Duration.ZERO)
        .setRpcTimeoutMultiplier(1.0)
        .setMaxRpcTimeoutDuration(java.time.Duration.ZERO);
  }

  public abstract Builder toBuilder();

  /**
   * A base builder class for {@link RetrySettings}. See the class documentation of {@link
   * RetrySettings} for a description of the different values that can be set.
   */
  @AutoValue.Builder
  public abstract static class Builder {

    /** This method is obsolete. Use {@link #setTotalTimeoutDuration(java.time.Duration)} instead */
    @ObsoleteApi("Use setTotalTimeoutDuration(java.time.Duration) instead")
    public final Builder setTotalTimeout(org.threeten.bp.Duration totalTimeout) {
      return setTotalTimeoutDuration(toJavaTimeDuration(totalTimeout));
    }

    /**
     * TotalTimeout has ultimate control over how long the logic should keep trying the remote call
     * until it gives up completely. The higher the total timeout, the more retries and polls can be
     * attempted. If this value is {@code Duration.ZERO}, then the logic will instead use the number
     * of attempts to determine retries. In the event that both maxAttempts and totalTimeout values
     * are both 0, the logic will not retry. If this value is non-{@code Duration.ZERO}, and the
     * retry duration has reaches the timeout value, the logic will give up retrying even the number
     * of attempts is lower than the maxAttempts value.
     *
     * <p>If there are no configurations, Retries have the default timeout value of {@code
     * Duration.ZERO} and LROs have a default total timeout value of {@code
     * Duration.ofMillis(300000)} (5 minutes).
     */
    public abstract Builder setTotalTimeoutDuration(java.time.Duration totalTimeout);

    /**
     * This method is obsolete. Use {@link #setInitialRetryDelayDuration(java.time.Duration)}
     * instead
     */
    @ObsoleteApi("Use setInitialRetryDelayDuration(java.time.Duration) instead")
    public final Builder setInitialRetryDelay(org.threeten.bp.Duration initialDelay) {
      return setInitialRetryDelayDuration(toJavaTimeDuration(initialDelay));
    }

    /**
     * InitialRetryDelay controls the delay before the first retry/ poll. Subsequent retries and
     * polls will use this value adjusted according to the RetryDelayMultiplier.
     *
     * <p>If there are no configurations, Retries have the default initial retry delay value of
     * {@code Duration.ZERO} and LROs have a default initial poll delay value of {@code
     * Duration.ofMillis(5000)} (5 seconds).
     */
    public abstract Builder setInitialRetryDelayDuration(java.time.Duration initialDelay);

    /**
     * RetryDelayMultiplier controls the change in delay before the next retry or poll. The retry
     * delay of the previous call is multiplied by the RetryDelayMultiplier to calculate the retry
     * delay for the next call.
     *
     * <p>If there are no configurations, Retries have the default retry delay multiplier value of
     * {@code 1.0} and LROs have a default retry delay multiplier of {@code 1.5}.
     */
    public abstract Builder setRetryDelayMultiplier(double multiplier);

    /**
     * This method is obsolete. Use {@link #setMaxRetryDelayDuration(java.time.Duration)} instead
     */
    @ObsoleteApi("Use setMaxRetryDelayDuration(java.time.Duration) instead")
    public final Builder setMaxRetryDelay(org.threeten.bp.Duration maxDelay) {
      return setMaxRetryDelayDuration(toJavaTimeDuration(maxDelay));
    }

    /**
     * MaxRetryDelay puts a limit on the value of the retry delay, so that the RetryDelayMultiplier
     * can't increase the retry delay higher than this amount.
     *
     * <p>If there are no configurations, Retries have the default max retry delay value of {@code
     * Duration.ZERO} and LROs have a default max poll retry delay value of {@code
     * Duration.ofMillis(45000)} (45 seconds).
     */
    public abstract Builder setMaxRetryDelayDuration(java.time.Duration maxDelay);

    /**
     * MaxAttempts defines the maximum number of retry attempts to perform. If this value is set to
     * 0, the logic will instead use the totalTimeout value to determine retries. In the event that
     * both the maxAttempts and totalTimeout values are both 0, the logic will not retry. If this
     * value is greater than 0, and the number of attempts exceeds this limit, the logic will give
     * up retrying even if the total retry time is still lower than totalTimeout.
     *
     * <p>If there are no configurations, Retries and LROs have the default max attempt value of
     * {@code 0}. LRO polling does not use this value by default.
     *
     * <p>The first RPC invocation will be considered attempt #0. Subsequent calls (retries) will
     * increment the number of attempts and the number of attempts will not exceed this value.
     */
    public abstract Builder setMaxAttempts(int maxAttempts);

    /**
     * Jitter determines if the delay time should be randomized. If jitter is set to {@code true}
     * the actual delay time is calculated in the following way:
     *
     * <pre>{@code actualDelay = rand_between(0, min(maxRetryDelay, exponentialDelay))}</pre>
     *
     * The default value is {@code true}, and this method will be a no-op soon.
     *
     * @deprecated Retries always jitter.
     */
    @Deprecated
    @VisibleForTesting
    public abstract Builder setJittered(boolean jittered);

    /**
     * This method is obsolete. Use {@link #setInitialRpcTimeoutDuration(java.time.Duration)}
     * instead
     */
    @ObsoleteApi("Use setInitialRpcTimeoutDuration(java.time.Duration) instead")
    public final Builder setInitialRpcTimeout(org.threeten.bp.Duration initialTimeout) {
      return setInitialRpcTimeoutDuration(toJavaTimeDuration(initialTimeout));
    }

    /**
     * InitialRpcTimeout controls the timeout for the initial RPC. Subsequent calls will use this
     * value adjusted according to the RpcTimeoutMultiplier. RPC Timeout value of {@code
     * Duration.ZERO} allows the RPC to continue indefinitely (until it hits a Connect Timeout or
     * the connection has been terminated).
     *
     * <p>{@link #getTotalTimeout()} caps how long the logic should keep trying the RPC until it
     * gives up completely. If {@link #getTotalTimeout()} is set, initialRpcTimeout should be <=
     * totalTimeout.
     *
     * <p>If there are no configurations, Retries have the default initial RPC timeout value of
     * {@code Duration.ZERO}. LRO polling does not use the Initial RPC Timeout value.
     */
    public abstract Builder setInitialRpcTimeoutDuration(java.time.Duration initialTimeout);

    /**
     * RpcTimeoutMultiplier controls the change in RPC timeout. The timeout of the previous call is
     * multiplied by the RpcTimeoutMultiplier to calculate the timeout for the next call.
     *
     * <p>If there are no configurations, Retries have the default RPC Timeout Multiplier value of
     * {@code 1.0}. LRO polling does not use the RPC Timeout Multiplier value.
     */
    public abstract Builder setRpcTimeoutMultiplier(double multiplier);

    /**
     * This method is obsolete. Use {@link #setMaxRpcTimeoutDuration(java.time.Duration)} instead
     */
    @ObsoleteApi("Use setMaxRpcTimeoutDuration(java.time.Duration) instead")
    public final Builder setMaxRpcTimeout(org.threeten.bp.Duration maxTimeout) {
      return setMaxRpcTimeoutDuration(toJavaTimeDuration(maxTimeout));
    }

    /**
     * MaxRpcTimeout puts a limit on the value of the RPC timeout, so that the RpcTimeoutMultiplier
     * can't increase the RPC timeout higher than this amount.
     *
     * <p>If there are no configurations, Retries have the default Max RPC Timeout value of {@code
     * Duration.ZERO}. LRO polling does not use the Max RPC Timeout value.
     */
    public abstract Builder setMaxRpcTimeoutDuration(java.time.Duration maxTimeout);

    /** This method is obsolete. Use {@link #getTotalTimeoutDuration()} instead */
    @ObsoleteApi("Use getTotalTimeoutDuration() instead")
    public final org.threeten.bp.Duration getTotalTimeout() {
      return toThreetenDuration(getTotalTimeoutDuration());
    }

    /**
     * TotalTimeout has ultimate control over how long the logic should keep trying the remote call
     * until it gives up completely. The higher the total timeout, the more retries and polls can be
     * attempted. If this value is {@code Duration.ZERO}, then the logic will instead use the number
     * of attempts to determine retries. In the event that both maxAttempts and totalTimeout values
     * are both 0, the logic will not retry. If this value is non-{@code Duration.ZERO}, and the
     * retry duration has reaches the timeout value, the logic will give up retrying even the number
     * of attempts is lower than the maxAttempts value.
     *
     * <p>If there are no configurations, Retries have the default timeout value of {@code
     * Duration.ZERO} and LROs have a default total timeout value of {@code
     * Duration.ofMillis(300000)} (5 minutes).
     */
    public abstract java.time.Duration getTotalTimeoutDuration();

    /** This method is obsolete. Use {@link #getInitialRetryDelayDuration()} instead */
    @ObsoleteApi("Use getInitialRetryDelayDuration() instead")
    public final org.threeten.bp.Duration getInitialRetryDelay() {
      return toThreetenDuration(getInitialRetryDelayDuration());
    }

    /**
     * InitialRetryDelay controls the delay before the first retry/ poll. Subsequent retries and
     * polls will use this value adjusted according to the RetryDelayMultiplier.
     *
     * <p>If there are no configurations, Retries have the default initial retry delay value of
     * {@code Duration.ZERO} and LROs have a default initial poll delay value of {@code
     * Duration.ofMillis(5000)} (5 seconds).
     */
    public abstract java.time.Duration getInitialRetryDelayDuration();

    /**
     * RetryDelayMultiplier controls the change in delay before the next retry or poll. The retry
     * delay of the previous call is multiplied by the RetryDelayMultiplier to calculate the retry
     * delay for the next call.
     *
     * <p>If there are no configurations, Retries have the default retry delay multiplier value of
     * {@code 1.0} and LROs have a default retry delay multiplier of {@code 1.5}.
     */
    public abstract double getRetryDelayMultiplier();

    /**
     * MaxAttempts defines the maximum number of retry attempts to perform. If this value is set to
     * 0, the logic will instead use the totalTimeout value to determine retries. In the event that
     * both the maxAttempts and totalTimeout values are both 0, the logic will not retry. If this
     * value is greater than 0, and the number of attempts exceeds this limit, the logic will give
     * up retrying even if the total retry time is still lower than totalTimeout.
     *
     * <p>If there are no configurations, Retries and LROs have the default max attempt value of
     * {@code 0}. LRO polling does not use this value by default.
     *
     * <p>The first RPC invocation will be considered attempt #0. Subsequent calls (retries) will
     * increment the number of attempts and the number of attempts will not exceed this value.
     */
    public abstract int getMaxAttempts();

    /**
     * Jitter determines if the delay time should be randomized. In most cases, if jitter is set to
     * {@code true} the actual delay time is calculated in the following way:
     *
     * <pre>{@code actualDelay = rand_between(0, min(maxRetryDelay, exponentialDelay))}</pre>
     *
     * The default value is {@code true}.
     */
    public abstract boolean isJittered();

    /** This method is obsolete. Use {@link #getMaxRetryDelayDuration()} instead */
    @ObsoleteApi("Use getMaxRetryDelayDuration() instead")
    public final org.threeten.bp.Duration getMaxRetryDelay() {
      return toThreetenDuration(getMaxRetryDelayDuration());
    }

    /**
     * MaxRetryDelay puts a limit on the value of the retry delay, so that the RetryDelayMultiplier
     * can't increase the retry delay higher than this amount.
     *
     * <p>If there are no configurations, Retries have the default max retry delay value of {@code
     * Duration.ZERO} and LROs have a default max poll retry delay value of {@code
     * Duration.ofMillis(45000)} (45 seconds).
     */
    public abstract java.time.Duration getMaxRetryDelayDuration();

    /** This method is obsolete. Use {@link #getInitialRpcTimeoutDuration()} instead */
    @ObsoleteApi("Use getInitialRpcTimeoutDuration() instead")
    public final org.threeten.bp.Duration getInitialRpcTimeout() {
      return toThreetenDuration(getInitialRpcTimeoutDuration());
    }

    /**
     * InitialRpcTimeout controls the timeout for the initial RPC. Subsequent calls will use this
     * value adjusted according to the RpcTimeoutMultiplier. RPC Timeout value of {@code
     * Duration.ZERO} allows the RPC to continue indefinitely (until it hits a Connect Timeout or
     * the connection has been terminated).
     *
     * <p>{@link #getTotalTimeout()} caps how long the logic should keep trying the RPC until it
     * gives up completely. If {@link #getTotalTimeout()} is set, initialRpcTimeout should be <=
     * totalTimeout.
     *
     * <p>If there are no configurations, Retries have the default initial RPC timeout value of
     * {@code Duration.ZERO}. LRO polling does not use the Initial RPC Timeout value.
     */
    public abstract java.time.Duration getInitialRpcTimeoutDuration();

    /**
     * RpcTimeoutMultiplier controls the change in RPC timeout. The timeout of the previous call is
     * multiplied by the RpcTimeoutMultiplier to calculate the timeout for the next call.
     *
     * <p>If there are no configurations, Retries have the default RPC Timeout Multiplier value of
     * {@code 1.0}. LRO polling does not use the RPC Timeout Multiplier value.
     */
    public abstract double getRpcTimeoutMultiplier();

    /** This method is obsolete. Use {@link #getMaxRpcTimeoutDuration()} instead */
    @ObsoleteApi("Use getMaxRpcTimeoutDuration() instead")
    public final org.threeten.bp.Duration getMaxRpcTimeout() {
      return toThreetenDuration(getMaxRpcTimeoutDuration());
    }

    /**
     * MaxRpcTimeout puts a limit on the value of the RPC timeout, so that the RpcTimeoutMultiplier
     * can't increase the RPC timeout higher than this amount.
     *
     * <p>If there are no configurations, Retries have the default Max RPC Timeout value of {@code
     * Duration.ZERO}. LRO polling does not use the Max RPC Timeout value.
     */
    public abstract java.time.Duration getMaxRpcTimeoutDuration();

    /** This method is obsolete. Use {@link #setLogicalTimeout(java.time.Duration)} instead. */
    @BetaApi
    @ObsoleteApi("Use setLogicalTimeout(java.time.Duration) instead")
    public Builder setLogicalTimeout(org.threeten.bp.Duration timeout) {
      return setLogicalTimeout(toJavaTimeDuration(timeout));
    }

    /**
     * Configures the timeout settings with the given timeout such that the logical call will take
     * no longer than the given timeout and each RPC attempt will use only the time remaining in the
     * logical call as a timeout.
     *
     * <p>Using this method in conjunction with individual {@link RetrySettings} timeout field
     * setters is not advised, because only the order in which they are invoked determines which
     * setter is respected.
     */
    @BetaApi
    public Builder setLogicalTimeout(java.time.Duration timeout) {
      return setRpcTimeoutMultiplier(1)
          .setInitialRpcTimeoutDuration(timeout)
          .setMaxRpcTimeoutDuration(timeout)
          .setTotalTimeoutDuration(timeout);
    }

    abstract RetrySettings autoBuild();

    public RetrySettings build() {
      RetrySettings params = autoBuild();
      if (params.getTotalTimeoutDuration().toMillis() < 0) {
        throw new IllegalStateException("total timeout must not be negative");
      }
      if (params.getInitialRetryDelayDuration().toMillis() < 0) {
        throw new IllegalStateException("initial retry delay must not be negative");
      }
      if (params.getRetryDelayMultiplier() < 1.0) {
        throw new IllegalStateException("retry delay multiplier must be at least 1");
      }
      if (params.getMaxRetryDelayDuration().compareTo(params.getInitialRetryDelayDuration()) < 0) {
        throw new IllegalStateException("max retry delay must not be shorter than initial delay");
      }
      if (params.getMaxAttempts() < 0) {
        throw new IllegalStateException("max attempts must be non-negative");
      }
      if (params.getInitialRpcTimeoutDuration().toMillis() < 0) {
        throw new IllegalStateException("initial rpc timeout must not be negative");
      }
      if (params.getMaxRpcTimeoutDuration().compareTo(params.getInitialRpcTimeoutDuration()) < 0) {
        throw new IllegalStateException("max rpc timeout must not be shorter than initial timeout");
      }
      if (params.getRpcTimeoutMultiplier() < 1.0) {
        throw new IllegalStateException("rpc timeout multiplier must be at least 1");
      }
      return params;
    }

    public RetrySettings.Builder merge(RetrySettings.Builder newSettings) {
      if (newSettings.getTotalTimeoutDuration() != null) {
        setTotalTimeoutDuration(newSettings.getTotalTimeoutDuration());
      }
      if (newSettings.getInitialRetryDelayDuration() != null) {
        setInitialRetryDelayDuration(newSettings.getInitialRetryDelayDuration());
      }
      if (newSettings.getRetryDelayMultiplier() >= 1) {
        setRetryDelayMultiplier(newSettings.getRetryDelayMultiplier());
      }
      if (newSettings.getMaxRetryDelayDuration() != null) {
        setMaxRetryDelayDuration(newSettings.getMaxRetryDelayDuration());
      }
      setMaxAttempts(newSettings.getMaxAttempts());
      setJittered(newSettings.isJittered());
      if (newSettings.getInitialRpcTimeoutDuration() != null) {
        setInitialRpcTimeoutDuration(newSettings.getInitialRpcTimeoutDuration());
      }
      if (newSettings.getRpcTimeoutMultiplier() >= 1) {
        setRpcTimeoutMultiplier(newSettings.getRpcTimeoutMultiplier());
      }
      if (newSettings.getMaxRpcTimeoutDuration() != null) {
        setMaxRpcTimeoutDuration(newSettings.getMaxRpcTimeoutDuration());
      }
      return this;
    }
  }
}
