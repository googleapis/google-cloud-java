/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.cloud.bigtable.data.v2.stub.metrics.Util.extractStatus;

import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.ResourceExhaustedException;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.UnavailableException;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.RateLimitInfo;
import com.google.cloud.bigtable.data.v2.stub.metrics.BigtableTracer;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class RateLimitingServerStreamingCallable
    extends ServerStreamingCallable<MutateRowsRequest, MutateRowsResponse> {

  private static final Logger logger =
      Logger.getLogger(RateLimitingServerStreamingCallable.class.getName());

  // When the mutation size is large, starting with a higher QPS will make
  // the dataflow job fail very quickly. Start with lower QPS and increase
  // the QPS gradually if the server doesn't push back
  private static final long DEFAULT_QPS = 10;

  // Default interval before changing the QPS on error responses
  private static final Duration DEFAULT_PERIOD = Duration.ofSeconds(10);

  // Minimum QPS to make sure the job is not stuck
  private static final double MIN_QPS = 0.1;
  private static final double MAX_QPS = 100_000;

  // QPS can be lowered to at most MIN_FACTOR * currentQps. When server returned
  // an error, use MIN_FACTOR to calculate the new QPS. This is the same as
  // the server side cap.
  @VisibleForTesting static final double MIN_FACTOR = 0.7;

  // QPS can be increased to at most MAX_FACTOR * currentQps. This is the same
  // as the server side cap
  private static final double MAX_FACTOR = 1.3;

  private final ConditionalRateLimiter limiter;

  private final ServerStreamingCallable<MutateRowsRequest, MutateRowsResponse> innerCallable;

  private BigtableTracer bigtableTracer;

  RateLimitingServerStreamingCallable(
      @Nonnull ServerStreamingCallable<MutateRowsRequest, MutateRowsResponse> innerCallable) {
    this.limiter = new ConditionalRateLimiter(DEFAULT_QPS);
    this.innerCallable = Preconditions.checkNotNull(innerCallable, "Inner callable must be set");
  }

  @Override
  public void call(
      MutateRowsRequest request,
      ResponseObserver<MutateRowsResponse> responseObserver,
      ApiCallContext context) {
    Stopwatch stopwatch = Stopwatch.createStarted();
    limiter.acquire();
    stopwatch.stop();
    if (context.getTracer() instanceof BigtableTracer) {
      bigtableTracer = (BigtableTracer) context.getTracer();
      bigtableTracer.batchRequestThrottled(stopwatch.elapsed(TimeUnit.NANOSECONDS));
    }
    RateLimitingResponseObserver innerObserver = new RateLimitingResponseObserver(responseObserver);
    innerCallable.call(request, innerObserver, context);
  }

  /** A rate limiter wrapper class that can be disabled. */
  static class ConditionalRateLimiter {

    private final AtomicBoolean enabled = new AtomicBoolean(false);

    private final RateLimiter limiter;

    // This is the next time allowed to change QPS or disable rate limiting.
    private final AtomicReference<Instant> nextRateUpdateTime =
        new AtomicReference<>(Instant.now());

    public ConditionalRateLimiter(long defaultQps) {
      limiter = RateLimiter.create(defaultQps);
      logger.info(
          "Batch write flow control: rate limiter is initiated (but disabled) with rate of "
              + defaultQps
              + " QPS.");
    }

    /**
     * Works the same way with {@link RateLimiter#acquire()} except that when the rate limiter is
     * disabled, {@link ConditionalRateLimiter#acquire()} always returns immediately.
     */
    public void acquire() {
      if (enabled.get()) {
        limiter.acquire();
      }
    }

    /**
     * Disables the rate limier if the current time exceeded the next rate update time. When
     * disabled, the rate is retained and will be re-used if re-enabled later.
     */
    public void tryDisable() {
      // Only disable after the rate update time.
      Instant nextTime = nextRateUpdateTime.get();
      Instant now = Instant.now();
      if (now.isAfter(nextTime)) {
        boolean wasEnabled = this.enabled.getAndSet(false);
        if (wasEnabled) {
          logger.info("Batch write flow control: rate limiter is disabled.");
        }
        // No need to update nextRateUpdateTime, any new RateLimitInfo can enable rate limiting and
        // update the rate again.
      }
    }

    /** Enables the rate limiter immediately. */
    public void enable() {
      boolean wasEnabled = this.enabled.getAndSet(true);
      if (!wasEnabled) {
        logger.info("Batch write flow control: rate limiter is enabled.");
      }
    }

    public boolean isEnabled() {
      return this.enabled.get();
    }

    public double getRate() {
      return limiter.getRate();
    }

    /**
     * Sets the rate and the next rate update time based on period, if the current time exceeds the
     * next rate update time. Otherwise, no-op.
     *
     * @param rate The new rate of the rate limiter.
     * @param period The period during which rate should not be updated again and the rate limiter
     *     should not be disabled.
     * @param bigtableTracer The tracer for exporting client-side metrics.
     * @param factor The capped factor that we're trying to apply.
     * @param status The status of the response from which the factor is retrieved or derived.
     */
    public void trySetRate(
        double rate,
        Duration period,
        @Nullable BigtableTracer bigtableTracer,
        double factor,
        @Nullable Throwable status) {
      Instant nextTime = nextRateUpdateTime.get();
      Instant now = Instant.now();

      if (now.isBefore(nextTime)) {
        if (bigtableTracer != null) {
          bigtableTracer.addBatchWriteFlowControlFactor(factor, status, false);
        }
        return;
      }

      Instant newNextTime = now.plusSeconds(period.getSeconds());

      if (!nextRateUpdateTime.compareAndSet(nextTime, newNextTime)) {
        // Someone else updated it already.
        if (bigtableTracer != null) {
          bigtableTracer.addBatchWriteFlowControlFactor(factor, status, false);
        }
        return;
      }
      final double oldRate = limiter.getRate();
      limiter.setRate(rate);
      logger.info(
          "Batch write flow control: updated max rate from "
              + oldRate
              + " to "
              + rate
              + " applied factor "
              + factor
              + " with period "
              + period.getSeconds()
              + " seconds. Status="
              + extractStatus(status));
      if (bigtableTracer != null) {
        bigtableTracer.setBatchWriteFlowControlTargetQps(rate);
        bigtableTracer.addBatchWriteFlowControlFactor(factor, status, true);
      }
    }

    @VisibleForTesting
    void setEnabled(boolean enabled) {
      this.enabled.set(enabled);
    }

    @VisibleForTesting
    void setRate(double rate) {
      limiter.setRate(rate);
    }
  }

  class RateLimitingResponseObserver extends SafeResponseObserver<MutateRowsResponse> {

    private final ResponseObserver<MutateRowsResponse> outerObserver;

    RateLimitingResponseObserver(ResponseObserver<MutateRowsResponse> observer) {
      super(observer);
      this.outerObserver = observer;
    }

    @Override
    protected void onStartImpl(StreamController controller) {
      outerObserver.onStart(controller);
    }

    private boolean hasValidRateLimitInfo(MutateRowsResponse response) {
      // RateLimitInfo is an optional field. However, proto3 sub-message field always
      // have presence even thought it's marked as "optional". Check the factor and
      // period to make sure they're not 0.
      if (!response.hasRateLimitInfo()) {
        logger.finest("Batch write flow control: response carries no RateLimitInfo");
        return false;
      }

      if (response.getRateLimitInfo().getFactor() <= 0
          || response.getRateLimitInfo().getPeriod().getSeconds() <= 0) {
        logger.finest(
            "Batch write flow control: response carries invalid RateLimitInfo="
                + response.getRateLimitInfo());
        return false;
      }

      logger.finest(
          "Batch write flow control: response carries valid RateLimitInfo="
              + response.getRateLimitInfo());
      return true;
    }

    @Override
    protected void onResponseImpl(MutateRowsResponse response) {
      if (hasValidRateLimitInfo(response)) {
        limiter.enable();
        RateLimitInfo info = response.getRateLimitInfo();
        updateQps(
            info.getFactor(),
            Duration.ofSeconds(com.google.protobuf.util.Durations.toSeconds(info.getPeriod())),
            null);
      } else {
        limiter.tryDisable();
      }
      outerObserver.onResponse(response);
    }

    @Override
    protected void onErrorImpl(Throwable t) {
      // When server returns DEADLINE_EXCEEDED, UNAVAILABLE or RESOURCE_EXHAUSTED,
      // assume cbt server is overloaded
      if (t instanceof DeadlineExceededException
          || t instanceof UnavailableException
          || t instanceof ResourceExhaustedException) {
        updateQps(MIN_FACTOR, DEFAULT_PERIOD, t);
      }
      outerObserver.onError(t);
    }

    @Override
    protected void onCompleteImpl() {
      outerObserver.onComplete();
    }

    private void updateQps(double factor, Duration period, @Nullable Throwable status) {
      double cappedFactor = Math.min(Math.max(factor, MIN_FACTOR), MAX_FACTOR);
      double currentRate = limiter.getRate();
      double cappedRate = Math.min(Math.max(currentRate * cappedFactor, MIN_QPS), MAX_QPS);
      limiter.trySetRate(cappedRate, period, bigtableTracer, cappedFactor, status);
    }
  }

  @VisibleForTesting
  AtomicReference<Instant> getNextRateUpdateTime() {
    return limiter.nextRateUpdateTime;
  }

  @VisibleForTesting
  double getCurrentRate() {
    return limiter.getRate();
  }

  @VisibleForTesting
  void setRate(double rate) {
    limiter.setRate(rate);
  }

  @VisibleForTesting
  boolean getLimiterEnabled() {
    return limiter.isEnabled();
  }

  @VisibleForTesting
  void setLimiterEnabled(boolean enabled) {
    limiter.setEnabled(enabled);
  }
}
