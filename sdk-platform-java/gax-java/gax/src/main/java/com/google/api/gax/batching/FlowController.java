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

import com.google.api.core.InternalApi;
import com.google.api.gax.batching.FlowControlEventStats.FlowControlEvent;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/** Provides flow control capability. */
public class FlowController {
  /** Base exception that signals a flow control state. */
  public abstract static class FlowControlException extends Exception {
    private FlowControlException() {}
  }

  /**
   * Runtime exception that can be used in place of FlowControlException when an unchecked exception
   * is required.
   */
  public static class FlowControlRuntimeException extends RuntimeException {
    private FlowControlRuntimeException(FlowControlException e) {
      super(e);
    }

    public static FlowControlRuntimeException fromFlowControlException(FlowControlException e) {
      return new FlowControlRuntimeException(e);
    }
  }

  /**
   * Exception thrown when client-side flow control is enforced based on the maximum number of
   * outstanding in-memory elements.
   */
  public static final class MaxOutstandingElementCountReachedException
      extends FlowControlException {
    private final long currentMaxElementCount;

    public MaxOutstandingElementCountReachedException(long currentMaxElementCount) {
      this.currentMaxElementCount = currentMaxElementCount;
    }

    public long getCurrentMaxBatchElementCount() {
      return currentMaxElementCount;
    }

    @Override
    public String toString() {
      return String.format(
          "The maximum number of batch elements: %d have been reached.", currentMaxElementCount);
    }
  }

  /**
   * Exception thrown when client-side flow control is enforced based on the maximum number of
   * unacknowledged in-memory bytes.
   */
  public static final class MaxOutstandingRequestBytesReachedException
      extends FlowControlException {
    private final long currentMaxBytes;

    public MaxOutstandingRequestBytesReachedException(long currentMaxBytes) {
      this.currentMaxBytes = currentMaxBytes;
    }

    public long getCurrentMaxBatchBytes() {
      return currentMaxBytes;
    }

    @Override
    public String toString() {
      return String.format(
          "The maximum number of batch bytes: %d have been reached.", currentMaxBytes);
    }
  }

  /**
   * Enumeration of behaviors that FlowController can use in case the flow control limits are
   * exceeded.
   */
  public enum LimitExceededBehavior {
    /**
     * Throws {@link MaxOutstandingElementCountReachedException} or {@link
     * MaxOutstandingRequestBytesReachedException}.
     *
     * <p>This might be appropriate in interactive scenarios. For example, a web server might catch
     * these exceptions and report to the user that the system is overloaded and that the user could
     * try again later. It could also be useful in applications that implement custom rate-limiting
     * logic.
     */
    ThrowException,

    /**
     * Waits until the request can be made without exceeding the limit.
     *
     * <p>This might be appropriate in batch-processing, where latencies of individual requests are
     * not important.
     */
    Block,

    /**
     * Disables flow-control.
     *
     * <p>This is provided mainly for debugging and not recommended for production use. Having too
     * many requests in-flight might cause RPCs to fail due to congested network or the computer to
     * run out of memory due to excessive buffering, etc.
     */
    Ignore,
  }

  @Nullable private final Semaphore64 outstandingElementCount;
  @Nullable private final Semaphore64 outstandingByteCount;
  @Nullable private final Long maxElementCountLimit;
  @Nullable private final Long maxRequestBytesLimit;
  @Nullable private final Long minElementCountLimit;
  @Nullable private final Long minRequestBytesLimit;
  private final LimitExceededBehavior limitExceededBehavior;
  private final Object updateLimitLock;

  // Threshold to record throttling events. If reserve() takes longer than this threshold, it will
  // be recorded as a throttling event.
  private static final long RESERVE_FLOW_CONTROL_THRESHOLD_MS = 1;
  private final FlowControlEventStats flowControlEventStats;

  public FlowController(FlowControlSettings settings) {
    // When the FlowController is initialized with FlowControlSettings, flow control limits can't be
    // adjusted. min, current, max element count and request bytes are initialized with the max
    // values in FlowControlSettings.
    this(convertFlowControlSettings(settings));
  }

