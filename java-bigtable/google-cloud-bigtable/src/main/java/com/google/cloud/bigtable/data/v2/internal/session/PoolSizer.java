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

package com.google.cloud.bigtable.data.v2.internal.session;

import com.google.bigtable.v2.GoAwayResponse;
import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.cloud.bigtable.data.v2.internal.session.SessionList.PoolStats;
import com.google.rpc.Status;
import javax.annotation.CheckReturnValue;

class PoolSizer {

  // Fraction of idle sessions to keep in order to manage an increase in requests-in-flight. For
  // example, a headroom of 50% will keep enough sessions to deal with a 50% increase in QPS or a
  // 50% increase in latency (since that also increases requests-in-flight).
  private volatile float idlesSessionHeadRoom;
  private volatile int minIdleSessions;
  private volatile int maxIdleSessions;

  private final PoolStats stats;
  private final Sized pendingRpcs;

  // This resolves cold start overprovisioning issue.
  // Session creation sometimes involves creating new connection and warming the backend.
  // So it takes time, but accumulated vRPCs may be processed rather quickly as simple
  // point reads are expected to complete within 1-4ms.
  // We assume that it is okay to collect 10 pending calls per starting session so that after
  // the session is ready it takes 10-40ms to process all pending calls.
  private volatile int pendingVRpcsPerSession;

  interface Sized {
    int getSize();
  }

  PoolSizer(
      PoolStats stats,
      Sized pendingRpcs,
      SessionClientConfiguration.SessionPoolConfiguration poolConfig) {
    this.stats = stats;
    this.pendingRpcs = pendingRpcs;

    this.idlesSessionHeadRoom = poolConfig.getHeadroom();
    this.minIdleSessions = poolConfig.getMinSessionCount();
    this.maxIdleSessions = poolConfig.getMaxSessionCount();
    this.pendingVRpcsPerSession = poolConfig.getNewSessionQueueLength();
  }

  void updateConfig(SessionClientConfiguration.SessionPoolConfiguration poolConfiguration) {
    this.idlesSessionHeadRoom = poolConfiguration.getHeadroom();
    this.minIdleSessions = poolConfiguration.getMinSessionCount();
    this.maxIdleSessions = poolConfiguration.getMaxSessionCount();
    this.pendingVRpcsPerSession = poolConfiguration.getNewSessionQueueLength();
  }

  public int getScaleDelta() {
    // Assume each session handles 1 RPC at a time. This should be revisited if sessions get
    // support for multiplexing.
    int effectivePending = (int) Math.ceil((float) pendingRpcs.getSize() / pendingVRpcsPerSession);
    int sessionsInUse = effectivePending + stats.getInUseCount();
    int unboundedDesiredIdleSessions = (int) Math.ceil(sessionsInUse * idlesSessionHeadRoom);
    int desiredIdleSessions =
        Math.max(Math.min(unboundedDesiredIdleSessions, maxIdleSessions), minIdleSessions);

    int desiredCapacity = sessionsInUse + desiredIdleSessions;
    int eventualCapacity = stats.getExpectedCapacity();
    int immediateCapacity = eventualCapacity - stats.getStartingCount();

    if (desiredCapacity < immediateCapacity) {
      return desiredCapacity - immediateCapacity;
    } else if (desiredCapacity > eventualCapacity) {
      return desiredCapacity - eventualCapacity;
    } else {
      return 0;
    }
  }

  /** Returns true if the session should be replaced */
  @CheckReturnValue
  public boolean handleGoAway(GoAwayResponse msg) {
    return getScaleDelta() >= 0;
  }

  /** Returns true if the closed session should be replaced */
  @CheckReturnValue
  boolean handleSessionClose(Status statusProto) {
    return getScaleDelta() >= 0;
  }

  /** Returns true if a new session should be added. */
  @CheckReturnValue
  boolean handleNewCall() {
    return getScaleDelta() > 0;
  }
}
