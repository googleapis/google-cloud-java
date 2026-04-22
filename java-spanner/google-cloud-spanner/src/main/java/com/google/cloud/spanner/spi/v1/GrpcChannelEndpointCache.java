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

package com.google.cloud.spanner.spi.v1;

import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.ChannelPoolSettings;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider.Builder;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.common.annotations.VisibleForTesting;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * gRPC implementation of {@link ChannelEndpointCache}.
 *
 * <p>This cache creates and caches gRPC channels per address. It uses {@link
 * InstantiatingGrpcChannelProvider#withEndpoint(String)} to create new channels with the same
 * configuration but different endpoints, avoiding race conditions.
 */
@InternalApi
class GrpcChannelEndpointCache implements ChannelEndpointCache {

  private static final Logger logger = Logger.getLogger(GrpcChannelEndpointCache.class.getName());

  /** Timeout for graceful channel shutdown. */
  private static final long SHUTDOWN_TIMEOUT_SECONDS = 5;

  @VisibleForTesting static final Duration ROUTED_KEEPALIVE_TIME = Duration.ofSeconds(2);
  @VisibleForTesting static final Duration ROUTED_KEEPALIVE_TIMEOUT = Duration.ofSeconds(20);

  private final InstantiatingGrpcChannelProvider baseProvider;
  private final Map<String, GrpcChannelEndpoint> servers = new ConcurrentHashMap<>();
  private final GrpcChannelEndpoint defaultEndpoint;
  private final String defaultAuthority;
  @Nullable private final GrpcGcpEndpointChannelConfigurator endpointChannelConfigurator;
  private final AtomicBoolean isShutdown = new AtomicBoolean(false);

  /**
   * Creates a new cache with the given channel provider.
   *
   * @param channelProvider the base provider used to create channels. New channels for different
   *     endpoints are created using {@link InstantiatingGrpcChannelProvider#withEndpoint(String)}.
   * @throws IOException if the default channel cannot be created
   */
  public GrpcChannelEndpointCache(InstantiatingGrpcChannelProvider channelProvider)
      throws IOException {
    this(channelProvider, null);
  }

  public GrpcChannelEndpointCache(
      InstantiatingGrpcChannelProvider channelProvider,
      @Nullable GrpcGcpEndpointChannelConfigurator endpointChannelConfigurator)
      throws IOException {
    this.baseProvider = channelProvider;
    this.endpointChannelConfigurator = endpointChannelConfigurator;
    String defaultEndpoint = channelProvider.getEndpoint();
    this.defaultEndpoint = new GrpcChannelEndpoint(defaultEndpoint, channelProvider);
    this.defaultAuthority = this.defaultEndpoint.getChannel().authority();
    this.servers.put(defaultEndpoint, this.defaultEndpoint);
  }

  @Override
  public ChannelEndpoint defaultChannel() {
    return defaultEndpoint;
  }

  @Override
  public ChannelEndpoint get(String address) {
    if (isShutdown.get()) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.FAILED_PRECONDITION, "ChannelEndpointCache has been shut down");
    }

    return servers.computeIfAbsent(
        address,
        addr -> {
          try {
            // Create a new provider with the same config but different endpoint.
            // This is thread-safe as withEndpoint() returns a new provider instance.
            InstantiatingGrpcChannelProvider newProvider =
                createProviderWithAuthorityOverride(addr);
            GrpcChannelEndpoint endpoint = new GrpcChannelEndpoint(addr, newProvider);
            logger.log(Level.FINE, "Location-aware endpoint created for address: {0}", addr);
            return endpoint;
          } catch (IOException e) {
            logger.log(
                Level.FINE, "Failed to create location-aware endpoint for address: " + addr, e);
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.INTERNAL, "Failed to create channel for address: " + addr, e);
          }
        });
  }

  @Override
  @Nullable
  public ChannelEndpoint getIfPresent(String address) {
    return servers.get(address);
  }

  @VisibleForTesting
  InstantiatingGrpcChannelProvider createProviderWithAuthorityOverride(String address) {
    InstantiatingGrpcChannelProvider endpointProvider =
        (InstantiatingGrpcChannelProvider) baseProvider.withEndpoint(address);
    if (Objects.equals(defaultAuthority, address)) {
      return endpointProvider;
    }
    Builder builder = endpointProvider.toBuilder();
    builder.setChannelPoolSettings(ChannelPoolSettings.staticallySized(1));
    builder.setKeepAliveTimeDuration(ROUTED_KEEPALIVE_TIME);
    builder.setKeepAliveTimeoutDuration(ROUTED_KEEPALIVE_TIMEOUT);
    builder.setKeepAliveWithoutCalls(Boolean.TRUE);
    final com.google.api.core.ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder>
        baseConfigurator =
            endpointChannelConfigurator == null ? builder.getChannelConfigurator() : null;
    builder.setChannelConfigurator(
        channelBuilder -> {
          ManagedChannelBuilder effectiveBuilder = channelBuilder;
          if (endpointChannelConfigurator != null) {
            effectiveBuilder = endpointChannelConfigurator.configure(effectiveBuilder);
          } else if (baseConfigurator != null) {
            effectiveBuilder = baseConfigurator.apply(effectiveBuilder);
          }
          return effectiveBuilder.overrideAuthority(defaultAuthority);
        });
    return builder.build();
  }

  @Override
  public void evict(String address) {
    if (defaultEndpoint.getAddress().equals(address)) {
      return;
    }
    GrpcChannelEndpoint server = servers.remove(address);
    if (server != null) {
      shutdownChannel(server, false);
    }
  }

  @Override
  public void shutdown() {
    if (!isShutdown.compareAndSet(false, true)) {
      return;
    }
    for (GrpcChannelEndpoint server : servers.values()) {
      shutdownChannel(server, true);
    }
    servers.clear();
  }

  /**
   * Shuts down a server's channel.
   *
   * <p>First attempts a graceful shutdown. When awaitTermination is true, waits for in-flight RPCs
   * to complete and forces shutdown on timeout.
   */
  private void shutdownChannel(GrpcChannelEndpoint server, boolean awaitTermination) {
    ManagedChannel channel = server.getChannel();
    if (channel.isShutdown()) {
      return;
    }

    channel.shutdown();
    if (!awaitTermination) {
      return;
    }
    try {
      if (!channel.awaitTermination(SHUTDOWN_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
        channel.shutdownNow();
      }
    } catch (InterruptedException e) {
      channel.shutdownNow();
      Thread.currentThread().interrupt();
    }
  }

  /** gRPC implementation of {@link ChannelEndpoint}. */
  static class GrpcChannelEndpoint implements ChannelEndpoint {
    private final String address;
    private final ManagedChannel channel;
    private final AtomicInteger activeRequests = new AtomicInteger();

    /**
     * Creates a server from a channel provider.
     *
     * @param address the server address
     * @param provider the channel provider (must be a gRPC provider)
     * @throws IOException if the channel cannot be created
     */
    GrpcChannelEndpoint(String address, InstantiatingGrpcChannelProvider provider)
        throws IOException {
      this.address = address;
      // Build a raw ManagedChannel directly instead of going through getTransportChannel(),
      // which wraps the channel in a ChannelPool that does not support getState().
      // Location-aware routing needs getState() to check channel connectivity.
      InstantiatingGrpcChannelProvider readyProvider = provider;
      if (provider.needsHeaders()) {
        readyProvider =
            (InstantiatingGrpcChannelProvider)
                provider.withHeaders(java.util.Collections.emptyMap());
      }
      this.channel = readyProvider.createDecoratedChannelBuilder().build();
    }

    /**
     * Creates a server with an existing channel. Primarily for testing.
     *
     * @param address the server address
     * @param channel the managed channel
     */
    @VisibleForTesting
    GrpcChannelEndpoint(String address, ManagedChannel channel) {
      this.address = address;
      this.channel = channel;
    }

    @Override
    public String getAddress() {
      return address;
    }

    @Override
    public boolean isHealthy() {
      if (channel.isShutdown() || channel.isTerminated()) {
        return false;
      }
      // Check connectivity state without triggering a connection attempt.
      // Only READY channels are considered healthy for location-aware routing.
      // Some channel implementations don't support getState(), in which case
      // we treat the endpoint as not ready for location-aware routing (defensive).
      try {
        ConnectivityState state = channel.getState(false);
        boolean ready = state == ConnectivityState.READY;
        if (!ready) {
          logger.log(
              Level.FINE,
              "Location-aware endpoint {0} is not ready for location-aware routing, state: {1}",
              new Object[] {address, state});
        }
        return ready;
      } catch (UnsupportedOperationException e) {
        logger.log(
            Level.FINE,
            "getState(false) unsupported for location-aware endpoint {0}, treating as not ready",
            address);
        return false;
      }
    }

    @Override
    public boolean isTransientFailure() {
      if (channel.isShutdown() || channel.isTerminated()) {
        return false;
      }
      try {
        ConnectivityState state = channel.getState(false);
        return state == ConnectivityState.TRANSIENT_FAILURE;
      } catch (UnsupportedOperationException e) {
        return false;
      }
    }

    @Override
    public ManagedChannel getChannel() {
      return channel;
    }

    @Override
    public void incrementActiveRequests() {
      activeRequests.incrementAndGet();
    }

    @Override
    public void decrementActiveRequests() {
      activeRequests.updateAndGet(current -> current > 0 ? current - 1 : 0);
    }

    @Override
    public int getActiveRequestCount() {
      return Math.max(0, activeRequests.get());
    }
  }
}
