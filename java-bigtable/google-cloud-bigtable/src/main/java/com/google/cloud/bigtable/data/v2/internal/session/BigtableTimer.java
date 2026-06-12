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

import java.util.concurrent.TimeUnit;

/**
 * Schedules short-lived callbacks (heartbeat ticks, deadline monitors, watchdog ticks) at
 * approximate, low-resolution times. Backed by a hashed wheel: O(1) insert and O(1) cancel,
 * regardless of how many pending timeouts the wheel holds.
 *
 * <p>{@link #newTimeout} runs the callback on the timer's bundled dispatch executor — callers do
 * not have to wrap their bodies in {@code executor.execute(...)} to stay off the tick thread. This
 * is the default and is correct for any callback that takes a lock or does real work.
 *
 * <p>TODO: once later refactor steps introduce per-op / per-session dispatchers (e.g. {@code
 * SerializingExecutor} or {@code SynchronizationContext}), add a {@code newTimeoutOnTickThread}
 * variant so callers with their own dispatcher can skip the wasted hop through the bundled
 * executor.
 *
 * <p>This is a thin abstraction over a single concrete implementation today (see {@code
 * NettyWheelTimer}). It exists so the implementation can be swapped after benchmarking establishes
 * a baseline.
 */
public interface BigtableTimer {
  /**
   * Schedules {@code task} to run after {@code delay}. The task body runs on the timer's bundled
   * dispatch executor, not on the tick thread, so it is safe to take locks or do bounded work.
   *
   * <p>The returned handle can be used to cancel the task; cancel is O(1) and does not leave the
   * entry in any heap.
   */
  Timeout newTimeout(Runnable task, long delay, TimeUnit unit);

  /**
   * Releases the tick thread and discards any pending timeouts. Idempotent. After {@code stop()},
   * subsequent calls to {@link #newTimeout} throw {@link IllegalStateException}.
   */
  void stop();

  interface Timeout {
    /** Cancels the scheduled task. Returns true if the task had not yet fired. */
    boolean cancel();

    boolean isCancelled();
  }
}
