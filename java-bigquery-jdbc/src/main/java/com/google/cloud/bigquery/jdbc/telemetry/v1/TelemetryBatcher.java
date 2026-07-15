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
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * High-performance, non-blocking telemetry event batcher and periodic dispatcher. Buffers
 * connection, statement, error, and feature usage telemetry events in memory and flushes them to
 * Clearcut via {@link ClearcutTransport}.
 */
final class TelemetryBatcher implements AutoCloseable {
  private static final Logger logger =
      new BigQueryJdbcCustomLogger(TelemetryBatcher.class.getName());
  private static final int MAX_QUEUE_SIZE = 10_000;
  private static final int MAX_PAYLOAD_BYTES = 512 * 1024; // 512 KB payload size limit

  private final TelemetryConfiguration config;
  private final ClearcutTransport transport;
  private final DriverEnvironment driverEnvironment;
  private final ScheduledExecutorService executorService;
  private final boolean ownsExecutor;
  private final ReentrantLock flushLock = new ReentrantLock();

  private final LinkedBlockingQueue<ConnectionAttempt> connectionAttemptQueue =
      new LinkedBlockingQueue<>(MAX_QUEUE_SIZE);
  private final LinkedBlockingQueue<StatementExecution> statementExecutionQueue =
      new LinkedBlockingQueue<>(MAX_QUEUE_SIZE);
  private final LinkedBlockingQueue<ErrorMetric> errorMetricQueue =
      new LinkedBlockingQueue<>(MAX_QUEUE_SIZE);
  private final LinkedBlockingQueue<FeatureUsage> featureUsageQueue =
      new LinkedBlockingQueue<>(MAX_QUEUE_SIZE);

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

  private static ScheduledExecutorService createDefaultExecutor() {
    return Executors.newSingleThreadScheduledExecutor(
        r -> {
          Thread t = new Thread(r, "jdbc-telemetry-batcher");
          t.setDaemon(true);
          return t;
        });
  }

  // Package-private constructor for testing overrides
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

  void offerConnectionAttempt(ConnectionAttempt attempt) {
    offerMetric(connectionAttemptQueue, attempt, "Connection attempt");
  }

  void offerStatementExecution(StatementExecution execution) {
    offerMetric(statementExecutionQueue, execution, "Statement execution");
  }

  void offerErrorMetric(ErrorMetric errorMetric) {
    offerMetric(errorMetricQueue, errorMetric, "Error metric");
  }

  void offerFeatureUsage(FeatureUsage featureUsage) {
    offerMetric(featureUsageQueue, featureUsage, "Feature usage");
  }

  private <T> void offerMetric(Queue<T> queue, T item, String metricName) {
    if (isClosed.get() || !isConfigured() || item == null) {
      return;
    }
    if (!queue.offer(item)) {
      logger.log(Level.WARNING, metricName + " telemetry queue full. Dropping metric.");
    }
  }

