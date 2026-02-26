/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;
import static com.google.cloud.bigtable.data.v2.stub.metrics.Util.extractStatus;

import com.google.api.core.ObsoleteApi;
import com.google.api.gax.retrying.ServerStreamingAttemptException;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.MethodInfo;
import com.google.cloud.bigtable.data.v2.stub.MetadataExtractorInterceptor;
import com.google.cloud.bigtable.data.v2.stub.MetadataExtractorInterceptor.SidebandData;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Comparators;
import com.google.common.math.IntMath;
import io.grpc.Deadline;
import io.grpc.Status;
import java.time.Duration;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

/**
 * A {@link BigtableTracer} that records built-in metrics and publish under the
 * bigtable.googleapis.com/client namespace
 */
class BuiltinMetricsTracer extends BigtableTracer {
  private static final MethodInfo READ_ROWS =
      MethodInfo.builder().setName("Bigtable.ReadRows").setStreaming(true).build();
  private final MetricRegistry.RecorderRegistry recorder;
  private final ClientInfo clientInfo;
  private final MethodInfo methodInfo;

  // Operation level metrics
  private final AtomicBoolean operationFinishedEarly = new AtomicBoolean();
  private final AtomicBoolean opFinished = new AtomicBoolean();
  private final Stopwatch operationTimer = Stopwatch.createStarted();
  private final Stopwatch firstResponsePerOpTimer = Stopwatch.createStarted();

  // Attempt level metrics
  private int attemptCount = 0;
  private Stopwatch attemptTimer;
  private volatile int attempt = 0;

  // Total server latency needs to be atomic because it's accessed from different threads. E.g.
  // request() from user thread and attempt failed from grpc thread. We're only measuring the extra
  // time application spent blocking grpc buffer, which will be operationLatency - serverLatency.
  private final AtomicLong totalServerLatencyNano = new AtomicLong(0);
  // Stopwatch is not thread safe so this is a workaround to check if the stopwatch changes is
  // flushed to memory.
  private final Stopwatch serverLatencyTimer = Stopwatch.createUnstarted();
  private final Object timerLock = new Object();

  private boolean flowControlIsDisabled = false;

  private final AtomicInteger requestLeft = new AtomicInteger(0);

  private String tableId = "<unspecified>";

  private final AtomicLong totalClientBlockingTime = new AtomicLong(0);

  private final AtomicLong grpcMessageSentDelay = new AtomicLong(0);

  private Deadline operationDeadline = null;
  private volatile Duration remainingDeadlineAtAttemptStart = Duration.ZERO;

  private volatile MetadataExtractorInterceptor.SidebandData sidebandData = new SidebandData();

  BuiltinMetricsTracer(
      MetricRegistry.RecorderRegistry recorder, ClientInfo clientInfo, MethodInfo methodInfo) {

    this.recorder = recorder;
    this.clientInfo = clientInfo;
    this.methodInfo = methodInfo;
  }

  @Override
  public Scope inScope() {
    return new Scope() {
      @Override
      public void close() {}
    };
  }

  @Override
  public void operationFinishEarly() {
    operationFinishedEarly.set(true);
    attemptTimer.stop();
    operationTimer.stop();
  }

  @Override
  public void operationSucceeded() {
    recordOperationCompletion(null);
  }

  @Override
  public void operationCancelled() {
    recordOperationCompletion(new CancellationException());
  }

  @Override
  public void operationFailed(Throwable error) {
    recordOperationCompletion(error);
  }

  @Override
  public void attemptStarted(int attemptNumber) {
    attemptStarted(null, attemptNumber);
  }

  @Override
  public void attemptStarted(Object request, int attemptNumber) {
    this.attempt = attemptNumber;
    attemptCount++;
    attemptTimer = Stopwatch.createStarted();
    if (operationDeadline != null) {
      remainingDeadlineAtAttemptStart =
          Duration.ofMillis(operationDeadline.timeRemaining(TimeUnit.MILLISECONDS));
    }
    if (request != null) {
      this.tableId = Util.extractTableId(request);
    }
    if (!flowControlIsDisabled) {
      synchronized (timerLock) {
        if (!serverLatencyTimer.isRunning()) {
          serverLatencyTimer.start();
        }
      }
    }
  }

  @Override
  public void attemptSucceeded() {
    recordAttemptCompletion(null);
  }

