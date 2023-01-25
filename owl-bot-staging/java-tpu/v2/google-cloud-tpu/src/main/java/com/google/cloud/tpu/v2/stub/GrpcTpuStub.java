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

package com.google.cloud.tpu.v2.stub;

import static com.google.cloud.tpu.v2.TpuClient.ListAcceleratorTypesPagedResponse;
import static com.google.cloud.tpu.v2.TpuClient.ListLocationsPagedResponse;
import static com.google.cloud.tpu.v2.TpuClient.ListNodesPagedResponse;
import static com.google.cloud.tpu.v2.TpuClient.ListRuntimeVersionsPagedResponse;

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
import com.google.cloud.tpu.v2.AcceleratorType;
import com.google.cloud.tpu.v2.CreateNodeRequest;
import com.google.cloud.tpu.v2.DeleteNodeRequest;
import com.google.cloud.tpu.v2.GenerateServiceIdentityRequest;
import com.google.cloud.tpu.v2.GenerateServiceIdentityResponse;
import com.google.cloud.tpu.v2.GetAcceleratorTypeRequest;
import com.google.cloud.tpu.v2.GetGuestAttributesRequest;
import com.google.cloud.tpu.v2.GetGuestAttributesResponse;
import com.google.cloud.tpu.v2.GetNodeRequest;
import com.google.cloud.tpu.v2.GetRuntimeVersionRequest;
import com.google.cloud.tpu.v2.ListAcceleratorTypesRequest;
import com.google.cloud.tpu.v2.ListAcceleratorTypesResponse;
import com.google.cloud.tpu.v2.ListNodesRequest;
import com.google.cloud.tpu.v2.ListNodesResponse;
import com.google.cloud.tpu.v2.ListRuntimeVersionsRequest;
import com.google.cloud.tpu.v2.ListRuntimeVersionsResponse;
import com.google.cloud.tpu.v2.Node;
import com.google.cloud.tpu.v2.OperationMetadata;
import com.google.cloud.tpu.v2.RuntimeVersion;
import com.google.cloud.tpu.v2.StartNodeRequest;
import com.google.cloud.tpu.v2.StopNodeRequest;
import com.google.cloud.tpu.v2.UpdateNodeRequest;
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
 * gRPC stub implementation for the Tpu service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcTpuStub extends TpuStub {
  private static final MethodDescriptor<ListNodesRequest, ListNodesResponse>
      listNodesMethodDescriptor =
          MethodDescriptor.<ListNodesRequest, ListNodesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2.Tpu/ListNodes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListNodesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListNodesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNodeRequest, Node> getNodeMethodDescriptor =
      MethodDescriptor.<GetNodeRequest, Node>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v2.Tpu/GetNode")
          .setRequestMarshaller(ProtoUtils.marshaller(GetNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Node.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateNodeRequest, Operation> createNodeMethodDescriptor =
      MethodDescriptor.<CreateNodeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v2.Tpu/CreateNode")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteNodeRequest, Operation> deleteNodeMethodDescriptor =
      MethodDescriptor.<DeleteNodeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v2.Tpu/DeleteNode")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<StopNodeRequest, Operation> stopNodeMethodDescriptor =
      MethodDescriptor.<StopNodeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v2.Tpu/StopNode")
          .setRequestMarshaller(ProtoUtils.marshaller(StopNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<StartNodeRequest, Operation> startNodeMethodDescriptor =
      MethodDescriptor.<StartNodeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v2.Tpu/StartNode")
          .setRequestMarshaller(ProtoUtils.marshaller(StartNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateNodeRequest, Operation> updateNodeMethodDescriptor =
      MethodDescriptor.<UpdateNodeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v2.Tpu/UpdateNode")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<
          GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
      generateServiceIdentityMethodDescriptor =
          MethodDescriptor
              .<GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2.Tpu/GenerateServiceIdentity")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateServiceIdentityRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateServiceIdentityResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>
      listAcceleratorTypesMethodDescriptor =
          MethodDescriptor.<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2.Tpu/ListAcceleratorTypes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAcceleratorTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAcceleratorTypesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAcceleratorTypeRequest, AcceleratorType>
      getAcceleratorTypeMethodDescriptor =
          MethodDescriptor.<GetAcceleratorTypeRequest, AcceleratorType>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2.Tpu/GetAcceleratorType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAcceleratorTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AcceleratorType.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse>
      listRuntimeVersionsMethodDescriptor =
          MethodDescriptor.<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2.Tpu/ListRuntimeVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRuntimeVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRuntimeVersionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRuntimeVersionRequest, RuntimeVersion>
      getRuntimeVersionMethodDescriptor =
          MethodDescriptor.<GetRuntimeVersionRequest, RuntimeVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2.Tpu/GetRuntimeVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRuntimeVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RuntimeVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGuestAttributesRequest, GetGuestAttributesResponse>
      getGuestAttributesMethodDescriptor =
          MethodDescriptor.<GetGuestAttributesRequest, GetGuestAttributesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v2.Tpu/GetGuestAttributes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGuestAttributesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GetGuestAttributesResponse.getDefaultInstance()))
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
