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
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the EdgeContainer service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class EdgeContainerStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListClustersRequest, ListClustersPagedResponse> listClustersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listClustersPagedCallable()");
  }

  public UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listClustersCallable()");
  }

  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getClusterCallable()");
  }

  public OperationCallable<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createClusterOperationCallable()");
  }

  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createClusterCallable()");
  }

  public OperationCallable<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateClusterOperationCallable()");
  }

  public UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateClusterCallable()");
  }

  public OperationCallable<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteClusterOperationCallable()");
  }

  public UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteClusterCallable()");
  }

  public UnaryCallable<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenCallable() {
    throw new UnsupportedOperationException("Not implemented: generateAccessTokenCallable()");
  }

  public UnaryCallable<ListNodePoolsRequest, ListNodePoolsPagedResponse>
      listNodePoolsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodePoolsPagedCallable()");
  }

  public UnaryCallable<ListNodePoolsRequest, ListNodePoolsResponse> listNodePoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodePoolsCallable()");
  }

  public UnaryCallable<GetNodePoolRequest, NodePool> getNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getNodePoolCallable()");
  }

  public OperationCallable<CreateNodePoolRequest, NodePool, OperationMetadata>
      createNodePoolOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createNodePoolOperationCallable()");
  }

  public UnaryCallable<CreateNodePoolRequest, Operation> createNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: createNodePoolCallable()");
  }

  public OperationCallable<UpdateNodePoolRequest, NodePool, OperationMetadata>
      updateNodePoolOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNodePoolOperationCallable()");
  }

  public UnaryCallable<UpdateNodePoolRequest, Operation> updateNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNodePoolCallable()");
  }

  public OperationCallable<DeleteNodePoolRequest, Empty, OperationMetadata>
      deleteNodePoolOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNodePoolOperationCallable()");
  }

  public UnaryCallable<DeleteNodePoolRequest, Operation> deleteNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNodePoolCallable()");
  }

  public UnaryCallable<ListMachinesRequest, ListMachinesPagedResponse> listMachinesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMachinesPagedCallable()");
  }

  public UnaryCallable<ListMachinesRequest, ListMachinesResponse> listMachinesCallable() {
    throw new UnsupportedOperationException("Not implemented: listMachinesCallable()");
  }

  public UnaryCallable<GetMachineRequest, Machine> getMachineCallable() {
    throw new UnsupportedOperationException("Not implemented: getMachineCallable()");
  }

  public UnaryCallable<ListVpnConnectionsRequest, ListVpnConnectionsPagedResponse>
      listVpnConnectionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listVpnConnectionsPagedCallable()");
  }

  public UnaryCallable<ListVpnConnectionsRequest, ListVpnConnectionsResponse>
      listVpnConnectionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listVpnConnectionsCallable()");
  }

  public UnaryCallable<GetVpnConnectionRequest, VpnConnection> getVpnConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: getVpnConnectionCallable()");
  }

  public OperationCallable<CreateVpnConnectionRequest, VpnConnection, OperationMetadata>
      createVpnConnectionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createVpnConnectionOperationCallable()");
  }

  public UnaryCallable<CreateVpnConnectionRequest, Operation> createVpnConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: createVpnConnectionCallable()");
  }

  public OperationCallable<DeleteVpnConnectionRequest, Empty, OperationMetadata>
      deleteVpnConnectionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteVpnConnectionOperationCallable()");
  }

  public UnaryCallable<DeleteVpnConnectionRequest, Operation> deleteVpnConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteVpnConnectionCallable()");
  }

  @Override
  public abstract void close();
}
