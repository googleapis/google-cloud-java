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
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.stream.Collectors;

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
 * <p>After updating the list of endpoints, MultiEndpoint will switch the current endpoint to the
 * top-priority available endpoint. If you have many processes using MultiEndpoint, this may lead to
 * immediate shift of all traffic which may be undesired. To smooth this transfer, use {@link
 * Builder#withSwitchingDelay} with randomized value to introduce a jitter. MultiEndpoint will delay
 * switching from an available endpoint to another endpoint for this amount of time.
 *
 * <p>The initial state of endpoint is "unavailable" or "recovering" if using recovery timeout.
 */
@CheckReturnValue
public final class MultiEndpoint {
  @GuardedBy("this")
  private final Map<String, Endpoint> endpointsMap = new HashMap<>();

  @GuardedBy("this")
  private volatile String currentId;

  private final Duration recoveryTimeout;
  private final Duration switchingDelay;

  @GuardedBy("this")
  private ScheduledFuture<?> scheduledSwitch;

  @GuardedBy("this")
  private volatile String switchTo;

  private long fallbackCnt = 0;
  private long recoverCnt = 0;
  private long replaceCnt = 0;

  final ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);

  private MultiEndpoint(Builder builder) {
    this.recoveryTimeout = builder.recoveryTimeout;
    this.switchingDelay = builder.switchingDelay;
    this.setEndpoints(builder.endpoints);
  }

  /** Builder for MultiEndpoint. */
  public static final class Builder {
    private final List<String> endpoints;
    private Duration recoveryTimeout = Duration.ZERO;
    private Duration switchingDelay = Duration.ZERO;

    public Builder(List<String> endpoints) {
      Preconditions.checkNotNull(endpoints);
      Preconditions.checkArgument(!endpoints.isEmpty(), "Endpoints list must not be empty.");
      this.endpoints = endpoints;
    }

    /**
     * MultiEndpoint will keep the current endpoint for up to recovery timeout after it became
     * unavailable to give it some time to recover.
     */
    @CanIgnoreReturnValue
    public Builder withRecoveryTimeout(Duration timeout) {
      Preconditions.checkNotNull(timeout);
      recoveryTimeout = timeout;
      return this;
    }

    /**
     * MultiEndpoint will delay switching from an available endpoint to another endpoint for this
     * amount of time.
     */
    @CanIgnoreReturnValue
    public Builder withSwitchingDelay(Duration delay) {
      Preconditions.checkNotNull(delay);
      switchingDelay = delay;
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

  public long getFallbackCnt() {
    return fallbackCnt;
  }

  public long getRecoverCnt() {
    return recoverCnt;
  }

  public long getReplaceCnt() {
    return replaceCnt;
  }

  public List<String> getEndpoints() {
    return endpointsMap.values().stream()
        .sorted(comparingInt(Endpoint::getPriority))
        .map(Endpoint::getId)
        .collect(Collectors.toList());
  }

  synchronized Map<String, Endpoint> getEndpointsMap() {
    return endpointsMap;
  }

  Duration getRecoveryTimeout() {
    return recoveryTimeout;
  }

  boolean isRecoveryEnabled() {
    return !recoveryTimeout.isNegative() && !recoveryTimeout.isZero();
  }

  private boolean isSwitchingDelayed() {
    return !switchingDelay.isNegative() && !switchingDelay.isZero();
  }

  /** Inform MultiEndpoint when an endpoint becomes available or unavailable. */
  public synchronized void setEndpointAvailable(String endpointId, boolean available) {
    Endpoint endpoint = endpointsMap.get(endpointId);
    if (endpoint == null) {
      return;
    }

    endpoint.setAvailability(available);
    maybeUpdateCurrentEndpoint();
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
      endpointsMap.put(
          endpointId, new Endpoint(endpointId, EndpointState.UNAVAILABLE, priority++, this));
    }

    maybeUpdateCurrentEndpoint();
  }

  // Updates currentId to the top-priority available endpoint unless the current endpoint is
  // recovering.
  synchronized void maybeUpdateCurrentEndpoint() {
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

    topEndpoint.ifPresent(endpoint -> updateCurrentEndpoint(current, endpoint.getId()));
  }

  private synchronized void updateCurrentEndpoint(Endpoint current, String newCurrentId) {
    // If no current or became unavailable then switch immediately.
    if (current == null || current.getState().equals(EndpointState.UNAVAILABLE)) {
      registerSwitch(currentId, newCurrentId);
      currentId = newCurrentId;
      return;
    }

    if (!isSwitchingDelayed()) {
      registerSwitch(currentId, newCurrentId);
      currentId = newCurrentId;
      return;
    }

    switchTo = newCurrentId;
    if (switchTo.equals(currentId)) {
      return;
    }

    if (scheduledSwitch == null || scheduledSwitch.isDone()) {
      scheduledSwitch =
          executor.schedule(this::switchCurrentEndpoint, switchingDelay.toMillis(), MILLISECONDS);
    }
  }

  private synchronized void switchCurrentEndpoint() {
    registerSwitch(currentId, switchTo);
    currentId = switchTo;
  }

  private void registerSwitch(String fromId, String toId) {
    if (toId.equals(fromId) || fromId == null) {
      return;
    }

    int fromIdx = -1;
    int toIdx = -1;
    for (Endpoint e : endpointsMap.values()) {
      if (e.getId().equals(fromId)) {
        fromIdx = e.getPriority();
      } else if (e.getId().equals(toId)) {
        toIdx = e.getPriority();
      }
    }

    if (fromIdx == -1) {
      replaceCnt++;
    } else if (fromIdx < toIdx) {
      fallbackCnt++;
    } else {
      recoverCnt++;
    }
  }

  // It is okay to read currentId and endpointsMap without obtaining a lock here.
  @SuppressWarnings("GuardedBy")
  @Override
  public String toString() {
    return "MultiEndpoint{"
        + "endpointsMap="
        + endpointsMap
        + ", currentId='"
        + currentId
        + "', recoveryTimeout="
        + recoveryTimeout
        + ", switchingDelay="
        + switchingDelay
        + ", scheduledSwitch="
        + scheduledSwitch
        + ", switchTo='"
        + switchTo
        + "', executor="
        + executor
        + '}';
  }
}
