/*
 * Copyright 2021 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.batching;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.api.gax.batching.FlowControlEventStats.FlowControlEvent;
import com.google.api.gax.batching.FlowController.MaxOutstandingRequestBytesReachedException;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

class FlowControlEventStatsTest {

  @Test
  void testCreateEvent() {
    long timestamp = 12345, throttledTimeMs = 5000;
    FlowControlEvent event = FlowControlEvent.createReserveDelayed(timestamp, throttledTimeMs);
    assertEquals(event.getTimestampMs(), event.getTimestampMs());
    assertEquals(throttledTimeMs / 1000, event.getThrottledTime(TimeUnit.SECONDS).longValue());
    assertNull(event.getException());

    MaxOutstandingRequestBytesReachedException exception =
        new MaxOutstandingRequestBytesReachedException(100);
    event = FlowControlEvent.createReserveDenied(timestamp, exception);
    assertEquals(timestamp, event.getTimestampMs());
    assertNotNull(event.getException());
    assertEquals(exception, event.getException());
    assertNull(event.getThrottledTime(TimeUnit.MILLISECONDS));

    try {
      event = FlowControlEvent.createReserveDenied(null);
      fail("FlowControlEvent did not throw exception");
    } catch (NullPointerException e) {
      // expected, ignore
    }
  }

  @Test
  void testGetLastEvent() {
    FlowControlEventStats stats = new FlowControlEventStats();
    long currentTime = System.currentTimeMillis();

    for (int i = 1; i <= 10; i++) {
      int timeElapsed = i;
      stats.recordFlowControlEvent(
          FlowControlEvent.createReserveDelayed(currentTime + timeElapsed, timeElapsed));
    }

    assertEquals(currentTime + 10, stats.getLastFlowControlEvent().getTimestampMs());
    assertEquals(
        10, stats.getLastFlowControlEvent().getThrottledTime(TimeUnit.MILLISECONDS).longValue());
  }
}
