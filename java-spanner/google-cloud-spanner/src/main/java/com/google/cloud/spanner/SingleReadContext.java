/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.base.Preconditions.checkState;

import com.google.cloud.grpc.GcpManagedChannel.ChannelAffinityRef;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Option;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/**
 * A {@code ReadContext} for standalone reads. This can only be used for a single operation, since
 * each standalone read may see a different timestamp of Cloud Spanner data.
 */
class SingleReadContext extends AbstractReadContext {
  static class Builder extends AbstractReadContext.Builder<Builder, SingleReadContext> {
    private TimestampBound bound;

    private Builder() {}

    Builder setTimestampBound(TimestampBound bound) {
      this.bound = bound;
      return self();
    }

    @Override
    SingleReadContext build() {
      return new SingleReadContext(this);
    }

    SingleUseReadOnlyTransaction buildSingleUseReadOnlyTransaction() {
      return new SingleUseReadOnlyTransaction(this);
    }
  }

  static Builder newBuilder() {
    return new Builder();
  }

  final TimestampBound bound;

  @GuardedBy("lock")
  private boolean used;

  private Map<SpannerRpc.Option, ?> channelHint;

  SingleReadContext(Builder builder) {
    super(builder);
    this.bound = builder.bound;
    // single use transaction have a single RPC and hence there is no need
    // of a channel hint. GAX will automatically choose a hint when used
    // with a multiplexed session to perform a round-robin channel selection. We are
    // passing a hint here to prefer random channel selection instead of doing GAX round-robin.
    this.channelHint =
        getChannelHintOptions(
            session.getOptions(),
            ThreadLocalRandom.current().nextLong(Long.MAX_VALUE),
            session.getSpanner().getOptions().isGrpcGcpExtensionEnabled());
  }

  @Override
  protected boolean isRouteToLeader() {
    return false;
  }

  @GuardedBy("lock")
  @Override
  void beforeReadOrQueryLocked() {
    super.beforeReadOrQueryLocked();
    checkState(!used, "Cannot use a single-read ReadContext for multiple reads");
    used = true;
  }

  @Override
  @Nullable
  TransactionSelector getTransactionSelector() {
    if (bound.getMode() == TimestampBound.Mode.STRONG) {
      // Default mode: no need to specify a transaction.
      return null;
    }
    return TransactionSelector.newBuilder()
        .setSingleUse(TransactionOptions.newBuilder().setReadOnly(bound.toProto()))
        .build();
  }

  @Override
  Map<SpannerRpc.Option, ?> getTransactionChannelHint() {
    return channelHint;
  }

  @Override
  boolean prepareRetryOnDifferentGrpcChannel() {
    ChannelAffinityRef channelAffinityRef =
        Option.CHANNEL_ID_AFFINITY.getChannelAffinityRef(channelHint);
    if (session.getIsMultiplexed() && channelAffinityRef != null) {
      channelAffinityRef.useDifferentChannelOnNextCall();
      return true;
    }
    return super.prepareRetryOnDifferentGrpcChannel();
  }
}
