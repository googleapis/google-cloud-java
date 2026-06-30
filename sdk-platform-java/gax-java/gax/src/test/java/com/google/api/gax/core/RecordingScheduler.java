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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public abstract class RecordingScheduler implements ScheduledExecutorService {

  public abstract List<java.time.Duration> getSleepDurations();

  public abstract int getIterationsCount();

  public static RecordingScheduler create(final FakeApiClock clock) {
    RecordingScheduler mock = Mockito.mock(RecordingScheduler.class);

    // mock class fields:
    final ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
    final List<java.time.Duration> sleepDurations = new ArrayList<>();
    final AtomicInteger iterationsCount = new AtomicInteger(0);

    // mock class methods:
    // ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit);
    when(mock.schedule(any(Runnable.class), anyLong(), any(TimeUnit.class)))
        .then(
            new Answer<ScheduledFuture<?>>() {
              @Override
              public ScheduledFuture<?> answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                Runnable runnable = (Runnable) args[0];
                Long delay = (Long) args[1];
                TimeUnit unit = (TimeUnit) args[2];
                iterationsCount.incrementAndGet();
                sleepDurations.add(
                    java.time.Duration.ofMillis(TimeUnit.MILLISECONDS.convert(delay, unit)));
                clock.incrementNanoTime(TimeUnit.NANOSECONDS.convert(delay, unit));
                return executor.schedule(runnable, 0, TimeUnit.NANOSECONDS);
              }
            });

    // List<Runnable> shutdownNow()
    when(mock.shutdownNow())
        .then(
            new Answer<List<Runnable>>() {
              @Override
              public List<Runnable> answer(InvocationOnMock invocation) throws Throwable {
                return executor.shutdownNow();
              }
            });

    // List<java.time.Duration> getSleepDurations()
    when(mock.getSleepDurations()).thenReturn(sleepDurations);

    // int getIterationsCount()
    when(mock.getIterationsCount())
        .then(
            new Answer<Integer>() {
              @Override
              public Integer answer(InvocationOnMock invocation) throws Throwable {
                return iterationsCount.get();
              }
            });

    return mock;
  }
}
