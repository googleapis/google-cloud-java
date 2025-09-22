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
package com.google.cloud.bigtable.gaxx.grpc;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.ChannelPoolSettings;
import com.google.auto.value.AutoValue;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.time.Duration;
import java.util.logging.Logger;

/**
 * Settings to control {@link BigtableChannelPool} behavior.
 *
 * <p>To facilitate low latency/high throughout applications, gax provides a {@link
 * BigtableChannelPool}. The pool is meant to facilitate high throughput/low latency clients. By
 * splitting load across multiple gRPC channels the client can spread load across multiple frontends
 * and overcome gRPC's limit of 100 concurrent RPCs per channel. However oversizing the {@link
 * BigtableChannelPool} can lead to underutilized channels which will lead to high tail latency due
 * to GFEs disconnecting idle channels.
 *
 * <p>The {@link BigtableChannelPool} is designed to adapt to varying traffic patterns by tracking
 * outstanding RPCs and resizing the pool size. This class configures the behavior. In general
 * clients should aim to have less than 50 concurrent RPCs per channel and at least 1 outstanding
 * per channel per minute.
 *
 * <p>The settings in this class will be applied every minute.
 */
@BetaApi("surface for channel pool sizing is not yet stable")
@AutoValue
public abstract class BigtableChannelPoolSettings {
  @VisibleForTesting
  static final Logger LOG = Logger.getLogger(BigtableChannelPoolSettings.class.getName());

  /** How often to check and possibly resize the {@link BigtableChannelPool}. */
  static final Duration RESIZE_INTERVAL = Duration.ofMinutes(1);

  /** The maximum number of channels that can be added or removed at a time. */
  static final int MAX_RESIZE_DELTA = 2;

  /** Environment variable used to set load balancing strategy. */
  private static final String CBT_LOAD_BALANCING_STRATEGY_ENV_VAR = "CBT_LOAD_BALANCING_STRATEGY";

  /** Load balancing strategy to use if environment variable is unset or invalid. */
  private static final LoadBalancingStrategy DEFAULT_LOAD_BALANCING_STRATEGY =
      LoadBalancingStrategy.ROUND_ROBIN;

  /** Supported load-balancing strategies. */
  public enum LoadBalancingStrategy {
    // Sequentially iterate across all channels.
    ROUND_ROBIN,
    // Pick the channel with the fewest in-flight requests. If multiple channels match, pick at
    // random.
    LEAST_IN_FLIGHT,
    // Out of two random channels, pick the channel with the fewest in-flight requests.
    POWER_OF_TWO_LEAST_IN_FLIGHT,
  }

  /**
   * Threshold to start scaling down the channel pool.
   *
   * <p>When the average of the maximum number of outstanding RPCs in a single minute drop below
   * this threshold, channels will be removed from the pool.
   */
  public abstract int getMinRpcsPerChannel();

  /**
   * Threshold to start scaling up the channel pool.
   *
   * <p>When the average of the maximum number of outstanding RPCs in a single minute surpass this
   * threshold, channels will be added to the pool. For google services, gRPC channels will start
   * locally queuing RPC when there are 100 concurrent RPCs.
   */
  public abstract int getMaxRpcsPerChannel();

  /**
   * The absolute minimum size of the channel pool.
   *
   * <p>Regardless of the current throughput, the number of channels will not drop below this limit
   */
  public abstract int getMinChannelCount();

  /**
   * The absolute maximum size of the channel pool.
   *
   * <p>Regardless of the current throughput, the number of channels will not exceed this limit
   */
  public abstract int getMaxChannelCount();

  /**
   * The initial size of the channel pool.
   *
   * <p>During client construction the client open this many connections. This will be scaled up or
   * down in the next period.
   */
  public abstract int getInitialChannelCount();

  /**
   * If all of the channels should be replaced on an hourly basis.
   *
   * <p>The GFE will forcibly disconnect active channels after an hour. To minimize the cost of
   * reconnects, this will create a new channel asynchronuously, prime it and then swap it with an
   * old channel.
   */
  public abstract boolean isPreemptiveRefreshEnabled();

  /** The load balancing strategy to use for distributing RPCs across channels. */
  @InternalApi("Use CBT_LOAD_BALANCING_STRATEGY environment variable")
  public abstract LoadBalancingStrategy getLoadBalancingStrategy();

