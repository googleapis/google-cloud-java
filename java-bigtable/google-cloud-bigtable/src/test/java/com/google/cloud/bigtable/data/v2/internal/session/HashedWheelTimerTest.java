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

import com.google.cloud.bigtable.data.v2.internal.session.BigtableTimer.Registration;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(value = 10, unit = TimeUnit.SECONDS)
class HashedWheelTimerTest {
  private static final Executor DIRECT = MoreExecutors.directExecutor();

  private HashedWheelTimer timer;

  @AfterEach
  void tearDown() {
    if (timer != null) {
      timer.stop();
    }
  }

  @Test
  void schedule_fires_after_delay() throws Exception {
    timer = new HashedWheelTimer("wheel-test");
    CountDownLatch latch = new CountDownLatch(1);

    timer.newTimeout(latch::countDown, DIRECT, 10, TimeUnit.MILLISECONDS);

    assertThat(latch.await(1, TimeUnit.SECONDS)).isTrue();
  }

  @Test
  void cancel_before_fire_prevents_execution() throws Exception {
    timer = new HashedWheelTimer("wheel-test");
    AtomicInteger fires = new AtomicInteger();

    BigtableTimer.Timeout t =
        timer.newTimeout(fires::incrementAndGet, DIRECT, 100, TimeUnit.MILLISECONDS);
    assertThat(t.cancel()).isTrue();
    assertThat(t.isCancelled()).isTrue();

    Thread.sleep(200);
    assertThat(fires.get()).isEqualTo(0);
  }

  @Test
  void stop_runs_all_hooks_on_caller_thread_then_newTimeout_returns_dead() {
    timer = new HashedWheelTimer("wheel-test");
    Thread caller = Thread.currentThread();
    List<Thread> ran = new CopyOnWriteArrayList<>();

    timer.onStop(() -> ran.add(Thread.currentThread()));
    timer.onStop(() -> ran.add(Thread.currentThread()));

    timer.stop();

    assertThat(ran).hasSize(2);
    for (Thread t : ran) {
      assertThat(t).isSameInstanceAs(caller);
    }
    // After stop, newTimeout returns a pre-cancelled Timeout that never fires.
    BigtableTimer.Timeout t = timer.newTimeout(() -> {}, DIRECT, 1, TimeUnit.MILLISECONDS);
    assertThat(t.isCancelled()).isTrue();
    timer = null;
  }

  @Test
  void onStop_after_stop_fires_hook_synchronously() {
    timer = new HashedWheelTimer("wheel-test");
    timer.stop();
    Thread caller = Thread.currentThread();
    List<Thread> ran = new CopyOnWriteArrayList<>();

    Registration reg = timer.onStop(() -> ran.add(Thread.currentThread()));

    assertThat(ran).hasSize(1);
    assertThat(ran.get(0)).isSameInstanceAs(caller);
    // Registration is still safe to call; should be a no-op.
    reg.unregister();
    timer = null;
  }

  @Test
  void double_stop_does_not_re_run_hooks() {
    timer = new HashedWheelTimer("wheel-test");
    AtomicInteger fires = new AtomicInteger();

    timer.onStop(fires::incrementAndGet);

    timer.stop();
    timer.stop();

    assertThat(fires.get()).isEqualTo(1);
    timer = null;
  }

  @Test
  void unregister_removes_hook() {
    timer = new HashedWheelTimer("wheel-test");
    AtomicInteger fires = new AtomicInteger();

    Registration reg = timer.onStop(fires::incrementAndGet);
    reg.unregister();

    timer.stop();
    timer = null;

    assertThat(fires.get()).isEqualTo(0);
  }

  @Test
  void newTimeout_dispatches_to_supplied_executor() throws Exception {
    timer = new HashedWheelTimer("wheel-test");
    Thread caller = Thread.currentThread();
    CountDownLatch latch = new CountDownLatch(1);

    timer.newTimeout(
        () -> {
          assertThat(Thread.currentThread()).isNotSameInstanceAs(caller);
          latch.countDown();
        },
        DIRECT,
        5,
        TimeUnit.MILLISECONDS);

    assertThat(latch.await(500, TimeUnit.MILLISECONDS)).isTrue();
  }
}
