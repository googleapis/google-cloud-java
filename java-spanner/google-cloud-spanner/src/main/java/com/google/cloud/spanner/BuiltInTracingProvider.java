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
import com.google.cloud.opentelemetry.trace.TraceConfiguration;
import com.google.cloud.opentelemetry.trace.TraceExporter;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import io.opentelemetry.sdk.trace.samplers.Sampler;
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

  private final Map<List<Object>, OpenTelemetrySdk> openTelemetries = new HashMap<>();
  private BiFunction<String, Credentials, SpanExporter> spanExporterFactory =
      BuiltInTracingProvider::createCloudTraceExporter;
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
            createOpenTelemetry(spanExporterFactory.apply(projectId, credentials), samplingRate);
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
              ? "Built-in tracing is enabled, but an OpenTelemetry instance was set with"
                  + " SpannerOptions.Builder#setOpenTelemetry. Spanner uses that instance instead"
                  + " of built-in tracing."
              : "Built-in tracing is enabled, but a global OpenTelemetry instance with tracing is"
                  + " registered, for example by the OpenTelemetry Java agent. Spanner uses that"
                  + " instance instead of built-in tracing.");
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
    spanExporterFactory = BuiltInTracingProvider::createCloudTraceExporter;
    openCensusWarningLogged = false;
    customTracingInfoLogged = false;
  }

  private synchronized void shutdown() {
    for (OpenTelemetrySdk openTelemetry : openTelemetries.values()) {
      openTelemetry.close();
    }
  }

  private static OpenTelemetrySdk createOpenTelemetry(
      SpanExporter spanExporter, double samplingRate) {
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .setSampler(Sampler.parentBased(Sampler.traceIdRatioBased(samplingRate)))
            .addSpanProcessor(BatchSpanProcessor.builder(spanExporter).build())
            .build();
    return OpenTelemetrySdk.builder()
        .setTracerProvider(tracerProvider)
        .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
        .build();
  }

  private static SpanExporter createCloudTraceExporter(String projectId, Credentials credentials) {
    return TraceExporter.createWithConfiguration(
        TraceConfiguration.builder().setProjectId(projectId).setCredentials(credentials).build());
  }
}
