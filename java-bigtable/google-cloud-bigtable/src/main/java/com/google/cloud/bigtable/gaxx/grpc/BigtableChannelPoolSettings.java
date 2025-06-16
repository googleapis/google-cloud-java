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
import com.google.api.gax.grpc.ChannelPoolSettings;
import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import java.time.Duration;

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
  /** How often to check and possibly resize the {@link BigtableChannelPool}. */
  static final Duration RESIZE_INTERVAL = Duration.ofMinutes(1);

  /** The maximum number of channels that can be added or removed at a time. */
  static final int MAX_RESIZE_DELTA = 2;

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

  public abstract Builder toBuilder();

  public static BigtableChannelPoolSettings copyFrom(ChannelPoolSettings externalSettings) {
    return BigtableChannelPoolSettings.builder()
        .setMinRpcsPerChannel(externalSettings.getMinRpcsPerChannel())
        .setMaxRpcsPerChannel(externalSettings.getMaxRpcsPerChannel())
        .setMinChannelCount(externalSettings.getMinChannelCount())
        .setMaxChannelCount(externalSettings.getMaxChannelCount())
        .setInitialChannelCount(externalSettings.getInitialChannelCount())
        .setPreemptiveRefreshEnabled(externalSettings.isPreemptiveRefreshEnabled())
        .build();
  }

  public static BigtableChannelPoolSettings staticallySized(int size) {
    return builder()
        .setInitialChannelCount(size)
        .setMinRpcsPerChannel(0)
        .setMaxRpcsPerChannel(Integer.MAX_VALUE)
        .setMinChannelCount(size)
        .setMaxChannelCount(size)
        .build();
  }

  public static Builder builder() {
    return new AutoValue_BigtableChannelPoolSettings.Builder()
        .setInitialChannelCount(1)
        .setMinChannelCount(1)
        .setMaxChannelCount(200)
        .setMinRpcsPerChannel(0)
        .setMaxRpcsPerChannel(Integer.MAX_VALUE)
        .setPreemptiveRefreshEnabled(false);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setMinRpcsPerChannel(int count);

    public abstract Builder setMaxRpcsPerChannel(int count);

    public abstract Builder setMinChannelCount(int count);

    public abstract Builder setMaxChannelCount(int count);

    public abstract Builder setInitialChannelCount(int count);

    public abstract Builder setPreemptiveRefreshEnabled(boolean enabled);

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
