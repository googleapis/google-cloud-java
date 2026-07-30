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
import java.util.ArrayList;
import java.util.List;
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

  private final LinkedBlockingQueue<Message> eventQueue = new LinkedBlockingQueue<>(MAX_QUEUE_SIZE);

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

  private static ScheduledExecutorService createDefaultExecutor() {
    return Executors.newSingleThreadScheduledExecutor(
        r -> {
          Thread t = new Thread(r, "jdbc-telemetry-batcher");
          t.setDaemon(true);
          return t;
        });
  }

  void offerConnectionAttempt(ConnectionAttempt attempt) {
    offerMetric(attempt, "Connection attempt");
  }

  void offerStatementExecution(StatementExecution execution) {
    offerMetric(execution, "Statement execution");
  }

  void offerErrorMetric(ErrorMetric errorMetric) {
    offerMetric(errorMetric, "Error metric");
  }

  void offerFeatureUsage(FeatureUsage featureUsage) {
    offerMetric(featureUsage, "Feature usage");
  }

  private void offerMetric(Message item, String metricName) {
    if (isClosed.get() || !isConfigured() || item == null) {
      return;
    }
    if (!eventQueue.offer(item)) {
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

      List<Message> events = new ArrayList<>(maxTotalBatchSize);
      eventQueue.drainTo(events, maxTotalBatchSize);

      if (events.isEmpty()) {
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

      populatePayloadBuilder(payloadBuilder, events);

      TelemetryPayload payload = payloadBuilder.build();

      // Enforce MAX_PAYLOAD_BYTES (512 KB) by estimating bulk trim with safety padding
      int currentSize = payload.getSerializedSize();
      if (currentSize > MAX_PAYLOAD_BYTES && !events.isEmpty()) {
        double avgBytesPerItem = (double) currentSize / events.size();
        int excessBytes = currentSize - MAX_PAYLOAD_BYTES;
        int itemsToTrim =
            Math.min(events.size(), (int) Math.ceil(excessBytes / avgBytesPerItem) + 5);

        int trimCount = Math.min(events.size(), itemsToTrim);
        int startIndex = events.size() - trimCount;
        List<Message> trimmedEvents = events.subList(startIndex, events.size());
        requeueItems(trimmedEvents);
        trimmedEvents.clear();

        payloadBuilder
            .clearConnectionAttempts()
            .clearStatementExecutions()
            .clearErrors()
            .clearFeatureUsages();
        populatePayloadBuilder(payloadBuilder, events);
        payload = payloadBuilder.build();
      }

      TransportResult result;
      try {
        result = transport.send(payload);
      } catch (Throwable t) {
        logger.log(Level.WARNING, "Unexpected exception during telemetry flush", t);
        result = new TransportResult(false, -1);
      }

      if (!result.isSuccess()) {
        requeueItems(events);
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

  private void populatePayloadBuilder(TelemetryPayload.Builder builder, List<Message> events) {
    for (Message event : events) {
      if (event instanceof ConnectionAttempt) {
        builder.addConnectionAttempts((ConnectionAttempt) event);
      } else if (event instanceof StatementExecution) {
        builder.addStatementExecutions((StatementExecution) event);
      } else if (event instanceof ErrorMetric) {
        builder.addErrors((ErrorMetric) event);
      } else if (event instanceof FeatureUsage) {
        builder.addFeatureUsages((FeatureUsage) event);
      }
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
    return eventQueue.isEmpty();
  }

  int getPendingEventCount() {
    return eventQueue.size();
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

  private void requeueItems(List<Message> items) {
    if (items == null || items.isEmpty()) {
      return;
    }
    for (Message item : items) {
      if (!eventQueue.offer(item)) {
        break; // Queue is full; stop requeueing to avoid dropping metrics or throwing exception
      }
    }
  }
}
