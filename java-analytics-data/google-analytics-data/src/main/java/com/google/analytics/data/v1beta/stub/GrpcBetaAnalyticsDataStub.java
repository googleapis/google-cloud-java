/*
 * Copyright 2022 Google LLC
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

package com.google.analytics.data.v1beta.stub;

import com.google.analytics.data.v1beta.BatchRunPivotReportsRequest;
import com.google.analytics.data.v1beta.BatchRunPivotReportsResponse;
import com.google.analytics.data.v1beta.BatchRunReportsRequest;
import com.google.analytics.data.v1beta.BatchRunReportsResponse;
import com.google.analytics.data.v1beta.CheckCompatibilityRequest;
import com.google.analytics.data.v1beta.CheckCompatibilityResponse;
import com.google.analytics.data.v1beta.GetMetadataRequest;
import com.google.analytics.data.v1beta.Metadata;
import com.google.analytics.data.v1beta.RunPivotReportRequest;
import com.google.analytics.data.v1beta.RunPivotReportResponse;
import com.google.analytics.data.v1beta.RunRealtimeReportRequest;
import com.google.analytics.data.v1beta.RunRealtimeReportResponse;
import com.google.analytics.data.v1beta.RunReportRequest;
import com.google.analytics.data.v1beta.RunReportResponse;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the BetaAnalyticsData service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcBetaAnalyticsDataStub extends BetaAnalyticsDataStub {
  private static final MethodDescriptor<RunReportRequest, RunReportResponse>
      runReportMethodDescriptor =
          MethodDescriptor.<RunReportRequest, RunReportResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.analytics.data.v1beta.BetaAnalyticsData/RunReport")
              .setRequestMarshaller(ProtoUtils.marshaller(RunReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RunReportResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RunPivotReportRequest, RunPivotReportResponse>
      runPivotReportMethodDescriptor =
          MethodDescriptor.<RunPivotReportRequest, RunPivotReportResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.analytics.data.v1beta.BetaAnalyticsData/RunPivotReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RunPivotReportRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RunPivotReportResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchRunReportsRequest, BatchRunReportsResponse>
      batchRunReportsMethodDescriptor =
          MethodDescriptor.<BatchRunReportsRequest, BatchRunReportsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.analytics.data.v1beta.BetaAnalyticsData/BatchRunReports")
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
                  "google.analytics.data.v1beta.BetaAnalyticsData/BatchRunPivotReports")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchRunPivotReportsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchRunPivotReportsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMetadataRequest, Metadata> getMetadataMethodDescriptor =
      MethodDescriptor.<GetMetadataRequest, Metadata>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.analytics.data.v1beta.BetaAnalyticsData/GetMetadata")
          .setRequestMarshaller(ProtoUtils.marshaller(GetMetadataRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Metadata.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<RunRealtimeReportRequest, RunRealtimeReportResponse>
      runRealtimeReportMethodDescriptor =
          MethodDescriptor.<RunRealtimeReportRequest, RunRealtimeReportResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.analytics.data.v1beta.BetaAnalyticsData/RunRealtimeReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RunRealtimeReportRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RunRealtimeReportResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CheckCompatibilityRequest, CheckCompatibilityResponse>
      checkCompatibilityMethodDescriptor =
          MethodDescriptor.<CheckCompatibilityRequest, CheckCompatibilityResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.data.v1beta.BetaAnalyticsData/CheckCompatibility")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CheckCompatibilityRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CheckCompatibilityResponse.getDefaultInstance()))
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
  private final UnaryCallable<CheckCompatibilityRequest, CheckCompatibilityResponse>
      checkCompatibilityCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBetaAnalyticsDataStub create(BetaAnalyticsDataStubSettings settings)
      throws IOException {
    return new GrpcBetaAnalyticsDataStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBetaAnalyticsDataStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcBetaAnalyticsDataStub(
        BetaAnalyticsDataStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBetaAnalyticsDataStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBetaAnalyticsDataStub(
        BetaAnalyticsDataStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBetaAnalyticsDataStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBetaAnalyticsDataStub(
      BetaAnalyticsDataStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcBetaAnalyticsDataCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBetaAnalyticsDataStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBetaAnalyticsDataStub(
      BetaAnalyticsDataStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<RunReportRequest, RunReportResponse> runReportTransportSettings =
        GrpcCallSettings.<RunReportRequest, RunReportResponse>newBuilder()
            .setMethodDescriptor(runReportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("property", String.valueOf(request.getProperty()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RunPivotReportRequest, RunPivotReportResponse>
        runPivotReportTransportSettings =
            GrpcCallSettings.<RunPivotReportRequest, RunPivotReportResponse>newBuilder()
                .setMethodDescriptor(runPivotReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("property", String.valueOf(request.getProperty()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<BatchRunReportsRequest, BatchRunReportsResponse>
        batchRunReportsTransportSettings =
            GrpcCallSettings.<BatchRunReportsRequest, BatchRunReportsResponse>newBuilder()
                .setMethodDescriptor(batchRunReportsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("property", String.valueOf(request.getProperty()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
        batchRunPivotReportsTransportSettings =
            GrpcCallSettings.<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>newBuilder()
                .setMethodDescriptor(batchRunPivotReportsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("property", String.valueOf(request.getProperty()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetMetadataRequest, Metadata> getMetadataTransportSettings =
        GrpcCallSettings.<GetMetadataRequest, Metadata>newBuilder()
            .setMethodDescriptor(getMetadataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RunRealtimeReportRequest, RunRealtimeReportResponse>
        runRealtimeReportTransportSettings =
            GrpcCallSettings.<RunRealtimeReportRequest, RunRealtimeReportResponse>newBuilder()
                .setMethodDescriptor(runRealtimeReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("property", String.valueOf(request.getProperty()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CheckCompatibilityRequest, CheckCompatibilityResponse>
        checkCompatibilityTransportSettings =
            GrpcCallSettings.<CheckCompatibilityRequest, CheckCompatibilityResponse>newBuilder()
                .setMethodDescriptor(checkCompatibilityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("property", String.valueOf(request.getProperty()));
                      return params.build();
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
    this.checkCompatibilityCallable =
        callableFactory.createUnaryCallable(
            checkCompatibilityTransportSettings,
            settings.checkCompatibilitySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<RunReportRequest, RunReportResponse> runReportCallable() {
    return runReportCallable;
  }

  @Override
  public UnaryCallable<RunPivotReportRequest, RunPivotReportResponse> runPivotReportCallable() {
    return runPivotReportCallable;
  }

  @Override
  public UnaryCallable<BatchRunReportsRequest, BatchRunReportsResponse> batchRunReportsCallable() {
    return batchRunReportsCallable;
  }

  @Override
  public UnaryCallable<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
      batchRunPivotReportsCallable() {
    return batchRunPivotReportsCallable;
  }

  @Override
  public UnaryCallable<GetMetadataRequest, Metadata> getMetadataCallable() {
    return getMetadataCallable;
  }

  @Override
  public UnaryCallable<RunRealtimeReportRequest, RunRealtimeReportResponse>
      runRealtimeReportCallable() {
    return runRealtimeReportCallable;
  }

  @Override
  public UnaryCallable<CheckCompatibilityRequest, CheckCompatibilityResponse>
      checkCompatibilityCallable() {
    return checkCompatibilityCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
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
