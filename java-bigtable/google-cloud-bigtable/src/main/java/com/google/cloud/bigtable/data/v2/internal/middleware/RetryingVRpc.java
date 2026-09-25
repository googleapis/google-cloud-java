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

import com.google.bigtable.v2.TelemetryConfiguration;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DebugTagTracer;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.session.BigtableTimer;
import com.google.common.base.Stopwatch;
import com.google.protobuf.Duration;
import com.google.protobuf.util.Durations;
import com.google.rpc.RetryInfo;
import io.grpc.Context;
import io.grpc.Status;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

// All mutable state is owned by the op executor; VOperationImpl trampolines every inbound call
// onto it, so no synchronization is needed here.
public class RetryingVRpc<ReqT, RespT> implements VRpc<ReqT, RespT> {

  private static final Logger LOG = Logger.getLogger(RetryingVRpc.class.getName());

  private final Context grpcContext;
  private final io.opentelemetry.context.Context otelContext;

  private final Supplier<VRpc<ReqT, RespT>> attemptFactory;
  private final VRpcResumptionStrategy<ReqT, RespT> resumptionStrategy;
  private final DebugTagTracer debugTagTracer;
  private ReqT request;
  // The request to send on the current attempt. Equal to `request` for the first attempt; rewritten
  // by the resumption strategy on each retry so a resumed stream skips what was already delivered.
  private ReqT currentRequest;
  private VRpcListener<RespT> listener;
  private VRpcCallContext context;
  private VRpcTracer tracer;

  // Outstanding response demand. start() implicitly requests the first response, and the transport
  // permits at most one in-flight response at a time, so this is only ever 0 or 1. It gates whether
  // a retryable failure resumes immediately (demand present) or parks in Idle until the caller
  // asks for the next response.
  private int outstanding;

  private final BigtableTimer timer;

  private State currentState;
  private boolean started;
  // Breaks the loop on uncaught exception during cancel.
  private boolean isCancelling;

  public RetryingVRpc(
      Supplier<VRpc<ReqT, RespT>> supplier,
      BigtableTimer timer,
      VRpcResumptionStrategy<ReqT, RespT> resumptionStrategy,
      DebugTagTracer debugTagTracer) {
    this.attemptFactory = supplier;
    this.resumptionStrategy = resumptionStrategy;
    this.debugTagTracer = debugTagTracer;

    grpcContext = Context.current();
    otelContext = io.opentelemetry.context.Context.current();

    this.timer = timer;

    started = false;
    isCancelling = false;
    this.currentState = new Idle();
  }

  @Override
  public void start(ReqT req, VRpcCallContext ctx, VRpcListener<RespT> listener) {
    if (started) {
      VRpcResult alreadyStarted =
          VRpcResult.createRejectedError(
              Status.FAILED_PRECONDITION.withDescription("operation is already started"));
      ctx.getExecutor().execute(() -> listener.onClose(alreadyStarted));
      return;
    }

    // Publish the fields BEFORE the try block. If anything below throws and we recover via
    // cancel(), cancel() reads this.context / this.listener — they must be set already, or
    // we trade the original failure for an NPE inside the recovery path.
    this.request = req;
    this.currentRequest = req;
    this.listener = listener;
    this.context = ctx;
    this.tracer = context.getTracer();
    // Starting the operation implicitly requests the first response.
    this.outstanding = 1;

    tracer.onOperationStart();
    started = true;

    try {
      currentState.onStart();
    } catch (Throwable t) {
      cancel("Unexpected error in start", t);
    }
  }

  @Override
  public void cancel(@Nullable String message, @Nullable Throwable cause) {
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
  }

  @Override
  public boolean isDone() {
    return currentState.isDone();
  }

  @Override
  public void requestNext() {
    // Guarded on started so a misuse before start() surfaces a clear error (and a debug tag) rather
    // than an NPE on the affinity assertion below, which reads this.context.
    debugTagTracer.checkPrecondition(
        started, "request_more_before_start", "requestNext called before start");
    context.getExecutor().throwIfNotInThisExecutor();
    currentState.onRequestNext();
  }

  void onStateChange(State state) {
    if (currentState.isDone()) {
      return;
    }
    // Give the outgoing state a chance to release per-state resources (timers, registrations,
    // tracer pairings). Default is a no-op; states that hold cleanup-worthy resources override.
    currentState.onExit();
    this.currentState = state;
    currentState.onStart();
  }

