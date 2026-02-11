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
package com.google.cloud.bigquery.storage.v1beta2.stub;

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
import com.google.cloud.bigquery.storage.v1beta2.BigQueryReadGrpc;
import com.google.cloud.bigquery.storage.v1beta2.BigQueryReadSettings;
import com.google.cloud.bigquery.storage.v1beta2.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1beta2.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta2.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1beta2.ReadSession;
import com.google.cloud.bigquery.storage.v1beta2.SplitReadStreamRequest;
import com.google.cloud.bigquery.storage.v1beta2.SplitReadStreamResponse;
import com.google.cloud.bigquery.storage.v1beta2.stub.readrows.ApiResultRetryAlgorithm;
import com.google.cloud.bigquery.storage.v1beta2.stub.readrows.ReadRowsRetryingCallable;
import com.google.common.collect.ImmutableMap;
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

  public static EnhancedBigQueryReadStub create(EnhancedBigQueryReadStubSettings settings)
      throws IOException {
    return create(settings, null);
  }

  public static EnhancedBigQueryReadStub create(
      EnhancedBigQueryReadStubSettings settings,
      BigQueryReadSettings.RetryAttemptListener readRowsRetryAttemptListener)
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
            .setStreamWatchdogProvider(settings.getStreamWatchdogProvider());

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
        stub, baseSettings, readRowsRetryAttemptListener, clientContext);
  }

  @InternalApi("Visible for testing")
  EnhancedBigQueryReadStub(
      GrpcBigQueryReadStub stub,
      BigQueryReadStubSettings stubSettings,
      BigQueryReadSettings.RetryAttemptListener readRowsRetryAttemptListener,
      ClientContext context) {
    this.stub = stub;
    this.stubSettings = stubSettings;
    this.readRowsRetryAttemptListener = readRowsRetryAttemptListener;
    this.context = context;
  }

  public UnaryCallable<CreateReadSessionRequest, ReadSession> createReadSessionCallable() {
    return stub.createReadSessionCallable();
  }

  public ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> readRowsCallable() {
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
  }

  public UnaryCallable<SplitReadStreamRequest, SplitReadStreamResponse> splitReadStreamCallable() {
    return stub.splitReadStreamCallable();
  }

  @Override
  public void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
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
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }
}
