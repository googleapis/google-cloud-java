/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.analytics.data.v1alpha.stub;

import com.google.analytics.data.v1alpha.BatchRunPivotReportsRequest;
import com.google.analytics.data.v1alpha.BatchRunPivotReportsResponse;
import com.google.analytics.data.v1alpha.BatchRunReportsRequest;
import com.google.analytics.data.v1alpha.BatchRunReportsResponse;
import com.google.analytics.data.v1alpha.GetMetadataRequest;
import com.google.analytics.data.v1alpha.Metadata;
import com.google.analytics.data.v1alpha.RunPivotReportRequest;
import com.google.analytics.data.v1alpha.RunPivotReportResponse;
import com.google.analytics.data.v1alpha.RunRealtimeReportRequest;
import com.google.analytics.data.v1alpha.RunRealtimeReportResponse;
import com.google.analytics.data.v1alpha.RunReportRequest;
import com.google.analytics.data.v1alpha.RunReportResponse;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AlphaAnalyticsData service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAlphaAnalyticsDataStub extends AlphaAnalyticsDataStub {
  private static final MethodDescriptor<RunReportRequest, RunReportResponse>
      runReportMethodDescriptor =
          MethodDescriptor.<RunReportRequest, RunReportResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.analytics.data.v1alpha.AlphaAnalyticsData/RunReport")
              .setRequestMarshaller(ProtoUtils.marshaller(RunReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RunReportResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RunPivotReportRequest, RunPivotReportResponse>
      runPivotReportMethodDescriptor =
          MethodDescriptor.<RunPivotReportRequest, RunPivotReportResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.analytics.data.v1alpha.AlphaAnalyticsData/RunPivotReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RunPivotReportRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RunPivotReportResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchRunReportsRequest, BatchRunReportsResponse>
      batchRunReportsMethodDescriptor =
          MethodDescriptor.<BatchRunReportsRequest, BatchRunReportsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.analytics.data.v1alpha.AlphaAnalyticsData/BatchRunReports")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchRunReportsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchRunReportsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
      batchRunPivotReportsMethodDescriptor =
          MethodDescriptor.<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/BatchRunPivotReports")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchRunPivotReportsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchRunPivotReportsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMetadataRequest, Metadata> getMetadataMethodDescriptor =
      MethodDescriptor.<GetMetadataRequest, Metadata>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.analytics.data.v1alpha.AlphaAnalyticsData/GetMetadata")
          .setRequestMarshaller(ProtoUtils.marshaller(GetMetadataRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Metadata.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<RunRealtimeReportRequest, RunRealtimeReportResponse>
      runRealtimeReportMethodDescriptor =
          MethodDescriptor.<RunRealtimeReportRequest, RunRealtimeReportResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/RunRealtimeReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RunRealtimeReportRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RunRealtimeReportResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<RunReportRequest, RunReportResponse> runReportCallable;
  private final UnaryCallable<RunPivotReportRequest, RunPivotReportResponse> runPivotReportCallable;
  private final UnaryCallable<BatchRunReportsRequest, BatchRunReportsResponse>
      batchRunReportsCallable;
  private final UnaryCallable<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
      batchRunPivotReportsCallable;
  private final UnaryCallable<GetMetadataRequest, Metadata> getMetadataCallable;
  private final UnaryCallable<RunRealtimeReportRequest, RunRealtimeReportResponse>
      runRealtimeReportCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAlphaAnalyticsDataStub create(AlphaAnalyticsDataStubSettings settings)
      throws IOException {
    return new GrpcAlphaAnalyticsDataStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAlphaAnalyticsDataStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAlphaAnalyticsDataStub(
        AlphaAnalyticsDataStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAlphaAnalyticsDataStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAlphaAnalyticsDataStub(
        AlphaAnalyticsDataStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAlphaAnalyticsDataStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAlphaAnalyticsDataStub(
      AlphaAnalyticsDataStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAlphaAnalyticsDataCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAlphaAnalyticsDataStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAlphaAnalyticsDataStub(
      AlphaAnalyticsDataStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<RunReportRequest, RunReportResponse> runReportTransportSettings =
        GrpcCallSettings.<RunReportRequest, RunReportResponse>newBuilder()
            .setMethodDescriptor(runReportMethodDescriptor)
            .build();
    GrpcCallSettings<RunPivotReportRequest, RunPivotReportResponse>
        runPivotReportTransportSettings =
            GrpcCallSettings.<RunPivotReportRequest, RunPivotReportResponse>newBuilder()
                .setMethodDescriptor(runPivotReportMethodDescriptor)
                .build();
    GrpcCallSettings<BatchRunReportsRequest, BatchRunReportsResponse>
        batchRunReportsTransportSettings =
            GrpcCallSettings.<BatchRunReportsRequest, BatchRunReportsResponse>newBuilder()
                .setMethodDescriptor(batchRunReportsMethodDescriptor)
                .build();
    GrpcCallSettings<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
        batchRunPivotReportsTransportSettings =
            GrpcCallSettings.<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>newBuilder()
                .setMethodDescriptor(batchRunPivotReportsMethodDescriptor)
                .build();
    GrpcCallSettings<GetMetadataRequest, Metadata> getMetadataTransportSettings =
        GrpcCallSettings.<GetMetadataRequest, Metadata>newBuilder()
            .setMethodDescriptor(getMetadataMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetMetadataRequest>() {
                  @Override
                  public Map<String, String> extract(GetMetadataRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<RunRealtimeReportRequest, RunRealtimeReportResponse>
        runRealtimeReportTransportSettings =
            GrpcCallSettings.<RunRealtimeReportRequest, RunRealtimeReportResponse>newBuilder()
                .setMethodDescriptor(runRealtimeReportMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<RunRealtimeReportRequest>() {
                      @Override
                      public Map<String, String> extract(RunRealtimeReportRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("property", String.valueOf(request.getProperty()));
                        return params.build();
                      }
                    })
                .build();

    this.runReportCallable =
        callableFactory.createUnaryCallable(
            runReportTransportSettings, settings.runReportSettings(), clientContext);
    this.runPivotReportCallable =
        callableFactory.createUnaryCallable(
            runPivotReportTransportSettings, settings.runPivotReportSettings(), clientContext);
    this.batchRunReportsCallable =
        callableFactory.createUnaryCallable(
            batchRunReportsTransportSettings, settings.batchRunReportsSettings(), clientContext);
    this.batchRunPivotReportsCallable =
        callableFactory.createUnaryCallable(
            batchRunPivotReportsTransportSettings,
            settings.batchRunPivotReportsSettings(),
            clientContext);
    this.getMetadataCallable =
        callableFactory.createUnaryCallable(
            getMetadataTransportSettings, settings.getMetadataSettings(), clientContext);
    this.runRealtimeReportCallable =
        callableFactory.createUnaryCallable(
            runRealtimeReportTransportSettings,
            settings.runRealtimeReportSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<RunReportRequest, RunReportResponse> runReportCallable() {
    return runReportCallable;
  }

  public UnaryCallable<RunPivotReportRequest, RunPivotReportResponse> runPivotReportCallable() {
    return runPivotReportCallable;
  }

  public UnaryCallable<BatchRunReportsRequest, BatchRunReportsResponse> batchRunReportsCallable() {
    return batchRunReportsCallable;
  }

  public UnaryCallable<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
      batchRunPivotReportsCallable() {
    return batchRunPivotReportsCallable;
  }

  public UnaryCallable<GetMetadataRequest, Metadata> getMetadataCallable() {
    return getMetadataCallable;
  }

  public UnaryCallable<RunRealtimeReportRequest, RunRealtimeReportResponse>
      runRealtimeReportCallable() {
    return runRealtimeReportCallable;
  }

  @Override
  public final void close() {
    shutdown();
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
