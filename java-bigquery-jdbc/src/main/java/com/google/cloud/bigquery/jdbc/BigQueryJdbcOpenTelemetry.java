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
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.autoconfigure.AutoConfiguredOpenTelemetrySdk;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class BigQueryJdbcOpenTelemetry {

  static final String INSTRUMENTATION_SCOPE_NAME = "com.google.cloud.bigquery.jdbc";
  static final String BIGQUERY_NAMESPACE = "com.google.cloud.bigquery";
  public static final String CONNECTION_ID_BAGGAGE_KEY = "jdbc.connection_id";
  public static final String DB_SYSTEM_KEY = "db.system";
  public static final String DB_SYSTEM_VALUE = "bigquery";
  public static final String DB_CONNECTION_ID_KEY = "db.connection_id";
  public static final String DB_APPLICATION_KEY = "db.application";
  public static final String DEFAULT_APPLICATION_NAME = "Google-BigQuery-JDBC-Driver";
  public static final String DB_STATEMENT_KEY = "db.statement";
  public static final String DB_STATEMENT_COUNT_KEY = "db.statement.count";
  public static final String DB_BATCH_STATEMENTS_KEY = "db.batch.statements";
  private static final String OTEL_TRACES_EXPORTER = "otel.traces.exporter";
  private static final String OTEL_EXPORTER_OTLP_ENDPOINT = "otel.exporter.otlp.endpoint";
  private static final String OTEL_LOGS_EXPORTER = "otel.logs.exporter";
  private static final String OTEL_METRICS_EXPORTER = "otel.metrics.exporter";
  private static final String GOOGLE_CLOUD_PROJECT = "google.cloud.project";
  private static final String OTLP_ENDPOINT_VALUE = "https://telemetry.googleapis.com:443";
  private static final URI OTLP_ENDPOINT_URI = URI.create(OTLP_ENDPOINT_VALUE);
  private static final String EXPORTER_NONE = "none";
  private static final String EXPORTER_OTLP = "otlp";
  private static final String OTEL_SPAN_ATTRIBUTE_VALUE_LENGTH_LIMIT =
      "otel.span.attribute.value.length.limit";
  private static final String OTEL_ATTRIBUTE_VALUE_LENGTH_LIMIT =
      "otel.attribute.value.length.limit";
  private static final String DEFAULT_ATTRIBUTE_LENGTH_LIMIT = "32768";
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

  public static synchronized void ensureGlobalHandlerAttached() {
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
    authProperties.put(
        BigQueryJdbcUrlUtility.OAUTH_TYPE_PROPERTY_NAME,
        BigQueryJdbcOAuthUtility.AuthType.GOOGLE_SERVICE_ACCOUNT.name()); // Service Account

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

  private static Map<String, String> getAuthHeaders(Credentials credentials) {
    try {
      Map<String, List<String>> metadata = credentials.getRequestMetadata(OTLP_ENDPOINT_URI);
      Map<String, String> headers = new HashMap<>();
      metadata.forEach(
          (headerKey, headerValues) -> {
            if (!headerValues.isEmpty()) {
              headers.put(headerKey, headerValues.get(0));
            }
          });
      return headers;
    } catch (Exception e) {
      // We log the warning and return an empty map, allowing the exporter to fail gracefully
      // with a standard OTLP response code (e.g., 401 Unauthorized) handled by OTel.
      LOG.warning(e, "Failed to get auth headers");
      return new HashMap<>();
    }
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
      boolean useGlobalOpenTelemetry,
      boolean enableGcpTraceExporter,
      boolean enableGcpLogExporter,
      OpenTelemetry customOpenTelemetry,
      String gcpTelemetryCredentials,
      String gcpTelemetryProjectId) {

    if (customOpenTelemetry != null) {
      return customOpenTelemetry;
    }

    if (useGlobalOpenTelemetry) {
      return GlobalOpenTelemetry.get();
    }

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

          // Set safe, generous default limits on attribute value lengths (32KB) to protect
          // customers from GCP Cloud Trace 64KB span ingestion failures when logging massive
          // exception stack traces or database schema metadata.
          // Respect any existing user configuration overrides.
          if (!props.containsKey(OTEL_SPAN_ATTRIBUTE_VALUE_LENGTH_LIMIT)) {
            props.put(OTEL_SPAN_ATTRIBUTE_VALUE_LENGTH_LIMIT, DEFAULT_ATTRIBUTE_LENGTH_LIMIT);
          }
          if (!props.containsKey(OTEL_ATTRIBUTE_VALUE_LENGTH_LIMIT)) {
            props.put(OTEL_ATTRIBUTE_VALUE_LENGTH_LIMIT, DEFAULT_ATTRIBUTE_LENGTH_LIMIT);
          }

          AutoConfiguredOpenTelemetrySdk autoConfigured =
              AutoConfiguredOpenTelemetrySdk.builder()
                  .addPropertiesSupplier(() -> props)
                  .addSpanExporterCustomizer(
                      (spanExporter, configProperties) -> {
                        if (gcpTelemetryCredentials == null) {
                          return spanExporter;
                        }
                        try {
                          Credentials credentials =
                              resolveCredentialsFromString(gcpTelemetryCredentials);
                          if (spanExporter instanceof OtlpHttpSpanExporter) {
                            return ((OtlpHttpSpanExporter) spanExporter)
                                .toBuilder().setHeaders(() -> getAuthHeaders(credentials)).build();
                          }
                          if (spanExporter instanceof OtlpGrpcSpanExporter) {
                            return ((OtlpGrpcSpanExporter) spanExporter)
                                .toBuilder().setHeaders(() -> getAuthHeaders(credentials)).build();
                          }
                        } catch (Exception e) {
                          LOG.warning(
                              e,
                              "Failed to resolve telemetry credentials. Telemetry will be exported using default OpenTelemetry configuration (custom authentication headers will not be injected).");
                        }
                        return spanExporter;
                      })
                  .build();

          OpenTelemetrySdk sdk = autoConfigured.getOpenTelemetrySdk();

          return sdk;
        });
  }

  /** Gets a Tracer for the JDBC driver instrumentation scope. */
  public static Tracer getTracer(OpenTelemetry openTelemetry) {
    return openTelemetry.getTracer(INSTRUMENTATION_SCOPE_NAME);
  }

  public static <T> T withTracing(
      String spanName, BigQueryConnection connection, String sql, Callable<T> operation)
      throws SQLException {

    Tracer tracer = connection.getTracer();
    Span span = tracer.spanBuilder(spanName).setSpanKind(SpanKind.CLIENT).startSpan();

    span.setAttribute(DB_SYSTEM_KEY, DB_SYSTEM_VALUE);
    span.setAttribute(DB_CONNECTION_ID_KEY, connection.getConnectionId());

    String appName = connection.getPartnerToken();
    if (appName == null || appName.isEmpty()) {
      appName = DEFAULT_APPLICATION_NAME;
    }
    span.setAttribute(DB_APPLICATION_KEY, appName);

    if (sql != null) {
      span.setAttribute(DB_STATEMENT_KEY, sql);
    }

    Baggage updatedBaggage =
        Baggage.fromContext(Context.current()).toBuilder()
            .put(CONNECTION_ID_BAGGAGE_KEY, connection.getConnectionId())
            .build();

    // Create full context with new span and updated baggage
    Context fullContext = Context.current().with(span).with(updatedBaggage);

    try (Scope scope = fullContext.makeCurrent()) {
      return operation.call();
    } catch (Exception ex) {
      span.recordException(ex);
      span.setStatus(StatusCode.ERROR, ex.getMessage());

      if (ex instanceof SQLException) {
        throw (SQLException) ex;
      }
      if (ex instanceof RuntimeException) {
        throw (RuntimeException) ex;
      }
      if (ex instanceof InterruptedException) {
        Thread.currentThread().interrupt();
        throw new BigQueryJdbcRuntimeException("Operation interrupted", ex);
      }
      throw new BigQueryJdbcRuntimeException(ex);
    } finally {
      span.end();
    }
  }
}