  @InternalApi("For google-cloud-java client use only")
  public FlowController(DynamicFlowControlSettings settings) {
    this.limitExceededBehavior = settings.getLimitExceededBehavior();
    this.updateLimitLock = new Object();
    this.flowControlEventStats = new FlowControlEventStats();
    switch (settings.getLimitExceededBehavior()) {
      case ThrowException:
      case Block:
        break;
      case Ignore:
        this.maxElementCountLimit = null;
        this.maxRequestBytesLimit = null;
        this.minElementCountLimit = null;
        this.minRequestBytesLimit = null;

        this.outstandingElementCount = null;
        this.outstandingByteCount = null;
        return;
      default:
        throw new IllegalArgumentException(
            "Unknown LimitBehaviour: " + settings.getLimitExceededBehavior());
    }
    this.maxElementCountLimit = settings.getMaxOutstandingElementCount();
    this.minElementCountLimit = settings.getMinOutstandingElementCount();
    Long initialElementCountLimit = settings.getInitialOutstandingElementCount();
    if (initialElementCountLimit == null) {
      outstandingElementCount = null;
    } else if (settings.getLimitExceededBehavior() == FlowController.LimitExceededBehavior.Block) {
      outstandingElementCount = new BlockingSemaphore(initialElementCountLimit);
    } else {
      outstandingElementCount = new NonBlockingSemaphore(initialElementCountLimit);
    }

    this.maxRequestBytesLimit = settings.getMaxOutstandingRequestBytes();
    this.minRequestBytesLimit = settings.getMinOutstandingRequestBytes();
    Long initialRequestBytesLimit = settings.getInitialOutstandingRequestBytes();
    if (initialRequestBytesLimit == null) {
      outstandingByteCount = null;
    } else if (settings.getLimitExceededBehavior() == FlowController.LimitExceededBehavior.Block) {
      outstandingByteCount = new BlockingSemaphore(initialRequestBytesLimit);
    } else {
      outstandingByteCount = new NonBlockingSemaphore(initialRequestBytesLimit);
    }
  }

  public void reserve(long elements, long bytes) throws FlowControlException {
    Preconditions.checkArgument(elements >= 0);
    Preconditions.checkArgument(bytes >= 0);

    Stopwatch stopwatch = Stopwatch.createStarted();
    if (outstandingElementCount != null) {
      if (!outstandingElementCount.acquire(elements)) {
        MaxOutstandingElementCountReachedException exception =
            new MaxOutstandingElementCountReachedException(
                outstandingElementCount.getPermitLimit());
        flowControlEventStats.recordFlowControlEvent(
            FlowControlEvent.createReserveDenied(exception));
        throw exception;
      }
    }

    // Always allows to send a request even if it is larger than the flow control limit,
    // if it doesn't then it will deadlock the thread.
    if (outstandingByteCount != null) {
      if (!outstandingByteCount.acquirePartial(bytes)) {
        if (outstandingElementCount != null) {
          outstandingElementCount.release(elements);
        }
        MaxOutstandingRequestBytesReachedException exception =
            new MaxOutstandingRequestBytesReachedException(outstandingByteCount.getPermitLimit());
        flowControlEventStats.recordFlowControlEvent(
            FlowControlEvent.createReserveDenied(exception));
        throw exception;
      }
    }
    long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
    if (elapsed >= RESERVE_FLOW_CONTROL_THRESHOLD_MS) {
      flowControlEventStats.recordFlowControlEvent(FlowControlEvent.createReserveDelayed(elapsed));
    }
  }

  public void release(long elements, long bytes) {
    Preconditions.checkArgument(elements >= 0);
    Preconditions.checkArgument(bytes >= 0);

    if (outstandingElementCount != null) {
      outstandingElementCount.release(elements);
    }
    if (outstandingByteCount != null) {
      outstandingByteCount.release(bytes);
    }
  }

