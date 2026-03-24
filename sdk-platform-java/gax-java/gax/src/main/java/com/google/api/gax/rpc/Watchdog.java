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
import static com.google.api.gax.util.TimeConversionUtils.toThreetenDuration;

import com.google.api.core.ApiClock;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;

/**
 * Prevents the streams from hanging indefinitely. This middleware garbage collects idle streams in
 * case the user forgot to close a ServerStream or if a connection is reset and GRPC does not get
 * notified.
 *
 * <p>For every {@code checkInterval}, this class checks two thresholds:
 *
 * <ul>
 *   <li>waitingTimeout: the amount of time to wait for a response (after the caller signaled
 *       demand) before forcefully closing the stream. Duration.ZERO disables the timeout.
 *   <li>idleTimeout: the amount of time to wait before assuming that the caller forgot to close the
 *       stream and forcefully closing the stream. This is measured from the last time the caller
 *       had no outstanding demand. Duration.ZERO disables the timeout.
 * </ul>
 */
public final class Watchdog implements Runnable, BackgroundResource {

  private static final Logger LOG = Logger.getLogger(Watchdog.class.getName());

  // Dummy value to convert the ConcurrentHashMap into a Set
  private static Object PRESENT = new Object();
  private final ConcurrentHashMap<WatchdogStream, Object> openStreams = new ConcurrentHashMap<>();

  private final ApiClock clock;
  private final java.time.Duration scheduleInterval;
  private final ScheduledExecutorService executor;
  private ScheduledFuture<?> future;

  /**
   * This method is obsolete. Use {@link #createDuration(ApiClock, java.time.Duration,
   * ScheduledExecutorService)} instead.
   */
  @ObsoleteApi("Use create(ApiClock, java.time.Duration, ScheduledExecutorService) instead")
  public static Watchdog create(
      ApiClock clock,
      org.threeten.bp.Duration scheduleInterval,
      ScheduledExecutorService executor) {
    return createDuration(clock, toJavaTimeDuration(scheduleInterval), executor);
  }

  /** returns a Watchdog which is scheduled at the provided interval. */
  public static Watchdog createDuration(
      ApiClock clock, java.time.Duration scheduleInterval, ScheduledExecutorService executor) {
    Watchdog watchdog = new Watchdog(clock, scheduleInterval, executor);
    watchdog.start();
    return watchdog;
  }

  private Watchdog(
      ApiClock clock, java.time.Duration scheduleInterval, ScheduledExecutorService executor) {
    this.clock = Preconditions.checkNotNull(clock, "clock can't be null");
    this.scheduleInterval = scheduleInterval;
    this.executor = executor;
  }

  private void start() {
    future =
        executor.scheduleAtFixedRate(
            this, scheduleInterval.toMillis(), scheduleInterval.toMillis(), TimeUnit.MILLISECONDS);
  }

  /**
   * This method is obsolete. Use {@link #watchDuration(ResponseObserver, java.time.Duration,
   * java.time.Duration)} instead.
   */
  @ObsoleteApi(
      "Use watchDuration(ResponseObserver, java.time.Duration, java.time.Duration) instead")
  public <ResponseT> ResponseObserver<ResponseT> watch(
      ResponseObserver<ResponseT> innerObserver,
      @Nonnull org.threeten.bp.Duration waitTimeout,
      @Nonnull org.threeten.bp.Duration idleTimeout) {
    return watchDuration(
        innerObserver, toJavaTimeDuration(waitTimeout), toJavaTimeDuration(idleTimeout));
  }

  /** Wraps the target observer with timing constraints. */
  public <ResponseT> ResponseObserver<ResponseT> watchDuration(
      ResponseObserver<ResponseT> innerObserver,
      @Nonnull java.time.Duration waitTimeout,
      @Nonnull java.time.Duration idleTimeout) {
    Preconditions.checkNotNull(innerObserver, "innerObserver can't be null");
    Preconditions.checkNotNull(waitTimeout, "waitTimeout can't be null");
    Preconditions.checkNotNull(idleTimeout, "idleTimeout can't be null");

    if (waitTimeout.isZero() && idleTimeout.isZero()) {
      return innerObserver;
    }

    WatchdogStream<ResponseT> stream =
        new WatchdogStream<>(innerObserver, waitTimeout, idleTimeout);
    openStreams.put(stream, PRESENT);
    return stream;
  }

  @Override
  public void run() {
    try {
      runUnsafe();
    } catch (Throwable t) {
      LOG.log(Level.SEVERE, "Caught throwable in periodic Watchdog run. Continuing.", t);
    }
  }

  private void runUnsafe() {
    Iterator<Entry<WatchdogStream, Object>> it = openStreams.entrySet().iterator();

    while (it.hasNext()) {
      WatchdogStream stream = it.next().getKey();
      if (stream.cancelIfStale()) {
        it.remove();
      }
    }
  }

  @Override
  public void shutdown() {
    future.cancel(false);
  }

  @Override
  public boolean isShutdown() {
    return future.isCancelled();
  }

  @Override
  public boolean isTerminated() {
    return future.isDone();
  }

  @Override
  public void shutdownNow() {
    future.cancel(true);
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    try {
      future.get(duration, unit);
      return true;
    } catch (ExecutionException | CancellationException e) {
      return true;
    } catch (TimeoutException e) {
      return false;
    }
  }

