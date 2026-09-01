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

import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.jdbc.BigQueryJdbcCustomLogger;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import java.util.Properties;
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
  private static volatile boolean globallyDisabled = false;

  private final TelemetryBatcher batcher;

  private TelemetryManager(TelemetryBatcher batcher) {
    this.batcher = batcher;
  }

  /**
   * Initializes or replaces the shared {@link TelemetryManager} instance with default configuration
   * and transport.
   */
  static TelemetryManager getInstance() {
    return getInstance(null);
  }

  static TelemetryManager getInstance(Properties properties) {
    if (globallyDisabled) {
      return null;
    }

    if (properties != null) {
      TelemetryConfiguration configCheck =
          TelemetryConfiguration.builder().resolveProperties(properties).build();
      if (!configCheck.isEnabled()) {
        synchronized (TelemetryManager.class) {
          globallyDisabled = true;
          closeInstance();
        }
        return null;
      }
    }

    TelemetryManager localRef = instance;
    if (localRef == null) {
      synchronized (TelemetryManager.class) {
        if (globallyDisabled) {
          return null;
        }
        localRef = instance;
        if (localRef == null) {
          TelemetryConfiguration config =
              TelemetryConfiguration.builder().resolveProperties(properties).build();
          ClearcutTransport transport = new ClearcutTransport(config);
          TelemetryBatcher batcher = new TelemetryBatcher(config, transport);
          localRef = new TelemetryManager(batcher);
          instance = localRef;
        }
      }
    }
    return localRef;
  }

  /** Package-private lifecycle initialisation method for explicit configuration or unit testing. */
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

  /** Package-private helper to check if an active instance is present and initialized. */
  static boolean isInitialized() {
    return instance != null;
  }

  /** Flushes pending buffered metrics and shuts down the shared instance. */
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

  // Package-private test helper to reset the global kill switch between test runs
  static synchronized void resetGlobalDisableForTest() {
    globallyDisabled = false;
  }

  static StatementType toStatementType(QueryStatistics.StatementType bqStatementType) {
    if (bqStatementType == null) {
      return StatementType.STATEMENT_TYPE_UNSPECIFIED;
    }

    EnumValueDescriptor desc =
        StatementType.getDescriptor().findValueByName("STATEMENT_TYPE_" + bqStatementType.name());

    return desc != null ? StatementType.valueOf(desc) : StatementType.STATEMENT_TYPE_OTHER;
  }

  static AuthenticationType toAuthenticationType(int oauthType) {
    switch (oauthType) {
      case 0:
        return AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT;
      case 1:
        return AuthenticationType.AUTHENTICATION_TYPE_USER_AUTHENTICATION;
      case 2:
        return AuthenticationType.AUTHENTICATION_TYPE_APPLICATION_DEFAULT_CREDENTIALS;
      case 3:
        return AuthenticationType.AUTHENTICATION_TYPE_EXTERNAL;
      case 4:
        return AuthenticationType.AUTHENTICATION_TYPE_TOKEN;
      default:
        return AuthenticationType.AUTHENTICATION_TYPE_CUSTOM;
    }
  }

  static final double[] HISTOGRAM_BOUNDS = {
    10.0, 50.0, 100.0, 250.0, 500.0, 1000.0, 5000.0, 10000.0
  };

  static int calculateBucketIndex(long durationMs) {
    int bucketIndex = HISTOGRAM_BOUNDS.length;
    for (int i = 0; i < HISTOGRAM_BOUNDS.length; i++) {
      if (durationMs < HISTOGRAM_BOUNDS[i]) {
        return i;
      }
    }
    return bucketIndex;
  }

  static void recordConnectionAttempt(Status status, int errorCode, AuthenticationType authType) {
    runSafely(
        () -> {
          TelemetryManager mgr = instance;
          if (mgr != null && mgr.getBatcher() != null) {
            mgr.getBatcher().offerConnectionAttempt(status, errorCode, authType);
          }
        });
  }

  // Avoids Protobuf allocations during execution by passing raw fields directly to the Batcher.

  static void recordStatementExecution(
      StatementType statementType,
      QueryApiType apiType,
      Status status,
      int errorCode,
      long durationMs) {
    runSafely(
        () -> {
          TelemetryManager mgr = instance;
          if (mgr != null && mgr.getBatcher() != null) {
            int bucketIndex = calculateBucketIndex(durationMs);
            mgr.getBatcher()
                .offerStatementExecution(
                    statementType, apiType, status, errorCode, durationMs, bucketIndex);
          }
        });
  }

  static void recordFeatureUsage(DriverFeature feature, String customFeatureName) {
    runSafely(
        () -> {
          TelemetryManager mgr = instance;
          if (mgr != null && mgr.getBatcher() != null) {
            mgr.getBatcher()
                .offerFeatureUsage(feature, customFeatureName == null ? "" : customFeatureName);
          }
        });
  }
}
