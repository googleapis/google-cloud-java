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

package com.google.cloud.talent.v4.stub;

import static com.google.cloud.talent.v4.JobServiceClient.ListJobsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.talent.v4.BatchCreateJobsRequest;
import com.google.cloud.talent.v4.BatchCreateJobsResponse;
import com.google.cloud.talent.v4.BatchDeleteJobsRequest;
import com.google.cloud.talent.v4.BatchDeleteJobsResponse;
import com.google.cloud.talent.v4.BatchOperationMetadata;
import com.google.cloud.talent.v4.BatchUpdateJobsRequest;
import com.google.cloud.talent.v4.BatchUpdateJobsResponse;
import com.google.cloud.talent.v4.CreateJobRequest;
import com.google.cloud.talent.v4.DeleteJobRequest;
import com.google.cloud.talent.v4.GetJobRequest;
import com.google.cloud.talent.v4.Job;
import com.google.cloud.talent.v4.ListJobsRequest;
import com.google.cloud.talent.v4.ListJobsResponse;
import com.google.cloud.talent.v4.SearchJobsRequest;
import com.google.cloud.talent.v4.SearchJobsResponse;
import com.google.cloud.talent.v4.UpdateJobRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the JobService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcJobServiceStub extends JobServiceStub {
  private static final MethodDescriptor<CreateJobRequest, Job> createJobMethodDescriptor =
      MethodDescriptor.<CreateJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.talent.v4.JobService/CreateJob")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<BatchCreateJobsRequest, Operation>
      batchCreateJobsMethodDescriptor =
          MethodDescriptor.<BatchCreateJobsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4.JobService/BatchCreateJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetJobRequest, Job> getJobMethodDescriptor =
      MethodDescriptor.<GetJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.talent.v4.JobService/GetJob")
          .setRequestMarshaller(ProtoUtils.marshaller(GetJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateJobRequest, Job> updateJobMethodDescriptor =
      MethodDescriptor.<UpdateJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.talent.v4.JobService/UpdateJob")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<BatchUpdateJobsRequest, Operation>
      batchUpdateJobsMethodDescriptor =
          MethodDescriptor.<BatchUpdateJobsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4.JobService/BatchUpdateJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchUpdateJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteJobRequest, Empty> deleteJobMethodDescriptor =
      MethodDescriptor.<DeleteJobRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.talent.v4.JobService/DeleteJob")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<BatchDeleteJobsRequest, Operation>
      batchDeleteJobsMethodDescriptor =
          MethodDescriptor.<BatchDeleteJobsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4.JobService/BatchDeleteJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeleteJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListJobsRequest, ListJobsResponse>
      listJobsMethodDescriptor =
          MethodDescriptor.<ListJobsRequest, ListJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4.JobService/ListJobs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchJobsRequest, SearchJobsResponse>
      searchJobsMethodDescriptor =
          MethodDescriptor.<SearchJobsRequest, SearchJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4.JobService/SearchJobs")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SearchJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchJobsRequest, SearchJobsResponse>
      searchJobsForAlertMethodDescriptor =
          MethodDescriptor.<SearchJobsRequest, SearchJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.talent.v4.JobService/SearchJobsForAlert")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SearchJobsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateJobRequest, Job> createJobCallable;
  private final UnaryCallable<BatchCreateJobsRequest, Operation> batchCreateJobsCallable;
  private final OperationCallable<
          BatchCreateJobsRequest, BatchCreateJobsResponse, BatchOperationMetadata>
      batchCreateJobsOperationCallable;
  private final UnaryCallable<GetJobRequest, Job> getJobCallable;
  private final UnaryCallable<UpdateJobRequest, Job> updateJobCallable;
  private final UnaryCallable<BatchUpdateJobsRequest, Operation> batchUpdateJobsCallable;
  private final OperationCallable<
          BatchUpdateJobsRequest, BatchUpdateJobsResponse, BatchOperationMetadata>
      batchUpdateJobsOperationCallable;
  private final UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable;
  private final UnaryCallable<BatchDeleteJobsRequest, Operation> batchDeleteJobsCallable;
  private final OperationCallable<
          BatchDeleteJobsRequest, BatchDeleteJobsResponse, BatchOperationMetadata>
      batchDeleteJobsOperationCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable;
  private final UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsCallable;
  private final UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsForAlertCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
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
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateJobRequest, Job> createJobTransportSettings =
        GrpcCallSettings.<CreateJobRequest, Job>newBuilder()
            .setMethodDescriptor(createJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateJobRequest>() {
                  @Override
                  public Map<String, String> extract(CreateJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchCreateJobsRequest, Operation> batchCreateJobsTransportSettings =
        GrpcCallSettings.<BatchCreateJobsRequest, Operation>newBuilder()
            .setMethodDescriptor(batchCreateJobsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<BatchCreateJobsRequest>() {
                  @Override
                  public Map<String, String> extract(BatchCreateJobsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetJobRequest, Job> getJobTransportSettings =
        GrpcCallSettings.<GetJobRequest, Job>newBuilder()
            .setMethodDescriptor(getJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetJobRequest>() {
                  @Override
                  public Map<String, String> extract(GetJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateJobRequest, Job> updateJobTransportSettings =
        GrpcCallSettings.<UpdateJobRequest, Job>newBuilder()
            .setMethodDescriptor(updateJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateJobRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("job.name", String.valueOf(request.getJob().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchUpdateJobsRequest, Operation> batchUpdateJobsTransportSettings =
        GrpcCallSettings.<BatchUpdateJobsRequest, Operation>newBuilder()
            .setMethodDescriptor(batchUpdateJobsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<BatchUpdateJobsRequest>() {
                  @Override
                  public Map<String, String> extract(BatchUpdateJobsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteJobRequest, Empty> deleteJobTransportSettings =
        GrpcCallSettings.<DeleteJobRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteJobRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchDeleteJobsRequest, Operation> batchDeleteJobsTransportSettings =
        GrpcCallSettings.<BatchDeleteJobsRequest, Operation>newBuilder()
            .setMethodDescriptor(batchDeleteJobsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<BatchDeleteJobsRequest>() {
                  @Override
                  public Map<String, String> extract(BatchDeleteJobsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListJobsRequest, ListJobsResponse> listJobsTransportSettings =
        GrpcCallSettings.<ListJobsRequest, ListJobsResponse>newBuilder()
            .setMethodDescriptor(listJobsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListJobsRequest>() {
                  @Override
                  public Map<String, String> extract(ListJobsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SearchJobsRequest, SearchJobsResponse> searchJobsTransportSettings =
        GrpcCallSettings.<SearchJobsRequest, SearchJobsResponse>newBuilder()
            .setMethodDescriptor(searchJobsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SearchJobsRequest>() {
                  @Override
                  public Map<String, String> extract(SearchJobsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SearchJobsRequest, SearchJobsResponse> searchJobsForAlertTransportSettings =
        GrpcCallSettings.<SearchJobsRequest, SearchJobsResponse>newBuilder()
            .setMethodDescriptor(searchJobsForAlertMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SearchJobsRequest>() {
                  @Override
                  public Map<String, String> extract(SearchJobsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();

    this.createJobCallable =
        callableFactory.createUnaryCallable(
            createJobTransportSettings, settings.createJobSettings(), clientContext);
    this.batchCreateJobsCallable =
        callableFactory.createUnaryCallable(
            batchCreateJobsTransportSettings, settings.batchCreateJobsSettings(), clientContext);
    this.batchCreateJobsOperationCallable =
        callableFactory.createOperationCallable(
            batchCreateJobsTransportSettings,
            settings.batchCreateJobsOperationSettings(),
            clientContext,
            operationsStub);
    this.getJobCallable =
        callableFactory.createUnaryCallable(
            getJobTransportSettings, settings.getJobSettings(), clientContext);
    this.updateJobCallable =
        callableFactory.createUnaryCallable(
            updateJobTransportSettings, settings.updateJobSettings(), clientContext);
    this.batchUpdateJobsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateJobsTransportSettings, settings.batchUpdateJobsSettings(), clientContext);
    this.batchUpdateJobsOperationCallable =
        callableFactory.createOperationCallable(
            batchUpdateJobsTransportSettings,
            settings.batchUpdateJobsOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteJobCallable =
        callableFactory.createUnaryCallable(
            deleteJobTransportSettings, settings.deleteJobSettings(), clientContext);
    this.batchDeleteJobsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteJobsTransportSettings, settings.batchDeleteJobsSettings(), clientContext);
    this.batchDeleteJobsOperationCallable =
        callableFactory.createOperationCallable(
            batchDeleteJobsTransportSettings,
            settings.batchDeleteJobsOperationSettings(),
            clientContext,
            operationsStub);
    this.listJobsCallable =
        callableFactory.createUnaryCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.listJobsPagedCallable =
        callableFactory.createPagedCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.searchJobsCallable =
        callableFactory.createUnaryCallable(
            searchJobsTransportSettings, settings.searchJobsSettings(), clientContext);
    this.searchJobsForAlertCallable =
        callableFactory.createUnaryCallable(
            searchJobsForAlertTransportSettings,
            settings.searchJobsForAlertSettings(),
            clientContext);

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
  public UnaryCallable<BatchCreateJobsRequest, Operation> batchCreateJobsCallable() {
    return batchCreateJobsCallable;
  }

  @Override
  public OperationCallable<BatchCreateJobsRequest, BatchCreateJobsResponse, BatchOperationMetadata>
      batchCreateJobsOperationCallable() {
    return batchCreateJobsOperationCallable;
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
  public UnaryCallable<BatchUpdateJobsRequest, Operation> batchUpdateJobsCallable() {
    return batchUpdateJobsCallable;
  }

  @Override
  public OperationCallable<BatchUpdateJobsRequest, BatchUpdateJobsResponse, BatchOperationMetadata>
      batchUpdateJobsOperationCallable() {
    return batchUpdateJobsOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    return deleteJobCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteJobsRequest, Operation> batchDeleteJobsCallable() {
    return batchDeleteJobsCallable;
  }

  @Override
  public OperationCallable<BatchDeleteJobsRequest, BatchDeleteJobsResponse, BatchOperationMetadata>
      batchDeleteJobsOperationCallable() {
    return batchDeleteJobsOperationCallable;
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
  public UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsCallable() {
    return searchJobsCallable;
  }

  @Override
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
