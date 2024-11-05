/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.firestore.telemetry;

import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.cloud.firestore.FirestoreOptions;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Nonnull;

/**
 * A utility interface for metrics collection. Classes that implement this interface may make their
 * own design choices for how they approach metrics collection. For instance, they may be no-op, or
 * they may use a particular metrics framework such as OpenTelemetry.
 */
@InternalApi
public interface MetricsUtil {
  final Logger logger = Logger.getLogger(MetricsUtil.class.getName());

  static final String ENABLE_METRICS_ENV_VAR = "FIRESTORE_ENABLE_METRICS";

  /**
   * Creates an instance of {@code MetricsUtil}. If the environment variable
   * `FIRESTORE_ENABLE_METRICS` is set to false or off, an instance of {@link DisabledMetricsUtil}
   * will be returned. Otherwise, an instance of {@link EnabledMetricsUtil} will be returned.
   *
   * @param firestoreOptions The Firestore options that configures client side metrics.
   * @return An instance of {@code MetricsUtil}.
   */
  static MetricsUtil getInstance(@Nonnull FirestoreOptions firestoreOptions) {
    if (shouldCreateEnabledInstance()) {
      return new EnabledMetricsUtil(firestoreOptions);
    } else {
      return new DisabledMetricsUtil();
    }
  }

  static boolean shouldCreateEnabledInstance() {
    // Client side metrics feature is default on unless it is manually turned off by
    // environment variables
    // TODO(metrics): The feature is disabled before it is ready for general release.
    boolean shouldCreateEnabledInstance = false;

    String enableMetricsEnvVar = System.getenv(ENABLE_METRICS_ENV_VAR);
    if (enableMetricsEnvVar != null) {
      switch (enableMetricsEnvVar.toLowerCase()) {
        case "true":
        case "on":
          // The feature is default on.
          break;
        case "false":
        case "off":
          shouldCreateEnabledInstance = false;
          break;
        default:
          logger.warning("Invalid value for FIRESTORE_ENABLE_METRICS: " + enableMetricsEnvVar);
      }
    }

    return shouldCreateEnabledInstance;
  }

  /**
   * Creates a new {@code MetricsContext} for the given method and starts timing.
   *
   * @param methodName The name of the method.
   * @return A new {@code MetricsContext}.
   */
  abstract MetricsContext createMetricsContext(String methodName);

  /**
   * Adds a metrics tracer factory to the given list of API tracer factories.
   *
   * @param apiTracerFactories The list of API tracer factories.
   */
  abstract void addMetricsTracerFactory(List<ApiTracerFactory> apiTracerFactories);

  /** A context for recording metrics. */
  interface MetricsContext {

    /**
     * If the operation ends in the future, its relevant metrics should be recorded _after_ the
     * future has been completed. This method "appends" the metrics recording code at the completion
     * of the given future.
     */
    <T> void recordEndToEndLatencyAtFuture(ApiFuture<T> futureValue);

    /** Records end-to-end latency for the current operation. */
    void recordEndToEndLatency();

    /** Records end-to-end latency for the current operation, which ended with a throwable. */
    void recordEndToEndLatency(Throwable t);

    /** Records first response latency for the current operation. */
    void recordFirstResponseLatency();
  }
}
