/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.grpc.fallback;

import static io.grpc.Status.Code.DEADLINE_EXCEEDED;
import static io.grpc.Status.Code.UNAUTHENTICATED;
import static io.grpc.Status.Code.UNAVAILABLE;

import io.grpc.Channel;
import io.grpc.Status;
import java.time.Duration;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.Function;

public class GcpFallbackChannelOptions {
  private final boolean enableFallback;
  private final float errorRateThreshold;
  private final Set<Status.Code> erroneousStates;
  private final Duration period;
  private final int minFailedCalls;
  private final Function<Channel, String> primaryProbingFunction;
  private final Function<Channel, String> fallbackProbingFunction;
  private final Duration primaryProbingInterval;
  private final Duration fallbackProbingInterval;
  private final String primaryChannelName;
  private final String fallbackChannelName;
  private final GcpFallbackOpenTelemetry openTelemetry;

  public GcpFallbackChannelOptions(Builder builder) {
    this.enableFallback = builder.enableFallback;
    this.errorRateThreshold = builder.errorRateThreshold;
    this.erroneousStates = builder.erroneousStates;
    this.period = builder.period;
    this.minFailedCalls = builder.minFailedCalls;
    this.primaryProbingFunction = builder.primaryProbingFunction;
    this.fallbackProbingFunction = builder.fallbackProbingFunction;
    this.primaryProbingInterval = builder.primaryProbingInterval;
    this.fallbackProbingInterval = builder.fallbackProbingInterval;
    this.primaryChannelName = builder.primaryChannelName;
    this.fallbackChannelName = builder.fallbackChannelName;
    this.openTelemetry = builder.openTelemetry;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public boolean isEnableFallback() {
    return enableFallback;
  }

  public float getErrorRateThreshold() {
    return errorRateThreshold;
  }

  public Set<Status.Code> getErroneousStates() {
    return erroneousStates;
  }

  public Duration getPeriod() {
    return period;
  }

  public int getMinFailedCalls() {
    return minFailedCalls;
  }

  public Function<Channel, String> getPrimaryProbingFunction() {
    return primaryProbingFunction;
  }

  public Function<Channel, String> getFallbackProbingFunction() {
    return fallbackProbingFunction;
  }

  public Duration getPrimaryProbingInterval() {
    return primaryProbingInterval;
  }

  public Duration getFallbackProbingInterval() {
    return fallbackProbingInterval;
  }

  public String getPrimaryChannelName() {
    return primaryChannelName;
  }

  public String getFallbackChannelName() {
    return fallbackChannelName;
  }

  public GcpFallbackOpenTelemetry getGcpOpenTelemetry() {
    return openTelemetry;
  }

  public static class Builder {
    private boolean enableFallback = true;
    private float errorRateThreshold = 1f;
    private Set<Status.Code> erroneousStates =
        EnumSet.of(UNAVAILABLE, DEADLINE_EXCEEDED, UNAUTHENTICATED);
    private Duration period = Duration.ofMinutes(1);
    private int minFailedCalls = 3;

    private Function<Channel, String> primaryProbingFunction = null;
    private Function<Channel, String> fallbackProbingFunction = null;

    private Duration primaryProbingInterval = Duration.ofMinutes(1);
    private Duration fallbackProbingInterval = Duration.ofMinutes(15);

    private String primaryChannelName = "primary";
    private String fallbackChannelName = "fallback";

    private GcpFallbackOpenTelemetry openTelemetry = null;

    public Builder() {}

    public static Builder newBuilder() {
      return new Builder();
    }

    public Builder setEnableFallback(boolean enableFallback) {
      this.enableFallback = enableFallback;
      return this;
    }

    public Builder setErrorRateThreshold(float errorRateThreshold) {
      this.errorRateThreshold = errorRateThreshold;
      return this;
    }

    public Builder setErroneousStates(Set<Status.Code> erroneousStates) {
      this.erroneousStates = erroneousStates;
      return this;
    }

    public Builder setPeriod(Duration period) {
      this.period = period;
      return this;
    }

    public Builder setMinFailedCalls(int minFailedCalls) {
      this.minFailedCalls = minFailedCalls;
      return this;
    }

    public Builder setProbingFunction(Function<Channel, String> probingFunction) {
      this.primaryProbingFunction = probingFunction;
      this.fallbackProbingFunction = probingFunction;
      return this;
    }

    public Builder setPrimaryProbingFunction(Function<Channel, String> primaryProbingFunction) {
      this.primaryProbingFunction = primaryProbingFunction;
      return this;
    }

    public Builder setFallbackProbingFunction(Function<Channel, String> fallbackProbingFunction) {
      this.fallbackProbingFunction = fallbackProbingFunction;
      return this;
    }

    public Builder setPrimaryProbingInterval(Duration primaryProbingInterval) {
      this.primaryProbingInterval = primaryProbingInterval;
      return this;
    }

    public Builder setFallbackProbingInterval(Duration fallbackProbingInterval) {
      this.fallbackProbingInterval = fallbackProbingInterval;
      return this;
    }

    public Builder setPrimaryChannelName(String primaryChannelName) {
      this.primaryChannelName = primaryChannelName;
      return this;
    }

    public Builder setFallbackChannelName(String fallbackChannelName) {
      this.fallbackChannelName = fallbackChannelName;
      return this;
    }

    public Builder setGcpFallbackOpenTelemetry(GcpFallbackOpenTelemetry openTelemetry) {
      this.openTelemetry = openTelemetry;
      return this;
    }

    public GcpFallbackChannelOptions build() {
      return new GcpFallbackChannelOptions(this);
    }
  }
}
