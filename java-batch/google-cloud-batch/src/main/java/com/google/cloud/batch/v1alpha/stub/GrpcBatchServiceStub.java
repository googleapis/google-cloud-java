/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.batch.v1alpha.stub;

import static com.google.cloud.batch.v1alpha.BatchServiceClient.ListJobsPagedResponse;
import static com.google.cloud.batch.v1alpha.BatchServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.batch.v1alpha.BatchServiceClient.ListResourceAllowancesPagedResponse;
import static com.google.cloud.batch.v1alpha.BatchServiceClient.ListTasksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.batch.v1alpha.CreateJobRequest;
import com.google.cloud.batch.v1alpha.CreateResourceAllowanceRequest;
import com.google.cloud.batch.v1alpha.DeleteJobRequest;
import com.google.cloud.batch.v1alpha.DeleteResourceAllowanceRequest;
import com.google.cloud.batch.v1alpha.GetJobRequest;
import com.google.cloud.batch.v1alpha.GetResourceAllowanceRequest;
import com.google.cloud.batch.v1alpha.GetTaskRequest;
import com.google.cloud.batch.v1alpha.Job;
import com.google.cloud.batch.v1alpha.ListJobsRequest;
import com.google.cloud.batch.v1alpha.ListJobsResponse;
import com.google.cloud.batch.v1alpha.ListResourceAllowancesRequest;
import com.google.cloud.batch.v1alpha.ListResourceAllowancesResponse;
import com.google.cloud.batch.v1alpha.ListTasksRequest;
import com.google.cloud.batch.v1alpha.ListTasksResponse;
import com.google.cloud.batch.v1alpha.OperationMetadata;
import com.google.cloud.batch.v1alpha.ResourceAllowance;
import com.google.cloud.batch.v1alpha.Task;
import com.google.cloud.batch.v1alpha.UpdateJobRequest;
import com.google.cloud.batch.v1alpha.UpdateResourceAllowanceRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the BatchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcBatchServiceStub extends BatchServiceStub {
  private static final MethodDescriptor<CreateJobRequest, Job> createJobMethodDescriptor =
      MethodDescriptor.<CreateJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.batch.v1alpha.BatchService/CreateJob")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetJobRequest, Job> getJobMethodDescriptor =
      MethodDescriptor.<GetJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.batch.v1alpha.BatchService/GetJob")
          .setRequestMarshaller(ProtoUtils.marshaller(GetJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteJobRequest, Operation> deleteJobMethodDescriptor =
      MethodDescriptor.<DeleteJobRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.batch.v1alpha.BatchService/DeleteJob")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateJobRequest, Job> updateJobMethodDescriptor =
      MethodDescriptor.<UpdateJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.batch.v1alpha.BatchService/UpdateJob")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListJobsRequest, ListJobsResponse>
      listJobsMethodDescriptor =
          MethodDescriptor.<ListJobsRequest, ListJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.batch.v1alpha.BatchService/ListJobs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTaskRequest, Task> getTaskMethodDescriptor =
      MethodDescriptor.<GetTaskRequest, Task>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.batch.v1alpha.BatchService/GetTask")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTaskRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Task.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListTasksRequest, ListTasksResponse>
      listTasksMethodDescriptor =
          MethodDescriptor.<ListTasksRequest, ListTasksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.batch.v1alpha.BatchService/ListTasks")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTasksRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListTasksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateResourceAllowanceRequest, ResourceAllowance>
      createResourceAllowanceMethodDescriptor =
          MethodDescriptor.<CreateResourceAllowanceRequest, ResourceAllowance>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.batch.v1alpha.BatchService/CreateResourceAllowance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateResourceAllowanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ResourceAllowance.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetResourceAllowanceRequest, ResourceAllowance>
      getResourceAllowanceMethodDescriptor =
          MethodDescriptor.<GetResourceAllowanceRequest, ResourceAllowance>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.batch.v1alpha.BatchService/GetResourceAllowance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetResourceAllowanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ResourceAllowance.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteResourceAllowanceRequest, Operation>
      deleteResourceAllowanceMethodDescriptor =
          MethodDescriptor.<DeleteResourceAllowanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.batch.v1alpha.BatchService/DeleteResourceAllowance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteResourceAllowanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListResourceAllowancesRequest, ListResourceAllowancesResponse>
      listResourceAllowancesMethodDescriptor =
          MethodDescriptor
              .<ListResourceAllowancesRequest, ListResourceAllowancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.batch.v1alpha.BatchService/ListResourceAllowances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListResourceAllowancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListResourceAllowancesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateResourceAllowanceRequest, ResourceAllowance>
      updateResourceAllowanceMethodDescriptor =
          MethodDescriptor.<UpdateResourceAllowanceRequest, ResourceAllowance>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.batch.v1alpha.BatchService/UpdateResourceAllowance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateResourceAllowanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ResourceAllowance.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateJobRequest, Job> createJobCallable;
  private final UnaryCallable<GetJobRequest, Job> getJobCallable;
  private final UnaryCallable<DeleteJobRequest, Operation> deleteJobCallable;
  private final OperationCallable<DeleteJobRequest, Empty, OperationMetadata>
      deleteJobOperationCallable;
  private final UnaryCallable<UpdateJobRequest, Job> updateJobCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable;
  private final UnaryCallable<GetTaskRequest, Task> getTaskCallable;
  private final UnaryCallable<ListTasksRequest, ListTasksResponse> listTasksCallable;
  private final UnaryCallable<ListTasksRequest, ListTasksPagedResponse> listTasksPagedCallable;
  private final UnaryCallable<CreateResourceAllowanceRequest, ResourceAllowance>
      createResourceAllowanceCallable;
  private final UnaryCallable<GetResourceAllowanceRequest, ResourceAllowance>
      getResourceAllowanceCallable;
  private final UnaryCallable<DeleteResourceAllowanceRequest, Operation>
      deleteResourceAllowanceCallable;
  private final OperationCallable<DeleteResourceAllowanceRequest, Empty, OperationMetadata>
      deleteResourceAllowanceOperationCallable;
  private final UnaryCallable<ListResourceAllowancesRequest, ListResourceAllowancesResponse>
      listResourceAllowancesCallable;
  private final UnaryCallable<ListResourceAllowancesRequest, ListResourceAllowancesPagedResponse>
      listResourceAllowancesPagedCallable;
  private final UnaryCallable<UpdateResourceAllowanceRequest, ResourceAllowance>
      updateResourceAllowanceCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBatchServiceStub create(BatchServiceStubSettings settings)
      throws IOException {
    return new GrpcBatchServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBatchServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcBatchServiceStub(BatchServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBatchServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBatchServiceStub(
        BatchServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBatchServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcBatchServiceStub(BatchServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcBatchServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBatchServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcBatchServiceStub(
      BatchServiceStubSettings settings,
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
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetJobRequest, Job> getJobTransportSettings =
        GrpcCallSettings.<GetJobRequest, Job>newBuilder()
            .setMethodDescriptor(getJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteJobRequest, Operation> deleteJobTransportSettings =
        GrpcCallSettings.<DeleteJobRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateJobRequest, Job> updateJobTransportSettings =
        GrpcCallSettings.<UpdateJobRequest, Job>newBuilder()
            .setMethodDescriptor(updateJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("job.name", String.valueOf(request.getJob().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListJobsRequest, ListJobsResponse> listJobsTransportSettings =
        GrpcCallSettings.<ListJobsRequest, ListJobsResponse>newBuilder()
            .setMethodDescriptor(listJobsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetTaskRequest, Task> getTaskTransportSettings =
        GrpcCallSettings.<GetTaskRequest, Task>newBuilder()
            .setMethodDescriptor(getTaskMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTasksRequest, ListTasksResponse> listTasksTransportSettings =
        GrpcCallSettings.<ListTasksRequest, ListTasksResponse>newBuilder()
            .setMethodDescriptor(listTasksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateResourceAllowanceRequest, ResourceAllowance>
        createResourceAllowanceTransportSettings =
            GrpcCallSettings.<CreateResourceAllowanceRequest, ResourceAllowance>newBuilder()
                .setMethodDescriptor(createResourceAllowanceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetResourceAllowanceRequest, ResourceAllowance>
        getResourceAllowanceTransportSettings =
            GrpcCallSettings.<GetResourceAllowanceRequest, ResourceAllowance>newBuilder()
                .setMethodDescriptor(getResourceAllowanceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteResourceAllowanceRequest, Operation>
        deleteResourceAllowanceTransportSettings =
            GrpcCallSettings.<DeleteResourceAllowanceRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteResourceAllowanceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListResourceAllowancesRequest, ListResourceAllowancesResponse>
        listResourceAllowancesTransportSettings =
            GrpcCallSettings
                .<ListResourceAllowancesRequest, ListResourceAllowancesResponse>newBuilder()
                .setMethodDescriptor(listResourceAllowancesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateResourceAllowanceRequest, ResourceAllowance>
        updateResourceAllowanceTransportSettings =
            GrpcCallSettings.<UpdateResourceAllowanceRequest, ResourceAllowance>newBuilder()
                .setMethodDescriptor(updateResourceAllowanceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "resource_allowance.name",
                          String.valueOf(request.getResourceAllowance().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createJobCallable =
        callableFactory.createUnaryCallable(
            createJobTransportSettings, settings.createJobSettings(), clientContext);
    this.getJobCallable =
        callableFactory.createUnaryCallable(
            getJobTransportSettings, settings.getJobSettings(), clientContext);
    this.deleteJobCallable =
        callableFactory.createUnaryCallable(
            deleteJobTransportSettings, settings.deleteJobSettings(), clientContext);
    this.deleteJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteJobTransportSettings,
            settings.deleteJobOperationSettings(),
            clientContext,
            operationsStub);
    this.updateJobCallable =
        callableFactory.createUnaryCallable(
            updateJobTransportSettings, settings.updateJobSettings(), clientContext);
    this.listJobsCallable =
        callableFactory.createUnaryCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.listJobsPagedCallable =
        callableFactory.createPagedCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.getTaskCallable =
        callableFactory.createUnaryCallable(
            getTaskTransportSettings, settings.getTaskSettings(), clientContext);
    this.listTasksCallable =
        callableFactory.createUnaryCallable(
            listTasksTransportSettings, settings.listTasksSettings(), clientContext);
    this.listTasksPagedCallable =
        callableFactory.createPagedCallable(
            listTasksTransportSettings, settings.listTasksSettings(), clientContext);
    this.createResourceAllowanceCallable =
        callableFactory.createUnaryCallable(
            createResourceAllowanceTransportSettings,
            settings.createResourceAllowanceSettings(),
            clientContext);
    this.getResourceAllowanceCallable =
        callableFactory.createUnaryCallable(
            getResourceAllowanceTransportSettings,
            settings.getResourceAllowanceSettings(),
            clientContext);
    this.deleteResourceAllowanceCallable =
        callableFactory.createUnaryCallable(
            deleteResourceAllowanceTransportSettings,
            settings.deleteResourceAllowanceSettings(),
            clientContext);
    this.deleteResourceAllowanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteResourceAllowanceTransportSettings,
            settings.deleteResourceAllowanceOperationSettings(),
            clientContext,
            operationsStub);
    this.listResourceAllowancesCallable =
        callableFactory.createUnaryCallable(
            listResourceAllowancesTransportSettings,
            settings.listResourceAllowancesSettings(),
            clientContext);
    this.listResourceAllowancesPagedCallable =
        callableFactory.createPagedCallable(
            listResourceAllowancesTransportSettings,
            settings.listResourceAllowancesSettings(),
            clientContext);
    this.updateResourceAllowanceCallable =
        callableFactory.createUnaryCallable(
            updateResourceAllowanceTransportSettings,
            settings.updateResourceAllowanceSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

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
  public UnaryCallable<DeleteJobRequest, Operation> deleteJobCallable() {
    return deleteJobCallable;
  }

  @Override
  public OperationCallable<DeleteJobRequest, Empty, OperationMetadata>
      deleteJobOperationCallable() {
    return deleteJobOperationCallable;
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
  public UnaryCallable<GetTaskRequest, Task> getTaskCallable() {
    return getTaskCallable;
  }

  @Override
  public UnaryCallable<ListTasksRequest, ListTasksResponse> listTasksCallable() {
    return listTasksCallable;
  }

  @Override
  public UnaryCallable<ListTasksRequest, ListTasksPagedResponse> listTasksPagedCallable() {
    return listTasksPagedCallable;
  }

  @Override
  public UnaryCallable<CreateResourceAllowanceRequest, ResourceAllowance>
      createResourceAllowanceCallable() {
    return createResourceAllowanceCallable;
  }

  @Override
  public UnaryCallable<GetResourceAllowanceRequest, ResourceAllowance>
      getResourceAllowanceCallable() {
    return getResourceAllowanceCallable;
  }

  @Override
  public UnaryCallable<DeleteResourceAllowanceRequest, Operation>
      deleteResourceAllowanceCallable() {
    return deleteResourceAllowanceCallable;
  }

  @Override
  public OperationCallable<DeleteResourceAllowanceRequest, Empty, OperationMetadata>
      deleteResourceAllowanceOperationCallable() {
    return deleteResourceAllowanceOperationCallable;
  }

  @Override
  public UnaryCallable<ListResourceAllowancesRequest, ListResourceAllowancesResponse>
      listResourceAllowancesCallable() {
    return listResourceAllowancesCallable;
  }

  @Override
  public UnaryCallable<ListResourceAllowancesRequest, ListResourceAllowancesPagedResponse>
      listResourceAllowancesPagedCallable() {
    return listResourceAllowancesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateResourceAllowanceRequest, ResourceAllowance>
      updateResourceAllowanceCallable() {
    return updateResourceAllowanceCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
