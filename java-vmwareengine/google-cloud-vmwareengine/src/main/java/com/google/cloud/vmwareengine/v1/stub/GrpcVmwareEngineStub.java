/*
 * Copyright 2023 Google LLC
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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the VmwareEngine service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcVmwareEngineStub extends VmwareEngineStub {
  private static final MethodDescriptor<ListPrivateCloudsRequest, ListPrivateCloudsResponse>
      listPrivateCloudsMethodDescriptor =
          MethodDescriptor.<ListPrivateCloudsRequest, ListPrivateCloudsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListPrivateClouds")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPrivateCloudsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPrivateCloudsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPrivateCloudRequest, PrivateCloud>
      getPrivateCloudMethodDescriptor =
          MethodDescriptor.<GetPrivateCloudRequest, PrivateCloud>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetPrivateCloud")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPrivateCloudRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PrivateCloud.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreatePrivateCloudRequest, Operation>
      createPrivateCloudMethodDescriptor =
          MethodDescriptor.<CreatePrivateCloudRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/CreatePrivateCloud")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePrivateCloudRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdatePrivateCloudRequest, Operation>
      updatePrivateCloudMethodDescriptor =
          MethodDescriptor.<UpdatePrivateCloudRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdatePrivateCloud")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePrivateCloudRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePrivateCloudRequest, Operation>
      deletePrivateCloudMethodDescriptor =
          MethodDescriptor.<DeletePrivateCloudRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/DeletePrivateCloud")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePrivateCloudRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UndeletePrivateCloudRequest, Operation>
      undeletePrivateCloudMethodDescriptor =
          MethodDescriptor.<UndeletePrivateCloudRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UndeletePrivateCloud")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeletePrivateCloudRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          MethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListClusters")
              .setRequestMarshaller(ProtoUtils.marshaller(ListClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListClustersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetClusterRequest, Cluster> getClusterMethodDescriptor =
      MethodDescriptor.<GetClusterRequest, Cluster>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetCluster")
          .setRequestMarshaller(ProtoUtils.marshaller(GetClusterRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Cluster.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateClusterRequest, Operation>
      createClusterMethodDescriptor =
          MethodDescriptor.<CreateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/CreateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateClusterRequest, Operation>
      updateClusterMethodDescriptor =
          MethodDescriptor.<UpdateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteClusterRequest, Operation>
      deleteClusterMethodDescriptor =
          MethodDescriptor.<DeleteClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/DeleteCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListNodesRequest, ListNodesResponse>
      listNodesMethodDescriptor =
          MethodDescriptor.<ListNodesRequest, ListNodesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListNodes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListNodesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListNodesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNodeRequest, Node> getNodeMethodDescriptor =
      MethodDescriptor.<GetNodeRequest, Node>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetNode")
          .setRequestMarshaller(ProtoUtils.marshaller(GetNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Node.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListExternalAddressesRequest, ListExternalAddressesResponse>
      listExternalAddressesMethodDescriptor =
          MethodDescriptor.<ListExternalAddressesRequest, ListExternalAddressesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListExternalAddresses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExternalAddressesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExternalAddressesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          FetchNetworkPolicyExternalAddressesRequest, FetchNetworkPolicyExternalAddressesResponse>
      fetchNetworkPolicyExternalAddressesMethodDescriptor =
          MethodDescriptor
              .<FetchNetworkPolicyExternalAddressesRequest,
                  FetchNetworkPolicyExternalAddressesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/FetchNetworkPolicyExternalAddresses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      FetchNetworkPolicyExternalAddressesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      FetchNetworkPolicyExternalAddressesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetExternalAddressRequest, ExternalAddress>
      getExternalAddressMethodDescriptor =
          MethodDescriptor.<GetExternalAddressRequest, ExternalAddress>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetExternalAddress")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetExternalAddressRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ExternalAddress.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateExternalAddressRequest, Operation>
      createExternalAddressMethodDescriptor =
          MethodDescriptor.<CreateExternalAddressRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/CreateExternalAddress")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateExternalAddressRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateExternalAddressRequest, Operation>
      updateExternalAddressMethodDescriptor =
          MethodDescriptor.<UpdateExternalAddressRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdateExternalAddress")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateExternalAddressRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteExternalAddressRequest, Operation>
      deleteExternalAddressMethodDescriptor =
          MethodDescriptor.<DeleteExternalAddressRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/DeleteExternalAddress")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteExternalAddressRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSubnetsRequest, ListSubnetsResponse>
      listSubnetsMethodDescriptor =
          MethodDescriptor.<ListSubnetsRequest, ListSubnetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListSubnets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSubnetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSubnetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSubnetRequest, Subnet> getSubnetMethodDescriptor =
      MethodDescriptor.<GetSubnetRequest, Subnet>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetSubnet")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSubnetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Subnet.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSubnetRequest, Operation>
      updateSubnetMethodDescriptor =
          MethodDescriptor.<UpdateSubnetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdateSubnet")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateSubnetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListExternalAccessRulesRequest, ListExternalAccessRulesResponse>
      listExternalAccessRulesMethodDescriptor =
          MethodDescriptor
              .<ListExternalAccessRulesRequest, ListExternalAccessRulesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/ListExternalAccessRules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExternalAccessRulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExternalAccessRulesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetExternalAccessRuleRequest, ExternalAccessRule>
      getExternalAccessRuleMethodDescriptor =
          MethodDescriptor.<GetExternalAccessRuleRequest, ExternalAccessRule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetExternalAccessRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetExternalAccessRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ExternalAccessRule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateExternalAccessRuleRequest, Operation>
      createExternalAccessRuleMethodDescriptor =
          MethodDescriptor.<CreateExternalAccessRuleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/CreateExternalAccessRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateExternalAccessRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateExternalAccessRuleRequest, Operation>
      updateExternalAccessRuleMethodDescriptor =
          MethodDescriptor.<UpdateExternalAccessRuleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/UpdateExternalAccessRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateExternalAccessRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteExternalAccessRuleRequest, Operation>
      deleteExternalAccessRuleMethodDescriptor =
          MethodDescriptor.<DeleteExternalAccessRuleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/DeleteExternalAccessRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteExternalAccessRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLoggingServersRequest, ListLoggingServersResponse>
      listLoggingServersMethodDescriptor =
          MethodDescriptor.<ListLoggingServersRequest, ListLoggingServersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListLoggingServers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLoggingServersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLoggingServersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLoggingServerRequest, LoggingServer>
      getLoggingServerMethodDescriptor =
          MethodDescriptor.<GetLoggingServerRequest, LoggingServer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetLoggingServer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetLoggingServerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LoggingServer.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateLoggingServerRequest, Operation>
      createLoggingServerMethodDescriptor =
          MethodDescriptor.<CreateLoggingServerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/CreateLoggingServer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateLoggingServerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateLoggingServerRequest, Operation>
      updateLoggingServerMethodDescriptor =
          MethodDescriptor.<UpdateLoggingServerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdateLoggingServer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateLoggingServerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteLoggingServerRequest, Operation>
      deleteLoggingServerMethodDescriptor =
          MethodDescriptor.<DeleteLoggingServerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/DeleteLoggingServer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteLoggingServerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListNodeTypesRequest, ListNodeTypesResponse>
      listNodeTypesMethodDescriptor =
          MethodDescriptor.<ListNodeTypesRequest, ListNodeTypesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListNodeTypes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNodeTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNodeTypesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNodeTypeRequest, NodeType> getNodeTypeMethodDescriptor =
      MethodDescriptor.<GetNodeTypeRequest, NodeType>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetNodeType")
          .setRequestMarshaller(ProtoUtils.marshaller(GetNodeTypeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(NodeType.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ShowNsxCredentialsRequest, Credentials>
      showNsxCredentialsMethodDescriptor =
          MethodDescriptor.<ShowNsxCredentialsRequest, Credentials>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ShowNsxCredentials")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ShowNsxCredentialsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Credentials.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ShowVcenterCredentialsRequest, Credentials>
      showVcenterCredentialsMethodDescriptor =
          MethodDescriptor.<ShowVcenterCredentialsRequest, Credentials>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ShowVcenterCredentials")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ShowVcenterCredentialsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Credentials.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResetNsxCredentialsRequest, Operation>
      resetNsxCredentialsMethodDescriptor =
          MethodDescriptor.<ResetNsxCredentialsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ResetNsxCredentials")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResetNsxCredentialsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResetVcenterCredentialsRequest, Operation>
      resetVcenterCredentialsMethodDescriptor =
          MethodDescriptor.<ResetVcenterCredentialsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/ResetVcenterCredentials")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResetVcenterCredentialsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDnsForwardingRequest, DnsForwarding>
      getDnsForwardingMethodDescriptor =
          MethodDescriptor.<GetDnsForwardingRequest, DnsForwarding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetDnsForwarding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDnsForwardingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DnsForwarding.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDnsForwardingRequest, Operation>
      updateDnsForwardingMethodDescriptor =
          MethodDescriptor.<UpdateDnsForwardingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdateDnsForwarding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDnsForwardingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNetworkPeeringRequest, NetworkPeering>
      getNetworkPeeringMethodDescriptor =
          MethodDescriptor.<GetNetworkPeeringRequest, NetworkPeering>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetNetworkPeering")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetNetworkPeeringRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NetworkPeering.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse>
      listNetworkPeeringsMethodDescriptor =
          MethodDescriptor.<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListNetworkPeerings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNetworkPeeringsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNetworkPeeringsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateNetworkPeeringRequest, Operation>
      createNetworkPeeringMethodDescriptor =
          MethodDescriptor.<CreateNetworkPeeringRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/CreateNetworkPeering")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNetworkPeeringRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNetworkPeeringRequest, Operation>
      deleteNetworkPeeringMethodDescriptor =
          MethodDescriptor.<DeleteNetworkPeeringRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/DeleteNetworkPeering")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNetworkPeeringRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateNetworkPeeringRequest, Operation>
      updateNetworkPeeringMethodDescriptor =
          MethodDescriptor.<UpdateNetworkPeeringRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdateNetworkPeering")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateNetworkPeeringRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPeeringRoutesRequest, ListPeeringRoutesResponse>
      listPeeringRoutesMethodDescriptor =
          MethodDescriptor.<ListPeeringRoutesRequest, ListPeeringRoutesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListPeeringRoutes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPeeringRoutesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPeeringRoutesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateHcxActivationKeyRequest, Operation>
      createHcxActivationKeyMethodDescriptor =
          MethodDescriptor.<CreateHcxActivationKeyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/CreateHcxActivationKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateHcxActivationKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>
      listHcxActivationKeysMethodDescriptor =
          MethodDescriptor.<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListHcxActivationKeys")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListHcxActivationKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListHcxActivationKeysResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetHcxActivationKeyRequest, HcxActivationKey>
      getHcxActivationKeyMethodDescriptor =
          MethodDescriptor.<GetHcxActivationKeyRequest, HcxActivationKey>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetHcxActivationKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetHcxActivationKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HcxActivationKey.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNetworkPolicyRequest, NetworkPolicy>
      getNetworkPolicyMethodDescriptor =
          MethodDescriptor.<GetNetworkPolicyRequest, NetworkPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetNetworkPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetNetworkPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NetworkPolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>
      listNetworkPoliciesMethodDescriptor =
          MethodDescriptor.<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListNetworkPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNetworkPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNetworkPoliciesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateNetworkPolicyRequest, Operation>
      createNetworkPolicyMethodDescriptor =
          MethodDescriptor.<CreateNetworkPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/CreateNetworkPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNetworkPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateNetworkPolicyRequest, Operation>
      updateNetworkPolicyMethodDescriptor =
          MethodDescriptor.<UpdateNetworkPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/UpdateNetworkPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateNetworkPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNetworkPolicyRequest, Operation>
      deleteNetworkPolicyMethodDescriptor =
          MethodDescriptor.<DeleteNetworkPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/DeleteNetworkPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNetworkPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsResponse>
      listManagementDnsZoneBindingsMethodDescriptor =
          MethodDescriptor
              .<ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/ListManagementDnsZoneBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListManagementDnsZoneBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListManagementDnsZoneBindingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
      getManagementDnsZoneBindingMethodDescriptor =
          MethodDescriptor
              .<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/GetManagementDnsZoneBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetManagementDnsZoneBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ManagementDnsZoneBinding.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateManagementDnsZoneBindingRequest, Operation>
      createManagementDnsZoneBindingMethodDescriptor =
          MethodDescriptor.<CreateManagementDnsZoneBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/CreateManagementDnsZoneBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateManagementDnsZoneBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateManagementDnsZoneBindingRequest, Operation>
      updateManagementDnsZoneBindingMethodDescriptor =
          MethodDescriptor.<UpdateManagementDnsZoneBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/UpdateManagementDnsZoneBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateManagementDnsZoneBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteManagementDnsZoneBindingRequest, Operation>
      deleteManagementDnsZoneBindingMethodDescriptor =
          MethodDescriptor.<DeleteManagementDnsZoneBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/DeleteManagementDnsZoneBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteManagementDnsZoneBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RepairManagementDnsZoneBindingRequest, Operation>
      repairManagementDnsZoneBindingMethodDescriptor =
          MethodDescriptor.<RepairManagementDnsZoneBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/RepairManagementDnsZoneBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RepairManagementDnsZoneBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateVmwareEngineNetworkRequest, Operation>
      createVmwareEngineNetworkMethodDescriptor =
          MethodDescriptor.<CreateVmwareEngineNetworkRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/CreateVmwareEngineNetwork")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateVmwareEngineNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateVmwareEngineNetworkRequest, Operation>
      updateVmwareEngineNetworkMethodDescriptor =
          MethodDescriptor.<UpdateVmwareEngineNetworkRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/UpdateVmwareEngineNetwork")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateVmwareEngineNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteVmwareEngineNetworkRequest, Operation>
      deleteVmwareEngineNetworkMethodDescriptor =
          MethodDescriptor.<DeleteVmwareEngineNetworkRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/DeleteVmwareEngineNetwork")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteVmwareEngineNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
      getVmwareEngineNetworkMethodDescriptor =
          MethodDescriptor.<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetVmwareEngineNetwork")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetVmwareEngineNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(VmwareEngineNetwork.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>
      listVmwareEngineNetworksMethodDescriptor =
          MethodDescriptor
              .<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/ListVmwareEngineNetworks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListVmwareEngineNetworksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVmwareEngineNetworksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionMethodDescriptor =
          MethodDescriptor.<CreatePrivateConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/CreatePrivateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePrivateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionMethodDescriptor =
          MethodDescriptor.<GetPrivateConnectionRequest, PrivateConnection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetPrivateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPrivateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PrivateConnection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsMethodDescriptor =
          MethodDescriptor
              .<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListPrivateConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPrivateConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPrivateConnectionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdatePrivateConnectionRequest, Operation>
      updatePrivateConnectionMethodDescriptor =
          MethodDescriptor.<UpdatePrivateConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/UpdatePrivateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePrivateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionMethodDescriptor =
          MethodDescriptor.<DeletePrivateConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/DeletePrivateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePrivateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListPrivateConnectionPeeringRoutesRequest, ListPrivateConnectionPeeringRoutesResponse>
      listPrivateConnectionPeeringRoutesMethodDescriptor =
          MethodDescriptor
              .<ListPrivateConnectionPeeringRoutesRequest,
                  ListPrivateConnectionPeeringRoutesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/ListPrivateConnectionPeeringRoutes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListPrivateConnectionPeeringRoutesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListPrivateConnectionPeeringRoutesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GrantDnsBindPermissionRequest, Operation>
      grantDnsBindPermissionMethodDescriptor =
          MethodDescriptor.<GrantDnsBindPermissionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GrantDnsBindPermission")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GrantDnsBindPermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDnsBindPermissionRequest, DnsBindPermission>
      getDnsBindPermissionMethodDescriptor =
          MethodDescriptor.<GetDnsBindPermissionRequest, DnsBindPermission>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/GetDnsBindPermission")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDnsBindPermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DnsBindPermission.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RevokeDnsBindPermissionRequest, Operation>
      revokeDnsBindPermissionMethodDescriptor =
          MethodDescriptor.<RevokeDnsBindPermissionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmwareengine.v1.VmwareEngine/RevokeDnsBindPermission")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RevokeDnsBindPermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsResponse>
      listPrivateCloudsCallable;
  private final UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsPagedResponse>
      listPrivateCloudsPagedCallable;
  private final UnaryCallable<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudCallable;
  private final UnaryCallable<CreatePrivateCloudRequest, Operation> createPrivateCloudCallable;
  private final OperationCallable<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      createPrivateCloudOperationCallable;
  private final UnaryCallable<UpdatePrivateCloudRequest, Operation> updatePrivateCloudCallable;
  private final OperationCallable<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      updatePrivateCloudOperationCallable;
  private final UnaryCallable<DeletePrivateCloudRequest, Operation> deletePrivateCloudCallable;
  private final OperationCallable<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      deletePrivateCloudOperationCallable;
  private final UnaryCallable<UndeletePrivateCloudRequest, Operation> undeletePrivateCloudCallable;
  private final OperationCallable<UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      undeletePrivateCloudOperationCallable;
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
  private final UnaryCallable<ListNodesRequest, ListNodesResponse> listNodesCallable;
  private final UnaryCallable<ListNodesRequest, ListNodesPagedResponse> listNodesPagedCallable;
  private final UnaryCallable<GetNodeRequest, Node> getNodeCallable;
  private final UnaryCallable<ListExternalAddressesRequest, ListExternalAddressesResponse>
      listExternalAddressesCallable;
  private final UnaryCallable<ListExternalAddressesRequest, ListExternalAddressesPagedResponse>
      listExternalAddressesPagedCallable;
  private final UnaryCallable<
          FetchNetworkPolicyExternalAddressesRequest, FetchNetworkPolicyExternalAddressesResponse>
      fetchNetworkPolicyExternalAddressesCallable;
  private final UnaryCallable<
          FetchNetworkPolicyExternalAddressesRequest,
          FetchNetworkPolicyExternalAddressesPagedResponse>
      fetchNetworkPolicyExternalAddressesPagedCallable;
  private final UnaryCallable<GetExternalAddressRequest, ExternalAddress>
      getExternalAddressCallable;
  private final UnaryCallable<CreateExternalAddressRequest, Operation>
      createExternalAddressCallable;
  private final OperationCallable<CreateExternalAddressRequest, ExternalAddress, OperationMetadata>
      createExternalAddressOperationCallable;
  private final UnaryCallable<UpdateExternalAddressRequest, Operation>
      updateExternalAddressCallable;
  private final OperationCallable<UpdateExternalAddressRequest, ExternalAddress, OperationMetadata>
      updateExternalAddressOperationCallable;
  private final UnaryCallable<DeleteExternalAddressRequest, Operation>
      deleteExternalAddressCallable;
  private final OperationCallable<DeleteExternalAddressRequest, Empty, OperationMetadata>
      deleteExternalAddressOperationCallable;
  private final UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable;
  private final UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse>
      listSubnetsPagedCallable;
  private final UnaryCallable<GetSubnetRequest, Subnet> getSubnetCallable;
  private final UnaryCallable<UpdateSubnetRequest, Operation> updateSubnetCallable;
  private final OperationCallable<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationCallable;
  private final UnaryCallable<ListExternalAccessRulesRequest, ListExternalAccessRulesResponse>
      listExternalAccessRulesCallable;
  private final UnaryCallable<ListExternalAccessRulesRequest, ListExternalAccessRulesPagedResponse>
      listExternalAccessRulesPagedCallable;
  private final UnaryCallable<GetExternalAccessRuleRequest, ExternalAccessRule>
      getExternalAccessRuleCallable;
  private final UnaryCallable<CreateExternalAccessRuleRequest, Operation>
      createExternalAccessRuleCallable;
  private final OperationCallable<
          CreateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      createExternalAccessRuleOperationCallable;
  private final UnaryCallable<UpdateExternalAccessRuleRequest, Operation>
      updateExternalAccessRuleCallable;
  private final OperationCallable<
          UpdateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      updateExternalAccessRuleOperationCallable;
  private final UnaryCallable<DeleteExternalAccessRuleRequest, Operation>
      deleteExternalAccessRuleCallable;
  private final OperationCallable<DeleteExternalAccessRuleRequest, Empty, OperationMetadata>
      deleteExternalAccessRuleOperationCallable;
  private final UnaryCallable<ListLoggingServersRequest, ListLoggingServersResponse>
      listLoggingServersCallable;
  private final UnaryCallable<ListLoggingServersRequest, ListLoggingServersPagedResponse>
      listLoggingServersPagedCallable;
  private final UnaryCallable<GetLoggingServerRequest, LoggingServer> getLoggingServerCallable;
  private final UnaryCallable<CreateLoggingServerRequest, Operation> createLoggingServerCallable;
  private final OperationCallable<CreateLoggingServerRequest, LoggingServer, OperationMetadata>
      createLoggingServerOperationCallable;
  private final UnaryCallable<UpdateLoggingServerRequest, Operation> updateLoggingServerCallable;
  private final OperationCallable<UpdateLoggingServerRequest, LoggingServer, OperationMetadata>
      updateLoggingServerOperationCallable;
  private final UnaryCallable<DeleteLoggingServerRequest, Operation> deleteLoggingServerCallable;
  private final OperationCallable<DeleteLoggingServerRequest, Empty, OperationMetadata>
      deleteLoggingServerOperationCallable;
  private final UnaryCallable<ListNodeTypesRequest, ListNodeTypesResponse> listNodeTypesCallable;
  private final UnaryCallable<ListNodeTypesRequest, ListNodeTypesPagedResponse>
      listNodeTypesPagedCallable;
  private final UnaryCallable<GetNodeTypeRequest, NodeType> getNodeTypeCallable;
  private final UnaryCallable<ShowNsxCredentialsRequest, Credentials> showNsxCredentialsCallable;
  private final UnaryCallable<ShowVcenterCredentialsRequest, Credentials>
      showVcenterCredentialsCallable;
  private final UnaryCallable<ResetNsxCredentialsRequest, Operation> resetNsxCredentialsCallable;
  private final OperationCallable<ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
      resetNsxCredentialsOperationCallable;
  private final UnaryCallable<ResetVcenterCredentialsRequest, Operation>
      resetVcenterCredentialsCallable;
  private final OperationCallable<ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
      resetVcenterCredentialsOperationCallable;
  private final UnaryCallable<GetDnsForwardingRequest, DnsForwarding> getDnsForwardingCallable;
  private final UnaryCallable<UpdateDnsForwardingRequest, Operation> updateDnsForwardingCallable;
  private final OperationCallable<UpdateDnsForwardingRequest, DnsForwarding, OperationMetadata>
      updateDnsForwardingOperationCallable;
  private final UnaryCallable<GetNetworkPeeringRequest, NetworkPeering> getNetworkPeeringCallable;
  private final UnaryCallable<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse>
      listNetworkPeeringsCallable;
  private final UnaryCallable<ListNetworkPeeringsRequest, ListNetworkPeeringsPagedResponse>
      listNetworkPeeringsPagedCallable;
  private final UnaryCallable<CreateNetworkPeeringRequest, Operation> createNetworkPeeringCallable;
  private final OperationCallable<CreateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      createNetworkPeeringOperationCallable;
  private final UnaryCallable<DeleteNetworkPeeringRequest, Operation> deleteNetworkPeeringCallable;
  private final OperationCallable<DeleteNetworkPeeringRequest, Empty, OperationMetadata>
      deleteNetworkPeeringOperationCallable;
  private final UnaryCallable<UpdateNetworkPeeringRequest, Operation> updateNetworkPeeringCallable;
  private final OperationCallable<UpdateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      updateNetworkPeeringOperationCallable;
  private final UnaryCallable<ListPeeringRoutesRequest, ListPeeringRoutesResponse>
      listPeeringRoutesCallable;
  private final UnaryCallable<ListPeeringRoutesRequest, ListPeeringRoutesPagedResponse>
      listPeeringRoutesPagedCallable;
  private final UnaryCallable<CreateHcxActivationKeyRequest, Operation>
      createHcxActivationKeyCallable;
  private final OperationCallable<
          CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
      createHcxActivationKeyOperationCallable;
  private final UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>
      listHcxActivationKeysCallable;
  private final UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysPagedResponse>
      listHcxActivationKeysPagedCallable;
  private final UnaryCallable<GetHcxActivationKeyRequest, HcxActivationKey>
      getHcxActivationKeyCallable;
  private final UnaryCallable<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicyCallable;
  private final UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>
      listNetworkPoliciesCallable;
  private final UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesPagedResponse>
      listNetworkPoliciesPagedCallable;
  private final UnaryCallable<CreateNetworkPolicyRequest, Operation> createNetworkPolicyCallable;
  private final OperationCallable<CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      createNetworkPolicyOperationCallable;
  private final UnaryCallable<UpdateNetworkPolicyRequest, Operation> updateNetworkPolicyCallable;
  private final OperationCallable<UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      updateNetworkPolicyOperationCallable;
  private final UnaryCallable<DeleteNetworkPolicyRequest, Operation> deleteNetworkPolicyCallable;
  private final OperationCallable<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
      deleteNetworkPolicyOperationCallable;
  private final UnaryCallable<
          ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsResponse>
      listManagementDnsZoneBindingsCallable;
  private final UnaryCallable<
          ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsPagedResponse>
      listManagementDnsZoneBindingsPagedCallable;
  private final UnaryCallable<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
      getManagementDnsZoneBindingCallable;
  private final UnaryCallable<CreateManagementDnsZoneBindingRequest, Operation>
      createManagementDnsZoneBindingCallable;
  private final OperationCallable<
          CreateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      createManagementDnsZoneBindingOperationCallable;
  private final UnaryCallable<UpdateManagementDnsZoneBindingRequest, Operation>
      updateManagementDnsZoneBindingCallable;
  private final OperationCallable<
          UpdateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      updateManagementDnsZoneBindingOperationCallable;
  private final UnaryCallable<DeleteManagementDnsZoneBindingRequest, Operation>
      deleteManagementDnsZoneBindingCallable;
  private final OperationCallable<DeleteManagementDnsZoneBindingRequest, Empty, OperationMetadata>
      deleteManagementDnsZoneBindingOperationCallable;
  private final UnaryCallable<RepairManagementDnsZoneBindingRequest, Operation>
      repairManagementDnsZoneBindingCallable;
  private final OperationCallable<
          RepairManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      repairManagementDnsZoneBindingOperationCallable;
  private final UnaryCallable<CreateVmwareEngineNetworkRequest, Operation>
      createVmwareEngineNetworkCallable;
  private final OperationCallable<
          CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkOperationCallable;
  private final UnaryCallable<UpdateVmwareEngineNetworkRequest, Operation>
      updateVmwareEngineNetworkCallable;
  private final OperationCallable<
          UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkOperationCallable;
  private final UnaryCallable<DeleteVmwareEngineNetworkRequest, Operation>
      deleteVmwareEngineNetworkCallable;
  private final OperationCallable<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
      deleteVmwareEngineNetworkOperationCallable;
  private final UnaryCallable<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
      getVmwareEngineNetworkCallable;
  private final UnaryCallable<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>
      listVmwareEngineNetworksCallable;
  private final UnaryCallable<
          ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksPagedResponse>
      listVmwareEngineNetworksPagedCallable;
  private final UnaryCallable<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionCallable;
  private final OperationCallable<
          CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationCallable;
  private final UnaryCallable<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionCallable;
  private final UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsCallable;
  private final UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsPagedCallable;
  private final UnaryCallable<UpdatePrivateConnectionRequest, Operation>
      updatePrivateConnectionCallable;
  private final OperationCallable<
          UpdatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      updatePrivateConnectionOperationCallable;
  private final UnaryCallable<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionCallable;
  private final OperationCallable<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationCallable;
  private final UnaryCallable<
          ListPrivateConnectionPeeringRoutesRequest, ListPrivateConnectionPeeringRoutesResponse>
      listPrivateConnectionPeeringRoutesCallable;
  private final UnaryCallable<
          ListPrivateConnectionPeeringRoutesRequest,
          ListPrivateConnectionPeeringRoutesPagedResponse>
      listPrivateConnectionPeeringRoutesPagedCallable;
  private final UnaryCallable<GrantDnsBindPermissionRequest, Operation>
      grantDnsBindPermissionCallable;
  private final OperationCallable<
          GrantDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      grantDnsBindPermissionOperationCallable;
  private final UnaryCallable<GetDnsBindPermissionRequest, DnsBindPermission>
      getDnsBindPermissionCallable;
  private final UnaryCallable<RevokeDnsBindPermissionRequest, Operation>
      revokeDnsBindPermissionCallable;
  private final OperationCallable<
          RevokeDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      revokeDnsBindPermissionOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcVmwareEngineStub create(VmwareEngineStubSettings settings)
      throws IOException {
    return new GrpcVmwareEngineStub(settings, ClientContext.create(settings));
  }

  public static final GrpcVmwareEngineStub create(ClientContext clientContext) throws IOException {
    return new GrpcVmwareEngineStub(VmwareEngineStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcVmwareEngineStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcVmwareEngineStub(
        VmwareEngineStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcVmwareEngineStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcVmwareEngineStub(VmwareEngineStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcVmwareEngineCallableFactory());
  }

  /**
   * Constructs an instance of GrpcVmwareEngineStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcVmwareEngineStub(
      VmwareEngineStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListPrivateCloudsRequest, ListPrivateCloudsResponse>
        listPrivateCloudsTransportSettings =
            GrpcCallSettings.<ListPrivateCloudsRequest, ListPrivateCloudsResponse>newBuilder()
                .setMethodDescriptor(listPrivateCloudsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudTransportSettings =
        GrpcCallSettings.<GetPrivateCloudRequest, PrivateCloud>newBuilder()
            .setMethodDescriptor(getPrivateCloudMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreatePrivateCloudRequest, Operation> createPrivateCloudTransportSettings =
        GrpcCallSettings.<CreatePrivateCloudRequest, Operation>newBuilder()
            .setMethodDescriptor(createPrivateCloudMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdatePrivateCloudRequest, Operation> updatePrivateCloudTransportSettings =
        GrpcCallSettings.<UpdatePrivateCloudRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePrivateCloudMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "private_cloud.name", String.valueOf(request.getPrivateCloud().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeletePrivateCloudRequest, Operation> deletePrivateCloudTransportSettings =
        GrpcCallSettings.<DeletePrivateCloudRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePrivateCloudMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UndeletePrivateCloudRequest, Operation> undeletePrivateCloudTransportSettings =
        GrpcCallSettings.<UndeletePrivateCloudRequest, Operation>newBuilder()
            .setMethodDescriptor(undeletePrivateCloudMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListClustersRequest, ListClustersResponse> listClustersTransportSettings =
        GrpcCallSettings.<ListClustersRequest, ListClustersResponse>newBuilder()
            .setMethodDescriptor(listClustersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetClusterRequest, Cluster> getClusterTransportSettings =
        GrpcCallSettings.<GetClusterRequest, Cluster>newBuilder()
            .setMethodDescriptor(getClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateClusterRequest, Operation> createClusterTransportSettings =
        GrpcCallSettings.<CreateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateClusterRequest, Operation> updateClusterTransportSettings =
        GrpcCallSettings.<UpdateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster.name", String.valueOf(request.getCluster().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteClusterRequest, Operation> deleteClusterTransportSettings =
        GrpcCallSettings.<DeleteClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListNodesRequest, ListNodesResponse> listNodesTransportSettings =
        GrpcCallSettings.<ListNodesRequest, ListNodesResponse>newBuilder()
            .setMethodDescriptor(listNodesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetNodeRequest, Node> getNodeTransportSettings =
        GrpcCallSettings.<GetNodeRequest, Node>newBuilder()
            .setMethodDescriptor(getNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListExternalAddressesRequest, ListExternalAddressesResponse>
        listExternalAddressesTransportSettings =
            GrpcCallSettings
                .<ListExternalAddressesRequest, ListExternalAddressesResponse>newBuilder()
                .setMethodDescriptor(listExternalAddressesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            FetchNetworkPolicyExternalAddressesRequest, FetchNetworkPolicyExternalAddressesResponse>
        fetchNetworkPolicyExternalAddressesTransportSettings =
            GrpcCallSettings
                .<FetchNetworkPolicyExternalAddressesRequest,
                    FetchNetworkPolicyExternalAddressesResponse>
                    newBuilder()
                .setMethodDescriptor(fetchNetworkPolicyExternalAddressesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("network_policy", String.valueOf(request.getNetworkPolicy()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetExternalAddressRequest, ExternalAddress>
        getExternalAddressTransportSettings =
            GrpcCallSettings.<GetExternalAddressRequest, ExternalAddress>newBuilder()
                .setMethodDescriptor(getExternalAddressMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateExternalAddressRequest, Operation>
        createExternalAddressTransportSettings =
            GrpcCallSettings.<CreateExternalAddressRequest, Operation>newBuilder()
                .setMethodDescriptor(createExternalAddressMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateExternalAddressRequest, Operation>
        updateExternalAddressTransportSettings =
            GrpcCallSettings.<UpdateExternalAddressRequest, Operation>newBuilder()
                .setMethodDescriptor(updateExternalAddressMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "external_address.name",
                          String.valueOf(request.getExternalAddress().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteExternalAddressRequest, Operation>
        deleteExternalAddressTransportSettings =
            GrpcCallSettings.<DeleteExternalAddressRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteExternalAddressMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListSubnetsRequest, ListSubnetsResponse> listSubnetsTransportSettings =
        GrpcCallSettings.<ListSubnetsRequest, ListSubnetsResponse>newBuilder()
            .setMethodDescriptor(listSubnetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSubnetRequest, Subnet> getSubnetTransportSettings =
        GrpcCallSettings.<GetSubnetRequest, Subnet>newBuilder()
            .setMethodDescriptor(getSubnetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSubnetRequest, Operation> updateSubnetTransportSettings =
        GrpcCallSettings.<UpdateSubnetRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSubnetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("subnet.name", String.valueOf(request.getSubnet().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListExternalAccessRulesRequest, ListExternalAccessRulesResponse>
        listExternalAccessRulesTransportSettings =
            GrpcCallSettings
                .<ListExternalAccessRulesRequest, ListExternalAccessRulesResponse>newBuilder()
                .setMethodDescriptor(listExternalAccessRulesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetExternalAccessRuleRequest, ExternalAccessRule>
        getExternalAccessRuleTransportSettings =
            GrpcCallSettings.<GetExternalAccessRuleRequest, ExternalAccessRule>newBuilder()
                .setMethodDescriptor(getExternalAccessRuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateExternalAccessRuleRequest, Operation>
        createExternalAccessRuleTransportSettings =
            GrpcCallSettings.<CreateExternalAccessRuleRequest, Operation>newBuilder()
                .setMethodDescriptor(createExternalAccessRuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateExternalAccessRuleRequest, Operation>
        updateExternalAccessRuleTransportSettings =
            GrpcCallSettings.<UpdateExternalAccessRuleRequest, Operation>newBuilder()
                .setMethodDescriptor(updateExternalAccessRuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "external_access_rule.name",
                          String.valueOf(request.getExternalAccessRule().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteExternalAccessRuleRequest, Operation>
        deleteExternalAccessRuleTransportSettings =
            GrpcCallSettings.<DeleteExternalAccessRuleRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteExternalAccessRuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLoggingServersRequest, ListLoggingServersResponse>
        listLoggingServersTransportSettings =
            GrpcCallSettings.<ListLoggingServersRequest, ListLoggingServersResponse>newBuilder()
                .setMethodDescriptor(listLoggingServersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetLoggingServerRequest, LoggingServer> getLoggingServerTransportSettings =
        GrpcCallSettings.<GetLoggingServerRequest, LoggingServer>newBuilder()
            .setMethodDescriptor(getLoggingServerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateLoggingServerRequest, Operation> createLoggingServerTransportSettings =
        GrpcCallSettings.<CreateLoggingServerRequest, Operation>newBuilder()
            .setMethodDescriptor(createLoggingServerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateLoggingServerRequest, Operation> updateLoggingServerTransportSettings =
        GrpcCallSettings.<UpdateLoggingServerRequest, Operation>newBuilder()
            .setMethodDescriptor(updateLoggingServerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "logging_server.name", String.valueOf(request.getLoggingServer().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteLoggingServerRequest, Operation> deleteLoggingServerTransportSettings =
        GrpcCallSettings.<DeleteLoggingServerRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteLoggingServerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListNodeTypesRequest, ListNodeTypesResponse> listNodeTypesTransportSettings =
        GrpcCallSettings.<ListNodeTypesRequest, ListNodeTypesResponse>newBuilder()
            .setMethodDescriptor(listNodeTypesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetNodeTypeRequest, NodeType> getNodeTypeTransportSettings =
        GrpcCallSettings.<GetNodeTypeRequest, NodeType>newBuilder()
            .setMethodDescriptor(getNodeTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ShowNsxCredentialsRequest, Credentials> showNsxCredentialsTransportSettings =
        GrpcCallSettings.<ShowNsxCredentialsRequest, Credentials>newBuilder()
            .setMethodDescriptor(showNsxCredentialsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("private_cloud", String.valueOf(request.getPrivateCloud()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ShowVcenterCredentialsRequest, Credentials>
        showVcenterCredentialsTransportSettings =
            GrpcCallSettings.<ShowVcenterCredentialsRequest, Credentials>newBuilder()
                .setMethodDescriptor(showVcenterCredentialsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("private_cloud", String.valueOf(request.getPrivateCloud()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ResetNsxCredentialsRequest, Operation> resetNsxCredentialsTransportSettings =
        GrpcCallSettings.<ResetNsxCredentialsRequest, Operation>newBuilder()
            .setMethodDescriptor(resetNsxCredentialsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("private_cloud", String.valueOf(request.getPrivateCloud()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ResetVcenterCredentialsRequest, Operation>
        resetVcenterCredentialsTransportSettings =
            GrpcCallSettings.<ResetVcenterCredentialsRequest, Operation>newBuilder()
                .setMethodDescriptor(resetVcenterCredentialsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("private_cloud", String.valueOf(request.getPrivateCloud()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDnsForwardingRequest, DnsForwarding> getDnsForwardingTransportSettings =
        GrpcCallSettings.<GetDnsForwardingRequest, DnsForwarding>newBuilder()
            .setMethodDescriptor(getDnsForwardingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDnsForwardingRequest, Operation> updateDnsForwardingTransportSettings =
        GrpcCallSettings.<UpdateDnsForwardingRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDnsForwardingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "dns_forwarding.name", String.valueOf(request.getDnsForwarding().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetNetworkPeeringRequest, NetworkPeering> getNetworkPeeringTransportSettings =
        GrpcCallSettings.<GetNetworkPeeringRequest, NetworkPeering>newBuilder()
            .setMethodDescriptor(getNetworkPeeringMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse>
        listNetworkPeeringsTransportSettings =
            GrpcCallSettings.<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse>newBuilder()
                .setMethodDescriptor(listNetworkPeeringsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateNetworkPeeringRequest, Operation> createNetworkPeeringTransportSettings =
        GrpcCallSettings.<CreateNetworkPeeringRequest, Operation>newBuilder()
            .setMethodDescriptor(createNetworkPeeringMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteNetworkPeeringRequest, Operation> deleteNetworkPeeringTransportSettings =
        GrpcCallSettings.<DeleteNetworkPeeringRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNetworkPeeringMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateNetworkPeeringRequest, Operation> updateNetworkPeeringTransportSettings =
        GrpcCallSettings.<UpdateNetworkPeeringRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNetworkPeeringMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "network_peering.name",
                      String.valueOf(request.getNetworkPeering().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPeeringRoutesRequest, ListPeeringRoutesResponse>
        listPeeringRoutesTransportSettings =
            GrpcCallSettings.<ListPeeringRoutesRequest, ListPeeringRoutesResponse>newBuilder()
                .setMethodDescriptor(listPeeringRoutesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateHcxActivationKeyRequest, Operation>
        createHcxActivationKeyTransportSettings =
            GrpcCallSettings.<CreateHcxActivationKeyRequest, Operation>newBuilder()
                .setMethodDescriptor(createHcxActivationKeyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>
        listHcxActivationKeysTransportSettings =
            GrpcCallSettings
                .<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>newBuilder()
                .setMethodDescriptor(listHcxActivationKeysMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetHcxActivationKeyRequest, HcxActivationKey>
        getHcxActivationKeyTransportSettings =
            GrpcCallSettings.<GetHcxActivationKeyRequest, HcxActivationKey>newBuilder()
                .setMethodDescriptor(getHcxActivationKeyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicyTransportSettings =
        GrpcCallSettings.<GetNetworkPolicyRequest, NetworkPolicy>newBuilder()
            .setMethodDescriptor(getNetworkPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>
        listNetworkPoliciesTransportSettings =
            GrpcCallSettings.<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>newBuilder()
                .setMethodDescriptor(listNetworkPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateNetworkPolicyRequest, Operation> createNetworkPolicyTransportSettings =
        GrpcCallSettings.<CreateNetworkPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(createNetworkPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateNetworkPolicyRequest, Operation> updateNetworkPolicyTransportSettings =
        GrpcCallSettings.<UpdateNetworkPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNetworkPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "network_policy.name", String.valueOf(request.getNetworkPolicy().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteNetworkPolicyRequest, Operation> deleteNetworkPolicyTransportSettings =
        GrpcCallSettings.<DeleteNetworkPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNetworkPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsResponse>
        listManagementDnsZoneBindingsTransportSettings =
            GrpcCallSettings
                .<ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsResponse>
                    newBuilder()
                .setMethodDescriptor(listManagementDnsZoneBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
        getManagementDnsZoneBindingTransportSettings =
            GrpcCallSettings
                .<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>newBuilder()
                .setMethodDescriptor(getManagementDnsZoneBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateManagementDnsZoneBindingRequest, Operation>
        createManagementDnsZoneBindingTransportSettings =
            GrpcCallSettings.<CreateManagementDnsZoneBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(createManagementDnsZoneBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateManagementDnsZoneBindingRequest, Operation>
        updateManagementDnsZoneBindingTransportSettings =
            GrpcCallSettings.<UpdateManagementDnsZoneBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(updateManagementDnsZoneBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "management_dns_zone_binding.name",
                          String.valueOf(request.getManagementDnsZoneBinding().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteManagementDnsZoneBindingRequest, Operation>
        deleteManagementDnsZoneBindingTransportSettings =
            GrpcCallSettings.<DeleteManagementDnsZoneBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteManagementDnsZoneBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RepairManagementDnsZoneBindingRequest, Operation>
        repairManagementDnsZoneBindingTransportSettings =
            GrpcCallSettings.<RepairManagementDnsZoneBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(repairManagementDnsZoneBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateVmwareEngineNetworkRequest, Operation>
        createVmwareEngineNetworkTransportSettings =
            GrpcCallSettings.<CreateVmwareEngineNetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(createVmwareEngineNetworkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateVmwareEngineNetworkRequest, Operation>
        updateVmwareEngineNetworkTransportSettings =
            GrpcCallSettings.<UpdateVmwareEngineNetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(updateVmwareEngineNetworkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "vmware_engine_network.name",
                          String.valueOf(request.getVmwareEngineNetwork().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteVmwareEngineNetworkRequest, Operation>
        deleteVmwareEngineNetworkTransportSettings =
            GrpcCallSettings.<DeleteVmwareEngineNetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteVmwareEngineNetworkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
        getVmwareEngineNetworkTransportSettings =
            GrpcCallSettings.<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>newBuilder()
                .setMethodDescriptor(getVmwareEngineNetworkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>
        listVmwareEngineNetworksTransportSettings =
            GrpcCallSettings
                .<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>newBuilder()
                .setMethodDescriptor(listVmwareEngineNetworksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreatePrivateConnectionRequest, Operation>
        createPrivateConnectionTransportSettings =
            GrpcCallSettings.<CreatePrivateConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(createPrivateConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPrivateConnectionRequest, PrivateConnection>
        getPrivateConnectionTransportSettings =
            GrpcCallSettings.<GetPrivateConnectionRequest, PrivateConnection>newBuilder()
                .setMethodDescriptor(getPrivateConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
        listPrivateConnectionsTransportSettings =
            GrpcCallSettings
                .<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>newBuilder()
                .setMethodDescriptor(listPrivateConnectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdatePrivateConnectionRequest, Operation>
        updatePrivateConnectionTransportSettings =
            GrpcCallSettings.<UpdatePrivateConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePrivateConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "private_connection.name",
                          String.valueOf(request.getPrivateConnection().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeletePrivateConnectionRequest, Operation>
        deletePrivateConnectionTransportSettings =
            GrpcCallSettings.<DeletePrivateConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePrivateConnectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListPrivateConnectionPeeringRoutesRequest, ListPrivateConnectionPeeringRoutesResponse>
        listPrivateConnectionPeeringRoutesTransportSettings =
            GrpcCallSettings
                .<ListPrivateConnectionPeeringRoutesRequest,
                    ListPrivateConnectionPeeringRoutesResponse>
                    newBuilder()
                .setMethodDescriptor(listPrivateConnectionPeeringRoutesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GrantDnsBindPermissionRequest, Operation>
        grantDnsBindPermissionTransportSettings =
            GrpcCallSettings.<GrantDnsBindPermissionRequest, Operation>newBuilder()
                .setMethodDescriptor(grantDnsBindPermissionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDnsBindPermissionRequest, DnsBindPermission>
        getDnsBindPermissionTransportSettings =
            GrpcCallSettings.<GetDnsBindPermissionRequest, DnsBindPermission>newBuilder()
                .setMethodDescriptor(getDnsBindPermissionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RevokeDnsBindPermissionRequest, Operation>
        revokeDnsBindPermissionTransportSettings =
            GrpcCallSettings.<RevokeDnsBindPermissionRequest, Operation>newBuilder()
                .setMethodDescriptor(revokeDnsBindPermissionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.listPrivateCloudsCallable =
        callableFactory.createUnaryCallable(
            listPrivateCloudsTransportSettings,
            settings.listPrivateCloudsSettings(),
            clientContext);
    this.listPrivateCloudsPagedCallable =
        callableFactory.createPagedCallable(
            listPrivateCloudsTransportSettings,
            settings.listPrivateCloudsSettings(),
            clientContext);
    this.getPrivateCloudCallable =
        callableFactory.createUnaryCallable(
            getPrivateCloudTransportSettings, settings.getPrivateCloudSettings(), clientContext);
    this.createPrivateCloudCallable =
        callableFactory.createUnaryCallable(
            createPrivateCloudTransportSettings,
            settings.createPrivateCloudSettings(),
            clientContext);
    this.createPrivateCloudOperationCallable =
        callableFactory.createOperationCallable(
            createPrivateCloudTransportSettings,
            settings.createPrivateCloudOperationSettings(),
            clientContext,
            operationsStub);
    this.updatePrivateCloudCallable =
        callableFactory.createUnaryCallable(
            updatePrivateCloudTransportSettings,
            settings.updatePrivateCloudSettings(),
            clientContext);
    this.updatePrivateCloudOperationCallable =
        callableFactory.createOperationCallable(
            updatePrivateCloudTransportSettings,
            settings.updatePrivateCloudOperationSettings(),
            clientContext,
            operationsStub);
    this.deletePrivateCloudCallable =
        callableFactory.createUnaryCallable(
            deletePrivateCloudTransportSettings,
            settings.deletePrivateCloudSettings(),
            clientContext);
    this.deletePrivateCloudOperationCallable =
        callableFactory.createOperationCallable(
            deletePrivateCloudTransportSettings,
            settings.deletePrivateCloudOperationSettings(),
            clientContext,
            operationsStub);
    this.undeletePrivateCloudCallable =
        callableFactory.createUnaryCallable(
            undeletePrivateCloudTransportSettings,
            settings.undeletePrivateCloudSettings(),
            clientContext);
    this.undeletePrivateCloudOperationCallable =
        callableFactory.createOperationCallable(
            undeletePrivateCloudTransportSettings,
            settings.undeletePrivateCloudOperationSettings(),
            clientContext,
            operationsStub);
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
    this.listNodesCallable =
        callableFactory.createUnaryCallable(
            listNodesTransportSettings, settings.listNodesSettings(), clientContext);
    this.listNodesPagedCallable =
        callableFactory.createPagedCallable(
            listNodesTransportSettings, settings.listNodesSettings(), clientContext);
    this.getNodeCallable =
        callableFactory.createUnaryCallable(
            getNodeTransportSettings, settings.getNodeSettings(), clientContext);
    this.listExternalAddressesCallable =
        callableFactory.createUnaryCallable(
            listExternalAddressesTransportSettings,
            settings.listExternalAddressesSettings(),
            clientContext);
    this.listExternalAddressesPagedCallable =
        callableFactory.createPagedCallable(
            listExternalAddressesTransportSettings,
            settings.listExternalAddressesSettings(),
            clientContext);
    this.fetchNetworkPolicyExternalAddressesCallable =
        callableFactory.createUnaryCallable(
            fetchNetworkPolicyExternalAddressesTransportSettings,
            settings.fetchNetworkPolicyExternalAddressesSettings(),
            clientContext);
    this.fetchNetworkPolicyExternalAddressesPagedCallable =
        callableFactory.createPagedCallable(
            fetchNetworkPolicyExternalAddressesTransportSettings,
            settings.fetchNetworkPolicyExternalAddressesSettings(),
            clientContext);
    this.getExternalAddressCallable =
        callableFactory.createUnaryCallable(
            getExternalAddressTransportSettings,
            settings.getExternalAddressSettings(),
            clientContext);
    this.createExternalAddressCallable =
        callableFactory.createUnaryCallable(
            createExternalAddressTransportSettings,
            settings.createExternalAddressSettings(),
            clientContext);
    this.createExternalAddressOperationCallable =
        callableFactory.createOperationCallable(
            createExternalAddressTransportSettings,
            settings.createExternalAddressOperationSettings(),
            clientContext,
            operationsStub);
    this.updateExternalAddressCallable =
        callableFactory.createUnaryCallable(
            updateExternalAddressTransportSettings,
            settings.updateExternalAddressSettings(),
            clientContext);
    this.updateExternalAddressOperationCallable =
        callableFactory.createOperationCallable(
            updateExternalAddressTransportSettings,
            settings.updateExternalAddressOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteExternalAddressCallable =
        callableFactory.createUnaryCallable(
            deleteExternalAddressTransportSettings,
            settings.deleteExternalAddressSettings(),
            clientContext);
    this.deleteExternalAddressOperationCallable =
        callableFactory.createOperationCallable(
            deleteExternalAddressTransportSettings,
            settings.deleteExternalAddressOperationSettings(),
            clientContext,
            operationsStub);
    this.listSubnetsCallable =
        callableFactory.createUnaryCallable(
            listSubnetsTransportSettings, settings.listSubnetsSettings(), clientContext);
    this.listSubnetsPagedCallable =
        callableFactory.createPagedCallable(
            listSubnetsTransportSettings, settings.listSubnetsSettings(), clientContext);
    this.getSubnetCallable =
        callableFactory.createUnaryCallable(
            getSubnetTransportSettings, settings.getSubnetSettings(), clientContext);
    this.updateSubnetCallable =
        callableFactory.createUnaryCallable(
            updateSubnetTransportSettings, settings.updateSubnetSettings(), clientContext);
    this.updateSubnetOperationCallable =
        callableFactory.createOperationCallable(
            updateSubnetTransportSettings,
            settings.updateSubnetOperationSettings(),
            clientContext,
            operationsStub);
    this.listExternalAccessRulesCallable =
        callableFactory.createUnaryCallable(
            listExternalAccessRulesTransportSettings,
            settings.listExternalAccessRulesSettings(),
            clientContext);
    this.listExternalAccessRulesPagedCallable =
        callableFactory.createPagedCallable(
            listExternalAccessRulesTransportSettings,
            settings.listExternalAccessRulesSettings(),
            clientContext);
    this.getExternalAccessRuleCallable =
        callableFactory.createUnaryCallable(
            getExternalAccessRuleTransportSettings,
            settings.getExternalAccessRuleSettings(),
            clientContext);
    this.createExternalAccessRuleCallable =
        callableFactory.createUnaryCallable(
            createExternalAccessRuleTransportSettings,
            settings.createExternalAccessRuleSettings(),
            clientContext);
    this.createExternalAccessRuleOperationCallable =
        callableFactory.createOperationCallable(
            createExternalAccessRuleTransportSettings,
            settings.createExternalAccessRuleOperationSettings(),
            clientContext,
            operationsStub);
    this.updateExternalAccessRuleCallable =
        callableFactory.createUnaryCallable(
            updateExternalAccessRuleTransportSettings,
            settings.updateExternalAccessRuleSettings(),
            clientContext);
    this.updateExternalAccessRuleOperationCallable =
        callableFactory.createOperationCallable(
            updateExternalAccessRuleTransportSettings,
            settings.updateExternalAccessRuleOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteExternalAccessRuleCallable =
        callableFactory.createUnaryCallable(
            deleteExternalAccessRuleTransportSettings,
            settings.deleteExternalAccessRuleSettings(),
            clientContext);
    this.deleteExternalAccessRuleOperationCallable =
        callableFactory.createOperationCallable(
            deleteExternalAccessRuleTransportSettings,
            settings.deleteExternalAccessRuleOperationSettings(),
            clientContext,
            operationsStub);
    this.listLoggingServersCallable =
        callableFactory.createUnaryCallable(
            listLoggingServersTransportSettings,
            settings.listLoggingServersSettings(),
            clientContext);
    this.listLoggingServersPagedCallable =
        callableFactory.createPagedCallable(
            listLoggingServersTransportSettings,
            settings.listLoggingServersSettings(),
            clientContext);
    this.getLoggingServerCallable =
        callableFactory.createUnaryCallable(
            getLoggingServerTransportSettings, settings.getLoggingServerSettings(), clientContext);
    this.createLoggingServerCallable =
        callableFactory.createUnaryCallable(
            createLoggingServerTransportSettings,
            settings.createLoggingServerSettings(),
            clientContext);
    this.createLoggingServerOperationCallable =
        callableFactory.createOperationCallable(
            createLoggingServerTransportSettings,
            settings.createLoggingServerOperationSettings(),
            clientContext,
            operationsStub);
    this.updateLoggingServerCallable =
        callableFactory.createUnaryCallable(
            updateLoggingServerTransportSettings,
            settings.updateLoggingServerSettings(),
            clientContext);
    this.updateLoggingServerOperationCallable =
        callableFactory.createOperationCallable(
            updateLoggingServerTransportSettings,
            settings.updateLoggingServerOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteLoggingServerCallable =
        callableFactory.createUnaryCallable(
            deleteLoggingServerTransportSettings,
            settings.deleteLoggingServerSettings(),
            clientContext);
    this.deleteLoggingServerOperationCallable =
        callableFactory.createOperationCallable(
            deleteLoggingServerTransportSettings,
            settings.deleteLoggingServerOperationSettings(),
            clientContext,
            operationsStub);
    this.listNodeTypesCallable =
        callableFactory.createUnaryCallable(
            listNodeTypesTransportSettings, settings.listNodeTypesSettings(), clientContext);
    this.listNodeTypesPagedCallable =
        callableFactory.createPagedCallable(
            listNodeTypesTransportSettings, settings.listNodeTypesSettings(), clientContext);
    this.getNodeTypeCallable =
        callableFactory.createUnaryCallable(
            getNodeTypeTransportSettings, settings.getNodeTypeSettings(), clientContext);
    this.showNsxCredentialsCallable =
        callableFactory.createUnaryCallable(
            showNsxCredentialsTransportSettings,
            settings.showNsxCredentialsSettings(),
            clientContext);
    this.showVcenterCredentialsCallable =
        callableFactory.createUnaryCallable(
            showVcenterCredentialsTransportSettings,
            settings.showVcenterCredentialsSettings(),
            clientContext);
    this.resetNsxCredentialsCallable =
        callableFactory.createUnaryCallable(
            resetNsxCredentialsTransportSettings,
            settings.resetNsxCredentialsSettings(),
            clientContext);
    this.resetNsxCredentialsOperationCallable =
        callableFactory.createOperationCallable(
            resetNsxCredentialsTransportSettings,
            settings.resetNsxCredentialsOperationSettings(),
            clientContext,
            operationsStub);
    this.resetVcenterCredentialsCallable =
        callableFactory.createUnaryCallable(
            resetVcenterCredentialsTransportSettings,
            settings.resetVcenterCredentialsSettings(),
            clientContext);
    this.resetVcenterCredentialsOperationCallable =
        callableFactory.createOperationCallable(
            resetVcenterCredentialsTransportSettings,
            settings.resetVcenterCredentialsOperationSettings(),
            clientContext,
            operationsStub);
    this.getDnsForwardingCallable =
        callableFactory.createUnaryCallable(
            getDnsForwardingTransportSettings, settings.getDnsForwardingSettings(), clientContext);
    this.updateDnsForwardingCallable =
        callableFactory.createUnaryCallable(
            updateDnsForwardingTransportSettings,
            settings.updateDnsForwardingSettings(),
            clientContext);
    this.updateDnsForwardingOperationCallable =
        callableFactory.createOperationCallable(
            updateDnsForwardingTransportSettings,
            settings.updateDnsForwardingOperationSettings(),
            clientContext,
            operationsStub);
    this.getNetworkPeeringCallable =
        callableFactory.createUnaryCallable(
            getNetworkPeeringTransportSettings,
            settings.getNetworkPeeringSettings(),
            clientContext);
    this.listNetworkPeeringsCallable =
        callableFactory.createUnaryCallable(
            listNetworkPeeringsTransportSettings,
            settings.listNetworkPeeringsSettings(),
            clientContext);
    this.listNetworkPeeringsPagedCallable =
        callableFactory.createPagedCallable(
            listNetworkPeeringsTransportSettings,
            settings.listNetworkPeeringsSettings(),
            clientContext);
    this.createNetworkPeeringCallable =
        callableFactory.createUnaryCallable(
            createNetworkPeeringTransportSettings,
            settings.createNetworkPeeringSettings(),
            clientContext);
    this.createNetworkPeeringOperationCallable =
        callableFactory.createOperationCallable(
            createNetworkPeeringTransportSettings,
            settings.createNetworkPeeringOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteNetworkPeeringCallable =
        callableFactory.createUnaryCallable(
            deleteNetworkPeeringTransportSettings,
            settings.deleteNetworkPeeringSettings(),
            clientContext);
    this.deleteNetworkPeeringOperationCallable =
        callableFactory.createOperationCallable(
            deleteNetworkPeeringTransportSettings,
            settings.deleteNetworkPeeringOperationSettings(),
            clientContext,
            operationsStub);
    this.updateNetworkPeeringCallable =
        callableFactory.createUnaryCallable(
            updateNetworkPeeringTransportSettings,
            settings.updateNetworkPeeringSettings(),
            clientContext);
    this.updateNetworkPeeringOperationCallable =
        callableFactory.createOperationCallable(
            updateNetworkPeeringTransportSettings,
            settings.updateNetworkPeeringOperationSettings(),
            clientContext,
            operationsStub);
    this.listPeeringRoutesCallable =
        callableFactory.createUnaryCallable(
            listPeeringRoutesTransportSettings,
            settings.listPeeringRoutesSettings(),
            clientContext);
    this.listPeeringRoutesPagedCallable =
        callableFactory.createPagedCallable(
            listPeeringRoutesTransportSettings,
            settings.listPeeringRoutesSettings(),
            clientContext);
    this.createHcxActivationKeyCallable =
        callableFactory.createUnaryCallable(
            createHcxActivationKeyTransportSettings,
            settings.createHcxActivationKeySettings(),
            clientContext);
    this.createHcxActivationKeyOperationCallable =
        callableFactory.createOperationCallable(
            createHcxActivationKeyTransportSettings,
            settings.createHcxActivationKeyOperationSettings(),
            clientContext,
            operationsStub);
    this.listHcxActivationKeysCallable =
        callableFactory.createUnaryCallable(
            listHcxActivationKeysTransportSettings,
            settings.listHcxActivationKeysSettings(),
            clientContext);
    this.listHcxActivationKeysPagedCallable =
        callableFactory.createPagedCallable(
            listHcxActivationKeysTransportSettings,
            settings.listHcxActivationKeysSettings(),
            clientContext);
    this.getHcxActivationKeyCallable =
        callableFactory.createUnaryCallable(
            getHcxActivationKeyTransportSettings,
            settings.getHcxActivationKeySettings(),
            clientContext);
    this.getNetworkPolicyCallable =
        callableFactory.createUnaryCallable(
            getNetworkPolicyTransportSettings, settings.getNetworkPolicySettings(), clientContext);
    this.listNetworkPoliciesCallable =
        callableFactory.createUnaryCallable(
            listNetworkPoliciesTransportSettings,
            settings.listNetworkPoliciesSettings(),
            clientContext);
    this.listNetworkPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listNetworkPoliciesTransportSettings,
            settings.listNetworkPoliciesSettings(),
            clientContext);
    this.createNetworkPolicyCallable =
        callableFactory.createUnaryCallable(
            createNetworkPolicyTransportSettings,
            settings.createNetworkPolicySettings(),
            clientContext);
    this.createNetworkPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createNetworkPolicyTransportSettings,
            settings.createNetworkPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateNetworkPolicyCallable =
        callableFactory.createUnaryCallable(
            updateNetworkPolicyTransportSettings,
            settings.updateNetworkPolicySettings(),
            clientContext);
    this.updateNetworkPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateNetworkPolicyTransportSettings,
            settings.updateNetworkPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteNetworkPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteNetworkPolicyTransportSettings,
            settings.deleteNetworkPolicySettings(),
            clientContext);
    this.deleteNetworkPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteNetworkPolicyTransportSettings,
            settings.deleteNetworkPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.listManagementDnsZoneBindingsCallable =
        callableFactory.createUnaryCallable(
            listManagementDnsZoneBindingsTransportSettings,
            settings.listManagementDnsZoneBindingsSettings(),
            clientContext);
    this.listManagementDnsZoneBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listManagementDnsZoneBindingsTransportSettings,
            settings.listManagementDnsZoneBindingsSettings(),
            clientContext);
    this.getManagementDnsZoneBindingCallable =
        callableFactory.createUnaryCallable(
            getManagementDnsZoneBindingTransportSettings,
            settings.getManagementDnsZoneBindingSettings(),
            clientContext);
    this.createManagementDnsZoneBindingCallable =
        callableFactory.createUnaryCallable(
            createManagementDnsZoneBindingTransportSettings,
            settings.createManagementDnsZoneBindingSettings(),
            clientContext);
    this.createManagementDnsZoneBindingOperationCallable =
        callableFactory.createOperationCallable(
            createManagementDnsZoneBindingTransportSettings,
            settings.createManagementDnsZoneBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.updateManagementDnsZoneBindingCallable =
        callableFactory.createUnaryCallable(
            updateManagementDnsZoneBindingTransportSettings,
            settings.updateManagementDnsZoneBindingSettings(),
            clientContext);
    this.updateManagementDnsZoneBindingOperationCallable =
        callableFactory.createOperationCallable(
            updateManagementDnsZoneBindingTransportSettings,
            settings.updateManagementDnsZoneBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteManagementDnsZoneBindingCallable =
        callableFactory.createUnaryCallable(
            deleteManagementDnsZoneBindingTransportSettings,
            settings.deleteManagementDnsZoneBindingSettings(),
            clientContext);
    this.deleteManagementDnsZoneBindingOperationCallable =
        callableFactory.createOperationCallable(
            deleteManagementDnsZoneBindingTransportSettings,
            settings.deleteManagementDnsZoneBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.repairManagementDnsZoneBindingCallable =
        callableFactory.createUnaryCallable(
            repairManagementDnsZoneBindingTransportSettings,
            settings.repairManagementDnsZoneBindingSettings(),
            clientContext);
    this.repairManagementDnsZoneBindingOperationCallable =
        callableFactory.createOperationCallable(
            repairManagementDnsZoneBindingTransportSettings,
            settings.repairManagementDnsZoneBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.createVmwareEngineNetworkCallable =
        callableFactory.createUnaryCallable(
            createVmwareEngineNetworkTransportSettings,
            settings.createVmwareEngineNetworkSettings(),
            clientContext);
    this.createVmwareEngineNetworkOperationCallable =
        callableFactory.createOperationCallable(
            createVmwareEngineNetworkTransportSettings,
            settings.createVmwareEngineNetworkOperationSettings(),
            clientContext,
            operationsStub);
    this.updateVmwareEngineNetworkCallable =
        callableFactory.createUnaryCallable(
            updateVmwareEngineNetworkTransportSettings,
            settings.updateVmwareEngineNetworkSettings(),
            clientContext);
    this.updateVmwareEngineNetworkOperationCallable =
        callableFactory.createOperationCallable(
            updateVmwareEngineNetworkTransportSettings,
            settings.updateVmwareEngineNetworkOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteVmwareEngineNetworkCallable =
        callableFactory.createUnaryCallable(
            deleteVmwareEngineNetworkTransportSettings,
            settings.deleteVmwareEngineNetworkSettings(),
            clientContext);
    this.deleteVmwareEngineNetworkOperationCallable =
        callableFactory.createOperationCallable(
            deleteVmwareEngineNetworkTransportSettings,
            settings.deleteVmwareEngineNetworkOperationSettings(),
            clientContext,
            operationsStub);
    this.getVmwareEngineNetworkCallable =
        callableFactory.createUnaryCallable(
            getVmwareEngineNetworkTransportSettings,
            settings.getVmwareEngineNetworkSettings(),
            clientContext);
    this.listVmwareEngineNetworksCallable =
        callableFactory.createUnaryCallable(
            listVmwareEngineNetworksTransportSettings,
            settings.listVmwareEngineNetworksSettings(),
            clientContext);
    this.listVmwareEngineNetworksPagedCallable =
        callableFactory.createPagedCallable(
            listVmwareEngineNetworksTransportSettings,
            settings.listVmwareEngineNetworksSettings(),
            clientContext);
    this.createPrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            createPrivateConnectionTransportSettings,
            settings.createPrivateConnectionSettings(),
            clientContext);
    this.createPrivateConnectionOperationCallable =
        callableFactory.createOperationCallable(
            createPrivateConnectionTransportSettings,
            settings.createPrivateConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.getPrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            getPrivateConnectionTransportSettings,
            settings.getPrivateConnectionSettings(),
            clientContext);
    this.listPrivateConnectionsCallable =
        callableFactory.createUnaryCallable(
            listPrivateConnectionsTransportSettings,
            settings.listPrivateConnectionsSettings(),
            clientContext);
    this.listPrivateConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listPrivateConnectionsTransportSettings,
            settings.listPrivateConnectionsSettings(),
            clientContext);
    this.updatePrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            updatePrivateConnectionTransportSettings,
            settings.updatePrivateConnectionSettings(),
            clientContext);
    this.updatePrivateConnectionOperationCallable =
        callableFactory.createOperationCallable(
            updatePrivateConnectionTransportSettings,
            settings.updatePrivateConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.deletePrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            deletePrivateConnectionTransportSettings,
            settings.deletePrivateConnectionSettings(),
            clientContext);
    this.deletePrivateConnectionOperationCallable =
        callableFactory.createOperationCallable(
            deletePrivateConnectionTransportSettings,
            settings.deletePrivateConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.listPrivateConnectionPeeringRoutesCallable =
        callableFactory.createUnaryCallable(
            listPrivateConnectionPeeringRoutesTransportSettings,
            settings.listPrivateConnectionPeeringRoutesSettings(),
            clientContext);
    this.listPrivateConnectionPeeringRoutesPagedCallable =
        callableFactory.createPagedCallable(
            listPrivateConnectionPeeringRoutesTransportSettings,
            settings.listPrivateConnectionPeeringRoutesSettings(),
            clientContext);
    this.grantDnsBindPermissionCallable =
        callableFactory.createUnaryCallable(
            grantDnsBindPermissionTransportSettings,
            settings.grantDnsBindPermissionSettings(),
            clientContext);
    this.grantDnsBindPermissionOperationCallable =
        callableFactory.createOperationCallable(
            grantDnsBindPermissionTransportSettings,
            settings.grantDnsBindPermissionOperationSettings(),
            clientContext,
            operationsStub);
    this.getDnsBindPermissionCallable =
        callableFactory.createUnaryCallable(
            getDnsBindPermissionTransportSettings,
            settings.getDnsBindPermissionSettings(),
            clientContext);
    this.revokeDnsBindPermissionCallable =
        callableFactory.createUnaryCallable(
            revokeDnsBindPermissionTransportSettings,
            settings.revokeDnsBindPermissionSettings(),
            clientContext);
    this.revokeDnsBindPermissionOperationCallable =
        callableFactory.createOperationCallable(
            revokeDnsBindPermissionTransportSettings,
            settings.revokeDnsBindPermissionOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsResponse>
      listPrivateCloudsCallable() {
    return listPrivateCloudsCallable;
  }

  @Override
  public UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsPagedResponse>
      listPrivateCloudsPagedCallable() {
    return listPrivateCloudsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudCallable() {
    return getPrivateCloudCallable;
  }

  @Override
  public UnaryCallable<CreatePrivateCloudRequest, Operation> createPrivateCloudCallable() {
    return createPrivateCloudCallable;
  }

  @Override
  public OperationCallable<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      createPrivateCloudOperationCallable() {
    return createPrivateCloudOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePrivateCloudRequest, Operation> updatePrivateCloudCallable() {
    return updatePrivateCloudCallable;
  }

  @Override
  public OperationCallable<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      updatePrivateCloudOperationCallable() {
    return updatePrivateCloudOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePrivateCloudRequest, Operation> deletePrivateCloudCallable() {
    return deletePrivateCloudCallable;
  }

  @Override
  public OperationCallable<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      deletePrivateCloudOperationCallable() {
    return deletePrivateCloudOperationCallable;
  }

  @Override
  public UnaryCallable<UndeletePrivateCloudRequest, Operation> undeletePrivateCloudCallable() {
    return undeletePrivateCloudCallable;
  }

  @Override
  public OperationCallable<UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      undeletePrivateCloudOperationCallable() {
    return undeletePrivateCloudOperationCallable;
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
  public UnaryCallable<ListExternalAddressesRequest, ListExternalAddressesResponse>
      listExternalAddressesCallable() {
    return listExternalAddressesCallable;
  }

  @Override
  public UnaryCallable<ListExternalAddressesRequest, ListExternalAddressesPagedResponse>
      listExternalAddressesPagedCallable() {
    return listExternalAddressesPagedCallable;
  }

  @Override
  public UnaryCallable<
          FetchNetworkPolicyExternalAddressesRequest, FetchNetworkPolicyExternalAddressesResponse>
      fetchNetworkPolicyExternalAddressesCallable() {
    return fetchNetworkPolicyExternalAddressesCallable;
  }

  @Override
  public UnaryCallable<
          FetchNetworkPolicyExternalAddressesRequest,
          FetchNetworkPolicyExternalAddressesPagedResponse>
      fetchNetworkPolicyExternalAddressesPagedCallable() {
    return fetchNetworkPolicyExternalAddressesPagedCallable;
  }

  @Override
  public UnaryCallable<GetExternalAddressRequest, ExternalAddress> getExternalAddressCallable() {
    return getExternalAddressCallable;
  }

  @Override
  public UnaryCallable<CreateExternalAddressRequest, Operation> createExternalAddressCallable() {
    return createExternalAddressCallable;
  }

  @Override
  public OperationCallable<CreateExternalAddressRequest, ExternalAddress, OperationMetadata>
      createExternalAddressOperationCallable() {
    return createExternalAddressOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateExternalAddressRequest, Operation> updateExternalAddressCallable() {
    return updateExternalAddressCallable;
  }

  @Override
  public OperationCallable<UpdateExternalAddressRequest, ExternalAddress, OperationMetadata>
      updateExternalAddressOperationCallable() {
    return updateExternalAddressOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteExternalAddressRequest, Operation> deleteExternalAddressCallable() {
    return deleteExternalAddressCallable;
  }

  @Override
  public OperationCallable<DeleteExternalAddressRequest, Empty, OperationMetadata>
      deleteExternalAddressOperationCallable() {
    return deleteExternalAddressOperationCallable;
  }

  @Override
  public UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable() {
    return listSubnetsCallable;
  }

  @Override
  public UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse> listSubnetsPagedCallable() {
    return listSubnetsPagedCallable;
  }

  @Override
  public UnaryCallable<GetSubnetRequest, Subnet> getSubnetCallable() {
    return getSubnetCallable;
  }

  @Override
  public UnaryCallable<UpdateSubnetRequest, Operation> updateSubnetCallable() {
    return updateSubnetCallable;
  }

  @Override
  public OperationCallable<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationCallable() {
    return updateSubnetOperationCallable;
  }

  @Override
  public UnaryCallable<ListExternalAccessRulesRequest, ListExternalAccessRulesResponse>
      listExternalAccessRulesCallable() {
    return listExternalAccessRulesCallable;
  }

  @Override
  public UnaryCallable<ListExternalAccessRulesRequest, ListExternalAccessRulesPagedResponse>
      listExternalAccessRulesPagedCallable() {
    return listExternalAccessRulesPagedCallable;
  }

  @Override
  public UnaryCallable<GetExternalAccessRuleRequest, ExternalAccessRule>
      getExternalAccessRuleCallable() {
    return getExternalAccessRuleCallable;
  }

  @Override
  public UnaryCallable<CreateExternalAccessRuleRequest, Operation>
      createExternalAccessRuleCallable() {
    return createExternalAccessRuleCallable;
  }

  @Override
  public OperationCallable<CreateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      createExternalAccessRuleOperationCallable() {
    return createExternalAccessRuleOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateExternalAccessRuleRequest, Operation>
      updateExternalAccessRuleCallable() {
    return updateExternalAccessRuleCallable;
  }

  @Override
  public OperationCallable<UpdateExternalAccessRuleRequest, ExternalAccessRule, OperationMetadata>
      updateExternalAccessRuleOperationCallable() {
    return updateExternalAccessRuleOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteExternalAccessRuleRequest, Operation>
      deleteExternalAccessRuleCallable() {
    return deleteExternalAccessRuleCallable;
  }

  @Override
  public OperationCallable<DeleteExternalAccessRuleRequest, Empty, OperationMetadata>
      deleteExternalAccessRuleOperationCallable() {
    return deleteExternalAccessRuleOperationCallable;
  }

  @Override
  public UnaryCallable<ListLoggingServersRequest, ListLoggingServersResponse>
      listLoggingServersCallable() {
    return listLoggingServersCallable;
  }

  @Override
  public UnaryCallable<ListLoggingServersRequest, ListLoggingServersPagedResponse>
      listLoggingServersPagedCallable() {
    return listLoggingServersPagedCallable;
  }

  @Override
  public UnaryCallable<GetLoggingServerRequest, LoggingServer> getLoggingServerCallable() {
    return getLoggingServerCallable;
  }

  @Override
  public UnaryCallable<CreateLoggingServerRequest, Operation> createLoggingServerCallable() {
    return createLoggingServerCallable;
  }

  @Override
  public OperationCallable<CreateLoggingServerRequest, LoggingServer, OperationMetadata>
      createLoggingServerOperationCallable() {
    return createLoggingServerOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateLoggingServerRequest, Operation> updateLoggingServerCallable() {
    return updateLoggingServerCallable;
  }

  @Override
  public OperationCallable<UpdateLoggingServerRequest, LoggingServer, OperationMetadata>
      updateLoggingServerOperationCallable() {
    return updateLoggingServerOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteLoggingServerRequest, Operation> deleteLoggingServerCallable() {
    return deleteLoggingServerCallable;
  }

  @Override
  public OperationCallable<DeleteLoggingServerRequest, Empty, OperationMetadata>
      deleteLoggingServerOperationCallable() {
    return deleteLoggingServerOperationCallable;
  }

  @Override
  public UnaryCallable<ListNodeTypesRequest, ListNodeTypesResponse> listNodeTypesCallable() {
    return listNodeTypesCallable;
  }

  @Override
  public UnaryCallable<ListNodeTypesRequest, ListNodeTypesPagedResponse>
      listNodeTypesPagedCallable() {
    return listNodeTypesPagedCallable;
  }

  @Override
  public UnaryCallable<GetNodeTypeRequest, NodeType> getNodeTypeCallable() {
    return getNodeTypeCallable;
  }

  @Override
  public UnaryCallable<ShowNsxCredentialsRequest, Credentials> showNsxCredentialsCallable() {
    return showNsxCredentialsCallable;
  }

  @Override
  public UnaryCallable<ShowVcenterCredentialsRequest, Credentials>
      showVcenterCredentialsCallable() {
    return showVcenterCredentialsCallable;
  }

  @Override
  public UnaryCallable<ResetNsxCredentialsRequest, Operation> resetNsxCredentialsCallable() {
    return resetNsxCredentialsCallable;
  }

  @Override
  public OperationCallable<ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
      resetNsxCredentialsOperationCallable() {
    return resetNsxCredentialsOperationCallable;
  }

  @Override
  public UnaryCallable<ResetVcenterCredentialsRequest, Operation>
      resetVcenterCredentialsCallable() {
    return resetVcenterCredentialsCallable;
  }

  @Override
  public OperationCallable<ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
      resetVcenterCredentialsOperationCallable() {
    return resetVcenterCredentialsOperationCallable;
  }

  @Override
  public UnaryCallable<GetDnsForwardingRequest, DnsForwarding> getDnsForwardingCallable() {
    return getDnsForwardingCallable;
  }

  @Override
  public UnaryCallable<UpdateDnsForwardingRequest, Operation> updateDnsForwardingCallable() {
    return updateDnsForwardingCallable;
  }

  @Override
  public OperationCallable<UpdateDnsForwardingRequest, DnsForwarding, OperationMetadata>
      updateDnsForwardingOperationCallable() {
    return updateDnsForwardingOperationCallable;
  }

  @Override
  public UnaryCallable<GetNetworkPeeringRequest, NetworkPeering> getNetworkPeeringCallable() {
    return getNetworkPeeringCallable;
  }

  @Override
  public UnaryCallable<ListNetworkPeeringsRequest, ListNetworkPeeringsResponse>
      listNetworkPeeringsCallable() {
    return listNetworkPeeringsCallable;
  }

  @Override
  public UnaryCallable<ListNetworkPeeringsRequest, ListNetworkPeeringsPagedResponse>
      listNetworkPeeringsPagedCallable() {
    return listNetworkPeeringsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateNetworkPeeringRequest, Operation> createNetworkPeeringCallable() {
    return createNetworkPeeringCallable;
  }

  @Override
  public OperationCallable<CreateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      createNetworkPeeringOperationCallable() {
    return createNetworkPeeringOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteNetworkPeeringRequest, Operation> deleteNetworkPeeringCallable() {
    return deleteNetworkPeeringCallable;
  }

  @Override
  public OperationCallable<DeleteNetworkPeeringRequest, Empty, OperationMetadata>
      deleteNetworkPeeringOperationCallable() {
    return deleteNetworkPeeringOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateNetworkPeeringRequest, Operation> updateNetworkPeeringCallable() {
    return updateNetworkPeeringCallable;
  }

  @Override
  public OperationCallable<UpdateNetworkPeeringRequest, NetworkPeering, OperationMetadata>
      updateNetworkPeeringOperationCallable() {
    return updateNetworkPeeringOperationCallable;
  }

  @Override
  public UnaryCallable<ListPeeringRoutesRequest, ListPeeringRoutesResponse>
      listPeeringRoutesCallable() {
    return listPeeringRoutesCallable;
  }

  @Override
  public UnaryCallable<ListPeeringRoutesRequest, ListPeeringRoutesPagedResponse>
      listPeeringRoutesPagedCallable() {
    return listPeeringRoutesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateHcxActivationKeyRequest, Operation> createHcxActivationKeyCallable() {
    return createHcxActivationKeyCallable;
  }

  @Override
  public OperationCallable<CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
      createHcxActivationKeyOperationCallable() {
    return createHcxActivationKeyOperationCallable;
  }

  @Override
  public UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>
      listHcxActivationKeysCallable() {
    return listHcxActivationKeysCallable;
  }

  @Override
  public UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysPagedResponse>
      listHcxActivationKeysPagedCallable() {
    return listHcxActivationKeysPagedCallable;
  }

  @Override
  public UnaryCallable<GetHcxActivationKeyRequest, HcxActivationKey> getHcxActivationKeyCallable() {
    return getHcxActivationKeyCallable;
  }

  @Override
  public UnaryCallable<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicyCallable() {
    return getNetworkPolicyCallable;
  }

  @Override
  public UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>
      listNetworkPoliciesCallable() {
    return listNetworkPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesPagedResponse>
      listNetworkPoliciesPagedCallable() {
    return listNetworkPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateNetworkPolicyRequest, Operation> createNetworkPolicyCallable() {
    return createNetworkPolicyCallable;
  }

  @Override
  public OperationCallable<CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      createNetworkPolicyOperationCallable() {
    return createNetworkPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateNetworkPolicyRequest, Operation> updateNetworkPolicyCallable() {
    return updateNetworkPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      updateNetworkPolicyOperationCallable() {
    return updateNetworkPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteNetworkPolicyRequest, Operation> deleteNetworkPolicyCallable() {
    return deleteNetworkPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
      deleteNetworkPolicyOperationCallable() {
    return deleteNetworkPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsResponse>
      listManagementDnsZoneBindingsCallable() {
    return listManagementDnsZoneBindingsCallable;
  }

  @Override
  public UnaryCallable<
          ListManagementDnsZoneBindingsRequest, ListManagementDnsZoneBindingsPagedResponse>
      listManagementDnsZoneBindingsPagedCallable() {
    return listManagementDnsZoneBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetManagementDnsZoneBindingRequest, ManagementDnsZoneBinding>
      getManagementDnsZoneBindingCallable() {
    return getManagementDnsZoneBindingCallable;
  }

  @Override
  public UnaryCallable<CreateManagementDnsZoneBindingRequest, Operation>
      createManagementDnsZoneBindingCallable() {
    return createManagementDnsZoneBindingCallable;
  }

  @Override
  public OperationCallable<
          CreateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      createManagementDnsZoneBindingOperationCallable() {
    return createManagementDnsZoneBindingOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateManagementDnsZoneBindingRequest, Operation>
      updateManagementDnsZoneBindingCallable() {
    return updateManagementDnsZoneBindingCallable;
  }

  @Override
  public OperationCallable<
          UpdateManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      updateManagementDnsZoneBindingOperationCallable() {
    return updateManagementDnsZoneBindingOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteManagementDnsZoneBindingRequest, Operation>
      deleteManagementDnsZoneBindingCallable() {
    return deleteManagementDnsZoneBindingCallable;
  }

  @Override
  public OperationCallable<DeleteManagementDnsZoneBindingRequest, Empty, OperationMetadata>
      deleteManagementDnsZoneBindingOperationCallable() {
    return deleteManagementDnsZoneBindingOperationCallable;
  }

  @Override
  public UnaryCallable<RepairManagementDnsZoneBindingRequest, Operation>
      repairManagementDnsZoneBindingCallable() {
    return repairManagementDnsZoneBindingCallable;
  }

  @Override
  public OperationCallable<
          RepairManagementDnsZoneBindingRequest, ManagementDnsZoneBinding, OperationMetadata>
      repairManagementDnsZoneBindingOperationCallable() {
    return repairManagementDnsZoneBindingOperationCallable;
  }

  @Override
  public UnaryCallable<CreateVmwareEngineNetworkRequest, Operation>
      createVmwareEngineNetworkCallable() {
    return createVmwareEngineNetworkCallable;
  }

  @Override
  public OperationCallable<CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkOperationCallable() {
    return createVmwareEngineNetworkOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateVmwareEngineNetworkRequest, Operation>
      updateVmwareEngineNetworkCallable() {
    return updateVmwareEngineNetworkCallable;
  }

  @Override
  public OperationCallable<UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkOperationCallable() {
    return updateVmwareEngineNetworkOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteVmwareEngineNetworkRequest, Operation>
      deleteVmwareEngineNetworkCallable() {
    return deleteVmwareEngineNetworkCallable;
  }

  @Override
  public OperationCallable<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
      deleteVmwareEngineNetworkOperationCallable() {
    return deleteVmwareEngineNetworkOperationCallable;
  }

  @Override
  public UnaryCallable<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
      getVmwareEngineNetworkCallable() {
    return getVmwareEngineNetworkCallable;
  }

  @Override
  public UnaryCallable<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>
      listVmwareEngineNetworksCallable() {
    return listVmwareEngineNetworksCallable;
  }

  @Override
  public UnaryCallable<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksPagedResponse>
      listVmwareEngineNetworksPagedCallable() {
    return listVmwareEngineNetworksPagedCallable;
  }

  @Override
  public UnaryCallable<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionCallable() {
    return createPrivateConnectionCallable;
  }

  @Override
  public OperationCallable<CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationCallable() {
    return createPrivateConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionCallable() {
    return getPrivateConnectionCallable;
  }

  @Override
  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsCallable() {
    return listPrivateConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsPagedCallable() {
    return listPrivateConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdatePrivateConnectionRequest, Operation>
      updatePrivateConnectionCallable() {
    return updatePrivateConnectionCallable;
  }

  @Override
  public OperationCallable<UpdatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      updatePrivateConnectionOperationCallable() {
    return updatePrivateConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionCallable() {
    return deletePrivateConnectionCallable;
  }

  @Override
  public OperationCallable<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationCallable() {
    return deletePrivateConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListPrivateConnectionPeeringRoutesRequest, ListPrivateConnectionPeeringRoutesResponse>
      listPrivateConnectionPeeringRoutesCallable() {
    return listPrivateConnectionPeeringRoutesCallable;
  }

  @Override
  public UnaryCallable<
          ListPrivateConnectionPeeringRoutesRequest,
          ListPrivateConnectionPeeringRoutesPagedResponse>
      listPrivateConnectionPeeringRoutesPagedCallable() {
    return listPrivateConnectionPeeringRoutesPagedCallable;
  }

  @Override
  public UnaryCallable<GrantDnsBindPermissionRequest, Operation> grantDnsBindPermissionCallable() {
    return grantDnsBindPermissionCallable;
  }

  @Override
  public OperationCallable<GrantDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      grantDnsBindPermissionOperationCallable() {
    return grantDnsBindPermissionOperationCallable;
  }

  @Override
  public UnaryCallable<GetDnsBindPermissionRequest, DnsBindPermission>
      getDnsBindPermissionCallable() {
    return getDnsBindPermissionCallable;
  }

  @Override
  public UnaryCallable<RevokeDnsBindPermissionRequest, Operation>
      revokeDnsBindPermissionCallable() {
    return revokeDnsBindPermissionCallable;
  }

  @Override
  public OperationCallable<RevokeDnsBindPermissionRequest, DnsBindPermission, OperationMetadata>
      revokeDnsBindPermissionOperationCallable() {
    return revokeDnsBindPermissionOperationCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
