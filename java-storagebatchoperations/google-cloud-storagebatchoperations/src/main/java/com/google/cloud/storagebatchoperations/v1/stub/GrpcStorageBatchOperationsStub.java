/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storagebatchoperations.v1.stub;

import static com.google.cloud.storagebatchoperations.v1.StorageBatchOperationsClient.ListJobsPagedResponse;
import static com.google.cloud.storagebatchoperations.v1.StorageBatchOperationsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.storagebatchoperations.v1.CancelJobRequest;
import com.google.cloud.storagebatchoperations.v1.CancelJobResponse;
import com.google.cloud.storagebatchoperations.v1.CreateJobRequest;
import com.google.cloud.storagebatchoperations.v1.DeleteJobRequest;
import com.google.cloud.storagebatchoperations.v1.GetJobRequest;
import com.google.cloud.storagebatchoperations.v1.Job;
import com.google.cloud.storagebatchoperations.v1.ListJobsRequest;
import com.google.cloud.storagebatchoperations.v1.ListJobsResponse;
import com.google.cloud.storagebatchoperations.v1.OperationMetadata;
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
 * gRPC stub implementation for the StorageBatchOperations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcStorageBatchOperationsStub extends StorageBatchOperationsStub {
  private static final MethodDescriptor<ListJobsRequest, ListJobsResponse>
      listJobsMethodDescriptor =
          MethodDescriptor.<ListJobsRequest, ListJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.storagebatchoperations.v1.StorageBatchOperations/ListJobs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListJobsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetJobRequest, Job> getJobMethodDescriptor =
      MethodDescriptor.<GetJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.storagebatchoperations.v1.StorageBatchOperations/GetJob")
          .setRequestMarshaller(ProtoUtils.marshaller(GetJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateJobRequest, Operation> createJobMethodDescriptor =
      MethodDescriptor.<CreateJobRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.storagebatchoperations.v1.StorageBatchOperations/CreateJob")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteJobRequest, Empty> deleteJobMethodDescriptor =
      MethodDescriptor.<DeleteJobRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.storagebatchoperations.v1.StorageBatchOperations/DeleteJob")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CancelJobRequest, CancelJobResponse>
      cancelJobMethodDescriptor =
          MethodDescriptor.<CancelJobRequest, CancelJobResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.storagebatchoperations.v1.StorageBatchOperations/CancelJob")
              .setRequestMarshaller(ProtoUtils.marshaller(CancelJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CancelJobResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable;
  private final UnaryCallable<GetJobRequest, Job> getJobCallable;
  private final UnaryCallable<CreateJobRequest, Operation> createJobCallable;
  private final OperationCallable<CreateJobRequest, Job, OperationMetadata>
      createJobOperationCallable;
  private final UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable;
  private final UnaryCallable<CancelJobRequest, CancelJobResponse> cancelJobCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcStorageBatchOperationsStub create(
      StorageBatchOperationsStubSettings settings) throws IOException {
    return new GrpcStorageBatchOperationsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcStorageBatchOperationsStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcStorageBatchOperationsStub(
        StorageBatchOperationsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcStorageBatchOperationsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcStorageBatchOperationsStub(
        StorageBatchOperationsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcStorageBatchOperationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcStorageBatchOperationsStub(
      StorageBatchOperationsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcStorageBatchOperationsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcStorageBatchOperationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcStorageBatchOperationsStub(
      StorageBatchOperationsStubSettings settings,
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
    GrpcCallSettings<CreateJobRequest, Operation> createJobTransportSettings =
        GrpcCallSettings.<CreateJobRequest, Operation>newBuilder()
            .setMethodDescriptor(createJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteJobRequest, Empty> deleteJobTransportSettings =
        GrpcCallSettings.<DeleteJobRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CancelJobRequest, CancelJobResponse> cancelJobTransportSettings =
        GrpcCallSettings.<CancelJobRequest, CancelJobResponse>newBuilder()
            .setMethodDescriptor(cancelJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
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
    this.createJobOperationCallable =
        callableFactory.createOperationCallable(
            createJobTransportSettings,
            settings.createJobOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteJobCallable =
        callableFactory.createUnaryCallable(
            deleteJobTransportSettings, settings.deleteJobSettings(), clientContext);
    this.cancelJobCallable =
        callableFactory.createUnaryCallable(
            cancelJobTransportSettings, settings.cancelJobSettings(), clientContext);
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
  public UnaryCallable<CreateJobRequest, Operation> createJobCallable() {
    return createJobCallable;
  }

  @Override
  public OperationCallable<CreateJobRequest, Job, OperationMetadata> createJobOperationCallable() {
    return createJobOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    return deleteJobCallable;
  }

  @Override
  public UnaryCallable<CancelJobRequest, CancelJobResponse> cancelJobCallable() {
    return cancelJobCallable;
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