  abstract static class State {
    public abstract void onStart();

    public void onExit() {}

    public void onCancel(String reason, Throwable throwable) {}

    public void onRequestNext() {}

    public boolean isDone() {
      return false;
    }
  }

  // Both the initial request and every retry land here first. An attempt is launched only while the
  // caller is actually demanding a response: on the initial start() and on a retry that happened
  // while demand was outstanding, `outstanding` is already 1 and we go straight to Active. On a
  // retry that happened while parked between responses (a spontaneous transport failure with no
  // demand), we wait here until requestNext arrives, so we never push an unsolicited response.
  class Idle extends State {

    @Override
    public void onStart() {
      if (outstanding > 0) {
        onStateChange(new Active());
      }
    }

    @Override
    public void onRequestNext() {
      outstanding = 1;
      onStateChange(new Active());
    }
  }

  class Active extends State {

    private VRpc<ReqT, RespT> attempt;
    // Tracer pairing flag scoped to this attempt. finishAttempt is idempotent via this flag so
    // listener path, cancel path, and onExit safety net never double-fire.
    private boolean attemptFinished = false;

    private void finishAttempt(VRpcResult result) {
      if (!attemptFinished) {
        attemptFinished = true;
        tracer.onAttemptFinish(result);
      }
    }

    @Override
    public void onStart() {
      attempt = attemptFactory.get();
      tracer.onAttemptStart(currentRequest);
      attempt.start(
          currentRequest,
          context,
          new VRpcListener<RespT>() {
            @Override
            public void onMessage(RespT msg) {
              context.getExecutor().throwIfNotInThisExecutor();
              if (currentState != Active.this) {
                LOG.log(
                    Level.FINE,
                    "Discarding response {0} because the attempt is no longer active.",
                    msg);
                return;
              }
              // A delivered response is progress: it satisfies the outstanding demand.
              outstanding = 0;
              resumptionStrategy.onResponse(msg);
              tracer.onResponseReceived();
              Stopwatch appTimer = Stopwatch.createStarted();
              Throwable userThrow = null;
              try {
                listener.onMessage(msg);
              } catch (Throwable t) {
                userThrow = t;
              } finally {
                tracer.recordApplicationBlockingLatencies(appTimer.elapsed());
              }
              if (userThrow != null) {
                // Classify as USER_FAILURE (not CANCELLED, which is what the OpExecutor uncaught
                // handler would produce via chain.cancel). Finish the attempt's tracer span
                // with the user-error result, cancel the underlying gRPC call so no further
                // events arrive (its later onClose is dropped by the currentState !=
                // Active.this guard), and transition directly to Done.
                VRpcResult userResult = VRpcResult.createUserError(userThrow);
                finishAttempt(userResult);
                attempt.cancel("User callback threw", userThrow);
                onStateChange(new Done(userResult));
              }
            }

            @Override
            public void onClose(VRpcResult result) {
              context.getExecutor().throwIfNotInThisExecutor();
              if (currentState != Active.this) {
                LOG.log(
                    Level.FINE,
                    "Discarding server close with result {0} because the the attempt is no"
                        + " longer active.",
                    result);
                return;
              }
              finishAttempt(result);
              if (shouldRetry(result)) {
                // Rewrite the request to resume from where the stream left off. A null result
                // means the scan is already fully satisfied, so complete OK instead of retrying.
                ReqT resumeRequest = resumptionStrategy.getResumeRequest(request);
                if (resumeRequest == null) {
                  // The attempt ended in a (retryable) error, but the scan was already fully
                  // satisfied, so we complete OK instead of resuming. Flag it: an error at the very
                  // end of a read is worth surfacing even though the user sees success. Carry the
                  // error frame's cluster attribution into the synthesized OK.
                  debugTagTracer.record(TelemetryConfiguration.Level.INFO, "error_at_end_of_read");
                  onStateChange(new Done(VRpcResult.createLocalOk(result.getClusterInfo())));
                  return;
                }
                currentRequest = resumeRequest;
                context = context.createForNextAttempt();
                // Always honor a server-directed delay by scheduling the retry. When the delay
                // elapses we drop into Idle, which decides whether to actually launch the resumed
                // attempt: if the caller is waiting (outstanding > 0) it fires immediately;
                // otherwise it parks until requestNext arrives. With no delay we go straight to
                // Idle and let it make the same decision now.
                Duration retryDelay =
                    Optional.ofNullable(result.getRetryInfo())
                        .map(RetryInfo::getRetryDelay)
                        .orElse(Durations.ZERO);
                if (Durations.compare(retryDelay, Durations.ZERO) > 0) {
                  onStateChange(new Scheduled(retryDelay));
                  return;
                }
                onStateChange(new Idle());
                return;
              }

              onStateChange(new Done(result));
            }
          });
    }

