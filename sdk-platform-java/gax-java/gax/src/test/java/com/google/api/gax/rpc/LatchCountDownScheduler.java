/*
 * Copyright 2017 Google LLC
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
package com.google.api.gax.rpc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public abstract class LatchCountDownScheduler implements ScheduledExecutorService {
  public static LatchCountDownScheduler get(
      final CountDownLatch latch,
      final long delayBeforeCountDown,
      final long extraDelayAfterCountDown) {
    LatchCountDownScheduler mock = Mockito.mock(LatchCountDownScheduler.class);

    // mock class fields:
    final ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);

    // mock class methods:
    // ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit);
    when(mock.schedule(any(Runnable.class), anyLong(), any(TimeUnit.class)))
        .then(
            new Answer<ScheduledFuture<?>>() {
              @Override
              public ScheduledFuture<?> answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                Long delay = (Long) args[1];
                TimeUnit timeUnit = (TimeUnit) args[2];
                delay += timeUnit.convert(extraDelayAfterCountDown, TimeUnit.MILLISECONDS);
                latch.countDown();
                if (delayBeforeCountDown > 0L) {
                  Thread.sleep(delayBeforeCountDown);
                }
                return executor.schedule((Runnable) args[0], delay, timeUnit);
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

    return mock;
  }
}
