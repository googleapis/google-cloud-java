/*
 * Copyright 2019 Google LLC
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
package com.google.api.gax.batching;

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.FlowController.FlowControlException;
import com.google.api.gax.batching.FlowController.FlowControlRuntimeException;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.Futures;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Queues up the elements until {@link #flush()} is called; once batching is over, returned future
 * resolves.
 *
 * <p>This class is not thread-safe, and expects to be used from a single thread.
 *
 * @param <ElementT> The type of each individual element to be batched.
 * @param <ElementResultT> The type of the result for each individual element.
 * @param <RequestT> The type of the request that will contain the accumulated elements.
 * @param <ResponseT> The type of the response that will unpack into individual element results.
 */
@InternalApi("For google-cloud-java client use only")
public class BatcherImpl<ElementT, ElementResultT, RequestT, ResponseT>
    implements Batcher<ElementT, ElementResultT> {

  private static final Logger LOG = Logger.getLogger(BatcherImpl.class.getName());
  private final BatchingDescriptor<ElementT, ElementResultT, RequestT, ResponseT>
      batchingDescriptor;
  private final UnaryCallable<RequestT, ResponseT> unaryCallable;
  private final RequestT prototype;
  private final BatchingSettings batchingSettings;
  private final BatcherReference currentBatcherReference;

  private Batch<ElementT, ElementResultT, RequestT, ResponseT> currentOpenBatch;
  private final ConcurrentMap<Batch<ElementT, ElementResultT, RequestT, ResponseT>, Boolean>
      outstandingBatches = new ConcurrentHashMap<>();
  private final Object flushLock = new Object();
  private final Object elementLock = new Object();
  private final Future<?> scheduledFuture;
  private SettableApiFuture<Void> closeFuture;
  private final BatcherStats batcherStats = new BatcherStats();
  private final FlowController flowController;
  private final ApiCallContext callContext;

  // If element threshold or bytes threshold is 0, it means that it'll always flush every element
  // without batching
  private final long elementThreshold;
  private final long bytesThreshold;

  /**
   * @param batchingDescriptor a {@link BatchingDescriptor} for transforming individual elements
   *     into wrappers request and response
   * @param unaryCallable a {@link UnaryCallable} object
   * @param prototype a {@link RequestT} object
   * @param batchingSettings a {@link BatchingSettings} with configuration of thresholds
   * @deprecated Please instantiate the Batcher with {@link FlowController} and {@link
   *     ApiCallContext}
   */
  @Deprecated
  public BatcherImpl(
      BatchingDescriptor<ElementT, ElementResultT, RequestT, ResponseT> batchingDescriptor,
      UnaryCallable<RequestT, ResponseT> unaryCallable,
      RequestT prototype,
      BatchingSettings batchingSettings,
      ScheduledExecutorService executor) {

    this(batchingDescriptor, unaryCallable, prototype, batchingSettings, executor, null, null);
  }

  /**
   * @param batchingDescriptor a {@link BatchingDescriptor} for transforming individual elements
   *     into wrappers request and response
   * @param unaryCallable a {@link UnaryCallable} object
   * @param prototype a {@link RequestT} object
   * @param batchingSettings a {@link BatchingSettings} with configuration of thresholds
   * @param flowController a {@link FlowController} for throttling requests. If it's null, create a
   *     {@link FlowController} object from {@link BatchingSettings#getFlowControlSettings()}.
   * @deprecated Please instantiate the Batcher with {@link ApiCallContext}
   */
  @Deprecated
  public BatcherImpl(
      BatchingDescriptor<ElementT, ElementResultT, RequestT, ResponseT> batchingDescriptor,
      UnaryCallable<RequestT, ResponseT> unaryCallable,
      RequestT prototype,
      BatchingSettings batchingSettings,
      ScheduledExecutorService executor,
      @Nullable FlowController flowController) {

    this(
        batchingDescriptor,
        unaryCallable,
        prototype,
        batchingSettings,
        executor,
        flowController,
        null);
  }

  /**
   * @param batchingDescriptor a {@link BatchingDescriptor} for transforming individual elements
   *     into wrappers request and response
   * @param unaryCallable a {@link UnaryCallable} object
   * @param prototype a {@link RequestT} object
   * @param batchingSettings a {@link BatchingSettings} with configuration of thresholds
   * @param flowController a {@link FlowController} for throttling requests. If it's null, create a
   *     {@link FlowController} object from {@link BatchingSettings#getFlowControlSettings()}.
   * @param callContext a {@link ApiCallContext} object that'll be merged in unaryCallable
   */
  public BatcherImpl(
      BatchingDescriptor<ElementT, ElementResultT, RequestT, ResponseT> batchingDescriptor,
      UnaryCallable<RequestT, ResponseT> unaryCallable,
      RequestT prototype,
      BatchingSettings batchingSettings,
      ScheduledExecutorService executor,
      @Nullable FlowController flowController,
      @Nullable ApiCallContext callContext) {

    this.batchingDescriptor =
        Preconditions.checkNotNull(batchingDescriptor, "batching descriptor cannot be null");
    this.unaryCallable = Preconditions.checkNotNull(unaryCallable, "callable cannot be null");
    this.prototype = Preconditions.checkNotNull(prototype, "request prototype cannot be null");
    this.batchingSettings =
        Preconditions.checkNotNull(batchingSettings, "batching setting cannot be null");
    Preconditions.checkNotNull(executor, "executor cannot be null");
    if (flowController == null) {
      flowController = new FlowController(batchingSettings.getFlowControlSettings());
    }
    // If throttling is enabled, make sure flow control limits are greater or equal to batch sizes
    // to avoid deadlocking
    if (flowController.getLimitExceededBehavior() != LimitExceededBehavior.Ignore) {
      Preconditions.checkArgument(
          flowController.getMaxElementCountLimit() == null
              || batchingSettings.getElementCountThreshold() == null
              || flowController.getMaxElementCountLimit()
                  >= batchingSettings.getElementCountThreshold(),
          "If throttling and batching on element count are enabled, FlowController"
              + "#maxOutstandingElementCount must be greater or equal to elementCountThreshold");
      Preconditions.checkArgument(
          flowController.getMaxRequestBytesLimit() == null
              || batchingSettings.getRequestByteThreshold() == null
              || flowController.getMaxRequestBytesLimit()
                  >= batchingSettings.getRequestByteThreshold(),
          "If throttling and batching on request bytes are enabled, FlowController"
              + "#maxOutstandingRequestBytes must be greater or equal to requestByteThreshold");
    }
    this.flowController = flowController;
    currentOpenBatch = new Batch<>(prototype, batchingDescriptor, batcherStats);
    if (batchingSettings.getDelayThresholdDuration() != null) {
      long delay = batchingSettings.getDelayThresholdDuration().toMillis();
      PushCurrentBatchRunnable<ElementT, ElementResultT, RequestT, ResponseT> runnable =
          new PushCurrentBatchRunnable<>(this);
      scheduledFuture =
          executor.scheduleWithFixedDelay(runnable, delay, delay, TimeUnit.MILLISECONDS);
    } else {
      scheduledFuture = Futures.immediateCancelledFuture();
    }
    currentBatcherReference = new BatcherReference(this);
    this.callContext = callContext;

    Long elementCountThreshold = batchingSettings.getElementCountThreshold();
    this.elementThreshold = elementCountThreshold == null ? 0 : elementCountThreshold;
    Long requestByteThreshold = batchingSettings.getRequestByteThreshold();
    this.bytesThreshold = requestByteThreshold == null ? 0 : requestByteThreshold;
  }

  /** {@inheritDoc} */
  @Override
  public ApiFuture<ElementResultT> add(ElementT element) {
    // Note: there is no need to synchronize over closeFuture. The write & read of the variable
    // will only be done from a single calling thread.
    Preconditions.checkState(closeFuture == null, "Cannot add elements on a closed batcher");

    BatchResource newResource = batchingDescriptor.createResource(element);

    // This is not the optimal way of throttling. It does not send out partial batches, which
    // means that the Batcher might not use up all the resources allowed by FlowController.
    // The more efficient implementation should look like:
    // if (!flowController.tryReserve(1, bytes)) {
    //   sendOutstanding();
    //   reserve(1, bytes);
    // }
    // where tryReserve() will return false if there isn't enough resources, or reserve and return
    // true.
    // However, with the current FlowController implementation, adding a tryReserve() could be
    // confusing. FlowController will end up having 3 different reserve behaviors: blocking,
    // non blocking and try reserve. And we'll also need to add a tryAcquire() to the Semaphore64
    // class, which made it seem unnecessary to have blocking and non-blocking semaphore
    // implementations. Some refactoring may be needed for the optimized implementation. So we'll
    // defer it till we decide on if refactoring FlowController is necessary.
    Stopwatch stopwatch = Stopwatch.createStarted();
    try {
      flowController.reserve(newResource.getElementCount(), newResource.getByteCount());
    } catch (FlowControlException e) {
      // This exception will only be thrown if the FlowController is set to ThrowException behavior
      throw FlowControlRuntimeException.fromFlowControlException(e);
    }
    long throttledTimeMs = stopwatch.elapsed(TimeUnit.MILLISECONDS);

    SettableApiFuture<ElementResultT> result = SettableApiFuture.create();
    synchronized (elementLock) {
      if (currentOpenBatch
          .resource
          .add(newResource)
          .shouldFlush(elementThreshold, bytesThreshold)) {
        sendOutstanding();
      }

      currentOpenBatch.add(element, newResource, result, throttledTimeMs);
    }

    return result;
  }

  /** {@inheritDoc} */
  @Override
  public void flush() throws InterruptedException {
    sendOutstanding();
    awaitAllOutstandingBatches();
  }

  /** {@inheritDoc} */
  @Override
  public void sendOutstanding() {
    final Batch<ElementT, ElementResultT, RequestT, ResponseT> accumulatedBatch;

    synchronized (elementLock) {
      if (currentOpenBatch.isEmpty()) {
        return;
      }
      accumulatedBatch = currentOpenBatch;
      currentOpenBatch = new Batch<>(prototype, batchingDescriptor, batcherStats);
    }

    // This check is for old clients that instantiated the batcher without ApiCallContext
    ApiCallContext callContextWithOption = null;
    if (callContext != null) {
      callContextWithOption =
          callContext.withOption(THROTTLED_TIME_KEY, accumulatedBatch.totalThrottledTimeMs);
    }
    ApiFuture<ResponseT> batchResponse;
    try {
      batchResponse =
          unaryCallable.futureCall(accumulatedBatch.builder.build(), callContextWithOption);
    } catch (Exception ex) {
      batchResponse = ApiFutures.immediateFailedFuture(ex);
    }
    accumulatedBatch.setResponseFuture(batchResponse);

    outstandingBatches.put(accumulatedBatch, Boolean.TRUE);

    ApiFutures.addCallback(
        batchResponse,
        new ApiFutureCallback<ResponseT>() {
          @Override
          public void onSuccess(ResponseT response) {
            try {
              flowController.release(
                  accumulatedBatch.resource.getElementCount(),
                  accumulatedBatch.resource.getByteCount());
              accumulatedBatch.onBatchSuccess(response);
            } finally {
              onBatchCompletion(accumulatedBatch);
            }
          }

          @Override
          public void onFailure(Throwable throwable) {
            try {
              flowController.release(
                  accumulatedBatch.resource.getElementCount(),
                  accumulatedBatch.resource.getByteCount());
              accumulatedBatch.onBatchFailure(throwable);
            } finally {
              onBatchCompletion(accumulatedBatch);
            }
          }
        },
        directExecutor());
  }

  private void onBatchCompletion(Batch<ElementT, ElementResultT, RequestT, ResponseT> batch) {
    boolean shouldClose = false;

    synchronized (flushLock) {
      outstandingBatches.remove(batch);
      if (outstandingBatches.isEmpty()) {
        flushLock.notifyAll();
        shouldClose = closeFuture != null;
      }
    }
    if (shouldClose) {
      BatchingException overallError = batcherStats.asException();
      if (overallError != null) {
        closeFuture.setException(overallError);
      } else {
        closeFuture.set(null);
      }
    }
  }

  private void awaitAllOutstandingBatches() throws InterruptedException {
    while (!outstandingBatches.isEmpty()) {
      synchronized (flushLock) {
        // Check again under lock to avoid racing with onBatchCompletion
        if (outstandingBatches.isEmpty()) {
          break;
        }
        flushLock.wait();
      }
    }
  }

  @Override
  public void cancelOutstanding() {
    for (Batch<?, ?, ?, ?> batch : outstandingBatches.keySet()) {
      batch.cancel();
    }
  }

  /** {@inheritDoc} */
  @Override
  public void close() throws InterruptedException {
    try {
      close(null);
    } catch (TimeoutException e) {
      // should never happen with a null timeout
      throw new IllegalStateException(
          "Unexpected timeout exception when trying to close the batcher without a timeout", e);
    }
  }

  @Override
  public void close(@Nullable Duration timeout) throws InterruptedException, TimeoutException {
    try {
      if (timeout != null) {
        closeAsync().get(timeout.toMillis(), TimeUnit.MILLISECONDS);
      } else {
        closeAsync().get();
      }
    } catch (ExecutionException e) {
      // Original stacktrace of a batching exception is not useful, so rethrow the error with
      // the caller stacktrace
      if (e.getCause() instanceof BatchingException) {
        BatchingException cause = (BatchingException) e.getCause();
        throw new BatchingException(cause.getMessage());
      } else {
        throw new IllegalStateException("unexpected error closing the batcher", e.getCause());
      }
    } catch (TimeoutException e) {
      StringJoiner batchesStr = new StringJoiner(",");
      for (Batch<ElementT, ElementResultT, RequestT, ResponseT> batch :
          outstandingBatches.keySet()) {
        batchesStr.add(batch.toString());
      }
      String msg = "Timed out trying to close batcher after " + timeout + ".";
      msg += " Batch request prototype: " + prototype + ".";
      msg += " Outstanding batches: " + batchesStr;

      throw new TimeoutException(msg);
    }
  }

  @Override
  public ApiFuture<Void> closeAsync() {
    if (closeFuture != null) {
      return closeFuture;
    }

    // Send any buffered elements
    // Must come before numOfOutstandingBatches check below
    sendOutstanding();

    boolean closeImmediately;

    synchronized (flushLock) {
      // prevent admission of new elements
      closeFuture = SettableApiFuture.create();
      // check if we can close immediately
      closeImmediately = outstandingBatches.isEmpty();
    }

    // Clean up accounting
    scheduledFuture.cancel(false);
    currentBatcherReference.closed = true;
    currentBatcherReference.clear();

    // notify futures
    if (closeImmediately) {
      finishClose();
    }
    return closeFuture;
  }

  private void finishClose() {
    BatchingException batchingException = batcherStats.asException();
    if (batchingException != null) {
      closeFuture.setException(batchingException);
    } else {
      closeFuture.set(null);
    }
  }

  @InternalApi("For google-cloud-java client use only")
  public FlowController getFlowController() {
    return flowController;
  }

  /**
   * This class represent one logical Batch. It accumulates all the elements and their corresponding
   * future results for one batch.
   */
  private static class Batch<ElementT, ElementResultT, RequestT, ResponseT> {
    private final BatchingRequestBuilder<ElementT, RequestT> builder;
    private final List<BatchEntry<ElementT, ElementResultT>> entries;
    private final BatchingDescriptor<ElementT, ElementResultT, RequestT, ResponseT> descriptor;

    private final BatcherStats batcherStats;
    private long totalThrottledTimeMs = 0;
    private BatchResource resource;

    private volatile ApiFuture<ResponseT> responseFuture;

    private Batch(
        RequestT prototype,
        BatchingDescriptor<ElementT, ElementResultT, RequestT, ResponseT> descriptor,
        BatcherStats batcherStats) {
      this.descriptor = descriptor;
      this.builder = descriptor.newRequestBuilder(prototype);
      this.entries = new ArrayList<>();
      this.batcherStats = batcherStats;
      this.resource = descriptor.createEmptyResource();
    }

    void add(
        ElementT element,
        BatchResource newResource,
        SettableApiFuture<ElementResultT> result,
        long throttledTimeMs) {
      builder.add(element);
      entries.add(BatchEntry.create(element, result));
      resource = resource.add(newResource);
      totalThrottledTimeMs += throttledTimeMs;
    }

    void setResponseFuture(@Nonnull ApiFuture<ResponseT> responseFuture) {
      Preconditions.checkNotNull(responseFuture);
      this.responseFuture = responseFuture;
    }

    void cancel() {
      if (this.responseFuture != null) {
        this.responseFuture.cancel(true);
      }
    }

    void onBatchSuccess(ResponseT response) {
      try {
        descriptor.splitResponse(response, entries);
        batcherStats.recordBatchElementsCompletion(entries);
      } catch (Exception ex) {
        onBatchFailure(ex);
      }
    }

    void onBatchFailure(Throwable throwable) {
      try {
        descriptor.splitException(throwable, entries);
      } catch (Exception ex) {
        for (BatchEntry<ElementT, ElementResultT> batchEntry : entries) {
          batchEntry.getResultFuture().setException(ex);
        }
      }
      batcherStats.recordBatchFailure(throwable);
    }

    boolean isEmpty() {
      return resource.getElementCount() == 0;
    }

    @Override
    public String toString() {
      StringJoiner elementsStr = new StringJoiner(",");
      for (BatchEntry<ElementT, ElementResultT> entry : entries) {
        elementsStr.add(
            Optional.ofNullable(entry.getElement()).map(Object::toString).orElse("null"));
      }
      return MoreObjects.toStringHelper(this)
          .add("responseFuture", responseFuture)
          .add("elements", elementsStr)
          .toString();
    }
  }

  /**
   * Executes {@link #sendOutstanding()} on a periodic interval.
   *
   * <p>This class holds a weak reference to the Batcher instance and cancels polling if the target
   * Batcher has been garbage collected.
   */
  @VisibleForTesting
  static class PushCurrentBatchRunnable<ElementT, ElementResultT, RequestT, ResponseT>
      implements Runnable {

    private Future<?> scheduledFuture;
    private final WeakReference<BatcherImpl<ElementT, ElementResultT, RequestT, ResponseT>>
        batcherReferent;

    PushCurrentBatchRunnable(BatcherImpl<ElementT, ElementResultT, RequestT, ResponseT> batcher) {
      this.batcherReferent = new WeakReference<>(batcher);
    }

    @Override
    public void run() {
      BatcherImpl<ElementT, ElementResultT, RequestT, ResponseT> batcher = batcherReferent.get();
      if (batcher == null) {
        scheduledFuture.cancel(true);
      } else {
        batcher.sendOutstanding();
      }
    }

    void setScheduledFuture(Future<?> scheduledFuture) {
      this.scheduledFuture = scheduledFuture;
    }

    boolean isCancelled() {
      return scheduledFuture.isCancelled();
    }
  }

  /**
   * On every Batcher allocation this class will check for garbage collected batchers that were
   * never closed and emit warning logs.
   */
  @VisibleForTesting
  static final class BatcherReference extends WeakReference<BatcherImpl> {

    private static final ReferenceQueue<BatcherImpl> refQueue = new ReferenceQueue<>();

    // Retain the References so they don't get GC'd
    private static final ConcurrentMap<BatcherReference, BatcherReference> refs =
        new ConcurrentHashMap<>();

    private static final String ALLOCATION_SITE_PROPERTY_NAME =
        "com.google.api.gax.batching.Batcher.enableAllocationTracking";

    private static final boolean ENABLE_ALLOCATION_TRACKING =
        Boolean.parseBoolean(System.getProperty(ALLOCATION_SITE_PROPERTY_NAME, "true"));
    private static final RuntimeException missingCallSite = missingCallSite();

    private final Reference<RuntimeException> allocationSite;
    private volatile boolean closed;

    BatcherReference(BatcherImpl referent) {
      super(referent, refQueue);
      // allocationSite is softReference to make it garbage collectible, but delay it as long as
      // possible as BatcherReference can only be weakly referred.
      allocationSite =
          new SoftReference<>(
              ENABLE_ALLOCATION_TRACKING
                  ? new RuntimeException("Batcher allocation site")
                  : missingCallSite);
      refs.put(this, this);
      cleanQueue();
    }

    /**
     * This clear() is *not* called automatically by the JVM. As this is a weak ref, the reference
     * will be cleared automatically by the JVM, but will not be removed from {@link #refs}. We do
     * it here to avoid this ending up on the reference queue.
     */
    @Override
    public void clear() {
      clearInternal();
      // We run this here to periodically clean up the queue if any Batcher is being
      // closed properly.
      cleanQueue();
    }

    private void clearInternal() {
      super.clear();
      refs.remove(this);
      allocationSite.clear();
    }

    /**
     * It performs below tasks:
     *
     * <ul>
     *   <li>Check each batcher registered on refQueue while initialization.
     *   <li>Unregister them from refQueue.
     *   <li>If close() is not called on the batcher, then emits log with possible allocationSite.
     *   <li>Keeps track of number of batcher on which close() is not called.
     * </ul>
     */
    @VisibleForTesting
    static int cleanQueue() {
      BatcherReference ref;
      int orphanedBatchers = 0;
      while ((ref = (BatcherReference) refQueue.poll()) != null) {
        RuntimeException maybeAllocationSite = ref.allocationSite.get();
        ref.clearInternal(); // technically the reference is gone already.
        if (!ref.closed) {
          orphanedBatchers++;
          if (LOG.isLoggable(Level.SEVERE)) {
            String message = "Batcher was not closed properly!!! Make sure to call close().";
            LOG.log(Level.SEVERE, message, maybeAllocationSite);
          }
        }
      }
      return orphanedBatchers;
    }

    private static RuntimeException missingCallSite() {
      RuntimeException e =
          new RuntimeException(
              "Batcher allocation site not recorded.  Set -D"
                  + ALLOCATION_SITE_PROPERTY_NAME
                  + "=true to enable it");
      e.setStackTrace(new StackTraceElement[0]);
      return e;
    }
  }
}
