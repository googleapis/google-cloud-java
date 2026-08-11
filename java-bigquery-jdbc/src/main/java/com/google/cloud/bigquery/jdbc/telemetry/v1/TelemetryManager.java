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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Thread-safe singleton hub managing the lifecycle of {@link TelemetryBatcher} for client-side
 * diagnostic and usage telemetry in the BigQuery JDBC driver.
 *
 * <p>All telemetry operations are wrapped in exception safeguards so that failures in metric
 * collection or batch dispatching never impact standard JDBC functionality.
 */
final class TelemetryManager implements AutoCloseable {
  private static final Logger logger =
      new BigQueryJdbcCustomLogger(TelemetryManager.class.getName());

  private static volatile TelemetryManager instance;

  private final TelemetryBatcher batcher;

  private TelemetryManager(TelemetryBatcher batcher) {
    this.batcher = batcher;
  }

  /**
   * Initializes or replaces the shared {@link TelemetryManager} instance with default
   * configuration and transport.
   */
  static TelemetryManager getInstance() {
    TelemetryManager localRef = instance;
    if (localRef == null) {
      synchronized (TelemetryManager.class) {
        localRef = instance;
        if (localRef == null) {
          TelemetryConfiguration config = TelemetryConfiguration.builder().build();
          ClearcutTransport transport = new ClearcutTransport(config);
          TelemetryBatcher batcher = new TelemetryBatcher(config, transport);
          localRef = new TelemetryManager(batcher);
          instance = localRef;
        }
      }
    }
    return localRef;
  }

  /**
   * Package-private lifecycle initialisation method for explicit configuration or unit testing.
   */
  static synchronized void init(TelemetryConfiguration config, ClearcutTransport transport) {
    closeInstance();
    if (config != null && config.isEnabled() && transport != null) {
      TelemetryBatcher batcher = new TelemetryBatcher(config, transport);
      instance = new TelemetryManager(batcher);
    }
  }

  /**
   * Returns the underlying {@link TelemetryBatcher} managed by this instance, or {@code null} if
   * telemetry is closed or uninitialized.
   */
  TelemetryBatcher getBatcher() {
    return batcher;
  }

  /**
   * Executes a telemetry logging operation safely inside an exception-isolated block. Guaranteed to
   * catch all {@link Throwable} exceptions to protect JDBC driver operations.
   */
  static void runSafely(Runnable action) {
    if (action == null) {
      return;
    }
    try {
      action.run();
    } catch (Throwable t) {
      logger.log(Level.FINE, "Diagnostic telemetry operation encountered non-fatal error", t);
    }
  }

  /**
   * Package-private helper to check if an active instance is present and initialized.
   */
  static boolean isInitialized() {
    return instance != null;
  }

  /**
   * Flushes pending buffered metrics and shuts down the shared instance.
   */
  static synchronized void closeInstance() {
    TelemetryManager localRef = instance;
    instance = null;
    if (localRef != null) {
      try {
        localRef.close();
      } catch (Throwable t) {
        logger.log(Level.FINE, "Error closing TelemetryManager instance", t);
      }
    }
  }

  @Override
  public void close() {
    if (batcher != null) {
      batcher.close();
    }
  }
}
