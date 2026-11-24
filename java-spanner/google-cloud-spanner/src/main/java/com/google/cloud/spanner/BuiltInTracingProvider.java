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
import com.google.common.base.Equivalence;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.ReadWriteSpan;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.SpanProcessor;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import java.util.function.BooleanSupplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jspecify.annotations.Nullable;

/**
 * Creates and caches the OpenTelemetry instances that are used for built-in tracing. One instance
 * is created per project, sampling rate and credentials object, so that spans are always exported
 * to the project of the client that created them, with the credentials of that client.
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
  private static final long SHUTDOWN_TIMEOUT_SECONDS = 10;
  @VisibleForTesting static final int MAX_OPEN_TELEMETRY_INSTANCES = 10;
  private static final AtomicBoolean credentialsWarningLogged = new AtomicBoolean();

  private final Map<List<Object>, OpenTelemetrySdk> openTelemetries = new HashMap<>();
  private final Set<List<Object>> failedKeys = new HashSet<>();
  private BiFunction<String, Credentials, SpanExporter> spanExporterFactory =
      BuiltInTracingProvider::createTelemetryApiExporter;
  private BooleanSupplier contextCheck = BuiltInTracingProvider::contextCanHoldSpans;
  private Boolean contextCanHoldSpans;
  private Thread shutdownHook;
  private boolean shutDown;
  private boolean openCensusWarningLogged;
  private boolean customTracingInfoLogged;
  private boolean notUsedInfoLogged;
  private boolean invalidSamplingRateWarningLogged;
  private boolean instanceLimitWarningLogged;

  private BuiltInTracingProvider() {}

  @Nullable
  synchronized OpenTelemetry getOrCreateOpenTelemetry(
      String projectId, Credentials credentials, double samplingRate) {
    if (shutDown || !isContextUsable()) {
      return null;
    }
    List<Object> key =
        ImmutableList.of(projectId, samplingRate, Equivalence.identity().wrap(credentials));
    if (failedKeys.contains(key)) {
      return null;
    }
    OpenTelemetrySdk openTelemetry = openTelemetries.get(key);
    if (openTelemetry == null) {
      if (openTelemetries.size() + failedKeys.size() >= MAX_OPEN_TELEMETRY_INSTANCES) {
        logInstanceLimitWarningOnce();
        return null;
      }
      try {
        openTelemetry =
            createOpenTelemetry(
                projectId, spanExporterFactory.apply(projectId, credentials), samplingRate);
      } catch (Throwable throwable) {
        failedKeys.add(key);
        logger.log(
            Level.WARNING,
            "Unable to create the exporter for built-in tracing, built-in tracing is disabled",
            throwable);
        return null;
      }
      if (shutdownHook == null) {
        Thread hook = new Thread(this::shutdown);
        try {
          Runtime.getRuntime().addShutdownHook(hook);
        } catch (IllegalStateException exception) {
          openTelemetry.close();
          return null;
        }
        shutdownHook = hook;
      }
      openTelemetries.put(key, openTelemetry);
    }
    return openTelemetry;
  }

  private boolean isContextUsable() {
    if (contextCanHoldSpans == null) {
      contextCanHoldSpans = contextCheck.getAsBoolean();
      if (!contextCanHoldSpans) {
        logger.log(
            Level.WARNING,
            "Built-in tracing is enabled, but spans of built-in tracing cannot be set as the"
                + " current span in this application, for example because the OpenTelemetry Java"
                + " agent is attached. Built-in tracing is not used. Enable tracing in the agent"
                + " instead.");
      }
    }
    return contextCanHoldSpans;
  }

  @VisibleForTesting
  static boolean contextCanHoldSpans() {
    try (SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder().addSpanProcessor(new NoopSpanProcessor()).build()) {
      Span span =
          tracerProvider
              .get(BuiltInTracingProvider.class.getName())
              .spanBuilder("check")
              .startSpan();
      try (Scope ignore = span.makeCurrent()) {
        return Span.current() == span;
      } finally {
        span.end();
      }
    } catch (Throwable throwable) {
      return false;
    }
  }

  private static final class NoopSpanProcessor implements SpanProcessor {
    @Override
    public void onStart(Context parentContext, ReadWriteSpan span) {}

    @Override
    public boolean isStartRequired() {
      return false;
    }

    @Override
    public void onEnd(ReadableSpan span) {}

    @Override
    public boolean isEndRequired() {
      return false;
    }
  }

  synchronized void logOpenCensusWarningOnce() {
    if (!openCensusWarningLogged) {
      openCensusWarningLogged = true;
      logger.log(
          Level.WARNING,
          "Built-in tracing is enabled, but OpenCensus is the tracing framework of this"
              + " application, because SpannerOptions.enableOpenCensusTraces() was called or a"
              + " Spanner client without built-in tracing was created first. Built-in tracing"
              + " requires OpenTelemetry and is not used. Call"
              + " SpannerOptions.enableOpenTelemetryTraces() before creating any Spanner client to"
              + " use built-in tracing.");
    }
  }

  synchronized void logNotUsedOnce(String reason) {
    if (!notUsedInfoLogged) {
      notUsedInfoLogged = true;
      logger.log(
          Level.INFO, "Built-in tracing is enabled, but it is not used with " + reason + ".");
    }
  }

  private void logInstanceLimitWarningOnce() {
    if (!instanceLimitWarningLogged) {
      instanceLimitWarningLogged = true;
      logger.log(
          Level.WARNING,
          "Built-in tracing already uses "
              + MAX_OPEN_TELEMETRY_INSTANCES
              + " OpenTelemetry instances, one for each combination of project, sampling rate and"
              + " credentials object. Built-in tracing is not used for new Spanner clients with"
              + " another combination. Use the same credentials object for clients that use the"
              + " same credentials.");
    }
  }

  synchronized void logInvalidSamplingRateOnce(String value) {
    if (!invalidSamplingRateWarningLogged) {
      invalidSamplingRateWarningLogged = true;
      logger.log(
          Level.WARNING,
          "The value of SPANNER_BUILTIN_TRACING_SAMPLING_RATE ("
              + value
              + ") is not a number between 0.0 and 1.0, so built-in tracing uses a sampling rate"
              + " of "
              + SpannerOptions.DEFAULT_BUILT_IN_TRACING_SAMPLING_RATE
              + ".");
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
  synchronized void setContextCheck(BooleanSupplier contextCheck) {
    this.contextCheck = contextCheck;
  }

  @VisibleForTesting
  synchronized void reset() {
    shutdown();
    shutDown = false;
    openTelemetries.clear();
    failedKeys.clear();
    if (shutdownHook != null) {
      try {
        Runtime.getRuntime().removeShutdownHook(shutdownHook);
      } catch (IllegalStateException ignore) {
      }
      shutdownHook = null;
    }
    spanExporterFactory = BuiltInTracingProvider::createTelemetryApiExporter;
    contextCheck = BuiltInTracingProvider::contextCanHoldSpans;
    contextCanHoldSpans = null;
    openCensusWarningLogged = false;
    customTracingInfoLogged = false;
    notUsedInfoLogged = false;
    invalidSamplingRateWarningLogged = false;
    instanceLimitWarningLogged = false;
    credentialsWarningLogged.set(false);
  }

  @VisibleForTesting
  void shutdown() {
    List<OpenTelemetrySdk> instances;
    synchronized (this) {
      shutDown = true;
      instances = new ArrayList<>(openTelemetries.values());
    }
    List<CompletableResultCode> results = new ArrayList<>();
    for (OpenTelemetrySdk openTelemetry : instances) {
      try {
        results.add(openTelemetry.shutdown());
      } catch (Throwable ignore) {
      }
    }
    CompletableResultCode.ofAll(results).join(SHUTDOWN_TIMEOUT_SECONDS, TimeUnit.SECONDS);
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
    return createOtlpExporter(TELEMETRY_API_ENDPOINT, credentials);
  }

  @VisibleForTesting
  static SpanExporter createOtlpExporter(String endpoint, Credentials credentials) {
    Credentials scopedCredentials =
        credentials instanceof GoogleCredentials
                && ((GoogleCredentials) credentials).createScopedRequired()
            ? ((GoogleCredentials) credentials).createScoped(CLOUD_PLATFORM_SCOPE)
            : credentials;
    return OtlpGrpcSpanExporter.builder()
        .setEndpoint(endpoint)
        .setHeaders(() -> getRequestHeaders(scopedCredentials))
        .setMeterProvider(MeterProvider.noop())
        .setComponentLoader(BuiltInTracingGrpcSender.componentLoader())
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
      credentialsWarningLogged.set(false);
      return headers;
    } catch (IOException exception) {
      if (credentialsWarningLogged.compareAndSet(false, true)) {
        logger.log(Level.WARNING, "Unable to get credentials for built-in tracing", exception);
      }
      return Collections.emptyMap();
    }
  }
}
