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

import com.google.errorprone.annotations.CheckReturnValue;
import java.util.concurrent.ScheduledFuture;

/**
 * Endpoint holds an endpoint's state, priority and a future of upcoming state change.
 */
@CheckReturnValue
final class Endpoint {

  /**
   * Holds a state of an endpoint.
   */
  public enum EndpointState {
    UNAVAILABLE,
    AVAILABLE,
    RECOVERING,
  }

  private final String id;
  private EndpointState state;
  private int priority;
  private ScheduledFuture<?> changeStateFuture;

  public Endpoint(String id, EndpointState state, int priority) {
    this.id = id;
    this.priority = priority;
    this.state = state;
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

  public void setState(EndpointState state) {
    this.state = state;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public synchronized void setChangeStateFuture(ScheduledFuture<?> future) {
    resetStateChangeFuture();
    this.changeStateFuture = future;
  }

  public synchronized void resetStateChangeFuture() {
    if (changeStateFuture != null) {
      changeStateFuture.cancel(true);
    }
  }
}
