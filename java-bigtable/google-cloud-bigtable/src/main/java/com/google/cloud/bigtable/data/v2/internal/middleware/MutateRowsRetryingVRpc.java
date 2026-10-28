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
import com.google.cloud.bigtable.data.v2.internal.api.Util;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.session.BigtableTimer;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import com.google.protobuf.util.Durations;
import com.google.rpc.Code;
import com.google.rpc.RetryInfo;
import io.grpc.Context;
import io.grpc.Status;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * Retrying {@link VRpc} middleware specialized for {@code SessionMutateRows}.
 *
 * <p>Handles both whole-vRPC failures (uncommitted errors, transport failures when all active
 * entries are idempotent, and server {@code ErrorResponse}s carrying {@link RetryInfo}) and partial
 * entry-level transient failures inside an {@code OK} {@link SessionMutateRowsResponse}.
 *
 * <p>On partial failures:
 *
 * <ul>
 *   <li>Entries that succeeded ({@code OK}) or failed with non-retryable statuses are locked in at
 *       their original request indices and excluded from subsequent attempts.
 *   <li>Entries that failed with transient statuses are retried <em>only</em> if that individual
 *       entry's mutations are idempotent ({@link Util#isIdempotent}). Non-idempotent entries (e.g.
 *       {@code AddToCell}, {@code MergeToCell}, server-assigned timestamps) are never retried after
 *       reaching the server.
 *   <li>Any entry index omitted from a server response is recorded as a permanent {@code INTERNAL}
 *       error.
 *   <li>If an earlier attempt locked in partial outcomes and a subsequent retry attempt fails at
 *       the whole-vRPC level, previously resolved entry outcomes are preserved and only the
 *       remaining unresolved entries receive the final vRPC failure status.
 * </ul>
 *
 * <p>All mutable state is owned by the per-operation {@link OpExecutor}.
 */
