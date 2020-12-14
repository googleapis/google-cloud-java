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
import com.google.api.gax.rpc.UnaryCallable;
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
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ClusterManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class ClusterManagerStub implements BackgroundResource {

  public UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listClustersCallable()");
  }

  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getClusterCallable()");
  }

  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createClusterCallable()");
  }

  public UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateClusterCallable()");
  }

  public UnaryCallable<UpdateNodePoolRequest, Operation> updateNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNodePoolCallable()");
  }

  public UnaryCallable<SetNodePoolAutoscalingRequest, Operation> setNodePoolAutoscalingCallable() {
    throw new UnsupportedOperationException("Not implemented: setNodePoolAutoscalingCallable()");
  }

  public UnaryCallable<SetLoggingServiceRequest, Operation> setLoggingServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: setLoggingServiceCallable()");
  }

  public UnaryCallable<SetMonitoringServiceRequest, Operation> setMonitoringServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: setMonitoringServiceCallable()");
  }

  public UnaryCallable<SetAddonsConfigRequest, Operation> setAddonsConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: setAddonsConfigCallable()");
  }

  public UnaryCallable<SetLocationsRequest, Operation> setLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: setLocationsCallable()");
  }

  public UnaryCallable<UpdateMasterRequest, Operation> updateMasterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMasterCallable()");
  }

  public UnaryCallable<SetMasterAuthRequest, Operation> setMasterAuthCallable() {
    throw new UnsupportedOperationException("Not implemented: setMasterAuthCallable()");
  }

  public UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteClusterCallable()");
  }

  public UnaryCallable<ListOperationsRequest, ListOperationsResponse> listOperationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listOperationsCallable()");
  }

  public UnaryCallable<GetOperationRequest, Operation> getOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: getOperationCallable()");
  }

  public UnaryCallable<CancelOperationRequest, Empty> cancelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelOperationCallable()");
  }

  public UnaryCallable<GetServerConfigRequest, ServerConfig> getServerConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getServerConfigCallable()");
  }

  public UnaryCallable<GetJSONWebKeysRequest, GetJSONWebKeysResponse> getJSONWebKeysCallable() {
    throw new UnsupportedOperationException("Not implemented: getJSONWebKeysCallable()");
  }

  public UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodePoolsCallable()");
  }

  public UnaryCallable<GetNodePoolRequest, NodePool> getNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getNodePoolCallable()");
  }

  public UnaryCallable<CreateNodePoolRequest, Operation> createNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: createNodePoolCallable()");
  }

  public UnaryCallable<DeleteNodePoolRequest, Operation> deleteNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNodePoolCallable()");
  }

  public UnaryCallable<RollbackNodePoolUpgradeRequest, Operation>
      rollbackNodePoolUpgradeCallable() {
    throw new UnsupportedOperationException("Not implemented: rollbackNodePoolUpgradeCallable()");
  }

  public UnaryCallable<SetNodePoolManagementRequest, Operation> setNodePoolManagementCallable() {
    throw new UnsupportedOperationException("Not implemented: setNodePoolManagementCallable()");
  }

  public UnaryCallable<SetLabelsRequest, Operation> setLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsCallable()");
  }

  public UnaryCallable<SetLegacyAbacRequest, Operation> setLegacyAbacCallable() {
    throw new UnsupportedOperationException("Not implemented: setLegacyAbacCallable()");
  }

  public UnaryCallable<StartIPRotationRequest, Operation> startIPRotationCallable() {
    throw new UnsupportedOperationException("Not implemented: startIPRotationCallable()");
  }

  public UnaryCallable<CompleteIPRotationRequest, Operation> completeIPRotationCallable() {
    throw new UnsupportedOperationException("Not implemented: completeIPRotationCallable()");
  }

  public UnaryCallable<SetNodePoolSizeRequest, Operation> setNodePoolSizeCallable() {
    throw new UnsupportedOperationException("Not implemented: setNodePoolSizeCallable()");
  }

  public UnaryCallable<SetNetworkPolicyRequest, Operation> setNetworkPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setNetworkPolicyCallable()");
  }

  public UnaryCallable<SetMaintenancePolicyRequest, Operation> setMaintenancePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setMaintenancePolicyCallable()");
  }

  public UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksPagedResponse>
      listUsableSubnetworksPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listUsableSubnetworksPagedCallable()");
  }

  public UnaryCallable<ListUsableSubnetworksRequest, ListUsableSubnetworksResponse>
      listUsableSubnetworksCallable() {
    throw new UnsupportedOperationException("Not implemented: listUsableSubnetworksCallable()");
  }

  @Override
  public abstract void close();
}