  TransportResult flush() {
    flushLock.lock();
    try {
      if (!isConfigured() || isEmpty()) {
        return TransportResult.disabled();
      }

      int maxTotalBatchSize =
          config != null
              ? config.getBatchSizeThreshold()
              : TelemetryConfiguration.DEFAULT_BATCH_SIZE_THRESHOLD;

      List<ConnectionAttempt> connectionAttempts = new ArrayList<>();
      List<StatementExecution> statementExecutions = new ArrayList<>();
      List<ErrorMetric> errorMetrics = new ArrayList<>();
      List<FeatureUsage> featureUsages = new ArrayList<>();

      int remainingQuota = maxTotalBatchSize;
      remainingQuota -= drainQueue(connectionAttemptQueue, connectionAttempts, remainingQuota);
      remainingQuota -= drainQueue(statementExecutionQueue, statementExecutions, remainingQuota);
      remainingQuota -= drainQueue(errorMetricQueue, errorMetrics, remainingQuota);
      remainingQuota -= drainQueue(featureUsageQueue, featureUsages, remainingQuota);

      if (connectionAttempts.isEmpty()
          && statementExecutions.isEmpty()
          && errorMetrics.isEmpty()
          && featureUsages.isEmpty()) {
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
      payloadBuilder.addAllConnectionAttempts(connectionAttempts);
      payloadBuilder.addAllStatementExecutions(statementExecutions);
      payloadBuilder.addAllErrors(errorMetrics);
      payloadBuilder.addAllFeatureUsages(featureUsages);

      TelemetryPayload payload = payloadBuilder.build();

      // Enforce MAX_PAYLOAD_BYTES (512 KB) by estimating bulk trim with safety padding
      int currentSize = payload.getSerializedSize();
      if (currentSize > MAX_PAYLOAD_BYTES) {
        int totalItems =
            connectionAttempts.size()
                + statementExecutions.size()
                + errorMetrics.size()
                + featureUsages.size();
        if (totalItems > 0) {
          double avgBytesPerItem = (double) currentSize / totalItems;
          int excessBytes = currentSize - MAX_PAYLOAD_BYTES;
          // Add +5 items safety pad to guarantee 100% single-pass size compliance
          int itemsToTrim =
              Math.min(totalItems, (int) Math.ceil(excessBytes / avgBytesPerItem) + 5);

          trimExcessItemsBulk(
              itemsToTrim, connectionAttempts, statementExecutions, errorMetrics, featureUsages);

          payloadBuilder
              .clearConnectionAttempts()
              .addAllConnectionAttempts(connectionAttempts)
              .clearStatementExecutions()
              .addAllStatementExecutions(statementExecutions)
              .clearErrors()
              .addAllErrors(errorMetrics)
              .clearFeatureUsages()
              .addAllFeatureUsages(featureUsages);
          payload = payloadBuilder.build();
        }
      }

      TransportResult result;
      try {
        result = transport.send(payload);
      } catch (Throwable t) {
        logger.log(Level.WARNING, "Unexpected exception during telemetry flush", t);
        result = new TransportResult(false, -1);
      }

      if (!result.isSuccess()) {
        requeueItems(connectionAttemptQueue, connectionAttempts);
        requeueItems(statementExecutionQueue, statementExecutions);
        requeueItems(errorMetricQueue, errorMetrics);
        requeueItems(featureUsageQueue, featureUsages);
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

  @Override
  public void close() {
    if (!isClosed.compareAndSet(false, true)) {
      return;
    }

    flushLock.lock();
    try {
      if (scheduledTask != null) {
        scheduledTask.cancel(false);
      }
    } finally {
      flushLock.unlock();
    }

    try {
      flush();
    } catch (Throwable t) {
      logger.log(Level.WARNING, "Error during final telemetry batcher flush", t);
    }

    if (ownsExecutor && executorService != null) {
      executorService.shutdown();
      try {
        if (!executorService.awaitTermination(3, TimeUnit.SECONDS)) {
          executorService.shutdownNow();
        }
      } catch (InterruptedException e) {
        executorService.shutdownNow();
        Thread.currentThread().interrupt();
      }
    }
  }

  boolean isEmpty() {
    return connectionAttemptQueue.isEmpty()
        && statementExecutionQueue.isEmpty()
        && errorMetricQueue.isEmpty()
        && featureUsageQueue.isEmpty();
  }

  int getPendingEventCount() {
    return connectionAttemptQueue.size()
        + statementExecutionQueue.size()
        + errorMetricQueue.size()
        + featureUsageQueue.size();
  }

  private boolean isConfigured() {
    return config != null && config.isEnabled() && transport != null;
  }

  private void reschedule(long delayMs) {
    if (isClosed.get() || executorService == null || executorService.isShutdown()) {
      return;
    }
    long effectiveDelay = Math.max(1L, delayMs);

    flushLock.lock();
    try {
      if (currentScheduleDelayMs.get() == effectiveDelay
          && scheduledTask != null
          && !scheduledTask.isDone()) {
        return;
      }

      if (scheduledTask != null) {
        scheduledTask.cancel(false);
      }

      currentScheduleDelayMs.set(effectiveDelay);
      scheduledTask =
          executorService.scheduleWithFixedDelay(
              () -> {
                try {
                  flush();
                } catch (Throwable t) {
                  logger.log(Level.WARNING, "Periodic telemetry flush encountered an exception", t);
                }
              },
              effectiveDelay,
              effectiveDelay,
              TimeUnit.MILLISECONDS);
    } finally {
      flushLock.unlock();
    }
  }

  private void trimExcessItemsBulk(
      int itemsToTrim,
      List<ConnectionAttempt> connectionAttempts,
      List<StatementExecution> statementExecutions,
      List<ErrorMetric> errorMetrics,
      List<FeatureUsage> featureUsages) {
    int remaining = itemsToTrim;
    remaining -= trimListToQueue(featureUsages, featureUsageQueue, remaining);
    remaining -= trimListToQueue(errorMetrics, errorMetricQueue, remaining);
    remaining -= trimListToQueue(statementExecutions, statementExecutionQueue, remaining);
    trimListToQueue(connectionAttempts, connectionAttemptQueue, remaining);
  }

  private <T> int trimListToQueue(List<T> list, Queue<T> queue, int maxToTrim) {
    int trimmed = 0;
    while (trimmed < maxToTrim && !list.isEmpty()) {
      queue.offer(list.remove(list.size() - 1));
      trimmed++;
    }
    return trimmed;
  }

  private <T> int drainQueue(LinkedBlockingQueue<T> queue, List<T> targetList, int maxItems) {
    if (maxItems <= 0) {
      return 0;
    }
    return queue.drainTo(targetList, maxItems);
  }

  private <T> void requeueItems(Queue<T> queue, List<T> items) {
    if (items != null && !items.isEmpty()) {
      for (T item : items) {
        if (!queue.offer(item)) {
          break; // Queue is full; stop requeueing to avoid dropping metrics or throwing exception
        }
      }
    }
  }
}
