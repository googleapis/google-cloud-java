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

package com.google.cloud.tpu.v2alpha1.stub;

import static com.google.cloud.tpu.v2alpha1.TpuClient.ListAcceleratorTypesPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListLocationsPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListNodesPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListQueuedResourcesPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListRuntimeVersionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.tpu.v2alpha1.AcceleratorType;
import com.google.cloud.tpu.v2alpha1.CreateNodeRequest;
import com.google.cloud.tpu.v2alpha1.CreateQueuedResourceRequest;
import com.google.cloud.tpu.v2alpha1.DeleteNodeRequest;
import com.google.cloud.tpu.v2alpha1.DeleteQueuedResourceRequest;
import com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityRequest;
import com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityResponse;
import com.google.cloud.tpu.v2alpha1.GetAcceleratorTypeRequest;
import com.google.cloud.tpu.v2alpha1.GetGuestAttributesRequest;
import com.google.cloud.tpu.v2alpha1.GetGuestAttributesResponse;
import com.google.cloud.tpu.v2alpha1.GetNodeRequest;
import com.google.cloud.tpu.v2alpha1.GetQueuedResourceRequest;
import com.google.cloud.tpu.v2alpha1.GetRuntimeVersionRequest;
import com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesRequest;
import com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesResponse;
import com.google.cloud.tpu.v2alpha1.ListNodesRequest;
import com.google.cloud.tpu.v2alpha1.ListNodesResponse;
import com.google.cloud.tpu.v2alpha1.ListQueuedResourcesRequest;
import com.google.cloud.tpu.v2alpha1.ListQueuedResourcesResponse;
import com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsRequest;
import com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsResponse;
import com.google.cloud.tpu.v2alpha1.Node;
import com.google.cloud.tpu.v2alpha1.OperationMetadata;
import com.google.cloud.tpu.v2alpha1.QueuedResource;
import com.google.cloud.tpu.v2alpha1.RuntimeVersion;
import com.google.cloud.tpu.v2alpha1.SimulateMaintenanceEventRequest;
import com.google.cloud.tpu.v2alpha1.StartNodeRequest;
import com.google.cloud.tpu.v2alpha1.StopNodeRequest;
import com.google.cloud.tpu.v2alpha1.UpdateNodeRequest;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the Tpu service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcTpuStub extends TpuStub {
  private static final MethodDescriptor<ListNodesRequest, ListNodesResponse>
      listNodesMethodDescriptor =
          MethodDescriptor.<ListNodesRequest, ListNodesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/ListNodes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListNodesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListNodesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNodeRequest, Node> getNodeMethodDescriptor =
      MethodDescriptor.<GetNodeRequest, Node>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/GetNode")
          .setRequestMarshaller(ProtoUtils.marshaller(GetNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Node.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateNodeRequest, Operation> createNodeMethodDescriptor =
      MethodDescriptor.<CreateNodeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/CreateNode")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteNodeRequest, Operation> deleteNodeMethodDescriptor =
      MethodDescriptor.<DeleteNodeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/DeleteNode")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<StopNodeRequest, Operation> stopNodeMethodDescriptor =
      MethodDescriptor.<StopNodeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/StopNode")
          .setRequestMarshaller(ProtoUtils.marshaller(StopNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<StartNodeRequest, Operation> startNodeMethodDescriptor =
      MethodDescriptor.<StartNodeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/StartNode")
          .setRequestMarshaller(ProtoUtils.marshaller(StartNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateNodeRequest, Operation> updateNodeMethodDescriptor =
      MethodDescriptor.<UpdateNodeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/UpdateNode")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListQueuedResourcesRequest, ListQueuedResourcesResponse>
      listQueuedResourcesMethodDescriptor =
          MethodDescriptor.<ListQueuedResourcesRequest, ListQueuedResourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/ListQueuedResources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListQueuedResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListQueuedResourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetQueuedResourceRequest, QueuedResource>
      getQueuedResourceMethodDescriptor =
          MethodDescriptor.<GetQueuedResourceRequest, QueuedResource>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/GetQueuedResource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetQueuedResourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(QueuedResource.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateQueuedResourceRequest, Operation>
      createQueuedResourceMethodDescriptor =
          MethodDescriptor.<CreateQueuedResourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/CreateQueuedResource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateQueuedResourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteQueuedResourceRequest, Operation>
      deleteQueuedResourceMethodDescriptor =
          MethodDescriptor.<DeleteQueuedResourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/DeleteQueuedResource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteQueuedResourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
      generateServiceIdentityMethodDescriptor =
          MethodDescriptor
              .<GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/GenerateServiceIdentity")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateServiceIdentityRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateServiceIdentityResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>
      listAcceleratorTypesMethodDescriptor =
          MethodDescriptor.<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/ListAcceleratorTypes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAcceleratorTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAcceleratorTypesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAcceleratorTypeRequest, AcceleratorType>
      getAcceleratorTypeMethodDescriptor =
          MethodDescriptor.<GetAcceleratorTypeRequest, AcceleratorType>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/GetAcceleratorType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAcceleratorTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AcceleratorType.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse>
      listRuntimeVersionsMethodDescriptor =
          MethodDescriptor.<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/ListRuntimeVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRuntimeVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRuntimeVersionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRuntimeVersionRequest, RuntimeVersion>
      getRuntimeVersionMethodDescriptor =
          MethodDescriptor.<GetRuntimeVersionRequest, RuntimeVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/GetRuntimeVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRuntimeVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RuntimeVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGuestAttributesRequest, GetGuestAttributesResponse>
      getGuestAttributesMethodDescriptor =
          MethodDescriptor.<GetGuestAttributesRequest, GetGuestAttributesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/GetGuestAttributes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGuestAttributesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GetGuestAttributesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SimulateMaintenanceEventRequest, Operation>
      simulateMaintenanceEventMethodDescriptor =
          MethodDescriptor.<SimulateMaintenanceEventRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2alpha1.Tpu/SimulateMaintenanceEvent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SimulateMaintenanceEventRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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

  private final UnaryCallable<ListNodesRequest, ListNodesResponse> listNodesCallable;
  private final UnaryCallable<ListNodesRequest, ListNodesPagedResponse> listNodesPagedCallable;
  private final UnaryCallable<GetNodeRequest, Node> getNodeCallable;
  private final UnaryCallable<CreateNodeRequest, Operation> createNodeCallable;
  private final OperationCallable<CreateNodeRequest, Node, OperationMetadata>
      createNodeOperationCallable;
  private final UnaryCallable<DeleteNodeRequest, Operation> deleteNodeCallable;
  private final OperationCallable<DeleteNodeRequest, Empty, OperationMetadata>
      deleteNodeOperationCallable;
  private final UnaryCallable<StopNodeRequest, Operation> stopNodeCallable;
  private final OperationCallable<StopNodeRequest, Node, OperationMetadata>
      stopNodeOperationCallable;
  private final UnaryCallable<StartNodeRequest, Operation> startNodeCallable;
  private final OperationCallable<StartNodeRequest, Node, OperationMetadata>
      startNodeOperationCallable;
  private final UnaryCallable<UpdateNodeRequest, Operation> updateNodeCallable;
  private final OperationCallable<UpdateNodeRequest, Node, OperationMetadata>
      updateNodeOperationCallable;
  private final UnaryCallable<ListQueuedResourcesRequest, ListQueuedResourcesResponse>
      listQueuedResourcesCallable;
  private final UnaryCallable<ListQueuedResourcesRequest, ListQueuedResourcesPagedResponse>
      listQueuedResourcesPagedCallable;
  private final UnaryCallable<GetQueuedResourceRequest, QueuedResource> getQueuedResourceCallable;
  private final UnaryCallable<CreateQueuedResourceRequest, Operation> createQueuedResourceCallable;
  private final OperationCallable<CreateQueuedResourceRequest, QueuedResource, OperationMetadata>
      createQueuedResourceOperationCallable;
  private final UnaryCallable<DeleteQueuedResourceRequest, Operation> deleteQueuedResourceCallable;
  private final OperationCallable<DeleteQueuedResourceRequest, QueuedResource, OperationMetadata>
      deleteQueuedResourceOperationCallable;
  private final UnaryCallable<GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
      generateServiceIdentityCallable;
  private final UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>
      listAcceleratorTypesCallable;
  private final UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesPagedCallable;
  private final UnaryCallable<GetAcceleratorTypeRequest, AcceleratorType>
      getAcceleratorTypeCallable;
  private final UnaryCallable<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse>
      listRuntimeVersionsCallable;
  private final UnaryCallable<ListRuntimeVersionsRequest, ListRuntimeVersionsPagedResponse>
      listRuntimeVersionsPagedCallable;
  private final UnaryCallable<GetRuntimeVersionRequest, RuntimeVersion> getRuntimeVersionCallable;
  private final UnaryCallable<GetGuestAttributesRequest, GetGuestAttributesResponse>
      getGuestAttributesCallable;
  private final UnaryCallable<SimulateMaintenanceEventRequest, Operation>
      simulateMaintenanceEventCallable;
  private final OperationCallable<SimulateMaintenanceEventRequest, Node, OperationMetadata>
      simulateMaintenanceEventOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTpuStub create(TpuStubSettings settings) throws IOException {
    return new GrpcTpuStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTpuStub create(ClientContext clientContext) throws IOException {
    return new GrpcTpuStub(TpuStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTpuStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTpuStub(TpuStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTpuStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcTpuStub(TpuStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcTpuCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTpuStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcTpuStub(
      TpuStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListNodesRequest, ListNodesResponse> listNodesTransportSettings =
        GrpcCallSettings.<ListNodesRequest, ListNodesResponse>newBuilder()
            .setMethodDescriptor(listNodesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetNodeRequest, Node> getNodeTransportSettings =
        GrpcCallSettings.<GetNodeRequest, Node>newBuilder()
            .setMethodDescriptor(getNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateNodeRequest, Operation> createNodeTransportSettings =
        GrpcCallSettings.<CreateNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(createNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteNodeRequest, Operation> deleteNodeTransportSettings =
        GrpcCallSettings.<DeleteNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StopNodeRequest, Operation> stopNodeTransportSettings =
        GrpcCallSettings.<StopNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(stopNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StartNodeRequest, Operation> startNodeTransportSettings =
        GrpcCallSettings.<StartNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(startNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateNodeRequest, Operation> updateNodeTransportSettings =
        GrpcCallSettings.<UpdateNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("node.name", String.valueOf(request.getNode().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListQueuedResourcesRequest, ListQueuedResourcesResponse>
        listQueuedResourcesTransportSettings =
            GrpcCallSettings.<ListQueuedResourcesRequest, ListQueuedResourcesResponse>newBuilder()
                .setMethodDescriptor(listQueuedResourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetQueuedResourceRequest, QueuedResource> getQueuedResourceTransportSettings =
        GrpcCallSettings.<GetQueuedResourceRequest, QueuedResource>newBuilder()
            .setMethodDescriptor(getQueuedResourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateQueuedResourceRequest, Operation> createQueuedResourceTransportSettings =
        GrpcCallSettings.<CreateQueuedResourceRequest, Operation>newBuilder()
            .setMethodDescriptor(createQueuedResourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteQueuedResourceRequest, Operation> deleteQueuedResourceTransportSettings =
        GrpcCallSettings.<DeleteQueuedResourceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteQueuedResourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
        generateServiceIdentityTransportSettings =
            GrpcCallSettings
                .<GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>newBuilder()
                .setMethodDescriptor(generateServiceIdentityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>
        listAcceleratorTypesTransportSettings =
            GrpcCallSettings.<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>newBuilder()
                .setMethodDescriptor(listAcceleratorTypesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetAcceleratorTypeRequest, AcceleratorType>
        getAcceleratorTypeTransportSettings =
            GrpcCallSettings.<GetAcceleratorTypeRequest, AcceleratorType>newBuilder()
                .setMethodDescriptor(getAcceleratorTypeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse>
        listRuntimeVersionsTransportSettings =
            GrpcCallSettings.<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse>newBuilder()
                .setMethodDescriptor(listRuntimeVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetRuntimeVersionRequest, RuntimeVersion> getRuntimeVersionTransportSettings =
        GrpcCallSettings.<GetRuntimeVersionRequest, RuntimeVersion>newBuilder()
            .setMethodDescriptor(getRuntimeVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetGuestAttributesRequest, GetGuestAttributesResponse>
        getGuestAttributesTransportSettings =
            GrpcCallSettings.<GetGuestAttributesRequest, GetGuestAttributesResponse>newBuilder()
                .setMethodDescriptor(getGuestAttributesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SimulateMaintenanceEventRequest, Operation>
        simulateMaintenanceEventTransportSettings =
            GrpcCallSettings.<SimulateMaintenanceEventRequest, Operation>newBuilder()
                .setMethodDescriptor(simulateMaintenanceEventMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
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

    this.listNodesCallable =
        callableFactory.createUnaryCallable(
            listNodesTransportSettings, settings.listNodesSettings(), clientContext);
    this.listNodesPagedCallable =
        callableFactory.createPagedCallable(
            listNodesTransportSettings, settings.listNodesSettings(), clientContext);
    this.getNodeCallable =
        callableFactory.createUnaryCallable(
            getNodeTransportSettings, settings.getNodeSettings(), clientContext);
    this.createNodeCallable =
        callableFactory.createUnaryCallable(
            createNodeTransportSettings, settings.createNodeSettings(), clientContext);
    this.createNodeOperationCallable =
        callableFactory.createOperationCallable(
            createNodeTransportSettings,
            settings.createNodeOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteNodeCallable =
        callableFactory.createUnaryCallable(
            deleteNodeTransportSettings, settings.deleteNodeSettings(), clientContext);
    this.deleteNodeOperationCallable =
        callableFactory.createOperationCallable(
            deleteNodeTransportSettings,
            settings.deleteNodeOperationSettings(),
            clientContext,
            operationsStub);
    this.stopNodeCallable =
        callableFactory.createUnaryCallable(
            stopNodeTransportSettings, settings.stopNodeSettings(), clientContext);
    this.stopNodeOperationCallable =
        callableFactory.createOperationCallable(
            stopNodeTransportSettings,
            settings.stopNodeOperationSettings(),
            clientContext,
            operationsStub);
    this.startNodeCallable =
        callableFactory.createUnaryCallable(
            startNodeTransportSettings, settings.startNodeSettings(), clientContext);
    this.startNodeOperationCallable =
        callableFactory.createOperationCallable(
            startNodeTransportSettings,
            settings.startNodeOperationSettings(),
            clientContext,
            operationsStub);
    this.updateNodeCallable =
        callableFactory.createUnaryCallable(
            updateNodeTransportSettings, settings.updateNodeSettings(), clientContext);
    this.updateNodeOperationCallable =
        callableFactory.createOperationCallable(
            updateNodeTransportSettings,
            settings.updateNodeOperationSettings(),
            clientContext,
            operationsStub);
    this.listQueuedResourcesCallable =
        callableFactory.createUnaryCallable(
            listQueuedResourcesTransportSettings,
            settings.listQueuedResourcesSettings(),
            clientContext);
    this.listQueuedResourcesPagedCallable =
        callableFactory.createPagedCallable(
            listQueuedResourcesTransportSettings,
            settings.listQueuedResourcesSettings(),
            clientContext);
    this.getQueuedResourceCallable =
        callableFactory.createUnaryCallable(
            getQueuedResourceTransportSettings,
            settings.getQueuedResourceSettings(),
            clientContext);
    this.createQueuedResourceCallable =
        callableFactory.createUnaryCallable(
            createQueuedResourceTransportSettings,
            settings.createQueuedResourceSettings(),
            clientContext);
    this.createQueuedResourceOperationCallable =
        callableFactory.createOperationCallable(
            createQueuedResourceTransportSettings,
            settings.createQueuedResourceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteQueuedResourceCallable =
        callableFactory.createUnaryCallable(
            deleteQueuedResourceTransportSettings,
            settings.deleteQueuedResourceSettings(),
            clientContext);
    this.deleteQueuedResourceOperationCallable =
        callableFactory.createOperationCallable(
            deleteQueuedResourceTransportSettings,
            settings.deleteQueuedResourceOperationSettings(),
            clientContext,
            operationsStub);
    this.generateServiceIdentityCallable =
        callableFactory.createUnaryCallable(
            generateServiceIdentityTransportSettings,
            settings.generateServiceIdentitySettings(),
            clientContext);
    this.listAcceleratorTypesCallable =
        callableFactory.createUnaryCallable(
            listAcceleratorTypesTransportSettings,
            settings.listAcceleratorTypesSettings(),
            clientContext);
    this.listAcceleratorTypesPagedCallable =
        callableFactory.createPagedCallable(
            listAcceleratorTypesTransportSettings,
            settings.listAcceleratorTypesSettings(),
            clientContext);
    this.getAcceleratorTypeCallable =
        callableFactory.createUnaryCallable(
            getAcceleratorTypeTransportSettings,
            settings.getAcceleratorTypeSettings(),
            clientContext);
    this.listRuntimeVersionsCallable =
        callableFactory.createUnaryCallable(
            listRuntimeVersionsTransportSettings,
            settings.listRuntimeVersionsSettings(),
            clientContext);
    this.listRuntimeVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listRuntimeVersionsTransportSettings,
            settings.listRuntimeVersionsSettings(),
            clientContext);
    this.getRuntimeVersionCallable =
        callableFactory.createUnaryCallable(
            getRuntimeVersionTransportSettings,
            settings.getRuntimeVersionSettings(),
            clientContext);
    this.getGuestAttributesCallable =
        callableFactory.createUnaryCallable(
            getGuestAttributesTransportSettings,
            settings.getGuestAttributesSettings(),
            clientContext);
    this.simulateMaintenanceEventCallable =
        callableFactory.createUnaryCallable(
            simulateMaintenanceEventTransportSettings,
            settings.simulateMaintenanceEventSettings(),
            clientContext);
    this.simulateMaintenanceEventOperationCallable =
        callableFactory.createOperationCallable(
            simulateMaintenanceEventTransportSettings,
            settings.simulateMaintenanceEventOperationSettings(),
            clientContext,
            operationsStub);
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
  public UnaryCallable<ListNodesRequest, ListNodesResponse> listNodesCallable() {
    return listNodesCallable;
  }

  @Override
  public UnaryCallable<ListNodesRequest, ListNodesPagedResponse> listNodesPagedCallable() {
    return listNodesPagedCallable;
  }

  @Override
  public UnaryCallable<GetNodeRequest, Node> getNodeCallable() {
    return getNodeCallable;
  }

  @Override
  public UnaryCallable<CreateNodeRequest, Operation> createNodeCallable() {
    return createNodeCallable;
  }

  @Override
  public OperationCallable<CreateNodeRequest, Node, OperationMetadata>
      createNodeOperationCallable() {
    return createNodeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteNodeRequest, Operation> deleteNodeCallable() {
    return deleteNodeCallable;
  }

  @Override
  public OperationCallable<DeleteNodeRequest, Empty, OperationMetadata>
      deleteNodeOperationCallable() {
    return deleteNodeOperationCallable;
  }

  @Override
  public UnaryCallable<StopNodeRequest, Operation> stopNodeCallable() {
    return stopNodeCallable;
  }

  @Override
  public OperationCallable<StopNodeRequest, Node, OperationMetadata> stopNodeOperationCallable() {
    return stopNodeOperationCallable;
  }

  @Override
  public UnaryCallable<StartNodeRequest, Operation> startNodeCallable() {
    return startNodeCallable;
  }

  @Override
  public OperationCallable<StartNodeRequest, Node, OperationMetadata> startNodeOperationCallable() {
    return startNodeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateNodeRequest, Operation> updateNodeCallable() {
    return updateNodeCallable;
  }

  @Override
  public OperationCallable<UpdateNodeRequest, Node, OperationMetadata>
      updateNodeOperationCallable() {
    return updateNodeOperationCallable;
  }

  @Override
  public UnaryCallable<ListQueuedResourcesRequest, ListQueuedResourcesResponse>
      listQueuedResourcesCallable() {
    return listQueuedResourcesCallable;
  }

  @Override
  public UnaryCallable<ListQueuedResourcesRequest, ListQueuedResourcesPagedResponse>
      listQueuedResourcesPagedCallable() {
    return listQueuedResourcesPagedCallable;
  }

  @Override
  public UnaryCallable<GetQueuedResourceRequest, QueuedResource> getQueuedResourceCallable() {
    return getQueuedResourceCallable;
  }

  @Override
  public UnaryCallable<CreateQueuedResourceRequest, Operation> createQueuedResourceCallable() {
    return createQueuedResourceCallable;
  }

  @Override
  public OperationCallable<CreateQueuedResourceRequest, QueuedResource, OperationMetadata>
      createQueuedResourceOperationCallable() {
    return createQueuedResourceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteQueuedResourceRequest, Operation> deleteQueuedResourceCallable() {
    return deleteQueuedResourceCallable;
  }

  @Override
  public OperationCallable<DeleteQueuedResourceRequest, QueuedResource, OperationMetadata>
      deleteQueuedResourceOperationCallable() {
    return deleteQueuedResourceOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
      generateServiceIdentityCallable() {
    return generateServiceIdentityCallable;
  }

  @Override
  public UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>
      listAcceleratorTypesCallable() {
    return listAcceleratorTypesCallable;
  }

  @Override
  public UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesPagedCallable() {
    return listAcceleratorTypesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAcceleratorTypeRequest, AcceleratorType> getAcceleratorTypeCallable() {
    return getAcceleratorTypeCallable;
  }

  @Override
  public UnaryCallable<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse>
      listRuntimeVersionsCallable() {
    return listRuntimeVersionsCallable;
  }

  @Override
  public UnaryCallable<ListRuntimeVersionsRequest, ListRuntimeVersionsPagedResponse>
      listRuntimeVersionsPagedCallable() {
    return listRuntimeVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRuntimeVersionRequest, RuntimeVersion> getRuntimeVersionCallable() {
    return getRuntimeVersionCallable;
  }

  @Override
  public UnaryCallable<GetGuestAttributesRequest, GetGuestAttributesResponse>
      getGuestAttributesCallable() {
    return getGuestAttributesCallable;
  }

  @Override
  public UnaryCallable<SimulateMaintenanceEventRequest, Operation>
      simulateMaintenanceEventCallable() {
    return simulateMaintenanceEventCallable;
  }

  @Override
  public OperationCallable<SimulateMaintenanceEventRequest, Node, OperationMetadata>
      simulateMaintenanceEventOperationCallable() {
    return simulateMaintenanceEventOperationCallable;
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