  @Override
  public void attemptCancelled() {
    recordAttemptCompletion(new CancellationException());
  }

  /**
   * This method is obsolete. Use {@link #attemptFailedDuration(Throwable, java.time.Duration)}
   * instead.
   */
  @ObsoleteApi("Use attemptFailedDuration(Throwable, java.time.Duration) instead")
  @Override
  public void attemptFailed(Throwable error, org.threeten.bp.Duration delay) {
    attemptFailedDuration(error, toJavaTimeDuration(delay));
  }

  @Override
  public void attemptFailedDuration(Throwable error, Duration delay) {
    recordAttemptCompletion(error);
  }

  @Override
  public void attemptPermanentFailure(Throwable throwable) {
    recordAttemptCompletion(throwable);
  }

  @Override
  public void onRequest(int requestCount) {
    requestLeft.accumulateAndGet(requestCount, IntMath::saturatedAdd);

    if (operationFinishedEarly.get()) {
      return;
    }

    if (flowControlIsDisabled) {
      // On request is only called when auto flow control is disabled. When auto flow control is
      // disabled, server latency is measured between onRequest and onResponse.
      synchronized (timerLock) {
        if (!serverLatencyTimer.isRunning()) {
          serverLatencyTimer.start();
        }
      }
    }
  }

  @Override
  public void responseReceived() {
    if (operationFinishedEarly.get()) {
      return;
    }

    if (firstResponsePerOpTimer.isRunning()) {
      firstResponsePerOpTimer.stop();
    }
    // When auto flow control is enabled, server latency is measured between afterResponse and
    // responseReceived.
    // When auto flow control is disabled, server latency is measured between onRequest and
    // responseReceived.
    // When auto flow control is disabled and application requested multiple responses, server
    // latency is measured between afterResponse and responseReceived.
    // In all the cases, we want to stop the serverLatencyTimer here.
    synchronized (timerLock) {
      if (serverLatencyTimer.isRunning()) {
        totalServerLatencyNano.addAndGet(serverLatencyTimer.elapsed(TimeUnit.NANOSECONDS));
        serverLatencyTimer.reset();
      }
    }
  }

  @Override
  public void afterResponse(long applicationLatency) {
    if (!flowControlIsDisabled || requestLeft.decrementAndGet() > 0) {
      if (operationFinishedEarly.get()) {
        return;
      }
      // When auto flow control is enabled, request will never be called, so server latency is
      // measured between after the last response is processed and before the next response is
      // received. If flow control is disabled but requestLeft is greater than 0,
      // also start the timer to count the time between afterResponse and responseReceived.
      synchronized (timerLock) {
        if (!serverLatencyTimer.isRunning()) {
          serverLatencyTimer.start();
        }
      }
    }
  }

  @Override
  public int getAttempt() {
    return attempt;
  }

  @Override
  public void setSidebandData(MetadataExtractorInterceptor.SidebandData sidebandData) {
    this.sidebandData = sidebandData;
  }

  @Override
  public void batchRequestThrottled(long throttledTimeNanos) {
    totalClientBlockingTime.addAndGet(java.time.Duration.ofNanos(throttledTimeNanos).toMillis());
  }

  @Override
  public void grpcMessageSent() {
    grpcMessageSentDelay.set(attemptTimer.elapsed(TimeUnit.NANOSECONDS));
  }

  @Override
  public void setTotalTimeoutDuration(java.time.Duration totalTimeoutDuration) {
    // This method is called by BigtableTracerStreamingCallable and
    // BigtableTracerUnaryCallable which is called per attempt. We only set
    // the operationDeadline on the first attempt and when totalTimeout is set.
    if (operationDeadline == null && !totalTimeoutDuration.isZero()) {
      this.operationDeadline =
          Deadline.after(totalTimeoutDuration.toMillis(), TimeUnit.MILLISECONDS);
      this.remainingDeadlineAtAttemptStart = totalTimeoutDuration;
    }
  }

  @Override
  public void disableFlowControl() {
    flowControlIsDisabled = true;
  }