    @Override
    public void onCancel(String reason, Throwable throwable) {
      // Pair the onAttemptStart fired in onStart with an onAttemptFinish at the moment we
      // abandon the attempt — the later server onClose for the cancelled attempt is dropped by
      // the stale-state guard, so this is the only chance to balance the tracer.
      finishAttempt(
          VRpcResult.createRejectedError(
              Status.CANCELLED.withDescription(reason).withCause(throwable)));
      // attempt could be null if attemptFactory.get() threw before assignment.
      if (attempt != null) {
        attempt.cancel(reason, throwable);
      }
    }

    @Override
    public void onRequestNext() {
      if (outstanding > 0) {
        throw new IllegalStateException(
            "requestNext called before the previous response was delivered");
      }
      outstanding = 1;
      attempt.requestNext();
    }

    @Override
    public void onExit() {
      // Defense-in-depth: every existing exit path (listener.onClose, onMessage user-throw,
      // onCancel) calls finishAttempt with a meaningful result before transitioning. This catches
      // any new exit path that forgets, recording a generic 'abandoned' instead of leaking the
      // tracer span.
      finishAttempt(
          VRpcResult.createRejectedError(
              Status.CANCELLED.withDescription("attempt abandoned during transition")));
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
    private BigtableTimer.Timeout future;
    // Registered with the timer on entry so a Client.close that stops the timer drives this
    // Scheduled to a CANCELLED Done instead of silently discarding the pending timeout.
    private BigtableTimer.Registration stopHook;

    Scheduled(Duration retryDelay) {
      this.retryDelay = retryDelay;
    }

    @Override
    public void onStart() {
      // If the timer is already stopped, onStop fires the hook synchronously here — which
      // enqueues an onTimerStopping body on the op executor — and newTimeout returns a
      // pre-cancelled Timeout. The queued onTimerStopping then drives us to Done(CANCELLED).
      stopHook = timer.onStop(this::onTimerStopping);
      // Wraps go innermost so the captured gRPC + OpenTelemetry contexts are re-established at
      // the moment the body runs on the op executor.
      future =
          timer.newTimeout(
              () ->
                  grpcContext
                      .wrap(() -> otelContext.wrap(() -> onStateChange(new Idle())).run())
                      .run(),
              context.getExecutor(),
              Durations.toMillis(retryDelay),
              TimeUnit.MILLISECONDS);
    }

    @Override
    public void onRequestNext() {
      // A caller can ask for the next response while we are waiting out a server-directed delay
      // (this happens when the retry fired with no demand outstanding). Record the demand but keep
      // honoring the delay — when the timer fires we drop into Idle, which sees outstanding > 0 and
      // launches the resumed attempt.
      outstanding = 1;
    }

    // Invoked from BigtableTimer.stop on the close thread. Trampoline back to the op executor so
    // currentState reads and onStateChange are still single-threaded with the rest of the chain.
    private void onTimerStopping() {
      context
          .getExecutor()
          .execute(
              () -> {
                if (currentState != Scheduled.this) {
                  return; // already transitioned out via normal fire or cancel
                }
                onStateChange(
                    new Done(
                        VRpcResult.createRejectedError(
                            Status.CANCELLED.withDescription(
                                "Client closing while retry pending"))));
              });
    }

    @Override
    public void onExit() {
      // Consolidated cleanup: runs on every exit path (normal fire → Idle, cancel → Done,
      // shutdown hook → Done). Both fields may be null if schedule threw an ISE before assignment.
      if (stopHook != null) {
        stopHook.unregister();
        stopHook = null;
      }
      if (future != null && !future.isCancelled()) {
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
      // Per-attempt tracer pairing is owned by Active.onExit; Done just runs the user listener
      // and the per-operation tracer finish.
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
