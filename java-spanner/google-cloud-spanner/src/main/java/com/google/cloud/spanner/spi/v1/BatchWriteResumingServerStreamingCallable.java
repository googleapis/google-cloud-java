/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.spi.v1;

import static com.google.cloud.spanner.XGoogSpannerRequestId.REQUEST_ID_CALL_OPTIONS_KEY;

import com.google.api.core.ApiClock;
import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StateCheckingResponseObserver;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import com.google.api.gax.tracing.BaseApiTracer;
import com.google.api.gax.tracing.MetricsTracer;
import com.google.api.gax.tracing.SpanName;
import com.google.cloud.grpc.GcpManagedChannel;
import com.google.cloud.grpc.GcpManagedChannel.ChannelAffinityRef;
import com.google.cloud.spanner.BuiltInMetricsConstant;
import com.google.cloud.spanner.CompositeTracer;
import com.google.cloud.spanner.XGoogSpannerRequestId;
import com.google.cloud.spanner.spi.v1.BatchWriteRetryPolicy.RetryDecision;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.spanner.v1.BatchWriteRequest;
import com.google.spanner.v1.BatchWriteResponse;
import io.grpc.CallOptions;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Status;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.DoubleSupplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/**
 * A {@link ServerStreamingCallable} for Spanner {@code BatchWrite} that transparently retries
 * transient stream failures and premature EOFs, sending only unacknowledged mutation groups and
 * translating response indices back to the caller's original index space.
 *
 * <p>Manages a single operation {@link ApiTracer} spanning all retry attempts directly so that
 * user-initiated, gRPC-context, deadline-expiration, and client-shutdown cancellations record
 * consistent attempt and operation metrics.
 */
