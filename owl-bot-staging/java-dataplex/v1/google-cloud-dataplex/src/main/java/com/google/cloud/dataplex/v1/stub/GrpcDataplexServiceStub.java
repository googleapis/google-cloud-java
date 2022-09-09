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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListAssetActionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListAssetsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListJobsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListLakeActionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListLakesPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListSessionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListTasksPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListZoneActionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListZonesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.Asset;
import com.google.cloud.dataplex.v1.CancelJobRequest;
import com.google.cloud.dataplex.v1.CreateAssetRequest;
import com.google.cloud.dataplex.v1.CreateEnvironmentRequest;
import com.google.cloud.dataplex.v1.CreateLakeRequest;
import com.google.cloud.dataplex.v1.CreateTaskRequest;
import com.google.cloud.dataplex.v1.CreateZoneRequest;
import com.google.cloud.dataplex.v1.DeleteAssetRequest;
import com.google.cloud.dataplex.v1.DeleteEnvironmentRequest;
import com.google.cloud.dataplex.v1.DeleteLakeRequest;
import com.google.cloud.dataplex.v1.DeleteTaskRequest;
import com.google.cloud.dataplex.v1.DeleteZoneRequest;
import com.google.cloud.dataplex.v1.Environment;
import com.google.cloud.dataplex.v1.GetAssetRequest;
import com.google.cloud.dataplex.v1.GetEnvironmentRequest;
import com.google.cloud.dataplex.v1.GetJobRequest;
import com.google.cloud.dataplex.v1.GetLakeRequest;
import com.google.cloud.dataplex.v1.GetTaskRequest;
import com.google.cloud.dataplex.v1.GetZoneRequest;
import com.google.cloud.dataplex.v1.Job;
import com.google.cloud.dataplex.v1.Lake;
import com.google.cloud.dataplex.v1.ListActionsResponse;
import com.google.cloud.dataplex.v1.ListAssetActionsRequest;
import com.google.cloud.dataplex.v1.ListAssetsRequest;
import com.google.cloud.dataplex.v1.ListAssetsResponse;
import com.google.cloud.dataplex.v1.ListEnvironmentsRequest;
import com.google.cloud.dataplex.v1.ListEnvironmentsResponse;
import com.google.cloud.dataplex.v1.ListJobsRequest;
import com.google.cloud.dataplex.v1.ListJobsResponse;
import com.google.cloud.dataplex.v1.ListLakeActionsRequest;
import com.google.cloud.dataplex.v1.ListLakesRequest;
import com.google.cloud.dataplex.v1.ListLakesResponse;
import com.google.cloud.dataplex.v1.ListSessionsRequest;
import com.google.cloud.dataplex.v1.ListSessionsResponse;
import com.google.cloud.dataplex.v1.ListTasksRequest;
import com.google.cloud.dataplex.v1.ListTasksResponse;
import com.google.cloud.dataplex.v1.ListZoneActionsRequest;
import com.google.cloud.dataplex.v1.ListZonesRequest;
import com.google.cloud.dataplex.v1.ListZonesResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.Task;
import com.google.cloud.dataplex.v1.UpdateAssetRequest;
import com.google.cloud.dataplex.v1.UpdateEnvironmentRequest;
import com.google.cloud.dataplex.v1.UpdateLakeRequest;
import com.google.cloud.dataplex.v1.UpdateTaskRequest;
import com.google.cloud.dataplex.v1.UpdateZoneRequest;
import com.google.cloud.dataplex.v1.Zone;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * gRPC stub implementation for the DataplexService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDataplexServiceStub extends DataplexServiceStub {
  private static final MethodDescriptor<CreateLakeRequest, Operation> createLakeMethodDescriptor =
      MethodDescriptor.<CreateLakeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/CreateLake")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateLakeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateLakeRequest, Operation> updateLakeMethodDescriptor =
      MethodDescriptor.<UpdateLakeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/UpdateLake")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateLakeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteLakeRequest, Operation> deleteLakeMethodDescriptor =
      MethodDescriptor.<DeleteLakeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/DeleteLake")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteLakeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListLakesRequest, ListLakesResponse>
      listLakesMethodDescriptor =
          MethodDescriptor.<ListLakesRequest, ListLakesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataplexService/ListLakes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListLakesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListLakesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLakeRequest, Lake> getLakeMethodDescriptor =
      MethodDescriptor.<GetLakeRequest, Lake>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/GetLake")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLakeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Lake.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListLakeActionsRequest, ListActionsResponse>
      listLakeActionsMethodDescriptor =
          MethodDescriptor.<ListLakeActionsRequest, ListActionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataplexService/ListLakeActions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLakeActionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListActionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateZoneRequest, Operation> createZoneMethodDescriptor =
      MethodDescriptor.<CreateZoneRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/CreateZone")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateZoneRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateZoneRequest, Operation> updateZoneMethodDescriptor =
      MethodDescriptor.<UpdateZoneRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/UpdateZone")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateZoneRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteZoneRequest, Operation> deleteZoneMethodDescriptor =
      MethodDescriptor.<DeleteZoneRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/DeleteZone")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteZoneRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListZonesRequest, ListZonesResponse>
      listZonesMethodDescriptor =
          MethodDescriptor.<ListZonesRequest, ListZonesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataplexService/ListZones")
              .setRequestMarshaller(ProtoUtils.marshaller(ListZonesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListZonesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetZoneRequest, Zone> getZoneMethodDescriptor =
      MethodDescriptor.<GetZoneRequest, Zone>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/GetZone")
          .setRequestMarshaller(ProtoUtils.marshaller(GetZoneRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Zone.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListZoneActionsRequest, ListActionsResponse>
      listZoneActionsMethodDescriptor =
          MethodDescriptor.<ListZoneActionsRequest, ListActionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataplexService/ListZoneActions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListZoneActionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListActionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAssetRequest, Operation> createAssetMethodDescriptor =
      MethodDescriptor.<CreateAssetRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/CreateAsset")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateAssetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateAssetRequest, Operation> updateAssetMethodDescriptor =
      MethodDescriptor.<UpdateAssetRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/UpdateAsset")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateAssetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteAssetRequest, Operation> deleteAssetMethodDescriptor =
      MethodDescriptor.<DeleteAssetRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/DeleteAsset")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteAssetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListAssetsRequest, ListAssetsResponse>
      listAssetsMethodDescriptor =
          MethodDescriptor.<ListAssetsRequest, ListAssetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataplexService/ListAssets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListAssetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAssetRequest, Asset> getAssetMethodDescriptor =
      MethodDescriptor.<GetAssetRequest, Asset>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/GetAsset")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAssetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Asset.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListAssetActionsRequest, ListActionsResponse>
      listAssetActionsMethodDescriptor =
          MethodDescriptor.<ListAssetActionsRequest, ListActionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataplexService/ListAssetActions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAssetActionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListActionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTaskRequest, Operation> createTaskMethodDescriptor =
      MethodDescriptor.<CreateTaskRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/CreateTask")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateTaskRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateTaskRequest, Operation> updateTaskMethodDescriptor =
      MethodDescriptor.<UpdateTaskRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/UpdateTask")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateTaskRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteTaskRequest, Operation> deleteTaskMethodDescriptor =
      MethodDescriptor.<DeleteTaskRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/DeleteTask")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteTaskRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListTasksRequest, ListTasksResponse>
      listTasksMethodDescriptor =
          MethodDescriptor.<ListTasksRequest, ListTasksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataplexService/ListTasks")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTasksRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListTasksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTaskRequest, Task> getTaskMethodDescriptor =
      MethodDescriptor.<GetTaskRequest, Task>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/GetTask")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTaskRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Task.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListJobsRequest, ListJobsResponse>
      listJobsMethodDescriptor =
          MethodDescriptor.<ListJobsRequest, ListJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataplexService/ListJobs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetJobRequest, Job> getJobMethodDescriptor =
      MethodDescriptor.<GetJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/GetJob")
          .setRequestMarshaller(ProtoUtils.marshaller(GetJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CancelJobRequest, Empty> cancelJobMethodDescriptor =
      MethodDescriptor.<CancelJobRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.DataplexService/CancelJob")
          .setRequestMarshaller(ProtoUtils.marshaller(CancelJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateEnvironmentRequest, Operation>
      createEnvironmentMethodDescriptor =
          MethodDescriptor.<CreateEnvironmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataplexService/CreateEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateEnvironmentRequest, Operation>
      updateEnvironmentMethodDescriptor =
          MethodDescriptor.<UpdateEnvironmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataplexService/UpdateEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEnvironmentRequest, Operation>
      deleteEnvironmentMethodDescriptor =
          MethodDescriptor.<DeleteEnvironmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataplexService/DeleteEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsMethodDescriptor =
          MethodDescriptor.<ListEnvironmentsRequest, ListEnvironmentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataplexService/ListEnvironments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEnvironmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEnvironmentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEnvironmentRequest, Environment>
      getEnvironmentMethodDescriptor =
          MethodDescriptor.<GetEnvironmentRequest, Environment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataplexService/GetEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Environment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSessionsRequest, ListSessionsResponse>
      listSessionsMethodDescriptor =
          MethodDescriptor.<ListSessionsRequest, ListSessionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataplexService/ListSessions")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSessionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSessionsResponse.getDefaultInstance()))
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

  private final UnaryCallable<CreateLakeRequest, Operation> createLakeCallable;
  private final OperationCallable<CreateLakeRequest, Lake, OperationMetadata>
      createLakeOperationCallable;
  private final UnaryCallable<UpdateLakeRequest, Operation> updateLakeCallable;
  private final OperationCallable<UpdateLakeRequest, Lake, OperationMetadata>
      updateLakeOperationCallable;
  private final UnaryCallable<DeleteLakeRequest, Operation> deleteLakeCallable;
  private final OperationCallable<DeleteLakeRequest, Empty, OperationMetadata>
      deleteLakeOperationCallable;
  private final UnaryCallable<ListLakesRequest, ListLakesResponse> listLakesCallable;
  private final UnaryCallable<ListLakesRequest, ListLakesPagedResponse> listLakesPagedCallable;
  private final UnaryCallable<GetLakeRequest, Lake> getLakeCallable;
  private final UnaryCallable<ListLakeActionsRequest, ListActionsResponse> listLakeActionsCallable;
  private final UnaryCallable<ListLakeActionsRequest, ListLakeActionsPagedResponse>
      listLakeActionsPagedCallable;
  private final UnaryCallable<CreateZoneRequest, Operation> createZoneCallable;
  private final OperationCallable<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationCallable;
  private final UnaryCallable<UpdateZoneRequest, Operation> updateZoneCallable;
  private final OperationCallable<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationCallable;
  private final UnaryCallable<DeleteZoneRequest, Operation> deleteZoneCallable;
  private final OperationCallable<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationCallable;
  private final UnaryCallable<ListZonesRequest, ListZonesResponse> listZonesCallable;
  private final UnaryCallable<ListZonesRequest, ListZonesPagedResponse> listZonesPagedCallable;
  private final UnaryCallable<GetZoneRequest, Zone> getZoneCallable;
  private final UnaryCallable<ListZoneActionsRequest, ListActionsResponse> listZoneActionsCallable;
  private final UnaryCallable<ListZoneActionsRequest, ListZoneActionsPagedResponse>
      listZoneActionsPagedCallable;
  private final UnaryCallable<CreateAssetRequest, Operation> createAssetCallable;
  private final OperationCallable<CreateAssetRequest, Asset, OperationMetadata>
      createAssetOperationCallable;
  private final UnaryCallable<UpdateAssetRequest, Operation> updateAssetCallable;
  private final OperationCallable<UpdateAssetRequest, Asset, OperationMetadata>
      updateAssetOperationCallable;
  private final UnaryCallable<DeleteAssetRequest, Operation> deleteAssetCallable;
  private final OperationCallable<DeleteAssetRequest, Empty, OperationMetadata>
      deleteAssetOperationCallable;
  private final UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable;
  private final UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable;
  private final UnaryCallable<GetAssetRequest, Asset> getAssetCallable;
  private final UnaryCallable<ListAssetActionsRequest, ListActionsResponse>
      listAssetActionsCallable;
  private final UnaryCallable<ListAssetActionsRequest, ListAssetActionsPagedResponse>
      listAssetActionsPagedCallable;
  private final UnaryCallable<CreateTaskRequest, Operation> createTaskCallable;
  private final OperationCallable<CreateTaskRequest, Task, OperationMetadata>
      createTaskOperationCallable;
  private final UnaryCallable<UpdateTaskRequest, Operation> updateTaskCallable;
  private final OperationCallable<UpdateTaskRequest, Task, OperationMetadata>
      updateTaskOperationCallable;
  private final UnaryCallable<DeleteTaskRequest, Operation> deleteTaskCallable;
  private final OperationCallable<DeleteTaskRequest, Empty, OperationMetadata>
      deleteTaskOperationCallable;
  private final UnaryCallable<ListTasksRequest, ListTasksResponse> listTasksCallable;
  private final UnaryCallable<ListTasksRequest, ListTasksPagedResponse> listTasksPagedCallable;
  private final UnaryCallable<GetTaskRequest, Task> getTaskCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable;
  private final UnaryCallable<GetJobRequest, Job> getJobCallable;
  private final UnaryCallable<CancelJobRequest, Empty> cancelJobCallable;
  private final UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable;
  private final OperationCallable<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationCallable;
  private final UnaryCallable<UpdateEnvironmentRequest, Operation> updateEnvironmentCallable;
  private final OperationCallable<UpdateEnvironmentRequest, Environment, OperationMetadata>
      updateEnvironmentOperationCallable;
  private final UnaryCallable<DeleteEnvironmentRequest, Operation> deleteEnvironmentCallable;
  private final OperationCallable<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationCallable;
  private final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable;
  private final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable;
  private final UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable;
  private final UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable;
  private final UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse>
      listSessionsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataplexServiceStub create(DataplexServiceStubSettings settings)
      throws IOException {
    return new GrpcDataplexServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataplexServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataplexServiceStub(
        DataplexServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataplexServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataplexServiceStub(
        DataplexServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataplexServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataplexServiceStub(
      DataplexServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataplexServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataplexServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataplexServiceStub(
      DataplexServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateLakeRequest, Operation> createLakeTransportSettings =
        GrpcCallSettings.<CreateLakeRequest, Operation>newBuilder()
            .setMethodDescriptor(createLakeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateLakeRequest, Operation> updateLakeTransportSettings =
        GrpcCallSettings.<UpdateLakeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateLakeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("lake.name", String.valueOf(request.getLake().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteLakeRequest, Operation> deleteLakeTransportSettings =
        GrpcCallSettings.<DeleteLakeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteLakeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListLakesRequest, ListLakesResponse> listLakesTransportSettings =
        GrpcCallSettings.<ListLakesRequest, ListLakesResponse>newBuilder()
            .setMethodDescriptor(listLakesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLakeRequest, Lake> getLakeTransportSettings =
        GrpcCallSettings.<GetLakeRequest, Lake>newBuilder()
            .setMethodDescriptor(getLakeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListLakeActionsRequest, ListActionsResponse> listLakeActionsTransportSettings =
        GrpcCallSettings.<ListLakeActionsRequest, ListActionsResponse>newBuilder()
            .setMethodDescriptor(listLakeActionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateZoneRequest, Operation> createZoneTransportSettings =
        GrpcCallSettings.<CreateZoneRequest, Operation>newBuilder()
            .setMethodDescriptor(createZoneMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateZoneRequest, Operation> updateZoneTransportSettings =
        GrpcCallSettings.<UpdateZoneRequest, Operation>newBuilder()
            .setMethodDescriptor(updateZoneMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("zone.name", String.valueOf(request.getZone().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteZoneRequest, Operation> deleteZoneTransportSettings =
        GrpcCallSettings.<DeleteZoneRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteZoneMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListZonesRequest, ListZonesResponse> listZonesTransportSettings =
        GrpcCallSettings.<ListZonesRequest, ListZonesResponse>newBuilder()
            .setMethodDescriptor(listZonesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetZoneRequest, Zone> getZoneTransportSettings =
        GrpcCallSettings.<GetZoneRequest, Zone>newBuilder()
            .setMethodDescriptor(getZoneMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListZoneActionsRequest, ListActionsResponse> listZoneActionsTransportSettings =
        GrpcCallSettings.<ListZoneActionsRequest, ListActionsResponse>newBuilder()
            .setMethodDescriptor(listZoneActionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateAssetRequest, Operation> createAssetTransportSettings =
        GrpcCallSettings.<CreateAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(createAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateAssetRequest, Operation> updateAssetTransportSettings =
        GrpcCallSettings.<UpdateAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("asset.name", String.valueOf(request.getAsset().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteAssetRequest, Operation> deleteAssetTransportSettings =
        GrpcCallSettings.<DeleteAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListAssetsRequest, ListAssetsResponse> listAssetsTransportSettings =
        GrpcCallSettings.<ListAssetsRequest, ListAssetsResponse>newBuilder()
            .setMethodDescriptor(listAssetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetAssetRequest, Asset> getAssetTransportSettings =
        GrpcCallSettings.<GetAssetRequest, Asset>newBuilder()
            .setMethodDescriptor(getAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListAssetActionsRequest, ListActionsResponse>
        listAssetActionsTransportSettings =
            GrpcCallSettings.<ListAssetActionsRequest, ListActionsResponse>newBuilder()
                .setMethodDescriptor(listAssetActionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateTaskRequest, Operation> createTaskTransportSettings =
        GrpcCallSettings.<CreateTaskRequest, Operation>newBuilder()
            .setMethodDescriptor(createTaskMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateTaskRequest, Operation> updateTaskTransportSettings =
        GrpcCallSettings.<UpdateTaskRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTaskMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("task.name", String.valueOf(request.getTask().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteTaskRequest, Operation> deleteTaskTransportSettings =
        GrpcCallSettings.<DeleteTaskRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTaskMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListTasksRequest, ListTasksResponse> listTasksTransportSettings =
        GrpcCallSettings.<ListTasksRequest, ListTasksResponse>newBuilder()
            .setMethodDescriptor(listTasksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetTaskRequest, Task> getTaskTransportSettings =
        GrpcCallSettings.<GetTaskRequest, Task>newBuilder()
            .setMethodDescriptor(getTaskMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
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
    GrpcCallSettings<CancelJobRequest, Empty> cancelJobTransportSettings =
        GrpcCallSettings.<CancelJobRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentTransportSettings =
        GrpcCallSettings.<CreateEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(createEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateEnvironmentRequest, Operation> updateEnvironmentTransportSettings =
        GrpcCallSettings.<UpdateEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "environment.name", String.valueOf(request.getEnvironment().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteEnvironmentRequest, Operation> deleteEnvironmentTransportSettings =
        GrpcCallSettings.<DeleteEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListEnvironmentsRequest, ListEnvironmentsResponse>
        listEnvironmentsTransportSettings =
            GrpcCallSettings.<ListEnvironmentsRequest, ListEnvironmentsResponse>newBuilder()
                .setMethodDescriptor(listEnvironmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetEnvironmentRequest, Environment> getEnvironmentTransportSettings =
        GrpcCallSettings.<GetEnvironmentRequest, Environment>newBuilder()
            .setMethodDescriptor(getEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListSessionsRequest, ListSessionsResponse> listSessionsTransportSettings =
        GrpcCallSettings.<ListSessionsRequest, ListSessionsResponse>newBuilder()
            .setMethodDescriptor(listSessionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.createLakeCallable =
        callableFactory.createUnaryCallable(
            createLakeTransportSettings, settings.createLakeSettings(), clientContext);
    this.createLakeOperationCallable =
        callableFactory.createOperationCallable(
            createLakeTransportSettings,
            settings.createLakeOperationSettings(),
            clientContext,
            operationsStub);
    this.updateLakeCallable =
        callableFactory.createUnaryCallable(
            updateLakeTransportSettings, settings.updateLakeSettings(), clientContext);
    this.updateLakeOperationCallable =
        callableFactory.createOperationCallable(
            updateLakeTransportSettings,
            settings.updateLakeOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteLakeCallable =
        callableFactory.createUnaryCallable(
            deleteLakeTransportSettings, settings.deleteLakeSettings(), clientContext);
    this.deleteLakeOperationCallable =
        callableFactory.createOperationCallable(
            deleteLakeTransportSettings,
            settings.deleteLakeOperationSettings(),
            clientContext,
            operationsStub);
    this.listLakesCallable =
        callableFactory.createUnaryCallable(
            listLakesTransportSettings, settings.listLakesSettings(), clientContext);
    this.listLakesPagedCallable =
        callableFactory.createPagedCallable(
            listLakesTransportSettings, settings.listLakesSettings(), clientContext);
    this.getLakeCallable =
        callableFactory.createUnaryCallable(
            getLakeTransportSettings, settings.getLakeSettings(), clientContext);
    this.listLakeActionsCallable =
        callableFactory.createUnaryCallable(
            listLakeActionsTransportSettings, settings.listLakeActionsSettings(), clientContext);
    this.listLakeActionsPagedCallable =
        callableFactory.createPagedCallable(
            listLakeActionsTransportSettings, settings.listLakeActionsSettings(), clientContext);
    this.createZoneCallable =
        callableFactory.createUnaryCallable(
            createZoneTransportSettings, settings.createZoneSettings(), clientContext);
    this.createZoneOperationCallable =
        callableFactory.createOperationCallable(
            createZoneTransportSettings,
            settings.createZoneOperationSettings(),
            clientContext,
            operationsStub);
    this.updateZoneCallable =
        callableFactory.createUnaryCallable(
            updateZoneTransportSettings, settings.updateZoneSettings(), clientContext);
    this.updateZoneOperationCallable =
        callableFactory.createOperationCallable(
            updateZoneTransportSettings,
            settings.updateZoneOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteZoneCallable =
        callableFactory.createUnaryCallable(
            deleteZoneTransportSettings, settings.deleteZoneSettings(), clientContext);
    this.deleteZoneOperationCallable =
        callableFactory.createOperationCallable(
            deleteZoneTransportSettings,
            settings.deleteZoneOperationSettings(),
            clientContext,
            operationsStub);
    this.listZonesCallable =
        callableFactory.createUnaryCallable(
            listZonesTransportSettings, settings.listZonesSettings(), clientContext);
    this.listZonesPagedCallable =
        callableFactory.createPagedCallable(
            listZonesTransportSettings, settings.listZonesSettings(), clientContext);
    this.getZoneCallable =
        callableFactory.createUnaryCallable(
            getZoneTransportSettings, settings.getZoneSettings(), clientContext);
    this.listZoneActionsCallable =
        callableFactory.createUnaryCallable(
            listZoneActionsTransportSettings, settings.listZoneActionsSettings(), clientContext);
    this.listZoneActionsPagedCallable =
        callableFactory.createPagedCallable(
            listZoneActionsTransportSettings, settings.listZoneActionsSettings(), clientContext);
    this.createAssetCallable =
        callableFactory.createUnaryCallable(
            createAssetTransportSettings, settings.createAssetSettings(), clientContext);
    this.createAssetOperationCallable =
        callableFactory.createOperationCallable(
            createAssetTransportSettings,
            settings.createAssetOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAssetCallable =
        callableFactory.createUnaryCallable(
            updateAssetTransportSettings, settings.updateAssetSettings(), clientContext);
    this.updateAssetOperationCallable =
        callableFactory.createOperationCallable(
            updateAssetTransportSettings,
            settings.updateAssetOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAssetCallable =
        callableFactory.createUnaryCallable(
            deleteAssetTransportSettings, settings.deleteAssetSettings(), clientContext);
    this.deleteAssetOperationCallable =
        callableFactory.createOperationCallable(
            deleteAssetTransportSettings,
            settings.deleteAssetOperationSettings(),
            clientContext,
            operationsStub);
    this.listAssetsCallable =
        callableFactory.createUnaryCallable(
            listAssetsTransportSettings, settings.listAssetsSettings(), clientContext);
    this.listAssetsPagedCallable =
        callableFactory.createPagedCallable(
            listAssetsTransportSettings, settings.listAssetsSettings(), clientContext);
    this.getAssetCallable =
        callableFactory.createUnaryCallable(
            getAssetTransportSettings, settings.getAssetSettings(), clientContext);
    this.listAssetActionsCallable =
        callableFactory.createUnaryCallable(
            listAssetActionsTransportSettings, settings.listAssetActionsSettings(), clientContext);
    this.listAssetActionsPagedCallable =
        callableFactory.createPagedCallable(
            listAssetActionsTransportSettings, settings.listAssetActionsSettings(), clientContext);
    this.createTaskCallable =
        callableFactory.createUnaryCallable(
            createTaskTransportSettings, settings.createTaskSettings(), clientContext);
    this.createTaskOperationCallable =
        callableFactory.createOperationCallable(
            createTaskTransportSettings,
            settings.createTaskOperationSettings(),
            clientContext,
            operationsStub);
    this.updateTaskCallable =
        callableFactory.createUnaryCallable(
            updateTaskTransportSettings, settings.updateTaskSettings(), clientContext);
    this.updateTaskOperationCallable =
        callableFactory.createOperationCallable(
            updateTaskTransportSettings,
            settings.updateTaskOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteTaskCallable =
        callableFactory.createUnaryCallable(
            deleteTaskTransportSettings, settings.deleteTaskSettings(), clientContext);
    this.deleteTaskOperationCallable =
        callableFactory.createOperationCallable(
            deleteTaskTransportSettings,
            settings.deleteTaskOperationSettings(),
            clientContext,
            operationsStub);
    this.listTasksCallable =
        callableFactory.createUnaryCallable(
            listTasksTransportSettings, settings.listTasksSettings(), clientContext);
    this.listTasksPagedCallable =
        callableFactory.createPagedCallable(
            listTasksTransportSettings, settings.listTasksSettings(), clientContext);
    this.getTaskCallable =
        callableFactory.createUnaryCallable(
            getTaskTransportSettings, settings.getTaskSettings(), clientContext);
    this.listJobsCallable =
        callableFactory.createUnaryCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.listJobsPagedCallable =
        callableFactory.createPagedCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.getJobCallable =
        callableFactory.createUnaryCallable(
            getJobTransportSettings, settings.getJobSettings(), clientContext);
    this.cancelJobCallable =
        callableFactory.createUnaryCallable(
            cancelJobTransportSettings, settings.cancelJobSettings(), clientContext);
    this.createEnvironmentCallable =
        callableFactory.createUnaryCallable(
            createEnvironmentTransportSettings,
            settings.createEnvironmentSettings(),
            clientContext);
    this.createEnvironmentOperationCallable =
        callableFactory.createOperationCallable(
            createEnvironmentTransportSettings,
            settings.createEnvironmentOperationSettings(),
            clientContext,
            operationsStub);
    this.updateEnvironmentCallable =
        callableFactory.createUnaryCallable(
            updateEnvironmentTransportSettings,
            settings.updateEnvironmentSettings(),
            clientContext);
    this.updateEnvironmentOperationCallable =
        callableFactory.createOperationCallable(
            updateEnvironmentTransportSettings,
            settings.updateEnvironmentOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteEnvironmentCallable =
        callableFactory.createUnaryCallable(
            deleteEnvironmentTransportSettings,
            settings.deleteEnvironmentSettings(),
            clientContext);
    this.deleteEnvironmentOperationCallable =
        callableFactory.createOperationCallable(
            deleteEnvironmentTransportSettings,
            settings.deleteEnvironmentOperationSettings(),
            clientContext,
            operationsStub);
    this.listEnvironmentsCallable =
        callableFactory.createUnaryCallable(
            listEnvironmentsTransportSettings, settings.listEnvironmentsSettings(), clientContext);
    this.listEnvironmentsPagedCallable =
        callableFactory.createPagedCallable(
            listEnvironmentsTransportSettings, settings.listEnvironmentsSettings(), clientContext);
    this.getEnvironmentCallable =
        callableFactory.createUnaryCallable(
            getEnvironmentTransportSettings, settings.getEnvironmentSettings(), clientContext);
    this.listSessionsCallable =
        callableFactory.createUnaryCallable(
            listSessionsTransportSettings, settings.listSessionsSettings(), clientContext);
    this.listSessionsPagedCallable =
        callableFactory.createPagedCallable(
            listSessionsTransportSettings, settings.listSessionsSettings(), clientContext);
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
  public UnaryCallable<CreateLakeRequest, Operation> createLakeCallable() {
    return createLakeCallable;
  }

  @Override
  public OperationCallable<CreateLakeRequest, Lake, OperationMetadata>
      createLakeOperationCallable() {
    return createLakeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateLakeRequest, Operation> updateLakeCallable() {
    return updateLakeCallable;
  }

  @Override
  public OperationCallable<UpdateLakeRequest, Lake, OperationMetadata>
      updateLakeOperationCallable() {
    return updateLakeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteLakeRequest, Operation> deleteLakeCallable() {
    return deleteLakeCallable;
  }

  @Override
  public OperationCallable<DeleteLakeRequest, Empty, OperationMetadata>
      deleteLakeOperationCallable() {
    return deleteLakeOperationCallable;
  }

  @Override
  public UnaryCallable<ListLakesRequest, ListLakesResponse> listLakesCallable() {
    return listLakesCallable;
  }

  @Override
  public UnaryCallable<ListLakesRequest, ListLakesPagedResponse> listLakesPagedCallable() {
    return listLakesPagedCallable;
  }

  @Override
  public UnaryCallable<GetLakeRequest, Lake> getLakeCallable() {
    return getLakeCallable;
  }

  @Override
  public UnaryCallable<ListLakeActionsRequest, ListActionsResponse> listLakeActionsCallable() {
    return listLakeActionsCallable;
  }

  @Override
  public UnaryCallable<ListLakeActionsRequest, ListLakeActionsPagedResponse>
      listLakeActionsPagedCallable() {
    return listLakeActionsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateZoneRequest, Operation> createZoneCallable() {
    return createZoneCallable;
  }

  @Override
  public OperationCallable<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationCallable() {
    return createZoneOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateZoneRequest, Operation> updateZoneCallable() {
    return updateZoneCallable;
  }

  @Override
  public OperationCallable<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationCallable() {
    return updateZoneOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteZoneRequest, Operation> deleteZoneCallable() {
    return deleteZoneCallable;
  }

  @Override
  public OperationCallable<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationCallable() {
    return deleteZoneOperationCallable;
  }

  @Override
  public UnaryCallable<ListZonesRequest, ListZonesResponse> listZonesCallable() {
    return listZonesCallable;
  }

  @Override
  public UnaryCallable<ListZonesRequest, ListZonesPagedResponse> listZonesPagedCallable() {
    return listZonesPagedCallable;
  }

  @Override
  public UnaryCallable<GetZoneRequest, Zone> getZoneCallable() {
    return getZoneCallable;
  }

  @Override
  public UnaryCallable<ListZoneActionsRequest, ListActionsResponse> listZoneActionsCallable() {
    return listZoneActionsCallable;
  }

  @Override
  public UnaryCallable<ListZoneActionsRequest, ListZoneActionsPagedResponse>
      listZoneActionsPagedCallable() {
    return listZoneActionsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateAssetRequest, Operation> createAssetCallable() {
    return createAssetCallable;
  }

  @Override
  public OperationCallable<CreateAssetRequest, Asset, OperationMetadata>
      createAssetOperationCallable() {
    return createAssetOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAssetRequest, Operation> updateAssetCallable() {
    return updateAssetCallable;
  }

  @Override
  public OperationCallable<UpdateAssetRequest, Asset, OperationMetadata>
      updateAssetOperationCallable() {
    return updateAssetOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAssetRequest, Operation> deleteAssetCallable() {
    return deleteAssetCallable;
  }

  @Override
  public OperationCallable<DeleteAssetRequest, Empty, OperationMetadata>
      deleteAssetOperationCallable() {
    return deleteAssetOperationCallable;
  }

  @Override
  public UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    return listAssetsCallable;
  }

  @Override
  public UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    return listAssetsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAssetRequest, Asset> getAssetCallable() {
    return getAssetCallable;
  }

  @Override
  public UnaryCallable<ListAssetActionsRequest, ListActionsResponse> listAssetActionsCallable() {
    return listAssetActionsCallable;
  }

  @Override
  public UnaryCallable<ListAssetActionsRequest, ListAssetActionsPagedResponse>
      listAssetActionsPagedCallable() {
    return listAssetActionsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTaskRequest, Operation> createTaskCallable() {
    return createTaskCallable;
  }

  @Override
  public OperationCallable<CreateTaskRequest, Task, OperationMetadata>
      createTaskOperationCallable() {
    return createTaskOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTaskRequest, Operation> updateTaskCallable() {
    return updateTaskCallable;
  }

  @Override
  public OperationCallable<UpdateTaskRequest, Task, OperationMetadata>
      updateTaskOperationCallable() {
    return updateTaskOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTaskRequest, Operation> deleteTaskCallable() {
    return deleteTaskCallable;
  }

  @Override
  public OperationCallable<DeleteTaskRequest, Empty, OperationMetadata>
      deleteTaskOperationCallable() {
    return deleteTaskOperationCallable;
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
  public UnaryCallable<GetTaskRequest, Task> getTaskCallable() {
    return getTaskCallable;
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
  public UnaryCallable<CancelJobRequest, Empty> cancelJobCallable() {
    return cancelJobCallable;
  }

  @Override
  public UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable() {
    return createEnvironmentCallable;
  }

  @Override
  public OperationCallable<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationCallable() {
    return createEnvironmentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEnvironmentRequest, Operation> updateEnvironmentCallable() {
    return updateEnvironmentCallable;
  }

  @Override
  public OperationCallable<UpdateEnvironmentRequest, Environment, OperationMetadata>
      updateEnvironmentOperationCallable() {
    return updateEnvironmentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEnvironmentRequest, Operation> deleteEnvironmentCallable() {
    return deleteEnvironmentCallable;
  }

  @Override
  public OperationCallable<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationCallable() {
    return deleteEnvironmentOperationCallable;
  }

  @Override
  public UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable() {
    return listEnvironmentsCallable;
  }

  @Override
  public UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable() {
    return listEnvironmentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    return getEnvironmentCallable;
  }

  @Override
  public UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable() {
    return listSessionsCallable;
  }

  @Override
  public UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse> listSessionsPagedCallable() {
    return listSessionsPagedCallable;
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
