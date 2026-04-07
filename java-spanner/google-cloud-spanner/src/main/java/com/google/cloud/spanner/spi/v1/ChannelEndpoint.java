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
   * Returns whether this server's channel is in {@code READY} state and can accept location-aware
   * RPCs.
   *
   * <p>Only endpoints in {@code READY} state are eligible for location-aware routing. Endpoints in
   * {@code IDLE}, {@code CONNECTING}, {@code TRANSIENT_FAILURE}, or {@code SHUTDOWN} are not
   * considered healthy for location-aware routing purposes.
   *
   * @return true if the channel is in READY state
   */
  boolean isHealthy();

  /**
   * Returns whether this server's channel is in {@code TRANSIENT_FAILURE} state.
   *
   * <p>When an endpoint is in transient failure, it should be reported as a skipped tablet in
   * routing hints so the server can refresh the client cache.
   *
   * @return true if the channel is in TRANSIENT_FAILURE state
   */
  boolean isTransientFailure();

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
