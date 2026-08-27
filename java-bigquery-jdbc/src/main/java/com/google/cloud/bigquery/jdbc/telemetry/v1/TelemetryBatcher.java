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
  private volatile ConcurrentHashMap<StatementKey, StatementAccumulator> statementsMap =
      new ConcurrentHashMap<>();
  private volatile ConcurrentHashMap<ConnectionKey, ConnectionAccumulator> connectionsMap =
      new ConcurrentHashMap<>();
  private volatile ConcurrentHashMap<ErrorKey, ErrorAccumulator> errorsMap =
      new ConcurrentHashMap<>();
  private volatile ConcurrentHashMap<FeatureKey, FeatureAccumulator> featuresMap =
      new ConcurrentHashMap<>();

  private final AtomicBoolean isClosed = new AtomicBoolean(false);
  private final AtomicLong currentScheduleDelayMs = new AtomicLong(-1);
  private ScheduledFuture<?> scheduledTask;

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

  void offerConnectionAttempt(Status status, int errorCode, AuthenticationType authType) {
    if (isClosed.get() || !isConfigured()) return;
    ConnectionKey key = new ConnectionKey(authType, status, errorCode);
    if (connectionsMap.size() >= MAX_UNIQUE_PROFILES && !connectionsMap.containsKey(key)) return;
    connectionsMap.computeIfAbsent(key, k -> new ConnectionAccumulator(key)).accumulate();
  }

  void offerStatementExecution(
      StatementType type,
      QueryApiType api,
      Status status,
      int errorCode,
      long durationMs,
      int bucketIndex) {
    if (isClosed.get() || !isConfigured()) return;
    StatementKey key = new StatementKey(type, api, status, errorCode);
    if (statementsMap.size() >= MAX_UNIQUE_PROFILES && !statementsMap.containsKey(key)) return;
    statementsMap
        .computeIfAbsent(key, k -> new StatementAccumulator(key))
        .accumulate(durationMs, bucketIndex);
  }

  void offerErrorMetric(int errorCode, int errorXdbcCode, String methodName) {
    if (isClosed.get() || !isConfigured()) return;
    ErrorKey key = new ErrorKey(errorCode, errorXdbcCode, methodName);
    if (errorsMap.size() >= MAX_UNIQUE_PROFILES && !errorsMap.containsKey(key)) return;
    errorsMap.computeIfAbsent(key, k -> new ErrorAccumulator(key)).accumulate();
  }

  void offerFeatureUsage(DriverFeature feature, String customFeatureName) {
    if (isClosed.get() || !isConfigured()) return;
    FeatureKey key = new FeatureKey(feature, customFeatureName);
    if (featuresMap.size() >= MAX_UNIQUE_PROFILES && !featuresMap.containsKey(key)) return;
    featuresMap.computeIfAbsent(key, k -> new FeatureAccumulator(key)).accumulate();
  }

  TransportResult flush() {
    flushLock.lock();
    try {
      if (!isConfigured()) {
        return TransportResult.disabled();
      }

      // Atomic Map Swap: Freeze current counts for flushing and start fresh lock-free maps.
      ConcurrentHashMap<StatementKey, StatementAccumulator> snapStatements = this.statementsMap;
      this.statementsMap = new ConcurrentHashMap<>();
      ConcurrentHashMap<ConnectionKey, ConnectionAccumulator> snapConnections = this.connectionsMap;
      this.connectionsMap = new ConcurrentHashMap<>();
      ConcurrentHashMap<ErrorKey, ErrorAccumulator> snapErrors = this.errorsMap;
      this.errorsMap = new ConcurrentHashMap<>();
      ConcurrentHashMap<FeatureKey, FeatureAccumulator> snapFeatures = this.featuresMap;
      this.featuresMap = new ConcurrentHashMap<>();

      if (snapStatements.isEmpty()
          && snapConnections.isEmpty()
          && snapErrors.isEmpty()
          && snapFeatures.isEmpty()) {
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

      for (StatementAccumulator acc : snapStatements.values()) {
        long totalCount = acc.count.sum();
        long totalSum = acc.durationSum.sum();
        DurationHistogram.Builder durBuilder =
            DurationHistogram.newBuilder().setCount(totalCount).setSum(totalSum);

        for (int i = 0; i < TelemetryManager.HISTOGRAM_BOUNDS.length; i++) {
          durBuilder.addExplicitBounds(TelemetryManager.HISTOGRAM_BOUNDS[i]);
        }
        for (LongAdder bucket : acc.bucketCounts) {
          durBuilder.addBucketCounts(bucket.sum());
        }

        payloadBuilder.addStatementExecutions(
            StatementExecution.newBuilder()
                .setStatementType(acc.key.type)
                .setQueryApiType(acc.key.api)
                .setStatus(acc.key.status)
                .setErrorCode(acc.key.errorCode)
                .setCount(totalCount)
                .setDuration(durBuilder.build())
                .build());
      }

      for (ConnectionAccumulator acc : snapConnections.values()) {
        payloadBuilder.addConnectionAttempts(
            ConnectionAttempt.newBuilder()
                .setAuthType(acc.key.authType)
                .setStatus(acc.key.status)
                .setErrorCode(acc.key.errorCode)
                .setCount(acc.count.sum())
                .build());
      }

      for (ErrorAccumulator acc : snapErrors.values()) {
        payloadBuilder.addErrors(
            ErrorMetric.newBuilder()
                .setErrorCode(acc.key.errorCode)
                .setErrorXdbcCode(String.valueOf(acc.key.errorXdbcCode))
                .setMethodName(acc.key.methodName)
                .setCount(acc.count.sum())
                .build());
      }

      for (FeatureAccumulator acc : snapFeatures.values()) {
        payloadBuilder.addFeatureUsages(
            FeatureUsage.newBuilder()
                .setDriverFeature(acc.key.driverFeature)
                .setCustomFeatureName(
                    acc.key.customFeatureName == null ? "" : acc.key.customFeatureName)
                .setCount(acc.count.sum())
                .build());
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
        remergeFailedStatements(snapStatements);
        remergeFailedConnections(snapConnections);
        remergeFailedErrors(snapErrors);
        remergeFailedFeatures(snapFeatures);
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

  private void remergeFailedStatements(
      ConcurrentHashMap<StatementKey, StatementAccumulator> failed) {
    for (Map.Entry<StatementKey, StatementAccumulator> entry : failed.entrySet()) {
      StatementAccumulator oldAcc = entry.getValue();
      StatementAccumulator newAcc =
          statementsMap.computeIfAbsent(entry.getKey(), k -> new StatementAccumulator(oldAcc.key));
      newAcc.count.add(oldAcc.count.sum());
      newAcc.durationSum.add(oldAcc.durationSum.sum());
      for (int i = 0; i < oldAcc.bucketCounts.length; i++) {
        newAcc.bucketCounts[i].add(oldAcc.bucketCounts[i].sum());
      }
    }
  }

  private void remergeFailedConnections(
      ConcurrentHashMap<ConnectionKey, ConnectionAccumulator> failed) {
    for (Map.Entry<ConnectionKey, ConnectionAccumulator> entry : failed.entrySet()) {
      ConnectionAccumulator oldAcc = entry.getValue();
      connectionsMap
          .computeIfAbsent(entry.getKey(), k -> new ConnectionAccumulator(oldAcc.key))
          .count
          .add(oldAcc.count.sum());
    }
  }

  private void remergeFailedErrors(ConcurrentHashMap<ErrorKey, ErrorAccumulator> failed) {
    for (Map.Entry<ErrorKey, ErrorAccumulator> entry : failed.entrySet()) {
      ErrorAccumulator oldAcc = entry.getValue();
      errorsMap
          .computeIfAbsent(entry.getKey(), k -> new ErrorAccumulator(oldAcc.key))
          .count
          .add(oldAcc.count.sum());
    }
  }

  private void remergeFailedFeatures(ConcurrentHashMap<FeatureKey, FeatureAccumulator> failed) {
    for (Map.Entry<FeatureKey, FeatureAccumulator> entry : failed.entrySet()) {
      FeatureAccumulator oldAcc = entry.getValue();
      featuresMap
          .computeIfAbsent(entry.getKey(), k -> new FeatureAccumulator(oldAcc.key))
          .count
          .add(oldAcc.count.sum());
    }
  }

  private boolean isConfigured() {
    return config != null && config.isEnabled() && transport != null;
  }

  private void reschedule(long delayMs) {
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

  // POJO Keys
  private static final class StatementKey {
    final StatementType type;
    final QueryApiType api;
    final Status status;
    final int errorCode;

    StatementKey(StatementType type, QueryApiType api, Status status, int errorCode) {
      this.type = type;
      this.api = api;
      this.status = status;
      this.errorCode = errorCode;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof StatementKey)) return false;
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
  }

  private static final class ConnectionKey {
    final AuthenticationType authType;
    final Status status;
    final int errorCode;

    ConnectionKey(AuthenticationType authType, Status status, int errorCode) {
      this.authType = authType;
      this.status = status;
      this.errorCode = errorCode;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof ConnectionKey)) return false;
      ConnectionKey that = (ConnectionKey) o;
      return errorCode == that.errorCode && authType == that.authType && status == that.status;
    }

    @Override
    public int hashCode() {
      return Objects.hash(authType, status, errorCode);
    }
  }

  private static final class ErrorKey {
    final int errorCode;
    final int errorXdbcCode;
    final String methodName;

    ErrorKey(int errorCode, int errorXdbcCode, String methodName) {
      this.errorCode = errorCode;
      this.errorXdbcCode = errorXdbcCode;
      this.methodName = methodName;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof ErrorKey)) return false;
      ErrorKey errorKey = (ErrorKey) o;
      return errorCode == errorKey.errorCode
          && errorXdbcCode == errorKey.errorXdbcCode
          && Objects.equals(methodName, errorKey.methodName);
    }

    @Override
    public int hashCode() {
      return Objects.hash(errorCode, errorXdbcCode, methodName);
    }
  }

  private static final class FeatureKey {
    final DriverFeature driverFeature;
    final String customFeatureName;

    FeatureKey(DriverFeature driverFeature, String customFeatureName) {
      this.driverFeature = driverFeature;
      this.customFeatureName = customFeatureName;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof FeatureKey)) return false;
      FeatureKey that = (FeatureKey) o;
      return driverFeature == that.driverFeature
          && Objects.equals(customFeatureName, that.customFeatureName);
    }

    @Override
    public int hashCode() {
      return Objects.hash(driverFeature, customFeatureName);
    }
  }

  // Accumulators
  private static final class StatementAccumulator {
    final StatementKey key;
    final LongAdder count = new LongAdder();
    final LongAdder durationSum = new LongAdder();
    final LongAdder[] bucketCounts = new LongAdder[TelemetryManager.HISTOGRAM_BOUNDS.length + 1];

    StatementAccumulator(StatementKey key) {
      this.key = key;
      for (int i = 0; i < bucketCounts.length; i++) {
        bucketCounts[i] = new LongAdder();
      }
    }

    void accumulate(long durationMs, int bucketIndex) {
      count.increment();
      durationSum.add(durationMs);
      if (bucketIndex >= 0 && bucketIndex < bucketCounts.length) {
        bucketCounts[bucketIndex].increment();
      }
    }
  }

  private static final class ConnectionAccumulator {
    final ConnectionKey key;
    final LongAdder count = new LongAdder();

    ConnectionAccumulator(ConnectionKey key) {
      this.key = key;
    }

    void accumulate() {
      count.increment();
    }
  }

  private static final class ErrorAccumulator {
    final ErrorKey key;
    final LongAdder count = new LongAdder();

    ErrorAccumulator(ErrorKey key) {
      this.key = key;
    }

    void accumulate() {
      count.increment();
    }
  }

  private static final class FeatureAccumulator {
    final FeatureKey key;
    final LongAdder count = new LongAdder();

    FeatureAccumulator(FeatureKey key) {
      this.key = key;
    }

    void accumulate() {
      count.increment();
    }
  }
}
