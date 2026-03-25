/*
 * Copyright 2016 Google LLC
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

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;
import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.ObsoleteApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.FlowController.FlowControlException;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Queues up elements until either a duration of time has passed or any threshold in a given set of
 * thresholds is breached, and then delivers the elements in a batch to the consumer.
 */
public final class ThresholdBatcher<E> {

  private class ReleaseResourcesFunction<T> implements ApiFunction<T, Void> {
    private final E batch;

    private ReleaseResourcesFunction(E batch) {
      this.batch = batch;
    }

    @Override
    public Void apply(T input) {
      flowController.release(batch);
      return null;
    }
  }

  private final Runnable pushCurrentBatchRunnable =
      new Runnable() {
        @Override
        public void run() {
          pushCurrentBatch();
        }
      };

  private final ArrayList<BatchingThreshold<E>> thresholds;
  private final ScheduledExecutorService executor;
  private final java.time.Duration maxDelay;
  private final ThresholdBatchReceiver<E> receiver;
  private final BatchingFlowController<E> flowController;
  private final BatchMerger<E> batchMerger;

  // Invariant:
  // - lock gates all accesses to members below
  // - currentOpenBatch and currentAlarmFuture are either both null or both non-null
  private final ReentrantLock lock = new ReentrantLock();
  private E currentOpenBatch;
  private Future<?> currentAlarmFuture;

  private ThresholdBatcher(Builder<E> builder) {
    this.thresholds = new ArrayList<>(builder.thresholds);
    this.executor = Preconditions.checkNotNull(builder.executor);
    this.maxDelay = Preconditions.checkNotNull(builder.maxDelay);
    this.receiver = Preconditions.checkNotNull(builder.receiver);
    this.flowController = Preconditions.checkNotNull(builder.flowController);
    this.batchMerger = Preconditions.checkNotNull(builder.batchMerger);

    resetThresholds();
  }

  /** Builder for a ThresholdBatcher. */
  public static class Builder<E> {
    private Collection<BatchingThreshold<E>> thresholds;
    private ScheduledExecutorService executor;
    private java.time.Duration maxDelay;
    private ThresholdBatchReceiver<E> receiver;
    private BatchingFlowController<E> flowController;
    private BatchMerger<E> batchMerger;

    private Builder() {}

    /** Set the executor for the ThresholdBatcher. */
    public Builder<E> setExecutor(ScheduledExecutorService executor) {
      this.executor = executor;
      return this;
    }

    /** Set the max delay for a batch. This is counted from the first item added to a batch. */
    public Builder<E> setMaxDelayDuration(java.time.Duration maxDelay) {
      this.maxDelay = maxDelay;
      return this;
    }

    /** This method is obsolete. Use {@link #setMaxDelayDuration(Duration)} instead */
    @ObsoleteApi("Use setMaxDelayDuration(java.time.Duration) instead")
    public Builder<E> setMaxDelay(org.threeten.bp.Duration maxDelay) {
      return setMaxDelayDuration(toJavaTimeDuration(maxDelay));
    }

    /** Set the thresholds for the ThresholdBatcher. */
    public Builder<E> setThresholds(Collection<BatchingThreshold<E>> thresholds) {
      this.thresholds = thresholds;
      return this;
    }

    /** Set the threshold batch receiver for the ThresholdBatcher. */
    public Builder<E> setReceiver(ThresholdBatchReceiver<E> receiver) {
      this.receiver = receiver;
      return this;
    }

    /** Set the flow controller for the ThresholdBatcher. */
    public Builder<E> setFlowController(BatchingFlowController<E> flowController) {
      this.flowController = flowController;
      return this;
    }

    /** Set the batch merger for the ThresholdBatcher. */
    public Builder<E> setBatchMerger(BatchMerger<E> batchMerger) {
      this.batchMerger = batchMerger;
      return this;
    }

    /** Build the ThresholdBatcher. */
    public ThresholdBatcher<E> build() {
      return new ThresholdBatcher<>(this);
    }
  }

  /** Get a new builder for a ThresholdBatcher. */
  public static <E> Builder<E> newBuilder() {
    return new Builder<>();
  }

  /**
   * Adds an element to the batcher. If the element causes the collection to go past any of the
   * thresholds, the batch will be sent to the {@code ThresholdBatchReceiver}.
   */
  public void add(E e) throws FlowControlException {
    // We need to reserve resources from flowController outside the lock, so that they can be
    // released by pushCurrentBatch().
    flowController.reserve(e);
    lock.lock();
    try {
      receiver.validateBatch(e);
      boolean anyThresholdReached = isAnyThresholdReached(e);

      if (currentOpenBatch == null) {
        currentOpenBatch = e;
        // Schedule a job only when no thresholds have been exceeded, otherwise it will be
        // immediately cancelled
        if (!anyThresholdReached) {
          currentAlarmFuture =
              executor.schedule(
                  pushCurrentBatchRunnable, maxDelay.toMillis(), TimeUnit.MILLISECONDS);
        }
      } else {
        batchMerger.merge(currentOpenBatch, e);
      }

      if (anyThresholdReached) {
        pushCurrentBatch();
      }
    } finally {
      lock.unlock();
    }
  }

  /** * Package-private for use in testing. */
  @VisibleForTesting
  boolean isEmpty() {
    lock.lock();
    try {
      return currentOpenBatch == null;
    } finally {
      lock.unlock();
    }
  }

  /**
   * Push the current batch to the batch receiver. Returns an ApiFuture that completes once the
   * batch has been processed by the batch receiver and the flow controller resources have been
   * released.
   *
   * <p>Note that this future can complete for the current batch before previous batches have
   * completed, so it cannot be depended upon for flushing.
   */
  @VisibleForTesting
  public ApiFuture<Void> pushCurrentBatch() {
    final E batch = removeBatch();
    if (batch == null) {
      return ApiFutures.immediateFuture(null);
    }

    final SettableApiFuture<Void> retFuture = SettableApiFuture.create();

    // It is tempting to use transform to both release and get ApiFuture<Void>.
    // This is incorrect because we also need to release on failure.
    //
    // It is also tempting to transform to get ApiFuture<Void> and addListener
    // separately to release. This probably works as most users expect,
    // but makes this class hard to test: retFuture.get() returning
    // won't guarantee that flow control has been released.
    ApiFutures.addCallback(
        receiver.processBatch(batch),
        new ApiFutureCallback<Object>() {
          @Override
          public void onSuccess(Object obj) {
            flowController.release(batch);
            retFuture.set(null);
          }

          @Override
          public void onFailure(Throwable t) {
            flowController.release(batch);
            retFuture.setException(t);
          }
        },
        directExecutor());

    return retFuture;
  }

  private E removeBatch() {
    lock.lock();
    try {
      E batch = currentOpenBatch;
      currentOpenBatch = null;
      if (currentAlarmFuture != null) {
        currentAlarmFuture.cancel(false);
        currentAlarmFuture = null;
      }
      resetThresholds();
      return batch;
    } finally {
      lock.unlock();
    }
  }

  private boolean isAnyThresholdReached(E e) {
    for (BatchingThreshold<E> threshold : thresholds) {
      threshold.accumulate(e);
      if (threshold.isThresholdReached()) {
        return true;
      }
    }
    return false;
  }

  private void resetThresholds() {
    for (int i = 0; i < thresholds.size(); i++) {
      thresholds.set(i, thresholds.get(i).copyWithZeroedValue());
    }
  }
}
