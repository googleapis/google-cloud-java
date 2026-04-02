/*
 * Copyright 2017 Google LLC
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
package com.google.api.gax.rpc;

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;
import static com.google.api.gax.util.TimeConversionUtils.toThreetenDuration;

import com.google.api.core.ObsoleteApi;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.SimpleStreamResumptionStrategy;
import com.google.api.gax.retrying.StreamResumptionStrategy;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.time.Duration;
import java.util.Set;
import javax.annotation.Nonnull;

/**
 * A settings class to configure a {@link ServerStreamingCallable}.
 *
 * <p>This class includes settings that are applicable to all server streaming calls, which
 * currently just includes retries and watchdog timers.
 *
 * <p>The watchdog timer is configured via {@code idleTimeout} and {@code waitTimeout}. The watchdog
 * will terminate any stream that has not has seen any demand (via {@link
 * StreamController#request(int)}) in the configured interval or has not seen a message from the
 * server in {@code waitTimeout}. To turn off idle checks, set the interval to {@link
 * java.time.Duration#ZERO}.
 *
 * <p>Retry configuration allows for the stream to be restarted and resumed. It is composed of 3
 * parts: the retryable codes, the retry settings and the stream resumption strategy. The retryable
 * codes indicate which codes cause a retry to occur, the retry settings configure the retry logic
 * when the retry needs to happen, and the stream resumption strategy composes the request to resume
 * the stream. To turn off retries, set the retryable codes to the empty set.
 *
 * <p>The retry settings have slightly different semantics when compared to unary RPCs:
 *
 * <ul>
 *   <li>retry delays are reset to the initial value as soon as a response is received.
 *   <li>RPC timeouts are reset to the initial value as soon as a response is received.
 *   <li>RPC timeouts apply to the time interval between caller demanding more responses via {@link
 *       StreamController#request(int)} and the {@link ResponseObserver} receiving the message.
 *   <li>RPC timeouts are best effort and are checked once every {@link
 *       StubSettings#getStreamWatchdogCheckIntervalDuration()}.
 *   <li>Attempt counts are reset as soon as a response is received. This means that max attempts is
 *       the maximum number of failures in a row.
 *   <li>totalTimeout still applies to the entire stream.
 * </ul>
 */
