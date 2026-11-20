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

package com.google.cloud.spanner;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jspecify.annotations.Nullable;

/**
 * Creates and caches the OpenTelemetry instances that are used for built-in tracing. One instance
 * is created per project and sampling rate, so that spans are always exported to the project of the
 * client that created them.
 */
final class BuiltInTracingProvider {

  static final BuiltInTracingProvider INSTANCE = new BuiltInTracingProvider();

  private static final Logger logger = Logger.getLogger(BuiltInTracingProvider.class.getName());

  private static final String TELEMETRY_API_ENDPOINT = "https://telemetry.googleapis.com";
  private static final String CLOUD_PLATFORM_SCOPE =
      "https://www.googleapis.com/auth/cloud-platform";
  private static final AttributeKey<String> GCP_PROJECT_ID_KEY =
      AttributeKey.stringKey("gcp.project_id");
  private static final AttributeKey<String> SERVICE_NAME_KEY =
      AttributeKey.stringKey("service.name");
  private static final String OTEL_SERVICE_NAME = "OTEL_SERVICE_NAME";

  private final Map<List<Object>, OpenTelemetrySdk> openTelemetries = new HashMap<>();
  private BiFunction<String, Credentials, SpanExporter> spanExporterFactory =
      BuiltInTracingProvider::createTelemetryApiExporter;
  private Thread shutdownHook;
  private boolean openCensusWarningLogged;
  private boolean customTracingInfoLogged;

  private BuiltInTracingProvider() {}

  @Nullable
  synchronized OpenTelemetry getOrCreateOpenTelemetry(
      String projectId, Credentials credentials, double samplingRate) {
    List<Object> key = ImmutableList.of(projectId, samplingRate);
    OpenTelemetrySdk openTelemetry = openTelemetries.get(key);
    if (openTelemetry == null) {
      try {
        openTelemetry =
            createOpenTelemetry(
                projectId, spanExporterFactory.apply(projectId, credentials), samplingRate);
      } catch (Throwable throwable) {
        logger.log(
            Level.WARNING,
            "Unable to create the exporter for built-in tracing, built-in tracing is disabled",
            throwable);
        return null;
      }
      openTelemetries.put(key, openTelemetry);
      if (shutdownHook == null) {
        shutdownHook = new Thread(this::shutdown);
        Runtime.getRuntime().addShutdownHook(shutdownHook);
      }
    }
    return openTelemetry;
  }

  synchronized void logOpenCensusWarningOnce() {
    if (!openCensusWarningLogged) {
      openCensusWarningLogged = true;
      logger.log(
          Level.WARNING,
          "Built-in tracing is enabled, but this application uses OpenCensus tracing. Built-in"
              + " tracing requires OpenTelemetry and is not used. Call"
              + " SpannerOptions.enableOpenTelemetryTraces() before creating any Spanner client to"
              + " use built-in tracing.");
    }
  }

  synchronized void logCustomTracingInfoOnce(boolean setInOptions) {
    if (!customTracingInfoLogged) {
      customTracingInfoLogged = true;
      logger.log(
          Level.INFO,
          setInOptions
              ? "Built-in tracing is enabled, but the OpenTelemetry instance that was set with"
                  + " SpannerOptions.Builder#setOpenTelemetry may have tracing. Spanner uses that"
                  + " instance instead of built-in tracing. If that instance only has metrics, use"
                  + " OpenTelemetry 1.67 or later, so that Spanner can detect this and use"
                  + " built-in tracing."
              : "Built-in tracing is enabled, but a global OpenTelemetry instance that may have"
                  + " tracing is registered, for example by the OpenTelemetry Java agent. Spanner"
                  + " uses that instance instead of built-in tracing. If that instance only has"
                  + " metrics, use OpenTelemetry 1.67 or later, so that Spanner can detect this"
                  + " and use built-in tracing.");
    }
  }

  @VisibleForTesting
  synchronized void setSpanExporterFactory(
      BiFunction<String, Credentials, SpanExporter> spanExporterFactory) {
    this.spanExporterFactory = spanExporterFactory;
  }

  @VisibleForTesting
  synchronized void reset() {
    shutdown();
    openTelemetries.clear();
    spanExporterFactory = BuiltInTracingProvider::createTelemetryApiExporter;
    openCensusWarningLogged = false;
    customTracingInfoLogged = false;
  }

  private synchronized void shutdown() {
    for (OpenTelemetrySdk openTelemetry : openTelemetries.values()) {
      openTelemetry.close();
    }
  }

  private static OpenTelemetrySdk createOpenTelemetry(
      String projectId, SpanExporter spanExporter, double samplingRate) {
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .setResource(createResource(projectId, System.getenv(OTEL_SERVICE_NAME)))
            .setSampler(Sampler.parentBased(Sampler.traceIdRatioBased(samplingRate)))
            .addSpanProcessor(BatchSpanProcessor.builder(spanExporter).build())
            .build();
    return OpenTelemetrySdk.builder()
        .setTracerProvider(tracerProvider)
        .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
        .build();
  }

  @VisibleForTesting
  static Resource createResource(String projectId, @Nullable String serviceName) {
    AttributesBuilder attributes = Attributes.builder().put(GCP_PROJECT_ID_KEY, projectId);
    if (!Strings.isNullOrEmpty(serviceName)) {
      attributes.put(SERVICE_NAME_KEY, serviceName);
    }
    return Resource.getDefault().merge(Resource.create(attributes.build()));
  }

  private static SpanExporter createTelemetryApiExporter(
      String projectId, Credentials credentials) {
    Credentials scopedCredentials =
        credentials instanceof GoogleCredentials
                && ((GoogleCredentials) credentials).createScopedRequired()
            ? ((GoogleCredentials) credentials).createScoped(CLOUD_PLATFORM_SCOPE)
            : credentials;
    return OtlpGrpcSpanExporter.builder()
        .setEndpoint(TELEMETRY_API_ENDPOINT)
        .setHeaders(() -> getRequestHeaders(scopedCredentials))
        .build();
  }

  @VisibleForTesting
  static Map<String, String> getRequestHeaders(Credentials credentials) {
    try {
      Map<String, String> headers = new HashMap<>();
      for (Map.Entry<String, List<String>> header :
          credentials.getRequestMetadata(URI.create(TELEMETRY_API_ENDPOINT)).entrySet()) {
        if (!header.getValue().isEmpty()) {
          headers.put(header.getKey(), header.getValue().get(0));
        }
      }
      return headers;
    } catch (IOException exception) {
      logger.log(Level.WARNING, "Unable to get credentials for built-in tracing", exception);
      return Collections.emptyMap();
    }
  }
}
