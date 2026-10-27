/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.lustre.v1.stub;

import static com.google.cloud.lustre.v1.LustreClient.ListDirectoryPoliciesPagedResponse;
import static com.google.cloud.lustre.v1.LustreClient.ListInstancesPagedResponse;
import static com.google.cloud.lustre.v1.LustreClient.ListLocationsPagedResponse;
import static com.google.cloud.lustre.v1.LustreClient.ListMirrorsPagedResponse;

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
import com.google.cloud.lustre.v1.CreateDirectoryPolicyRequest;
import com.google.cloud.lustre.v1.CreateInstanceRequest;
import com.google.cloud.lustre.v1.CreateMirrorMetadata;
import com.google.cloud.lustre.v1.CreateMirrorRequest;
import com.google.cloud.lustre.v1.DeleteDirectoryPolicyRequest;
import com.google.cloud.lustre.v1.DeleteInstanceRequest;
import com.google.cloud.lustre.v1.DeleteMirrorRequest;
import com.google.cloud.lustre.v1.DirectoryPolicy;
import com.google.cloud.lustre.v1.ExportDataMetadata;
import com.google.cloud.lustre.v1.ExportDataRequest;
import com.google.cloud.lustre.v1.ExportDataResponse;
import com.google.cloud.lustre.v1.GetDirectoryPolicyRequest;
import com.google.cloud.lustre.v1.GetInstanceRequest;
import com.google.cloud.lustre.v1.GetMirrorRequest;
import com.google.cloud.lustre.v1.ImportDataMetadata;
import com.google.cloud.lustre.v1.ImportDataRequest;
import com.google.cloud.lustre.v1.ImportDataResponse;
import com.google.cloud.lustre.v1.Instance;
import com.google.cloud.lustre.v1.ListDirectoryPoliciesRequest;
import com.google.cloud.lustre.v1.ListDirectoryPoliciesResponse;
import com.google.cloud.lustre.v1.ListInstancesRequest;
import com.google.cloud.lustre.v1.ListInstancesResponse;
import com.google.cloud.lustre.v1.ListMirrorsRequest;
import com.google.cloud.lustre.v1.ListMirrorsResponse;
import com.google.cloud.lustre.v1.Mirror;
import com.google.cloud.lustre.v1.OperationMetadata;
import com.google.cloud.lustre.v1.RescheduleMaintenanceRequest;
import com.google.cloud.lustre.v1.UpdateInstanceRequest;
import com.google.cloud.lustre.v1.UpdateMirrorRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Lustre service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcLustreStub extends LustreStub {
  private static final MethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          MethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.lustre.v1.Lustre/ListInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetInstanceRequest, Instance> getInstanceMethodDescriptor =
      MethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.lustre.v1.Lustre/GetInstance")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          MethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.lustre.v1.Lustre/CreateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateInstanceRequest, Operation>
      updateInstanceMethodDescriptor =
          MethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.lustre.v1.Lustre/UpdateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          MethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.lustre.v1.Lustre/DeleteInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceMethodDescriptor =
          MethodDescriptor.<RescheduleMaintenanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.lustre.v1.Lustre/RescheduleMaintenance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RescheduleMaintenanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ImportDataRequest, Operation> importDataMethodDescriptor =
      MethodDescriptor.<ImportDataRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.lustre.v1.Lustre/ImportData")
          .setRequestMarshaller(ProtoUtils.marshaller(ImportDataRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ExportDataRequest, Operation> exportDataMethodDescriptor =
      MethodDescriptor.<ExportDataRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.lustre.v1.Lustre/ExportData")
          .setRequestMarshaller(ProtoUtils.marshaller(ExportDataRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateMirrorRequest, Operation>
      createMirrorMethodDescriptor =
          MethodDescriptor.<CreateMirrorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.lustre.v1.Lustre/CreateMirror")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateMirrorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateMirrorRequest, Operation>
      updateMirrorMethodDescriptor =
          MethodDescriptor.<UpdateMirrorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.lustre.v1.Lustre/UpdateMirror")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateMirrorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteMirrorRequest, Operation>
      deleteMirrorMethodDescriptor =
          MethodDescriptor.<DeleteMirrorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.lustre.v1.Lustre/DeleteMirror")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteMirrorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMirrorRequest, Mirror> getMirrorMethodDescriptor =
      MethodDescriptor.<GetMirrorRequest, Mirror>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.lustre.v1.Lustre/GetMirror")
          .setRequestMarshaller(ProtoUtils.marshaller(GetMirrorRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Mirror.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListMirrorsRequest, ListMirrorsResponse>
      listMirrorsMethodDescriptor =
          MethodDescriptor.<ListMirrorsRequest, ListMirrorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.lustre.v1.Lustre/ListMirrors")
              .setRequestMarshaller(ProtoUtils.marshaller(ListMirrorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMirrorsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateDirectoryPolicyRequest, Operation>
      createDirectoryPolicyMethodDescriptor =
          MethodDescriptor.<CreateDirectoryPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.lustre.v1.Lustre/CreateDirectoryPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDirectoryPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteDirectoryPolicyRequest, Operation>
      deleteDirectoryPolicyMethodDescriptor =
          MethodDescriptor.<DeleteDirectoryPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.lustre.v1.Lustre/DeleteDirectoryPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDirectoryPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDirectoryPolicyRequest, DirectoryPolicy>
      getDirectoryPolicyMethodDescriptor =
          MethodDescriptor.<GetDirectoryPolicyRequest, DirectoryPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.lustre.v1.Lustre/GetDirectoryPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDirectoryPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DirectoryPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDirectoryPoliciesRequest, ListDirectoryPoliciesResponse>
      listDirectoryPoliciesMethodDescriptor =
          MethodDescriptor.<ListDirectoryPoliciesRequest, ListDirectoryPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.lustre.v1.Lustre/ListDirectoryPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDirectoryPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDirectoryPoliciesResponse.getDefaultInstance()))
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

  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable;
  private final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable;
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable;
  private final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable;
  private final UnaryCallable<RescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceCallable;
  private final OperationCallable<RescheduleMaintenanceRequest, Instance, OperationMetadata>
      rescheduleMaintenanceOperationCallable;
  private final UnaryCallable<ImportDataRequest, Operation> importDataCallable;
  private final OperationCallable<ImportDataRequest, ImportDataResponse, ImportDataMetadata>
      importDataOperationCallable;
  private final UnaryCallable<ExportDataRequest, Operation> exportDataCallable;
  private final OperationCallable<ExportDataRequest, ExportDataResponse, ExportDataMetadata>
      exportDataOperationCallable;
  private final UnaryCallable<CreateMirrorRequest, Operation> createMirrorCallable;
  private final OperationCallable<CreateMirrorRequest, Mirror, CreateMirrorMetadata>
      createMirrorOperationCallable;
  private final UnaryCallable<UpdateMirrorRequest, Operation> updateMirrorCallable;
  private final OperationCallable<UpdateMirrorRequest, Mirror, OperationMetadata>
      updateMirrorOperationCallable;
  private final UnaryCallable<DeleteMirrorRequest, Operation> deleteMirrorCallable;
  private final OperationCallable<DeleteMirrorRequest, Empty, OperationMetadata>
      deleteMirrorOperationCallable;
  private final UnaryCallable<GetMirrorRequest, Mirror> getMirrorCallable;
  private final UnaryCallable<ListMirrorsRequest, ListMirrorsResponse> listMirrorsCallable;
  private final UnaryCallable<ListMirrorsRequest, ListMirrorsPagedResponse>
      listMirrorsPagedCallable;
  private final UnaryCallable<CreateDirectoryPolicyRequest, Operation>
      createDirectoryPolicyCallable;
  private final OperationCallable<CreateDirectoryPolicyRequest, DirectoryPolicy, OperationMetadata>
      createDirectoryPolicyOperationCallable;
  private final UnaryCallable<DeleteDirectoryPolicyRequest, Operation>
      deleteDirectoryPolicyCallable;
  private final OperationCallable<DeleteDirectoryPolicyRequest, Empty, OperationMetadata>
      deleteDirectoryPolicyOperationCallable;
  private final UnaryCallable<GetDirectoryPolicyRequest, DirectoryPolicy>
      getDirectoryPolicyCallable;
  private final UnaryCallable<ListDirectoryPoliciesRequest, ListDirectoryPoliciesResponse>
      listDirectoryPoliciesCallable;
  private final UnaryCallable<ListDirectoryPoliciesRequest, ListDirectoryPoliciesPagedResponse>
      listDirectoryPoliciesPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcLustreStub create(LustreStubSettings settings) throws IOException {
    return new GrpcLustreStub(settings, ClientContext.create(settings));
  }

  public static final GrpcLustreStub create(ClientContext clientContext) throws IOException {
    return new GrpcLustreStub(LustreStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcLustreStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcLustreStub(
        LustreStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcLustreStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcLustreStub(LustreStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcLustreCallableFactory());
  }

  /**
   * Constructs an instance of GrpcLustreStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcLustreStub(
      LustreStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesTransportSettings =
        GrpcCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
            .setMethodDescriptor(listInstancesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        GrpcCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateInstanceRequest, Operation> createInstanceTransportSettings =
        GrpcCallSettings.<CreateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateInstanceRequest, Operation> updateInstanceTransportSettings =
        GrpcCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance.name", String.valueOf(request.getInstance().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        GrpcCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<RescheduleMaintenanceRequest, Operation>
        rescheduleMaintenanceTransportSettings =
            GrpcCallSettings.<RescheduleMaintenanceRequest, Operation>newBuilder()
                .setMethodDescriptor(rescheduleMaintenanceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ImportDataRequest, Operation> importDataTransportSettings =
        GrpcCallSettings.<ImportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(importDataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ExportDataRequest, Operation> exportDataTransportSettings =
        GrpcCallSettings.<ExportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportDataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateMirrorRequest, Operation> createMirrorTransportSettings =
        GrpcCallSettings.<CreateMirrorRequest, Operation>newBuilder()
            .setMethodDescriptor(createMirrorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateMirrorRequest, Operation> updateMirrorTransportSettings =
        GrpcCallSettings.<UpdateMirrorRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMirrorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("mirror.name", String.valueOf(request.getMirror().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteMirrorRequest, Operation> deleteMirrorTransportSettings =
        GrpcCallSettings.<DeleteMirrorRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMirrorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetMirrorRequest, Mirror> getMirrorTransportSettings =
        GrpcCallSettings.<GetMirrorRequest, Mirror>newBuilder()
            .setMethodDescriptor(getMirrorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListMirrorsRequest, ListMirrorsResponse> listMirrorsTransportSettings =
        GrpcCallSettings.<ListMirrorsRequest, ListMirrorsResponse>newBuilder()
            .setMethodDescriptor(listMirrorsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<CreateDirectoryPolicyRequest, Operation>
        createDirectoryPolicyTransportSettings =
            GrpcCallSettings.<CreateDirectoryPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createDirectoryPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<DeleteDirectoryPolicyRequest, Operation>
        deleteDirectoryPolicyTransportSettings =
            GrpcCallSettings.<DeleteDirectoryPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDirectoryPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<GetDirectoryPolicyRequest, DirectoryPolicy>
        getDirectoryPolicyTransportSettings =
            GrpcCallSettings.<GetDirectoryPolicyRequest, DirectoryPolicy>newBuilder()
                .setMethodDescriptor(getDirectoryPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListDirectoryPoliciesRequest, ListDirectoryPoliciesResponse>
        listDirectoryPoliciesTransportSettings =
            GrpcCallSettings
                .<ListDirectoryPoliciesRequest, ListDirectoryPoliciesResponse>newBuilder()
                .setMethodDescriptor(listDirectoryPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
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

    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.createInstanceCallable =
        callableFactory.createUnaryCallable(
            createInstanceTransportSettings, settings.createInstanceSettings(), clientContext);
    this.createInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createInstanceTransportSettings,
            settings.createInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.updateInstanceCallable =
        callableFactory.createUnaryCallable(
            updateInstanceTransportSettings, settings.updateInstanceSettings(), clientContext);
    this.updateInstanceOperationCallable =
        callableFactory.createOperationCallable(
            updateInstanceTransportSettings,
            settings.updateInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.deleteInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstanceTransportSettings,
            settings.deleteInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.rescheduleMaintenanceCallable =
        callableFactory.createUnaryCallable(
            rescheduleMaintenanceTransportSettings,
            settings.rescheduleMaintenanceSettings(),
            clientContext);
    this.rescheduleMaintenanceOperationCallable =
        callableFactory.createOperationCallable(
            rescheduleMaintenanceTransportSettings,
            settings.rescheduleMaintenanceOperationSettings(),
            clientContext,
            operationsStub);
    this.importDataCallable =
        callableFactory.createUnaryCallable(
            importDataTransportSettings, settings.importDataSettings(), clientContext);
    this.importDataOperationCallable =
        callableFactory.createOperationCallable(
            importDataTransportSettings,
            settings.importDataOperationSettings(),
            clientContext,
            operationsStub);
    this.exportDataCallable =
        callableFactory.createUnaryCallable(
            exportDataTransportSettings, settings.exportDataSettings(), clientContext);
    this.exportDataOperationCallable =
        callableFactory.createOperationCallable(
            exportDataTransportSettings,
            settings.exportDataOperationSettings(),
            clientContext,
            operationsStub);
    this.createMirrorCallable =
        callableFactory.createUnaryCallable(
            createMirrorTransportSettings, settings.createMirrorSettings(), clientContext);
    this.createMirrorOperationCallable =
        callableFactory.createOperationCallable(
            createMirrorTransportSettings,
            settings.createMirrorOperationSettings(),
            clientContext,
            operationsStub);
    this.updateMirrorCallable =
        callableFactory.createUnaryCallable(
            updateMirrorTransportSettings, settings.updateMirrorSettings(), clientContext);
    this.updateMirrorOperationCallable =
        callableFactory.createOperationCallable(
            updateMirrorTransportSettings,
            settings.updateMirrorOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMirrorCallable =
        callableFactory.createUnaryCallable(
            deleteMirrorTransportSettings, settings.deleteMirrorSettings(), clientContext);
    this.deleteMirrorOperationCallable =
        callableFactory.createOperationCallable(
            deleteMirrorTransportSettings,
            settings.deleteMirrorOperationSettings(),
            clientContext,
            operationsStub);
    this.getMirrorCallable =
        callableFactory.createUnaryCallable(
            getMirrorTransportSettings, settings.getMirrorSettings(), clientContext);
    this.listMirrorsCallable =
        callableFactory.createUnaryCallable(
            listMirrorsTransportSettings, settings.listMirrorsSettings(), clientContext);
    this.listMirrorsPagedCallable =
        callableFactory.createPagedCallable(
            listMirrorsTransportSettings, settings.listMirrorsSettings(), clientContext);
    this.createDirectoryPolicyCallable =
        callableFactory.createUnaryCallable(
            createDirectoryPolicyTransportSettings,
            settings.createDirectoryPolicySettings(),
            clientContext);
    this.createDirectoryPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createDirectoryPolicyTransportSettings,
            settings.createDirectoryPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDirectoryPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteDirectoryPolicyTransportSettings,
            settings.deleteDirectoryPolicySettings(),
            clientContext);
    this.deleteDirectoryPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteDirectoryPolicyTransportSettings,
            settings.deleteDirectoryPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.getDirectoryPolicyCallable =
        callableFactory.createUnaryCallable(
            getDirectoryPolicyTransportSettings,
            settings.getDirectoryPolicySettings(),
            clientContext);
    this.listDirectoryPoliciesCallable =
        callableFactory.createUnaryCallable(
            listDirectoryPoliciesTransportSettings,
            settings.listDirectoryPoliciesSettings(),
            clientContext);
    this.listDirectoryPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listDirectoryPoliciesTransportSettings,
            settings.listDirectoryPoliciesSettings(),
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
  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  @Override
  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return createInstanceCallable;
  }

  @Override
  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return createInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return updateInstanceCallable;
  }

  @Override
  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return updateInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return deleteInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<RescheduleMaintenanceRequest, Operation> rescheduleMaintenanceCallable() {
    return rescheduleMaintenanceCallable;
  }

  @Override
  public OperationCallable<RescheduleMaintenanceRequest, Instance, OperationMetadata>
      rescheduleMaintenanceOperationCallable() {
    return rescheduleMaintenanceOperationCallable;
  }

  @Override
  public UnaryCallable<ImportDataRequest, Operation> importDataCallable() {
    return importDataCallable;
  }

  @Override
  public OperationCallable<ImportDataRequest, ImportDataResponse, ImportDataMetadata>
      importDataOperationCallable() {
    return importDataOperationCallable;
  }

  @Override
  public UnaryCallable<ExportDataRequest, Operation> exportDataCallable() {
    return exportDataCallable;
  }

  @Override
  public OperationCallable<ExportDataRequest, ExportDataResponse, ExportDataMetadata>
      exportDataOperationCallable() {
    return exportDataOperationCallable;
  }

  @Override
  public UnaryCallable<CreateMirrorRequest, Operation> createMirrorCallable() {
    return createMirrorCallable;
  }

  @Override
  public OperationCallable<CreateMirrorRequest, Mirror, CreateMirrorMetadata>
      createMirrorOperationCallable() {
    return createMirrorOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMirrorRequest, Operation> updateMirrorCallable() {
    return updateMirrorCallable;
  }

  @Override
  public OperationCallable<UpdateMirrorRequest, Mirror, OperationMetadata>
      updateMirrorOperationCallable() {
    return updateMirrorOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMirrorRequest, Operation> deleteMirrorCallable() {
    return deleteMirrorCallable;
  }

  @Override
  public OperationCallable<DeleteMirrorRequest, Empty, OperationMetadata>
      deleteMirrorOperationCallable() {
    return deleteMirrorOperationCallable;
  }

  @Override
  public UnaryCallable<GetMirrorRequest, Mirror> getMirrorCallable() {
    return getMirrorCallable;
  }

  @Override
  public UnaryCallable<ListMirrorsRequest, ListMirrorsResponse> listMirrorsCallable() {
    return listMirrorsCallable;
  }

  @Override
  public UnaryCallable<ListMirrorsRequest, ListMirrorsPagedResponse> listMirrorsPagedCallable() {
    return listMirrorsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateDirectoryPolicyRequest, Operation> createDirectoryPolicyCallable() {
    return createDirectoryPolicyCallable;
  }

  @Override
  public OperationCallable<CreateDirectoryPolicyRequest, DirectoryPolicy, OperationMetadata>
      createDirectoryPolicyOperationCallable() {
    return createDirectoryPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDirectoryPolicyRequest, Operation> deleteDirectoryPolicyCallable() {
    return deleteDirectoryPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteDirectoryPolicyRequest, Empty, OperationMetadata>
      deleteDirectoryPolicyOperationCallable() {
    return deleteDirectoryPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<GetDirectoryPolicyRequest, DirectoryPolicy> getDirectoryPolicyCallable() {
    return getDirectoryPolicyCallable;
  }

  @Override
  public UnaryCallable<ListDirectoryPoliciesRequest, ListDirectoryPoliciesResponse>
      listDirectoryPoliciesCallable() {
    return listDirectoryPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListDirectoryPoliciesRequest, ListDirectoryPoliciesPagedResponse>
      listDirectoryPoliciesPagedCallable() {
    return listDirectoryPoliciesPagedCallable;
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
