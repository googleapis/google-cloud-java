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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
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
import com.google.cloud.vmwareengine.v1.PeeringRoute;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
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
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VmwareEngineStub}.
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
 * VmwareEngineStubSettings.Builder vmwareEngineSettingsBuilder =
 *     VmwareEngineStubSettings.newBuilder();
 * vmwareEngineSettingsBuilder
 *     .getPrivateCloudSettings()
 *     .setRetrySettings(
 *         vmwareEngineSettingsBuilder
 *             .getPrivateCloudSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VmwareEngineStubSettings vmwareEngineSettings = vmwareEngineSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class VmwareEngineStubSettings extends StubSettings<VmwareEngineStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListPrivateCloudsRequest, ListPrivateCloudsResponse, ListPrivateCloudsPagedResponse>
      listPrivateCloudsSettings;
  private final UnaryCallSettings<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudSettings;
  private final UnaryCallSettings<CreatePrivateCloudRequest, Operation> createPrivateCloudSettings;
  private final OperationCallSettings<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      createPrivateCloudOperationSettings;
  private final UnaryCallSettings<UpdatePrivateCloudRequest, Operation> updatePrivateCloudSettings;
  private final OperationCallSettings<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      updatePrivateCloudOperationSettings;
  private final UnaryCallSettings<DeletePrivateCloudRequest, Operation> deletePrivateCloudSettings;
  private final OperationCallSettings<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      deletePrivateCloudOperationSettings;
  private final UnaryCallSettings<UndeletePrivateCloudRequest, Operation>
      undeletePrivateCloudSettings;
  private final OperationCallSettings<UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      undeletePrivateCloudOperationSettings;
  private final PagedCallSettings<
          ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings;
  private final UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings;
  private final UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings;
  private final OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings;
  private final UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings;
  private final OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings;
  private final UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings;
  private final OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings;
  private final PagedCallSettings<ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>
      listNodesSettings;
  private final UnaryCallSettings<GetNodeRequest, Node> getNodeSettings;
  private final PagedCallSettings<
          ListExternalAddressesRequest,
          ListExternalAddressesResponse,
          ListExternalAddressesPagedResponse>
      listExternalAddressesSettings;
  private final PagedCallSettings<
          FetchNetworkPolicyExternalAddressesRequest,
          FetchNetworkPolicyExternalAddressesResponse,
          FetchNetworkPolicyExternalAddressesPagedResponse>
      fetchNetworkPolicyExternalAddressesSettings;
  private final UnaryCallSettings<GetExternalAddressRequest, ExternalAddress>
      getExternalAddressSettings;
  private final UnaryCallSettings<CreateExternalAddressRequest, Operation>
      createExternalAddressSettings;
  private final OperationCallSettings<
          CreateExternalAddressRequest, ExternalAddress, OperationMetadata>
      createExternalAddressOperationSettings;
  private final UnaryCallSettings<UpdateExternalAddressRequest, Operation>
      updateExternalAddressSettings;
  private final OperationCallSettings<
          UpdateExternalAddressRequest, ExternalAddress, OperationMetadata>
      updateExternalAddressOperationSettings;
  private final UnaryCallSettings<DeleteExternalAddressRequest, Operation>
      deleteExternalAddressSettings;
  private final OperationCallSettings<DeleteExternalAddressRequest, Empty, OperationMetadata>
      deleteExternalAddressOperationSettings;
  private final PagedCallSettings<ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
      listSubnetsSettings;
  private final UnaryCallSettings<GetSubnetRequest, Subnet> getSubnetSettings;
  private final UnaryCallSettings<UpdateSubnetRequest, Operation> updateSubnetSettings;
  private final OperationCallSettings<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationSettings;
  private final PagedCallSettings<
          ListExternalAccessRulesRequest,
          ListExternalAccessRulesResponse,
          ListExternalAccessRulesPagedResponse>
      listExternalAccessRulesSettings;
  private final UnaryCallSettings<GetExternalAccessRuleRequest, ExternalAccessRule>
      getExternalAccessRuleSettings;
  private final UnaryCallSettings<CreateExternalAccessRuleRequest, Operation>
      createExternalAccessRuleSettings;
  private final OperationCallSettings<
          CreateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      createExternalAccessRuleOperationSettings;
  private final UnaryCallSettings<UpdateExternalAccessRuleRequest, Operation>
      updateExternalAccessRuleSettings;
  private final OperationCallSettings<
          UpdateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      updateExternalAccessRuleOperationSettings;
  private final UnaryCallSettings<DeleteExternalAccessRuleRequest, Operation>
      deleteExternalAccessRuleSettings;
  private final OperationCallSettings<DeleteExternalAccessRuleRequest, Empty, OperationMetadata>
      deleteExternalAccessRuleOperationSettings;
  private final PagedCallSettings<
          ListLoggingServersRequest, ListLoggingServersResponse, ListLoggingServersPagedResponse>
      listLoggingServersSettings;
  private final UnaryCallSettings<GetLoggingServerRequest, LoggingServer> getLoggingServerSettings;
  private final UnaryCallSettings<CreateLoggingServerRequest, Operation>
      createLoggingServerSettings;
  private final OperationCallSettings<CreateLoggingServerRequest, LoggingServer, OperationMetadata>
      createLoggingServerOperationSettings;
  private final UnaryCallSettings<UpdateLoggingServerRequest, Operation>
      updateLoggingServerSettings;
  private final OperationCallSettings<UpdateLoggingServerRequest, LoggingServer, OperationMetadata>
      updateLoggingServerOperationSettings;
  private final UnaryCallSettings<DeleteLoggingServerRequest, Operation>
      deleteLoggingServerSettings;
  private final OperationCallSettings<DeleteLoggingServerRequest, Empty, OperationMetadata>
      deleteLoggingServerOperationSettings;
  private final PagedCallSettings<
          ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>
      listNodeTypesSettings;
  private final UnaryCallSettings<GetNodeTypeRequest, NodeType> getNodeTypeSettings;
  private final UnaryCallSettings<ShowNsxCredentialsRequest, Credentials>
      showNsxCredentialsSettings;
  private final UnaryCallSettings<ShowVcenterCredentialsRequest, Credentials>
      showVcenterCredentialsSettings;
  private final UnaryCallSettings<ResetNsxCredentialsRequest, Operation>
      resetNsxCredentialsSettings;
  private final OperationCallSettings<ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
      resetNsxCredentialsOperationSettings;
  private final UnaryCallSettings<ResetVcenterCredentialsRequest, Operation>
      resetVcenterCredentialsSettings;
  private final OperationCallSettings<
          ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
      resetVcenterCredentialsOperationSettings;
  private final UnaryCallSettings<GetDnsForwardingRequest, DnsForwarding> getDnsForwardingSettings;
  private final UnaryCallSettings<UpdateDnsForwardingRequest, Operation>
      updateDnsForwardingSettings;
  private final OperationCallSettings<UpdateDnsForwardingRequest, DnsForwarding, OperationMetadata>
      updateDnsForwardingOperationSettings;
  private final UnaryCallSettings<GetNetworkPeeringRequest, NetworkPeering>
      getNetworkPeeringSettings;
  private final PagedCallSettings<
          ListNetworkPeeringsRequest, ListNetworkPeeringsResponse, ListNetworkPeeringsPagedResponse>
      listNetworkPeeringsSettings;
  private final UnaryCallSettings<CreateNetworkPeeringRequest, Operation>
      createNetworkPeeringSettings;
  private final OperationCallSettings<
          CreateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      createNetworkPeeringOperationSettings;
  private final UnaryCallSettings<DeleteNetworkPeeringRequest, Operation>
      deleteNetworkPeeringSettings;
  private final OperationCallSettings<DeleteNetworkPeeringRequest, Empty, OperationMetadata>
      deleteNetworkPeeringOperationSettings;
  private final UnaryCallSettings<UpdateNetworkPeeringRequest, Operation>
      updateNetworkPeeringSettings;
  private final OperationCallSettings<
          UpdateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      updateNetworkPeeringOperationSettings;
  private final PagedCallSettings<
          ListPeeringRoutesRequest, ListPeeringRoutesResponse, ListPeeringRoutesPagedResponse>
      listPeeringRoutesSettings;
  private final UnaryCallSettings<CreateHcxActivationKeyRequest, Operation>
      createHcxActivationKeySettings;
  private final OperationCallSettings<
          CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
      createHcxActivationKeyOperationSettings;
  private final PagedCallSettings<
          ListHcxActivationKeysRequest,
          ListHcxActivationKeysResponse,
          ListHcxActivationKeysPagedResponse>
      listHcxActivationKeysSettings;
  private final UnaryCallSettings<GetHcxActivationKeyRequest, HcxActivationKey>
      getHcxActivationKeySettings;
  private final UnaryCallSettings<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicySettings;
  private final PagedCallSettings<
          ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, ListNetworkPoliciesPagedResponse>
      listNetworkPoliciesSettings;
  private final UnaryCallSettings<CreateNetworkPolicyRequest, Operation>
      createNetworkPolicySettings;
  private final OperationCallSettings<CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      createNetworkPolicyOperationSettings;
  private final UnaryCallSettings<UpdateNetworkPolicyRequest, Operation>
      updateNetworkPolicySettings;
  private final OperationCallSettings<UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      updateNetworkPolicyOperationSettings;
  private final UnaryCallSettings<DeleteNetworkPolicyRequest, Operation>
      deleteNetworkPolicySettings;
  private final OperationCallSettings<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
      deleteNetworkPolicyOperationSettings;
  private final PagedCallSettings<
          ListManagementDnsZoneBindingsRequest,
          ListManagementDnsZoneBindingsResponse,
          ListManagementDnsZoneBindingsPagedResponse>
      listManagementDnsZoneBindingsSettings;
  private final UnaryCallSettings<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
      getManagementDnsZoneBindingSettings;
  private final UnaryCallSettings<CreateManagementDnsZoneBindingRequest, Operation>
      createManagementDnsZoneBindingSettings;
  private final OperationCallSettings<
          CreateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      createManagementDnsZoneBindingOperationSettings;
  private final UnaryCallSettings<UpdateManagementDnsZoneBindingRequest, Operation>
      updateManagementDnsZoneBindingSettings;
  private final OperationCallSettings<
          UpdateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      updateManagementDnsZoneBindingOperationSettings;
  private final UnaryCallSettings<DeleteManagementDnsZoneBindingRequest, Operation>
      deleteManagementDnsZoneBindingSettings;
  private final OperationCallSettings<
          DeleteManagementDnsZoneBindingRequest, Empty, OperationMetadata>
      deleteManagementDnsZoneBindingOperationSettings;
  private final UnaryCallSettings<RepairManagementDnsZoneBindingRequest, Operation>
      repairManagementDnsZoneBindingSettings;
  private final OperationCallSettings<
          RepairManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      repairManagementDnsZoneBindingOperationSettings;
  private final UnaryCallSettings<CreateVmwareEngineNetworkRequest, Operation>
      createVmwareEngineNetworkSettings;
  private final OperationCallSettings<
          CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkOperationSettings;
  private final UnaryCallSettings<UpdateVmwareEngineNetworkRequest, Operation>
      updateVmwareEngineNetworkSettings;
  private final OperationCallSettings<
          UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkOperationSettings;
  private final UnaryCallSettings<DeleteVmwareEngineNetworkRequest, Operation>
      deleteVmwareEngineNetworkSettings;
  private final OperationCallSettings<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
      deleteVmwareEngineNetworkOperationSettings;
  private final UnaryCallSettings<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
      getVmwareEngineNetworkSettings;
  private final PagedCallSettings<
          ListVmwareEngineNetworksRequest,
          ListVmwareEngineNetworksResponse,
          ListVmwareEngineNetworksPagedResponse>
      listVmwareEngineNetworksSettings;
  private final UnaryCallSettings<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionSettings;
  private final OperationCallSettings<
          CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationSettings;
  private final UnaryCallSettings<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionSettings;
  private final PagedCallSettings<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsSettings;
  private final UnaryCallSettings<UpdatePrivateConnectionRequest, Operation>
      updatePrivateConnectionSettings;
  private final OperationCallSettings<
          UpdatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      updatePrivateConnectionOperationSettings;
  private final UnaryCallSettings<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionSettings;
  private final OperationCallSettings<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationSettings;
  private final PagedCallSettings<
          ListPrivateConnectionPeeringRoutesRequest,
          ListPrivateConnectionPeeringRoutesResponse,
          ListPrivateConnectionPeeringRoutesPagedResponse>
      listPrivateConnectionPeeringRoutesSettings;
  private final UnaryCallSettings<GrantDnsBindPermissionRequest, Operation>
      grantDnsBindPermissionSettings;
  private final OperationCallSettings<
          GrantDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      grantDnsBindPermissionOperationSettings;
  private final UnaryCallSettings<GetDnsBindPermissionRequest, DnsBindPermission>
      getDnsBindPermissionSettings;
  private final UnaryCallSettings<RevokeDnsBindPermissionRequest, Operation>
      revokeDnsBindPermissionSettings;
  private final OperationCallSettings<
          RevokeDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      revokeDnsBindPermissionOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListPrivateCloudsRequest, ListPrivateCloudsResponse, PrivateCloud>
      LIST_PRIVATE_CLOUDS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPrivateCloudsRequest, ListPrivateCloudsResponse, PrivateCloud>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPrivateCloudsRequest injectToken(
                ListPrivateCloudsRequest payload, String token) {
              return ListPrivateCloudsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPrivateCloudsRequest injectPageSize(
                ListPrivateCloudsRequest payload, int pageSize) {
              return ListPrivateCloudsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPrivateCloudsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPrivateCloudsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PrivateCloud> extractResources(ListPrivateCloudsResponse payload) {
              return payload.getPrivateCloudsList() == null
                  ? ImmutableList.<PrivateCloud>of()
                  : payload.getPrivateCloudsList();
            }
          };

  private static final PagedListDescriptor<ListClustersRequest, ListClustersResponse, Cluster>
      LIST_CLUSTERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListClustersRequest, ListClustersResponse, Cluster>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListClustersRequest injectToken(ListClustersRequest payload, String token) {
              return ListClustersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListClustersRequest injectPageSize(ListClustersRequest payload, int pageSize) {
              return ListClustersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListClustersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListClustersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Cluster> extractResources(ListClustersResponse payload) {
              return payload.getClustersList() == null
                  ? ImmutableList.<Cluster>of()
                  : payload.getClustersList();
            }
          };

  private static final PagedListDescriptor<ListNodesRequest, ListNodesResponse, Node>
      LIST_NODES_PAGE_STR_DESC =
          new PagedListDescriptor<ListNodesRequest, ListNodesResponse, Node>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNodesRequest injectToken(ListNodesRequest payload, String token) {
              return ListNodesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNodesRequest injectPageSize(ListNodesRequest payload, int pageSize) {
              return ListNodesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNodesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNodesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Node> extractResources(ListNodesResponse payload) {
              return payload.getNodesList() == null
                  ? ImmutableList.<Node>of()
                  : payload.getNodesList();
            }
          };

  private static final PagedListDescriptor<
          ListExternalAddressesRequest, ListExternalAddressesResponse, ExternalAddress>
      LIST_EXTERNAL_ADDRESSES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListExternalAddressesRequest, ListExternalAddressesResponse, ExternalAddress>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExternalAddressesRequest injectToken(
                ListExternalAddressesRequest payload, String token) {
              return ListExternalAddressesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListExternalAddressesRequest injectPageSize(
                ListExternalAddressesRequest payload, int pageSize) {
              return ListExternalAddressesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListExternalAddressesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExternalAddressesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ExternalAddress> extractResources(
                ListExternalAddressesResponse payload) {
              return payload.getExternalAddressesList() == null
                  ? ImmutableList.<ExternalAddress>of()
                  : payload.getExternalAddressesList();
            }
          };

  private static final PagedListDescriptor<
          FetchNetworkPolicyExternalAddressesRequest,
          FetchNetworkPolicyExternalAddressesResponse,
          ExternalAddress>
      FETCH_NETWORK_POLICY_EXTERNAL_ADDRESSES_PAGE_STR_DESC =
          new PagedListDescriptor<
              FetchNetworkPolicyExternalAddressesRequest,
              FetchNetworkPolicyExternalAddressesResponse,
              ExternalAddress>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchNetworkPolicyExternalAddressesRequest injectToken(
                FetchNetworkPolicyExternalAddressesRequest payload, String token) {
              return FetchNetworkPolicyExternalAddressesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public FetchNetworkPolicyExternalAddressesRequest injectPageSize(
                FetchNetworkPolicyExternalAddressesRequest payload, int pageSize) {
              return FetchNetworkPolicyExternalAddressesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(FetchNetworkPolicyExternalAddressesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchNetworkPolicyExternalAddressesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ExternalAddress> extractResources(
                FetchNetworkPolicyExternalAddressesResponse payload) {
              return payload.getExternalAddressesList() == null
                  ? ImmutableList.<ExternalAddress>of()
                  : payload.getExternalAddressesList();
            }
          };

  private static final PagedListDescriptor<ListSubnetsRequest, ListSubnetsResponse, Subnet>
      LIST_SUBNETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSubnetsRequest, ListSubnetsResponse, Subnet>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSubnetsRequest injectToken(ListSubnetsRequest payload, String token) {
              return ListSubnetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSubnetsRequest injectPageSize(ListSubnetsRequest payload, int pageSize) {
              return ListSubnetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSubnetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSubnetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Subnet> extractResources(ListSubnetsResponse payload) {
              return payload.getSubnetsList() == null
                  ? ImmutableList.<Subnet>of()
                  : payload.getSubnetsList();
            }
          };

  private static final PagedListDescriptor<
          ListExternalAccessRulesRequest, ListExternalAccessRulesResponse, ExternalAccessRule>
      LIST_EXTERNAL_ACCESS_RULES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListExternalAccessRulesRequest,
              ListExternalAccessRulesResponse,
              ExternalAccessRule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExternalAccessRulesRequest injectToken(
                ListExternalAccessRulesRequest payload, String token) {
              return ListExternalAccessRulesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListExternalAccessRulesRequest injectPageSize(
                ListExternalAccessRulesRequest payload, int pageSize) {
              return ListExternalAccessRulesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListExternalAccessRulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExternalAccessRulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ExternalAccessRule> extractResources(
                ListExternalAccessRulesResponse payload) {
              return payload.getExternalAccessRulesList() == null
                  ? ImmutableList.<ExternalAccessRule>of()
                  : payload.getExternalAccessRulesList();
            }
          };

  private static final PagedListDescriptor<
          ListLoggingServersRequest, ListLoggingServersResponse, LoggingServer>
      LIST_LOGGING_SERVERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListLoggingServersRequest, ListLoggingServersResponse, LoggingServer>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLoggingServersRequest injectToken(
                ListLoggingServersRequest payload, String token) {
              return ListLoggingServersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLoggingServersRequest injectPageSize(
                ListLoggingServersRequest payload, int pageSize) {
              return ListLoggingServersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLoggingServersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLoggingServersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LoggingServer> extractResources(ListLoggingServersResponse payload) {
              return payload.getLoggingServersList() == null
                  ? ImmutableList.<LoggingServer>of()
                  : payload.getLoggingServersList();
            }
          };

  private static final PagedListDescriptor<ListNodeTypesRequest, ListNodeTypesResponse, NodeType>
      LIST_NODE_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<ListNodeTypesRequest, ListNodeTypesResponse, NodeType>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNodeTypesRequest injectToken(ListNodeTypesRequest payload, String token) {
              return ListNodeTypesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNodeTypesRequest injectPageSize(ListNodeTypesRequest payload, int pageSize) {
              return ListNodeTypesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNodeTypesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNodeTypesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NodeType> extractResources(ListNodeTypesResponse payload) {
              return payload.getNodeTypesList() == null
                  ? ImmutableList.<NodeType>of()
                  : payload.getNodeTypesList();
            }
          };

  private static final PagedListDescriptor<
          ListNetworkPeeringsRequest, ListNetworkPeeringsResponse, NetworkPeering>
      LIST_NETWORK_PEERINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNetworkPeeringsRequest, ListNetworkPeeringsResponse, NetworkPeering>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNetworkPeeringsRequest injectToken(
                ListNetworkPeeringsRequest payload, String token) {
              return ListNetworkPeeringsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNetworkPeeringsRequest injectPageSize(
                ListNetworkPeeringsRequest payload, int pageSize) {
              return ListNetworkPeeringsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNetworkPeeringsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNetworkPeeringsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NetworkPeering> extractResources(ListNetworkPeeringsResponse payload) {
              return payload.getNetworkPeeringsList() == null
                  ? ImmutableList.<NetworkPeering>of()
                  : payload.getNetworkPeeringsList();
            }
          };

  private static final PagedListDescriptor<
          ListPeeringRoutesRequest, ListPeeringRoutesResponse, PeeringRoute>
      LIST_PEERING_ROUTES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPeeringRoutesRequest, ListPeeringRoutesResponse, PeeringRoute>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPeeringRoutesRequest injectToken(
                ListPeeringRoutesRequest payload, String token) {
              return ListPeeringRoutesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPeeringRoutesRequest injectPageSize(
                ListPeeringRoutesRequest payload, int pageSize) {
              return ListPeeringRoutesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPeeringRoutesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPeeringRoutesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PeeringRoute> extractResources(ListPeeringRoutesResponse payload) {
              return payload.getPeeringRoutesList() == null
                  ? ImmutableList.<PeeringRoute>of()
                  : payload.getPeeringRoutesList();
            }
          };

  private static final PagedListDescriptor<
          ListHcxActivationKeysRequest, ListHcxActivationKeysResponse, HcxActivationKey>
      LIST_HCX_ACTIVATION_KEYS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListHcxActivationKeysRequest, ListHcxActivationKeysResponse, HcxActivationKey>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHcxActivationKeysRequest injectToken(
                ListHcxActivationKeysRequest payload, String token) {
              return ListHcxActivationKeysRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListHcxActivationKeysRequest injectPageSize(
                ListHcxActivationKeysRequest payload, int pageSize) {
              return ListHcxActivationKeysRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListHcxActivationKeysRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListHcxActivationKeysResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<HcxActivationKey> extractResources(
                ListHcxActivationKeysResponse payload) {
              return payload.getHcxActivationKeysList() == null
                  ? ImmutableList.<HcxActivationKey>of()
                  : payload.getHcxActivationKeysList();
            }
          };

  private static final PagedListDescriptor<
          ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, NetworkPolicy>
      LIST_NETWORK_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, NetworkPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNetworkPoliciesRequest injectToken(
                ListNetworkPoliciesRequest payload, String token) {
              return ListNetworkPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNetworkPoliciesRequest injectPageSize(
                ListNetworkPoliciesRequest payload, int pageSize) {
              return ListNetworkPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNetworkPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNetworkPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NetworkPolicy> extractResources(ListNetworkPoliciesResponse payload) {
              return payload.getNetworkPoliciesList() == null
                  ? ImmutableList.<NetworkPolicy>of()
                  : payload.getNetworkPoliciesList();
            }
          };

  private static final PagedListDescriptor<
          ListManagementDnsZoneBindingsRequest,
          ListManagementDnsZoneBindingsResponse,
          ManagementDnsZoneBinding>
      LIST_MANAGEMENT_DNS_ZONE_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListManagementDnsZoneBindingsRequest,
              ListManagementDnsZoneBindingsResponse,
              ManagementDnsZoneBinding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListManagementDnsZoneBindingsRequest injectToken(
                ListManagementDnsZoneBindingsRequest payload, String token) {
              return ListManagementDnsZoneBindingsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListManagementDnsZoneBindingsRequest injectPageSize(
                ListManagementDnsZoneBindingsRequest payload, int pageSize) {
              return ListManagementDnsZoneBindingsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListManagementDnsZoneBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListManagementDnsZoneBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ManagementDnsZoneBinding> extractResources(
                ListManagementDnsZoneBindingsResponse payload) {
              return payload.getManagementDnsZoneBindingsList() == null
                  ? ImmutableList.<ManagementDnsZoneBinding>of()
                  : payload.getManagementDnsZoneBindingsList();
            }
          };

  private static final PagedListDescriptor<
          ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse, VmwareEngineNetwork>
      LIST_VMWARE_ENGINE_NETWORKS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListVmwareEngineNetworksRequest,
              ListVmwareEngineNetworksResponse,
              VmwareEngineNetwork>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVmwareEngineNetworksRequest injectToken(
                ListVmwareEngineNetworksRequest payload, String token) {
              return ListVmwareEngineNetworksRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListVmwareEngineNetworksRequest injectPageSize(
                ListVmwareEngineNetworksRequest payload, int pageSize) {
              return ListVmwareEngineNetworksRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListVmwareEngineNetworksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVmwareEngineNetworksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VmwareEngineNetwork> extractResources(
                ListVmwareEngineNetworksResponse payload) {
              return payload.getVmwareEngineNetworksList() == null
                  ? ImmutableList.<VmwareEngineNetwork>of()
                  : payload.getVmwareEngineNetworksList();
            }
          };

  private static final PagedListDescriptor<
          ListPrivateConnectionsRequest, ListPrivateConnectionsResponse, PrivateConnection>
      LIST_PRIVATE_CONNECTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPrivateConnectionsRequest, ListPrivateConnectionsResponse, PrivateConnection>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPrivateConnectionsRequest injectToken(
                ListPrivateConnectionsRequest payload, String token) {
              return ListPrivateConnectionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPrivateConnectionsRequest injectPageSize(
                ListPrivateConnectionsRequest payload, int pageSize) {
              return ListPrivateConnectionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListPrivateConnectionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPrivateConnectionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PrivateConnection> extractResources(
                ListPrivateConnectionsResponse payload) {
              return payload.getPrivateConnectionsList() == null
                  ? ImmutableList.<PrivateConnection>of()
                  : payload.getPrivateConnectionsList();
            }
          };

  private static final PagedListDescriptor<
          ListPrivateConnectionPeeringRoutesRequest,
          ListPrivateConnectionPeeringRoutesResponse,
          PeeringRoute>
      LIST_PRIVATE_CONNECTION_PEERING_ROUTES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPrivateConnectionPeeringRoutesRequest,
              ListPrivateConnectionPeeringRoutesResponse,
              PeeringRoute>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPrivateConnectionPeeringRoutesRequest injectToken(
                ListPrivateConnectionPeeringRoutesRequest payload, String token) {
              return ListPrivateConnectionPeeringRoutesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListPrivateConnectionPeeringRoutesRequest injectPageSize(
                ListPrivateConnectionPeeringRoutesRequest payload, int pageSize) {
              return ListPrivateConnectionPeeringRoutesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListPrivateConnectionPeeringRoutesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPrivateConnectionPeeringRoutesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PeeringRoute> extractResources(
                ListPrivateConnectionPeeringRoutesResponse payload) {
              return payload.getPeeringRoutesList() == null
                  ? ImmutableList.<PeeringRoute>of()
                  : payload.getPeeringRoutesList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListPrivateCloudsRequest, ListPrivateCloudsResponse, ListPrivateCloudsPagedResponse>
      LIST_PRIVATE_CLOUDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPrivateCloudsRequest,
              ListPrivateCloudsResponse,
              ListPrivateCloudsPagedResponse>() {
            @Override
            public ApiFuture<ListPrivateCloudsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsResponse> callable,
                ListPrivateCloudsRequest request,
                ApiCallContext context,
                ApiFuture<ListPrivateCloudsResponse> futureResponse) {
              PageContext<ListPrivateCloudsRequest, ListPrivateCloudsResponse, PrivateCloud>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PRIVATE_CLOUDS_PAGE_STR_DESC, request, context);
              return ListPrivateCloudsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      LIST_CLUSTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>() {
            @Override
            public ApiFuture<ListClustersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListClustersRequest, ListClustersResponse> callable,
                ListClustersRequest request,
                ApiCallContext context,
                ApiFuture<ListClustersResponse> futureResponse) {
              PageContext<ListClustersRequest, ListClustersResponse, Cluster> pageContext =
                  PageContext.create(callable, LIST_CLUSTERS_PAGE_STR_DESC, request, context);
              return ListClustersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>
      LIST_NODES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>() {
            @Override
            public ApiFuture<ListNodesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNodesRequest, ListNodesResponse> callable,
                ListNodesRequest request,
                ApiCallContext context,
                ApiFuture<ListNodesResponse> futureResponse) {
              PageContext<ListNodesRequest, ListNodesResponse, Node> pageContext =
                  PageContext.create(callable, LIST_NODES_PAGE_STR_DESC, request, context);
              return ListNodesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListExternalAddressesRequest,
          ListExternalAddressesResponse,
          ListExternalAddressesPagedResponse>
      LIST_EXTERNAL_ADDRESSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExternalAddressesRequest,
              ListExternalAddressesResponse,
              ListExternalAddressesPagedResponse>() {
            @Override
            public ApiFuture<ListExternalAddressesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExternalAddressesRequest, ListExternalAddressesResponse> callable,
                ListExternalAddressesRequest request,
                ApiCallContext context,
                ApiFuture<ListExternalAddressesResponse> futureResponse) {
              PageContext<
                      ListExternalAddressesRequest, ListExternalAddressesResponse, ExternalAddress>
                  pageContext =
                      PageContext.create(
                          callable, LIST_EXTERNAL_ADDRESSES_PAGE_STR_DESC, request, context);
              return ListExternalAddressesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchNetworkPolicyExternalAddressesRequest,
          FetchNetworkPolicyExternalAddressesResponse,
          FetchNetworkPolicyExternalAddressesPagedResponse>
      FETCH_NETWORK_POLICY_EXTERNAL_ADDRESSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchNetworkPolicyExternalAddressesRequest,
              FetchNetworkPolicyExternalAddressesResponse,
              FetchNetworkPolicyExternalAddressesPagedResponse>() {
            @Override
            public ApiFuture<FetchNetworkPolicyExternalAddressesPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            FetchNetworkPolicyExternalAddressesRequest,
                            FetchNetworkPolicyExternalAddressesResponse>
                        callable,
                    FetchNetworkPolicyExternalAddressesRequest request,
                    ApiCallContext context,
                    ApiFuture<FetchNetworkPolicyExternalAddressesResponse> futureResponse) {
              PageContext<
                      FetchNetworkPolicyExternalAddressesRequest,
                      FetchNetworkPolicyExternalAddressesResponse,
                      ExternalAddress>
                  pageContext =
                      PageContext.create(
                          callable,
                          FETCH_NETWORK_POLICY_EXTERNAL_ADDRESSES_PAGE_STR_DESC,
                          request,
                          context);
              return FetchNetworkPolicyExternalAddressesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
      LIST_SUBNETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>() {
            @Override
            public ApiFuture<ListSubnetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> callable,
                ListSubnetsRequest request,
                ApiCallContext context,
                ApiFuture<ListSubnetsResponse> futureResponse) {
              PageContext<ListSubnetsRequest, ListSubnetsResponse, Subnet> pageContext =
                  PageContext.create(callable, LIST_SUBNETS_PAGE_STR_DESC, request, context);
              return ListSubnetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListExternalAccessRulesRequest,
          ListExternalAccessRulesResponse,
          ListExternalAccessRulesPagedResponse>
      LIST_EXTERNAL_ACCESS_RULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExternalAccessRulesRequest,
              ListExternalAccessRulesResponse,
              ListExternalAccessRulesPagedResponse>() {
            @Override
            public ApiFuture<ListExternalAccessRulesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExternalAccessRulesRequest, ListExternalAccessRulesResponse>
                    callable,
                ListExternalAccessRulesRequest request,
                ApiCallContext context,
                ApiFuture<ListExternalAccessRulesResponse> futureResponse) {
              PageContext<
                      ListExternalAccessRulesRequest,
                      ListExternalAccessRulesResponse,
                      ExternalAccessRule>
                  pageContext =
                      PageContext.create(
                          callable, LIST_EXTERNAL_ACCESS_RULES_PAGE_STR_DESC, request, context);
              return ListExternalAccessRulesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLoggingServersRequest, ListLoggingServersResponse, ListLoggingServersPagedResponse>
      LIST_LOGGING_SERVERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLoggingServersRequest,
              ListLoggingServersResponse,
              ListLoggingServersPagedResponse>() {
            @Override
            public ApiFuture<ListLoggingServersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLoggingServersRequest, ListLoggingServersResponse> callable,
                ListLoggingServersRequest request,
                ApiCallContext context,
                ApiFuture<ListLoggingServersResponse> futureResponse) {
              PageContext<ListLoggingServersRequest, ListLoggingServersResponse, LoggingServer>
                  pageContext =
                      PageContext.create(
                          callable, LIST_LOGGING_SERVERS_PAGE_STR_DESC, request, context);
              return ListLoggingServersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>
      LIST_NODE_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>() {
            @Override
            public ApiFuture<ListNodeTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNodeTypesRequest, ListNodeTypesResponse> callable,
                ListNodeTypesRequest request,
                ApiCallContext context,
                ApiFuture<ListNodeTypesResponse> futureResponse) {
              PageContext<ListNodeTypesRequest, ListNodeTypesResponse, NodeType> pageContext =
                  PageContext.create(callable, LIST_NODE_TYPES_PAGE_STR_DESC, request, context);
              return ListNodeTypesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNetworkPeeringsRequest, ListNetworkPeeringsResponse, ListNetworkPeeringsPagedResponse>
      LIST_NETWORK_PEERINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNetworkPeeringsRequest,
              ListNetworkPeeringsResponse,
              ListNetworkPeeringsPagedResponse>() {
            @Override
            public ApiFuture<ListNetworkPeeringsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse> callable,
                ListNetworkPeeringsRequest request,
                ApiCallContext context,
                ApiFuture<ListNetworkPeeringsResponse> futureResponse) {
              PageContext<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse, NetworkPeering>
                  pageContext =
                      PageContext.create(
                          callable, LIST_NETWORK_PEERINGS_PAGE_STR_DESC, request, context);
              return ListNetworkPeeringsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPeeringRoutesRequest, ListPeeringRoutesResponse, ListPeeringRoutesPagedResponse>
      LIST_PEERING_ROUTES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPeeringRoutesRequest,
              ListPeeringRoutesResponse,
              ListPeeringRoutesPagedResponse>() {
            @Override
            public ApiFuture<ListPeeringRoutesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPeeringRoutesRequest, ListPeeringRoutesResponse> callable,
                ListPeeringRoutesRequest request,
                ApiCallContext context,
                ApiFuture<ListPeeringRoutesResponse> futureResponse) {
              PageContext<ListPeeringRoutesRequest, ListPeeringRoutesResponse, PeeringRoute>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PEERING_ROUTES_PAGE_STR_DESC, request, context);
              return ListPeeringRoutesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListHcxActivationKeysRequest,
          ListHcxActivationKeysResponse,
          ListHcxActivationKeysPagedResponse>
      LIST_HCX_ACTIVATION_KEYS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListHcxActivationKeysRequest,
              ListHcxActivationKeysResponse,
              ListHcxActivationKeysPagedResponse>() {
            @Override
            public ApiFuture<ListHcxActivationKeysPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse> callable,
                ListHcxActivationKeysRequest request,
                ApiCallContext context,
                ApiFuture<ListHcxActivationKeysResponse> futureResponse) {
              PageContext<
                      ListHcxActivationKeysRequest, ListHcxActivationKeysResponse, HcxActivationKey>
                  pageContext =
                      PageContext.create(
                          callable, LIST_HCX_ACTIVATION_KEYS_PAGE_STR_DESC, request, context);
              return ListHcxActivationKeysPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, ListNetworkPoliciesPagedResponse>
      LIST_NETWORK_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNetworkPoliciesRequest,
              ListNetworkPoliciesResponse,
              ListNetworkPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListNetworkPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse> callable,
                ListNetworkPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListNetworkPoliciesResponse> futureResponse) {
              PageContext<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, NetworkPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_NETWORK_POLICIES_PAGE_STR_DESC, request, context);
              return ListNetworkPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListManagementDnsZoneBindingsRequest,
          ListManagementDnsZoneBindingsResponse,
          ListManagementDnsZoneBindingsPagedResponse>
      LIST_MANAGEMENT_DNS_ZONE_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListManagementDnsZoneBindingsRequest,
              ListManagementDnsZoneBindingsResponse,
              ListManagementDnsZoneBindingsPagedResponse>() {
            @Override
            public ApiFuture<ListManagementDnsZoneBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsResponse>
                    callable,
                ListManagementDnsZoneBindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListManagementDnsZoneBindingsResponse> futureResponse) {
              PageContext<
                      ListManagementDnsZoneBindingsRequest,
                      ListManagementDnsZoneBindingsResponse,
                      ManagementDnsZoneBinding>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_MANAGEMENT_DNS_ZONE_BINDINGS_PAGE_STR_DESC,
                          request,
                          context);
              return ListManagementDnsZoneBindingsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVmwareEngineNetworksRequest,
          ListVmwareEngineNetworksResponse,
          ListVmwareEngineNetworksPagedResponse>
      LIST_VMWARE_ENGINE_NETWORKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVmwareEngineNetworksRequest,
              ListVmwareEngineNetworksResponse,
              ListVmwareEngineNetworksPagedResponse>() {
            @Override
            public ApiFuture<ListVmwareEngineNetworksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>
                    callable,
                ListVmwareEngineNetworksRequest request,
                ApiCallContext context,
                ApiFuture<ListVmwareEngineNetworksResponse> futureResponse) {
              PageContext<
                      ListVmwareEngineNetworksRequest,
                      ListVmwareEngineNetworksResponse,
                      VmwareEngineNetwork>
                  pageContext =
                      PageContext.create(
                          callable, LIST_VMWARE_ENGINE_NETWORKS_PAGE_STR_DESC, request, context);
              return ListVmwareEngineNetworksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          ListPrivateConnectionsPagedResponse>
      LIST_PRIVATE_CONNECTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPrivateConnectionsRequest,
              ListPrivateConnectionsResponse,
              ListPrivateConnectionsPagedResponse>() {
            @Override
            public ApiFuture<ListPrivateConnectionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
                    callable,
                ListPrivateConnectionsRequest request,
                ApiCallContext context,
                ApiFuture<ListPrivateConnectionsResponse> futureResponse) {
              PageContext<
                      ListPrivateConnectionsRequest,
                      ListPrivateConnectionsResponse,
                      PrivateConnection>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PRIVATE_CONNECTIONS_PAGE_STR_DESC, request, context);
              return ListPrivateConnectionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPrivateConnectionPeeringRoutesRequest,
          ListPrivateConnectionPeeringRoutesResponse,
          ListPrivateConnectionPeeringRoutesPagedResponse>
      LIST_PRIVATE_CONNECTION_PEERING_ROUTES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPrivateConnectionPeeringRoutesRequest,
              ListPrivateConnectionPeeringRoutesResponse,
              ListPrivateConnectionPeeringRoutesPagedResponse>() {
            @Override
            public ApiFuture<ListPrivateConnectionPeeringRoutesPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListPrivateConnectionPeeringRoutesRequest,
                            ListPrivateConnectionPeeringRoutesResponse>
                        callable,
                    ListPrivateConnectionPeeringRoutesRequest request,
                    ApiCallContext context,
                    ApiFuture<ListPrivateConnectionPeeringRoutesResponse> futureResponse) {
              PageContext<
                      ListPrivateConnectionPeeringRoutesRequest,
                      ListPrivateConnectionPeeringRoutesResponse,
                      PeeringRoute>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_PRIVATE_CONNECTION_PEERING_ROUTES_PAGE_STR_DESC,
                          request,
                          context);
              return ListPrivateConnectionPeeringRoutesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listPrivateClouds. */
  public PagedCallSettings<
          ListPrivateCloudsRequest, ListPrivateCloudsResponse, ListPrivateCloudsPagedResponse>
      listPrivateCloudsSettings() {
    return listPrivateCloudsSettings;
  }

  /** Returns the object with the settings used for calls to getPrivateCloud. */
  public UnaryCallSettings<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudSettings() {
    return getPrivateCloudSettings;
  }

  /** Returns the object with the settings used for calls to createPrivateCloud. */
  public UnaryCallSettings<CreatePrivateCloudRequest, Operation> createPrivateCloudSettings() {
    return createPrivateCloudSettings;
  }

  /** Returns the object with the settings used for calls to createPrivateCloud. */
  public OperationCallSettings<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      createPrivateCloudOperationSettings() {
    return createPrivateCloudOperationSettings;
  }

  /** Returns the object with the settings used for calls to updatePrivateCloud. */
  public UnaryCallSettings<UpdatePrivateCloudRequest, Operation> updatePrivateCloudSettings() {
    return updatePrivateCloudSettings;
  }

  /** Returns the object with the settings used for calls to updatePrivateCloud. */
  public OperationCallSettings<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      updatePrivateCloudOperationSettings() {
    return updatePrivateCloudOperationSettings;
  }

  /** Returns the object with the settings used for calls to deletePrivateCloud. */
  public UnaryCallSettings<DeletePrivateCloudRequest, Operation> deletePrivateCloudSettings() {
    return deletePrivateCloudSettings;
  }

  /** Returns the object with the settings used for calls to deletePrivateCloud. */
  public OperationCallSettings<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      deletePrivateCloudOperationSettings() {
    return deletePrivateCloudOperationSettings;
  }

  /** Returns the object with the settings used for calls to undeletePrivateCloud. */
  public UnaryCallSettings<UndeletePrivateCloudRequest, Operation> undeletePrivateCloudSettings() {
    return undeletePrivateCloudSettings;
  }

  /** Returns the object with the settings used for calls to undeletePrivateCloud. */
  public OperationCallSettings<UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      undeletePrivateCloudOperationSettings() {
    return undeletePrivateCloudOperationSettings;
  }

  /** Returns the object with the settings used for calls to listClusters. */
  public PagedCallSettings<ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings() {
    return listClustersSettings;
  }

  /** Returns the object with the settings used for calls to getCluster. */
  public UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings() {
    return getClusterSettings;
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings() {
    return createClusterSettings;
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings() {
    return createClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings() {
    return updateClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings() {
    return updateClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings() {
    return deleteClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings() {
    return deleteClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to listNodes. */
  public PagedCallSettings<ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>
      listNodesSettings() {
    return listNodesSettings;
  }

  /** Returns the object with the settings used for calls to getNode. */
  public UnaryCallSettings<GetNodeRequest, Node> getNodeSettings() {
    return getNodeSettings;
  }

  /** Returns the object with the settings used for calls to listExternalAddresses. */
  public PagedCallSettings<
          ListExternalAddressesRequest,
          ListExternalAddressesResponse,
          ListExternalAddressesPagedResponse>
      listExternalAddressesSettings() {
    return listExternalAddressesSettings;
  }

  /** Returns the object with the settings used for calls to fetchNetworkPolicyExternalAddresses. */
  public PagedCallSettings<
          FetchNetworkPolicyExternalAddressesRequest,
          FetchNetworkPolicyExternalAddressesResponse,
          FetchNetworkPolicyExternalAddressesPagedResponse>
      fetchNetworkPolicyExternalAddressesSettings() {
    return fetchNetworkPolicyExternalAddressesSettings;
  }

  /** Returns the object with the settings used for calls to getExternalAddress. */
  public UnaryCallSettings<GetExternalAddressRequest, ExternalAddress>
      getExternalAddressSettings() {
    return getExternalAddressSettings;
  }

  /** Returns the object with the settings used for calls to createExternalAddress. */
  public UnaryCallSettings<CreateExternalAddressRequest, Operation>
      createExternalAddressSettings() {
    return createExternalAddressSettings;
  }

  /** Returns the object with the settings used for calls to createExternalAddress. */
  public OperationCallSettings<CreateExternalAddressRequest, ExternalAddress, OperationMetadata>
      createExternalAddressOperationSettings() {
    return createExternalAddressOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateExternalAddress. */
  public UnaryCallSettings<UpdateExternalAddressRequest, Operation>
      updateExternalAddressSettings() {
    return updateExternalAddressSettings;
  }

  /** Returns the object with the settings used for calls to updateExternalAddress. */
  public OperationCallSettings<UpdateExternalAddressRequest, ExternalAddress, OperationMetadata>
      updateExternalAddressOperationSettings() {
    return updateExternalAddressOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteExternalAddress. */
  public UnaryCallSettings<DeleteExternalAddressRequest, Operation>
      deleteExternalAddressSettings() {
    return deleteExternalAddressSettings;
  }

  /** Returns the object with the settings used for calls to deleteExternalAddress. */
  public OperationCallSettings<DeleteExternalAddressRequest, Empty, OperationMetadata>
      deleteExternalAddressOperationSettings() {
    return deleteExternalAddressOperationSettings;
  }

  /** Returns the object with the settings used for calls to listSubnets. */
  public PagedCallSettings<ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
      listSubnetsSettings() {
    return listSubnetsSettings;
  }

  /** Returns the object with the settings used for calls to getSubnet. */
  public UnaryCallSettings<GetSubnetRequest, Subnet> getSubnetSettings() {
    return getSubnetSettings;
  }

  /** Returns the object with the settings used for calls to updateSubnet. */
  public UnaryCallSettings<UpdateSubnetRequest, Operation> updateSubnetSettings() {
    return updateSubnetSettings;
  }

  /** Returns the object with the settings used for calls to updateSubnet. */
  public OperationCallSettings<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationSettings() {
    return updateSubnetOperationSettings;
  }

  /** Returns the object with the settings used for calls to listExternalAccessRules. */
  public PagedCallSettings<
          ListExternalAccessRulesRequest,
          ListExternalAccessRulesResponse,
          ListExternalAccessRulesPagedResponse>
      listExternalAccessRulesSettings() {
    return listExternalAccessRulesSettings;
  }

  /** Returns the object with the settings used for calls to getExternalAccessRule. */
  public UnaryCallSettings<GetExternalAccessRuleRequest, ExternalAccessRule>
      getExternalAccessRuleSettings() {
    return getExternalAccessRuleSettings;
  }

  /** Returns the object with the settings used for calls to createExternalAccessRule. */
  public UnaryCallSettings<CreateExternalAccessRuleRequest, Operation>
      createExternalAccessRuleSettings() {
    return createExternalAccessRuleSettings;
  }

  /** Returns the object with the settings used for calls to createExternalAccessRule. */
  public OperationCallSettings<
          CreateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      createExternalAccessRuleOperationSettings() {
    return createExternalAccessRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateExternalAccessRule. */
  public UnaryCallSettings<UpdateExternalAccessRuleRequest, Operation>
      updateExternalAccessRuleSettings() {
    return updateExternalAccessRuleSettings;
  }

  /** Returns the object with the settings used for calls to updateExternalAccessRule. */
  public OperationCallSettings<
          UpdateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      updateExternalAccessRuleOperationSettings() {
    return updateExternalAccessRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteExternalAccessRule. */
  public UnaryCallSettings<DeleteExternalAccessRuleRequest, Operation>
      deleteExternalAccessRuleSettings() {
    return deleteExternalAccessRuleSettings;
  }

  /** Returns the object with the settings used for calls to deleteExternalAccessRule. */
  public OperationCallSettings<DeleteExternalAccessRuleRequest, Empty, OperationMetadata>
      deleteExternalAccessRuleOperationSettings() {
    return deleteExternalAccessRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLoggingServers. */
  public PagedCallSettings<
          ListLoggingServersRequest, ListLoggingServersResponse, ListLoggingServersPagedResponse>
      listLoggingServersSettings() {
    return listLoggingServersSettings;
  }

  /** Returns the object with the settings used for calls to getLoggingServer. */
  public UnaryCallSettings<GetLoggingServerRequest, LoggingServer> getLoggingServerSettings() {
    return getLoggingServerSettings;
  }

  /** Returns the object with the settings used for calls to createLoggingServer. */
  public UnaryCallSettings<CreateLoggingServerRequest, Operation> createLoggingServerSettings() {
    return createLoggingServerSettings;
  }

  /** Returns the object with the settings used for calls to createLoggingServer. */
  public OperationCallSettings<CreateLoggingServerRequest, LoggingServer, OperationMetadata>
      createLoggingServerOperationSettings() {
    return createLoggingServerOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateLoggingServer. */
  public UnaryCallSettings<UpdateLoggingServerRequest, Operation> updateLoggingServerSettings() {
    return updateLoggingServerSettings;
  }

  /** Returns the object with the settings used for calls to updateLoggingServer. */
  public OperationCallSettings<UpdateLoggingServerRequest, LoggingServer, OperationMetadata>
      updateLoggingServerOperationSettings() {
    return updateLoggingServerOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteLoggingServer. */
  public UnaryCallSettings<DeleteLoggingServerRequest, Operation> deleteLoggingServerSettings() {
    return deleteLoggingServerSettings;
  }

  /** Returns the object with the settings used for calls to deleteLoggingServer. */
  public OperationCallSettings<DeleteLoggingServerRequest, Empty, OperationMetadata>
      deleteLoggingServerOperationSettings() {
    return deleteLoggingServerOperationSettings;
  }

  /** Returns the object with the settings used for calls to listNodeTypes. */
  public PagedCallSettings<ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>
      listNodeTypesSettings() {
    return listNodeTypesSettings;
  }

  /** Returns the object with the settings used for calls to getNodeType. */
  public UnaryCallSettings<GetNodeTypeRequest, NodeType> getNodeTypeSettings() {
    return getNodeTypeSettings;
  }

  /** Returns the object with the settings used for calls to showNsxCredentials. */
  public UnaryCallSettings<ShowNsxCredentialsRequest, Credentials> showNsxCredentialsSettings() {
    return showNsxCredentialsSettings;
  }

  /** Returns the object with the settings used for calls to showVcenterCredentials. */
  public UnaryCallSettings<ShowVcenterCredentialsRequest, Credentials>
      showVcenterCredentialsSettings() {
    return showVcenterCredentialsSettings;
  }

  /** Returns the object with the settings used for calls to resetNsxCredentials. */
  public UnaryCallSettings<ResetNsxCredentialsRequest, Operation> resetNsxCredentialsSettings() {
    return resetNsxCredentialsSettings;
  }

  /** Returns the object with the settings used for calls to resetNsxCredentials. */
  public OperationCallSettings<ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
      resetNsxCredentialsOperationSettings() {
    return resetNsxCredentialsOperationSettings;
  }

  /** Returns the object with the settings used for calls to resetVcenterCredentials. */
  public UnaryCallSettings<ResetVcenterCredentialsRequest, Operation>
      resetVcenterCredentialsSettings() {
    return resetVcenterCredentialsSettings;
  }

  /** Returns the object with the settings used for calls to resetVcenterCredentials. */
  public OperationCallSettings<ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
      resetVcenterCredentialsOperationSettings() {
    return resetVcenterCredentialsOperationSettings;
  }

  /** Returns the object with the settings used for calls to getDnsForwarding. */
  public UnaryCallSettings<GetDnsForwardingRequest, DnsForwarding> getDnsForwardingSettings() {
    return getDnsForwardingSettings;
  }

  /** Returns the object with the settings used for calls to updateDnsForwarding. */
  public UnaryCallSettings<UpdateDnsForwardingRequest, Operation> updateDnsForwardingSettings() {
    return updateDnsForwardingSettings;
  }

  /** Returns the object with the settings used for calls to updateDnsForwarding. */
  public OperationCallSettings<UpdateDnsForwardingRequest, DnsForwarding, OperationMetadata>
      updateDnsForwardingOperationSettings() {
    return updateDnsForwardingOperationSettings;
  }

  /** Returns the object with the settings used for calls to getNetworkPeering. */
  public UnaryCallSettings<GetNetworkPeeringRequest, NetworkPeering> getNetworkPeeringSettings() {
    return getNetworkPeeringSettings;
  }

  /** Returns the object with the settings used for calls to listNetworkPeerings. */
  public PagedCallSettings<
          ListNetworkPeeringsRequest, ListNetworkPeeringsResponse, ListNetworkPeeringsPagedResponse>
      listNetworkPeeringsSettings() {
    return listNetworkPeeringsSettings;
  }

  /** Returns the object with the settings used for calls to createNetworkPeering. */
  public UnaryCallSettings<CreateNetworkPeeringRequest, Operation> createNetworkPeeringSettings() {
    return createNetworkPeeringSettings;
  }

  /** Returns the object with the settings used for calls to createNetworkPeering. */
  public OperationCallSettings<CreateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      createNetworkPeeringOperationSettings() {
    return createNetworkPeeringOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteNetworkPeering. */
  public UnaryCallSettings<DeleteNetworkPeeringRequest, Operation> deleteNetworkPeeringSettings() {
    return deleteNetworkPeeringSettings;
  }

  /** Returns the object with the settings used for calls to deleteNetworkPeering. */
  public OperationCallSettings<DeleteNetworkPeeringRequest, Empty, OperationMetadata>
      deleteNetworkPeeringOperationSettings() {
    return deleteNetworkPeeringOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateNetworkPeering. */
  public UnaryCallSettings<UpdateNetworkPeeringRequest, Operation> updateNetworkPeeringSettings() {
    return updateNetworkPeeringSettings;
  }

  /** Returns the object with the settings used for calls to updateNetworkPeering. */
  public OperationCallSettings<UpdateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      updateNetworkPeeringOperationSettings() {
    return updateNetworkPeeringOperationSettings;
  }

  /** Returns the object with the settings used for calls to listPeeringRoutes. */
  public PagedCallSettings<
          ListPeeringRoutesRequest, ListPeeringRoutesResponse, ListPeeringRoutesPagedResponse>
      listPeeringRoutesSettings() {
    return listPeeringRoutesSettings;
  }

  /** Returns the object with the settings used for calls to createHcxActivationKey. */
  public UnaryCallSettings<CreateHcxActivationKeyRequest, Operation>
      createHcxActivationKeySettings() {
    return createHcxActivationKeySettings;
  }

  /** Returns the object with the settings used for calls to createHcxActivationKey. */
  public OperationCallSettings<CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
      createHcxActivationKeyOperationSettings() {
    return createHcxActivationKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listHcxActivationKeys. */
  public PagedCallSettings<
          ListHcxActivationKeysRequest,
          ListHcxActivationKeysResponse,
          ListHcxActivationKeysPagedResponse>
      listHcxActivationKeysSettings() {
    return listHcxActivationKeysSettings;
  }

  /** Returns the object with the settings used for calls to getHcxActivationKey. */
  public UnaryCallSettings<GetHcxActivationKeyRequest, HcxActivationKey>
      getHcxActivationKeySettings() {
    return getHcxActivationKeySettings;
  }

  /** Returns the object with the settings used for calls to getNetworkPolicy. */
  public UnaryCallSettings<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicySettings() {
    return getNetworkPolicySettings;
  }

  /** Returns the object with the settings used for calls to listNetworkPolicies. */
  public PagedCallSettings<
          ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, ListNetworkPoliciesPagedResponse>
      listNetworkPoliciesSettings() {
    return listNetworkPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to createNetworkPolicy. */
  public UnaryCallSettings<CreateNetworkPolicyRequest, Operation> createNetworkPolicySettings() {
    return createNetworkPolicySettings;
  }

  /** Returns the object with the settings used for calls to createNetworkPolicy. */
  public OperationCallSettings<CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      createNetworkPolicyOperationSettings() {
    return createNetworkPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateNetworkPolicy. */
  public UnaryCallSettings<UpdateNetworkPolicyRequest, Operation> updateNetworkPolicySettings() {
    return updateNetworkPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateNetworkPolicy. */
  public OperationCallSettings<UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      updateNetworkPolicyOperationSettings() {
    return updateNetworkPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteNetworkPolicy. */
  public UnaryCallSettings<DeleteNetworkPolicyRequest, Operation> deleteNetworkPolicySettings() {
    return deleteNetworkPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteNetworkPolicy. */
  public OperationCallSettings<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
      deleteNetworkPolicyOperationSettings() {
    return deleteNetworkPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listManagementDnsZoneBindings. */
  public PagedCallSettings<
          ListManagementDnsZoneBindingsRequest,
          ListManagementDnsZoneBindingsResponse,
          ListManagementDnsZoneBindingsPagedResponse>
      listManagementDnsZoneBindingsSettings() {
    return listManagementDnsZoneBindingsSettings;
  }

  /** Returns the object with the settings used for calls to getManagementDnsZoneBinding. */
  public UnaryCallSettings<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
      getManagementDnsZoneBindingSettings() {
    return getManagementDnsZoneBindingSettings;
  }

  /** Returns the object with the settings used for calls to createManagementDnsZoneBinding. */
  public UnaryCallSettings<CreateManagementDnsZoneBindingRequest, Operation>
      createManagementDnsZoneBindingSettings() {
    return createManagementDnsZoneBindingSettings;
  }

  /** Returns the object with the settings used for calls to createManagementDnsZoneBinding. */
  public OperationCallSettings<
          CreateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      createManagementDnsZoneBindingOperationSettings() {
    return createManagementDnsZoneBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateManagementDnsZoneBinding. */
  public UnaryCallSettings<UpdateManagementDnsZoneBindingRequest, Operation>
      updateManagementDnsZoneBindingSettings() {
    return updateManagementDnsZoneBindingSettings;
  }

  /** Returns the object with the settings used for calls to updateManagementDnsZoneBinding. */
  public OperationCallSettings<
          UpdateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      updateManagementDnsZoneBindingOperationSettings() {
    return updateManagementDnsZoneBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteManagementDnsZoneBinding. */
  public UnaryCallSettings<DeleteManagementDnsZoneBindingRequest, Operation>
      deleteManagementDnsZoneBindingSettings() {
    return deleteManagementDnsZoneBindingSettings;
  }

  /** Returns the object with the settings used for calls to deleteManagementDnsZoneBinding. */
  public OperationCallSettings<DeleteManagementDnsZoneBindingRequest, Empty, OperationMetadata>
      deleteManagementDnsZoneBindingOperationSettings() {
    return deleteManagementDnsZoneBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to repairManagementDnsZoneBinding. */
  public UnaryCallSettings<RepairManagementDnsZoneBindingRequest, Operation>
      repairManagementDnsZoneBindingSettings() {
    return repairManagementDnsZoneBindingSettings;
  }

  /** Returns the object with the settings used for calls to repairManagementDnsZoneBinding. */
  public OperationCallSettings<
          RepairManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      repairManagementDnsZoneBindingOperationSettings() {
    return repairManagementDnsZoneBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to createVmwareEngineNetwork. */
  public UnaryCallSettings<CreateVmwareEngineNetworkRequest, Operation>
      createVmwareEngineNetworkSettings() {
    return createVmwareEngineNetworkSettings;
  }

  /** Returns the object with the settings used for calls to createVmwareEngineNetwork. */
  public OperationCallSettings<
          CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkOperationSettings() {
    return createVmwareEngineNetworkOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateVmwareEngineNetwork. */
  public UnaryCallSettings<UpdateVmwareEngineNetworkRequest, Operation>
      updateVmwareEngineNetworkSettings() {
    return updateVmwareEngineNetworkSettings;
  }

  /** Returns the object with the settings used for calls to updateVmwareEngineNetwork. */
  public OperationCallSettings<
          UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkOperationSettings() {
    return updateVmwareEngineNetworkOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteVmwareEngineNetwork. */
  public UnaryCallSettings<DeleteVmwareEngineNetworkRequest, Operation>
      deleteVmwareEngineNetworkSettings() {
    return deleteVmwareEngineNetworkSettings;
  }

  /** Returns the object with the settings used for calls to deleteVmwareEngineNetwork. */
  public OperationCallSettings<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
      deleteVmwareEngineNetworkOperationSettings() {
    return deleteVmwareEngineNetworkOperationSettings;
  }

  /** Returns the object with the settings used for calls to getVmwareEngineNetwork. */
  public UnaryCallSettings<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
      getVmwareEngineNetworkSettings() {
    return getVmwareEngineNetworkSettings;
  }

  /** Returns the object with the settings used for calls to listVmwareEngineNetworks. */
  public PagedCallSettings<
          ListVmwareEngineNetworksRequest,
          ListVmwareEngineNetworksResponse,
          ListVmwareEngineNetworksPagedResponse>
      listVmwareEngineNetworksSettings() {
    return listVmwareEngineNetworksSettings;
  }

  /** Returns the object with the settings used for calls to createPrivateConnection. */
  public UnaryCallSettings<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionSettings() {
    return createPrivateConnectionSettings;
  }

  /** Returns the object with the settings used for calls to createPrivateConnection. */
  public OperationCallSettings<CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationSettings() {
    return createPrivateConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to getPrivateConnection. */
  public UnaryCallSettings<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionSettings() {
    return getPrivateConnectionSettings;
  }

  /** Returns the object with the settings used for calls to listPrivateConnections. */
  public PagedCallSettings<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsSettings() {
    return listPrivateConnectionsSettings;
  }

  /** Returns the object with the settings used for calls to updatePrivateConnection. */
  public UnaryCallSettings<UpdatePrivateConnectionRequest, Operation>
      updatePrivateConnectionSettings() {
    return updatePrivateConnectionSettings;
  }

  /** Returns the object with the settings used for calls to updatePrivateConnection. */
  public OperationCallSettings<UpdatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      updatePrivateConnectionOperationSettings() {
    return updatePrivateConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to deletePrivateConnection. */
  public UnaryCallSettings<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionSettings() {
    return deletePrivateConnectionSettings;
  }

  /** Returns the object with the settings used for calls to deletePrivateConnection. */
  public OperationCallSettings<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationSettings() {
    return deletePrivateConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to listPrivateConnectionPeeringRoutes. */
  public PagedCallSettings<
          ListPrivateConnectionPeeringRoutesRequest,
          ListPrivateConnectionPeeringRoutesResponse,
          ListPrivateConnectionPeeringRoutesPagedResponse>
      listPrivateConnectionPeeringRoutesSettings() {
    return listPrivateConnectionPeeringRoutesSettings;
  }

  /** Returns the object with the settings used for calls to grantDnsBindPermission. */
  public UnaryCallSettings<GrantDnsBindPermissionRequest, Operation>
      grantDnsBindPermissionSettings() {
    return grantDnsBindPermissionSettings;
  }

  /** Returns the object with the settings used for calls to grantDnsBindPermission. */
  public OperationCallSettings<GrantDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      grantDnsBindPermissionOperationSettings() {
    return grantDnsBindPermissionOperationSettings;
  }

  /** Returns the object with the settings used for calls to getDnsBindPermission. */
  public UnaryCallSettings<GetDnsBindPermissionRequest, DnsBindPermission>
      getDnsBindPermissionSettings() {
    return getDnsBindPermissionSettings;
  }

  /** Returns the object with the settings used for calls to revokeDnsBindPermission. */
  public UnaryCallSettings<RevokeDnsBindPermissionRequest, Operation>
      revokeDnsBindPermissionSettings() {
    return revokeDnsBindPermissionSettings;
  }

  /** Returns the object with the settings used for calls to revokeDnsBindPermission. */
  public OperationCallSettings<RevokeDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      revokeDnsBindPermissionOperationSettings() {
    return revokeDnsBindPermissionOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public VmwareEngineStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcVmwareEngineStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonVmwareEngineStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "vmwareengine";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "vmwareengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "vmwareengine.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(VmwareEngineStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(VmwareEngineStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VmwareEngineStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
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

  protected VmwareEngineStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listPrivateCloudsSettings = settingsBuilder.listPrivateCloudsSettings().build();
    getPrivateCloudSettings = settingsBuilder.getPrivateCloudSettings().build();
    createPrivateCloudSettings = settingsBuilder.createPrivateCloudSettings().build();
    createPrivateCloudOperationSettings =
        settingsBuilder.createPrivateCloudOperationSettings().build();
    updatePrivateCloudSettings = settingsBuilder.updatePrivateCloudSettings().build();
    updatePrivateCloudOperationSettings =
        settingsBuilder.updatePrivateCloudOperationSettings().build();
    deletePrivateCloudSettings = settingsBuilder.deletePrivateCloudSettings().build();
    deletePrivateCloudOperationSettings =
        settingsBuilder.deletePrivateCloudOperationSettings().build();
    undeletePrivateCloudSettings = settingsBuilder.undeletePrivateCloudSettings().build();
    undeletePrivateCloudOperationSettings =
        settingsBuilder.undeletePrivateCloudOperationSettings().build();
    listClustersSettings = settingsBuilder.listClustersSettings().build();
    getClusterSettings = settingsBuilder.getClusterSettings().build();
    createClusterSettings = settingsBuilder.createClusterSettings().build();
    createClusterOperationSettings = settingsBuilder.createClusterOperationSettings().build();
    updateClusterSettings = settingsBuilder.updateClusterSettings().build();
    updateClusterOperationSettings = settingsBuilder.updateClusterOperationSettings().build();
    deleteClusterSettings = settingsBuilder.deleteClusterSettings().build();
    deleteClusterOperationSettings = settingsBuilder.deleteClusterOperationSettings().build();
    listNodesSettings = settingsBuilder.listNodesSettings().build();
    getNodeSettings = settingsBuilder.getNodeSettings().build();
    listExternalAddressesSettings = settingsBuilder.listExternalAddressesSettings().build();
    fetchNetworkPolicyExternalAddressesSettings =
        settingsBuilder.fetchNetworkPolicyExternalAddressesSettings().build();
    getExternalAddressSettings = settingsBuilder.getExternalAddressSettings().build();
    createExternalAddressSettings = settingsBuilder.createExternalAddressSettings().build();
    createExternalAddressOperationSettings =
        settingsBuilder.createExternalAddressOperationSettings().build();
    updateExternalAddressSettings = settingsBuilder.updateExternalAddressSettings().build();
    updateExternalAddressOperationSettings =
        settingsBuilder.updateExternalAddressOperationSettings().build();
    deleteExternalAddressSettings = settingsBuilder.deleteExternalAddressSettings().build();
    deleteExternalAddressOperationSettings =
        settingsBuilder.deleteExternalAddressOperationSettings().build();
    listSubnetsSettings = settingsBuilder.listSubnetsSettings().build();
    getSubnetSettings = settingsBuilder.getSubnetSettings().build();
    updateSubnetSettings = settingsBuilder.updateSubnetSettings().build();
    updateSubnetOperationSettings = settingsBuilder.updateSubnetOperationSettings().build();
    listExternalAccessRulesSettings = settingsBuilder.listExternalAccessRulesSettings().build();
    getExternalAccessRuleSettings = settingsBuilder.getExternalAccessRuleSettings().build();
    createExternalAccessRuleSettings = settingsBuilder.createExternalAccessRuleSettings().build();
    createExternalAccessRuleOperationSettings =
        settingsBuilder.createExternalAccessRuleOperationSettings().build();
    updateExternalAccessRuleSettings = settingsBuilder.updateExternalAccessRuleSettings().build();
    updateExternalAccessRuleOperationSettings =
        settingsBuilder.updateExternalAccessRuleOperationSettings().build();
    deleteExternalAccessRuleSettings = settingsBuilder.deleteExternalAccessRuleSettings().build();
    deleteExternalAccessRuleOperationSettings =
        settingsBuilder.deleteExternalAccessRuleOperationSettings().build();
    listLoggingServersSettings = settingsBuilder.listLoggingServersSettings().build();
    getLoggingServerSettings = settingsBuilder.getLoggingServerSettings().build();
    createLoggingServerSettings = settingsBuilder.createLoggingServerSettings().build();
    createLoggingServerOperationSettings =
        settingsBuilder.createLoggingServerOperationSettings().build();
    updateLoggingServerSettings = settingsBuilder.updateLoggingServerSettings().build();
    updateLoggingServerOperationSettings =
        settingsBuilder.updateLoggingServerOperationSettings().build();
    deleteLoggingServerSettings = settingsBuilder.deleteLoggingServerSettings().build();
    deleteLoggingServerOperationSettings =
        settingsBuilder.deleteLoggingServerOperationSettings().build();
    listNodeTypesSettings = settingsBuilder.listNodeTypesSettings().build();
    getNodeTypeSettings = settingsBuilder.getNodeTypeSettings().build();
    showNsxCredentialsSettings = settingsBuilder.showNsxCredentialsSettings().build();
    showVcenterCredentialsSettings = settingsBuilder.showVcenterCredentialsSettings().build();
    resetNsxCredentialsSettings = settingsBuilder.resetNsxCredentialsSettings().build();
    resetNsxCredentialsOperationSettings =
        settingsBuilder.resetNsxCredentialsOperationSettings().build();
    resetVcenterCredentialsSettings = settingsBuilder.resetVcenterCredentialsSettings().build();
    resetVcenterCredentialsOperationSettings =
        settingsBuilder.resetVcenterCredentialsOperationSettings().build();
    getDnsForwardingSettings = settingsBuilder.getDnsForwardingSettings().build();
    updateDnsForwardingSettings = settingsBuilder.updateDnsForwardingSettings().build();
    updateDnsForwardingOperationSettings =
        settingsBuilder.updateDnsForwardingOperationSettings().build();
    getNetworkPeeringSettings = settingsBuilder.getNetworkPeeringSettings().build();
    listNetworkPeeringsSettings = settingsBuilder.listNetworkPeeringsSettings().build();
    createNetworkPeeringSettings = settingsBuilder.createNetworkPeeringSettings().build();
    createNetworkPeeringOperationSettings =
        settingsBuilder.createNetworkPeeringOperationSettings().build();
    deleteNetworkPeeringSettings = settingsBuilder.deleteNetworkPeeringSettings().build();
    deleteNetworkPeeringOperationSettings =
        settingsBuilder.deleteNetworkPeeringOperationSettings().build();
    updateNetworkPeeringSettings = settingsBuilder.updateNetworkPeeringSettings().build();
    updateNetworkPeeringOperationSettings =
        settingsBuilder.updateNetworkPeeringOperationSettings().build();
    listPeeringRoutesSettings = settingsBuilder.listPeeringRoutesSettings().build();
    createHcxActivationKeySettings = settingsBuilder.createHcxActivationKeySettings().build();
    createHcxActivationKeyOperationSettings =
        settingsBuilder.createHcxActivationKeyOperationSettings().build();
    listHcxActivationKeysSettings = settingsBuilder.listHcxActivationKeysSettings().build();
    getHcxActivationKeySettings = settingsBuilder.getHcxActivationKeySettings().build();
    getNetworkPolicySettings = settingsBuilder.getNetworkPolicySettings().build();
    listNetworkPoliciesSettings = settingsBuilder.listNetworkPoliciesSettings().build();
    createNetworkPolicySettings = settingsBuilder.createNetworkPolicySettings().build();
    createNetworkPolicyOperationSettings =
        settingsBuilder.createNetworkPolicyOperationSettings().build();
    updateNetworkPolicySettings = settingsBuilder.updateNetworkPolicySettings().build();
    updateNetworkPolicyOperationSettings =
        settingsBuilder.updateNetworkPolicyOperationSettings().build();
    deleteNetworkPolicySettings = settingsBuilder.deleteNetworkPolicySettings().build();
    deleteNetworkPolicyOperationSettings =
        settingsBuilder.deleteNetworkPolicyOperationSettings().build();
    listManagementDnsZoneBindingsSettings =
        settingsBuilder.listManagementDnsZoneBindingsSettings().build();
    getManagementDnsZoneBindingSettings =
        settingsBuilder.getManagementDnsZoneBindingSettings().build();
    createManagementDnsZoneBindingSettings =
        settingsBuilder.createManagementDnsZoneBindingSettings().build();
    createManagementDnsZoneBindingOperationSettings =
        settingsBuilder.createManagementDnsZoneBindingOperationSettings().build();
    updateManagementDnsZoneBindingSettings =
        settingsBuilder.updateManagementDnsZoneBindingSettings().build();
    updateManagementDnsZoneBindingOperationSettings =
        settingsBuilder.updateManagementDnsZoneBindingOperationSettings().build();
    deleteManagementDnsZoneBindingSettings =
        settingsBuilder.deleteManagementDnsZoneBindingSettings().build();
    deleteManagementDnsZoneBindingOperationSettings =
        settingsBuilder.deleteManagementDnsZoneBindingOperationSettings().build();
    repairManagementDnsZoneBindingSettings =
        settingsBuilder.repairManagementDnsZoneBindingSettings().build();
    repairManagementDnsZoneBindingOperationSettings =
        settingsBuilder.repairManagementDnsZoneBindingOperationSettings().build();
    createVmwareEngineNetworkSettings = settingsBuilder.createVmwareEngineNetworkSettings().build();
    createVmwareEngineNetworkOperationSettings =
        settingsBuilder.createVmwareEngineNetworkOperationSettings().build();
    updateVmwareEngineNetworkSettings = settingsBuilder.updateVmwareEngineNetworkSettings().build();
    updateVmwareEngineNetworkOperationSettings =
        settingsBuilder.updateVmwareEngineNetworkOperationSettings().build();
    deleteVmwareEngineNetworkSettings = settingsBuilder.deleteVmwareEngineNetworkSettings().build();
    deleteVmwareEngineNetworkOperationSettings =
        settingsBuilder.deleteVmwareEngineNetworkOperationSettings().build();
    getVmwareEngineNetworkSettings = settingsBuilder.getVmwareEngineNetworkSettings().build();
    listVmwareEngineNetworksSettings = settingsBuilder.listVmwareEngineNetworksSettings().build();
    createPrivateConnectionSettings = settingsBuilder.createPrivateConnectionSettings().build();
    createPrivateConnectionOperationSettings =
        settingsBuilder.createPrivateConnectionOperationSettings().build();
    getPrivateConnectionSettings = settingsBuilder.getPrivateConnectionSettings().build();
    listPrivateConnectionsSettings = settingsBuilder.listPrivateConnectionsSettings().build();
    updatePrivateConnectionSettings = settingsBuilder.updatePrivateConnectionSettings().build();
    updatePrivateConnectionOperationSettings =
        settingsBuilder.updatePrivateConnectionOperationSettings().build();
    deletePrivateConnectionSettings = settingsBuilder.deletePrivateConnectionSettings().build();
    deletePrivateConnectionOperationSettings =
        settingsBuilder.deletePrivateConnectionOperationSettings().build();
    listPrivateConnectionPeeringRoutesSettings =
        settingsBuilder.listPrivateConnectionPeeringRoutesSettings().build();
    grantDnsBindPermissionSettings = settingsBuilder.grantDnsBindPermissionSettings().build();
    grantDnsBindPermissionOperationSettings =
        settingsBuilder.grantDnsBindPermissionOperationSettings().build();
    getDnsBindPermissionSettings = settingsBuilder.getDnsBindPermissionSettings().build();
    revokeDnsBindPermissionSettings = settingsBuilder.revokeDnsBindPermissionSettings().build();
    revokeDnsBindPermissionOperationSettings =
        settingsBuilder.revokeDnsBindPermissionOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for VmwareEngineStubSettings. */
  public static class Builder extends StubSettings.Builder<VmwareEngineStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListPrivateCloudsRequest, ListPrivateCloudsResponse, ListPrivateCloudsPagedResponse>
        listPrivateCloudsSettings;
    private final UnaryCallSettings.Builder<GetPrivateCloudRequest, PrivateCloud>
        getPrivateCloudSettings;
    private final UnaryCallSettings.Builder<CreatePrivateCloudRequest, Operation>
        createPrivateCloudSettings;
    private final OperationCallSettings.Builder<
            CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
        createPrivateCloudOperationSettings;
    private final UnaryCallSettings.Builder<UpdatePrivateCloudRequest, Operation>
        updatePrivateCloudSettings;
    private final OperationCallSettings.Builder<
            UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
        updatePrivateCloudOperationSettings;
    private final UnaryCallSettings.Builder<DeletePrivateCloudRequest, Operation>
        deletePrivateCloudSettings;
    private final OperationCallSettings.Builder<
            DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
        deletePrivateCloudOperationSettings;
    private final UnaryCallSettings.Builder<UndeletePrivateCloudRequest, Operation>
        undeletePrivateCloudSettings;
    private final OperationCallSettings.Builder<
            UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
        undeletePrivateCloudOperationSettings;
    private final PagedCallSettings.Builder<
            ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
        listClustersSettings;
    private final UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings;
    private final UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings;
    private final OperationCallSettings.Builder<CreateClusterRequest, Cluster, OperationMetadata>
        createClusterOperationSettings;
    private final UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings;
    private final OperationCallSettings.Builder<UpdateClusterRequest, Cluster, OperationMetadata>
        updateClusterOperationSettings;
    private final UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings;
    private final OperationCallSettings.Builder<DeleteClusterRequest, Empty, OperationMetadata>
        deleteClusterOperationSettings;
    private final PagedCallSettings.Builder<
            ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>
        listNodesSettings;
    private final UnaryCallSettings.Builder<GetNodeRequest, Node> getNodeSettings;
    private final PagedCallSettings.Builder<
            ListExternalAddressesRequest,
            ListExternalAddressesResponse,
            ListExternalAddressesPagedResponse>
        listExternalAddressesSettings;
    private final PagedCallSettings.Builder<
            FetchNetworkPolicyExternalAddressesRequest,
            FetchNetworkPolicyExternalAddressesResponse,
            FetchNetworkPolicyExternalAddressesPagedResponse>
        fetchNetworkPolicyExternalAddressesSettings;
    private final UnaryCallSettings.Builder<GetExternalAddressRequest, ExternalAddress>
        getExternalAddressSettings;
    private final UnaryCallSettings.Builder<CreateExternalAddressRequest, Operation>
        createExternalAddressSettings;
    private final OperationCallSettings.Builder<
            CreateExternalAddressRequest, ExternalAddress, OperationMetadata>
        createExternalAddressOperationSettings;
    private final UnaryCallSettings.Builder<UpdateExternalAddressRequest, Operation>
        updateExternalAddressSettings;
    private final OperationCallSettings.Builder<
            UpdateExternalAddressRequest, ExternalAddress, OperationMetadata>
        updateExternalAddressOperationSettings;
    private final UnaryCallSettings.Builder<DeleteExternalAddressRequest, Operation>
        deleteExternalAddressSettings;
    private final OperationCallSettings.Builder<
            DeleteExternalAddressRequest, Empty, OperationMetadata>
        deleteExternalAddressOperationSettings;
    private final PagedCallSettings.Builder<
            ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
        listSubnetsSettings;
    private final UnaryCallSettings.Builder<GetSubnetRequest, Subnet> getSubnetSettings;
    private final UnaryCallSettings.Builder<UpdateSubnetRequest, Operation> updateSubnetSettings;
    private final OperationCallSettings.Builder<UpdateSubnetRequest, Subnet, OperationMetadata>
        updateSubnetOperationSettings;
    private final PagedCallSettings.Builder<
            ListExternalAccessRulesRequest,
            ListExternalAccessRulesResponse,
            ListExternalAccessRulesPagedResponse>
        listExternalAccessRulesSettings;
    private final UnaryCallSettings.Builder<GetExternalAccessRuleRequest, ExternalAccessRule>
        getExternalAccessRuleSettings;
    private final UnaryCallSettings.Builder<CreateExternalAccessRuleRequest, Operation>
        createExternalAccessRuleSettings;
    private final OperationCallSettings.Builder<
            CreateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
        createExternalAccessRuleOperationSettings;
    private final UnaryCallSettings.Builder<UpdateExternalAccessRuleRequest, Operation>
        updateExternalAccessRuleSettings;
    private final OperationCallSettings.Builder<
            UpdateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
        updateExternalAccessRuleOperationSettings;
    private final UnaryCallSettings.Builder<DeleteExternalAccessRuleRequest, Operation>
        deleteExternalAccessRuleSettings;
    private final OperationCallSettings.Builder<
            DeleteExternalAccessRuleRequest, Empty, OperationMetadata>
        deleteExternalAccessRuleOperationSettings;
    private final PagedCallSettings.Builder<
            ListLoggingServersRequest, ListLoggingServersResponse, ListLoggingServersPagedResponse>
        listLoggingServersSettings;
    private final UnaryCallSettings.Builder<GetLoggingServerRequest, LoggingServer>
        getLoggingServerSettings;
    private final UnaryCallSettings.Builder<CreateLoggingServerRequest, Operation>
        createLoggingServerSettings;
    private final OperationCallSettings.Builder<
            CreateLoggingServerRequest, LoggingServer, OperationMetadata>
        createLoggingServerOperationSettings;
    private final UnaryCallSettings.Builder<UpdateLoggingServerRequest, Operation>
        updateLoggingServerSettings;
    private final OperationCallSettings.Builder<
            UpdateLoggingServerRequest, LoggingServer, OperationMetadata>
        updateLoggingServerOperationSettings;
    private final UnaryCallSettings.Builder<DeleteLoggingServerRequest, Operation>
        deleteLoggingServerSettings;
    private final OperationCallSettings.Builder<
            DeleteLoggingServerRequest, Empty, OperationMetadata>
        deleteLoggingServerOperationSettings;
    private final PagedCallSettings.Builder<
            ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>
        listNodeTypesSettings;
    private final UnaryCallSettings.Builder<GetNodeTypeRequest, NodeType> getNodeTypeSettings;
    private final UnaryCallSettings.Builder<ShowNsxCredentialsRequest, Credentials>
        showNsxCredentialsSettings;
    private final UnaryCallSettings.Builder<ShowVcenterCredentialsRequest, Credentials>
        showVcenterCredentialsSettings;
    private final UnaryCallSettings.Builder<ResetNsxCredentialsRequest, Operation>
        resetNsxCredentialsSettings;
    private final OperationCallSettings.Builder<
            ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
        resetNsxCredentialsOperationSettings;
    private final UnaryCallSettings.Builder<ResetVcenterCredentialsRequest, Operation>
        resetVcenterCredentialsSettings;
    private final OperationCallSettings.Builder<
            ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
        resetVcenterCredentialsOperationSettings;
    private final UnaryCallSettings.Builder<GetDnsForwardingRequest, DnsForwarding>
        getDnsForwardingSettings;
    private final UnaryCallSettings.Builder<UpdateDnsForwardingRequest, Operation>
        updateDnsForwardingSettings;
    private final OperationCallSettings.Builder<
            UpdateDnsForwardingRequest, DnsForwarding, OperationMetadata>
        updateDnsForwardingOperationSettings;
    private final UnaryCallSettings.Builder<GetNetworkPeeringRequest, NetworkPeering>
        getNetworkPeeringSettings;
    private final PagedCallSettings.Builder<
            ListNetworkPeeringsRequest,
            ListNetworkPeeringsResponse,
            ListNetworkPeeringsPagedResponse>
        listNetworkPeeringsSettings;
    private final UnaryCallSettings.Builder<CreateNetworkPeeringRequest, Operation>
        createNetworkPeeringSettings;
    private final OperationCallSettings.Builder<
            CreateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
        createNetworkPeeringOperationSettings;
    private final UnaryCallSettings.Builder<DeleteNetworkPeeringRequest, Operation>
        deleteNetworkPeeringSettings;
    private final OperationCallSettings.Builder<
            DeleteNetworkPeeringRequest, Empty, OperationMetadata>
        deleteNetworkPeeringOperationSettings;
    private final UnaryCallSettings.Builder<UpdateNetworkPeeringRequest, Operation>
        updateNetworkPeeringSettings;
    private final OperationCallSettings.Builder<
            UpdateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
        updateNetworkPeeringOperationSettings;
    private final PagedCallSettings.Builder<
            ListPeeringRoutesRequest, ListPeeringRoutesResponse, ListPeeringRoutesPagedResponse>
        listPeeringRoutesSettings;
    private final UnaryCallSettings.Builder<CreateHcxActivationKeyRequest, Operation>
        createHcxActivationKeySettings;
    private final OperationCallSettings.Builder<
            CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
        createHcxActivationKeyOperationSettings;
    private final PagedCallSettings.Builder<
            ListHcxActivationKeysRequest,
            ListHcxActivationKeysResponse,
            ListHcxActivationKeysPagedResponse>
        listHcxActivationKeysSettings;
    private final UnaryCallSettings.Builder<GetHcxActivationKeyRequest, HcxActivationKey>
        getHcxActivationKeySettings;
    private final UnaryCallSettings.Builder<GetNetworkPolicyRequest, NetworkPolicy>
        getNetworkPolicySettings;
    private final PagedCallSettings.Builder<
            ListNetworkPoliciesRequest,
            ListNetworkPoliciesResponse,
            ListNetworkPoliciesPagedResponse>
        listNetworkPoliciesSettings;
    private final UnaryCallSettings.Builder<CreateNetworkPolicyRequest, Operation>
        createNetworkPolicySettings;
    private final OperationCallSettings.Builder<
            CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
        createNetworkPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateNetworkPolicyRequest, Operation>
        updateNetworkPolicySettings;
    private final OperationCallSettings.Builder<
            UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
        updateNetworkPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteNetworkPolicyRequest, Operation>
        deleteNetworkPolicySettings;
    private final OperationCallSettings.Builder<
            DeleteNetworkPolicyRequest, Empty, OperationMetadata>
        deleteNetworkPolicyOperationSettings;
    private final PagedCallSettings.Builder<
            ListManagementDnsZoneBindingsRequest,
            ListManagementDnsZoneBindingsResponse,
            ListManagementDnsZoneBindingsPagedResponse>
        listManagementDnsZoneBindingsSettings;
    private final UnaryCallSettings.Builder<
            GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
        getManagementDnsZoneBindingSettings;
    private final UnaryCallSettings.Builder<CreateManagementDnsZoneBindingRequest, Operation>
        createManagementDnsZoneBindingSettings;
    private final OperationCallSettings.Builder<
            CreateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
        createManagementDnsZoneBindingOperationSettings;
    private final UnaryCallSettings.Builder<UpdateManagementDnsZoneBindingRequest, Operation>
        updateManagementDnsZoneBindingSettings;
    private final OperationCallSettings.Builder<
            UpdateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
        updateManagementDnsZoneBindingOperationSettings;
    private final UnaryCallSettings.Builder<DeleteManagementDnsZoneBindingRequest, Operation>
        deleteManagementDnsZoneBindingSettings;
    private final OperationCallSettings.Builder<
            DeleteManagementDnsZoneBindingRequest, Empty, OperationMetadata>
        deleteManagementDnsZoneBindingOperationSettings;
    private final UnaryCallSettings.Builder<RepairManagementDnsZoneBindingRequest, Operation>
        repairManagementDnsZoneBindingSettings;
    private final OperationCallSettings.Builder<
            RepairManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
        repairManagementDnsZoneBindingOperationSettings;
    private final UnaryCallSettings.Builder<CreateVmwareEngineNetworkRequest, Operation>
        createVmwareEngineNetworkSettings;
    private final OperationCallSettings.Builder<
            CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
        createVmwareEngineNetworkOperationSettings;
    private final UnaryCallSettings.Builder<UpdateVmwareEngineNetworkRequest, Operation>
        updateVmwareEngineNetworkSettings;
    private final OperationCallSettings.Builder<
            UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
        updateVmwareEngineNetworkOperationSettings;
    private final UnaryCallSettings.Builder<DeleteVmwareEngineNetworkRequest, Operation>
        deleteVmwareEngineNetworkSettings;
    private final OperationCallSettings.Builder<
            DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
        deleteVmwareEngineNetworkOperationSettings;
    private final UnaryCallSettings.Builder<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
        getVmwareEngineNetworkSettings;
    private final PagedCallSettings.Builder<
            ListVmwareEngineNetworksRequest,
            ListVmwareEngineNetworksResponse,
            ListVmwareEngineNetworksPagedResponse>
        listVmwareEngineNetworksSettings;
    private final UnaryCallSettings.Builder<CreatePrivateConnectionRequest, Operation>
        createPrivateConnectionSettings;
    private final OperationCallSettings.Builder<
            CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
        createPrivateConnectionOperationSettings;
    private final UnaryCallSettings.Builder<GetPrivateConnectionRequest, PrivateConnection>
        getPrivateConnectionSettings;
    private final PagedCallSettings.Builder<
            ListPrivateConnectionsRequest,
            ListPrivateConnectionsResponse,
            ListPrivateConnectionsPagedResponse>
        listPrivateConnectionsSettings;
    private final UnaryCallSettings.Builder<UpdatePrivateConnectionRequest, Operation>
        updatePrivateConnectionSettings;
    private final OperationCallSettings.Builder<
            UpdatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
        updatePrivateConnectionOperationSettings;
    private final UnaryCallSettings.Builder<DeletePrivateConnectionRequest, Operation>
        deletePrivateConnectionSettings;
    private final OperationCallSettings.Builder<
            DeletePrivateConnectionRequest, Empty, OperationMetadata>
        deletePrivateConnectionOperationSettings;
    private final PagedCallSettings.Builder<
            ListPrivateConnectionPeeringRoutesRequest,
            ListPrivateConnectionPeeringRoutesResponse,
            ListPrivateConnectionPeeringRoutesPagedResponse>
        listPrivateConnectionPeeringRoutesSettings;
    private final UnaryCallSettings.Builder<GrantDnsBindPermissionRequest, Operation>
        grantDnsBindPermissionSettings;
    private final OperationCallSettings.Builder<
            GrantDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
        grantDnsBindPermissionOperationSettings;
    private final UnaryCallSettings.Builder<GetDnsBindPermissionRequest, DnsBindPermission>
        getDnsBindPermissionSettings;
    private final UnaryCallSettings.Builder<RevokeDnsBindPermissionRequest, Operation>
        revokeDnsBindPermissionSettings;
    private final OperationCallSettings.Builder<
            RevokeDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
        revokeDnsBindPermissionOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(120000L))
              .setTotalTimeout(Duration.ofMillis(120000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(120000L))
              .setTotalTimeout(Duration.ofMillis(120000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listPrivateCloudsSettings = PagedCallSettings.newBuilder(LIST_PRIVATE_CLOUDS_PAGE_STR_FACT);
      getPrivateCloudSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPrivateCloudSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPrivateCloudOperationSettings = OperationCallSettings.newBuilder();
      updatePrivateCloudSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePrivateCloudOperationSettings = OperationCallSettings.newBuilder();
      deletePrivateCloudSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePrivateCloudOperationSettings = OperationCallSettings.newBuilder();
      undeletePrivateCloudSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeletePrivateCloudOperationSettings = OperationCallSettings.newBuilder();
      listClustersSettings = PagedCallSettings.newBuilder(LIST_CLUSTERS_PAGE_STR_FACT);
      getClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClusterOperationSettings = OperationCallSettings.newBuilder();
      updateClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateClusterOperationSettings = OperationCallSettings.newBuilder();
      deleteClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteClusterOperationSettings = OperationCallSettings.newBuilder();
      listNodesSettings = PagedCallSettings.newBuilder(LIST_NODES_PAGE_STR_FACT);
      getNodeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listExternalAddressesSettings =
          PagedCallSettings.newBuilder(LIST_EXTERNAL_ADDRESSES_PAGE_STR_FACT);
      fetchNetworkPolicyExternalAddressesSettings =
          PagedCallSettings.newBuilder(FETCH_NETWORK_POLICY_EXTERNAL_ADDRESSES_PAGE_STR_FACT);
      getExternalAddressSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createExternalAddressSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createExternalAddressOperationSettings = OperationCallSettings.newBuilder();
      updateExternalAddressSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateExternalAddressOperationSettings = OperationCallSettings.newBuilder();
      deleteExternalAddressSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteExternalAddressOperationSettings = OperationCallSettings.newBuilder();
      listSubnetsSettings = PagedCallSettings.newBuilder(LIST_SUBNETS_PAGE_STR_FACT);
      getSubnetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSubnetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSubnetOperationSettings = OperationCallSettings.newBuilder();
      listExternalAccessRulesSettings =
          PagedCallSettings.newBuilder(LIST_EXTERNAL_ACCESS_RULES_PAGE_STR_FACT);
      getExternalAccessRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createExternalAccessRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createExternalAccessRuleOperationSettings = OperationCallSettings.newBuilder();
      updateExternalAccessRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateExternalAccessRuleOperationSettings = OperationCallSettings.newBuilder();
      deleteExternalAccessRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteExternalAccessRuleOperationSettings = OperationCallSettings.newBuilder();
      listLoggingServersSettings = PagedCallSettings.newBuilder(LIST_LOGGING_SERVERS_PAGE_STR_FACT);
      getLoggingServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createLoggingServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createLoggingServerOperationSettings = OperationCallSettings.newBuilder();
      updateLoggingServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateLoggingServerOperationSettings = OperationCallSettings.newBuilder();
      deleteLoggingServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteLoggingServerOperationSettings = OperationCallSettings.newBuilder();
      listNodeTypesSettings = PagedCallSettings.newBuilder(LIST_NODE_TYPES_PAGE_STR_FACT);
      getNodeTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      showNsxCredentialsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      showVcenterCredentialsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetNsxCredentialsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetNsxCredentialsOperationSettings = OperationCallSettings.newBuilder();
      resetVcenterCredentialsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetVcenterCredentialsOperationSettings = OperationCallSettings.newBuilder();
      getDnsForwardingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDnsForwardingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDnsForwardingOperationSettings = OperationCallSettings.newBuilder();
      getNetworkPeeringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listNetworkPeeringsSettings =
          PagedCallSettings.newBuilder(LIST_NETWORK_PEERINGS_PAGE_STR_FACT);
      createNetworkPeeringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createNetworkPeeringOperationSettings = OperationCallSettings.newBuilder();
      deleteNetworkPeeringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNetworkPeeringOperationSettings = OperationCallSettings.newBuilder();
      updateNetworkPeeringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNetworkPeeringOperationSettings = OperationCallSettings.newBuilder();
      listPeeringRoutesSettings = PagedCallSettings.newBuilder(LIST_PEERING_ROUTES_PAGE_STR_FACT);
      createHcxActivationKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHcxActivationKeyOperationSettings = OperationCallSettings.newBuilder();
      listHcxActivationKeysSettings =
          PagedCallSettings.newBuilder(LIST_HCX_ACTIVATION_KEYS_PAGE_STR_FACT);
      getHcxActivationKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getNetworkPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listNetworkPoliciesSettings =
          PagedCallSettings.newBuilder(LIST_NETWORK_POLICIES_PAGE_STR_FACT);
      createNetworkPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createNetworkPolicyOperationSettings = OperationCallSettings.newBuilder();
      updateNetworkPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNetworkPolicyOperationSettings = OperationCallSettings.newBuilder();
      deleteNetworkPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNetworkPolicyOperationSettings = OperationCallSettings.newBuilder();
      listManagementDnsZoneBindingsSettings =
          PagedCallSettings.newBuilder(LIST_MANAGEMENT_DNS_ZONE_BINDINGS_PAGE_STR_FACT);
      getManagementDnsZoneBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createManagementDnsZoneBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createManagementDnsZoneBindingOperationSettings = OperationCallSettings.newBuilder();
      updateManagementDnsZoneBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateManagementDnsZoneBindingOperationSettings = OperationCallSettings.newBuilder();
      deleteManagementDnsZoneBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteManagementDnsZoneBindingOperationSettings = OperationCallSettings.newBuilder();
      repairManagementDnsZoneBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      repairManagementDnsZoneBindingOperationSettings = OperationCallSettings.newBuilder();
      createVmwareEngineNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createVmwareEngineNetworkOperationSettings = OperationCallSettings.newBuilder();
      updateVmwareEngineNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateVmwareEngineNetworkOperationSettings = OperationCallSettings.newBuilder();
      deleteVmwareEngineNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteVmwareEngineNetworkOperationSettings = OperationCallSettings.newBuilder();
      getVmwareEngineNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listVmwareEngineNetworksSettings =
          PagedCallSettings.newBuilder(LIST_VMWARE_ENGINE_NETWORKS_PAGE_STR_FACT);
      createPrivateConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPrivateConnectionOperationSettings = OperationCallSettings.newBuilder();
      getPrivateConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPrivateConnectionsSettings =
          PagedCallSettings.newBuilder(LIST_PRIVATE_CONNECTIONS_PAGE_STR_FACT);
      updatePrivateConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePrivateConnectionOperationSettings = OperationCallSettings.newBuilder();
      deletePrivateConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePrivateConnectionOperationSettings = OperationCallSettings.newBuilder();
      listPrivateConnectionPeeringRoutesSettings =
          PagedCallSettings.newBuilder(LIST_PRIVATE_CONNECTION_PEERING_ROUTES_PAGE_STR_FACT);
      grantDnsBindPermissionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      grantDnsBindPermissionOperationSettings = OperationCallSettings.newBuilder();
      getDnsBindPermissionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      revokeDnsBindPermissionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      revokeDnsBindPermissionOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listPrivateCloudsSettings,
              getPrivateCloudSettings,
              createPrivateCloudSettings,
              updatePrivateCloudSettings,
              deletePrivateCloudSettings,
              undeletePrivateCloudSettings,
              listClustersSettings,
              getClusterSettings,
              createClusterSettings,
              updateClusterSettings,
              deleteClusterSettings,
              listNodesSettings,
              getNodeSettings,
              listExternalAddressesSettings,
              fetchNetworkPolicyExternalAddressesSettings,
              getExternalAddressSettings,
              createExternalAddressSettings,
              updateExternalAddressSettings,
              deleteExternalAddressSettings,
              listSubnetsSettings,
              getSubnetSettings,
              updateSubnetSettings,
              listExternalAccessRulesSettings,
              getExternalAccessRuleSettings,
              createExternalAccessRuleSettings,
              updateExternalAccessRuleSettings,
              deleteExternalAccessRuleSettings,
              listLoggingServersSettings,
              getLoggingServerSettings,
              createLoggingServerSettings,
              updateLoggingServerSettings,
              deleteLoggingServerSettings,
              listNodeTypesSettings,
              getNodeTypeSettings,
              showNsxCredentialsSettings,
              showVcenterCredentialsSettings,
              resetNsxCredentialsSettings,
              resetVcenterCredentialsSettings,
              getDnsForwardingSettings,
              updateDnsForwardingSettings,
              getNetworkPeeringSettings,
              listNetworkPeeringsSettings,
              createNetworkPeeringSettings,
              deleteNetworkPeeringSettings,
              updateNetworkPeeringSettings,
              listPeeringRoutesSettings,
              createHcxActivationKeySettings,
              listHcxActivationKeysSettings,
              getHcxActivationKeySettings,
              getNetworkPolicySettings,
              listNetworkPoliciesSettings,
              createNetworkPolicySettings,
              updateNetworkPolicySettings,
              deleteNetworkPolicySettings,
              listManagementDnsZoneBindingsSettings,
              getManagementDnsZoneBindingSettings,
              createManagementDnsZoneBindingSettings,
              updateManagementDnsZoneBindingSettings,
              deleteManagementDnsZoneBindingSettings,
              repairManagementDnsZoneBindingSettings,
              createVmwareEngineNetworkSettings,
              updateVmwareEngineNetworkSettings,
              deleteVmwareEngineNetworkSettings,
              getVmwareEngineNetworkSettings,
              listVmwareEngineNetworksSettings,
              createPrivateConnectionSettings,
              getPrivateConnectionSettings,
              listPrivateConnectionsSettings,
              updatePrivateConnectionSettings,
              deletePrivateConnectionSettings,
              listPrivateConnectionPeeringRoutesSettings,
              grantDnsBindPermissionSettings,
              getDnsBindPermissionSettings,
              revokeDnsBindPermissionSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(VmwareEngineStubSettings settings) {
      super(settings);

      listPrivateCloudsSettings = settings.listPrivateCloudsSettings.toBuilder();
      getPrivateCloudSettings = settings.getPrivateCloudSettings.toBuilder();
      createPrivateCloudSettings = settings.createPrivateCloudSettings.toBuilder();
      createPrivateCloudOperationSettings =
          settings.createPrivateCloudOperationSettings.toBuilder();
      updatePrivateCloudSettings = settings.updatePrivateCloudSettings.toBuilder();
      updatePrivateCloudOperationSettings =
          settings.updatePrivateCloudOperationSettings.toBuilder();
      deletePrivateCloudSettings = settings.deletePrivateCloudSettings.toBuilder();
      deletePrivateCloudOperationSettings =
          settings.deletePrivateCloudOperationSettings.toBuilder();
      undeletePrivateCloudSettings = settings.undeletePrivateCloudSettings.toBuilder();
      undeletePrivateCloudOperationSettings =
          settings.undeletePrivateCloudOperationSettings.toBuilder();
      listClustersSettings = settings.listClustersSettings.toBuilder();
      getClusterSettings = settings.getClusterSettings.toBuilder();
      createClusterSettings = settings.createClusterSettings.toBuilder();
      createClusterOperationSettings = settings.createClusterOperationSettings.toBuilder();
      updateClusterSettings = settings.updateClusterSettings.toBuilder();
      updateClusterOperationSettings = settings.updateClusterOperationSettings.toBuilder();
      deleteClusterSettings = settings.deleteClusterSettings.toBuilder();
      deleteClusterOperationSettings = settings.deleteClusterOperationSettings.toBuilder();
      listNodesSettings = settings.listNodesSettings.toBuilder();
      getNodeSettings = settings.getNodeSettings.toBuilder();
      listExternalAddressesSettings = settings.listExternalAddressesSettings.toBuilder();
      fetchNetworkPolicyExternalAddressesSettings =
          settings.fetchNetworkPolicyExternalAddressesSettings.toBuilder();
      getExternalAddressSettings = settings.getExternalAddressSettings.toBuilder();
      createExternalAddressSettings = settings.createExternalAddressSettings.toBuilder();
      createExternalAddressOperationSettings =
          settings.createExternalAddressOperationSettings.toBuilder();
      updateExternalAddressSettings = settings.updateExternalAddressSettings.toBuilder();
      updateExternalAddressOperationSettings =
          settings.updateExternalAddressOperationSettings.toBuilder();
      deleteExternalAddressSettings = settings.deleteExternalAddressSettings.toBuilder();
      deleteExternalAddressOperationSettings =
          settings.deleteExternalAddressOperationSettings.toBuilder();
      listSubnetsSettings = settings.listSubnetsSettings.toBuilder();
      getSubnetSettings = settings.getSubnetSettings.toBuilder();
      updateSubnetSettings = settings.updateSubnetSettings.toBuilder();
      updateSubnetOperationSettings = settings.updateSubnetOperationSettings.toBuilder();
      listExternalAccessRulesSettings = settings.listExternalAccessRulesSettings.toBuilder();
      getExternalAccessRuleSettings = settings.getExternalAccessRuleSettings.toBuilder();
      createExternalAccessRuleSettings = settings.createExternalAccessRuleSettings.toBuilder();
      createExternalAccessRuleOperationSettings =
          settings.createExternalAccessRuleOperationSettings.toBuilder();
      updateExternalAccessRuleSettings = settings.updateExternalAccessRuleSettings.toBuilder();
      updateExternalAccessRuleOperationSettings =
          settings.updateExternalAccessRuleOperationSettings.toBuilder();
      deleteExternalAccessRuleSettings = settings.deleteExternalAccessRuleSettings.toBuilder();
      deleteExternalAccessRuleOperationSettings =
          settings.deleteExternalAccessRuleOperationSettings.toBuilder();
      listLoggingServersSettings = settings.listLoggingServersSettings.toBuilder();
      getLoggingServerSettings = settings.getLoggingServerSettings.toBuilder();
      createLoggingServerSettings = settings.createLoggingServerSettings.toBuilder();
      createLoggingServerOperationSettings =
          settings.createLoggingServerOperationSettings.toBuilder();
      updateLoggingServerSettings = settings.updateLoggingServerSettings.toBuilder();
      updateLoggingServerOperationSettings =
          settings.updateLoggingServerOperationSettings.toBuilder();
      deleteLoggingServerSettings = settings.deleteLoggingServerSettings.toBuilder();
      deleteLoggingServerOperationSettings =
          settings.deleteLoggingServerOperationSettings.toBuilder();
      listNodeTypesSettings = settings.listNodeTypesSettings.toBuilder();
      getNodeTypeSettings = settings.getNodeTypeSettings.toBuilder();
      showNsxCredentialsSettings = settings.showNsxCredentialsSettings.toBuilder();
      showVcenterCredentialsSettings = settings.showVcenterCredentialsSettings.toBuilder();
      resetNsxCredentialsSettings = settings.resetNsxCredentialsSettings.toBuilder();
      resetNsxCredentialsOperationSettings =
          settings.resetNsxCredentialsOperationSettings.toBuilder();
      resetVcenterCredentialsSettings = settings.resetVcenterCredentialsSettings.toBuilder();
      resetVcenterCredentialsOperationSettings =
          settings.resetVcenterCredentialsOperationSettings.toBuilder();
      getDnsForwardingSettings = settings.getDnsForwardingSettings.toBuilder();
      updateDnsForwardingSettings = settings.updateDnsForwardingSettings.toBuilder();
      updateDnsForwardingOperationSettings =
          settings.updateDnsForwardingOperationSettings.toBuilder();
      getNetworkPeeringSettings = settings.getNetworkPeeringSettings.toBuilder();
      listNetworkPeeringsSettings = settings.listNetworkPeeringsSettings.toBuilder();
      createNetworkPeeringSettings = settings.createNetworkPeeringSettings.toBuilder();
      createNetworkPeeringOperationSettings =
          settings.createNetworkPeeringOperationSettings.toBuilder();
      deleteNetworkPeeringSettings = settings.deleteNetworkPeeringSettings.toBuilder();
      deleteNetworkPeeringOperationSettings =
          settings.deleteNetworkPeeringOperationSettings.toBuilder();
      updateNetworkPeeringSettings = settings.updateNetworkPeeringSettings.toBuilder();
      updateNetworkPeeringOperationSettings =
          settings.updateNetworkPeeringOperationSettings.toBuilder();
      listPeeringRoutesSettings = settings.listPeeringRoutesSettings.toBuilder();
      createHcxActivationKeySettings = settings.createHcxActivationKeySettings.toBuilder();
      createHcxActivationKeyOperationSettings =
          settings.createHcxActivationKeyOperationSettings.toBuilder();
      listHcxActivationKeysSettings = settings.listHcxActivationKeysSettings.toBuilder();
      getHcxActivationKeySettings = settings.getHcxActivationKeySettings.toBuilder();
      getNetworkPolicySettings = settings.getNetworkPolicySettings.toBuilder();
      listNetworkPoliciesSettings = settings.listNetworkPoliciesSettings.toBuilder();
      createNetworkPolicySettings = settings.createNetworkPolicySettings.toBuilder();
      createNetworkPolicyOperationSettings =
          settings.createNetworkPolicyOperationSettings.toBuilder();
      updateNetworkPolicySettings = settings.updateNetworkPolicySettings.toBuilder();
      updateNetworkPolicyOperationSettings =
          settings.updateNetworkPolicyOperationSettings.toBuilder();
      deleteNetworkPolicySettings = settings.deleteNetworkPolicySettings.toBuilder();
      deleteNetworkPolicyOperationSettings =
          settings.deleteNetworkPolicyOperationSettings.toBuilder();
      listManagementDnsZoneBindingsSettings =
          settings.listManagementDnsZoneBindingsSettings.toBuilder();
      getManagementDnsZoneBindingSettings =
          settings.getManagementDnsZoneBindingSettings.toBuilder();
      createManagementDnsZoneBindingSettings =
          settings.createManagementDnsZoneBindingSettings.toBuilder();
      createManagementDnsZoneBindingOperationSettings =
          settings.createManagementDnsZoneBindingOperationSettings.toBuilder();
      updateManagementDnsZoneBindingSettings =
          settings.updateManagementDnsZoneBindingSettings.toBuilder();
      updateManagementDnsZoneBindingOperationSettings =
          settings.updateManagementDnsZoneBindingOperationSettings.toBuilder();
      deleteManagementDnsZoneBindingSettings =
          settings.deleteManagementDnsZoneBindingSettings.toBuilder();
      deleteManagementDnsZoneBindingOperationSettings =
          settings.deleteManagementDnsZoneBindingOperationSettings.toBuilder();
      repairManagementDnsZoneBindingSettings =
          settings.repairManagementDnsZoneBindingSettings.toBuilder();
      repairManagementDnsZoneBindingOperationSettings =
          settings.repairManagementDnsZoneBindingOperationSettings.toBuilder();
      createVmwareEngineNetworkSettings = settings.createVmwareEngineNetworkSettings.toBuilder();
      createVmwareEngineNetworkOperationSettings =
          settings.createVmwareEngineNetworkOperationSettings.toBuilder();
      updateVmwareEngineNetworkSettings = settings.updateVmwareEngineNetworkSettings.toBuilder();
      updateVmwareEngineNetworkOperationSettings =
          settings.updateVmwareEngineNetworkOperationSettings.toBuilder();
      deleteVmwareEngineNetworkSettings = settings.deleteVmwareEngineNetworkSettings.toBuilder();
      deleteVmwareEngineNetworkOperationSettings =
          settings.deleteVmwareEngineNetworkOperationSettings.toBuilder();
      getVmwareEngineNetworkSettings = settings.getVmwareEngineNetworkSettings.toBuilder();
      listVmwareEngineNetworksSettings = settings.listVmwareEngineNetworksSettings.toBuilder();
      createPrivateConnectionSettings = settings.createPrivateConnectionSettings.toBuilder();
      createPrivateConnectionOperationSettings =
          settings.createPrivateConnectionOperationSettings.toBuilder();
      getPrivateConnectionSettings = settings.getPrivateConnectionSettings.toBuilder();
      listPrivateConnectionsSettings = settings.listPrivateConnectionsSettings.toBuilder();
      updatePrivateConnectionSettings = settings.updatePrivateConnectionSettings.toBuilder();
      updatePrivateConnectionOperationSettings =
          settings.updatePrivateConnectionOperationSettings.toBuilder();
      deletePrivateConnectionSettings = settings.deletePrivateConnectionSettings.toBuilder();
      deletePrivateConnectionOperationSettings =
          settings.deletePrivateConnectionOperationSettings.toBuilder();
      listPrivateConnectionPeeringRoutesSettings =
          settings.listPrivateConnectionPeeringRoutesSettings.toBuilder();
      grantDnsBindPermissionSettings = settings.grantDnsBindPermissionSettings.toBuilder();
      grantDnsBindPermissionOperationSettings =
          settings.grantDnsBindPermissionOperationSettings.toBuilder();
      getDnsBindPermissionSettings = settings.getDnsBindPermissionSettings.toBuilder();
      revokeDnsBindPermissionSettings = settings.revokeDnsBindPermissionSettings.toBuilder();
      revokeDnsBindPermissionOperationSettings =
          settings.revokeDnsBindPermissionOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listPrivateCloudsSettings,
              getPrivateCloudSettings,
              createPrivateCloudSettings,
              updatePrivateCloudSettings,
              deletePrivateCloudSettings,
              undeletePrivateCloudSettings,
              listClustersSettings,
              getClusterSettings,
              createClusterSettings,
              updateClusterSettings,
              deleteClusterSettings,
              listNodesSettings,
              getNodeSettings,
              listExternalAddressesSettings,
              fetchNetworkPolicyExternalAddressesSettings,
              getExternalAddressSettings,
              createExternalAddressSettings,
              updateExternalAddressSettings,
              deleteExternalAddressSettings,
              listSubnetsSettings,
              getSubnetSettings,
              updateSubnetSettings,
              listExternalAccessRulesSettings,
              getExternalAccessRuleSettings,
              createExternalAccessRuleSettings,
              updateExternalAccessRuleSettings,
              deleteExternalAccessRuleSettings,
              listLoggingServersSettings,
              getLoggingServerSettings,
              createLoggingServerSettings,
              updateLoggingServerSettings,
              deleteLoggingServerSettings,
              listNodeTypesSettings,
              getNodeTypeSettings,
              showNsxCredentialsSettings,
              showVcenterCredentialsSettings,
              resetNsxCredentialsSettings,
              resetVcenterCredentialsSettings,
              getDnsForwardingSettings,
              updateDnsForwardingSettings,
              getNetworkPeeringSettings,
              listNetworkPeeringsSettings,
              createNetworkPeeringSettings,
              deleteNetworkPeeringSettings,
              updateNetworkPeeringSettings,
              listPeeringRoutesSettings,
              createHcxActivationKeySettings,
              listHcxActivationKeysSettings,
              getHcxActivationKeySettings,
              getNetworkPolicySettings,
              listNetworkPoliciesSettings,
              createNetworkPolicySettings,
              updateNetworkPolicySettings,
              deleteNetworkPolicySettings,
              listManagementDnsZoneBindingsSettings,
              getManagementDnsZoneBindingSettings,
              createManagementDnsZoneBindingSettings,
              updateManagementDnsZoneBindingSettings,
              deleteManagementDnsZoneBindingSettings,
              repairManagementDnsZoneBindingSettings,
              createVmwareEngineNetworkSettings,
              updateVmwareEngineNetworkSettings,
              deleteVmwareEngineNetworkSettings,
              getVmwareEngineNetworkSettings,
              listVmwareEngineNetworksSettings,
              createPrivateConnectionSettings,
              getPrivateConnectionSettings,
              listPrivateConnectionsSettings,
              updatePrivateConnectionSettings,
              deletePrivateConnectionSettings,
              listPrivateConnectionPeeringRoutesSettings,
              grantDnsBindPermissionSettings,
              getDnsBindPermissionSettings,
              revokeDnsBindPermissionSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listPrivateCloudsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPrivateCloudSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPrivateCloudSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updatePrivateCloudSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deletePrivateCloudSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .undeletePrivateCloudSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listNodesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getNodeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listExternalAddressesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchNetworkPolicyExternalAddressesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getExternalAddressSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createExternalAddressSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateExternalAddressSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteExternalAddressSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listSubnetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSubnetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSubnetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listExternalAccessRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getExternalAccessRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createExternalAccessRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateExternalAccessRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteExternalAccessRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listLoggingServersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLoggingServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createLoggingServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateLoggingServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteLoggingServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listNodeTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getNodeTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .showNsxCredentialsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .showVcenterCredentialsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .resetNsxCredentialsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .resetVcenterCredentialsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getDnsForwardingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDnsForwardingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getNetworkPeeringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listNetworkPeeringsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createNetworkPeeringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteNetworkPeeringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateNetworkPeeringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listPeeringRoutesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createHcxActivationKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listHcxActivationKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getHcxActivationKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getNetworkPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listNetworkPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createNetworkPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateNetworkPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteNetworkPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listManagementDnsZoneBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getManagementDnsZoneBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createManagementDnsZoneBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateManagementDnsZoneBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteManagementDnsZoneBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .repairManagementDnsZoneBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .createVmwareEngineNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateVmwareEngineNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteVmwareEngineNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getVmwareEngineNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listVmwareEngineNetworksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPrivateConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getPrivateConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPrivateConnectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updatePrivateConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deletePrivateConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listPrivateConnectionPeeringRoutesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .grantDnsBindPermissionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getDnsBindPermissionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .revokeDnsBindPermissionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .createPrivateCloudOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePrivateCloudRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateCloud.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updatePrivateCloudOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePrivateCloudRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateCloud.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deletePrivateCloudOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePrivateCloudRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateCloud.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .undeletePrivateCloudOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeletePrivateCloudRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateCloud.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Cluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Cluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createExternalAddressOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateExternalAddressRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExternalAddress.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateExternalAddressOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateExternalAddressRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExternalAddress.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteExternalAddressOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteExternalAddressRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateSubnetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateSubnetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Subnet.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createExternalAccessRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateExternalAccessRuleRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExternalAccessRule.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateExternalAccessRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateExternalAccessRuleRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExternalAccessRule.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteExternalAccessRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteExternalAccessRuleRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createLoggingServerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateLoggingServerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(LoggingServer.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateLoggingServerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateLoggingServerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(LoggingServer.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteLoggingServerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteLoggingServerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .resetNsxCredentialsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResetNsxCredentialsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateCloud.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .resetVcenterCredentialsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResetVcenterCredentialsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateCloud.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateDnsForwardingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDnsForwardingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DnsForwarding.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createNetworkPeeringOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateNetworkPeeringRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(NetworkPeering.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteNetworkPeeringOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteNetworkPeeringRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateNetworkPeeringOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateNetworkPeeringRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(NetworkPeering.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createHcxActivationKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateHcxActivationKeyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(HcxActivationKey.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createNetworkPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateNetworkPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(NetworkPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateNetworkPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateNetworkPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(NetworkPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteNetworkPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteNetworkPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createManagementDnsZoneBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateManagementDnsZoneBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ManagementDnsZoneBinding.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateManagementDnsZoneBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateManagementDnsZoneBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ManagementDnsZoneBinding.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteManagementDnsZoneBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteManagementDnsZoneBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .repairManagementDnsZoneBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RepairManagementDnsZoneBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ManagementDnsZoneBinding.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createVmwareEngineNetworkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateVmwareEngineNetworkRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(VmwareEngineNetwork.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateVmwareEngineNetworkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateVmwareEngineNetworkRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(VmwareEngineNetwork.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteVmwareEngineNetworkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteVmwareEngineNetworkRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createPrivateConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePrivateConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateConnection.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updatePrivateConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePrivateConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateConnection.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deletePrivateConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePrivateConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .grantDnsBindPermissionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<GrantDnsBindPermissionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DnsBindPermission.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .revokeDnsBindPermissionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RevokeDnsBindPermissionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DnsBindPermission.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listPrivateClouds. */
    public PagedCallSettings.Builder<
            ListPrivateCloudsRequest, ListPrivateCloudsResponse, ListPrivateCloudsPagedResponse>
        listPrivateCloudsSettings() {
      return listPrivateCloudsSettings;
    }

    /** Returns the builder for the settings used for calls to getPrivateCloud. */
    public UnaryCallSettings.Builder<GetPrivateCloudRequest, PrivateCloud>
        getPrivateCloudSettings() {
      return getPrivateCloudSettings;
    }

    /** Returns the builder for the settings used for calls to createPrivateCloud. */
    public UnaryCallSettings.Builder<CreatePrivateCloudRequest, Operation>
        createPrivateCloudSettings() {
      return createPrivateCloudSettings;
    }

    /** Returns the builder for the settings used for calls to createPrivateCloud. */
    public OperationCallSettings.Builder<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
        createPrivateCloudOperationSettings() {
      return createPrivateCloudOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updatePrivateCloud. */
    public UnaryCallSettings.Builder<UpdatePrivateCloudRequest, Operation>
        updatePrivateCloudSettings() {
      return updatePrivateCloudSettings;
    }

    /** Returns the builder for the settings used for calls to updatePrivateCloud. */
    public OperationCallSettings.Builder<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
        updatePrivateCloudOperationSettings() {
      return updatePrivateCloudOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deletePrivateCloud. */
    public UnaryCallSettings.Builder<DeletePrivateCloudRequest, Operation>
        deletePrivateCloudSettings() {
      return deletePrivateCloudSettings;
    }

    /** Returns the builder for the settings used for calls to deletePrivateCloud. */
    public OperationCallSettings.Builder<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
        deletePrivateCloudOperationSettings() {
      return deletePrivateCloudOperationSettings;
    }

    /** Returns the builder for the settings used for calls to undeletePrivateCloud. */
    public UnaryCallSettings.Builder<UndeletePrivateCloudRequest, Operation>
        undeletePrivateCloudSettings() {
      return undeletePrivateCloudSettings;
    }

    /** Returns the builder for the settings used for calls to undeletePrivateCloud. */
    public OperationCallSettings.Builder<
            UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
        undeletePrivateCloudOperationSettings() {
      return undeletePrivateCloudOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listClusters. */
    public PagedCallSettings.Builder<
            ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
        listClustersSettings() {
      return listClustersSettings;
    }

    /** Returns the builder for the settings used for calls to getCluster. */
    public UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings() {
      return getClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings() {
      return createClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public OperationCallSettings.Builder<CreateClusterRequest, Cluster, OperationMetadata>
        createClusterOperationSettings() {
      return createClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings() {
      return updateClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public OperationCallSettings.Builder<UpdateClusterRequest, Cluster, OperationMetadata>
        updateClusterOperationSettings() {
      return updateClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings() {
      return deleteClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public OperationCallSettings.Builder<DeleteClusterRequest, Empty, OperationMetadata>
        deleteClusterOperationSettings() {
      return deleteClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listNodes. */
    public PagedCallSettings.Builder<ListNodesRequest, ListNodesResponse, ListNodesPagedResponse>
        listNodesSettings() {
      return listNodesSettings;
    }

    /** Returns the builder for the settings used for calls to getNode. */
    public UnaryCallSettings.Builder<GetNodeRequest, Node> getNodeSettings() {
      return getNodeSettings;
    }

    /** Returns the builder for the settings used for calls to listExternalAddresses. */
    public PagedCallSettings.Builder<
            ListExternalAddressesRequest,
            ListExternalAddressesResponse,
            ListExternalAddressesPagedResponse>
        listExternalAddressesSettings() {
      return listExternalAddressesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to fetchNetworkPolicyExternalAddresses.
     */
    public PagedCallSettings.Builder<
            FetchNetworkPolicyExternalAddressesRequest,
            FetchNetworkPolicyExternalAddressesResponse,
            FetchNetworkPolicyExternalAddressesPagedResponse>
        fetchNetworkPolicyExternalAddressesSettings() {
      return fetchNetworkPolicyExternalAddressesSettings;
    }

    /** Returns the builder for the settings used for calls to getExternalAddress. */
    public UnaryCallSettings.Builder<GetExternalAddressRequest, ExternalAddress>
        getExternalAddressSettings() {
      return getExternalAddressSettings;
    }

    /** Returns the builder for the settings used for calls to createExternalAddress. */
    public UnaryCallSettings.Builder<CreateExternalAddressRequest, Operation>
        createExternalAddressSettings() {
      return createExternalAddressSettings;
    }

    /** Returns the builder for the settings used for calls to createExternalAddress. */
    public OperationCallSettings.Builder<
            CreateExternalAddressRequest, ExternalAddress, OperationMetadata>
        createExternalAddressOperationSettings() {
      return createExternalAddressOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateExternalAddress. */
    public UnaryCallSettings.Builder<UpdateExternalAddressRequest, Operation>
        updateExternalAddressSettings() {
      return updateExternalAddressSettings;
    }

    /** Returns the builder for the settings used for calls to updateExternalAddress. */
    public OperationCallSettings.Builder<
            UpdateExternalAddressRequest, ExternalAddress, OperationMetadata>
        updateExternalAddressOperationSettings() {
      return updateExternalAddressOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExternalAddress. */
    public UnaryCallSettings.Builder<DeleteExternalAddressRequest, Operation>
        deleteExternalAddressSettings() {
      return deleteExternalAddressSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExternalAddress. */
    public OperationCallSettings.Builder<DeleteExternalAddressRequest, Empty, OperationMetadata>
        deleteExternalAddressOperationSettings() {
      return deleteExternalAddressOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listSubnets. */
    public PagedCallSettings.Builder<
            ListSubnetsRequest, ListSubnetsResponse, ListSubnetsPagedResponse>
        listSubnetsSettings() {
      return listSubnetsSettings;
    }

    /** Returns the builder for the settings used for calls to getSubnet. */
    public UnaryCallSettings.Builder<GetSubnetRequest, Subnet> getSubnetSettings() {
      return getSubnetSettings;
    }

    /** Returns the builder for the settings used for calls to updateSubnet. */
    public UnaryCallSettings.Builder<UpdateSubnetRequest, Operation> updateSubnetSettings() {
      return updateSubnetSettings;
    }

    /** Returns the builder for the settings used for calls to updateSubnet. */
    public OperationCallSettings.Builder<UpdateSubnetRequest, Subnet, OperationMetadata>
        updateSubnetOperationSettings() {
      return updateSubnetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listExternalAccessRules. */
    public PagedCallSettings.Builder<
            ListExternalAccessRulesRequest,
            ListExternalAccessRulesResponse,
            ListExternalAccessRulesPagedResponse>
        listExternalAccessRulesSettings() {
      return listExternalAccessRulesSettings;
    }

    /** Returns the builder for the settings used for calls to getExternalAccessRule. */
    public UnaryCallSettings.Builder<GetExternalAccessRuleRequest, ExternalAccessRule>
        getExternalAccessRuleSettings() {
      return getExternalAccessRuleSettings;
    }

    /** Returns the builder for the settings used for calls to createExternalAccessRule. */
    public UnaryCallSettings.Builder<CreateExternalAccessRuleRequest, Operation>
        createExternalAccessRuleSettings() {
      return createExternalAccessRuleSettings;
    }

    /** Returns the builder for the settings used for calls to createExternalAccessRule. */
    public OperationCallSettings.Builder<
            CreateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
        createExternalAccessRuleOperationSettings() {
      return createExternalAccessRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateExternalAccessRule. */
    public UnaryCallSettings.Builder<UpdateExternalAccessRuleRequest, Operation>
        updateExternalAccessRuleSettings() {
      return updateExternalAccessRuleSettings;
    }

    /** Returns the builder for the settings used for calls to updateExternalAccessRule. */
    public OperationCallSettings.Builder<
            UpdateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
        updateExternalAccessRuleOperationSettings() {
      return updateExternalAccessRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExternalAccessRule. */
    public UnaryCallSettings.Builder<DeleteExternalAccessRuleRequest, Operation>
        deleteExternalAccessRuleSettings() {
      return deleteExternalAccessRuleSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExternalAccessRule. */
    public OperationCallSettings.Builder<DeleteExternalAccessRuleRequest, Empty, OperationMetadata>
        deleteExternalAccessRuleOperationSettings() {
      return deleteExternalAccessRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLoggingServers. */
    public PagedCallSettings.Builder<
            ListLoggingServersRequest, ListLoggingServersResponse, ListLoggingServersPagedResponse>
        listLoggingServersSettings() {
      return listLoggingServersSettings;
    }

    /** Returns the builder for the settings used for calls to getLoggingServer. */
    public UnaryCallSettings.Builder<GetLoggingServerRequest, LoggingServer>
        getLoggingServerSettings() {
      return getLoggingServerSettings;
    }

    /** Returns the builder for the settings used for calls to createLoggingServer. */
    public UnaryCallSettings.Builder<CreateLoggingServerRequest, Operation>
        createLoggingServerSettings() {
      return createLoggingServerSettings;
    }

    /** Returns the builder for the settings used for calls to createLoggingServer. */
    public OperationCallSettings.Builder<
            CreateLoggingServerRequest, LoggingServer, OperationMetadata>
        createLoggingServerOperationSettings() {
      return createLoggingServerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateLoggingServer. */
    public UnaryCallSettings.Builder<UpdateLoggingServerRequest, Operation>
        updateLoggingServerSettings() {
      return updateLoggingServerSettings;
    }

    /** Returns the builder for the settings used for calls to updateLoggingServer. */
    public OperationCallSettings.Builder<
            UpdateLoggingServerRequest, LoggingServer, OperationMetadata>
        updateLoggingServerOperationSettings() {
      return updateLoggingServerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLoggingServer. */
    public UnaryCallSettings.Builder<DeleteLoggingServerRequest, Operation>
        deleteLoggingServerSettings() {
      return deleteLoggingServerSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLoggingServer. */
    public OperationCallSettings.Builder<DeleteLoggingServerRequest, Empty, OperationMetadata>
        deleteLoggingServerOperationSettings() {
      return deleteLoggingServerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listNodeTypes. */
    public PagedCallSettings.Builder<
            ListNodeTypesRequest, ListNodeTypesResponse, ListNodeTypesPagedResponse>
        listNodeTypesSettings() {
      return listNodeTypesSettings;
    }

    /** Returns the builder for the settings used for calls to getNodeType. */
    public UnaryCallSettings.Builder<GetNodeTypeRequest, NodeType> getNodeTypeSettings() {
      return getNodeTypeSettings;
    }

    /** Returns the builder for the settings used for calls to showNsxCredentials. */
    public UnaryCallSettings.Builder<ShowNsxCredentialsRequest, Credentials>
        showNsxCredentialsSettings() {
      return showNsxCredentialsSettings;
    }

    /** Returns the builder for the settings used for calls to showVcenterCredentials. */
    public UnaryCallSettings.Builder<ShowVcenterCredentialsRequest, Credentials>
        showVcenterCredentialsSettings() {
      return showVcenterCredentialsSettings;
    }

    /** Returns the builder for the settings used for calls to resetNsxCredentials. */
    public UnaryCallSettings.Builder<ResetNsxCredentialsRequest, Operation>
        resetNsxCredentialsSettings() {
      return resetNsxCredentialsSettings;
    }

    /** Returns the builder for the settings used for calls to resetNsxCredentials. */
    public OperationCallSettings.Builder<
            ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
        resetNsxCredentialsOperationSettings() {
      return resetNsxCredentialsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to resetVcenterCredentials. */
    public UnaryCallSettings.Builder<ResetVcenterCredentialsRequest, Operation>
        resetVcenterCredentialsSettings() {
      return resetVcenterCredentialsSettings;
    }

    /** Returns the builder for the settings used for calls to resetVcenterCredentials. */
    public OperationCallSettings.Builder<
            ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
        resetVcenterCredentialsOperationSettings() {
      return resetVcenterCredentialsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getDnsForwarding. */
    public UnaryCallSettings.Builder<GetDnsForwardingRequest, DnsForwarding>
        getDnsForwardingSettings() {
      return getDnsForwardingSettings;
    }

    /** Returns the builder for the settings used for calls to updateDnsForwarding. */
    public UnaryCallSettings.Builder<UpdateDnsForwardingRequest, Operation>
        updateDnsForwardingSettings() {
      return updateDnsForwardingSettings;
    }

    /** Returns the builder for the settings used for calls to updateDnsForwarding. */
    public OperationCallSettings.Builder<
            UpdateDnsForwardingRequest, DnsForwarding, OperationMetadata>
        updateDnsForwardingOperationSettings() {
      return updateDnsForwardingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getNetworkPeering. */
    public UnaryCallSettings.Builder<GetNetworkPeeringRequest, NetworkPeering>
        getNetworkPeeringSettings() {
      return getNetworkPeeringSettings;
    }

    /** Returns the builder for the settings used for calls to listNetworkPeerings. */
    public PagedCallSettings.Builder<
            ListNetworkPeeringsRequest,
            ListNetworkPeeringsResponse,
            ListNetworkPeeringsPagedResponse>
        listNetworkPeeringsSettings() {
      return listNetworkPeeringsSettings;
    }

    /** Returns the builder for the settings used for calls to createNetworkPeering. */
    public UnaryCallSettings.Builder<CreateNetworkPeeringRequest, Operation>
        createNetworkPeeringSettings() {
      return createNetworkPeeringSettings;
    }

    /** Returns the builder for the settings used for calls to createNetworkPeering. */
    public OperationCallSettings.Builder<
            CreateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
        createNetworkPeeringOperationSettings() {
      return createNetworkPeeringOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNetworkPeering. */
    public UnaryCallSettings.Builder<DeleteNetworkPeeringRequest, Operation>
        deleteNetworkPeeringSettings() {
      return deleteNetworkPeeringSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNetworkPeering. */
    public OperationCallSettings.Builder<DeleteNetworkPeeringRequest, Empty, OperationMetadata>
        deleteNetworkPeeringOperationSettings() {
      return deleteNetworkPeeringOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateNetworkPeering. */
    public UnaryCallSettings.Builder<UpdateNetworkPeeringRequest, Operation>
        updateNetworkPeeringSettings() {
      return updateNetworkPeeringSettings;
    }

    /** Returns the builder for the settings used for calls to updateNetworkPeering. */
    public OperationCallSettings.Builder<
            UpdateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
        updateNetworkPeeringOperationSettings() {
      return updateNetworkPeeringOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listPeeringRoutes. */
    public PagedCallSettings.Builder<
            ListPeeringRoutesRequest, ListPeeringRoutesResponse, ListPeeringRoutesPagedResponse>
        listPeeringRoutesSettings() {
      return listPeeringRoutesSettings;
    }

    /** Returns the builder for the settings used for calls to createHcxActivationKey. */
    public UnaryCallSettings.Builder<CreateHcxActivationKeyRequest, Operation>
        createHcxActivationKeySettings() {
      return createHcxActivationKeySettings;
    }

    /** Returns the builder for the settings used for calls to createHcxActivationKey. */
    public OperationCallSettings.Builder<
            CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
        createHcxActivationKeyOperationSettings() {
      return createHcxActivationKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listHcxActivationKeys. */
    public PagedCallSettings.Builder<
            ListHcxActivationKeysRequest,
            ListHcxActivationKeysResponse,
            ListHcxActivationKeysPagedResponse>
        listHcxActivationKeysSettings() {
      return listHcxActivationKeysSettings;
    }

    /** Returns the builder for the settings used for calls to getHcxActivationKey. */
    public UnaryCallSettings.Builder<GetHcxActivationKeyRequest, HcxActivationKey>
        getHcxActivationKeySettings() {
      return getHcxActivationKeySettings;
    }

    /** Returns the builder for the settings used for calls to getNetworkPolicy. */
    public UnaryCallSettings.Builder<GetNetworkPolicyRequest, NetworkPolicy>
        getNetworkPolicySettings() {
      return getNetworkPolicySettings;
    }

    /** Returns the builder for the settings used for calls to listNetworkPolicies. */
    public PagedCallSettings.Builder<
            ListNetworkPoliciesRequest,
            ListNetworkPoliciesResponse,
            ListNetworkPoliciesPagedResponse>
        listNetworkPoliciesSettings() {
      return listNetworkPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to createNetworkPolicy. */
    public UnaryCallSettings.Builder<CreateNetworkPolicyRequest, Operation>
        createNetworkPolicySettings() {
      return createNetworkPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createNetworkPolicy. */
    public OperationCallSettings.Builder<
            CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
        createNetworkPolicyOperationSettings() {
      return createNetworkPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateNetworkPolicy. */
    public UnaryCallSettings.Builder<UpdateNetworkPolicyRequest, Operation>
        updateNetworkPolicySettings() {
      return updateNetworkPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateNetworkPolicy. */
    public OperationCallSettings.Builder<
            UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
        updateNetworkPolicyOperationSettings() {
      return updateNetworkPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNetworkPolicy. */
    public UnaryCallSettings.Builder<DeleteNetworkPolicyRequest, Operation>
        deleteNetworkPolicySettings() {
      return deleteNetworkPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteNetworkPolicy. */
    public OperationCallSettings.Builder<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
        deleteNetworkPolicyOperationSettings() {
      return deleteNetworkPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listManagementDnsZoneBindings. */
    public PagedCallSettings.Builder<
            ListManagementDnsZoneBindingsRequest,
            ListManagementDnsZoneBindingsResponse,
            ListManagementDnsZoneBindingsPagedResponse>
        listManagementDnsZoneBindingsSettings() {
      return listManagementDnsZoneBindingsSettings;
    }

    /** Returns the builder for the settings used for calls to getManagementDnsZoneBinding. */
    public UnaryCallSettings.Builder<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
        getManagementDnsZoneBindingSettings() {
      return getManagementDnsZoneBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createManagementDnsZoneBinding. */
    public UnaryCallSettings.Builder<CreateManagementDnsZoneBindingRequest, Operation>
        createManagementDnsZoneBindingSettings() {
      return createManagementDnsZoneBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createManagementDnsZoneBinding. */
    public OperationCallSettings.Builder<
            CreateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
        createManagementDnsZoneBindingOperationSettings() {
      return createManagementDnsZoneBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateManagementDnsZoneBinding. */
    public UnaryCallSettings.Builder<UpdateManagementDnsZoneBindingRequest, Operation>
        updateManagementDnsZoneBindingSettings() {
      return updateManagementDnsZoneBindingSettings;
    }

    /** Returns the builder for the settings used for calls to updateManagementDnsZoneBinding. */
    public OperationCallSettings.Builder<
            UpdateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
        updateManagementDnsZoneBindingOperationSettings() {
      return updateManagementDnsZoneBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteManagementDnsZoneBinding. */
    public UnaryCallSettings.Builder<DeleteManagementDnsZoneBindingRequest, Operation>
        deleteManagementDnsZoneBindingSettings() {
      return deleteManagementDnsZoneBindingSettings;
    }

    /** Returns the builder for the settings used for calls to deleteManagementDnsZoneBinding. */
    public OperationCallSettings.Builder<
            DeleteManagementDnsZoneBindingRequest, Empty, OperationMetadata>
        deleteManagementDnsZoneBindingOperationSettings() {
      return deleteManagementDnsZoneBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to repairManagementDnsZoneBinding. */
    public UnaryCallSettings.Builder<RepairManagementDnsZoneBindingRequest, Operation>
        repairManagementDnsZoneBindingSettings() {
      return repairManagementDnsZoneBindingSettings;
    }

    /** Returns the builder for the settings used for calls to repairManagementDnsZoneBinding. */
    public OperationCallSettings.Builder<
            RepairManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
        repairManagementDnsZoneBindingOperationSettings() {
      return repairManagementDnsZoneBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<CreateVmwareEngineNetworkRequest, Operation>
        createVmwareEngineNetworkSettings() {
      return createVmwareEngineNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to createVmwareEngineNetwork. */
    public OperationCallSettings.Builder<
            CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
        createVmwareEngineNetworkOperationSettings() {
      return createVmwareEngineNetworkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<UpdateVmwareEngineNetworkRequest, Operation>
        updateVmwareEngineNetworkSettings() {
      return updateVmwareEngineNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to updateVmwareEngineNetwork. */
    public OperationCallSettings.Builder<
            UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
        updateVmwareEngineNetworkOperationSettings() {
      return updateVmwareEngineNetworkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<DeleteVmwareEngineNetworkRequest, Operation>
        deleteVmwareEngineNetworkSettings() {
      return deleteVmwareEngineNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVmwareEngineNetwork. */
    public OperationCallSettings.Builder<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
        deleteVmwareEngineNetworkOperationSettings() {
      return deleteVmwareEngineNetworkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getVmwareEngineNetwork. */
    public UnaryCallSettings.Builder<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
        getVmwareEngineNetworkSettings() {
      return getVmwareEngineNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to listVmwareEngineNetworks. */
    public PagedCallSettings.Builder<
            ListVmwareEngineNetworksRequest,
            ListVmwareEngineNetworksResponse,
            ListVmwareEngineNetworksPagedResponse>
        listVmwareEngineNetworksSettings() {
      return listVmwareEngineNetworksSettings;
    }

    /** Returns the builder for the settings used for calls to createPrivateConnection. */
    public UnaryCallSettings.Builder<CreatePrivateConnectionRequest, Operation>
        createPrivateConnectionSettings() {
      return createPrivateConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to createPrivateConnection. */
    public OperationCallSettings.Builder<
            CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
        createPrivateConnectionOperationSettings() {
      return createPrivateConnectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getPrivateConnection. */
    public UnaryCallSettings.Builder<GetPrivateConnectionRequest, PrivateConnection>
        getPrivateConnectionSettings() {
      return getPrivateConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to listPrivateConnections. */
    public PagedCallSettings.Builder<
            ListPrivateConnectionsRequest,
            ListPrivateConnectionsResponse,
            ListPrivateConnectionsPagedResponse>
        listPrivateConnectionsSettings() {
      return listPrivateConnectionsSettings;
    }

    /** Returns the builder for the settings used for calls to updatePrivateConnection. */
    public UnaryCallSettings.Builder<UpdatePrivateConnectionRequest, Operation>
        updatePrivateConnectionSettings() {
      return updatePrivateConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to updatePrivateConnection. */
    public OperationCallSettings.Builder<
            UpdatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
        updatePrivateConnectionOperationSettings() {
      return updatePrivateConnectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deletePrivateConnection. */
    public UnaryCallSettings.Builder<DeletePrivateConnectionRequest, Operation>
        deletePrivateConnectionSettings() {
      return deletePrivateConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to deletePrivateConnection. */
    public OperationCallSettings.Builder<DeletePrivateConnectionRequest, Empty, OperationMetadata>
        deletePrivateConnectionOperationSettings() {
      return deletePrivateConnectionOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listPrivateConnectionPeeringRoutes.
     */
    public PagedCallSettings.Builder<
            ListPrivateConnectionPeeringRoutesRequest,
            ListPrivateConnectionPeeringRoutesResponse,
            ListPrivateConnectionPeeringRoutesPagedResponse>
        listPrivateConnectionPeeringRoutesSettings() {
      return listPrivateConnectionPeeringRoutesSettings;
    }

    /** Returns the builder for the settings used for calls to grantDnsBindPermission. */
    public UnaryCallSettings.Builder<GrantDnsBindPermissionRequest, Operation>
        grantDnsBindPermissionSettings() {
      return grantDnsBindPermissionSettings;
    }

    /** Returns the builder for the settings used for calls to grantDnsBindPermission. */
    public OperationCallSettings.Builder<
            GrantDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
        grantDnsBindPermissionOperationSettings() {
      return grantDnsBindPermissionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getDnsBindPermission. */
    public UnaryCallSettings.Builder<GetDnsBindPermissionRequest, DnsBindPermission>
        getDnsBindPermissionSettings() {
      return getDnsBindPermissionSettings;
    }

    /** Returns the builder for the settings used for calls to revokeDnsBindPermission. */
    public UnaryCallSettings.Builder<RevokeDnsBindPermissionRequest, Operation>
        revokeDnsBindPermissionSettings() {
      return revokeDnsBindPermissionSettings;
    }

    /** Returns the builder for the settings used for calls to revokeDnsBindPermission. */
    public OperationCallSettings.Builder<
            RevokeDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
        revokeDnsBindPermissionOperationSettings() {
      return revokeDnsBindPermissionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public VmwareEngineStubSettings build() throws IOException {
      return new VmwareEngineStubSettings(this);
    }
  }
}
