/*
 * Copyright 2016 Google LLC
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

import static com.google.api.gax.batching.AssertByPolling.assertByPolling;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.api.gax.batching.FlowController.FlowControlException;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.common.util.concurrent.SettableFuture;
import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/** Tests for {@link FlowController}. */
class FlowControllerTest {

  @Test
  void testReserveRelease_ok() throws Exception {
    FlowController flowController =
        new FlowController(
            FlowControlSettings.newBuilder()
                .setMaxOutstandingElementCount(10L)
                .setMaxOutstandingRequestBytes(10L)
                .setLimitExceededBehavior(LimitExceededBehavior.Block)
                .build());

    flowController.reserve(1, 1);
    flowController.release(1, 1);
  }

  @Test
  void testInvalidArguments() throws Exception {
    FlowController flowController =
        new FlowController(
            FlowControlSettings.newBuilder()
                .setMaxOutstandingElementCount(10L)
                .setMaxOutstandingRequestBytes(10L)
                .setLimitExceededBehavior(LimitExceededBehavior.Block)
                .build());

    flowController.reserve(0, 0);
    try {
      flowController.reserve(-1, 1);
      fail("Must have thrown an illegal argument error");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      flowController.reserve(1, -1);
      fail("Must have thrown an illegal argument error");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    flowController.increaseThresholds(0, 0);
    flowController.decreaseThresholds(0, 0);
    try {
      flowController.increaseThresholds(-1, 1);
      fail("Must have thrown an illegal argument error");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      flowController.decreaseThresholds(1, -1);
      fail("Must have thrown an illegal argument error");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
  }

  @Test
  void testReserveRelease_noLimits_ok() throws Exception {
    FlowController flowController =
        new FlowController(
            FlowControlSettings.newBuilder()
                .setLimitExceededBehavior(LimitExceededBehavior.Block)
                .build());

    flowController.reserve(1, 1);
    flowController.release(1, 1);
  }

  @Test
  void testReserveRelease_ignore_ok() throws Exception {
    FlowController flowController =
        new FlowController(
            FlowControlSettings.newBuilder()
                .setMaxOutstandingElementCount(1L)
                .setMaxOutstandingRequestBytes(1L)
                .setLimitExceededBehavior(LimitExceededBehavior.Ignore)
                .build());

    flowController.reserve(1, 1);
    flowController.release(1, 1);
  }

  @Test
  void testReserveRelease_blockedByElementCount() throws Exception {
    FlowController flowController =
        new FlowController(
            FlowControlSettings.newBuilder()
                .setMaxOutstandingElementCount(10L)
                .setMaxOutstandingRequestBytes(100L)
                .setLimitExceededBehavior(LimitExceededBehavior.Block)
                .build());

    testBlockingReserveRelease(flowController, 10, 10);
  }

  @Test
  void testReserveRelease_blockedByElementCount_noBytesLimit() throws Exception {
    FlowController flowController =
        new FlowController(
            FlowControlSettings.newBuilder()
                .setMaxOutstandingElementCount(10L)
                .setLimitExceededBehavior(LimitExceededBehavior.Block)
                .build());

    testBlockingReserveRelease(flowController, 10, 10);
  }

  @Test
  void testReserveRelease_blockedByNumberOfBytes() throws Exception {
    FlowController flowController =
        new FlowController(
            FlowControlSettings.newBuilder()
                .setMaxOutstandingElementCount(100L)
                .setMaxOutstandingRequestBytes(10L)
                .setLimitExceededBehavior(LimitExceededBehavior.Block)
                .build());

    testBlockingReserveRelease(flowController, 10, 10);
  }

  @Test
  void testReserveRelease_blockedByNumberOfBytes_noElementCountLimit() throws Exception {
    FlowController flowController =
        new FlowController(
            FlowControlSettings.newBuilder()
                .setMaxOutstandingRequestBytes(10L)
                .setLimitExceededBehavior(LimitExceededBehavior.Block)
                .build());

    testBlockingReserveRelease(flowController, 10, 10);
  }

  private static void testBlockingReserveRelease(
      final FlowController flowController, final int maxElementCount, final int maxNumBytes)
      throws Exception {

    flowController.reserve(1, 1);

    final SettableFuture<?> permitsReserved = SettableFuture.create();
    Future<?> finished =
        Executors.newCachedThreadPool()
            .submit(
                () -> {
                  try {
                    permitsReserved.set(null);
                    flowController.reserve(maxElementCount, maxNumBytes);
                  } catch (FlowControlException e) {
                    throw new AssertionError(e);
                  }
                });

    permitsReserved.get();
    assertFalse(finished.isDone());
    flowController.release(1, 1);

    finished.get(50, TimeUnit.MILLISECONDS);
    flowController.release(maxElementCount, maxNumBytes);
  }

  @Test
  void testReserveRelease_rejectedByElementCount() throws Exception {
    FlowController flowController =
        new FlowController(
            FlowControlSettings.newBuilder()
                .setMaxOutstandingElementCount(10L)
                .setMaxOutstandingRequestBytes(100L)
                .setLimitExceededBehavior(LimitExceededBehavior.ThrowException)
                .build());

    testRejectedReserveRelease(
        flowController, 10, 10, FlowController.MaxOutstandingElementCountReachedException.class);
    assertNotNull(flowController.getFlowControlEventStats().getLastFlowControlEvent());
    assertThat(flowController.getFlowControlEventStats().getLastFlowControlEvent().getException())
        .isInstanceOf(FlowController.MaxOutstandingElementCountReachedException.class);
  }

  @Test
  void testReserveRelease_rejectedByElementCount_noBytesLimit() throws Exception {
    FlowController flowController =
        new FlowController(
            FlowControlSettings.newBuilder()
                .setMaxOutstandingElementCount(10L)
                .setLimitExceededBehavior(LimitExceededBehavior.ThrowException)
                .build());

    testRejectedReserveRelease(
        flowController, 10, 10, FlowController.MaxOutstandingElementCountReachedException.class);
  }

  @Test
  void testReserveRelease_rejectedByNumberOfBytes() throws Exception {
    FlowController flowController =
        new FlowController(
            FlowControlSettings.newBuilder()
                .setMaxOutstandingElementCount(100L)
                .setMaxOutstandingRequestBytes(10L)
                .setLimitExceededBehavior(LimitExceededBehavior.ThrowException)
                .build());

    testRejectedReserveRelease(
        flowController, 10, 10, FlowController.MaxOutstandingRequestBytesReachedException.class);
    assertNotNull(flowController.getFlowControlEventStats().getLastFlowControlEvent());
    assertThat(flowController.getFlowControlEventStats().getLastFlowControlEvent().getException())
        .isInstanceOf(FlowController.MaxOutstandingRequestBytesReachedException.class);
  }

  @Test
  void testReserveRelease_rejectedByNumberOfBytes_noElementCountLimit() throws Exception {
    FlowController flowController =
        new FlowController(
            FlowControlSettings.newBuilder()
                .setMaxOutstandingRequestBytes(10L)
                .setLimitExceededBehavior(LimitExceededBehavior.ThrowException)
                .build());

    testRejectedReserveRelease(
        flowController, 10, 10, FlowController.MaxOutstandingRequestBytesReachedException.class);
  }

  @Test
  void testRestoreAfterFail() throws FlowController.FlowControlException {
    FlowController flowController =
        new FlowController(
            FlowControlSettings.newBuilder()
                .setMaxOutstandingElementCount(2L)
                .setMaxOutstandingRequestBytes(1L)
                .setLimitExceededBehavior(LimitExceededBehavior.ThrowException)
                .build());

    flowController.reserve(1, 1);

    try {
      flowController.reserve(1, 1);
      throw new IllegalStateException("flowController should not have any bytes left");
    } catch (FlowController.MaxOutstandingRequestBytesReachedException e) {
      // Ignore.
    }
    flowController.reserve(1, 0);
  }

  @Test
  void testConstructedByDynamicFlowControlSetting() {
    FlowController flowController =
        new FlowController(
            DynamicFlowControlSettings.newBuilder()
                .setMinOutstandingElementCount(1L)
                .setInitialOutstandingElementCount(2L)
                .setMaxOutstandingElementCount(3L)
                .setMinOutstandingRequestBytes(10L)
                .setInitialOutstandingRequestBytes(20L)
                .setMaxOutstandingRequestBytes(30L)
                .setLimitExceededBehavior(LimitExceededBehavior.Block)
                .build());
    assertEquals(1, flowController.getMinElementCountLimit().longValue());
    assertEquals(2, flowController.getCurrentElementCountLimit().longValue());
    assertEquals(3, flowController.getMaxElementCountLimit().longValue());
    assertEquals(10, flowController.getMinRequestBytesLimit().longValue());
    assertEquals(20, flowController.getCurrentRequestBytesLimit().longValue());
    assertEquals(30, flowController.getMaxRequestBytesLimit().longValue());

    flowController =
        new FlowController(
            DynamicFlowControlSettings.newBuilder()
                .setMinOutstandingElementCount(1L)
                .setInitialOutstandingElementCount(2L)
                .setMaxOutstandingElementCount(3L)
                .setMinOutstandingRequestBytes(10L)
                .setInitialOutstandingRequestBytes(20L)
                .setMaxOutstandingRequestBytes(30L)
                .setLimitExceededBehavior(LimitExceededBehavior.Ignore)
                .build());
    assertNull(flowController.getMinElementCountLimit());
    assertNull(flowController.getCurrentElementCountLimit());
    assertNull(flowController.getMaxElementCountLimit());
    assertNull(flowController.getMinRequestBytesLimit());
    assertNull(flowController.getCurrentRequestBytesLimit());
    assertNull(flowController.getMaxRequestBytesLimit());
    assertNotNull(flowController.getFlowControlEventStats());
  }

  @Test
  void testIncreaseThresholds_blocking() throws Exception {
    FlowController flowController =
        new FlowController(
            DynamicFlowControlSettings.newBuilder()
                .setInitialOutstandingElementCount(10L)
                .setMinOutstandingElementCount(2L)
                .setMaxOutstandingElementCount(20L)
                .setInitialOutstandingRequestBytes(10L)
                .setMinOutstandingRequestBytes(2L)
                .setMaxOutstandingRequestBytes(20L)
                .setLimitExceededBehavior(LimitExceededBehavior.Block)
                .build());

    assertEquals(10L, flowController.getCurrentElementCountLimit().longValue());
    assertEquals(10L, flowController.getCurrentRequestBytesLimit().longValue());
    testBlockingReserveRelease(flowController, 10, 0);
    testBlockingReserveRelease(flowController, 0, 10);

    flowController.increaseThresholds(5, 5);
    assertEquals(15L, flowController.getCurrentElementCountLimit().longValue());
    assertEquals(15L, flowController.getCurrentRequestBytesLimit().longValue());
    testBlockingReserveRelease(flowController, 15, 0);
    testBlockingReserveRelease(flowController, 0, 15);

    // Thresholds can't go over max values. FlowController will set the values to max.
    flowController.increaseThresholds(10, 10);
    assertEquals(20L, flowController.getCurrentElementCountLimit().longValue());
    assertEquals(20L, flowController.getCurrentRequestBytesLimit().longValue());
    testBlockingReserveRelease(flowController, 20, 0);
    testBlockingReserveRelease(flowController, 0, 20);
  }

  @Test
  void testDecreaseThresholds_blocking() throws Exception {
    FlowController flowController =
        new FlowController(
            DynamicFlowControlSettings.newBuilder()
                .setInitialOutstandingElementCount(10L)
                .setMinOutstandingElementCount(2L)
                .setMaxOutstandingElementCount(20L)
                .setInitialOutstandingRequestBytes(10L)
                .setMinOutstandingRequestBytes(2L)
                .setMaxOutstandingRequestBytes(20L)
                .setLimitExceededBehavior(LimitExceededBehavior.Block)
                .build());

    assertEquals(10L, flowController.getCurrentElementCountLimit().longValue());
    assertEquals(10L, flowController.getCurrentRequestBytesLimit().longValue());
    testBlockingReserveRelease(flowController, 10, 0);
    testBlockingReserveRelease(flowController, 0, 10);

    flowController.decreaseThresholds(5, 5);
    assertEquals(5L, flowController.getCurrentElementCountLimit().longValue());
    assertEquals(5L, flowController.getCurrentRequestBytesLimit().longValue());
    testBlockingReserveRelease(flowController, 5, 0);
    testBlockingReserveRelease(flowController, 0, 5);

    // Thresholds can't go below min values. FlowController will set them to min svalues.
    flowController.decreaseThresholds(5, 5);
    assertEquals(2L, flowController.getCurrentElementCountLimit().longValue());
    assertEquals(2L, flowController.getCurrentRequestBytesLimit().longValue());
    testBlockingReserveRelease(flowController, 2, 0);
    testBlockingReserveRelease(flowController, 0, 2);
  }

  @Test
  void testIncreaseThresholds_nonBlocking() throws Exception {
    FlowController flowController =
        new FlowController(
            DynamicFlowControlSettings.newBuilder()
                .setInitialOutstandingElementCount(10L)
                .setMinOutstandingElementCount(2L)
                .setMaxOutstandingElementCount(20L)
                .setInitialOutstandingRequestBytes(10L)
                .setMinOutstandingRequestBytes(2L)
                .setMaxOutstandingRequestBytes(20L)
                .setLimitExceededBehavior(LimitExceededBehavior.ThrowException)
                .build());

    assertEquals(10L, flowController.getCurrentElementCountLimit().longValue());
    assertEquals(10L, flowController.getCurrentRequestBytesLimit().longValue());
    testRejectedReserveRelease(
        flowController, 10, 0, FlowController.MaxOutstandingElementCountReachedException.class);
    testRejectedReserveRelease(
        flowController, 0, 10, FlowController.MaxOutstandingRequestBytesReachedException.class);

    flowController.increaseThresholds(5, 5);
    assertEquals(15L, flowController.getCurrentElementCountLimit().longValue());
    assertEquals(15L, flowController.getCurrentRequestBytesLimit().longValue());
    testRejectedReserveRelease(
        flowController, 15, 0, FlowController.MaxOutstandingElementCountReachedException.class);
    testRejectedReserveRelease(
        flowController, 0, 15, FlowController.MaxOutstandingRequestBytesReachedException.class);

    // Thresholds can't go over max values. FlowController will set the values to max.
    flowController.increaseThresholds(10, 10);
    assertEquals(20L, flowController.getCurrentElementCountLimit().longValue());
    assertEquals(20L, flowController.getCurrentRequestBytesLimit().longValue());
    testRejectedReserveRelease(
        flowController, 20, 0, FlowController.MaxOutstandingElementCountReachedException.class);
    testRejectedReserveRelease(
        flowController, 0, 20, FlowController.MaxOutstandingRequestBytesReachedException.class);
  }

  @Test
  void testDecreaseThresholds_nonBlocking() throws Exception {
    FlowController flowController =
        new FlowController(
            DynamicFlowControlSettings.newBuilder()
                .setInitialOutstandingElementCount(10L)
                .setMinOutstandingElementCount(2L)
                .setMaxOutstandingElementCount(20L)
                .setInitialOutstandingRequestBytes(10L)
                .setMinOutstandingRequestBytes(2L)
                .setMaxOutstandingRequestBytes(20L)
                .setLimitExceededBehavior(LimitExceededBehavior.ThrowException)
                .build());

    assertEquals(10L, flowController.getCurrentElementCountLimit().longValue());
    assertEquals(10L, flowController.getCurrentRequestBytesLimit().longValue());
    testRejectedReserveRelease(
        flowController, 10, 0, FlowController.MaxOutstandingElementCountReachedException.class);
    testRejectedReserveRelease(
        flowController, 0, 10, FlowController.MaxOutstandingRequestBytesReachedException.class);

    flowController.decreaseThresholds(5, 5);
    assertEquals(5L, flowController.getCurrentElementCountLimit().longValue());
    assertEquals(5L, flowController.getCurrentRequestBytesLimit().longValue());
    testRejectedReserveRelease(
        flowController, 5, 0, FlowController.MaxOutstandingElementCountReachedException.class);
    testRejectedReserveRelease(
        flowController, 0, 5, FlowController.MaxOutstandingRequestBytesReachedException.class);

    // Thresholds can't go below min values. FlowController will set them to min svalues.
    flowController.decreaseThresholds(5, 5);
    assertEquals(2L, flowController.getCurrentElementCountLimit().longValue());
    assertEquals(2L, flowController.getCurrentRequestBytesLimit().longValue());
    testRejectedReserveRelease(
        flowController, 2, 0, FlowController.MaxOutstandingElementCountReachedException.class);
    testRejectedReserveRelease(
        flowController, 0, 2, FlowController.MaxOutstandingRequestBytesReachedException.class);
  }

  private void testRejectedReserveRelease(
      FlowController flowController,
      int maxElementCount,
      int maxNumBytes,
      Class<? extends FlowController.FlowControlException> expectedException)
      throws FlowController.FlowControlException {

    flowController.reserve(1, 1);

    try {
      flowController.reserve(maxElementCount, maxNumBytes);
      fail("Should thrown a FlowController.FlowControlException");
    } catch (FlowController.FlowControlException e) {
      assertTrue(expectedException.isInstance(e));
    }

    flowController.release(1, 1);
    flowController.reserve(maxElementCount, maxNumBytes);
    flowController.release(maxElementCount, maxNumBytes);
  }

  @Test
  void testConcurrentUpdateThresholds_blocking() throws Exception {
    int initialValue = 5000;
    FlowController flowController =
        new FlowController(
            DynamicFlowControlSettings.newBuilder()
                .setInitialOutstandingElementCount((long) initialValue)
                .setMinOutstandingElementCount(1L)
                .setMaxOutstandingElementCount(10000L)
                .setInitialOutstandingRequestBytes((long) initialValue)
                .setMinOutstandingRequestBytes(1L)
                .setMaxOutstandingRequestBytes(50000L)
                .setLimitExceededBehavior(LimitExceededBehavior.Block)
                .build());
    final AtomicInteger totalIncreased = new AtomicInteger(0);
    final AtomicInteger totalDecreased = new AtomicInteger(0);
    final AtomicInteger releasedCounter = new AtomicInteger(0);

    List<Future<?>> reserveThreads =
        testConcurrentUpdates(
            flowController, 100, 100, 10, totalIncreased, totalDecreased, releasedCounter);
    for (Future<?> t : reserveThreads) {
      t.get(200, TimeUnit.MILLISECONDS);
    }
    assertEquals(reserveThreads.size(), releasedCounter.get());
    assertTrue(totalIncreased.get() > 0);
    assertTrue(totalDecreased.get() > 0);
    int expectedValue = initialValue + totalIncreased.get() - totalDecreased.get();
    assertEquals(expectedValue, flowController.getCurrentRequestBytesLimit().longValue());
    assertEquals(expectedValue, flowController.getCurrentElementCountLimit().longValue());
    testBlockingReserveRelease(flowController, expectedValue, 0);
    testBlockingReserveRelease(flowController, 0, expectedValue);
  }

  @Test
  void testConcurrentUpdateThresholds_nonBlocking() throws Exception {
    int initialValue = 5000;
    FlowController flowController =
        new FlowController(
            DynamicFlowControlSettings.newBuilder()
                .setInitialOutstandingElementCount((long) initialValue)
                .setMinOutstandingElementCount(1L)
                .setMaxOutstandingElementCount(10000L)
                .setInitialOutstandingRequestBytes((long) initialValue)
                .setMinOutstandingRequestBytes(1L)
                .setMaxOutstandingRequestBytes(50000L)
                .setLimitExceededBehavior(LimitExceededBehavior.ThrowException)
                .build());
    AtomicInteger totalIncreased = new AtomicInteger(0);
    AtomicInteger totalDecreased = new AtomicInteger(0);
    AtomicInteger releasedCounter = new AtomicInteger(0);
    List<Future<?>> reserveThreads =
        testConcurrentUpdates(
            flowController, 100, 100, 100, totalIncreased, totalDecreased, releasedCounter);
    for (Future<?> t : reserveThreads) {
      t.get(200, TimeUnit.MILLISECONDS);
    }
    assertEquals(reserveThreads.size(), releasedCounter.get());
    assertTrue(totalIncreased.get() > 0);
    assertTrue(totalDecreased.get() > 0);
    int expectedValue = initialValue + totalIncreased.get() - totalDecreased.get();
    assertEquals(expectedValue, flowController.getCurrentRequestBytesLimit().longValue());
    assertEquals(expectedValue, flowController.getCurrentElementCountLimit().longValue());
    testRejectedReserveRelease(
        flowController,
        expectedValue,
        0,
        FlowController.MaxOutstandingElementCountReachedException.class);
    testRejectedReserveRelease(
        flowController,
        0,
        expectedValue,
        FlowController.MaxOutstandingRequestBytesReachedException.class);
  }

  @Test
  void testNumberOfBytesOutOfBoundaryWontDeadlock() throws Exception {
    // Test the special case where in FlowController#reserve, to avoid deadlocks, it allows
    // reserving byte size greater than current request bytes limit.
    int initial = 50;
    final FlowController flowController =
        new FlowController(
            DynamicFlowControlSettings.newBuilder()
                .setInitialOutstandingRequestBytes((long) initial)
                .setMinOutstandingRequestBytes(1L)
                .setMaxOutstandingRequestBytes(100L)
                .setLimitExceededBehavior(LimitExceededBehavior.Block)
                .build());
    flowController.reserve(0, 10);
    // will be blocked by reserve 10
    Thread t =
        new Thread(
            () -> {
              try {
                flowController.reserve(0, 100);
              } catch (FlowControlException e) {
                throw new AssertionError(e);
              }
            });
    t.start();

    // wait for thread to start, and check it should be blocked
    assertByPolling(
        java.time.Duration.ofMillis(200), () -> assertEquals(State.WAITING, t.getState()));

    // increase and decrease should not be blocked
    int increase = 5, decrease = 20;
    flowController.decreaseThresholds(0, decrease);
    flowController.increaseThresholds(0, increase);
    // releasing 10 permits should unblock t
    flowController.release(0, 10);
    t.join();
    int expectedNewThreshold = initial - decrease + increase;
    assertEquals(expectedNewThreshold, flowController.getCurrentRequestBytesLimit().longValue());
    flowController.release(0, 100);
    // Verify no extra permits are released to the semaphore
    testBlockingReserveRelease(flowController, 0, expectedNewThreshold);
  }

  @Test
  @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
  void testElementCountsOutOfBoundaryWontDeadlock() throws Exception {
    // Test the special case where in FlowController#reserve, to avoid deadlocks, it allows
    // reserving byte size greater than current request bytes limit.
    final int initial = 50;
    final FlowController flowController =
        new FlowController(
            DynamicFlowControlSettings.newBuilder()
                .setInitialOutstandingElementCount((long) initial)
                .setMinOutstandingElementCount(1L)
                .setMaxOutstandingElementCount(100L)
                .setInitialOutstandingRequestBytes((long) initial)
                .setMinOutstandingRequestBytes(1L)
                .setMaxOutstandingRequestBytes(100L)
                .setLimitExceededBehavior(LimitExceededBehavior.Block)
                .build());
    Thread t =
        new Thread(
            () -> {
              try {
                flowController.reserve(initial + 10, 10);
              } catch (FlowControlException e) {
                throw new AssertionError(e);
              }
            });
    t.start();

    // wait for thread to start, and check it should be blocked
    assertByPolling(
        java.time.Duration.ofMillis(200), () -> assertEquals(State.WAITING, t.getState()));

    // increase and decrease should not be blocked
    int increase = 5, decrease = 20;
    flowController.decreaseThresholds(decrease, 0);
    flowController.increaseThresholds(increase, 0);
    // reserve 1 permit should also not be blocked
    flowController.reserve(1, 1);
    flowController.release(1, 1);
    // increasing permits to unblock
    flowController.increaseThresholds(50, 0);
    t.join();
  }

  @Test
  void testFlowControlBlockEventIsRecorded() throws Exception {
    // Test when reserve is blocked for at least FlowController#RESERVE_FLOW_CONTROL_THRESHOLD_MS,
    // FlowController will record the FlowControlEvent in FlowControlEventStats
    final FlowController flowController =
        new FlowController(
            DynamicFlowControlSettings.newBuilder()
                .setInitialOutstandingElementCount(5L)
                .setMinOutstandingElementCount(1L)
                .setMaxOutstandingElementCount(10L)
                .setInitialOutstandingRequestBytes(5L)
                .setMinOutstandingRequestBytes(1L)
                .setMaxOutstandingRequestBytes(10L)
                .setLimitExceededBehavior(LimitExceededBehavior.Block)
                .build());
    Runnable runnable =
        () -> {
          try {
            flowController.reserve(1, 1);
          } catch (FlowControlException e) {
            throw new AssertionError(e);
          }
        };
    // blocked by element. Reserve all 5 elements first, reserve in the runnable will be blocked
    flowController.reserve(5, 1);
    Future<?> finished1 = Executors.newSingleThreadExecutor().submit(runnable);
    try {
      finished1.get(50, TimeUnit.MILLISECONDS);
      fail("reserve should block");
    } catch (TimeoutException e) {
      // expected
    }
    assertFalse(finished1.isDone());
    flowController.release(5, 1);
    // After other elements are released, reserve in the runnable should go through. Since reserve
    // was blocked for longer than 1 millisecond, FlowController should record this event in
    // FlowControlEventStats.
    finished1.get(50, TimeUnit.MILLISECONDS);
    assertNotNull(flowController.getFlowControlEventStats().getLastFlowControlEvent());
    assertNotNull(
        flowController
            .getFlowControlEventStats()
            .getLastFlowControlEvent()
            .getThrottledTime(TimeUnit.MILLISECONDS));
    flowController.release(1, 1);

    // Similar to blocked by element, test blocking by bytes.
    flowController.reserve(1, 5);
    Future<?> finished2 = Executors.newSingleThreadExecutor().submit(runnable);
    try {
      finished2.get(50, TimeUnit.MILLISECONDS);
      fail("reserve should block");
    } catch (TimeoutException e) {
      // expected
    }
    assertFalse(finished2.isDone());
    long currentTime = System.currentTimeMillis();
    flowController.release(1, 5);
    finished2.get(50, TimeUnit.MILLISECONDS);
    assertNotNull(flowController.getFlowControlEventStats().getLastFlowControlEvent());
    // Make sure this newer event is recorded
    assertThat(flowController.getFlowControlEventStats().getLastFlowControlEvent().getTimestampMs())
        .isAtLeast(currentTime);
  }

  private List<Future<?>> testConcurrentUpdates(
      final FlowController flowController,
      final int increaseStepRange,
      final int decreaseStepRange,
      final int reserve,
      final AtomicInteger totalIncreased,
      final AtomicInteger totalDecreased,
      final AtomicInteger releasedCounter)
      throws InterruptedException, TimeoutException, ExecutionException {
    final Random random = new Random();
    Runnable increaseRunnable =
        () -> {
          int increase = random.nextInt(increaseStepRange) + 1;
          flowController.increaseThresholds(increase, increase);
          totalIncreased.addAndGet(increase);
        };
    Runnable decreaseRunnable =
        () -> {
          int decrease = random.nextInt(decreaseStepRange) + 1;
          flowController.decreaseThresholds(decrease, decrease);
          totalDecreased.addAndGet(decrease);
        };
    Runnable reserveReleaseRunnable =
        () -> {
          try {
            flowController.reserve(reserve, reserve);
            flowController.release(reserve, reserve);
            releasedCounter.incrementAndGet();
          } catch (Exception e) {
          }
        };
    List<Future<?>> updateFuture = new ArrayList<>();
    List<Future<?>> reserveReleaseFuture = new ArrayList<>();
    ExecutorService executors = Executors.newFixedThreadPool(10);
    ExecutorService reserveExecutor = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 5; i++) {
      updateFuture.add(executors.submit(increaseRunnable));
      updateFuture.add(executors.submit(decreaseRunnable));
      reserveReleaseFuture.add(reserveExecutor.submit(reserveReleaseRunnable));
    }
    for (Future<?> t : updateFuture) {
      t.get(50, TimeUnit.MILLISECONDS);
    }
    executors.shutdown();
    return reserveReleaseFuture;
  }
}
