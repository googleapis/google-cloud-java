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

import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.common.base.Stopwatch;
import com.google.protobuf.Duration;
import com.google.protobuf.util.Durations;
import com.google.rpc.RetryInfo;
import io.grpc.Context;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import java.util.Optional;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public class RetryingVRpc<ReqT, RespT> implements VRpc<ReqT, RespT> {

  private static final Logger LOG = Logger.getLogger(RetryingVRpc.class.getName());

  private final Context grpcContext;
  private final io.opentelemetry.context.Context otelContext;

  private final Supplier<VRpc<ReqT, RespT>> attemptFactory;
  private ReqT request;
  private VRpcListener<RespT> listener;
  private VRpcCallContext context;
  private VRpcTracer tracer;

  private final ScheduledExecutorService executor;
  private final SynchronizationContext syncContext;

  // current state and all the flags don't need to be volatile because they're only updated within
  // the sync context.
  private State currentState;
  private boolean started;
  // Breaks the loop if uncaught exception happens during sync context execution.
  private boolean isCancelling;

  public RetryingVRpc(Supplier<VRpc<ReqT, RespT>> supplier, ScheduledExecutorService executor) {
    this.attemptFactory = supplier;

    grpcContext = Context.current();
    otelContext = io.opentelemetry.context.Context.current();

    this.executor = otelContext.wrap(executor);
    this.syncContext =
        new SynchronizationContext(
            (t, e) -> {
              this.cancel(
                  "Unexpected error while notifying the caller of RetryingVRpc. Trying to cancel"
                      + " vRpc to ensure consistent state",
                  e);
            });

    started = false;
    isCancelling = false;
    this.currentState = new Idle();
  }

  @Override
  public void start(ReqT req, VRpcCallContext ctx, VRpcListener<RespT> listener) {
    syncContext.execute(
        () -> {
          if (started) {
            listener.onClose(
                VRpcResult.createRejectedError(
                    Status.FAILED_PRECONDITION.withDescription("operation is already started")));
            return;
          }
          started = true;

          this.request = req;
          this.listener = listener;
          this.context = ctx;
          this.tracer = context.getTracer();

          tracer.onOperationStart();
          currentState.onStart();
        });
  }

  @Override
  public void cancel(@Nullable String message, @Nullable Throwable cause) {
    syncContext.execute(
        () -> {
          if (currentState.isDone() || isCancelling) {
            LOG.fine("Ignoring cancel because the vRPC is already cancelled or done.");
            return;
          }
          // Prevents infinite loop if there's any error thrown during this phase.
          isCancelling = true;
          Throwable finalCause = cause;
          try {
            currentState.onCancel(message, cause);
          } catch (Throwable t) {
            if (finalCause != null) {
              finalCause.addSuppressed(t);
            } else {
              finalCause = t;
            }
          }
          onStateChange(
              new Done(
                  VRpcResult.createRejectedError(
                      Status.CANCELLED.withDescription(message).withCause(finalCause))));
        });
  }

  @Override
  public void requestNext() {
    throw new UnsupportedOperationException("request next is not supported in unary");
  }

  void onStateChange(State state) {
    syncContext.throwIfNotInThisSynchronizationContext();
    if (currentState.isDone()) {
      return;
    }
    this.currentState = state;
    currentState.onStart();
  }

  abstract static class State {
    public abstract void onStart();

    public void onCancel(String reason, Throwable throwable) {}

    public boolean isDone() {
      return false;
    }
  }

  class Idle extends State {

    @Override
    public void onStart() {
      // initial request and retries will all start in idle state.
      // TODO: When stream is supported we only transition to active state when
      //  caller is requesting more. And this should be part of the attempt time and app blocking
      // time.
      Active active = new Active();
      onStateChange(active);
    }
  }

  class Active extends State {

    private VRpc<ReqT, RespT> attempt;

    @Override
    public void onStart() {
      attempt = attemptFactory.get();
      tracer.onAttemptStart(request);
      attempt.start(
          request,
          context,
          new VRpcListener<RespT>() {
            @Override
            public void onMessage(RespT msg) {
              syncContext.execute(
                  () -> {
                    if (currentState != Active.this) {
                      LOG.log(
                          Level.FINE,
                          "Discarding response {0} because the attempt is no longer active.",
                          msg);
                      return;
                    }
                    tracer.onResponseReceived();
                    Stopwatch appTimer = Stopwatch.createStarted();
                    try {
                      listener.onMessage(msg);
                    } finally {
                      tracer.recordApplicationBlockingLatencies(appTimer.elapsed());
                    }
                  });
            }

            @Override
            public void onClose(VRpcResult result) {
              syncContext.execute(
                  () -> {
                    tracer.onAttemptFinish(result);
                    if (currentState != Active.this) {
                      LOG.log(
                          Level.FINE,
                          "Discarding server close with result {0} because the the attempt is no"
                              + " longer active.",
                          result);
                      return;
                    }
                    if (shouldRetry(result)) {
                      context = context.createForNextAttempt();
                      Duration retryDelay =
                          Optional.ofNullable(result.getRetryInfo())
                              .map(RetryInfo::getRetryDelay)
                              .orElse(Durations.ZERO);
                      if (Durations.compare(retryDelay, Durations.ZERO) > 0) {
                        Scheduled scheduled = new Scheduled(retryDelay);
                        onStateChange(scheduled);
                      } else {
                        onStateChange(new Idle());
                      }
                      return;
                    }

                    onStateChange(new Done(result));
                  });
            }
          });
    }

    @Override
    public void onCancel(String reason, Throwable throwable) {
      // attempt could be null if attemptFactory.get() throws an exception. In which case sync
      // context uncaught exception handler will be called, which calls cancel on the current
      // state before transition into done state.
      if (attempt != null) {
        attempt.cancel(reason, throwable);
      }
    }

    boolean shouldRetry(VRpcResult result) {
      // If the error has RetryInfo, it means it comes from the server and should
      // be retried.
      if (!result.getStatus().isOk()
          && result.getRetryInfo() != null
          && result.getRetryInfo().hasRetryDelay()) {
        long retryDelay = Durations.toMillis(result.getRetryInfo().getRetryDelay());
        // only schedule retry if there's still a chance for the request to succeed
        return context.getOperationInfo().getDeadline().timeRemaining(TimeUnit.MILLISECONDS)
                - retryDelay
            > 1;
      }
      // Do not retry result that is explicitly rejected
      if (result.getRejected()) {
        return false;
      }
      // If the error didn't leave the client or failed in transport and is idempotent, we
      // can retry up to 3 times.
      boolean isRetryable =
          (result.getState() == VRpcResult.State.UNCOMMITED)
              || (context.getOperationInfo().isIdempotent()
                  && result.getState() == VRpcResult.State.TRANSPORT_FAILURE);
      if (isRetryable && context.getOperationInfo().getAttemptNumber() < 3) {
        return true;
      }
      return false;
    }
  }

  class Scheduled extends State {
    private final Duration retryDelay;
    private SynchronizationContext.ScheduledHandle future;

    Scheduled(Duration retryDelay) {
      this.retryDelay = retryDelay;
    }

    @Override
    public void onStart() {
      try {
        future =
            syncContext.schedule(
                () -> grpcContext.wrap(() -> onStateChange(new Idle())).run(),
                Durations.toMillis(retryDelay),
                TimeUnit.MILLISECONDS,
                executor);
      } catch (RejectedExecutionException e) {
        onStateChange(
            new Done(
                VRpcResult.createRejectedError(
                    Status.CANCELLED
                        .withDescription(
                            "Executor shutting down, can't schedule operation for retry.")
                        .withCause(e))));
      }
    }

    @Override
    public void onCancel(String reason, Throwable throwable) {
      // future can be null if schedule throws an exception that's not RejectedExecutionException.
      // In which case sync context uncaught exception handler will be called, which calls cancel on
      // the current
      // state before transition into done state.
      if (future != null && future.isPending()) {
        future.cancel();
      }
    }
  }

  class Done extends State {

    private final VRpcResult result;

    Done(VRpcResult result) {
      this.result = result;
    }

    @Override
    public void onStart() {
      if (!started) {
        LOG.fine("operation is not started yet.");
        return;
      }
      Stopwatch appTimer = Stopwatch.createStarted();
      try {
        listener.onClose(result);
      } finally {
        tracer.recordApplicationBlockingLatencies(appTimer.elapsed());
        tracer.onOperationFinish(result);
      }
    }

    @Override
    public boolean isDone() {
      return true;
    }
  }
}
