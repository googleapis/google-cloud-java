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

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import com.google.errorprone.annotations.CheckReturnValue;
import java.util.concurrent.ScheduledFuture;

/** Endpoint holds an endpoint's state, priority and a future of upcoming state change. */
@CheckReturnValue
final class Endpoint {

  /** Holds a state of an endpoint. */
  public enum EndpointState {
    UNAVAILABLE,
    AVAILABLE,
    RECOVERING,
  }

  private final String id;
  private EndpointState state;
  private long lastStateChangeNano;
  private int priority;
  private ScheduledFuture<?> changeStateFuture;
  private final MultiEndpoint multiEndpoint;

  Endpoint(String id, EndpointState state, int priority, MultiEndpoint multiEndpoint) {
    this.id = id;
    this.priority = priority;
    this.multiEndpoint = multiEndpoint;
    setAvailability(EndpointState.AVAILABLE.equals(state));
  }

  public String getId() {
    return id;
  }

  public EndpointState getState() {
    return state;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  // Internal method to change state to any state.
  private void setState(EndpointState state) {
    synchronized (multiEndpoint) {
      if (changeStateFuture != null) {
        changeStateFuture.cancel(false);
      }
      this.state = state;
      lastStateChangeNano = System.nanoTime();
    }
  }

  void setAvailability(boolean available) {
    synchronized (multiEndpoint) {
      if (available) {
        setState(EndpointState.AVAILABLE);
        return;
      }

      if (state != null && !EndpointState.AVAILABLE.equals(state)) {
        return;
      }

      if (!multiEndpoint.isRecoveryEnabled()) {
        setState(EndpointState.UNAVAILABLE);
        return;
      }

      setState(EndpointState.RECOVERING);
      final long stateChangeNano = lastStateChangeNano;
      changeStateFuture =
          multiEndpoint.executor.schedule(
              () -> triggerRecoveryTimeout(stateChangeNano),
              multiEndpoint.getRecoveryTimeout().toMillis(),
              MILLISECONDS);
    }
  }

  private void triggerRecoveryTimeout(long statusChangeNano) {
    synchronized (multiEndpoint) {
      if (lastStateChangeNano != statusChangeNano) {
        // This timer is outdated.
        return;
      }

      setState(EndpointState.UNAVAILABLE);
      multiEndpoint.maybeUpdateCurrentEndpoint();
    }
  }

  @Override
  public String toString() {
    return "Endpoint{"
        + "id='"
        + id
        + "', state="
        + state
        + ", lastStateChangeNano="
        + lastStateChangeNano
        + ", priority="
        + priority
        + ", changeStateFuture="
        + changeStateFuture
        + '}';
  }
}
