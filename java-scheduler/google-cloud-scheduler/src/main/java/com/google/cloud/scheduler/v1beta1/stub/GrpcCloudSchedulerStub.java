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

package com.google.cloud.scheduler.v1beta1.stub;

import static com.google.cloud.scheduler.v1beta1.CloudSchedulerClient.ListJobsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.scheduler.v1beta1.CreateJobRequest;
import com.google.cloud.scheduler.v1beta1.DeleteJobRequest;
import com.google.cloud.scheduler.v1beta1.GetJobRequest;
import com.google.cloud.scheduler.v1beta1.Job;
import com.google.cloud.scheduler.v1beta1.ListJobsRequest;
import com.google.cloud.scheduler.v1beta1.ListJobsResponse;
import com.google.cloud.scheduler.v1beta1.PauseJobRequest;
import com.google.cloud.scheduler.v1beta1.ResumeJobRequest;
import com.google.cloud.scheduler.v1beta1.RunJobRequest;
import com.google.cloud.scheduler.v1beta1.UpdateJobRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CloudScheduler service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcCloudSchedulerStub extends CloudSchedulerStub {
  private static final MethodDescriptor<ListJobsRequest, ListJobsResponse>
      listJobsMethodDescriptor =
          MethodDescriptor.<ListJobsRequest, ListJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.scheduler.v1beta1.CloudScheduler/ListJobs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetJobRequest, Job> getJobMethodDescriptor =
      MethodDescriptor.<GetJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.scheduler.v1beta1.CloudScheduler/GetJob")
          .setRequestMarshaller(ProtoUtils.marshaller(GetJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateJobRequest, Job> createJobMethodDescriptor =
      MethodDescriptor.<CreateJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.scheduler.v1beta1.CloudScheduler/CreateJob")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateJobRequest, Job> updateJobMethodDescriptor =
      MethodDescriptor.<UpdateJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.scheduler.v1beta1.CloudScheduler/UpdateJob")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteJobRequest, Empty> deleteJobMethodDescriptor =
      MethodDescriptor.<DeleteJobRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.scheduler.v1beta1.CloudScheduler/DeleteJob")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<PauseJobRequest, Job> pauseJobMethodDescriptor =
      MethodDescriptor.<PauseJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.scheduler.v1beta1.CloudScheduler/PauseJob")
          .setRequestMarshaller(ProtoUtils.marshaller(PauseJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ResumeJobRequest, Job> resumeJobMethodDescriptor =
      MethodDescriptor.<ResumeJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.scheduler.v1beta1.CloudScheduler/ResumeJob")
          .setRequestMarshaller(ProtoUtils.marshaller(ResumeJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<RunJobRequest, Job> runJobMethodDescriptor =
      MethodDescriptor.<RunJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.scheduler.v1beta1.CloudScheduler/RunJob")
          .setRequestMarshaller(ProtoUtils.marshaller(RunJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable;
  private final UnaryCallable<GetJobRequest, Job> getJobCallable;
  private final UnaryCallable<CreateJobRequest, Job> createJobCallable;
  private final UnaryCallable<UpdateJobRequest, Job> updateJobCallable;
  private final UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable;
  private final UnaryCallable<PauseJobRequest, Job> pauseJobCallable;
  private final UnaryCallable<ResumeJobRequest, Job> resumeJobCallable;
  private final UnaryCallable<RunJobRequest, Job> runJobCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudSchedulerStub create(CloudSchedulerStubSettings settings)
      throws IOException {
    return new GrpcCloudSchedulerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudSchedulerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCloudSchedulerStub(
        CloudSchedulerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudSchedulerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudSchedulerStub(
        CloudSchedulerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudSchedulerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCloudSchedulerStub(CloudSchedulerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCloudSchedulerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudSchedulerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCloudSchedulerStub(
      CloudSchedulerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListJobsRequest, ListJobsResponse> listJobsTransportSettings =
        GrpcCallSettings.<ListJobsRequest, ListJobsResponse>newBuilder()
            .setMethodDescriptor(listJobsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetJobRequest, Job> getJobTransportSettings =
        GrpcCallSettings.<GetJobRequest, Job>newBuilder()
            .setMethodDescriptor(getJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateJobRequest, Job> createJobTransportSettings =
        GrpcCallSettings.<CreateJobRequest, Job>newBuilder()
            .setMethodDescriptor(createJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateJobRequest, Job> updateJobTransportSettings =
        GrpcCallSettings.<UpdateJobRequest, Job>newBuilder()
            .setMethodDescriptor(updateJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("job.name", String.valueOf(request.getJob().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteJobRequest, Empty> deleteJobTransportSettings =
        GrpcCallSettings.<DeleteJobRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<PauseJobRequest, Job> pauseJobTransportSettings =
        GrpcCallSettings.<PauseJobRequest, Job>newBuilder()
            .setMethodDescriptor(pauseJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ResumeJobRequest, Job> resumeJobTransportSettings =
        GrpcCallSettings.<ResumeJobRequest, Job>newBuilder()
            .setMethodDescriptor(resumeJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RunJobRequest, Job> runJobTransportSettings =
        GrpcCallSettings.<RunJobRequest, Job>newBuilder()
            .setMethodDescriptor(runJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listJobsCallable =
        callableFactory.createUnaryCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.listJobsPagedCallable =
        callableFactory.createPagedCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.getJobCallable =
        callableFactory.createUnaryCallable(
            getJobTransportSettings, settings.getJobSettings(), clientContext);
    this.createJobCallable =
        callableFactory.createUnaryCallable(
            createJobTransportSettings, settings.createJobSettings(), clientContext);
    this.updateJobCallable =
        callableFactory.createUnaryCallable(
            updateJobTransportSettings, settings.updateJobSettings(), clientContext);
    this.deleteJobCallable =
        callableFactory.createUnaryCallable(
            deleteJobTransportSettings, settings.deleteJobSettings(), clientContext);
    this.pauseJobCallable =
        callableFactory.createUnaryCallable(
            pauseJobTransportSettings, settings.pauseJobSettings(), clientContext);
    this.resumeJobCallable =
        callableFactory.createUnaryCallable(
            resumeJobTransportSettings, settings.resumeJobSettings(), clientContext);
    this.runJobCallable =
        callableFactory.createUnaryCallable(
            runJobTransportSettings, settings.runJobSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    return listJobsCallable;
  }

  @Override
  public UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable() {
    return listJobsPagedCallable;
  }

  @Override
  public UnaryCallable<GetJobRequest, Job> getJobCallable() {
    return getJobCallable;
  }

  @Override
  public UnaryCallable<CreateJobRequest, Job> createJobCallable() {
    return createJobCallable;
  }

  @Override
  public UnaryCallable<UpdateJobRequest, Job> updateJobCallable() {
    return updateJobCallable;
  }

  @Override
  public UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    return deleteJobCallable;
  }

  @Override
  public UnaryCallable<PauseJobRequest, Job> pauseJobCallable() {
    return pauseJobCallable;
  }

  @Override
  public UnaryCallable<ResumeJobRequest, Job> resumeJobCallable() {
    return resumeJobCallable;
  }

  @Override
  public UnaryCallable<RunJobRequest, Job> runJobCallable() {
    return runJobCallable;
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
