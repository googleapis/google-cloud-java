/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.FetchNetworkPolicyExternalAddressesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListClustersPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListExternalAccessRulesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListExternalAddressesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListHcxActivationKeysPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListLocationsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListLoggingServersPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListManagementDnsZoneBindingsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNetworkPeeringsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNetworkPoliciesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNodeTypesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListNodesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPeeringRoutesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPrivateCloudsPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPrivateConnectionPeeringRoutesPagedResponse;
import static com.google.cloud.vmwareengine.v1.VmwareEngineClient.ListPrivateConnectionsPagedResponse;
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
import com.google.cloud.vmwareengine.v1.CreateExternalAccessRuleRequest;
import com.google.cloud.vmwareengine.v1.CreateExternalAddressRequest;
import com.google.cloud.vmwareengine.v1.CreateHcxActivationKeyRequest;
import com.google.cloud.vmwareengine.v1.CreateLoggingServerRequest;
import com.google.cloud.vmwareengine.v1.CreateManagementDnsZoneBindingRequest;
import com.google.cloud.vmwareengine.v1.CreateNetworkPeeringRequest;
import com.google.cloud.vmwareengine.v1.CreateNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.CreatePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.CreatePrivateConnectionRequest;
import com.google.cloud.vmwareengine.v1.CreateVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.Credentials;
import com.google.cloud.vmwareengine.v1.DeleteClusterRequest;
import com.google.cloud.vmwareengine.v1.DeleteExternalAccessRuleRequest;
import com.google.cloud.vmwareengine.v1.DeleteExternalAddressRequest;
import com.google.cloud.vmwareengine.v1.DeleteLoggingServerRequest;
import com.google.cloud.vmwareengine.v1.DeleteManagementDnsZoneBindingRequest;
import com.google.cloud.vmwareengine.v1.DeleteNetworkPeeringRequest;
import com.google.cloud.vmwareengine.v1.DeleteNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.DeletePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.DeletePrivateConnectionRequest;
import com.google.cloud.vmwareengine.v1.DeleteVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.DnsBindPermission;
import com.google.cloud.vmwareengine.v1.DnsForwarding;
import com.google.cloud.vmwareengine.v1.ExternalAccessRule;
import com.google.cloud.vmwareengine.v1.ExternalAddress;
import com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesRequest;
import com.google.cloud.vmwareengine.v1.FetchNetworkPolicyExternalAddressesResponse;
import com.google.cloud.vmwareengine.v1.GetClusterRequest;
import com.google.cloud.vmwareengine.v1.GetDnsBindPermissionRequest;
import com.google.cloud.vmwareengine.v1.GetDnsForwardingRequest;
import com.google.cloud.vmwareengine.v1.GetExternalAccessRuleRequest;
import com.google.cloud.vmwareengine.v1.GetExternalAddressRequest;
import com.google.cloud.vmwareengine.v1.GetHcxActivationKeyRequest;
import com.google.cloud.vmwareengine.v1.GetLoggingServerRequest;
import com.google.cloud.vmwareengine.v1.GetManagementDnsZoneBindingRequest;
import com.google.cloud.vmwareengine.v1.GetNetworkPeeringRequest;
import com.google.cloud.vmwareengine.v1.GetNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.GetNodeRequest;
import com.google.cloud.vmwareengine.v1.GetNodeTypeRequest;
import com.google.cloud.vmwareengine.v1.GetPrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.GetPrivateConnectionRequest;
import com.google.cloud.vmwareengine.v1.GetSubnetRequest;
import com.google.cloud.vmwareengine.v1.GetVmwareEngineNetworkRequest;
import com.google.cloud.vmwareengine.v1.GrantDnsBindPermissionRequest;
import com.google.cloud.vmwareengine.v1.HcxActivationKey;
import com.google.cloud.vmwareengine.v1.ListClustersRequest;
import com.google.cloud.vmwareengine.v1.ListClustersResponse;
import com.google.cloud.vmwareengine.v1.ListExternalAccessRulesRequest;
import com.google.cloud.vmwareengine.v1.ListExternalAccessRulesResponse;
import com.google.cloud.vmwareengine.v1.ListExternalAddressesRequest;
import com.google.cloud.vmwareengine.v1.ListExternalAddressesResponse;
import com.google.cloud.vmwareengine.v1.ListHcxActivationKeysRequest;
import com.google.cloud.vmwareengine.v1.ListHcxActivationKeysResponse;
import com.google.cloud.vmwareengine.v1.ListLoggingServersRequest;
import com.google.cloud.vmwareengine.v1.ListLoggingServersResponse;
import com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsRequest;
import com.google.cloud.vmwareengine.v1.ListManagementDnsZoneBindingsResponse;
import com.google.cloud.vmwareengine.v1.ListNetworkPeeringsRequest;
import com.google.cloud.vmwareengine.v1.ListNetworkPeeringsResponse;
import com.google.cloud.vmwareengine.v1.ListNetworkPoliciesRequest;
import com.google.cloud.vmwareengine.v1.ListNetworkPoliciesResponse;
import com.google.cloud.vmwareengine.v1.ListNodeTypesRequest;
import com.google.cloud.vmwareengine.v1.ListNodeTypesResponse;
import com.google.cloud.vmwareengine.v1.ListNodesRequest;
import com.google.cloud.vmwareengine.v1.ListNodesResponse;
import com.google.cloud.vmwareengine.v1.ListPeeringRoutesRequest;
import com.google.cloud.vmwareengine.v1.ListPeeringRoutesResponse;
import com.google.cloud.vmwareengine.v1.ListPrivateCloudsRequest;
import com.google.cloud.vmwareengine.v1.ListPrivateCloudsResponse;
import com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesRequest;
import com.google.cloud.vmwareengine.v1.ListPrivateConnectionPeeringRoutesResponse;
import com.google.cloud.vmwareengine.v1.ListPrivateConnectionsRequest;
import com.google.cloud.vmwareengine.v1.ListPrivateConnectionsResponse;
import com.google.cloud.vmwareengine.v1.ListSubnetsRequest;
import com.google.cloud.vmwareengine.v1.ListSubnetsResponse;
import com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksRequest;
import com.google.cloud.vmwareengine.v1.ListVmwareEngineNetworksResponse;
import com.google.cloud.vmwareengine.v1.LoggingServer;
import com.google.cloud.vmwareengine.v1.ManagementDnsZoneBinding;
import com.google.cloud.vmwareengine.v1.NetworkPeering;
import com.google.cloud.vmwareengine.v1.NetworkPolicy;
import com.google.cloud.vmwareengine.v1.Node;
import com.google.cloud.vmwareengine.v1.NodeType;
import com.google.cloud.vmwareengine.v1.OperationMetadata;
import com.google.cloud.vmwareengine.v1.PrivateCloud;
import com.google.cloud.vmwareengine.v1.PrivateConnection;
import com.google.cloud.vmwareengine.v1.RepairManagementDnsZoneBindingRequest;
import com.google.cloud.vmwareengine.v1.ResetNsxCredentialsRequest;
import com.google.cloud.vmwareengine.v1.ResetVcenterCredentialsRequest;
import com.google.cloud.vmwareengine.v1.RevokeDnsBindPermissionRequest;
import com.google.cloud.vmwareengine.v1.ShowNsxCredentialsRequest;
import com.google.cloud.vmwareengine.v1.ShowVcenterCredentialsRequest;
import com.google.cloud.vmwareengine.v1.Subnet;
import com.google.cloud.vmwareengine.v1.UndeletePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.UpdateClusterRequest;
import com.google.cloud.vmwareengine.v1.UpdateDnsForwardingRequest;
import com.google.cloud.vmwareengine.v1.UpdateExternalAccessRuleRequest;
import com.google.cloud.vmwareengine.v1.UpdateExternalAddressRequest;
import com.google.cloud.vmwareengine.v1.UpdateLoggingServerRequest;
import com.google.cloud.vmwareengine.v1.UpdateManagementDnsZoneBindingRequest;
import com.google.cloud.vmwareengine.v1.UpdateNetworkPeeringRequest;
import com.google.cloud.vmwareengine.v1.UpdateNetworkPolicyRequest;
import com.google.cloud.vmwareengine.v1.UpdatePrivateCloudRequest;
import com.google.cloud.vmwareengine.v1.UpdatePrivateConnectionRequest;
import com.google.cloud.vmwareengine.v1.UpdateSubnetRequest;
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

  public UnaryCallable<ListNodesRequest, ListNodesPagedResponse> listNodesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodesPagedCallable()");
  }

  public UnaryCallable<ListNodesRequest, ListNodesResponse> listNodesCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodesCallable()");
  }

  public UnaryCallable<GetNodeRequest, Node> getNodeCallable() {
    throw new UnsupportedOperationException("Not implemented: getNodeCallable()");
  }

  public UnaryCallable<ListExternalAddressesRequest, ListExternalAddressesPagedResponse>
      listExternalAddressesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listExternalAddressesPagedCallable()");
  }

  public UnaryCallable<ListExternalAddressesRequest, ListExternalAddressesResponse>
      listExternalAddressesCallable() {
    throw new UnsupportedOperationException("Not implemented: listExternalAddressesCallable()");
  }

  public UnaryCallable<
          FetchNetworkPolicyExternalAddressesRequest,
          FetchNetworkPolicyExternalAddressesPagedResponse>
      fetchNetworkPolicyExternalAddressesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchNetworkPolicyExternalAddressesPagedCallable()");
  }

  public UnaryCallable<
          FetchNetworkPolicyExternalAddressesRequest, FetchNetworkPolicyExternalAddressesResponse>
      fetchNetworkPolicyExternalAddressesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchNetworkPolicyExternalAddressesCallable()");
  }

  public UnaryCallable<GetExternalAddressRequest, ExternalAddress> getExternalAddressCallable() {
    throw new UnsupportedOperationException("Not implemented: getExternalAddressCallable()");
  }

  public OperationCallable<CreateExternalAddressRequest, ExternalAddress, OperationMetadata>
      createExternalAddressOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createExternalAddressOperationCallable()");
  }

  public UnaryCallable<CreateExternalAddressRequest, Operation> createExternalAddressCallable() {
    throw new UnsupportedOperationException("Not implemented: createExternalAddressCallable()");
  }

  public OperationCallable<UpdateExternalAddressRequest, ExternalAddress, OperationMetadata>
      updateExternalAddressOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateExternalAddressOperationCallable()");
  }

  public UnaryCallable<UpdateExternalAddressRequest, Operation> updateExternalAddressCallable() {
    throw new UnsupportedOperationException("Not implemented: updateExternalAddressCallable()");
  }

  public OperationCallable<DeleteExternalAddressRequest, Empty, OperationMetadata>
      deleteExternalAddressOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteExternalAddressOperationCallable()");
  }

  public UnaryCallable<DeleteExternalAddressRequest, Operation> deleteExternalAddressCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExternalAddressCallable()");
  }

  public UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse> listSubnetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubnetsPagedCallable()");
  }

  public UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubnetsCallable()");
  }

  public UnaryCallable<GetSubnetRequest, Subnet> getSubnetCallable() {
    throw new UnsupportedOperationException("Not implemented: getSubnetCallable()");
  }

  public OperationCallable<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSubnetOperationCallable()");
  }

  public UnaryCallable<UpdateSubnetRequest, Operation> updateSubnetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSubnetCallable()");
  }

  public UnaryCallable<ListExternalAccessRulesRequest, ListExternalAccessRulesPagedResponse>
      listExternalAccessRulesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listExternalAccessRulesPagedCallable()");
  }

  public UnaryCallable<ListExternalAccessRulesRequest, ListExternalAccessRulesResponse>
      listExternalAccessRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: listExternalAccessRulesCallable()");
  }

  public UnaryCallable<GetExternalAccessRuleRequest, ExternalAccessRule>
      getExternalAccessRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: getExternalAccessRuleCallable()");
  }

  public OperationCallable<CreateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      createExternalAccessRuleOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createExternalAccessRuleOperationCallable()");
  }

  public UnaryCallable<CreateExternalAccessRuleRequest, Operation>
      createExternalAccessRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: createExternalAccessRuleCallable()");
  }

  public OperationCallable<UpdateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      updateExternalAccessRuleOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateExternalAccessRuleOperationCallable()");
  }

  public UnaryCallable<UpdateExternalAccessRuleRequest, Operation>
      updateExternalAccessRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: updateExternalAccessRuleCallable()");
  }

  public OperationCallable<DeleteExternalAccessRuleRequest, Empty, OperationMetadata>
      deleteExternalAccessRuleOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteExternalAccessRuleOperationCallable()");
  }

  public UnaryCallable<DeleteExternalAccessRuleRequest, Operation>
      deleteExternalAccessRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExternalAccessRuleCallable()");
  }

  public UnaryCallable<ListLoggingServersRequest, ListLoggingServersPagedResponse>
      listLoggingServersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLoggingServersPagedCallable()");
  }

  public UnaryCallable<ListLoggingServersRequest, ListLoggingServersResponse>
      listLoggingServersCallable() {
    throw new UnsupportedOperationException("Not implemented: listLoggingServersCallable()");
  }

  public UnaryCallable<GetLoggingServerRequest, LoggingServer> getLoggingServerCallable() {
    throw new UnsupportedOperationException("Not implemented: getLoggingServerCallable()");
  }

  public OperationCallable<CreateLoggingServerRequest, LoggingServer, OperationMetadata>
      createLoggingServerOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createLoggingServerOperationCallable()");
  }

  public UnaryCallable<CreateLoggingServerRequest, Operation> createLoggingServerCallable() {
    throw new UnsupportedOperationException("Not implemented: createLoggingServerCallable()");
  }

  public OperationCallable<UpdateLoggingServerRequest, LoggingServer, OperationMetadata>
      updateLoggingServerOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateLoggingServerOperationCallable()");
  }

  public UnaryCallable<UpdateLoggingServerRequest, Operation> updateLoggingServerCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLoggingServerCallable()");
  }

  public OperationCallable<DeleteLoggingServerRequest, Empty, OperationMetadata>
      deleteLoggingServerOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteLoggingServerOperationCallable()");
  }

  public UnaryCallable<DeleteLoggingServerRequest, Operation> deleteLoggingServerCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLoggingServerCallable()");
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

  public UnaryCallable<GetDnsForwardingRequest, DnsForwarding> getDnsForwardingCallable() {
    throw new UnsupportedOperationException("Not implemented: getDnsForwardingCallable()");
  }

  public OperationCallable<UpdateDnsForwardingRequest, DnsForwarding, OperationMetadata>
      updateDnsForwardingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateDnsForwardingOperationCallable()");
  }

  public UnaryCallable<UpdateDnsForwardingRequest, Operation> updateDnsForwardingCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDnsForwardingCallable()");
  }

  public UnaryCallable<GetNetworkPeeringRequest, NetworkPeering> getNetworkPeeringCallable() {
    throw new UnsupportedOperationException("Not implemented: getNetworkPeeringCallable()");
  }

  public UnaryCallable<ListNetworkPeeringsRequest, ListNetworkPeeringsPagedResponse>
      listNetworkPeeringsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworkPeeringsPagedCallable()");
  }

  public UnaryCallable<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse>
      listNetworkPeeringsCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworkPeeringsCallable()");
  }

  public OperationCallable<CreateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      createNetworkPeeringOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createNetworkPeeringOperationCallable()");
  }

  public UnaryCallable<CreateNetworkPeeringRequest, Operation> createNetworkPeeringCallable() {
    throw new UnsupportedOperationException("Not implemented: createNetworkPeeringCallable()");
  }

  public OperationCallable<DeleteNetworkPeeringRequest, Empty, OperationMetadata>
      deleteNetworkPeeringOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteNetworkPeeringOperationCallable()");
  }

  public UnaryCallable<DeleteNetworkPeeringRequest, Operation> deleteNetworkPeeringCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNetworkPeeringCallable()");
  }

  public OperationCallable<UpdateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      updateNetworkPeeringOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateNetworkPeeringOperationCallable()");
  }

  public UnaryCallable<UpdateNetworkPeeringRequest, Operation> updateNetworkPeeringCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNetworkPeeringCallable()");
  }

  public UnaryCallable<ListPeeringRoutesRequest, ListPeeringRoutesPagedResponse>
      listPeeringRoutesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPeeringRoutesPagedCallable()");
  }

  public UnaryCallable<ListPeeringRoutesRequest, ListPeeringRoutesResponse>
      listPeeringRoutesCallable() {
    throw new UnsupportedOperationException("Not implemented: listPeeringRoutesCallable()");
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

  public UnaryCallable<
          ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsPagedResponse>
      listManagementDnsZoneBindingsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listManagementDnsZoneBindingsPagedCallable()");
  }

  public UnaryCallable<ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsResponse>
      listManagementDnsZoneBindingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listManagementDnsZoneBindingsCallable()");
  }

  public UnaryCallable<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
      getManagementDnsZoneBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getManagementDnsZoneBindingCallable()");
  }

  public OperationCallable<
          CreateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      createManagementDnsZoneBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createManagementDnsZoneBindingOperationCallable()");
  }

  public UnaryCallable<CreateManagementDnsZoneBindingRequest, Operation>
      createManagementDnsZoneBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createManagementDnsZoneBindingCallable()");
  }

  public OperationCallable<
          UpdateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      updateManagementDnsZoneBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateManagementDnsZoneBindingOperationCallable()");
  }

  public UnaryCallable<UpdateManagementDnsZoneBindingRequest, Operation>
      updateManagementDnsZoneBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateManagementDnsZoneBindingCallable()");
  }

  public OperationCallable<DeleteManagementDnsZoneBindingRequest, Empty, OperationMetadata>
      deleteManagementDnsZoneBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteManagementDnsZoneBindingOperationCallable()");
  }

  public UnaryCallable<DeleteManagementDnsZoneBindingRequest, Operation>
      deleteManagementDnsZoneBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteManagementDnsZoneBindingCallable()");
  }

  public OperationCallable<
          RepairManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      repairManagementDnsZoneBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: repairManagementDnsZoneBindingOperationCallable()");
  }

  public UnaryCallable<RepairManagementDnsZoneBindingRequest, Operation>
      repairManagementDnsZoneBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: repairManagementDnsZoneBindingCallable()");
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

  public OperationCallable<CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createPrivateConnectionOperationCallable()");
  }

  public UnaryCallable<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: createPrivateConnectionCallable()");
  }

  public UnaryCallable<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: getPrivateConnectionCallable()");
  }

  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPrivateConnectionsPagedCallable()");
  }

  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPrivateConnectionsCallable()");
  }

  public OperationCallable<UpdatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      updatePrivateConnectionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updatePrivateConnectionOperationCallable()");
  }

  public UnaryCallable<UpdatePrivateConnectionRequest, Operation>
      updatePrivateConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePrivateConnectionCallable()");
  }

  public OperationCallable<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePrivateConnectionOperationCallable()");
  }

  public UnaryCallable<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePrivateConnectionCallable()");
  }

  public UnaryCallable<
          ListPrivateConnectionPeeringRoutesRequest,
          ListPrivateConnectionPeeringRoutesPagedResponse>
      listPrivateConnectionPeeringRoutesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPrivateConnectionPeeringRoutesPagedCallable()");
  }

  public UnaryCallable<
          ListPrivateConnectionPeeringRoutesRequest, ListPrivateConnectionPeeringRoutesResponse>
      listPrivateConnectionPeeringRoutesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPrivateConnectionPeeringRoutesCallable()");
  }

  public OperationCallable<GrantDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      grantDnsBindPermissionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: grantDnsBindPermissionOperationCallable()");
  }

  public UnaryCallable<GrantDnsBindPermissionRequest, Operation> grantDnsBindPermissionCallable() {
    throw new UnsupportedOperationException("Not implemented: grantDnsBindPermissionCallable()");
  }

  public UnaryCallable<GetDnsBindPermissionRequest, DnsBindPermission>
      getDnsBindPermissionCallable() {
    throw new UnsupportedOperationException("Not implemented: getDnsBindPermissionCallable()");
  }

  public OperationCallable<RevokeDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      revokeDnsBindPermissionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: revokeDnsBindPermissionOperationCallable()");
  }

  public UnaryCallable<RevokeDnsBindPermissionRequest, Operation>
      revokeDnsBindPermissionCallable() {
    throw new UnsupportedOperationException("Not implemented: revokeDnsBindPermissionCallable()");
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