  /**
   * Helper to check if the {@link BigtableChannelPool} implementation can skip dynamic size logic
   */
  boolean isStaticSize() {
    // When range is restricted to a single size
    if (getMinChannelCount() == getMaxChannelCount()) {
      return true;
    }
    // When the scaling threshold are not set
    if (getMinRpcsPerChannel() == 0 && getMaxRpcsPerChannel() == Integer.MAX_VALUE) {
      return true;
    }

    return false;
  }

  /**
   * Use environment variable CBT_LOAD_BALANCING_STRATEGY to pick a load-balancing strategy.
   *
   * @return load-balancing strategy to use.
   */
  private static LoadBalancingStrategy loadBalancingStrategyFromEnv() {
    String strategyString = System.getenv(CBT_LOAD_BALANCING_STRATEGY_ENV_VAR);
    if (Strings.isNullOrEmpty(strategyString)) {
      return DEFAULT_LOAD_BALANCING_STRATEGY;
    }
    try {
      return LoadBalancingStrategy.valueOf(strategyString.trim().toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new IllegalStateException(
          String.format("Invalid load-balancing strategy %s", strategyString));
    }
  }

  public abstract Builder toBuilder();

  public static BigtableChannelPoolSettings copyFrom(ChannelPoolSettings externalSettings) {
    return BigtableChannelPoolSettings.builder()
        .setMinRpcsPerChannel(externalSettings.getMinRpcsPerChannel())
        .setMaxRpcsPerChannel(externalSettings.getMaxRpcsPerChannel())
        .setMinChannelCount(externalSettings.getMinChannelCount())
        .setMaxChannelCount(externalSettings.getMaxChannelCount())
        .setInitialChannelCount(externalSettings.getInitialChannelCount())
        .setPreemptiveRefreshEnabled(externalSettings.isPreemptiveRefreshEnabled())
        .setLoadBalancingStrategy(loadBalancingStrategyFromEnv())
        .build();
  }

  public static BigtableChannelPoolSettings staticallySized(int size) {
    return builder()
        .setInitialChannelCount(size)
        .setMinRpcsPerChannel(0)
        .setMaxRpcsPerChannel(Integer.MAX_VALUE)
        .setMinChannelCount(size)
        .setMaxChannelCount(size)
        .setLoadBalancingStrategy(loadBalancingStrategyFromEnv())
        .build();
  }

  public static Builder builder() {
    return new AutoValue_BigtableChannelPoolSettings.Builder()
        .setInitialChannelCount(1)
        .setMinChannelCount(1)
        .setMaxChannelCount(200)
        .setMinRpcsPerChannel(0)
        .setMaxRpcsPerChannel(Integer.MAX_VALUE)
        .setPreemptiveRefreshEnabled(false)
        .setLoadBalancingStrategy(loadBalancingStrategyFromEnv());
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setMinRpcsPerChannel(int count);

    public abstract Builder setMaxRpcsPerChannel(int count);

    public abstract Builder setMinChannelCount(int count);

    public abstract Builder setMaxChannelCount(int count);

    public abstract Builder setInitialChannelCount(int count);

    public abstract Builder setPreemptiveRefreshEnabled(boolean enabled);

    @InternalApi("Use CBT_LOAD_BALANCING_STRATEGY environment variable")
    public abstract Builder setLoadBalancingStrategy(LoadBalancingStrategy strategy);

    abstract BigtableChannelPoolSettings autoBuild();

    public BigtableChannelPoolSettings build() {
      BigtableChannelPoolSettings s = autoBuild();

      Preconditions.checkState(
          s.getMinRpcsPerChannel() <= s.getMaxRpcsPerChannel(), "rpcsPerChannel range is invalid");
      Preconditions.checkState(
          s.getMinChannelCount() > 0, "Minimum channel count must be at least 1");
      Preconditions.checkState(
          s.getMinChannelCount() <= s.getMaxRpcsPerChannel(), "absolute channel range is invalid");
      Preconditions.checkState(
          s.getMinChannelCount() <= s.getInitialChannelCount(),
          "initial channel count be at least minChannelCount");
      Preconditions.checkState(
          s.getInitialChannelCount() <= s.getMaxChannelCount(),
          "initial channel count must be less than maxChannelCount");
      Preconditions.checkState(
          s.getInitialChannelCount() > 0, "Initial channel count must be greater than 0");
      return s;
    }
  }
}
