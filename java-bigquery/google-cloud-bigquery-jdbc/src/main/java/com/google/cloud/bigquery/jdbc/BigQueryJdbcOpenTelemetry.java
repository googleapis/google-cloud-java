/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.auth.Credentials;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.common.hash.Hashing;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.autoconfigure.AutoConfiguredOpenTelemetrySdk;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class BigQueryJdbcOpenTelemetry {

  static final String INSTRUMENTATION_SCOPE_NAME = "com.google.cloud.bigquery.jdbc";
  static final String BIGQUERY_NAMESPACE = "com.google.cloud.bigquery";
  public static final String CONNECTION_ID_BAGGAGE_KEY = "jdbc.connection_id";
  private static final String OTEL_TRACES_EXPORTER = "otel.traces.exporter";
  private static final String OTEL_EXPORTER_OTLP_ENDPOINT = "otel.exporter.otlp.endpoint";
  private static final String OTEL_LOGS_EXPORTER = "otel.logs.exporter";
  private static final String OTEL_METRICS_EXPORTER = "otel.metrics.exporter";
  private static final String GOOGLE_CLOUD_PROJECT = "google.cloud.project";
  private static final String CREDENTIALS_JSON = "google.cloud.credentials.json";
  private static final String CREDENTIALS_PATH = "google.cloud.credentials.path";
  private static final String OTLP_ENDPOINT_VALUE = "https://telemetry.googleapis.com:443";
  private static final String EXPORTER_NONE = "none";
  private static final String EXPORTER_OTLP = "otlp";
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger("BigQueryJdbcOpenTelemetry");

  private static final class SdkCacheKey {
    private final String projectId;
    private final String credentialsHashOrPath;
    private final boolean enableTrace;

    SdkCacheKey(String projectId, String credentialsHashOrPath, boolean enableTrace) {
      this.projectId = projectId;
      this.credentialsHashOrPath = credentialsHashOrPath;
      this.enableTrace = enableTrace;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      SdkCacheKey that = (SdkCacheKey) o;
      return enableTrace == that.enableTrace
          && Objects.equals(projectId, that.projectId)
          && Objects.equals(credentialsHashOrPath, that.credentialsHashOrPath);
    }

    @Override
    public int hashCode() {
      return Objects.hash(projectId, credentialsHashOrPath, enableTrace);
    }
  }

  private static final ConcurrentHashMap<SdkCacheKey, OpenTelemetrySdk> sdkCache =
      new ConcurrentHashMap<>();

  static class TelemetryConfig {
    final OpenTelemetry openTelemetry;
    final Logging loggingClient;
    final boolean useDirectGcpLogging;

    TelemetryConfig(
        OpenTelemetry openTelemetry, Logging loggingClient, Boolean useDirectGcpLogging) {
      this.openTelemetry = openTelemetry;
      this.loggingClient = loggingClient;
      this.useDirectGcpLogging = useDirectGcpLogging != null ? useDirectGcpLogging : false;
    }
  }

  private static final ConcurrentHashMap<String, TelemetryConfig> connectionConfigs =
      new ConcurrentHashMap<>();

  private BigQueryJdbcOpenTelemetry() {}

  static {
    ensureGlobalHandlerAttached();
    Runtime.getRuntime()
        .addShutdownHook(
            new Thread(
                () -> {
                  for (OpenTelemetrySdk sdk : sdkCache.values()) {
                    try {
                      sdk.close();
                    } catch (Exception e) {
                      // Ignore failures during shutdown to ensure all SDKs are attempted to be
                      // closed. Logging is avoided here because the logging system might have
                      // already been shut down by the JVM.
                    }
                  }
                }));
  }

  public static void ensureGlobalHandlerAttached() {
    Logger logger = Logger.getLogger(BIGQUERY_NAMESPACE);
    boolean present = false;
    for (Handler h : logger.getHandlers()) {
      if (h instanceof OpenTelemetryJulHandler) {
        present = true;
        break;
      }
    }
    if (!present) {
      logger.addHandler(new OpenTelemetryJulHandler());
    }
  }

  public static void registerConnection(
      String connectionId,
      OpenTelemetry openTelemetry,
      Logging loggingClient,
      Boolean useDirectGcpLogging) {
    connectionConfigs.put(
        connectionId, new TelemetryConfig(openTelemetry, loggingClient, useDirectGcpLogging));
  }

  public static void unregisterConnection(String connectionId) {
    TelemetryConfig config = connectionConfigs.remove(connectionId);
    if (config != null && config.loggingClient != null) {
      try {
        config.loggingClient.close();
      } catch (Exception e) {
        LOG.warning("Failed to close Logging client during unregister: %s", e.getMessage());
      }
    }
  }

  public static Logging createLoggingClient(
      boolean enableGcpLogExporter,
      OpenTelemetry customOpenTelemetry,
      String effectiveCredentials,
      String effectiveProjectId,
      Credentials fallbackCredentials) {

    if (!enableGcpLogExporter || customOpenTelemetry != null) {
      return null;
    }

    try {
      Credentials credentials;
      if (effectiveCredentials != null) {
        credentials = resolveCredentialsFromString(effectiveCredentials);
      } else {
        credentials = fallbackCredentials;
      }

      LoggingOptions.Builder loggingOptionsBuilder =
          LoggingOptions.newBuilder().setProjectId(effectiveProjectId);
      if (credentials != null) {
        loggingOptionsBuilder.setCredentials(credentials);
      }
      return loggingOptionsBuilder.build().getService();
    } catch (Exception e) {
      throw new BigQueryJdbcRuntimeException("Failed to initialize Logging client", e);
    }
  }

  private static Credentials resolveCredentialsFromString(String credsString) {
    Map<String, String> authProperties = new java.util.HashMap<>();
    authProperties.put(BigQueryJdbcUrlUtility.OAUTH_TYPE_PROPERTY_NAME, "0"); // Service Account

    byte[] credsBytes = credsString.getBytes(StandardCharsets.UTF_8);
    if (BigQueryJdbcOAuthUtility.isJson(credsBytes)) {
      authProperties.put(BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PROPERTY_NAME, credsString);
    } else {
      authProperties.put(BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PATH_PROPERTY_NAME, credsString);
    }

    return BigQueryJdbcOAuthUtility.getCredentials(
        authProperties,
        new java.util.HashMap<>(),
        false,
        BigQueryJdbcOpenTelemetry.class.getName());
  }

  public static TelemetryConfig getConnectionConfig(String connectionId) {
    return connectionConfigs.get(connectionId);
  }

  public static Collection<TelemetryConfig> getRegisteredConfigs() {
    return connectionConfigs.values();
  }

  private static String getCredentialsIdentifier(String credentials) {
    if (credentials == null) {
      return "";
    }
    byte[] credsBytes = credentials.getBytes(StandardCharsets.UTF_8);
    if (BigQueryJdbcOAuthUtility.isJson(credsBytes)) {
      return Hashing.sha256().hashString(credentials, StandardCharsets.UTF_8).toString();
    }
    return credentials;
  }

  /**
   * Initializes or returns the OpenTelemetry instance based on hybrid logic. Prefer
   * customOpenTelemetry if provided; fallback to an auto-configured GCP exporter if requested.
   */
  public static OpenTelemetry getOpenTelemetry(
      boolean enableGcpTraceExporter,
      boolean enableGcpLogExporter,
      OpenTelemetry customOpenTelemetry,
      String gcpTelemetryCredentials,
      String gcpTelemetryProjectId) {

    if (customOpenTelemetry != null) {
      return customOpenTelemetry;
    }

    // NOTE: Currently, tracing only fully supports Application Default Credentials (ADC).
    // Once b/503721589 is completed, Service Account (SA) will work as well.
    if (!enableGcpTraceExporter && !enableGcpLogExporter) {
      return OpenTelemetry.noop();
    }

    SdkCacheKey key =
        new SdkCacheKey(
            gcpTelemetryProjectId,
            getCredentialsIdentifier(gcpTelemetryCredentials),
            enableGcpTraceExporter);
    return sdkCache.computeIfAbsent(
        key,
        k -> {
          Map<String, String> props = new HashMap<>();
          if (gcpTelemetryCredentials != null) {
            byte[] credsBytes = gcpTelemetryCredentials.getBytes(StandardCharsets.UTF_8);
            if (BigQueryJdbcOAuthUtility.isJson(credsBytes)) {
              props.put(CREDENTIALS_JSON, gcpTelemetryCredentials);
            } else {
              props.put(CREDENTIALS_PATH, gcpTelemetryCredentials);
            }
          }

          if (enableGcpTraceExporter) {
            props.put(OTEL_TRACES_EXPORTER, EXPORTER_OTLP);
            props.put(OTEL_EXPORTER_OTLP_ENDPOINT, OTLP_ENDPOINT_VALUE);
          } else {
            props.put(OTEL_TRACES_EXPORTER, EXPORTER_NONE);
          }

          // Logs are handled directly via GCP logging
          props.put(OTEL_LOGS_EXPORTER, EXPORTER_NONE);
          // Metrics are deferred to a future phase
          props.put(OTEL_METRICS_EXPORTER, EXPORTER_NONE);

          if (gcpTelemetryProjectId != null) {
            props.put(GOOGLE_CLOUD_PROJECT, gcpTelemetryProjectId);
          }

          AutoConfiguredOpenTelemetrySdk autoConfigured =
              AutoConfiguredOpenTelemetrySdk.builder().addPropertiesSupplier(() -> props).build();

          OpenTelemetrySdk sdk = autoConfigured.getOpenTelemetrySdk();

          return sdk;
        });
  }

  /** Gets a Tracer for the JDBC driver instrumentation scope. */
  public static Tracer getTracer(OpenTelemetry openTelemetry) {
    return openTelemetry.getTracer(INSTRUMENTATION_SCOPE_NAME);
  }
}
