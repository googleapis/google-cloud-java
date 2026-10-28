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

package com.google.cloud.bigtable.data.v2.internal.middleware;

import static io.opentelemetry.context.Context.current;

import com.google.bigtable.v2.SessionMutateRowsRequest;
import com.google.bigtable.v2.SessionMutateRowsResponse;
import com.google.cloud.bigtable.data.v2.internal.session.BigtableTimer;
import io.grpc.Context;
import io.grpc.Status;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;
import javax.annotation.Nullable;

/**
 * Non-blocking rate-limiting {@link VRpc} middleware for {@code SessionMutateRows}.
 *
 * <p>Reserves a permit from {@link SessionMutateRowsRateLimiter} when an attempt starts, schedules
 * any required throttle delay asynchronously on {@link BigtableTimer} (never blocking {@link
 * OpExecutor} or gRPC threads), and updates the limiter from server {@code RateLimitInfo} responses
 * and overload statuses.
 *
 * <p>All mutable state is owned by the per-operation {@link OpExecutor}.
 */
public final class RateLimitingVRpc
    implements VRpc<SessionMutateRowsRequest, SessionMutateRowsResponse> {

  private final VRpc<SessionMutateRowsRequest, SessionMutateRowsResponse> delegate;
  private final SessionMutateRowsRateLimiter limiter;
  private final BigtableTimer timer;
  private final UnaryOperator<Runnable> contextWrapper;

  private SessionMutateRowsRequest request;
  private VRpcCallContext context;
  private VRpcListener<SessionMutateRowsResponse> listener;

  private boolean delegateStarted = false;
  private boolean done = false;
  @Nullable private BigtableTimer.Timeout throttleTimeout;
  @Nullable private BigtableTimer.Registration stopHook;

  public RateLimitingVRpc(
      VRpc<SessionMutateRowsRequest, SessionMutateRowsResponse> delegate,
      SessionMutateRowsRateLimiter limiter,
      BigtableTimer timer) {
    this.delegate = delegate;
    this.limiter = limiter;
    this.timer = timer;
    Context grpcContext = Context.current();
    UnaryOperator<Runnable> otelWrap = current()::wrap;
    this.contextWrapper = task -> grpcContext.wrap(otelWrap.apply(task));
  }

  @Override
  public void start(
      SessionMutateRowsRequest req,
      VRpcCallContext ctx,
      VRpcListener<SessionMutateRowsResponse> listener) {
    if (this.context != null) {
      VRpcResult alreadyStarted =
          VRpcResult.createRejectedError(
              Status.FAILED_PRECONDITION.withDescription("operation is already started"));
      ctx.getExecutor().execute(() -> listener.onClose(alreadyStarted));
      return;
    }
    this.request = req;
    this.context = ctx;
    this.listener = listener;

    long remainingNanos = ctx.getOperationInfo().getDeadline().timeRemaining(TimeUnit.NANOSECONDS);
    if (remainingNanos <= 0) {
      failFast(
          VRpcResult.createRejectedError(
              Status.DEADLINE_EXCEEDED.withDescription(
                  "Deadline expired before acquiring batch write flow control permit")));
      return;
    }

    Optional<Duration> delayOpt = limiter.tryAcquireDelay(Duration.ofNanos(remainingNanos));
    if (!delayOpt.isPresent()) {
      failFast(
          VRpcResult.createRejectedError(
              Status.DEADLINE_EXCEEDED.withDescription(
                  "Deadline would expire while waiting for batch write flow control permit")));
      return;
    }

    Duration delay = delayOpt.get();
    if (delay.isZero()) {
      startDelegate();
      return;
    }

    stopHook = timer.onStop(this::onTimerStopping);
    throttleTimeout =
        timer.newTimeout(
            () -> contextWrapper.apply(this::onThrottleComplete).run(),
            ctx.getExecutor(),
            delay.toNanos(),
            TimeUnit.NANOSECONDS);
  }

  private void failFast(VRpcResult result) {
    done = true;
    context.getExecutor().execute(() -> listener.onClose(result));
  }

  private void onThrottleComplete() {
    context.getExecutor().throwIfNotInThisExecutor();
    if (done || delegateStarted) {
      return;
    }
    cleanupTimerHandles();
    startDelegate();
  }

  private void onTimerStopping() {
    context
        .getExecutor()
        .execute(
            () -> {
              if (done || delegateStarted) {
                return;
              }
              cleanupTimerHandles();
              done = true;
              listener.onClose(
                  VRpcResult.createRejectedError(
                      Status.CANCELLED.withDescription(
                          "Client closing while waiting for batch write flow control permit")));
            });
  }

  private void startDelegate() {
    delegateStarted = true;
    delegate.start(
        request,
        context,
        new VRpcListener<SessionMutateRowsResponse>() {
          @Override
          public void onMessage(SessionMutateRowsResponse msg) {
            context.getExecutor().throwIfNotInThisExecutor();
            limiter.onResponse(msg, context.getTracer());
            listener.onMessage(msg);
          }

          @Override
          public void onClose(VRpcResult result) {
            context.getExecutor().throwIfNotInThisExecutor();
            done = true;
            limiter.onResult(result, context.getTracer());
            listener.onClose(result);
          }
        });
  }

  @Override
  public void cancel(@Nullable String message, @Nullable Throwable cause) {
    if (done) {
      return;
    }
    cleanupTimerHandles();
    if (delegateStarted) {
      delegate.cancel(message, cause);
      done = delegate.isDone();
    } else {
      done = true;
      if (listener != null) {
        listener.onClose(
            VRpcResult.createRejectedError(
                Status.CANCELLED.withDescription(message).withCause(cause)));
      }
    }
  }

  @Override
  public boolean isDone() {
    return done || (delegateStarted && delegate.isDone());
  }

  @Override
  public void requestNext() {
    if (context != null) {
      context.getExecutor().throwIfNotInThisExecutor();
    }
    throw new UnsupportedOperationException("request next is not supported in unary");
  }

  private void cleanupTimerHandles() {
    if (stopHook != null) {
      stopHook.unregister();
      stopHook = null;
    }
    if (throttleTimeout != null && !throttleTimeout.isCancelled()) {
      throttleTimeout.cancel();
    }
    throttleTimeout = null;
  }
}
