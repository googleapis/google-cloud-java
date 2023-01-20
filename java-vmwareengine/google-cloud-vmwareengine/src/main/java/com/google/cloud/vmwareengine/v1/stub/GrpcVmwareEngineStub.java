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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
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
import com.google.common.collect.ImmutableMap;
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

  private static final MethodDescriptor<ListSubnetsRequest, ListSubnetsResponse>
      listSubnetsMethodDescriptor =
          MethodDescriptor.<ListSubnetsRequest, ListSubnetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmwareengine.v1.VmwareEngine/ListSubnets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSubnetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSubnetsResponse.getDefaultInstance()))
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
  private final UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable;
  private final UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse>
      listSubnetsPagedCallable;
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
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudTransportSettings =
        GrpcCallSettings.<GetPrivateCloudRequest, PrivateCloud>newBuilder()
            .setMethodDescriptor(getPrivateCloudMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreatePrivateCloudRequest, Operation> createPrivateCloudTransportSettings =
        GrpcCallSettings.<CreatePrivateCloudRequest, Operation>newBuilder()
            .setMethodDescriptor(createPrivateCloudMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdatePrivateCloudRequest, Operation> updatePrivateCloudTransportSettings =
        GrpcCallSettings.<UpdatePrivateCloudRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePrivateCloudMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "private_cloud.name", String.valueOf(request.getPrivateCloud().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeletePrivateCloudRequest, Operation> deletePrivateCloudTransportSettings =
        GrpcCallSettings.<DeletePrivateCloudRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePrivateCloudMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UndeletePrivateCloudRequest, Operation> undeletePrivateCloudTransportSettings =
        GrpcCallSettings.<UndeletePrivateCloudRequest, Operation>newBuilder()
            .setMethodDescriptor(undeletePrivateCloudMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
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
    GrpcCallSettings<ListSubnetsRequest, ListSubnetsResponse> listSubnetsTransportSettings =
        GrpcCallSettings.<ListSubnetsRequest, ListSubnetsResponse>newBuilder()
            .setMethodDescriptor(listSubnetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListNodeTypesRequest, ListNodeTypesResponse> listNodeTypesTransportSettings =
        GrpcCallSettings.<ListNodeTypesRequest, ListNodeTypesResponse>newBuilder()
            .setMethodDescriptor(listNodeTypesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetNodeTypeRequest, NodeType> getNodeTypeTransportSettings =
        GrpcCallSettings.<GetNodeTypeRequest, NodeType>newBuilder()
            .setMethodDescriptor(getNodeTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ShowNsxCredentialsRequest, Credentials> showNsxCredentialsTransportSettings =
        GrpcCallSettings.<ShowNsxCredentialsRequest, Credentials>newBuilder()
            .setMethodDescriptor(showNsxCredentialsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("private_cloud", String.valueOf(request.getPrivateCloud()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ShowVcenterCredentialsRequest, Credentials>
        showVcenterCredentialsTransportSettings =
            GrpcCallSettings.<ShowVcenterCredentialsRequest, Credentials>newBuilder()
                .setMethodDescriptor(showVcenterCredentialsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("private_cloud", String.valueOf(request.getPrivateCloud()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ResetNsxCredentialsRequest, Operation> resetNsxCredentialsTransportSettings =
        GrpcCallSettings.<ResetNsxCredentialsRequest, Operation>newBuilder()
            .setMethodDescriptor(resetNsxCredentialsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("private_cloud", String.valueOf(request.getPrivateCloud()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ResetVcenterCredentialsRequest, Operation>
        resetVcenterCredentialsTransportSettings =
            GrpcCallSettings.<ResetVcenterCredentialsRequest, Operation>newBuilder()
                .setMethodDescriptor(resetVcenterCredentialsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("private_cloud", String.valueOf(request.getPrivateCloud()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateHcxActivationKeyRequest, Operation>
        createHcxActivationKeyTransportSettings =
            GrpcCallSettings.<CreateHcxActivationKeyRequest, Operation>newBuilder()
                .setMethodDescriptor(createHcxActivationKeyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>
        listHcxActivationKeysTransportSettings =
            GrpcCallSettings
                .<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>newBuilder()
                .setMethodDescriptor(listHcxActivationKeysMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetHcxActivationKeyRequest, HcxActivationKey>
        getHcxActivationKeyTransportSettings =
            GrpcCallSettings.<GetHcxActivationKeyRequest, HcxActivationKey>newBuilder()
                .setMethodDescriptor(getHcxActivationKeyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicyTransportSettings =
        GrpcCallSettings.<GetNetworkPolicyRequest, NetworkPolicy>newBuilder()
            .setMethodDescriptor(getNetworkPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>
        listNetworkPoliciesTransportSettings =
            GrpcCallSettings.<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>newBuilder()
                .setMethodDescriptor(listNetworkPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateNetworkPolicyRequest, Operation> createNetworkPolicyTransportSettings =
        GrpcCallSettings.<CreateNetworkPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(createNetworkPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateNetworkPolicyRequest, Operation> updateNetworkPolicyTransportSettings =
        GrpcCallSettings.<UpdateNetworkPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNetworkPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "network_policy.name", String.valueOf(request.getNetworkPolicy().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteNetworkPolicyRequest, Operation> deleteNetworkPolicyTransportSettings =
        GrpcCallSettings.<DeleteNetworkPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNetworkPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateVmwareEngineNetworkRequest, Operation>
        createVmwareEngineNetworkTransportSettings =
            GrpcCallSettings.<CreateVmwareEngineNetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(createVmwareEngineNetworkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateVmwareEngineNetworkRequest, Operation>
        updateVmwareEngineNetworkTransportSettings =
            GrpcCallSettings.<UpdateVmwareEngineNetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(updateVmwareEngineNetworkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "vmware_engine_network.name",
                          String.valueOf(request.getVmwareEngineNetwork().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteVmwareEngineNetworkRequest, Operation>
        deleteVmwareEngineNetworkTransportSettings =
            GrpcCallSettings.<DeleteVmwareEngineNetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteVmwareEngineNetworkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
        getVmwareEngineNetworkTransportSettings =
            GrpcCallSettings.<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>newBuilder()
                .setMethodDescriptor(getVmwareEngineNetworkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>
        listVmwareEngineNetworksTransportSettings =
            GrpcCallSettings
                .<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>newBuilder()
                .setMethodDescriptor(listVmwareEngineNetworksMethodDescriptor)
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
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
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
    this.listSubnetsCallable =
        callableFactory.createUnaryCallable(
            listSubnetsTransportSettings, settings.listSubnetsSettings(), clientContext);
    this.listSubnetsPagedCallable =
        callableFactory.createPagedCallable(
            listSubnetsTransportSettings, settings.listSubnetsSettings(), clientContext);
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
  public UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable() {
    return listSubnetsCallable;
  }

  @Override
  public UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse> listSubnetsPagedCallable() {
    return listSubnetsPagedCallable;
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
