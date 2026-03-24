/*
 * Copyright 2018 Google LLC
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

import static com.google.api.gax.util.TimeConversionTestUtils.testDurationMethod;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiClock;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InstantiatingWatchdogProviderTest {
  @Mock private ScheduledExecutorService executor;
  @Mock private ApiClock clock;
  private java.time.Duration checkInterval = java.time.Duration.ofSeconds(11);

  @Test
  void happyPath() {
    WatchdogProvider provider = InstantiatingWatchdogProvider.create();

    assertThat(provider.needsExecutor()).isTrue();
    provider = provider.withExecutor(executor);

    assertThat(provider.needsClock()).isTrue();
    provider = provider.withClock(clock);

    assertThat(provider.needsCheckInterval()).isTrue();
    provider = provider.withCheckIntervalDuration(checkInterval);

    assertThat(provider.shouldAutoClose()).isTrue();

    Watchdog watchdog = provider.getWatchdog();
    Mockito.verify(executor)
        .scheduleAtFixedRate(
            watchdog, checkInterval.toMillis(), checkInterval.toMillis(), TimeUnit.MILLISECONDS);
  }

  @Test
  void requiresExecutor() {
    WatchdogProvider provider =
        InstantiatingWatchdogProvider.create()
            .withCheckIntervalDuration(checkInterval)
            .withClock(clock);

    Throwable actualError = null;
    try {
      provider.getWatchdog();
    } catch (Throwable t) {
      actualError = t;
    }
    assertThat(actualError).isInstanceOf(IllegalStateException.class);
  }

  @Test
  void requiresCheckInterval() {
    WatchdogProvider provider =
        InstantiatingWatchdogProvider.create().withExecutor(executor).withClock(clock);

    Throwable actualError = null;
    try {
      provider.getWatchdog();
    } catch (Throwable t) {
      actualError = t;
    }
    assertThat(actualError).isInstanceOf(IllegalStateException.class);
  }

  @Test
  void requiresClock() {
    WatchdogProvider provider =
        InstantiatingWatchdogProvider.create()
            .withExecutor(executor)
            .withCheckIntervalDuration(checkInterval);

    Throwable actualError = null;
    try {
      provider.getWatchdog();
    } catch (Throwable t) {
      actualError = t;
    }
    assertThat(actualError).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void testCheckInterval_backportMethodsBehaveCorrectly() {
    final InstantiatingWatchdogProvider baseProvider =
        (InstantiatingWatchdogProvider)
            InstantiatingWatchdogProvider.create().withClock(clock).withExecutor(executor);
    testDurationMethod(
        123l,
        jt -> baseProvider.withCheckIntervalDuration(jt),
        tt -> baseProvider.withCheckInterval(tt),
        wp -> wp.getWatchdog().getScheduleIntervalDuration(),
        wp -> wp.getWatchdog().getScheduleInterval());
  }
}
