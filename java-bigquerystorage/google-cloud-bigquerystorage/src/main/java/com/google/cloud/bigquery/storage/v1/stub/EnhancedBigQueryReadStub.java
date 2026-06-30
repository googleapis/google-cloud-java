/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.storage.v1.stub;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcRawCallableFactory;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.ScheduledRetryingExecutor;
import com.google.api.gax.retrying.StreamingRetryAlgorithm;
import com.google.api.gax.rpc.Callables;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.tracing.SpanName;
import com.google.api.gax.tracing.TracedServerStreamingCallable;
import com.google.cloud.bigquery.storage.v1.BigQueryReadGrpc;
import com.google.cloud.bigquery.storage.v1.BigQueryReadSettings;
import com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1.ReadSession;
import com.google.cloud.bigquery.storage.v1.Singletons;
import com.google.cloud.bigquery.storage.v1.SplitReadStreamRequest;
import com.google.cloud.bigquery.storage.v1.SplitReadStreamResponse;
import com.google.cloud.bigquery.storage.v1.stub.readrows.ApiResultRetryAlgorithm;
import com.google.cloud.bigquery.storage.v1.stub.readrows.ReadRowsRetryingCallable;
import com.google.common.collect.ImmutableMap;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.context.Scope;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Enhanced stub class for BigQuery Storage API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
public class EnhancedBigQueryReadStub implements BackgroundResource {

  private static final String TRACING_OUTER_CLIENT_NAME = "BigQueryStorage";
  private final GrpcBigQueryReadStub stub;
  private final BigQueryReadStubSettings stubSettings;
  private final BigQueryReadSettings.RetryAttemptListener readRowsRetryAttemptListener;
  private final ClientContext context;
  private boolean enableOpenTelemetryTracing = false;
  private Tracer openTelemetryTracer = null;

  public static EnhancedBigQueryReadStub create(EnhancedBigQueryReadStubSettings settings)
      throws IOException {
    return create(settings, null);
  }

  public static EnhancedBigQueryReadStub create(
      EnhancedBigQueryReadStubSettings settings,
      BigQueryReadSettings.RetryAttemptListener readRowsRetryAttemptListener)
      throws IOException {
    return create(settings, readRowsRetryAttemptListener, false, null);
  }

  public static EnhancedBigQueryReadStub create(
      EnhancedBigQueryReadStubSettings settings,
      BigQueryReadSettings.RetryAttemptListener readRowsRetryAttemptListener,
      boolean enableOpenTelemetryTracing,
      TracerProvider openTelemetryTracerProvider)
      throws IOException {
    // Configure the base settings.
    BigQueryReadStubSettings.Builder baseSettingsBuilder =
        BigQueryReadStubSettings.newBuilder()
            .setUniverseDomain(settings.getUniverseDomain())
            .setTransportChannelProvider(settings.getTransportChannelProvider())
            .setEndpoint(settings.getEndpoint())
            .setHeaderProvider(settings.getHeaderProvider())
            .setCredentialsProvider(settings.getCredentialsProvider())
            .setStreamWatchdogCheckInterval(settings.getStreamWatchdogCheckInterval())
            .setStreamWatchdogProvider(settings.getStreamWatchdogProvider())
            .setBackgroundExecutorProvider(settings.getBackgroundExecutorProvider());

    baseSettingsBuilder
        .createReadSessionSettings()
        .setRetryableCodes(settings.createReadSessionSettings().getRetryableCodes())
        .setRetrySettings(settings.createReadSessionSettings().getRetrySettings());

    baseSettingsBuilder
        .readRowsSettings()
        .setRetryableCodes(settings.readRowsSettings().getRetryableCodes())
        .setRetrySettings(settings.readRowsSettings().getRetrySettings())
        .setResumptionStrategy(settings.readRowsSettings().getResumptionStrategy())
        .setIdleTimeout(settings.readRowsSettings().getIdleTimeout());

    baseSettingsBuilder
        .splitReadStreamSettings()
        .setRetryableCodes(settings.splitReadStreamSettings().getRetryableCodes())
        .setRetrySettings(settings.splitReadStreamSettings().getRetrySettings());

    BigQueryReadStubSettings baseSettings = baseSettingsBuilder.build();
    ClientContext clientContext = ClientContext.create(baseSettings);
    GrpcBigQueryReadStub stub = new GrpcBigQueryReadStub(baseSettings, clientContext);
    return new EnhancedBigQueryReadStub(
        stub,
        baseSettings,
        readRowsRetryAttemptListener,
        clientContext,
        enableOpenTelemetryTracing,
        openTelemetryTracerProvider);
  }

