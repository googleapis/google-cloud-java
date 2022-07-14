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

package com.google.cloud.container.v1beta1.stub;

import static com.google.cloud.container.v1beta1.ClusterManagerClient.ListUsableSubnetworksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.container.v1beta1.CancelOperationRequest;
import com.google.container.v1beta1.Cluster;
import com.google.container.v1beta1.CompleteIPRotationRequest;
import com.google.container.v1beta1.CompleteNodePoolUpgradeRequest;
import com.google.container.v1beta1.CreateClusterRequest;
import com.google.container.v1beta1.CreateNodePoolRequest;
import com.google.container.v1beta1.DeleteClusterRequest;
import com.google.container.v1beta1.DeleteNodePoolRequest;
import com.google.container.v1beta1.GetClusterRequest;
import com.google.container.v1beta1.GetJSONWebKeysRequest;
import com.google.container.v1beta1.GetJSONWebKeysResponse;
import com.google.container.v1beta1.GetNodePoolRequest;
import com.google.container.v1beta1.GetOperationRequest;
import com.google.container.v1beta1.GetServerConfigRequest;
import com.google.container.v1beta1.ListClustersRequest;
import com.google.container.v1beta1.ListClustersResponse;
import com.google.container.v1beta1.ListLocationsRequest;
import com.google.container.v1beta1.ListLocationsResponse;
import com.google.container.v1beta1.ListNodePoolsRequest;
import com.google.container.v1beta1.ListNodePoolsResponse;
import com.google.container.v1beta1.ListOperationsRequest;
import com.google.container.v1beta1.ListOperationsResponse;
import com.google.container.v1beta1.ListUsableSubnetworksRequest;
import com.google.container.v1beta1.ListUsableSubnetworksResponse;
import com.google.container.v1beta1.NodePool;
import com.google.container.v1beta1.Operation;
import com.google.container.v1beta1.RollbackNodePoolUpgradeRequest;
import com.google.container.v1beta1.ServerConfig;
import com.google.container.v1beta1.SetAddonsConfigRequest;
import com.google.container.v1beta1.SetLabelsRequest;
import com.google.container.v1beta1.SetLegacyAbacRequest;
import com.google.container.v1beta1.SetLocationsRequest;
import com.google.container.v1beta1.SetLoggingServiceRequest;
import com.google.container.v1beta1.SetMaintenancePolicyRequest;
import com.google.container.v1beta1.SetMasterAuthRequest;
import com.google.container.v1beta1.SetMonitoringServiceRequest;
import com.google.container.v1beta1.SetNetworkPolicyRequest;
import com.google.container.v1beta1.SetNodePoolAutoscalingRequest;
import com.google.container.v1beta1.SetNodePoolManagementRequest;
import com.google.container.v1beta1.SetNodePoolSizeRequest;
import com.google.container.v1beta1.StartIPRotationRequest;
import com.google.container.v1beta1.UpdateClusterRequest;
import com.google.container.v1beta1.UpdateMasterRequest;
import com.google.container.v1beta1.UpdateNodePoolRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ClusterManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcClusterManagerStub extends ClusterManagerStub {
  private static final MethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          MethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/ListClusters")
              .setRequestMarshaller(ProtoUtils.marshaller(ListClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListClustersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetClusterRequest, Cluster> getClusterMethodDescriptor =
      MethodDescriptor.<GetClusterRequest, Cluster>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.container.v1beta1.ClusterManager/GetCluster")
          .setRequestMarshaller(ProtoUtils.marshaller(GetClusterRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Cluster.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateClusterRequest, Operation>
      createClusterMethodDescriptor =
          MethodDescriptor.<CreateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/CreateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateClusterRequest, Operation>
      updateClusterMethodDescriptor =
          MethodDescriptor.<UpdateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/UpdateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateNodePoolRequest, Operation>
      updateNodePoolMethodDescriptor =
          MethodDescriptor.<UpdateNodePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/UpdateNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetNodePoolAutoscalingRequest, Operation>
      setNodePoolAutoscalingMethodDescriptor =
          MethodDescriptor.<SetNodePoolAutoscalingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/SetNodePoolAutoscaling")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetNodePoolAutoscalingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetLoggingServiceRequest, Operation>
      setLoggingServiceMethodDescriptor =
          MethodDescriptor.<SetLoggingServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/SetLoggingService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetLoggingServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetMonitoringServiceRequest, Operation>
      setMonitoringServiceMethodDescriptor =
          MethodDescriptor.<SetMonitoringServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/SetMonitoringService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetMonitoringServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetAddonsConfigRequest, Operation>
      setAddonsConfigMethodDescriptor =
          MethodDescriptor.<SetAddonsConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/SetAddonsConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetAddonsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetLocationsRequest, Operation>
      setLocationsMethodDescriptor =
          MethodDescriptor.<SetLocationsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/SetLocations")
              .setRequestMarshaller(ProtoUtils.marshaller(SetLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateMasterRequest, Operation>
      updateMasterMethodDescriptor =
          MethodDescriptor.<UpdateMasterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/UpdateMaster")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateMasterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetMasterAuthRequest, Operation>
      setMasterAuthMethodDescriptor =
          MethodDescriptor.<SetMasterAuthRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/SetMasterAuth")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetMasterAuthRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteClusterRequest, Operation>
      deleteClusterMethodDescriptor =
          MethodDescriptor.<DeleteClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/DeleteCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListOperationsRequest, ListOperationsResponse>
      listOperationsMethodDescriptor =
          MethodDescriptor.<ListOperationsRequest, ListOperationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/ListOperations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOperationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOperationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetOperationRequest, Operation>
      getOperationMethodDescriptor =
          MethodDescriptor.<GetOperationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/GetOperation")
              .setRequestMarshaller(ProtoUtils.marshaller(GetOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelOperationRequest, Empty>
      cancelOperationMethodDescriptor =
          MethodDescriptor.<CancelOperationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/CancelOperation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServerConfigRequest, ServerConfig>
      getServerConfigMethodDescriptor =
          MethodDescriptor.<GetServerConfigRequest, ServerConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/GetServerConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServerConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServerConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListNodePoolsRequest, ListNodePoolsResponse>
      listNodePoolsMethodDescriptor =
          MethodDescriptor.<ListNodePoolsRequest, ListNodePoolsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/ListNodePools")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNodePoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNodePoolsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetJSONWebKeysRequest, GetJSONWebKeysResponse>
      getJSONWebKeysMethodDescriptor =
          MethodDescriptor.<GetJSONWebKeysRequest, GetJSONWebKeysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/GetJSONWebKeys")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetJSONWebKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GetJSONWebKeysResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNodePoolRequest, NodePool> getNodePoolMethodDescriptor =
      MethodDescriptor.<GetNodePoolRequest, NodePool>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.container.v1beta1.ClusterManager/GetNodePool")
          .setRequestMarshaller(ProtoUtils.marshaller(GetNodePoolRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(NodePool.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateNodePoolRequest, Operation>
      createNodePoolMethodDescriptor =
          MethodDescriptor.<CreateNodePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/CreateNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNodePoolRequest, Operation>
      deleteNodePoolMethodDescriptor =
          MethodDescriptor.<DeleteNodePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/DeleteNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CompleteNodePoolUpgradeRequest, Empty>
      completeNodePoolUpgradeMethodDescriptor =
          MethodDescriptor.<CompleteNodePoolUpgradeRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/CompleteNodePoolUpgrade")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CompleteNodePoolUpgradeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RollbackNodePoolUpgradeRequest, Operation>
      rollbackNodePoolUpgradeMethodDescriptor =
          MethodDescriptor.<RollbackNodePoolUpgradeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/RollbackNodePoolUpgrade")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RollbackNodePoolUpgradeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetNodePoolManagementRequest, Operation>
      setNodePoolManagementMethodDescriptor =
          MethodDescriptor.<SetNodePoolManagementRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/SetNodePoolManagement")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetNodePoolManagementRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetLabelsRequest, Operation> setLabelsMethodDescriptor =
      MethodDescriptor.<SetLabelsRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.container.v1beta1.ClusterManager/SetLabels")
          .setRequestMarshaller(ProtoUtils.marshaller(SetLabelsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetLegacyAbacRequest, Operation>
      setLegacyAbacMethodDescriptor =
          MethodDescriptor.<SetLegacyAbacRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/SetLegacyAbac")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetLegacyAbacRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StartIPRotationRequest, Operation>
      startIPRotationMethodDescriptor =
          MethodDescriptor.<StartIPRotationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/StartIPRotation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartIPRotationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CompleteIPRotationRequest, Operation>
      completeIPRotationMethodDescriptor =
          MethodDescriptor.<CompleteIPRotationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/CompleteIPRotation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CompleteIPRotationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetNodePoolSizeRequest, Operation>
      setNodePoolSizeMethodDescriptor =
          MethodDescriptor.<SetNodePoolSizeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/SetNodePoolSize")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetNodePoolSizeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetNetworkPolicyRequest, Operation>
      setNetworkPolicyMethodDescriptor =
          MethodDescriptor.<SetNetworkPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/SetNetworkPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetNetworkPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetMaintenancePolicyRequest, Operation>
      setMaintenancePolicyMethodDescriptor =
          MethodDescriptor.<SetMaintenancePolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/SetMaintenancePolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetMaintenancePolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>
      listUsableSubnetworksMethodDescriptor =
          MethodDescriptor.<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/ListUsableSubnetworks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUsableSubnetworksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUsableSubnetworksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1beta1.ClusterManager/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable;
  private final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable;
  private final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable;
  private final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable;
  private final UnaryCallable<UpdateNodePoolRequest, Operation> updateNodePoolCallable;
  private final UnaryCallable<SetNodePoolAutoscalingRequest, Operation>
      setNodePoolAutoscalingCallable;
  private final UnaryCallable<SetLoggingServiceRequest, Operation> setLoggingServiceCallable;
  private final UnaryCallable<SetMonitoringServiceRequest, Operation> setMonitoringServiceCallable;
  private final UnaryCallable<SetAddonsConfigRequest, Operation> setAddonsConfigCallable;
  private final UnaryCallable<SetLocationsRequest, Operation> setLocationsCallable;
  private final UnaryCallable<UpdateMasterRequest, Operation> updateMasterCallable;
  private final UnaryCallable<SetMasterAuthRequest, Operation> setMasterAuthCallable;
  private final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable;
  private final UnaryCallable<ListOperationsRequest, ListOperationsResponse> listOperationsCallable;
  private final UnaryCallable<GetOperationRequest, Operation> getOperationCallable;
  private final UnaryCallable<CancelOperationRequest, Empty> cancelOperationCallable;
  private final UnaryCallable<GetServerConfigRequest, ServerConfig> getServerConfigCallable;
  private final UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsCallable;
  private final UnaryCallable<GetJSONWebKeysRequest, GetJSONWebKeysResponse> getJSONWebKeysCallable;
  private final UnaryCallable<GetNodePoolRequest, NodePool> getNodePoolCallable;
  private final UnaryCallable<CreateNodePoolRequest, Operation> createNodePoolCallable;
  private final UnaryCallable<DeleteNodePoolRequest, Operation> deleteNodePoolCallable;
  private final UnaryCallable<CompleteNodePoolUpgradeRequest, Empty>
      completeNodePoolUpgradeCallable;
  private final UnaryCallable<RollbackNodePoolUpgradeRequest, Operation>
      rollbackNodePoolUpgradeCallable;
  private final UnaryCallable<SetNodePoolManagementRequest, Operation>
      setNodePoolManagementCallable;
  private final UnaryCallable<SetLabelsRequest, Operation> setLabelsCallable;
  private final UnaryCallable<SetLegacyAbacRequest, Operation> setLegacyAbacCallable;
  private final UnaryCallable<StartIPRotationRequest, Operation> startIPRotationCallable;
  private final UnaryCallable<CompleteIPRotationRequest, Operation> completeIPRotationCallable;
  private final UnaryCallable<SetNodePoolSizeRequest, Operation> setNodePoolSizeCallable;
  private final UnaryCallable<SetNetworkPolicyRequest, Operation> setNetworkPolicyCallable;
  private final UnaryCallable<SetMaintenancePolicyRequest, Operation> setMaintenancePolicyCallable;
  private final UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>
      listUsableSubnetworksCallable;
  private final UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksPagedResponse>
      listUsableSubnetworksPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcClusterManagerStub create(ClusterManagerStubSettings settings)
      throws IOException {
    return new GrpcClusterManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcClusterManagerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcClusterManagerStub(
        ClusterManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcClusterManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcClusterManagerStub(
        ClusterManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcClusterManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcClusterManagerStub(ClusterManagerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcClusterManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcClusterManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcClusterManagerStub(
      ClusterManagerStubSettings settings,
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
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetClusterRequest, Cluster> getClusterTransportSettings =
        GrpcCallSettings.<GetClusterRequest, Cluster>newBuilder()
            .setMethodDescriptor(getClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
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
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateClusterRequest, Operation> updateClusterTransportSettings =
        GrpcCallSettings.<UpdateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateNodePoolRequest, Operation> updateNodePoolTransportSettings =
        GrpcCallSettings.<UpdateNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNodePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("node_pool_id", String.valueOf(request.getNodePoolId()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetNodePoolAutoscalingRequest, Operation>
        setNodePoolAutoscalingTransportSettings =
            GrpcCallSettings.<SetNodePoolAutoscalingRequest, Operation>newBuilder()
                .setMethodDescriptor(setNodePoolAutoscalingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("cluster_id", String.valueOf(request.getClusterId()));
                      params.put("name", String.valueOf(request.getName()));
                      params.put("node_pool_id", String.valueOf(request.getNodePoolId()));
                      params.put("project_id", String.valueOf(request.getProjectId()));
                      params.put("zone", String.valueOf(request.getZone()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SetLoggingServiceRequest, Operation> setLoggingServiceTransportSettings =
        GrpcCallSettings.<SetLoggingServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(setLoggingServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetMonitoringServiceRequest, Operation> setMonitoringServiceTransportSettings =
        GrpcCallSettings.<SetMonitoringServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(setMonitoringServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetAddonsConfigRequest, Operation> setAddonsConfigTransportSettings =
        GrpcCallSettings.<SetAddonsConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(setAddonsConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetLocationsRequest, Operation> setLocationsTransportSettings =
        GrpcCallSettings.<SetLocationsRequest, Operation>newBuilder()
            .setMethodDescriptor(setLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateMasterRequest, Operation> updateMasterTransportSettings =
        GrpcCallSettings.<UpdateMasterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMasterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetMasterAuthRequest, Operation> setMasterAuthTransportSettings =
        GrpcCallSettings.<SetMasterAuthRequest, Operation>newBuilder()
            .setMethodDescriptor(setMasterAuthMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteClusterRequest, Operation> deleteClusterTransportSettings =
        GrpcCallSettings.<DeleteClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListOperationsRequest, ListOperationsResponse>
        listOperationsTransportSettings =
            GrpcCallSettings.<ListOperationsRequest, ListOperationsResponse>newBuilder()
                .setMethodDescriptor(listOperationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      params.put("project_id", String.valueOf(request.getProjectId()));
                      params.put("zone", String.valueOf(request.getZone()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetOperationRequest, Operation> getOperationTransportSettings =
        GrpcCallSettings.<GetOperationRequest, Operation>newBuilder()
            .setMethodDescriptor(getOperationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  params.put("operation_id", String.valueOf(request.getOperationId()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CancelOperationRequest, Empty> cancelOperationTransportSettings =
        GrpcCallSettings.<CancelOperationRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelOperationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  params.put("operation_id", String.valueOf(request.getOperationId()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetServerConfigRequest, ServerConfig> getServerConfigTransportSettings =
        GrpcCallSettings.<GetServerConfigRequest, ServerConfig>newBuilder()
            .setMethodDescriptor(getServerConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsTransportSettings =
        GrpcCallSettings.<ListNodePoolsRequest, ListNodePoolsResponse>newBuilder()
            .setMethodDescriptor(listNodePoolsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("parent", String.valueOf(request.getParent()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetJSONWebKeysRequest, GetJSONWebKeysResponse>
        getJSONWebKeysTransportSettings =
            GrpcCallSettings.<GetJSONWebKeysRequest, GetJSONWebKeysResponse>newBuilder()
                .setMethodDescriptor(getJSONWebKeysMethodDescriptor)
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
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("node_pool_id", String.valueOf(request.getNodePoolId()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateNodePoolRequest, Operation> createNodePoolTransportSettings =
        GrpcCallSettings.<CreateNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createNodePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("parent", String.valueOf(request.getParent()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteNodePoolRequest, Operation> deleteNodePoolTransportSettings =
        GrpcCallSettings.<DeleteNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNodePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("node_pool_id", String.valueOf(request.getNodePoolId()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CompleteNodePoolUpgradeRequest, Empty>
        completeNodePoolUpgradeTransportSettings =
            GrpcCallSettings.<CompleteNodePoolUpgradeRequest, Empty>newBuilder()
                .setMethodDescriptor(completeNodePoolUpgradeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<RollbackNodePoolUpgradeRequest, Operation>
        rollbackNodePoolUpgradeTransportSettings =
            GrpcCallSettings.<RollbackNodePoolUpgradeRequest, Operation>newBuilder()
                .setMethodDescriptor(rollbackNodePoolUpgradeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("cluster_id", String.valueOf(request.getClusterId()));
                      params.put("name", String.valueOf(request.getName()));
                      params.put("node_pool_id", String.valueOf(request.getNodePoolId()));
                      params.put("project_id", String.valueOf(request.getProjectId()));
                      params.put("zone", String.valueOf(request.getZone()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SetNodePoolManagementRequest, Operation>
        setNodePoolManagementTransportSettings =
            GrpcCallSettings.<SetNodePoolManagementRequest, Operation>newBuilder()
                .setMethodDescriptor(setNodePoolManagementMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("cluster_id", String.valueOf(request.getClusterId()));
                      params.put("name", String.valueOf(request.getName()));
                      params.put("node_pool_id", String.valueOf(request.getNodePoolId()));
                      params.put("project_id", String.valueOf(request.getProjectId()));
                      params.put("zone", String.valueOf(request.getZone()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SetLabelsRequest, Operation> setLabelsTransportSettings =
        GrpcCallSettings.<SetLabelsRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetLegacyAbacRequest, Operation> setLegacyAbacTransportSettings =
        GrpcCallSettings.<SetLegacyAbacRequest, Operation>newBuilder()
            .setMethodDescriptor(setLegacyAbacMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StartIPRotationRequest, Operation> startIPRotationTransportSettings =
        GrpcCallSettings.<StartIPRotationRequest, Operation>newBuilder()
            .setMethodDescriptor(startIPRotationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CompleteIPRotationRequest, Operation> completeIPRotationTransportSettings =
        GrpcCallSettings.<CompleteIPRotationRequest, Operation>newBuilder()
            .setMethodDescriptor(completeIPRotationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetNodePoolSizeRequest, Operation> setNodePoolSizeTransportSettings =
        GrpcCallSettings.<SetNodePoolSizeRequest, Operation>newBuilder()
            .setMethodDescriptor(setNodePoolSizeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("node_pool_id", String.valueOf(request.getNodePoolId()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetNetworkPolicyRequest, Operation> setNetworkPolicyTransportSettings =
        GrpcCallSettings.<SetNetworkPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(setNetworkPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetMaintenancePolicyRequest, Operation> setMaintenancePolicyTransportSettings =
        GrpcCallSettings.<SetMaintenancePolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(setMaintenancePolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("cluster_id", String.valueOf(request.getClusterId()));
                  params.put("name", String.valueOf(request.getName()));
                  params.put("project_id", String.valueOf(request.getProjectId()));
                  params.put("zone", String.valueOf(request.getZone()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>
        listUsableSubnetworksTransportSettings =
            GrpcCallSettings
                .<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>newBuilder()
                .setMethodDescriptor(listUsableSubnetworksMethodDescriptor)
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
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();

    this.listClustersCallable =
        callableFactory.createUnaryCallable(
            listClustersTransportSettings, settings.listClustersSettings(), clientContext);
    this.getClusterCallable =
        callableFactory.createUnaryCallable(
            getClusterTransportSettings, settings.getClusterSettings(), clientContext);
    this.createClusterCallable =
        callableFactory.createUnaryCallable(
            createClusterTransportSettings, settings.createClusterSettings(), clientContext);
    this.updateClusterCallable =
        callableFactory.createUnaryCallable(
            updateClusterTransportSettings, settings.updateClusterSettings(), clientContext);
    this.updateNodePoolCallable =
        callableFactory.createUnaryCallable(
            updateNodePoolTransportSettings, settings.updateNodePoolSettings(), clientContext);
    this.setNodePoolAutoscalingCallable =
        callableFactory.createUnaryCallable(
            setNodePoolAutoscalingTransportSettings,
            settings.setNodePoolAutoscalingSettings(),
            clientContext);
    this.setLoggingServiceCallable =
        callableFactory.createUnaryCallable(
            setLoggingServiceTransportSettings,
            settings.setLoggingServiceSettings(),
            clientContext);
    this.setMonitoringServiceCallable =
        callableFactory.createUnaryCallable(
            setMonitoringServiceTransportSettings,
            settings.setMonitoringServiceSettings(),
            clientContext);
    this.setAddonsConfigCallable =
        callableFactory.createUnaryCallable(
            setAddonsConfigTransportSettings, settings.setAddonsConfigSettings(), clientContext);
    this.setLocationsCallable =
        callableFactory.createUnaryCallable(
            setLocationsTransportSettings, settings.setLocationsSettings(), clientContext);
    this.updateMasterCallable =
        callableFactory.createUnaryCallable(
            updateMasterTransportSettings, settings.updateMasterSettings(), clientContext);
    this.setMasterAuthCallable =
        callableFactory.createUnaryCallable(
            setMasterAuthTransportSettings, settings.setMasterAuthSettings(), clientContext);
    this.deleteClusterCallable =
        callableFactory.createUnaryCallable(
            deleteClusterTransportSettings, settings.deleteClusterSettings(), clientContext);
    this.listOperationsCallable =
        callableFactory.createUnaryCallable(
            listOperationsTransportSettings, settings.listOperationsSettings(), clientContext);
    this.getOperationCallable =
        callableFactory.createUnaryCallable(
            getOperationTransportSettings, settings.getOperationSettings(), clientContext);
    this.cancelOperationCallable =
        callableFactory.createUnaryCallable(
            cancelOperationTransportSettings, settings.cancelOperationSettings(), clientContext);
    this.getServerConfigCallable =
        callableFactory.createUnaryCallable(
            getServerConfigTransportSettings, settings.getServerConfigSettings(), clientContext);
    this.listNodePoolsCallable =
        callableFactory.createUnaryCallable(
            listNodePoolsTransportSettings, settings.listNodePoolsSettings(), clientContext);
    this.getJSONWebKeysCallable =
        callableFactory.createUnaryCallable(
            getJSONWebKeysTransportSettings, settings.getJSONWebKeysSettings(), clientContext);
    this.getNodePoolCallable =
        callableFactory.createUnaryCallable(
            getNodePoolTransportSettings, settings.getNodePoolSettings(), clientContext);
    this.createNodePoolCallable =
        callableFactory.createUnaryCallable(
            createNodePoolTransportSettings, settings.createNodePoolSettings(), clientContext);
    this.deleteNodePoolCallable =
        callableFactory.createUnaryCallable(
            deleteNodePoolTransportSettings, settings.deleteNodePoolSettings(), clientContext);
    this.completeNodePoolUpgradeCallable =
        callableFactory.createUnaryCallable(
            completeNodePoolUpgradeTransportSettings,
            settings.completeNodePoolUpgradeSettings(),
            clientContext);
    this.rollbackNodePoolUpgradeCallable =
        callableFactory.createUnaryCallable(
            rollbackNodePoolUpgradeTransportSettings,
            settings.rollbackNodePoolUpgradeSettings(),
            clientContext);
    this.setNodePoolManagementCallable =
        callableFactory.createUnaryCallable(
            setNodePoolManagementTransportSettings,
            settings.setNodePoolManagementSettings(),
            clientContext);
    this.setLabelsCallable =
        callableFactory.createUnaryCallable(
            setLabelsTransportSettings, settings.setLabelsSettings(), clientContext);
    this.setLegacyAbacCallable =
        callableFactory.createUnaryCallable(
            setLegacyAbacTransportSettings, settings.setLegacyAbacSettings(), clientContext);
    this.startIPRotationCallable =
        callableFactory.createUnaryCallable(
            startIPRotationTransportSettings, settings.startIPRotationSettings(), clientContext);
    this.completeIPRotationCallable =
        callableFactory.createUnaryCallable(
            completeIPRotationTransportSettings,
            settings.completeIPRotationSettings(),
            clientContext);
    this.setNodePoolSizeCallable =
        callableFactory.createUnaryCallable(
            setNodePoolSizeTransportSettings, settings.setNodePoolSizeSettings(), clientContext);
    this.setNetworkPolicyCallable =
        callableFactory.createUnaryCallable(
            setNetworkPolicyTransportSettings, settings.setNetworkPolicySettings(), clientContext);
    this.setMaintenancePolicyCallable =
        callableFactory.createUnaryCallable(
            setMaintenancePolicyTransportSettings,
            settings.setMaintenancePolicySettings(),
            clientContext);
    this.listUsableSubnetworksCallable =
        callableFactory.createUnaryCallable(
            listUsableSubnetworksTransportSettings,
            settings.listUsableSubnetworksSettings(),
            clientContext);
    this.listUsableSubnetworksPagedCallable =
        callableFactory.createPagedCallable(
            listUsableSubnetworksTransportSettings,
            settings.listUsableSubnetworksSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);

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
  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return getClusterCallable;
  }

  @Override
  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return createClusterCallable;
  }

  @Override
  public UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return updateClusterCallable;
  }

  @Override
  public UnaryCallable<UpdateNodePoolRequest, Operation> updateNodePoolCallable() {
    return updateNodePoolCallable;
  }

  @Override
  public UnaryCallable<SetNodePoolAutoscalingRequest, Operation> setNodePoolAutoscalingCallable() {
    return setNodePoolAutoscalingCallable;
  }

  @Override
  public UnaryCallable<SetLoggingServiceRequest, Operation> setLoggingServiceCallable() {
    return setLoggingServiceCallable;
  }

  @Override
  public UnaryCallable<SetMonitoringServiceRequest, Operation> setMonitoringServiceCallable() {
    return setMonitoringServiceCallable;
  }

  @Override
  public UnaryCallable<SetAddonsConfigRequest, Operation> setAddonsConfigCallable() {
    return setAddonsConfigCallable;
  }

  @Override
  public UnaryCallable<SetLocationsRequest, Operation> setLocationsCallable() {
    return setLocationsCallable;
  }

  @Override
  public UnaryCallable<UpdateMasterRequest, Operation> updateMasterCallable() {
    return updateMasterCallable;
  }

  @Override
  public UnaryCallable<SetMasterAuthRequest, Operation> setMasterAuthCallable() {
    return setMasterAuthCallable;
  }

  @Override
  public UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return deleteClusterCallable;
  }

  @Override
  public UnaryCallable<ListOperationsRequest, ListOperationsResponse> listOperationsCallable() {
    return listOperationsCallable;
  }

  @Override
  public UnaryCallable<GetOperationRequest, Operation> getOperationCallable() {
    return getOperationCallable;
  }

  @Override
  public UnaryCallable<CancelOperationRequest, Empty> cancelOperationCallable() {
    return cancelOperationCallable;
  }

  @Override
  public UnaryCallable<GetServerConfigRequest, ServerConfig> getServerConfigCallable() {
    return getServerConfigCallable;
  }

  @Override
  public UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsCallable() {
    return listNodePoolsCallable;
  }

  @Override
  public UnaryCallable<GetJSONWebKeysRequest, GetJSONWebKeysResponse> getJSONWebKeysCallable() {
    return getJSONWebKeysCallable;
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
  public UnaryCallable<DeleteNodePoolRequest, Operation> deleteNodePoolCallable() {
    return deleteNodePoolCallable;
  }

  @Override
  public UnaryCallable<CompleteNodePoolUpgradeRequest, Empty> completeNodePoolUpgradeCallable() {
    return completeNodePoolUpgradeCallable;
  }

  @Override
  public UnaryCallable<RollbackNodePoolUpgradeRequest, Operation>
      rollbackNodePoolUpgradeCallable() {
    return rollbackNodePoolUpgradeCallable;
  }

  @Override
  public UnaryCallable<SetNodePoolManagementRequest, Operation> setNodePoolManagementCallable() {
    return setNodePoolManagementCallable;
  }

  @Override
  public UnaryCallable<SetLabelsRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  @Override
  public UnaryCallable<SetLegacyAbacRequest, Operation> setLegacyAbacCallable() {
    return setLegacyAbacCallable;
  }

  @Override
  public UnaryCallable<StartIPRotationRequest, Operation> startIPRotationCallable() {
    return startIPRotationCallable;
  }

  @Override
  public UnaryCallable<CompleteIPRotationRequest, Operation> completeIPRotationCallable() {
    return completeIPRotationCallable;
  }

  @Override
  public UnaryCallable<SetNodePoolSizeRequest, Operation> setNodePoolSizeCallable() {
    return setNodePoolSizeCallable;
  }

  @Override
  public UnaryCallable<SetNetworkPolicyRequest, Operation> setNetworkPolicyCallable() {
    return setNetworkPolicyCallable;
  }

  @Override
  public UnaryCallable<SetMaintenancePolicyRequest, Operation> setMaintenancePolicyCallable() {
    return setMaintenancePolicyCallable;
  }

  @Override
  public UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>
      listUsableSubnetworksCallable() {
    return listUsableSubnetworksCallable;
  }

  @Override
  public UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksPagedResponse>
      listUsableSubnetworksPagedCallable() {
    return listUsableSubnetworksPagedCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
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
