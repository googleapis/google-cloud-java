/*
 * Copyright 2021 Google LLC
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

package com.google.api.gax.grpc;

import com.google.api.core.BetaApi;
import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import java.time.Duration;

/**
 * Settings to control {@link ChannelPool} behavior.
 *
 * <p>To facilitate low latency/high throughout applications, gax provides a {@link ChannelPool}.
 * The pool is meant to facilitate high throughput/low latency clients. By splitting load across
 * multiple gRPC channels the client can spread load across multiple frontends and overcome gRPC's
 * limit of 100 concurrent RPCs per channel. However oversizing the {@link ChannelPool} can lead to
 * underutilized channels which will lead to high tail latency due to GFEs disconnecting idle
 * channels.
 *
 * <p>The {@link ChannelPool} is designed to adapt to varying traffic patterns by tracking
 * outstanding RPCs and resizing the pool size. This class configures the behavior. In general
 * clients should aim to have less than 50 concurrent RPCs per channel and at least 1 outstanding
 * per channel per minute.
 *
 * <p>The settings in this class will be applied every minute.
 */
@BetaApi("surface for channel pool sizing is not yet stable")
@AutoValue
public abstract class ChannelPoolSettings {
  /** How often to check and possibly resize the {@link ChannelPool}. */
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

  /** Helper to check if the {@link ChannelPool} implementation can skip dynamic size logic */
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

  public static ChannelPoolSettings staticallySized(int size) {
    return builder()
        .setInitialChannelCount(size)
        .setMinRpcsPerChannel(0)
        .setMaxRpcsPerChannel(Integer.MAX_VALUE)
        .setMinChannelCount(size)
        .setMaxChannelCount(size)
        .build();
  }

  public static Builder builder() {
    return new AutoValue_ChannelPoolSettings.Builder()
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

    abstract ChannelPoolSettings autoBuild();

    public ChannelPoolSettings build() {
      ChannelPoolSettings s = autoBuild();

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
