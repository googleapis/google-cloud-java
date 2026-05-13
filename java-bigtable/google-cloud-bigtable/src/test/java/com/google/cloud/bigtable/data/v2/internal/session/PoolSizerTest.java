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

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.GoAwayResponse;
import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.cloud.bigtable.data.v2.internal.session.PoolSizer.Sized;
import com.google.cloud.bigtable.data.v2.internal.session.SessionList.PoolStats;
import com.google.common.base.Preconditions;
import com.google.rpc.Status;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class PoolSizerTest {

  private static final float IDLE_SESSION_HEADROOM_RATIO = 0.5f;
  private static final int MIN_IDLE_SESSIONS = 5;
  private static final int MAX_IDLE_SESSIONS = 400;
  private static final int PENDING_RPCS_PER_SESSION = 10;

  private static final SessionClientConfiguration.SessionPoolConfiguration DEFAULT_CONFIG =
      SessionClientConfiguration.SessionPoolConfiguration.newBuilder()
          .setHeadroom(IDLE_SESSION_HEADROOM_RATIO)
          .setMinSessionCount(MIN_IDLE_SESSIONS)
          .setMaxSessionCount(MAX_IDLE_SESSIONS)
          .setNewSessionQueueLength(PENDING_RPCS_PER_SESSION)
          .build();

  @Test
  void testInitial() {
    PoolStats stats = new PoolStats();
    Sized pendingRpcsCount = () -> 0;
    PoolSizer sizer = new PoolSizer(stats, pendingRpcsCount, DEFAULT_CONFIG);

    assertThat(sizer.getScaleDelta()).isEqualTo(MIN_IDLE_SESSIONS);
    assertThat(sizer.handleNewCall()).isTrue();
    assertThat(sizer.handleGoAway(GoAwayResponse.getDefaultInstance())).isTrue();
    assertThat(sizer.handleSessionClose(Status.getDefaultInstance())).isTrue();
  }

  @Test
  void testTestEquilibrium() {
    PoolStats stats = new PoolStats();
    Sized pendingRpcsCount = () -> 0;
    PoolSizer sizer = new PoolSizer(stats, pendingRpcsCount, DEFAULT_CONFIG);

    stats.getTestHelper().setReadyCount(MIN_IDLE_SESSIONS);
    stats.getTestHelper().setExpectedCapacity(MIN_IDLE_SESSIONS);

    assertThat(sizer.getScaleDelta()).isEqualTo(0);
    assertThat(sizer.handleNewCall()).isFalse();
    assertThat(sizer.handleGoAway(GoAwayResponse.getDefaultInstance())).isTrue();
    assertThat(sizer.handleSessionClose(Status.getDefaultInstance())).isTrue();
  }

  @Test
  void testPendingRpcs() {
    PoolStats stats = new PoolStats();
    Sized pendingRpcsCount = () -> 9;
    PoolSizer sizer = new PoolSizer(stats, pendingRpcsCount, DEFAULT_CONFIG);

    Preconditions.checkState(
        pendingRpcsCount.getSize() > MIN_IDLE_SESSIONS,
        "Test requires the pendingCount to be larger than ready count");

    int numReadySessions = MIN_IDLE_SESSIONS;

    stats.getTestHelper().setReadyCount(numReadySessions);
    stats.getTestHelper().setInUseCount(0);
    stats.getTestHelper().setExpectedCapacity(numReadySessions);
    assertThat(sizer.getScaleDelta())
        .isEqualTo(
            (int) Math.ceil((float) pendingRpcsCount.getSize() / PENDING_RPCS_PER_SESSION)
                - numReadySessions
                + MIN_IDLE_SESSIONS);
    assertThat(sizer.handleNewCall()).isTrue();
    assertThat(sizer.handleGoAway(GoAwayResponse.getDefaultInstance())).isTrue();
    assertThat(sizer.handleSessionClose(Status.getDefaultInstance())).isTrue();
  }

  @Test
  void testInUseWithNewCall() {
    PoolStats stats = new PoolStats();
    Sized pendingRpcsCount = () -> 0;
    PoolSizer sizer = new PoolSizer(stats, pendingRpcsCount, DEFAULT_CONFIG);

    stats.getTestHelper().setReadyCount(0);
    stats.getTestHelper().setInUseCount(1);
    stats.getTestHelper().setExpectedCapacity(1);

    // Ensure that we always have at least MIN_IDLE_SESSIONS sessions available
    // Separately we want to have IDLE_SESSION_HEADROOM_RATIO available sessions, but in this case
    // MIN_IDLE_SESSIONS is the primary indicator
    assertThat(sizer.getScaleDelta()).isEqualTo(MIN_IDLE_SESSIONS);
    // Remain steady in band
    assertThat(sizer.handleNewCall()).isTrue();
    assertThat(sizer.handleGoAway(GoAwayResponse.getDefaultInstance())).isTrue();
    assertThat(sizer.handleSessionClose(Status.getDefaultInstance())).isTrue();
  }

  @Test
  void testInUseWithNewCall2() {
    PoolStats stats = new PoolStats();
    Sized pendingRpcsCount = () -> 0;
    PoolSizer sizer = new PoolSizer(stats, pendingRpcsCount, DEFAULT_CONFIG);

    stats.getTestHelper().setReadyCount(0);
    stats.getTestHelper().setInUseCount(20);
    stats.getTestHelper().setExpectedCapacity(20);

    // Separately we want to have IDLE_SESSION_HEADROOM_RATIO available sessions
    // Separately we want to ensure that we always have at least MIN_IDLE_SESSIONS sessions
    // but in this case the ratio is the primary indicator available
    assertThat(sizer.getScaleDelta()).isEqualTo(10);
    // Remain steady in band
    assertThat(sizer.handleNewCall()).isTrue();
    assertThat(sizer.handleGoAway(GoAwayResponse.getDefaultInstance())).isTrue();
    assertThat(sizer.handleSessionClose(Status.getDefaultInstance())).isTrue();
  }

  @Test
  void testEquilibriumWhenStarting() {
    PoolStats stats = new PoolStats();
    Sized pendingRpcsCount = () -> 0;
    PoolSizer sizer = new PoolSizer(stats, pendingRpcsCount, DEFAULT_CONFIG);

    stats.getTestHelper().setStartingCount(MIN_IDLE_SESSIONS);
    stats.getTestHelper().setExpectedCapacity(MIN_IDLE_SESSIONS);

    assertThat(sizer.getScaleDelta()).isEqualTo(0);
    // Remain steady in band
    assertThat(sizer.handleNewCall()).isFalse();
    assertThat(sizer.handleGoAway(GoAwayResponse.getDefaultInstance())).isTrue();
    assertThat(sizer.handleSessionClose(Status.getDefaultInstance())).isTrue();
  }

  @Test
  void testEquilibriumWhenStartingWithLoad() {
    PoolStats stats = new PoolStats();
    final AtomicInteger pendingCount = new AtomicInteger(0);
    Sized pendingRpcsCount = () -> pendingCount.get();
    PoolSizer sizer = new PoolSizer(stats, pendingRpcsCount, DEFAULT_CONFIG);

    assertThat(sizer.getScaleDelta()).isEqualTo(MIN_IDLE_SESSIONS);

    // Started 5 sessions on startup to satisfy PoolSizer.MIN_IDLE_SESSIONS.
    stats.getTestHelper().setStartingCount(MIN_IDLE_SESSIONS);
    stats.getTestHelper().setExpectedCapacity(MIN_IDLE_SESSIONS);

    // Requests start to pile up while we still have our first 5 sessions starting.
    int incomingRequests = 100;
    for (int i = 0; i < incomingRequests; i++) {
      // When we start a pending vRPC we add it to the list...
      pendingCount.incrementAndGet();
      // ... and call handleNewCall() on the sizer.
      boolean newCallVerdict = sizer.handleNewCall();
      if (i % PENDING_RPCS_PER_SESSION == 0) {
        // For 1st, 11th, 21st, 31st etc. pending call we should demand a new session to be started.
        assertThat(newCallVerdict).isTrue();
      } else {
        assertThat(newCallVerdict).isFalse();
      }

      int forPending = (int) Math.ceil((float) pendingCount.get() / PENDING_RPCS_PER_SESSION);
      int sessionsNeeded = forPending + stats.getInUseCount();
      int desiredIdleSessions = (int) Math.ceil(sessionsNeeded * IDLE_SESSION_HEADROOM_RATIO);
      desiredIdleSessions =
          Math.max(Math.min(desiredIdleSessions, MAX_IDLE_SESSIONS), MIN_IDLE_SESSIONS);
      int desiredCapacity = sessionsNeeded + desiredIdleSessions;

      assertThat(sizer.getScaleDelta())
          .isEqualTo(Math.max(0, desiredCapacity - stats.getExpectedCapacity()));

      if (newCallVerdict) {
        // Starting new session as instructed by handleNewCall().
        stats.getTestHelper().setStartingCount(stats.getStartingCount() + 1);
        stats.getTestHelper().setExpectedCapacity(stats.getExpectedCapacity() + 1);
      }
    }

    // After 100 pending RPCs we have 15 sessions starting (10 + 5 for idle headroom).
    assertThat(stats.getExpectedCapacity()).isEqualTo(15);
    assertThat(sizer.getScaleDelta()).isEqualTo(0);
    assertThat(sizer.handleNewCall()).isFalse();

    // Simulate one session has started.
    stats.getTestHelper().setStartingCount(stats.getStartingCount() - 1);
    stats.getTestHelper().setReadyCount(stats.getReadyCount() + 1);
    // One pending would be immediately taken.
    pendingCount.decrementAndGet();
    stats.getTestHelper().setReadyCount(stats.getReadyCount() - 1);
    stats.getTestHelper().setInUseCount(stats.getInUseCount() + 1);
    // And two more sessions would be requested.
    // We still have pending calls for 10 sessions.
    // + 1 in-use session now
    // + 6 for idle headroom (50% of 11)
    // = 17 sessions needed, but we only have 15
    assertThat(sizer.getScaleDelta()).isEqualTo(2);
  }
}
