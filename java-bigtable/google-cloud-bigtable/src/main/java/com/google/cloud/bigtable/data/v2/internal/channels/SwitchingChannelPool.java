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

package com.google.cloud.bigtable.data.v2.internal.channels;

import static com.google.cloud.bigtable.data.v2.internal.csm.attributes.Util.transportTypeToString;

import com.google.bigtable.v2.PeerInfo.TransportType;
import com.google.bigtable.v2.SessionClientConfiguration.ChannelPoolConfiguration;
import com.google.bigtable.v2.SessionRequest;
import com.google.bigtable.v2.SessionResponse;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders.ChannelProvider;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager.ListenerHandle;
import io.grpc.CallOptions;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Supplier;
import javax.annotation.concurrent.GuardedBy;

/**
 * SwitchingChannelPool reads channel pool configuration from configManager on initialization,
 * creates underlying channel pool according to the configuration, and subscribes to configuration
 * updates. When update happens, it propagates updated configuration to the underlying channel pool
 * or creates a different channel pool if channel pool mode has changed.
 */
public class SwitchingChannelPool implements ChannelPool {
  @GuardedBy("this")
  private ChannelPool delegate;

  private ChannelPoolConfiguration currentConfiguration;

  private final boolean fallbackAvailable;
  private final ListenerHandle configListener;

  @GuardedBy("this")
  private boolean isClosed;

  private final ChannelProvider channelProvider;
  private final Metrics metrics;
  private final ScheduledExecutorService backgroundExecutor;

  public SwitchingChannelPool(
      ChannelProvider channelProvider,
      ClientConfigurationManager configManager,
      Metrics metrics,
      ScheduledExecutorService backgroundExecutor) {
    this.channelProvider = channelProvider;
    this.metrics = metrics;
    this.backgroundExecutor = backgroundExecutor;

    currentConfiguration =
        configManager.getClientConfiguration().getSessionConfiguration().getChannelConfiguration();

    if (channelProvider.getFallback().isPresent()) {
      fallbackAvailable = true;
      delegate = createChannelPoolForCurrentMode();
    } else {
      // Depending on whether DirectAccess is avaialbe, the channelProvider
      // is either a DirectAccess with fallback to Cloudpath
      // or a basic Cloudpath.
      // If it's a basic cloudpath we can't do any fallback,
      // and we can't do directaccess without fallback.
      // Essentially, fallback configuration is not applicable here.
      fallbackAvailable = false;
      delegate = newChannelPoolFromProvider(channelProvider);
    }

    // Subscribe to config changes.
    configListener =
        configManager.addListener(
            cfg -> cfg.getSessionConfiguration().getChannelConfiguration(), this::updateConfig);
  }

  @Override
  public synchronized void updateConfig(ChannelPoolConfiguration newConfig) {
    if (isClosed) {
      return;
    }

    if (fallbackAvailable && currentConfiguration.getModeCase() != newConfig.getModeCase()) {
      // Mode has changed and we can change modes.
      currentConfiguration = newConfig;
      ChannelPool cp = createChannelPoolForCurrentMode();
      replaceChannelPool(cp);
      return;
    }

    currentConfiguration = newConfig;
    delegate.updateConfig(currentConfiguration);
  }

  private ChannelPool createChannelPoolForCurrentMode() {
    switch (currentConfiguration.getModeCase()) {
      default:
      case MODE_NOT_SET:
      case CLOUD_PATH_ONLY:
        return newChannelPoolFromProvider(channelProvider.getFallback().get());
      case DIRECT_ACCESS_ONLY:
        return newChannelPoolFromProvider(channelProvider);
      case DIRECT_ACCESS_WITH_FALLBACK:
        ChannelPool primaryChannelPool =
            newChannelPoolFromProvider(
                channelProvider,
                "primary",
                new DirectpathEnforcer(
                    "Non-directpath connections are not allowed in the directpath channel "
                        + "pool when a fallback channel pool is available."));
        ChannelPool fallbackChannelPool =
            newChannelPoolFromProvider(channelProvider.getFallback().get(), "fallback");
        FallbackConfiguration fallbackConfiguration =
            FallbackConfiguration.builder()
                .setPrimary(
                    transportTypeToString(TransportType.TRANSPORT_TYPE_SESSION_DIRECT_ACCESS),
                    primaryChannelPool)
                .setFallback(
                    transportTypeToString(TransportType.TRANSPORT_TYPE_SESSION_CLOUD_PATH),
                    fallbackChannelPool)
                .setEnabled(true)
                .setCheckInterval(
                    Duration.ofSeconds(
                        currentConfiguration
                            .getDirectAccessWithFallback()
                            .getCheckInterval()
                            .getSeconds()))
                .setErrorRate(
                    currentConfiguration.getDirectAccessWithFallback().getErrorRateThreshold())
                .build();
        return new FallbackChannelPool(
            fallbackConfiguration, metrics.getPoolFallbackListener(), backgroundExecutor);
    }
  }

  private synchronized void replaceChannelPool(ChannelPool newChannelPool) {
    newChannelPool.start();
    ChannelPool prev = delegate;
    delegate = newChannelPool;
    prev.close();
  }

  @Override
  public synchronized void start() {
    delegate.start();
  }

  @Override
  public synchronized void close() {
    if (isClosed) {
      return;
    }

    configListener.close();
    delegate.close();
    isClosed = true;
  }

  @Override
  public synchronized SessionStream newStream(
      MethodDescriptor<SessionRequest, SessionResponse> desc, CallOptions callOptions) {
    return delegate.newStream(desc, callOptions);
  }

  private ChannelPool newChannelPoolFromProvider(
      ChannelProvider channelProvider, ClientInterceptor... interceptors) {
    return newChannelPoolFromProvider(channelProvider, null, interceptors);
  }

  private ChannelPool newChannelPoolFromProvider(
      ChannelProvider channelProvider, String logName, ClientInterceptor... interceptors) {
    if (channelProvider.isSingleEndpoint()) {
      return new SingleChannelPool(
          channelBuilderToSupplier(channelProvider.newChannelBuilder(), interceptors));
    }

    if (logName != null) {
      return new ChannelPoolDpImpl(
          channelBuilderToSupplier(channelProvider.newChannelBuilder(), interceptors),
          currentConfiguration,
          logName,
          metrics.getDebugTagTracer(),
          backgroundExecutor);
    }

    return new ChannelPoolDpImpl(
        channelBuilderToSupplier(channelProvider.newChannelBuilder(), interceptors),
        currentConfiguration,
        metrics.getDebugTagTracer(),
        backgroundExecutor);
  }

  private Supplier<ManagedChannel> channelBuilderToSupplier(
      ManagedChannelBuilder<?> channelBuilder, ClientInterceptor... interceptors) {
    return () -> channelBuilder.intercept(interceptors).build();
  }
}
