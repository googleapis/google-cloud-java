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

import com.google.api.core.ApiClock;
import com.google.api.core.InternalApi;
import com.google.api.core.ObsoleteApi;
import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A watchdog provider which always returns the same watchdog instance provided to the provider
 * during construction.
 *
 * <p>This is the internal class and is public only for technical reasons. It may change any time
 * without notice, please do not depend on it explicitly.
 */
@InternalApi
public final class FixedWatchdogProvider implements WatchdogProvider {
  @Nullable private final Watchdog watchdog;

  public static WatchdogProvider create(Watchdog watchdog) {
    return new FixedWatchdogProvider(watchdog);
  }

  private FixedWatchdogProvider(Watchdog watchdog) {
    this.watchdog = watchdog;
  }

  @Override
  public boolean needsClock() {
    return false;
  }

  @Override
  public WatchdogProvider withClock(@Nonnull ApiClock clock) {
    throw new UnsupportedOperationException("FixedWatchdogProvider doesn't need a clock");
  }

  @Override
  public boolean needsCheckInterval() {
    return false;
  }

  /** This method is obsolete. Use {@link #withCheckIntervalDuration(Duration)} instead. */
  @Override
  @ObsoleteApi("Use withCheckIntervalDuration(java.time.Duration) instead")
  public WatchdogProvider withCheckInterval(org.threeten.bp.Duration checkInterval) {
    throw new UnsupportedOperationException("FixedWatchdogProvider doesn't need a checkInterval");
  }

  @Override
  public WatchdogProvider withCheckIntervalDuration(java.time.Duration checkInterval) {
    throw new UnsupportedOperationException("FixedWatchdogProvider doesn't need a checkInterval");
  }

  @Override
  public boolean needsExecutor() {
    return false;
  }

  @Override
  public WatchdogProvider withExecutor(ScheduledExecutorService executor) {
    throw new UnsupportedOperationException("FixedWatchdogProvider doesn't need an executor");
  }

  @Override
  public Watchdog getWatchdog() {
    return watchdog;
  }

  @Override
  public boolean shouldAutoClose() {
    return false;
  }
}
