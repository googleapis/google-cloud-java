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

import static com.google.dataflow.v1beta3.JobsV1Beta3Client.AggregatedListJobsPagedResponse;
import static com.google.dataflow.v1beta3.JobsV1Beta3Client.ListJobsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.dataflow.v1beta3.CheckActiveJobsRequest;
import com.google.dataflow.v1beta3.CheckActiveJobsResponse;
import com.google.dataflow.v1beta3.CreateJobRequest;
import com.google.dataflow.v1beta3.GetJobRequest;
import com.google.dataflow.v1beta3.Job;
import com.google.dataflow.v1beta3.ListJobsRequest;
import com.google.dataflow.v1beta3.ListJobsResponse;
import com.google.dataflow.v1beta3.Snapshot;
import com.google.dataflow.v1beta3.SnapshotJobRequest;
import com.google.dataflow.v1beta3.UpdateJobRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the JobsV1Beta3 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcJobsV1Beta3Stub extends JobsV1Beta3Stub {
  private static final MethodDescriptor<CreateJobRequest, Job> createJobMethodDescriptor =
      MethodDescriptor.<CreateJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.dataflow.v1beta3.JobsV1Beta3/CreateJob")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetJobRequest, Job> getJobMethodDescriptor =
      MethodDescriptor.<GetJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.dataflow.v1beta3.JobsV1Beta3/GetJob")
          .setRequestMarshaller(ProtoUtils.marshaller(GetJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateJobRequest, Job> updateJobMethodDescriptor =
      MethodDescriptor.<UpdateJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.dataflow.v1beta3.JobsV1Beta3/UpdateJob")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListJobsRequest, ListJobsResponse>
      listJobsMethodDescriptor =
          MethodDescriptor.<ListJobsRequest, ListJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.dataflow.v1beta3.JobsV1Beta3/ListJobs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListJobsRequest, ListJobsResponse>
      aggregatedListJobsMethodDescriptor =
          MethodDescriptor.<ListJobsRequest, ListJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.dataflow.v1beta3.JobsV1Beta3/AggregatedListJobs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CheckActiveJobsRequest, CheckActiveJobsResponse>
      checkActiveJobsMethodDescriptor =
          MethodDescriptor.<CheckActiveJobsRequest, CheckActiveJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.dataflow.v1beta3.JobsV1Beta3/CheckActiveJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CheckActiveJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CheckActiveJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SnapshotJobRequest, Snapshot> snapshotJobMethodDescriptor =
      MethodDescriptor.<SnapshotJobRequest, Snapshot>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.dataflow.v1beta3.JobsV1Beta3/SnapshotJob")
          .setRequestMarshaller(ProtoUtils.marshaller(SnapshotJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Snapshot.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateJobRequest, Job> createJobCallable;
  private final UnaryCallable<GetJobRequest, Job> getJobCallable;
  private final UnaryCallable<UpdateJobRequest, Job> updateJobCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsResponse> aggregatedListJobsCallable;
  private final UnaryCallable<ListJobsRequest, AggregatedListJobsPagedResponse>
      aggregatedListJobsPagedCallable;
  private final UnaryCallable<CheckActiveJobsRequest, CheckActiveJobsResponse>
      checkActiveJobsCallable;
  private final UnaryCallable<SnapshotJobRequest, Snapshot> snapshotJobCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcJobsV1Beta3Stub create(JobsV1Beta3StubSettings settings)
      throws IOException {
    return new GrpcJobsV1Beta3Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcJobsV1Beta3Stub create(ClientContext clientContext) throws IOException {
    return new GrpcJobsV1Beta3Stub(JobsV1Beta3StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcJobsV1Beta3Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcJobsV1Beta3Stub(
        JobsV1Beta3StubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcJobsV1Beta3Stub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcJobsV1Beta3Stub(JobsV1Beta3StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcJobsV1Beta3CallableFactory());
  }

  /**
   * Constructs an instance of GrpcJobsV1Beta3Stub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcJobsV1Beta3Stub(
      JobsV1Beta3StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateJobRequest, Job> createJobTransportSettings =
        GrpcCallSettings.<CreateJobRequest, Job>newBuilder()
            .setMethodDescriptor(createJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("location", String.valueOf(request.getLocation()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetJobRequest, Job> getJobTransportSettings =
        GrpcCallSettings.<GetJobRequest, Job>newBuilder()
            .setMethodDescriptor(getJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("job_id", String.valueOf(request.getJobId()));
                  params.put("location", String.valueOf(request.getLocation()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateJobRequest, Job> updateJobTransportSettings =
        GrpcCallSettings.<UpdateJobRequest, Job>newBuilder()
            .setMethodDescriptor(updateJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("job_id", String.valueOf(request.getJobId()));
                  params.put("location", String.valueOf(request.getLocation()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListJobsRequest, ListJobsResponse> listJobsTransportSettings =
        GrpcCallSettings.<ListJobsRequest, ListJobsResponse>newBuilder()
            .setMethodDescriptor(listJobsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("location", String.valueOf(request.getLocation()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListJobsRequest, ListJobsResponse> aggregatedListJobsTransportSettings =
        GrpcCallSettings.<ListJobsRequest, ListJobsResponse>newBuilder()
            .setMethodDescriptor(aggregatedListJobsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CheckActiveJobsRequest, CheckActiveJobsResponse>
        checkActiveJobsTransportSettings =
            GrpcCallSettings.<CheckActiveJobsRequest, CheckActiveJobsResponse>newBuilder()
                .setMethodDescriptor(checkActiveJobsMethodDescriptor)
                .build();
    GrpcCallSettings<SnapshotJobRequest, Snapshot> snapshotJobTransportSettings =
        GrpcCallSettings.<SnapshotJobRequest, Snapshot>newBuilder()
            .setMethodDescriptor(snapshotJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("job_id", String.valueOf(request.getJobId()));
                  params.put("location", String.valueOf(request.getLocation()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  return params.build();
                })
            .build();

    this.createJobCallable =
        callableFactory.createUnaryCallable(
            createJobTransportSettings, settings.createJobSettings(), clientContext);
    this.getJobCallable =
        callableFactory.createUnaryCallable(
            getJobTransportSettings, settings.getJobSettings(), clientContext);
    this.updateJobCallable =
        callableFactory.createUnaryCallable(
            updateJobTransportSettings, settings.updateJobSettings(), clientContext);
    this.listJobsCallable =
        callableFactory.createUnaryCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.listJobsPagedCallable =
        callableFactory.createPagedCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.aggregatedListJobsCallable =
        callableFactory.createUnaryCallable(
            aggregatedListJobsTransportSettings,
            settings.aggregatedListJobsSettings(),
            clientContext);
    this.aggregatedListJobsPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListJobsTransportSettings,
            settings.aggregatedListJobsSettings(),
            clientContext);
    this.checkActiveJobsCallable =
        callableFactory.createUnaryCallable(
            checkActiveJobsTransportSettings, settings.checkActiveJobsSettings(), clientContext);
    this.snapshotJobCallable =
        callableFactory.createUnaryCallable(
            snapshotJobTransportSettings, settings.snapshotJobSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateJobRequest, Job> createJobCallable() {
    return createJobCallable;
  }

  @Override
  public UnaryCallable<GetJobRequest, Job> getJobCallable() {
    return getJobCallable;
  }

  @Override
  public UnaryCallable<UpdateJobRequest, Job> updateJobCallable() {
    return updateJobCallable;
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
  public UnaryCallable<ListJobsRequest, ListJobsResponse> aggregatedListJobsCallable() {
    return aggregatedListJobsCallable;
  }

  @Override
  public UnaryCallable<ListJobsRequest, AggregatedListJobsPagedResponse>
      aggregatedListJobsPagedCallable() {
    return aggregatedListJobsPagedCallable;
  }

  @Override
  public UnaryCallable<CheckActiveJobsRequest, CheckActiveJobsResponse> checkActiveJobsCallable() {
    return checkActiveJobsCallable;
  }

  @Override
  public UnaryCallable<SnapshotJobRequest, Snapshot> snapshotJobCallable() {
    return snapshotJobCallable;
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
