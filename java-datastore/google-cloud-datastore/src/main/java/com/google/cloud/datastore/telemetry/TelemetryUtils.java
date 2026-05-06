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
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.datastore.DatastoreException;
import com.google.common.base.Stopwatch;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Utility class for common telemetry operations in Datastore.
 *
 * <p>WARNING: This class is intended for internal use only.
 */
@InternalApi
public final class TelemetryUtils {

  private TelemetryUtils() {}

  /**
   * Method to build a map of attributes to be used across both operation and attempt level metrics.
   *
   * @param methodName The name of the API method.
   * @param status The status of the operation or attempt.
   * @return The map of attributes.
   */
  public static Map<String, String> buildMetricAttributes(
      String methodName, String status, String databaseId) {
    Map<String, String> attributes = new HashMap<>();
    attributes.put(TelemetryConstants.ATTRIBUTES_KEY_METHOD, methodName);
    attributes.put(TelemetryConstants.ATTRIBUTES_KEY_STATUS, status);
    attributes.put(TelemetryConstants.ATTRIBUTES_KEY_SERVICE, TelemetryConstants.SERVICE_VALUE);
    if (databaseId != null) {
      attributes.put(TelemetryConstants.ATTRIBUTES_KEY_DATABASE_ID, databaseId);
    }
    return attributes;
  }

  /**
   * Records operation-level metrics. This method should be called after the entire operation across
   * all retry attempts has completed.
   *
   * <p>Metrics are recorded for both transport types (gRPC and HTTP).
   *
   * @param metricsRecorder The metrics recorder.
   * @param operationStopwatch The stopwatch tracking the duration of the entire operation.
   * @param methodName The name of the API method.
   * @param status The final status of the operation after all retries.
   */
  public static void recordOperationMetrics(
      DatastoreMetricsRecorder metricsRecorder,
      Stopwatch operationStopwatch,
      String methodName,
      String status,
      String databaseId) {
    if (methodName != null) {
      Map<String, String> attributes = buildMetricAttributes(methodName, status, databaseId);
      metricsRecorder.recordOperationLatency(
          operationStopwatch.elapsed(TimeUnit.MILLISECONDS), attributes);
      metricsRecorder.recordOperationCount(1, attributes);
    }
  }

  /**
   * Wraps a callable with logic to record attempt-level metrics. Attempt metrics are recorded for
   * each individual execution of the callable, regardless of whether it succeeds or fails.
   *
   * <p>Metrics are recorded for both transport types (gRPC and HTTP).
   *
   * @param callable The original callable to execute.
   * @param metricsRecorder The metrics recorder.
   * @param methodName The name of the API method.
   * @param <T> The return type of the callable.
   * @return A wrapped callable that includes attempt-level metrics recording.
   */
  public static <T> Callable<T> attemptMetricsCallable(
      Callable<T> callable,
      DatastoreMetricsRecorder metricsRecorder,
      String methodName,
      String databaseId) {
    return () -> {
      Stopwatch stopwatch = Stopwatch.createStarted();
      String status = StatusCode.Code.UNKNOWN.toString();
      try {
        T result = callable.call();
        status = StatusCode.Code.OK.toString();
        return result;
      } catch (Exception e) {
        status = DatastoreException.extractStatusCode(e);
        throw e;
      } finally {
        Map<String, String> attributes = buildMetricAttributes(methodName, status, databaseId);
        metricsRecorder.recordAttemptLatency(stopwatch.elapsed(TimeUnit.MILLISECONDS), attributes);
        metricsRecorder.recordAttemptCount(1, attributes);
      }
    };
  }
}
