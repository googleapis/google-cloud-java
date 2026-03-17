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
import java.util.Map;

/**
 * Metrics recorder implementation, used to stub out metrics instrumentation when metrics are
 * disabled.
 *
 * <p>WARNING: This class is intended for internal use only. It was made public to be used across
 * packages as a default. It should not be used by external customers and its API may change without
 * notice.
 */
@InternalApi
public class NoOpMetricsRecorder implements MetricsRecorder {

  @Override
  public void recordTransactionLatency(double latencyMs, Map<String, String> attributes) {
    /* No-Op OTel Operation */
  }

  @Override
  public void recordTransactionAttemptCount(long count, Map<String, String> attributes) {
    /* No-Op OTel Operation */
  }

  @Override
  public void recordAttemptLatency(double latencyMs, Map<String, String> attributes) {
    /* No-Op OTel Operation */
  }

  @Override
  public void recordAttemptCount(long count, Map<String, String> attributes) {
    /* No-Op OTel Operation */
  }

  @Override
  public void recordOperationLatency(double latencyMs, Map<String, String> attributes) {
    /* No-Op OTel Operation */
  }

  @Override
  public void recordOperationCount(long count, Map<String, String> attributes) {
    /* No-Op OTel Operation */
  }
}
