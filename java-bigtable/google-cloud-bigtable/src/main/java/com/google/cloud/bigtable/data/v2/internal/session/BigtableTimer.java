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

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Schedules short-lived callbacks (heartbeat ticks, deadline monitors, watchdog ticks) at
 * approximate, low-resolution times. Backed by a hashed wheel: O(1) insert and O(1) cancel,
 * regardless of how many pending timeouts the wheel holds.
 *
 * <p>Each {@link #newTimeout} call carries the {@link Executor} that should run the task body.
 * Tasks never run on the timer's tick thread (unless the caller passes {@code directExecutor()};
 * see warning below). Passing the executor per-call avoids the dispatcher hop that a bundled
 * default would impose on callers who already trampoline onto their own executor.
 */
public interface BigtableTimer {
  /**
   * Schedules {@code task} to run after {@code delay}. The task body is handed to {@code
   * executor.execute(task)} — pass the executor where this task should ultimately run.
   *
   * <p>The returned handle can be used to cancel the task; cancel is O(1) and does not leave the
   * entry in any heap.
   *
   * <p><b>Warning:</b> passing {@code MoreExecutors.directExecutor()} runs {@code task} inline on
   * the timer's tick thread. The task must be trivial and non-blocking — anything more will stall
   * every other scheduled timeout on the wheel.
   */
  Timeout newTimeout(Runnable task, Executor executor, long delay, TimeUnit unit);

  /**
   * Releases the tick thread and discards any pending timeouts. Idempotent. After {@code stop()},
   * subsequent calls to {@link #newTimeout} or {@link #onStop} throw {@link IllegalStateException}.
   *
   * <p>Before releasing the tick thread, invokes every hook registered via {@link #onStop} on the
   * caller thread. Hooks fire in unspecified order; a hook that throws is logged and other hooks
   * still fire.
   */
  void stop();

  /**
   * Registers a hook to run during {@link #stop()}. Use this to drive caller-owned state (e.g. a
   * scheduled retry waiting on the timer) to a terminal state before the timer is torn down,
   * instead of letting a pending timeout silently disappear.
   *
   * <p>The returned {@link Registration} unregisters the hook; call it when the hook is no longer
   * needed (e.g. the scheduled work fired normally or was cancelled) so the hook set does not
   * accumulate stale entries.
   */
  Registration onStop(Runnable hook);

  interface Timeout {
    /** Cancels the scheduled task. Returns true if the task had not yet fired. */
    boolean cancel();

    boolean isCancelled();
  }

  interface Registration {
    void unregister();
  }
}
