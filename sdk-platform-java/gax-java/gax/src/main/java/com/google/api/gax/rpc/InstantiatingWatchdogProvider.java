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

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;

import com.google.api.core.ApiClock;
import com.google.api.core.InternalApi;
import com.google.api.core.ObsoleteApi;
import com.google.common.base.Preconditions;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A watchdog provider which instantiates a new provider on every request.
 *
 * <p>This is the internal class and is public only for technical reasons. It may change any time
 * without notice, please do not depend on it explicitly.
 */
@InternalApi
public final class InstantiatingWatchdogProvider implements WatchdogProvider {
  @Nullable private final ApiClock clock;
  @Nullable private final ScheduledExecutorService executor;
  @Nullable private final java.time.Duration checkInterval;

  public static WatchdogProvider create() {
    return new InstantiatingWatchdogProvider(null, null, null);
  }

  private InstantiatingWatchdogProvider(
      @Nullable ApiClock clock,
      @Nullable ScheduledExecutorService executor,
      @Nullable java.time.Duration checkInterval) {
    this.clock = clock;
    this.executor = executor;
    this.checkInterval = checkInterval;
  }

  @Override
  public boolean needsClock() {
    return clock == null;
  }

  @Override
  public WatchdogProvider withClock(@Nonnull ApiClock clock) {
    return new InstantiatingWatchdogProvider(
        Preconditions.checkNotNull(clock), executor, checkInterval);
  }

  @Override
  public boolean needsCheckInterval() {
    return checkInterval == null;
  }

  /**
   * This method is obsolete. Use {@link #withCheckIntervalDuration(java.time.Duration)} instead.
   */
  @Override
  @ObsoleteApi("Use withCheckIntervalDuration(java.time.Duration) instead")
  public WatchdogProvider withCheckInterval(@Nonnull org.threeten.bp.Duration checkInterval) {
    return withCheckIntervalDuration(toJavaTimeDuration(checkInterval));
  }

  @Override
  public WatchdogProvider withCheckIntervalDuration(@Nonnull java.time.Duration checkInterval) {
    return new InstantiatingWatchdogProvider(
        clock, executor, Preconditions.checkNotNull(checkInterval));
  }

  @Override
  public boolean needsExecutor() {
    return executor == null;
  }

  @Override
  public WatchdogProvider withExecutor(ScheduledExecutorService executor) {
    return new InstantiatingWatchdogProvider(
        clock, Preconditions.checkNotNull(executor), checkInterval);
  }

  @SuppressWarnings("ConstantConditions")
  @Nullable
  @Override
  public Watchdog getWatchdog() {
    Preconditions.checkState(!needsClock(), "A clock is needed");
    Preconditions.checkState(!needsCheckInterval(), "A check interval is needed");
    Preconditions.checkState(!needsExecutor(), "An executor is needed");

    // Watchdog is disabled
    if (checkInterval.isZero()) {
      return null;
    }

    return Watchdog.createDuration(clock, checkInterval, executor);
  }

  @Override
  public boolean shouldAutoClose() {
    return true;
  }
}
