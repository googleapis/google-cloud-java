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

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.grpc.netty.shaded.io.netty.util.HashedWheelTimer;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * {@link BigtableTimer} backed by Netty's {@code HashedWheelTimer}, accessed via the shaded copy
 * inside {@code grpc-netty-shaded}. We depend on the shaded class so the library does not pull in
 * an additional {@code io.netty:netty-common} artifact.
 *
 * <p>Temporary: once threading-refactor benchmarks establish a baseline, this should be replaced
 * with an in-tree implementation that does not reach into gRPC's shaded internals.
 */
public final class NettyWheelTimer implements BigtableTimer {
  private static final Logger LOG = Logger.getLogger(NettyWheelTimer.class.getName());

  // 10 ms tick × 512 buckets ≈ 5 s per rotation. Heartbeat (100 ms), deadlines (sub-second to
  // seconds), and watchdog (5 min) all sit comfortably inside this resolution.
  private static final long TICK_DURATION_MS = 10;
  private static final int TICKS_PER_WHEEL = 512;

  private final HashedWheelTimer delegate;
  private final Executor dispatcher;

  // ConcurrentHashMap-backed Set so onStop/Registration.unregister can run from any thread without
  // blocking newTimeout. Stop drains it once, then refuses further registrations.
  private final Set<Runnable> stopHooks = ConcurrentHashMap.newKeySet();
  private volatile boolean stopped = false;

  public NettyWheelTimer(String name, Executor dispatcher) {
    this.dispatcher = dispatcher;
    this.delegate =
        new HashedWheelTimer(
            new ThreadFactoryBuilder().setNameFormat(name + "-%d").setDaemon(true).build(),
            TICK_DURATION_MS,
            TimeUnit.MILLISECONDS,
            TICKS_PER_WHEEL);
  }

  @Override
  public Timeout newTimeout(Runnable task, long delay, TimeUnit unit) {
    if (stopped) {
      throw new IllegalStateException("timer stopped");
    }
    return new TimeoutHandle(
        delegate.newTimeout(ignored -> dispatcher.execute(task), delay, unit));
  }

  @Override
  public Registration onStop(Runnable hook) {
    if (stopped) {
      throw new IllegalStateException("timer stopped");
    }
    stopHooks.add(hook);
    return () -> stopHooks.remove(hook);
  }

  @Override
  public void stop() {
    if (stopped) {
      return;
    }
    stopped = true;
    // Snapshot then clear so hooks can no longer be unregistered while we iterate (and so a hook
    // that re-enters onStop sees stopped=true and fails fast).
    Set<Runnable> hooks = new HashSet<>(stopHooks);
    stopHooks.clear();
    for (Runnable hook : hooks) {
      try {
        hook.run();
      } catch (Throwable t) {
        LOG.log(Level.WARNING, "stop hook threw; continuing", t);
      }
    }
    delegate.stop();
  }

  private static final class TimeoutHandle implements Timeout {
    private final io.grpc.netty.shaded.io.netty.util.Timeout nettyTimeout;

    TimeoutHandle(io.grpc.netty.shaded.io.netty.util.Timeout nettyTimeout) {
      this.nettyTimeout = nettyTimeout;
    }

    @Override
    public boolean cancel() {
      return nettyTimeout.cancel();
    }

    @Override
    public boolean isCancelled() {
      return nettyTimeout.isCancelled();
    }
  }
}
