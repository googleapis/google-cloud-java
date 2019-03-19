/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.talent.v4beta1.stub;

import static com.google.cloud.talent.v4beta1.JobServiceClient.ListJobsPagedResponse;
import static com.google.cloud.talent.v4beta1.JobServiceClient.SearchJobsForAlertPagedResponse;
import static com.google.cloud.talent.v4beta1.JobServiceClient.SearchJobsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest;
import com.google.cloud.talent.v4beta1.CreateJobRequest;
import com.google.cloud.talent.v4beta1.DeleteJobRequest;
import com.google.cloud.talent.v4beta1.GetJobRequest;
import com.google.cloud.talent.v4beta1.Job;
import com.google.cloud.talent.v4beta1.ListJobsRequest;
import com.google.cloud.talent.v4beta1.ListJobsResponse;
import com.google.cloud.talent.v4beta1.SearchJobsRequest;
import com.google.cloud.talent.v4beta1.SearchJobsResponse;
import com.google.cloud.talent.v4beta1.UpdateJobRequest;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Cloud Talent Solution API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcJobServiceStub extends JobServiceStub {

  private static final MethodDescriptor<CreateJobRequest, Job> createJobMethodDescriptor =
      MethodDescriptor.<CreateJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.talent.v4beta1.JobService/CreateJob")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<GetJobRequest, Job> getJobMethodDescriptor =
      MethodDescriptor.<GetJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.talent.v4beta1.JobService/GetJob")
          .setRequestMarshaller(ProtoUtils.marshaller(GetJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<UpdateJobRequest, Job> updateJobMethodDescriptor =
      MethodDescriptor.<UpdateJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.talent.v4beta1.JobService/UpdateJob")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<DeleteJobRequest, Empty> deleteJobMethodDescriptor =
      MethodDescriptor.<DeleteJobRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.talent.v4beta1.JobService/DeleteJob")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListJobsRequest, ListJobsResponse>
      listJobsMethodDescriptor =
          MethodDescriptor.<ListJobsRequest, ListJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4beta1.JobService/ListJobs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListJobsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<BatchDeleteJobsRequest, Empty>
      batchDeleteJobsMethodDescriptor =
          MethodDescriptor.<BatchDeleteJobsRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4beta1.JobService/BatchDeleteJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeleteJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<SearchJobsRequest, SearchJobsResponse>
      searchJobsMethodDescriptor =
          MethodDescriptor.<SearchJobsRequest, SearchJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4beta1.JobService/SearchJobs")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SearchJobsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<SearchJobsRequest, SearchJobsResponse>
      searchJobsForAlertMethodDescriptor =
          MethodDescriptor.<SearchJobsRequest, SearchJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4beta1.JobService/SearchJobsForAlert")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SearchJobsResponse.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<CreateJobRequest, Job> createJobCallable;
  private final UnaryCallable<GetJobRequest, Job> getJobCallable;
  private final UnaryCallable<UpdateJobRequest, Job> updateJobCallable;
  private final UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable;
  private final UnaryCallable<BatchDeleteJobsRequest, Empty> batchDeleteJobsCallable;
  private final UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsCallable;
  private final UnaryCallable<SearchJobsRequest, SearchJobsPagedResponse> searchJobsPagedCallable;
  private final UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsForAlertCallable;
  private final UnaryCallable<SearchJobsRequest, SearchJobsForAlertPagedResponse>
      searchJobsForAlertPagedCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcJobServiceStub create(JobServiceStubSettings settings)
      throws IOException {
    return new GrpcJobServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcJobServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcJobServiceStub(JobServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcJobServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcJobServiceStub(
        JobServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcJobServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcJobServiceStub(JobServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcJobServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcJobServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcJobServiceStub(
      JobServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    GrpcCallSettings<CreateJobRequest, Job> createJobTransportSettings =
        GrpcCallSettings.<CreateJobRequest, Job>newBuilder()
            .setMethodDescriptor(createJobMethodDescriptor)
            .build();
    GrpcCallSettings<GetJobRequest, Job> getJobTransportSettings =
        GrpcCallSettings.<GetJobRequest, Job>newBuilder()
            .setMethodDescriptor(getJobMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateJobRequest, Job> updateJobTransportSettings =
        GrpcCallSettings.<UpdateJobRequest, Job>newBuilder()
            .setMethodDescriptor(updateJobMethodDescriptor)
            .build();
    GrpcCallSettings<DeleteJobRequest, Empty> deleteJobTransportSettings =
        GrpcCallSettings.<DeleteJobRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteJobMethodDescriptor)
            .build();
    GrpcCallSettings<ListJobsRequest, ListJobsResponse> listJobsTransportSettings =
        GrpcCallSettings.<ListJobsRequest, ListJobsResponse>newBuilder()
            .setMethodDescriptor(listJobsMethodDescriptor)
            .build();
    GrpcCallSettings<BatchDeleteJobsRequest, Empty> batchDeleteJobsTransportSettings =
        GrpcCallSettings.<BatchDeleteJobsRequest, Empty>newBuilder()
            .setMethodDescriptor(batchDeleteJobsMethodDescriptor)
            .build();
    GrpcCallSettings<SearchJobsRequest, SearchJobsResponse> searchJobsTransportSettings =
        GrpcCallSettings.<SearchJobsRequest, SearchJobsResponse>newBuilder()
            .setMethodDescriptor(searchJobsMethodDescriptor)
            .build();
    GrpcCallSettings<SearchJobsRequest, SearchJobsResponse> searchJobsForAlertTransportSettings =
        GrpcCallSettings.<SearchJobsRequest, SearchJobsResponse>newBuilder()
            .setMethodDescriptor(searchJobsForAlertMethodDescriptor)
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
    this.deleteJobCallable =
        callableFactory.createUnaryCallable(
            deleteJobTransportSettings, settings.deleteJobSettings(), clientContext);
    this.listJobsCallable =
        callableFactory.createUnaryCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.listJobsPagedCallable =
        callableFactory.createPagedCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.batchDeleteJobsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteJobsTransportSettings, settings.batchDeleteJobsSettings(), clientContext);
    this.searchJobsCallable =
        callableFactory.createUnaryCallable(
            searchJobsTransportSettings, settings.searchJobsSettings(), clientContext);
    this.searchJobsPagedCallable =
        callableFactory.createPagedCallable(
            searchJobsTransportSettings, settings.searchJobsSettings(), clientContext);
    this.searchJobsForAlertCallable =
        callableFactory.createUnaryCallable(
            searchJobsForAlertTransportSettings,
            settings.searchJobsForAlertSettings(),
            clientContext);
    this.searchJobsForAlertPagedCallable =
        callableFactory.createPagedCallable(
            searchJobsForAlertTransportSettings,
            settings.searchJobsForAlertSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<CreateJobRequest, Job> createJobCallable() {
    return createJobCallable;
  }

  public UnaryCallable<GetJobRequest, Job> getJobCallable() {
    return getJobCallable;
  }

  public UnaryCallable<UpdateJobRequest, Job> updateJobCallable() {
    return updateJobCallable;
  }

  public UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    return deleteJobCallable;
  }

  public UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable() {
    return listJobsPagedCallable;
  }

  public UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    return listJobsCallable;
  }

  public UnaryCallable<BatchDeleteJobsRequest, Empty> batchDeleteJobsCallable() {
    return batchDeleteJobsCallable;
  }

  public UnaryCallable<SearchJobsRequest, SearchJobsPagedResponse> searchJobsPagedCallable() {
    return searchJobsPagedCallable;
  }

  public UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsCallable() {
    return searchJobsCallable;
  }

  public UnaryCallable<SearchJobsRequest, SearchJobsForAlertPagedResponse>
      searchJobsForAlertPagedCallable() {
    return searchJobsForAlertPagedCallable;
  }

  public UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsForAlertCallable() {
    return searchJobsForAlertCallable;
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
