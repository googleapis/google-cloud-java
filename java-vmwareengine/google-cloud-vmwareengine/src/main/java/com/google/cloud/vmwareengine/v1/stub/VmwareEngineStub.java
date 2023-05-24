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

package com.google.cloud.vmwareengine.v1.stub;

import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListClustersPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListHcxActivationKeysPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListLocationsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNetworkPoliciesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNodeTypesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPrivateCloudsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListSubnetsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListVmwareEngineNetworksPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vmwareengine.v1.Cluster;
import com.google.cloud.vmwareengine.v1.CreateClusterRequest;
import com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest;
import com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.Credentials;
import com.google.cloud.vmwareengine.v1.DeleteClusterRequest;
import com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.GetClusterRequest;
import com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest;
import com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.GetNodeTypeRequest;
import com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.HcxActivationKey;
import com.google.cloud.vmwareengine.v1.ListClustersRequest;
import com.google.cloud.vmwareengine.v1.ListClustersResponse;
import com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest;
import com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse;
import com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest;
import com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse;
import com.google.cloud.vmwareengine.v1.ListNodeTypesRequest;
import com.google.cloud.vmwareengine.v1.ListNodeTypesResponse;
import com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest;
import com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse;
import com.google.cloud.vmwareengine.v1.ListSubnetsRequest;
import com.google.cloud.vmwareengine.v1.ListSubnetsResponse;
import com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest;
import com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse;
import com.google.cloud.vmwareengine.v1.NetworkPolicy;
import com.google.cloud.vmwareengine.v1.NodeType;
import com.google.cloud.vmwareengine.v1.OperationMetadata;
import com.google.cloud.vmwareengine.v1.PrivateCloud;
import com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest;
import com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest;
import com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest;
import com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest;
import com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.UpdateClusterRequest;
import com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.UpdateVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.VmwareEngineNetwork;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the VmwareEngine service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class VmwareEngineStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsPagedResponse>
      listPrivateCloudsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPrivateCloudsPagedCallable()");
  }

  public UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsResponse>
      listPrivateCloudsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPrivateCloudsCallable()");
  }

  public UnaryCallable<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudCallable() {
    throw new UnsupportedOperationException("Not implemented: getPrivateCloudCallable()");
  }

  public OperationCallable<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      createPrivateCloudOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createPrivateCloudOperationCallable()");
  }

  public UnaryCallable<CreatePrivateCloudRequest, Operation> createPrivateCloudCallable() {
    throw new UnsupportedOperationException("Not implemented: createPrivateCloudCallable()");
  }

  public OperationCallable<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      updatePrivateCloudOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updatePrivateCloudOperationCallable()");
  }

  public UnaryCallable<UpdatePrivateCloudRequest, Operation> updatePrivateCloudCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePrivateCloudCallable()");
  }

  public OperationCallable<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      deletePrivateCloudOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePrivateCloudOperationCallable()");
  }

  public UnaryCallable<DeletePrivateCloudRequest, Operation> deletePrivateCloudCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePrivateCloudCallable()");
  }

  public OperationCallable<UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      undeletePrivateCloudOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeletePrivateCloudOperationCallable()");
  }

  public UnaryCallable<UndeletePrivateCloudRequest, Operation> undeletePrivateCloudCallable() {
    throw new UnsupportedOperationException("Not implemented: undeletePrivateCloudCallable()");
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

  public UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse> listSubnetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubnetsPagedCallable()");
  }

  public UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubnetsCallable()");
  }

  public UnaryCallable<ListNodeTypesRequest, ListNodeTypesPagedResponse>
      listNodeTypesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodeTypesPagedCallable()");
  }

  public UnaryCallable<ListNodeTypesRequest, ListNodeTypesResponse> listNodeTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodeTypesCallable()");
  }

  public UnaryCallable<GetNodeTypeRequest, NodeType> getNodeTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: getNodeTypeCallable()");
  }

  public UnaryCallable<ShowNsxCredentialsRequest, Credentials> showNsxCredentialsCallable() {
    throw new UnsupportedOperationException("Not implemented: showNsxCredentialsCallable()");
  }

  public UnaryCallable<ShowVcenterCredentialsRequest, Credentials>
      showVcenterCredentialsCallable() {
    throw new UnsupportedOperationException("Not implemented: showVcenterCredentialsCallable()");
  }

  public OperationCallable<ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
      resetNsxCredentialsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: resetNsxCredentialsOperationCallable()");
  }

  public UnaryCallable<ResetNsxCredentialsRequest, Operation> resetNsxCredentialsCallable() {
    throw new UnsupportedOperationException("Not implemented: resetNsxCredentialsCallable()");
  }

  public OperationCallable<ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
      resetVcenterCredentialsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: resetVcenterCredentialsOperationCallable()");
  }

  public UnaryCallable<ResetVcenterCredentialsRequest, Operation>
      resetVcenterCredentialsCallable() {
    throw new UnsupportedOperationException("Not implemented: resetVcenterCredentialsCallable()");
  }

  public OperationCallable<CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
      createHcxActivationKeyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createHcxActivationKeyOperationCallable()");
  }

  public UnaryCallable<CreateHcxActivationKeyRequest, Operation> createHcxActivationKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: createHcxActivationKeyCallable()");
  }

  public UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysPagedResponse>
      listHcxActivationKeysPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listHcxActivationKeysPagedCallable()");
  }

  public UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>
      listHcxActivationKeysCallable() {
    throw new UnsupportedOperationException("Not implemented: listHcxActivationKeysCallable()");
  }

  public UnaryCallable<GetHcxActivationKeyRequest, HcxActivationKey> getHcxActivationKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: getHcxActivationKeyCallable()");
  }

  public UnaryCallable<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getNetworkPolicyCallable()");
  }

  public UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesPagedResponse>
      listNetworkPoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworkPoliciesPagedCallable()");
  }

  public UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>
      listNetworkPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworkPoliciesCallable()");
  }

  public OperationCallable<CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      createNetworkPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createNetworkPolicyOperationCallable()");
  }

  public UnaryCallable<CreateNetworkPolicyRequest, Operation> createNetworkPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createNetworkPolicyCallable()");
  }

  public OperationCallable<UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      updateNetworkPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateNetworkPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateNetworkPolicyRequest, Operation> updateNetworkPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNetworkPolicyCallable()");
  }

  public OperationCallable<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
      deleteNetworkPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteNetworkPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteNetworkPolicyRequest, Operation> deleteNetworkPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNetworkPolicyCallable()");
  }

  public OperationCallable<CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createVmwareEngineNetworkOperationCallable()");
  }

  public UnaryCallable<CreateVmwareEngineNetworkRequest, Operation>
      createVmwareEngineNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: createVmwareEngineNetworkCallable()");
  }

  public OperationCallable<UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateVmwareEngineNetworkOperationCallable()");
  }

  public UnaryCallable<UpdateVmwareEngineNetworkRequest, Operation>
      updateVmwareEngineNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: updateVmwareEngineNetworkCallable()");
  }

  public OperationCallable<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
      deleteVmwareEngineNetworkOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteVmwareEngineNetworkOperationCallable()");
  }

  public UnaryCallable<DeleteVmwareEngineNetworkRequest, Operation>
      deleteVmwareEngineNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteVmwareEngineNetworkCallable()");
  }

  public UnaryCallable<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
      getVmwareEngineNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: getVmwareEngineNetworkCallable()");
  }

  public UnaryCallable<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksPagedResponse>
      listVmwareEngineNetworksPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listVmwareEngineNetworksPagedCallable()");
  }

  public UnaryCallable<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>
      listVmwareEngineNetworksCallable() {
    throw new UnsupportedOperationException("Not implemented: listVmwareEngineNetworksCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