  private void recordOperationCompletion(@Nullable Throwable throwable) {
    if (operationFinishedEarly.get()) {
      throwable = null; // force an ok
    }

    if (!opFinished.compareAndSet(false, true)) {
      return;
    }
    long operationLatencyNano = operationTimer.elapsed(TimeUnit.NANOSECONDS);

    Status.Code code = extractStatus(throwable);

    // Only record when retry count is greater than 0 so the retry
    // graph will be less confusing
    if (attemptCount > 1) {
      recorder.retryCount.record(
          clientInfo,
          tableId,
          methodInfo,
          sidebandData.getResponseParams(),
          code,
          attemptCount - 1);
    }

    recorder.operationLatency.record(
        clientInfo,
        tableId,
        methodInfo,
        sidebandData.getResponseParams(),
        code,
        Duration.ofNanos(operationLatencyNano));

    // serverLatencyTimer should already be stopped in recordAttemptCompletion
    long applicationLatencyNano = operationLatencyNano - totalServerLatencyNano.get();
    recorder.applicationBlockingLatency.record(
        clientInfo,
        tableId,
        methodInfo,
        sidebandData.getResponseParams(),
        Duration.ofNanos(applicationLatencyNano));

    if (methodInfo.equals(READ_ROWS)) {
      recorder.firstResponseLantency.record(
          clientInfo,
          tableId,
          methodInfo,
          sidebandData.getResponseParams(),
          code,
          firstResponsePerOpTimer.elapsed());
    }
  }

  private void recordAttemptCompletion(@Nullable Throwable throwable) {
    if (operationFinishedEarly.get()) {
      throwable = null; // force an ok
    }
    // If the attempt failed, the time spent in retry should be counted in application latency.
    // Stop the stopwatch and decrement requestLeft.
    synchronized (timerLock) {
      if (serverLatencyTimer.isRunning()) {
        requestLeft.decrementAndGet();
        totalServerLatencyNano.addAndGet(serverLatencyTimer.elapsed(TimeUnit.NANOSECONDS));
        serverLatencyTimer.reset();
      }
    }

    // Patch the throwable until it's fixed in gax. When an attempt failed,
    // it'll throw a ServerStreamingAttemptException. Unwrap the exception
    // so it could get processed by extractStatus
    if (throwable instanceof ServerStreamingAttemptException) {
      throwable = throwable.getCause();
    }

    Status.Code code = extractStatus(throwable);

    totalClientBlockingTime.addAndGet(grpcMessageSentDelay.get());
    recorder.clientBlockingLatency.record(
        clientInfo,
        tableId,
        methodInfo,
        sidebandData.getResponseParams(),
        Duration.ofNanos(totalClientBlockingTime.get()));

    recorder.attemptLatency.record(
        clientInfo,
        tableId,
        sidebandData.getResponseParams(),
        methodInfo,
        code,
        attemptTimer.elapsed());

    recorder.attemptLatency2.record(
        clientInfo,
        tableId,
        sidebandData.getPeerInfo(),
        sidebandData.getResponseParams(),
        methodInfo,
        code,
        attemptTimer.elapsed());

    // When operationDeadline is set, it's possible that the deadline is passed by the time we send
    // a new attempt. In this case we'll record 0.
    if (operationDeadline != null) {
      recorder.remainingDeadline.record(
          clientInfo,
          tableId,
          methodInfo,
          sidebandData.getResponseParams(),
          code,
          Comparators.max(remainingDeadlineAtAttemptStart, Duration.ZERO));
    }

    if (sidebandData.getGfeTiming() != null) {
      recorder.serverLatency.record(
          clientInfo,
          tableId,
          methodInfo,
          sidebandData.getResponseParams(),
          code,
          sidebandData.getGfeTiming());
      recorder.connectivityErrorCount.record(
          clientInfo, tableId, methodInfo, sidebandData.getResponseParams(), code, 0);
    } else {
      recorder.connectivityErrorCount.record(
          clientInfo, tableId, methodInfo, sidebandData.getResponseParams(), code, 1);
    }
  }

  private static double convertToMs(long nanoSeconds) {
    double toMs = 1e-6;
    return nanoSeconds * toMs;
  }

  @Override
  public void setBatchWriteFlowControlTargetQps(double targetQps) {
    recorder.batchWriteFlowControlTargetQps.record(clientInfo, methodInfo, targetQps);
  }

  @Override
  public void addBatchWriteFlowControlFactor(
      double factor, @Nullable Throwable throwable, boolean applied) {
    recorder.batchWriteFlowControlFactor.record(
        clientInfo, extractStatus(throwable), applied, methodInfo, factor);
  }
}
