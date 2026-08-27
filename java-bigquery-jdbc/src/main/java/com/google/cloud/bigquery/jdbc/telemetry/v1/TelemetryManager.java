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
   * Initializes or replaces the shared {@link TelemetryManager} instance with default configuration
   * and transport.
   */
  static TelemetryManager getInstance() {
    return getInstance(null);
  }

  static TelemetryManager getInstance(java.util.Properties properties) {
    TelemetryManager localRef = instance;
    if (localRef == null) {
      synchronized (TelemetryManager.class) {
        localRef = instance;
        if (localRef == null) {
          TelemetryConfiguration config =
              TelemetryConfiguration.builder().resolveEnabledFlag(properties).build();
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

  static StatementType toStatementType(QueryStatistics.StatementType bqStatementType) {
    if (bqStatementType == null) {
      return StatementType.STATEMENT_TYPE_UNSPECIFIED;
    }
    switch (bqStatementType.name()) {
      case "SELECT":
        return StatementType.STATEMENT_TYPE_SELECT;
      case "INSERT":
        return StatementType.STATEMENT_TYPE_INSERT;
      case "UPDATE":
        return StatementType.STATEMENT_TYPE_UPDATE;
      case "DELETE":
        return StatementType.STATEMENT_TYPE_DELETE;
      case "MERGE":
        return StatementType.STATEMENT_TYPE_MERGE;
      case "CREATE_TABLE":
        return StatementType.STATEMENT_TYPE_CREATE_TABLE;
      case "CREATE_TABLE_AS_SELECT":
        return StatementType.STATEMENT_TYPE_CREATE_TABLE_AS_SELECT;
      case "CREATE_MODEL":
        return StatementType.STATEMENT_TYPE_CREATE_MODEL;
      case "CREATE_VIEW":
        return StatementType.STATEMENT_TYPE_CREATE_VIEW;
      case "CREATE_FUNCTION":
        return StatementType.STATEMENT_TYPE_CREATE_FUNCTION;
      case "CREATE_PROCEDURE":
        return StatementType.STATEMENT_TYPE_CREATE_PROCEDURE;
      case "CREATE_MATERIALIZED_VIEW":
        return StatementType.STATEMENT_TYPE_CREATE_MATERIALIZED_VIEW;
      case "CREATE_TABLE_FUNCTION":
        return StatementType.STATEMENT_TYPE_CREATE_TABLE_FUNCTION;
      case "CREATE_ROW_ACCESS_POLICY":
        return StatementType.STATEMENT_TYPE_CREATE_ROW_ACCESS_POLICY;
      case "CREATE_SCHEMA":
        return StatementType.STATEMENT_TYPE_CREATE_SCHEMA;
      case "CREATE_SNAPSHOT_TABLE":
        return StatementType.STATEMENT_TYPE_CREATE_SNAPSHOT_TABLE;
      case "CREATE_SEARCH_INDEX":
        return StatementType.STATEMENT_TYPE_CREATE_SEARCH_INDEX;
      case "CREATE_EXTERNAL_TABLE":
        return StatementType.STATEMENT_TYPE_CREATE_EXTERNAL_TABLE;
      case "DROP_TABLE":
        return StatementType.STATEMENT_TYPE_DROP_TABLE;
      case "DROP_VIEW":
        return StatementType.STATEMENT_TYPE_DROP_VIEW;
      case "DROP_FUNCTION":
        return StatementType.STATEMENT_TYPE_DROP_FUNCTION;
      case "DROP_PROCEDURE":
        return StatementType.STATEMENT_TYPE_DROP_PROCEDURE;
      case "DROP_EXTERNAL_TABLE":
        return StatementType.STATEMENT_TYPE_DROP_EXTERNAL_TABLE;
      case "DROP_MODEL":
        return StatementType.STATEMENT_TYPE_DROP_MODEL;
      case "DROP_MATERIALIZED_VIEW":
        return StatementType.STATEMENT_TYPE_DROP_MATERIALIZED_VIEW;
      case "DROP_TABLE_FUNCTION":
        return StatementType.STATEMENT_TYPE_DROP_TABLE_FUNCTION;
      case "DROP_SEARCH_INDEX":
        return StatementType.STATEMENT_TYPE_DROP_SEARCH_INDEX;
      case "DROP_SCHEMA":
        return StatementType.STATEMENT_TYPE_DROP_SCHEMA;
      case "DROP_SNAPSHOT_TABLE":
        return StatementType.STATEMENT_TYPE_DROP_SNAPSHOT_TABLE;
      case "DROP_ROW_ACCESS_POLICY":
        return StatementType.STATEMENT_TYPE_DROP_ROW_ACCESS_POLICY;
      case "ALTER_TABLE":
        return StatementType.STATEMENT_TYPE_ALTER_TABLE;
      case "ALTER_VIEW":
        return StatementType.STATEMENT_TYPE_ALTER_VIEW;
      case "ALTER_MATERIALIZED_VIEW":
        return StatementType.STATEMENT_TYPE_ALTER_MATERIALIZED_VIEW;
      case "ALTER_SCHEMA":
        return StatementType.STATEMENT_TYPE_ALTER_SCHEMA;
      case "TRUNCATE_TABLE":
        return StatementType.STATEMENT_TYPE_TRUNCATE_TABLE;
      case "EXPORT_DATA":
        return StatementType.STATEMENT_TYPE_EXPORT_DATA;
      case "EXPORT_MODEL":
        return StatementType.STATEMENT_TYPE_EXPORT_MODEL;
      case "LOAD_DATA":
        return StatementType.STATEMENT_TYPE_LOAD_DATA;
      case "CALL":
        return StatementType.STATEMENT_TYPE_CALL;
      case "SCRIPT":
        return StatementType.STATEMENT_TYPE_SCRIPT;
      default:
        return StatementType.STATEMENT_TYPE_OTHER;
    }
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

  static DurationHistogram toDurationBucketMs(long durationMs) {
    DurationHistogram.Builder builder =
        DurationHistogram.newBuilder().setCount(1).setSum(durationMs);

    int bucketIndex = HISTOGRAM_BOUNDS.length;
    for (int i = 0; i < HISTOGRAM_BOUNDS.length; i++) {
      builder.addExplicitBounds(HISTOGRAM_BOUNDS[i]);
      if (bucketIndex == HISTOGRAM_BOUNDS.length && durationMs < HISTOGRAM_BOUNDS[i]) {
        bucketIndex = i;
      }
    }
    for (int i = 0; i <= HISTOGRAM_BOUNDS.length; i++) {
      builder.addBucketCounts(i == bucketIndex ? 1L : 0L);
    }
    return builder.build();
  }

  static void recordConnectionAttempt(Status status, int errorCode, AuthenticationType authType) {
    runSafely(
        () -> {
          TelemetryManager mgr = instance;
          if (mgr != null && mgr.getBatcher() != null) {
            mgr.getBatcher()
                .offerConnectionAttempt(
                    ConnectionAttempt.newBuilder()
                        .setStatus(status)
                        .setErrorCode(errorCode)
                        .setAuthType(authType)
                        .setCount(1)
                        .build());
          }
        });
  }

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
            mgr.getBatcher()
                .offerStatementExecution(
                    StatementExecution.newBuilder()
                        .setStatementType(statementType)
                        .setQueryApiType(apiType)
                        .setStatus(status)
                        .setErrorCode(errorCode)
                        .setCount(1)
                        .setDuration(toDurationBucketMs(durationMs))
                        .build());
          }
        });
  }

  static void recordFeatureUsage(DriverFeature feature, String customFeatureName) {
    runSafely(
        () -> {
          TelemetryManager mgr = instance;
          if (mgr != null && mgr.getBatcher() != null) {
            mgr.getBatcher()
                .offerFeatureUsage(
                    FeatureUsage.newBuilder()
                        .setDriverFeature(feature)
                        .setCustomFeatureName(customFeatureName == null ? "" : customFeatureName)
                        .setCount(1)
                        .build());
          }
        });
  }
}
