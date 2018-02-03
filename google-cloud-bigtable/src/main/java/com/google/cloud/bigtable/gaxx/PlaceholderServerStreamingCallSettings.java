/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.gaxx;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import java.util.Set;
import org.threeten.bp.Duration;

/**
 * Placeholder for code in the unmerged PR: https://github.com/googleapis/gax-java/pull/463
 *
 * <p>This class will be replaced by the ServerStreamingCallSettings defined there.
 */
public final class PlaceholderServerStreamingCallSettings<RequestT, ResponseT>
    extends StreamingCallSettings<RequestT, ResponseT> {

  private final Set<Code> retryableCodes;
  private final RetrySettings retrySettings;

  private final Duration timeoutCheckInterval;
  private final Duration idleTimeout;

  private PlaceholderServerStreamingCallSettings(Builder<RequestT, ResponseT> builder) {
    this.retryableCodes = ImmutableSet.copyOf(builder.retryableCodes);
    this.retrySettings = builder.retrySettings;
    this.timeoutCheckInterval = builder.timeoutCheckInterval;
    this.idleTimeout = builder.idleTimeout;
  }

  public Set<Code> getRetryableCodes() {
    return retryableCodes;
  }

  public RetrySettings getRetrySettings() {
    return retrySettings;
  }

  public Duration getTimeoutCheckInterval() {
    return timeoutCheckInterval;
  }

  public Duration getIdleTimeout() {
    return idleTimeout;
  }

  public Builder<RequestT, ResponseT> toBuilder() {
    return new Builder<>(this);
  }

  public static <RequestT, ResponseT> Builder<RequestT, ResponseT> newBuilder() {
    return new Builder<>();
  }

  public static class Builder<RequestT, ResponseT>
      extends StreamingCallSettings.Builder<RequestT, ResponseT> {
    private Set<Code> retryableCodes;
    private RetrySettings retrySettings;

    private Duration timeoutCheckInterval;
    private Duration idleTimeout;

    private Builder() {
      this.retryableCodes = ImmutableSet.of();
      this.retrySettings = RetrySettings.newBuilder().build();

      this.timeoutCheckInterval = Duration.ZERO;
      this.idleTimeout = Duration.ZERO;
    }

    private Builder(PlaceholderServerStreamingCallSettings<RequestT, ResponseT> settings) {
      super(settings);
      this.retryableCodes = settings.retryableCodes;
      this.retrySettings = settings.retrySettings;

      this.timeoutCheckInterval = settings.timeoutCheckInterval;
      this.idleTimeout = settings.idleTimeout;
    }

    public Builder<RequestT, ResponseT> setRetryableCodes(StatusCode.Code... codes) {
      this.setRetryableCodes(Sets.newHashSet(codes));
      return this;
    }

    public Builder<RequestT, ResponseT> setRetryableCodes(Set<Code> retryableCodes) {
      this.retryableCodes = Sets.newHashSet(retryableCodes);
      return this;
    }

    public Set<Code> getRetryableCodes() {
      return retryableCodes;
    }

    public Builder<RequestT, ResponseT> setRetrySettings(RetrySettings retrySettings) {
      this.retrySettings = retrySettings;
      return this;
    }

    public RetrySettings getRetrySettings() {
      return retrySettings;
    }

    public Builder<RequestT, ResponseT> setSimpleTimeoutNoRetries(Duration timeout) {
      setRetryableCodes();
      setRetrySettings(
          RetrySettings.newBuilder()
              .setTotalTimeout(timeout)
              .setInitialRetryDelay(Duration.ZERO)
              .setRetryDelayMultiplier(1)
              .setMaxRetryDelay(Duration.ZERO)
              .setInitialRpcTimeout(timeout)
              .setRpcTimeoutMultiplier(1)
              .setMaxRpcTimeout(timeout)
              .setMaxAttempts(1)
              .build());

      // enable watchdog
      Duration checkInterval = Ordering.natural().max(timeout.dividedBy(2), Duration.ofSeconds(10));
      setTimeoutCheckInterval(checkInterval);

      return this;
    }

    public Duration getTimeoutCheckInterval() {
      return timeoutCheckInterval;
    }

    public Builder<RequestT, ResponseT> setTimeoutCheckInterval(Duration timeoutCheckInterval) {
      this.timeoutCheckInterval = timeoutCheckInterval;
      return this;
    }

    public Duration getIdleTimeout() {
      return idleTimeout;
    }

    public Builder<RequestT, ResponseT> setIdleTimeout(Duration idleTimeout) {
      this.idleTimeout = idleTimeout;
      return this;
    }

    @Override
    public PlaceholderServerStreamingCallSettings<RequestT, ResponseT> build() {
      return new PlaceholderServerStreamingCallSettings<>(this);
    }
  }
}