@InternalApi
public final class BatchWriteResumingServerStreamingCallable
    extends ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> {

  private static final SpanName BATCH_WRITE_SPAN_NAME = SpanName.of("Spanner", "BatchWrite");
  private static final Pattern SESSION_RESOURCE_PATTERN =
      Pattern.compile(
          "projects/(?<project>[^/]+)/instances/(?<instance>[^/]+)/databases/(?<database>[^/]+)(?:/.*)?");
  private static final String QUEUING_RESPONSE_OBSERVER_CLASS_NAME =
      "com.google.api.gax.rpc.QueuingResponseObserver";
  private static final long DEFAULT_ABANDONED_STREAM_SWEEP_INTERVAL_MILLIS = 1_000L;

  /** Lifecycle callbacks invoked by {@link BatchWriteResumingServerStreamingCallable}. */
  @InternalApi
  public interface StreamLifecycleListener {
    /** Invoked when a retry attempt is started to resume remaining mutation groups. */
    default void onResume(int oneBasedAttempt, int remainingMutationGroups) {}

    /**
     * Invoked once when the stream terminates cleanly ({@code error == null}) or with a terminal
     * error / cancellation, immediately before notifying the outer observer.
     */
    void onComplete(@Nullable Throwable error);
  }

  /** Internal {@link CallOptions} key carrying a {@link StreamLifecycleListener}. */
  @InternalApi
  public static final CallOptions.Key<StreamLifecycleListener> LIFECYCLE_LISTENER_KEY =
      CallOptions.Key.create("batch_write_lifecycle_listener");

  private static final StreamController NOOP_STREAM_CONTROLLER =
      new StreamController() {
        @Override
        public void cancel() {}

        @Override
        public void disableAutoInboundFlowControl() {}

        @Override
        public void request(int count) {}
      };

  private static final ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse>
      EMPTY_CALLABLE =
          new ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse>() {
            @Override
            public void call(
                BatchWriteRequest request,
                ResponseObserver<BatchWriteResponse> responseObserver,
                ApiCallContext context) {
              responseObserver.onStart(NOOP_STREAM_CONTROLLER);
              responseObserver.onComplete();
            }
          };

  private final ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> innerCallable;
  private final RetrySettings defaultRetrySettings;
  private final ImmutableSet<Code> defaultRetryableCodes;
  private final ScheduledExecutorService executor;
  private final ApiClock clock;
  private final ApiTracerFactory tracerFactory;
  private final int numChannels;
  private final boolean isGrpcGcpExtensionEnabled;
  private final DoubleSupplier jitterRandom;
  private final long abandonedStreamSweepIntervalMillis;
  private final Set<BatchWriteStreamCoordinator> activeStreams = ConcurrentHashMap.newKeySet();
  private final ReferenceQueue<ResponseObserver<BatchWriteResponse>> abandonedStreamQueue =
      new ReferenceQueue<>();
  private final Set<AbandonedStreamRef> trackedStreamRefs = ConcurrentHashMap.newKeySet();
  private final Object sweepLock = new Object();

  @GuardedBy("sweepLock")
  @Nullable
  private ScheduledFuture<?> sweepFuture;

  public BatchWriteResumingServerStreamingCallable(
      ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> innerCallable,
      RetrySettings defaultRetrySettings,
      Set<Code> defaultRetryableCodes,
      ScheduledExecutorService executor,
      ApiClock clock,
      ApiTracerFactory tracerFactory,
      int numChannels,
      boolean isGrpcGcpExtensionEnabled) {
    this(
        innerCallable,
        defaultRetrySettings,
        defaultRetryableCodes,
        executor,
        clock,
        tracerFactory,
        numChannels,
        isGrpcGcpExtensionEnabled,
        () -> ThreadLocalRandom.current().nextDouble(),
        DEFAULT_ABANDONED_STREAM_SWEEP_INTERVAL_MILLIS);
  }

  @VisibleForTesting
  BatchWriteResumingServerStreamingCallable(
      ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> innerCallable,
      RetrySettings defaultRetrySettings,
      Set<Code> defaultRetryableCodes,
      ScheduledExecutorService executor,
      ApiClock clock,
      ApiTracerFactory tracerFactory,
      int numChannels,
      boolean isGrpcGcpExtensionEnabled,
      DoubleSupplier jitterRandom) {
    this(
        innerCallable,
        defaultRetrySettings,
        defaultRetryableCodes,
        executor,
        clock,
        tracerFactory,
        numChannels,
        isGrpcGcpExtensionEnabled,
        jitterRandom,
        DEFAULT_ABANDONED_STREAM_SWEEP_INTERVAL_MILLIS);
  }

  @VisibleForTesting
  BatchWriteResumingServerStreamingCallable(
      ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> innerCallable,
      RetrySettings defaultRetrySettings,
      Set<Code> defaultRetryableCodes,
      ScheduledExecutorService executor,
      ApiClock clock,
      ApiTracerFactory tracerFactory,
      int numChannels,
      boolean isGrpcGcpExtensionEnabled,
      DoubleSupplier jitterRandom,
      long abandonedStreamSweepIntervalMillis) {
    this.innerCallable = Preconditions.checkNotNull(innerCallable);
    this.defaultRetrySettings = Preconditions.checkNotNull(defaultRetrySettings);
    this.defaultRetryableCodes =
        ImmutableSet.copyOf(Preconditions.checkNotNull(defaultRetryableCodes));
    this.executor = Preconditions.checkNotNull(executor);
    this.clock = Preconditions.checkNotNull(clock);
    this.tracerFactory = Preconditions.checkNotNull(tracerFactory);
    this.numChannels = Math.max(1, numChannels);
    this.isGrpcGcpExtensionEnabled = isGrpcGcpExtensionEnabled;
    this.jitterRandom = Preconditions.checkNotNull(jitterRandom);
    this.abandonedStreamSweepIntervalMillis = Math.max(1L, abandonedStreamSweepIntervalMillis);
  }

  /** Returns an immediately completed empty {@link ServerStream} with zero network RPCs. */
  public static ServerStream<BatchWriteResponse> emptyServerStream() {
    return EMPTY_CALLABLE.call(BatchWriteRequest.getDefaultInstance());
  }

  /**
   * Cancels all active {@code BatchWrite} streams and any pending retry timers (for example, when
   * the Spanner client is shut down while consumers have abandoned streams).
   */
  public void cancelAll() {
    synchronized (sweepLock) {
      if (sweepFuture != null) {
        sweepFuture.cancel(false);
        sweepFuture = null;
      }
    }
    ApiException shutdownError =
        ApiExceptionFactory.createException(
            "BatchWrite stream cancelled due to client shutdown",
            null,
            GrpcStatusCode.of(Status.Code.CANCELLED),
            /* retryable= */ false);
    for (BatchWriteStreamCoordinator coordinator : activeStreams) {
      coordinator.onExternalCancel(shutdownError);
    }
  }

  @VisibleForTesting
  void drainAbandonedStreams() {
    AbandonedStreamRef ref;
    while ((ref = (AbandonedStreamRef) abandonedStreamQueue.poll()) != null) {
      trackedStreamRefs.remove(ref);
      ref.coordinator.onExternalCancel(createAbandonedStreamError());
    }
  }

  private void ensureSweepScheduled() {
    synchronized (sweepLock) {
      if (sweepFuture != null || trackedStreamRefs.isEmpty()) {
        return;
      }
      try {
        sweepFuture =
            executor.scheduleAtFixedRate(
                this::sweepAbandonedStreams,
                abandonedStreamSweepIntervalMillis,
                abandonedStreamSweepIntervalMillis,
                TimeUnit.MILLISECONDS);
      } catch (RejectedExecutionException ignored) {
        // Executor is shutting down; cancelAll() will clean up remaining streams.
      }
    }
  }

  private void sweepAbandonedStreams() {
    drainAbandonedStreams();
    synchronized (sweepLock) {
      if (trackedStreamRefs.isEmpty() && sweepFuture != null) {
        sweepFuture.cancel(false);
        sweepFuture = null;
      }
    }
  }

  private static ApiException createAbandonedStreamError() {
    return ApiExceptionFactory.createException(
        "BatchWrite stream abandoned by consumer without calling cancel()",
        null,
        GrpcStatusCode.of(Status.Code.CANCELLED),
        /* retryable= */ false);
  }

  @VisibleForTesting
  int getActiveStreamCount() {
    return activeStreams.size();
  }

  @Override
  public void call(
      BatchWriteRequest request,
      ResponseObserver<BatchWriteResponse> responseObserver,
      ApiCallContext context) {
    Preconditions.checkNotNull(request, "request cannot be null");
    Preconditions.checkNotNull(responseObserver, "responseObserver cannot be null");
    drainAbandonedStreams();

    if (request.getMutationGroupsCount() == 0) {
      StreamLifecycleListener listener =
          context instanceof GrpcCallContext
              ? ((GrpcCallContext) context).getCallOptions().getOption(LIFECYCLE_LISTENER_KEY)
              : null;
      responseObserver.onStart(NOOP_STREAM_CONTROLLER);
      if (listener != null) {
        listener.onComplete(null);
      }
      responseObserver.onComplete();
      return;
    }

    ApiCallContext effectiveContext = context != null ? context : GrpcCallContext.createDefault();
    RetrySettings effectiveRetrySettings =
        effectiveContext.getRetrySettings() != null
            ? effectiveContext.getRetrySettings()
            : defaultRetrySettings;
    Set<Code> effectiveRetryableCodes =
        effectiveContext.getRetryableCodes() != null
            ? effectiveContext.getRetryableCodes()
            : defaultRetryableCodes;
    BatchWriteRetryPolicy retryPolicy =
        new BatchWriteRetryPolicy(
            effectiveRetrySettings, effectiveRetryableCodes, clock, jitterRandom);

    ApiTracer operationTracer =
        tracerFactory.newTracer(
            effectiveContext.getTracer(), BATCH_WRITE_SPAN_NAME, OperationType.ServerStreaming);
    if (operationTracer == null) {
      operationTracer = BaseApiTracer.getInstance();
    }
    effectiveContext = effectiveContext.withTracer(operationTracer);

    BatchWriteStreamCoordinator coordinator =
        new BatchWriteStreamCoordinator(
            request,
            responseObserver,
            effectiveContext,
            operationTracer,
            retryPolicy,
            Context.current());
    coordinator.start(responseObserver);
  }

  private static final class AbandonedStreamRef
      extends WeakReference<ResponseObserver<BatchWriteResponse>> {
    final BatchWriteStreamCoordinator coordinator;

    AbandonedStreamRef(
        ResponseObserver<BatchWriteResponse> observer,
        ReferenceQueue<ResponseObserver<BatchWriteResponse>> queue,
        BatchWriteStreamCoordinator coordinator) {
      super(observer, queue);
      this.coordinator = coordinator;
    }
  }

  private enum DirectExecutor implements Executor {
    INSTANCE;

    @Override
    public void execute(Runnable command) {
      command.run();
    }
  }

  private enum CoordinatorState {
    /** Before the first inner attempt has been started. */
    IDLE,
    /** An inner stream attempt is currently in flight. */
    STREAMING,
    /** Between attempts: evaluating retry policy or waiting for a scheduled backoff timer. */
    BACKOFF,
    /**
     * External cancellation requested while an attempt is in flight; awaiting inner termination.
     */
    CANCELLING,
    /** Terminal state: outer observer has been (or is being) notified once. */
    TERMINATED
  }

  private final class BatchWriteStreamCoordinator {
    private final Object lock = new Object();

    // For ServerStream callers (QueuingResponseObserver), hold only a WeakReference so dropping
    // the ServerStream and its Iterator without calling cancel() allows GC to enqueue the ref and
    // trigger prompt stream/timer cancellation. For direct async ResponseObserver callers, keep a
    // strong reference per GAX callback semantics.
    @Nullable private final ResponseObserver<BatchWriteResponse> strongOuterObserver;
    @Nullable private final AbandonedStreamRef weakOuterObserverRef;
    private final ApiCallContext baseContext;
    private final ApiTracer tracer;
    private final BatchWriteRetryPolicy retryPolicy;
    private final Context grpcContext;
    private final io.opentelemetry.context.Context otelContext;
    @Nullable private final StreamLifecycleListener lifecycleListener;
    private final AtomicBoolean lifecycleCompleted = new AtomicBoolean(false);
    private final long operationStartNanos;
    private final int initialChannelAffinity;
    @Nullable private final ChannelAffinityRef grpcGcpChannelAffinityRef;

    @GuardedBy("lock")
    private final BatchWriteResumptionState resumptionState;

    // Flow control configuration (set synchronously during outerObserver.onStart).
    private boolean autoFlowControl = true;
    private boolean started;

    @GuardedBy("lock")
    private CoordinatorState state = CoordinatorState.IDLE;

    @GuardedBy("lock")
    private int pendingDemand;

    @GuardedBy("lock")
    @Nullable
    private StreamController activeInnerController;

    @GuardedBy("lock")
    @Nullable
    private ScheduledFuture<?> pendingRetryFuture;

    @GuardedBy("lock")
    private int activeAttemptId;

    @GuardedBy("lock")
    private int attemptCount;

    @GuardedBy("lock")
    @Nullable
    private Throwable cancellationCause;

    @GuardedBy("lock")
    @Nullable
    private Throwable lastRetryableError;

    private final Context.CancellationListener contextCancellationListener =
        ctx -> onExternalCancel(BatchWriteRetryPolicy.createContextCancellationException(ctx));

    BatchWriteStreamCoordinator(
        BatchWriteRequest initialRequest,
        ResponseObserver<BatchWriteResponse> outerObserver,
        ApiCallContext baseContext,
        ApiTracer tracer,
        BatchWriteRetryPolicy retryPolicy,
        Context grpcContext) {
      if (QUEUING_RESPONSE_OBSERVER_CLASS_NAME.equals(outerObserver.getClass().getName())) {
        this.strongOuterObserver = null;
        this.weakOuterObserverRef =
            new AbandonedStreamRef(outerObserver, abandonedStreamQueue, this);
      } else {
        this.strongOuterObserver = outerObserver;
        this.weakOuterObserverRef = null;
      }
      this.baseContext = baseContext != null ? baseContext : GrpcCallContext.createDefault();
      this.tracer = tracer != null ? tracer : BaseApiTracer.getInstance();
      this.retryPolicy = retryPolicy;
      this.grpcContext = grpcContext;
      this.otelContext = io.opentelemetry.context.Context.current();
      this.lifecycleListener =
          this.baseContext instanceof GrpcCallContext
              ? ((GrpcCallContext) this.baseContext)
                  .getCallOptions()
                  .getOption(LIFECYCLE_LISTENER_KEY)
              : null;
      this.operationStartNanos = clock.nanoTime();
      this.resumptionState = new BatchWriteResumptionState(initialRequest);

      Integer configuredAffinity =
          baseContext instanceof GrpcCallContext
              ? ((GrpcCallContext) baseContext).getChannelAffinity()
              : null;
      this.initialChannelAffinity =
          configuredAffinity != null
              ? Math.floorMod(configuredAffinity, numChannels)
              : ThreadLocalRandom.current().nextInt(numChannels);

      if (isGrpcGcpExtensionEnabled) {
        ChannelAffinityRef existingRef =
            this.baseContext instanceof GrpcCallContext
                ? ((GrpcCallContext) this.baseContext)
                    .getCallOptions()
                    .getOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY)
                : null;
        this.grpcGcpChannelAffinityRef =
            existingRef != null ? existingRef : new ChannelAffinityRef();
      } else {
        this.grpcGcpChannelAffinityRef = null;
      }
    }

    void start(ResponseObserver<BatchWriteResponse> initialObserver) {
      initialObserver.onStart(
          new StreamController() {
            @Override
            public void disableAutoInboundFlowControl() {
              Preconditions.checkState(
                  !started, "Can't disable auto flow control once the stream is started");
              autoFlowControl = false;
            }

            @Override
            public void request(int count) {
              onOuterRequest(count);
            }

            @Override
            public void cancel() {
              onExternalCancel(new CancellationException("User cancelled BatchWrite stream"));
            }
          });

      if (autoFlowControl) {
        synchronized (lock) {
          pendingDemand = Integer.MAX_VALUE;
        }
      }
      started = true;
      activeStreams.add(this);
      if (weakOuterObserverRef != null) {
        trackedStreamRefs.add(weakOuterObserverRef);
        ensureSweepScheduled();
      }

      if (grpcContext.isCancelled()) {
        onExternalCancel(BatchWriteRetryPolicy.createContextCancellationException(grpcContext));
        return;
      }
      grpcContext.addListener(contextCancellationListener, DirectExecutor.INSTANCE);

      startAttempt();
    }

    private void onOuterRequest(int count) {
      Preconditions.checkState(!autoFlowControl, "Automatic flow control is enabled");
      Preconditions.checkArgument(count > 0, "Count must be > 0");

      StreamController controllerToRequest;
      int inc;
      synchronized (lock) {
        if (state == CoordinatorState.CANCELLING || state == CoordinatorState.TERMINATED) {
          return;
        }
        int maxInc = Integer.MAX_VALUE - pendingDemand;
        inc = Math.min(maxInc, count);
        pendingDemand += inc;
        controllerToRequest = activeInnerController;
      }
      if (controllerToRequest != null && inc > 0) {
        controllerToRequest.request(inc);
      }
    }

    private void onExternalCancel(Throwable cause) {
      StreamController controllerToCancel;
      ScheduledFuture<?> futureToCancel;
      boolean completeImmediately = false;
      boolean cancelledBeforeFirstAttempt = false;

      synchronized (lock) {
        if (state == CoordinatorState.CANCELLING || state == CoordinatorState.TERMINATED) {
          return;
        }
        cancellationCause = cause;
        futureToCancel = pendingRetryFuture;
        pendingRetryFuture = null;
        controllerToCancel = activeInnerController;

        if (state == CoordinatorState.STREAMING) {
          // Wait for inner cancellation to drive onAttemptError (or onAttemptStart to cancel).
          state = CoordinatorState.CANCELLING;
        } else {
          // IDLE or BACKOFF: no inner stream is active, so complete immediately.
          cancelledBeforeFirstAttempt = (state == CoordinatorState.IDLE);
          state = CoordinatorState.TERMINATED;
          completeImmediately = true;
        }
      }

      if (futureToCancel != null) {
        futureToCancel.cancel(false);
      }
      if (controllerToCancel != null) {
        controllerToCancel.cancel();
      }
      if (completeImmediately) {
        if (cancelledBeforeFirstAttempt) {
          // No RPC hit the wire; populate resource labels directly for operation metrics and skip
          // attempt metrics to avoid blank labels and spurious gfe_header_missing_count.
          populateFallbackMetricAttributes();
        }
        failOuter(cause, /* attemptTracerCallback= */ null);
      }
    }

    private void startAttempt() {
      BatchWriteRequest attemptRequest = null;
      int currentAttemptNumber = 0;
      int thisAttemptId = 0;
      boolean completeWithoutRpc = false;
      Throwable preDispatchFailure = null;
      boolean failedBeforeFirstAttempt = false;

      Deadline callOptionsDeadline = getCallOptionsDeadline();
      synchronized (lock) {
        if (state != CoordinatorState.IDLE && state != CoordinatorState.BACKOFF) {
          return;
        }
        boolean isRetryWakeUp = (state == CoordinatorState.BACKOFF);
        pendingRetryFuture = null;
        if (resumptionState.isAllAcknowledged()) {
          state = CoordinatorState.TERMINATED;
          completeWithoutRpc = true;
        } else if (grpcContext.isCancelled()) {
          state = CoordinatorState.TERMINATED;
          preDispatchFailure =
              BatchWriteRetryPolicy.createContextCancellationException(grpcContext);
          failedBeforeFirstAttempt = !isRetryWakeUp;
        } else if (isRetryWakeUp) {
          // Re-check total timeout and deadlines after waking up from backoff sleep so scheduler
          // jitter past the deadline never dispatches a doomed 1ms RPC.
          ApiException expired =
              retryPolicy.checkDeadlineExceeded(
                  operationStartNanos,
                  grpcContext,
                  callOptionsDeadline,
                  /* additionalDelayMillis= */ 0L,
                  lastRetryableError);
          if (expired != null) {
            state = CoordinatorState.TERMINATED;
            preDispatchFailure = expired;
          }
        } else if (callOptionsDeadline != null && callOptionsDeadline.isExpired()) {
          state = CoordinatorState.TERMINATED;
          preDispatchFailure =
              ApiExceptionFactory.createException(
                  "BatchWrite call deadline exceeded",
                  null,
                  GrpcStatusCode.of(Status.Code.DEADLINE_EXCEEDED),
                  /* retryable= */ false);
          failedBeforeFirstAttempt = true;
        }

        if (!completeWithoutRpc && preDispatchFailure == null) {
          state = CoordinatorState.STREAMING;
          currentAttemptNumber = attemptCount++;
          thisAttemptId = ++activeAttemptId;
          activeInnerController = null;
          attemptRequest = resumptionState.buildNextAttemptRequest();
        }
      }

      if (completeWithoutRpc) {
        completeOuter(/* attemptTracerCallback= */ null);
        return;
      }
      if (preDispatchFailure != null) {
        if (failedBeforeFirstAttempt) {
          populateFallbackMetricAttributes();
        }
        failOuter(preDispatchFailure, /* attemptTracerCallback= */ null);
        return;
      }

      if (currentAttemptNumber > 0) {
        int oneBasedAttempt = currentAttemptNumber + 1;
        int remainingGroups = attemptRequest.getMutationGroupsCount();
        if (lifecycleListener != null) {
          lifecycleListener.onResume(oneBasedAttempt, remainingGroups);
        } else {
          Span otelSpan = Span.fromContext(otelContext);
          if (otelSpan.isRecording()) {
            otelSpan.addEvent(
                "Resuming BatchWrite stream",
                Attributes.builder()
                    .put("attempt", (long) oneBasedAttempt)
                    .put("remaining_mutation_groups", (long) remainingGroups)
                    .build());
          }
        }
      }

      final int expectedAttemptId = thisAttemptId;
      try {
        ApiCallContext attemptContext = createAttemptContext(currentAttemptNumber);
        tracer.attemptStarted(attemptRequest, currentAttemptNumber);
        innerCallable.call(
            attemptRequest,
            new StateCheckingResponseObserver<BatchWriteResponse>() {
              @Override
              protected void onStartImpl(StreamController controller) {
                onAttemptStart(expectedAttemptId, controller);
              }

              @Override
              protected void onResponseImpl(BatchWriteResponse response) {
                onAttemptResponse(expectedAttemptId, response);
              }

              @Override
              protected void onErrorImpl(Throwable t) {
                onAttemptError(expectedAttemptId, t);
              }

              @Override
              protected void onCompleteImpl() {
                onAttemptComplete(expectedAttemptId);
              }
            },
            attemptContext);
      } catch (Throwable t) {
        onAttemptError(expectedAttemptId, t);
      }
    }

    private ApiCallContext createAttemptContext(int zeroBasedAttemptNumber) {
      ApiCallContext ctx = baseContext;

      Duration rpcTimeout =
          retryPolicy.computeAttemptRpcTimeout(
              zeroBasedAttemptNumber, baseContext.getTimeoutDuration(), operationStartNanos);
      if (rpcTimeout != null && !rpcTimeout.isZero()) {
        ctx = ctx.withTimeoutDuration(rpcTimeout);
      }

      // Rotate channel/connection on retry so retries are not pinned to a degraded backend.
      if (ctx instanceof GrpcCallContext) {
        GrpcCallContext grpcCtx = (GrpcCallContext) ctx;
        if (isGrpcGcpExtensionEnabled) {
          if (zeroBasedAttemptNumber > 0) {
            // Exclude the channel used by the previous failed attempt on the next pick.
            grpcGcpChannelAffinityRef.useDifferentChannelOnNextCall();
          }
          CallOptions callOptions = grpcCtx.getCallOptions();
          if (callOptions.getOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY)
              != grpcGcpChannelAffinityRef) {
            callOptions =
                callOptions.withOption(
                    GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY, grpcGcpChannelAffinityRef);
            grpcCtx = grpcCtx.withCallOptions(callOptions);
          }
        } else if (numChannels > 1) {
          int channelAffinity = (initialChannelAffinity + zeroBasedAttemptNumber) % numChannels;
          grpcCtx = grpcCtx.withChannelAffinity(channelAffinity);
          XGoogSpannerRequestId requestId =
              grpcCtx.getCallOptions().getOption(REQUEST_ID_CALL_OPTIONS_KEY);
          if (requestId != null) {
            requestId.setChannelId(channelAffinity + 1);
          }
        }
        ctx = grpcCtx;
      }

      return ctx;
    }

    private void onAttemptStart(int expectedAttemptId, StreamController controller) {
      if (!autoFlowControl) {
        controller.disableAutoInboundFlowControl();
      }

      boolean shouldCancel;
      int demandToForward = 0;

      synchronized (lock) {
        if (expectedAttemptId != activeAttemptId || state != CoordinatorState.STREAMING) {
          shouldCancel = true;
        } else {
          activeInnerController = controller;
          shouldCancel = false;
          if (!autoFlowControl) {
            demandToForward = pendingDemand;
          }
        }
      }

      if (shouldCancel) {
        controller.cancel();
      } else if (demandToForward > 0) {
        controller.request(demandToForward);
      }
    }

    private void onAttemptResponse(int expectedAttemptId, BatchWriteResponse response) {
      BatchWriteResponse translated = null;
      ApiException corruptedError = null;
      StreamController controllerToCancel = null;

      synchronized (lock) {
        if (expectedAttemptId != activeAttemptId || state != CoordinatorState.STREAMING) {
          return;
        }
        if (!autoFlowControl && pendingDemand > 0) {
          pendingDemand--;
        }
        try {
          translated = resumptionState.translateAndAcknowledge(response);
        } catch (ApiException e) {
          // Route through CANCELLING so cancelling the inner stream lets HeaderInterceptor.onClose
          // populate resource & server-timing attributes before attempt/operation metrics flush.
          corruptedError = e;
          state = CoordinatorState.CANCELLING;
          cancellationCause = e;
          controllerToCancel = activeInnerController;
        }
      }

      if (corruptedError != null) {
        if (controllerToCancel != null) {
          controllerToCancel.cancel();
        }
        return;
      }

      ResponseObserver<BatchWriteResponse> observer = getOuterObserver();
      if (observer == null) {
        onExternalCancel(createAbandonedStreamError());
        return;
      }
      tracer.responseReceived();
      observer.onResponse(translated);
    }

    private void onAttemptComplete(int expectedAttemptId) {
      boolean shouldComplete = false;
      Throwable localCancelCause = null;
      int unprocessed = 0;

      synchronized (lock) {
        if (expectedAttemptId != activeAttemptId
            || (state != CoordinatorState.STREAMING && state != CoordinatorState.CANCELLING)) {
          return;
        }
        activeInnerController = null;

        if (state == CoordinatorState.CANCELLING) {
          state = CoordinatorState.TERMINATED;
          localCancelCause = cancellationCause;
        } else if (resumptionState.isAllAcknowledged()) {
          state = CoordinatorState.TERMINATED;
          shouldComplete = true;
        } else {
          state = CoordinatorState.BACKOFF;
          unprocessed = resumptionState.getRemainingCount();
        }
      }

      if (localCancelCause != null) {
        Throwable finalCancelCause = localCancelCause;
        failOuter(finalCancelCause, () -> recordAttemptCancellationOrFailure(finalCancelCause));
        return;
      }
      if (shouldComplete) {
        completeOuter(tracer::attemptSucceeded);
        return;
      }

      // Premature EOF while mutation groups remain unacknowledged -> treat as retryable
      // UNAVAILABLE.
      ApiException prematureEof =
          ApiExceptionFactory.createException(
              String.format(
                  "BatchWrite stream closed prematurely with %d unprocessed mutation groups",
                  unprocessed),
              null,
              GrpcStatusCode.of(Status.Code.UNAVAILABLE),
              /* retryable= */ true);
      handleRetryOrFail(expectedAttemptId, prematureEof);
    }

    private void onAttemptError(int expectedAttemptId, Throwable t) {
      Throwable localCancelCause = null;
      boolean completeAsOk = false;

      synchronized (lock) {
        if (expectedAttemptId != activeAttemptId
            || (state != CoordinatorState.STREAMING && state != CoordinatorState.CANCELLING)) {
          return;
        }
        activeInnerController = null;

        if (state == CoordinatorState.CANCELLING) {
          state = CoordinatorState.TERMINATED;
          localCancelCause = cancellationCause;
        } else if (resumptionState.isAllAcknowledged() && resumptionState.getTotalCount() > 0) {
          // Every mutation group has already been acknowledged; trailing transport error does not
          // affect the outcome of the operation.
          state = CoordinatorState.TERMINATED;
          completeAsOk = true;
        } else {
          state = CoordinatorState.BACKOFF;
        }
      }

      if (localCancelCause != null) {
        Throwable finalCancelCause = localCancelCause;
        failOuter(finalCancelCause, () -> recordAttemptCancellationOrFailure(finalCancelCause));
        return;
      }
      if (completeAsOk) {
        completeOuter(tracer::attemptSucceeded);
        return;
      }

      handleRetryOrFail(expectedAttemptId, t);
    }

    private void handleRetryOrFail(int expectedAttemptId, Throwable error) {
      int completedAttempts;
      synchronized (lock) {
        if (expectedAttemptId != activeAttemptId || state != CoordinatorState.BACKOFF) {
          return;
        }
        completedAttempts = attemptCount;
      }

      Deadline callOptionsDeadline = getCallOptionsDeadline();
      RetryDecision decision =
          retryPolicy.evaluate(
              error, completedAttempts, operationStartNanos, grpcContext, callOptionsDeadline);
      if (decision.action != BatchWriteRetryPolicy.Action.RETRY) {
        terminateFromBackoff(expectedAttemptId, decision);
        return;
      }

      long delayMillis = decision.delayMillis;
      synchronized (lock) {
        if (expectedAttemptId != activeAttemptId || state != CoordinatorState.BACKOFF) {
          return;
        }
        lastRetryableError = error;
      }
      tracer.attemptFailedDuration(error, Duration.ofMillis(delayMillis));

      // Propagate both gRPC Context (cancellation/deadlines/OpenCensus) and OpenTelemetry Context
      // (active span for HeaderInterceptor server-timing attributes) onto the retry thread.
      Runnable retryTask = grpcContext.wrap(otelContext.wrap(this::startAttempt));
      Throwable scheduleFailure = null;
      synchronized (lock) {
        if (expectedAttemptId != activeAttemptId || state != CoordinatorState.BACKOFF) {
          return;
        }
        try {
          pendingRetryFuture =
              executor.schedule(retryTask, Math.max(0L, delayMillis), TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException rejected) {
          state = CoordinatorState.TERMINATED;
          scheduleFailure =
              ApiExceptionFactory.createException(
                  "BatchWrite retry could not be scheduled because executor is shut down",
                  rejected,
                  GrpcStatusCode.of(Status.Code.CANCELLED),
                  /* retryable= */ false);
        }
      }
      if (scheduleFailure != null) {
        failOuter(scheduleFailure, /* attemptTracerCallback= */ null);
      }
    }

    private void terminateFromBackoff(int expectedAttemptId, RetryDecision decision) {
      synchronized (lock) {
        if (expectedAttemptId != activeAttemptId || state != CoordinatorState.BACKOFF) {
          return;
        }
        state = CoordinatorState.TERMINATED;
      }

      Throwable terminalError = decision.terminalError;
      failOuter(
          terminalError,
          () -> {
            switch (decision.action) {
              case CANCELLED:
                tracer.attemptCancelled();
                break;
              case RETRIES_EXHAUSTED:
                tracer.attemptFailedRetriesExhausted(terminalError);
                break;
              case PERMANENT_FAILURE:
              default:
                tracer.attemptPermanentFailure(terminalError);
                break;
            }
          });
    }

    @Nullable
    private Deadline getCallOptionsDeadline() {
      return baseContext instanceof GrpcCallContext
          ? ((GrpcCallContext) baseContext).getCallOptions().getDeadline()
          : null;
    }

    @Nullable
    private ResponseObserver<BatchWriteResponse> getOuterObserver() {
      return strongOuterObserver != null ? strongOuterObserver : weakOuterObserverRef.get();
    }

    private void completeOuter(@Nullable Runnable attemptTracerCallback) {
      // Capture outer observer BEFORE cleanup() clears weakOuterObserverRef.
      ResponseObserver<BatchWriteResponse> observer = getOuterObserver();
      cleanup();
      if (attemptTracerCallback != null) {
        attemptTracerCallback.run();
      }
      tracer.operationSucceeded();
      notifyLifecycleComplete(null);
      if (observer != null) {
        observer.onComplete();
      }
    }

    private void failOuter(Throwable error, @Nullable Runnable attemptTracerCallback) {
      // Capture outer observer BEFORE cleanup() clears weakOuterObserverRef.
      ResponseObserver<BatchWriteResponse> observer = getOuterObserver();
      cleanup();
      if (attemptTracerCallback != null) {
        attemptTracerCallback.run();
      }
      recordOperationCancellationOrFailure(error);
      notifyLifecycleComplete(error);
      if (observer != null) {
        observer.onError(error);
      }
    }

    private void populateFallbackMetricAttributes() {
      String session = resumptionState.getRequestTemplate().getSession();
      Matcher matcher = SESSION_RESOURCE_PATTERN.matcher(session);
      ImmutableMap.Builder<String, String> attrs = ImmutableMap.builder();
      if (matcher.matches()) {
        attrs.put(BuiltInMetricsConstant.PROJECT_ID_KEY.getKey(), matcher.group("project"));
        attrs.put(BuiltInMetricsConstant.INSTANCE_ID_KEY.getKey(), matcher.group("instance"));
        attrs.put(BuiltInMetricsConstant.DATABASE_KEY.getKey(), matcher.group("database"));
      }
      attrs.put(BuiltInMetricsConstant.DIRECT_PATH_USED_KEY.getKey(), "false");
      ImmutableMap<String, String> map = attrs.build();
      if (tracer instanceof CompositeTracer) {
        ((CompositeTracer) tracer).addAttributes(map);
      } else if (tracer instanceof MetricsTracer) {
        ((MetricsTracer) tracer).addAttributes(map);
      }
    }

    private void recordAttemptCancellationOrFailure(Throwable error) {
      if (isCancellationCause(error)) {
        tracer.attemptCancelled();
      } else {
        tracer.attemptPermanentFailure(error);
      }
    }

    private void recordOperationCancellationOrFailure(Throwable error) {
      if (isCancellationCause(error)) {
        tracer.operationCancelled();
      } else {
        tracer.operationFailed(error);
      }
    }

    private void notifyLifecycleComplete(@Nullable Throwable error) {
      if (lifecycleListener != null && lifecycleCompleted.compareAndSet(false, true)) {
        lifecycleListener.onComplete(error);
      }
    }

    private void cleanup() {
      activeStreams.remove(this);
      if (weakOuterObserverRef != null) {
        trackedStreamRefs.remove(weakOuterObserverRef);
        weakOuterObserverRef.clear();
      }
      grpcContext.removeListener(contextCancellationListener);
    }
  }

  private static boolean isCancellationCause(Throwable error) {
    if (error instanceof CancellationException) {
      return true;
    }
    return BatchWriteRetryPolicy.extractStatusCode(error) == Code.CANCELLED;
  }
}
