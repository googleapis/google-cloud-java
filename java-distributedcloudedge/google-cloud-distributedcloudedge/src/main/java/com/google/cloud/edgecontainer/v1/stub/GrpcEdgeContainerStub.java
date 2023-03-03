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

package com.google.cloud.edgecontainer.v1.stub;

import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListClustersPagedResponse;
import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListMachinesPagedResponse;
import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListNodePoolsPagedResponse;
import static com.google.cloud.edgecontainer.v1.EdgeContainerClient.ListVpnConnectionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.edgecontainer.v1.Cluster;
import com.google.cloud.edgecontainer.v1.CreateClusterRequest;
import com.google.cloud.edgecontainer.v1.CreateNodePoolRequest;
import com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest;
import com.google.cloud.edgecontainer.v1.DeleteClusterRequest;
import com.google.cloud.edgecontainer.v1.DeleteNodePoolRequest;
import com.google.cloud.edgecontainer.v1.DeleteVpnConnectionRequest;
import com.google.cloud.edgecontainer.v1.GenerateAccessTokenRequest;
import com.google.cloud.edgecontainer.v1.GenerateAccessTokenResponse;
import com.google.cloud.edgecontainer.v1.GetClusterRequest;
import com.google.cloud.edgecontainer.v1.GetMachineRequest;
import com.google.cloud.edgecontainer.v1.GetNodePoolRequest;
import com.google.cloud.edgecontainer.v1.GetVpnConnectionRequest;
import com.google.cloud.edgecontainer.v1.ListClustersRequest;
import com.google.cloud.edgecontainer.v1.ListClustersResponse;
import com.google.cloud.edgecontainer.v1.ListMachinesRequest;
import com.google.cloud.edgecontainer.v1.ListMachinesResponse;
import com.google.cloud.edgecontainer.v1.ListNodePoolsRequest;
import com.google.cloud.edgecontainer.v1.ListNodePoolsResponse;
import com.google.cloud.edgecontainer.v1.ListVpnConnectionsRequest;
import com.google.cloud.edgecontainer.v1.ListVpnConnectionsResponse;
import com.google.cloud.edgecontainer.v1.Machine;
import com.google.cloud.edgecontainer.v1.NodePool;
import com.google.cloud.edgecontainer.v1.OperationMetadata;
import com.google.cloud.edgecontainer.v1.UpdateClusterRequest;
import com.google.cloud.edgecontainer.v1.UpdateNodePoolRequest;
import com.google.cloud.edgecontainer.v1.VpnConnection;
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
 * gRPC stub implementation for the EdgeContainer service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcEdgeContainerStub extends EdgeContainerStub {
  private static final MethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          MethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/ListClusters")
              .setRequestMarshaller(ProtoUtils.marshaller(ListClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListClustersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetClusterRequest, Cluster> getClusterMethodDescriptor =
      MethodDescriptor.<GetClusterRequest, Cluster>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/GetCluster")
          .setRequestMarshaller(ProtoUtils.marshaller(GetClusterRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Cluster.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateClusterRequest, Operation>
      createClusterMethodDescriptor =
          MethodDescriptor.<CreateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/CreateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateClusterRequest, Operation>
      updateClusterMethodDescriptor =
          MethodDescriptor.<UpdateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/UpdateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteClusterRequest, Operation>
      deleteClusterMethodDescriptor =
          MethodDescriptor.<DeleteClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/DeleteCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenMethodDescriptor =
          MethodDescriptor.<GenerateAccessTokenRequest, GenerateAccessTokenResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/GenerateAccessToken")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateAccessTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateAccessTokenResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListNodePoolsRequest, ListNodePoolsResponse>
      listNodePoolsMethodDescriptor =
          MethodDescriptor.<ListNodePoolsRequest, ListNodePoolsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/ListNodePools")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNodePoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNodePoolsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNodePoolRequest, NodePool> getNodePoolMethodDescriptor =
      MethodDescriptor.<GetNodePoolRequest, NodePool>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/GetNodePool")
          .setRequestMarshaller(ProtoUtils.marshaller(GetNodePoolRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(NodePool.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateNodePoolRequest, Operation>
      createNodePoolMethodDescriptor =
          MethodDescriptor.<CreateNodePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/CreateNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateNodePoolRequest, Operation>
      updateNodePoolMethodDescriptor =
          MethodDescriptor.<UpdateNodePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/UpdateNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNodePoolRequest, Operation>
      deleteNodePoolMethodDescriptor =
          MethodDescriptor.<DeleteNodePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/DeleteNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMachinesRequest, ListMachinesResponse>
      listMachinesMethodDescriptor =
          MethodDescriptor.<ListMachinesRequest, ListMachinesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/ListMachines")
              .setRequestMarshaller(ProtoUtils.marshaller(ListMachinesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMachinesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMachineRequest, Machine> getMachineMethodDescriptor =
      MethodDescriptor.<GetMachineRequest, Machine>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/GetMachine")
          .setRequestMarshaller(ProtoUtils.marshaller(GetMachineRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Machine.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListVpnConnectionsRequest, ListVpnConnectionsResponse>
      listVpnConnectionsMethodDescriptor =
          MethodDescriptor.<ListVpnConnectionsRequest, ListVpnConnectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/ListVpnConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListVpnConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVpnConnectionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVpnConnectionRequest, VpnConnection>
      getVpnConnectionMethodDescriptor =
          MethodDescriptor.<GetVpnConnectionRequest, VpnConnection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/GetVpnConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetVpnConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(VpnConnection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateVpnConnectionRequest, Operation>
      createVpnConnectionMethodDescriptor =
          MethodDescriptor.<CreateVpnConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/CreateVpnConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateVpnConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteVpnConnectionRequest, Operation>
      deleteVpnConnectionMethodDescriptor =
          MethodDescriptor.<DeleteVpnConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.edgecontainer.v1.EdgeContainer/DeleteVpnConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteVpnConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable;
  private final UnaryCallable<ListClustersRequest, ListClustersPagedResponse>
      listClustersPagedCallable;
  private final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable;
  private final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable;
  private final OperationCallable<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationCallable;
  private final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable;
  private final OperationCallable<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationCallable;
  private final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable;
  private final OperationCallable<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationCallable;
  private final UnaryCallable<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenCallable;
  private final UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsCallable;
  private final UnaryCallable<ListNodePoolsRequest, ListNodePoolsPagedResponse>
      listNodePoolsPagedCallable;
  private final UnaryCallable<GetNodePoolRequest, NodePool> getNodePoolCallable;
  private final UnaryCallable<CreateNodePoolRequest, Operation> createNodePoolCallable;
  private final OperationCallable<CreateNodePoolRequest, NodePool, OperationMetadata>
      createNodePoolOperationCallable;
  private final UnaryCallable<UpdateNodePoolRequest, Operation> updateNodePoolCallable;
  private final OperationCallable<UpdateNodePoolRequest, NodePool, OperationMetadata>
      updateNodePoolOperationCallable;
  private final UnaryCallable<DeleteNodePoolRequest, Operation> deleteNodePoolCallable;
  private final OperationCallable<DeleteNodePoolRequest, Empty, OperationMetadata>
      deleteNodePoolOperationCallable;
  private final UnaryCallable<ListMachinesRequest, ListMachinesResponse> listMachinesCallable;
  private final UnaryCallable<ListMachinesRequest, ListMachinesPagedResponse>
      listMachinesPagedCallable;
  private final UnaryCallable<GetMachineRequest, Machine> getMachineCallable;
  private final UnaryCallable<ListVpnConnectionsRequest, ListVpnConnectionsResponse>
      listVpnConnectionsCallable;
  private final UnaryCallable<ListVpnConnectionsRequest, ListVpnConnectionsPagedResponse>
      listVpnConnectionsPagedCallable;
  private final UnaryCallable<GetVpnConnectionRequest, VpnConnection> getVpnConnectionCallable;
  private final UnaryCallable<CreateVpnConnectionRequest, Operation> createVpnConnectionCallable;
  private final OperationCallable<CreateVpnConnectionRequest, VpnConnection, OperationMetadata>
      createVpnConnectionOperationCallable;
  private final UnaryCallable<DeleteVpnConnectionRequest, Operation> deleteVpnConnectionCallable;
  private final OperationCallable<DeleteVpnConnectionRequest, Empty, OperationMetadata>
      deleteVpnConnectionOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEdgeContainerStub create(EdgeContainerStubSettings settings)
      throws IOException {
    return new GrpcEdgeContainerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEdgeContainerStub create(ClientContext clientContext) throws IOException {
    return new GrpcEdgeContainerStub(EdgeContainerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEdgeContainerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEdgeContainerStub(
        EdgeContainerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEdgeContainerStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEdgeContainerStub(EdgeContainerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcEdgeContainerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEdgeContainerStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEdgeContainerStub(
      EdgeContainerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListClustersRequest, ListClustersResponse> listClustersTransportSettings =
        GrpcCallSettings.<ListClustersRequest, ListClustersResponse>newBuilder()
            .setMethodDescriptor(listClustersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetClusterRequest, Cluster> getClusterTransportSettings =
        GrpcCallSettings.<GetClusterRequest, Cluster>newBuilder()
            .setMethodDescriptor(getClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateClusterRequest, Operation> createClusterTransportSettings =
        GrpcCallSettings.<CreateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateClusterRequest, Operation> updateClusterTransportSettings =
        GrpcCallSettings.<UpdateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster.name", String.valueOf(request.getCluster().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteClusterRequest, Operation> deleteClusterTransportSettings =
        GrpcCallSettings.<DeleteClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
        generateAccessTokenTransportSettings =
            GrpcCallSettings.<GenerateAccessTokenRequest, GenerateAccessTokenResponse>newBuilder()
                .setMethodDescriptor(generateAccessTokenMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("cluster", String.valueOf(request.getCluster()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsTransportSettings =
        GrpcCallSettings.<ListNodePoolsRequest, ListNodePoolsResponse>newBuilder()
            .setMethodDescriptor(listNodePoolsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetNodePoolRequest, NodePool> getNodePoolTransportSettings =
        GrpcCallSettings.<GetNodePoolRequest, NodePool>newBuilder()
            .setMethodDescriptor(getNodePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateNodePoolRequest, Operation> createNodePoolTransportSettings =
        GrpcCallSettings.<CreateNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createNodePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateNodePoolRequest, Operation> updateNodePoolTransportSettings =
        GrpcCallSettings.<UpdateNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNodePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("node_pool.name", String.valueOf(request.getNodePool().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteNodePoolRequest, Operation> deleteNodePoolTransportSettings =
        GrpcCallSettings.<DeleteNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNodePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListMachinesRequest, ListMachinesResponse> listMachinesTransportSettings =
        GrpcCallSettings.<ListMachinesRequest, ListMachinesResponse>newBuilder()
            .setMethodDescriptor(listMachinesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetMachineRequest, Machine> getMachineTransportSettings =
        GrpcCallSettings.<GetMachineRequest, Machine>newBuilder()
            .setMethodDescriptor(getMachineMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListVpnConnectionsRequest, ListVpnConnectionsResponse>
        listVpnConnectionsTransportSettings =
            GrpcCallSettings.<ListVpnConnectionsRequest, ListVpnConnectionsResponse>newBuilder()
                .setMethodDescriptor(listVpnConnectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetVpnConnectionRequest, VpnConnection> getVpnConnectionTransportSettings =
        GrpcCallSettings.<GetVpnConnectionRequest, VpnConnection>newBuilder()
            .setMethodDescriptor(getVpnConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateVpnConnectionRequest, Operation> createVpnConnectionTransportSettings =
        GrpcCallSettings.<CreateVpnConnectionRequest, Operation>newBuilder()
            .setMethodDescriptor(createVpnConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteVpnConnectionRequest, Operation> deleteVpnConnectionTransportSettings =
        GrpcCallSettings.<DeleteVpnConnectionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteVpnConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listClustersCallable =
        callableFactory.createUnaryCallable(
            listClustersTransportSettings, settings.listClustersSettings(), clientContext);
    this.listClustersPagedCallable =
        callableFactory.createPagedCallable(
            listClustersTransportSettings, settings.listClustersSettings(), clientContext);
    this.getClusterCallable =
        callableFactory.createUnaryCallable(
            getClusterTransportSettings, settings.getClusterSettings(), clientContext);
    this.createClusterCallable =
        callableFactory.createUnaryCallable(
            createClusterTransportSettings, settings.createClusterSettings(), clientContext);
    this.createClusterOperationCallable =
        callableFactory.createOperationCallable(
            createClusterTransportSettings,
            settings.createClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.updateClusterCallable =
        callableFactory.createUnaryCallable(
            updateClusterTransportSettings, settings.updateClusterSettings(), clientContext);
    this.updateClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateClusterTransportSettings,
            settings.updateClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteClusterCallable =
        callableFactory.createUnaryCallable(
            deleteClusterTransportSettings, settings.deleteClusterSettings(), clientContext);
    this.deleteClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteClusterTransportSettings,
            settings.deleteClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.generateAccessTokenCallable =
        callableFactory.createUnaryCallable(
            generateAccessTokenTransportSettings,
            settings.generateAccessTokenSettings(),
            clientContext);
    this.listNodePoolsCallable =
        callableFactory.createUnaryCallable(
            listNodePoolsTransportSettings, settings.listNodePoolsSettings(), clientContext);
    this.listNodePoolsPagedCallable =
        callableFactory.createPagedCallable(
            listNodePoolsTransportSettings, settings.listNodePoolsSettings(), clientContext);
    this.getNodePoolCallable =
        callableFactory.createUnaryCallable(
            getNodePoolTransportSettings, settings.getNodePoolSettings(), clientContext);
    this.createNodePoolCallable =
        callableFactory.createUnaryCallable(
            createNodePoolTransportSettings, settings.createNodePoolSettings(), clientContext);
    this.createNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            createNodePoolTransportSettings,
            settings.createNodePoolOperationSettings(),
            clientContext,
            operationsStub);
    this.updateNodePoolCallable =
        callableFactory.createUnaryCallable(
            updateNodePoolTransportSettings, settings.updateNodePoolSettings(), clientContext);
    this.updateNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            updateNodePoolTransportSettings,
            settings.updateNodePoolOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteNodePoolCallable =
        callableFactory.createUnaryCallable(
            deleteNodePoolTransportSettings, settings.deleteNodePoolSettings(), clientContext);
    this.deleteNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            deleteNodePoolTransportSettings,
            settings.deleteNodePoolOperationSettings(),
            clientContext,
            operationsStub);
    this.listMachinesCallable =
        callableFactory.createUnaryCallable(
            listMachinesTransportSettings, settings.listMachinesSettings(), clientContext);
    this.listMachinesPagedCallable =
        callableFactory.createPagedCallable(
            listMachinesTransportSettings, settings.listMachinesSettings(), clientContext);
    this.getMachineCallable =
        callableFactory.createUnaryCallable(
            getMachineTransportSettings, settings.getMachineSettings(), clientContext);
    this.listVpnConnectionsCallable =
        callableFactory.createUnaryCallable(
            listVpnConnectionsTransportSettings,
            settings.listVpnConnectionsSettings(),
            clientContext);
    this.listVpnConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listVpnConnectionsTransportSettings,
            settings.listVpnConnectionsSettings(),
            clientContext);
    this.getVpnConnectionCallable =
        callableFactory.createUnaryCallable(
            getVpnConnectionTransportSettings, settings.getVpnConnectionSettings(), clientContext);
    this.createVpnConnectionCallable =
        callableFactory.createUnaryCallable(
            createVpnConnectionTransportSettings,
            settings.createVpnConnectionSettings(),
            clientContext);
    this.createVpnConnectionOperationCallable =
        callableFactory.createOperationCallable(
            createVpnConnectionTransportSettings,
            settings.createVpnConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteVpnConnectionCallable =
        callableFactory.createUnaryCallable(
            deleteVpnConnectionTransportSettings,
            settings.deleteVpnConnectionSettings(),
            clientContext);
    this.deleteVpnConnectionOperationCallable =
        callableFactory.createOperationCallable(
            deleteVpnConnectionTransportSettings,
            settings.deleteVpnConnectionOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return listClustersCallable;
  }

  @Override
  public UnaryCallable<ListClustersRequest, ListClustersPagedResponse> listClustersPagedCallable() {
    return listClustersPagedCallable;
  }

  @Override
  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return getClusterCallable;
  }

  @Override
  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return createClusterCallable;
  }

  @Override
  public OperationCallable<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationCallable() {
    return createClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return updateClusterCallable;
  }

  @Override
  public OperationCallable<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationCallable() {
    return updateClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return deleteClusterCallable;
  }

  @Override
  public OperationCallable<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationCallable() {
    return deleteClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenCallable() {
    return generateAccessTokenCallable;
  }

  @Override
  public UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsCallable() {
    return listNodePoolsCallable;
  }

  @Override
  public UnaryCallable<ListNodePoolsRequest, ListNodePoolsPagedResponse>
      listNodePoolsPagedCallable() {
    return listNodePoolsPagedCallable;
  }

  @Override
  public UnaryCallable<GetNodePoolRequest, NodePool> getNodePoolCallable() {
    return getNodePoolCallable;
  }

  @Override
  public UnaryCallable<CreateNodePoolRequest, Operation> createNodePoolCallable() {
    return createNodePoolCallable;
  }

  @Override
  public OperationCallable<CreateNodePoolRequest, NodePool, OperationMetadata>
      createNodePoolOperationCallable() {
    return createNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateNodePoolRequest, Operation> updateNodePoolCallable() {
    return updateNodePoolCallable;
  }

  @Override
  public OperationCallable<UpdateNodePoolRequest, NodePool, OperationMetadata>
      updateNodePoolOperationCallable() {
    return updateNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteNodePoolRequest, Operation> deleteNodePoolCallable() {
    return deleteNodePoolCallable;
  }

  @Override
  public OperationCallable<DeleteNodePoolRequest, Empty, OperationMetadata>
      deleteNodePoolOperationCallable() {
    return deleteNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<ListMachinesRequest, ListMachinesResponse> listMachinesCallable() {
    return listMachinesCallable;
  }

  @Override
  public UnaryCallable<ListMachinesRequest, ListMachinesPagedResponse> listMachinesPagedCallable() {
    return listMachinesPagedCallable;
  }

  @Override
  public UnaryCallable<GetMachineRequest, Machine> getMachineCallable() {
    return getMachineCallable;
  }

  @Override
  public UnaryCallable<ListVpnConnectionsRequest, ListVpnConnectionsResponse>
      listVpnConnectionsCallable() {
    return listVpnConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListVpnConnectionsRequest, ListVpnConnectionsPagedResponse>
      listVpnConnectionsPagedCallable() {
    return listVpnConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetVpnConnectionRequest, VpnConnection> getVpnConnectionCallable() {
    return getVpnConnectionCallable;
  }

  @Override
  public UnaryCallable<CreateVpnConnectionRequest, Operation> createVpnConnectionCallable() {
    return createVpnConnectionCallable;
  }

  @Override
  public OperationCallable<CreateVpnConnectionRequest, VpnConnection, OperationMetadata>
      createVpnConnectionOperationCallable() {
    return createVpnConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteVpnConnectionRequest, Operation> deleteVpnConnectionCallable() {
    return deleteVpnConnectionCallable;
  }

  @Override
  public OperationCallable<DeleteVpnConnectionRequest, Empty, OperationMetadata>
      deleteVpnConnectionOperationCallable() {
    return deleteVpnConnectionOperationCallable;
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
