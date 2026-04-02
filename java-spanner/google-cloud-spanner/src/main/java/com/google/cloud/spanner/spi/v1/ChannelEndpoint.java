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
import io.grpc.ManagedChannel;

/**
 * Represents a Spanner server endpoint for location-aware routing.
 *
 * <p>Each instance wraps a gRPC {@link ManagedChannel} connected to a specific Spanner server. The
 * {@link ChannelEndpointCache} creates and caches these instances.
 *
 * <p>Implementations must be thread-safe as instances may be shared across multiple concurrent
 * operations.
 *
 * @see ChannelEndpointCache
 */
@InternalApi
public interface ChannelEndpoint {

  /**
   * Returns the network address of this server.
   *
   * @return the server address in "host:port" format
   */
  String getAddress();

  /**
   * Returns whether this server is ready to accept RPCs.
   *
   * <p>A server is considered unhealthy if:
   *
   * <ul>
   *   <li>The underlying channel is shutdown or terminated
   *   <li>The channel is in a transient failure state
   * </ul>
   *
   * @return true if the server is healthy and ready to accept RPCs
   */
  boolean isHealthy();

  /**
   * Returns the gRPC channel for making RPCs to this server.
   *
   * <p>The returned channel is managed by the {@link ChannelEndpointCache} and should not be shut
   * down directly by callers.
   *
   * @return the managed channel for this server
   */
  ManagedChannel getChannel();
}
