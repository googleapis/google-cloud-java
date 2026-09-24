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

import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.jdbc.BigQueryJdbcCustomLogger;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import java.sql.SQLException;
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
public final class TelemetryManager implements AutoCloseable {
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
  public static TelemetryManager getInstance() {
    return getInstance(null);
  }

  public static TelemetryManager getInstance(Properties properties) {
    if (globallyDisabled) {
      return null;
    }

    if (properties != null
        && !TelemetryConfiguration.builder().resolveProperties(properties).build().isEnabled()) {
      synchronized (TelemetryManager.class) {
        globallyDisabled = true;
        closeInstance();
      }
      return null;
    }

    TelemetryManager localRef = instance;
    if (localRef != null) {
      return localRef;
    }

    synchronized (TelemetryManager.class) {
      if (globallyDisabled) {
        return null;
      }
      localRef = instance;
      if (localRef != null) {
        return localRef;
      }
      TelemetryConfiguration config =
          TelemetryConfiguration.builder()
              .resolveProperties(properties)
              .setDriverEnvironment(DriverEnvironmentDetector.build())
              .build();
      ClearcutTransport transport = new ClearcutTransport(config);
      TelemetryBatcher batcher = new TelemetryBatcher(config, transport);
      localRef = new TelemetryManager(batcher);
      // Registered before the instance is published so that a non-null instance always implies a
      // registered shutdown hook.
      registerShutdownHook();
      instance = localRef;
      return localRef;
    }
  }

  /** Package-private lifecycle initialisation method for explicit configuration or unit testing. */
  static synchronized void init(TelemetryConfiguration config, ClearcutTransport transport) {
    closeInstance();
    if (config == null || !config.isEnabled() || transport == null) {
      return;
    }
    instance = new TelemetryManager(new TelemetryBatcher(config, transport));
  }

  /**
   * Returns the underlying {@link TelemetryBatcher} managed by this instance, or {@code null} if
   * telemetry is closed or uninitialized.
   */
  TelemetryBatcher getBatcher() {
    return batcher;
  }

  /**
   * Returns the {@link TelemetryBatcher} of the active instance, or {@code null} if telemetry is
   * closed or uninitialized.
   */
  private static TelemetryBatcher activeBatcher() {
    TelemetryManager localRef = instance;
    return localRef == null ? null : localRef.getBatcher();
  }

  /**
   * Executes a telemetry logging operation safely inside an exception-isolated block. Guaranteed to
   * catch all {@link Throwable} exceptions to protect JDBC driver operations.
   */
  public static void runSafely(Runnable action) {
    if (action == null) {
      return;
    }
    try {
      action.run();
    } catch (Throwable t) {
      logger.log(Level.FINE, "Diagnostic telemetry operation encountered non-fatal error", t);
    }
  }

  /** Helper to check if an active instance is present and initialized. */
  public static boolean isInitialized() {
    return instance != null;
  }

  /** Flushes pending buffered metrics and shuts down the shared instance. */
  public static synchronized void closeInstance() {
    TelemetryManager localRef = instance;
    instance = null;
    if (localRef == null) {
      return;
    }
    try {
      localRef.close();
    } catch (Throwable t) {
      logger.log(Level.FINE, "Error closing TelemetryManager instance", t);
    }
  }

  @Override
  public void close() {
    batcher.close();
  }

  // Package-private test helper to reset the global kill switch between test runs
  static synchronized void resetGlobalDisableForTest() {
    globallyDisabled = false;
  }

  public static StatementType toStatementType(QueryStatistics.StatementType bqStatementType) {
    if (bqStatementType == null) {
      return StatementType.STATEMENT_TYPE_UNSPECIFIED;
    }

    EnumValueDescriptor desc =
        StatementType.getDescriptor().findValueByName("STATEMENT_TYPE_" + bqStatementType.name());

    return desc != null ? StatementType.valueOf(desc) : StatementType.STATEMENT_TYPE_OTHER;
  }

  public static AuthenticationType toAuthenticationType(int oauthType) {
    switch (oauthType) {
      case 0:
        return AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT;
      case 1:
        return AuthenticationType.AUTHENTICATION_TYPE_USER_AUTHENTICATION;
      case 2:
        return AuthenticationType.AUTHENTICATION_TYPE_TOKEN;
      case 3:
        return AuthenticationType.AUTHENTICATION_TYPE_APPLICATION_DEFAULT_CREDENTIALS;
      case 4:
        return AuthenticationType.AUTHENTICATION_TYPE_EXTERNAL;
      default:
        return AuthenticationType.AUTHENTICATION_TYPE_CUSTOM;
    }
  }

