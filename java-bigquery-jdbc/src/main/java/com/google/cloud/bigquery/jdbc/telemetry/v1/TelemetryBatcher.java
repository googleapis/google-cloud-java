/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.telemetry.v1;

import com.google.cloud.bigquery.jdbc.BigQueryJdbcCustomLogger;
import com.google.protobuf.Message;
import com.google.protobuf.Timestamp;
import java.time.Instant;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/** High-performance, non-blocking telemetry event batcher and periodic dispatcher. */
final class TelemetryBatcher implements AutoCloseable {
  private static final Logger logger =
      new BigQueryJdbcCustomLogger(TelemetryBatcher.class.getName());
  private static final int MAX_UNIQUE_PROFILES = 3000;

  private final TelemetryConfiguration config;
  private final ClearcutTransport transport;
  private final DriverEnvironment driverEnvironment;
  private final ScheduledExecutorService executorService;
  private final boolean ownsExecutor;
  private final ReentrantLock flushLock = new ReentrantLock();

  // Live telemetry accumulators. Lock-free to eliminate object allocation and GC overhead.
  private ConcurrentHashMap<TelemetryKey, TelemetryAccumulator> metricsMap =
      new ConcurrentHashMap<>();

  private final AtomicBoolean isClosed = new AtomicBoolean(false);
  private final AtomicLong currentScheduleDelayMs = new AtomicLong(-1);
  private ScheduledFuture<?> scheduledTask;

  // Constructors & Lifecycle
  TelemetryBatcher(TelemetryConfiguration config, ClearcutTransport transport) {
    this(
        config,
        transport,
        (config != null && config.isEnabled()) ? createDefaultExecutor() : null,
        config != null && config.isEnabled());
  }

  TelemetryBatcher(
      TelemetryConfiguration config,
      ClearcutTransport transport,
      ScheduledExecutorService executorService,
      boolean ownsExecutor) {
    this.config = config;
    this.transport = transport;
    this.driverEnvironment = config != null ? config.getDriverEnvironment() : null;
    this.executorService = executorService;
    this.ownsExecutor = ownsExecutor;

    if (this.config != null && this.config.isEnabled()) {
      reschedule(this.config.getUploadIntervalMs());
    }
  }

  private static ScheduledExecutorService createDefaultExecutor() {
    return Executors.newSingleThreadScheduledExecutor(
        r -> {
          Thread t = new Thread(r, "jdbc-telemetry-batcher");
          t.setDaemon(true);
          return t;
        });
  }

  TelemetryConfiguration getConfig() {
    return config;
  }

  private boolean isConfigured() {
    return config != null && config.isEnabled() && transport != null;
  }

<<<<<<< HEAD
=======
  private void reschedule(long delayMs) {
    if (isClosed.get()) {
      return;
    }
    long current = currentScheduleDelayMs.get();
    if (current == delayMs && scheduledTask != null && !scheduledTask.isDone()) {
      return;
    }
    if (scheduledTask != null) {
      scheduledTask.cancel(false);
    }
    if (executorService != null && !executorService.isShutdown()) {
      currentScheduleDelayMs.set(delayMs);
      scheduledTask = executorService.schedule(this::flush, delayMs, TimeUnit.MILLISECONDS);
    }
  }

>>>>>>> 2dcb587f6ba (isclosed check)
  @Override
  public void close() {
    if (isClosed.compareAndSet(false, true)) {
      if (scheduledTask != null) {
        scheduledTask.cancel(false);
      }
      flush();
      if (ownsExecutor && executorService != null) {
        executorService.shutdown();
        try {
          if (!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
          }
        } catch (InterruptedException e) {
          executorService.shutdownNow();
          Thread.currentThread().interrupt();
        }
      }
    }
  }

  // Ingestion Methods
  void offer(Message metric) {
    offer(metric, 0);
  }

  void offer(Message metric, long durationMs) {
    if (isClosed.get() || !isConfigured()) {
      return;
    }
    TelemetryKey key = TelemetryKey.from(metric);
    TelemetryAccumulator acc = getOrAddAccumulator(key);
    if (acc != null) {
      acc.accumulate(durationMs);
    }
  }