  @InternalApi("Visible for testing")
  EnhancedBigQueryReadStub(
      GrpcBigQueryReadStub stub,
      BigQueryReadStubSettings stubSettings,
      BigQueryReadSettings.RetryAttemptListener readRowsRetryAttemptListener,
      ClientContext context,
      boolean enableOpenTelemetryTracing,
      TracerProvider openTelemetryTracerProvider) {
    this.stub = stub;
    this.stubSettings = stubSettings;
    this.readRowsRetryAttemptListener = readRowsRetryAttemptListener;
    this.context = context;
    this.enableOpenTelemetryTracing = enableOpenTelemetryTracing;
    if (enableOpenTelemetryTracing) {
      if (openTelemetryTracerProvider == null) {
        this.openTelemetryTracer =
            Singletons.getOpenTelemetry()
                .getTracerProvider()
                .tracerBuilder("com.google.cloud.bigquery.storage.v1.read.stub")
                .build();
      } else {
        this.openTelemetryTracer =
            openTelemetryTracerProvider
                .tracerBuilder("com.google.cloud.bigquery.storage.v1.read.stub")
                .build();
      }
    }
  }

  public UnaryCallable<CreateReadSessionRequest, ReadSession> createReadSessionCallable() {
    Span createReadSessionCallable = null;
    if (enableOpenTelemetryTracing) {
      createReadSessionCallable =
          openTelemetryTracer
              .spanBuilder(
                  "com.google.cloud.bigquery.storage.v1.read.stub.createReadSessionCallable")
              .startSpan();
    }
    try (Scope createReadSessionCallableScope =
        createReadSessionCallable != null ? createReadSessionCallable.makeCurrent() : null) {
      return stub.createReadSessionCallable();
    } finally {
      if (createReadSessionCallable != null) {
        createReadSessionCallable.end();
      }
    }
  }

  public ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> readRowsCallable() {
    Span readRowsCallable = null;
    if (enableOpenTelemetryTracing) {
      readRowsCallable =
          openTelemetryTracer
              .spanBuilder("com.google.cloud.bigquery.storage.v1.read.stub.readRowsCallable")
              .startSpan();
    }
    try (Scope readRowsCallableScope =
        readRowsCallable != null ? readRowsCallable.makeCurrent() : null) {
      ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> innerCallable =
          GrpcRawCallableFactory.createServerStreamingCallable(
              GrpcCallSettings.<ReadRowsRequest, ReadRowsResponse>newBuilder()
                  .setMethodDescriptor(BigQueryReadGrpc.getReadRowsMethod())
                  .setParamsExtractor(
                      new RequestParamsExtractor<ReadRowsRequest>() {
                        @Override
                        public Map<String, String> extract(ReadRowsRequest request) {
                          return ImmutableMap.of(
                              "read_stream", String.valueOf(request.getReadStream()));
                        }
                      })
                  .build(),
              stubSettings.readRowsSettings().getRetryableCodes());
      ServerStreamingCallSettings<ReadRowsRequest, ReadRowsResponse> callSettings =
          stubSettings.readRowsSettings();

      StreamingRetryAlgorithm<Void> retryAlgorithm =
          new StreamingRetryAlgorithm<>(
              new ApiResultRetryAlgorithm<Void>(readRowsRetryAttemptListener),
              new ExponentialRetryAlgorithm(callSettings.getRetrySettings(), context.getClock()));

      ScheduledRetryingExecutor<Void> retryingExecutor =
          new ScheduledRetryingExecutor<>(retryAlgorithm, context.getExecutor());

      if (context.getStreamWatchdog() != null) {
        innerCallable = Callables.watched(innerCallable, callSettings, context);
      }

      ReadRowsRetryingCallable outerCallable =
          new ReadRowsRetryingCallable(
              context.getDefaultCallContext(),
              innerCallable,
              retryingExecutor,
              callSettings.getResumptionStrategy());

      ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> traced =
          new TracedServerStreamingCallable<>(
              outerCallable,
              context.getTracerFactory(),
              SpanName.of(TRACING_OUTER_CLIENT_NAME, "ReadRows"));
      return traced.withDefaultCallContext(context.getDefaultCallContext());
    } finally {
      if (readRowsCallable != null) {
        readRowsCallable.end();
      }
    }
  }

