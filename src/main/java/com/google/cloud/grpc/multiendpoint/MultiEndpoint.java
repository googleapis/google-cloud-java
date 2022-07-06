/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.grpc.multiendpoint;

import static java.util.Comparator.comparingInt;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

import com.google.cloud.grpc.multiendpoint.Endpoint.EndpointState;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * MultiEndpoint holds a list of endpoints, tracks their availability and defines the current
 * endpoint. An endpoint has a priority defined by its position in the list (first item has top
 * priority). MultiEndpoint returns top priority endpoint that is available as current. If no
 * endpoint is available, MultiEndpoint returns the top priority endpoint.
 *
 * <p>Sometimes switching between endpoints can be costly, and it is worth waiting for some time
 * after current endpoint becomes unavailable. For this case, use {@link
 * Builder#withRecoveryTimeout} to set the recovery timeout. MultiEndpoint will keep the current
 * endpoint for up to recovery timeout after it became unavailable to give it some time to recover.
 *
 * <p>The list of endpoints can be changed at any time with {@link #setEndpoints} method.
 * MultiEndpoint will preserve endpoints' state and update their priority according to their new
 * positions.
 *
 * <p>The initial state of endpoint is "unavailable" or "recovering" if using recovery timeout.
 */
@CheckReturnValue
public final class MultiEndpoint {
  @GuardedBy("this")
  private final Map<String, Endpoint> endpointsMap = new HashMap<>();

  @GuardedBy("this")
  private String currentId;

  private final Duration recoveryTimeout;
  private final boolean recoveryEnabled;

  private final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

  private MultiEndpoint(Builder builder) {
    this.recoveryTimeout = builder.recoveryTimeout;
    this.recoveryEnabled =
        !builder.recoveryTimeout.isNegative() && !builder.recoveryTimeout.isZero();
    this.setEndpoints(builder.endpoints);
  }

  /** Builder for MultiEndpoint. */
  public static final class Builder {
    private final List<String> endpoints;
    private Duration recoveryTimeout = Duration.ZERO;

    public Builder(List<String> endpoints) {
      Preconditions.checkNotNull(endpoints);
      Preconditions.checkArgument(!endpoints.isEmpty(), "Endpoints list must not be empty.");
      this.endpoints = endpoints;
    }

    /**
     * MultiEndpoint will keep the current endpoint for up to recovery timeout after it became
     * unavailable to give it some time to recover.
     */
    public Builder withRecoveryTimeout(Duration timeout) {
      Preconditions.checkNotNull(timeout);
      this.recoveryTimeout = timeout;
      return this;
    }

    public MultiEndpoint build() {
      return new MultiEndpoint(this);
    }
  }

  /**
   * Returns current endpoint id.
   *
   * <p>Note that the read is not synchronized and in case of a race condition there is a chance of
   * getting an outdated current id.
   */
  @SuppressWarnings("GuardedBy")
  public String getCurrentId() {
    return currentId;
  }

  private synchronized void setEndpointStateInternal(String endpointId, EndpointState state) {
    Endpoint endpoint = endpointsMap.get(endpointId);
    if (endpoint != null) {
      endpoint.setState(state);
      maybeFallback();
    }
  }

  /** Inform MultiEndpoint when an endpoint becomes available or unavailable. */
  public synchronized void setEndpointAvailable(String endpointId, boolean available) {
    setEndpointState(endpointId, available ? EndpointState.AVAILABLE : EndpointState.UNAVAILABLE);
  }

  private synchronized void setEndpointState(String endpointId, EndpointState state) {
    Preconditions.checkNotNull(state);
    Endpoint endpoint = endpointsMap.get(endpointId);
    if (endpoint == null) {
      return;
    }
    // If we allow some recovery time.
    if (EndpointState.UNAVAILABLE.equals(state) && recoveryEnabled) {
      endpoint.setState(EndpointState.RECOVERING);
      ScheduledFuture<?> future =
          executor.schedule(
              () -> setEndpointStateInternal(endpointId, EndpointState.UNAVAILABLE),
              recoveryTimeout.toMillis(),
              MILLISECONDS);
      endpoint.setChangeStateFuture(future);
      return;
    }
    endpoint.resetStateChangeFuture();
    endpoint.setState(state);
    maybeFallback();
  }

  /**
   * Provide an updated list of endpoints to MultiEndpoint.
   *
   * <p>MultiEndpoint will preserve current endpoints' state and update their priority according to
   * their new positions.
   */
  public synchronized void setEndpoints(List<String> endpoints) {
    Preconditions.checkNotNull(endpoints);
    Preconditions.checkArgument(!endpoints.isEmpty(), "Endpoints list must not be empty.");

    // Remove obsolete endpoints.
    endpointsMap.keySet().retainAll(endpoints);

    // Add new endpoints and update priority.
    int priority = 0;
    for (String endpointId : endpoints) {
      Endpoint existingEndpoint = endpointsMap.get(endpointId);
      if (existingEndpoint != null) {
        existingEndpoint.setPriority(priority++);
        continue;
      }
      EndpointState newState =
          recoveryEnabled ? EndpointState.RECOVERING : EndpointState.UNAVAILABLE;
      Endpoint newEndpoint = new Endpoint(endpointId, newState, priority++);
      if (recoveryEnabled) {
        ScheduledFuture<?> future =
            executor.schedule(
                () -> setEndpointStateInternal(endpointId, EndpointState.UNAVAILABLE),
                recoveryTimeout.toMillis(),
                MILLISECONDS);
        newEndpoint.setChangeStateFuture(future);
      }
      endpointsMap.put(endpointId, newEndpoint);
    }

    maybeFallback();
  }

  private synchronized void maybeFallback() {
    Optional<Endpoint> topEndpoint =
        endpointsMap.values().stream()
            .filter((c) -> c.getState().equals(EndpointState.AVAILABLE))
            .min(comparingInt(Endpoint::getPriority));

    Endpoint current = endpointsMap.get(currentId);
    if (current != null && current.getState().equals(EndpointState.RECOVERING)) {
      // Keep recovering endpoint as current unless a higher priority endpoint became available.
      if (!topEndpoint.isPresent() || topEndpoint.get().getPriority() >= current.getPriority()) {
        return;
      }
    }

    if (!topEndpoint.isPresent() && current == null) {
      topEndpoint = endpointsMap.values().stream().min(comparingInt(Endpoint::getPriority));
    }

    topEndpoint.ifPresent(endpoint -> currentId = endpoint.getId());
  }
}
