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

package com.google.cloud.datastore.telemetry;

import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A {@link DatastoreMetricsRecorder} implementation that fans out recording calls to multiple
 * underlying recorders.
 *
 * <p>This allows simultaneous recording to both built-in (Cloud Monitoring) and custom
 * (user-provided) OpenTelemetry backends.
 */
@InternalApi
public class CompositeDatastoreMetricsRecorder implements DatastoreMetricsRecorder {

  private static final Logger logger =
      Logger.getLogger(CompositeDatastoreMetricsRecorder.class.getName());

  private final List<DatastoreMetricsRecorder> recorders;

  public CompositeDatastoreMetricsRecorder(List<DatastoreMetricsRecorder> recorders) {
    this.recorders = recorders;
  }

  @VisibleForTesting
  List<DatastoreMetricsRecorder> getMetricRecorders() {
    return recorders;
  }

  /** {@inheritDoc} */
  @Override
  public void recordTransactionLatency(double latencyMs, Map<String, String> attributes) {
    for (DatastoreMetricsRecorder recorder : recorders) {
      recorder.recordTransactionLatency(latencyMs, attributes);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void recordTransactionAttemptCount(long count, Map<String, String> attributes) {
    for (DatastoreMetricsRecorder recorder : recorders) {
      recorder.recordTransactionAttemptCount(count, attributes);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void recordAttemptLatency(double latencyMs, Map<String, String> attributes) {
    for (DatastoreMetricsRecorder recorder : recorders) {
      recorder.recordAttemptLatency(latencyMs, attributes);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void recordAttemptCount(long count, Map<String, String> attributes) {
    for (DatastoreMetricsRecorder recorder : recorders) {
      recorder.recordAttemptCount(count, attributes);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void recordOperationLatency(double latencyMs, Map<String, String> attributes) {
    for (DatastoreMetricsRecorder recorder : recorders) {
      recorder.recordOperationLatency(latencyMs, attributes);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void recordOperationCount(long count, Map<String, String> attributes) {
    for (DatastoreMetricsRecorder recorder : recorders) {
      recorder.recordOperationCount(count, attributes);
    }
  }

  /**
   * Closes all underlying recorders.
   *
   * <p>Each recorder's own {@link DatastoreMetricsRecorder#close()} semantics apply: recorders that
   * own their {@link io.opentelemetry.api.OpenTelemetry} instance (built-in path) will flush and
   * shut down; recorders backed by a user-provided instance will no-op. All recorders are closed
   * even if one throws an exception.
   */
  @Override
  public void close() {
    for (int i = recorders.size() - 1; i >= 0; i--) {
      try {
        recorders.get(i).close();
      } catch (Exception e) {
        logger.log(Level.WARNING, "Failed to close metrics recorder", e);
      }
    }
  }
}
