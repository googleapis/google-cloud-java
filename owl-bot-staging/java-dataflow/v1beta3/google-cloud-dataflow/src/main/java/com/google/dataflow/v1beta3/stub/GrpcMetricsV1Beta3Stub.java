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

package com.google.dataflow.v1beta3.stub;

import static com.google.dataflow.v1beta3.MetricsV1Beta3Client.GetJobExecutionDetailsPagedResponse;
import static com.google.dataflow.v1beta3.MetricsV1Beta3Client.GetStageExecutionDetailsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.dataflow.v1beta3.GetJobExecutionDetailsRequest;
import com.google.dataflow.v1beta3.GetJobMetricsRequest;
import com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest;
import com.google.dataflow.v1beta3.JobExecutionDetails;
import com.google.dataflow.v1beta3.JobMetrics;
import com.google.dataflow.v1beta3.StageExecutionDetails;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MetricsV1Beta3 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcMetricsV1Beta3Stub extends MetricsV1Beta3Stub {
  private static final MethodDescriptor<GetJobMetricsRequest, JobMetrics>
      getJobMetricsMethodDescriptor =
          MethodDescriptor.<GetJobMetricsRequest, JobMetrics>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.dataflow.v1beta3.MetricsV1Beta3/GetJobMetrics")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetJobMetricsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(JobMetrics.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetJobExecutionDetailsRequest, JobExecutionDetails>
      getJobExecutionDetailsMethodDescriptor =
          MethodDescriptor.<GetJobExecutionDetailsRequest, JobExecutionDetails>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.dataflow.v1beta3.MetricsV1Beta3/GetJobExecutionDetails")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetJobExecutionDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(JobExecutionDetails.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetStageExecutionDetailsRequest, StageExecutionDetails>
      getStageExecutionDetailsMethodDescriptor =
          MethodDescriptor.<GetStageExecutionDetailsRequest, StageExecutionDetails>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.dataflow.v1beta3.MetricsV1Beta3/GetStageExecutionDetails")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetStageExecutionDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StageExecutionDetails.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetJobMetricsRequest, JobMetrics> getJobMetricsCallable;
  private final UnaryCallable<GetJobExecutionDetailsRequest, JobExecutionDetails>
      getJobExecutionDetailsCallable;
  private final UnaryCallable<GetJobExecutionDetailsRequest, GetJobExecutionDetailsPagedResponse>
      getJobExecutionDetailsPagedCallable;
  private final UnaryCallable<GetStageExecutionDetailsRequest, StageExecutionDetails>
      getStageExecutionDetailsCallable;
  private final UnaryCallable<
          GetStageExecutionDetailsRequest, GetStageExecutionDetailsPagedResponse>
      getStageExecutionDetailsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMetricsV1Beta3Stub create(MetricsV1Beta3StubSettings settings)
      throws IOException {
    return new GrpcMetricsV1Beta3Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcMetricsV1Beta3Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMetricsV1Beta3Stub(
        MetricsV1Beta3StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMetricsV1Beta3Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMetricsV1Beta3Stub(
        MetricsV1Beta3StubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMetricsV1Beta3Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetricsV1Beta3Stub(MetricsV1Beta3StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcMetricsV1Beta3CallableFactory());
  }

  /**
   * Constructs an instance of GrpcMetricsV1Beta3Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetricsV1Beta3Stub(
      MetricsV1Beta3StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetJobMetricsRequest, JobMetrics> getJobMetricsTransportSettings =
        GrpcCallSettings.<GetJobMetricsRequest, JobMetrics>newBuilder()
            .setMethodDescriptor(getJobMetricsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("job_id", String.valueOf(request.getJobId()));
                  params.put("location", String.valueOf(request.getLocation()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetJobExecutionDetailsRequest, JobExecutionDetails>
        getJobExecutionDetailsTransportSettings =
            GrpcCallSettings.<GetJobExecutionDetailsRequest, JobExecutionDetails>newBuilder()
                .setMethodDescriptor(getJobExecutionDetailsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("job_id", String.valueOf(request.getJobId()));
                      params.put("location", String.valueOf(request.getLocation()));
                      params.put("project_id", String.valueOf(request.getProjectId()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetStageExecutionDetailsRequest, StageExecutionDetails>
        getStageExecutionDetailsTransportSettings =
            GrpcCallSettings.<GetStageExecutionDetailsRequest, StageExecutionDetails>newBuilder()
                .setMethodDescriptor(getStageExecutionDetailsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("job_id", String.valueOf(request.getJobId()));
                      params.put("location", String.valueOf(request.getLocation()));
                      params.put("project_id", String.valueOf(request.getProjectId()));
                      params.put("stage_id", String.valueOf(request.getStageId()));
                      return params.build();
                    })
                .build();

    this.getJobMetricsCallable =
        callableFactory.createUnaryCallable(
            getJobMetricsTransportSettings, settings.getJobMetricsSettings(), clientContext);
    this.getJobExecutionDetailsCallable =
        callableFactory.createUnaryCallable(
            getJobExecutionDetailsTransportSettings,
            settings.getJobExecutionDetailsSettings(),
            clientContext);
    this.getJobExecutionDetailsPagedCallable =
        callableFactory.createPagedCallable(
            getJobExecutionDetailsTransportSettings,
            settings.getJobExecutionDetailsSettings(),
            clientContext);
    this.getStageExecutionDetailsCallable =
        callableFactory.createUnaryCallable(
            getStageExecutionDetailsTransportSettings,
            settings.getStageExecutionDetailsSettings(),
            clientContext);
    this.getStageExecutionDetailsPagedCallable =
        callableFactory.createPagedCallable(
            getStageExecutionDetailsTransportSettings,
            settings.getStageExecutionDetailsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetJobMetricsRequest, JobMetrics> getJobMetricsCallable() {
    return getJobMetricsCallable;
  }

  @Override
  public UnaryCallable<GetJobExecutionDetailsRequest, JobExecutionDetails>
      getJobExecutionDetailsCallable() {
    return getJobExecutionDetailsCallable;
  }

  @Override
  public UnaryCallable<GetJobExecutionDetailsRequest, GetJobExecutionDetailsPagedResponse>
      getJobExecutionDetailsPagedCallable() {
    return getJobExecutionDetailsPagedCallable;
  }

  @Override
  public UnaryCallable<GetStageExecutionDetailsRequest, StageExecutionDetails>
      getStageExecutionDetailsCallable() {
    return getStageExecutionDetailsCallable;
  }

  @Override
  public UnaryCallable<GetStageExecutionDetailsRequest, GetStageExecutionDetailsPagedResponse>
      getStageExecutionDetailsPagedCallable() {
    return getStageExecutionDetailsPagedCallable;
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
