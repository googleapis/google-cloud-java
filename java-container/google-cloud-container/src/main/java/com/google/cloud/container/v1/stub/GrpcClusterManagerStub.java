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

package com.google.cloud.container.v1.stub;

import static com.google.cloud.container.v1.ClusterManagerClient.ListUsableSubnetworksPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.container.v1.CancelOperationRequest;
import com.google.container.v1.Cluster;
import com.google.container.v1.CompleteIPRotationRequest;
import com.google.container.v1.CreateClusterRequest;
import com.google.container.v1.CreateNodePoolRequest;
import com.google.container.v1.DeleteClusterRequest;
import com.google.container.v1.DeleteNodePoolRequest;
import com.google.container.v1.GetClusterRequest;
import com.google.container.v1.GetJSONWebKeysRequest;
import com.google.container.v1.GetJSONWebKeysResponse;
import com.google.container.v1.GetNodePoolRequest;
import com.google.container.v1.GetOperationRequest;
import com.google.container.v1.GetServerConfigRequest;
import com.google.container.v1.ListClustersRequest;
import com.google.container.v1.ListClustersResponse;
import com.google.container.v1.ListNodePoolsRequest;
import com.google.container.v1.ListNodePoolsResponse;
import com.google.container.v1.ListOperationsRequest;
import com.google.container.v1.ListOperationsResponse;
import com.google.container.v1.ListUsableSubnetworksRequest;
import com.google.container.v1.ListUsableSubnetworksResponse;
import com.google.container.v1.NodePool;
import com.google.container.v1.Operation;
import com.google.container.v1.RollbackNodePoolUpgradeRequest;
import com.google.container.v1.ServerConfig;
import com.google.container.v1.SetAddonsConfigRequest;
import com.google.container.v1.SetLabelsRequest;
import com.google.container.v1.SetLegacyAbacRequest;
import com.google.container.v1.SetLocationsRequest;
import com.google.container.v1.SetLoggingServiceRequest;
import com.google.container.v1.SetMaintenancePolicyRequest;
import com.google.container.v1.SetMasterAuthRequest;
import com.google.container.v1.SetMonitoringServiceRequest;
import com.google.container.v1.SetNetworkPolicyRequest;
import com.google.container.v1.SetNodePoolAutoscalingRequest;
import com.google.container.v1.SetNodePoolManagementRequest;
import com.google.container.v1.SetNodePoolSizeRequest;
import com.google.container.v1.StartIPRotationRequest;
import com.google.container.v1.UpdateClusterRequest;
import com.google.container.v1.UpdateMasterRequest;
import com.google.container.v1.UpdateNodePoolRequest;
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
 * gRPC stub implementation for the ClusterManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcClusterManagerStub extends ClusterManagerStub {
  private static final MethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          MethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/ListClusters")
              .setRequestMarshaller(ProtoUtils.marshaller(ListClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListClustersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetClusterRequest, Cluster> getClusterMethodDescriptor =
      MethodDescriptor.<GetClusterRequest, Cluster>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.container.v1.ClusterManager/GetCluster")
          .setRequestMarshaller(ProtoUtils.marshaller(GetClusterRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Cluster.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateClusterRequest, Operation>
      createClusterMethodDescriptor =
          MethodDescriptor.<CreateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/CreateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateClusterRequest, Operation>
      updateClusterMethodDescriptor =
          MethodDescriptor.<UpdateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/UpdateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateNodePoolRequest, Operation>
      updateNodePoolMethodDescriptor =
          MethodDescriptor.<UpdateNodePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/UpdateNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetNodePoolAutoscalingRequest, Operation>
      setNodePoolAutoscalingMethodDescriptor =
          MethodDescriptor.<SetNodePoolAutoscalingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/SetNodePoolAutoscaling")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetNodePoolAutoscalingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetLoggingServiceRequest, Operation>
      setLoggingServiceMethodDescriptor =
          MethodDescriptor.<SetLoggingServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/SetLoggingService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetLoggingServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetMonitoringServiceRequest, Operation>
      setMonitoringServiceMethodDescriptor =
          MethodDescriptor.<SetMonitoringServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/SetMonitoringService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetMonitoringServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetAddonsConfigRequest, Operation>
      setAddonsConfigMethodDescriptor =
          MethodDescriptor.<SetAddonsConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/SetAddonsConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetAddonsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetLocationsRequest, Operation>
      setLocationsMethodDescriptor =
          MethodDescriptor.<SetLocationsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/SetLocations")
              .setRequestMarshaller(ProtoUtils.marshaller(SetLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateMasterRequest, Operation>
      updateMasterMethodDescriptor =
          MethodDescriptor.<UpdateMasterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/UpdateMaster")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateMasterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetMasterAuthRequest, Operation>
      setMasterAuthMethodDescriptor =
          MethodDescriptor.<SetMasterAuthRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/SetMasterAuth")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetMasterAuthRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteClusterRequest, Operation>
      deleteClusterMethodDescriptor =
          MethodDescriptor.<DeleteClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/DeleteCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListOperationsRequest, ListOperationsResponse>
      listOperationsMethodDescriptor =
          MethodDescriptor.<ListOperationsRequest, ListOperationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/ListOperations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOperationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOperationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetOperationRequest, Operation>
      getOperationMethodDescriptor =
          MethodDescriptor.<GetOperationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/GetOperation")
              .setRequestMarshaller(ProtoUtils.marshaller(GetOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelOperationRequest, Empty>
      cancelOperationMethodDescriptor =
          MethodDescriptor.<CancelOperationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/CancelOperation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServerConfigRequest, ServerConfig>
      getServerConfigMethodDescriptor =
          MethodDescriptor.<GetServerConfigRequest, ServerConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/GetServerConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServerConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServerConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetJSONWebKeysRequest, GetJSONWebKeysResponse>
      getJSONWebKeysMethodDescriptor =
          MethodDescriptor.<GetJSONWebKeysRequest, GetJSONWebKeysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/GetJSONWebKeys")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetJSONWebKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GetJSONWebKeysResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListNodePoolsRequest, ListNodePoolsResponse>
      listNodePoolsMethodDescriptor =
          MethodDescriptor.<ListNodePoolsRequest, ListNodePoolsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/ListNodePools")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNodePoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNodePoolsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNodePoolRequest, NodePool> getNodePoolMethodDescriptor =
      MethodDescriptor.<GetNodePoolRequest, NodePool>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.container.v1.ClusterManager/GetNodePool")
          .setRequestMarshaller(ProtoUtils.marshaller(GetNodePoolRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(NodePool.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateNodePoolRequest, Operation>
      createNodePoolMethodDescriptor =
          MethodDescriptor.<CreateNodePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/CreateNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNodePoolRequest, Operation>
      deleteNodePoolMethodDescriptor =
          MethodDescriptor.<DeleteNodePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/DeleteNodePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNodePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RollbackNodePoolUpgradeRequest, Operation>
      rollbackNodePoolUpgradeMethodDescriptor =
          MethodDescriptor.<RollbackNodePoolUpgradeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/RollbackNodePoolUpgrade")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RollbackNodePoolUpgradeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetNodePoolManagementRequest, Operation>
      setNodePoolManagementMethodDescriptor =
          MethodDescriptor.<SetNodePoolManagementRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/SetNodePoolManagement")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetNodePoolManagementRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetLabelsRequest, Operation> setLabelsMethodDescriptor =
      MethodDescriptor.<SetLabelsRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.container.v1.ClusterManager/SetLabels")
          .setRequestMarshaller(ProtoUtils.marshaller(SetLabelsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetLegacyAbacRequest, Operation>
      setLegacyAbacMethodDescriptor =
          MethodDescriptor.<SetLegacyAbacRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/SetLegacyAbac")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetLegacyAbacRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StartIPRotationRequest, Operation>
      startIPRotationMethodDescriptor =
          MethodDescriptor.<StartIPRotationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/StartIPRotation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartIPRotationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CompleteIPRotationRequest, Operation>
      completeIPRotationMethodDescriptor =
          MethodDescriptor.<CompleteIPRotationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/CompleteIPRotation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CompleteIPRotationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetNodePoolSizeRequest, Operation>
      setNodePoolSizeMethodDescriptor =
          MethodDescriptor.<SetNodePoolSizeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/SetNodePoolSize")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetNodePoolSizeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetNetworkPolicyRequest, Operation>
      setNetworkPolicyMethodDescriptor =
          MethodDescriptor.<SetNetworkPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/SetNetworkPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetNetworkPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetMaintenancePolicyRequest, Operation>
      setMaintenancePolicyMethodDescriptor =
          MethodDescriptor.<SetMaintenancePolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/SetMaintenancePolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetMaintenancePolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>
      listUsableSubnetworksMethodDescriptor =
          MethodDescriptor.<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.container.v1.ClusterManager/ListUsableSubnetworks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUsableSubnetworksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUsableSubnetworksResponse.getDefaultInstance()))
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
  private final UnaryCallable<GetJSONWebKeysRequest, GetJSONWebKeysResponse> getJSONWebKeysCallable;
  private final UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsCallable;
  private final UnaryCallable<GetNodePoolRequest, NodePool> getNodePoolCallable;
  private final UnaryCallable<CreateNodePoolRequest, Operation> createNodePoolCallable;
  private final UnaryCallable<DeleteNodePoolRequest, Operation> deleteNodePoolCallable;
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
                new RequestParamsExtractor<ListClustersRequest>() {
                  @Override
                  public Map<String, String> extract(ListClustersRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetClusterRequest, Cluster> getClusterTransportSettings =
        GrpcCallSettings.<GetClusterRequest, Cluster>newBuilder()
            .setMethodDescriptor(getClusterMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetClusterRequest>() {
                  @Override
                  public Map<String, String> extract(GetClusterRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateClusterRequest, Operation> createClusterTransportSettings =
        GrpcCallSettings.<CreateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createClusterMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateClusterRequest>() {
                  @Override
                  public Map<String, String> extract(CreateClusterRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateClusterRequest, Operation> updateClusterTransportSettings =
        GrpcCallSettings.<UpdateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateClusterMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateClusterRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateClusterRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateNodePoolRequest, Operation> updateNodePoolTransportSettings =
        GrpcCallSettings.<UpdateNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNodePoolMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateNodePoolRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateNodePoolRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("node_pool_id", String.valueOf(request.getNodePoolId()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetNodePoolAutoscalingRequest, Operation>
        setNodePoolAutoscalingTransportSettings =
            GrpcCallSettings.<SetNodePoolAutoscalingRequest, Operation>newBuilder()
                .setMethodDescriptor(setNodePoolAutoscalingMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<SetNodePoolAutoscalingRequest>() {
                      @Override
                      public Map<String, String> extract(SetNodePoolAutoscalingRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("cluster_id", String.valueOf(request.getClusterId()));
                        params.put("name", String.valueOf(request.getName()));
                        params.put("node_pool_id", String.valueOf(request.getNodePoolId()));
                        params.put("project_id", String.valueOf(request.getProjectId()));
                        params.put("zone", String.valueOf(request.getZone()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<SetLoggingServiceRequest, Operation> setLoggingServiceTransportSettings =
        GrpcCallSettings.<SetLoggingServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(setLoggingServiceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetLoggingServiceRequest>() {
                  @Override
                  public Map<String, String> extract(SetLoggingServiceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetMonitoringServiceRequest, Operation> setMonitoringServiceTransportSettings =
        GrpcCallSettings.<SetMonitoringServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(setMonitoringServiceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetMonitoringServiceRequest>() {
                  @Override
                  public Map<String, String> extract(SetMonitoringServiceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetAddonsConfigRequest, Operation> setAddonsConfigTransportSettings =
        GrpcCallSettings.<SetAddonsConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(setAddonsConfigMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetAddonsConfigRequest>() {
                  @Override
                  public Map<String, String> extract(SetAddonsConfigRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetLocationsRequest, Operation> setLocationsTransportSettings =
        GrpcCallSettings.<SetLocationsRequest, Operation>newBuilder()
            .setMethodDescriptor(setLocationsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetLocationsRequest>() {
                  @Override
                  public Map<String, String> extract(SetLocationsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateMasterRequest, Operation> updateMasterTransportSettings =
        GrpcCallSettings.<UpdateMasterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMasterMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateMasterRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateMasterRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetMasterAuthRequest, Operation> setMasterAuthTransportSettings =
        GrpcCallSettings.<SetMasterAuthRequest, Operation>newBuilder()
            .setMethodDescriptor(setMasterAuthMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetMasterAuthRequest>() {
                  @Override
                  public Map<String, String> extract(SetMasterAuthRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteClusterRequest, Operation> deleteClusterTransportSettings =
        GrpcCallSettings.<DeleteClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteClusterMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteClusterRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteClusterRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListOperationsRequest, ListOperationsResponse>
        listOperationsTransportSettings =
            GrpcCallSettings.<ListOperationsRequest, ListOperationsResponse>newBuilder()
                .setMethodDescriptor(listOperationsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListOperationsRequest>() {
                      @Override
                      public Map<String, String> extract(ListOperationsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        params.put("project_id", String.valueOf(request.getProjectId()));
                        params.put("zone", String.valueOf(request.getZone()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetOperationRequest, Operation> getOperationTransportSettings =
        GrpcCallSettings.<GetOperationRequest, Operation>newBuilder()
            .setMethodDescriptor(getOperationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetOperationRequest>() {
                  @Override
                  public Map<String, String> extract(GetOperationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    params.put("operation_id", String.valueOf(request.getOperationId()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CancelOperationRequest, Empty> cancelOperationTransportSettings =
        GrpcCallSettings.<CancelOperationRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelOperationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CancelOperationRequest>() {
                  @Override
                  public Map<String, String> extract(CancelOperationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    params.put("operation_id", String.valueOf(request.getOperationId()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetServerConfigRequest, ServerConfig> getServerConfigTransportSettings =
        GrpcCallSettings.<GetServerConfigRequest, ServerConfig>newBuilder()
            .setMethodDescriptor(getServerConfigMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetServerConfigRequest>() {
                  @Override
                  public Map<String, String> extract(GetServerConfigRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetJSONWebKeysRequest, GetJSONWebKeysResponse>
        getJSONWebKeysTransportSettings =
            GrpcCallSettings.<GetJSONWebKeysRequest, GetJSONWebKeysResponse>newBuilder()
                .setMethodDescriptor(getJSONWebKeysMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetJSONWebKeysRequest>() {
                      @Override
                      public Map<String, String> extract(GetJSONWebKeysRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsTransportSettings =
        GrpcCallSettings.<ListNodePoolsRequest, ListNodePoolsResponse>newBuilder()
            .setMethodDescriptor(listNodePoolsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListNodePoolsRequest>() {
                  @Override
                  public Map<String, String> extract(ListNodePoolsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("parent", String.valueOf(request.getParent()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetNodePoolRequest, NodePool> getNodePoolTransportSettings =
        GrpcCallSettings.<GetNodePoolRequest, NodePool>newBuilder()
            .setMethodDescriptor(getNodePoolMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetNodePoolRequest>() {
                  @Override
                  public Map<String, String> extract(GetNodePoolRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("node_pool_id", String.valueOf(request.getNodePoolId()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateNodePoolRequest, Operation> createNodePoolTransportSettings =
        GrpcCallSettings.<CreateNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createNodePoolMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateNodePoolRequest>() {
                  @Override
                  public Map<String, String> extract(CreateNodePoolRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("parent", String.valueOf(request.getParent()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteNodePoolRequest, Operation> deleteNodePoolTransportSettings =
        GrpcCallSettings.<DeleteNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNodePoolMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteNodePoolRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteNodePoolRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("node_pool_id", String.valueOf(request.getNodePoolId()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<RollbackNodePoolUpgradeRequest, Operation>
        rollbackNodePoolUpgradeTransportSettings =
            GrpcCallSettings.<RollbackNodePoolUpgradeRequest, Operation>newBuilder()
                .setMethodDescriptor(rollbackNodePoolUpgradeMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<RollbackNodePoolUpgradeRequest>() {
                      @Override
                      public Map<String, String> extract(RollbackNodePoolUpgradeRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("cluster_id", String.valueOf(request.getClusterId()));
                        params.put("name", String.valueOf(request.getName()));
                        params.put("node_pool_id", String.valueOf(request.getNodePoolId()));
                        params.put("project_id", String.valueOf(request.getProjectId()));
                        params.put("zone", String.valueOf(request.getZone()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<SetNodePoolManagementRequest, Operation>
        setNodePoolManagementTransportSettings =
            GrpcCallSettings.<SetNodePoolManagementRequest, Operation>newBuilder()
                .setMethodDescriptor(setNodePoolManagementMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<SetNodePoolManagementRequest>() {
                      @Override
                      public Map<String, String> extract(SetNodePoolManagementRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("cluster_id", String.valueOf(request.getClusterId()));
                        params.put("name", String.valueOf(request.getName()));
                        params.put("node_pool_id", String.valueOf(request.getNodePoolId()));
                        params.put("project_id", String.valueOf(request.getProjectId()));
                        params.put("zone", String.valueOf(request.getZone()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<SetLabelsRequest, Operation> setLabelsTransportSettings =
        GrpcCallSettings.<SetLabelsRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetLabelsRequest>() {
                  @Override
                  public Map<String, String> extract(SetLabelsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetLegacyAbacRequest, Operation> setLegacyAbacTransportSettings =
        GrpcCallSettings.<SetLegacyAbacRequest, Operation>newBuilder()
            .setMethodDescriptor(setLegacyAbacMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetLegacyAbacRequest>() {
                  @Override
                  public Map<String, String> extract(SetLegacyAbacRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<StartIPRotationRequest, Operation> startIPRotationTransportSettings =
        GrpcCallSettings.<StartIPRotationRequest, Operation>newBuilder()
            .setMethodDescriptor(startIPRotationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<StartIPRotationRequest>() {
                  @Override
                  public Map<String, String> extract(StartIPRotationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CompleteIPRotationRequest, Operation> completeIPRotationTransportSettings =
        GrpcCallSettings.<CompleteIPRotationRequest, Operation>newBuilder()
            .setMethodDescriptor(completeIPRotationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CompleteIPRotationRequest>() {
                  @Override
                  public Map<String, String> extract(CompleteIPRotationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetNodePoolSizeRequest, Operation> setNodePoolSizeTransportSettings =
        GrpcCallSettings.<SetNodePoolSizeRequest, Operation>newBuilder()
            .setMethodDescriptor(setNodePoolSizeMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetNodePoolSizeRequest>() {
                  @Override
                  public Map<String, String> extract(SetNodePoolSizeRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("node_pool_id", String.valueOf(request.getNodePoolId()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetNetworkPolicyRequest, Operation> setNetworkPolicyTransportSettings =
        GrpcCallSettings.<SetNetworkPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(setNetworkPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetNetworkPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(SetNetworkPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetMaintenancePolicyRequest, Operation> setMaintenancePolicyTransportSettings =
        GrpcCallSettings.<SetMaintenancePolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(setMaintenancePolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetMaintenancePolicyRequest>() {
                  @Override
                  public Map<String, String> extract(SetMaintenancePolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_id", String.valueOf(request.getClusterId()));
                    params.put("name", String.valueOf(request.getName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("zone", String.valueOf(request.getZone()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>
        listUsableSubnetworksTransportSettings =
            GrpcCallSettings
                .<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>newBuilder()
                .setMethodDescriptor(listUsableSubnetworksMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListUsableSubnetworksRequest>() {
                      @Override
                      public Map<String, String> extract(ListUsableSubnetworksRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
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
    this.getJSONWebKeysCallable =
        callableFactory.createUnaryCallable(
            getJSONWebKeysTransportSettings, settings.getJSONWebKeysSettings(), clientContext);
    this.listNodePoolsCallable =
        callableFactory.createUnaryCallable(
            listNodePoolsTransportSettings, settings.listNodePoolsSettings(), clientContext);
    this.getNodePoolCallable =
        callableFactory.createUnaryCallable(
            getNodePoolTransportSettings, settings.getNodePoolSettings(), clientContext);
    this.createNodePoolCallable =
        callableFactory.createUnaryCallable(
            createNodePoolTransportSettings, settings.createNodePoolSettings(), clientContext);
    this.deleteNodePoolCallable =
        callableFactory.createUnaryCallable(
            deleteNodePoolTransportSettings, settings.deleteNodePoolSettings(), clientContext);
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return listClustersCallable;
  }

  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return getClusterCallable;
  }

  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return createClusterCallable;
  }

  public UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return updateClusterCallable;
  }

  public UnaryCallable<UpdateNodePoolRequest, Operation> updateNodePoolCallable() {
    return updateNodePoolCallable;
  }

  public UnaryCallable<SetNodePoolAutoscalingRequest, Operation> setNodePoolAutoscalingCallable() {
    return setNodePoolAutoscalingCallable;
  }

  public UnaryCallable<SetLoggingServiceRequest, Operation> setLoggingServiceCallable() {
    return setLoggingServiceCallable;
  }

  public UnaryCallable<SetMonitoringServiceRequest, Operation> setMonitoringServiceCallable() {
    return setMonitoringServiceCallable;
  }

  public UnaryCallable<SetAddonsConfigRequest, Operation> setAddonsConfigCallable() {
    return setAddonsConfigCallable;
  }

  public UnaryCallable<SetLocationsRequest, Operation> setLocationsCallable() {
    return setLocationsCallable;
  }

  public UnaryCallable<UpdateMasterRequest, Operation> updateMasterCallable() {
    return updateMasterCallable;
  }

  public UnaryCallable<SetMasterAuthRequest, Operation> setMasterAuthCallable() {
    return setMasterAuthCallable;
  }

  public UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return deleteClusterCallable;
  }

  public UnaryCallable<ListOperationsRequest, ListOperationsResponse> listOperationsCallable() {
    return listOperationsCallable;
  }

  public UnaryCallable<GetOperationRequest, Operation> getOperationCallable() {
    return getOperationCallable;
  }

  public UnaryCallable<CancelOperationRequest, Empty> cancelOperationCallable() {
    return cancelOperationCallable;
  }

  public UnaryCallable<GetServerConfigRequest, ServerConfig> getServerConfigCallable() {
    return getServerConfigCallable;
  }

  public UnaryCallable<GetJSONWebKeysRequest, GetJSONWebKeysResponse> getJSONWebKeysCallable() {
    return getJSONWebKeysCallable;
  }

  public UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsCallable() {
    return listNodePoolsCallable;
  }

  public UnaryCallable<GetNodePoolRequest, NodePool> getNodePoolCallable() {
    return getNodePoolCallable;
  }

  public UnaryCallable<CreateNodePoolRequest, Operation> createNodePoolCallable() {
    return createNodePoolCallable;
  }

  public UnaryCallable<DeleteNodePoolRequest, Operation> deleteNodePoolCallable() {
    return deleteNodePoolCallable;
  }

  public UnaryCallable<RollbackNodePoolUpgradeRequest, Operation>
      rollbackNodePoolUpgradeCallable() {
    return rollbackNodePoolUpgradeCallable;
  }

  public UnaryCallable<SetNodePoolManagementRequest, Operation> setNodePoolManagementCallable() {
    return setNodePoolManagementCallable;
  }

  public UnaryCallable<SetLabelsRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  public UnaryCallable<SetLegacyAbacRequest, Operation> setLegacyAbacCallable() {
    return setLegacyAbacCallable;
  }

  public UnaryCallable<StartIPRotationRequest, Operation> startIPRotationCallable() {
    return startIPRotationCallable;
  }

  public UnaryCallable<CompleteIPRotationRequest, Operation> completeIPRotationCallable() {
    return completeIPRotationCallable;
  }

  public UnaryCallable<SetNodePoolSizeRequest, Operation> setNodePoolSizeCallable() {
    return setNodePoolSizeCallable;
  }

  public UnaryCallable<SetNetworkPolicyRequest, Operation> setNetworkPolicyCallable() {
    return setNetworkPolicyCallable;
  }

  public UnaryCallable<SetMaintenancePolicyRequest, Operation> setMaintenancePolicyCallable() {
    return setMaintenancePolicyCallable;
  }

  public UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>
      listUsableSubnetworksCallable() {
    return listUsableSubnetworksCallable;
  }

  public UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksPagedResponse>
      listUsableSubnetworksPagedCallable() {
    return listUsableSubnetworksPagedCallable;
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