  private <A extends TelemetryAccumulator> A getOrAddAccumulator(TelemetryKey key) {
    if (isClosed.get() || !isConfigured()) {
      return null;
    }
    if (metricsMap.size() >= MAX_UNIQUE_PROFILES && !metricsMap.containsKey(key)) {
      return null;
    }
    return (A) metricsMap.computeIfAbsent(key, TelemetryKey::createAccumulator);
  }

  // Dispatch & Flushing Methods
  TransportResult flush() {
    flushLock.lock();
    try {
      if (!isConfigured()) {
        return TransportResult.disabled();
      }

      // Atomic Map Swap: Freeze current counts for flushing and start fresh lock-free maps.
      ConcurrentHashMap<TelemetryKey, TelemetryAccumulator> snapMetrics = this.metricsMap;
      this.metricsMap = new ConcurrentHashMap<>();

      if (snapMetrics.isEmpty()) {
        return TransportResult.disabled();
      }

      Instant now = Instant.now();
      Timestamp timestamp =
          Timestamp.newBuilder().setSeconds(now.getEpochSecond()).setNanos(now.getNano()).build();
      TelemetryPayload.Builder payloadBuilder =
          TelemetryPayload.newBuilder().setEventTime(timestamp);

      if (driverEnvironment != null) {
        payloadBuilder.setDriverEnvironment(driverEnvironment);
      }

      for (TelemetryAccumulator accumulator : snapMetrics.values()) {
        accumulator.addToPayload(payloadBuilder);
      }

      TransportResult result;
      try {
        result = transport.send(payloadBuilder.build());
      } catch (Throwable t) {
        logger.log(Level.WARNING, "Unexpected exception during telemetry flush", t);
        result = new TransportResult(false, -1);
      }

      if (!result.isSuccess()) {
        // Simple requeue logic for failed requests
        remergeFailedMetrics(snapMetrics);
      }

      long uploadIntervalMs = config != null ? config.getUploadIntervalMs() : 300_000L;
      long newDelayMs =
          result.getNextRequestWaitMillis() > 0
              ? Math.max(uploadIntervalMs, result.getNextRequestWaitMillis())
              : uploadIntervalMs;
      reschedule(newDelayMs);

      return result;
    } finally {
      flushLock.unlock();
    }
  }

  private void remergeFailedMetrics(Map<TelemetryKey, TelemetryAccumulator> snapshot) {
    for (Map.Entry<TelemetryKey, TelemetryAccumulator> entry : snapshot.entrySet()) {
      metricsMap.compute(
          entry.getKey(),
          (k, v) -> {
            if (v == null) {
              return entry.getValue();
            }
            v.merge(entry.getValue());
            return v;
          });
    }
  }

  private void reschedule(long delayMs) {
    if (isClosed.get()) {
      return;
    }
    long current = currentScheduleDelayMs.get();
    if (current == delayMs && scheduledTask != null && !scheduledTask.isDone()) {
      return;
    }
    if (scheduledTask != null) {
      scheduledTask.cancel(false);
    }
    if (executorService != null && !executorService.isShutdown()) {
      currentScheduleDelayMs.set(delayMs);
      scheduledTask = executorService.schedule(this::flush, delayMs, TimeUnit.MILLISECONDS);
    }
  }

  // Telemetry Interfaces
  interface TelemetryKey {
    TelemetryAccumulator createAccumulator();

    static TelemetryKey from(Message message) {
      if (message instanceof StatementExecution) {
        return new StatementKey((StatementExecution) message);
      } else if (message instanceof ConnectionAttempt) {
        return new ConnectionKey((ConnectionAttempt) message);
      } else if (message instanceof ErrorMetric) {
        return new ErrorKey((ErrorMetric) message);
      } else if (message instanceof FeatureUsage) {
        return new FeatureKey((FeatureUsage) message);
      }
      throw new IllegalArgumentException("Unsupported metric type: " + message.getClass());
    }
  }