public class MutateRowsRetryingVRpc
    implements VRpc<SessionMutateRowsRequest, SessionMutateRowsResponse> {

  private static final Logger LOG = Logger.getLogger(MutateRowsRetryingVRpc.class.getName());

  static final Set<Integer> DEFAULT_RETRYABLE_ENTRY_CODES =
      ImmutableSet.of(Code.DEADLINE_EXCEEDED_VALUE, Code.UNAVAILABLE_VALUE);
  static final Duration DEFAULT_INITIAL_BACKOFF = Duration.ofMillis(10);
  static final double DEFAULT_BACKOFF_MULTIPLIER = 2.0;
  static final Duration DEFAULT_MAX_BACKOFF = Duration.ofMinutes(1);

  private final Supplier<VRpc<SessionMutateRowsRequest, SessionMutateRowsResponse>> attemptFactory;
  private final BigtableTimer timer;
  private final Set<Integer> retryableEntryCodes;
  private final Duration initialBackoff;
  private final double backoffMultiplier;
  private final Duration maxBackoff;
  private final UnaryOperator<Runnable> contextWrapper;

  private SessionMutateRowsRequest originalRequest;
  private SessionMutateRowsRequest currentRequest;
  private boolean[] entryIdempotent;
  private SessionMutateRowsResponse.Entry[] resolvedEntries;
  private int[] activeOriginalIndices;
  private boolean hasPartialProgress = false;
  @Nullable private VRpcResult lastOkServerResult;
  private int partialRetryAttempt = 0;
  private int consecutiveNonServerRetries = 0;

  private VRpcListener<SessionMutateRowsResponse> listener;
  private VRpcCallContext context;
  private VRpcTracer tracer;

  private State currentState;
  private boolean started = false;
  private boolean isCancelling = false;

  public MutateRowsRetryingVRpc(
      Supplier<VRpc<SessionMutateRowsRequest, SessionMutateRowsResponse>> supplier,
      BigtableTimer timer) {
    this(
        supplier,
        timer,
        DEFAULT_RETRYABLE_ENTRY_CODES,
        DEFAULT_INITIAL_BACKOFF,
        DEFAULT_BACKOFF_MULTIPLIER,
        DEFAULT_MAX_BACKOFF);
  }

  @VisibleForTesting
  public MutateRowsRetryingVRpc(
      Supplier<VRpc<SessionMutateRowsRequest, SessionMutateRowsResponse>> supplier,
      BigtableTimer timer,
      Set<Integer> retryableEntryCodes,
      Duration initialBackoff,
      double backoffMultiplier,
      Duration maxBackoff) {
    this.attemptFactory = supplier;
    this.timer = timer;
    this.retryableEntryCodes = ImmutableSet.copyOf(retryableEntryCodes);
    this.initialBackoff = initialBackoff;
    this.backoffMultiplier = backoffMultiplier;
    this.maxBackoff = maxBackoff;
    Context grpcContext = Context.current();
    UnaryOperator<Runnable> otelWrap = current()::wrap;
    this.contextWrapper = task -> grpcContext.wrap(otelWrap.apply(task));
    this.currentState = new Idle();
  }

  @Override
  public void start(
      SessionMutateRowsRequest req,
      VRpcCallContext ctx,
      VRpcListener<SessionMutateRowsResponse> listener) {
    if (started) {
      VRpcResult alreadyStarted =
          VRpcResult.createRejectedError(
              Status.FAILED_PRECONDITION.withDescription("operation is already started"));
      ctx.getExecutor().execute(() -> listener.onClose(alreadyStarted));
      return;
    }

    int entryCount = req.getEntriesCount();
    this.originalRequest = req;
    this.currentRequest = req;
    this.entryIdempotent = new boolean[entryCount];
    this.resolvedEntries = new SessionMutateRowsResponse.Entry[entryCount];
    this.activeOriginalIndices = new int[entryCount];
    for (int i = 0; i < entryCount; i++) {
      this.entryIdempotent[i] = Util.isIdempotent(req.getEntries(i).getMutationsList());
      this.activeOriginalIndices[i] = i;
    }

    this.listener = listener;
    this.context = ctx;
    this.tracer = ctx.getTracer();

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
    if (context != null) {
      context.getExecutor().throwIfNotInThisExecutor();
    }
    throw new UnsupportedOperationException("request next is not supported in unary");
  }

  private void onStateChange(State state) {
    if (currentState.isDone()) {
      return;
    }
    currentState.onExit();
    this.currentState = state;
    currentState.onStart();
  }

  private boolean areAllActiveEntriesIdempotent() {
    for (int origIdx : activeOriginalIndices) {
      if (!entryIdempotent[origIdx]) {
        return false;
      }
    }
    return true;
  }

  private Duration nextPartialRetryBackoff() {
    double multiplier = Math.pow(backoffMultiplier, partialRetryAttempt);
    partialRetryAttempt++;
    double delayNanos = initialBackoff.toNanos() * multiplier;
    if (delayNanos >= maxBackoff.toNanos()) {
      return maxBackoff;
    }
    return Duration.ofNanos((long) delayNanos);
  }

  private boolean hasRemainingDeadlineFor(Duration retryDelay) {
    return context.getOperationInfo().getDeadline().timeRemaining(TimeUnit.NANOSECONDS)
            - retryDelay.toNanos()
        > TimeUnit.MILLISECONDS.toNanos(1);
  }

  abstract static class State {
    public abstract void onStart();

    public void onExit() {}

    public void onCancel(@Nullable String reason, @Nullable Throwable throwable) {}

    public boolean isDone() {
      return false;
    }
  }

  class Idle extends State {
    @Override
    public void onStart() {
      onStateChange(new Active());
    }
  }

  class Active extends State {
    private VRpc<SessionMutateRowsRequest, SessionMutateRowsResponse> attempt;
    private boolean attemptFinished = false;
    @Nullable private SessionMutateRowsResponse attemptResponse;

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
          new VRpcListener<SessionMutateRowsResponse>() {
            @Override
            public void onMessage(SessionMutateRowsResponse msg) {
              context.getExecutor().throwIfNotInThisExecutor();
              if (currentState != Active.this) {
                LOG.log(
                    Level.FINE,
                    "Discarding response {0} because the attempt is no longer active.",
                    msg);
                return;
              }
              tracer.onResponseReceived();
              attemptResponse = msg;
            }

            @Override
            public void onClose(VRpcResult result) {
              context.getExecutor().throwIfNotInThisExecutor();
              if (currentState != Active.this) {
                LOG.log(
                    Level.FINE,
                    "Discarding server close with result {0} because the attempt is no longer"
                        + " active.",
                    result);
                return;
              }

              if (!result.getStatus().isOk()) {
                handleWholeVRpcError(result);
                return;
              }

              if (attemptResponse == null) {
                // Protocol error: unary vRPC closed OK without delivering a response payload.
                finishAttempt(result);
                onStateChange(new Done(result));
                return;
              }

              handleResponseAndClose(attemptResponse, result);
            }
          });
    }

    private void handleWholeVRpcError(VRpcResult result) {
      finishAttempt(result);
      if (result.getState() == VRpcResult.State.SERVER_RESULT) {
        consecutiveNonServerRetries = 0;
      }
      if (shouldRetryWholeVRpc(result)) {
        if (result.getState() != VRpcResult.State.SERVER_RESULT) {
          consecutiveNonServerRetries++;
        }
        context = context.createForNextAttempt();
        Duration retryDelay =
            Optional.ofNullable(result.getRetryInfo())
                .filter(RetryInfo::hasRetryDelay)
                .map(info -> Duration.ofNanos(Durations.toNanos(info.getRetryDelay())))
                .orElse(Duration.ZERO);
        if (!retryDelay.isZero() && !retryDelay.isNegative()) {
          onStateChange(new Scheduled(retryDelay));
        } else {
          onStateChange(new Idle());
        }
        return;
      }

      if (hasPartialProgress && lastOkServerResult != null) {
        // Earlier attempts already locked in outcomes for some entries; synthesize per-entry
        // failure statuses for the remaining unresolved entries so prior successes/permanent
        // errors are not lost.
        Status failureStatus = result.getStatus();
        String message =
            failureStatus.getDescription() != null ? failureStatus.getDescription() : "";
        for (int origIdx : activeOriginalIndices) {
          SessionMutateRowsResponse.Entry.Builder entryBuilder =
              SessionMutateRowsResponse.Entry.newBuilder().setIndex(origIdx);
          entryBuilder
              .getStatusBuilder()
              .setCode(failureStatus.getCode().value())
              .setMessage(message);
          resolvedEntries[origIdx] = entryBuilder.build();
        }
        SessionMutateRowsResponse merged = buildFinalResponse(null);
        deliverFinalMessageAndClose(merged, lastOkServerResult);
        return;
      }

      onStateChange(new Done(result));
    }

    private void handleResponseAndClose(SessionMutateRowsResponse response, VRpcResult result) {
      consecutiveNonServerRetries = 0;
      lastOkServerResult = result;
      int currentCount = activeOriginalIndices.length;
      boolean[] seen = new boolean[currentCount];

      List<Integer> retryOrigIndices = new ArrayList<>();
      List<SessionMutateRowsResponse.Entry> pendingTransientEntries = new ArrayList<>();

      for (SessionMutateRowsResponse.Entry respEntry : response.getEntriesList()) {
        int idx = Ints.checkedCast(respEntry.getIndex());
        if (idx < 0 || idx >= currentCount || seen[idx]) {
          continue;
        }
        seen[idx] = true;
        int origIdx = activeOriginalIndices[idx];
        int code = respEntry.getStatus().getCode();

        SessionMutateRowsResponse.Entry remapped = respEntry.toBuilder().setIndex(origIdx).build();

        if (code == Code.OK_VALUE) {
          resolvedEntries[origIdx] = remapped;
          hasPartialProgress = true;
        } else if (retryableEntryCodes.contains(code) && entryIdempotent[origIdx]) {
          retryOrigIndices.add(origIdx);
          pendingTransientEntries.add(remapped);
        } else {
          resolvedEntries[origIdx] = remapped;
          hasPartialProgress = true;
        }
      }

      for (int i = 0; i < currentCount; i++) {
        if (!seen[i]) {
          int origIdx = activeOriginalIndices[i];
          SessionMutateRowsResponse.Entry.Builder missingBuilder =
              SessionMutateRowsResponse.Entry.newBuilder().setIndex(origIdx);
          missingBuilder
              .getStatusBuilder()
              .setCode(Code.INTERNAL_VALUE)
              .setMessage("Missing entry response for entry " + origIdx);
          resolvedEntries[origIdx] = missingBuilder.build();
          hasPartialProgress = true;
        }
      }

      if (!retryOrigIndices.isEmpty()) {
        Duration backoff = nextPartialRetryBackoff();
        if (hasRemainingDeadlineFor(backoff)) {
          finishAttempt(result);
          SessionMutateRowsRequest.Builder nextReq = SessionMutateRowsRequest.newBuilder();
          int[] nextIndices = new int[retryOrigIndices.size()];
          for (int i = 0; i < retryOrigIndices.size(); i++) {
            int origIdx = retryOrigIndices.get(i);
            nextIndices[i] = origIdx;
            nextReq.addEntries(originalRequest.getEntries(origIdx));
          }
          currentRequest = nextReq.build();
          activeOriginalIndices = nextIndices;
          context = context.createForNextAttempt();
          if (!backoff.isZero() && !backoff.isNegative()) {
            onStateChange(new Scheduled(backoff));
          } else {
            onStateChange(new Idle());
          }
          return;
        }

        // Remaining deadline is insufficient for another retry; surface the transient entry errors.
        for (SessionMutateRowsResponse.Entry transientEntry : pendingTransientEntries) {
          resolvedEntries[Ints.checkedCast(transientEntry.getIndex())] = transientEntry;
        }
      }

      SessionMutateRowsResponse finalResponse = buildFinalResponse(response);
      Stopwatch appTimer = Stopwatch.createStarted();
      Throwable userThrow = null;
      try {
        listener.onMessage(finalResponse);
      } catch (Throwable t) {
        userThrow = t;
      } finally {
        tracer.recordApplicationBlockingLatencies(appTimer.elapsed());
      }

      if (userThrow != null) {
        VRpcResult userResult = VRpcResult.createUserError(userThrow);
        finishAttempt(userResult);
        onStateChange(new Done(userResult));
        return;
      }

      finishAttempt(result);
      onStateChange(new Done(result));
    }

    private void deliverFinalMessageAndClose(
        SessionMutateRowsResponse finalResponse, VRpcResult closeResult) {
      Stopwatch appTimer = Stopwatch.createStarted();
      Throwable userThrow = null;
      try {
        listener.onMessage(finalResponse);
      } catch (Throwable t) {
        userThrow = t;
      } finally {
        tracer.recordApplicationBlockingLatencies(appTimer.elapsed());
      }

      if (userThrow != null) {
        onStateChange(new Done(VRpcResult.createUserError(userThrow)));
        return;
      }
      onStateChange(new Done(closeResult));
    }

    private SessionMutateRowsResponse buildFinalResponse(
        @Nullable SessionMutateRowsResponse latestResponse) {
      SessionMutateRowsResponse.Builder builder = SessionMutateRowsResponse.newBuilder();
      if (latestResponse != null && latestResponse.hasRateLimitInfo()) {
        builder.setRateLimitInfo(latestResponse.getRateLimitInfo());
      }
      for (SessionMutateRowsResponse.Entry entry : resolvedEntries) {
        builder.addEntries(entry);
      }
      return builder.build();
    }

    private boolean shouldRetryWholeVRpc(VRpcResult result) {
      if (!result.getStatus().isOk()
          && result.getRetryInfo() != null
          && result.getRetryInfo().hasRetryDelay()) {
        Duration retryDelay =
            Duration.ofNanos(Durations.toNanos(result.getRetryInfo().getRetryDelay()));
        return hasRemainingDeadlineFor(retryDelay);
      }
      if (result.getRejected()) {
        return false;
      }
      boolean isRetryable =
          (result.getState() == VRpcResult.State.UNCOMMITED)
              || (areAllActiveEntriesIdempotent()
                  && result.getState() == VRpcResult.State.TRANSPORT_FAILURE);
      return isRetryable && consecutiveNonServerRetries < 3;
    }

    @Override
    public void onCancel(@Nullable String reason, @Nullable Throwable throwable) {
      finishAttempt(
          VRpcResult.createRejectedError(
              Status.CANCELLED.withDescription(reason).withCause(throwable)));
      if (attempt != null) {
        attempt.cancel(reason, throwable);
      }
    }

    @Override
    public void onExit() {
      finishAttempt(
          VRpcResult.createRejectedError(
              Status.CANCELLED.withDescription("attempt abandoned during transition")));
    }
  }

  class Scheduled extends State {
    private final Duration retryDelay;
    @Nullable private BigtableTimer.Timeout future;
    @Nullable private BigtableTimer.Registration stopHook;

    Scheduled(Duration retryDelay) {
      this.retryDelay = retryDelay;
    }

    @Override
    public void onStart() {
      stopHook = timer.onStop(this::onTimerStopping);
      future =
          timer.newTimeout(
              () -> contextWrapper.apply(() -> onStateChange(new Idle())).run(),
              context.getExecutor(),
              retryDelay.toNanos(),
              TimeUnit.NANOSECONDS);
    }

    private void onTimerStopping() {
      context
          .getExecutor()
          .execute(
              () -> {
                if (currentState != Scheduled.this) {
                  return;
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