  /**
   * Increase flow control limits to allow extra elementSteps elements and byteSteps request bytes
   * before enforcing flow control.
   */
  @InternalApi("For google-cloud-java client use only")
  public void increaseThresholds(long elementSteps, long byteSteps) {
    Preconditions.checkArgument(elementSteps >= 0);
    Preconditions.checkArgument(byteSteps >= 0);
    synchronized (updateLimitLock) {
      if (outstandingElementCount != null) {
        long actualStep =
            Math.min(elementSteps, maxElementCountLimit - outstandingElementCount.getPermitLimit());
        outstandingElementCount.increasePermitLimit(actualStep);
      }

      if (outstandingByteCount != null) {
        long actualStep =
            Math.min(byteSteps, maxRequestBytesLimit - outstandingByteCount.getPermitLimit());
        outstandingByteCount.increasePermitLimit(actualStep);
      }
    }
  }

  /**
   * Decrease flow control limits to allow elementSteps fewer elements and byteSteps fewer request
   * bytes before enforcing flow control.
   */
  @InternalApi("For google-cloud-java client use only")
  public void decreaseThresholds(long elementSteps, long byteSteps) {
    Preconditions.checkArgument(elementSteps >= 0);
    Preconditions.checkArgument(byteSteps >= 0);
    synchronized (updateLimitLock) {
      if (outstandingElementCount != null) {
        long actualStep =
            Math.min(elementSteps, outstandingElementCount.getPermitLimit() - minElementCountLimit);
        outstandingElementCount.reducePermitLimit(actualStep);
      }

      if (outstandingByteCount != null) {
        long actualStep =
            Math.min(byteSteps, outstandingByteCount.getPermitLimit() - minRequestBytesLimit);
        outstandingByteCount.reducePermitLimit(actualStep);
      }
    }
  }

  private static DynamicFlowControlSettings convertFlowControlSettings(
      FlowControlSettings settings) {
    return DynamicFlowControlSettings.newBuilder()
        .setInitialOutstandingElementCount(settings.getMaxOutstandingElementCount())
        .setMinOutstandingElementCount(settings.getMaxOutstandingElementCount())
        .setMaxOutstandingElementCount(settings.getMaxOutstandingElementCount())
        .setInitialOutstandingRequestBytes(settings.getMaxOutstandingRequestBytes())
        .setMinOutstandingRequestBytes(settings.getMaxOutstandingRequestBytes())
        .setMaxOutstandingRequestBytes(settings.getMaxOutstandingRequestBytes())
        .setLimitExceededBehavior(settings.getLimitExceededBehavior())
        .build();
  }

  LimitExceededBehavior getLimitExceededBehavior() {
    return limitExceededBehavior;
  }

  @InternalApi("For internal use by google-cloud-java clients only")
  @Nullable
  public Long getMaxElementCountLimit() {
    return maxElementCountLimit;
  }

  @InternalApi("For internal use by google-cloud-java clients only")
  @Nullable
  public Long getMaxRequestBytesLimit() {
    return maxRequestBytesLimit;
  }

  @InternalApi("For google-cloud-java client use only")
  @Nullable
  public Long getMinElementCountLimit() {
    return minElementCountLimit;
  }

  @InternalApi("For google-cloud-java client use only")
  @Nullable
  public Long getMinRequestBytesLimit() {
    return minRequestBytesLimit;
  }

  @InternalApi("For google-cloud-java client use only")
  @Nullable
  public Long getCurrentElementCountLimit() {
    return outstandingElementCount == null ? null : outstandingElementCount.getPermitLimit();
  }

  @InternalApi("For google-cloud-java client use only")
  @Nullable
  public Long getCurrentRequestBytesLimit() {
    return outstandingByteCount == null ? null : outstandingByteCount.getPermitLimit();
  }

  @InternalApi("For google-cloud-java client use only")
  public FlowControlEventStats getFlowControlEventStats() {
    return flowControlEventStats;
  }
}
