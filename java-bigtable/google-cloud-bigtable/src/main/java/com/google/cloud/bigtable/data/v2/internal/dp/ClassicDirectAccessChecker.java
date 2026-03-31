/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal.dp;

import com.google.api.core.InternalApi;
import com.google.bigtable.v2.PeerInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DirectPathCompatibleTracer;
import com.google.cloud.bigtable.data.v2.stub.MetadataExtractorInterceptor;
import com.google.cloud.bigtable.gaxx.grpc.ChannelPrimer;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Channel;
import io.grpc.ClientInterceptors;
import io.grpc.ManagedChannel;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * Evaluates whether a given channel has Direct Access (DirectPath) routing by executing a RPC and
 * inspecting the response headers.
 */
@InternalApi
public class ClassicDirectAccessChecker implements DirectAccessChecker {
  private static final Logger LOG = Logger.getLogger(ClassicDirectAccessChecker.class.getName());
  private final DirectPathCompatibleTracer tracer;
  private final ChannelPrimer channelPrimer;
  private final ScheduledExecutorService executor;

  public ClassicDirectAccessChecker(
      DirectPathCompatibleTracer tracer,
      ChannelPrimer channelPrimer,
      ScheduledExecutorService executor) {
    this.tracer = Preconditions.checkNotNull(tracer);
    this.channelPrimer = Preconditions.checkNotNull(channelPrimer);
    this.executor = Preconditions.checkNotNull(executor);
  }

  @VisibleForTesting
  MetadataExtractorInterceptor createInterceptor() {
    return new MetadataExtractorInterceptor();
  }

  @Override
  public boolean check(Channel channel) {
    try {
      return evaluateEligibility(channel);
    } catch (Exception e) {
      investigateFailure(e);
      LOG.log(Level.WARNING, "Failed to evaluate direct access eligibility.", e);
      return false;
    } finally {
      if (channel instanceof ManagedChannel) {
        ManagedChannel managedChannel = (ManagedChannel) channel;
        managedChannel.shutdownNow();
      }
    }
  }

  /** Executes the underlying RPC and evaluates the eligibility. */
  private boolean evaluateEligibility(Channel channel) {
    MetadataExtractorInterceptor interceptor = createInterceptor();
    Channel interceptedChannel = ClientInterceptors.intercept(channel, interceptor);
    channelPrimer.primeChannel(interceptedChannel);
    MetadataExtractorInterceptor.SidebandData sidebandData = interceptor.getSidebandData();

    boolean isEligible =
        Optional.ofNullable(sidebandData)
            .map(MetadataExtractorInterceptor.SidebandData::getPeerInfo)
            .map(PeerInfo::getTransportType)
            .map(type -> type == PeerInfo.TransportType.TRANSPORT_TYPE_DIRECT_ACCESS)
            .orElse(false);

    if (isEligible) {
      // getIp should be non-null as isEligible is true
      tracer.recordSuccess(sidebandData.getIpProtocol());
    } else {
      investigateFailure(null);
    }
    return isEligible;
  }

  @Override
  public void investigateFailure(@Nullable Throwable originalError) {
    if (executor != null) {
      executor.execute(() -> DirectAccessInvestigator.investigateAndReport(tracer, originalError));
    }
  }
}
