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
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.common.annotations.VisibleForTesting;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * gRPC implementation of {@link ChannelEndpointCache}.
 *
 * <p>This cache creates and caches gRPC channels per address. It uses {@link
 * InstantiatingGrpcChannelProvider#withEndpoint(String)} to create new channels with the same
 * configuration but different endpoints, avoiding race conditions.
 */
@InternalApi
class GrpcChannelEndpointCache implements ChannelEndpointCache {

  /** Timeout for graceful channel shutdown. */
  private static final long SHUTDOWN_TIMEOUT_SECONDS = 5;

  private final InstantiatingGrpcChannelProvider baseProvider;
  private final Map<String, GrpcChannelEndpoint> servers = new ConcurrentHashMap<>();
  private final GrpcChannelEndpoint defaultEndpoint;
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
    this.baseProvider = channelProvider;
    String defaultEndpoint = channelProvider.getEndpoint();
    this.defaultEndpoint = new GrpcChannelEndpoint(defaultEndpoint, channelProvider);
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
            TransportChannelProvider newProvider = baseProvider.withEndpoint(addr);
            return new GrpcChannelEndpoint(addr, newProvider);
          } catch (IOException e) {
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.INTERNAL, "Failed to create channel for address: " + addr, e);
          }
        });
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

    /**
     * Creates a server from a channel provider.
     *
     * @param address the server address
     * @param provider the channel provider (must be a gRPC provider)
     * @throws IOException if the channel cannot be created
     */
    GrpcChannelEndpoint(String address, TransportChannelProvider provider) throws IOException {
      this.address = address;
      TransportChannelProvider readyProvider = provider;
      if (provider.needsHeaders()) {
        readyProvider = provider.withHeaders(java.util.Collections.emptyMap());
      }
      GrpcTransportChannel transportChannel =
          (GrpcTransportChannel) readyProvider.getTransportChannel();
      this.channel = (ManagedChannel) transportChannel.getChannel();
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
      // Some channel implementations don't support getState(), in which case
      // we assume the channel is healthy if it's not shutdown/terminated.
      try {
        ConnectivityState state = channel.getState(false);
        return state != ConnectivityState.SHUTDOWN && state != ConnectivityState.TRANSIENT_FAILURE;
      } catch (UnsupportedOperationException ignore) {
        return true;
      }
    }

    @Override
    public ManagedChannel getChannel() {
      return channel;
    }
  }
}