  public static void recordConnectionAttempt(
      Status status, int errorCode, AuthenticationType authType) {
    runSafely(
        () -> {
          TelemetryBatcher activeBatcher = activeBatcher();
          if (activeBatcher == null) {
            return;
          }
          activeBatcher.offer(
              ConnectionAttempt.newBuilder()
                  .setStatus(status)
                  .setErrorCode(errorCode)
                  .setAuthType(authType)
                  .build());
        });
  }

  public static void recordStatementExecution(
      StatementType statementType,
      QueryApiType apiType,
      Status status,
      int errorCode,
      long durationMs) {
    runSafely(
        () -> {
          TelemetryBatcher activeBatcher = activeBatcher();
          if (activeBatcher == null) {
            return;
          }
          activeBatcher.offer(
              StatementExecution.newBuilder()
                  .setStatementType(statementType)
                  .setQueryApiType(apiType)
                  .setStatus(status)
                  .setErrorCode(errorCode)
                  .build(),
              durationMs);
        });
  }

  public static void recordStatementExecution(
      StatementExecution.Builder statementExecutionBuilder, long durationMs) {
    if (statementExecutionBuilder == null) {
      return;
    }
    runSafely(
        () -> {
          TelemetryBatcher activeBatcher = activeBatcher();
          if (activeBatcher == null) {
            return;
          }
          activeBatcher.offer(statementExecutionBuilder.build(), durationMs);
        });
  }

  public static void recordFeatureUsage(DriverFeature feature, String customFeatureName) {
    runSafely(
        () -> {
          TelemetryBatcher activeBatcher = activeBatcher();
          if (activeBatcher == null) {
            return;
          }
          activeBatcher.offer(
              FeatureUsage.newBuilder()
                  .setDriverFeature(feature)
                  .setCustomFeatureName(customFeatureName == null ? "" : customFeatureName)
                  .build());
        });
  }

  public static void recordFeatureUsage(DriverFeature feature) {
    recordFeatureUsage(feature, null);
  }

  // Not setting xdbc_error_code intentionally.
  public static void recordError(int errorCode, String errorSqlState, String methodName) {
    runSafely(
        () -> {
          TelemetryBatcher activeBatcher = activeBatcher();
          if (activeBatcher == null) {
            return;
          }
          activeBatcher.offer(
              ErrorMetric.newBuilder()
                  .setErrorCode(errorCode)
                  .setErrorSqlState(errorSqlState == null ? "" : errorSqlState)
                  .setMethodName(methodName == null ? "" : methodName)
                  .build());
        });
  }

  /**
   * Extracts the numeric error code from the throwable chain. Traverses causes to unpack
   * BigQueryException (HTTP status codes) or SQLException error codes. Returns 1000 as the fallback
   * driver error code.
   */
  public static int extractErrorCode(Throwable t) {
    int depth = 0;
    while (t != null && depth++ < 20) {
      if (t instanceof BigQueryException) {
        int code = ((BigQueryException) t).getCode();
        if (code != 0) {
          return code;
        }
      }
      if (t instanceof SQLException) {
        int code = ((SQLException) t).getErrorCode();
        if (code != 0) {
          return code;
        }
      }
      t = t.getCause();
    }
    return 1000;
  }

  /**
   * Extracts a numeric form of the SQLState from the throwable chain. SQLStates are five-character
   * strings; the digits-only ones (for example {@code 42000}) carry directly, while states
   * containing letters (for example {@code HY000}) have no numeric form and yield {@code 0}.
   *
   * <p>Returns {@code 0} when no SQLState is present or none is numeric, matching the proto default
   * for {@code error_xdbc_code} so that unset and unmappable are indistinguishable downstream.
   */
  public static String extractSqlState(Throwable t) {
    int depth = 0;
    while (t != null && depth++ < 20) {
      if (t instanceof SQLException) {
        String sqlState = ((SQLException) t).getSQLState();
        if (sqlState != null && !sqlState.isEmpty()) {
          return sqlState;
        }
      }
      t = t.getCause();
    }
    return "";
  }

  /**
   * Registers the JVM shutdown hook that flushes pending telemetry.
   *
   * <p>Only reached from the instance-creation critical section of {@link
   * #getInstance(Properties)}, which already guarantees single execution, so no further guarding is
   * needed here.
   */
  private static void registerShutdownHook() {
    try {
      Runtime.getRuntime()
          .addShutdownHook(
              new Thread(
                  TelemetryManager::closeInstanceOnShutdown,
                  "bigquery-jdbc-telemetry-shutdown-hook"));
    } catch (IllegalStateException e) {
      // Thrown if the JVM is already in the process of shutting down
    } catch (SecurityException e) {
      logger.warning("SecurityManager prevented registering telemetry shutdown hook");
    }
  }

  /** Shutdown-hook body: flushes and closes the shared instance without propagating failures. */
  private static void closeInstanceOnShutdown() {
    try {
      closeInstance();
    } catch (Throwable t) {
      logger.warning("Error closing TelemetryManager during JVM shutdown");
    }
  }
}