  @Override
  public void close() {
    shutdown();
  }

  @VisibleForTesting
  java.time.Duration getScheduleIntervalDuration() {
    return this.scheduleInterval;
  }

  @VisibleForTesting
  org.threeten.bp.Duration getScheduleInterval() {
    return toThreetenDuration(this.scheduleInterval);
  }

  enum State {
    /** Stream has been started, but doesn't have any outstanding requests. */
    IDLE,
    /** Stream is awaiting a response from upstream. */
    WAITING,
    /**
     * Stream received a response from upstream, and is awaiting outerResponseObserver processing.
     */
    DELIVERING
  }

  class WatchdogStream<ResponseT> extends StateCheckingResponseObserver<ResponseT> {
    private final Object lock = new Object();

    private final java.time.Duration waitTimeout;
    private final java.time.Duration idleTimeout;
    private boolean hasStarted;
    private boolean autoAutoFlowControl = true;

    private final ResponseObserver<ResponseT> outerResponseObserver;
    private volatile StreamController innerController;

    // When a stream is created it has automatic inbound flow control enabled. The stream
    // won't wait for the caller to request a message. Setting the default to WAITING
    // to reflect this state.
    @GuardedBy("lock")
    private State state = State.WAITING;

    @GuardedBy("lock")
    private int pendingCount = 0;

    @GuardedBy("lock")
    private long lastActivityAt = clock.millisTime();

    private volatile Throwable error;

    WatchdogStream(
        ResponseObserver<ResponseT> responseObserver,
        java.time.Duration waitTimeout,
        java.time.Duration idleTimeout) {
      this.waitTimeout = waitTimeout;
      this.idleTimeout = idleTimeout;
      this.outerResponseObserver = responseObserver;
    }

    @Override
    public void onStartImpl(StreamController controller) {
      this.innerController = controller;
      outerResponseObserver.onStart(
          new StreamController() {
            @Override
            public void disableAutoInboundFlowControl() {
              Preconditions.checkState(
                  !hasStarted, "Can't disable automatic flow control after the stream has started");

              // Adding the lock only to satisfy the annotation. It doesn't matter because before
              // the stream is started, this is only accessed by the caller.
              synchronized (lock) {
                // When auto flow control is disabled, caller needs to call onRequest() to request a
                // message. Setting the state to IDLE because now we're waiting for caller to call
                // onRequest().
                state = State.IDLE;
              }

              autoAutoFlowControl = false;
              innerController.disableAutoInboundFlowControl();
            }

            @Override
            public void request(int count) {
              WatchdogStream.this.onRequest(count);
            }

            @Override
            public void cancel() {
              WatchdogStream.this.onCancel();
            }
          });

      hasStarted = true;
    }

    private void onRequest(int count) {
      Preconditions.checkArgument(count > 0, "count must be > 0");
      Preconditions.checkState(!autoAutoFlowControl, "Auto flow control is enabled");

      // Only reset the request water mark if there are no outstanding requests.
      synchronized (lock) {
        if (state == State.IDLE) {
          state = State.WAITING;
          lastActivityAt = clock.millisTime();
        }

        // Increment the request count without overflow
        int maxIncrement = Integer.MAX_VALUE - pendingCount;
        count = Math.min(maxIncrement, count);
        pendingCount += count;
      }
      innerController.request(count);
    }

    private void onCancel() {
      error = new CancellationException("User cancelled stream");
      innerController.cancel();
    }

    @Override
    public void onResponseImpl(ResponseT response) {
      synchronized (lock) {
        state = State.DELIVERING;
      }

      outerResponseObserver.onResponse(response);

      synchronized (lock) {
        pendingCount--;
        lastActivityAt = clock.millisTime();

        if (autoAutoFlowControl || pendingCount > 0) {
          state = State.WAITING;
        } else {
          state = State.IDLE;
        }
      }
    }

    @Override
    public void onErrorImpl(Throwable t) {
      // Overlay the cancellation errors (either user or idle)
      if (this.error != null) {
        t = this.error;
      }
      openStreams.remove(this);
      outerResponseObserver.onError(t);
    }

    @Override
    public void onCompleteImpl() {
      openStreams.remove(this);
      outerResponseObserver.onComplete();
    }

    /**
     * Checks if this stream has overrun any of its timeouts and cancels it if it does.
     *
     * @return True if the stream was canceled.
     */
    boolean cancelIfStale() {
      // If the stream hasn't started yet, innerController will be null. Skip the check this time
      // and return false so the stream is still watched.
      if (innerController == null) {
        return false;
      }

      Throwable myError = null;

      synchronized (lock) {
        long waitTime = clock.millisTime() - lastActivityAt;

        switch (this.state) {
          case IDLE:
            if (!idleTimeout.isZero() && waitTime >= idleTimeout.toMillis()) {
              myError = new WatchdogTimeoutException("Canceled due to idle connection", false);
            }
            break;
          case WAITING:
            if (!waitTimeout.isZero() && waitTime >= waitTimeout.toMillis()) {
              myError =
                  new WatchdogTimeoutException(
                      "Canceled due to timeout waiting for next response", true);
            }
            break;
        }
      }

      if (myError != null) {
        this.error = myError;
        innerController.cancel();
        return true;
      }
      return false;
    }
  }
}
