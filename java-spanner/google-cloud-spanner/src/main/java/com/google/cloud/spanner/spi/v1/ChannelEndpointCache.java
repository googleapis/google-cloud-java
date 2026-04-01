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

/**
 * Cache for server connections used in location-aware routing.
 *
 * <p>Implementations are expected to cache {@link ChannelEndpoint} instances such that repeated
 * calls with the same address return the same instance. This allows routing components to
 * efficiently manage server references.
 *
 * <p>Implementations must be thread-safe. Multiple threads may concurrently call {@link
 * #get(String)} with different addresses.
 */
@InternalApi
public interface ChannelEndpointCache {

  /**
   * Returns the default channel endpoint.
   *
   * <p>The default channel is the original endpoint configured in {@link
   * com.google.cloud.spanner.SpannerOptions}. It is used as a fallback when the location cache does
   * not have routing information for a request.
   *
   * @return the default channel, never null
   */
  ChannelEndpoint defaultChannel();

  /**
   * Returns a cached channel for the given address, creating it if needed.
   *
   * <p>If a channel for this address already exists in the cache, the cached instance is returned.
   * Otherwise, a new server connection is created and cached.
   *
   * @param address the server address in "host:port" format
   * @return a channel instance for the address, never null
   * @throws com.google.cloud.spanner.SpannerException if the channel cannot be created
   */
  ChannelEndpoint get(String address);

  /**
   * Evicts a server connection from the cache and gracefully shuts down its channel.
   *
   * <p>This method should be called when a server becomes unhealthy or is no longer needed. The
   * channel shutdown is graceful: existing RPCs are allowed to complete, but new RPCs will not be
   * accepted on this channel.
   *
   * <p>If the address is not in the cache, this method does nothing.
   *
   * @param address the server address to evict
   */
  void evict(String address);

  /**
   * Shuts down all cached server connections.
   *
   * <p>This method should be called when the Spanner client is closed to release all resources.
   * Each channel is shut down gracefully, allowing in-flight RPCs to complete.
   *
   * <p>After calling this method, the cache should not be used to create new connections.
   */
  void shutdown();
}