public final class ServerStreamingCallSettings<RequestT, ResponseT>
    extends StreamingCallSettings<RequestT, ResponseT> {

  @Nonnull private final Set<Code> retryableCodes;
  @Nonnull private final RetrySettings retrySettings;
  @Nonnull private final StreamResumptionStrategy<RequestT, ResponseT> resumptionStrategy;

  @Nonnull private final java.time.Duration idleTimeout;
  @Nonnull private final java.time.Duration waitTimeout;

  private ServerStreamingCallSettings(Builder<RequestT, ResponseT> builder) {
    this.retryableCodes = ImmutableSet.copyOf(builder.retryableCodes);
    this.retrySettings = builder.retrySettingsBuilder.build();
    this.resumptionStrategy = builder.resumptionStrategy;
    this.idleTimeout = builder.idleTimeout;
    this.waitTimeout = builder.waitTimeout;
  }

  /**
   * See the class documentation of {@link ServerStreamingCallSettings} for a description of what
   * retryableCodes do.
   */
  @Nonnull
  public Set<Code> getRetryableCodes() {
    return retryableCodes;
  }

  /**
   * See the class documentation of {@link ServerStreamingCallSettings} for a description of what
   * retrySettings do.
   */
  @Nonnull
  public RetrySettings getRetrySettings() {
    return retrySettings;
  }

  /**
   * See the class documentation of {@link ServerStreamingCallSettings} and {@link
   * StreamResumptionStrategy} for a description of what the StreamResumptionStrategy does.
   */
  @Nonnull
  public StreamResumptionStrategy<RequestT, ResponseT> getResumptionStrategy() {
    return resumptionStrategy;
  }

  /** This method is obsolete. Use {@link #getIdleTimeoutDuration()} instead. */
  @Nonnull
  @ObsoleteApi("Use getIdleTimeoutDuration() instead")
  public org.threeten.bp.Duration getIdleTimeout() {
    return toThreetenDuration(getIdleTimeoutDuration());
  }

  /**
   * See the class documentation of {@link ServerStreamingCallSettings} for a description of what
   * the {@link #idleTimeout} does.
   */
  @Nonnull
  public java.time.Duration getIdleTimeoutDuration() {
    return idleTimeout;
  }

  /** This method is obsolete. Use {@link #getWaitTimeoutDuration()} instead. */
  @Nonnull
  @ObsoleteApi("Use getWaitTimeoutDuration() instead")
  public org.threeten.bp.Duration getWaitTimeout() {
    return toThreetenDuration(getWaitTimeoutDuration());
  }

  /**
   * See the class documentation of {@link ServerStreamingCallSettings} for a description of what
   * the {@link #waitTimeout} does.
   */
  @Nonnull
  public java.time.Duration getWaitTimeoutDuration() {
    return waitTimeout;
  }

  public Builder<RequestT, ResponseT> toBuilder() {
    return new Builder<>(this);
  }

  public static <RequestT, ResponseT> Builder<RequestT, ResponseT> newBuilder() {
    return new Builder<>();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("idleTimeout", idleTimeout)
        .add("waitTimeout", waitTimeout)
        .add("retryableCodes", retryableCodes)
        .add("retrySettings", retrySettings)
        .toString();
  }

  public static class Builder<RequestT, ResponseT>
      extends StreamingCallSettings.Builder<RequestT, ResponseT> {
    @Nonnull private Set<StatusCode.Code> retryableCodes;
    @Nonnull private RetrySettings.Builder retrySettingsBuilder;
    @Nonnull private StreamResumptionStrategy<RequestT, ResponseT> resumptionStrategy;

    @Nonnull private java.time.Duration idleTimeout;

    @Nonnull private java.time.Duration waitTimeout;

    /** Initialize the builder with default settings */
    private Builder() {
      this.retryableCodes = ImmutableSet.of();
      this.retrySettingsBuilder = RetrySettings.newBuilder();
      this.resumptionStrategy = new SimpleStreamResumptionStrategy<>();

      this.idleTimeout = java.time.Duration.ZERO;
      this.waitTimeout = java.time.Duration.ZERO;
    }

    private Builder(ServerStreamingCallSettings<RequestT, ResponseT> settings) {
      super(settings);
      this.retryableCodes = settings.retryableCodes;
      this.retrySettingsBuilder = settings.retrySettings.toBuilder();
      this.resumptionStrategy = settings.resumptionStrategy;

      this.idleTimeout = settings.idleTimeout;
      this.waitTimeout = settings.waitTimeout;
    }

    /**
     * See the class documentation of {@link ServerStreamingCallSettings} for a description of what
     * retryableCodes do.
     */
    public Builder<RequestT, ResponseT> setRetryableCodes(StatusCode.Code... codes) {
      this.setRetryableCodes(Sets.newHashSet(codes));
      return this;
    }

    /**
     * See the class documentation of {@link ServerStreamingCallSettings} for a description of what
     * retryableCodes do.
     */
    public Builder<RequestT, ResponseT> setRetryableCodes(Set<Code> retryableCodes) {
      Preconditions.checkNotNull(retryableCodes);
      this.retryableCodes = Sets.newHashSet(retryableCodes);
      return this;
    }

    @Nonnull
    public Set<Code> getRetryableCodes() {
      return retryableCodes;
    }

    /**
     * Returns the underlying {@link RetrySettings.Builder}, which allows callers to augment the
     * existing {@link RetrySettings}.
     */
    public RetrySettings.Builder retrySettings() {
      return this.retrySettingsBuilder;
    }

    /**
     * Replaces the {@link RetrySettings} for the associated {@link ServerStreamingCallable}.
     *
     * <p>When using the method, make sure that the {@link RetrySettings} are complete. For example,
     * the following code will disable retries because the retry delay is not set:
     *
     * <pre>{@code
     * stubSettings.setRetrySettings(
     *   RetrySettings.newBuilder()
     *     .setTotalTimeout(Duration.ofSeconds(10)
     * );
     * }</pre>
     *
     * @see #retrySettings()
     */
    public Builder<RequestT, ResponseT> setRetrySettings(@Nonnull RetrySettings retrySettings) {
      Preconditions.checkNotNull(retrySettings);
      this.retrySettingsBuilder = retrySettings.toBuilder();
      return this;
    }

    @Nonnull
    public RetrySettings getRetrySettings() {
      return retrySettingsBuilder.build();
    }

    /**
     * This method is obsolete. Use {@link #setSimpleTimeoutNoRetriesDuration(java.time.Duration)}
     * instead.
     */
    @ObsoleteApi("Use setSimpleTimeoutNoRetriesDuration(java.time.Duration) instead")
    public Builder<RequestT, ResponseT> setSimpleTimeoutNoRetries(
        @Nonnull org.threeten.bp.Duration timeout) {
      return setSimpleTimeoutNoRetriesDuration(toJavaTimeDuration(timeout));
    }

    /** Disables retries and sets the overall timeout. */
    public Builder<RequestT, ResponseT> setSimpleTimeoutNoRetriesDuration(
        @Nonnull java.time.Duration timeout) {
      setRetryableCodes();
      setRetrySettings(
          RetrySettings.newBuilder()
              .setTotalTimeoutDuration(timeout)
              .setInitialRetryDelayDuration(java.time.Duration.ZERO)
              .setRetryDelayMultiplier(1)
              .setMaxRetryDelayDuration(java.time.Duration.ZERO)
              .setInitialRpcTimeoutDuration(timeout)
              .setRpcTimeoutMultiplier(1)
              .setMaxRpcTimeoutDuration(timeout)
              .setMaxAttempts(1)
              .build());

      return this;
    }

    /**
     * See the class documentation of {@link ServerStreamingCallSettings} for a description of what
     * StreamResumptionStrategy does.
     */
    public Builder<RequestT, ResponseT> setResumptionStrategy(
        @Nonnull StreamResumptionStrategy<RequestT, ResponseT> resumptionStrategy) {
      Preconditions.checkNotNull(resumptionStrategy);
      this.resumptionStrategy = Preconditions.checkNotNull(resumptionStrategy);
      return this;
    }

    @Nonnull
    public StreamResumptionStrategy<RequestT, ResponseT> getResumptionStrategy() {
      return resumptionStrategy;
    }

    /** This method is obsolete. Use {@link #getIdleTimeoutDuration()} instead. */
    @Nonnull
    @ObsoleteApi("Use getIdleTimeoutDuration() instead")
    public org.threeten.bp.Duration getIdleTimeout() {
      return toThreetenDuration(getIdleTimeoutDuration());
    }

    @Nonnull
    public java.time.Duration getIdleTimeoutDuration() {
      return idleTimeout;
    }

    /** This method is obsolete. Use {@link #setIdleTimeoutDuration(Duration)} instead. */
    @ObsoleteApi("Use setIdleTimeoutDuration(java.time.Duration) instead")
    public Builder<RequestT, ResponseT> setIdleTimeout(
        @Nonnull org.threeten.bp.Duration idleTimeout) {
      return setIdleTimeoutDuration(toJavaTimeDuration(idleTimeout));
    }

    /**
     * Set how long to wait before considering the stream orphaned by the user and closing it.
     * {@link java.time.Duration#ZERO} disables the check for abandoned streams.
     */
    public Builder<RequestT, ResponseT> setIdleTimeoutDuration(
        @Nonnull java.time.Duration idleTimeout) {
      this.idleTimeout = Preconditions.checkNotNull(idleTimeout);
      return this;
    }

    /** This method is obsolete. Use {@link #getWaitTimeoutDuration()} instead. */
    @Nonnull
    @ObsoleteApi("Use getWaitTimeoutDuration() instead")
    public org.threeten.bp.Duration getWaitTimeout() {
      return toThreetenDuration(getWaitTimeoutDuration());
    }

    @Nonnull
    public java.time.Duration getWaitTimeoutDuration() {
      return waitTimeout;
    }

    /** This method is obsolete. Use {@link #setWaitTimeoutDuration(java.time.Duration)} instead. */
    @ObsoleteApi("Use setWaitTimeoutDuration(java.time.Duration) instead")
    public Builder<RequestT, ResponseT> setWaitTimeout(
        @Nonnull org.threeten.bp.Duration waitTimeout) {
      return setWaitTimeoutDuration(toJavaTimeDuration(waitTimeout));
    }

    /**
     * Set the maximum amount of time to wait for the next message from the server. {@link
     * java.time.Duration#ZERO} disables the check for abandoned streams.
     */
    public Builder<RequestT, ResponseT> setWaitTimeoutDuration(
        @Nonnull java.time.Duration waitTimeout) {
      this.waitTimeout = waitTimeout;
      return this;
    }

    @Override
    public ServerStreamingCallSettings<RequestT, ResponseT> build() {
      return new ServerStreamingCallSettings<>(this);
    }
  }
}