  public UnaryCallable<SplitReadStreamRequest, SplitReadStreamResponse> splitReadStreamCallable() {
    Span splitReadStreamCallable = null;
    if (enableOpenTelemetryTracing) {
      splitReadStreamCallable =
          openTelemetryTracer
              .spanBuilder("com.google.cloud.bigquery.storage.v1.read.stub.splitReadStreamCallable")
              .startSpan();
    }
    try (Scope readRowsCallableScope =
        splitReadStreamCallable != null ? splitReadStreamCallable.makeCurrent() : null) {
      return stub.splitReadStreamCallable();
    } finally {
      if (splitReadStreamCallable != null) {
        splitReadStreamCallable.end();
      }
    }
  }

  @Override
  public void close() {
    Span close = null;
    if (enableOpenTelemetryTracing) {
      close =
          openTelemetryTracer
              .spanBuilder("com.google.cloud.bigquery.storage.v1.read.stub.close")
              .startSpan();
    }
    try (Scope closeScope = close != null ? close.makeCurrent() : null) {
      stub.close();
    } finally {
      if (close != null) {
        close.end();
      }
    }
  }

  @Override
  public void shutdown() {
    Span shutdown = null;
    if (enableOpenTelemetryTracing) {
      shutdown =
          openTelemetryTracer
              .spanBuilder("com.google.cloud.bigquery.storage.v1.read.stub.shutdown")
              .startSpan();
    }
    try (Scope shutdownScope = shutdown != null ? shutdown.makeCurrent() : null) {
      stub.shutdown();
    } finally {
      if (shutdown != null) {
        shutdown.end();
      }
    }
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    Span shutdownNow = null;
    if (enableOpenTelemetryTracing) {
      shutdownNow =
          openTelemetryTracer
              .spanBuilder("com.google.cloud.bigquery.storage.v1.read.stub.shutdownNow")
              .startSpan();
    }
    try (Scope shutdownNowScope = shutdownNow != null ? shutdownNow.makeCurrent() : null) {
      stub.shutdownNow();
    } finally {
      if (shutdownNow != null) {
        shutdownNow.end();
      }
    }
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    Span awaitTermination = null;
    if (enableOpenTelemetryTracing) {
      awaitTermination =
          openTelemetryTracer
              .spanBuilder("com.google.cloud.bigquery.storage.v1.read.stub.awaitTermination")
              .setAttribute("duration", duration)
              .setAttribute("unit", unit.toString())
              .startSpan();
    }
    try (Scope awaitTerminationScope =
        awaitTermination != null ? awaitTermination.makeCurrent() : null) {
      return stub.awaitTermination(duration, unit);
    } finally {
      if (awaitTermination != null) {
        awaitTermination.end();
      }
    }
  }

  public BigQueryReadStubSettings getStubSettings() {
    return stubSettings;
  }
}
