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

package com.google.cloud.vmwareengine.v1;

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

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vmwareengine.v1.stub.VmwareEngineStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VmwareEngineClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (vmwareengine.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getPrivateCloud to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VmwareEngineSettings.Builder vmwareEngineSettingsBuilder = VmwareEngineSettings.newBuilder();
 * vmwareEngineSettingsBuilder
 *     .getPrivateCloudSettings()
 *     .setRetrySettings(
 *         vmwareEngineSettingsBuilder
 *             .getPrivateCloudSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VmwareEngineSettings vmwareEngineSettings = vmwareEngineSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class VmwareEngineSettings extends ClientSettings<VmwareEngineSettings> {

  /** Returns the object with the settings used for calls to listPrivateClouds. */
  public PagedCallSettings<
          ListPrivateCloudsRequest, ListPrivateCloudsResponse, ListPrivateCloudsPagedResponse>
      listPrivateCloudsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listPrivateCloudsSettings();
  }

  /** Returns the object with the settings used for calls to getPrivateCloud. */
  public UnaryCallSettings<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getPrivateCloudSettings();
  }

  /** Returns the object with the settings used for calls to createPrivateCloud. */
  public UnaryCallSettings<CreatePrivateCloudRequest, Operation> createPrivateCloudSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createPrivateCloudSettings();
  }

  /** Returns the object with the settings used for calls to createPrivateCloud. */
  public OperationCallSettings<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      createPrivateCloudOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createPrivateCloudOperationSettings();
  }

  /** Returns the object with the settings used for calls to updatePrivateCloud. */
  public UnaryCallSettings<UpdatePrivateCloudRequest, Operation> updatePrivateCloudSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updatePrivateCloudSettings();
  }

  /** Returns the object with the settings used for calls to updatePrivateCloud. */
  public OperationCallSettings<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      updatePrivateCloudOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updatePrivateCloudOperationSettings();
  }

  /** Returns the object with the settings used for calls to deletePrivateCloud. */
  public UnaryCallSettings<DeletePrivateCloudRequest, Operation> deletePrivateCloudSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deletePrivateCloudSettings();
  }

  /** Returns the object with the settings used for calls to deletePrivateCloud. */
  public OperationCallSettings<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      deletePrivateCloudOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deletePrivateCloudOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeletePrivateCloud. */
  public UnaryCallSettings<UndeletePrivateCloudRequest, Operation> undeletePrivateCloudSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).undeletePrivateCloudSettings();
  }

  /** Returns the object with the settings used for calls to undeletePrivateCloud. */
  public OperationCallSettings<UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      undeletePrivateCloudOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).undeletePrivateCloudOperationSettings();
  }

  /** Returns the object with the settings used for calls to listClusters. */
  public PagedCallSettings<ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listClustersSettings();
  }

  /** Returns the object with the settings used for calls to getCluster. */
  public UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateClusterSettings();
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteClusterSettings();
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to listNodes. */
  public PagedCallSettings<ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>
      listNodesSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listNodesSettings();
  }

  /** Returns the object with the settings used for calls to getNode. */
  public UnaryCallSettings<GetNodeRequest, Node> getNodeSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getNodeSettings();
  }

  /** Returns the object with the settings used for calls to listExternalAddresses. */
  public PagedCallSettings<
          ListExternalAddressesRequest,
          ListExternalAddressesResponse,
          ListExternalAddressesPagedResponse>
      listExternalAddressesSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listExternalAddressesSettings();
  }

  /** Returns the object with the settings used for calls to fetchNetworkPolicyExternalAddresses. */
  public PagedCallSettings<
          FetchNetworkPolicyExternalAddressesRequest,
          FetchNetworkPolicyExternalAddressesResponse,
          FetchNetworkPolicyExternalAddressesPagedResponse>
      fetchNetworkPolicyExternalAddressesSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .fetchNetworkPolicyExternalAddressesSettings();
  }

  /** Returns the object with the settings used for calls to getExternalAddress. */
  public UnaryCallSettings<GetExternalAddressRequest, ExternalAddress>
      getExternalAddressSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getExternalAddressSettings();
  }

  /** Returns the object with the settings used for calls to createExternalAddress. */
  public UnaryCallSettings<CreateExternalAddressRequest, Operation>
      createExternalAddressSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createExternalAddressSettings();
  }

  /** Returns the object with the settings used for calls to createExternalAddress. */
  public OperationCallSettings<CreateExternalAddressRequest, ExternalAddress, OperationMetadata>
      createExternalAddressOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createExternalAddressOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateExternalAddress. */
  public UnaryCallSettings<UpdateExternalAddressRequest, Operation>
      updateExternalAddressSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateExternalAddressSettings();
  }

  /** Returns the object with the settings used for calls to updateExternalAddress. */
  public OperationCallSettings<UpdateExternalAddressRequest, ExternalAddress, OperationMetadata>
      updateExternalAddressOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateExternalAddressOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteExternalAddress. */
  public UnaryCallSettings<DeleteExternalAddressRequest, Operation>
      deleteExternalAddressSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteExternalAddressSettings();
  }

  /** Returns the object with the settings used for calls to deleteExternalAddress. */
  public OperationCallSettings<DeleteExternalAddressRequest, Empty, OperationMetadata>
      deleteExternalAddressOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteExternalAddressOperationSettings();
  }

  /** Returns the object with the settings used for calls to listSubnets. */
  public PagedCallSettings<ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
      listSubnetsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listSubnetsSettings();
  }

  /** Returns the object with the settings used for calls to getSubnet. */
  public UnaryCallSettings<GetSubnetRequest, Subnet> getSubnetSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getSubnetSettings();
  }

  /** Returns the object with the settings used for calls to updateSubnet. */
  public UnaryCallSettings<UpdateSubnetRequest, Operation> updateSubnetSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateSubnetSettings();
  }

  /** Returns the object with the settings used for calls to updateSubnet. */
  public OperationCallSettings<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateSubnetOperationSettings();
  }

  /** Returns the object with the settings used for calls to listExternalAccessRules. */
  public PagedCallSettings<
          ListExternalAccessRulesRequest,
          ListExternalAccessRulesResponse,
          ListExternalAccessRulesPagedResponse>
      listExternalAccessRulesSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listExternalAccessRulesSettings();
  }

  /** Returns the object with the settings used for calls to getExternalAccessRule. */
  public UnaryCallSettings<GetExternalAccessRuleRequest, ExternalAccessRule>
      getExternalAccessRuleSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getExternalAccessRuleSettings();
  }

  /** Returns the object with the settings used for calls to createExternalAccessRule. */
  public UnaryCallSettings<CreateExternalAccessRuleRequest, Operation>
      createExternalAccessRuleSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createExternalAccessRuleSettings();
  }

  /** Returns the object with the settings used for calls to createExternalAccessRule. */
  public OperationCallSettings<
          CreateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      createExternalAccessRuleOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .createExternalAccessRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateExternalAccessRule. */
  public UnaryCallSettings<UpdateExternalAccessRuleRequest, Operation>
      updateExternalAccessRuleSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateExternalAccessRuleSettings();
  }

  /** Returns the object with the settings used for calls to updateExternalAccessRule. */
  public OperationCallSettings<
          UpdateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      updateExternalAccessRuleOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .updateExternalAccessRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteExternalAccessRule. */
  public UnaryCallSettings<DeleteExternalAccessRuleRequest, Operation>
      deleteExternalAccessRuleSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteExternalAccessRuleSettings();
  }

  /** Returns the object with the settings used for calls to deleteExternalAccessRule. */
  public OperationCallSettings<DeleteExternalAccessRuleRequest, Empty, OperationMetadata>
      deleteExternalAccessRuleOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .deleteExternalAccessRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLoggingServers. */
  public PagedCallSettings<
          ListLoggingServersRequest, ListLoggingServersResponse, ListLoggingServersPagedResponse>
      listLoggingServersSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listLoggingServersSettings();
  }

  /** Returns the object with the settings used for calls to getLoggingServer. */
  public UnaryCallSettings<GetLoggingServerRequest, LoggingServer> getLoggingServerSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getLoggingServerSettings();
  }

  /** Returns the object with the settings used for calls to createLoggingServer. */
  public UnaryCallSettings<CreateLoggingServerRequest, Operation> createLoggingServerSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createLoggingServerSettings();
  }

  /** Returns the object with the settings used for calls to createLoggingServer. */
  public OperationCallSettings<CreateLoggingServerRequest, LoggingServer, OperationMetadata>
      createLoggingServerOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createLoggingServerOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateLoggingServer. */
  public UnaryCallSettings<UpdateLoggingServerRequest, Operation> updateLoggingServerSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateLoggingServerSettings();
  }

  /** Returns the object with the settings used for calls to updateLoggingServer. */
  public OperationCallSettings<UpdateLoggingServerRequest, LoggingServer, OperationMetadata>
      updateLoggingServerOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateLoggingServerOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteLoggingServer. */
  public UnaryCallSettings<DeleteLoggingServerRequest, Operation> deleteLoggingServerSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteLoggingServerSettings();
  }

  /** Returns the object with the settings used for calls to deleteLoggingServer. */
  public OperationCallSettings<DeleteLoggingServerRequest, Empty, OperationMetadata>
      deleteLoggingServerOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteLoggingServerOperationSettings();
  }

  /** Returns the object with the settings used for calls to listNodeTypes. */
  public PagedCallSettings<ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>
      listNodeTypesSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listNodeTypesSettings();
  }

  /** Returns the object with the settings used for calls to getNodeType. */
  public UnaryCallSettings<GetNodeTypeRequest, NodeType> getNodeTypeSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getNodeTypeSettings();
  }

  /** Returns the object with the settings used for calls to showNsxCredentials. */
  public UnaryCallSettings<ShowNsxCredentialsRequest, Credentials> showNsxCredentialsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).showNsxCredentialsSettings();
  }

  /** Returns the object with the settings used for calls to showVcenterCredentials. */
  public UnaryCallSettings<ShowVcenterCredentialsRequest, Credentials>
      showVcenterCredentialsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).showVcenterCredentialsSettings();
  }

  /** Returns the object with the settings used for calls to resetNsxCredentials. */
  public UnaryCallSettings<ResetNsxCredentialsRequest, Operation> resetNsxCredentialsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).resetNsxCredentialsSettings();
  }

  /** Returns the object with the settings used for calls to resetNsxCredentials. */
  public OperationCallSettings<ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
      resetNsxCredentialsOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).resetNsxCredentialsOperationSettings();
  }

  /** Returns the object with the settings used for calls to resetVcenterCredentials. */
  public UnaryCallSettings<ResetVcenterCredentialsRequest, Operation>
      resetVcenterCredentialsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).resetVcenterCredentialsSettings();
  }

  /** Returns the object with the settings used for calls to resetVcenterCredentials. */
  public OperationCallSettings<ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
      resetVcenterCredentialsOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .resetVcenterCredentialsOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDnsForwarding. */
  public UnaryCallSettings<GetDnsForwardingRequest, DnsForwarding> getDnsForwardingSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getDnsForwardingSettings();
  }

  /** Returns the object with the settings used for calls to updateDnsForwarding. */
  public UnaryCallSettings<UpdateDnsForwardingRequest, Operation> updateDnsForwardingSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateDnsForwardingSettings();
  }

  /** Returns the object with the settings used for calls to updateDnsForwarding. */
  public OperationCallSettings<UpdateDnsForwardingRequest, DnsForwarding, OperationMetadata>
      updateDnsForwardingOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateDnsForwardingOperationSettings();
  }

  /** Returns the object with the settings used for calls to getNetworkPeering. */
  public UnaryCallSettings<GetNetworkPeeringRequest, NetworkPeering> getNetworkPeeringSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getNetworkPeeringSettings();
  }

  /** Returns the object with the settings used for calls to listNetworkPeerings. */
  public PagedCallSettings<
          ListNetworkPeeringsRequest, ListNetworkPeeringsResponse, ListNetworkPeeringsPagedResponse>
      listNetworkPeeringsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listNetworkPeeringsSettings();
  }

  /** Returns the object with the settings used for calls to createNetworkPeering. */
  public UnaryCallSettings<CreateNetworkPeeringRequest, Operation> createNetworkPeeringSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createNetworkPeeringSettings();
  }

  /** Returns the object with the settings used for calls to createNetworkPeering. */
  public OperationCallSettings<CreateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      createNetworkPeeringOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createNetworkPeeringOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteNetworkPeering. */
  public UnaryCallSettings<DeleteNetworkPeeringRequest, Operation> deleteNetworkPeeringSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteNetworkPeeringSettings();
  }

  /** Returns the object with the settings used for calls to deleteNetworkPeering. */
  public OperationCallSettings<DeleteNetworkPeeringRequest, Empty, OperationMetadata>
      deleteNetworkPeeringOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteNetworkPeeringOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateNetworkPeering. */
  public UnaryCallSettings<UpdateNetworkPeeringRequest, Operation> updateNetworkPeeringSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateNetworkPeeringSettings();
  }

  /** Returns the object with the settings used for calls to updateNetworkPeering. */
  public OperationCallSettings<UpdateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      updateNetworkPeeringOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateNetworkPeeringOperationSettings();
  }

  /** Returns the object with the settings used for calls to listPeeringRoutes. */
  public PagedCallSettings<
          ListPeeringRoutesRequest, ListPeeringRoutesResponse, ListPeeringRoutesPagedResponse>
      listPeeringRoutesSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listPeeringRoutesSettings();
  }

  /** Returns the object with the settings used for calls to createHcxActivationKey. */
  public UnaryCallSettings<CreateHcxActivationKeyRequest, Operation>
      createHcxActivationKeySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createHcxActivationKeySettings();
  }

  /** Returns the object with the settings used for calls to createHcxActivationKey. */
  public OperationCallSettings<CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
      createHcxActivationKeyOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createHcxActivationKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listHcxActivationKeys. */
  public PagedCallSettings<
          ListHcxActivationKeysRequest,
          ListHcxActivationKeysResponse,
          ListHcxActivationKeysPagedResponse>
      listHcxActivationKeysSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listHcxActivationKeysSettings();
  }

  /** Returns the object with the settings used for calls to getHcxActivationKey. */
  public UnaryCallSettings<GetHcxActivationKeyRequest, HcxActivationKey>
      getHcxActivationKeySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getHcxActivationKeySettings();
  }

  /** Returns the object with the settings used for calls to getNetworkPolicy. */
  public UnaryCallSettings<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getNetworkPolicySettings();
  }

  /** Returns the object with the settings used for calls to listNetworkPolicies. */
  public PagedCallSettings<
          ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, ListNetworkPoliciesPagedResponse>
      listNetworkPoliciesSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listNetworkPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to createNetworkPolicy. */
  public UnaryCallSettings<CreateNetworkPolicyRequest, Operation> createNetworkPolicySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createNetworkPolicySettings();
  }

  /** Returns the object with the settings used for calls to createNetworkPolicy. */
  public OperationCallSettings<CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      createNetworkPolicyOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createNetworkPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateNetworkPolicy. */
  public UnaryCallSettings<UpdateNetworkPolicyRequest, Operation> updateNetworkPolicySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateNetworkPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateNetworkPolicy. */
  public OperationCallSettings<UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      updateNetworkPolicyOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateNetworkPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteNetworkPolicy. */
  public UnaryCallSettings<DeleteNetworkPolicyRequest, Operation> deleteNetworkPolicySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteNetworkPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteNetworkPolicy. */
  public OperationCallSettings<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
      deleteNetworkPolicyOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteNetworkPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listManagementDnsZoneBindings. */
  public PagedCallSettings<
          ListManagementDnsZoneBindingsRequest,
          ListManagementDnsZoneBindingsResponse,
          ListManagementDnsZoneBindingsPagedResponse>
      listManagementDnsZoneBindingsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listManagementDnsZoneBindingsSettings();
  }

  /** Returns the object with the settings used for calls to getManagementDnsZoneBinding. */
  public UnaryCallSettings<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
      getManagementDnsZoneBindingSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getManagementDnsZoneBindingSettings();
  }

  /** Returns the object with the settings used for calls to createManagementDnsZoneBinding. */
  public UnaryCallSettings<CreateManagementDnsZoneBindingRequest, Operation>
      createManagementDnsZoneBindingSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createManagementDnsZoneBindingSettings();
  }

  /** Returns the object with the settings used for calls to createManagementDnsZoneBinding. */
  public OperationCallSettings<
          CreateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      createManagementDnsZoneBindingOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .createManagementDnsZoneBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateManagementDnsZoneBinding. */
  public UnaryCallSettings<UpdateManagementDnsZoneBindingRequest, Operation>
      updateManagementDnsZoneBindingSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateManagementDnsZoneBindingSettings();
  }

  /** Returns the object with the settings used for calls to updateManagementDnsZoneBinding. */
  public OperationCallSettings<
          UpdateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      updateManagementDnsZoneBindingOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .updateManagementDnsZoneBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteManagementDnsZoneBinding. */
  public UnaryCallSettings<DeleteManagementDnsZoneBindingRequest, Operation>
      deleteManagementDnsZoneBindingSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteManagementDnsZoneBindingSettings();
  }

  /** Returns the object with the settings used for calls to deleteManagementDnsZoneBinding. */
  public OperationCallSettings<DeleteManagementDnsZoneBindingRequest, Empty, OperationMetadata>
      deleteManagementDnsZoneBindingOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .deleteManagementDnsZoneBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to repairManagementDnsZoneBinding. */
  public UnaryCallSettings<RepairManagementDnsZoneBindingRequest, Operation>
      repairManagementDnsZoneBindingSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).repairManagementDnsZoneBindingSettings();
  }

  /** Returns the object with the settings used for calls to repairManagementDnsZoneBinding. */
  public OperationCallSettings<
          RepairManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      repairManagementDnsZoneBindingOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .repairManagementDnsZoneBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to createVmwareEngineNetwork. */
  public UnaryCallSettings<CreateVmwareEngineNetworkRequest, Operation>
      createVmwareEngineNetworkSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createVmwareEngineNetworkSettings();
  }

  /** Returns the object with the settings used for calls to createVmwareEngineNetwork. */
  public OperationCallSettings<
          CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .createVmwareEngineNetworkOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateVmwareEngineNetwork. */
  public UnaryCallSettings<UpdateVmwareEngineNetworkRequest, Operation>
      updateVmwareEngineNetworkSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updateVmwareEngineNetworkSettings();
  }

  /** Returns the object with the settings used for calls to updateVmwareEngineNetwork. */
  public OperationCallSettings<
          UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .updateVmwareEngineNetworkOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteVmwareEngineNetwork. */
  public UnaryCallSettings<DeleteVmwareEngineNetworkRequest, Operation>
      deleteVmwareEngineNetworkSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deleteVmwareEngineNetworkSettings();
  }

  /** Returns the object with the settings used for calls to deleteVmwareEngineNetwork. */
  public OperationCallSettings<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
      deleteVmwareEngineNetworkOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .deleteVmwareEngineNetworkOperationSettings();
  }

  /** Returns the object with the settings used for calls to getVmwareEngineNetwork. */
  public UnaryCallSettings<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
      getVmwareEngineNetworkSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getVmwareEngineNetworkSettings();
  }

  /** Returns the object with the settings used for calls to listVmwareEngineNetworks. */
  public PagedCallSettings<
          ListVmwareEngineNetworksRequest,
          ListVmwareEngineNetworksResponse,
          ListVmwareEngineNetworksPagedResponse>
      listVmwareEngineNetworksSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listVmwareEngineNetworksSettings();
  }

  /** Returns the object with the settings used for calls to createPrivateConnection. */
  public UnaryCallSettings<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).createPrivateConnectionSettings();
  }

  /** Returns the object with the settings used for calls to createPrivateConnection. */
  public OperationCallSettings<CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .createPrivateConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getPrivateConnection. */
  public UnaryCallSettings<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getPrivateConnectionSettings();
  }

  /** Returns the object with the settings used for calls to listPrivateConnections. */
  public PagedCallSettings<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listPrivateConnectionsSettings();
  }

  /** Returns the object with the settings used for calls to updatePrivateConnection. */
  public UnaryCallSettings<UpdatePrivateConnectionRequest, Operation>
      updatePrivateConnectionSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).updatePrivateConnectionSettings();
  }

  /** Returns the object with the settings used for calls to updatePrivateConnection. */
  public OperationCallSettings<UpdatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      updatePrivateConnectionOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .updatePrivateConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to deletePrivateConnection. */
  public UnaryCallSettings<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).deletePrivateConnectionSettings();
  }

  /** Returns the object with the settings used for calls to deletePrivateConnection. */
  public OperationCallSettings<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .deletePrivateConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to listPrivateConnectionPeeringRoutes. */
  public PagedCallSettings<
          ListPrivateConnectionPeeringRoutesRequest,
          ListPrivateConnectionPeeringRoutesResponse,
          ListPrivateConnectionPeeringRoutesPagedResponse>
      listPrivateConnectionPeeringRoutesSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .listPrivateConnectionPeeringRoutesSettings();
  }

  /** Returns the object with the settings used for calls to grantDnsBindPermission. */
  public UnaryCallSettings<GrantDnsBindPermissionRequest, Operation>
      grantDnsBindPermissionSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).grantDnsBindPermissionSettings();
  }

  /** Returns the object with the settings used for calls to grantDnsBindPermission. */
  public OperationCallSettings<GrantDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      grantDnsBindPermissionOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).grantDnsBindPermissionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDnsBindPermission. */
  public UnaryCallSettings<GetDnsBindPermissionRequest, DnsBindPermission>
      getDnsBindPermissionSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getDnsBindPermissionSettings();
  }

  /** Returns the object with the settings used for calls to revokeDnsBindPermission. */
  public UnaryCallSettings<RevokeDnsBindPermissionRequest, Operation>
      revokeDnsBindPermissionSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).revokeDnsBindPermissionSettings();
  }

  /** Returns the object with the settings used for calls to revokeDnsBindPermission. */
  public OperationCallSettings<RevokeDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      revokeDnsBindPermissionOperationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings())
        .revokeDnsBindPermissionOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((VmwareEngineStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final VmwareEngineSettings create(VmwareEngineStubSettings stub)
      throws IOException {
    return new VmwareEngineSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return VmwareEngineStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return VmwareEngineStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return VmwareEngineStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return VmwareEngineStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return VmwareEngineStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return VmwareEngineStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return VmwareEngineStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VmwareEngineStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected VmwareEngineSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for VmwareEngineSettings. */
  public static class Builder extends ClientSettings.Builder<VmwareEngineSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(VmwareEngineStubSettings.newBuilder(clientContext));
    }

    protected Builder(VmwareEngineSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(VmwareEngineStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(VmwareEngineStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(VmwareEngineStubSettings.newHttpJsonBuilder());
    }

    public VmwareEngineStubSettings.Builder getStubSettingsBuilder() {
      return ((VmwareEngineStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listPrivateClouds. */
    public PagedCallSettings.Builder<
            ListPrivateCloudsRequest, ListPrivateCloudsResponse, ListPrivateCloudsPagedResponse>
        listPrivateCloudsSettings() {
      return getStubSettingsBuilder().listPrivateCloudsSettings();
    }

    /** Returns the builder for the settings used for calls to getPrivateCloud. */
    public UnaryCallSettings.Builder<GetPrivateCloudRequest, PrivateCloud>
        getPrivateCloudSettings() {
      return getStubSettingsBuilder().getPrivateCloudSettings();
    }

    /** Returns the builder for the settings used for calls to createPrivateCloud. */
    public UnaryCallSettings.Builder<CreatePrivateCloudRequest, Operation>
        createPrivateCloudSettings() {
      return getStubSettingsBuilder().createPrivateCloudSettings();
    }

    /** Returns the builder for the settings used for calls to createPrivateCloud. */
    public OperationCallSettings.Builder<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
        createPrivateCloudOperationSettings() {
      return getStubSettingsBuilder().createPrivateCloudOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updatePrivateCloud. */
    public UnaryCallSettings.Builder<UpdatePrivateCloudRequest, Operation>
        updatePrivateCloudSettings() {
      return getStubSettingsBuilder().updatePrivateCloudSettings();
    }

    /** Returns the builder for the settings used for calls to updatePrivateCloud. */
    public OperationCallSettings.Builder<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
        updatePrivateCloudOperationSettings() {
      return getStubSettingsBuilder().updatePrivateCloudOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deletePrivateCloud. */
    public UnaryCallSettings.Builder<DeletePrivateCloudRequest, Operation>
        deletePrivateCloudSettings() {
      return getStubSettingsBuilder().deletePrivateCloudSettings();
    }

    /** Returns the builder for the settings used for calls to deletePrivateCloud. */
    public OperationCallSettings.Builder<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
        deletePrivateCloudOperationSettings() {
      return getStubSettingsBuilder().deletePrivateCloudOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeletePrivateCloud. */
    public UnaryCallSettings.Builder<UndeletePrivateCloudRequest, Operation>
        undeletePrivateCloudSettings() {
      return getStubSettingsBuilder().undeletePrivateCloudSettings();
    }

    /** Returns the builder for the settings used for calls to undeletePrivateCloud. */
    public OperationCallSettings.Builder<
            UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
        undeletePrivateCloudOperationSettings() {
      return getStubSettingsBuilder().undeletePrivateCloudOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listClusters. */
    public PagedCallSettings.Builder<
            ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
        listClustersSettings() {
      return getStubSettingsBuilder().listClustersSettings();
    }

    /** Returns the builder for the settings used for calls to getCluster. */
    public UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings() {
      return getStubSettingsBuilder().getClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings() {
      return getStubSettingsBuilder().createClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public OperationCallSettings.Builder<CreateClusterRequest, Cluster, OperationMetadata>
        createClusterOperationSettings() {
      return getStubSettingsBuilder().createClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings() {
      return getStubSettingsBuilder().updateClusterSettings();
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public OperationCallSettings.Builder<UpdateClusterRequest, Cluster, OperationMetadata>
        updateClusterOperationSettings() {
      return getStubSettingsBuilder().updateClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings() {
      return getStubSettingsBuilder().deleteClusterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public OperationCallSettings.Builder<DeleteClusterRequest, Empty, OperationMetadata>
        deleteClusterOperationSettings() {
      return getStubSettingsBuilder().deleteClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listNodes. */
    public PagedCallSettings.Builder<ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>
        listNodesSettings() {
      return getStubSettingsBuilder().listNodesSettings();
    }

    /** Returns the builder for the settings used for calls to getNode. */
    public UnaryCallSettings.Builder<GetNodeRequest, Node> getNodeSettings() {
      return getStubSettingsBuilder().getNodeSettings();
    }

    /** Returns the builder for the settings used for calls to listExternalAddresses. */
    public PagedCallSettings.Builder<
            ListExternalAddressesRequest,
            ListExternalAddressesResponse,
            ListExternalAddressesPagedResponse>
        listExternalAddressesSettings() {
      return getStubSettingsBuilder().listExternalAddressesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to fetchNetworkPolicyExternalAddresses.
     */
    public PagedCallSettings.Builder<
            FetchNetworkPolicyExternalAddressesRequest,
            FetchNetworkPolicyExternalAddressesResponse,
            FetchNetworkPolicyExternalAddressesPagedResponse>
        fetchNetworkPolicyExternalAddressesSettings() {
      return getStubSettingsBuilder().fetchNetworkPolicyExternalAddressesSettings();
    }

    /** Returns the builder for the settings used for calls to getExternalAddress. */
    public UnaryCallSettings.Builder<GetExternalAddressRequest, ExternalAddress>
        getExternalAddressSettings() {
      return getStubSettingsBuilder().getExternalAddressSettings();
    }

    /** Returns the builder for the settings used for calls to createExternalAddress. */
    public UnaryCallSettings.Builder<CreateExternalAddressRequest, Operation>
        createExternalAddressSettings() {
      return getStubSettingsBuilder().createExternalAddressSettings();
    }

    /** Returns the builder for the settings used for calls to createExternalAddress. */
    public OperationCallSettings.Builder<
            CreateExternalAddressRequest, ExternalAddress, OperationMetadata>
        createExternalAddressOperationSettings() {
      return getStubSettingsBuilder().createExternalAddressOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateExternalAddress. */
    public UnaryCallSettings.Builder<UpdateExternalAddressRequest, Operation>
        updateExternalAddressSettings() {
      return getStubSettingsBuilder().updateExternalAddressSettings();
    }

    /** Returns the builder for the settings used for calls to updateExternalAddress. */
    public OperationCallSettings.Builder<
            UpdateExternalAddressRequest, ExternalAddress, OperationMetadata>
        updateExternalAddressOperationSettings() {
      return getStubSettingsBuilder().updateExternalAddressOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExternalAddress. */
    public UnaryCallSettings.Builder<DeleteExternalAddressRequest, Operation>
        deleteExternalAddressSettings() {
      return getStubSettingsBuilder().deleteExternalAddressSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExternalAddress. */
    public OperationCallSettings.Builder<DeleteExternalAddressRequest, Empty, OperationMetadata>
        deleteExternalAddressOperationSettings() {
      return getStubSettingsBuilder().deleteExternalAddressOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listSubnets. */
    public PagedCallSettings.Builder<
            ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
        listSubnetsSettings() {
      return getStubSettingsBuilder().listSubnetsSettings();
    }

    /** Returns the builder for the settings used for calls to getSubnet. */
    public UnaryCallSettings.Builder<GetSubnetRequest, Subnet> getSubnetSettings() {
      return getStubSettingsBuilder().getSubnetSettings();
    }

    /** Returns the builder for the settings used for calls to updateSubnet. */
    public UnaryCallSettings.Builder<UpdateSubnetRequest, Operation> updateSubnetSettings() {
      return getStubSettingsBuilder().updateSubnetSettings();
    }

    /** Returns the builder for the settings used for calls to updateSubnet. */
    public OperationCallSettings.Builder<UpdateSubnetRequest, Subnet, OperationMetadata>
        updateSubnetOperationSettings() {
      return getStubSettingsBuilder().updateSubnetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listExternalAccessRules. */
    public PagedCallSettings.Builder<
            ListExternalAccessRulesRequest,
            ListExternalAccessRulesResponse,
            ListExternalAccessRulesPagedResponse>
        listExternalAccessRulesSettings() {
      return getStubSettingsBuilder().listExternalAccessRulesSettings();
    }

    /** Returns the builder for the settings used for calls to getExternalAccessRule. */
    public UnaryCallSettings.Builder<GetExternalAccessRuleRequest, ExternalAccessRule>
        getExternalAccessRuleSettings() {
      return getStubSettingsBuilder().getExternalAccessRuleSettings();
    }

    /** Returns the builder for the settings used for calls to createExternalAccessRule. */
    public UnaryCallSettings.Builder<CreateExternalAccessRuleRequest, Operation>
        createExternalAccessRuleSettings() {
      return getStubSettingsBuilder().createExternalAccessRuleSettings();
    }

    /** Returns the builder for the settings used for calls to createExternalAccessRule. */
    public OperationCallSettings.Builder<
            CreateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
        createExternalAccessRuleOperationSettings() {
      return getStubSettingsBuilder().createExternalAccessRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateExternalAccessRule. */
    public UnaryCallSettings.Builder<UpdateExternalAccessRuleRequest, Operation>
        updateExternalAccessRuleSettings() {
      return getStubSettingsBuilder().updateExternalAccessRuleSettings();
    }

    /** Returns the builder for the settings used for calls to updateExternalAccessRule. */
    public OperationCallSettings.Builder<
            UpdateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
        updateExternalAccessRuleOperationSettings() {
      return getStubSettingsBuilder().updateExternalAccessRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExternalAccessRule. */
    public UnaryCallSettings.Builder<DeleteExternalAccessRuleRequest, Operation>
        deleteExternalAccessRuleSettings() {
      return getStubSettingsBuilder().deleteExternalAccessRuleSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExternalAccessRule. */
    public OperationCallSettings.Builder<DeleteExternalAccessRuleRequest, Empty, OperationMetadata>
        deleteExternalAccessRuleOperationSettings() {
      return getStubSettingsBuilder().deleteExternalAccessRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLoggingServers. */
    public PagedCallSettings.Builder<
            ListLoggingServersRequest, ListLoggingServersResponse, ListLoggingServersPagedResponse>
        listLoggingServersSettings() {
      return getStubSettingsBuilder().listLoggingServersSettings();
    }

    /** Returns the builder for the settings used for calls to getLoggingServer. */
    public UnaryCallSettings.Builder<GetLoggingServerRequest, LoggingServer>
        getLoggingServerSettings() {
      return getStubSettingsBuilder().getLoggingServerSettings();
    }

    /** Returns the builder for the settings used for calls to createLoggingServer. */
    public UnaryCallSettings.Builder<CreateLoggingServerRequest, Operation>
        createLoggingServerSettings() {
      return getStubSettingsBuilder().createLoggingServerSettings();
    }

    /** Returns the builder for the settings used for calls to createLoggingServer. */
    public OperationCallSettings.Builder<
            CreateLoggingServerRequest, LoggingServer, OperationMetadata>
        createLoggingServerOperationSettings() {
      return getStubSettingsBuilder().createLoggingServerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateLoggingServer. */
    public UnaryCallSettings.Builder<UpdateLoggingServerRequest, Operation>
        updateLoggingServerSettings() {
      return getStubSettingsBuilder().updateLoggingServerSettings();
    }

    /** Returns the builder for the settings used for calls to updateLoggingServer. */
    public OperationCallSettings.Builder<
            UpdateLoggingServerRequest, LoggingServer, OperationMetadata>
        updateLoggingServerOperationSettings() {
      return getStubSettingsBuilder().updateLoggingServerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLoggingServer. */
    public UnaryCallSettings.Builder<DeleteLoggingServerRequest, Operation>
        deleteLoggingServerSettings() {
      return getStubSettingsBuilder().deleteLoggingServerSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLoggingServer. */
    public OperationCallSettings.Builder<DeleteLoggingServerRequest, Empty, OperationMetadata>
        deleteLoggingServerOperationSettings() {
      return getStubSettingsBuilder().deleteLoggingServerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listNodeTypes. */
    public PagedCallSettings.Builder<
            ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>
        listNodeTypesSettings() {
      return getStubSettingsBuilder().listNodeTypesSettings();
    }

    /** Returns the builder for the settings used for calls to getNodeType. */
    public UnaryCallSettings.Builder<GetNodeTypeRequest, NodeType> getNodeTypeSettings() {
      return getStubSettingsBuilder().getNodeTypeSettings();
    }

    /** Returns the builder for the settings used for calls to showNsxCredentials. */
    public UnaryCallSettings.Builder<ShowNsxCredentialsRequest, Credentials>
        showNsxCredentialsSettings() {
      return getStubSettingsBuilder().showNsxCredentialsSettings();
    }

    /** Returns the builder for the settings used for calls to showVcenterCredentials. */
    public UnaryCallSettings.Builder<ShowVcenterCredentialsRequest, Credentials>
        showVcenterCredentialsSettings() {
      return getStubSettingsBuilder().showVcenterCredentialsSettings();
    }

    /** Returns the builder for the settings used for calls to resetNsxCredentials. */
    public UnaryCallSettings.Builder<ResetNsxCredentialsRequest, Operation>
        resetNsxCredentialsSettings() {
      return getStubSettingsBuilder().resetNsxCredentialsSettings();
    }

    /** Returns the builder for the settings used for calls to resetNsxCredentials. */
    public OperationCallSettings.Builder<
            ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
        resetNsxCredentialsOperationSettings() {
      return getStubSettingsBuilder().resetNsxCredentialsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resetVcenterCredentials. */
    public UnaryCallSettings.Builder<ResetVcenterCredentialsRequest, Operation>
        resetVcenterCredentialsSettings() {
      return getStubSettingsBuilder().resetVcenterCredentialsSettings();
    }

    /** Returns the builder for the settings used for calls to resetVcenterCredentials. */
    public OperationCallSettings.Builder<
            ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
        resetVcenterCredentialsOperationSettings() {
      return getStubSettingsBuilder().resetVcenterCredentialsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDnsForwarding. */
    public UnaryCallSettings.Builder<GetDnsForwardingRequest, DnsForwarding>
        getDnsForwardingSettings() {
      return getStubSettingsBuilder().getDnsForwardingSettings();
    }

    /** Returns the builder for the settings used for calls to updateDnsForwarding. */
    public UnaryCallSettings.Builder<UpdateDnsForwardingRequest, Operation>
        updateDnsForwardingSettings() {
      return getStubSettingsBuilder().updateDnsForwardingSettings();
    }

    /** Returns the builder for the settings used for calls to updateDnsForwarding. */
    public OperationCallSettings.Builder<
            UpdateDnsForwardingRequest, DnsForwarding, OperationMetadata>
        updateDnsForwardingOperationSettings() {
      return getStubSettingsBuilder().updateDnsForwardingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getNetworkPeering. */
    public UnaryCallSettings.Builder<GetNetworkPeeringRequest, NetworkPeering>
        getNetworkPeeringSettings() {
      return getStubSettingsBuilder().getNetworkPeeringSettings();
    }

    /** Returns the builder for the settings used for calls to listNetworkPeerings. */
    public PagedCallSettings.Builder<
            ListNetworkPeeringsRequest,
            ListNetworkPeeringsResponse,
            ListNetworkPeeringsPagedResponse>
        listNetworkPeeringsSettings() {
      return getStubSettingsBuilder().listNetworkPeeringsSettings();
    }

    /** Returns the builder for the settings used for calls to createNetworkPeering. */
    public UnaryCallSettings.Builder<CreateNetworkPeeringRequest, Operation>
        createNetworkPeeringSettings() {
      return getStubSettingsBuilder().createNetworkPeeringSettings();
    }

    /** Returns the builder for the settings used for calls to createNetworkPeering. */
    public OperationCallSettings.Builder<
            CreateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
        createNetworkPeeringOperationSettings() {
      return getStubSettingsBuilder().createNetworkPeeringOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNetworkPeering. */
    public UnaryCallSettings.Builder<DeleteNetworkPeeringRequest, Operation>
        deleteNetworkPeeringSettings() {
      return getStubSettingsBuilder().deleteNetworkPeeringSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNetworkPeering. */
    public OperationCallSettings.Builder<DeleteNetworkPeeringRequest, Empty, OperationMetadata>
        deleteNetworkPeeringOperationSettings() {
      return getStubSettingsBuilder().deleteNetworkPeeringOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateNetworkPeering. */
    public UnaryCallSettings.Builder<UpdateNetworkPeeringRequest, Operation>
        updateNetworkPeeringSettings() {
      return getStubSettingsBuilder().updateNetworkPeeringSettings();
    }

    /** Returns the builder for the settings used for calls to updateNetworkPeering. */
    public OperationCallSettings.Builder<
            UpdateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
        updateNetworkPeeringOperationSettings() {
      return getStubSettingsBuilder().updateNetworkPeeringOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listPeeringRoutes. */
    public PagedCallSettings.Builder<
            ListPeeringRoutesRequest, ListPeeringRoutesResponse, ListPeeringRoutesPagedResponse>
        listPeeringRoutesSettings() {
      return getStubSettingsBuilder().listPeeringRoutesSettings();
    }

    /** Returns the builder for the settings used for calls to createHcxActivationKey. */
    public UnaryCallSettings.Builder<CreateHcxActivationKeyRequest, Operation>
        createHcxActivationKeySettings() {
      return getStubSettingsBuilder().createHcxActivationKeySettings();
    }

    /** Returns the builder for the settings used for calls to createHcxActivationKey. */
    public OperationCallSettings.Builder<
            CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
        createHcxActivationKeyOperationSettings() {
      return getStubSettingsBuilder().createHcxActivationKeyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listHcxActivationKeys. */
    public PagedCallSettings.Builder<
            ListHcxActivationKeysRequest,
            ListHcxActivationKeysResponse,
            ListHcxActivationKeysPagedResponse>
        listHcxActivationKeysSettings() {
      return getStubSettingsBuilder().listHcxActivationKeysSettings();
    }

    /** Returns the builder for the settings used for calls to getHcxActivationKey. */
    public UnaryCallSettings.Builder<GetHcxActivationKeyRequest, HcxActivationKey>
        getHcxActivationKeySettings() {
      return getStubSettingsBuilder().getHcxActivationKeySettings();
    }

    /** Returns the builder for the settings used for calls to getNetworkPolicy. */
    public UnaryCallSettings.Builder<GetNetworkPolicyRequest, NetworkPolicy>
        getNetworkPolicySettings() {
      return getStubSettingsBuilder().getNetworkPolicySettings();
    }

    /** Returns the builder for the settings used for calls to listNetworkPolicies. */
    public PagedCallSettings.Builder<
            ListNetworkPoliciesRequest,
            ListNetworkPoliciesResponse,
            ListNetworkPoliciesPagedResponse>
        listNetworkPoliciesSettings() {
      return getStubSettingsBuilder().listNetworkPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to createNetworkPolicy. */
    public UnaryCallSettings.Builder<CreateNetworkPolicyRequest, Operation>
        createNetworkPolicySettings() {
      return getStubSettingsBuilder().createNetworkPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createNetworkPolicy. */
    public OperationCallSettings.Builder<
            CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
        createNetworkPolicyOperationSettings() {
      return getStubSettingsBuilder().createNetworkPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateNetworkPolicy. */
    public UnaryCallSettings.Builder<UpdateNetworkPolicyRequest, Operation>
        updateNetworkPolicySettings() {
      return getStubSettingsBuilder().updateNetworkPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateNetworkPolicy. */
    public OperationCallSettings.Builder<
            UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
        updateNetworkPolicyOperationSettings() {
      return getStubSettingsBuilder().updateNetworkPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNetworkPolicy. */
    public UnaryCallSettings.Builder<DeleteNetworkPolicyRequest, Operation>
        deleteNetworkPolicySettings() {
      return getStubSettingsBuilder().deleteNetworkPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteNetworkPolicy. */
    public OperationCallSettings.Builder<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
        deleteNetworkPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteNetworkPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listManagementDnsZoneBindings. */
    public PagedCallSettings.Builder<
            ListManagementDnsZoneBindingsRequest,
            ListManagementDnsZoneBindingsResponse,
            ListManagementDnsZoneBindingsPagedResponse>
        listManagementDnsZoneBindingsSettings() {
      return getStubSettingsBuilder().listManagementDnsZoneBindingsSettings();
    }

    /** Returns the builder for the settings used for calls to getManagementDnsZoneBinding. */
    public UnaryCallSettings.Builder<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
        getManagementDnsZoneBindingSettings() {
      return getStubSettingsBuilder().getManagementDnsZoneBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createManagementDnsZoneBinding. */
    public UnaryCallSettings.Builder<CreateManagementDnsZoneBindingRequest, Operation>
        createManagementDnsZoneBindingSettings() {
      return getStubSettingsBuilder().createManagementDnsZoneBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createManagementDnsZoneBinding. */
    public OperationCallSettings.Builder<
            CreateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
        createManagementDnsZoneBindingOperationSettings() {
      return getStubSettingsBuilder().createManagementDnsZoneBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateManagementDnsZoneBinding. */
    public UnaryCallSettings.Builder<UpdateManagementDnsZoneBindingRequest, Operation>
        updateManagementDnsZoneBindingSettings() {
      return getStubSettingsBuilder().updateManagementDnsZoneBindingSettings();
    }

    /** Returns the builder for the settings used for calls to updateManagementDnsZoneBinding. */
    public OperationCallSettings.Builder<
            UpdateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
        updateManagementDnsZoneBindingOperationSettings() {
      return getStubSettingsBuilder().updateManagementDnsZoneBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteManagementDnsZoneBinding. */
    public UnaryCallSettings.Builder<DeleteManagementDnsZoneBindingRequest, Operation>
        deleteManagementDnsZoneBindingSettings() {
      return getStubSettingsBuilder().deleteManagementDnsZoneBindingSettings();
    }

    /** Returns the builder for the settings used for calls to deleteManagementDnsZoneBinding. */
    public OperationCallSettings.Builder<
            DeleteManagementDnsZoneBindingRequest, Empty, OperationMetadata>
        deleteManagementDnsZoneBindingOperationSettings() {
      return getStubSettingsBuilder().deleteManagementDnsZoneBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to repairManagementDnsZoneBinding. */
    public UnaryCallSettings.Builder<RepairManagementDnsZoneBindingRequest, Operation>
        repairManagementDnsZoneBindingSettings() {
      return getStubSettingsBuilder().repairManagementDnsZoneBindingSettings();
    }

    /** Returns the builder for the settings used for calls to repairManagementDnsZoneBinding. */
    public OperationCallSettings.Builder<
            RepairManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
        repairManagementDnsZoneBindingOperationSettings() {
      return getStubSettingsBuilder().repairManagementDnsZoneBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<CreateVmwareEngineNetworkRequest, Operation>
        createVmwareEngineNetworkSettings() {
      return getStubSettingsBuilder().createVmwareEngineNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to createVmwareEngineNetwork. */
    public OperationCallSettings.Builder<
            CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
        createVmwareEngineNetworkOperationSettings() {
      return getStubSettingsBuilder().createVmwareEngineNetworkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<UpdateVmwareEngineNetworkRequest, Operation>
        updateVmwareEngineNetworkSettings() {
      return getStubSettingsBuilder().updateVmwareEngineNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to updateVmwareEngineNetwork. */
    public OperationCallSettings.Builder<
            UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
        updateVmwareEngineNetworkOperationSettings() {
      return getStubSettingsBuilder().updateVmwareEngineNetworkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<DeleteVmwareEngineNetworkRequest, Operation>
        deleteVmwareEngineNetworkSettings() {
      return getStubSettingsBuilder().deleteVmwareEngineNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVmwareEngineNetwork. */
    public OperationCallSettings.Builder<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
        deleteVmwareEngineNetworkOperationSettings() {
      return getStubSettingsBuilder().deleteVmwareEngineNetworkOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
        getVmwareEngineNetworkSettings() {
      return getStubSettingsBuilder().getVmwareEngineNetworkSettings();
    }

    /** Returns the builder for the settings used for calls to listVmwareEngineNetworks. */
    public PagedCallSettings.Builder<
            ListVmwareEngineNetworksRequest,
            ListVmwareEngineNetworksResponse,
            ListVmwareEngineNetworksPagedResponse>
        listVmwareEngineNetworksSettings() {
      return getStubSettingsBuilder().listVmwareEngineNetworksSettings();
    }

    /** Returns the builder for the settings used for calls to createPrivateConnection. */
    public UnaryCallSettings.Builder<CreatePrivateConnectionRequest, Operation>
        createPrivateConnectionSettings() {
      return getStubSettingsBuilder().createPrivateConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to createPrivateConnection. */
    public OperationCallSettings.Builder<
            CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
        createPrivateConnectionOperationSettings() {
      return getStubSettingsBuilder().createPrivateConnectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getPrivateConnection. */
    public UnaryCallSettings.Builder<GetPrivateConnectionRequest, PrivateConnection>
        getPrivateConnectionSettings() {
      return getStubSettingsBuilder().getPrivateConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to listPrivateConnections. */
    public PagedCallSettings.Builder<
            ListPrivateConnectionsRequest,
            ListPrivateConnectionsResponse,
            ListPrivateConnectionsPagedResponse>
        listPrivateConnectionsSettings() {
      return getStubSettingsBuilder().listPrivateConnectionsSettings();
    }

    /** Returns the builder for the settings used for calls to updatePrivateConnection. */
    public UnaryCallSettings.Builder<UpdatePrivateConnectionRequest, Operation>
        updatePrivateConnectionSettings() {
      return getStubSettingsBuilder().updatePrivateConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to updatePrivateConnection. */
    public OperationCallSettings.Builder<
            UpdatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
        updatePrivateConnectionOperationSettings() {
      return getStubSettingsBuilder().updatePrivateConnectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deletePrivateConnection. */
    public UnaryCallSettings.Builder<DeletePrivateConnectionRequest, Operation>
        deletePrivateConnectionSettings() {
      return getStubSettingsBuilder().deletePrivateConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to deletePrivateConnection. */
    public OperationCallSettings.Builder<DeletePrivateConnectionRequest, Empty, OperationMetadata>
        deletePrivateConnectionOperationSettings() {
      return getStubSettingsBuilder().deletePrivateConnectionOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to listPrivateConnectionPeeringRoutes.
     */
    public PagedCallSettings.Builder<
            ListPrivateConnectionPeeringRoutesRequest,
            ListPrivateConnectionPeeringRoutesResponse,
            ListPrivateConnectionPeeringRoutesPagedResponse>
        listPrivateConnectionPeeringRoutesSettings() {
      return getStubSettingsBuilder().listPrivateConnectionPeeringRoutesSettings();
    }

    /** Returns the builder for the settings used for calls to grantDnsBindPermission. */
    public UnaryCallSettings.Builder<GrantDnsBindPermissionRequest, Operation>
        grantDnsBindPermissionSettings() {
      return getStubSettingsBuilder().grantDnsBindPermissionSettings();
    }

    /** Returns the builder for the settings used for calls to grantDnsBindPermission. */
    public OperationCallSettings.Builder<
            GrantDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
        grantDnsBindPermissionOperationSettings() {
      return getStubSettingsBuilder().grantDnsBindPermissionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDnsBindPermission. */
    public UnaryCallSettings.Builder<GetDnsBindPermissionRequest, DnsBindPermission>
        getDnsBindPermissionSettings() {
      return getStubSettingsBuilder().getDnsBindPermissionSettings();
    }

    /** Returns the builder for the settings used for calls to revokeDnsBindPermission. */
    public UnaryCallSettings.Builder<RevokeDnsBindPermissionRequest, Operation>
        revokeDnsBindPermissionSettings() {
      return getStubSettingsBuilder().revokeDnsBindPermissionSettings();
    }

    /** Returns the builder for the settings used for calls to revokeDnsBindPermission. */
    public OperationCallSettings.Builder<
            RevokeDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
        revokeDnsBindPermissionOperationSettings() {
      return getStubSettingsBuilder().revokeDnsBindPermissionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public VmwareEngineSettings build() throws IOException {
      return new VmwareEngineSettings(this);
    }
  }
}
