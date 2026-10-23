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
package com.google.api.gax.core;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A test {@link ScheduledExecutorService} that records scheduled task iterations and advances a
 * {@link FakeApiClock} instead of sleeping in real time.
 *
 * <p>When {@link #schedule(Runnable, long, TimeUnit)} is called, this scheduler increments the
 * iteration count, advances the {@link FakeApiClock} by the requested delay, and immediately
 * submits the task with zero delay to the underlying single-threaded executor. This allows
 * multi-attempt retry and polling tests to execute without real-time backoff sleeps while still
 * exercising simulated elapsed time calculations and preserving asynchronous callback ordering on
 * {@code CallbackChainRetryingFuture}.
 */
public class RecordingScheduler extends ScheduledThreadPoolExecutor {
  /**
   * A single worker thread executes zero-delay scheduled tasks sequentially in FIFO order. Running
   * tasks asynchronously on a dedicated worker thread avoids lock-inversion and reentrant race
   * conditions when registering attempt futures in CallbackChainRetryingFuture.
   */
  private static final int CORE_POOL_SIZE = 1;

  private final FakeApiClock clock;
  private final AtomicInteger iterationsCount = new AtomicInteger(0);

  private RecordingScheduler(FakeApiClock clock) {
    super(CORE_POOL_SIZE);
    this.clock = clock;
  }

  /**
   * Creates a new {@link RecordingScheduler} bound to the given {@link FakeApiClock}.
   *
   * @param clock the fake clock to advance whenever a delayed task is scheduled
   */
  public static RecordingScheduler create(FakeApiClock clock) {
    return new RecordingScheduler(clock);
  }

  /**
   * Schedules a task by incrementing the iteration count, advancing the {@link FakeApiClock} by the
   * requested delay, and immediately submitting the task with zero delay to the worker thread.
   *
   * <p>Advancing the fake clock simulates the passage of backoff time deterministically without
   * sleeping in real time. Submitting with zero delay to the worker thread preserves asynchronous
   * execution so that attempt registration in {@code CallbackChainRetryingFuture} completes
   * cleanly before the scheduled attempt runs.
   */
  @Override
  public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
    iterationsCount.incrementAndGet();
    clock.incrementNanoTime(TimeUnit.NANOSECONDS.convert(delay, unit));
    return super.schedule(command, 0, TimeUnit.NANOSECONDS);
  }

  /** Returns the total number of tasks scheduled via {@link #schedule(Runnable, long, TimeUnit)}. */
  public int getIterationsCount() {
    return iterationsCount.get();
  }
}