  interface TelemetryAccumulator {
    void accumulate(long value);

    void merge(TelemetryAccumulator other);

    void addToPayload(TelemetryPayload.Builder payloadBuilder);
  }

  // Telemetry Keys
  static final class StatementKey implements TelemetryKey {
    final StatementType type;
    final QueryApiType api;
    final Status status;
    final int errorCode;

    StatementKey(StatementExecution statementExecution) {
      this.type = statementExecution.getStatementType();
      this.api = statementExecution.getQueryApiType();
      this.status = statementExecution.getStatus();
      this.errorCode = statementExecution.getErrorCode();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof StatementKey)) {
        return false;
      }
      StatementKey that = (StatementKey) o;
      return errorCode == that.errorCode
          && type == that.type
          && api == that.api
          && status == that.status;
    }

    @Override
    public int hashCode() {
      return Objects.hash(type, api, status, errorCode);
    }

    @Override
    public TelemetryAccumulator createAccumulator() {
      return new StatementAccumulator(this);
    }

    StatementExecution.Builder toBuilder() {
      return StatementExecution.newBuilder()
          .setStatementType(type)
          .setQueryApiType(api)
          .setStatus(status)
          .setErrorCode(errorCode);
    }
  }

  static final class ConnectionKey implements TelemetryKey {
    final AuthenticationType authType;
    final Status status;
    final int errorCode;

    ConnectionKey(ConnectionAttempt connectionAttempt) {
      this.authType = connectionAttempt.getAuthType();
      this.status = connectionAttempt.getStatus();
      this.errorCode = connectionAttempt.getErrorCode();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof ConnectionKey)) {
        return false;
      }
      ConnectionKey that = (ConnectionKey) o;
      return errorCode == that.errorCode && authType == that.authType && status == that.status;
    }

    @Override
    public int hashCode() {
      return Objects.hash(authType, status, errorCode);
    }

    @Override
    public TelemetryAccumulator createAccumulator() {
      return new ConnectionAccumulator(this);
    }

    ConnectionAttempt.Builder toBuilder() {
      return ConnectionAttempt.newBuilder()
          .setAuthType(authType)
          .setStatus(status)
          .setErrorCode(errorCode);
    }
  }

  static final class ErrorKey implements TelemetryKey {
    final int errorCode;
    final int errorXdbcCode;
    final String methodName;

    ErrorKey(ErrorMetric errorMetric) {
      this.errorCode = errorMetric.getErrorCode();
      this.errorXdbcCode = errorMetric.getErrorXdbcCode();
      this.methodName = errorMetric.getMethodName();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof ErrorKey)) {
        return false;
      }
      ErrorKey errorKey = (ErrorKey) o;
      return errorCode == errorKey.errorCode
          && errorXdbcCode == errorKey.errorXdbcCode
          && Objects.equals(methodName, errorKey.methodName);
    }

    @Override
    public int hashCode() {
      return Objects.hash(errorCode, errorXdbcCode, methodName);
    }

    @Override
    public TelemetryAccumulator createAccumulator() {
      return new ErrorAccumulator(this);
    }

    ErrorMetric.Builder toBuilder() {
      return ErrorMetric.newBuilder()
          .setErrorCode(errorCode)
          .setErrorXdbcCode(errorXdbcCode)
          .setMethodName(methodName);
    }
  }

  static final class FeatureKey implements TelemetryKey {
    final DriverFeature driverFeature;
    final String customFeatureName;

    FeatureKey(FeatureUsage featureUsage) {
      this.driverFeature = featureUsage.getDriverFeature();
      this.customFeatureName = featureUsage.getCustomFeatureName();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof FeatureKey)) {
        return false;
      }
      FeatureKey that = (FeatureKey) o;
      return driverFeature == that.driverFeature
          && Objects.equals(customFeatureName, that.customFeatureName);
    }

    @Override
    public int hashCode() {
      return Objects.hash(driverFeature, customFeatureName);
    }

    @Override
    public TelemetryAccumulator createAccumulator() {
      return new FeatureAccumulator(this);
    }

    FeatureUsage.Builder toBuilder() {
      return FeatureUsage.newBuilder()
          .setDriverFeature(driverFeature)
          .setCustomFeatureName(customFeatureName == null ? "" : customFeatureName);
    }
  }

  // Telemetry Accumulators
  abstract static class CountAccumulator implements TelemetryAccumulator {
    protected final LongAdder count = new LongAdder();

    @Override
    public void accumulate(long unused) {
      count.increment();
    }

    @Override
    public void merge(TelemetryAccumulator other) {
      this.count.add(((CountAccumulator) other).count.sum());
    }
  }

  static final class StatementAccumulator implements TelemetryAccumulator {
    private static final double[] HISTOGRAM_BOUNDS = {
      10.0, 50.0, 100.0, 250.0, 500.0, 1000.0, 5000.0, 10000.0
    };

    private final StatementKey key;
    private final LongAdder count = new LongAdder();
    private final LongAdder durationSum = new LongAdder();
    private final LongAdder[] bucketCounts = new LongAdder[HISTOGRAM_BOUNDS.length + 1];

    StatementAccumulator(StatementKey key) {
      this.key = key;
      for (int i = 0; i < bucketCounts.length; i++) {
        bucketCounts[i] = new LongAdder();
      }
    }

    @Override
    public void accumulate(long durationMs) {
      count.increment();
      durationSum.add(durationMs);
      int bucket = calculateBucket(durationMs);
      bucketCounts[bucket].increment();
    }

    private static int calculateBucket(long durationMs) {
      for (int i = 0; i < HISTOGRAM_BOUNDS.length; i++) {
        if (durationMs < HISTOGRAM_BOUNDS[i]) {
          return i;
        }
      }
      return HISTOGRAM_BOUNDS.length;
    }

    @Override
    public void merge(TelemetryAccumulator other) {
      StatementAccumulator o = (StatementAccumulator) other;
      count.add(o.count.sum());
      durationSum.add(o.durationSum.sum());
      for (int i = 0; i < bucketCounts.length; i++) {
        bucketCounts[i].add(o.bucketCounts[i].sum());
      }
    }

    @Override
    public void addToPayload(TelemetryPayload.Builder payloadBuilder) {
      long totalCount = count.sum();
      DurationHistogram.Builder durBuilder =
          DurationHistogram.newBuilder().setCount(totalCount).setSum(durationSum.sum());

      for (double bound : HISTOGRAM_BOUNDS) {
        durBuilder.addExplicitBounds(bound);
      }
      for (LongAdder bucket : bucketCounts) {
        durBuilder.addBucketCounts(bucket.sum());
      }

      payloadBuilder.addStatementExecutions(
          key.toBuilder().setCount(totalCount).setDuration(durBuilder).build());
    }
  }

  static final class ConnectionAccumulator extends CountAccumulator {
    final ConnectionKey key;

    ConnectionAccumulator(ConnectionKey key) {
      this.key = key;
    }

    @Override
    public void addToPayload(TelemetryPayload.Builder payloadBuilder) {
      payloadBuilder.addConnectionAttempts(key.toBuilder().setCount(count.sum()).build());
    }
  }

  static final class ErrorAccumulator extends CountAccumulator {
    final ErrorKey key;

    ErrorAccumulator(ErrorKey key) {
      this.key = key;
    }

    @Override
    public void addToPayload(TelemetryPayload.Builder payloadBuilder) {
      payloadBuilder.addErrors(key.toBuilder().setCount(count.sum()).build());
    }
  }

  static final class FeatureAccumulator extends CountAccumulator {
    final FeatureKey key;

    FeatureAccumulator(FeatureKey key) {
      this.key = key;
    }

    @Override
    public void addToPayload(TelemetryPayload.Builder payloadBuilder) {
      payloadBuilder.addFeatureUsages(key.toBuilder().setCount(count.sum()).build());
    }
  }
}
