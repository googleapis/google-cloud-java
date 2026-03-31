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

import java.util.List;
import java.util.Map;

/**
 * A {@link DatastoreMetricsRecorder} implementation that fans out recording calls to multiple
 * underlying recorders.
 *
 * <p>This allows simultaneous recording to both built-in (Cloud Monitoring) and custom
 * (user-provided) OpenTelemetry backends.
 */
class CompositeDatastoreMetricsRecorder implements DatastoreMetricsRecorder {

  private final List<DatastoreMetricsRecorder> recorders;

  CompositeDatastoreMetricsRecorder(List<DatastoreMetricsRecorder> recorders) {
    this.recorders = recorders;
  }

  @Override
  public void recordTransactionLatency(double latencyMs, Map<String, String> attributes) {
    for (DatastoreMetricsRecorder recorder : recorders) {
      recorder.recordTransactionLatency(latencyMs, attributes);
    }
  }

  @Override
  public void recordTransactionAttemptCount(long count, Map<String, String> attributes) {
    for (DatastoreMetricsRecorder recorder : recorders) {
      recorder.recordTransactionAttemptCount(count, attributes);
    }
  }

  @Override
  public void recordAttemptLatency(double latencyMs, Map<String, String> attributes) {
    for (DatastoreMetricsRecorder recorder : recorders) {
      recorder.recordAttemptLatency(latencyMs, attributes);
    }
  }

  @Override
  public void recordAttemptCount(long count, Map<String, String> attributes) {
    for (DatastoreMetricsRecorder recorder : recorders) {
      recorder.recordAttemptCount(count, attributes);
    }
  }

  @Override
  public void recordOperationLatency(double latencyMs, Map<String, String> attributes) {
    for (DatastoreMetricsRecorder recorder : recorders) {
      recorder.recordOperationLatency(latencyMs, attributes);
    }
  }

  @Override
  public void recordOperationCount(long count, Map<String, String> attributes) {
    for (DatastoreMetricsRecorder recorder : recorders) {
      recorder.recordOperationCount(count, attributes);
    }
  }
}
