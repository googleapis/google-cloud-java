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
package com.google.cloud.bigtable.data.v2.internal.csm.tracers;

import com.google.api.core.InternalApi;
import com.google.bigtable.v2.PeerInfo.TransportType;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.gaxx.grpc.BigtableChannelObserver;
import com.google.cloud.bigtable.gaxx.grpc.BigtableChannelPoolObserver;
import com.google.cloud.bigtable.gaxx.grpc.BigtableChannelPoolSettings.LoadBalancingStrategy;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

@InternalApi("For internal use only")
public class ChannelPoolMetricsTracer implements Runnable {
  private static final Logger logger = Logger.getLogger(ChannelPoolMetricsTracer.class.getName());

  private static final int SAMPLING_PERIOD_SECONDS = 60;
  private final MetricRegistry.RecorderRegistry recorder;
  private final ClientInfo clientInfo;

  private final AtomicReference<BigtableChannelPoolObserver> bigtableChannelInsightsProviderRef =
      new AtomicReference<>();
  private final AtomicReference<LoadBalancingStrategy> lbPolicyRef =
      new AtomicReference<>(LoadBalancingStrategy.ROUND_ROBIN);

  // Attributes for unary and streaming RPCs, built on demand in run()

  public ChannelPoolMetricsTracer(MetricRegistry.RecorderRegistry recorder, ClientInfo clientInfo) {
    this.recorder = recorder;
    this.clientInfo = clientInfo;
  }

  /**
   * Registers the provider for the channel pool entries. This should be called by the component
   * that creates the BigtableChannelPool.
   */
  public void registerChannelInsightsProvider(BigtableChannelPoolObserver channelInsightsProvider) {
    this.bigtableChannelInsightsProviderRef.set(channelInsightsProvider);
  }

  /** Register the current lb policy * */
  public void registerLoadBalancingStrategy(LoadBalancingStrategy lbPolicy) {
    this.lbPolicyRef.set(lbPolicy);
  }

  /** Starts the periodic collection. */
  public ScheduledFuture<?> start(ScheduledExecutorService scheduler) {
    return scheduler.scheduleAtFixedRate(
        this, SAMPLING_PERIOD_SECONDS, SAMPLING_PERIOD_SECONDS, TimeUnit.SECONDS);
  }

  @Override
  public void run() {
    BigtableChannelPoolObserver channelInsightsProvider = bigtableChannelInsightsProviderRef.get();
    if (channelInsightsProvider == null) {
      logger.warning("No Bigtable ChannelPoolObserver available");
      return; // Not registered yet
    }
    List<? extends BigtableChannelObserver> channelInsights =
        channelInsightsProvider.getChannelInfos();
    if (channelInsights == null || channelInsights.isEmpty()) {
      return;
    }

    LoadBalancingStrategy lbPolicy = lbPolicyRef.get();

    for (BigtableChannelObserver info : channelInsights) {
      TransportType transportType =
          info.isAltsChannel()
              ? TransportType.TRANSPORT_TYPE_DIRECT_ACCESS
              : TransportType.TRANSPORT_TYPE_CLOUD_PATH;

      long currentOutstandingUnaryRpcs = info.getOutstandingUnaryRpcs();
      long currentOutstandingStreamingRpcs = info.getOutstandingStreamingRpcs();

      recorder.channelPoolOutstandingRpcs.record(
          clientInfo, transportType, lbPolicy, false, currentOutstandingUnaryRpcs);
      recorder.channelPoolOutstandingRpcs.record(
          clientInfo, transportType, lbPolicy, true, currentOutstandingStreamingRpcs);

      long errors = info.getAndResetErrorCount();
      // Record errors with empty attributes.
      recorder.perConnectionErrorCount.record(clientInfo, errors);
    }
  }
}
